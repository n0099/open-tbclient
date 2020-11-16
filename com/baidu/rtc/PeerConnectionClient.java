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
/* loaded from: classes16.dex */
public class PeerConnectionClient implements DataChannel.Observer {
    private MediaConstraints ciH;
    private MediaConstraints ciI;
    private AudioSource ciJ;
    private boolean ciL;
    private b ciM;
    private PeerConnectionFactory ciN;
    private JavaAudioDeviceModule.SamplesReadyCallback ciO;
    private boolean ciQ;
    private AudioTrack ciR;
    private VideoSink ciS;
    private SurfaceTextureHelper ciT;
    private RtpSender ciU;
    private VideoTrack ciV;
    private boolean ciX;
    private JavaAudioDeviceModule.RemoteSamplesReadyCallback ciZ;
    private MediaStream cjb;
    private MediaConstraints cjc;
    private c cje;
    private String cjf;
    private VideoTrack cjh;
    private boolean cji;
    private MediaConstraints cjj;
    private Timer cjk;
    private VideoCapturer cjn;
    private boolean cjo;
    private int cjp;
    private VideoSource cjq;
    private Context context;
    private JavaAudioDeviceModule.ExternalSamplesReadyCallback externalSamplesCallback;
    private int videoHeight;
    private int videoWidth;
    PeerConnectionFactory.Options options = null;
    private Map<BigInteger, TimerTask> cjm = new ConcurrentHashMap();
    private Map<BigInteger, TimerTask> cjl = new ConcurrentHashMap();
    private boolean mHasVideo = true;
    private boolean mHasAudio = true;
    private boolean ciY = false;
    private int ciW = StreamConfig.Audio.AUDIO_RTC_FREQUENCY_48K;
    private int mAudioChannel = 1;
    private boolean ciP = true;
    private DataChannel ciK = null;
    Map<BigInteger, Integer> cjg = new ConcurrentHashMap();
    private boolean cja = false;
    private JavaAudioDeviceModule ciG = null;
    private final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
    private ConcurrentHashMap<BigInteger, com.baidu.rtc.a> cjd = new ConcurrentHashMap<>();

    /* loaded from: classes16.dex */
    public enum StatsEventsType {
        GET_AUDIOLEVEL_EVENT,
        GET_QUALITY_MONITOR_EVENT,
        GET_BWE_EVENT
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes16.dex */
    public class a implements PeerConnection.Observer {
        private PeerConnection ciu;
        private com.baidu.rtc.a cjA;

        private a() {
        }

        public void a(com.baidu.rtc.a aVar) {
            this.cjA = aVar;
            this.ciu = aVar.ciu;
        }

        @Override // org.webrtc.PeerConnection.Observer
        public void onAddStream(final MediaStream mediaStream) {
            if (PeerConnectionClient.this.executor.isShutdown()) {
                Log.w("PCRTCClient", "executor is already shutdown");
            } else {
                PeerConnectionClient.this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.a.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.ciu == null || PeerConnectionClient.this.ciQ) {
                            return;
                        }
                        Log.d("PCRTCClient", "=========== onAddStream ==========");
                        if (mediaStream.videoTracks.size() == 1) {
                            PeerConnectionClient.this.cjh = mediaStream.videoTracks.get(0);
                            PeerConnectionClient.this.cjh.setEnabled(true);
                            a.this.cjA.cix = PeerConnectionClient.this.cjh;
                            PeerConnectionClient.this.ciM.b(a.this.cjA);
                        }
                        PeerConnectionClient.this.ciM.a(mediaStream.videoTracks.size() != 0, mediaStream.audioTracks.size() != 0, a.this.cjA.cit);
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
                        PeerConnectionClient.this.ciM.a(iceCandidate, a.this.cjA.cit);
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
                        PeerConnectionClient.this.ciM.onIceCandidatesRemoved(iceCandidateArr);
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
                            PeerConnectionClient.this.ciM.adf();
                        } else if (iceConnectionState == PeerConnection.IceConnectionState.DISCONNECTED) {
                            PeerConnectionClient.this.ciM.adg();
                        } else if (iceConnectionState == PeerConnection.IceConnectionState.FAILED) {
                            PeerConnectionClient.this.ciM.adh();
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
                        PeerConnectionClient.this.cjh = null;
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

    /* loaded from: classes16.dex */
    public interface b {
        void a(Boolean bool, Boolean bool2, BigInteger bigInteger);

        void a(IceCandidate iceCandidate, BigInteger bigInteger);

        void a(SessionDescription sessionDescription, BigInteger bigInteger);

        void a(StatsReport[] statsReportArr, BigInteger bigInteger, StatsEventsType statsEventsType);

        void adf();

        void adg();

        void adh();

        void adi();

        void b(com.baidu.rtc.a aVar);

        void b(SessionDescription sessionDescription, BigInteger bigInteger);

        void jP(String str);

        void l(ByteBuffer byteBuffer);

        void onIceCandidatesRemoved(IceCandidate[] iceCandidateArr);
    }

    /* loaded from: classes16.dex */
    public static class c {
        public final String cjG;
        public final int cjH;
        public final boolean cjI;
        public final boolean cjJ;
        public final boolean cjK;
        public final boolean cjL;
        public final boolean cjM;
        public final boolean cjN;
        public final boolean cjO;
        public final boolean cjP;
        public final int cjQ;
        public final boolean cjR;
        public final boolean cjS;
        public final boolean cjT;
        public final boolean cjU;
        public final String cjV;
        public final boolean cjW;
        public final int cjX;
        public final int cjY;
        public final int cjp;
        public final int videoHeight;
        public final int videoWidth;

        public c(boolean z, int i, int i2, int i3, String str, boolean z2, int i4, String str2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, int i5, int i6, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, boolean z13, int i7) {
            this.cjT = z;
            this.videoWidth = i;
            this.videoHeight = i2;
            this.cjp = i3;
            this.cjV = str;
            this.cjW = z2;
            this.cjH = i4;
            this.cjG = str2;
            this.cjS = z3;
            this.cjU = z4;
            this.cjJ = z5;
            this.cjK = z6;
            this.cjL = z7;
            this.cjX = i5;
            this.cjY = i6;
            this.cjR = z8;
            this.cjI = z9;
            this.cjM = z10;
            this.cjN = z11;
            this.cjP = z12;
            this.cjO = z13;
            this.cjQ = i7;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class d implements SdpObserver {
        private c cis;
        private BigInteger cit;
        private PeerConnection ciu;
        private d civ;
        private boolean ciw;
        private SessionDescription cjZ;

        d() {
        }

        public void a(com.baidu.rtc.a aVar) {
            this.ciu = aVar.ciu;
            this.civ = aVar.civ;
            this.cit = aVar.cit;
            this.ciw = aVar.ciw;
            this.cis = aVar.cis;
        }

        public void close() {
            this.ciu = null;
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
            this.cjZ = sessionDescription2;
            if (PeerConnectionClient.this.executor.isShutdown()) {
                Log.w("PCRTCClient", "executor is already shutdown");
            } else {
                PeerConnectionClient.this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.d.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (d.this.ciu == null || PeerConnectionClient.this.ciQ) {
                            return;
                        }
                        Log.d("PCRTCClient", "Set local SDP from " + sessionDescription2.type);
                        d.this.ciu.setLocalDescription(d.this.civ, sessionDescription2);
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
                        if (d.this.ciu == null || PeerConnectionClient.this.ciQ) {
                            return;
                        }
                        if (d.this.ciw) {
                            if (d.this.ciu.getRemoteDescription() != null) {
                                Log.d("PCRTCClient", "Remote SDP set succesfully");
                                return;
                            }
                            Log.d("PCRTCClient", "Local SDP set succesfully");
                            PeerConnectionClient.this.ciM.a(d.this.cjZ, d.this.cit);
                        } else if (d.this.ciu.getLocalDescription() == null) {
                            Log.d("PCRTCClient", "answer Remote SDP set succesfully");
                        } else {
                            Log.d("PCRTCClient", "answer Local SDP set succesfully");
                            PeerConnectionClient.this.ciM.b(d.this.cjZ, d.this.cit);
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
        PeerConnection createPeerConnection = this.ciN.createPeerConnection(arrayList, aVar);
        com.baidu.rtc.a aVar2 = new com.baidu.rtc.a();
        aVar2.cit = bigInteger;
        aVar2.civ = dVar;
        aVar2.ciu = createPeerConnection;
        aVar2.ciw = z;
        aVar2.ciy = -1;
        aVar2.cis = this.cje;
        this.cjd.put(bigInteger, aVar2);
        aVar.a(aVar2);
        dVar.a(aVar2);
        DataChannel.Init init = new DataChannel.Init();
        if (this.ciY && z) {
            this.ciK = createPeerConnection.createDataChannel("JanusDataChannel", init);
        }
        Log.d("PCRTCClient", "Peer connection created.");
        return createPeerConnection;
    }

    private VideoTrack a(EglBase.Context context, VideoCapturer videoCapturer) {
        this.cjq = this.ciN.createVideoSource(false);
        this.ciT = SurfaceTextureHelper.create("video renderer", context);
        videoCapturer.initialize(this.ciT, this.context, this.cjq.getCapturerObserver());
        videoCapturer.startCapture(this.videoWidth, this.videoHeight, this.cjp);
        this.ciV = this.ciN.createVideoTrack("ARDAMSv0", this.cjq);
        this.ciV.setEnabled(this.cji);
        this.ciV.addSink(this.ciS);
        return this.ciV;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(PeerConnectionClient peerConnectionClient, Integer num) {
        if (peerConnectionClient.ciU == null) {
            return;
        }
        Log.d("PCRTCClient", "Requested max video bitrate: " + num);
        if (peerConnectionClient.ciU == null) {
            Log.w("PCRTCClient", "Sender is not ready.");
            return;
        }
        RtpParameters parameters = peerConnectionClient.ciU.getParameters();
        if (parameters.encodings.size() == 0) {
            Log.w("PCRTCClient", "RtpParameters are not ready.");
            return;
        }
        for (RtpParameters.Encoding encoding : parameters.encodings) {
            encoding.maxBitrateBps = num == null ? null : Integer.valueOf(num.intValue() * 1000);
        }
        if (!peerConnectionClient.ciU.setParameters(parameters)) {
            Log.e("PCRTCClient", "RtpSender.setParameters failed.");
        }
        Log.d("PCRTCClient", "Configured max video bitrate to: " + num);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final BigInteger bigInteger, final StatsEventsType statsEventsType) {
        if (this.cjd.get(bigInteger).ciu.getStats(new StatsObserver() { // from class: com.baidu.rtc.PeerConnectionClient.14
            @Override // org.webrtc.StatsObserver
            public void onComplete(StatsReport[] statsReportArr) {
                PeerConnectionClient.this.ciM.a(statsReportArr, bigInteger, statsEventsType);
            }
        }, null)) {
            return;
        }
        Log.e("PCRTCClient", "getStats() returns false!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(EglBase.Context context, BigInteger bigInteger) {
        if (this.ciN == null || this.ciQ) {
            Log.e("PCRTCClient", "Peerconnection factory is not created");
            return;
        }
        Log.d("PCRTCClient", "PCConstraints: " + this.cjc.toString());
        Log.d("PCRTCClient", "EGLContext: " + context);
        PeerConnection a2 = a(bigInteger, true);
        this.cjb = this.ciN.createLocalMediaStream("ARDAMS");
        if (this.mHasVideo) {
            this.cjb.addTrack(a(context, this.cjn));
        }
        if (this.mHasAudio) {
            this.cjb.addTrack(ada());
        }
        a2.addStream(this.cjb);
        g(bigInteger);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aX(Context context) {
        boolean z = false;
        if (this.cje.cjT) {
            PeerConnectionFactory.startInternalTracingCapture(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "webrtc-trace.txt");
        }
        Log.d("PCRTCClient", "Create peer connection factory. Use video: true");
        this.ciQ = false;
        this.cjf = "VP8";
        if (this.cje.cjV != null) {
            if (this.cje.cjV.equals("VP9")) {
                this.cjf = "VP9";
            } else if (this.cje.cjV.equals("H264")) {
                this.cjf = "H264";
            }
        }
        Log.d("PCRTCClient", "Pereferred video codec: " + this.cjf);
        if (this.cje.cjU) {
            Log.d("PCRTCClient", "Allow OpenSL ES audio if device supports it");
            WebRtcAudioManager.setBlacklistDeviceForOpenSLESUsage(false);
        } else {
            Log.d("PCRTCClient", "Disable OpenSL ES audio even if device supports it");
            WebRtcAudioManager.setBlacklistDeviceForOpenSLESUsage(true);
        }
        if (this.cje.cjJ) {
            Log.d("PCRTCClient", "Disable built-in AEC even if device supports it");
            WebRtcAudioUtils.setWebRtcBasedAcousticEchoCanceler(true);
        } else {
            Log.d("PCRTCClient", "Enable built-in AEC if device supports it");
            WebRtcAudioUtils.setWebRtcBasedAcousticEchoCanceler(false);
        }
        if (this.cje.cjK) {
            Log.d("PCRTCClient", "Disable built-in AGC even if device supports it");
            WebRtcAudioUtils.setWebRtcBasedAutomaticGainControl(true);
        } else {
            Log.d("PCRTCClient", "Enable built-in AGC if device supports it");
            WebRtcAudioUtils.setWebRtcBasedAutomaticGainControl(false);
        }
        if (this.cje.cjL) {
            Log.d("PCRTCClient", "Disable built-in NS even if device supports it");
            WebRtcAudioUtils.setWebRtcBasedNoiseSuppressor(true);
        } else {
            Log.d("PCRTCClient", "Enable built-in NS if device supports it");
            WebRtcAudioUtils.setWebRtcBasedNoiseSuppressor(false);
        }
        this.context = context;
        this.ciH = new MediaConstraints();
        this.ciH.mandatory.add(new MediaConstraints.KeyValuePair("OfferToReceiveAudio", "true"));
        this.ciH.mandatory.add(new MediaConstraints.KeyValuePair("OfferToReceiveVideo", "true"));
        String str = this.cje.cjM ? "WebRTC-FlexFEC-03-Advertised/Enabled/WebRTC-FlexFEC-03/Enabled/" : "";
        if (this.cje.cjN) {
            str = str + "BRTC.Fixed.Resolution/Enabled/";
        }
        if (this.cje.cjQ == 0 || this.cje.cjQ == 1 || this.cje.cjQ == 2) {
            str = str + "BRTC-Encoder-BitrateMode/" + this.cje.cjQ + "/";
        }
        boolean z2 = this.cje.cjO;
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
        if (this.cje.cjP || z) {
            str = str + "BRTC.Required.Resolustion.Aligment32/Enabled/";
        }
        PeerConnectionFactory.initialize(PeerConnectionFactory.InitializationOptions.builder(context).setFieldTrials(str).createInitializationOptions());
        AudioDeviceModule add = add();
        this.ciG = (JavaAudioDeviceModule) add;
        this.ciN = PeerConnectionFactory.builder().setAudioDeviceModule(add).setVideoDecoderFactory(MediaCodecVideoDecoder.createFactory()).setVideoEncoderFactory(MediaCodecVideoEncoder.createFactory()).createPeerConnectionFactory();
        Log.d("PCRTCClient", "Peer connection factory created.");
        add.release();
        if (!this.cja) {
            Logging.enableLogToDebugOutput(Logging.Severity.LS_ERROR);
            return;
        }
        Logging.enableLogThreads();
        Logging.enableLogTimeStamps();
        Logging.enableLogToDebugOutput(Logging.Severity.LS_VERBOSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void acZ() {
        Log.d("PCRTCClient", "Closing peer connection.");
        this.cjk.cancel();
        if (this.cjd != null) {
            int size = this.cjd.size();
            for (int i = 0; i < size; i++) {
                com.baidu.rtc.a aVar = (com.baidu.rtc.a) this.cjd.values().toArray()[i];
                aVar.ciu.close();
                aVar.ciu.dispose();
                aVar.ciu = null;
                aVar.civ.close();
            }
        }
        Log.d("PCRTCClient", "Closing audio source.");
        if (this.ciJ != null) {
            this.ciJ.dispose();
            this.ciJ = null;
        }
        Log.d("PCRTCClient", "Stopping capture.");
        if (this.cjn != null) {
            try {
                this.cjn.stopCapture();
                this.cjo = true;
                this.cjn.dispose();
                this.cjn = null;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        Log.d("PCRTCClient", "Closing video source.");
        if (this.cjq != null) {
            this.cjq.dispose();
            this.cjq = null;
        }
        if (this.ciT != null) {
            this.ciT.dispose();
            this.ciT = null;
        }
        Log.d("PCRTCClient", "Closing peer connection factory.");
        if (this.ciN != null) {
            this.ciN.dispose();
            this.ciN = null;
        }
        this.options = null;
        Log.d("PCRTCClient", "Closing peer connection done.");
        this.ciM.adi();
        PeerConnectionFactory.stopInternalTracingCapture();
        PeerConnectionFactory.shutdownInternalTracer();
    }

    private AudioTrack ada() {
        this.ciJ = this.ciN.createAudioSource(this.ciI);
        this.ciR = this.ciN.createAudioTrack("ARDAMSa0", this.ciJ);
        this.ciR.setEnabled(this.ciL);
        return this.ciR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adb() {
        this.cjc = new MediaConstraints();
        this.cjc.optional.add(new MediaConstraints.KeyValuePair("DtlsSrtpKeyAgreement", "true"));
        this.videoWidth = this.cje.videoWidth;
        this.videoHeight = this.cje.videoHeight;
        this.cjp = this.cje.cjp;
        if (this.videoWidth == 0 || this.videoHeight == 0) {
            this.videoWidth = PlatformPlugin.DEFAULT_SYSTEM_UI;
            this.videoHeight = 720;
        }
        if (this.cjp == 0) {
            this.cjp = 30;
        }
        Logging.d("PCRTCClient", "Capturing format: " + this.videoWidth + "x" + this.videoHeight + UgcConstant.AT_RULE_TAG + this.cjp);
        this.ciI = new MediaConstraints();
        if (this.cje.cjS) {
            Log.d("PCRTCClient", "Disabling audio processing");
            this.ciI.mandatory.add(new MediaConstraints.KeyValuePair("googEchoCancellation", "false"));
            this.ciI.mandatory.add(new MediaConstraints.KeyValuePair("googAutoGainControl", "false"));
            this.ciI.mandatory.add(new MediaConstraints.KeyValuePair("googHighpassFilter", "false"));
            this.ciI.mandatory.add(new MediaConstraints.KeyValuePair("googNoiseSuppression", "false"));
        }
        this.cjj = new MediaConstraints();
        if (this.mHasAudio) {
            this.cjj.mandatory.add(new MediaConstraints.KeyValuePair("OfferToReceiveAudio", "true"));
        }
        if (this.mHasVideo) {
            this.cjj.mandatory.add(new MediaConstraints.KeyValuePair("OfferToReceiveVideo", "true"));
        }
        if (this.ciY) {
            this.cjj.mandatory.add(new MediaConstraints.KeyValuePair("data", "true"));
        }
    }

    public static PeerConnectionClient adc() {
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
        for (RtpSender rtpSender : this.cjd.get(bigInteger).ciu.getSenders()) {
            if (rtpSender.track() != null && rtpSender.track().kind().equals("video")) {
                Log.d("PCRTCClient", "Found video sender.");
                this.ciU = rtpSender;
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
                    if (PeerConnectionClient.this.ciQ) {
                        return;
                    }
                    PeerConnectionClient.this.ciM.jP(str);
                    PeerConnectionClient.this.ciQ = true;
                }
            });
        }
    }

    public void a(final Context context, c cVar, b bVar) {
        this.cje = cVar;
        this.ciM = bVar;
        this.context = null;
        this.ciN = null;
        this.cjo = false;
        this.ciQ = false;
        this.cjb = null;
        this.cjn = null;
        this.cji = !cVar.cjI;
        this.ciV = null;
        this.cjh = null;
        this.ciU = null;
        this.ciL = !cVar.cjR;
        this.ciR = null;
        this.cjk = new Timer();
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
                    PeerConnection peerConnection = ((com.baidu.rtc.a) PeerConnectionClient.this.cjd.get(bigInteger)).ciu;
                    d dVar = ((com.baidu.rtc.a) PeerConnectionClient.this.cjd.get(bigInteger)).civ;
                    if (peerConnection == null || PeerConnectionClient.this.ciQ) {
                        return;
                    }
                    peerConnection.setRemoteDescription(dVar, new SessionDescription(sessionDescription.type, sessionDescription.description));
                }
            });
        }
    }

    public void a(final EglBase.Context context, VideoSink videoSink, VideoCapturer videoCapturer, final BigInteger bigInteger) {
        if (this.cje == null) {
            Log.e("PCRTCClient", "Creating peer connection without initializing factory.");
            return;
        }
        this.ciS = videoSink;
        this.cjn = videoCapturer;
        if (this.executor.isShutdown()) {
            Log.w("PCRTCClient", "executor is already shutdown");
        } else {
            this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.8
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        PeerConnectionClient.this.adb();
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
        this.ciZ = remoteSamplesReadyCallback;
    }

    public void a(JavaAudioDeviceModule.SamplesReadyCallback samplesReadyCallback) {
        this.ciO = samplesReadyCallback;
    }

    public void a(boolean z, int i, final BigInteger bigInteger, final StatsEventsType statsEventsType) {
        TimerTask timerTask = null;
        if (!z) {
            if (statsEventsType == StatsEventsType.GET_AUDIOLEVEL_EVENT) {
                timerTask = this.cjm.get(bigInteger);
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
                timerTask = this.cjm.get(bigInteger);
            } else if (statsEventsType == StatsEventsType.GET_QUALITY_MONITOR_EVENT) {
                this.cjl.get(bigInteger);
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
                this.cjm.put(bigInteger, timerTask2);
            } else if (statsEventsType == StatsEventsType.GET_QUALITY_MONITOR_EVENT) {
                this.cjl.put(bigInteger, timerTask2);
            }
            this.cjk.schedule(timerTask2, 0L, i);
        } catch (Exception e) {
            Log.e("PCRTCClient", "Can not schedule statistics timer", e);
        }
    }

    AudioDeviceModule add() {
        AudioDeviceModule createAudioDeviceModule = JavaAudioDeviceModule.builder(this.context).setSamplesReadyCallback(this.ciO).setRemoteSamplesReadyCallback(this.ciZ).setExternalAudioRecord(this.ciX).setUseHardwareAcousticEchoCanceler(!this.cje.cjJ).setUseHardwareNoiseSuppressor(true).setAudioRecordErrorCallback(new JavaAudioDeviceModule.AudioRecordErrorCallback() { // from class: com.baidu.rtc.PeerConnectionClient.11
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
        }).setSampleRate(this.ciW).setUseStereoInput(this.mAudioChannel > 1).setUseStereoOutput(this.mAudioChannel > 1).createAudioDeviceModule();
        if (this.ciX && (createAudioDeviceModule instanceof JavaAudioDeviceModule)) {
            this.externalSamplesCallback = ((JavaAudioDeviceModule) createAudioDeviceModule).getExternalSamplesReadyCallback();
        }
        return createAudioDeviceModule;
    }

    public void ade() {
        if (this.executor.isShutdown()) {
            Log.w("PCRTCClient", "executor is already shutdown");
        } else {
            this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.6
                @Override // java.lang.Runnable
                public void run() {
                    if (PeerConnectionClient.this.cjn == null || PeerConnectionClient.this.cjo) {
                        return;
                    }
                    Log.d("PCRTCClient", "Stop video source.");
                    try {
                        PeerConnectionClient.this.cjn.stopCapture();
                    } catch (InterruptedException e) {
                    }
                    PeerConnectionClient.this.cjo = true;
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
                    d dVar = ((com.baidu.rtc.a) PeerConnectionClient.this.cjd.get(bigInteger)).civ;
                    if (a2 == null || PeerConnectionClient.this.ciQ) {
                        return;
                    }
                    a2.setRemoteDescription(dVar, sessionDescription);
                    Log.d("PCRTCClient", "PC create ANSWER");
                    a2.createAnswer(((com.baidu.rtc.a) PeerConnectionClient.this.cjd.get(bigInteger)).civ, PeerConnectionClient.this.ciH);
                }
            });
        }
    }

    public void close() {
        this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.10
            @Override // java.lang.Runnable
            public void run() {
                PeerConnectionClient.this.acZ();
            }
        });
        try {
            this.executor.shutdown();
            this.executor.awaitTermination(200L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
        }
    }

    public void dT(final boolean z) {
        if (this.executor.isShutdown()) {
            Log.w("PCRTCClient", "executor is already shutdown");
        } else {
            this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.16
                @Override // java.lang.Runnable
                public void run() {
                    PeerConnectionClient.this.ciL = z;
                    if (PeerConnectionClient.this.ciR != null) {
                        PeerConnectionClient.this.ciR.setEnabled(PeerConnectionClient.this.ciL);
                    }
                }
            });
        }
    }

    public void dU(boolean z) {
        this.cja = z;
    }

    public void dV(boolean z) {
        this.ciX = z;
    }

    public void dW(boolean z) {
        this.mHasAudio = z;
    }

    public void dX(boolean z) {
        this.ciY = z;
    }

    public void dY(boolean z) {
        this.mHasVideo = z;
    }

    public void dZ(final boolean z) {
        if (this.executor.isShutdown()) {
            Log.w("PCRTCClient", "executor is already shutdown");
        } else {
            this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.2
                @Override // java.lang.Runnable
                public void run() {
                    PeerConnectionClient.this.cji = z;
                    if (PeerConnectionClient.this.ciV != null) {
                        PeerConnectionClient.this.ciV.setEnabled(PeerConnectionClient.this.cji);
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
                if (PeerConnectionClient.this.cjd == null || (aVar = (com.baidu.rtc.a) PeerConnectionClient.this.cjd.get(bigInteger)) == null) {
                    return;
                }
                if (aVar.ciu != null) {
                    aVar.ciu.close();
                    aVar.ciu.dispose();
                    aVar.ciu = null;
                }
                if (aVar.civ != null) {
                    aVar.civ.close();
                    aVar.civ = null;
                }
                PeerConnectionClient.this.cjd.remove(bigInteger);
            }
        });
    }

    public void ha(int i) {
        this.ciW = i;
    }

    public void i(final BigInteger bigInteger) {
        if (this.executor.isShutdown()) {
            Log.w("PCRTCClient", "executor is already shutdown");
        } else {
            this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.3
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.rtc.a aVar = (com.baidu.rtc.a) PeerConnectionClient.this.cjd.get(bigInteger);
                    PeerConnection peerConnection = aVar.ciu;
                    if (peerConnection == null || PeerConnectionClient.this.ciQ) {
                        return;
                    }
                    Log.d("PCRTCClient", "PC Create OFFER");
                    peerConnection.createOffer(aVar.civ, PeerConnectionClient.this.cjj);
                }
            });
        }
    }

    public com.baidu.rtc.a j(BigInteger bigInteger) {
        return this.cjd.get(bigInteger);
    }

    @Override // org.webrtc.DataChannel.Observer
    public void onBufferedAmountChange(long j) {
    }

    @Override // org.webrtc.DataChannel.Observer
    public void onMessage(DataChannel.Buffer buffer) {
        this.ciM.l(buffer.data);
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
                    if (PeerConnectionClient.this.ciG != null) {
                        PeerConnectionClient.this.ciG.setSpeakerMute(z);
                    }
                }
            });
        }
    }
}
