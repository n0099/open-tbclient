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
import org.webrtc.MediaStreamTrack;
import org.webrtc.SessionDescription;
/* loaded from: classes9.dex */
public class o {
    static OkHttpClient.Builder cgp = new OkHttpClient.Builder().connectionPool(new ConnectionPool(5, 1, TimeUnit.MINUTES)).addInterceptor(new Interceptor() { // from class: com.baidu.rtc.o.1
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
    static int cgq = 25000;
    private BigInteger cgN;
    private WebSocket cgR;
    private c cgr;
    private ConcurrentHashMap<String, d> cgS = new ConcurrentHashMap<>();
    private ConcurrentHashMap<BigInteger, b> cgu = new ConcurrentHashMap<>();
    private ConcurrentHashMap<BigInteger, b> cgs = new ConcurrentHashMap<>();
    private long mUserId = (Build.SERIAL.hashCode() % 100000) + 78657895;
    private String mDisplayName = "Android-rtc";
    private String mRoomName = "";
    private String mVideoCodec = "h264";
    private boolean cgw = true;
    private boolean cgv = true;
    private boolean mHasVideo = true;
    private boolean mHasAudio = true;
    private boolean ceV = false;
    private long mRoomId = -1160725808;
    private String mAppId = "";
    private String cgO = "";
    private String cgH = "";
    private String cgG = "";
    private String cgC = "";
    private String cgM = "";
    private BaiduRtcRoom.RtcLiveTransferMode cgJ = BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ANCHOR_TRASNSMISSION;
    private boolean cgA = false;
    private boolean cgE = false;
    private String cgI = "";
    private String cgD = "";
    private BaiduRtcRoom.RtcLiveTransferMode cgK = BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ANCHOR_TRASNSMISSION;
    private boolean cgB = false;
    private boolean cgF = false;
    private int cgz = 5000;
    private int cgL = 5000;
    public boolean cgx = true;
    public boolean cgy = true;
    volatile BaiduRtcRoom.e cgQ = null;
    private ConcurrentHashMap<BigInteger, BaiduRtcRoom.d> cgP = new ConcurrentHashMap<>();
    private Runnable cgt = new Runnable() { // from class: com.baidu.rtc.o.16
        @Override // java.lang.Runnable
        public void run() {
            o.this.abv();
            o.this.mHandler.postDelayed(o.this.cgt, o.cgq);
        }
    };
    private Handler mHandler = new Handler(Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: private */
    public void abu() {
        String c = c((Integer) 12);
        d dVar = new d();
        dVar.tid = c;
        dVar.ceD = new n() { // from class: com.baidu.rtc.o.18
            @Override // com.baidu.rtc.n
            public void au(JSONObject jSONObject) {
                o.this.cgN = new BigInteger(jSONObject.optJSONObject("data").optString("id"));
                o.this.mHandler.postDelayed(o.this.cgt, o.cgq);
                o.this.abw();
            }
        };
        dVar.ceC = new m() { // from class: com.baidu.rtc.o.19
            @Override // com.baidu.rtc.m
            public void at(JSONObject jSONObject) {
            }
        };
        this.cgS.put(c, dVar);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("janus", "create");
            jSONObject.putOpt("transaction", c);
            if (!this.cgM.isEmpty()) {
                jSONObject.putOpt("sdktag", this.cgM);
            }
            jSONObject.putOpt("sessionevent", true);
            jSONObject.putOpt("userevent", true);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        av(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abv() {
        String c = c((Integer) 12);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("janus", "keepalive");
            jSONObject.putOpt("session_id", this.cgN);
            jSONObject.putOpt("transaction", c);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        av(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abw() {
        String c = c((Integer) 12);
        d dVar = new d();
        dVar.tid = c;
        dVar.ceD = new n() { // from class: com.baidu.rtc.o.20
            @Override // com.baidu.rtc.n
            public void au(JSONObject jSONObject) {
                b bVar = new b();
                bVar.ces = new BigInteger(jSONObject.optJSONObject("data").optString("id"));
                bVar.cez = new e() { // from class: com.baidu.rtc.o.20.1
                    @Override // com.baidu.rtc.e
                    public void a(b bVar2) {
                        o.this.cgr.c(bVar2.ces);
                    }
                };
                bVar.ceB = new f() { // from class: com.baidu.rtc.o.20.2
                    @Override // com.baidu.rtc.f
                    public void a(b bVar2, JSONObject jSONObject2) {
                        o.this.cgr.a(bVar2.ces, jSONObject2);
                    }
                };
                o.this.cgu.put(bVar.ces, bVar);
                if (o.this.mRoomId == -1160725808) {
                    o.this.e(bVar);
                } else {
                    o.this.a(o.this.mRoomId, o.this.mRoomName, bVar);
                }
            }
        };
        dVar.ceC = new m() { // from class: com.baidu.rtc.o.21
            @Override // com.baidu.rtc.m
            public void at(JSONObject jSONObject) {
            }
        };
        this.cgS.put(c, dVar);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("janus", "attach");
            jSONObject.putOpt("plugin", "janus.plugin.videoroom");
            jSONObject.putOpt("transaction", c);
            jSONObject.putOpt("session_id", this.cgN);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        av(jSONObject);
    }

    private void av(JSONObject jSONObject) {
        this.cgR.send(jSONObject.toString());
        if (com.baidu.rtc.b.a.ceX) {
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
            jSONObject2.putOpt("session_id", this.cgN);
            jSONObject2.putOpt("handle_id", bVar.ces);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        av(jSONObject2);
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
            if (!this.cgH.isEmpty() && this.cgJ == BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ANCHOR_TRASNSMISSION) {
                jSONObject3.putOpt("url", this.cgH);
                if (!this.cgC.isEmpty()) {
                    jSONObject3.putOpt("mixTemplate", this.cgC);
                }
                jSONObject3.putOpt("mix", Boolean.valueOf(this.cgA));
                jSONObject2.putOpt("rtmp", jSONObject3);
            } else if (!this.cgI.isEmpty() && this.cgK == BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ANCHOR_TRASNSMISSION) {
                jSONObject3.putOpt("url", this.cgI);
                if (!this.cgD.isEmpty()) {
                    jSONObject3.putOpt("mixTemplate", this.cgD);
                }
                jSONObject3.putOpt("mix", Boolean.valueOf(this.cgB));
                jSONObject2.putOpt("rtmp", jSONObject3);
            }
            if (this.cgE) {
                jSONObject4.putOpt("rec", Boolean.valueOf(this.cgE));
                jSONObject2.putOpt("recording", jSONObject4);
            }
            jSONObject.putOpt("janus", "message");
            jSONObject.putOpt("body", jSONObject2);
            jSONObject.putOpt("transaction", c((Integer) 12));
            jSONObject.putOpt("session_id", this.cgN);
            jSONObject.putOpt("handle_id", bVar.ces);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        av(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(b bVar) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt("request", UbcStatConstant.ContentType.UBC_TYPE_IM_JOIN);
            jSONObject2.putOpt(UbcStatConstant.KEY_CONTENT_ROOM, Long.valueOf(this.mRoomId));
            jSONObject2.putOpt("ptype", "listener");
            jSONObject2.putOpt("feed", bVar.cey);
            jSONObject2.putOpt("id", Long.valueOf(this.mUserId));
            jSONObject2.putOpt("app_id", this.mAppId);
            jSONObject2.putOpt(DpStatConstants.KEY_ROOM_NAME, this.mRoomName);
            jSONObject2.putOpt("token", this.cgO);
            jSONObject2.putOpt("role", "listener");
            jSONObject.putOpt("janus", "message");
            jSONObject.putOpt("body", jSONObject2);
            jSONObject.putOpt("transaction", c((Integer) 12));
            jSONObject.putOpt("session_id", this.cgN);
            jSONObject.putOpt("handle_id", bVar.ces);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        av(jSONObject);
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
        if (com.baidu.rtc.b.a.ceX) {
            Log.i("WebSocketChannel", "onMessage" + str);
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("janus");
            if (optString.equals("success")) {
                String optString2 = jSONObject.optString("transaction");
                d dVar = this.cgS.get(optString2);
                if (dVar.ceD != null) {
                    dVar.ceD.au(jSONObject);
                }
                this.cgS.remove(optString2);
            } else if (optString.equals(BdStatsConstant.StatsType.ERROR)) {
                String optString3 = jSONObject.optString("transaction");
                d dVar2 = this.cgS.get(optString3);
                if (dVar2 != null && dVar2.ceC != null) {
                    dVar2.ceC.at(jSONObject);
                }
                this.cgS.remove(optString3);
                if (jSONObject.has(BdStatsConstant.StatsType.ERROR)) {
                    String optString4 = jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR).optString(TiebaInitialize.LogFields.REASON);
                    if (optString4.contains("Room is disbanded")) {
                        this.cgr.abh();
                    } else if (optString4.contains("User is kick out")) {
                        this.cgr.aQ(this.mUserId);
                    }
                }
            } else if (optString.equals("ack")) {
            } else {
                if (optString.equals("timeout")) {
                    this.mHandler.removeCallbacks(this.cgt);
                    this.cgr.abe();
                } else if (optString.equals("slowlink")) {
                    this.cgr.h(jSONObject.optBoolean("uplink"), jSONObject.optInt("nacks"));
                } else if (!optString.equals("sessionevent")) {
                    if (jSONObject.has("sender")) {
                        final b bVar = this.cgu.get(new BigInteger(jSONObject.optString("sender")));
                        if (bVar == null) {
                            Log.e("WebSocketChannel", "missing handle");
                        } else if (!optString.equals(NotificationCompat.CATEGORY_EVENT)) {
                            if (optString.equals("detached")) {
                                bVar.ceA.a(bVar);
                            } else if (optString.equals("webrtcup")) {
                                this.cgr.e(bVar.ces);
                            } else if (optString.equals("media")) {
                                this.cgr.a(bVar.ces, jSONObject.getString("type").contains("video") ? 1 : 0, jSONObject.getBoolean("receiving"));
                            } else if (optString.equals("hangup")) {
                                this.cgr.b(bVar.ces);
                            }
                        } else {
                            JSONObject optJSONObject = jSONObject.optJSONObject("plugindata").optJSONObject("data");
                            if (optJSONObject.optString("videoroom").equals("joined")) {
                                bVar.cez.a(bVar);
                            } else if (optJSONObject.optString("videoroom").equals(NotificationCompat.CATEGORY_EVENT)) {
                                if (optJSONObject.has("error_code")) {
                                    this.cgr.gT(optJSONObject.optInt("error_code"));
                                }
                                if (optJSONObject.optInt("error_code") == 436) {
                                    Log.e("WebSocketChannel", "error_code 436， so try again。");
                                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.rtc.o.17
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
                                    this.cgr.b(bigInteger, optString5);
                                    if (this.cgv && this.cgy) {
                                        d(bigInteger, optString5);
                                    }
                                    i++;
                                }
                            }
                            String optString6 = optJSONObject.optString("leaving");
                            if (!TextUtils.isEmpty(optString6) && !optString6.equals("ok")) {
                                this.cgr.a(bVar.ces, new BigInteger(optString6));
                                b bVar2 = this.cgs.get(new BigInteger(optString6));
                                if (bVar2 != null && bVar2.ceA != null) {
                                    bVar2.ceA.a(bVar2);
                                }
                            }
                            String optString7 = optJSONObject.optString("unpublished");
                            if (!TextUtils.isEmpty(optString7)) {
                                if (!optString7.equals("ok") && !optString7.equals("self")) {
                                    this.cgr.a(bVar.ces, new BigInteger(optString7));
                                    b bVar3 = this.cgs.get(new BigInteger(optString7));
                                    if (bVar3 != null && bVar3.ceA != null) {
                                        bVar3.ceA.a(bVar3);
                                    }
                                } else if (optString7.equals("self") && optJSONObject.has("servertrigger")) {
                                    this.cgr.b(bVar.ces);
                                }
                            }
                            JSONObject optJSONObject3 = jSONObject.optJSONObject("jsep");
                            if (optJSONObject3 != null) {
                                bVar.ceB.a(bVar, optJSONObject3);
                            }
                        }
                    }
                } else if (jSONObject.has("recvdata")) {
                    JSONObject optJSONObject4 = jSONObject.optJSONObject("recvdata");
                    if (!optJSONObject4.optBoolean("internal")) {
                        this.cgr.c(new BigInteger(optJSONObject4.optString("from")), optJSONObject4.optString("data"));
                        return;
                    }
                    BaiduRtcRoom.d dVar3 = this.cgP.get(BigInteger.valueOf(optJSONObject4.optLong("from")));
                    if (dVar3 != null) {
                        dVar3.attribute = optJSONObject4.optString("data");
                    }
                    this.cgr.a(new BigInteger(optJSONObject4.optString("from")), optJSONObject4.optString("data"));
                } else if (jSONObject.has("userevent")) {
                    JSONObject optJSONObject5 = jSONObject.optJSONObject("userevent");
                    if (optJSONObject5.has("joined")) {
                        BaiduRtcRoom.d dVar4 = new BaiduRtcRoom.d();
                        dVar4.userId = optJSONObject5.optLong("joined");
                        dVar4.userName = optJSONObject5.optString("display");
                        dVar4.attribute = optJSONObject5.optString(Config.EVENT_ATTR);
                        this.cgP.put(BigInteger.valueOf(dVar4.userId), dVar4);
                        this.cgr.a(new BigInteger(optJSONObject5.optString("joined")), optJSONObject5.optString("display"), "");
                    } else if (optJSONObject5.has("leaving")) {
                        this.cgP.remove(BigInteger.valueOf(optJSONObject5.optLong("leaving")));
                        this.cgr.d(new BigInteger(optJSONObject5.optString("leaving")));
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
                            this.cgP.put(bigInteger2, dVar5);
                            this.cgr.a(bigInteger2, optString8, "");
                            String optString9 = optJSONObject6.optString(Config.EVENT_ATTR);
                            if (!optString9.isEmpty()) {
                                this.cgr.a(bigInteger2, optString9);
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
                            this.cgr.aP(optLong);
                        } else if (valueOf.booleanValue() || valueOf2.booleanValue()) {
                        } else {
                            this.cgr.aR(optLong);
                        }
                    } else if (jSONObject.has("userkickout")) {
                        this.cgr.aQ(jSONObject.optJSONObject("userkickout").optLong("id"));
                    } else if (jSONObject.has("bypass_event")) {
                        JSONObject optJSONObject8 = jSONObject.optJSONObject("bypass_event");
                        BaiduRtcRoom.RtcLiveTransferMode rtcLiveTransferMode = optJSONObject8.optString("level").contains(UbcStatConstant.KEY_CONTENT_ROOM) ? BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ROOM_TRANSMISSION : BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ANCHOR_TRASNSMISSION;
                        String optString10 = optJSONObject8.optJSONObject("rtmp").optString("url");
                        String optString11 = optJSONObject8.optString("bypassStatus");
                        if (optString11.contains("success")) {
                            this.cgr.c(rtcLiveTransferMode, optString10);
                        } else if (optString11.contains(SmsLoginView.f.l)) {
                            this.cgr.a(rtcLiveTransferMode, optString10);
                        } else if (optString11.contains("break")) {
                            this.cgr.b(rtcLiveTransferMode, optString10);
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
                int size = o.this.cgu.size();
                for (int i = 0; i < size; i++) {
                    o.this.b((b) o.this.cgu.values().toArray()[i]);
                    try {
                        Thread.sleep(50L);
                    } catch (Exception e) {
                    }
                }
            }
        });
    }

    public void K(String str, boolean z) {
        String str2 = str + "?appid=" + this.mAppId + "&roomname=" + encodeURIComponent(this.mRoomName) + "&uid=" + this.mUserId + "&token=" + this.cgO;
        if (z) {
            str2 = str2 + "&compulsive=true";
        }
        if (com.baidu.rtc.b.a.ceX) {
            Log.i("WebSocketChannel", "connect url: " + str2);
        }
        this.cgR = cgp.connectTimeout(this.cgz, TimeUnit.MILLISECONDS).readTimeout(this.cgL, TimeUnit.MILLISECONDS).dns(new Dns() { // from class: com.baidu.rtc.o.10
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
                    return (List) futureTask.get(o.this.cgz, TimeUnit.MILLISECONDS);
                } catch (Exception e2) {
                    return null;
                }
            }
        }).build().newWebSocket(new Request.Builder().url(str2).build(), new WebSocketListener() { // from class: com.baidu.rtc.o.15
            @Override // okhttp3.WebSocketListener
            public void onClosed(WebSocket webSocket, int i, String str3) {
            }

            @Override // okhttp3.WebSocketListener
            public void onClosing(WebSocket webSocket, int i, String str3) {
                if (com.baidu.rtc.b.a.ceX) {
                    Log.i("WebSocketChannel", "onClosing");
                }
                if (o.this.cgr != null) {
                    o.this.cgr.abe();
                }
            }

            @Override // okhttp3.WebSocketListener
            public void onFailure(WebSocket webSocket, Throwable th, Response response) {
                if (th != null) {
                    Log.e("WebSocketChannel", "onFailure" + th.toString());
                } else {
                    Log.e("WebSocketChannel", "onFailure");
                }
                if (o.this.cgr == null) {
                    return;
                }
                if (th instanceof SocketTimeoutException) {
                    o.this.cgr.abg();
                } else if (th instanceof NumberFormatException) {
                    Log.e("WebSocketChannel", "onFailure: java.lang.NumberFormatException");
                } else if (th instanceof NullPointerException) {
                    Log.e("WebSocketChannel", "onFailure: java.lang.NullPointerException");
                } else if (!(th instanceof SSLException)) {
                    o.this.cgr.abf();
                } else {
                    Log.e("WebSocketChannel", "onFailure: SSLException");
                    o.this.cgr.abe();
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
                if (com.baidu.rtc.b.a.ceX) {
                    Log.i("WebSocketChannel", "onOpen");
                }
                o.this.abu();
            }
        });
    }

    public void a(long j, String str, final b bVar) {
        String c = c((Integer) 12);
        d dVar = new d();
        dVar.tid = c;
        dVar.ceD = new n() { // from class: com.baidu.rtc.o.5
            @Override // com.baidu.rtc.n
            public void au(JSONObject jSONObject) {
                o.this.c(bVar);
            }
        };
        dVar.ceC = new m() { // from class: com.baidu.rtc.o.6
            @Override // com.baidu.rtc.m
            public void at(JSONObject jSONObject) {
                o.this.c(bVar);
            }
        };
        this.cgS.put(c, dVar);
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
            if (!this.cgH.isEmpty() && this.cgJ == BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ROOM_TRANSMISSION) {
                jSONObject3.putOpt("url", this.cgH);
                if (!this.cgC.isEmpty()) {
                    jSONObject3.putOpt("mixTemplate", this.cgC);
                }
                jSONObject.putOpt("rtmp", jSONObject3);
            } else if (!this.cgI.isEmpty() && this.cgK == BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ROOM_TRANSMISSION) {
                jSONObject3.putOpt("url", this.cgI);
                if (!this.cgD.isEmpty()) {
                    jSONObject3.putOpt("mixTemplate", this.cgD);
                }
                jSONObject.putOpt("rtmp", jSONObject3);
            }
            if (this.cgE) {
                jSONObject4.putOpt("rec", Boolean.valueOf(this.cgE));
                jSONObject.putOpt("recording", jSONObject4);
            }
            jSONObject2.putOpt("janus", "message");
            jSONObject2.putOpt("body", jSONObject);
            jSONObject2.putOpt("transaction", c);
            jSONObject2.putOpt("session_id", this.cgN);
            jSONObject2.putOpt("handle_id", bVar.ces);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        av(jSONObject2);
    }

    public void a(BaiduRtcRoom.RtcLiveTransferMode rtcLiveTransferMode) {
        this.cgJ = rtcLiveTransferMode;
    }

    public void a(c cVar) {
        this.cgr = cVar;
    }

    public void a(String str, long j, boolean z) {
        String c = c((Integer) 12);
        d dVar = new d();
        dVar.tid = c;
        dVar.ceD = new n() { // from class: com.baidu.rtc.o.11
            @Override // com.baidu.rtc.n
            public void au(JSONObject jSONObject) {
            }
        };
        dVar.ceC = new m() { // from class: com.baidu.rtc.o.12
            @Override // com.baidu.rtc.m
            public void at(JSONObject jSONObject) {
            }
        };
        this.cgS.put(c, dVar);
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
            jSONObject2.putOpt("session_id", this.cgN);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        av(jSONObject2);
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
            jSONObject2.putOpt("session_id", this.cgN);
            jSONObject2.putOpt("handle_id", bigInteger);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        av(jSONObject2);
    }

    public void aO(long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("request", "kickoutuser");
            jSONObject.putOpt(UbcStatConstant.KEY_CONTENT_ROOM, Long.valueOf(this.mRoomId));
            jSONObject.putOpt("target", Long.valueOf(j));
            aw(jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public BaiduRtcRoom.d[] abx() {
        if (this.cgP.size() < 1) {
            return null;
        }
        BaiduRtcRoom.d[] dVarArr = new BaiduRtcRoom.d[this.cgP.size()];
        int i = 0;
        Iterator<BaiduRtcRoom.d> it = this.cgP.values().iterator();
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

    public void aw(JSONObject jSONObject) {
        String c = c((Integer) 12);
        d dVar = new d();
        dVar.tid = c;
        dVar.ceD = new n() { // from class: com.baidu.rtc.o.13
            @Override // com.baidu.rtc.n
            public void au(JSONObject jSONObject2) {
            }
        };
        dVar.ceC = new m() { // from class: com.baidu.rtc.o.14
            @Override // com.baidu.rtc.m
            public void at(JSONObject jSONObject2) {
            }
        };
        this.cgS.put(c, dVar);
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt("janus", "message");
            jSONObject2.putOpt("body", jSONObject);
            jSONObject2.putOpt("transaction", c);
            jSONObject2.putOpt("session_id", this.cgN);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        av(jSONObject2);
    }

    public void b(String str, boolean z, boolean z2, String str2, BaiduRtcRoom.RtcLiveTransferMode rtcLiveTransferMode) {
        this.cgI = str;
        this.cgB = z;
        this.cgF = z2;
        this.cgD = str2;
        this.cgK = rtcLiveTransferMode;
    }

    public void c(BigInteger bigInteger, SessionDescription sessionDescription) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject.putOpt("request", "configure");
            jSONObject.putOpt(MediaStreamTrack.AUDIO_TRACK_KIND, Boolean.valueOf(this.mHasAudio));
            jSONObject.putOpt("video", Boolean.valueOf(this.mHasVideo));
            if (this.ceV) {
                jSONObject.putOpt("data", Boolean.valueOf(this.ceV));
            }
            jSONObject2.putOpt("type", sessionDescription.type);
            jSONObject2.putOpt("sdp", sessionDescription.description);
            jSONObject3.putOpt("janus", "message");
            jSONObject3.putOpt("body", jSONObject);
            jSONObject3.putOpt("jsep", jSONObject2);
            jSONObject3.putOpt("transaction", c((Integer) 12));
            jSONObject3.putOpt("session_id", this.cgN);
            jSONObject3.putOpt("handle_id", bigInteger);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        av(jSONObject3);
    }

    public void d(long j, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("request", "forwardconfigure");
            jSONObject.putOpt(UbcStatConstant.KEY_CONTENT_ROOM, Long.valueOf(this.mRoomId));
            jSONObject.putOpt("target", Long.valueOf(j));
            jSONObject.putOpt(MediaStreamTrack.AUDIO_TRACK_KIND, Boolean.valueOf(!z));
            jSONObject.putOpt("video", Boolean.valueOf(!z));
            jSONObject.putOpt("data", Boolean.valueOf(!z));
            aw(jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void d(final BigInteger bigInteger, final String str) {
        String c = c((Integer) 12);
        d dVar = new d();
        dVar.tid = c;
        dVar.ceD = new n() { // from class: com.baidu.rtc.o.22
            @Override // com.baidu.rtc.n
            public void au(JSONObject jSONObject) {
                b bVar = new b();
                bVar.ces = new BigInteger(jSONObject.optJSONObject("data").optString("id"));
                bVar.cey = bigInteger;
                bVar.avb = str;
                bVar.ceB = new f() { // from class: com.baidu.rtc.o.22.1
                    @Override // com.baidu.rtc.f
                    public void a(b bVar2, JSONObject jSONObject2) {
                        o.this.cgr.b(bVar2.ces, jSONObject2);
                    }
                };
                bVar.ceA = new e() { // from class: com.baidu.rtc.o.22.2
                    @Override // com.baidu.rtc.e
                    public void a(b bVar2) {
                        o.this.f(bVar2);
                    }
                };
                o.this.cgu.put(bVar.ces, bVar);
                o.this.cgs.put(bVar.cey, bVar);
                o.this.d(bVar);
            }
        };
        dVar.ceC = new m() { // from class: com.baidu.rtc.o.2
            @Override // com.baidu.rtc.m
            public void at(JSONObject jSONObject) {
            }
        };
        this.cgS.put(c, dVar);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("janus", "attach");
            jSONObject.putOpt("plugin", "janus.plugin.videoroom");
            jSONObject.putOpt("transaction", c);
            jSONObject.putOpt("session_id", this.cgN);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        av(jSONObject);
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
            jSONObject3.putOpt("session_id", this.cgN);
            jSONObject3.putOpt("handle_id", bigInteger);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        av(jSONObject3);
    }

    public void dM(boolean z) {
        this.mHasAudio = z;
    }

    public void dN(boolean z) {
        this.ceV = z;
    }

    public void dO(boolean z) {
        this.mHasVideo = z;
    }

    public void dQ(boolean z) {
        this.cgv = z;
    }

    public void dR(boolean z) {
        this.cgw = z;
    }

    public void dS(boolean z) {
        this.cgx = z;
    }

    public void dT(boolean z) {
        this.cgy = z;
    }

    public void dU(boolean z) {
        this.cgA = z;
    }

    public void dV(boolean z) {
        this.cgE = z;
    }

    public void disbandRoom() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("request", "disbandroom");
            jSONObject.putOpt(UbcStatConstant.KEY_CONTENT_ROOM, Long.valueOf(this.mRoomId));
            aw(jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void e(final b bVar) {
        String c = c((Integer) 12);
        d dVar = new d();
        dVar.tid = c;
        dVar.ceD = new n() { // from class: com.baidu.rtc.o.7
            @Override // com.baidu.rtc.n
            public void au(JSONObject jSONObject) {
                o.this.mRoomId = jSONObject.optJSONObject("plugindata").optJSONObject("data").optLong(UbcStatConstant.KEY_CONTENT_ROOM);
                Log.v("createRoomWithoutRoomID", "Got RoomID:" + o.this.mRoomId);
                o.this.c(bVar);
            }
        };
        dVar.ceC = new m() { // from class: com.baidu.rtc.o.8
            @Override // com.baidu.rtc.m
            public void at(JSONObject jSONObject) {
                o.this.c(bVar);
            }
        };
        this.cgS.put(c, dVar);
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
            if (!this.cgH.isEmpty() && this.cgJ == BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ROOM_TRANSMISSION) {
                jSONObject3.putOpt("url", this.cgH);
                jSONObject3.putOpt("mixTemplate", this.cgC);
                jSONObject.putOpt("rtmp", jSONObject3);
            } else if (!this.cgI.isEmpty() && this.cgK == BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ROOM_TRANSMISSION) {
                jSONObject3.putOpt("url", this.cgI);
                if (!this.cgD.isEmpty()) {
                    jSONObject3.putOpt("mixTemplate", this.cgD);
                }
                jSONObject.putOpt("rtmp", jSONObject3);
            }
            if (this.cgE) {
                jSONObject4.putOpt("rec", Boolean.valueOf(this.cgE));
                jSONObject.putOpt("recording", jSONObject4);
            }
            jSONObject2.putOpt("janus", "message");
            jSONObject2.putOpt("body", jSONObject);
            jSONObject2.putOpt("transaction", c);
            jSONObject2.putOpt("session_id", this.cgN);
            jSONObject2.putOpt("handle_id", bVar.ces);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        av(jSONObject2);
    }

    public void f(final b bVar) {
        String c = c((Integer) 12);
        d dVar = new d();
        dVar.tid = c;
        dVar.ceD = new n() { // from class: com.baidu.rtc.o.3
            @Override // com.baidu.rtc.n
            public void au(JSONObject jSONObject) {
                o.this.cgr.a(bVar.ces, bVar.cey);
                o.this.cgu.remove(bVar.ces);
                o.this.cgs.remove(bVar.cey);
            }
        };
        dVar.ceC = new m() { // from class: com.baidu.rtc.o.4
            @Override // com.baidu.rtc.m
            public void at(JSONObject jSONObject) {
            }
        };
        this.cgS.put(c, dVar);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("janus", "detach");
            jSONObject.putOpt("transaction", c);
            jSONObject.putOpt("session_id", this.cgN);
            jSONObject.putOpt("handle_id", bVar.ces);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        av(jSONObject);
    }

    public void finalize() {
        this.mHandler.removeCallbacks(this.cgt);
        this.cgr = null;
        if (this.cgR != null) {
            this.cgR.close(1001, "going away");
        }
    }

    public void gV(int i) {
        this.cgz = i;
    }

    public void gW(int i) {
        this.cgL = i;
    }

    public long getRoomId() {
        return this.mRoomId;
    }

    public BigInteger i(BigInteger bigInteger) {
        return this.cgu.get(bigInteger) == null ? BigInteger.valueOf(0L) : this.cgu.get(bigInteger).cey;
    }

    public String j(BigInteger bigInteger) {
        if (this.cgP.get(bigInteger) == null) {
            return null;
        }
        return this.cgP.get(bigInteger).userName;
    }

    public void jI(String str) {
        this.cgC = str;
    }

    public void jJ(String str) {
        this.cgH = str;
    }

    public void jK(String str) {
        this.mRoomName = str;
    }

    public void jL(String str) {
        this.cgM = str;
    }

    public void jM(String str) {
        this.cgO = str;
    }

    public void k(BigInteger bigInteger) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.putOpt("completed", true);
            jSONObject2.putOpt("janus", "trickle");
            jSONObject2.putOpt("candidate", jSONObject);
            jSONObject2.putOpt("transaction", c((Integer) 12));
            jSONObject2.putOpt("session_id", this.cgN);
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

    public void setUserId(long j) {
        this.mUserId = j;
    }

    public void setVideoCodec(String str) {
        this.mVideoCodec = str.toLowerCase();
    }
}
