package com.baidu.apollon.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.baidu.apollon.ApollonConstants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
/* loaded from: classes.dex */
public final class NetworkUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int NETWORK_2G = 2;
    public static final int NETWORK_3G = 3;
    public static final int NETWORK_4G = 4;
    public static final int NETWORK_TYPE_GSM = 16;
    public static final int NETWORK_TYPE_IWLAN = 18;
    public static final int NETWORK_TYPE_TD_SCDMA = 17;
    public static final int NETWORK_UNKNOW = 0;
    public static final int NETWORK_WIFI = 1;

    /* renamed from: a  reason: collision with root package name */
    public static final String f4079a = "NetworkUtils";
    public transient /* synthetic */ FieldHolder $fh;

    public NetworkUtils() {
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

    public static String getLocalIpAddress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            try {
                Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
                while (networkInterfaces.hasMoreElements()) {
                    Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                    while (inetAddresses.hasMoreElements()) {
                        InetAddress nextElement = inetAddresses.nextElement();
                        if (!nextElement.isLoopbackAddress()) {
                            return nextElement.getHostAddress().toString();
                        }
                    }
                }
                return null;
            } catch (SocketException e2) {
                LogUtil.e("", "NetworkStatus", e2);
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String getLocalMacAddress(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) ? ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getMacAddress() : (String) invokeL.objValue;
    }

    public static String getNetName(Context context) {
        InterceptResult invokeL;
        NetworkInfo activeNetworkInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            return (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) ? "" : activeNetworkInfo.getType() == 1 ? "wifi" : (activeNetworkInfo.getTypeName() == null || activeNetworkInfo.getExtraInfo() == null) ? "" : activeNetworkInfo.getExtraInfo().toLowerCase();
        }
        return (String) invokeL.objValue;
    }

    public static int getNetworkType(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, context)) == null) {
            if (isWifiNetworkAvailable(context)) {
                return 1;
            }
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                switch (telephonyManager.getNetworkType()) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                    case 16:
                        return 2;
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
                        return 3;
                    case 13:
                    case 18:
                        return 4;
                    default:
                        return 0;
                }
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static boolean isNetworkAvailable(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context)) == null) {
            if (context == null) {
                if (ApollonConstants.DEBUG) {
                    LogUtil.d("NetworkUtils", "context is null!");
                }
                return false;
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                if (ApollonConstants.DEBUG) {
                    LogUtil.d("NetworkUtils", "couldn't get connectivity manager");
                }
                return false;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                if (ApollonConstants.DEBUG) {
                    LogUtil.d("NetworkUtils", "network is available");
                    return true;
                }
                return true;
            }
            if (ApollonConstants.DEBUG) {
                LogUtil.d("NetworkUtils", "network is not available");
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean isNetworkConnected(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, context)) == null) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                if (ApollonConstants.DEBUG) {
                    Log.d("NetworkUtils", "couldn't get connectivity manager");
                }
                return false;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                if (ApollonConstants.DEBUG) {
                    Log.d("NetworkUtils", "network is available");
                    return true;
                }
                return true;
            }
            if (ApollonConstants.DEBUG) {
                Log.d("NetworkUtils", "network is not available");
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean isNetworkRoaming(Context context) {
        InterceptResult invokeL;
        TelephonyManager telephonyManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                if (ApollonConstants.DEBUG) {
                    LogUtil.v("NetworkUtils", "couldn't get connectivity manager");
                }
                return false;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null || activeNetworkInfo.getType() != 0 || (telephonyManager = (TelephonyManager) context.getSystemService("phone")) == null || !telephonyManager.isNetworkRoaming()) {
                return false;
            }
            if (ApollonConstants.DEBUG) {
                LogUtil.v("NetworkUtils", "network is roaming");
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean isWifiNetworkAvailable(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                if (ApollonConstants.DEBUG) {
                    LogUtil.d("NetworkUtils", "couldn't get connectivity manager");
                }
                return false;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected() && activeNetworkInfo.getType() == 1;
        }
        return invokeL.booleanValue;
    }
}
