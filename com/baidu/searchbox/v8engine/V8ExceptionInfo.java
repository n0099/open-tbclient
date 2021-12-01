package com.baidu.searchbox.v8engine;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes9.dex */
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return "V8ExceptionInfo{exceptionTime=" + this.exceptionTime + ", exceptionMsg='" + this.exceptionMsg + ExtendedMessageFormat.QUOTE + ", exceptionTrace='" + this.exceptionTrace + ExtendedMessageFormat.QUOTE + ", exceptionType='" + this.exceptionType + ExtendedMessageFormat.QUOTE + ", filePath='" + this.filePath + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }

    public V8ExceptionInfo(long j2, String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j2), str, str2, str3, str4};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.exceptionTime = j2;
        this.exceptionMsg = str;
        this.exceptionTrace = str2;
        this.exceptionType = str3;
        this.filePath = str4;
    }

    public void reset(long j2, String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j2), str, str2, str3, str4}) == null) {
            this.exceptionTime = j2;
            this.exceptionMsg = str;
            this.exceptionTrace = str2;
            this.exceptionType = str3;
            this.filePath = str4;
        }
    }
}
