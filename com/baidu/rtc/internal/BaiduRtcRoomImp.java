package com.baidu.rtc.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.media.MediaCodec;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.media.session.MediaSessionCompat;
import android.util.Log;
import android.view.Surface;
import androidx.core.view.DisplayCompat;
import com.baidu.cloudbase.audiofilter.AudioFilter;
import com.baidu.cloudbase.plugin.DownSoHelper;
import com.baidu.rtc.BaiduRtcRoom;
import com.baidu.rtc.CommonDefine;
import com.baidu.rtc.JanusConnection;
import com.baidu.rtc.JanusHandle;
import com.baidu.rtc.JanusRTCInterface;
import com.baidu.rtc.PeerConnectionClient;
import com.baidu.rtc.RTCAudioSamples;
import com.baidu.rtc.RTCVideoCapture;
import com.baidu.rtc.RTCVideoExternalRender;
import com.baidu.rtc.RTCVideoExternalRenderImp;
import com.baidu.rtc.RTCVideoView;
import com.baidu.rtc.RtcParameterSettings;
import com.baidu.rtc.WebSocketChannel;
import com.baidu.rtc.logreport.CpuMonitor;
import com.baidu.rtc.logreport.ErrorInfoReport;
import com.baidu.rtc.logreport.HUDStatistics;
import com.baidu.rtc.logreport.RtcLogReport;
import com.baidu.rtc.logreport.SLIReportInterface;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.sapi2.activity.IdCardOcrCameraActivity;
import com.baidu.searchbox.live.interfaces.ILiveNPSPlugin;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.TbEnum;
import com.heytap.mcssdk.mode.CommandMessage;
import com.kwai.video.player.KsMediaMeta;
import d.a.k.c.b;
import d.a.k.d.a;
import d.a.k.d.b;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.webrtc.Camera1Enumerator;
import org.webrtc.Camera2Enumerator;
import org.webrtc.CameraEnumerator;
import org.webrtc.CameraVideoCapturer;
import org.webrtc.EglBase;
import org.webrtc.EglBase_CC;
import org.webrtc.IceCandidate;
import org.webrtc.SessionDescription;
import org.webrtc.StatsReport;
import org.webrtc.VideoCapturer;
import org.webrtc.VideoFrame;
import org.webrtc.VideoSink;
import org.webrtc.VideoTrack;
import org.webrtc.audio.JavaAudioDeviceModule;
/* loaded from: classes2.dex */
public class BaiduRtcRoomImp extends BaiduRtcRoom implements JanusRTCInterface, PeerConnectionClient.PeerConnectionEvents {
    public static final String BRTC_SDK_VERSION_PREFIX = "BRTC.Android.SDK V";
    public static final int COMMUNICATION_REPORT_INTERVAL = 2000;
    public static int DEFAULT_CAMERA_ID = -1;
    public static final int DEVICEINFO_REPORT_INTERVAL = 300000;
    public static int MAX_VIDEOVIEW_CNT = 30;
    public static final int SLI_REPORT_INTERVAL = 5000;
    public static final String TAG = "BaiduRtcRoomImp";
    public static ConcurrentHashMap<String, String> mCameraUsingMap = new ConcurrentHashMap<>();
    public static int mConfigAudioContenttype = 1;
    public static boolean mbEnableDebugLog = false;
    public int bluetoothOpSeq;
    public Boolean disableBuiltInAGC;
    public Boolean disableBuiltInNS;
    public RTCAudioSamples.RTCExternalSamplesReadyCallback externalSamplesReadyCallback;
    public Boolean isBluetoothOn;
    public boolean isEnableHighProfileConfirm;
    public String mAppId;
    public AudioFilter mAudioFilter;
    public WeakReference<Context> mContext;
    public CpuMonitor mCpuMonitor;
    public String mCpuType;
    public String mDisplayName;
    public HeadsetReceiver mHeadSetReceiver;
    public boolean mIsEnableSoLaterLoad;
    public boolean mIsLoginSuccess;
    public boolean mIsSoDownloaded;
    public BaiduRtcRoom.RtcLiveTransferMode mLastLssMode;
    public String mLastLssURL;
    public long mLoginSuccessTime;
    public b mOnMixedFrameUpdateListener;
    public JavaAudioDeviceModule.RemoteSamplesReadyCallback mRemoteSamplesInternalCallback;
    public ConcurrentHashMap<BigInteger, StreamStats> mRemoteStreamStats;
    public String mRoomName;
    public JavaAudioDeviceModule.SamplesReadyCallback mSamplesReadyInternalCallback;
    public d.a.k.d.b mSoCallback;
    public Context mSoContext;
    public Thread mSoDownloadThread;
    public String mSoLaterLoadUrl;
    public long mStartLoginTime;
    public long mUserId;
    public VideoSink mVideoSink;
    public WebSocketChannel mWebSocketChannel;
    public Runnable reportDeviceInfoRun;
    public EglBase rootEglBase;
    public RtcLogReport rtcLogReport;
    public boolean mIsEnableExternalVideoCapturer = false;
    public boolean mIsEnableExternalAudioRecord = false;
    public boolean mEnableAudioMix = false;
    public volatile PeerConnectionClient peerConnectionClient = null;
    public PeerConnectionClient.PeerConnectionParameters peerConnectionParameters = null;
    public RTCVideoView mLocalRender = null;
    public RTCVideoView[] mRemoteRenderList = null;
    public VideoCapturer videoCapturer = null;
    public String mJanusServerURL = "wss://rtc.exp.bcelive.com/janus";
    public int mRemoteVideoCnt = 0;
    public boolean mUsingFrontCamera = true;
    public boolean[] mHasVideoView = new boolean[MAX_VIDEOVIEW_CNT];
    public AudioManager audioManager = null;
    public int mRemoteFilterTrack = -1;
    public BaiduRtcRoom.BaiduRtcRoomDelegate mBaiduRtcRoomDelegate = null;
    public RTCAudioSamples.RTCSamplesReadyCallback mSamplesReadyCallback = null;
    public RTCAudioSamples.RTCRemoteSamplesReadyCallback mRemoteSamplesCallback = null;
    public RTCAudioSamples.RTCMixedSamplesReadyCallback mMixedSamplesCallback = null;
    public ConcurrentHashMap<Long, RTCVideoExternalRender> mUserIdVideoRendererMap = new ConcurrentHashMap<>();
    public IdentityHashMap<Long, RTCVideoExternalRender> mPendingRemoveRendererMap = new IdentityHashMap<>();
    public boolean mVideoCaptureIsFrontCamera = false;
    public int mCameraID = DEFAULT_CAMERA_ID;
    public RtcParameterSettings mParamSettings = new RtcParameterSettings();
    public Handler mHandler = new Handler(Looper.getMainLooper());
    public BigInteger mPublisherHandle = null;
    public volatile long mLastLeavingId = 0;
    public volatile long mLastGoneId = 0;
    public ConcurrentHashMap<BigInteger, BigInteger> mFeedToViewMap = new ConcurrentHashMap<>();
    public boolean mbOnStatistics = true;
    public double mgoogAvailableSendBandwidth = 200.0d;
    public boolean mIsEnablePushQualityMonitor = false;
    public boolean mIsEnablePullQualityMonitor = false;
    public boolean mIsEnableErrorInfoMonitor = true;
    public boolean mIsUseDefaultErrorInfoMonitor = true;
    public String mErrorInfoMonitorEnv = "online";
    public String mQualityMonitorEnv = "online";
    public ConcurrentHashMap<BigInteger, HUDStatistics> mHUDStatisticsMap = new ConcurrentHashMap<>();
    public boolean mbStartReportDI = false;
    public boolean mIsAsListener = true;
    public boolean mIsAsPublisher = true;
    public boolean mIsCompulsive = false;
    public boolean mIsStreamPublish = false;

    /* renamed from: com.baidu.rtc.internal.BaiduRtcRoomImp$25  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass25 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$rtc$RtcParameterSettings$RtcParamSettingType;

        static {
            int[] iArr = new int[RtcParameterSettings.RtcParamSettingType.values().length];
            $SwitchMap$com$baidu$rtc$RtcParameterSettings$RtcParamSettingType = iArr;
            try {
                iArr[RtcParameterSettings.RtcParamSettingType.RTC_PARAM_SETTINGS_ALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$rtc$RtcParameterSettings$RtcParamSettingType[RtcParameterSettings.RtcParamSettingType.RTC_VIDEO_PARAM_SETTINGS_BITRATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$baidu$rtc$RtcParameterSettings$RtcParamSettingType[RtcParameterSettings.RtcParamSettingType.RTC_VIDEO_PARAM_SETTINGS_RENDER_MODE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public class AudioStuckEvent implements SLIReportInterface {
        public AudioStuckEvent() {
        }

        @Override // com.baidu.rtc.logreport.SLIReportInterface
        public void onStuckData(long j, long j2) {
            BaiduRtcRoomImp baiduRtcRoomImp = BaiduRtcRoomImp.this;
            if (baiduRtcRoomImp.mIsEnablePullQualityMonitor) {
                for (Map.Entry entry : baiduRtcRoomImp.mHUDStatisticsMap.entrySet()) {
                    if (entry.getKey() != BaiduRtcRoomImp.this.mPublisherHandle && entry.getValue() != null) {
                        ((HUDStatistics) entry.getValue()).addAudioStuckData(j, j2);
                        if (BaiduRtcRoomImp.this.mIsEnableErrorInfoMonitor) {
                            long j3 = j2 - j;
                            if (j3 > 200) {
                                BigInteger valueOf = BigInteger.valueOf(0L);
                                if (BaiduRtcRoomImp.this.mWebSocketChannel != null) {
                                    valueOf = BaiduRtcRoomImp.this.mWebSocketChannel.getFeedByHandle((BigInteger) entry.getKey());
                                }
                                ErrorInfoReport.getInstance().reportErrorInfo(ErrorInfoReport.ErrorCode.AUDIO_STUCK, j3, (BigInteger) entry.getKey(), valueOf);
                            }
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class HeadsetReceiver extends BroadcastReceiver {
        public HeadsetReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            BaiduRtcRoomImp baiduRtcRoomImp;
            BaiduRtcRoom.RtcSoundMode rtcSoundMode;
            if (BaiduRtcRoomImp.this.audioManager == null) {
                BaiduRtcRoomImp baiduRtcRoomImp2 = BaiduRtcRoomImp.this;
                baiduRtcRoomImp2.audioManager = (AudioManager) ((Context) baiduRtcRoomImp2.mContext.get()).getSystemService("audio");
            }
            String action = intent.getAction();
            if ("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED".equals(action)) {
                int intExtra = intent.getIntExtra("android.bluetooth.profile.extra.STATE", -1);
                if (intExtra != 0) {
                    if (intExtra == 2) {
                        final int access$3404 = BaiduRtcRoomImp.access$3404(BaiduRtcRoomImp.this);
                        BaiduRtcRoomImp.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.rtc.internal.BaiduRtcRoomImp.HeadsetReceiver.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (access$3404 == BaiduRtcRoomImp.this.bluetoothOpSeq) {
                                    BaiduRtcRoomImp.this.setBluetoothScoOn(Boolean.TRUE);
                                    BaiduRtcRoomImp.this.setSoundMod(BaiduRtcRoom.RtcSoundMode.RTC_SOUND_MODE_EAR);
                                }
                            }
                        }, 1500L);
                        Log.i(BaiduRtcRoomImp.TAG, "Bluetooth headset connected");
                        return;
                    }
                    return;
                }
                Log.i(BaiduRtcRoomImp.TAG, "Bluetooth headset not disconnected");
                BaiduRtcRoomImp.this.setBluetoothScoOn(Boolean.FALSE);
                BaiduRtcRoomImp.access$3408(BaiduRtcRoomImp.this);
                if (BaiduRtcRoomImp.this.audioManager.isWiredHeadsetOn()) {
                    return;
                }
            } else if (intent.getAction().equals("android.intent.action.HEADSET_PLUG") && intent.hasExtra("state")) {
                if (intent.getIntExtra("state", -1) != 0 || BaiduRtcRoomImp.this.isHeadsetOn(context)) {
                    if (intent.getIntExtra("state", -1) == 1) {
                        Log.i(BaiduRtcRoomImp.TAG, "headset connected");
                        baiduRtcRoomImp = BaiduRtcRoomImp.this;
                        rtcSoundMode = BaiduRtcRoom.RtcSoundMode.RTC_SOUND_MODE_EAR;
                        baiduRtcRoomImp.setSoundMod(rtcSoundMode);
                    }
                    return;
                }
                Log.i(BaiduRtcRoomImp.TAG, "headset not connected");
            } else if (!"android.bluetooth.adapter.action.STATE_CHANGED".equals(action) || intent.getIntExtra("android.bluetooth.adapter.extra.STATE", Integer.MIN_VALUE) != 10) {
                return;
            } else {
                BaiduRtcRoomImp.access$3408(BaiduRtcRoomImp.this);
                BaiduRtcRoomImp.this.setBluetoothScoOn(Boolean.FALSE);
                if (BaiduRtcRoomImp.this.audioManager.isWiredHeadsetOn()) {
                    return;
                }
            }
            baiduRtcRoomImp = BaiduRtcRoomImp.this;
            rtcSoundMode = BaiduRtcRoom.RtcSoundMode.RTC_SOUND_MODE_SPEAKER;
            baiduRtcRoomImp.setSoundMod(rtcSoundMode);
        }
    }

    /* loaded from: classes2.dex */
    public static class StreamStats {
        public BigInteger handleId;
        public Boolean hasAudio;
        public Boolean hasVideo;
        public String nickName;
        public long userId;
        public int volume = -1;

        public StreamStats(BigInteger bigInteger, long j, Boolean bool, Boolean bool2, String str) {
            this.nickName = "";
            this.handleId = bigInteger;
            this.userId = j;
            this.hasAudio = bool2;
            this.hasVideo = bool;
            this.nickName = str;
        }
    }

    /* loaded from: classes2.dex */
    public class VideoStuckEvent implements SLIReportInterface {
        public BigInteger handleId;

        public VideoStuckEvent(BigInteger bigInteger) {
            this.handleId = bigInteger;
        }

        @Override // com.baidu.rtc.logreport.SLIReportInterface
        public void onStuckData(long j, long j2) {
            HUDStatistics hUDStatistics;
            BaiduRtcRoomImp baiduRtcRoomImp = BaiduRtcRoomImp.this;
            if (!baiduRtcRoomImp.mIsEnablePullQualityMonitor || (hUDStatistics = (HUDStatistics) baiduRtcRoomImp.mHUDStatisticsMap.get(this.handleId)) == null) {
                return;
            }
            hUDStatistics.addVideoStuckData(j, j2);
            if (BaiduRtcRoomImp.this.mIsEnableErrorInfoMonitor) {
                long j3 = j2 - j;
                if (j3 > 600) {
                    BigInteger valueOf = BigInteger.valueOf(0L);
                    if (BaiduRtcRoomImp.this.mWebSocketChannel != null) {
                        valueOf = BaiduRtcRoomImp.this.mWebSocketChannel.getFeedByHandle(this.handleId);
                    }
                    ErrorInfoReport.getInstance().reportErrorInfo(ErrorInfoReport.ErrorCode.VIDEO_STUCK, j3, this.handleId, valueOf);
                }
            }
        }
    }

    public BaiduRtcRoomImp(Context context, String str, String str2, String str3, boolean z) {
        this.mContext = null;
        this.mWebSocketChannel = null;
        this.rootEglBase = null;
        Boolean bool = Boolean.FALSE;
        this.disableBuiltInAGC = bool;
        this.disableBuiltInNS = bool;
        this.mLastLssURL = "";
        this.mHeadSetReceiver = null;
        this.isEnableHighProfileConfirm = false;
        this.mIsLoginSuccess = false;
        this.mRemoteStreamStats = new ConcurrentHashMap<>();
        this.mSoDownloadThread = null;
        this.mIsEnableSoLaterLoad = false;
        this.mIsSoDownloaded = false;
        this.mSoLaterLoadUrl = "";
        this.mCpuType = "armeabi-v7a";
        this.mSoContext = null;
        this.mSoCallback = new b.a() { // from class: com.baidu.rtc.internal.BaiduRtcRoomImp.1
            @Override // d.a.k.d.b
            public void onDownloadFail(String str4, int i2, String str5) {
                Log.d(BaiduRtcRoomImp.TAG, "Failed to download so.");
                if (BaiduRtcRoomImp.this.mIsEnableErrorInfoMonitor) {
                    ErrorInfoReport.getInstance().reportErrorInfo(ErrorInfoReport.ErrorCode.SO_LATER_DOWNLOADING_FAIL);
                }
                BaiduRtcRoom.BaiduRtcRoomDelegate baiduRtcRoomDelegate = BaiduRtcRoomImp.this.mBaiduRtcRoomDelegate;
                if (baiduRtcRoomDelegate != null) {
                    baiduRtcRoomDelegate.onErrorInfoUpdate(400);
                }
            }

            @Override // d.a.k.d.b
            public void onDownloadSuccess(String str4, String str5) {
                BaiduRtcRoom.BaiduRtcRoomDelegate baiduRtcRoomDelegate;
                Log.d(BaiduRtcRoomImp.TAG, "Be successful to download so!");
                String str6 = a.g(BaiduRtcRoomImp.this.mSoContext) + File.separator + "libjingle_peerconnection_so.so";
                Log.d(BaiduRtcRoomImp.TAG, "RTC so path is: " + str6);
                BaiduRtcRoomImp.this.mIsSoDownloaded = true;
                if (DownSoHelper.k(BaiduRtcRoomImp.this.mSoContext).n(a.g(BaiduRtcRoomImp.this.mSoContext))) {
                    try {
                        System.load(str6);
                        Log.d(BaiduRtcRoomImp.TAG, "loaded so, and start to login room.");
                        BaiduRtcRoomImp.this.loginRtcRoomWithRoomName(BaiduRtcRoomImp.this.mRoomName, BaiduRtcRoomImp.this.mUserId, BaiduRtcRoomImp.this.mDisplayName, BaiduRtcRoomImp.this.mIsAsPublisher, BaiduRtcRoomImp.this.mIsAsListener);
                        return;
                    } catch (Throwable th) {
                        Log.d(BaiduRtcRoomImp.TAG, "Failed call System.load to load so! Error: " + th);
                        if (BaiduRtcRoomImp.this.mIsEnableErrorInfoMonitor) {
                            ErrorInfoReport.getInstance().reportErrorInfo(ErrorInfoReport.ErrorCode.SO_LATER_LOADING_FAIL);
                        }
                        baiduRtcRoomDelegate = BaiduRtcRoomImp.this.mBaiduRtcRoomDelegate;
                        if (baiduRtcRoomDelegate == null) {
                            return;
                        }
                    }
                } else {
                    Log.d(BaiduRtcRoomImp.TAG, "call DownSoHelper.getInstance(mSoContext).loadSo() Failed.");
                    Log.d(BaiduRtcRoomImp.TAG, "try call load Full Path.");
                    try {
                        System.load(str6);
                        Log.d(BaiduRtcRoomImp.TAG, "loaded so with full path, and start to login room.");
                        BaiduRtcRoomImp.this.loginRtcRoomWithRoomName(BaiduRtcRoomImp.this.mRoomName, BaiduRtcRoomImp.this.mUserId, BaiduRtcRoomImp.this.mDisplayName, BaiduRtcRoomImp.this.mIsAsPublisher, BaiduRtcRoomImp.this.mIsAsListener);
                        return;
                    } catch (Throwable th2) {
                        Log.d(BaiduRtcRoomImp.TAG, "Failed to load so with full path! Error: " + th2);
                        baiduRtcRoomDelegate = BaiduRtcRoomImp.this.mBaiduRtcRoomDelegate;
                        if (baiduRtcRoomDelegate == null) {
                            return;
                        }
                    }
                }
                baiduRtcRoomDelegate.onErrorInfoUpdate(401);
            }
        };
        this.mSamplesReadyInternalCallback = new JavaAudioDeviceModule.SamplesReadyCallback() { // from class: com.baidu.rtc.internal.BaiduRtcRoomImp.4
            @Override // org.webrtc.audio.JavaAudioDeviceModule.SamplesReadyCallback
            public void onWebRtcAudioRecordSamplesReady(JavaAudioDeviceModule.AudioSamples audioSamples) {
                if (audioSamples == null || audioSamples.getData() == null || audioSamples.getData().length <= 0) {
                    return;
                }
                RTCAudioSamples.RTCSamplesReadyCallback rTCSamplesReadyCallback = BaiduRtcRoomImp.this.mSamplesReadyCallback;
                if (rTCSamplesReadyCallback != null) {
                    rTCSamplesReadyCallback.onRtcAudioRecordSamplesReady(new RTCAudioSamples(audioSamples.getAudioFormat(), audioSamples.getChannelCount(), audioSamples.getSampleRate(), audioSamples.getData()));
                }
                if (!BaiduRtcRoomImp.this.mEnableAudioMix || BaiduRtcRoomImp.this.mIsEnableExternalAudioRecord) {
                    return;
                }
                MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
                bufferInfo.size = audioSamples.getData().length;
                bufferInfo.offset = 0;
                ByteBuffer wrap = ByteBuffer.wrap(audioSamples.getData());
                bufferInfo.presentationTimeUs = System.nanoTime();
                BaiduRtcRoomImp.this.mAudioFilter.e(wrap, bufferInfo);
            }
        };
        this.mRemoteSamplesInternalCallback = new JavaAudioDeviceModule.RemoteSamplesReadyCallback() { // from class: com.baidu.rtc.internal.BaiduRtcRoomImp.5
            @Override // org.webrtc.audio.JavaAudioDeviceModule.RemoteSamplesReadyCallback
            public void onWebRtcAudioRemoteSamplesReady(JavaAudioDeviceModule.AudioSamples audioSamples) {
                if (audioSamples == null) {
                    return;
                }
                RTCAudioSamples.RTCRemoteSamplesReadyCallback rTCRemoteSamplesReadyCallback = BaiduRtcRoomImp.this.mRemoteSamplesCallback;
                if (rTCRemoteSamplesReadyCallback != null) {
                    rTCRemoteSamplesReadyCallback.onRtcAudioRemoteSamplesReady(new RTCAudioSamples(audioSamples.getAudioFormat(), audioSamples.getChannelCount(), audioSamples.getSampleRate(), audioSamples.getData()));
                }
                if (!BaiduRtcRoomImp.this.mEnableAudioMix || BaiduRtcRoomImp.this.mRemoteFilterTrack < 0) {
                    return;
                }
                MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
                bufferInfo.size = audioSamples.getData().length;
                bufferInfo.offset = 0;
                BaiduRtcRoomImp.this.mAudioFilter.f(ByteBuffer.wrap(audioSamples.getData()), bufferInfo, BaiduRtcRoomImp.this.mRemoteFilterTrack);
            }
        };
        this.externalSamplesReadyCallback = new RTCAudioSamples.RTCExternalSamplesReadyCallback() { // from class: com.baidu.rtc.internal.BaiduRtcRoomImp.6
            @Override // com.baidu.rtc.RTCAudioSamples.RTCExternalSamplesReadyCallback
            public void onRtcAudioExternalSamplesReady(RTCAudioSamples rTCAudioSamples) {
                if (BaiduRtcRoomImp.this.peerConnectionClient != null) {
                    JavaAudioDeviceModule.ExternalSamplesReadyCallback externalSamplesCallback = BaiduRtcRoomImp.this.peerConnectionClient.getExternalSamplesCallback();
                    if (externalSamplesCallback != null) {
                        externalSamplesCallback.onWebRtcAudioExternalSamplesReady(rTCAudioSamples);
                    }
                    if (BaiduRtcRoomImp.this.mEnableAudioMix && BaiduRtcRoomImp.this.mIsEnableExternalAudioRecord) {
                        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
                        bufferInfo.size = rTCAudioSamples.getData().length;
                        bufferInfo.offset = 0;
                        BaiduRtcRoomImp.this.mAudioFilter.e(ByteBuffer.wrap(rTCAudioSamples.getData()), bufferInfo);
                    }
                }
            }
        };
        this.mOnMixedFrameUpdateListener = new d.a.k.c.b() { // from class: com.baidu.rtc.internal.BaiduRtcRoomImp.7
            @Override // d.a.k.c.b
            public void onFilteredFrameUpdate(byte[] bArr, MediaCodec.BufferInfo bufferInfo) {
                BaiduRtcRoomImp baiduRtcRoomImp = BaiduRtcRoomImp.this;
                RTCAudioSamples.RTCMixedSamplesReadyCallback rTCMixedSamplesReadyCallback = baiduRtcRoomImp.mMixedSamplesCallback;
                if (rTCMixedSamplesReadyCallback != null) {
                    rTCMixedSamplesReadyCallback.onRtcAudioMixedSamplesReady(new RTCAudioSamples(2, baiduRtcRoomImp.mParamSettings.AudioChannel, BaiduRtcRoomImp.this.mParamSettings.AudioFrequency, bArr, bufferInfo.presentationTimeUs));
                }
            }
        };
        this.reportDeviceInfoRun = new Runnable() { // from class: com.baidu.rtc.internal.BaiduRtcRoomImp.24
            @Override // java.lang.Runnable
            public void run() {
                BaiduRtcRoomImp baiduRtcRoomImp = BaiduRtcRoomImp.this;
                if (baiduRtcRoomImp.rtcLogReport != null && (baiduRtcRoomImp.mIsEnablePushQualityMonitor || baiduRtcRoomImp.mIsEnablePullQualityMonitor)) {
                    BaiduRtcRoomImp.this.reportDeviceInfo();
                }
                BaiduRtcRoomImp.this.mHandler.postDelayed(BaiduRtcRoomImp.this.reportDeviceInfoRun, 300000L);
            }
        };
        this.mIsEnableSoLaterLoad = z;
        this.mSoContext = context;
        this.mContext = new WeakReference<>(context);
        this.mCpuType = str3;
        WebSocketChannel webSocketChannel = new WebSocketChannel();
        this.mWebSocketChannel = webSocketChannel;
        webSocketChannel.setAppId(str);
        this.mWebSocketChannel.setTokenStr(str2);
        WebSocketChannel webSocketChannel2 = this.mWebSocketChannel;
        webSocketChannel2.setSDK(BRTC_SDK_VERSION_PREFIX + version());
        this.mAppId = str;
        this.mWebSocketChannel.setDelegate(this);
        this.rootEglBase = EglBase_CC.create();
        int i2 = 0;
        while (true) {
            boolean[] zArr = this.mHasVideoView;
            if (i2 >= zArr.length) {
                break;
            }
            zArr[i2] = false;
            i2++;
        }
        AudioManager audioManager = (AudioManager) this.mContext.get().getSystemService("audio");
        audioManager.setSpeakerphoneOn(false);
        if (this.mIsEnablePushQualityMonitor || this.mIsEnablePullQualityMonitor || this.mIsEnableErrorInfoMonitor) {
            this.mCpuMonitor = new CpuMonitor(context);
            this.rtcLogReport = RtcLogReport.getInstance();
        }
        ErrorInfoReport.getInstance().setEnv(this.mErrorInfoMonitorEnv);
        ErrorInfoReport errorInfoReport = ErrorInfoReport.getInstance();
        errorInfoReport.setVersion(BRTC_SDK_VERSION_PREFIX + version());
        ErrorInfoReport.getInstance().setAppId(this.mAppId);
        this.bluetoothOpSeq = 0;
        this.isBluetoothOn = Boolean.FALSE;
        audioManager = audioManager == null ? (AudioManager) this.mContext.get().getSystemService("audio") : audioManager;
        this.mHeadSetReceiver = new HeadsetReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.HEADSET_PLUG");
        intentFilter.addAction("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
        intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        try {
            if (audioManager.isBluetoothScoAvailableOffCall()) {
                intentFilter.addAction("android.media.SCO_AUDIO_STATE_CHANGED");
                intentFilter.addAction("android.media.ACTION_SCO_AUDIO_STATE_UPDATED");
                if (audioManager.isBluetoothScoOn()) {
                    setBluetoothScoOn(Boolean.TRUE);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.mContext.get().registerReceiver(this.mHeadSetReceiver, intentFilter);
        if (isHeadsetOn(this.mContext.get())) {
            return;
        }
        presetLoudSpeaker(true);
        Log.i(TAG, "Headset No");
    }

    public static /* synthetic */ int access$3404(BaiduRtcRoomImp baiduRtcRoomImp) {
        int i2 = baiduRtcRoomImp.bluetoothOpSeq + 1;
        baiduRtcRoomImp.bluetoothOpSeq = i2;
        return i2;
    }

    public static /* synthetic */ int access$3408(BaiduRtcRoomImp baiduRtcRoomImp) {
        int i2 = baiduRtcRoomImp.bluetoothOpSeq;
        baiduRtcRoomImp.bluetoothOpSeq = i2 + 1;
        return i2;
    }

    private boolean captureToTexture() {
        return !Build.MODEL.contains("SABRESD-MX6DQ");
    }

    private VideoCapturer createCameraCapturer(CameraEnumerator cameraEnumerator) {
        CameraVideoCapturer createCapturer;
        CameraVideoCapturer createCapturer2;
        CameraVideoCapturer createCapturer3;
        String[] deviceNames = cameraEnumerator.getDeviceNames();
        int i2 = this.mCameraID;
        if (i2 == DEFAULT_CAMERA_ID || i2 >= deviceNames.length || (createCapturer3 = cameraEnumerator.createCapturer(deviceNames[i2], null)) == null) {
            Log.d(TAG, "Looking for front facing cameras.");
            for (String str : deviceNames) {
                if (cameraEnumerator.isFrontFacing(str)) {
                    Log.d(TAG, "Creating front facing camera capturer.");
                    if (!mCameraUsingMap.containsValue(str) && (createCapturer2 = cameraEnumerator.createCapturer(str, null)) != null) {
                        mCameraUsingMap.put(toString(), str);
                        this.mVideoCaptureIsFrontCamera = true;
                        RTCVideoView rTCVideoView = this.mLocalRender;
                        if (rTCVideoView != null) {
                            rTCVideoView.setMirror(true);
                        }
                        return createCapturer2;
                    }
                }
            }
            Log.d(TAG, "Looking for other cameras.");
            for (String str2 : deviceNames) {
                if (!cameraEnumerator.isFrontFacing(str2)) {
                    Log.d(TAG, "Creating other camera capturer.");
                    if (!mCameraUsingMap.containsValue(str2) && (createCapturer = cameraEnumerator.createCapturer(str2, null)) != null) {
                        mCameraUsingMap.put(toString(), str2);
                        this.mVideoCaptureIsFrontCamera = false;
                        return createCapturer;
                    }
                }
            }
            return null;
        }
        return createCapturer3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public VideoCapturer createVideoCapturer() {
        CameraEnumerator camera1Enumerator;
        VideoCapturer videoCapturer = this.videoCapturer;
        if (videoCapturer != null) {
            return videoCapturer;
        }
        if (useCamera2()) {
            Log.d(TAG, "Creating capturer using camera2 API.");
            camera1Enumerator = new Camera2Enumerator(this.mContext.get());
        } else {
            Log.d(TAG, "Creating capturer using camera1 API.");
            camera1Enumerator = new Camera1Enumerator(captureToTexture());
        }
        VideoCapturer createCameraCapturer = createCameraCapturer(camera1Enumerator);
        if (createCameraCapturer == null) {
            Log.e(TAG, "Failed to open camera");
            return null;
        }
        return createCameraCapturer;
    }

    private void disposeExternalRenderers() {
        if (this.mUserIdVideoRendererMap.isEmpty()) {
            return;
        }
        for (Long l : this.mUserIdVideoRendererMap.keySet()) {
            RTCVideoExternalRender rTCVideoExternalRender = this.mUserIdVideoRendererMap.get(l);
            if (rTCVideoExternalRender != null) {
                if (rTCVideoExternalRender.getSurface() != null) {
                    rTCVideoExternalRender.releaseSurface();
                }
                rTCVideoExternalRender.release();
            }
            this.mUserIdVideoRendererMap.remove(l);
        }
    }

    private void disposePendingRenderers() {
        synchronized (this) {
            if (this.mPendingRemoveRendererMap.isEmpty()) {
                return;
            }
            for (RTCVideoExternalRender rTCVideoExternalRender : this.mPendingRemoveRendererMap.values()) {
                if (rTCVideoExternalRender != null) {
                    if (rTCVideoExternalRender.getSurface() != null) {
                        rTCVideoExternalRender.releaseSurface();
                    }
                    rTCVideoExternalRender.release();
                }
            }
            this.mPendingRemoveRendererMap.clear();
        }
    }

    public static BaiduRtcRoom.RoomInfo getRoomInfofromPlatformServer(String str, String str2, String str3, String str4) {
        BaiduRtcRoom.RoomInfo roomInfo = new BaiduRtcRoom.RoomInfo();
        try {
            MediaType parse = MediaType.parse("application/json;charset=utf-8");
            OkHttpClient build = new OkHttpClient.Builder().addInterceptor(new Interceptor() { // from class: com.baidu.rtc.internal.BaiduRtcRoomImp.21
                @Override // okhttp3.Interceptor
                public Response intercept(Interceptor.Chain chain) throws IOException {
                    return chain.proceed(chain.request().newBuilder().build());
                }
            }).connectTimeout(10L, TimeUnit.SECONDS).readTimeout(10L, TimeUnit.SECONDS).build();
            String string = build.newCall(new Request.Builder().url(str4).post(RequestBody.create(parse, "{\"appId\":\"" + str + "\",\"roomName\":\"" + str2 + "\",\"uId\":\"" + str3 + "\"}")).build()).execute().body().string();
            Log.e("", string);
            try {
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("mediaServerIP");
                jSONObject.optString("mediaServerPort");
                String optString2 = jSONObject.optString(ILiveNPSPlugin.PARAMS_ROOM_ID);
                if (!optString.isEmpty()) {
                    roomInfo.MediaServerURL = "ws://" + optString + ":8188/janus";
                    roomInfo.RoomID = optString2;
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        } catch (IOException | Exception unused) {
        }
        return roomInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isHeadsetOn(Context context) {
        AudioDeviceInfo[] devices;
        if (this.audioManager == null) {
            this.audioManager = (AudioManager) context.getSystemService("audio");
        }
        AudioManager audioManager = this.audioManager;
        if (audioManager == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 23) {
            return audioManager.isWiredHeadsetOn() || this.audioManager.isBluetoothScoOn() || this.audioManager.isBluetoothA2dpOn();
        }
        for (AudioDeviceInfo audioDeviceInfo : audioManager.getDevices(2)) {
            if (audioDeviceInfo.getType() == 3 || audioDeviceInfo.getType() == 4 || audioDeviceInfo.getType() == 8 || audioDeviceInfo.getType() == 7 || audioDeviceInfo.getType() == 11) {
                return true;
            }
        }
        return false;
    }

    private void offerPeerConnection(final BigInteger bigInteger) {
        if (this.mIsStreamPublish) {
            return;
        }
        this.mIsStreamPublish = true;
        this.mHandler.post(new Runnable() { // from class: com.baidu.rtc.internal.BaiduRtcRoomImp.22
            @Override // java.lang.Runnable
            public void run() {
                PeerConnectionClient peerConnectionClient;
                EglBase.Context eglBaseContext;
                VideoSink videoSink;
                if (BaiduRtcRoomImp.this.mParamSettings.HasVideo) {
                    BaiduRtcRoomImp baiduRtcRoomImp = BaiduRtcRoomImp.this;
                    baiduRtcRoomImp.videoCapturer = baiduRtcRoomImp.createVideoCapturer();
                }
                if (BaiduRtcRoomImp.this.peerConnectionClient == null) {
                    Log.e(BaiduRtcRoomImp.TAG, "peerConnectionClient is null!");
                    return;
                }
                if (BaiduRtcRoomImp.this.mIsEnableExternalVideoCapturer) {
                    peerConnectionClient = BaiduRtcRoomImp.this.peerConnectionClient;
                    eglBaseContext = BaiduRtcRoomImp.this.rootEglBase.getEglBaseContext();
                    videoSink = BaiduRtcRoomImp.this.mVideoSink;
                } else {
                    peerConnectionClient = BaiduRtcRoomImp.this.peerConnectionClient;
                    eglBaseContext = BaiduRtcRoomImp.this.rootEglBase.getEglBaseContext();
                    videoSink = BaiduRtcRoomImp.this.mLocalRender;
                }
                peerConnectionClient.createPeerConnection(eglBaseContext, videoSink, BaiduRtcRoomImp.this.videoCapturer, bigInteger);
                BaiduRtcRoomImp.this.mStartLoginTime = System.currentTimeMillis();
                BaiduRtcRoomImp.this.peerConnectionClient.createOffer(bigInteger);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onFfDelayChange(JanusConnection janusConnection, BigInteger bigInteger) {
        HUDStatistics hUDStatistics;
        if (!this.mIsEnablePullQualityMonitor || (hUDStatistics = this.mHUDStatisticsMap.get(janusConnection.handleId)) == null) {
            return;
        }
        hUDStatistics.setFirstFrameTime(System.currentTimeMillis());
        reportSLIFfDelay(bigInteger.longValue(), hUDStatistics.getFirstFrameTime() - hUDStatistics.getRequestSubscribeTime());
    }

    private void onPacketLossEvent(Map<String, Integer> map) {
        long intValue = map.get("packetloss_s") != null ? map.get("packetloss_s").intValue() : 0L;
        long intValue2 = map.get("packetlost") != null ? map.get("packetlost").intValue() : 0L;
        long intValue3 = map.get("packesend") != null ? map.get("packesend").intValue() : 0L;
        if (this.mBaiduRtcRoomDelegate != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("packetsLost", intValue2);
                jSONObject.put("packetsSent", intValue3);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            this.mBaiduRtcRoomDelegate.onRoomEventUpdate(201, intValue, jSONObject.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void parseAudioLeves(StatsReport[] statsReportArr, BigInteger bigInteger) {
        BigInteger feedByHandle;
        StatsReport.Value[] valueArr;
        StatsReport.Value[] valueArr2;
        WebSocketChannel webSocketChannel = this.mWebSocketChannel;
        if (webSocketChannel == null) {
            return;
        }
        if (bigInteger == this.mPublisherHandle) {
            feedByHandle = BigInteger.valueOf(this.mUserId);
        } else {
            feedByHandle = webSocketChannel.getFeedByHandle(bigInteger);
            if (feedByHandle == null) {
                return;
            }
        }
        StreamStats streamStats = this.mRemoteStreamStats.get(feedByHandle);
        if (streamStats == null) {
            if (this.peerConnectionClient != null) {
                this.peerConnectionClient.enableStatsEvents(false, 0, bigInteger, PeerConnectionClient.StatsEventsType.GET_AUDIOLEVEL_EVENT);
                return;
            }
            return;
        }
        for (StatsReport statsReport : statsReportArr) {
            if (bigInteger == this.mPublisherHandle) {
                if (statsReport.type.equals("ssrc") && statsReport.id.contains("ssrc") && statsReport.id.contains("send")) {
                    for (StatsReport.Value value : statsReport.values) {
                        if (value.name.contains("audioInputLevel")) {
                            try {
                                streamStats.volume = Integer.valueOf(value.value).intValue();
                            } catch (NumberFormatException e2) {
                                Log.e(TAG, "parse string num exception: " + e2);
                            }
                        }
                    }
                }
            } else if (statsReport.type.equals("ssrc") && statsReport.id.contains("ssrc") && statsReport.id.contains("recv")) {
                for (StatsReport.Value value2 : statsReport.values) {
                    if (value2.name.contains("audioOutputLevel")) {
                        try {
                            streamStats.volume = Integer.valueOf(value2.value).intValue();
                        } catch (NumberFormatException e3) {
                            Log.e(TAG, "parse string num exception: " + e3);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportCommunicationQualityInfo() {
        HUDStatistics hUDStatistics;
        if (this.mWebSocketChannel == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        boolean z = true;
        HUDStatistics hUDStatistics2 = this.mHUDStatisticsMap.get(this.mPublisherHandle);
        if (hUDStatistics2 == null) {
            z = false;
        } else {
            hUDStatistics2.getStatsSendInfo(hashMap);
        }
        if (hashMap.size() == 0) {
            z = false;
        }
        onPacketLossEvent(hashMap);
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("duration", 2);
            JSONObject jSONObject3 = new JSONObject();
            if (this.mCpuMonitor != null) {
                jSONObject3.put("sysCpuUsage", this.mCpuMonitor.getFrequencyScaleAverage());
            }
            jSONObject3.put("appCpuUsage", 0);
            jSONObject2.put("resourceUsageInfo", jSONObject3);
            if (this.mIsEnablePushQualityMonitor) {
                JSONObject jSONObject4 = new JSONObject();
                if (z) {
                    jSONObject4.put(KsMediaMeta.KSM_KEY_BITRATE, hashMap.get("bitrate_s"));
                    jSONObject4.put("packetloss", hashMap.get("packetloss_s"));
                    jSONObject4.put("cfps", hashMap.get("fps_s"));
                    jSONObject4.put("fps", hashMap.get("fps_i"));
                    if (hUDStatistics2 != null) {
                        jSONObject4.put("resolution", hUDStatistics2.getSendResolution());
                        jSONObject2.put("senderQualityInfo", jSONObject4);
                    }
                } else {
                    jSONObject4.put(KsMediaMeta.KSM_KEY_BITRATE, 0);
                    jSONObject4.put("packetloss", 0);
                    jSONObject4.put("fps", 0);
                }
                jSONObject4.put("resolution", "");
                jSONObject2.put("senderQualityInfo", jSONObject4);
            }
            if (this.mIsEnablePullQualityMonitor) {
                JSONArray jSONArray = new JSONArray();
                for (BigInteger bigInteger : this.mHUDStatisticsMap.keySet()) {
                    if (bigInteger != this.mPublisherHandle && (hUDStatistics = this.mHUDStatisticsMap.get(bigInteger)) != null) {
                        HashMap hashMap2 = new HashMap();
                        hUDStatistics.getStatsRecvInfo(hashMap2);
                        if (hashMap2.size() != 0) {
                            JSONObject jSONObject5 = new JSONObject();
                            if (this.mWebSocketChannel != null) {
                                jSONObject5.put("feedId", this.mWebSocketChannel.getFeedByHandle(bigInteger));
                            }
                            jSONObject5.put(KsMediaMeta.KSM_KEY_BITRATE, hashMap2.get("bitrate_r"));
                            jSONObject5.put("packetloss", hashMap2.get("packetloss_r"));
                            jSONObject5.put("fps", hashMap2.get("fps_r"));
                            jSONObject5.put("resolution", hUDStatistics.getRecvResolution());
                            jSONArray.put(jSONObject5);
                        }
                    }
                }
                jSONObject2.put("receiverQualityInfoList", jSONArray);
            }
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put("communicationQualityInfo", jSONObject2);
            jSONObject.put("env", this.mQualityMonitorEnv);
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.mAppId);
            if (this.mWebSocketChannel != null) {
                jSONObject.put(ILiveNPSPlugin.PARAMS_ROOM_ID, this.mWebSocketChannel.getRoomId());
            }
            jSONObject.put("timestamp", System.currentTimeMillis());
            jSONObject.put("userId", this.mUserId);
            jSONObject.put("message", jSONObject6);
        } catch (JSONException e2) {
            Log.e(TAG, "Caught error on reportCommunicationQualityInfo: " + e2);
        }
        this.rtcLogReport.report(jSONObject.toString(), 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportDeviceInfo() {
        if (this.mWebSocketChannel == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(CommandMessage.SDK_VERSION, BRTC_SDK_VERSION_PREFIX + version());
            jSONObject2.put("networkType", RtcLogReport.getNetworkType(this.mContext.get()));
            jSONObject2.put("device", RtcLogReport.getDeviceModel());
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("deviceInfo", jSONObject2);
            jSONObject.put("env", this.mQualityMonitorEnv);
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.mAppId);
            if (this.mWebSocketChannel != null) {
                jSONObject.put(ILiveNPSPlugin.PARAMS_ROOM_ID, this.mWebSocketChannel.getRoomId());
            }
            jSONObject.put("timestamp", System.currentTimeMillis());
            jSONObject.put("userId", this.mUserId);
            jSONObject.put("message", jSONObject3);
        } catch (JSONException e2) {
            Log.e(TAG, "Caught error on reportDeviceInfo: " + e2);
        }
        this.rtcLogReport.report(jSONObject.toString(), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportRoomEventInfo(String str) {
        if ((this.mIsEnablePushQualityMonitor || this.mIsEnablePullQualityMonitor) && this.mWebSocketChannel != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(TbEnum.SystemMessage.KEY_USER_NAME, this.mDisplayName);
                jSONObject2.put("eventDescription", str);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("roomEvent", jSONObject2);
                jSONObject.put("env", this.mQualityMonitorEnv);
                jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.mAppId);
                if (this.mWebSocketChannel != null) {
                    jSONObject.put(ILiveNPSPlugin.PARAMS_ROOM_ID, this.mWebSocketChannel.getRoomId());
                }
                jSONObject.put("timestamp", System.currentTimeMillis());
                jSONObject.put("userId", this.mUserId);
                jSONObject.put("message", jSONObject3);
            } catch (JSONException e2) {
                Log.e(TAG, "Caught error on reportRoomEventInfo: " + e2);
            }
            this.rtcLogReport.report(jSONObject.toString(), 1);
        }
    }

    private void reportSLIFfDelay(long j, long j2) {
        if (this.mWebSocketChannel == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            JSONObject jSONObject4 = new JSONObject();
            jSONObject2.put("feedId", j);
            jSONObject4.put("duration", j2);
            jSONObject2.put("ffDelay", jSONObject4);
            jSONObject3.put("sli", jSONObject2);
            jSONObject.put("env", this.mQualityMonitorEnv);
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.mAppId);
            if (this.mWebSocketChannel != null) {
                jSONObject.put(ILiveNPSPlugin.PARAMS_ROOM_ID, this.mWebSocketChannel.getRoomId());
            }
            jSONObject.put("timestamp", System.currentTimeMillis());
            jSONObject.put("userId", this.mUserId);
            jSONObject.put("message", jSONObject3);
        } catch (JSONException e2) {
            Log.e(TAG, "Caught error on reportDeviceInfo: " + e2);
        }
        this.rtcLogReport.report(jSONObject.toString(), 3);
        if (!this.mIsEnableErrorInfoMonitor || j2 <= 3000) {
            return;
        }
        BigInteger valueOf = BigInteger.valueOf(0L);
        WebSocketChannel webSocketChannel = this.mWebSocketChannel;
        if (webSocketChannel != null && webSocketChannel.getHandleByFeed(BigInteger.valueOf(j)) != null) {
            valueOf = this.mWebSocketChannel.getHandleByFeed(BigInteger.valueOf(j)).handleId;
        }
        ErrorInfoReport.getInstance().reportErrorInfo(ErrorInfoReport.ErrorCode.BAD_FIRST_FRAME_TIME, j2, valueOf, BigInteger.valueOf(j));
    }

    private void reportSLILoginEvent(String str) {
        WebSocketChannel webSocketChannel = this.mWebSocketChannel;
        reportSLILoginEvent(str, webSocketChannel != null ? webSocketChannel.getRoomId() : -1L);
    }

    private void reportSLILoginEvent(String str, long j) {
        if (this.mWebSocketChannel == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            new JSONObject();
            jSONObject2.put("feedId", 0);
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("type", str);
            jSONObject2.put("loginEvent", jSONObject4);
            jSONObject3.put("sli", jSONObject2);
            jSONObject.put("env", this.mQualityMonitorEnv);
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.mAppId);
            if (j > 0) {
                jSONObject.put(ILiveNPSPlugin.PARAMS_ROOM_ID, j);
            }
            jSONObject.put("timestamp", System.currentTimeMillis());
            jSONObject.put("userId", this.mUserId);
            jSONObject.put("message", jSONObject3);
        } catch (JSONException e2) {
            Log.e(TAG, "Caught error on reportDeviceInfo: " + e2);
        }
        this.rtcLogReport.report(jSONObject.toString(), 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportSLIStuckInfo() {
        HUDStatistics hUDStatistics;
        if (this.mWebSocketChannel != null && this.mIsEnablePullQualityMonitor) {
            new JSONArray();
            for (BigInteger bigInteger : this.mHUDStatisticsMap.keySet()) {
                if (bigInteger != this.mPublisherHandle && (hUDStatistics = this.mHUDStatisticsMap.get(bigInteger)) != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("feedId", this.mWebSocketChannel.getFeedByHandle(bigInteger));
                        JSONArray jSONArray = new JSONArray();
                        JSONArray jSONArray2 = new JSONArray();
                        HashMap hashMap = new HashMap();
                        hUDStatistics.getSlIStuckData(hashMap);
                        ArrayList<Long> arrayList = hashMap.get("aStuck");
                        if (arrayList.size() == 0) {
                            jSONArray.put(0);
                        } else {
                            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                                jSONArray.put(arrayList.get(i2));
                            }
                        }
                        ArrayList<Long> arrayList2 = hashMap.get("vStuck");
                        if (arrayList2.size() == 0) {
                            jSONArray2.put(0);
                        } else {
                            for (int i3 = 0; i3 < arrayList2.size(); i3++) {
                                jSONArray2.put(arrayList2.get(i3));
                            }
                        }
                        JSONObject jSONObject4 = new JSONObject();
                        jSONObject4.put("durations", jSONArray);
                        JSONObject jSONObject5 = new JSONObject();
                        jSONObject5.put("durations", jSONArray2);
                        jSONObject3.put("astuck", jSONObject4);
                        jSONObject3.put("vstuck", jSONObject5);
                        hUDStatistics.clearSLIStuckData();
                        JSONObject jSONObject6 = new JSONObject();
                        if (hUDStatistics.getEndTOEndTime() > 0) {
                            jSONObject6.put("duration", hUDStatistics.getEndTOEndTime());
                            jSONObject3.put("e2eDelay", jSONObject6);
                        }
                        jSONObject2.put("sli", jSONObject3);
                        jSONObject.put("env", this.mQualityMonitorEnv);
                        jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.mAppId);
                        if (this.mWebSocketChannel != null) {
                            jSONObject.put(ILiveNPSPlugin.PARAMS_ROOM_ID, this.mWebSocketChannel.getRoomId());
                        }
                        jSONObject.put("timestamp", System.currentTimeMillis());
                        jSONObject.put("userId", this.mUserId);
                        jSONObject.put("message", jSONObject2);
                    } catch (JSONException e2) {
                        Log.e(TAG, "Caught error on reportDeviceInfo: " + e2);
                    }
                    this.rtcLogReport.report(jSONObject.toString(), 3);
                    if (this.mIsEnableErrorInfoMonitor && hUDStatistics.getEndTOEndTime() > 400) {
                        BigInteger valueOf = BigInteger.valueOf(0L);
                        WebSocketChannel webSocketChannel = this.mWebSocketChannel;
                        if (webSocketChannel != null) {
                            valueOf = webSocketChannel.getFeedByHandle(bigInteger);
                        }
                        ErrorInfoReport.getInstance().reportErrorInfo(ErrorInfoReport.ErrorCode.BAD_END_TO_END_DELAY, hUDStatistics.getEndTOEndTime(), bigInteger, valueOf);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int setBluetoothScoOn(Boolean bool) {
        if (this.isBluetoothOn == bool) {
            return 0;
        }
        if (this.audioManager == null) {
            this.audioManager = (AudioManager) this.mContext.get().getSystemService("audio");
        }
        if (this.audioManager == null) {
            return -1;
        }
        try {
            if (bool.booleanValue()) {
                this.audioManager.startBluetoothSco();
                this.audioManager.setBluetoothScoOn(bool.booleanValue());
            }
            this.audioManager.setBluetoothScoOn(bool.booleanValue());
            this.audioManager.stopBluetoothSco();
            this.isBluetoothOn = bool;
            return 0;
        } catch (Exception e2) {
            Log.e(TAG, "set bluetooth sco fail: " + e2.getMessage());
            return -1;
        }
    }

    public static void setUseTestEnv(boolean z) {
    }

    public static void setVerbose(boolean z) {
        mbEnableDebugLog = z;
    }

    private boolean useCamera2() {
        Camera2Enumerator.disableExtraCamera(this.mParamSettings.DisableExtraCamera);
        return Camera2Enumerator.isSupported(this.mContext.get());
    }

    private void userRenderMove2PendingMap(long j) {
        synchronized (this) {
            if (this.mUserIdVideoRendererMap.containsKey(Long.valueOf(j))) {
                this.mPendingRemoveRendererMap.put(Long.valueOf(j), this.mUserIdVideoRendererMap.get(Long.valueOf(j)));
                this.mUserIdVideoRendererMap.remove(Long.valueOf(j));
            }
        }
    }

    public static String version() {
        return "1.2.17";
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void addExternalRenderer(long j, RTCVideoExternalRender rTCVideoExternalRender) {
        removeExternalRenderer(j);
        this.mUserIdVideoRendererMap.put(Long.valueOf(j), rTCVideoExternalRender);
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void cameraFocusWithPoint(int i2, int i3) {
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void changeSurfaceSize(long j, int i2, int i3) {
        if (this.mUserIdVideoRendererMap.containsKey(Long.valueOf(j))) {
            RTCVideoExternalRender rTCVideoExternalRender = this.mUserIdVideoRendererMap.get(Long.valueOf(j));
            if (rTCVideoExternalRender != null) {
                rTCVideoExternalRender.changeSurfaceSize(i2, i3);
                return;
            }
            return;
        }
        Log.d(TAG, "External render not found to  change surface size for " + j);
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public boolean configLiveServerWithUrl(String str, boolean z, boolean z2, String str2, BaiduRtcRoom.RtcLiveTransferMode rtcLiveTransferMode) {
        if (!this.mLastLssURL.isEmpty() && this.mLastLssMode != rtcLiveTransferMode) {
            this.mWebSocketChannel.setLssConfigSecond(str, z, z2, str2, rtcLiveTransferMode);
            return true;
        }
        this.mLastLssURL = str;
        this.mLastLssMode = rtcLiveTransferMode;
        this.mWebSocketChannel.setRecording(z2);
        this.mWebSocketChannel.setLssURL(str);
        this.mWebSocketChannel.setMixing(z);
        this.mWebSocketChannel.setLssMixTemplate(str2);
        this.mWebSocketChannel.setLssTransferMode(rtcLiveTransferMode);
        return true;
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void destroyExternalSurface(long j, Surface surface) {
        RTCVideoExternalRender rTCVideoExternalRender;
        if (this.mUserIdVideoRendererMap.containsKey(Long.valueOf(j)) && (rTCVideoExternalRender = this.mUserIdVideoRendererMap.get(Long.valueOf(j))) != null && surface == rTCVideoExternalRender.getSurface()) {
            rTCVideoExternalRender.releaseSurface();
        }
        disposePendingRenderers();
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void disbandRoom() {
        WebSocketChannel webSocketChannel = this.mWebSocketChannel;
        if (webSocketChannel != null) {
            webSocketChannel.disbandRoom();
        }
    }

    public void doDestroy() {
        logoutRtcRoom();
        mCameraUsingMap.remove(toString());
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void enableAgc(boolean z) {
        this.disableBuiltInAGC = Boolean.valueOf(z);
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void enableAns(boolean z) {
        this.disableBuiltInNS = Boolean.valueOf(z);
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void enableAudioMix(boolean z) {
        this.mEnableAudioMix = z;
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void enableErrorInfoToServer(boolean z, String str) {
        this.mIsEnableErrorInfoMonitor = z;
        this.mIsUseDefaultErrorInfoMonitor = false;
        this.mErrorInfoMonitorEnv = str;
        ErrorInfoReport.getInstance().setEnv(str);
        if (z && this.rtcLogReport == null) {
            this.rtcLogReport = RtcLogReport.getInstance();
        }
        WebSocketChannel webSocketChannel = this.mWebSocketChannel;
        if (webSocketChannel != null) {
            webSocketChannel.setEnableErrorInfoMonitor(z);
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void enableExternalAudioRecord(boolean z) {
        this.mIsEnableExternalAudioRecord = z;
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void enableExternalVideoCapturer(boolean z) {
        this.mIsEnableExternalVideoCapturer = z;
        this.mVideoSink = new VideoSink() { // from class: com.baidu.rtc.internal.BaiduRtcRoomImp.23
            @Override // org.webrtc.VideoSink
            public void onFrame(VideoFrame videoFrame) {
            }
        };
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void enableLaterLoadSo(String str) {
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void enableStatsToServer(boolean z, String str) {
        enableStatsToServer(z, z, str);
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void enableStatsToServer(boolean z, boolean z2, String str) {
        this.mIsEnablePushQualityMonitor = z;
        this.mIsEnablePullQualityMonitor = z2;
        this.mQualityMonitorEnv = str;
        if (!z && !z2) {
            CpuMonitor cpuMonitor = this.mCpuMonitor;
            if (cpuMonitor != null) {
                cpuMonitor.pause();
                return;
            }
            return;
        }
        if (this.mCpuMonitor == null) {
            this.mCpuMonitor = new CpuMonitor(this.mSoContext);
        }
        if (this.rtcLogReport == null) {
            this.rtcLogReport = RtcLogReport.getInstance();
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public RTCAudioSamples.RTCExternalSamplesReadyCallback getExternalAudioSamplesCallback() {
        return this.externalSamplesReadyCallback;
    }

    public RTCVideoExternalRender getExternalRender(long j) {
        synchronized (this) {
            Log.d(TAG, j + " : Get external renderer.");
            if (this.mUserIdVideoRendererMap.containsKey(Long.valueOf(j))) {
                return this.mUserIdVideoRendererMap.get(Long.valueOf(j));
            }
            RTCVideoExternalRenderImp rTCVideoExternalRenderImp = new RTCVideoExternalRenderImp(this.mBaiduRtcRoomDelegate, j);
            Log.d(TAG, j + " : Create external renderer" + rTCVideoExternalRenderImp);
            this.mUserIdVideoRendererMap.put(Long.valueOf(j), rTCVideoExternalRenderImp);
            return rTCVideoExternalRenderImp;
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public BaiduRtcRoom.RtcRoomAudioLevel[] getRemoteAudioLevels() {
        int i2 = 0;
        int i3 = 0;
        for (BigInteger bigInteger : this.mRemoteStreamStats.keySet()) {
            StreamStats streamStats = this.mRemoteStreamStats.get(bigInteger);
            if (streamStats != null && streamStats.hasAudio.booleanValue() && streamStats.volume != -1) {
                i3++;
            }
        }
        BaiduRtcRoom.RtcRoomAudioLevel[] rtcRoomAudioLevelArr = new BaiduRtcRoom.RtcRoomAudioLevel[i3];
        for (BigInteger bigInteger2 : this.mRemoteStreamStats.keySet()) {
            StreamStats streamStats2 = this.mRemoteStreamStats.get(bigInteger2);
            if (streamStats2 != null && streamStats2.volume != -1 && streamStats2.hasAudio.booleanValue()) {
                if (i2 >= i3) {
                    break;
                }
                rtcRoomAudioLevelArr[i2] = new BaiduRtcRoom.RtcRoomAudioLevel();
                rtcRoomAudioLevelArr[i2].userId = streamStats2.userId;
                rtcRoomAudioLevelArr[i2].volumeLevel = streamStats2.volume;
                rtcRoomAudioLevelArr[i2].nicName = streamStats2.nickName;
                i2++;
            }
        }
        return rtcRoomAudioLevelArr;
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public BaiduRtcRoom.RtcRoomVideoDimension getRemoteVideoDimension(long j) {
        RTCVideoExternalRenderImp rTCVideoExternalRenderImp = (RTCVideoExternalRenderImp) this.mUserIdVideoRendererMap.get(Long.valueOf(j));
        BaiduRtcRoom.RtcRoomVideoDimension rtcRoomVideoDimension = new BaiduRtcRoom.RtcRoomVideoDimension();
        if (rTCVideoExternalRenderImp != null) {
            rtcRoomVideoDimension.videoWidth = rTCVideoExternalRenderImp.getVideoWidth();
            rtcRoomVideoDimension.videoHeight = rTCVideoExternalRenderImp.getVideoHeight();
            rtcRoomVideoDimension.videoRotation = rTCVideoExternalRenderImp.getVideoRotation();
        }
        return rtcRoomVideoDimension;
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void getUserAttribute(long j) {
        WebSocketChannel webSocketChannel = this.mWebSocketChannel;
        if (webSocketChannel == null) {
            return;
        }
        webSocketChannel.getUserAttribute(j);
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public BaiduRtcRoom.RtcRoomUserInfo[] getUserListOfRoom() {
        WebSocketChannel webSocketChannel = this.mWebSocketChannel;
        if (webSocketChannel == null) {
            return null;
        }
        return webSocketChannel.UserInfoList();
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public boolean isExternalAudioRecord() {
        return this.mIsEnableExternalAudioRecord;
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public boolean isSpeakerOn() {
        return ((AudioManager) this.mContext.get().getSystemService("audio")).isSpeakerphoneOn();
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void kickOffUserWithId(long j) {
        WebSocketChannel webSocketChannel = this.mWebSocketChannel;
        if (webSocketChannel != null) {
            webSocketChannel.kickOffUserWithId(j);
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public boolean loginRtcRoomWithRoomName(String str, long j, String str2) {
        return loginRtcRoomWithRoomName(str, j, str2, true, true);
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public boolean loginRtcRoomWithRoomName(String str, long j, String str2, boolean z) {
        Log.i(TAG, "enable force login");
        this.mIsCompulsive = z;
        return loginRtcRoomWithRoomName(str, j, str2, true, true);
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public boolean loginRtcRoomWithRoomName(String str, long j, String str2, boolean z, boolean z2) {
        boolean z3;
        int i2;
        int i3;
        this.mDisplayName = str2;
        this.mRoomName = str;
        this.mUserId = j;
        this.mIsAsPublisher = z;
        this.mIsAsListener = z2;
        if (this.mIsEnableSoLaterLoad) {
            try {
                System.loadLibrary("jingle_peerconnection_so");
            } catch (UnsatisfiedLinkError unused) {
                z3 = false;
            }
        }
        z3 = true;
        if (!z3 && this.mIsEnableSoLaterLoad && !this.mIsSoDownloaded) {
            Thread thread = new Thread(new Runnable() { // from class: com.baidu.rtc.internal.BaiduRtcRoomImp.3
                @Override // java.lang.Runnable
                public void run() {
                    Log.d(BaiduRtcRoomImp.TAG, "setup downloading thread ......");
                    BaiduRtcRoomImp baiduRtcRoomImp = BaiduRtcRoomImp.this;
                    baiduRtcRoomImp.setupSoLaterLoad(baiduRtcRoomImp.mSoContext);
                }
            });
            this.mSoDownloadThread = thread;
            thread.start();
            return true;
        } else if (j != 0) {
            this.mWebSocketChannel.setRoomName(str);
            this.mWebSocketChannel.setUserId(j);
            if (str2 != null && !str2.isEmpty()) {
                this.mWebSocketChannel.setDisplayName(str2);
            }
            this.mWebSocketChannel.setVideoCodec(this.mParamSettings.VideoCodec);
            this.mWebSocketChannel.setAsPublisher(z);
            this.mWebSocketChannel.setAsListener(z2);
            RtcParameterSettings rtcParameterSettings = this.mParamSettings;
            int i4 = rtcParameterSettings.VideoWidth;
            int i5 = rtcParameterSettings.VideoHeight;
            String lowerCase = rtcParameterSettings.VideoResolution.toLowerCase();
            if (lowerCase.contains("192x144")) {
                i4 = 192;
                i5 = 144;
            } else if (lowerCase.contains("320x180")) {
                i5 = 180;
                i4 = MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP;
            } else if (lowerCase.contains("352x288")) {
                i4 = 352;
                i5 = 288;
            } else if (lowerCase.contains("480x320")) {
                i4 = 480;
                i5 = MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP;
            } else {
                if (lowerCase.contains("320x480")) {
                    i4 = MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP;
                } else {
                    if (lowerCase.contains("480x360")) {
                        i4 = 480;
                    } else if (lowerCase.contains("640x360")) {
                        i4 = 640;
                    } else if (lowerCase.contains("640x480")) {
                        i4 = 640;
                    } else if (lowerCase.contains("960x540")) {
                        i4 = TbConfig.HEAD_IMG_SIZE;
                        i5 = 540;
                    } else if (lowerCase.contains("1280x720")) {
                        i4 = 1280;
                        i5 = PeerConnectionClient.HD_VIDEO_HEIGHT;
                    } else if (lowerCase.contains("1920x1080")) {
                        i4 = 1920;
                        i5 = IdCardOcrCameraActivity.G;
                    } else {
                        if (lowerCase.contains("3840x2160")) {
                            i4 = DisplayCompat.DISPLAY_SIZE_4K_WIDTH;
                        } else if (lowerCase.contains("4096x2160")) {
                            i4 = 4096;
                        } else {
                            if (lowerCase.contains("7680x4320")) {
                                i4 = 7680;
                            } else {
                                i4 = lowerCase.contains("8192x4320") ? 8192 : 8192;
                            }
                            i5 = 4320;
                        }
                        i5 = DisplayCompat.DISPLAY_SIZE_4K_HEIGHT;
                    }
                    i5 = 360;
                }
                i5 = 480;
            }
            if (i4 > 8192 || i5 > 4320) {
                i2 = 8192;
                i3 = 4320;
            } else {
                i2 = i4;
                i3 = i5;
            }
            if (Build.MODEL.contains("Redmi 6 Pro")) {
                this.mParamSettings.DisableBuiltInAEC = true;
                this.disableBuiltInNS = Boolean.TRUE;
            }
            if (Build.HARDWARE.contains("mt6768")) {
                RtcParameterSettings rtcParameterSettings2 = this.mParamSettings;
                rtcParameterSettings2.EnableRequiredResolutionAligment32 = true;
                rtcParameterSettings2.EnableMTKH264Decode = false;
            }
            if (Build.MODEL.contains("Mi Note 2") || Build.MODEL.contains("V1809")) {
                this.mParamSettings.EncodeBitrateMode = 1;
            }
            RtcParameterSettings rtcParameterSettings3 = this.mParamSettings;
            int i6 = rtcParameterSettings3.VideoFps;
            String upperCase = rtcParameterSettings3.VideoCodec.toUpperCase();
            boolean z4 = this.mParamSettings.DisableBuiltInAEC;
            boolean booleanValue = this.disableBuiltInAGC.booleanValue();
            boolean booleanValue2 = this.disableBuiltInNS.booleanValue();
            RtcParameterSettings rtcParameterSettings4 = this.mParamSettings;
            this.peerConnectionParameters = new PeerConnectionClient.PeerConnectionParameters(false, i2, i3, i6, upperCase, true, 0, "opus", false, false, z4, booleanValue, booleanValue2, rtcParameterSettings4.VideoMaxkbps, rtcParameterSettings4.VideoMinkbps, rtcParameterSettings4.MicPhoneMuted, rtcParameterSettings4.CameraMuted, true, rtcParameterSettings4.EnableFixedResolution, rtcParameterSettings4.EnableRequiredResolutionAligment32, rtcParameterSettings4.EnableHighProfile, rtcParameterSettings4.AudioMaxkbps, rtcParameterSettings4.audioBitrateMode, rtcParameterSettings4.TransportAudioChannel, rtcParameterSettings4.EncodeBitrateMode, rtcParameterSettings4.EnableHisiH264HW, rtcParameterSettings4.EnableMTKH264Decode, rtcParameterSettings4.AudioSource, rtcParameterSettings4.AudioBufferPackets, rtcParameterSettings4.AudioPlayoutDelay, rtcParameterSettings4.AudioCodecComplex);
            this.peerConnectionClient = PeerConnectionClient.getInstance();
            if (this.mEnableAudioMix) {
                if (this.mAudioFilter == null) {
                    this.mAudioFilter = new AudioFilter();
                }
                this.mAudioFilter.l(false);
                if (this.mRemoteFilterTrack < 0) {
                    this.mRemoteFilterTrack = this.mAudioFilter.b();
                }
                this.mAudioFilter.c();
                this.mAudioFilter.j(false);
                this.mAudioFilter.i(false);
                this.mAudioFilter.k(this.mOnMixedFrameUpdateListener);
            }
            if (this.mSamplesReadyCallback != null || this.mEnableAudioMix) {
                this.peerConnectionClient.setAudioSamplesReadyCallback(this.mSamplesReadyInternalCallback);
            }
            if (this.mRemoteSamplesCallback != null || this.mEnableAudioMix) {
                this.peerConnectionClient.setRemoteAudioSamplesReadyCallback(this.mRemoteSamplesInternalCallback);
            }
            RtcParameterSettings rtcParameterSettings5 = this.mParamSettings;
            if (rtcParameterSettings5 != null) {
                this.mWebSocketChannel.setHasAudio(rtcParameterSettings5.HasAudio);
                this.peerConnectionClient.setHasAudio(this.mParamSettings.HasAudio);
                this.mWebSocketChannel.setHasVideo(this.mParamSettings.HasVideo);
                this.peerConnectionClient.setHasVideo(this.mParamSettings.HasVideo);
                this.mWebSocketChannel.setHasData(this.mParamSettings.HasData);
                this.peerConnectionClient.setHasData(this.mParamSettings.HasData);
                this.peerConnectionClient.setAudioFreguency(this.mParamSettings.AudioFrequency);
                this.peerConnectionClient.setAudioChannel(this.mParamSettings.AudioChannel);
                this.mWebSocketChannel.setConnectionTimeoutMs(this.mParamSettings.ConnectionTimeoutMs);
                this.mWebSocketChannel.setReadTimeoutMs(this.mParamSettings.ReadTimeoutMs);
                this.mWebSocketChannel.setAutoPublish(this.mParamSettings.AutoPublish);
                this.mWebSocketChannel.setAutoSubScribe(this.mParamSettings.AutoSubScribe);
                this.mWebSocketChannel.setMediaServerIP(this.mParamSettings.MediaServerIP);
            }
            this.peerConnectionClient.setExternalAudioRecord(this.mIsEnableExternalAudioRecord);
            this.peerConnectionClient.setEnableDebugLog(mbEnableDebugLog);
            this.peerConnectionClient.createPeerConnectionFactory(this.mContext.get(), this.peerConnectionParameters, this);
            this.peerConnectionClient.setStuckEventListener(new AudioStuckEvent());
            this.peerConnectionClient.setEnableSLIReport(this.mIsEnablePullQualityMonitor);
            this.mWebSocketChannel.initConnection(this.mJanusServerURL, this.mIsCompulsive);
            if (this.mIsUseDefaultErrorInfoMonitor) {
                if (this.mJanusServerURL.contains("bcelive.com")) {
                    this.mIsEnableErrorInfoMonitor = true;
                } else {
                    this.mIsEnableErrorInfoMonitor = false;
                }
            }
            Log.i("BRTC", "loginRtcRoomWithRoomName: this " + this + " version: " + version());
            return true;
        } else {
            throw new InvalidParameterException("loginRtcRoomWithRoomName: Param Error,userId cann't be zero. zero is reserved.");
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public boolean logoutRtcRoom() {
        if (this.peerConnectionClient == null) {
            return true;
        }
        int i2 = 0;
        this.peerConnectionClient.setAudioEnabled(false);
        this.peerConnectionClient.setVideoEnabled(false);
        this.peerConnectionClient.stopVideoSource();
        this.mWebSocketChannel.leaveRoom();
        this.mWebSocketChannel.finalize();
        this.peerConnectionClient.close();
        CpuMonitor cpuMonitor = this.mCpuMonitor;
        if (cpuMonitor != null) {
            cpuMonitor.pause();
        }
        ErrorInfoReport.getInstance().resetParam();
        this.mHUDStatisticsMap.clear();
        this.peerConnectionClient = null;
        this.mWebSocketChannel = null;
        AudioFilter audioFilter = this.mAudioFilter;
        if (audioFilter != null) {
            audioFilter.k(null);
            this.mAudioFilter.g();
        }
        RTCVideoView rTCVideoView = this.mLocalRender;
        if (rTCVideoView != null) {
            rTCVideoView.release();
            this.mLocalRender = null;
        }
        if (this.mRemoteRenderList != null) {
            while (true) {
                RTCVideoView[] rTCVideoViewArr = this.mRemoteRenderList;
                if (i2 >= rTCVideoViewArr.length) {
                    break;
                }
                if (rTCVideoViewArr[i2] != null) {
                    rTCVideoViewArr[i2].release();
                    this.mRemoteRenderList[i2] = null;
                }
                i2++;
            }
        }
        disposeExternalRenderers();
        disposePendingRenderers();
        EglBase eglBase = this.rootEglBase;
        if (eglBase != null) {
            eglBase.release();
        }
        AudioManager audioManager = this.audioManager;
        if (audioManager != null && audioManager.isBluetoothScoOn()) {
            setBluetoothScoOn(Boolean.FALSE);
        }
        if (this.mHeadSetReceiver != null) {
            this.mContext.get().unregisterReceiver(this.mHeadSetReceiver);
            this.mHeadSetReceiver = null;
        }
        System.gc();
        return true;
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void muteCamera(boolean z) {
        if (this.peerConnectionClient != null) {
            this.peerConnectionClient.setVideoEnabled(!z);
        }
        reportRoomEventInfo("MUTE_CAMERA");
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void muteMicphone(boolean z) {
        if (this.peerConnectionClient != null) {
            this.peerConnectionClient.setAudioEnabled(!z);
        }
        reportRoomEventInfo("MUTE_MICPHONE");
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void muteSpeaker(boolean z) {
        if (this.peerConnectionClient != null) {
            this.peerConnectionClient.setSpeakerMute(z);
        }
    }

    @Override // com.baidu.rtc.JanusRTCInterface
    public void onAttribute(BigInteger bigInteger, String str) {
        BaiduRtcRoom.BaiduRtcRoomDelegate baiduRtcRoomDelegate = this.mBaiduRtcRoomDelegate;
        if (baiduRtcRoomDelegate == null) {
            return;
        }
        baiduRtcRoomDelegate.onRoomEventUpdate(303, bigInteger.longValue(), str);
    }

    @Override // com.baidu.rtc.JanusRTCInterface
    public void onComing(BigInteger bigInteger, String str) {
        if (this.mLastLeavingId == bigInteger.longValue()) {
            this.mLastLeavingId = 0L;
        }
        if (this.mLastGoneId == bigInteger.longValue()) {
            this.mLastGoneId = 0L;
        }
        BaiduRtcRoom.BaiduRtcRoomDelegate baiduRtcRoomDelegate = this.mBaiduRtcRoomDelegate;
        if (baiduRtcRoomDelegate == null) {
            return;
        }
        baiduRtcRoomDelegate.onRoomEventUpdate(104, bigInteger.longValue(), str);
    }

    @Override // com.baidu.rtc.JanusRTCInterface
    public void onConnectError() {
        if (this.mIsEnableErrorInfoMonitor) {
            ErrorInfoReport.getInstance().reportErrorInfo(ErrorInfoReport.ErrorCode.ENTER_FAILED);
        }
        if (this.mIsEnablePushQualityMonitor && !this.mIsLoginSuccess) {
            reportSLILoginEvent(CommonDefine.SLILoginEvent.ENTER_FAILED);
        }
        BaiduRtcRoom.BaiduRtcRoomDelegate baiduRtcRoomDelegate = this.mBaiduRtcRoomDelegate;
        if (baiduRtcRoomDelegate == null) {
            return;
        }
        baiduRtcRoomDelegate.onRoomEventUpdate(103, 0L, "coennection Error");
        reportRoomEventInfo("CONNECTION_LOST");
    }

    @Override // com.baidu.rtc.JanusRTCInterface
    public void onCreatedHandle(BigInteger bigInteger, long j) {
        this.mIsLoginSuccess = false;
        if (this.mIsEnablePushQualityMonitor) {
            reportSLILoginEvent(CommonDefine.SLILoginEvent.ENTER_BEGIN, j);
        }
    }

    @Override // com.baidu.rtc.JanusRTCInterface
    public void onHangUp(BigInteger bigInteger) {
        if (this.mIsEnableErrorInfoMonitor) {
            ErrorInfoReport.getInstance().reportErrorInfo(ErrorInfoReport.ErrorCode.HANG_UP);
        }
        BaiduRtcRoom.BaiduRtcRoomDelegate baiduRtcRoomDelegate = this.mBaiduRtcRoomDelegate;
        if (baiduRtcRoomDelegate == null) {
            return;
        }
        baiduRtcRoomDelegate.onPeerConnectStateUpdate(2003);
    }

    @Override // com.baidu.rtc.PeerConnectionClient.PeerConnectionEvents
    public void onIceCandidate(IceCandidate iceCandidate, BigInteger bigInteger) {
        Log.e(TAG, "=========onIceCandidate========");
        if (iceCandidate != null) {
            this.mWebSocketChannel.trickleCandidate(bigInteger, iceCandidate);
        } else {
            this.mWebSocketChannel.trickleCandidateComplete(bigInteger);
        }
    }

    @Override // com.baidu.rtc.PeerConnectionClient.PeerConnectionEvents
    public void onIceCandidatesRemoved(IceCandidate[] iceCandidateArr) {
    }

    @Override // com.baidu.rtc.PeerConnectionClient.PeerConnectionEvents
    public void onIceConnected() {
    }

    @Override // com.baidu.rtc.PeerConnectionClient.PeerConnectionEvents
    public void onIceDisconnected() {
    }

    @Override // com.baidu.rtc.PeerConnectionClient.PeerConnectionEvents
    public void onIceFailed() {
        if (this.mIsEnableErrorInfoMonitor) {
            ErrorInfoReport.getInstance().reportErrorInfo(ErrorInfoReport.ErrorCode.MEDIA_CHANNEL_CONNECTION_LOST);
            ErrorInfoReport.getInstance().reportErrorInfo(ErrorInfoReport.ErrorCode.ENTER_FAILED);
        }
        if (this.mIsEnablePushQualityMonitor && !this.mIsLoginSuccess) {
            reportSLILoginEvent(CommonDefine.SLILoginEvent.ENTER_FAILED);
        }
        BaiduRtcRoom.BaiduRtcRoomDelegate baiduRtcRoomDelegate = this.mBaiduRtcRoomDelegate;
        if (baiduRtcRoomDelegate != null) {
            baiduRtcRoomDelegate.onPeerConnectStateUpdate(2003);
        }
    }

    @Override // com.baidu.rtc.JanusRTCInterface
    public void onLeaving(BigInteger bigInteger, final BigInteger bigInteger2) {
        int i2;
        Log.i(TAG, "==================onLeaving=======================");
        final JanusHandle handleByFeed = this.mWebSocketChannel.getHandleByFeed(bigInteger2);
        this.mHandler.post(new Runnable() { // from class: com.baidu.rtc.internal.BaiduRtcRoomImp.14
            @Override // java.lang.Runnable
            public void run() {
                BaiduRtcRoomImp.this.mRemoteStreamStats.remove(bigInteger2);
                JanusHandle janusHandle = handleByFeed;
                if (janusHandle != null) {
                    BigInteger bigInteger3 = janusHandle.handleId;
                    if (BaiduRtcRoomImp.this.mHUDStatisticsMap.get(bigInteger3) != null) {
                        BaiduRtcRoomImp.this.mHUDStatisticsMap.remove(bigInteger3);
                        if (BaiduRtcRoomImp.this.peerConnectionClient != null) {
                            BaiduRtcRoomImp.this.peerConnectionClient.enableStatsEvents(false, 0, bigInteger3, PeerConnectionClient.StatsEventsType.GET_QUALITY_MONITOR_EVENT);
                            BaiduRtcRoomImp.this.peerConnectionClient.enableStatsEvents(false, 0, bigInteger3, PeerConnectionClient.StatsEventsType.GET_SLI_EVENT);
                        }
                    }
                }
            }
        });
        JanusConnection janusConnectionByHandleID = this.peerConnectionClient.getJanusConnectionByHandleID(bigInteger);
        if (janusConnectionByHandleID != null && janusConnectionByHandleID.audioTrack != null) {
            this.mBaiduRtcRoomDelegate.onRoomEventUpdate(109, bigInteger2.longValue(), "remote audio gone");
            janusConnectionByHandleID.audioTrack = null;
        }
        if (this.mParamSettings.VideoRenderMode == RtcParameterSettings.RtcVideoRenderMode.RTC_VIDEO_RENDER_MODE_EXTERNAL) {
            RTCVideoExternalRender rTCVideoExternalRender = this.mUserIdVideoRendererMap.get(Long.valueOf(bigInteger2.longValue()));
            if (rTCVideoExternalRender == null || janusConnectionByHandleID == null) {
                Log.d(TAG, "No external render has found!");
            } else {
                Log.d(TAG, "remove external video sink of user " + bigInteger2);
                rTCVideoExternalRender.leaving();
                rTCVideoExternalRender.clearImage();
                VideoTrack videoTrack = janusConnectionByHandleID.videoTrack;
                if (videoTrack != null) {
                    videoTrack.removeSink(rTCVideoExternalRender);
                }
                userRenderMove2PendingMap(bigInteger2.longValue());
                if (this.mBaiduRtcRoomDelegate != null) {
                    if (this.mLastGoneId == bigInteger2.longValue()) {
                        return;
                    }
                    this.mBaiduRtcRoomDelegate.onRoomEventUpdate(107, bigInteger2.longValue(), "gone");
                    this.mLastGoneId = bigInteger2.longValue();
                    return;
                }
            }
        }
        if (janusConnectionByHandleID != null && (i2 = janusConnectionByHandleID.videoview_tag) >= 0) {
            boolean[] zArr = this.mHasVideoView;
            if (i2 < zArr.length) {
                zArr[i2] = false;
                this.mRemoteVideoCnt--;
                RTCVideoView[] rTCVideoViewArr = this.mRemoteRenderList;
                if (rTCVideoViewArr[i2] != null) {
                    rTCVideoViewArr[i2].clearImage();
                    VideoTrack videoTrack2 = janusConnectionByHandleID.videoTrack;
                    if (videoTrack2 != null) {
                        videoTrack2.removeSink(this.mRemoteRenderList[i2]);
                    }
                    if (this.mBaiduRtcRoomDelegate != null) {
                        if (this.mLastGoneId == bigInteger2.longValue()) {
                            return;
                        }
                        this.mBaiduRtcRoomDelegate.onRoomEventUpdate(107, bigInteger2.longValue(), "gone");
                        this.mLastGoneId = bigInteger2.longValue();
                        return;
                    }
                }
            }
        }
        if (this.mBaiduRtcRoomDelegate != null) {
            if (this.mLastLeavingId == bigInteger2.longValue()) {
                return;
            }
            this.mFeedToViewMap.remove(bigInteger2);
            this.mBaiduRtcRoomDelegate.onRoomEventUpdate(105, bigInteger2.longValue(), "leaving");
        }
        this.mLastLeavingId = bigInteger2.longValue();
        reportRoomEventInfo("REMOTE_LEAVING_" + bigInteger2 + "_" + bigInteger);
    }

    @Override // com.baidu.rtc.JanusRTCInterface
    public void onLivePublishFailed(BaiduRtcRoom.RtcLiveTransferMode rtcLiveTransferMode, String str) {
        ErrorInfoReport errorInfoReport;
        ErrorInfoReport.ErrorCode errorCode;
        if (this.mIsEnableErrorInfoMonitor) {
            if (rtcLiveTransferMode.ordinal() == BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ROOM_TRANSMISSION.ordinal()) {
                errorInfoReport = ErrorInfoReport.getInstance();
                errorCode = ErrorInfoReport.ErrorCode.ROOM_LIVE_PUBLISH_FAIL;
            } else {
                errorInfoReport = ErrorInfoReport.getInstance();
                errorCode = ErrorInfoReport.ErrorCode.ANCHOR_LIVE_PUBLISH_FAIL;
            }
            errorInfoReport.reportErrorInfo(errorCode);
        }
        BaiduRtcRoom.BaiduRtcRoomDelegate baiduRtcRoomDelegate = this.mBaiduRtcRoomDelegate;
        if (baiduRtcRoomDelegate == null) {
            return;
        }
        baiduRtcRoomDelegate.onRoomEventUpdate(117, rtcLiveTransferMode.ordinal(), str);
    }

    @Override // com.baidu.rtc.JanusRTCInterface
    public void onLivePublishInterrupted(BaiduRtcRoom.RtcLiveTransferMode rtcLiveTransferMode, String str) {
        ErrorInfoReport errorInfoReport;
        ErrorInfoReport.ErrorCode errorCode;
        if (this.mIsEnableErrorInfoMonitor) {
            if (rtcLiveTransferMode.ordinal() == BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ROOM_TRANSMISSION.ordinal()) {
                errorInfoReport = ErrorInfoReport.getInstance();
                errorCode = ErrorInfoReport.ErrorCode.ROOM_LIVE_INTRERRUPT;
            } else {
                errorInfoReport = ErrorInfoReport.getInstance();
                errorCode = ErrorInfoReport.ErrorCode.ANCHOR_LIVE_INTRERRUPT;
            }
            errorInfoReport.reportErrorInfo(errorCode);
        }
        BaiduRtcRoom.BaiduRtcRoomDelegate baiduRtcRoomDelegate = this.mBaiduRtcRoomDelegate;
        if (baiduRtcRoomDelegate == null) {
            return;
        }
        baiduRtcRoomDelegate.onRoomEventUpdate(118, rtcLiveTransferMode.ordinal(), str);
    }

    @Override // com.baidu.rtc.JanusRTCInterface
    public void onLivePublishSucceed(BaiduRtcRoom.RtcLiveTransferMode rtcLiveTransferMode, String str) {
        BaiduRtcRoom.BaiduRtcRoomDelegate baiduRtcRoomDelegate = this.mBaiduRtcRoomDelegate;
        if (baiduRtcRoomDelegate == null) {
            return;
        }
        baiduRtcRoomDelegate.onRoomEventUpdate(116, rtcLiveTransferMode.ordinal(), str);
    }

    @Override // com.baidu.rtc.PeerConnectionClient.PeerConnectionEvents
    public void onLocalDescription(SessionDescription sessionDescription, BigInteger bigInteger, boolean z) {
        Log.e(TAG, sessionDescription.type.toString());
        WebSocketChannel webSocketChannel = this.mWebSocketChannel;
        if (webSocketChannel == null) {
            return;
        }
        this.isEnableHighProfileConfirm = z;
        webSocketChannel.publisherCreateOffer(bigInteger, sessionDescription);
        this.mHandler.post(new Runnable() { // from class: com.baidu.rtc.internal.BaiduRtcRoomImp.15
            @Override // java.lang.Runnable
            public void run() {
                if (BaiduRtcRoomImp.this.peerConnectionClient == null || BaiduRtcRoomImp.this.peerConnectionParameters.videoMaxkbps <= 0) {
                    return;
                }
                Log.d(BaiduRtcRoomImp.TAG, "Set video maximum bitrate: " + BaiduRtcRoomImp.this.peerConnectionParameters.videoMaxkbps);
                BaiduRtcRoomImp.this.peerConnectionClient.setVideoMaxBitrate(Integer.valueOf(BaiduRtcRoomImp.this.peerConnectionParameters.videoMaxkbps));
            }
        });
    }

    @Override // com.baidu.rtc.JanusRTCInterface
    public void onLoginError() {
        if (this.mIsEnableErrorInfoMonitor) {
            ErrorInfoReport.getInstance().reportErrorInfo(ErrorInfoReport.ErrorCode.LOGIN_ERROR);
            ErrorInfoReport.getInstance().reportErrorInfo(ErrorInfoReport.ErrorCode.ENTER_FAILED);
        }
        if (this.mIsEnablePushQualityMonitor && !this.mIsLoginSuccess) {
            reportSLILoginEvent(CommonDefine.SLILoginEvent.ENTER_FAILED);
        }
        BaiduRtcRoom.BaiduRtcRoomDelegate baiduRtcRoomDelegate = this.mBaiduRtcRoomDelegate;
        if (baiduRtcRoomDelegate == null) {
            return;
        }
        baiduRtcRoomDelegate.onRoomEventUpdate(102, 0L, "error");
        reportRoomEventInfo("LOGIN_ERROR");
    }

    @Override // com.baidu.rtc.JanusRTCInterface
    public void onLoginTimeout() {
        if (this.mIsEnableErrorInfoMonitor) {
            ErrorInfoReport.getInstance().reportErrorInfo(ErrorInfoReport.ErrorCode.LOGIN_TIMEOUT);
            ErrorInfoReport.getInstance().reportErrorInfo(ErrorInfoReport.ErrorCode.ENTER_FAILED);
        }
        if (this.mIsEnablePushQualityMonitor && !this.mIsLoginSuccess) {
            reportSLILoginEvent(CommonDefine.SLILoginEvent.ENTER_FAILED);
        }
        BaiduRtcRoom.BaiduRtcRoomDelegate baiduRtcRoomDelegate = this.mBaiduRtcRoomDelegate;
        if (baiduRtcRoomDelegate == null) {
            return;
        }
        baiduRtcRoomDelegate.onRoomEventUpdate(101, 0L, "time out");
    }

    @Override // com.baidu.rtc.JanusRTCInterface
    public void onMediaStreamingEvent(BigInteger bigInteger, int i2, boolean z) {
        ErrorInfoReport errorInfoReport;
        ErrorInfoReport.ErrorCode errorCode;
        if (this.mIsEnableErrorInfoMonitor) {
            if (i2 == 1 && !z) {
                errorInfoReport = ErrorInfoReport.getInstance();
                errorCode = ErrorInfoReport.ErrorCode.VIDEO_SENDING_MEDIA_FAILED;
            } else if (i2 == 0 && !z) {
                errorInfoReport = ErrorInfoReport.getInstance();
                errorCode = ErrorInfoReport.ErrorCode.AUDIO_SENDING_MEDIA_FAILED;
            }
            errorInfoReport.reportErrorInfo(errorCode);
        }
        BaiduRtcRoom.BaiduRtcRoomDelegate baiduRtcRoomDelegate = this.mBaiduRtcRoomDelegate;
        if (baiduRtcRoomDelegate == null) {
            return;
        }
        baiduRtcRoomDelegate.onPeerConnectStateUpdate(z ? 2001 : 2002);
    }

    @Override // com.baidu.rtc.JanusRTCInterface
    public void onMessage(BigInteger bigInteger, String str) {
        BaiduRtcRoom.BaiduRtcRoomDelegate baiduRtcRoomDelegate = this.mBaiduRtcRoomDelegate;
        if (baiduRtcRoomDelegate == null) {
            return;
        }
        baiduRtcRoomDelegate.onRoomEventUpdate(302, bigInteger.longValue(), str);
    }

    @Override // com.baidu.rtc.PeerConnectionClient.PeerConnectionEvents
    public void onPeerConnectionClosed() {
    }

    @Override // com.baidu.rtc.PeerConnectionClient.PeerConnectionEvents
    public void onPeerConnectionError(String str) {
        if (this.mIsEnableErrorInfoMonitor) {
            ErrorInfoReport.getInstance().reportErrorInfo(ErrorInfoReport.ErrorCode.PEERCONNECTION_CREATE_ERROR);
            ErrorInfoReport.getInstance().reportErrorInfo(ErrorInfoReport.ErrorCode.ENTER_FAILED);
        }
        if (this.mIsEnablePushQualityMonitor && !this.mIsLoginSuccess) {
            reportSLILoginEvent(CommonDefine.SLILoginEvent.ENTER_FAILED);
        }
        BaiduRtcRoom.BaiduRtcRoomDelegate baiduRtcRoomDelegate = this.mBaiduRtcRoomDelegate;
        if (baiduRtcRoomDelegate != null) {
            baiduRtcRoomDelegate.onErrorInfoUpdate(10000);
        }
    }

    @Override // com.baidu.rtc.PeerConnectionClient.PeerConnectionEvents
    public void onPeerConnectionStatsReady(final StatsReport[] statsReportArr, final BigInteger bigInteger, final PeerConnectionClient.StatsEventsType statsEventsType) {
        if (bigInteger == this.mPublisherHandle && statsEventsType == PeerConnectionClient.StatsEventsType.GET_BWE_EVENT && this.mbOnStatistics) {
            updateBweStatistics(statsReportArr);
        }
        this.mHandler.post(new Runnable() { // from class: com.baidu.rtc.internal.BaiduRtcRoomImp.16
            @Override // java.lang.Runnable
            public void run() {
                if (statsEventsType == PeerConnectionClient.StatsEventsType.GET_AUDIOLEVEL_EVENT) {
                    BaiduRtcRoomImp.this.parseAudioLeves(statsReportArr, bigInteger);
                }
                HUDStatistics hUDStatistics = (HUDStatistics) BaiduRtcRoomImp.this.mHUDStatisticsMap.get(bigInteger);
                if (hUDStatistics != null) {
                    hUDStatistics.updateEncoderStatistics(statsReportArr);
                }
                BaiduRtcRoomImp baiduRtcRoomImp = BaiduRtcRoomImp.this;
                if ((baiduRtcRoomImp.mIsEnablePushQualityMonitor || baiduRtcRoomImp.mIsEnablePullQualityMonitor) && statsEventsType == PeerConnectionClient.StatsEventsType.GET_QUALITY_MONITOR_EVENT) {
                    BigInteger bigInteger2 = bigInteger;
                    BaiduRtcRoomImp baiduRtcRoomImp2 = BaiduRtcRoomImp.this;
                    if (bigInteger2 == baiduRtcRoomImp2.mPublisherHandle && baiduRtcRoomImp2.rtcLogReport != null) {
                        baiduRtcRoomImp2.reportCommunicationQualityInfo();
                    }
                }
                BaiduRtcRoomImp baiduRtcRoomImp3 = BaiduRtcRoomImp.this;
                if ((baiduRtcRoomImp3.mIsEnablePushQualityMonitor || baiduRtcRoomImp3.mIsEnablePullQualityMonitor) && statsEventsType == PeerConnectionClient.StatsEventsType.GET_SLI_EVENT) {
                    BigInteger bigInteger3 = bigInteger;
                    BaiduRtcRoomImp baiduRtcRoomImp4 = BaiduRtcRoomImp.this;
                    if (bigInteger3 != baiduRtcRoomImp4.mPublisherHandle || baiduRtcRoomImp4.rtcLogReport == null) {
                        return;
                    }
                    baiduRtcRoomImp4.reportSLIStuckInfo();
                }
            }
        });
    }

    @Override // com.baidu.rtc.JanusRTCInterface
    public void onPublisherJoined(final BigInteger bigInteger) {
        BaiduRtcRoom.BaiduRtcRoomDelegate baiduRtcRoomDelegate = this.mBaiduRtcRoomDelegate;
        if (baiduRtcRoomDelegate != null) {
            baiduRtcRoomDelegate.onRoomEventUpdate(100, 0L, "ok");
        }
        this.mPublisherHandle = bigInteger;
        ErrorInfoReport.getInstance().setPublishHandleId(this.mPublisherHandle.longValue());
        if (this.mParamSettings.AutoPublish) {
            offerPeerConnection(bigInteger);
        }
        if (this.mbOnStatistics && this.peerConnectionClient != null) {
            this.peerConnectionClient.enableStatsEvents(this.mbOnStatistics, 5000, this.mPublisherHandle, PeerConnectionClient.StatsEventsType.GET_BWE_EVENT);
        }
        this.mHandler.post(new Runnable() { // from class: com.baidu.rtc.internal.BaiduRtcRoomImp.12
            @Override // java.lang.Runnable
            public void run() {
                BaiduRtcRoomImp baiduRtcRoomImp = BaiduRtcRoomImp.this;
                if ((baiduRtcRoomImp.mIsEnablePushQualityMonitor || baiduRtcRoomImp.mIsEnablePullQualityMonitor) && BaiduRtcRoomImp.this.peerConnectionClient != null) {
                    if (BaiduRtcRoomImp.this.mHUDStatisticsMap.get(bigInteger) != null) {
                        BaiduRtcRoomImp.this.peerConnectionClient.enableStatsEvents(false, 0, bigInteger, PeerConnectionClient.StatsEventsType.GET_QUALITY_MONITOR_EVENT);
                        BaiduRtcRoomImp.this.peerConnectionClient.enableStatsEvents(false, 0, bigInteger, PeerConnectionClient.StatsEventsType.GET_SLI_EVENT);
                        BaiduRtcRoomImp.this.mHUDStatisticsMap.remove(bigInteger);
                    }
                    PeerConnectionClient peerConnectionClient = BaiduRtcRoomImp.this.peerConnectionClient;
                    BaiduRtcRoomImp baiduRtcRoomImp2 = BaiduRtcRoomImp.this;
                    peerConnectionClient.enableStatsEvents(baiduRtcRoomImp2.mIsEnablePushQualityMonitor || baiduRtcRoomImp2.mIsEnablePullQualityMonitor, 2000, bigInteger, PeerConnectionClient.StatsEventsType.GET_QUALITY_MONITOR_EVENT);
                    PeerConnectionClient peerConnectionClient2 = BaiduRtcRoomImp.this.peerConnectionClient;
                    BaiduRtcRoomImp baiduRtcRoomImp3 = BaiduRtcRoomImp.this;
                    peerConnectionClient2.enableStatsEvents(baiduRtcRoomImp3.mIsEnablePushQualityMonitor || baiduRtcRoomImp3.mIsEnablePullQualityMonitor, 5000, bigInteger, PeerConnectionClient.StatsEventsType.GET_SLI_EVENT);
                    BaiduRtcRoomImp.this.mHUDStatisticsMap.put(bigInteger, new HUDStatistics());
                    BaiduRtcRoomImp baiduRtcRoomImp4 = BaiduRtcRoomImp.this;
                    if (baiduRtcRoomImp4.rtcLogReport != null && !baiduRtcRoomImp4.mbStartReportDI) {
                        baiduRtcRoomImp4.mbStartReportDI = true;
                        baiduRtcRoomImp4.mHandler.post(BaiduRtcRoomImp.this.reportDeviceInfoRun);
                    }
                    BaiduRtcRoomImp baiduRtcRoomImp5 = BaiduRtcRoomImp.this;
                    baiduRtcRoomImp5.reportRoomEventInfo("RTCROOM_LOGIN_OK_" + BaiduRtcRoomImp.this.mUserId);
                }
                StreamStats streamStats = (StreamStats) BaiduRtcRoomImp.this.mRemoteStreamStats.get(BigInteger.valueOf(BaiduRtcRoomImp.this.mUserId));
                if (streamStats != null) {
                    if (BaiduRtcRoomImp.this.peerConnectionClient != null) {
                        BaiduRtcRoomImp.this.peerConnectionClient.enableStatsEvents(false, 0, streamStats.handleId, PeerConnectionClient.StatsEventsType.GET_AUDIOLEVEL_EVENT);
                    }
                    streamStats.hasVideo = Boolean.valueOf(BaiduRtcRoomImp.this.mParamSettings.HasVideo);
                    streamStats.hasAudio = Boolean.valueOf(BaiduRtcRoomImp.this.mParamSettings.HasAudio);
                    streamStats.handleId = bigInteger;
                    streamStats.nickName = BaiduRtcRoomImp.this.mDisplayName;
                } else {
                    BigInteger bigInteger2 = bigInteger;
                    BaiduRtcRoomImp baiduRtcRoomImp6 = BaiduRtcRoomImp.this;
                    BaiduRtcRoomImp.this.mRemoteStreamStats.put(BigInteger.valueOf(BaiduRtcRoomImp.this.mUserId), new StreamStats(bigInteger2, baiduRtcRoomImp6.mUserId, Boolean.valueOf(baiduRtcRoomImp6.mParamSettings.HasVideo), Boolean.valueOf(BaiduRtcRoomImp.this.mParamSettings.HasAudio), BaiduRtcRoomImp.this.mDisplayName));
                }
                if (BaiduRtcRoomImp.this.peerConnectionClient != null) {
                    BaiduRtcRoomImp.this.peerConnectionClient.enableStatsEvents(true, 200, bigInteger, PeerConnectionClient.StatsEventsType.GET_AUDIOLEVEL_EVENT);
                }
            }
        });
    }

    @Override // com.baidu.rtc.JanusRTCInterface
    public void onPublisherRemoteJsep(BigInteger bigInteger, JSONObject jSONObject) {
        SessionDescription.Type fromCanonicalForm = SessionDescription.Type.fromCanonicalForm(jSONObject.optString("type"));
        String optString = jSONObject.optString("sdp");
        if (this.mParamSettings.EnableHighProfile && this.isEnableHighProfileConfirm && optString.contains("profile-level-id=42e01f")) {
            optString = optString.replace("profile-level-id=42e01f", "profile-level-id=640c1f");
            Log.e(TAG, "enable high profile, remote jsep changed: " + optString);
        }
        this.peerConnectionClient.setRemoteDescription(bigInteger, new SessionDescription(fromCanonicalForm, optString));
    }

    @Override // com.baidu.rtc.PeerConnectionClient.PeerConnectionEvents
    public void onRemoteData(ByteBuffer byteBuffer) {
        BaiduRtcRoom.BaiduRtcRoomDelegate baiduRtcRoomDelegate = this.mBaiduRtcRoomDelegate;
        if (baiduRtcRoomDelegate == null) {
            return;
        }
        baiduRtcRoomDelegate.onRoomDataMessage(byteBuffer);
    }

    @Override // com.baidu.rtc.PeerConnectionClient.PeerConnectionEvents
    public void onRemoteDescription(SessionDescription sessionDescription, BigInteger bigInteger) {
        Log.e(TAG, sessionDescription.type.toString());
        this.mWebSocketChannel.subscriberCreateAnswer(bigInteger, sessionDescription);
    }

    @Override // com.baidu.rtc.JanusRTCInterface
    public void onRemoteGone(BigInteger bigInteger) {
        if (this.peerConnectionClient != null) {
            this.peerConnectionClient.closePeer(bigInteger);
        }
    }

    @Override // com.baidu.rtc.PeerConnectionClient.PeerConnectionEvents
    public void onRemoteRender(final JanusConnection janusConnection) {
        int i2;
        RTCVideoView[] rTCVideoViewArr;
        Log.e(TAG, "=========onRemoteRender========" + janusConnection.videoTrack);
        final BigInteger feedByHandle = this.mWebSocketChannel.getFeedByHandle(janusConnection.handleId);
        if (feedByHandle.longValue() == 0) {
            Log.e(TAG, "onRemoteRender Userid is 0.");
        } else if (this.mParamSettings.VideoRenderMode == RtcParameterSettings.RtcVideoRenderMode.RTC_VIDEO_RENDER_MODE_EXTERNAL) {
            RTCVideoExternalRender externalRender = getExternalRender(feedByHandle.longValue());
            Log.d(TAG, "enable external video render mode with videoRenderer -> " + externalRender);
            if (externalRender != null) {
                janusConnection.videoTrack.addSink(externalRender);
                externalRender.setStuckEventListener(new VideoStuckEvent(janusConnection.handleId));
                externalRender.setEnableSLIDataReport(this.mIsEnablePullQualityMonitor);
            } else {
                Log.d(TAG, "Not found external render for user " + feedByHandle);
            }
            onFfDelayChange(janusConnection, feedByHandle);
            this.mBaiduRtcRoomDelegate.onRoomEventUpdate(106, feedByHandle.longValue(), "");
        } else {
            Log.d(TAG, "it is internal video render mode");
            int i3 = -1;
            try {
                i2 = this.mFeedToViewMap.get(this.mWebSocketChannel.getFeedByHandle(janusConnection.handleId)).intValue();
            } catch (Exception unused) {
                i2 = -1;
            }
            if (i2 >= 0 && i2 < MAX_VIDEOVIEW_CNT && (rTCVideoViewArr = this.mRemoteRenderList) != null) {
                if (rTCVideoViewArr[i2] != null) {
                    rTCVideoViewArr[i2].setFirstFrameEventListener(new Runnable() { // from class: com.baidu.rtc.internal.BaiduRtcRoomImp.18
                        @Override // java.lang.Runnable
                        public void run() {
                            BaiduRtcRoom.BaiduRtcRoomDelegate baiduRtcRoomDelegate = BaiduRtcRoomImp.this.mBaiduRtcRoomDelegate;
                            if (baiduRtcRoomDelegate != null) {
                                baiduRtcRoomDelegate.onRoomEventUpdate(106, feedByHandle.longValue(), "");
                            }
                            BaiduRtcRoomImp.this.onFfDelayChange(janusConnection, feedByHandle);
                        }
                    });
                    this.mRemoteRenderList[i2].setStuckEventListener(new VideoStuckEvent(janusConnection.handleId));
                    this.mRemoteRenderList[i2].setEnableSLIDataReport(this.mIsEnablePullQualityMonitor);
                    janusConnection.videoTrack.addSink(this.mRemoteRenderList[i2]);
                }
                janusConnection.videoview_tag = i2;
            } else if (this.mRemoteRenderList != null) {
                int i4 = 0;
                while (true) {
                    boolean[] zArr = this.mHasVideoView;
                    if (i4 >= zArr.length) {
                        break;
                    } else if (!zArr[i4]) {
                        zArr[i4] = true;
                        i3 = i4;
                        break;
                    } else {
                        i4++;
                    }
                }
                if (i3 >= 0) {
                    RTCVideoView[] rTCVideoViewArr2 = this.mRemoteRenderList;
                    if (rTCVideoViewArr2[i3] != null) {
                        rTCVideoViewArr2[i3].setFirstFrameEventListener(new Runnable() { // from class: com.baidu.rtc.internal.BaiduRtcRoomImp.19
                            @Override // java.lang.Runnable
                            public void run() {
                                BaiduRtcRoom.BaiduRtcRoomDelegate baiduRtcRoomDelegate = BaiduRtcRoomImp.this.mBaiduRtcRoomDelegate;
                                if (baiduRtcRoomDelegate != null) {
                                    baiduRtcRoomDelegate.onRoomEventUpdate(106, feedByHandle.longValue(), "");
                                }
                                BaiduRtcRoomImp.this.onFfDelayChange(janusConnection, feedByHandle);
                            }
                        });
                        this.mRemoteRenderList[i3].setStuckEventListener(new VideoStuckEvent(janusConnection.handleId));
                        this.mRemoteRenderList[i3].setEnableSLIDataReport(this.mIsEnablePullQualityMonitor);
                        janusConnection.videoTrack.addSink(this.mRemoteRenderList[i3]);
                    }
                    janusConnection.videoview_tag = i3;
                }
                this.mRemoteVideoCnt++;
            }
        }
    }

    @Override // com.baidu.rtc.PeerConnectionClient.PeerConnectionEvents
    public void onRemoteStreamStats(final Boolean bool, final Boolean bool2, final BigInteger bigInteger) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.rtc.internal.BaiduRtcRoomImp.17
            @Override // java.lang.Runnable
            public void run() {
                if (BaiduRtcRoomImp.this.mWebSocketChannel == null) {
                    return;
                }
                BigInteger feedByHandle = BaiduRtcRoomImp.this.mWebSocketChannel.getFeedByHandle(bigInteger);
                String nickNameByFeed = BaiduRtcRoomImp.this.mWebSocketChannel.getNickNameByFeed(feedByHandle);
                StreamStats streamStats = (StreamStats) BaiduRtcRoomImp.this.mRemoteStreamStats.get(feedByHandle);
                if (streamStats == null) {
                    streamStats = new StreamStats(bigInteger, feedByHandle.longValue(), bool, bool2, nickNameByFeed);
                    BaiduRtcRoomImp.this.mRemoteStreamStats.put(feedByHandle, streamStats);
                } else {
                    streamStats.hasVideo = bool;
                    streamStats.hasAudio = bool2;
                    streamStats.handleId = bigInteger;
                    streamStats.nickName = nickNameByFeed;
                }
                if (bool2.booleanValue()) {
                    BaiduRtcRoom.BaiduRtcRoomDelegate baiduRtcRoomDelegate = BaiduRtcRoomImp.this.mBaiduRtcRoomDelegate;
                    if (baiduRtcRoomDelegate != null) {
                        baiduRtcRoomDelegate.onRoomEventUpdate(108, feedByHandle.longValue(), "");
                    }
                    if (BaiduRtcRoomImp.this.peerConnectionClient != null) {
                        BaiduRtcRoomImp.this.peerConnectionClient.enableStatsEvents(true, 200, streamStats.handleId, PeerConnectionClient.StatsEventsType.GET_AUDIOLEVEL_EVENT);
                    }
                }
            }
        });
    }

    @Override // com.baidu.rtc.JanusRTCInterface
    public void onRoomDisbanded() {
        BaiduRtcRoom.BaiduRtcRoomDelegate baiduRtcRoomDelegate = this.mBaiduRtcRoomDelegate;
        if (baiduRtcRoomDelegate == null) {
            return;
        }
        baiduRtcRoomDelegate.onRoomEventUpdate(112, 0L, "");
    }

    @Override // com.baidu.rtc.JanusRTCInterface
    public void onServerAckTimeout() {
        BaiduRtcRoom.BaiduRtcRoomDelegate baiduRtcRoomDelegate = this.mBaiduRtcRoomDelegate;
        if (baiduRtcRoomDelegate == null) {
            return;
        }
        baiduRtcRoomDelegate.onErrorInfoUpdate(402);
    }

    @Override // com.baidu.rtc.JanusRTCInterface
    public void onSignalErrorInfo(int i2) {
        if (this.mBaiduRtcRoomDelegate != null && i2 == 436) {
            if (this.mIsEnableErrorInfoMonitor) {
                ErrorInfoReport.getInstance().reportErrorInfo(ErrorInfoReport.ErrorCode.USR_ALREADY_EXIST);
            }
            this.mBaiduRtcRoomDelegate.onErrorInfoUpdate(436);
        }
    }

    @Override // com.baidu.rtc.JanusRTCInterface
    public void onSlowLink(boolean z, int i2) {
        if (this.mBaiduRtcRoomDelegate == null) {
            return;
        }
        this.mBaiduRtcRoomDelegate.onPeerConnectStateUpdate(i2 < 10 ? 2100 : i2 < 15 ? 2101 : i2 < 25 ? 2102 : i2 < 40 ? 2103 : i2 < 60 ? 2104 : i2 < 90 ? 2105 : i2 < 120 ? 2106 : i2 < 180 ? 2107 : i2 < 250 ? 2108 : 2109);
    }

    @Override // com.baidu.rtc.JanusRTCInterface
    public void onUserDisShutUp(long j) {
        BaiduRtcRoom.BaiduRtcRoomDelegate baiduRtcRoomDelegate = this.mBaiduRtcRoomDelegate;
        if (baiduRtcRoomDelegate == null) {
            return;
        }
        baiduRtcRoomDelegate.onRoomEventUpdate(114, j, "");
    }

    @Override // com.baidu.rtc.JanusRTCInterface
    public void onUserJoinedRoom(BigInteger bigInteger, String str, String str2) {
        BaiduRtcRoom.BaiduRtcRoomDelegate baiduRtcRoomDelegate = this.mBaiduRtcRoomDelegate;
        if (baiduRtcRoomDelegate == null) {
            return;
        }
        baiduRtcRoomDelegate.onRoomEventUpdate(300, bigInteger.longValue(), str);
    }

    @Override // com.baidu.rtc.JanusRTCInterface
    public void onUserKickOff(long j) {
        BaiduRtcRoom.BaiduRtcRoomDelegate baiduRtcRoomDelegate = this.mBaiduRtcRoomDelegate;
        if (baiduRtcRoomDelegate == null) {
            return;
        }
        baiduRtcRoomDelegate.onRoomEventUpdate(115, j, "");
    }

    @Override // com.baidu.rtc.JanusRTCInterface
    public void onUserLeavingRoom(BigInteger bigInteger) {
        BaiduRtcRoom.BaiduRtcRoomDelegate baiduRtcRoomDelegate = this.mBaiduRtcRoomDelegate;
        if (baiduRtcRoomDelegate == null) {
            return;
        }
        baiduRtcRoomDelegate.onRoomEventUpdate(301, bigInteger.longValue(), "");
    }

    @Override // com.baidu.rtc.JanusRTCInterface
    public void onUserShutUp(long j) {
        BaiduRtcRoom.BaiduRtcRoomDelegate baiduRtcRoomDelegate = this.mBaiduRtcRoomDelegate;
        if (baiduRtcRoomDelegate == null) {
            return;
        }
        baiduRtcRoomDelegate.onRoomEventUpdate(113, j, "");
    }

    @Override // com.baidu.rtc.JanusRTCInterface
    public void onWebrtcUp(BigInteger bigInteger) {
        if (this.mIsEnablePushQualityMonitor && bigInteger == this.mPublisherHandle) {
            this.mIsLoginSuccess = true;
            long currentTimeMillis = System.currentTimeMillis();
            this.mLoginSuccessTime = currentTimeMillis;
            if (currentTimeMillis - this.mStartLoginTime > 5000) {
                if (this.mIsEnableErrorInfoMonitor) {
                    ErrorInfoReport.getInstance().reportErrorInfo(ErrorInfoReport.ErrorCode.ENTER_TIMEOUT);
                }
                reportSLILoginEvent(CommonDefine.SLILoginEvent.ENTER_TIMEOUT);
            }
        }
        BaiduRtcRoom.BaiduRtcRoomDelegate baiduRtcRoomDelegate = this.mBaiduRtcRoomDelegate;
        if (baiduRtcRoomDelegate == null) {
            return;
        }
        baiduRtcRoomDelegate.onPeerConnectStateUpdate(2000);
        reportRoomEventInfo("WEBRTC_UP_" + bigInteger.longValue());
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void presetLoudSpeaker(boolean z) {
        ((AudioManager) this.mContext.get().getSystemService("audio")).setSpeakerphoneOn(z);
        reportRoomEventInfo("PRESETLOUDSPEAKER");
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void publishStreaming() {
        offerPeerConnection(this.mPublisherHandle);
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void queryEngineStatisticsInfo() {
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public BaiduRtcRoom.UserList queryUserListOfRoom() {
        WebSocketChannel webSocketChannel = this.mWebSocketChannel;
        if (webSocketChannel == null) {
            return null;
        }
        return webSocketChannel.UserListOfRoom();
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void removeExternalRenderer(long j) {
        Log.d(TAG, j + " : Remove external renderer ...");
        if (this.mUserIdVideoRendererMap.containsKey(Long.valueOf(j))) {
            RTCVideoExternalRender rTCVideoExternalRender = this.mUserIdVideoRendererMap.get(Long.valueOf(j));
            if (rTCVideoExternalRender != null) {
                rTCVideoExternalRender.release();
            }
            this.mUserIdVideoRendererMap.remove(Long.valueOf(j));
            return;
        }
        Log.d(TAG, "External render not found to  remove surface for " + j);
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void sendData(ByteBuffer byteBuffer) {
        if (this.peerConnectionClient == null) {
            return;
        }
        this.peerConnectionClient.sendData(byteBuffer);
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void sendMessageToUser(String str, long j) {
        WebSocketChannel webSocketChannel = this.mWebSocketChannel;
        if (webSocketChannel == null) {
            return;
        }
        webSocketChannel.sendMessageToUser(str, j);
        try {
            Thread.sleep(10L);
        } catch (InterruptedException unused) {
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void setAudioRecordDelegate(RTCAudioSamples.RTCSamplesReadyCallback rTCSamplesReadyCallback) {
        this.mSamplesReadyCallback = rTCSamplesReadyCallback;
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void setAuidoSamplesReadyCallback(RTCAudioSamples.RTCSamplesReadyCallback rTCSamplesReadyCallback) {
        this.mSamplesReadyCallback = rTCSamplesReadyCallback;
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void setBaiduRtcAppID(String str, String str2) {
        this.mWebSocketChannel.setAppId(str);
        this.mAppId = str;
        this.mWebSocketChannel.setTokenStr(str2);
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public boolean setBaiduRtcRoomDelegate(BaiduRtcRoom.BaiduRtcRoomDelegate baiduRtcRoomDelegate) {
        this.mBaiduRtcRoomDelegate = baiduRtcRoomDelegate;
        return true;
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void setBuffingFactor(float f2) {
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void setCameraID(int i2) {
        this.mCameraID = i2;
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void setEngineStateStatistics(boolean z) {
        this.mbOnStatistics = z;
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void setExternalSurface(long j, Surface surface) {
        RTCVideoExternalRender externalRender = getExternalRender(j);
        if (externalRender != null) {
            if (!externalRender.isRenderInited()) {
                externalRender.init();
                externalRender.setRenderInited(true);
            }
            for (Long l : this.mUserIdVideoRendererMap.keySet()) {
                RTCVideoExternalRender rTCVideoExternalRender = this.mUserIdVideoRendererMap.get(l);
                if (rTCVideoExternalRender != null && rTCVideoExternalRender.hasSurface() && surface == rTCVideoExternalRender.getSurface() && this.mBaiduRtcRoomDelegate != null) {
                    Log.d(TAG, "Set surface repeat with userId " + j);
                    if (this.mIsEnableErrorInfoMonitor) {
                        ErrorInfoReport.getInstance().reportErrorInfo(ErrorInfoReport.ErrorCode.SET_EXTERNAL_SURFACE_ERROR);
                    }
                    this.mBaiduRtcRoomDelegate.onErrorInfoUpdate(600);
                    return;
                }
            }
            externalRender.setSurface(surface);
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public boolean setLiveStreamingMix(boolean z) {
        this.mWebSocketChannel.setMixing(z);
        return true;
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public boolean setLiveStreamingRole(String str) {
        this.mWebSocketChannel.setLssRole(str);
        return true;
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public boolean setLiveStreamingURL(String str) {
        this.mWebSocketChannel.setLssURL(str);
        return true;
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void setLocalDisplay(RTCVideoView rTCVideoView) {
        this.mLocalRender = rTCVideoView;
        this.mHandler.post(new Runnable() { // from class: com.baidu.rtc.internal.BaiduRtcRoomImp.9
            @Override // java.lang.Runnable
            public void run() {
                if (BaiduRtcRoomImp.this.mLocalRender != null) {
                    try {
                        BaiduRtcRoomImp.this.mLocalRender.init(BaiduRtcRoomImp.this.rootEglBase.getEglBaseContext(), null);
                    } catch (Exception unused) {
                    }
                    BaiduRtcRoomImp.this.mLocalRender.setEnableHardwareScaler(true);
                    if (BaiduRtcRoomImp.this.mVideoCaptureIsFrontCamera) {
                        BaiduRtcRoomImp.this.mLocalRender.setMirror(true);
                    }
                }
            }
        });
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void setMediaServerURL(String str) {
        this.mJanusServerURL = str;
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public boolean setMixLayoutPositionIndex(String str) {
        this.mWebSocketChannel.setMixLayoutPosition(str);
        return true;
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void setMixedAudioSamplesCallback(RTCAudioSamples.RTCMixedSamplesReadyCallback rTCMixedSamplesReadyCallback) {
        this.mMixedSamplesCallback = rTCMixedSamplesReadyCallback;
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void setParamSettings(RtcParameterSettings rtcParameterSettings, RtcParameterSettings.RtcParamSettingType rtcParamSettingType) {
        Handler handler;
        int i2 = AnonymousClass25.$SwitchMap$com$baidu$rtc$RtcParameterSettings$RtcParamSettingType[rtcParamSettingType.ordinal()];
        if (i2 == 1) {
            if (rtcParameterSettings != null) {
                this.mParamSettings = rtcParameterSettings;
                mConfigAudioContenttype = rtcParameterSettings.AudioContentType;
            }
        } else if (i2 != 2) {
            if (i2 != 3) {
                return;
            }
            this.mParamSettings.VideoRenderMode = rtcParameterSettings.VideoRenderMode;
        } else {
            this.mParamSettings.VideoMaxkbps = rtcParameterSettings.VideoMaxkbps;
            if (this.peerConnectionClient == null || (handler = this.mHandler) == null) {
                return;
            }
            handler.post(new Runnable() { // from class: com.baidu.rtc.internal.BaiduRtcRoomImp.2
                @Override // java.lang.Runnable
                public void run() {
                    if (BaiduRtcRoomImp.this.peerConnectionClient == null || BaiduRtcRoomImp.this.mParamSettings.VideoMaxkbps <= 0) {
                        return;
                    }
                    Log.d(BaiduRtcRoomImp.TAG, "Set video maximum bitrate: " + BaiduRtcRoomImp.this.mParamSettings.VideoMaxkbps);
                    BaiduRtcRoomImp.this.peerConnectionClient.setVideoMaxBitrate(Integer.valueOf(BaiduRtcRoomImp.this.mParamSettings.VideoMaxkbps));
                }
            });
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public boolean setRecording(boolean z) {
        this.mWebSocketChannel.setRecording(z);
        return true;
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void setRedenFactor(float f2) {
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void setRemoteAudioPlayState(boolean z, long j) {
        StreamStats streamStats = this.mRemoteStreamStats.get(BigInteger.valueOf(j));
        if (streamStats == null || streamStats.hasAudio.booleanValue() == z) {
            return;
        }
        streamStats.hasAudio = Boolean.valueOf(z);
        this.mWebSocketChannel.setRemoteStreamPlayState(streamStats.hasVideo, Boolean.valueOf(z), j);
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void setRemoteAudioSamplesCallback(RTCAudioSamples.RTCRemoteSamplesReadyCallback rTCRemoteSamplesReadyCallback) {
        this.mRemoteSamplesCallback = rTCRemoteSamplesReadyCallback;
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void setRemoteDisplay(RTCVideoView rTCVideoView) {
        setRemoteDisplayGroup(new RTCVideoView[]{rTCVideoView});
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void setRemoteDisplay(final RTCVideoView rTCVideoView, final long j) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.rtc.internal.BaiduRtcRoomImp.11
            @Override // java.lang.Runnable
            public void run() {
                boolean z;
                try {
                    int i2 = 0;
                    if (BaiduRtcRoomImp.this.mRemoteRenderList == null) {
                        BaiduRtcRoomImp.this.mRemoteRenderList = new RTCVideoView[]{rTCVideoView};
                        rTCVideoView.init(BaiduRtcRoomImp.this.rootEglBase.getEglBaseContext(), null);
                        rTCVideoView.setEnableHardwareScaler(true);
                    } else {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= BaiduRtcRoomImp.this.mRemoteRenderList.length) {
                                i3 = 0;
                                z = false;
                                break;
                            } else if (BaiduRtcRoomImp.this.mRemoteRenderList[i3] == rTCVideoView) {
                                z = true;
                                break;
                            } else {
                                i3++;
                            }
                        }
                        if (z) {
                            i2 = i3;
                        } else {
                            rTCVideoView.init(BaiduRtcRoomImp.this.rootEglBase.getEglBaseContext(), null);
                            rTCVideoView.setEnableHardwareScaler(true);
                            RTCVideoView[] rTCVideoViewArr = new RTCVideoView[BaiduRtcRoomImp.this.mRemoteRenderList.length + 1];
                            while (i2 < BaiduRtcRoomImp.this.mRemoteRenderList.length) {
                                rTCVideoViewArr[i2] = BaiduRtcRoomImp.this.mRemoteRenderList[i2];
                                i2++;
                            }
                            rTCVideoViewArr[BaiduRtcRoomImp.this.mRemoteRenderList.length] = rTCVideoView;
                            BaiduRtcRoomImp.this.mRemoteRenderList = rTCVideoViewArr;
                            i2 = BaiduRtcRoomImp.this.mRemoteRenderList.length - 1;
                        }
                    }
                    BaiduRtcRoomImp.this.mFeedToViewMap.put(BigInteger.valueOf(j), BigInteger.valueOf(i2));
                    BaiduRtcRoomImp.this.mHasVideoView[i2] = true;
                } catch (Exception unused) {
                    Log.e(BaiduRtcRoomImp.TAG, "setRemoteDisplay error,userId:" + j);
                }
            }
        });
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void setRemoteDisplayGroup(RTCVideoView[] rTCVideoViewArr) {
        this.mRemoteRenderList = rTCVideoViewArr;
        this.mHandler.post(new Runnable() { // from class: com.baidu.rtc.internal.BaiduRtcRoomImp.10
            @Override // java.lang.Runnable
            public void run() {
                for (int i2 = 0; i2 < BaiduRtcRoomImp.this.mRemoteRenderList.length; i2++) {
                    if (BaiduRtcRoomImp.this.mRemoteRenderList[i2] != null) {
                        try {
                            BaiduRtcRoomImp.this.mRemoteRenderList[i2].init(BaiduRtcRoomImp.this.rootEglBase.getEglBaseContext(), null);
                        } catch (Exception unused) {
                        }
                        BaiduRtcRoomImp.this.mRemoteRenderList[i2].setEnableHardwareScaler(true);
                    }
                }
            }
        });
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void setRemoteVideoPlayState(boolean z, long j) {
        StreamStats streamStats = this.mRemoteStreamStats.get(BigInteger.valueOf(j));
        if (streamStats == null || streamStats.hasVideo.booleanValue() == z) {
            return;
        }
        streamStats.hasVideo = Boolean.valueOf(z);
        this.mWebSocketChannel.setRemoteStreamPlayState(Boolean.valueOf(z), streamStats.hasAudio, j);
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void setSoLaterLoadUrl(String str) {
        this.mSoLaterLoadUrl = str;
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void setSoundMod(BaiduRtcRoom.RtcSoundMode rtcSoundMode) {
        boolean z;
        AudioManager audioManager = (AudioManager) this.mContext.get().getSystemService("audio");
        if (rtcSoundMode == BaiduRtcRoom.RtcSoundMode.RTC_SOUND_MODE_SPEAKER) {
            z = true;
        } else if (rtcSoundMode != BaiduRtcRoom.RtcSoundMode.RTC_SOUND_MODE_EAR) {
            return;
        } else {
            z = false;
        }
        audioManager.setSpeakerphoneOn(z);
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void setUserAttribute(String str) {
        WebSocketChannel webSocketChannel = this.mWebSocketChannel;
        if (webSocketChannel == null) {
            return;
        }
        webSocketChannel.setUserAttribute(str);
        try {
            Thread.sleep(10L);
        } catch (InterruptedException unused) {
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void setVideoCapture(RTCVideoCapture rTCVideoCapture) {
        this.videoCapturer = rTCVideoCapture;
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void setWhitenFactor(float f2) {
    }

    public void setupSoLaterLoad(Context context) {
        DownSoHelper k;
        String str;
        Log.d(TAG, "setup so later loading feature, and cpu type: " + this.mCpuType);
        DownSoHelper.k(context).o(this.mCpuType);
        if (this.mSoLaterLoadUrl.isEmpty()) {
            k = DownSoHelper.k(context);
            str = a.f();
        } else {
            Log.d(TAG, "setup so later load url: " + this.mSoLaterLoadUrl);
            k = DownSoHelper.k(context);
            str = this.mSoLaterLoadUrl;
        }
        k.j(str, true, this.mSoCallback);
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void shutUpUserWithId(long j) {
        shutUpUserWithId(j, true);
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void shutUpUserWithId(long j, boolean z) {
        WebSocketChannel webSocketChannel = this.mWebSocketChannel;
        if (webSocketChannel != null) {
            webSocketChannel.shutUpUserWithId(j, z);
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public boolean startLiveServerStreaming(String str, boolean z, boolean z2, String str2, BaiduRtcRoom.RtcLiveTransferMode rtcLiveTransferMode) {
        this.mWebSocketChannel.startPublishLiveStream(str, z, z2, str2, rtcLiveTransferMode);
        return true;
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void startPreview() {
        Log.d(TAG, "start to preview.");
        if (this.peerConnectionClient != null) {
            this.peerConnectionClient.startVideoSource();
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void startPublish() {
        offerPeerConnection(this.mPublisherHandle);
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public boolean stopLiveServerStreaming(BaiduRtcRoom.RtcLiveTransferMode rtcLiveTransferMode) {
        this.mWebSocketChannel.stopPublishLiveStream(rtcLiveTransferMode);
        return true;
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void stopPreview() {
        this.peerConnectionClient.stopVideoSource();
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void stopPublish() {
        WebSocketChannel webSocketChannel = this.mWebSocketChannel;
        if (webSocketChannel == null) {
            return;
        }
        webSocketChannel.unpublishHandle(this.mPublisherHandle);
        if (this.peerConnectionClient != null) {
            this.peerConnectionClient.stopAudioSource();
            this.peerConnectionClient.stopVideoSource();
            this.peerConnectionClient.closePeer(this.mPublisherHandle);
            if (this.mLocalRender != null) {
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.rtc.internal.BaiduRtcRoomImp.8
                    @Override // java.lang.Runnable
                    public void run() {
                        BaiduRtcRoomImp.this.mLocalRender.clearImage();
                    }
                }, 100L);
            }
            VideoCapturer videoCapturer = this.videoCapturer;
            if (videoCapturer != null) {
                videoCapturer.dispose();
                this.videoCapturer = null;
                mCameraUsingMap.remove(toString());
            }
        }
        this.mIsStreamPublish = false;
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void stopSubscribeStreaming(long j) {
        try {
            this.mWebSocketChannel.subscriberOnLeaving(this.mWebSocketChannel.getHandleByFeed(BigInteger.valueOf(j)));
        } catch (Exception unused) {
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void subscribeStreaming(int i2, long j) {
        if (this.mWebSocketChannel == null) {
            return;
        }
        if (i2 >= 0 && i2 < MAX_VIDEOVIEW_CNT && this.mRemoteRenderList != null) {
            this.mFeedToViewMap.put(BigInteger.valueOf(j), BigInteger.valueOf(i2));
            this.mHasVideoView[i2] = true;
        }
        this.mWebSocketChannel.subscriberCreateHandle(BigInteger.valueOf(j), "out");
    }

    @Override // com.baidu.rtc.JanusRTCInterface
    public void subscriberHandleRemoteJsep(final BigInteger bigInteger, JSONObject jSONObject) {
        this.peerConnectionClient.subscriberHandleRemoteJsep(bigInteger, new SessionDescription(SessionDescription.Type.fromCanonicalForm(jSONObject.optString("type")), jSONObject.optString("sdp")));
        this.mHandler.post(new Runnable() { // from class: com.baidu.rtc.internal.BaiduRtcRoomImp.13
            @Override // java.lang.Runnable
            public void run() {
                BaiduRtcRoomImp baiduRtcRoomImp = BaiduRtcRoomImp.this;
                if (!baiduRtcRoomImp.mIsEnablePullQualityMonitor || bigInteger == baiduRtcRoomImp.mPublisherHandle || baiduRtcRoomImp.peerConnectionClient == null) {
                    return;
                }
                if (BaiduRtcRoomImp.this.mHUDStatisticsMap.get(bigInteger) != null) {
                    BaiduRtcRoomImp.this.peerConnectionClient.enableStatsEvents(false, 0, bigInteger, PeerConnectionClient.StatsEventsType.GET_QUALITY_MONITOR_EVENT);
                    BaiduRtcRoomImp.this.peerConnectionClient.enableStatsEvents(false, 0, bigInteger, PeerConnectionClient.StatsEventsType.GET_SLI_EVENT);
                    BaiduRtcRoomImp.this.mHUDStatisticsMap.remove(bigInteger);
                }
                BaiduRtcRoomImp.this.peerConnectionClient.enableStatsEvents(BaiduRtcRoomImp.this.mIsEnablePullQualityMonitor, 2000, bigInteger, PeerConnectionClient.StatsEventsType.GET_QUALITY_MONITOR_EVENT);
                BaiduRtcRoomImp.this.peerConnectionClient.enableStatsEvents(BaiduRtcRoomImp.this.mIsEnablePullQualityMonitor, 5000, bigInteger, PeerConnectionClient.StatsEventsType.GET_SLI_EVENT);
                HUDStatistics hUDStatistics = new HUDStatistics();
                BaiduRtcRoomImp.this.mHUDStatisticsMap.put(bigInteger, hUDStatistics);
                hUDStatistics.setRequestSubscribeTime(System.currentTimeMillis());
            }
        });
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void switchCamera() {
        if (this.peerConnectionClient != null) {
            this.peerConnectionClient.switchCamera();
        }
        boolean z = !this.mUsingFrontCamera;
        this.mUsingFrontCamera = z;
        RTCVideoView rTCVideoView = this.mLocalRender;
        if (rTCVideoView != null) {
            rTCVideoView.setMirror(z);
        }
        reportRoomEventInfo("SWITCH_CAMERA");
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void switchLoundSpeaker() {
        AudioManager audioManager = (AudioManager) this.mContext.get().getSystemService("audio");
        audioManager.setSpeakerphoneOn(!audioManager.isSpeakerphoneOn());
        reportRoomEventInfo("SWITCH_LOUDSPEAKER");
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void upLoadLog() {
    }

    public void updateBweStatistics(StatsReport[] statsReportArr) {
        StatsReport.Value[] valueArr;
        if (this.mBaiduRtcRoomDelegate == null) {
            return;
        }
        for (StatsReport statsReport : statsReportArr) {
            if (statsReport.id.equals("bweforvideo")) {
                for (StatsReport.Value value : statsReport.values) {
                    if (value.name.equals("googAvailableSendBandwidth")) {
                        double parseDouble = Double.parseDouble(value.value);
                        this.mgoogAvailableSendBandwidth = parseDouble;
                        if (parseDouble > 100.0d) {
                            this.mBaiduRtcRoomDelegate.onRoomEventUpdate(200, (long) parseDouble, statsReport.toString());
                        }
                    }
                }
                return;
            }
        }
    }
}
