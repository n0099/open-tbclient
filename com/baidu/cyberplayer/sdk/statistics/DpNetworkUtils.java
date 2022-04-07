package com.baidu.cyberplayer.sdk.statistics;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.cyberplayer.sdk.Keep;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class DpNetworkUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public DpNetworkUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static int a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager == null) {
                    return 0;
                }
                String simOperator = telephonyManager.getSimOperator();
                if (TextUtils.isEmpty(simOperator)) {
                    return 0;
                }
                if (!"46000".equals(simOperator) && !"46002".equals(simOperator) && !"46007".equals(simOperator) && !"46008".equals(simOperator)) {
                    if (!"46001".equals(simOperator) && !"46006".equals(simOperator) && !"46009".equals(simOperator)) {
                        if (!"46003".equals(simOperator) && !"46005".equals(simOperator)) {
                            if (!"46011".equals(simOperator)) {
                                return 99;
                            }
                        }
                        return 2;
                    }
                    return 3;
                }
                return 1;
            } catch (Exception e) {
                e.printStackTrace();
                return 0;
            }
        }
        return invokeL.intValue;
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        WifiInfo connectionInfo;
        int rssi;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            NetworkInfo netWorkInfo = getNetWorkInfo(context);
            if (netWorkInfo != null) {
                int type = netWorkInfo.getType();
                if (type == 0) {
                    String extraInfo = netWorkInfo.getExtraInfo();
                    return TextUtils.isEmpty(extraInfo) ? "Disconnect" : extraInfo;
                } else if (type == 1) {
                    WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                    if (wifiManager == null || (connectionInfo = wifiManager.getConnectionInfo()) == null || (rssi = connectionInfo.getRssi()) <= -127) {
                        return "Disconnect";
                    }
                    return "wifi:" + rssi;
                } else {
                    return "N/A";
                }
            }
            return "Disconnect";
        }
        return (String) invokeL.objValue;
    }

    @Keep
    public static NetworkInfo getNetWorkInfo(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (context == null) {
                return null;
            }
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager != null) {
                    return connectivityManager.getActiveNetworkInfo();
                }
            } catch (Exception unused) {
            }
            return null;
        }
        return (NetworkInfo) invokeL.objValue;
    }

    @Keep
    public static int getNetworkConnectType(NetworkInfo networkInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, networkInfo)) == null) {
            if (networkInfo == null || networkInfo.getState() != NetworkInfo.State.CONNECTED) {
                return 0;
            }
            if (networkInfo.getType() != 0) {
                if (networkInfo.getType() == 1) {
                    return 100;
                }
                return networkInfo.getType() == 9 ? 101 : 999;
            }
            switch (networkInfo.getSubtype()) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
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
                    return 3;
                case 13:
                    return 4;
                default:
                    return 1;
            }
        }
        return invokeL.intValue;
    }

    @Keep
    public static String getNetworkStatisticsData(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            int networkConnectType = getNetworkConnectType(getNetWorkInfo(context));
            int a = a(context);
            return networkConnectType + "_" + a;
        }
        return (String) invokeL.objValue;
    }
}
