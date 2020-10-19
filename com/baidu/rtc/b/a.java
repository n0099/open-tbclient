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
import com.baidu.rtc.o;
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
import org.webrtc.MediaStreamTrack;
import org.webrtc.SessionDescription;
import org.webrtc.StatsReport;
import org.webrtc.VideoCapturer;
import org.webrtc.VideoFrame;
import org.webrtc.VideoSink;
import org.webrtc.audio.JavaAudioDeviceModule;
/* loaded from: classes9.dex */
public class a extends BaiduRtcRoom implements PeerConnectionClient.b, c {
    public static boolean bWy = false;
    public static int caA = 30;
    private static ConcurrentHashMap<String, String> caB = new ConcurrentHashMap<>();
    public static int caC = 1;
    static int caz = -1;
    String bYn;
    private int caD;
    private Boolean caH;
    private com.baidu.cloudbase.a.a caI;
    com.baidu.rtc.c.a caL;
    C0299a caQ;
    private boolean caY;
    private VideoSink cbB;
    private o cbC;
    private EglBase cbI;
    d cbJ;
    BaiduRtcRoom.RtcLiveTransferMode cbd;
    private Context cbv;
    String mAppId;
    private WeakReference<Context> mContext;
    private String mCpuType;
    String mDisplayName;
    long mUserId;
    private boolean caV = false;
    private boolean caU = false;
    private boolean caM = false;
    private volatile PeerConnectionClient cbG = null;
    private PeerConnectionClient.c bWC = null;
    private RTCVideoView cbf = null;
    private RTCVideoView[] cbn = null;
    private VideoCapturer bWL = null;
    private String cba = "wss://rtc2.exp.bcelive.com/janus";
    private int cbr = 0;
    private boolean cbz = true;
    private boolean[] caP = new boolean[caA];
    private AudioManager audioManager = null;
    private int cbm = -1;
    BaiduRtcRoom.a caJ = null;
    g.d cbs = null;
    g.c cbo = null;
    g.b cbg = null;
    private ConcurrentHashMap<Long, j> cby = new ConcurrentHashMap<>();
    private IdentityHashMap<Long, j> cbj = new IdentityHashMap<>();
    private boolean cbA = false;
    int caK = caz;
    private RtcParameterSettings cbi = new RtcParameterSettings();
    private Handler mHandler = new Handler(Looper.getMainLooper());
    BigInteger cbk = null;
    volatile long cbc = 0;
    volatile long cbb = 0;
    ConcurrentHashMap<BigInteger, BigInteger> caN = new ConcurrentHashMap<>();
    boolean cbD = true;
    double cbF = 200.0d;
    boolean caX = true;
    boolean caW = false;
    String cbl = "online";
    private ConcurrentHashMap<BigInteger, com.baidu.rtc.c.b> caO = new ConcurrentHashMap<>();
    boolean cbE = false;
    boolean caR = true;
    boolean caS = true;
    boolean caT = false;
    Boolean caE = false;
    Boolean caF = false;
    String cbe = "";
    private ConcurrentHashMap<BigInteger, b> cbq = new ConcurrentHashMap<>();
    private Thread cbw = null;
    private boolean caZ = false;
    private String cbx = "";
    private com.baidu.cloudbase.b.c cbu = new c.a() { // from class: com.baidu.rtc.b.a.1
        @Override // com.baidu.cloudbase.b.c
        public void V(String str, String str2) {
            Log.d("BaiduRtcRoomImp", "Be successful to download so!");
            String str3 = com.baidu.cloudbase.b.b.Z(a.this.cbv) + File.separator + "libjingle_peerconnection_so.so";
            Log.d("BaiduRtcRoomImp", "RTC so path is: " + str3);
            a.this.caZ = true;
            if (com.baidu.cloudbase.b.a.aa(a.this.cbv).dv(com.baidu.cloudbase.b.b.Z(a.this.cbv))) {
                try {
                    System.load(str3);
                    Log.d("BaiduRtcRoomImp", "loaded so, and start to login room.");
                    a.this.loginRtcRoomWithRoomName(a.this.bYn, a.this.mUserId, a.this.mDisplayName, a.this.caS, a.this.caR);
                    return;
                } catch (Throwable th) {
                    Log.d("BaiduRtcRoomImp", "Failed call System.load to load so! Error: " + th);
                    if (a.this.caJ != null) {
                        a.this.caJ.onErrorInfoUpdate(401);
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
                a.this.loginRtcRoomWithRoomName(a.this.bYn, a.this.mUserId, a.this.mDisplayName, a.this.caS, a.this.caR);
            } catch (Throwable th2) {
                Log.d("BaiduRtcRoomImp", "Failed to load so with full path! Error: " + th2);
                if (a.this.caJ != null) {
                    a.this.caJ.onErrorInfoUpdate(401);
                }
            }
        }

        @Override // com.baidu.cloudbase.b.c
        public void b(String str, int i, String str2) {
            Log.d("BaiduRtcRoomImp", "Failed to download so.");
            if (a.this.caJ != null) {
                a.this.caJ.onErrorInfoUpdate(400);
            }
        }
    };
    JavaAudioDeviceModule.SamplesReadyCallback cbt = new JavaAudioDeviceModule.SamplesReadyCallback() { // from class: com.baidu.rtc.b.a.17
        @Override // org.webrtc.audio.JavaAudioDeviceModule.SamplesReadyCallback
        public void onWebRtcAudioRecordSamplesReady(JavaAudioDeviceModule.AudioSamples audioSamples) {
            if (audioSamples == null || audioSamples.getData() == null || audioSamples.getData().length <= 0) {
                return;
            }
            if (a.this.cbs != null) {
                a.this.cbs.a(new g(audioSamples.getAudioFormat(), audioSamples.getChannelCount(), audioSamples.getSampleRate(), audioSamples.getData()));
            }
            if (!a.this.caM || a.this.caU) {
                return;
            }
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            bufferInfo.size = audioSamples.getData().length;
            bufferInfo.offset = 0;
            a.this.caI.a(ByteBuffer.wrap(audioSamples.getData()), bufferInfo);
        }
    };
    JavaAudioDeviceModule.RemoteSamplesReadyCallback cbp = new JavaAudioDeviceModule.RemoteSamplesReadyCallback() { // from class: com.baidu.rtc.b.a.18
        @Override // org.webrtc.audio.JavaAudioDeviceModule.RemoteSamplesReadyCallback
        public void onWebRtcAudioRemoteSamplesReady(JavaAudioDeviceModule.AudioSamples audioSamples) {
            if (audioSamples == null) {
                return;
            }
            if (a.this.cbo != null) {
                a.this.cbo.c(new g(audioSamples.getAudioFormat(), audioSamples.getChannelCount(), audioSamples.getSampleRate(), audioSamples.getData()));
            }
            if (!a.this.caM || a.this.cbm < 0) {
                return;
            }
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            bufferInfo.size = audioSamples.getData().length;
            bufferInfo.offset = 0;
            a.this.caI.a(ByteBuffer.wrap(audioSamples.getData()), bufferInfo, a.this.cbm);
        }
    };
    g.a caG = new g.a() { // from class: com.baidu.rtc.b.a.19
    };
    private com.baidu.cloudbase.c.a cbh = new com.baidu.cloudbase.c.a() { // from class: com.baidu.rtc.b.a.20
        @Override // com.baidu.cloudbase.c.a
        public void onFilteredFrameUpdate(byte[] bArr, MediaCodec.BufferInfo bufferInfo) {
            if (a.this.cbg != null) {
                a.this.cbg.b(new g(2, a.this.cbi.AudioChannel, a.this.cbi.AudioFrequency, bArr));
            }
        }
    };
    private Runnable cbH = new Runnable() { // from class: com.baidu.rtc.b.a.14
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.cbJ != null && (a.this.caX || a.this.caW)) {
                a.this.aap();
            }
            a.this.mHandler.postDelayed(a.this.cbH, 300000L);
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.rtc.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C0299a extends BroadcastReceiver {
        C0299a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (a.this.audioManager == null) {
                a.this.audioManager = (AudioManager) ((Context) a.this.mContext.get()).getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
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
                                if (s == a.this.caD) {
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

    /* loaded from: classes9.dex */
    public static class b {
        public BigInteger bVT;
        public Boolean cbT;
        public Boolean cbU;
        public String nickName;
        public long userId;
        public int volume = -1;

        public b(BigInteger bigInteger, long j, Boolean bool, Boolean bool2, String str) {
            this.nickName = "";
            this.bVT = bigInteger;
            this.userId = j;
            this.cbT = bool2;
            this.cbU = bool;
            this.nickName = str;
        }
    }

    public a(Context context, String str, String str2, String str3, boolean z) {
        this.mContext = null;
        this.cbC = null;
        this.cbI = null;
        this.caQ = null;
        this.caY = false;
        this.mCpuType = "armeabi-v7a";
        this.cbv = null;
        this.caY = z;
        this.cbv = context;
        this.mContext = new WeakReference<>(context);
        this.mCpuType = str3;
        this.cbC = new o();
        this.cbC.setAppId(str);
        this.cbC.jt(str2);
        this.cbC.js("BRTC.Android.SDK V" + version());
        this.mAppId = str;
        this.cbC.a(this);
        this.cbI = EglBase_CC.create();
        for (int i = 0; i < this.caP.length; i++) {
            this.caP[i] = false;
        }
        AudioManager audioManager = (AudioManager) this.mContext.get().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        audioManager.setSpeakerphoneOn(false);
        if (this.caX || this.caW) {
            this.caL = new com.baidu.rtc.c.a(context);
            this.cbJ = d.aaE();
        }
        this.caD = 0;
        this.caH = false;
        audioManager = audioManager == null ? (AudioManager) this.mContext.get().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND) : audioManager;
        this.caQ = new C0299a();
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
        this.mContext.get().registerReceiver(this.caQ, intentFilter);
        if (isHeadsetOn(this.mContext.get())) {
            return;
        }
        dJ(true);
        Log.i("BaiduRtcRoomImp", "Headset No");
    }

    private VideoCapturer a(CameraEnumerator cameraEnumerator) {
        CameraVideoCapturer createCapturer;
        CameraVideoCapturer createCapturer2;
        CameraVideoCapturer createCapturer3;
        String[] deviceNames = cameraEnumerator.getDeviceNames();
        if (this.caK == caz || this.caK >= deviceNames.length || (createCapturer3 = cameraEnumerator.createCapturer(deviceNames[this.caK], null)) == null) {
            Log.d("BaiduRtcRoomImp", "Looking for front facing cameras.");
            for (String str : deviceNames) {
                if (cameraEnumerator.isFrontFacing(str)) {
                    Log.d("BaiduRtcRoomImp", "Creating front facing camera capturer.");
                    if (!caB.containsValue(str) && (createCapturer2 = cameraEnumerator.createCapturer(str, null)) != null) {
                        caB.put(toString(), str);
                        this.cbA = true;
                        if (this.cbf != null) {
                            this.cbf.setMirror(true);
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
                    if (!caB.containsValue(str2) && (createCapturer = cameraEnumerator.createCapturer(str2, null)) != null) {
                        caB.put(toString(), str2);
                        this.cbA = false;
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
        BigInteger i;
        StatsReport.Value[] valueArr;
        StatsReport.Value[] valueArr2;
        if (this.cbC == null) {
            return;
        }
        if (bigInteger == this.cbk) {
            i = BigInteger.valueOf(this.mUserId);
        } else {
            i = this.cbC.i(bigInteger);
            if (i == null) {
                return;
            }
        }
        b bVar = this.cbq.get(i);
        if (bVar == null && this.cbG != null) {
            this.cbG.a(false, 0, bigInteger, PeerConnectionClient.StatsEventsType.GET_AUDIOLEVEL_EVENT);
            return;
        }
        for (StatsReport statsReport : statsReportArr) {
            if (bigInteger == this.cbk) {
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

    private void aQ(long j) {
        synchronized (this) {
            if (this.cby.containsKey(Long.valueOf(j))) {
                this.cbj.put(Long.valueOf(j), this.cby.get(Long.valueOf(j)));
                this.cby.remove(Long.valueOf(j));
            }
        }
    }

    private boolean aak() {
        return !Build.MODEL.contains("SABRESD-MX6DQ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public VideoCapturer aal() {
        VideoCapturer a2;
        if (this.bWL != null) {
            return this.bWL;
        }
        if (aaq()) {
            Log.d("BaiduRtcRoomImp", "Creating capturer using camera2 API.");
            a2 = a(new Camera2Enumerator(this.mContext.get()));
        } else {
            Log.d("BaiduRtcRoomImp", "Creating capturer using camera1 API.");
            a2 = a(new Camera1Enumerator(aak()));
        }
        if (a2 == null) {
            Log.e("BaiduRtcRoomImp", "Failed to open camera");
            return null;
        }
        return a2;
    }

    private void aam() {
        if (this.cby.isEmpty()) {
            return;
        }
        for (Long l : this.cby.keySet()) {
            j jVar = this.cby.get(l);
            if (jVar != null) {
                if (jVar.getSurface() != null) {
                    jVar.releaseSurface();
                }
                jVar.release();
            }
            this.cby.remove(l);
        }
    }

    private void aan() {
        synchronized (this) {
            if (this.cbj.isEmpty()) {
                return;
            }
            for (j jVar : this.cbj.values()) {
                if (jVar != null) {
                    if (jVar.getSurface() != null) {
                        jVar.releaseSurface();
                    }
                    jVar.release();
                }
            }
            this.cbj.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aao() {
        com.baidu.rtc.c.b bVar;
        if (this.cbC == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        boolean z = true;
        com.baidu.rtc.c.b bVar2 = this.caO.get(this.cbk);
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
            if (this.caL != null) {
                jSONObject3.put("sysCpuUsage", this.caL.aay());
            }
            jSONObject3.put("appCpuUsage", 0);
            jSONObject2.put("resourceUsageInfo", jSONObject3);
            if (this.caX) {
                JSONObject jSONObject4 = new JSONObject();
                if (z2) {
                    jSONObject4.put("bitrate", hashMap.get("bitrate_s"));
                    jSONObject4.put("packetloss", hashMap.get("packetloss_s"));
                    jSONObject4.put("fps", hashMap.get("fps_s"));
                    if (bVar2 == null) {
                        jSONObject4.put("resolution", "");
                    } else {
                        jSONObject4.put("resolution", bVar2.aaC());
                    }
                } else {
                    jSONObject4.put("bitrate", 0);
                    jSONObject4.put("packetloss", 0);
                    jSONObject4.put("fps", 0);
                    jSONObject4.put("resolution", "");
                }
                jSONObject2.put("senderQualityInfo", jSONObject4);
            }
            if (this.caW) {
                JSONArray jSONArray = new JSONArray();
                for (BigInteger bigInteger : this.caO.keySet()) {
                    if (bigInteger != this.cbk && (bVar = this.caO.get(bigInteger)) != null) {
                        HashMap hashMap2 = new HashMap();
                        bVar.t(hashMap2);
                        if (hashMap2.size() != 0) {
                            JSONObject jSONObject5 = new JSONObject();
                            jSONObject5.put("feedId", this.cbC.i(bigInteger));
                            jSONObject5.put("bitrate", hashMap2.get("bitrate_r"));
                            jSONObject5.put("packetloss", hashMap2.get("packetloss_r"));
                            jSONObject5.put("fps", hashMap2.get("fps_r"));
                            jSONObject5.put("resolution", bVar.aaB());
                            jSONArray.put(jSONObject5);
                        }
                    }
                }
                jSONObject2.put("receiverQualityInfoList", jSONArray);
            }
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put("communicationQualityInfo", jSONObject2);
            jSONObject.put("env", this.cbl);
            jSONObject.put("appId", this.mAppId);
            jSONObject.put("roomId", this.cbC.getRoomId());
            jSONObject.put("timestamp", System.currentTimeMillis());
            jSONObject.put(TbEnum.SystemMessage.KEY_USER_ID, this.mUserId);
            jSONObject.put("message", jSONObject6);
        } catch (JSONException e) {
            Log.e("BaiduRtcRoomImp", "Caught error on reportCommunicationQualityInfo: " + e);
        }
        this.cbJ.H(jSONObject.toString(), 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aap() {
        if (this.cbC == null) {
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
            jSONObject.put("env", this.cbl);
            jSONObject.put("appId", this.mAppId);
            jSONObject.put("roomId", this.cbC.getRoomId());
            jSONObject.put("timestamp", System.currentTimeMillis());
            jSONObject.put(TbEnum.SystemMessage.KEY_USER_ID, this.mUserId);
            jSONObject.put("message", jSONObject3);
        } catch (JSONException e) {
            Log.e("BaiduRtcRoomImp", "Caught error on reportDeviceInfo: " + e);
        }
        this.cbJ.H(jSONObject.toString(), 0);
    }

    private boolean aaq() {
        Camera2Enumerator.disableExtraCamera(this.cbi.bXK);
        return Camera2Enumerator.isSupported(this.mContext.get());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int c(Boolean bool) {
        if (this.caH == bool) {
            return 0;
        }
        if (this.audioManager == null) {
            this.audioManager = (AudioManager) this.mContext.get().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
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
            this.caH = bool;
            return 0;
        } catch (Exception e) {
            Log.e("BaiduRtcRoomImp", "set bluetooth sco fail: " + e.getMessage());
            return -1;
        }
    }

    public static void du(boolean z) {
        bWy = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isHeadsetOn(Context context) {
        AudioDeviceInfo[] devices;
        if (this.audioManager == null) {
            this.audioManager = (AudioManager) context.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
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
    public void ju(String str) {
        if ((this.caX || this.caW) && this.cbC != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(TbEnum.SystemMessage.KEY_USER_NAME, this.mDisplayName);
                jSONObject2.put("eventDescription", str);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("roomEvent", jSONObject2);
                jSONObject.put("env", this.cbl);
                jSONObject.put("appId", this.mAppId);
                jSONObject.put("roomId", this.cbC.getRoomId());
                jSONObject.put("timestamp", System.currentTimeMillis());
                jSONObject.put(TbEnum.SystemMessage.KEY_USER_ID, this.mUserId);
                jSONObject.put("message", jSONObject3);
            } catch (JSONException e) {
                Log.e("BaiduRtcRoomImp", "Caught error on reportRoomEventInfo: " + e);
            }
            this.cbJ.H(jSONObject.toString(), 1);
        }
    }

    private void l(final BigInteger bigInteger) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.rtc.b.a.12
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.cbi.HasVideo) {
                    a.this.bWL = a.this.aal();
                }
                if (a.this.caV) {
                    a.this.cbG.a(a.this.cbI.getEglBaseContext(), a.this.cbB, a.this.bWL, bigInteger);
                } else {
                    a.this.cbG.a(a.this.cbI.getEglBaseContext(), a.this.cbf, a.this.bWL, bigInteger);
                }
                a.this.cbG.g(bigInteger);
            }
        });
    }

    static /* synthetic */ int s(a aVar) {
        int i = aVar.caD + 1;
        aVar.caD = i;
        return i;
    }

    static /* synthetic */ int t(a aVar) {
        int i = aVar.caD;
        aVar.caD = i + 1;
        return i;
    }

    public static String version() {
        return "1.2.10";
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void Zj() {
        if (this.cbC != null) {
            this.cbC.Zj();
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public BaiduRtcRoom.c[] Zk() {
        int i = 0;
        int i2 = 0;
        for (BigInteger bigInteger : this.cbq.keySet()) {
            b bVar = this.cbq.get(bigInteger);
            if (bVar.cbT.booleanValue() && bVar.volume != -1) {
                i2++;
            }
        }
        BaiduRtcRoom.c[] cVarArr = new BaiduRtcRoom.c[i2];
        for (BigInteger bigInteger2 : this.cbq.keySet()) {
            b bVar2 = this.cbq.get(bigInteger2);
            if (bVar2.volume != -1 && bVar2.cbT.booleanValue()) {
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

    @Override // com.baidu.rtc.c
    public void Zl() {
        if (this.caJ == null) {
            return;
        }
        this.caJ.onRoomEventUpdate(103, 0L, "coennection Error");
        ju("CONNECTION_LOST");
    }

    @Override // com.baidu.rtc.c
    public void Zm() {
        if (this.caJ == null) {
            return;
        }
        this.caJ.onRoomEventUpdate(102, 0L, BdStatsConstant.StatsType.ERROR);
        ju("LOGIN_ERROR");
    }

    @Override // com.baidu.rtc.c
    public void Zn() {
        if (this.caJ == null) {
            return;
        }
        this.caJ.onRoomEventUpdate(101, 0L, "time out");
    }

    @Override // com.baidu.rtc.c
    public void Zo() {
        if (this.caJ == null) {
            return;
        }
        this.caJ.onRoomEventUpdate(112, 0L, "");
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void Zv() {
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void Zw() {
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void Zx() {
        if (this.caJ != null) {
            this.caJ.onPeerConnectStateUpdate(2003);
        }
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void Zy() {
    }

    @Override // com.baidu.rtc.c
    public void a(BaiduRtcRoom.RtcLiveTransferMode rtcLiveTransferMode, String str) {
        if (this.caJ == null) {
            return;
        }
        this.caJ.onRoomEventUpdate(117, rtcLiveTransferMode.ordinal(), str);
    }

    public void a(BaiduRtcRoom.RtcSoundMode rtcSoundMode) {
        AudioManager audioManager = (AudioManager) this.mContext.get().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
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
                    this.cbi = rtcParameterSettings;
                    caC = this.cbi.AudioContentType;
                    return;
                }
                return;
            case RTC_VIDEO_PARAM_SETTINGS_BITRATE:
                this.cbi.VideoMaxkbps = rtcParameterSettings.VideoMaxkbps;
                if (this.cbG == null || this.mHandler == null) {
                    return;
                }
                this.mHandler.post(new Runnable() { // from class: com.baidu.rtc.b.a.11
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.cbG == null || a.this.cbi.VideoMaxkbps <= 0) {
                            return;
                        }
                        Log.d("BaiduRtcRoomImp", "Set video maximum bitrate: " + a.this.cbi.VideoMaxkbps);
                        a.this.cbG.b(Integer.valueOf(a.this.cbi.VideoMaxkbps));
                    }
                });
                return;
            case RTC_VIDEO_PARAM_SETTINGS_RENDER_MODE:
                this.cbi.bXP = rtcParameterSettings.bXP;
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void a(g.d dVar) {
        this.cbs = dVar;
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void a(i iVar) {
        this.bWL = iVar;
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void a(final Boolean bool, final Boolean bool2, final BigInteger bigInteger) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.rtc.b.a.8
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.cbC == null) {
                    return;
                }
                BigInteger i = a.this.cbC.i(bigInteger);
                String j = a.this.cbC.j(i);
                b bVar = (b) a.this.cbq.get(i);
                if (bVar == null) {
                    bVar = new b(bigInteger, i.longValue(), bool, bool2, j);
                    a.this.cbq.put(i, bVar);
                } else {
                    bVar.cbU = bool;
                    bVar.cbT = bool2;
                    bVar.bVT = bigInteger;
                    bVar.nickName = j;
                }
                if (!bool2.booleanValue() || a.this.cbG == null) {
                    return;
                }
                a.this.cbG.a(true, 200, bVar.bVT, PeerConnectionClient.StatsEventsType.GET_AUDIOLEVEL_EVENT);
            }
        });
    }

    @Override // com.baidu.rtc.c
    public void a(BigInteger bigInteger, int i, boolean z) {
        if (this.caJ == null) {
            return;
        }
        this.caJ.onPeerConnectStateUpdate(z ? 2001 : 2002);
    }

    @Override // com.baidu.rtc.c
    public void a(BigInteger bigInteger, String str) {
        if (this.caJ == null) {
            return;
        }
        this.caJ.onRoomEventUpdate(303, bigInteger.longValue(), str);
    }

    @Override // com.baidu.rtc.c
    public void a(BigInteger bigInteger, String str, String str2) {
        if (this.caJ == null) {
            return;
        }
        this.caJ.onRoomEventUpdate(300, bigInteger.longValue(), str);
    }

    @Override // com.baidu.rtc.c
    public void a(final BigInteger bigInteger, final BigInteger bigInteger2) {
        int i;
        Log.i("BaiduRtcRoomImp", "==================onLeaving=======================");
        this.mHandler.post(new Runnable() { // from class: com.baidu.rtc.b.a.5
            @Override // java.lang.Runnable
            public void run() {
                a.this.cbq.remove(bigInteger2);
                if (a.this.caO.get(bigInteger) != null) {
                    a.this.caO.remove(bigInteger);
                    if (a.this.cbG != null) {
                        a.this.cbG.a(false, 0, bigInteger, PeerConnectionClient.StatsEventsType.GET_QUALITY_MONITOR_EVENT);
                    }
                }
            }
        });
        com.baidu.rtc.a h = this.cbG.h(bigInteger);
        if (this.cbi.bXP == RtcParameterSettings.RtcVideoRenderMode.RTC_VIDEO_RENDER_MODE_EXTERNAL) {
            j jVar = this.cby.get(Long.valueOf(bigInteger2.longValue()));
            if (jVar == null || h == null) {
                Log.d("BaiduRtcRoomImp", "No external render has found!");
            } else {
                Log.d("BaiduRtcRoomImp", "remove external video sink of user " + bigInteger2);
                jVar.clearImage();
                if (h.bVX != null) {
                    h.bVX.removeSink(jVar);
                }
                aQ(bigInteger2.longValue());
                if (this.caJ != null) {
                    if (this.cbb == bigInteger2.longValue()) {
                        return;
                    }
                    this.caJ.onRoomEventUpdate(107, bigInteger2.longValue(), "gone");
                    this.cbb = bigInteger2.longValue();
                    return;
                }
            }
        }
        if (h != null && (i = h.bVY) >= 0 && i < this.caP.length) {
            this.caP[i] = false;
            this.cbr--;
            if (this.cbn[i] != null) {
                this.cbn[i].clearImage();
                if (h.bVX != null) {
                    h.bVX.removeSink(this.cbn[i]);
                }
                if (this.caJ != null) {
                    if (this.cbb != bigInteger2.longValue()) {
                        this.caJ.onRoomEventUpdate(107, bigInteger2.longValue(), "gone");
                        this.cbb = bigInteger2.longValue();
                        return;
                    }
                    return;
                }
            }
        }
        if (this.caJ != null) {
            if (this.cbc == bigInteger2.longValue()) {
                return;
            }
            this.caN.remove(bigInteger2);
            this.caJ.onRoomEventUpdate(105, bigInteger2.longValue(), "leaving");
        }
        this.cbc = bigInteger2.longValue();
        ju("REMOTE_LEAVING_" + bigInteger2 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + bigInteger);
    }

    @Override // com.baidu.rtc.c
    public void a(BigInteger bigInteger, JSONObject jSONObject) {
        this.cbG.a(bigInteger, new SessionDescription(SessionDescription.Type.fromCanonicalForm(jSONObject.optString("type")), jSONObject.optString("sdp")));
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void a(IceCandidate iceCandidate, BigInteger bigInteger) {
        Log.e("BaiduRtcRoomImp", "=========onIceCandidate========");
        if (iceCandidate != null) {
            this.cbC.a(bigInteger, iceCandidate);
        } else {
            this.cbC.k(bigInteger);
        }
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void a(SessionDescription sessionDescription, BigInteger bigInteger) {
        Log.e("BaiduRtcRoomImp", sessionDescription.type.toString());
        if (this.cbC == null) {
            return;
        }
        this.cbC.c(bigInteger, sessionDescription);
        this.mHandler.post(new Runnable() { // from class: com.baidu.rtc.b.a.6
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.cbG == null || a.this.bWC.bXt <= 0) {
                    return;
                }
                Log.d("BaiduRtcRoomImp", "Set video maximum bitrate: " + a.this.bWC.bXt);
                a.this.cbG.b(Integer.valueOf(a.this.bWC.bXt));
            }
        });
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void a(RTCVideoView[] rTCVideoViewArr) {
        this.cbn = rTCVideoViewArr;
        this.mHandler.post(new Runnable() { // from class: com.baidu.rtc.b.a.2
            @Override // java.lang.Runnable
            public void run() {
                for (int i = 0; i < a.this.cbn.length; i++) {
                    if (a.this.cbn[i] != null) {
                        try {
                            a.this.cbn[i].init(a.this.cbI.getEglBaseContext(), null);
                        } catch (Exception e) {
                        }
                        a.this.cbn[i].setEnableHardwareScaler(true);
                    }
                }
            }
        });
    }

    public void a(StatsReport[] statsReportArr) {
        StatsReport.Value[] valueArr;
        if (this.caJ == null) {
            return;
        }
        for (StatsReport statsReport : statsReportArr) {
            if (statsReport.id.equals("bweforvideo")) {
                for (StatsReport.Value value : statsReport.values) {
                    if (value.name.equals("googAvailableSendBandwidth")) {
                        this.cbF = Double.parseDouble(value.value);
                        if (this.cbF > 100.0d) {
                            this.caJ.onRoomEventUpdate(200, (long) this.cbF, statsReport.toString());
                        }
                    }
                }
                return;
            }
        }
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void a(final StatsReport[] statsReportArr, final BigInteger bigInteger, final PeerConnectionClient.StatsEventsType statsEventsType) {
        if (bigInteger == this.cbk && statsEventsType == PeerConnectionClient.StatsEventsType.GET_BWE_EVENT && this.cbD) {
            a(statsReportArr);
        }
        this.mHandler.post(new Runnable() { // from class: com.baidu.rtc.b.a.7
            @Override // java.lang.Runnable
            public void run() {
                if (statsEventsType == PeerConnectionClient.StatsEventsType.GET_AUDIOLEVEL_EVENT) {
                    a.this.a(statsReportArr, bigInteger);
                }
                if ((a.this.caX || a.this.caW) && statsEventsType == PeerConnectionClient.StatsEventsType.GET_QUALITY_MONITOR_EVENT) {
                    com.baidu.rtc.c.b bVar = (com.baidu.rtc.c.b) a.this.caO.get(bigInteger);
                    if (bVar != null) {
                        bVar.b(statsReportArr);
                    }
                    if (bigInteger != a.this.cbk || a.this.cbJ == null) {
                        return;
                    }
                    a.this.aao();
                }
            }
        });
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public boolean a(BaiduRtcRoom.a aVar) {
        this.caJ = aVar;
        return true;
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public boolean a(String str, long j, String str2, boolean z) {
        Log.i("BaiduRtcRoomImp", "enable force login");
        this.caT = z;
        return loginRtcRoomWithRoomName(str, j, str2, true, true);
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public boolean a(String str, boolean z, boolean z2, String str2, BaiduRtcRoom.RtcLiveTransferMode rtcLiveTransferMode) {
        if (this.cbe.isEmpty() || this.cbd == rtcLiveTransferMode) {
            this.cbe = str;
            this.cbd = rtcLiveTransferMode;
            this.cbC.dH(z2);
            this.cbC.jq(str);
            this.cbC.dG(z);
            this.cbC.jp(str2);
            this.cbC.a(rtcLiveTransferMode);
        } else {
            this.cbC.b(str, z, z2, str2, rtcLiveTransferMode);
        }
        return true;
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void aM(long j) {
        if (this.cbC != null) {
            this.cbC.aM(j);
        }
    }

    @Override // com.baidu.rtc.c
    public void aN(long j) {
        if (this.caJ == null) {
            return;
        }
        this.caJ.onRoomEventUpdate(114, j, "");
    }

    @Override // com.baidu.rtc.c
    public void aO(long j) {
        if (this.caJ == null) {
            return;
        }
        this.caJ.onRoomEventUpdate(115, j, "");
    }

    @Override // com.baidu.rtc.c
    public void aP(long j) {
        if (this.caJ == null) {
            return;
        }
        this.caJ.onRoomEventUpdate(113, j, "");
    }

    public j aR(long j) {
        if (this.cby.containsKey(Long.valueOf(j))) {
            return this.cby.get(Long.valueOf(j));
        }
        k kVar = new k(this.caJ, j);
        this.cby.put(Long.valueOf(j), kVar);
        return kVar;
    }

    @Override // com.baidu.rtc.c
    public void b(BaiduRtcRoom.RtcLiveTransferMode rtcLiveTransferMode, String str) {
        if (this.caJ == null) {
            return;
        }
        this.caJ.onRoomEventUpdate(118, rtcLiveTransferMode.ordinal(), str);
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void b(com.baidu.rtc.a aVar) {
        int i;
        Log.e("BaiduRtcRoomImp", "=========onRemoteRender========" + aVar.bVX);
        final BigInteger i2 = this.cbC.i(aVar.bVT);
        if (i2.longValue() == 0) {
            Log.e("BaiduRtcRoomImp", "onRemoteRender Userid is 0.");
        } else if (this.cbi.bXP == RtcParameterSettings.RtcVideoRenderMode.RTC_VIDEO_RENDER_MODE_EXTERNAL) {
            this.caJ.onRoomEventUpdate(106, i2.longValue(), "");
            Log.d("BaiduRtcRoomImp", "enable external video render mode.");
            j aR = aR(i2.longValue());
            if (aR != null) {
                aVar.bVX.addSink(aR);
                return;
            }
            Log.d("BaiduRtcRoomImp", "Not found external render for user " + i2);
        } else {
            Log.d("BaiduRtcRoomImp", "it is internal video render mode");
            try {
                i = this.caN.get(this.cbC.i(aVar.bVT)).intValue();
            } catch (Exception e) {
                i = -1;
            }
            if (i >= 0 && i < caA && this.cbn != null) {
                if (this.cbn[i] != null) {
                    this.cbn[i].setFirstFrameEventListener(new Runnable() { // from class: com.baidu.rtc.b.a.9
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.caJ != null) {
                                a.this.caJ.onRoomEventUpdate(106, i2.longValue(), "");
                            }
                        }
                    });
                    aVar.bVX.addSink(this.cbn[i]);
                }
                aVar.bVY = i;
            } else if (this.cbn != null) {
                int i3 = 0;
                while (true) {
                    if (i3 >= this.caP.length) {
                        i3 = -1;
                        break;
                    } else if (!this.caP[i3]) {
                        this.caP[i3] = true;
                        break;
                    } else {
                        i3++;
                    }
                }
                if (i3 >= 0) {
                    if (this.cbn[i3] != null) {
                        this.cbn[i3].setFirstFrameEventListener(new Runnable() { // from class: com.baidu.rtc.b.a.10
                            @Override // java.lang.Runnable
                            public void run() {
                                if (a.this.caJ != null) {
                                    a.this.caJ.onRoomEventUpdate(106, i2.longValue(), "");
                                }
                            }
                        });
                        aVar.bVX.addSink(this.cbn[i3]);
                    }
                    aVar.bVY = i3;
                }
                this.cbr++;
            }
        }
    }

    @Override // com.baidu.rtc.c
    public void b(BigInteger bigInteger) {
        if (this.caJ == null) {
            return;
        }
        this.caJ.onPeerConnectStateUpdate(2003);
    }

    @Override // com.baidu.rtc.c
    public void b(BigInteger bigInteger, String str) {
        if (this.cbc == bigInteger.longValue()) {
            this.cbc = 0L;
        }
        if (this.cbb == bigInteger.longValue()) {
            this.cbb = 0L;
        }
        if (this.caJ == null) {
            return;
        }
        this.caJ.onRoomEventUpdate(104, bigInteger.longValue(), str);
    }

    @Override // com.baidu.rtc.c
    public void b(final BigInteger bigInteger, JSONObject jSONObject) {
        this.cbG.b(bigInteger, new SessionDescription(SessionDescription.Type.fromCanonicalForm(jSONObject.optString("type")), jSONObject.optString("sdp")));
        this.mHandler.post(new Runnable() { // from class: com.baidu.rtc.b.a.4
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.caW || bigInteger == a.this.cbk || a.this.cbG == null) {
                    return;
                }
                if (a.this.caO.get(bigInteger) != null) {
                    a.this.cbG.a(false, 0, bigInteger, PeerConnectionClient.StatsEventsType.GET_QUALITY_MONITOR_EVENT);
                    a.this.caO.remove(bigInteger);
                }
                a.this.cbG.a(a.this.caW, 2000, bigInteger, PeerConnectionClient.StatsEventsType.GET_QUALITY_MONITOR_EVENT);
                a.this.caO.put(bigInteger, new com.baidu.rtc.c.b());
            }
        });
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void b(SessionDescription sessionDescription, BigInteger bigInteger) {
        Log.e("BaiduRtcRoomImp", sessionDescription.type.toString());
        this.cbC.d(bigInteger, sessionDescription);
    }

    public void bb(Context context) {
        Log.d("BaiduRtcRoomImp", "setup so later loading feature, and cpu type: " + this.mCpuType);
        com.baidu.cloudbase.b.a.aa(context).dw(this.mCpuType);
        if (this.cbx.isEmpty()) {
            com.baidu.cloudbase.b.a.aa(context).a(com.baidu.cloudbase.b.b.uI(), true, this.cbu);
            return;
        }
        Log.d("BaiduRtcRoomImp", "setup so later load url: " + this.cbx);
        com.baidu.cloudbase.b.a.aa(context).a(this.cbx, true, this.cbu);
    }

    @Override // com.baidu.rtc.c
    public void c(BaiduRtcRoom.RtcLiveTransferMode rtcLiveTransferMode, String str) {
        if (this.caJ == null) {
            return;
        }
        this.caJ.onRoomEventUpdate(116, rtcLiveTransferMode.ordinal(), str);
    }

    @Override // com.baidu.rtc.c
    public void c(final BigInteger bigInteger) {
        if (this.caJ != null) {
            this.caJ.onRoomEventUpdate(100, 0L, "ok");
        }
        this.cbk = bigInteger;
        if (this.cbi.AutoPublish) {
            l(bigInteger);
        }
        if (this.cbD && this.cbG != null) {
            this.cbG.a(this.cbD, 5000, this.cbk, PeerConnectionClient.StatsEventsType.GET_BWE_EVENT);
        }
        this.mHandler.post(new Runnable() { // from class: com.baidu.rtc.b.a.3
            @Override // java.lang.Runnable
            public void run() {
                if ((a.this.caX || a.this.caW) && a.this.cbG != null) {
                    if (a.this.caO.get(bigInteger) != null) {
                        a.this.cbG.a(false, 0, bigInteger, PeerConnectionClient.StatsEventsType.GET_QUALITY_MONITOR_EVENT);
                        a.this.caO.remove(bigInteger);
                    }
                    a.this.cbG.a(a.this.caX || a.this.caW, 2000, bigInteger, PeerConnectionClient.StatsEventsType.GET_QUALITY_MONITOR_EVENT);
                    a.this.caO.put(bigInteger, new com.baidu.rtc.c.b());
                    if (a.this.cbJ != null && !a.this.cbE) {
                        a.this.cbE = true;
                        a.this.mHandler.post(a.this.cbH);
                    }
                    a aVar = a.this;
                    aVar.ju("RTCROOM_LOGIN_OK_" + a.this.mUserId);
                }
                b bVar = (b) a.this.cbq.get(BigInteger.valueOf(a.this.mUserId));
                if (bVar != null) {
                    if (a.this.cbG != null) {
                        a.this.cbG.a(false, 0, bVar.bVT, PeerConnectionClient.StatsEventsType.GET_AUDIOLEVEL_EVENT);
                    }
                    bVar.cbU = Boolean.valueOf(a.this.cbi.HasVideo);
                    bVar.cbT = Boolean.valueOf(a.this.cbi.HasAudio);
                    bVar.bVT = bigInteger;
                    bVar.nickName = a.this.mDisplayName;
                } else {
                    a.this.cbq.put(BigInteger.valueOf(a.this.mUserId), new b(bigInteger, a.this.mUserId, Boolean.valueOf(a.this.cbi.HasVideo), Boolean.valueOf(a.this.cbi.HasAudio), a.this.mDisplayName));
                }
                if (a.this.cbG != null) {
                    a.this.cbG.a(true, 200, bigInteger, PeerConnectionClient.StatsEventsType.GET_AUDIOLEVEL_EVENT);
                }
            }
        });
    }

    @Override // com.baidu.rtc.c
    public void c(BigInteger bigInteger, String str) {
        if (this.caJ == null) {
            return;
        }
        this.caJ.onRoomEventUpdate(302, bigInteger.longValue(), str);
    }

    @Override // com.baidu.rtc.c
    public void d(BigInteger bigInteger) {
        if (this.caJ == null) {
            return;
        }
        this.caJ.onRoomEventUpdate(301, bigInteger.longValue(), "");
    }

    public void dJ(boolean z) {
        ((AudioManager) this.mContext.get().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND)).setSpeakerphoneOn(z);
        ju("PRESETLOUDSPEAKER");
    }

    public void doDestroy() {
        logoutRtcRoom();
        caB.remove(toString());
    }

    @Override // com.baidu.rtc.c
    public void e(BigInteger bigInteger) {
        if (this.caJ == null) {
            return;
        }
        this.caJ.onPeerConnectStateUpdate(2000);
        ju("WEBRTC_UP_" + bigInteger.longValue());
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void enableExternalVideoCapturer(boolean z) {
        this.caV = z;
        this.cbB = new VideoSink() { // from class: com.baidu.rtc.b.a.13
            @Override // org.webrtc.VideoSink
            public void onFrame(VideoFrame videoFrame) {
            }
        };
    }

    @Override // com.baidu.rtc.c
    public void gI(int i) {
        if (this.caJ != null && i == 436) {
            this.caJ.onErrorInfoUpdate(436);
        }
    }

    @Override // com.baidu.rtc.c
    public void h(boolean z, int i) {
        if (this.caJ == null) {
            return;
        }
        this.caJ.onPeerConnectStateUpdate(i < 10 ? 2100 : i < 15 ? RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL1 : i < 25 ? RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL2 : i < 40 ? RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL3 : i < 60 ? RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL4 : i < 90 ? RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL5 : i < 120 ? RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL6 : i < 180 ? RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL7 : i < 250 ? RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL8 : RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL9);
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void jo(String str) {
        if (this.caJ != null) {
            this.caJ.onErrorInfoUpdate(10000);
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public boolean loginRtcRoomWithRoomName(String str, long j, String str2, boolean z, boolean z2) {
        int i;
        int i2;
        int i3;
        int i4;
        this.mDisplayName = str2;
        this.bYn = str;
        this.mUserId = j;
        this.caS = z;
        this.caR = z2;
        if (this.caY && !this.caZ) {
            this.cbw = new Thread(new Runnable() { // from class: com.baidu.rtc.b.a.16
                @Override // java.lang.Runnable
                public void run() {
                    Log.d("BaiduRtcRoomImp", "setup downloading thread ......");
                    a.this.bb(a.this.cbv);
                }
            });
            this.cbw.start();
            return true;
        } else if (j == 0) {
            throw new InvalidParameterException("loginRtcRoomWithRoomName: Param Error,userId cann't be zero. zero is reserved.");
        } else {
            this.cbC.jr(str);
            this.cbC.setUserId(j);
            if (str2 != null && !str2.isEmpty()) {
                this.cbC.setDisplayName(str2);
            }
            this.cbC.setVideoCodec(this.cbi.VideoCodec);
            this.cbC.dD(z);
            this.cbC.dC(z2);
            int i5 = this.cbi.VideoWidth;
            int i6 = this.cbi.VideoHeight;
            String lowerCase = this.cbi.VideoResolution.toLowerCase();
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
            this.bWC = new PeerConnectionClient.c(false, i, i6, this.cbi.VideoFps, this.cbi.VideoCodec.toUpperCase(), true, 0, "opus", false, false, false, this.caE.booleanValue(), this.caF.booleanValue(), this.cbi.VideoMaxkbps, this.cbi.VideoMinkbps, this.cbi.bXO, this.cbi.bXJ, true, this.cbi.bXL, this.cbi.bXN, this.cbi.bXM);
            this.cbG = PeerConnectionClient.Zs();
            if (this.caM) {
                if (this.caI == null) {
                    this.caI = new com.baidu.cloudbase.a.a();
                }
                this.caI.aR(false);
                if (this.cbm < 0) {
                    this.cbm = this.caI.uB();
                }
                this.caI.uC();
                this.caI.aQ(false);
                this.caI.aP(false);
                this.caI.a(this.cbh);
            }
            if (this.cbs != null || this.caM) {
                this.cbG.a(this.cbt);
            }
            if (this.cbo != null || this.caM) {
                this.cbG.a(this.cbp);
            }
            if (this.cbi != null) {
                this.cbC.dy(this.cbi.HasAudio);
                this.cbG.dy(this.cbi.HasAudio);
                this.cbC.dA(this.cbi.HasVideo);
                this.cbG.dA(this.cbi.HasVideo);
                this.cbC.dz(this.cbi.HasData);
                this.cbG.dz(this.cbi.HasData);
                this.cbG.gJ(this.cbi.AudioFrequency);
                this.cbG.setAudioChannel(this.cbi.AudioChannel);
                this.cbC.gK(this.cbi.ConnectionTimeoutMs);
                this.cbC.gL(this.cbi.ReadTimeoutMs);
                this.cbC.dE(this.cbi.AutoPublish);
                this.cbC.dF(this.cbi.AutoSubScribe);
            }
            this.cbG.dx(this.caU);
            this.cbG.dw(bWy);
            this.cbG.a(this.mContext.get(), this.bWC, this);
            this.cbC.I(this.cba, this.caT);
            Log.i("BRTC", "loginRtcRoomWithRoomName: this " + this + " version: " + version());
            return true;
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public boolean logoutRtcRoom() {
        if (this.cbG != null) {
            this.cbG.dv(false);
            this.cbG.dB(false);
            this.cbG.Zu();
            this.cbC.BP();
            this.cbC.finalize();
            this.cbG.close();
            if (this.caL != null) {
                this.caL.pause();
            }
            this.caO.clear();
            this.cbG = null;
            this.cbC = null;
            if (this.caI != null) {
                this.caI.a(null);
                this.caI.release();
            }
            if (this.cbf != null) {
                this.cbf.release();
                this.cbf = null;
            }
            if (this.cbn != null) {
                for (int i = 0; i < this.cbn.length; i++) {
                    if (this.cbn[i] != null) {
                        this.cbn[i].release();
                        this.cbn[i] = null;
                    }
                }
            }
            aam();
            aan();
            if (this.cbI != null) {
                this.cbI.release();
            }
            if (this.audioManager != null && this.audioManager.isBluetoothScoOn()) {
                c((Boolean) false);
            }
            if (this.caQ != null) {
                this.mContext.get().unregisterReceiver(this.caQ);
                this.caQ = null;
            }
            System.gc();
        }
        return true;
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void m(ByteBuffer byteBuffer) {
        if (this.caJ == null) {
            return;
        }
        this.caJ.l(byteBuffer);
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void muteMicphone(boolean z) {
        if (this.cbG != null) {
            this.cbG.dv(!z);
        }
        ju("MUTE_MICPHONE");
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void onIceCandidatesRemoved(IceCandidate[] iceCandidateArr) {
    }
}
