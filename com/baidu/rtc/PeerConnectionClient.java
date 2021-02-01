package com.baidu.rtc;

import android.content.Context;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Environment;
import android.util.Log;
import com.baidu.mobstat.Config;
import com.baidu.rtc.RtcParameterSettings;
import com.baidu.rtc.m;
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
    private b ctA;
    private PeerConnectionFactory ctB;
    private JavaAudioDeviceModule.SamplesReadyCallback ctC;
    private boolean ctE;
    private AudioTrack ctF;
    private VideoSink ctG;
    private SurfaceTextureHelper ctH;
    private RtpSender ctI;
    private VideoTrack ctJ;
    private boolean ctL;
    private JavaAudioDeviceModule.RemoteSamplesReadyCallback ctN;
    private MediaStream ctQ;
    private MediaConstraints ctR;
    private c ctT;
    private String ctU;
    private VideoTrack ctW;
    private boolean ctX;
    private MediaConstraints ctY;
    private Timer ctZ;
    private MediaConstraints ctu;
    private MediaConstraints ctv;
    private AudioSource ctw;
    private boolean ctz;
    private VideoCapturer cud;
    private boolean cue;
    private VideoSource cuf;
    private JavaAudioDeviceModule.ExternalSamplesReadyCallback externalSamplesCallback;
    private int videoFps;
    private int videoHeight;
    private int videoWidth;
    PeerConnectionFactory.Options options = null;
    private Map<BigInteger, TimerTask> cuc = new ConcurrentHashMap();
    private Map<BigInteger, TimerTask> cua = new ConcurrentHashMap();
    private Map<BigInteger, TimerTask> cub = new ConcurrentHashMap();
    private boolean mHasVideo = true;
    private boolean mHasAudio = true;
    private boolean ctM = false;
    private int ctK = 48000;
    private int mAudioChannel = 1;
    private boolean ctD = true;
    private DataChannel cty = null;
    Map<BigInteger, Integer> ctV = new ConcurrentHashMap();
    private com.baidu.rtc.b.e ctO = null;
    private boolean ctP = false;
    private JavaAudioDeviceModule cts = null;
    private final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
    private ConcurrentHashMap<BigInteger, com.baidu.rtc.a> ctS = new ConcurrentHashMap<>();

    /* loaded from: classes10.dex */
    public enum StatsEventsType {
        GET_AUDIOLEVEL_EVENT,
        GET_QUALITY_MONITOR_EVENT,
        GET_BWE_EVENT,
        GET_SLI_EVENT
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a implements PeerConnection.Observer {
        private PeerConnection ctf;
        private com.baidu.rtc.a cup;

        private a() {
        }

        public void a(com.baidu.rtc.a aVar) {
            this.cup = aVar;
            this.ctf = aVar.ctf;
        }

        @Override // org.webrtc.PeerConnection.Observer
        public void onAddStream(final MediaStream mediaStream) {
            if (PeerConnectionClient.this.executor.isShutdown()) {
                Log.w("PCRTCClient", "executor is already shutdown");
            } else {
                PeerConnectionClient.this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.a.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.ctf == null || PeerConnectionClient.this.ctE) {
                            return;
                        }
                        Log.d("PCRTCClient", "=========== onAddStream ==========");
                        if (mediaStream.videoTracks.size() == 1) {
                            PeerConnectionClient.this.ctW = mediaStream.videoTracks.get(0);
                            PeerConnectionClient.this.ctW.setEnabled(true);
                            a.this.cup.cti = PeerConnectionClient.this.ctW;
                            PeerConnectionClient.this.ctA.b(a.this.cup);
                        }
                        PeerConnectionClient.this.ctA.a(mediaStream.videoTracks.size() != 0, mediaStream.audioTracks.size() != 0, a.this.cup.cte);
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
                        PeerConnectionClient.this.ctA.a(iceCandidate, a.this.cup.cte);
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
                        PeerConnectionClient.this.ctA.onIceCandidatesRemoved(iceCandidateArr);
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
                            PeerConnectionClient.this.ctA.aeJ();
                        } else if (iceConnectionState == PeerConnection.IceConnectionState.DISCONNECTED) {
                            PeerConnectionClient.this.ctA.aeK();
                        } else if (iceConnectionState == PeerConnection.IceConnectionState.FAILED) {
                            PeerConnectionClient.this.ctA.aeL();
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
                        PeerConnectionClient.this.ctW = null;
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

        void aeJ();

        void aeK();

        void aeL();

        void aeM();

        void b(com.baidu.rtc.a aVar);

        void jv(String str);

        void l(ByteBuffer byteBuffer);

        void onIceCandidatesRemoved(IceCandidate[] iceCandidateArr);
    }

    /* loaded from: classes10.dex */
    public static class c {
        public final int audioSource;
        public final int cuA;
        public final int cuB;
        public final int cuC;
        public final int cuD;
        public final boolean cuE;
        public final boolean cuF;
        public final boolean cuG;
        public final boolean cuH;
        public final boolean cuI;
        public final boolean cuJ;
        public final boolean cuK;
        public final boolean cuL;
        public final boolean cuM;
        public final boolean cuN;
        public final int cuO;
        public final boolean cuP;
        public final boolean cuQ;
        public final boolean cuR;
        public RtcParameterSettings.RtcAudioChannel cuS;
        public final boolean cuT;
        public final String cuU;
        public final boolean cuV;
        public final int cuW;
        public final int cuX;
        public RtcParameterSettings.RtcAudioBitrateMode cux;
        public final int cuy;
        public final String cuz;
        public final int videoFps;
        public final int videoHeight;
        public final int videoWidth;

        public c(boolean z, int i, int i2, int i3, String str, boolean z2, int i4, String str2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, int i5, int i6, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, boolean z13, int i7, RtcParameterSettings.RtcAudioBitrateMode rtcAudioBitrateMode, RtcParameterSettings.RtcAudioChannel rtcAudioChannel, int i8, boolean z14, boolean z15, int i9, int i10, int i11, int i12) {
            this.cuR = z;
            this.videoWidth = i;
            this.videoHeight = i2;
            this.videoFps = i3;
            this.cuU = str;
            this.cuV = z2;
            this.cuD = i4;
            this.cuz = str2;
            this.cuQ = z3;
            this.cuT = z4;
            this.cuF = z5;
            this.cuG = z6;
            this.cuH = z7;
            this.cuW = i5;
            this.cuX = i6;
            this.cuP = z8;
            this.cuE = z9;
            this.cuI = z10;
            this.cuJ = z11;
            this.cuN = z12;
            this.cuK = z13;
            this.cuB = i7;
            this.cux = rtcAudioBitrateMode;
            this.cuS = rtcAudioChannel;
            this.cuO = i8;
            this.cuL = z14;
            this.cuM = z15;
            this.audioSource = i9;
            this.cuy = i10;
            this.cuC = i11;
            this.cuA = i12;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class d implements SdpObserver {
        private c ctd;
        private BigInteger cte;
        private PeerConnection ctf;
        private d ctg;
        private boolean cth;
        private SessionDescription cuY;

        d() {
        }

        public void a(com.baidu.rtc.a aVar) {
            this.ctf = aVar.ctf;
            this.ctg = aVar.ctg;
            this.cte = aVar.cte;
            this.cth = aVar.cth;
            this.ctd = aVar.ctd;
        }

        public void close() {
            this.ctf = null;
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
            this.cuY = sessionDescription2;
            if (PeerConnectionClient.this.executor.isShutdown()) {
                Log.w("PCRTCClient", "executor is already shutdown");
            } else {
                PeerConnectionClient.this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.d.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (d.this.ctf == null || PeerConnectionClient.this.ctE) {
                            return;
                        }
                        Log.d("PCRTCClient", "Set local SDP from " + sessionDescription2.type);
                        d.this.ctf.setLocalDescription(d.this.ctg, sessionDescription2);
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
                        if (d.this.ctf == null || PeerConnectionClient.this.ctE) {
                            return;
                        }
                        if (!d.this.cth) {
                            if (d.this.ctf.getLocalDescription() == null) {
                                Log.d("PCRTCClient", "answer Remote SDP set succesfully");
                                return;
                            }
                            Log.d("PCRTCClient", "answer Local SDP set succesfully");
                            PeerConnectionClient.this.ctA.a(d.this.cuY, d.this.cte);
                        } else if (d.this.ctf.getRemoteDescription() != null) {
                            Log.d("PCRTCClient", "Remote SDP set succesfully");
                        } else {
                            Log.d("PCRTCClient", "Local SDP set succesfully");
                            PeerConnectionClient.this.ctA.a(d.this.cuY, d.this.cte, d.this.cuY.description.contains("profile-level-id=640c1f"));
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
        PeerConnection.RTCConfiguration rTCConfiguration = new PeerConnection.RTCConfiguration(arrayList);
        rTCConfiguration.audioJitterBufferMaxPackets = this.ctT.cuy;
        a aVar = new a();
        d dVar = new d();
        PeerConnection createPeerConnection = this.ctB.createPeerConnection(rTCConfiguration, aVar);
        com.baidu.rtc.a aVar2 = new com.baidu.rtc.a();
        aVar2.cte = bigInteger;
        aVar2.ctg = dVar;
        aVar2.ctf = createPeerConnection;
        aVar2.cth = z;
        aVar2.ctj = -1;
        aVar2.ctd = this.ctT;
        this.ctS.put(bigInteger, aVar2);
        aVar.a(aVar2);
        dVar.a(aVar2);
        DataChannel.Init init = new DataChannel.Init();
        if (this.ctM && z) {
            this.cty = createPeerConnection.createDataChannel("JanusDataChannel", init);
        }
        Log.d("PCRTCClient", "Peer connection created.");
        return createPeerConnection;
    }

    private VideoTrack a(EglBase.Context context, VideoCapturer videoCapturer) {
        this.cuf = this.ctB.createVideoSource(false);
        this.ctH = SurfaceTextureHelper.create("video renderer", context);
        videoCapturer.initialize(this.ctH, this.context, this.cuf.getCapturerObserver());
        videoCapturer.startCapture(this.videoWidth, this.videoHeight, this.videoFps);
        this.ctJ = this.ctB.createVideoTrack("ARDAMSv0", this.cuf);
        this.ctJ.setEnabled(this.ctX);
        this.ctJ.addSink(this.ctG);
        return this.ctJ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(PeerConnectionClient peerConnectionClient, Integer num) {
        if (peerConnectionClient.ctI == null) {
            return;
        }
        Log.d("PCRTCClient", "Requested max video bitrate: " + num);
        if (peerConnectionClient.ctI == null) {
            Log.w("PCRTCClient", "Sender is not ready.");
            return;
        }
        RtpParameters parameters = peerConnectionClient.ctI.getParameters();
        if (parameters.encodings.size() == 0) {
            Log.w("PCRTCClient", "RtpParameters are not ready.");
            return;
        }
        for (RtpParameters.Encoding encoding : parameters.encodings) {
            encoding.maxBitrateBps = num == null ? null : Integer.valueOf(num.intValue() * 1000);
        }
        if (!peerConnectionClient.ctI.setParameters(parameters)) {
            Log.e("PCRTCClient", "RtpSender.setParameters failed.");
        }
        Log.d("PCRTCClient", "Configured max video bitrate to: " + num);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final BigInteger bigInteger, final StatsEventsType statsEventsType) {
        if (this.ctS.get(bigInteger).ctf.getStats(new StatsObserver() { // from class: com.baidu.rtc.PeerConnectionClient.17
            @Override // org.webrtc.StatsObserver
            public void onComplete(StatsReport[] statsReportArr) {
                PeerConnectionClient.this.ctA.a(statsReportArr, bigInteger, statsEventsType);
            }
        }, null)) {
            return;
        }
        Log.e("PCRTCClient", "getStats() returns false!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(EglBase.Context context, BigInteger bigInteger) {
        if (this.ctB == null || this.ctE) {
            Log.e("PCRTCClient", "Peerconnection factory is not created");
            return;
        }
        Log.d("PCRTCClient", "PCConstraints: " + this.ctR.toString());
        Log.d("PCRTCClient", "EGLContext: " + context);
        PeerConnection a2 = a(bigInteger, true);
        this.ctQ = this.ctB.createLocalMediaStream("ARDAMS");
        if (this.mHasVideo) {
            this.ctQ.addTrack(a(context, this.cud));
        }
        if (this.mHasAudio) {
            this.ctQ.addTrack(aeD());
        }
        a2.addStream(this.ctQ);
        g(bigInteger);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aeC() {
        Log.d("PCRTCClient", "Closing peer connection.");
        this.ctZ.cancel();
        if (this.ctS != null) {
            int size = this.ctS.size();
            for (int i = 0; i < size; i++) {
                com.baidu.rtc.a aVar = (com.baidu.rtc.a) this.ctS.values().toArray()[i];
                aVar.ctf.close();
                aVar.ctf.dispose();
                aVar.ctf = null;
                aVar.ctg.close();
            }
        }
        Log.d("PCRTCClient", "Closing audio source.");
        if (this.ctw != null) {
            this.ctw.dispose();
            this.ctw = null;
        }
        Log.d("PCRTCClient", "Stopping capture.");
        if (this.cud != null) {
            try {
                this.cud.stopCapture();
                this.cue = true;
                this.cud.dispose();
                this.cud = null;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        Log.d("PCRTCClient", "Closing video source.");
        if (this.cuf != null) {
            this.cuf.dispose();
            this.cuf = null;
        }
        if (this.ctH != null) {
            this.ctH.dispose();
            this.ctH = null;
        }
        Log.d("PCRTCClient", "Closing peer connection factory.");
        if (this.ctB != null) {
            this.ctB.dispose();
            this.ctB = null;
        }
        this.options = null;
        Log.d("PCRTCClient", "Closing peer connection done.");
        this.ctA.aeM();
        PeerConnectionFactory.stopInternalTracingCapture();
        PeerConnectionFactory.shutdownInternalTracer();
    }

    private AudioTrack aeD() {
        this.ctw = this.ctB.createAudioSource(this.ctv);
        this.ctF = this.ctB.createAudioTrack("ARDAMSa0", this.ctw);
        this.ctF.setEnabled(this.ctz);
        return this.ctF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aeE() {
        this.ctR = new MediaConstraints();
        this.ctR.optional.add(new MediaConstraints.KeyValuePair("DtlsSrtpKeyAgreement", "true"));
        this.videoWidth = this.ctT.videoWidth;
        this.videoHeight = this.ctT.videoHeight;
        this.videoFps = this.ctT.videoFps;
        if (this.videoWidth == 0 || this.videoHeight == 0) {
            this.videoWidth = 1280;
            this.videoHeight = 720;
        }
        if (this.videoFps == 0) {
            this.videoFps = 30;
        }
        Logging.d("PCRTCClient", "Capturing format: " + this.videoWidth + Config.EVENT_HEAT_X + this.videoHeight + "@" + this.videoFps);
        this.ctv = new MediaConstraints();
        if (this.ctT.cuQ) {
            Log.d("PCRTCClient", "Disabling audio processing");
            this.ctv.mandatory.add(new MediaConstraints.KeyValuePair("googEchoCancellation", "false"));
            this.ctv.mandatory.add(new MediaConstraints.KeyValuePair("googAutoGainControl", "false"));
            this.ctv.mandatory.add(new MediaConstraints.KeyValuePair("googHighpassFilter", "false"));
            this.ctv.mandatory.add(new MediaConstraints.KeyValuePair("googNoiseSuppression", "false"));
        }
        this.ctY = new MediaConstraints();
        if (this.mHasAudio) {
            this.ctY.mandatory.add(new MediaConstraints.KeyValuePair("OfferToReceiveAudio", "true"));
        }
        if (this.mHasVideo) {
            this.ctY.mandatory.add(new MediaConstraints.KeyValuePair("OfferToReceiveVideo", "true"));
        }
        if (this.ctM) {
            this.ctY.mandatory.add(new MediaConstraints.KeyValuePair("data", "true"));
        }
    }

    public static PeerConnectionClient aeF() {
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
    public void bO(Context context) {
        boolean z = false;
        if (this.ctT.cuR) {
            PeerConnectionFactory.startInternalTracingCapture(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "webrtc-trace.txt");
        }
        Log.d("PCRTCClient", "Create peer connection factory. Use video: true");
        this.ctE = false;
        this.ctU = "VP8";
        if (this.ctT.cuU != null) {
            if (this.ctT.cuU.equals("VP9")) {
                this.ctU = "VP9";
            } else if (this.ctT.cuU.equals("H264")) {
                this.ctU = "H264";
            }
        }
        Log.d("PCRTCClient", "Pereferred video codec: " + this.ctU);
        if (this.ctT.cuT) {
            Log.d("PCRTCClient", "Allow OpenSL ES audio if device supports it");
            WebRtcAudioManager.setBlacklistDeviceForOpenSLESUsage(false);
        } else {
            Log.d("PCRTCClient", "Disable OpenSL ES audio even if device supports it");
            WebRtcAudioManager.setBlacklistDeviceForOpenSLESUsage(true);
        }
        if (this.ctT.cuF) {
            Log.d("PCRTCClient", "Disable built-in AEC even if device supports it");
            WebRtcAudioUtils.setWebRtcBasedAcousticEchoCanceler(true);
        } else {
            Log.d("PCRTCClient", "Enable built-in AEC if device supports it");
            WebRtcAudioUtils.setWebRtcBasedAcousticEchoCanceler(false);
        }
        if (this.ctT.cuG) {
            Log.d("PCRTCClient", "Disable built-in AGC even if device supports it");
            WebRtcAudioUtils.setWebRtcBasedAutomaticGainControl(true);
        } else {
            Log.d("PCRTCClient", "Enable built-in AGC if device supports it");
            WebRtcAudioUtils.setWebRtcBasedAutomaticGainControl(false);
        }
        if (this.ctT.cuH) {
            Log.d("PCRTCClient", "Disable built-in NS even if device supports it");
            WebRtcAudioUtils.setWebRtcBasedNoiseSuppressor(true);
        } else {
            Log.d("PCRTCClient", "Enable built-in NS if device supports it");
            WebRtcAudioUtils.setWebRtcBasedNoiseSuppressor(false);
        }
        this.context = context;
        this.ctu = new MediaConstraints();
        this.ctu.mandatory.add(new MediaConstraints.KeyValuePair("OfferToReceiveAudio", "true"));
        this.ctu.mandatory.add(new MediaConstraints.KeyValuePair("OfferToReceiveVideo", "true"));
        String str = this.ctT.cuI ? "WebRTC-FlexFEC-03-Advertised/Enabled/WebRTC-FlexFEC-03/Enabled/" : "";
        if (this.ctT.cuJ) {
            str = str + "BRTC.Fixed.Resolution/Enabled/";
        }
        if (this.ctT.cuO == 0 || this.ctT.cuO == 1 || this.ctT.cuO == 2) {
            str = str + "BRTC-Encoder-BitrateMode/" + this.ctT.cuO + "/";
        }
        if (this.ctT.cuK) {
            str = (str + "WebRTC-H264HighProfile/Enabled/") + "WebRTC-MediaTekH264/Enabled/";
        }
        if (this.ctT.cuL) {
            str = str + "BRTC.HisiH264HW/Enabled/";
        }
        if (this.ctT.cuM) {
            str = str + "BRTC.MTK.H264.Decode/Enabled/";
        }
        if (this.ctT.cuC >= 0) {
            str = str + "BRTC.Playout.Delay.AudioOnly/" + this.ctT.cuC + "/";
        }
        if (this.ctT.cuA >= 0) {
            str = str + "BRTC.Opus.Complexity/" + this.ctT.cuA + "/";
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
        if (this.ctT.cuN || z) {
            str = str + "BRTC.Required.Resolustion.Aligment32/Enabled/";
        }
        PeerConnectionFactory.initialize(PeerConnectionFactory.InitializationOptions.builder(context).setFieldTrials(str).createInitializationOptions());
        AudioDeviceModule aeG = aeG();
        this.cts = (JavaAudioDeviceModule) aeG;
        this.ctB = PeerConnectionFactory.builder().setAudioDeviceModule(aeG).setVideoDecoderFactory(MediaCodecVideoDecoder.createFactory()).setVideoEncoderFactory(MediaCodecVideoEncoder.createFactory()).createPeerConnectionFactory();
        Log.d("PCRTCClient", "Peer connection factory created.");
        aeG.release();
        if (!this.ctP) {
            Logging.enableLogToDebugOutput(Logging.Severity.LS_ERROR);
            return;
        }
        Logging.enableLogThreads();
        Logging.enableLogTimeStamps();
        Logging.enableLogToDebugOutput(Logging.Severity.LS_VERBOSE);
    }

    private void g(BigInteger bigInteger) {
        for (RtpSender rtpSender : this.ctS.get(bigInteger).ctf.getSenders()) {
            if (rtpSender.track() != null && rtpSender.track().kind().equals("video")) {
                Log.d("PCRTCClient", "Found video sender.");
                this.ctI = rtpSender;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportError(final String str) {
        Log.e("PCRTCClient", "Peerconnection error: " + str);
        if (this.executor.isShutdown()) {
            Log.w("PCRTCClient", "executor is already shutdown");
        } else {
            this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.8
                @Override // java.lang.Runnable
                public void run() {
                    if (PeerConnectionClient.this.ctE) {
                        return;
                    }
                    PeerConnectionClient.this.ctA.jv(str);
                    PeerConnectionClient.this.ctE = true;
                }
            });
        }
    }

    public void a(final Context context, c cVar, b bVar) {
        this.ctT = cVar;
        this.ctA = bVar;
        this.context = null;
        this.ctB = null;
        this.cue = false;
        this.ctE = false;
        this.ctQ = null;
        this.cud = null;
        this.ctX = !cVar.cuE;
        this.ctJ = null;
        this.ctW = null;
        this.ctI = null;
        this.ctz = !cVar.cuP;
        this.ctF = null;
        this.ctZ = new Timer();
        if (this.executor.isShutdown()) {
            Log.w("PCRTCClient", "executor is already shutdown");
        } else {
            this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.1
                @Override // java.lang.Runnable
                public void run() {
                    PeerConnectionClient.this.bO(context);
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
                    PeerConnection peerConnection = ((com.baidu.rtc.a) PeerConnectionClient.this.ctS.get(bigInteger)).ctf;
                    d dVar = ((com.baidu.rtc.a) PeerConnectionClient.this.ctS.get(bigInteger)).ctg;
                    if (peerConnection == null || PeerConnectionClient.this.ctE) {
                        return;
                    }
                    String str = sessionDescription.description;
                    m.a aVar = new m.a();
                    aVar.cvH = PeerConnectionClient.this.ctT.cux == RtcParameterSettings.RtcAudioBitrateMode.RTC_AUDIO_BITRATE_CBR;
                    aVar.cvI = PeerConnectionClient.this.ctT.cuB;
                    aVar.cvL = PeerConnectionClient.this.ctT.cuS == RtcParameterSettings.RtcAudioChannel.RTC_AUDIO_STEREO;
                    peerConnection.setRemoteDescription(dVar, new SessionDescription(sessionDescription.type, m.a(PeerConnectionClient.this.ctT.cuz, str, aVar)));
                }
            });
        }
    }

    public void a(final EglBase.Context context, VideoSink videoSink, VideoCapturer videoCapturer, final BigInteger bigInteger) {
        if (this.ctT == null) {
            Log.e("PCRTCClient", "Creating peer connection without initializing factory.");
            return;
        }
        this.ctG = videoSink;
        this.cud = videoCapturer;
        if (this.executor.isShutdown()) {
            Log.w("PCRTCClient", "executor is already shutdown");
        } else {
            this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.9
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        PeerConnectionClient.this.aeE();
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
        this.ctN = remoteSamplesReadyCallback;
    }

    public void a(JavaAudioDeviceModule.SamplesReadyCallback samplesReadyCallback) {
        this.ctC = samplesReadyCallback;
    }

    public void a(boolean z, int i, final BigInteger bigInteger, final StatsEventsType statsEventsType) {
        TimerTask timerTask = null;
        if (!z) {
            if (statsEventsType == StatsEventsType.GET_AUDIOLEVEL_EVENT) {
                timerTask = this.cuc.get(bigInteger);
            } else if (statsEventsType == StatsEventsType.GET_QUALITY_MONITOR_EVENT) {
                timerTask = this.cua.get(bigInteger);
            } else if (statsEventsType == StatsEventsType.GET_SLI_EVENT) {
                timerTask = this.cub.get(bigInteger);
            }
            if (timerTask != null) {
                timerTask.cancel();
                return;
            }
            return;
        }
        try {
            if (statsEventsType == StatsEventsType.GET_AUDIOLEVEL_EVENT) {
                timerTask = this.cuc.get(bigInteger);
            } else if (statsEventsType == StatsEventsType.GET_QUALITY_MONITOR_EVENT) {
                timerTask = this.cua.get(bigInteger);
            } else if (statsEventsType == StatsEventsType.GET_SLI_EVENT) {
                timerTask = this.cub.get(bigInteger);
            }
            if (timerTask != null) {
                timerTask.cancel();
            }
            TimerTask timerTask2 = new TimerTask() { // from class: com.baidu.rtc.PeerConnectionClient.18
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (PeerConnectionClient.this.executor.isShutdown()) {
                        return;
                    }
                    PeerConnectionClient.this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.18.1
                        @Override // java.lang.Runnable
                        public void run() {
                            PeerConnectionClient.this.a(bigInteger, statsEventsType);
                        }
                    });
                }
            };
            if (statsEventsType == StatsEventsType.GET_AUDIOLEVEL_EVENT) {
                this.cuc.put(bigInteger, timerTask2);
            } else if (statsEventsType == StatsEventsType.GET_QUALITY_MONITOR_EVENT) {
                this.cua.put(bigInteger, timerTask2);
            } else if (statsEventsType == StatsEventsType.GET_SLI_EVENT) {
                this.cub.put(bigInteger, timerTask2);
            }
            this.ctZ.schedule(timerTask2, 0L, i);
        } catch (Exception e) {
            Log.e("PCRTCClient", "Can not schedule statistics timer", e);
        }
    }

    AudioDeviceModule aeG() {
        AudioDeviceModule createAudioDeviceModule = JavaAudioDeviceModule.builder(this.context).setSamplesReadyCallback(this.ctC).setRemoteSamplesReadyCallback(this.ctN).setExternalAudioRecord(this.ctL).setUseHardwareAcousticEchoCanceler(!this.ctT.cuF).setUseHardwareNoiseSuppressor(!this.ctT.cuH).setAudioRecordErrorCallback(new JavaAudioDeviceModule.AudioRecordErrorCallback() { // from class: com.baidu.rtc.PeerConnectionClient.14
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
        }).setAudioTrackErrorCallback(new JavaAudioDeviceModule.AudioTrackErrorCallback() { // from class: com.baidu.rtc.PeerConnectionClient.15
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
        }).setSampleRate(this.ctK).setUseStereoInput(this.mAudioChannel > 1).setUseStereoOutput(this.mAudioChannel > 1).setAudioSource(this.ctT.audioSource).createAudioDeviceModule();
        if (this.ctL && (createAudioDeviceModule instanceof JavaAudioDeviceModule)) {
            this.externalSamplesCallback = ((JavaAudioDeviceModule) createAudioDeviceModule).getExternalSamplesReadyCallback();
        }
        return createAudioDeviceModule;
    }

    public void aeH() {
        if (this.executor.isShutdown()) {
            Log.w("PCRTCClient", "executor is already shutdown");
        } else {
            this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.7
                @Override // java.lang.Runnable
                public void run() {
                    if (PeerConnectionClient.this.ctw != null) {
                        PeerConnectionClient.this.ctw.dispose();
                        PeerConnectionClient.this.ctw = null;
                    }
                }
            });
        }
    }

    public void aeI() {
        if (this.executor.isShutdown()) {
            Log.w("PCRTCClient", "executor is already shutdown");
        } else {
            this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.6
                @Override // java.lang.Runnable
                public void run() {
                    if (PeerConnectionClient.this.cud == null || PeerConnectionClient.this.cue) {
                        return;
                    }
                    Log.d("PCRTCClient", "Stop video source.");
                    try {
                        PeerConnectionClient.this.cud.stopCapture();
                    } catch (InterruptedException e) {
                    }
                    PeerConnectionClient.this.cue = true;
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
                    d dVar = ((com.baidu.rtc.a) PeerConnectionClient.this.ctS.get(bigInteger)).ctg;
                    if (a2 == null || PeerConnectionClient.this.ctE) {
                        return;
                    }
                    a2.setRemoteDescription(dVar, sessionDescription);
                    Log.d("PCRTCClient", "PC create ANSWER");
                    a2.createAnswer(((com.baidu.rtc.a) PeerConnectionClient.this.ctS.get(bigInteger)).ctg, PeerConnectionClient.this.ctu);
                }
            });
        }
    }

    public void close() {
        this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.13
            @Override // java.lang.Runnable
            public void run() {
                PeerConnectionClient.this.aeC();
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

    public void eq(final boolean z) {
        if (this.executor.isShutdown()) {
            Log.w("PCRTCClient", "executor is already shutdown");
        } else {
            this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.19
                @Override // java.lang.Runnable
                public void run() {
                    PeerConnectionClient.this.ctz = z;
                    if (PeerConnectionClient.this.ctF != null) {
                        PeerConnectionClient.this.ctF.setEnabled(PeerConnectionClient.this.ctz);
                    }
                    if (PeerConnectionClient.this.cts != null) {
                        PeerConnectionClient.this.cts.setMicrophoneMute(!z);
                    }
                }
            });
        }
    }

    public void er(boolean z) {
        this.ctP = z;
    }

    public void es(boolean z) {
        this.ctL = z;
    }

    public void et(boolean z) {
        this.mHasAudio = z;
    }

    public void eu(boolean z) {
        this.ctM = z;
    }

    public void ev(boolean z) {
        this.mHasVideo = z;
    }

    public void ew(final boolean z) {
        if (this.executor.isShutdown()) {
            Log.w("PCRTCClient", "executor is already shutdown");
        } else {
            this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.2
                @Override // java.lang.Runnable
                public void run() {
                    PeerConnectionClient.this.ctX = z;
                    if (PeerConnectionClient.this.ctJ != null) {
                        PeerConnectionClient.this.ctJ.setEnabled(PeerConnectionClient.this.ctX);
                    }
                }
            });
        }
    }

    public void fT(int i) {
        this.ctK = i;
    }

    public void h(final BigInteger bigInteger) {
        if (this.executor == null || this.executor.isShutdown()) {
            return;
        }
        this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.16
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.rtc.a aVar;
                if (PeerConnectionClient.this.ctS == null || (aVar = (com.baidu.rtc.a) PeerConnectionClient.this.ctS.get(bigInteger)) == null) {
                    return;
                }
                if (aVar.ctf != null) {
                    aVar.ctf.close();
                    aVar.ctf.dispose();
                    aVar.ctf = null;
                }
                if (aVar.ctg != null) {
                    aVar.ctg.close();
                    aVar.ctg = null;
                }
                PeerConnectionClient.this.ctS.remove(bigInteger);
            }
        });
    }

    public void i(final BigInteger bigInteger) {
        if (this.executor.isShutdown()) {
            Log.w("PCRTCClient", "executor is already shutdown");
        } else {
            this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.3
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.rtc.a aVar = (com.baidu.rtc.a) PeerConnectionClient.this.ctS.get(bigInteger);
                    PeerConnection peerConnection = aVar.ctf;
                    if (peerConnection == null || PeerConnectionClient.this.ctE) {
                        return;
                    }
                    Log.d("PCRTCClient", "PC Create OFFER");
                    peerConnection.createOffer(aVar.ctg, PeerConnectionClient.this.ctY);
                }
            });
        }
    }

    public com.baidu.rtc.a j(BigInteger bigInteger) {
        return this.ctS.get(bigInteger);
    }

    @Override // org.webrtc.DataChannel.Observer
    public void onBufferedAmountChange(long j) {
    }

    @Override // org.webrtc.DataChannel.Observer
    public void onMessage(DataChannel.Buffer buffer) {
        this.ctA.l(buffer.data);
    }

    @Override // org.webrtc.DataChannel.Observer
    public void onStateChange() {
    }

    public void setAudioChannel(int i) {
        this.mAudioChannel = i;
    }

    public void setEnableSLIReport(final boolean z) {
        if (this.executor.isShutdown()) {
            Log.w("PCRTCClient", "executor is already shutdown");
        } else {
            this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.12
                @Override // java.lang.Runnable
                public void run() {
                    if (PeerConnectionClient.this.cts != null) {
                        PeerConnectionClient.this.cts.setEnableSLIReport(z);
                    }
                }
            });
        }
    }

    public void setSpeakerMute(final boolean z) {
        if (this.executor.isShutdown()) {
            Log.w("PCRTCClient", "executor is already shutdown");
        } else {
            this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.10
                @Override // java.lang.Runnable
                public void run() {
                    if (PeerConnectionClient.this.cts != null) {
                        PeerConnectionClient.this.cts.setSpeakerMute(z);
                    }
                }
            });
        }
    }

    public void setStuckEventListener(final com.baidu.rtc.b.e eVar) {
        if (this.executor.isShutdown()) {
            Log.w("PCRTCClient", "executor is already shutdown");
        } else {
            this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.11
                @Override // java.lang.Runnable
                public void run() {
                    PeerConnectionClient.this.ctO = eVar;
                    if (PeerConnectionClient.this.cts != null) {
                        PeerConnectionClient.this.cts.setStuckEventListener(eVar);
                    }
                }
            });
        }
    }
}
