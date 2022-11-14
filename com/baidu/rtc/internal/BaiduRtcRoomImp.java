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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.pass.biometrics.base.utils.PassBiometricUtil;
import com.baidu.rtc.BaiduRtcRoom;
import com.baidu.rtc.CommonDefine;
import com.baidu.rtc.JanusConnection;
import com.baidu.rtc.JanusHandle;
import com.baidu.rtc.JanusRTCInterface;
import com.baidu.rtc.PeerConnectionClient;
import com.baidu.rtc.RTCAudioSamples;
import com.baidu.rtc.RTCLoadManager;
import com.baidu.rtc.RTCVideoCapture;
import com.baidu.rtc.RTCVideoExternalRender;
import com.baidu.rtc.RTCVideoExternalRenderImp;
import com.baidu.rtc.RTCVideoView;
import com.baidu.rtc.RtcParameterSettings;
import com.baidu.rtc.WebSocketChannel;
import com.baidu.rtc.config.Constraints;
import com.baidu.rtc.logreport.CpuMonitor;
import com.baidu.rtc.logreport.ErrorInfoReport;
import com.baidu.rtc.logreport.HUDStatistics;
import com.baidu.rtc.logreport.RtcLogReport;
import com.baidu.rtc.logreport.SLIReportInterface;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.datacollector.growth.utils.GrowthConstant;
import com.baidu.searchbox.fluency.utils.FpsConstants;
import com.baidu.searchbox.live.interfaces.ILiveNPSPlugin;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.d;
import com.baidu.tieba.g10;
import com.baidu.tieba.jz9;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
import com.google.android.material.internal.ManufacturerUtils;
import com.heytap.mcssdk.mode.CommandMessage;
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
    public static /* synthetic */ Interceptable $ic = null;
    public static final int COMMUNICATION_REPORT_INTERVAL = 2000;
    public static int DEFAULT_CAMERA_ID = -1;
    public static final int DEVICEINFO_REPORT_INTERVAL = 300000;
    public static int MAX_VIDEOVIEW_CNT = 30;
    public static final int SLI_REPORT_INTERVAL = 5000;
    public static final String TAG = "BaiduRtcRoomImp";
    public static ConcurrentHashMap<String, String> mCameraUsingMap = null;
    public static int mConfigAudioContenttype = 1;
    public static boolean mbEnableDebugLog;
    public transient /* synthetic */ FieldHolder $fh;
    public AudioManager audioManager;
    public int bluetoothOpSeq;
    public Boolean disableBuiltInAGC;
    public Boolean disableBuiltInNS;
    public RTCAudioSamples.RTCExternalSamplesReadyCallback externalSamplesReadyCallback;
    public Boolean isBluetoothOn;
    public boolean isEnableHighProfileConfirm;
    public String mAppId;
    public d mAudioFilter;
    public BaiduRtcRoom.BaiduRtcRoomDelegate mBaiduRtcRoomDelegate;
    public int mCameraID;
    public WeakReference<Context> mContext;
    public CpuMonitor mCpuMonitor;
    public String mCpuType;
    public String mDisplayName;
    public boolean mEnableAudioMix;
    public String mErrorInfoMonitorEnv;
    public ConcurrentHashMap<BigInteger, BigInteger> mFeedToViewMap;
    public ConcurrentHashMap<BigInteger, HUDStatistics> mHUDStatisticsMap;
    public Handler mHandler;
    public boolean[] mHasVideoView;
    public HeadsetReceiver mHeadSetReceiver;
    public boolean mIsAsListener;
    public boolean mIsAsPublisher;
    public boolean mIsCompulsive;
    public boolean mIsEnableErrorInfoMonitor;
    public boolean mIsEnableExternalAudioRecord;
    public boolean mIsEnableExternalVideoCapturer;
    public boolean mIsEnablePullQualityMonitor;
    public boolean mIsEnablePushQualityMonitor;
    public boolean mIsEnableSoLaterLoad;
    public boolean mIsLoginSuccess;
    public boolean mIsStreamPublish;
    public boolean mIsUseDefaultErrorInfoMonitor;
    public String mJanusServerURL;
    public volatile long mLastGoneId;
    public volatile long mLastLeavingId;
    public BaiduRtcRoom.RtcLiveTransferMode mLastLssMode;
    public String mLastLssURL;
    public RTCLoadManager.LoadListener mLoadListener;
    public RTCVideoView mLocalRender;
    public long mLoginSuccessTime;
    public RTCAudioSamples.RTCMixedSamplesReadyCallback mMixedSamplesCallback;
    public g10 mOnMixedFrameUpdateListener;
    public RtcParameterSettings mParamSettings;
    public IdentityHashMap<Long, RTCVideoExternalRender> mPendingRemoveRendererMap;
    public BigInteger mPublisherHandle;
    public String mQualityMonitorEnv;
    public int mRemoteFilterTrack;
    public RTCVideoView[] mRemoteRenderList;
    public RTCAudioSamples.RTCRemoteSamplesReadyCallback mRemoteSamplesCallback;
    public JavaAudioDeviceModule.RemoteSamplesReadyCallback mRemoteSamplesInternalCallback;
    public ConcurrentHashMap<BigInteger, StreamStats> mRemoteStreamStats;
    public int mRemoteVideoCnt;
    public String mRoomName;
    public RTCAudioSamples.RTCSamplesReadyCallback mSamplesReadyCallback;
    public JavaAudioDeviceModule.SamplesReadyCallback mSamplesReadyInternalCallback;
    public Context mSoContext;
    public String mSoLaterLoadUrl;
    public long mStartLoginTime;
    public long mUserId;
    public ConcurrentHashMap<Long, RTCVideoExternalRender> mUserIdVideoRendererMap;
    public boolean mUsingFrontCamera;
    public boolean mVideoCaptureIsFrontCamera;
    public VideoSink mVideoSink;
    public WebSocketChannel mWebSocketChannel;
    public boolean mbOnStatistics;
    public boolean mbStartReportDI;
    public double mgoogAvailableSendBandwidth;
    public volatile PeerConnectionClient peerConnectionClient;
    public PeerConnectionClient.PeerConnectionParameters peerConnectionParameters;
    public Runnable reportDeviceInfoRun;
    public EglBase rootEglBase;
    public RtcLogReport rtcLogReport;
    public VideoCapturer videoCapturer;

    public static void setUseTestEnv(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65595, null, z) == null) {
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void cameraFocusWithPoint(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) {
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void enableLaterLoadSo(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
        }
    }

    @Override // com.baidu.rtc.PeerConnectionClient.PeerConnectionEvents
    public void onIceCandidatesRemoved(IceCandidate[] iceCandidateArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, iceCandidateArr) == null) {
        }
    }

    @Override // com.baidu.rtc.PeerConnectionClient.PeerConnectionEvents
    public void onIceConnected() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
        }
    }

    @Override // com.baidu.rtc.PeerConnectionClient.PeerConnectionEvents
    public void onIceDisconnected() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
        }
    }

    @Override // com.baidu.rtc.PeerConnectionClient.PeerConnectionEvents
    public void onPeerClosed(BigInteger bigInteger) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, bigInteger) == null) {
        }
    }

    @Override // com.baidu.rtc.PeerConnectionClient.PeerConnectionEvents
    public void onPeerConnectionClosed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
        }
    }

    @Override // com.baidu.rtc.PeerConnectionClient.PeerConnectionEvents
    public void onSEIRecv(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, byteBuffer) == null) {
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void queryEngineStatisticsInfo() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048651, this) == null) {
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void setBuffingFactor(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048660, this, f) == null) {
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void setRedenFactor(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048673, this, f) == null) {
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void setWhitenFactor(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048684, this, f) == null) {
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void upLoadLog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048698, this) == null) {
        }
    }

    /* renamed from: com.baidu.rtc.internal.BaiduRtcRoomImp$24  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass24 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$rtc$RtcParameterSettings$RtcParamSettingType;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-451680406, "Lcom/baidu/rtc/internal/BaiduRtcRoomImp$24;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-451680406, "Lcom/baidu/rtc/internal/BaiduRtcRoomImp$24;");
                    return;
                }
            }
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
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaiduRtcRoomImp this$0;

        public AudioStuckEvent(BaiduRtcRoomImp baiduRtcRoomImp) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baiduRtcRoomImp};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = baiduRtcRoomImp;
        }

        @Override // com.baidu.rtc.logreport.SLIReportInterface
        public void onStuckData(long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                BaiduRtcRoomImp baiduRtcRoomImp = this.this$0;
                if (baiduRtcRoomImp.mIsEnablePullQualityMonitor) {
                    for (Map.Entry entry : baiduRtcRoomImp.mHUDStatisticsMap.entrySet()) {
                        if (entry.getKey() != this.this$0.mPublisherHandle && entry.getValue() != null) {
                            ((HUDStatistics) entry.getValue()).addAudioStuckData(j, j2);
                            if (this.this$0.mIsEnableErrorInfoMonitor) {
                                long j3 = j2 - j;
                                if (j3 > 200) {
                                    BigInteger valueOf = BigInteger.valueOf(0L);
                                    if (this.this$0.mWebSocketChannel != null) {
                                        valueOf = this.this$0.mWebSocketChannel.getFeedByHandle((BigInteger) entry.getKey());
                                    }
                                    ErrorInfoReport.getInstance().reportErrorInfo(ErrorInfoReport.ErrorCode.AUDIO_STUCK, j3, (BigInteger) entry.getKey(), valueOf);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class HeadsetReceiver extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaiduRtcRoomImp this$0;

        public HeadsetReceiver(BaiduRtcRoomImp baiduRtcRoomImp) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baiduRtcRoomImp};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = baiduRtcRoomImp;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
                if (this.this$0.audioManager == null) {
                    BaiduRtcRoomImp baiduRtcRoomImp = this.this$0;
                    baiduRtcRoomImp.audioManager = (AudioManager) ((Context) baiduRtcRoomImp.mContext.get()).getSystemService("audio");
                }
                String action = intent.getAction();
                if ("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED".equals(action)) {
                    int intExtra = intent.getIntExtra("android.bluetooth.profile.extra.STATE", -1);
                    if (intExtra == 0) {
                        Log.i(BaiduRtcRoomImp.TAG, "Bluetooth headset not disconnected");
                        this.this$0.setBluetoothScoOn(Boolean.FALSE);
                        BaiduRtcRoomImp.access$3208(this.this$0);
                        if (!this.this$0.audioManager.isWiredHeadsetOn()) {
                            this.this$0.setSoundMod(BaiduRtcRoom.RtcSoundMode.RTC_SOUND_MODE_SPEAKER);
                        }
                    } else if (intExtra == 2) {
                        this.this$0.mHandler.postDelayed(new Runnable(this, BaiduRtcRoomImp.access$3204(this.this$0)) { // from class: com.baidu.rtc.internal.BaiduRtcRoomImp.HeadsetReceiver.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ HeadsetReceiver this$1;
                            public final /* synthetic */ int val$tmpBluetoothOpSeq;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, Integer.valueOf(r7)};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$1 = this;
                                this.val$tmpBluetoothOpSeq = r7;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable2 = $ic;
                                if ((interceptable2 != null && interceptable2.invokeV(1048576, this) != null) || this.val$tmpBluetoothOpSeq != this.this$1.this$0.bluetoothOpSeq) {
                                    return;
                                }
                                this.this$1.this$0.setBluetoothScoOn(Boolean.TRUE);
                                this.this$1.this$0.setSoundMod(BaiduRtcRoom.RtcSoundMode.RTC_SOUND_MODE_EAR);
                            }
                        }, 1500L);
                        Log.i(BaiduRtcRoomImp.TAG, "Bluetooth headset connected");
                    }
                } else if (intent.getAction().equals("android.intent.action.HEADSET_PLUG") && intent.hasExtra("state")) {
                    if (intent.getIntExtra("state", -1) == 0 && !this.this$0.isHeadsetOn(context)) {
                        Log.i(BaiduRtcRoomImp.TAG, "headset not connected");
                        this.this$0.setSoundMod(BaiduRtcRoom.RtcSoundMode.RTC_SOUND_MODE_SPEAKER);
                    } else if (intent.getIntExtra("state", -1) == 1) {
                        Log.i(BaiduRtcRoomImp.TAG, "headset connected");
                        this.this$0.setSoundMod(BaiduRtcRoom.RtcSoundMode.RTC_SOUND_MODE_EAR);
                    }
                } else if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(action) && intent.getIntExtra("android.bluetooth.adapter.extra.STATE", Integer.MIN_VALUE) == 10) {
                    BaiduRtcRoomImp.access$3208(this.this$0);
                    this.this$0.setBluetoothScoOn(Boolean.FALSE);
                    if (!this.this$0.audioManager.isWiredHeadsetOn()) {
                        this.this$0.setSoundMod(BaiduRtcRoom.RtcSoundMode.RTC_SOUND_MODE_SPEAKER);
                    }
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class StreamStats {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public BigInteger handleId;
        public Boolean hasAudio;
        public Boolean hasVideo;
        public String nickName;
        public long userId;
        public int volume;

        public StreamStats(BigInteger bigInteger, long j, Boolean bool, Boolean bool2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bigInteger, Long.valueOf(j), bool, bool2, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.volume = -1;
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
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public BigInteger handleId;
        public final /* synthetic */ BaiduRtcRoomImp this$0;

        public VideoStuckEvent(BaiduRtcRoomImp baiduRtcRoomImp, BigInteger bigInteger) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baiduRtcRoomImp, bigInteger};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = baiduRtcRoomImp;
            this.handleId = bigInteger;
        }

        @Override // com.baidu.rtc.logreport.SLIReportInterface
        public void onStuckData(long j, long j2) {
            HUDStatistics hUDStatistics;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                BaiduRtcRoomImp baiduRtcRoomImp = this.this$0;
                if (baiduRtcRoomImp.mIsEnablePullQualityMonitor && (hUDStatistics = (HUDStatistics) baiduRtcRoomImp.mHUDStatisticsMap.get(this.handleId)) != null) {
                    hUDStatistics.addVideoStuckData(j, j2);
                    if (this.this$0.mIsEnableErrorInfoMonitor) {
                        long j3 = j2 - j;
                        if (j3 > 600) {
                            BigInteger valueOf = BigInteger.valueOf(0L);
                            if (this.this$0.mWebSocketChannel != null) {
                                valueOf = this.this$0.mWebSocketChannel.getFeedByHandle(this.handleId);
                            }
                            ErrorInfoReport.getInstance().reportErrorInfo(ErrorInfoReport.ErrorCode.VIDEO_STUCK, j3, this.handleId, valueOf);
                        }
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-966963066, "Lcom/baidu/rtc/internal/BaiduRtcRoomImp;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-966963066, "Lcom/baidu/rtc/internal/BaiduRtcRoomImp;");
                return;
            }
        }
        mCameraUsingMap = new ConcurrentHashMap<>();
    }

    private boolean captureToTexture() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65576, this)) == null) {
            if (Build.MODEL.contains("SABRESD-MX6DQ")) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    private boolean useCamera2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65597, this)) == null) {
            Camera2Enumerator.disableExtraCamera(this.mParamSettings.DisableExtraCamera);
            if (Build.MODEL.contains("LIO-AL00")) {
                return false;
            }
            return Camera2Enumerator.isSupported(this.mContext.get());
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void disbandRoom() {
        WebSocketChannel webSocketChannel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (webSocketChannel = this.mWebSocketChannel) != null) {
            webSocketChannel.disbandRoom();
        }
    }

    public void doDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            RTCLoadManager.getInstance(this.mSoContext).release();
            logoutRtcRoom();
            mCameraUsingMap.remove(toString());
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public RTCAudioSamples.RTCExternalSamplesReadyCallback getExternalAudioSamplesCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.externalSamplesReadyCallback;
        }
        return (RTCAudioSamples.RTCExternalSamplesReadyCallback) invokeV.objValue;
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public BaiduRtcRoom.RtcRoomUserInfo[] getUserListOfRoom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            WebSocketChannel webSocketChannel = this.mWebSocketChannel;
            if (webSocketChannel == null) {
                return null;
            }
            return webSocketChannel.UserInfoList();
        }
        return (BaiduRtcRoom.RtcRoomUserInfo[]) invokeV.objValue;
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public boolean isExternalAudioRecord() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.mIsEnableExternalAudioRecord;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public boolean isSpeakerOn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return ((AudioManager) this.mContext.get().getSystemService("audio")).isSpeakerphoneOn();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.rtc.JanusRTCInterface
    public void onRoomDisbanded() {
        BaiduRtcRoom.BaiduRtcRoomDelegate baiduRtcRoomDelegate;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048638, this) != null) || (baiduRtcRoomDelegate = this.mBaiduRtcRoomDelegate) == null) {
            return;
        }
        baiduRtcRoomDelegate.onRoomEventUpdate(112, 0L, "");
    }

    @Override // com.baidu.rtc.JanusRTCInterface
    public void onServerAckTimeout() {
        BaiduRtcRoom.BaiduRtcRoomDelegate baiduRtcRoomDelegate;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048640, this) != null) || (baiduRtcRoomDelegate = this.mBaiduRtcRoomDelegate) == null) {
            return;
        }
        baiduRtcRoomDelegate.onErrorInfoUpdate(402);
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void publishStreaming() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048650, this) == null) {
            offerPeerConnection(this.mPublisherHandle);
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public BaiduRtcRoom.UserList queryUserListOfRoom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) {
            WebSocketChannel webSocketChannel = this.mWebSocketChannel;
            if (webSocketChannel == null) {
                return null;
            }
            return webSocketChannel.UserListOfRoom();
        }
        return (BaiduRtcRoom.UserList) invokeV.objValue;
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void startPreview() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048688, this) == null) {
            Log.d(TAG, "start to preview.");
            if (this.peerConnectionClient != null) {
                this.peerConnectionClient.startVideoSource();
            }
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void startPublish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048689, this) == null) {
            offerPeerConnection(this.mPublisherHandle);
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void stopPreview() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048691, this) == null) {
            this.peerConnectionClient.stopVideoSource();
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void switchCamera() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048696, this) == null) {
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
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void switchLoundSpeaker() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048697, this) == null) {
            AudioManager audioManager = (AudioManager) this.mContext.get().getSystemService("audio");
            audioManager.setSpeakerphoneOn(!audioManager.isSpeakerphoneOn());
            reportRoomEventInfo("SWITCH_LOUDSPEAKER");
        }
    }

    public BaiduRtcRoomImp(Context context, String str, String str2, String str3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2, str3, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mContext = null;
        this.mWebSocketChannel = null;
        this.mIsEnableExternalVideoCapturer = false;
        this.mIsEnableExternalAudioRecord = false;
        this.mEnableAudioMix = false;
        this.peerConnectionClient = null;
        this.peerConnectionParameters = null;
        this.mLocalRender = null;
        this.mRemoteRenderList = null;
        this.videoCapturer = null;
        this.rootEglBase = null;
        this.mJanusServerURL = "wss://rtc.exp.bcelive.com/janus";
        this.mRemoteVideoCnt = 0;
        this.mUsingFrontCamera = true;
        this.mHasVideoView = new boolean[MAX_VIDEOVIEW_CNT];
        this.audioManager = null;
        this.mRemoteFilterTrack = -1;
        this.mBaiduRtcRoomDelegate = null;
        this.mSamplesReadyCallback = null;
        this.mRemoteSamplesCallback = null;
        this.mMixedSamplesCallback = null;
        this.mUserIdVideoRendererMap = new ConcurrentHashMap<>();
        this.mPendingRemoveRendererMap = new IdentityHashMap<>();
        this.mVideoCaptureIsFrontCamera = false;
        this.mCameraID = DEFAULT_CAMERA_ID;
        this.mParamSettings = new RtcParameterSettings();
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mPublisherHandle = null;
        this.mLastLeavingId = 0L;
        this.mLastGoneId = 0L;
        this.mFeedToViewMap = new ConcurrentHashMap<>();
        this.mbOnStatistics = true;
        this.mgoogAvailableSendBandwidth = 200.0d;
        this.mIsEnablePushQualityMonitor = false;
        this.mIsEnablePullQualityMonitor = false;
        this.mIsEnableErrorInfoMonitor = true;
        this.mIsUseDefaultErrorInfoMonitor = true;
        this.mErrorInfoMonitorEnv = "online";
        this.mQualityMonitorEnv = "online";
        this.mHUDStatisticsMap = new ConcurrentHashMap<>();
        this.mbStartReportDI = false;
        this.mIsAsListener = true;
        this.mIsAsPublisher = true;
        this.mIsCompulsive = false;
        this.mIsStreamPublish = false;
        Boolean bool = Boolean.FALSE;
        this.disableBuiltInAGC = bool;
        this.disableBuiltInNS = bool;
        this.mLastLssURL = "";
        this.mHeadSetReceiver = null;
        this.isEnableHighProfileConfirm = false;
        this.mIsLoginSuccess = false;
        this.mRemoteStreamStats = new ConcurrentHashMap<>();
        this.mIsEnableSoLaterLoad = false;
        this.mSoLaterLoadUrl = "";
        this.mCpuType = PassBiometricUtil.CPU_TYPE_ARMEABI_V7A;
        this.mSoContext = null;
        this.mLoadListener = new RTCLoadManager.LoadListener(this) { // from class: com.baidu.rtc.internal.BaiduRtcRoomImp.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ BaiduRtcRoomImp this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.baidu.rtc.RTCLoadManager.LoadListener
            public void onLoadProgress(float f) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f) == null) {
                    Log.d(BaiduRtcRoomImp.TAG, "loaded so progress " + f);
                }
            }

            @Override // com.baidu.rtc.RTCLoadManager.LoadListener
            public void onLoadError(int i3, String str4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i3, str4) == null) {
                    Log.d(BaiduRtcRoomImp.TAG, "Failed to download so.");
                    if (this.this$0.mIsEnableErrorInfoMonitor) {
                        ErrorInfoReport.getInstance().reportErrorInfo(ErrorInfoReport.ErrorCode.SO_LATER_DOWNLOADING_FAIL);
                    }
                    BaiduRtcRoom.BaiduRtcRoomDelegate baiduRtcRoomDelegate = this.this$0.mBaiduRtcRoomDelegate;
                    if (baiduRtcRoomDelegate != null) {
                        baiduRtcRoomDelegate.onErrorInfoUpdate(400);
                    }
                }
            }

            @Override // com.baidu.rtc.RTCLoadManager.LoadListener
            public void onLoadSuccess() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    Log.d(BaiduRtcRoomImp.TAG, "after loaded so, start to login room.");
                    BaiduRtcRoomImp baiduRtcRoomImp = this.this$0;
                    baiduRtcRoomImp.loginRtcRoomWithRoomName(baiduRtcRoomImp.mRoomName, baiduRtcRoomImp.mUserId, baiduRtcRoomImp.mDisplayName, baiduRtcRoomImp.mIsAsPublisher, baiduRtcRoomImp.mIsAsListener);
                }
            }
        };
        this.mSamplesReadyInternalCallback = new JavaAudioDeviceModule.SamplesReadyCallback(this) { // from class: com.baidu.rtc.internal.BaiduRtcRoomImp.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ BaiduRtcRoomImp this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // org.webrtc.audio.JavaAudioDeviceModule.SamplesReadyCallback
            public void onWebRtcAudioRecordSamplesReady(JavaAudioDeviceModule.AudioSamples audioSamples) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, audioSamples) == null) && audioSamples != null && audioSamples.getData() != null && audioSamples.getData().length > 0) {
                    RTCAudioSamples.RTCSamplesReadyCallback rTCSamplesReadyCallback = this.this$0.mSamplesReadyCallback;
                    if (rTCSamplesReadyCallback != null) {
                        rTCSamplesReadyCallback.onRtcAudioRecordSamplesReady(new RTCAudioSamples(audioSamples.getAudioFormat(), audioSamples.getChannelCount(), audioSamples.getSampleRate(), audioSamples.getData()));
                    }
                    if (this.this$0.mEnableAudioMix && !this.this$0.mIsEnableExternalAudioRecord) {
                        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
                        bufferInfo.size = audioSamples.getData().length;
                        bufferInfo.offset = 0;
                        ByteBuffer wrap = ByteBuffer.wrap(audioSamples.getData());
                        bufferInfo.presentationTimeUs = System.nanoTime();
                        this.this$0.mAudioFilter.e(wrap, bufferInfo);
                    }
                }
            }
        };
        this.mRemoteSamplesInternalCallback = new JavaAudioDeviceModule.RemoteSamplesReadyCallback(this) { // from class: com.baidu.rtc.internal.BaiduRtcRoomImp.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ BaiduRtcRoomImp this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // org.webrtc.audio.JavaAudioDeviceModule.RemoteSamplesReadyCallback
            public void onWebRtcAudioRemoteSamplesReady(JavaAudioDeviceModule.AudioSamples audioSamples) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 != null && interceptable2.invokeL(1048576, this, audioSamples) != null) || audioSamples == null) {
                    return;
                }
                RTCAudioSamples.RTCRemoteSamplesReadyCallback rTCRemoteSamplesReadyCallback = this.this$0.mRemoteSamplesCallback;
                if (rTCRemoteSamplesReadyCallback != null) {
                    rTCRemoteSamplesReadyCallback.onRtcAudioRemoteSamplesReady(new RTCAudioSamples(audioSamples.getAudioFormat(), audioSamples.getChannelCount(), audioSamples.getSampleRate(), audioSamples.getData()));
                }
                if (this.this$0.mEnableAudioMix && this.this$0.mRemoteFilterTrack >= 0) {
                    MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
                    bufferInfo.size = audioSamples.getData().length;
                    bufferInfo.offset = 0;
                    this.this$0.mAudioFilter.f(ByteBuffer.wrap(audioSamples.getData()), bufferInfo, this.this$0.mRemoteFilterTrack);
                }
            }
        };
        this.externalSamplesReadyCallback = new RTCAudioSamples.RTCExternalSamplesReadyCallback(this) { // from class: com.baidu.rtc.internal.BaiduRtcRoomImp.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ BaiduRtcRoomImp this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.baidu.rtc.RTCAudioSamples.RTCExternalSamplesReadyCallback
            public void onRtcAudioExternalSamplesReady(RTCAudioSamples rTCAudioSamples) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, rTCAudioSamples) == null) && this.this$0.peerConnectionClient != null) {
                    JavaAudioDeviceModule.ExternalSamplesReadyCallback externalSamplesCallback = this.this$0.peerConnectionClient.getExternalSamplesCallback();
                    if (externalSamplesCallback != null) {
                        externalSamplesCallback.onWebRtcAudioExternalSamplesReady(rTCAudioSamples);
                    }
                    if (this.this$0.mEnableAudioMix && this.this$0.mIsEnableExternalAudioRecord) {
                        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
                        bufferInfo.size = rTCAudioSamples.getData().length;
                        bufferInfo.offset = 0;
                        this.this$0.mAudioFilter.e(ByteBuffer.wrap(rTCAudioSamples.getData()), bufferInfo);
                    }
                }
            }
        };
        this.mOnMixedFrameUpdateListener = new g10(this) { // from class: com.baidu.rtc.internal.BaiduRtcRoomImp.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ BaiduRtcRoomImp this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.baidu.tieba.g10
            public void onFilteredFrameUpdate(byte[] bArr, MediaCodec.BufferInfo bufferInfo) {
                BaiduRtcRoomImp baiduRtcRoomImp;
                RTCAudioSamples.RTCMixedSamplesReadyCallback rTCMixedSamplesReadyCallback;
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeLL(1048576, this, bArr, bufferInfo) == null) && (rTCMixedSamplesReadyCallback = (baiduRtcRoomImp = this.this$0).mMixedSamplesCallback) != null) {
                    rTCMixedSamplesReadyCallback.onRtcAudioMixedSamplesReady(new RTCAudioSamples(2, baiduRtcRoomImp.mParamSettings.AudioChannel, this.this$0.mParamSettings.AudioFrequency, bArr, bufferInfo.presentationTimeUs));
                }
            }
        };
        this.reportDeviceInfoRun = new Runnable(this) { // from class: com.baidu.rtc.internal.BaiduRtcRoomImp.23
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ BaiduRtcRoomImp this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    BaiduRtcRoomImp baiduRtcRoomImp = this.this$0;
                    if (baiduRtcRoomImp.rtcLogReport != null && (baiduRtcRoomImp.mIsEnablePushQualityMonitor || baiduRtcRoomImp.mIsEnablePullQualityMonitor)) {
                        this.this$0.reportDeviceInfo();
                    }
                    this.this$0.mHandler.postDelayed(this.this$0.reportDeviceInfoRun, 300000L);
                }
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
        this.mWebSocketChannel.setSDK(Constraints.sdkVersion());
        this.mAppId = str;
        this.mWebSocketChannel.setDelegate(this);
        this.rootEglBase = jz9.a();
        int i3 = 0;
        while (true) {
            boolean[] zArr = this.mHasVideoView;
            if (i3 >= zArr.length) {
                break;
            }
            zArr[i3] = false;
            i3++;
        }
        AudioManager audioManager = (AudioManager) this.mContext.get().getSystemService("audio");
        audioManager.setSpeakerphoneOn(false);
        if (this.mIsEnablePushQualityMonitor || this.mIsEnablePullQualityMonitor || this.mIsEnableErrorInfoMonitor) {
            this.mCpuMonitor = new CpuMonitor(context);
            this.rtcLogReport = RtcLogReport.getInstance();
        }
        ErrorInfoReport.getInstance().setEnv(this.mErrorInfoMonitorEnv);
        ErrorInfoReport.getInstance().setVersion(Constraints.sdkVersion());
        ErrorInfoReport.getInstance().setAppId(this.mAppId);
        this.bluetoothOpSeq = 0;
        this.isBluetoothOn = Boolean.FALSE;
        audioManager = audioManager == null ? (AudioManager) this.mContext.get().getSystemService("audio") : audioManager;
        this.mHeadSetReceiver = new HeadsetReceiver(this);
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
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.mContext.get().registerReceiver(this.mHeadSetReceiver, intentFilter);
        if (!isHeadsetOn(this.mContext.get())) {
            presetLoudSpeaker(true);
            Log.i(TAG, "Headset No");
        }
    }

    public static /* synthetic */ int access$3204(BaiduRtcRoomImp baiduRtcRoomImp) {
        int i = baiduRtcRoomImp.bluetoothOpSeq + 1;
        baiduRtcRoomImp.bluetoothOpSeq = i;
        return i;
    }

    public static /* synthetic */ int access$3208(BaiduRtcRoomImp baiduRtcRoomImp) {
        int i = baiduRtcRoomImp.bluetoothOpSeq;
        baiduRtcRoomImp.bluetoothOpSeq = i + 1;
        return i;
    }

    private void offerPeerConnection(BigInteger bigInteger) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65583, this, bigInteger) != null) || this.mIsStreamPublish) {
            return;
        }
        this.mIsStreamPublish = true;
        this.mHandler.post(new Runnable(this, bigInteger) { // from class: com.baidu.rtc.internal.BaiduRtcRoomImp.21
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ BaiduRtcRoomImp this$0;
            public final /* synthetic */ BigInteger val$handleId;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, bigInteger};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
                this.val$handleId = bigInteger;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    if (this.this$0.mParamSettings.HasVideo) {
                        BaiduRtcRoomImp baiduRtcRoomImp = this.this$0;
                        baiduRtcRoomImp.videoCapturer = baiduRtcRoomImp.createVideoCapturer();
                    }
                    if (this.this$0.peerConnectionClient == null) {
                        Log.e(BaiduRtcRoomImp.TAG, "peerConnectionClient is null!");
                        return;
                    }
                    if (this.this$0.mIsEnableExternalVideoCapturer) {
                        this.this$0.peerConnectionClient.createPeerConnection(this.this$0.rootEglBase.getEglBaseContext(), this.this$0.mVideoSink, this.this$0.videoCapturer, this.val$handleId);
                    } else {
                        this.this$0.peerConnectionClient.createPeerConnection(this.this$0.rootEglBase.getEglBaseContext(), this.this$0.mLocalRender, this.this$0.videoCapturer, this.val$handleId);
                    }
                    this.this$0.mStartLoginTime = System.currentTimeMillis();
                    this.this$0.peerConnectionClient.createOffer(this.val$handleId);
                }
            }
        });
    }

    private void reportSLILoginEvent(String str) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65591, this, str) == null) {
            WebSocketChannel webSocketChannel = this.mWebSocketChannel;
            if (webSocketChannel != null) {
                j = webSocketChannel.getRoomId();
            } else {
                j = -1;
            }
            reportSLILoginEvent(str, j);
        }
    }

    public static void setVerbose(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65596, null, z) == null) {
            mbEnableDebugLog = z;
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void enableAgc(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.disableBuiltInAGC = Boolean.valueOf(z);
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void enableAns(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.disableBuiltInNS = Boolean.valueOf(z);
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void enableAudioMix(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.mEnableAudioMix = z;
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void enableExternalAudioRecord(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.mIsEnableExternalAudioRecord = z;
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void enableExternalVideoCapturer(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.mIsEnableExternalVideoCapturer = z;
            this.mVideoSink = new VideoSink(this) { // from class: com.baidu.rtc.internal.BaiduRtcRoomImp.22
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BaiduRtcRoomImp this$0;

                @Override // org.webrtc.VideoSink
                public void onFrame(VideoFrame videoFrame) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, videoFrame) == null) {
                    }
                }

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }
            };
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void getUserAttribute(long j) {
        WebSocketChannel webSocketChannel;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeJ(1048596, this, j) != null) || (webSocketChannel = this.mWebSocketChannel) == null) {
            return;
        }
        webSocketChannel.getUserAttribute(j);
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void kickOffUserWithId(long j) {
        WebSocketChannel webSocketChannel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(1048600, this, j) == null) && (webSocketChannel = this.mWebSocketChannel) != null) {
            webSocketChannel.kickOffUserWithId(j);
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void muteCamera(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            if (this.peerConnectionClient != null) {
                this.peerConnectionClient.setVideoEnabled(!z);
            }
            reportRoomEventInfo("MUTE_CAMERA");
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void muteMicphone(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z) == null) {
            if (this.peerConnectionClient != null) {
                this.peerConnectionClient.setAudioEnabled(!z);
            }
            reportRoomEventInfo("MUTE_MICPHONE");
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void muteSpeaker(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048607, this, z) == null) && this.peerConnectionClient != null) {
            this.peerConnectionClient.setSpeakerMute(z);
        }
    }

    @Override // com.baidu.rtc.JanusRTCInterface
    public void onHangUp(BigInteger bigInteger) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, bigInteger) == null) {
            if (this.mIsEnableErrorInfoMonitor) {
                ErrorInfoReport.getInstance().reportErrorInfo(ErrorInfoReport.ErrorCode.HANG_UP);
            }
            BaiduRtcRoom.BaiduRtcRoomDelegate baiduRtcRoomDelegate = this.mBaiduRtcRoomDelegate;
            if (baiduRtcRoomDelegate == null) {
                return;
            }
            baiduRtcRoomDelegate.onPeerConnectStateUpdate(2003);
        }
    }

    @Override // com.baidu.rtc.PeerConnectionClient.PeerConnectionEvents
    public void onRemoteData(ByteBuffer byteBuffer) {
        BaiduRtcRoom.BaiduRtcRoomDelegate baiduRtcRoomDelegate;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048633, this, byteBuffer) != null) || (baiduRtcRoomDelegate = this.mBaiduRtcRoomDelegate) == null) {
            return;
        }
        baiduRtcRoomDelegate.onRoomDataMessage(byteBuffer);
    }

    @Override // com.baidu.rtc.JanusRTCInterface
    public void onRemoteGone(BigInteger bigInteger) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048635, this, bigInteger) == null) && this.peerConnectionClient != null) {
            this.peerConnectionClient.closePeer(bigInteger);
        }
    }

    @Override // com.baidu.rtc.JanusRTCInterface
    public void onSignalErrorInfo(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048641, this, i) == null) && this.mBaiduRtcRoomDelegate != null && i == 436) {
            if (this.mIsEnableErrorInfoMonitor) {
                ErrorInfoReport.getInstance().reportErrorInfo(ErrorInfoReport.ErrorCode.USR_ALREADY_EXIST);
            }
            this.mBaiduRtcRoomDelegate.onErrorInfoUpdate(436);
        }
    }

    @Override // com.baidu.rtc.JanusRTCInterface
    public void onUserDisShutUp(long j) {
        BaiduRtcRoom.BaiduRtcRoomDelegate baiduRtcRoomDelegate;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeJ(1048643, this, j) != null) || (baiduRtcRoomDelegate = this.mBaiduRtcRoomDelegate) == null) {
            return;
        }
        baiduRtcRoomDelegate.onRoomEventUpdate(114, j, "");
    }

    @Override // com.baidu.rtc.JanusRTCInterface
    public void onUserKickOff(long j) {
        BaiduRtcRoom.BaiduRtcRoomDelegate baiduRtcRoomDelegate;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeJ(1048645, this, j) != null) || (baiduRtcRoomDelegate = this.mBaiduRtcRoomDelegate) == null) {
            return;
        }
        baiduRtcRoomDelegate.onRoomEventUpdate(115, j, "");
    }

    @Override // com.baidu.rtc.JanusRTCInterface
    public void onUserLeavingRoom(BigInteger bigInteger) {
        BaiduRtcRoom.BaiduRtcRoomDelegate baiduRtcRoomDelegate;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048646, this, bigInteger) != null) || (baiduRtcRoomDelegate = this.mBaiduRtcRoomDelegate) == null) {
            return;
        }
        baiduRtcRoomDelegate.onRoomEventUpdate(301, bigInteger.longValue(), "");
    }

    @Override // com.baidu.rtc.JanusRTCInterface
    public void onUserShutUp(long j) {
        BaiduRtcRoom.BaiduRtcRoomDelegate baiduRtcRoomDelegate;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeJ(1048647, this, j) != null) || (baiduRtcRoomDelegate = this.mBaiduRtcRoomDelegate) == null) {
            return;
        }
        baiduRtcRoomDelegate.onRoomEventUpdate(113, j, "");
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void presetLoudSpeaker(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048649, this, z) == null) {
            ((AudioManager) this.mContext.get().getSystemService("audio")).setSpeakerphoneOn(z);
            reportRoomEventInfo("PRESETLOUDSPEAKER");
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void sendData(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048654, this, byteBuffer) != null) || this.peerConnectionClient == null) {
            return;
        }
        this.peerConnectionClient.sendData(byteBuffer);
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void setAudioRecordDelegate(RTCAudioSamples.RTCSamplesReadyCallback rTCSamplesReadyCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048656, this, rTCSamplesReadyCallback) == null) {
            this.mSamplesReadyCallback = rTCSamplesReadyCallback;
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void setAuidoSamplesReadyCallback(RTCAudioSamples.RTCSamplesReadyCallback rTCSamplesReadyCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048657, this, rTCSamplesReadyCallback) == null) {
            this.mSamplesReadyCallback = rTCSamplesReadyCallback;
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public boolean setBaiduRtcRoomDelegate(BaiduRtcRoom.BaiduRtcRoomDelegate baiduRtcRoomDelegate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048659, this, baiduRtcRoomDelegate)) == null) {
            this.mBaiduRtcRoomDelegate = baiduRtcRoomDelegate;
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void setCameraID(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048661, this, i) == null) {
            this.mCameraID = i;
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void setEngineStateStatistics(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048662, this, z) == null) {
            this.mbOnStatistics = z;
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public boolean setLiveStreamingMix(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048664, this, z)) == null) {
            this.mWebSocketChannel.setMixing(z);
            return true;
        }
        return invokeZ.booleanValue;
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public boolean setLiveStreamingRole(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048665, this, str)) == null) {
            this.mWebSocketChannel.setLssRole(str);
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public boolean setLiveStreamingURL(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048666, this, str)) == null) {
            this.mWebSocketChannel.setLssURL(str);
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void setLocalDisplay(RTCVideoView rTCVideoView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048667, this, rTCVideoView) == null) {
            this.mLocalRender = rTCVideoView;
            this.mHandler.post(new Runnable(this) { // from class: com.baidu.rtc.internal.BaiduRtcRoomImp.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BaiduRtcRoomImp this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.this$0.mLocalRender != null) {
                        try {
                            this.this$0.mLocalRender.init(this.this$0.rootEglBase.getEglBaseContext(), null);
                        } catch (Exception unused) {
                        }
                        this.this$0.mLocalRender.setEnableHardwareScaler(true);
                        if (this.this$0.mVideoCaptureIsFrontCamera) {
                            this.this$0.mLocalRender.setMirror(true);
                        }
                    }
                }
            });
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void setMediaServerURL(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048668, this, str) == null) {
            this.mJanusServerURL = str;
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public boolean setMixLayoutPositionIndex(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048669, this, str)) == null) {
            this.mWebSocketChannel.setMixLayoutPosition(str);
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void setMixedAudioSamplesCallback(RTCAudioSamples.RTCMixedSamplesReadyCallback rTCMixedSamplesReadyCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048670, this, rTCMixedSamplesReadyCallback) == null) {
            this.mMixedSamplesCallback = rTCMixedSamplesReadyCallback;
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public boolean setRecording(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048672, this, z)) == null) {
            this.mWebSocketChannel.setRecording(z);
            return true;
        }
        return invokeZ.booleanValue;
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void setRemoteAudioSamplesCallback(RTCAudioSamples.RTCRemoteSamplesReadyCallback rTCRemoteSamplesReadyCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048675, this, rTCRemoteSamplesReadyCallback) == null) {
            this.mRemoteSamplesCallback = rTCRemoteSamplesReadyCallback;
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void setRemoteDisplay(RTCVideoView rTCVideoView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048676, this, rTCVideoView) == null) {
            setRemoteDisplayGroup(new RTCVideoView[]{rTCVideoView});
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void setRemoteDisplayGroup(RTCVideoView[] rTCVideoViewArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048678, this, rTCVideoViewArr) == null) {
            this.mRemoteRenderList = rTCVideoViewArr;
            this.mHandler.post(new Runnable(this) { // from class: com.baidu.rtc.internal.BaiduRtcRoomImp.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BaiduRtcRoomImp this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        for (int i = 0; i < this.this$0.mRemoteRenderList.length; i++) {
                            if (this.this$0.mRemoteRenderList[i] != null) {
                                try {
                                    this.this$0.mRemoteRenderList[i].init(this.this$0.rootEglBase.getEglBaseContext(), null);
                                } catch (Exception unused) {
                                }
                                this.this$0.mRemoteRenderList[i].setEnableHardwareScaler(true);
                            }
                        }
                    }
                }
            });
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void setSoLaterLoadUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048680, this, str) == null) {
            this.mSoLaterLoadUrl = str;
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void setSoundMod(BaiduRtcRoom.RtcSoundMode rtcSoundMode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048681, this, rtcSoundMode) == null) {
            AudioManager audioManager = (AudioManager) this.mContext.get().getSystemService("audio");
            if (rtcSoundMode == BaiduRtcRoom.RtcSoundMode.RTC_SOUND_MODE_SPEAKER) {
                audioManager.setSpeakerphoneOn(true);
            } else if (rtcSoundMode == BaiduRtcRoom.RtcSoundMode.RTC_SOUND_MODE_EAR) {
                audioManager.setSpeakerphoneOn(false);
            }
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void setUserAttribute(String str) {
        WebSocketChannel webSocketChannel;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048682, this, str) != null) || (webSocketChannel = this.mWebSocketChannel) == null) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048683, this, rTCVideoCapture) == null) {
            this.videoCapturer = rTCVideoCapture;
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void shutUpUserWithId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048685, this, j) == null) {
            shutUpUserWithId(j, true);
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public boolean stopLiveServerStreaming(BaiduRtcRoom.RtcLiveTransferMode rtcLiveTransferMode) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048690, this, rtcLiveTransferMode)) == null) {
            this.mWebSocketChannel.stopPublishLiveStream(rtcLiveTransferMode);
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void stopSubscribeStreaming(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048693, this, j) == null) {
            try {
                this.mWebSocketChannel.subscriberOnLeaving(this.mWebSocketChannel.getHandleByFeed(BigInteger.valueOf(j)));
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void addExternalRenderer(long j, RTCVideoExternalRender rTCVideoExternalRender) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048576, this, j, rTCVideoExternalRender) == null) {
            removeExternalRenderer(j);
            this.mUserIdVideoRendererMap.put(Long.valueOf(j), rTCVideoExternalRender);
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void enableErrorInfoToServer(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048586, this, z, str) == null) {
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
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void enableStatsToServer(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048590, this, z, str) == null) {
            enableStatsToServer(z, z, str);
        }
    }

    @Override // com.baidu.rtc.JanusRTCInterface
    public void onAttribute(BigInteger bigInteger, String str) {
        BaiduRtcRoom.BaiduRtcRoomDelegate baiduRtcRoomDelegate;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048608, this, bigInteger, str) != null) || (baiduRtcRoomDelegate = this.mBaiduRtcRoomDelegate) == null) {
            return;
        }
        baiduRtcRoomDelegate.onRoomEventUpdate(303, bigInteger.longValue(), str);
    }

    @Override // com.baidu.rtc.JanusRTCInterface
    public void onCreatedHandle(BigInteger bigInteger, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048611, this, bigInteger, j) == null) {
            this.mIsLoginSuccess = false;
            if (this.mIsEnablePushQualityMonitor) {
                reportSLILoginEvent(CommonDefine.SLILoginEvent.ENTER_BEGIN, j);
            }
        }
    }

    @Override // com.baidu.rtc.PeerConnectionClient.PeerConnectionEvents
    public void onIceCandidate(IceCandidate iceCandidate, BigInteger bigInteger) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048613, this, iceCandidate, bigInteger) == null) {
            Log.e(TAG, "=========onIceCandidate========");
            if (iceCandidate != null) {
                this.mWebSocketChannel.trickleCandidate(bigInteger, iceCandidate);
            } else {
                this.mWebSocketChannel.trickleCandidateComplete(bigInteger);
            }
        }
    }

    @Override // com.baidu.rtc.JanusRTCInterface
    public void onLivePublishSucceed(BaiduRtcRoom.RtcLiveTransferMode rtcLiveTransferMode, String str) {
        BaiduRtcRoom.BaiduRtcRoomDelegate baiduRtcRoomDelegate;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048621, this, rtcLiveTransferMode, str) != null) || (baiduRtcRoomDelegate = this.mBaiduRtcRoomDelegate) == null) {
            return;
        }
        baiduRtcRoomDelegate.onRoomEventUpdate(116, rtcLiveTransferMode.ordinal(), str);
    }

    @Override // com.baidu.rtc.JanusRTCInterface
    public void onMessage(BigInteger bigInteger, String str) {
        BaiduRtcRoom.BaiduRtcRoomDelegate baiduRtcRoomDelegate;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048626, this, bigInteger, str) != null) || (baiduRtcRoomDelegate = this.mBaiduRtcRoomDelegate) == null) {
            return;
        }
        baiduRtcRoomDelegate.onRoomEventUpdate(302, bigInteger.longValue(), str);
    }

    @Override // com.baidu.rtc.PeerConnectionClient.PeerConnectionEvents
    public void onRemoteDescription(SessionDescription sessionDescription, BigInteger bigInteger) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048634, this, sessionDescription, bigInteger) == null) {
            Log.e(TAG, sessionDescription.type.toString());
            this.mWebSocketChannel.subscriberCreateAnswer(bigInteger, sessionDescription);
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void sendMessageToUser(String str, long j) {
        WebSocketChannel webSocketChannel;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLJ(1048655, this, str, j) != null) || (webSocketChannel = this.mWebSocketChannel) == null) {
            return;
        }
        webSocketChannel.sendMessageToUser(str, j);
        try {
            Thread.sleep(10L);
        } catch (InterruptedException unused) {
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void setBaiduRtcAppID(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048658, this, str, str2) == null) {
            this.mWebSocketChannel.setAppId(str);
            this.mAppId = str;
            this.mWebSocketChannel.setTokenStr(str2);
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void setRemoteDisplay(RTCVideoView rTCVideoView, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048677, this, rTCVideoView, j) == null) {
            this.mHandler.post(new Runnable(this, rTCVideoView, j) { // from class: com.baidu.rtc.internal.BaiduRtcRoomImp.10
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BaiduRtcRoomImp this$0;
                public final /* synthetic */ RTCVideoView val$remoteVideoView;
                public final /* synthetic */ long val$userId;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, rTCVideoView, Long.valueOf(j)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$remoteVideoView = rTCVideoView;
                    this.val$userId = j;
                }

                @Override // java.lang.Runnable
                public void run() {
                    boolean z;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            int i = 0;
                            if (this.this$0.mRemoteRenderList == null) {
                                this.this$0.mRemoteRenderList = new RTCVideoView[]{this.val$remoteVideoView};
                                this.val$remoteVideoView.init(this.this$0.rootEglBase.getEglBaseContext(), null);
                                this.val$remoteVideoView.setEnableHardwareScaler(true);
                            } else {
                                int i2 = 0;
                                while (true) {
                                    if (i2 < this.this$0.mRemoteRenderList.length) {
                                        if (this.this$0.mRemoteRenderList[i2] == this.val$remoteVideoView) {
                                            z = true;
                                            break;
                                        }
                                        i2++;
                                    } else {
                                        i2 = 0;
                                        z = false;
                                        break;
                                    }
                                }
                                if (!z) {
                                    this.val$remoteVideoView.init(this.this$0.rootEglBase.getEglBaseContext(), null);
                                    this.val$remoteVideoView.setEnableHardwareScaler(true);
                                    RTCVideoView[] rTCVideoViewArr = new RTCVideoView[this.this$0.mRemoteRenderList.length + 1];
                                    while (i < this.this$0.mRemoteRenderList.length) {
                                        rTCVideoViewArr[i] = this.this$0.mRemoteRenderList[i];
                                        i++;
                                    }
                                    rTCVideoViewArr[this.this$0.mRemoteRenderList.length] = this.val$remoteVideoView;
                                    this.this$0.mRemoteRenderList = rTCVideoViewArr;
                                    i = this.this$0.mRemoteRenderList.length - 1;
                                } else {
                                    i = i2;
                                }
                            }
                            this.this$0.mFeedToViewMap.put(BigInteger.valueOf(this.val$userId), BigInteger.valueOf(i));
                            this.this$0.mHasVideoView[i] = true;
                        } catch (Exception unused) {
                            Log.e(BaiduRtcRoomImp.TAG, "setRemoteDisplay error,userId:" + this.val$userId);
                        }
                    }
                }
            });
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void shutUpUserWithId(long j, boolean z) {
        WebSocketChannel webSocketChannel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048686, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) && (webSocketChannel = this.mWebSocketChannel) != null) {
            webSocketChannel.shutUpUserWithId(j, z);
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public boolean loginRtcRoomWithRoomName(String str, long j, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048601, this, new Object[]{str, Long.valueOf(j), str2})) == null) {
            return loginRtcRoomWithRoomName(str, j, str2, true, true);
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.baidu.rtc.PeerConnectionClient.PeerConnectionEvents
    public void onLocalDescription(SessionDescription sessionDescription, BigInteger bigInteger, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048622, this, sessionDescription, bigInteger, z) == null) {
            Log.e(TAG, sessionDescription.type.toString());
            WebSocketChannel webSocketChannel = this.mWebSocketChannel;
            if (webSocketChannel == null) {
                return;
            }
            this.isEnableHighProfileConfirm = z;
            webSocketChannel.publisherCreateOffer(bigInteger, sessionDescription);
            this.mHandler.post(new Runnable(this) { // from class: com.baidu.rtc.internal.BaiduRtcRoomImp.14
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BaiduRtcRoomImp this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.this$0.peerConnectionClient != null && this.this$0.peerConnectionParameters.videoMaxkbps > 0) {
                        Log.d(BaiduRtcRoomImp.TAG, "Set video maximum bitrate: " + this.this$0.peerConnectionParameters.videoMaxkbps);
                        this.this$0.peerConnectionClient.setVideoMaxBitrate(Integer.valueOf(this.this$0.peerConnectionParameters.videoMaxkbps));
                    }
                }
            });
        }
    }

    @Override // com.baidu.rtc.PeerConnectionClient.PeerConnectionEvents
    public void onRemoteStreamStats(Boolean bool, Boolean bool2, BigInteger bigInteger) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048637, this, bool, bool2, bigInteger) == null) {
            this.mHandler.post(new Runnable(this, bigInteger, bool, bool2) { // from class: com.baidu.rtc.internal.BaiduRtcRoomImp.16
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BaiduRtcRoomImp this$0;
                public final /* synthetic */ BigInteger val$handleID;
                public final /* synthetic */ Boolean val$hasAudio;
                public final /* synthetic */ Boolean val$hasVideo;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, bigInteger, bool, bool2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$handleID = bigInteger;
                    this.val$hasVideo = bool;
                    this.val$hasAudio = bool2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 != null && interceptable2.invokeV(1048576, this) != null) || this.this$0.mWebSocketChannel == null) {
                        return;
                    }
                    BigInteger feedByHandle = this.this$0.mWebSocketChannel.getFeedByHandle(this.val$handleID);
                    String nickNameByFeed = this.this$0.mWebSocketChannel.getNickNameByFeed(feedByHandle);
                    StreamStats streamStats = (StreamStats) this.this$0.mRemoteStreamStats.get(feedByHandle);
                    if (streamStats == null) {
                        streamStats = new StreamStats(this.val$handleID, feedByHandle.longValue(), this.val$hasVideo, this.val$hasAudio, nickNameByFeed);
                        this.this$0.mRemoteStreamStats.put(feedByHandle, streamStats);
                    } else {
                        streamStats.hasVideo = this.val$hasVideo;
                        streamStats.hasAudio = this.val$hasAudio;
                        streamStats.handleId = this.val$handleID;
                        streamStats.nickName = nickNameByFeed;
                    }
                    if (this.val$hasAudio.booleanValue()) {
                        BaiduRtcRoom.BaiduRtcRoomDelegate baiduRtcRoomDelegate = this.this$0.mBaiduRtcRoomDelegate;
                        if (baiduRtcRoomDelegate != null) {
                            baiduRtcRoomDelegate.onRoomEventUpdate(108, feedByHandle.longValue(), "");
                        }
                        if (this.this$0.peerConnectionClient != null) {
                            this.this$0.peerConnectionClient.enableStatsEvents(true, 200, streamStats.handleId, PeerConnectionClient.StatsEventsType.GET_AUDIOLEVEL_EVENT);
                        }
                    }
                }
            });
        }
    }

    @Override // com.baidu.rtc.JanusRTCInterface
    public void onUserJoinedRoom(BigInteger bigInteger, String str, String str2) {
        BaiduRtcRoom.BaiduRtcRoomDelegate baiduRtcRoomDelegate;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048644, this, bigInteger, str, str2) != null) || (baiduRtcRoomDelegate = this.mBaiduRtcRoomDelegate) == null) {
            return;
        }
        baiduRtcRoomDelegate.onRoomEventUpdate(300, bigInteger.longValue(), str);
    }

    private VideoCapturer createCameraCapturer(CameraEnumerator cameraEnumerator) {
        InterceptResult invokeL;
        CameraVideoCapturer createCapturer;
        CameraVideoCapturer createCapturer2;
        CameraVideoCapturer createCapturer3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65577, this, cameraEnumerator)) == null) {
            String[] deviceNames = cameraEnumerator.getDeviceNames();
            int i = this.mCameraID;
            if (i != DEFAULT_CAMERA_ID && i < deviceNames.length && (createCapturer3 = cameraEnumerator.createCapturer(deviceNames[i], null)) != null) {
                return createCapturer3;
            }
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
        return (VideoCapturer) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public VideoCapturer createVideoCapturer() {
        InterceptResult invokeV;
        VideoCapturer createCameraCapturer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65578, this)) == null) {
            VideoCapturer videoCapturer = this.videoCapturer;
            if (videoCapturer != null) {
                return videoCapturer;
            }
            if (useCamera2()) {
                Log.d(TAG, "Creating capturer using camera2 API.");
                createCameraCapturer = createCameraCapturer(new Camera2Enumerator(this.mContext.get()));
            } else {
                Log.d(TAG, "Creating capturer using camera1 API.");
                createCameraCapturer = createCameraCapturer(new Camera1Enumerator(captureToTexture()));
            }
            if (createCameraCapturer == null) {
                Log.e(TAG, "Failed to open camera");
                return null;
            }
            return createCameraCapturer;
        }
        return (VideoCapturer) invokeV.objValue;
    }

    private void disposeExternalRenderers() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65579, this) != null) || this.mUserIdVideoRendererMap.isEmpty()) {
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

    private synchronized void disposePendingRenderers() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65580, this) == null) {
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
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void stopPublish() {
        WebSocketChannel webSocketChannel;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048692, this) != null) || (webSocketChannel = this.mWebSocketChannel) == null) {
            return;
        }
        webSocketChannel.unpublishHandle(this.mPublisherHandle);
        if (this.peerConnectionClient != null) {
            this.peerConnectionClient.stopAudioSource();
            this.peerConnectionClient.stopVideoSource();
            this.peerConnectionClient.closePeer(this.mPublisherHandle);
            if (this.mLocalRender != null) {
                new Handler().postDelayed(new Runnable(this) { // from class: com.baidu.rtc.internal.BaiduRtcRoomImp.7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ BaiduRtcRoomImp this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.this$0.mLocalRender.clearImage();
                        }
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

    public static BaiduRtcRoom.RoomInfo getRoomInfofromPlatformServer(String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65581, null, str, str2, str3, str4)) == null) {
            BaiduRtcRoom.RoomInfo roomInfo = new BaiduRtcRoom.RoomInfo();
            try {
                MediaType parse = MediaType.parse("application/json;charset=utf-8");
                OkHttpClient build = new OkHttpClient.Builder().addInterceptor(new Interceptor() { // from class: com.baidu.rtc.internal.BaiduRtcRoomImp.20
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                            }
                        }
                    }

                    @Override // okhttp3.Interceptor
                    public Response intercept(Interceptor.Chain chain) throws IOException {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, chain)) == null) {
                            return chain.proceed(chain.request().newBuilder().build());
                        }
                        return (Response) invokeL.objValue;
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
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } catch (IOException | Exception unused) {
            }
            return roomInfo;
        }
        return (BaiduRtcRoom.RoomInfo) invokeLLLL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isHeadsetOn(Context context) {
        InterceptResult invokeL;
        AudioDeviceInfo[] devices;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65582, this, context)) == null) {
            if (this.audioManager == null) {
                this.audioManager = (AudioManager) context.getSystemService("audio");
            }
            AudioManager audioManager = this.audioManager;
            if (audioManager == null) {
                return false;
            }
            if (Build.VERSION.SDK_INT < 23) {
                if (!audioManager.isWiredHeadsetOn() && !this.audioManager.isBluetoothScoOn() && !this.audioManager.isBluetoothA2dpOn()) {
                    return false;
                }
                return true;
            }
            for (AudioDeviceInfo audioDeviceInfo : audioManager.getDevices(2)) {
                if (audioDeviceInfo.getType() == 3 || audioDeviceInfo.getType() == 4 || audioDeviceInfo.getType() == 8 || audioDeviceInfo.getType() == 7 || audioDeviceInfo.getType() == 11) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    private void onPacketLossEvent(Map<String, Integer> map) {
        long j;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65585, this, map) == null) {
            long j3 = 0;
            if (map.get("packetloss_s") != null) {
                j = map.get("packetloss_s").intValue();
            } else {
                j = 0;
            }
            if (map.get("packetlost") != null) {
                j2 = map.get("packetlost").intValue();
            } else {
                j2 = 0;
            }
            if (map.get("packesend") != null) {
                j3 = map.get("packesend").intValue();
            }
            if (this.mBaiduRtcRoomDelegate != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("packetsLost", j2);
                    jSONObject.put("packetsSent", j3);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                this.mBaiduRtcRoomDelegate.onRoomEventUpdate(201, j, jSONObject.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportRoomEventInfo(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65589, this, str) == null) {
            if ((!this.mIsEnablePushQualityMonitor && !this.mIsEnablePullQualityMonitor) || this.mWebSocketChannel == null) {
                return;
            }
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
            } catch (JSONException e) {
                Log.e(TAG, "Caught error on reportRoomEventInfo: " + e);
            }
            this.rtcLogReport.report(jSONObject.toString(), 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int setBluetoothScoOn(Boolean bool) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65594, this, bool)) == null) {
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
            } catch (Exception e) {
                Log.e(TAG, "set bluetooth sco fail: " + e.getMessage());
                return -1;
            }
        }
        return invokeL.intValue;
    }

    public synchronized RTCVideoExternalRender getExternalRender(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048593, this, j)) == null) {
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
        return (RTCVideoExternalRender) invokeJ.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onFfDelayChange(JanusConnection janusConnection, BigInteger bigInteger) {
        HUDStatistics hUDStatistics;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65584, this, janusConnection, bigInteger) == null) && this.mIsEnablePullQualityMonitor && (hUDStatistics = this.mHUDStatisticsMap.get(janusConnection.handleId)) != null) {
            hUDStatistics.setFirstFrameTime(System.currentTimeMillis());
            reportSLIFfDelay(bigInteger.longValue(), hUDStatistics.getFirstFrameTime() - hUDStatistics.getRequestSubscribeTime());
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void destroyExternalSurface(long j, Surface surface) {
        RTCVideoExternalRender rTCVideoExternalRender;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048580, this, j, surface) == null) {
            if (this.mUserIdVideoRendererMap.containsKey(Long.valueOf(j)) && (rTCVideoExternalRender = this.mUserIdVideoRendererMap.get(Long.valueOf(j))) != null && surface == rTCVideoExternalRender.getSurface()) {
                rTCVideoExternalRender.releaseSurface();
            }
            disposePendingRenderers();
        }
    }

    @Override // com.baidu.rtc.JanusRTCInterface
    public void onComing(BigInteger bigInteger, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048609, this, bigInteger, str) == null) {
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
    }

    @Override // com.baidu.rtc.JanusRTCInterface
    public void onLivePublishFailed(BaiduRtcRoom.RtcLiveTransferMode rtcLiveTransferMode, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048619, this, rtcLiveTransferMode, str) == null) {
            if (this.mIsEnableErrorInfoMonitor) {
                if (rtcLiveTransferMode.ordinal() == BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ROOM_TRANSMISSION.ordinal()) {
                    ErrorInfoReport.getInstance().reportErrorInfo(ErrorInfoReport.ErrorCode.ROOM_LIVE_PUBLISH_FAIL);
                } else {
                    ErrorInfoReport.getInstance().reportErrorInfo(ErrorInfoReport.ErrorCode.ANCHOR_LIVE_PUBLISH_FAIL);
                }
            }
            BaiduRtcRoom.BaiduRtcRoomDelegate baiduRtcRoomDelegate = this.mBaiduRtcRoomDelegate;
            if (baiduRtcRoomDelegate == null) {
                return;
            }
            baiduRtcRoomDelegate.onRoomEventUpdate(117, rtcLiveTransferMode.ordinal(), str);
        }
    }

    @Override // com.baidu.rtc.JanusRTCInterface
    public void onLivePublishInterrupted(BaiduRtcRoom.RtcLiveTransferMode rtcLiveTransferMode, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048620, this, rtcLiveTransferMode, str) == null) {
            if (this.mIsEnableErrorInfoMonitor) {
                if (rtcLiveTransferMode.ordinal() == BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ROOM_TRANSMISSION.ordinal()) {
                    ErrorInfoReport.getInstance().reportErrorInfo(ErrorInfoReport.ErrorCode.ROOM_LIVE_INTRERRUPT);
                } else {
                    ErrorInfoReport.getInstance().reportErrorInfo(ErrorInfoReport.ErrorCode.ANCHOR_LIVE_INTRERRUPT);
                }
            }
            BaiduRtcRoom.BaiduRtcRoomDelegate baiduRtcRoomDelegate = this.mBaiduRtcRoomDelegate;
            if (baiduRtcRoomDelegate == null) {
                return;
            }
            baiduRtcRoomDelegate.onRoomEventUpdate(118, rtcLiveTransferMode.ordinal(), str);
        }
    }

    @Override // com.baidu.rtc.JanusRTCInterface
    public void subscriberHandleRemoteJsep(BigInteger bigInteger, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048695, this, bigInteger, jSONObject) == null) {
            this.peerConnectionClient.subscriberHandleRemoteJsep(bigInteger, new SessionDescription(SessionDescription.Type.fromCanonicalForm(jSONObject.optString("type")), jSONObject.optString("sdp")));
            this.mHandler.post(new Runnable(this, bigInteger) { // from class: com.baidu.rtc.internal.BaiduRtcRoomImp.12
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BaiduRtcRoomImp this$0;
                public final /* synthetic */ BigInteger val$handleId;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, bigInteger};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$handleId = bigInteger;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        BaiduRtcRoomImp baiduRtcRoomImp = this.this$0;
                        if (baiduRtcRoomImp.mIsEnablePullQualityMonitor && this.val$handleId != baiduRtcRoomImp.mPublisherHandle && baiduRtcRoomImp.peerConnectionClient != null) {
                            if (this.this$0.mHUDStatisticsMap.get(this.val$handleId) != null) {
                                this.this$0.peerConnectionClient.enableStatsEvents(false, 0, this.val$handleId, PeerConnectionClient.StatsEventsType.GET_QUALITY_MONITOR_EVENT);
                                this.this$0.peerConnectionClient.enableStatsEvents(false, 0, this.val$handleId, PeerConnectionClient.StatsEventsType.GET_SLI_EVENT);
                                this.this$0.mHUDStatisticsMap.remove(this.val$handleId);
                            }
                            this.this$0.peerConnectionClient.enableStatsEvents(this.this$0.mIsEnablePullQualityMonitor, 2000, this.val$handleId, PeerConnectionClient.StatsEventsType.GET_QUALITY_MONITOR_EVENT);
                            this.this$0.peerConnectionClient.enableStatsEvents(this.this$0.mIsEnablePullQualityMonitor, 5000, this.val$handleId, PeerConnectionClient.StatsEventsType.GET_SLI_EVENT);
                            HUDStatistics hUDStatistics = new HUDStatistics();
                            this.this$0.mHUDStatisticsMap.put(this.val$handleId, hUDStatistics);
                            hUDStatistics.setRequestSubscribeTime(System.currentTimeMillis());
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void parseAudioLeves(StatsReport[] statsReportArr, BigInteger bigInteger) {
        WebSocketChannel webSocketChannel;
        BigInteger feedByHandle;
        StatsReport.Value[] valueArr;
        StatsReport.Value[] valueArr2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65586, this, statsReportArr, bigInteger) != null) || (webSocketChannel = this.mWebSocketChannel) == null) {
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
                            } catch (NumberFormatException e) {
                                Log.e(TAG, "parse string num exception: " + e);
                            }
                        }
                    }
                }
            } else if (statsReport.type.equals("ssrc") && statsReport.id.contains("ssrc") && statsReport.id.contains("recv")) {
                for (StatsReport.Value value2 : statsReport.values) {
                    if (value2.name.contains("audioOutputLevel")) {
                        try {
                            streamStats.volume = Integer.valueOf(value2.value).intValue();
                        } catch (NumberFormatException e2) {
                            Log.e(TAG, "parse string num exception: " + e2);
                        }
                    }
                }
            }
        }
    }

    private void reportSLIFfDelay(long j, long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65590, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) != null) || this.mWebSocketChannel == null) {
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
        } catch (JSONException e) {
            Log.e(TAG, "Caught error on reportDeviceInfo: " + e);
        }
        this.rtcLogReport.report(jSONObject.toString(), 3);
        if (this.mIsEnableErrorInfoMonitor && j2 > 3000) {
            BigInteger valueOf = BigInteger.valueOf(0L);
            WebSocketChannel webSocketChannel = this.mWebSocketChannel;
            if (webSocketChannel != null && webSocketChannel.getHandleByFeed(BigInteger.valueOf(j)) != null) {
                valueOf = this.mWebSocketChannel.getHandleByFeed(BigInteger.valueOf(j)).handleId;
            }
            ErrorInfoReport.getInstance().reportErrorInfo(ErrorInfoReport.ErrorCode.BAD_FIRST_FRAME_TIME, j2, valueOf, BigInteger.valueOf(j));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportCommunicationQualityInfo() {
        HUDStatistics hUDStatistics;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65587, this) != null) || this.mWebSocketChannel == null) {
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
                    jSONObject4.put("bitrate", hashMap.get("bitrate_s"));
                    jSONObject4.put("packetloss", hashMap.get("packetloss_s"));
                    jSONObject4.put("cfps", hashMap.get("fps_s"));
                    jSONObject4.put(FpsConstants.REPORT_FPS, hashMap.get("fps_i"));
                    if (hUDStatistics2 == null) {
                        jSONObject4.put("resolution", "");
                    } else {
                        jSONObject4.put("resolution", hUDStatistics2.getSendResolution());
                    }
                } else {
                    jSONObject4.put("bitrate", 0);
                    jSONObject4.put("packetloss", 0);
                    jSONObject4.put(FpsConstants.REPORT_FPS, 0);
                    jSONObject4.put("resolution", "");
                }
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
                            jSONObject5.put("bitrate", hashMap2.get("bitrate_r"));
                            jSONObject5.put("packetloss", hashMap2.get("packetloss_r"));
                            jSONObject5.put(FpsConstants.REPORT_FPS, hashMap2.get("fps_r"));
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
        } catch (JSONException e) {
            Log.e(TAG, "Caught error on reportCommunicationQualityInfo: " + e);
        }
        this.rtcLogReport.report(jSONObject.toString(), 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportDeviceInfo() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65588, this) != null) || this.mWebSocketChannel == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(CommandMessage.SDK_VERSION, Constraints.sdkVersion());
            jSONObject2.put("networkType", RtcLogReport.getNetworkType(this.mContext.get()));
            jSONObject2.put(Config.DEVICE_PART, RtcLogReport.getDeviceModel());
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(GrowthConstant.UBC_VALUE_TYPE_DEVICE_INFO, jSONObject2);
            jSONObject.put("env", this.mQualityMonitorEnv);
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.mAppId);
            if (this.mWebSocketChannel != null) {
                jSONObject.put(ILiveNPSPlugin.PARAMS_ROOM_ID, this.mWebSocketChannel.getRoomId());
            }
            jSONObject.put("timestamp", System.currentTimeMillis());
            jSONObject.put("userId", this.mUserId);
            jSONObject.put("message", jSONObject3);
        } catch (JSONException e) {
            Log.e(TAG, "Caught error on reportDeviceInfo: " + e);
        }
        this.rtcLogReport.report(jSONObject.toString(), 0);
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public boolean logoutRtcRoom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            if (this.peerConnectionClient == null) {
                return true;
            }
            int i = 0;
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
            d dVar = this.mAudioFilter;
            if (dVar != null) {
                dVar.k(null);
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
                    if (i >= rTCVideoViewArr.length) {
                        break;
                    }
                    if (rTCVideoViewArr[i] != null) {
                        rTCVideoViewArr[i].release();
                        this.mRemoteRenderList[i] = null;
                    }
                    i++;
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
            this.mHandler.removeCallbacksAndMessages(null);
            System.gc();
            return true;
        }
        return invokeV.booleanValue;
    }

    private void reportSLILoginEvent(String str, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLJ(65592, this, str, j) != null) || this.mWebSocketChannel == null) {
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
        } catch (JSONException e) {
            Log.e(TAG, "Caught error on reportDeviceInfo: " + e);
        }
        this.rtcLogReport.report(jSONObject.toString(), 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportSLIStuckInfo() {
        HUDStatistics hUDStatistics;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65593, this) == null) && this.mWebSocketChannel != null && this.mIsEnablePullQualityMonitor) {
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
                            for (int i = 0; i < arrayList.size(); i++) {
                                jSONArray.put(arrayList.get(i));
                            }
                        }
                        ArrayList<Long> arrayList2 = hashMap.get("vStuck");
                        if (arrayList2.size() == 0) {
                            jSONArray2.put(0);
                        } else {
                            for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                                jSONArray2.put(arrayList2.get(i2));
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
                    } catch (JSONException e) {
                        Log.e(TAG, "Caught error on reportDeviceInfo: " + e);
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

    private synchronized void userRenderMove2PendingMap(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65598, this, j) == null) {
            synchronized (this) {
                if (!this.mUserIdVideoRendererMap.containsKey(Long.valueOf(j))) {
                    return;
                }
                this.mPendingRemoveRendererMap.put(Long.valueOf(j), this.mUserIdVideoRendererMap.get(Long.valueOf(j)));
                this.mUserIdVideoRendererMap.remove(Long.valueOf(j));
            }
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public BaiduRtcRoom.RtcRoomVideoDimension getRemoteVideoDimension(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048595, this, j)) == null) {
            RTCVideoExternalRenderImp rTCVideoExternalRenderImp = (RTCVideoExternalRenderImp) this.mUserIdVideoRendererMap.get(Long.valueOf(j));
            BaiduRtcRoom.RtcRoomVideoDimension rtcRoomVideoDimension = new BaiduRtcRoom.RtcRoomVideoDimension();
            if (rTCVideoExternalRenderImp != null) {
                rtcRoomVideoDimension.videoWidth = rTCVideoExternalRenderImp.getVideoWidth();
                rtcRoomVideoDimension.videoHeight = rTCVideoExternalRenderImp.getVideoHeight();
                rtcRoomVideoDimension.videoRotation = rTCVideoExternalRenderImp.getVideoRotation();
            }
            return rtcRoomVideoDimension;
        }
        return (BaiduRtcRoom.RtcRoomVideoDimension) invokeJ.objValue;
    }

    @Override // com.baidu.rtc.PeerConnectionClient.PeerConnectionEvents
    public void onPeerConnectionError(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, str) == null) {
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
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void changeSurfaceSize(long j, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2)}) == null) {
            if (!this.mUserIdVideoRendererMap.containsKey(Long.valueOf(j))) {
                Log.d(TAG, "External render not found to  change surface size for " + j);
                return;
            }
            RTCVideoExternalRender rTCVideoExternalRender = this.mUserIdVideoRendererMap.get(Long.valueOf(j));
            if (rTCVideoExternalRender != null) {
                rTCVideoExternalRender.changeSurfaceSize(i, i2);
            }
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void enableStatsToServer(boolean z, boolean z2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) {
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
    }

    @Override // com.baidu.rtc.JanusRTCInterface
    public void onMediaStreamingEvent(BigInteger bigInteger, int i, boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048625, this, new Object[]{bigInteger, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            if (this.mIsEnableErrorInfoMonitor) {
                if (i == 1 && !z) {
                    ErrorInfoReport.getInstance().reportErrorInfo(ErrorInfoReport.ErrorCode.VIDEO_SENDING_MEDIA_FAILED);
                } else if (i == 0 && !z) {
                    ErrorInfoReport.getInstance().reportErrorInfo(ErrorInfoReport.ErrorCode.AUDIO_SENDING_MEDIA_FAILED);
                }
            }
            BaiduRtcRoom.BaiduRtcRoomDelegate baiduRtcRoomDelegate = this.mBaiduRtcRoomDelegate;
            if (baiduRtcRoomDelegate == null) {
                return;
            }
            if (z) {
                i2 = 2001;
            } else {
                i2 = 2002;
            }
            baiduRtcRoomDelegate.onPeerConnectStateUpdate(i2);
        }
    }

    @Override // com.baidu.rtc.PeerConnectionClient.PeerConnectionEvents
    public void onPeerConnectionStatsReady(StatsReport[] statsReportArr, BigInteger bigInteger, PeerConnectionClient.StatsEventsType statsEventsType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048630, this, statsReportArr, bigInteger, statsEventsType) == null) {
            for (StatsReport statsReport : statsReportArr) {
                Log.e(TAG, "onPeerConnectionStats" + statsReport.toString());
            }
            if (bigInteger == this.mPublisherHandle && statsEventsType == PeerConnectionClient.StatsEventsType.GET_BWE_EVENT && this.mbOnStatistics) {
                updateBweStatistics(statsReportArr);
            }
            this.mHandler.post(new Runnable(this, statsEventsType, statsReportArr, bigInteger) { // from class: com.baidu.rtc.internal.BaiduRtcRoomImp.15
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BaiduRtcRoomImp this$0;
                public final /* synthetic */ PeerConnectionClient.StatsEventsType val$eventsType;
                public final /* synthetic */ BigInteger val$handleId;
                public final /* synthetic */ StatsReport[] val$reports;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, statsEventsType, statsReportArr, bigInteger};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$eventsType = statsEventsType;
                    this.val$reports = statsReportArr;
                    this.val$handleId = bigInteger;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (this.val$eventsType == PeerConnectionClient.StatsEventsType.GET_AUDIOLEVEL_EVENT) {
                            this.this$0.parseAudioLeves(this.val$reports, this.val$handleId);
                        }
                        HUDStatistics hUDStatistics = (HUDStatistics) this.this$0.mHUDStatisticsMap.get(this.val$handleId);
                        if (hUDStatistics != null) {
                            hUDStatistics.updateEncoderStatistics(this.val$reports);
                        }
                        BaiduRtcRoomImp baiduRtcRoomImp = this.this$0;
                        if ((baiduRtcRoomImp.mIsEnablePushQualityMonitor || baiduRtcRoomImp.mIsEnablePullQualityMonitor) && this.val$eventsType == PeerConnectionClient.StatsEventsType.GET_QUALITY_MONITOR_EVENT) {
                            BigInteger bigInteger2 = this.val$handleId;
                            BaiduRtcRoomImp baiduRtcRoomImp2 = this.this$0;
                            if (bigInteger2 == baiduRtcRoomImp2.mPublisherHandle && baiduRtcRoomImp2.rtcLogReport != null) {
                                baiduRtcRoomImp2.reportCommunicationQualityInfo();
                            }
                        }
                        BaiduRtcRoomImp baiduRtcRoomImp3 = this.this$0;
                        if ((baiduRtcRoomImp3.mIsEnablePushQualityMonitor || baiduRtcRoomImp3.mIsEnablePullQualityMonitor) && this.val$eventsType == PeerConnectionClient.StatsEventsType.GET_SLI_EVENT) {
                            BigInteger bigInteger3 = this.val$handleId;
                            BaiduRtcRoomImp baiduRtcRoomImp4 = this.this$0;
                            if (bigInteger3 != baiduRtcRoomImp4.mPublisherHandle || baiduRtcRoomImp4.rtcLogReport == null) {
                                return;
                            }
                            baiduRtcRoomImp4.reportSLIStuckInfo();
                        }
                    }
                }
            });
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public boolean configLiveServerWithUrl(String str, boolean z, boolean z2, String str2, BaiduRtcRoom.RtcLiveTransferMode rtcLiveTransferMode) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2), str2, rtcLiveTransferMode})) == null) {
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
        return invokeCommon.booleanValue;
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public BaiduRtcRoom.RtcRoomAudioLevel[] getRemoteAudioLevels() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            int i = 0;
            int i2 = 0;
            for (BigInteger bigInteger : this.mRemoteStreamStats.keySet()) {
                StreamStats streamStats = this.mRemoteStreamStats.get(bigInteger);
                if (streamStats != null && streamStats.hasAudio.booleanValue() && streamStats.volume != -1) {
                    i2++;
                }
            }
            BaiduRtcRoom.RtcRoomAudioLevel[] rtcRoomAudioLevelArr = new BaiduRtcRoom.RtcRoomAudioLevel[i2];
            for (BigInteger bigInteger2 : this.mRemoteStreamStats.keySet()) {
                StreamStats streamStats2 = this.mRemoteStreamStats.get(bigInteger2);
                if (streamStats2 != null && streamStats2.volume != -1 && streamStats2.hasAudio.booleanValue()) {
                    if (i >= i2) {
                        break;
                    }
                    rtcRoomAudioLevelArr[i] = new BaiduRtcRoom.RtcRoomAudioLevel();
                    rtcRoomAudioLevelArr[i].userId = streamStats2.userId;
                    rtcRoomAudioLevelArr[i].volumeLevel = streamStats2.volume;
                    rtcRoomAudioLevelArr[i].nicName = streamStats2.nickName;
                    i++;
                }
            }
            return rtcRoomAudioLevelArr;
        }
        return (BaiduRtcRoom.RtcRoomAudioLevel[]) invokeV.objValue;
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public boolean loginRtcRoomWithRoomName(String str, long j, String str2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048602, this, new Object[]{str, Long.valueOf(j), str2, Boolean.valueOf(z)})) == null) {
            Log.i(TAG, "enable force login");
            this.mIsCompulsive = z;
            return loginRtcRoomWithRoomName(str, j, str2, true, true);
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public boolean loginRtcRoomWithRoomName(String str, long j, String str2, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048603, this, new Object[]{str, Long.valueOf(j), str2, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            this.mDisplayName = str2;
            this.mRoomName = str;
            this.mUserId = j;
            this.mIsAsPublisher = z;
            this.mIsAsListener = z2;
            if (this.mIsEnableSoLaterLoad && !RTCLoadManager.getInstance(this.mSoContext).isLoadCompleted()) {
                RTCLoadManager.getInstance(this.mSoContext).loadLibraries(this.mSoLaterLoadUrl, this.mCpuType, this.mLoadListener);
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
                int i3 = rtcParameterSettings.VideoWidth;
                int i4 = rtcParameterSettings.VideoHeight;
                String lowerCase = rtcParameterSettings.VideoResolution.toLowerCase();
                if (lowerCase.contains("192x144")) {
                    i3 = 192;
                    i4 = Cea708Decoder.COMMAND_SPA;
                } else if (lowerCase.contains("320x180")) {
                    i4 = 180;
                    i3 = MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP;
                } else if (lowerCase.contains("352x288")) {
                    i3 = 352;
                    i4 = 288;
                } else if (lowerCase.contains("480x320")) {
                    i3 = 480;
                    i4 = MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP;
                } else {
                    if (lowerCase.contains("320x480")) {
                        i3 = MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP;
                    } else {
                        if (lowerCase.contains("480x360")) {
                            i3 = 480;
                        } else if (lowerCase.contains("640x360")) {
                            i3 = 640;
                        } else if (lowerCase.contains("640x480")) {
                            i3 = 640;
                        } else if (lowerCase.contains("960x540")) {
                            i3 = 960;
                            i4 = 540;
                        } else if (lowerCase.contains("1280x720")) {
                            i3 = 1280;
                            i4 = 720;
                        } else if (lowerCase.contains("1920x1080")) {
                            i3 = 1920;
                            i4 = 1080;
                        } else {
                            if (lowerCase.contains("3840x2160")) {
                                i3 = 3840;
                            } else if (lowerCase.contains("4096x2160")) {
                                i3 = 4096;
                            } else {
                                if (lowerCase.contains("7680x4320")) {
                                    i3 = 7680;
                                } else {
                                    i3 = lowerCase.contains("8192x4320") ? 8192 : 8192;
                                }
                                i4 = 4320;
                            }
                            i4 = DisplayCompat.DISPLAY_SIZE_4K_HEIGHT;
                        }
                        i4 = 360;
                    }
                    i4 = 480;
                }
                if (i3 <= 8192 && i4 <= 4320) {
                    i = i3;
                    i2 = i4;
                } else {
                    i = 8192;
                    i2 = 4320;
                }
                if (Build.MODEL.contains("Redmi 6 Pro")) {
                    this.mParamSettings.DisableBuiltInAEC = true;
                    this.disableBuiltInNS = Boolean.TRUE;
                }
                if (Build.MANUFACTURER.trim().toLowerCase().contains(ManufacturerUtils.SAMSUNG)) {
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
                int i5 = rtcParameterSettings3.VideoFps;
                String upperCase = rtcParameterSettings3.VideoCodec.toUpperCase();
                boolean z3 = this.mParamSettings.DisableBuiltInAEC;
                boolean booleanValue = this.disableBuiltInAGC.booleanValue();
                boolean booleanValue2 = this.disableBuiltInNS.booleanValue();
                RtcParameterSettings rtcParameterSettings4 = this.mParamSettings;
                this.peerConnectionParameters = new PeerConnectionClient.PeerConnectionParameters(false, i, i2, i5, upperCase, true, 0, "opus", false, false, z3, booleanValue, booleanValue2, rtcParameterSettings4.VideoMaxkbps, rtcParameterSettings4.VideoMinkbps, rtcParameterSettings4.MicPhoneMuted, rtcParameterSettings4.CameraMuted, true, rtcParameterSettings4.EnableFixedResolution, rtcParameterSettings4.EnableRequiredResolutionAligment32, rtcParameterSettings4.EnableHighProfile, rtcParameterSettings4.AudioMaxkbps, rtcParameterSettings4.audioBitrateMode, rtcParameterSettings4.TransportAudioChannel, rtcParameterSettings4.EncodeBitrateMode, rtcParameterSettings4.EnableHisiH264HW, rtcParameterSettings4.EnableMTKH264Decode, rtcParameterSettings4.AudioSource, rtcParameterSettings4.AudioBufferPackets, rtcParameterSettings4.AudioPlayoutDelay, rtcParameterSettings4.AudioCodecComplex, false, mConfigAudioContenttype);
                this.peerConnectionClient = PeerConnectionClient.getInstance();
                if (this.mEnableAudioMix) {
                    if (this.mAudioFilter == null) {
                        this.mAudioFilter = new d();
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
                    this.peerConnectionClient.setHasAudioSend(this.mParamSettings.HasAudio);
                    this.peerConnectionClient.setHasAudioRecv(this.mParamSettings.HasAudio);
                    this.mWebSocketChannel.setHasVideo(this.mParamSettings.HasVideo);
                    this.peerConnectionClient.setHasVideoSend(this.mParamSettings.HasVideo);
                    this.peerConnectionClient.setHasVideoRecv(this.mParamSettings.HasVideo);
                    this.mWebSocketChannel.setHasData(this.mParamSettings.HasData);
                    this.peerConnectionClient.setHasDataSend(this.mParamSettings.HasData);
                    this.peerConnectionClient.setHasDataRecv(this.mParamSettings.HasData);
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
                Log.i("BRTC", "loginRtcRoomWithRoomName: this " + this + " version: " + BaiduRtcRoom.version());
                return true;
            } else {
                throw new InvalidParameterException("loginRtcRoomWithRoomName: Param Error,userId cann't be zero. zero is reserved.");
            }
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.baidu.rtc.JanusRTCInterface
    public void onConnectError() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
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
    }

    @Override // com.baidu.rtc.PeerConnectionClient.PeerConnectionEvents
    public void onIceFailed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
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
    }

    @Override // com.baidu.rtc.JanusRTCInterface
    public void onLoginError() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
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
    }

    @Override // com.baidu.rtc.JanusRTCInterface
    public void onLoginTimeout() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
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
    }

    @Override // com.baidu.rtc.JanusRTCInterface
    public void onLeaving(BigInteger bigInteger, BigInteger bigInteger2) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048618, this, bigInteger, bigInteger2) == null) {
            Log.i(TAG, "==================onLeaving=======================");
            this.mHandler.post(new Runnable(this, bigInteger2, this.mWebSocketChannel.getHandleByFeed(bigInteger2)) { // from class: com.baidu.rtc.internal.BaiduRtcRoomImp.13
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BaiduRtcRoomImp this$0;
                public final /* synthetic */ BigInteger val$feedId;
                public final /* synthetic */ JanusHandle val$janusHandle;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, bigInteger2, r8};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$feedId = bigInteger2;
                    this.val$janusHandle = r8;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.mRemoteStreamStats.remove(this.val$feedId);
                        JanusHandle janusHandle = this.val$janusHandle;
                        if (janusHandle != null) {
                            BigInteger bigInteger3 = janusHandle.handleId;
                            if (this.this$0.mHUDStatisticsMap.get(bigInteger3) != null) {
                                this.this$0.mHUDStatisticsMap.remove(bigInteger3);
                                if (this.this$0.peerConnectionClient != null) {
                                    this.this$0.peerConnectionClient.enableStatsEvents(false, 0, bigInteger3, PeerConnectionClient.StatsEventsType.GET_QUALITY_MONITOR_EVENT);
                                    this.this$0.peerConnectionClient.enableStatsEvents(false, 0, bigInteger3, PeerConnectionClient.StatsEventsType.GET_SLI_EVENT);
                                }
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
                if (rTCVideoExternalRender != null && janusConnectionByHandleID != null) {
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
                } else {
                    Log.d(TAG, "No external render has found!");
                }
            }
            if (janusConnectionByHandleID != null && (i = janusConnectionByHandleID.videoview_tag) >= 0) {
                boolean[] zArr = this.mHasVideoView;
                if (i < zArr.length) {
                    zArr[i] = false;
                    this.mRemoteVideoCnt--;
                    RTCVideoView[] rTCVideoViewArr = this.mRemoteRenderList;
                    if (rTCVideoViewArr[i] != null) {
                        rTCVideoViewArr[i].clearImage();
                        VideoTrack videoTrack2 = janusConnectionByHandleID.videoTrack;
                        if (videoTrack2 != null) {
                            videoTrack2.removeSink(this.mRemoteRenderList[i]);
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
    }

    @Override // com.baidu.rtc.JanusRTCInterface
    public void onPublisherJoined(BigInteger bigInteger) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, bigInteger) == null) {
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
            this.mHandler.post(new Runnable(this, bigInteger) { // from class: com.baidu.rtc.internal.BaiduRtcRoomImp.11
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BaiduRtcRoomImp this$0;
                public final /* synthetic */ BigInteger val$handleId;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, bigInteger};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$handleId = bigInteger;
                }

                @Override // java.lang.Runnable
                public void run() {
                    boolean z;
                    boolean z2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        BaiduRtcRoomImp baiduRtcRoomImp = this.this$0;
                        if ((baiduRtcRoomImp.mIsEnablePushQualityMonitor || baiduRtcRoomImp.mIsEnablePullQualityMonitor) && this.this$0.peerConnectionClient != null) {
                            if (this.this$0.mHUDStatisticsMap.get(this.val$handleId) != null) {
                                this.this$0.peerConnectionClient.enableStatsEvents(false, 0, this.val$handleId, PeerConnectionClient.StatsEventsType.GET_QUALITY_MONITOR_EVENT);
                                this.this$0.peerConnectionClient.enableStatsEvents(false, 0, this.val$handleId, PeerConnectionClient.StatsEventsType.GET_SLI_EVENT);
                                this.this$0.mHUDStatisticsMap.remove(this.val$handleId);
                            }
                            PeerConnectionClient peerConnectionClient = this.this$0.peerConnectionClient;
                            BaiduRtcRoomImp baiduRtcRoomImp2 = this.this$0;
                            if (!baiduRtcRoomImp2.mIsEnablePushQualityMonitor && !baiduRtcRoomImp2.mIsEnablePullQualityMonitor) {
                                z = false;
                            } else {
                                z = true;
                            }
                            peerConnectionClient.enableStatsEvents(z, 2000, this.val$handleId, PeerConnectionClient.StatsEventsType.GET_QUALITY_MONITOR_EVENT);
                            PeerConnectionClient peerConnectionClient2 = this.this$0.peerConnectionClient;
                            BaiduRtcRoomImp baiduRtcRoomImp3 = this.this$0;
                            if (!baiduRtcRoomImp3.mIsEnablePushQualityMonitor && !baiduRtcRoomImp3.mIsEnablePullQualityMonitor) {
                                z2 = false;
                            } else {
                                z2 = true;
                            }
                            peerConnectionClient2.enableStatsEvents(z2, 5000, this.val$handleId, PeerConnectionClient.StatsEventsType.GET_SLI_EVENT);
                            this.this$0.mHUDStatisticsMap.put(this.val$handleId, new HUDStatistics());
                            BaiduRtcRoomImp baiduRtcRoomImp4 = this.this$0;
                            if (baiduRtcRoomImp4.rtcLogReport != null && !baiduRtcRoomImp4.mbStartReportDI) {
                                baiduRtcRoomImp4.mbStartReportDI = true;
                                baiduRtcRoomImp4.mHandler.post(this.this$0.reportDeviceInfoRun);
                            }
                            BaiduRtcRoomImp baiduRtcRoomImp5 = this.this$0;
                            baiduRtcRoomImp5.reportRoomEventInfo("RTCROOM_LOGIN_OK_" + this.this$0.mUserId);
                        }
                        StreamStats streamStats = (StreamStats) this.this$0.mRemoteStreamStats.get(BigInteger.valueOf(this.this$0.mUserId));
                        if (streamStats != null) {
                            if (this.this$0.peerConnectionClient != null) {
                                this.this$0.peerConnectionClient.enableStatsEvents(false, 0, streamStats.handleId, PeerConnectionClient.StatsEventsType.GET_AUDIOLEVEL_EVENT);
                            }
                            streamStats.hasVideo = Boolean.valueOf(this.this$0.mParamSettings.HasVideo);
                            streamStats.hasAudio = Boolean.valueOf(this.this$0.mParamSettings.HasAudio);
                            streamStats.handleId = this.val$handleId;
                            streamStats.nickName = this.this$0.mDisplayName;
                        } else {
                            BigInteger bigInteger2 = this.val$handleId;
                            BaiduRtcRoomImp baiduRtcRoomImp6 = this.this$0;
                            this.this$0.mRemoteStreamStats.put(BigInteger.valueOf(this.this$0.mUserId), new StreamStats(bigInteger2, baiduRtcRoomImp6.mUserId, Boolean.valueOf(baiduRtcRoomImp6.mParamSettings.HasVideo), Boolean.valueOf(this.this$0.mParamSettings.HasAudio), this.this$0.mDisplayName));
                        }
                        if (this.this$0.peerConnectionClient != null) {
                            this.this$0.peerConnectionClient.enableStatsEvents(true, 200, this.val$handleId, PeerConnectionClient.StatsEventsType.GET_AUDIOLEVEL_EVENT);
                        }
                    }
                }
            });
        }
    }

    @Override // com.baidu.rtc.JanusRTCInterface
    public void onWebrtcUp(BigInteger bigInteger) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048648, this, bigInteger) == null) {
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
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void removeExternalRenderer(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048653, this, j) == null) {
            Log.d(TAG, j + " : Remove external renderer ...");
            if (!this.mUserIdVideoRendererMap.containsKey(Long.valueOf(j))) {
                Log.d(TAG, "External render not found to  remove surface for " + j);
                return;
            }
            RTCVideoExternalRender rTCVideoExternalRender = this.mUserIdVideoRendererMap.get(Long.valueOf(j));
            if (rTCVideoExternalRender != null) {
                rTCVideoExternalRender.release();
            }
            this.mUserIdVideoRendererMap.remove(Long.valueOf(j));
        }
    }

    public void updateBweStatistics(StatsReport[] statsReportArr) {
        StatsReport.Value[] valueArr;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048699, this, statsReportArr) != null) || this.mBaiduRtcRoomDelegate == null) {
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

    @Override // com.baidu.rtc.JanusRTCInterface
    public void onPublisherRemoteJsep(BigInteger bigInteger, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048632, this, bigInteger, jSONObject) == null) {
            SessionDescription.Type fromCanonicalForm = SessionDescription.Type.fromCanonicalForm(jSONObject.optString("type"));
            String optString = jSONObject.optString("sdp");
            if (this.mParamSettings.EnableHighProfile && this.isEnableHighProfileConfirm && optString.contains("profile-level-id=42e01f")) {
                optString = optString.replace("profile-level-id=42e01f", "profile-level-id=640c1f");
                Log.e(TAG, "enable high profile, remote jsep changed: " + optString);
            }
            this.peerConnectionClient.setRemoteDescription(bigInteger, new SessionDescription(fromCanonicalForm, optString));
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void setParamSettings(RtcParameterSettings rtcParameterSettings, RtcParameterSettings.RtcParamSettingType rtcParamSettingType) {
        Handler handler;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048671, this, rtcParameterSettings, rtcParamSettingType) == null) {
            int i = AnonymousClass24.$SwitchMap$com$baidu$rtc$RtcParameterSettings$RtcParamSettingType[rtcParamSettingType.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        this.mParamSettings.VideoRenderMode = rtcParameterSettings.VideoRenderMode;
                        return;
                    }
                    return;
                }
                this.mParamSettings.VideoMaxkbps = rtcParameterSettings.VideoMaxkbps;
                if (this.peerConnectionClient != null && (handler = this.mHandler) != null) {
                    handler.post(new Runnable(this) { // from class: com.baidu.rtc.internal.BaiduRtcRoomImp.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ BaiduRtcRoomImp this$0;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.this$0.peerConnectionClient != null && this.this$0.mParamSettings.VideoMaxkbps > 0) {
                                Log.d(BaiduRtcRoomImp.TAG, "Set video maximum bitrate: " + this.this$0.mParamSettings.VideoMaxkbps);
                                this.this$0.peerConnectionClient.setVideoMaxBitrate(Integer.valueOf(this.this$0.mParamSettings.VideoMaxkbps));
                            }
                        }
                    });
                }
            } else if (rtcParameterSettings != null) {
                this.mParamSettings = rtcParameterSettings;
                mConfigAudioContenttype = rtcParameterSettings.AudioContentType;
            }
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void setRemoteAudioPlayState(boolean z, long j) {
        StreamStats streamStats;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048674, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j)}) == null) && (streamStats = this.mRemoteStreamStats.get(BigInteger.valueOf(j))) != null && streamStats.hasAudio.booleanValue() != z) {
            streamStats.hasAudio = Boolean.valueOf(z);
            this.mWebSocketChannel.setRemoteStreamPlayState(streamStats.hasVideo, Boolean.valueOf(z), j);
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void setRemoteVideoPlayState(boolean z, long j) {
        StreamStats streamStats;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048679, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j)}) == null) && (streamStats = this.mRemoteStreamStats.get(BigInteger.valueOf(j))) != null && streamStats.hasVideo.booleanValue() != z) {
            streamStats.hasVideo = Boolean.valueOf(z);
            this.mWebSocketChannel.setRemoteStreamPlayState(Boolean.valueOf(z), streamStats.hasAudio, j);
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void subscribeStreaming(int i, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048694, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)}) != null) || this.mWebSocketChannel == null) {
            return;
        }
        if (i >= 0 && i < MAX_VIDEOVIEW_CNT && this.mRemoteRenderList != null) {
            this.mFeedToViewMap.put(BigInteger.valueOf(j), BigInteger.valueOf(i));
            this.mHasVideoView[i] = true;
        }
        this.mWebSocketChannel.subscriberCreateHandle(BigInteger.valueOf(j), "out");
    }

    @Override // com.baidu.rtc.PeerConnectionClient.PeerConnectionEvents
    public void onRemoteRender(JanusConnection janusConnection) {
        int i;
        RTCVideoView[] rTCVideoViewArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, janusConnection) == null) {
            Log.e(TAG, "=========onRemoteRender========" + janusConnection.videoTrack);
            BigInteger feedByHandle = this.mWebSocketChannel.getFeedByHandle(janusConnection.handleId);
            if (feedByHandle.longValue() == 0) {
                Log.e(TAG, "onRemoteRender Userid is 0.");
            } else if (this.mParamSettings.VideoRenderMode == RtcParameterSettings.RtcVideoRenderMode.RTC_VIDEO_RENDER_MODE_EXTERNAL) {
                RTCVideoExternalRender externalRender = getExternalRender(feedByHandle.longValue());
                Log.d(TAG, "enable external video render mode with videoRenderer -> " + externalRender);
                if (externalRender != null) {
                    janusConnection.videoTrack.addSink(externalRender);
                    externalRender.setStuckEventListener(new VideoStuckEvent(this, janusConnection.handleId));
                    externalRender.setEnableSLIDataReport(this.mIsEnablePullQualityMonitor);
                } else {
                    Log.d(TAG, "Not found external render for user " + feedByHandle);
                }
                onFfDelayChange(janusConnection, feedByHandle);
                this.mBaiduRtcRoomDelegate.onRoomEventUpdate(106, feedByHandle.longValue(), "");
            } else {
                Log.d(TAG, "it is internal video render mode");
                int i2 = -1;
                try {
                    i = this.mFeedToViewMap.get(this.mWebSocketChannel.getFeedByHandle(janusConnection.handleId)).intValue();
                } catch (Exception unused) {
                    i = -1;
                }
                if (i >= 0 && i < MAX_VIDEOVIEW_CNT && (rTCVideoViewArr = this.mRemoteRenderList) != null) {
                    if (rTCVideoViewArr[i] != null) {
                        rTCVideoViewArr[i].setFirstFrameEventListener(new Runnable(this, feedByHandle, janusConnection) { // from class: com.baidu.rtc.internal.BaiduRtcRoomImp.17
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ BaiduRtcRoomImp this$0;
                            public final /* synthetic */ JanusConnection val$connection;
                            public final /* synthetic */ BigInteger val$userId;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, feedByHandle, janusConnection};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i3 = newInitContext.flag;
                                    if ((i3 & 1) != 0) {
                                        int i4 = i3 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$0 = this;
                                this.val$userId = feedByHandle;
                                this.val$connection = janusConnection;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    BaiduRtcRoom.BaiduRtcRoomDelegate baiduRtcRoomDelegate = this.this$0.mBaiduRtcRoomDelegate;
                                    if (baiduRtcRoomDelegate != null) {
                                        baiduRtcRoomDelegate.onRoomEventUpdate(106, this.val$userId.longValue(), "");
                                    }
                                    this.this$0.onFfDelayChange(this.val$connection, this.val$userId);
                                }
                            }
                        });
                        this.mRemoteRenderList[i].setStuckEventListener(new VideoStuckEvent(this, janusConnection.handleId));
                        this.mRemoteRenderList[i].setEnableSLIDataReport(this.mIsEnablePullQualityMonitor);
                        janusConnection.videoTrack.addSink(this.mRemoteRenderList[i]);
                    }
                    janusConnection.videoview_tag = i;
                } else if (this.mRemoteRenderList != null) {
                    int i3 = 0;
                    while (true) {
                        boolean[] zArr = this.mHasVideoView;
                        if (i3 >= zArr.length) {
                            break;
                        } else if (!zArr[i3]) {
                            zArr[i3] = true;
                            i2 = i3;
                            break;
                        } else {
                            i3++;
                        }
                    }
                    if (i2 >= 0) {
                        RTCVideoView[] rTCVideoViewArr2 = this.mRemoteRenderList;
                        if (rTCVideoViewArr2[i2] != null) {
                            rTCVideoViewArr2[i2].setFirstFrameEventListener(new Runnable(this, feedByHandle, janusConnection) { // from class: com.baidu.rtc.internal.BaiduRtcRoomImp.18
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ BaiduRtcRoomImp this$0;
                                public final /* synthetic */ JanusConnection val$connection;
                                public final /* synthetic */ BigInteger val$userId;

                                {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, feedByHandle, janusConnection};
                                        interceptable2.invokeUnInit(65536, newInitContext);
                                        int i4 = newInitContext.flag;
                                        if ((i4 & 1) != 0) {
                                            int i5 = i4 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable2.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.this$0 = this;
                                    this.val$userId = feedByHandle;
                                    this.val$connection = janusConnection;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                        BaiduRtcRoom.BaiduRtcRoomDelegate baiduRtcRoomDelegate = this.this$0.mBaiduRtcRoomDelegate;
                                        if (baiduRtcRoomDelegate != null) {
                                            baiduRtcRoomDelegate.onRoomEventUpdate(106, this.val$userId.longValue(), "");
                                        }
                                        this.this$0.onFfDelayChange(this.val$connection, this.val$userId);
                                    }
                                }
                            });
                            this.mRemoteRenderList[i2].setStuckEventListener(new VideoStuckEvent(this, janusConnection.handleId));
                            this.mRemoteRenderList[i2].setEnableSLIDataReport(this.mIsEnablePullQualityMonitor);
                            janusConnection.videoTrack.addSink(this.mRemoteRenderList[i2]);
                        }
                        janusConnection.videoview_tag = i2;
                    }
                    this.mRemoteVideoCnt++;
                }
            }
        }
    }

    @Override // com.baidu.rtc.JanusRTCInterface
    public void onSlowLink(boolean z, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048642, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) != null) || this.mBaiduRtcRoomDelegate == null) {
            return;
        }
        if (i < 10) {
            i2 = 2100;
        } else if (i < 15) {
            i2 = 2101;
        } else if (i < 25) {
            i2 = 2102;
        } else if (i < 40) {
            i2 = 2103;
        } else if (i < 60) {
            i2 = 2104;
        } else if (i < 90) {
            i2 = 2105;
        } else if (i < 120) {
            i2 = 2106;
        } else if (i < 180) {
            i2 = 2107;
        } else if (i < 250) {
            i2 = 2108;
        } else {
            i2 = 2109;
        }
        this.mBaiduRtcRoomDelegate.onPeerConnectStateUpdate(i2);
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void setExternalSurface(long j, Surface surface) {
        RTCVideoExternalRender externalRender;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJL(1048663, this, j, surface) == null) && (externalRender = getExternalRender(j)) != null) {
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
    public boolean startLiveServerStreaming(String str, boolean z, boolean z2, String str2, BaiduRtcRoom.RtcLiveTransferMode rtcLiveTransferMode) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048687, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2), str2, rtcLiveTransferMode})) == null) {
            this.mWebSocketChannel.startPublishLiveStream(str, z, z2, str2, rtcLiveTransferMode);
            return true;
        }
        return invokeCommon.booleanValue;
    }
}
