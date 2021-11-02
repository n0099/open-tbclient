package com.baidu.mapapi;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mapsdkplatform.comapi.util.SysUpdateObservable;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class NetworkUtil {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public NetworkUtil() {
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

    public static NetworkInfo getActiveNetworkInfo(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            try {
                return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            } catch (Exception unused) {
                return null;
            }
        }
        return (NetworkInfo) invokeL.objValue;
    }

    public static String getCurrentNetMode(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            NetworkInfo activeNetworkInfo = getActiveNetworkInfo(context);
            int i2 = 1;
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.getType() != 1) {
                    switch (((TelephonyManager) context.getSystemService("phone")).getNetworkType()) {
                        case 1:
                        case 2:
                            i2 = 6;
                            break;
                        case 3:
                        case 9:
                        case 10:
                        case 15:
                            i2 = 9;
                            break;
                        case 4:
                            i2 = 5;
                            break;
                        case 5:
                        case 6:
                        case 7:
                        case 12:
                            i2 = 7;
                            break;
                        case 8:
                            i2 = 8;
                            break;
                        case 11:
                            i2 = 2;
                            break;
                        case 13:
                            i2 = 4;
                            break;
                        case 14:
                            i2 = 10;
                            break;
                    }
                }
                return Integer.toString(i2);
            }
            i2 = 0;
            return Integer.toString(i2);
        }
        return (String) invokeL.objValue;
    }

    public static boolean initConnectState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public static boolean isNetworkAvailable(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            try {
                if (isWifiConnected(context)) {
                    return true;
                }
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    return activeNetworkInfo.isConnectedOrConnecting();
                }
                return false;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean isWifiConnected(Context context) {
        InterceptResult invokeL;
        ConnectivityManager connectivityManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context)) == null) {
            if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
                return false;
            }
            try {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo == null || 1 != activeNetworkInfo.getType()) {
                    return false;
                }
                return activeNetworkInfo.isConnected();
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0012, code lost:
        if (r4.isConnected() != false) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean isWifiConnected(NetworkInfo networkInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, networkInfo)) == null) {
            boolean z = true;
            if (networkInfo != null) {
                try {
                    if (1 == networkInfo.getType()) {
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return false;
                }
            }
            z = false;
            return z;
        }
        return invokeL.booleanValue;
    }

    public static boolean isWifiState(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            if (context == null) {
                return false;
            }
            int i2 = -1;
            try {
                i2 = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getWifiState();
            } catch (Exception unused) {
            }
            return i2 == 3;
        }
        return invokeL.booleanValue;
    }

    public static void updateNetworkProxy(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, context) == null) {
            SysUpdateObservable.getInstance().updateNetworkProxy(context);
        }
    }
}
