package com.baidu.searchbox.v8engine;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class V8ExceptionInfo {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String V8_EXCEPTION_ERROR = "Error";
    public static final String V8_EXCEPTION_RANGE_ERROR = "RangeError";
    public static final String V8_EXCEPTION_REFERENCE_ERROR = "ReferenceError";
    public static final String V8_EXCEPTION_SYNTAX_ERROR = "SyntaxError";
    public static final String V8_EXCEPTION_TYPE_ERROR = "TypeError";
    public transient /* synthetic */ FieldHolder $fh;
    public String exceptionMsg;
    public long exceptionTime;
    public String exceptionTrace;
    public String exceptionType;
    public String filePath;

    public V8ExceptionInfo() {
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

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            reset(0L, "", "", "", "");
        }
    }

    public V8ExceptionInfo(long j, String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j), str, str2, str3, str4};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.exceptionTime = j;
        this.exceptionMsg = str;
        this.exceptionTrace = str2;
        this.exceptionType = str3;
        this.filePath = str4;
    }

    public void reset(long j, String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), str, str2, str3, str4}) == null) {
            this.exceptionTime = j;
            this.exceptionMsg = str;
            this.exceptionTrace = str2;
            this.exceptionType = str3;
            this.filePath = str4;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return "V8ExceptionInfo{exceptionTime=" + this.exceptionTime + ", exceptionMsg='" + this.exceptionMsg + "', exceptionTrace='" + this.exceptionTrace + "', exceptionType='" + this.exceptionType + "', filePath='" + this.filePath + "'}";
        }
        return (String) invokeV.objValue;
    }
}
