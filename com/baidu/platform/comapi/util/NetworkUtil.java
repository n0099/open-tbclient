package com.baidu.platform.comapi.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class NetworkUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int NETYPE_2G = 2;
    public static final int NETYPE_3G = 3;
    public static final int NETYPE_4G = 4;
    public static final int NETYPE_4G_UNKNOWN = 10;
    public static final int NETYPE_MOBILE_3G = 8;
    public static final int NETYPE_MOBILE_UNICOM_2G = 6;
    public static final int NETYPE_NOCON = -1;
    public static final int NETYPE_TELECOM_2G = 5;
    public static final int NETYPE_TELECOM_3G = 7;
    public static final int NETYPE_UNICOM_3G = 9;
    public static final int NETYPE_UNKNOWN = 0;
    public static final int NETYPE_WIFI = 1;
    public static String mProxyHost = "";
    public static int mProxyPort;
    public static boolean mUseProxy;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-784934608, "Lcom/baidu/platform/comapi/util/NetworkUtil;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-784934608, "Lcom/baidu/platform/comapi/util/NetworkUtil;");
        }
    }

    public static boolean initConnectState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public static void updateNetworkProxy(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, context) == null) {
        }
    }

    public NetworkUtil() {
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

    public static NetworkInfo getActiveNetworkInfo(Context context) {
        InterceptResult invokeL;
        ConnectivityManager connectivityManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (context != null && (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) != null) {
                try {
                    return connectivityManager.getActiveNetworkInfo();
                } catch (Exception unused) {
                }
            }
            return null;
        }
        return (NetworkInfo) invokeL.objValue;
    }

    public static NetworkInfo[] getAllNetworkInfo(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (context == null) {
                return null;
            }
            try {
                return ((ConnectivityManager) context.getSystemService("connectivity")).getAllNetworkInfo();
            } catch (Exception unused) {
                return null;
            }
        }
        return (NetworkInfo[]) invokeL.objValue;
    }

    public static boolean isNetworkAvailable(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            try {
                if (isWifiConnected(context)) {
                    return true;
                }
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo == null) {
                    return false;
                }
                if (!activeNetworkInfo.isConnectedOrConnecting()) {
                    return false;
                }
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static String getCurrentNetMode(Context context) {
        InterceptResult invokeL;
        NetworkCapabilities networkCapabilities;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            NetworkInfo activeNetworkInfo = getActiveNetworkInfo(context);
            int i = -1;
            if (activeNetworkInfo != null) {
                int type = activeNetworkInfo.getType();
                if (type == 1) {
                    i = 1;
                } else if (type == 0 || type == 3 || type == 4 || type == 5) {
                    if (Build.VERSION.SDK_INT > 29) {
                        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                        if (connectivityManager == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork())) == null) {
                            return "mobile";
                        }
                        boolean hasTransport = networkCapabilities.hasTransport(1);
                        boolean hasTransport2 = networkCapabilities.hasTransport(0);
                        boolean hasTransport3 = networkCapabilities.hasTransport(3);
                        boolean hasTransport4 = networkCapabilities.hasTransport(6);
                        boolean hasTransport5 = networkCapabilities.hasTransport(4);
                        boolean hasTransport6 = networkCapabilities.hasTransport(5);
                        if (hasTransport) {
                            return "WIFI";
                        }
                        if (hasTransport2) {
                            return "CELLULAR";
                        }
                        if (hasTransport3) {
                            return "ETHERNET";
                        }
                        if (hasTransport4) {
                            return "LoWPAN";
                        }
                        if (hasTransport5) {
                            return "VPN";
                        }
                        if (!hasTransport6) {
                            return "mobile";
                        }
                        return "WifiAware";
                    }
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    if (telephonyManager != null) {
                        switch (telephonyManager.getNetworkType()) {
                            case 1:
                            case 2:
                                i = 6;
                                break;
                            case 3:
                            case 9:
                            case 10:
                            case 15:
                                i = 9;
                                break;
                            case 4:
                                i = 5;
                                break;
                            case 5:
                            case 6:
                            case 12:
                                i = 7;
                                break;
                            case 7:
                            case 11:
                            case 16:
                                i = 2;
                                break;
                            case 8:
                            case 17:
                                i = 8;
                                break;
                            case 13:
                            case 18:
                                i = 4;
                                break;
                            case 14:
                                i = 3;
                                break;
                            default:
                                i = 0;
                                break;
                        }
                    }
                }
            }
            return Integer.toString(i);
        }
        return (String) invokeL.objValue;
    }

    public static String getNetworkOperatorInfo(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                String networkOperator = telephonyManager.getNetworkOperator();
                if (!TextUtils.isEmpty(networkOperator)) {
                    try {
                        StringBuilder sb = new StringBuilder(networkOperator);
                        sb.insert(3, ":");
                        return sb.toString();
                    } catch (Exception unused) {
                    }
                }
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static int getNetworkOperatorType(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            String networkOperatorInfo = getNetworkOperatorInfo(context);
            if (!TextUtils.isEmpty(networkOperatorInfo)) {
                if (!networkOperatorInfo.startsWith("460:00") && !networkOperatorInfo.startsWith("460:02")) {
                    if (networkOperatorInfo.startsWith("460:01")) {
                        return 1;
                    }
                    if (networkOperatorInfo.startsWith("460:03")) {
                        return 2;
                    }
                    return -1;
                }
                return 0;
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public static boolean isWifiConnected(Context context) {
        InterceptResult invokeL;
        NetworkInfo activeNetworkInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            if (context == null) {
                return false;
            }
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || 1 != activeNetworkInfo.getType()) {
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

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x002e -> B:16:0x002f). Please submit an issue!!! */
    @SuppressLint({"MissingPermission"})
    public static boolean isWifiState(Context context) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
            if (context == null) {
                return false;
            }
            WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
            if (Build.VERSION.SDK_INT >= 23) {
                if (context.checkSelfPermission(com.kuaishou.weapon.p0.h.d) == 0) {
                    i = wifiManager.getWifiState();
                }
                i = 1;
            } else {
                i = wifiManager.getWifiState();
            }
            if (i != 3) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
