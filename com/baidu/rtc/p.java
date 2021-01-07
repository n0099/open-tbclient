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
import com.baidu.platform.comapi.map.MapBundleKey;
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
/* loaded from: classes10.dex */
public class p {
    static int cyA = 25000;
    static OkHttpClient.Builder cyz = new OkHttpClient.Builder().connectionPool(new ConnectionPool(5, 1, TimeUnit.MINUTES)).addInterceptor(new Interceptor() { // from class: com.baidu.rtc.p.1
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
    private c cyB;
    private BigInteger cyY;
    private WebSocket czc;
    private ConcurrentHashMap<String, d> czd = new ConcurrentHashMap<>();
    private ConcurrentHashMap<BigInteger, b> cyE = new ConcurrentHashMap<>();
    private ConcurrentHashMap<BigInteger, b> cyC = new ConcurrentHashMap<>();
    private long mUserId = (Build.SERIAL.hashCode() % 100000) + 78657895;
    private String mDisplayName = "Android-rtc";
    private String mRoomName = "";
    private String mVideoCodec = KsMediaFormat.CODEC_NAME_H264;
    private boolean cyG = true;
    private boolean cyF = true;
    private boolean mHasVideo = true;
    private boolean mHasAudio = true;
    private boolean cwM = false;
    private long mRoomId = -1160725808;
    private String mAppId = "";
    private String cyZ = "";
    private String cyR = "";
    private String cyQ = "";
    private String cyM = "";
    private String cyV = "";
    private String cyX = "";
    private BaiduRtcRoom.RtcLiveTransferMode cyT = BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ANCHOR_TRASNSMISSION;
    private boolean cyK = false;
    private boolean cyO = false;
    private String cyS = "";
    private String cyN = "";
    private BaiduRtcRoom.RtcLiveTransferMode cyU = BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ANCHOR_TRASNSMISSION;
    private boolean cyL = false;
    private boolean cyP = false;
    private int cyJ = 5000;
    private int cyW = 5000;
    public boolean cyH = true;
    public boolean cyI = true;
    volatile BaiduRtcRoom.e czb = null;
    private ConcurrentHashMap<BigInteger, BaiduRtcRoom.d> cza = new ConcurrentHashMap<>();
    private Runnable cyD = new Runnable() { // from class: com.baidu.rtc.p.18
        @Override // java.lang.Runnable
        public void run() {
            p.this.ais();
            p.this.mHandler.postDelayed(p.this.cyD, p.cyA);
        }
    };
    private Handler mHandler = new Handler(Looper.getMainLooper());

    private void aF(JSONObject jSONObject) {
        if (this.czc != null) {
            this.czc.send(jSONObject.toString());
        }
        if (com.baidu.rtc.a.a.cwO) {
            Log.i("WebSocketChannel", jSONObject.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ais() {
        String e = e((Integer) 12);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("janus", "keepalive");
            jSONObject.putOpt("session_id", this.cyY);
            jSONObject.putOpt("transaction", e);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        aF(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ait() {
        String e = e((Integer) 12);
        d dVar = new d();
        dVar.tid = e;
        dVar.cwt = new o() { // from class: com.baidu.rtc.p.22
            @Override // com.baidu.rtc.o
            public void aE(JSONObject jSONObject) {
                b bVar = new b();
                bVar.cwh = new BigInteger(jSONObject.optJSONObject("data").optString("id"));
                bVar.cwp = new e() { // from class: com.baidu.rtc.p.22.1
                    @Override // com.baidu.rtc.e
                    public void a(b bVar2) {
                        p.this.cyB.c(bVar2.cwh);
                    }
                };
                bVar.cwr = new f() { // from class: com.baidu.rtc.p.22.2
                    @Override // com.baidu.rtc.f
                    public void a(b bVar2, JSONObject jSONObject2) {
                        p.this.cyB.a(bVar2.cwh, jSONObject2);
                    }
                };
                p.this.cyE.put(bVar.cwh, bVar);
                if (p.this.mRoomId == -1160725808) {
                    p.this.e(bVar);
                } else {
                    p.this.a(p.this.mRoomId, p.this.mRoomName, bVar);
                }
            }
        };
        dVar.cws = new n() { // from class: com.baidu.rtc.p.23
            @Override // com.baidu.rtc.n
            public void aD(JSONObject jSONObject) {
            }
        };
        this.czd.put(e, dVar);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("janus", "attach");
            jSONObject.putOpt("plugin", "janus.plugin.videoroom");
            jSONObject.putOpt("transaction", e);
            jSONObject.putOpt("session_id", this.cyY);
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
            jSONObject2.putOpt("session_id", this.cyY);
            jSONObject2.putOpt("handle_id", bVar.cwh);
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
            if (!this.cyV.isEmpty()) {
                jSONObject2.putOpt("window_id_in_bypass", this.cyV);
            }
            if (!this.cyR.isEmpty() && this.cyT == BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ANCHOR_TRASNSMISSION) {
                jSONObject3.putOpt("url", this.cyR);
                if (!this.cyM.isEmpty()) {
                    jSONObject3.putOpt("mixTemplate", this.cyM);
                }
                jSONObject3.putOpt("mix", Boolean.valueOf(this.cyK));
                jSONObject2.putOpt(AlaRecorderLog.Protocol.RTMP, jSONObject3);
            } else if (!this.cyS.isEmpty() && this.cyU == BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ANCHOR_TRASNSMISSION) {
                jSONObject3.putOpt("url", this.cyS);
                if (!this.cyN.isEmpty()) {
                    jSONObject3.putOpt("mixTemplate", this.cyN);
                }
                jSONObject3.putOpt("mix", Boolean.valueOf(this.cyL));
                jSONObject2.putOpt(AlaRecorderLog.Protocol.RTMP, jSONObject3);
            }
            if (this.cyO) {
                jSONObject4.putOpt("rec", Boolean.valueOf(this.cyO));
                jSONObject2.putOpt("recording", jSONObject4);
            }
            jSONObject.putOpt("janus", "message");
            jSONObject.putOpt("body", jSONObject2);
            jSONObject.putOpt("transaction", e((Integer) 12));
            jSONObject.putOpt("session_id", this.cyY);
            jSONObject.putOpt("handle_id", bVar.cwh);
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
        dVar.cwt = new o() { // from class: com.baidu.rtc.p.20
            @Override // com.baidu.rtc.o
            public void aE(JSONObject jSONObject) {
                p.this.cyY = new BigInteger(jSONObject.optJSONObject("data").optString("id"));
                p.this.mHandler.postDelayed(p.this.cyD, p.cyA);
                p.this.ait();
            }
        };
        dVar.cws = new n() { // from class: com.baidu.rtc.p.21
            @Override // com.baidu.rtc.n
            public void aD(JSONObject jSONObject) {
            }
        };
        this.czd.put(e, dVar);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("janus", "create");
            jSONObject.putOpt("transaction", e);
            if (!this.cyX.isEmpty()) {
                jSONObject.putOpt("sdktag", this.cyX);
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
            jSONObject2.putOpt(LogConfig.KEY_FEED, bVar.cwo);
            jSONObject2.putOpt("id", Long.valueOf(this.mUserId));
            jSONObject2.putOpt("app_id", this.mAppId);
            jSONObject2.putOpt(DpStatConstants.KEY_ROOM_NAME, this.mRoomName);
            jSONObject2.putOpt("token", this.cyZ);
            jSONObject2.putOpt("role", "listener");
            if (!this.cyV.isEmpty()) {
                jSONObject2.putOpt("window_id_in_bypass", this.cyV);
            }
            jSONObject.putOpt("janus", "message");
            jSONObject.putOpt("body", jSONObject2);
            jSONObject.putOpt("transaction", e((Integer) 12));
            jSONObject.putOpt("session_id", this.cyY);
            jSONObject.putOpt("handle_id", bVar.cwh);
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
        if (com.baidu.rtc.a.a.cwO) {
            Log.i("WebSocketChannel", "onMessage" + str);
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("janus");
            if (optString.equals("success")) {
                String optString2 = jSONObject.optString("transaction");
                d dVar = this.czd.get(optString2);
                if (dVar.cwt != null) {
                    dVar.cwt.aE(jSONObject);
                }
                this.czd.remove(optString2);
            } else if (optString.equals(BdStatsConstant.StatsType.ERROR)) {
                String optString3 = jSONObject.optString("transaction");
                d dVar2 = this.czd.get(optString3);
                if (dVar2 != null && dVar2.cws != null) {
                    dVar2.cws.aD(jSONObject);
                }
                this.czd.remove(optString3);
                if (jSONObject.has(BdStatsConstant.StatsType.ERROR)) {
                    String optString4 = jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR).optString(TiebaInitialize.LogFields.REASON);
                    if (optString4.contains("Room is disbanded")) {
                        if (this.cyB != null) {
                            this.cyB.aie();
                        }
                    } else if (!optString4.contains("User is kick out") || this.cyB == null) {
                    } else {
                        this.cyB.bM(this.mUserId);
                    }
                }
            } else if (optString.equals("ack")) {
            } else {
                if (optString.equals("timeout")) {
                    this.mHandler.removeCallbacks(this.cyD);
                    if (this.cyB != null) {
                        this.cyB.aib();
                    }
                } else if (optString.equals("slowlink")) {
                    this.cyB.g(jSONObject.optBoolean("uplink"), jSONObject.optInt("nacks"));
                } else if (!optString.equals("sessionevent")) {
                    if (jSONObject.has("sender")) {
                        final b bVar = this.cyE.get(new BigInteger(jSONObject.optString("sender")));
                        if (bVar == null) {
                            Log.e("WebSocketChannel", "missing handle");
                        } else if (!optString.equals("event")) {
                            if (optString.equals("detached")) {
                                bVar.cwq.a(bVar);
                            } else if (optString.equals("webrtcup")) {
                                this.cyB.f(bVar.cwh);
                            } else if (optString.equals("media")) {
                                this.cyB.a(bVar.cwh, jSONObject.getString("type").contains("video") ? 1 : 0, jSONObject.getBoolean("receiving"));
                            } else if (!optString.equals("hangup") || this.cyB == null) {
                            } else {
                                this.cyB.b(bVar.cwh);
                            }
                        } else {
                            JSONObject optJSONObject = jSONObject.optJSONObject("plugindata").optJSONObject("data");
                            if (optJSONObject.optString("videoroom").equals("joined")) {
                                bVar.cwp.a(bVar);
                            } else if (optJSONObject.optString("videoroom").equals("event")) {
                                if (optJSONObject.has("error_code")) {
                                    this.cyB.hw(optJSONObject.optInt("error_code"));
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
                                    this.cyB.b(bigInteger, optString5);
                                    if (this.cyF && this.cyI) {
                                        d(bigInteger, optString5);
                                    }
                                    i++;
                                }
                            }
                            String optString6 = optJSONObject.optString("leaving");
                            if (!TextUtils.isEmpty(optString6) && !optString6.equals("ok")) {
                                this.cyB.a(bVar.cwh, new BigInteger(optString6));
                                b bVar2 = this.cyC.get(new BigInteger(optString6));
                                if (bVar2 != null && bVar2.cwq != null) {
                                    bVar2.cwq.a(bVar2);
                                }
                            }
                            String optString7 = optJSONObject.optString("unpublished");
                            if (!TextUtils.isEmpty(optString7)) {
                                if (!optString7.equals("ok") && !optString7.equals("self")) {
                                    this.cyB.a(bVar.cwh, new BigInteger(optString7));
                                    b bVar3 = this.cyC.get(new BigInteger(optString7));
                                    if (bVar3 != null && bVar3.cwq != null) {
                                        bVar3.cwq.a(bVar3);
                                    }
                                } else if (optString7.equals("self") && optJSONObject.has("servertrigger")) {
                                    this.cyB.b(bVar.cwh);
                                }
                            }
                            JSONObject optJSONObject3 = jSONObject.optJSONObject("jsep");
                            if (optJSONObject3 != null) {
                                bVar.cwr.a(bVar, optJSONObject3);
                            }
                        }
                    }
                } else if (jSONObject.has("recvdata")) {
                    JSONObject optJSONObject4 = jSONObject.optJSONObject("recvdata");
                    if (!optJSONObject4.optBoolean("internal")) {
                        this.cyB.c(new BigInteger(optJSONObject4.optString("from")), optJSONObject4.optString("data"));
                        return;
                    }
                    BaiduRtcRoom.d dVar3 = this.cza.get(BigInteger.valueOf(optJSONObject4.optLong("from")));
                    if (dVar3 != null) {
                        dVar3.attribute = optJSONObject4.optString("data");
                    }
                    this.cyB.a(new BigInteger(optJSONObject4.optString("from")), optJSONObject4.optString("data"));
                } else if (jSONObject.has("userevent")) {
                    JSONObject optJSONObject5 = jSONObject.optJSONObject("userevent");
                    if (optJSONObject5.has("joined")) {
                        BaiduRtcRoom.d dVar4 = new BaiduRtcRoom.d();
                        dVar4.userId = optJSONObject5.optLong("joined");
                        dVar4.userName = optJSONObject5.optString("display");
                        dVar4.attribute = optJSONObject5.optString(Config.EVENT_ATTR);
                        this.cza.put(BigInteger.valueOf(dVar4.userId), dVar4);
                        this.cyB.a(new BigInteger(optJSONObject5.optString("joined")), optJSONObject5.optString("display"), "");
                    } else if (optJSONObject5.has("leaving")) {
                        this.cza.remove(BigInteger.valueOf(optJSONObject5.optLong("leaving")));
                        this.cyB.e(new BigInteger(optJSONObject5.optString("leaving")));
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
                            this.cza.put(bigInteger2, dVar5);
                            this.cyB.a(bigInteger2, optString8, "");
                            String optString9 = optJSONObject6.optString(Config.EVENT_ATTR);
                            if (!optString9.isEmpty()) {
                                this.cyB.a(bigInteger2, optString9);
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
                            this.cyB.bL(optLong);
                        } else if (valueOf.booleanValue() || valueOf2.booleanValue()) {
                        } else {
                            this.cyB.bN(optLong);
                        }
                    } else if (jSONObject.has("userkickout")) {
                        this.cyB.bM(jSONObject.optJSONObject("userkickout").optLong("id"));
                    } else if (jSONObject.has("bypass_event")) {
                        JSONObject optJSONObject8 = jSONObject.optJSONObject("bypass_event");
                        BaiduRtcRoom.RtcLiveTransferMode rtcLiveTransferMode = optJSONObject8.optString(MapBundleKey.MapObjKey.OBJ_LEVEL).contains(UbcStatConstant.KEY_CONTENT_ROOM) ? BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ROOM_TRANSMISSION : BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ANCHOR_TRASNSMISSION;
                        String optString10 = optJSONObject8.optJSONObject(AlaRecorderLog.Protocol.RTMP).optString("url");
                        String optString11 = optJSONObject8.optString("bypassStatus");
                        if (optString11.contains("success")) {
                            this.cyB.c(rtcLiveTransferMode, optString10);
                        } else if (optString11.contains(SmsLoginView.f.l)) {
                            this.cyB.a(rtcLiveTransferMode, optString10);
                        } else if (optString11.contains("break")) {
                            this.cyB.b(rtcLiveTransferMode, optString10);
                        }
                    }
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void Cw() {
        this.mHandler.post(new Runnable() { // from class: com.baidu.rtc.p.9
            @Override // java.lang.Runnable
            public void run() {
                int size = p.this.cyE.size();
                for (int i = 0; i < size; i++) {
                    p.this.b((b) p.this.cyE.values().toArray()[i]);
                    try {
                        Thread.sleep(50L);
                    } catch (Exception e) {
                    }
                }
            }
        });
    }

    public void L(String str, boolean z) {
        String str2 = str + "?appid=" + this.mAppId + "&roomname=" + encodeURIComponent(this.mRoomName) + "&uid=" + this.mUserId + "&token=" + this.cyZ;
        if (z) {
            str2 = str2 + "&compulsive=true";
        }
        if (com.baidu.rtc.a.a.cwO) {
            Log.i("WebSocketChannel", "connect url: " + str2);
        }
        this.czc = cyz.connectTimeout(this.cyJ, TimeUnit.MILLISECONDS).readTimeout(this.cyW, TimeUnit.MILLISECONDS).dns(new Dns() { // from class: com.baidu.rtc.p.10
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
                    return (List) futureTask.get(p.this.cyJ, TimeUnit.MILLISECONDS);
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
                if (com.baidu.rtc.a.a.cwO) {
                    Log.i("WebSocketChannel", "onClosing");
                }
                if (p.this.cyB != null) {
                    p.this.cyB.aib();
                }
            }

            @Override // okhttp3.WebSocketListener
            public void onFailure(WebSocket webSocket, Throwable th, Response response) {
                if (th != null) {
                    Log.e("WebSocketChannel", "onFailure" + th.toString());
                } else {
                    Log.e("WebSocketChannel", "onFailure");
                }
                if (p.this.cyB == null) {
                    return;
                }
                if (th instanceof SocketTimeoutException) {
                    if (p.this.cyB != null) {
                        p.this.cyB.aid();
                    }
                } else if (th instanceof NumberFormatException) {
                    Log.e("WebSocketChannel", "onFailure: java.lang.NumberFormatException");
                } else if (th instanceof NullPointerException) {
                    Log.e("WebSocketChannel", "onFailure: java.lang.NullPointerException");
                } else if (!(th instanceof SSLException)) {
                    if (p.this.cyB != null) {
                        p.this.cyB.aic();
                    }
                } else {
                    Log.e("WebSocketChannel", "onFailure: SSLException");
                    if (p.this.cyB != null) {
                        p.this.cyB.aib();
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
                if (com.baidu.rtc.a.a.cwO) {
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
        dVar.cwt = new o() { // from class: com.baidu.rtc.p.5
            @Override // com.baidu.rtc.o
            public void aE(JSONObject jSONObject) {
                p.this.c(bVar);
            }
        };
        dVar.cws = new n() { // from class: com.baidu.rtc.p.6
            @Override // com.baidu.rtc.n
            public void aD(JSONObject jSONObject) {
                p.this.c(bVar);
            }
        };
        this.czd.put(e, dVar);
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
            if (!this.cyR.isEmpty() && this.cyT == BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ROOM_TRANSMISSION) {
                jSONObject3.putOpt("url", this.cyR);
                if (!this.cyM.isEmpty()) {
                    jSONObject3.putOpt("mixTemplate", this.cyM);
                }
                jSONObject.putOpt(AlaRecorderLog.Protocol.RTMP, jSONObject3);
            } else if (!this.cyS.isEmpty() && this.cyU == BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ROOM_TRANSMISSION) {
                jSONObject3.putOpt("url", this.cyS);
                if (!this.cyN.isEmpty()) {
                    jSONObject3.putOpt("mixTemplate", this.cyN);
                }
                jSONObject.putOpt(AlaRecorderLog.Protocol.RTMP, jSONObject3);
            }
            if (this.cyO) {
                jSONObject4.putOpt("rec", Boolean.valueOf(this.cyO));
                jSONObject.putOpt("recording", jSONObject4);
            }
            jSONObject2.putOpt("janus", "message");
            jSONObject2.putOpt("body", jSONObject);
            jSONObject2.putOpt("transaction", e);
            jSONObject2.putOpt("session_id", this.cyY);
            jSONObject2.putOpt("handle_id", bVar.cwh);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        aF(jSONObject2);
    }

    public void a(BaiduRtcRoom.RtcLiveTransferMode rtcLiveTransferMode) {
        this.cyT = rtcLiveTransferMode;
    }

    public void a(c cVar) {
        this.cyB = cVar;
    }

    public void a(String str, long j, boolean z) {
        String e = e((Integer) 12);
        d dVar = new d();
        dVar.tid = e;
        dVar.cwt = new o() { // from class: com.baidu.rtc.p.11
            @Override // com.baidu.rtc.o
            public void aE(JSONObject jSONObject) {
            }
        };
        dVar.cws = new n() { // from class: com.baidu.rtc.p.12
            @Override // com.baidu.rtc.n
            public void aD(JSONObject jSONObject) {
            }
        };
        this.czd.put(e, dVar);
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
            jSONObject2.putOpt("session_id", this.cyY);
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
            jSONObject2.putOpt("session_id", this.cyY);
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
        dVar.cwt = new o() { // from class: com.baidu.rtc.p.15
            @Override // com.baidu.rtc.o
            public void aE(JSONObject jSONObject2) {
            }
        };
        dVar.cws = new n() { // from class: com.baidu.rtc.p.16
            @Override // com.baidu.rtc.n
            public void aD(JSONObject jSONObject2) {
            }
        };
        this.czd.put(e, dVar);
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt("janus", "message");
            jSONObject2.putOpt("body", jSONObject);
            jSONObject2.putOpt("transaction", e);
            jSONObject2.putOpt("session_id", this.cyY);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        aF(jSONObject2);
    }

    public BaiduRtcRoom.d[] aiu() {
        if (this.cza.size() < 1) {
            return null;
        }
        BaiduRtcRoom.d[] dVarArr = new BaiduRtcRoom.d[this.cza.size()];
        int i = 0;
        Iterator<BaiduRtcRoom.d> it = this.cza.values().iterator();
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
        this.cyS = str;
        this.cyL = z;
        this.cyP = z2;
        this.cyN = str2;
        this.cyU = rtcLiveTransferMode;
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
            if (this.cwM) {
                jSONObject.putOpt("data", Boolean.valueOf(this.cwM));
            }
            jSONObject2.putOpt("type", sessionDescription.type);
            jSONObject2.putOpt("sdp", sessionDescription.description);
            jSONObject3.putOpt("janus", "message");
            jSONObject3.putOpt("body", jSONObject);
            jSONObject3.putOpt("jsep", jSONObject2);
            jSONObject3.putOpt("transaction", e((Integer) 12));
            jSONObject3.putOpt("session_id", this.cyY);
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
        dVar.cwt = new o() { // from class: com.baidu.rtc.p.24
            @Override // com.baidu.rtc.o
            public void aE(JSONObject jSONObject) {
                b bVar = new b();
                bVar.cwh = new BigInteger(jSONObject.optJSONObject("data").optString("id"));
                bVar.cwo = bigInteger;
                bVar.cwn = str;
                bVar.cwr = new f() { // from class: com.baidu.rtc.p.24.1
                    @Override // com.baidu.rtc.f
                    public void a(b bVar2, JSONObject jSONObject2) {
                        p.this.cyB.b(bVar2.cwh, jSONObject2);
                    }
                };
                bVar.cwq = new e() { // from class: com.baidu.rtc.p.24.2
                    @Override // com.baidu.rtc.e
                    public void a(b bVar2) {
                        p.this.f(bVar2);
                    }
                };
                p.this.cyE.put(bVar.cwh, bVar);
                p.this.cyC.put(bVar.cwo, bVar);
                p.this.d(bVar);
            }
        };
        dVar.cws = new n() { // from class: com.baidu.rtc.p.2
            @Override // com.baidu.rtc.n
            public void aD(JSONObject jSONObject) {
            }
        };
        this.czd.put(e, dVar);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("janus", "attach");
            jSONObject.putOpt("plugin", "janus.plugin.videoroom");
            jSONObject.putOpt("transaction", e);
            jSONObject.putOpt("session_id", this.cyY);
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
            jSONObject3.putOpt("session_id", this.cyY);
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

    public void e(long j, boolean z) {
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

    public void e(final b bVar) {
        String e = e((Integer) 12);
        d dVar = new d();
        dVar.tid = e;
        dVar.cwt = new o() { // from class: com.baidu.rtc.p.7
            @Override // com.baidu.rtc.o
            public void aE(JSONObject jSONObject) {
                p.this.mRoomId = jSONObject.optJSONObject("plugindata").optJSONObject("data").optLong(UbcStatConstant.KEY_CONTENT_ROOM);
                Log.v("createRoomWithoutRoomID", "Got RoomID:" + p.this.mRoomId);
                p.this.c(bVar);
            }
        };
        dVar.cws = new n() { // from class: com.baidu.rtc.p.8
            @Override // com.baidu.rtc.n
            public void aD(JSONObject jSONObject) {
                p.this.c(bVar);
            }
        };
        this.czd.put(e, dVar);
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
            if (!this.cyR.isEmpty() && this.cyT == BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ROOM_TRANSMISSION) {
                jSONObject3.putOpt("url", this.cyR);
                jSONObject3.putOpt("mixTemplate", this.cyM);
                jSONObject.putOpt(AlaRecorderLog.Protocol.RTMP, jSONObject3);
            } else if (!this.cyS.isEmpty() && this.cyU == BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ROOM_TRANSMISSION) {
                jSONObject3.putOpt("url", this.cyS);
                if (!this.cyN.isEmpty()) {
                    jSONObject3.putOpt("mixTemplate", this.cyN);
                }
                jSONObject.putOpt(AlaRecorderLog.Protocol.RTMP, jSONObject3);
            }
            if (this.cyO) {
                jSONObject4.putOpt("rec", Boolean.valueOf(this.cyO));
                jSONObject.putOpt("recording", jSONObject4);
            }
            jSONObject2.putOpt("janus", "message");
            jSONObject2.putOpt("body", jSONObject);
            jSONObject2.putOpt("transaction", e);
            jSONObject2.putOpt("session_id", this.cyY);
            jSONObject2.putOpt("handle_id", bVar.cwh);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        aF(jSONObject2);
    }

    public void eA(boolean z) {
        this.cyF = z;
    }

    public void eB(boolean z) {
        this.cyG = z;
    }

    public void eC(boolean z) {
        this.cyH = z;
    }

    public void eD(boolean z) {
        this.cyI = z;
    }

    public void eE(boolean z) {
        this.cyK = z;
    }

    public void eF(boolean z) {
        this.cyO = z;
    }

    public void ev(boolean z) {
        this.mHasAudio = z;
    }

    public void ew(boolean z) {
        this.cwM = z;
    }

    public void ex(boolean z) {
        this.mHasVideo = z;
    }

    public void f(final b bVar) {
        String e = e((Integer) 12);
        d dVar = new d();
        dVar.tid = e;
        dVar.cwt = new o() { // from class: com.baidu.rtc.p.3
            @Override // com.baidu.rtc.o
            public void aE(JSONObject jSONObject) {
                p.this.cyB.a(bVar.cwh, bVar.cwo);
                p.this.cyB.d(bVar.cwh);
                p.this.cyE.remove(bVar.cwh);
                p.this.cyC.remove(bVar.cwo);
            }
        };
        dVar.cws = new n() { // from class: com.baidu.rtc.p.4
            @Override // com.baidu.rtc.n
            public void aD(JSONObject jSONObject) {
            }
        };
        this.czd.put(e, dVar);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("janus", "detach");
            jSONObject.putOpt("transaction", e);
            jSONObject.putOpt("session_id", this.cyY);
            jSONObject.putOpt("handle_id", bVar.cwh);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        aF(jSONObject);
    }

    public void finalize() {
        this.mHandler.removeCallbacks(this.cyD);
        this.cyB = null;
        if (this.czc != null) {
            this.czc.close(1001, "going away");
        }
    }

    public long getRoomId() {
        return this.mRoomId;
    }

    public void hy(int i) {
        this.cyJ = i;
    }

    public void hz(int i) {
        this.cyW = i;
    }

    public BigInteger k(BigInteger bigInteger) {
        return this.cyE.get(bigInteger) == null ? BigInteger.valueOf(0L) : this.cyE.get(bigInteger).cwo;
    }

    public void kq(String str) {
        this.cyM = str;
    }

    public void kr(String str) {
        this.cyR = str;
    }

    public void ks(String str) {
        this.cyV = str;
    }

    public void kt(String str) {
        this.mRoomName = str;
    }

    public void ku(String str) {
        this.cyX = str;
    }

    public void kv(String str) {
        this.cyZ = str;
    }

    public String l(BigInteger bigInteger) {
        if (this.cza.get(bigInteger) == null) {
            return null;
        }
        return this.cza.get(bigInteger).userName;
    }

    public void m(BigInteger bigInteger) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.putOpt("completed", true);
            jSONObject2.putOpt("janus", "trickle");
            jSONObject2.putOpt("candidate", jSONObject);
            jSONObject2.putOpt("transaction", e((Integer) 12));
            jSONObject2.putOpt("session_id", this.cyY);
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
        dVar.cwt = new o() { // from class: com.baidu.rtc.p.13
            @Override // com.baidu.rtc.o
            public void aE(JSONObject jSONObject) {
                p.this.a(str, 0L, true);
            }
        };
        dVar.cws = new n() { // from class: com.baidu.rtc.p.14
            @Override // com.baidu.rtc.n
            public void aD(JSONObject jSONObject) {
            }
        };
        this.czd.put(e, dVar);
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
            jSONObject2.putOpt("session_id", this.cyY);
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
}
