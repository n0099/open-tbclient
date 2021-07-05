package com.baidu.pass.biometrics.base.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.apollon.statistics.g;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public final class NetworkUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int NETWORK_2G = 2;
    public static final int NETWORK_3G = 3;
    public static final int NETWORK_4G = 4;
    public static final int NETWORK_TYPE_1XRTT = 7;
    public static final int NETWORK_TYPE_CDMA = 4;
    public static final int NETWORK_TYPE_EDGE = 2;
    public static final int NETWORK_TYPE_EHRPD = 14;
    public static final int NETWORK_TYPE_EVDO_0 = 5;
    public static final int NETWORK_TYPE_EVDO_A = 6;
    public static final int NETWORK_TYPE_EVDO_B = 12;
    public static final int NETWORK_TYPE_GPRS = 1;
    public static final int NETWORK_TYPE_GSM = 16;
    public static final int NETWORK_TYPE_HSDPA = 8;
    public static final int NETWORK_TYPE_HSPA = 10;
    public static final int NETWORK_TYPE_HSPAP = 15;
    public static final int NETWORK_TYPE_HSUPA = 9;
    public static final int NETWORK_TYPE_IDEN = 11;
    public static final int NETWORK_TYPE_IWLAN = 18;
    public static final int NETWORK_TYPE_LTE = 13;
    public static final int NETWORK_TYPE_NR = 20;
    public static final int NETWORK_TYPE_TD_SCDMA = 17;
    public static final int NETWORK_TYPE_UMTS = 3;
    public static final int NETWORK_TYPE_UNKNOWN = 0;
    public static final int NETWORK_UNKNOW = 0;
    public static final int NETWORK_WIFI = 1;
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

    @TargetApi(3)
    public static String getNetworkClass(Context context) {
        InterceptResult invokeL;
        NetworkInfo activeNetworkInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            try {
                activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            } catch (Throwable unused) {
            }
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                if (activeNetworkInfo.getType() == 1) {
                    return CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING;
                }
                if (activeNetworkInfo.getType() == 0) {
                    int subtype = activeNetworkInfo.getSubtype();
                    if (subtype != 20) {
                        switch (subtype) {
                            case 1:
                            case 2:
                            case 4:
                            case 7:
                            case 11:
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
                                return g.f3983b;
                            case 13:
                                return "4G";
                            default:
                                return RomUtils.UNKNOWN;
                        }
                    }
                    return "5G";
                }
                return RomUtils.UNKNOWN;
            }
            return "UNCNCT";
        }
        return (String) invokeL.objValue;
    }

    public static boolean isNetworkAvailable(Context context) {
        InterceptResult invokeL;
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) ? (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isAvailable()) ? false : true : invokeL.booleanValue;
    }
}
