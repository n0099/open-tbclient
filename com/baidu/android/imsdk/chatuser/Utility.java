package com.baidu.android.imsdk.chatuser;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class Utility {
    public static /* synthetic */ Interceptable $ic;
    public static final String[] ZXS_LIST;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1828402124, "Lcom/baidu/android/imsdk/chatuser/Utility;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1828402124, "Lcom/baidu/android/imsdk/chatuser/Utility;");
                return;
            }
        }
        ZXS_LIST = new String[]{"北京市", "天津市", "上海市", "重庆市"};
    }

    public Utility() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static String createAnonyMousUserName(IpInfo ipInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, ipInfo)) == null) {
            if (ipInfo == null) {
                return "未知地区客户";
            }
            String str = new String();
            if (!TextUtils.isEmpty(ipInfo.getProv())) {
                if (isZhiXiaShi(ipInfo.getProv())) {
                    return ipInfo.getProv() + "客户";
                }
                str = str + ipInfo.getProv();
            }
            if (!TextUtils.isEmpty(ipInfo.getCity())) {
                str = str + ipInfo.getCity();
            }
            if (TextUtils.isEmpty(str)) {
                str = ipInfo.getCountry();
            }
            if (TextUtils.isEmpty(str)) {
                str = "未知地区";
            }
            return str + "客户";
        }
        return (String) invokeL.objValue;
    }

    public static boolean isZhiXiaShi(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            for (String str2 : ZXS_LIST) {
                if (str2.startsWith(str)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
