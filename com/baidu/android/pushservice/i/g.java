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
import com.kuaishou.weapon.un.s;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
/* loaded from: classes9.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public static ConnectivityManager a;

    /* renamed from: b  reason: collision with root package name */
    public static TelephonyManager f33318b;
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
            NetworkInfo c2 = c(context);
            if (c2 != null) {
                return c2.isConnectedOrConnecting();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            NetworkInfo c2 = c(context);
            return c2 != null && c2.getType() == 1;
        }
        return invokeL.booleanValue;
    }

    public static NetworkInfo c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            try {
                ConnectivityManager i2 = i(context.getApplicationContext());
                if (i2 != null) {
                    return i2.getActiveNetworkInfo();
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
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) ? j(context) != null ? j(context).getSimOperatorName() : "noPermission" : (String) invokeL.objValue;
    }

    public static String e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            String str = "nonMobileIp";
            try {
                Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
                while (networkInterfaces.hasMoreElements()) {
                    Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                    while (inetAddresses.hasMoreElements()) {
                        InetAddress nextElement = inetAddresses.nextElement();
                        if (!nextElement.isLoopbackAddress() && (nextElement instanceof Inet4Address)) {
                            str = nextElement.getHostAddress().toString();
                        }
                    }
                }
            } catch (Exception unused) {
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static String f(Context context) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            if (j(context) != null) {
                int networkType = j(context).getNetworkType();
                switch (networkType) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                    case 16:
                        str = "2G";
                        break;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                    case 17:
                        str = "3G";
                        break;
                    case 13:
                    case 18:
                        str = "4G";
                        break;
                    default:
                        str = "";
                        break;
                }
                return str + "-" + networkType;
            }
            return "unKnow";
        }
        return (String) invokeL.objValue;
    }

    public static String g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            if (a(context)) {
                if (b(context)) {
                    return "wifi";
                }
                return d(context) + "|" + e(context) + "|" + f(context);
            }
            return "nonNet";
        }
        return (String) invokeL.objValue;
    }

    public static String h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            if (a(context)) {
                NetworkInfo c2 = c(context);
                switch (c2 != null ? c2.getType() : -1) {
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

    public static ConnectivityManager i(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
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

    public static TelephonyManager j(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
            if (context.checkCallingOrSelfPermission(s.f57419c) == 0) {
                if (context == null) {
                    return f33318b;
                }
                if (f33318b == null) {
                    f33318b = (TelephonyManager) context.getSystemService("phone");
                }
            }
            return f33318b;
        }
        return (TelephonyManager) invokeL.objValue;
    }
}
