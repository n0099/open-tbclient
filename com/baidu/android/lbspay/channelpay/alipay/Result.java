package com.baidu.android.lbspay.channelpay.alipay;

import com.alipay.sdk.util.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class Result {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String RESULT_CANCLE = "6001";
    public static final String RESULT_ERROR = "9999";
    public static final String RESULT_FAILED = "4000";
    public static final String RESULT_NETWROK_ERROR = "6002";
    public static final String RESULT_PAYING = "8000";
    public static final String RESULT_SUCCESS = "9000";
    public transient /* synthetic */ FieldHolder $fh;
    public String memo;
    public String result;
    public String resultStatus;

    public Result(String str) {
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        try {
            for (String str2 : str.split(";")) {
                if (str2.startsWith(l.f2024a)) {
                    this.resultStatus = gatValue(str2, l.f2024a);
                }
                if (str2.startsWith("result")) {
                    this.result = gatValue(str2, "result");
                }
                if (str2.startsWith(l.f2025b)) {
                    this.memo = gatValue(str2, l.f2025b);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public String gatValue(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            String str3 = str2 + "={";
            return str.substring(str.indexOf(str3) + str3.length(), str.indexOf("}"));
        }
        return (String) invokeLL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "resultStatus : " + this.resultStatus + ", result = " + this.result + ", memo = " + this.memo;
        }
        return (String) invokeV.objValue;
    }
}
