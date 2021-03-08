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
/* loaded from: classes9.dex */
public class p {
    static OkHttpClient.Builder cxo = new OkHttpClient.Builder().connectionPool(new ConnectionPool(5, 1, TimeUnit.MINUTES)).addInterceptor(new Interceptor() { // from class: com.baidu.rtc.p.1
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
    static int cxp = 25000;
    private BigInteger cxR;
    private WebSocket cxV;
    private c cxr;
    private Handler cxv;
    private ConcurrentHashMap<String, d> cxY = new ConcurrentHashMap<>();
    private ConcurrentHashMap<BigInteger, b> cxu = new ConcurrentHashMap<>();
    private ConcurrentHashMap<BigInteger, b> cxs = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, d> cxq = new ConcurrentHashMap<>();
    private long mUserId = (Build.SERIAL.hashCode() % 100000) + 78657895;
    private String mDisplayName = "Android-rtc";
    private String mRoomName = "";
    private String mVideoCodec = KsMediaFormat.CODEC_NAME_H264;
    private boolean cxx = true;
    private boolean cxw = true;
    private boolean mHasVideo = true;
    private boolean mHasAudio = true;
    private boolean cvo = false;
    private long mRoomId = -1160725808;
    private String mAppId = "";
    private String cxS = "";
    private String cxI = "";
    private String cxH = "";
    private String cxD = "";
    private String cxN = "";
    private String cxQ = "";
    private BaiduRtcRoom.RtcLiveTransferMode cxK = BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ANCHOR_TRASNSMISSION;
    private boolean cxB = false;
    private boolean cxF = false;
    private String cxJ = "";
    private String cxE = "";
    private BaiduRtcRoom.RtcLiveTransferMode cxL = BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ANCHOR_TRASNSMISSION;
    private boolean cxC = false;
    private boolean cxG = false;
    private int cxA = 5000;
    private int cxO = 5000;
    private int cxW = 5000;
    public boolean cxy = true;
    public boolean cxz = true;
    private String cxP = "";
    private String cxM = "";
    volatile BaiduRtcRoom.e cxU = null;
    private ConcurrentHashMap<BigInteger, BaiduRtcRoom.d> cxT = new ConcurrentHashMap<>();
    private Runnable cxt = new Runnable() { // from class: com.baidu.rtc.p.20
        @Override // java.lang.Runnable
        public void run() {
            p.this.aeU();
            p.this.mHandler.postDelayed(p.this.cxt, p.cxp);
        }
    };
    private Runnable cxX = new Runnable() { // from class: com.baidu.rtc.p.21
        @Override // java.lang.Runnable
        public void run() {
            if (p.this.cxr != null) {
                p.this.cxr.aeE();
            }
        }
    };
    private Handler mHandler = new Handler(Looper.getMainLooper());

    public p() {
        this.cxv = null;
        this.cxv = new Handler(Looper.getMainLooper());
    }

    private void aE(JSONObject jSONObject) {
        if (this.cxV != null) {
            this.cxV.send(jSONObject.toString());
        }
        if (com.baidu.rtc.a.a.cvr) {
            Log.i("WebSocketChannel", jSONObject.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aeU() {
        String e = e((Integer) 12);
        d dVar = new d();
        dVar.tid = e;
        dVar.cuV = new o() { // from class: com.baidu.rtc.p.5
            @Override // com.baidu.rtc.o
            public void aD(JSONObject jSONObject) {
                p.this.cxv.removeCallbacks(p.this.cxX);
            }
        };
        dVar.cuU = new n() { // from class: com.baidu.rtc.p.6
            @Override // com.baidu.rtc.n
            public void aC(JSONObject jSONObject) {
                p.this.cxv.removeCallbacks(p.this.cxX);
            }
        };
        this.cxq.put(e, dVar);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("janus", "keepalive");
            jSONObject.putOpt("session_id", this.cxR);
            jSONObject.putOpt("transaction", e);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        this.cxv.removeCallbacks(this.cxX);
        this.cxv.postDelayed(this.cxX, this.cxW);
        aE(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aeV() {
        String e = e((Integer) 12);
        d dVar = new d();
        dVar.tid = e;
        dVar.cuV = new o() { // from class: com.baidu.rtc.p.25
            @Override // com.baidu.rtc.o
            public void aD(JSONObject jSONObject) {
                b bVar = new b();
                bVar.cuJ = new BigInteger(jSONObject.optJSONObject("data").optString("id"));
                bVar.cuR = new e() { // from class: com.baidu.rtc.p.25.1
                    @Override // com.baidu.rtc.e
                    public void a(b bVar2) {
                        if (p.this.cxr != null) {
                            p.this.cxr.c(bVar2.cuJ);
                        }
                    }
                };
                bVar.cuT = new f() { // from class: com.baidu.rtc.p.25.2
                    @Override // com.baidu.rtc.f
                    public void a(b bVar2, JSONObject jSONObject2) {
                        if (p.this.cxr != null) {
                            p.this.cxr.a(bVar2.cuJ, jSONObject2);
                        }
                    }
                };
                p.this.cxu.put(bVar.cuJ, bVar);
                if (p.this.cxr == null) {
                    return;
                }
                p.this.cxr.a(bVar.cuJ, p.this.mRoomId);
                if (p.this.mRoomId == -1160725808) {
                    p.this.e(bVar);
                } else {
                    p.this.a(p.this.mRoomId, p.this.mRoomName, bVar);
                }
            }
        };
        dVar.cuU = new n() { // from class: com.baidu.rtc.p.26
            @Override // com.baidu.rtc.n
            public void aC(JSONObject jSONObject) {
            }
        };
        this.cxY.put(e, dVar);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("janus", "attach");
            jSONObject.putOpt("plugin", "janus.plugin.videoroom");
            jSONObject.putOpt("transaction", e);
            jSONObject.putOpt("session_id", this.cxR);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        aE(jSONObject);
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
            jSONObject2.putOpt("session_id", this.cxR);
            jSONObject2.putOpt("handle_id", bVar.cuJ);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        aE(jSONObject2);
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
            if (!this.cxN.isEmpty()) {
                jSONObject2.putOpt("window_id_in_bypass", this.cxN);
            }
            if (!this.cxI.isEmpty() && this.cxK == BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ANCHOR_TRASNSMISSION) {
                jSONObject3.putOpt("url", this.cxI);
                if (!this.cxD.isEmpty()) {
                    jSONObject3.putOpt("mixTemplate", this.cxD);
                }
                jSONObject3.putOpt("mix", Boolean.valueOf(this.cxB));
                jSONObject2.putOpt(AlaRecorderLog.Protocol.RTMP, jSONObject3);
            } else if (!this.cxJ.isEmpty() && this.cxL == BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ANCHOR_TRASNSMISSION) {
                jSONObject3.putOpt("url", this.cxJ);
                if (!this.cxE.isEmpty()) {
                    jSONObject3.putOpt("mixTemplate", this.cxE);
                }
                jSONObject3.putOpt("mix", Boolean.valueOf(this.cxC));
                jSONObject2.putOpt(AlaRecorderLog.Protocol.RTMP, jSONObject3);
            }
            if (this.cxF) {
                jSONObject4.putOpt("rec", Boolean.valueOf(this.cxF));
                jSONObject2.putOpt("recording", jSONObject4);
            }
            jSONObject.putOpt("janus", "message");
            jSONObject.putOpt("body", jSONObject2);
            jSONObject.putOpt("transaction", e((Integer) 12));
            jSONObject.putOpt("session_id", this.cxR);
            jSONObject.putOpt("handle_id", bVar.cuJ);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        aE(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createSession() {
        String e = e((Integer) 12);
        d dVar = new d();
        dVar.tid = e;
        dVar.cuV = new o() { // from class: com.baidu.rtc.p.23
            @Override // com.baidu.rtc.o
            public void aD(JSONObject jSONObject) {
                p.this.cxR = new BigInteger(jSONObject.optJSONObject("data").optString("id"));
                p.this.mHandler.postDelayed(p.this.cxt, p.cxp);
                p.this.aeV();
            }
        };
        dVar.cuU = new n() { // from class: com.baidu.rtc.p.24
            @Override // com.baidu.rtc.n
            public void aC(JSONObject jSONObject) {
            }
        };
        this.cxY.put(e, dVar);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("janus", "create");
            jSONObject.putOpt("transaction", e);
            if (!this.cxQ.isEmpty()) {
                jSONObject.putOpt("sdktag", this.cxQ);
            }
            if (!this.cxM.isEmpty()) {
                jSONObject.putOpt("janusIp", this.cxM);
            }
            jSONObject.putOpt(DownloadDataConstants.Columns.COLUMN_URI, this.cxP);
            jSONObject.putOpt("sessionevent", true);
            jSONObject.putOpt("userevent", true);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        aE(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(b bVar) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt("request", UbcStatConstant.ContentType.UBC_TYPE_IM_JOIN);
            jSONObject2.putOpt(UbcStatConstant.KEY_CONTENT_ROOM, Long.valueOf(this.mRoomId));
            jSONObject2.putOpt("ptype", "listener");
            jSONObject2.putOpt(LogConfig.KEY_FEED, bVar.cuQ);
            jSONObject2.putOpt("id", Long.valueOf(this.mUserId));
            jSONObject2.putOpt("app_id", this.mAppId);
            jSONObject2.putOpt(DpStatConstants.KEY_ROOM_NAME, this.mRoomName);
            jSONObject2.putOpt("token", this.cxS);
            jSONObject2.putOpt("role", "listener");
            if (!this.cxN.isEmpty()) {
                jSONObject2.putOpt("window_id_in_bypass", this.cxN);
            }
            jSONObject.putOpt("janus", "message");
            jSONObject.putOpt("body", jSONObject2);
            jSONObject.putOpt("transaction", e((Integer) 12));
            jSONObject.putOpt("session_id", this.cxR);
            jSONObject.putOpt("handle_id", bVar.cuJ);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        aE(jSONObject);
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
        if (com.baidu.rtc.a.a.cvr) {
            Log.i("WebSocketChannel", "onMessage" + str);
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("janus");
            if (optString.equals("success")) {
                String optString2 = jSONObject.optString("transaction");
                d dVar = this.cxY.get(optString2);
                if (dVar != null && dVar.cuV != null) {
                    dVar.cuV.aD(jSONObject);
                }
                this.cxY.remove(optString2);
            } else if (optString.equals(BdStatsConstant.StatsType.ERROR)) {
                String optString3 = jSONObject.optString("transaction");
                d dVar2 = this.cxY.get(optString3);
                if (dVar2 != null && dVar2.cuU != null) {
                    dVar2.cuU.aC(jSONObject);
                }
                this.cxY.remove(optString3);
                if (jSONObject.has(BdStatsConstant.StatsType.ERROR)) {
                    String optString4 = jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR).optString(TiebaInitialize.LogFields.REASON);
                    if (optString4.contains("Room is disbanded")) {
                        if (this.cxr != null) {
                            this.cxr.aeD();
                        }
                    } else if (!optString4.contains("User is kick out") || this.cxr == null) {
                    } else {
                        this.cxr.bQ(this.mUserId);
                    }
                }
            } else if (optString.equals("ack")) {
                String optString5 = jSONObject.optString("transaction");
                d dVar3 = this.cxq.get(optString5);
                if (dVar3 != null && dVar3.cuV != null) {
                    dVar3.cuV.aD(jSONObject);
                }
                this.cxq.remove(optString5);
            } else if (optString.equals("timeout")) {
                this.mHandler.removeCallbacks(this.cxt);
                this.cxv.removeCallbacks(this.cxX);
                if (this.cxr != null) {
                    this.cxr.aeA();
                }
            } else if (optString.equals("slowlink")) {
                this.cxr.g(jSONObject.optBoolean("uplink"), jSONObject.optInt("nacks"));
            } else if (!optString.equals("sessionevent")) {
                if (jSONObject.has("sender")) {
                    final b bVar = this.cxu.get(new BigInteger(jSONObject.optString("sender")));
                    if (bVar == null) {
                        Log.e("WebSocketChannel", "missing handle");
                    } else if (!optString.equals("event")) {
                        if (optString.equals("detached")) {
                            bVar.cuS.a(bVar);
                        } else if (optString.equals("webrtcup")) {
                            this.cxr.f(bVar.cuJ);
                        } else if (!optString.equals("media")) {
                            if (!optString.equals("hangup") || this.cxr == null) {
                                return;
                            }
                            this.cxr.b(bVar.cuJ);
                        } else {
                            boolean z = jSONObject.getBoolean("receiving");
                            String string = jSONObject.getString("type");
                            if (this.cxr != null) {
                                this.cxr.a(bVar.cuJ, string.contains("video") ? 1 : 0, z);
                            }
                        }
                    } else {
                        JSONObject optJSONObject = jSONObject.optJSONObject("plugindata").optJSONObject("data");
                        if (optJSONObject.optString("videoroom").equals("joined")) {
                            bVar.cuR.a(bVar);
                        } else if (optJSONObject.optString("videoroom").equals("event")) {
                            if (optJSONObject.has("error_code")) {
                                this.cxr.fT(optJSONObject.optInt("error_code"));
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
                                this.cxr.b(bigInteger, optString6);
                                if (this.cxw && this.cxz) {
                                    d(bigInteger, optString6);
                                }
                                i++;
                            }
                        }
                        String optString7 = optJSONObject.optString("leaving");
                        if (!TextUtils.isEmpty(optString7) && !optString7.equals("ok")) {
                            this.cxr.a(bVar.cuJ, new BigInteger(optString7));
                            b bVar2 = this.cxs.get(new BigInteger(optString7));
                            if (bVar2 != null && bVar2.cuS != null) {
                                bVar2.cuS.a(bVar2);
                            }
                        }
                        String optString8 = optJSONObject.optString("unpublished");
                        if (!TextUtils.isEmpty(optString8)) {
                            if (!optString8.equals("ok") && !optString8.equals("self")) {
                                this.cxr.a(bVar.cuJ, new BigInteger(optString8));
                                b bVar3 = this.cxs.get(new BigInteger(optString8));
                                if (bVar3 != null && bVar3.cuS != null) {
                                    bVar3.cuS.a(bVar3);
                                }
                            } else if (optString8.equals("self") && optJSONObject.has("servertrigger")) {
                                this.cxr.b(bVar.cuJ);
                            }
                        }
                        JSONObject optJSONObject3 = jSONObject.optJSONObject("jsep");
                        if (optJSONObject3 != null) {
                            bVar.cuT.a(bVar, optJSONObject3);
                        }
                    }
                }
            } else if (jSONObject.has("recvdata")) {
                JSONObject optJSONObject4 = jSONObject.optJSONObject("recvdata");
                if (!optJSONObject4.optBoolean("internal")) {
                    this.cxr.c(new BigInteger(optJSONObject4.optString("from")), optJSONObject4.optString("data"));
                    return;
                }
                BaiduRtcRoom.d dVar4 = this.cxT.get(BigInteger.valueOf(optJSONObject4.optLong("from")));
                if (dVar4 != null) {
                    dVar4.attribute = optJSONObject4.optString("data");
                }
                this.cxr.a(new BigInteger(optJSONObject4.optString("from")), optJSONObject4.optString("data"));
            } else if (jSONObject.has("userevent")) {
                JSONObject optJSONObject5 = jSONObject.optJSONObject("userevent");
                if (optJSONObject5.has("joined")) {
                    BaiduRtcRoom.d dVar5 = new BaiduRtcRoom.d();
                    dVar5.userId = optJSONObject5.optLong("joined");
                    dVar5.userName = optJSONObject5.optString("display");
                    dVar5.attribute = optJSONObject5.optString(Config.EVENT_ATTR);
                    this.cxT.put(BigInteger.valueOf(dVar5.userId), dVar5);
                    this.cxr.a(new BigInteger(optJSONObject5.optString("joined")), optJSONObject5.optString("display"), "");
                } else if (optJSONObject5.has("leaving")) {
                    this.cxT.remove(BigInteger.valueOf(optJSONObject5.optLong("leaving")));
                    this.cxr.e(new BigInteger(optJSONObject5.optString("leaving")));
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
                        this.cxT.put(bigInteger2, dVar6);
                        this.cxr.a(bigInteger2, optString9, "");
                        String optString10 = optJSONObject6.optString(Config.EVENT_ATTR);
                        if (!optString10.isEmpty()) {
                            this.cxr.a(bigInteger2, optString10);
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
                        this.cxr.bP(optLong);
                    } else if (valueOf.booleanValue() || valueOf2.booleanValue()) {
                    } else {
                        this.cxr.bR(optLong);
                    }
                } else if (jSONObject.has("userkickout")) {
                    this.cxr.bQ(jSONObject.optJSONObject("userkickout").optLong("id"));
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
                        this.cxr.c(rtcLiveTransferMode, str2);
                    } else if (optString11.contains(SmsLoginView.f.l)) {
                        this.cxr.a(rtcLiveTransferMode, str2);
                    } else if (optString11.contains("break")) {
                        this.cxr.b(rtcLiveTransferMode, str2);
                    }
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void K(String str, boolean z) {
        this.cxP = str;
        String str2 = str + "?appid=" + this.mAppId + "&roomname=" + encodeURIComponent(this.mRoomName) + "&uid=" + this.mUserId + "&token=" + this.cxS;
        if (z) {
            str2 = str2 + "&compulsive=true";
        }
        if (com.baidu.rtc.a.a.cvr) {
            Log.i("WebSocketChannel", "connect url: " + str2);
        }
        this.cxV = cxo.connectTimeout(this.cxA, TimeUnit.MILLISECONDS).readTimeout(this.cxO, TimeUnit.MILLISECONDS).dns(new Dns() { // from class: com.baidu.rtc.p.11
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
                    return (List) futureTask.get(p.this.cxA, TimeUnit.MILLISECONDS);
                } catch (Exception e2) {
                    return null;
                }
            }
        }).build().newWebSocket(new Request.Builder().url(str2).build(), new WebSocketListener() { // from class: com.baidu.rtc.p.17
            @Override // okhttp3.WebSocketListener
            public void onClosed(WebSocket webSocket, int i, String str3) {
                if (com.baidu.rtc.a.a.cvr) {
                    Log.i("WebSocketChannel", "onClosed");
                }
            }

            @Override // okhttp3.WebSocketListener
            public void onClosing(WebSocket webSocket, int i, String str3) {
                if (com.baidu.rtc.a.a.cvr) {
                    Log.i("WebSocketChannel", "onClosing");
                }
                if (p.this.cxr != null) {
                    p.this.cxr.aeA();
                }
            }

            @Override // okhttp3.WebSocketListener
            public void onFailure(WebSocket webSocket, Throwable th, Response response) {
                if (th != null) {
                    Log.e("WebSocketChannel", "onFailure" + th.toString());
                } else {
                    Log.e("WebSocketChannel", "onFailure");
                }
                if (p.this.cxr == null) {
                    return;
                }
                if (th instanceof SocketTimeoutException) {
                    if (p.this.cxr != null) {
                        p.this.cxr.aeC();
                    }
                } else if (th instanceof NumberFormatException) {
                    Log.e("WebSocketChannel", "onFailure: java.lang.NumberFormatException");
                } else if (th instanceof NullPointerException) {
                    Log.e("WebSocketChannel", "onFailure: java.lang.NullPointerException");
                } else if (!(th instanceof SSLException)) {
                    if (p.this.cxr != null) {
                        p.this.cxr.aeB();
                    }
                } else {
                    Log.e("WebSocketChannel", "onFailure: SSLException");
                    if (p.this.cxr != null) {
                        p.this.cxr.aeA();
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
                if (com.baidu.rtc.a.a.cvr) {
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
        dVar.cuV = new o() { // from class: com.baidu.rtc.p.7
            @Override // com.baidu.rtc.o
            public void aD(JSONObject jSONObject) {
                p.this.c(bVar);
            }
        };
        dVar.cuU = new n() { // from class: com.baidu.rtc.p.8
            @Override // com.baidu.rtc.n
            public void aC(JSONObject jSONObject) {
                p.this.c(bVar);
            }
        };
        this.cxY.put(e, dVar);
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
            if (!this.cxI.isEmpty() && this.cxK == BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ROOM_TRANSMISSION) {
                jSONObject3.putOpt("url", this.cxI);
                if (!this.cxD.isEmpty()) {
                    jSONObject3.putOpt("mixTemplate", this.cxD);
                }
                jSONObject.putOpt(AlaRecorderLog.Protocol.RTMP, jSONObject3);
            } else if (!this.cxJ.isEmpty() && this.cxL == BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ROOM_TRANSMISSION) {
                jSONObject3.putOpt("url", this.cxJ);
                if (!this.cxE.isEmpty()) {
                    jSONObject3.putOpt("mixTemplate", this.cxE);
                }
                jSONObject.putOpt(AlaRecorderLog.Protocol.RTMP, jSONObject3);
            }
            if (this.cxF) {
                jSONObject4.putOpt("rec", Boolean.valueOf(this.cxF));
                jSONObject.putOpt("recording", jSONObject4);
            }
            jSONObject2.putOpt("janus", "message");
            jSONObject2.putOpt("body", jSONObject);
            jSONObject2.putOpt("transaction", e);
            jSONObject2.putOpt("session_id", this.cxR);
            jSONObject2.putOpt("handle_id", bVar.cuJ);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        aE(jSONObject2);
    }

    public void a(c cVar) {
        this.cxr = cVar;
    }

    public void a(String str, long j, boolean z) {
        String e = e((Integer) 12);
        d dVar = new d();
        dVar.tid = e;
        dVar.cuV = new o() { // from class: com.baidu.rtc.p.13
            @Override // com.baidu.rtc.o
            public void aD(JSONObject jSONObject) {
            }
        };
        dVar.cuU = new n() { // from class: com.baidu.rtc.p.14
            @Override // com.baidu.rtc.n
            public void aC(JSONObject jSONObject) {
            }
        };
        this.cxY.put(e, dVar);
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
            jSONObject2.putOpt("session_id", this.cxR);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        aE(jSONObject2);
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
            jSONObject2.putOpt("session_id", this.cxR);
            jSONObject2.putOpt("handle_id", bigInteger);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        aE(jSONObject2);
    }

    public void aF(JSONObject jSONObject) {
        String e = e((Integer) 12);
        d dVar = new d();
        dVar.tid = e;
        dVar.cuV = new o() { // from class: com.baidu.rtc.p.18
            @Override // com.baidu.rtc.o
            public void aD(JSONObject jSONObject2) {
            }
        };
        dVar.cuU = new n() { // from class: com.baidu.rtc.p.19
            @Override // com.baidu.rtc.n
            public void aC(JSONObject jSONObject2) {
            }
        };
        this.cxY.put(e, dVar);
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt("janus", "message");
            jSONObject2.putOpt("body", jSONObject);
            jSONObject2.putOpt("transaction", e);
            jSONObject2.putOpt("session_id", this.cxR);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        aE(jSONObject2);
    }

    public void b(BaiduRtcRoom.RtcLiveTransferMode rtcLiveTransferMode) {
        this.cxK = rtcLiveTransferMode;
    }

    public void bO(long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("request", "kickoutuser");
            jSONObject.putOpt(UbcStatConstant.KEY_CONTENT_ROOM, Long.valueOf(this.mRoomId));
            jSONObject.putOpt("target", Long.valueOf(j));
            aF(jSONObject);
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
            aF(jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void c(String str, boolean z, boolean z2, String str2, BaiduRtcRoom.RtcLiveTransferMode rtcLiveTransferMode) {
        this.cxJ = str;
        this.cxC = z;
        this.cxG = z2;
        this.cxE = str2;
        this.cxL = rtcLiveTransferMode;
    }

    public void c(BigInteger bigInteger, SessionDescription sessionDescription) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject.putOpt("request", "configure");
            jSONObject.putOpt("audio", Boolean.valueOf(this.mHasAudio));
            jSONObject.putOpt("video", Boolean.valueOf(this.mHasVideo));
            if (this.cvo) {
                jSONObject.putOpt("data", Boolean.valueOf(this.cvo));
            }
            jSONObject2.putOpt("type", sessionDescription.type);
            jSONObject2.putOpt("sdp", sessionDescription.description);
            jSONObject3.putOpt("janus", "message");
            jSONObject3.putOpt("body", jSONObject);
            jSONObject3.putOpt("jsep", jSONObject2);
            jSONObject3.putOpt("transaction", e((Integer) 12));
            jSONObject3.putOpt("session_id", this.cxR);
            jSONObject3.putOpt("handle_id", bigInteger);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        aE(jSONObject3);
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
            aF(jSONObject);
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
            aF(jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void d(final BigInteger bigInteger, final String str) {
        String e = e((Integer) 12);
        d dVar = new d();
        dVar.tid = e;
        dVar.cuV = new o() { // from class: com.baidu.rtc.p.27
            @Override // com.baidu.rtc.o
            public void aD(JSONObject jSONObject) {
                b bVar = new b();
                bVar.cuJ = new BigInteger(jSONObject.optJSONObject("data").optString("id"));
                bVar.cuQ = bigInteger;
                bVar.cuP = str;
                bVar.cuT = new f() { // from class: com.baidu.rtc.p.27.1
                    @Override // com.baidu.rtc.f
                    public void a(b bVar2, JSONObject jSONObject2) {
                        p.this.cxr.b(bVar2.cuJ, jSONObject2);
                    }
                };
                bVar.cuS = new e() { // from class: com.baidu.rtc.p.27.2
                    @Override // com.baidu.rtc.e
                    public void a(b bVar2) {
                        p.this.f(bVar2);
                    }
                };
                p.this.cxu.put(bVar.cuJ, bVar);
                p.this.cxs.put(bVar.cuQ, bVar);
                p.this.d(bVar);
            }
        };
        dVar.cuU = new n() { // from class: com.baidu.rtc.p.2
            @Override // com.baidu.rtc.n
            public void aC(JSONObject jSONObject) {
            }
        };
        this.cxY.put(e, dVar);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("janus", "attach");
            jSONObject.putOpt("plugin", "janus.plugin.videoroom");
            jSONObject.putOpt("transaction", e);
            jSONObject.putOpt("session_id", this.cxR);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        aE(jSONObject);
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
            jSONObject3.putOpt("session_id", this.cxR);
            jSONObject3.putOpt("handle_id", bigInteger);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        aE(jSONObject3);
    }

    public void disbandRoom() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("request", "disbandroom");
            jSONObject.putOpt(UbcStatConstant.KEY_CONTENT_ROOM, Long.valueOf(this.mRoomId));
            aF(jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void e(final b bVar) {
        String e = e((Integer) 12);
        d dVar = new d();
        dVar.tid = e;
        dVar.cuV = new o() { // from class: com.baidu.rtc.p.9
            @Override // com.baidu.rtc.o
            public void aD(JSONObject jSONObject) {
                p.this.mRoomId = jSONObject.optJSONObject("plugindata").optJSONObject("data").optLong(UbcStatConstant.KEY_CONTENT_ROOM);
                Log.v("createRoomWithoutRoomID", "Got RoomID:" + p.this.mRoomId);
                p.this.c(bVar);
            }
        };
        dVar.cuU = new n() { // from class: com.baidu.rtc.p.10
            @Override // com.baidu.rtc.n
            public void aC(JSONObject jSONObject) {
                p.this.c(bVar);
            }
        };
        this.cxY.put(e, dVar);
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
            if (!this.cxI.isEmpty() && this.cxK == BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ROOM_TRANSMISSION) {
                jSONObject3.putOpt("url", this.cxI);
                jSONObject3.putOpt("mixTemplate", this.cxD);
                jSONObject.putOpt(AlaRecorderLog.Protocol.RTMP, jSONObject3);
            } else if (!this.cxJ.isEmpty() && this.cxL == BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ROOM_TRANSMISSION) {
                jSONObject3.putOpt("url", this.cxJ);
                if (!this.cxE.isEmpty()) {
                    jSONObject3.putOpt("mixTemplate", this.cxE);
                }
                jSONObject.putOpt(AlaRecorderLog.Protocol.RTMP, jSONObject3);
            }
            if (this.cxF) {
                jSONObject4.putOpt("rec", Boolean.valueOf(this.cxF));
                jSONObject.putOpt("recording", jSONObject4);
            }
            jSONObject2.putOpt("janus", "message");
            jSONObject2.putOpt("body", jSONObject);
            jSONObject2.putOpt("transaction", e);
            jSONObject2.putOpt("session_id", this.cxR);
            jSONObject2.putOpt("handle_id", bVar.cuJ);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        aE(jSONObject2);
    }

    public void eA(boolean z) {
        this.cxy = z;
    }

    public void eB(boolean z) {
        this.cxz = z;
    }

    public void eC(boolean z) {
        this.cxB = z;
    }

    public void eD(boolean z) {
        this.cxF = z;
    }

    public void et(boolean z) {
        this.mHasAudio = z;
    }

    public void eu(boolean z) {
        this.cvo = z;
    }

    public void ev(boolean z) {
        this.mHasVideo = z;
    }

    public void ey(boolean z) {
        this.cxw = z;
    }

    public void ez(boolean z) {
        this.cxx = z;
    }

    public void f(final b bVar) {
        String e = e((Integer) 12);
        d dVar = new d();
        dVar.tid = e;
        dVar.cuV = new o() { // from class: com.baidu.rtc.p.3
            @Override // com.baidu.rtc.o
            public void aD(JSONObject jSONObject) {
                p.this.cxr.a(bVar.cuJ, bVar.cuQ);
                p.this.cxr.d(bVar.cuJ);
                p.this.cxu.remove(bVar.cuJ);
                p.this.cxs.remove(bVar.cuQ);
            }
        };
        dVar.cuU = new n() { // from class: com.baidu.rtc.p.4
            @Override // com.baidu.rtc.n
            public void aC(JSONObject jSONObject) {
            }
        };
        this.cxY.put(e, dVar);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("janus", "detach");
            jSONObject.putOpt("transaction", e);
            jSONObject.putOpt("session_id", this.cxR);
            jSONObject.putOpt("handle_id", bVar.cuJ);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        aE(jSONObject);
    }

    public void fV(int i) {
        this.cxA = i;
    }

    public void fW(int i) {
        this.cxO = i;
    }

    public void finalize() {
        this.mHandler.removeCallbacks(this.cxt);
        this.cxv.removeCallbacks(this.cxX);
        this.cxr = null;
        if (this.cxV != null) {
            this.cxV.close(1001, "going away");
        }
    }

    public long getRoomId() {
        return this.mRoomId;
    }

    public void jD(String str) {
        this.cxD = str;
    }

    public void jE(String str) {
        this.cxI = str;
    }

    public void jF(String str) {
        this.cxM = str;
    }

    public void jG(String str) {
        this.cxN = str;
    }

    public void jH(String str) {
        this.mRoomName = str;
    }

    public void jI(String str) {
        this.cxQ = str;
    }

    public void jJ(String str) {
        this.cxS = str;
    }

    public BigInteger k(BigInteger bigInteger) {
        return this.cxu.get(bigInteger) == null ? BigInteger.valueOf(0L) : this.cxu.get(bigInteger).cuQ;
    }

    public b l(BigInteger bigInteger) {
        return this.cxs.get(bigInteger);
    }

    public String m(BigInteger bigInteger) {
        if (this.cxT.get(bigInteger) == null) {
            return null;
        }
        return this.cxT.get(bigInteger).userName;
    }

    public void n(BigInteger bigInteger) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.putOpt("completed", true);
            jSONObject2.putOpt("janus", "trickle");
            jSONObject2.putOpt("candidate", jSONObject);
            jSONObject2.putOpt("transaction", e((Integer) 12));
            jSONObject2.putOpt("session_id", this.cxR);
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
            jSONObject2.putOpt("session_id", this.cxR);
            jSONObject2.putOpt("handle_id", bigInteger);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        aE(jSONObject2);
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
        dVar.cuV = new o() { // from class: com.baidu.rtc.p.15
            @Override // com.baidu.rtc.o
            public void aD(JSONObject jSONObject) {
                p.this.a(str, 0L, true);
            }
        };
        dVar.cuU = new n() { // from class: com.baidu.rtc.p.16
            @Override // com.baidu.rtc.n
            public void aC(JSONObject jSONObject) {
            }
        };
        this.cxY.put(e, dVar);
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
            jSONObject2.putOpt("session_id", this.cxR);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        aE(jSONObject2);
    }

    public void setUserId(long j) {
        this.mUserId = j;
    }

    public void setVideoCodec(String str) {
        this.mVideoCodec = str.toLowerCase();
    }

    public void yr() {
        this.mHandler.post(new Runnable() { // from class: com.baidu.rtc.p.12
            @Override // java.lang.Runnable
            public void run() {
                int size = p.this.cxu.size();
                for (int i = 0; i < size; i++) {
                    p.this.b((b) p.this.cxu.values().toArray()[i]);
                    try {
                        Thread.sleep(50L);
                    } catch (Exception e) {
                    }
                }
            }
        });
    }
}
