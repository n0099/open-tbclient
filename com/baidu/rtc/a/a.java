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
import com.baidu.platform.comapi.UIMsg;
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
/* loaded from: classes10.dex */
public class a extends BaiduRtcRoom implements PeerConnectionClient.b, c {
    public static boolean cwO = false;
    static int czp = -1;
    public static int czq = 30;
    private static ConcurrentHashMap<String, String> czr = new ConcurrentHashMap<>();
    public static int czs = 1;
    d cAA;
    private Context cAm;
    private VideoSink cAs;
    private p cAt;
    private EglBase cAz;
    com.baidu.rtc.b.a czC;
    C0333a czH;
    private boolean czP;
    BaiduRtcRoom.RtcLiveTransferMode czU;
    private int czt;
    private Boolean czx;
    private com.baidu.cloudbase.a.a czz;
    String mAppId;
    private WeakReference<Context> mContext;
    private String mCpuType;
    String mDisplayName;
    String mRoomName;
    long mUserId;
    private boolean czM = false;
    private boolean czL = false;
    private boolean czD = false;
    private volatile PeerConnectionClient cAx = null;
    private PeerConnectionClient.c cwS = null;
    private RTCVideoView czW = null;
    private RTCVideoView[] cAe = null;
    private VideoCapturer cxb = null;
    private String czR = "wss://rtc2.exp.bcelive.com/janus";
    private int cAi = 0;
    private boolean cAq = true;
    private boolean[] czG = new boolean[czq];
    private AudioManager audioManager = null;
    private int cAd = -1;
    BaiduRtcRoom.a czA = null;
    g.d cAj = null;
    g.c cAf = null;
    g.b czX = null;
    private ConcurrentHashMap<Long, j> cAp = new ConcurrentHashMap<>();
    private IdentityHashMap<Long, j> cAa = new IdentityHashMap<>();
    private boolean cAr = false;
    int czB = czp;
    private RtcParameterSettings czZ = new RtcParameterSettings();
    private Handler mHandler = new Handler(Looper.getMainLooper());
    BigInteger cAb = null;
    volatile long czT = 0;
    volatile long czS = 0;
    ConcurrentHashMap<BigInteger, BigInteger> czE = new ConcurrentHashMap<>();
    boolean cAu = true;
    double cAw = 200.0d;
    boolean czO = false;
    boolean czN = false;
    String cAc = "online";
    private ConcurrentHashMap<BigInteger, com.baidu.rtc.b.b> czF = new ConcurrentHashMap<>();
    boolean cAv = false;
    boolean czI = true;
    boolean czJ = true;
    boolean czK = false;
    Boolean czu = false;
    Boolean czv = false;
    String czV = "";
    private boolean czy = false;
    private ConcurrentHashMap<BigInteger, b> cAh = new ConcurrentHashMap<>();
    private Thread cAn = null;
    private boolean czQ = false;
    private String cAo = "";
    private com.baidu.cloudbase.b.c cAl = new c.a() { // from class: com.baidu.rtc.a.a.1
        @Override // com.baidu.cloudbase.b.c
        public void U(String str, String str2) {
            Log.d("BaiduRtcRoomImp", "Be successful to download so!");
            String str3 = com.baidu.cloudbase.b.b.aa(a.this.cAm) + File.separator + "libjingle_peerconnection_so.so";
            Log.d("BaiduRtcRoomImp", "RTC so path is: " + str3);
            a.this.czQ = true;
            if (com.baidu.cloudbase.b.a.ab(a.this.cAm).dt(com.baidu.cloudbase.b.b.aa(a.this.cAm))) {
                try {
                    System.load(str3);
                    Log.d("BaiduRtcRoomImp", "loaded so, and start to login room.");
                    a.this.loginRtcRoomWithRoomName(a.this.mRoomName, a.this.mUserId, a.this.mDisplayName, a.this.czJ, a.this.czI);
                    return;
                } catch (Throwable th) {
                    Log.d("BaiduRtcRoomImp", "Failed call System.load to load so! Error: " + th);
                    if (a.this.czA != null) {
                        a.this.czA.onErrorInfoUpdate(401);
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
                a.this.loginRtcRoomWithRoomName(a.this.mRoomName, a.this.mUserId, a.this.mDisplayName, a.this.czJ, a.this.czI);
            } catch (Throwable th2) {
                Log.d("BaiduRtcRoomImp", "Failed to load so with full path! Error: " + th2);
                if (a.this.czA != null) {
                    a.this.czA.onErrorInfoUpdate(401);
                }
            }
        }

        @Override // com.baidu.cloudbase.b.c
        public void b(String str, int i, String str2) {
            Log.d("BaiduRtcRoomImp", "Failed to download so.");
            if (a.this.czA != null) {
                a.this.czA.onErrorInfoUpdate(400);
            }
        }
    };
    JavaAudioDeviceModule.SamplesReadyCallback cAk = new JavaAudioDeviceModule.SamplesReadyCallback() { // from class: com.baidu.rtc.a.a.16
        @Override // org.webrtc.audio.JavaAudioDeviceModule.SamplesReadyCallback
        public void onWebRtcAudioRecordSamplesReady(JavaAudioDeviceModule.AudioSamples audioSamples) {
            if (audioSamples == null || audioSamples.getData() == null || audioSamples.getData().length <= 0) {
                return;
            }
            if (a.this.cAj != null) {
                a.this.cAj.a(new g(audioSamples.getAudioFormat(), audioSamples.getChannelCount(), audioSamples.getSampleRate(), audioSamples.getData()));
            }
            if (!a.this.czD || a.this.czL) {
                return;
            }
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            bufferInfo.size = audioSamples.getData().length;
            bufferInfo.offset = 0;
            a.this.czz.a(ByteBuffer.wrap(audioSamples.getData()), bufferInfo);
        }
    };
    JavaAudioDeviceModule.RemoteSamplesReadyCallback cAg = new JavaAudioDeviceModule.RemoteSamplesReadyCallback() { // from class: com.baidu.rtc.a.a.17
        @Override // org.webrtc.audio.JavaAudioDeviceModule.RemoteSamplesReadyCallback
        public void onWebRtcAudioRemoteSamplesReady(JavaAudioDeviceModule.AudioSamples audioSamples) {
            if (audioSamples == null) {
                return;
            }
            if (a.this.cAf != null) {
                a.this.cAf.c(new g(audioSamples.getAudioFormat(), audioSamples.getChannelCount(), audioSamples.getSampleRate(), audioSamples.getData()));
            }
            if (!a.this.czD || a.this.cAd < 0) {
                return;
            }
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            bufferInfo.size = audioSamples.getData().length;
            bufferInfo.offset = 0;
            a.this.czz.a(ByteBuffer.wrap(audioSamples.getData()), bufferInfo, a.this.cAd);
        }
    };
    g.a czw = new g.a() { // from class: com.baidu.rtc.a.a.18
    };
    private com.baidu.cloudbase.c.a czY = new com.baidu.cloudbase.c.a() { // from class: com.baidu.rtc.a.a.19
        @Override // com.baidu.cloudbase.c.a
        public void onFilteredFrameUpdate(byte[] bArr, MediaCodec.BufferInfo bufferInfo) {
            if (a.this.czX != null) {
                a.this.czX.b(new g(2, a.this.czZ.AudioChannel, a.this.czZ.AudioFrequency, bArr));
            }
        }
    };
    private Runnable cAy = new Runnable() { // from class: com.baidu.rtc.a.a.13
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.cAA != null && (a.this.czO || a.this.czN)) {
                a.this.aiA();
            }
            a.this.mHandler.postDelayed(a.this.cAy, 300000L);
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.rtc.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C0333a extends BroadcastReceiver {
        C0333a() {
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
                                if (s == a.this.czt) {
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

    /* loaded from: classes10.dex */
    public static class b {
        public Boolean cAK;
        public Boolean cAL;
        public BigInteger cwh;
        public String nickName;
        public long userId;
        public int volume = -1;

        public b(BigInteger bigInteger, long j, Boolean bool, Boolean bool2, String str) {
            this.nickName = "";
            this.cwh = bigInteger;
            this.userId = j;
            this.cAK = bool2;
            this.cAL = bool;
            this.nickName = str;
        }
    }

    public a(Context context, String str, String str2, String str3, boolean z) {
        this.mContext = null;
        this.cAt = null;
        this.cAz = null;
        this.czH = null;
        this.czP = false;
        this.mCpuType = "armeabi-v7a";
        this.cAm = null;
        this.czP = z;
        this.cAm = context;
        this.mContext = new WeakReference<>(context);
        this.mCpuType = str3;
        this.cAt = new p();
        this.cAt.setAppId(str);
        this.cAt.kv(str2);
        this.cAt.ku("BRTC.Android.SDK V" + version());
        this.mAppId = str;
        this.cAt.a(this);
        this.cAz = EglBase_CC.create();
        for (int i = 0; i < this.czG.length; i++) {
            this.czG[i] = false;
        }
        AudioManager audioManager = (AudioManager) this.mContext.get().getSystemService("audio");
        audioManager.setSpeakerphoneOn(false);
        if (this.czO || this.czN) {
            this.czC = new com.baidu.rtc.b.a(context);
            this.cAA = d.aiP();
        }
        this.czt = 0;
        this.czx = false;
        audioManager = audioManager == null ? (AudioManager) this.mContext.get().getSystemService("audio") : audioManager;
        this.czH = new C0333a();
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
        this.mContext.get().registerReceiver(this.czH, intentFilter);
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
        if (this.czB == czp || this.czB >= deviceNames.length || (createCapturer3 = cameraEnumerator.createCapturer(deviceNames[this.czB], null)) == null) {
            Log.d("BaiduRtcRoomImp", "Looking for front facing cameras.");
            for (String str : deviceNames) {
                if (cameraEnumerator.isFrontFacing(str)) {
                    Log.d("BaiduRtcRoomImp", "Creating front facing camera capturer.");
                    if (!czr.containsValue(str) && (createCapturer2 = cameraEnumerator.createCapturer(str, null)) != null) {
                        czr.put(toString(), str);
                        this.cAr = true;
                        if (this.czW != null) {
                            this.czW.setMirror(true);
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
                    if (!czr.containsValue(str2) && (createCapturer = cameraEnumerator.createCapturer(str2, null)) != null) {
                        czr.put(toString(), str2);
                        this.cAr = false;
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
        if (this.cAt == null) {
            return;
        }
        if (bigInteger == this.cAb) {
            k = BigInteger.valueOf(this.mUserId);
        } else {
            k = this.cAt.k(bigInteger);
            if (k == null) {
                return;
            }
        }
        b bVar = this.cAh.get(k);
        if (bVar == null && this.cAx != null) {
            this.cAx.a(false, 0, bigInteger, PeerConnectionClient.StatsEventsType.GET_AUDIOLEVEL_EVENT);
            return;
        }
        for (StatsReport statsReport : statsReportArr) {
            if (bigInteger == this.cAb) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void aiA() {
        if (this.cAt == null) {
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
            jSONObject.put("env", this.cAc);
            jSONObject.put("appId", this.mAppId);
            if (this.cAt != null) {
                jSONObject.put("roomId", this.cAt.getRoomId());
            }
            jSONObject.put("timestamp", System.currentTimeMillis());
            jSONObject.put(TbEnum.SystemMessage.KEY_USER_ID, this.mUserId);
            jSONObject.put("message", jSONObject3);
        } catch (JSONException e) {
            Log.e("BaiduRtcRoomImp", "Caught error on reportDeviceInfo: " + e);
        }
        this.cAA.report(jSONObject.toString(), 0);
    }

    private boolean aiB() {
        Camera2Enumerator.disableExtraCamera(this.czZ.cyj);
        return Camera2Enumerator.isSupported(this.mContext.get());
    }

    private boolean aiv() {
        return !Build.MODEL.contains("SABRESD-MX6DQ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public VideoCapturer aiw() {
        VideoCapturer a2;
        if (this.cxb != null) {
            return this.cxb;
        }
        if (aiB()) {
            Log.d("BaiduRtcRoomImp", "Creating capturer using camera2 API.");
            a2 = a(new Camera2Enumerator(this.mContext.get()));
        } else {
            Log.d("BaiduRtcRoomImp", "Creating capturer using camera1 API.");
            a2 = a(new Camera1Enumerator(aiv()));
        }
        if (a2 == null) {
            Log.e("BaiduRtcRoomImp", "Failed to open camera");
            return null;
        }
        return a2;
    }

    private void aix() {
        if (this.cAp.isEmpty()) {
            return;
        }
        for (Long l : this.cAp.keySet()) {
            j jVar = this.cAp.get(l);
            if (jVar != null) {
                if (jVar.getSurface() != null) {
                    jVar.releaseSurface();
                }
                jVar.release();
            }
            this.cAp.remove(l);
        }
    }

    private void aiy() {
        synchronized (this) {
            if (this.cAa.isEmpty()) {
                return;
            }
            for (j jVar : this.cAa.values()) {
                if (jVar != null) {
                    if (jVar.getSurface() != null) {
                        jVar.releaseSurface();
                    }
                    jVar.release();
                }
            }
            this.cAa.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiz() {
        com.baidu.rtc.b.b bVar;
        if (this.cAt == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        boolean z = true;
        com.baidu.rtc.b.b bVar2 = this.czF.get(this.cAb);
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
            if (this.czC != null) {
                jSONObject3.put("sysCpuUsage", this.czC.aiJ());
            }
            jSONObject3.put("appCpuUsage", 0);
            jSONObject2.put("resourceUsageInfo", jSONObject3);
            if (this.czO) {
                JSONObject jSONObject4 = new JSONObject();
                if (z2) {
                    jSONObject4.put(KsMediaMeta.KSM_KEY_BITRATE, hashMap.get("bitrate_s"));
                    jSONObject4.put("packetloss", hashMap.get("packetloss_s"));
                    jSONObject4.put("cfps", hashMap.get("fps_s"));
                    jSONObject4.put(AlaRecorderLog.KEY_CANERA_START_FPS, hashMap.get("fps_i"));
                    if (bVar2 == null) {
                        jSONObject4.put("resolution", "");
                    } else {
                        jSONObject4.put("resolution", bVar2.aiN());
                    }
                } else {
                    jSONObject4.put(KsMediaMeta.KSM_KEY_BITRATE, 0);
                    jSONObject4.put("packetloss", 0);
                    jSONObject4.put(AlaRecorderLog.KEY_CANERA_START_FPS, 0);
                    jSONObject4.put("resolution", "");
                }
                jSONObject2.put("senderQualityInfo", jSONObject4);
            }
            if (this.czN) {
                JSONArray jSONArray = new JSONArray();
                for (BigInteger bigInteger : this.czF.keySet()) {
                    if (bigInteger != this.cAb && (bVar = this.czF.get(bigInteger)) != null) {
                        HashMap hashMap2 = new HashMap();
                        bVar.u(hashMap2);
                        if (hashMap2.size() != 0) {
                            JSONObject jSONObject5 = new JSONObject();
                            if (this.cAt != null) {
                                jSONObject5.put("feedId", this.cAt.k(bigInteger));
                            }
                            jSONObject5.put(KsMediaMeta.KSM_KEY_BITRATE, hashMap2.get("bitrate_r"));
                            jSONObject5.put("packetloss", hashMap2.get("packetloss_r"));
                            jSONObject5.put(AlaRecorderLog.KEY_CANERA_START_FPS, hashMap2.get("fps_r"));
                            jSONObject5.put("resolution", bVar.aiM());
                            jSONArray.put(jSONObject5);
                        }
                    }
                }
                jSONObject2.put("receiverQualityInfoList", jSONArray);
            }
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put("communicationQualityInfo", jSONObject2);
            jSONObject.put("env", this.cAc);
            jSONObject.put("appId", this.mAppId);
            if (this.cAt != null) {
                jSONObject.put("roomId", this.cAt.getRoomId());
            }
            jSONObject.put("timestamp", System.currentTimeMillis());
            jSONObject.put(TbEnum.SystemMessage.KEY_USER_ID, this.mUserId);
            jSONObject.put("message", jSONObject6);
        } catch (JSONException e) {
            Log.e("BaiduRtcRoomImp", "Caught error on reportCommunicationQualityInfo: " + e);
        }
        this.cAA.report(jSONObject.toString(), 2);
    }

    private void bO(long j) {
        synchronized (this) {
            if (this.cAp.containsKey(Long.valueOf(j))) {
                this.cAa.put(Long.valueOf(j), this.cAp.get(Long.valueOf(j)));
                this.cAp.remove(Long.valueOf(j));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int d(Boolean bool) {
        if (this.czx == bool) {
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
            this.czx = bool;
            return 0;
        } catch (Exception e) {
            Log.e("BaiduRtcRoomImp", "set bluetooth sco fail: " + e.getMessage());
            return -1;
        }
    }

    public static void eq(boolean z) {
        cwO = z;
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
    public void kw(String str) {
        if ((this.czO || this.czN) && this.cAt != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(TbEnum.SystemMessage.KEY_USER_NAME, this.mDisplayName);
                jSONObject2.put("eventDescription", str);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("roomEvent", jSONObject2);
                jSONObject.put("env", this.cAc);
                jSONObject.put("appId", this.mAppId);
                if (this.cAt != null) {
                    jSONObject.put("roomId", this.cAt.getRoomId());
                }
                jSONObject.put("timestamp", System.currentTimeMillis());
                jSONObject.put(TbEnum.SystemMessage.KEY_USER_ID, this.mUserId);
                jSONObject.put("message", jSONObject3);
            } catch (JSONException e) {
                Log.e("BaiduRtcRoomImp", "Caught error on reportRoomEventInfo: " + e);
            }
            this.cAA.report(jSONObject.toString(), 1);
        }
    }

    private void n(final BigInteger bigInteger) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.rtc.a.a.11
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.czZ.HasVideo) {
                    a.this.cxb = a.this.aiw();
                }
                if (a.this.cAx == null) {
                    Log.e("BaiduRtcRoomImp", "peerConnectionClient is null!");
                    return;
                }
                if (a.this.czM) {
                    a.this.cAx.a(a.this.cAz.getEglBaseContext(), a.this.cAs, a.this.cxb, bigInteger);
                } else {
                    a.this.cAx.a(a.this.cAz.getEglBaseContext(), a.this.czW, a.this.cxb, bigInteger);
                }
                a.this.cAx.i(bigInteger);
            }
        });
    }

    static /* synthetic */ int s(a aVar) {
        int i = aVar.czt + 1;
        aVar.czt = i;
        return i;
    }

    static /* synthetic */ int t(a aVar) {
        int i = aVar.czt;
        aVar.czt = i + 1;
        return i;
    }

    public static String version() {
        return "1.2.13_20201120";
    }

    @Override // com.baidu.rtc.c
    public void a(BaiduRtcRoom.RtcLiveTransferMode rtcLiveTransferMode, String str) {
        if (this.czA == null) {
            return;
        }
        this.czA.onRoomEventUpdate(117, rtcLiveTransferMode.ordinal(), str);
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
                    this.czZ = rtcParameterSettings;
                    czs = this.czZ.AudioContentType;
                    return;
                }
                return;
            case RTC_VIDEO_PARAM_SETTINGS_BITRATE:
                this.czZ.VideoMaxkbps = rtcParameterSettings.VideoMaxkbps;
                if (this.cAx == null || this.mHandler == null) {
                    return;
                }
                this.mHandler.post(new Runnable() { // from class: com.baidu.rtc.a.a.10
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.cAx == null || a.this.czZ.VideoMaxkbps <= 0) {
                            return;
                        }
                        Log.d("BaiduRtcRoomImp", "Set video maximum bitrate: " + a.this.czZ.VideoMaxkbps);
                        a.this.cAx.d(Integer.valueOf(a.this.czZ.VideoMaxkbps));
                    }
                });
                return;
            case RTC_VIDEO_PARAM_SETTINGS_RENDER_MODE:
                this.czZ.cyr = rtcParameterSettings.cyr;
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void a(g.d dVar) {
        this.cAj = dVar;
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void a(i iVar) {
        this.cxb = iVar;
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void a(final Boolean bool, final Boolean bool2, final BigInteger bigInteger) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.rtc.a.a.7
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.cAt == null) {
                    return;
                }
                BigInteger k = a.this.cAt.k(bigInteger);
                String l = a.this.cAt.l(k);
                b bVar = (b) a.this.cAh.get(k);
                if (bVar == null) {
                    bVar = new b(bigInteger, k.longValue(), bool, bool2, l);
                    a.this.cAh.put(k, bVar);
                } else {
                    bVar.cAL = bool;
                    bVar.cAK = bool2;
                    bVar.cwh = bigInteger;
                    bVar.nickName = l;
                }
                if (!bool2.booleanValue() || a.this.cAx == null) {
                    return;
                }
                a.this.cAx.a(true, 200, bVar.cwh, PeerConnectionClient.StatsEventsType.GET_AUDIOLEVEL_EVENT);
            }
        });
    }

    @Override // com.baidu.rtc.c
    public void a(BigInteger bigInteger, int i, boolean z) {
        if (this.czA == null) {
            return;
        }
        this.czA.onPeerConnectStateUpdate(z ? 2001 : 2002);
    }

    @Override // com.baidu.rtc.c
    public void a(BigInteger bigInteger, String str) {
        if (this.czA == null) {
            return;
        }
        this.czA.onRoomEventUpdate(303, bigInteger.longValue(), str);
    }

    @Override // com.baidu.rtc.c
    public void a(BigInteger bigInteger, String str, String str2) {
        if (this.czA == null) {
            return;
        }
        this.czA.onRoomEventUpdate(300, bigInteger.longValue(), str);
    }

    @Override // com.baidu.rtc.c
    public void a(final BigInteger bigInteger, final BigInteger bigInteger2) {
        int i;
        Log.i("BaiduRtcRoomImp", "==================onLeaving=======================");
        this.mHandler.post(new Runnable() { // from class: com.baidu.rtc.a.a.4
            @Override // java.lang.Runnable
            public void run() {
                a.this.cAh.remove(bigInteger2);
                if (a.this.czF.get(bigInteger) != null) {
                    a.this.czF.remove(bigInteger);
                    if (a.this.cAx != null) {
                        a.this.cAx.a(false, 0, bigInteger, PeerConnectionClient.StatsEventsType.GET_QUALITY_MONITOR_EVENT);
                    }
                }
            }
        });
        com.baidu.rtc.a j = this.cAx.j(bigInteger);
        if (this.czZ.cyr == RtcParameterSettings.RtcVideoRenderMode.RTC_VIDEO_RENDER_MODE_EXTERNAL) {
            j jVar = this.cAp.get(Long.valueOf(bigInteger2.longValue()));
            if (jVar == null || j == null) {
                Log.d("BaiduRtcRoomImp", "No external render has found!");
            } else {
                Log.d("BaiduRtcRoomImp", "remove external video sink of user " + bigInteger2);
                jVar.clearImage();
                if (j.cwl != null) {
                    j.cwl.removeSink(jVar);
                }
                bO(bigInteger2.longValue());
                if (this.czA != null) {
                    if (this.czS == bigInteger2.longValue()) {
                        return;
                    }
                    this.czA.onRoomEventUpdate(107, bigInteger2.longValue(), "gone");
                    this.czS = bigInteger2.longValue();
                    return;
                }
            }
        }
        if (j != null && (i = j.cwm) >= 0 && i < this.czG.length) {
            this.czG[i] = false;
            this.cAi--;
            if (this.cAe[i] != null) {
                this.cAe[i].clearImage();
                if (j.cwl != null) {
                    j.cwl.removeSink(this.cAe[i]);
                }
                if (this.czA != null) {
                    if (this.czS != bigInteger2.longValue()) {
                        this.czA.onRoomEventUpdate(107, bigInteger2.longValue(), "gone");
                        this.czS = bigInteger2.longValue();
                        return;
                    }
                    return;
                }
            }
        }
        if (this.czA != null) {
            if (this.czT == bigInteger2.longValue()) {
                return;
            }
            this.czE.remove(bigInteger2);
            this.czA.onRoomEventUpdate(105, bigInteger2.longValue(), "leaving");
        }
        this.czT = bigInteger2.longValue();
        kw("REMOTE_LEAVING_" + bigInteger2 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + bigInteger);
    }

    @Override // com.baidu.rtc.c
    public void a(BigInteger bigInteger, JSONObject jSONObject) {
        SessionDescription.Type fromCanonicalForm = SessionDescription.Type.fromCanonicalForm(jSONObject.optString("type"));
        String optString = jSONObject.optString("sdp");
        if (this.czZ.cyl && this.czy && optString.contains("profile-level-id=42e01f")) {
            optString = optString.replace("profile-level-id=42e01f", "profile-level-id=640c1f");
            Log.e("BaiduRtcRoomImp", "enable high profile, remote jsep changed: " + optString);
        }
        this.cAx.a(bigInteger, new SessionDescription(fromCanonicalForm, optString));
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void a(IceCandidate iceCandidate, BigInteger bigInteger) {
        Log.e("BaiduRtcRoomImp", "=========onIceCandidate========");
        if (iceCandidate != null) {
            this.cAt.a(bigInteger, iceCandidate);
        } else {
            this.cAt.m(bigInteger);
        }
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void a(SessionDescription sessionDescription, BigInteger bigInteger) {
        Log.e("BaiduRtcRoomImp", sessionDescription.type.toString());
        this.cAt.d(bigInteger, sessionDescription);
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void a(SessionDescription sessionDescription, BigInteger bigInteger, boolean z) {
        Log.e("BaiduRtcRoomImp", sessionDescription.type.toString());
        if (this.cAt == null) {
            return;
        }
        this.czy = z;
        this.cAt.c(bigInteger, sessionDescription);
        this.mHandler.post(new Runnable() { // from class: com.baidu.rtc.a.a.5
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.cAx == null || a.this.cwS.cxP <= 0) {
                    return;
                }
                Log.d("BaiduRtcRoomImp", "Set video maximum bitrate: " + a.this.cwS.cxP);
                a.this.cAx.d(Integer.valueOf(a.this.cwS.cxP));
            }
        });
    }

    public void a(StatsReport[] statsReportArr) {
        StatsReport.Value[] valueArr;
        if (this.czA == null) {
            return;
        }
        for (StatsReport statsReport : statsReportArr) {
            if (statsReport.id.equals("bweforvideo")) {
                for (StatsReport.Value value : statsReport.values) {
                    if (value.name.equals("googAvailableSendBandwidth")) {
                        this.cAw = Double.parseDouble(value.value);
                        if (this.cAw > 100.0d) {
                            this.czA.onRoomEventUpdate(200, (long) this.cAw, statsReport.toString());
                        }
                    }
                }
                return;
            }
        }
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void a(final StatsReport[] statsReportArr, final BigInteger bigInteger, final PeerConnectionClient.StatsEventsType statsEventsType) {
        if (bigInteger == this.cAb && statsEventsType == PeerConnectionClient.StatsEventsType.GET_BWE_EVENT && this.cAu) {
            a(statsReportArr);
        }
        this.mHandler.post(new Runnable() { // from class: com.baidu.rtc.a.a.6
            @Override // java.lang.Runnable
            public void run() {
                if (statsEventsType == PeerConnectionClient.StatsEventsType.GET_AUDIOLEVEL_EVENT) {
                    a.this.a(statsReportArr, bigInteger);
                }
                if ((a.this.czO || a.this.czN) && statsEventsType == PeerConnectionClient.StatsEventsType.GET_QUALITY_MONITOR_EVENT) {
                    com.baidu.rtc.b.b bVar = (com.baidu.rtc.b.b) a.this.czF.get(bigInteger);
                    if (bVar != null) {
                        bVar.b(statsReportArr);
                    }
                    if (bigInteger != a.this.cAb || a.this.cAA == null) {
                        return;
                    }
                    a.this.aiz();
                }
            }
        });
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public boolean a(BaiduRtcRoom.a aVar) {
        this.czA = aVar;
        return true;
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public boolean a(String str, boolean z, boolean z2, String str2, BaiduRtcRoom.RtcLiveTransferMode rtcLiveTransferMode) {
        if (this.czV.isEmpty() || this.czU == rtcLiveTransferMode) {
            this.czV = str;
            this.czU = rtcLiveTransferMode;
            this.cAt.eF(z2);
            this.cAt.kr(str);
            this.cAt.eE(z);
            this.cAt.kq(str2);
            this.cAt.a(rtcLiveTransferMode);
        } else {
            this.cAt.b(str, z, z2, str2, rtcLiveTransferMode);
        }
        return true;
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public BaiduRtcRoom.c[] ahZ() {
        int i = 0;
        int i2 = 0;
        for (BigInteger bigInteger : this.cAh.keySet()) {
            b bVar = this.cAh.get(bigInteger);
            if (bVar != null && bVar.cAK.booleanValue() && bVar.volume != -1) {
                i2++;
            }
        }
        BaiduRtcRoom.c[] cVarArr = new BaiduRtcRoom.c[i2];
        for (BigInteger bigInteger2 : this.cAh.keySet()) {
            b bVar2 = this.cAh.get(bigInteger2);
            if (bVar2 != null && bVar2.volume != -1 && bVar2.cAK.booleanValue()) {
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
    public BaiduRtcRoom.d[] aia() {
        if (this.cAt == null) {
            return null;
        }
        return this.cAt.aiu();
    }

    @Override // com.baidu.rtc.c
    public void aib() {
        if (this.czA == null) {
            return;
        }
        this.czA.onRoomEventUpdate(103, 0L, "coennection Error");
        kw("CONNECTION_LOST");
    }

    @Override // com.baidu.rtc.c
    public void aic() {
        if (this.czA == null) {
            return;
        }
        this.czA.onRoomEventUpdate(102, 0L, BdStatsConstant.StatsType.ERROR);
        kw("LOGIN_ERROR");
    }

    @Override // com.baidu.rtc.c
    public void aid() {
        if (this.czA == null) {
            return;
        }
        this.czA.onRoomEventUpdate(101, 0L, "time out");
    }

    @Override // com.baidu.rtc.c
    public void aie() {
        if (this.czA == null) {
            return;
        }
        this.czA.onRoomEventUpdate(112, 0L, "");
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void ail() {
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void aim() {
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void ain() {
        if (this.czA != null) {
            this.czA.onPeerConnectStateUpdate(2003);
        }
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void aio() {
    }

    @Override // com.baidu.rtc.c
    public void b(BaiduRtcRoom.RtcLiveTransferMode rtcLiveTransferMode, String str) {
        if (this.czA == null) {
            return;
        }
        this.czA.onRoomEventUpdate(118, rtcLiveTransferMode.ordinal(), str);
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void b(com.baidu.rtc.a aVar) {
        int i;
        Log.e("BaiduRtcRoomImp", "=========onRemoteRender========" + aVar.cwl);
        final BigInteger k = this.cAt.k(aVar.cwh);
        if (k.longValue() == 0) {
            Log.e("BaiduRtcRoomImp", "onRemoteRender Userid is 0.");
        } else if (this.czZ.cyr == RtcParameterSettings.RtcVideoRenderMode.RTC_VIDEO_RENDER_MODE_EXTERNAL) {
            j bP = bP(k.longValue());
            Log.d("BaiduRtcRoomImp", "enable external video render mode with videoRenderer -> " + bP);
            if (bP != null) {
                aVar.cwl.addSink(bP);
            } else {
                Log.d("BaiduRtcRoomImp", "Not found external render for user " + k);
            }
            this.czA.onRoomEventUpdate(106, k.longValue(), "");
        } else {
            Log.d("BaiduRtcRoomImp", "it is internal video render mode");
            try {
                i = this.czE.get(this.cAt.k(aVar.cwh)).intValue();
            } catch (Exception e) {
                i = -1;
            }
            if (i >= 0 && i < czq && this.cAe != null) {
                if (this.cAe[i] != null) {
                    this.cAe[i].setFirstFrameEventListener(new Runnable() { // from class: com.baidu.rtc.a.a.8
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.czA != null) {
                                a.this.czA.onRoomEventUpdate(106, k.longValue(), "");
                            }
                        }
                    });
                    aVar.cwl.addSink(this.cAe[i]);
                }
                aVar.cwm = i;
            } else if (this.cAe != null) {
                int i2 = 0;
                while (true) {
                    if (i2 >= this.czG.length) {
                        i2 = -1;
                        break;
                    } else if (!this.czG[i2]) {
                        this.czG[i2] = true;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i2 >= 0) {
                    if (this.cAe[i2] != null) {
                        this.cAe[i2].setFirstFrameEventListener(new Runnable() { // from class: com.baidu.rtc.a.a.9
                            @Override // java.lang.Runnable
                            public void run() {
                                if (a.this.czA != null) {
                                    a.this.czA.onRoomEventUpdate(106, k.longValue(), "");
                                }
                            }
                        });
                        aVar.cwl.addSink(this.cAe[i2]);
                    }
                    aVar.cwm = i2;
                }
                this.cAi++;
            }
        }
    }

    @Override // com.baidu.rtc.c
    public void b(BigInteger bigInteger) {
        if (this.czA == null) {
            return;
        }
        this.czA.onPeerConnectStateUpdate(2003);
    }

    @Override // com.baidu.rtc.c
    public void b(BigInteger bigInteger, String str) {
        if (this.czT == bigInteger.longValue()) {
            this.czT = 0L;
        }
        if (this.czS == bigInteger.longValue()) {
            this.czS = 0L;
        }
        if (this.czA == null) {
            return;
        }
        this.czA.onRoomEventUpdate(104, bigInteger.longValue(), str);
    }

    @Override // com.baidu.rtc.c
    public void b(final BigInteger bigInteger, JSONObject jSONObject) {
        this.cAx.b(bigInteger, new SessionDescription(SessionDescription.Type.fromCanonicalForm(jSONObject.optString("type")), jSONObject.optString("sdp")));
        this.mHandler.post(new Runnable() { // from class: com.baidu.rtc.a.a.3
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.czN || bigInteger == a.this.cAb || a.this.cAx == null) {
                    return;
                }
                if (a.this.czF.get(bigInteger) != null) {
                    a.this.cAx.a(false, 0, bigInteger, PeerConnectionClient.StatsEventsType.GET_QUALITY_MONITOR_EVENT);
                    a.this.czF.remove(bigInteger);
                }
                a.this.cAx.a(a.this.czN, 2000, bigInteger, PeerConnectionClient.StatsEventsType.GET_QUALITY_MONITOR_EVENT);
                a.this.czF.put(bigInteger, new com.baidu.rtc.b.b());
            }
        });
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void bK(long j) {
        if (this.cAt != null) {
            this.cAt.bK(j);
        }
    }

    @Override // com.baidu.rtc.c
    public void bL(long j) {
        if (this.czA == null) {
            return;
        }
        this.czA.onRoomEventUpdate(114, j, "");
    }

    @Override // com.baidu.rtc.c
    public void bM(long j) {
        if (this.czA == null) {
            return;
        }
        this.czA.onRoomEventUpdate(115, j, "");
    }

    @Override // com.baidu.rtc.c
    public void bN(long j) {
        if (this.czA == null) {
            return;
        }
        this.czA.onRoomEventUpdate(113, j, "");
    }

    public j bP(long j) {
        j kVar;
        synchronized (this) {
            Log.d("BaiduRtcRoomImp", j + " : Get external renderer.");
            if (this.cAp.containsKey(Long.valueOf(j))) {
                kVar = this.cAp.get(Long.valueOf(j));
            } else {
                kVar = new k(this.czA, j);
                Log.d("BaiduRtcRoomImp", j + " : Create external renderer" + kVar);
                this.cAp.put(Long.valueOf(j), kVar);
            }
        }
        return kVar;
    }

    public void bR(Context context) {
        Log.d("BaiduRtcRoomImp", "setup so later loading feature, and cpu type: " + this.mCpuType);
        com.baidu.cloudbase.b.a.ab(context).du(this.mCpuType);
        if (this.cAo.isEmpty()) {
            com.baidu.cloudbase.b.a.ab(context).a(com.baidu.cloudbase.b.b.uj(), true, this.cAl);
            return;
        }
        Log.d("BaiduRtcRoomImp", "setup so later load url: " + this.cAo);
        com.baidu.cloudbase.b.a.ab(context).a(this.cAo, true, this.cAl);
    }

    @Override // com.baidu.rtc.c
    public void c(BaiduRtcRoom.RtcLiveTransferMode rtcLiveTransferMode, String str) {
        if (this.czA == null) {
            return;
        }
        this.czA.onRoomEventUpdate(116, rtcLiveTransferMode.ordinal(), str);
    }

    @Override // com.baidu.rtc.c
    public void c(final BigInteger bigInteger) {
        if (this.czA != null) {
            this.czA.onRoomEventUpdate(100, 0L, "ok");
        }
        this.cAb = bigInteger;
        if (this.czZ.AutoPublish) {
            n(bigInteger);
        }
        if (this.cAu && this.cAx != null) {
            this.cAx.a(this.cAu, 5000, this.cAb, PeerConnectionClient.StatsEventsType.GET_BWE_EVENT);
        }
        this.mHandler.post(new Runnable() { // from class: com.baidu.rtc.a.a.2
            @Override // java.lang.Runnable
            public void run() {
                if ((a.this.czO || a.this.czN) && a.this.cAx != null) {
                    if (a.this.czF.get(bigInteger) != null) {
                        a.this.cAx.a(false, 0, bigInteger, PeerConnectionClient.StatsEventsType.GET_QUALITY_MONITOR_EVENT);
                        a.this.czF.remove(bigInteger);
                    }
                    a.this.cAx.a(a.this.czO || a.this.czN, 2000, bigInteger, PeerConnectionClient.StatsEventsType.GET_QUALITY_MONITOR_EVENT);
                    a.this.czF.put(bigInteger, new com.baidu.rtc.b.b());
                    if (a.this.cAA != null && !a.this.cAv) {
                        a.this.cAv = true;
                        a.this.mHandler.post(a.this.cAy);
                    }
                    a aVar = a.this;
                    aVar.kw("RTCROOM_LOGIN_OK_" + a.this.mUserId);
                }
                b bVar = (b) a.this.cAh.get(BigInteger.valueOf(a.this.mUserId));
                if (bVar != null) {
                    if (a.this.cAx != null) {
                        a.this.cAx.a(false, 0, bVar.cwh, PeerConnectionClient.StatsEventsType.GET_AUDIOLEVEL_EVENT);
                    }
                    bVar.cAL = Boolean.valueOf(a.this.czZ.HasVideo);
                    bVar.cAK = Boolean.valueOf(a.this.czZ.HasAudio);
                    bVar.cwh = bigInteger;
                    bVar.nickName = a.this.mDisplayName;
                } else {
                    a.this.cAh.put(BigInteger.valueOf(a.this.mUserId), new b(bigInteger, a.this.mUserId, Boolean.valueOf(a.this.czZ.HasVideo), Boolean.valueOf(a.this.czZ.HasAudio), a.this.mDisplayName));
                }
                if (a.this.cAx != null) {
                    a.this.cAx.a(true, 200, bigInteger, PeerConnectionClient.StatsEventsType.GET_AUDIOLEVEL_EVENT);
                }
            }
        });
    }

    @Override // com.baidu.rtc.c
    public void c(BigInteger bigInteger, String str) {
        if (this.czA == null) {
            return;
        }
        this.czA.onRoomEventUpdate(302, bigInteger.longValue(), str);
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void changeSurfaceSize(long j, int i, int i2) {
        if (this.cAp.containsKey(Long.valueOf(j))) {
            j jVar = this.cAp.get(Long.valueOf(j));
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
        if (this.cAx != null) {
            this.cAx.h(bigInteger);
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void destroyExternalSurface(long j, Surface surface) {
        j jVar;
        if (this.cAp.containsKey(Long.valueOf(j)) && (jVar = this.cAp.get(Long.valueOf(j))) != null && surface == jVar.getSurface()) {
            jVar.releaseSurface();
        }
        aiy();
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void disbandRoom() {
        if (this.cAt != null) {
            this.cAt.disbandRoom();
        }
    }

    public void doDestroy() {
        logoutRtcRoom();
        czr.remove(toString());
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void e(long j, boolean z) {
        if (this.cAt != null) {
            this.cAt.e(j, z);
        }
    }

    @Override // com.baidu.rtc.c
    public void e(BigInteger bigInteger) {
        if (this.czA == null) {
            return;
        }
        this.czA.onRoomEventUpdate(301, bigInteger.longValue(), "");
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void enableExternalVideoCapturer(boolean z) {
        this.czM = z;
        this.cAs = new VideoSink() { // from class: com.baidu.rtc.a.a.12
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
    public void er(boolean z) {
        if (this.cAx != null) {
            this.cAx.setSpeakerMute(z);
        }
    }

    @Override // com.baidu.rtc.c
    public void f(BigInteger bigInteger) {
        if (this.czA == null) {
            return;
        }
        this.czA.onPeerConnectStateUpdate(2000);
        kw("WEBRTC_UP_" + bigInteger.longValue());
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void f(boolean z, boolean z2, String str) {
        this.czO = z;
        this.czN = z2;
        this.cAc = str;
        if (!z && !z2) {
            if (this.czC != null) {
                this.czC.pause();
                return;
            }
            return;
        }
        if (this.czC == null) {
            this.czC = new com.baidu.rtc.b.a(this.cAm);
        }
        if (this.cAA == null) {
            this.cAA = d.aiP();
        }
    }

    @Override // com.baidu.rtc.c
    public void g(boolean z, int i) {
        if (this.czA == null) {
            return;
        }
        this.czA.onPeerConnectStateUpdate(i < 10 ? 2100 : i < 15 ? RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL1 : i < 25 ? RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL2 : i < 40 ? RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL3 : i < 60 ? RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL4 : i < 90 ? RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL5 : i < 120 ? RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL6 : i < 180 ? RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL7 : i < 250 ? RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL8 : RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL9);
    }

    @Override // com.baidu.rtc.c
    public void hw(int i) {
        if (this.czA != null && i == 436) {
            this.czA.onErrorInfoUpdate(RTCConst.RTC_ROOM_USERID_ALREADY_EXIST_ERROR);
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public boolean ko(String str) {
        this.cAt.ks(str);
        return true;
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void kp(String str) {
        if (this.czA != null) {
            this.czA.onErrorInfoUpdate(10000);
        }
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void l(ByteBuffer byteBuffer) {
        if (this.czA == null) {
            return;
        }
        this.czA.onRoomDataMessage(byteBuffer);
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public boolean loginRtcRoomWithRoomName(String str, long j, String str2, boolean z) {
        Log.i("BaiduRtcRoomImp", "enable force login");
        this.czK = z;
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
        this.czJ = z;
        this.czI = z2;
        if (this.czP && !this.czQ) {
            this.cAn = new Thread(new Runnable() { // from class: com.baidu.rtc.a.a.15
                @Override // java.lang.Runnable
                public void run() {
                    Log.d("BaiduRtcRoomImp", "setup downloading thread ......");
                    a.this.bR(a.this.cAm);
                }
            });
            this.cAn.start();
            return true;
        } else if (j == 0) {
            throw new InvalidParameterException("loginRtcRoomWithRoomName: Param Error,userId cann't be zero. zero is reserved.");
        } else {
            this.cAt.kt(str);
            this.cAt.setUserId(j);
            if (str2 != null && !str2.isEmpty()) {
                this.cAt.setDisplayName(str2);
            }
            this.cAt.setVideoCodec(this.czZ.VideoCodec);
            this.cAt.eB(z);
            this.cAt.eA(z2);
            int i5 = this.czZ.VideoWidth;
            int i6 = this.czZ.VideoHeight;
            String lowerCase = this.czZ.VideoResolution.toLowerCase();
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
                this.czZ.cyi = true;
                this.czv = true;
            }
            this.cwS = new PeerConnectionClient.c(false, i, i6, this.czZ.VideoFps, this.czZ.VideoCodec.toUpperCase(), true, 0, "opus", false, false, this.czZ.cyi, this.czu.booleanValue(), this.czv.booleanValue(), this.czZ.VideoMaxkbps, this.czZ.VideoMinkbps, this.czZ.cyp, this.czZ.cyh, true, this.czZ.cyk, this.czZ.cyn, this.czZ.cyl, this.czZ.cyg, this.czZ.cxu, this.czZ.cyq, this.czZ.cyo, this.czZ.cym);
            this.cAx = PeerConnectionClient.aii();
            if (this.czD) {
                if (this.czz == null) {
                    this.czz = new com.baidu.cloudbase.a.a();
                }
                this.czz.aQ(false);
                if (this.cAd < 0) {
                    this.cAd = this.czz.uc();
                }
                this.czz.ud();
                this.czz.aP(false);
                this.czz.aO(false);
                this.czz.a(this.czY);
            }
            if (this.cAj != null || this.czD) {
                this.cAx.a(this.cAk);
            }
            if (this.cAf != null || this.czD) {
                this.cAx.a(this.cAg);
            }
            if (this.czZ != null) {
                this.cAt.ev(this.czZ.HasAudio);
                this.cAx.ev(this.czZ.HasAudio);
                this.cAt.ex(this.czZ.HasVideo);
                this.cAx.ex(this.czZ.HasVideo);
                this.cAt.ew(this.czZ.HasData);
                this.cAx.ew(this.czZ.HasData);
                this.cAx.hx(this.czZ.AudioFrequency);
                this.cAx.setAudioChannel(this.czZ.AudioChannel);
                this.cAt.hy(this.czZ.ConnectionTimeoutMs);
                this.cAt.hz(this.czZ.ReadTimeoutMs);
                this.cAt.eC(this.czZ.AutoPublish);
                this.cAt.eD(this.czZ.AutoSubScribe);
            }
            this.cAx.eu(this.czL);
            this.cAx.et(cwO);
            this.cAx.a(this.mContext.get(), this.cwS, this);
            this.cAt.L(this.czR, this.czK);
            Log.i("BRTC", "loginRtcRoomWithRoomName: this " + this + " version: " + version());
            return true;
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public boolean logoutRtcRoom() {
        if (this.cAx != null) {
            this.cAx.es(false);
            this.cAx.ey(false);
            this.cAx.aik();
            this.cAt.Cw();
            this.cAt.finalize();
            this.cAx.close();
            if (this.czC != null) {
                this.czC.pause();
            }
            this.czF.clear();
            this.cAx = null;
            this.cAt = null;
            if (this.czz != null) {
                this.czz.a(null);
                this.czz.release();
            }
            if (this.czW != null) {
                this.czW.release();
                this.czW = null;
            }
            if (this.cAe != null) {
                for (int i = 0; i < this.cAe.length; i++) {
                    if (this.cAe[i] != null) {
                        this.cAe[i].release();
                        this.cAe[i] = null;
                    }
                }
            }
            aix();
            aiy();
            if (this.cAz != null) {
                this.cAz.release();
            }
            if (this.audioManager != null && this.audioManager.isBluetoothScoOn()) {
                d((Boolean) false);
            }
            if (this.czH != null) {
                this.mContext.get().unregisterReceiver(this.czH);
                this.czH = null;
            }
            System.gc();
        }
        return true;
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void muteMicphone(boolean z) {
        if (this.cAx != null) {
            this.cAx.es(!z);
        }
        kw("MUTE_MICPHONE");
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void onIceCandidatesRemoved(IceCandidate[] iceCandidateArr) {
    }

    public void presetLoudSpeaker(boolean z) {
        ((AudioManager) this.mContext.get().getSystemService("audio")).setSpeakerphoneOn(z);
        kw("PRESETLOUDSPEAKER");
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void sendMessageToUser(String str, long j) {
        if (this.cAt == null) {
            return;
        }
        this.cAt.sendMessageToUser(str, j);
        try {
            Thread.sleep(10L);
        } catch (InterruptedException e) {
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void setExternalSurface(long j, Surface surface) {
        j bP = bP(j);
        if (bP != null) {
            if (!bP.aip()) {
                bP.init();
                bP.ez(true);
            }
            for (Long l : this.cAp.keySet()) {
                j jVar = this.cAp.get(l);
                if (jVar != null && jVar.hasSurface() && surface == jVar.getSurface() && this.czA != null) {
                    Log.d("BaiduRtcRoomImp", "Set surface repeat with userId " + j);
                    this.czA.onErrorInfoUpdate(600);
                    return;
                }
            }
            bP.setSurface(surface);
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void setUserAttribute(String str) {
        if (this.cAt == null) {
            return;
        }
        this.cAt.setUserAttribute(str);
        try {
            Thread.sleep(10L);
        } catch (InterruptedException e) {
        }
    }
}
