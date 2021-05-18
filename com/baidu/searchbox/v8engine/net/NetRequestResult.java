package com.baidu.searchbox.v8engine.net;

import com.baidu.searchbox.v8engine.NotProguard;
import com.baidu.searchbox.v8engine.net.NetInfo;
@NotProguard
/* loaded from: classes2.dex */
public class NetRequestResult {
    public static final byte NET_REQUEST_RESULT_FROM_TYPE_REQUEST = 0;
    public static final byte NET_REQUEST_RESULT_FROM_TYPE_RESPONSE = 1;
    public static final byte NET_REQUEST_RESULT_FROM_TYPE_UNKNOWN = 3;
    public static final byte NET_REQUEST_RESULT_FROM_TYPE_V8_TASK = 2;
    public static final int STATUS_CODE_ABORT_ACTIVELY_TRIGGER_START = 11;
    public static final int STATUS_CODE_ABORT_REQUEST_TIMEOUT = 9;
    public static final int STATUS_CODE_EXECUTE_FAILED_V8_TASK = 8;
    public static final int STATUS_CODE_EXECUTE_SUCCEEDED_V8_TASK = 7;
    public static final int STATUS_CODE_INTERCEPT_NET_REQUEST = -301;
    public static final int STATUS_CODE_INTERPRET_NET_REQUEST_PARAM_FINISH = 4;
    public static final int STATUS_CODE_INTERPRET_NET_REQUEST_PARAM_START = 3;
    public static final int STATUS_CODE_NA_REQUEST_DATA_ERROR = -108;
    public static final int STATUS_CODE_NA_REQUEST_DATA_TRANSFORM_FAILED_ERROR = -109;
    public static final int STATUS_CODE_NA_REQUEST_DATA_TYPE_ERROR = -106;
    public static final int STATUS_CODE_NA_REQUEST_DELAY_SEND_REQUEST = 1;
    public static final int STATUS_CODE_NA_REQUEST_FUNCTION_TABLE_INVALID_ERROR = -201;
    public static final int STATUS_CODE_NA_REQUEST_HEADER_ERROR = -104;
    public static final int STATUS_CODE_NA_REQUEST_ISSUE_REQUEST = 6;
    public static final int STATUS_CODE_NA_REQUEST_JNI_NET_REQUEST_INVALID_ERROR = -202;
    public static final int STATUS_CODE_NA_REQUEST_METHOD_ERROR = -103;
    public static final int STATUS_CODE_NA_REQUEST_NET_FUNCTION_TABLE_READY = 2;
    public static final int STATUS_CODE_NA_REQUEST_NO_ERROR = 0;
    public static final int STATUS_CODE_NA_REQUEST_POST_PROCESSING_FAILED_DATA_EMPTY_ERROR = -110;
    public static final int STATUS_CODE_NA_REQUEST_POST_PROCESSING_FAILED_DATA_TOO_LARGE_ERROR = -111;
    public static final int STATUS_CODE_NA_REQUEST_RESPONSE_DATA_TOO_LARGE_ERROR = -105;
    public static final int STATUS_CODE_NA_REQUEST_RESPONSE_TYPE_ERROR = -107;
    public static final int STATUS_CODE_NA_REQUEST_URL_EMPTY_ERROR = -102;
    public static final int STATUS_CODE_NA_REQUEST_URL_ERROR = -101;
    public static final int STATUS_CODE_NET_REQUEST_CALLBACK_EXECUTE_ERROR = 1001;
    public static final int STATUS_CODE_NET_REQUEST_CALLBACK_SCHEME_ERROR = 202;
    public static final int STATUS_CODE_PREPARE_ABORT_ACTIVELY_TRIGGER = 10;
    public static final int STATUS_CODE_REINTERPRET_NET_REQUEST_PARAM_FINISH = 5;
    public static final int STATUS_CODE_V8NET_RESULT_ENV_NOT_READY = -3;
    public static final int STATUS_CODE_V8NET_RESULT_ENV_SHUTDOWN = -8;
    public static final int STATUS_CODE_V8NET_RESULT_ILLEGAL_ARGS = -7;
    public static final int STATUS_CODE_V8NET_RESULT_ILLEGAL_METHOD = -6;
    public static final int STATUS_CODE_V8NET_RESULT_ILLEGAL_URL = -5;
    public static final int STATUS_CODE_V8NET_RESULT_INPUT_ERR = -1;
    public static final int STATUS_CODE_V8NET_RESULT_MALLOC_FAILED = -2;
    public static final int STATUS_CODE_V8NET_RESULT_REQUEST_ERROR = -4;
    public static final int STATUS_CODE_V8NET_RESULT_REQUEST_FAIL = -9;
    public static final int STATUS_CODE_V8NET_RESULT_SUCCESS = 0;
    public static final String TAG = "NetRequestResult";
    public long mCreatedTime;
    public boolean mDirty;
    public byte mFromType;
    public long mId;
    public long mNativePtr;
    public NetInfo mNetInfo;
    public int mStatusCode;
    public String mStatusMsg;
    public NetInfo.SwanExtra mSwanExtra = new NetInfo.SwanExtra();
    public String mUrl;

    public NetRequestResult(long j, long j2) {
        this.mId = j;
        this.mNativePtr = j2;
    }

    private native int nativeGetFromType(long j);

    private native String nativeGetNetInfo(long j);

    private native int nativeGetStatusCode(long j);

    private native String nativeGetStatusMsg(long j);

    private native String nativeGetUrl(long j);

    private native void nativeSetStatusCode(long j, int i2);

    private native void nativeSetStatusMsg(long j, String str);

    private void setConnectTime(long j) {
        this.mSwanExtra.mTiming.mConnectTime = j;
    }

    public long getCreatedTime() {
        return this.mCreatedTime;
    }

    public int getFromType() {
        long j = this.mNativePtr;
        if (j != 0) {
            return nativeGetFromType(j);
        }
        return this.mFromType;
    }

    public long getId() {
        return this.mId;
    }

    public NetInfo getNetInfo() {
        NetInfo netInfo = this.mNetInfo;
        if (netInfo != null) {
            return netInfo;
        }
        long j = this.mNativePtr;
        if (j != 0) {
            NetInfo netInfo2 = new NetInfo(nativeGetNetInfo(j), this.mSwanExtra);
            this.mNetInfo = netInfo2;
            return netInfo2;
        }
        return null;
    }

    public int getStatusCode() {
        if (this.mDirty) {
            return this.mStatusCode;
        }
        long j = this.mNativePtr;
        if (j != 0) {
            int nativeGetStatusCode = nativeGetStatusCode(j);
            this.mStatusCode = nativeGetStatusCode;
            return nativeGetStatusCode;
        }
        return this.mStatusCode;
    }

    public String getStatusMsg() {
        if (this.mDirty) {
            return this.mStatusMsg;
        }
        String str = this.mStatusMsg;
        if (str != null) {
            return str;
        }
        long j = this.mNativePtr;
        if (j != 0) {
            String nativeGetStatusMsg = nativeGetStatusMsg(j);
            this.mStatusMsg = nativeGetStatusMsg;
            return nativeGetStatusMsg;
        }
        return null;
    }

    public String getUrl() {
        String str = this.mUrl;
        if (str != null) {
            return str;
        }
        long j = this.mNativePtr;
        if (j != 0) {
            String nativeGetUrl = nativeGetUrl(j);
            this.mUrl = nativeGetUrl;
            return nativeGetUrl;
        }
        return null;
    }

    public void setStatusCodeAndMsg(int i2, String str) {
        this.mDirty = true;
        this.mStatusCode = i2;
        this.mStatusMsg = str;
        long j = this.mNativePtr;
        if (j != 0) {
            nativeSetStatusCode(j, i2);
            nativeSetStatusMsg(this.mNativePtr, this.mStatusMsg);
        }
    }

    public String toString() {
        return "NetRequestResult{mDirty=" + this.mDirty + ", mId=" + this.mId + ", mUrl='" + this.mUrl + "', mStatusCode=" + this.mStatusCode + ", mStatusMsg='" + this.mStatusMsg + "', mFromType=" + ((int) this.mFromType) + ", mNativePtr=" + this.mNativePtr + ", mCreatedTime=" + this.mCreatedTime + ", mSwanExtra=" + this.mSwanExtra + ", mNetInfo=" + this.mNetInfo + '}';
    }
}
