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
    private MediaConstraints bWA;
    private c bWC;
    private String bWD;
    private VideoTrack bWF;
    private boolean bWG;
    private MediaConstraints bWH;
    private Timer bWI;
    private VideoCapturer bWL;
    private boolean bWM;
    private int bWN;
    private VideoSource bWO;
    private MediaConstraints bWf;
    private MediaConstraints bWg;
    private AudioSource bWh;
    private boolean bWj;
    private b bWk;
    private PeerConnectionFactory bWl;
    private JavaAudioDeviceModule.SamplesReadyCallback bWm;
    private boolean bWo;
    private AudioTrack bWp;
    private VideoSink bWq;
    private SurfaceTextureHelper bWr;
    private RtpSender bWs;
    private VideoTrack bWt;
    private boolean bWv;
    private JavaAudioDeviceModule.RemoteSamplesReadyCallback bWx;
    private MediaStream bWz;
    private Context context;
    private JavaAudioDeviceModule.ExternalSamplesReadyCallback externalSamplesCallback;
    private int videoHeight;
    private int videoWidth;
    PeerConnectionFactory.Options options = null;
    private Map<BigInteger, TimerTask> bWK = new ConcurrentHashMap();
    private Map<BigInteger, TimerTask> bWJ = new ConcurrentHashMap();
    private boolean mHasVideo = true;
    private boolean mHasAudio = true;
    private boolean bWw = false;
    private int bWu = StreamConfig.Audio.AUDIO_RTC_FREQUENCY_48K;
    private int mAudioChannel = 1;
    private boolean bWn = true;
    private DataChannel bWi = null;
    Map<BigInteger, Integer> bWE = new ConcurrentHashMap();
    private boolean bWy = false;
    private final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
    private ConcurrentHashMap<BigInteger, com.baidu.rtc.a> bWB = new ConcurrentHashMap<>();

    /* loaded from: classes9.dex */
    public enum StatsEventsType {
        GET_AUDIOLEVEL_EVENT,
        GET_QUALITY_MONITOR_EVENT,
        GET_BWE_EVENT
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a implements PeerConnection.Observer {
        private PeerConnection bVU;
        private com.baidu.rtc.a bWX;

        private a() {
        }

        public void a(com.baidu.rtc.a aVar) {
            this.bWX = aVar;
            this.bVU = aVar.bVU;
        }

        @Override // org.webrtc.PeerConnection.Observer
        public void onAddStream(final MediaStream mediaStream) {
            PeerConnectionClient.this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.a.4
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.bVU == null || PeerConnectionClient.this.bWo) {
                        return;
                    }
                    Log.d("PCRTCClient", "=========== onAddStream ==========");
                    if (mediaStream.videoTracks.size() == 1) {
                        PeerConnectionClient.this.bWF = mediaStream.videoTracks.get(0);
                        PeerConnectionClient.this.bWF.setEnabled(true);
                        a.this.bWX.bVX = PeerConnectionClient.this.bWF;
                        PeerConnectionClient.this.bWk.b(a.this.bWX);
                    }
                    PeerConnectionClient.this.bWk.a(mediaStream.videoTracks.size() != 0, mediaStream.audioTracks.size() != 0, a.this.bWX.bVT);
                }
            });
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
            PeerConnectionClient.this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.a.1
                @Override // java.lang.Runnable
                public void run() {
                    PeerConnectionClient.this.bWk.a(iceCandidate, a.this.bWX.bVT);
                }
            });
        }

        @Override // org.webrtc.PeerConnection.Observer
        public void onIceCandidatesRemoved(final IceCandidate[] iceCandidateArr) {
            PeerConnectionClient.this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.a.2
                @Override // java.lang.Runnable
                public void run() {
                    PeerConnectionClient.this.bWk.onIceCandidatesRemoved(iceCandidateArr);
                }
            });
        }

        @Override // org.webrtc.PeerConnection.Observer
        public void onIceConnectionChange(final PeerConnection.IceConnectionState iceConnectionState) {
            if (PeerConnectionClient.this.executor.isShutdown()) {
                return;
            }
            PeerConnectionClient.this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.a.3
                @Override // java.lang.Runnable
                public void run() {
                    Log.d("PCRTCClient", "IceConnectionState: " + iceConnectionState);
                    if (iceConnectionState == PeerConnection.IceConnectionState.CONNECTED) {
                        PeerConnectionClient.this.bWk.Zv();
                    } else if (iceConnectionState == PeerConnection.IceConnectionState.DISCONNECTED) {
                        PeerConnectionClient.this.bWk.Zw();
                    } else if (iceConnectionState == PeerConnection.IceConnectionState.FAILED) {
                        PeerConnectionClient.this.bWk.Zx();
                    }
                }
            });
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
            PeerConnectionClient.this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.a.5
                @Override // java.lang.Runnable
                public void run() {
                    PeerConnectionClient.this.bWF = null;
                }
            });
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
        void Zv();

        void Zw();

        void Zx();

        void Zy();

        void a(Boolean bool, Boolean bool2, BigInteger bigInteger);

        void a(IceCandidate iceCandidate, BigInteger bigInteger);

        void a(SessionDescription sessionDescription, BigInteger bigInteger);

        void a(StatsReport[] statsReportArr, BigInteger bigInteger, StatsEventsType statsEventsType);

        void b(com.baidu.rtc.a aVar);

        void b(SessionDescription sessionDescription, BigInteger bigInteger);

        void jo(String str);

        void m(ByteBuffer byteBuffer);

        void onIceCandidatesRemoved(IceCandidate[] iceCandidateArr);
    }

    /* loaded from: classes9.dex */
    public static class c {
        public final int bWN;
        public final String bXd;
        public final int bXe;
        public final boolean bXf;
        public final boolean bXg;
        public final boolean bXh;
        public final boolean bXi;
        public final boolean bXj;
        public final boolean bXk;
        public final boolean bXl;
        public final boolean bXm;
        public final boolean bXn;
        public final boolean bXo;
        public final boolean bXp;
        public final boolean bXq;
        public final String bXr;
        public final boolean bXs;
        public final int bXt;
        public final int bXu;
        public final int videoHeight;
        public final int videoWidth;

        public c(boolean z, int i, int i2, int i3, String str, boolean z2, int i4, String str2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, int i5, int i6, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, boolean z13) {
            this.bXp = z;
            this.videoWidth = i;
            this.videoHeight = i2;
            this.bWN = i3;
            this.bXr = str;
            this.bXs = z2;
            this.bXe = i4;
            this.bXd = str2;
            this.bXo = z3;
            this.bXq = z4;
            this.bXg = z5;
            this.bXh = z6;
            this.bXi = z7;
            this.bXt = i5;
            this.bXu = i6;
            this.bXn = z8;
            this.bXf = z9;
            this.bXj = z10;
            this.bXk = z11;
            this.bXm = z12;
            this.bXl = z13;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class d implements SdpObserver {
        private BigInteger bVT;
        private PeerConnection bVU;
        private d bVV;
        private boolean bVW;
        private SessionDescription bXv;

        d() {
        }

        public void a(com.baidu.rtc.a aVar) {
            this.bVU = aVar.bVU;
            this.bVV = aVar.bVV;
            this.bVT = aVar.bVT;
            this.bVW = aVar.bVW;
        }

        public void close() {
            this.bVU = null;
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
            this.bXv = sessionDescription2;
            PeerConnectionClient.this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.d.1
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.bVU == null || PeerConnectionClient.this.bWo) {
                        return;
                    }
                    Log.d("PCRTCClient", "Set local SDP from " + sessionDescription2.type);
                    d.this.bVU.setLocalDescription(d.this.bVV, sessionDescription2);
                }
            });
        }

        @Override // org.webrtc.SdpObserver
        public void onSetFailure(String str) {
            PeerConnectionClient peerConnectionClient = PeerConnectionClient.this;
            peerConnectionClient.reportError("setSDP error: " + str);
        }

        @Override // org.webrtc.SdpObserver
        public void onSetSuccess() {
            PeerConnectionClient.this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.d.2
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.bVU == null || PeerConnectionClient.this.bWo) {
                        return;
                    }
                    if (d.this.bVW) {
                        if (d.this.bVU.getRemoteDescription() != null) {
                            Log.d("PCRTCClient", "Remote SDP set succesfully");
                            return;
                        }
                        Log.d("PCRTCClient", "Local SDP set succesfully");
                        PeerConnectionClient.this.bWk.a(d.this.bXv, d.this.bVT);
                    } else if (d.this.bVU.getLocalDescription() == null) {
                        Log.d("PCRTCClient", "answer Remote SDP set succesfully");
                    } else {
                        Log.d("PCRTCClient", "answer Local SDP set succesfully");
                        PeerConnectionClient.this.bWk.b(d.this.bXv, d.this.bVT);
                    }
                }
            });
        }
    }

    private PeerConnectionClient() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zp() {
        Log.d("PCRTCClient", "Closing peer connection.");
        this.bWI.cancel();
        if (this.bWB != null) {
            int size = this.bWB.size();
            for (int i = 0; i < size; i++) {
                com.baidu.rtc.a aVar = (com.baidu.rtc.a) this.bWB.values().toArray()[i];
                aVar.bVU.close();
                aVar.bVU.dispose();
                aVar.bVU = null;
                aVar.bVV.close();
            }
        }
        Log.d("PCRTCClient", "Closing audio source.");
        if (this.bWh != null) {
            this.bWh.dispose();
            this.bWh = null;
        }
        Log.d("PCRTCClient", "Stopping capture.");
        if (this.bWL != null) {
            try {
                this.bWL.stopCapture();
                this.bWM = true;
                this.bWL.dispose();
                this.bWL = null;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        Log.d("PCRTCClient", "Closing video source.");
        if (this.bWO != null) {
            this.bWO.dispose();
            this.bWO = null;
        }
        if (this.bWr != null) {
            this.bWr.dispose();
            this.bWr = null;
        }
        Log.d("PCRTCClient", "Closing peer connection factory.");
        if (this.bWl != null) {
            this.bWl.dispose();
            this.bWl = null;
        }
        this.options = null;
        Log.d("PCRTCClient", "Closing peer connection done.");
        this.bWk.Zy();
        PeerConnectionFactory.stopInternalTracingCapture();
        PeerConnectionFactory.shutdownInternalTracer();
    }

    private AudioTrack Zq() {
        this.bWh = this.bWl.createAudioSource(this.bWg);
        this.bWp = this.bWl.createAudioTrack("ARDAMSa0", this.bWh);
        this.bWp.setEnabled(this.bWj);
        return this.bWp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zr() {
        this.bWA = new MediaConstraints();
        this.bWA.optional.add(new MediaConstraints.KeyValuePair("DtlsSrtpKeyAgreement", "true"));
        this.videoWidth = this.bWC.videoWidth;
        this.videoHeight = this.bWC.videoHeight;
        this.bWN = this.bWC.bWN;
        if (this.videoWidth == 0 || this.videoHeight == 0) {
            this.videoWidth = PlatformPlugin.DEFAULT_SYSTEM_UI;
            this.videoHeight = 720;
        }
        if (this.bWN == 0) {
            this.bWN = 30;
        }
        Logging.d("PCRTCClient", "Capturing format: " + this.videoWidth + "x" + this.videoHeight + UgcConstant.AT_RULE_TAG + this.bWN);
        this.bWg = new MediaConstraints();
        if (this.bWC.bXo) {
            Log.d("PCRTCClient", "Disabling audio processing");
            this.bWg.mandatory.add(new MediaConstraints.KeyValuePair("googEchoCancellation", "false"));
            this.bWg.mandatory.add(new MediaConstraints.KeyValuePair("googAutoGainControl", "false"));
            this.bWg.mandatory.add(new MediaConstraints.KeyValuePair("googHighpassFilter", "false"));
            this.bWg.mandatory.add(new MediaConstraints.KeyValuePair("googNoiseSuppression", "false"));
        }
        this.bWH = new MediaConstraints();
        if (this.mHasAudio) {
            this.bWH.mandatory.add(new MediaConstraints.KeyValuePair("OfferToReceiveAudio", "true"));
        }
        if (this.mHasVideo) {
            this.bWH.mandatory.add(new MediaConstraints.KeyValuePair("OfferToReceiveVideo", "true"));
        }
        if (this.bWw) {
            this.bWH.mandatory.add(new MediaConstraints.KeyValuePair("data", "true"));
        }
    }

    public static PeerConnectionClient Zs() {
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
    public PeerConnection a(BigInteger bigInteger, boolean z) {
        Log.d("PCRTCClient", "Create peer connection.");
        ArrayList arrayList = new ArrayList();
        PeerConnection.IceServer.builder("stun:180.149.142.139:3478").createIceServer();
        new PeerConnection.RTCConfiguration(arrayList);
        a aVar = new a();
        d dVar = new d();
        PeerConnection createPeerConnection = this.bWl.createPeerConnection(arrayList, aVar);
        com.baidu.rtc.a aVar2 = new com.baidu.rtc.a();
        aVar2.bVT = bigInteger;
        aVar2.bVV = dVar;
        aVar2.bVU = createPeerConnection;
        aVar2.bVW = z;
        aVar2.bVY = -1;
        this.bWB.put(bigInteger, aVar2);
        aVar.a(aVar2);
        dVar.a(aVar2);
        DataChannel.Init init = new DataChannel.Init();
        if (this.bWw && z) {
            this.bWi = createPeerConnection.createDataChannel("JanusDataChannel", init);
        }
        Log.d("PCRTCClient", "Peer connection created.");
        return createPeerConnection;
    }

    private VideoTrack a(EglBase.Context context, VideoCapturer videoCapturer) {
        this.bWO = this.bWl.createVideoSource(false);
        this.bWr = SurfaceTextureHelper.create("video renderer", context);
        videoCapturer.initialize(this.bWr, this.context, this.bWO.getCapturerObserver());
        videoCapturer.startCapture(this.videoWidth, this.videoHeight, this.bWN);
        this.bWt = this.bWl.createVideoTrack("ARDAMSv0", this.bWO);
        this.bWt.setEnabled(this.bWG);
        this.bWt.addSink(this.bWq);
        return this.bWt;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(PeerConnectionClient peerConnectionClient, Integer num) {
        if (peerConnectionClient.bWs == null) {
            return;
        }
        Log.d("PCRTCClient", "Requested max video bitrate: " + num);
        if (peerConnectionClient.bWs == null) {
            Log.w("PCRTCClient", "Sender is not ready.");
            return;
        }
        RtpParameters parameters = peerConnectionClient.bWs.getParameters();
        if (parameters.encodings.size() == 0) {
            Log.w("PCRTCClient", "RtpParameters are not ready.");
            return;
        }
        for (RtpParameters.Encoding encoding : parameters.encodings) {
            encoding.maxBitrateBps = num == null ? null : Integer.valueOf(num.intValue() * 1000);
        }
        if (!peerConnectionClient.bWs.setParameters(parameters)) {
            Log.e("PCRTCClient", "RtpSender.setParameters failed.");
        }
        Log.d("PCRTCClient", "Configured max video bitrate to: " + num);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final BigInteger bigInteger, final StatsEventsType statsEventsType) {
        if (this.bWB.get(bigInteger).bVU.getStats(new StatsObserver() { // from class: com.baidu.rtc.PeerConnectionClient.11
            @Override // org.webrtc.StatsObserver
            public void onComplete(StatsReport[] statsReportArr) {
                PeerConnectionClient.this.bWk.a(statsReportArr, bigInteger, statsEventsType);
            }
        }, null)) {
            return;
        }
        Log.e("PCRTCClient", "getStats() returns false!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(EglBase.Context context, BigInteger bigInteger) {
        if (this.bWl == null || this.bWo) {
            Log.e("PCRTCClient", "Peerconnection factory is not created");
            return;
        }
        Log.d("PCRTCClient", "PCConstraints: " + this.bWA.toString());
        Log.d("PCRTCClient", "EGLContext: " + context);
        PeerConnection a2 = a(bigInteger, true);
        this.bWz = this.bWl.createLocalMediaStream("ARDAMS");
        if (this.mHasVideo) {
            this.bWz.addTrack(a(context, this.bWL));
        }
        if (this.mHasAudio) {
            this.bWz.addTrack(Zq());
        }
        a2.addStream(this.bWz);
        f(bigInteger);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aX(Context context) {
        boolean z = false;
        if (this.bWC.bXp) {
            PeerConnectionFactory.startInternalTracingCapture(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "webrtc-trace.txt");
        }
        Log.d("PCRTCClient", "Create peer connection factory. Use video: true");
        this.bWo = false;
        this.bWD = "VP8";
        if (this.bWC.bXr != null) {
            if (this.bWC.bXr.equals("VP9")) {
                this.bWD = "VP9";
            } else if (this.bWC.bXr.equals("H264")) {
                this.bWD = "H264";
            }
        }
        Log.d("PCRTCClient", "Pereferred video codec: " + this.bWD);
        if (this.bWC.bXq) {
            Log.d("PCRTCClient", "Allow OpenSL ES audio if device supports it");
            WebRtcAudioManager.setBlacklistDeviceForOpenSLESUsage(false);
        } else {
            Log.d("PCRTCClient", "Disable OpenSL ES audio even if device supports it");
            WebRtcAudioManager.setBlacklistDeviceForOpenSLESUsage(true);
        }
        if (this.bWC.bXg) {
            Log.d("PCRTCClient", "Disable built-in AEC even if device supports it");
            WebRtcAudioUtils.setWebRtcBasedAcousticEchoCanceler(true);
        } else {
            Log.d("PCRTCClient", "Enable built-in AEC if device supports it");
            WebRtcAudioUtils.setWebRtcBasedAcousticEchoCanceler(false);
        }
        if (this.bWC.bXh) {
            Log.d("PCRTCClient", "Disable built-in AGC even if device supports it");
            WebRtcAudioUtils.setWebRtcBasedAutomaticGainControl(true);
        } else {
            Log.d("PCRTCClient", "Enable built-in AGC if device supports it");
            WebRtcAudioUtils.setWebRtcBasedAutomaticGainControl(false);
        }
        if (this.bWC.bXi) {
            Log.d("PCRTCClient", "Disable built-in NS even if device supports it");
            WebRtcAudioUtils.setWebRtcBasedNoiseSuppressor(true);
        } else {
            Log.d("PCRTCClient", "Enable built-in NS if device supports it");
            WebRtcAudioUtils.setWebRtcBasedNoiseSuppressor(false);
        }
        this.context = context;
        this.bWf = new MediaConstraints();
        this.bWf.mandatory.add(new MediaConstraints.KeyValuePair("OfferToReceiveAudio", "true"));
        this.bWf.mandatory.add(new MediaConstraints.KeyValuePair("OfferToReceiveVideo", "true"));
        String str = this.bWC.bXj ? "WebRTC-FlexFEC-03-Advertised/Enabled/WebRTC-FlexFEC-03/Enabled/" : "";
        if (this.bWC.bXk) {
            str = str + "BRTC.Fixed.Resolution/Enabled/";
        }
        boolean z2 = this.bWC.bXl;
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
        if (this.bWC.bXm || z) {
            str = str + "BRTC.Required.Resolustion.Aligment32/Enabled/";
        }
        PeerConnectionFactory.initialize(PeerConnectionFactory.InitializationOptions.builder(context).setFieldTrials(str).createInitializationOptions());
        AudioDeviceModule Zt = Zt();
        this.bWl = PeerConnectionFactory.builder().setAudioDeviceModule(Zt).setVideoDecoderFactory(MediaCodecVideoDecoder.createFactory()).setVideoEncoderFactory(MediaCodecVideoEncoder.createFactory()).createPeerConnectionFactory();
        Log.d("PCRTCClient", "Peer connection factory created.");
        Zt.release();
        if (!this.bWy) {
            Logging.enableLogToDebugOutput(Logging.Severity.LS_ERROR);
            return;
        }
        Logging.enableLogThreads();
        Logging.enableLogTimeStamps();
        Logging.enableLogToDebugOutput(Logging.Severity.LS_VERBOSE);
    }

    private void f(BigInteger bigInteger) {
        for (RtpSender rtpSender : this.bWB.get(bigInteger).bVU.getSenders()) {
            if (rtpSender.track() != null && rtpSender.track().kind().equals("video")) {
                Log.d("PCRTCClient", "Found video sender.");
                this.bWs = rtpSender;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportError(final String str) {
        Log.e("PCRTCClient", "Peerconnection error: " + str);
        this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.6
            @Override // java.lang.Runnable
            public void run() {
                if (PeerConnectionClient.this.bWo) {
                    return;
                }
                PeerConnectionClient.this.bWk.jo(str);
                PeerConnectionClient.this.bWo = true;
            }
        });
    }

    AudioDeviceModule Zt() {
        AudioDeviceModule createAudioDeviceModule = JavaAudioDeviceModule.builder(this.context).setSamplesReadyCallback(this.bWm).setRemoteSamplesReadyCallback(this.bWx).setExternalAudioRecord(this.bWv).setUseHardwareAcousticEchoCanceler(true).setUseHardwareNoiseSuppressor(true).setAudioRecordErrorCallback(new JavaAudioDeviceModule.AudioRecordErrorCallback() { // from class: com.baidu.rtc.PeerConnectionClient.9
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
        }).setAudioTrackErrorCallback(new JavaAudioDeviceModule.AudioTrackErrorCallback() { // from class: com.baidu.rtc.PeerConnectionClient.10
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
        }).setSampleRate(this.bWu).setUseStereoInput(this.mAudioChannel > 1).setUseStereoOutput(this.mAudioChannel > 1).createAudioDeviceModule();
        if (this.bWv && (createAudioDeviceModule instanceof JavaAudioDeviceModule)) {
            this.externalSamplesCallback = ((JavaAudioDeviceModule) createAudioDeviceModule).getExternalSamplesReadyCallback();
        }
        return createAudioDeviceModule;
    }

    public void Zu() {
        this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.5
            @Override // java.lang.Runnable
            public void run() {
                if (PeerConnectionClient.this.bWL == null || PeerConnectionClient.this.bWM) {
                    return;
                }
                Log.d("PCRTCClient", "Stop video source.");
                try {
                    PeerConnectionClient.this.bWL.stopCapture();
                } catch (InterruptedException e) {
                }
                PeerConnectionClient.this.bWM = true;
            }
        });
    }

    public void a(final Context context, c cVar, b bVar) {
        this.bWC = cVar;
        this.bWk = bVar;
        this.context = null;
        this.bWl = null;
        this.bWM = false;
        this.bWo = false;
        this.bWz = null;
        this.bWL = null;
        this.bWG = !cVar.bXf;
        this.bWt = null;
        this.bWF = null;
        this.bWs = null;
        this.bWj = !cVar.bXn;
        this.bWp = null;
        this.bWI = new Timer();
        this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.1
            @Override // java.lang.Runnable
            public void run() {
                PeerConnectionClient.this.aX(context);
            }
        });
    }

    public void a(final BigInteger bigInteger, final SessionDescription sessionDescription) {
        this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.3
            @Override // java.lang.Runnable
            public void run() {
                PeerConnection peerConnection = ((com.baidu.rtc.a) PeerConnectionClient.this.bWB.get(bigInteger)).bVU;
                d dVar = ((com.baidu.rtc.a) PeerConnectionClient.this.bWB.get(bigInteger)).bVV;
                if (peerConnection == null || PeerConnectionClient.this.bWo) {
                    return;
                }
                peerConnection.setRemoteDescription(dVar, sessionDescription);
            }
        });
    }

    public void a(final EglBase.Context context, VideoSink videoSink, VideoCapturer videoCapturer, final BigInteger bigInteger) {
        if (this.bWC == null) {
            Log.e("PCRTCClient", "Creating peer connection without initializing factory.");
            return;
        }
        this.bWq = videoSink;
        this.bWL = videoCapturer;
        this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    PeerConnectionClient.this.Zr();
                    PeerConnectionClient.this.a(context, bigInteger);
                } catch (Exception e) {
                    PeerConnectionClient peerConnectionClient = PeerConnectionClient.this;
                    peerConnectionClient.reportError("Failed to create peer connection: " + e.getMessage());
                    throw e;
                }
            }
        });
    }

    public void a(JavaAudioDeviceModule.RemoteSamplesReadyCallback remoteSamplesReadyCallback) {
        this.bWx = remoteSamplesReadyCallback;
    }

    public void a(JavaAudioDeviceModule.SamplesReadyCallback samplesReadyCallback) {
        this.bWm = samplesReadyCallback;
    }

    public void a(boolean z, int i, final BigInteger bigInteger, final StatsEventsType statsEventsType) {
        TimerTask timerTask = null;
        if (!z) {
            if (statsEventsType == StatsEventsType.GET_AUDIOLEVEL_EVENT) {
                timerTask = this.bWK.get(bigInteger);
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
                timerTask = this.bWK.get(bigInteger);
            } else if (statsEventsType == StatsEventsType.GET_QUALITY_MONITOR_EVENT) {
                this.bWJ.get(bigInteger);
            }
            if (timerTask != null) {
                timerTask.cancel();
            }
            TimerTask timerTask2 = new TimerTask() { // from class: com.baidu.rtc.PeerConnectionClient.12
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (PeerConnectionClient.this.executor.isShutdown()) {
                        return;
                    }
                    PeerConnectionClient.this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.12.1
                        @Override // java.lang.Runnable
                        public void run() {
                            PeerConnectionClient.this.a(bigInteger, statsEventsType);
                        }
                    });
                }
            };
            if (statsEventsType == StatsEventsType.GET_AUDIOLEVEL_EVENT) {
                this.bWK.put(bigInteger, timerTask2);
            } else if (statsEventsType == StatsEventsType.GET_QUALITY_MONITOR_EVENT) {
                this.bWJ.put(bigInteger, timerTask2);
            }
            this.bWI.schedule(timerTask2, 0L, i);
        } catch (Exception e) {
            Log.e("PCRTCClient", "Can not schedule statistics timer", e);
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
        this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.4
            @Override // java.lang.Runnable
            public void run() {
                PeerConnection a2 = PeerConnectionClient.this.a(bigInteger, false);
                d dVar = ((com.baidu.rtc.a) PeerConnectionClient.this.bWB.get(bigInteger)).bVV;
                if (a2 == null || PeerConnectionClient.this.bWo) {
                    return;
                }
                a2.setRemoteDescription(dVar, sessionDescription);
                Log.d("PCRTCClient", "PC create ANSWER");
                a2.createAnswer(((com.baidu.rtc.a) PeerConnectionClient.this.bWB.get(bigInteger)).bVV, PeerConnectionClient.this.bWf);
            }
        });
    }

    public void close() {
        this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.8
            @Override // java.lang.Runnable
            public void run() {
                PeerConnectionClient.this.Zp();
            }
        });
        try {
            this.executor.shutdown();
            this.executor.awaitTermination(200L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
        }
    }

    public void dA(boolean z) {
        this.mHasVideo = z;
    }

    public void dB(final boolean z) {
        this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.14
            @Override // java.lang.Runnable
            public void run() {
                PeerConnectionClient.this.bWG = z;
                if (PeerConnectionClient.this.bWt != null) {
                    PeerConnectionClient.this.bWt.setEnabled(PeerConnectionClient.this.bWG);
                }
            }
        });
    }

    public void dv(final boolean z) {
        this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.13
            @Override // java.lang.Runnable
            public void run() {
                PeerConnectionClient.this.bWj = z;
                if (PeerConnectionClient.this.bWp != null) {
                    PeerConnectionClient.this.bWp.setEnabled(PeerConnectionClient.this.bWj);
                }
            }
        });
    }

    public void dw(boolean z) {
        this.bWy = z;
    }

    public void dx(boolean z) {
        this.bWv = z;
    }

    public void dy(boolean z) {
        this.mHasAudio = z;
    }

    public void dz(boolean z) {
        this.bWw = z;
    }

    public void g(final BigInteger bigInteger) {
        this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.2
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.rtc.a aVar = (com.baidu.rtc.a) PeerConnectionClient.this.bWB.get(bigInteger);
                PeerConnection peerConnection = aVar.bVU;
                if (peerConnection == null || PeerConnectionClient.this.bWo) {
                    return;
                }
                Log.d("PCRTCClient", "PC Create OFFER");
                peerConnection.createOffer(aVar.bVV, PeerConnectionClient.this.bWH);
            }
        });
    }

    public void gJ(int i) {
        this.bWu = i;
    }

    public com.baidu.rtc.a h(BigInteger bigInteger) {
        return this.bWB.get(bigInteger);
    }

    @Override // org.webrtc.DataChannel.Observer
    public void onBufferedAmountChange(long j) {
    }

    @Override // org.webrtc.DataChannel.Observer
    public void onMessage(DataChannel.Buffer buffer) {
        this.bWk.m(buffer.data);
    }

    @Override // org.webrtc.DataChannel.Observer
    public void onStateChange() {
    }

    public void setAudioChannel(int i) {
        this.mAudioChannel = i;
    }
}
