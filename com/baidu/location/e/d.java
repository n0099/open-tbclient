package com.baidu.location.e;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes2.dex */
public class d {
    public static /* synthetic */ Interceptable $ic = null;
    public static String a = "https://loc.map.baidu.com/sdk_ep.php";
    public static String b = "https://loc.map.baidu.com/tcu.php";
    public static String c = "https://loc.map.baidu.com/sdk.php";
    public static String d = "https://loc.map.baidu.com/cfgs/loc/commcfgs";
    public static String e = "https://client.map.baidu.com/phpui2/?";
    public static String f = "https://loc.map.baidu.com/cfgs/indoorloc/indoorroadnet";
    public static String g = "https://loc.map.baidu.com/check_indoor_data_update";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1037812749, "Lcom/baidu/location/e/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1037812749, "Lcom/baidu/location/e/d;");
        }
    }
}
