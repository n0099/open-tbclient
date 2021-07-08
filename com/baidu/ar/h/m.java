package com.baidu.ar.h;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public final class m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean t(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            NetworkInfo v = v(context);
            return v != null && v.isAvailable();
        }
        return invokeL.booleanValue;
    }

    public static boolean u(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            NetworkInfo v = v(context);
            return v != null && v.isAvailable() && v.getType() == 1;
        }
        return invokeL.booleanValue;
    }

    public static NetworkInfo v(Context context) {
        InterceptResult invokeL;
        ConnectivityManager connectivityManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
                return null;
            }
            return connectivityManager.getActiveNetworkInfo();
        }
        return (NetworkInfo) invokeL.objValue;
    }

    public static int w(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            NetworkInfo v = v(context);
            if (v == null) {
                return Integer.MIN_VALUE;
            }
            if (v.isAvailable() && v.getType() == 0) {
                String subtypeName = v.getSubtypeName();
                switch (v.getSubtype()) {
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
                        if (subtypeName.equalsIgnoreCase("TD-SCDMA") || subtypeName.equalsIgnoreCase("WCDMA") || subtypeName.equalsIgnoreCase("CDMA2000")) {
                            return 3;
                        }
                        break;
                }
            }
            return Integer.MIN_VALUE;
        }
        return invokeL.intValue;
    }

    public static String x(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            if (!t(context) || context == null) {
                return "not_Reachable";
            }
            if (u(context)) {
                return "wifi";
            }
            int w = w(context);
            return w == 2 ? "2G" : w == 3 ? com.baidu.apollon.statistics.g.f3986b : w == 4 ? "4G" : "other_network";
        }
        return (String) invokeL.objValue;
    }
}
