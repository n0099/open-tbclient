package com.baidu.crabsdk.lite.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes2.dex */
public final class m {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static TelephonyManager f4754a;

    /* renamed from: b  reason: collision with root package name */
    public static ConnectivityManager f4755b;

    /* renamed from: c  reason: collision with root package name */
    public static Context f4756c;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, context) == null) {
            f4756c = context;
        }
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            try {
                if (f4755b == null) {
                    f4755b = (ConnectivityManager) f4756c.getSystemService("connectivity");
                }
                NetworkInfo activeNetworkInfo = f4755b.getActiveNetworkInfo();
                return activeNetworkInfo == null ? RomUtils.UNKNOWN : !activeNetworkInfo.isConnected() ? "NONE" : activeNetworkInfo.getTypeName().toUpperCase();
            } catch (RuntimeException unused) {
                return RomUtils.UNKNOWN;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String c(String str) {
        InterceptResult invokeL;
        NetworkInfo activeNetworkInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            String str2 = "\n";
            StringBuilder sb = new StringBuilder();
            try {
                if (f4755b == null) {
                    f4755b = (ConnectivityManager) f4756c.getSystemService("connectivity");
                }
                activeNetworkInfo = f4755b.getActiveNetworkInfo();
            } catch (RuntimeException e2) {
                com.baidu.crabsdk.lite.b.a.e(str, "getNetworkInfo", e2);
            }
            if (activeNetworkInfo == null) {
                return "N/A";
            }
            if (activeNetworkInfo.isConnected()) {
                sb.append("type: ");
                sb.append(activeNetworkInfo.getTypeName());
                sb.append("\n");
                if (activeNetworkInfo.getType() == 0) {
                    sb.append("subType: ");
                    sb.append(activeNetworkInfo.getSubtypeName());
                    sb.append("\n");
                    if (f4754a == null) {
                        f4754a = (TelephonyManager) f4756c.getSystemService("phone");
                    }
                    sb.append("isRoaming: ");
                    sb.append(f4754a.isNetworkRoaming() ? "yes" : "no");
                }
                return sb.toString();
            }
            str2 = "type: none\n";
            sb.append(str2);
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }
}
