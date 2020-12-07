package com.baidu.rtc.b;

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
import com.baidu.platform.comapi.UIMsg;
import com.baidu.rtc.BaiduRtcRoom;
import com.baidu.rtc.PeerConnectionClient;
import com.baidu.rtc.RTCVideoView;
import com.baidu.rtc.RtcParameterSettings;
import com.baidu.rtc.c;
import com.baidu.rtc.c.d;
import com.baidu.rtc.g;
import com.baidu.rtc.i;
import com.baidu.rtc.j;
import com.baidu.rtc.k;
import com.baidu.rtc.p;
import com.heytap.mcssdk.mode.CommandMessage;
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
/* loaded from: classes12.dex */
public class a extends BaiduRtcRoom implements PeerConnectionClient.b, c {
    public static boolean cpJ = false;
    static int cue = -1;
    public static int cuf = 30;
    private static ConcurrentHashMap<String, String> cug = new ConcurrentHashMap<>();
    public static int cuh = 1;
    private boolean cuG;
    BaiduRtcRoom.RtcLiveTransferMode cuL;
    private int cui;
    private Boolean cum;
    private com.baidu.cloudbase.a.a cuo;
    com.baidu.rtc.c.a cus;
    C0334a cuy;
    private Context cvd;
    private VideoSink cvj;
    private p cvk;
    private EglBase cvq;
    d cvr;
    String mAppId;
    private WeakReference<Context> mContext;
    private String mCpuType;
    String mDisplayName;
    String mRoomName;
    long mUserId;
    private boolean cuD = false;
    private boolean cuC = false;
    private boolean cuu = false;
    private volatile PeerConnectionClient cvo = null;
    private PeerConnectionClient.c cpN = null;
    private RTCVideoView cuN = null;
    private RTCVideoView[] cuV = null;
    private VideoCapturer cpW = null;
    private String cuI = "wss://rtc2.exp.bcelive.com/janus";
    private int cuZ = 0;
    private boolean cvh = true;
    private boolean[] cux = new boolean[cuf];
    private AudioManager audioManager = null;
    private int cuU = -1;
    BaiduRtcRoom.a cup = null;
    g.d cva = null;
    g.c cuW = null;
    g.b cuO = null;
    private ConcurrentHashMap<Long, j> cvg = new ConcurrentHashMap<>();
    private IdentityHashMap<Long, j> cuR = new IdentityHashMap<>();
    private boolean cvi = false;
    int cuq = cue;
    private RtcParameterSettings cuQ = new RtcParameterSettings();
    private Handler mHandler = new Handler(Looper.getMainLooper());
    BigInteger cuS = null;
    volatile long cuK = 0;
    volatile long cuJ = 0;
    ConcurrentHashMap<BigInteger, BigInteger> cuv = new ConcurrentHashMap<>();
    boolean cvl = true;
    double cvn = 200.0d;
    boolean cuF = false;
    boolean cuE = false;
    String cuT = "online";
    private ConcurrentHashMap<BigInteger, com.baidu.rtc.c.b> cuw = new ConcurrentHashMap<>();
    boolean cvm = false;
    boolean cuz = true;
    boolean cuA = true;
    boolean cuB = false;
    Boolean cuj = false;
    Boolean cuk = false;
    String cuM = "";
    private boolean cun = false;
    private ConcurrentHashMap<BigInteger, b> cuY = new ConcurrentHashMap<>();
    private Thread cve = null;
    private boolean cuH = false;
    private String cvf = "";
    private com.baidu.cloudbase.b.c cvc = new c.a() { // from class: com.baidu.rtc.b.a.1
        @Override // com.baidu.cloudbase.b.c
        public void U(String str, String str2) {
            Log.d("BaiduRtcRoomImp", "Be successful to download so!");
            String str3 = com.baidu.cloudbase.b.b.aa(a.this.cvd) + File.separator + "libjingle_peerconnection_so.so";
            Log.d("BaiduRtcRoomImp", "RTC so path is: " + str3);
            a.this.cuH = true;
            if (com.baidu.cloudbase.b.a.ab(a.this.cvd).dA(com.baidu.cloudbase.b.b.aa(a.this.cvd))) {
                try {
                    System.load(str3);
                    Log.d("BaiduRtcRoomImp", "loaded so, and start to login room.");
                    a.this.loginRtcRoomWithRoomName(a.this.mRoomName, a.this.mUserId, a.this.mDisplayName, a.this.cuA, a.this.cuz);
                    return;
                } catch (Throwable th) {
                    Log.d("BaiduRtcRoomImp", "Failed call System.load to load so! Error: " + th);
                    if (a.this.cup != null) {
                        a.this.cup.onErrorInfoUpdate(401);
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
                a.this.loginRtcRoomWithRoomName(a.this.mRoomName, a.this.mUserId, a.this.mDisplayName, a.this.cuA, a.this.cuz);
            } catch (Throwable th2) {
                Log.d("BaiduRtcRoomImp", "Failed to load so with full path! Error: " + th2);
                if (a.this.cup != null) {
                    a.this.cup.onErrorInfoUpdate(401);
                }
            }
        }

        @Override // com.baidu.cloudbase.b.c
        public void b(String str, int i, String str2) {
            Log.d("BaiduRtcRoomImp", "Failed to download so.");
            if (a.this.cup != null) {
                a.this.cup.onErrorInfoUpdate(400);
            }
        }
    };
    JavaAudioDeviceModule.SamplesReadyCallback cvb = new JavaAudioDeviceModule.SamplesReadyCallback() { // from class: com.baidu.rtc.b.a.16
        @Override // org.webrtc.audio.JavaAudioDeviceModule.SamplesReadyCallback
        public void onWebRtcAudioRecordSamplesReady(JavaAudioDeviceModule.AudioSamples audioSamples) {
            if (audioSamples == null || audioSamples.getData() == null || audioSamples.getData().length <= 0) {
                return;
            }
            if (a.this.cva != null) {
                a.this.cva.a(new g(audioSamples.getAudioFormat(), audioSamples.getChannelCount(), audioSamples.getSampleRate(), audioSamples.getData()));
            }
            if (!a.this.cuu || a.this.cuC) {
                return;
            }
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            bufferInfo.size = audioSamples.getData().length;
            bufferInfo.offset = 0;
            a.this.cuo.a(ByteBuffer.wrap(audioSamples.getData()), bufferInfo);
        }
    };
    JavaAudioDeviceModule.RemoteSamplesReadyCallback cuX = new JavaAudioDeviceModule.RemoteSamplesReadyCallback() { // from class: com.baidu.rtc.b.a.17
        @Override // org.webrtc.audio.JavaAudioDeviceModule.RemoteSamplesReadyCallback
        public void onWebRtcAudioRemoteSamplesReady(JavaAudioDeviceModule.AudioSamples audioSamples) {
            if (audioSamples == null) {
                return;
            }
            if (a.this.cuW != null) {
                a.this.cuW.c(new g(audioSamples.getAudioFormat(), audioSamples.getChannelCount(), audioSamples.getSampleRate(), audioSamples.getData()));
            }
            if (!a.this.cuu || a.this.cuU < 0) {
                return;
            }
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            bufferInfo.size = audioSamples.getData().length;
            bufferInfo.offset = 0;
            a.this.cuo.a(ByteBuffer.wrap(audioSamples.getData()), bufferInfo, a.this.cuU);
        }
    };
    g.a cul = new g.a() { // from class: com.baidu.rtc.b.a.18
    };
    private com.baidu.cloudbase.c.a cuP = new com.baidu.cloudbase.c.a() { // from class: com.baidu.rtc.b.a.19
        @Override // com.baidu.cloudbase.c.a
        public void onFilteredFrameUpdate(byte[] bArr, MediaCodec.BufferInfo bufferInfo) {
            if (a.this.cuO != null) {
                a.this.cuO.b(new g(2, a.this.cuQ.AudioChannel, a.this.cuQ.AudioFrequency, bArr));
            }
        }
    };
    private Runnable cvp = new Runnable() { // from class: com.baidu.rtc.b.a.13
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.cvr != null && (a.this.cuF || a.this.cuE)) {
                a.this.ahj();
            }
            a.this.mHandler.postDelayed(a.this.cvp, 300000L);
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.rtc.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public class C0334a extends BroadcastReceiver {
        C0334a() {
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
                        a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.rtc.b.a.a.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (s == a.this.cui) {
                                    a.this.c((Boolean) true);
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
                a.this.c((Boolean) false);
                a.t(a.this);
                if (a.this.audioManager.isWiredHeadsetOn()) {
                    return;
                }
                a.this.a(BaiduRtcRoom.RtcSoundMode.RTC_SOUND_MODE_SPEAKER);
            } else if (!intent.getAction().equals("android.intent.action.HEADSET_PLUG") || !intent.hasExtra("state")) {
                if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(action) && intent.getIntExtra("android.bluetooth.adapter.extra.STATE", Integer.MIN_VALUE) == 10) {
                    a.t(a.this);
                    a.this.c((Boolean) false);
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

    /* loaded from: classes12.dex */
    public static class b {
        public BigInteger cpb;
        public Boolean cvB;
        public Boolean cvC;
        public String nickName;
        public long userId;
        public int volume = -1;

        public b(BigInteger bigInteger, long j, Boolean bool, Boolean bool2, String str) {
            this.nickName = "";
            this.cpb = bigInteger;
            this.userId = j;
            this.cvB = bool2;
            this.cvC = bool;
            this.nickName = str;
        }
    }

    public a(Context context, String str, String str2, String str3, boolean z) {
        this.mContext = null;
        this.cvk = null;
        this.cvq = null;
        this.cuy = null;
        this.cuG = false;
        this.mCpuType = "armeabi-v7a";
        this.cvd = null;
        this.cuG = z;
        this.cvd = context;
        this.mContext = new WeakReference<>(context);
        this.mCpuType = str3;
        this.cvk = new p();
        this.cvk.setAppId(str);
        this.cvk.kC(str2);
        this.cvk.kB("BRTC.Android.SDK V" + version());
        this.mAppId = str;
        this.cvk.a(this);
        this.cvq = EglBase_CC.create();
        for (int i = 0; i < this.cux.length; i++) {
            this.cux[i] = false;
        }
        AudioManager audioManager = (AudioManager) this.mContext.get().getSystemService("audio");
        audioManager.setSpeakerphoneOn(false);
        if (this.cuF || this.cuE) {
            this.cus = new com.baidu.rtc.c.a(context);
            this.cvr = d.ahy();
        }
        this.cui = 0;
        this.cum = false;
        audioManager = audioManager == null ? (AudioManager) this.mContext.get().getSystemService("audio") : audioManager;
        this.cuy = new C0334a();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.HEADSET_PLUG");
        intentFilter.addAction("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
        intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        try {
            if (audioManager.isBluetoothScoAvailableOffCall()) {
                intentFilter.addAction("android.media.SCO_AUDIO_STATE_CHANGED");
                intentFilter.addAction("android.media.ACTION_SCO_AUDIO_STATE_UPDATED");
                if (audioManager.isBluetoothScoOn()) {
                    c((Boolean) true);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.mContext.get().registerReceiver(this.cuy, intentFilter);
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
        if (this.cuq == cue || this.cuq >= deviceNames.length || (createCapturer3 = cameraEnumerator.createCapturer(deviceNames[this.cuq], null)) == null) {
            Log.d("BaiduRtcRoomImp", "Looking for front facing cameras.");
            for (String str : deviceNames) {
                if (cameraEnumerator.isFrontFacing(str)) {
                    Log.d("BaiduRtcRoomImp", "Creating front facing camera capturer.");
                    if (!cug.containsValue(str) && (createCapturer2 = cameraEnumerator.createCapturer(str, null)) != null) {
                        cug.put(toString(), str);
                        this.cvi = true;
                        if (this.cuN != null) {
                            this.cuN.setMirror(true);
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
                    if (!cug.containsValue(str2) && (createCapturer = cameraEnumerator.createCapturer(str2, null)) != null) {
                        cug.put(toString(), str2);
                        this.cvi = false;
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
        if (this.cvk == null) {
            return;
        }
        if (bigInteger == this.cuS) {
            k = BigInteger.valueOf(this.mUserId);
        } else {
            k = this.cvk.k(bigInteger);
            if (k == null) {
                return;
            }
        }
        b bVar = this.cuY.get(k);
        if (bVar == null && this.cvo != null) {
            this.cvo.a(false, 0, bigInteger, PeerConnectionClient.StatsEventsType.GET_AUDIOLEVEL_EVENT);
            return;
        }
        for (StatsReport statsReport : statsReportArr) {
            if (bigInteger == this.cuS) {
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

    private boolean ahe() {
        return !Build.MODEL.contains("SABRESD-MX6DQ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public VideoCapturer ahf() {
        VideoCapturer a2;
        if (this.cpW != null) {
            return this.cpW;
        }
        if (ahk()) {
            Log.d("BaiduRtcRoomImp", "Creating capturer using camera2 API.");
            a2 = a(new Camera2Enumerator(this.mContext.get()));
        } else {
            Log.d("BaiduRtcRoomImp", "Creating capturer using camera1 API.");
            a2 = a(new Camera1Enumerator(ahe()));
        }
        if (a2 == null) {
            Log.e("BaiduRtcRoomImp", "Failed to open camera");
            return null;
        }
        return a2;
    }

    private void ahg() {
        if (this.cvg.isEmpty()) {
            return;
        }
        for (Long l : this.cvg.keySet()) {
            j jVar = this.cvg.get(l);
            if (jVar != null) {
                if (jVar.getSurface() != null) {
                    jVar.releaseSurface();
                }
                jVar.release();
            }
            this.cvg.remove(l);
        }
    }

    private void ahh() {
        synchronized (this) {
            if (this.cuR.isEmpty()) {
                return;
            }
            for (j jVar : this.cuR.values()) {
                if (jVar != null) {
                    if (jVar.getSurface() != null) {
                        jVar.releaseSurface();
                    }
                    jVar.release();
                }
            }
            this.cuR.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahi() {
        com.baidu.rtc.c.b bVar;
        if (this.cvk == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        boolean z = true;
        com.baidu.rtc.c.b bVar2 = this.cuw.get(this.cuS);
        if (bVar2 == null) {
            z = false;
        } else {
            bVar2.u(hashMap);
        }
        boolean z2 = hashMap.size() != 0 ? z : false;
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("duration", 2);
            JSONObject jSONObject3 = new JSONObject();
            if (this.cus != null) {
                jSONObject3.put("sysCpuUsage", this.cus.ahs());
            }
            jSONObject3.put("appCpuUsage", 0);
            jSONObject2.put("resourceUsageInfo", jSONObject3);
            if (this.cuF) {
                JSONObject jSONObject4 = new JSONObject();
                if (z2) {
                    jSONObject4.put("bitrate", hashMap.get("bitrate_s"));
                    jSONObject4.put("packetloss", hashMap.get("packetloss_s"));
                    jSONObject4.put("cfps", hashMap.get("fps_s"));
                    jSONObject4.put(AlaRecorderLog.KEY_CANERA_START_FPS, hashMap.get("fps_i"));
                    if (bVar2 == null) {
                        jSONObject4.put("resolution", "");
                    } else {
                        jSONObject4.put("resolution", bVar2.ahw());
                    }
                } else {
                    jSONObject4.put("bitrate", 0);
                    jSONObject4.put("packetloss", 0);
                    jSONObject4.put(AlaRecorderLog.KEY_CANERA_START_FPS, 0);
                    jSONObject4.put("resolution", "");
                }
                jSONObject2.put("senderQualityInfo", jSONObject4);
            }
            if (this.cuE) {
                JSONArray jSONArray = new JSONArray();
                for (BigInteger bigInteger : this.cuw.keySet()) {
                    if (bigInteger != this.cuS && (bVar = this.cuw.get(bigInteger)) != null) {
                        HashMap hashMap2 = new HashMap();
                        bVar.t(hashMap2);
                        if (hashMap2.size() != 0) {
                            JSONObject jSONObject5 = new JSONObject();
                            if (this.cvk != null) {
                                jSONObject5.put("feedId", this.cvk.k(bigInteger));
                            }
                            jSONObject5.put("bitrate", hashMap2.get("bitrate_r"));
                            jSONObject5.put("packetloss", hashMap2.get("packetloss_r"));
                            jSONObject5.put(AlaRecorderLog.KEY_CANERA_START_FPS, hashMap2.get("fps_r"));
                            jSONObject5.put("resolution", bVar.ahv());
                            jSONArray.put(jSONObject5);
                        }
                    }
                }
                jSONObject2.put("receiverQualityInfoList", jSONArray);
            }
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put("communicationQualityInfo", jSONObject2);
            jSONObject.put("env", this.cuT);
            jSONObject.put("appId", this.mAppId);
            if (this.cvk != null) {
                jSONObject.put("roomId", this.cvk.getRoomId());
            }
            jSONObject.put("timestamp", System.currentTimeMillis());
            jSONObject.put(TbEnum.SystemMessage.KEY_USER_ID, this.mUserId);
            jSONObject.put("message", jSONObject6);
        } catch (JSONException e) {
            Log.e("BaiduRtcRoomImp", "Caught error on reportCommunicationQualityInfo: " + e);
        }
        this.cvr.K(jSONObject.toString(), 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahj() {
        if (this.cvk == null) {
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
            jSONObject.put("env", this.cuT);
            jSONObject.put("appId", this.mAppId);
            if (this.cvk != null) {
                jSONObject.put("roomId", this.cvk.getRoomId());
            }
            jSONObject.put("timestamp", System.currentTimeMillis());
            jSONObject.put(TbEnum.SystemMessage.KEY_USER_ID, this.mUserId);
            jSONObject.put("message", jSONObject3);
        } catch (JSONException e) {
            Log.e("BaiduRtcRoomImp", "Caught error on reportDeviceInfo: " + e);
        }
        this.cvr.K(jSONObject.toString(), 0);
    }

    private boolean ahk() {
        Camera2Enumerator.disableExtraCamera(this.cuQ.crf);
        return Camera2Enumerator.isSupported(this.mContext.get());
    }

    private void bN(long j) {
        synchronized (this) {
            if (this.cvg.containsKey(Long.valueOf(j))) {
                this.cuR.put(Long.valueOf(j), this.cvg.get(Long.valueOf(j)));
                this.cvg.remove(Long.valueOf(j));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int c(Boolean bool) {
        if (this.cum == bool) {
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
            this.cum = bool;
            return 0;
        } catch (Exception e) {
            Log.e("BaiduRtcRoomImp", "set bluetooth sco fail: " + e.getMessage());
            return -1;
        }
    }

    public static void eh(boolean z) {
        cpJ = z;
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
    public void kD(String str) {
        if ((this.cuF || this.cuE) && this.cvk != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(TbEnum.SystemMessage.KEY_USER_NAME, this.mDisplayName);
                jSONObject2.put("eventDescription", str);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("roomEvent", jSONObject2);
                jSONObject.put("env", this.cuT);
                jSONObject.put("appId", this.mAppId);
                if (this.cvk != null) {
                    jSONObject.put("roomId", this.cvk.getRoomId());
                }
                jSONObject.put("timestamp", System.currentTimeMillis());
                jSONObject.put(TbEnum.SystemMessage.KEY_USER_ID, this.mUserId);
                jSONObject.put("message", jSONObject3);
            } catch (JSONException e) {
                Log.e("BaiduRtcRoomImp", "Caught error on reportRoomEventInfo: " + e);
            }
            this.cvr.K(jSONObject.toString(), 1);
        }
    }

    private void n(final BigInteger bigInteger) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.rtc.b.a.11
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.cuQ.HasVideo) {
                    a.this.cpW = a.this.ahf();
                }
                if (a.this.cvo == null) {
                    Log.e("BaiduRtcRoomImp", "peerConnectionClient is null!");
                    return;
                }
                if (a.this.cuD) {
                    a.this.cvo.a(a.this.cvq.getEglBaseContext(), a.this.cvj, a.this.cpW, bigInteger);
                } else {
                    a.this.cvo.a(a.this.cvq.getEglBaseContext(), a.this.cuN, a.this.cpW, bigInteger);
                }
                a.this.cvo.i(bigInteger);
            }
        });
    }

    static /* synthetic */ int s(a aVar) {
        int i = aVar.cui + 1;
        aVar.cui = i;
        return i;
    }

    static /* synthetic */ int t(a aVar) {
        int i = aVar.cui;
        aVar.cui = i + 1;
        return i;
    }

    public static String version() {
        return "1.2.13_20201120";
    }

    @Override // com.baidu.rtc.c
    public void a(BaiduRtcRoom.RtcLiveTransferMode rtcLiveTransferMode, String str) {
        if (this.cup == null) {
            return;
        }
        this.cup.onRoomEventUpdate(117, rtcLiveTransferMode.ordinal(), str);
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
                    this.cuQ = rtcParameterSettings;
                    cuh = this.cuQ.AudioContentType;
                    return;
                }
                return;
            case RTC_VIDEO_PARAM_SETTINGS_BITRATE:
                this.cuQ.VideoMaxkbps = rtcParameterSettings.VideoMaxkbps;
                if (this.cvo == null || this.mHandler == null) {
                    return;
                }
                this.mHandler.post(new Runnable() { // from class: com.baidu.rtc.b.a.10
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.cvo == null || a.this.cuQ.VideoMaxkbps <= 0) {
                            return;
                        }
                        Log.d("BaiduRtcRoomImp", "Set video maximum bitrate: " + a.this.cuQ.VideoMaxkbps);
                        a.this.cvo.b(Integer.valueOf(a.this.cuQ.VideoMaxkbps));
                    }
                });
                return;
            case RTC_VIDEO_PARAM_SETTINGS_RENDER_MODE:
                this.cuQ.crn = rtcParameterSettings.crn;
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void a(g.d dVar) {
        this.cva = dVar;
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void a(i iVar) {
        this.cpW = iVar;
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void a(final Boolean bool, final Boolean bool2, final BigInteger bigInteger) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.rtc.b.a.7
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.cvk == null) {
                    return;
                }
                BigInteger k = a.this.cvk.k(bigInteger);
                String l = a.this.cvk.l(k);
                b bVar = (b) a.this.cuY.get(k);
                if (bVar == null) {
                    bVar = new b(bigInteger, k.longValue(), bool, bool2, l);
                    a.this.cuY.put(k, bVar);
                } else {
                    bVar.cvC = bool;
                    bVar.cvB = bool2;
                    bVar.cpb = bigInteger;
                    bVar.nickName = l;
                }
                if (!bool2.booleanValue() || a.this.cvo == null) {
                    return;
                }
                a.this.cvo.a(true, 200, bVar.cpb, PeerConnectionClient.StatsEventsType.GET_AUDIOLEVEL_EVENT);
            }
        });
    }

    @Override // com.baidu.rtc.c
    public void a(BigInteger bigInteger, int i, boolean z) {
        if (this.cup == null) {
            return;
        }
        this.cup.onPeerConnectStateUpdate(z ? 2001 : 2002);
    }

    @Override // com.baidu.rtc.c
    public void a(BigInteger bigInteger, String str) {
        if (this.cup == null) {
            return;
        }
        this.cup.onRoomEventUpdate(303, bigInteger.longValue(), str);
    }

    @Override // com.baidu.rtc.c
    public void a(BigInteger bigInteger, String str, String str2) {
        if (this.cup == null) {
            return;
        }
        this.cup.onRoomEventUpdate(300, bigInteger.longValue(), str);
    }

    @Override // com.baidu.rtc.c
    public void a(final BigInteger bigInteger, final BigInteger bigInteger2) {
        int i;
        Log.i("BaiduRtcRoomImp", "==================onLeaving=======================");
        this.mHandler.post(new Runnable() { // from class: com.baidu.rtc.b.a.4
            @Override // java.lang.Runnable
            public void run() {
                a.this.cuY.remove(bigInteger2);
                if (a.this.cuw.get(bigInteger) != null) {
                    a.this.cuw.remove(bigInteger);
                    if (a.this.cvo != null) {
                        a.this.cvo.a(false, 0, bigInteger, PeerConnectionClient.StatsEventsType.GET_QUALITY_MONITOR_EVENT);
                    }
                }
            }
        });
        com.baidu.rtc.a j = this.cvo.j(bigInteger);
        if (this.cuQ.crn == RtcParameterSettings.RtcVideoRenderMode.RTC_VIDEO_RENDER_MODE_EXTERNAL) {
            j jVar = this.cvg.get(Long.valueOf(bigInteger2.longValue()));
            if (jVar == null || j == null) {
                Log.d("BaiduRtcRoomImp", "No external render has found!");
            } else {
                Log.d("BaiduRtcRoomImp", "remove external video sink of user " + bigInteger2);
                jVar.clearImage();
                if (j.cpf != null) {
                    j.cpf.removeSink(jVar);
                }
                bN(bigInteger2.longValue());
                if (this.cup != null) {
                    if (this.cuJ == bigInteger2.longValue()) {
                        return;
                    }
                    this.cup.onRoomEventUpdate(107, bigInteger2.longValue(), "gone");
                    this.cuJ = bigInteger2.longValue();
                    return;
                }
            }
        }
        if (j != null && (i = j.cpg) >= 0 && i < this.cux.length) {
            this.cux[i] = false;
            this.cuZ--;
            if (this.cuV[i] != null) {
                this.cuV[i].clearImage();
                if (j.cpf != null) {
                    j.cpf.removeSink(this.cuV[i]);
                }
                if (this.cup != null) {
                    if (this.cuJ != bigInteger2.longValue()) {
                        this.cup.onRoomEventUpdate(107, bigInteger2.longValue(), "gone");
                        this.cuJ = bigInteger2.longValue();
                        return;
                    }
                    return;
                }
            }
        }
        if (this.cup != null) {
            if (this.cuK == bigInteger2.longValue()) {
                return;
            }
            this.cuv.remove(bigInteger2);
            this.cup.onRoomEventUpdate(105, bigInteger2.longValue(), "leaving");
        }
        this.cuK = bigInteger2.longValue();
        kD("REMOTE_LEAVING_" + bigInteger2 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + bigInteger);
    }

    @Override // com.baidu.rtc.c
    public void a(BigInteger bigInteger, JSONObject jSONObject) {
        SessionDescription.Type fromCanonicalForm = SessionDescription.Type.fromCanonicalForm(jSONObject.optString("type"));
        String optString = jSONObject.optString("sdp");
        if (this.cuQ.crh && this.cun && optString.contains("profile-level-id=42e01f")) {
            optString = optString.replace("profile-level-id=42e01f", "profile-level-id=640c1f");
            Log.e("BaiduRtcRoomImp", "enable high profile, remote jsep changed: " + optString);
        }
        this.cvo.a(bigInteger, new SessionDescription(fromCanonicalForm, optString));
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void a(IceCandidate iceCandidate, BigInteger bigInteger) {
        Log.e("BaiduRtcRoomImp", "=========onIceCandidate========");
        if (iceCandidate != null) {
            this.cvk.a(bigInteger, iceCandidate);
        } else {
            this.cvk.m(bigInteger);
        }
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void a(SessionDescription sessionDescription, BigInteger bigInteger) {
        Log.e("BaiduRtcRoomImp", sessionDescription.type.toString());
        this.cvk.d(bigInteger, sessionDescription);
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void a(SessionDescription sessionDescription, BigInteger bigInteger, boolean z) {
        Log.e("BaiduRtcRoomImp", sessionDescription.type.toString());
        if (this.cvk == null) {
            return;
        }
        this.cun = z;
        this.cvk.c(bigInteger, sessionDescription);
        this.mHandler.post(new Runnable() { // from class: com.baidu.rtc.b.a.5
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.cvo == null || a.this.cpN.cqK <= 0) {
                    return;
                }
                Log.d("BaiduRtcRoomImp", "Set video maximum bitrate: " + a.this.cpN.cqK);
                a.this.cvo.b(Integer.valueOf(a.this.cpN.cqK));
            }
        });
    }

    public void a(StatsReport[] statsReportArr) {
        StatsReport.Value[] valueArr;
        if (this.cup == null) {
            return;
        }
        for (StatsReport statsReport : statsReportArr) {
            if (statsReport.id.equals("bweforvideo")) {
                for (StatsReport.Value value : statsReport.values) {
                    if (value.name.equals("googAvailableSendBandwidth")) {
                        this.cvn = Double.parseDouble(value.value);
                        if (this.cvn > 100.0d) {
                            this.cup.onRoomEventUpdate(200, (long) this.cvn, statsReport.toString());
                        }
                    }
                }
                return;
            }
        }
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void a(final StatsReport[] statsReportArr, final BigInteger bigInteger, final PeerConnectionClient.StatsEventsType statsEventsType) {
        if (bigInteger == this.cuS && statsEventsType == PeerConnectionClient.StatsEventsType.GET_BWE_EVENT && this.cvl) {
            a(statsReportArr);
        }
        this.mHandler.post(new Runnable() { // from class: com.baidu.rtc.b.a.6
            @Override // java.lang.Runnable
            public void run() {
                if (statsEventsType == PeerConnectionClient.StatsEventsType.GET_AUDIOLEVEL_EVENT) {
                    a.this.a(statsReportArr, bigInteger);
                }
                if ((a.this.cuF || a.this.cuE) && statsEventsType == PeerConnectionClient.StatsEventsType.GET_QUALITY_MONITOR_EVENT) {
                    com.baidu.rtc.c.b bVar = (com.baidu.rtc.c.b) a.this.cuw.get(bigInteger);
                    if (bVar != null) {
                        bVar.b(statsReportArr);
                    }
                    if (bigInteger != a.this.cuS || a.this.cvr == null) {
                        return;
                    }
                    a.this.ahi();
                }
            }
        });
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public boolean a(BaiduRtcRoom.a aVar) {
        this.cup = aVar;
        return true;
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public boolean a(String str, boolean z, boolean z2, String str2, BaiduRtcRoom.RtcLiveTransferMode rtcLiveTransferMode) {
        if (this.cuM.isEmpty() || this.cuL == rtcLiveTransferMode) {
            this.cuM = str;
            this.cuL = rtcLiveTransferMode;
            this.cvk.ew(z2);
            this.cvk.ky(str);
            this.cvk.ev(z);
            this.cvk.kx(str2);
            this.cvk.a(rtcLiveTransferMode);
        } else {
            this.cvk.b(str, z, z2, str2, rtcLiveTransferMode);
        }
        return true;
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public BaiduRtcRoom.c[] agc() {
        int i = 0;
        int i2 = 0;
        for (BigInteger bigInteger : this.cuY.keySet()) {
            b bVar = this.cuY.get(bigInteger);
            if (bVar != null && bVar.cvB.booleanValue() && bVar.volume != -1) {
                i2++;
            }
        }
        BaiduRtcRoom.c[] cVarArr = new BaiduRtcRoom.c[i2];
        for (BigInteger bigInteger2 : this.cuY.keySet()) {
            b bVar2 = this.cuY.get(bigInteger2);
            if (bVar2 != null && bVar2.volume != -1 && bVar2.cvB.booleanValue()) {
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
    public BaiduRtcRoom.d[] agd() {
        if (this.cvk == null) {
            return null;
        }
        return this.cvk.agx();
    }

    @Override // com.baidu.rtc.c
    public void age() {
        if (this.cup == null) {
            return;
        }
        this.cup.onRoomEventUpdate(103, 0L, "coennection Error");
        kD("CONNECTION_LOST");
    }

    @Override // com.baidu.rtc.c
    public void agf() {
        if (this.cup == null) {
            return;
        }
        this.cup.onRoomEventUpdate(102, 0L, BdStatsConstant.StatsType.ERROR);
        kD("LOGIN_ERROR");
    }

    @Override // com.baidu.rtc.c
    public void agg() {
        if (this.cup == null) {
            return;
        }
        this.cup.onRoomEventUpdate(101, 0L, "time out");
    }

    @Override // com.baidu.rtc.c
    public void agh() {
        if (this.cup == null) {
            return;
        }
        this.cup.onRoomEventUpdate(112, 0L, "");
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void ago() {
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void agp() {
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void agq() {
        if (this.cup != null) {
            this.cup.onPeerConnectStateUpdate(2003);
        }
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void agr() {
    }

    @Override // com.baidu.rtc.c
    public void b(BaiduRtcRoom.RtcLiveTransferMode rtcLiveTransferMode, String str) {
        if (this.cup == null) {
            return;
        }
        this.cup.onRoomEventUpdate(118, rtcLiveTransferMode.ordinal(), str);
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void b(com.baidu.rtc.a aVar) {
        int i;
        Log.e("BaiduRtcRoomImp", "=========onRemoteRender========" + aVar.cpf);
        final BigInteger k = this.cvk.k(aVar.cpb);
        if (k.longValue() == 0) {
            Log.e("BaiduRtcRoomImp", "onRemoteRender Userid is 0.");
        } else if (this.cuQ.crn == RtcParameterSettings.RtcVideoRenderMode.RTC_VIDEO_RENDER_MODE_EXTERNAL) {
            j bO = bO(k.longValue());
            Log.d("BaiduRtcRoomImp", "enable external video render mode with videoRenderer -> " + bO);
            if (bO != null) {
                aVar.cpf.addSink(bO);
            } else {
                Log.d("BaiduRtcRoomImp", "Not found external render for user " + k);
            }
            this.cup.onRoomEventUpdate(106, k.longValue(), "");
        } else {
            Log.d("BaiduRtcRoomImp", "it is internal video render mode");
            try {
                i = this.cuv.get(this.cvk.k(aVar.cpb)).intValue();
            } catch (Exception e) {
                i = -1;
            }
            if (i >= 0 && i < cuf && this.cuV != null) {
                if (this.cuV[i] != null) {
                    this.cuV[i].setFirstFrameEventListener(new Runnable() { // from class: com.baidu.rtc.b.a.8
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.cup != null) {
                                a.this.cup.onRoomEventUpdate(106, k.longValue(), "");
                            }
                        }
                    });
                    aVar.cpf.addSink(this.cuV[i]);
                }
                aVar.cpg = i;
            } else if (this.cuV != null) {
                int i2 = 0;
                while (true) {
                    if (i2 >= this.cux.length) {
                        i2 = -1;
                        break;
                    } else if (!this.cux[i2]) {
                        this.cux[i2] = true;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i2 >= 0) {
                    if (this.cuV[i2] != null) {
                        this.cuV[i2].setFirstFrameEventListener(new Runnable() { // from class: com.baidu.rtc.b.a.9
                            @Override // java.lang.Runnable
                            public void run() {
                                if (a.this.cup != null) {
                                    a.this.cup.onRoomEventUpdate(106, k.longValue(), "");
                                }
                            }
                        });
                        aVar.cpf.addSink(this.cuV[i2]);
                    }
                    aVar.cpg = i2;
                }
                this.cuZ++;
            }
        }
    }

    @Override // com.baidu.rtc.c
    public void b(BigInteger bigInteger) {
        if (this.cup == null) {
            return;
        }
        this.cup.onPeerConnectStateUpdate(2003);
    }

    @Override // com.baidu.rtc.c
    public void b(BigInteger bigInteger, String str) {
        if (this.cuK == bigInteger.longValue()) {
            this.cuK = 0L;
        }
        if (this.cuJ == bigInteger.longValue()) {
            this.cuJ = 0L;
        }
        if (this.cup == null) {
            return;
        }
        this.cup.onRoomEventUpdate(104, bigInteger.longValue(), str);
    }

    @Override // com.baidu.rtc.c
    public void b(final BigInteger bigInteger, JSONObject jSONObject) {
        this.cvo.b(bigInteger, new SessionDescription(SessionDescription.Type.fromCanonicalForm(jSONObject.optString("type")), jSONObject.optString("sdp")));
        this.mHandler.post(new Runnable() { // from class: com.baidu.rtc.b.a.3
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.cuE || bigInteger == a.this.cuS || a.this.cvo == null) {
                    return;
                }
                if (a.this.cuw.get(bigInteger) != null) {
                    a.this.cvo.a(false, 0, bigInteger, PeerConnectionClient.StatsEventsType.GET_QUALITY_MONITOR_EVENT);
                    a.this.cuw.remove(bigInteger);
                }
                a.this.cvo.a(a.this.cuE, 2000, bigInteger, PeerConnectionClient.StatsEventsType.GET_QUALITY_MONITOR_EVENT);
                a.this.cuw.put(bigInteger, new com.baidu.rtc.c.b());
            }
        });
    }

    public void bH(Context context) {
        Log.d("BaiduRtcRoomImp", "setup so later loading feature, and cpu type: " + this.mCpuType);
        com.baidu.cloudbase.b.a.ab(context).dB(this.mCpuType);
        if (this.cvf.isEmpty()) {
            com.baidu.cloudbase.b.a.ab(context).a(com.baidu.cloudbase.b.b.uK(), true, this.cvc);
            return;
        }
        Log.d("BaiduRtcRoomImp", "setup so later load url: " + this.cvf);
        com.baidu.cloudbase.b.a.ab(context).a(this.cvf, true, this.cvc);
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void bJ(long j) {
        if (this.cvk != null) {
            this.cvk.bJ(j);
        }
    }

    @Override // com.baidu.rtc.c
    public void bK(long j) {
        if (this.cup == null) {
            return;
        }
        this.cup.onRoomEventUpdate(114, j, "");
    }

    @Override // com.baidu.rtc.c
    public void bL(long j) {
        if (this.cup == null) {
            return;
        }
        this.cup.onRoomEventUpdate(115, j, "");
    }

    @Override // com.baidu.rtc.c
    public void bM(long j) {
        if (this.cup == null) {
            return;
        }
        this.cup.onRoomEventUpdate(113, j, "");
    }

    public j bO(long j) {
        j kVar;
        synchronized (this) {
            Log.d("BaiduRtcRoomImp", j + " : Get external renderer.");
            if (this.cvg.containsKey(Long.valueOf(j))) {
                kVar = this.cvg.get(Long.valueOf(j));
            } else {
                kVar = new k(this.cup, j);
                Log.d("BaiduRtcRoomImp", j + " : Create external renderer" + kVar);
                this.cvg.put(Long.valueOf(j), kVar);
            }
        }
        return kVar;
    }

    @Override // com.baidu.rtc.c
    public void c(BaiduRtcRoom.RtcLiveTransferMode rtcLiveTransferMode, String str) {
        if (this.cup == null) {
            return;
        }
        this.cup.onRoomEventUpdate(116, rtcLiveTransferMode.ordinal(), str);
    }

    @Override // com.baidu.rtc.c
    public void c(final BigInteger bigInteger) {
        if (this.cup != null) {
            this.cup.onRoomEventUpdate(100, 0L, "ok");
        }
        this.cuS = bigInteger;
        if (this.cuQ.AutoPublish) {
            n(bigInteger);
        }
        if (this.cvl && this.cvo != null) {
            this.cvo.a(this.cvl, 5000, this.cuS, PeerConnectionClient.StatsEventsType.GET_BWE_EVENT);
        }
        this.mHandler.post(new Runnable() { // from class: com.baidu.rtc.b.a.2
            @Override // java.lang.Runnable
            public void run() {
                if ((a.this.cuF || a.this.cuE) && a.this.cvo != null) {
                    if (a.this.cuw.get(bigInteger) != null) {
                        a.this.cvo.a(false, 0, bigInteger, PeerConnectionClient.StatsEventsType.GET_QUALITY_MONITOR_EVENT);
                        a.this.cuw.remove(bigInteger);
                    }
                    a.this.cvo.a(a.this.cuF || a.this.cuE, 2000, bigInteger, PeerConnectionClient.StatsEventsType.GET_QUALITY_MONITOR_EVENT);
                    a.this.cuw.put(bigInteger, new com.baidu.rtc.c.b());
                    if (a.this.cvr != null && !a.this.cvm) {
                        a.this.cvm = true;
                        a.this.mHandler.post(a.this.cvp);
                    }
                    a aVar = a.this;
                    aVar.kD("RTCROOM_LOGIN_OK_" + a.this.mUserId);
                }
                b bVar = (b) a.this.cuY.get(BigInteger.valueOf(a.this.mUserId));
                if (bVar != null) {
                    if (a.this.cvo != null) {
                        a.this.cvo.a(false, 0, bVar.cpb, PeerConnectionClient.StatsEventsType.GET_AUDIOLEVEL_EVENT);
                    }
                    bVar.cvC = Boolean.valueOf(a.this.cuQ.HasVideo);
                    bVar.cvB = Boolean.valueOf(a.this.cuQ.HasAudio);
                    bVar.cpb = bigInteger;
                    bVar.nickName = a.this.mDisplayName;
                } else {
                    a.this.cuY.put(BigInteger.valueOf(a.this.mUserId), new b(bigInteger, a.this.mUserId, Boolean.valueOf(a.this.cuQ.HasVideo), Boolean.valueOf(a.this.cuQ.HasAudio), a.this.mDisplayName));
                }
                if (a.this.cvo != null) {
                    a.this.cvo.a(true, 200, bigInteger, PeerConnectionClient.StatsEventsType.GET_AUDIOLEVEL_EVENT);
                }
            }
        });
    }

    @Override // com.baidu.rtc.c
    public void c(BigInteger bigInteger, String str) {
        if (this.cup == null) {
            return;
        }
        this.cup.onRoomEventUpdate(302, bigInteger.longValue(), str);
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void c(boolean z, boolean z2, String str) {
        this.cuF = z;
        this.cuE = z2;
        this.cuT = str;
        if (!z && !z2) {
            if (this.cus != null) {
                this.cus.pause();
                return;
            }
            return;
        }
        if (this.cus == null) {
            this.cus = new com.baidu.rtc.c.a(this.cvd);
        }
        if (this.cvr == null) {
            this.cvr = d.ahy();
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void changeSurfaceSize(long j, int i, int i2) {
        if (this.cvg.containsKey(Long.valueOf(j))) {
            j jVar = this.cvg.get(Long.valueOf(j));
            if (jVar != null) {
                jVar.changeSurfaceSize(i, i2);
                return;
            }
            return;
        }
        Log.d("BaiduRtcRoomImp", "External render not found to  change surface size for " + j);
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void d(long j, boolean z) {
        if (this.cvk != null) {
            this.cvk.d(j, z);
        }
    }

    @Override // com.baidu.rtc.c
    public void d(BigInteger bigInteger) {
        if (this.cvo != null) {
            this.cvo.h(bigInteger);
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void destroyExternalSurface(long j, Surface surface) {
        j jVar;
        if (this.cvg.containsKey(Long.valueOf(j)) && (jVar = this.cvg.get(Long.valueOf(j))) != null && surface == jVar.getSurface()) {
            jVar.releaseSurface();
        }
        ahh();
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void disbandRoom() {
        if (this.cvk != null) {
            this.cvk.disbandRoom();
        }
    }

    public void doDestroy() {
        logoutRtcRoom();
        cug.remove(toString());
    }

    @Override // com.baidu.rtc.c
    public void e(BigInteger bigInteger) {
        if (this.cup == null) {
            return;
        }
        this.cup.onRoomEventUpdate(301, bigInteger.longValue(), "");
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void ei(boolean z) {
        if (this.cvo != null) {
            this.cvo.setSpeakerMute(z);
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void enableExternalVideoCapturer(boolean z) {
        this.cuD = z;
        this.cvj = new VideoSink() { // from class: com.baidu.rtc.b.a.12
            @Override // org.webrtc.VideoSink
            public void onFrame(VideoFrame videoFrame) {
            }
        };
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void enableStatsToServer(boolean z, String str) {
        c(z, z, str);
    }

    @Override // com.baidu.rtc.c
    public void f(BigInteger bigInteger) {
        if (this.cup == null) {
            return;
        }
        this.cup.onPeerConnectStateUpdate(2000);
        kD("WEBRTC_UP_" + bigInteger.longValue());
    }

    @Override // com.baidu.rtc.c
    public void h(boolean z, int i) {
        if (this.cup == null) {
            return;
        }
        this.cup.onPeerConnectStateUpdate(i < 10 ? 2100 : i < 15 ? RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL1 : i < 25 ? RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL2 : i < 40 ? RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL3 : i < 60 ? RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL4 : i < 90 ? RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL5 : i < 120 ? RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL6 : i < 180 ? RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL7 : i < 250 ? RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL8 : RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL9);
    }

    @Override // com.baidu.rtc.c
    public void hx(int i) {
        if (this.cup != null && i == 436) {
            this.cup.onErrorInfoUpdate(RTCConst.RTC_ROOM_USERID_ALREADY_EXIST_ERROR);
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public boolean kv(String str) {
        this.cvk.kz(str);
        return true;
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void kw(String str) {
        if (this.cup != null) {
            this.cup.onErrorInfoUpdate(10000);
        }
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void l(ByteBuffer byteBuffer) {
        if (this.cup == null) {
            return;
        }
        this.cup.onRoomDataMessage(byteBuffer);
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public boolean loginRtcRoomWithRoomName(String str, long j, String str2, boolean z) {
        Log.i("BaiduRtcRoomImp", "enable force login");
        this.cuB = z;
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
        this.cuA = z;
        this.cuz = z2;
        if (this.cuG && !this.cuH) {
            this.cve = new Thread(new Runnable() { // from class: com.baidu.rtc.b.a.15
                @Override // java.lang.Runnable
                public void run() {
                    Log.d("BaiduRtcRoomImp", "setup downloading thread ......");
                    a.this.bH(a.this.cvd);
                }
            });
            this.cve.start();
            return true;
        } else if (j == 0) {
            throw new InvalidParameterException("loginRtcRoomWithRoomName: Param Error,userId cann't be zero. zero is reserved.");
        } else {
            this.cvk.kA(str);
            this.cvk.setUserId(j);
            if (str2 != null && !str2.isEmpty()) {
                this.cvk.setDisplayName(str2);
            }
            this.cvk.setVideoCodec(this.cuQ.VideoCodec);
            this.cvk.es(z);
            this.cvk.er(z2);
            int i5 = this.cuQ.VideoWidth;
            int i6 = this.cuQ.VideoHeight;
            String lowerCase = this.cuQ.VideoResolution.toLowerCase();
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
                    i6 = UIMsg.MsgDefine.MSG_NETWORK_CHANNEL;
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
                this.cuQ.cre = true;
                this.cuk = true;
            }
            this.cpN = new PeerConnectionClient.c(false, i, i6, this.cuQ.VideoFps, this.cuQ.VideoCodec.toUpperCase(), true, 0, "opus", false, false, this.cuQ.cre, this.cuj.booleanValue(), this.cuk.booleanValue(), this.cuQ.VideoMaxkbps, this.cuQ.VideoMinkbps, this.cuQ.crl, this.cuQ.crd, true, this.cuQ.crg, this.cuQ.crj, this.cuQ.crh, this.cuQ.crb, this.cuQ.cqp, this.cuQ.crm, this.cuQ.crk, this.cuQ.cri);
            this.cvo = PeerConnectionClient.agl();
            if (this.cuu) {
                if (this.cuo == null) {
                    this.cuo = new com.baidu.cloudbase.a.a();
                }
                this.cuo.aT(false);
                if (this.cuU < 0) {
                    this.cuU = this.cuo.uD();
                }
                this.cuo.uE();
                this.cuo.aS(false);
                this.cuo.aR(false);
                this.cuo.a(this.cuP);
            }
            if (this.cva != null || this.cuu) {
                this.cvo.a(this.cvb);
            }
            if (this.cuW != null || this.cuu) {
                this.cvo.a(this.cuX);
            }
            if (this.cuQ != null) {
                this.cvk.em(this.cuQ.HasAudio);
                this.cvo.em(this.cuQ.HasAudio);
                this.cvk.eo(this.cuQ.HasVideo);
                this.cvo.eo(this.cuQ.HasVideo);
                this.cvk.en(this.cuQ.HasData);
                this.cvo.en(this.cuQ.HasData);
                this.cvo.hy(this.cuQ.AudioFrequency);
                this.cvo.setAudioChannel(this.cuQ.AudioChannel);
                this.cvk.hz(this.cuQ.ConnectionTimeoutMs);
                this.cvk.hA(this.cuQ.ReadTimeoutMs);
                this.cvk.et(this.cuQ.AutoPublish);
                this.cvk.eu(this.cuQ.AutoSubScribe);
            }
            this.cvo.el(this.cuC);
            this.cvo.ek(cpJ);
            this.cvo.a(this.mContext.get(), this.cpN, this);
            this.cvk.L(this.cuI, this.cuB);
            Log.i("BRTC", "loginRtcRoomWithRoomName: this " + this + " version: " + version());
            return true;
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public boolean logoutRtcRoom() {
        if (this.cvo != null) {
            this.cvo.ej(false);
            this.cvo.ep(false);
            this.cvo.agn();
            this.cvk.Df();
            this.cvk.finalize();
            this.cvo.close();
            if (this.cus != null) {
                this.cus.pause();
            }
            this.cuw.clear();
            this.cvo = null;
            this.cvk = null;
            if (this.cuo != null) {
                this.cuo.a(null);
                this.cuo.release();
            }
            if (this.cuN != null) {
                this.cuN.release();
                this.cuN = null;
            }
            if (this.cuV != null) {
                for (int i = 0; i < this.cuV.length; i++) {
                    if (this.cuV[i] != null) {
                        this.cuV[i].release();
                        this.cuV[i] = null;
                    }
                }
            }
            ahg();
            ahh();
            if (this.cvq != null) {
                this.cvq.release();
            }
            if (this.audioManager != null && this.audioManager.isBluetoothScoOn()) {
                c((Boolean) false);
            }
            if (this.cuy != null) {
                this.mContext.get().unregisterReceiver(this.cuy);
                this.cuy = null;
            }
            System.gc();
        }
        return true;
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void muteMicphone(boolean z) {
        if (this.cvo != null) {
            this.cvo.ej(!z);
        }
        kD("MUTE_MICPHONE");
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void onIceCandidatesRemoved(IceCandidate[] iceCandidateArr) {
    }

    public void presetLoudSpeaker(boolean z) {
        ((AudioManager) this.mContext.get().getSystemService("audio")).setSpeakerphoneOn(z);
        kD("PRESETLOUDSPEAKER");
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void sendMessageToUser(String str, long j) {
        if (this.cvk == null) {
            return;
        }
        this.cvk.sendMessageToUser(str, j);
        try {
            Thread.sleep(10L);
        } catch (InterruptedException e) {
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void setExternalSurface(long j, Surface surface) {
        j bO = bO(j);
        if (bO != null) {
            if (!bO.ags()) {
                bO.init();
                bO.eq(true);
            }
            for (Long l : this.cvg.keySet()) {
                j jVar = this.cvg.get(l);
                if (jVar != null && jVar.hasSurface() && surface == jVar.getSurface() && this.cup != null) {
                    Log.d("BaiduRtcRoomImp", "Set surface repeat with userId " + j);
                    this.cup.onErrorInfoUpdate(600);
                    return;
                }
            }
            bO.setSurface(surface);
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void setUserAttribute(String str) {
        if (this.cvk == null) {
            return;
        }
        this.cvk.setUserAttribute(str);
        try {
            Thread.sleep(10L);
        } catch (InterruptedException e) {
        }
    }
}
