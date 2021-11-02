package b.a.z.a.i;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Process;
import android.telephony.TelephonyManager;
import androidx.core.view.InputDeviceCompat;
import b.a.z.a.e;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static NetworkInfo a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            e.c("DpNetworkUtils", "getNetWorkInfo()");
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

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            e.c("DpNetworkUtils", "shouldCheckPermission()");
            return Build.VERSION.SDK_INT >= 23;
        }
        return invokeV.booleanValue;
    }

    public static boolean c(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            e.c("DpNetworkUtils", "checkPermissionGranted()");
            return str != null && context.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
        }
        return invokeLL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean d(Context context) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65539, null, context)) != null) {
            return invokeL.booleanValue;
        }
        e.c("DpNetworkUtils", "checkPhonePermission()");
        boolean z2 = true;
        if (!b()) {
            return true;
        }
        if (context == null) {
            return false;
        }
        try {
            if (!c(context, "android.permission.CALL_PHONE") && !c(context, "android.permission.MODIFY_PHONE_STATE") && !c(context, "android.permission.READ_PHONE_STATE") && !c(context, "android.permission.PROCESS_OUTGOING_CALLS")) {
                z = false;
                if (Build.VERSION.SDK_INT < 16) {
                    if (!z) {
                        if (!c(context, "android.permission.READ_CALL_LOG")) {
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

    public static String e(Context context) {
        InterceptResult invokeL;
        int i2;
        TelephonyManager telephonyManager;
        String subscriberId;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            e.c("DpNetworkUtils", "getNetworkStatisticsData()");
            NetworkInfo a2 = a(context);
            int i3 = 3;
            if (a2 == null || a2.getState() != NetworkInfo.State.CONNECTED) {
                i2 = 0;
            } else if (a2.getType() == 0) {
                switch (a2.getSubtype()) {
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
                i2 = a2.getType() == 1 ? 100 : a2.getType() == 9 ? 101 : 999;
            }
            int i4 = 99;
            try {
                if (!d(context) || (telephonyManager = (TelephonyManager) context.getSystemService("phone")) == null || (subscriberId = telephonyManager.getSubscriberId()) == null) {
                    i3 = 0;
                } else {
                    if (!subscriberId.startsWith("46000") && !subscriberId.startsWith("46002")) {
                        if (!subscriberId.startsWith("46001")) {
                            i3 = subscriberId.startsWith("46003") ? 2 : 99;
                        }
                    }
                    i3 = 1;
                }
                i4 = i3;
            } catch (Throwable th) {
                e.e("DpNetworkUtils", "network changed: " + th);
            }
            return i2 + "_" + i4;
        }
        return (String) invokeL.objValue;
    }
}
