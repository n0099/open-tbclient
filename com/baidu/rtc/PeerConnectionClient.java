package com.baidu.rtc;

import android.content.Context;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Environment;
import android.util.Log;
import com.baidu.ala.helper.StreamConfig;
import com.baidu.rtc.RtcParameterSettings;
import com.baidu.rtc.m;
import com.baidu.searchbox.ugc.model.UgcConstant;
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
/* loaded from: classes12.dex */
public class PeerConnectionClient implements DataChannel.Observer {
    private Context context;
    private AudioTrack cpA;
    private VideoSink cpB;
    private SurfaceTextureHelper cpC;
    private RtpSender cpD;
    private VideoTrack cpE;
    private boolean cpG;
    private JavaAudioDeviceModule.RemoteSamplesReadyCallback cpI;
    private MediaStream cpK;
    private MediaConstraints cpL;
    private c cpN;
    private String cpO;
    private VideoTrack cpQ;
    private boolean cpR;
    private MediaConstraints cpS;
    private Timer cpT;
    private VideoCapturer cpW;
    private boolean cpX;
    private int cpY;
    private VideoSource cpZ;
    private MediaConstraints cpp;
    private MediaConstraints cpq;
    private AudioSource cpr;
    private boolean cpt;
    private b cpv;
    private PeerConnectionFactory cpw;
    private JavaAudioDeviceModule.SamplesReadyCallback cpx;
    private boolean cpz;
    private JavaAudioDeviceModule.ExternalSamplesReadyCallback externalSamplesCallback;
    private int videoHeight;
    private int videoWidth;
    PeerConnectionFactory.Options options = null;
    private Map<BigInteger, TimerTask> cpV = new ConcurrentHashMap();
    private Map<BigInteger, TimerTask> cpU = new ConcurrentHashMap();
    private boolean mHasVideo = true;
    private boolean mHasAudio = true;
    private boolean cpH = false;
    private int cpF = StreamConfig.Audio.AUDIO_RTC_FREQUENCY_48K;
    private int mAudioChannel = 1;
    private boolean cpy = true;
    private DataChannel cps = null;
    Map<BigInteger, Integer> cpP = new ConcurrentHashMap();
    private boolean cpJ = false;
    private JavaAudioDeviceModule cpo = null;
    private final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
    private ConcurrentHashMap<BigInteger, com.baidu.rtc.a> cpM = new ConcurrentHashMap<>();

    /* loaded from: classes12.dex */
    public enum StatsEventsType {
        GET_AUDIOLEVEL_EVENT,
        GET_QUALITY_MONITOR_EVENT,
        GET_BWE_EVENT
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public class a implements PeerConnection.Observer {
        private PeerConnection cpc;
        private com.baidu.rtc.a cqj;

        private a() {
        }

        public void a(com.baidu.rtc.a aVar) {
            this.cqj = aVar;
            this.cpc = aVar.cpc;
        }

        @Override // org.webrtc.PeerConnection.Observer
        public void onAddStream(final MediaStream mediaStream) {
            if (PeerConnectionClient.this.executor.isShutdown()) {
                Log.w("PCRTCClient", "executor is already shutdown");
            } else {
                PeerConnectionClient.this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.a.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.cpc == null || PeerConnectionClient.this.cpz) {
                            return;
                        }
                        Log.d("PCRTCClient", "=========== onAddStream ==========");
                        if (mediaStream.videoTracks.size() == 1) {
                            PeerConnectionClient.this.cpQ = mediaStream.videoTracks.get(0);
                            PeerConnectionClient.this.cpQ.setEnabled(true);
                            a.this.cqj.cpf = PeerConnectionClient.this.cpQ;
                            PeerConnectionClient.this.cpv.b(a.this.cqj);
                        }
                        PeerConnectionClient.this.cpv.a(mediaStream.videoTracks.size() != 0, mediaStream.audioTracks.size() != 0, a.this.cqj.cpb);
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
                        PeerConnectionClient.this.cpv.a(iceCandidate, a.this.cqj.cpb);
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
                        PeerConnectionClient.this.cpv.onIceCandidatesRemoved(iceCandidateArr);
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
                            PeerConnectionClient.this.cpv.ago();
                        } else if (iceConnectionState == PeerConnection.IceConnectionState.DISCONNECTED) {
                            PeerConnectionClient.this.cpv.agp();
                        } else if (iceConnectionState == PeerConnection.IceConnectionState.FAILED) {
                            PeerConnectionClient.this.cpv.agq();
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
                        PeerConnectionClient.this.cpQ = null;
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

    /* loaded from: classes12.dex */
    public interface b {
        void a(Boolean bool, Boolean bool2, BigInteger bigInteger);

        void a(IceCandidate iceCandidate, BigInteger bigInteger);

        void a(SessionDescription sessionDescription, BigInteger bigInteger);

        void a(SessionDescription sessionDescription, BigInteger bigInteger, boolean z);

        void a(StatsReport[] statsReportArr, BigInteger bigInteger, StatsEventsType statsEventsType);

        void ago();

        void agp();

        void agq();

        void agr();

        void b(com.baidu.rtc.a aVar);

        void kw(String str);

        void l(ByteBuffer byteBuffer);

        void onIceCandidatesRemoved(IceCandidate[] iceCandidateArr);
    }

    /* loaded from: classes12.dex */
    public static class c {
        public final int cpY;
        public final boolean cqA;
        public final boolean cqB;
        public final int cqC;
        public final boolean cqD;
        public final boolean cqE;
        public final boolean cqF;
        public RtcParameterSettings.RtcAudioChannel cqG;
        public final boolean cqH;
        public final String cqI;
        public final boolean cqJ;
        public final int cqK;
        public final int cqL;
        public RtcParameterSettings.RtcAudioBitrateMode cqp;
        public final String cqq;
        public final int cqr;
        public final int cqs;
        public final boolean cqt;
        public final boolean cqu;
        public final boolean cqv;
        public final boolean cqw;
        public final boolean cqx;
        public final boolean cqy;
        public final boolean cqz;
        public final int videoHeight;
        public final int videoWidth;

        public c(boolean z, int i, int i2, int i3, String str, boolean z2, int i4, String str2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, int i5, int i6, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, boolean z13, int i7, RtcParameterSettings.RtcAudioBitrateMode rtcAudioBitrateMode, RtcParameterSettings.RtcAudioChannel rtcAudioChannel, int i8, boolean z14) {
            this.cqF = z;
            this.videoWidth = i;
            this.videoHeight = i2;
            this.cpY = i3;
            this.cqI = str;
            this.cqJ = z2;
            this.cqs = i4;
            this.cqq = str2;
            this.cqE = z3;
            this.cqH = z4;
            this.cqu = z5;
            this.cqv = z6;
            this.cqw = z7;
            this.cqK = i5;
            this.cqL = i6;
            this.cqD = z8;
            this.cqt = z9;
            this.cqx = z10;
            this.cqy = z11;
            this.cqB = z12;
            this.cqz = z13;
            this.cqr = i7;
            this.cqp = rtcAudioBitrateMode;
            this.cqG = rtcAudioChannel;
            this.cqC = i8;
            this.cqA = z14;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public class d implements SdpObserver {
        private c cpa;
        private BigInteger cpb;
        private PeerConnection cpc;
        private d cpd;
        private boolean cpe;
        private SessionDescription cqM;

        d() {
        }

        public void a(com.baidu.rtc.a aVar) {
            this.cpc = aVar.cpc;
            this.cpd = aVar.cpd;
            this.cpb = aVar.cpb;
            this.cpe = aVar.cpe;
            this.cpa = aVar.cpa;
        }

        public void close() {
            this.cpc = null;
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
            this.cqM = sessionDescription2;
            if (PeerConnectionClient.this.executor.isShutdown()) {
                Log.w("PCRTCClient", "executor is already shutdown");
            } else {
                PeerConnectionClient.this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.d.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (d.this.cpc == null || PeerConnectionClient.this.cpz) {
                            return;
                        }
                        Log.d("PCRTCClient", "Set local SDP from " + sessionDescription2.type);
                        d.this.cpc.setLocalDescription(d.this.cpd, sessionDescription2);
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
                        if (d.this.cpc == null || PeerConnectionClient.this.cpz) {
                            return;
                        }
                        if (!d.this.cpe) {
                            if (d.this.cpc.getLocalDescription() == null) {
                                Log.d("PCRTCClient", "answer Remote SDP set succesfully");
                                return;
                            }
                            Log.d("PCRTCClient", "answer Local SDP set succesfully");
                            PeerConnectionClient.this.cpv.a(d.this.cqM, d.this.cpb);
                        } else if (d.this.cpc.getRemoteDescription() != null) {
                            Log.d("PCRTCClient", "Remote SDP set succesfully");
                        } else {
                            Log.d("PCRTCClient", "Local SDP set succesfully");
                            PeerConnectionClient.this.cpv.a(d.this.cqM, d.this.cpb, d.this.cqM.description.contains("profile-level-id=640c1f"));
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
        PeerConnection createPeerConnection = this.cpw.createPeerConnection(arrayList, aVar);
        com.baidu.rtc.a aVar2 = new com.baidu.rtc.a();
        aVar2.cpb = bigInteger;
        aVar2.cpd = dVar;
        aVar2.cpc = createPeerConnection;
        aVar2.cpe = z;
        aVar2.cpg = -1;
        aVar2.cpa = this.cpN;
        this.cpM.put(bigInteger, aVar2);
        aVar.a(aVar2);
        dVar.a(aVar2);
        DataChannel.Init init = new DataChannel.Init();
        if (this.cpH && z) {
            this.cps = createPeerConnection.createDataChannel("JanusDataChannel", init);
        }
        Log.d("PCRTCClient", "Peer connection created.");
        return createPeerConnection;
    }

    private VideoTrack a(EglBase.Context context, VideoCapturer videoCapturer) {
        this.cpZ = this.cpw.createVideoSource(false);
        this.cpC = SurfaceTextureHelper.create("video renderer", context);
        videoCapturer.initialize(this.cpC, this.context, this.cpZ.getCapturerObserver());
        videoCapturer.startCapture(this.videoWidth, this.videoHeight, this.cpY);
        this.cpE = this.cpw.createVideoTrack("ARDAMSv0", this.cpZ);
        this.cpE.setEnabled(this.cpR);
        this.cpE.addSink(this.cpB);
        return this.cpE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(PeerConnectionClient peerConnectionClient, Integer num) {
        if (peerConnectionClient.cpD == null) {
            return;
        }
        Log.d("PCRTCClient", "Requested max video bitrate: " + num);
        if (peerConnectionClient.cpD == null) {
            Log.w("PCRTCClient", "Sender is not ready.");
            return;
        }
        RtpParameters parameters = peerConnectionClient.cpD.getParameters();
        if (parameters.encodings.size() == 0) {
            Log.w("PCRTCClient", "RtpParameters are not ready.");
            return;
        }
        for (RtpParameters.Encoding encoding : parameters.encodings) {
            encoding.maxBitrateBps = num == null ? null : Integer.valueOf(num.intValue() * 1000);
        }
        if (!peerConnectionClient.cpD.setParameters(parameters)) {
            Log.e("PCRTCClient", "RtpSender.setParameters failed.");
        }
        Log.d("PCRTCClient", "Configured max video bitrate to: " + num);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final BigInteger bigInteger, final StatsEventsType statsEventsType) {
        if (this.cpM.get(bigInteger).cpc.getStats(new StatsObserver() { // from class: com.baidu.rtc.PeerConnectionClient.14
            @Override // org.webrtc.StatsObserver
            public void onComplete(StatsReport[] statsReportArr) {
                PeerConnectionClient.this.cpv.a(statsReportArr, bigInteger, statsEventsType);
            }
        }, null)) {
            return;
        }
        Log.e("PCRTCClient", "getStats() returns false!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(EglBase.Context context, BigInteger bigInteger) {
        if (this.cpw == null || this.cpz) {
            Log.e("PCRTCClient", "Peerconnection factory is not created");
            return;
        }
        Log.d("PCRTCClient", "PCConstraints: " + this.cpL.toString());
        Log.d("PCRTCClient", "EGLContext: " + context);
        PeerConnection a2 = a(bigInteger, true);
        this.cpK = this.cpw.createLocalMediaStream("ARDAMS");
        if (this.mHasVideo) {
            this.cpK.addTrack(a(context, this.cpW));
        }
        if (this.mHasAudio) {
            this.cpK.addTrack(agj());
        }
        a2.addStream(this.cpK);
        g(bigInteger);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agi() {
        Log.d("PCRTCClient", "Closing peer connection.");
        this.cpT.cancel();
        if (this.cpM != null) {
            int size = this.cpM.size();
            for (int i = 0; i < size; i++) {
                com.baidu.rtc.a aVar = (com.baidu.rtc.a) this.cpM.values().toArray()[i];
                aVar.cpc.close();
                aVar.cpc.dispose();
                aVar.cpc = null;
                aVar.cpd.close();
            }
        }
        Log.d("PCRTCClient", "Closing audio source.");
        if (this.cpr != null) {
            this.cpr.dispose();
            this.cpr = null;
        }
        Log.d("PCRTCClient", "Stopping capture.");
        if (this.cpW != null) {
            try {
                this.cpW.stopCapture();
                this.cpX = true;
                this.cpW.dispose();
                this.cpW = null;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        Log.d("PCRTCClient", "Closing video source.");
        if (this.cpZ != null) {
            this.cpZ.dispose();
            this.cpZ = null;
        }
        if (this.cpC != null) {
            this.cpC.dispose();
            this.cpC = null;
        }
        Log.d("PCRTCClient", "Closing peer connection factory.");
        if (this.cpw != null) {
            this.cpw.dispose();
            this.cpw = null;
        }
        this.options = null;
        Log.d("PCRTCClient", "Closing peer connection done.");
        this.cpv.agr();
        PeerConnectionFactory.stopInternalTracingCapture();
        PeerConnectionFactory.shutdownInternalTracer();
    }

    private AudioTrack agj() {
        this.cpr = this.cpw.createAudioSource(this.cpq);
        this.cpA = this.cpw.createAudioTrack("ARDAMSa0", this.cpr);
        this.cpA.setEnabled(this.cpt);
        return this.cpA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agk() {
        this.cpL = new MediaConstraints();
        this.cpL.optional.add(new MediaConstraints.KeyValuePair("DtlsSrtpKeyAgreement", "true"));
        this.videoWidth = this.cpN.videoWidth;
        this.videoHeight = this.cpN.videoHeight;
        this.cpY = this.cpN.cpY;
        if (this.videoWidth == 0 || this.videoHeight == 0) {
            this.videoWidth = PlatformPlugin.DEFAULT_SYSTEM_UI;
            this.videoHeight = 720;
        }
        if (this.cpY == 0) {
            this.cpY = 30;
        }
        Logging.d("PCRTCClient", "Capturing format: " + this.videoWidth + "x" + this.videoHeight + UgcConstant.AT_RULE_TAG + this.cpY);
        this.cpq = new MediaConstraints();
        if (this.cpN.cqE) {
            Log.d("PCRTCClient", "Disabling audio processing");
            this.cpq.mandatory.add(new MediaConstraints.KeyValuePair("googEchoCancellation", "false"));
            this.cpq.mandatory.add(new MediaConstraints.KeyValuePair("googAutoGainControl", "false"));
            this.cpq.mandatory.add(new MediaConstraints.KeyValuePair("googHighpassFilter", "false"));
            this.cpq.mandatory.add(new MediaConstraints.KeyValuePair("googNoiseSuppression", "false"));
        }
        this.cpS = new MediaConstraints();
        if (this.mHasAudio) {
            this.cpS.mandatory.add(new MediaConstraints.KeyValuePair("OfferToReceiveAudio", "true"));
        }
        if (this.mHasVideo) {
            this.cpS.mandatory.add(new MediaConstraints.KeyValuePair("OfferToReceiveVideo", "true"));
        }
        if (this.cpH) {
            this.cpS.mandatory.add(new MediaConstraints.KeyValuePair("data", "true"));
        }
    }

    public static PeerConnectionClient agl() {
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
    public void bD(Context context) {
        boolean z = false;
        if (this.cpN.cqF) {
            PeerConnectionFactory.startInternalTracingCapture(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "webrtc-trace.txt");
        }
        Log.d("PCRTCClient", "Create peer connection factory. Use video: true");
        this.cpz = false;
        this.cpO = "VP8";
        if (this.cpN.cqI != null) {
            if (this.cpN.cqI.equals("VP9")) {
                this.cpO = "VP9";
            } else if (this.cpN.cqI.equals("H264")) {
                this.cpO = "H264";
            }
        }
        Log.d("PCRTCClient", "Pereferred video codec: " + this.cpO);
        if (this.cpN.cqH) {
            Log.d("PCRTCClient", "Allow OpenSL ES audio if device supports it");
            WebRtcAudioManager.setBlacklistDeviceForOpenSLESUsage(false);
        } else {
            Log.d("PCRTCClient", "Disable OpenSL ES audio even if device supports it");
            WebRtcAudioManager.setBlacklistDeviceForOpenSLESUsage(true);
        }
        if (this.cpN.cqu) {
            Log.d("PCRTCClient", "Disable built-in AEC even if device supports it");
            WebRtcAudioUtils.setWebRtcBasedAcousticEchoCanceler(true);
        } else {
            Log.d("PCRTCClient", "Enable built-in AEC if device supports it");
            WebRtcAudioUtils.setWebRtcBasedAcousticEchoCanceler(false);
        }
        if (this.cpN.cqv) {
            Log.d("PCRTCClient", "Disable built-in AGC even if device supports it");
            WebRtcAudioUtils.setWebRtcBasedAutomaticGainControl(true);
        } else {
            Log.d("PCRTCClient", "Enable built-in AGC if device supports it");
            WebRtcAudioUtils.setWebRtcBasedAutomaticGainControl(false);
        }
        if (this.cpN.cqw) {
            Log.d("PCRTCClient", "Disable built-in NS even if device supports it");
            WebRtcAudioUtils.setWebRtcBasedNoiseSuppressor(true);
        } else {
            Log.d("PCRTCClient", "Enable built-in NS if device supports it");
            WebRtcAudioUtils.setWebRtcBasedNoiseSuppressor(false);
        }
        this.context = context;
        this.cpp = new MediaConstraints();
        this.cpp.mandatory.add(new MediaConstraints.KeyValuePair("OfferToReceiveAudio", "true"));
        this.cpp.mandatory.add(new MediaConstraints.KeyValuePair("OfferToReceiveVideo", "true"));
        String str = this.cpN.cqx ? "WebRTC-FlexFEC-03-Advertised/Enabled/WebRTC-FlexFEC-03/Enabled/" : "";
        if (this.cpN.cqy) {
            str = str + "BRTC.Fixed.Resolution/Enabled/";
        }
        if (this.cpN.cqC == 0 || this.cpN.cqC == 1 || this.cpN.cqC == 2) {
            str = str + "BRTC-Encoder-BitrateMode/" + this.cpN.cqC + "/";
        }
        if (this.cpN.cqz) {
            str = (str + "WebRTC-H264HighProfile/Enabled/") + "WebRTC-MediaTekH264/Enabled/";
        }
        if (this.cpN.cqA) {
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
        if (this.cpN.cqB || z) {
            str = str + "BRTC.Required.Resolustion.Aligment32/Enabled/";
        }
        PeerConnectionFactory.initialize(PeerConnectionFactory.InitializationOptions.builder(context).setFieldTrials(str).createInitializationOptions());
        AudioDeviceModule agm = agm();
        this.cpo = (JavaAudioDeviceModule) agm;
        this.cpw = PeerConnectionFactory.builder().setAudioDeviceModule(agm).setVideoDecoderFactory(MediaCodecVideoDecoder.createFactory()).setVideoEncoderFactory(MediaCodecVideoEncoder.createFactory()).createPeerConnectionFactory();
        Log.d("PCRTCClient", "Peer connection factory created.");
        agm.release();
        if (!this.cpJ) {
            Logging.enableLogToDebugOutput(Logging.Severity.LS_ERROR);
            return;
        }
        Logging.enableLogThreads();
        Logging.enableLogTimeStamps();
        Logging.enableLogToDebugOutput(Logging.Severity.LS_VERBOSE);
    }

    private void g(BigInteger bigInteger) {
        for (RtpSender rtpSender : this.cpM.get(bigInteger).cpc.getSenders()) {
            if (rtpSender.track() != null && rtpSender.track().kind().equals("video")) {
                Log.d("PCRTCClient", "Found video sender.");
                this.cpD = rtpSender;
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
                    if (PeerConnectionClient.this.cpz) {
                        return;
                    }
                    PeerConnectionClient.this.cpv.kw(str);
                    PeerConnectionClient.this.cpz = true;
                }
            });
        }
    }

    public void a(final Context context, c cVar, b bVar) {
        this.cpN = cVar;
        this.cpv = bVar;
        this.context = null;
        this.cpw = null;
        this.cpX = false;
        this.cpz = false;
        this.cpK = null;
        this.cpW = null;
        this.cpR = !cVar.cqt;
        this.cpE = null;
        this.cpQ = null;
        this.cpD = null;
        this.cpt = !cVar.cqD;
        this.cpA = null;
        this.cpT = new Timer();
        if (this.executor.isShutdown()) {
            Log.w("PCRTCClient", "executor is already shutdown");
        } else {
            this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.1
                @Override // java.lang.Runnable
                public void run() {
                    PeerConnectionClient.this.bD(context);
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
                    PeerConnection peerConnection = ((com.baidu.rtc.a) PeerConnectionClient.this.cpM.get(bigInteger)).cpc;
                    d dVar = ((com.baidu.rtc.a) PeerConnectionClient.this.cpM.get(bigInteger)).cpd;
                    if (peerConnection == null || PeerConnectionClient.this.cpz) {
                        return;
                    }
                    String str = sessionDescription.description;
                    m.a aVar = new m.a();
                    aVar.cro = PeerConnectionClient.this.cpN.cqp == RtcParameterSettings.RtcAudioBitrateMode.RTC_AUDIO_BITRATE_CBR;
                    aVar.crp = PeerConnectionClient.this.cpN.cqr;
                    aVar.crs = PeerConnectionClient.this.cpN.cqG == RtcParameterSettings.RtcAudioChannel.RTC_AUDIO_STEREO;
                    peerConnection.setRemoteDescription(dVar, new SessionDescription(sessionDescription.type, m.a(PeerConnectionClient.this.cpN.cqq, str, aVar)));
                }
            });
        }
    }

    public void a(final EglBase.Context context, VideoSink videoSink, VideoCapturer videoCapturer, final BigInteger bigInteger) {
        if (this.cpN == null) {
            Log.e("PCRTCClient", "Creating peer connection without initializing factory.");
            return;
        }
        this.cpB = videoSink;
        this.cpW = videoCapturer;
        if (this.executor.isShutdown()) {
            Log.w("PCRTCClient", "executor is already shutdown");
        } else {
            this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.8
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        PeerConnectionClient.this.agk();
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
        this.cpI = remoteSamplesReadyCallback;
    }

    public void a(JavaAudioDeviceModule.SamplesReadyCallback samplesReadyCallback) {
        this.cpx = samplesReadyCallback;
    }

    public void a(boolean z, int i, final BigInteger bigInteger, final StatsEventsType statsEventsType) {
        TimerTask timerTask = null;
        if (!z) {
            if (statsEventsType == StatsEventsType.GET_AUDIOLEVEL_EVENT) {
                timerTask = this.cpV.get(bigInteger);
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
                timerTask = this.cpV.get(bigInteger);
            } else if (statsEventsType == StatsEventsType.GET_QUALITY_MONITOR_EVENT) {
                this.cpU.get(bigInteger);
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
                this.cpV.put(bigInteger, timerTask2);
            } else if (statsEventsType == StatsEventsType.GET_QUALITY_MONITOR_EVENT) {
                this.cpU.put(bigInteger, timerTask2);
            }
            this.cpT.schedule(timerTask2, 0L, i);
        } catch (Exception e) {
            Log.e("PCRTCClient", "Can not schedule statistics timer", e);
        }
    }

    AudioDeviceModule agm() {
        AudioDeviceModule createAudioDeviceModule = JavaAudioDeviceModule.builder(this.context).setSamplesReadyCallback(this.cpx).setRemoteSamplesReadyCallback(this.cpI).setExternalAudioRecord(this.cpG).setUseHardwareAcousticEchoCanceler(!this.cpN.cqu).setUseHardwareNoiseSuppressor(!this.cpN.cqw).setAudioRecordErrorCallback(new JavaAudioDeviceModule.AudioRecordErrorCallback() { // from class: com.baidu.rtc.PeerConnectionClient.11
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
        }).setSampleRate(this.cpF).setUseStereoInput(this.mAudioChannel > 1).setUseStereoOutput(this.mAudioChannel > 1).createAudioDeviceModule();
        if (this.cpG && (createAudioDeviceModule instanceof JavaAudioDeviceModule)) {
            this.externalSamplesCallback = ((JavaAudioDeviceModule) createAudioDeviceModule).getExternalSamplesReadyCallback();
        }
        return createAudioDeviceModule;
    }

    public void agn() {
        if (this.executor.isShutdown()) {
            Log.w("PCRTCClient", "executor is already shutdown");
        } else {
            this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.6
                @Override // java.lang.Runnable
                public void run() {
                    if (PeerConnectionClient.this.cpW == null || PeerConnectionClient.this.cpX) {
                        return;
                    }
                    Log.d("PCRTCClient", "Stop video source.");
                    try {
                        PeerConnectionClient.this.cpW.stopCapture();
                    } catch (InterruptedException e) {
                    }
                    PeerConnectionClient.this.cpX = true;
                }
            });
        }
    }

    public void b(final Integer num) {
        this.executor.execute(new Runnable() { // from class: com.baidu.rtc.q
            @Override // java.lang.Runnable
            public final void run() {
                PeerConnectionClient.a(PeerConnectionClient.this, num);
            }
        });
    }

    public void b(final BigInteger bigInteger, final SessionDescription sessionDescription) {
        if (this.executor.isShutdown()) {
            Log.w("PCRTCClient", "executor is already shutdown");
        } else {
            this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.5
                @Override // java.lang.Runnable
                public void run() {
                    PeerConnection a2 = PeerConnectionClient.this.a(bigInteger, false);
                    d dVar = ((com.baidu.rtc.a) PeerConnectionClient.this.cpM.get(bigInteger)).cpd;
                    if (a2 == null || PeerConnectionClient.this.cpz) {
                        return;
                    }
                    a2.setRemoteDescription(dVar, sessionDescription);
                    Log.d("PCRTCClient", "PC create ANSWER");
                    a2.createAnswer(((com.baidu.rtc.a) PeerConnectionClient.this.cpM.get(bigInteger)).cpd, PeerConnectionClient.this.cpp);
                }
            });
        }
    }

    public void close() {
        this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.10
            @Override // java.lang.Runnable
            public void run() {
                PeerConnectionClient.this.agi();
            }
        });
        try {
            this.executor.shutdown();
            this.executor.awaitTermination(200L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
        }
    }

    public void ej(final boolean z) {
        if (this.executor.isShutdown()) {
            Log.w("PCRTCClient", "executor is already shutdown");
        } else {
            this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.16
                @Override // java.lang.Runnable
                public void run() {
                    PeerConnectionClient.this.cpt = z;
                    if (PeerConnectionClient.this.cpA != null) {
                        PeerConnectionClient.this.cpA.setEnabled(PeerConnectionClient.this.cpt);
                    }
                }
            });
        }
    }

    public void ek(boolean z) {
        this.cpJ = z;
    }

    public void el(boolean z) {
        this.cpG = z;
    }

    public void em(boolean z) {
        this.mHasAudio = z;
    }

    public void en(boolean z) {
        this.cpH = z;
    }

    public void eo(boolean z) {
        this.mHasVideo = z;
    }

    public void ep(final boolean z) {
        if (this.executor.isShutdown()) {
            Log.w("PCRTCClient", "executor is already shutdown");
        } else {
            this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.2
                @Override // java.lang.Runnable
                public void run() {
                    PeerConnectionClient.this.cpR = z;
                    if (PeerConnectionClient.this.cpE != null) {
                        PeerConnectionClient.this.cpE.setEnabled(PeerConnectionClient.this.cpR);
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
                if (PeerConnectionClient.this.cpM == null || (aVar = (com.baidu.rtc.a) PeerConnectionClient.this.cpM.get(bigInteger)) == null) {
                    return;
                }
                if (aVar.cpc != null) {
                    aVar.cpc.close();
                    aVar.cpc.dispose();
                    aVar.cpc = null;
                }
                if (aVar.cpd != null) {
                    aVar.cpd.close();
                    aVar.cpd = null;
                }
                PeerConnectionClient.this.cpM.remove(bigInteger);
            }
        });
    }

    public void hy(int i) {
        this.cpF = i;
    }

    public void i(final BigInteger bigInteger) {
        if (this.executor.isShutdown()) {
            Log.w("PCRTCClient", "executor is already shutdown");
        } else {
            this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.3
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.rtc.a aVar = (com.baidu.rtc.a) PeerConnectionClient.this.cpM.get(bigInteger);
                    PeerConnection peerConnection = aVar.cpc;
                    if (peerConnection == null || PeerConnectionClient.this.cpz) {
                        return;
                    }
                    Log.d("PCRTCClient", "PC Create OFFER");
                    peerConnection.createOffer(aVar.cpd, PeerConnectionClient.this.cpS);
                }
            });
        }
    }

    public com.baidu.rtc.a j(BigInteger bigInteger) {
        return this.cpM.get(bigInteger);
    }

    @Override // org.webrtc.DataChannel.Observer
    public void onBufferedAmountChange(long j) {
    }

    @Override // org.webrtc.DataChannel.Observer
    public void onMessage(DataChannel.Buffer buffer) {
        this.cpv.l(buffer.data);
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
                    if (PeerConnectionClient.this.cpo != null) {
                        PeerConnectionClient.this.cpo.setSpeakerMute(z);
                    }
                }
            });
        }
    }
}
