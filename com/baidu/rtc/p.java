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
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.mobstat.Config;
import com.baidu.rtc.BaiduRtcRoom;
import com.baidu.sapi2.views.SmsLoginView;
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
/* loaded from: classes12.dex */
public class p {
    static OkHttpClient.Builder crv = new OkHttpClient.Builder().connectionPool(new ConnectionPool(5, 1, TimeUnit.MINUTES)).addInterceptor(new Interceptor() { // from class: com.baidu.rtc.p.1
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
    static int crw = 25000;
    private BigInteger crU;
    private WebSocket crY;
    private c crx;
    private ConcurrentHashMap<String, d> crZ = new ConcurrentHashMap<>();
    private ConcurrentHashMap<BigInteger, b> crA = new ConcurrentHashMap<>();
    private ConcurrentHashMap<BigInteger, b> cry = new ConcurrentHashMap<>();
    private long mUserId = (Build.SERIAL.hashCode() % 100000) + 78657895;
    private String mDisplayName = "Android-rtc";
    private String mRoomName = "";
    private String mVideoCodec = "h264";
    private boolean crC = true;
    private boolean crB = true;
    private boolean mHasVideo = true;
    private boolean mHasAudio = true;
    private boolean cpH = false;
    private long mRoomId = -1160725808;
    private String mAppId = "";
    private String crV = "";
    private String crN = "";
    private String crM = "";
    private String crI = "";
    private String crR = "";
    private String crT = "";
    private BaiduRtcRoom.RtcLiveTransferMode crP = BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ANCHOR_TRASNSMISSION;
    private boolean crG = false;
    private boolean crK = false;
    private String crO = "";
    private String crJ = "";
    private BaiduRtcRoom.RtcLiveTransferMode crQ = BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ANCHOR_TRASNSMISSION;
    private boolean crH = false;
    private boolean crL = false;
    private int crF = 5000;
    private int crS = 5000;
    public boolean crD = true;
    public boolean crE = true;
    volatile BaiduRtcRoom.e crX = null;
    private ConcurrentHashMap<BigInteger, BaiduRtcRoom.d> crW = new ConcurrentHashMap<>();
    private Runnable crz = new Runnable() { // from class: com.baidu.rtc.p.18
        @Override // java.lang.Runnable
        public void run() {
            p.this.agv();
            p.this.mHandler.postDelayed(p.this.crz, p.crw);
        }
    };
    private Handler mHandler = new Handler(Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: private */
    public void agv() {
        String c = c((Integer) 12);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("janus", "keepalive");
            jSONObject.putOpt("session_id", this.crU);
            jSONObject.putOpt("transaction", c);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ax(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agw() {
        String c = c((Integer) 12);
        d dVar = new d();
        dVar.tid = c;
        dVar.cpn = new o() { // from class: com.baidu.rtc.p.22
            @Override // com.baidu.rtc.o
            public void aw(JSONObject jSONObject) {
                b bVar = new b();
                bVar.cpb = new BigInteger(jSONObject.optJSONObject("data").optString("id"));
                bVar.cpj = new e() { // from class: com.baidu.rtc.p.22.1
                    @Override // com.baidu.rtc.e
                    public void a(b bVar2) {
                        p.this.crx.c(bVar2.cpb);
                    }
                };
                bVar.cpl = new f() { // from class: com.baidu.rtc.p.22.2
                    @Override // com.baidu.rtc.f
                    public void a(b bVar2, JSONObject jSONObject2) {
                        p.this.crx.a(bVar2.cpb, jSONObject2);
                    }
                };
                p.this.crA.put(bVar.cpb, bVar);
                if (p.this.mRoomId == -1160725808) {
                    p.this.e(bVar);
                } else {
                    p.this.a(p.this.mRoomId, p.this.mRoomName, bVar);
                }
            }
        };
        dVar.cpm = new n() { // from class: com.baidu.rtc.p.23
            @Override // com.baidu.rtc.n
            public void av(JSONObject jSONObject) {
            }
        };
        this.crZ.put(c, dVar);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("janus", "attach");
            jSONObject.putOpt("plugin", "janus.plugin.videoroom");
            jSONObject.putOpt("transaction", c);
            jSONObject.putOpt("session_id", this.crU);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ax(jSONObject);
    }

    private void ax(JSONObject jSONObject) {
        if (this.crY != null) {
            this.crY.send(jSONObject.toString());
        }
        if (com.baidu.rtc.b.a.cpJ) {
            Log.i("WebSocketChannel", jSONObject.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(b bVar) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.putOpt("request", UbcStatConstant.ContentType.UBC_TYPE_IM_LEAVE);
            jSONObject2.putOpt("janus", "message");
            jSONObject2.putOpt("body", jSONObject);
            jSONObject2.putOpt("transaction", c((Integer) 12));
            jSONObject2.putOpt("session_id", this.crU);
            jSONObject2.putOpt("handle_id", bVar.cpb);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ax(jSONObject2);
    }

    private String c(Integer num) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(num.intValue());
        for (int i = 0; i < num.intValue(); i++) {
            sb.append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt(random.nextInt("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".length())));
        }
        return sb.toString();
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
            if (!this.crR.isEmpty()) {
                jSONObject2.putOpt("window_id_in_bypass", this.crR);
            }
            if (!this.crN.isEmpty() && this.crP == BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ANCHOR_TRASNSMISSION) {
                jSONObject3.putOpt("url", this.crN);
                if (!this.crI.isEmpty()) {
                    jSONObject3.putOpt("mixTemplate", this.crI);
                }
                jSONObject3.putOpt("mix", Boolean.valueOf(this.crG));
                jSONObject2.putOpt(AlaRecorderLog.Protocol.RTMP, jSONObject3);
            } else if (!this.crO.isEmpty() && this.crQ == BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ANCHOR_TRASNSMISSION) {
                jSONObject3.putOpt("url", this.crO);
                if (!this.crJ.isEmpty()) {
                    jSONObject3.putOpt("mixTemplate", this.crJ);
                }
                jSONObject3.putOpt("mix", Boolean.valueOf(this.crH));
                jSONObject2.putOpt(AlaRecorderLog.Protocol.RTMP, jSONObject3);
            }
            if (this.crK) {
                jSONObject4.putOpt("rec", Boolean.valueOf(this.crK));
                jSONObject2.putOpt("recording", jSONObject4);
            }
            jSONObject.putOpt("janus", "message");
            jSONObject.putOpt("body", jSONObject2);
            jSONObject.putOpt("transaction", c((Integer) 12));
            jSONObject.putOpt("session_id", this.crU);
            jSONObject.putOpt("handle_id", bVar.cpb);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ax(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createSession() {
        String c = c((Integer) 12);
        d dVar = new d();
        dVar.tid = c;
        dVar.cpn = new o() { // from class: com.baidu.rtc.p.20
            @Override // com.baidu.rtc.o
            public void aw(JSONObject jSONObject) {
                p.this.crU = new BigInteger(jSONObject.optJSONObject("data").optString("id"));
                p.this.mHandler.postDelayed(p.this.crz, p.crw);
                p.this.agw();
            }
        };
        dVar.cpm = new n() { // from class: com.baidu.rtc.p.21
            @Override // com.baidu.rtc.n
            public void av(JSONObject jSONObject) {
            }
        };
        this.crZ.put(c, dVar);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("janus", "create");
            jSONObject.putOpt("transaction", c);
            if (!this.crT.isEmpty()) {
                jSONObject.putOpt("sdktag", this.crT);
            }
            jSONObject.putOpt("sessionevent", true);
            jSONObject.putOpt("userevent", true);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ax(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(b bVar) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt("request", UbcStatConstant.ContentType.UBC_TYPE_IM_JOIN);
            jSONObject2.putOpt(UbcStatConstant.KEY_CONTENT_ROOM, Long.valueOf(this.mRoomId));
            jSONObject2.putOpt("ptype", "listener");
            jSONObject2.putOpt("feed", bVar.cpi);
            jSONObject2.putOpt("id", Long.valueOf(this.mUserId));
            jSONObject2.putOpt("app_id", this.mAppId);
            jSONObject2.putOpt(DpStatConstants.KEY_ROOM_NAME, this.mRoomName);
            jSONObject2.putOpt("token", this.crV);
            jSONObject2.putOpt("role", "listener");
            if (!this.crR.isEmpty()) {
                jSONObject2.putOpt("window_id_in_bypass", this.crR);
            }
            jSONObject.putOpt("janus", "message");
            jSONObject.putOpt("body", jSONObject2);
            jSONObject.putOpt("transaction", c((Integer) 12));
            jSONObject.putOpt("session_id", this.crU);
            jSONObject.putOpt("handle_id", bVar.cpb);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ax(jSONObject);
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
        if (com.baidu.rtc.b.a.cpJ) {
            Log.i("WebSocketChannel", "onMessage" + str);
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("janus");
            if (optString.equals("success")) {
                String optString2 = jSONObject.optString("transaction");
                d dVar = this.crZ.get(optString2);
                if (dVar.cpn != null) {
                    dVar.cpn.aw(jSONObject);
                }
                this.crZ.remove(optString2);
            } else if (optString.equals(BdStatsConstant.StatsType.ERROR)) {
                String optString3 = jSONObject.optString("transaction");
                d dVar2 = this.crZ.get(optString3);
                if (dVar2 != null && dVar2.cpm != null) {
                    dVar2.cpm.av(jSONObject);
                }
                this.crZ.remove(optString3);
                if (jSONObject.has(BdStatsConstant.StatsType.ERROR)) {
                    String optString4 = jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR).optString(TiebaInitialize.LogFields.REASON);
                    if (optString4.contains("Room is disbanded")) {
                        if (this.crx != null) {
                            this.crx.agh();
                        }
                    } else if (!optString4.contains("User is kick out") || this.crx == null) {
                    } else {
                        this.crx.bL(this.mUserId);
                    }
                }
            } else if (optString.equals("ack")) {
            } else {
                if (optString.equals("timeout")) {
                    this.mHandler.removeCallbacks(this.crz);
                    if (this.crx != null) {
                        this.crx.age();
                    }
                } else if (optString.equals("slowlink")) {
                    this.crx.h(jSONObject.optBoolean("uplink"), jSONObject.optInt("nacks"));
                } else if (!optString.equals("sessionevent")) {
                    if (jSONObject.has("sender")) {
                        final b bVar = this.crA.get(new BigInteger(jSONObject.optString("sender")));
                        if (bVar == null) {
                            Log.e("WebSocketChannel", "missing handle");
                        } else if (!optString.equals("event")) {
                            if (optString.equals("detached")) {
                                bVar.cpk.a(bVar);
                            } else if (optString.equals("webrtcup")) {
                                this.crx.f(bVar.cpb);
                            } else if (optString.equals("media")) {
                                this.crx.a(bVar.cpb, jSONObject.getString("type").contains("video") ? 1 : 0, jSONObject.getBoolean("receiving"));
                            } else if (!optString.equals("hangup") || this.crx == null) {
                            } else {
                                this.crx.b(bVar.cpb);
                            }
                        } else {
                            JSONObject optJSONObject = jSONObject.optJSONObject("plugindata").optJSONObject("data");
                            if (optJSONObject.optString("videoroom").equals("joined")) {
                                bVar.cpj.a(bVar);
                            } else if (optJSONObject.optString("videoroom").equals("event")) {
                                if (optJSONObject.has("error_code")) {
                                    this.crx.hx(optJSONObject.optInt("error_code"));
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
                                    this.crx.b(bigInteger, optString5);
                                    if (this.crB && this.crE) {
                                        d(bigInteger, optString5);
                                    }
                                    i++;
                                }
                            }
                            String optString6 = optJSONObject.optString("leaving");
                            if (!TextUtils.isEmpty(optString6) && !optString6.equals("ok")) {
                                this.crx.a(bVar.cpb, new BigInteger(optString6));
                                b bVar2 = this.cry.get(new BigInteger(optString6));
                                if (bVar2 != null && bVar2.cpk != null) {
                                    bVar2.cpk.a(bVar2);
                                }
                            }
                            String optString7 = optJSONObject.optString("unpublished");
                            if (!TextUtils.isEmpty(optString7)) {
                                if (!optString7.equals("ok") && !optString7.equals("self")) {
                                    this.crx.a(bVar.cpb, new BigInteger(optString7));
                                    b bVar3 = this.cry.get(new BigInteger(optString7));
                                    if (bVar3 != null && bVar3.cpk != null) {
                                        bVar3.cpk.a(bVar3);
                                    }
                                } else if (optString7.equals("self") && optJSONObject.has("servertrigger")) {
                                    this.crx.b(bVar.cpb);
                                }
                            }
                            JSONObject optJSONObject3 = jSONObject.optJSONObject("jsep");
                            if (optJSONObject3 != null) {
                                bVar.cpl.a(bVar, optJSONObject3);
                            }
                        }
                    }
                } else if (jSONObject.has("recvdata")) {
                    JSONObject optJSONObject4 = jSONObject.optJSONObject("recvdata");
                    if (!optJSONObject4.optBoolean("internal")) {
                        this.crx.c(new BigInteger(optJSONObject4.optString("from")), optJSONObject4.optString("data"));
                        return;
                    }
                    BaiduRtcRoom.d dVar3 = this.crW.get(BigInteger.valueOf(optJSONObject4.optLong("from")));
                    if (dVar3 != null) {
                        dVar3.attribute = optJSONObject4.optString("data");
                    }
                    this.crx.a(new BigInteger(optJSONObject4.optString("from")), optJSONObject4.optString("data"));
                } else if (jSONObject.has("userevent")) {
                    JSONObject optJSONObject5 = jSONObject.optJSONObject("userevent");
                    if (optJSONObject5.has("joined")) {
                        BaiduRtcRoom.d dVar4 = new BaiduRtcRoom.d();
                        dVar4.userId = optJSONObject5.optLong("joined");
                        dVar4.userName = optJSONObject5.optString("display");
                        dVar4.attribute = optJSONObject5.optString(Config.EVENT_ATTR);
                        this.crW.put(BigInteger.valueOf(dVar4.userId), dVar4);
                        this.crx.a(new BigInteger(optJSONObject5.optString("joined")), optJSONObject5.optString("display"), "");
                    } else if (optJSONObject5.has("leaving")) {
                        this.crW.remove(BigInteger.valueOf(optJSONObject5.optLong("leaving")));
                        this.crx.e(new BigInteger(optJSONObject5.optString("leaving")));
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
                            this.crW.put(bigInteger2, dVar5);
                            this.crx.a(bigInteger2, optString8, "");
                            String optString9 = optJSONObject6.optString(Config.EVENT_ATTR);
                            if (!optString9.isEmpty()) {
                                this.crx.a(bigInteger2, optString9);
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
                            this.crx.bK(optLong);
                        } else if (valueOf.booleanValue() || valueOf2.booleanValue()) {
                        } else {
                            this.crx.bM(optLong);
                        }
                    } else if (jSONObject.has("userkickout")) {
                        this.crx.bL(jSONObject.optJSONObject("userkickout").optLong("id"));
                    } else if (jSONObject.has("bypass_event")) {
                        JSONObject optJSONObject8 = jSONObject.optJSONObject("bypass_event");
                        BaiduRtcRoom.RtcLiveTransferMode rtcLiveTransferMode = optJSONObject8.optString("level").contains(UbcStatConstant.KEY_CONTENT_ROOM) ? BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ROOM_TRANSMISSION : BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ANCHOR_TRASNSMISSION;
                        String optString10 = optJSONObject8.optJSONObject(AlaRecorderLog.Protocol.RTMP).optString("url");
                        String optString11 = optJSONObject8.optString("bypassStatus");
                        if (optString11.contains("success")) {
                            this.crx.c(rtcLiveTransferMode, optString10);
                        } else if (optString11.contains(SmsLoginView.f.l)) {
                            this.crx.a(rtcLiveTransferMode, optString10);
                        } else if (optString11.contains("break")) {
                            this.crx.b(rtcLiveTransferMode, optString10);
                        }
                    }
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void Df() {
        this.mHandler.post(new Runnable() { // from class: com.baidu.rtc.p.9
            @Override // java.lang.Runnable
            public void run() {
                int size = p.this.crA.size();
                for (int i = 0; i < size; i++) {
                    p.this.b((b) p.this.crA.values().toArray()[i]);
                    try {
                        Thread.sleep(50L);
                    } catch (Exception e) {
                    }
                }
            }
        });
    }

    public void L(String str, boolean z) {
        String str2 = str + "?appid=" + this.mAppId + "&roomname=" + encodeURIComponent(this.mRoomName) + "&uid=" + this.mUserId + "&token=" + this.crV;
        if (z) {
            str2 = str2 + "&compulsive=true";
        }
        if (com.baidu.rtc.b.a.cpJ) {
            Log.i("WebSocketChannel", "connect url: " + str2);
        }
        this.crY = crv.connectTimeout(this.crF, TimeUnit.MILLISECONDS).readTimeout(this.crS, TimeUnit.MILLISECONDS).dns(new Dns() { // from class: com.baidu.rtc.p.10
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
                    return (List) futureTask.get(p.this.crF, TimeUnit.MILLISECONDS);
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
                if (com.baidu.rtc.b.a.cpJ) {
                    Log.i("WebSocketChannel", "onClosing");
                }
                if (p.this.crx != null) {
                    p.this.crx.age();
                }
            }

            @Override // okhttp3.WebSocketListener
            public void onFailure(WebSocket webSocket, Throwable th, Response response) {
                if (th != null) {
                    Log.e("WebSocketChannel", "onFailure" + th.toString());
                } else {
                    Log.e("WebSocketChannel", "onFailure");
                }
                if (p.this.crx == null) {
                    return;
                }
                if (th instanceof SocketTimeoutException) {
                    if (p.this.crx != null) {
                        p.this.crx.agg();
                    }
                } else if (th instanceof NumberFormatException) {
                    Log.e("WebSocketChannel", "onFailure: java.lang.NumberFormatException");
                } else if (th instanceof NullPointerException) {
                    Log.e("WebSocketChannel", "onFailure: java.lang.NullPointerException");
                } else if (!(th instanceof SSLException)) {
                    if (p.this.crx != null) {
                        p.this.crx.agf();
                    }
                } else {
                    Log.e("WebSocketChannel", "onFailure: SSLException");
                    if (p.this.crx != null) {
                        p.this.crx.age();
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
                if (com.baidu.rtc.b.a.cpJ) {
                    Log.i("WebSocketChannel", "onOpen");
                }
                p.this.createSession();
            }
        });
    }

    public void a(long j, String str, final b bVar) {
        String c = c((Integer) 12);
        d dVar = new d();
        dVar.tid = c;
        dVar.cpn = new o() { // from class: com.baidu.rtc.p.5
            @Override // com.baidu.rtc.o
            public void aw(JSONObject jSONObject) {
                p.this.c(bVar);
            }
        };
        dVar.cpm = new n() { // from class: com.baidu.rtc.p.6
            @Override // com.baidu.rtc.n
            public void av(JSONObject jSONObject) {
                p.this.c(bVar);
            }
        };
        this.crZ.put(c, dVar);
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
            if (!this.crN.isEmpty() && this.crP == BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ROOM_TRANSMISSION) {
                jSONObject3.putOpt("url", this.crN);
                if (!this.crI.isEmpty()) {
                    jSONObject3.putOpt("mixTemplate", this.crI);
                }
                jSONObject.putOpt(AlaRecorderLog.Protocol.RTMP, jSONObject3);
            } else if (!this.crO.isEmpty() && this.crQ == BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ROOM_TRANSMISSION) {
                jSONObject3.putOpt("url", this.crO);
                if (!this.crJ.isEmpty()) {
                    jSONObject3.putOpt("mixTemplate", this.crJ);
                }
                jSONObject.putOpt(AlaRecorderLog.Protocol.RTMP, jSONObject3);
            }
            if (this.crK) {
                jSONObject4.putOpt("rec", Boolean.valueOf(this.crK));
                jSONObject.putOpt("recording", jSONObject4);
            }
            jSONObject2.putOpt("janus", "message");
            jSONObject2.putOpt("body", jSONObject);
            jSONObject2.putOpt("transaction", c);
            jSONObject2.putOpt("session_id", this.crU);
            jSONObject2.putOpt("handle_id", bVar.cpb);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ax(jSONObject2);
    }

    public void a(BaiduRtcRoom.RtcLiveTransferMode rtcLiveTransferMode) {
        this.crP = rtcLiveTransferMode;
    }

    public void a(c cVar) {
        this.crx = cVar;
    }

    public void a(String str, long j, boolean z) {
        String c = c((Integer) 12);
        d dVar = new d();
        dVar.tid = c;
        dVar.cpn = new o() { // from class: com.baidu.rtc.p.11
            @Override // com.baidu.rtc.o
            public void aw(JSONObject jSONObject) {
            }
        };
        dVar.cpm = new n() { // from class: com.baidu.rtc.p.12
            @Override // com.baidu.rtc.n
            public void av(JSONObject jSONObject) {
            }
        };
        this.crZ.put(c, dVar);
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
            jSONObject2.putOpt("transaction", c);
            jSONObject2.putOpt("session_id", this.crU);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ax(jSONObject2);
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
            jSONObject2.putOpt("transaction", c((Integer) 12));
            jSONObject2.putOpt("session_id", this.crU);
            jSONObject2.putOpt("handle_id", bigInteger);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ax(jSONObject2);
    }

    public BaiduRtcRoom.d[] agx() {
        if (this.crW.size() < 1) {
            return null;
        }
        BaiduRtcRoom.d[] dVarArr = new BaiduRtcRoom.d[this.crW.size()];
        int i = 0;
        Iterator<BaiduRtcRoom.d> it = this.crW.values().iterator();
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

    public void ay(JSONObject jSONObject) {
        String c = c((Integer) 12);
        d dVar = new d();
        dVar.tid = c;
        dVar.cpn = new o() { // from class: com.baidu.rtc.p.15
            @Override // com.baidu.rtc.o
            public void aw(JSONObject jSONObject2) {
            }
        };
        dVar.cpm = new n() { // from class: com.baidu.rtc.p.16
            @Override // com.baidu.rtc.n
            public void av(JSONObject jSONObject2) {
            }
        };
        this.crZ.put(c, dVar);
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt("janus", "message");
            jSONObject2.putOpt("body", jSONObject);
            jSONObject2.putOpt("transaction", c);
            jSONObject2.putOpt("session_id", this.crU);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ax(jSONObject2);
    }

    public void b(String str, boolean z, boolean z2, String str2, BaiduRtcRoom.RtcLiveTransferMode rtcLiveTransferMode) {
        this.crO = str;
        this.crH = z;
        this.crL = z2;
        this.crJ = str2;
        this.crQ = rtcLiveTransferMode;
    }

    public void bJ(long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("request", "kickoutuser");
            jSONObject.putOpt(UbcStatConstant.KEY_CONTENT_ROOM, Long.valueOf(this.mRoomId));
            jSONObject.putOpt("target", Long.valueOf(j));
            ay(jSONObject);
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
            if (this.cpH) {
                jSONObject.putOpt("data", Boolean.valueOf(this.cpH));
            }
            jSONObject2.putOpt("type", sessionDescription.type);
            jSONObject2.putOpt("sdp", sessionDescription.description);
            jSONObject3.putOpt("janus", "message");
            jSONObject3.putOpt("body", jSONObject);
            jSONObject3.putOpt("jsep", jSONObject2);
            jSONObject3.putOpt("transaction", c((Integer) 12));
            jSONObject3.putOpt("session_id", this.crU);
            jSONObject3.putOpt("handle_id", bigInteger);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ax(jSONObject3);
    }

    public void d(long j, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("request", "forwardconfigure");
            jSONObject.putOpt(UbcStatConstant.KEY_CONTENT_ROOM, Long.valueOf(this.mRoomId));
            jSONObject.putOpt("target", Long.valueOf(j));
            jSONObject.putOpt("audio", Boolean.valueOf(!z));
            jSONObject.putOpt("video", Boolean.valueOf(!z));
            jSONObject.putOpt("data", Boolean.valueOf(!z));
            ay(jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void d(final BigInteger bigInteger, final String str) {
        String c = c((Integer) 12);
        d dVar = new d();
        dVar.tid = c;
        dVar.cpn = new o() { // from class: com.baidu.rtc.p.24
            @Override // com.baidu.rtc.o
            public void aw(JSONObject jSONObject) {
                b bVar = new b();
                bVar.cpb = new BigInteger(jSONObject.optJSONObject("data").optString("id"));
                bVar.cpi = bigInteger;
                bVar.cph = str;
                bVar.cpl = new f() { // from class: com.baidu.rtc.p.24.1
                    @Override // com.baidu.rtc.f
                    public void a(b bVar2, JSONObject jSONObject2) {
                        p.this.crx.b(bVar2.cpb, jSONObject2);
                    }
                };
                bVar.cpk = new e() { // from class: com.baidu.rtc.p.24.2
                    @Override // com.baidu.rtc.e
                    public void a(b bVar2) {
                        p.this.f(bVar2);
                    }
                };
                p.this.crA.put(bVar.cpb, bVar);
                p.this.cry.put(bVar.cpi, bVar);
                p.this.d(bVar);
            }
        };
        dVar.cpm = new n() { // from class: com.baidu.rtc.p.2
            @Override // com.baidu.rtc.n
            public void av(JSONObject jSONObject) {
            }
        };
        this.crZ.put(c, dVar);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("janus", "attach");
            jSONObject.putOpt("plugin", "janus.plugin.videoroom");
            jSONObject.putOpt("transaction", c);
            jSONObject.putOpt("session_id", this.crU);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ax(jSONObject);
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
            jSONObject3.putOpt("transaction", c((Integer) 12));
            jSONObject3.putOpt("session_id", this.crU);
            jSONObject3.putOpt("handle_id", bigInteger);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ax(jSONObject3);
    }

    public void disbandRoom() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("request", "disbandroom");
            jSONObject.putOpt(UbcStatConstant.KEY_CONTENT_ROOM, Long.valueOf(this.mRoomId));
            ay(jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void e(final b bVar) {
        String c = c((Integer) 12);
        d dVar = new d();
        dVar.tid = c;
        dVar.cpn = new o() { // from class: com.baidu.rtc.p.7
            @Override // com.baidu.rtc.o
            public void aw(JSONObject jSONObject) {
                p.this.mRoomId = jSONObject.optJSONObject("plugindata").optJSONObject("data").optLong(UbcStatConstant.KEY_CONTENT_ROOM);
                Log.v("createRoomWithoutRoomID", "Got RoomID:" + p.this.mRoomId);
                p.this.c(bVar);
            }
        };
        dVar.cpm = new n() { // from class: com.baidu.rtc.p.8
            @Override // com.baidu.rtc.n
            public void av(JSONObject jSONObject) {
                p.this.c(bVar);
            }
        };
        this.crZ.put(c, dVar);
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
            if (!this.crN.isEmpty() && this.crP == BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ROOM_TRANSMISSION) {
                jSONObject3.putOpt("url", this.crN);
                jSONObject3.putOpt("mixTemplate", this.crI);
                jSONObject.putOpt(AlaRecorderLog.Protocol.RTMP, jSONObject3);
            } else if (!this.crO.isEmpty() && this.crQ == BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ROOM_TRANSMISSION) {
                jSONObject3.putOpt("url", this.crO);
                if (!this.crJ.isEmpty()) {
                    jSONObject3.putOpt("mixTemplate", this.crJ);
                }
                jSONObject.putOpt(AlaRecorderLog.Protocol.RTMP, jSONObject3);
            }
            if (this.crK) {
                jSONObject4.putOpt("rec", Boolean.valueOf(this.crK));
                jSONObject.putOpt("recording", jSONObject4);
            }
            jSONObject2.putOpt("janus", "message");
            jSONObject2.putOpt("body", jSONObject);
            jSONObject2.putOpt("transaction", c);
            jSONObject2.putOpt("session_id", this.crU);
            jSONObject2.putOpt("handle_id", bVar.cpb);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ax(jSONObject2);
    }

    public void em(boolean z) {
        this.mHasAudio = z;
    }

    public void en(boolean z) {
        this.cpH = z;
    }

    public void eo(boolean z) {
        this.mHasVideo = z;
    }

    public void er(boolean z) {
        this.crB = z;
    }

    public void es(boolean z) {
        this.crC = z;
    }

    public void et(boolean z) {
        this.crD = z;
    }

    public void eu(boolean z) {
        this.crE = z;
    }

    public void ev(boolean z) {
        this.crG = z;
    }

    public void ew(boolean z) {
        this.crK = z;
    }

    public void f(final b bVar) {
        String c = c((Integer) 12);
        d dVar = new d();
        dVar.tid = c;
        dVar.cpn = new o() { // from class: com.baidu.rtc.p.3
            @Override // com.baidu.rtc.o
            public void aw(JSONObject jSONObject) {
                p.this.crx.a(bVar.cpb, bVar.cpi);
                p.this.crx.d(bVar.cpb);
                p.this.crA.remove(bVar.cpb);
                p.this.cry.remove(bVar.cpi);
            }
        };
        dVar.cpm = new n() { // from class: com.baidu.rtc.p.4
            @Override // com.baidu.rtc.n
            public void av(JSONObject jSONObject) {
            }
        };
        this.crZ.put(c, dVar);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("janus", "detach");
            jSONObject.putOpt("transaction", c);
            jSONObject.putOpt("session_id", this.crU);
            jSONObject.putOpt("handle_id", bVar.cpb);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ax(jSONObject);
    }

    public void finalize() {
        this.mHandler.removeCallbacks(this.crz);
        this.crx = null;
        if (this.crY != null) {
            this.crY.close(1001, "going away");
        }
    }

    public long getRoomId() {
        return this.mRoomId;
    }

    public void hA(int i) {
        this.crS = i;
    }

    public void hz(int i) {
        this.crF = i;
    }

    public BigInteger k(BigInteger bigInteger) {
        return this.crA.get(bigInteger) == null ? BigInteger.valueOf(0L) : this.crA.get(bigInteger).cpi;
    }

    public void kA(String str) {
        this.mRoomName = str;
    }

    public void kB(String str) {
        this.crT = str;
    }

    public void kC(String str) {
        this.crV = str;
    }

    public void kx(String str) {
        this.crI = str;
    }

    public void ky(String str) {
        this.crN = str;
    }

    public void kz(String str) {
        this.crR = str;
    }

    public String l(BigInteger bigInteger) {
        if (this.crW.get(bigInteger) == null) {
            return null;
        }
        return this.crW.get(bigInteger).userName;
    }

    public void m(BigInteger bigInteger) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.putOpt("completed", true);
            jSONObject2.putOpt("janus", "trickle");
            jSONObject2.putOpt("candidate", jSONObject);
            jSONObject2.putOpt("transaction", c((Integer) 12));
            jSONObject2.putOpt("session_id", this.crU);
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
        String c = c((Integer) 12);
        d dVar = new d();
        dVar.tid = c;
        dVar.cpn = new o() { // from class: com.baidu.rtc.p.13
            @Override // com.baidu.rtc.o
            public void aw(JSONObject jSONObject) {
                p.this.a(str, 0L, true);
            }
        };
        dVar.cpm = new n() { // from class: com.baidu.rtc.p.14
            @Override // com.baidu.rtc.n
            public void av(JSONObject jSONObject) {
            }
        };
        this.crZ.put(c, dVar);
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.putOpt("request", "setuserattribute");
            jSONObject.putOpt(UbcStatConstant.KEY_CONTENT_ROOM, Long.valueOf(this.mRoomId));
            jSONObject.putOpt("id", Long.valueOf(this.mUserId));
            jSONObject.putOpt("userattribute", str);
            jSONObject2.putOpt("janus", "message");
            jSONObject2.putOpt("body", jSONObject);
            jSONObject2.putOpt("transaction", c);
            jSONObject2.putOpt("session_id", this.crU);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ax(jSONObject2);
    }

    public void setUserId(long j) {
        this.mUserId = j;
    }

    public void setVideoCodec(String str) {
        this.mVideoCodec = str.toLowerCase();
    }
}
