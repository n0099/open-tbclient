package com.alipay.sdk.packet;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public a() {
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

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            String[] split = str.split("&");
            if (split.length == 0) {
                return "";
            }
            String str2 = null;
            String str3 = null;
            String str4 = null;
            String str5 = null;
            for (String str6 : split) {
                if (TextUtils.isEmpty(str2)) {
                    str2 = e(str6);
                }
                if (TextUtils.isEmpty(str3)) {
                    str3 = d(str6);
                }
                if (TextUtils.isEmpty(str4)) {
                    str4 = f(str6);
                }
                if (TextUtils.isEmpty(str5)) {
                    str5 = c(str6);
                }
            }
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(str2)) {
                sb.append("biz_type=" + str2 + ";");
            }
            if (!TextUtils.isEmpty(str3)) {
                sb.append("biz_no=" + str3 + ";");
            }
            if (!TextUtils.isEmpty(str4)) {
                sb.append("trade_no=" + str4 + ";");
            }
            if (!TextUtils.isEmpty(str5)) {
                sb.append("app_userid=" + str5 + ";");
            }
            String sb2 = sb.toString();
            return sb2.endsWith(";") ? sb2.substring(0, sb2.length() - 1) : sb2;
        }
        return (String) invokeL.objValue;
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            String[] split = str.split("=");
            if (split.length > 1) {
                String str2 = split[1];
                return str2.contains("\"") ? str2.replaceAll("\"", "") : str2;
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (str.contains("app_userid")) {
                return b(str);
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static String d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (str.contains("biz_no")) {
                return b(str);
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static String e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            if (str.contains("biz_type")) {
                return b(str);
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static String f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            if (!str.contains(com.alipay.sdk.app.statistic.b.H0) || str.startsWith(com.alipay.sdk.app.statistic.b.G0)) {
                return null;
            }
            return b(str);
        }
        return (String) invokeL.objValue;
    }
}
