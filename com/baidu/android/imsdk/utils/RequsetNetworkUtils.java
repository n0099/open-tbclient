package com.baidu.android.imsdk.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.manager.DefaultConnectivityMonitorFactory;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
/* loaded from: classes4.dex */
public class RequsetNetworkUtils extends BaseUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "RequsetNetworkUtils";
    public static ConnectivityManager mConnManager;
    public static TelephonyManager mTelephonyManager;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(374902354, "Lcom/baidu/android/imsdk/utils/RequsetNetworkUtils;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(374902354, "Lcom/baidu/android/imsdk/utils/RequsetNetworkUtils;");
        }
    }

    public RequsetNetworkUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            if (context.checkCallingOrSelfPermission(DefaultConnectivityMonitorFactory.NETWORK_PERMISSION) == 0 && mConnManager == null) {
                mConnManager = (ConnectivityManager) context.getSystemService("connectivity");
            }
            return mConnManager;
        }
        return (ConnectivityManager) invokeL.objValue;
    }

    public static String getHostUrl(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (context == null) {
                LogUtils.e("RequsetNetworkUtils", "context is null");
                return null;
            }
            int readIntData = Utility.readIntData(context, Constants.KEY_ENV, 0);
            if (readIntData != 0) {
                if (readIntData != 1) {
                    if (readIntData != 2) {
                        if (readIntData != 3) {
                            return null;
                        }
                        return Constants.URL_HTTP_BOX;
                    }
                    return Constants.URL_HTTP_QA;
                }
                return "http://rd-im-server.bcc-szth.baidu.com:8080/";
            }
            return "https://pim.baidu.com/";
        }
        return (String) invokeL.objValue;
    }

    public static String getMobileIp(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
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
            } catch (Exception e2) {
                LogUtils.d("RequsetNetworkUtils", e2.getMessage());
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static String getMobileType(Context context) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context)) == null) {
            if (getTelephonyManager(context) != null) {
                int networkType = getTelephonyManager(context).getNetworkType();
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

    public static String getNetInfo(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, context)) == null) {
            if (isNetworkAvailable(context)) {
                if (isWifiConnected(context)) {
                    return "wifi|" + getWifiIp(context);
                }
                return getOperatorName(context) + "|" + getMobileIp(context) + "|" + getMobileType(context);
            }
            return "nonNet";
        }
        return (String) invokeL.objValue;
    }

    public static NetworkInfo getNetWorkInfo(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            NetworkInfo networkInfo = null;
            try {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext == null) {
                    LogUtils.d("RequsetNetworkUtils", "context is null !!!");
                }
                ConnectivityManager connectivityManager = getConnectivityManager(applicationContext);
                if (connectivityManager != null) {
                    networkInfo = connectivityManager.getActiveNetworkInfo();
                    if (networkInfo == null) {
                        LogUtils.e("RequsetNetworkUtils", "networkInfo is null !!!");
                    }
                } else {
                    LogUtils.e("RequsetNetworkUtils", "connManager is null !!!");
                }
            } catch (Exception e2) {
                LogUtils.e("RequsetNetworkUtils", "exp: " + e2.getMessage());
            }
            return networkInfo;
        }
        return (NetworkInfo) invokeL.objValue;
    }

    public static String getOperatorName(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) ? getTelephonyManager(context) != null ? getTelephonyManager(context).getSimOperatorName() : "noPermission" : (String) invokeL.objValue;
    }

    public static TelephonyManager getTelephonyManager(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            if (context == null) {
                return mTelephonyManager;
            }
            if (context.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") == 0 && mTelephonyManager == null) {
                mTelephonyManager = (TelephonyManager) context.getSystemService("phone");
            }
            return mTelephonyManager;
        }
        return (TelephonyManager) invokeL.objValue;
    }

    public static String getWifiIp(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
            try {
                if (context.checkCallingOrSelfPermission("android.permission.ACCESS_WIFI_STATE") == 0) {
                    int ipAddress = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getIpAddress();
                    return String.format("%d.%d.%d.%d", Integer.valueOf(ipAddress & 255), Integer.valueOf((ipAddress >> 8) & 255), Integer.valueOf((ipAddress >> 16) & 255), Integer.valueOf((ipAddress >> 24) & 255));
                }
                return "nonWifiIp";
            } catch (Exception unused) {
                return "nonWifiIp";
            }
        }
        return (String) invokeL.objValue;
    }

    public static boolean isConnected(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        }
        return invokeL.booleanValue;
    }

    public static boolean isNetworkAvailable(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, context)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, context)) == null) {
            NetworkInfo netWorkInfo = getNetWorkInfo(context);
            return netWorkInfo != null && netWorkInfo.getType() == 1;
        }
        return invokeL.booleanValue;
    }
}
