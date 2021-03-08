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
import com.baidu.rtc.b.e;
import com.baidu.rtc.g;
import com.baidu.rtc.i;
import com.baidu.rtc.j;
import com.baidu.rtc.k;
import com.baidu.rtc.p;
import com.heytap.mcssdk.mode.CommandMessage;
import com.kwai.video.player.KsMediaMeta;
import com.yy.videoplayer.decoder.VideoConstant;
import java.io.File;
import java.lang.ref.WeakReference;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;
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
public class a extends BaiduRtcRoom implements PeerConnectionClient.b, com.baidu.rtc.c {
    public static boolean cvr = false;
    static int cyk = -1;
    public static int cyl = 30;
    private static ConcurrentHashMap<String, String> cym = new ConcurrentHashMap<>();
    public static int cyn = 1;
    b cyC;
    private boolean cyK;
    BaiduRtcRoom.RtcLiveTransferMode cyR;
    private long cyU;
    private int cyo;
    private Boolean cys;
    private com.baidu.cloudbase.a.a cyu;
    com.baidu.rtc.b.a cyx;
    private Context czk;
    private long czn;
    private VideoSink czr;
    private p czs;
    private EglBase czy;
    com.baidu.rtc.b.d czz;
    String mAppId;
    private WeakReference<Context> mContext;
    private String mCpuType;
    String mDisplayName;
    String mRoomName;
    long mUserId;
    private boolean cyH = false;
    private boolean cyG = false;
    private boolean cyy = false;
    private volatile PeerConnectionClient czw = null;
    private PeerConnectionClient.c cvv = null;
    private RTCVideoView cyT = null;
    private RTCVideoView[] czc = null;
    private VideoCapturer cvF = null;
    private String cyO = "wss://rtc.exp.bcelive.com/janus";
    private int czg = 0;
    private boolean czp = true;
    private boolean[] cyB = new boolean[cyl];
    private AudioManager audioManager = null;
    private int czb = -1;
    BaiduRtcRoom.a cyv = null;
    g.d czh = null;
    g.c czd = null;
    g.b cyV = null;
    private ConcurrentHashMap<Long, j> czo = new ConcurrentHashMap<>();
    private IdentityHashMap<Long, j> cyY = new IdentityHashMap<>();
    private boolean czq = false;
    int cyw = cyk;
    private RtcParameterSettings cyX = new RtcParameterSettings();
    private Handler mHandler = new Handler(Looper.getMainLooper());
    BigInteger cyZ = null;
    volatile long cyQ = 0;
    volatile long cyP = 0;
    ConcurrentHashMap<BigInteger, BigInteger> cyz = new ConcurrentHashMap<>();
    boolean czt = true;
    double czv = 200.0d;
    boolean cyJ = false;
    boolean cyI = false;
    String cza = "online";
    private ConcurrentHashMap<BigInteger, com.baidu.rtc.b.b> cyA = new ConcurrentHashMap<>();
    boolean czu = false;
    boolean cyD = true;
    boolean cyE = true;
    boolean cyF = false;
    boolean cyN = false;
    Boolean cyp = false;
    Boolean cyq = false;
    String cyS = "";
    private boolean cyt = false;
    private boolean cyL = false;
    private ConcurrentHashMap<BigInteger, c> czf = new ConcurrentHashMap<>();
    private Thread czl = null;
    private boolean cyM = false;
    private String czm = "";
    private com.baidu.cloudbase.b.c czj = new c.a() { // from class: com.baidu.rtc.a.a.1
        @Override // com.baidu.cloudbase.b.c
        public void R(String str, String str2) {
            Log.d("BaiduRtcRoomImp", "Be successful to download so!");
            String str3 = com.baidu.cloudbase.b.b.Y(a.this.czk) + File.separator + "libjingle_peerconnection_so.so";
            Log.d("BaiduRtcRoomImp", "RTC so path is: " + str3);
            a.this.cyM = true;
            if (com.baidu.cloudbase.b.a.Z(a.this.czk).ds(com.baidu.cloudbase.b.b.Y(a.this.czk))) {
                try {
                    System.load(str3);
                    Log.d("BaiduRtcRoomImp", "loaded so, and start to login room.");
                    a.this.loginRtcRoomWithRoomName(a.this.mRoomName, a.this.mUserId, a.this.mDisplayName, a.this.cyE, a.this.cyD);
                    return;
                } catch (Throwable th) {
                    Log.d("BaiduRtcRoomImp", "Failed call System.load to load so! Error: " + th);
                    if (a.this.cyv != null) {
                        a.this.cyv.onErrorInfoUpdate(401);
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
                a.this.loginRtcRoomWithRoomName(a.this.mRoomName, a.this.mUserId, a.this.mDisplayName, a.this.cyE, a.this.cyD);
            } catch (Throwable th2) {
                Log.d("BaiduRtcRoomImp", "Failed to load so with full path! Error: " + th2);
                if (a.this.cyv != null) {
                    a.this.cyv.onErrorInfoUpdate(401);
                }
            }
        }

        @Override // com.baidu.cloudbase.b.c
        public void b(String str, int i, String str2) {
            Log.d("BaiduRtcRoomImp", "Failed to download so.");
            if (a.this.cyv != null) {
                a.this.cyv.onErrorInfoUpdate(400);
            }
        }
    };
    JavaAudioDeviceModule.SamplesReadyCallback czi = new JavaAudioDeviceModule.SamplesReadyCallback() { // from class: com.baidu.rtc.a.a.16
        @Override // org.webrtc.audio.JavaAudioDeviceModule.SamplesReadyCallback
        public void onWebRtcAudioRecordSamplesReady(JavaAudioDeviceModule.AudioSamples audioSamples) {
            if (audioSamples == null || audioSamples.getData() == null || audioSamples.getData().length <= 0) {
                return;
            }
            if (a.this.czh != null) {
                a.this.czh.a(new g(audioSamples.getAudioFormat(), audioSamples.getChannelCount(), audioSamples.getSampleRate(), audioSamples.getData()));
            }
            if (!a.this.cyy || a.this.cyG) {
                return;
            }
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            bufferInfo.size = audioSamples.getData().length;
            bufferInfo.offset = 0;
            ByteBuffer wrap = ByteBuffer.wrap(audioSamples.getData());
            bufferInfo.presentationTimeUs = System.nanoTime();
            a.this.cyu.a(wrap, bufferInfo);
        }
    };
    JavaAudioDeviceModule.RemoteSamplesReadyCallback cze = new JavaAudioDeviceModule.RemoteSamplesReadyCallback() { // from class: com.baidu.rtc.a.a.17
        @Override // org.webrtc.audio.JavaAudioDeviceModule.RemoteSamplesReadyCallback
        public void onWebRtcAudioRemoteSamplesReady(JavaAudioDeviceModule.AudioSamples audioSamples) {
            if (audioSamples == null) {
                return;
            }
            if (a.this.czd != null) {
                a.this.czd.c(new g(audioSamples.getAudioFormat(), audioSamples.getChannelCount(), audioSamples.getSampleRate(), audioSamples.getData()));
            }
            if (!a.this.cyy || a.this.czb < 0) {
                return;
            }
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            bufferInfo.size = audioSamples.getData().length;
            bufferInfo.offset = 0;
            a.this.cyu.a(ByteBuffer.wrap(audioSamples.getData()), bufferInfo, a.this.czb);
        }
    };
    g.a cyr = new g.a() { // from class: com.baidu.rtc.a.a.18
    };
    private com.baidu.cloudbase.c.a cyW = new com.baidu.cloudbase.c.a() { // from class: com.baidu.rtc.a.a.19
        @Override // com.baidu.cloudbase.c.a
        public void onFilteredFrameUpdate(byte[] bArr, MediaCodec.BufferInfo bufferInfo) {
            if (a.this.cyV != null) {
                a.this.cyV.b(new g(2, a.this.cyX.AudioChannel, a.this.cyX.AudioFrequency, bArr, bufferInfo.presentationTimeUs));
            }
        }
    };
    private Runnable czx = new Runnable() { // from class: com.baidu.rtc.a.a.13
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.czz != null && (a.this.cyJ || a.this.cyI)) {
                a.this.afb();
            }
            a.this.mHandler.postDelayed(a.this.czx, 300000L);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.rtc.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C0319a implements e {
        private C0319a() {
        }

        @Override // com.baidu.rtc.b.e
        public void m(long j, long j2) {
            if (a.this.cyI) {
                for (Map.Entry entry : a.this.cyA.entrySet()) {
                    if (entry.getKey() != a.this.cyZ && entry.getValue() != null) {
                        ((com.baidu.rtc.b.b) entry.getValue()).n(j, j2);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class b extends BroadcastReceiver {
        b() {
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
                        final int u = a.u(a.this);
                        a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.rtc.a.a.b.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (u == a.this.cyo) {
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
                a.v(a.this);
                if (a.this.audioManager.isWiredHeadsetOn()) {
                    return;
                }
                a.this.a(BaiduRtcRoom.RtcSoundMode.RTC_SOUND_MODE_SPEAKER);
            } else if (!intent.getAction().equals("android.intent.action.HEADSET_PLUG") || !intent.hasExtra("state")) {
                if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(action) && intent.getIntExtra("android.bluetooth.adapter.extra.STATE", Integer.MIN_VALUE) == 10) {
                    a.v(a.this);
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
    public static class c {
        public BigInteger cuJ;
        public Boolean czL;
        public Boolean czM;
        public String nickName;
        public long userId;
        public int volume = -1;

        public c(BigInteger bigInteger, long j, Boolean bool, Boolean bool2, String str) {
            this.nickName = "";
            this.cuJ = bigInteger;
            this.userId = j;
            this.czL = bool2;
            this.czM = bool;
            this.nickName = str;
        }
    }

    /* loaded from: classes9.dex */
    private class d implements e {
        private BigInteger cuJ;

        d(BigInteger bigInteger) {
            this.cuJ = bigInteger;
        }

        @Override // com.baidu.rtc.b.e
        public void m(long j, long j2) {
            com.baidu.rtc.b.b bVar;
            if (!a.this.cyI || (bVar = (com.baidu.rtc.b.b) a.this.cyA.get(this.cuJ)) == null) {
                return;
            }
            bVar.o(j, j2);
        }
    }

    public a(Context context, String str, String str2, String str3, boolean z) {
        this.mContext = null;
        this.czs = null;
        this.czy = null;
        this.cyC = null;
        this.cyK = false;
        this.mCpuType = "armeabi-v7a";
        this.czk = null;
        this.cyK = z;
        this.czk = context;
        this.mContext = new WeakReference<>(context);
        this.mCpuType = str3;
        this.czs = new p();
        this.czs.setAppId(str);
        this.czs.jJ(str2);
        this.czs.jI("BRTC.Android.SDK V" + version());
        this.mAppId = str;
        this.czs.a(this);
        this.czy = EglBase_CC.create();
        for (int i = 0; i < this.cyB.length; i++) {
            this.cyB[i] = false;
        }
        AudioManager audioManager = (AudioManager) this.mContext.get().getSystemService("audio");
        audioManager.setSpeakerphoneOn(false);
        if (this.cyJ || this.cyI) {
            this.cyx = new com.baidu.rtc.b.a(context);
            this.czz = com.baidu.rtc.b.d.afv();
        }
        this.cyo = 0;
        this.cys = false;
        audioManager = audioManager == null ? (AudioManager) this.mContext.get().getSystemService("audio") : audioManager;
        this.cyC = new b();
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
        this.mContext.get().registerReceiver(this.cyC, intentFilter);
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
        if (this.cyw == cyk || this.cyw >= deviceNames.length || (createCapturer3 = cameraEnumerator.createCapturer(deviceNames[this.cyw], null)) == null) {
            Log.d("BaiduRtcRoomImp", "Looking for front facing cameras.");
            for (String str : deviceNames) {
                if (cameraEnumerator.isFrontFacing(str)) {
                    Log.d("BaiduRtcRoomImp", "Creating front facing camera capturer.");
                    if (!cym.containsValue(str) && (createCapturer2 = cameraEnumerator.createCapturer(str, null)) != null) {
                        cym.put(toString(), str);
                        this.czq = true;
                        if (this.cyT != null) {
                            this.cyT.setMirror(true);
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
                    if (!cym.containsValue(str2) && (createCapturer = cameraEnumerator.createCapturer(str2, null)) != null) {
                        cym.put(toString(), str2);
                        this.czq = false;
                        return createCapturer;
                    }
                }
            }
            return null;
        }
        return createCapturer3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.rtc.a aVar, BigInteger bigInteger) {
        com.baidu.rtc.b.b bVar;
        if (!this.cyI || (bVar = this.cyA.get(aVar.cuJ)) == null) {
            return;
        }
        bVar.bU(System.currentTimeMillis());
        l(bigInteger.longValue(), bVar.afq() - bVar.afs());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(StatsReport[] statsReportArr, BigInteger bigInteger) {
        BigInteger k;
        StatsReport.Value[] valueArr;
        StatsReport.Value[] valueArr2;
        if (this.czs == null) {
            return;
        }
        if (bigInteger == this.cyZ) {
            k = BigInteger.valueOf(this.mUserId);
        } else {
            k = this.czs.k(bigInteger);
            if (k == null) {
                return;
            }
        }
        c cVar = this.czf.get(k);
        if (cVar == null) {
            if (this.czw != null) {
                this.czw.a(false, 0, bigInteger, PeerConnectionClient.StatsEventsType.GET_AUDIOLEVEL_EVENT);
                return;
            }
            return;
        }
        for (StatsReport statsReport : statsReportArr) {
            if (bigInteger == this.cyZ) {
                if (statsReport.type.equals("ssrc") && statsReport.id.contains("ssrc") && statsReport.id.contains(UbcStatConstant.ContentType.UBC_TYPE_IM_SEND)) {
                    for (StatsReport.Value value : statsReport.values) {
                        if (value.name.contains("audioInputLevel")) {
                            try {
                                cVar.volume = Integer.valueOf(value.value).intValue();
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
                            cVar.volume = Integer.valueOf(value2.value).intValue();
                        } catch (NumberFormatException e2) {
                            Log.e("BaiduRtcRoomImp", "parse string num exception: " + e2);
                        }
                    }
                }
            }
        }
    }

    private boolean aeW() {
        return !Build.MODEL.contains("SABRESD-MX6DQ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public VideoCapturer aeX() {
        VideoCapturer a2;
        if (this.cvF != null) {
            return this.cvF;
        }
        if (afd()) {
            Log.d("BaiduRtcRoomImp", "Creating capturer using camera2 API.");
            a2 = a(new Camera2Enumerator(this.mContext.get()));
        } else {
            Log.d("BaiduRtcRoomImp", "Creating capturer using camera1 API.");
            a2 = a(new Camera1Enumerator(aeW()));
        }
        if (a2 == null) {
            Log.e("BaiduRtcRoomImp", "Failed to open camera");
            return null;
        }
        return a2;
    }

    private void aeY() {
        if (this.czo.isEmpty()) {
            return;
        }
        for (Long l : this.czo.keySet()) {
            j jVar = this.czo.get(l);
            if (jVar != null) {
                if (jVar.getSurface() != null) {
                    jVar.releaseSurface();
                }
                jVar.release();
            }
            this.czo.remove(l);
        }
    }

    private void aeZ() {
        synchronized (this) {
            if (this.cyY.isEmpty()) {
                return;
            }
            for (j jVar : this.cyY.values()) {
                if (jVar != null) {
                    if (jVar.getSurface() != null) {
                        jVar.releaseSurface();
                    }
                    jVar.release();
                }
            }
            this.cyY.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afa() {
        com.baidu.rtc.b.b bVar;
        if (this.czs == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        boolean z = true;
        com.baidu.rtc.b.b bVar2 = this.cyA.get(this.cyZ);
        if (bVar2 == null) {
            z = false;
        } else {
            bVar2.x(hashMap);
        }
        boolean z2 = hashMap.size() != 0 ? z : false;
        o(hashMap);
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("duration", 2);
            JSONObject jSONObject3 = new JSONObject();
            if (this.cyx != null) {
                jSONObject3.put("sysCpuUsage", this.cyx.afl());
            }
            jSONObject3.put("appCpuUsage", 0);
            jSONObject2.put("resourceUsageInfo", jSONObject3);
            if (this.cyJ) {
                JSONObject jSONObject4 = new JSONObject();
                if (z2) {
                    jSONObject4.put(KsMediaMeta.KSM_KEY_BITRATE, hashMap.get("bitrate_s"));
                    jSONObject4.put("packetloss", hashMap.get("packetloss_s"));
                    jSONObject4.put("cfps", hashMap.get("fps_s"));
                    jSONObject4.put(AlaRecorderLog.KEY_CANERA_START_FPS, hashMap.get("fps_i"));
                    if (bVar2 == null) {
                        jSONObject4.put("resolution", "");
                    } else {
                        jSONObject4.put("resolution", bVar2.aft());
                    }
                } else {
                    jSONObject4.put(KsMediaMeta.KSM_KEY_BITRATE, 0);
                    jSONObject4.put("packetloss", 0);
                    jSONObject4.put(AlaRecorderLog.KEY_CANERA_START_FPS, 0);
                    jSONObject4.put("resolution", "");
                }
                jSONObject2.put("senderQualityInfo", jSONObject4);
            }
            if (this.cyI) {
                JSONArray jSONArray = new JSONArray();
                for (BigInteger bigInteger : this.cyA.keySet()) {
                    if (bigInteger != this.cyZ && (bVar = this.cyA.get(bigInteger)) != null) {
                        HashMap hashMap2 = new HashMap();
                        bVar.w(hashMap2);
                        if (hashMap2.size() != 0) {
                            JSONObject jSONObject5 = new JSONObject();
                            if (this.czs != null) {
                                jSONObject5.put("feedId", this.czs.k(bigInteger));
                            }
                            jSONObject5.put(KsMediaMeta.KSM_KEY_BITRATE, hashMap2.get("bitrate_r"));
                            jSONObject5.put("packetloss", hashMap2.get("packetloss_r"));
                            jSONObject5.put(AlaRecorderLog.KEY_CANERA_START_FPS, hashMap2.get("fps_r"));
                            jSONObject5.put("resolution", bVar.afr());
                            jSONArray.put(jSONObject5);
                        }
                    }
                }
                jSONObject2.put("receiverQualityInfoList", jSONArray);
            }
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put("communicationQualityInfo", jSONObject2);
            jSONObject.put("env", this.cza);
            jSONObject.put("appId", this.mAppId);
            if (this.czs != null) {
                jSONObject.put("roomId", this.czs.getRoomId());
            }
            jSONObject.put("timestamp", System.currentTimeMillis());
            jSONObject.put(TbEnum.SystemMessage.KEY_USER_ID, this.mUserId);
            jSONObject.put("message", jSONObject6);
        } catch (JSONException e) {
            Log.e("BaiduRtcRoomImp", "Caught error on reportCommunicationQualityInfo: " + e);
        }
        this.czz.O(jSONObject.toString(), 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afb() {
        if (this.czs == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(CommandMessage.SDK_VERSION, "BRTC.Android.SDK V" + version());
            jSONObject2.put("networkType", com.baidu.rtc.b.d.getNetworkType(this.mContext.get()));
            jSONObject2.put(Config.DEVICE_PART, com.baidu.rtc.b.d.getDeviceModel());
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("deviceInfo", jSONObject2);
            jSONObject.put("env", this.cza);
            jSONObject.put("appId", this.mAppId);
            if (this.czs != null) {
                jSONObject.put("roomId", this.czs.getRoomId());
            }
            jSONObject.put("timestamp", System.currentTimeMillis());
            jSONObject.put(TbEnum.SystemMessage.KEY_USER_ID, this.mUserId);
            jSONObject.put("message", jSONObject3);
        } catch (JSONException e) {
            Log.e("BaiduRtcRoomImp", "Caught error on reportDeviceInfo: " + e);
        }
        this.czz.O(jSONObject.toString(), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afc() {
        com.baidu.rtc.b.b bVar;
        if (this.czs != null && this.cyI) {
            new JSONArray();
            for (BigInteger bigInteger : this.cyA.keySet()) {
                if (bigInteger != this.cyZ && (bVar = this.cyA.get(bigInteger)) != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("feedId", this.czs.k(bigInteger));
                        JSONArray jSONArray = new JSONArray();
                        JSONArray jSONArray2 = new JSONArray();
                        HashMap hashMap = new HashMap();
                        bVar.v(hashMap);
                        ArrayList<Long> arrayList = hashMap.get("aStuck");
                        if (arrayList.size() == 0) {
                            jSONArray.put(0);
                        } else {
                            for (int i = 0; i < arrayList.size(); i++) {
                                jSONArray.put(arrayList.get(i));
                            }
                        }
                        ArrayList<Long> arrayList2 = hashMap.get("vStuck");
                        if (arrayList2.size() == 0) {
                            jSONArray2.put(0);
                        } else {
                            for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                                jSONArray2.put(arrayList2.get(i2));
                            }
                        }
                        JSONObject jSONObject4 = new JSONObject();
                        jSONObject4.put("durations", jSONArray);
                        JSONObject jSONObject5 = new JSONObject();
                        jSONObject5.put("durations", jSONArray2);
                        jSONObject3.put("astuck", jSONObject4);
                        jSONObject3.put("vstuck", jSONObject5);
                        bVar.afo();
                        JSONObject jSONObject6 = new JSONObject();
                        if (bVar.afp() > 0) {
                            jSONObject6.put("duration", bVar.afp());
                            jSONObject3.put("e2eDelay", jSONObject6);
                        }
                        jSONObject2.put("sli", jSONObject3);
                        jSONObject.put("env", this.cza);
                        jSONObject.put("appId", this.mAppId);
                        if (this.czs != null) {
                            jSONObject.put("roomId", this.czs.getRoomId());
                        }
                        jSONObject.put("timestamp", System.currentTimeMillis());
                        jSONObject.put(TbEnum.SystemMessage.KEY_USER_ID, this.mUserId);
                        jSONObject.put("message", jSONObject2);
                    } catch (JSONException e) {
                        Log.e("BaiduRtcRoomImp", "Caught error on reportDeviceInfo: " + e);
                    }
                    this.czz.O(jSONObject.toString(), 3);
                }
            }
        }
    }

    private boolean afd() {
        Camera2Enumerator.disableExtraCamera(this.cyX.cwW);
        return Camera2Enumerator.isSupported(this.mContext.get());
    }

    private void bS(long j) {
        synchronized (this) {
            if (this.czo.containsKey(Long.valueOf(j))) {
                this.cyY.put(Long.valueOf(j), this.czo.get(Long.valueOf(j)));
                this.czo.remove(Long.valueOf(j));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int d(Boolean bool) {
        if (this.cys == bool) {
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
            this.cys = bool;
            return 0;
        } catch (Exception e) {
            Log.e("BaiduRtcRoomImp", "set bluetooth sco fail: " + e.getMessage());
            return -1;
        }
    }

    public static void ep(boolean z) {
        cvr = z;
    }

    private void h(String str, long j) {
        if (this.czs == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            new JSONObject();
            jSONObject2.put("feedId", 0);
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("type", str);
            jSONObject2.put("loginEvent", jSONObject4);
            jSONObject3.put("sli", jSONObject2);
            jSONObject.put("env", this.cza);
            jSONObject.put("appId", this.mAppId);
            if (j > 0) {
                jSONObject.put("roomId", j);
            }
            jSONObject.put("timestamp", System.currentTimeMillis());
            jSONObject.put(TbEnum.SystemMessage.KEY_USER_ID, this.mUserId);
            jSONObject.put("message", jSONObject3);
        } catch (JSONException e) {
            Log.e("BaiduRtcRoomImp", "Caught error on reportDeviceInfo: " + e);
        }
        this.czz.O(jSONObject.toString(), 3);
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
    public void jK(String str) {
        if ((this.cyJ || this.cyI) && this.czs != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(TbEnum.SystemMessage.KEY_USER_NAME, this.mDisplayName);
                jSONObject2.put("eventDescription", str);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("roomEvent", jSONObject2);
                jSONObject.put("env", this.cza);
                jSONObject.put("appId", this.mAppId);
                if (this.czs != null) {
                    jSONObject.put("roomId", this.czs.getRoomId());
                }
                jSONObject.put("timestamp", System.currentTimeMillis());
                jSONObject.put(TbEnum.SystemMessage.KEY_USER_ID, this.mUserId);
                jSONObject.put("message", jSONObject3);
            } catch (JSONException e) {
                Log.e("BaiduRtcRoomImp", "Caught error on reportRoomEventInfo: " + e);
            }
            this.czz.O(jSONObject.toString(), 1);
        }
    }

    private void jL(String str) {
        h(str, this.czs != null ? this.czs.getRoomId() : -1L);
    }

    private void l(long j, long j2) {
        if (this.czs == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            JSONObject jSONObject4 = new JSONObject();
            jSONObject2.put("feedId", j);
            jSONObject4.put("duration", j2);
            jSONObject2.put("ffDelay", jSONObject4);
            jSONObject3.put("sli", jSONObject2);
            jSONObject.put("env", this.cza);
            jSONObject.put("appId", this.mAppId);
            if (this.czs != null) {
                jSONObject.put("roomId", this.czs.getRoomId());
            }
            jSONObject.put("timestamp", System.currentTimeMillis());
            jSONObject.put(TbEnum.SystemMessage.KEY_USER_ID, this.mUserId);
            jSONObject.put("message", jSONObject3);
        } catch (JSONException e) {
            Log.e("BaiduRtcRoomImp", "Caught error on reportDeviceInfo: " + e);
        }
        this.czz.O(jSONObject.toString(), 3);
    }

    private void o(Map<String, Integer> map) {
        long intValue = map.get("packetloss_s") != null ? map.get("packetloss_s").intValue() : 0L;
        long intValue2 = map.get("packetlost") != null ? map.get("packetlost").intValue() : 0L;
        long intValue3 = map.get("packesend") != null ? map.get("packesend").intValue() : 0L;
        if (this.cyv != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("packetsLost", intValue2);
                jSONObject.put("packetsSent", intValue3);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.cyv.onRoomEventUpdate(201, intValue, jSONObject.toString());
        }
    }

    private void p(final BigInteger bigInteger) {
        if (this.cyN) {
            return;
        }
        this.cyN = true;
        this.mHandler.post(new Runnable() { // from class: com.baidu.rtc.a.a.11
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.cyX.HasVideo) {
                    a.this.cvF = a.this.aeX();
                }
                if (a.this.czw == null) {
                    Log.e("BaiduRtcRoomImp", "peerConnectionClient is null!");
                    return;
                }
                if (a.this.cyH) {
                    a.this.czw.a(a.this.czy.getEglBaseContext(), a.this.czr, a.this.cvF, bigInteger);
                } else {
                    a.this.czw.a(a.this.czy.getEglBaseContext(), a.this.cyT, a.this.cvF, bigInteger);
                }
                a.this.czn = System.currentTimeMillis();
                a.this.czw.i(bigInteger);
            }
        });
    }

    static /* synthetic */ int u(a aVar) {
        int i = aVar.cyo + 1;
        aVar.cyo = i;
        return i;
    }

    static /* synthetic */ int v(a aVar) {
        int i = aVar.cyo;
        aVar.cyo = i + 1;
        return i;
    }

    public static String version() {
        return "1.2.15";
    }

    @Override // com.baidu.rtc.c
    public void a(BaiduRtcRoom.RtcLiveTransferMode rtcLiveTransferMode, String str) {
        if (this.cyv == null) {
            return;
        }
        this.cyv.onRoomEventUpdate(117, rtcLiveTransferMode.ordinal(), str);
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
                    this.cyX = rtcParameterSettings;
                    cyn = this.cyX.AudioContentType;
                    return;
                }
                return;
            case RTC_VIDEO_PARAM_SETTINGS_BITRATE:
                this.cyX.VideoMaxkbps = rtcParameterSettings.VideoMaxkbps;
                if (this.czw == null || this.mHandler == null) {
                    return;
                }
                this.mHandler.post(new Runnable() { // from class: com.baidu.rtc.a.a.10
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.czw == null || a.this.cyX.VideoMaxkbps <= 0) {
                            return;
                        }
                        Log.d("BaiduRtcRoomImp", "Set video maximum bitrate: " + a.this.cyX.VideoMaxkbps);
                        a.this.czw.d(Integer.valueOf(a.this.cyX.VideoMaxkbps));
                    }
                });
                return;
            case RTC_VIDEO_PARAM_SETTINGS_RENDER_MODE:
                this.cyX.cxg = rtcParameterSettings.cxg;
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void a(g.d dVar) {
        this.czh = dVar;
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void a(i iVar) {
        this.cvF = iVar;
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void a(final Boolean bool, final Boolean bool2, final BigInteger bigInteger) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.rtc.a.a.7
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.czs == null) {
                    return;
                }
                BigInteger k = a.this.czs.k(bigInteger);
                String m = a.this.czs.m(k);
                c cVar = (c) a.this.czf.get(k);
                if (cVar == null) {
                    cVar = new c(bigInteger, k.longValue(), bool, bool2, m);
                    a.this.czf.put(k, cVar);
                } else {
                    cVar.czM = bool;
                    cVar.czL = bool2;
                    cVar.cuJ = bigInteger;
                    cVar.nickName = m;
                }
                if (!bool2.booleanValue() || a.this.czw == null) {
                    return;
                }
                a.this.czw.a(true, 200, cVar.cuJ, PeerConnectionClient.StatsEventsType.GET_AUDIOLEVEL_EVENT);
            }
        });
    }

    @Override // com.baidu.rtc.c
    public void a(BigInteger bigInteger, int i, boolean z) {
        if (this.cyv == null) {
            return;
        }
        this.cyv.onPeerConnectStateUpdate(z ? 2001 : 2002);
    }

    @Override // com.baidu.rtc.c
    public void a(BigInteger bigInteger, long j) {
        this.cyL = false;
        if (this.cyJ) {
            h("ENTER_BEGIN", j);
        }
    }

    @Override // com.baidu.rtc.c
    public void a(BigInteger bigInteger, String str) {
        if (this.cyv == null) {
            return;
        }
        this.cyv.onRoomEventUpdate(303, bigInteger.longValue(), str);
    }

    @Override // com.baidu.rtc.c
    public void a(BigInteger bigInteger, String str, String str2) {
        if (this.cyv == null) {
            return;
        }
        this.cyv.onRoomEventUpdate(300, bigInteger.longValue(), str);
    }

    @Override // com.baidu.rtc.c
    public void a(BigInteger bigInteger, final BigInteger bigInteger2) {
        int i;
        Log.i("BaiduRtcRoomImp", "==================onLeaving=======================");
        final com.baidu.rtc.b l = this.czs.l(bigInteger2);
        this.mHandler.post(new Runnable() { // from class: com.baidu.rtc.a.a.4
            @Override // java.lang.Runnable
            public void run() {
                a.this.czf.remove(bigInteger2);
                if (l != null) {
                    BigInteger bigInteger3 = l.cuJ;
                    if (a.this.cyA.get(bigInteger3) != null) {
                        a.this.cyA.remove(bigInteger3);
                        if (a.this.czw != null) {
                            a.this.czw.a(false, 0, bigInteger3, PeerConnectionClient.StatsEventsType.GET_QUALITY_MONITOR_EVENT);
                            a.this.czw.a(false, 0, bigInteger3, PeerConnectionClient.StatsEventsType.GET_SLI_EVENT);
                        }
                    }
                }
            }
        });
        com.baidu.rtc.a j = this.czw.j(bigInteger);
        if (this.cyX.cxg == RtcParameterSettings.RtcVideoRenderMode.RTC_VIDEO_RENDER_MODE_EXTERNAL) {
            j jVar = this.czo.get(Long.valueOf(bigInteger2.longValue()));
            if (jVar == null || j == null) {
                Log.d("BaiduRtcRoomImp", "No external render has found!");
            } else {
                Log.d("BaiduRtcRoomImp", "remove external video sink of user " + bigInteger2);
                jVar.aeR();
                jVar.clearImage();
                if (j.cuN != null) {
                    j.cuN.removeSink(jVar);
                }
                bS(bigInteger2.longValue());
                if (this.cyv != null) {
                    if (this.cyP == bigInteger2.longValue()) {
                        return;
                    }
                    this.cyv.onRoomEventUpdate(107, bigInteger2.longValue(), "gone");
                    this.cyP = bigInteger2.longValue();
                    return;
                }
            }
        }
        if (j != null && (i = j.cuO) >= 0 && i < this.cyB.length) {
            this.cyB[i] = false;
            this.czg--;
            if (this.czc[i] != null) {
                this.czc[i].clearImage();
                if (j.cuN != null) {
                    j.cuN.removeSink(this.czc[i]);
                }
                if (this.cyv != null) {
                    if (this.cyP != bigInteger2.longValue()) {
                        this.cyv.onRoomEventUpdate(107, bigInteger2.longValue(), "gone");
                        this.cyP = bigInteger2.longValue();
                        return;
                    }
                    return;
                }
            }
        }
        if (this.cyv != null) {
            if (this.cyQ == bigInteger2.longValue()) {
                return;
            }
            this.cyz.remove(bigInteger2);
            this.cyv.onRoomEventUpdate(105, bigInteger2.longValue(), "leaving");
        }
        this.cyQ = bigInteger2.longValue();
        jK("REMOTE_LEAVING_" + bigInteger2 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + bigInteger);
    }

    @Override // com.baidu.rtc.c
    public void a(BigInteger bigInteger, JSONObject jSONObject) {
        SessionDescription.Type fromCanonicalForm = SessionDescription.Type.fromCanonicalForm(jSONObject.optString("type"));
        String optString = jSONObject.optString("sdp");
        if (this.cyX.cwY && this.cyt && optString.contains("profile-level-id=42e01f")) {
            optString = optString.replace("profile-level-id=42e01f", "profile-level-id=640c1f");
            Log.e("BaiduRtcRoomImp", "enable high profile, remote jsep changed: " + optString);
        }
        this.czw.a(bigInteger, new SessionDescription(fromCanonicalForm, optString));
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void a(IceCandidate iceCandidate, BigInteger bigInteger) {
        Log.e("BaiduRtcRoomImp", "=========onIceCandidate========");
        if (iceCandidate != null) {
            this.czs.a(bigInteger, iceCandidate);
        } else {
            this.czs.n(bigInteger);
        }
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void a(SessionDescription sessionDescription, BigInteger bigInteger) {
        Log.e("BaiduRtcRoomImp", sessionDescription.type.toString());
        this.czs.d(bigInteger, sessionDescription);
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void a(SessionDescription sessionDescription, BigInteger bigInteger, boolean z) {
        Log.e("BaiduRtcRoomImp", sessionDescription.type.toString());
        if (this.czs == null) {
            return;
        }
        this.cyt = z;
        this.czs.c(bigInteger, sessionDescription);
        this.mHandler.post(new Runnable() { // from class: com.baidu.rtc.a.a.5
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.czw == null || a.this.cvv.cww <= 0) {
                    return;
                }
                Log.d("BaiduRtcRoomImp", "Set video maximum bitrate: " + a.this.cvv.cww);
                a.this.czw.d(Integer.valueOf(a.this.cvv.cww));
            }
        });
    }

    public void a(StatsReport[] statsReportArr) {
        StatsReport.Value[] valueArr;
        if (this.cyv == null) {
            return;
        }
        for (StatsReport statsReport : statsReportArr) {
            if (statsReport.id.equals("bweforvideo")) {
                for (StatsReport.Value value : statsReport.values) {
                    if (value.name.equals("googAvailableSendBandwidth")) {
                        this.czv = Double.parseDouble(value.value);
                        if (this.czv > 100.0d) {
                            this.cyv.onRoomEventUpdate(200, (long) this.czv, statsReport.toString());
                        }
                    }
                }
                return;
            }
        }
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void a(final StatsReport[] statsReportArr, final BigInteger bigInteger, final PeerConnectionClient.StatsEventsType statsEventsType) {
        if (bigInteger == this.cyZ && statsEventsType == PeerConnectionClient.StatsEventsType.GET_BWE_EVENT && this.czt) {
            a(statsReportArr);
        }
        this.mHandler.post(new Runnable() { // from class: com.baidu.rtc.a.a.6
            @Override // java.lang.Runnable
            public void run() {
                if (statsEventsType == PeerConnectionClient.StatsEventsType.GET_AUDIOLEVEL_EVENT) {
                    a.this.a(statsReportArr, bigInteger);
                }
                com.baidu.rtc.b.b bVar = (com.baidu.rtc.b.b) a.this.cyA.get(bigInteger);
                if (bVar != null) {
                    bVar.b(statsReportArr);
                }
                if ((a.this.cyJ || a.this.cyI) && statsEventsType == PeerConnectionClient.StatsEventsType.GET_QUALITY_MONITOR_EVENT && bigInteger == a.this.cyZ && a.this.czz != null) {
                    a.this.afa();
                }
                if ((a.this.cyJ || a.this.cyI) && statsEventsType == PeerConnectionClient.StatsEventsType.GET_SLI_EVENT && bigInteger == a.this.cyZ && a.this.czz != null) {
                    a.this.afc();
                }
            }
        });
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public boolean a(BaiduRtcRoom.RtcLiveTransferMode rtcLiveTransferMode) {
        this.czs.c(rtcLiveTransferMode);
        return true;
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public boolean a(BaiduRtcRoom.a aVar) {
        this.cyv = aVar;
        return true;
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public boolean a(String str, boolean z, boolean z2, String str2, BaiduRtcRoom.RtcLiveTransferMode rtcLiveTransferMode) {
        if (this.cyS.isEmpty() || this.cyR == rtcLiveTransferMode) {
            this.cyS = str;
            this.cyR = rtcLiveTransferMode;
            this.czs.eD(z2);
            this.czs.jE(str);
            this.czs.eC(z);
            this.czs.jD(str2);
            this.czs.b(rtcLiveTransferMode);
        } else {
            this.czs.c(str, z, z2, str2, rtcLiveTransferMode);
        }
        return true;
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void aZ(boolean z) {
        if (this.czw != null) {
            this.czw.setSpeakerMute(z);
        }
    }

    @Override // com.baidu.rtc.c
    public void aeA() {
        if (this.cyJ && !this.cyL) {
            jL("ENTER_FAILED");
        }
        if (this.cyv == null) {
            return;
        }
        this.cyv.onRoomEventUpdate(103, 0L, "coennection Error");
        jK("CONNECTION_LOST");
    }

    @Override // com.baidu.rtc.c
    public void aeB() {
        if (this.cyJ && !this.cyL) {
            jL("ENTER_FAILED");
        }
        if (this.cyv == null) {
            return;
        }
        this.cyv.onRoomEventUpdate(102, 0L, BdStatsConstant.StatsType.ERROR);
        jK("LOGIN_ERROR");
    }

    @Override // com.baidu.rtc.c
    public void aeC() {
        if (this.cyJ && !this.cyL) {
            jL("ENTER_FAILED");
        }
        if (this.cyv == null) {
            return;
        }
        this.cyv.onRoomEventUpdate(101, 0L, "time out");
    }

    @Override // com.baidu.rtc.c
    public void aeD() {
        if (this.cyv == null) {
            return;
        }
        this.cyv.onRoomEventUpdate(112, 0L, "");
    }

    @Override // com.baidu.rtc.c
    public void aeE() {
        if (this.cyv == null) {
            return;
        }
        this.cyv.onErrorInfoUpdate(402);
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void aeM() {
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void aeN() {
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void aeO() {
        if (this.cyJ && !this.cyL) {
            jL("ENTER_FAILED");
        }
        if (this.cyv != null) {
            this.cyv.onPeerConnectStateUpdate(2003);
        }
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void aeP() {
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public BaiduRtcRoom.c[] aez() {
        int i = 0;
        int i2 = 0;
        for (BigInteger bigInteger : this.czf.keySet()) {
            c cVar = this.czf.get(bigInteger);
            if (cVar != null && cVar.czL.booleanValue() && cVar.volume != -1) {
                i2++;
            }
        }
        BaiduRtcRoom.c[] cVarArr = new BaiduRtcRoom.c[i2];
        for (BigInteger bigInteger2 : this.czf.keySet()) {
            c cVar2 = this.czf.get(bigInteger2);
            if (cVar2 != null && cVar2.volume != -1 && cVar2.czL.booleanValue()) {
                if (i >= i2) {
                    break;
                }
                cVarArr[i] = new BaiduRtcRoom.c();
                cVarArr[i].userId = cVar2.userId;
                cVarArr[i].volumeLevel = cVar2.volume;
                cVarArr[i].nicName = cVar2.nickName;
                i++;
            }
        }
        return cVarArr;
    }

    @Override // com.baidu.rtc.c
    public void b(BaiduRtcRoom.RtcLiveTransferMode rtcLiveTransferMode, String str) {
        if (this.cyv == null) {
            return;
        }
        this.cyv.onRoomEventUpdate(118, rtcLiveTransferMode.ordinal(), str);
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void b(final com.baidu.rtc.a aVar) {
        int i;
        Log.e("BaiduRtcRoomImp", "=========onRemoteRender========" + aVar.cuN);
        final BigInteger k = this.czs.k(aVar.cuJ);
        if (k.longValue() == 0) {
            Log.e("BaiduRtcRoomImp", "onRemoteRender Userid is 0.");
        } else if (this.cyX.cxg == RtcParameterSettings.RtcVideoRenderMode.RTC_VIDEO_RENDER_MODE_EXTERNAL) {
            j bT = bT(k.longValue());
            Log.d("BaiduRtcRoomImp", "enable external video render mode with videoRenderer -> " + bT);
            if (bT != null) {
                aVar.cuN.addSink(bT);
                bT.setStuckEventListener(new d(aVar.cuJ));
                bT.setEnableSLIDataReport(this.cyI);
            } else {
                Log.d("BaiduRtcRoomImp", "Not found external render for user " + k);
            }
            a(aVar, k);
            this.cyv.onRoomEventUpdate(106, k.longValue(), "");
        } else {
            Log.d("BaiduRtcRoomImp", "it is internal video render mode");
            try {
                i = this.cyz.get(this.czs.k(aVar.cuJ)).intValue();
            } catch (Exception e) {
                i = -1;
            }
            if (i >= 0 && i < cyl && this.czc != null) {
                if (this.czc[i] != null) {
                    this.czc[i].setFirstFrameEventListener(new Runnable() { // from class: com.baidu.rtc.a.a.8
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.cyv != null) {
                                a.this.cyv.onRoomEventUpdate(106, k.longValue(), "");
                            }
                            a.this.a(aVar, k);
                        }
                    });
                    this.czc[i].setStuckEventListener(new d(aVar.cuJ));
                    this.czc[i].setEnableSLIDataReport(this.cyI);
                    aVar.cuN.addSink(this.czc[i]);
                }
                aVar.cuO = i;
            } else if (this.czc != null) {
                int i2 = 0;
                while (true) {
                    if (i2 >= this.cyB.length) {
                        i2 = -1;
                        break;
                    } else if (!this.cyB[i2]) {
                        this.cyB[i2] = true;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i2 >= 0) {
                    if (this.czc[i2] != null) {
                        this.czc[i2].setFirstFrameEventListener(new Runnable() { // from class: com.baidu.rtc.a.a.9
                            @Override // java.lang.Runnable
                            public void run() {
                                if (a.this.cyv != null) {
                                    a.this.cyv.onRoomEventUpdate(106, k.longValue(), "");
                                }
                                a.this.a(aVar, k);
                            }
                        });
                        this.czc[i2].setStuckEventListener(new d(aVar.cuJ));
                        this.czc[i2].setEnableSLIDataReport(this.cyI);
                        aVar.cuN.addSink(this.czc[i2]);
                    }
                    aVar.cuO = i2;
                }
                this.czg++;
            }
        }
    }

    @Override // com.baidu.rtc.c
    public void b(BigInteger bigInteger) {
        if (this.cyv == null) {
            return;
        }
        this.cyv.onPeerConnectStateUpdate(2003);
    }

    @Override // com.baidu.rtc.c
    public void b(BigInteger bigInteger, String str) {
        if (this.cyQ == bigInteger.longValue()) {
            this.cyQ = 0L;
        }
        if (this.cyP == bigInteger.longValue()) {
            this.cyP = 0L;
        }
        if (this.cyv == null) {
            return;
        }
        this.cyv.onRoomEventUpdate(104, bigInteger.longValue(), str);
    }

    @Override // com.baidu.rtc.c
    public void b(final BigInteger bigInteger, JSONObject jSONObject) {
        this.czw.b(bigInteger, new SessionDescription(SessionDescription.Type.fromCanonicalForm(jSONObject.optString("type")), jSONObject.optString("sdp")));
        this.mHandler.post(new Runnable() { // from class: com.baidu.rtc.a.a.3
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.cyI || bigInteger == a.this.cyZ || a.this.czw == null) {
                    return;
                }
                if (a.this.cyA.get(bigInteger) != null) {
                    a.this.czw.a(false, 0, bigInteger, PeerConnectionClient.StatsEventsType.GET_QUALITY_MONITOR_EVENT);
                    a.this.czw.a(false, 0, bigInteger, PeerConnectionClient.StatsEventsType.GET_SLI_EVENT);
                    a.this.cyA.remove(bigInteger);
                }
                a.this.czw.a(a.this.cyI, 2000, bigInteger, PeerConnectionClient.StatsEventsType.GET_QUALITY_MONITOR_EVENT);
                a.this.czw.a(a.this.cyI, 5000, bigInteger, PeerConnectionClient.StatsEventsType.GET_SLI_EVENT);
                com.baidu.rtc.b.b bVar = new com.baidu.rtc.b.b();
                a.this.cyA.put(bigInteger, bVar);
                bVar.bV(System.currentTimeMillis());
            }
        });
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public boolean b(String str, boolean z, boolean z2, String str2, BaiduRtcRoom.RtcLiveTransferMode rtcLiveTransferMode) {
        this.czs.d(str, z, z2, str2, rtcLiveTransferMode);
        return true;
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void bO(long j) {
        if (this.czs != null) {
            this.czs.bO(j);
        }
    }

    public void bO(Context context) {
        Log.d("BaiduRtcRoomImp", "setup so later loading feature, and cpu type: " + this.mCpuType);
        com.baidu.cloudbase.b.a.Z(context).dt(this.mCpuType);
        if (this.czm.isEmpty()) {
            com.baidu.cloudbase.b.a.Z(context).a(com.baidu.cloudbase.b.b.tZ(), true, this.czj);
            return;
        }
        Log.d("BaiduRtcRoomImp", "setup so later load url: " + this.czm);
        com.baidu.cloudbase.b.a.Z(context).a(this.czm, true, this.czj);
    }

    @Override // com.baidu.rtc.c
    public void bP(long j) {
        if (this.cyv == null) {
            return;
        }
        this.cyv.onRoomEventUpdate(114, j, "");
    }

    @Override // com.baidu.rtc.c
    public void bQ(long j) {
        if (this.cyv == null) {
            return;
        }
        this.cyv.onRoomEventUpdate(115, j, "");
    }

    @Override // com.baidu.rtc.c
    public void bR(long j) {
        if (this.cyv == null) {
            return;
        }
        this.cyv.onRoomEventUpdate(113, j, "");
    }

    public j bT(long j) {
        j kVar;
        synchronized (this) {
            Log.d("BaiduRtcRoomImp", j + " : Get external renderer.");
            if (this.czo.containsKey(Long.valueOf(j))) {
                kVar = this.czo.get(Long.valueOf(j));
            } else {
                kVar = new k(this.cyv, j);
                Log.d("BaiduRtcRoomImp", j + " : Create external renderer" + kVar);
                this.czo.put(Long.valueOf(j), kVar);
            }
        }
        return kVar;
    }

    @Override // com.baidu.rtc.c
    public void c(BaiduRtcRoom.RtcLiveTransferMode rtcLiveTransferMode, String str) {
        if (this.cyv == null) {
            return;
        }
        this.cyv.onRoomEventUpdate(116, rtcLiveTransferMode.ordinal(), str);
    }

    @Override // com.baidu.rtc.c
    public void c(final BigInteger bigInteger) {
        if (this.cyv != null) {
            this.cyv.onRoomEventUpdate(100, 0L, "ok");
        }
        this.cyZ = bigInteger;
        if (this.cyX.AutoPublish) {
            p(bigInteger);
        }
        if (this.czt && this.czw != null) {
            this.czw.a(this.czt, 5000, this.cyZ, PeerConnectionClient.StatsEventsType.GET_BWE_EVENT);
        }
        this.mHandler.post(new Runnable() { // from class: com.baidu.rtc.a.a.2
            @Override // java.lang.Runnable
            public void run() {
                if ((a.this.cyJ || a.this.cyI) && a.this.czw != null) {
                    if (a.this.cyA.get(bigInteger) != null) {
                        a.this.czw.a(false, 0, bigInteger, PeerConnectionClient.StatsEventsType.GET_QUALITY_MONITOR_EVENT);
                        a.this.czw.a(false, 0, bigInteger, PeerConnectionClient.StatsEventsType.GET_SLI_EVENT);
                        a.this.cyA.remove(bigInteger);
                    }
                    a.this.czw.a(a.this.cyJ || a.this.cyI, 2000, bigInteger, PeerConnectionClient.StatsEventsType.GET_QUALITY_MONITOR_EVENT);
                    a.this.czw.a(a.this.cyJ || a.this.cyI, 5000, bigInteger, PeerConnectionClient.StatsEventsType.GET_SLI_EVENT);
                    a.this.cyA.put(bigInteger, new com.baidu.rtc.b.b());
                    if (a.this.czz != null && !a.this.czu) {
                        a.this.czu = true;
                        a.this.mHandler.post(a.this.czx);
                    }
                    a aVar = a.this;
                    aVar.jK("RTCROOM_LOGIN_OK_" + a.this.mUserId);
                }
                c cVar = (c) a.this.czf.get(BigInteger.valueOf(a.this.mUserId));
                if (cVar != null) {
                    if (a.this.czw != null) {
                        a.this.czw.a(false, 0, cVar.cuJ, PeerConnectionClient.StatsEventsType.GET_AUDIOLEVEL_EVENT);
                    }
                    cVar.czM = Boolean.valueOf(a.this.cyX.HasVideo);
                    cVar.czL = Boolean.valueOf(a.this.cyX.HasAudio);
                    cVar.cuJ = bigInteger;
                    cVar.nickName = a.this.mDisplayName;
                } else {
                    a.this.czf.put(BigInteger.valueOf(a.this.mUserId), new c(bigInteger, a.this.mUserId, Boolean.valueOf(a.this.cyX.HasVideo), Boolean.valueOf(a.this.cyX.HasAudio), a.this.mDisplayName));
                }
                if (a.this.czw != null) {
                    a.this.czw.a(true, 200, bigInteger, PeerConnectionClient.StatsEventsType.GET_AUDIOLEVEL_EVENT);
                }
            }
        });
    }

    @Override // com.baidu.rtc.c
    public void c(BigInteger bigInteger, String str) {
        if (this.cyv == null) {
            return;
        }
        this.cyv.onRoomEventUpdate(302, bigInteger.longValue(), str);
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void changeSurfaceSize(long j, int i, int i2) {
        if (this.czo.containsKey(Long.valueOf(j))) {
            j jVar = this.czo.get(Long.valueOf(j));
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
        if (this.czs != null) {
            this.czs.d(j, z);
        }
    }

    @Override // com.baidu.rtc.c
    public void d(BigInteger bigInteger) {
        if (this.czw != null) {
            this.czw.h(bigInteger);
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void d(boolean z, boolean z2, String str) {
        this.cyJ = z;
        this.cyI = z2;
        this.cza = str;
        if (!z && !z2) {
            if (this.cyx != null) {
                this.cyx.pause();
                return;
            }
            return;
        }
        if (this.cyx == null) {
            this.cyx = new com.baidu.rtc.b.a(this.czk);
        }
        if (this.czz == null) {
            this.czz = com.baidu.rtc.b.d.afv();
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void destroyExternalSurface(long j, Surface surface) {
        j jVar;
        if (this.czo.containsKey(Long.valueOf(j)) && (jVar = this.czo.get(Long.valueOf(j))) != null && surface == jVar.getSurface()) {
            jVar.releaseSurface();
        }
        aeZ();
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void disbandRoom() {
        if (this.czs != null) {
            this.czs.disbandRoom();
        }
    }

    public void doDestroy() {
        logoutRtcRoom();
        cym.remove(toString());
    }

    @Override // com.baidu.rtc.c
    public void e(BigInteger bigInteger) {
        if (this.cyv == null) {
            return;
        }
        this.cyv.onRoomEventUpdate(301, bigInteger.longValue(), "");
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void enableAgc(boolean z) {
        this.cyp = Boolean.valueOf(z);
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void enableAns(boolean z) {
        this.cyq = Boolean.valueOf(z);
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void enableExternalVideoCapturer(boolean z) {
        this.cyH = z;
        this.czr = new VideoSink() { // from class: com.baidu.rtc.a.a.12
            @Override // org.webrtc.VideoSink
            public void onFrame(VideoFrame videoFrame) {
            }
        };
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void enableStatsToServer(boolean z, String str) {
        d(z, z, str);
    }

    @Override // com.baidu.rtc.c
    public void f(BigInteger bigInteger) {
        if (this.cyJ && bigInteger == this.cyZ) {
            this.cyL = true;
            this.cyU = System.currentTimeMillis();
            if (this.cyU - this.czn > 5000) {
                jL("ENTER_TIMEOUT");
            }
        }
        if (this.cyv == null) {
            return;
        }
        this.cyv.onPeerConnectStateUpdate(2000);
        jK("WEBRTC_UP_" + bigInteger.longValue());
    }

    @Override // com.baidu.rtc.c
    public void fT(int i) {
        if (this.cyv != null && i == 436) {
            this.cyv.onErrorInfoUpdate(RTCConst.RTC_ROOM_USERID_ALREADY_EXIST_ERROR);
        }
    }

    @Override // com.baidu.rtc.c
    public void g(boolean z, int i) {
        if (this.cyv == null) {
            return;
        }
        this.cyv.onPeerConnectStateUpdate(i < 10 ? 2100 : i < 15 ? RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL1 : i < 25 ? RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL2 : i < 40 ? RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL3 : i < 60 ? RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL4 : i < 90 ? RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL5 : i < 120 ? RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL6 : i < 180 ? RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL7 : i < 250 ? RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL8 : RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL9);
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public boolean jB(String str) {
        this.czs.jG(str);
        return true;
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void jC(String str) {
        if (this.cyJ && !this.cyL) {
            jL("ENTER_FAILED");
        }
        if (this.cyv != null) {
            this.cyv.onErrorInfoUpdate(10000);
        }
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void l(ByteBuffer byteBuffer) {
        if (this.cyv == null) {
            return;
        }
        this.cyv.onRoomDataMessage(byteBuffer);
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public boolean loginRtcRoomWithRoomName(String str, long j, String str2, boolean z) {
        Log.i("BaiduRtcRoomImp", "enable force login");
        this.cyF = z;
        return loginRtcRoomWithRoomName(str, j, str2, true, true);
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public boolean loginRtcRoomWithRoomName(String str, long j, String str2, boolean z, boolean z2) {
        boolean z3;
        int i;
        int i2;
        int i3;
        int i4;
        this.mDisplayName = str2;
        this.mRoomName = str;
        this.mUserId = j;
        this.cyE = z;
        this.cyD = z2;
        if (this.cyK) {
            try {
                System.loadLibrary("jingle_peerconnection_so");
            } catch (UnsatisfiedLinkError e) {
                z3 = false;
            }
        }
        z3 = true;
        if (!z3 && this.cyK && !this.cyM) {
            this.czl = new Thread(new Runnable() { // from class: com.baidu.rtc.a.a.15
                @Override // java.lang.Runnable
                public void run() {
                    Log.d("BaiduRtcRoomImp", "setup downloading thread ......");
                    a.this.bO(a.this.czk);
                }
            });
            this.czl.start();
            return true;
        } else if (j == 0) {
            throw new InvalidParameterException("loginRtcRoomWithRoomName: Param Error,userId cann't be zero. zero is reserved.");
        } else {
            this.czs.jH(str);
            this.czs.setUserId(j);
            if (str2 != null && !str2.isEmpty()) {
                this.czs.setDisplayName(str2);
            }
            this.czs.setVideoCodec(this.cyX.VideoCodec);
            this.czs.ez(z);
            this.czs.ey(z2);
            int i5 = this.cyX.VideoWidth;
            int i6 = this.cyX.VideoHeight;
            String lowerCase = this.cyX.VideoResolution.toLowerCase();
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
                i6 = VideoConstant.THUMBNAIL_WIDTH;
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
                this.cyX.cwV = true;
                this.cyq = true;
            }
            if (Build.HARDWARE.contains("mt6768")) {
                this.cyX.cxb = true;
                this.cyX.cxa = false;
            }
            if (Build.MODEL.contains("Mi Note 2") || Build.MODEL.contains("V1809")) {
                this.cyX.cxc = 1;
            }
            this.cvv = new PeerConnectionClient.c(false, i, i6, this.cyX.VideoFps, this.cyX.VideoCodec.toUpperCase(), true, 0, "opus", false, false, this.cyX.cwV, this.cyp.booleanValue(), this.cyq.booleanValue(), this.cyX.VideoMaxkbps, this.cyX.VideoMinkbps, this.cyX.cxe, this.cyX.cwU, true, this.cyX.cwX, this.cyX.cxb, this.cyX.cwY, this.cyX.cwR, this.cyX.cvX, this.cyX.cxf, this.cyX.cxc, this.cyX.cwZ, this.cyX.cxa, this.cyX.cwT, this.cyX.cwP, this.cyX.cwS, this.cyX.cwQ);
            this.czw = PeerConnectionClient.aeI();
            if (this.cyy) {
                if (this.cyu == null) {
                    this.cyu = new com.baidu.cloudbase.a.a();
                }
                this.cyu.aQ(false);
                if (this.czb < 0) {
                    this.czb = this.cyu.tS();
                }
                this.cyu.tT();
                this.cyu.aP(false);
                this.cyu.aO(false);
                this.cyu.a(this.cyW);
            }
            if (this.czh != null || this.cyy) {
                this.czw.a(this.czi);
            }
            if (this.czd != null || this.cyy) {
                this.czw.a(this.cze);
            }
            if (this.cyX != null) {
                this.czs.et(this.cyX.HasAudio);
                this.czw.et(this.cyX.HasAudio);
                this.czs.ev(this.cyX.HasVideo);
                this.czw.ev(this.cyX.HasVideo);
                this.czs.eu(this.cyX.HasData);
                this.czw.eu(this.cyX.HasData);
                this.czw.fU(this.cyX.AudioFrequency);
                this.czw.setAudioChannel(this.cyX.AudioChannel);
                this.czs.fV(this.cyX.ConnectionTimeoutMs);
                this.czs.fW(this.cyX.ReadTimeoutMs);
                this.czs.eA(this.cyX.AutoPublish);
                this.czs.eB(this.cyX.AutoSubScribe);
                this.czs.jF(this.cyX.cxd);
            }
            this.czw.es(this.cyG);
            this.czw.er(cvr);
            this.czw.a(this.mContext.get(), this.cvv, this);
            this.czw.setStuckEventListener(new C0319a());
            this.czw.setEnableSLIReport(this.cyI);
            this.czs.K(this.cyO, this.cyF);
            Log.i("BRTC", "loginRtcRoomWithRoomName: this " + this + " version: " + version());
            return true;
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public boolean logoutRtcRoom() {
        if (this.czw != null) {
            this.czw.eq(false);
            this.czw.ew(false);
            this.czw.aeL();
            this.czs.yr();
            this.czs.finalize();
            this.czw.close();
            if (this.cyx != null) {
                this.cyx.pause();
            }
            this.cyA.clear();
            this.czw = null;
            this.czs = null;
            if (this.cyu != null) {
                this.cyu.a(null);
                this.cyu.release();
            }
            if (this.cyT != null) {
                this.cyT.release();
                this.cyT = null;
            }
            if (this.czc != null) {
                for (int i = 0; i < this.czc.length; i++) {
                    if (this.czc[i] != null) {
                        this.czc[i].release();
                        this.czc[i] = null;
                    }
                }
            }
            aeY();
            aeZ();
            if (this.czy != null) {
                this.czy.release();
            }
            if (this.audioManager != null && this.audioManager.isBluetoothScoOn()) {
                d((Boolean) false);
            }
            if (this.cyC != null) {
                this.mContext.get().unregisterReceiver(this.cyC);
                this.cyC = null;
            }
            System.gc();
        }
        return true;
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void muteMicphone(boolean z) {
        if (this.czw != null) {
            this.czw.eq(!z);
        }
        jK("MUTE_MICPHONE");
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void onIceCandidatesRemoved(IceCandidate[] iceCandidateArr) {
    }

    public void presetLoudSpeaker(boolean z) {
        ((AudioManager) this.mContext.get().getSystemService("audio")).setSpeakerphoneOn(z);
        jK("PRESETLOUDSPEAKER");
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void publishStreaming() {
        p(this.cyZ);
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void sendMessageToUser(String str, long j) {
        if (this.czs == null) {
            return;
        }
        this.czs.sendMessageToUser(str, j);
        try {
            Thread.sleep(10L);
        } catch (InterruptedException e) {
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void setExternalSurface(long j, Surface surface) {
        j bT = bT(j);
        if (bT != null) {
            if (!bT.aeQ()) {
                bT.init();
                bT.ex(true);
            }
            for (Long l : this.czo.keySet()) {
                j jVar = this.czo.get(l);
                if (jVar != null && jVar.hasSurface() && surface == jVar.getSurface() && this.cyv != null) {
                    Log.d("BaiduRtcRoomImp", "Set surface repeat with userId " + j);
                    this.cyv.onErrorInfoUpdate(600);
                    return;
                }
            }
            bT.setSurface(surface);
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void setUserAttribute(String str) {
        if (this.czs == null) {
            return;
        }
        this.czs.setUserAttribute(str);
        try {
            Thread.sleep(10L);
        } catch (InterruptedException e) {
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void stopPublish() {
        if (this.czs == null) {
            return;
        }
        this.czs.o(this.cyZ);
        if (this.czw != null) {
            this.czw.aeK();
            this.czw.aeL();
            this.czw.h(this.cyZ);
            if (this.cyT != null) {
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.rtc.a.a.20
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.cyT.clearImage();
                    }
                }, 100L);
            }
            if (this.cvF != null) {
                this.cvF.dispose();
                this.cvF = null;
                cym.remove(toString());
            }
        }
        this.cyN = false;
    }
}
