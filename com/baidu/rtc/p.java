package com.baidu.rtc;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.ala.recorder.video.AlaRecorderLog;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.down.request.db.DownloadDataConstants;
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
/* loaded from: classes10.dex */
public class p {
    static OkHttpClient.Builder cvO = new OkHttpClient.Builder().connectionPool(new ConnectionPool(5, 1, TimeUnit.MINUTES)).addInterceptor(new Interceptor() { // from class: com.baidu.rtc.p.1
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
    static int cvP = 25000;
    private c cvR;
    private Handler cvV;
    private BigInteger cwr;
    private WebSocket cwv;
    private ConcurrentHashMap<String, d> cwy = new ConcurrentHashMap<>();
    private ConcurrentHashMap<BigInteger, b> cvU = new ConcurrentHashMap<>();
    private ConcurrentHashMap<BigInteger, b> cvS = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, d> cvQ = new ConcurrentHashMap<>();
    private long mUserId = (Build.SERIAL.hashCode() % 100000) + 78657895;
    private String mDisplayName = "Android-rtc";
    private String mRoomName = "";
    private String mVideoCodec = KsMediaFormat.CODEC_NAME_H264;
    private boolean cvX = true;
    private boolean cvW = true;
    private boolean mHasVideo = true;
    private boolean mHasAudio = true;
    private boolean ctM = false;
    private long mRoomId = -1160725808;
    private String mAppId = "";
    private String cws = "";
    private String cwi = "";
    private String cwh = "";
    private String cwd = "";
    private String cwn = "";
    private String cwq = "";
    private BaiduRtcRoom.RtcLiveTransferMode cwk = BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ANCHOR_TRASNSMISSION;
    private boolean cwb = false;
    private boolean cwf = false;
    private String cwj = "";
    private String cwe = "";
    private BaiduRtcRoom.RtcLiveTransferMode cwl = BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ANCHOR_TRASNSMISSION;
    private boolean cwc = false;
    private boolean cwg = false;
    private int cwa = 5000;
    private int cwo = 5000;
    private int cww = 5000;
    public boolean cvY = true;
    public boolean cvZ = true;
    private String cwp = "";
    private String cwm = "";
    volatile BaiduRtcRoom.e cwu = null;
    private ConcurrentHashMap<BigInteger, BaiduRtcRoom.d> cwt = new ConcurrentHashMap<>();
    private Runnable cvT = new Runnable() { // from class: com.baidu.rtc.p.20
        @Override // java.lang.Runnable
        public void run() {
            p.this.aeR();
            p.this.mHandler.postDelayed(p.this.cvT, p.cvP);
        }
    };
    private Runnable cwx = new Runnable() { // from class: com.baidu.rtc.p.21
        @Override // java.lang.Runnable
        public void run() {
            if (p.this.cvR != null) {
                p.this.cvR.aeB();
            }
        }
    };
    private Handler mHandler = new Handler(Looper.getMainLooper());

    public p() {
        this.cvV = null;
        this.cvV = new Handler(Looper.getMainLooper());
    }

    private void aC(JSONObject jSONObject) {
        if (this.cwv != null) {
            this.cwv.send(jSONObject.toString());
        }
        if (com.baidu.rtc.a.a.ctP) {
            Log.i("WebSocketChannel", jSONObject.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aeR() {
        String e = e((Integer) 12);
        d dVar = new d();
        dVar.tid = e;
        dVar.ctq = new o() { // from class: com.baidu.rtc.p.5
            @Override // com.baidu.rtc.o
            public void aB(JSONObject jSONObject) {
                p.this.cvV.removeCallbacks(p.this.cwx);
            }
        };
        dVar.ctp = new n() { // from class: com.baidu.rtc.p.6
            @Override // com.baidu.rtc.n
            public void aA(JSONObject jSONObject) {
                p.this.cvV.removeCallbacks(p.this.cwx);
            }
        };
        this.cvQ.put(e, dVar);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("janus", "keepalive");
            jSONObject.putOpt("session_id", this.cwr);
            jSONObject.putOpt("transaction", e);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        this.cvV.removeCallbacks(this.cwx);
        this.cvV.postDelayed(this.cwx, this.cww);
        aC(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aeS() {
        String e = e((Integer) 12);
        d dVar = new d();
        dVar.tid = e;
        dVar.ctq = new o() { // from class: com.baidu.rtc.p.25
            @Override // com.baidu.rtc.o
            public void aB(JSONObject jSONObject) {
                b bVar = new b();
                bVar.cte = new BigInteger(jSONObject.optJSONObject("data").optString("id"));
                bVar.ctm = new e() { // from class: com.baidu.rtc.p.25.1
                    @Override // com.baidu.rtc.e
                    public void a(b bVar2) {
                        if (p.this.cvR != null) {
                            p.this.cvR.c(bVar2.cte);
                        }
                    }
                };
                bVar.cto = new f() { // from class: com.baidu.rtc.p.25.2
                    @Override // com.baidu.rtc.f
                    public void a(b bVar2, JSONObject jSONObject2) {
                        if (p.this.cvR != null) {
                            p.this.cvR.a(bVar2.cte, jSONObject2);
                        }
                    }
                };
                p.this.cvU.put(bVar.cte, bVar);
                if (p.this.cvR == null) {
                    return;
                }
                p.this.cvR.a(bVar.cte, p.this.mRoomId);
                if (p.this.mRoomId == -1160725808) {
                    p.this.e(bVar);
                } else {
                    p.this.a(p.this.mRoomId, p.this.mRoomName, bVar);
                }
            }
        };
        dVar.ctp = new n() { // from class: com.baidu.rtc.p.26
            @Override // com.baidu.rtc.n
            public void aA(JSONObject jSONObject) {
            }
        };
        this.cwy.put(e, dVar);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("janus", "attach");
            jSONObject.putOpt("plugin", "janus.plugin.videoroom");
            jSONObject.putOpt("transaction", e);
            jSONObject.putOpt("session_id", this.cwr);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        aC(jSONObject);
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
            jSONObject2.putOpt("session_id", this.cwr);
            jSONObject2.putOpt("handle_id", bVar.cte);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        aC(jSONObject2);
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
            if (!this.cwn.isEmpty()) {
                jSONObject2.putOpt("window_id_in_bypass", this.cwn);
            }
            if (!this.cwi.isEmpty() && this.cwk == BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ANCHOR_TRASNSMISSION) {
                jSONObject3.putOpt("url", this.cwi);
                if (!this.cwd.isEmpty()) {
                    jSONObject3.putOpt("mixTemplate", this.cwd);
                }
                jSONObject3.putOpt("mix", Boolean.valueOf(this.cwb));
                jSONObject2.putOpt(AlaRecorderLog.Protocol.RTMP, jSONObject3);
            } else if (!this.cwj.isEmpty() && this.cwl == BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ANCHOR_TRASNSMISSION) {
                jSONObject3.putOpt("url", this.cwj);
                if (!this.cwe.isEmpty()) {
                    jSONObject3.putOpt("mixTemplate", this.cwe);
                }
                jSONObject3.putOpt("mix", Boolean.valueOf(this.cwc));
                jSONObject2.putOpt(AlaRecorderLog.Protocol.RTMP, jSONObject3);
            }
            if (this.cwf) {
                jSONObject4.putOpt("rec", Boolean.valueOf(this.cwf));
                jSONObject2.putOpt("recording", jSONObject4);
            }
            jSONObject.putOpt("janus", "message");
            jSONObject.putOpt("body", jSONObject2);
            jSONObject.putOpt("transaction", e((Integer) 12));
            jSONObject.putOpt("session_id", this.cwr);
            jSONObject.putOpt("handle_id", bVar.cte);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        aC(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createSession() {
        String e = e((Integer) 12);
        d dVar = new d();
        dVar.tid = e;
        dVar.ctq = new o() { // from class: com.baidu.rtc.p.23
            @Override // com.baidu.rtc.o
            public void aB(JSONObject jSONObject) {
                p.this.cwr = new BigInteger(jSONObject.optJSONObject("data").optString("id"));
                p.this.mHandler.postDelayed(p.this.cvT, p.cvP);
                p.this.aeS();
            }
        };
        dVar.ctp = new n() { // from class: com.baidu.rtc.p.24
            @Override // com.baidu.rtc.n
            public void aA(JSONObject jSONObject) {
            }
        };
        this.cwy.put(e, dVar);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("janus", "create");
            jSONObject.putOpt("transaction", e);
            if (!this.cwq.isEmpty()) {
                jSONObject.putOpt("sdktag", this.cwq);
            }
            if (!this.cwm.isEmpty()) {
                jSONObject.putOpt("janusIp", this.cwm);
            }
            jSONObject.putOpt(DownloadDataConstants.Columns.COLUMN_URI, this.cwp);
            jSONObject.putOpt("sessionevent", true);
            jSONObject.putOpt("userevent", true);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        aC(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(b bVar) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt("request", UbcStatConstant.ContentType.UBC_TYPE_IM_JOIN);
            jSONObject2.putOpt(UbcStatConstant.KEY_CONTENT_ROOM, Long.valueOf(this.mRoomId));
            jSONObject2.putOpt("ptype", "listener");
            jSONObject2.putOpt(LogConfig.KEY_FEED, bVar.ctl);
            jSONObject2.putOpt("id", Long.valueOf(this.mUserId));
            jSONObject2.putOpt("app_id", this.mAppId);
            jSONObject2.putOpt(DpStatConstants.KEY_ROOM_NAME, this.mRoomName);
            jSONObject2.putOpt("token", this.cws);
            jSONObject2.putOpt("role", "listener");
            if (!this.cwn.isEmpty()) {
                jSONObject2.putOpt("window_id_in_bypass", this.cwn);
            }
            jSONObject.putOpt("janus", "message");
            jSONObject.putOpt("body", jSONObject2);
            jSONObject.putOpt("transaction", e((Integer) 12));
            jSONObject.putOpt("session_id", this.cwr);
            jSONObject.putOpt("handle_id", bVar.cte);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        aC(jSONObject);
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
        if (com.baidu.rtc.a.a.ctP) {
            Log.i("WebSocketChannel", "onMessage" + str);
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("janus");
            if (optString.equals("success")) {
                String optString2 = jSONObject.optString("transaction");
                d dVar = this.cwy.get(optString2);
                if (dVar != null && dVar.ctq != null) {
                    dVar.ctq.aB(jSONObject);
                }
                this.cwy.remove(optString2);
            } else if (optString.equals(BdStatsConstant.StatsType.ERROR)) {
                String optString3 = jSONObject.optString("transaction");
                d dVar2 = this.cwy.get(optString3);
                if (dVar2 != null && dVar2.ctp != null) {
                    dVar2.ctp.aA(jSONObject);
                }
                this.cwy.remove(optString3);
                if (jSONObject.has(BdStatsConstant.StatsType.ERROR)) {
                    String optString4 = jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR).optString(TiebaInitialize.LogFields.REASON);
                    if (optString4.contains("Room is disbanded")) {
                        if (this.cvR != null) {
                            this.cvR.aeA();
                        }
                    } else if (!optString4.contains("User is kick out") || this.cvR == null) {
                    } else {
                        this.cvR.bQ(this.mUserId);
                    }
                }
            } else if (optString.equals("ack")) {
                String optString5 = jSONObject.optString("transaction");
                d dVar3 = this.cvQ.get(optString5);
                if (dVar3 != null && dVar3.ctq != null) {
                    dVar3.ctq.aB(jSONObject);
                }
                this.cvQ.remove(optString5);
            } else if (optString.equals("timeout")) {
                this.mHandler.removeCallbacks(this.cvT);
                this.cvV.removeCallbacks(this.cwx);
                if (this.cvR != null) {
                    this.cvR.aex();
                }
            } else if (optString.equals("slowlink")) {
                this.cvR.g(jSONObject.optBoolean("uplink"), jSONObject.optInt("nacks"));
            } else if (!optString.equals("sessionevent")) {
                if (jSONObject.has("sender")) {
                    final b bVar = this.cvU.get(new BigInteger(jSONObject.optString("sender")));
                    if (bVar == null) {
                        Log.e("WebSocketChannel", "missing handle");
                    } else if (!optString.equals("event")) {
                        if (optString.equals("detached")) {
                            bVar.ctn.a(bVar);
                        } else if (optString.equals("webrtcup")) {
                            this.cvR.f(bVar.cte);
                        } else if (!optString.equals("media")) {
                            if (!optString.equals("hangup") || this.cvR == null) {
                                return;
                            }
                            this.cvR.b(bVar.cte);
                        } else {
                            boolean z = jSONObject.getBoolean("receiving");
                            String string = jSONObject.getString("type");
                            if (this.cvR != null) {
                                this.cvR.a(bVar.cte, string.contains("video") ? 1 : 0, z);
                            }
                        }
                    } else {
                        JSONObject optJSONObject = jSONObject.optJSONObject("plugindata").optJSONObject("data");
                        if (optJSONObject.optString("videoroom").equals("joined")) {
                            bVar.ctm.a(bVar);
                        } else if (optJSONObject.optString("videoroom").equals("event")) {
                            if (optJSONObject.has("error_code")) {
                                this.cvR.fS(optJSONObject.optInt("error_code"));
                            }
                            if (optJSONObject.optInt("error_code") == 436) {
                                Log.e("WebSocketChannel", "error_code 436， so try again。");
                                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.rtc.p.22
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
                                String optString6 = optJSONObject2.optString("display");
                                this.cvR.b(bigInteger, optString6);
                                if (this.cvW && this.cvZ) {
                                    d(bigInteger, optString6);
                                }
                                i++;
                            }
                        }
                        String optString7 = optJSONObject.optString("leaving");
                        if (!TextUtils.isEmpty(optString7) && !optString7.equals("ok")) {
                            this.cvR.a(bVar.cte, new BigInteger(optString7));
                            b bVar2 = this.cvS.get(new BigInteger(optString7));
                            if (bVar2 != null && bVar2.ctn != null) {
                                bVar2.ctn.a(bVar2);
                            }
                        }
                        String optString8 = optJSONObject.optString("unpublished");
                        if (!TextUtils.isEmpty(optString8)) {
                            if (!optString8.equals("ok") && !optString8.equals("self")) {
                                this.cvR.a(bVar.cte, new BigInteger(optString8));
                                b bVar3 = this.cvS.get(new BigInteger(optString8));
                                if (bVar3 != null && bVar3.ctn != null) {
                                    bVar3.ctn.a(bVar3);
                                }
                            } else if (optString8.equals("self") && optJSONObject.has("servertrigger")) {
                                this.cvR.b(bVar.cte);
                            }
                        }
                        JSONObject optJSONObject3 = jSONObject.optJSONObject("jsep");
                        if (optJSONObject3 != null) {
                            bVar.cto.a(bVar, optJSONObject3);
                        }
                    }
                }
            } else if (jSONObject.has("recvdata")) {
                JSONObject optJSONObject4 = jSONObject.optJSONObject("recvdata");
                if (!optJSONObject4.optBoolean("internal")) {
                    this.cvR.c(new BigInteger(optJSONObject4.optString("from")), optJSONObject4.optString("data"));
                    return;
                }
                BaiduRtcRoom.d dVar4 = this.cwt.get(BigInteger.valueOf(optJSONObject4.optLong("from")));
                if (dVar4 != null) {
                    dVar4.attribute = optJSONObject4.optString("data");
                }
                this.cvR.a(new BigInteger(optJSONObject4.optString("from")), optJSONObject4.optString("data"));
            } else if (jSONObject.has("userevent")) {
                JSONObject optJSONObject5 = jSONObject.optJSONObject("userevent");
                if (optJSONObject5.has("joined")) {
                    BaiduRtcRoom.d dVar5 = new BaiduRtcRoom.d();
                    dVar5.userId = optJSONObject5.optLong("joined");
                    dVar5.userName = optJSONObject5.optString("display");
                    dVar5.attribute = optJSONObject5.optString(Config.EVENT_ATTR);
                    this.cwt.put(BigInteger.valueOf(dVar5.userId), dVar5);
                    this.cvR.a(new BigInteger(optJSONObject5.optString("joined")), optJSONObject5.optString("display"), "");
                } else if (optJSONObject5.has("leaving")) {
                    this.cwt.remove(BigInteger.valueOf(optJSONObject5.optLong("leaving")));
                    this.cvR.e(new BigInteger(optJSONObject5.optString("leaving")));
                } else if (!optJSONObject5.has("users") || (optJSONArray = optJSONObject5.optJSONArray("users")) == null || optJSONArray.length() <= 0) {
                } else {
                    int length2 = optJSONArray.length();
                    while (i <= length2 - 1) {
                        JSONObject optJSONObject6 = optJSONArray.optJSONObject(i);
                        BigInteger bigInteger2 = new BigInteger(optJSONObject6.optString("id"));
                        String optString9 = optJSONObject6.optString("display");
                        BaiduRtcRoom.d dVar6 = new BaiduRtcRoom.d();
                        dVar6.userId = optJSONObject6.optLong("id");
                        dVar6.userName = optJSONObject6.optString("display");
                        dVar6.attribute = optJSONObject6.optString(Config.EVENT_ATTR);
                        this.cwt.put(bigInteger2, dVar6);
                        this.cvR.a(bigInteger2, optString9, "");
                        String optString10 = optJSONObject6.optString(Config.EVENT_ATTR);
                        if (!optString10.isEmpty()) {
                            this.cvR.a(bigInteger2, optString10);
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
                        this.cvR.bP(optLong);
                    } else if (valueOf.booleanValue() || valueOf2.booleanValue()) {
                    } else {
                        this.cvR.bR(optLong);
                    }
                } else if (jSONObject.has("userkickout")) {
                    this.cvR.bQ(jSONObject.optJSONObject("userkickout").optLong("id"));
                } else if (jSONObject.has("bypass_event")) {
                    JSONObject optJSONObject8 = jSONObject.optJSONObject("bypass_event");
                    BaiduRtcRoom.RtcLiveTransferMode rtcLiveTransferMode = optJSONObject8.optString("level").contains(UbcStatConstant.KEY_CONTENT_ROOM) ? BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ROOM_TRANSMISSION : BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ANCHOR_TRASNSMISSION;
                    String str2 = "";
                    if (optJSONObject8.has(AlaRecorderLog.Protocol.RTMP)) {
                        JSONObject optJSONObject9 = optJSONObject8.optJSONObject(AlaRecorderLog.Protocol.RTMP);
                        if (optJSONObject9.has("url")) {
                            str2 = optJSONObject9.optString("url");
                        }
                    }
                    String optString11 = optJSONObject8.optString("bypassStatus");
                    if (optString11.contains("success")) {
                        this.cvR.c(rtcLiveTransferMode, str2);
                    } else if (optString11.contains(SmsLoginView.f.l)) {
                        this.cvR.a(rtcLiveTransferMode, str2);
                    } else if (optString11.contains("break")) {
                        this.cvR.b(rtcLiveTransferMode, str2);
                    }
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void K(String str, boolean z) {
        this.cwp = str;
        String str2 = str + "?appid=" + this.mAppId + "&roomname=" + encodeURIComponent(this.mRoomName) + "&uid=" + this.mUserId + "&token=" + this.cws;
        if (z) {
            str2 = str2 + "&compulsive=true";
        }
        if (com.baidu.rtc.a.a.ctP) {
            Log.i("WebSocketChannel", "connect url: " + str2);
        }
        this.cwv = cvO.connectTimeout(this.cwa, TimeUnit.MILLISECONDS).readTimeout(this.cwo, TimeUnit.MILLISECONDS).dns(new Dns() { // from class: com.baidu.rtc.p.11
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
                    FutureTask futureTask = new FutureTask(new Callable<List<InetAddress>>() { // from class: com.baidu.rtc.p.11.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // java.util.concurrent.Callable
                        public List<InetAddress> call() throws Exception {
                            return Arrays.asList(InetAddress.getAllByName(str3));
                        }
                    });
                    new Thread(futureTask).start();
                    return (List) futureTask.get(p.this.cwa, TimeUnit.MILLISECONDS);
                } catch (Exception e2) {
                    return null;
                }
            }
        }).build().newWebSocket(new Request.Builder().url(str2).build(), new WebSocketListener() { // from class: com.baidu.rtc.p.17
            @Override // okhttp3.WebSocketListener
            public void onClosed(WebSocket webSocket, int i, String str3) {
                if (com.baidu.rtc.a.a.ctP) {
                    Log.i("WebSocketChannel", "onClosed");
                }
            }

            @Override // okhttp3.WebSocketListener
            public void onClosing(WebSocket webSocket, int i, String str3) {
                if (com.baidu.rtc.a.a.ctP) {
                    Log.i("WebSocketChannel", "onClosing");
                }
                if (p.this.cvR != null) {
                    p.this.cvR.aex();
                }
            }

            @Override // okhttp3.WebSocketListener
            public void onFailure(WebSocket webSocket, Throwable th, Response response) {
                if (th != null) {
                    Log.e("WebSocketChannel", "onFailure" + th.toString());
                } else {
                    Log.e("WebSocketChannel", "onFailure");
                }
                if (p.this.cvR == null) {
                    return;
                }
                if (th instanceof SocketTimeoutException) {
                    if (p.this.cvR != null) {
                        p.this.cvR.aez();
                    }
                } else if (th instanceof NumberFormatException) {
                    Log.e("WebSocketChannel", "onFailure: java.lang.NumberFormatException");
                } else if (th instanceof NullPointerException) {
                    Log.e("WebSocketChannel", "onFailure: java.lang.NullPointerException");
                } else if (!(th instanceof SSLException)) {
                    if (p.this.cvR != null) {
                        p.this.cvR.aey();
                    }
                } else {
                    Log.e("WebSocketChannel", "onFailure: SSLException");
                    if (p.this.cvR != null) {
                        p.this.cvR.aex();
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
                if (com.baidu.rtc.a.a.ctP) {
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
        dVar.ctq = new o() { // from class: com.baidu.rtc.p.7
            @Override // com.baidu.rtc.o
            public void aB(JSONObject jSONObject) {
                p.this.c(bVar);
            }
        };
        dVar.ctp = new n() { // from class: com.baidu.rtc.p.8
            @Override // com.baidu.rtc.n
            public void aA(JSONObject jSONObject) {
                p.this.c(bVar);
            }
        };
        this.cwy.put(e, dVar);
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
            if (!this.cwi.isEmpty() && this.cwk == BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ROOM_TRANSMISSION) {
                jSONObject3.putOpt("url", this.cwi);
                if (!this.cwd.isEmpty()) {
                    jSONObject3.putOpt("mixTemplate", this.cwd);
                }
                jSONObject.putOpt(AlaRecorderLog.Protocol.RTMP, jSONObject3);
            } else if (!this.cwj.isEmpty() && this.cwl == BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ROOM_TRANSMISSION) {
                jSONObject3.putOpt("url", this.cwj);
                if (!this.cwe.isEmpty()) {
                    jSONObject3.putOpt("mixTemplate", this.cwe);
                }
                jSONObject.putOpt(AlaRecorderLog.Protocol.RTMP, jSONObject3);
            }
            if (this.cwf) {
                jSONObject4.putOpt("rec", Boolean.valueOf(this.cwf));
                jSONObject.putOpt("recording", jSONObject4);
            }
            jSONObject2.putOpt("janus", "message");
            jSONObject2.putOpt("body", jSONObject);
            jSONObject2.putOpt("transaction", e);
            jSONObject2.putOpt("session_id", this.cwr);
            jSONObject2.putOpt("handle_id", bVar.cte);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        aC(jSONObject2);
    }

    public void a(c cVar) {
        this.cvR = cVar;
    }

    public void a(String str, long j, boolean z) {
        String e = e((Integer) 12);
        d dVar = new d();
        dVar.tid = e;
        dVar.ctq = new o() { // from class: com.baidu.rtc.p.13
            @Override // com.baidu.rtc.o
            public void aB(JSONObject jSONObject) {
            }
        };
        dVar.ctp = new n() { // from class: com.baidu.rtc.p.14
            @Override // com.baidu.rtc.n
            public void aA(JSONObject jSONObject) {
            }
        };
        this.cwy.put(e, dVar);
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
            jSONObject2.putOpt("session_id", this.cwr);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        aC(jSONObject2);
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
            jSONObject2.putOpt("session_id", this.cwr);
            jSONObject2.putOpt("handle_id", bigInteger);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        aC(jSONObject2);
    }

    public void aD(JSONObject jSONObject) {
        String e = e((Integer) 12);
        d dVar = new d();
        dVar.tid = e;
        dVar.ctq = new o() { // from class: com.baidu.rtc.p.18
            @Override // com.baidu.rtc.o
            public void aB(JSONObject jSONObject2) {
            }
        };
        dVar.ctp = new n() { // from class: com.baidu.rtc.p.19
            @Override // com.baidu.rtc.n
            public void aA(JSONObject jSONObject2) {
            }
        };
        this.cwy.put(e, dVar);
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt("janus", "message");
            jSONObject2.putOpt("body", jSONObject);
            jSONObject2.putOpt("transaction", e);
            jSONObject2.putOpt("session_id", this.cwr);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        aC(jSONObject2);
    }

    public void b(BaiduRtcRoom.RtcLiveTransferMode rtcLiveTransferMode) {
        this.cwk = rtcLiveTransferMode;
    }

    public void bO(long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("request", "kickoutuser");
            jSONObject.putOpt(UbcStatConstant.KEY_CONTENT_ROOM, Long.valueOf(this.mRoomId));
            jSONObject.putOpt("target", Long.valueOf(j));
            aD(jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void c(BaiduRtcRoom.RtcLiveTransferMode rtcLiveTransferMode) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("request", "stopbypass");
            jSONObject.putOpt("level", rtcLiveTransferMode == BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ANCHOR_TRASNSMISSION ? "anchor" : UbcStatConstant.KEY_CONTENT_ROOM);
            jSONObject.putOpt(UbcStatConstant.KEY_CONTENT_ROOM, Long.valueOf(this.mRoomId));
            jSONObject.putOpt("id", Long.valueOf(this.mUserId));
            aD(jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void c(String str, boolean z, boolean z2, String str2, BaiduRtcRoom.RtcLiveTransferMode rtcLiveTransferMode) {
        this.cwj = str;
        this.cwc = z;
        this.cwg = z2;
        this.cwe = str2;
        this.cwl = rtcLiveTransferMode;
    }

    public void c(BigInteger bigInteger, SessionDescription sessionDescription) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject.putOpt("request", "configure");
            jSONObject.putOpt("audio", Boolean.valueOf(this.mHasAudio));
            jSONObject.putOpt("video", Boolean.valueOf(this.mHasVideo));
            if (this.ctM) {
                jSONObject.putOpt("data", Boolean.valueOf(this.ctM));
            }
            jSONObject2.putOpt("type", sessionDescription.type);
            jSONObject2.putOpt("sdp", sessionDescription.description);
            jSONObject3.putOpt("janus", "message");
            jSONObject3.putOpt("body", jSONObject);
            jSONObject3.putOpt("jsep", jSONObject2);
            jSONObject3.putOpt("transaction", e((Integer) 12));
            jSONObject3.putOpt("session_id", this.cwr);
            jSONObject3.putOpt("handle_id", bigInteger);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        aC(jSONObject3);
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
            aD(jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void d(String str, boolean z, boolean z2, String str2, BaiduRtcRoom.RtcLiveTransferMode rtcLiveTransferMode) {
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject.putOpt("request", "startbypass");
            jSONObject.putOpt("level", rtcLiveTransferMode == BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ANCHOR_TRASNSMISSION ? "anchor" : UbcStatConstant.KEY_CONTENT_ROOM);
            jSONObject.putOpt(UbcStatConstant.KEY_CONTENT_ROOM, Long.valueOf(this.mRoomId));
            jSONObject.putOpt("id", Long.valueOf(this.mUserId));
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.putOpt("url", str);
            jSONObject3.putOpt("mix", Boolean.valueOf(z));
            jSONObject3.putOpt("mixTemplate", str2);
            jSONObject.putOpt(AlaRecorderLog.Protocol.RTMP, jSONObject3);
            if (z2) {
                jSONObject2.putOpt("rec", Boolean.valueOf(z2));
                jSONObject.putOpt("recording", jSONObject2);
            }
            aD(jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void d(final BigInteger bigInteger, final String str) {
        String e = e((Integer) 12);
        d dVar = new d();
        dVar.tid = e;
        dVar.ctq = new o() { // from class: com.baidu.rtc.p.27
            @Override // com.baidu.rtc.o
            public void aB(JSONObject jSONObject) {
                b bVar = new b();
                bVar.cte = new BigInteger(jSONObject.optJSONObject("data").optString("id"));
                bVar.ctl = bigInteger;
                bVar.ctk = str;
                bVar.cto = new f() { // from class: com.baidu.rtc.p.27.1
                    @Override // com.baidu.rtc.f
                    public void a(b bVar2, JSONObject jSONObject2) {
                        p.this.cvR.b(bVar2.cte, jSONObject2);
                    }
                };
                bVar.ctn = new e() { // from class: com.baidu.rtc.p.27.2
                    @Override // com.baidu.rtc.e
                    public void a(b bVar2) {
                        p.this.f(bVar2);
                    }
                };
                p.this.cvU.put(bVar.cte, bVar);
                p.this.cvS.put(bVar.ctl, bVar);
                p.this.d(bVar);
            }
        };
        dVar.ctp = new n() { // from class: com.baidu.rtc.p.2
            @Override // com.baidu.rtc.n
            public void aA(JSONObject jSONObject) {
            }
        };
        this.cwy.put(e, dVar);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("janus", "attach");
            jSONObject.putOpt("plugin", "janus.plugin.videoroom");
            jSONObject.putOpt("transaction", e);
            jSONObject.putOpt("session_id", this.cwr);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        aC(jSONObject);
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
            jSONObject3.putOpt("session_id", this.cwr);
            jSONObject3.putOpt("handle_id", bigInteger);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        aC(jSONObject3);
    }

    public void disbandRoom() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("request", "disbandroom");
            jSONObject.putOpt(UbcStatConstant.KEY_CONTENT_ROOM, Long.valueOf(this.mRoomId));
            aD(jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void e(final b bVar) {
        String e = e((Integer) 12);
        d dVar = new d();
        dVar.tid = e;
        dVar.ctq = new o() { // from class: com.baidu.rtc.p.9
            @Override // com.baidu.rtc.o
            public void aB(JSONObject jSONObject) {
                p.this.mRoomId = jSONObject.optJSONObject("plugindata").optJSONObject("data").optLong(UbcStatConstant.KEY_CONTENT_ROOM);
                Log.v("createRoomWithoutRoomID", "Got RoomID:" + p.this.mRoomId);
                p.this.c(bVar);
            }
        };
        dVar.ctp = new n() { // from class: com.baidu.rtc.p.10
            @Override // com.baidu.rtc.n
            public void aA(JSONObject jSONObject) {
                p.this.c(bVar);
            }
        };
        this.cwy.put(e, dVar);
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
            if (!this.cwi.isEmpty() && this.cwk == BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ROOM_TRANSMISSION) {
                jSONObject3.putOpt("url", this.cwi);
                jSONObject3.putOpt("mixTemplate", this.cwd);
                jSONObject.putOpt(AlaRecorderLog.Protocol.RTMP, jSONObject3);
            } else if (!this.cwj.isEmpty() && this.cwl == BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ROOM_TRANSMISSION) {
                jSONObject3.putOpt("url", this.cwj);
                if (!this.cwe.isEmpty()) {
                    jSONObject3.putOpt("mixTemplate", this.cwe);
                }
                jSONObject.putOpt(AlaRecorderLog.Protocol.RTMP, jSONObject3);
            }
            if (this.cwf) {
                jSONObject4.putOpt("rec", Boolean.valueOf(this.cwf));
                jSONObject.putOpt("recording", jSONObject4);
            }
            jSONObject2.putOpt("janus", "message");
            jSONObject2.putOpt("body", jSONObject);
            jSONObject2.putOpt("transaction", e);
            jSONObject2.putOpt("session_id", this.cwr);
            jSONObject2.putOpt("handle_id", bVar.cte);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        aC(jSONObject2);
    }

    public void eA(boolean z) {
        this.cvY = z;
    }

    public void eB(boolean z) {
        this.cvZ = z;
    }

    public void eC(boolean z) {
        this.cwb = z;
    }

    public void eD(boolean z) {
        this.cwf = z;
    }

    public void et(boolean z) {
        this.mHasAudio = z;
    }

    public void eu(boolean z) {
        this.ctM = z;
    }

    public void ev(boolean z) {
        this.mHasVideo = z;
    }

    public void ey(boolean z) {
        this.cvW = z;
    }

    public void ez(boolean z) {
        this.cvX = z;
    }

    public void f(final b bVar) {
        String e = e((Integer) 12);
        d dVar = new d();
        dVar.tid = e;
        dVar.ctq = new o() { // from class: com.baidu.rtc.p.3
            @Override // com.baidu.rtc.o
            public void aB(JSONObject jSONObject) {
                p.this.cvR.a(bVar.cte, bVar.ctl);
                p.this.cvR.d(bVar.cte);
                p.this.cvU.remove(bVar.cte);
                p.this.cvS.remove(bVar.ctl);
            }
        };
        dVar.ctp = new n() { // from class: com.baidu.rtc.p.4
            @Override // com.baidu.rtc.n
            public void aA(JSONObject jSONObject) {
            }
        };
        this.cwy.put(e, dVar);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("janus", "detach");
            jSONObject.putOpt("transaction", e);
            jSONObject.putOpt("session_id", this.cwr);
            jSONObject.putOpt("handle_id", bVar.cte);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        aC(jSONObject);
    }

    public void fU(int i) {
        this.cwa = i;
    }

    public void fV(int i) {
        this.cwo = i;
    }

    public void finalize() {
        this.mHandler.removeCallbacks(this.cvT);
        this.cvV.removeCallbacks(this.cwx);
        this.cvR = null;
        if (this.cwv != null) {
            this.cwv.close(1001, "going away");
        }
    }

    public long getRoomId() {
        return this.mRoomId;
    }

    public void jA(String str) {
        this.mRoomName = str;
    }

    public void jB(String str) {
        this.cwq = str;
    }

    public void jC(String str) {
        this.cws = str;
    }

    public void jw(String str) {
        this.cwd = str;
    }

    public void jx(String str) {
        this.cwi = str;
    }

    public void jy(String str) {
        this.cwm = str;
    }

    public void jz(String str) {
        this.cwn = str;
    }

    public BigInteger k(BigInteger bigInteger) {
        return this.cvU.get(bigInteger) == null ? BigInteger.valueOf(0L) : this.cvU.get(bigInteger).ctl;
    }

    public b l(BigInteger bigInteger) {
        return this.cvS.get(bigInteger);
    }

    public String m(BigInteger bigInteger) {
        if (this.cwt.get(bigInteger) == null) {
            return null;
        }
        return this.cwt.get(bigInteger).userName;
    }

    public void n(BigInteger bigInteger) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.putOpt("completed", true);
            jSONObject2.putOpt("janus", "trickle");
            jSONObject2.putOpt("candidate", jSONObject);
            jSONObject2.putOpt("transaction", e((Integer) 12));
            jSONObject2.putOpt("session_id", this.cwr);
            jSONObject2.putOpt("handle_id", bigInteger);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void o(BigInteger bigInteger) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.putOpt("request", "unpublish");
            jSONObject2.putOpt("janus", "message");
            jSONObject2.putOpt("body", jSONObject);
            jSONObject2.putOpt("transaction", e((Integer) 12));
            jSONObject2.putOpt("session_id", this.cwr);
            jSONObject2.putOpt("handle_id", bigInteger);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        aC(jSONObject2);
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
        dVar.ctq = new o() { // from class: com.baidu.rtc.p.15
            @Override // com.baidu.rtc.o
            public void aB(JSONObject jSONObject) {
                p.this.a(str, 0L, true);
            }
        };
        dVar.ctp = new n() { // from class: com.baidu.rtc.p.16
            @Override // com.baidu.rtc.n
            public void aA(JSONObject jSONObject) {
            }
        };
        this.cwy.put(e, dVar);
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
            jSONObject2.putOpt("session_id", this.cwr);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        aC(jSONObject2);
    }

    public void setUserId(long j) {
        this.mUserId = j;
    }

    public void setVideoCodec(String str) {
        this.mVideoCodec = str.toLowerCase();
    }

    public void yo() {
        this.mHandler.post(new Runnable() { // from class: com.baidu.rtc.p.12
            @Override // java.lang.Runnable
            public void run() {
                int size = p.this.cvU.size();
                for (int i = 0; i < size; i++) {
                    p.this.b((b) p.this.cvU.values().toArray()[i]);
                    try {
                        Thread.sleep(50L);
                    } catch (Exception e) {
                    }
                }
            }
        });
    }
}
