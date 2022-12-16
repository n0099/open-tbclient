package com.alipay.sdk.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.util.ApiReplaceUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String b = "00:00:00:00:00:00";
    public static a c;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1255002791, "Lcom/alipay/sdk/util/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1255002791, "Lcom/alipay/sdk/util/a;");
        }
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? Config.NULL_DEVICE_ID : (String) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? Config.NULL_DEVICE_ID : (String) invokeV.objValue;
    }

    public a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        try {
            try {
                String macAddress = ApiReplaceUtil.getMacAddress(((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo());
                this.a = macAddress;
                if (!TextUtils.isEmpty(macAddress)) {
                    return;
                }
            } catch (Exception e) {
                c.a(e);
                if (!TextUtils.isEmpty(this.a)) {
                    return;
                }
            }
            this.a = b;
        } catch (Throwable th) {
            if (TextUtils.isEmpty(this.a)) {
                this.a = b;
            }
            throw th;
        }
    }

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            return b(context).a().substring(0, 8);
        }
        return (String) invokeL.objValue;
    }

    public static a b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (c == null) {
                c = new a(context);
            }
            return c;
        }
        return (a) invokeL.objValue;
    }

    public static String c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            if (context == null) {
                return "";
            }
            try {
                return context.getResources().getConfiguration().locale.toString();
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static e d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            try {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.getType() == 0) {
                    return e.a(activeNetworkInfo.getSubtype());
                }
                if (activeNetworkInfo != null && activeNetworkInfo.getType() == 1) {
                    return e.c;
                }
                return e.r;
            } catch (Exception unused) {
                return e.r;
            }
        }
        return (e) invokeL.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            String str = b() + "|";
            String c2 = c();
            if (TextUtils.isEmpty(c2)) {
                return str + Config.NULL_DEVICE_ID;
            }
            return str + c2;
        }
        return (String) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.a;
        }
        return (String) invokeV.objValue;
    }
}
