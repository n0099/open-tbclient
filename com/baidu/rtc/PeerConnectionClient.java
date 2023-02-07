package com.baidu.rtc;

import android.content.Context;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.rtc.PeerConnectionClient;
import com.baidu.rtc.RtcParameterSettings;
import com.baidu.rtc.SdpPrefer;
import com.baidu.rtc.logreport.ErrorInfoReport;
import com.baidu.rtc.logreport.SLIReportInterface;
import com.baidu.tieba.mca;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.webrtc.AudioSource;
import org.webrtc.AudioTrack;
import org.webrtc.CalledByNative;
import org.webrtc.CameraVideoCapturer;
import org.webrtc.DataChannel;
import org.webrtc.EglBase;
import org.webrtc.IceCandidate;
import org.webrtc.Logging;
import org.webrtc.MediaCodecVideoDecoder;
import org.webrtc.MediaCodecVideoEncoder;
import org.webrtc.MediaConstraints;
import org.webrtc.MediaStream;
import org.webrtc.MediaStreamTrack;
import org.webrtc.PeerConnection;
import org.webrtc.PeerConnectionFactory;
import org.webrtc.RtpParameters;
import org.webrtc.RtpReceiver;
import org.webrtc.RtpSender;
import org.webrtc.RtpTransceiver;
import org.webrtc.SdpObserver;
import org.webrtc.SessionDescription;
import org.webrtc.StatsObserver;
import org.webrtc.StatsReport;
import org.webrtc.SurfaceTextureHelper;
import org.webrtc.VideoCapturer;
import org.webrtc.VideoSink;
import org.webrtc.VideoSource;
import org.webrtc.VideoTrack;
import org.webrtc.audio.AudioDeviceModule;
import org.webrtc.audio.JavaAudioDeviceModule;
import org.webrtc.voiceengine.WebRtcAudioManager;
import org.webrtc.voiceengine.WebRtcAudioUtils;
/* loaded from: classes2.dex */
public class PeerConnectionClient implements DataChannel.Observer {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String AUDIO_AUTO_GAIN_CONTROL_CONSTRAINT = "googAutoGainControl";
    public static final String AUDIO_ECHO_CANCELLATION_CONSTRAINT = "googEchoCancellation";
    public static final String AUDIO_HIGH_PASS_FILTER_CONSTRAINT = "googHighpassFilter";
    public static final String AUDIO_NOISE_SUPPRESSION_CONSTRAINT = "googNoiseSuppression";
    public static final String AUDIO_TRACK_ID = "ARDAMSa0";
    public static final int BPS_IN_KBPS = 1000;
    public static final String DTLS_SRTP_KEY_AGREEMENT_CONSTRAINT = "DtlsSrtpKeyAgreement";
    public static final int HD_VIDEO_HEIGHT = 720;
    public static final int HD_VIDEO_WIDTH = 1280;
    public static final String TAG = "PCRTCClient";
    public static final String VIDEO_CODEC_H264 = "H264";
    public static final String VIDEO_CODEC_VP8 = "VP8";
    public static final String VIDEO_CODEC_VP9 = "VP9";
    public static final String VIDEO_TRACK_ID = "ARDAMSv0";
    public static final String VIDEO_TRACK_TYPE = "video";
    public static final PeerConnectionClient instance = null;
    public transient /* synthetic */ FieldHolder $fh;
    public JavaAudioDeviceModule adm;
    public ParcelFileDescriptor aecDumpFileDescriptor;
    public MediaConstraints answer_sdpMediaConstraints;
    public MediaConstraints audioConstraints;
    public AudioSource audioSource;
    public Context context;
    public DataChannel dcPublisher;
    public boolean enableAudio;
    public PeerConnectionEvents events;
    public final ScheduledExecutorService executor;
    public JavaAudioDeviceModule.ExternalSamplesReadyCallback externalSamplesCallback;
    public PeerConnectionFactory factory;
    public JavaAudioDeviceModule.SamplesReadyCallback innersamplesReadyCallback;
    public boolean isEnableFEC;
    public boolean isError;
    public AudioTrack localAudioTrack;
    public VideoSink localRender;
    public SurfaceTextureHelper localTextureHelper;
    public RtpSender localVideoSender;
    public VideoTrack localVideoTrack;
    public int mAudioChannel;
    public int mAudioFreguency;
    public boolean mExternalAudioRecord;
    public boolean mHasAudioRecv;
    public boolean mHasAudioSend;
    public boolean mHasData;
    public boolean mHasDataRecv;
    public boolean mHasDataSend;
    public boolean mHasVideoRecv;
    public boolean mHasVideoSend;
    public JavaAudioDeviceModule.RemoteSamplesReadyCallback mRemoteSamplesReadyCallback;
    public SLIReportInterface mStuckEvent;
    public boolean mbEnableDebugLog;
    public MediaStream mediaStream;
    public PeerConnectionFactory.Options options;
    public MediaConstraints pcConstraints;
    public ConcurrentHashMap<BigInteger, JanusConnection> peerConnectionMap;
    public PeerConnectionParameters peerConnectionParameters;
    public String preferredVideoCodec;
    public AudioTrack remoteAudioTrack;
    public Map<BigInteger, Integer> remoteLevels;
    public VideoTrack remoteVideoTrack;
    public boolean renderVideo;
    public MediaConstraints sdpMediaConstraints;
    public Timer statsTimer;
    public Map<BigInteger, TimerTask> timerTaskGetQualityMap;
    public Map<BigInteger, TimerTask> timerTaskGetSLIMap;
    public Map<BigInteger, TimerTask> timerTaskGetVolumeMap;
    public VideoCapturer videoCapturer;
    public boolean videoCapturerStopped;
    public int videoFps;
    public int videoHeight;
    public VideoSource videoSource;
    public int videoWidth;
    public int videokbps;

    /* loaded from: classes2.dex */
    public interface PeerConnectionEvents {
        void onIceCandidate(IceCandidate iceCandidate, BigInteger bigInteger);

        void onIceCandidatesRemoved(IceCandidate[] iceCandidateArr);

        void onIceConnected();

        void onIceDisconnected();

        void onIceFailed();

        void onLocalDescription(SessionDescription sessionDescription, BigInteger bigInteger, boolean z);

        void onPeerClosed(BigInteger bigInteger);

        void onPeerConnectionClosed();

        void onPeerConnectionError(String str);

        void onPeerConnectionStatsReady(StatsReport[] statsReportArr, BigInteger bigInteger, StatsEventsType statsEventsType);

        void onRemoteData(ByteBuffer byteBuffer);

        void onRemoteDescription(SessionDescription sessionDescription, BigInteger bigInteger);

        void onRemoteRender(JanusConnection janusConnection);

        void onRemoteStreamStats(Boolean bool, Boolean bool2, BigInteger bigInteger);

        void onSEIRecv(ByteBuffer byteBuffer);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948454708, "Lcom/baidu/rtc/PeerConnectionClient;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948454708, "Lcom/baidu/rtc/PeerConnectionClient;");
        }
    }

    @Override // org.webrtc.DataChannel.Observer
    public void onBufferedAmountChange(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048588, this, j) == null) {
        }
    }

    @Override // org.webrtc.DataChannel.Observer
    public void onStateChange() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
        }
    }

    /* loaded from: classes2.dex */
    public class PCObserver implements PeerConnection.Observer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public JanusConnection connection;
        public PeerConnection peerConnection;
        public final /* synthetic */ PeerConnectionClient this$0;

        @Override // org.webrtc.PeerConnection.Observer
        @CalledByNative("Observer")
        public /* synthetic */ void onConnectionChange(PeerConnection.PeerConnectionState peerConnectionState) {
            mca.$default$onConnectionChange(this, peerConnectionState);
        }

        @Override // org.webrtc.PeerConnection.Observer
        public void onRenegotiationNeeded() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            }
        }

        @Override // org.webrtc.PeerConnection.Observer
        @CalledByNative("Observer")
        public /* synthetic */ void onTrack(RtpTransceiver rtpTransceiver) {
            mca.$default$onTrack(this, rtpTransceiver);
        }

        public PCObserver(PeerConnectionClient peerConnectionClient) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {peerConnectionClient};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = peerConnectionClient;
        }

        @Override // org.webrtc.PeerConnection.Observer
        public void onAddStream(MediaStream mediaStream) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mediaStream) == null) {
                if (this.this$0.executor.isShutdown()) {
                    Log.w(PeerConnectionClient.TAG, "executor is already shutdown");
                } else {
                    this.this$0.executor.execute(new Runnable(this, mediaStream) { // from class: com.baidu.rtc.PeerConnectionClient.PCObserver.4
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ PCObserver this$1;
                        public final /* synthetic */ MediaStream val$stream;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, mediaStream};
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
                            this.val$stream = mediaStream;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Boolean bool;
                            Interceptable interceptable2 = $ic;
                            if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.this$1.peerConnection != null && !this.this$1.this$0.isError) {
                                Log.d(PeerConnectionClient.TAG, "=========== onAddStream ==========");
                                if (this.val$stream.audioTracks.size() == 1) {
                                    this.this$1.this$0.remoteAudioTrack = this.val$stream.audioTracks.get(0);
                                    this.this$1.connection.audioTrack = this.this$1.this$0.remoteAudioTrack;
                                }
                                if (this.val$stream.videoTracks.size() == 1) {
                                    this.this$1.this$0.remoteVideoTrack = this.val$stream.videoTracks.get(0);
                                    this.this$1.this$0.remoteVideoTrack.setEnabled(true);
                                    this.this$1.connection.videoTrack = this.this$1.this$0.remoteVideoTrack;
                                    this.this$1.this$0.events.onRemoteRender(this.this$1.connection);
                                }
                                Boolean bool2 = Boolean.FALSE;
                                if (this.val$stream.videoTracks.size() != 0) {
                                    bool = Boolean.TRUE;
                                } else {
                                    bool = bool2;
                                }
                                if (this.val$stream.audioTracks.size() != 0) {
                                    bool2 = Boolean.TRUE;
                                }
                                this.this$1.this$0.events.onRemoteStreamStats(bool, bool2, this.this$1.connection.handleId);
                            }
                        }
                    });
                }
            }
        }

        @Override // org.webrtc.PeerConnection.Observer
        public void onDataChannel(DataChannel dataChannel) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, dataChannel) == null) {
                Log.d(PeerConnectionClient.TAG, "New Data channel " + dataChannel.label());
                dataChannel.registerObserver(this.this$0);
            }
        }

        @Override // org.webrtc.PeerConnection.Observer
        public void onIceCandidate(IceCandidate iceCandidate) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, iceCandidate) == null) {
                if (this.this$0.executor.isShutdown()) {
                    Log.w(PeerConnectionClient.TAG, "executor is already shutdown");
                } else {
                    this.this$0.executor.execute(new Runnable(this, iceCandidate) { // from class: com.baidu.rtc.PeerConnectionClient.PCObserver.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ PCObserver this$1;
                        public final /* synthetic */ IceCandidate val$candidate;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, iceCandidate};
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
                            this.val$candidate = iceCandidate;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.this$1.this$0.events.onIceCandidate(this.val$candidate, this.this$1.connection.handleId);
                            }
                        }
                    });
                }
            }
        }

        @Override // org.webrtc.PeerConnection.Observer
        public void onIceCandidatesRemoved(IceCandidate[] iceCandidateArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, iceCandidateArr) == null) {
                if (this.this$0.executor.isShutdown()) {
                    Log.w(PeerConnectionClient.TAG, "executor is already shutdown");
                } else {
                    this.this$0.executor.execute(new Runnable(this, iceCandidateArr) { // from class: com.baidu.rtc.PeerConnectionClient.PCObserver.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ PCObserver this$1;
                        public final /* synthetic */ IceCandidate[] val$candidates;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, iceCandidateArr};
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
                            this.val$candidates = iceCandidateArr;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.this$1.this$0.events.onIceCandidatesRemoved(this.val$candidates);
                            }
                        }
                    });
                }
            }
        }

        @Override // org.webrtc.PeerConnection.Observer
        public void onIceConnectionChange(PeerConnection.IceConnectionState iceConnectionState) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, iceConnectionState) == null) {
                if (this.this$0.executor.isShutdown()) {
                    Log.w(PeerConnectionClient.TAG, "executor is already shutdown");
                } else {
                    this.this$0.executor.execute(new Runnable(this, iceConnectionState) { // from class: com.baidu.rtc.PeerConnectionClient.PCObserver.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ PCObserver this$1;
                        public final /* synthetic */ PeerConnection.IceConnectionState val$newState;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, iceConnectionState};
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
                            this.val$newState = iceConnectionState;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                Log.d(PeerConnectionClient.TAG, "IceConnectionState: " + this.val$newState);
                                PeerConnection.IceConnectionState iceConnectionState2 = this.val$newState;
                                if (iceConnectionState2 == PeerConnection.IceConnectionState.CONNECTED) {
                                    this.this$1.this$0.events.onIceConnected();
                                } else if (iceConnectionState2 == PeerConnection.IceConnectionState.DISCONNECTED) {
                                    this.this$1.this$0.events.onIceDisconnected();
                                } else if (iceConnectionState2 == PeerConnection.IceConnectionState.FAILED) {
                                    this.this$1.this$0.events.onIceFailed();
                                }
                            }
                        }
                    });
                }
            }
        }

        @Override // org.webrtc.PeerConnection.Observer
        public void onIceConnectionReceivingChange(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
                Log.d(PeerConnectionClient.TAG, "IceConnectionReceiving changed to " + z);
            }
        }

        @Override // org.webrtc.PeerConnection.Observer
        public void onIceGatheringChange(PeerConnection.IceGatheringState iceGatheringState) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, iceGatheringState) == null) {
                Log.d(PeerConnectionClient.TAG, "IceGatheringState: " + iceGatheringState);
            }
        }

        @Override // org.webrtc.PeerConnection.Observer
        public void onRemoveStream(MediaStream mediaStream) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, mediaStream) == null) {
                if (this.this$0.executor.isShutdown()) {
                    Log.w(PeerConnectionClient.TAG, "executor is already shutdown");
                } else {
                    this.this$0.executor.execute(new Runnable(this) { // from class: com.baidu.rtc.PeerConnectionClient.PCObserver.5
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ PCObserver this$1;

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
                            this.this$1 = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.this$1.this$0.remoteVideoTrack = null;
                                this.this$1.this$0.remoteAudioTrack = null;
                            }
                        }
                    });
                }
            }
        }

        @Override // org.webrtc.PeerConnection.Observer
        public void onSignalingChange(PeerConnection.SignalingState signalingState) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, signalingState) == null) {
                Log.d(PeerConnectionClient.TAG, "SignalingState: " + signalingState);
            }
        }

        public void setConnection(JanusConnection janusConnection) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048590, this, janusConnection) == null) {
                this.connection = janusConnection;
                this.peerConnection = janusConnection.peerConnection;
            }
        }

        public void close() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.peerConnection = null;
            }
        }

        @Override // org.webrtc.PeerConnection.Observer
        public void onAddTrack(RtpReceiver rtpReceiver, MediaStream[] mediaStreamArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, rtpReceiver, mediaStreamArr) == null) {
                Log.d(PeerConnectionClient.TAG, "testing ... add track");
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class PeerConnectionParameters {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public RtcParameterSettings.RtcAudioBitrateMode audioBitrateMode;
        public final int audioBufferPackets;
        public final String audioCodec;
        public final int audioCodecComplex;
        public final int audioContentType;
        public final int audioMaxkbps;
        public final int audioPlayoutDelay;
        public final int audioSource;
        public final int audioStartBitrate;
        public final boolean cameraMuted;
        public final boolean disableBuiltInAEC;
        public final boolean disableBuiltInAGC;
        public final boolean disableBuiltInNS;
        public final boolean enableAACCodec;
        public final boolean enableFEC;
        public final boolean enableFixedResolution;
        public final boolean enableHighProfile;
        public final boolean enableHisiH264HW;
        public final boolean enableMTKH264Decode;
        public final boolean enableRequiredResolutionAligment32;
        public final int encodeBitrateMode;
        public final boolean micPhoneMuted;
        public final boolean noAudioProcessing;
        public final boolean tracing;
        public RtcParameterSettings.RtcAudioChannel transportAudioChannel;
        public final boolean useOpenSLES;
        public final String videoCodec;
        public final boolean videoCodecHwAcceleration;
        public final int videoFps;
        public final int videoHeight;
        public final int videoMaxkbps;
        public final int videoMinkbps;
        public final int videoWidth;

        public PeerConnectionParameters(boolean z, int i, int i2, int i3, String str, boolean z2, int i4, String str2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, int i5, int i6, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, boolean z13, int i7, RtcParameterSettings.RtcAudioBitrateMode rtcAudioBitrateMode, RtcParameterSettings.RtcAudioChannel rtcAudioChannel, int i8, boolean z14, boolean z15, int i9, int i10, int i11, int i12, boolean z16, int i13) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str, Boolean.valueOf(z2), Integer.valueOf(i4), str2, Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5), Boolean.valueOf(z6), Boolean.valueOf(z7), Integer.valueOf(i5), Integer.valueOf(i6), Boolean.valueOf(z8), Boolean.valueOf(z9), Boolean.valueOf(z10), Boolean.valueOf(z11), Boolean.valueOf(z12), Boolean.valueOf(z13), Integer.valueOf(i7), rtcAudioBitrateMode, rtcAudioChannel, Integer.valueOf(i8), Boolean.valueOf(z14), Boolean.valueOf(z15), Integer.valueOf(i9), Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), Boolean.valueOf(z16), Integer.valueOf(i13)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i14 = newInitContext.flag;
                if ((i14 & 1) != 0) {
                    int i15 = i14 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.tracing = z;
            this.videoWidth = i;
            this.videoHeight = i2;
            this.videoFps = i3;
            this.videoCodec = str;
            this.videoCodecHwAcceleration = z2;
            this.audioStartBitrate = i4;
            this.audioCodec = str2;
            this.noAudioProcessing = z3;
            this.useOpenSLES = z4;
            this.disableBuiltInAEC = z5;
            this.disableBuiltInAGC = z6;
            this.disableBuiltInNS = z7;
            this.videoMaxkbps = i5;
            this.videoMinkbps = i6;
            this.micPhoneMuted = z8;
            this.cameraMuted = z9;
            this.enableFEC = z10;
            this.enableFixedResolution = z11;
            this.enableRequiredResolutionAligment32 = z12;
            this.enableHighProfile = z13;
            this.audioMaxkbps = i7;
            this.audioBitrateMode = rtcAudioBitrateMode;
            this.transportAudioChannel = rtcAudioChannel;
            this.encodeBitrateMode = i8;
            this.enableHisiH264HW = z14;
            this.enableMTKH264Decode = z15;
            this.audioSource = i9;
            this.audioBufferPackets = i10;
            this.audioPlayoutDelay = i11;
            this.audioCodecComplex = i12;
            this.enableAACCodec = z16;
            this.audioContentType = i13;
        }
    }

    /* loaded from: classes2.dex */
    public class SDPObserver implements SdpObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public PeerConnectionParameters connectionParam;
        public BigInteger handleId;
        public SessionDescription localSdp;
        public PeerConnection peerConnection;
        public SDPObserver sdpObserver;
        public final /* synthetic */ PeerConnectionClient this$0;
        public boolean type;

        public SDPObserver(PeerConnectionClient peerConnectionClient) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {peerConnectionClient};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = peerConnectionClient;
        }

        @Override // org.webrtc.SdpObserver
        public void onCreateFailure(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                PeerConnectionClient peerConnectionClient = this.this$0;
                peerConnectionClient.reportError("createSDP error: " + str);
                ErrorInfoReport.getInstance().reportErrorInfo(ErrorInfoReport.ErrorCode.PEERCONNECTION_CREATE_ERROR);
            }
        }

        @Override // org.webrtc.SdpObserver
        public void onSetFailure(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                PeerConnectionClient peerConnectionClient = this.this$0;
                peerConnectionClient.reportError("setSDP error: " + str);
                ErrorInfoReport.getInstance().reportErrorInfo(ErrorInfoReport.ErrorCode.PEERCONNECTION_CREATE_ERROR);
            }
        }

        public void setConnection(JanusConnection janusConnection) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, janusConnection) == null) {
                this.peerConnection = janusConnection.peerConnection;
                this.sdpObserver = janusConnection.sdpObserver;
                this.handleId = janusConnection.handleId;
                this.type = janusConnection.type;
                this.connectionParam = janusConnection.connectionParam;
            }
        }

        public void close() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.peerConnection = null;
            }
        }

        @Override // org.webrtc.SdpObserver
        public void onSetSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                if (this.this$0.executor.isShutdown()) {
                    Log.w(PeerConnectionClient.TAG, "executor is already shutdown");
                } else {
                    this.this$0.executor.execute(new Runnable(this) { // from class: com.baidu.rtc.PeerConnectionClient.SDPObserver.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ SDPObserver this$1;

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
                            this.this$1 = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.this$1.peerConnection != null && !this.this$1.this$0.isError) {
                                if (this.this$1.type) {
                                    if (this.this$1.peerConnection.getRemoteDescription() == null) {
                                        Log.d(PeerConnectionClient.TAG, "Local SDP set succesfully");
                                        this.this$1.this$0.events.onLocalDescription(this.this$1.localSdp, this.this$1.handleId, this.this$1.localSdp.description.contains("profile-level-id=640c1f"));
                                        return;
                                    }
                                    Log.d(PeerConnectionClient.TAG, "Remote SDP set succesfully");
                                } else if (this.this$1.peerConnection.getLocalDescription() != null) {
                                    Log.d(PeerConnectionClient.TAG, "answer Local SDP set succesfully");
                                    this.this$1.this$0.events.onRemoteDescription(this.this$1.localSdp, this.this$1.handleId);
                                } else {
                                    Log.d(PeerConnectionClient.TAG, "answer Remote SDP set succesfully");
                                }
                            }
                        }
                    });
                }
            }
        }

        @Override // org.webrtc.SdpObserver
        public void onCreateSuccess(SessionDescription sessionDescription) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sessionDescription) == null) {
                Log.e(PeerConnectionClient.TAG, "SDP on create success");
                SessionDescription sessionDescription2 = new SessionDescription(sessionDescription.type, sessionDescription.description);
                this.localSdp = sessionDescription2;
                if (this.this$0.executor.isShutdown()) {
                    Log.w(PeerConnectionClient.TAG, "executor is already shutdown");
                } else {
                    this.this$0.executor.execute(new Runnable(this, sessionDescription2) { // from class: com.baidu.rtc.PeerConnectionClient.SDPObserver.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ SDPObserver this$1;
                        public final /* synthetic */ SessionDescription val$sdp;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, sessionDescription2};
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
                            this.val$sdp = sessionDescription2;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.this$1.peerConnection != null && !this.this$1.this$0.isError) {
                                Log.d(PeerConnectionClient.TAG, "Set local SDP from " + this.val$sdp.type + " description:" + this.val$sdp.description);
                                this.this$1.peerConnection.setLocalDescription(this.this$1.sdpObserver, this.val$sdp);
                            }
                        }
                    });
                }
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class StatsEventsType {
        public static final /* synthetic */ StatsEventsType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final StatsEventsType GET_AUDIOLEVEL_EVENT;
        public static final StatsEventsType GET_BWE_EVENT;
        public static final StatsEventsType GET_QUALITY_MONITOR_EVENT;
        public static final StatsEventsType GET_SLI_EVENT;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2063065542, "Lcom/baidu/rtc/PeerConnectionClient$StatsEventsType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2063065542, "Lcom/baidu/rtc/PeerConnectionClient$StatsEventsType;");
                    return;
                }
            }
            GET_AUDIOLEVEL_EVENT = new StatsEventsType("GET_AUDIOLEVEL_EVENT", 0);
            GET_QUALITY_MONITOR_EVENT = new StatsEventsType("GET_QUALITY_MONITOR_EVENT", 1);
            GET_BWE_EVENT = new StatsEventsType("GET_BWE_EVENT", 2);
            StatsEventsType statsEventsType = new StatsEventsType("GET_SLI_EVENT", 3);
            GET_SLI_EVENT = statsEventsType;
            $VALUES = new StatsEventsType[]{GET_AUDIOLEVEL_EVENT, GET_QUALITY_MONITOR_EVENT, GET_BWE_EVENT, statsEventsType};
        }

        public StatsEventsType(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static StatsEventsType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (StatsEventsType) Enum.valueOf(StatsEventsType.class, str);
            }
            return (StatsEventsType) invokeL.objValue;
        }

        public static StatsEventsType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (StatsEventsType[]) $VALUES.clone();
            }
            return (StatsEventsType[]) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static class VideoDecoderObserver implements MediaCodecVideoDecoder.MediaCodecVideoDecoderObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public PeerConnectionEvents events;

        public VideoDecoderObserver(PeerConnectionEvents peerConnectionEvents) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {peerConnectionEvents};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.events = peerConnectionEvents;
        }

        @Override // org.webrtc.MediaCodecVideoDecoder.MediaCodecVideoDecoderObserver
        public void onSEIRecv(ByteBuffer byteBuffer) {
            PeerConnectionEvents peerConnectionEvents;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, byteBuffer) == null) && (peerConnectionEvents = this.events) != null) {
                peerConnectionEvents.onSEIRecv(byteBuffer);
            }
        }
    }

    public PeerConnectionClient() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.options = null;
        this.timerTaskGetVolumeMap = new ConcurrentHashMap();
        this.timerTaskGetQualityMap = new ConcurrentHashMap();
        this.timerTaskGetSLIMap = new ConcurrentHashMap();
        this.mHasData = false;
        this.mAudioFreguency = 48000;
        this.mAudioChannel = 1;
        this.isEnableFEC = true;
        this.dcPublisher = null;
        this.remoteLevels = new ConcurrentHashMap();
        this.mStuckEvent = null;
        this.mbEnableDebugLog = false;
        this.adm = null;
        this.mHasAudioSend = true;
        this.mHasVideoSend = true;
        this.mHasDataSend = false;
        this.mHasAudioRecv = true;
        this.mHasVideoRecv = true;
        this.mHasDataRecv = false;
        this.executor = Executors.newSingleThreadScheduledExecutor();
        this.peerConnectionMap = new ConcurrentHashMap<>();
    }

    public AudioDeviceModule createJavaAudioDevice() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            boolean z2 = true;
            JavaAudioDeviceModule.Builder sampleRate = JavaAudioDeviceModule.builder(this.context).setSamplesReadyCallback(this.innersamplesReadyCallback).setRemoteSamplesReadyCallback(this.mRemoteSamplesReadyCallback).setExternalAudioRecord(this.mExternalAudioRecord).setUseHardwareAcousticEchoCanceler(!this.peerConnectionParameters.disableBuiltInAEC).setUseHardwareNoiseSuppressor(!this.peerConnectionParameters.disableBuiltInNS).setAudioRecordErrorCallback(new JavaAudioDeviceModule.AudioRecordErrorCallback(this) { // from class: com.baidu.rtc.PeerConnectionClient.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ PeerConnectionClient this$0;

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

                @Override // org.webrtc.audio.JavaAudioDeviceModule.AudioRecordErrorCallback
                public void onWebRtcAudioRecordError(String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, str) == null) {
                        Log.e(PeerConnectionClient.TAG, "onWebRtcAudioRecordError: " + str);
                        this.this$0.reportError(str);
                    }
                }

                @Override // org.webrtc.audio.JavaAudioDeviceModule.AudioRecordErrorCallback
                public void onWebRtcAudioRecordInitError(String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                        Log.e(PeerConnectionClient.TAG, "onWebRtcAudioRecordInitError: " + str);
                        this.this$0.reportError(str);
                        ErrorInfoReport.getInstance().reportErrorInfo(ErrorInfoReport.ErrorCode.PEERCONNECTION_CREATE_ERROR);
                    }
                }

                @Override // org.webrtc.audio.JavaAudioDeviceModule.AudioRecordErrorCallback
                public void onWebRtcAudioRecordStartError(JavaAudioDeviceModule.AudioRecordStartErrorCode audioRecordStartErrorCode, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_SEND_USER_MSG, this, audioRecordStartErrorCode, str) == null) {
                        Log.e(PeerConnectionClient.TAG, "onWebRtcAudioRecordStartError: " + audioRecordStartErrorCode + ". " + str);
                    }
                }
            }).setAudioTrackErrorCallback(new JavaAudioDeviceModule.AudioTrackErrorCallback(this) { // from class: com.baidu.rtc.PeerConnectionClient.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ PeerConnectionClient this$0;

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

                @Override // org.webrtc.audio.JavaAudioDeviceModule.AudioTrackErrorCallback
                public void onWebRtcAudioTrackError(String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, str) == null) {
                        Log.e(PeerConnectionClient.TAG, "onWebRtcAudioTrackError: " + str);
                        this.this$0.reportError(str);
                    }
                }

                @Override // org.webrtc.audio.JavaAudioDeviceModule.AudioTrackErrorCallback
                public void onWebRtcAudioTrackInitError(String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                        Log.e(PeerConnectionClient.TAG, "onWebRtcAudioTrackInitError: " + str);
                        this.this$0.reportError(str);
                    }
                }

                @Override // org.webrtc.audio.JavaAudioDeviceModule.AudioTrackErrorCallback
                public void onWebRtcAudioTrackStartError(JavaAudioDeviceModule.AudioTrackStartErrorCode audioTrackStartErrorCode, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_SEND_USER_MSG, this, audioTrackStartErrorCode, str) == null) {
                        Log.e(PeerConnectionClient.TAG, "onWebRtcAudioTrackStartError: " + audioTrackStartErrorCode + ". " + str);
                        this.this$0.reportError(str);
                    }
                }
            }).setSampleRate(this.mAudioFreguency);
            if (this.mAudioChannel > 1) {
                z = true;
            } else {
                z = false;
            }
            JavaAudioDeviceModule.Builder useStereoInput = sampleRate.setUseStereoInput(z);
            if (this.mAudioChannel <= 1) {
                z2 = false;
            }
            AudioDeviceModule createAudioDeviceModule = useStereoInput.setUseStereoOutput(z2).setAudioSource(this.peerConnectionParameters.audioSource).setAudioContentType(this.peerConnectionParameters.audioContentType).createAudioDeviceModule();
            if (this.mExternalAudioRecord && (createAudioDeviceModule instanceof JavaAudioDeviceModule)) {
                this.externalSamplesCallback = ((JavaAudioDeviceModule) createAudioDeviceModule).getExternalSamplesReadyCallback();
            }
            return createAudioDeviceModule;
        }
        return (AudioDeviceModule) invokeV.objValue;
    }

    public void setAudioRecording(BigInteger bigInteger, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048595, this, bigInteger, z) == null) {
            if (this.executor.isShutdown()) {
                Log.w(TAG, "executor is already shutdown");
            } else {
                this.executor.execute(new Runnable(this, bigInteger, z) { // from class: com.baidu.rtc.PeerConnectionClient.18
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ PeerConnectionClient this$0;
                    public final /* synthetic */ BigInteger val$handleId;
                    public final /* synthetic */ boolean val$recording;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, bigInteger, Boolean.valueOf(z)};
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
                        this.val$recording = z;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        PeerConnection peerConnection;
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && (peerConnection = ((JanusConnection) this.this$0.peerConnectionMap.get(this.val$handleId)).peerConnection) != null) {
                            peerConnection.setAudioRecording(this.val$recording);
                        }
                    }
                });
            }
        }
    }

    public void setRemoteDescription(BigInteger bigInteger, SessionDescription sessionDescription) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048608, this, bigInteger, sessionDescription) == null) {
            if (this.executor.isShutdown()) {
                Log.w(TAG, "executor is already shutdown");
            } else {
                this.executor.execute(new Runnable(this, bigInteger, sessionDescription) { // from class: com.baidu.rtc.PeerConnectionClient.13
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ PeerConnectionClient this$0;
                    public final /* synthetic */ BigInteger val$handleId;
                    public final /* synthetic */ SessionDescription val$sdp;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, bigInteger, sessionDescription};
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
                        this.val$sdp = sessionDescription;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        boolean z;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            PeerConnection peerConnection = ((JanusConnection) this.this$0.peerConnectionMap.get(this.val$handleId)).peerConnection;
                            SDPObserver sDPObserver = ((JanusConnection) this.this$0.peerConnectionMap.get(this.val$handleId)).sdpObserver;
                            if (peerConnection != null && !this.this$0.isError) {
                                String str = this.val$sdp.description;
                                SdpPrefer.AudioSdpAttribute audioSdpAttribute = new SdpPrefer.AudioSdpAttribute();
                                boolean z2 = true;
                                if (this.this$0.peerConnectionParameters.audioBitrateMode == RtcParameterSettings.RtcAudioBitrateMode.RTC_AUDIO_BITRATE_CBR) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                audioSdpAttribute.cbr = z;
                                audioSdpAttribute.maxaveragebitrate = this.this$0.peerConnectionParameters.audioMaxkbps;
                                if (this.this$0.peerConnectionParameters.transportAudioChannel != RtcParameterSettings.RtcAudioChannel.RTC_AUDIO_STEREO) {
                                    z2 = false;
                                }
                                audioSdpAttribute.stereo = z2;
                                String audioAttributes = SdpPrefer.setAudioAttributes(this.this$0.peerConnectionParameters.audioCodec, str, audioSdpAttribute);
                                peerConnection.setRemoteDescription(sDPObserver, new SessionDescription(this.val$sdp.type, audioAttributes));
                                ErrorInfoReport.getInstance().putServerMap(this.val$handleId, SdpPrefer.parseRemoteMediaIp(audioAttributes));
                            }
                        }
                    }
                });
            }
        }
    }

    public void subscriberHandleRemoteJsep(BigInteger bigInteger, SessionDescription sessionDescription) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048616, this, bigInteger, sessionDescription) == null) {
            if (this.executor.isShutdown()) {
                Log.w(TAG, "executor is already shutdown");
            } else {
                this.executor.execute(new Runnable(this, bigInteger, sessionDescription) { // from class: com.baidu.rtc.PeerConnectionClient.14
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ PeerConnectionClient this$0;
                    public final /* synthetic */ BigInteger val$handleId;
                    public final /* synthetic */ SessionDescription val$sdp;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, bigInteger, sessionDescription};
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
                        this.val$sdp = sessionDescription;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null && interceptable2.invokeV(1048576, this) != null) {
                            return;
                        }
                        PeerConnection createPeerConnection = this.this$0.createPeerConnection(this.val$handleId, false);
                        SDPObserver sDPObserver = ((JanusConnection) this.this$0.peerConnectionMap.get(this.val$handleId)).sdpObserver;
                        if (createPeerConnection != null && !this.this$0.isError) {
                            createPeerConnection.setRemoteDescription(sDPObserver, this.val$sdp);
                            ErrorInfoReport.getInstance().putServerMap(this.val$handleId, SdpPrefer.parseRemoteMediaIp(this.val$sdp.description));
                            Log.d(PeerConnectionClient.TAG, "PC create ANSWER");
                            createPeerConnection.createAnswer(((JanusConnection) this.this$0.peerConnectionMap.get(this.val$handleId)).sdpObserver, this.this$0.answer_sdpMediaConstraints);
                        }
                    }
                });
            }
        }
    }

    public void closePeer(BigInteger bigInteger) {
        ScheduledExecutorService scheduledExecutorService;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, bigInteger) != null) || (scheduledExecutorService = this.executor) == null || scheduledExecutorService.isShutdown()) {
            return;
        }
        this.executor.execute(new Runnable(this, bigInteger) { // from class: com.baidu.rtc.PeerConnectionClient.7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PeerConnectionClient this$0;
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
                JanusConnection janusConnection;
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.this$0.peerConnectionMap != null && (janusConnection = (JanusConnection) this.this$0.peerConnectionMap.get(this.val$handleId)) != null) {
                    PeerConnection peerConnection = janusConnection.peerConnection;
                    if (peerConnection != null) {
                        peerConnection.close();
                        janusConnection.peerConnection.dispose();
                        janusConnection.peerConnection = null;
                    }
                    SDPObserver sDPObserver = janusConnection.sdpObserver;
                    if (sDPObserver != null) {
                        sDPObserver.close();
                        janusConnection.sdpObserver = null;
                    }
                    PCObserver pCObserver = janusConnection.pcObserver;
                    if (pCObserver != null) {
                        pCObserver.close();
                        janusConnection.pcObserver = null;
                    }
                    this.this$0.peerConnectionMap.remove(this.val$handleId);
                    Log.d(PeerConnectionClient.TAG, "Closing peer connection done.");
                    this.this$0.events.onPeerClosed(this.val$handleId);
                }
            }
        });
    }

    public void createOffer(BigInteger bigInteger) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bigInteger) == null) {
            if (this.executor.isShutdown()) {
                Log.w(TAG, "executor is already shutdown");
            } else {
                this.executor.execute(new Runnable(this, bigInteger) { // from class: com.baidu.rtc.PeerConnectionClient.12
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ PeerConnectionClient this$0;
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
                        JanusConnection janusConnection;
                        PeerConnection peerConnection;
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && (peerConnection = (janusConnection = (JanusConnection) this.this$0.peerConnectionMap.get(this.val$handleId)).peerConnection) != null && !this.this$0.isError) {
                            Log.d(PeerConnectionClient.TAG, "PC Create OFFER");
                            peerConnection.createOffer(janusConnection.sdpObserver, this.this$0.sdpMediaConstraints);
                        }
                    }
                });
            }
        }
    }

    public JanusConnection getJanusConnectionByHandleID(BigInteger bigInteger) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, bigInteger)) == null) {
            return this.peerConnectionMap.get(bigInteger);
        }
        return (JanusConnection) invokeL.objValue;
    }

    @Override // org.webrtc.DataChannel.Observer
    public void onMessage(DataChannel.Buffer buffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, buffer) == null) {
            this.events.onRemoteData(buffer.data);
        }
    }

    public void sendData(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048591, this, byteBuffer) != null) || this.dcPublisher == null) {
            return;
        }
        this.dcPublisher.send(new DataChannel.Buffer(byteBuffer, true));
    }

    public void setAudioChannel(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.mAudioChannel = i;
        }
    }

    public void setAudioEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            if (this.executor.isShutdown()) {
                Log.w(TAG, "executor is already shutdown");
            } else {
                this.executor.execute(new Runnable(this, z) { // from class: com.baidu.rtc.PeerConnectionClient.10
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ PeerConnectionClient this$0;
                    public final /* synthetic */ boolean val$enable;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Boolean.valueOf(z)};
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
                        this.val$enable = z;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.this$0.enableAudio = this.val$enable;
                            if (this.this$0.localAudioTrack != null) {
                                this.this$0.localAudioTrack.setEnabled(this.this$0.enableAudio);
                            }
                            if (this.this$0.adm != null) {
                                this.this$0.adm.setMicrophoneMute(!this.val$enable);
                            }
                        }
                    }
                });
            }
        }
    }

    public void setAudioFreguency(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            this.mAudioFreguency = i;
        }
    }

    public void setAudioSamplesReadyCallback(JavaAudioDeviceModule.SamplesReadyCallback samplesReadyCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, samplesReadyCallback) == null) {
            this.innersamplesReadyCallback = samplesReadyCallback;
        }
    }

    public void setEnableDebugLog(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.mbEnableDebugLog = z;
        }
    }

    public void setEnableSLIReport(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            if (this.executor.isShutdown()) {
                Log.w(TAG, "executor is already shutdown");
            } else {
                this.executor.execute(new Runnable(this, z) { // from class: com.baidu.rtc.PeerConnectionClient.24
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ PeerConnectionClient this$0;
                    public final /* synthetic */ boolean val$enable;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Boolean.valueOf(z)};
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
                        this.val$enable = z;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.this$0.adm != null) {
                            this.this$0.adm.setEnableSLIReport(this.val$enable);
                        }
                    }
                });
            }
        }
    }

    public void setExternalAudioRecord(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.mExternalAudioRecord = z;
        }
    }

    public void setHasAudioRecv(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.mHasAudioRecv = z;
        }
    }

    public void setHasAudioSend(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            this.mHasAudioSend = z;
        }
    }

    public void setHasDataRecv(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            this.mHasDataRecv = z;
        }
    }

    public void setHasDataSend(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            this.mHasDataSend = z;
        }
    }

    public void setHasVideoRecv(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            this.mHasVideoRecv = z;
        }
    }

    public void setHasVideoSend(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            this.mHasVideoSend = z;
        }
    }

    public void setPeerConnectionFactoryOptions(PeerConnectionFactory.Options options) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, options) == null) {
            this.options = options;
        }
    }

    public void setRemoteAudioSamplesReadyCallback(JavaAudioDeviceModule.RemoteSamplesReadyCallback remoteSamplesReadyCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, remoteSamplesReadyCallback) == null) {
            if (this.adm == null) {
                this.mRemoteSamplesReadyCallback = remoteSamplesReadyCallback;
            } else if (this.executor.isShutdown()) {
                Log.w(TAG, "executor is already shutdown");
            } else {
                this.executor.execute(new Runnable(this, remoteSamplesReadyCallback) { // from class: com.baidu.rtc.PeerConnectionClient.6
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ PeerConnectionClient this$0;
                    public final /* synthetic */ JavaAudioDeviceModule.RemoteSamplesReadyCallback val$callback;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, remoteSamplesReadyCallback};
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
                        this.val$callback = remoteSamplesReadyCallback;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.this$0.adm != null) {
                            this.this$0.adm.setRemoteSamplesReadyCallback(this.val$callback);
                        }
                    }
                });
            }
        }
    }

    public void setSpeakerMute(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048609, this, z) == null) {
            if (this.executor.isShutdown()) {
                Log.w(TAG, "executor is already shutdown");
            } else {
                this.executor.execute(new Runnable(this, z) { // from class: com.baidu.rtc.PeerConnectionClient.22
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ PeerConnectionClient this$0;
                    public final /* synthetic */ boolean val$muted;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Boolean.valueOf(z)};
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
                        this.val$muted = z;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.this$0.adm != null) {
                            this.this$0.adm.setSpeakerMute(this.val$muted);
                        }
                    }
                });
            }
        }
    }

    public void setStuckEventListener(SLIReportInterface sLIReportInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, sLIReportInterface) == null) {
            if (this.executor.isShutdown()) {
                Log.w(TAG, "executor is already shutdown");
            } else {
                this.executor.execute(new Runnable(this, sLIReportInterface) { // from class: com.baidu.rtc.PeerConnectionClient.23
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ PeerConnectionClient this$0;
                    public final /* synthetic */ SLIReportInterface val$r;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, sLIReportInterface};
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
                        this.val$r = sLIReportInterface;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.this$0.mStuckEvent = this.val$r;
                            if (this.this$0.adm != null) {
                                this.this$0.adm.setStuckEventListener(this.val$r);
                            }
                        }
                    }
                });
            }
        }
    }

    public void setVideoEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048611, this, z) == null) {
            if (this.executor.isShutdown()) {
                Log.w(TAG, "executor is already shutdown");
            } else {
                this.executor.execute(new Runnable(this, z) { // from class: com.baidu.rtc.PeerConnectionClient.11
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ PeerConnectionClient this$0;
                    public final /* synthetic */ boolean val$enable;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Boolean.valueOf(z)};
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
                        this.val$enable = z;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.this$0.renderVideo = this.val$enable;
                            if (this.this$0.localVideoTrack != null) {
                                this.this$0.localVideoTrack.setEnabled(this.this$0.renderVideo);
                            }
                        }
                    }
                });
            }
        }
    }

    public void setVideoMaxBitrate(final Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, num) == null) {
            if (this.executor.isShutdown()) {
                Log.w(TAG, "executor is already shutdown");
            } else {
                this.executor.execute(new Runnable() { // from class: com.baidu.tieba.rk1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            PeerConnectionClient.this.a(num);
                        }
                    }
                });
            }
        }
    }

    public void changeCaptureFormat(int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, i3) == null) {
            if (this.executor.isShutdown()) {
                Log.w(TAG, "executor is already shutdown");
            } else {
                this.executor.execute(new Runnable(this, i, i2, i3) { // from class: com.baidu.rtc.PeerConnectionClient.21
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ PeerConnectionClient this$0;
                    public final /* synthetic */ int val$framerate;
                    public final /* synthetic */ int val$height;
                    public final /* synthetic */ int val$width;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)};
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
                        this.val$width = i;
                        this.val$height = i2;
                        this.val$framerate = i3;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null && interceptable2.invokeV(1048576, this) != null) {
                            return;
                        }
                        this.this$0.changeCaptureFormatInternal(this.val$width, this.val$height, this.val$framerate);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeCaptureFormatInternal(int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(65575, this, i, i2, i3) == null) {
            if (!this.isError && this.videoCapturer != null) {
                Log.d(TAG, "changeCaptureFormat: " + i + "x" + i2 + "@" + i3);
                this.videoSource.adaptOutputFormat(i, i2, i3);
                return;
            }
            Log.e(TAG, "Failed to change capture format. Video: true. Error : " + this.isError);
        }
    }

    public void createPeerConnectionFactory(Context context, PeerConnectionParameters peerConnectionParameters, PeerConnectionEvents peerConnectionEvents) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, context, peerConnectionParameters, peerConnectionEvents) == null) {
            this.peerConnectionParameters = peerConnectionParameters;
            this.events = peerConnectionEvents;
            this.context = null;
            this.factory = null;
            this.videoCapturerStopped = false;
            this.isError = false;
            this.mediaStream = null;
            this.videoCapturer = null;
            this.renderVideo = !peerConnectionParameters.cameraMuted;
            this.localVideoTrack = null;
            this.remoteVideoTrack = null;
            this.localVideoSender = null;
            this.enableAudio = !peerConnectionParameters.micPhoneMuted;
            this.localAudioTrack = null;
            this.remoteAudioTrack = null;
            this.statsTimer = new Timer();
            if (this.executor.isShutdown()) {
                Log.w(TAG, "executor is already shutdown");
            } else {
                this.executor.execute(new Runnable(this, context) { // from class: com.baidu.rtc.PeerConnectionClient.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ PeerConnectionClient this$0;
                    public final /* synthetic */ Context val$context;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, context};
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
                        this.val$context = context;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.this$0.createPeerConnectionFactoryInternal(this.val$context);
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeInternal() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65576, this) == null) {
            Log.d(TAG, "Closing peer connection.");
            this.statsTimer.cancel();
            ConcurrentHashMap<BigInteger, JanusConnection> concurrentHashMap = this.peerConnectionMap;
            if (concurrentHashMap != null) {
                int size = concurrentHashMap.size();
                for (int i = 0; i < size; i++) {
                    JanusConnection janusConnection = (JanusConnection) this.peerConnectionMap.values().toArray()[i];
                    janusConnection.peerConnection.close();
                    janusConnection.peerConnection.dispose();
                    janusConnection.peerConnection = null;
                    janusConnection.sdpObserver.close();
                }
            }
            Log.d(TAG, "Closing audio source.");
            AudioSource audioSource = this.audioSource;
            if (audioSource != null) {
                audioSource.dispose();
                this.audioSource = null;
            }
            Log.d(TAG, "Stopping capture.");
            VideoCapturer videoCapturer = this.videoCapturer;
            if (videoCapturer != null) {
                try {
                    videoCapturer.stopCapture();
                    this.videoCapturerStopped = true;
                    this.videoCapturer.dispose();
                    this.videoCapturer = null;
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            Log.d(TAG, "Closing video source.");
            VideoSource videoSource = this.videoSource;
            if (videoSource != null) {
                videoSource.dispose();
                this.videoSource = null;
            }
            SurfaceTextureHelper surfaceTextureHelper = this.localTextureHelper;
            if (surfaceTextureHelper != null) {
                surfaceTextureHelper.dispose();
                this.localTextureHelper = null;
            }
            Log.d(TAG, "Closing peer connection factory.");
            PeerConnectionFactory peerConnectionFactory = this.factory;
            if (peerConnectionFactory != null) {
                peerConnectionFactory.dispose();
                this.factory = null;
            }
            this.options = null;
            Log.d(TAG, "Closing peer connection done.");
            this.events.onPeerConnectionClosed();
            PeerConnectionFactory.stopInternalTracingCapture();
            PeerConnectionFactory.shutdownInternalTracer();
        }
    }

    private AudioTrack createAudioTrack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65577, this)) == null) {
            AudioSource createAudioSource = this.factory.createAudioSource(this.audioConstraints);
            this.audioSource = createAudioSource;
            AudioTrack createAudioTrack = this.factory.createAudioTrack(AUDIO_TRACK_ID, createAudioSource);
            this.localAudioTrack = createAudioTrack;
            createAudioTrack.setEnabled(this.enableAudio);
            return this.localAudioTrack;
        }
        return (AudioTrack) invokeV.objValue;
    }

    public static synchronized PeerConnectionClient getInstance() {
        InterceptResult invokeV;
        PeerConnectionClient peerConnectionClient;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65584, null)) == null) {
            synchronized (PeerConnectionClient.class) {
                peerConnectionClient = new PeerConnectionClient();
            }
            return peerConnectionClient;
        }
        return (PeerConnectionClient) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void switchCameraInternal() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65587, this) == null) {
            if (this.videoCapturer instanceof CameraVideoCapturer) {
                Log.d(TAG, "Switch camera");
                ((CameraVideoCapturer) this.videoCapturer).switchCamera(null);
                return;
            }
            Log.d(TAG, "Will not switch camera, video caputurer is not a camera");
        }
    }

    public JavaAudioDeviceModule.ExternalSamplesReadyCallback getExternalSamplesCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.externalSamplesCallback;
        }
        return (JavaAudioDeviceModule.ExternalSamplesReadyCallback) invokeV.objValue;
    }

    public boolean isHDVideo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.videoWidth * this.videoHeight >= 921600) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void startVideoSource() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            if (this.executor.isShutdown()) {
                Log.w(TAG, "executor is already shutdown");
            } else {
                this.executor.execute(new Runnable(this) { // from class: com.baidu.rtc.PeerConnectionClient.16
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ PeerConnectionClient this$0;

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
                        if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.this$0.videoCapturer != null && this.this$0.videoCapturerStopped) {
                            Log.d(PeerConnectionClient.TAG, "Restart video source.");
                            this.this$0.videoCapturer.startCapture(this.this$0.videoWidth, this.this$0.videoHeight, this.this$0.videoFps);
                            this.this$0.videoCapturerStopped = false;
                        }
                    }
                });
            }
        }
    }

    public void stopAudioSource() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            if (this.executor.isShutdown()) {
                Log.w(TAG, "executor is already shutdown");
            } else {
                this.executor.execute(new Runnable(this) { // from class: com.baidu.rtc.PeerConnectionClient.17
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ PeerConnectionClient this$0;

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
                        if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.this$0.audioSource != null) {
                            this.this$0.audioSource.dispose();
                            this.this$0.audioSource = null;
                        }
                    }
                });
            }
        }
    }

    public void stopVideoSource() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            if (this.executor.isShutdown()) {
                Log.w(TAG, "executor is already shutdown");
            } else {
                this.executor.execute(new Runnable(this) { // from class: com.baidu.rtc.PeerConnectionClient.15
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ PeerConnectionClient this$0;

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
                        if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.this$0.videoCapturer != null && !this.this$0.videoCapturerStopped) {
                            Log.d(PeerConnectionClient.TAG, "Stop video source.");
                            try {
                                this.this$0.videoCapturer.stopCapture();
                            } catch (InterruptedException unused) {
                            }
                            this.this$0.videoCapturerStopped = true;
                        }
                    }
                });
            }
        }
    }

    public void switchCamera() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            if (this.executor.isShutdown()) {
                Log.w(TAG, "executor is already shutdown");
            } else {
                this.executor.execute(new Runnable(this) { // from class: com.baidu.rtc.PeerConnectionClient.20
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ PeerConnectionClient this$0;

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
                        if (interceptable2 != null && interceptable2.invokeV(1048576, this) != null) {
                            return;
                        }
                        this.this$0.switchCameraInternal();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createMediaConstraintsInternal() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65578, this) == null) {
            MediaConstraints mediaConstraints = new MediaConstraints();
            this.pcConstraints = mediaConstraints;
            mediaConstraints.optional.add(new MediaConstraints.KeyValuePair(DTLS_SRTP_KEY_AGREEMENT_CONSTRAINT, "true"));
            PeerConnectionParameters peerConnectionParameters = this.peerConnectionParameters;
            int i = peerConnectionParameters.videoWidth;
            this.videoWidth = i;
            int i2 = peerConnectionParameters.videoHeight;
            this.videoHeight = i2;
            this.videoFps = peerConnectionParameters.videoFps;
            if (i == 0 || i2 == 0) {
                this.videoWidth = 1280;
                this.videoHeight = 720;
            }
            if (this.videoFps == 0) {
                this.videoFps = 30;
            }
            Logging.d(TAG, "Capturing format: " + this.videoWidth + "x" + this.videoHeight + "@" + this.videoFps);
            this.audioConstraints = new MediaConstraints();
            if (this.peerConnectionParameters.noAudioProcessing) {
                Log.d(TAG, "Disabling audio processing");
                this.audioConstraints.mandatory.add(new MediaConstraints.KeyValuePair(AUDIO_ECHO_CANCELLATION_CONSTRAINT, "false"));
                this.audioConstraints.mandatory.add(new MediaConstraints.KeyValuePair(AUDIO_AUTO_GAIN_CONTROL_CONSTRAINT, "false"));
                this.audioConstraints.mandatory.add(new MediaConstraints.KeyValuePair(AUDIO_HIGH_PASS_FILTER_CONSTRAINT, "false"));
                this.audioConstraints.mandatory.add(new MediaConstraints.KeyValuePair(AUDIO_NOISE_SUPPRESSION_CONSTRAINT, "false"));
            }
            MediaConstraints mediaConstraints2 = new MediaConstraints();
            this.sdpMediaConstraints = mediaConstraints2;
            if (this.mHasAudioRecv) {
                mediaConstraints2.mandatory.add(new MediaConstraints.KeyValuePair("OfferToReceiveAudio", "true"));
            }
            if (this.mHasVideoRecv) {
                this.sdpMediaConstraints.mandatory.add(new MediaConstraints.KeyValuePair("OfferToReceiveVideo", "true"));
            }
            if (this.mHasDataRecv) {
                this.sdpMediaConstraints.mandatory.add(new MediaConstraints.KeyValuePair("data", "true"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PeerConnection createPeerConnection(BigInteger bigInteger, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65579, this, bigInteger, z)) == null) {
            Log.d(TAG, "Create peer connection.");
            ArrayList arrayList = new ArrayList();
            PeerConnection.IceServer.builder("stun:180.149.142.139:3478").createIceServer();
            PeerConnection.RTCConfiguration rTCConfiguration = new PeerConnection.RTCConfiguration(arrayList);
            if (!this.mHasAudioSend && !this.mHasVideoSend) {
                rTCConfiguration.sdpSemantics = PeerConnection.SdpSemantics.UNIFIED_PLAN;
            }
            rTCConfiguration.audioJitterBufferMaxPackets = this.peerConnectionParameters.audioBufferPackets;
            PCObserver pCObserver = new PCObserver(this);
            SDPObserver sDPObserver = new SDPObserver(this);
            PeerConnection createPeerConnection = this.factory.createPeerConnection(rTCConfiguration, pCObserver);
            JanusConnection janusConnection = new JanusConnection();
            janusConnection.handleId = bigInteger;
            janusConnection.sdpObserver = sDPObserver;
            janusConnection.pcObserver = pCObserver;
            janusConnection.peerConnection = createPeerConnection;
            janusConnection.type = z;
            janusConnection.videoview_tag = -1;
            janusConnection.connectionParam = this.peerConnectionParameters;
            this.peerConnectionMap.put(bigInteger, janusConnection);
            pCObserver.setConnection(janusConnection);
            sDPObserver.setConnection(janusConnection);
            DataChannel.Init init = new DataChannel.Init();
            if (this.mHasData && z) {
                this.dcPublisher = createPeerConnection.createDataChannel("JanusDataChannel", init);
            }
            Log.d(TAG, "Peer connection created.");
            return createPeerConnection;
        }
        return (PeerConnection) invokeLZ.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createPeerConnectionFactoryInternal(Context context) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65580, this, context) == null) {
            if (this.peerConnectionParameters.tracing) {
                PeerConnectionFactory.startInternalTracingCapture(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "webrtc-trace.txt");
            }
            Log.d(TAG, "Create peer connection factory. Use video: true");
            boolean z = false;
            this.isError = false;
            this.preferredVideoCodec = VIDEO_CODEC_VP8;
            String str2 = this.peerConnectionParameters.videoCodec;
            if (str2 != null) {
                if (str2.equals(VIDEO_CODEC_VP9)) {
                    this.preferredVideoCodec = VIDEO_CODEC_VP9;
                } else if (this.peerConnectionParameters.videoCodec.equals(VIDEO_CODEC_H264)) {
                    this.preferredVideoCodec = VIDEO_CODEC_H264;
                }
            }
            Log.d(TAG, "Pereferred video codec: " + this.preferredVideoCodec);
            if (!this.peerConnectionParameters.useOpenSLES) {
                Log.d(TAG, "Disable OpenSL ES audio even if device supports it");
                WebRtcAudioManager.setBlacklistDeviceForOpenSLESUsage(true);
            } else {
                Log.d(TAG, "Allow OpenSL ES audio if device supports it");
                WebRtcAudioManager.setBlacklistDeviceForOpenSLESUsage(false);
            }
            if (this.peerConnectionParameters.disableBuiltInAEC) {
                Log.d(TAG, "Disable built-in AEC even if device supports it");
                WebRtcAudioUtils.setWebRtcBasedAcousticEchoCanceler(true);
            } else {
                Log.d(TAG, "Enable built-in AEC if device supports it");
                WebRtcAudioUtils.setWebRtcBasedAcousticEchoCanceler(false);
            }
            if (this.peerConnectionParameters.disableBuiltInAGC) {
                Log.d(TAG, "Disable built-in AGC even if device supports it");
                WebRtcAudioUtils.setWebRtcBasedAutomaticGainControl(true);
            } else {
                Log.d(TAG, "Enable built-in AGC if device supports it");
                WebRtcAudioUtils.setWebRtcBasedAutomaticGainControl(false);
            }
            if (this.peerConnectionParameters.disableBuiltInNS) {
                Log.d(TAG, "Disable built-in NS even if device supports it");
                WebRtcAudioUtils.setWebRtcBasedNoiseSuppressor(true);
            } else {
                Log.d(TAG, "Enable built-in NS if device supports it");
                WebRtcAudioUtils.setWebRtcBasedNoiseSuppressor(false);
            }
            this.context = context;
            MediaConstraints mediaConstraints = new MediaConstraints();
            this.answer_sdpMediaConstraints = mediaConstraints;
            mediaConstraints.mandatory.add(new MediaConstraints.KeyValuePair("OfferToReceiveAudio", "true"));
            this.answer_sdpMediaConstraints.mandatory.add(new MediaConstraints.KeyValuePair("OfferToReceiveVideo", "true"));
            if (this.peerConnectionParameters.enableFEC) {
                str = "WebRTC-FlexFEC-03-Advertised/Enabled/WebRTC-FlexFEC-03/Enabled/";
            } else {
                str = "";
            }
            if (this.peerConnectionParameters.enableFixedResolution) {
                str = str + "BRTC.Fixed.Resolution/Enabled/";
            }
            int i = this.peerConnectionParameters.encodeBitrateMode;
            if (i == 0 || i == 1 || i == 2) {
                str = str + "BRTC-Encoder-BitrateMode/" + this.peerConnectionParameters.encodeBitrateMode + "/";
            }
            if (this.peerConnectionParameters.enableHighProfile) {
                str = (str + "WebRTC-H264HighProfile/Enabled/") + "WebRTC-MediaTekH264/Enabled/";
            }
            if (this.peerConnectionParameters.enableHisiH264HW) {
                str = str + "BRTC.HisiH264HW/Enabled/";
            }
            if (this.peerConnectionParameters.enableMTKH264Decode) {
                str = str + "BRTC.MTK.H264.Decode/Enabled/";
            }
            if (this.peerConnectionParameters.audioPlayoutDelay >= 0) {
                str = str + "BRTC.Playout.Delay.AudioOnly/" + this.peerConnectionParameters.audioPlayoutDelay + "/";
            }
            if (this.peerConnectionParameters.audioCodecComplex >= 0) {
                str = str + "BRTC.Opus.Complexity/" + this.peerConnectionParameters.audioCodecComplex + "/";
            }
            if (this.peerConnectionParameters.enableAACCodec) {
                str = str + "BRTC.Aac.Codec/Enabled/";
            }
            int i2 = 0;
            while (true) {
                if (i2 >= MediaCodecList.getCodecCount()) {
                    break;
                }
                MediaCodecInfo mediaCodecInfo = null;
                try {
                    mediaCodecInfo = MediaCodecList.getCodecInfoAt(i2);
                } catch (IllegalArgumentException e) {
                    Logging.e(TAG, "Cannot retrieve encoder codec info", e);
                }
                if (mediaCodecInfo != null && mediaCodecInfo.isEncoder() && mediaCodecInfo.getName().startsWith(MediaCodecVideoDecoder.supportedHisiH264HighProfileHwCodecPrefix)) {
                    z = true;
                    break;
                }
                i2++;
            }
            if (this.peerConnectionParameters.enableRequiredResolutionAligment32 || z) {
                str = str + "BRTC.Required.Resolustion.Aligment32/Enabled/";
            }
            PeerConnectionFactory.initialize(PeerConnectionFactory.InitializationOptions.builder(context).setFieldTrials(str).createInitializationOptions());
            AudioDeviceModule createJavaAudioDevice = createJavaAudioDevice();
            this.adm = (JavaAudioDeviceModule) createJavaAudioDevice;
            MediaCodecVideoDecoder.setVideoDecoderObserver(new VideoDecoderObserver(this.events));
            this.factory = PeerConnectionFactory.builder().setAudioDeviceModule(createJavaAudioDevice).setVideoDecoderFactory(MediaCodecVideoDecoder.createFactory()).setVideoEncoderFactory(MediaCodecVideoEncoder.createFactory()).createPeerConnectionFactory();
            Log.d(TAG, "Peer connection factory created.");
            createJavaAudioDevice.release();
            if (this.mbEnableDebugLog) {
                Logging.enableLogThreads();
                Logging.enableLogTimeStamps();
                Logging.enableLogToDebugOutput(Logging.Severity.LS_VERBOSE);
                return;
            }
            Logging.enableLogToDebugOutput(Logging.Severity.LS_ERROR);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createPeerConnectionInternal(EglBase.Context context, BigInteger bigInteger) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65581, this, context, bigInteger) == null) {
            if (this.factory != null && !this.isError) {
                Log.d(TAG, "PCConstraints: " + this.pcConstraints.toString());
                Log.d(TAG, "EGLContext: " + context);
                PeerConnection createPeerConnection = createPeerConnection(bigInteger, true);
                boolean z2 = this.mHasAudioSend;
                if (!z2 && !(z = this.mHasVideoSend)) {
                    if (!z2 && !z) {
                        createPeerConnection.addTransceiver(MediaStreamTrack.MediaType.MEDIA_TYPE_AUDIO, new RtpTransceiver.RtpTransceiverInit(RtpTransceiver.RtpTransceiverDirection.RECV_ONLY));
                        createPeerConnection.addTransceiver(MediaStreamTrack.MediaType.MEDIA_TYPE_VIDEO, new RtpTransceiver.RtpTransceiverInit(RtpTransceiver.RtpTransceiverDirection.RECV_ONLY));
                        return;
                    }
                    return;
                }
                MediaStream createLocalMediaStream = this.factory.createLocalMediaStream("ARDAMS");
                this.mediaStream = createLocalMediaStream;
                if (this.mHasVideoSend) {
                    createLocalMediaStream.addTrack(createVideoTrack(context, this.videoCapturer));
                }
                if (this.mHasAudioSend) {
                    this.mediaStream.addTrack(createAudioTrack());
                }
                createPeerConnection.addStream(this.mediaStream);
                findVideoSender(bigInteger);
                return;
            }
            Log.e(TAG, "Peerconnection factory is not created");
        }
    }

    private VideoTrack createVideoTrack(EglBase.Context context, VideoCapturer videoCapturer) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65582, this, context, videoCapturer)) == null) {
            this.videoSource = this.factory.createVideoSource(false);
            SurfaceTextureHelper create = SurfaceTextureHelper.create("video renderer", context);
            this.localTextureHelper = create;
            videoCapturer.initialize(create, this.context, this.videoSource.getCapturerObserver());
            videoCapturer.startCapture(this.videoWidth, this.videoHeight, this.videoFps);
            VideoTrack createVideoTrack = this.factory.createVideoTrack(VIDEO_TRACK_ID, this.videoSource);
            this.localVideoTrack = createVideoTrack;
            createVideoTrack.setEnabled(this.renderVideo);
            this.localVideoTrack.addSink(this.localRender);
            return this.localVideoTrack;
        }
        return (VideoTrack) invokeLL.objValue;
    }

    private void findVideoSender(BigInteger bigInteger) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65583, this, bigInteger) == null) {
            for (RtpSender rtpSender : this.peerConnectionMap.get(bigInteger).peerConnection.getSenders()) {
                if (rtpSender.track() != null && rtpSender.track().kind().equals("video")) {
                    Log.d(TAG, "Found video sender.");
                    this.localVideoSender = rtpSender;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getStats(BigInteger bigInteger, StatsEventsType statsEventsType) {
        ConcurrentHashMap<BigInteger, JanusConnection> concurrentHashMap;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65585, this, bigInteger, statsEventsType) == null) && (concurrentHashMap = this.peerConnectionMap) != null && concurrentHashMap.get(bigInteger) != null && this.peerConnectionMap.get(bigInteger).peerConnection != null && !this.peerConnectionMap.get(bigInteger).peerConnection.getStats(new StatsObserver(this, bigInteger, statsEventsType) { // from class: com.baidu.rtc.PeerConnectionClient.8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PeerConnectionClient this$0;
            public final /* synthetic */ StatsEventsType val$eventsType;
            public final /* synthetic */ BigInteger val$handleId;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, bigInteger, statsEventsType};
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
                this.val$eventsType = statsEventsType;
            }

            @Override // org.webrtc.StatsObserver
            public void onComplete(StatsReport[] statsReportArr) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, statsReportArr) == null) {
                    this.this$0.events.onPeerConnectionStatsReady(statsReportArr, this.val$handleId, this.val$eventsType);
                }
            }
        }, null)) {
            Log.e(TAG, "getStats() returns false!");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportError(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65586, this, str) == null) {
            Log.e(TAG, "Peerconnection error: " + str);
            if (this.executor.isShutdown()) {
                Log.w(TAG, "executor is already shutdown");
            } else {
                this.executor.execute(new Runnable(this, str) { // from class: com.baidu.rtc.PeerConnectionClient.19
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ PeerConnectionClient this$0;
                    public final /* synthetic */ String val$errorMessage;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, str};
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
                        this.val$errorMessage = str;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && !this.this$0.isError) {
                            this.this$0.events.onPeerConnectionError(this.val$errorMessage);
                            this.this$0.isError = true;
                        }
                    }
                });
            }
        }
    }

    public /* synthetic */ void a(Integer num) {
        Integer valueOf;
        if (this.localVideoSender == null) {
            return;
        }
        Log.d(TAG, "Requested max video bitrate: " + num);
        RtpSender rtpSender = this.localVideoSender;
        if (rtpSender == null) {
            Log.w(TAG, "Sender is not ready.");
            return;
        }
        RtpParameters parameters = rtpSender.getParameters();
        if (parameters.encodings.size() == 0) {
            Log.w(TAG, "RtpParameters are not ready.");
            return;
        }
        for (RtpParameters.Encoding encoding : parameters.encodings) {
            if (num == null) {
                valueOf = null;
            } else {
                valueOf = Integer.valueOf(num.intValue() * 1000);
            }
            encoding.maxBitrateBps = valueOf;
        }
        if (!this.localVideoSender.setParameters(parameters)) {
            Log.e(TAG, "RtpSender.setParameters failed.");
        }
        Log.d(TAG, "Configured max video bitrate to: " + num);
    }

    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            MediaCodecVideoDecoder.setVideoDecoderObserver(null);
            try {
                this.executor.execute(new Runnable(this) { // from class: com.baidu.rtc.PeerConnectionClient.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ PeerConnectionClient this$0;

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
                        if (interceptable2 != null && interceptable2.invokeV(1048576, this) != null) {
                            return;
                        }
                        this.this$0.closeInternal();
                    }
                });
                this.executor.shutdown();
                this.executor.awaitTermination(200L, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                Log.d(TAG, "pc close interrupted exception:" + e.getMessage());
            } catch (Exception e2) {
                Log.d(TAG, "pc close exception:" + e2.getMessage());
            }
        }
    }

    public void createPeerConnection(EglBase.Context context, VideoSink videoSink, VideoCapturer videoCapturer, BigInteger bigInteger) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048582, this, context, videoSink, videoCapturer, bigInteger) == null) {
            if (this.peerConnectionParameters == null) {
                Log.e(TAG, "Creating peer connection without initializing factory.");
                return;
            }
            this.localRender = videoSink;
            this.videoCapturer = videoCapturer;
            if (this.executor.isShutdown()) {
                Log.w(TAG, "executor is already shutdown");
            } else {
                this.executor.execute(new Runnable(this, context, bigInteger) { // from class: com.baidu.rtc.PeerConnectionClient.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ PeerConnectionClient this$0;
                    public final /* synthetic */ BigInteger val$handleId;
                    public final /* synthetic */ EglBase.Context val$renderEGLContext;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, context, bigInteger};
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
                        this.val$renderEGLContext = context;
                        this.val$handleId = bigInteger;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null && interceptable2.invokeV(1048576, this) != null) {
                            return;
                        }
                        try {
                            this.this$0.createMediaConstraintsInternal();
                            this.this$0.createPeerConnectionInternal(this.val$renderEGLContext, this.val$handleId);
                        } catch (Exception e) {
                            PeerConnectionClient peerConnectionClient = this.this$0;
                            peerConnectionClient.reportError("Failed to create peer connection: " + e.getMessage());
                            ErrorInfoReport.getInstance().reportErrorInfo(ErrorInfoReport.ErrorCode.PEERCONNECTION_CREATE_ERROR);
                            throw e;
                        }
                    }
                });
            }
        }
    }

    public void enableStatsEvents(boolean z, int i, BigInteger bigInteger, StatsEventsType statsEventsType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), bigInteger, statsEventsType}) == null) {
            TimerTask timerTask = null;
            if (z) {
                try {
                    if (statsEventsType == StatsEventsType.GET_AUDIOLEVEL_EVENT) {
                        timerTask = this.timerTaskGetVolumeMap.get(bigInteger);
                    } else if (statsEventsType == StatsEventsType.GET_QUALITY_MONITOR_EVENT) {
                        timerTask = this.timerTaskGetQualityMap.get(bigInteger);
                    } else if (statsEventsType == StatsEventsType.GET_SLI_EVENT) {
                        timerTask = this.timerTaskGetSLIMap.get(bigInteger);
                    }
                    if (timerTask != null) {
                        timerTask.cancel();
                    }
                    TimerTask timerTask2 = new TimerTask(this, bigInteger, statsEventsType) { // from class: com.baidu.rtc.PeerConnectionClient.9
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ PeerConnectionClient this$0;
                        public final /* synthetic */ StatsEventsType val$eventsType;
                        public final /* synthetic */ BigInteger val$handleId;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, bigInteger, statsEventsType};
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
                            this.val$eventsType = statsEventsType;
                        }

                        @Override // java.util.TimerTask, java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null && interceptable2.invokeV(1048576, this) != null) {
                                return;
                            }
                            this.this$0.getStats(this.val$handleId, this.val$eventsType);
                        }
                    };
                    if (statsEventsType == StatsEventsType.GET_AUDIOLEVEL_EVENT) {
                        this.timerTaskGetVolumeMap.put(bigInteger, timerTask2);
                    } else if (statsEventsType == StatsEventsType.GET_QUALITY_MONITOR_EVENT) {
                        this.timerTaskGetQualityMap.put(bigInteger, timerTask2);
                    } else if (statsEventsType == StatsEventsType.GET_SLI_EVENT) {
                        this.timerTaskGetSLIMap.put(bigInteger, timerTask2);
                    }
                    this.statsTimer.schedule(timerTask2, 0L, i);
                    return;
                } catch (Exception e) {
                    Log.e(TAG, "Can not schedule statistics timer", e);
                    return;
                }
            }
            if (statsEventsType == StatsEventsType.GET_AUDIOLEVEL_EVENT) {
                timerTask = this.timerTaskGetVolumeMap.get(bigInteger);
            } else if (statsEventsType == StatsEventsType.GET_QUALITY_MONITOR_EVENT) {
                timerTask = this.timerTaskGetQualityMap.get(bigInteger);
            } else if (statsEventsType == StatsEventsType.GET_SLI_EVENT) {
                timerTask = this.timerTaskGetSLIMap.get(bigInteger);
            }
            if (timerTask != null) {
                timerTask.cancel();
            }
        }
    }
}
