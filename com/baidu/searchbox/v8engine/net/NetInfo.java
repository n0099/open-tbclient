package com.baidu.searchbox.v8engine.net;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.fluency.tracer.FpsTracer;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.searchbox.util.BaiduActiveStatistic;
import com.baidu.smallgame.sdk.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class NetInfo {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "NetInfo";
    public transient /* synthetic */ FieldHolder $fh;
    public Base mBase;
    public JSONObject mJSONObject;
    public Response mResponse;
    public Socket mSocket;
    public Ssl mSsl;
    public SwanExtra mSwanExtra;
    public Timing mTiming;

    /* loaded from: classes2.dex */
    public static class Dns {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public JSONObject mJSONObject;

        /* loaded from: classes2.dex */
        public static class Config {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public Config() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }
        }

        /* loaded from: classes2.dex */
        public static class Result {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public Result() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }
        }

        public Dns(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mJSONObject = jSONObject;
        }
    }

    /* loaded from: classes2.dex */
    public static class Socket {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public JSONObject mJSONObject;
        public boolean mQuic;
        public boolean mReused;

        /* loaded from: classes2.dex */
        public static class Attempts {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public Attempts() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }
        }

        public Socket(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            if (jSONObject != null) {
                this.mJSONObject = jSONObject;
                this.mQuic = JSONObjectUtils.getBoolean(jSONObject, "quic");
                this.mReused = JSONObjectUtils.getBoolean(this.mJSONObject, "reused");
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "Socket{mJSONObject=" + this.mJSONObject + ", mQuic=" + this.mQuic + ", mReused=" + this.mReused + '}';
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static class SwanExtra {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Timing mTiming;

        /* loaded from: classes2.dex */
        public static class Timing {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public long mConnectTime;

            public Timing() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.mConnectTime = -1L;
            }
        }

        public SwanExtra() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mTiming = new Timing();
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "SwanExtra{mTiming=" + this.mTiming + "}";
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static class Base {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public JSONObject mJSONObject;
        public int mNetType;
        public double mRequestStart;
        public int mStatus;
        public String mUrl;

        public Base(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            if (jSONObject != null) {
                this.mJSONObject = jSONObject;
                this.mNetType = JSONObjectUtils.getInt(jSONObject, FpsTracer.UBC_KEY_NET_TYPE);
                this.mRequestStart = JSONObjectUtils.getDouble(this.mJSONObject, BaiduActiveStatistic.UBC_VALUE_REQUEST_START);
                this.mStatus = JSONObjectUtils.getInt(this.mJSONObject, "status");
                this.mUrl = JSONObjectUtils.getString(this.mJSONObject, "url");
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "Base{mJSONObject=" + this.mJSONObject + ", mNetType=" + this.mNetType + ", mRequestStart=" + this.mRequestStart + ", mStatus=" + this.mStatus + ", mUrl='" + this.mUrl + "'}";
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static class JSONObjectUtils {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public JSONObjectUtils() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static boolean getBoolean(JSONObject jSONObject, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, jSONObject, str)) == null) {
                if (jSONObject == null) {
                    return false;
                }
                try {
                    return jSONObject.getBoolean(str);
                } catch (JSONException e) {
                    Log.w(NetInfo.TAG, e.getMessage());
                    return false;
                }
            }
            return invokeLL.booleanValue;
        }

        public static double getDouble(JSONObject jSONObject, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jSONObject, str)) == null) {
                if (jSONObject == null) {
                    return 0.0d;
                }
                try {
                    return jSONObject.getDouble(str);
                } catch (JSONException e) {
                    Log.w(NetInfo.TAG, e.getMessage());
                    return 0.0d;
                }
            }
            return invokeLL.doubleValue;
        }

        public static int getInt(JSONObject jSONObject, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, jSONObject, str)) == null) {
                if (jSONObject == null) {
                    return 0;
                }
                try {
                    return jSONObject.getInt(str);
                } catch (JSONException e) {
                    Log.w(NetInfo.TAG, e.getMessage());
                    return 0;
                }
            }
            return invokeLL.intValue;
        }

        public static JSONObject getJSONObject(JSONObject jSONObject, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject, str)) == null) {
                if (jSONObject == null) {
                    return null;
                }
                try {
                    return jSONObject.getJSONObject(str);
                } catch (JSONException e) {
                    Log.w(NetInfo.TAG, e.getMessage());
                    return null;
                }
            }
            return (JSONObject) invokeLL.objValue;
        }

        public static long getLong(JSONObject jSONObject, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, jSONObject, str)) == null) {
                if (jSONObject == null) {
                    return 0L;
                }
                try {
                    return jSONObject.getLong(str);
                } catch (JSONException e) {
                    Log.w(NetInfo.TAG, e.getMessage());
                    return 0L;
                }
            }
            return invokeLL.longValue;
        }

        public static String getString(JSONObject jSONObject, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, jSONObject, str)) == null) {
                if (jSONObject == null) {
                    return "";
                }
                try {
                    return jSONObject.getString(str);
                } catch (JSONException e) {
                    Log.w(NetInfo.TAG, e.getMessage());
                    return "";
                }
            }
            return (String) invokeLL.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static class Quic {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Quic() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class Response {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean mBackupJob;
        public boolean mCached;
        public int mCode;
        public int mConnectionInfo;
        public int mDnsSource;
        public JSONObject mJSONObject;
        public boolean mNetworkAccessed;
        public int mQuicSend;
        public int mQuicType;
        public int mRaceResult;
        public int mReceivedBytes;
        public int mResolveType;
        public int mSentBytes;
        public int mUseQuic;
        public boolean mViaProxy;
        public int mWeakNqe;
        public int mWeakRtt;

        public Response(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            if (jSONObject != null) {
                this.mJSONObject = jSONObject;
                this.mBackupJob = JSONObjectUtils.getBoolean(jSONObject, "backup_job");
                this.mCached = JSONObjectUtils.getBoolean(this.mJSONObject, "cached");
                this.mCode = JSONObjectUtils.getInt(this.mJSONObject, "code");
                this.mConnectionInfo = JSONObjectUtils.getInt(this.mJSONObject, "connection_info");
                this.mDnsSource = JSONObjectUtils.getInt(this.mJSONObject, "dns_source");
                this.mNetworkAccessed = JSONObjectUtils.getBoolean(this.mJSONObject, "network_accessed");
                this.mQuicSend = JSONObjectUtils.getInt(this.mJSONObject, "quic_send");
                this.mQuicType = JSONObjectUtils.getInt(this.mJSONObject, "quic_type");
                this.mRaceResult = JSONObjectUtils.getInt(this.mJSONObject, "race_result");
                this.mReceivedBytes = JSONObjectUtils.getInt(this.mJSONObject, "received_bytes");
                this.mResolveType = JSONObjectUtils.getInt(this.mJSONObject, "resolve_type");
                this.mSentBytes = JSONObjectUtils.getInt(this.mJSONObject, "sent_bytes");
                this.mUseQuic = JSONObjectUtils.getInt(this.mJSONObject, "use_quic");
                this.mViaProxy = JSONObjectUtils.getBoolean(this.mJSONObject, "via_proxy");
                this.mWeakNqe = JSONObjectUtils.getInt(this.mJSONObject, "weak_nqe");
                this.mWeakRtt = JSONObjectUtils.getInt(this.mJSONObject, "weak_rtt");
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "Response{mJSONObject=" + this.mJSONObject + ", mBackupJob=" + this.mBackupJob + ", mCached=" + this.mCached + ", mCode=" + this.mCode + ", mConnectionInfo=" + this.mConnectionInfo + ", mDnsSource=" + this.mDnsSource + ", mNetworkAccessed=" + this.mNetworkAccessed + ", mQuicSend=" + this.mQuicSend + ", mQuicType=" + this.mQuicType + ", mRaceResult=" + this.mRaceResult + ", mReceivedBytes=" + this.mReceivedBytes + ", mResolveType=" + this.mResolveType + ", mSentBytes=" + this.mSentBytes + ", mUseQuic=" + this.mUseQuic + ", mViaProxy=" + this.mViaProxy + ", mWeakNqe=" + this.mWeakNqe + ", mWeakRtt=" + this.mWeakRtt + '}';
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static class Ssl {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean mClientCertSent;
        public int mConnectionStatus;
        public int mHandshakeType;
        public boolean mIsIssuedByKnownRoot;
        public JSONObject mJSONObject;
        public int mKeyExchangeInfo;

        public Ssl(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            if (jSONObject != null) {
                this.mJSONObject = jSONObject;
                this.mClientCertSent = JSONObjectUtils.getBoolean(jSONObject, "client_cert_sent");
                this.mConnectionStatus = JSONObjectUtils.getInt(this.mJSONObject, "connection_status");
                this.mHandshakeType = JSONObjectUtils.getInt(this.mJSONObject, "handshake_type");
                this.mIsIssuedByKnownRoot = JSONObjectUtils.getBoolean(this.mJSONObject, "is_issued_by_known_root");
                this.mKeyExchangeInfo = JSONObjectUtils.getInt(this.mJSONObject, "key_exchange_info");
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "Ssl{mJSONObject=" + this.mJSONObject + ", mClientCertSent=" + this.mClientCertSent + ", mConnectionStatus=" + this.mConnectionStatus + ", mHandshakeType=" + this.mHandshakeType + ", mIsIssuedByKnownRoot=" + this.mIsIssuedByKnownRoot + ", mKeyExchangeInfo=" + this.mKeyExchangeInfo + '}';
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static class Timing {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long mConnect;
        public long mDns;
        public long mDurationTime;
        public int mHeadRecv;
        public JSONObject mJSONObject;
        public int mRedirect;
        public int mSend;
        public int mSsl;
        public int mTTfb;

        public Timing(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            if (jSONObject != null) {
                this.mJSONObject = jSONObject;
                this.mConnect = JSONObjectUtils.getLong(jSONObject, "connect");
                this.mDns = JSONObjectUtils.getLong(this.mJSONObject, "dns");
                this.mDurationTime = JSONObjectUtils.getLong(this.mJSONObject, "duration_time");
                this.mHeadRecv = JSONObjectUtils.getInt(this.mJSONObject, "head_recv");
                this.mRedirect = JSONObjectUtils.getInt(this.mJSONObject, "redirect");
                this.mSend = JSONObjectUtils.getInt(this.mJSONObject, "send");
                this.mSsl = JSONObjectUtils.getInt(this.mJSONObject, "ssl");
                this.mTTfb = JSONObjectUtils.getInt(this.mJSONObject, "ttfb");
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "Timing{mJSONObject=" + this.mJSONObject + ", mConnect=" + this.mConnect + ", mDns=" + this.mDns + ", mDurationTime=" + this.mDurationTime + ", mHeadRecv=" + this.mHeadRecv + ", mRedirect=" + this.mRedirect + ", mSend=" + this.mSend + ", mSsl=" + this.mSsl + ", mTTfb=" + this.mTTfb + '}';
            }
            return (String) invokeV.objValue;
        }
    }

    public NetInfo(String str, SwanExtra swanExtra) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, swanExtra};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mSwanExtra = swanExtra;
        if (!TextUtils.isEmpty(str)) {
            try {
                this.mJSONObject = new JSONObject(str);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Base getBase() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!isEmpty() && this.mBase == null) {
                this.mBase = new Base(JSONObjectUtils.getJSONObject(this.mJSONObject, SchemeCollecter.CLASSIFY_BASE));
            }
            return this.mBase;
        }
        return (Base) invokeV.objValue;
    }

    public Response getResponse() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (!isEmpty() && this.mResponse == null) {
                this.mResponse = new Response(JSONObjectUtils.getJSONObject(this.mJSONObject, "response"));
            }
            return this.mResponse;
        }
        return (Response) invokeV.objValue;
    }

    public Socket getSocket() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (!isEmpty() && this.mSocket == null) {
                this.mSocket = new Socket(JSONObjectUtils.getJSONObject(this.mJSONObject, "socket"));
            }
            return this.mSocket;
        }
        return (Socket) invokeV.objValue;
    }

    public Ssl getSsl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (!isEmpty() && this.mSsl == null) {
                this.mSsl = new Ssl(JSONObjectUtils.getJSONObject(this.mJSONObject, "ssl"));
            }
            return this.mSsl;
        }
        return (Ssl) invokeV.objValue;
    }

    public SwanExtra getSwanExtra() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mSwanExtra;
        }
        return (SwanExtra) invokeV.objValue;
    }

    public Timing getTiming() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (!isEmpty() && this.mTiming == null) {
                this.mTiming = new Timing(JSONObjectUtils.getJSONObject(this.mJSONObject, "timing"));
            }
            return this.mTiming;
        }
        return (Timing) invokeV.objValue;
    }

    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.mJSONObject == null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void setSwanExtra(SwanExtra swanExtra) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, swanExtra) == null) {
            this.mSwanExtra = swanExtra;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return "NetInfo{mBase=" + this.mBase + ", mTiming=" + this.mTiming + ", mResponse=" + this.mResponse + ", mSocket=" + this.mSocket + ", mSsl=" + this.mSsl + ", mSwanExtra=" + this.mSwanExtra + ", mJSONObject=" + this.mJSONObject + '}';
        }
        return (String) invokeV.objValue;
    }
}
