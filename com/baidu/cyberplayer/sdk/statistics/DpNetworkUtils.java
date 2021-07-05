package com.baidu.cyberplayer.sdk.statistics;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Process;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.Keep;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class DpNetworkUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public DpNetworkUtils() {
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

    public static String a(Context context) {
        InterceptResult invokeL;
        WifiInfo connectionInfo;
        int rssi;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            NetworkInfo b2 = b(context);
            if (b2 != null) {
                int type = b2.getType();
                if (type == 0) {
                    String extraInfo = b2.getExtraInfo();
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

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? Build.VERSION.SDK_INT >= 23 : invokeV.booleanValue;
    }

    public static boolean a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, str)) == null) ? str != null && context.checkPermission(str, Process.myPid(), Process.myUid()) == 0 : invokeLL.booleanValue;
    }

    public static NetworkInfo b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, context)) == null) {
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

    /* JADX WARN: Removed duplicated region for block: B:23:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean c(Context context) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context)) != null) {
            return invokeL.booleanValue;
        }
        boolean z2 = true;
        if (!a()) {
            return true;
        }
        if (context == null) {
            return false;
        }
        try {
            if (!a(context, "android.permission.CALL_PHONE") && !a(context, "android.permission.MODIFY_PHONE_STATE") && !a(context, "android.permission.READ_PHONE_STATE") && !a(context, "android.permission.PROCESS_OUTGOING_CALLS")) {
                z = false;
                if (Build.VERSION.SDK_INT < 16) {
                    if (!z) {
                        if (!a(context, "android.permission.READ_CALL_LOG")) {
                            z2 = false;
                        }
                    }
                    return z2;
                }
                return z;
            }
            z = true;
            if (Build.VERSION.SDK_INT < 16) {
            }
        } catch (Throwable unused) {
            return false;
        }
    }

    @Keep
    public static String getNetworkStatisticsData(Context context) {
        InterceptResult invokeL;
        int i2;
        TelephonyManager telephonyManager;
        String subscriberId;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, context)) == null) {
            NetworkInfo b2 = b(context);
            int i3 = 3;
            if (b2 == null || b2.getState() != NetworkInfo.State.CONNECTED) {
                i2 = 0;
            } else if (b2.getType() == 0) {
                switch (b2.getSubtype()) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        i2 = 2;
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
                        i2 = 3;
                        break;
                    case 13:
                        i2 = 4;
                        break;
                    default:
                        i2 = 1;
                        break;
                }
            } else {
                i2 = b2.getType() == 1 ? 100 : b2.getType() == 9 ? 101 : 999;
            }
            int i4 = 99;
            try {
                if (!c(context) || (telephonyManager = (TelephonyManager) context.getSystemService("phone")) == null || (subscriberId = telephonyManager.getSubscriberId()) == null) {
                    i3 = 0;
                } else {
                    if (!subscriberId.startsWith("46000") && !subscriberId.startsWith("46002") && !subscriberId.startsWith("46007") && !subscriberId.startsWith("46008")) {
                        if (!subscriberId.startsWith("46001") && !subscriberId.startsWith("46006") && !subscriberId.startsWith("46009")) {
                            if (!subscriberId.startsWith("46003") && !subscriberId.startsWith("46005")) {
                                if (!subscriberId.startsWith("460011")) {
                                    i3 = 99;
                                }
                            }
                            i3 = 2;
                        }
                    }
                    i3 = 1;
                }
                i4 = i3;
            } catch (Throwable th) {
                CyberLog.e("DpNetworkUtils", "network changed: " + th);
            }
            return i2 + "_" + i4;
        }
        return (String) invokeL.objValue;
    }
}
