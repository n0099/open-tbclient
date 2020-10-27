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
    private MediaConstraints ceE;
    private MediaConstraints ceF;
    private AudioSource ceG;
    private boolean ceI;
    private b ceJ;
    private PeerConnectionFactory ceK;
    private JavaAudioDeviceModule.SamplesReadyCallback ceL;
    private boolean ceN;
    private AudioTrack ceO;
    private VideoSink ceP;
    private SurfaceTextureHelper ceQ;
    private RtpSender ceR;
    private VideoTrack ceS;
    private boolean ceU;
    private JavaAudioDeviceModule.RemoteSamplesReadyCallback ceW;
    private MediaStream ceY;
    private MediaConstraints ceZ;
    private c cfb;
    private String cfc;
    private VideoTrack cfe;
    private boolean cff;
    private MediaConstraints cfg;
    private Timer cfh;
    private VideoCapturer cfk;
    private boolean cfl;
    private int cfm;
    private VideoSource cfn;
    private Context context;
    private JavaAudioDeviceModule.ExternalSamplesReadyCallback externalSamplesCallback;
    private int videoHeight;
    private int videoWidth;
    PeerConnectionFactory.Options options = null;
    private Map<BigInteger, TimerTask> cfj = new ConcurrentHashMap();
    private Map<BigInteger, TimerTask> cfi = new ConcurrentHashMap();
    private boolean mHasVideo = true;
    private boolean mHasAudio = true;
    private boolean ceV = false;
    private int ceT = StreamConfig.Audio.AUDIO_RTC_FREQUENCY_48K;
    private int mAudioChannel = 1;
    private boolean ceM = true;
    private DataChannel ceH = null;
    Map<BigInteger, Integer> cfd = new ConcurrentHashMap();
    private boolean ceX = false;
    private final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
    private ConcurrentHashMap<BigInteger, com.baidu.rtc.a> cfa = new ConcurrentHashMap<>();

    /* loaded from: classes9.dex */
    public enum StatsEventsType {
        GET_AUDIOLEVEL_EVENT,
        GET_QUALITY_MONITOR_EVENT,
        GET_BWE_EVENT
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a implements PeerConnection.Observer {
        private PeerConnection cet;
        private com.baidu.rtc.a cfw;

        private a() {
        }

        public void a(com.baidu.rtc.a aVar) {
            this.cfw = aVar;
            this.cet = aVar.cet;
        }

        @Override // org.webrtc.PeerConnection.Observer
        public void onAddStream(final MediaStream mediaStream) {
            PeerConnectionClient.this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.a.4
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.cet == null || PeerConnectionClient.this.ceN) {
                        return;
                    }
                    Log.d("PCRTCClient", "=========== onAddStream ==========");
                    if (mediaStream.videoTracks.size() == 1) {
                        PeerConnectionClient.this.cfe = mediaStream.videoTracks.get(0);
                        PeerConnectionClient.this.cfe.setEnabled(true);
                        a.this.cfw.cew = PeerConnectionClient.this.cfe;
                        PeerConnectionClient.this.ceJ.b(a.this.cfw);
                    }
                    PeerConnectionClient.this.ceJ.a(mediaStream.videoTracks.size() != 0, mediaStream.audioTracks.size() != 0, a.this.cfw.ces);
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
                    PeerConnectionClient.this.ceJ.a(iceCandidate, a.this.cfw.ces);
                }
            });
        }

        @Override // org.webrtc.PeerConnection.Observer
        public void onIceCandidatesRemoved(final IceCandidate[] iceCandidateArr) {
            PeerConnectionClient.this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.a.2
                @Override // java.lang.Runnable
                public void run() {
                    PeerConnectionClient.this.ceJ.onIceCandidatesRemoved(iceCandidateArr);
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
                        PeerConnectionClient.this.ceJ.abo();
                    } else if (iceConnectionState == PeerConnection.IceConnectionState.DISCONNECTED) {
                        PeerConnectionClient.this.ceJ.abp();
                    } else if (iceConnectionState == PeerConnection.IceConnectionState.FAILED) {
                        PeerConnectionClient.this.ceJ.abq();
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
                    PeerConnectionClient.this.cfe = null;
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
        void a(Boolean bool, Boolean bool2, BigInteger bigInteger);

        void a(IceCandidate iceCandidate, BigInteger bigInteger);

        void a(SessionDescription sessionDescription, BigInteger bigInteger);

        void a(StatsReport[] statsReportArr, BigInteger bigInteger, StatsEventsType statsEventsType);

        void abo();

        void abp();

        void abq();

        void abr();

        void b(com.baidu.rtc.a aVar);

        void b(SessionDescription sessionDescription, BigInteger bigInteger);

        void jH(String str);

        void l(ByteBuffer byteBuffer);

        void onIceCandidatesRemoved(IceCandidate[] iceCandidateArr);
    }

    /* loaded from: classes9.dex */
    public static class c {
        public final String cfC;
        public final int cfD;
        public final boolean cfE;
        public final boolean cfF;
        public final boolean cfG;
        public final boolean cfH;
        public final boolean cfI;
        public final boolean cfJ;
        public final boolean cfK;
        public final boolean cfL;
        public final boolean cfM;
        public final boolean cfN;
        public final boolean cfO;
        public final boolean cfP;
        public final String cfQ;
        public final boolean cfR;
        public final int cfS;
        public final int cfT;
        public final int cfm;
        public final int videoHeight;
        public final int videoWidth;

        public c(boolean z, int i, int i2, int i3, String str, boolean z2, int i4, String str2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, int i5, int i6, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, boolean z13) {
            this.cfO = z;
            this.videoWidth = i;
            this.videoHeight = i2;
            this.cfm = i3;
            this.cfQ = str;
            this.cfR = z2;
            this.cfD = i4;
            this.cfC = str2;
            this.cfN = z3;
            this.cfP = z4;
            this.cfF = z5;
            this.cfG = z6;
            this.cfH = z7;
            this.cfS = i5;
            this.cfT = i6;
            this.cfM = z8;
            this.cfE = z9;
            this.cfI = z10;
            this.cfJ = z11;
            this.cfL = z12;
            this.cfK = z13;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class d implements SdpObserver {
        private BigInteger ces;
        private PeerConnection cet;
        private d ceu;
        private boolean cev;
        private SessionDescription cfU;

        d() {
        }

        public void a(com.baidu.rtc.a aVar) {
            this.cet = aVar.cet;
            this.ceu = aVar.ceu;
            this.ces = aVar.ces;
            this.cev = aVar.cev;
        }

        public void close() {
            this.cet = null;
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
            this.cfU = sessionDescription2;
            PeerConnectionClient.this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.d.1
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.cet == null || PeerConnectionClient.this.ceN) {
                        return;
                    }
                    Log.d("PCRTCClient", "Set local SDP from " + sessionDescription2.type);
                    d.this.cet.setLocalDescription(d.this.ceu, sessionDescription2);
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
                    if (d.this.cet == null || PeerConnectionClient.this.ceN) {
                        return;
                    }
                    if (d.this.cev) {
                        if (d.this.cet.getRemoteDescription() != null) {
                            Log.d("PCRTCClient", "Remote SDP set succesfully");
                            return;
                        }
                        Log.d("PCRTCClient", "Local SDP set succesfully");
                        PeerConnectionClient.this.ceJ.a(d.this.cfU, d.this.ces);
                    } else if (d.this.cet.getLocalDescription() == null) {
                        Log.d("PCRTCClient", "answer Remote SDP set succesfully");
                    } else {
                        Log.d("PCRTCClient", "answer Local SDP set succesfully");
                        PeerConnectionClient.this.ceJ.b(d.this.cfU, d.this.ces);
                    }
                }
            });
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
        PeerConnection createPeerConnection = this.ceK.createPeerConnection(arrayList, aVar);
        com.baidu.rtc.a aVar2 = new com.baidu.rtc.a();
        aVar2.ces = bigInteger;
        aVar2.ceu = dVar;
        aVar2.cet = createPeerConnection;
        aVar2.cev = z;
        aVar2.cex = -1;
        this.cfa.put(bigInteger, aVar2);
        aVar.a(aVar2);
        dVar.a(aVar2);
        DataChannel.Init init = new DataChannel.Init();
        if (this.ceV && z) {
            this.ceH = createPeerConnection.createDataChannel("JanusDataChannel", init);
        }
        Log.d("PCRTCClient", "Peer connection created.");
        return createPeerConnection;
    }

    private VideoTrack a(EglBase.Context context, VideoCapturer videoCapturer) {
        this.cfn = this.ceK.createVideoSource(false);
        this.ceQ = SurfaceTextureHelper.create("video renderer", context);
        videoCapturer.initialize(this.ceQ, this.context, this.cfn.getCapturerObserver());
        videoCapturer.startCapture(this.videoWidth, this.videoHeight, this.cfm);
        this.ceS = this.ceK.createVideoTrack("ARDAMSv0", this.cfn);
        this.ceS.setEnabled(this.cff);
        this.ceS.addSink(this.ceP);
        return this.ceS;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(PeerConnectionClient peerConnectionClient, Integer num) {
        if (peerConnectionClient.ceR == null) {
            return;
        }
        Log.d("PCRTCClient", "Requested max video bitrate: " + num);
        if (peerConnectionClient.ceR == null) {
            Log.w("PCRTCClient", "Sender is not ready.");
            return;
        }
        RtpParameters parameters = peerConnectionClient.ceR.getParameters();
        if (parameters.encodings.size() == 0) {
            Log.w("PCRTCClient", "RtpParameters are not ready.");
            return;
        }
        for (RtpParameters.Encoding encoding : parameters.encodings) {
            encoding.maxBitrateBps = num == null ? null : Integer.valueOf(num.intValue() * 1000);
        }
        if (!peerConnectionClient.ceR.setParameters(parameters)) {
            Log.e("PCRTCClient", "RtpSender.setParameters failed.");
        }
        Log.d("PCRTCClient", "Configured max video bitrate to: " + num);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final BigInteger bigInteger, final StatsEventsType statsEventsType) {
        if (this.cfa.get(bigInteger).cet.getStats(new StatsObserver() { // from class: com.baidu.rtc.PeerConnectionClient.11
            @Override // org.webrtc.StatsObserver
            public void onComplete(StatsReport[] statsReportArr) {
                PeerConnectionClient.this.ceJ.a(statsReportArr, bigInteger, statsEventsType);
            }
        }, null)) {
            return;
        }
        Log.e("PCRTCClient", "getStats() returns false!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(EglBase.Context context, BigInteger bigInteger) {
        if (this.ceK == null || this.ceN) {
            Log.e("PCRTCClient", "Peerconnection factory is not created");
            return;
        }
        Log.d("PCRTCClient", "PCConstraints: " + this.ceZ.toString());
        Log.d("PCRTCClient", "EGLContext: " + context);
        PeerConnection a2 = a(bigInteger, true);
        this.ceY = this.ceK.createLocalMediaStream("ARDAMS");
        if (this.mHasVideo) {
            this.ceY.addTrack(a(context, this.cfk));
        }
        if (this.mHasAudio) {
            this.ceY.addTrack(abj());
        }
        a2.addStream(this.ceY);
        f(bigInteger);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aX(Context context) {
        boolean z = false;
        if (this.cfb.cfO) {
            PeerConnectionFactory.startInternalTracingCapture(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "webrtc-trace.txt");
        }
        Log.d("PCRTCClient", "Create peer connection factory. Use video: true");
        this.ceN = false;
        this.cfc = "VP8";
        if (this.cfb.cfQ != null) {
            if (this.cfb.cfQ.equals("VP9")) {
                this.cfc = "VP9";
            } else if (this.cfb.cfQ.equals("H264")) {
                this.cfc = "H264";
            }
        }
        Log.d("PCRTCClient", "Pereferred video codec: " + this.cfc);
        if (this.cfb.cfP) {
            Log.d("PCRTCClient", "Allow OpenSL ES audio if device supports it");
            WebRtcAudioManager.setBlacklistDeviceForOpenSLESUsage(false);
        } else {
            Log.d("PCRTCClient", "Disable OpenSL ES audio even if device supports it");
            WebRtcAudioManager.setBlacklistDeviceForOpenSLESUsage(true);
        }
        if (this.cfb.cfF) {
            Log.d("PCRTCClient", "Disable built-in AEC even if device supports it");
            WebRtcAudioUtils.setWebRtcBasedAcousticEchoCanceler(true);
        } else {
            Log.d("PCRTCClient", "Enable built-in AEC if device supports it");
            WebRtcAudioUtils.setWebRtcBasedAcousticEchoCanceler(false);
        }
        if (this.cfb.cfG) {
            Log.d("PCRTCClient", "Disable built-in AGC even if device supports it");
            WebRtcAudioUtils.setWebRtcBasedAutomaticGainControl(true);
        } else {
            Log.d("PCRTCClient", "Enable built-in AGC if device supports it");
            WebRtcAudioUtils.setWebRtcBasedAutomaticGainControl(false);
        }
        if (this.cfb.cfH) {
            Log.d("PCRTCClient", "Disable built-in NS even if device supports it");
            WebRtcAudioUtils.setWebRtcBasedNoiseSuppressor(true);
        } else {
            Log.d("PCRTCClient", "Enable built-in NS if device supports it");
            WebRtcAudioUtils.setWebRtcBasedNoiseSuppressor(false);
        }
        this.context = context;
        this.ceE = new MediaConstraints();
        this.ceE.mandatory.add(new MediaConstraints.KeyValuePair("OfferToReceiveAudio", "true"));
        this.ceE.mandatory.add(new MediaConstraints.KeyValuePair("OfferToReceiveVideo", "true"));
        String str = this.cfb.cfI ? "WebRTC-FlexFEC-03-Advertised/Enabled/WebRTC-FlexFEC-03/Enabled/" : "";
        if (this.cfb.cfJ) {
            str = str + "BRTC.Fixed.Resolution/Enabled/";
        }
        boolean z2 = this.cfb.cfK;
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
        if (this.cfb.cfL || z) {
            str = str + "BRTC.Required.Resolustion.Aligment32/Enabled/";
        }
        PeerConnectionFactory.initialize(PeerConnectionFactory.InitializationOptions.builder(context).setFieldTrials(str).createInitializationOptions());
        AudioDeviceModule abm = abm();
        this.ceK = PeerConnectionFactory.builder().setAudioDeviceModule(abm).setVideoDecoderFactory(MediaCodecVideoDecoder.createFactory()).setVideoEncoderFactory(MediaCodecVideoEncoder.createFactory()).createPeerConnectionFactory();
        Log.d("PCRTCClient", "Peer connection factory created.");
        abm.release();
        if (!this.ceX) {
            Logging.enableLogToDebugOutput(Logging.Severity.LS_ERROR);
            return;
        }
        Logging.enableLogThreads();
        Logging.enableLogTimeStamps();
        Logging.enableLogToDebugOutput(Logging.Severity.LS_VERBOSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abi() {
        Log.d("PCRTCClient", "Closing peer connection.");
        this.cfh.cancel();
        if (this.cfa != null) {
            int size = this.cfa.size();
            for (int i = 0; i < size; i++) {
                com.baidu.rtc.a aVar = (com.baidu.rtc.a) this.cfa.values().toArray()[i];
                aVar.cet.close();
                aVar.cet.dispose();
                aVar.cet = null;
                aVar.ceu.close();
            }
        }
        Log.d("PCRTCClient", "Closing audio source.");
        if (this.ceG != null) {
            this.ceG.dispose();
            this.ceG = null;
        }
        Log.d("PCRTCClient", "Stopping capture.");
        if (this.cfk != null) {
            try {
                this.cfk.stopCapture();
                this.cfl = true;
                this.cfk.dispose();
                this.cfk = null;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        Log.d("PCRTCClient", "Closing video source.");
        if (this.cfn != null) {
            this.cfn.dispose();
            this.cfn = null;
        }
        if (this.ceQ != null) {
            this.ceQ.dispose();
            this.ceQ = null;
        }
        Log.d("PCRTCClient", "Closing peer connection factory.");
        if (this.ceK != null) {
            this.ceK.dispose();
            this.ceK = null;
        }
        this.options = null;
        Log.d("PCRTCClient", "Closing peer connection done.");
        this.ceJ.abr();
        PeerConnectionFactory.stopInternalTracingCapture();
        PeerConnectionFactory.shutdownInternalTracer();
    }

    private AudioTrack abj() {
        this.ceG = this.ceK.createAudioSource(this.ceF);
        this.ceO = this.ceK.createAudioTrack("ARDAMSa0", this.ceG);
        this.ceO.setEnabled(this.ceI);
        return this.ceO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abk() {
        this.ceZ = new MediaConstraints();
        this.ceZ.optional.add(new MediaConstraints.KeyValuePair("DtlsSrtpKeyAgreement", "true"));
        this.videoWidth = this.cfb.videoWidth;
        this.videoHeight = this.cfb.videoHeight;
        this.cfm = this.cfb.cfm;
        if (this.videoWidth == 0 || this.videoHeight == 0) {
            this.videoWidth = PlatformPlugin.DEFAULT_SYSTEM_UI;
            this.videoHeight = 720;
        }
        if (this.cfm == 0) {
            this.cfm = 30;
        }
        Logging.d("PCRTCClient", "Capturing format: " + this.videoWidth + "x" + this.videoHeight + UgcConstant.AT_RULE_TAG + this.cfm);
        this.ceF = new MediaConstraints();
        if (this.cfb.cfN) {
            Log.d("PCRTCClient", "Disabling audio processing");
            this.ceF.mandatory.add(new MediaConstraints.KeyValuePair("googEchoCancellation", "false"));
            this.ceF.mandatory.add(new MediaConstraints.KeyValuePair("googAutoGainControl", "false"));
            this.ceF.mandatory.add(new MediaConstraints.KeyValuePair("googHighpassFilter", "false"));
            this.ceF.mandatory.add(new MediaConstraints.KeyValuePair("googNoiseSuppression", "false"));
        }
        this.cfg = new MediaConstraints();
        if (this.mHasAudio) {
            this.cfg.mandatory.add(new MediaConstraints.KeyValuePair("OfferToReceiveAudio", "true"));
        }
        if (this.mHasVideo) {
            this.cfg.mandatory.add(new MediaConstraints.KeyValuePair("OfferToReceiveVideo", "true"));
        }
        if (this.ceV) {
            this.cfg.mandatory.add(new MediaConstraints.KeyValuePair("data", "true"));
        }
    }

    public static PeerConnectionClient abl() {
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

    private void f(BigInteger bigInteger) {
        for (RtpSender rtpSender : this.cfa.get(bigInteger).cet.getSenders()) {
            if (rtpSender.track() != null && rtpSender.track().kind().equals("video")) {
                Log.d("PCRTCClient", "Found video sender.");
                this.ceR = rtpSender;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportError(final String str) {
        Log.e("PCRTCClient", "Peerconnection error: " + str);
        this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.6
            @Override // java.lang.Runnable
            public void run() {
                if (PeerConnectionClient.this.ceN) {
                    return;
                }
                PeerConnectionClient.this.ceJ.jH(str);
                PeerConnectionClient.this.ceN = true;
            }
        });
    }

    public void a(final Context context, c cVar, b bVar) {
        this.cfb = cVar;
        this.ceJ = bVar;
        this.context = null;
        this.ceK = null;
        this.cfl = false;
        this.ceN = false;
        this.ceY = null;
        this.cfk = null;
        this.cff = !cVar.cfE;
        this.ceS = null;
        this.cfe = null;
        this.ceR = null;
        this.ceI = !cVar.cfM;
        this.ceO = null;
        this.cfh = new Timer();
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
                PeerConnection peerConnection = ((com.baidu.rtc.a) PeerConnectionClient.this.cfa.get(bigInteger)).cet;
                d dVar = ((com.baidu.rtc.a) PeerConnectionClient.this.cfa.get(bigInteger)).ceu;
                if (peerConnection == null || PeerConnectionClient.this.ceN) {
                    return;
                }
                peerConnection.setRemoteDescription(dVar, sessionDescription);
            }
        });
    }

    public void a(final EglBase.Context context, VideoSink videoSink, VideoCapturer videoCapturer, final BigInteger bigInteger) {
        if (this.cfb == null) {
            Log.e("PCRTCClient", "Creating peer connection without initializing factory.");
            return;
        }
        this.ceP = videoSink;
        this.cfk = videoCapturer;
        this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    PeerConnectionClient.this.abk();
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
        this.ceW = remoteSamplesReadyCallback;
    }

    public void a(JavaAudioDeviceModule.SamplesReadyCallback samplesReadyCallback) {
        this.ceL = samplesReadyCallback;
    }

    public void a(boolean z, int i, final BigInteger bigInteger, final StatsEventsType statsEventsType) {
        TimerTask timerTask = null;
        if (!z) {
            if (statsEventsType == StatsEventsType.GET_AUDIOLEVEL_EVENT) {
                timerTask = this.cfj.get(bigInteger);
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
                timerTask = this.cfj.get(bigInteger);
            } else if (statsEventsType == StatsEventsType.GET_QUALITY_MONITOR_EVENT) {
                this.cfi.get(bigInteger);
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
                this.cfj.put(bigInteger, timerTask2);
            } else if (statsEventsType == StatsEventsType.GET_QUALITY_MONITOR_EVENT) {
                this.cfi.put(bigInteger, timerTask2);
            }
            this.cfh.schedule(timerTask2, 0L, i);
        } catch (Exception e) {
            Log.e("PCRTCClient", "Can not schedule statistics timer", e);
        }
    }

    AudioDeviceModule abm() {
        AudioDeviceModule createAudioDeviceModule = JavaAudioDeviceModule.builder(this.context).setSamplesReadyCallback(this.ceL).setRemoteSamplesReadyCallback(this.ceW).setExternalAudioRecord(this.ceU).setUseHardwareAcousticEchoCanceler(true).setUseHardwareNoiseSuppressor(true).setAudioRecordErrorCallback(new JavaAudioDeviceModule.AudioRecordErrorCallback() { // from class: com.baidu.rtc.PeerConnectionClient.9
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
        }).setSampleRate(this.ceT).setUseStereoInput(this.mAudioChannel > 1).setUseStereoOutput(this.mAudioChannel > 1).createAudioDeviceModule();
        if (this.ceU && (createAudioDeviceModule instanceof JavaAudioDeviceModule)) {
            this.externalSamplesCallback = ((JavaAudioDeviceModule) createAudioDeviceModule).getExternalSamplesReadyCallback();
        }
        return createAudioDeviceModule;
    }

    public void abn() {
        this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.5
            @Override // java.lang.Runnable
            public void run() {
                if (PeerConnectionClient.this.cfk == null || PeerConnectionClient.this.cfl) {
                    return;
                }
                Log.d("PCRTCClient", "Stop video source.");
                try {
                    PeerConnectionClient.this.cfk.stopCapture();
                } catch (InterruptedException e) {
                }
                PeerConnectionClient.this.cfl = true;
            }
        });
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
                d dVar = ((com.baidu.rtc.a) PeerConnectionClient.this.cfa.get(bigInteger)).ceu;
                if (a2 == null || PeerConnectionClient.this.ceN) {
                    return;
                }
                a2.setRemoteDescription(dVar, sessionDescription);
                Log.d("PCRTCClient", "PC create ANSWER");
                a2.createAnswer(((com.baidu.rtc.a) PeerConnectionClient.this.cfa.get(bigInteger)).ceu, PeerConnectionClient.this.ceE);
            }
        });
    }

    public void close() {
        this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.8
            @Override // java.lang.Runnable
            public void run() {
                PeerConnectionClient.this.abi();
            }
        });
        try {
            this.executor.shutdown();
            this.executor.awaitTermination(200L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
        }
    }

    public void dJ(final boolean z) {
        this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.13
            @Override // java.lang.Runnable
            public void run() {
                PeerConnectionClient.this.ceI = z;
                if (PeerConnectionClient.this.ceO != null) {
                    PeerConnectionClient.this.ceO.setEnabled(PeerConnectionClient.this.ceI);
                }
            }
        });
    }

    public void dK(boolean z) {
        this.ceX = z;
    }

    public void dL(boolean z) {
        this.ceU = z;
    }

    public void dM(boolean z) {
        this.mHasAudio = z;
    }

    public void dN(boolean z) {
        this.ceV = z;
    }

    public void dO(boolean z) {
        this.mHasVideo = z;
    }

    public void dP(final boolean z) {
        this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.14
            @Override // java.lang.Runnable
            public void run() {
                PeerConnectionClient.this.cff = z;
                if (PeerConnectionClient.this.ceS != null) {
                    PeerConnectionClient.this.ceS.setEnabled(PeerConnectionClient.this.cff);
                }
            }
        });
    }

    public void g(final BigInteger bigInteger) {
        this.executor.execute(new Runnable() { // from class: com.baidu.rtc.PeerConnectionClient.2
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.rtc.a aVar = (com.baidu.rtc.a) PeerConnectionClient.this.cfa.get(bigInteger);
                PeerConnection peerConnection = aVar.cet;
                if (peerConnection == null || PeerConnectionClient.this.ceN) {
                    return;
                }
                Log.d("PCRTCClient", "PC Create OFFER");
                peerConnection.createOffer(aVar.ceu, PeerConnectionClient.this.cfg);
            }
        });
    }

    public void gU(int i) {
        this.ceT = i;
    }

    public com.baidu.rtc.a h(BigInteger bigInteger) {
        return this.cfa.get(bigInteger);
    }

    @Override // org.webrtc.DataChannel.Observer
    public void onBufferedAmountChange(long j) {
    }

    @Override // org.webrtc.DataChannel.Observer
    public void onMessage(DataChannel.Buffer buffer) {
        this.ceJ.l(buffer.data);
    }

    @Override // org.webrtc.DataChannel.Observer
    public void onStateChange() {
    }

    public void setAudioChannel(int i) {
        this.mAudioChannel = i;
    }
}
