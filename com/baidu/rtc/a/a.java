package com.baidu.rtc.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.media.MediaCodec;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.Surface;
import com.baidu.ala.recorder.video.AlaRecorderLog;
import com.baidu.ala.recorder.video.drawer.EncoderTextureDrawer;
import com.baidu.cloudbase.b.c;
import com.baidu.cyberplayer.sdk.rtc.RTCConst;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.mobstat.Config;
import com.baidu.rtc.BaiduRtcRoom;
import com.baidu.rtc.PeerConnectionClient;
import com.baidu.rtc.RTCVideoView;
import com.baidu.rtc.RtcParameterSettings;
import com.baidu.rtc.b.d;
import com.baidu.rtc.c;
import com.baidu.rtc.g;
import com.baidu.rtc.i;
import com.baidu.rtc.j;
import com.baidu.rtc.k;
import com.baidu.rtc.p;
import com.heytap.mcssdk.mode.CommandMessage;
import com.kwai.video.player.KsMediaMeta;
import java.io.File;
import java.lang.ref.WeakReference;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.webrtc.Camera1Enumerator;
import org.webrtc.Camera2Enumerator;
import org.webrtc.CameraEnumerator;
import org.webrtc.CameraVideoCapturer;
import org.webrtc.EglBase;
import org.webrtc.EglBase_CC;
import org.webrtc.IceCandidate;
import org.webrtc.SessionDescription;
import org.webrtc.StatsReport;
import org.webrtc.VideoCapturer;
import org.webrtc.VideoFrame;
import org.webrtc.VideoSink;
import org.webrtc.audio.JavaAudioDeviceModule;
/* loaded from: classes9.dex */
public class a extends BaiduRtcRoom implements PeerConnectionClient.b, c {
    public static boolean crX = false;
    static int cuD = -1;
    public static int cuE = 30;
    private static ConcurrentHashMap<String, String> cuF = new ConcurrentHashMap<>();
    public static int cuG = 1;
    private int cuH;
    private Boolean cuL;
    private com.baidu.cloudbase.a.a cuN;
    com.baidu.rtc.b.a cuQ;
    C0316a cuV;
    private Context cvA;
    private VideoSink cvG;
    private p cvH;
    private EglBase cvN;
    d cvO;
    private boolean cvd;
    BaiduRtcRoom.RtcLiveTransferMode cvi;
    String mAppId;
    private WeakReference<Context> mContext;
    private String mCpuType;
    String mDisplayName;
    String mRoomName;
    long mUserId;
    private boolean cva = false;
    private boolean cuZ = false;
    private boolean cuR = false;
    private volatile PeerConnectionClient cvL = null;
    private PeerConnectionClient.c csb = null;
    private RTCVideoView cvk = null;
    private RTCVideoView[] cvs = null;
    private VideoCapturer csk = null;
    private String cvf = "wss://rtc2.exp.bcelive.com/janus";
    private int cvw = 0;
    private boolean cvE = true;
    private boolean[] cuU = new boolean[cuE];
    private AudioManager audioManager = null;
    private int cvr = -1;
    BaiduRtcRoom.a cuO = null;
    g.d cvx = null;
    g.c cvt = null;
    g.b cvl = null;
    private ConcurrentHashMap<Long, j> cvD = new ConcurrentHashMap<>();
    private IdentityHashMap<Long, j> cvo = new IdentityHashMap<>();
    private boolean cvF = false;
    int cuP = cuD;
    private RtcParameterSettings cvn = new RtcParameterSettings();
    private Handler mHandler = new Handler(Looper.getMainLooper());
    BigInteger cvp = null;
    volatile long cvh = 0;
    volatile long cvg = 0;
    ConcurrentHashMap<BigInteger, BigInteger> cuS = new ConcurrentHashMap<>();
    boolean cvI = true;
    double cvK = 200.0d;
    boolean cvc = false;
    boolean cvb = false;
    String cvq = "online";
    private ConcurrentHashMap<BigInteger, com.baidu.rtc.b.b> cuT = new ConcurrentHashMap<>();
    boolean cvJ = false;
    boolean cuW = true;
    boolean cuX = true;
    boolean cuY = false;
    Boolean cuI = false;
    Boolean cuJ = false;
    String cvj = "";
    private boolean cuM = false;
    private ConcurrentHashMap<BigInteger, b> cvv = new ConcurrentHashMap<>();
    private Thread cvB = null;
    private boolean cve = false;
    private String cvC = "";
    private com.baidu.cloudbase.b.c cvz = new c.a() { // from class: com.baidu.rtc.a.a.1
        @Override // com.baidu.cloudbase.b.c
        public void T(String str, String str2) {
            Log.d("BaiduRtcRoomImp", "Be successful to download so!");
            String str3 = com.baidu.cloudbase.b.b.Z(a.this.cvA) + File.separator + "libjingle_peerconnection_so.so";
            Log.d("BaiduRtcRoomImp", "RTC so path is: " + str3);
            a.this.cve = true;
            if (com.baidu.cloudbase.b.a.aa(a.this.cvA).m17do(com.baidu.cloudbase.b.b.Z(a.this.cvA))) {
                try {
                    System.load(str3);
                    Log.d("BaiduRtcRoomImp", "loaded so, and start to login room.");
                    a.this.loginRtcRoomWithRoomName(a.this.mRoomName, a.this.mUserId, a.this.mDisplayName, a.this.cuX, a.this.cuW);
                    return;
                } catch (Throwable th) {
                    Log.d("BaiduRtcRoomImp", "Failed call System.load to load so! Error: " + th);
                    if (a.this.cuO != null) {
                        a.this.cuO.onErrorInfoUpdate(401);
                        return;
                    }
                    return;
                }
            }
            Log.d("BaiduRtcRoomImp", "call DownSoHelper.getInstance(mSoContext).loadSo() Failed.");
            Log.d("BaiduRtcRoomImp", "try call load Full Path.");
            try {
                System.load(str3);
                Log.d("BaiduRtcRoomImp", "loaded so with full path, and start to login room.");
                a.this.loginRtcRoomWithRoomName(a.this.mRoomName, a.this.mUserId, a.this.mDisplayName, a.this.cuX, a.this.cuW);
            } catch (Throwable th2) {
                Log.d("BaiduRtcRoomImp", "Failed to load so with full path! Error: " + th2);
                if (a.this.cuO != null) {
                    a.this.cuO.onErrorInfoUpdate(401);
                }
            }
        }

        @Override // com.baidu.cloudbase.b.c
        public void b(String str, int i, String str2) {
            Log.d("BaiduRtcRoomImp", "Failed to download so.");
            if (a.this.cuO != null) {
                a.this.cuO.onErrorInfoUpdate(400);
            }
        }
    };
    JavaAudioDeviceModule.SamplesReadyCallback cvy = new JavaAudioDeviceModule.SamplesReadyCallback() { // from class: com.baidu.rtc.a.a.16
        @Override // org.webrtc.audio.JavaAudioDeviceModule.SamplesReadyCallback
        public void onWebRtcAudioRecordSamplesReady(JavaAudioDeviceModule.AudioSamples audioSamples) {
            if (audioSamples == null || audioSamples.getData() == null || audioSamples.getData().length <= 0) {
                return;
            }
            if (a.this.cvx != null) {
                a.this.cvx.a(new g(audioSamples.getAudioFormat(), audioSamples.getChannelCount(), audioSamples.getSampleRate(), audioSamples.getData()));
            }
            if (!a.this.cuR || a.this.cuZ) {
                return;
            }
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            bufferInfo.size = audioSamples.getData().length;
            bufferInfo.offset = 0;
            a.this.cuN.a(ByteBuffer.wrap(audioSamples.getData()), bufferInfo);
        }
    };
    JavaAudioDeviceModule.RemoteSamplesReadyCallback cvu = new JavaAudioDeviceModule.RemoteSamplesReadyCallback() { // from class: com.baidu.rtc.a.a.17
        @Override // org.webrtc.audio.JavaAudioDeviceModule.RemoteSamplesReadyCallback
        public void onWebRtcAudioRemoteSamplesReady(JavaAudioDeviceModule.AudioSamples audioSamples) {
            if (audioSamples == null) {
                return;
            }
            if (a.this.cvt != null) {
                a.this.cvt.c(new g(audioSamples.getAudioFormat(), audioSamples.getChannelCount(), audioSamples.getSampleRate(), audioSamples.getData()));
            }
            if (!a.this.cuR || a.this.cvr < 0) {
                return;
            }
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            bufferInfo.size = audioSamples.getData().length;
            bufferInfo.offset = 0;
            a.this.cuN.a(ByteBuffer.wrap(audioSamples.getData()), bufferInfo, a.this.cvr);
        }
    };
    g.a cuK = new g.a() { // from class: com.baidu.rtc.a.a.18
    };
    private com.baidu.cloudbase.c.a cvm = new com.baidu.cloudbase.c.a() { // from class: com.baidu.rtc.a.a.19
        @Override // com.baidu.cloudbase.c.a
        public void onFilteredFrameUpdate(byte[] bArr, MediaCodec.BufferInfo bufferInfo) {
            if (a.this.cvl != null) {
                a.this.cvl.b(new g(2, a.this.cvn.AudioChannel, a.this.cvn.AudioFrequency, bArr));
            }
        }
    };
    private Runnable cvM = new Runnable() { // from class: com.baidu.rtc.a.a.13
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.cvO != null && (a.this.cvc || a.this.cvb)) {
                a.this.aeG();
            }
            a.this.mHandler.postDelayed(a.this.cvM, 300000L);
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.rtc.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C0316a extends BroadcastReceiver {
        C0316a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (a.this.audioManager == null) {
                a.this.audioManager = (AudioManager) ((Context) a.this.mContext.get()).getSystemService("audio");
            }
            String action = intent.getAction();
            if ("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED".equals(action)) {
                int intExtra = intent.getIntExtra("android.bluetooth.profile.extra.STATE", -1);
                if (intExtra != 0) {
                    if (intExtra == 2) {
                        final int s = a.s(a.this);
                        a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.rtc.a.a.a.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (s == a.this.cuH) {
                                    a.this.d((Boolean) true);
                                    a.this.a(BaiduRtcRoom.RtcSoundMode.RTC_SOUND_MODE_EAR);
                                }
                            }
                        }, 1500L);
                        Log.i("BaiduRtcRoomImp", "Bluetooth headset connected");
                        return;
                    }
                    return;
                }
                Log.i("BaiduRtcRoomImp", "Bluetooth headset not disconnected");
                a.this.d((Boolean) false);
                a.t(a.this);
                if (a.this.audioManager.isWiredHeadsetOn()) {
                    return;
                }
                a.this.a(BaiduRtcRoom.RtcSoundMode.RTC_SOUND_MODE_SPEAKER);
            } else if (!intent.getAction().equals("android.intent.action.HEADSET_PLUG") || !intent.hasExtra("state")) {
                if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(action) && intent.getIntExtra("android.bluetooth.adapter.extra.STATE", Integer.MIN_VALUE) == 10) {
                    a.t(a.this);
                    a.this.d((Boolean) false);
                    if (a.this.audioManager.isWiredHeadsetOn()) {
                        return;
                    }
                    a.this.a(BaiduRtcRoom.RtcSoundMode.RTC_SOUND_MODE_SPEAKER);
                }
            } else if (intent.getIntExtra("state", -1) == 0 && !a.this.isHeadsetOn(context)) {
                Log.i("BaiduRtcRoomImp", "headset not connected");
                a.this.a(BaiduRtcRoom.RtcSoundMode.RTC_SOUND_MODE_SPEAKER);
            } else if (intent.getIntExtra("state", -1) == 1) {
                Log.i("BaiduRtcRoomImp", "headset connected");
                a.this.a(BaiduRtcRoom.RtcSoundMode.RTC_SOUND_MODE_EAR);
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class b {
        public BigInteger crq;
        public Boolean cvY;
        public Boolean cvZ;
        public String nickName;
        public long userId;
        public int volume = -1;

        public b(BigInteger bigInteger, long j, Boolean bool, Boolean bool2, String str) {
            this.nickName = "";
            this.crq = bigInteger;
            this.userId = j;
            this.cvY = bool2;
            this.cvZ = bool;
            this.nickName = str;
        }
    }

    public a(Context context, String str, String str2, String str3, boolean z) {
        this.mContext = null;
        this.cvH = null;
        this.cvN = null;
        this.cuV = null;
        this.cvd = false;
        this.mCpuType = "armeabi-v7a";
        this.cvA = null;
        this.cvd = z;
        this.cvA = context;
        this.mContext = new WeakReference<>(context);
        this.mCpuType = str3;
        this.cvH = new p();
        this.cvH.setAppId(str);
        this.cvH.jk(str2);
        this.cvH.jj("BRTC.Android.SDK V" + version());
        this.mAppId = str;
        this.cvH.a(this);
        this.cvN = EglBase_CC.create();
        for (int i = 0; i < this.cuU.length; i++) {
            this.cuU[i] = false;
        }
        AudioManager audioManager = (AudioManager) this.mContext.get().getSystemService("audio");
        audioManager.setSpeakerphoneOn(false);
        if (this.cvc || this.cvb) {
            this.cuQ = new com.baidu.rtc.b.a(context);
            this.cvO = d.aeV();
        }
        this.cuH = 0;
        this.cuL = false;
        audioManager = audioManager == null ? (AudioManager) this.mContext.get().getSystemService("audio") : audioManager;
        this.cuV = new C0316a();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.HEADSET_PLUG");
        intentFilter.addAction("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
        intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        try {
            if (audioManager.isBluetoothScoAvailableOffCall()) {
                intentFilter.addAction("android.media.SCO_AUDIO_STATE_CHANGED");
                intentFilter.addAction("android.media.ACTION_SCO_AUDIO_STATE_UPDATED");
                if (audioManager.isBluetoothScoOn()) {
                    d((Boolean) true);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.mContext.get().registerReceiver(this.cuV, intentFilter);
        if (isHeadsetOn(this.mContext.get())) {
            return;
        }
        presetLoudSpeaker(true);
        Log.i("BaiduRtcRoomImp", "Headset No");
    }

    private VideoCapturer a(CameraEnumerator cameraEnumerator) {
        CameraVideoCapturer createCapturer;
        CameraVideoCapturer createCapturer2;
        CameraVideoCapturer createCapturer3;
        String[] deviceNames = cameraEnumerator.getDeviceNames();
        if (this.cuP == cuD || this.cuP >= deviceNames.length || (createCapturer3 = cameraEnumerator.createCapturer(deviceNames[this.cuP], null)) == null) {
            Log.d("BaiduRtcRoomImp", "Looking for front facing cameras.");
            for (String str : deviceNames) {
                if (cameraEnumerator.isFrontFacing(str)) {
                    Log.d("BaiduRtcRoomImp", "Creating front facing camera capturer.");
                    if (!cuF.containsValue(str) && (createCapturer2 = cameraEnumerator.createCapturer(str, null)) != null) {
                        cuF.put(toString(), str);
                        this.cvF = true;
                        if (this.cvk != null) {
                            this.cvk.setMirror(true);
                            return createCapturer2;
                        }
                        return createCapturer2;
                    }
                }
            }
            Log.d("BaiduRtcRoomImp", "Looking for other cameras.");
            for (String str2 : deviceNames) {
                if (!cameraEnumerator.isFrontFacing(str2)) {
                    Log.d("BaiduRtcRoomImp", "Creating other camera capturer.");
                    if (!cuF.containsValue(str2) && (createCapturer = cameraEnumerator.createCapturer(str2, null)) != null) {
                        cuF.put(toString(), str2);
                        this.cvF = false;
                        return createCapturer;
                    }
                }
            }
            return null;
        }
        return createCapturer3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(StatsReport[] statsReportArr, BigInteger bigInteger) {
        BigInteger k;
        StatsReport.Value[] valueArr;
        StatsReport.Value[] valueArr2;
        if (this.cvH == null) {
            return;
        }
        if (bigInteger == this.cvp) {
            k = BigInteger.valueOf(this.mUserId);
        } else {
            k = this.cvH.k(bigInteger);
            if (k == null) {
                return;
            }
        }
        b bVar = this.cvv.get(k);
        if (bVar == null && this.cvL != null) {
            this.cvL.a(false, 0, bigInteger, PeerConnectionClient.StatsEventsType.GET_AUDIOLEVEL_EVENT);
            return;
        }
        for (StatsReport statsReport : statsReportArr) {
            if (bigInteger == this.cvp) {
                if (statsReport.type.equals("ssrc") && statsReport.id.contains("ssrc") && statsReport.id.contains(UbcStatConstant.ContentType.UBC_TYPE_IM_SEND)) {
                    for (StatsReport.Value value : statsReport.values) {
                        if (value.name.contains("audioInputLevel")) {
                            try {
                                bVar.volume = Integer.valueOf(value.value).intValue();
                            } catch (NumberFormatException e) {
                                Log.e("BaiduRtcRoomImp", "parse string num exception: " + e);
                            }
                        }
                    }
                }
            } else if (statsReport.type.equals("ssrc") && statsReport.id.contains("ssrc") && statsReport.id.contains("recv")) {
                for (StatsReport.Value value2 : statsReport.values) {
                    if (value2.name.contains("audioOutputLevel")) {
                        try {
                            bVar.volume = Integer.valueOf(value2.value).intValue();
                        } catch (NumberFormatException e2) {
                            Log.e("BaiduRtcRoomImp", "parse string num exception: " + e2);
                        }
                    }
                }
            }
        }
    }

    private boolean aeB() {
        return !Build.MODEL.contains("SABRESD-MX6DQ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public VideoCapturer aeC() {
        VideoCapturer a2;
        if (this.csk != null) {
            return this.csk;
        }
        if (aeH()) {
            Log.d("BaiduRtcRoomImp", "Creating capturer using camera2 API.");
            a2 = a(new Camera2Enumerator(this.mContext.get()));
        } else {
            Log.d("BaiduRtcRoomImp", "Creating capturer using camera1 API.");
            a2 = a(new Camera1Enumerator(aeB()));
        }
        if (a2 == null) {
            Log.e("BaiduRtcRoomImp", "Failed to open camera");
            return null;
        }
        return a2;
    }

    private void aeD() {
        if (this.cvD.isEmpty()) {
            return;
        }
        for (Long l : this.cvD.keySet()) {
            j jVar = this.cvD.get(l);
            if (jVar != null) {
                if (jVar.getSurface() != null) {
                    jVar.releaseSurface();
                }
                jVar.release();
            }
            this.cvD.remove(l);
        }
    }

    private void aeE() {
        synchronized (this) {
            if (this.cvo.isEmpty()) {
                return;
            }
            for (j jVar : this.cvo.values()) {
                if (jVar != null) {
                    if (jVar.getSurface() != null) {
                        jVar.releaseSurface();
                    }
                    jVar.release();
                }
            }
            this.cvo.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aeF() {
        com.baidu.rtc.b.b bVar;
        if (this.cvH == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        boolean z = true;
        com.baidu.rtc.b.b bVar2 = this.cuT.get(this.cvp);
        if (bVar2 == null) {
            z = false;
        } else {
            bVar2.v(hashMap);
        }
        boolean z2 = hashMap.size() != 0 ? z : false;
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("duration", 2);
            JSONObject jSONObject3 = new JSONObject();
            if (this.cuQ != null) {
                jSONObject3.put("sysCpuUsage", this.cuQ.aeP());
            }
            jSONObject3.put("appCpuUsage", 0);
            jSONObject2.put("resourceUsageInfo", jSONObject3);
            if (this.cvc) {
                JSONObject jSONObject4 = new JSONObject();
                if (z2) {
                    jSONObject4.put(KsMediaMeta.KSM_KEY_BITRATE, hashMap.get("bitrate_s"));
                    jSONObject4.put("packetloss", hashMap.get("packetloss_s"));
                    jSONObject4.put("cfps", hashMap.get("fps_s"));
                    jSONObject4.put(AlaRecorderLog.KEY_CANERA_START_FPS, hashMap.get("fps_i"));
                    if (bVar2 == null) {
                        jSONObject4.put("resolution", "");
                    } else {
                        jSONObject4.put("resolution", bVar2.aeT());
                    }
                } else {
                    jSONObject4.put(KsMediaMeta.KSM_KEY_BITRATE, 0);
                    jSONObject4.put("packetloss", 0);
                    jSONObject4.put(AlaRecorderLog.KEY_CANERA_START_FPS, 0);
                    jSONObject4.put("resolution", "");
                }
                jSONObject2.put("senderQualityInfo", jSONObject4);
            }
            if (this.cvb) {
                JSONArray jSONArray = new JSONArray();
                for (BigInteger bigInteger : this.cuT.keySet()) {
                    if (bigInteger != this.cvp && (bVar = this.cuT.get(bigInteger)) != null) {
                        HashMap hashMap2 = new HashMap();
                        bVar.u(hashMap2);
                        if (hashMap2.size() != 0) {
                            JSONObject jSONObject5 = new JSONObject();
                            if (this.cvH != null) {
                                jSONObject5.put("feedId", this.cvH.k(bigInteger));
                            }
                            jSONObject5.put(KsMediaMeta.KSM_KEY_BITRATE, hashMap2.get("bitrate_r"));
                            jSONObject5.put("packetloss", hashMap2.get("packetloss_r"));
                            jSONObject5.put(AlaRecorderLog.KEY_CANERA_START_FPS, hashMap2.get("fps_r"));
                            jSONObject5.put("resolution", bVar.aeS());
                            jSONArray.put(jSONObject5);
                        }
                    }
                }
                jSONObject2.put("receiverQualityInfoList", jSONArray);
            }
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put("communicationQualityInfo", jSONObject2);
            jSONObject.put("env", this.cvq);
            jSONObject.put("appId", this.mAppId);
            if (this.cvH != null) {
                jSONObject.put("roomId", this.cvH.getRoomId());
            }
            jSONObject.put("timestamp", System.currentTimeMillis());
            jSONObject.put(TbEnum.SystemMessage.KEY_USER_ID, this.mUserId);
            jSONObject.put("message", jSONObject6);
        } catch (JSONException e) {
            Log.e("BaiduRtcRoomImp", "Caught error on reportCommunicationQualityInfo: " + e);
        }
        this.cvO.report(jSONObject.toString(), 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aeG() {
        if (this.cvH == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(CommandMessage.SDK_VERSION, "BRTC.Android.SDK V" + version());
            jSONObject2.put("networkType", d.getNetworkType(this.mContext.get()));
            jSONObject2.put(Config.DEVICE_PART, d.getDeviceModel());
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("deviceInfo", jSONObject2);
            jSONObject.put("env", this.cvq);
            jSONObject.put("appId", this.mAppId);
            if (this.cvH != null) {
                jSONObject.put("roomId", this.cvH.getRoomId());
            }
            jSONObject.put("timestamp", System.currentTimeMillis());
            jSONObject.put(TbEnum.SystemMessage.KEY_USER_ID, this.mUserId);
            jSONObject.put("message", jSONObject3);
        } catch (JSONException e) {
            Log.e("BaiduRtcRoomImp", "Caught error on reportDeviceInfo: " + e);
        }
        this.cvO.report(jSONObject.toString(), 0);
    }

    private boolean aeH() {
        Camera2Enumerator.disableExtraCamera(this.cvn.ctu);
        return Camera2Enumerator.isSupported(this.mContext.get());
    }

    private void bO(long j) {
        synchronized (this) {
            if (this.cvD.containsKey(Long.valueOf(j))) {
                this.cvo.put(Long.valueOf(j), this.cvD.get(Long.valueOf(j)));
                this.cvD.remove(Long.valueOf(j));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int d(Boolean bool) {
        if (this.cuL == bool) {
            return 0;
        }
        if (this.audioManager == null) {
            this.audioManager = (AudioManager) this.mContext.get().getSystemService("audio");
        }
        if (this.audioManager == null) {
            return -1;
        }
        try {
            if (bool.booleanValue()) {
                this.audioManager.startBluetoothSco();
                this.audioManager.setBluetoothScoOn(bool.booleanValue());
            }
            this.audioManager.setBluetoothScoOn(bool.booleanValue());
            this.audioManager.stopBluetoothSco();
            this.cuL = bool;
            return 0;
        } catch (Exception e) {
            Log.e("BaiduRtcRoomImp", "set bluetooth sco fail: " + e.getMessage());
            return -1;
        }
    }

    public static void em(boolean z) {
        crX = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isHeadsetOn(Context context) {
        AudioDeviceInfo[] devices;
        if (this.audioManager == null) {
            this.audioManager = (AudioManager) context.getSystemService("audio");
        }
        if (this.audioManager == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 23) {
            return this.audioManager.isWiredHeadsetOn() || this.audioManager.isBluetoothScoOn() || this.audioManager.isBluetoothA2dpOn();
        }
        for (AudioDeviceInfo audioDeviceInfo : this.audioManager.getDevices(2)) {
            if (audioDeviceInfo.getType() == 3 || audioDeviceInfo.getType() == 4 || audioDeviceInfo.getType() == 8 || audioDeviceInfo.getType() == 7 || audioDeviceInfo.getType() == 11) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jl(String str) {
        if ((this.cvc || this.cvb) && this.cvH != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(TbEnum.SystemMessage.KEY_USER_NAME, this.mDisplayName);
                jSONObject2.put("eventDescription", str);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("roomEvent", jSONObject2);
                jSONObject.put("env", this.cvq);
                jSONObject.put("appId", this.mAppId);
                if (this.cvH != null) {
                    jSONObject.put("roomId", this.cvH.getRoomId());
                }
                jSONObject.put("timestamp", System.currentTimeMillis());
                jSONObject.put(TbEnum.SystemMessage.KEY_USER_ID, this.mUserId);
                jSONObject.put("message", jSONObject3);
            } catch (JSONException e) {
                Log.e("BaiduRtcRoomImp", "Caught error on reportRoomEventInfo: " + e);
            }
            this.cvO.report(jSONObject.toString(), 1);
        }
    }

    private void n(final BigInteger bigInteger) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.rtc.a.a.11
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.cvn.HasVideo) {
                    a.this.csk = a.this.aeC();
                }
                if (a.this.cvL == null) {
                    Log.e("BaiduRtcRoomImp", "peerConnectionClient is null!");
                    return;
                }
                if (a.this.cva) {
                    a.this.cvL.a(a.this.cvN.getEglBaseContext(), a.this.cvG, a.this.csk, bigInteger);
                } else {
                    a.this.cvL.a(a.this.cvN.getEglBaseContext(), a.this.cvk, a.this.csk, bigInteger);
                }
                a.this.cvL.i(bigInteger);
            }
        });
    }

    static /* synthetic */ int s(a aVar) {
        int i = aVar.cuH + 1;
        aVar.cuH = i;
        return i;
    }

    static /* synthetic */ int t(a aVar) {
        int i = aVar.cuH;
        aVar.cuH = i + 1;
        return i;
    }

    public static String version() {
        return "1.2.13_20201120";
    }

    @Override // com.baidu.rtc.c
    public void a(BaiduRtcRoom.RtcLiveTransferMode rtcLiveTransferMode, String str) {
        if (this.cuO == null) {
            return;
        }
        this.cuO.onRoomEventUpdate(117, rtcLiveTransferMode.ordinal(), str);
    }

    public void a(BaiduRtcRoom.RtcSoundMode rtcSoundMode) {
        AudioManager audioManager = (AudioManager) this.mContext.get().getSystemService("audio");
        if (rtcSoundMode == BaiduRtcRoom.RtcSoundMode.RTC_SOUND_MODE_SPEAKER) {
            audioManager.setSpeakerphoneOn(true);
        } else if (rtcSoundMode == BaiduRtcRoom.RtcSoundMode.RTC_SOUND_MODE_EAR) {
            audioManager.setSpeakerphoneOn(false);
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void a(RtcParameterSettings rtcParameterSettings, RtcParameterSettings.RtcParamSettingType rtcParamSettingType) {
        switch (rtcParamSettingType) {
            case RTC_PARAM_SETTINGS_ALL:
                if (rtcParameterSettings != null) {
                    this.cvn = rtcParameterSettings;
                    cuG = this.cvn.AudioContentType;
                    return;
                }
                return;
            case RTC_VIDEO_PARAM_SETTINGS_BITRATE:
                this.cvn.VideoMaxkbps = rtcParameterSettings.VideoMaxkbps;
                if (this.cvL == null || this.mHandler == null) {
                    return;
                }
                this.mHandler.post(new Runnable() { // from class: com.baidu.rtc.a.a.10
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.cvL == null || a.this.cvn.VideoMaxkbps <= 0) {
                            return;
                        }
                        Log.d("BaiduRtcRoomImp", "Set video maximum bitrate: " + a.this.cvn.VideoMaxkbps);
                        a.this.cvL.d(Integer.valueOf(a.this.cvn.VideoMaxkbps));
                    }
                });
                return;
            case RTC_VIDEO_PARAM_SETTINGS_RENDER_MODE:
                this.cvn.ctD = rtcParameterSettings.ctD;
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void a(g.d dVar) {
        this.cvx = dVar;
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void a(i iVar) {
        this.csk = iVar;
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void a(final Boolean bool, final Boolean bool2, final BigInteger bigInteger) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.rtc.a.a.7
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.cvH == null) {
                    return;
                }
                BigInteger k = a.this.cvH.k(bigInteger);
                String l = a.this.cvH.l(k);
                b bVar = (b) a.this.cvv.get(k);
                if (bVar == null) {
                    bVar = new b(bigInteger, k.longValue(), bool, bool2, l);
                    a.this.cvv.put(k, bVar);
                } else {
                    bVar.cvZ = bool;
                    bVar.cvY = bool2;
                    bVar.crq = bigInteger;
                    bVar.nickName = l;
                }
                if (!bool2.booleanValue() || a.this.cvL == null) {
                    return;
                }
                a.this.cvL.a(true, 200, bVar.crq, PeerConnectionClient.StatsEventsType.GET_AUDIOLEVEL_EVENT);
            }
        });
    }

    @Override // com.baidu.rtc.c
    public void a(BigInteger bigInteger, int i, boolean z) {
        if (this.cuO == null) {
            return;
        }
        this.cuO.onPeerConnectStateUpdate(z ? 2001 : 2002);
    }

    @Override // com.baidu.rtc.c
    public void a(BigInteger bigInteger, String str) {
        if (this.cuO == null) {
            return;
        }
        this.cuO.onRoomEventUpdate(303, bigInteger.longValue(), str);
    }

    @Override // com.baidu.rtc.c
    public void a(BigInteger bigInteger, String str, String str2) {
        if (this.cuO == null) {
            return;
        }
        this.cuO.onRoomEventUpdate(300, bigInteger.longValue(), str);
    }

    @Override // com.baidu.rtc.c
    public void a(final BigInteger bigInteger, final BigInteger bigInteger2) {
        int i;
        Log.i("BaiduRtcRoomImp", "==================onLeaving=======================");
        this.mHandler.post(new Runnable() { // from class: com.baidu.rtc.a.a.4
            @Override // java.lang.Runnable
            public void run() {
                a.this.cvv.remove(bigInteger2);
                if (a.this.cuT.get(bigInteger) != null) {
                    a.this.cuT.remove(bigInteger);
                    if (a.this.cvL != null) {
                        a.this.cvL.a(false, 0, bigInteger, PeerConnectionClient.StatsEventsType.GET_QUALITY_MONITOR_EVENT);
                    }
                }
            }
        });
        com.baidu.rtc.a j = this.cvL.j(bigInteger);
        if (this.cvn.ctD == RtcParameterSettings.RtcVideoRenderMode.RTC_VIDEO_RENDER_MODE_EXTERNAL) {
            j jVar = this.cvD.get(Long.valueOf(bigInteger2.longValue()));
            if (jVar == null || j == null) {
                Log.d("BaiduRtcRoomImp", "No external render has found!");
            } else {
                Log.d("BaiduRtcRoomImp", "remove external video sink of user " + bigInteger2);
                jVar.clearImage();
                if (j.cru != null) {
                    j.cru.removeSink(jVar);
                }
                bO(bigInteger2.longValue());
                if (this.cuO != null) {
                    if (this.cvg == bigInteger2.longValue()) {
                        return;
                    }
                    this.cuO.onRoomEventUpdate(107, bigInteger2.longValue(), "gone");
                    this.cvg = bigInteger2.longValue();
                    return;
                }
            }
        }
        if (j != null && (i = j.crv) >= 0 && i < this.cuU.length) {
            this.cuU[i] = false;
            this.cvw--;
            if (this.cvs[i] != null) {
                this.cvs[i].clearImage();
                if (j.cru != null) {
                    j.cru.removeSink(this.cvs[i]);
                }
                if (this.cuO != null) {
                    if (this.cvg != bigInteger2.longValue()) {
                        this.cuO.onRoomEventUpdate(107, bigInteger2.longValue(), "gone");
                        this.cvg = bigInteger2.longValue();
                        return;
                    }
                    return;
                }
            }
        }
        if (this.cuO != null) {
            if (this.cvh == bigInteger2.longValue()) {
                return;
            }
            this.cuS.remove(bigInteger2);
            this.cuO.onRoomEventUpdate(105, bigInteger2.longValue(), "leaving");
        }
        this.cvh = bigInteger2.longValue();
        jl("REMOTE_LEAVING_" + bigInteger2 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + bigInteger);
    }

    @Override // com.baidu.rtc.c
    public void a(BigInteger bigInteger, JSONObject jSONObject) {
        SessionDescription.Type fromCanonicalForm = SessionDescription.Type.fromCanonicalForm(jSONObject.optString("type"));
        String optString = jSONObject.optString("sdp");
        if (this.cvn.ctw && this.cuM && optString.contains("profile-level-id=42e01f")) {
            optString = optString.replace("profile-level-id=42e01f", "profile-level-id=640c1f");
            Log.e("BaiduRtcRoomImp", "enable high profile, remote jsep changed: " + optString);
        }
        this.cvL.a(bigInteger, new SessionDescription(fromCanonicalForm, optString));
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void a(IceCandidate iceCandidate, BigInteger bigInteger) {
        Log.e("BaiduRtcRoomImp", "=========onIceCandidate========");
        if (iceCandidate != null) {
            this.cvH.a(bigInteger, iceCandidate);
        } else {
            this.cvH.m(bigInteger);
        }
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void a(SessionDescription sessionDescription, BigInteger bigInteger) {
        Log.e("BaiduRtcRoomImp", sessionDescription.type.toString());
        this.cvH.d(bigInteger, sessionDescription);
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void a(SessionDescription sessionDescription, BigInteger bigInteger, boolean z) {
        Log.e("BaiduRtcRoomImp", sessionDescription.type.toString());
        if (this.cvH == null) {
            return;
        }
        this.cuM = z;
        this.cvH.c(bigInteger, sessionDescription);
        this.mHandler.post(new Runnable() { // from class: com.baidu.rtc.a.a.5
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.cvL == null || a.this.csb.csY <= 0) {
                    return;
                }
                Log.d("BaiduRtcRoomImp", "Set video maximum bitrate: " + a.this.csb.csY);
                a.this.cvL.d(Integer.valueOf(a.this.csb.csY));
            }
        });
    }

    public void a(StatsReport[] statsReportArr) {
        StatsReport.Value[] valueArr;
        if (this.cuO == null) {
            return;
        }
        for (StatsReport statsReport : statsReportArr) {
            if (statsReport.id.equals("bweforvideo")) {
                for (StatsReport.Value value : statsReport.values) {
                    if (value.name.equals("googAvailableSendBandwidth")) {
                        this.cvK = Double.parseDouble(value.value);
                        if (this.cvK > 100.0d) {
                            this.cuO.onRoomEventUpdate(200, (long) this.cvK, statsReport.toString());
                        }
                    }
                }
                return;
            }
        }
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void a(final StatsReport[] statsReportArr, final BigInteger bigInteger, final PeerConnectionClient.StatsEventsType statsEventsType) {
        if (bigInteger == this.cvp && statsEventsType == PeerConnectionClient.StatsEventsType.GET_BWE_EVENT && this.cvI) {
            a(statsReportArr);
        }
        this.mHandler.post(new Runnable() { // from class: com.baidu.rtc.a.a.6
            @Override // java.lang.Runnable
            public void run() {
                if (statsEventsType == PeerConnectionClient.StatsEventsType.GET_AUDIOLEVEL_EVENT) {
                    a.this.a(statsReportArr, bigInteger);
                }
                if ((a.this.cvc || a.this.cvb) && statsEventsType == PeerConnectionClient.StatsEventsType.GET_QUALITY_MONITOR_EVENT) {
                    com.baidu.rtc.b.b bVar = (com.baidu.rtc.b.b) a.this.cuT.get(bigInteger);
                    if (bVar != null) {
                        bVar.b(statsReportArr);
                    }
                    if (bigInteger != a.this.cvp || a.this.cvO == null) {
                        return;
                    }
                    a.this.aeF();
                }
            }
        });
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public boolean a(BaiduRtcRoom.a aVar) {
        this.cuO = aVar;
        return true;
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public boolean a(String str, boolean z, boolean z2, String str2, BaiduRtcRoom.RtcLiveTransferMode rtcLiveTransferMode) {
        if (this.cvj.isEmpty() || this.cvi == rtcLiveTransferMode) {
            this.cvj = str;
            this.cvi = rtcLiveTransferMode;
            this.cvH.eB(z2);
            this.cvH.jg(str);
            this.cvH.eA(z);
            this.cvH.jf(str2);
            this.cvH.a(rtcLiveTransferMode);
        } else {
            this.cvH.b(str, z, z2, str2, rtcLiveTransferMode);
        }
        return true;
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public BaiduRtcRoom.c[] aef() {
        int i = 0;
        int i2 = 0;
        for (BigInteger bigInteger : this.cvv.keySet()) {
            b bVar = this.cvv.get(bigInteger);
            if (bVar != null && bVar.cvY.booleanValue() && bVar.volume != -1) {
                i2++;
            }
        }
        BaiduRtcRoom.c[] cVarArr = new BaiduRtcRoom.c[i2];
        for (BigInteger bigInteger2 : this.cvv.keySet()) {
            b bVar2 = this.cvv.get(bigInteger2);
            if (bVar2 != null && bVar2.volume != -1 && bVar2.cvY.booleanValue()) {
                if (i >= i2) {
                    break;
                }
                cVarArr[i] = new BaiduRtcRoom.c();
                cVarArr[i].userId = bVar2.userId;
                cVarArr[i].volumeLevel = bVar2.volume;
                cVarArr[i].nicName = bVar2.nickName;
                i++;
            }
        }
        return cVarArr;
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public BaiduRtcRoom.d[] aeg() {
        if (this.cvH == null) {
            return null;
        }
        return this.cvH.aeA();
    }

    @Override // com.baidu.rtc.c
    public void aeh() {
        if (this.cuO == null) {
            return;
        }
        this.cuO.onRoomEventUpdate(103, 0L, "coennection Error");
        jl("CONNECTION_LOST");
    }

    @Override // com.baidu.rtc.c
    public void aei() {
        if (this.cuO == null) {
            return;
        }
        this.cuO.onRoomEventUpdate(102, 0L, BdStatsConstant.StatsType.ERROR);
        jl("LOGIN_ERROR");
    }

    @Override // com.baidu.rtc.c
    public void aej() {
        if (this.cuO == null) {
            return;
        }
        this.cuO.onRoomEventUpdate(101, 0L, "time out");
    }

    @Override // com.baidu.rtc.c
    public void aek() {
        if (this.cuO == null) {
            return;
        }
        this.cuO.onRoomEventUpdate(112, 0L, "");
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void aer() {
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void aes() {
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void aet() {
        if (this.cuO != null) {
            this.cuO.onPeerConnectStateUpdate(2003);
        }
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void aeu() {
    }

    @Override // com.baidu.rtc.c
    public void b(BaiduRtcRoom.RtcLiveTransferMode rtcLiveTransferMode, String str) {
        if (this.cuO == null) {
            return;
        }
        this.cuO.onRoomEventUpdate(118, rtcLiveTransferMode.ordinal(), str);
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void b(com.baidu.rtc.a aVar) {
        int i;
        Log.e("BaiduRtcRoomImp", "=========onRemoteRender========" + aVar.cru);
        final BigInteger k = this.cvH.k(aVar.crq);
        if (k.longValue() == 0) {
            Log.e("BaiduRtcRoomImp", "onRemoteRender Userid is 0.");
        } else if (this.cvn.ctD == RtcParameterSettings.RtcVideoRenderMode.RTC_VIDEO_RENDER_MODE_EXTERNAL) {
            j bP = bP(k.longValue());
            Log.d("BaiduRtcRoomImp", "enable external video render mode with videoRenderer -> " + bP);
            if (bP != null) {
                aVar.cru.addSink(bP);
            } else {
                Log.d("BaiduRtcRoomImp", "Not found external render for user " + k);
            }
            this.cuO.onRoomEventUpdate(106, k.longValue(), "");
        } else {
            Log.d("BaiduRtcRoomImp", "it is internal video render mode");
            try {
                i = this.cuS.get(this.cvH.k(aVar.crq)).intValue();
            } catch (Exception e) {
                i = -1;
            }
            if (i >= 0 && i < cuE && this.cvs != null) {
                if (this.cvs[i] != null) {
                    this.cvs[i].setFirstFrameEventListener(new Runnable() { // from class: com.baidu.rtc.a.a.8
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.cuO != null) {
                                a.this.cuO.onRoomEventUpdate(106, k.longValue(), "");
                            }
                        }
                    });
                    aVar.cru.addSink(this.cvs[i]);
                }
                aVar.crv = i;
            } else if (this.cvs != null) {
                int i2 = 0;
                while (true) {
                    if (i2 >= this.cuU.length) {
                        i2 = -1;
                        break;
                    } else if (!this.cuU[i2]) {
                        this.cuU[i2] = true;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i2 >= 0) {
                    if (this.cvs[i2] != null) {
                        this.cvs[i2].setFirstFrameEventListener(new Runnable() { // from class: com.baidu.rtc.a.a.9
                            @Override // java.lang.Runnable
                            public void run() {
                                if (a.this.cuO != null) {
                                    a.this.cuO.onRoomEventUpdate(106, k.longValue(), "");
                                }
                            }
                        });
                        aVar.cru.addSink(this.cvs[i2]);
                    }
                    aVar.crv = i2;
                }
                this.cvw++;
            }
        }
    }

    @Override // com.baidu.rtc.c
    public void b(BigInteger bigInteger) {
        if (this.cuO == null) {
            return;
        }
        this.cuO.onPeerConnectStateUpdate(2003);
    }

    @Override // com.baidu.rtc.c
    public void b(BigInteger bigInteger, String str) {
        if (this.cvh == bigInteger.longValue()) {
            this.cvh = 0L;
        }
        if (this.cvg == bigInteger.longValue()) {
            this.cvg = 0L;
        }
        if (this.cuO == null) {
            return;
        }
        this.cuO.onRoomEventUpdate(104, bigInteger.longValue(), str);
    }

    @Override // com.baidu.rtc.c
    public void b(final BigInteger bigInteger, JSONObject jSONObject) {
        this.cvL.b(bigInteger, new SessionDescription(SessionDescription.Type.fromCanonicalForm(jSONObject.optString("type")), jSONObject.optString("sdp")));
        this.mHandler.post(new Runnable() { // from class: com.baidu.rtc.a.a.3
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.cvb || bigInteger == a.this.cvp || a.this.cvL == null) {
                    return;
                }
                if (a.this.cuT.get(bigInteger) != null) {
                    a.this.cvL.a(false, 0, bigInteger, PeerConnectionClient.StatsEventsType.GET_QUALITY_MONITOR_EVENT);
                    a.this.cuT.remove(bigInteger);
                }
                a.this.cvL.a(a.this.cvb, 2000, bigInteger, PeerConnectionClient.StatsEventsType.GET_QUALITY_MONITOR_EVENT);
                a.this.cuT.put(bigInteger, new com.baidu.rtc.b.b());
            }
        });
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void bK(long j) {
        if (this.cvH != null) {
            this.cvH.bK(j);
        }
    }

    @Override // com.baidu.rtc.c
    public void bL(long j) {
        if (this.cuO == null) {
            return;
        }
        this.cuO.onRoomEventUpdate(114, j, "");
    }

    @Override // com.baidu.rtc.c
    public void bM(long j) {
        if (this.cuO == null) {
            return;
        }
        this.cuO.onRoomEventUpdate(115, j, "");
    }

    @Override // com.baidu.rtc.c
    public void bN(long j) {
        if (this.cuO == null) {
            return;
        }
        this.cuO.onRoomEventUpdate(113, j, "");
    }

    public j bP(long j) {
        j kVar;
        synchronized (this) {
            Log.d("BaiduRtcRoomImp", j + " : Get external renderer.");
            if (this.cvD.containsKey(Long.valueOf(j))) {
                kVar = this.cvD.get(Long.valueOf(j));
            } else {
                kVar = new k(this.cuO, j);
                Log.d("BaiduRtcRoomImp", j + " : Create external renderer" + kVar);
                this.cvD.put(Long.valueOf(j), kVar);
            }
        }
        return kVar;
    }

    public void bQ(Context context) {
        Log.d("BaiduRtcRoomImp", "setup so later loading feature, and cpu type: " + this.mCpuType);
        com.baidu.cloudbase.b.a.aa(context).dp(this.mCpuType);
        if (this.cvC.isEmpty()) {
            com.baidu.cloudbase.b.a.aa(context).a(com.baidu.cloudbase.b.b.uc(), true, this.cvz);
            return;
        }
        Log.d("BaiduRtcRoomImp", "setup so later load url: " + this.cvC);
        com.baidu.cloudbase.b.a.aa(context).a(this.cvC, true, this.cvz);
    }

    @Override // com.baidu.rtc.c
    public void c(BaiduRtcRoom.RtcLiveTransferMode rtcLiveTransferMode, String str) {
        if (this.cuO == null) {
            return;
        }
        this.cuO.onRoomEventUpdate(116, rtcLiveTransferMode.ordinal(), str);
    }

    @Override // com.baidu.rtc.c
    public void c(final BigInteger bigInteger) {
        if (this.cuO != null) {
            this.cuO.onRoomEventUpdate(100, 0L, "ok");
        }
        this.cvp = bigInteger;
        if (this.cvn.AutoPublish) {
            n(bigInteger);
        }
        if (this.cvI && this.cvL != null) {
            this.cvL.a(this.cvI, 5000, this.cvp, PeerConnectionClient.StatsEventsType.GET_BWE_EVENT);
        }
        this.mHandler.post(new Runnable() { // from class: com.baidu.rtc.a.a.2
            @Override // java.lang.Runnable
            public void run() {
                if ((a.this.cvc || a.this.cvb) && a.this.cvL != null) {
                    if (a.this.cuT.get(bigInteger) != null) {
                        a.this.cvL.a(false, 0, bigInteger, PeerConnectionClient.StatsEventsType.GET_QUALITY_MONITOR_EVENT);
                        a.this.cuT.remove(bigInteger);
                    }
                    a.this.cvL.a(a.this.cvc || a.this.cvb, 2000, bigInteger, PeerConnectionClient.StatsEventsType.GET_QUALITY_MONITOR_EVENT);
                    a.this.cuT.put(bigInteger, new com.baidu.rtc.b.b());
                    if (a.this.cvO != null && !a.this.cvJ) {
                        a.this.cvJ = true;
                        a.this.mHandler.post(a.this.cvM);
                    }
                    a aVar = a.this;
                    aVar.jl("RTCROOM_LOGIN_OK_" + a.this.mUserId);
                }
                b bVar = (b) a.this.cvv.get(BigInteger.valueOf(a.this.mUserId));
                if (bVar != null) {
                    if (a.this.cvL != null) {
                        a.this.cvL.a(false, 0, bVar.crq, PeerConnectionClient.StatsEventsType.GET_AUDIOLEVEL_EVENT);
                    }
                    bVar.cvZ = Boolean.valueOf(a.this.cvn.HasVideo);
                    bVar.cvY = Boolean.valueOf(a.this.cvn.HasAudio);
                    bVar.crq = bigInteger;
                    bVar.nickName = a.this.mDisplayName;
                } else {
                    a.this.cvv.put(BigInteger.valueOf(a.this.mUserId), new b(bigInteger, a.this.mUserId, Boolean.valueOf(a.this.cvn.HasVideo), Boolean.valueOf(a.this.cvn.HasAudio), a.this.mDisplayName));
                }
                if (a.this.cvL != null) {
                    a.this.cvL.a(true, 200, bigInteger, PeerConnectionClient.StatsEventsType.GET_AUDIOLEVEL_EVENT);
                }
            }
        });
    }

    @Override // com.baidu.rtc.c
    public void c(BigInteger bigInteger, String str) {
        if (this.cuO == null) {
            return;
        }
        this.cuO.onRoomEventUpdate(302, bigInteger.longValue(), str);
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void changeSurfaceSize(long j, int i, int i2) {
        if (this.cvD.containsKey(Long.valueOf(j))) {
            j jVar = this.cvD.get(Long.valueOf(j));
            if (jVar != null) {
                jVar.changeSurfaceSize(i, i2);
                return;
            }
            return;
        }
        Log.d("BaiduRtcRoomImp", "External render not found to  change surface size for " + j);
    }

    @Override // com.baidu.rtc.c
    public void d(BigInteger bigInteger) {
        if (this.cvL != null) {
            this.cvL.h(bigInteger);
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void destroyExternalSurface(long j, Surface surface) {
        j jVar;
        if (this.cvD.containsKey(Long.valueOf(j)) && (jVar = this.cvD.get(Long.valueOf(j))) != null && surface == jVar.getSurface()) {
            jVar.releaseSurface();
        }
        aeE();
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void disbandRoom() {
        if (this.cvH != null) {
            this.cvH.disbandRoom();
        }
    }

    public void doDestroy() {
        logoutRtcRoom();
        cuF.remove(toString());
    }

    @Override // com.baidu.rtc.c
    public void e(BigInteger bigInteger) {
        if (this.cuO == null) {
            return;
        }
        this.cuO.onRoomEventUpdate(301, bigInteger.longValue(), "");
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void en(boolean z) {
        if (this.cvL != null) {
            this.cvL.setSpeakerMute(z);
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void enableExternalVideoCapturer(boolean z) {
        this.cva = z;
        this.cvG = new VideoSink() { // from class: com.baidu.rtc.a.a.12
            @Override // org.webrtc.VideoSink
            public void onFrame(VideoFrame videoFrame) {
            }
        };
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void enableStatsToServer(boolean z, String str) {
        f(z, z, str);
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void f(long j, boolean z) {
        if (this.cvH != null) {
            this.cvH.f(j, z);
        }
    }

    @Override // com.baidu.rtc.c
    public void f(BigInteger bigInteger) {
        if (this.cuO == null) {
            return;
        }
        this.cuO.onPeerConnectStateUpdate(2000);
        jl("WEBRTC_UP_" + bigInteger.longValue());
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void f(boolean z, boolean z2, String str) {
        this.cvc = z;
        this.cvb = z2;
        this.cvq = str;
        if (!z && !z2) {
            if (this.cuQ != null) {
                this.cuQ.pause();
                return;
            }
            return;
        }
        if (this.cuQ == null) {
            this.cuQ = new com.baidu.rtc.b.a(this.cvA);
        }
        if (this.cvO == null) {
            this.cvO = d.aeV();
        }
    }

    @Override // com.baidu.rtc.c
    public void fP(int i) {
        if (this.cuO != null && i == 436) {
            this.cuO.onErrorInfoUpdate(RTCConst.RTC_ROOM_USERID_ALREADY_EXIST_ERROR);
        }
    }

    @Override // com.baidu.rtc.c
    public void g(boolean z, int i) {
        if (this.cuO == null) {
            return;
        }
        this.cuO.onPeerConnectStateUpdate(i < 10 ? 2100 : i < 15 ? RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL1 : i < 25 ? RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL2 : i < 40 ? RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL3 : i < 60 ? RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL4 : i < 90 ? RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL5 : i < 120 ? RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL6 : i < 180 ? RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL7 : i < 250 ? RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL8 : RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL9);
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public boolean jd(String str) {
        this.cvH.jh(str);
        return true;
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void je(String str) {
        if (this.cuO != null) {
            this.cuO.onErrorInfoUpdate(10000);
        }
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void l(ByteBuffer byteBuffer) {
        if (this.cuO == null) {
            return;
        }
        this.cuO.onRoomDataMessage(byteBuffer);
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public boolean loginRtcRoomWithRoomName(String str, long j, String str2, boolean z) {
        Log.i("BaiduRtcRoomImp", "enable force login");
        this.cuY = z;
        return loginRtcRoomWithRoomName(str, j, str2, true, true);
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public boolean loginRtcRoomWithRoomName(String str, long j, String str2, boolean z, boolean z2) {
        int i;
        int i2;
        int i3;
        int i4;
        this.mDisplayName = str2;
        this.mRoomName = str;
        this.mUserId = j;
        this.cuX = z;
        this.cuW = z2;
        if (this.cvd && !this.cve) {
            this.cvB = new Thread(new Runnable() { // from class: com.baidu.rtc.a.a.15
                @Override // java.lang.Runnable
                public void run() {
                    Log.d("BaiduRtcRoomImp", "setup downloading thread ......");
                    a.this.bQ(a.this.cvA);
                }
            });
            this.cvB.start();
            return true;
        } else if (j == 0) {
            throw new InvalidParameterException("loginRtcRoomWithRoomName: Param Error,userId cann't be zero. zero is reserved.");
        } else {
            this.cvH.ji(str);
            this.cvH.setUserId(j);
            if (str2 != null && !str2.isEmpty()) {
                this.cvH.setDisplayName(str2);
            }
            this.cvH.setVideoCodec(this.cvn.VideoCodec);
            this.cvH.ex(z);
            this.cvH.ew(z2);
            int i5 = this.cvn.VideoWidth;
            int i6 = this.cvn.VideoHeight;
            String lowerCase = this.cvn.VideoResolution.toLowerCase();
            if (lowerCase.contains("192x144")) {
                i6 = 144;
                i = 192;
            } else if (lowerCase.contains("320x180")) {
                i6 = 180;
                i = 320;
            } else if (lowerCase.contains("352x288")) {
                i6 = 288;
                i = 352;
            } else if (lowerCase.contains("480x320")) {
                i6 = 320;
                i = 480;
            } else {
                if (lowerCase.contains("480x360")) {
                    i4 = 480;
                } else if (lowerCase.contains("640x360")) {
                    i4 = 640;
                } else if (lowerCase.contains("640x480")) {
                    i6 = 480;
                    i = 640;
                } else if (lowerCase.contains("960x540")) {
                    i6 = 540;
                    i = 960;
                } else if (lowerCase.contains("1280x720")) {
                    i6 = 720;
                    i = 1280;
                } else if (lowerCase.contains("1920x1080")) {
                    i6 = 1080;
                    i = 1920;
                } else {
                    if (lowerCase.contains("3840x2160")) {
                        i3 = 3840;
                    } else if (lowerCase.contains("4096x2160")) {
                        i3 = 4096;
                    } else {
                        if (lowerCase.contains("7680x4320")) {
                            i2 = 7680;
                        } else if (lowerCase.contains("8192x4320")) {
                            i2 = 8192;
                        } else {
                            i = i5;
                        }
                        i6 = 4320;
                        i = i2;
                    }
                    i6 = 2160;
                    i = i3;
                }
                i6 = EncoderTextureDrawer.X264_WIDTH;
                i = i4;
            }
            if (i > 8192 || i6 > 4320) {
                i = 8192;
                i6 = 4320;
            }
            String str3 = Build.MODEL;
            if (Build.MODEL.contains("Redmi 6 Pro")) {
                this.cvn.cts = true;
                this.cuJ = true;
            }
            this.csb = new PeerConnectionClient.c(false, i, i6, this.cvn.VideoFps, this.cvn.VideoCodec.toUpperCase(), true, 0, "opus", false, false, this.cvn.cts, this.cuI.booleanValue(), this.cuJ.booleanValue(), this.cvn.VideoMaxkbps, this.cvn.VideoMinkbps, this.cvn.ctB, this.cvn.ctq, true, this.cvn.ctv, this.cvn.ctz, this.cvn.ctw, this.cvn.ctp, this.cvn.csD, this.cvn.ctC, this.cvn.ctA, this.cvn.cty);
            this.cvL = PeerConnectionClient.aeo();
            if (this.cuR) {
                if (this.cuN == null) {
                    this.cuN = new com.baidu.cloudbase.a.a();
                }
                this.cuN.aQ(false);
                if (this.cvr < 0) {
                    this.cvr = this.cuN.tV();
                }
                this.cuN.tW();
                this.cuN.aP(false);
                this.cuN.aO(false);
                this.cuN.a(this.cvm);
            }
            if (this.cvx != null || this.cuR) {
                this.cvL.a(this.cvy);
            }
            if (this.cvt != null || this.cuR) {
                this.cvL.a(this.cvu);
            }
            if (this.cvn != null) {
                this.cvH.er(this.cvn.HasAudio);
                this.cvL.er(this.cvn.HasAudio);
                this.cvH.et(this.cvn.HasVideo);
                this.cvL.et(this.cvn.HasVideo);
                this.cvH.es(this.cvn.HasData);
                this.cvL.es(this.cvn.HasData);
                this.cvL.fQ(this.cvn.AudioFrequency);
                this.cvL.setAudioChannel(this.cvn.AudioChannel);
                this.cvH.fR(this.cvn.ConnectionTimeoutMs);
                this.cvH.fS(this.cvn.ReadTimeoutMs);
                this.cvH.ey(this.cvn.AutoPublish);
                this.cvH.ez(this.cvn.AutoSubScribe);
            }
            this.cvL.eq(this.cuZ);
            this.cvL.ep(crX);
            this.cvL.a(this.mContext.get(), this.csb, this);
            this.cvH.L(this.cvf, this.cuY);
            Log.i("BRTC", "loginRtcRoomWithRoomName: this " + this + " version: " + version());
            return true;
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public boolean logoutRtcRoom() {
        if (this.cvL != null) {
            this.cvL.eo(false);
            this.cvL.eu(false);
            this.cvL.aeq();
            this.cvH.yB();
            this.cvH.finalize();
            this.cvL.close();
            if (this.cuQ != null) {
                this.cuQ.pause();
            }
            this.cuT.clear();
            this.cvL = null;
            this.cvH = null;
            if (this.cuN != null) {
                this.cuN.a(null);
                this.cuN.release();
            }
            if (this.cvk != null) {
                this.cvk.release();
                this.cvk = null;
            }
            if (this.cvs != null) {
                for (int i = 0; i < this.cvs.length; i++) {
                    if (this.cvs[i] != null) {
                        this.cvs[i].release();
                        this.cvs[i] = null;
                    }
                }
            }
            aeD();
            aeE();
            if (this.cvN != null) {
                this.cvN.release();
            }
            if (this.audioManager != null && this.audioManager.isBluetoothScoOn()) {
                d((Boolean) false);
            }
            if (this.cuV != null) {
                this.mContext.get().unregisterReceiver(this.cuV);
                this.cuV = null;
            }
            System.gc();
        }
        return true;
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void muteMicphone(boolean z) {
        if (this.cvL != null) {
            this.cvL.eo(!z);
        }
        jl("MUTE_MICPHONE");
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void onIceCandidatesRemoved(IceCandidate[] iceCandidateArr) {
    }

    public void presetLoudSpeaker(boolean z) {
        ((AudioManager) this.mContext.get().getSystemService("audio")).setSpeakerphoneOn(z);
        jl("PRESETLOUDSPEAKER");
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void sendMessageToUser(String str, long j) {
        if (this.cvH == null) {
            return;
        }
        this.cvH.sendMessageToUser(str, j);
        try {
            Thread.sleep(10L);
        } catch (InterruptedException e) {
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void setExternalSurface(long j, Surface surface) {
        j bP = bP(j);
        if (bP != null) {
            if (!bP.aev()) {
                bP.init();
                bP.ev(true);
            }
            for (Long l : this.cvD.keySet()) {
                j jVar = this.cvD.get(l);
                if (jVar != null && jVar.hasSurface() && surface == jVar.getSurface() && this.cuO != null) {
                    Log.d("BaiduRtcRoomImp", "Set surface repeat with userId " + j);
                    this.cuO.onErrorInfoUpdate(600);
                    return;
                }
            }
            bP.setSurface(surface);
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void setUserAttribute(String str) {
        if (this.cvH == null) {
            return;
        }
        this.cvH.setUserAttribute(str);
        try {
            Thread.sleep(10L);
        } catch (InterruptedException e) {
        }
    }
}
