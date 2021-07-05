package com.baidu.crabsdk.lite.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public final class n {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Context f4714a;

    /* renamed from: b  reason: collision with root package name */
    public static PackageManager f4715b;

    /* renamed from: c  reason: collision with root package name */
    public static PackageInfo f4716c;

    /* renamed from: d  reason: collision with root package name */
    public static String f4717d;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, str, context) == null) && f4714a == null) {
            f4714a = context;
            PackageManager packageManager = context.getPackageManager();
            f4715b = packageManager;
            try {
                f4716c = packageManager.getPackageInfo(f4714a.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e2) {
                com.baidu.crabsdk.lite.b.a.e(str, "PackageCollector.init fail.", e2);
            }
        }
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? f4714a.getPackageName() : (String) invokeV.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f4717d == null) {
                PackageInfo packageInfo = f4716c;
                if (packageInfo == null) {
                    return "N/A";
                }
                f4717d = packageInfo.applicationInfo.loadLabel(f4715b).toString();
            }
            return f4717d;
        }
        return (String) invokeV.objValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            PackageInfo packageInfo = f4716c;
            return packageInfo == null ? "N/A" : packageInfo.versionName;
        }
        return (String) invokeV.objValue;
    }

    public static int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65540, null)) == null) {
            PackageInfo packageInfo = f4716c;
            if (packageInfo == null) {
                return 0;
            }
            return packageInfo.versionCode;
        }
        return invokeV.intValue;
    }
}
