package com.baidu.rtc;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.ala.recorder.video.AlaRecorderLog;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.mobstat.Config;
import com.baidu.rtc.BaiduRtcRoom;
import com.baidu.sapi2.views.SmsLoginView;
import com.kwai.video.player.misc.KsMediaFormat;
import com.xiaomi.mipush.sdk.Constants;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLException;
import okhttp3.ConnectionPool;
import okhttp3.Dns;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.webrtc.IceCandidate;
import org.webrtc.SessionDescription;
/* loaded from: classes9.dex */
public class p {
    static OkHttpClient.Builder ctL = new OkHttpClient.Builder().connectionPool(new ConnectionPool(5, 1, TimeUnit.MINUTES)).addInterceptor(new Interceptor() { // from class: com.baidu.rtc.p.1
        @Override // okhttp3.Interceptor
        public Response intercept(Interceptor.Chain chain) throws IOException {
            Request.Builder newBuilder = chain.request().newBuilder();
            newBuilder.addHeader("Sec-WebSocket-Protocol", "janus-protocol");
            try {
                return chain.proceed(newBuilder.build());
            } catch (Exception e) {
                throw new IOException("BRTC Connection error");
            }
        }
    });
    static int ctM = 25000;
    private c ctN;
    private BigInteger cuk;
    private WebSocket cuo;
    private ConcurrentHashMap<String, d> cup = new ConcurrentHashMap<>();
    private ConcurrentHashMap<BigInteger, b> ctQ = new ConcurrentHashMap<>();
    private ConcurrentHashMap<BigInteger, b> ctO = new ConcurrentHashMap<>();
    private long mUserId = (Build.SERIAL.hashCode() % 100000) + 78657895;
    private String mDisplayName = "Android-rtc";
    private String mRoomName = "";
    private String mVideoCodec = KsMediaFormat.CODEC_NAME_H264;
    private boolean ctS = true;
    private boolean ctR = true;
    private boolean mHasVideo = true;
    private boolean mHasAudio = true;
    private boolean crV = false;
    private long mRoomId = -1160725808;
    private String mAppId = "";
    private String cul = "";
    private String cud = "";
    private String cuc = "";
    private String ctY = "";
    private String cuh = "";
    private String cuj = "";
    private BaiduRtcRoom.RtcLiveTransferMode cuf = BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ANCHOR_TRASNSMISSION;
    private boolean ctW = false;
    private boolean cua = false;
    private String cue = "";
    private String ctZ = "";
    private BaiduRtcRoom.RtcLiveTransferMode cug = BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ANCHOR_TRASNSMISSION;
    private boolean ctX = false;
    private boolean cub = false;
    private int ctV = 5000;
    private int cui = 5000;
    public boolean ctT = true;
    public boolean ctU = true;
    volatile BaiduRtcRoom.e cun = null;
    private ConcurrentHashMap<BigInteger, BaiduRtcRoom.d> cum = new ConcurrentHashMap<>();
    private Runnable ctP = new Runnable() { // from class: com.baidu.rtc.p.18
        @Override // java.lang.Runnable
        public void run() {
            p.this.aey();
            p.this.mHandler.postDelayed(p.this.ctP, p.ctM);
        }
    };
    private Handler mHandler = new Handler(Looper.getMainLooper());

    private void aF(JSONObject jSONObject) {
        if (this.cuo != null) {
            this.cuo.send(jSONObject.toString());
        }
        if (com.baidu.rtc.a.a.crX) {
            Log.i("WebSocketChannel", jSONObject.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aey() {
        String e = e((Integer) 12);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("janus", "keepalive");
            jSONObject.putOpt("session_id", this.cuk);
            jSONObject.putOpt("transaction", e);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        aF(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aez() {
        String e = e((Integer) 12);
        d dVar = new d();
        dVar.tid = e;
        dVar.crC = new o() { // from class: com.baidu.rtc.p.22
            @Override // com.baidu.rtc.o
            public void aE(JSONObject jSONObject) {
                b bVar = new b();
                bVar.crq = new BigInteger(jSONObject.optJSONObject("data").optString("id"));
                bVar.cry = new e() { // from class: com.baidu.rtc.p.22.1
                    @Override // com.baidu.rtc.e
                    public void a(b bVar2) {
                        p.this.ctN.c(bVar2.crq);
                    }
                };
                bVar.crA = new f() { // from class: com.baidu.rtc.p.22.2
                    @Override // com.baidu.rtc.f
                    public void a(b bVar2, JSONObject jSONObject2) {
                        p.this.ctN.a(bVar2.crq, jSONObject2);
                    }
                };
                p.this.ctQ.put(bVar.crq, bVar);
                if (p.this.mRoomId == -1160725808) {
                    p.this.e(bVar);
                } else {
                    p.this.a(p.this.mRoomId, p.this.mRoomName, bVar);
                }
            }
        };
        dVar.crB = new n() { // from class: com.baidu.rtc.p.23
            @Override // com.baidu.rtc.n
            public void aD(JSONObject jSONObject) {
            }
        };
        this.cup.put(e, dVar);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("janus", "attach");
            jSONObject.putOpt("plugin", "janus.plugin.videoroom");
            jSONObject.putOpt("transaction", e);
            jSONObject.putOpt("session_id", this.cuk);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        aF(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(b bVar) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.putOpt("request", UbcStatConstant.ContentType.UBC_TYPE_IM_LEAVE);
            jSONObject2.putOpt("janus", "message");
            jSONObject2.putOpt("body", jSONObject);
            jSONObject2.putOpt("transaction", e((Integer) 12));
            jSONObject2.putOpt("session_id", this.cuk);
            jSONObject2.putOpt("handle_id", bVar.crq);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        aF(jSONObject2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(b bVar) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        JSONObject jSONObject4 = new JSONObject();
        try {
            jSONObject2.putOpt("request", UbcStatConstant.ContentType.UBC_TYPE_IM_JOIN);
            jSONObject2.putOpt(UbcStatConstant.KEY_CONTENT_ROOM, Long.valueOf(this.mRoomId));
            jSONObject2.putOpt("ptype", "publisher");
            jSONObject2.putOpt("display", this.mDisplayName);
            jSONObject2.putOpt("id", Long.valueOf(this.mUserId));
            jSONObject2.putOpt("app_id", this.mAppId);
            jSONObject2.putOpt(DpStatConstants.KEY_ROOM_NAME, this.mRoomName);
            jSONObject2.putOpt("role", "publisher");
            jSONObject2.putOpt("token", "no_token");
            if (!this.cuh.isEmpty()) {
                jSONObject2.putOpt("window_id_in_bypass", this.cuh);
            }
            if (!this.cud.isEmpty() && this.cuf == BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ANCHOR_TRASNSMISSION) {
                jSONObject3.putOpt("url", this.cud);
                if (!this.ctY.isEmpty()) {
                    jSONObject3.putOpt("mixTemplate", this.ctY);
                }
                jSONObject3.putOpt("mix", Boolean.valueOf(this.ctW));
                jSONObject2.putOpt(AlaRecorderLog.Protocol.RTMP, jSONObject3);
            } else if (!this.cue.isEmpty() && this.cug == BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ANCHOR_TRASNSMISSION) {
                jSONObject3.putOpt("url", this.cue);
                if (!this.ctZ.isEmpty()) {
                    jSONObject3.putOpt("mixTemplate", this.ctZ);
                }
                jSONObject3.putOpt("mix", Boolean.valueOf(this.ctX));
                jSONObject2.putOpt(AlaRecorderLog.Protocol.RTMP, jSONObject3);
            }
            if (this.cua) {
                jSONObject4.putOpt("rec", Boolean.valueOf(this.cua));
                jSONObject2.putOpt("recording", jSONObject4);
            }
            jSONObject.putOpt("janus", "message");
            jSONObject.putOpt("body", jSONObject2);
            jSONObject.putOpt("transaction", e((Integer) 12));
            jSONObject.putOpt("session_id", this.cuk);
            jSONObject.putOpt("handle_id", bVar.crq);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        aF(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createSession() {
        String e = e((Integer) 12);
        d dVar = new d();
        dVar.tid = e;
        dVar.crC = new o() { // from class: com.baidu.rtc.p.20
            @Override // com.baidu.rtc.o
            public void aE(JSONObject jSONObject) {
                p.this.cuk = new BigInteger(jSONObject.optJSONObject("data").optString("id"));
                p.this.mHandler.postDelayed(p.this.ctP, p.ctM);
                p.this.aez();
            }
        };
        dVar.crB = new n() { // from class: com.baidu.rtc.p.21
            @Override // com.baidu.rtc.n
            public void aD(JSONObject jSONObject) {
            }
        };
        this.cup.put(e, dVar);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("janus", "create");
            jSONObject.putOpt("transaction", e);
            if (!this.cuj.isEmpty()) {
                jSONObject.putOpt("sdktag", this.cuj);
            }
            jSONObject.putOpt("sessionevent", true);
            jSONObject.putOpt("userevent", true);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        aF(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(b bVar) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt("request", UbcStatConstant.ContentType.UBC_TYPE_IM_JOIN);
            jSONObject2.putOpt(UbcStatConstant.KEY_CONTENT_ROOM, Long.valueOf(this.mRoomId));
            jSONObject2.putOpt("ptype", "listener");
            jSONObject2.putOpt(LogConfig.KEY_FEED, bVar.crx);
            jSONObject2.putOpt("id", Long.valueOf(this.mUserId));
            jSONObject2.putOpt("app_id", this.mAppId);
            jSONObject2.putOpt(DpStatConstants.KEY_ROOM_NAME, this.mRoomName);
            jSONObject2.putOpt("token", this.cul);
            jSONObject2.putOpt("role", "listener");
            if (!this.cuh.isEmpty()) {
                jSONObject2.putOpt("window_id_in_bypass", this.cuh);
            }
            jSONObject.putOpt("janus", "message");
            jSONObject.putOpt("body", jSONObject2);
            jSONObject.putOpt("transaction", e((Integer) 12));
            jSONObject.putOpt("session_id", this.cuk);
            jSONObject.putOpt("handle_id", bVar.crq);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        aF(jSONObject);
    }

    private String e(Integer num) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(num.intValue());
        for (int i = 0; i < num.intValue(); i++) {
            sb.append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt(random.nextInt("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".length())));
        }
        return sb.toString();
    }

    public static String encodeURIComponent(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8").replaceAll("\\+", "%20").replaceAll("\\%21", "!").replaceAll("\\%27", "'").replaceAll("\\%28", "(").replaceAll("\\%29", ")").replaceAll("\\%7E", Constants.WAVE_SEPARATOR);
        } catch (UnsupportedEncodingException e) {
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onMessage(String str) {
        JSONArray optJSONArray;
        int i = 0;
        if (com.baidu.rtc.a.a.crX) {
            Log.i("WebSocketChannel", "onMessage" + str);
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("janus");
            if (optString.equals("success")) {
                String optString2 = jSONObject.optString("transaction");
                d dVar = this.cup.get(optString2);
                if (dVar.crC != null) {
                    dVar.crC.aE(jSONObject);
                }
                this.cup.remove(optString2);
            } else if (optString.equals(BdStatsConstant.StatsType.ERROR)) {
                String optString3 = jSONObject.optString("transaction");
                d dVar2 = this.cup.get(optString3);
                if (dVar2 != null && dVar2.crB != null) {
                    dVar2.crB.aD(jSONObject);
                }
                this.cup.remove(optString3);
                if (jSONObject.has(BdStatsConstant.StatsType.ERROR)) {
                    String optString4 = jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR).optString(TiebaInitialize.LogFields.REASON);
                    if (optString4.contains("Room is disbanded")) {
                        if (this.ctN != null) {
                            this.ctN.aek();
                        }
                    } else if (!optString4.contains("User is kick out") || this.ctN == null) {
                    } else {
                        this.ctN.bM(this.mUserId);
                    }
                }
            } else if (optString.equals("ack")) {
            } else {
                if (optString.equals("timeout")) {
                    this.mHandler.removeCallbacks(this.ctP);
                    if (this.ctN != null) {
                        this.ctN.aeh();
                    }
                } else if (optString.equals("slowlink")) {
                    this.ctN.g(jSONObject.optBoolean("uplink"), jSONObject.optInt("nacks"));
                } else if (!optString.equals("sessionevent")) {
                    if (jSONObject.has("sender")) {
                        final b bVar = this.ctQ.get(new BigInteger(jSONObject.optString("sender")));
                        if (bVar == null) {
                            Log.e("WebSocketChannel", "missing handle");
                        } else if (!optString.equals("event")) {
                            if (optString.equals("detached")) {
                                bVar.crz.a(bVar);
                            } else if (optString.equals("webrtcup")) {
                                this.ctN.f(bVar.crq);
                            } else if (optString.equals("media")) {
                                this.ctN.a(bVar.crq, jSONObject.getString("type").contains("video") ? 1 : 0, jSONObject.getBoolean("receiving"));
                            } else if (!optString.equals("hangup") || this.ctN == null) {
                            } else {
                                this.ctN.b(bVar.crq);
                            }
                        } else {
                            JSONObject optJSONObject = jSONObject.optJSONObject("plugindata").optJSONObject("data");
                            if (optJSONObject.optString("videoroom").equals("joined")) {
                                bVar.cry.a(bVar);
                            } else if (optJSONObject.optString("videoroom").equals("event")) {
                                if (optJSONObject.has("error_code")) {
                                    this.ctN.fP(optJSONObject.optInt("error_code"));
                                }
                                if (optJSONObject.optInt("error_code") == 436) {
                                    Log.e("WebSocketChannel", "error_code 436， so try again。");
                                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.rtc.p.19
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            p.this.c(bVar);
                                        }
                                    }, 2000L);
                                }
                            }
                            JSONArray optJSONArray2 = optJSONObject.optJSONArray("publishers");
                            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                                int length = optJSONArray2.length();
                                while (i <= length - 1) {
                                    JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i);
                                    BigInteger bigInteger = new BigInteger(optJSONObject2.optString("id"));
                                    String optString5 = optJSONObject2.optString("display");
                                    this.ctN.b(bigInteger, optString5);
                                    if (this.ctR && this.ctU) {
                                        d(bigInteger, optString5);
                                    }
                                    i++;
                                }
                            }
                            String optString6 = optJSONObject.optString("leaving");
                            if (!TextUtils.isEmpty(optString6) && !optString6.equals("ok")) {
                                this.ctN.a(bVar.crq, new BigInteger(optString6));
                                b bVar2 = this.ctO.get(new BigInteger(optString6));
                                if (bVar2 != null && bVar2.crz != null) {
                                    bVar2.crz.a(bVar2);
                                }
                            }
                            String optString7 = optJSONObject.optString("unpublished");
                            if (!TextUtils.isEmpty(optString7)) {
                                if (!optString7.equals("ok") && !optString7.equals("self")) {
                                    this.ctN.a(bVar.crq, new BigInteger(optString7));
                                    b bVar3 = this.ctO.get(new BigInteger(optString7));
                                    if (bVar3 != null && bVar3.crz != null) {
                                        bVar3.crz.a(bVar3);
                                    }
                                } else if (optString7.equals("self") && optJSONObject.has("servertrigger")) {
                                    this.ctN.b(bVar.crq);
                                }
                            }
                            JSONObject optJSONObject3 = jSONObject.optJSONObject("jsep");
                            if (optJSONObject3 != null) {
                                bVar.crA.a(bVar, optJSONObject3);
                            }
                        }
                    }
                } else if (jSONObject.has("recvdata")) {
                    JSONObject optJSONObject4 = jSONObject.optJSONObject("recvdata");
                    if (!optJSONObject4.optBoolean("internal")) {
                        this.ctN.c(new BigInteger(optJSONObject4.optString("from")), optJSONObject4.optString("data"));
                        return;
                    }
                    BaiduRtcRoom.d dVar3 = this.cum.get(BigInteger.valueOf(optJSONObject4.optLong("from")));
                    if (dVar3 != null) {
                        dVar3.attribute = optJSONObject4.optString("data");
                    }
                    this.ctN.a(new BigInteger(optJSONObject4.optString("from")), optJSONObject4.optString("data"));
                } else if (jSONObject.has("userevent")) {
                    JSONObject optJSONObject5 = jSONObject.optJSONObject("userevent");
                    if (optJSONObject5.has("joined")) {
                        BaiduRtcRoom.d dVar4 = new BaiduRtcRoom.d();
                        dVar4.userId = optJSONObject5.optLong("joined");
                        dVar4.userName = optJSONObject5.optString("display");
                        dVar4.attribute = optJSONObject5.optString(Config.EVENT_ATTR);
                        this.cum.put(BigInteger.valueOf(dVar4.userId), dVar4);
                        this.ctN.a(new BigInteger(optJSONObject5.optString("joined")), optJSONObject5.optString("display"), "");
                    } else if (optJSONObject5.has("leaving")) {
                        this.cum.remove(BigInteger.valueOf(optJSONObject5.optLong("leaving")));
                        this.ctN.e(new BigInteger(optJSONObject5.optString("leaving")));
                    } else if (!optJSONObject5.has("users") || (optJSONArray = optJSONObject5.optJSONArray("users")) == null || optJSONArray.length() <= 0) {
                    } else {
                        int length2 = optJSONArray.length();
                        while (i <= length2 - 1) {
                            JSONObject optJSONObject6 = optJSONArray.optJSONObject(i);
                            BigInteger bigInteger2 = new BigInteger(optJSONObject6.optString("id"));
                            String optString8 = optJSONObject6.optString("display");
                            BaiduRtcRoom.d dVar5 = new BaiduRtcRoom.d();
                            dVar5.userId = optJSONObject6.optLong("id");
                            dVar5.userName = optJSONObject6.optString("display");
                            dVar5.attribute = optJSONObject6.optString(Config.EVENT_ATTR);
                            this.cum.put(bigInteger2, dVar5);
                            this.ctN.a(bigInteger2, optString8, "");
                            String optString9 = optJSONObject6.optString(Config.EVENT_ATTR);
                            if (!optString9.isEmpty()) {
                                this.ctN.a(bigInteger2, optString9);
                            }
                            i++;
                        }
                    }
                } else if (jSONObject.has("detached")) {
                } else {
                    if (jSONObject.has("forwardconfigure")) {
                        JSONObject optJSONObject7 = jSONObject.optJSONObject("forwardconfigure");
                        long optLong = Boolean.valueOf(optJSONObject7.optBoolean("self")).booleanValue() ? this.mUserId : optJSONObject7.optLong("id");
                        Boolean valueOf = Boolean.valueOf(optJSONObject7.optBoolean("video"));
                        Boolean valueOf2 = Boolean.valueOf(optJSONObject7.optBoolean("audio"));
                        if (valueOf.booleanValue() && valueOf2.booleanValue()) {
                            this.ctN.bL(optLong);
                        } else if (valueOf.booleanValue() || valueOf2.booleanValue()) {
                        } else {
                            this.ctN.bN(optLong);
                        }
                    } else if (jSONObject.has("userkickout")) {
                        this.ctN.bM(jSONObject.optJSONObject("userkickout").optLong("id"));
                    } else if (jSONObject.has("bypass_event")) {
                        JSONObject optJSONObject8 = jSONObject.optJSONObject("bypass_event");
                        BaiduRtcRoom.RtcLiveTransferMode rtcLiveTransferMode = optJSONObject8.optString("level").contains(UbcStatConstant.KEY_CONTENT_ROOM) ? BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ROOM_TRANSMISSION : BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ANCHOR_TRASNSMISSION;
                        String optString10 = optJSONObject8.optJSONObject(AlaRecorderLog.Protocol.RTMP).optString("url");
                        String optString11 = optJSONObject8.optString("bypassStatus");
                        if (optString11.contains("success")) {
                            this.ctN.c(rtcLiveTransferMode, optString10);
                        } else if (optString11.contains(SmsLoginView.f.l)) {
                            this.ctN.a(rtcLiveTransferMode, optString10);
                        } else if (optString11.contains("break")) {
                            this.ctN.b(rtcLiveTransferMode, optString10);
                        }
                    }
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void L(String str, boolean z) {
        String str2 = str + "?appid=" + this.mAppId + "&roomname=" + encodeURIComponent(this.mRoomName) + "&uid=" + this.mUserId + "&token=" + this.cul;
        if (z) {
            str2 = str2 + "&compulsive=true";
        }
        if (com.baidu.rtc.a.a.crX) {
            Log.i("WebSocketChannel", "connect url: " + str2);
        }
        this.cuo = ctL.connectTimeout(this.ctV, TimeUnit.MILLISECONDS).readTimeout(this.cui, TimeUnit.MILLISECONDS).dns(new Dns() { // from class: com.baidu.rtc.p.10
            @Override // okhttp3.Dns
            public List<InetAddress> lookup(final String str3) {
                if (str3.equals("mytestrtc.exp.bcelive.com")) {
                    ArrayList arrayList = new ArrayList();
                    try {
                        arrayList.add(InetAddress.getByName("10.99.206.86"));
                        return arrayList;
                    } catch (Exception e) {
                        return arrayList;
                    }
                }
                try {
                    FutureTask futureTask = new FutureTask(new Callable<List<InetAddress>>() { // from class: com.baidu.rtc.p.10.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // java.util.concurrent.Callable
                        public List<InetAddress> call() throws Exception {
                            return Arrays.asList(InetAddress.getAllByName(str3));
                        }
                    });
                    new Thread(futureTask).start();
                    return (List) futureTask.get(p.this.ctV, TimeUnit.MILLISECONDS);
                } catch (Exception e2) {
                    return null;
                }
            }
        }).build().newWebSocket(new Request.Builder().url(str2).build(), new WebSocketListener() { // from class: com.baidu.rtc.p.17
            @Override // okhttp3.WebSocketListener
            public void onClosed(WebSocket webSocket, int i, String str3) {
            }

            @Override // okhttp3.WebSocketListener
            public void onClosing(WebSocket webSocket, int i, String str3) {
                if (com.baidu.rtc.a.a.crX) {
                    Log.i("WebSocketChannel", "onClosing");
                }
                if (p.this.ctN != null) {
                    p.this.ctN.aeh();
                }
            }

            @Override // okhttp3.WebSocketListener
            public void onFailure(WebSocket webSocket, Throwable th, Response response) {
                if (th != null) {
                    Log.e("WebSocketChannel", "onFailure" + th.toString());
                } else {
                    Log.e("WebSocketChannel", "onFailure");
                }
                if (p.this.ctN == null) {
                    return;
                }
                if (th instanceof SocketTimeoutException) {
                    if (p.this.ctN != null) {
                        p.this.ctN.aej();
                    }
                } else if (th instanceof NumberFormatException) {
                    Log.e("WebSocketChannel", "onFailure: java.lang.NumberFormatException");
                } else if (th instanceof NullPointerException) {
                    Log.e("WebSocketChannel", "onFailure: java.lang.NullPointerException");
                } else if (!(th instanceof SSLException)) {
                    if (p.this.ctN != null) {
                        p.this.ctN.aei();
                    }
                } else {
                    Log.e("WebSocketChannel", "onFailure: SSLException");
                    if (p.this.ctN != null) {
                        p.this.ctN.aeh();
                    }
                }
            }

            @Override // okhttp3.WebSocketListener
            public void onMessage(WebSocket webSocket, String str3) {
                p.this.onMessage(str3);
            }

            @Override // okhttp3.WebSocketListener
            public void onMessage(WebSocket webSocket, ByteString byteString) {
            }

            @Override // okhttp3.WebSocketListener
            public void onOpen(WebSocket webSocket, Response response) {
                if (com.baidu.rtc.a.a.crX) {
                    Log.i("WebSocketChannel", "onOpen");
                }
                p.this.createSession();
            }
        });
    }

    public void a(long j, String str, final b bVar) {
        String e = e((Integer) 12);
        d dVar = new d();
        dVar.tid = e;
        dVar.crC = new o() { // from class: com.baidu.rtc.p.5
            @Override // com.baidu.rtc.o
            public void aE(JSONObject jSONObject) {
                p.this.c(bVar);
            }
        };
        dVar.crB = new n() { // from class: com.baidu.rtc.p.6
            @Override // com.baidu.rtc.n
            public void aD(JSONObject jSONObject) {
                p.this.c(bVar);
            }
        };
        this.cup.put(e, dVar);
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        JSONObject jSONObject4 = new JSONObject();
        try {
            jSONObject.putOpt("request", "create");
            jSONObject.putOpt(UbcStatConstant.KEY_CONTENT_ROOM, Long.valueOf(j));
            jSONObject.putOpt("description", str);
            jSONObject.putOpt("publishers", 1000);
            jSONObject.putOpt("is_private", false);
            jSONObject.putOpt("videocodec", this.mVideoCodec);
            jSONObject.putOpt("playoutdelay_ext", true);
            if (!this.cud.isEmpty() && this.cuf == BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ROOM_TRANSMISSION) {
                jSONObject3.putOpt("url", this.cud);
                if (!this.ctY.isEmpty()) {
                    jSONObject3.putOpt("mixTemplate", this.ctY);
                }
                jSONObject.putOpt(AlaRecorderLog.Protocol.RTMP, jSONObject3);
            } else if (!this.cue.isEmpty() && this.cug == BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ROOM_TRANSMISSION) {
                jSONObject3.putOpt("url", this.cue);
                if (!this.ctZ.isEmpty()) {
                    jSONObject3.putOpt("mixTemplate", this.ctZ);
                }
                jSONObject.putOpt(AlaRecorderLog.Protocol.RTMP, jSONObject3);
            }
            if (this.cua) {
                jSONObject4.putOpt("rec", Boolean.valueOf(this.cua));
                jSONObject.putOpt("recording", jSONObject4);
            }
            jSONObject2.putOpt("janus", "message");
            jSONObject2.putOpt("body", jSONObject);
            jSONObject2.putOpt("transaction", e);
            jSONObject2.putOpt("session_id", this.cuk);
            jSONObject2.putOpt("handle_id", bVar.crq);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        aF(jSONObject2);
    }

    public void a(BaiduRtcRoom.RtcLiveTransferMode rtcLiveTransferMode) {
        this.cuf = rtcLiveTransferMode;
    }

    public void a(c cVar) {
        this.ctN = cVar;
    }

    public void a(String str, long j, boolean z) {
        String e = e((Integer) 12);
        d dVar = new d();
        dVar.tid = e;
        dVar.crC = new o() { // from class: com.baidu.rtc.p.11
            @Override // com.baidu.rtc.o
            public void aE(JSONObject jSONObject) {
            }
        };
        dVar.crB = new n() { // from class: com.baidu.rtc.p.12
            @Override // com.baidu.rtc.n
            public void aD(JSONObject jSONObject) {
            }
        };
        this.cup.put(e, dVar);
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.putOpt("request", "senddata");
            jSONObject.putOpt(UbcStatConstant.KEY_CONTENT_ROOM, Long.valueOf(this.mRoomId));
            jSONObject.putOpt("id", Long.valueOf(this.mUserId));
            jSONObject.putOpt("to", Long.valueOf(j));
            jSONObject.putOpt("data", str);
            jSONObject.putOpt("internal", Boolean.valueOf(z));
            jSONObject2.putOpt("janus", "message");
            jSONObject2.putOpt("body", jSONObject);
            jSONObject2.putOpt("transaction", e);
            jSONObject2.putOpt("session_id", this.cuk);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        aF(jSONObject2);
    }

    public void a(BigInteger bigInteger, IceCandidate iceCandidate) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.putOpt("candidate", iceCandidate.sdp);
            jSONObject.putOpt("sdpMid", iceCandidate.sdpMid);
            jSONObject.putOpt("sdpMLineIndex", Integer.valueOf(iceCandidate.sdpMLineIndex));
            jSONObject2.putOpt("janus", "trickle");
            jSONObject2.putOpt("candidate", jSONObject);
            jSONObject2.putOpt("transaction", e((Integer) 12));
            jSONObject2.putOpt("session_id", this.cuk);
            jSONObject2.putOpt("handle_id", bigInteger);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        aF(jSONObject2);
    }

    public void aG(JSONObject jSONObject) {
        String e = e((Integer) 12);
        d dVar = new d();
        dVar.tid = e;
        dVar.crC = new o() { // from class: com.baidu.rtc.p.15
            @Override // com.baidu.rtc.o
            public void aE(JSONObject jSONObject2) {
            }
        };
        dVar.crB = new n() { // from class: com.baidu.rtc.p.16
            @Override // com.baidu.rtc.n
            public void aD(JSONObject jSONObject2) {
            }
        };
        this.cup.put(e, dVar);
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt("janus", "message");
            jSONObject2.putOpt("body", jSONObject);
            jSONObject2.putOpt("transaction", e);
            jSONObject2.putOpt("session_id", this.cuk);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        aF(jSONObject2);
    }

    public BaiduRtcRoom.d[] aeA() {
        if (this.cum.size() < 1) {
            return null;
        }
        BaiduRtcRoom.d[] dVarArr = new BaiduRtcRoom.d[this.cum.size()];
        int i = 0;
        Iterator<BaiduRtcRoom.d> it = this.cum.values().iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return dVarArr;
            }
            BaiduRtcRoom.d next = it.next();
            dVarArr[i2] = new BaiduRtcRoom.d();
            dVarArr[i2].userId = next.userId;
            dVarArr[i2].userName = next.userName;
            dVarArr[i2].attribute = next.attribute;
            i = i2 + 1;
        }
    }

    public void b(String str, boolean z, boolean z2, String str2, BaiduRtcRoom.RtcLiveTransferMode rtcLiveTransferMode) {
        this.cue = str;
        this.ctX = z;
        this.cub = z2;
        this.ctZ = str2;
        this.cug = rtcLiveTransferMode;
    }

    public void bK(long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("request", "kickoutuser");
            jSONObject.putOpt(UbcStatConstant.KEY_CONTENT_ROOM, Long.valueOf(this.mRoomId));
            jSONObject.putOpt("target", Long.valueOf(j));
            aG(jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void c(BigInteger bigInteger, SessionDescription sessionDescription) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject.putOpt("request", "configure");
            jSONObject.putOpt("audio", Boolean.valueOf(this.mHasAudio));
            jSONObject.putOpt("video", Boolean.valueOf(this.mHasVideo));
            if (this.crV) {
                jSONObject.putOpt("data", Boolean.valueOf(this.crV));
            }
            jSONObject2.putOpt("type", sessionDescription.type);
            jSONObject2.putOpt("sdp", sessionDescription.description);
            jSONObject3.putOpt("janus", "message");
            jSONObject3.putOpt("body", jSONObject);
            jSONObject3.putOpt("jsep", jSONObject2);
            jSONObject3.putOpt("transaction", e((Integer) 12));
            jSONObject3.putOpt("session_id", this.cuk);
            jSONObject3.putOpt("handle_id", bigInteger);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        aF(jSONObject3);
    }

    public void d(final BigInteger bigInteger, final String str) {
        String e = e((Integer) 12);
        d dVar = new d();
        dVar.tid = e;
        dVar.crC = new o() { // from class: com.baidu.rtc.p.24
            @Override // com.baidu.rtc.o
            public void aE(JSONObject jSONObject) {
                b bVar = new b();
                bVar.crq = new BigInteger(jSONObject.optJSONObject("data").optString("id"));
                bVar.crx = bigInteger;
                bVar.crw = str;
                bVar.crA = new f() { // from class: com.baidu.rtc.p.24.1
                    @Override // com.baidu.rtc.f
                    public void a(b bVar2, JSONObject jSONObject2) {
                        p.this.ctN.b(bVar2.crq, jSONObject2);
                    }
                };
                bVar.crz = new e() { // from class: com.baidu.rtc.p.24.2
                    @Override // com.baidu.rtc.e
                    public void a(b bVar2) {
                        p.this.f(bVar2);
                    }
                };
                p.this.ctQ.put(bVar.crq, bVar);
                p.this.ctO.put(bVar.crx, bVar);
                p.this.d(bVar);
            }
        };
        dVar.crB = new n() { // from class: com.baidu.rtc.p.2
            @Override // com.baidu.rtc.n
            public void aD(JSONObject jSONObject) {
            }
        };
        this.cup.put(e, dVar);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("janus", "attach");
            jSONObject.putOpt("plugin", "janus.plugin.videoroom");
            jSONObject.putOpt("transaction", e);
            jSONObject.putOpt("session_id", this.cuk);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        aF(jSONObject);
    }

    public void d(BigInteger bigInteger, SessionDescription sessionDescription) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject.putOpt("request", "start");
            jSONObject.putOpt(UbcStatConstant.KEY_CONTENT_ROOM, Long.valueOf(this.mRoomId));
            jSONObject2.putOpt("type", sessionDescription.type);
            jSONObject2.putOpt("sdp", sessionDescription.description);
            jSONObject3.putOpt("janus", "message");
            jSONObject3.putOpt("body", jSONObject);
            jSONObject3.putOpt("jsep", jSONObject2);
            jSONObject3.putOpt("transaction", e((Integer) 12));
            jSONObject3.putOpt("session_id", this.cuk);
            jSONObject3.putOpt("handle_id", bigInteger);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        aF(jSONObject3);
    }

    public void disbandRoom() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("request", "disbandroom");
            jSONObject.putOpt(UbcStatConstant.KEY_CONTENT_ROOM, Long.valueOf(this.mRoomId));
            aG(jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void e(final b bVar) {
        String e = e((Integer) 12);
        d dVar = new d();
        dVar.tid = e;
        dVar.crC = new o() { // from class: com.baidu.rtc.p.7
            @Override // com.baidu.rtc.o
            public void aE(JSONObject jSONObject) {
                p.this.mRoomId = jSONObject.optJSONObject("plugindata").optJSONObject("data").optLong(UbcStatConstant.KEY_CONTENT_ROOM);
                Log.v("createRoomWithoutRoomID", "Got RoomID:" + p.this.mRoomId);
                p.this.c(bVar);
            }
        };
        dVar.crB = new n() { // from class: com.baidu.rtc.p.8
            @Override // com.baidu.rtc.n
            public void aD(JSONObject jSONObject) {
                p.this.c(bVar);
            }
        };
        this.cup.put(e, dVar);
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        JSONObject jSONObject4 = new JSONObject();
        try {
            jSONObject.putOpt("request", "create");
            jSONObject.putOpt("id", Long.valueOf(this.mUserId));
            jSONObject.putOpt("app_id", this.mAppId);
            jSONObject.putOpt(DpStatConstants.KEY_ROOM_NAME, this.mRoomName);
            jSONObject.putOpt("description", this.mRoomName);
            jSONObject.putOpt("publishers", 1000);
            jSONObject.putOpt("is_private", false);
            jSONObject.putOpt("videocodec", this.mVideoCodec);
            jSONObject.putOpt("playoutdelay_ext", true);
            if (!this.cud.isEmpty() && this.cuf == BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ROOM_TRANSMISSION) {
                jSONObject3.putOpt("url", this.cud);
                jSONObject3.putOpt("mixTemplate", this.ctY);
                jSONObject.putOpt(AlaRecorderLog.Protocol.RTMP, jSONObject3);
            } else if (!this.cue.isEmpty() && this.cug == BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ROOM_TRANSMISSION) {
                jSONObject3.putOpt("url", this.cue);
                if (!this.ctZ.isEmpty()) {
                    jSONObject3.putOpt("mixTemplate", this.ctZ);
                }
                jSONObject.putOpt(AlaRecorderLog.Protocol.RTMP, jSONObject3);
            }
            if (this.cua) {
                jSONObject4.putOpt("rec", Boolean.valueOf(this.cua));
                jSONObject.putOpt("recording", jSONObject4);
            }
            jSONObject2.putOpt("janus", "message");
            jSONObject2.putOpt("body", jSONObject);
            jSONObject2.putOpt("transaction", e);
            jSONObject2.putOpt("session_id", this.cuk);
            jSONObject2.putOpt("handle_id", bVar.crq);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        aF(jSONObject2);
    }

    public void eA(boolean z) {
        this.ctW = z;
    }

    public void eB(boolean z) {
        this.cua = z;
    }

    public void er(boolean z) {
        this.mHasAudio = z;
    }

    public void es(boolean z) {
        this.crV = z;
    }

    public void et(boolean z) {
        this.mHasVideo = z;
    }

    public void ew(boolean z) {
        this.ctR = z;
    }

    public void ex(boolean z) {
        this.ctS = z;
    }

    public void ey(boolean z) {
        this.ctT = z;
    }

    public void ez(boolean z) {
        this.ctU = z;
    }

    public void f(long j, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("request", "forwardconfigure");
            jSONObject.putOpt(UbcStatConstant.KEY_CONTENT_ROOM, Long.valueOf(this.mRoomId));
            jSONObject.putOpt("target", Long.valueOf(j));
            jSONObject.putOpt("audio", Boolean.valueOf(!z));
            jSONObject.putOpt("video", Boolean.valueOf(!z));
            jSONObject.putOpt("data", Boolean.valueOf(!z));
            aG(jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void f(final b bVar) {
        String e = e((Integer) 12);
        d dVar = new d();
        dVar.tid = e;
        dVar.crC = new o() { // from class: com.baidu.rtc.p.3
            @Override // com.baidu.rtc.o
            public void aE(JSONObject jSONObject) {
                p.this.ctN.a(bVar.crq, bVar.crx);
                p.this.ctN.d(bVar.crq);
                p.this.ctQ.remove(bVar.crq);
                p.this.ctO.remove(bVar.crx);
            }
        };
        dVar.crB = new n() { // from class: com.baidu.rtc.p.4
            @Override // com.baidu.rtc.n
            public void aD(JSONObject jSONObject) {
            }
        };
        this.cup.put(e, dVar);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("janus", "detach");
            jSONObject.putOpt("transaction", e);
            jSONObject.putOpt("session_id", this.cuk);
            jSONObject.putOpt("handle_id", bVar.crq);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        aF(jSONObject);
    }

    public void fR(int i) {
        this.ctV = i;
    }

    public void fS(int i) {
        this.cui = i;
    }

    public void finalize() {
        this.mHandler.removeCallbacks(this.ctP);
        this.ctN = null;
        if (this.cuo != null) {
            this.cuo.close(1001, "going away");
        }
    }

    public long getRoomId() {
        return this.mRoomId;
    }

    public void jf(String str) {
        this.ctY = str;
    }

    public void jg(String str) {
        this.cud = str;
    }

    public void jh(String str) {
        this.cuh = str;
    }

    public void ji(String str) {
        this.mRoomName = str;
    }

    public void jj(String str) {
        this.cuj = str;
    }

    public void jk(String str) {
        this.cul = str;
    }

    public BigInteger k(BigInteger bigInteger) {
        return this.ctQ.get(bigInteger) == null ? BigInteger.valueOf(0L) : this.ctQ.get(bigInteger).crx;
    }

    public String l(BigInteger bigInteger) {
        if (this.cum.get(bigInteger) == null) {
            return null;
        }
        return this.cum.get(bigInteger).userName;
    }

    public void m(BigInteger bigInteger) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.putOpt("completed", true);
            jSONObject2.putOpt("janus", "trickle");
            jSONObject2.putOpt("candidate", jSONObject);
            jSONObject2.putOpt("transaction", e((Integer) 12));
            jSONObject2.putOpt("session_id", this.cuk);
            jSONObject2.putOpt("handle_id", bigInteger);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void sendMessageToUser(String str, long j) {
        a(str, j, false);
    }

    public void setAppId(String str) {
        this.mAppId = str;
    }

    public void setDisplayName(String str) {
        this.mDisplayName = str;
    }

    public void setUserAttribute(final String str) {
        String e = e((Integer) 12);
        d dVar = new d();
        dVar.tid = e;
        dVar.crC = new o() { // from class: com.baidu.rtc.p.13
            @Override // com.baidu.rtc.o
            public void aE(JSONObject jSONObject) {
                p.this.a(str, 0L, true);
            }
        };
        dVar.crB = new n() { // from class: com.baidu.rtc.p.14
            @Override // com.baidu.rtc.n
            public void aD(JSONObject jSONObject) {
            }
        };
        this.cup.put(e, dVar);
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.putOpt("request", "setuserattribute");
            jSONObject.putOpt(UbcStatConstant.KEY_CONTENT_ROOM, Long.valueOf(this.mRoomId));
            jSONObject.putOpt("id", Long.valueOf(this.mUserId));
            jSONObject.putOpt("userattribute", str);
            jSONObject2.putOpt("janus", "message");
            jSONObject2.putOpt("body", jSONObject);
            jSONObject2.putOpt("transaction", e);
            jSONObject2.putOpt("session_id", this.cuk);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        aF(jSONObject2);
    }

    public void setUserId(long j) {
        this.mUserId = j;
    }

    public void setVideoCodec(String str) {
        this.mVideoCodec = str.toLowerCase();
    }

    public void yB() {
        this.mHandler.post(new Runnable() { // from class: com.baidu.rtc.p.9
            @Override // java.lang.Runnable
            public void run() {
                int size = p.this.ctQ.size();
                for (int i = 0; i < size; i++) {
                    p.this.b((b) p.this.ctQ.values().toArray()[i]);
                    try {
                        Thread.sleep(50L);
                    } catch (Exception e) {
                    }
                }
            }
        });
    }
}
