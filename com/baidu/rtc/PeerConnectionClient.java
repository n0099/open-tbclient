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
/* loaded from: classes9.dex */
public class PeerConnectionClient implements DataChannel.Observer {
    private Context context;
    private MediaConstraints cuX;
    private MediaConstraints cuY;
    private AudioSource cuZ;
    private MediaConstraints cvA;
    private Timer cvB;
    private VideoCapturer cvF;
    private boolean cvG;
    private VideoSource cvH;
    private boolean cvb;
    private b cvc;
    private PeerConnectionFactory cvd;
    private JavaAudioDeviceModule.SamplesReadyCallback cve;
    private boolean cvg;
    private AudioTrack cvh;
    private VideoSink cvi;
    private SurfaceTextureHelper cvj;
    private RtpSender cvk;
    private VideoTrack cvl;
    private boolean cvn;
    private JavaAudioDeviceModule.RemoteSamplesReadyCallback cvp;
    private MediaStream cvs;
    private MediaConstraints cvt;
    private c cvv;
    private String cvw;
    private VideoTrack cvy;
    private boolean cvz;
    private JavaAudioDeviceModule.ExternalSamplesReadyCallback externalSamplesCallback;
    private int videoFps;
    private int videoHeight;
    private int videoWidth;
    PeerConnectionFactory.Options options = null;
    private Map<BigInteger, TimerTask> cvE = new ConcurrentHashMap();
    private Map<BigInteger, TimerTask> cvC = new ConcurrentHashMap();
    private Map<BigInteger, TimerTask> cvD = new ConcurrentHashMap();
    private boolean mHasVideo = true;
    private boolean mHasAudio = true;
    private boolean cvo = false;
    private int cvm = 48000;
    private int mAudioChannel = 1;
    private boolean cvf = true;
    private DataChannel cva = null;
    Map<BigInteger, Integer> cvx = new ConcurrentHashMap();
    private com.baidu.rtc.b.e cvq = null;
    private boolean cvr = false;
    private JavaAudioDeviceModule cuW = null;
    private final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
    private ConcurrentHashMap<BigInteger, com.baidu.rtc.a> cvu = new ConcurrentHashMap<>();

    /* loaded from: classes9.dex */
    public enum StatsEventsType {
        GET_AUDIOLEVEL_EVENT,
        GET_QUALITY_MONITOR_EVENT,
        GET_BWE_EVENT,
        GET_SLI_EVENT
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a implements PeerConnection.Observer {
        private PeerConnection cuK;
        private com.baidu.rtc.a cvR;

        private a() {
        }

        public void a(com.baidu.rtc.a aVar) {
            this.cvR = aVar;
            this.cuK = aVar.cuK;
        }

        @Override // org.webrtc.PeerConnection.Observer
        public void onAddStream(final MediaStream mediaStream) {
            if (PeerConnectionClient.this.executor.isShutdown()) {
                Log.w("PCRTCClient", "executor is already shutdown");
            } else {
                PeerConnectionClient.this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.a.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.cuK == null || PeerConnectionClient.this.cvg) {
                            return;
                        }
                        Log.d("PCRTCClient", "=========== onAddStream ==========");
                        if (mediaStream.videoTracks.size() == 1) {
                            PeerConnectionClient.this.cvy = mediaStream.videoTracks.get(0);
                            PeerConnectionClient.this.cvy.setEnabled(true);
                            a.this.cvR.cuN = PeerConnectionClient.this.cvy;
                            PeerConnectionClient.this.cvc.b(a.this.cvR);
                        }
                        PeerConnectionClient.this.cvc.a(mediaStream.videoTracks.size() != 0, mediaStream.audioTracks.size() != 0, a.this.cvR.cuJ);
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
                        PeerConnectionClient.this.cvc.a(iceCandidate, a.this.cvR.cuJ);
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
                        PeerConnectionClient.this.cvc.onIceCandidatesRemoved(iceCandidateArr);
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
                            PeerConnectionClient.this.cvc.aeM();
                        } else if (iceConnectionState == PeerConnection.IceConnectionState.DISCONNECTED) {
                            PeerConnectionClient.this.cvc.aeN();
                        } else if (iceConnectionState == PeerConnection.IceConnectionState.FAILED) {
                            PeerConnectionClient.this.cvc.aeO();
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
                        PeerConnectionClient.this.cvy = null;
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

    /* loaded from: classes9.dex */
    public interface b {
        void a(Boolean bool, Boolean bool2, BigInteger bigInteger);

        void a(IceCandidate iceCandidate, BigInteger bigInteger);

        void a(SessionDescription sessionDescription, BigInteger bigInteger);

        void a(SessionDescription sessionDescription, BigInteger bigInteger, boolean z);

        void a(StatsReport[] statsReportArr, BigInteger bigInteger, StatsEventsType statsEventsType);

        void aeM();

        void aeN();

        void aeO();

        void aeP();

        void b(com.baidu.rtc.a aVar);

        void jC(String str);

        void l(ByteBuffer byteBuffer);

        void onIceCandidatesRemoved(IceCandidate[] iceCandidateArr);
    }

    /* loaded from: classes9.dex */
    public static class c {
        public final int audioSource;
        public RtcParameterSettings.RtcAudioBitrateMode cvX;
        public final int cvY;
        public final String cvZ;
        public final int cwa;
        public final int cwb;
        public final int cwc;
        public final int cwd;
        public final boolean cwe;
        public final boolean cwf;
        public final boolean cwg;
        public final boolean cwh;
        public final boolean cwi;
        public final boolean cwj;
        public final boolean cwk;
        public final boolean cwl;
        public final boolean cwm;
        public final boolean cwn;
        public final int cwo;
        public final boolean cwp;
        public final boolean cwq;
        public final boolean cwr;
        public RtcParameterSettings.RtcAudioChannel cws;
        public final boolean cwt;
        public final String cwu;
        public final boolean cwv;
        public final int cww;
        public final int cwx;
        public final int videoFps;
        public final int videoHeight;
        public final int videoWidth;

        public c(boolean z, int i, int i2, int i3, String str, boolean z2, int i4, String str2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, int i5, int i6, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, boolean z13, int i7, RtcParameterSettings.RtcAudioBitrateMode rtcAudioBitrateMode, RtcParameterSettings.RtcAudioChannel rtcAudioChannel, int i8, boolean z14, boolean z15, int i9, int i10, int i11, int i12) {
            this.cwr = z;
            this.videoWidth = i;
            this.videoHeight = i2;
            this.videoFps = i3;
            this.cwu = str;
            this.cwv = z2;
            this.cwd = i4;
            this.cvZ = str2;
            this.cwq = z3;
            this.cwt = z4;
            this.cwf = z5;
            this.cwg = z6;
            this.cwh = z7;
            this.cww = i5;
            this.cwx = i6;
            this.cwp = z8;
            this.cwe = z9;
            this.cwi = z10;
            this.cwj = z11;
            this.cwn = z12;
            this.cwk = z13;
            this.cwb = i7;
            this.cvX = rtcAudioBitrateMode;
            this.cws = rtcAudioChannel;
            this.cwo = i8;
            this.cwl = z14;
            this.cwm = z15;
            this.audioSource = i9;
            this.cvY = i10;
            this.cwc = i11;
            this.cwa = i12;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class d implements SdpObserver {
        private c cuI;
        private BigInteger cuJ;
        private PeerConnection cuK;
        private d cuL;
        private boolean cuM;
        private SessionDescription cwy;

        d() {
        }

        public void a(com.baidu.rtc.a aVar) {
            this.cuK = aVar.cuK;
            this.cuL = aVar.cuL;
            this.cuJ = aVar.cuJ;
            this.cuM = aVar.cuM;
            this.cuI = aVar.cuI;
        }

        public void close() {
            this.cuK = null;
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
            this.cwy = sessionDescription2;
            if (PeerConnectionClient.this.executor.isShutdown()) {
                Log.w("PCRTCClient", "executor is already shutdown");
            } else {
                PeerConnectionClient.this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.d.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (d.this.cuK == null || PeerConnectionClient.this.cvg) {
                            return;
                        }
                        Log.d("PCRTCClient", "Set local SDP from " + sessionDescription2.type);
                        d.this.cuK.setLocalDescription(d.this.cuL, sessionDescription2);
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
                        if (d.this.cuK == null || PeerConnectionClient.this.cvg) {
                            return;
                        }
                        if (!d.this.cuM) {
                            if (d.this.cuK.getLocalDescription() == null) {
                                Log.d("PCRTCClient", "answer Remote SDP set succesfully");
                                return;
                            }
                            Log.d("PCRTCClient", "answer Local SDP set succesfully");
                            PeerConnectionClient.this.cvc.a(d.this.cwy, d.this.cuJ);
                        } else if (d.this.cuK.getRemoteDescription() != null) {
                            Log.d("PCRTCClient", "Remote SDP set succesfully");
                        } else {
                            Log.d("PCRTCClient", "Local SDP set succesfully");
                            PeerConnectionClient.this.cvc.a(d.this.cwy, d.this.cuJ, d.this.cwy.description.contains("profile-level-id=640c1f"));
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
        rTCConfiguration.audioJitterBufferMaxPackets = this.cvv.cvY;
        a aVar = new a();
        d dVar = new d();
        PeerConnection createPeerConnection = this.cvd.createPeerConnection(rTCConfiguration, aVar);
        com.baidu.rtc.a aVar2 = new com.baidu.rtc.a();
        aVar2.cuJ = bigInteger;
        aVar2.cuL = dVar;
        aVar2.cuK = createPeerConnection;
        aVar2.cuM = z;
        aVar2.cuO = -1;
        aVar2.cuI = this.cvv;
        this.cvu.put(bigInteger, aVar2);
        aVar.a(aVar2);
        dVar.a(aVar2);
        DataChannel.Init init = new DataChannel.Init();
        if (this.cvo && z) {
            this.cva = createPeerConnection.createDataChannel("JanusDataChannel", init);
        }
        Log.d("PCRTCClient", "Peer connection created.");
        return createPeerConnection;
    }

    private VideoTrack a(EglBase.Context context, VideoCapturer videoCapturer) {
        this.cvH = this.cvd.createVideoSource(false);
        this.cvj = SurfaceTextureHelper.create("video renderer", context);
        videoCapturer.initialize(this.cvj, this.context, this.cvH.getCapturerObserver());
        videoCapturer.startCapture(this.videoWidth, this.videoHeight, this.videoFps);
        this.cvl = this.cvd.createVideoTrack("ARDAMSv0", this.cvH);
        this.cvl.setEnabled(this.cvz);
        this.cvl.addSink(this.cvi);
        return this.cvl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(PeerConnectionClient peerConnectionClient, Integer num) {
        if (peerConnectionClient.cvk == null) {
            return;
        }
        Log.d("PCRTCClient", "Requested max video bitrate: " + num);
        if (peerConnectionClient.cvk == null) {
            Log.w("PCRTCClient", "Sender is not ready.");
            return;
        }
        RtpParameters parameters = peerConnectionClient.cvk.getParameters();
        if (parameters.encodings.size() == 0) {
            Log.w("PCRTCClient", "RtpParameters are not ready.");
            return;
        }
        for (RtpParameters.Encoding encoding : parameters.encodings) {
            encoding.maxBitrateBps = num == null ? null : Integer.valueOf(num.intValue() * 1000);
        }
        if (!peerConnectionClient.cvk.setParameters(parameters)) {
            Log.e("PCRTCClient", "RtpSender.setParameters failed.");
        }
        Log.d("PCRTCClient", "Configured max video bitrate to: " + num);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final BigInteger bigInteger, final StatsEventsType statsEventsType) {
        if (this.cvu.get(bigInteger).cuK.getStats(new StatsObserver() { // from class: com.baidu.rtc.PeerConnectionClient.17
            @Override // org.webrtc.StatsObserver
            public void onComplete(StatsReport[] statsReportArr) {
                PeerConnectionClient.this.cvc.a(statsReportArr, bigInteger, statsEventsType);
            }
        }, null)) {
            return;
        }
        Log.e("PCRTCClient", "getStats() returns false!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(EglBase.Context context, BigInteger bigInteger) {
        if (this.cvd == null || this.cvg) {
            Log.e("PCRTCClient", "Peerconnection factory is not created");
            return;
        }
        Log.d("PCRTCClient", "PCConstraints: " + this.cvt.toString());
        Log.d("PCRTCClient", "EGLContext: " + context);
        PeerConnection a2 = a(bigInteger, true);
        this.cvs = this.cvd.createLocalMediaStream("ARDAMS");
        if (this.mHasVideo) {
            this.cvs.addTrack(a(context, this.cvF));
        }
        if (this.mHasAudio) {
            this.cvs.addTrack(aeG());
        }
        a2.addStream(this.cvs);
        g(bigInteger);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aeF() {
        Log.d("PCRTCClient", "Closing peer connection.");
        this.cvB.cancel();
        if (this.cvu != null) {
            int size = this.cvu.size();
            for (int i = 0; i < size; i++) {
                com.baidu.rtc.a aVar = (com.baidu.rtc.a) this.cvu.values().toArray()[i];
                aVar.cuK.close();
                aVar.cuK.dispose();
                aVar.cuK = null;
                aVar.cuL.close();
            }
        }
        Log.d("PCRTCClient", "Closing audio source.");
        if (this.cuZ != null) {
            this.cuZ.dispose();
            this.cuZ = null;
        }
        Log.d("PCRTCClient", "Stopping capture.");
        if (this.cvF != null) {
            try {
                this.cvF.stopCapture();
                this.cvG = true;
                this.cvF.dispose();
                this.cvF = null;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        Log.d("PCRTCClient", "Closing video source.");
        if (this.cvH != null) {
            this.cvH.dispose();
            this.cvH = null;
        }
        if (this.cvj != null) {
            this.cvj.dispose();
            this.cvj = null;
        }
        Log.d("PCRTCClient", "Closing peer connection factory.");
        if (this.cvd != null) {
            this.cvd.dispose();
            this.cvd = null;
        }
        this.options = null;
        Log.d("PCRTCClient", "Closing peer connection done.");
        this.cvc.aeP();
        PeerConnectionFactory.stopInternalTracingCapture();
        PeerConnectionFactory.shutdownInternalTracer();
    }

    private AudioTrack aeG() {
        this.cuZ = this.cvd.createAudioSource(this.cuY);
        this.cvh = this.cvd.createAudioTrack("ARDAMSa0", this.cuZ);
        this.cvh.setEnabled(this.cvb);
        return this.cvh;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aeH() {
        this.cvt = new MediaConstraints();
        this.cvt.optional.add(new MediaConstraints.KeyValuePair("DtlsSrtpKeyAgreement", "true"));
        this.videoWidth = this.cvv.videoWidth;
        this.videoHeight = this.cvv.videoHeight;
        this.videoFps = this.cvv.videoFps;
        if (this.videoWidth == 0 || this.videoHeight == 0) {
            this.videoWidth = 1280;
            this.videoHeight = 720;
        }
        if (this.videoFps == 0) {
            this.videoFps = 30;
        }
        Logging.d("PCRTCClient", "Capturing format: " + this.videoWidth + Config.EVENT_HEAT_X + this.videoHeight + "@" + this.videoFps);
        this.cuY = new MediaConstraints();
        if (this.cvv.cwq) {
            Log.d("PCRTCClient", "Disabling audio processing");
            this.cuY.mandatory.add(new MediaConstraints.KeyValuePair("googEchoCancellation", "false"));
            this.cuY.mandatory.add(new MediaConstraints.KeyValuePair("googAutoGainControl", "false"));
            this.cuY.mandatory.add(new MediaConstraints.KeyValuePair("googHighpassFilter", "false"));
            this.cuY.mandatory.add(new MediaConstraints.KeyValuePair("googNoiseSuppression", "false"));
        }
        this.cvA = new MediaConstraints();
        if (this.mHasAudio) {
            this.cvA.mandatory.add(new MediaConstraints.KeyValuePair("OfferToReceiveAudio", "true"));
        }
        if (this.mHasVideo) {
            this.cvA.mandatory.add(new MediaConstraints.KeyValuePair("OfferToReceiveVideo", "true"));
        }
        if (this.cvo) {
            this.cvA.mandatory.add(new MediaConstraints.KeyValuePair("data", "true"));
        }
    }

    public static PeerConnectionClient aeI() {
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
    public void bN(Context context) {
        boolean z = false;
        if (this.cvv.cwr) {
            PeerConnectionFactory.startInternalTracingCapture(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "webrtc-trace.txt");
        }
        Log.d("PCRTCClient", "Create peer connection factory. Use video: true");
        this.cvg = false;
        this.cvw = "VP8";
        if (this.cvv.cwu != null) {
            if (this.cvv.cwu.equals("VP9")) {
                this.cvw = "VP9";
            } else if (this.cvv.cwu.equals("H264")) {
                this.cvw = "H264";
            }
        }
        Log.d("PCRTCClient", "Pereferred video codec: " + this.cvw);
        if (this.cvv.cwt) {
            Log.d("PCRTCClient", "Allow OpenSL ES audio if device supports it");
            WebRtcAudioManager.setBlacklistDeviceForOpenSLESUsage(false);
        } else {
            Log.d("PCRTCClient", "Disable OpenSL ES audio even if device supports it");
            WebRtcAudioManager.setBlacklistDeviceForOpenSLESUsage(true);
        }
        if (this.cvv.cwf) {
            Log.d("PCRTCClient", "Disable built-in AEC even if device supports it");
            WebRtcAudioUtils.setWebRtcBasedAcousticEchoCanceler(true);
        } else {
            Log.d("PCRTCClient", "Enable built-in AEC if device supports it");
            WebRtcAudioUtils.setWebRtcBasedAcousticEchoCanceler(false);
        }
        if (this.cvv.cwg) {
            Log.d("PCRTCClient", "Disable built-in AGC even if device supports it");
            WebRtcAudioUtils.setWebRtcBasedAutomaticGainControl(true);
        } else {
            Log.d("PCRTCClient", "Enable built-in AGC if device supports it");
            WebRtcAudioUtils.setWebRtcBasedAutomaticGainControl(false);
        }
        if (this.cvv.cwh) {
            Log.d("PCRTCClient", "Disable built-in NS even if device supports it");
            WebRtcAudioUtils.setWebRtcBasedNoiseSuppressor(true);
        } else {
            Log.d("PCRTCClient", "Enable built-in NS if device supports it");
            WebRtcAudioUtils.setWebRtcBasedNoiseSuppressor(false);
        }
        this.context = context;
        this.cuX = new MediaConstraints();
        this.cuX.mandatory.add(new MediaConstraints.KeyValuePair("OfferToReceiveAudio", "true"));
        this.cuX.mandatory.add(new MediaConstraints.KeyValuePair("OfferToReceiveVideo", "true"));
        String str = this.cvv.cwi ? "WebRTC-FlexFEC-03-Advertised/Enabled/WebRTC-FlexFEC-03/Enabled/" : "";
        if (this.cvv.cwj) {
            str = str + "BRTC.Fixed.Resolution/Enabled/";
        }
        if (this.cvv.cwo == 0 || this.cvv.cwo == 1 || this.cvv.cwo == 2) {
            str = str + "BRTC-Encoder-BitrateMode/" + this.cvv.cwo + "/";
        }
        if (this.cvv.cwk) {
            str = (str + "WebRTC-H264HighProfile/Enabled/") + "WebRTC-MediaTekH264/Enabled/";
        }
        if (this.cvv.cwl) {
            str = str + "BRTC.HisiH264HW/Enabled/";
        }
        if (this.cvv.cwm) {
            str = str + "BRTC.MTK.H264.Decode/Enabled/";
        }
        if (this.cvv.cwc >= 0) {
            str = str + "BRTC.Playout.Delay.AudioOnly/" + this.cvv.cwc + "/";
        }
        if (this.cvv.cwa >= 0) {
            str = str + "BRTC.Opus.Complexity/" + this.cvv.cwa + "/";
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
        if (this.cvv.cwn || z) {
            str = str + "BRTC.Required.Resolustion.Aligment32/Enabled/";
        }
        PeerConnectionFactory.initialize(PeerConnectionFactory.InitializationOptions.builder(context).setFieldTrials(str).createInitializationOptions());
        AudioDeviceModule aeJ = aeJ();
        this.cuW = (JavaAudioDeviceModule) aeJ;
        this.cvd = PeerConnectionFactory.builder().setAudioDeviceModule(aeJ).setVideoDecoderFactory(MediaCodecVideoDecoder.createFactory()).setVideoEncoderFactory(MediaCodecVideoEncoder.createFactory()).createPeerConnectionFactory();
        Log.d("PCRTCClient", "Peer connection factory created.");
        aeJ.release();
        if (!this.cvr) {
            Logging.enableLogToDebugOutput(Logging.Severity.LS_ERROR);
            return;
        }
        Logging.enableLogThreads();
        Logging.enableLogTimeStamps();
        Logging.enableLogToDebugOutput(Logging.Severity.LS_VERBOSE);
    }

    private void g(BigInteger bigInteger) {
        for (RtpSender rtpSender : this.cvu.get(bigInteger).cuK.getSenders()) {
            if (rtpSender.track() != null && rtpSender.track().kind().equals("video")) {
                Log.d("PCRTCClient", "Found video sender.");
                this.cvk = rtpSender;
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
                    if (PeerConnectionClient.this.cvg) {
                        return;
                    }
                    PeerConnectionClient.this.cvc.jC(str);
                    PeerConnectionClient.this.cvg = true;
                }
            });
        }
    }

    public void a(final Context context, c cVar, b bVar) {
        this.cvv = cVar;
        this.cvc = bVar;
        this.context = null;
        this.cvd = null;
        this.cvG = false;
        this.cvg = false;
        this.cvs = null;
        this.cvF = null;
        this.cvz = !cVar.cwe;
        this.cvl = null;
        this.cvy = null;
        this.cvk = null;
        this.cvb = !cVar.cwp;
        this.cvh = null;
        this.cvB = new Timer();
        if (this.executor.isShutdown()) {
            Log.w("PCRTCClient", "executor is already shutdown");
        } else {
            this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.1
                @Override // java.lang.Runnable
                public void run() {
                    PeerConnectionClient.this.bN(context);
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
                    PeerConnection peerConnection = ((com.baidu.rtc.a) PeerConnectionClient.this.cvu.get(bigInteger)).cuK;
                    d dVar = ((com.baidu.rtc.a) PeerConnectionClient.this.cvu.get(bigInteger)).cuL;
                    if (peerConnection == null || PeerConnectionClient.this.cvg) {
                        return;
                    }
                    String str = sessionDescription.description;
                    m.a aVar = new m.a();
                    aVar.cxh = PeerConnectionClient.this.cvv.cvX == RtcParameterSettings.RtcAudioBitrateMode.RTC_AUDIO_BITRATE_CBR;
                    aVar.cxi = PeerConnectionClient.this.cvv.cwb;
                    aVar.cxl = PeerConnectionClient.this.cvv.cws == RtcParameterSettings.RtcAudioChannel.RTC_AUDIO_STEREO;
                    peerConnection.setRemoteDescription(dVar, new SessionDescription(sessionDescription.type, m.a(PeerConnectionClient.this.cvv.cvZ, str, aVar)));
                }
            });
        }
    }

    public void a(final EglBase.Context context, VideoSink videoSink, VideoCapturer videoCapturer, final BigInteger bigInteger) {
        if (this.cvv == null) {
            Log.e("PCRTCClient", "Creating peer connection without initializing factory.");
            return;
        }
        this.cvi = videoSink;
        this.cvF = videoCapturer;
        if (this.executor.isShutdown()) {
            Log.w("PCRTCClient", "executor is already shutdown");
        } else {
            this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.9
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        PeerConnectionClient.this.aeH();
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
        this.cvp = remoteSamplesReadyCallback;
    }

    public void a(JavaAudioDeviceModule.SamplesReadyCallback samplesReadyCallback) {
        this.cve = samplesReadyCallback;
    }

    public void a(boolean z, int i, final BigInteger bigInteger, final StatsEventsType statsEventsType) {
        TimerTask timerTask = null;
        if (!z) {
            if (statsEventsType == StatsEventsType.GET_AUDIOLEVEL_EVENT) {
                timerTask = this.cvE.get(bigInteger);
            } else if (statsEventsType == StatsEventsType.GET_QUALITY_MONITOR_EVENT) {
                timerTask = this.cvC.get(bigInteger);
            } else if (statsEventsType == StatsEventsType.GET_SLI_EVENT) {
                timerTask = this.cvD.get(bigInteger);
            }
            if (timerTask != null) {
                timerTask.cancel();
                return;
            }
            return;
        }
        try {
            if (statsEventsType == StatsEventsType.GET_AUDIOLEVEL_EVENT) {
                timerTask = this.cvE.get(bigInteger);
            } else if (statsEventsType == StatsEventsType.GET_QUALITY_MONITOR_EVENT) {
                timerTask = this.cvC.get(bigInteger);
            } else if (statsEventsType == StatsEventsType.GET_SLI_EVENT) {
                timerTask = this.cvD.get(bigInteger);
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
                this.cvE.put(bigInteger, timerTask2);
            } else if (statsEventsType == StatsEventsType.GET_QUALITY_MONITOR_EVENT) {
                this.cvC.put(bigInteger, timerTask2);
            } else if (statsEventsType == StatsEventsType.GET_SLI_EVENT) {
                this.cvD.put(bigInteger, timerTask2);
            }
            this.cvB.schedule(timerTask2, 0L, i);
        } catch (Exception e) {
            Log.e("PCRTCClient", "Can not schedule statistics timer", e);
        }
    }

    AudioDeviceModule aeJ() {
        AudioDeviceModule createAudioDeviceModule = JavaAudioDeviceModule.builder(this.context).setSamplesReadyCallback(this.cve).setRemoteSamplesReadyCallback(this.cvp).setExternalAudioRecord(this.cvn).setUseHardwareAcousticEchoCanceler(!this.cvv.cwf).setUseHardwareNoiseSuppressor(!this.cvv.cwh).setAudioRecordErrorCallback(new JavaAudioDeviceModule.AudioRecordErrorCallback() { // from class: com.baidu.rtc.PeerConnectionClient.14
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
        }).setSampleRate(this.cvm).setUseStereoInput(this.mAudioChannel > 1).setUseStereoOutput(this.mAudioChannel > 1).setAudioSource(this.cvv.audioSource).createAudioDeviceModule();
        if (this.cvn && (createAudioDeviceModule instanceof JavaAudioDeviceModule)) {
            this.externalSamplesCallback = ((JavaAudioDeviceModule) createAudioDeviceModule).getExternalSamplesReadyCallback();
        }
        return createAudioDeviceModule;
    }

    public void aeK() {
        if (this.executor.isShutdown()) {
            Log.w("PCRTCClient", "executor is already shutdown");
        } else {
            this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.7
                @Override // java.lang.Runnable
                public void run() {
                    if (PeerConnectionClient.this.cuZ != null) {
                        PeerConnectionClient.this.cuZ.dispose();
                        PeerConnectionClient.this.cuZ = null;
                    }
                }
            });
        }
    }

    public void aeL() {
        if (this.executor.isShutdown()) {
            Log.w("PCRTCClient", "executor is already shutdown");
        } else {
            this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.6
                @Override // java.lang.Runnable
                public void run() {
                    if (PeerConnectionClient.this.cvF == null || PeerConnectionClient.this.cvG) {
                        return;
                    }
                    Log.d("PCRTCClient", "Stop video source.");
                    try {
                        PeerConnectionClient.this.cvF.stopCapture();
                    } catch (InterruptedException e) {
                    }
                    PeerConnectionClient.this.cvG = true;
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
                    d dVar = ((com.baidu.rtc.a) PeerConnectionClient.this.cvu.get(bigInteger)).cuL;
                    if (a2 == null || PeerConnectionClient.this.cvg) {
                        return;
                    }
                    a2.setRemoteDescription(dVar, sessionDescription);
                    Log.d("PCRTCClient", "PC create ANSWER");
                    a2.createAnswer(((com.baidu.rtc.a) PeerConnectionClient.this.cvu.get(bigInteger)).cuL, PeerConnectionClient.this.cuX);
                }
            });
        }
    }

    public void close() {
        this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.13
            @Override // java.lang.Runnable
            public void run() {
                PeerConnectionClient.this.aeF();
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
                    PeerConnectionClient.this.cvb = z;
                    if (PeerConnectionClient.this.cvh != null) {
                        PeerConnectionClient.this.cvh.setEnabled(PeerConnectionClient.this.cvb);
                    }
                    if (PeerConnectionClient.this.cuW != null) {
                        PeerConnectionClient.this.cuW.setMicrophoneMute(!z);
                    }
                }
            });
        }
    }

    public void er(boolean z) {
        this.cvr = z;
    }

    public void es(boolean z) {
        this.cvn = z;
    }

    public void et(boolean z) {
        this.mHasAudio = z;
    }

    public void eu(boolean z) {
        this.cvo = z;
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
                    PeerConnectionClient.this.cvz = z;
                    if (PeerConnectionClient.this.cvl != null) {
                        PeerConnectionClient.this.cvl.setEnabled(PeerConnectionClient.this.cvz);
                    }
                }
            });
        }
    }

    public void fU(int i) {
        this.cvm = i;
    }

    public void h(final BigInteger bigInteger) {
        if (this.executor == null || this.executor.isShutdown()) {
            return;
        }
        this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.16
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.rtc.a aVar;
                if (PeerConnectionClient.this.cvu == null || (aVar = (com.baidu.rtc.a) PeerConnectionClient.this.cvu.get(bigInteger)) == null) {
                    return;
                }
                if (aVar.cuK != null) {
                    aVar.cuK.close();
                    aVar.cuK.dispose();
                    aVar.cuK = null;
                }
                if (aVar.cuL != null) {
                    aVar.cuL.close();
                    aVar.cuL = null;
                }
                PeerConnectionClient.this.cvu.remove(bigInteger);
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
                    com.baidu.rtc.a aVar = (com.baidu.rtc.a) PeerConnectionClient.this.cvu.get(bigInteger);
                    PeerConnection peerConnection = aVar.cuK;
                    if (peerConnection == null || PeerConnectionClient.this.cvg) {
                        return;
                    }
                    Log.d("PCRTCClient", "PC Create OFFER");
                    peerConnection.createOffer(aVar.cuL, PeerConnectionClient.this.cvA);
                }
            });
        }
    }

    public com.baidu.rtc.a j(BigInteger bigInteger) {
        return this.cvu.get(bigInteger);
    }

    @Override // org.webrtc.DataChannel.Observer
    public void onBufferedAmountChange(long j) {
    }

    @Override // org.webrtc.DataChannel.Observer
    public void onMessage(DataChannel.Buffer buffer) {
        this.cvc.l(buffer.data);
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
                    if (PeerConnectionClient.this.cuW != null) {
                        PeerConnectionClient.this.cuW.setEnableSLIReport(z);
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
                    if (PeerConnectionClient.this.cuW != null) {
                        PeerConnectionClient.this.cuW.setSpeakerMute(z);
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
                    PeerConnectionClient.this.cvq = eVar;
                    if (PeerConnectionClient.this.cuW != null) {
                        PeerConnectionClient.this.cuW.setStuckEventListener(eVar);
                    }
                }
            });
        }
    }
}
