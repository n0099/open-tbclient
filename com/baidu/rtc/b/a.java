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
/* loaded from: classes9.dex */
public class a extends BaiduRtcRoom implements PeerConnectionClient.b, c {
    public static boolean ckK = false;
    static int coU = -1;
    public static int coV = 30;
    private static ConcurrentHashMap<String, String> coW = new ConcurrentHashMap<>();
    public static int coX = 1;
    private int coY;
    private Context cpR;
    private VideoSink cpX;
    private o cpY;
    private Boolean cpc;
    private com.baidu.cloudbase.a.a cpd;
    com.baidu.rtc.c.a cpg;
    C0325a cpl;
    private boolean cpt;
    BaiduRtcRoom.RtcLiveTransferMode cpz;
    private EglBase cqe;
    d cqf;
    String mAppId;
    private WeakReference<Context> mContext;
    private String mCpuType;
    String mDisplayName;
    String mRoomName;
    long mUserId;
    private boolean cpq = false;
    private boolean cpp = false;
    private boolean cph = false;
    private volatile PeerConnectionClient cqc = null;
    private PeerConnectionClient.c ckO = null;
    private RTCVideoView cpB = null;
    private RTCVideoView[] cpJ = null;
    private VideoCapturer ckX = null;
    private String cpw = "wss://rtc2.exp.bcelive.com/janus";
    private int cpN = 0;
    private boolean cpV = true;
    private boolean[] cpk = new boolean[coV];
    private AudioManager audioManager = null;
    private int cpI = -1;
    BaiduRtcRoom.a cpe = null;
    g.d cpO = null;
    g.c cpK = null;
    g.b cpC = null;
    private ConcurrentHashMap<Long, j> cpU = new ConcurrentHashMap<>();
    private IdentityHashMap<Long, j> cpF = new IdentityHashMap<>();
    private boolean cpW = false;
    int cpf = coU;
    private RtcParameterSettings cpE = new RtcParameterSettings();
    private Handler mHandler = new Handler(Looper.getMainLooper());
    BigInteger cpG = null;
    volatile long cpy = 0;
    volatile long cpx = 0;
    ConcurrentHashMap<BigInteger, BigInteger> cpi = new ConcurrentHashMap<>();
    boolean cpZ = true;
    double cqb = 200.0d;
    boolean cps = false;
    boolean cpr = false;
    String cpH = "online";
    private ConcurrentHashMap<BigInteger, com.baidu.rtc.c.b> cpj = new ConcurrentHashMap<>();
    boolean cqa = false;
    boolean cpm = true;
    boolean cpn = true;
    boolean cpo = false;
    Boolean coZ = false;
    Boolean cpa = false;
    String cpA = "";
    private ConcurrentHashMap<BigInteger, b> cpM = new ConcurrentHashMap<>();
    private Thread cpS = null;
    private boolean cpv = false;
    private String cpT = "";
    private com.baidu.cloudbase.b.c cpQ = new c.a() { // from class: com.baidu.rtc.b.a.1
        @Override // com.baidu.cloudbase.b.c
        public void V(String str, String str2) {
            Log.d("BaiduRtcRoomImp", "Be successful to download so!");
            String str3 = com.baidu.cloudbase.b.b.Z(a.this.cpR) + File.separator + "libjingle_peerconnection_so.so";
            Log.d("BaiduRtcRoomImp", "RTC so path is: " + str3);
            a.this.cpv = true;
            if (com.baidu.cloudbase.b.a.aa(a.this.cpR).dv(com.baidu.cloudbase.b.b.Z(a.this.cpR))) {
                try {
                    System.load(str3);
                    Log.d("BaiduRtcRoomImp", "loaded so, and start to login room.");
                    a.this.loginRtcRoomWithRoomName(a.this.mRoomName, a.this.mUserId, a.this.mDisplayName, a.this.cpn, a.this.cpm);
                    return;
                } catch (Throwable th) {
                    Log.d("BaiduRtcRoomImp", "Failed call System.load to load so! Error: " + th);
                    if (a.this.cpe != null) {
                        a.this.cpe.onErrorInfoUpdate(401);
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
                a.this.loginRtcRoomWithRoomName(a.this.mRoomName, a.this.mUserId, a.this.mDisplayName, a.this.cpn, a.this.cpm);
            } catch (Throwable th2) {
                Log.d("BaiduRtcRoomImp", "Failed to load so with full path! Error: " + th2);
                if (a.this.cpe != null) {
                    a.this.cpe.onErrorInfoUpdate(401);
                }
            }
        }

        @Override // com.baidu.cloudbase.b.c
        public void b(String str, int i, String str2) {
            Log.d("BaiduRtcRoomImp", "Failed to download so.");
            if (a.this.cpe != null) {
                a.this.cpe.onErrorInfoUpdate(400);
            }
        }
    };
    JavaAudioDeviceModule.SamplesReadyCallback cpP = new JavaAudioDeviceModule.SamplesReadyCallback() { // from class: com.baidu.rtc.b.a.16
        @Override // org.webrtc.audio.JavaAudioDeviceModule.SamplesReadyCallback
        public void onWebRtcAudioRecordSamplesReady(JavaAudioDeviceModule.AudioSamples audioSamples) {
            if (audioSamples == null || audioSamples.getData() == null || audioSamples.getData().length <= 0) {
                return;
            }
            if (a.this.cpO != null) {
                a.this.cpO.a(new g(audioSamples.getAudioFormat(), audioSamples.getChannelCount(), audioSamples.getSampleRate(), audioSamples.getData()));
            }
            if (!a.this.cph || a.this.cpp) {
                return;
            }
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            bufferInfo.size = audioSamples.getData().length;
            bufferInfo.offset = 0;
            a.this.cpd.a(ByteBuffer.wrap(audioSamples.getData()), bufferInfo);
        }
    };
    JavaAudioDeviceModule.RemoteSamplesReadyCallback cpL = new JavaAudioDeviceModule.RemoteSamplesReadyCallback() { // from class: com.baidu.rtc.b.a.17
        @Override // org.webrtc.audio.JavaAudioDeviceModule.RemoteSamplesReadyCallback
        public void onWebRtcAudioRemoteSamplesReady(JavaAudioDeviceModule.AudioSamples audioSamples) {
            if (audioSamples == null) {
                return;
            }
            if (a.this.cpK != null) {
                a.this.cpK.c(new g(audioSamples.getAudioFormat(), audioSamples.getChannelCount(), audioSamples.getSampleRate(), audioSamples.getData()));
            }
            if (!a.this.cph || a.this.cpI < 0) {
                return;
            }
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            bufferInfo.size = audioSamples.getData().length;
            bufferInfo.offset = 0;
            a.this.cpd.a(ByteBuffer.wrap(audioSamples.getData()), bufferInfo, a.this.cpI);
        }
    };
    g.a cpb = new g.a() { // from class: com.baidu.rtc.b.a.18
    };
    private com.baidu.cloudbase.c.a cpD = new com.baidu.cloudbase.c.a() { // from class: com.baidu.rtc.b.a.19
        @Override // com.baidu.cloudbase.c.a
        public void onFilteredFrameUpdate(byte[] bArr, MediaCodec.BufferInfo bufferInfo) {
            if (a.this.cpC != null) {
                a.this.cpC.b(new g(2, a.this.cpE.AudioChannel, a.this.cpE.AudioFrequency, bArr));
            }
        }
    };
    private Runnable cqd = new Runnable() { // from class: com.baidu.rtc.b.a.13
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.cqf != null && (a.this.cps || a.this.cpr)) {
                a.this.aeJ();
            }
            a.this.mHandler.postDelayed(a.this.cqd, 300000L);
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.rtc.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C0325a extends BroadcastReceiver {
        C0325a() {
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
                                if (s == a.this.coY) {
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
        public BigInteger cke;
        public Boolean cqp;
        public Boolean cqq;
        public String nickName;
        public long userId;
        public int volume = -1;

        public b(BigInteger bigInteger, long j, Boolean bool, Boolean bool2, String str) {
            this.nickName = "";
            this.cke = bigInteger;
            this.userId = j;
            this.cqp = bool2;
            this.cqq = bool;
            this.nickName = str;
        }
    }

    public a(Context context, String str, String str2, String str3, boolean z) {
        this.mContext = null;
        this.cpY = null;
        this.cqe = null;
        this.cpl = null;
        this.cpt = false;
        this.mCpuType = "armeabi-v7a";
        this.cpR = null;
        this.cpt = z;
        this.cpR = context;
        this.mContext = new WeakReference<>(context);
        this.mCpuType = str3;
        this.cpY = new o();
        this.cpY.setAppId(str);
        this.cpY.kb(str2);
        this.cpY.ka("BRTC.Android.SDK V" + version());
        this.mAppId = str;
        this.cpY.a(this);
        this.cqe = EglBase_CC.create();
        for (int i = 0; i < this.cpk.length; i++) {
            this.cpk[i] = false;
        }
        AudioManager audioManager = (AudioManager) this.mContext.get().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        audioManager.setSpeakerphoneOn(false);
        if (this.cps || this.cpr) {
            this.cpg = new com.baidu.rtc.c.a(context);
            this.cqf = d.aeY();
        }
        this.coY = 0;
        this.cpc = false;
        audioManager = audioManager == null ? (AudioManager) this.mContext.get().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND) : audioManager;
        this.cpl = new C0325a();
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
        this.mContext.get().registerReceiver(this.cpl, intentFilter);
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
        if (this.cpf == coU || this.cpf >= deviceNames.length || (createCapturer3 = cameraEnumerator.createCapturer(deviceNames[this.cpf], null)) == null) {
            Log.d("BaiduRtcRoomImp", "Looking for front facing cameras.");
            for (String str : deviceNames) {
                if (cameraEnumerator.isFrontFacing(str)) {
                    Log.d("BaiduRtcRoomImp", "Creating front facing camera capturer.");
                    if (!coW.containsValue(str) && (createCapturer2 = cameraEnumerator.createCapturer(str, null)) != null) {
                        coW.put(toString(), str);
                        this.cpW = true;
                        if (this.cpB != null) {
                            this.cpB.setMirror(true);
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
                    if (!coW.containsValue(str2) && (createCapturer = cameraEnumerator.createCapturer(str2, null)) != null) {
                        coW.put(toString(), str2);
                        this.cpW = false;
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
        if (this.cpY == null) {
            return;
        }
        if (bigInteger == this.cpG) {
            k = BigInteger.valueOf(this.mUserId);
        } else {
            k = this.cpY.k(bigInteger);
            if (k == null) {
                return;
            }
        }
        b bVar = this.cpM.get(k);
        if (bVar == null && this.cqc != null) {
            this.cqc.a(false, 0, bigInteger, PeerConnectionClient.StatsEventsType.GET_AUDIOLEVEL_EVENT);
            return;
        }
        for (StatsReport statsReport : statsReportArr) {
            if (bigInteger == this.cpG) {
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

    private boolean aeE() {
        return !Build.MODEL.contains("SABRESD-MX6DQ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public VideoCapturer aeF() {
        VideoCapturer a2;
        if (this.ckX != null) {
            return this.ckX;
        }
        if (aeK()) {
            Log.d("BaiduRtcRoomImp", "Creating capturer using camera2 API.");
            a2 = a(new Camera2Enumerator(this.mContext.get()));
        } else {
            Log.d("BaiduRtcRoomImp", "Creating capturer using camera1 API.");
            a2 = a(new Camera1Enumerator(aeE()));
        }
        if (a2 == null) {
            Log.e("BaiduRtcRoomImp", "Failed to open camera");
            return null;
        }
        return a2;
    }

    private void aeG() {
        if (this.cpU.isEmpty()) {
            return;
        }
        for (Long l : this.cpU.keySet()) {
            j jVar = this.cpU.get(l);
            if (jVar != null) {
                if (jVar.getSurface() != null) {
                    jVar.releaseSurface();
                }
                jVar.release();
            }
            this.cpU.remove(l);
        }
    }

    private void aeH() {
        synchronized (this) {
            if (this.cpF.isEmpty()) {
                return;
            }
            for (j jVar : this.cpF.values()) {
                if (jVar != null) {
                    if (jVar.getSurface() != null) {
                        jVar.releaseSurface();
                    }
                    jVar.release();
                }
            }
            this.cpF.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aeI() {
        com.baidu.rtc.c.b bVar;
        if (this.cpY == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        boolean z = true;
        com.baidu.rtc.c.b bVar2 = this.cpj.get(this.cpG);
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
            if (this.cpg != null) {
                jSONObject3.put("sysCpuUsage", this.cpg.aeS());
            }
            jSONObject3.put("appCpuUsage", 0);
            jSONObject2.put("resourceUsageInfo", jSONObject3);
            if (this.cps) {
                JSONObject jSONObject4 = new JSONObject();
                if (z2) {
                    jSONObject4.put("bitrate", hashMap.get("bitrate_s"));
                    jSONObject4.put("packetloss", hashMap.get("packetloss_s"));
                    jSONObject4.put("fps", hashMap.get("fps_s"));
                    if (bVar2 == null) {
                        jSONObject4.put("resolution", "");
                    } else {
                        jSONObject4.put("resolution", bVar2.aeW());
                    }
                } else {
                    jSONObject4.put("bitrate", 0);
                    jSONObject4.put("packetloss", 0);
                    jSONObject4.put("fps", 0);
                    jSONObject4.put("resolution", "");
                }
                jSONObject2.put("senderQualityInfo", jSONObject4);
            }
            if (this.cpr) {
                JSONArray jSONArray = new JSONArray();
                for (BigInteger bigInteger : this.cpj.keySet()) {
                    if (bigInteger != this.cpG && (bVar = this.cpj.get(bigInteger)) != null) {
                        HashMap hashMap2 = new HashMap();
                        bVar.t(hashMap2);
                        if (hashMap2.size() != 0) {
                            JSONObject jSONObject5 = new JSONObject();
                            jSONObject5.put("feedId", this.cpY.k(bigInteger));
                            jSONObject5.put("bitrate", hashMap2.get("bitrate_r"));
                            jSONObject5.put("packetloss", hashMap2.get("packetloss_r"));
                            jSONObject5.put("fps", hashMap2.get("fps_r"));
                            jSONObject5.put("resolution", bVar.aeV());
                            jSONArray.put(jSONObject5);
                        }
                    }
                }
                jSONObject2.put("receiverQualityInfoList", jSONArray);
            }
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put("communicationQualityInfo", jSONObject2);
            jSONObject.put("env", this.cpH);
            jSONObject.put("appId", this.mAppId);
            jSONObject.put("roomId", this.cpY.getRoomId());
            jSONObject.put("timestamp", System.currentTimeMillis());
            jSONObject.put(TbEnum.SystemMessage.KEY_USER_ID, this.mUserId);
            jSONObject.put("message", jSONObject6);
        } catch (JSONException e) {
            Log.e("BaiduRtcRoomImp", "Caught error on reportCommunicationQualityInfo: " + e);
        }
        this.cqf.J(jSONObject.toString(), 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aeJ() {
        if (this.cpY == null) {
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
            jSONObject.put("env", this.cpH);
            jSONObject.put("appId", this.mAppId);
            jSONObject.put("roomId", this.cpY.getRoomId());
            jSONObject.put("timestamp", System.currentTimeMillis());
            jSONObject.put(TbEnum.SystemMessage.KEY_USER_ID, this.mUserId);
            jSONObject.put("message", jSONObject3);
        } catch (JSONException e) {
            Log.e("BaiduRtcRoomImp", "Caught error on reportDeviceInfo: " + e);
        }
        this.cqf.J(jSONObject.toString(), 0);
    }

    private boolean aeK() {
        Camera2Enumerator.disableExtraCamera(this.cpE.cma);
        return Camera2Enumerator.isSupported(this.mContext.get());
    }

    private void bo(long j) {
        synchronized (this) {
            if (this.cpU.containsKey(Long.valueOf(j))) {
                this.cpF.put(Long.valueOf(j), this.cpU.get(Long.valueOf(j)));
                this.cpU.remove(Long.valueOf(j));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int c(Boolean bool) {
        if (this.cpc == bool) {
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
            this.cpc = bool;
            return 0;
        } catch (Exception e) {
            Log.e("BaiduRtcRoomImp", "set bluetooth sco fail: " + e.getMessage());
            return -1;
        }
    }

    public static void dP(boolean z) {
        ckK = z;
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
    public void kc(String str) {
        if ((this.cps || this.cpr) && this.cpY != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(TbEnum.SystemMessage.KEY_USER_NAME, this.mDisplayName);
                jSONObject2.put("eventDescription", str);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("roomEvent", jSONObject2);
                jSONObject.put("env", this.cpH);
                jSONObject.put("appId", this.mAppId);
                jSONObject.put("roomId", this.cpY.getRoomId());
                jSONObject.put("timestamp", System.currentTimeMillis());
                jSONObject.put(TbEnum.SystemMessage.KEY_USER_ID, this.mUserId);
                jSONObject.put("message", jSONObject3);
            } catch (JSONException e) {
                Log.e("BaiduRtcRoomImp", "Caught error on reportRoomEventInfo: " + e);
            }
            this.cqf.J(jSONObject.toString(), 1);
        }
    }

    private void n(final BigInteger bigInteger) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.rtc.b.a.11
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.cpE.HasVideo) {
                    a.this.ckX = a.this.aeF();
                }
                if (a.this.cqc == null) {
                    Log.e("BaiduRtcRoomImp", "peerConnectionClient is null!");
                    return;
                }
                if (a.this.cpq) {
                    a.this.cqc.a(a.this.cqe.getEglBaseContext(), a.this.cpX, a.this.ckX, bigInteger);
                } else {
                    a.this.cqc.a(a.this.cqe.getEglBaseContext(), a.this.cpB, a.this.ckX, bigInteger);
                }
                a.this.cqc.i(bigInteger);
            }
        });
    }

    static /* synthetic */ int s(a aVar) {
        int i = aVar.coY + 1;
        aVar.coY = i;
        return i;
    }

    static /* synthetic */ int t(a aVar) {
        int i = aVar.coY;
        aVar.coY = i + 1;
        return i;
    }

    public static String version() {
        return "1.2.12_1106";
    }

    @Override // com.baidu.rtc.c
    public void a(BaiduRtcRoom.RtcLiveTransferMode rtcLiveTransferMode, String str) {
        if (this.cpe == null) {
            return;
        }
        this.cpe.onRoomEventUpdate(117, rtcLiveTransferMode.ordinal(), str);
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
                    this.cpE = rtcParameterSettings;
                    coX = this.cpE.AudioContentType;
                    return;
                }
                return;
            case RTC_VIDEO_PARAM_SETTINGS_BITRATE:
                this.cpE.VideoMaxkbps = rtcParameterSettings.VideoMaxkbps;
                if (this.cqc == null || this.mHandler == null) {
                    return;
                }
                this.mHandler.post(new Runnable() { // from class: com.baidu.rtc.b.a.10
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.cqc == null || a.this.cpE.VideoMaxkbps <= 0) {
                            return;
                        }
                        Log.d("BaiduRtcRoomImp", "Set video maximum bitrate: " + a.this.cpE.VideoMaxkbps);
                        a.this.cqc.b(Integer.valueOf(a.this.cpE.VideoMaxkbps));
                    }
                });
                return;
            case RTC_VIDEO_PARAM_SETTINGS_RENDER_MODE:
                this.cpE.cmh = rtcParameterSettings.cmh;
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void a(g.d dVar) {
        this.cpO = dVar;
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void a(i iVar) {
        this.ckX = iVar;
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void a(final Boolean bool, final Boolean bool2, final BigInteger bigInteger) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.rtc.b.a.7
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.cpY == null) {
                    return;
                }
                BigInteger k = a.this.cpY.k(bigInteger);
                String l = a.this.cpY.l(k);
                b bVar = (b) a.this.cpM.get(k);
                if (bVar == null) {
                    bVar = new b(bigInteger, k.longValue(), bool, bool2, l);
                    a.this.cpM.put(k, bVar);
                } else {
                    bVar.cqq = bool;
                    bVar.cqp = bool2;
                    bVar.cke = bigInteger;
                    bVar.nickName = l;
                }
                if (!bool2.booleanValue() || a.this.cqc == null) {
                    return;
                }
                a.this.cqc.a(true, 200, bVar.cke, PeerConnectionClient.StatsEventsType.GET_AUDIOLEVEL_EVENT);
            }
        });
    }

    @Override // com.baidu.rtc.c
    public void a(BigInteger bigInteger, int i, boolean z) {
        if (this.cpe == null) {
            return;
        }
        this.cpe.onPeerConnectStateUpdate(z ? 2001 : 2002);
    }

    @Override // com.baidu.rtc.c
    public void a(BigInteger bigInteger, String str) {
        if (this.cpe == null) {
            return;
        }
        this.cpe.onRoomEventUpdate(303, bigInteger.longValue(), str);
    }

    @Override // com.baidu.rtc.c
    public void a(BigInteger bigInteger, String str, String str2) {
        if (this.cpe == null) {
            return;
        }
        this.cpe.onRoomEventUpdate(300, bigInteger.longValue(), str);
    }

    @Override // com.baidu.rtc.c
    public void a(final BigInteger bigInteger, final BigInteger bigInteger2) {
        int i;
        Log.i("BaiduRtcRoomImp", "==================onLeaving=======================");
        this.mHandler.post(new Runnable() { // from class: com.baidu.rtc.b.a.4
            @Override // java.lang.Runnable
            public void run() {
                a.this.cpM.remove(bigInteger2);
                if (a.this.cpj.get(bigInteger) != null) {
                    a.this.cpj.remove(bigInteger);
                    if (a.this.cqc != null) {
                        a.this.cqc.a(false, 0, bigInteger, PeerConnectionClient.StatsEventsType.GET_QUALITY_MONITOR_EVENT);
                    }
                }
            }
        });
        com.baidu.rtc.a j = this.cqc.j(bigInteger);
        if (this.cpE.cmh == RtcParameterSettings.RtcVideoRenderMode.RTC_VIDEO_RENDER_MODE_EXTERNAL) {
            j jVar = this.cpU.get(Long.valueOf(bigInteger2.longValue()));
            if (jVar == null || j == null) {
                Log.d("BaiduRtcRoomImp", "No external render has found!");
            } else {
                Log.d("BaiduRtcRoomImp", "remove external video sink of user " + bigInteger2);
                jVar.clearImage();
                if (j.cki != null) {
                    j.cki.removeSink(jVar);
                }
                bo(bigInteger2.longValue());
                if (this.cpe != null) {
                    if (this.cpx == bigInteger2.longValue()) {
                        return;
                    }
                    this.cpe.onRoomEventUpdate(107, bigInteger2.longValue(), "gone");
                    this.cpx = bigInteger2.longValue();
                    return;
                }
            }
        }
        if (j != null && (i = j.ckj) >= 0 && i < this.cpk.length) {
            this.cpk[i] = false;
            this.cpN--;
            if (this.cpJ[i] != null) {
                this.cpJ[i].clearImage();
                if (j.cki != null) {
                    j.cki.removeSink(this.cpJ[i]);
                }
                if (this.cpe != null) {
                    if (this.cpx != bigInteger2.longValue()) {
                        this.cpe.onRoomEventUpdate(107, bigInteger2.longValue(), "gone");
                        this.cpx = bigInteger2.longValue();
                        return;
                    }
                    return;
                }
            }
        }
        if (this.cpe != null) {
            if (this.cpy == bigInteger2.longValue()) {
                return;
            }
            this.cpi.remove(bigInteger2);
            this.cpe.onRoomEventUpdate(105, bigInteger2.longValue(), "leaving");
        }
        this.cpy = bigInteger2.longValue();
        kc("REMOTE_LEAVING_" + bigInteger2 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + bigInteger);
    }

    @Override // com.baidu.rtc.c
    public void a(BigInteger bigInteger, JSONObject jSONObject) {
        this.cqc.a(bigInteger, new SessionDescription(SessionDescription.Type.fromCanonicalForm(jSONObject.optString("type")), jSONObject.optString("sdp")));
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void a(IceCandidate iceCandidate, BigInteger bigInteger) {
        Log.e("BaiduRtcRoomImp", "=========onIceCandidate========");
        if (iceCandidate != null) {
            this.cpY.a(bigInteger, iceCandidate);
        } else {
            this.cpY.m(bigInteger);
        }
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void a(SessionDescription sessionDescription, BigInteger bigInteger) {
        Log.e("BaiduRtcRoomImp", sessionDescription.type.toString());
        if (this.cpY == null) {
            return;
        }
        this.cpY.c(bigInteger, sessionDescription);
        this.mHandler.post(new Runnable() { // from class: com.baidu.rtc.b.a.5
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.cqc == null || a.this.ckO.clH <= 0) {
                    return;
                }
                Log.d("BaiduRtcRoomImp", "Set video maximum bitrate: " + a.this.ckO.clH);
                a.this.cqc.b(Integer.valueOf(a.this.ckO.clH));
            }
        });
    }

    public void a(StatsReport[] statsReportArr) {
        StatsReport.Value[] valueArr;
        if (this.cpe == null) {
            return;
        }
        for (StatsReport statsReport : statsReportArr) {
            if (statsReport.id.equals("bweforvideo")) {
                for (StatsReport.Value value : statsReport.values) {
                    if (value.name.equals("googAvailableSendBandwidth")) {
                        this.cqb = Double.parseDouble(value.value);
                        if (this.cqb > 100.0d) {
                            this.cpe.onRoomEventUpdate(200, (long) this.cqb, statsReport.toString());
                        }
                    }
                }
                return;
            }
        }
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void a(final StatsReport[] statsReportArr, final BigInteger bigInteger, final PeerConnectionClient.StatsEventsType statsEventsType) {
        if (bigInteger == this.cpG && statsEventsType == PeerConnectionClient.StatsEventsType.GET_BWE_EVENT && this.cpZ) {
            a(statsReportArr);
        }
        this.mHandler.post(new Runnable() { // from class: com.baidu.rtc.b.a.6
            @Override // java.lang.Runnable
            public void run() {
                if (statsEventsType == PeerConnectionClient.StatsEventsType.GET_AUDIOLEVEL_EVENT) {
                    a.this.a(statsReportArr, bigInteger);
                }
                if ((a.this.cps || a.this.cpr) && statsEventsType == PeerConnectionClient.StatsEventsType.GET_QUALITY_MONITOR_EVENT) {
                    com.baidu.rtc.c.b bVar = (com.baidu.rtc.c.b) a.this.cpj.get(bigInteger);
                    if (bVar != null) {
                        bVar.b(statsReportArr);
                    }
                    if (bigInteger != a.this.cpG || a.this.cqf == null) {
                        return;
                    }
                    a.this.aeI();
                }
            }
        });
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public boolean a(BaiduRtcRoom.a aVar) {
        this.cpe = aVar;
        return true;
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public boolean a(String str, boolean z, boolean z2, String str2, BaiduRtcRoom.RtcLiveTransferMode rtcLiveTransferMode) {
        if (this.cpA.isEmpty() || this.cpz == rtcLiveTransferMode) {
            this.cpA = str;
            this.cpz = rtcLiveTransferMode;
            this.cpY.ee(z2);
            this.cpY.jX(str);
            this.cpY.ed(z);
            this.cpY.jW(str2);
            this.cpY.a(rtcLiveTransferMode);
        } else {
            this.cpY.b(str, z, z2, str2, rtcLiveTransferMode);
        }
        return true;
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public BaiduRtcRoom.c[] adB() {
        int i = 0;
        int i2 = 0;
        for (BigInteger bigInteger : this.cpM.keySet()) {
            b bVar = this.cpM.get(bigInteger);
            if (bVar.cqp.booleanValue() && bVar.volume != -1) {
                i2++;
            }
        }
        BaiduRtcRoom.c[] cVarArr = new BaiduRtcRoom.c[i2];
        for (BigInteger bigInteger2 : this.cpM.keySet()) {
            b bVar2 = this.cpM.get(bigInteger2);
            if (bVar2.volume != -1 && bVar2.cqp.booleanValue()) {
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
    public BaiduRtcRoom.d[] adC() {
        if (this.cpY == null) {
            return null;
        }
        return this.cpY.adX();
    }

    @Override // com.baidu.rtc.c
    public void adD() {
        if (this.cpe == null) {
            return;
        }
        this.cpe.onRoomEventUpdate(103, 0L, "coennection Error");
        kc("CONNECTION_LOST");
    }

    @Override // com.baidu.rtc.c
    public void adE() {
        if (this.cpe == null) {
            return;
        }
        this.cpe.onRoomEventUpdate(102, 0L, BdStatsConstant.StatsType.ERROR);
        kc("LOGIN_ERROR");
    }

    @Override // com.baidu.rtc.c
    public void adF() {
        if (this.cpe == null) {
            return;
        }
        this.cpe.onRoomEventUpdate(101, 0L, "time out");
    }

    @Override // com.baidu.rtc.c
    public void adG() {
        if (this.cpe == null) {
            return;
        }
        this.cpe.onRoomEventUpdate(112, 0L, "");
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void adN() {
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void adO() {
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void adP() {
        if (this.cpe != null) {
            this.cpe.onPeerConnectStateUpdate(2003);
        }
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void adQ() {
    }

    @Override // com.baidu.rtc.c
    public void b(BaiduRtcRoom.RtcLiveTransferMode rtcLiveTransferMode, String str) {
        if (this.cpe == null) {
            return;
        }
        this.cpe.onRoomEventUpdate(118, rtcLiveTransferMode.ordinal(), str);
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void b(com.baidu.rtc.a aVar) {
        int i;
        Log.e("BaiduRtcRoomImp", "=========onRemoteRender========" + aVar.cki);
        final BigInteger k = this.cpY.k(aVar.cke);
        if (k.longValue() == 0) {
            Log.e("BaiduRtcRoomImp", "onRemoteRender Userid is 0.");
        } else if (this.cpE.cmh == RtcParameterSettings.RtcVideoRenderMode.RTC_VIDEO_RENDER_MODE_EXTERNAL) {
            j bp = bp(k.longValue());
            Log.d("BaiduRtcRoomImp", "enable external video render mode with videoRenderer -> " + bp);
            if (bp != null) {
                aVar.cki.addSink(bp);
            } else {
                Log.d("BaiduRtcRoomImp", "Not found external render for user " + k);
            }
            this.cpe.onRoomEventUpdate(106, k.longValue(), "");
        } else {
            Log.d("BaiduRtcRoomImp", "it is internal video render mode");
            try {
                i = this.cpi.get(this.cpY.k(aVar.cke)).intValue();
            } catch (Exception e) {
                i = -1;
            }
            if (i >= 0 && i < coV && this.cpJ != null) {
                if (this.cpJ[i] != null) {
                    this.cpJ[i].setFirstFrameEventListener(new Runnable() { // from class: com.baidu.rtc.b.a.8
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.cpe != null) {
                                a.this.cpe.onRoomEventUpdate(106, k.longValue(), "");
                            }
                        }
                    });
                    aVar.cki.addSink(this.cpJ[i]);
                }
                aVar.ckj = i;
            } else if (this.cpJ != null) {
                int i2 = 0;
                while (true) {
                    if (i2 >= this.cpk.length) {
                        i2 = -1;
                        break;
                    } else if (!this.cpk[i2]) {
                        this.cpk[i2] = true;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i2 >= 0) {
                    if (this.cpJ[i2] != null) {
                        this.cpJ[i2].setFirstFrameEventListener(new Runnable() { // from class: com.baidu.rtc.b.a.9
                            @Override // java.lang.Runnable
                            public void run() {
                                if (a.this.cpe != null) {
                                    a.this.cpe.onRoomEventUpdate(106, k.longValue(), "");
                                }
                            }
                        });
                        aVar.cki.addSink(this.cpJ[i2]);
                    }
                    aVar.ckj = i2;
                }
                this.cpN++;
            }
        }
    }

    @Override // com.baidu.rtc.c
    public void b(BigInteger bigInteger) {
        if (this.cpe == null) {
            return;
        }
        this.cpe.onPeerConnectStateUpdate(2003);
    }

    @Override // com.baidu.rtc.c
    public void b(BigInteger bigInteger, String str) {
        if (this.cpy == bigInteger.longValue()) {
            this.cpy = 0L;
        }
        if (this.cpx == bigInteger.longValue()) {
            this.cpx = 0L;
        }
        if (this.cpe == null) {
            return;
        }
        this.cpe.onRoomEventUpdate(104, bigInteger.longValue(), str);
    }

    @Override // com.baidu.rtc.c
    public void b(final BigInteger bigInteger, JSONObject jSONObject) {
        this.cqc.b(bigInteger, new SessionDescription(SessionDescription.Type.fromCanonicalForm(jSONObject.optString("type")), jSONObject.optString("sdp")));
        this.mHandler.post(new Runnable() { // from class: com.baidu.rtc.b.a.3
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.cpr || bigInteger == a.this.cpG || a.this.cqc == null) {
                    return;
                }
                if (a.this.cpj.get(bigInteger) != null) {
                    a.this.cqc.a(false, 0, bigInteger, PeerConnectionClient.StatsEventsType.GET_QUALITY_MONITOR_EVENT);
                    a.this.cpj.remove(bigInteger);
                }
                a.this.cqc.a(a.this.cpr, 2000, bigInteger, PeerConnectionClient.StatsEventsType.GET_QUALITY_MONITOR_EVENT);
                a.this.cpj.put(bigInteger, new com.baidu.rtc.c.b());
            }
        });
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void b(SessionDescription sessionDescription, BigInteger bigInteger) {
        Log.e("BaiduRtcRoomImp", sessionDescription.type.toString());
        this.cpY.d(bigInteger, sessionDescription);
    }

    public void bb(Context context) {
        Log.d("BaiduRtcRoomImp", "setup so later loading feature, and cpu type: " + this.mCpuType);
        com.baidu.cloudbase.b.a.aa(context).dw(this.mCpuType);
        if (this.cpT.isEmpty()) {
            com.baidu.cloudbase.b.a.aa(context).a(com.baidu.cloudbase.b.b.uI(), true, this.cpQ);
            return;
        }
        Log.d("BaiduRtcRoomImp", "setup so later load url: " + this.cpT);
        com.baidu.cloudbase.b.a.aa(context).a(this.cpT, true, this.cpQ);
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void bk(long j) {
        if (this.cpY != null) {
            this.cpY.bk(j);
        }
    }

    @Override // com.baidu.rtc.c
    public void bl(long j) {
        if (this.cpe == null) {
            return;
        }
        this.cpe.onRoomEventUpdate(114, j, "");
    }

    @Override // com.baidu.rtc.c
    public void bm(long j) {
        if (this.cpe == null) {
            return;
        }
        this.cpe.onRoomEventUpdate(115, j, "");
    }

    @Override // com.baidu.rtc.c
    public void bn(long j) {
        if (this.cpe == null) {
            return;
        }
        this.cpe.onRoomEventUpdate(113, j, "");
    }

    public j bp(long j) {
        j kVar;
        synchronized (this) {
            Log.d("BaiduRtcRoomImp", j + " : Get external renderer.");
            if (this.cpU.containsKey(Long.valueOf(j))) {
                kVar = this.cpU.get(Long.valueOf(j));
            } else {
                kVar = new k(this.cpe, j);
                Log.d("BaiduRtcRoomImp", j + " : Create external renderer" + kVar);
                this.cpU.put(Long.valueOf(j), kVar);
            }
        }
        return kVar;
    }

    @Override // com.baidu.rtc.c
    public void c(BaiduRtcRoom.RtcLiveTransferMode rtcLiveTransferMode, String str) {
        if (this.cpe == null) {
            return;
        }
        this.cpe.onRoomEventUpdate(116, rtcLiveTransferMode.ordinal(), str);
    }

    @Override // com.baidu.rtc.c
    public void c(final BigInteger bigInteger) {
        if (this.cpe != null) {
            this.cpe.onRoomEventUpdate(100, 0L, "ok");
        }
        this.cpG = bigInteger;
        if (this.cpE.AutoPublish) {
            n(bigInteger);
        }
        if (this.cpZ && this.cqc != null) {
            this.cqc.a(this.cpZ, 5000, this.cpG, PeerConnectionClient.StatsEventsType.GET_BWE_EVENT);
        }
        this.mHandler.post(new Runnable() { // from class: com.baidu.rtc.b.a.2
            @Override // java.lang.Runnable
            public void run() {
                if ((a.this.cps || a.this.cpr) && a.this.cqc != null) {
                    if (a.this.cpj.get(bigInteger) != null) {
                        a.this.cqc.a(false, 0, bigInteger, PeerConnectionClient.StatsEventsType.GET_QUALITY_MONITOR_EVENT);
                        a.this.cpj.remove(bigInteger);
                    }
                    a.this.cqc.a(a.this.cps || a.this.cpr, 2000, bigInteger, PeerConnectionClient.StatsEventsType.GET_QUALITY_MONITOR_EVENT);
                    a.this.cpj.put(bigInteger, new com.baidu.rtc.c.b());
                    if (a.this.cqf != null && !a.this.cqa) {
                        a.this.cqa = true;
                        a.this.mHandler.post(a.this.cqd);
                    }
                    a aVar = a.this;
                    aVar.kc("RTCROOM_LOGIN_OK_" + a.this.mUserId);
                }
                b bVar = (b) a.this.cpM.get(BigInteger.valueOf(a.this.mUserId));
                if (bVar != null) {
                    if (a.this.cqc != null) {
                        a.this.cqc.a(false, 0, bVar.cke, PeerConnectionClient.StatsEventsType.GET_AUDIOLEVEL_EVENT);
                    }
                    bVar.cqq = Boolean.valueOf(a.this.cpE.HasVideo);
                    bVar.cqp = Boolean.valueOf(a.this.cpE.HasAudio);
                    bVar.cke = bigInteger;
                    bVar.nickName = a.this.mDisplayName;
                } else {
                    a.this.cpM.put(BigInteger.valueOf(a.this.mUserId), new b(bigInteger, a.this.mUserId, Boolean.valueOf(a.this.cpE.HasVideo), Boolean.valueOf(a.this.cpE.HasAudio), a.this.mDisplayName));
                }
                if (a.this.cqc != null) {
                    a.this.cqc.a(true, 200, bigInteger, PeerConnectionClient.StatsEventsType.GET_AUDIOLEVEL_EVENT);
                }
            }
        });
    }

    @Override // com.baidu.rtc.c
    public void c(BigInteger bigInteger, String str) {
        if (this.cpe == null) {
            return;
        }
        this.cpe.onRoomEventUpdate(302, bigInteger.longValue(), str);
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void c(boolean z, boolean z2, String str) {
        this.cps = z;
        this.cpr = z2;
        this.cpH = str;
        if (!z && !z2) {
            if (this.cpg != null) {
                this.cpg.pause();
                return;
            }
            return;
        }
        if (this.cpg == null) {
            this.cpg = new com.baidu.rtc.c.a(this.cpR);
        }
        if (this.cqf == null) {
            this.cqf = d.aeY();
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void changeSurfaceSize(long j, int i, int i2) {
        if (this.cpU.containsKey(Long.valueOf(j))) {
            j jVar = this.cpU.get(Long.valueOf(j));
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
        if (this.cpY != null) {
            this.cpY.d(j, z);
        }
    }

    @Override // com.baidu.rtc.c
    public void d(BigInteger bigInteger) {
        if (this.cqc != null) {
            this.cqc.h(bigInteger);
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void dQ(boolean z) {
        if (this.cqc != null) {
            this.cqc.setSpeakerMute(z);
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void destroyExternalSurface(long j, Surface surface) {
        j jVar;
        if (this.cpU.containsKey(Long.valueOf(j)) && (jVar = this.cpU.get(Long.valueOf(j))) != null && surface == jVar.getSurface()) {
            jVar.releaseSurface();
        }
        aeH();
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void disbandRoom() {
        if (this.cpY != null) {
            this.cpY.disbandRoom();
        }
    }

    public void doDestroy() {
        logoutRtcRoom();
        coW.remove(toString());
    }

    @Override // com.baidu.rtc.c
    public void e(BigInteger bigInteger) {
        if (this.cpe == null) {
            return;
        }
        this.cpe.onRoomEventUpdate(301, bigInteger.longValue(), "");
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void enableExternalVideoCapturer(boolean z) {
        this.cpq = z;
        this.cpX = new VideoSink() { // from class: com.baidu.rtc.b.a.12
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
        if (this.cpe == null) {
            return;
        }
        this.cpe.onPeerConnectStateUpdate(2000);
        kc("WEBRTC_UP_" + bigInteger.longValue());
    }

    @Override // com.baidu.rtc.c
    public void h(boolean z, int i) {
        if (this.cpe == null) {
            return;
        }
        this.cpe.onPeerConnectStateUpdate(i < 10 ? 2100 : i < 15 ? RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL1 : i < 25 ? RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL2 : i < 40 ? RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL3 : i < 60 ? RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL4 : i < 90 ? RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL5 : i < 120 ? RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL6 : i < 180 ? RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL7 : i < 250 ? RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL8 : RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL9);
    }

    @Override // com.baidu.rtc.c
    public void hd(int i) {
        if (this.cpe != null && i == 436) {
            this.cpe.onErrorInfoUpdate(RTCConst.RTC_ROOM_USERID_ALREADY_EXIST_ERROR);
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public boolean jU(String str) {
        this.cpY.jY(str);
        return true;
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void jV(String str) {
        if (this.cpe != null) {
            this.cpe.onErrorInfoUpdate(10000);
        }
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void l(ByteBuffer byteBuffer) {
        if (this.cpe == null) {
            return;
        }
        this.cpe.onRoomDataMessage(byteBuffer);
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public boolean loginRtcRoomWithRoomName(String str, long j, String str2, boolean z) {
        Log.i("BaiduRtcRoomImp", "enable force login");
        this.cpo = z;
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
        this.cpn = z;
        this.cpm = z2;
        if (this.cpt && !this.cpv) {
            this.cpS = new Thread(new Runnable() { // from class: com.baidu.rtc.b.a.15
                @Override // java.lang.Runnable
                public void run() {
                    Log.d("BaiduRtcRoomImp", "setup downloading thread ......");
                    a.this.bb(a.this.cpR);
                }
            });
            this.cpS.start();
            return true;
        } else if (j == 0) {
            throw new InvalidParameterException("loginRtcRoomWithRoomName: Param Error,userId cann't be zero. zero is reserved.");
        } else {
            this.cpY.jZ(str);
            this.cpY.setUserId(j);
            if (str2 != null && !str2.isEmpty()) {
                this.cpY.setDisplayName(str2);
            }
            this.cpY.setVideoCodec(this.cpE.VideoCodec);
            this.cpY.ea(z);
            this.cpY.dZ(z2);
            int i5 = this.cpE.VideoWidth;
            int i6 = this.cpE.VideoHeight;
            String lowerCase = this.cpE.VideoResolution.toLowerCase();
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
                this.cpE.clZ = true;
            }
            this.ckO = new PeerConnectionClient.c(false, i, i6, this.cpE.VideoFps, this.cpE.VideoCodec.toUpperCase(), true, 0, "opus", false, false, this.cpE.clZ, this.coZ.booleanValue(), this.cpa.booleanValue(), this.cpE.VideoMaxkbps, this.cpE.VideoMinkbps, this.cpE.cmg, this.cpE.clY, true, this.cpE.cmb, this.cpE.cme, this.cpE.cmc, this.cpE.cmf);
            this.cqc = PeerConnectionClient.adK();
            if (this.cph) {
                if (this.cpd == null) {
                    this.cpd = new com.baidu.cloudbase.a.a();
                }
                this.cpd.aR(false);
                if (this.cpI < 0) {
                    this.cpI = this.cpd.uB();
                }
                this.cpd.uC();
                this.cpd.aQ(false);
                this.cpd.aP(false);
                this.cpd.a(this.cpD);
            }
            if (this.cpO != null || this.cph) {
                this.cqc.a(this.cpP);
            }
            if (this.cpK != null || this.cph) {
                this.cqc.a(this.cpL);
            }
            if (this.cpE != null) {
                this.cpY.dU(this.cpE.HasAudio);
                this.cqc.dU(this.cpE.HasAudio);
                this.cpY.dW(this.cpE.HasVideo);
                this.cqc.dW(this.cpE.HasVideo);
                this.cpY.dV(this.cpE.HasData);
                this.cqc.dV(this.cpE.HasData);
                this.cqc.he(this.cpE.AudioFrequency);
                this.cqc.setAudioChannel(this.cpE.AudioChannel);
                this.cpY.hf(this.cpE.ConnectionTimeoutMs);
                this.cpY.hg(this.cpE.ReadTimeoutMs);
                this.cpY.eb(this.cpE.AutoPublish);
                this.cpY.ec(this.cpE.AutoSubScribe);
            }
            this.cqc.dT(this.cpp);
            this.cqc.dS(ckK);
            this.cqc.a(this.mContext.get(), this.ckO, this);
            this.cpY.K(this.cpw, this.cpo);
            Log.i("BRTC", "loginRtcRoomWithRoomName: this " + this + " version: " + version());
            return true;
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public boolean logoutRtcRoom() {
        if (this.cqc != null) {
            this.cqc.dR(false);
            this.cqc.dX(false);
            this.cqc.adM();
            this.cpY.Cf();
            this.cpY.finalize();
            this.cqc.close();
            if (this.cpg != null) {
                this.cpg.pause();
            }
            this.cpj.clear();
            this.cqc = null;
            this.cpY = null;
            if (this.cpd != null) {
                this.cpd.a(null);
                this.cpd.release();
            }
            if (this.cpB != null) {
                this.cpB.release();
                this.cpB = null;
            }
            if (this.cpJ != null) {
                for (int i = 0; i < this.cpJ.length; i++) {
                    if (this.cpJ[i] != null) {
                        this.cpJ[i].release();
                        this.cpJ[i] = null;
                    }
                }
            }
            aeG();
            aeH();
            if (this.cqe != null) {
                this.cqe.release();
            }
            if (this.audioManager != null && this.audioManager.isBluetoothScoOn()) {
                c((Boolean) false);
            }
            if (this.cpl != null) {
                this.mContext.get().unregisterReceiver(this.cpl);
                this.cpl = null;
            }
            System.gc();
        }
        return true;
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void muteMicphone(boolean z) {
        if (this.cqc != null) {
            this.cqc.dR(!z);
        }
        kc("MUTE_MICPHONE");
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void onIceCandidatesRemoved(IceCandidate[] iceCandidateArr) {
    }

    public void presetLoudSpeaker(boolean z) {
        ((AudioManager) this.mContext.get().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND)).setSpeakerphoneOn(z);
        kc("PRESETLOUDSPEAKER");
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void sendMessageToUser(String str, long j) {
        if (this.cpY == null) {
            return;
        }
        this.cpY.sendMessageToUser(str, j);
        try {
            Thread.sleep(10L);
        } catch (InterruptedException e) {
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void setExternalSurface(long j, Surface surface) {
        j bp = bp(j);
        if (bp != null) {
            if (!bp.adR()) {
                bp.init();
                bp.dY(true);
            }
            for (Long l : this.cpU.keySet()) {
                j jVar = this.cpU.get(l);
                if (jVar != null && jVar.hasSurface() && surface == jVar.getSurface() && this.cpe != null) {
                    Log.d("BaiduRtcRoomImp", "Set surface repeat with userId " + j);
                    this.cpe.onErrorInfoUpdate(600);
                    return;
                }
            }
            bp.setSurface(surface);
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void setUserAttribute(String str) {
        if (this.cpY == null) {
            return;
        }
        this.cpY.setUserAttribute(str);
        try {
            Thread.sleep(10L);
        } catch (InterruptedException e) {
        }
    }
}
