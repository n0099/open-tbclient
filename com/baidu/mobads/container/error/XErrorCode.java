package com.baidu.mobads.container.error;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.RemoteXAdLogger;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes2.dex */
public class XErrorCode {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ERROR_CODE = "error_code";
    public static final String ERROR_MESSAGE = "error_message";
    public transient /* synthetic */ FieldHolder $fh;
    public final RemoteXAdLogger mAdLogger;

    public XErrorCode() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mAdLogger = RemoteXAdLogger.getInstance();
    }

    public String genCompleteErrorMessage(XAdErrorCode xAdErrorCode, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, xAdErrorCode, str)) == null) {
            if (xAdErrorCode == null) {
                return "";
            }
            return genCompleteErrorMessage(xAdErrorCode.getCode() + "", xAdErrorCode.getMessage(), str);
        }
        return (String) invokeLL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x002a -> B:13:0x002a). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String getMessage(Map<String, Object> map) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, map)) != null) {
            return (String) invokeL.objValue;
        }
        if (map != null) {
            try {
                if (map.containsKey("msg")) {
                    str = genCompleteErrorMessage((XAdErrorCode) map.get("msg"), "");
                } else if (map.containsKey("error_message")) {
                    str = (String) map.get("error_message");
                }
            } catch (Exception unused) {
            }
            return str != null ? "" : str;
        }
        str = "";
        if (str != null) {
        }
    }

    public void printErrorMessage(XAdErrorCode xAdErrorCode, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, xAdErrorCode, str) == null) {
            this.mAdLogger.e(genCompleteErrorMessage(xAdErrorCode, str));
        }
    }

    public String genCompleteErrorMessage(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3)) == null) {
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(str)) {
                sb.append("ErrorCode: [");
                sb.append(str);
                sb.append("];");
            }
            if (!TextUtils.isEmpty(str2)) {
                sb.append("ErrorDesc: [");
                sb.append(str2);
                sb.append("];");
            }
            if (!TextUtils.isEmpty(str3)) {
                sb.append(" Extra: [");
                sb.append(str3);
                sb.append("];");
            }
            return sb.toString();
        }
        return (String) invokeLLL.objValue;
    }

    public void printErrorMessage(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, str, str2, str3) == null) {
            this.mAdLogger.e(genCompleteErrorMessage(str, str2, str3));
        }
    }
}
