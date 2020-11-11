package com.baidu.rtc;

import android.content.Context;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Environment;
import android.util.Log;
import com.baidu.ala.helper.StreamConfig;
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
/* loaded from: classes9.dex */
public class PeerConnectionClient implements DataChannel.Observer {
    private boolean ckA;
    private AudioTrack ckB;
    private VideoSink ckC;
    private SurfaceTextureHelper ckD;
    private RtpSender ckE;
    private VideoTrack ckF;
    private boolean ckH;
    private JavaAudioDeviceModule.RemoteSamplesReadyCallback ckJ;
    private MediaStream ckL;
    private MediaConstraints ckM;
    private c ckO;
    private String ckP;
    private VideoTrack ckR;
    private boolean ckS;
    private MediaConstraints ckT;
    private Timer ckU;
    private VideoCapturer ckX;
    private boolean ckY;
    private int ckZ;
    private MediaConstraints ckr;
    private MediaConstraints cks;
    private AudioSource ckt;
    private boolean ckv;
    private b ckw;
    private PeerConnectionFactory ckx;
    private JavaAudioDeviceModule.SamplesReadyCallback cky;
    private VideoSource cla;
    private Context context;
    private JavaAudioDeviceModule.ExternalSamplesReadyCallback externalSamplesCallback;
    private int videoHeight;
    private int videoWidth;
    PeerConnectionFactory.Options options = null;
    private Map<BigInteger, TimerTask> ckW = new ConcurrentHashMap();
    private Map<BigInteger, TimerTask> ckV = new ConcurrentHashMap();
    private boolean mHasVideo = true;
    private boolean mHasAudio = true;
    private boolean ckI = false;
    private int ckG = StreamConfig.Audio.AUDIO_RTC_FREQUENCY_48K;
    private int mAudioChannel = 1;
    private boolean ckz = true;
    private DataChannel cku = null;
    Map<BigInteger, Integer> ckQ = new ConcurrentHashMap();
    private boolean ckK = false;
    private JavaAudioDeviceModule ckq = null;
    private final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
    private ConcurrentHashMap<BigInteger, com.baidu.rtc.a> ckN = new ConcurrentHashMap<>();

    /* loaded from: classes9.dex */
    public enum StatsEventsType {
        GET_AUDIOLEVEL_EVENT,
        GET_QUALITY_MONITOR_EVENT,
        GET_BWE_EVENT
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a implements PeerConnection.Observer {
        private PeerConnection ckf;
        private com.baidu.rtc.a clk;

        private a() {
        }

        public void a(com.baidu.rtc.a aVar) {
            this.clk = aVar;
            this.ckf = aVar.ckf;
        }

        @Override // org.webrtc.PeerConnection.Observer
        public void onAddStream(final MediaStream mediaStream) {
            if (PeerConnectionClient.this.executor.isShutdown()) {
                Log.w("PCRTCClient", "executor is already shutdown");
            } else {
                PeerConnectionClient.this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.a.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.ckf == null || PeerConnectionClient.this.ckA) {
                            return;
                        }
                        Log.d("PCRTCClient", "=========== onAddStream ==========");
                        if (mediaStream.videoTracks.size() == 1) {
                            PeerConnectionClient.this.ckR = mediaStream.videoTracks.get(0);
                            PeerConnectionClient.this.ckR.setEnabled(true);
                            a.this.clk.cki = PeerConnectionClient.this.ckR;
                            PeerConnectionClient.this.ckw.b(a.this.clk);
                        }
                        PeerConnectionClient.this.ckw.a(mediaStream.videoTracks.size() != 0, mediaStream.audioTracks.size() != 0, a.this.clk.cke);
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
                        PeerConnectionClient.this.ckw.a(iceCandidate, a.this.clk.cke);
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
                        PeerConnectionClient.this.ckw.onIceCandidatesRemoved(iceCandidateArr);
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
                            PeerConnectionClient.this.ckw.adN();
                        } else if (iceConnectionState == PeerConnection.IceConnectionState.DISCONNECTED) {
                            PeerConnectionClient.this.ckw.adO();
                        } else if (iceConnectionState == PeerConnection.IceConnectionState.FAILED) {
                            PeerConnectionClient.this.ckw.adP();
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
                        PeerConnectionClient.this.ckR = null;
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

        void a(StatsReport[] statsReportArr, BigInteger bigInteger, StatsEventsType statsEventsType);

        void adN();

        void adO();

        void adP();

        void adQ();

        void b(com.baidu.rtc.a aVar);

        void b(SessionDescription sessionDescription, BigInteger bigInteger);

        void jV(String str);

        void l(ByteBuffer byteBuffer);

        void onIceCandidatesRemoved(IceCandidate[] iceCandidateArr);
    }

    /* loaded from: classes9.dex */
    public static class c {
        public final int ckZ;
        public final int clA;
        public final boolean clB;
        public final boolean clC;
        public final boolean clD;
        public final boolean clE;
        public final String clF;
        public final boolean clG;
        public final int clH;
        public final int clI;
        public final String clq;
        public final int clr;
        public final boolean cls;
        public final boolean clt;
        public final boolean clu;
        public final boolean clv;
        public final boolean clw;
        public final boolean clx;
        public final boolean cly;
        public final boolean clz;
        public final int videoHeight;
        public final int videoWidth;

        public c(boolean z, int i, int i2, int i3, String str, boolean z2, int i4, String str2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, int i5, int i6, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, boolean z13, int i7) {
            this.clD = z;
            this.videoWidth = i;
            this.videoHeight = i2;
            this.ckZ = i3;
            this.clF = str;
            this.clG = z2;
            this.clr = i4;
            this.clq = str2;
            this.clC = z3;
            this.clE = z4;
            this.clt = z5;
            this.clu = z6;
            this.clv = z7;
            this.clH = i5;
            this.clI = i6;
            this.clB = z8;
            this.cls = z9;
            this.clw = z10;
            this.clx = z11;
            this.clz = z12;
            this.cly = z13;
            this.clA = i7;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class d implements SdpObserver {
        private c ckd;
        private BigInteger cke;
        private PeerConnection ckf;
        private d ckg;
        private boolean ckh;
        private SessionDescription clJ;

        d() {
        }

        public void a(com.baidu.rtc.a aVar) {
            this.ckf = aVar.ckf;
            this.ckg = aVar.ckg;
            this.cke = aVar.cke;
            this.ckh = aVar.ckh;
            this.ckd = aVar.ckd;
        }

        public void close() {
            this.ckf = null;
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
            this.clJ = sessionDescription2;
            if (PeerConnectionClient.this.executor.isShutdown()) {
                Log.w("PCRTCClient", "executor is already shutdown");
            } else {
                PeerConnectionClient.this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.d.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (d.this.ckf == null || PeerConnectionClient.this.ckA) {
                            return;
                        }
                        Log.d("PCRTCClient", "Set local SDP from " + sessionDescription2.type);
                        d.this.ckf.setLocalDescription(d.this.ckg, sessionDescription2);
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
                        if (d.this.ckf == null || PeerConnectionClient.this.ckA) {
                            return;
                        }
                        if (d.this.ckh) {
                            if (d.this.ckf.getRemoteDescription() != null) {
                                Log.d("PCRTCClient", "Remote SDP set succesfully");
                                return;
                            }
                            Log.d("PCRTCClient", "Local SDP set succesfully");
                            PeerConnectionClient.this.ckw.a(d.this.clJ, d.this.cke);
                        } else if (d.this.ckf.getLocalDescription() == null) {
                            Log.d("PCRTCClient", "answer Remote SDP set succesfully");
                        } else {
                            Log.d("PCRTCClient", "answer Local SDP set succesfully");
                            PeerConnectionClient.this.ckw.b(d.this.clJ, d.this.cke);
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
        PeerConnection createPeerConnection = this.ckx.createPeerConnection(arrayList, aVar);
        com.baidu.rtc.a aVar2 = new com.baidu.rtc.a();
        aVar2.cke = bigInteger;
        aVar2.ckg = dVar;
        aVar2.ckf = createPeerConnection;
        aVar2.ckh = z;
        aVar2.ckj = -1;
        aVar2.ckd = this.ckO;
        this.ckN.put(bigInteger, aVar2);
        aVar.a(aVar2);
        dVar.a(aVar2);
        DataChannel.Init init = new DataChannel.Init();
        if (this.ckI && z) {
            this.cku = createPeerConnection.createDataChannel("JanusDataChannel", init);
        }
        Log.d("PCRTCClient", "Peer connection created.");
        return createPeerConnection;
    }

    private VideoTrack a(EglBase.Context context, VideoCapturer videoCapturer) {
        this.cla = this.ckx.createVideoSource(false);
        this.ckD = SurfaceTextureHelper.create("video renderer", context);
        videoCapturer.initialize(this.ckD, this.context, this.cla.getCapturerObserver());
        videoCapturer.startCapture(this.videoWidth, this.videoHeight, this.ckZ);
        this.ckF = this.ckx.createVideoTrack("ARDAMSv0", this.cla);
        this.ckF.setEnabled(this.ckS);
        this.ckF.addSink(this.ckC);
        return this.ckF;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(PeerConnectionClient peerConnectionClient, Integer num) {
        if (peerConnectionClient.ckE == null) {
            return;
        }
        Log.d("PCRTCClient", "Requested max video bitrate: " + num);
        if (peerConnectionClient.ckE == null) {
            Log.w("PCRTCClient", "Sender is not ready.");
            return;
        }
        RtpParameters parameters = peerConnectionClient.ckE.getParameters();
        if (parameters.encodings.size() == 0) {
            Log.w("PCRTCClient", "RtpParameters are not ready.");
            return;
        }
        for (RtpParameters.Encoding encoding : parameters.encodings) {
            encoding.maxBitrateBps = num == null ? null : Integer.valueOf(num.intValue() * 1000);
        }
        if (!peerConnectionClient.ckE.setParameters(parameters)) {
            Log.e("PCRTCClient", "RtpSender.setParameters failed.");
        }
        Log.d("PCRTCClient", "Configured max video bitrate to: " + num);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final BigInteger bigInteger, final StatsEventsType statsEventsType) {
        if (this.ckN.get(bigInteger).ckf.getStats(new StatsObserver() { // from class: com.baidu.rtc.PeerConnectionClient.14
            @Override // org.webrtc.StatsObserver
            public void onComplete(StatsReport[] statsReportArr) {
                PeerConnectionClient.this.ckw.a(statsReportArr, bigInteger, statsEventsType);
            }
        }, null)) {
            return;
        }
        Log.e("PCRTCClient", "getStats() returns false!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(EglBase.Context context, BigInteger bigInteger) {
        if (this.ckx == null || this.ckA) {
            Log.e("PCRTCClient", "Peerconnection factory is not created");
            return;
        }
        Log.d("PCRTCClient", "PCConstraints: " + this.ckM.toString());
        Log.d("PCRTCClient", "EGLContext: " + context);
        PeerConnection a2 = a(bigInteger, true);
        this.ckL = this.ckx.createLocalMediaStream("ARDAMS");
        if (this.mHasVideo) {
            this.ckL.addTrack(a(context, this.ckX));
        }
        if (this.mHasAudio) {
            this.ckL.addTrack(adI());
        }
        a2.addStream(this.ckL);
        g(bigInteger);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aX(Context context) {
        boolean z = false;
        if (this.ckO.clD) {
            PeerConnectionFactory.startInternalTracingCapture(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "webrtc-trace.txt");
        }
        Log.d("PCRTCClient", "Create peer connection factory. Use video: true");
        this.ckA = false;
        this.ckP = "VP8";
        if (this.ckO.clF != null) {
            if (this.ckO.clF.equals("VP9")) {
                this.ckP = "VP9";
            } else if (this.ckO.clF.equals("H264")) {
                this.ckP = "H264";
            }
        }
        Log.d("PCRTCClient", "Pereferred video codec: " + this.ckP);
        if (this.ckO.clE) {
            Log.d("PCRTCClient", "Allow OpenSL ES audio if device supports it");
            WebRtcAudioManager.setBlacklistDeviceForOpenSLESUsage(false);
        } else {
            Log.d("PCRTCClient", "Disable OpenSL ES audio even if device supports it");
            WebRtcAudioManager.setBlacklistDeviceForOpenSLESUsage(true);
        }
        if (this.ckO.clt) {
            Log.d("PCRTCClient", "Disable built-in AEC even if device supports it");
            WebRtcAudioUtils.setWebRtcBasedAcousticEchoCanceler(true);
        } else {
            Log.d("PCRTCClient", "Enable built-in AEC if device supports it");
            WebRtcAudioUtils.setWebRtcBasedAcousticEchoCanceler(false);
        }
        if (this.ckO.clu) {
            Log.d("PCRTCClient", "Disable built-in AGC even if device supports it");
            WebRtcAudioUtils.setWebRtcBasedAutomaticGainControl(true);
        } else {
            Log.d("PCRTCClient", "Enable built-in AGC if device supports it");
            WebRtcAudioUtils.setWebRtcBasedAutomaticGainControl(false);
        }
        if (this.ckO.clv) {
            Log.d("PCRTCClient", "Disable built-in NS even if device supports it");
            WebRtcAudioUtils.setWebRtcBasedNoiseSuppressor(true);
        } else {
            Log.d("PCRTCClient", "Enable built-in NS if device supports it");
            WebRtcAudioUtils.setWebRtcBasedNoiseSuppressor(false);
        }
        this.context = context;
        this.ckr = new MediaConstraints();
        this.ckr.mandatory.add(new MediaConstraints.KeyValuePair("OfferToReceiveAudio", "true"));
        this.ckr.mandatory.add(new MediaConstraints.KeyValuePair("OfferToReceiveVideo", "true"));
        String str = this.ckO.clw ? "WebRTC-FlexFEC-03-Advertised/Enabled/WebRTC-FlexFEC-03/Enabled/" : "";
        if (this.ckO.clx) {
            str = str + "BRTC.Fixed.Resolution/Enabled/";
        }
        if (this.ckO.clA == 0 || this.ckO.clA == 1 || this.ckO.clA == 2) {
            str = str + "BRTC-Encoder-BitrateMode/" + this.ckO.clA + "/";
        }
        boolean z2 = this.ckO.cly;
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
        if (this.ckO.clz || z) {
            str = str + "BRTC.Required.Resolustion.Aligment32/Enabled/";
        }
        PeerConnectionFactory.initialize(PeerConnectionFactory.InitializationOptions.builder(context).setFieldTrials(str).createInitializationOptions());
        AudioDeviceModule adL = adL();
        this.ckq = (JavaAudioDeviceModule) adL;
        this.ckx = PeerConnectionFactory.builder().setAudioDeviceModule(adL).setVideoDecoderFactory(MediaCodecVideoDecoder.createFactory()).setVideoEncoderFactory(MediaCodecVideoEncoder.createFactory()).createPeerConnectionFactory();
        Log.d("PCRTCClient", "Peer connection factory created.");
        adL.release();
        if (!this.ckK) {
            Logging.enableLogToDebugOutput(Logging.Severity.LS_ERROR);
            return;
        }
        Logging.enableLogThreads();
        Logging.enableLogTimeStamps();
        Logging.enableLogToDebugOutput(Logging.Severity.LS_VERBOSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adH() {
        Log.d("PCRTCClient", "Closing peer connection.");
        this.ckU.cancel();
        if (this.ckN != null) {
            int size = this.ckN.size();
            for (int i = 0; i < size; i++) {
                com.baidu.rtc.a aVar = (com.baidu.rtc.a) this.ckN.values().toArray()[i];
                aVar.ckf.close();
                aVar.ckf.dispose();
                aVar.ckf = null;
                aVar.ckg.close();
            }
        }
        Log.d("PCRTCClient", "Closing audio source.");
        if (this.ckt != null) {
            this.ckt.dispose();
            this.ckt = null;
        }
        Log.d("PCRTCClient", "Stopping capture.");
        if (this.ckX != null) {
            try {
                this.ckX.stopCapture();
                this.ckY = true;
                this.ckX.dispose();
                this.ckX = null;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        Log.d("PCRTCClient", "Closing video source.");
        if (this.cla != null) {
            this.cla.dispose();
            this.cla = null;
        }
        if (this.ckD != null) {
            this.ckD.dispose();
            this.ckD = null;
        }
        Log.d("PCRTCClient", "Closing peer connection factory.");
        if (this.ckx != null) {
            this.ckx.dispose();
            this.ckx = null;
        }
        this.options = null;
        Log.d("PCRTCClient", "Closing peer connection done.");
        this.ckw.adQ();
        PeerConnectionFactory.stopInternalTracingCapture();
        PeerConnectionFactory.shutdownInternalTracer();
    }

    private AudioTrack adI() {
        this.ckt = this.ckx.createAudioSource(this.cks);
        this.ckB = this.ckx.createAudioTrack("ARDAMSa0", this.ckt);
        this.ckB.setEnabled(this.ckv);
        return this.ckB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adJ() {
        this.ckM = new MediaConstraints();
        this.ckM.optional.add(new MediaConstraints.KeyValuePair("DtlsSrtpKeyAgreement", "true"));
        this.videoWidth = this.ckO.videoWidth;
        this.videoHeight = this.ckO.videoHeight;
        this.ckZ = this.ckO.ckZ;
        if (this.videoWidth == 0 || this.videoHeight == 0) {
            this.videoWidth = PlatformPlugin.DEFAULT_SYSTEM_UI;
            this.videoHeight = 720;
        }
        if (this.ckZ == 0) {
            this.ckZ = 30;
        }
        Logging.d("PCRTCClient", "Capturing format: " + this.videoWidth + "x" + this.videoHeight + UgcConstant.AT_RULE_TAG + this.ckZ);
        this.cks = new MediaConstraints();
        if (this.ckO.clC) {
            Log.d("PCRTCClient", "Disabling audio processing");
            this.cks.mandatory.add(new MediaConstraints.KeyValuePair("googEchoCancellation", "false"));
            this.cks.mandatory.add(new MediaConstraints.KeyValuePair("googAutoGainControl", "false"));
            this.cks.mandatory.add(new MediaConstraints.KeyValuePair("googHighpassFilter", "false"));
            this.cks.mandatory.add(new MediaConstraints.KeyValuePair("googNoiseSuppression", "false"));
        }
        this.ckT = new MediaConstraints();
        if (this.mHasAudio) {
            this.ckT.mandatory.add(new MediaConstraints.KeyValuePair("OfferToReceiveAudio", "true"));
        }
        if (this.mHasVideo) {
            this.ckT.mandatory.add(new MediaConstraints.KeyValuePair("OfferToReceiveVideo", "true"));
        }
        if (this.ckI) {
            this.ckT.mandatory.add(new MediaConstraints.KeyValuePair("data", "true"));
        }
    }

    public static PeerConnectionClient adK() {
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

    private void g(BigInteger bigInteger) {
        for (RtpSender rtpSender : this.ckN.get(bigInteger).ckf.getSenders()) {
            if (rtpSender.track() != null && rtpSender.track().kind().equals("video")) {
                Log.d("PCRTCClient", "Found video sender.");
                this.ckE = rtpSender;
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
                    if (PeerConnectionClient.this.ckA) {
                        return;
                    }
                    PeerConnectionClient.this.ckw.jV(str);
                    PeerConnectionClient.this.ckA = true;
                }
            });
        }
    }

    public void a(final Context context, c cVar, b bVar) {
        this.ckO = cVar;
        this.ckw = bVar;
        this.context = null;
        this.ckx = null;
        this.ckY = false;
        this.ckA = false;
        this.ckL = null;
        this.ckX = null;
        this.ckS = !cVar.cls;
        this.ckF = null;
        this.ckR = null;
        this.ckE = null;
        this.ckv = !cVar.clB;
        this.ckB = null;
        this.ckU = new Timer();
        if (this.executor.isShutdown()) {
            Log.w("PCRTCClient", "executor is already shutdown");
        } else {
            this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.1
                @Override // java.lang.Runnable
                public void run() {
                    PeerConnectionClient.this.aX(context);
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
                    PeerConnection peerConnection = ((com.baidu.rtc.a) PeerConnectionClient.this.ckN.get(bigInteger)).ckf;
                    d dVar = ((com.baidu.rtc.a) PeerConnectionClient.this.ckN.get(bigInteger)).ckg;
                    if (peerConnection == null || PeerConnectionClient.this.ckA) {
                        return;
                    }
                    peerConnection.setRemoteDescription(dVar, new SessionDescription(sessionDescription.type, sessionDescription.description));
                }
            });
        }
    }

    public void a(final EglBase.Context context, VideoSink videoSink, VideoCapturer videoCapturer, final BigInteger bigInteger) {
        if (this.ckO == null) {
            Log.e("PCRTCClient", "Creating peer connection without initializing factory.");
            return;
        }
        this.ckC = videoSink;
        this.ckX = videoCapturer;
        if (this.executor.isShutdown()) {
            Log.w("PCRTCClient", "executor is already shutdown");
        } else {
            this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.8
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        PeerConnectionClient.this.adJ();
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
        this.ckJ = remoteSamplesReadyCallback;
    }

    public void a(JavaAudioDeviceModule.SamplesReadyCallback samplesReadyCallback) {
        this.cky = samplesReadyCallback;
    }

    public void a(boolean z, int i, final BigInteger bigInteger, final StatsEventsType statsEventsType) {
        TimerTask timerTask = null;
        if (!z) {
            if (statsEventsType == StatsEventsType.GET_AUDIOLEVEL_EVENT) {
                timerTask = this.ckW.get(bigInteger);
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
                timerTask = this.ckW.get(bigInteger);
            } else if (statsEventsType == StatsEventsType.GET_QUALITY_MONITOR_EVENT) {
                this.ckV.get(bigInteger);
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
                this.ckW.put(bigInteger, timerTask2);
            } else if (statsEventsType == StatsEventsType.GET_QUALITY_MONITOR_EVENT) {
                this.ckV.put(bigInteger, timerTask2);
            }
            this.ckU.schedule(timerTask2, 0L, i);
        } catch (Exception e) {
            Log.e("PCRTCClient", "Can not schedule statistics timer", e);
        }
    }

    AudioDeviceModule adL() {
        AudioDeviceModule createAudioDeviceModule = JavaAudioDeviceModule.builder(this.context).setSamplesReadyCallback(this.cky).setRemoteSamplesReadyCallback(this.ckJ).setExternalAudioRecord(this.ckH).setUseHardwareAcousticEchoCanceler(!this.ckO.clt).setUseHardwareNoiseSuppressor(true).setAudioRecordErrorCallback(new JavaAudioDeviceModule.AudioRecordErrorCallback() { // from class: com.baidu.rtc.PeerConnectionClient.11
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
        }).setSampleRate(this.ckG).setUseStereoInput(this.mAudioChannel > 1).setUseStereoOutput(this.mAudioChannel > 1).createAudioDeviceModule();
        if (this.ckH && (createAudioDeviceModule instanceof JavaAudioDeviceModule)) {
            this.externalSamplesCallback = ((JavaAudioDeviceModule) createAudioDeviceModule).getExternalSamplesReadyCallback();
        }
        return createAudioDeviceModule;
    }

    public void adM() {
        if (this.executor.isShutdown()) {
            Log.w("PCRTCClient", "executor is already shutdown");
        } else {
            this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.6
                @Override // java.lang.Runnable
                public void run() {
                    if (PeerConnectionClient.this.ckX == null || PeerConnectionClient.this.ckY) {
                        return;
                    }
                    Log.d("PCRTCClient", "Stop video source.");
                    try {
                        PeerConnectionClient.this.ckX.stopCapture();
                    } catch (InterruptedException e) {
                    }
                    PeerConnectionClient.this.ckY = true;
                }
            });
        }
    }

    public void b(final Integer num) {
        this.executor.execute(new Runnable() { // from class: com.baidu.rtc.p
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
                    d dVar = ((com.baidu.rtc.a) PeerConnectionClient.this.ckN.get(bigInteger)).ckg;
                    if (a2 == null || PeerConnectionClient.this.ckA) {
                        return;
                    }
                    a2.setRemoteDescription(dVar, sessionDescription);
                    Log.d("PCRTCClient", "PC create ANSWER");
                    a2.createAnswer(((com.baidu.rtc.a) PeerConnectionClient.this.ckN.get(bigInteger)).ckg, PeerConnectionClient.this.ckr);
                }
            });
        }
    }

    public void close() {
        this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.10
            @Override // java.lang.Runnable
            public void run() {
                PeerConnectionClient.this.adH();
            }
        });
        try {
            this.executor.shutdown();
            this.executor.awaitTermination(200L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
        }
    }

    public void dR(final boolean z) {
        if (this.executor.isShutdown()) {
            Log.w("PCRTCClient", "executor is already shutdown");
        } else {
            this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.16
                @Override // java.lang.Runnable
                public void run() {
                    PeerConnectionClient.this.ckv = z;
                    if (PeerConnectionClient.this.ckB != null) {
                        PeerConnectionClient.this.ckB.setEnabled(PeerConnectionClient.this.ckv);
                    }
                }
            });
        }
    }

    public void dS(boolean z) {
        this.ckK = z;
    }

    public void dT(boolean z) {
        this.ckH = z;
    }

    public void dU(boolean z) {
        this.mHasAudio = z;
    }

    public void dV(boolean z) {
        this.ckI = z;
    }

    public void dW(boolean z) {
        this.mHasVideo = z;
    }

    public void dX(final boolean z) {
        if (this.executor.isShutdown()) {
            Log.w("PCRTCClient", "executor is already shutdown");
        } else {
            this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.2
                @Override // java.lang.Runnable
                public void run() {
                    PeerConnectionClient.this.ckS = z;
                    if (PeerConnectionClient.this.ckF != null) {
                        PeerConnectionClient.this.ckF.setEnabled(PeerConnectionClient.this.ckS);
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
                if (PeerConnectionClient.this.ckN == null || (aVar = (com.baidu.rtc.a) PeerConnectionClient.this.ckN.get(bigInteger)) == null) {
                    return;
                }
                if (aVar.ckf != null) {
                    aVar.ckf.close();
                    aVar.ckf.dispose();
                    aVar.ckf = null;
                }
                if (aVar.ckg != null) {
                    aVar.ckg.close();
                    aVar.ckg = null;
                }
                PeerConnectionClient.this.ckN.remove(bigInteger);
            }
        });
    }

    public void he(int i) {
        this.ckG = i;
    }

    public void i(final BigInteger bigInteger) {
        if (this.executor.isShutdown()) {
            Log.w("PCRTCClient", "executor is already shutdown");
        } else {
            this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.3
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.rtc.a aVar = (com.baidu.rtc.a) PeerConnectionClient.this.ckN.get(bigInteger);
                    PeerConnection peerConnection = aVar.ckf;
                    if (peerConnection == null || PeerConnectionClient.this.ckA) {
                        return;
                    }
                    Log.d("PCRTCClient", "PC Create OFFER");
                    peerConnection.createOffer(aVar.ckg, PeerConnectionClient.this.ckT);
                }
            });
        }
    }

    public com.baidu.rtc.a j(BigInteger bigInteger) {
        return this.ckN.get(bigInteger);
    }

    @Override // org.webrtc.DataChannel.Observer
    public void onBufferedAmountChange(long j) {
    }

    @Override // org.webrtc.DataChannel.Observer
    public void onMessage(DataChannel.Buffer buffer) {
        this.ckw.l(buffer.data);
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
                    if (PeerConnectionClient.this.ckq != null) {
                        PeerConnectionClient.this.ckq.setSpeakerMute(z);
                    }
                }
            });
        }
    }
}
