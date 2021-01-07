package com.baidu.rtc;

import android.content.Context;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Environment;
import android.util.Log;
import com.baidu.ala.helper.StreamConfig;
import com.baidu.rtc.RtcParameterSettings;
import com.baidu.rtc.m;
import io.flutter.plugin.platform.PlatformPlugin;
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
/* loaded from: classes10.dex */
public class PeerConnectionClient implements DataChannel.Observer {
    private Context context;
    private b cwA;
    private PeerConnectionFactory cwB;
    private JavaAudioDeviceModule.SamplesReadyCallback cwC;
    private boolean cwE;
    private AudioTrack cwF;
    private VideoSink cwG;
    private SurfaceTextureHelper cwH;
    private RtpSender cwI;
    private VideoTrack cwJ;
    private boolean cwL;
    private JavaAudioDeviceModule.RemoteSamplesReadyCallback cwN;
    private MediaStream cwP;
    private MediaConstraints cwQ;
    private c cwS;
    private String cwT;
    private VideoTrack cwV;
    private boolean cwW;
    private MediaConstraints cwX;
    private Timer cwY;
    private MediaConstraints cwv;
    private MediaConstraints cww;
    private AudioSource cwx;
    private boolean cwz;
    private VideoCapturer cxb;
    private boolean cxc;
    private int cxd;
    private VideoSource cxe;
    private JavaAudioDeviceModule.ExternalSamplesReadyCallback externalSamplesCallback;
    private int videoHeight;
    private int videoWidth;
    PeerConnectionFactory.Options options = null;
    private Map<BigInteger, TimerTask> cxa = new ConcurrentHashMap();
    private Map<BigInteger, TimerTask> cwZ = new ConcurrentHashMap();
    private boolean mHasVideo = true;
    private boolean mHasAudio = true;
    private boolean cwM = false;
    private int cwK = StreamConfig.Audio.AUDIO_RTC_FREQUENCY_48K;
    private int mAudioChannel = 1;
    private boolean cwD = true;
    private DataChannel cwy = null;
    Map<BigInteger, Integer> cwU = new ConcurrentHashMap();
    private boolean cwO = false;
    private JavaAudioDeviceModule cwu = null;
    private final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
    private ConcurrentHashMap<BigInteger, com.baidu.rtc.a> cwR = new ConcurrentHashMap<>();

    /* loaded from: classes10.dex */
    public enum StatsEventsType {
        GET_AUDIOLEVEL_EVENT,
        GET_QUALITY_MONITOR_EVENT,
        GET_BWE_EVENT
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a implements PeerConnection.Observer {
        private PeerConnection cwi;
        private com.baidu.rtc.a cxo;

        private a() {
        }

        public void a(com.baidu.rtc.a aVar) {
            this.cxo = aVar;
            this.cwi = aVar.cwi;
        }

        @Override // org.webrtc.PeerConnection.Observer
        public void onAddStream(final MediaStream mediaStream) {
            if (PeerConnectionClient.this.executor.isShutdown()) {
                Log.w("PCRTCClient", "executor is already shutdown");
            } else {
                PeerConnectionClient.this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.a.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.cwi == null || PeerConnectionClient.this.cwE) {
                            return;
                        }
                        Log.d("PCRTCClient", "=========== onAddStream ==========");
                        if (mediaStream.videoTracks.size() == 1) {
                            PeerConnectionClient.this.cwV = mediaStream.videoTracks.get(0);
                            PeerConnectionClient.this.cwV.setEnabled(true);
                            a.this.cxo.cwl = PeerConnectionClient.this.cwV;
                            PeerConnectionClient.this.cwA.b(a.this.cxo);
                        }
                        PeerConnectionClient.this.cwA.a(mediaStream.videoTracks.size() != 0, mediaStream.audioTracks.size() != 0, a.this.cxo.cwh);
                    }
                });
            }
        }

        @Override // org.webrtc.PeerConnection.Observer
        public void onAddTrack(RtpReceiver rtpReceiver, MediaStream[] mediaStreamArr) {
            Log.d("PCRTCClient", "testing ... add track");
        }

        @Override // org.webrtc.PeerConnection.Observer
        @CalledByNative("Observer")
        public void onConnectionChange(PeerConnection.PeerConnectionState peerConnectionState) {
            PeerConnection.Observer_CC.$default$onConnectionChange(this, peerConnectionState);
        }

        @Override // org.webrtc.PeerConnection.Observer
        public void onDataChannel(DataChannel dataChannel) {
            Log.d("PCRTCClient", "New Data channel " + dataChannel.label());
            dataChannel.registerObserver(PeerConnectionClient.this);
        }

        @Override // org.webrtc.PeerConnection.Observer
        public void onIceCandidate(final IceCandidate iceCandidate) {
            if (PeerConnectionClient.this.executor.isShutdown()) {
                Log.w("PCRTCClient", "executor is already shutdown");
            } else {
                PeerConnectionClient.this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PeerConnectionClient.this.cwA.a(iceCandidate, a.this.cxo.cwh);
                    }
                });
            }
        }

        @Override // org.webrtc.PeerConnection.Observer
        public void onIceCandidatesRemoved(final IceCandidate[] iceCandidateArr) {
            if (PeerConnectionClient.this.executor.isShutdown()) {
                Log.w("PCRTCClient", "executor is already shutdown");
            } else {
                PeerConnectionClient.this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        PeerConnectionClient.this.cwA.onIceCandidatesRemoved(iceCandidateArr);
                    }
                });
            }
        }

        @Override // org.webrtc.PeerConnection.Observer
        public void onIceConnectionChange(final PeerConnection.IceConnectionState iceConnectionState) {
            if (PeerConnectionClient.this.executor.isShutdown()) {
                Log.w("PCRTCClient", "executor is already shutdown");
            } else {
                PeerConnectionClient.this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.a.3
                    @Override // java.lang.Runnable
                    public void run() {
                        Log.d("PCRTCClient", "IceConnectionState: " + iceConnectionState);
                        if (iceConnectionState == PeerConnection.IceConnectionState.CONNECTED) {
                            PeerConnectionClient.this.cwA.ail();
                        } else if (iceConnectionState == PeerConnection.IceConnectionState.DISCONNECTED) {
                            PeerConnectionClient.this.cwA.aim();
                        } else if (iceConnectionState == PeerConnection.IceConnectionState.FAILED) {
                            PeerConnectionClient.this.cwA.ain();
                        }
                    }
                });
            }
        }

        @Override // org.webrtc.PeerConnection.Observer
        public void onIceConnectionReceivingChange(boolean z) {
            Log.d("PCRTCClient", "IceConnectionReceiving changed to " + z);
        }

        @Override // org.webrtc.PeerConnection.Observer
        public void onIceGatheringChange(PeerConnection.IceGatheringState iceGatheringState) {
            Log.d("PCRTCClient", "IceGatheringState: " + iceGatheringState);
        }

        @Override // org.webrtc.PeerConnection.Observer
        public void onRemoveStream(MediaStream mediaStream) {
            if (PeerConnectionClient.this.executor.isShutdown()) {
                Log.w("PCRTCClient", "executor is already shutdown");
            } else {
                PeerConnectionClient.this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.a.5
                    @Override // java.lang.Runnable
                    public void run() {
                        PeerConnectionClient.this.cwV = null;
                    }
                });
            }
        }

        @Override // org.webrtc.PeerConnection.Observer
        public void onRenegotiationNeeded() {
        }

        @Override // org.webrtc.PeerConnection.Observer
        public void onSignalingChange(PeerConnection.SignalingState signalingState) {
            Log.d("PCRTCClient", "SignalingState: " + signalingState);
        }

        @Override // org.webrtc.PeerConnection.Observer
        @CalledByNative("Observer")
        public void onTrack(RtpTransceiver rtpTransceiver) {
            PeerConnection.Observer_CC.$default$onTrack(this, rtpTransceiver);
        }
    }

    /* loaded from: classes10.dex */
    public interface b {
        void a(Boolean bool, Boolean bool2, BigInteger bigInteger);

        void a(IceCandidate iceCandidate, BigInteger bigInteger);

        void a(SessionDescription sessionDescription, BigInteger bigInteger);

        void a(SessionDescription sessionDescription, BigInteger bigInteger, boolean z);

        void a(StatsReport[] statsReportArr, BigInteger bigInteger, StatsEventsType statsEventsType);

        void ail();

        void aim();

        void ain();

        void aio();

        void b(com.baidu.rtc.a aVar);

        void kp(String str);

        void l(ByteBuffer byteBuffer);

        void onIceCandidatesRemoved(IceCandidate[] iceCandidateArr);
    }

    /* loaded from: classes10.dex */
    public static class c {
        public final boolean cxA;
        public final boolean cxB;
        public final boolean cxC;
        public final boolean cxD;
        public final boolean cxE;
        public final boolean cxF;
        public final boolean cxG;
        public final int cxH;
        public final boolean cxI;
        public final boolean cxJ;
        public final boolean cxK;
        public RtcParameterSettings.RtcAudioChannel cxL;
        public final boolean cxM;
        public final String cxN;
        public final boolean cxO;
        public final int cxP;
        public final int cxQ;
        public final int cxd;
        public RtcParameterSettings.RtcAudioBitrateMode cxu;
        public final String cxv;
        public final int cxw;
        public final int cxx;
        public final boolean cxy;
        public final boolean cxz;
        public final int videoHeight;
        public final int videoWidth;

        public c(boolean z, int i, int i2, int i3, String str, boolean z2, int i4, String str2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, int i5, int i6, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, boolean z13, int i7, RtcParameterSettings.RtcAudioBitrateMode rtcAudioBitrateMode, RtcParameterSettings.RtcAudioChannel rtcAudioChannel, int i8, boolean z14) {
            this.cxK = z;
            this.videoWidth = i;
            this.videoHeight = i2;
            this.cxd = i3;
            this.cxN = str;
            this.cxO = z2;
            this.cxx = i4;
            this.cxv = str2;
            this.cxJ = z3;
            this.cxM = z4;
            this.cxz = z5;
            this.cxA = z6;
            this.cxB = z7;
            this.cxP = i5;
            this.cxQ = i6;
            this.cxI = z8;
            this.cxy = z9;
            this.cxC = z10;
            this.cxD = z11;
            this.cxG = z12;
            this.cxE = z13;
            this.cxw = i7;
            this.cxu = rtcAudioBitrateMode;
            this.cxL = rtcAudioChannel;
            this.cxH = i8;
            this.cxF = z14;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class d implements SdpObserver {
        private c cwg;
        private BigInteger cwh;
        private PeerConnection cwi;
        private d cwj;
        private boolean cwk;
        private SessionDescription cxR;

        d() {
        }

        public void a(com.baidu.rtc.a aVar) {
            this.cwi = aVar.cwi;
            this.cwj = aVar.cwj;
            this.cwh = aVar.cwh;
            this.cwk = aVar.cwk;
            this.cwg = aVar.cwg;
        }

        public void close() {
            this.cwi = null;
        }

        @Override // org.webrtc.SdpObserver
        public void onCreateFailure(String str) {
            PeerConnectionClient peerConnectionClient = PeerConnectionClient.this;
            peerConnectionClient.reportError("createSDP error: " + str);
        }

        @Override // org.webrtc.SdpObserver
        public void onCreateSuccess(SessionDescription sessionDescription) {
            Log.e("PCRTCClient", "SDP on create success");
            final SessionDescription sessionDescription2 = new SessionDescription(sessionDescription.type, sessionDescription.description);
            this.cxR = sessionDescription2;
            if (PeerConnectionClient.this.executor.isShutdown()) {
                Log.w("PCRTCClient", "executor is already shutdown");
            } else {
                PeerConnectionClient.this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.d.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (d.this.cwi == null || PeerConnectionClient.this.cwE) {
                            return;
                        }
                        Log.d("PCRTCClient", "Set local SDP from " + sessionDescription2.type);
                        d.this.cwi.setLocalDescription(d.this.cwj, sessionDescription2);
                    }
                });
            }
        }

        @Override // org.webrtc.SdpObserver
        public void onSetFailure(String str) {
            PeerConnectionClient peerConnectionClient = PeerConnectionClient.this;
            peerConnectionClient.reportError("setSDP error: " + str);
        }

        @Override // org.webrtc.SdpObserver
        public void onSetSuccess() {
            if (PeerConnectionClient.this.executor.isShutdown()) {
                Log.w("PCRTCClient", "executor is already shutdown");
            } else {
                PeerConnectionClient.this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.d.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (d.this.cwi == null || PeerConnectionClient.this.cwE) {
                            return;
                        }
                        if (!d.this.cwk) {
                            if (d.this.cwi.getLocalDescription() == null) {
                                Log.d("PCRTCClient", "answer Remote SDP set succesfully");
                                return;
                            }
                            Log.d("PCRTCClient", "answer Local SDP set succesfully");
                            PeerConnectionClient.this.cwA.a(d.this.cxR, d.this.cwh);
                        } else if (d.this.cwi.getRemoteDescription() != null) {
                            Log.d("PCRTCClient", "Remote SDP set succesfully");
                        } else {
                            Log.d("PCRTCClient", "Local SDP set succesfully");
                            PeerConnectionClient.this.cwA.a(d.this.cxR, d.this.cwh, d.this.cxR.description.contains("profile-level-id=640c1f"));
                        }
                    }
                });
            }
        }
    }

    private PeerConnectionClient() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PeerConnection a(BigInteger bigInteger, boolean z) {
        Log.d("PCRTCClient", "Create peer connection.");
        ArrayList arrayList = new ArrayList();
        PeerConnection.IceServer.builder("stun:180.149.142.139:3478").createIceServer();
        new PeerConnection.RTCConfiguration(arrayList);
        a aVar = new a();
        d dVar = new d();
        PeerConnection createPeerConnection = this.cwB.createPeerConnection(arrayList, aVar);
        com.baidu.rtc.a aVar2 = new com.baidu.rtc.a();
        aVar2.cwh = bigInteger;
        aVar2.cwj = dVar;
        aVar2.cwi = createPeerConnection;
        aVar2.cwk = z;
        aVar2.cwm = -1;
        aVar2.cwg = this.cwS;
        this.cwR.put(bigInteger, aVar2);
        aVar.a(aVar2);
        dVar.a(aVar2);
        DataChannel.Init init = new DataChannel.Init();
        if (this.cwM && z) {
            this.cwy = createPeerConnection.createDataChannel("JanusDataChannel", init);
        }
        Log.d("PCRTCClient", "Peer connection created.");
        return createPeerConnection;
    }

    private VideoTrack a(EglBase.Context context, VideoCapturer videoCapturer) {
        this.cxe = this.cwB.createVideoSource(false);
        this.cwH = SurfaceTextureHelper.create("video renderer", context);
        videoCapturer.initialize(this.cwH, this.context, this.cxe.getCapturerObserver());
        videoCapturer.startCapture(this.videoWidth, this.videoHeight, this.cxd);
        this.cwJ = this.cwB.createVideoTrack("ARDAMSv0", this.cxe);
        this.cwJ.setEnabled(this.cwW);
        this.cwJ.addSink(this.cwG);
        return this.cwJ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(PeerConnectionClient peerConnectionClient, Integer num) {
        if (peerConnectionClient.cwI == null) {
            return;
        }
        Log.d("PCRTCClient", "Requested max video bitrate: " + num);
        if (peerConnectionClient.cwI == null) {
            Log.w("PCRTCClient", "Sender is not ready.");
            return;
        }
        RtpParameters parameters = peerConnectionClient.cwI.getParameters();
        if (parameters.encodings.size() == 0) {
            Log.w("PCRTCClient", "RtpParameters are not ready.");
            return;
        }
        for (RtpParameters.Encoding encoding : parameters.encodings) {
            encoding.maxBitrateBps = num == null ? null : Integer.valueOf(num.intValue() * 1000);
        }
        if (!peerConnectionClient.cwI.setParameters(parameters)) {
            Log.e("PCRTCClient", "RtpSender.setParameters failed.");
        }
        Log.d("PCRTCClient", "Configured max video bitrate to: " + num);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final BigInteger bigInteger, final StatsEventsType statsEventsType) {
        if (this.cwR.get(bigInteger).cwi.getStats(new StatsObserver() { // from class: com.baidu.rtc.PeerConnectionClient.14
            @Override // org.webrtc.StatsObserver
            public void onComplete(StatsReport[] statsReportArr) {
                PeerConnectionClient.this.cwA.a(statsReportArr, bigInteger, statsEventsType);
            }
        }, null)) {
            return;
        }
        Log.e("PCRTCClient", "getStats() returns false!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(EglBase.Context context, BigInteger bigInteger) {
        if (this.cwB == null || this.cwE) {
            Log.e("PCRTCClient", "Peerconnection factory is not created");
            return;
        }
        Log.d("PCRTCClient", "PCConstraints: " + this.cwQ.toString());
        Log.d("PCRTCClient", "EGLContext: " + context);
        PeerConnection a2 = a(bigInteger, true);
        this.cwP = this.cwB.createLocalMediaStream("ARDAMS");
        if (this.mHasVideo) {
            this.cwP.addTrack(a(context, this.cxb));
        }
        if (this.mHasAudio) {
            this.cwP.addTrack(aig());
        }
        a2.addStream(this.cwP);
        g(bigInteger);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aif() {
        Log.d("PCRTCClient", "Closing peer connection.");
        this.cwY.cancel();
        if (this.cwR != null) {
            int size = this.cwR.size();
            for (int i = 0; i < size; i++) {
                com.baidu.rtc.a aVar = (com.baidu.rtc.a) this.cwR.values().toArray()[i];
                aVar.cwi.close();
                aVar.cwi.dispose();
                aVar.cwi = null;
                aVar.cwj.close();
            }
        }
        Log.d("PCRTCClient", "Closing audio source.");
        if (this.cwx != null) {
            this.cwx.dispose();
            this.cwx = null;
        }
        Log.d("PCRTCClient", "Stopping capture.");
        if (this.cxb != null) {
            try {
                this.cxb.stopCapture();
                this.cxc = true;
                this.cxb.dispose();
                this.cxb = null;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        Log.d("PCRTCClient", "Closing video source.");
        if (this.cxe != null) {
            this.cxe.dispose();
            this.cxe = null;
        }
        if (this.cwH != null) {
            this.cwH.dispose();
            this.cwH = null;
        }
        Log.d("PCRTCClient", "Closing peer connection factory.");
        if (this.cwB != null) {
            this.cwB.dispose();
            this.cwB = null;
        }
        this.options = null;
        Log.d("PCRTCClient", "Closing peer connection done.");
        this.cwA.aio();
        PeerConnectionFactory.stopInternalTracingCapture();
        PeerConnectionFactory.shutdownInternalTracer();
    }

    private AudioTrack aig() {
        this.cwx = this.cwB.createAudioSource(this.cww);
        this.cwF = this.cwB.createAudioTrack("ARDAMSa0", this.cwx);
        this.cwF.setEnabled(this.cwz);
        return this.cwF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aih() {
        this.cwQ = new MediaConstraints();
        this.cwQ.optional.add(new MediaConstraints.KeyValuePair("DtlsSrtpKeyAgreement", "true"));
        this.videoWidth = this.cwS.videoWidth;
        this.videoHeight = this.cwS.videoHeight;
        this.cxd = this.cwS.cxd;
        if (this.videoWidth == 0 || this.videoHeight == 0) {
            this.videoWidth = PlatformPlugin.DEFAULT_SYSTEM_UI;
            this.videoHeight = 720;
        }
        if (this.cxd == 0) {
            this.cxd = 30;
        }
        Logging.d("PCRTCClient", "Capturing format: " + this.videoWidth + "x" + this.videoHeight + "@" + this.cxd);
        this.cww = new MediaConstraints();
        if (this.cwS.cxJ) {
            Log.d("PCRTCClient", "Disabling audio processing");
            this.cww.mandatory.add(new MediaConstraints.KeyValuePair("googEchoCancellation", "false"));
            this.cww.mandatory.add(new MediaConstraints.KeyValuePair("googAutoGainControl", "false"));
            this.cww.mandatory.add(new MediaConstraints.KeyValuePair("googHighpassFilter", "false"));
            this.cww.mandatory.add(new MediaConstraints.KeyValuePair("googNoiseSuppression", "false"));
        }
        this.cwX = new MediaConstraints();
        if (this.mHasAudio) {
            this.cwX.mandatory.add(new MediaConstraints.KeyValuePair("OfferToReceiveAudio", "true"));
        }
        if (this.mHasVideo) {
            this.cwX.mandatory.add(new MediaConstraints.KeyValuePair("OfferToReceiveVideo", "true"));
        }
        if (this.cwM) {
            this.cwX.mandatory.add(new MediaConstraints.KeyValuePair("data", "true"));
        }
    }

    public static PeerConnectionClient aii() {
        PeerConnectionClient peerConnectionClient;
        synchronized (PeerConnectionClient.class) {
            try {
                peerConnectionClient = new PeerConnectionClient();
            } catch (Throwable th) {
                throw th;
            }
        }
        return peerConnectionClient;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQ(Context context) {
        boolean z = false;
        if (this.cwS.cxK) {
            PeerConnectionFactory.startInternalTracingCapture(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "webrtc-trace.txt");
        }
        Log.d("PCRTCClient", "Create peer connection factory. Use video: true");
        this.cwE = false;
        this.cwT = "VP8";
        if (this.cwS.cxN != null) {
            if (this.cwS.cxN.equals("VP9")) {
                this.cwT = "VP9";
            } else if (this.cwS.cxN.equals("H264")) {
                this.cwT = "H264";
            }
        }
        Log.d("PCRTCClient", "Pereferred video codec: " + this.cwT);
        if (this.cwS.cxM) {
            Log.d("PCRTCClient", "Allow OpenSL ES audio if device supports it");
            WebRtcAudioManager.setBlacklistDeviceForOpenSLESUsage(false);
        } else {
            Log.d("PCRTCClient", "Disable OpenSL ES audio even if device supports it");
            WebRtcAudioManager.setBlacklistDeviceForOpenSLESUsage(true);
        }
        if (this.cwS.cxz) {
            Log.d("PCRTCClient", "Disable built-in AEC even if device supports it");
            WebRtcAudioUtils.setWebRtcBasedAcousticEchoCanceler(true);
        } else {
            Log.d("PCRTCClient", "Enable built-in AEC if device supports it");
            WebRtcAudioUtils.setWebRtcBasedAcousticEchoCanceler(false);
        }
        if (this.cwS.cxA) {
            Log.d("PCRTCClient", "Disable built-in AGC even if device supports it");
            WebRtcAudioUtils.setWebRtcBasedAutomaticGainControl(true);
        } else {
            Log.d("PCRTCClient", "Enable built-in AGC if device supports it");
            WebRtcAudioUtils.setWebRtcBasedAutomaticGainControl(false);
        }
        if (this.cwS.cxB) {
            Log.d("PCRTCClient", "Disable built-in NS even if device supports it");
            WebRtcAudioUtils.setWebRtcBasedNoiseSuppressor(true);
        } else {
            Log.d("PCRTCClient", "Enable built-in NS if device supports it");
            WebRtcAudioUtils.setWebRtcBasedNoiseSuppressor(false);
        }
        this.context = context;
        this.cwv = new MediaConstraints();
        this.cwv.mandatory.add(new MediaConstraints.KeyValuePair("OfferToReceiveAudio", "true"));
        this.cwv.mandatory.add(new MediaConstraints.KeyValuePair("OfferToReceiveVideo", "true"));
        String str = this.cwS.cxC ? "WebRTC-FlexFEC-03-Advertised/Enabled/WebRTC-FlexFEC-03/Enabled/" : "";
        if (this.cwS.cxD) {
            str = str + "BRTC.Fixed.Resolution/Enabled/";
        }
        if (this.cwS.cxH == 0 || this.cwS.cxH == 1 || this.cwS.cxH == 2) {
            str = str + "BRTC-Encoder-BitrateMode/" + this.cwS.cxH + "/";
        }
        if (this.cwS.cxE) {
            str = (str + "WebRTC-H264HighProfile/Enabled/") + "WebRTC-MediaTekH264/Enabled/";
        }
        if (this.cwS.cxF) {
            str = str + "BRTC.HisiH264HW/Enabled/";
        }
        int i = 0;
        while (true) {
            if (i >= MediaCodecList.getCodecCount()) {
                break;
            }
            MediaCodecInfo mediaCodecInfo = null;
            try {
                mediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
            } catch (IllegalArgumentException e) {
                Logging.e("PCRTCClient", "Cannot retrieve encoder codec info", e);
            }
            if (mediaCodecInfo != null && mediaCodecInfo.isEncoder() && mediaCodecInfo.getName().startsWith("OMX.hisi.")) {
                z = true;
                break;
            }
            i++;
        }
        if (this.cwS.cxG || z) {
            str = str + "BRTC.Required.Resolustion.Aligment32/Enabled/";
        }
        PeerConnectionFactory.initialize(PeerConnectionFactory.InitializationOptions.builder(context).setFieldTrials(str).createInitializationOptions());
        AudioDeviceModule aij = aij();
        this.cwu = (JavaAudioDeviceModule) aij;
        this.cwB = PeerConnectionFactory.builder().setAudioDeviceModule(aij).setVideoDecoderFactory(MediaCodecVideoDecoder.createFactory()).setVideoEncoderFactory(MediaCodecVideoEncoder.createFactory()).createPeerConnectionFactory();
        Log.d("PCRTCClient", "Peer connection factory created.");
        aij.release();
        if (!this.cwO) {
            Logging.enableLogToDebugOutput(Logging.Severity.LS_ERROR);
            return;
        }
        Logging.enableLogThreads();
        Logging.enableLogTimeStamps();
        Logging.enableLogToDebugOutput(Logging.Severity.LS_VERBOSE);
    }

    private void g(BigInteger bigInteger) {
        for (RtpSender rtpSender : this.cwR.get(bigInteger).cwi.getSenders()) {
            if (rtpSender.track() != null && rtpSender.track().kind().equals("video")) {
                Log.d("PCRTCClient", "Found video sender.");
                this.cwI = rtpSender;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportError(final String str) {
        Log.e("PCRTCClient", "Peerconnection error: " + str);
        if (this.executor.isShutdown()) {
            Log.w("PCRTCClient", "executor is already shutdown");
        } else {
            this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.7
                @Override // java.lang.Runnable
                public void run() {
                    if (PeerConnectionClient.this.cwE) {
                        return;
                    }
                    PeerConnectionClient.this.cwA.kp(str);
                    PeerConnectionClient.this.cwE = true;
                }
            });
        }
    }

    public void a(final Context context, c cVar, b bVar) {
        this.cwS = cVar;
        this.cwA = bVar;
        this.context = null;
        this.cwB = null;
        this.cxc = false;
        this.cwE = false;
        this.cwP = null;
        this.cxb = null;
        this.cwW = !cVar.cxy;
        this.cwJ = null;
        this.cwV = null;
        this.cwI = null;
        this.cwz = !cVar.cxI;
        this.cwF = null;
        this.cwY = new Timer();
        if (this.executor.isShutdown()) {
            Log.w("PCRTCClient", "executor is already shutdown");
        } else {
            this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.1
                @Override // java.lang.Runnable
                public void run() {
                    PeerConnectionClient.this.bQ(context);
                }
            });
        }
    }

    public void a(final BigInteger bigInteger, final SessionDescription sessionDescription) {
        if (this.executor.isShutdown()) {
            Log.w("PCRTCClient", "executor is already shutdown");
        } else {
            this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.4
                @Override // java.lang.Runnable
                public void run() {
                    PeerConnection peerConnection = ((com.baidu.rtc.a) PeerConnectionClient.this.cwR.get(bigInteger)).cwi;
                    d dVar = ((com.baidu.rtc.a) PeerConnectionClient.this.cwR.get(bigInteger)).cwj;
                    if (peerConnection == null || PeerConnectionClient.this.cwE) {
                        return;
                    }
                    String str = sessionDescription.description;
                    m.a aVar = new m.a();
                    aVar.cys = PeerConnectionClient.this.cwS.cxu == RtcParameterSettings.RtcAudioBitrateMode.RTC_AUDIO_BITRATE_CBR;
                    aVar.cyt = PeerConnectionClient.this.cwS.cxw;
                    aVar.cyw = PeerConnectionClient.this.cwS.cxL == RtcParameterSettings.RtcAudioChannel.RTC_AUDIO_STEREO;
                    peerConnection.setRemoteDescription(dVar, new SessionDescription(sessionDescription.type, m.a(PeerConnectionClient.this.cwS.cxv, str, aVar)));
                }
            });
        }
    }

    public void a(final EglBase.Context context, VideoSink videoSink, VideoCapturer videoCapturer, final BigInteger bigInteger) {
        if (this.cwS == null) {
            Log.e("PCRTCClient", "Creating peer connection without initializing factory.");
            return;
        }
        this.cwG = videoSink;
        this.cxb = videoCapturer;
        if (this.executor.isShutdown()) {
            Log.w("PCRTCClient", "executor is already shutdown");
        } else {
            this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.8
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        PeerConnectionClient.this.aih();
                        PeerConnectionClient.this.a(context, bigInteger);
                    } catch (Exception e) {
                        PeerConnectionClient peerConnectionClient = PeerConnectionClient.this;
                        peerConnectionClient.reportError("Failed to create peer connection: " + e.getMessage());
                        throw e;
                    }
                }
            });
        }
    }

    public void a(JavaAudioDeviceModule.RemoteSamplesReadyCallback remoteSamplesReadyCallback) {
        this.cwN = remoteSamplesReadyCallback;
    }

    public void a(JavaAudioDeviceModule.SamplesReadyCallback samplesReadyCallback) {
        this.cwC = samplesReadyCallback;
    }

    public void a(boolean z, int i, final BigInteger bigInteger, final StatsEventsType statsEventsType) {
        TimerTask timerTask = null;
        if (!z) {
            if (statsEventsType == StatsEventsType.GET_AUDIOLEVEL_EVENT) {
                timerTask = this.cxa.get(bigInteger);
            } else {
                StatsEventsType statsEventsType2 = StatsEventsType.GET_QUALITY_MONITOR_EVENT;
            }
            if (timerTask != null) {
                timerTask.cancel();
                return;
            }
            return;
        }
        try {
            if (statsEventsType == StatsEventsType.GET_AUDIOLEVEL_EVENT) {
                timerTask = this.cxa.get(bigInteger);
            } else if (statsEventsType == StatsEventsType.GET_QUALITY_MONITOR_EVENT) {
                this.cwZ.get(bigInteger);
            }
            if (timerTask != null) {
                timerTask.cancel();
            }
            TimerTask timerTask2 = new TimerTask() { // from class: com.baidu.rtc.PeerConnectionClient.15
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (PeerConnectionClient.this.executor.isShutdown()) {
                        return;
                    }
                    PeerConnectionClient.this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.15.1
                        @Override // java.lang.Runnable
                        public void run() {
                            PeerConnectionClient.this.a(bigInteger, statsEventsType);
                        }
                    });
                }
            };
            if (statsEventsType == StatsEventsType.GET_AUDIOLEVEL_EVENT) {
                this.cxa.put(bigInteger, timerTask2);
            } else if (statsEventsType == StatsEventsType.GET_QUALITY_MONITOR_EVENT) {
                this.cwZ.put(bigInteger, timerTask2);
            }
            this.cwY.schedule(timerTask2, 0L, i);
        } catch (Exception e) {
            Log.e("PCRTCClient", "Can not schedule statistics timer", e);
        }
    }

    AudioDeviceModule aij() {
        AudioDeviceModule createAudioDeviceModule = JavaAudioDeviceModule.builder(this.context).setSamplesReadyCallback(this.cwC).setRemoteSamplesReadyCallback(this.cwN).setExternalAudioRecord(this.cwL).setUseHardwareAcousticEchoCanceler(!this.cwS.cxz).setUseHardwareNoiseSuppressor(!this.cwS.cxB).setAudioRecordErrorCallback(new JavaAudioDeviceModule.AudioRecordErrorCallback() { // from class: com.baidu.rtc.PeerConnectionClient.11
            @Override // org.webrtc.audio.JavaAudioDeviceModule.AudioRecordErrorCallback
            public void onWebRtcAudioRecordError(String str) {
                Log.e("PCRTCClient", "onWebRtcAudioRecordError: " + str);
                PeerConnectionClient.this.reportError(str);
            }

            @Override // org.webrtc.audio.JavaAudioDeviceModule.AudioRecordErrorCallback
            public void onWebRtcAudioRecordInitError(String str) {
                Log.e("PCRTCClient", "onWebRtcAudioRecordInitError: " + str);
                PeerConnectionClient.this.reportError(str);
            }

            @Override // org.webrtc.audio.JavaAudioDeviceModule.AudioRecordErrorCallback
            public void onWebRtcAudioRecordStartError(JavaAudioDeviceModule.AudioRecordStartErrorCode audioRecordStartErrorCode, String str) {
                Log.e("PCRTCClient", "onWebRtcAudioRecordStartError: " + audioRecordStartErrorCode + ". " + str);
            }
        }).setAudioTrackErrorCallback(new JavaAudioDeviceModule.AudioTrackErrorCallback() { // from class: com.baidu.rtc.PeerConnectionClient.12
            @Override // org.webrtc.audio.JavaAudioDeviceModule.AudioTrackErrorCallback
            public void onWebRtcAudioTrackError(String str) {
                Log.e("PCRTCClient", "onWebRtcAudioTrackError: " + str);
                PeerConnectionClient.this.reportError(str);
            }

            @Override // org.webrtc.audio.JavaAudioDeviceModule.AudioTrackErrorCallback
            public void onWebRtcAudioTrackInitError(String str) {
                Log.e("PCRTCClient", "onWebRtcAudioTrackInitError: " + str);
                PeerConnectionClient.this.reportError(str);
            }

            @Override // org.webrtc.audio.JavaAudioDeviceModule.AudioTrackErrorCallback
            public void onWebRtcAudioTrackStartError(JavaAudioDeviceModule.AudioTrackStartErrorCode audioTrackStartErrorCode, String str) {
                Log.e("PCRTCClient", "onWebRtcAudioTrackStartError: " + audioTrackStartErrorCode + ". " + str);
                PeerConnectionClient.this.reportError(str);
            }
        }).setSampleRate(this.cwK).setUseStereoInput(this.mAudioChannel > 1).setUseStereoOutput(this.mAudioChannel > 1).createAudioDeviceModule();
        if (this.cwL && (createAudioDeviceModule instanceof JavaAudioDeviceModule)) {
            this.externalSamplesCallback = ((JavaAudioDeviceModule) createAudioDeviceModule).getExternalSamplesReadyCallback();
        }
        return createAudioDeviceModule;
    }

    public void aik() {
        if (this.executor.isShutdown()) {
            Log.w("PCRTCClient", "executor is already shutdown");
        } else {
            this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.6
                @Override // java.lang.Runnable
                public void run() {
                    if (PeerConnectionClient.this.cxb == null || PeerConnectionClient.this.cxc) {
                        return;
                    }
                    Log.d("PCRTCClient", "Stop video source.");
                    try {
                        PeerConnectionClient.this.cxb.stopCapture();
                    } catch (InterruptedException e) {
                    }
                    PeerConnectionClient.this.cxc = true;
                }
            });
        }
    }

    public void b(final BigInteger bigInteger, final SessionDescription sessionDescription) {
        if (this.executor.isShutdown()) {
            Log.w("PCRTCClient", "executor is already shutdown");
        } else {
            this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.5
                @Override // java.lang.Runnable
                public void run() {
                    PeerConnection a2 = PeerConnectionClient.this.a(bigInteger, false);
                    d dVar = ((com.baidu.rtc.a) PeerConnectionClient.this.cwR.get(bigInteger)).cwj;
                    if (a2 == null || PeerConnectionClient.this.cwE) {
                        return;
                    }
                    a2.setRemoteDescription(dVar, sessionDescription);
                    Log.d("PCRTCClient", "PC create ANSWER");
                    a2.createAnswer(((com.baidu.rtc.a) PeerConnectionClient.this.cwR.get(bigInteger)).cwj, PeerConnectionClient.this.cwv);
                }
            });
        }
    }

    public void close() {
        this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.10
            @Override // java.lang.Runnable
            public void run() {
                PeerConnectionClient.this.aif();
            }
        });
        try {
            this.executor.shutdown();
            this.executor.awaitTermination(200L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
        }
    }

    public void d(final Integer num) {
        this.executor.execute(new Runnable() { // from class: com.baidu.rtc.q
            @Override // java.lang.Runnable
            public final void run() {
                PeerConnectionClient.a(PeerConnectionClient.this, num);
            }
        });
    }

    public void es(final boolean z) {
        if (this.executor.isShutdown()) {
            Log.w("PCRTCClient", "executor is already shutdown");
        } else {
            this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.16
                @Override // java.lang.Runnable
                public void run() {
                    PeerConnectionClient.this.cwz = z;
                    if (PeerConnectionClient.this.cwF != null) {
                        PeerConnectionClient.this.cwF.setEnabled(PeerConnectionClient.this.cwz);
                    }
                }
            });
        }
    }

    public void et(boolean z) {
        this.cwO = z;
    }

    public void eu(boolean z) {
        this.cwL = z;
    }

    public void ev(boolean z) {
        this.mHasAudio = z;
    }

    public void ew(boolean z) {
        this.cwM = z;
    }

    public void ex(boolean z) {
        this.mHasVideo = z;
    }

    public void ey(final boolean z) {
        if (this.executor.isShutdown()) {
            Log.w("PCRTCClient", "executor is already shutdown");
        } else {
            this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.2
                @Override // java.lang.Runnable
                public void run() {
                    PeerConnectionClient.this.cwW = z;
                    if (PeerConnectionClient.this.cwJ != null) {
                        PeerConnectionClient.this.cwJ.setEnabled(PeerConnectionClient.this.cwW);
                    }
                }
            });
        }
    }

    public void h(final BigInteger bigInteger) {
        if (this.executor == null || this.executor.isShutdown()) {
            return;
        }
        this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.13
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.rtc.a aVar;
                if (PeerConnectionClient.this.cwR == null || (aVar = (com.baidu.rtc.a) PeerConnectionClient.this.cwR.get(bigInteger)) == null) {
                    return;
                }
                if (aVar.cwi != null) {
                    aVar.cwi.close();
                    aVar.cwi.dispose();
                    aVar.cwi = null;
                }
                if (aVar.cwj != null) {
                    aVar.cwj.close();
                    aVar.cwj = null;
                }
                PeerConnectionClient.this.cwR.remove(bigInteger);
            }
        });
    }

    public void hx(int i) {
        this.cwK = i;
    }

    public void i(final BigInteger bigInteger) {
        if (this.executor.isShutdown()) {
            Log.w("PCRTCClient", "executor is already shutdown");
        } else {
            this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.3
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.rtc.a aVar = (com.baidu.rtc.a) PeerConnectionClient.this.cwR.get(bigInteger);
                    PeerConnection peerConnection = aVar.cwi;
                    if (peerConnection == null || PeerConnectionClient.this.cwE) {
                        return;
                    }
                    Log.d("PCRTCClient", "PC Create OFFER");
                    peerConnection.createOffer(aVar.cwj, PeerConnectionClient.this.cwX);
                }
            });
        }
    }

    public com.baidu.rtc.a j(BigInteger bigInteger) {
        return this.cwR.get(bigInteger);
    }

    @Override // org.webrtc.DataChannel.Observer
    public void onBufferedAmountChange(long j) {
    }

    @Override // org.webrtc.DataChannel.Observer
    public void onMessage(DataChannel.Buffer buffer) {
        this.cwA.l(buffer.data);
    }

    @Override // org.webrtc.DataChannel.Observer
    public void onStateChange() {
    }

    public void setAudioChannel(int i) {
        this.mAudioChannel = i;
    }

    public void setSpeakerMute(final boolean z) {
        if (this.executor.isShutdown()) {
            Log.w("PCRTCClient", "executor is already shutdown");
        } else {
            this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.9
                @Override // java.lang.Runnable
                public void run() {
                    if (PeerConnectionClient.this.cwu != null) {
                        PeerConnectionClient.this.cwu.setSpeakerMute(z);
                    }
                }
            });
        }
    }
}
