package com.baidu.searchbox.v8engine.net;

import android.text.TextUtils;
import com.baidu.searchbox.dns.cache.DnsCacheHelper;
import com.baidu.searchbox.fluency.tracer.FpsTracer;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.searchbox.util.BaiduActiveStatistic;
import com.baidu.smallgame.sdk.Log;
import com.baidu.tbadk.core.log.Logger;
import com.huawei.hms.framework.common.ExceptionCode;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class NetInfo {
    public static final String TAG = "NetInfo";
    public Base mBase;
    public JSONObject mJSONObject;
    public Response mResponse;
    public Socket mSocket;
    public Ssl mSsl;
    public SwanExtra mSwanExtra;
    public Timing mTiming;

    /* loaded from: classes4.dex */
    public static class Quic {
    }

    /* loaded from: classes4.dex */
    public static class Base {
        public JSONObject mJSONObject;
        public int mNetType;
        public double mRequestStart;
        public int mStatus;
        public String mUrl;

        public Base(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.mJSONObject = jSONObject;
                this.mNetType = JSONObjectUtils.getInt(jSONObject, FpsTracer.UBC_KEY_NET_TYPE);
                this.mRequestStart = JSONObjectUtils.getDouble(this.mJSONObject, BaiduActiveStatistic.UBC_VALUE_REQUEST_START);
                this.mStatus = JSONObjectUtils.getInt(this.mJSONObject, "status");
                this.mUrl = JSONObjectUtils.getString(this.mJSONObject, "url");
            }
        }

        public String toString() {
            return "Base{mJSONObject=" + this.mJSONObject + ", mNetType=" + this.mNetType + ", mRequestStart=" + this.mRequestStart + ", mStatus=" + this.mStatus + ", mUrl='" + this.mUrl + "'}";
        }
    }

    /* loaded from: classes4.dex */
    public static class Dns {
        public JSONObject mJSONObject;

        /* loaded from: classes4.dex */
        public static class Config {
        }

        /* loaded from: classes4.dex */
        public static class Result {
        }

        public Dns(JSONObject jSONObject) {
            this.mJSONObject = jSONObject;
        }
    }

    /* loaded from: classes4.dex */
    public static class Response {
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
            return "Response{mJSONObject=" + this.mJSONObject + ", mBackupJob=" + this.mBackupJob + ", mCached=" + this.mCached + ", mCode=" + this.mCode + ", mConnectionInfo=" + this.mConnectionInfo + ", mDnsSource=" + this.mDnsSource + ", mNetworkAccessed=" + this.mNetworkAccessed + ", mQuicSend=" + this.mQuicSend + ", mQuicType=" + this.mQuicType + ", mRaceResult=" + this.mRaceResult + ", mReceivedBytes=" + this.mReceivedBytes + ", mResolveType=" + this.mResolveType + ", mSentBytes=" + this.mSentBytes + ", mUseQuic=" + this.mUseQuic + ", mViaProxy=" + this.mViaProxy + ", mWeakNqe=" + this.mWeakNqe + ", mWeakRtt=" + this.mWeakRtt + '}';
        }
    }

    /* loaded from: classes4.dex */
    public static class Socket {
        public JSONObject mJSONObject;
        public boolean mQuic;
        public boolean mReused;

        /* loaded from: classes4.dex */
        public static class Attempts {
        }

        public Socket(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.mJSONObject = jSONObject;
                this.mQuic = JSONObjectUtils.getBoolean(jSONObject, "quic");
                this.mReused = JSONObjectUtils.getBoolean(this.mJSONObject, "reused");
            }
        }

        public String toString() {
            return "Socket{mJSONObject=" + this.mJSONObject + ", mQuic=" + this.mQuic + ", mReused=" + this.mReused + '}';
        }
    }

    /* loaded from: classes4.dex */
    public static class Ssl {
        public boolean mClientCertSent;
        public int mConnectionStatus;
        public int mHandshakeType;
        public boolean mIsIssuedByKnownRoot;
        public JSONObject mJSONObject;
        public int mKeyExchangeInfo;

        public Ssl(JSONObject jSONObject) {
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
            return "Ssl{mJSONObject=" + this.mJSONObject + ", mClientCertSent=" + this.mClientCertSent + ", mConnectionStatus=" + this.mConnectionStatus + ", mHandshakeType=" + this.mHandshakeType + ", mIsIssuedByKnownRoot=" + this.mIsIssuedByKnownRoot + ", mKeyExchangeInfo=" + this.mKeyExchangeInfo + '}';
        }
    }

    /* loaded from: classes4.dex */
    public static class SwanExtra {
        public Timing mTiming = new Timing();

        /* loaded from: classes4.dex */
        public static class Timing {
            public long mConnectTime = -1;
        }

        public String toString() {
            return "SwanExtra{mTiming=" + this.mTiming + "}";
        }
    }

    /* loaded from: classes4.dex */
    public static class Timing {
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
            if (jSONObject != null) {
                this.mJSONObject = jSONObject;
                this.mConnect = JSONObjectUtils.getLong(jSONObject, ExceptionCode.CONNECT);
                this.mDns = JSONObjectUtils.getLong(this.mJSONObject, DnsCacheHelper.DIR_NAME);
                this.mDurationTime = JSONObjectUtils.getLong(this.mJSONObject, "duration_time");
                this.mHeadRecv = JSONObjectUtils.getInt(this.mJSONObject, "head_recv");
                this.mRedirect = JSONObjectUtils.getInt(this.mJSONObject, "redirect");
                this.mSend = JSONObjectUtils.getInt(this.mJSONObject, "send");
                this.mSsl = JSONObjectUtils.getInt(this.mJSONObject, "ssl");
                this.mTTfb = JSONObjectUtils.getInt(this.mJSONObject, "ttfb");
            }
        }

        public String toString() {
            return "Timing{mJSONObject=" + this.mJSONObject + ", mConnect=" + this.mConnect + ", mDns=" + this.mDns + ", mDurationTime=" + this.mDurationTime + ", mHeadRecv=" + this.mHeadRecv + ", mRedirect=" + this.mRedirect + ", mSend=" + this.mSend + ", mSsl=" + this.mSsl + ", mTTfb=" + this.mTTfb + '}';
        }
    }

    public NetInfo(String str, SwanExtra swanExtra) {
        this.mSwanExtra = swanExtra;
        if (!TextUtils.isEmpty(str)) {
            try {
                this.mJSONObject = new JSONObject(str);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class JSONObjectUtils {
        public static boolean getBoolean(JSONObject jSONObject, String str) {
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

        public static double getDouble(JSONObject jSONObject, String str) {
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

        public static int getInt(JSONObject jSONObject, String str) {
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

        public static JSONObject getJSONObject(JSONObject jSONObject, String str) {
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

        public static long getLong(JSONObject jSONObject, String str) {
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

        public static String getString(JSONObject jSONObject, String str) {
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
    }

    public Base getBase() {
        if (!isEmpty() && this.mBase == null) {
            this.mBase = new Base(JSONObjectUtils.getJSONObject(this.mJSONObject, SchemeCollecter.CLASSIFY_BASE));
        }
        return this.mBase;
    }

    public Response getResponse() {
        if (!isEmpty() && this.mResponse == null) {
            this.mResponse = new Response(JSONObjectUtils.getJSONObject(this.mJSONObject, "response"));
        }
        return this.mResponse;
    }

    public Socket getSocket() {
        if (!isEmpty() && this.mSocket == null) {
            this.mSocket = new Socket(JSONObjectUtils.getJSONObject(this.mJSONObject, Logger.SOCKET_TYPE));
        }
        return this.mSocket;
    }

    public Ssl getSsl() {
        if (!isEmpty() && this.mSsl == null) {
            this.mSsl = new Ssl(JSONObjectUtils.getJSONObject(this.mJSONObject, "ssl"));
        }
        return this.mSsl;
    }

    public SwanExtra getSwanExtra() {
        return this.mSwanExtra;
    }

    public Timing getTiming() {
        if (!isEmpty() && this.mTiming == null) {
            this.mTiming = new Timing(JSONObjectUtils.getJSONObject(this.mJSONObject, "timing"));
        }
        return this.mTiming;
    }

    public boolean isEmpty() {
        if (this.mJSONObject == null) {
            return true;
        }
        return false;
    }

    public void setSwanExtra(SwanExtra swanExtra) {
        this.mSwanExtra = swanExtra;
    }

    public String toString() {
        return "NetInfo{mBase=" + this.mBase + ", mTiming=" + this.mTiming + ", mResponse=" + this.mResponse + ", mSocket=" + this.mSocket + ", mSsl=" + this.mSsl + ", mSwanExtra=" + this.mSwanExtra + ", mJSONObject=" + this.mJSONObject + '}';
    }
}
