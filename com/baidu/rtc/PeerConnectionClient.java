package com.baidu.rtc;

import android.content.Context;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.baidu.rtc.RtcParameterSettings;
import com.baidu.rtc.SdpPrefer;
import com.baidu.rtc.logreport.ErrorInfoReport;
import com.baidu.rtc.logreport.SLIReportInterface;
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
    public ParcelFileDescriptor aecDumpFileDescriptor;
    public MediaConstraints answer_sdpMediaConstraints;
    public MediaConstraints audioConstraints;
    public AudioSource audioSource;
    public Context context;
    public boolean enableAudio;
    public PeerConnectionEvents events;
    public JavaAudioDeviceModule.ExternalSamplesReadyCallback externalSamplesCallback;
    public PeerConnectionFactory factory;
    public JavaAudioDeviceModule.SamplesReadyCallback innersamplesReadyCallback;
    public boolean isError;
    public AudioTrack localAudioTrack;
    public VideoSink localRender;
    public SurfaceTextureHelper localTextureHelper;
    public RtpSender localVideoSender;
    public VideoTrack localVideoTrack;
    public boolean mExternalAudioRecord;
    public JavaAudioDeviceModule.RemoteSamplesReadyCallback mRemoteSamplesReadyCallback;
    public MediaStream mediaStream;
    public MediaConstraints pcConstraints;
    public PeerConnectionParameters peerConnectionParameters;
    public String preferredVideoCodec;
    public AudioTrack remoteAudioTrack;
    public VideoTrack remoteVideoTrack;
    public boolean renderVideo;
    public MediaConstraints sdpMediaConstraints;
    public Timer statsTimer;
    public VideoCapturer videoCapturer;
    public boolean videoCapturerStopped;
    public int videoFps;
    public int videoHeight;
    public VideoSource videoSource;
    public int videoWidth;
    public int videokbps;
    public PeerConnectionFactory.Options options = null;
    public Map<BigInteger, TimerTask> timerTaskGetVolumeMap = new ConcurrentHashMap();
    public Map<BigInteger, TimerTask> timerTaskGetQualityMap = new ConcurrentHashMap();
    public Map<BigInteger, TimerTask> timerTaskGetSLIMap = new ConcurrentHashMap();
    public boolean mHasVideo = true;
    public boolean mHasAudio = true;
    public boolean mHasData = false;
    public int mAudioFreguency = 48000;
    public int mAudioChannel = 1;
    public boolean isEnableFEC = true;
    public DataChannel dcPublisher = null;
    public Map<BigInteger, Integer> remoteLevels = new ConcurrentHashMap();
    public SLIReportInterface mStuckEvent = null;
    public boolean mbEnableDebugLog = false;
    public JavaAudioDeviceModule adm = null;
    public final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
    public ConcurrentHashMap<BigInteger, JanusConnection> peerConnectionMap = new ConcurrentHashMap<>();

    /* loaded from: classes2.dex */
    public class PCObserver implements PeerConnection.Observer {
        public JanusConnection connection;
        public PeerConnection peerConnection;

        public PCObserver() {
        }

        @Override // org.webrtc.PeerConnection.Observer
        public void onAddStream(final MediaStream mediaStream) {
            if (PeerConnectionClient.this.executor.isShutdown()) {
                Log.w(PeerConnectionClient.TAG, "executor is already shutdown");
            } else {
                PeerConnectionClient.this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.PCObserver.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (PCObserver.this.peerConnection == null || PeerConnectionClient.this.isError) {
                            return;
                        }
                        Log.d(PeerConnectionClient.TAG, "=========== onAddStream ==========");
                        if (mediaStream.audioTracks.size() == 1) {
                            PeerConnectionClient.this.remoteAudioTrack = mediaStream.audioTracks.get(0);
                            PCObserver.this.connection.audioTrack = PeerConnectionClient.this.remoteAudioTrack;
                        }
                        if (mediaStream.videoTracks.size() == 1) {
                            PeerConnectionClient.this.remoteVideoTrack = mediaStream.videoTracks.get(0);
                            PeerConnectionClient.this.remoteVideoTrack.setEnabled(true);
                            PCObserver.this.connection.videoTrack = PeerConnectionClient.this.remoteVideoTrack;
                            PeerConnectionClient.this.events.onRemoteRender(PCObserver.this.connection);
                        }
                        Boolean bool = Boolean.FALSE;
                        Boolean bool2 = mediaStream.videoTracks.size() != 0 ? Boolean.TRUE : bool;
                        if (mediaStream.audioTracks.size() != 0) {
                            bool = Boolean.TRUE;
                        }
                        PeerConnectionClient.this.events.onRemoteStreamStats(bool2, bool, PCObserver.this.connection.handleId);
                    }
                });
            }
        }

        @Override // org.webrtc.PeerConnection.Observer
        public void onAddTrack(RtpReceiver rtpReceiver, MediaStream[] mediaStreamArr) {
            Log.d(PeerConnectionClient.TAG, "testing ... add track");
        }

        @Override // org.webrtc.PeerConnection.Observer
        @CalledByNative("Observer")
        public void onConnectionChange(PeerConnection.PeerConnectionState peerConnectionState) {
            PeerConnection.Observer_CC.$default$onConnectionChange(this, peerConnectionState);
        }

        @Override // org.webrtc.PeerConnection.Observer
        public void onDataChannel(DataChannel dataChannel) {
            Log.d(PeerConnectionClient.TAG, "New Data channel " + dataChannel.label());
            dataChannel.registerObserver(PeerConnectionClient.this);
        }

        @Override // org.webrtc.PeerConnection.Observer
        public void onIceCandidate(final IceCandidate iceCandidate) {
            if (PeerConnectionClient.this.executor.isShutdown()) {
                Log.w(PeerConnectionClient.TAG, "executor is already shutdown");
            } else {
                PeerConnectionClient.this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.PCObserver.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PeerConnectionClient.this.events.onIceCandidate(iceCandidate, PCObserver.this.connection.handleId);
                    }
                });
            }
        }

        @Override // org.webrtc.PeerConnection.Observer
        public void onIceCandidatesRemoved(final IceCandidate[] iceCandidateArr) {
            if (PeerConnectionClient.this.executor.isShutdown()) {
                Log.w(PeerConnectionClient.TAG, "executor is already shutdown");
            } else {
                PeerConnectionClient.this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.PCObserver.2
                    @Override // java.lang.Runnable
                    public void run() {
                        PeerConnectionClient.this.events.onIceCandidatesRemoved(iceCandidateArr);
                    }
                });
            }
        }

        @Override // org.webrtc.PeerConnection.Observer
        public void onIceConnectionChange(final PeerConnection.IceConnectionState iceConnectionState) {
            if (PeerConnectionClient.this.executor.isShutdown()) {
                Log.w(PeerConnectionClient.TAG, "executor is already shutdown");
            } else {
                PeerConnectionClient.this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.PCObserver.3
                    @Override // java.lang.Runnable
                    public void run() {
                        Log.d(PeerConnectionClient.TAG, "IceConnectionState: " + iceConnectionState);
                        PeerConnection.IceConnectionState iceConnectionState2 = iceConnectionState;
                        if (iceConnectionState2 == PeerConnection.IceConnectionState.CONNECTED) {
                            PeerConnectionClient.this.events.onIceConnected();
                        } else if (iceConnectionState2 == PeerConnection.IceConnectionState.DISCONNECTED) {
                            PeerConnectionClient.this.events.onIceDisconnected();
                        } else if (iceConnectionState2 == PeerConnection.IceConnectionState.FAILED) {
                            PeerConnectionClient.this.events.onIceFailed();
                        }
                    }
                });
            }
        }

        @Override // org.webrtc.PeerConnection.Observer
        public void onIceConnectionReceivingChange(boolean z) {
            Log.d(PeerConnectionClient.TAG, "IceConnectionReceiving changed to " + z);
        }

        @Override // org.webrtc.PeerConnection.Observer
        public void onIceGatheringChange(PeerConnection.IceGatheringState iceGatheringState) {
            Log.d(PeerConnectionClient.TAG, "IceGatheringState: " + iceGatheringState);
        }

        @Override // org.webrtc.PeerConnection.Observer
        public void onRemoveStream(MediaStream mediaStream) {
            if (PeerConnectionClient.this.executor.isShutdown()) {
                Log.w(PeerConnectionClient.TAG, "executor is already shutdown");
            } else {
                PeerConnectionClient.this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.PCObserver.5
                    @Override // java.lang.Runnable
                    public void run() {
                        PeerConnectionClient.this.remoteVideoTrack = null;
                        PeerConnectionClient.this.remoteAudioTrack = null;
                    }
                });
            }
        }

        @Override // org.webrtc.PeerConnection.Observer
        public void onRenegotiationNeeded() {
        }

        @Override // org.webrtc.PeerConnection.Observer
        public void onSignalingChange(PeerConnection.SignalingState signalingState) {
            Log.d(PeerConnectionClient.TAG, "SignalingState: " + signalingState);
        }

        @Override // org.webrtc.PeerConnection.Observer
        @CalledByNative("Observer")
        public void onTrack(RtpTransceiver rtpTransceiver) {
            PeerConnection.Observer_CC.$default$onTrack(this, rtpTransceiver);
        }

        public void setConnection(JanusConnection janusConnection) {
            this.connection = janusConnection;
            this.peerConnection = janusConnection.peerConnection;
        }
    }

    /* loaded from: classes2.dex */
    public interface PeerConnectionEvents {
        void onIceCandidate(IceCandidate iceCandidate, BigInteger bigInteger);

        void onIceCandidatesRemoved(IceCandidate[] iceCandidateArr);

        void onIceConnected();

        void onIceDisconnected();

        void onIceFailed();

        void onLocalDescription(SessionDescription sessionDescription, BigInteger bigInteger, boolean z);

        void onPeerConnectionClosed();

        void onPeerConnectionError(String str);

        void onPeerConnectionStatsReady(StatsReport[] statsReportArr, BigInteger bigInteger, StatsEventsType statsEventsType);

        void onRemoteData(ByteBuffer byteBuffer);

        void onRemoteDescription(SessionDescription sessionDescription, BigInteger bigInteger);

        void onRemoteRender(JanusConnection janusConnection);

        void onRemoteStreamStats(Boolean bool, Boolean bool2, BigInteger bigInteger);
    }

    /* loaded from: classes2.dex */
    public static class PeerConnectionParameters {
        public RtcParameterSettings.RtcAudioBitrateMode audioBitrateMode;
        public final int audioBufferPackets;
        public final String audioCodec;
        public final int audioCodecComplex;
        public final int audioMaxkbps;
        public final int audioPlayoutDelay;
        public final int audioSource;
        public final int audioStartBitrate;
        public final boolean cameraMuted;
        public final boolean disableBuiltInAEC;
        public final boolean disableBuiltInAGC;
        public final boolean disableBuiltInNS;
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

        public PeerConnectionParameters(boolean z, int i2, int i3, int i4, String str, boolean z2, int i5, String str2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, int i6, int i7, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, boolean z13, int i8, RtcParameterSettings.RtcAudioBitrateMode rtcAudioBitrateMode, RtcParameterSettings.RtcAudioChannel rtcAudioChannel, int i9, boolean z14, boolean z15, int i10, int i11, int i12, int i13) {
            this.tracing = z;
            this.videoWidth = i2;
            this.videoHeight = i3;
            this.videoFps = i4;
            this.videoCodec = str;
            this.videoCodecHwAcceleration = z2;
            this.audioStartBitrate = i5;
            this.audioCodec = str2;
            this.noAudioProcessing = z3;
            this.useOpenSLES = z4;
            this.disableBuiltInAEC = z5;
            this.disableBuiltInAGC = z6;
            this.disableBuiltInNS = z7;
            this.videoMaxkbps = i6;
            this.videoMinkbps = i7;
            this.micPhoneMuted = z8;
            this.cameraMuted = z9;
            this.enableFEC = z10;
            this.enableFixedResolution = z11;
            this.enableRequiredResolutionAligment32 = z12;
            this.enableHighProfile = z13;
            this.audioMaxkbps = i8;
            this.audioBitrateMode = rtcAudioBitrateMode;
            this.transportAudioChannel = rtcAudioChannel;
            this.encodeBitrateMode = i9;
            this.enableHisiH264HW = z14;
            this.enableMTKH264Decode = z15;
            this.audioSource = i10;
            this.audioBufferPackets = i11;
            this.audioPlayoutDelay = i12;
            this.audioCodecComplex = i13;
        }
    }

    /* loaded from: classes2.dex */
    public class SDPObserver implements SdpObserver {
        public PeerConnectionParameters connectionParam;
        public BigInteger handleId;
        public SessionDescription localSdp;
        public PeerConnection peerConnection;
        public SDPObserver sdpObserver;
        public boolean type;

        public SDPObserver() {
        }

        public void close() {
            this.peerConnection = null;
        }

        @Override // org.webrtc.SdpObserver
        public void onCreateFailure(String str) {
            PeerConnectionClient peerConnectionClient = PeerConnectionClient.this;
            peerConnectionClient.reportError("createSDP error: " + str);
            ErrorInfoReport.getInstance().reportErrorInfo(ErrorInfoReport.ErrorCode.PEERCONNECTION_CREATE_ERROR);
        }

        @Override // org.webrtc.SdpObserver
        public void onCreateSuccess(SessionDescription sessionDescription) {
            Log.e(PeerConnectionClient.TAG, "SDP on create success");
            final SessionDescription sessionDescription2 = new SessionDescription(sessionDescription.type, sessionDescription.description);
            this.localSdp = sessionDescription2;
            if (PeerConnectionClient.this.executor.isShutdown()) {
                Log.w(PeerConnectionClient.TAG, "executor is already shutdown");
            } else {
                PeerConnectionClient.this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.SDPObserver.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (SDPObserver.this.peerConnection == null || PeerConnectionClient.this.isError) {
                            return;
                        }
                        Log.d(PeerConnectionClient.TAG, "Set local SDP from " + sessionDescription2.type);
                        SDPObserver.this.peerConnection.setLocalDescription(SDPObserver.this.sdpObserver, sessionDescription2);
                    }
                });
            }
        }

        @Override // org.webrtc.SdpObserver
        public void onSetFailure(String str) {
            PeerConnectionClient peerConnectionClient = PeerConnectionClient.this;
            peerConnectionClient.reportError("setSDP error: " + str);
            ErrorInfoReport.getInstance().reportErrorInfo(ErrorInfoReport.ErrorCode.PEERCONNECTION_CREATE_ERROR);
        }

        @Override // org.webrtc.SdpObserver
        public void onSetSuccess() {
            if (PeerConnectionClient.this.executor.isShutdown()) {
                Log.w(PeerConnectionClient.TAG, "executor is already shutdown");
            } else {
                PeerConnectionClient.this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.SDPObserver.2
                    @Override // java.lang.Runnable
                    public void run() {
                        String str;
                        if (SDPObserver.this.peerConnection == null || PeerConnectionClient.this.isError) {
                            return;
                        }
                        if (SDPObserver.this.type) {
                            if (SDPObserver.this.peerConnection.getRemoteDescription() == null) {
                                Log.d(PeerConnectionClient.TAG, "Local SDP set succesfully");
                                PeerConnectionClient.this.events.onLocalDescription(SDPObserver.this.localSdp, SDPObserver.this.handleId, SDPObserver.this.localSdp.description.contains("profile-level-id=640c1f"));
                                return;
                            }
                            str = "Remote SDP set succesfully";
                        } else if (SDPObserver.this.peerConnection.getLocalDescription() != null) {
                            Log.d(PeerConnectionClient.TAG, "answer Local SDP set succesfully");
                            PeerConnectionClient.this.events.onRemoteDescription(SDPObserver.this.localSdp, SDPObserver.this.handleId);
                            return;
                        } else {
                            str = "answer Remote SDP set succesfully";
                        }
                        Log.d(PeerConnectionClient.TAG, str);
                    }
                });
            }
        }

        public void setConnection(JanusConnection janusConnection) {
            this.peerConnection = janusConnection.peerConnection;
            this.sdpObserver = janusConnection.sdpObserver;
            this.handleId = janusConnection.handleId;
            this.type = janusConnection.type;
            this.connectionParam = janusConnection.connectionParam;
        }
    }

    /* loaded from: classes2.dex */
    public enum StatsEventsType {
        GET_AUDIOLEVEL_EVENT,
        GET_QUALITY_MONITOR_EVENT,
        GET_BWE_EVENT,
        GET_SLI_EVENT
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeCaptureFormatInternal(int i2, int i3, int i4) {
        if (this.isError || this.videoCapturer == null) {
            Log.e(TAG, "Failed to change capture format. Video: true. Error : " + this.isError);
            return;
        }
        Log.d(TAG, "changeCaptureFormat: " + i2 + "x" + i3 + "@" + i4);
        this.videoSource.adaptOutputFormat(i2, i3, i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeInternal() {
        Log.d(TAG, "Closing peer connection.");
        this.statsTimer.cancel();
        ConcurrentHashMap<BigInteger, JanusConnection> concurrentHashMap = this.peerConnectionMap;
        if (concurrentHashMap != null) {
            int size = concurrentHashMap.size();
            for (int i2 = 0; i2 < size; i2++) {
                JanusConnection janusConnection = (JanusConnection) this.peerConnectionMap.values().toArray()[i2];
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
            } catch (InterruptedException e2) {
                throw new RuntimeException(e2);
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

    private AudioTrack createAudioTrack() {
        AudioSource createAudioSource = this.factory.createAudioSource(this.audioConstraints);
        this.audioSource = createAudioSource;
        AudioTrack createAudioTrack = this.factory.createAudioTrack(AUDIO_TRACK_ID, createAudioSource);
        this.localAudioTrack = createAudioTrack;
        createAudioTrack.setEnabled(this.enableAudio);
        return this.localAudioTrack;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createMediaConstraintsInternal() {
        MediaConstraints mediaConstraints = new MediaConstraints();
        this.pcConstraints = mediaConstraints;
        mediaConstraints.optional.add(new MediaConstraints.KeyValuePair(DTLS_SRTP_KEY_AGREEMENT_CONSTRAINT, "true"));
        PeerConnectionParameters peerConnectionParameters = this.peerConnectionParameters;
        int i2 = peerConnectionParameters.videoWidth;
        this.videoWidth = i2;
        int i3 = peerConnectionParameters.videoHeight;
        this.videoHeight = i3;
        this.videoFps = peerConnectionParameters.videoFps;
        if (i2 == 0 || i3 == 0) {
            this.videoWidth = 1280;
            this.videoHeight = HD_VIDEO_HEIGHT;
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
        if (this.mHasAudio) {
            mediaConstraints2.mandatory.add(new MediaConstraints.KeyValuePair("OfferToReceiveAudio", "true"));
        }
        if (this.mHasVideo) {
            this.sdpMediaConstraints.mandatory.add(new MediaConstraints.KeyValuePair("OfferToReceiveVideo", "true"));
        }
        if (this.mHasData) {
            this.sdpMediaConstraints.mandatory.add(new MediaConstraints.KeyValuePair("data", "true"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PeerConnection createPeerConnection(BigInteger bigInteger, boolean z) {
        Log.d(TAG, "Create peer connection.");
        ArrayList arrayList = new ArrayList();
        PeerConnection.IceServer.builder("stun:180.149.142.139:3478").createIceServer();
        PeerConnection.RTCConfiguration rTCConfiguration = new PeerConnection.RTCConfiguration(arrayList);
        rTCConfiguration.audioJitterBufferMaxPackets = this.peerConnectionParameters.audioBufferPackets;
        PCObserver pCObserver = new PCObserver();
        SDPObserver sDPObserver = new SDPObserver();
        PeerConnection createPeerConnection = this.factory.createPeerConnection(rTCConfiguration, pCObserver);
        JanusConnection janusConnection = new JanusConnection();
        janusConnection.handleId = bigInteger;
        janusConnection.sdpObserver = sDPObserver;
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

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0051, code lost:
        if (r2.equals(com.baidu.rtc.PeerConnectionClient.VIDEO_CODEC_H264) != false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void createPeerConnectionFactoryInternal(Context context) {
        Logging.Severity severity;
        if (this.peerConnectionParameters.tracing) {
            PeerConnectionFactory.startInternalTracingCapture(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "webrtc-trace.txt");
        }
        Log.d(TAG, "Create peer connection factory. Use video: true");
        boolean z = false;
        this.isError = false;
        this.preferredVideoCodec = VIDEO_CODEC_VP8;
        String str = this.peerConnectionParameters.videoCodec;
        if (str != null) {
            String str2 = VIDEO_CODEC_VP9;
            if (!str.equals(VIDEO_CODEC_VP9)) {
                String str3 = this.peerConnectionParameters.videoCodec;
                str2 = VIDEO_CODEC_H264;
            }
            this.preferredVideoCodec = str2;
        }
        Log.d(TAG, "Pereferred video codec: " + this.preferredVideoCodec);
        if (this.peerConnectionParameters.useOpenSLES) {
            Log.d(TAG, "Allow OpenSL ES audio if device supports it");
            WebRtcAudioManager.setBlacklistDeviceForOpenSLESUsage(false);
        } else {
            Log.d(TAG, "Disable OpenSL ES audio even if device supports it");
            WebRtcAudioManager.setBlacklistDeviceForOpenSLESUsage(true);
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
        String str4 = this.peerConnectionParameters.enableFEC ? "WebRTC-FlexFEC-03-Advertised/Enabled/WebRTC-FlexFEC-03/Enabled/" : "";
        if (this.peerConnectionParameters.enableFixedResolution) {
            str4 = str4 + "BRTC.Fixed.Resolution/Enabled/";
        }
        int i2 = this.peerConnectionParameters.encodeBitrateMode;
        if (i2 == 0 || i2 == 1 || i2 == 2) {
            str4 = str4 + "BRTC-Encoder-BitrateMode/" + this.peerConnectionParameters.encodeBitrateMode + "/";
        }
        if (this.peerConnectionParameters.enableHighProfile) {
            str4 = (str4 + "WebRTC-H264HighProfile/Enabled/") + "WebRTC-MediaTekH264/Enabled/";
        }
        if (this.peerConnectionParameters.enableHisiH264HW) {
            str4 = str4 + "BRTC.HisiH264HW/Enabled/";
        }
        if (this.peerConnectionParameters.enableMTKH264Decode) {
            str4 = str4 + "BRTC.MTK.H264.Decode/Enabled/";
        }
        if (this.peerConnectionParameters.audioPlayoutDelay >= 0) {
            str4 = str4 + "BRTC.Playout.Delay.AudioOnly/" + this.peerConnectionParameters.audioPlayoutDelay + "/";
        }
        if (this.peerConnectionParameters.audioCodecComplex >= 0) {
            str4 = str4 + "BRTC.Opus.Complexity/" + this.peerConnectionParameters.audioCodecComplex + "/";
        }
        int i3 = 0;
        while (true) {
            if (i3 >= MediaCodecList.getCodecCount()) {
                break;
            }
            MediaCodecInfo mediaCodecInfo = null;
            try {
                mediaCodecInfo = MediaCodecList.getCodecInfoAt(i3);
            } catch (IllegalArgumentException e2) {
                Logging.e(TAG, "Cannot retrieve encoder codec info", e2);
            }
            if (mediaCodecInfo != null && mediaCodecInfo.isEncoder() && mediaCodecInfo.getName().startsWith(MediaCodecVideoDecoder.supportedHisiH264HighProfileHwCodecPrefix)) {
                z = true;
                break;
            }
            i3++;
        }
        if (this.peerConnectionParameters.enableRequiredResolutionAligment32 || z) {
            str4 = str4 + "BRTC.Required.Resolustion.Aligment32/Enabled/";
        }
        PeerConnectionFactory.initialize(PeerConnectionFactory.InitializationOptions.builder(context).setFieldTrials(str4).createInitializationOptions());
        AudioDeviceModule createJavaAudioDevice = createJavaAudioDevice();
        this.adm = (JavaAudioDeviceModule) createJavaAudioDevice;
        this.factory = PeerConnectionFactory.builder().setAudioDeviceModule(createJavaAudioDevice).setVideoDecoderFactory(MediaCodecVideoDecoder.createFactory()).setVideoEncoderFactory(MediaCodecVideoEncoder.createFactory()).createPeerConnectionFactory();
        Log.d(TAG, "Peer connection factory created.");
        createJavaAudioDevice.release();
        if (this.mbEnableDebugLog) {
            Logging.enableLogThreads();
            Logging.enableLogTimeStamps();
            severity = Logging.Severity.LS_VERBOSE;
        } else {
            severity = Logging.Severity.LS_ERROR;
        }
        Logging.enableLogToDebugOutput(severity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createPeerConnectionInternal(EglBase.Context context, BigInteger bigInteger) {
        if (this.factory == null || this.isError) {
            Log.e(TAG, "Peerconnection factory is not created");
            return;
        }
        Log.d(TAG, "PCConstraints: " + this.pcConstraints.toString());
        Log.d(TAG, "EGLContext: " + context);
        PeerConnection createPeerConnection = createPeerConnection(bigInteger, true);
        MediaStream createLocalMediaStream = this.factory.createLocalMediaStream("ARDAMS");
        this.mediaStream = createLocalMediaStream;
        if (this.mHasVideo) {
            createLocalMediaStream.addTrack(createVideoTrack(context, this.videoCapturer));
        }
        if (this.mHasAudio) {
            this.mediaStream.addTrack(createAudioTrack());
        }
        createPeerConnection.addStream(this.mediaStream);
        findVideoSender(bigInteger);
    }

    private VideoTrack createVideoTrack(EglBase.Context context, VideoCapturer videoCapturer) {
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

    private void findVideoSender(BigInteger bigInteger) {
        for (RtpSender rtpSender : this.peerConnectionMap.get(bigInteger).peerConnection.getSenders()) {
            if (rtpSender.track() != null && rtpSender.track().kind().equals("video")) {
                Log.d(TAG, "Found video sender.");
                this.localVideoSender = rtpSender;
            }
        }
    }

    public static PeerConnectionClient getInstance() {
        PeerConnectionClient peerConnectionClient;
        synchronized (PeerConnectionClient.class) {
            peerConnectionClient = new PeerConnectionClient();
        }
        return peerConnectionClient;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getStats(final BigInteger bigInteger, final StatsEventsType statsEventsType) {
        if (this.peerConnectionMap.get(bigInteger).peerConnection.getStats(new StatsObserver() { // from class: com.baidu.rtc.PeerConnectionClient.7
            @Override // org.webrtc.StatsObserver
            public void onComplete(StatsReport[] statsReportArr) {
                PeerConnectionClient.this.events.onPeerConnectionStatsReady(statsReportArr, bigInteger, statsEventsType);
            }
        }, null)) {
            return;
        }
        Log.e(TAG, "getStats() returns false!");
    }

    public static /* synthetic */ void lambda$setVideoMaxBitrate$0(PeerConnectionClient peerConnectionClient, Integer num) {
        if (peerConnectionClient.localVideoSender == null) {
            return;
        }
        Log.d(TAG, "Requested max video bitrate: " + num);
        RtpSender rtpSender = peerConnectionClient.localVideoSender;
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
            encoding.maxBitrateBps = num == null ? null : Integer.valueOf(num.intValue() * 1000);
        }
        if (!peerConnectionClient.localVideoSender.setParameters(parameters)) {
            Log.e(TAG, "RtpSender.setParameters failed.");
        }
        Log.d(TAG, "Configured max video bitrate to: " + num);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportError(final String str) {
        Log.e(TAG, "Peerconnection error: " + str);
        if (this.executor.isShutdown()) {
            Log.w(TAG, "executor is already shutdown");
        } else {
            this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.18
                @Override // java.lang.Runnable
                public void run() {
                    if (PeerConnectionClient.this.isError) {
                        return;
                    }
                    PeerConnectionClient.this.events.onPeerConnectionError(str);
                    PeerConnectionClient.this.isError = true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void switchCameraInternal() {
        if (!(this.videoCapturer instanceof CameraVideoCapturer)) {
            Log.d(TAG, "Will not switch camera, video caputurer is not a camera");
            return;
        }
        Log.d(TAG, "Switch camera");
        ((CameraVideoCapturer) this.videoCapturer).switchCamera(null);
    }

    public void changeCaptureFormat(final int i2, final int i3, final int i4) {
        if (this.executor.isShutdown()) {
            Log.w(TAG, "executor is already shutdown");
        } else {
            this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.20
                @Override // java.lang.Runnable
                public void run() {
                    PeerConnectionClient.this.changeCaptureFormatInternal(i2, i3, i4);
                }
            });
        }
    }

    public void close() {
        this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.3
            @Override // java.lang.Runnable
            public void run() {
                PeerConnectionClient.this.closeInternal();
            }
        });
        try {
            this.executor.shutdown();
            this.executor.awaitTermination(200L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException unused) {
        }
    }

    public void closePeer(final BigInteger bigInteger) {
        ScheduledExecutorService scheduledExecutorService = this.executor;
        if (scheduledExecutorService == null || scheduledExecutorService.isShutdown()) {
            return;
        }
        this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.6
            @Override // java.lang.Runnable
            public void run() {
                JanusConnection janusConnection;
                if (PeerConnectionClient.this.peerConnectionMap == null || (janusConnection = (JanusConnection) PeerConnectionClient.this.peerConnectionMap.get(bigInteger)) == null) {
                    return;
                }
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
                PeerConnectionClient.this.peerConnectionMap.remove(bigInteger);
            }
        });
    }

    public AudioDeviceModule createJavaAudioDevice() {
        AudioDeviceModule createAudioDeviceModule = JavaAudioDeviceModule.builder(this.context).setSamplesReadyCallback(this.innersamplesReadyCallback).setRemoteSamplesReadyCallback(this.mRemoteSamplesReadyCallback).setExternalAudioRecord(this.mExternalAudioRecord).setUseHardwareAcousticEchoCanceler(!this.peerConnectionParameters.disableBuiltInAEC).setUseHardwareNoiseSuppressor(!this.peerConnectionParameters.disableBuiltInNS).setAudioRecordErrorCallback(new JavaAudioDeviceModule.AudioRecordErrorCallback() { // from class: com.baidu.rtc.PeerConnectionClient.4
            @Override // org.webrtc.audio.JavaAudioDeviceModule.AudioRecordErrorCallback
            public void onWebRtcAudioRecordError(String str) {
                Log.e(PeerConnectionClient.TAG, "onWebRtcAudioRecordError: " + str);
                PeerConnectionClient.this.reportError(str);
            }

            @Override // org.webrtc.audio.JavaAudioDeviceModule.AudioRecordErrorCallback
            public void onWebRtcAudioRecordInitError(String str) {
                Log.e(PeerConnectionClient.TAG, "onWebRtcAudioRecordInitError: " + str);
                PeerConnectionClient.this.reportError(str);
                ErrorInfoReport.getInstance().reportErrorInfo(ErrorInfoReport.ErrorCode.PEERCONNECTION_CREATE_ERROR);
            }

            @Override // org.webrtc.audio.JavaAudioDeviceModule.AudioRecordErrorCallback
            public void onWebRtcAudioRecordStartError(JavaAudioDeviceModule.AudioRecordStartErrorCode audioRecordStartErrorCode, String str) {
                Log.e(PeerConnectionClient.TAG, "onWebRtcAudioRecordStartError: " + audioRecordStartErrorCode + ". " + str);
            }
        }).setAudioTrackErrorCallback(new JavaAudioDeviceModule.AudioTrackErrorCallback() { // from class: com.baidu.rtc.PeerConnectionClient.5
            @Override // org.webrtc.audio.JavaAudioDeviceModule.AudioTrackErrorCallback
            public void onWebRtcAudioTrackError(String str) {
                Log.e(PeerConnectionClient.TAG, "onWebRtcAudioTrackError: " + str);
                PeerConnectionClient.this.reportError(str);
            }

            @Override // org.webrtc.audio.JavaAudioDeviceModule.AudioTrackErrorCallback
            public void onWebRtcAudioTrackInitError(String str) {
                Log.e(PeerConnectionClient.TAG, "onWebRtcAudioTrackInitError: " + str);
                PeerConnectionClient.this.reportError(str);
            }

            @Override // org.webrtc.audio.JavaAudioDeviceModule.AudioTrackErrorCallback
            public void onWebRtcAudioTrackStartError(JavaAudioDeviceModule.AudioTrackStartErrorCode audioTrackStartErrorCode, String str) {
                Log.e(PeerConnectionClient.TAG, "onWebRtcAudioTrackStartError: " + audioTrackStartErrorCode + ". " + str);
                PeerConnectionClient.this.reportError(str);
            }
        }).setSampleRate(this.mAudioFreguency).setUseStereoInput(this.mAudioChannel > 1).setUseStereoOutput(this.mAudioChannel > 1).setAudioSource(this.peerConnectionParameters.audioSource).createAudioDeviceModule();
        if (this.mExternalAudioRecord && (createAudioDeviceModule instanceof JavaAudioDeviceModule)) {
            this.externalSamplesCallback = ((JavaAudioDeviceModule) createAudioDeviceModule).getExternalSamplesReadyCallback();
        }
        return createAudioDeviceModule;
    }

    public void createOffer(final BigInteger bigInteger) {
        if (this.executor.isShutdown()) {
            Log.w(TAG, "executor is already shutdown");
        } else {
            this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.11
                @Override // java.lang.Runnable
                public void run() {
                    JanusConnection janusConnection = (JanusConnection) PeerConnectionClient.this.peerConnectionMap.get(bigInteger);
                    PeerConnection peerConnection = janusConnection.peerConnection;
                    if (peerConnection == null || PeerConnectionClient.this.isError) {
                        return;
                    }
                    Log.d(PeerConnectionClient.TAG, "PC Create OFFER");
                    peerConnection.createOffer(janusConnection.sdpObserver, PeerConnectionClient.this.sdpMediaConstraints);
                }
            });
        }
    }

    public void createPeerConnection(final EglBase.Context context, VideoSink videoSink, VideoCapturer videoCapturer, final BigInteger bigInteger) {
        if (this.peerConnectionParameters == null) {
            Log.e(TAG, "Creating peer connection without initializing factory.");
            return;
        }
        this.localRender = videoSink;
        this.videoCapturer = videoCapturer;
        if (this.executor.isShutdown()) {
            Log.w(TAG, "executor is already shutdown");
        } else {
            this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        PeerConnectionClient.this.createMediaConstraintsInternal();
                        PeerConnectionClient.this.createPeerConnectionInternal(context, bigInteger);
                    } catch (Exception e2) {
                        PeerConnectionClient peerConnectionClient = PeerConnectionClient.this;
                        peerConnectionClient.reportError("Failed to create peer connection: " + e2.getMessage());
                        ErrorInfoReport.getInstance().reportErrorInfo(ErrorInfoReport.ErrorCode.PEERCONNECTION_CREATE_ERROR);
                        throw e2;
                    }
                }
            });
        }
    }

    public void createPeerConnectionFactory(final Context context, PeerConnectionParameters peerConnectionParameters, PeerConnectionEvents peerConnectionEvents) {
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
        this.statsTimer = new Timer();
        if (this.executor.isShutdown()) {
            Log.w(TAG, "executor is already shutdown");
        } else {
            this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.1
                @Override // java.lang.Runnable
                public void run() {
                    PeerConnectionClient.this.createPeerConnectionFactoryInternal(context);
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0029 A[Catch: Exception -> 0x0052, TryCatch #0 {Exception -> 0x0052, blocks: (B:4:0x0003, B:6:0x0007, B:7:0x000d, B:15:0x0029, B:16:0x002c, B:18:0x0035, B:19:0x0037, B:26:0x0049, B:20:0x003b, B:22:0x003f, B:23:0x0042, B:25:0x0046, B:8:0x0011, B:10:0x0015, B:11:0x001c, B:13:0x0020), top: B:43:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0035 A[Catch: Exception -> 0x0052, TryCatch #0 {Exception -> 0x0052, blocks: (B:4:0x0003, B:6:0x0007, B:7:0x000d, B:15:0x0029, B:16:0x002c, B:18:0x0035, B:19:0x0037, B:26:0x0049, B:20:0x003b, B:22:0x003f, B:23:0x0042, B:25:0x0046, B:8:0x0011, B:10:0x0015, B:11:0x001c, B:13:0x0020), top: B:43:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003b A[Catch: Exception -> 0x0052, TryCatch #0 {Exception -> 0x0052, blocks: (B:4:0x0003, B:6:0x0007, B:7:0x000d, B:15:0x0029, B:16:0x002c, B:18:0x0035, B:19:0x0037, B:26:0x0049, B:20:0x003b, B:22:0x003f, B:23:0x0042, B:25:0x0046, B:8:0x0011, B:10:0x0015, B:11:0x001c, B:13:0x0020), top: B:43:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void enableStatsEvents(boolean z, int i2, final BigInteger bigInteger, final StatsEventsType statsEventsType) {
        TimerTask timerTask;
        Map<BigInteger, TimerTask> map;
        Map<BigInteger, TimerTask> map2;
        TimerTask timerTask2 = null;
        if (z) {
            try {
                if (statsEventsType == StatsEventsType.GET_AUDIOLEVEL_EVENT) {
                    timerTask = this.timerTaskGetVolumeMap.get(bigInteger);
                } else if (statsEventsType != StatsEventsType.GET_QUALITY_MONITOR_EVENT) {
                    if (statsEventsType == StatsEventsType.GET_SLI_EVENT) {
                        timerTask = this.timerTaskGetSLIMap.get(bigInteger);
                    }
                    if (timerTask2 != null) {
                        timerTask2.cancel();
                    }
                    TimerTask timerTask3 = new TimerTask() { // from class: com.baidu.rtc.PeerConnectionClient.8
                        @Override // java.util.TimerTask, java.lang.Runnable
                        public void run() {
                            if (PeerConnectionClient.this.executor.isShutdown()) {
                                return;
                            }
                            PeerConnectionClient.this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.8.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    AnonymousClass8 anonymousClass8 = AnonymousClass8.this;
                                    PeerConnectionClient.this.getStats(bigInteger, statsEventsType);
                                }
                            });
                        }
                    };
                    if (statsEventsType != StatsEventsType.GET_AUDIOLEVEL_EVENT) {
                        map = this.timerTaskGetVolumeMap;
                    } else if (statsEventsType != StatsEventsType.GET_QUALITY_MONITOR_EVENT) {
                        if (statsEventsType == StatsEventsType.GET_SLI_EVENT) {
                            map = this.timerTaskGetSLIMap;
                        }
                        this.statsTimer.schedule(timerTask3, 0L, i2);
                        return;
                    } else {
                        map = this.timerTaskGetQualityMap;
                    }
                    map.put(bigInteger, timerTask3);
                    this.statsTimer.schedule(timerTask3, 0L, i2);
                    return;
                } else {
                    timerTask = this.timerTaskGetQualityMap.get(bigInteger);
                }
                timerTask2 = timerTask;
                if (timerTask2 != null) {
                }
                TimerTask timerTask32 = new TimerTask() { // from class: com.baidu.rtc.PeerConnectionClient.8
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        if (PeerConnectionClient.this.executor.isShutdown()) {
                            return;
                        }
                        PeerConnectionClient.this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.8.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AnonymousClass8 anonymousClass8 = AnonymousClass8.this;
                                PeerConnectionClient.this.getStats(bigInteger, statsEventsType);
                            }
                        });
                    }
                };
                if (statsEventsType != StatsEventsType.GET_AUDIOLEVEL_EVENT) {
                }
                map.put(bigInteger, timerTask32);
                this.statsTimer.schedule(timerTask32, 0L, i2);
                return;
            } catch (Exception e2) {
                Log.e(TAG, "Can not schedule statistics timer", e2);
                return;
            }
        }
        if (statsEventsType == StatsEventsType.GET_AUDIOLEVEL_EVENT) {
            map2 = this.timerTaskGetVolumeMap;
        } else if (statsEventsType != StatsEventsType.GET_QUALITY_MONITOR_EVENT) {
            if (statsEventsType == StatsEventsType.GET_SLI_EVENT) {
                map2 = this.timerTaskGetSLIMap;
            }
            if (timerTask2 == null) {
                timerTask2.cancel();
                return;
            }
            return;
        } else {
            map2 = this.timerTaskGetQualityMap;
        }
        timerTask2 = map2.get(bigInteger);
        if (timerTask2 == null) {
        }
    }

    public JavaAudioDeviceModule.ExternalSamplesReadyCallback getExternalSamplesCallback() {
        return this.externalSamplesCallback;
    }

    public JanusConnection getJanusConnectionByHandleID(BigInteger bigInteger) {
        return this.peerConnectionMap.get(bigInteger);
    }

    public boolean isHDVideo() {
        return this.videoWidth * this.videoHeight >= 921600;
    }

    @Override // org.webrtc.DataChannel.Observer
    public void onBufferedAmountChange(long j) {
    }

    @Override // org.webrtc.DataChannel.Observer
    public void onMessage(DataChannel.Buffer buffer) {
        this.events.onRemoteData(buffer.data);
    }

    @Override // org.webrtc.DataChannel.Observer
    public void onStateChange() {
    }

    public void sendData(ByteBuffer byteBuffer) {
        if (this.dcPublisher == null) {
            return;
        }
        this.dcPublisher.send(new DataChannel.Buffer(byteBuffer, true));
    }

    public void setAudioChannel(int i2) {
        this.mAudioChannel = i2;
    }

    public void setAudioEnabled(final boolean z) {
        if (this.executor.isShutdown()) {
            Log.w(TAG, "executor is already shutdown");
        } else {
            this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.9
                @Override // java.lang.Runnable
                public void run() {
                    PeerConnectionClient.this.enableAudio = z;
                    if (PeerConnectionClient.this.localAudioTrack != null) {
                        PeerConnectionClient.this.localAudioTrack.setEnabled(PeerConnectionClient.this.enableAudio);
                    }
                    if (PeerConnectionClient.this.adm != null) {
                        PeerConnectionClient.this.adm.setMicrophoneMute(!z);
                    }
                }
            });
        }
    }

    public void setAudioFreguency(int i2) {
        this.mAudioFreguency = i2;
    }

    public void setAudioRecording(final BigInteger bigInteger, final boolean z) {
        if (this.executor.isShutdown()) {
            Log.w(TAG, "executor is already shutdown");
        } else {
            this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.17
                @Override // java.lang.Runnable
                public void run() {
                    PeerConnection peerConnection = ((JanusConnection) PeerConnectionClient.this.peerConnectionMap.get(bigInteger)).peerConnection;
                    if (peerConnection != null) {
                        peerConnection.setAudioRecording(z);
                    }
                }
            });
        }
    }

    public void setAudioSamplesReadyCallback(JavaAudioDeviceModule.SamplesReadyCallback samplesReadyCallback) {
        this.innersamplesReadyCallback = samplesReadyCallback;
    }

    public void setEnableDebugLog(boolean z) {
        this.mbEnableDebugLog = z;
    }

    public void setEnableSLIReport(final boolean z) {
        if (this.executor.isShutdown()) {
            Log.w(TAG, "executor is already shutdown");
        } else {
            this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.23
                @Override // java.lang.Runnable
                public void run() {
                    if (PeerConnectionClient.this.adm != null) {
                        PeerConnectionClient.this.adm.setEnableSLIReport(z);
                    }
                }
            });
        }
    }

    public void setExternalAudioRecord(boolean z) {
        this.mExternalAudioRecord = z;
    }

    public void setHasAudio(boolean z) {
        this.mHasAudio = z;
    }

    public void setHasData(boolean z) {
        this.mHasData = z;
    }

    public void setHasVideo(boolean z) {
        this.mHasVideo = z;
    }

    public void setPeerConnectionFactoryOptions(PeerConnectionFactory.Options options) {
        this.options = options;
    }

    public void setRemoteAudioSamplesReadyCallback(JavaAudioDeviceModule.RemoteSamplesReadyCallback remoteSamplesReadyCallback) {
        this.mRemoteSamplesReadyCallback = remoteSamplesReadyCallback;
    }

    public void setRemoteDescription(final BigInteger bigInteger, final SessionDescription sessionDescription) {
        if (this.executor.isShutdown()) {
            Log.w(TAG, "executor is already shutdown");
        } else {
            this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.12
                @Override // java.lang.Runnable
                public void run() {
                    PeerConnection peerConnection = ((JanusConnection) PeerConnectionClient.this.peerConnectionMap.get(bigInteger)).peerConnection;
                    SDPObserver sDPObserver = ((JanusConnection) PeerConnectionClient.this.peerConnectionMap.get(bigInteger)).sdpObserver;
                    if (peerConnection == null || PeerConnectionClient.this.isError) {
                        return;
                    }
                    String str = sessionDescription.description;
                    SdpPrefer.AudioSdpAttribute audioSdpAttribute = new SdpPrefer.AudioSdpAttribute();
                    audioSdpAttribute.cbr = PeerConnectionClient.this.peerConnectionParameters.audioBitrateMode == RtcParameterSettings.RtcAudioBitrateMode.RTC_AUDIO_BITRATE_CBR;
                    audioSdpAttribute.maxaveragebitrate = PeerConnectionClient.this.peerConnectionParameters.audioMaxkbps;
                    audioSdpAttribute.stereo = PeerConnectionClient.this.peerConnectionParameters.transportAudioChannel == RtcParameterSettings.RtcAudioChannel.RTC_AUDIO_STEREO;
                    String audioAttributes = SdpPrefer.setAudioAttributes(PeerConnectionClient.this.peerConnectionParameters.audioCodec, str, audioSdpAttribute);
                    peerConnection.setRemoteDescription(sDPObserver, new SessionDescription(sessionDescription.type, audioAttributes));
                    ErrorInfoReport.getInstance().putServerMap(bigInteger, SdpPrefer.parseRemoteMediaIp(audioAttributes));
                }
            });
        }
    }

    public void setSpeakerMute(final boolean z) {
        if (this.executor.isShutdown()) {
            Log.w(TAG, "executor is already shutdown");
        } else {
            this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.21
                @Override // java.lang.Runnable
                public void run() {
                    if (PeerConnectionClient.this.adm != null) {
                        PeerConnectionClient.this.adm.setSpeakerMute(z);
                    }
                }
            });
        }
    }

    public void setStuckEventListener(final SLIReportInterface sLIReportInterface) {
        if (this.executor.isShutdown()) {
            Log.w(TAG, "executor is already shutdown");
        } else {
            this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.22
                @Override // java.lang.Runnable
                public void run() {
                    PeerConnectionClient.this.mStuckEvent = sLIReportInterface;
                    if (PeerConnectionClient.this.adm != null) {
                        PeerConnectionClient.this.adm.setStuckEventListener(sLIReportInterface);
                    }
                }
            });
        }
    }

    public void setVideoEnabled(final boolean z) {
        if (this.executor.isShutdown()) {
            Log.w(TAG, "executor is already shutdown");
        } else {
            this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.10
                @Override // java.lang.Runnable
                public void run() {
                    PeerConnectionClient.this.renderVideo = z;
                    if (PeerConnectionClient.this.localVideoTrack != null) {
                        PeerConnectionClient.this.localVideoTrack.setEnabled(PeerConnectionClient.this.renderVideo);
                    }
                }
            });
        }
    }

    public void setVideoMaxBitrate(final Integer num) {
        this.executor.execute(new Runnable() { // from class: com.baidu.rtc._$$Lambda$PeerConnectionClient$VCAMHyuRIwi67k5BJMZGKWj_waM
            @Override // java.lang.Runnable
            public final void run() {
                PeerConnectionClient.lambda$setVideoMaxBitrate$0(PeerConnectionClient.this, num);
            }
        });
    }

    public void startVideoSource() {
        if (this.executor.isShutdown()) {
            Log.w(TAG, "executor is already shutdown");
        } else {
            this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.15
                @Override // java.lang.Runnable
                public void run() {
                    if (PeerConnectionClient.this.videoCapturer == null || !PeerConnectionClient.this.videoCapturerStopped) {
                        return;
                    }
                    Log.d(PeerConnectionClient.TAG, "Restart video source.");
                    PeerConnectionClient.this.videoCapturer.startCapture(PeerConnectionClient.this.videoWidth, PeerConnectionClient.this.videoHeight, PeerConnectionClient.this.videoFps);
                    PeerConnectionClient.this.videoCapturerStopped = false;
                }
            });
        }
    }

    public void stopAudioSource() {
        if (this.executor.isShutdown()) {
            Log.w(TAG, "executor is already shutdown");
        } else {
            this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.16
                @Override // java.lang.Runnable
                public void run() {
                    if (PeerConnectionClient.this.audioSource != null) {
                        PeerConnectionClient.this.audioSource.dispose();
                        PeerConnectionClient.this.audioSource = null;
                    }
                }
            });
        }
    }

    public void stopVideoSource() {
        if (this.executor.isShutdown()) {
            Log.w(TAG, "executor is already shutdown");
        } else {
            this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.14
                @Override // java.lang.Runnable
                public void run() {
                    if (PeerConnectionClient.this.videoCapturer == null || PeerConnectionClient.this.videoCapturerStopped) {
                        return;
                    }
                    Log.d(PeerConnectionClient.TAG, "Stop video source.");
                    try {
                        PeerConnectionClient.this.videoCapturer.stopCapture();
                    } catch (InterruptedException unused) {
                    }
                    PeerConnectionClient.this.videoCapturerStopped = true;
                }
            });
        }
    }

    public void subscriberHandleRemoteJsep(final BigInteger bigInteger, final SessionDescription sessionDescription) {
        if (this.executor.isShutdown()) {
            Log.w(TAG, "executor is already shutdown");
        } else {
            this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.13
                @Override // java.lang.Runnable
                public void run() {
                    PeerConnection createPeerConnection = PeerConnectionClient.this.createPeerConnection(bigInteger, false);
                    SDPObserver sDPObserver = ((JanusConnection) PeerConnectionClient.this.peerConnectionMap.get(bigInteger)).sdpObserver;
                    if (createPeerConnection == null || PeerConnectionClient.this.isError) {
                        return;
                    }
                    createPeerConnection.setRemoteDescription(sDPObserver, sessionDescription);
                    ErrorInfoReport.getInstance().putServerMap(bigInteger, SdpPrefer.parseRemoteMediaIp(sessionDescription.description));
                    Log.d(PeerConnectionClient.TAG, "PC create ANSWER");
                    createPeerConnection.createAnswer(((JanusConnection) PeerConnectionClient.this.peerConnectionMap.get(bigInteger)).sdpObserver, PeerConnectionClient.this.answer_sdpMediaConstraints);
                }
            });
        }
    }

    public void switchCamera() {
        if (this.executor.isShutdown()) {
            Log.w(TAG, "executor is already shutdown");
        } else {
            this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.19
                @Override // java.lang.Runnable
                public void run() {
                    PeerConnectionClient.this.switchCameraInternal();
                }
            });
        }
    }
}
