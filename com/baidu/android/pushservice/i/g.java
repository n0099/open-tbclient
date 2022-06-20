package com.baidu.android.pushservice.i;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.pushservice.h.a.b;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public static ConnectivityManager a;
    public static TelephonyManager b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-676899844, "Lcom/baidu/android/pushservice/i/g;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-676899844, "Lcom/baidu/android/pushservice/i/g;");
        }
    }

    public static boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            NetworkInfo c = c(context);
            if (c != null) {
                return c.isConnectedOrConnecting();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            NetworkInfo c = c(context);
            return c != null && c.getType() == 1;
        }
        return invokeL.booleanValue;
    }

    public static NetworkInfo c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            try {
                ConnectivityManager e = e(context.getApplicationContext());
                if (e != null) {
                    return e.getActiveNetworkInfo();
                }
                return null;
            } catch (Exception e2) {
                new b.c(context).a(Log.getStackTraceString(e2)).a();
                return null;
            }
        }
        return (NetworkInfo) invokeL.objValue;
    }

    public static String d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            if (a(context)) {
                NetworkInfo c = c(context);
                switch (c != null ? c.getType() : -1) {
                    case 0:
                        return "mobile";
                    case 1:
                        return "wifi";
                    case 2:
                        return "mobile_mms";
                    case 3:
                        return "mobile_supl";
                    case 4:
                        return "mobile_dun";
                    case 5:
                        return "mobile_hipri";
                    case 6:
                        return "wimax";
                    default:
                        return "connectionless";
                }
            }
            return "connectionless";
        }
        return (String) invokeL.objValue;
    }

    public static ConnectivityManager e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            if (context == null) {
                return a;
            }
            if (a == null) {
                a = (ConnectivityManager) context.getSystemService("connectivity");
            }
            return a;
        }
        return (ConnectivityManager) invokeL.objValue;
    }
}
