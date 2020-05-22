package com.baidu.ala.recorder;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.View;
import com.baidu.ala.dumixar.Config;
import com.baidu.ala.helper.AlaDataModel;
import com.baidu.ala.helper.AlaLiveBaseInfo;
import com.baidu.ala.helper.AlaLiveDebugInfo;
import com.baidu.ala.helper.AlaLiveRtcConfig;
import com.baidu.ala.helper.AlaLiveStatConfig;
import com.baidu.ala.helper.AlaLiveStreamCmdInfo;
import com.baidu.ala.helper.AlaLiveUtilHelper;
import com.baidu.ala.ndk.AlaAudioFrame;
import com.baidu.ala.ndk.AlaNDKRecorderAdapter;
import com.baidu.ala.ndk.AlaNdkAdapter;
import com.baidu.ala.player.StreamConfig;
import com.baidu.ala.recorder.AlaLiveRecorderConfig;
import com.baidu.ala.recorder.audio.AlaAudioRecorder;
import com.baidu.ala.recorder.video.AlaLiveVideoConfig;
import com.baidu.ala.recorder.video.AlaLiveVideoRecorder;
import com.baidu.ala.recorder.video.IVideoRecorder;
import com.baidu.ala.recorder.video.VideoBeautyType;
import com.baidu.ala.recorder.video.VideoRecorderType;
import com.baidu.ala.recorder.video.camera.ICameraStatusHandler;
import com.baidu.ala.recorder.video.hardware.EncoderOutputStream;
import com.baidu.ala.recorder.video.hardware.HardH264Encoder;
import com.baidu.ala.recorder.video.screen.AlaScreenRecorder;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.stats.BdStatisticsManager;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.NetWorkChangedMessage;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.coremedia.iso.boxes.PerformerBox;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaLiveRecorder implements IFaceUnityOperator, ICameraStatusHandler {
    private static final int ALA_STREAM_CONNECT_SUCC = 1;
    private static final int CHECK_STREAM_INTERVAL = 5000;
    private static final int DEFAULT_REDUCE_DELAY_STRATEGY = 0;
    private static final int HIGH_LEVEL_CPU_CORE = 8;
    private static final float HIGH_LEVEL_FREQ = 2.0f;
    private static final float HIGH_LEVEL_RAM_SIZE = 3.0f;
    private static final String LOG_TAG = "liverecorder";
    private static final int RECORDER_STATE_INIT = 0;
    private static final int RECORDER_STATE_PUSHING = 1;
    private static final int RECORDER_STATE_STOPPED = 2;
    private final int DEBUG_MONITOR_INTERVAL;
    private Activity mActivity;
    private AlaAudioRecorder mAudioRecorder;
    private VideoBeautyType mBeautyType;
    AlaLiveStreamCmdInfo.CmdData mCmdData;
    private int mCurStreamLevel;
    private int mCurrentIncreaseCount;
    private volatile int mCurrentPushState;
    private boolean mEnableRtcACE;
    private EncoderOutputStream.OnEncoderOutput mEncoderOutput;
    private ExecutorService mExecService;
    private final List<RecorderCallback> mExternRecordCallbacks;
    private Runnable mFpsEnhancedRunnable;
    private boolean mGameHardEncode;
    private HardH264Encoder mHardEncorder;
    private volatile boolean mHasAudio;
    private boolean mHasNetwork;
    private boolean mHasSendRtcConnected;
    private volatile boolean mHasVideo;
    private volatile boolean mIsAudioThreadRun;
    private boolean mIsAutoStartFromBack;
    private volatile boolean mIsBackground;
    private volatile boolean mIsDeviceRun;
    private volatile boolean mIsEnableSendData;
    private volatile boolean mIsInterruptByPhone;
    private boolean mIsMirror;
    private volatile boolean mIsMute;
    private volatile boolean mIsNetRequestRestart;
    private boolean mIsRecordStoped;
    private volatile boolean mIsRestarting;
    private volatile boolean mIsSendCmd;
    private int mLastNetState;
    private long mLastSendVideoDataTime;
    private AlaLiveDebugInfo mLiveDebugInfo;
    private Handler mMainHandler;
    private byte[] mMuteBytes;
    private AlaNDKRecorderAdapter mNdkAdapter;
    CustomMessageListener mNetworkChangedListener;
    private AlaLivePKPlayer mPKPlayer;
    private PhoneStateListener mPhoneStateListener;
    private int mPreVideoHeight;
    private int mPreVideoWidth;
    private RecorderCallback mRecordCallback;
    private String mRecordUrl;
    private volatile boolean mResetAudioDev;
    private AlaLiveRtcConfig mRtcConfig;
    private int mRtcStreamStatus;
    private Runnable mRunableSendCmdFlag;
    private int mSendDataErrorCount;
    private SendHandler mSendHandler;
    private HandlerThread mSendThread;
    private AlaLiveBaseInfo mStartBaseInfo;
    private AlaLiveStatConfig mStatConfig;
    private int mStreamMode;
    private AlaLiveVideoConfig mVideoConfig;
    private IVideoRecorder.IVideoDataCallBack mVideoDataCallBack;
    private AlaLiveVideoRecorder mVideoRecorder;
    private VideoRecorderType mVideoRecorderType;
    private Runnable mrtmpResponsedRestartRunnable;

    public AlaLiveRecorder(Context context, AlaLiveVideoConfig alaLiveVideoConfig, VideoRecorderType videoRecorderType) {
        this(context, alaLiveVideoConfig, videoRecorderType, VideoBeautyType.BEAUTY_FACEUNITY);
    }

    public AlaLiveRecorder(Context context, AlaLiveVideoConfig alaLiveVideoConfig, VideoRecorderType videoRecorderType, VideoBeautyType videoBeautyType) {
        this.mCmdData = new AlaLiveStreamCmdInfo.CmdData();
        this.mCurStreamLevel = 1;
        this.DEBUG_MONITOR_INTERVAL = 5;
        this.mGameHardEncode = true;
        this.mSendDataErrorCount = 0;
        this.mLastNetState = 0;
        this.mIsDeviceRun = false;
        this.mHasAudio = false;
        this.mHasVideo = false;
        this.mIsEnableSendData = false;
        this.mIsAudioThreadRun = false;
        this.mCurrentPushState = 0;
        this.mIsBackground = false;
        this.mIsRecordStoped = true;
        this.mIsRestarting = false;
        this.mIsNetRequestRestart = false;
        this.mIsSendCmd = false;
        this.mExecService = Executors.newFixedThreadPool(1);
        this.mLiveDebugInfo = null;
        this.mAudioRecorder = null;
        this.mVideoRecorder = null;
        this.mBeautyType = VideoBeautyType.BEAUTY_FACEUNITY;
        this.mStatConfig = new AlaLiveStatConfig();
        this.mNdkAdapter = null;
        this.mRecordUrl = null;
        this.mPKPlayer = null;
        this.mHasSendRtcConnected = false;
        this.mStreamMode = 1;
        this.mRtcStreamStatus = 0;
        this.mLastSendVideoDataTime = 0L;
        this.mCurrentIncreaseCount = 0;
        this.mIsMirror = false;
        this.mIsMute = false;
        this.mMuteBytes = new byte[2048];
        this.mIsInterruptByPhone = false;
        this.mIsAutoStartFromBack = true;
        this.mHasNetwork = true;
        this.mResetAudioDev = false;
        this.mEnableRtcACE = true;
        this.mPhoneStateListener = new PhoneStateListener() { // from class: com.baidu.ala.recorder.AlaLiveRecorder.1
            @Override // android.telephony.PhoneStateListener
            public void onCallStateChanged(int i, String str) {
                switch (i) {
                    case 0:
                        AlaLiveRecorder.this.mIsInterruptByPhone = false;
                        break;
                    case 1:
                        AlaLiveRecorder.this.mIsInterruptByPhone = true;
                        break;
                    case 2:
                        AlaLiveRecorder.this.mIsInterruptByPhone = true;
                        break;
                }
                super.onCallStateChanged(i, str);
            }
        };
        this.mExternRecordCallbacks = new LinkedList();
        this.mRecordCallback = new RecorderCallback() { // from class: com.baidu.ala.recorder.AlaLiveRecorder.2
            @Override // com.baidu.ala.recorder.RecorderCallback
            public void flashLightSwitched(boolean z) {
                if (!AlaLiveRecorder.this.mExternRecordCallbacks.isEmpty()) {
                    for (RecorderCallback recorderCallback : AlaLiveRecorder.this.mExternRecordCallbacks) {
                        recorderCallback.flashLightSwitched(z);
                    }
                }
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void cameraSwitched(boolean z) {
                if (!AlaLiveRecorder.this.mExternRecordCallbacks.isEmpty()) {
                    for (RecorderCallback recorderCallback : AlaLiveRecorder.this.mExternRecordCallbacks) {
                        recorderCallback.cameraSwitched(z);
                    }
                }
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void streamLostPackageRateReceived(double d) {
                if (!AlaLiveRecorder.this.mExternRecordCallbacks.isEmpty()) {
                    for (RecorderCallback recorderCallback : AlaLiveRecorder.this.mExternRecordCallbacks) {
                        recorderCallback.streamLostPackageRateReceived(d);
                    }
                }
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void streamStateReceived(int i, boolean z, int i2, boolean z2) {
                if (!AlaLiveRecorder.this.mExternRecordCallbacks.isEmpty()) {
                    for (RecorderCallback recorderCallback : AlaLiveRecorder.this.mExternRecordCallbacks) {
                        recorderCallback.streamStateReceived(i, z, i2, z2);
                    }
                }
                AlaLiveRecorder.this.mCurStreamLevel = i2;
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void onVideoCollectionStart(boolean z, int i, int i2) {
                AlaLiveRecorder.this.mPreVideoWidth = i;
                AlaLiveRecorder.this.mPreVideoHeight = i2;
                if (!AlaLiveRecorder.this.mExternRecordCallbacks.isEmpty()) {
                    for (RecorderCallback recorderCallback : AlaLiveRecorder.this.mExternRecordCallbacks) {
                        recorderCallback.onVideoCollectionStart(z, i, i2);
                    }
                }
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void onVideoCollectionStop() {
                if (!AlaLiveRecorder.this.mExternRecordCallbacks.isEmpty()) {
                    for (RecorderCallback recorderCallback : AlaLiveRecorder.this.mExternRecordCallbacks) {
                        recorderCallback.onVideoCollectionStop();
                    }
                }
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void onAudioOpened(boolean z) {
                if (!AlaLiveRecorder.this.mExternRecordCallbacks.isEmpty()) {
                    for (RecorderCallback recorderCallback : AlaLiveRecorder.this.mExternRecordCallbacks) {
                        recorderCallback.onAudioOpened(z);
                    }
                }
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void onDebugInfo(AlaLiveDebugInfo alaLiveDebugInfo) {
                AlaLiveRecorder.this.mLiveDebugInfo.fillWithDebugInfo(alaLiveDebugInfo);
                if (!AlaLiveRecorder.this.mExternRecordCallbacks.isEmpty()) {
                    for (RecorderCallback recorderCallback : AlaLiveRecorder.this.mExternRecordCallbacks) {
                        recorderCallback.onDebugInfo(alaLiveDebugInfo);
                    }
                }
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void onError(int i, String str) {
                if (!AlaLiveRecorder.this.mIsRecordStoped && !AlaLiveRecorder.this.mExternRecordCallbacks.isEmpty()) {
                    for (RecorderCallback recorderCallback : AlaLiveRecorder.this.mExternRecordCallbacks) {
                        recorderCallback.onError(i, str);
                    }
                }
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void onRtcConnected(int i) {
                if (!AlaLiveRecorder.this.mExternRecordCallbacks.isEmpty()) {
                    for (RecorderCallback recorderCallback : AlaLiveRecorder.this.mExternRecordCallbacks) {
                        recorderCallback.onRtcConnected(i);
                    }
                }
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void onPKPlayerFirstFrame() {
                if (!AlaLiveRecorder.this.mExternRecordCallbacks.isEmpty()) {
                    for (RecorderCallback recorderCallback : AlaLiveRecorder.this.mExternRecordCallbacks) {
                        recorderCallback.onPKPlayerFirstFrame();
                    }
                }
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void onFaceUnityEvent(int i, int i2, Object obj) {
                if (!AlaLiveRecorder.this.mExternRecordCallbacks.isEmpty()) {
                    for (RecorderCallback recorderCallback : AlaLiveRecorder.this.mExternRecordCallbacks) {
                        recorderCallback.onFaceUnityEvent(i, i2, obj);
                    }
                }
            }
        };
        this.mVideoDataCallBack = new IVideoRecorder.IVideoDataCallBack() { // from class: com.baidu.ala.recorder.AlaLiveRecorder.3
            @Override // com.baidu.ala.recorder.video.IVideoRecorder.IVideoDataCallBack
            public void onRawVideoFrameReceived(byte[] bArr, int i, int i2, int i3) {
                if (AlaLiveRecorder.this.mIsDeviceRun && !AlaLiveRecorder.this.mIsInterruptByPhone) {
                    if (AlaLiveRecorder.this.mSendHandler != null) {
                        Message obtainMessage = AlaLiveRecorder.this.mSendHandler.obtainMessage();
                        SendDataInfo sendDataInfo = new SendDataInfo();
                        sendDataInfo.data = bArr;
                        sendDataInfo.displayRotate = i2;
                        sendDataInfo.length = i;
                        sendDataInfo.lineSize = i3;
                        obtainMessage.obj = sendDataInfo;
                        obtainMessage.what = 0;
                        if (AlaLiveRecorder.this.mSendHandler != null) {
                            AlaLiveRecorder.this.mSendHandler.sendMessage(obtainMessage);
                            return;
                        }
                        return;
                    }
                    AlaLiveRecorder.this.sendAndEncodeDataReal(bArr, i, i2, i3);
                }
            }

            @Override // com.baidu.ala.recorder.video.IVideoRecorder.IVideoDataCallBack
            public void onEncodeVideoFrameRecived(byte[] bArr, int i, int i2, int i3, long j, long j2) {
                if (AlaLiveRecorder.this.mIsDeviceRun && !AlaLiveRecorder.this.mIsInterruptByPhone && AlaLiveRecorder.this.mNdkAdapter != null && AlaLiveRecorder.this.mNdkAdapter.getNativeObject() != 0) {
                    String str = null;
                    if (AlaLiveRecorder.this.mIsSendCmd) {
                        AlaLiveRecorder.this.fillCmdData();
                        str = AlaLiveStreamCmdInfo.genCmd(AlaLiveRecorder.this.mActivity, AlaLiveRecorder.this.mCmdData);
                        AlaLiveRecorder.this.mIsSendCmd = false;
                    }
                    int sendH264DataNative = AlaLiveRecorder.this.mNdkAdapter.sendH264DataNative(bArr, i2, str, j, j2);
                    if (sendH264DataNative == 0) {
                        AlaLiveRecorder.this.mHasVideo = true;
                        AlaLiveRecorder.this.adjustDynamicBitRate();
                    } else {
                        AlaLiveRecorder.this.mHasVideo = false;
                    }
                    if (AlaLiveRecorder.this.mSendHandler != null) {
                        AlaLiveRecorder.this.mSendHandler.removeCallbacks(AlaLiveRecorder.this.mFpsEnhancedRunnable);
                        AlaLiveRecorder.this.mSendHandler.postDelayed(AlaLiveRecorder.this.mFpsEnhancedRunnable, 5000L);
                    }
                    if (sendH264DataNative != 0) {
                        BdLog.e("onEncodeVideoFrameRecived error. error is " + sendH264DataNative);
                    }
                }
            }

            @Override // com.baidu.ala.recorder.video.IVideoRecorder.IVideoDataCallBack
            public void onError(int i) {
                if (AlaLiveRecorder.this.mLiveDebugInfo != null) {
                    AlaLiveRecorder.this.mLiveDebugInfo.statusCode = i;
                }
            }
        };
        this.mFpsEnhancedRunnable = new Runnable() { // from class: com.baidu.ala.recorder.AlaLiveRecorder.4
            @Override // java.lang.Runnable
            public void run() {
                AlaLiveRecorder.this.mHasVideo = false;
                if (AlaLiveRecorder.this.mSendHandler != null) {
                    AlaLiveRecorder.this.mSendHandler.postDelayed(AlaLiveRecorder.this.mFpsEnhancedRunnable, 5000L);
                }
            }
        };
        this.mRunableSendCmdFlag = new Runnable() { // from class: com.baidu.ala.recorder.AlaLiveRecorder.7
            @Override // java.lang.Runnable
            public void run() {
                AlaLiveRecorder.this.mIsSendCmd = true;
                AlaLiveRecorder.this.runSetSendCmdFlag(false);
            }
        };
        this.mNetworkChangedListener = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.ala.recorder.AlaLiveRecorder.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && AlaLiveRecorder.this.mCurrentPushState == 1 && AlaLiveRecorder.this.mNdkAdapter != null) {
                    if (AlaLiveRecorder.this.mNdkAdapter == null || AlaLiveRecorder.this.mNdkAdapter.getNativeObject() != 0) {
                        NetWorkChangedMessage netWorkChangedMessage = (NetWorkChangedMessage) customResponsedMessage;
                        if (!BdNetTypeUtil.isNetWorkAvailable()) {
                            AlaLiveRecorder.this.mHasNetwork = false;
                            AlaLiveRecorder.this.mIsNetRequestRestart = false;
                            AlaLiveRecorder.this.mNdkAdapter.networkChangedNotifyNative(0);
                        } else if (netWorkChangedMessage.mCurNetState == 1) {
                            AlaLiveRecorder.this.mHasNetwork = true;
                            AlaLiveRecorder.this.mIsNetRequestRestart = true;
                            AlaLiveRecorder.this.mNdkAdapter.networkChangedNotifyNative(1);
                        } else {
                            AlaLiveRecorder.this.mHasNetwork = true;
                            AlaLiveRecorder.this.mIsNetRequestRestart = true;
                            AlaLiveRecorder.this.mNdkAdapter.networkChangedNotifyNative(2);
                        }
                        if (AlaLiveRecorder.this.mLastNetState == 0 && AlaLiveRecorder.this.mHasNetwork && AlaLiveRecorder.this.mCurrentPushState == 1 && !AlaLiveRecorder.this.mResetAudioDev) {
                            AlaLiveRecorder.this.mResetAudioDev = true;
                        }
                        AlaLiveRecorder.this.mLastNetState = BdNetTypeUtil.netType();
                    }
                }
            }
        };
        this.mrtmpResponsedRestartRunnable = new Runnable() { // from class: com.baidu.ala.recorder.AlaLiveRecorder.15
            @Override // java.lang.Runnable
            public void run() {
                if (AlaLiveRecorder.this.mIsDeviceRun && !AlaLiveRecorder.this.mIsRestarting) {
                    AlaLiveRecorder.this.mIsRestarting = true;
                    AlaLiveRecorder.this.mIsNetRequestRestart = false;
                    AlaLiveRecorder.this.mLastSendVideoDataTime = 0L;
                    AlaLiveRecorder.this.mCurrentIncreaseCount = 0;
                    AlaLiveRecorder.this.prepareNative(true);
                    AlaLiveRecorder.this.startAudioCaptureLoop();
                    AlaLiveRecorder.log(BdStatsConstant.StatsType.ERROR, "restart", TiebaInitialize.LogFields.REASON, "streamclose");
                }
                AlaLiveRecorder.this.mIsRestarting = false;
            }
        };
        this.mEncoderOutput = new EncoderOutputStream.OnEncoderOutput() { // from class: com.baidu.ala.recorder.AlaLiveRecorder.16
            @Override // com.baidu.ala.recorder.video.hardware.EncoderOutputStream.OnEncoderOutput
            public void onEncode(byte[] bArr, int i, boolean z, boolean z2, long j) {
                String str = null;
                if (AlaLiveRecorder.this.mIsDeviceRun && !AlaLiveRecorder.this.mIsInterruptByPhone) {
                    if (z) {
                        AlaLiveRecorder.this.mGameHardEncode = false;
                        if (AlaLiveRecorder.this.mHardEncorder != null) {
                            AlaLiveRecorder.this.mHardEncorder.stop();
                            AlaLiveRecorder.this.mHardEncorder.release();
                        }
                        AlaLiveRecorder.this.mHardEncorder = null;
                        return;
                    }
                    long j2 = j / 1000;
                    if (AlaLiveRecorder.this.mIsSendCmd) {
                        AlaLiveRecorder.this.fillCmdData();
                        str = AlaLiveStreamCmdInfo.genCmd(AlaLiveRecorder.this.mActivity, AlaLiveRecorder.this.mCmdData);
                        AlaLiveRecorder.this.mIsSendCmd = false;
                    }
                    int sendH264DataNative = AlaLiveRecorder.this.mNdkAdapter.sendH264DataNative(bArr, i, str, j2, j2);
                    if (sendH264DataNative == 0) {
                        AlaLiveRecorder.this.mHasVideo = true;
                        AlaLiveRecorder.this.adjustDynamicBitRate();
                    } else {
                        AlaLiveRecorder.this.mHasVideo = false;
                    }
                    if (AlaLiveRecorder.this.mSendHandler != null) {
                        AlaLiveRecorder.this.mSendHandler.removeCallbacks(AlaLiveRecorder.this.mFpsEnhancedRunnable);
                        AlaLiveRecorder.this.mSendHandler.postDelayed(AlaLiveRecorder.this.mFpsEnhancedRunnable, 5000L);
                    }
                    if (sendH264DataNative != 0) {
                        BdLog.e("sendH264DataNative error. error is " + sendH264DataNative);
                    }
                }
            }
        };
        AlaLiveUtilHelper.loadPluginLibrary("ala");
        if (context instanceof Activity) {
            this.mActivity = (Activity) context;
            if (alaLiveVideoConfig == null) {
                throw new IllegalArgumentException("video config invalid");
            }
            this.mNdkAdapter = new AlaNDKRecorderAdapter();
            this.mLastNetState = BdNetTypeUtil.netType();
            this.mVideoRecorderType = videoRecorderType;
            this.mVideoConfig = new AlaLiveVideoConfig(alaLiveVideoConfig);
            this.mPreVideoWidth = this.mVideoConfig.getPreviewWidth();
            this.mPreVideoHeight = this.mVideoConfig.getPreviewHeight();
            this.mBeautyType = videoBeautyType;
            if (videoRecorderType != null) {
                this.mVideoRecorder = new AlaLiveVideoRecorder(this.mActivity);
                this.mVideoRecorder.init(videoRecorderType, this.mBeautyType);
                this.mVideoRecorder.setVideoDataCallback(this.mVideoDataCallBack);
                this.mVideoRecorder.setVideoConfig(this.mVideoConfig);
                if (this.mVideoRecorderType == VideoRecorderType.CAMERA) {
                    this.mVideoRecorder.setPreviewFps(this.mVideoConfig.getVideoFPS());
                }
            }
            initDebugInfo();
            MessageManager.getInstance().registerListener(this.mNetworkChangedListener);
            this.mMainHandler = new Handler();
            ((TelephonyManager) TbadkCoreApplication.getInst().getSystemService("phone")).listen(this.mPhoneStateListener, 32);
            if (this.mVideoRecorder.hasBeauty() < 0) {
                this.mSendThread = new HandlerThread("ala_recorder_send_thread");
                this.mSendThread.start();
                this.mSendHandler = new SendHandler(this.mSendThread.getLooper());
            }
            this.mStartBaseInfo = new AlaLiveBaseInfo(AlaLiveUtilHelper.getApkVersionName(context));
            int initRecordNative = this.mNdkAdapter.initRecordNative(this, 1, 0);
            if (initRecordNative != 0) {
                BdLog.e("initRecordNative error. errcode is " + initRecordNative);
            }
            this.mExecService.submit(new Runnable() { // from class: com.baidu.ala.recorder.AlaLiveRecorder.5
                @Override // java.lang.Runnable
                public void run() {
                    Thread.currentThread().setName("rc_exec_service_thread");
                }
            });
            AlaDataModel.getInstance().clear();
            return;
        }
        throw new IllegalArgumentException("context must be Activity");
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraStatusHandler
    public void setVideoConfig(AlaLiveVideoConfig alaLiveVideoConfig) {
        this.mVideoConfig = new AlaLiveVideoConfig(alaLiveVideoConfig);
        if (this.mVideoRecorder != null) {
            this.mVideoRecorder.setVideoConfig(this.mVideoConfig);
        }
    }

    public void setRtcConfig(AlaLiveRtcConfig alaLiveRtcConfig) {
        this.mRtcConfig = new AlaLiveRtcConfig(alaLiveRtcConfig);
    }

    public boolean setDefaultRtcMode() {
        int initVideoEncoderNative;
        int i = this.mStreamMode;
        if (this.mRtcConfig == null || this.mRtcConfig.mPushUrl == null) {
            return false;
        }
        final AlaNDKRecorderAdapter alaNDKRecorderAdapter = new AlaNDKRecorderAdapter();
        alaNDKRecorderAdapter.setNativeObject(this.mNdkAdapter.getNativeObject());
        this.mExecService.submit(new Runnable() { // from class: com.baidu.ala.recorder.AlaLiveRecorder.6
            @Override // java.lang.Runnable
            public void run() {
                int stopNative = alaNDKRecorderAdapter.stopNative();
                if (stopNative != 0) {
                    BdLog.e("stopNative error:" + stopNative);
                }
            }
        });
        int initRecordNative = this.mNdkAdapter.initRecordNative(this, 2, this.mRtcConfig.mReduceDelay);
        if (initRecordNative != 0) {
            BdLog.e("initRecordNative error. errcode is " + initRecordNative);
            this.mStreamMode = i;
            return false;
        }
        if (this.mVideoRecorderType != null) {
            this.mVideoConfig.switchToRtcMode(this.mVideoConfig.getVideoWidth(), this.mVideoConfig.getVideoHeight());
            this.mVideoRecorder.setVideoConfig(this.mVideoConfig);
            this.mVideoRecorder.setPreviewFps(this.mVideoConfig.getVideoFPS());
            if (this.mVideoConfig.getEncoderType() != 1 && (initVideoEncoderNative = this.mNdkAdapter.initVideoEncoderNative(this.mVideoConfig.getVideoWidth(), this.mVideoConfig.getVideoHeight(), this.mVideoConfig.getBitStream(), this.mVideoRecorder.getVideoFormat().getValue(), 1, 10, this.mPreVideoWidth, this.mPreVideoHeight)) != 0) {
                BdLog.e("initAudioEncoderNative error. errcode is " + initVideoEncoderNative);
                this.mStreamMode = i;
                return false;
            }
        }
        if (this.mNdkAdapter.getNativeObject() != 0) {
            int initAudioEncoderNative = this.mNdkAdapter.initAudioEncoderNative(StreamConfig.Audio.AUDIO_RTC_FREQUENCY_48K, 1, 16);
            if (initAudioEncoderNative != 0) {
                BdLog.e("initAudioEncoderNative error. errcode is " + initAudioEncoderNative);
                this.mStreamMode = i;
                return false;
            } else if (this.mEnableRtcACE) {
                this.mNdkAdapter.initAudioReSample(0, StreamConfig.Audio.AUDIO_RTC_FREQUENCY_48K, 1);
            }
        }
        if (this.mNdkAdapter.getNativeObject() != 0) {
            this.mNdkAdapter.initRtcRoomInfoNative(this.mRtcConfig.mRoomId, this.mRtcConfig.mLineIndex, this.mRtcConfig.mUId, this.mRtcConfig.mPushUrl);
            this.mNdkAdapter.setRtcConfig(this.mRtcConfig.mHandshakeTimeout, this.mRtcConfig.mHeartInterval, this.mRtcConfig.mHeartTimeout, this.mRtcConfig.mCloseTimeout);
        }
        this.mStreamMode = 2;
        return true;
    }

    public boolean switchToCommonMode(int i, int i2) {
        if (this.mStreamMode == 1) {
            return true;
        }
        int i3 = this.mStreamMode;
        if (this.mStreamMode == 2) {
            this.mStreamMode = 1;
            this.mVideoRecorder.willSwitchSense(1);
            stopAll(false, false);
            this.mNdkAdapter = new AlaNDKRecorderAdapter();
            int initRecordNative = this.mNdkAdapter.initRecordNative(this, 1, 0);
            if (initRecordNative != 0) {
                BdLog.e("initRecordNative error. errcode is " + initRecordNative);
                this.mStreamMode = i3;
                return false;
            }
            if (this.mVideoRecorderType != null) {
                this.mVideoConfig.switchToNormalMode(i, i2);
                this.mVideoRecorder.setVideoConfig(this.mVideoConfig);
                this.mVideoRecorder.setRecorderCallback(this.mRecordCallback);
                this.mVideoRecorder.setPreviewFps(this.mVideoConfig.getVideoFPS());
            }
            this.mVideoRecorder.startRecord();
            if (this.mNdkAdapter != null && this.mNdkAdapter.getNativeObject() != 0) {
                int initAudioEncoderNative = this.mNdkAdapter.initAudioEncoderNative(44100, 1, 16);
                if (initAudioEncoderNative != 0) {
                    BdLog.e("initAudioEncoderNative error. errcode is " + initAudioEncoderNative);
                    this.mStreamMode = i3;
                    return false;
                } else if (this.mEnableRtcACE) {
                    this.mNdkAdapter.initAudioReSample(0, 44100, 1);
                }
            }
            this.mStartBaseInfo.mPkId = null;
            if (startPushForCommon(this.mRecordUrl) != 0) {
                this.mStreamMode = i3;
                return false;
            }
        }
        this.mHasSendRtcConnected = false;
        this.mRtcStreamStatus = 0;
        return true;
    }

    public boolean switchToRtcMode(int i, int i2) {
        int initVideoEncoderNative;
        if (this.mStreamMode == 2) {
            return true;
        }
        int i3 = this.mStreamMode;
        if (this.mStreamMode == 1) {
            this.mStreamMode = 2;
            if (this.mRtcConfig == null) {
                this.mStreamMode = i3;
                return false;
            }
            this.mVideoRecorder.willSwitchSense(2);
            stopAll(false, false);
            this.mNdkAdapter = new AlaNDKRecorderAdapter();
            int initRecordNative = this.mNdkAdapter.initRecordNative(this, 2, this.mRtcConfig.mReduceDelay);
            if (initRecordNative != 0) {
                BdLog.e("initRecordNative error. errcode is " + initRecordNative);
                this.mStreamMode = i3;
                return false;
            }
            if (this.mNdkAdapter.getNativeObject() != 0) {
                int initAudioEncoderNative = this.mNdkAdapter.initAudioEncoderNative(StreamConfig.Audio.AUDIO_RTC_FREQUENCY_48K, 1, 16);
                if (initAudioEncoderNative != 0) {
                    BdLog.e("initAudioEncoderNative error. errcode is " + initAudioEncoderNative);
                    this.mStreamMode = i3;
                    return false;
                } else if (this.mEnableRtcACE) {
                    this.mNdkAdapter.initAudioReSample(0, StreamConfig.Audio.AUDIO_RTC_FREQUENCY_48K, 1);
                }
            }
            AlaLiveVideoConfig alaLiveVideoConfig = new AlaLiveVideoConfig(this.mVideoConfig);
            if (this.mNdkAdapter.getNativeObject() != 0) {
                if (this.mVideoConfig.getEncoderType() == 1) {
                    initVideoEncoderNative = 0;
                    alaLiveVideoConfig.switchToRtcMode(i, i2);
                    this.mVideoRecorder.setVideoConfig(alaLiveVideoConfig);
                } else {
                    initVideoEncoderNative = this.mNdkAdapter.initVideoEncoderNative(alaLiveVideoConfig.getVideoWidth(), alaLiveVideoConfig.getVideoHeight(), alaLiveVideoConfig.getBitStream(), this.mVideoRecorder.getVideoFormat().getValue(), 1, 10, this.mPreVideoWidth, this.mPreVideoHeight);
                }
                if (initVideoEncoderNative != 0) {
                    BdLog.e("initVideoEncoderNative error. errcode is " + initVideoEncoderNative);
                    this.mStreamMode = i3;
                    return false;
                }
            }
            if (this.mNdkAdapter.getNativeObject() != 0) {
                this.mNdkAdapter.initRtcRoomInfoNative(this.mRtcConfig.mRoomId, this.mRtcConfig.mLineIndex, this.mRtcConfig.mUId, this.mRecordUrl);
                this.mNdkAdapter.setRtcConfig(this.mRtcConfig.mHandshakeTimeout, this.mRtcConfig.mHeartInterval, this.mRtcConfig.mHeartTimeout, this.mRtcConfig.mCloseTimeout);
            }
            this.mIsDeviceRun = true;
            this.mCurrentPushState = 1;
            if (this.mVideoRecorderType != null) {
                if (this.mVideoConfig.getEncoderType() == 1) {
                    this.mVideoRecorder.setVideoConfig(alaLiveVideoConfig);
                } else {
                    this.mVideoRecorder.setVideoConfig(this.mVideoConfig);
                }
                this.mVideoRecorder.setRecorderCallback(this.mRecordCallback);
                this.mVideoRecorder.setPreviewFps(10);
            }
            this.mVideoRecorder.startRecord();
            this.mStartBaseInfo.mPkId = String.format("%d", Long.valueOf(this.mRtcConfig.mRoomId));
            createPKPlayer();
            if (this.mPKPlayer != null) {
                this.mPKPlayer.setEnableRtcACE(this.mEnableRtcACE);
                this.mPKPlayer.startPlay(this.mRtcConfig.getRtcUrl(), 1, this.mStartBaseInfo.toJsonString());
            }
            if (this.mNdkAdapter.getNativeObject() != 0) {
                this.mNdkAdapter.setDebugMonitor(true, 5);
                if (this.mNdkAdapter.startNative(this.mRtcConfig.getRtcUrl(), getNetworkState(), this.mStartBaseInfo.toJsonString()) != 0) {
                    this.mStreamMode = i3;
                    return false;
                }
            }
            startDevices();
        }
        this.mHasSendRtcConnected = false;
        this.mRtcStreamStatus = 0;
        return true;
    }

    public int getRtcStreamStatus() {
        return this.mRtcStreamStatus;
    }

    public AlaLiveVideoConfig getVideoConfig() {
        return this.mVideoConfig;
    }

    public void changeVideoRecorderType(VideoRecorderType videoRecorderType, boolean z) {
        if (this.mVideoRecorderType != null) {
            if (!z || this.mVideoRecorderType.equals(videoRecorderType)) {
                stopVideoRecord();
                this.mVideoRecorder.release();
                this.mVideoRecorderType = videoRecorderType;
                this.mVideoRecorder = new AlaLiveVideoRecorder(this.mActivity);
                this.mVideoRecorder.init(this.mVideoRecorderType, this.mBeautyType);
                this.mVideoRecorder.setVideoConfig(this.mVideoConfig);
                setPushMirror(this.mIsMirror);
                if (this.mVideoRecorderType == VideoRecorderType.SCREEN && this.mGameHardEncode) {
                    if (this.mHardEncorder != null) {
                        this.mHardEncorder.stop();
                        this.mHardEncorder.release();
                    }
                    this.mHardEncorder = new HardH264Encoder(AlaScreenRecorder.getInstance());
                    if (this.mHardEncorder.initMediaParams()) {
                        this.mHardEncorder.setOutput(this.mEncoderOutput);
                        AlaScreenRecorder.getInstance().setHardEncoder(this.mHardEncorder);
                    } else {
                        this.mHardEncorder.stop();
                        this.mHardEncorder = null;
                        this.mGameHardEncode = false;
                    }
                }
                this.mVideoRecorder.setVideoDataCallback(this.mVideoDataCallBack);
                if (videoRecorderType == VideoRecorderType.SCREEN && !this.mIsDeviceRun) {
                    this.mIsBackground = false;
                    if (this.mCurrentPushState == 1) {
                        if (this.mNdkAdapter.getNativeObject() == 0) {
                            int initRecordNative = this.mNdkAdapter.initRecordNative(this, 1, 0);
                            if (initRecordNative != 0) {
                                BdLog.e("initRecordNative error. errcode is " + initRecordNative);
                                return;
                            } else {
                                startPushForCommon(this.mRecordUrl);
                                return;
                            }
                        }
                        startDevices();
                        prepareNative(false);
                    }
                }
            }
        }
    }

    public void changeVideoRecorderType(VideoRecorderType videoRecorderType) {
        changeVideoRecorderType(videoRecorderType, false);
    }

    public VideoRecorderType getVideoRecorderType() {
        return this.mVideoRecorderType;
    }

    public View createPKPlayer() {
        if (this.mPKPlayer == null) {
            this.mPKPlayer = new AlaLivePKPlayer(this.mActivity, this.mNdkAdapter.getNativeObject(), this.mVideoRecorder.getRecorderHandler());
            int initPKPlayer = this.mNdkAdapter.initPKPlayer(this.mPKPlayer);
            if (initPKPlayer != 0) {
                BdLog.e("createPKPlayer -> initPKPlayer error.  " + initPKPlayer);
            }
        }
        return this.mPKPlayer.createPlayer();
    }

    private void registerNativeObject(long j) {
        this.mNdkAdapter.setNativeObject(j);
    }

    private void deRegisterNativeObject() {
        this.mNdkAdapter.setNativeObject(0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fillCmdData() {
        this.mCmdData.mHasAudio = this.mHasAudio;
        this.mCmdData.mHasVideo = this.mHasVideo;
        this.mCmdData.mIsBackground = this.mIsBackground;
        this.mCmdData.mIsDeviceRun = this.mIsDeviceRun;
        this.mCmdData.mGameHardEncode = this.mGameHardEncode;
        this.mCmdData.type = this.mVideoRecorderType;
        this.mCmdData.mCurStreamLevel = this.mCurStreamLevel;
        this.mCmdData.mDebugInfo = this.mLiveDebugInfo;
        this.mCmdData.ip = getPushStreamIp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runSetSendCmdFlag(boolean z) {
        if (this.mMainHandler != null) {
            if (z) {
                this.mMainHandler.removeCallbacks(this.mRunableSendCmdFlag);
            }
            this.mMainHandler.postDelayed(this.mRunableSendCmdFlag, 5000L);
        }
    }

    private void adjustDynamicBitRate4Codec(int i) {
        if (this.mVideoRecorderType != VideoRecorderType.SCREEN) {
            if (this.mVideoConfig.getEncoderType() == 1) {
                this.mVideoRecorder.setVideoConfig(this.mVideoConfig);
            } else if (this.mStreamMode == 2) {
                this.mNdkAdapter.updateVCodeParamNative(this.mVideoConfig.getVideoWidth(), this.mVideoConfig.getVideoHeight(), i, this.mVideoRecorder.getVideoFormat().getValue(), 1, 10, this.mPreVideoWidth, this.mPreVideoHeight);
            } else if (this.mStreamMode == 1) {
                this.mNdkAdapter.updateVCodeParamNative(this.mVideoConfig.isLandscape() ? this.mVideoConfig.getVideoHeight() : this.mVideoConfig.getVideoWidth(), this.mVideoConfig.isLandscape() ? this.mVideoConfig.getVideoWidth() : this.mVideoConfig.getVideoHeight(), i, this.mVideoRecorder.getVideoFormat().getValue(), this.mVideoConfig.getVideoGOP(), this.mVideoConfig.getVideoFPS(), this.mPreVideoWidth, this.mPreVideoHeight);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adjustDynamicBitRate() {
        if (this.mVideoConfig != null && this.mVideoConfig.getCurrentBitRateConfig() != null && this.mVideoRecorder != null && this.mHasNetwork && this.mVideoConfig.getIsSupportDynamicBitrate()) {
            if (this.mLastSendVideoDataTime > 0) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.mLastSendVideoDataTime > 5000) {
                    this.mLastSendVideoDataTime = currentTimeMillis;
                    Integer num = new Integer(0);
                    Integer num2 = new Integer(0);
                    float streamStateNative = this.mNdkAdapter.getStreamStateNative(num, num2);
                    double d = 0.0d;
                    if (num2.intValue() > 0) {
                        d = num.intValue() / num2.intValue();
                    }
                    int outputWidth = this.mVideoRecorder.getOutputWidth();
                    int outputHeight = this.mVideoRecorder.getOutputHeight();
                    if (outputWidth > 0 && outputHeight > 0) {
                        if (streamStateNative > this.mVideoConfig.getCurrentBitRateConfig().getDecreaseThreshold()) {
                            this.mCurrentIncreaseCount = 0;
                            if (this.mVideoConfig.getCurrentBitRateConfig().decrease()) {
                                adjustDynamicBitRate4Codec(this.mVideoConfig.getCurrentBitRateConfig().getCurrentBitRate());
                                int streamLevelPercent = this.mVideoConfig.getCurrentBitRateConfig().getStreamLevelPercent();
                                boolean isFirstLevel = this.mVideoConfig.getCurrentBitRateConfig().isFirstLevel();
                                int currentLevel = this.mVideoConfig.getCurrentBitRateConfig().getCurrentLevel();
                                if (this.mVideoRecorder != null) {
                                    this.mVideoRecorder.sendStreamState(streamLevelPercent, isFirstLevel, currentLevel, false);
                                }
                                log("brchange", Integer.valueOf(currentLevel), "lostRate", Double.valueOf(d));
                            }
                        } else if (streamStateNative < this.mVideoConfig.getCurrentBitRateConfig().getIncreaseThreshold()) {
                            this.mCurrentIncreaseCount++;
                            if (this.mCurrentIncreaseCount >= this.mVideoConfig.getCurrentBitRateConfig().getIncreaseCount()) {
                                this.mCurrentIncreaseCount = 0;
                                if (this.mVideoConfig.getCurrentBitRateConfig().increase()) {
                                    adjustDynamicBitRate4Codec(this.mVideoConfig.getCurrentBitRateConfig().getCurrentBitRate());
                                    int streamLevelPercent2 = this.mVideoConfig.getCurrentBitRateConfig().getStreamLevelPercent();
                                    boolean isFirstLevel2 = this.mVideoConfig.getCurrentBitRateConfig().isFirstLevel();
                                    int currentLevel2 = this.mVideoConfig.getCurrentBitRateConfig().getCurrentLevel();
                                    if (this.mVideoRecorder != null) {
                                        this.mVideoRecorder.sendStreamState(streamLevelPercent2, isFirstLevel2, currentLevel2, true);
                                    }
                                    log("brchange", Integer.valueOf(currentLevel2), "lostRate", Double.valueOf(d));
                                }
                            }
                        } else {
                            this.mCurrentIncreaseCount = 0;
                        }
                        if (num.intValue() > 0 && this.mVideoRecorder != null) {
                            this.mVideoRecorder.sendLostRate(d);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            this.mLastSendVideoDataTime = System.currentTimeMillis();
        }
    }

    public void startRecord() {
        this.mVideoRecorder.startRecord();
        this.mIsRecordStoped = false;
    }

    public void stopRecord() {
        this.mIsRecordStoped = true;
        stopVideoRecord();
    }

    private void stopVideoRecord() {
        if (this.mSendHandler != null) {
            this.mSendHandler.removeCallbacks(this.mFpsEnhancedRunnable);
        }
        this.mVideoRecorder.stopRecord();
    }

    public int startPush(String str) {
        if (this.mStreamMode == 1) {
            return startPushForCommon(str);
        }
        if (this.mStreamMode == 2) {
            return startPushForRtc(str);
        }
        return -1;
    }

    public int getStreamMode() {
        return this.mStreamMode;
    }

    public void setStatConfigBeforeStart(String str, String str2, int i) {
        this.mStatConfig.mEnable = i;
        this.mStatConfig.mSavePath = str;
        this.mStatConfig.mUploadUrl = str2;
    }

    public void setStartInfo(String str, String str2, String str3) {
        this.mStartBaseInfo.mClientIp = str3;
        this.mStartBaseInfo.mLiveId = str;
        this.mStartBaseInfo.mSessionId = str2;
        this.mStartBaseInfo.mNetWork = BdNetTypeUtil.netTypeNameInUpperCase();
    }

    public void setStartInfo(String str, String str2, String str3, String str4) {
        setStartInfo(str, str2, str3);
        this.mStartBaseInfo.mSubAppType = str4;
    }

    public void setConfigBeforeStop(String str, String str2, String str3) {
        if (this.mNdkAdapter != null && this.mNdkAdapter.getNativeObject() != 0) {
            this.mNdkAdapter.sendNativeStatAppData(PerformerBox.TYPE, str, 1);
            this.mNdkAdapter.sendNativeStatAppData("kStatFirstFrame", str2, 1);
            this.mNdkAdapter.sendNativeStatAppData("kStatDelayOff", str3, 1);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("videoWith", this.mVideoConfig.getVideoWidth());
                jSONObject.put("videoHeight", this.mVideoConfig.getVideoHeight());
                jSONObject.put("videoGop", this.mVideoConfig.getVideoGOP() * this.mVideoConfig.getVideoFPS());
                jSONObject.put("videoBFrame", 0);
                this.mNdkAdapter.sendNativeStatAppData("videoInfo", jSONObject.toString(), 1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void setRoomInfo(String str) {
        if (this.mNdkAdapter != null && this.mNdkAdapter.getNativeObject() != 0) {
            this.mNdkAdapter.sendNativeStatAppData("roomInfo", str, 1);
        }
    }

    private int initCodecs() {
        int initVideoEncoderNative;
        if (this.mNdkAdapter != null && this.mNdkAdapter.getNativeObject() != 0) {
            if (this.mVideoConfig.getEncoderType() == 1) {
                initVideoEncoderNative = 0;
            } else {
                initVideoEncoderNative = this.mNdkAdapter.initVideoEncoderNative(this.mVideoConfig.isLandscape() ? this.mVideoConfig.getVideoHeight() : this.mVideoConfig.getVideoWidth(), this.mVideoConfig.isLandscape() ? this.mVideoConfig.getVideoWidth() : this.mVideoConfig.getVideoHeight(), this.mVideoRecorder.getBitRate(), this.mVideoRecorder.getVideoFormat().getValue(), this.mVideoConfig.getVideoGOP(), this.mVideoConfig.getVideoFPS(), this.mPreVideoWidth, this.mPreVideoHeight);
            }
            this.mNdkAdapter.syncStatConfig(this.mStatConfig.mSavePath, this.mStatConfig.mUploadUrl, this.mStatConfig.mEnable);
            this.mNdkAdapter.setDebugMonitor(true, 5);
            if (this.mSendThread != null) {
                this.mSendHandler = new SendHandler(this.mSendThread.getLooper());
            }
            BdLog.d("initVideoEncoderNative " + initVideoEncoderNative);
            if (initVideoEncoderNative != 0) {
                BdLog.e("initVideoEncoderNative error. errcode is " + initVideoEncoderNative);
                stopAll(true, true);
                return initVideoEncoderNative;
            }
            runSetSendCmdFlag(true);
            int initAudioEncoderNative = this.mNdkAdapter.initAudioEncoderNative(44100, 1, 16);
            if (initAudioEncoderNative != 0) {
                BdLog.e("initAudioEncoderNative error. errocde is " + initAudioEncoderNative);
                stopAll(true, true);
                return initAudioEncoderNative;
            }
            return 0;
        }
        BdLog.d("initCodecs mNdkAdapter.getNativeObject() == 0");
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int prepareNative(final boolean z) {
        this.mExecService.submit(new Runnable() { // from class: com.baidu.ala.recorder.AlaLiveRecorder.8
            @Override // java.lang.Runnable
            public void run() {
                int startNative;
                if (!AlaLiveRecorder.this.mExecService.isShutdown()) {
                    if (z) {
                        startNative = AlaLiveRecorder.this.mNdkAdapter.restartNative(AlaLiveRecorder.this.mRecordUrl);
                        if (startNative != 0) {
                            BdLog.e("restartNative error:" + startNative);
                        }
                        AlaLiveRecorder.log(BdStatsConstant.StatsType.ERROR, "restartnative", "errcode", Integer.valueOf(startNative), "curnet", BdNetTypeUtil.netTypeNameInLowerCase(), "puship", AlaLiveRecorder.this.getPushStreamIp());
                    } else {
                        startNative = AlaLiveRecorder.this.mNdkAdapter.startNative(AlaLiveRecorder.this.mRecordUrl, AlaLiveRecorder.this.getNetworkState(), AlaLiveRecorder.this.mStartBaseInfo.toJsonString());
                        if (startNative != 0) {
                            BdLog.e("startNative error:" + startNative);
                        }
                        AlaLiveRecorder.log(BdStatsConstant.StatsType.ERROR, "startnative", "errcode", Integer.valueOf(startNative), "curnet", BdNetTypeUtil.netTypeNameInLowerCase(), "puship", AlaLiveRecorder.this.getPushStreamIp());
                    }
                    if (startNative != 0) {
                    }
                }
            }
        });
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int startAudioCaptureLoop() {
        if (this.mIsAudioThreadRun && this.mIsEnableSendData) {
            BdLog.d("startAudioCaptureLoop mExecService has submit runnable!! ");
        } else {
            boolean useOpenSLES = StreamConfig.useOpenSLES();
            if (this.mStreamMode == 2 && useOpenSLES && this.mEnableRtcACE) {
                this.mExecService.submit(new Runnable() { // from class: com.baidu.ala.recorder.AlaLiveRecorder.9
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AlaLiveRecorder.this.mAudioRecorder != null) {
                            if (!AlaLiveRecorder.this.mExecService.isShutdown()) {
                                AlaLiveRecorder.this.mIsEnableSendData = true;
                                AlaLiveRecorder.this.mIsAudioThreadRun = true;
                                System.currentTimeMillis();
                                boolean z = false;
                                boolean z2 = false;
                                while (true) {
                                    if (!AlaLiveRecorder.this.mIsEnableSendData && !Thread.interrupted() && !AlaLiveRecorder.this.mExecService.isShutdown()) {
                                        break;
                                    } else if (AlaLiveRecorder.this.mAudioRecorder != null) {
                                        if (AlaLiveRecorder.this.mIsInterruptByPhone) {
                                            if (!z2) {
                                                AlaLiveRecorder.this.mAudioRecorder.pause();
                                                z2 = true;
                                            }
                                        } else {
                                            if (z2) {
                                                AlaLiveRecorder.this.mAudioRecorder.resume();
                                                z2 = false;
                                            }
                                            if (AlaLiveRecorder.this.mIsMute) {
                                                if (!z) {
                                                    AlaLiveRecorder.this.mAudioRecorder.mutex(true);
                                                    z = true;
                                                }
                                            } else if (z) {
                                                AlaLiveRecorder.this.mAudioRecorder.mutex(false);
                                                z = false;
                                            }
                                            if (AlaLiveRecorder.this.mResetAudioDev) {
                                                AlaLiveRecorder.this.mResetAudioDev = false;
                                                AlaLiveRecorder.this.startAudioDevice(false);
                                            }
                                            if (System.currentTimeMillis() - AlaLiveRecorder.this.mAudioRecorder.getLastCaptureTimestamp() >= 5000) {
                                                AlaLiveRecorder.this.mHasAudio = false;
                                                System.currentTimeMillis();
                                            } else {
                                                AlaLiveRecorder.this.mHasAudio = true;
                                            }
                                            try {
                                                Thread.sleep(40L);
                                            } catch (InterruptedException e) {
                                                BdLog.e(e);
                                            }
                                        }
                                    } else {
                                        BdLog.e("mAudioRecorder is null, stopAll is called");
                                        break;
                                    }
                                }
                                AlaLiveRecorder.this.mIsAudioThreadRun = false;
                                AlaLiveRecorder.this.stopAudioDevice();
                                return;
                            }
                            BdLog.e("startAudioCaptureLoop has shutdown!");
                            AlaLiveRecorder.this.stopAudioDevice();
                            return;
                        }
                        BdLog.e("mAudioRecorder is null, stopAll is called");
                    }
                });
            } else {
                this.mExecService.submit(new Runnable() { // from class: com.baidu.ala.recorder.AlaLiveRecorder.10
                    /* JADX WARN: Removed duplicated region for block: B:73:0x019e A[SYNTHETIC] */
                    /* JADX WARN: Removed duplicated region for block: B:78:0x010d A[SYNTHETIC] */
                    @Override // java.lang.Runnable
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public void run() {
                        AlaAudioFrame readData;
                        int i;
                        long currentTimeMillis;
                        if (AlaLiveRecorder.this.mAudioRecorder != null) {
                            if (!AlaLiveRecorder.this.mExecService.isShutdown()) {
                                AlaLiveRecorder.this.mIsEnableSendData = true;
                                AlaLiveRecorder.this.mIsAudioThreadRun = true;
                                long currentTimeMillis2 = System.currentTimeMillis();
                                int i2 = 0;
                                while (true) {
                                    if (!AlaLiveRecorder.this.mIsEnableSendData && !Thread.interrupted() && !AlaLiveRecorder.this.mExecService.isShutdown()) {
                                        break;
                                    } else if (AlaLiveRecorder.this.mAudioRecorder != null) {
                                        if (!AlaLiveRecorder.this.mIsInterruptByPhone) {
                                            if (AlaLiveRecorder.this.mResetAudioDev) {
                                                AlaLiveRecorder.this.mResetAudioDev = false;
                                                AlaLiveRecorder.this.startAudioDevice(false);
                                            }
                                            if (AlaLiveRecorder.this.mIsMute) {
                                                AlaAudioFrame readData2 = AlaLiveRecorder.this.mAudioRecorder.readData();
                                                readData2.bytes = AlaLiveRecorder.this.mMuteBytes;
                                                readData2.length = 2048;
                                                readData = readData2;
                                            } else {
                                                readData = AlaLiveRecorder.this.mAudioRecorder.readData();
                                            }
                                            if (readData == null || readData.bytes == null || readData.length <= 0) {
                                                if (!AlaLiveRecorder.this.mIsEnableSendData) {
                                                    break;
                                                }
                                                i = -1;
                                                if ((i == 0 || !(readData == null || readData.bytes == null || readData.bytes.length != 0)) && System.currentTimeMillis() - currentTimeMillis2 >= 5000) {
                                                    AlaLiveRecorder.this.mHasAudio = false;
                                                    currentTimeMillis = System.currentTimeMillis();
                                                } else {
                                                    currentTimeMillis = currentTimeMillis2;
                                                }
                                                if (i != 0) {
                                                    AlaLiveRecorder.this.mHasAudio = true;
                                                    currentTimeMillis2 = System.currentTimeMillis();
                                                } else {
                                                    int i3 = i2 + 1;
                                                    if (i3 < 5) {
                                                        AlaLiveRecorder.log(BdStatsConstant.StatsType.ERROR, "sendPCMDataNative", "errcode", Integer.valueOf(i), "curnet", BdNetTypeUtil.netTypeNameInLowerCase(), "puship", AlaLiveRecorder.this.getPushStreamIp());
                                                    }
                                                    try {
                                                        Thread.sleep(40L);
                                                        currentTimeMillis2 = currentTimeMillis;
                                                        i2 = i3;
                                                    } catch (InterruptedException e) {
                                                        BdLog.e(e);
                                                        currentTimeMillis2 = currentTimeMillis;
                                                        i2 = i3;
                                                    }
                                                }
                                            } else if (AlaLiveRecorder.this.mNdkAdapter == null || AlaLiveRecorder.this.mNdkAdapter.getNativeObject() == 0) {
                                                break;
                                            } else {
                                                if (AlaLiveRecorder.this.mStreamMode == 1) {
                                                    i = AlaLiveRecorder.this.mNdkAdapter.sendPCMDataNative(readData.bytes, readData.length, readData.dts, readData.pts);
                                                } else if (AlaLiveRecorder.this.mStreamMode == 2) {
                                                    i = AlaLiveRecorder.this.mNdkAdapter.sendPCMDataNative2(readData.bytes, readData.length, readData.dts, readData.pts);
                                                } else {
                                                    BdLog.d("unknow stream mode!!");
                                                    i = -1;
                                                }
                                                if (i == 0) {
                                                }
                                                AlaLiveRecorder.this.mHasAudio = false;
                                                currentTimeMillis = System.currentTimeMillis();
                                                if (i != 0) {
                                                }
                                            }
                                        }
                                    } else {
                                        BdLog.e("mAudioRecorder is null, stopAll is called");
                                        break;
                                    }
                                }
                                AlaLiveRecorder.this.mIsAudioThreadRun = false;
                                AlaLiveRecorder.this.stopAudioDevice();
                                return;
                            }
                            BdLog.e("startAudioCaptureLoop has shutdown!");
                            AlaLiveRecorder.this.stopAudioDevice();
                            return;
                        }
                        BdLog.e("mAudioRecorder is null, stopAll is called");
                    }
                });
            }
        }
        return 0;
    }

    private int startPushForRtc(String str) {
        if (this.mStreamMode == 1 || this.mCurrentPushState == 1) {
            return 0;
        }
        if (this.mRtcConfig == null) {
            BdLog.e("startPushForRtc rtcConfig = null");
            return -1;
        }
        this.mIsDeviceRun = true;
        this.mCurrentPushState = 1;
        this.mStartBaseInfo.mStreamType = AlaLiveBaseInfo.STREAM_TYPE_SEND;
        this.mStartBaseInfo.mPkId = String.format("%d", Long.valueOf(this.mRtcConfig.mRoomId));
        this.mVideoRecorder.startRecord();
        createPKPlayer();
        if (this.mPKPlayer != null) {
            this.mPKPlayer.setEnableRtcACE(this.mEnableRtcACE);
            this.mPKPlayer.startPlay(this.mRtcConfig.getRtcUrl(), 1, this.mStartBaseInfo.toJsonString());
        }
        if (this.mNdkAdapter.getNativeObject() != 0) {
            this.mNdkAdapter.setDebugMonitor(true, 5);
            if (this.mNdkAdapter.startNative(this.mRtcConfig.getRtcUrl(), getNetworkState(), this.mStartBaseInfo.toJsonString()) != 0) {
                BdLog.e("startNative fail");
            }
        }
        startDevices();
        this.mHasSendRtcConnected = false;
        this.mRtcStreamStatus = 0;
        return 0;
    }

    private int startPushForCommon(String str) {
        if (this.mStreamMode == 2 || str == null || this.mCurrentPushState == 1) {
            return 0;
        }
        this.mCurrentPushState = 1;
        this.mStartBaseInfo.mStreamType = AlaLiveBaseInfo.STREAM_TYPE_SEND;
        this.mStartBaseInfo.mPkId = null;
        if (initCodecs() < 0) {
            BdLog.e("startPushForCommon initCodec error !!");
            return -1;
        }
        this.mRecordUrl = str;
        startAudioDevice(true);
        if (!this.mIsBackground) {
            startVideoDevice();
        }
        if (this.mHardEncorder != null && this.mGameHardEncode) {
            this.mHardEncorder.start(0);
        }
        this.mIsDeviceRun = true;
        prepareNative(false);
        startAudioCaptureLoop();
        return 0;
    }

    private void stopAll(boolean z, boolean z2) {
        if (this.mSendHandler != null) {
            this.mSendHandler.removeCallbacksAndMessages(null);
        }
        if (this.mNdkAdapter.getNativeObject() != 0) {
            this.mNdkAdapter.sendNativeStatAppData("arInfo", AlaDataModel.getInstance().getData(AlaDataModel.ALA_DATA_BEAUTY_PARAMS_KEYS), 1);
        }
        this.mCurrentPushState = 2;
        stopDevices(z);
        stopNative(z2);
        if (this.mHardEncorder != null && this.mGameHardEncode) {
            this.mHardEncorder.stop();
        }
    }

    public void release() {
        BdStatisticsManager.getInstance().newDebug("AlaLiveRecorder", 0L, null, "verbose", "release recorder");
        if (this.mVideoRecorder != null) {
            this.mVideoRecorder.willSwitchSense(0);
        }
        stopAll(true, true);
        Config.getInstance().setDuSticker(null);
        this.mExecService.shutdown();
        if (this.mHardEncorder != null && this.mGameHardEncode) {
            this.mHardEncorder.release();
        }
        if (this.mSendThread != null && this.mSendThread.getLooper() != null) {
            this.mSendThread.getLooper().quit();
            this.mSendThread = null;
        }
        this.mActivity = null;
        MessageManager.getInstance().unRegisterListener(this.mNetworkChangedListener);
        this.mNetworkChangedListener = null;
        this.mMainHandler.removeCallbacksAndMessages(null);
        ((TelephonyManager) TbadkCoreApplication.getInst().getSystemService("phone")).listen(this.mPhoneStateListener, 0);
    }

    private void startDevices() {
        this.mIsDeviceRun = true;
        startVideoDevice();
        startAudioDevice(true);
        startAudioCaptureLoop();
        if (this.mExecService != null) {
            this.mExecService.submit(new Runnable() { // from class: com.baidu.ala.recorder.AlaLiveRecorder.11
                @Override // java.lang.Runnable
                public void run() {
                    AlaLiveRecorder.this.stopAudioDevice();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startAudioDevice(boolean z) {
        Runnable runnable = new Runnable() { // from class: com.baidu.ala.recorder.AlaLiveRecorder.12
            @Override // java.lang.Runnable
            public void run() {
                if (AlaLiveRecorder.this.mAudioRecorder != null) {
                    AlaLiveRecorder.this.mAudioRecorder.stopAndRelease();
                    AlaLiveRecorder.this.mAudioRecorder = null;
                }
                if (AlaLiveRecorder.this.mStreamMode != 1) {
                    if (AlaLiveRecorder.this.mStreamMode == 2) {
                        AlaLiveRecorder.this.mAudioRecorder = new AlaAudioRecorder(AlaLiveRecorder.this.mActivity, StreamConfig.Audio.AUDIO_RTC_FREQUENCY_48K, 16, AlaLiveRecorder.this.mEnableRtcACE);
                    }
                } else {
                    AlaLiveRecorder.this.mAudioRecorder = new AlaAudioRecorder(AlaLiveRecorder.this.mActivity, 44100, 16, false);
                }
                if (AlaLiveRecorder.this.mAudioRecorder != null) {
                    boolean start = AlaLiveRecorder.this.mAudioRecorder.start();
                    if (AlaLiveRecorder.this.mVideoRecorder != null && AlaLiveRecorder.this.mVideoRecorder.getRecorderHandler() != null) {
                        AlaLiveRecorder.this.mVideoRecorder.getRecorderHandler().sendAudioOpened(start);
                    }
                    if (!start) {
                        BdLog.e("mAudioRecorder start failed");
                        AlaLiveRecorder.this.stopNative(false);
                    }
                    if (AlaLiveRecorder.this.mExecService != null && AlaLiveRecorder.this.mExecService.isShutdown() && AlaLiveRecorder.this.mAudioRecorder != null) {
                        AlaLiveRecorder.this.mAudioRecorder.stopAndRelease();
                        AlaLiveRecorder.this.mAudioRecorder = null;
                        return;
                    }
                    return;
                }
                BdLog.d("mAudioRecorder construct error !!!");
            }
        };
        if (z) {
            this.mExecService.submit(runnable);
        } else {
            runnable.run();
        }
    }

    private void startVideoDevice() {
        if (this.mVideoRecorder == null) {
            this.mVideoRecorder = new AlaLiveVideoRecorder(this.mActivity);
            this.mVideoRecorder.init(this.mVideoRecorderType, this.mBeautyType);
            this.mVideoRecorder.setVideoDataCallback(this.mVideoDataCallBack);
            this.mVideoRecorder.setVideoConfig(this.mVideoConfig);
            this.mVideoRecorder.setRecorderCallback(this.mRecordCallback);
            if (this.mStreamMode == 2) {
                this.mVideoRecorder.setPreviewFps(10);
            } else if (this.mStreamMode == 1) {
                this.mVideoRecorder.setPreviewFps(this.mVideoConfig.getVideoFPS());
            }
        }
        if (!this.mVideoRecorder.isVideoThreadRun()) {
            this.mVideoRecorder.startRecord();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void stopAudioDevice() {
        if (this.mAudioRecorder != null) {
            this.mAudioRecorder.stopAndRelease();
            this.mAudioRecorder = null;
        }
    }

    private void stopVideoDevice() {
        if (this.mVideoRecorder != null) {
            stopVideoRecord();
        }
    }

    private void stopDevices(boolean z) {
        this.mIsDeviceRun = false;
        this.mIsEnableSendData = false;
        stopAudioDevice();
        stopVideoDevice();
        if (this.mVideoRecorder != null && z) {
            this.mVideoRecorder.release();
        }
        log("action", "stopDevices");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopNative(boolean z) {
        final AlaNDKRecorderAdapter alaNDKRecorderAdapter = new AlaNDKRecorderAdapter();
        alaNDKRecorderAdapter.setNativeObject(this.mNdkAdapter.getNativeObject());
        Runnable runnable = new Runnable() { // from class: com.baidu.ala.recorder.AlaLiveRecorder.13
            @Override // java.lang.Runnable
            public void run() {
                if (!AlaLiveRecorder.this.mIsAudioThreadRun && alaNDKRecorderAdapter.getNativeObject() != 0) {
                    if (AlaLiveRecorder.this.mPKPlayer != null) {
                        AlaLiveRecorder.this.mPKPlayer.stopPlay();
                        AlaLiveRecorder.this.mPKPlayer.destroy();
                        AlaLiveRecorder.this.mPKPlayer = null;
                    }
                    int stopNative = alaNDKRecorderAdapter.stopNative();
                    if (stopNative != 0) {
                        BdLog.e("stopNative error:" + stopNative);
                    }
                    AlaLiveRecorder.this.mPKPlayer = null;
                }
            }
        };
        if (z) {
            this.mExecService.submit(runnable);
        } else {
            runnable.run();
        }
    }

    public String getPushStreamIp() {
        try {
            if (this.mNdkAdapter != null) {
                return this.mNdkAdapter.getPushStreamIpNative();
            }
            return "";
        } catch (Throwable th) {
            AlaLiveUtilHelper.loadPluginLibrary("ala");
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getNetworkState() {
        int netType = BdNetTypeUtil.netType();
        if (netType > 2) {
            return 2;
        }
        return netType;
    }

    public void enterBackground() {
        if (this.mNdkAdapter != null && this.mNdkAdapter.getNativeObject() != 0) {
            this.mNdkAdapter.enterBackground();
        }
        if (this.mVideoRecorder.isForeBackgroundSwitchEnable()) {
            if (!this.mIsAutoStartFromBack) {
                this.mIsBackground = false;
                return;
            }
            this.mIsBackground = true;
            stopDevices(false);
        }
    }

    public void enterForeground() {
        if (this.mNdkAdapter != null && this.mNdkAdapter.getNativeObject() != 0) {
            this.mNdkAdapter.enterForeground();
        }
        if (this.mVideoRecorder != null) {
            if (this.mVideoRecorder == null || this.mVideoRecorder.isForeBackgroundSwitchEnable()) {
                if (!this.mIsAutoStartFromBack) {
                    this.mIsBackground = false;
                    return;
                }
                this.mIsBackground = false;
                if (this.mCurrentPushState == 1) {
                    startDevices();
                }
            }
        }
    }

    private void rtmpDebugResponsedCallback(AlaLiveDebugInfo alaLiveDebugInfo) {
        if (alaLiveDebugInfo != null && this.mVideoRecorder != null) {
            this.mVideoRecorder.sendDebugInfo(new AlaLiveDebugInfo(alaLiveDebugInfo));
        }
    }

    private void rtmpResponsedCallback(int i, int i2) {
        if (this.mStreamMode == 2) {
            this.mRtcStreamStatus = i2;
            if (!this.mHasSendRtcConnected && this.mVideoRecorder != null && this.mVideoRecorder.getRecorderHandler() != null) {
                this.mHasSendRtcConnected = true;
                this.mVideoRecorder.getRecorderHandler().sendRtcConnected(i2);
            }
        }
        if (!BdNetTypeUtil.isNetworkAvailableForImmediately()) {
            BdLog.e("网络不可用，rtmp断开");
        } else if (this.mStreamMode == 1 && i != 1 && this.mMainHandler != null) {
            this.mMainHandler.post(this.mrtmpResponsedRestartRunnable);
        }
    }

    public View getPreview() {
        if (this.mVideoRecorder == null) {
            return null;
        }
        return this.mVideoRecorder.getPreview();
    }

    public void addRecorderCallback(RecorderCallback recorderCallback) {
        this.mVideoRecorder.setRecorderCallback(this.mRecordCallback);
        if (recorderCallback != null && !this.mExternRecordCallbacks.contains(recorderCallback)) {
            this.mExternRecordCallbacks.add(recorderCallback);
        }
    }

    public void removeRecorderCallback(RecorderCallback recorderCallback) {
        if (recorderCallback != null) {
            this.mExternRecordCallbacks.remove(recorderCallback);
        }
    }

    protected static void log(Object... objArr) {
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            BdStatisticsManager.getInstance().newDebug(LOG_TAG, 0L, null, objArr);
        }
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraStatusHandler
    public void switchCamera() {
        this.mVideoRecorder.switchCamera();
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraStatusHandler
    public boolean isBackCamera() {
        return this.mVideoRecorder.isBackCamera();
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraStatusHandler
    public void switchFlashingLight() {
        this.mVideoRecorder.switchFlashingLight();
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraStatusHandler
    public boolean isFlashingLightOpen() {
        return this.mVideoRecorder.isFlashingLightOpen();
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraStatusHandler
    public void setBeauty(int i) {
        this.mVideoRecorder.setBeauty(i);
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraStatusHandler
    public int hasBeauty() {
        return this.mVideoRecorder.hasBeauty();
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraStatusHandler
    public int getDisplayRotate() {
        return this.mVideoRecorder.getDisplayRotate();
    }

    public void setIsAutoStartFromBack(boolean z) {
        this.mIsAutoStartFromBack = z;
    }

    public int getMediaStatus() {
        return (this.mHasAudio ? 0 : 2) | (this.mHasVideo ? 0 : 1);
    }

    public AlaLiveDebugInfo getRecorderDebugInfo() {
        return this.mLiveDebugInfo;
    }

    private void initDebugInfo() {
        this.mLiveDebugInfo = new AlaLiveDebugInfo();
    }

    public void switchOrientation(boolean z) {
        if (this.mVideoRecorderType == VideoRecorderType.SCREEN) {
            if (this.mIsDeviceRun) {
                int currentBitRate = this.mVideoConfig.getCurrentBitRateConfig().getCurrentBitRate();
                if (this.mStreamMode == 2) {
                    this.mNdkAdapter.updateVCodeParamNative(this.mVideoRecorder.getOutputWidth(), this.mVideoRecorder.getOutputHeight(), currentBitRate, this.mVideoRecorder.getVideoFormat().getValue(), 1, 10, this.mPreVideoWidth, this.mPreVideoHeight);
                } else if (this.mStreamMode == 1) {
                    this.mNdkAdapter.updateVCodeParamNative(this.mVideoRecorder.getOutputWidth(), this.mVideoRecorder.getOutputHeight(), currentBitRate, this.mVideoRecorder.getVideoFormat().getValue(), this.mVideoConfig.getVideoGOP(), this.mVideoConfig.getVideoFPS(), this.mPreVideoWidth, this.mPreVideoHeight);
                }
            }
            changeVideoRecorderType(VideoRecorderType.SCREEN, true);
        }
    }

    public void onBeautyTypeChanged(VideoBeautyType videoBeautyType) {
        if (videoBeautyType == this.mBeautyType) {
            BdLog.d("onBeautyTypeChanged same");
            return;
        }
        this.mBeautyType = videoBeautyType;
        this.mVideoRecorder.onBeautyTypeChanged(videoBeautyType);
    }

    public VideoBeautyType getBeautyType() {
        return this.mBeautyType;
    }

    public void onBeautyParamsChanged(float f, HashMap<String, Object> hashMap) {
        if (this.mVideoRecorder != null) {
            this.mVideoRecorder.onBeautyParamsChanged(f, hashMap);
        }
    }

    /* loaded from: classes3.dex */
    class SendDataInfo {
        public byte[] data;
        public int displayRotate;
        public int length;
        public int lineSize;

        SendDataInfo() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class SendHandler extends Handler {
        public SendHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    SendDataInfo sendDataInfo = (SendDataInfo) message.obj;
                    AlaLiveRecorder.this.sendAndEncodeDataReal(sendDataInfo.data, sendDataInfo.length, sendDataInfo.displayRotate, sendDataInfo.lineSize);
                    removeCallbacks(AlaLiveRecorder.this.mFpsEnhancedRunnable);
                    postDelayed(AlaLiveRecorder.this.mFpsEnhancedRunnable, 5000L);
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendAndEncodeDataReal(byte[] bArr, int i, int i2, int i3) {
        if (this.mNdkAdapter != null && this.mNdkAdapter.getNativeObject() != 0) {
            int i4 = 0;
            String str = null;
            if (this.mIsSendCmd) {
                fillCmdData();
                str = AlaLiveStreamCmdInfo.genCmd(this.mActivity, this.mCmdData);
                this.mIsSendCmd = false;
            }
            if (this.mNdkAdapter != null && this.mNdkAdapter.getNativeObject() != 0) {
                long mediaStreamTS = AlaNdkAdapter.getMediaStreamTS(false);
                i4 = this.mNdkAdapter.sendYuvDataNative(bArr, i, i2, i3, mediaStreamTS, mediaStreamTS, str);
            }
            if (i4 != 0) {
                this.mSendDataErrorCount++;
                if (this.mSendDataErrorCount < 5) {
                    log(BdStatsConstant.StatsType.ERROR, "sendYuvData", "errcode", Integer.valueOf(i4), "curnet", BdNetTypeUtil.netTypeNameInLowerCase(), "puship", getPushStreamIp());
                }
            } else {
                this.mHasVideo = true;
                this.mSendDataErrorCount = 0;
                adjustDynamicBitRate();
            }
            if (i4 != 0) {
                BdLog.e("sendYuvDataNative error. error is " + i4);
            }
        }
    }

    public void setUserGameHardEncode(boolean z) {
        this.mGameHardEncode = z;
    }

    @Override // com.baidu.ala.recorder.IFaceUnityOperator
    public void onEffectItemSelected(String str) {
        if (this.mVideoRecorder != null) {
            this.mVideoRecorder.onEffectItemSelected(str);
        }
    }

    @Override // com.baidu.ala.recorder.IFaceUnityOperator
    public void onStickerItemSelected(Object obj) {
        if (this.mVideoRecorder != null) {
            this.mVideoRecorder.onStickerItemSelected(obj);
        }
    }

    @Override // com.baidu.ala.recorder.IFaceUnityOperator
    public void onGiftEffectItemSelected(String str) {
        if (this.mVideoRecorder != null) {
            this.mVideoRecorder.onGiftEffectItemSelected(str);
        }
    }

    @Override // com.baidu.ala.recorder.IFaceUnityOperator
    public void onFilterSelected(String str, String str2, float f) {
        if (this.mVideoRecorder != null) {
            this.mVideoRecorder.onFilterSelected(str, str2, f);
        }
    }

    @Override // com.baidu.ala.recorder.IFaceUnityOperator
    public void onBlurLevelSelected(int i) {
        if (this.mVideoRecorder != null) {
            this.mVideoRecorder.onBlurLevelSelected(i);
        }
    }

    @Override // com.baidu.ala.recorder.IFaceUnityOperator
    public void onColorLevelSelected(float f) {
        if (this.mVideoRecorder != null) {
            this.mVideoRecorder.onColorLevelSelected(f);
        }
    }

    @Override // com.baidu.ala.recorder.IFaceUnityOperator
    public void onCheekThinSelected(float f) {
        if (this.mVideoRecorder != null) {
            this.mVideoRecorder.onCheekThinSelected(f);
        }
    }

    @Override // com.baidu.ala.recorder.IFaceUnityOperator
    public void onEnlargeEyeSelected(float f) {
        if (this.mVideoRecorder != null) {
            this.mVideoRecorder.onEnlargeEyeSelected(f);
        }
    }

    @Override // com.baidu.ala.recorder.IFaceUnityOperator
    public void onFaceShapeSelected(int i) {
        if (this.mVideoRecorder != null) {
            this.mVideoRecorder.onFaceShapeSelected(i);
        }
    }

    @Override // com.baidu.ala.recorder.IFaceUnityOperator
    public void onFaceShapeLevelSelected(float f) {
        if (this.mVideoRecorder != null) {
            this.mVideoRecorder.onFaceShapeLevelSelected(f);
        }
    }

    @Override // com.baidu.ala.recorder.IFaceUnityOperator
    public void onRedLevelSelected(float f) {
        if (this.mVideoRecorder != null) {
            this.mVideoRecorder.onRedLevelSelected(f);
        }
    }

    @Override // com.baidu.ala.recorder.IFaceUnityOperator
    public void onChinSelected(float f) {
        if (this.mVideoRecorder != null) {
            this.mVideoRecorder.onChinSelected(f);
        }
    }

    @Override // com.baidu.ala.recorder.IFaceUnityOperator
    public void onNoseSelected(float f) {
        if (this.mVideoRecorder != null) {
            this.mVideoRecorder.onNoseSelected(f);
        }
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraStatusHandler
    public boolean hasAdvancedBeauty() {
        return this.mVideoRecorder.hasAdvancedBeauty();
    }

    public void setPushMirror(boolean z) {
        this.mIsMirror = z;
        this.mVideoRecorder.setPushMirror(z);
    }

    public boolean isPushMirror() {
        return this.mVideoRecorder != null ? this.mVideoRecorder.isPushMirror() : this.mIsMirror;
    }

    public void setMute(boolean z) {
        this.mIsMute = z;
    }

    public boolean isMute() {
        return this.mIsMute;
    }

    public boolean isBackground() {
        return this.mIsBackground;
    }

    public void setFaceUnityCallback(AlaLiveRecorderConfig.FaceUnityCallBack faceUnityCallBack) {
        AlaLiveRecorderConfig.setFaceUnityCallback(faceUnityCallBack);
    }

    public void setILoadLibrary(AlaLiveRecorderConfig.ILoadLibrary iLoadLibrary) {
        AlaLiveRecorderConfig.setILoadLibraryCallback(iLoadLibrary);
    }

    public void setDefBeautyParams(ConcurrentHashMap<String, Object> concurrentHashMap) {
        this.mVideoRecorder.setDefBeautyParams(concurrentHashMap);
    }

    public void setBeautyJsonPath(String str) {
        this.mVideoRecorder.setBeautyJsonPath(str);
    }
}
