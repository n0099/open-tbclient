package com.baidu.android.pushservice.j;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.pushservice.i.a.b;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
/* loaded from: classes4.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static ConnectivityManager f37639a;

    /* renamed from: b  reason: collision with root package name */
    public static TelephonyManager f37640b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-676870053, "Lcom/baidu/android/pushservice/j/g;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-676870053, "Lcom/baidu/android/pushservice/j/g;");
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
                ConnectivityManager j2 = j(context.getApplicationContext());
                if (j2 != null) {
                    return j2.getActiveNetworkInfo();
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
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) ? k(context) != null ? k(context).getSimOperatorName() : "noPermission" : (String) invokeL.objValue;
    }

    public static String e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context)) == null) {
            if (context.checkCallingOrSelfPermission("android.permission.ACCESS_WIFI_STATE") == 0) {
                int ipAddress = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getIpAddress();
                return String.format("%d.%d.%d.%d", Integer.valueOf(ipAddress & 255), Integer.valueOf((ipAddress >> 8) & 255), Integer.valueOf((ipAddress >> 16) & 255), Integer.valueOf((ipAddress >> 24) & 255));
            }
            return "nonWifiIp";
        }
        return (String) invokeL.objValue;
    }

    public static String f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, context)) == null) {
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

    public static String g(Context context) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            if (k(context) != null) {
                int networkType = k(context).getNetworkType();
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

    public static String h(Context context) {
        InterceptResult invokeL;
        StringBuilder sb;
        String g2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            if (a(context)) {
                if (b(context)) {
                    sb = new StringBuilder();
                    sb.append("wifi|");
                    g2 = e(context);
                } else {
                    sb = new StringBuilder();
                    sb.append(d(context));
                    sb.append("|");
                    sb.append(f(context));
                    sb.append("|");
                    g2 = g(context);
                }
                sb.append(g2);
                return sb.toString();
            }
            return "nonNet";
        }
        return (String) invokeL.objValue;
    }

    public static String i(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
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

    public static ConnectivityManager j(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
            if (context == null) {
                return f37639a;
            }
            if (f37639a == null) {
                f37639a = (ConnectivityManager) context.getSystemService("connectivity");
            }
            return f37639a;
        }
        return (ConnectivityManager) invokeL.objValue;
    }

    public static TelephonyManager k(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) {
            if (context.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") == 0) {
                if (context == null) {
                    return f37640b;
                }
                if (f37640b == null) {
                    f37640b = (TelephonyManager) context.getSystemService("phone");
                }
            }
            return f37640b;
        }
        return (TelephonyManager) invokeL.objValue;
    }
}
