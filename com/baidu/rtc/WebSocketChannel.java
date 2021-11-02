package com.baidu.rtc;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.imsdk.upload.action.IMTrackDatabase;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.rtc.BaiduRtcRoom;
import com.baidu.rtc.internal.BaiduRtcRoomImp;
import com.baidu.rtc.logreport.ErrorInfoReport;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.searchbox.ui.animview.praise.resource.ComboPraiseProvider;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.newbindcard.NewBindCardEntry;
import com.baidubce.services.vod.VodClient;
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
/* loaded from: classes7.dex */
public class WebSocketChannel {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int NO_SET_VALID_ROOM_ID = -1160725808;
    public static final String TAG = "WebSocketChannel";
    public static OkHttpClient.Builder httpclientBuilder = null;
    public static int kKeepAliveTimeMs = 25000;
    public transient /* synthetic */ FieldHolder $fh;
    public ConcurrentHashMap<String, JanusTransaction> ackTransactions;
    public JanusRTCInterface delegate;
    public ConcurrentHashMap<BigInteger, JanusHandle> feeds;
    public Runnable fireKeepAlive;
    public ConcurrentHashMap<BigInteger, JanusHandle> handles;
    public Handler keepAliveTimer;
    public String mAppId;
    public boolean mAsListener;
    public boolean mAsPublisher;
    public boolean mAutoPublish;
    public boolean mAutoSubScribe;
    public int mConnectionTimeoutMs;
    public String mDisplayName;
    public Handler mHandler;
    public boolean mHasAudio;
    public boolean mHasData;
    public boolean mHasVideo;
    public boolean mIsEnableErrorInfoMonitor;
    public boolean mLiveStreamingMix;
    public boolean mLiveStreamingMixSecond;
    public String mLiveStreamingMixTemplate;
    public String mLiveStreamingMixTemplateSecond;
    public boolean mLiveStreamingRecording;
    public boolean mLiveStreamingRecordingSecond;
    public String mLiveStreamingRole;
    public String mLiveStreamingServerURL;
    public String mLiveStreamingServerURLSecond;
    public BaiduRtcRoom.RtcLiveTransferMode mLiveStreamingTransferMode;
    public BaiduRtcRoom.RtcLiveTransferMode mLiveStreamingTransferModeSecond;
    public String mMediaServerIP;
    public String mMixLayoutPosition;
    public int mReadTimeoutMs;
    public long mRoomId;
    public String mRoomName;
    public String mRtcServerUrl;
    public String mSDKTag;
    public BigInteger mSessionId;
    public String mTokenStr;
    public long mUserId;
    public ConcurrentHashMap<BigInteger, BaiduRtcRoom.RtcRoomUserInfo> mUserInfoList;
    public volatile BaiduRtcRoom.UserList mUserList;
    public String mVideoCodec;
    public WebSocket mWebSocket;
    public int serverAckTimeout;
    public Runnable serverKeepAliveTimeout;
    public ConcurrentHashMap<String, JanusTransaction> transactions;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1212207619, "Lcom/baidu/rtc/WebSocketChannel;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1212207619, "Lcom/baidu/rtc/WebSocketChannel;");
                return;
            }
        }
        httpclientBuilder = new OkHttpClient.Builder().connectionPool(new ConnectionPool(5, 1L, TimeUnit.MINUTES)).addInterceptor(new Interceptor() { // from class: com.baidu.rtc.WebSocketChannel.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // okhttp3.Interceptor
            public Response intercept(Interceptor.Chain chain) throws IOException {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, chain)) == null) {
                    Request.Builder newBuilder = chain.request().newBuilder();
                    newBuilder.addHeader("Sec-WebSocket-Protocol", "janus-protocol");
                    try {
                        return chain.proceed(newBuilder.build());
                    } catch (Exception unused) {
                        throw new IOException("BRTC Connection error");
                    }
                }
                return (Response) invokeL.objValue;
            }
        });
    }

    public WebSocketChannel() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.transactions = new ConcurrentHashMap<>();
        this.handles = new ConcurrentHashMap<>();
        this.feeds = new ConcurrentHashMap<>();
        this.ackTransactions = new ConcurrentHashMap<>();
        this.mUserId = (Build.SERIAL.hashCode() % 100000) + 78657895;
        this.mDisplayName = "Android-rtc";
        this.mRoomName = "";
        this.mVideoCodec = "h264";
        this.mAsPublisher = true;
        this.mAsListener = true;
        this.mHasVideo = true;
        this.mHasAudio = true;
        this.mHasData = false;
        this.mRoomId = -1160725808L;
        this.mAppId = "";
        this.mTokenStr = "";
        this.mLiveStreamingServerURL = "";
        this.mLiveStreamingRole = "";
        this.mLiveStreamingMixTemplate = "";
        this.mMixLayoutPosition = "";
        this.mSDKTag = "";
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
        this.fireKeepAlive = new Runnable(this) { // from class: com.baidu.rtc.WebSocketChannel.32
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ WebSocketChannel this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.this$0.keepAlive();
                    this.this$0.mHandler.postDelayed(this.this$0.fireKeepAlive, WebSocketChannel.kKeepAliveTimeMs);
                }
            }
        };
        this.serverKeepAliveTimeout = new Runnable(this) { // from class: com.baidu.rtc.WebSocketChannel.33
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ WebSocketChannel this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.this$0.delegate == null) {
                    return;
                }
                this.this$0.delegate.onServerAckTimeout();
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper());
        this.keepAliveTimer = new Handler(Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createSession() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65559, this) == null) {
            String randomString = randomString(12);
            JanusTransaction janusTransaction = new JanusTransaction();
            janusTransaction.tid = randomString;
            janusTransaction.success = new TransactionCallbackSuccess(this) { // from class: com.baidu.rtc.WebSocketChannel.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ WebSocketChannel this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // com.baidu.rtc.TransactionCallbackSuccess
                public void success(JSONObject jSONObject) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, jSONObject) == null) {
                        this.this$0.mSessionId = new BigInteger(jSONObject.optJSONObject("data").optString("id"));
                        ErrorInfoReport.getInstance().setSessionId(this.this$0.mSessionId.longValue());
                        this.this$0.mHandler.postDelayed(this.this$0.fireKeepAlive, WebSocketChannel.kKeepAliveTimeMs);
                        this.this$0.publisherCreateHandle();
                    }
                }
            };
            janusTransaction.error = new TransactionCallbackError(this) { // from class: com.baidu.rtc.WebSocketChannel.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ WebSocketChannel this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // com.baidu.rtc.TransactionCallbackError
                public void error(JSONObject jSONObject) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, jSONObject) == null) {
                    }
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doLeaveRoom(JanusHandle janusHandle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65560, this, janusHandle) == null) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject.putOpt("request", "leave");
                jSONObject2.putOpt("janus", "message");
                jSONObject2.putOpt("body", jSONObject);
                jSONObject2.putOpt("transaction", randomString(12));
                jSONObject2.putOpt("session_id", this.mSessionId);
                jSONObject2.putOpt("handle_id", janusHandle.handleId);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            sendMessage(jSONObject2);
        }
    }

    public static String encodeURIComponent(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, null, str)) == null) {
            try {
                return URLEncoder.encode(str, "UTF-8").replaceAll("\\+", "%20").replaceAll("\\%21", "!").replaceAll("\\%27", "'").replaceAll("\\%28", "(").replaceAll("\\%29", SmallTailInfo.EMOTION_SUFFIX).replaceAll("\\%7E", Constants.WAVE_SEPARATOR);
            } catch (UnsupportedEncodingException unused) {
                return str;
            }
        }
        return (String) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void keepAlive() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65562, this) == null) {
            String randomString = randomString(12);
            JanusTransaction janusTransaction = new JanusTransaction();
            janusTransaction.tid = randomString;
            janusTransaction.success = new TransactionCallbackSuccess(this) { // from class: com.baidu.rtc.WebSocketChannel.13
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ WebSocketChannel this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // com.baidu.rtc.TransactionCallbackSuccess
                public void success(JSONObject jSONObject) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, jSONObject) == null) {
                        this.this$0.keepAliveTimer.removeCallbacks(this.this$0.serverKeepAliveTimeout);
                    }
                }
            };
            janusTransaction.error = new TransactionCallbackError(this) { // from class: com.baidu.rtc.WebSocketChannel.14
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ WebSocketChannel this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // com.baidu.rtc.TransactionCallbackError
                public void error(JSONObject jSONObject) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, jSONObject) == null) {
                        this.this$0.keepAliveTimer.removeCallbacks(this.this$0.serverKeepAliveTimeout);
                    }
                }
            };
            this.ackTransactions.put(randomString, janusTransaction);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("janus", "keepalive");
                jSONObject.putOpt("session_id", this.mSessionId);
                jSONObject.putOpt("transaction", randomString);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            this.keepAliveTimer.removeCallbacks(this.serverKeepAliveTimeout);
            this.keepAliveTimer.postDelayed(this.serverKeepAliveTimeout, this.serverAckTimeout);
            sendMessage(jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onMessage(String str) {
        JanusHandle janusHandle;
        BaiduRtcRoom.RtcLiveTransferMode rtcLiveTransferMode;
        long optLong;
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65563, this, str) == null) {
            if (BaiduRtcRoomImp.mbEnableDebugLog) {
                String str2 = "onMessage" + str;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("janus");
                if (optString.equals("success")) {
                    String optString2 = jSONObject.optString("transaction");
                    JanusTransaction janusTransaction = this.transactions.get(optString2);
                    if (janusTransaction != null && janusTransaction.success != null) {
                        janusTransaction.success.success(jSONObject);
                    }
                    this.transactions.remove(optString2);
                } else if (optString.equals("error")) {
                    String optString3 = jSONObject.optString("transaction");
                    JanusTransaction janusTransaction2 = this.transactions.get(optString3);
                    if (janusTransaction2 != null && janusTransaction2.error != null) {
                        janusTransaction2.error.error(jSONObject);
                    }
                    this.transactions.remove(optString3);
                    if (jSONObject.has("error")) {
                        String optString4 = jSONObject.optJSONObject("error").optString("reason");
                        if (optString4.contains("Room is disbanded")) {
                            if (this.delegate != null) {
                                this.delegate.onRoomDisbanded();
                            }
                        } else if (optString4.contains("User is kick out") && this.delegate != null) {
                            this.delegate.onUserKickOff(this.mUserId);
                        }
                    }
                } else if (optString.equals(IMTrackDatabase.AckEnum.TABLE_NAME)) {
                    String optString5 = jSONObject.optString("transaction");
                    JanusTransaction janusTransaction3 = this.ackTransactions.get(optString5);
                    if (janusTransaction3 != null && janusTransaction3.success != null) {
                        janusTransaction3.success.success(jSONObject);
                    }
                    this.ackTransactions.remove(optString5);
                } else if (optString.equals("timeout")) {
                    this.mHandler.removeCallbacks(this.fireKeepAlive);
                    this.keepAliveTimer.removeCallbacks(this.serverKeepAliveTimeout);
                    if (this.mIsEnableErrorInfoMonitor) {
                        ErrorInfoReport.getInstance().reportErrorInfo(ErrorInfoReport.ErrorCode.KEEPALIVE_TIMEOUT);
                    }
                    if (this.delegate != null) {
                        this.delegate.onConnectError();
                    }
                } else if (optString.equals("slowlink")) {
                    this.delegate.onSlowLink(jSONObject.optBoolean("uplink"), jSONObject.optInt("nacks"));
                } else if (optString.equals("sessionevent")) {
                    if (jSONObject.has("recvdata")) {
                        JSONObject optJSONObject = jSONObject.optJSONObject("recvdata");
                        if (optJSONObject.optBoolean("internal")) {
                            BaiduRtcRoom.RtcRoomUserInfo rtcRoomUserInfo = this.mUserInfoList.get(BigInteger.valueOf(optJSONObject.optLong("from")));
                            if (rtcRoomUserInfo != null) {
                                rtcRoomUserInfo.attribute = optJSONObject.optString("data");
                            }
                            this.delegate.onAttribute(new BigInteger(optJSONObject.optString("from")), optJSONObject.optString("data"));
                            return;
                        }
                        this.delegate.onMessage(new BigInteger(optJSONObject.optString("from")), optJSONObject.optString("data"));
                        return;
                    }
                    String str3 = "";
                    if (jSONObject.has("userevent")) {
                        JSONObject optJSONObject2 = jSONObject.optJSONObject("userevent");
                        if (optJSONObject2.has("joined")) {
                            BaiduRtcRoom.RtcRoomUserInfo rtcRoomUserInfo2 = new BaiduRtcRoom.RtcRoomUserInfo();
                            rtcRoomUserInfo2.userId = optJSONObject2.optLong("joined");
                            rtcRoomUserInfo2.userName = optJSONObject2.optString("display");
                            rtcRoomUserInfo2.attribute = optJSONObject2.optString("attribute");
                            this.mUserInfoList.put(BigInteger.valueOf(rtcRoomUserInfo2.userId), rtcRoomUserInfo2);
                            this.delegate.onUserJoinedRoom(new BigInteger(optJSONObject2.optString("joined")), optJSONObject2.optString("display"), "");
                        } else if (optJSONObject2.has("leaving")) {
                            this.mUserInfoList.remove(BigInteger.valueOf(optJSONObject2.optLong("leaving")));
                            this.delegate.onUserLeavingRoom(new BigInteger(optJSONObject2.optString("leaving")));
                        } else if (optJSONObject2.has(IMConstants.AT_DATA_TYPE_USER) && (optJSONArray = optJSONObject2.optJSONArray(IMConstants.AT_DATA_TYPE_USER)) != null && optJSONArray.length() > 0) {
                            int length = optJSONArray.length();
                            for (int i2 = 0; i2 <= length - 1; i2++) {
                                JSONObject optJSONObject3 = optJSONArray.optJSONObject(i2);
                                BigInteger bigInteger = new BigInteger(optJSONObject3.optString("id"));
                                String optString6 = optJSONObject3.optString("display");
                                BaiduRtcRoom.RtcRoomUserInfo rtcRoomUserInfo3 = new BaiduRtcRoom.RtcRoomUserInfo();
                                rtcRoomUserInfo3.userId = optJSONObject3.optLong("id");
                                rtcRoomUserInfo3.userName = optJSONObject3.optString("display");
                                rtcRoomUserInfo3.attribute = optJSONObject3.optString("attribute");
                                this.mUserInfoList.put(bigInteger, rtcRoomUserInfo3);
                                this.delegate.onUserJoinedRoom(bigInteger, optString6, "");
                                String optString7 = optJSONObject3.optString("attribute");
                                if (!optString7.isEmpty()) {
                                    this.delegate.onAttribute(bigInteger, optString7);
                                }
                            }
                        }
                    } else if (!jSONObject.has("detached")) {
                        if (jSONObject.has("forwardconfigure")) {
                            JSONObject optJSONObject4 = jSONObject.optJSONObject("forwardconfigure");
                            if (Boolean.valueOf(optJSONObject4.optBoolean("self")).booleanValue()) {
                                optLong = this.mUserId;
                            } else {
                                optLong = optJSONObject4.optLong("id");
                            }
                            Boolean valueOf = Boolean.valueOf(optJSONObject4.optBoolean("video"));
                            Boolean valueOf2 = Boolean.valueOf(optJSONObject4.optBoolean(MediaStreamTrack.AUDIO_TRACK_KIND));
                            if (valueOf.booleanValue() && valueOf2.booleanValue()) {
                                this.delegate.onUserDisShutUp(optLong);
                            } else if (!valueOf.booleanValue() && !valueOf2.booleanValue()) {
                                this.delegate.onUserShutUp(optLong);
                            }
                        } else if (jSONObject.has("userkickout")) {
                            this.delegate.onUserKickOff(jSONObject.optJSONObject("userkickout").optLong("id"));
                        } else if (jSONObject.has("bypass_event")) {
                            JSONObject optJSONObject5 = jSONObject.optJSONObject("bypass_event");
                            if (optJSONObject5.optString(ComboPraiseProvider.RES_KEY_PREFIX_PRAISE_LEVEL).contains("room")) {
                                rtcLiveTransferMode = BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ROOM_TRANSMISSION;
                            } else {
                                rtcLiveTransferMode = BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ANCHOR_TRASNSMISSION;
                            }
                            if (optJSONObject5.has("rtmp")) {
                                JSONObject optJSONObject6 = optJSONObject5.optJSONObject("rtmp");
                                if (optJSONObject6.has("url")) {
                                    str3 = optJSONObject6.optString("url");
                                }
                            }
                            String optString8 = optJSONObject5.optString("bypassStatus");
                            if (optString8.contains("success")) {
                                this.delegate.onLivePublishSucceed(rtcLiveTransferMode, str3);
                            } else if (optString8.contains(SmsLoginView.f.l)) {
                                this.delegate.onLivePublishFailed(rtcLiveTransferMode, str3);
                            } else if (optString8.contains("break")) {
                                this.delegate.onLivePublishInterrupted(rtcLiveTransferMode, str3);
                            }
                        }
                    }
                } else if (jSONObject.has("sender") && (janusHandle = this.handles.get(new BigInteger(jSONObject.optString("sender")))) != null) {
                    if (optString.equals("event")) {
                        JSONObject optJSONObject7 = jSONObject.optJSONObject("plugindata").optJSONObject("data");
                        if (optJSONObject7.optString("videoroom").equals("joined")) {
                            janusHandle.onJoined.onJoined(janusHandle);
                        } else if (optJSONObject7.optString("videoroom").equals("event")) {
                            if (optJSONObject7.has("error_code")) {
                                this.delegate.onSignalErrorInfo(optJSONObject7.optInt("error_code"));
                            }
                            if (optJSONObject7.optInt("error_code") == 436) {
                                this.mHandler.postDelayed(new Runnable(this, janusHandle) { // from class: com.baidu.rtc.WebSocketChannel.4
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ WebSocketChannel this$0;
                                    public final /* synthetic */ JanusHandle val$handle;

                                    {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {this, janusHandle};
                                            interceptable2.invokeUnInit(65536, newInitContext);
                                            int i3 = newInitContext.flag;
                                            if ((i3 & 1) != 0) {
                                                int i4 = i3 & 2;
                                                newInitContext.thisArg = this;
                                                interceptable2.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.this$0 = this;
                                        this.val$handle = janusHandle;
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                            this.this$0.publisherJoinRoom(this.val$handle);
                                        }
                                    }
                                }, 2000L);
                            }
                        }
                        JSONArray optJSONArray2 = optJSONObject7.optJSONArray("publishers");
                        if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                            int length2 = optJSONArray2.length();
                            for (int i3 = 0; i3 <= length2 - 1; i3++) {
                                JSONObject optJSONObject8 = optJSONArray2.optJSONObject(i3);
                                BigInteger bigInteger2 = new BigInteger(optJSONObject8.optString("id"));
                                String optString9 = optJSONObject8.optString("display");
                                this.delegate.onComing(bigInteger2, optString9);
                                if (this.mAsListener && this.mAutoSubScribe) {
                                    subscriberCreateHandle(bigInteger2, optString9);
                                }
                            }
                        }
                        String optString10 = optJSONObject7.optString("leaving");
                        if (!TextUtils.isEmpty(optString10) && !optString10.equals(NewBindCardEntry.BING_CARD_SUCCESS_MSG)) {
                            this.delegate.onLeaving(janusHandle.handleId, new BigInteger(optString10));
                            JanusHandle janusHandle2 = this.feeds.get(new BigInteger(optString10));
                            if (janusHandle2 != null && janusHandle2.onLeaving != null) {
                                janusHandle2.onLeaving.onJoined(janusHandle2);
                            }
                        }
                        String optString11 = optJSONObject7.optString("unpublished");
                        if (!TextUtils.isEmpty(optString11)) {
                            if (!optString11.equals(NewBindCardEntry.BING_CARD_SUCCESS_MSG) && !optString11.equals("self")) {
                                this.delegate.onLeaving(janusHandle.handleId, new BigInteger(optString11));
                                JanusHandle janusHandle3 = this.feeds.get(new BigInteger(optString11));
                                if (janusHandle3 != null && janusHandle3.onLeaving != null) {
                                    janusHandle3.onLeaving.onJoined(janusHandle3);
                                }
                            } else if (optString11.equals("self") && optJSONObject7.has("servertrigger")) {
                                this.delegate.onHangUp(janusHandle.handleId);
                            }
                        }
                        JSONObject optJSONObject9 = jSONObject.optJSONObject("jsep");
                        if (optJSONObject9 != null) {
                            janusHandle.onRemoteJsep.onRemoteJsep(janusHandle, optJSONObject9);
                        }
                    } else if (optString.equals("detached")) {
                        janusHandle.onLeaving.onJoined(janusHandle);
                    } else if (optString.equals("webrtcup")) {
                        this.delegate.onWebrtcUp(janusHandle.handleId);
                    } else if (optString.equals(VodClient.PATH_MEDIA)) {
                        boolean z = jSONObject.getBoolean("receiving");
                        String string = jSONObject.getString("type");
                        if (this.delegate != null) {
                            this.delegate.onMediaStreamingEvent(janusHandle.handleId, string.contains("video") ? 1 : 0, z);
                        }
                    } else if (optString.equals("hangup") && this.delegate != null) {
                        this.delegate.onHangUp(janusHandle.handleId);
                    }
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void publisherCreateHandle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65564, this) == null) {
            String randomString = randomString(12);
            JanusTransaction janusTransaction = new JanusTransaction();
            janusTransaction.tid = randomString;
            janusTransaction.success = new TransactionCallbackSuccess(this) { // from class: com.baidu.rtc.WebSocketChannel.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ WebSocketChannel this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // com.baidu.rtc.TransactionCallbackSuccess
                public void success(JSONObject jSONObject) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, jSONObject) == null) {
                        JanusHandle janusHandle = new JanusHandle();
                        janusHandle.handleId = new BigInteger(jSONObject.optJSONObject("data").optString("id"));
                        janusHandle.onJoined = new OnJoined(this) { // from class: com.baidu.rtc.WebSocketChannel.7.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass7 this$1;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$1 = this;
                            }

                            @Override // com.baidu.rtc.OnJoined
                            public void onJoined(JanusHandle janusHandle2) {
                                Interceptable interceptable3 = $ic;
                                if (!(interceptable3 == null || interceptable3.invokeL(1048576, this, janusHandle2) == null) || this.this$1.this$0.delegate == null) {
                                    return;
                                }
                                this.this$1.this$0.delegate.onPublisherJoined(janusHandle2.handleId);
                            }
                        };
                        janusHandle.onRemoteJsep = new OnRemoteJsep(this) { // from class: com.baidu.rtc.WebSocketChannel.7.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass7 this$1;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$1 = this;
                            }

                            @Override // com.baidu.rtc.OnRemoteJsep
                            public void onRemoteJsep(JanusHandle janusHandle2, JSONObject jSONObject2) {
                                Interceptable interceptable3 = $ic;
                                if (!(interceptable3 == null || interceptable3.invokeLL(1048576, this, janusHandle2, jSONObject2) == null) || this.this$1.this$0.delegate == null) {
                                    return;
                                }
                                this.this$1.this$0.delegate.onPublisherRemoteJsep(janusHandle2.handleId, jSONObject2);
                            }
                        };
                        this.this$0.handles.put(janusHandle.handleId, janusHandle);
                        if (this.this$0.delegate == null) {
                            return;
                        }
                        this.this$0.delegate.onCreatedHandle(janusHandle.handleId, this.this$0.mRoomId);
                        if (this.this$0.mRoomId != -1160725808) {
                            ErrorInfoReport.getInstance().setRoomId(this.this$0.mRoomId);
                            WebSocketChannel webSocketChannel = this.this$0;
                            webSocketChannel.createRoom(webSocketChannel.mRoomId, this.this$0.mRoomName, janusHandle);
                            return;
                        }
                        this.this$0.createRoomWithoutRoomID(janusHandle);
                    }
                }
            };
            janusTransaction.error = new TransactionCallbackError(this) { // from class: com.baidu.rtc.WebSocketChannel.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ WebSocketChannel this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // com.baidu.rtc.TransactionCallbackError
                public void error(JSONObject jSONObject) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, jSONObject) == null) {
                    }
                }
            };
            this.transactions.put(randomString, janusTransaction);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("janus", "attach");
                jSONObject.putOpt("plugin", "janus.plugin.videoroom");
                jSONObject.putOpt("transaction", randomString);
                jSONObject.putOpt("session_id", this.mSessionId);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            sendMessage(jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void publisherJoinRoom(JanusHandle janusHandle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65565, this, janusHandle) == null) {
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
                jSONObject2.putOpt("app_id", this.mAppId);
                jSONObject2.putOpt(DpStatConstants.KEY_ROOM_NAME, this.mRoomName);
                jSONObject2.putOpt("role", "publisher");
                jSONObject2.putOpt("token", "no_token");
                if (!this.mMixLayoutPosition.isEmpty()) {
                    jSONObject2.putOpt("window_id_in_bypass", this.mMixLayoutPosition);
                }
                if (!this.mLiveStreamingServerURL.isEmpty() && this.mLiveStreamingTransferMode == BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ANCHOR_TRASNSMISSION) {
                    jSONObject3.putOpt("url", this.mLiveStreamingServerURL);
                    if (!this.mLiveStreamingMixTemplate.isEmpty()) {
                        jSONObject3.putOpt("mixTemplate", this.mLiveStreamingMixTemplate);
                    }
                    jSONObject3.putOpt("mix", Boolean.valueOf(this.mLiveStreamingMix));
                    jSONObject2.putOpt("rtmp", jSONObject3);
                } else if (!this.mLiveStreamingServerURLSecond.isEmpty() && this.mLiveStreamingTransferModeSecond == BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ANCHOR_TRASNSMISSION) {
                    jSONObject3.putOpt("url", this.mLiveStreamingServerURLSecond);
                    if (!this.mLiveStreamingMixTemplateSecond.isEmpty()) {
                        jSONObject3.putOpt("mixTemplate", this.mLiveStreamingMixTemplateSecond);
                    }
                    jSONObject3.putOpt("mix", Boolean.valueOf(this.mLiveStreamingMixSecond));
                    jSONObject2.putOpt("rtmp", jSONObject3);
                }
                if (this.mLiveStreamingRecording) {
                    jSONObject4.putOpt("rec", Boolean.valueOf(this.mLiveStreamingRecording));
                    jSONObject2.putOpt("recording", jSONObject4);
                }
                jSONObject.putOpt("janus", "message");
                jSONObject.putOpt("body", jSONObject2);
                jSONObject.putOpt("transaction", randomString(12));
                jSONObject.putOpt("session_id", this.mSessionId);
                jSONObject.putOpt("handle_id", janusHandle.handleId);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            sendMessage(jSONObject);
        }
    }

    private String randomString(Integer num) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65566, this, num)) == null) {
            Random random = new Random();
            StringBuilder sb = new StringBuilder(num.intValue());
            for (int i2 = 0; i2 < num.intValue(); i2++) {
                sb.append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt(random.nextInt(62)));
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    private void sendMessage(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65567, this, jSONObject) == null) {
            WebSocket webSocket = this.mWebSocket;
            if (webSocket != null) {
                webSocket.send(jSONObject.toString());
            }
            if (BaiduRtcRoomImp.mbEnableDebugLog) {
                jSONObject.toString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void subscriberJoinRoom(JanusHandle janusHandle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65568, this, janusHandle) == null) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.putOpt("request", "join");
                jSONObject2.putOpt("room", Long.valueOf(this.mRoomId));
                jSONObject2.putOpt("ptype", "listener");
                jSONObject2.putOpt("feed", janusHandle.feedId);
                jSONObject2.putOpt("id", Long.valueOf(this.mUserId));
                jSONObject2.putOpt("app_id", this.mAppId);
                jSONObject2.putOpt(DpStatConstants.KEY_ROOM_NAME, this.mRoomName);
                jSONObject2.putOpt("token", this.mTokenStr);
                jSONObject2.putOpt("role", "listener");
                if (!this.mMixLayoutPosition.isEmpty()) {
                    jSONObject2.putOpt("window_id_in_bypass", this.mMixLayoutPosition);
                }
                jSONObject.putOpt("janus", "message");
                jSONObject.putOpt("body", jSONObject2);
                jSONObject.putOpt("transaction", randomString(12));
                jSONObject.putOpt("session_id", this.mSessionId);
                jSONObject.putOpt("handle_id", janusHandle.handleId);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            sendMessage(jSONObject);
        }
    }

    public void Send(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
            String randomString = randomString(12);
            JanusTransaction janusTransaction = new JanusTransaction();
            janusTransaction.tid = randomString;
            janusTransaction.success = new TransactionCallbackSuccess(this) { // from class: com.baidu.rtc.WebSocketChannel.30
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ WebSocketChannel this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // com.baidu.rtc.TransactionCallbackSuccess
                public void success(JSONObject jSONObject2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, jSONObject2) == null) {
                    }
                }
            };
            janusTransaction.error = new TransactionCallbackError(this) { // from class: com.baidu.rtc.WebSocketChannel.31
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ WebSocketChannel this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // com.baidu.rtc.TransactionCallbackError
                public void error(JSONObject jSONObject2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, jSONObject2) == null) {
                    }
                }
            };
            this.transactions.put(randomString, janusTransaction);
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.putOpt("janus", "message");
                jSONObject2.putOpt("body", jSONObject);
                jSONObject2.putOpt("transaction", randomString);
                jSONObject2.putOpt("session_id", this.mSessionId);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            sendMessage(jSONObject2);
        }
    }

    public BaiduRtcRoom.RtcRoomUserInfo[] UserInfoList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.mUserInfoList.size() < 1) {
                return null;
            }
            BaiduRtcRoom.RtcRoomUserInfo[] rtcRoomUserInfoArr = new BaiduRtcRoom.RtcRoomUserInfo[this.mUserInfoList.size()];
            int i2 = 0;
            for (BaiduRtcRoom.RtcRoomUserInfo rtcRoomUserInfo : this.mUserInfoList.values()) {
                rtcRoomUserInfoArr[i2] = new BaiduRtcRoom.RtcRoomUserInfo();
                rtcRoomUserInfoArr[i2].userId = rtcRoomUserInfo.userId;
                rtcRoomUserInfoArr[i2].userName = rtcRoomUserInfo.userName;
                rtcRoomUserInfoArr[i2].attribute = rtcRoomUserInfo.attribute;
                i2++;
            }
            return rtcRoomUserInfoArr;
        }
        return (BaiduRtcRoom.RtcRoomUserInfo[]) invokeV.objValue;
    }

    public BaiduRtcRoom.UserList UserListOfRoom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this)) == null) {
            String randomString = randomString(12);
            JanusTransaction janusTransaction = new JanusTransaction();
            janusTransaction.tid = randomString;
            janusTransaction.success = new TransactionCallbackSuccess(this) { // from class: com.baidu.rtc.WebSocketChannel.19
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ WebSocketChannel this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // com.baidu.rtc.TransactionCallbackSuccess
                public void success(JSONObject jSONObject) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, jSONObject) == null) {
                        JSONArray optJSONArray = jSONObject.optJSONObject("plugindata").optJSONObject("data").optJSONArray("publishers");
                        JSONArray optJSONArray2 = jSONObject.optJSONObject("plugindata").optJSONObject("data").optJSONArray("listeners");
                        if (optJSONArray != null) {
                            BaiduRtcRoom.UserList userList = new BaiduRtcRoom.UserList(optJSONArray.length(), optJSONArray2.length());
                            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                                userList.Publishers[i2] = optJSONArray.optJSONObject(i2).optInt("clientUserId");
                            }
                            for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                                userList.Listeners[i3] = optJSONArray2.optJSONObject(i3).optInt("clientUserId");
                            }
                            this.this$0.mUserList = userList;
                        }
                        synchronized (this.this$0) {
                            try {
                                this.this$0.notifyAll();
                            } catch (Exception unused) {
                            }
                        }
                    }
                }
            };
            janusTransaction.error = new TransactionCallbackError(this) { // from class: com.baidu.rtc.WebSocketChannel.20
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ WebSocketChannel this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // com.baidu.rtc.TransactionCallbackError
                public void error(JSONObject jSONObject) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, jSONObject) == null) {
                    }
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
                jSONObject2.putOpt("session_id", this.mSessionId);
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
        return (BaiduRtcRoom.UserList) invokeV.objValue;
    }

    public void createRoom(long j, String str, JanusHandle janusHandle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j), str, janusHandle}) == null) {
            String randomString = randomString(12);
            JanusTransaction janusTransaction = new JanusTransaction();
            janusTransaction.tid = randomString;
            janusTransaction.success = new TransactionCallbackSuccess(this, janusHandle) { // from class: com.baidu.rtc.WebSocketChannel.15
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ WebSocketChannel this$0;
                public final /* synthetic */ JanusHandle val$handle;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, janusHandle};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$handle = janusHandle;
                }

                @Override // com.baidu.rtc.TransactionCallbackSuccess
                public void success(JSONObject jSONObject) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, jSONObject) == null) {
                        this.this$0.publisherJoinRoom(this.val$handle);
                    }
                }
            };
            janusTransaction.error = new TransactionCallbackError(this, janusHandle) { // from class: com.baidu.rtc.WebSocketChannel.16
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ WebSocketChannel this$0;
                public final /* synthetic */ JanusHandle val$handle;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, janusHandle};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$handle = janusHandle;
                }

                @Override // com.baidu.rtc.TransactionCallbackError
                public void error(JSONObject jSONObject) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, jSONObject) == null) {
                        this.this$0.publisherJoinRoom(this.val$handle);
                    }
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
                if (!this.mLiveStreamingServerURL.isEmpty() && this.mLiveStreamingTransferMode == BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ROOM_TRANSMISSION) {
                    jSONObject3.putOpt("url", this.mLiveStreamingServerURL);
                    if (!this.mLiveStreamingMixTemplate.isEmpty()) {
                        jSONObject3.putOpt("mixTemplate", this.mLiveStreamingMixTemplate);
                    }
                    jSONObject.putOpt("rtmp", jSONObject3);
                } else if (!this.mLiveStreamingServerURLSecond.isEmpty() && this.mLiveStreamingTransferModeSecond == BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ROOM_TRANSMISSION) {
                    jSONObject3.putOpt("url", this.mLiveStreamingServerURLSecond);
                    if (!this.mLiveStreamingMixTemplateSecond.isEmpty()) {
                        jSONObject3.putOpt("mixTemplate", this.mLiveStreamingMixTemplateSecond);
                    }
                    jSONObject.putOpt("rtmp", jSONObject3);
                }
                if (this.mLiveStreamingRecording) {
                    jSONObject4.putOpt("rec", Boolean.valueOf(this.mLiveStreamingRecording));
                    jSONObject.putOpt("recording", jSONObject4);
                }
                jSONObject2.putOpt("janus", "message");
                jSONObject2.putOpt("body", jSONObject);
                jSONObject2.putOpt("transaction", randomString);
                jSONObject2.putOpt("session_id", this.mSessionId);
                jSONObject2.putOpt("handle_id", janusHandle.handleId);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            sendMessage(jSONObject2);
        }
    }

    public void createRoomWithoutRoomID(JanusHandle janusHandle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, janusHandle) == null) {
            String randomString = randomString(12);
            JanusTransaction janusTransaction = new JanusTransaction();
            janusTransaction.tid = randomString;
            janusTransaction.success = new TransactionCallbackSuccess(this, janusHandle) { // from class: com.baidu.rtc.WebSocketChannel.17
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ WebSocketChannel this$0;
                public final /* synthetic */ JanusHandle val$handle;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, janusHandle};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$handle = janusHandle;
                }

                @Override // com.baidu.rtc.TransactionCallbackSuccess
                public void success(JSONObject jSONObject) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, jSONObject) == null) {
                        this.this$0.mRoomId = jSONObject.optJSONObject("plugindata").optJSONObject("data").optLong("room");
                        String str = "Got RoomID:" + this.this$0.mRoomId;
                        ErrorInfoReport.getInstance().setRoomId(this.this$0.mRoomId);
                        this.this$0.publisherJoinRoom(this.val$handle);
                    }
                }
            };
            janusTransaction.error = new TransactionCallbackError(this, janusHandle) { // from class: com.baidu.rtc.WebSocketChannel.18
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ WebSocketChannel this$0;
                public final /* synthetic */ JanusHandle val$handle;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, janusHandle};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$handle = janusHandle;
                }

                @Override // com.baidu.rtc.TransactionCallbackError
                public void error(JSONObject jSONObject) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, jSONObject) == null) {
                        this.this$0.publisherJoinRoom(this.val$handle);
                    }
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
                jSONObject.putOpt("app_id", this.mAppId);
                jSONObject.putOpt(DpStatConstants.KEY_ROOM_NAME, this.mRoomName);
                jSONObject.putOpt("description", this.mRoomName);
                jSONObject.putOpt("publishers", 1000);
                jSONObject.putOpt("is_private", Boolean.FALSE);
                jSONObject.putOpt("videocodec", this.mVideoCodec);
                jSONObject.putOpt("playoutdelay_ext", Boolean.TRUE);
                if (!this.mLiveStreamingServerURL.isEmpty() && this.mLiveStreamingTransferMode == BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ROOM_TRANSMISSION) {
                    jSONObject3.putOpt("url", this.mLiveStreamingServerURL);
                    jSONObject3.putOpt("mixTemplate", this.mLiveStreamingMixTemplate);
                    jSONObject.putOpt("rtmp", jSONObject3);
                } else if (!this.mLiveStreamingServerURLSecond.isEmpty() && this.mLiveStreamingTransferModeSecond == BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ROOM_TRANSMISSION) {
                    jSONObject3.putOpt("url", this.mLiveStreamingServerURLSecond);
                    if (!this.mLiveStreamingMixTemplateSecond.isEmpty()) {
                        jSONObject3.putOpt("mixTemplate", this.mLiveStreamingMixTemplateSecond);
                    }
                    jSONObject.putOpt("rtmp", jSONObject3);
                }
                if (this.mLiveStreamingRecording) {
                    jSONObject4.putOpt("rec", Boolean.valueOf(this.mLiveStreamingRecording));
                    jSONObject.putOpt("recording", jSONObject4);
                }
                jSONObject2.putOpt("janus", "message");
                jSONObject2.putOpt("body", jSONObject);
                jSONObject2.putOpt("transaction", randomString);
                jSONObject2.putOpt("session_id", this.mSessionId);
                jSONObject2.putOpt("handle_id", janusHandle.handleId);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            sendMessage(jSONObject2);
        }
    }

    public void disbandRoom() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("request", "disbandroom");
                jSONObject.putOpt("room", Long.valueOf(this.mRoomId));
                Send(jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void finalize() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.mHandler.removeCallbacks(this.fireKeepAlive);
            this.keepAliveTimer.removeCallbacks(this.serverKeepAliveTimeout);
            this.delegate = null;
            WebSocket webSocket = this.mWebSocket;
            if (webSocket != null) {
                webSocket.close(1001, "going away");
            }
        }
    }

    public BigInteger getFeedByHandle(BigInteger bigInteger) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, bigInteger)) == null) ? this.handles.get(bigInteger) == null ? BigInteger.valueOf(0L) : this.handles.get(bigInteger).feedId : (BigInteger) invokeL.objValue;
    }

    public JanusHandle getHandleByFeed(BigInteger bigInteger) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bigInteger)) == null) ? this.feeds.get(bigInteger) : (JanusHandle) invokeL.objValue;
    }

    public String getNickNameByFeed(BigInteger bigInteger) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, bigInteger)) == null) {
            if (this.mUserInfoList.get(bigInteger) == null) {
                return null;
            }
            return this.mUserInfoList.get(bigInteger).userName;
        }
        return (String) invokeL.objValue;
    }

    public long getRoomId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mRoomId : invokeV.longValue;
    }

    public void getUserAttribute(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048587, this, j) == null) {
            String randomString = randomString(12);
            JanusTransaction janusTransaction = new JanusTransaction();
            janusTransaction.tid = randomString;
            janusTransaction.success = new TransactionCallbackSuccess(this, j) { // from class: com.baidu.rtc.WebSocketChannel.28
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ WebSocketChannel this$0;
                public final /* synthetic */ long val$feedid;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Long.valueOf(j)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$feedid = j;
                }

                @Override // com.baidu.rtc.TransactionCallbackSuccess
                public void success(JSONObject jSONObject) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeL(1048576, this, jSONObject) == null) && jSONObject.has("data")) {
                        String optString = jSONObject.optJSONObject("data").optString("userattribute");
                        if (optString.isEmpty()) {
                            return;
                        }
                        this.this$0.delegate.onAttribute(BigInteger.valueOf(this.val$feedid), optString);
                    }
                }
            };
            janusTransaction.error = new TransactionCallbackError(this) { // from class: com.baidu.rtc.WebSocketChannel.29
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ WebSocketChannel this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // com.baidu.rtc.TransactionCallbackError
                public void error(JSONObject jSONObject) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, jSONObject) == null) {
                    }
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
                jSONObject2.putOpt("session_id", this.mSessionId);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            sendMessage(jSONObject2);
        }
    }

    public void initConnection(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048588, this, str, z) == null) {
            this.mRtcServerUrl = str;
            String str2 = str + "?appid=" + this.mAppId + "&roomname=" + encodeURIComponent(this.mRoomName) + "&uid=" + this.mUserId + "&token=" + this.mTokenStr;
            ErrorInfoReport.getInstance().setUserId(this.mUserId);
            if (z) {
                str2 = str2 + "&compulsive=true";
            }
            if (BaiduRtcRoomImp.mbEnableDebugLog) {
                String str3 = "connect url: " + str2;
            }
            this.mWebSocket = httpclientBuilder.connectTimeout(this.mConnectionTimeoutMs, TimeUnit.MILLISECONDS).readTimeout(this.mReadTimeoutMs, TimeUnit.MILLISECONDS).dns(new Dns(this) { // from class: com.baidu.rtc.WebSocketChannel.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ WebSocketChannel this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // okhttp3.Dns
                public List<InetAddress> lookup(String str4) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, str4)) == null) {
                        if (str4.equals("mytestrtc.exp.bcelive.com")) {
                            ArrayList arrayList = new ArrayList();
                            try {
                                arrayList.add(InetAddress.getByName("10.99.206.86"));
                            } catch (Exception unused) {
                            }
                            return arrayList;
                        }
                        try {
                            FutureTask futureTask = new FutureTask(new Callable<List<InetAddress>>(this, str4) { // from class: com.baidu.rtc.WebSocketChannel.2.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass2 this$1;
                                public final /* synthetic */ String val$hostname;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, str4};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.this$1 = this;
                                    this.val$hostname = str4;
                                }

                                /* JADX DEBUG: Method merged with bridge method */
                                @Override // java.util.concurrent.Callable
                                public List<InetAddress> call() throws Exception {
                                    InterceptResult invokeV;
                                    Interceptable interceptable3 = $ic;
                                    return (interceptable3 == null || (invokeV = interceptable3.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? Arrays.asList(InetAddress.getAllByName(this.val$hostname)) : (List) invokeV.objValue;
                                }
                            });
                            new Thread(futureTask).start();
                            return (List) futureTask.get(this.this$0.mConnectionTimeoutMs, TimeUnit.MILLISECONDS);
                        } catch (Exception unused2) {
                            return null;
                        }
                    }
                    return (List) invokeL.objValue;
                }
            }).build().newWebSocket(new Request.Builder().url(str2).build(), new WebSocketListener(this) { // from class: com.baidu.rtc.WebSocketChannel.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ WebSocketChannel this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // okhttp3.WebSocketListener
                public void onClosed(WebSocket webSocket, int i2, String str4) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIL(1048576, this, webSocket, i2, str4) == null) {
                        boolean z2 = BaiduRtcRoomImp.mbEnableDebugLog;
                    }
                }

                @Override // okhttp3.WebSocketListener
                public void onClosing(WebSocket webSocket, int i2, String str4) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webSocket, i2, str4) == null) {
                        boolean z2 = BaiduRtcRoomImp.mbEnableDebugLog;
                        if (this.this$0.delegate != null) {
                            this.this$0.delegate.onConnectError();
                        }
                    }
                }

                @Override // okhttp3.WebSocketListener
                public void onFailure(WebSocket webSocket, Throwable th, Response response) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLL(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, webSocket, th, response) == null) {
                        if (th != null) {
                            String str4 = "onFailure" + th.toString();
                        }
                        if (this.this$0.delegate == null) {
                            return;
                        }
                        if (th instanceof SocketTimeoutException) {
                            if (this.this$0.delegate != null) {
                                this.this$0.delegate.onLoginTimeout();
                            }
                        } else if ((th instanceof NumberFormatException) || (th instanceof NullPointerException)) {
                        } else {
                            if (th instanceof SSLException) {
                                if (this.this$0.delegate != null) {
                                    this.this$0.delegate.onConnectError();
                                    return;
                                }
                                return;
                            }
                            if (this.this$0.mIsEnableErrorInfoMonitor) {
                                ErrorInfoReport.getInstance().reportErrorInfo(ErrorInfoReport.ErrorCode.SIGNAL_CHANNEL_CONNECTION_LOST);
                            }
                            if (this.this$0.delegate != null) {
                                this.this$0.delegate.onLoginError();
                            }
                        }
                    }
                }

                @Override // okhttp3.WebSocketListener
                public void onMessage(WebSocket webSocket, String str4) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048579, this, webSocket, str4) == null) {
                        this.this$0.onMessage(str4);
                    }
                }

                @Override // okhttp3.WebSocketListener
                public void onMessage(WebSocket webSocket, ByteString byteString) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048580, this, webSocket, byteString) == null) {
                    }
                }

                @Override // okhttp3.WebSocketListener
                public void onOpen(WebSocket webSocket, Response response) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048581, this, webSocket, response) == null) {
                        boolean z2 = BaiduRtcRoomImp.mbEnableDebugLog;
                        this.this$0.createSession();
                    }
                }
            });
        }
    }

    public void kickOffUserWithId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048589, this, j) == null) {
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
    }

    public void leaveRoom() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.mHandler.post(new Runnable(this) { // from class: com.baidu.rtc.WebSocketChannel.21
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ WebSocketChannel this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        int size = this.this$0.handles.size();
                        for (int i2 = 0; i2 < size; i2++) {
                            WebSocketChannel webSocketChannel = this.this$0;
                            webSocketChannel.doLeaveRoom((JanusHandle) webSocketChannel.handles.values().toArray()[i2]);
                            try {
                                Thread.sleep(50L);
                            } catch (Exception unused) {
                            }
                        }
                    }
                }
            });
        }
    }

    public void publisherCreateOffer(BigInteger bigInteger, SessionDescription sessionDescription) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, bigInteger, sessionDescription) == null) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject.putOpt("request", "configure");
                jSONObject.putOpt(MediaStreamTrack.AUDIO_TRACK_KIND, Boolean.valueOf(this.mHasAudio));
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
                jSONObject3.putOpt("session_id", this.mSessionId);
                jSONObject3.putOpt("handle_id", bigInteger);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            sendMessage(jSONObject3);
        }
    }

    public void sendMessageToUser(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048592, this, str, j) == null) {
            sendMessageToUser(str, j, false);
        }
    }

    public void setAppId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.mAppId = str;
        }
    }

    public void setAsListener(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.mAsListener = z;
        }
    }

    public void setAsPublisher(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.mAsPublisher = z;
        }
    }

    public void setAutoPublish(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.mAutoPublish = z;
        }
    }

    public void setAutoSubScribe(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.mAutoSubScribe = z;
        }
    }

    public void setConnectionTimeoutMs(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            this.mConnectionTimeoutMs = i2;
        }
    }

    public void setDelegate(JanusRTCInterface janusRTCInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, janusRTCInterface) == null) {
            this.delegate = janusRTCInterface;
        }
    }

    public void setDisplayName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            this.mDisplayName = str;
        }
    }

    public void setEnableErrorInfoMonitor(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            this.mIsEnableErrorInfoMonitor = z;
        }
    }

    public void setHasAudio(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            this.mHasAudio = z;
        }
    }

    public void setHasData(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            this.mHasData = z;
        }
    }

    public void setHasVideo(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            this.mHasVideo = z;
        }
    }

    public void setLssConfigSecond(String str, boolean z, boolean z2, String str2, BaiduRtcRoom.RtcLiveTransferMode rtcLiveTransferMode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048606, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2), str2, rtcLiveTransferMode}) == null) {
            this.mLiveStreamingServerURLSecond = str;
            this.mLiveStreamingMixSecond = z;
            this.mLiveStreamingRecordingSecond = z2;
            this.mLiveStreamingMixTemplateSecond = str2;
            this.mLiveStreamingTransferModeSecond = rtcLiveTransferMode;
        }
    }

    public void setLssMixTemplate(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, str) == null) {
            this.mLiveStreamingMixTemplate = str;
        }
    }

    public void setLssRole(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, str) == null) {
            this.mLiveStreamingRole = str;
        }
    }

    public void setLssTransferMode(BaiduRtcRoom.RtcLiveTransferMode rtcLiveTransferMode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, rtcLiveTransferMode) == null) {
            this.mLiveStreamingTransferMode = rtcLiveTransferMode;
        }
    }

    public void setLssURL(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, str) == null) {
            this.mLiveStreamingServerURL = str;
        }
    }

    public void setMediaServerIP(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, str) == null) {
            this.mMediaServerIP = str;
        }
    }

    public void setMixLayoutPosition(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, str) == null) {
            this.mMixLayoutPosition = str;
        }
    }

    public void setMixing(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048613, this, z) == null) {
            this.mLiveStreamingMix = z;
        }
    }

    public void setReadTimeoutMs(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i2) == null) {
            this.mReadTimeoutMs = i2;
        }
    }

    public void setRecording(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z) == null) {
            this.mLiveStreamingRecording = z;
        }
    }

    public void setRemoteStreamPlayState(Boolean bool, Boolean bool2, long j) {
        JanusHandle janusHandle;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048616, this, new Object[]{bool, bool2, Long.valueOf(j)}) == null) || (janusHandle = this.feeds.get(BigInteger.valueOf(j))) == null) {
            return;
        }
        String randomString = randomString(12);
        JanusTransaction janusTransaction = new JanusTransaction();
        janusTransaction.tid = randomString;
        janusTransaction.success = new TransactionCallbackSuccess(this) { // from class: com.baidu.rtc.WebSocketChannel.22
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ WebSocketChannel this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.baidu.rtc.TransactionCallbackSuccess
            public void success(JSONObject jSONObject) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, jSONObject) == null) {
                }
            }
        };
        janusTransaction.error = new TransactionCallbackError(this) { // from class: com.baidu.rtc.WebSocketChannel.23
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ WebSocketChannel this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.baidu.rtc.TransactionCallbackError
            public void error(JSONObject jSONObject) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, jSONObject) == null) {
                }
            }
        };
        this.transactions.put(randomString, janusTransaction);
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.putOpt("request", "configure");
            jSONObject.putOpt(MediaStreamTrack.AUDIO_TRACK_KIND, bool2);
            jSONObject.putOpt("video", bool);
            jSONObject.putOpt("data", Boolean.TRUE);
            jSONObject2.putOpt("janus", "message");
            jSONObject2.putOpt("body", jSONObject);
            jSONObject2.putOpt("transaction", randomString);
            jSONObject2.putOpt("session_id", this.mSessionId);
            jSONObject2.putOpt("handle_id", janusHandle.handleId);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        sendMessage(jSONObject2);
    }

    public void setRoomId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048617, this, i2) == null) {
            this.mRoomId = i2;
        }
    }

    public void setRoomName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, str) == null) {
            this.mRoomName = str;
        }
    }

    public void setSDK(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, str) == null) {
            this.mSDKTag = str;
        }
    }

    public void setTokenStr(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, str) == null) {
            this.mTokenStr = str;
        }
    }

    public void setUserAttribute(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, str) == null) {
            String randomString = randomString(12);
            JanusTransaction janusTransaction = new JanusTransaction();
            janusTransaction.tid = randomString;
            janusTransaction.success = new TransactionCallbackSuccess(this, str) { // from class: com.baidu.rtc.WebSocketChannel.26
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ WebSocketChannel this$0;
                public final /* synthetic */ String val$a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$a = str;
                }

                @Override // com.baidu.rtc.TransactionCallbackSuccess
                public void success(JSONObject jSONObject) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, jSONObject) == null) {
                        this.this$0.sendMessageToUser(this.val$a, 0L, true);
                    }
                }
            };
            janusTransaction.error = new TransactionCallbackError(this) { // from class: com.baidu.rtc.WebSocketChannel.27
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ WebSocketChannel this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // com.baidu.rtc.TransactionCallbackError
                public void error(JSONObject jSONObject) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, jSONObject) == null) {
                    }
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
                jSONObject2.putOpt("session_id", this.mSessionId);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            sendMessage(jSONObject2);
        }
    }

    public void setUserId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048622, this, j) == null) {
            this.mUserId = j;
        }
    }

    public void setVideoCodec(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, str) == null) {
            this.mVideoCodec = str.toLowerCase();
        }
    }

    public void shutUpUserWithId(long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048624, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("request", "forwardconfigure");
                jSONObject.putOpt("room", Long.valueOf(this.mRoomId));
                jSONObject.putOpt("target", Long.valueOf(j));
                boolean z2 = true;
                jSONObject.putOpt(MediaStreamTrack.AUDIO_TRACK_KIND, Boolean.valueOf(!z));
                jSONObject.putOpt("video", Boolean.valueOf(!z));
                if (z) {
                    z2 = false;
                }
                jSONObject.putOpt("data", Boolean.valueOf(z2));
                Send(jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void startPublishLiveStream(String str, boolean z, boolean z2, String str2, BaiduRtcRoom.RtcLiveTransferMode rtcLiveTransferMode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048625, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2), str2, rtcLiveTransferMode}) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject.putOpt("request", "startbypass");
                jSONObject.putOpt(ComboPraiseProvider.RES_KEY_PREFIX_PRAISE_LEVEL, rtcLiveTransferMode == BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ANCHOR_TRASNSMISSION ? "anchor" : "room");
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
    }

    public void stopPublishLiveStream(BaiduRtcRoom.RtcLiveTransferMode rtcLiveTransferMode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, rtcLiveTransferMode) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("request", "stopbypass");
                jSONObject.putOpt(ComboPraiseProvider.RES_KEY_PREFIX_PRAISE_LEVEL, rtcLiveTransferMode == BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ANCHOR_TRASNSMISSION ? "anchor" : "room");
                jSONObject.putOpt("room", Long.valueOf(this.mRoomId));
                jSONObject.putOpt("id", Long.valueOf(this.mUserId));
                Send(jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void subscriberCreateAnswer(BigInteger bigInteger, SessionDescription sessionDescription) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048627, this, bigInteger, sessionDescription) == null) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject.putOpt("request", "start");
                jSONObject.putOpt("room", Long.valueOf(this.mRoomId));
                jSONObject2.putOpt("type", sessionDescription.type);
                jSONObject2.putOpt("sdp", sessionDescription.description);
                jSONObject3.putOpt("janus", "message");
                jSONObject3.putOpt("body", jSONObject);
                jSONObject3.putOpt("jsep", jSONObject2);
                jSONObject3.putOpt("transaction", randomString(12));
                jSONObject3.putOpt("session_id", this.mSessionId);
                jSONObject3.putOpt("handle_id", bigInteger);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            sendMessage(jSONObject3);
        }
    }

    public void subscriberCreateHandle(BigInteger bigInteger, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048628, this, bigInteger, str) == null) {
            String randomString = randomString(12);
            JanusTransaction janusTransaction = new JanusTransaction();
            janusTransaction.tid = randomString;
            janusTransaction.success = new TransactionCallbackSuccess(this, bigInteger, str) { // from class: com.baidu.rtc.WebSocketChannel.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ WebSocketChannel this$0;
                public final /* synthetic */ String val$display;
                public final /* synthetic */ BigInteger val$feed;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, bigInteger, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$feed = bigInteger;
                    this.val$display = str;
                }

                @Override // com.baidu.rtc.TransactionCallbackSuccess
                public void success(JSONObject jSONObject) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, jSONObject) == null) {
                        JanusHandle janusHandle = new JanusHandle();
                        janusHandle.handleId = new BigInteger(jSONObject.optJSONObject("data").optString("id"));
                        janusHandle.feedId = this.val$feed;
                        janusHandle.display = this.val$display;
                        janusHandle.onRemoteJsep = new OnRemoteJsep(this) { // from class: com.baidu.rtc.WebSocketChannel.9.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass9 this$1;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$1 = this;
                            }

                            @Override // com.baidu.rtc.OnRemoteJsep
                            public void onRemoteJsep(JanusHandle janusHandle2, JSONObject jSONObject2) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeLL(1048576, this, janusHandle2, jSONObject2) == null) {
                                    this.this$1.this$0.delegate.subscriberHandleRemoteJsep(janusHandle2.handleId, jSONObject2);
                                }
                            }
                        };
                        janusHandle.onLeaving = new OnJoined(this) { // from class: com.baidu.rtc.WebSocketChannel.9.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass9 this$1;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$1 = this;
                            }

                            @Override // com.baidu.rtc.OnJoined
                            public void onJoined(JanusHandle janusHandle2) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeL(1048576, this, janusHandle2) == null) {
                                    this.this$1.this$0.subscriberOnLeaving(janusHandle2);
                                }
                            }
                        };
                        this.this$0.handles.put(janusHandle.handleId, janusHandle);
                        this.this$0.feeds.put(janusHandle.feedId, janusHandle);
                        this.this$0.subscriberJoinRoom(janusHandle);
                    }
                }
            };
            janusTransaction.error = new TransactionCallbackError(this) { // from class: com.baidu.rtc.WebSocketChannel.10
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ WebSocketChannel this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // com.baidu.rtc.TransactionCallbackError
                public void error(JSONObject jSONObject) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, jSONObject) == null) {
                    }
                }
            };
            this.transactions.put(randomString, janusTransaction);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("janus", "attach");
                jSONObject.putOpt("plugin", "janus.plugin.videoroom");
                jSONObject.putOpt("transaction", randomString);
                jSONObject.putOpt("session_id", this.mSessionId);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            sendMessage(jSONObject);
        }
    }

    public void subscriberOnLeaving(JanusHandle janusHandle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, janusHandle) == null) {
            String randomString = randomString(12);
            JanusTransaction janusTransaction = new JanusTransaction();
            janusTransaction.tid = randomString;
            janusTransaction.success = new TransactionCallbackSuccess(this, janusHandle) { // from class: com.baidu.rtc.WebSocketChannel.11
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ WebSocketChannel this$0;
                public final /* synthetic */ JanusHandle val$handle;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, janusHandle};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$handle = janusHandle;
                }

                @Override // com.baidu.rtc.TransactionCallbackSuccess
                public void success(JSONObject jSONObject) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, jSONObject) == null) {
                        JanusRTCInterface janusRTCInterface = this.this$0.delegate;
                        JanusHandle janusHandle2 = this.val$handle;
                        janusRTCInterface.onLeaving(janusHandle2.handleId, janusHandle2.feedId);
                        this.this$0.delegate.onRemoteGone(this.val$handle.handleId);
                        this.this$0.handles.remove(this.val$handle.handleId);
                        this.this$0.feeds.remove(this.val$handle.feedId);
                    }
                }
            };
            janusTransaction.error = new TransactionCallbackError(this) { // from class: com.baidu.rtc.WebSocketChannel.12
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ WebSocketChannel this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // com.baidu.rtc.TransactionCallbackError
                public void error(JSONObject jSONObject) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, jSONObject) == null) {
                    }
                }
            };
            this.transactions.put(randomString, janusTransaction);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("janus", "detach");
                jSONObject.putOpt("transaction", randomString);
                jSONObject.putOpt("session_id", this.mSessionId);
                jSONObject.putOpt("handle_id", janusHandle.handleId);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            sendMessage(jSONObject);
        }
    }

    public void trickleCandidate(BigInteger bigInteger, IceCandidate iceCandidate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048630, this, bigInteger, iceCandidate) == null) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject.putOpt("candidate", iceCandidate.sdp);
                jSONObject.putOpt("sdpMid", iceCandidate.sdpMid);
                jSONObject.putOpt("sdpMLineIndex", Integer.valueOf(iceCandidate.sdpMLineIndex));
                jSONObject2.putOpt("janus", "trickle");
                jSONObject2.putOpt("candidate", jSONObject);
                jSONObject2.putOpt("transaction", randomString(12));
                jSONObject2.putOpt("session_id", this.mSessionId);
                jSONObject2.putOpt("handle_id", bigInteger);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            sendMessage(jSONObject2);
        }
    }

    public void trickleCandidateComplete(BigInteger bigInteger) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, bigInteger) == null) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject.putOpt("completed", Boolean.TRUE);
                jSONObject2.putOpt("janus", "trickle");
                jSONObject2.putOpt("candidate", jSONObject);
                jSONObject2.putOpt("transaction", randomString(12));
                jSONObject2.putOpt("session_id", this.mSessionId);
                jSONObject2.putOpt("handle_id", bigInteger);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void unpublishHandle(BigInteger bigInteger) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, bigInteger) == null) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject.putOpt("request", "unpublish");
                jSONObject2.putOpt("janus", "message");
                jSONObject2.putOpt("body", jSONObject);
                jSONObject2.putOpt("transaction", randomString(12));
                jSONObject2.putOpt("session_id", this.mSessionId);
                jSONObject2.putOpt("handle_id", bigInteger);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            sendMessage(jSONObject2);
        }
    }

    public void sendMessageToUser(String str, long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{str, Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            String randomString = randomString(12);
            JanusTransaction janusTransaction = new JanusTransaction();
            janusTransaction.tid = randomString;
            janusTransaction.success = new TransactionCallbackSuccess(this) { // from class: com.baidu.rtc.WebSocketChannel.24
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ WebSocketChannel this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // com.baidu.rtc.TransactionCallbackSuccess
                public void success(JSONObject jSONObject) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, jSONObject) == null) {
                    }
                }
            };
            janusTransaction.error = new TransactionCallbackError(this) { // from class: com.baidu.rtc.WebSocketChannel.25
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ WebSocketChannel this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // com.baidu.rtc.TransactionCallbackError
                public void error(JSONObject jSONObject) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, jSONObject) == null) {
                    }
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
                jSONObject2.putOpt("session_id", this.mSessionId);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            sendMessage(jSONObject2);
        }
    }
}
