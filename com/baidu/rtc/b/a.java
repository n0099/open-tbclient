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
    public static boolean ceX = false;
    static int ciY = -1;
    public static int ciZ = 30;
    private static ConcurrentHashMap<String, String> cja = new ConcurrentHashMap<>();
    public static int cjb = 1;
    BaiduRtcRoom.RtcLiveTransferMode cjC;
    private Context cjU;
    private int cjc;
    private Boolean cjg;
    private com.baidu.cloudbase.a.a cjh;
    com.baidu.rtc.c.a cjk;
    C0313a cjp;
    private boolean cjx;
    private VideoSink cka;
    private o ckb;
    private EglBase ckh;
    d cki;
    String mAppId;
    private WeakReference<Context> mContext;
    private String mCpuType;
    String mDisplayName;
    String mRoomName;
    long mUserId;
    private boolean cju = false;
    private boolean cjt = false;
    private boolean cjl = false;
    private volatile PeerConnectionClient ckf = null;
    private PeerConnectionClient.c cfb = null;
    private RTCVideoView cjE = null;
    private RTCVideoView[] cjM = null;
    private VideoCapturer cfk = null;
    private String cjz = "wss://rtc2.exp.bcelive.com/janus";
    private int cjQ = 0;
    private boolean cjY = true;
    private boolean[] cjo = new boolean[ciZ];
    private AudioManager audioManager = null;
    private int cjL = -1;
    BaiduRtcRoom.a cji = null;
    g.d cjR = null;
    g.c cjN = null;
    g.b cjF = null;
    private ConcurrentHashMap<Long, j> cjX = new ConcurrentHashMap<>();
    private IdentityHashMap<Long, j> cjI = new IdentityHashMap<>();
    private boolean cjZ = false;
    int cjj = ciY;
    private RtcParameterSettings cjH = new RtcParameterSettings();
    private Handler mHandler = new Handler(Looper.getMainLooper());
    BigInteger cjJ = null;
    volatile long cjB = 0;
    volatile long cjA = 0;
    ConcurrentHashMap<BigInteger, BigInteger> cjm = new ConcurrentHashMap<>();
    boolean ckc = true;
    double cke = 200.0d;
    boolean cjw = true;
    boolean cjv = false;
    String cjK = "online";
    private ConcurrentHashMap<BigInteger, com.baidu.rtc.c.b> cjn = new ConcurrentHashMap<>();
    boolean ckd = false;
    boolean cjq = true;
    boolean cjr = true;
    boolean cjs = false;
    Boolean cjd = false;
    Boolean cje = false;
    String cjD = "";
    private ConcurrentHashMap<BigInteger, b> cjP = new ConcurrentHashMap<>();
    private Thread cjV = null;
    private boolean cjy = false;
    private String cjW = "";
    private com.baidu.cloudbase.b.c cjT = new c.a() { // from class: com.baidu.rtc.b.a.1
        @Override // com.baidu.cloudbase.b.c
        public void V(String str, String str2) {
            Log.d("BaiduRtcRoomImp", "Be successful to download so!");
            String str3 = com.baidu.cloudbase.b.b.Z(a.this.cjU) + File.separator + "libjingle_peerconnection_so.so";
            Log.d("BaiduRtcRoomImp", "RTC so path is: " + str3);
            a.this.cjy = true;
            if (com.baidu.cloudbase.b.a.aa(a.this.cjU).dv(com.baidu.cloudbase.b.b.Z(a.this.cjU))) {
                try {
                    System.load(str3);
                    Log.d("BaiduRtcRoomImp", "loaded so, and start to login room.");
                    a.this.loginRtcRoomWithRoomName(a.this.mRoomName, a.this.mUserId, a.this.mDisplayName, a.this.cjr, a.this.cjq);
                    return;
                } catch (Throwable th) {
                    Log.d("BaiduRtcRoomImp", "Failed call System.load to load so! Error: " + th);
                    if (a.this.cji != null) {
                        a.this.cji.onErrorInfoUpdate(401);
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
                a.this.loginRtcRoomWithRoomName(a.this.mRoomName, a.this.mUserId, a.this.mDisplayName, a.this.cjr, a.this.cjq);
            } catch (Throwable th2) {
                Log.d("BaiduRtcRoomImp", "Failed to load so with full path! Error: " + th2);
                if (a.this.cji != null) {
                    a.this.cji.onErrorInfoUpdate(401);
                }
            }
        }

        @Override // com.baidu.cloudbase.b.c
        public void b(String str, int i, String str2) {
            Log.d("BaiduRtcRoomImp", "Failed to download so.");
            if (a.this.cji != null) {
                a.this.cji.onErrorInfoUpdate(400);
            }
        }
    };
    JavaAudioDeviceModule.SamplesReadyCallback cjS = new JavaAudioDeviceModule.SamplesReadyCallback() { // from class: com.baidu.rtc.b.a.17
        @Override // org.webrtc.audio.JavaAudioDeviceModule.SamplesReadyCallback
        public void onWebRtcAudioRecordSamplesReady(JavaAudioDeviceModule.AudioSamples audioSamples) {
            if (audioSamples == null || audioSamples.getData() == null || audioSamples.getData().length <= 0) {
                return;
            }
            if (a.this.cjR != null) {
                a.this.cjR.a(new g(audioSamples.getAudioFormat(), audioSamples.getChannelCount(), audioSamples.getSampleRate(), audioSamples.getData()));
            }
            if (!a.this.cjl || a.this.cjt) {
                return;
            }
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            bufferInfo.size = audioSamples.getData().length;
            bufferInfo.offset = 0;
            a.this.cjh.a(ByteBuffer.wrap(audioSamples.getData()), bufferInfo);
        }
    };
    JavaAudioDeviceModule.RemoteSamplesReadyCallback cjO = new JavaAudioDeviceModule.RemoteSamplesReadyCallback() { // from class: com.baidu.rtc.b.a.18
        @Override // org.webrtc.audio.JavaAudioDeviceModule.RemoteSamplesReadyCallback
        public void onWebRtcAudioRemoteSamplesReady(JavaAudioDeviceModule.AudioSamples audioSamples) {
            if (audioSamples == null) {
                return;
            }
            if (a.this.cjN != null) {
                a.this.cjN.c(new g(audioSamples.getAudioFormat(), audioSamples.getChannelCount(), audioSamples.getSampleRate(), audioSamples.getData()));
            }
            if (!a.this.cjl || a.this.cjL < 0) {
                return;
            }
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            bufferInfo.size = audioSamples.getData().length;
            bufferInfo.offset = 0;
            a.this.cjh.a(ByteBuffer.wrap(audioSamples.getData()), bufferInfo, a.this.cjL);
        }
    };
    g.a cjf = new g.a() { // from class: com.baidu.rtc.b.a.19
    };
    private com.baidu.cloudbase.c.a cjG = new com.baidu.cloudbase.c.a() { // from class: com.baidu.rtc.b.a.20
        @Override // com.baidu.cloudbase.c.a
        public void onFilteredFrameUpdate(byte[] bArr, MediaCodec.BufferInfo bufferInfo) {
            if (a.this.cjF != null) {
                a.this.cjF.b(new g(2, a.this.cjH.AudioChannel, a.this.cjH.AudioFrequency, bArr));
            }
        }
    };
    private Runnable ckg = new Runnable() { // from class: com.baidu.rtc.b.a.14
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.cki != null && (a.this.cjw || a.this.cjv)) {
                a.this.acj();
            }
            a.this.mHandler.postDelayed(a.this.ckg, 300000L);
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.rtc.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C0313a extends BroadcastReceiver {
        C0313a() {
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
                                if (s == a.this.cjc) {
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
        public BigInteger ces;
        public Boolean cks;
        public Boolean ckt;
        public String nickName;
        public long userId;
        public int volume = -1;

        public b(BigInteger bigInteger, long j, Boolean bool, Boolean bool2, String str) {
            this.nickName = "";
            this.ces = bigInteger;
            this.userId = j;
            this.cks = bool2;
            this.ckt = bool;
            this.nickName = str;
        }
    }

    public a(Context context, String str, String str2, String str3, boolean z) {
        this.mContext = null;
        this.ckb = null;
        this.ckh = null;
        this.cjp = null;
        this.cjx = false;
        this.mCpuType = "armeabi-v7a";
        this.cjU = null;
        this.cjx = z;
        this.cjU = context;
        this.mContext = new WeakReference<>(context);
        this.mCpuType = str3;
        this.ckb = new o();
        this.ckb.setAppId(str);
        this.ckb.jM(str2);
        this.ckb.jL("BRTC.Android.SDK V" + version());
        this.mAppId = str;
        this.ckb.a(this);
        this.ckh = EglBase_CC.create();
        for (int i = 0; i < this.cjo.length; i++) {
            this.cjo[i] = false;
        }
        AudioManager audioManager = (AudioManager) this.mContext.get().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        audioManager.setSpeakerphoneOn(false);
        if (this.cjw || this.cjv) {
            this.cjk = new com.baidu.rtc.c.a(context);
            this.cki = d.acy();
        }
        this.cjc = 0;
        this.cjg = false;
        audioManager = audioManager == null ? (AudioManager) this.mContext.get().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND) : audioManager;
        this.cjp = new C0313a();
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
        this.mContext.get().registerReceiver(this.cjp, intentFilter);
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
        if (this.cjj == ciY || this.cjj >= deviceNames.length || (createCapturer3 = cameraEnumerator.createCapturer(deviceNames[this.cjj], null)) == null) {
            Log.d("BaiduRtcRoomImp", "Looking for front facing cameras.");
            for (String str : deviceNames) {
                if (cameraEnumerator.isFrontFacing(str)) {
                    Log.d("BaiduRtcRoomImp", "Creating front facing camera capturer.");
                    if (!cja.containsValue(str) && (createCapturer2 = cameraEnumerator.createCapturer(str, null)) != null) {
                        cja.put(toString(), str);
                        this.cjZ = true;
                        if (this.cjE != null) {
                            this.cjE.setMirror(true);
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
                    if (!cja.containsValue(str2) && (createCapturer = cameraEnumerator.createCapturer(str2, null)) != null) {
                        cja.put(toString(), str2);
                        this.cjZ = false;
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
        if (this.ckb == null) {
            return;
        }
        if (bigInteger == this.cjJ) {
            i = BigInteger.valueOf(this.mUserId);
        } else {
            i = this.ckb.i(bigInteger);
            if (i == null) {
                return;
            }
        }
        b bVar = this.cjP.get(i);
        if (bVar == null && this.ckf != null) {
            this.ckf.a(false, 0, bigInteger, PeerConnectionClient.StatsEventsType.GET_AUDIOLEVEL_EVENT);
            return;
        }
        for (StatsReport statsReport : statsReportArr) {
            if (bigInteger == this.cjJ) {
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

    private void aS(long j) {
        synchronized (this) {
            if (this.cjX.containsKey(Long.valueOf(j))) {
                this.cjI.put(Long.valueOf(j), this.cjX.get(Long.valueOf(j)));
                this.cjX.remove(Long.valueOf(j));
            }
        }
    }

    private boolean ace() {
        return !Build.MODEL.contains("SABRESD-MX6DQ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public VideoCapturer acf() {
        VideoCapturer a2;
        if (this.cfk != null) {
            return this.cfk;
        }
        if (ack()) {
            Log.d("BaiduRtcRoomImp", "Creating capturer using camera2 API.");
            a2 = a(new Camera2Enumerator(this.mContext.get()));
        } else {
            Log.d("BaiduRtcRoomImp", "Creating capturer using camera1 API.");
            a2 = a(new Camera1Enumerator(ace()));
        }
        if (a2 == null) {
            Log.e("BaiduRtcRoomImp", "Failed to open camera");
            return null;
        }
        return a2;
    }

    private void acg() {
        if (this.cjX.isEmpty()) {
            return;
        }
        for (Long l : this.cjX.keySet()) {
            j jVar = this.cjX.get(l);
            if (jVar != null) {
                if (jVar.getSurface() != null) {
                    jVar.releaseSurface();
                }
                jVar.release();
            }
            this.cjX.remove(l);
        }
    }

    private void ach() {
        synchronized (this) {
            if (this.cjI.isEmpty()) {
                return;
            }
            for (j jVar : this.cjI.values()) {
                if (jVar != null) {
                    if (jVar.getSurface() != null) {
                        jVar.releaseSurface();
                    }
                    jVar.release();
                }
            }
            this.cjI.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aci() {
        com.baidu.rtc.c.b bVar;
        if (this.ckb == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        boolean z = true;
        com.baidu.rtc.c.b bVar2 = this.cjn.get(this.cjJ);
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
            if (this.cjk != null) {
                jSONObject3.put("sysCpuUsage", this.cjk.acs());
            }
            jSONObject3.put("appCpuUsage", 0);
            jSONObject2.put("resourceUsageInfo", jSONObject3);
            if (this.cjw) {
                JSONObject jSONObject4 = new JSONObject();
                if (z2) {
                    jSONObject4.put("bitrate", hashMap.get("bitrate_s"));
                    jSONObject4.put("packetloss", hashMap.get("packetloss_s"));
                    jSONObject4.put("fps", hashMap.get("fps_s"));
                    if (bVar2 == null) {
                        jSONObject4.put("resolution", "");
                    } else {
                        jSONObject4.put("resolution", bVar2.acw());
                    }
                } else {
                    jSONObject4.put("bitrate", 0);
                    jSONObject4.put("packetloss", 0);
                    jSONObject4.put("fps", 0);
                    jSONObject4.put("resolution", "");
                }
                jSONObject2.put("senderQualityInfo", jSONObject4);
            }
            if (this.cjv) {
                JSONArray jSONArray = new JSONArray();
                for (BigInteger bigInteger : this.cjn.keySet()) {
                    if (bigInteger != this.cjJ && (bVar = this.cjn.get(bigInteger)) != null) {
                        HashMap hashMap2 = new HashMap();
                        bVar.t(hashMap2);
                        if (hashMap2.size() != 0) {
                            JSONObject jSONObject5 = new JSONObject();
                            jSONObject5.put("feedId", this.ckb.i(bigInteger));
                            jSONObject5.put("bitrate", hashMap2.get("bitrate_r"));
                            jSONObject5.put("packetloss", hashMap2.get("packetloss_r"));
                            jSONObject5.put("fps", hashMap2.get("fps_r"));
                            jSONObject5.put("resolution", bVar.acv());
                            jSONArray.put(jSONObject5);
                        }
                    }
                }
                jSONObject2.put("receiverQualityInfoList", jSONArray);
            }
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put("communicationQualityInfo", jSONObject2);
            jSONObject.put("env", this.cjK);
            jSONObject.put("appId", this.mAppId);
            jSONObject.put("roomId", this.ckb.getRoomId());
            jSONObject.put("timestamp", System.currentTimeMillis());
            jSONObject.put(TbEnum.SystemMessage.KEY_USER_ID, this.mUserId);
            jSONObject.put("message", jSONObject6);
        } catch (JSONException e) {
            Log.e("BaiduRtcRoomImp", "Caught error on reportCommunicationQualityInfo: " + e);
        }
        this.cki.H(jSONObject.toString(), 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void acj() {
        if (this.ckb == null) {
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
            jSONObject.put("env", this.cjK);
            jSONObject.put("appId", this.mAppId);
            jSONObject.put("roomId", this.ckb.getRoomId());
            jSONObject.put("timestamp", System.currentTimeMillis());
            jSONObject.put(TbEnum.SystemMessage.KEY_USER_ID, this.mUserId);
            jSONObject.put("message", jSONObject3);
        } catch (JSONException e) {
            Log.e("BaiduRtcRoomImp", "Caught error on reportDeviceInfo: " + e);
        }
        this.cki.H(jSONObject.toString(), 0);
    }

    private boolean ack() {
        Camera2Enumerator.disableExtraCamera(this.cjH.cgj);
        return Camera2Enumerator.isSupported(this.mContext.get());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int c(Boolean bool) {
        if (this.cjg == bool) {
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
            this.cjg = bool;
            return 0;
        } catch (Exception e) {
            Log.e("BaiduRtcRoomImp", "set bluetooth sco fail: " + e.getMessage());
            return -1;
        }
    }

    public static void dI(boolean z) {
        ceX = z;
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
    public void jN(String str) {
        if ((this.cjw || this.cjv) && this.ckb != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(TbEnum.SystemMessage.KEY_USER_NAME, this.mDisplayName);
                jSONObject2.put("eventDescription", str);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("roomEvent", jSONObject2);
                jSONObject.put("env", this.cjK);
                jSONObject.put("appId", this.mAppId);
                jSONObject.put("roomId", this.ckb.getRoomId());
                jSONObject.put("timestamp", System.currentTimeMillis());
                jSONObject.put(TbEnum.SystemMessage.KEY_USER_ID, this.mUserId);
                jSONObject.put("message", jSONObject3);
            } catch (JSONException e) {
                Log.e("BaiduRtcRoomImp", "Caught error on reportRoomEventInfo: " + e);
            }
            this.cki.H(jSONObject.toString(), 1);
        }
    }

    private void l(final BigInteger bigInteger) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.rtc.b.a.12
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.cjH.HasVideo) {
                    a.this.cfk = a.this.acf();
                }
                if (a.this.cju) {
                    a.this.ckf.a(a.this.ckh.getEglBaseContext(), a.this.cka, a.this.cfk, bigInteger);
                } else {
                    a.this.ckf.a(a.this.ckh.getEglBaseContext(), a.this.cjE, a.this.cfk, bigInteger);
                }
                a.this.ckf.g(bigInteger);
            }
        });
    }

    static /* synthetic */ int s(a aVar) {
        int i = aVar.cjc + 1;
        aVar.cjc = i;
        return i;
    }

    static /* synthetic */ int t(a aVar) {
        int i = aVar.cjc;
        aVar.cjc = i + 1;
        return i;
    }

    public static String version() {
        return "1.2.10";
    }

    @Override // com.baidu.rtc.c
    public void a(BaiduRtcRoom.RtcLiveTransferMode rtcLiveTransferMode, String str) {
        if (this.cji == null) {
            return;
        }
        this.cji.onRoomEventUpdate(117, rtcLiveTransferMode.ordinal(), str);
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
                    this.cjH = rtcParameterSettings;
                    cjb = this.cjH.AudioContentType;
                    return;
                }
                return;
            case RTC_VIDEO_PARAM_SETTINGS_BITRATE:
                this.cjH.VideoMaxkbps = rtcParameterSettings.VideoMaxkbps;
                if (this.ckf == null || this.mHandler == null) {
                    return;
                }
                this.mHandler.post(new Runnable() { // from class: com.baidu.rtc.b.a.11
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.ckf == null || a.this.cjH.VideoMaxkbps <= 0) {
                            return;
                        }
                        Log.d("BaiduRtcRoomImp", "Set video maximum bitrate: " + a.this.cjH.VideoMaxkbps);
                        a.this.ckf.b(Integer.valueOf(a.this.cjH.VideoMaxkbps));
                    }
                });
                return;
            case RTC_VIDEO_PARAM_SETTINGS_RENDER_MODE:
                this.cjH.cgo = rtcParameterSettings.cgo;
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void a(g.d dVar) {
        this.cjR = dVar;
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void a(i iVar) {
        this.cfk = iVar;
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void a(final Boolean bool, final Boolean bool2, final BigInteger bigInteger) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.rtc.b.a.8
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.ckb == null) {
                    return;
                }
                BigInteger i = a.this.ckb.i(bigInteger);
                String j = a.this.ckb.j(i);
                b bVar = (b) a.this.cjP.get(i);
                if (bVar == null) {
                    bVar = new b(bigInteger, i.longValue(), bool, bool2, j);
                    a.this.cjP.put(i, bVar);
                } else {
                    bVar.ckt = bool;
                    bVar.cks = bool2;
                    bVar.ces = bigInteger;
                    bVar.nickName = j;
                }
                if (!bool2.booleanValue() || a.this.ckf == null) {
                    return;
                }
                a.this.ckf.a(true, 200, bVar.ces, PeerConnectionClient.StatsEventsType.GET_AUDIOLEVEL_EVENT);
            }
        });
    }

    @Override // com.baidu.rtc.c
    public void a(BigInteger bigInteger, int i, boolean z) {
        if (this.cji == null) {
            return;
        }
        this.cji.onPeerConnectStateUpdate(z ? 2001 : 2002);
    }

    @Override // com.baidu.rtc.c
    public void a(BigInteger bigInteger, String str) {
        if (this.cji == null) {
            return;
        }
        this.cji.onRoomEventUpdate(303, bigInteger.longValue(), str);
    }

    @Override // com.baidu.rtc.c
    public void a(BigInteger bigInteger, String str, String str2) {
        if (this.cji == null) {
            return;
        }
        this.cji.onRoomEventUpdate(300, bigInteger.longValue(), str);
    }

    @Override // com.baidu.rtc.c
    public void a(final BigInteger bigInteger, final BigInteger bigInteger2) {
        int i;
        Log.i("BaiduRtcRoomImp", "==================onLeaving=======================");
        this.mHandler.post(new Runnable() { // from class: com.baidu.rtc.b.a.5
            @Override // java.lang.Runnable
            public void run() {
                a.this.cjP.remove(bigInteger2);
                if (a.this.cjn.get(bigInteger) != null) {
                    a.this.cjn.remove(bigInteger);
                    if (a.this.ckf != null) {
                        a.this.ckf.a(false, 0, bigInteger, PeerConnectionClient.StatsEventsType.GET_QUALITY_MONITOR_EVENT);
                    }
                }
            }
        });
        com.baidu.rtc.a h = this.ckf.h(bigInteger);
        if (this.cjH.cgo == RtcParameterSettings.RtcVideoRenderMode.RTC_VIDEO_RENDER_MODE_EXTERNAL) {
            j jVar = this.cjX.get(Long.valueOf(bigInteger2.longValue()));
            if (jVar == null || h == null) {
                Log.d("BaiduRtcRoomImp", "No external render has found!");
            } else {
                Log.d("BaiduRtcRoomImp", "remove external video sink of user " + bigInteger2);
                jVar.clearImage();
                if (h.cew != null) {
                    h.cew.removeSink(jVar);
                }
                aS(bigInteger2.longValue());
                if (this.cji != null) {
                    if (this.cjA == bigInteger2.longValue()) {
                        return;
                    }
                    this.cji.onRoomEventUpdate(107, bigInteger2.longValue(), "gone");
                    this.cjA = bigInteger2.longValue();
                    return;
                }
            }
        }
        if (h != null && (i = h.cex) >= 0 && i < this.cjo.length) {
            this.cjo[i] = false;
            this.cjQ--;
            if (this.cjM[i] != null) {
                this.cjM[i].clearImage();
                if (h.cew != null) {
                    h.cew.removeSink(this.cjM[i]);
                }
                if (this.cji != null) {
                    if (this.cjA != bigInteger2.longValue()) {
                        this.cji.onRoomEventUpdate(107, bigInteger2.longValue(), "gone");
                        this.cjA = bigInteger2.longValue();
                        return;
                    }
                    return;
                }
            }
        }
        if (this.cji != null) {
            if (this.cjB == bigInteger2.longValue()) {
                return;
            }
            this.cjm.remove(bigInteger2);
            this.cji.onRoomEventUpdate(105, bigInteger2.longValue(), "leaving");
        }
        this.cjB = bigInteger2.longValue();
        jN("REMOTE_LEAVING_" + bigInteger2 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + bigInteger);
    }

    @Override // com.baidu.rtc.c
    public void a(BigInteger bigInteger, JSONObject jSONObject) {
        this.ckf.a(bigInteger, new SessionDescription(SessionDescription.Type.fromCanonicalForm(jSONObject.optString("type")), jSONObject.optString("sdp")));
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void a(IceCandidate iceCandidate, BigInteger bigInteger) {
        Log.e("BaiduRtcRoomImp", "=========onIceCandidate========");
        if (iceCandidate != null) {
            this.ckb.a(bigInteger, iceCandidate);
        } else {
            this.ckb.k(bigInteger);
        }
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void a(SessionDescription sessionDescription, BigInteger bigInteger) {
        Log.e("BaiduRtcRoomImp", sessionDescription.type.toString());
        if (this.ckb == null) {
            return;
        }
        this.ckb.c(bigInteger, sessionDescription);
        this.mHandler.post(new Runnable() { // from class: com.baidu.rtc.b.a.6
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.ckf == null || a.this.cfb.cfS <= 0) {
                    return;
                }
                Log.d("BaiduRtcRoomImp", "Set video maximum bitrate: " + a.this.cfb.cfS);
                a.this.ckf.b(Integer.valueOf(a.this.cfb.cfS));
            }
        });
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void a(RTCVideoView[] rTCVideoViewArr) {
        this.cjM = rTCVideoViewArr;
        this.mHandler.post(new Runnable() { // from class: com.baidu.rtc.b.a.2
            @Override // java.lang.Runnable
            public void run() {
                for (int i = 0; i < a.this.cjM.length; i++) {
                    if (a.this.cjM[i] != null) {
                        try {
                            a.this.cjM[i].init(a.this.ckh.getEglBaseContext(), null);
                        } catch (Exception e) {
                        }
                        a.this.cjM[i].setEnableHardwareScaler(true);
                    }
                }
            }
        });
    }

    public void a(StatsReport[] statsReportArr) {
        StatsReport.Value[] valueArr;
        if (this.cji == null) {
            return;
        }
        for (StatsReport statsReport : statsReportArr) {
            if (statsReport.id.equals("bweforvideo")) {
                for (StatsReport.Value value : statsReport.values) {
                    if (value.name.equals("googAvailableSendBandwidth")) {
                        this.cke = Double.parseDouble(value.value);
                        if (this.cke > 100.0d) {
                            this.cji.onRoomEventUpdate(200, (long) this.cke, statsReport.toString());
                        }
                    }
                }
                return;
            }
        }
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void a(final StatsReport[] statsReportArr, final BigInteger bigInteger, final PeerConnectionClient.StatsEventsType statsEventsType) {
        if (bigInteger == this.cjJ && statsEventsType == PeerConnectionClient.StatsEventsType.GET_BWE_EVENT && this.ckc) {
            a(statsReportArr);
        }
        this.mHandler.post(new Runnable() { // from class: com.baidu.rtc.b.a.7
            @Override // java.lang.Runnable
            public void run() {
                if (statsEventsType == PeerConnectionClient.StatsEventsType.GET_AUDIOLEVEL_EVENT) {
                    a.this.a(statsReportArr, bigInteger);
                }
                if ((a.this.cjw || a.this.cjv) && statsEventsType == PeerConnectionClient.StatsEventsType.GET_QUALITY_MONITOR_EVENT) {
                    com.baidu.rtc.c.b bVar = (com.baidu.rtc.c.b) a.this.cjn.get(bigInteger);
                    if (bVar != null) {
                        bVar.b(statsReportArr);
                    }
                    if (bigInteger != a.this.cjJ || a.this.cki == null) {
                        return;
                    }
                    a.this.aci();
                }
            }
        });
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public boolean a(BaiduRtcRoom.a aVar) {
        this.cji = aVar;
        return true;
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public boolean a(String str, boolean z, boolean z2, String str2, BaiduRtcRoom.RtcLiveTransferMode rtcLiveTransferMode) {
        if (this.cjD.isEmpty() || this.cjC == rtcLiveTransferMode) {
            this.cjD = str;
            this.cjC = rtcLiveTransferMode;
            this.ckb.dV(z2);
            this.ckb.jJ(str);
            this.ckb.dU(z);
            this.ckb.jI(str2);
            this.ckb.a(rtcLiveTransferMode);
        } else {
            this.ckb.b(str, z, z2, str2, rtcLiveTransferMode);
        }
        return true;
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void aO(long j) {
        if (this.ckb != null) {
            this.ckb.aO(j);
        }
    }

    @Override // com.baidu.rtc.c
    public void aP(long j) {
        if (this.cji == null) {
            return;
        }
        this.cji.onRoomEventUpdate(114, j, "");
    }

    @Override // com.baidu.rtc.c
    public void aQ(long j) {
        if (this.cji == null) {
            return;
        }
        this.cji.onRoomEventUpdate(115, j, "");
    }

    @Override // com.baidu.rtc.c
    public void aR(long j) {
        if (this.cji == null) {
            return;
        }
        this.cji.onRoomEventUpdate(113, j, "");
    }

    public j aT(long j) {
        if (this.cjX.containsKey(Long.valueOf(j))) {
            return this.cjX.get(Long.valueOf(j));
        }
        k kVar = new k(this.cji, j);
        this.cjX.put(Long.valueOf(j), kVar);
        return kVar;
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public BaiduRtcRoom.c[] abc() {
        int i = 0;
        int i2 = 0;
        for (BigInteger bigInteger : this.cjP.keySet()) {
            b bVar = this.cjP.get(bigInteger);
            if (bVar.cks.booleanValue() && bVar.volume != -1) {
                i2++;
            }
        }
        BaiduRtcRoom.c[] cVarArr = new BaiduRtcRoom.c[i2];
        for (BigInteger bigInteger2 : this.cjP.keySet()) {
            b bVar2 = this.cjP.get(bigInteger2);
            if (bVar2.volume != -1 && bVar2.cks.booleanValue()) {
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
    public BaiduRtcRoom.d[] abd() {
        if (this.ckb == null) {
            return null;
        }
        return this.ckb.abx();
    }

    @Override // com.baidu.rtc.c
    public void abe() {
        if (this.cji == null) {
            return;
        }
        this.cji.onRoomEventUpdate(103, 0L, "coennection Error");
        jN("CONNECTION_LOST");
    }

    @Override // com.baidu.rtc.c
    public void abf() {
        if (this.cji == null) {
            return;
        }
        this.cji.onRoomEventUpdate(102, 0L, BdStatsConstant.StatsType.ERROR);
        jN("LOGIN_ERROR");
    }

    @Override // com.baidu.rtc.c
    public void abg() {
        if (this.cji == null) {
            return;
        }
        this.cji.onRoomEventUpdate(101, 0L, "time out");
    }

    @Override // com.baidu.rtc.c
    public void abh() {
        if (this.cji == null) {
            return;
        }
        this.cji.onRoomEventUpdate(112, 0L, "");
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void abo() {
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void abp() {
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void abq() {
        if (this.cji != null) {
            this.cji.onPeerConnectStateUpdate(2003);
        }
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void abr() {
    }

    @Override // com.baidu.rtc.c
    public void b(BaiduRtcRoom.RtcLiveTransferMode rtcLiveTransferMode, String str) {
        if (this.cji == null) {
            return;
        }
        this.cji.onRoomEventUpdate(118, rtcLiveTransferMode.ordinal(), str);
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void b(com.baidu.rtc.a aVar) {
        int i;
        Log.e("BaiduRtcRoomImp", "=========onRemoteRender========" + aVar.cew);
        final BigInteger i2 = this.ckb.i(aVar.ces);
        if (i2.longValue() == 0) {
            Log.e("BaiduRtcRoomImp", "onRemoteRender Userid is 0.");
        } else if (this.cjH.cgo == RtcParameterSettings.RtcVideoRenderMode.RTC_VIDEO_RENDER_MODE_EXTERNAL) {
            this.cji.onRoomEventUpdate(106, i2.longValue(), "");
            Log.d("BaiduRtcRoomImp", "enable external video render mode.");
            j aT = aT(i2.longValue());
            if (aT != null) {
                aVar.cew.addSink(aT);
                return;
            }
            Log.d("BaiduRtcRoomImp", "Not found external render for user " + i2);
        } else {
            Log.d("BaiduRtcRoomImp", "it is internal video render mode");
            try {
                i = this.cjm.get(this.ckb.i(aVar.ces)).intValue();
            } catch (Exception e) {
                i = -1;
            }
            if (i >= 0 && i < ciZ && this.cjM != null) {
                if (this.cjM[i] != null) {
                    this.cjM[i].setFirstFrameEventListener(new Runnable() { // from class: com.baidu.rtc.b.a.9
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.cji != null) {
                                a.this.cji.onRoomEventUpdate(106, i2.longValue(), "");
                            }
                        }
                    });
                    aVar.cew.addSink(this.cjM[i]);
                }
                aVar.cex = i;
            } else if (this.cjM != null) {
                int i3 = 0;
                while (true) {
                    if (i3 >= this.cjo.length) {
                        i3 = -1;
                        break;
                    } else if (!this.cjo[i3]) {
                        this.cjo[i3] = true;
                        break;
                    } else {
                        i3++;
                    }
                }
                if (i3 >= 0) {
                    if (this.cjM[i3] != null) {
                        this.cjM[i3].setFirstFrameEventListener(new Runnable() { // from class: com.baidu.rtc.b.a.10
                            @Override // java.lang.Runnable
                            public void run() {
                                if (a.this.cji != null) {
                                    a.this.cji.onRoomEventUpdate(106, i2.longValue(), "");
                                }
                            }
                        });
                        aVar.cew.addSink(this.cjM[i3]);
                    }
                    aVar.cex = i3;
                }
                this.cjQ++;
            }
        }
    }

    @Override // com.baidu.rtc.c
    public void b(BigInteger bigInteger) {
        if (this.cji == null) {
            return;
        }
        this.cji.onPeerConnectStateUpdate(2003);
    }

    @Override // com.baidu.rtc.c
    public void b(BigInteger bigInteger, String str) {
        if (this.cjB == bigInteger.longValue()) {
            this.cjB = 0L;
        }
        if (this.cjA == bigInteger.longValue()) {
            this.cjA = 0L;
        }
        if (this.cji == null) {
            return;
        }
        this.cji.onRoomEventUpdate(104, bigInteger.longValue(), str);
    }

    @Override // com.baidu.rtc.c
    public void b(final BigInteger bigInteger, JSONObject jSONObject) {
        this.ckf.b(bigInteger, new SessionDescription(SessionDescription.Type.fromCanonicalForm(jSONObject.optString("type")), jSONObject.optString("sdp")));
        this.mHandler.post(new Runnable() { // from class: com.baidu.rtc.b.a.4
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.cjv || bigInteger == a.this.cjJ || a.this.ckf == null) {
                    return;
                }
                if (a.this.cjn.get(bigInteger) != null) {
                    a.this.ckf.a(false, 0, bigInteger, PeerConnectionClient.StatsEventsType.GET_QUALITY_MONITOR_EVENT);
                    a.this.cjn.remove(bigInteger);
                }
                a.this.ckf.a(a.this.cjv, 2000, bigInteger, PeerConnectionClient.StatsEventsType.GET_QUALITY_MONITOR_EVENT);
                a.this.cjn.put(bigInteger, new com.baidu.rtc.c.b());
            }
        });
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void b(SessionDescription sessionDescription, BigInteger bigInteger) {
        Log.e("BaiduRtcRoomImp", sessionDescription.type.toString());
        this.ckb.d(bigInteger, sessionDescription);
    }

    public void bb(Context context) {
        Log.d("BaiduRtcRoomImp", "setup so later loading feature, and cpu type: " + this.mCpuType);
        com.baidu.cloudbase.b.a.aa(context).dw(this.mCpuType);
        if (this.cjW.isEmpty()) {
            com.baidu.cloudbase.b.a.aa(context).a(com.baidu.cloudbase.b.b.uI(), true, this.cjT);
            return;
        }
        Log.d("BaiduRtcRoomImp", "setup so later load url: " + this.cjW);
        com.baidu.cloudbase.b.a.aa(context).a(this.cjW, true, this.cjT);
    }

    @Override // com.baidu.rtc.c
    public void c(BaiduRtcRoom.RtcLiveTransferMode rtcLiveTransferMode, String str) {
        if (this.cji == null) {
            return;
        }
        this.cji.onRoomEventUpdate(116, rtcLiveTransferMode.ordinal(), str);
    }

    @Override // com.baidu.rtc.c
    public void c(final BigInteger bigInteger) {
        if (this.cji != null) {
            this.cji.onRoomEventUpdate(100, 0L, "ok");
        }
        this.cjJ = bigInteger;
        if (this.cjH.AutoPublish) {
            l(bigInteger);
        }
        if (this.ckc && this.ckf != null) {
            this.ckf.a(this.ckc, 5000, this.cjJ, PeerConnectionClient.StatsEventsType.GET_BWE_EVENT);
        }
        this.mHandler.post(new Runnable() { // from class: com.baidu.rtc.b.a.3
            @Override // java.lang.Runnable
            public void run() {
                if ((a.this.cjw || a.this.cjv) && a.this.ckf != null) {
                    if (a.this.cjn.get(bigInteger) != null) {
                        a.this.ckf.a(false, 0, bigInteger, PeerConnectionClient.StatsEventsType.GET_QUALITY_MONITOR_EVENT);
                        a.this.cjn.remove(bigInteger);
                    }
                    a.this.ckf.a(a.this.cjw || a.this.cjv, 2000, bigInteger, PeerConnectionClient.StatsEventsType.GET_QUALITY_MONITOR_EVENT);
                    a.this.cjn.put(bigInteger, new com.baidu.rtc.c.b());
                    if (a.this.cki != null && !a.this.ckd) {
                        a.this.ckd = true;
                        a.this.mHandler.post(a.this.ckg);
                    }
                    a aVar = a.this;
                    aVar.jN("RTCROOM_LOGIN_OK_" + a.this.mUserId);
                }
                b bVar = (b) a.this.cjP.get(BigInteger.valueOf(a.this.mUserId));
                if (bVar != null) {
                    if (a.this.ckf != null) {
                        a.this.ckf.a(false, 0, bVar.ces, PeerConnectionClient.StatsEventsType.GET_AUDIOLEVEL_EVENT);
                    }
                    bVar.ckt = Boolean.valueOf(a.this.cjH.HasVideo);
                    bVar.cks = Boolean.valueOf(a.this.cjH.HasAudio);
                    bVar.ces = bigInteger;
                    bVar.nickName = a.this.mDisplayName;
                } else {
                    a.this.cjP.put(BigInteger.valueOf(a.this.mUserId), new b(bigInteger, a.this.mUserId, Boolean.valueOf(a.this.cjH.HasVideo), Boolean.valueOf(a.this.cjH.HasAudio), a.this.mDisplayName));
                }
                if (a.this.ckf != null) {
                    a.this.ckf.a(true, 200, bigInteger, PeerConnectionClient.StatsEventsType.GET_AUDIOLEVEL_EVENT);
                }
            }
        });
    }

    @Override // com.baidu.rtc.c
    public void c(BigInteger bigInteger, String str) {
        if (this.cji == null) {
            return;
        }
        this.cji.onRoomEventUpdate(302, bigInteger.longValue(), str);
    }

    public void c(boolean z, boolean z2, String str) {
        this.cjw = z;
        this.cjv = z2;
        this.cjK = str;
        if (!z && !z2) {
            if (this.cjk != null) {
                this.cjk.pause();
                return;
            }
            return;
        }
        if (this.cjk == null) {
            this.cjk = new com.baidu.rtc.c.a(this.cjU);
        }
        if (this.cki == null) {
            this.cki = d.acy();
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void d(long j, boolean z) {
        if (this.ckb != null) {
            this.ckb.d(j, z);
        }
    }

    @Override // com.baidu.rtc.c
    public void d(BigInteger bigInteger) {
        if (this.cji == null) {
            return;
        }
        this.cji.onRoomEventUpdate(301, bigInteger.longValue(), "");
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void disbandRoom() {
        if (this.ckb != null) {
            this.ckb.disbandRoom();
        }
    }

    public void doDestroy() {
        logoutRtcRoom();
        cja.remove(toString());
    }

    @Override // com.baidu.rtc.c
    public void e(BigInteger bigInteger) {
        if (this.cji == null) {
            return;
        }
        this.cji.onPeerConnectStateUpdate(2000);
        jN("WEBRTC_UP_" + bigInteger.longValue());
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void enableExternalVideoCapturer(boolean z) {
        this.cju = z;
        this.cka = new VideoSink() { // from class: com.baidu.rtc.b.a.13
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
    public void gT(int i) {
        if (this.cji != null && i == 436) {
            this.cji.onErrorInfoUpdate(RTCConst.RTC_ROOM_USERID_ALREADY_EXIST_ERROR);
        }
    }

    @Override // com.baidu.rtc.c
    public void h(boolean z, int i) {
        if (this.cji == null) {
            return;
        }
        this.cji.onPeerConnectStateUpdate(i < 10 ? 2100 : i < 15 ? RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL1 : i < 25 ? RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL2 : i < 40 ? RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL3 : i < 60 ? RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL4 : i < 90 ? RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL5 : i < 120 ? RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL6 : i < 180 ? RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL7 : i < 250 ? RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL8 : RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL9);
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void jH(String str) {
        if (this.cji != null) {
            this.cji.onErrorInfoUpdate(10000);
        }
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void l(ByteBuffer byteBuffer) {
        if (this.cji == null) {
            return;
        }
        this.cji.onRoomDataMessage(byteBuffer);
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public boolean loginRtcRoomWithRoomName(String str, long j, String str2, boolean z) {
        Log.i("BaiduRtcRoomImp", "enable force login");
        this.cjs = z;
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
        this.cjr = z;
        this.cjq = z2;
        if (this.cjx && !this.cjy) {
            this.cjV = new Thread(new Runnable() { // from class: com.baidu.rtc.b.a.16
                @Override // java.lang.Runnable
                public void run() {
                    Log.d("BaiduRtcRoomImp", "setup downloading thread ......");
                    a.this.bb(a.this.cjU);
                }
            });
            this.cjV.start();
            return true;
        } else if (j == 0) {
            throw new InvalidParameterException("loginRtcRoomWithRoomName: Param Error,userId cann't be zero. zero is reserved.");
        } else {
            this.ckb.jK(str);
            this.ckb.setUserId(j);
            if (str2 != null && !str2.isEmpty()) {
                this.ckb.setDisplayName(str2);
            }
            this.ckb.setVideoCodec(this.cjH.VideoCodec);
            this.ckb.dR(z);
            this.ckb.dQ(z2);
            int i5 = this.cjH.VideoWidth;
            int i6 = this.cjH.VideoHeight;
            String lowerCase = this.cjH.VideoResolution.toLowerCase();
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
            this.cfb = new PeerConnectionClient.c(false, i, i6, this.cjH.VideoFps, this.cjH.VideoCodec.toUpperCase(), true, 0, "opus", false, false, false, this.cjd.booleanValue(), this.cje.booleanValue(), this.cjH.VideoMaxkbps, this.cjH.VideoMinkbps, this.cjH.cgn, this.cjH.cgi, true, this.cjH.cgk, this.cjH.cgm, this.cjH.cgl);
            this.ckf = PeerConnectionClient.abl();
            if (this.cjl) {
                if (this.cjh == null) {
                    this.cjh = new com.baidu.cloudbase.a.a();
                }
                this.cjh.aR(false);
                if (this.cjL < 0) {
                    this.cjL = this.cjh.uB();
                }
                this.cjh.uC();
                this.cjh.aQ(false);
                this.cjh.aP(false);
                this.cjh.a(this.cjG);
            }
            if (this.cjR != null || this.cjl) {
                this.ckf.a(this.cjS);
            }
            if (this.cjN != null || this.cjl) {
                this.ckf.a(this.cjO);
            }
            if (this.cjH != null) {
                this.ckb.dM(this.cjH.HasAudio);
                this.ckf.dM(this.cjH.HasAudio);
                this.ckb.dO(this.cjH.HasVideo);
                this.ckf.dO(this.cjH.HasVideo);
                this.ckb.dN(this.cjH.HasData);
                this.ckf.dN(this.cjH.HasData);
                this.ckf.gU(this.cjH.AudioFrequency);
                this.ckf.setAudioChannel(this.cjH.AudioChannel);
                this.ckb.gV(this.cjH.ConnectionTimeoutMs);
                this.ckb.gW(this.cjH.ReadTimeoutMs);
                this.ckb.dS(this.cjH.AutoPublish);
                this.ckb.dT(this.cjH.AutoSubScribe);
            }
            this.ckf.dL(this.cjt);
            this.ckf.dK(ceX);
            this.ckf.a(this.mContext.get(), this.cfb, this);
            this.ckb.K(this.cjz, this.cjs);
            Log.i("BRTC", "loginRtcRoomWithRoomName: this " + this + " version: " + version());
            return true;
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public boolean logoutRtcRoom() {
        if (this.ckf != null) {
            this.ckf.dJ(false);
            this.ckf.dP(false);
            this.ckf.abn();
            this.ckb.BP();
            this.ckb.finalize();
            this.ckf.close();
            if (this.cjk != null) {
                this.cjk.pause();
            }
            this.cjn.clear();
            this.ckf = null;
            this.ckb = null;
            if (this.cjh != null) {
                this.cjh.a(null);
                this.cjh.release();
            }
            if (this.cjE != null) {
                this.cjE.release();
                this.cjE = null;
            }
            if (this.cjM != null) {
                for (int i = 0; i < this.cjM.length; i++) {
                    if (this.cjM[i] != null) {
                        this.cjM[i].release();
                        this.cjM[i] = null;
                    }
                }
            }
            acg();
            ach();
            if (this.ckh != null) {
                this.ckh.release();
            }
            if (this.audioManager != null && this.audioManager.isBluetoothScoOn()) {
                c((Boolean) false);
            }
            if (this.cjp != null) {
                this.mContext.get().unregisterReceiver(this.cjp);
                this.cjp = null;
            }
            System.gc();
        }
        return true;
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void muteMicphone(boolean z) {
        if (this.ckf != null) {
            this.ckf.dJ(!z);
        }
        jN("MUTE_MICPHONE");
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void onIceCandidatesRemoved(IceCandidate[] iceCandidateArr) {
    }

    public void presetLoudSpeaker(boolean z) {
        ((AudioManager) this.mContext.get().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND)).setSpeakerphoneOn(z);
        jN("PRESETLOUDSPEAKER");
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void sendMessageToUser(String str, long j) {
        if (this.ckb == null) {
            return;
        }
        this.ckb.sendMessageToUser(str, j);
        try {
            Thread.sleep(10L);
        } catch (InterruptedException e) {
        }
    }
}
