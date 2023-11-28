package com.baidu.android.pushservice.a0;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public static ConnectivityManager a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(483530546, "Lcom/baidu/android/pushservice/a0/g;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(483530546, "Lcom/baidu/android/pushservice/a0/g;");
        }
    }

    public static ConnectivityManager a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
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

    public static NetworkInfo b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            try {
                ConnectivityManager a2 = a(context.getApplicationContext());
                if (a2 != null) {
                    return a2.getActiveNetworkInfo();
                }
            } catch (Exception unused) {
            }
            return null;
        }
        return (NetworkInfo) invokeL.objValue;
    }

    public static String c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (d(context)) {
                NetworkInfo b = b(context);
                switch (b != null ? b.getType() : -1) {
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

    public static boolean d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            NetworkInfo b = b(context);
            if (b != null) {
                return b.isConnectedOrConnecting();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            NetworkInfo b = b(context);
            return b != null && b.getType() == 1;
        }
        return invokeL.booleanValue;
    }
}
