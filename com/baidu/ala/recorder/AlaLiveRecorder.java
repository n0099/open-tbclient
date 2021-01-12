package com.baidu.ala.recorder;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.baidu.ala.adp.lib.util.BdLog;
import com.baidu.ala.adp.lib.util.BdNetTypeUtil;
import com.baidu.ala.adp.lib.util.NetWorkChangedListener;
import com.baidu.ala.adp.lib.util.NetWorkChangedMessage;
import com.baidu.ala.dumixar.ArCache;
import com.baidu.ala.dumixar.EGLTextureReader;
import com.baidu.ala.helper.AlaConstants;
import com.baidu.ala.helper.AlaDataModel;
import com.baidu.ala.helper.AlaLiveBaseInfo;
import com.baidu.ala.helper.AlaLiveDebugInfo;
import com.baidu.ala.helper.AlaLiveRtcConfig;
import com.baidu.ala.helper.AlaLiveStatConfig;
import com.baidu.ala.helper.AlaLiveStreamCmdInfo;
import com.baidu.ala.helper.AlaLiveUtilHelper;
import com.baidu.ala.helper.EncodePerformanceHelper;
import com.baidu.ala.helper.StreamConfig;
import com.baidu.ala.ndk.AlaAudioFrame;
import com.baidu.ala.ndk.AlaNDKRecorderAdapter;
import com.baidu.ala.recorder.AlaLiveRecorderConfig;
import com.baidu.ala.recorder.audio.AlaAudioConfig;
import com.baidu.ala.recorder.audio.AlaAudioSession;
import com.baidu.ala.recorder.audio.AudioSamplesInfo;
import com.baidu.ala.recorder.audio.IAudioService;
import com.baidu.ala.recorder.audio.RtcMixedPcmDataListener;
import com.baidu.ala.recorder.video.AlaLiveSession;
import com.baidu.ala.recorder.video.AlaLiveVideoConfig;
import com.baidu.ala.recorder.video.AlaRecorderLog;
import com.baidu.ala.recorder.video.IVideoRecorder;
import com.baidu.ala.recorder.video.LogReport;
import com.baidu.ala.recorder.video.VideoBeautyType;
import com.baidu.ala.recorder.video.VideoRecorderType;
import com.baidu.ala.recorder.video.camera.ICameraStatusHandler;
import com.baidu.ala.tbadk.core.TbadkCoreApplicationProxy;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public class AlaLiveRecorder implements IFaceUnityOperator, ICameraStatusHandler, ICameraStatusHandler.Beauty {
    public static final int ALA_STREAM_CONNECT_FAIL = 0;
    public static final int ALA_STREAM_CONNECT_INIT = -1;
    public static final int ALA_STREAM_CONNECT_START = 2;
    public static final int ALA_STREAM_CONNECT_SUCC = 1;
    private static final int CHECK_STREAM_INTERVAL = 5000;
    private static final int DEFAULT_REDUCE_DELAY_STRATEGY = 0;
    private static final int DELAY_RUNNABLE_MS = 5000;
    private static final int ERR_LOG_LIMIT = 500;
    private static final String LOG_TAG = "liverecorder";
    private static final int RECORDER_STATE_INIT = 0;
    private static final int RECORDER_STATE_PUSHING = 1;
    private static final int RECORDER_STATE_STOPPED = 2;
    private final int DEBUG_MONITOR_INTERVAL;
    private boolean hasInitAudioReSample;
    private boolean isEnableExternalAudioCapture;
    private Activity mActivity;
    private AlaAudioSession mAudioRecorder;
    private IAudioService.FrameCallback mAudioSessionCallback;
    private VideoBeautyType mBeautyType;
    AlaLiveStreamCmdInfo.CmdData mCmdData;
    private int mCurStreamLevel;
    private int mCurrentIncreaseCount;
    private volatile int mCurrentPushState;
    private boolean mEnableRtcACE;
    private int mErrLogLimit;
    private ExecutorService mExecService;
    private final List<RecorderCallback> mExternRecordCallbacks;
    private volatile boolean mHasAudio;
    private boolean mHasNetwork;
    private boolean mHasSendRtcConnected;
    private volatile boolean mHasVideo;
    private boolean mIsAutoStartFromBack;
    private volatile boolean mIsBackground;
    private volatile boolean mIsCameraOpened;
    private volatile boolean mIsDeviceRun;
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
    private AlaNDKRecorderAdapter mNdkAdapter;
    NetWorkChangedListener mNetworkChangedListener;
    private long mNoVideoExceptions;
    private EGLTextureReader.OnPixelReadCallback mOnPixelReadCallback;
    private AlaLivePKPlayer mPKPlayer;
    private int mPreVideoHeight;
    private int mPreVideoWidth;
    private String mPushBestIp;
    private String mPushHost;
    private RecorderCallback mRecordCallback;
    private String mRecordUrl;
    private RecorderErrorCallback mRecorderErrorCallback;
    private AlaRecorderLog mRecorderLog;
    private volatile boolean mResetAudioDev;
    private AlaLiveRtcConfig mRtcConfig;
    private RtcMixedPcmDataListener mRtcMixedPcmDataListener;
    private int mRtcStreamStatus;
    private Runnable mRunnableSendCmdFlag;
    private int mSendDataErrorCount;
    private SendHandler mSendHandler;
    private HandlerThread mSendThread;
    private AlaLiveBaseInfo mStartBaseInfo;
    private AlaLiveStatConfig mStatConfig;
    private int mStreamMode;
    private AlaLiveVideoConfig mVideoConfig;
    private IVideoRecorder.IVideoDataCallBack mVideoDataCallBack;
    private AlaLiveSession mVideoRecorder;
    private VideoRecorderType mVideoRecorderType;
    private Runnable mrtmpResponsedRestartRunnable;
    private int outChannelNum;
    private int outFormat;
    byte[] outPcm;
    private int outSampleRate;
    private int rtcMixPcmNumForLog;

    static /* synthetic */ int access$2308(AlaLiveRecorder alaLiveRecorder) {
        int i = alaLiveRecorder.rtcMixPcmNumForLog;
        alaLiveRecorder.rtcMixPcmNumForLog = i + 1;
        return i;
    }

    static /* synthetic */ int access$3208(AlaLiveRecorder alaLiveRecorder) {
        int i = alaLiveRecorder.mErrLogLimit;
        alaLiveRecorder.mErrLogLimit = i + 1;
        return i;
    }

    public AlaLiveRecorder(Context context, AlaLiveVideoConfig alaLiveVideoConfig, VideoRecorderType videoRecorderType, IRecorderDependency iRecorderDependency) {
        this(context, alaLiveVideoConfig, videoRecorderType, iRecorderDependency, VideoBeautyType.BEAUTY_FACEUNITY);
    }

    public AlaLiveRecorder(Context context, AlaLiveVideoConfig alaLiveVideoConfig, VideoRecorderType videoRecorderType, IRecorderDependency iRecorderDependency, VideoBeautyType videoBeautyType) {
        this.mCmdData = new AlaLiveStreamCmdInfo.CmdData();
        this.mCurStreamLevel = 1;
        this.DEBUG_MONITOR_INTERVAL = 5;
        this.mSendDataErrorCount = 0;
        this.mLastNetState = 0;
        this.mIsDeviceRun = false;
        this.mHasAudio = false;
        this.mHasVideo = false;
        this.mCurrentPushState = 0;
        this.mIsBackground = false;
        this.mIsCameraOpened = false;
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
        this.mIsAutoStartFromBack = true;
        this.mHasNetwork = true;
        this.mResetAudioDev = false;
        this.mEnableRtcACE = true;
        this.mExternRecordCallbacks = new LinkedList();
        this.mErrLogLimit = 0;
        this.mRecordCallback = new RecorderCallback() { // from class: com.baidu.ala.recorder.AlaLiveRecorder.1
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
                AlaLiveRecorder.this.mIsCameraOpened = z;
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
                AlaLiveRecorder.this.mIsCameraOpened = false;
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
                AlaLiveRecorder.this.mRecorderLog.onDebugInfo(alaLiveDebugInfo);
                if (!AlaLiveRecorder.this.mExternRecordCallbacks.isEmpty()) {
                    for (RecorderCallback recorderCallback : AlaLiveRecorder.this.mExternRecordCallbacks) {
                        recorderCallback.onDebugInfo(alaLiveDebugInfo);
                    }
                }
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void onError(int i, String str) {
                if (!AlaLiveRecorder.this.mIsRecordStoped) {
                    AlaLiveRecorder.this.mRecorderLog.onRecorderError(i, str);
                    if (AlaLiveRecorder.this.mRecorderErrorCallback != null) {
                        AlaLiveRecorder.this.mRecorderErrorCallback.onError(i, str);
                    }
                    if (!AlaLiveRecorder.this.mExternRecordCallbacks.isEmpty()) {
                        for (RecorderCallback recorderCallback : AlaLiveRecorder.this.mExternRecordCallbacks) {
                            recorderCallback.onError(i, str);
                        }
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

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void onNetStateReport(int i, int i2) {
                AlaLiveRecorder.this.mRecorderLog.onNetStateReport(i, i2);
                if (!AlaLiveRecorder.this.mExternRecordCallbacks.isEmpty()) {
                    for (RecorderCallback recorderCallback : AlaLiveRecorder.this.mExternRecordCallbacks) {
                        recorderCallback.onNetStateReport(i, i2);
                    }
                }
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void onLogReport(String str, JSONObject jSONObject, JSONObject jSONObject2) {
                if (!AlaLiveRecorder.this.mExternRecordCallbacks.isEmpty()) {
                    for (RecorderCallback recorderCallback : AlaLiveRecorder.this.mExternRecordCallbacks) {
                        recorderCallback.onLogReport(str, jSONObject, jSONObject2);
                    }
                }
            }

            @Override // com.baidu.ala.recorder.RecorderCallback
            public void sendBufferChanged(int i) {
                if (!AlaLiveRecorder.this.mExternRecordCallbacks.isEmpty()) {
                    for (RecorderCallback recorderCallback : AlaLiveRecorder.this.mExternRecordCallbacks) {
                        recorderCallback.sendBufferChanged(i);
                    }
                }
            }
        };
        this.mVideoDataCallBack = new IVideoRecorder.IVideoDataCallBack() { // from class: com.baidu.ala.recorder.AlaLiveRecorder.2
            @Override // com.baidu.ala.recorder.video.IVideoRecorder.IVideoDataCallBack
            public void onRawVideoFrameReceived(byte[] bArr, int i, int i2, int i3, long j) {
                if (AlaLiveRecorder.this.mCurrentPushState == 1 && AlaLiveRecorder.this.mNdkAdapter != null) {
                    if (AlaLiveRecorder.this.mNdkAdapter == null || AlaLiveRecorder.this.mNdkAdapter.getNativeObject() != 0) {
                        if (AlaLiveRecorder.this.mSendHandler != null) {
                            Message obtainMessage = AlaLiveRecorder.this.mSendHandler.obtainMessage();
                            SendDataInfo sendDataInfo = new SendDataInfo();
                            sendDataInfo.data = bArr;
                            sendDataInfo.displayRotate = i2;
                            sendDataInfo.length = i;
                            sendDataInfo.lineSize = i3;
                            sendDataInfo.timestamp = j;
                            obtainMessage.obj = sendDataInfo;
                            obtainMessage.what = 0;
                            if (AlaLiveRecorder.this.mSendHandler != null) {
                                AlaLiveRecorder.this.mSendHandler.sendMessage(obtainMessage);
                                return;
                            }
                            return;
                        }
                        AlaLiveRecorder.this.sendAndEncodeDataReal(bArr, i, i2, i3, j);
                    }
                }
            }

            @Override // com.baidu.ala.recorder.video.IVideoRecorder.IVideoDataCallBack
            public void onEncodeVideoFrameRecived(byte[] bArr, int i, int i2, int i3, long j, long j2, int i4) {
                if (AlaLiveRecorder.this.mCurrentPushState == 1 && AlaLiveRecorder.this.mNdkAdapter != null) {
                    if ((AlaLiveRecorder.this.mNdkAdapter == null || AlaLiveRecorder.this.mNdkAdapter.getNativeObject() != 0) && AlaLiveRecorder.this.mNdkAdapter != null && AlaLiveRecorder.this.mNdkAdapter.getNativeObject() != 0) {
                        String str = null;
                        if (AlaLiveRecorder.this.mIsSendCmd) {
                            AlaLiveRecorder.this.fillCmdData();
                            str = AlaLiveStreamCmdInfo.genCmd(AlaLiveRecorder.this.mActivity, AlaLiveRecorder.this.mCmdData);
                            AlaLiveRecorder.this.mIsSendCmd = false;
                        }
                        int sendEncodeVideoData = AlaLiveRecorder.this.mNdkAdapter.sendEncodeVideoData(bArr, i2, str, j, j2, i4);
                        if (sendEncodeVideoData == 0) {
                            AlaLiveRecorder.this.mHasVideo = true;
                            AlaLiveRecorder.this.adjustDynamicBitRate();
                        } else {
                            AlaLiveRecorder.this.mHasVideo = false;
                        }
                        if (sendEncodeVideoData != 0) {
                            AlaLiveRecorder.this.errLog(11, "onEncodeVideoFrameRecived error. error is " + sendEncodeVideoData);
                            BdLog.e("onEncodeVideoFrameRecived error. error is " + sendEncodeVideoData);
                        }
                    }
                }
            }

            @Override // com.baidu.ala.recorder.video.IVideoRecorder.IVideoDataCallBack
            public void onError(int i) {
                if (AlaLiveRecorder.this.mLiveDebugInfo != null) {
                    AlaLiveRecorder.this.mLiveDebugInfo.statusCode = i;
                }
                AlaLiveRecorder.this.errLog(12, "oncodec error. error is  " + i);
            }
        };
        this.hasInitAudioReSample = false;
        this.outSampleRate = 44100;
        this.outChannelNum = 1;
        this.outFormat = 1;
        this.mRtcMixedPcmDataListener = new RtcMixedPcmDataListener() { // from class: com.baidu.ala.recorder.AlaLiveRecorder.3
            @Override // com.baidu.ala.recorder.audio.RtcMixedPcmDataListener
            public void onRtcAudioMixedSamplesReady(AudioSamplesInfo audioSamplesInfo) {
                int i;
                float f;
                float f2;
                float f3;
                if (audioSamplesInfo != null && AlaLiveRecorder.this.mNdkAdapter != null && AlaLiveRecorder.this.mNdkAdapter.getNativeObject() != 0 && AlaLiveRecorder.this.mStreamMode == 1) {
                    if (!AlaLiveRecorder.this.hasInitAudioReSample) {
                        if (audioSamplesInfo.audioFormat == 1) {
                            i = 0;
                        } else {
                            i = audioSamplesInfo.audioFormat == 2 ? 1 : 1;
                        }
                        int ceil = (int) (Math.ceil(f * f2 * f3) + 1.0d);
                        int i2 = audioSamplesInfo.length * ceil;
                        AlaLiveRecorder.this.outPcm = new byte[i2];
                        AlaLiveRecorder.this.initAudioReSample(audioSamplesInfo.sampleRate, audioSamplesInfo.channelCount, i, AlaLiveRecorder.this.outSampleRate, AlaLiveRecorder.this.outChannelNum, AlaLiveRecorder.this.outFormat);
                        BdLog.e("linkmic onRtcAudioMixedSamplesReady init \ninit: in-sampleRate=" + audioSamplesInfo.sampleRate + " , in-channel-count=" + audioSamplesInfo.channelCount + " , in-format=" + i + " , out-sampleRate=" + AlaLiveRecorder.this.outSampleRate + " , out-channel-count=" + AlaLiveRecorder.this.outChannelNum + " , out-format=" + AlaLiveRecorder.this.outFormat + " \n , originalLength =" + audioSamplesInfo.length + " , byte-size=" + i2 + " , subTimes=" + ceil + " , sampleTimes=" + ((AlaLiveRecorder.this.outSampleRate * 1.0f) / audioSamplesInfo.sampleRate) + " , channelTimes=" + ((AlaLiveRecorder.this.outChannelNum * 1.0f) / audioSamplesInfo.channelCount) + " ,formatTimes=" + (2.0f / audioSamplesInfo.audioFormat));
                        AlaLiveRecorder.this.hasInitAudioReSample = true;
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    int audioReSample = AlaLiveRecorder.this.audioReSample(audioSamplesInfo.data, audioSamplesInfo.length, AlaLiveRecorder.this.outPcm, AlaLiveRecorder.this.outPcm.length);
                    int i3 = audioSamplesInfo.audioFormat * AlaLiveRecorder.this.outChannelNum * audioReSample;
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    int sendPCMDataNative = AlaLiveRecorder.this.mNdkAdapter.sendPCMDataNative(AlaLiveRecorder.this.outPcm, i3, audioSamplesInfo.dts, audioSamplesInfo.pts);
                    if (AlaLiveRecorder.this.rtcMixPcmNumForLog == 500) {
                        BdLog.e("linkmic onRtcAudioMixedSamplesReady audioReSample  timeDiff=" + currentTimeMillis2 + " , samples=" + audioReSample + " , pcmLength=" + i3);
                        if (sendPCMDataNative != 0) {
                            BdLog.e("linkmic onRtcAudioMixedSamplesReady sendPCMData failed ret=" + sendPCMDataNative);
                        }
                        AlaLiveRecorder.this.rtcMixPcmNumForLog = 0;
                    }
                    AlaLiveRecorder.access$2308(AlaLiveRecorder.this);
                }
            }
        };
        this.isEnableExternalAudioCapture = false;
        this.mRunnableSendCmdFlag = new Runnable() { // from class: com.baidu.ala.recorder.AlaLiveRecorder.6
            @Override // java.lang.Runnable
            public void run() {
                AlaLiveRecorder.this.mIsSendCmd = true;
                AlaLiveRecorder.this.runSetSendCmdFlag(false);
            }
        };
        this.mNoVideoExceptions = 0L;
        this.mAudioSessionCallback = new IAudioService.FrameCallback() { // from class: com.baidu.ala.recorder.AlaLiveRecorder.8
            @Override // com.baidu.ala.recorder.audio.IAudioService.FrameCallback
            public void onAudioData(AlaAudioFrame alaAudioFrame) {
                if (AlaLiveRecorder.this.mCurrentPushState == 1 && alaAudioFrame != null && AlaLiveRecorder.this.mNdkAdapter != null && AlaLiveRecorder.this.mNdkAdapter.getNativeObject() != 0) {
                    if (AlaLiveRecorder.this.mStreamMode == 2) {
                        AlaLiveRecorder.this.mNdkAdapter.sendPCMDataNative2(alaAudioFrame.bytes, alaAudioFrame.length, alaAudioFrame.dts, alaAudioFrame.pts);
                    } else if (AlaLiveRecorder.this.mStreamMode == 1) {
                        AlaLiveRecorder.this.mNdkAdapter.sendPCMDataNative(alaAudioFrame.bytes, alaAudioFrame.length, alaAudioFrame.dts, alaAudioFrame.pts);
                    }
                }
            }

            @Override // com.baidu.ala.recorder.audio.IAudioService.FrameCallback
            public void onMessage(int i, Object obj, String str) {
                if (1000 == i && (obj instanceof Boolean)) {
                    AlaLiveRecorder.this.mHasAudio = ((Boolean) obj).booleanValue();
                    if (!AlaLiveRecorder.this.mHasAudio && AlaLiveRecorder.this.mNdkAdapter != null && AlaLiveRecorder.this.mNdkAdapter.getNativeObject() != 0) {
                        AlaLiveRecorder.this.mNdkAdapter.logMediaException(3);
                    }
                } else if (1001 == i && (obj instanceof Integer)) {
                    Integer num = (Integer) obj;
                    if (AlaLiveRecorder.this.mNdkAdapter != null && AlaLiveRecorder.this.mNdkAdapter.getNativeObject() != 0) {
                        AlaLiveRecorder.this.mNdkAdapter.sendNativeStatAppData(AlaConstants.STAT_AUDIO_CAPTURE_TYPE, num.intValue() + "", 1);
                    }
                }
            }

            @Override // com.baidu.ala.recorder.audio.IAudioService.FrameCallback
            public void onError(int i, String str) {
                AlaLiveRecorder.access$3208(AlaLiveRecorder.this);
                if (AlaLiveRecorder.this.mErrLogLimit < 500) {
                    Log.e("IAudioService", " onError code:" + i + " msg:" + str);
                    if (i == 100 || i == 200) {
                        AlaLiveRecorder.this.errLog(14, str);
                    } else if (i == 101 || i == 201) {
                        AlaLiveRecorder.this.errLog(15, str);
                    }
                }
            }
        };
        this.mNetworkChangedListener = new NetWorkChangedListener() { // from class: com.baidu.ala.recorder.AlaLiveRecorder.10
            @Override // com.baidu.ala.adp.lib.util.NetWorkChangedListener
            public void onNetWorkChanged(NetWorkChangedMessage netWorkChangedMessage) {
                if (AlaLiveRecorder.this.mCurrentPushState == 1 && AlaLiveRecorder.this.mNdkAdapter != null) {
                    if (AlaLiveRecorder.this.mNdkAdapter == null || AlaLiveRecorder.this.mNdkAdapter.getNativeObject() != 0) {
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
                        AlaLiveRecorder.this.mLastNetState = BdNetTypeUtil.netType();
                        if (!AlaLiveRecorder.this.isEnableExternalAudioCapture && AlaLiveRecorder.this.mLastNetState == 0 && AlaLiveRecorder.this.mHasNetwork && AlaLiveRecorder.this.mCurrentPushState == 1 && !AlaLiveRecorder.this.mResetAudioDev) {
                            AlaLiveRecorder.this.mResetAudioDev = true;
                            AlaLiveRecorder.this.mMainHandler.post(new Runnable() { // from class: com.baidu.ala.recorder.AlaLiveRecorder.10.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    AlaLiveRecorder.this.mResetAudioDev = false;
                                    if (AlaLiveRecorder.this.mAudioRecorder != null && AlaLiveRecorder.this.mIsDeviceRun) {
                                        AlaLiveRecorder.this.mAudioRecorder.stop();
                                        AlaLiveRecorder.this.mAudioRecorder.start();
                                    }
                                }
                            });
                        }
                    }
                }
            }
        };
        this.mrtmpResponsedRestartRunnable = new Runnable() { // from class: com.baidu.ala.recorder.AlaLiveRecorder.11
            @Override // java.lang.Runnable
            public void run() {
                if (AlaLiveRecorder.this.mIsDeviceRun && !AlaLiveRecorder.this.mIsRestarting) {
                    AlaLiveRecorder.this.mIsRestarting = true;
                    AlaLiveRecorder.this.mIsNetRequestRestart = false;
                    AlaLiveRecorder.this.mLastSendVideoDataTime = 0L;
                    AlaLiveRecorder.this.mCurrentIncreaseCount = 0;
                    AlaLiveRecorder.this.prepareNative(true);
                    AlaLiveRecorder.log(BdStatsConstant.StatsType.ERROR, "restart", TiebaInitialize.LogFields.REASON, "streamclose");
                }
                AlaLiveRecorder.this.mIsRestarting = false;
            }
        };
        TbadkCoreApplicationProxy.getInst().init(iRecorderDependency);
        AlaLiveUtilHelper.loadPluginLibrary("ala");
        if (context instanceof Activity) {
            this.mActivity = (Activity) context;
            if (alaLiveVideoConfig == null) {
                throw new IllegalArgumentException("video config invalid");
            }
            this.mNdkAdapter = new AlaNDKRecorderAdapter();
            this.mRecorderLog = new AlaRecorderLog(this.mRecordCallback);
            LogReport.init(this.mRecorderLog);
            this.mLastNetState = BdNetTypeUtil.netType();
            this.mVideoRecorderType = videoRecorderType;
            this.mVideoConfig = new AlaLiveVideoConfig(alaLiveVideoConfig);
            this.mRecorderLog.setVideoConfig(this.mVideoConfig);
            this.mPreVideoWidth = this.mVideoConfig.getPreviewWidth();
            this.mPreVideoHeight = this.mVideoConfig.getPreviewHeight();
            this.mBeautyType = videoBeautyType;
            if (videoRecorderType != null) {
                this.mVideoRecorder = new AlaLiveSession(this.mActivity);
                this.mVideoRecorder.init(videoRecorderType, this.mBeautyType);
                this.mVideoRecorder.setVideoDataCallback(this.mVideoDataCallBack);
                this.mVideoRecorder.setVideoConfig(this.mVideoConfig);
                if (this.mVideoRecorderType == VideoRecorderType.CAMERA) {
                    this.mVideoRecorder.setPreviewFps(this.mVideoConfig.getVideoFPS());
                }
            }
            if (this.mAudioRecorder == null) {
                this.mAudioRecorder = new AlaAudioSession(this.mActivity, this.mAudioSessionCallback);
            }
            initDebugInfo();
            BdNetTypeUtil.addNetWorkChangedListener(this.mNetworkChangedListener);
            this.mMainHandler = new Handler();
            this.mSendThread = new HandlerThread("ala_recorder_send_thread");
            this.mSendThread.start();
            this.mSendHandler = new SendHandler(this.mSendThread.getLooper());
            this.mStartBaseInfo = new AlaLiveBaseInfo(AlaLiveUtilHelper.getApkVersionName(context));
            int initRecordNative = this.mNdkAdapter.initRecordNative(this, 1, 0);
            if (initRecordNative != 0) {
                BdLog.e("initRecordNative error. errcode is " + initRecordNative);
                errLog(14, "construct initRecordNative error. errcode is " + initRecordNative);
            }
            if (this.mVideoConfig.getVideoCodecId() == 7 && this.mVideoConfig.getEncoderType() == 2 && this.mVideoConfig.getVideoEncoderConfig() != null && !TextUtils.isEmpty(this.mVideoConfig.getVideoEncoderConfig().x264Param)) {
                setX264Config(1, this.mVideoConfig.getVideoEncoderConfig().x264Param, null);
            }
            this.mExecService.submit(new Runnable() { // from class: com.baidu.ala.recorder.AlaLiveRecorder.4
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

    public void notifyBackGroundSwitch(boolean z) {
        TbadkCoreApplicationProxy.getInst().notifyBackgroundSwitch(z);
    }

    public int startX264Encode(String str, String str2) {
        return this.mNdkAdapter.startX264EncodeToNative(str, str2);
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraStatusHandler
    public void setVideoConfig(AlaLiveVideoConfig alaLiveVideoConfig) {
        this.mVideoConfig = new AlaLiveVideoConfig(alaLiveVideoConfig);
        this.mRecorderLog.setVideoConfig(this.mVideoConfig);
        if (this.mVideoRecorder != null) {
            this.mVideoRecorder.setVideoConfig(this.mVideoConfig);
        }
    }

    public void setRtcConfig(AlaLiveRtcConfig alaLiveRtcConfig) {
        this.mRtcConfig = new AlaLiveRtcConfig(alaLiveRtcConfig);
    }

    public void setEnableCloudRtc(boolean z, EGLTextureReader.OnPixelReadCallback onPixelReadCallback) {
        if (!z) {
            this.mStreamMode = 1;
            stopAll(false, true);
            int initRecordNative = this.mNdkAdapter.initRecordNative(this, 1, 0);
            if (initRecordNative != 0) {
                BdLog.e("initRecordNative error. error code is " + initRecordNative);
                errLog(14, "setEnablePixelOutput initRecordNative error. errcode is " + initRecordNative);
            }
            this.mVideoRecorder.setTextureReaderListener(null);
            this.mVideoRecorder.enableEncoderDrawer(true);
        } else {
            this.mRecorderLog.pushEnd();
            this.mStreamMode = 3;
            this.mCurrentPushState = 1;
            stopAudioDevice();
            stopNative(true);
            this.mVideoRecorder.setTextureReaderListener(onPixelReadCallback);
            this.mVideoRecorder.enableEncoderDrawer(false);
        }
        this.mNoVideoExceptions = 0L;
    }

    public void setEnablePixelOutput(boolean z) {
        if (z) {
            this.mVideoRecorder.setTextureReaderListener(this.mOnPixelReadCallback);
            this.mVideoRecorder.enableEncoderDrawer(true);
            return;
        }
        this.mVideoRecorder.setTextureReaderListener(null);
        this.mVideoRecorder.enableEncoderDrawer(true);
    }

    public void setPixelReadCallback(EGLTextureReader.OnPixelReadCallback onPixelReadCallback) {
        this.mOnPixelReadCallback = onPixelReadCallback;
    }

    public void setEnableExternalAudioCapture(boolean z) {
        this.isEnableExternalAudioCapture = z;
        if (this.mAudioRecorder != null) {
            this.mAudioRecorder.setExternalAudio(z);
        }
        if (z) {
            stopAudioDevice();
            Log.i(LOG_TAG, "setEnableExternalAudioCapture stop AudioDevice");
            return;
        }
        startAudioDevice();
        Log.i(LOG_TAG, "setEnableExternalAudioCapture start AudioDevice");
    }

    public RtcMixedPcmDataListener getExternalAudioInput() {
        return this.mRtcMixedPcmDataListener;
    }

    public boolean setDefaultRtcMode() {
        int initAudioEncoderNative;
        int initVideoEncoderNative;
        int i = this.mStreamMode;
        if (this.mRtcConfig == null || this.mRtcConfig.mPushUrl == null) {
            return false;
        }
        final AlaNDKRecorderAdapter alaNDKRecorderAdapter = new AlaNDKRecorderAdapter();
        alaNDKRecorderAdapter.setNativeObject(this.mNdkAdapter.getNativeObject());
        this.mExecService.submit(new Runnable() { // from class: com.baidu.ala.recorder.AlaLiveRecorder.5
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
            errLog(14, "setDefaultRtcMode initRecordNative error. errcode is " + initRecordNative);
            this.mStreamMode = i;
            return false;
        }
        if (this.mVideoRecorderType != null) {
            this.mVideoConfig.switchToRtcMode(this.mVideoConfig.getVideoWidth(), this.mVideoConfig.getVideoHeight());
            this.mVideoRecorder.setVideoConfig(this.mVideoConfig);
            this.mVideoRecorder.setPreviewFps(this.mVideoConfig.getVideoFPS());
            if (this.mVideoConfig.getEncoderType() != 1 && (initVideoEncoderNative = this.mNdkAdapter.initVideoEncoderNative(this.mVideoConfig.getVideoWidth(), this.mVideoConfig.getVideoHeight(), this.mVideoConfig.getBitStream(), this.mVideoRecorder.getVideoFormat().getValue(), 1, 10, this.mPreVideoWidth, this.mPreVideoHeight, 7)) != 0) {
                BdLog.e("initAudioEncoderNative error. errcode is " + initVideoEncoderNative);
                errLog(14, "setDefaultRtcMode 1 initAudioEncoderNative error. errcode is " + initVideoEncoderNative);
                this.mStreamMode = i;
                return false;
            }
        }
        if (this.mNdkAdapter.getNativeObject() != 0 && (initAudioEncoderNative = this.mNdkAdapter.initAudioEncoderNative(StreamConfig.Audio.AUDIO_RTC_FREQUENCY_48K, 1, 16)) != 0) {
            BdLog.e("initAudioEncoderNative error. errcode is " + initAudioEncoderNative);
            errLog(14, "setDefaultRtcMode 2 initAudioEncoderNative error. errcode is " + initAudioEncoderNative);
            this.mStreamMode = i;
            return false;
        }
        if (this.mNdkAdapter.getNativeObject() != 0) {
            this.mNdkAdapter.initRtcRoomInfoNative(this.mRtcConfig.mRoomId, this.mRtcConfig.mLineIndex, this.mRtcConfig.mUId, this.mRtcConfig.mPushUrl);
            this.mNdkAdapter.setRtcConfig(this.mRtcConfig.mHandshakeTimeout, this.mRtcConfig.mHeartInterval, this.mRtcConfig.mHeartTimeout, this.mRtcConfig.mCloseTimeout);
        }
        this.mStreamMode = 2;
        return true;
    }

    public boolean switchToCommonMode(int i, int i2) {
        int initAudioEncoderNative;
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
                errLog(14, "switchToCommonMode 3 initAudioEncoderNative error. errcode is " + initRecordNative);
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
            if (this.mNdkAdapter != null && this.mNdkAdapter.getNativeObject() != 0 && (initAudioEncoderNative = this.mNdkAdapter.initAudioEncoderNative(44100, 1, 16)) != 0) {
                BdLog.e("initAudioEncoderNative error. errcode is " + initAudioEncoderNative);
                errLog(14, "switchToCommonMode 4 initAudioEncoderNative error. errcode is " + initAudioEncoderNative);
                this.mStreamMode = i3;
                return false;
            }
            this.mIsRecordStoped = false;
            this.mStartBaseInfo.mPkId = null;
            if (startPushForCommon(this.mRecordUrl) != 0) {
                this.mStreamMode = i3;
                return false;
            }
            resetDummyCapture();
        }
        this.mHasSendRtcConnected = false;
        this.mRtcStreamStatus = 0;
        return true;
    }

    public boolean switchToRtcMode(int i, int i2) {
        int initVideoEncoderNative;
        int initAudioEncoderNative;
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
                errLog(14, "switchToRtcMode initRecordNative error. errcode is " + initRecordNative);
                this.mStreamMode = i3;
                return false;
            } else if (this.mNdkAdapter.getNativeObject() != 0 && (initAudioEncoderNative = this.mNdkAdapter.initAudioEncoderNative(StreamConfig.Audio.AUDIO_RTC_FREQUENCY_48K, 1, 16)) != 0) {
                BdLog.e("initAudioEncoderNative error. errcode is " + initAudioEncoderNative);
                errLog(14, "switchToRtcMode initAudioEncoderNative error. errcode is " + initAudioEncoderNative);
                this.mStreamMode = i3;
                return false;
            } else {
                AlaLiveVideoConfig alaLiveVideoConfig = new AlaLiveVideoConfig(this.mVideoConfig);
                if (this.mNdkAdapter.getNativeObject() != 0) {
                    if (this.mVideoConfig.getEncoderType() == 1) {
                        initVideoEncoderNative = 0;
                        alaLiveVideoConfig.switchToRtcMode(i, i2);
                        this.mVideoRecorder.setVideoConfig(alaLiveVideoConfig);
                    } else {
                        initVideoEncoderNative = this.mNdkAdapter.initVideoEncoderNative(alaLiveVideoConfig.getVideoWidth(), alaLiveVideoConfig.getVideoHeight(), alaLiveVideoConfig.getBitStream(), this.mVideoRecorder.getVideoFormat().getValue(), 1, 10, this.mPreVideoWidth, this.mPreVideoHeight, 7);
                    }
                    if (initVideoEncoderNative != 0) {
                        BdLog.e("initVideoEncoderNative error. errcode is " + initVideoEncoderNative);
                        errLog(14, "switchToRtcMode 7 initVideoEncoderNative error. errcode is " + initVideoEncoderNative);
                        this.mStreamMode = i3;
                        return false;
                    }
                }
                if (this.mNdkAdapter.getNativeObject() != 0) {
                    this.mNdkAdapter.initRtcRoomInfoNative(this.mRtcConfig.mRoomId, this.mRtcConfig.mLineIndex, this.mRtcConfig.mUId, this.mRecordUrl);
                    this.mNdkAdapter.setRtcConfig(this.mRtcConfig.mHandshakeTimeout, this.mRtcConfig.mHeartInterval, this.mRtcConfig.mHeartTimeout, this.mRtcConfig.mCloseTimeout);
                }
                this.mIsDeviceRun = true;
                this.mIsRecordStoped = false;
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
                resetDummyCapture();
            }
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

    private void changeVideoRecorderType(VideoRecorderType videoRecorderType, boolean z) {
        if (this.mVideoRecorderType != null) {
            if (!z || this.mVideoRecorderType.equals(videoRecorderType)) {
                stopVideoRecord();
                this.mVideoRecorder.release();
                this.mVideoRecorderType = videoRecorderType;
                this.mVideoRecorder = new AlaLiveSession(this.mActivity);
                this.mVideoRecorder.init(this.mVideoRecorderType, this.mBeautyType);
                this.mVideoRecorder.setVideoConfig(this.mVideoConfig);
                setPushMirror(this.mIsMirror);
                this.mVideoRecorder.setVideoDataCallback(this.mVideoDataCallBack);
                if (videoRecorderType == VideoRecorderType.SCREEN && !this.mIsDeviceRun) {
                    this.mIsBackground = false;
                    if (this.mCurrentPushState == 1) {
                        if (this.mNdkAdapter.getNativeObject() == 0) {
                            int initRecordNative = this.mNdkAdapter.initRecordNative(this, 1, 0);
                            if (initRecordNative != 0) {
                                BdLog.e("initRecordNative error. errcode is " + initRecordNative);
                                errLog(14, "changeVideoRecorderType 8 initRecordNative error. errcode is " + initRecordNative);
                                return;
                            }
                            startPushForCommon(this.mRecordUrl);
                            return;
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
                errLog(14, "initPKPlayer error. errcode is " + initPKPlayer);
            }
        }
        return this.mPKPlayer.createPlayer();
    }

    public void onFocus(int i, int i2, int i3, int i4) {
        if (this.mVideoRecorder != null) {
            this.mVideoRecorder.onFocus(i, i2, i3, i4);
        }
    }

    public void onExposure(float f) {
        if (this.mVideoRecorder != null) {
            this.mVideoRecorder.onExposure(f);
        }
    }

    public float getExposure() {
        if (this.mVideoRecorder != null) {
            return this.mVideoRecorder.getExposure();
        }
        return -1.0f;
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
        this.mCmdData.mGameHardEncode = true;
        this.mCmdData.type = this.mVideoRecorderType;
        this.mCmdData.mCurStreamLevel = this.mCurStreamLevel;
        this.mCmdData.mDebugInfo = this.mLiveDebugInfo;
        this.mCmdData.ip = getPushStreamIp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runSetSendCmdFlag(boolean z) {
        if (this.mMainHandler != null) {
            if (!this.mIsCameraOpened) {
                this.mMainHandler.postDelayed(this.mRunnableSendCmdFlag, 5000L);
                return;
            }
            if (z) {
                this.mMainHandler.removeCallbacks(this.mRunnableSendCmdFlag);
            }
            if (this.mHasVideo) {
                this.mNoVideoExceptions = 0L;
            } else {
                this.mNoVideoExceptions++;
            }
            if (this.mNoVideoExceptions == 3 && this.mRecordCallback != null) {
                if (this.mStreamMode != 3) {
                    this.mRecordCallback.onError(4, "Stream Exception");
                }
                BdLog.e("mRecordCallback.onError no video streams");
            }
            this.mHasVideo = false;
            this.mMainHandler.postDelayed(this.mRunnableSendCmdFlag, 5000L);
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
                    int[] iArr = new int[1];
                    int[] iArr2 = new int[1];
                    float streamStateNative = this.mNdkAdapter.getStreamStateNative(iArr, iArr2);
                    double d = 0.0d;
                    if (iArr2[0] > 0) {
                        d = iArr[0] / iArr2[0];
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
                        if (iArr[0] > 0 && this.mVideoRecorder != null) {
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
        if (this.mMainHandler != null) {
            this.mMainHandler.removeCallbacks(this.mRunnableSendCmdFlag);
        }
    }

    private void stopVideoRecord() {
        this.mVideoRecorder.stopRecord();
    }

    public void setPreDetectedBestDns(String str, String str2) {
        this.mPushHost = str;
        this.mPushBestIp = str2;
    }

    public String getPushUrl() {
        return this.mRecordUrl;
    }

    public void setPushUrl(String str) {
        this.mRecordUrl = str;
    }

    public int startPush() {
        if (TextUtils.isEmpty(this.mRecordUrl)) {
            return -1;
        }
        return startPush(this.mRecordUrl);
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
            this.mNdkAdapter.sendNativeStatAppData("perf", str, 1);
            this.mNdkAdapter.sendNativeStatAppData(AlaConstants.STAT_FIRST_FRAME, str2, 1);
            this.mNdkAdapter.sendNativeStatAppData(AlaConstants.STAT_DELAY_OFF, str3, 1);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(AlaConstants.STAT_VIDEO_WITH, this.mVideoConfig.getVideoWidth());
                jSONObject.put(AlaConstants.STAT_VIDEO_HEIGHT, this.mVideoConfig.getVideoHeight());
                jSONObject.put(AlaConstants.STAT_VIDEO_GOP, this.mVideoConfig.getVideoGOP() * this.mVideoConfig.getVideoFPS());
                jSONObject.put(AlaConstants.STAT_VIDEO_BFRAME, 0);
                this.mNdkAdapter.sendNativeStatAppData(AlaConstants.STAT_VIDEO_INFO, jSONObject.toString(), 1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void setRoomInfo(String str) {
        if (this.mNdkAdapter != null && this.mNdkAdapter.getNativeObject() != 0) {
            this.mNdkAdapter.sendNativeStatAppData(AlaConstants.STAT_ROOM_INFO, str, 1);
        }
    }

    public int initX264Only() {
        int initVideoEncoderNative;
        if (this.mNdkAdapter != null && this.mNdkAdapter.getNativeObject() != 0) {
            if (this.mVideoConfig.getEncoderType() == 1) {
                initVideoEncoderNative = 0;
            } else {
                initVideoEncoderNative = this.mNdkAdapter.initVideoEncoderNative(this.mVideoConfig.isLandscape() ? this.mVideoConfig.getVideoHeight() : this.mVideoConfig.getVideoWidth(), this.mVideoConfig.isLandscape() ? this.mVideoConfig.getVideoWidth() : this.mVideoConfig.getVideoHeight(), this.mVideoRecorder.getBitRate(), 3, this.mVideoConfig.getVideoGOP(), this.mVideoConfig.getVideoFPS(), this.mPreVideoWidth, this.mPreVideoHeight, this.mVideoConfig.getVideoCodecId());
            }
            this.mNdkAdapter.syncStatConfig(this.mStatConfig.mSavePath, this.mStatConfig.mUploadUrl, this.mStatConfig.mEnable);
            this.mNdkAdapter.setDebugMonitor(true, 5);
            BdLog.d("initVideoEncoderNative " + initVideoEncoderNative);
            if (initVideoEncoderNative != 0) {
                BdLog.e("initVideoEncoderNative error. errcode is " + initVideoEncoderNative);
                errLog(14, "initVideoEncoderNative 9 error. errcode is " + initVideoEncoderNative);
                stopAll(true, true);
                return initVideoEncoderNative;
            }
            return 0;
        }
        BdLog.d("initCodecs mNdkAdapter.getNativeObject() == 0");
        errLog(14, "initCodecs mNdkAdapter.getNativeObject() == 0");
        return -1;
    }

    private int initCodecs() {
        int initVideoEncoderNative;
        if (this.mNdkAdapter != null && this.mNdkAdapter.getNativeObject() != 0) {
            if (this.mVideoConfig.getEncoderType() == 1) {
                initVideoEncoderNative = 0;
            } else {
                initVideoEncoderNative = this.mNdkAdapter.initVideoEncoderNative(this.mVideoConfig.isLandscape() ? this.mVideoConfig.getVideoHeight() : this.mVideoConfig.getVideoWidth(), this.mVideoConfig.isLandscape() ? this.mVideoConfig.getVideoWidth() : this.mVideoConfig.getVideoHeight(), this.mVideoRecorder.getBitRate(), this.mVideoRecorder.getVideoFormat().getValue(), this.mVideoConfig.getVideoGOP(), this.mVideoConfig.getVideoFPS(), this.mPreVideoWidth, this.mPreVideoHeight, this.mVideoConfig.getVideoCodecId());
            }
            this.mNdkAdapter.syncStatConfig(this.mStatConfig.mSavePath, this.mStatConfig.mUploadUrl, this.mStatConfig.mEnable);
            this.mNdkAdapter.setDebugMonitor(true, 5);
            BdLog.d("initVideoEncoderNative " + initVideoEncoderNative);
            if (initVideoEncoderNative != 0) {
                BdLog.e("initVideoEncoderNative error. errcode is " + initVideoEncoderNative);
                errLog(14, "initVideoEncoderNative 9 error. errcode is " + initVideoEncoderNative);
                stopAll(true, true);
                return initVideoEncoderNative;
            }
            runSetSendCmdFlag(true);
            int initAudioEncoderNative = this.mNdkAdapter.initAudioEncoderNative(44100, 1, 16);
            if (initAudioEncoderNative != 0) {
                BdLog.e("initAudioEncoderNative error. errocde is " + initAudioEncoderNative);
                errLog(14, "initAudioEncoderNative 10 error. errcode is " + initAudioEncoderNative);
                stopAll(true, true);
                return initAudioEncoderNative;
            }
            return 0;
        }
        BdLog.d("initCodecs mNdkAdapter.getNativeObject() == 0");
        errLog(14, "initCodecs mNdkAdapter.getNativeObject() == 0");
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int prepareNative(final boolean z) {
        this.mExecService.submit(new Runnable() { // from class: com.baidu.ala.recorder.AlaLiveRecorder.7
            @Override // java.lang.Runnable
            public void run() {
                int startNative;
                if (!AlaLiveRecorder.this.mExecService.isShutdown()) {
                    if (z) {
                        startNative = AlaLiveRecorder.this.mNdkAdapter.restartNative(AlaLiveRecorder.this.mRecordUrl);
                        if (startNative != 0) {
                            BdLog.e("restartNative error:" + startNative);
                            AlaLiveRecorder.this.errLog(14, "restartNative error:" + startNative);
                        }
                        AlaLiveRecorder.log(BdStatsConstant.StatsType.ERROR, "restartnative", "errcode", Integer.valueOf(startNative), "curnet", BdNetTypeUtil.netTypeNameInLowerCase(), "puship", AlaLiveRecorder.this.getPushStreamIp());
                    } else {
                        AlaLiveRecorder.this.mNdkAdapter.setPreDetectedBestDns(AlaLiveRecorder.this.mPushHost, AlaLiveRecorder.this.mPushBestIp);
                        startNative = AlaLiveRecorder.this.mNdkAdapter.startNative(AlaLiveRecorder.this.mRecordUrl, AlaLiveRecorder.this.getNetworkState(), AlaLiveRecorder.this.mStartBaseInfo.toJsonString());
                        if (startNative != 0) {
                            BdLog.e("startNative error:" + startNative);
                            AlaLiveRecorder.this.errLog(14, "startNative error:" + startNative);
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

    public void initAudioReSample(int i, int i2, int i3, int i4, int i5, int i6) {
        if (this.mNdkAdapter != null) {
            this.mNdkAdapter.initAudioReSample(i, i2, i3, i4, i5, i6);
        }
    }

    public int audioReSample(byte[] bArr, int i, byte[] bArr2, int i2) {
        if (this.mNdkAdapter != null) {
            return this.mNdkAdapter.audioReSample(bArr, i, bArr2, i2);
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
            int startNative = this.mNdkAdapter.startNative(this.mRtcConfig.getRtcUrl(), getNetworkState(), this.mStartBaseInfo.toJsonString());
            if (startNative != 0) {
                errLog(14, "startNative fail  11 ret " + startNative);
                BdLog.e("startNative fail");
            }
        }
        startDevices();
        this.mHasSendRtcConnected = false;
        this.mRtcStreamStatus = 0;
        return 0;
    }

    public int startPushForTest(String str) {
        if (this.mStreamMode == 2 || str == null || this.mCurrentPushState == 1) {
            return 0;
        }
        this.mCurrentPushState = 1;
        this.mStartBaseInfo.mStreamType = AlaLiveBaseInfo.STREAM_TYPE_SEND;
        this.mStartBaseInfo.mPkId = null;
        this.mRecorderLog.setPushConfig(AlaRecorderLog.Protocol.RTMP, str);
        int initX264Only = initX264Only();
        if (initX264Only < 0) {
            BdLog.e("startPushForCommon initCodec error !!");
            errLog(14, "startPushForCommon initCodec error ret =  " + initX264Only);
            return -1;
        }
        this.mRecordUrl = str;
        prepareNative(false);
        return 0;
    }

    private int startPushForCommon(String str) {
        if (this.mStreamMode == 2 || str == null || this.mCurrentPushState == 1) {
            return 0;
        }
        this.mCurrentPushState = 1;
        this.mStartBaseInfo.mStreamType = AlaLiveBaseInfo.STREAM_TYPE_SEND;
        this.mStartBaseInfo.mPkId = null;
        this.mRecorderLog.setPushConfig(AlaRecorderLog.Protocol.RTMP, str);
        int initCodecs = initCodecs();
        if (initCodecs < 0) {
            BdLog.e("startPushForCommon initCodec error !!");
            errLog(14, "startPushForCommon initCodec error ret =  " + initCodecs);
            return -1;
        }
        this.mRecordUrl = str;
        startAudioDevice();
        if (!this.mIsBackground) {
            startVideoDevice();
        }
        this.mIsDeviceRun = true;
        prepareNative(false);
        return 0;
    }

    private void stopAll(boolean z, boolean z2) {
        if (this.mSendHandler != null) {
            this.mSendHandler.removeCallbacksAndMessages(null);
        }
        if (this.mNdkAdapter.getNativeObject() != 0) {
            this.mNdkAdapter.sendNativeStatAppData(AlaConstants.STAT_AR_INFO, AlaDataModel.getInstance().getData(AlaDataModel.ALA_DATA_BEAUTY_PARAMS_KEYS), 1);
        }
        this.mCurrentPushState = 2;
        stopDevices(z);
        stopNative(z2);
    }

    public void release() {
        if (this.mVideoRecorder != null) {
            this.mVideoRecorder.willSwitchSense(0);
        }
        stopAll(true, true);
        if (this.mAudioRecorder != null) {
            this.mAudioRecorder.onDestroy();
            this.mAudioRecorder = null;
        }
        ArCache.setDuSticker(null);
        this.mExecService.shutdown();
        if (this.mMainHandler != null) {
            this.mMainHandler.removeCallbacksAndMessages(null);
        }
        if (this.mSendThread != null && this.mSendThread.getLooper() != null) {
            this.mSendThread.getLooper().quit();
            this.mSendThread = null;
        }
        this.mActivity = null;
        BdNetTypeUtil.removeNetWorkChangedListener(this.mNetworkChangedListener);
        this.mNetworkChangedListener = null;
        if (this.mMainHandler != null) {
            this.mMainHandler.removeCallbacksAndMessages(null);
        }
        try {
            TbadkCoreApplicationProxy.getInst().release();
        } catch (Exception e) {
            e.printStackTrace();
        }
        EncodePerformanceHelper.release();
        this.mRecorderLog.pushEnd();
        this.mRecorderErrorCallback = null;
        this.mOnPixelReadCallback = null;
    }

    private void startDevices() {
        this.mIsDeviceRun = true;
        startVideoDevice();
        startAudioDevice();
    }

    private void startAudioDevice() {
        if (this.isEnableExternalAudioCapture) {
            Log.i(LOG_TAG, "startAudioDevice fail, use External audio Capture Device");
            return;
        }
        if (this.mAudioRecorder != null) {
            this.mAudioRecorder.stop();
        }
        if (this.mStreamMode == 1) {
            this.mAudioRecorder.onCreate(new AlaAudioConfig());
            this.mAudioRecorder.mute(this.mIsMute);
        } else if (this.mStreamMode == 2) {
            AlaAudioConfig alaAudioConfig = new AlaAudioConfig(StreamConfig.Audio.AUDIO_RTC_FREQUENCY_48K, 16, 2);
            this.mAudioRecorder.mute(this.mIsMute);
            this.mAudioRecorder.onCreate(alaAudioConfig);
        }
        if (this.mAudioRecorder == null) {
            BdLog.d("mAudioRecorder construct error !!!");
            return;
        }
        boolean start = this.mAudioRecorder.start();
        if (this.mVideoRecorder != null && this.mVideoRecorder.getRecorderHandler() != null) {
            this.mVideoRecorder.getRecorderHandler().sendAudioOpened(start);
        }
        if (!start) {
            BdLog.e("mAudioRecorder start failed");
            errLog(14, "mAudioRecorder start failed ");
            stopNative(false);
        }
    }

    private void startVideoDevice() {
        if (this.mVideoRecorder == null) {
            this.mVideoRecorder = new AlaLiveSession(this.mActivity);
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

    private synchronized void stopAudioDevice() {
        if (this.mAudioRecorder != null) {
            this.mAudioRecorder.stop();
        }
    }

    private void stopVideoDevice() {
        if (this.mVideoRecorder != null) {
            stopVideoRecord();
        }
    }

    private void stopDevices(boolean z) {
        this.mIsDeviceRun = false;
        stopAudioDevice();
        stopVideoDevice();
        if (this.mVideoRecorder != null && z) {
            this.mVideoRecorder.release();
        }
        log("action", "stopDevices");
    }

    private void stopNative(boolean z) {
        final AlaNDKRecorderAdapter alaNDKRecorderAdapter = new AlaNDKRecorderAdapter();
        alaNDKRecorderAdapter.setNativeObject(this.mNdkAdapter.getNativeObject());
        Runnable runnable = new Runnable() { // from class: com.baidu.ala.recorder.AlaLiveRecorder.9
            @Override // java.lang.Runnable
            public void run() {
                if (alaNDKRecorderAdapter.getNativeObject() != 0) {
                    if (AlaLiveRecorder.this.mPKPlayer != null) {
                        AlaLiveRecorder.this.mPKPlayer.stopPlay();
                        AlaLiveRecorder.this.mPKPlayer.destroy();
                        AlaLiveRecorder.this.mPKPlayer = null;
                    }
                    int stopNative = alaNDKRecorderAdapter.stopNative();
                    if (stopNative != 0) {
                        BdLog.e("stopNative error:" + stopNative);
                        AlaLiveRecorder.this.errLog(16, "stopNative error:" + stopNative);
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
        deRegisterNativeObject();
    }

    public void setUseDummyAudioCapture(boolean z) {
        if (this.mAudioRecorder != null) {
            this.mAudioRecorder.setDummyCapture(z);
            AlaDataModel.getInstance().putData(AlaDataModel.ALA_DATA_DUMMY_AUDIO_KEYS, z ? "1" : "0");
        }
    }

    public void setUseDummyVideoCapture(boolean z) {
        if (this.mVideoRecorder != null) {
            this.mVideoRecorder.setUseDummyCapture(z);
            AlaDataModel.getInstance().putData(AlaDataModel.ALA_DATA_DUMMY_VIDEO_KEYS, z ? "1" : "0");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x003f, code lost:
        if (java.lang.Integer.parseInt(r3) > 0) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void resetDummyCapture() {
        boolean z;
        boolean z2 = true;
        if (this.mStreamMode == 2) {
            if (this.mVideoRecorder != null) {
                this.mVideoRecorder.setUseDummyCapture(false);
            }
            if (this.mAudioRecorder != null) {
                this.mAudioRecorder.setDummyCapture(false);
            }
        } else if (this.mStreamMode == 1) {
            try {
                String data = AlaDataModel.getInstance().getData(AlaDataModel.ALA_DATA_DUMMY_VIDEO_KEYS);
                z = Integer.parseInt(AlaDataModel.getInstance().getData(AlaDataModel.ALA_DATA_DUMMY_VIDEO_KEYS)) > 0;
                try {
                } catch (Exception e) {
                    e = e;
                    e.printStackTrace();
                    z2 = false;
                    if (this.mVideoRecorder != null) {
                        this.mVideoRecorder.setUseDummyCapture(z);
                    }
                    if (this.mAudioRecorder != null) {
                        this.mAudioRecorder.setDummyCapture(z2);
                    }
                }
            } catch (Exception e2) {
                e = e2;
                z = false;
            }
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
        this.mRecorderLog.markEnterBackground();
        if (this.mNdkAdapter != null && this.mNdkAdapter.getNativeObject() != 0) {
            this.mNdkAdapter.enterBackground();
        }
        if (this.mVideoRecorder.dealBackground()) {
            if (!this.mIsAutoStartFromBack) {
                this.mIsBackground = false;
                return;
            }
            this.mIsBackground = true;
            notifyBackGroundSwitch(this.mIsBackground);
            stopDevices(false);
            if (this.mVideoRecorder != null) {
                this.mVideoRecorder.onPause();
            }
            if (this.mAudioRecorder != null) {
                this.mAudioRecorder.onPause();
            }
        }
    }

    public void enterForeground() {
        this.mRecorderLog.markEnterForeground();
        if (this.mNdkAdapter != null && this.mNdkAdapter.getNativeObject() != 0) {
            this.mNdkAdapter.enterForeground();
        }
        if (this.mVideoRecorder != null) {
            if (this.mVideoRecorder == null || this.mVideoRecorder.dealBackground()) {
                if (this.mAudioRecorder != null) {
                    this.mVideoRecorder.onResume();
                }
                if (this.mAudioRecorder != null) {
                    this.mAudioRecorder.onResume();
                }
                if (!this.mIsAutoStartFromBack) {
                    this.mIsBackground = false;
                    return;
                }
                this.mIsBackground = false;
                notifyBackGroundSwitch(this.mIsBackground);
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
            if (i == 1) {
                this.mRtcStreamStatus = 0;
                if (!this.mHasSendRtcConnected && this.mVideoRecorder != null && this.mVideoRecorder.getRecorderHandler() != null) {
                    this.mHasSendRtcConnected = true;
                    this.mVideoRecorder.getRecorderHandler().sendRtcConnected(this.mRtcStreamStatus);
                }
            } else if (i == 0) {
                this.mRtcStreamStatus = i2;
                if (!this.mHasSendRtcConnected && this.mVideoRecorder != null && this.mVideoRecorder.getRecorderHandler() != null) {
                    this.mHasSendRtcConnected = true;
                    this.mVideoRecorder.getRecorderHandler().sendRtcConnected(this.mRtcStreamStatus);
                }
            }
        }
        if (this.mStreamMode == 1 && this.mVideoRecorder != null) {
            if (i == 1) {
                this.mRecorderLog.setPushStreamIp(getPushStreamIp());
            }
            this.mVideoRecorder.sendNetStateInfo(i, i2);
        }
        if (!BdNetTypeUtil.isNetworkAvailableForImmediately()) {
            BdLog.e("网络不可用，rtmp断开");
        } else if (this.mStreamMode == 1 && i == 0 && this.mMainHandler != null) {
            this.mMainHandler.post(this.mrtmpResponsedRestartRunnable);
        }
    }

    private void sendBufferChanged(int i) {
        if (this.mVideoRecorder != null) {
            this.mVideoRecorder.sendBufferChanged(i);
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

    public void setUserGameHardEncode(boolean z) {
        this.mCmdData.mGameHardEncode = z;
    }

    public void removeRecorderCallback(RecorderCallback recorderCallback) {
        if (recorderCallback != null) {
            this.mExternRecordCallbacks.remove(recorderCallback);
        }
    }

    public void setRecorderErrorCallback(RecorderErrorCallback recorderErrorCallback) {
        this.mRecorderErrorCallback = recorderErrorCallback;
    }

    protected static void log(Object... objArr) {
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

    @Override // com.baidu.ala.recorder.video.camera.ICameraStatusHandler.Beauty
    public void setBeauty(int i) {
        this.mVideoRecorder.setBeauty(i);
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraStatusHandler.Beauty
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
        if (this.mVideoRecorderType == VideoRecorderType.SCREEN && this.mIsDeviceRun) {
            int currentBitRate = this.mVideoConfig.getCurrentBitRateConfig().getCurrentBitRate();
            if (this.mStreamMode == 2) {
                this.mNdkAdapter.updateVCodeParamNative(this.mVideoRecorder.getOutputWidth(), this.mVideoRecorder.getOutputHeight(), currentBitRate, this.mVideoRecorder.getVideoFormat().getValue(), 1, 10, this.mPreVideoWidth, this.mPreVideoHeight);
            } else if (this.mStreamMode == 1) {
                this.mNdkAdapter.updateVCodeParamNative(this.mVideoRecorder.getOutputWidth(), this.mVideoRecorder.getOutputHeight(), currentBitRate, this.mVideoRecorder.getVideoFormat().getValue(), this.mVideoConfig.getVideoGOP(), this.mVideoConfig.getVideoFPS(), this.mPreVideoWidth, this.mPreVideoHeight);
            }
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

    public void onOrientationChanged() {
        this.mVideoRecorder.onBeautyTypeChanged(this.mBeautyType);
    }

    public VideoBeautyType getBeautyType() {
        return this.mBeautyType;
    }

    public void onBeautyParamsChanged(float f, HashMap<String, Object> hashMap) {
        if (this.mVideoRecorder != null) {
            this.mVideoRecorder.onBeautyParamsChanged(f, hashMap);
        }
    }

    public void onBeautyParamsChanged(String str, Object obj) {
        if (this.mVideoRecorder != null) {
            this.mVideoRecorder.onBeautyParamsChanged(str, obj);
        }
    }

    /* loaded from: classes14.dex */
    class SendDataInfo {
        public byte[] data;
        public int displayRotate;
        public int length;
        public int lineSize;
        public long timestamp;

        SendDataInfo() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public class SendHandler extends Handler {
        public SendHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    SendDataInfo sendDataInfo = (SendDataInfo) message.obj;
                    AlaLiveRecorder.this.sendAndEncodeDataReal(sendDataInfo.data, sendDataInfo.length, sendDataInfo.displayRotate, sendDataInfo.lineSize, sendDataInfo.timestamp);
                    return;
                default:
                    return;
            }
        }
    }

    public int setX264Config(int i, String str, String str2) {
        return this.mNdkAdapter.setX264ConfigToNative(i, str, str2);
    }

    public void setFrameReport(EncodePerformanceHelper.FrameReport frameReport) {
        EncodePerformanceHelper.getInst().setFrameReport(frameReport);
    }

    public void sendAndEncodeDataReal(byte[] bArr, int i, int i2, int i3, long j) {
        if (this.mNdkAdapter != null && this.mNdkAdapter.getNativeObject() != 0) {
            int i4 = 0;
            String str = null;
            if (this.mIsSendCmd) {
                fillCmdData();
                str = AlaLiveStreamCmdInfo.genCmd(this.mActivity, this.mCmdData);
                this.mIsSendCmd = false;
            }
            if (this.mNdkAdapter != null && this.mNdkAdapter.getNativeObject() != 0) {
                EncodePerformanceHelper.getInst().before();
                i4 = this.mNdkAdapter.sendYuvDataNative(bArr, i, i2, i3, j, j, str, this.mVideoConfig.getVideoCodecId());
                EncodePerformanceHelper.getInst().after();
            }
            if (i4 != 0) {
                this.mSendDataErrorCount++;
                if (this.mSendDataErrorCount < 5) {
                    log(BdStatsConstant.StatsType.ERROR, "sendYuvData", "errcode", Integer.valueOf(i4), "curnet", BdNetTypeUtil.netTypeNameInLowerCase(), "puship", getPushStreamIp());
                    if (i4 != -7) {
                        errLog(17, "sendYuvData error ret " + i4);
                    }
                }
                if (this.mSendDataErrorCount > 20 && this.mSendDataErrorCount < 40) {
                    errLog(17, "sendYuvData error ret " + i4);
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

    @Override // com.baidu.ala.recorder.video.camera.ICameraStatusHandler.Beauty
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
        if (this.mAudioRecorder != null) {
            this.mAudioRecorder.mute(z);
        }
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

    /* JADX INFO: Access modifiers changed from: private */
    public void errLog(int i, String str) {
        if (this.mVideoRecorder != null) {
            this.mVideoRecorder.sendError(i, str);
        }
    }

    public AlaRecorderLog getRecorderLog() {
        return this.mRecorderLog;
    }
}
