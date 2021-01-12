package com.baidu.rtc;

import android.content.Context;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Environment;
import android.util.Log;
import com.baidu.ala.helper.StreamConfig;
import com.baidu.mobstat.Config;
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
/* loaded from: classes9.dex */
public class PeerConnectionClient implements DataChannel.Observer {
    private Context context;
    private MediaConstraints crE;
    private MediaConstraints crF;
    private AudioSource crG;
    private boolean crI;
    private b crJ;
    private PeerConnectionFactory crK;
    private JavaAudioDeviceModule.SamplesReadyCallback crL;
    private boolean crN;
    private AudioTrack crO;
    private VideoSink crP;
    private SurfaceTextureHelper crQ;
    private RtpSender crR;
    private VideoTrack crS;
    private boolean crU;
    private JavaAudioDeviceModule.RemoteSamplesReadyCallback crW;
    private MediaStream crY;
    private MediaConstraints crZ;
    private c csb;
    private String csc;
    private VideoTrack cse;
    private boolean csf;
    private MediaConstraints csg;
    private Timer csh;
    private VideoCapturer csk;
    private boolean csl;
    private int csm;
    private VideoSource csn;
    private JavaAudioDeviceModule.ExternalSamplesReadyCallback externalSamplesCallback;
    private int videoHeight;
    private int videoWidth;
    PeerConnectionFactory.Options options = null;
    private Map<BigInteger, TimerTask> csj = new ConcurrentHashMap();
    private Map<BigInteger, TimerTask> csi = new ConcurrentHashMap();
    private boolean mHasVideo = true;
    private boolean mHasAudio = true;
    private boolean crV = false;
    private int crT = StreamConfig.Audio.AUDIO_RTC_FREQUENCY_48K;
    private int mAudioChannel = 1;
    private boolean crM = true;
    private DataChannel crH = null;
    Map<BigInteger, Integer> csd = new ConcurrentHashMap();
    private boolean crX = false;
    private JavaAudioDeviceModule crD = null;
    private final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
    private ConcurrentHashMap<BigInteger, com.baidu.rtc.a> csa = new ConcurrentHashMap<>();

    /* loaded from: classes9.dex */
    public enum StatsEventsType {
        GET_AUDIOLEVEL_EVENT,
        GET_QUALITY_MONITOR_EVENT,
        GET_BWE_EVENT
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a implements PeerConnection.Observer {
        private PeerConnection crr;
        private com.baidu.rtc.a csx;

        private a() {
        }

        public void a(com.baidu.rtc.a aVar) {
            this.csx = aVar;
            this.crr = aVar.crr;
        }

        @Override // org.webrtc.PeerConnection.Observer
        public void onAddStream(final MediaStream mediaStream) {
            if (PeerConnectionClient.this.executor.isShutdown()) {
                Log.w("PCRTCClient", "executor is already shutdown");
            } else {
                PeerConnectionClient.this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.a.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.crr == null || PeerConnectionClient.this.crN) {
                            return;
                        }
                        Log.d("PCRTCClient", "=========== onAddStream ==========");
                        if (mediaStream.videoTracks.size() == 1) {
                            PeerConnectionClient.this.cse = mediaStream.videoTracks.get(0);
                            PeerConnectionClient.this.cse.setEnabled(true);
                            a.this.csx.cru = PeerConnectionClient.this.cse;
                            PeerConnectionClient.this.crJ.b(a.this.csx);
                        }
                        PeerConnectionClient.this.crJ.a(mediaStream.videoTracks.size() != 0, mediaStream.audioTracks.size() != 0, a.this.csx.crq);
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
                        PeerConnectionClient.this.crJ.a(iceCandidate, a.this.csx.crq);
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
                        PeerConnectionClient.this.crJ.onIceCandidatesRemoved(iceCandidateArr);
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
                            PeerConnectionClient.this.crJ.aer();
                        } else if (iceConnectionState == PeerConnection.IceConnectionState.DISCONNECTED) {
                            PeerConnectionClient.this.crJ.aes();
                        } else if (iceConnectionState == PeerConnection.IceConnectionState.FAILED) {
                            PeerConnectionClient.this.crJ.aet();
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
                        PeerConnectionClient.this.cse = null;
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

        void aer();

        void aes();

        void aet();

        void aeu();

        void b(com.baidu.rtc.a aVar);

        void je(String str);

        void l(ByteBuffer byteBuffer);

        void onIceCandidatesRemoved(IceCandidate[] iceCandidateArr);
    }

    /* loaded from: classes9.dex */
    public static class c {
        public RtcParameterSettings.RtcAudioBitrateMode csD;
        public final String csE;
        public final int csF;
        public final int csG;
        public final boolean csH;
        public final boolean csI;
        public final boolean csJ;
        public final boolean csK;
        public final boolean csL;
        public final boolean csM;
        public final boolean csN;
        public final boolean csO;
        public final boolean csP;
        public final int csQ;
        public final boolean csR;
        public final boolean csS;
        public final boolean csT;
        public RtcParameterSettings.RtcAudioChannel csU;
        public final boolean csV;
        public final String csW;
        public final boolean csX;
        public final int csY;
        public final int csZ;
        public final int csm;
        public final int videoHeight;
        public final int videoWidth;

        public c(boolean z, int i, int i2, int i3, String str, boolean z2, int i4, String str2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, int i5, int i6, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, boolean z13, int i7, RtcParameterSettings.RtcAudioBitrateMode rtcAudioBitrateMode, RtcParameterSettings.RtcAudioChannel rtcAudioChannel, int i8, boolean z14) {
            this.csT = z;
            this.videoWidth = i;
            this.videoHeight = i2;
            this.csm = i3;
            this.csW = str;
            this.csX = z2;
            this.csG = i4;
            this.csE = str2;
            this.csS = z3;
            this.csV = z4;
            this.csI = z5;
            this.csJ = z6;
            this.csK = z7;
            this.csY = i5;
            this.csZ = i6;
            this.csR = z8;
            this.csH = z9;
            this.csL = z10;
            this.csM = z11;
            this.csP = z12;
            this.csN = z13;
            this.csF = i7;
            this.csD = rtcAudioBitrateMode;
            this.csU = rtcAudioChannel;
            this.csQ = i8;
            this.csO = z14;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class d implements SdpObserver {
        private c crp;
        private BigInteger crq;
        private PeerConnection crr;
        private d crs;
        private boolean crt;
        private SessionDescription cta;

        d() {
        }

        public void a(com.baidu.rtc.a aVar) {
            this.crr = aVar.crr;
            this.crs = aVar.crs;
            this.crq = aVar.crq;
            this.crt = aVar.crt;
            this.crp = aVar.crp;
        }

        public void close() {
            this.crr = null;
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
            this.cta = sessionDescription2;
            if (PeerConnectionClient.this.executor.isShutdown()) {
                Log.w("PCRTCClient", "executor is already shutdown");
            } else {
                PeerConnectionClient.this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.d.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (d.this.crr == null || PeerConnectionClient.this.crN) {
                            return;
                        }
                        Log.d("PCRTCClient", "Set local SDP from " + sessionDescription2.type);
                        d.this.crr.setLocalDescription(d.this.crs, sessionDescription2);
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
                        if (d.this.crr == null || PeerConnectionClient.this.crN) {
                            return;
                        }
                        if (!d.this.crt) {
                            if (d.this.crr.getLocalDescription() == null) {
                                Log.d("PCRTCClient", "answer Remote SDP set succesfully");
                                return;
                            }
                            Log.d("PCRTCClient", "answer Local SDP set succesfully");
                            PeerConnectionClient.this.crJ.a(d.this.cta, d.this.crq);
                        } else if (d.this.crr.getRemoteDescription() != null) {
                            Log.d("PCRTCClient", "Remote SDP set succesfully");
                        } else {
                            Log.d("PCRTCClient", "Local SDP set succesfully");
                            PeerConnectionClient.this.crJ.a(d.this.cta, d.this.crq, d.this.cta.description.contains("profile-level-id=640c1f"));
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
        PeerConnection createPeerConnection = this.crK.createPeerConnection(arrayList, aVar);
        com.baidu.rtc.a aVar2 = new com.baidu.rtc.a();
        aVar2.crq = bigInteger;
        aVar2.crs = dVar;
        aVar2.crr = createPeerConnection;
        aVar2.crt = z;
        aVar2.crv = -1;
        aVar2.crp = this.csb;
        this.csa.put(bigInteger, aVar2);
        aVar.a(aVar2);
        dVar.a(aVar2);
        DataChannel.Init init = new DataChannel.Init();
        if (this.crV && z) {
            this.crH = createPeerConnection.createDataChannel("JanusDataChannel", init);
        }
        Log.d("PCRTCClient", "Peer connection created.");
        return createPeerConnection;
    }

    private VideoTrack a(EglBase.Context context, VideoCapturer videoCapturer) {
        this.csn = this.crK.createVideoSource(false);
        this.crQ = SurfaceTextureHelper.create("video renderer", context);
        videoCapturer.initialize(this.crQ, this.context, this.csn.getCapturerObserver());
        videoCapturer.startCapture(this.videoWidth, this.videoHeight, this.csm);
        this.crS = this.crK.createVideoTrack("ARDAMSv0", this.csn);
        this.crS.setEnabled(this.csf);
        this.crS.addSink(this.crP);
        return this.crS;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(PeerConnectionClient peerConnectionClient, Integer num) {
        if (peerConnectionClient.crR == null) {
            return;
        }
        Log.d("PCRTCClient", "Requested max video bitrate: " + num);
        if (peerConnectionClient.crR == null) {
            Log.w("PCRTCClient", "Sender is not ready.");
            return;
        }
        RtpParameters parameters = peerConnectionClient.crR.getParameters();
        if (parameters.encodings.size() == 0) {
            Log.w("PCRTCClient", "RtpParameters are not ready.");
            return;
        }
        for (RtpParameters.Encoding encoding : parameters.encodings) {
            encoding.maxBitrateBps = num == null ? null : Integer.valueOf(num.intValue() * 1000);
        }
        if (!peerConnectionClient.crR.setParameters(parameters)) {
            Log.e("PCRTCClient", "RtpSender.setParameters failed.");
        }
        Log.d("PCRTCClient", "Configured max video bitrate to: " + num);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final BigInteger bigInteger, final StatsEventsType statsEventsType) {
        if (this.csa.get(bigInteger).crr.getStats(new StatsObserver() { // from class: com.baidu.rtc.PeerConnectionClient.14
            @Override // org.webrtc.StatsObserver
            public void onComplete(StatsReport[] statsReportArr) {
                PeerConnectionClient.this.crJ.a(statsReportArr, bigInteger, statsEventsType);
            }
        }, null)) {
            return;
        }
        Log.e("PCRTCClient", "getStats() returns false!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(EglBase.Context context, BigInteger bigInteger) {
        if (this.crK == null || this.crN) {
            Log.e("PCRTCClient", "Peerconnection factory is not created");
            return;
        }
        Log.d("PCRTCClient", "PCConstraints: " + this.crZ.toString());
        Log.d("PCRTCClient", "EGLContext: " + context);
        PeerConnection a2 = a(bigInteger, true);
        this.crY = this.crK.createLocalMediaStream("ARDAMS");
        if (this.mHasVideo) {
            this.crY.addTrack(a(context, this.csk));
        }
        if (this.mHasAudio) {
            this.crY.addTrack(aem());
        }
        a2.addStream(this.crY);
        g(bigInteger);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ael() {
        Log.d("PCRTCClient", "Closing peer connection.");
        this.csh.cancel();
        if (this.csa != null) {
            int size = this.csa.size();
            for (int i = 0; i < size; i++) {
                com.baidu.rtc.a aVar = (com.baidu.rtc.a) this.csa.values().toArray()[i];
                aVar.crr.close();
                aVar.crr.dispose();
                aVar.crr = null;
                aVar.crs.close();
            }
        }
        Log.d("PCRTCClient", "Closing audio source.");
        if (this.crG != null) {
            this.crG.dispose();
            this.crG = null;
        }
        Log.d("PCRTCClient", "Stopping capture.");
        if (this.csk != null) {
            try {
                this.csk.stopCapture();
                this.csl = true;
                this.csk.dispose();
                this.csk = null;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        Log.d("PCRTCClient", "Closing video source.");
        if (this.csn != null) {
            this.csn.dispose();
            this.csn = null;
        }
        if (this.crQ != null) {
            this.crQ.dispose();
            this.crQ = null;
        }
        Log.d("PCRTCClient", "Closing peer connection factory.");
        if (this.crK != null) {
            this.crK.dispose();
            this.crK = null;
        }
        this.options = null;
        Log.d("PCRTCClient", "Closing peer connection done.");
        this.crJ.aeu();
        PeerConnectionFactory.stopInternalTracingCapture();
        PeerConnectionFactory.shutdownInternalTracer();
    }

    private AudioTrack aem() {
        this.crG = this.crK.createAudioSource(this.crF);
        this.crO = this.crK.createAudioTrack("ARDAMSa0", this.crG);
        this.crO.setEnabled(this.crI);
        return this.crO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aen() {
        this.crZ = new MediaConstraints();
        this.crZ.optional.add(new MediaConstraints.KeyValuePair("DtlsSrtpKeyAgreement", "true"));
        this.videoWidth = this.csb.videoWidth;
        this.videoHeight = this.csb.videoHeight;
        this.csm = this.csb.csm;
        if (this.videoWidth == 0 || this.videoHeight == 0) {
            this.videoWidth = PlatformPlugin.DEFAULT_SYSTEM_UI;
            this.videoHeight = 720;
        }
        if (this.csm == 0) {
            this.csm = 30;
        }
        Logging.d("PCRTCClient", "Capturing format: " + this.videoWidth + Config.EVENT_HEAT_X + this.videoHeight + "@" + this.csm);
        this.crF = new MediaConstraints();
        if (this.csb.csS) {
            Log.d("PCRTCClient", "Disabling audio processing");
            this.crF.mandatory.add(new MediaConstraints.KeyValuePair("googEchoCancellation", "false"));
            this.crF.mandatory.add(new MediaConstraints.KeyValuePair("googAutoGainControl", "false"));
            this.crF.mandatory.add(new MediaConstraints.KeyValuePair("googHighpassFilter", "false"));
            this.crF.mandatory.add(new MediaConstraints.KeyValuePair("googNoiseSuppression", "false"));
        }
        this.csg = new MediaConstraints();
        if (this.mHasAudio) {
            this.csg.mandatory.add(new MediaConstraints.KeyValuePair("OfferToReceiveAudio", "true"));
        }
        if (this.mHasVideo) {
            this.csg.mandatory.add(new MediaConstraints.KeyValuePair("OfferToReceiveVideo", "true"));
        }
        if (this.crV) {
            this.csg.mandatory.add(new MediaConstraints.KeyValuePair("data", "true"));
        }
    }

    public static PeerConnectionClient aeo() {
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
    public void bP(Context context) {
        boolean z = false;
        if (this.csb.csT) {
            PeerConnectionFactory.startInternalTracingCapture(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "webrtc-trace.txt");
        }
        Log.d("PCRTCClient", "Create peer connection factory. Use video: true");
        this.crN = false;
        this.csc = "VP8";
        if (this.csb.csW != null) {
            if (this.csb.csW.equals("VP9")) {
                this.csc = "VP9";
            } else if (this.csb.csW.equals("H264")) {
                this.csc = "H264";
            }
        }
        Log.d("PCRTCClient", "Pereferred video codec: " + this.csc);
        if (this.csb.csV) {
            Log.d("PCRTCClient", "Allow OpenSL ES audio if device supports it");
            WebRtcAudioManager.setBlacklistDeviceForOpenSLESUsage(false);
        } else {
            Log.d("PCRTCClient", "Disable OpenSL ES audio even if device supports it");
            WebRtcAudioManager.setBlacklistDeviceForOpenSLESUsage(true);
        }
        if (this.csb.csI) {
            Log.d("PCRTCClient", "Disable built-in AEC even if device supports it");
            WebRtcAudioUtils.setWebRtcBasedAcousticEchoCanceler(true);
        } else {
            Log.d("PCRTCClient", "Enable built-in AEC if device supports it");
            WebRtcAudioUtils.setWebRtcBasedAcousticEchoCanceler(false);
        }
        if (this.csb.csJ) {
            Log.d("PCRTCClient", "Disable built-in AGC even if device supports it");
            WebRtcAudioUtils.setWebRtcBasedAutomaticGainControl(true);
        } else {
            Log.d("PCRTCClient", "Enable built-in AGC if device supports it");
            WebRtcAudioUtils.setWebRtcBasedAutomaticGainControl(false);
        }
        if (this.csb.csK) {
            Log.d("PCRTCClient", "Disable built-in NS even if device supports it");
            WebRtcAudioUtils.setWebRtcBasedNoiseSuppressor(true);
        } else {
            Log.d("PCRTCClient", "Enable built-in NS if device supports it");
            WebRtcAudioUtils.setWebRtcBasedNoiseSuppressor(false);
        }
        this.context = context;
        this.crE = new MediaConstraints();
        this.crE.mandatory.add(new MediaConstraints.KeyValuePair("OfferToReceiveAudio", "true"));
        this.crE.mandatory.add(new MediaConstraints.KeyValuePair("OfferToReceiveVideo", "true"));
        String str = this.csb.csL ? "WebRTC-FlexFEC-03-Advertised/Enabled/WebRTC-FlexFEC-03/Enabled/" : "";
        if (this.csb.csM) {
            str = str + "BRTC.Fixed.Resolution/Enabled/";
        }
        if (this.csb.csQ == 0 || this.csb.csQ == 1 || this.csb.csQ == 2) {
            str = str + "BRTC-Encoder-BitrateMode/" + this.csb.csQ + "/";
        }
        if (this.csb.csN) {
            str = (str + "WebRTC-H264HighProfile/Enabled/") + "WebRTC-MediaTekH264/Enabled/";
        }
        if (this.csb.csO) {
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
        if (this.csb.csP || z) {
            str = str + "BRTC.Required.Resolustion.Aligment32/Enabled/";
        }
        PeerConnectionFactory.initialize(PeerConnectionFactory.InitializationOptions.builder(context).setFieldTrials(str).createInitializationOptions());
        AudioDeviceModule aep = aep();
        this.crD = (JavaAudioDeviceModule) aep;
        this.crK = PeerConnectionFactory.builder().setAudioDeviceModule(aep).setVideoDecoderFactory(MediaCodecVideoDecoder.createFactory()).setVideoEncoderFactory(MediaCodecVideoEncoder.createFactory()).createPeerConnectionFactory();
        Log.d("PCRTCClient", "Peer connection factory created.");
        aep.release();
        if (!this.crX) {
            Logging.enableLogToDebugOutput(Logging.Severity.LS_ERROR);
            return;
        }
        Logging.enableLogThreads();
        Logging.enableLogTimeStamps();
        Logging.enableLogToDebugOutput(Logging.Severity.LS_VERBOSE);
    }

    private void g(BigInteger bigInteger) {
        for (RtpSender rtpSender : this.csa.get(bigInteger).crr.getSenders()) {
            if (rtpSender.track() != null && rtpSender.track().kind().equals("video")) {
                Log.d("PCRTCClient", "Found video sender.");
                this.crR = rtpSender;
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
                    if (PeerConnectionClient.this.crN) {
                        return;
                    }
                    PeerConnectionClient.this.crJ.je(str);
                    PeerConnectionClient.this.crN = true;
                }
            });
        }
    }

    public void a(final Context context, c cVar, b bVar) {
        this.csb = cVar;
        this.crJ = bVar;
        this.context = null;
        this.crK = null;
        this.csl = false;
        this.crN = false;
        this.crY = null;
        this.csk = null;
        this.csf = !cVar.csH;
        this.crS = null;
        this.cse = null;
        this.crR = null;
        this.crI = !cVar.csR;
        this.crO = null;
        this.csh = new Timer();
        if (this.executor.isShutdown()) {
            Log.w("PCRTCClient", "executor is already shutdown");
        } else {
            this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.1
                @Override // java.lang.Runnable
                public void run() {
                    PeerConnectionClient.this.bP(context);
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
                    PeerConnection peerConnection = ((com.baidu.rtc.a) PeerConnectionClient.this.csa.get(bigInteger)).crr;
                    d dVar = ((com.baidu.rtc.a) PeerConnectionClient.this.csa.get(bigInteger)).crs;
                    if (peerConnection == null || PeerConnectionClient.this.crN) {
                        return;
                    }
                    String str = sessionDescription.description;
                    m.a aVar = new m.a();
                    aVar.ctE = PeerConnectionClient.this.csb.csD == RtcParameterSettings.RtcAudioBitrateMode.RTC_AUDIO_BITRATE_CBR;
                    aVar.ctF = PeerConnectionClient.this.csb.csF;
                    aVar.ctI = PeerConnectionClient.this.csb.csU == RtcParameterSettings.RtcAudioChannel.RTC_AUDIO_STEREO;
                    peerConnection.setRemoteDescription(dVar, new SessionDescription(sessionDescription.type, m.a(PeerConnectionClient.this.csb.csE, str, aVar)));
                }
            });
        }
    }

    public void a(final EglBase.Context context, VideoSink videoSink, VideoCapturer videoCapturer, final BigInteger bigInteger) {
        if (this.csb == null) {
            Log.e("PCRTCClient", "Creating peer connection without initializing factory.");
            return;
        }
        this.crP = videoSink;
        this.csk = videoCapturer;
        if (this.executor.isShutdown()) {
            Log.w("PCRTCClient", "executor is already shutdown");
        } else {
            this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.8
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        PeerConnectionClient.this.aen();
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
        this.crW = remoteSamplesReadyCallback;
    }

    public void a(JavaAudioDeviceModule.SamplesReadyCallback samplesReadyCallback) {
        this.crL = samplesReadyCallback;
    }

    public void a(boolean z, int i, final BigInteger bigInteger, final StatsEventsType statsEventsType) {
        TimerTask timerTask = null;
        if (!z) {
            if (statsEventsType == StatsEventsType.GET_AUDIOLEVEL_EVENT) {
                timerTask = this.csj.get(bigInteger);
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
                timerTask = this.csj.get(bigInteger);
            } else if (statsEventsType == StatsEventsType.GET_QUALITY_MONITOR_EVENT) {
                this.csi.get(bigInteger);
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
                this.csj.put(bigInteger, timerTask2);
            } else if (statsEventsType == StatsEventsType.GET_QUALITY_MONITOR_EVENT) {
                this.csi.put(bigInteger, timerTask2);
            }
            this.csh.schedule(timerTask2, 0L, i);
        } catch (Exception e) {
            Log.e("PCRTCClient", "Can not schedule statistics timer", e);
        }
    }

    AudioDeviceModule aep() {
        AudioDeviceModule createAudioDeviceModule = JavaAudioDeviceModule.builder(this.context).setSamplesReadyCallback(this.crL).setRemoteSamplesReadyCallback(this.crW).setExternalAudioRecord(this.crU).setUseHardwareAcousticEchoCanceler(!this.csb.csI).setUseHardwareNoiseSuppressor(!this.csb.csK).setAudioRecordErrorCallback(new JavaAudioDeviceModule.AudioRecordErrorCallback() { // from class: com.baidu.rtc.PeerConnectionClient.11
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
        }).setSampleRate(this.crT).setUseStereoInput(this.mAudioChannel > 1).setUseStereoOutput(this.mAudioChannel > 1).createAudioDeviceModule();
        if (this.crU && (createAudioDeviceModule instanceof JavaAudioDeviceModule)) {
            this.externalSamplesCallback = ((JavaAudioDeviceModule) createAudioDeviceModule).getExternalSamplesReadyCallback();
        }
        return createAudioDeviceModule;
    }

    public void aeq() {
        if (this.executor.isShutdown()) {
            Log.w("PCRTCClient", "executor is already shutdown");
        } else {
            this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.6
                @Override // java.lang.Runnable
                public void run() {
                    if (PeerConnectionClient.this.csk == null || PeerConnectionClient.this.csl) {
                        return;
                    }
                    Log.d("PCRTCClient", "Stop video source.");
                    try {
                        PeerConnectionClient.this.csk.stopCapture();
                    } catch (InterruptedException e) {
                    }
                    PeerConnectionClient.this.csl = true;
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
                    d dVar = ((com.baidu.rtc.a) PeerConnectionClient.this.csa.get(bigInteger)).crs;
                    if (a2 == null || PeerConnectionClient.this.crN) {
                        return;
                    }
                    a2.setRemoteDescription(dVar, sessionDescription);
                    Log.d("PCRTCClient", "PC create ANSWER");
                    a2.createAnswer(((com.baidu.rtc.a) PeerConnectionClient.this.csa.get(bigInteger)).crs, PeerConnectionClient.this.crE);
                }
            });
        }
    }

    public void close() {
        this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.10
            @Override // java.lang.Runnable
            public void run() {
                PeerConnectionClient.this.ael();
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

    public void eo(final boolean z) {
        if (this.executor.isShutdown()) {
            Log.w("PCRTCClient", "executor is already shutdown");
        } else {
            this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.16
                @Override // java.lang.Runnable
                public void run() {
                    PeerConnectionClient.this.crI = z;
                    if (PeerConnectionClient.this.crO != null) {
                        PeerConnectionClient.this.crO.setEnabled(PeerConnectionClient.this.crI);
                    }
                }
            });
        }
    }

    public void ep(boolean z) {
        this.crX = z;
    }

    public void eq(boolean z) {
        this.crU = z;
    }

    public void er(boolean z) {
        this.mHasAudio = z;
    }

    public void es(boolean z) {
        this.crV = z;
    }

    public void et(boolean z) {
        this.mHasVideo = z;
    }

    public void eu(final boolean z) {
        if (this.executor.isShutdown()) {
            Log.w("PCRTCClient", "executor is already shutdown");
        } else {
            this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.2
                @Override // java.lang.Runnable
                public void run() {
                    PeerConnectionClient.this.csf = z;
                    if (PeerConnectionClient.this.crS != null) {
                        PeerConnectionClient.this.crS.setEnabled(PeerConnectionClient.this.csf);
                    }
                }
            });
        }
    }

    public void fQ(int i) {
        this.crT = i;
    }

    public void h(final BigInteger bigInteger) {
        if (this.executor == null || this.executor.isShutdown()) {
            return;
        }
        this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.13
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.rtc.a aVar;
                if (PeerConnectionClient.this.csa == null || (aVar = (com.baidu.rtc.a) PeerConnectionClient.this.csa.get(bigInteger)) == null) {
                    return;
                }
                if (aVar.crr != null) {
                    aVar.crr.close();
                    aVar.crr.dispose();
                    aVar.crr = null;
                }
                if (aVar.crs != null) {
                    aVar.crs.close();
                    aVar.crs = null;
                }
                PeerConnectionClient.this.csa.remove(bigInteger);
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
                    com.baidu.rtc.a aVar = (com.baidu.rtc.a) PeerConnectionClient.this.csa.get(bigInteger);
                    PeerConnection peerConnection = aVar.crr;
                    if (peerConnection == null || PeerConnectionClient.this.crN) {
                        return;
                    }
                    Log.d("PCRTCClient", "PC Create OFFER");
                    peerConnection.createOffer(aVar.crs, PeerConnectionClient.this.csg);
                }
            });
        }
    }

    public com.baidu.rtc.a j(BigInteger bigInteger) {
        return this.csa.get(bigInteger);
    }

    @Override // org.webrtc.DataChannel.Observer
    public void onBufferedAmountChange(long j) {
    }

    @Override // org.webrtc.DataChannel.Observer
    public void onMessage(DataChannel.Buffer buffer) {
        this.crJ.l(buffer.data);
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
                    if (PeerConnectionClient.this.crD != null) {
                        PeerConnectionClient.this.crD.setSpeakerMute(z);
                    }
                }
            });
        }
    }
}
