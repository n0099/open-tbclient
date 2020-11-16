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
/* loaded from: classes16.dex */
public class a extends BaiduRtcRoom implements PeerConnectionClient.b, c {
    public static boolean cja = false;
    static int cni = -1;
    public static int cnj = 30;
    private static ConcurrentHashMap<String, String> cnk = new ConcurrentHashMap<>();
    public static int cnl = 1;
    C0323a cnA;
    private boolean cnI;
    BaiduRtcRoom.RtcLiveTransferMode cnN;
    private int cnm;
    private Boolean cnq;
    private com.baidu.cloudbase.a.a cnr;
    com.baidu.rtc.c.a cnv;
    private Context cof;
    private VideoSink col;

    /* renamed from: com  reason: collision with root package name */
    private o f3197com;
    private EglBase cot;
    d cou;
    String mAppId;
    private WeakReference<Context> mContext;
    private String mCpuType;
    String mDisplayName;
    String mRoomName;
    long mUserId;
    private boolean cnF = false;
    private boolean cnE = false;
    private boolean cnw = false;
    private volatile PeerConnectionClient cor = null;
    private PeerConnectionClient.c cje = null;
    private RTCVideoView cnP = null;
    private RTCVideoView[] cnX = null;
    private VideoCapturer cjn = null;
    private String cnK = "wss://rtc2.exp.bcelive.com/janus";
    private int cob = 0;
    private boolean coj = true;
    private boolean[] cnz = new boolean[cnj];
    private AudioManager audioManager = null;
    private int cnW = -1;
    BaiduRtcRoom.a cns = null;
    g.d coc = null;
    g.c cnY = null;
    g.b cnQ = null;
    private ConcurrentHashMap<Long, j> coi = new ConcurrentHashMap<>();
    private IdentityHashMap<Long, j> cnT = new IdentityHashMap<>();
    private boolean cok = false;
    int cnu = cni;
    private RtcParameterSettings cnS = new RtcParameterSettings();
    private Handler mHandler = new Handler(Looper.getMainLooper());
    BigInteger cnU = null;
    volatile long cnM = 0;
    volatile long cnL = 0;
    ConcurrentHashMap<BigInteger, BigInteger> cnx = new ConcurrentHashMap<>();
    boolean coo = true;
    double coq = 200.0d;
    boolean cnH = false;
    boolean cnG = false;
    String cnV = "online";
    private ConcurrentHashMap<BigInteger, com.baidu.rtc.c.b> cny = new ConcurrentHashMap<>();
    boolean cop = false;
    boolean cnB = true;
    boolean cnC = true;
    boolean cnD = false;
    Boolean cnn = false;
    Boolean cno = false;
    String cnO = "";
    private ConcurrentHashMap<BigInteger, b> coa = new ConcurrentHashMap<>();
    private Thread cog = null;
    private boolean cnJ = false;
    private String coh = "";
    private com.baidu.cloudbase.b.c coe = new c.a() { // from class: com.baidu.rtc.b.a.1
        @Override // com.baidu.cloudbase.b.c
        public void U(String str, String str2) {
            Log.d("BaiduRtcRoomImp", "Be successful to download so!");
            String str3 = com.baidu.cloudbase.b.b.Z(a.this.cof) + File.separator + "libjingle_peerconnection_so.so";
            Log.d("BaiduRtcRoomImp", "RTC so path is: " + str3);
            a.this.cnJ = true;
            if (com.baidu.cloudbase.b.a.aa(a.this.cof).dx(com.baidu.cloudbase.b.b.Z(a.this.cof))) {
                try {
                    System.load(str3);
                    Log.d("BaiduRtcRoomImp", "loaded so, and start to login room.");
                    a.this.loginRtcRoomWithRoomName(a.this.mRoomName, a.this.mUserId, a.this.mDisplayName, a.this.cnC, a.this.cnB);
                    return;
                } catch (Throwable th) {
                    Log.d("BaiduRtcRoomImp", "Failed call System.load to load so! Error: " + th);
                    if (a.this.cns != null) {
                        a.this.cns.onErrorInfoUpdate(401);
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
                a.this.loginRtcRoomWithRoomName(a.this.mRoomName, a.this.mUserId, a.this.mDisplayName, a.this.cnC, a.this.cnB);
            } catch (Throwable th2) {
                Log.d("BaiduRtcRoomImp", "Failed to load so with full path! Error: " + th2);
                if (a.this.cns != null) {
                    a.this.cns.onErrorInfoUpdate(401);
                }
            }
        }

        @Override // com.baidu.cloudbase.b.c
        public void b(String str, int i, String str2) {
            Log.d("BaiduRtcRoomImp", "Failed to download so.");
            if (a.this.cns != null) {
                a.this.cns.onErrorInfoUpdate(400);
            }
        }
    };
    JavaAudioDeviceModule.SamplesReadyCallback cod = new JavaAudioDeviceModule.SamplesReadyCallback() { // from class: com.baidu.rtc.b.a.16
        @Override // org.webrtc.audio.JavaAudioDeviceModule.SamplesReadyCallback
        public void onWebRtcAudioRecordSamplesReady(JavaAudioDeviceModule.AudioSamples audioSamples) {
            if (audioSamples == null || audioSamples.getData() == null || audioSamples.getData().length <= 0) {
                return;
            }
            if (a.this.coc != null) {
                a.this.coc.a(new g(audioSamples.getAudioFormat(), audioSamples.getChannelCount(), audioSamples.getSampleRate(), audioSamples.getData()));
            }
            if (!a.this.cnw || a.this.cnE) {
                return;
            }
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            bufferInfo.size = audioSamples.getData().length;
            bufferInfo.offset = 0;
            a.this.cnr.a(ByteBuffer.wrap(audioSamples.getData()), bufferInfo);
        }
    };
    JavaAudioDeviceModule.RemoteSamplesReadyCallback cnZ = new JavaAudioDeviceModule.RemoteSamplesReadyCallback() { // from class: com.baidu.rtc.b.a.17
        @Override // org.webrtc.audio.JavaAudioDeviceModule.RemoteSamplesReadyCallback
        public void onWebRtcAudioRemoteSamplesReady(JavaAudioDeviceModule.AudioSamples audioSamples) {
            if (audioSamples == null) {
                return;
            }
            if (a.this.cnY != null) {
                a.this.cnY.c(new g(audioSamples.getAudioFormat(), audioSamples.getChannelCount(), audioSamples.getSampleRate(), audioSamples.getData()));
            }
            if (!a.this.cnw || a.this.cnW < 0) {
                return;
            }
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            bufferInfo.size = audioSamples.getData().length;
            bufferInfo.offset = 0;
            a.this.cnr.a(ByteBuffer.wrap(audioSamples.getData()), bufferInfo, a.this.cnW);
        }
    };
    g.a cnp = new g.a() { // from class: com.baidu.rtc.b.a.18
    };
    private com.baidu.cloudbase.c.a cnR = new com.baidu.cloudbase.c.a() { // from class: com.baidu.rtc.b.a.19
        @Override // com.baidu.cloudbase.c.a
        public void onFilteredFrameUpdate(byte[] bArr, MediaCodec.BufferInfo bufferInfo) {
            if (a.this.cnQ != null) {
                a.this.cnQ.b(new g(2, a.this.cnS.AudioChannel, a.this.cnS.AudioFrequency, bArr));
            }
        }
    };
    private Runnable cos = new Runnable() { // from class: com.baidu.rtc.b.a.13
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.cou != null && (a.this.cnH || a.this.cnG)) {
                a.this.aeb();
            }
            a.this.mHandler.postDelayed(a.this.cos, 300000L);
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.rtc.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public class C0323a extends BroadcastReceiver {
        C0323a() {
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
                                if (s == a.this.cnm) {
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

    /* loaded from: classes16.dex */
    public static class b {
        public BigInteger cit;
        public Boolean coE;
        public Boolean coF;
        public String nickName;
        public long userId;
        public int volume = -1;

        public b(BigInteger bigInteger, long j, Boolean bool, Boolean bool2, String str) {
            this.nickName = "";
            this.cit = bigInteger;
            this.userId = j;
            this.coE = bool2;
            this.coF = bool;
            this.nickName = str;
        }
    }

    public a(Context context, String str, String str2, String str3, boolean z) {
        this.mContext = null;
        this.f3197com = null;
        this.cot = null;
        this.cnA = null;
        this.cnI = false;
        this.mCpuType = "armeabi-v7a";
        this.cof = null;
        this.cnI = z;
        this.cof = context;
        this.mContext = new WeakReference<>(context);
        this.mCpuType = str3;
        this.f3197com = new o();
        this.f3197com.setAppId(str);
        this.f3197com.jV(str2);
        this.f3197com.jU("BRTC.Android.SDK V" + version());
        this.mAppId = str;
        this.f3197com.a(this);
        this.cot = EglBase_CC.create();
        for (int i = 0; i < this.cnz.length; i++) {
            this.cnz[i] = false;
        }
        AudioManager audioManager = (AudioManager) this.mContext.get().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        audioManager.setSpeakerphoneOn(false);
        if (this.cnH || this.cnG) {
            this.cnv = new com.baidu.rtc.c.a(context);
            this.cou = d.aeq();
        }
        this.cnm = 0;
        this.cnq = false;
        audioManager = audioManager == null ? (AudioManager) this.mContext.get().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND) : audioManager;
        this.cnA = new C0323a();
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
        this.mContext.get().registerReceiver(this.cnA, intentFilter);
        if (isHeadsetOn(this.mContext.get())) {
            return;
        }
        ei(true);
        Log.i("BaiduRtcRoomImp", "Headset No");
    }

    private VideoCapturer a(CameraEnumerator cameraEnumerator) {
        CameraVideoCapturer createCapturer;
        CameraVideoCapturer createCapturer2;
        CameraVideoCapturer createCapturer3;
        String[] deviceNames = cameraEnumerator.getDeviceNames();
        if (this.cnu == cni || this.cnu >= deviceNames.length || (createCapturer3 = cameraEnumerator.createCapturer(deviceNames[this.cnu], null)) == null) {
            Log.d("BaiduRtcRoomImp", "Looking for front facing cameras.");
            for (String str : deviceNames) {
                if (cameraEnumerator.isFrontFacing(str)) {
                    Log.d("BaiduRtcRoomImp", "Creating front facing camera capturer.");
                    if (!cnk.containsValue(str) && (createCapturer2 = cameraEnumerator.createCapturer(str, null)) != null) {
                        cnk.put(toString(), str);
                        this.cok = true;
                        if (this.cnP != null) {
                            this.cnP.setMirror(true);
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
                    if (!cnk.containsValue(str2) && (createCapturer = cameraEnumerator.createCapturer(str2, null)) != null) {
                        cnk.put(toString(), str2);
                        this.cok = false;
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
        if (this.f3197com == null) {
            return;
        }
        if (bigInteger == this.cnU) {
            k = BigInteger.valueOf(this.mUserId);
        } else {
            k = this.f3197com.k(bigInteger);
            if (k == null) {
                return;
            }
        }
        b bVar = this.coa.get(k);
        if (bVar == null && this.cor != null) {
            this.cor.a(false, 0, bigInteger, PeerConnectionClient.StatsEventsType.GET_AUDIOLEVEL_EVENT);
            return;
        }
        for (StatsReport statsReport : statsReportArr) {
            if (bigInteger == this.cnU) {
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

    private boolean adW() {
        return !Build.MODEL.contains("SABRESD-MX6DQ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public VideoCapturer adX() {
        VideoCapturer a2;
        if (this.cjn != null) {
            return this.cjn;
        }
        if (aec()) {
            Log.d("BaiduRtcRoomImp", "Creating capturer using camera2 API.");
            a2 = a(new Camera2Enumerator(this.mContext.get()));
        } else {
            Log.d("BaiduRtcRoomImp", "Creating capturer using camera1 API.");
            a2 = a(new Camera1Enumerator(adW()));
        }
        if (a2 == null) {
            Log.e("BaiduRtcRoomImp", "Failed to open camera");
            return null;
        }
        return a2;
    }

    private void adY() {
        if (this.coi.isEmpty()) {
            return;
        }
        for (Long l : this.coi.keySet()) {
            j jVar = this.coi.get(l);
            if (jVar != null) {
                if (jVar.getSurface() != null) {
                    jVar.releaseSurface();
                }
                jVar.release();
            }
            this.coi.remove(l);
        }
    }

    private void adZ() {
        synchronized (this) {
            if (this.cnT.isEmpty()) {
                return;
            }
            for (j jVar : this.cnT.values()) {
                if (jVar != null) {
                    if (jVar.getSurface() != null) {
                        jVar.releaseSurface();
                    }
                    jVar.release();
                }
            }
            this.cnT.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aea() {
        com.baidu.rtc.c.b bVar;
        if (this.f3197com == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        boolean z = true;
        com.baidu.rtc.c.b bVar2 = this.cny.get(this.cnU);
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
            if (this.cnv != null) {
                jSONObject3.put("sysCpuUsage", this.cnv.aek());
            }
            jSONObject3.put("appCpuUsage", 0);
            jSONObject2.put("resourceUsageInfo", jSONObject3);
            if (this.cnH) {
                JSONObject jSONObject4 = new JSONObject();
                if (z2) {
                    jSONObject4.put("bitrate", hashMap.get("bitrate_s"));
                    jSONObject4.put("packetloss", hashMap.get("packetloss_s"));
                    jSONObject4.put("fps", hashMap.get("fps_s"));
                    if (bVar2 == null) {
                        jSONObject4.put("resolution", "");
                    } else {
                        jSONObject4.put("resolution", bVar2.aeo());
                    }
                } else {
                    jSONObject4.put("bitrate", 0);
                    jSONObject4.put("packetloss", 0);
                    jSONObject4.put("fps", 0);
                    jSONObject4.put("resolution", "");
                }
                jSONObject2.put("senderQualityInfo", jSONObject4);
            }
            if (this.cnG) {
                JSONArray jSONArray = new JSONArray();
                for (BigInteger bigInteger : this.cny.keySet()) {
                    if (bigInteger != this.cnU && (bVar = this.cny.get(bigInteger)) != null) {
                        HashMap hashMap2 = new HashMap();
                        bVar.t(hashMap2);
                        if (hashMap2.size() != 0) {
                            JSONObject jSONObject5 = new JSONObject();
                            jSONObject5.put("feedId", this.f3197com.k(bigInteger));
                            jSONObject5.put("bitrate", hashMap2.get("bitrate_r"));
                            jSONObject5.put("packetloss", hashMap2.get("packetloss_r"));
                            jSONObject5.put("fps", hashMap2.get("fps_r"));
                            jSONObject5.put("resolution", bVar.aen());
                            jSONArray.put(jSONObject5);
                        }
                    }
                }
                jSONObject2.put("receiverQualityInfoList", jSONArray);
            }
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put("communicationQualityInfo", jSONObject2);
            jSONObject.put("env", this.cnV);
            jSONObject.put("appId", this.mAppId);
            jSONObject.put("roomId", this.f3197com.getRoomId());
            jSONObject.put("timestamp", System.currentTimeMillis());
            jSONObject.put(TbEnum.SystemMessage.KEY_USER_ID, this.mUserId);
            jSONObject.put("message", jSONObject6);
        } catch (JSONException e) {
            Log.e("BaiduRtcRoomImp", "Caught error on reportCommunicationQualityInfo: " + e);
        }
        this.cou.J(jSONObject.toString(), 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aeb() {
        if (this.f3197com == null) {
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
            jSONObject.put("env", this.cnV);
            jSONObject.put("appId", this.mAppId);
            jSONObject.put("roomId", this.f3197com.getRoomId());
            jSONObject.put("timestamp", System.currentTimeMillis());
            jSONObject.put(TbEnum.SystemMessage.KEY_USER_ID, this.mUserId);
            jSONObject.put("message", jSONObject3);
        } catch (JSONException e) {
            Log.e("BaiduRtcRoomImp", "Caught error on reportDeviceInfo: " + e);
        }
        this.cou.J(jSONObject.toString(), 0);
    }

    private boolean aec() {
        Camera2Enumerator.disableExtraCamera(this.cnS.ckq);
        return Camera2Enumerator.isSupported(this.mContext.get());
    }

    private void bo(long j) {
        synchronized (this) {
            if (this.coi.containsKey(Long.valueOf(j))) {
                this.cnT.put(Long.valueOf(j), this.coi.get(Long.valueOf(j)));
                this.coi.remove(Long.valueOf(j));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int c(Boolean bool) {
        if (this.cnq == bool) {
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
            this.cnq = bool;
            return 0;
        } catch (Exception e) {
            Log.e("BaiduRtcRoomImp", "set bluetooth sco fail: " + e.getMessage());
            return -1;
        }
    }

    public static void dR(boolean z) {
        cja = z;
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
    public void jW(String str) {
        if ((this.cnH || this.cnG) && this.f3197com != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(TbEnum.SystemMessage.KEY_USER_NAME, this.mDisplayName);
                jSONObject2.put("eventDescription", str);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("roomEvent", jSONObject2);
                jSONObject.put("env", this.cnV);
                jSONObject.put("appId", this.mAppId);
                jSONObject.put("roomId", this.f3197com.getRoomId());
                jSONObject.put("timestamp", System.currentTimeMillis());
                jSONObject.put(TbEnum.SystemMessage.KEY_USER_ID, this.mUserId);
                jSONObject.put("message", jSONObject3);
            } catch (JSONException e) {
                Log.e("BaiduRtcRoomImp", "Caught error on reportRoomEventInfo: " + e);
            }
            this.cou.J(jSONObject.toString(), 1);
        }
    }

    private void n(final BigInteger bigInteger) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.rtc.b.a.11
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.cnS.HasVideo) {
                    a.this.cjn = a.this.adX();
                }
                if (a.this.cor == null) {
                    Log.e("BaiduRtcRoomImp", "peerConnectionClient is null!");
                    return;
                }
                if (a.this.cnF) {
                    a.this.cor.a(a.this.cot.getEglBaseContext(), a.this.col, a.this.cjn, bigInteger);
                } else {
                    a.this.cor.a(a.this.cot.getEglBaseContext(), a.this.cnP, a.this.cjn, bigInteger);
                }
                a.this.cor.i(bigInteger);
            }
        });
    }

    static /* synthetic */ int s(a aVar) {
        int i = aVar.cnm + 1;
        aVar.cnm = i;
        return i;
    }

    static /* synthetic */ int t(a aVar) {
        int i = aVar.cnm;
        aVar.cnm = i + 1;
        return i;
    }

    public static String version() {
        return "1.2.12_1106";
    }

    @Override // com.baidu.rtc.c
    public void a(BaiduRtcRoom.RtcLiveTransferMode rtcLiveTransferMode, String str) {
        if (this.cns == null) {
            return;
        }
        this.cns.onRoomEventUpdate(117, rtcLiveTransferMode.ordinal(), str);
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
                    this.cnS = rtcParameterSettings;
                    cnl = this.cnS.AudioContentType;
                    return;
                }
                return;
            case RTC_VIDEO_PARAM_SETTINGS_BITRATE:
                this.cnS.VideoMaxkbps = rtcParameterSettings.VideoMaxkbps;
                if (this.cor == null || this.mHandler == null) {
                    return;
                }
                this.mHandler.post(new Runnable() { // from class: com.baidu.rtc.b.a.10
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.cor == null || a.this.cnS.VideoMaxkbps <= 0) {
                            return;
                        }
                        Log.d("BaiduRtcRoomImp", "Set video maximum bitrate: " + a.this.cnS.VideoMaxkbps);
                        a.this.cor.b(Integer.valueOf(a.this.cnS.VideoMaxkbps));
                    }
                });
                return;
            case RTC_VIDEO_PARAM_SETTINGS_RENDER_MODE:
                this.cnS.ckw = rtcParameterSettings.ckw;
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void a(g.d dVar) {
        this.coc = dVar;
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void a(i iVar) {
        this.cjn = iVar;
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void a(final Boolean bool, final Boolean bool2, final BigInteger bigInteger) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.rtc.b.a.7
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.f3197com == null) {
                    return;
                }
                BigInteger k = a.this.f3197com.k(bigInteger);
                String l = a.this.f3197com.l(k);
                b bVar = (b) a.this.coa.get(k);
                if (bVar == null) {
                    bVar = new b(bigInteger, k.longValue(), bool, bool2, l);
                    a.this.coa.put(k, bVar);
                } else {
                    bVar.coF = bool;
                    bVar.coE = bool2;
                    bVar.cit = bigInteger;
                    bVar.nickName = l;
                }
                if (!bool2.booleanValue() || a.this.cor == null) {
                    return;
                }
                a.this.cor.a(true, 200, bVar.cit, PeerConnectionClient.StatsEventsType.GET_AUDIOLEVEL_EVENT);
            }
        });
    }

    @Override // com.baidu.rtc.c
    public void a(BigInteger bigInteger, int i, boolean z) {
        if (this.cns == null) {
            return;
        }
        this.cns.onPeerConnectStateUpdate(z ? 2001 : 2002);
    }

    @Override // com.baidu.rtc.c
    public void a(BigInteger bigInteger, String str) {
        if (this.cns == null) {
            return;
        }
        this.cns.onRoomEventUpdate(303, bigInteger.longValue(), str);
    }

    @Override // com.baidu.rtc.c
    public void a(BigInteger bigInteger, String str, String str2) {
        if (this.cns == null) {
            return;
        }
        this.cns.onRoomEventUpdate(300, bigInteger.longValue(), str);
    }

    @Override // com.baidu.rtc.c
    public void a(final BigInteger bigInteger, final BigInteger bigInteger2) {
        int i;
        Log.i("BaiduRtcRoomImp", "==================onLeaving=======================");
        this.mHandler.post(new Runnable() { // from class: com.baidu.rtc.b.a.4
            @Override // java.lang.Runnable
            public void run() {
                a.this.coa.remove(bigInteger2);
                if (a.this.cny.get(bigInteger) != null) {
                    a.this.cny.remove(bigInteger);
                    if (a.this.cor != null) {
                        a.this.cor.a(false, 0, bigInteger, PeerConnectionClient.StatsEventsType.GET_QUALITY_MONITOR_EVENT);
                    }
                }
            }
        });
        com.baidu.rtc.a j = this.cor.j(bigInteger);
        if (this.cnS.ckw == RtcParameterSettings.RtcVideoRenderMode.RTC_VIDEO_RENDER_MODE_EXTERNAL) {
            j jVar = this.coi.get(Long.valueOf(bigInteger2.longValue()));
            if (jVar == null || j == null) {
                Log.d("BaiduRtcRoomImp", "No external render has found!");
            } else {
                Log.d("BaiduRtcRoomImp", "remove external video sink of user " + bigInteger2);
                jVar.clearImage();
                if (j.cix != null) {
                    j.cix.removeSink(jVar);
                }
                bo(bigInteger2.longValue());
                if (this.cns != null) {
                    if (this.cnL == bigInteger2.longValue()) {
                        return;
                    }
                    this.cns.onRoomEventUpdate(107, bigInteger2.longValue(), "gone");
                    this.cnL = bigInteger2.longValue();
                    return;
                }
            }
        }
        if (j != null && (i = j.ciy) >= 0 && i < this.cnz.length) {
            this.cnz[i] = false;
            this.cob--;
            if (this.cnX[i] != null) {
                this.cnX[i].clearImage();
                if (j.cix != null) {
                    j.cix.removeSink(this.cnX[i]);
                }
                if (this.cns != null) {
                    if (this.cnL != bigInteger2.longValue()) {
                        this.cns.onRoomEventUpdate(107, bigInteger2.longValue(), "gone");
                        this.cnL = bigInteger2.longValue();
                        return;
                    }
                    return;
                }
            }
        }
        if (this.cns != null) {
            if (this.cnM == bigInteger2.longValue()) {
                return;
            }
            this.cnx.remove(bigInteger2);
            this.cns.onRoomEventUpdate(105, bigInteger2.longValue(), "leaving");
        }
        this.cnM = bigInteger2.longValue();
        jW("REMOTE_LEAVING_" + bigInteger2 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + bigInteger);
    }

    @Override // com.baidu.rtc.c
    public void a(BigInteger bigInteger, JSONObject jSONObject) {
        this.cor.a(bigInteger, new SessionDescription(SessionDescription.Type.fromCanonicalForm(jSONObject.optString("type")), jSONObject.optString("sdp")));
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void a(IceCandidate iceCandidate, BigInteger bigInteger) {
        Log.e("BaiduRtcRoomImp", "=========onIceCandidate========");
        if (iceCandidate != null) {
            this.f3197com.a(bigInteger, iceCandidate);
        } else {
            this.f3197com.m(bigInteger);
        }
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void a(SessionDescription sessionDescription, BigInteger bigInteger) {
        Log.e("BaiduRtcRoomImp", sessionDescription.type.toString());
        if (this.f3197com == null) {
            return;
        }
        this.f3197com.c(bigInteger, sessionDescription);
        this.mHandler.post(new Runnable() { // from class: com.baidu.rtc.b.a.5
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.cor == null || a.this.cje.cjX <= 0) {
                    return;
                }
                Log.d("BaiduRtcRoomImp", "Set video maximum bitrate: " + a.this.cje.cjX);
                a.this.cor.b(Integer.valueOf(a.this.cje.cjX));
            }
        });
    }

    public void a(StatsReport[] statsReportArr) {
        StatsReport.Value[] valueArr;
        if (this.cns == null) {
            return;
        }
        for (StatsReport statsReport : statsReportArr) {
            if (statsReport.id.equals("bweforvideo")) {
                for (StatsReport.Value value : statsReport.values) {
                    if (value.name.equals("googAvailableSendBandwidth")) {
                        this.coq = Double.parseDouble(value.value);
                        if (this.coq > 100.0d) {
                            this.cns.onRoomEventUpdate(200, (long) this.coq, statsReport.toString());
                        }
                    }
                }
                return;
            }
        }
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void a(final StatsReport[] statsReportArr, final BigInteger bigInteger, final PeerConnectionClient.StatsEventsType statsEventsType) {
        if (bigInteger == this.cnU && statsEventsType == PeerConnectionClient.StatsEventsType.GET_BWE_EVENT && this.coo) {
            a(statsReportArr);
        }
        this.mHandler.post(new Runnable() { // from class: com.baidu.rtc.b.a.6
            @Override // java.lang.Runnable
            public void run() {
                if (statsEventsType == PeerConnectionClient.StatsEventsType.GET_AUDIOLEVEL_EVENT) {
                    a.this.a(statsReportArr, bigInteger);
                }
                if ((a.this.cnH || a.this.cnG) && statsEventsType == PeerConnectionClient.StatsEventsType.GET_QUALITY_MONITOR_EVENT) {
                    com.baidu.rtc.c.b bVar = (com.baidu.rtc.c.b) a.this.cny.get(bigInteger);
                    if (bVar != null) {
                        bVar.b(statsReportArr);
                    }
                    if (bigInteger != a.this.cnU || a.this.cou == null) {
                        return;
                    }
                    a.this.aea();
                }
            }
        });
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public boolean a(BaiduRtcRoom.a aVar) {
        this.cns = aVar;
        return true;
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public boolean a(String str, long j, String str2, boolean z) {
        Log.i("BaiduRtcRoomImp", "enable force login");
        this.cnD = z;
        return loginRtcRoomWithRoomName(str, j, str2, true, true);
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public boolean a(String str, boolean z, boolean z2, String str2, BaiduRtcRoom.RtcLiveTransferMode rtcLiveTransferMode) {
        if (this.cnO.isEmpty() || this.cnN == rtcLiveTransferMode) {
            this.cnO = str;
            this.cnN = rtcLiveTransferMode;
            this.f3197com.eg(z2);
            this.f3197com.jR(str);
            this.f3197com.ef(z);
            this.f3197com.jQ(str2);
            this.f3197com.a(rtcLiveTransferMode);
        } else {
            this.f3197com.b(str, z, z2, str2, rtcLiveTransferMode);
        }
        return true;
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void acS() {
        if (this.f3197com != null) {
            this.f3197com.acS();
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public BaiduRtcRoom.c[] acT() {
        int i = 0;
        int i2 = 0;
        for (BigInteger bigInteger : this.coa.keySet()) {
            b bVar = this.coa.get(bigInteger);
            if (bVar.coE.booleanValue() && bVar.volume != -1) {
                i2++;
            }
        }
        BaiduRtcRoom.c[] cVarArr = new BaiduRtcRoom.c[i2];
        for (BigInteger bigInteger2 : this.coa.keySet()) {
            b bVar2 = this.coa.get(bigInteger2);
            if (bVar2.volume != -1 && bVar2.coE.booleanValue()) {
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
    public BaiduRtcRoom.d[] acU() {
        if (this.f3197com == null) {
            return null;
        }
        return this.f3197com.adp();
    }

    @Override // com.baidu.rtc.c
    public void acV() {
        if (this.cns == null) {
            return;
        }
        this.cns.onRoomEventUpdate(103, 0L, "coennection Error");
        jW("CONNECTION_LOST");
    }

    @Override // com.baidu.rtc.c
    public void acW() {
        if (this.cns == null) {
            return;
        }
        this.cns.onRoomEventUpdate(102, 0L, BdStatsConstant.StatsType.ERROR);
        jW("LOGIN_ERROR");
    }

    @Override // com.baidu.rtc.c
    public void acX() {
        if (this.cns == null) {
            return;
        }
        this.cns.onRoomEventUpdate(101, 0L, "time out");
    }

    @Override // com.baidu.rtc.c
    public void acY() {
        if (this.cns == null) {
            return;
        }
        this.cns.onRoomEventUpdate(112, 0L, "");
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void adf() {
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void adg() {
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void adh() {
        if (this.cns != null) {
            this.cns.onPeerConnectStateUpdate(2003);
        }
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void adi() {
    }

    @Override // com.baidu.rtc.c
    public void b(BaiduRtcRoom.RtcLiveTransferMode rtcLiveTransferMode, String str) {
        if (this.cns == null) {
            return;
        }
        this.cns.onRoomEventUpdate(118, rtcLiveTransferMode.ordinal(), str);
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void b(com.baidu.rtc.a aVar) {
        int i;
        Log.e("BaiduRtcRoomImp", "=========onRemoteRender========" + aVar.cix);
        final BigInteger k = this.f3197com.k(aVar.cit);
        if (k.longValue() == 0) {
            Log.e("BaiduRtcRoomImp", "onRemoteRender Userid is 0.");
        } else if (this.cnS.ckw == RtcParameterSettings.RtcVideoRenderMode.RTC_VIDEO_RENDER_MODE_EXTERNAL) {
            j bp = bp(k.longValue());
            Log.d("BaiduRtcRoomImp", "enable external video render mode with videoRenderer -> " + bp);
            if (bp != null) {
                aVar.cix.addSink(bp);
            } else {
                Log.d("BaiduRtcRoomImp", "Not found external render for user " + k);
            }
            this.cns.onRoomEventUpdate(106, k.longValue(), "");
        } else {
            Log.d("BaiduRtcRoomImp", "it is internal video render mode");
            try {
                i = this.cnx.get(this.f3197com.k(aVar.cit)).intValue();
            } catch (Exception e) {
                i = -1;
            }
            if (i >= 0 && i < cnj && this.cnX != null) {
                if (this.cnX[i] != null) {
                    this.cnX[i].setFirstFrameEventListener(new Runnable() { // from class: com.baidu.rtc.b.a.8
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.cns != null) {
                                a.this.cns.onRoomEventUpdate(106, k.longValue(), "");
                            }
                        }
                    });
                    aVar.cix.addSink(this.cnX[i]);
                }
                aVar.ciy = i;
            } else if (this.cnX != null) {
                int i2 = 0;
                while (true) {
                    if (i2 >= this.cnz.length) {
                        i2 = -1;
                        break;
                    } else if (!this.cnz[i2]) {
                        this.cnz[i2] = true;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i2 >= 0) {
                    if (this.cnX[i2] != null) {
                        this.cnX[i2].setFirstFrameEventListener(new Runnable() { // from class: com.baidu.rtc.b.a.9
                            @Override // java.lang.Runnable
                            public void run() {
                                if (a.this.cns != null) {
                                    a.this.cns.onRoomEventUpdate(106, k.longValue(), "");
                                }
                            }
                        });
                        aVar.cix.addSink(this.cnX[i2]);
                    }
                    aVar.ciy = i2;
                }
                this.cob++;
            }
        }
    }

    @Override // com.baidu.rtc.c
    public void b(BigInteger bigInteger) {
        if (this.cns == null) {
            return;
        }
        this.cns.onPeerConnectStateUpdate(2003);
    }

    @Override // com.baidu.rtc.c
    public void b(BigInteger bigInteger, String str) {
        if (this.cnM == bigInteger.longValue()) {
            this.cnM = 0L;
        }
        if (this.cnL == bigInteger.longValue()) {
            this.cnL = 0L;
        }
        if (this.cns == null) {
            return;
        }
        this.cns.onRoomEventUpdate(104, bigInteger.longValue(), str);
    }

    @Override // com.baidu.rtc.c
    public void b(final BigInteger bigInteger, JSONObject jSONObject) {
        this.cor.b(bigInteger, new SessionDescription(SessionDescription.Type.fromCanonicalForm(jSONObject.optString("type")), jSONObject.optString("sdp")));
        this.mHandler.post(new Runnable() { // from class: com.baidu.rtc.b.a.3
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.cnG || bigInteger == a.this.cnU || a.this.cor == null) {
                    return;
                }
                if (a.this.cny.get(bigInteger) != null) {
                    a.this.cor.a(false, 0, bigInteger, PeerConnectionClient.StatsEventsType.GET_QUALITY_MONITOR_EVENT);
                    a.this.cny.remove(bigInteger);
                }
                a.this.cor.a(a.this.cnG, 2000, bigInteger, PeerConnectionClient.StatsEventsType.GET_QUALITY_MONITOR_EVENT);
                a.this.cny.put(bigInteger, new com.baidu.rtc.c.b());
            }
        });
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void b(SessionDescription sessionDescription, BigInteger bigInteger) {
        Log.e("BaiduRtcRoomImp", sessionDescription.type.toString());
        this.f3197com.d(bigInteger, sessionDescription);
    }

    public void bb(Context context) {
        Log.d("BaiduRtcRoomImp", "setup so later loading feature, and cpu type: " + this.mCpuType);
        com.baidu.cloudbase.b.a.aa(context).dy(this.mCpuType);
        if (this.coh.isEmpty()) {
            com.baidu.cloudbase.b.a.aa(context).a(com.baidu.cloudbase.b.b.uH(), true, this.coe);
            return;
        }
        Log.d("BaiduRtcRoomImp", "setup so later load url: " + this.coh);
        com.baidu.cloudbase.b.a.aa(context).a(this.coh, true, this.coe);
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void bk(long j) {
        if (this.f3197com != null) {
            this.f3197com.bk(j);
        }
    }

    @Override // com.baidu.rtc.c
    public void bl(long j) {
        if (this.cns == null) {
            return;
        }
        this.cns.onRoomEventUpdate(114, j, "");
    }

    @Override // com.baidu.rtc.c
    public void bm(long j) {
        if (this.cns == null) {
            return;
        }
        this.cns.onRoomEventUpdate(115, j, "");
    }

    @Override // com.baidu.rtc.c
    public void bn(long j) {
        if (this.cns == null) {
            return;
        }
        this.cns.onRoomEventUpdate(113, j, "");
    }

    public j bp(long j) {
        j kVar;
        synchronized (this) {
            Log.d("BaiduRtcRoomImp", j + " : Get external renderer.");
            if (this.coi.containsKey(Long.valueOf(j))) {
                kVar = this.coi.get(Long.valueOf(j));
            } else {
                kVar = new k(this.cns, j);
                Log.d("BaiduRtcRoomImp", j + " : Create external renderer" + kVar);
                this.coi.put(Long.valueOf(j), kVar);
            }
        }
        return kVar;
    }

    @Override // com.baidu.rtc.c
    public void c(BaiduRtcRoom.RtcLiveTransferMode rtcLiveTransferMode, String str) {
        if (this.cns == null) {
            return;
        }
        this.cns.onRoomEventUpdate(116, rtcLiveTransferMode.ordinal(), str);
    }

    @Override // com.baidu.rtc.c
    public void c(final BigInteger bigInteger) {
        if (this.cns != null) {
            this.cns.onRoomEventUpdate(100, 0L, "ok");
        }
        this.cnU = bigInteger;
        if (this.cnS.AutoPublish) {
            n(bigInteger);
        }
        if (this.coo && this.cor != null) {
            this.cor.a(this.coo, 5000, this.cnU, PeerConnectionClient.StatsEventsType.GET_BWE_EVENT);
        }
        this.mHandler.post(new Runnable() { // from class: com.baidu.rtc.b.a.2
            @Override // java.lang.Runnable
            public void run() {
                if ((a.this.cnH || a.this.cnG) && a.this.cor != null) {
                    if (a.this.cny.get(bigInteger) != null) {
                        a.this.cor.a(false, 0, bigInteger, PeerConnectionClient.StatsEventsType.GET_QUALITY_MONITOR_EVENT);
                        a.this.cny.remove(bigInteger);
                    }
                    a.this.cor.a(a.this.cnH || a.this.cnG, 2000, bigInteger, PeerConnectionClient.StatsEventsType.GET_QUALITY_MONITOR_EVENT);
                    a.this.cny.put(bigInteger, new com.baidu.rtc.c.b());
                    if (a.this.cou != null && !a.this.cop) {
                        a.this.cop = true;
                        a.this.mHandler.post(a.this.cos);
                    }
                    a aVar = a.this;
                    aVar.jW("RTCROOM_LOGIN_OK_" + a.this.mUserId);
                }
                b bVar = (b) a.this.coa.get(BigInteger.valueOf(a.this.mUserId));
                if (bVar != null) {
                    if (a.this.cor != null) {
                        a.this.cor.a(false, 0, bVar.cit, PeerConnectionClient.StatsEventsType.GET_AUDIOLEVEL_EVENT);
                    }
                    bVar.coF = Boolean.valueOf(a.this.cnS.HasVideo);
                    bVar.coE = Boolean.valueOf(a.this.cnS.HasAudio);
                    bVar.cit = bigInteger;
                    bVar.nickName = a.this.mDisplayName;
                } else {
                    a.this.coa.put(BigInteger.valueOf(a.this.mUserId), new b(bigInteger, a.this.mUserId, Boolean.valueOf(a.this.cnS.HasVideo), Boolean.valueOf(a.this.cnS.HasAudio), a.this.mDisplayName));
                }
                if (a.this.cor != null) {
                    a.this.cor.a(true, 200, bigInteger, PeerConnectionClient.StatsEventsType.GET_AUDIOLEVEL_EVENT);
                }
            }
        });
    }

    @Override // com.baidu.rtc.c
    public void c(BigInteger bigInteger, String str) {
        if (this.cns == null) {
            return;
        }
        this.cns.onRoomEventUpdate(302, bigInteger.longValue(), str);
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void c(boolean z, boolean z2, String str) {
        this.cnH = z;
        this.cnG = z2;
        this.cnV = str;
        if (!z && !z2) {
            if (this.cnv != null) {
                this.cnv.pause();
                return;
            }
            return;
        }
        if (this.cnv == null) {
            this.cnv = new com.baidu.rtc.c.a(this.cof);
        }
        if (this.cou == null) {
            this.cou = d.aeq();
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void changeSurfaceSize(long j, int i, int i2) {
        if (this.coi.containsKey(Long.valueOf(j))) {
            j jVar = this.coi.get(Long.valueOf(j));
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
        if (this.f3197com != null) {
            this.f3197com.d(j, z);
        }
    }

    @Override // com.baidu.rtc.c
    public void d(BigInteger bigInteger) {
        if (this.cor != null) {
            this.cor.h(bigInteger);
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void dS(boolean z) {
        if (this.cor != null) {
            this.cor.setSpeakerMute(z);
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void destroyExternalSurface(long j, Surface surface) {
        j jVar;
        if (this.coi.containsKey(Long.valueOf(j)) && (jVar = this.coi.get(Long.valueOf(j))) != null && surface == jVar.getSurface()) {
            jVar.releaseSurface();
        }
        adZ();
    }

    public void doDestroy() {
        logoutRtcRoom();
        cnk.remove(toString());
    }

    @Override // com.baidu.rtc.c
    public void e(BigInteger bigInteger) {
        if (this.cns == null) {
            return;
        }
        this.cns.onRoomEventUpdate(301, bigInteger.longValue(), "");
    }

    public void ei(boolean z) {
        ((AudioManager) this.mContext.get().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND)).setSpeakerphoneOn(z);
        jW("PRESETLOUDSPEAKER");
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void enableExternalVideoCapturer(boolean z) {
        this.cnF = z;
        this.col = new VideoSink() { // from class: com.baidu.rtc.b.a.12
            @Override // org.webrtc.VideoSink
            public void onFrame(VideoFrame videoFrame) {
            }
        };
    }

    @Override // com.baidu.rtc.c
    public void f(BigInteger bigInteger) {
        if (this.cns == null) {
            return;
        }
        this.cns.onPeerConnectStateUpdate(2000);
        jW("WEBRTC_UP_" + bigInteger.longValue());
    }

    @Override // com.baidu.rtc.c
    public void gZ(int i) {
        if (this.cns != null && i == 436) {
            this.cns.onErrorInfoUpdate(436);
        }
    }

    @Override // com.baidu.rtc.c
    public void h(boolean z, int i) {
        if (this.cns == null) {
            return;
        }
        this.cns.onPeerConnectStateUpdate(i < 10 ? 2100 : i < 15 ? RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL1 : i < 25 ? RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL2 : i < 40 ? RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL3 : i < 60 ? RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL4 : i < 90 ? RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL5 : i < 120 ? RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL6 : i < 180 ? RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL7 : i < 250 ? RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL8 : RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL9);
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void j(boolean z, String str) {
        c(z, z, str);
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public boolean jO(String str) {
        this.f3197com.jS(str);
        return true;
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void jP(String str) {
        if (this.cns != null) {
            this.cns.onErrorInfoUpdate(10000);
        }
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void l(ByteBuffer byteBuffer) {
        if (this.cns == null) {
            return;
        }
        this.cns.onRoomDataMessage(byteBuffer);
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
        this.cnC = z;
        this.cnB = z2;
        if (this.cnI && !this.cnJ) {
            this.cog = new Thread(new Runnable() { // from class: com.baidu.rtc.b.a.15
                @Override // java.lang.Runnable
                public void run() {
                    Log.d("BaiduRtcRoomImp", "setup downloading thread ......");
                    a.this.bb(a.this.cof);
                }
            });
            this.cog.start();
            return true;
        } else if (j == 0) {
            throw new InvalidParameterException("loginRtcRoomWithRoomName: Param Error,userId cann't be zero. zero is reserved.");
        } else {
            this.f3197com.jT(str);
            this.f3197com.setUserId(j);
            if (str2 != null && !str2.isEmpty()) {
                this.f3197com.setDisplayName(str2);
            }
            this.f3197com.setVideoCodec(this.cnS.VideoCodec);
            this.f3197com.ec(z);
            this.f3197com.eb(z2);
            int i5 = this.cnS.VideoWidth;
            int i6 = this.cnS.VideoHeight;
            String lowerCase = this.cnS.VideoResolution.toLowerCase();
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
                this.cnS.ckp = true;
            }
            this.cje = new PeerConnectionClient.c(false, i, i6, this.cnS.VideoFps, this.cnS.VideoCodec.toUpperCase(), true, 0, "opus", false, false, this.cnS.ckp, this.cnn.booleanValue(), this.cno.booleanValue(), this.cnS.VideoMaxkbps, this.cnS.VideoMinkbps, this.cnS.ckv, this.cnS.cko, true, this.cnS.ckr, this.cnS.ckt, this.cnS.cks, this.cnS.cku);
            this.cor = PeerConnectionClient.adc();
            if (this.cnw) {
                if (this.cnr == null) {
                    this.cnr = new com.baidu.cloudbase.a.a();
                }
                this.cnr.aT(false);
                if (this.cnW < 0) {
                    this.cnW = this.cnr.uA();
                }
                this.cnr.uB();
                this.cnr.aS(false);
                this.cnr.aR(false);
                this.cnr.a(this.cnR);
            }
            if (this.coc != null || this.cnw) {
                this.cor.a(this.cod);
            }
            if (this.cnY != null || this.cnw) {
                this.cor.a(this.cnZ);
            }
            if (this.cnS != null) {
                this.f3197com.dW(this.cnS.HasAudio);
                this.cor.dW(this.cnS.HasAudio);
                this.f3197com.dY(this.cnS.HasVideo);
                this.cor.dY(this.cnS.HasVideo);
                this.f3197com.dX(this.cnS.HasData);
                this.cor.dX(this.cnS.HasData);
                this.cor.ha(this.cnS.AudioFrequency);
                this.cor.setAudioChannel(this.cnS.AudioChannel);
                this.f3197com.hb(this.cnS.ConnectionTimeoutMs);
                this.f3197com.hc(this.cnS.ReadTimeoutMs);
                this.f3197com.ed(this.cnS.AutoPublish);
                this.f3197com.ee(this.cnS.AutoSubScribe);
            }
            this.cor.dV(this.cnE);
            this.cor.dU(cja);
            this.cor.a(this.mContext.get(), this.cje, this);
            this.f3197com.K(this.cnK, this.cnD);
            Log.i("BRTC", "loginRtcRoomWithRoomName: this " + this + " version: " + version());
            return true;
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public boolean logoutRtcRoom() {
        if (this.cor != null) {
            this.cor.dT(false);
            this.cor.dZ(false);
            this.cor.ade();
            this.f3197com.Bw();
            this.f3197com.finalize();
            this.cor.close();
            if (this.cnv != null) {
                this.cnv.pause();
            }
            this.cny.clear();
            this.cor = null;
            this.f3197com = null;
            if (this.cnr != null) {
                this.cnr.a(null);
                this.cnr.release();
            }
            if (this.cnP != null) {
                this.cnP.release();
                this.cnP = null;
            }
            if (this.cnX != null) {
                for (int i = 0; i < this.cnX.length; i++) {
                    if (this.cnX[i] != null) {
                        this.cnX[i].release();
                        this.cnX[i] = null;
                    }
                }
            }
            adY();
            adZ();
            if (this.cot != null) {
                this.cot.release();
            }
            if (this.audioManager != null && this.audioManager.isBluetoothScoOn()) {
                c((Boolean) false);
            }
            if (this.cnA != null) {
                this.mContext.get().unregisterReceiver(this.cnA);
                this.cnA = null;
            }
            System.gc();
        }
        return true;
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void muteMicphone(boolean z) {
        if (this.cor != null) {
            this.cor.dT(!z);
        }
        jW("MUTE_MICPHONE");
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void onIceCandidatesRemoved(IceCandidate[] iceCandidateArr) {
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void sendMessageToUser(String str, long j) {
        if (this.f3197com == null) {
            return;
        }
        this.f3197com.sendMessageToUser(str, j);
        try {
            Thread.sleep(10L);
        } catch (InterruptedException e) {
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void setExternalSurface(long j, Surface surface) {
        j bp = bp(j);
        if (bp != null) {
            if (!bp.adj()) {
                bp.init();
                bp.ea(true);
            }
            for (Long l : this.coi.keySet()) {
                j jVar = this.coi.get(l);
                if (jVar != null && jVar.hasSurface() && surface == jVar.getSurface() && this.cns != null) {
                    Log.d("BaiduRtcRoomImp", "Set surface repeat with userId " + j);
                    this.cns.onErrorInfoUpdate(600);
                    return;
                }
            }
            bp.setSurface(surface);
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void setUserAttribute(String str) {
        if (this.f3197com == null) {
            return;
        }
        this.f3197com.setUserAttribute(str);
        try {
            Thread.sleep(10L);
        } catch (InterruptedException e) {
        }
    }
}
