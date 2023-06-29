package com.baidu.android.imsdk.upload.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.p0.h;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
/* loaded from: classes.dex */
public class RequsetNetworkUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int NETWORK_TYPE_LTE_CA = 19;
    public static final String TAG = "RequsetNetworkUtils";
    public static ConnectivityManager mConnManager;
    public static TelephonyManager mTelephonyManager;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(10568114, "Lcom/baidu/android/imsdk/upload/utils/RequsetNetworkUtils;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(10568114, "Lcom/baidu/android/imsdk/upload/utils/RequsetNetworkUtils;");
        }
    }

    public RequsetNetworkUtils() {
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

    public static ConnectivityManager getConnectivityManager(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (context == null) {
                return mConnManager;
            }
            if (context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0 && mConnManager == null) {
                mConnManager = (ConnectivityManager) context.getSystemService("connectivity");
            }
            return mConnManager;
        }
        return (ConnectivityManager) invokeL.objValue;
    }

    public static TelephonyManager getTelephonyManager(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            if (context == null) {
                return mTelephonyManager;
            }
            if (context.checkCallingOrSelfPermission(h.c) == 0 && mTelephonyManager == null) {
                mTelephonyManager = (TelephonyManager) context.getSystemService("phone");
            }
            return mTelephonyManager;
        }
        return (TelephonyManager) invokeL.objValue;
    }

    public static String getMobileIp(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
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
            } catch (Exception e) {
                Log.d("RequsetNetworkUtils", "getMobileIp exception :" + e.getMessage());
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    @SuppressLint({"SwitchIntDef"})
    public static String getMobileType(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            TelephonyManager telephonyManager = getTelephonyManager(context);
            if (telephonyManager != null) {
                switch (telephonyManager.getNetworkType()) {
                    case 0:
                    default:
                        return "unknown";
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                    case 16:
                        return "2G";
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
                        return "3G";
                    case 13:
                    case 18:
                    case 19:
                        return "4G";
                }
            }
            return "unknown";
        }
        return (String) invokeL.objValue;
    }

    public static NetworkInfo getNetWorkInfo(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            NetworkInfo networkInfo = null;
            try {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext == null) {
                    Log.d("RequsetNetworkUtils", "context is null !!!");
                }
                ConnectivityManager connectivityManager = getConnectivityManager(applicationContext);
                if (connectivityManager != null) {
                    networkInfo = connectivityManager.getActiveNetworkInfo();
                    if (networkInfo == null) {
                        Log.e("RequsetNetworkUtils", "networkInfo is null !!!");
                    }
                } else {
                    Log.e("RequsetNetworkUtils", "connManager is null !!!");
                }
            } catch (Exception e) {
                Log.e("RequsetNetworkUtils", "exp: " + e.getMessage());
            }
            return networkInfo;
        }
        return (NetworkInfo) invokeL.objValue;
    }

    public static String getOperatorName(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            if (getTelephonyManager(context) != null) {
                return getTelephonyManager(context).getSimOperatorName();
            }
            return "noPermission";
        }
        return (String) invokeL.objValue;
    }

    public static boolean isConnected(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            try {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo == null) {
                    return false;
                }
                if (!activeNetworkInfo.isConnected()) {
                    return false;
                }
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean isNetworkAvailable(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            NetworkInfo netWorkInfo = getNetWorkInfo(context);
            if (netWorkInfo != null) {
                return netWorkInfo.isConnectedOrConnecting();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean isWifiConnected(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
            NetworkInfo netWorkInfo = getNetWorkInfo(context);
            if (netWorkInfo != null && netWorkInfo.getType() == 1) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
