package com.baidu.mobads.container.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class ConnectionType {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int TYPE_2G = 2;
    public static final int TYPE_3G = 3;
    public static final int TYPE_4G = 4;
    public static final int TYPE_5G = 5;
    public static final int TYPE_CELL_UNKNOWN = 1;
    public static final int TYPE_ETHERNET = 101;
    public static final int TYPE_UNKNOWN = 999;
    public static final int TYPE_UNREACHABLE = 0;
    public static final int TYPE_WIFI = 100;
    public transient /* synthetic */ FieldHolder $fh;

    public ConnectionType() {
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

    public static int get(Context context) {
        InterceptResult invokeL;
        NetworkInfo networkInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                return 0;
            }
            NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(1);
            if (networkInfo2 == null || !isConnectedOrConnecting(networkInfo2.getState())) {
                if (Build.VERSION.SDK_INT < 13 || (networkInfo = connectivityManager.getNetworkInfo(9)) == null || !isConnectedOrConnecting(networkInfo.getState())) {
                    NetworkInfo networkInfo3 = connectivityManager.getNetworkInfo(0);
                    if (networkInfo3 == null || !isConnectedOrConnecting(networkInfo3.getState())) {
                        return 999;
                    }
                    switch (((TelephonyManager) context.getSystemService("phone")).getNetworkType()) {
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
                return 101;
            }
            return 100;
        }
        return invokeL.intValue;
    }

    public static boolean isConnectedOrConnecting(NetworkInfo.State state) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, state)) == null) ? state != null && (state == NetworkInfo.State.CONNECTED || state == NetworkInfo.State.CONNECTING) : invokeL.booleanValue;
    }
}
