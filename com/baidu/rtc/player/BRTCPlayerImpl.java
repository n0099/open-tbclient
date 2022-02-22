package com.baidu.rtc.player;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.rtc.JanusConnection;
import com.baidu.rtc.PeerConnectionClient;
import com.baidu.rtc.RTCAudioSamples;
import com.baidu.rtc.RTCCommStatesReport;
import com.baidu.rtc.RTCLoadManager;
import com.baidu.rtc.RTCVideoView;
import com.baidu.rtc.RemoteAudioSamplesInterceptor;
import com.baidu.rtc.RtcParameterSettings;
import com.baidu.rtc.config.Constraints;
import com.baidu.rtc.logreport.HUDStatistics;
import com.baidu.rtc.logreport.RtcReportHandle;
import com.baidu.rtc.player.AsyncHttpRequest;
import com.baidu.rtc.player.BRTCPlayer;
import com.baidu.rtc.player.PlayTimeStatistician;
import com.baidu.rtc.record.MediaEncodeParams;
import com.baidu.rtc.record.RTCMediaRecorderImpl;
import com.baidu.rtc.record.RecorderCallback;
import com.baidu.rtc.signalling.play.RemoteSdpRequest;
import com.baidu.rtc.signalling.play.RemoteSdpResponse;
import com.baidu.rtc.snapshot.SnapShotCallback;
import com.baidu.rtc.snapshot.SnapShotHelper;
import com.baidu.rtc.utils.CommonUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import h.c.i0;
import java.lang.ref.WeakReference;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.Objects;
import org.webrtc.AudioTrack;
import org.webrtc.EglBase;
import org.webrtc.IceCandidate;
import org.webrtc.Logging;
import org.webrtc.RendererCommon;
import org.webrtc.SessionDescription;
import org.webrtc.StatsReport;
import org.webrtc.VideoTrack;
import org.webrtc.audio.JavaAudioDeviceModule;
/* loaded from: classes11.dex */
public class BRTCPlayerImpl implements BRTCPlayer, PeerConnectionClient.PeerConnectionEvents {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_AUDIO_BUFFER_MAINTAINABLE_MS = 50;
    public static final int DEFAULT_AUDIO_BUFFER_UNDER_LOAD_MS = 20;
    public static final int DEFAULT_BUFFERING_DETECT_MS = 200;
    public static final int DEFAULT_BUFFERING_DETECT_PERIOD = 1;
    public static final int DEFAULT_STATS_REPORT_PERIOD = 5;
    public static final int DEFAULT_STREAMING_INTERRUPT_PERIOD = 30;
    public static final String STREAM_URL_PREFIX = "webrtc://";
    public static final String TAG = "BRTCPlayer";
    public transient /* synthetic */ FieldHolder $fh;
    public String mAppId;
    public int mAudioBufferMaintainableLevel;
    public int mAudioBufferUnderLoadLevel;
    public AudioTrack mAudioTrack;
    public volatile int mBufferingDetectCount;
    public int mBufferingDetectPeriod;
    public final Context mContext;
    public volatile BRTCPlayer.PlayerState mCurrentState;
    public RtcParameterSettings mDefaultSettings;
    public boolean mEnablePullQualityMonitor;
    public BRTCPlayerEvents mEventObserver;
    public Handler mHandler;
    public volatile boolean mIsBuffing;
    public boolean mIsEnableErrorInfoMonitor;
    public boolean mIsLibraryLoading;
    public RTCLoadManager.LoadListener mLoadListener;
    public long mLocalUserId;
    public BigInteger mPlayTransactionId;
    public BRTCPlayerParameters mPlayerParameters;
    public String mPullUrl;
    public String mRemoteHandleId;
    public RemoteAudioSamplesInterceptor mRemoteSamplesInterceptor;
    public JavaAudioDeviceModule.RemoteSamplesReadyCallback mRemoteSamplesInternalCallback;
    public RTCMediaRecorderImpl mRemoteVideoRecorder;
    public RTCVideoView mRenderView;
    public RendererCommon.RendererEvents mRendererEvents;
    public RtcReportHandle mReportHandler;
    public String mRoomId;
    public EglBase mRootEglBase;
    public volatile int mStatsReportCount;
    public int mStatsReportPeriod;
    public String mStreamUrl;
    public int mStreamingInterruptDetectPeriod;
    public volatile int mStreamingValidityDetectCount;
    public PlayTimeStatistician mTimeStatistician;
    public String mUserId;
    public VideoTrack mVideoTrack;
    public volatile PeerConnectionClient peerConnectionClient;
    public PeerConnectionClient.PeerConnectionParameters peerConnectionParameters;

    public BRTCPlayerImpl(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mStreamingInterruptDetectPeriod = 30;
        this.mStatsReportPeriod = 5;
        this.mBufferingDetectPeriod = 5;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.peerConnectionClient = null;
        this.peerConnectionParameters = null;
        this.mDefaultSettings = new RtcParameterSettings();
        this.mPlayTransactionId = null;
        this.mCurrentState = BRTCPlayer.PlayerState.STATE_IDLE;
        this.mLocalUserId = -1L;
        this.mIsBuffing = false;
        this.mAudioBufferUnderLoadLevel = 20;
        this.mAudioBufferMaintainableLevel = 50;
        this.mIsLibraryLoading = false;
        this.mIsEnableErrorInfoMonitor = true;
        this.mEnablePullQualityMonitor = true;
        this.mRendererEvents = new RendererCommon.RendererEvents(this) { // from class: com.baidu.rtc.player.BRTCPlayerImpl.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ BRTCPlayerImpl this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // org.webrtc.RendererCommon.RendererEvents
            public void onFirstFrameRendered() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.this$0.mTimeStatistician.updateStepTime(PlayTimeStatistician.PlayStep.PLAY_FIRST_FRAME_RENDERED);
                    if (this.this$0.mEventObserver != null) {
                        this.this$0.mEventObserver.onInfoUpdated(1008, this.this$0.mTimeStatistician);
                        this.this$0.mEventObserver.onFirstFrameRendered();
                    }
                    this.this$0.mReportHandler.onFfDelayChange(this.this$0.mPlayTransactionId);
                    Logging.d(BRTCPlayerImpl.TAG, "first frame rendered time statistic :" + this.this$0.mTimeStatistician.toString());
                }
            }

            @Override // org.webrtc.RendererCommon.RendererEvents
            public void onFrameResolutionChanged(int i4, int i5, int i6) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i4, i5, i6) == null) || this.this$0.mEventObserver == null) {
                    return;
                }
                this.this$0.mEventObserver.onResolutionChanged(i4, i5);
            }
        };
        this.mLoadListener = new RTCLoadManager.LoadListener(this) { // from class: com.baidu.rtc.player.BRTCPlayerImpl.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ BRTCPlayerImpl this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.baidu.rtc.RTCLoadManager.LoadListener
            public void onLoadError(int i4, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i4, str) == null) {
                    BRTCPlayerImpl bRTCPlayerImpl = this.this$0;
                    bRTCPlayerImpl.reportError(10010, i4 + " / " + str);
                }
            }

            @Override // com.baidu.rtc.RTCLoadManager.LoadListener
            public void onLoadProgress(float f2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2) == null) {
                    Logging.d(BRTCPlayerImpl.TAG, "loaded so progress " + f2);
                }
            }

            @Override // com.baidu.rtc.RTCLoadManager.LoadListener
            public void onLoadSuccess() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    Logging.d(BRTCPlayerImpl.TAG, "after libs loaded, replay.");
                    this.this$0.mTimeStatistician.updateStepTime(PlayTimeStatistician.PlayStep.PLAY_LIBRARY_LOADED);
                    if (this.this$0.getPlayerState() != BRTCPlayer.PlayerState.STATE_IDLE) {
                        BRTCPlayerImpl bRTCPlayerImpl = this.this$0;
                        bRTCPlayerImpl.initPlayer(bRTCPlayerImpl.mPlayerParameters, this.this$0.mEventObserver);
                        this.this$0.startPlay();
                    }
                }
            }
        };
        this.mRemoteSamplesInternalCallback = new JavaAudioDeviceModule.RemoteSamplesReadyCallback(this) { // from class: com.baidu.rtc.player.BRTCPlayerImpl.7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ BRTCPlayerImpl this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
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
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, audioSamples) == null) || audioSamples == null || this.this$0.mRemoteSamplesInterceptor == null) {
                    return;
                }
                this.this$0.mRemoteSamplesInterceptor.onRtcAudioRemoteSamplesReady(new RTCAudioSamples(audioSamples.getAudioFormat(), audioSamples.getChannelCount(), audioSamples.getSampleRate(), audioSamples.getData()));
            }
        };
        this.mContext = context.getApplicationContext();
        this.mLocalUserId = Long.valueOf(CommonUtils.randomNumber(10)).longValue();
        this.mRootEglBase = i0.a();
        this.mReportHandler = RtcReportHandle.getInstance(this.mContext);
        RtcReportHandle.enableMonitor(true, this.mEnablePullQualityMonitor, this.mIsEnableErrorInfoMonitor, false);
        this.mTimeStatistician = new PlayTimeStatistician();
    }

    private void closePeer(BigInteger bigInteger) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65557, this, bigInteger) == null) || bigInteger == null) {
            return;
        }
        this.mHandler.post(new Runnable(this, bigInteger) { // from class: com.baidu.rtc.player.BRTCPlayerImpl.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ BRTCPlayerImpl this$0;
            public final /* synthetic */ BigInteger val$handleId;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, bigInteger};
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
                this.val$handleId = bigInteger;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.this$0.peerConnectionClient == null) {
                    return;
                }
                this.this$0.peerConnectionClient.closePeer(this.val$handleId);
            }
        });
    }

    private BigInteger createPlayerHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65558, this)) == null) ? BigInteger.valueOf(Long.valueOf(CommonUtils.randomNumber(14)).longValue()) : (BigInteger) invokeV.objValue;
    }

    private boolean isCanPlayState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65559, this)) == null) ? (this.mCurrentState == BRTCPlayer.PlayerState.STATE_IDLE || this.mCurrentState == BRTCPlayer.PlayerState.STATE_PLAYING || this.mCurrentState == BRTCPlayer.PlayerState.STATE_PREPARED) ? false : true : invokeV.booleanValue;
    }

    private void offerPeerConnection(BigInteger bigInteger) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65560, this, bigInteger) == null) {
            this.mHandler.post(new Runnable(this, bigInteger) { // from class: com.baidu.rtc.player.BRTCPlayerImpl.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BRTCPlayerImpl this$0;
                public final /* synthetic */ BigInteger val$handleId;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, bigInteger};
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
                    this.val$handleId = bigInteger;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.this$0.peerConnectionClient == null) {
                        return;
                    }
                    this.this$0.peerConnectionClient.createPeerConnection(this.this$0.mRootEglBase.getEglBaseContext(), null, null, this.val$handleId);
                    this.this$0.peerConnectionClient.createOffer(this.val$handleId);
                }
            });
        }
    }

    private void prepareSdp(long j2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(65561, this, j2, str) == null) {
            RemoteSdpRequest remoteSdpRequest = new RemoteSdpRequest(str, j2, this.mStreamUrl);
            Logging.d(TAG, "Connecting to signaling server: " + this.mPullUrl + "\n offer sdp:" + str);
            AsyncHttpRequest asyncHttpRequest = new AsyncHttpRequest("POST", this.mPullUrl, remoteSdpRequest.toJSONString(), "application/json", new AsyncHttpRequest.AsyncHttpEvents(this) { // from class: com.baidu.rtc.player.BRTCPlayerImpl.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BRTCPlayerImpl this$0;

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

                @Override // com.baidu.rtc.player.AsyncHttpRequest.AsyncHttpEvents
                public void onHttpComplete(String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, str2) == null) {
                        this.this$0.mTimeStatistician.updateStepTime(PlayTimeStatistician.PlayStep.PLAY_REMOTE_SDP_ACQUIRED);
                        if (this.this$0.mCurrentState != BRTCPlayer.PlayerState.STATE_PREPARING) {
                            Logging.e(BRTCPlayerImpl.TAG, "Set remote sdp in invalid state: " + this.this$0.mCurrentState);
                            BRTCPlayerImpl bRTCPlayerImpl = this.this$0;
                            bRTCPlayerImpl.reportError(10007, "Set remote sdp in invalid state: " + this.this$0.mCurrentState);
                            return;
                        }
                        RemoteSdpResponse newFromJsonStr = RemoteSdpResponse.newFromJsonStr(str2);
                        String sdp = newFromJsonStr.getSdp();
                        this.this$0.mRemoteHandleId = newFromJsonStr.getRemoteHandleId();
                        String sessionId = newFromJsonStr.getSessionId();
                        this.this$0.mAppId = newFromJsonStr.getAppId();
                        this.this$0.mRoomId = newFromJsonStr.getRoomId();
                        newFromJsonStr.getRoomName();
                        this.this$0.mUserId = newFromJsonStr.getUserId();
                        if (this.this$0.mLocalUserId > 0) {
                            BRTCPlayerImpl bRTCPlayerImpl2 = this.this$0;
                            bRTCPlayerImpl2.mUserId = String.valueOf(bRTCPlayerImpl2.mLocalUserId);
                        }
                        String feed = newFromJsonStr.getFeed();
                        Logging.d(BRTCPlayerImpl.TAG, "play response from signaling server: " + str2);
                        if (sdp == null || sdp.length() <= 0) {
                            this.this$0.reportError(10007, "remote sdp parsing error.");
                            return;
                        }
                        Logging.d(BRTCPlayerImpl.TAG, "obtain answer sdp : " + sdp);
                        this.this$0.setRemoteSdp(sdp);
                        this.this$0.mReportHandler.updateRoomInfo(this.this$0.mAppId, this.this$0.mRoomId, this.this$0.mUserId, feed, this.this$0.mRemoteHandleId, sessionId);
                        if (!TextUtils.isEmpty(this.this$0.mRemoteHandleId)) {
                            RtcReportHandle rtcReportHandle = this.this$0.mReportHandler;
                            BRTCPlayerImpl bRTCPlayerImpl3 = this.this$0;
                            rtcReportHandle.startPeerPullReport(bRTCPlayerImpl3.mPlayTransactionId, bRTCPlayerImpl3.peerConnectionClient);
                            this.this$0.mReportHandler.startDeviceInfoReport();
                        }
                        this.this$0.setCurrentState(BRTCPlayer.PlayerState.STATE_PREPARED);
                    }
                }

                @Override // com.baidu.rtc.player.AsyncHttpRequest.AsyncHttpEvents
                public void onHttpError(String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str2) == null) {
                        Logging.e(BRTCPlayerImpl.TAG, "connection error: " + str2);
                        this.this$0.reportError(10006, str2);
                    }
                }
            });
            if (this.mCurrentState == BRTCPlayer.PlayerState.STATE_PREPARING) {
                asyncHttpRequest.request();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportError(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65562, this, i2, str) == null) {
            this.mTimeStatistician.updateStepTime(PlayTimeStatistician.PlayStep.PLAY_ERROR);
            Logging.d(TAG, "report error: " + str + " time statistic:" + this.mTimeStatistician.toString());
            if (getPlayerState() != BRTCPlayer.PlayerState.STATE_ERROR && getPlayerState() != BRTCPlayer.PlayerState.STATE_IDLE) {
                BRTCPlayerEvents bRTCPlayerEvents = this.mEventObserver;
                if (bRTCPlayerEvents != null) {
                    bRTCPlayerEvents.onInfoUpdated(1008, this.mTimeStatistician);
                    this.mEventObserver.onError(i2, str);
                }
                if (this.mIsEnableErrorInfoMonitor) {
                    this.mReportHandler.reportError(i2, str);
                }
                setCurrentState(BRTCPlayer.PlayerState.STATE_ERROR);
                return;
            }
            Logging.d(TAG, "Is current state " + getPlayerState() + " skip error report.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurrentState(BRTCPlayer.PlayerState playerState) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65563, this, playerState) == null) || this.mCurrentState == playerState) {
            return;
        }
        this.mCurrentState = playerState;
        BRTCPlayerEvents bRTCPlayerEvents = this.mEventObserver;
        if (bRTCPlayerEvents != null) {
            bRTCPlayerEvents.onPlayerStateChanged(this.mCurrentState);
        }
    }

    public static String version() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65564, null)) == null) ? Constraints.version() : (String) invokeV.objValue;
    }

    @Override // com.baidu.rtc.player.BRTCPlayer
    public BRTCPlayer.PlayerState getPlayerState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mCurrentState : (BRTCPlayer.PlayerState) invokeV.objValue;
    }

    @Override // com.baidu.rtc.player.BRTCPlayer
    public boolean hasAudio() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mAudioTrack != null : invokeV.booleanValue;
    }

    @Override // com.baidu.rtc.player.BRTCPlayer
    public boolean hasVideo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mVideoTrack != null : invokeV.booleanValue;
    }

    public boolean initPeerConnectionClient() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.peerConnectionClient != null) {
                this.peerConnectionClient.close();
                this.peerConnectionClient = null;
            }
            this.peerConnectionClient = PeerConnectionClient.getInstance();
            this.peerConnectionClient.setHasAudioSend(false);
            this.peerConnectionClient.setHasVideoSend(false);
            this.peerConnectionClient.setHasDataSend(false);
            this.peerConnectionClient.setHasAudioRecv(true);
            this.peerConnectionClient.setHasVideoRecv(true);
            this.peerConnectionClient.setHasDataRecv(true);
            if (this.mPlayerParameters != null) {
                this.peerConnectionClient.setEnableDebugLog(this.mPlayerParameters.getEnableDebug());
            }
            this.mRemoteSamplesInterceptor = new RemoteAudioSamplesInterceptor();
            WeakReference weakReference = new WeakReference(this.mContext);
            RtcParameterSettings rtcParameterSettings = this.mDefaultSettings;
            int i2 = rtcParameterSettings.VideoFps;
            String upperCase = rtcParameterSettings.VideoCodec.toUpperCase();
            RtcParameterSettings rtcParameterSettings2 = this.mDefaultSettings;
            this.peerConnectionParameters = new PeerConnectionClient.PeerConnectionParameters(false, -1, -1, i2, upperCase, true, 0, "", false, false, rtcParameterSettings2.DisableBuiltInAEC, true, true, rtcParameterSettings2.VideoMaxkbps, rtcParameterSettings2.VideoMinkbps, rtcParameterSettings2.MicPhoneMuted, rtcParameterSettings2.CameraMuted, true, rtcParameterSettings2.EnableFixedResolution, rtcParameterSettings2.EnableRequiredResolutionAligment32, rtcParameterSettings2.EnableHighProfile, rtcParameterSettings2.AudioMaxkbps, rtcParameterSettings2.audioBitrateMode, rtcParameterSettings2.TransportAudioChannel, rtcParameterSettings2.EncodeBitrateMode, rtcParameterSettings2.EnableHisiH264HW, rtcParameterSettings2.EnableMTKH264Decode, 0, rtcParameterSettings2.AudioBufferPackets, rtcParameterSettings2.AudioPlayoutDelay, rtcParameterSettings2.AudioCodecComplex, true, 2);
            this.peerConnectionClient.createPeerConnectionFactory((Context) weakReference.get(), this.peerConnectionParameters, this);
            PeerConnectionClient peerConnectionClient = this.peerConnectionClient;
            RtcReportHandle rtcReportHandle = this.mReportHandler;
            Objects.requireNonNull(rtcReportHandle);
            peerConnectionClient.setStuckEventListener(new RtcReportHandle.AudioStuckEvent(rtcReportHandle));
            this.peerConnectionClient.setEnableSLIReport(this.mEnablePullQualityMonitor);
            String str = "Rtc Sdk Version  " + Constraints.sdkVersion();
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.rtc.player.BRTCPlayer
    public long initPlayer(@NonNull BRTCPlayerParameters bRTCPlayerParameters, @NonNull BRTCPlayerEvents bRTCPlayerEvents) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, bRTCPlayerParameters, bRTCPlayerEvents)) == null) {
            this.mEventObserver = bRTCPlayerEvents;
            this.mPlayerParameters = bRTCPlayerParameters;
            this.mPullUrl = bRTCPlayerParameters.getPullUrl();
            if (this.mPlayerParameters.getUserId() > 0) {
                this.mLocalUserId = this.mPlayerParameters.getUserId();
            }
            this.mReportHandler.setUserId(this.mLocalUserId);
            int streamingInterruptDetectInterval = this.mPlayerParameters.getStreamingInterruptDetectInterval() / 200;
            this.mStreamingInterruptDetectPeriod = streamingInterruptDetectInterval;
            if (streamingInterruptDetectInterval <= 0) {
                this.mStreamingInterruptDetectPeriod = 30;
            }
            int statsReportIntervalMs = this.mPlayerParameters.getStatsReportIntervalMs() / 200;
            this.mStatsReportPeriod = statsReportIntervalMs;
            if (statsReportIntervalMs <= 0) {
                this.mStatsReportPeriod = 5;
            }
            int bufferingDetectIntervalMs = this.mPlayerParameters.getBufferingDetectIntervalMs() / 200;
            this.mBufferingDetectPeriod = bufferingDetectIntervalMs;
            if (bufferingDetectIntervalMs <= 0) {
                this.mBufferingDetectPeriod = 1;
            }
            int audioBufferUnderLoadLevel = this.mPlayerParameters.getAudioBufferUnderLoadLevel();
            this.mAudioBufferUnderLoadLevel = audioBufferUnderLoadLevel;
            if (audioBufferUnderLoadLevel < 0) {
                this.mAudioBufferUnderLoadLevel = 20;
            }
            int audioBufferMaintainableLevel = this.mPlayerParameters.getAudioBufferMaintainableLevel();
            this.mAudioBufferMaintainableLevel = audioBufferMaintainableLevel;
            if (audioBufferMaintainableLevel < 0) {
                this.mAudioBufferMaintainableLevel = 50;
            }
            this.mIsBuffing = false;
            initPeerConnectionClient();
            setCurrentState(BRTCPlayer.PlayerState.STATE_INITIALIZED);
            return this.mLocalUserId;
        }
        return invokeLL.longValue;
    }

    @Override // com.baidu.rtc.PeerConnectionClient.PeerConnectionEvents
    public void onIceCandidate(IceCandidate iceCandidate, BigInteger bigInteger) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, iceCandidate, bigInteger) == null) {
        }
    }

    @Override // com.baidu.rtc.PeerConnectionClient.PeerConnectionEvents
    public void onIceCandidatesRemoved(IceCandidate[] iceCandidateArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, iceCandidateArr) == null) {
        }
    }

    @Override // com.baidu.rtc.PeerConnectionClient.PeerConnectionEvents
    public void onIceConnected() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.mTimeStatistician.updateStepTime(PlayTimeStatistician.PlayStep.PLAY_ICE_CONNECTED);
            BRTCPlayerEvents bRTCPlayerEvents = this.mEventObserver;
            if (bRTCPlayerEvents != null) {
                bRTCPlayerEvents.onInfoUpdated(1001, "ice connected");
            }
            Logging.d(TAG, "ice connected.");
        }
    }

    @Override // com.baidu.rtc.PeerConnectionClient.PeerConnectionEvents
    public void onIceDisconnected() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            BRTCPlayerEvents bRTCPlayerEvents = this.mEventObserver;
            if (bRTCPlayerEvents != null) {
                bRTCPlayerEvents.onInfoUpdated(1006, "ice disconnected");
            }
            Logging.d(TAG, "ice disconnected.");
        }
    }

    @Override // com.baidu.rtc.PeerConnectionClient.PeerConnectionEvents
    public void onIceFailed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            reportError(10001, "Ice negotiate failed");
        }
    }

    @Override // com.baidu.rtc.PeerConnectionClient.PeerConnectionEvents
    public void onLocalDescription(SessionDescription sessionDescription, BigInteger bigInteger, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048586, this, sessionDescription, bigInteger, z) == null) {
            this.mTimeStatistician.updateStepTime(PlayTimeStatistician.PlayStep.PLAY_LOCAL_SDP_SET);
            Logging.d(TAG, bigInteger + " :" + sessionDescription.type.toString() + " is \n " + sessionDescription.description);
            BRTCPlayerEvents bRTCPlayerEvents = this.mEventObserver;
            if (bRTCPlayerEvents != null) {
                bRTCPlayerEvents.onInfoUpdated(1009, "local sdp has set.");
            }
            prepareSdp(bigInteger.longValue(), sessionDescription.description);
        }
    }

    @Override // com.baidu.rtc.PeerConnectionClient.PeerConnectionEvents
    public void onPeerClosed(BigInteger bigInteger) {
        RtcReportHandle rtcReportHandle;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, bigInteger) == null) || (rtcReportHandle = this.mReportHandler) == null || bigInteger == null) {
            return;
        }
        rtcReportHandle.stopPeerReport(bigInteger, this.peerConnectionClient);
    }

    @Override // com.baidu.rtc.PeerConnectionClient.PeerConnectionEvents
    public void onPeerConnectionClosed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            BRTCPlayerEvents bRTCPlayerEvents = this.mEventObserver;
            if (bRTCPlayerEvents != null) {
                bRTCPlayerEvents.onInfoUpdated(1002, "peer connection closed");
            }
            Logging.d(TAG, "peer connection closed.");
        }
    }

    @Override // com.baidu.rtc.PeerConnectionClient.PeerConnectionEvents
    public void onPeerConnectionError(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            reportError(10003, str);
        }
    }

    @Override // com.baidu.rtc.PeerConnectionClient.PeerConnectionEvents
    public void onPeerConnectionStatsReady(StatsReport[] statsReportArr, BigInteger bigInteger, PeerConnectionClient.StatsEventsType statsEventsType) {
        RtcReportHandle rtcReportHandle;
        HUDStatistics updateStatsData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048590, this, statsReportArr, bigInteger, statsEventsType) == null) || (rtcReportHandle = this.mReportHandler) == null || bigInteger == null || (updateStatsData = rtcReportHandle.updateStatsData(statsReportArr, bigInteger)) == null) {
            return;
        }
        if (statsEventsType == PeerConnectionClient.StatsEventsType.GET_AUDIOLEVEL_EVENT) {
            if (this.mEventObserver != null) {
                int i2 = updateStatsData.mAudioJitterBufferMs;
                if (i2 < this.mAudioBufferUnderLoadLevel) {
                    this.mBufferingDetectCount++;
                    if (this.mBufferingDetectCount >= this.mBufferingDetectPeriod && !this.mIsBuffing) {
                        this.mIsBuffing = true;
                        this.mBufferingDetectCount = 0;
                        this.mEventObserver.onInfoUpdated(1004, "Buffering start with buffer capacity " + i2);
                    } else {
                        Logging.d(TAG, "Audio jitter buffer underflow " + i2 + " ms times " + this.mBufferingDetectCount);
                    }
                } else if (i2 > this.mAudioBufferMaintainableLevel) {
                    if (this.mIsBuffing) {
                        this.mIsBuffing = false;
                        this.mEventObserver.onInfoUpdated(1005, "Buffering end with buffer capacity " + i2);
                    }
                    this.mBufferingDetectCount = 0;
                }
                int i3 = this.mStatsReportCount + 1;
                this.mStatsReportCount = i3;
                if (i3 >= this.mStatsReportPeriod) {
                    RTCCommStatesReport rTCCommStatesReport = new RTCCommStatesReport(this.mPlayTransactionId, this.mRoomId, this.mUserId, this.mRemoteHandleId, updateStatsData);
                    rTCCommStatesReport.setDebugFlag(19);
                    this.mEventObserver.onInfoUpdated(1003, rTCCommStatesReport);
                    this.mStatsReportCount = 0;
                }
            }
            if (!this.mReportHandler.streamingValidityDetect(bigInteger)) {
                BRTCPlayerEvents bRTCPlayerEvents = this.mEventObserver;
                if (bRTCPlayerEvents != null) {
                    bRTCPlayerEvents.onInfoUpdated(1007, "No streaming detected count " + this.mStreamingValidityDetectCount);
                }
                int i4 = this.mStreamingValidityDetectCount + 1;
                this.mStreamingValidityDetectCount = i4;
                if (i4 != this.mStreamingInterruptDetectPeriod || getPlayerState() == BRTCPlayer.PlayerState.STATE_ERROR || getPlayerState() == BRTCPlayer.PlayerState.STATE_STOP) {
                    return;
                }
                Logging.d(TAG, "streaming interrupt error appeared!");
                stopPlay();
                reportError(10009, "streaming interrupted.");
                this.mStreamingValidityDetectCount = 0;
                return;
            }
            this.mStreamingValidityDetectCount = 0;
        } else if (statsEventsType == PeerConnectionClient.StatsEventsType.GET_SLI_EVENT || statsEventsType == PeerConnectionClient.StatsEventsType.GET_QUALITY_MONITOR_EVENT) {
            this.mReportHandler.onPeerStatisticsReport(statsEventsType);
        }
    }

    @Override // com.baidu.rtc.PeerConnectionClient.PeerConnectionEvents
    public void onRemoteData(ByteBuffer byteBuffer) {
        BRTCPlayerEvents bRTCPlayerEvents;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, byteBuffer) == null) || (bRTCPlayerEvents = this.mEventObserver) == null) {
            return;
        }
        bRTCPlayerEvents.onRemoteData(byteBuffer);
    }

    @Override // com.baidu.rtc.PeerConnectionClient.PeerConnectionEvents
    public void onRemoteDescription(SessionDescription sessionDescription, BigInteger bigInteger) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, sessionDescription, bigInteger) == null) {
            Logging.d(TAG, bigInteger + " :" + sessionDescription.type.toString() + " is \n" + sessionDescription.description);
            BRTCPlayerEvents bRTCPlayerEvents = this.mEventObserver;
            if (bRTCPlayerEvents != null) {
                bRTCPlayerEvents.onInfoUpdated(1010, "remote sdp has set.");
            }
        }
    }

    @Override // com.baidu.rtc.PeerConnectionClient.PeerConnectionEvents
    public void onRemoteRender(JanusConnection janusConnection) {
        RTCVideoView rTCVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, janusConnection) == null) || janusConnection == null) {
            return;
        }
        this.mTimeStatistician.updateStepTime(PlayTimeStatistician.PlayStep.PLAY_ADD_STREAM);
        VideoTrack videoTrack = janusConnection.videoTrack;
        if (videoTrack != null && (rTCVideoView = this.mRenderView) != null) {
            videoTrack.addSink(rTCVideoView);
            if (this.mVideoTrack != null) {
                this.mRenderView.setVideoTrackChanged(true);
            }
            this.mVideoTrack = janusConnection.videoTrack;
            RTCVideoView rTCVideoView2 = this.mRenderView;
            RtcReportHandle rtcReportHandle = this.mReportHandler;
            Objects.requireNonNull(rtcReportHandle);
            rTCVideoView2.setStuckEventListener(new RtcReportHandle.VideoStuckEvent(rtcReportHandle, janusConnection.handleId));
            this.mRenderView.setEnableSLIDataReport(this.mEnablePullQualityMonitor);
        }
        AudioTrack audioTrack = janusConnection.audioTrack;
        if (audioTrack != null) {
            this.mAudioTrack = audioTrack;
        }
        Logging.d(TAG, "add remote stream handleId: " + janusConnection.handleId);
        BRTCPlayerEvents bRTCPlayerEvents = this.mEventObserver;
        if (bRTCPlayerEvents != null) {
            bRTCPlayerEvents.onInfoUpdated(1000, "remote video start rendering");
        }
        this.mStreamingValidityDetectCount = 0;
        setCurrentState(BRTCPlayer.PlayerState.STATE_PLAYING);
    }

    @Override // com.baidu.rtc.PeerConnectionClient.PeerConnectionEvents
    public void onRemoteStreamStats(Boolean bool, Boolean bool2, BigInteger bigInteger) {
        BRTCPlayerEvents bRTCPlayerEvents;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048594, this, bool, bool2, bigInteger) == null) || (bRTCPlayerEvents = this.mEventObserver) == null) {
            return;
        }
        bRTCPlayerEvents.onRemoteStreamStats(bool.booleanValue(), bool2.booleanValue(), bigInteger);
    }

    @Override // com.baidu.rtc.PeerConnectionClient.PeerConnectionEvents
    public void onSEIRecv(ByteBuffer byteBuffer) {
        BRTCPlayerEvents bRTCPlayerEvents;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, byteBuffer) == null) || (bRTCPlayerEvents = this.mEventObserver) == null) {
            return;
        }
        bRTCPlayerEvents.onSEIRecv(byteBuffer);
    }

    public void pauseAudio() {
        AudioTrack audioTrack;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (audioTrack = this.mAudioTrack) == null) {
            return;
        }
        audioTrack.setEnabled(false);
    }

    @Override // com.baidu.rtc.player.BRTCPlayer
    public void pausePlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            if (getPlayerState() == BRTCPlayer.PlayerState.STATE_PLAYING || getPlayerState() == BRTCPlayer.PlayerState.STATE_ERROR) {
                pauseAudio();
                if (this.mRenderView != null && hasVideo()) {
                    this.mRenderView.pauseVideo();
                }
                setCurrentState(BRTCPlayer.PlayerState.STATE_PAUSED);
            }
        }
    }

    @Override // com.baidu.rtc.player.BRTCPlayer
    public void releasePlayer() {
        BigInteger bigInteger;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            RTCLoadManager.getInstance(this.mContext).release();
            RTCMediaRecorderImpl rTCMediaRecorderImpl = this.mRemoteVideoRecorder;
            if (rTCMediaRecorderImpl != null && rTCMediaRecorderImpl.isRecording()) {
                this.mRemoteVideoRecorder.stopRecording();
            }
            RTCVideoView rTCVideoView = this.mRenderView;
            if (rTCVideoView != null) {
                rTCVideoView.release();
            }
            EglBase eglBase = this.mRootEglBase;
            if (eglBase != null) {
                eglBase.release();
            }
            RtcReportHandle rtcReportHandle = this.mReportHandler;
            if (rtcReportHandle != null && (bigInteger = this.mPlayTransactionId) != null) {
                rtcReportHandle.stopPeerReport(bigInteger, this.peerConnectionClient);
            }
            if (this.peerConnectionClient != null) {
                this.peerConnectionClient.setAudioEnabled(false);
                this.peerConnectionClient.setVideoEnabled(false);
                this.peerConnectionClient.close();
                this.peerConnectionClient = null;
            }
            this.mPlayTransactionId = null;
            this.mAudioTrack = null;
            this.mVideoTrack = null;
            setCurrentState(BRTCPlayer.PlayerState.STATE_IDLE);
            System.gc();
        }
    }

    public void resumeAudio() {
        AudioTrack audioTrack;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || (audioTrack = this.mAudioTrack) == null) {
            return;
        }
        audioTrack.setEnabled(true);
    }

    @Override // com.baidu.rtc.player.BRTCPlayer
    public void resumePlay() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && getPlayerState() == BRTCPlayer.PlayerState.STATE_PAUSED) {
            if (this.mRenderView != null && hasVideo()) {
                this.mRenderView.disableFpsReduction();
            }
            resumeAudio();
            setCurrentState(BRTCPlayer.PlayerState.STATE_PLAYING);
        }
    }

    @Override // com.baidu.rtc.player.BRTCPlayer
    public void setEventObserver(BRTCPlayerEvents bRTCPlayerEvents) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, bRTCPlayerEvents) == null) {
            this.mEventObserver = bRTCPlayerEvents;
        }
    }

    @Override // com.baidu.rtc.player.BRTCPlayer
    public void setRemoteSdp(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            SessionDescription sessionDescription = new SessionDescription(SessionDescription.Type.ANSWER, str);
            if (this.peerConnectionClient != null) {
                Logging.d(TAG, "set remote sdp with transaction id" + this.mPlayTransactionId);
                this.peerConnectionClient.setRemoteDescription(this.mPlayTransactionId, sessionDescription);
            }
        }
    }

    @Override // com.baidu.rtc.player.BRTCPlayer
    public void setScalingType(RTCVideoView.ScalingType scalingType) {
        RTCVideoView rTCVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048603, this, scalingType) == null) || (rTCVideoView = this.mRenderView) == null) {
            return;
        }
        rTCVideoView.setScalingType(RendererCommon.ScalingType.values()[scalingType.ordinal()]);
    }

    @Override // com.baidu.rtc.player.BRTCPlayer
    public void setStreamUri(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, str) == null) {
            this.mStreamUrl = str;
        }
    }

    @Override // com.baidu.rtc.player.BRTCPlayer
    public void setSurfaceView(RTCVideoView rTCVideoView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, rTCVideoView) == null) {
            RTCVideoView rTCVideoView2 = this.mRenderView;
            if (rTCVideoView2 != null) {
                rTCVideoView2.release();
            }
            this.mRenderView = rTCVideoView;
            this.mHandler.post(new Runnable(this) { // from class: com.baidu.rtc.player.BRTCPlayerImpl.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BRTCPlayerImpl this$0;

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
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.this$0.mRenderView == null) {
                        return;
                    }
                    try {
                        this.this$0.mRenderView.init(this.this$0.mRootEglBase.getEglBaseContext(), this.this$0.mRendererEvents);
                    } catch (Exception unused) {
                    }
                    this.this$0.mRenderView.setEnableHardwareScaler(true);
                }
            });
        }
    }

    @Override // com.baidu.rtc.player.BRTCPlayer
    public void setVolume(double d2) {
        AudioTrack audioTrack;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048606, this, new Object[]{Double.valueOf(d2)}) == null) || (audioTrack = this.mAudioTrack) == null) {
            return;
        }
        audioTrack.setVolume(d2);
    }

    @Override // com.baidu.rtc.player.BRTCPlayer
    public void startPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            if (!this.mIsLibraryLoading) {
                this.mTimeStatistician.setStartTime();
            }
            if (!TextUtils.isEmpty(this.mStreamUrl) && this.mStreamUrl.startsWith(STREAM_URL_PREFIX)) {
                if (this.mPlayerParameters.isEnableSoLaterLoad() && !RTCLoadManager.getInstance(this.mContext).isLoadCompleted()) {
                    this.mIsLibraryLoading = true;
                    RTCLoadManager.getInstance(this.mContext).loadLibraries(this.mPlayerParameters.getSoLaterLoadUrl(), this.mPlayerParameters.getCpuType(), this.mLoadListener);
                    return;
                }
                this.mIsLibraryLoading = false;
                if (this.mPlayTransactionId != null && getPlayerState() == BRTCPlayer.PlayerState.STATE_ERROR) {
                    stopPlay();
                }
                if (isCanPlayState()) {
                    this.mPlayTransactionId = createPlayerHandler();
                    Logging.d(TAG, "Create play transactionId:" + this.mPlayTransactionId);
                    offerPeerConnection(this.mPlayTransactionId);
                    this.mIsBuffing = false;
                    this.mBufferingDetectCount = 0;
                    this.mStreamingValidityDetectCount = 0;
                    this.mTimeStatistician.updateStepTime(PlayTimeStatistician.PlayStep.PLAY_STARTED);
                    setCurrentState(BRTCPlayer.PlayerState.STATE_PREPARING);
                    return;
                }
                reportError(10008, "Play failed invalid state " + getPlayerState() + " with" + this.mStreamUrl);
                return;
            }
            BRTCPlayerEvents bRTCPlayerEvents = this.mEventObserver;
            if (bRTCPlayerEvents != null) {
                bRTCPlayerEvents.onError(10000, "Play failed invalid stream url format with " + this.mStreamUrl);
            }
        }
    }

    @Override // com.baidu.rtc.record.IMediaRecord
    public void startRecording(String str, MediaEncodeParams mediaEncodeParams, RecorderCallback recorderCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048608, this, str, mediaEncodeParams, recorderCallback) == null) {
            if (getPlayerState() != BRTCPlayer.PlayerState.STATE_PLAYING || TextUtils.isEmpty(str)) {
                if (recorderCallback != null) {
                    recorderCallback.onRecordCompleted(false, "Invalid state");
                    return;
                }
                return;
            }
            if (this.mRemoteVideoRecorder == null) {
                if (this.mRemoteSamplesInterceptor == null) {
                    this.mRemoteSamplesInterceptor = new RemoteAudioSamplesInterceptor();
                }
                this.mRemoteVideoRecorder = new RTCMediaRecorderImpl(this.mVideoTrack, this.mRemoteSamplesInterceptor);
            }
            if (this.peerConnectionClient != null) {
                this.peerConnectionClient.setRemoteAudioSamplesReadyCallback(this.mRemoteSamplesInternalCallback);
            }
            if (mediaEncodeParams == null) {
                try {
                    mediaEncodeParams = new MediaEncodeParams();
                    Logging.d(TAG, "Use default encode params!");
                } catch (Exception e2) {
                    Logging.d(TAG, e2.toString());
                    return;
                }
            }
            this.mRemoteVideoRecorder.startRecording(str, mediaEncodeParams, recorderCallback);
        }
    }

    @Override // com.baidu.rtc.player.BRTCPlayer
    public void stopPlay() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048609, this) == null) || getPlayerState() == BRTCPlayer.PlayerState.STATE_IDLE || getPlayerState() == BRTCPlayer.PlayerState.STATE_INITIALIZED || getPlayerState() == BRTCPlayer.PlayerState.STATE_STOP) {
            return;
        }
        closePeer(this.mPlayTransactionId);
        this.mPlayTransactionId = null;
        this.mStreamingValidityDetectCount = 0;
        this.mIsBuffing = false;
        this.mBufferingDetectCount = 0;
        setCurrentState(BRTCPlayer.PlayerState.STATE_STOP);
    }

    @Override // com.baidu.rtc.record.IMediaRecord
    public void stopRecording() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            RemoteAudioSamplesInterceptor remoteAudioSamplesInterceptor = this.mRemoteSamplesInterceptor;
            if (remoteAudioSamplesInterceptor != null) {
                remoteAudioSamplesInterceptor.detachCallback();
                this.mRemoteSamplesInterceptor = null;
            }
            if (this.peerConnectionClient != null) {
                this.peerConnectionClient.setRemoteAudioSamplesReadyCallback(null);
            }
            RTCMediaRecorderImpl rTCMediaRecorderImpl = this.mRemoteVideoRecorder;
            if (rTCMediaRecorderImpl != null) {
                rTCMediaRecorderImpl.stopRecording();
                this.mRemoteVideoRecorder = null;
            }
        }
    }

    @Override // com.baidu.rtc.snapshot.ISnapShot
    public void takeSnapShot(String str, SnapShotCallback snapShotCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048611, this, str, snapShotCallback) == null) {
            if ((getPlayerState() == BRTCPlayer.PlayerState.STATE_PLAYING || getPlayerState() == BRTCPlayer.PlayerState.STATE_PAUSED) && !TextUtils.isEmpty(str)) {
                new SnapShotHelper(this.mRenderView, this.mHandler).takeSnapShot(str, snapShotCallback);
            } else if (snapShotCallback != null) {
                snapShotCallback.onSnapShotTake(false, "Invalid state with file path " + str);
            }
        }
    }
}
