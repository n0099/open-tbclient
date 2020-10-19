package com.baidu.rtc;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.Log;
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
import org.webrtc.MediaStreamTrack;
import org.webrtc.SessionDescription;
/* loaded from: classes9.dex */
public class o {
    static OkHttpClient.Builder bXQ = new OkHttpClient.Builder().connectionPool(new ConnectionPool(5, 1, TimeUnit.MINUTES)).addInterceptor(new Interceptor() { // from class: com.baidu.rtc.o.1
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
    static int bXR = 25000;
    private c bXS;
    private BigInteger bYp;
    private WebSocket bYt;
    private ConcurrentHashMap<String, d> bYu = new ConcurrentHashMap<>();
    private ConcurrentHashMap<BigInteger, b> bXV = new ConcurrentHashMap<>();
    private ConcurrentHashMap<BigInteger, b> bXT = new ConcurrentHashMap<>();
    private long mUserId = (Build.SERIAL.hashCode() % 100000) + 78657895;
    private String mDisplayName = "Android-rtc";
    private String bYn = "";
    private String mVideoCodec = "h264";
    private boolean bXX = true;
    private boolean bXW = true;
    private boolean mHasVideo = true;
    private boolean mHasAudio = true;
    private boolean bWw = false;
    private long mRoomId = -1160725808;
    private String mAppId = "";
    private String bYq = "";
    private String bYi = "";
    private String bYh = "";
    private String bYd = "";
    private String bYo = "";
    private BaiduRtcRoom.RtcLiveTransferMode bYk = BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ANCHOR_TRASNSMISSION;
    private boolean bYb = false;
    private boolean bYf = false;
    private String bYj = "";
    private String bYe = "";
    private BaiduRtcRoom.RtcLiveTransferMode bYl = BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ANCHOR_TRASNSMISSION;
    private boolean bYc = false;
    private boolean bYg = false;
    private int bYa = 5000;
    private int bYm = 5000;
    public boolean bXY = true;
    public boolean bXZ = true;
    volatile BaiduRtcRoom.e bYs = null;
    private ConcurrentHashMap<BigInteger, BaiduRtcRoom.d> bYr = new ConcurrentHashMap<>();
    private Runnable bXU = new Runnable() { // from class: com.baidu.rtc.o.14
        @Override // java.lang.Runnable
        public void run() {
            o.this.ZC();
            o.this.mHandler.postDelayed(o.this.bXU, o.bXR);
        }
    };
    private Handler mHandler = new Handler(Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: private */
    public void ZB() {
        String c = c((Integer) 12);
        d dVar = new d();
        dVar.tid = c;
        dVar.bWe = new n() { // from class: com.baidu.rtc.o.16
            @Override // com.baidu.rtc.n
            public void ar(JSONObject jSONObject) {
                o.this.bYp = new BigInteger(jSONObject.optJSONObject("data").optString("id"));
                o.this.mHandler.postDelayed(o.this.bXU, o.bXR);
                o.this.ZD();
            }
        };
        dVar.bWd = new m() { // from class: com.baidu.rtc.o.17
            @Override // com.baidu.rtc.m
            public void aq(JSONObject jSONObject) {
            }
        };
        this.bYu.put(c, dVar);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("janus", "create");
            jSONObject.putOpt("transaction", c);
            if (!this.bYo.isEmpty()) {
                jSONObject.putOpt("sdktag", this.bYo);
            }
            jSONObject.putOpt("sessionevent", true);
            jSONObject.putOpt("userevent", true);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        as(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZC() {
        String c = c((Integer) 12);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("janus", "keepalive");
            jSONObject.putOpt("session_id", this.bYp);
            jSONObject.putOpt("transaction", c);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        as(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZD() {
        String c = c((Integer) 12);
        d dVar = new d();
        dVar.tid = c;
        dVar.bWe = new n() { // from class: com.baidu.rtc.o.18
            @Override // com.baidu.rtc.n
            public void ar(JSONObject jSONObject) {
                b bVar = new b();
                bVar.bVT = new BigInteger(jSONObject.optJSONObject("data").optString("id"));
                bVar.bWa = new e() { // from class: com.baidu.rtc.o.18.1
                    @Override // com.baidu.rtc.e
                    public void a(b bVar2) {
                        o.this.bXS.c(bVar2.bVT);
                    }
                };
                bVar.bWc = new f() { // from class: com.baidu.rtc.o.18.2
                    @Override // com.baidu.rtc.f
                    public void a(b bVar2, JSONObject jSONObject2) {
                        o.this.bXS.a(bVar2.bVT, jSONObject2);
                    }
                };
                o.this.bXV.put(bVar.bVT, bVar);
                if (o.this.mRoomId == -1160725808) {
                    o.this.e(bVar);
                } else {
                    o.this.a(o.this.mRoomId, o.this.bYn, bVar);
                }
            }
        };
        dVar.bWd = new m() { // from class: com.baidu.rtc.o.19
            @Override // com.baidu.rtc.m
            public void aq(JSONObject jSONObject) {
            }
        };
        this.bYu.put(c, dVar);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("janus", "attach");
            jSONObject.putOpt("plugin", "janus.plugin.videoroom");
            jSONObject.putOpt("transaction", c);
            jSONObject.putOpt("session_id", this.bYp);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        as(jSONObject);
    }

    private void as(JSONObject jSONObject) {
        this.bYt.send(jSONObject.toString());
        if (com.baidu.rtc.b.a.bWy) {
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
            jSONObject2.putOpt("session_id", this.bYp);
            jSONObject2.putOpt("handle_id", bVar.bVT);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        as(jSONObject2);
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
            jSONObject2.putOpt(DpStatConstants.KEY_ROOM_NAME, this.bYn);
            jSONObject2.putOpt("role", "publisher");
            jSONObject2.putOpt("token", "no_token");
            if (!this.bYi.isEmpty() && this.bYk == BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ANCHOR_TRASNSMISSION) {
                jSONObject3.putOpt("url", this.bYi);
                if (!this.bYd.isEmpty()) {
                    jSONObject3.putOpt("mixTemplate", this.bYd);
                }
                jSONObject3.putOpt("mix", Boolean.valueOf(this.bYb));
                jSONObject2.putOpt("rtmp", jSONObject3);
            } else if (!this.bYj.isEmpty() && this.bYl == BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ANCHOR_TRASNSMISSION) {
                jSONObject3.putOpt("url", this.bYj);
                if (!this.bYe.isEmpty()) {
                    jSONObject3.putOpt("mixTemplate", this.bYe);
                }
                jSONObject3.putOpt("mix", Boolean.valueOf(this.bYc));
                jSONObject2.putOpt("rtmp", jSONObject3);
            }
            if (this.bYf) {
                jSONObject4.putOpt("rec", Boolean.valueOf(this.bYf));
                jSONObject2.putOpt("recording", jSONObject4);
            }
            jSONObject.putOpt("janus", "message");
            jSONObject.putOpt("body", jSONObject2);
            jSONObject.putOpt("transaction", c((Integer) 12));
            jSONObject.putOpt("session_id", this.bYp);
            jSONObject.putOpt("handle_id", bVar.bVT);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        as(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(b bVar) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt("request", UbcStatConstant.ContentType.UBC_TYPE_IM_JOIN);
            jSONObject2.putOpt(UbcStatConstant.KEY_CONTENT_ROOM, Long.valueOf(this.mRoomId));
            jSONObject2.putOpt("ptype", "listener");
            jSONObject2.putOpt("feed", bVar.bVZ);
            jSONObject2.putOpt("id", Long.valueOf(this.mUserId));
            jSONObject2.putOpt("app_id", this.mAppId);
            jSONObject2.putOpt(DpStatConstants.KEY_ROOM_NAME, this.bYn);
            jSONObject2.putOpt("token", this.bYq);
            jSONObject2.putOpt("role", "listener");
            jSONObject.putOpt("janus", "message");
            jSONObject.putOpt("body", jSONObject2);
            jSONObject.putOpt("transaction", c((Integer) 12));
            jSONObject.putOpt("session_id", this.bYp);
            jSONObject.putOpt("handle_id", bVar.bVT);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        as(jSONObject);
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
        if (com.baidu.rtc.b.a.bWy) {
            Log.i("WebSocketChannel", "onMessage" + str);
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("janus");
            if (optString.equals("success")) {
                String optString2 = jSONObject.optString("transaction");
                d dVar = this.bYu.get(optString2);
                if (dVar.bWe != null) {
                    dVar.bWe.ar(jSONObject);
                }
                this.bYu.remove(optString2);
            } else if (optString.equals(BdStatsConstant.StatsType.ERROR)) {
                String optString3 = jSONObject.optString("transaction");
                d dVar2 = this.bYu.get(optString3);
                if (dVar2 != null && dVar2.bWd != null) {
                    dVar2.bWd.aq(jSONObject);
                }
                this.bYu.remove(optString3);
                if (jSONObject.has(BdStatsConstant.StatsType.ERROR)) {
                    String optString4 = jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR).optString(TiebaInitialize.LogFields.REASON);
                    if (optString4.contains("Room is disbanded")) {
                        this.bXS.Zo();
                    } else if (optString4.contains("User is kick out")) {
                        this.bXS.aO(this.mUserId);
                    }
                }
            } else if (optString.equals("ack")) {
            } else {
                if (optString.equals("timeout")) {
                    this.mHandler.removeCallbacks(this.bXU);
                    this.bXS.Zl();
                } else if (optString.equals("slowlink")) {
                    this.bXS.h(jSONObject.optBoolean("uplink"), jSONObject.optInt("nacks"));
                } else if (!optString.equals("sessionevent")) {
                    if (jSONObject.has("sender")) {
                        final b bVar = this.bXV.get(new BigInteger(jSONObject.optString("sender")));
                        if (bVar == null) {
                            Log.e("WebSocketChannel", "missing handle");
                        } else if (!optString.equals(NotificationCompat.CATEGORY_EVENT)) {
                            if (optString.equals("detached")) {
                                bVar.bWb.a(bVar);
                            } else if (optString.equals("webrtcup")) {
                                this.bXS.e(bVar.bVT);
                            } else if (optString.equals("media")) {
                                this.bXS.a(bVar.bVT, jSONObject.getString("type").contains("video") ? 1 : 0, jSONObject.getBoolean("receiving"));
                            } else if (optString.equals("hangup")) {
                                this.bXS.b(bVar.bVT);
                            }
                        } else {
                            JSONObject optJSONObject = jSONObject.optJSONObject("plugindata").optJSONObject("data");
                            if (optJSONObject.optString("videoroom").equals("joined")) {
                                bVar.bWa.a(bVar);
                            } else if (optJSONObject.optString("videoroom").equals(NotificationCompat.CATEGORY_EVENT)) {
                                if (optJSONObject.has("error_code")) {
                                    this.bXS.gI(optJSONObject.optInt("error_code"));
                                }
                                if (optJSONObject.optInt("error_code") == 436) {
                                    Log.e("WebSocketChannel", "error_code 436， so try again。");
                                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.rtc.o.15
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            o.this.c(bVar);
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
                                    this.bXS.b(bigInteger, optString5);
                                    if (this.bXW && this.bXZ) {
                                        d(bigInteger, optString5);
                                    }
                                    i++;
                                }
                            }
                            String optString6 = optJSONObject.optString("leaving");
                            if (!TextUtils.isEmpty(optString6) && !optString6.equals("ok")) {
                                this.bXS.a(bVar.bVT, new BigInteger(optString6));
                                b bVar2 = this.bXT.get(new BigInteger(optString6));
                                if (bVar2 != null && bVar2.bWb != null) {
                                    bVar2.bWb.a(bVar2);
                                }
                            }
                            String optString7 = optJSONObject.optString("unpublished");
                            if (!TextUtils.isEmpty(optString7)) {
                                if (!optString7.equals("ok") && !optString7.equals("self")) {
                                    this.bXS.a(bVar.bVT, new BigInteger(optString7));
                                    b bVar3 = this.bXT.get(new BigInteger(optString7));
                                    if (bVar3 != null && bVar3.bWb != null) {
                                        bVar3.bWb.a(bVar3);
                                    }
                                } else if (optString7.equals("self") && optJSONObject.has("servertrigger")) {
                                    this.bXS.b(bVar.bVT);
                                }
                            }
                            JSONObject optJSONObject3 = jSONObject.optJSONObject("jsep");
                            if (optJSONObject3 != null) {
                                bVar.bWc.a(bVar, optJSONObject3);
                            }
                        }
                    }
                } else if (jSONObject.has("recvdata")) {
                    JSONObject optJSONObject4 = jSONObject.optJSONObject("recvdata");
                    if (!optJSONObject4.optBoolean("internal")) {
                        this.bXS.c(new BigInteger(optJSONObject4.optString("from")), optJSONObject4.optString("data"));
                        return;
                    }
                    BaiduRtcRoom.d dVar3 = this.bYr.get(BigInteger.valueOf(optJSONObject4.optLong("from")));
                    if (dVar3 != null) {
                        dVar3.attribute = optJSONObject4.optString("data");
                    }
                    this.bXS.a(new BigInteger(optJSONObject4.optString("from")), optJSONObject4.optString("data"));
                } else if (jSONObject.has("userevent")) {
                    JSONObject optJSONObject5 = jSONObject.optJSONObject("userevent");
                    if (optJSONObject5.has("joined")) {
                        BaiduRtcRoom.d dVar4 = new BaiduRtcRoom.d();
                        dVar4.userId = optJSONObject5.optLong("joined");
                        dVar4.userName = optJSONObject5.optString("display");
                        dVar4.attribute = optJSONObject5.optString(Config.EVENT_ATTR);
                        this.bYr.put(BigInteger.valueOf(dVar4.userId), dVar4);
                        this.bXS.a(new BigInteger(optJSONObject5.optString("joined")), optJSONObject5.optString("display"), "");
                    } else if (optJSONObject5.has("leaving")) {
                        this.bYr.remove(BigInteger.valueOf(optJSONObject5.optLong("leaving")));
                        this.bXS.d(new BigInteger(optJSONObject5.optString("leaving")));
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
                            this.bYr.put(bigInteger2, dVar5);
                            this.bXS.a(bigInteger2, optString8, "");
                            String optString9 = optJSONObject6.optString(Config.EVENT_ATTR);
                            if (!optString9.isEmpty()) {
                                this.bXS.a(bigInteger2, optString9);
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
                        Boolean valueOf2 = Boolean.valueOf(optJSONObject7.optBoolean(MediaStreamTrack.AUDIO_TRACK_KIND));
                        if (valueOf.booleanValue() && valueOf2.booleanValue()) {
                            this.bXS.aN(optLong);
                        } else if (valueOf.booleanValue() || valueOf2.booleanValue()) {
                        } else {
                            this.bXS.aP(optLong);
                        }
                    } else if (jSONObject.has("userkickout")) {
                        this.bXS.aO(jSONObject.optJSONObject("userkickout").optLong("id"));
                    } else if (jSONObject.has("bypass_event")) {
                        JSONObject optJSONObject8 = jSONObject.optJSONObject("bypass_event");
                        BaiduRtcRoom.RtcLiveTransferMode rtcLiveTransferMode = optJSONObject8.optString("level").contains(UbcStatConstant.KEY_CONTENT_ROOM) ? BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ROOM_TRANSMISSION : BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ANCHOR_TRASNSMISSION;
                        String optString10 = optJSONObject8.optJSONObject("rtmp").optString("url");
                        String optString11 = optJSONObject8.optString("bypassStatus");
                        if (optString11.contains("success")) {
                            this.bXS.c(rtcLiveTransferMode, optString10);
                        } else if (optString11.contains(SmsLoginView.f.l)) {
                            this.bXS.a(rtcLiveTransferMode, optString10);
                        } else if (optString11.contains("break")) {
                            this.bXS.b(rtcLiveTransferMode, optString10);
                        }
                    }
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void BP() {
        this.mHandler.post(new Runnable() { // from class: com.baidu.rtc.o.9
            @Override // java.lang.Runnable
            public void run() {
                int size = o.this.bXV.size();
                for (int i = 0; i < size; i++) {
                    o.this.b((b) o.this.bXV.values().toArray()[i]);
                    try {
                        Thread.sleep(50L);
                    } catch (Exception e) {
                    }
                }
            }
        });
    }

    public void I(String str, boolean z) {
        String str2 = str + "?appid=" + this.mAppId + "&roomname=" + encodeURIComponent(this.bYn) + "&uid=" + this.mUserId + "&token=" + this.bYq;
        if (z) {
            str2 = str2 + "&compulsive=true";
        }
        if (com.baidu.rtc.b.a.bWy) {
            Log.i("WebSocketChannel", "connect url: " + str2);
        }
        this.bYt = bXQ.connectTimeout(this.bYa, TimeUnit.MILLISECONDS).readTimeout(this.bYm, TimeUnit.MILLISECONDS).dns(new Dns() { // from class: com.baidu.rtc.o.10
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
                    FutureTask futureTask = new FutureTask(new Callable<List<InetAddress>>() { // from class: com.baidu.rtc.o.10.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // java.util.concurrent.Callable
                        public List<InetAddress> call() throws Exception {
                            return Arrays.asList(InetAddress.getAllByName(str3));
                        }
                    });
                    new Thread(futureTask).start();
                    return (List) futureTask.get(o.this.bYa, TimeUnit.MILLISECONDS);
                } catch (Exception e2) {
                    return null;
                }
            }
        }).build().newWebSocket(new Request.Builder().url(str2).build(), new WebSocketListener() { // from class: com.baidu.rtc.o.13
            @Override // okhttp3.WebSocketListener
            public void onClosed(WebSocket webSocket, int i, String str3) {
            }

            @Override // okhttp3.WebSocketListener
            public void onClosing(WebSocket webSocket, int i, String str3) {
                if (com.baidu.rtc.b.a.bWy) {
                    Log.i("WebSocketChannel", "onClosing");
                }
                if (o.this.bXS != null) {
                    o.this.bXS.Zl();
                }
            }

            @Override // okhttp3.WebSocketListener
            public void onFailure(WebSocket webSocket, Throwable th, Response response) {
                if (th != null) {
                    Log.e("WebSocketChannel", "onFailure" + th.toString());
                } else {
                    Log.e("WebSocketChannel", "onFailure");
                }
                if (o.this.bXS == null) {
                    return;
                }
                if (th instanceof SocketTimeoutException) {
                    o.this.bXS.Zn();
                } else if (th instanceof NumberFormatException) {
                    Log.e("WebSocketChannel", "onFailure: java.lang.NumberFormatException");
                } else if (th instanceof NullPointerException) {
                    Log.e("WebSocketChannel", "onFailure: java.lang.NullPointerException");
                } else if (!(th instanceof SSLException)) {
                    o.this.bXS.Zm();
                } else {
                    Log.e("WebSocketChannel", "onFailure: SSLException");
                    o.this.bXS.Zl();
                }
            }

            @Override // okhttp3.WebSocketListener
            public void onMessage(WebSocket webSocket, String str3) {
                o.this.onMessage(str3);
            }

            @Override // okhttp3.WebSocketListener
            public void onMessage(WebSocket webSocket, ByteString byteString) {
            }

            @Override // okhttp3.WebSocketListener
            public void onOpen(WebSocket webSocket, Response response) {
                if (com.baidu.rtc.b.a.bWy) {
                    Log.i("WebSocketChannel", "onOpen");
                }
                o.this.ZB();
            }
        });
    }

    public void Zj() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("request", "disbandroom");
            jSONObject.putOpt(UbcStatConstant.KEY_CONTENT_ROOM, Long.valueOf(this.mRoomId));
            at(jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void a(long j, String str, final b bVar) {
        String c = c((Integer) 12);
        d dVar = new d();
        dVar.tid = c;
        dVar.bWe = new n() { // from class: com.baidu.rtc.o.5
            @Override // com.baidu.rtc.n
            public void ar(JSONObject jSONObject) {
                o.this.c(bVar);
            }
        };
        dVar.bWd = new m() { // from class: com.baidu.rtc.o.6
            @Override // com.baidu.rtc.m
            public void aq(JSONObject jSONObject) {
                o.this.c(bVar);
            }
        };
        this.bYu.put(c, dVar);
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
            if (!this.bYi.isEmpty() && this.bYk == BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ROOM_TRANSMISSION) {
                jSONObject3.putOpt("url", this.bYi);
                if (!this.bYd.isEmpty()) {
                    jSONObject3.putOpt("mixTemplate", this.bYd);
                }
                jSONObject.putOpt("rtmp", jSONObject3);
            } else if (!this.bYj.isEmpty() && this.bYl == BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ROOM_TRANSMISSION) {
                jSONObject3.putOpt("url", this.bYj);
                if (!this.bYe.isEmpty()) {
                    jSONObject3.putOpt("mixTemplate", this.bYe);
                }
                jSONObject.putOpt("rtmp", jSONObject3);
            }
            if (this.bYf) {
                jSONObject4.putOpt("rec", Boolean.valueOf(this.bYf));
                jSONObject.putOpt("recording", jSONObject4);
            }
            jSONObject2.putOpt("janus", "message");
            jSONObject2.putOpt("body", jSONObject);
            jSONObject2.putOpt("transaction", c);
            jSONObject2.putOpt("session_id", this.bYp);
            jSONObject2.putOpt("handle_id", bVar.bVT);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        as(jSONObject2);
    }

    public void a(BaiduRtcRoom.RtcLiveTransferMode rtcLiveTransferMode) {
        this.bYk = rtcLiveTransferMode;
    }

    public void a(c cVar) {
        this.bXS = cVar;
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
            jSONObject2.putOpt("session_id", this.bYp);
            jSONObject2.putOpt("handle_id", bigInteger);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        as(jSONObject2);
    }

    public void aM(long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("request", "kickoutuser");
            jSONObject.putOpt(UbcStatConstant.KEY_CONTENT_ROOM, Long.valueOf(this.mRoomId));
            jSONObject.putOpt("target", Long.valueOf(j));
            at(jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void at(JSONObject jSONObject) {
        String c = c((Integer) 12);
        d dVar = new d();
        dVar.tid = c;
        dVar.bWe = new n() { // from class: com.baidu.rtc.o.11
            @Override // com.baidu.rtc.n
            public void ar(JSONObject jSONObject2) {
            }
        };
        dVar.bWd = new m() { // from class: com.baidu.rtc.o.12
            @Override // com.baidu.rtc.m
            public void aq(JSONObject jSONObject2) {
            }
        };
        this.bYu.put(c, dVar);
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt("janus", "message");
            jSONObject2.putOpt("body", jSONObject);
            jSONObject2.putOpt("transaction", c);
            jSONObject2.putOpt("session_id", this.bYp);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        as(jSONObject2);
    }

    public void b(String str, boolean z, boolean z2, String str2, BaiduRtcRoom.RtcLiveTransferMode rtcLiveTransferMode) {
        this.bYj = str;
        this.bYc = z;
        this.bYg = z2;
        this.bYe = str2;
        this.bYl = rtcLiveTransferMode;
    }

    public void c(BigInteger bigInteger, SessionDescription sessionDescription) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject.putOpt("request", "configure");
            jSONObject.putOpt(MediaStreamTrack.AUDIO_TRACK_KIND, Boolean.valueOf(this.mHasAudio));
            jSONObject.putOpt("video", Boolean.valueOf(this.mHasVideo));
            if (this.bWw) {
                jSONObject.putOpt("data", Boolean.valueOf(this.bWw));
            }
            jSONObject2.putOpt("type", sessionDescription.type);
            jSONObject2.putOpt("sdp", sessionDescription.description);
            jSONObject3.putOpt("janus", "message");
            jSONObject3.putOpt("body", jSONObject);
            jSONObject3.putOpt("jsep", jSONObject2);
            jSONObject3.putOpt("transaction", c((Integer) 12));
            jSONObject3.putOpt("session_id", this.bYp);
            jSONObject3.putOpt("handle_id", bigInteger);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        as(jSONObject3);
    }

    public void d(final BigInteger bigInteger, final String str) {
        String c = c((Integer) 12);
        d dVar = new d();
        dVar.tid = c;
        dVar.bWe = new n() { // from class: com.baidu.rtc.o.20
            @Override // com.baidu.rtc.n
            public void ar(JSONObject jSONObject) {
                b bVar = new b();
                bVar.bVT = new BigInteger(jSONObject.optJSONObject("data").optString("id"));
                bVar.bVZ = bigInteger;
                bVar.ava = str;
                bVar.bWc = new f() { // from class: com.baidu.rtc.o.20.1
                    @Override // com.baidu.rtc.f
                    public void a(b bVar2, JSONObject jSONObject2) {
                        o.this.bXS.b(bVar2.bVT, jSONObject2);
                    }
                };
                bVar.bWb = new e() { // from class: com.baidu.rtc.o.20.2
                    @Override // com.baidu.rtc.e
                    public void a(b bVar2) {
                        o.this.f(bVar2);
                    }
                };
                o.this.bXV.put(bVar.bVT, bVar);
                o.this.bXT.put(bVar.bVZ, bVar);
                o.this.d(bVar);
            }
        };
        dVar.bWd = new m() { // from class: com.baidu.rtc.o.2
            @Override // com.baidu.rtc.m
            public void aq(JSONObject jSONObject) {
            }
        };
        this.bYu.put(c, dVar);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("janus", "attach");
            jSONObject.putOpt("plugin", "janus.plugin.videoroom");
            jSONObject.putOpt("transaction", c);
            jSONObject.putOpt("session_id", this.bYp);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        as(jSONObject);
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
            jSONObject3.putOpt("session_id", this.bYp);
            jSONObject3.putOpt("handle_id", bigInteger);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        as(jSONObject3);
    }

    public void dA(boolean z) {
        this.mHasVideo = z;
    }

    public void dC(boolean z) {
        this.bXW = z;
    }

    public void dD(boolean z) {
        this.bXX = z;
    }

    public void dE(boolean z) {
        this.bXY = z;
    }

    public void dF(boolean z) {
        this.bXZ = z;
    }

    public void dG(boolean z) {
        this.bYb = z;
    }

    public void dH(boolean z) {
        this.bYf = z;
    }

    public void dy(boolean z) {
        this.mHasAudio = z;
    }

    public void dz(boolean z) {
        this.bWw = z;
    }

    public void e(final b bVar) {
        String c = c((Integer) 12);
        d dVar = new d();
        dVar.tid = c;
        dVar.bWe = new n() { // from class: com.baidu.rtc.o.7
            @Override // com.baidu.rtc.n
            public void ar(JSONObject jSONObject) {
                o.this.mRoomId = jSONObject.optJSONObject("plugindata").optJSONObject("data").optLong(UbcStatConstant.KEY_CONTENT_ROOM);
                Log.v("createRoomWithoutRoomID", "Got RoomID:" + o.this.mRoomId);
                o.this.c(bVar);
            }
        };
        dVar.bWd = new m() { // from class: com.baidu.rtc.o.8
            @Override // com.baidu.rtc.m
            public void aq(JSONObject jSONObject) {
                o.this.c(bVar);
            }
        };
        this.bYu.put(c, dVar);
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        JSONObject jSONObject4 = new JSONObject();
        try {
            jSONObject.putOpt("request", "create");
            jSONObject.putOpt("id", Long.valueOf(this.mUserId));
            jSONObject.putOpt("app_id", this.mAppId);
            jSONObject.putOpt(DpStatConstants.KEY_ROOM_NAME, this.bYn);
            jSONObject.putOpt("description", this.bYn);
            jSONObject.putOpt("publishers", 1000);
            jSONObject.putOpt("is_private", false);
            jSONObject.putOpt("videocodec", this.mVideoCodec);
            jSONObject.putOpt("playoutdelay_ext", true);
            if (!this.bYi.isEmpty() && this.bYk == BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ROOM_TRANSMISSION) {
                jSONObject3.putOpt("url", this.bYi);
                jSONObject3.putOpt("mixTemplate", this.bYd);
                jSONObject.putOpt("rtmp", jSONObject3);
            } else if (!this.bYj.isEmpty() && this.bYl == BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ROOM_TRANSMISSION) {
                jSONObject3.putOpt("url", this.bYj);
                if (!this.bYe.isEmpty()) {
                    jSONObject3.putOpt("mixTemplate", this.bYe);
                }
                jSONObject.putOpt("rtmp", jSONObject3);
            }
            if (this.bYf) {
                jSONObject4.putOpt("rec", Boolean.valueOf(this.bYf));
                jSONObject.putOpt("recording", jSONObject4);
            }
            jSONObject2.putOpt("janus", "message");
            jSONObject2.putOpt("body", jSONObject);
            jSONObject2.putOpt("transaction", c);
            jSONObject2.putOpt("session_id", this.bYp);
            jSONObject2.putOpt("handle_id", bVar.bVT);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        as(jSONObject2);
    }

    public void f(final b bVar) {
        String c = c((Integer) 12);
        d dVar = new d();
        dVar.tid = c;
        dVar.bWe = new n() { // from class: com.baidu.rtc.o.3
            @Override // com.baidu.rtc.n
            public void ar(JSONObject jSONObject) {
                o.this.bXS.a(bVar.bVT, bVar.bVZ);
                o.this.bXV.remove(bVar.bVT);
                o.this.bXT.remove(bVar.bVZ);
            }
        };
        dVar.bWd = new m() { // from class: com.baidu.rtc.o.4
            @Override // com.baidu.rtc.m
            public void aq(JSONObject jSONObject) {
            }
        };
        this.bYu.put(c, dVar);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("janus", "detach");
            jSONObject.putOpt("transaction", c);
            jSONObject.putOpt("session_id", this.bYp);
            jSONObject.putOpt("handle_id", bVar.bVT);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        as(jSONObject);
    }

    public void finalize() {
        this.mHandler.removeCallbacks(this.bXU);
        this.bXS = null;
        if (this.bYt != null) {
            this.bYt.close(1001, "going away");
        }
    }

    public void gK(int i) {
        this.bYa = i;
    }

    public void gL(int i) {
        this.bYm = i;
    }

    public long getRoomId() {
        return this.mRoomId;
    }

    public BigInteger i(BigInteger bigInteger) {
        return this.bXV.get(bigInteger) == null ? BigInteger.valueOf(0L) : this.bXV.get(bigInteger).bVZ;
    }

    public String j(BigInteger bigInteger) {
        if (this.bYr.get(bigInteger) == null) {
            return null;
        }
        return this.bYr.get(bigInteger).userName;
    }

    public void jp(String str) {
        this.bYd = str;
    }

    public void jq(String str) {
        this.bYi = str;
    }

    public void jr(String str) {
        this.bYn = str;
    }

    public void js(String str) {
        this.bYo = str;
    }

    public void jt(String str) {
        this.bYq = str;
    }

    public void k(BigInteger bigInteger) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.putOpt("completed", true);
            jSONObject2.putOpt("janus", "trickle");
            jSONObject2.putOpt("candidate", jSONObject);
            jSONObject2.putOpt("transaction", c((Integer) 12));
            jSONObject2.putOpt("session_id", this.bYp);
            jSONObject2.putOpt("handle_id", bigInteger);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void setAppId(String str) {
        this.mAppId = str;
    }

    public void setDisplayName(String str) {
        this.mDisplayName = str;
    }

    public void setUserId(long j) {
        this.mUserId = j;
    }

    public void setVideoCodec(String str) {
        this.mVideoCodec = str.toLowerCase();
    }
}
