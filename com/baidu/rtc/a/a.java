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
/* loaded from: classes10.dex */
public class a extends BaiduRtcRoom implements PeerConnectionClient.b, com.baidu.rtc.c {
    public static boolean ctP = false;
    static int cwK = -1;
    public static int cwL = 30;
    private static ConcurrentHashMap<String, String> cwM = new ConcurrentHashMap<>();
    public static int cwN = 1;
    private int cwO;
    private Boolean cwS;
    private com.baidu.cloudbase.a.a cwU;
    com.baidu.rtc.b.a cwX;
    private Context cxK;
    private long cxN;
    private VideoSink cxR;
    private p cxS;
    private EglBase cxY;
    com.baidu.rtc.b.d cxZ;
    b cxc;
    private boolean cxk;
    BaiduRtcRoom.RtcLiveTransferMode cxr;
    private long cxu;
    String mAppId;
    private WeakReference<Context> mContext;
    private String mCpuType;
    String mDisplayName;
    String mRoomName;
    long mUserId;
    private boolean cxh = false;
    private boolean cxg = false;
    private boolean cwY = false;
    private volatile PeerConnectionClient cxW = null;
    private PeerConnectionClient.c ctT = null;
    private RTCVideoView cxt = null;
    private RTCVideoView[] cxC = null;
    private VideoCapturer cud = null;
    private String cxo = "wss://rtc.exp.bcelive.com/janus";
    private int cxG = 0;
    private boolean cxP = true;
    private boolean[] cxb = new boolean[cwL];
    private AudioManager audioManager = null;
    private int cxB = -1;
    BaiduRtcRoom.a cwV = null;
    g.d cxH = null;
    g.c cxD = null;
    g.b cxv = null;
    private ConcurrentHashMap<Long, j> cxO = new ConcurrentHashMap<>();
    private IdentityHashMap<Long, j> cxy = new IdentityHashMap<>();
    private boolean cxQ = false;
    int cwW = cwK;
    private RtcParameterSettings cxx = new RtcParameterSettings();
    private Handler mHandler = new Handler(Looper.getMainLooper());
    BigInteger cxz = null;
    volatile long cxq = 0;
    volatile long cxp = 0;
    ConcurrentHashMap<BigInteger, BigInteger> cwZ = new ConcurrentHashMap<>();
    boolean cxT = true;
    double cxV = 200.0d;
    boolean cxj = false;
    boolean cxi = false;
    String cxA = "online";
    private ConcurrentHashMap<BigInteger, com.baidu.rtc.b.b> cxa = new ConcurrentHashMap<>();
    boolean cxU = false;
    boolean cxd = true;
    boolean cxe = true;
    boolean cxf = false;
    boolean cxn = false;
    Boolean cwP = false;
    Boolean cwQ = false;
    String cxs = "";
    private boolean cwT = false;
    private boolean cxl = false;
    private ConcurrentHashMap<BigInteger, c> cxF = new ConcurrentHashMap<>();
    private Thread cxL = null;
    private boolean cxm = false;
    private String cxM = "";
    private com.baidu.cloudbase.b.c cxJ = new c.a() { // from class: com.baidu.rtc.a.a.1
        @Override // com.baidu.cloudbase.b.c
        public void R(String str, String str2) {
            Log.d("BaiduRtcRoomImp", "Be successful to download so!");
            String str3 = com.baidu.cloudbase.b.b.Z(a.this.cxK) + File.separator + "libjingle_peerconnection_so.so";
            Log.d("BaiduRtcRoomImp", "RTC so path is: " + str3);
            a.this.cxm = true;
            if (com.baidu.cloudbase.b.a.aa(a.this.cxK).m18do(com.baidu.cloudbase.b.b.Z(a.this.cxK))) {
                try {
                    System.load(str3);
                    Log.d("BaiduRtcRoomImp", "loaded so, and start to login room.");
                    a.this.loginRtcRoomWithRoomName(a.this.mRoomName, a.this.mUserId, a.this.mDisplayName, a.this.cxe, a.this.cxd);
                    return;
                } catch (Throwable th) {
                    Log.d("BaiduRtcRoomImp", "Failed call System.load to load so! Error: " + th);
                    if (a.this.cwV != null) {
                        a.this.cwV.onErrorInfoUpdate(401);
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
                a.this.loginRtcRoomWithRoomName(a.this.mRoomName, a.this.mUserId, a.this.mDisplayName, a.this.cxe, a.this.cxd);
            } catch (Throwable th2) {
                Log.d("BaiduRtcRoomImp", "Failed to load so with full path! Error: " + th2);
                if (a.this.cwV != null) {
                    a.this.cwV.onErrorInfoUpdate(401);
                }
            }
        }

        @Override // com.baidu.cloudbase.b.c
        public void b(String str, int i, String str2) {
            Log.d("BaiduRtcRoomImp", "Failed to download so.");
            if (a.this.cwV != null) {
                a.this.cwV.onErrorInfoUpdate(400);
            }
        }
    };
    JavaAudioDeviceModule.SamplesReadyCallback cxI = new JavaAudioDeviceModule.SamplesReadyCallback() { // from class: com.baidu.rtc.a.a.16
        @Override // org.webrtc.audio.JavaAudioDeviceModule.SamplesReadyCallback
        public void onWebRtcAudioRecordSamplesReady(JavaAudioDeviceModule.AudioSamples audioSamples) {
            if (audioSamples == null || audioSamples.getData() == null || audioSamples.getData().length <= 0) {
                return;
            }
            if (a.this.cxH != null) {
                a.this.cxH.a(new g(audioSamples.getAudioFormat(), audioSamples.getChannelCount(), audioSamples.getSampleRate(), audioSamples.getData()));
            }
            if (!a.this.cwY || a.this.cxg) {
                return;
            }
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            bufferInfo.size = audioSamples.getData().length;
            bufferInfo.offset = 0;
            ByteBuffer wrap = ByteBuffer.wrap(audioSamples.getData());
            bufferInfo.presentationTimeUs = System.nanoTime();
            a.this.cwU.a(wrap, bufferInfo);
        }
    };
    JavaAudioDeviceModule.RemoteSamplesReadyCallback cxE = new JavaAudioDeviceModule.RemoteSamplesReadyCallback() { // from class: com.baidu.rtc.a.a.17
        @Override // org.webrtc.audio.JavaAudioDeviceModule.RemoteSamplesReadyCallback
        public void onWebRtcAudioRemoteSamplesReady(JavaAudioDeviceModule.AudioSamples audioSamples) {
            if (audioSamples == null) {
                return;
            }
            if (a.this.cxD != null) {
                a.this.cxD.c(new g(audioSamples.getAudioFormat(), audioSamples.getChannelCount(), audioSamples.getSampleRate(), audioSamples.getData()));
            }
            if (!a.this.cwY || a.this.cxB < 0) {
                return;
            }
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            bufferInfo.size = audioSamples.getData().length;
            bufferInfo.offset = 0;
            a.this.cwU.a(ByteBuffer.wrap(audioSamples.getData()), bufferInfo, a.this.cxB);
        }
    };
    g.a cwR = new g.a() { // from class: com.baidu.rtc.a.a.18
    };
    private com.baidu.cloudbase.c.a cxw = new com.baidu.cloudbase.c.a() { // from class: com.baidu.rtc.a.a.19
        @Override // com.baidu.cloudbase.c.a
        public void onFilteredFrameUpdate(byte[] bArr, MediaCodec.BufferInfo bufferInfo) {
            if (a.this.cxv != null) {
                a.this.cxv.b(new g(2, a.this.cxx.AudioChannel, a.this.cxx.AudioFrequency, bArr, bufferInfo.presentationTimeUs));
            }
        }
    };
    private Runnable cxX = new Runnable() { // from class: com.baidu.rtc.a.a.13
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.cxZ != null && (a.this.cxj || a.this.cxi)) {
                a.this.aeY();
            }
            a.this.mHandler.postDelayed(a.this.cxX, 300000L);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.rtc.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C0313a implements e {
        private C0313a() {
        }

        @Override // com.baidu.rtc.b.e
        public void m(long j, long j2) {
            if (a.this.cxi) {
                for (Map.Entry entry : a.this.cxa.entrySet()) {
                    if (entry.getKey() != a.this.cxz && entry.getValue() != null) {
                        ((com.baidu.rtc.b.b) entry.getValue()).n(j, j2);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
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
                                if (u == a.this.cwO) {
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

    /* loaded from: classes10.dex */
    public static class c {
        public BigInteger cte;
        public Boolean cyl;
        public Boolean cym;
        public String nickName;
        public long userId;
        public int volume = -1;

        public c(BigInteger bigInteger, long j, Boolean bool, Boolean bool2, String str) {
            this.nickName = "";
            this.cte = bigInteger;
            this.userId = j;
            this.cyl = bool2;
            this.cym = bool;
            this.nickName = str;
        }
    }

    /* loaded from: classes10.dex */
    private class d implements e {
        private BigInteger cte;

        d(BigInteger bigInteger) {
            this.cte = bigInteger;
        }

        @Override // com.baidu.rtc.b.e
        public void m(long j, long j2) {
            com.baidu.rtc.b.b bVar;
            if (!a.this.cxi || (bVar = (com.baidu.rtc.b.b) a.this.cxa.get(this.cte)) == null) {
                return;
            }
            bVar.o(j, j2);
        }
    }

    public a(Context context, String str, String str2, String str3, boolean z) {
        this.mContext = null;
        this.cxS = null;
        this.cxY = null;
        this.cxc = null;
        this.cxk = false;
        this.mCpuType = "armeabi-v7a";
        this.cxK = null;
        this.cxk = z;
        this.cxK = context;
        this.mContext = new WeakReference<>(context);
        this.mCpuType = str3;
        this.cxS = new p();
        this.cxS.setAppId(str);
        this.cxS.jC(str2);
        this.cxS.jB("BRTC.Android.SDK V" + version());
        this.mAppId = str;
        this.cxS.a(this);
        this.cxY = EglBase_CC.create();
        for (int i = 0; i < this.cxb.length; i++) {
            this.cxb[i] = false;
        }
        AudioManager audioManager = (AudioManager) this.mContext.get().getSystemService("audio");
        audioManager.setSpeakerphoneOn(false);
        if (this.cxj || this.cxi) {
            this.cwX = new com.baidu.rtc.b.a(context);
            this.cxZ = com.baidu.rtc.b.d.afs();
        }
        this.cwO = 0;
        this.cwS = false;
        audioManager = audioManager == null ? (AudioManager) this.mContext.get().getSystemService("audio") : audioManager;
        this.cxc = new b();
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
        this.mContext.get().registerReceiver(this.cxc, intentFilter);
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
        if (this.cwW == cwK || this.cwW >= deviceNames.length || (createCapturer3 = cameraEnumerator.createCapturer(deviceNames[this.cwW], null)) == null) {
            Log.d("BaiduRtcRoomImp", "Looking for front facing cameras.");
            for (String str : deviceNames) {
                if (cameraEnumerator.isFrontFacing(str)) {
                    Log.d("BaiduRtcRoomImp", "Creating front facing camera capturer.");
                    if (!cwM.containsValue(str) && (createCapturer2 = cameraEnumerator.createCapturer(str, null)) != null) {
                        cwM.put(toString(), str);
                        this.cxQ = true;
                        if (this.cxt != null) {
                            this.cxt.setMirror(true);
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
                    if (!cwM.containsValue(str2) && (createCapturer = cameraEnumerator.createCapturer(str2, null)) != null) {
                        cwM.put(toString(), str2);
                        this.cxQ = false;
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
        if (!this.cxi || (bVar = this.cxa.get(aVar.cte)) == null) {
            return;
        }
        bVar.bU(System.currentTimeMillis());
        l(bigInteger.longValue(), bVar.afn() - bVar.afp());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(StatsReport[] statsReportArr, BigInteger bigInteger) {
        BigInteger k;
        StatsReport.Value[] valueArr;
        StatsReport.Value[] valueArr2;
        if (this.cxS == null) {
            return;
        }
        if (bigInteger == this.cxz) {
            k = BigInteger.valueOf(this.mUserId);
        } else {
            k = this.cxS.k(bigInteger);
            if (k == null) {
                return;
            }
        }
        c cVar = this.cxF.get(k);
        if (cVar == null) {
            if (this.cxW != null) {
                this.cxW.a(false, 0, bigInteger, PeerConnectionClient.StatsEventsType.GET_AUDIOLEVEL_EVENT);
                return;
            }
            return;
        }
        for (StatsReport statsReport : statsReportArr) {
            if (bigInteger == this.cxz) {
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

    private boolean aeT() {
        return !Build.MODEL.contains("SABRESD-MX6DQ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public VideoCapturer aeU() {
        VideoCapturer a2;
        if (this.cud != null) {
            return this.cud;
        }
        if (afa()) {
            Log.d("BaiduRtcRoomImp", "Creating capturer using camera2 API.");
            a2 = a(new Camera2Enumerator(this.mContext.get()));
        } else {
            Log.d("BaiduRtcRoomImp", "Creating capturer using camera1 API.");
            a2 = a(new Camera1Enumerator(aeT()));
        }
        if (a2 == null) {
            Log.e("BaiduRtcRoomImp", "Failed to open camera");
            return null;
        }
        return a2;
    }

    private void aeV() {
        if (this.cxO.isEmpty()) {
            return;
        }
        for (Long l : this.cxO.keySet()) {
            j jVar = this.cxO.get(l);
            if (jVar != null) {
                if (jVar.getSurface() != null) {
                    jVar.releaseSurface();
                }
                jVar.release();
            }
            this.cxO.remove(l);
        }
    }

    private void aeW() {
        synchronized (this) {
            if (this.cxy.isEmpty()) {
                return;
            }
            for (j jVar : this.cxy.values()) {
                if (jVar != null) {
                    if (jVar.getSurface() != null) {
                        jVar.releaseSurface();
                    }
                    jVar.release();
                }
            }
            this.cxy.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aeX() {
        com.baidu.rtc.b.b bVar;
        if (this.cxS == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        boolean z = true;
        com.baidu.rtc.b.b bVar2 = this.cxa.get(this.cxz);
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
            if (this.cwX != null) {
                jSONObject3.put("sysCpuUsage", this.cwX.afi());
            }
            jSONObject3.put("appCpuUsage", 0);
            jSONObject2.put("resourceUsageInfo", jSONObject3);
            if (this.cxj) {
                JSONObject jSONObject4 = new JSONObject();
                if (z2) {
                    jSONObject4.put(KsMediaMeta.KSM_KEY_BITRATE, hashMap.get("bitrate_s"));
                    jSONObject4.put("packetloss", hashMap.get("packetloss_s"));
                    jSONObject4.put("cfps", hashMap.get("fps_s"));
                    jSONObject4.put(AlaRecorderLog.KEY_CANERA_START_FPS, hashMap.get("fps_i"));
                    if (bVar2 == null) {
                        jSONObject4.put("resolution", "");
                    } else {
                        jSONObject4.put("resolution", bVar2.afq());
                    }
                } else {
                    jSONObject4.put(KsMediaMeta.KSM_KEY_BITRATE, 0);
                    jSONObject4.put("packetloss", 0);
                    jSONObject4.put(AlaRecorderLog.KEY_CANERA_START_FPS, 0);
                    jSONObject4.put("resolution", "");
                }
                jSONObject2.put("senderQualityInfo", jSONObject4);
            }
            if (this.cxi) {
                JSONArray jSONArray = new JSONArray();
                for (BigInteger bigInteger : this.cxa.keySet()) {
                    if (bigInteger != this.cxz && (bVar = this.cxa.get(bigInteger)) != null) {
                        HashMap hashMap2 = new HashMap();
                        bVar.w(hashMap2);
                        if (hashMap2.size() != 0) {
                            JSONObject jSONObject5 = new JSONObject();
                            if (this.cxS != null) {
                                jSONObject5.put("feedId", this.cxS.k(bigInteger));
                            }
                            jSONObject5.put(KsMediaMeta.KSM_KEY_BITRATE, hashMap2.get("bitrate_r"));
                            jSONObject5.put("packetloss", hashMap2.get("packetloss_r"));
                            jSONObject5.put(AlaRecorderLog.KEY_CANERA_START_FPS, hashMap2.get("fps_r"));
                            jSONObject5.put("resolution", bVar.afo());
                            jSONArray.put(jSONObject5);
                        }
                    }
                }
                jSONObject2.put("receiverQualityInfoList", jSONArray);
            }
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put("communicationQualityInfo", jSONObject2);
            jSONObject.put("env", this.cxA);
            jSONObject.put("appId", this.mAppId);
            if (this.cxS != null) {
                jSONObject.put("roomId", this.cxS.getRoomId());
            }
            jSONObject.put("timestamp", System.currentTimeMillis());
            jSONObject.put(TbEnum.SystemMessage.KEY_USER_ID, this.mUserId);
            jSONObject.put("message", jSONObject6);
        } catch (JSONException e) {
            Log.e("BaiduRtcRoomImp", "Caught error on reportCommunicationQualityInfo: " + e);
        }
        this.cxZ.report(jSONObject.toString(), 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aeY() {
        if (this.cxS == null) {
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
            jSONObject.put("env", this.cxA);
            jSONObject.put("appId", this.mAppId);
            if (this.cxS != null) {
                jSONObject.put("roomId", this.cxS.getRoomId());
            }
            jSONObject.put("timestamp", System.currentTimeMillis());
            jSONObject.put(TbEnum.SystemMessage.KEY_USER_ID, this.mUserId);
            jSONObject.put("message", jSONObject3);
        } catch (JSONException e) {
            Log.e("BaiduRtcRoomImp", "Caught error on reportDeviceInfo: " + e);
        }
        this.cxZ.report(jSONObject.toString(), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aeZ() {
        com.baidu.rtc.b.b bVar;
        if (this.cxS != null && this.cxi) {
            new JSONArray();
            for (BigInteger bigInteger : this.cxa.keySet()) {
                if (bigInteger != this.cxz && (bVar = this.cxa.get(bigInteger)) != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("feedId", this.cxS.k(bigInteger));
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
                        bVar.afl();
                        JSONObject jSONObject6 = new JSONObject();
                        if (bVar.afm() > 0) {
                            jSONObject6.put("duration", bVar.afm());
                            jSONObject3.put("e2eDelay", jSONObject6);
                        }
                        jSONObject2.put("sli", jSONObject3);
                        jSONObject.put("env", this.cxA);
                        jSONObject.put("appId", this.mAppId);
                        if (this.cxS != null) {
                            jSONObject.put("roomId", this.cxS.getRoomId());
                        }
                        jSONObject.put("timestamp", System.currentTimeMillis());
                        jSONObject.put(TbEnum.SystemMessage.KEY_USER_ID, this.mUserId);
                        jSONObject.put("message", jSONObject2);
                    } catch (JSONException e) {
                        Log.e("BaiduRtcRoomImp", "Caught error on reportDeviceInfo: " + e);
                    }
                    this.cxZ.report(jSONObject.toString(), 3);
                }
            }
        }
    }

    private boolean afa() {
        Camera2Enumerator.disableExtraCamera(this.cxx.cvw);
        return Camera2Enumerator.isSupported(this.mContext.get());
    }

    private void bS(long j) {
        synchronized (this) {
            if (this.cxO.containsKey(Long.valueOf(j))) {
                this.cxy.put(Long.valueOf(j), this.cxO.get(Long.valueOf(j)));
                this.cxO.remove(Long.valueOf(j));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int d(Boolean bool) {
        if (this.cwS == bool) {
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
            this.cwS = bool;
            return 0;
        } catch (Exception e) {
            Log.e("BaiduRtcRoomImp", "set bluetooth sco fail: " + e.getMessage());
            return -1;
        }
    }

    public static void ep(boolean z) {
        ctP = z;
    }

    private void h(String str, long j) {
        if (this.cxS == null) {
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
            jSONObject.put("env", this.cxA);
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
        this.cxZ.report(jSONObject.toString(), 3);
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
    public void jD(String str) {
        if ((this.cxj || this.cxi) && this.cxS != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(TbEnum.SystemMessage.KEY_USER_NAME, this.mDisplayName);
                jSONObject2.put("eventDescription", str);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("roomEvent", jSONObject2);
                jSONObject.put("env", this.cxA);
                jSONObject.put("appId", this.mAppId);
                if (this.cxS != null) {
                    jSONObject.put("roomId", this.cxS.getRoomId());
                }
                jSONObject.put("timestamp", System.currentTimeMillis());
                jSONObject.put(TbEnum.SystemMessage.KEY_USER_ID, this.mUserId);
                jSONObject.put("message", jSONObject3);
            } catch (JSONException e) {
                Log.e("BaiduRtcRoomImp", "Caught error on reportRoomEventInfo: " + e);
            }
            this.cxZ.report(jSONObject.toString(), 1);
        }
    }

    private void jE(String str) {
        h(str, this.cxS != null ? this.cxS.getRoomId() : -1L);
    }

    private void l(long j, long j2) {
        if (this.cxS == null) {
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
            jSONObject.put("env", this.cxA);
            jSONObject.put("appId", this.mAppId);
            if (this.cxS != null) {
                jSONObject.put("roomId", this.cxS.getRoomId());
            }
            jSONObject.put("timestamp", System.currentTimeMillis());
            jSONObject.put(TbEnum.SystemMessage.KEY_USER_ID, this.mUserId);
            jSONObject.put("message", jSONObject3);
        } catch (JSONException e) {
            Log.e("BaiduRtcRoomImp", "Caught error on reportDeviceInfo: " + e);
        }
        this.cxZ.report(jSONObject.toString(), 3);
    }

    private void o(Map<String, Integer> map) {
        long intValue = map.get("packetloss_s") != null ? map.get("packetloss_s").intValue() : 0L;
        long intValue2 = map.get("packetlost") != null ? map.get("packetlost").intValue() : 0L;
        long intValue3 = map.get("packesend") != null ? map.get("packesend").intValue() : 0L;
        if (this.cwV != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("packetsLost", intValue2);
                jSONObject.put("packetsSent", intValue3);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.cwV.onRoomEventUpdate(201, intValue, jSONObject.toString());
        }
    }

    private void p(final BigInteger bigInteger) {
        if (this.cxn) {
            return;
        }
        this.cxn = true;
        this.mHandler.post(new Runnable() { // from class: com.baidu.rtc.a.a.11
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.cxx.HasVideo) {
                    a.this.cud = a.this.aeU();
                }
                if (a.this.cxW == null) {
                    Log.e("BaiduRtcRoomImp", "peerConnectionClient is null!");
                    return;
                }
                if (a.this.cxh) {
                    a.this.cxW.a(a.this.cxY.getEglBaseContext(), a.this.cxR, a.this.cud, bigInteger);
                } else {
                    a.this.cxW.a(a.this.cxY.getEglBaseContext(), a.this.cxt, a.this.cud, bigInteger);
                }
                a.this.cxN = System.currentTimeMillis();
                a.this.cxW.i(bigInteger);
            }
        });
    }

    static /* synthetic */ int u(a aVar) {
        int i = aVar.cwO + 1;
        aVar.cwO = i;
        return i;
    }

    static /* synthetic */ int v(a aVar) {
        int i = aVar.cwO;
        aVar.cwO = i + 1;
        return i;
    }

    public static String version() {
        return "1.2.15";
    }

    @Override // com.baidu.rtc.c
    public void a(BaiduRtcRoom.RtcLiveTransferMode rtcLiveTransferMode, String str) {
        if (this.cwV == null) {
            return;
        }
        this.cwV.onRoomEventUpdate(117, rtcLiveTransferMode.ordinal(), str);
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
                    this.cxx = rtcParameterSettings;
                    cwN = this.cxx.AudioContentType;
                    return;
                }
                return;
            case RTC_VIDEO_PARAM_SETTINGS_BITRATE:
                this.cxx.VideoMaxkbps = rtcParameterSettings.VideoMaxkbps;
                if (this.cxW == null || this.mHandler == null) {
                    return;
                }
                this.mHandler.post(new Runnable() { // from class: com.baidu.rtc.a.a.10
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.cxW == null || a.this.cxx.VideoMaxkbps <= 0) {
                            return;
                        }
                        Log.d("BaiduRtcRoomImp", "Set video maximum bitrate: " + a.this.cxx.VideoMaxkbps);
                        a.this.cxW.d(Integer.valueOf(a.this.cxx.VideoMaxkbps));
                    }
                });
                return;
            case RTC_VIDEO_PARAM_SETTINGS_RENDER_MODE:
                this.cxx.cvG = rtcParameterSettings.cvG;
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void a(g.d dVar) {
        this.cxH = dVar;
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void a(i iVar) {
        this.cud = iVar;
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void a(final Boolean bool, final Boolean bool2, final BigInteger bigInteger) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.rtc.a.a.7
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.cxS == null) {
                    return;
                }
                BigInteger k = a.this.cxS.k(bigInteger);
                String m = a.this.cxS.m(k);
                c cVar = (c) a.this.cxF.get(k);
                if (cVar == null) {
                    cVar = new c(bigInteger, k.longValue(), bool, bool2, m);
                    a.this.cxF.put(k, cVar);
                } else {
                    cVar.cym = bool;
                    cVar.cyl = bool2;
                    cVar.cte = bigInteger;
                    cVar.nickName = m;
                }
                if (!bool2.booleanValue() || a.this.cxW == null) {
                    return;
                }
                a.this.cxW.a(true, 200, cVar.cte, PeerConnectionClient.StatsEventsType.GET_AUDIOLEVEL_EVENT);
            }
        });
    }

    @Override // com.baidu.rtc.c
    public void a(BigInteger bigInteger, int i, boolean z) {
        if (this.cwV == null) {
            return;
        }
        this.cwV.onPeerConnectStateUpdate(z ? 2001 : 2002);
    }

    @Override // com.baidu.rtc.c
    public void a(BigInteger bigInteger, long j) {
        this.cxl = false;
        if (this.cxj) {
            h("ENTER_BEGIN", j);
        }
    }

    @Override // com.baidu.rtc.c
    public void a(BigInteger bigInteger, String str) {
        if (this.cwV == null) {
            return;
        }
        this.cwV.onRoomEventUpdate(303, bigInteger.longValue(), str);
    }

    @Override // com.baidu.rtc.c
    public void a(BigInteger bigInteger, String str, String str2) {
        if (this.cwV == null) {
            return;
        }
        this.cwV.onRoomEventUpdate(300, bigInteger.longValue(), str);
    }

    @Override // com.baidu.rtc.c
    public void a(BigInteger bigInteger, final BigInteger bigInteger2) {
        int i;
        Log.i("BaiduRtcRoomImp", "==================onLeaving=======================");
        final com.baidu.rtc.b l = this.cxS.l(bigInteger2);
        this.mHandler.post(new Runnable() { // from class: com.baidu.rtc.a.a.4
            @Override // java.lang.Runnable
            public void run() {
                a.this.cxF.remove(bigInteger2);
                if (l != null) {
                    BigInteger bigInteger3 = l.cte;
                    if (a.this.cxa.get(bigInteger3) != null) {
                        a.this.cxa.remove(bigInteger3);
                        if (a.this.cxW != null) {
                            a.this.cxW.a(false, 0, bigInteger3, PeerConnectionClient.StatsEventsType.GET_QUALITY_MONITOR_EVENT);
                            a.this.cxW.a(false, 0, bigInteger3, PeerConnectionClient.StatsEventsType.GET_SLI_EVENT);
                        }
                    }
                }
            }
        });
        com.baidu.rtc.a j = this.cxW.j(bigInteger);
        if (this.cxx.cvG == RtcParameterSettings.RtcVideoRenderMode.RTC_VIDEO_RENDER_MODE_EXTERNAL) {
            j jVar = this.cxO.get(Long.valueOf(bigInteger2.longValue()));
            if (jVar == null || j == null) {
                Log.d("BaiduRtcRoomImp", "No external render has found!");
            } else {
                Log.d("BaiduRtcRoomImp", "remove external video sink of user " + bigInteger2);
                jVar.aeO();
                jVar.clearImage();
                if (j.cti != null) {
                    j.cti.removeSink(jVar);
                }
                bS(bigInteger2.longValue());
                if (this.cwV != null) {
                    if (this.cxp == bigInteger2.longValue()) {
                        return;
                    }
                    this.cwV.onRoomEventUpdate(107, bigInteger2.longValue(), "gone");
                    this.cxp = bigInteger2.longValue();
                    return;
                }
            }
        }
        if (j != null && (i = j.ctj) >= 0 && i < this.cxb.length) {
            this.cxb[i] = false;
            this.cxG--;
            if (this.cxC[i] != null) {
                this.cxC[i].clearImage();
                if (j.cti != null) {
                    j.cti.removeSink(this.cxC[i]);
                }
                if (this.cwV != null) {
                    if (this.cxp != bigInteger2.longValue()) {
                        this.cwV.onRoomEventUpdate(107, bigInteger2.longValue(), "gone");
                        this.cxp = bigInteger2.longValue();
                        return;
                    }
                    return;
                }
            }
        }
        if (this.cwV != null) {
            if (this.cxq == bigInteger2.longValue()) {
                return;
            }
            this.cwZ.remove(bigInteger2);
            this.cwV.onRoomEventUpdate(105, bigInteger2.longValue(), "leaving");
        }
        this.cxq = bigInteger2.longValue();
        jD("REMOTE_LEAVING_" + bigInteger2 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + bigInteger);
    }

    @Override // com.baidu.rtc.c
    public void a(BigInteger bigInteger, JSONObject jSONObject) {
        SessionDescription.Type fromCanonicalForm = SessionDescription.Type.fromCanonicalForm(jSONObject.optString("type"));
        String optString = jSONObject.optString("sdp");
        if (this.cxx.cvy && this.cwT && optString.contains("profile-level-id=42e01f")) {
            optString = optString.replace("profile-level-id=42e01f", "profile-level-id=640c1f");
            Log.e("BaiduRtcRoomImp", "enable high profile, remote jsep changed: " + optString);
        }
        this.cxW.a(bigInteger, new SessionDescription(fromCanonicalForm, optString));
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void a(IceCandidate iceCandidate, BigInteger bigInteger) {
        Log.e("BaiduRtcRoomImp", "=========onIceCandidate========");
        if (iceCandidate != null) {
            this.cxS.a(bigInteger, iceCandidate);
        } else {
            this.cxS.n(bigInteger);
        }
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void a(SessionDescription sessionDescription, BigInteger bigInteger) {
        Log.e("BaiduRtcRoomImp", sessionDescription.type.toString());
        this.cxS.d(bigInteger, sessionDescription);
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void a(SessionDescription sessionDescription, BigInteger bigInteger, boolean z) {
        Log.e("BaiduRtcRoomImp", sessionDescription.type.toString());
        if (this.cxS == null) {
            return;
        }
        this.cwT = z;
        this.cxS.c(bigInteger, sessionDescription);
        this.mHandler.post(new Runnable() { // from class: com.baidu.rtc.a.a.5
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.cxW == null || a.this.ctT.cuW <= 0) {
                    return;
                }
                Log.d("BaiduRtcRoomImp", "Set video maximum bitrate: " + a.this.ctT.cuW);
                a.this.cxW.d(Integer.valueOf(a.this.ctT.cuW));
            }
        });
    }

    public void a(StatsReport[] statsReportArr) {
        StatsReport.Value[] valueArr;
        if (this.cwV == null) {
            return;
        }
        for (StatsReport statsReport : statsReportArr) {
            if (statsReport.id.equals("bweforvideo")) {
                for (StatsReport.Value value : statsReport.values) {
                    if (value.name.equals("googAvailableSendBandwidth")) {
                        this.cxV = Double.parseDouble(value.value);
                        if (this.cxV > 100.0d) {
                            this.cwV.onRoomEventUpdate(200, (long) this.cxV, statsReport.toString());
                        }
                    }
                }
                return;
            }
        }
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void a(final StatsReport[] statsReportArr, final BigInteger bigInteger, final PeerConnectionClient.StatsEventsType statsEventsType) {
        if (bigInteger == this.cxz && statsEventsType == PeerConnectionClient.StatsEventsType.GET_BWE_EVENT && this.cxT) {
            a(statsReportArr);
        }
        this.mHandler.post(new Runnable() { // from class: com.baidu.rtc.a.a.6
            @Override // java.lang.Runnable
            public void run() {
                if (statsEventsType == PeerConnectionClient.StatsEventsType.GET_AUDIOLEVEL_EVENT) {
                    a.this.a(statsReportArr, bigInteger);
                }
                com.baidu.rtc.b.b bVar = (com.baidu.rtc.b.b) a.this.cxa.get(bigInteger);
                if (bVar != null) {
                    bVar.b(statsReportArr);
                }
                if ((a.this.cxj || a.this.cxi) && statsEventsType == PeerConnectionClient.StatsEventsType.GET_QUALITY_MONITOR_EVENT && bigInteger == a.this.cxz && a.this.cxZ != null) {
                    a.this.aeX();
                }
                if ((a.this.cxj || a.this.cxi) && statsEventsType == PeerConnectionClient.StatsEventsType.GET_SLI_EVENT && bigInteger == a.this.cxz && a.this.cxZ != null) {
                    a.this.aeZ();
                }
            }
        });
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public boolean a(BaiduRtcRoom.RtcLiveTransferMode rtcLiveTransferMode) {
        this.cxS.c(rtcLiveTransferMode);
        return true;
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public boolean a(BaiduRtcRoom.a aVar) {
        this.cwV = aVar;
        return true;
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public boolean a(String str, boolean z, boolean z2, String str2, BaiduRtcRoom.RtcLiveTransferMode rtcLiveTransferMode) {
        if (this.cxs.isEmpty() || this.cxr == rtcLiveTransferMode) {
            this.cxs = str;
            this.cxr = rtcLiveTransferMode;
            this.cxS.eD(z2);
            this.cxS.jx(str);
            this.cxS.eC(z);
            this.cxS.jw(str2);
            this.cxS.b(rtcLiveTransferMode);
        } else {
            this.cxS.c(str, z, z2, str2, rtcLiveTransferMode);
        }
        return true;
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void aZ(boolean z) {
        if (this.cxW != null) {
            this.cxW.setSpeakerMute(z);
        }
    }

    @Override // com.baidu.rtc.c
    public void aeA() {
        if (this.cwV == null) {
            return;
        }
        this.cwV.onRoomEventUpdate(112, 0L, "");
    }

    @Override // com.baidu.rtc.c
    public void aeB() {
        if (this.cwV == null) {
            return;
        }
        this.cwV.onErrorInfoUpdate(402);
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void aeJ() {
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void aeK() {
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void aeL() {
        if (this.cxj && !this.cxl) {
            jE("ENTER_FAILED");
        }
        if (this.cwV != null) {
            this.cwV.onPeerConnectStateUpdate(2003);
        }
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void aeM() {
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public BaiduRtcRoom.c[] aew() {
        int i = 0;
        int i2 = 0;
        for (BigInteger bigInteger : this.cxF.keySet()) {
            c cVar = this.cxF.get(bigInteger);
            if (cVar != null && cVar.cyl.booleanValue() && cVar.volume != -1) {
                i2++;
            }
        }
        BaiduRtcRoom.c[] cVarArr = new BaiduRtcRoom.c[i2];
        for (BigInteger bigInteger2 : this.cxF.keySet()) {
            c cVar2 = this.cxF.get(bigInteger2);
            if (cVar2 != null && cVar2.volume != -1 && cVar2.cyl.booleanValue()) {
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
    public void aex() {
        if (this.cxj && !this.cxl) {
            jE("ENTER_FAILED");
        }
        if (this.cwV == null) {
            return;
        }
        this.cwV.onRoomEventUpdate(103, 0L, "coennection Error");
        jD("CONNECTION_LOST");
    }

    @Override // com.baidu.rtc.c
    public void aey() {
        if (this.cxj && !this.cxl) {
            jE("ENTER_FAILED");
        }
        if (this.cwV == null) {
            return;
        }
        this.cwV.onRoomEventUpdate(102, 0L, BdStatsConstant.StatsType.ERROR);
        jD("LOGIN_ERROR");
    }

    @Override // com.baidu.rtc.c
    public void aez() {
        if (this.cxj && !this.cxl) {
            jE("ENTER_FAILED");
        }
        if (this.cwV == null) {
            return;
        }
        this.cwV.onRoomEventUpdate(101, 0L, "time out");
    }

    @Override // com.baidu.rtc.c
    public void b(BaiduRtcRoom.RtcLiveTransferMode rtcLiveTransferMode, String str) {
        if (this.cwV == null) {
            return;
        }
        this.cwV.onRoomEventUpdate(118, rtcLiveTransferMode.ordinal(), str);
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void b(final com.baidu.rtc.a aVar) {
        int i;
        Log.e("BaiduRtcRoomImp", "=========onRemoteRender========" + aVar.cti);
        final BigInteger k = this.cxS.k(aVar.cte);
        if (k.longValue() == 0) {
            Log.e("BaiduRtcRoomImp", "onRemoteRender Userid is 0.");
        } else if (this.cxx.cvG == RtcParameterSettings.RtcVideoRenderMode.RTC_VIDEO_RENDER_MODE_EXTERNAL) {
            j bT = bT(k.longValue());
            Log.d("BaiduRtcRoomImp", "enable external video render mode with videoRenderer -> " + bT);
            if (bT != null) {
                aVar.cti.addSink(bT);
                bT.setStuckEventListener(new d(aVar.cte));
                bT.setEnableSLIDataReport(this.cxi);
            } else {
                Log.d("BaiduRtcRoomImp", "Not found external render for user " + k);
            }
            a(aVar, k);
            this.cwV.onRoomEventUpdate(106, k.longValue(), "");
        } else {
            Log.d("BaiduRtcRoomImp", "it is internal video render mode");
            try {
                i = this.cwZ.get(this.cxS.k(aVar.cte)).intValue();
            } catch (Exception e) {
                i = -1;
            }
            if (i >= 0 && i < cwL && this.cxC != null) {
                if (this.cxC[i] != null) {
                    this.cxC[i].setFirstFrameEventListener(new Runnable() { // from class: com.baidu.rtc.a.a.8
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.cwV != null) {
                                a.this.cwV.onRoomEventUpdate(106, k.longValue(), "");
                            }
                            a.this.a(aVar, k);
                        }
                    });
                    this.cxC[i].setStuckEventListener(new d(aVar.cte));
                    this.cxC[i].setEnableSLIDataReport(this.cxi);
                    aVar.cti.addSink(this.cxC[i]);
                }
                aVar.ctj = i;
            } else if (this.cxC != null) {
                int i2 = 0;
                while (true) {
                    if (i2 >= this.cxb.length) {
                        i2 = -1;
                        break;
                    } else if (!this.cxb[i2]) {
                        this.cxb[i2] = true;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i2 >= 0) {
                    if (this.cxC[i2] != null) {
                        this.cxC[i2].setFirstFrameEventListener(new Runnable() { // from class: com.baidu.rtc.a.a.9
                            @Override // java.lang.Runnable
                            public void run() {
                                if (a.this.cwV != null) {
                                    a.this.cwV.onRoomEventUpdate(106, k.longValue(), "");
                                }
                                a.this.a(aVar, k);
                            }
                        });
                        this.cxC[i2].setStuckEventListener(new d(aVar.cte));
                        this.cxC[i2].setEnableSLIDataReport(this.cxi);
                        aVar.cti.addSink(this.cxC[i2]);
                    }
                    aVar.ctj = i2;
                }
                this.cxG++;
            }
        }
    }

    @Override // com.baidu.rtc.c
    public void b(BigInteger bigInteger) {
        if (this.cwV == null) {
            return;
        }
        this.cwV.onPeerConnectStateUpdate(2003);
    }

    @Override // com.baidu.rtc.c
    public void b(BigInteger bigInteger, String str) {
        if (this.cxq == bigInteger.longValue()) {
            this.cxq = 0L;
        }
        if (this.cxp == bigInteger.longValue()) {
            this.cxp = 0L;
        }
        if (this.cwV == null) {
            return;
        }
        this.cwV.onRoomEventUpdate(104, bigInteger.longValue(), str);
    }

    @Override // com.baidu.rtc.c
    public void b(final BigInteger bigInteger, JSONObject jSONObject) {
        this.cxW.b(bigInteger, new SessionDescription(SessionDescription.Type.fromCanonicalForm(jSONObject.optString("type")), jSONObject.optString("sdp")));
        this.mHandler.post(new Runnable() { // from class: com.baidu.rtc.a.a.3
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.cxi || bigInteger == a.this.cxz || a.this.cxW == null) {
                    return;
                }
                if (a.this.cxa.get(bigInteger) != null) {
                    a.this.cxW.a(false, 0, bigInteger, PeerConnectionClient.StatsEventsType.GET_QUALITY_MONITOR_EVENT);
                    a.this.cxW.a(false, 0, bigInteger, PeerConnectionClient.StatsEventsType.GET_SLI_EVENT);
                    a.this.cxa.remove(bigInteger);
                }
                a.this.cxW.a(a.this.cxi, 2000, bigInteger, PeerConnectionClient.StatsEventsType.GET_QUALITY_MONITOR_EVENT);
                a.this.cxW.a(a.this.cxi, 5000, bigInteger, PeerConnectionClient.StatsEventsType.GET_SLI_EVENT);
                com.baidu.rtc.b.b bVar = new com.baidu.rtc.b.b();
                a.this.cxa.put(bigInteger, bVar);
                bVar.bV(System.currentTimeMillis());
            }
        });
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public boolean b(String str, boolean z, boolean z2, String str2, BaiduRtcRoom.RtcLiveTransferMode rtcLiveTransferMode) {
        this.cxS.d(str, z, z2, str2, rtcLiveTransferMode);
        return true;
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void bO(long j) {
        if (this.cxS != null) {
            this.cxS.bO(j);
        }
    }

    @Override // com.baidu.rtc.c
    public void bP(long j) {
        if (this.cwV == null) {
            return;
        }
        this.cwV.onRoomEventUpdate(114, j, "");
    }

    public void bP(Context context) {
        Log.d("BaiduRtcRoomImp", "setup so later loading feature, and cpu type: " + this.mCpuType);
        com.baidu.cloudbase.b.a.aa(context).dp(this.mCpuType);
        if (this.cxM.isEmpty()) {
            com.baidu.cloudbase.b.a.aa(context).a(com.baidu.cloudbase.b.b.tZ(), true, this.cxJ);
            return;
        }
        Log.d("BaiduRtcRoomImp", "setup so later load url: " + this.cxM);
        com.baidu.cloudbase.b.a.aa(context).a(this.cxM, true, this.cxJ);
    }

    @Override // com.baidu.rtc.c
    public void bQ(long j) {
        if (this.cwV == null) {
            return;
        }
        this.cwV.onRoomEventUpdate(115, j, "");
    }

    @Override // com.baidu.rtc.c
    public void bR(long j) {
        if (this.cwV == null) {
            return;
        }
        this.cwV.onRoomEventUpdate(113, j, "");
    }

    public j bT(long j) {
        j kVar;
        synchronized (this) {
            Log.d("BaiduRtcRoomImp", j + " : Get external renderer.");
            if (this.cxO.containsKey(Long.valueOf(j))) {
                kVar = this.cxO.get(Long.valueOf(j));
            } else {
                kVar = new k(this.cwV, j);
                Log.d("BaiduRtcRoomImp", j + " : Create external renderer" + kVar);
                this.cxO.put(Long.valueOf(j), kVar);
            }
        }
        return kVar;
    }

    @Override // com.baidu.rtc.c
    public void c(BaiduRtcRoom.RtcLiveTransferMode rtcLiveTransferMode, String str) {
        if (this.cwV == null) {
            return;
        }
        this.cwV.onRoomEventUpdate(116, rtcLiveTransferMode.ordinal(), str);
    }

    @Override // com.baidu.rtc.c
    public void c(final BigInteger bigInteger) {
        if (this.cwV != null) {
            this.cwV.onRoomEventUpdate(100, 0L, "ok");
        }
        this.cxz = bigInteger;
        if (this.cxx.AutoPublish) {
            p(bigInteger);
        }
        if (this.cxT && this.cxW != null) {
            this.cxW.a(this.cxT, 5000, this.cxz, PeerConnectionClient.StatsEventsType.GET_BWE_EVENT);
        }
        this.mHandler.post(new Runnable() { // from class: com.baidu.rtc.a.a.2
            @Override // java.lang.Runnable
            public void run() {
                if ((a.this.cxj || a.this.cxi) && a.this.cxW != null) {
                    if (a.this.cxa.get(bigInteger) != null) {
                        a.this.cxW.a(false, 0, bigInteger, PeerConnectionClient.StatsEventsType.GET_QUALITY_MONITOR_EVENT);
                        a.this.cxW.a(false, 0, bigInteger, PeerConnectionClient.StatsEventsType.GET_SLI_EVENT);
                        a.this.cxa.remove(bigInteger);
                    }
                    a.this.cxW.a(a.this.cxj || a.this.cxi, 2000, bigInteger, PeerConnectionClient.StatsEventsType.GET_QUALITY_MONITOR_EVENT);
                    a.this.cxW.a(a.this.cxj || a.this.cxi, 5000, bigInteger, PeerConnectionClient.StatsEventsType.GET_SLI_EVENT);
                    a.this.cxa.put(bigInteger, new com.baidu.rtc.b.b());
                    if (a.this.cxZ != null && !a.this.cxU) {
                        a.this.cxU = true;
                        a.this.mHandler.post(a.this.cxX);
                    }
                    a aVar = a.this;
                    aVar.jD("RTCROOM_LOGIN_OK_" + a.this.mUserId);
                }
                c cVar = (c) a.this.cxF.get(BigInteger.valueOf(a.this.mUserId));
                if (cVar != null) {
                    if (a.this.cxW != null) {
                        a.this.cxW.a(false, 0, cVar.cte, PeerConnectionClient.StatsEventsType.GET_AUDIOLEVEL_EVENT);
                    }
                    cVar.cym = Boolean.valueOf(a.this.cxx.HasVideo);
                    cVar.cyl = Boolean.valueOf(a.this.cxx.HasAudio);
                    cVar.cte = bigInteger;
                    cVar.nickName = a.this.mDisplayName;
                } else {
                    a.this.cxF.put(BigInteger.valueOf(a.this.mUserId), new c(bigInteger, a.this.mUserId, Boolean.valueOf(a.this.cxx.HasVideo), Boolean.valueOf(a.this.cxx.HasAudio), a.this.mDisplayName));
                }
                if (a.this.cxW != null) {
                    a.this.cxW.a(true, 200, bigInteger, PeerConnectionClient.StatsEventsType.GET_AUDIOLEVEL_EVENT);
                }
            }
        });
    }

    @Override // com.baidu.rtc.c
    public void c(BigInteger bigInteger, String str) {
        if (this.cwV == null) {
            return;
        }
        this.cwV.onRoomEventUpdate(302, bigInteger.longValue(), str);
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void changeSurfaceSize(long j, int i, int i2) {
        if (this.cxO.containsKey(Long.valueOf(j))) {
            j jVar = this.cxO.get(Long.valueOf(j));
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
        if (this.cxS != null) {
            this.cxS.d(j, z);
        }
    }

    @Override // com.baidu.rtc.c
    public void d(BigInteger bigInteger) {
        if (this.cxW != null) {
            this.cxW.h(bigInteger);
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void destroyExternalSurface(long j, Surface surface) {
        j jVar;
        if (this.cxO.containsKey(Long.valueOf(j)) && (jVar = this.cxO.get(Long.valueOf(j))) != null && surface == jVar.getSurface()) {
            jVar.releaseSurface();
        }
        aeW();
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void disbandRoom() {
        if (this.cxS != null) {
            this.cxS.disbandRoom();
        }
    }

    public void doDestroy() {
        logoutRtcRoom();
        cwM.remove(toString());
    }

    @Override // com.baidu.rtc.c
    public void e(BigInteger bigInteger) {
        if (this.cwV == null) {
            return;
        }
        this.cwV.onRoomEventUpdate(301, bigInteger.longValue(), "");
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void enableAgc(boolean z) {
        this.cwP = Boolean.valueOf(z);
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void enableAns(boolean z) {
        this.cwQ = Boolean.valueOf(z);
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void enableExternalVideoCapturer(boolean z) {
        this.cxh = z;
        this.cxR = new VideoSink() { // from class: com.baidu.rtc.a.a.12
            @Override // org.webrtc.VideoSink
            public void onFrame(VideoFrame videoFrame) {
            }
        };
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void enableStatsToServer(boolean z, String str) {
        f(z, z, str);
    }

    @Override // com.baidu.rtc.c
    public void f(BigInteger bigInteger) {
        if (this.cxj && bigInteger == this.cxz) {
            this.cxl = true;
            this.cxu = System.currentTimeMillis();
            if (this.cxu - this.cxN > 5000) {
                jE("ENTER_TIMEOUT");
            }
        }
        if (this.cwV == null) {
            return;
        }
        this.cwV.onPeerConnectStateUpdate(2000);
        jD("WEBRTC_UP_" + bigInteger.longValue());
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void f(boolean z, boolean z2, String str) {
        this.cxj = z;
        this.cxi = z2;
        this.cxA = str;
        if (!z && !z2) {
            if (this.cwX != null) {
                this.cwX.pause();
                return;
            }
            return;
        }
        if (this.cwX == null) {
            this.cwX = new com.baidu.rtc.b.a(this.cxK);
        }
        if (this.cxZ == null) {
            this.cxZ = com.baidu.rtc.b.d.afs();
        }
    }

    @Override // com.baidu.rtc.c
    public void fS(int i) {
        if (this.cwV != null && i == 436) {
            this.cwV.onErrorInfoUpdate(RTCConst.RTC_ROOM_USERID_ALREADY_EXIST_ERROR);
        }
    }

    @Override // com.baidu.rtc.c
    public void g(boolean z, int i) {
        if (this.cwV == null) {
            return;
        }
        this.cwV.onPeerConnectStateUpdate(i < 10 ? 2100 : i < 15 ? RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL1 : i < 25 ? RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL2 : i < 40 ? RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL3 : i < 60 ? RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL4 : i < 90 ? RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL5 : i < 120 ? RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL6 : i < 180 ? RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL7 : i < 250 ? RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL8 : RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL9);
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public boolean ju(String str) {
        this.cxS.jz(str);
        return true;
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void jv(String str) {
        if (this.cxj && !this.cxl) {
            jE("ENTER_FAILED");
        }
        if (this.cwV != null) {
            this.cwV.onErrorInfoUpdate(10000);
        }
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void l(ByteBuffer byteBuffer) {
        if (this.cwV == null) {
            return;
        }
        this.cwV.onRoomDataMessage(byteBuffer);
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public boolean loginRtcRoomWithRoomName(String str, long j, String str2, boolean z) {
        Log.i("BaiduRtcRoomImp", "enable force login");
        this.cxf = z;
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
        this.cxe = z;
        this.cxd = z2;
        if (this.cxk) {
            try {
                System.loadLibrary("jingle_peerconnection_so");
            } catch (UnsatisfiedLinkError e) {
                z3 = false;
            }
        }
        z3 = true;
        if (!z3 && this.cxk && !this.cxm) {
            this.cxL = new Thread(new Runnable() { // from class: com.baidu.rtc.a.a.15
                @Override // java.lang.Runnable
                public void run() {
                    Log.d("BaiduRtcRoomImp", "setup downloading thread ......");
                    a.this.bP(a.this.cxK);
                }
            });
            this.cxL.start();
            return true;
        } else if (j == 0) {
            throw new InvalidParameterException("loginRtcRoomWithRoomName: Param Error,userId cann't be zero. zero is reserved.");
        } else {
            this.cxS.jA(str);
            this.cxS.setUserId(j);
            if (str2 != null && !str2.isEmpty()) {
                this.cxS.setDisplayName(str2);
            }
            this.cxS.setVideoCodec(this.cxx.VideoCodec);
            this.cxS.ez(z);
            this.cxS.ey(z2);
            int i5 = this.cxx.VideoWidth;
            int i6 = this.cxx.VideoHeight;
            String lowerCase = this.cxx.VideoResolution.toLowerCase();
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
                this.cxx.cvv = true;
                this.cwQ = true;
            }
            if (Build.HARDWARE.contains("mt6768")) {
                this.cxx.cvB = true;
                this.cxx.cvA = false;
            }
            if (Build.MODEL.contains("Mi Note 2") || Build.MODEL.contains("V1809")) {
                this.cxx.cvC = 1;
            }
            this.ctT = new PeerConnectionClient.c(false, i, i6, this.cxx.VideoFps, this.cxx.VideoCodec.toUpperCase(), true, 0, "opus", false, false, this.cxx.cvv, this.cwP.booleanValue(), this.cwQ.booleanValue(), this.cxx.VideoMaxkbps, this.cxx.VideoMinkbps, this.cxx.cvE, this.cxx.cvu, true, this.cxx.cvx, this.cxx.cvB, this.cxx.cvy, this.cxx.cvr, this.cxx.cux, this.cxx.cvF, this.cxx.cvC, this.cxx.cvz, this.cxx.cvA, this.cxx.cvt, this.cxx.cvp, this.cxx.cvs, this.cxx.cvq);
            this.cxW = PeerConnectionClient.aeF();
            if (this.cwY) {
                if (this.cwU == null) {
                    this.cwU = new com.baidu.cloudbase.a.a();
                }
                this.cwU.aQ(false);
                if (this.cxB < 0) {
                    this.cxB = this.cwU.tS();
                }
                this.cwU.tT();
                this.cwU.aP(false);
                this.cwU.aO(false);
                this.cwU.a(this.cxw);
            }
            if (this.cxH != null || this.cwY) {
                this.cxW.a(this.cxI);
            }
            if (this.cxD != null || this.cwY) {
                this.cxW.a(this.cxE);
            }
            if (this.cxx != null) {
                this.cxS.et(this.cxx.HasAudio);
                this.cxW.et(this.cxx.HasAudio);
                this.cxS.ev(this.cxx.HasVideo);
                this.cxW.ev(this.cxx.HasVideo);
                this.cxS.eu(this.cxx.HasData);
                this.cxW.eu(this.cxx.HasData);
                this.cxW.fT(this.cxx.AudioFrequency);
                this.cxW.setAudioChannel(this.cxx.AudioChannel);
                this.cxS.fU(this.cxx.ConnectionTimeoutMs);
                this.cxS.fV(this.cxx.ReadTimeoutMs);
                this.cxS.eA(this.cxx.AutoPublish);
                this.cxS.eB(this.cxx.AutoSubScribe);
                this.cxS.jy(this.cxx.cvD);
            }
            this.cxW.es(this.cxg);
            this.cxW.er(ctP);
            this.cxW.a(this.mContext.get(), this.ctT, this);
            this.cxW.setStuckEventListener(new C0313a());
            this.cxW.setEnableSLIReport(this.cxi);
            this.cxS.K(this.cxo, this.cxf);
            Log.i("BRTC", "loginRtcRoomWithRoomName: this " + this + " version: " + version());
            return true;
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public boolean logoutRtcRoom() {
        if (this.cxW != null) {
            this.cxW.eq(false);
            this.cxW.ew(false);
            this.cxW.aeI();
            this.cxS.yo();
            this.cxS.finalize();
            this.cxW.close();
            if (this.cwX != null) {
                this.cwX.pause();
            }
            this.cxa.clear();
            this.cxW = null;
            this.cxS = null;
            if (this.cwU != null) {
                this.cwU.a(null);
                this.cwU.release();
            }
            if (this.cxt != null) {
                this.cxt.release();
                this.cxt = null;
            }
            if (this.cxC != null) {
                for (int i = 0; i < this.cxC.length; i++) {
                    if (this.cxC[i] != null) {
                        this.cxC[i].release();
                        this.cxC[i] = null;
                    }
                }
            }
            aeV();
            aeW();
            if (this.cxY != null) {
                this.cxY.release();
            }
            if (this.audioManager != null && this.audioManager.isBluetoothScoOn()) {
                d((Boolean) false);
            }
            if (this.cxc != null) {
                this.mContext.get().unregisterReceiver(this.cxc);
                this.cxc = null;
            }
            System.gc();
        }
        return true;
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void muteMicphone(boolean z) {
        if (this.cxW != null) {
            this.cxW.eq(!z);
        }
        jD("MUTE_MICPHONE");
    }

    @Override // com.baidu.rtc.PeerConnectionClient.b
    public void onIceCandidatesRemoved(IceCandidate[] iceCandidateArr) {
    }

    public void presetLoudSpeaker(boolean z) {
        ((AudioManager) this.mContext.get().getSystemService("audio")).setSpeakerphoneOn(z);
        jD("PRESETLOUDSPEAKER");
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void publishStreaming() {
        p(this.cxz);
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void sendMessageToUser(String str, long j) {
        if (this.cxS == null) {
            return;
        }
        this.cxS.sendMessageToUser(str, j);
        try {
            Thread.sleep(10L);
        } catch (InterruptedException e) {
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void setExternalSurface(long j, Surface surface) {
        j bT = bT(j);
        if (bT != null) {
            if (!bT.aeN()) {
                bT.init();
                bT.ex(true);
            }
            for (Long l : this.cxO.keySet()) {
                j jVar = this.cxO.get(l);
                if (jVar != null && jVar.hasSurface() && surface == jVar.getSurface() && this.cwV != null) {
                    Log.d("BaiduRtcRoomImp", "Set surface repeat with userId " + j);
                    this.cwV.onErrorInfoUpdate(600);
                    return;
                }
            }
            bT.setSurface(surface);
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void setUserAttribute(String str) {
        if (this.cxS == null) {
            return;
        }
        this.cxS.setUserAttribute(str);
        try {
            Thread.sleep(10L);
        } catch (InterruptedException e) {
        }
    }

    @Override // com.baidu.rtc.BaiduRtcRoom
    public void stopPublish() {
        if (this.cxS == null) {
            return;
        }
        this.cxS.o(this.cxz);
        if (this.cxW != null) {
            this.cxW.aeH();
            this.cxW.aeI();
            this.cxW.h(this.cxz);
            if (this.cxt != null) {
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.rtc.a.a.20
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.cxt.clearImage();
                    }
                }, 100L);
            }
            if (this.cud != null) {
                this.cud.dispose();
                this.cud = null;
                cwM.remove(toString());
            }
        }
        this.cxn = false;
    }
}
