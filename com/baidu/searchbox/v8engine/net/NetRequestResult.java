package com.baidu.searchbox.v8engine.net;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.NotProguard;
import com.baidu.searchbox.v8engine.net.NetInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
@NotProguard
/* loaded from: classes9.dex */
public class NetRequestResult {
    public static /* synthetic */ Interceptable $ic = null;
    public static final byte NET_REQUEST_RESULT_FROM_TYPE_REQUEST = 0;
    public static final byte NET_REQUEST_RESULT_FROM_TYPE_RESPONSE = 1;
    public static final byte NET_REQUEST_RESULT_FROM_TYPE_UNKNOWN = 3;
    public static final byte NET_REQUEST_RESULT_FROM_TYPE_V8_TASK = 2;
    public static final int STATUS_CODE_ABORT_ACTIVELY_TRIGGER_START = 11;
    public static final int STATUS_CODE_ABORT_REQUEST_TIMEOUT = 9;
    public static final int STATUS_CODE_EXECUTE_FAILED_V8_TASK = 8;
    public static final int STATUS_CODE_EXECUTE_SUCCEEDED_V8_TASK = 7;
    public static final int STATUS_CODE_INTERCEPT_NET_REQUEST = -301;
    public static final int STATUS_CODE_INTERCEPT_NET_REQUEST_FINISH = 14;
    public static final int STATUS_CODE_INTERPRET_NET_REQUEST_PARAM_FINISH = 4;
    public static final int STATUS_CODE_INTERPRET_NET_REQUEST_PARAM_START = 3;
    public static final int STATUS_CODE_NA_RECEIVE_NET_REQUEST_RAW_OBJECT = 12;
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
    public static final int STATUS_CODE_READY_TO_EXECUTE_V8_TASK = 15;
    public static final int STATUS_CODE_READY_TO_ISSUE_NET_REQUEST = 13;
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
    public transient /* synthetic */ FieldHolder $fh;
    public long mCreatedTime;
    public boolean mDirty;
    public byte mFromType;
    public long mId;
    public long mNativePtr;
    public NetInfo mNetInfo;
    public int mStatusCode;
    public String mStatusMsg;
    public NetInfo.SwanExtra mSwanExtra;
    public String mUrl;

    public NetRequestResult(long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j2), Long.valueOf(j3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mSwanExtra = new NetInfo.SwanExtra();
        this.mId = j2;
        this.mNativePtr = j3;
    }

    private native int nativeGetFromType(long j2);

    private native String nativeGetNetInfo(long j2);

    private native int nativeGetStatusCode(long j2);

    private native String nativeGetStatusMsg(long j2);

    private native String nativeGetUrl(long j2);

    private native void nativeSetStatusCode(long j2, int i2);

    private native void nativeSetStatusMsg(long j2, String str);

    private void setConnectTime(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65544, this, j2) == null) {
            this.mSwanExtra.mTiming.mConnectTime = j2;
        }
    }

    public long getCreatedTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mCreatedTime : invokeV.longValue;
    }

    public int getFromType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            long j2 = this.mNativePtr;
            if (j2 != 0) {
                return nativeGetFromType(j2);
            }
            return this.mFromType;
        }
        return invokeV.intValue;
    }

    public long getId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mId : invokeV.longValue;
    }

    public NetInfo getNetInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            NetInfo netInfo = this.mNetInfo;
            if (netInfo != null) {
                return netInfo;
            }
            long j2 = this.mNativePtr;
            if (j2 != 0) {
                NetInfo netInfo2 = new NetInfo(nativeGetNetInfo(j2), this.mSwanExtra);
                this.mNetInfo = netInfo2;
                return netInfo2;
            }
            return null;
        }
        return (NetInfo) invokeV.objValue;
    }

    public int getStatusCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.mDirty) {
                return this.mStatusCode;
            }
            long j2 = this.mNativePtr;
            if (j2 != 0) {
                int nativeGetStatusCode = nativeGetStatusCode(j2);
                this.mStatusCode = nativeGetStatusCode;
                return nativeGetStatusCode;
            }
            return this.mStatusCode;
        }
        return invokeV.intValue;
    }

    public String getStatusMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.mDirty) {
                return this.mStatusMsg;
            }
            String str = this.mStatusMsg;
            if (str != null) {
                return str;
            }
            long j2 = this.mNativePtr;
            if (j2 != 0) {
                String nativeGetStatusMsg = nativeGetStatusMsg(j2);
                this.mStatusMsg = nativeGetStatusMsg;
                return nativeGetStatusMsg;
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            String str = this.mUrl;
            if (str != null) {
                return str;
            }
            long j2 = this.mNativePtr;
            if (j2 != 0) {
                String nativeGetUrl = nativeGetUrl(j2);
                this.mUrl = nativeGetUrl;
                return nativeGetUrl;
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public void setStatusCodeAndMsg(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048583, this, i2, str) == null) {
            this.mDirty = true;
            this.mStatusCode = i2;
            this.mStatusMsg = str;
            long j2 = this.mNativePtr;
            if (j2 != 0) {
                nativeSetStatusCode(j2, i2);
                nativeSetStatusMsg(this.mNativePtr, this.mStatusMsg);
            }
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return "NetRequestResult{mDirty=" + this.mDirty + ", mId=" + this.mId + ", mUrl='" + this.mUrl + ExtendedMessageFormat.QUOTE + ", mStatusCode=" + this.mStatusCode + ", mStatusMsg='" + this.mStatusMsg + ExtendedMessageFormat.QUOTE + ", mFromType=" + ((int) this.mFromType) + ", mNativePtr=" + this.mNativePtr + ", mCreatedTime=" + this.mCreatedTime + ", mSwanExtra=" + this.mSwanExtra + ", mNetInfo=" + this.mNetInfo + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
