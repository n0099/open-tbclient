package com.baidu.crabsdk.lite.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes2.dex */
public final class n {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Context f4731a;

    /* renamed from: b  reason: collision with root package name */
    public static PackageManager f4732b;

    /* renamed from: c  reason: collision with root package name */
    public static PackageInfo f4733c;

    /* renamed from: d  reason: collision with root package name */
    public static String f4734d;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, str, context) == null) && f4731a == null) {
            f4731a = context;
            PackageManager packageManager = context.getPackageManager();
            f4732b = packageManager;
            try {
                f4733c = packageManager.getPackageInfo(f4731a.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e2) {
                com.baidu.crabsdk.lite.b.a.e(str, "PackageCollector.init fail.", e2);
            }
        }
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? f4731a.getPackageName() : (String) invokeV.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f4734d == null) {
                PackageInfo packageInfo = f4733c;
                if (packageInfo == null) {
                    return "N/A";
                }
                f4734d = packageInfo.applicationInfo.loadLabel(f4732b).toString();
            }
            return f4734d;
        }
        return (String) invokeV.objValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            PackageInfo packageInfo = f4733c;
            return packageInfo == null ? "N/A" : packageInfo.versionName;
        }
        return (String) invokeV.objValue;
    }

    public static int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            PackageInfo packageInfo = f4733c;
            if (packageInfo == null) {
                return 0;
            }
            return packageInfo.versionCode;
        }
        return invokeV.intValue;
    }
}
