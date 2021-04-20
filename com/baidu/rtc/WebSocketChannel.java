package com.baidu.rtc;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.upload.action.IMTrackDatabase;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.mobstat.Config;
import com.baidu.rtc.BaiduRtcRoom;
import com.baidu.rtc.internal.BaiduRtcRoomImp;
import com.baidu.rtc.logreport.ErrorInfoReport;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.webkit.internal.ETAG;
import com.baidubce.services.vod.VodClient;
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
/* loaded from: classes2.dex */
public class WebSocketChannel {
    public static final int NO_SET_VALID_ROOM_ID = -1160725808;
    public static final String TAG = "WebSocketChannel";
    public static OkHttpClient.Builder httpclientBuilder = new OkHttpClient.Builder().connectionPool(new ConnectionPool(5, 1, TimeUnit.MINUTES)).addInterceptor(new Interceptor() { // from class: com.baidu.rtc.WebSocketChannel.1
        @Override // okhttp3.Interceptor
        public Response intercept(Interceptor.Chain chain) throws IOException {
            Request.Builder newBuilder = chain.request().newBuilder();
            newBuilder.addHeader("Sec-WebSocket-Protocol", "janus-protocol");
            try {
                return chain.proceed(newBuilder.build());
            } catch (Exception unused) {
                throw new IOException("BRTC Connection error");
            }
        }
    });
    public static int kKeepAliveTimeMs = 25000;
    public JanusRTCInterface delegate;
    public Runnable fireKeepAlive;
    public Handler keepAliveTimer;
    public boolean mAutoPublish;
    public boolean mAutoSubScribe;
    public int mConnectionTimeoutMs;
    public Handler mHandler;
    public boolean mIsEnableErrorInfoMonitor;
    public boolean mLiveStreamingMix;
    public boolean mLiveStreamingMixSecond;
    public String mLiveStreamingMixTemplateSecond;
    public boolean mLiveStreamingRecording;
    public boolean mLiveStreamingRecordingSecond;
    public String mLiveStreamingServerURLSecond;
    public BaiduRtcRoom.RtcLiveTransferMode mLiveStreamingTransferMode;
    public BaiduRtcRoom.RtcLiveTransferMode mLiveStreamingTransferModeSecond;
    public String mMediaServerIP;
    public int mReadTimeoutMs;
    public String mRtcServerUrl;
    public BigInteger mSessionId;
    public ConcurrentHashMap<BigInteger, BaiduRtcRoom.RtcRoomUserInfo> mUserInfoList;
    public volatile BaiduRtcRoom.UserList mUserList;
    public WebSocket mWebSocket;
    public int serverAckTimeout;
    public Runnable serverKeepAliveTimeout;
    public ConcurrentHashMap<String, JanusTransaction> transactions = new ConcurrentHashMap<>();
    public ConcurrentHashMap<BigInteger, JanusHandle> handles = new ConcurrentHashMap<>();
    public ConcurrentHashMap<BigInteger, JanusHandle> feeds = new ConcurrentHashMap<>();
    public ConcurrentHashMap<String, JanusTransaction> ackTransactions = new ConcurrentHashMap<>();
    public long mUserId = (Build.SERIAL.hashCode() % 100000) + 78657895;
    public String mDisplayName = "Android-rtc";
    public String mRoomName = "";
    public String mVideoCodec = KsMediaFormat.CODEC_NAME_H264;
    public boolean mAsPublisher = true;
    public boolean mAsListener = true;
    public boolean mHasVideo = true;
    public boolean mHasAudio = true;
    public boolean mHasData = false;
    public long mRoomId = -1160725808;
    public String mAppId = "";
    public String mTokenStr = "";
    public String mLiveStreamingServerURL = "";
    public String mLiveStreamingRole = "";
    public String mLiveStreamingMixTemplate = "";
    public String mMixLayoutPosition = "";
    public String mSDKTag = "";

    public WebSocketChannel() {
        BaiduRtcRoom.RtcLiveTransferMode rtcLiveTransferMode = BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ANCHOR_TRASNSMISSION;
        this.mLiveStreamingTransferMode = rtcLiveTransferMode;
        this.mLiveStreamingMix = false;
        this.mLiveStreamingRecording = false;
        this.mLiveStreamingServerURLSecond = "";
        this.mLiveStreamingMixTemplateSecond = "";
        this.mLiveStreamingTransferModeSecond = rtcLiveTransferMode;
        this.mLiveStreamingMixSecond = false;
        this.mLiveStreamingRecordingSecond = false;
        this.mConnectionTimeoutMs = 5000;
        this.mReadTimeoutMs = 5000;
        this.serverAckTimeout = 5000;
        this.mAutoPublish = true;
        this.mAutoSubScribe = true;
        this.keepAliveTimer = null;
        this.mRtcServerUrl = "";
        this.mMediaServerIP = "";
        this.mIsEnableErrorInfoMonitor = true;
        this.mUserList = null;
        this.mUserInfoList = new ConcurrentHashMap<>();
        this.fireKeepAlive = new Runnable() { // from class: com.baidu.rtc.WebSocketChannel.32
            @Override // java.lang.Runnable
            public void run() {
                WebSocketChannel.this.keepAlive();
                WebSocketChannel.this.mHandler.postDelayed(WebSocketChannel.this.fireKeepAlive, WebSocketChannel.kKeepAliveTimeMs);
            }
        };
        this.serverKeepAliveTimeout = new Runnable() { // from class: com.baidu.rtc.WebSocketChannel.33
            @Override // java.lang.Runnable
            public void run() {
                if (WebSocketChannel.this.delegate != null) {
                    WebSocketChannel.this.delegate.onServerAckTimeout();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper());
        this.keepAliveTimer = new Handler(Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createSession() {
        String randomString = randomString(12);
        JanusTransaction janusTransaction = new JanusTransaction();
        janusTransaction.tid = randomString;
        janusTransaction.success = new TransactionCallbackSuccess() { // from class: com.baidu.rtc.WebSocketChannel.5
            @Override // com.baidu.rtc.TransactionCallbackSuccess
            public void success(JSONObject jSONObject) {
                WebSocketChannel.this.mSessionId = new BigInteger(jSONObject.optJSONObject("data").optString("id"));
                ErrorInfoReport.getInstance().setSessionId(WebSocketChannel.this.mSessionId.longValue());
                WebSocketChannel.this.mHandler.postDelayed(WebSocketChannel.this.fireKeepAlive, WebSocketChannel.kKeepAliveTimeMs);
                WebSocketChannel.this.publisherCreateHandle();
            }
        };
        janusTransaction.error = new TransactionCallbackError() { // from class: com.baidu.rtc.WebSocketChannel.6
            @Override // com.baidu.rtc.TransactionCallbackError
            public void error(JSONObject jSONObject) {
            }
        };
        this.transactions.put(randomString, janusTransaction);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("janus", "create");
            jSONObject.putOpt("transaction", randomString);
            if (!this.mSDKTag.isEmpty()) {
                jSONObject.putOpt("sdktag", this.mSDKTag);
            }
            if (!this.mMediaServerIP.isEmpty()) {
                jSONObject.putOpt("janusIp", this.mMediaServerIP);
            }
            jSONObject.putOpt("uri", this.mRtcServerUrl);
            jSONObject.putOpt("sessionevent", Boolean.TRUE);
            jSONObject.putOpt("userevent", Boolean.TRUE);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        sendMessage(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doLeaveRoom(JanusHandle janusHandle) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.putOpt("request", "leave");
            jSONObject2.putOpt("janus", "message");
            jSONObject2.putOpt("body", jSONObject);
            jSONObject2.putOpt("transaction", randomString(12));
            jSONObject2.putOpt(ETAG.KEY_STATISTICS_SEESIONID, this.mSessionId);
            jSONObject2.putOpt("handle_id", janusHandle.handleId);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        sendMessage(jSONObject2);
    }

    public static String encodeURIComponent(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8").replaceAll("\\+", "%20").replaceAll("\\%21", "!").replaceAll("\\%27", "'").replaceAll("\\%28", "(").replaceAll("\\%29", SmallTailInfo.EMOTION_SUFFIX).replaceAll("\\%7E", Constants.WAVE_SEPARATOR);
        } catch (UnsupportedEncodingException unused) {
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void keepAlive() {
        String randomString = randomString(12);
        JanusTransaction janusTransaction = new JanusTransaction();
        janusTransaction.tid = randomString;
        janusTransaction.success = new TransactionCallbackSuccess() { // from class: com.baidu.rtc.WebSocketChannel.13
            @Override // com.baidu.rtc.TransactionCallbackSuccess
            public void success(JSONObject jSONObject) {
                WebSocketChannel.this.keepAliveTimer.removeCallbacks(WebSocketChannel.this.serverKeepAliveTimeout);
            }
        };
        janusTransaction.error = new TransactionCallbackError() { // from class: com.baidu.rtc.WebSocketChannel.14
            @Override // com.baidu.rtc.TransactionCallbackError
            public void error(JSONObject jSONObject) {
                WebSocketChannel.this.keepAliveTimer.removeCallbacks(WebSocketChannel.this.serverKeepAliveTimeout);
            }
        };
        this.ackTransactions.put(randomString, janusTransaction);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("janus", "keepalive");
            jSONObject.putOpt(ETAG.KEY_STATISTICS_SEESIONID, this.mSessionId);
            jSONObject.putOpt("transaction", randomString);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        this.keepAliveTimer.removeCallbacks(this.serverKeepAliveTimeout);
        this.keepAliveTimer.postDelayed(this.serverKeepAliveTimeout, this.serverAckTimeout);
        sendMessage(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onMessage(String str) {
        long optLong;
        JanusRTCInterface janusRTCInterface;
        JSONArray optJSONArray;
        String optString;
        ConcurrentHashMap<String, JanusTransaction> concurrentHashMap;
        if (BaiduRtcRoomImp.mbEnableDebugLog) {
            Log.i(TAG, "onMessage" + str);
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString2 = jSONObject.optString("janus");
            if (!optString2.equals("success")) {
                if (optString2.equals("error")) {
                    String optString3 = jSONObject.optString("transaction");
                    JanusTransaction janusTransaction = this.transactions.get(optString3);
                    if (janusTransaction != null && janusTransaction.error != null) {
                        janusTransaction.error.error(jSONObject);
                    }
                    this.transactions.remove(optString3);
                    if (!jSONObject.has("error")) {
                        return;
                    }
                    String optString4 = jSONObject.optJSONObject("error").optString("reason");
                    if (optString4.contains("Room is disbanded")) {
                        if (this.delegate != null) {
                            this.delegate.onRoomDisbanded();
                            return;
                        }
                        return;
                    } else if (!optString4.contains("User is kick out") || this.delegate == null) {
                        return;
                    } else {
                        janusRTCInterface = this.delegate;
                        optLong = this.mUserId;
                    }
                } else if (optString2.equals(IMTrackDatabase.AckEnum.TABLE_NAME)) {
                    optString = jSONObject.optString("transaction");
                    JanusTransaction janusTransaction2 = this.ackTransactions.get(optString);
                    if (janusTransaction2 != null && janusTransaction2.success != null) {
                        janusTransaction2.success.success(jSONObject);
                    }
                    concurrentHashMap = this.ackTransactions;
                } else if (optString2.equals("timeout")) {
                    this.mHandler.removeCallbacks(this.fireKeepAlive);
                    this.keepAliveTimer.removeCallbacks(this.serverKeepAliveTimeout);
                    if (this.mIsEnableErrorInfoMonitor) {
                        ErrorInfoReport.getInstance().reportErrorInfo(ErrorInfoReport.ErrorCode.KEEPALIVE_TIMEOUT);
                    }
                    if (this.delegate != null) {
                        this.delegate.onConnectError();
                        return;
                    }
                    return;
                } else if (optString2.equals("slowlink")) {
                    this.delegate.onSlowLink(jSONObject.optBoolean("uplink"), jSONObject.optInt("nacks"));
                    return;
                } else if (!optString2.equals("sessionevent")) {
                    if (jSONObject.has("sender")) {
                        final JanusHandle janusHandle = this.handles.get(new BigInteger(jSONObject.optString("sender")));
                        if (janusHandle == null) {
                            Log.e(TAG, "missing handle");
                            return;
                        } else if (!optString2.equals("event")) {
                            if (optString2.equals("detached")) {
                                janusHandle.onLeaving.onJoined(janusHandle);
                                return;
                            } else if (optString2.equals("webrtcup")) {
                                this.delegate.onWebrtcUp(janusHandle.handleId);
                                return;
                            } else if (!optString2.equals(VodClient.PATH_MEDIA)) {
                                if (!optString2.equals("hangup") || this.delegate == null) {
                                    return;
                                }
                                this.delegate.onHangUp(janusHandle.handleId);
                                return;
                            } else {
                                boolean z = jSONObject.getBoolean("receiving");
                                String string = jSONObject.getString("type");
                                if (this.delegate != null) {
                                    this.delegate.onMediaStreamingEvent(janusHandle.handleId, string.contains("video") ? 1 : 0, z);
                                    return;
                                }
                                return;
                            }
                        } else {
                            JSONObject optJSONObject = jSONObject.optJSONObject("plugindata").optJSONObject("data");
                            if (optJSONObject.optString("videoroom").equals("joined")) {
                                janusHandle.onJoined.onJoined(janusHandle);
                            } else if (optJSONObject.optString("videoroom").equals("event")) {
                                if (optJSONObject.has("error_code")) {
                                    this.delegate.onSignalErrorInfo(optJSONObject.optInt("error_code"));
                                }
                                if (optJSONObject.optInt("error_code") == 436) {
                                    Log.e(TAG, "error_code 436， so try again。");
                                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.rtc.WebSocketChannel.4
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            WebSocketChannel.this.publisherJoinRoom(janusHandle);
                                        }
                                    }, 2000L);
                                }
                            }
                            JSONArray optJSONArray2 = optJSONObject.optJSONArray("publishers");
                            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                                int length = optJSONArray2.length();
                                for (int i = 0; i <= length - 1; i++) {
                                    JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i);
                                    BigInteger bigInteger = new BigInteger(optJSONObject2.optString("id"));
                                    String optString5 = optJSONObject2.optString("display");
                                    this.delegate.onComing(bigInteger, optString5);
                                    if (this.mAsListener && this.mAutoSubScribe) {
                                        subscriberCreateHandle(bigInteger, optString5);
                                    }
                                }
                            }
                            String optString6 = optJSONObject.optString("leaving");
                            if (!TextUtils.isEmpty(optString6) && !optString6.equals("ok")) {
                                this.delegate.onLeaving(janusHandle.handleId, new BigInteger(optString6));
                                JanusHandle janusHandle2 = this.feeds.get(new BigInteger(optString6));
                                if (janusHandle2 != null && janusHandle2.onLeaving != null) {
                                    janusHandle2.onLeaving.onJoined(janusHandle2);
                                }
                            }
                            String optString7 = optJSONObject.optString("unpublished");
                            if (!TextUtils.isEmpty(optString7)) {
                                if (!optString7.equals("ok") && !optString7.equals("self")) {
                                    this.delegate.onLeaving(janusHandle.handleId, new BigInteger(optString7));
                                    JanusHandle janusHandle3 = this.feeds.get(new BigInteger(optString7));
                                    if (janusHandle3 != null && janusHandle3.onLeaving != null) {
                                        janusHandle3.onLeaving.onJoined(janusHandle3);
                                    }
                                } else if (optString7.equals("self") && optJSONObject.has("servertrigger")) {
                                    this.delegate.onHangUp(janusHandle.handleId);
                                }
                            }
                            JSONObject optJSONObject3 = jSONObject.optJSONObject("jsep");
                            if (optJSONObject3 != null) {
                                janusHandle.onRemoteJsep.onRemoteJsep(janusHandle, optJSONObject3);
                                return;
                            }
                            return;
                        }
                    }
                    return;
                } else if (jSONObject.has("recvdata")) {
                    JSONObject optJSONObject4 = jSONObject.optJSONObject("recvdata");
                    if (!optJSONObject4.optBoolean("internal")) {
                        this.delegate.onMessage(new BigInteger(optJSONObject4.optString("from")), optJSONObject4.optString("data"));
                        return;
                    }
                    BaiduRtcRoom.RtcRoomUserInfo rtcRoomUserInfo = this.mUserInfoList.get(BigInteger.valueOf(optJSONObject4.optLong("from")));
                    if (rtcRoomUserInfo != null) {
                        rtcRoomUserInfo.attribute = optJSONObject4.optString("data");
                    }
                    this.delegate.onAttribute(new BigInteger(optJSONObject4.optString("from")), optJSONObject4.optString("data"));
                    return;
                } else {
                    String str2 = "";
                    if (jSONObject.has("userevent")) {
                        JSONObject optJSONObject5 = jSONObject.optJSONObject("userevent");
                        if (optJSONObject5.has("joined")) {
                            BaiduRtcRoom.RtcRoomUserInfo rtcRoomUserInfo2 = new BaiduRtcRoom.RtcRoomUserInfo();
                            rtcRoomUserInfo2.userId = optJSONObject5.optLong("joined");
                            rtcRoomUserInfo2.userName = optJSONObject5.optString("display");
                            rtcRoomUserInfo2.attribute = optJSONObject5.optString(Config.EVENT_ATTR);
                            this.mUserInfoList.put(BigInteger.valueOf(rtcRoomUserInfo2.userId), rtcRoomUserInfo2);
                            this.delegate.onUserJoinedRoom(new BigInteger(optJSONObject5.optString("joined")), optJSONObject5.optString("display"), "");
                            return;
                        } else if (optJSONObject5.has("leaving")) {
                            this.mUserInfoList.remove(BigInteger.valueOf(optJSONObject5.optLong("leaving")));
                            this.delegate.onUserLeavingRoom(new BigInteger(optJSONObject5.optString("leaving")));
                            return;
                        } else if (!optJSONObject5.has("users") || (optJSONArray = optJSONObject5.optJSONArray("users")) == null || optJSONArray.length() <= 0) {
                            return;
                        } else {
                            int length2 = optJSONArray.length();
                            for (int i2 = 0; i2 <= length2 - 1; i2++) {
                                JSONObject optJSONObject6 = optJSONArray.optJSONObject(i2);
                                BigInteger bigInteger2 = new BigInteger(optJSONObject6.optString("id"));
                                String optString8 = optJSONObject6.optString("display");
                                BaiduRtcRoom.RtcRoomUserInfo rtcRoomUserInfo3 = new BaiduRtcRoom.RtcRoomUserInfo();
                                rtcRoomUserInfo3.userId = optJSONObject6.optLong("id");
                                rtcRoomUserInfo3.userName = optJSONObject6.optString("display");
                                rtcRoomUserInfo3.attribute = optJSONObject6.optString(Config.EVENT_ATTR);
                                this.mUserInfoList.put(bigInteger2, rtcRoomUserInfo3);
                                this.delegate.onUserJoinedRoom(bigInteger2, optString8, "");
                                String optString9 = optJSONObject6.optString(Config.EVENT_ATTR);
                                if (!optString9.isEmpty()) {
                                    this.delegate.onAttribute(bigInteger2, optString9);
                                }
                            }
                            return;
                        }
                    } else if (jSONObject.has("detached")) {
                        return;
                    } else {
                        if (jSONObject.has("forwardconfigure")) {
                            JSONObject optJSONObject7 = jSONObject.optJSONObject("forwardconfigure");
                            long optLong2 = Boolean.valueOf(optJSONObject7.optBoolean("self")).booleanValue() ? this.mUserId : optJSONObject7.optLong("id");
                            Boolean valueOf = Boolean.valueOf(optJSONObject7.optBoolean("video"));
                            Boolean valueOf2 = Boolean.valueOf(optJSONObject7.optBoolean("audio"));
                            if (valueOf.booleanValue() && valueOf2.booleanValue()) {
                                this.delegate.onUserDisShutUp(optLong2);
                                return;
                            } else if (valueOf.booleanValue() || valueOf2.booleanValue()) {
                                return;
                            } else {
                                this.delegate.onUserShutUp(optLong2);
                                return;
                            }
                        } else if (!jSONObject.has("userkickout")) {
                            if (jSONObject.has("bypass_event")) {
                                JSONObject optJSONObject8 = jSONObject.optJSONObject("bypass_event");
                                BaiduRtcRoom.RtcLiveTransferMode rtcLiveTransferMode = optJSONObject8.optString("level").contains("room") ? BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ROOM_TRANSMISSION : BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ANCHOR_TRASNSMISSION;
                                if (optJSONObject8.has("rtmp")) {
                                    JSONObject optJSONObject9 = optJSONObject8.optJSONObject("rtmp");
                                    if (optJSONObject9.has("url")) {
                                        str2 = optJSONObject9.optString("url");
                                    }
                                }
                                String optString10 = optJSONObject8.optString("bypassStatus");
                                if (optString10.contains("success")) {
                                    this.delegate.onLivePublishSucceed(rtcLiveTransferMode, str2);
                                    return;
                                } else if (optString10.contains(SmsLoginView.f.l)) {
                                    this.delegate.onLivePublishFailed(rtcLiveTransferMode, str2);
                                    return;
                                } else if (optString10.contains("break")) {
                                    this.delegate.onLivePublishInterrupted(rtcLiveTransferMode, str2);
                                    return;
                                } else {
                                    return;
                                }
                            }
                            return;
                        } else {
                            optLong = jSONObject.optJSONObject("userkickout").optLong("id");
                            janusRTCInterface = this.delegate;
                        }
                    }
                }
                janusRTCInterface.onUserKickOff(optLong);
                return;
            }
            optString = jSONObject.optString("transaction");
            JanusTransaction janusTransaction3 = this.transactions.get(optString);
            if (janusTransaction3 != null && janusTransaction3.success != null) {
                janusTransaction3.success.success(jSONObject);
            }
            concurrentHashMap = this.transactions;
            concurrentHashMap.remove(optString);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void publisherCreateHandle() {
        String randomString = randomString(12);
        JanusTransaction janusTransaction = new JanusTransaction();
        janusTransaction.tid = randomString;
        janusTransaction.success = new TransactionCallbackSuccess() { // from class: com.baidu.rtc.WebSocketChannel.7
            @Override // com.baidu.rtc.TransactionCallbackSuccess
            public void success(JSONObject jSONObject) {
                JanusHandle janusHandle = new JanusHandle();
                janusHandle.handleId = new BigInteger(jSONObject.optJSONObject("data").optString("id"));
                janusHandle.onJoined = new OnJoined() { // from class: com.baidu.rtc.WebSocketChannel.7.1
                    @Override // com.baidu.rtc.OnJoined
                    public void onJoined(JanusHandle janusHandle2) {
                        if (WebSocketChannel.this.delegate != null) {
                            WebSocketChannel.this.delegate.onPublisherJoined(janusHandle2.handleId);
                        }
                    }
                };
                janusHandle.onRemoteJsep = new OnRemoteJsep() { // from class: com.baidu.rtc.WebSocketChannel.7.2
                    @Override // com.baidu.rtc.OnRemoteJsep
                    public void onRemoteJsep(JanusHandle janusHandle2, JSONObject jSONObject2) {
                        if (WebSocketChannel.this.delegate != null) {
                            WebSocketChannel.this.delegate.onPublisherRemoteJsep(janusHandle2.handleId, jSONObject2);
                        }
                    }
                };
                WebSocketChannel.this.handles.put(janusHandle.handleId, janusHandle);
                if (WebSocketChannel.this.delegate == null) {
                    return;
                }
                WebSocketChannel.this.delegate.onCreatedHandle(janusHandle.handleId, WebSocketChannel.this.mRoomId);
                if (WebSocketChannel.this.mRoomId == -1160725808) {
                    WebSocketChannel.this.createRoomWithoutRoomID(janusHandle);
                    return;
                }
                ErrorInfoReport.getInstance().setRoomId(WebSocketChannel.this.mRoomId);
                WebSocketChannel webSocketChannel = WebSocketChannel.this;
                webSocketChannel.createRoom(webSocketChannel.mRoomId, WebSocketChannel.this.mRoomName, janusHandle);
            }
        };
        janusTransaction.error = new TransactionCallbackError() { // from class: com.baidu.rtc.WebSocketChannel.8
            @Override // com.baidu.rtc.TransactionCallbackError
            public void error(JSONObject jSONObject) {
            }
        };
        this.transactions.put(randomString, janusTransaction);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("janus", "attach");
            jSONObject.putOpt("plugin", "janus.plugin.videoroom");
            jSONObject.putOpt("transaction", randomString);
            jSONObject.putOpt(ETAG.KEY_STATISTICS_SEESIONID, this.mSessionId);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        sendMessage(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ce A[Catch: JSONException -> 0x0109, TryCatch #0 {JSONException -> 0x0109, blocks: (B:3:0x0016, B:5:0x0062, B:6:0x006a, B:9:0x007b, B:11:0x0081, B:13:0x008e, B:14:0x0093, B:15:0x009c, B:24:0x00ca, B:26:0x00ce, B:27:0x00de, B:16:0x00a0, B:18:0x00a8, B:20:0x00ae, B:22:0x00bb, B:23:0x00c0), top: B:33:0x0016 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void publisherJoinRoom(JanusHandle janusHandle) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        JSONObject jSONObject4 = new JSONObject();
        try {
            jSONObject2.putOpt("request", "join");
            jSONObject2.putOpt("room", Long.valueOf(this.mRoomId));
            jSONObject2.putOpt("ptype", "publisher");
            jSONObject2.putOpt("display", this.mDisplayName);
            jSONObject2.putOpt("id", Long.valueOf(this.mUserId));
            jSONObject2.putOpt(Constants.APP_ID, this.mAppId);
            jSONObject2.putOpt(DpStatConstants.KEY_ROOM_NAME, this.mRoomName);
            jSONObject2.putOpt("role", "publisher");
            jSONObject2.putOpt("token", "no_token");
            if (!this.mMixLayoutPosition.isEmpty()) {
                jSONObject2.putOpt("window_id_in_bypass", this.mMixLayoutPosition);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        if (this.mLiveStreamingServerURL.isEmpty() || this.mLiveStreamingTransferMode != BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ANCHOR_TRASNSMISSION) {
            if (!this.mLiveStreamingServerURLSecond.isEmpty() && this.mLiveStreamingTransferModeSecond == BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ANCHOR_TRASNSMISSION) {
                jSONObject3.putOpt("url", this.mLiveStreamingServerURLSecond);
                if (!this.mLiveStreamingMixTemplateSecond.isEmpty()) {
                    jSONObject3.putOpt("mixTemplate", this.mLiveStreamingMixTemplateSecond);
                }
                jSONObject3.putOpt("mix", Boolean.valueOf(this.mLiveStreamingMixSecond));
            }
            if (this.mLiveStreamingRecording) {
                jSONObject4.putOpt("rec", Boolean.valueOf(this.mLiveStreamingRecording));
                jSONObject2.putOpt("recording", jSONObject4);
            }
            jSONObject.putOpt("janus", "message");
            jSONObject.putOpt("body", jSONObject2);
            jSONObject.putOpt("transaction", randomString(12));
            jSONObject.putOpt(ETAG.KEY_STATISTICS_SEESIONID, this.mSessionId);
            jSONObject.putOpt("handle_id", janusHandle.handleId);
            sendMessage(jSONObject);
        }
        jSONObject3.putOpt("url", this.mLiveStreamingServerURL);
        if (!this.mLiveStreamingMixTemplate.isEmpty()) {
            jSONObject3.putOpt("mixTemplate", this.mLiveStreamingMixTemplate);
        }
        jSONObject3.putOpt("mix", Boolean.valueOf(this.mLiveStreamingMix));
        jSONObject2.putOpt("rtmp", jSONObject3);
        if (this.mLiveStreamingRecording) {
        }
        jSONObject.putOpt("janus", "message");
        jSONObject.putOpt("body", jSONObject2);
        jSONObject.putOpt("transaction", randomString(12));
        jSONObject.putOpt(ETAG.KEY_STATISTICS_SEESIONID, this.mSessionId);
        jSONObject.putOpt("handle_id", janusHandle.handleId);
        sendMessage(jSONObject);
    }

    private String randomString(Integer num) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(num.intValue());
        for (int i = 0; i < num.intValue(); i++) {
            sb.append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt(random.nextInt(62)));
        }
        return sb.toString();
    }

    private void sendMessage(JSONObject jSONObject) {
        WebSocket webSocket = this.mWebSocket;
        if (webSocket != null) {
            webSocket.send(jSONObject.toString());
        }
        if (BaiduRtcRoomImp.mbEnableDebugLog) {
            Log.i(TAG, jSONObject.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void subscriberJoinRoom(JanusHandle janusHandle) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt("request", "join");
            jSONObject2.putOpt("room", Long.valueOf(this.mRoomId));
            jSONObject2.putOpt("ptype", "listener");
            jSONObject2.putOpt("feed", janusHandle.feedId);
            jSONObject2.putOpt("id", Long.valueOf(this.mUserId));
            jSONObject2.putOpt(Constants.APP_ID, this.mAppId);
            jSONObject2.putOpt(DpStatConstants.KEY_ROOM_NAME, this.mRoomName);
            jSONObject2.putOpt("token", this.mTokenStr);
            jSONObject2.putOpt("role", "listener");
            if (!this.mMixLayoutPosition.isEmpty()) {
                jSONObject2.putOpt("window_id_in_bypass", this.mMixLayoutPosition);
            }
            jSONObject.putOpt("janus", "message");
            jSONObject.putOpt("body", jSONObject2);
            jSONObject.putOpt("transaction", randomString(12));
            jSONObject.putOpt(ETAG.KEY_STATISTICS_SEESIONID, this.mSessionId);
            jSONObject.putOpt("handle_id", janusHandle.handleId);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        sendMessage(jSONObject);
    }

    public void Send(JSONObject jSONObject) {
        String randomString = randomString(12);
        JanusTransaction janusTransaction = new JanusTransaction();
        janusTransaction.tid = randomString;
        janusTransaction.success = new TransactionCallbackSuccess() { // from class: com.baidu.rtc.WebSocketChannel.30
            @Override // com.baidu.rtc.TransactionCallbackSuccess
            public void success(JSONObject jSONObject2) {
            }
        };
        janusTransaction.error = new TransactionCallbackError() { // from class: com.baidu.rtc.WebSocketChannel.31
            @Override // com.baidu.rtc.TransactionCallbackError
            public void error(JSONObject jSONObject2) {
            }
        };
        this.transactions.put(randomString, janusTransaction);
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt("janus", "message");
            jSONObject2.putOpt("body", jSONObject);
            jSONObject2.putOpt("transaction", randomString);
            jSONObject2.putOpt(ETAG.KEY_STATISTICS_SEESIONID, this.mSessionId);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        sendMessage(jSONObject2);
    }

    public BaiduRtcRoom.RtcRoomUserInfo[] UserInfoList() {
        if (this.mUserInfoList.size() < 1) {
            return null;
        }
        BaiduRtcRoom.RtcRoomUserInfo[] rtcRoomUserInfoArr = new BaiduRtcRoom.RtcRoomUserInfo[this.mUserInfoList.size()];
        int i = 0;
        for (BaiduRtcRoom.RtcRoomUserInfo rtcRoomUserInfo : this.mUserInfoList.values()) {
            rtcRoomUserInfoArr[i] = new BaiduRtcRoom.RtcRoomUserInfo();
            rtcRoomUserInfoArr[i].userId = rtcRoomUserInfo.userId;
            rtcRoomUserInfoArr[i].userName = rtcRoomUserInfo.userName;
            rtcRoomUserInfoArr[i].attribute = rtcRoomUserInfo.attribute;
            i++;
        }
        return rtcRoomUserInfoArr;
    }

    public BaiduRtcRoom.UserList UserListOfRoom() {
        String randomString = randomString(12);
        JanusTransaction janusTransaction = new JanusTransaction();
        janusTransaction.tid = randomString;
        janusTransaction.success = new TransactionCallbackSuccess() { // from class: com.baidu.rtc.WebSocketChannel.19
            @Override // com.baidu.rtc.TransactionCallbackSuccess
            public void success(JSONObject jSONObject) {
                JSONArray optJSONArray = jSONObject.optJSONObject("plugindata").optJSONObject("data").optJSONArray("publishers");
                JSONArray optJSONArray2 = jSONObject.optJSONObject("plugindata").optJSONObject("data").optJSONArray("listeners");
                if (optJSONArray != null) {
                    BaiduRtcRoom.UserList userList = new BaiduRtcRoom.UserList(optJSONArray.length(), optJSONArray2.length());
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        userList.Publishers[i] = optJSONArray.optJSONObject(i).optInt("clientUserId");
                    }
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        userList.Listeners[i2] = optJSONArray2.optJSONObject(i2).optInt("clientUserId");
                    }
                    WebSocketChannel.this.mUserList = userList;
                }
                synchronized (WebSocketChannel.this) {
                    try {
                        WebSocketChannel.this.notifyAll();
                    } catch (Exception unused) {
                    }
                }
            }
        };
        janusTransaction.error = new TransactionCallbackError() { // from class: com.baidu.rtc.WebSocketChannel.20
            @Override // com.baidu.rtc.TransactionCallbackError
            public void error(JSONObject jSONObject) {
            }
        };
        this.transactions.put(randomString, janusTransaction);
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.putOpt("request", "listparticipants");
            jSONObject.putOpt("room", Long.valueOf(this.mRoomId));
            jSONObject2.putOpt("janus", "message");
            jSONObject2.putOpt("body", jSONObject);
            jSONObject2.putOpt("transaction", randomString);
            jSONObject2.putOpt(ETAG.KEY_STATISTICS_SEESIONID, this.mSessionId);
            jSONObject2.putOpt("handle_id", ((JanusHandle) this.handles.values().toArray()[0]).handleId);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        sendMessage(jSONObject2);
        synchronized (this) {
            try {
                wait(1000L);
            } catch (Exception unused) {
            }
        }
        return this.mUserList;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00be A[Catch: JSONException -> 0x00ef, TryCatch #0 {JSONException -> 0x00ef, blocks: (B:3:0x0038, B:6:0x007d, B:8:0x0083, B:10:0x0090, B:11:0x0095, B:19:0x00ba, B:21:0x00be, B:22:0x00ce, B:12:0x0099, B:14:0x00a1, B:16:0x00a7, B:18:0x00b4), top: B:28:0x0038 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void createRoom(long j, String str, final JanusHandle janusHandle) {
        String randomString = randomString(12);
        JanusTransaction janusTransaction = new JanusTransaction();
        janusTransaction.tid = randomString;
        janusTransaction.success = new TransactionCallbackSuccess() { // from class: com.baidu.rtc.WebSocketChannel.15
            @Override // com.baidu.rtc.TransactionCallbackSuccess
            public void success(JSONObject jSONObject) {
                WebSocketChannel.this.publisherJoinRoom(janusHandle);
            }
        };
        janusTransaction.error = new TransactionCallbackError() { // from class: com.baidu.rtc.WebSocketChannel.16
            @Override // com.baidu.rtc.TransactionCallbackError
            public void error(JSONObject jSONObject) {
                WebSocketChannel.this.publisherJoinRoom(janusHandle);
            }
        };
        this.transactions.put(randomString, janusTransaction);
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        JSONObject jSONObject4 = new JSONObject();
        try {
            jSONObject.putOpt("request", "create");
            jSONObject.putOpt("room", Long.valueOf(j));
            jSONObject.putOpt("description", str);
            jSONObject.putOpt("publishers", 1000);
            jSONObject.putOpt("is_private", Boolean.FALSE);
            jSONObject.putOpt("videocodec", this.mVideoCodec);
            jSONObject.putOpt("playoutdelay_ext", Boolean.TRUE);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        if (this.mLiveStreamingServerURL.isEmpty() || this.mLiveStreamingTransferMode != BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ROOM_TRANSMISSION) {
            if (!this.mLiveStreamingServerURLSecond.isEmpty() && this.mLiveStreamingTransferModeSecond == BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ROOM_TRANSMISSION) {
                jSONObject3.putOpt("url", this.mLiveStreamingServerURLSecond);
                if (!this.mLiveStreamingMixTemplateSecond.isEmpty()) {
                    jSONObject3.putOpt("mixTemplate", this.mLiveStreamingMixTemplateSecond);
                }
            }
            if (this.mLiveStreamingRecording) {
                jSONObject4.putOpt("rec", Boolean.valueOf(this.mLiveStreamingRecording));
                jSONObject.putOpt("recording", jSONObject4);
            }
            jSONObject2.putOpt("janus", "message");
            jSONObject2.putOpt("body", jSONObject);
            jSONObject2.putOpt("transaction", randomString);
            jSONObject2.putOpt(ETAG.KEY_STATISTICS_SEESIONID, this.mSessionId);
            jSONObject2.putOpt("handle_id", janusHandle.handleId);
            sendMessage(jSONObject2);
        }
        jSONObject3.putOpt("url", this.mLiveStreamingServerURL);
        if (!this.mLiveStreamingMixTemplate.isEmpty()) {
            jSONObject3.putOpt("mixTemplate", this.mLiveStreamingMixTemplate);
        }
        jSONObject.putOpt("rtmp", jSONObject3);
        if (this.mLiveStreamingRecording) {
        }
        jSONObject2.putOpt("janus", "message");
        jSONObject2.putOpt("body", jSONObject);
        jSONObject2.putOpt("transaction", randomString);
        jSONObject2.putOpt(ETAG.KEY_STATISTICS_SEESIONID, this.mSessionId);
        jSONObject2.putOpt("handle_id", janusHandle.handleId);
        sendMessage(jSONObject2);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00c8 A[Catch: JSONException -> 0x00f9, TryCatch #0 {JSONException -> 0x00f9, blocks: (B:3:0x0038, B:6:0x008f, B:8:0x0095, B:9:0x009f, B:17:0x00c4, B:19:0x00c8, B:20:0x00d8, B:10:0x00a3, B:12:0x00ab, B:14:0x00b1, B:16:0x00be), top: B:26:0x0038 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void createRoomWithoutRoomID(final JanusHandle janusHandle) {
        String randomString = randomString(12);
        JanusTransaction janusTransaction = new JanusTransaction();
        janusTransaction.tid = randomString;
        janusTransaction.success = new TransactionCallbackSuccess() { // from class: com.baidu.rtc.WebSocketChannel.17
            @Override // com.baidu.rtc.TransactionCallbackSuccess
            public void success(JSONObject jSONObject) {
                WebSocketChannel.this.mRoomId = jSONObject.optJSONObject("plugindata").optJSONObject("data").optLong("room");
                Log.v("createRoomWithoutRoomID", "Got RoomID:" + WebSocketChannel.this.mRoomId);
                ErrorInfoReport.getInstance().setRoomId(WebSocketChannel.this.mRoomId);
                WebSocketChannel.this.publisherJoinRoom(janusHandle);
            }
        };
        janusTransaction.error = new TransactionCallbackError() { // from class: com.baidu.rtc.WebSocketChannel.18
            @Override // com.baidu.rtc.TransactionCallbackError
            public void error(JSONObject jSONObject) {
                WebSocketChannel.this.publisherJoinRoom(janusHandle);
            }
        };
        this.transactions.put(randomString, janusTransaction);
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        JSONObject jSONObject4 = new JSONObject();
        try {
            jSONObject.putOpt("request", "create");
            jSONObject.putOpt("id", Long.valueOf(this.mUserId));
            jSONObject.putOpt(Constants.APP_ID, this.mAppId);
            jSONObject.putOpt(DpStatConstants.KEY_ROOM_NAME, this.mRoomName);
            jSONObject.putOpt("description", this.mRoomName);
            jSONObject.putOpt("publishers", 1000);
            jSONObject.putOpt("is_private", Boolean.FALSE);
            jSONObject.putOpt("videocodec", this.mVideoCodec);
            jSONObject.putOpt("playoutdelay_ext", Boolean.TRUE);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        if (this.mLiveStreamingServerURL.isEmpty() || this.mLiveStreamingTransferMode != BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ROOM_TRANSMISSION) {
            if (!this.mLiveStreamingServerURLSecond.isEmpty() && this.mLiveStreamingTransferModeSecond == BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ROOM_TRANSMISSION) {
                jSONObject3.putOpt("url", this.mLiveStreamingServerURLSecond);
                if (!this.mLiveStreamingMixTemplateSecond.isEmpty()) {
                    jSONObject3.putOpt("mixTemplate", this.mLiveStreamingMixTemplateSecond);
                }
            }
            if (this.mLiveStreamingRecording) {
                jSONObject4.putOpt("rec", Boolean.valueOf(this.mLiveStreamingRecording));
                jSONObject.putOpt("recording", jSONObject4);
            }
            jSONObject2.putOpt("janus", "message");
            jSONObject2.putOpt("body", jSONObject);
            jSONObject2.putOpt("transaction", randomString);
            jSONObject2.putOpt(ETAG.KEY_STATISTICS_SEESIONID, this.mSessionId);
            jSONObject2.putOpt("handle_id", janusHandle.handleId);
            sendMessage(jSONObject2);
        }
        jSONObject3.putOpt("url", this.mLiveStreamingServerURL);
        jSONObject3.putOpt("mixTemplate", this.mLiveStreamingMixTemplate);
        jSONObject.putOpt("rtmp", jSONObject3);
        if (this.mLiveStreamingRecording) {
        }
        jSONObject2.putOpt("janus", "message");
        jSONObject2.putOpt("body", jSONObject);
        jSONObject2.putOpt("transaction", randomString);
        jSONObject2.putOpt(ETAG.KEY_STATISTICS_SEESIONID, this.mSessionId);
        jSONObject2.putOpt("handle_id", janusHandle.handleId);
        sendMessage(jSONObject2);
    }

    public void disbandRoom() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("request", "disbandroom");
            jSONObject.putOpt("room", Long.valueOf(this.mRoomId));
            Send(jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void finalize() {
        this.mHandler.removeCallbacks(this.fireKeepAlive);
        this.keepAliveTimer.removeCallbacks(this.serverKeepAliveTimeout);
        this.delegate = null;
        WebSocket webSocket = this.mWebSocket;
        if (webSocket != null) {
            webSocket.close(1001, "going away");
        }
    }

    public BigInteger getFeedByHandle(BigInteger bigInteger) {
        return this.handles.get(bigInteger) == null ? BigInteger.valueOf(0L) : this.handles.get(bigInteger).feedId;
    }

    public JanusHandle getHandleByFeed(BigInteger bigInteger) {
        return this.feeds.get(bigInteger);
    }

    public String getNickNameByFeed(BigInteger bigInteger) {
        if (this.mUserInfoList.get(bigInteger) == null) {
            return null;
        }
        return this.mUserInfoList.get(bigInteger).userName;
    }

    public long getRoomId() {
        return this.mRoomId;
    }

    public void getUserAttribute(final long j) {
        String randomString = randomString(12);
        JanusTransaction janusTransaction = new JanusTransaction();
        janusTransaction.tid = randomString;
        janusTransaction.success = new TransactionCallbackSuccess() { // from class: com.baidu.rtc.WebSocketChannel.28
            @Override // com.baidu.rtc.TransactionCallbackSuccess
            public void success(JSONObject jSONObject) {
                if (jSONObject.has("data")) {
                    String optString = jSONObject.optJSONObject("data").optString("userattribute");
                    if (optString.isEmpty()) {
                        return;
                    }
                    WebSocketChannel.this.delegate.onAttribute(BigInteger.valueOf(j), optString);
                }
            }
        };
        janusTransaction.error = new TransactionCallbackError() { // from class: com.baidu.rtc.WebSocketChannel.29
            @Override // com.baidu.rtc.TransactionCallbackError
            public void error(JSONObject jSONObject) {
            }
        };
        this.transactions.put(randomString, janusTransaction);
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.putOpt("request", "getuserattribute");
            jSONObject.putOpt("room", Long.valueOf(this.mRoomId));
            jSONObject.putOpt("id", Long.valueOf(j));
            jSONObject2.putOpt("janus", "message");
            jSONObject2.putOpt("body", jSONObject);
            jSONObject2.putOpt("transaction", randomString);
            jSONObject2.putOpt(ETAG.KEY_STATISTICS_SEESIONID, this.mSessionId);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        sendMessage(jSONObject2);
    }

    public void initConnection(String str, boolean z) {
        this.mRtcServerUrl = str;
        String str2 = str + "?appid=" + this.mAppId + "&roomname=" + encodeURIComponent(this.mRoomName) + "&uid=" + this.mUserId + "&token=" + this.mTokenStr;
        ErrorInfoReport.getInstance().setUserId(this.mUserId);
        if (z) {
            str2 = str2 + "&compulsive=true";
        }
        if (BaiduRtcRoomImp.mbEnableDebugLog) {
            Log.i(TAG, "connect url: " + str2);
        }
        this.mWebSocket = httpclientBuilder.connectTimeout(this.mConnectionTimeoutMs, TimeUnit.MILLISECONDS).readTimeout(this.mReadTimeoutMs, TimeUnit.MILLISECONDS).dns(new Dns() { // from class: com.baidu.rtc.WebSocketChannel.2
            @Override // okhttp3.Dns
            public List<InetAddress> lookup(final String str3) {
                if (str3.equals("mytestrtc.exp.bcelive.com")) {
                    ArrayList arrayList = new ArrayList();
                    try {
                        arrayList.add(InetAddress.getByName("10.99.206.86"));
                    } catch (Exception unused) {
                    }
                    return arrayList;
                }
                try {
                    FutureTask futureTask = new FutureTask(new Callable<List<InetAddress>>() { // from class: com.baidu.rtc.WebSocketChannel.2.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // java.util.concurrent.Callable
                        public List<InetAddress> call() throws Exception {
                            return Arrays.asList(InetAddress.getAllByName(str3));
                        }
                    });
                    new Thread(futureTask).start();
                    return (List) futureTask.get(WebSocketChannel.this.mConnectionTimeoutMs, TimeUnit.MILLISECONDS);
                } catch (Exception unused2) {
                    return null;
                }
            }
        }).build().newWebSocket(new Request.Builder().url(str2).build(), new WebSocketListener() { // from class: com.baidu.rtc.WebSocketChannel.3
            @Override // okhttp3.WebSocketListener
            public void onClosed(WebSocket webSocket, int i, String str3) {
                if (BaiduRtcRoomImp.mbEnableDebugLog) {
                    Log.i(WebSocketChannel.TAG, "onClosed");
                }
            }

            @Override // okhttp3.WebSocketListener
            public void onClosing(WebSocket webSocket, int i, String str3) {
                if (BaiduRtcRoomImp.mbEnableDebugLog) {
                    Log.i(WebSocketChannel.TAG, "onClosing");
                }
                if (WebSocketChannel.this.delegate != null) {
                    WebSocketChannel.this.delegate.onConnectError();
                }
            }

            @Override // okhttp3.WebSocketListener
            public void onFailure(WebSocket webSocket, Throwable th, Response response) {
                String str3;
                String str4 = "onFailure";
                if (th != null) {
                    str4 = "onFailure" + th.toString();
                }
                Log.e(WebSocketChannel.TAG, str4);
                if (WebSocketChannel.this.delegate == null) {
                    return;
                }
                if (th instanceof SocketTimeoutException) {
                    if (WebSocketChannel.this.delegate != null) {
                        WebSocketChannel.this.delegate.onLoginTimeout();
                        return;
                    }
                    return;
                }
                if (th instanceof NumberFormatException) {
                    str3 = "onFailure: java.lang.NumberFormatException";
                } else if (!(th instanceof NullPointerException)) {
                    if (th instanceof SSLException) {
                        Log.e(WebSocketChannel.TAG, "onFailure: SSLException");
                        if (WebSocketChannel.this.delegate != null) {
                            WebSocketChannel.this.delegate.onConnectError();
                            return;
                        }
                        return;
                    }
                    if (WebSocketChannel.this.mIsEnableErrorInfoMonitor) {
                        ErrorInfoReport.getInstance().reportErrorInfo(ErrorInfoReport.ErrorCode.SIGNAL_CHANNEL_CONNECTION_LOST);
                    }
                    if (WebSocketChannel.this.delegate != null) {
                        WebSocketChannel.this.delegate.onLoginError();
                        return;
                    }
                    return;
                } else {
                    str3 = "onFailure: java.lang.NullPointerException";
                }
                Log.e(WebSocketChannel.TAG, str3);
            }

            @Override // okhttp3.WebSocketListener
            public void onMessage(WebSocket webSocket, String str3) {
                WebSocketChannel.this.onMessage(str3);
            }

            @Override // okhttp3.WebSocketListener
            public void onMessage(WebSocket webSocket, ByteString byteString) {
            }

            @Override // okhttp3.WebSocketListener
            public void onOpen(WebSocket webSocket, Response response) {
                if (BaiduRtcRoomImp.mbEnableDebugLog) {
                    Log.i(WebSocketChannel.TAG, "onOpen");
                }
                WebSocketChannel.this.createSession();
            }
        });
    }

    public void kickOffUserWithId(long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("request", "kickoutuser");
            jSONObject.putOpt("room", Long.valueOf(this.mRoomId));
            jSONObject.putOpt("target", Long.valueOf(j));
            Send(jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void leaveRoom() {
        this.mHandler.post(new Runnable() { // from class: com.baidu.rtc.WebSocketChannel.21
            @Override // java.lang.Runnable
            public void run() {
                int size = WebSocketChannel.this.handles.size();
                for (int i = 0; i < size; i++) {
                    WebSocketChannel webSocketChannel = WebSocketChannel.this;
                    webSocketChannel.doLeaveRoom((JanusHandle) webSocketChannel.handles.values().toArray()[i]);
                    try {
                        Thread.sleep(50L);
                    } catch (Exception unused) {
                    }
                }
            }
        });
    }

    public void publisherCreateOffer(BigInteger bigInteger, SessionDescription sessionDescription) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject.putOpt("request", "configure");
            jSONObject.putOpt("audio", Boolean.valueOf(this.mHasAudio));
            jSONObject.putOpt("video", Boolean.valueOf(this.mHasVideo));
            if (this.mHasData) {
                jSONObject.putOpt("data", Boolean.valueOf(this.mHasData));
            }
            jSONObject2.putOpt("type", sessionDescription.type);
            jSONObject2.putOpt("sdp", sessionDescription.description);
            jSONObject3.putOpt("janus", "message");
            jSONObject3.putOpt("body", jSONObject);
            jSONObject3.putOpt("jsep", jSONObject2);
            jSONObject3.putOpt("transaction", randomString(12));
            jSONObject3.putOpt(ETAG.KEY_STATISTICS_SEESIONID, this.mSessionId);
            jSONObject3.putOpt("handle_id", bigInteger);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        sendMessage(jSONObject3);
    }

    public void sendMessageToUser(String str, long j) {
        sendMessageToUser(str, j, false);
    }

    public void sendMessageToUser(String str, long j, boolean z) {
        String randomString = randomString(12);
        JanusTransaction janusTransaction = new JanusTransaction();
        janusTransaction.tid = randomString;
        janusTransaction.success = new TransactionCallbackSuccess() { // from class: com.baidu.rtc.WebSocketChannel.24
            @Override // com.baidu.rtc.TransactionCallbackSuccess
            public void success(JSONObject jSONObject) {
            }
        };
        janusTransaction.error = new TransactionCallbackError() { // from class: com.baidu.rtc.WebSocketChannel.25
            @Override // com.baidu.rtc.TransactionCallbackError
            public void error(JSONObject jSONObject) {
            }
        };
        this.transactions.put(randomString, janusTransaction);
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.putOpt("request", "senddata");
            jSONObject.putOpt("room", Long.valueOf(this.mRoomId));
            jSONObject.putOpt("id", Long.valueOf(this.mUserId));
            jSONObject.putOpt("to", Long.valueOf(j));
            jSONObject.putOpt("data", str);
            jSONObject.putOpt("internal", Boolean.valueOf(z));
            jSONObject2.putOpt("janus", "message");
            jSONObject2.putOpt("body", jSONObject);
            jSONObject2.putOpt("transaction", randomString);
            jSONObject2.putOpt(ETAG.KEY_STATISTICS_SEESIONID, this.mSessionId);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        sendMessage(jSONObject2);
    }

    public void setAppId(String str) {
        this.mAppId = str;
    }

    public void setAsListener(boolean z) {
        this.mAsListener = z;
    }

    public void setAsPublisher(boolean z) {
        this.mAsPublisher = z;
    }

    public void setAutoPublish(boolean z) {
        this.mAutoPublish = z;
    }

    public void setAutoSubScribe(boolean z) {
        this.mAutoSubScribe = z;
    }

    public void setConnectionTimeoutMs(int i) {
        this.mConnectionTimeoutMs = i;
    }

    public void setDelegate(JanusRTCInterface janusRTCInterface) {
        this.delegate = janusRTCInterface;
    }

    public void setDisplayName(String str) {
        this.mDisplayName = str;
    }

    public void setEnableErrorInfoMonitor(boolean z) {
        this.mIsEnableErrorInfoMonitor = z;
    }

    public void setHasAudio(boolean z) {
        this.mHasAudio = z;
    }

    public void setHasData(boolean z) {
        this.mHasData = z;
    }

    public void setHasVideo(boolean z) {
        this.mHasVideo = z;
    }

    public void setLssConfigSecond(String str, boolean z, boolean z2, String str2, BaiduRtcRoom.RtcLiveTransferMode rtcLiveTransferMode) {
        this.mLiveStreamingServerURLSecond = str;
        this.mLiveStreamingMixSecond = z;
        this.mLiveStreamingRecordingSecond = z2;
        this.mLiveStreamingMixTemplateSecond = str2;
        this.mLiveStreamingTransferModeSecond = rtcLiveTransferMode;
    }

    public void setLssMixTemplate(String str) {
        this.mLiveStreamingMixTemplate = str;
    }

    public void setLssRole(String str) {
        this.mLiveStreamingRole = str;
    }

    public void setLssTransferMode(BaiduRtcRoom.RtcLiveTransferMode rtcLiveTransferMode) {
        this.mLiveStreamingTransferMode = rtcLiveTransferMode;
    }

    public void setLssURL(String str) {
        this.mLiveStreamingServerURL = str;
    }

    public void setMediaServerIP(String str) {
        this.mMediaServerIP = str;
    }

    public void setMixLayoutPosition(String str) {
        this.mMixLayoutPosition = str;
    }

    public void setMixing(boolean z) {
        this.mLiveStreamingMix = z;
    }

    public void setReadTimeoutMs(int i) {
        this.mReadTimeoutMs = i;
    }

    public void setRecording(boolean z) {
        this.mLiveStreamingRecording = z;
    }

    public void setRemoteStreamPlayState(Boolean bool, Boolean bool2, long j) {
        JanusHandle janusHandle = this.feeds.get(BigInteger.valueOf(j));
        if (janusHandle == null) {
            Log.e(TAG, "wrong userID");
            return;
        }
        String randomString = randomString(12);
        JanusTransaction janusTransaction = new JanusTransaction();
        janusTransaction.tid = randomString;
        janusTransaction.success = new TransactionCallbackSuccess() { // from class: com.baidu.rtc.WebSocketChannel.22
            @Override // com.baidu.rtc.TransactionCallbackSuccess
            public void success(JSONObject jSONObject) {
            }
        };
        janusTransaction.error = new TransactionCallbackError() { // from class: com.baidu.rtc.WebSocketChannel.23
            @Override // com.baidu.rtc.TransactionCallbackError
            public void error(JSONObject jSONObject) {
            }
        };
        this.transactions.put(randomString, janusTransaction);
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.putOpt("request", "configure");
            jSONObject.putOpt("audio", bool2);
            jSONObject.putOpt("video", bool);
            jSONObject.putOpt("data", Boolean.TRUE);
            jSONObject2.putOpt("janus", "message");
            jSONObject2.putOpt("body", jSONObject);
            jSONObject2.putOpt("transaction", randomString);
            jSONObject2.putOpt(ETAG.KEY_STATISTICS_SEESIONID, this.mSessionId);
            jSONObject2.putOpt("handle_id", janusHandle.handleId);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        sendMessage(jSONObject2);
    }

    public void setRoomId(int i) {
        this.mRoomId = i;
    }

    public void setRoomName(String str) {
        this.mRoomName = str;
    }

    public void setSDK(String str) {
        this.mSDKTag = str;
    }

    public void setTokenStr(String str) {
        this.mTokenStr = str;
    }

    public void setUserAttribute(final String str) {
        String randomString = randomString(12);
        JanusTransaction janusTransaction = new JanusTransaction();
        janusTransaction.tid = randomString;
        janusTransaction.success = new TransactionCallbackSuccess() { // from class: com.baidu.rtc.WebSocketChannel.26
            @Override // com.baidu.rtc.TransactionCallbackSuccess
            public void success(JSONObject jSONObject) {
                WebSocketChannel.this.sendMessageToUser(str, 0L, true);
            }
        };
        janusTransaction.error = new TransactionCallbackError() { // from class: com.baidu.rtc.WebSocketChannel.27
            @Override // com.baidu.rtc.TransactionCallbackError
            public void error(JSONObject jSONObject) {
            }
        };
        this.transactions.put(randomString, janusTransaction);
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.putOpt("request", "setuserattribute");
            jSONObject.putOpt("room", Long.valueOf(this.mRoomId));
            jSONObject.putOpt("id", Long.valueOf(this.mUserId));
            jSONObject.putOpt("userattribute", str);
            jSONObject2.putOpt("janus", "message");
            jSONObject2.putOpt("body", jSONObject);
            jSONObject2.putOpt("transaction", randomString);
            jSONObject2.putOpt(ETAG.KEY_STATISTICS_SEESIONID, this.mSessionId);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        sendMessage(jSONObject2);
    }

    public void setUserId(long j) {
        this.mUserId = j;
    }

    public void setVideoCodec(String str) {
        this.mVideoCodec = str.toLowerCase();
    }

    public void shutUpUserWithId(long j, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("request", "forwardconfigure");
            jSONObject.putOpt("room", Long.valueOf(this.mRoomId));
            jSONObject.putOpt("target", Long.valueOf(j));
            boolean z2 = !z;
            jSONObject.putOpt("audio", Boolean.valueOf(z2));
            jSONObject.putOpt("video", Boolean.valueOf(z2));
            jSONObject.putOpt("data", Boolean.valueOf(z2));
            Send(jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void startPublishLiveStream(String str, boolean z, boolean z2, String str2, BaiduRtcRoom.RtcLiveTransferMode rtcLiveTransferMode) {
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject.putOpt("request", "startbypass");
            jSONObject.putOpt("level", rtcLiveTransferMode == BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ANCHOR_TRASNSMISSION ? "anchor" : "room");
            jSONObject.putOpt("room", Long.valueOf(this.mRoomId));
            jSONObject.putOpt("id", Long.valueOf(this.mUserId));
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.putOpt("url", str);
            jSONObject3.putOpt("mix", Boolean.valueOf(z));
            jSONObject3.putOpt("mixTemplate", str2);
            jSONObject.putOpt("rtmp", jSONObject3);
            if (z2) {
                jSONObject2.putOpt("rec", Boolean.valueOf(z2));
                jSONObject.putOpt("recording", jSONObject2);
            }
            Send(jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void stopPublishLiveStream(BaiduRtcRoom.RtcLiveTransferMode rtcLiveTransferMode) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("request", "stopbypass");
            jSONObject.putOpt("level", rtcLiveTransferMode == BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ANCHOR_TRASNSMISSION ? "anchor" : "room");
            jSONObject.putOpt("room", Long.valueOf(this.mRoomId));
            jSONObject.putOpt("id", Long.valueOf(this.mUserId));
            Send(jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void subscriberCreateAnswer(BigInteger bigInteger, SessionDescription sessionDescription) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject.putOpt("request", IntentConfig.START);
            jSONObject.putOpt("room", Long.valueOf(this.mRoomId));
            jSONObject2.putOpt("type", sessionDescription.type);
            jSONObject2.putOpt("sdp", sessionDescription.description);
            jSONObject3.putOpt("janus", "message");
            jSONObject3.putOpt("body", jSONObject);
            jSONObject3.putOpt("jsep", jSONObject2);
            jSONObject3.putOpt("transaction", randomString(12));
            jSONObject3.putOpt(ETAG.KEY_STATISTICS_SEESIONID, this.mSessionId);
            jSONObject3.putOpt("handle_id", bigInteger);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        sendMessage(jSONObject3);
    }

    public void subscriberCreateHandle(final BigInteger bigInteger, final String str) {
        String randomString = randomString(12);
        JanusTransaction janusTransaction = new JanusTransaction();
        janusTransaction.tid = randomString;
        janusTransaction.success = new TransactionCallbackSuccess() { // from class: com.baidu.rtc.WebSocketChannel.9
            @Override // com.baidu.rtc.TransactionCallbackSuccess
            public void success(JSONObject jSONObject) {
                JanusHandle janusHandle = new JanusHandle();
                janusHandle.handleId = new BigInteger(jSONObject.optJSONObject("data").optString("id"));
                janusHandle.feedId = bigInteger;
                janusHandle.display = str;
                janusHandle.onRemoteJsep = new OnRemoteJsep() { // from class: com.baidu.rtc.WebSocketChannel.9.1
                    @Override // com.baidu.rtc.OnRemoteJsep
                    public void onRemoteJsep(JanusHandle janusHandle2, JSONObject jSONObject2) {
                        WebSocketChannel.this.delegate.subscriberHandleRemoteJsep(janusHandle2.handleId, jSONObject2);
                    }
                };
                janusHandle.onLeaving = new OnJoined() { // from class: com.baidu.rtc.WebSocketChannel.9.2
                    @Override // com.baidu.rtc.OnJoined
                    public void onJoined(JanusHandle janusHandle2) {
                        WebSocketChannel.this.subscriberOnLeaving(janusHandle2);
                    }
                };
                WebSocketChannel.this.handles.put(janusHandle.handleId, janusHandle);
                WebSocketChannel.this.feeds.put(janusHandle.feedId, janusHandle);
                WebSocketChannel.this.subscriberJoinRoom(janusHandle);
            }
        };
        janusTransaction.error = new TransactionCallbackError() { // from class: com.baidu.rtc.WebSocketChannel.10
            @Override // com.baidu.rtc.TransactionCallbackError
            public void error(JSONObject jSONObject) {
            }
        };
        this.transactions.put(randomString, janusTransaction);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("janus", "attach");
            jSONObject.putOpt("plugin", "janus.plugin.videoroom");
            jSONObject.putOpt("transaction", randomString);
            jSONObject.putOpt(ETAG.KEY_STATISTICS_SEESIONID, this.mSessionId);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        sendMessage(jSONObject);
    }

    public void subscriberOnLeaving(final JanusHandle janusHandle) {
        String randomString = randomString(12);
        JanusTransaction janusTransaction = new JanusTransaction();
        janusTransaction.tid = randomString;
        janusTransaction.success = new TransactionCallbackSuccess() { // from class: com.baidu.rtc.WebSocketChannel.11
            @Override // com.baidu.rtc.TransactionCallbackSuccess
            public void success(JSONObject jSONObject) {
                JanusRTCInterface janusRTCInterface = WebSocketChannel.this.delegate;
                JanusHandle janusHandle2 = janusHandle;
                janusRTCInterface.onLeaving(janusHandle2.handleId, janusHandle2.feedId);
                WebSocketChannel.this.delegate.onRemoteGone(janusHandle.handleId);
                WebSocketChannel.this.handles.remove(janusHandle.handleId);
                WebSocketChannel.this.feeds.remove(janusHandle.feedId);
            }
        };
        janusTransaction.error = new TransactionCallbackError() { // from class: com.baidu.rtc.WebSocketChannel.12
            @Override // com.baidu.rtc.TransactionCallbackError
            public void error(JSONObject jSONObject) {
            }
        };
        this.transactions.put(randomString, janusTransaction);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("janus", "detach");
            jSONObject.putOpt("transaction", randomString);
            jSONObject.putOpt(ETAG.KEY_STATISTICS_SEESIONID, this.mSessionId);
            jSONObject.putOpt("handle_id", janusHandle.handleId);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        sendMessage(jSONObject);
    }

    public void trickleCandidate(BigInteger bigInteger, IceCandidate iceCandidate) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.putOpt("candidate", iceCandidate.sdp);
            jSONObject.putOpt("sdpMid", iceCandidate.sdpMid);
            jSONObject.putOpt("sdpMLineIndex", Integer.valueOf(iceCandidate.sdpMLineIndex));
            jSONObject2.putOpt("janus", "trickle");
            jSONObject2.putOpt("candidate", jSONObject);
            jSONObject2.putOpt("transaction", randomString(12));
            jSONObject2.putOpt(ETAG.KEY_STATISTICS_SEESIONID, this.mSessionId);
            jSONObject2.putOpt("handle_id", bigInteger);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        sendMessage(jSONObject2);
    }

    public void trickleCandidateComplete(BigInteger bigInteger) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.putOpt("completed", Boolean.TRUE);
            jSONObject2.putOpt("janus", "trickle");
            jSONObject2.putOpt("candidate", jSONObject);
            jSONObject2.putOpt("transaction", randomString(12));
            jSONObject2.putOpt(ETAG.KEY_STATISTICS_SEESIONID, this.mSessionId);
            jSONObject2.putOpt("handle_id", bigInteger);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void unpublishHandle(BigInteger bigInteger) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.putOpt("request", "unpublish");
            jSONObject2.putOpt("janus", "message");
            jSONObject2.putOpt("body", jSONObject);
            jSONObject2.putOpt("transaction", randomString(12));
            jSONObject2.putOpt(ETAG.KEY_STATISTICS_SEESIONID, this.mSessionId);
            jSONObject2.putOpt("handle_id", bigInteger);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        sendMessage(jSONObject2);
    }
}
