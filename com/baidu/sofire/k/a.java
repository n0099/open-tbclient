package com.baidu.sofire.k;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.util.devices.IDevices;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Field;
import java.util.Collection;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;
    public static String a = "";
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized String a(Context context) {
        InterceptResult invokeL;
        String[] strArr;
        String[] strArr2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            synchronized (a.class) {
                if (!TextUtils.isEmpty(a)) {
                    return a;
                }
                int i = Build.VERSION.SDK_INT;
                if (i >= 21) {
                    String b = b(context);
                    a = b;
                    if (!TextUtils.isEmpty(b)) {
                        return a;
                    }
                }
                if (TextUtils.isEmpty(a)) {
                    String str = Build.CPU_ABI;
                    a = str;
                    if (!TextUtils.isEmpty(str)) {
                        return a;
                    }
                }
                if (i >= 21 && TextUtils.isEmpty(a)) {
                    boolean c = b.c();
                    if (c && (strArr2 = Build.SUPPORTED_64_BIT_ABIS) != null && strArr2.length > 0) {
                        a = strArr2[0];
                    } else if (!c && (strArr = Build.SUPPORTED_32_BIT_ABIS) != null && strArr.length > 0) {
                        a = strArr[0];
                    }
                    if (!TextUtils.isEmpty(a)) {
                        return a;
                    }
                }
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String a(Context context, Collection<String> collection) {
        InterceptResult invokeLL;
        String[] strArr;
        String[] strArr2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, collection)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                String b = b(context);
                if (!TextUtils.isEmpty(b) && collection.contains(b)) {
                    return b;
                }
                boolean c = b.c();
                if (c) {
                    strArr = Build.SUPPORTED_64_BIT_ABIS;
                } else {
                    strArr = Build.SUPPORTED_32_BIT_ABIS;
                }
                if (strArr != null && strArr.length > 0) {
                    for (String str : strArr) {
                        if (collection.contains(str)) {
                            return str;
                        }
                    }
                }
                if (!c && collection.contains("armeabi") && (strArr2 = Build.SUPPORTED_ABIS) != null && strArr2.length > 0 && !IDevices.ABI_MIPS.equals(strArr2[0])) {
                    return "armeabi";
                }
                return "";
            }
            String str2 = Build.CPU_ABI;
            if (collection.contains(str2)) {
                return str2;
            }
            String str3 = Build.CPU_ABI2;
            if (collection.contains(str3)) {
                return str3;
            }
            if (collection.contains("armeabi") && !IDevices.ABI_MIPS.equals(str2)) {
                return "armeabi";
            }
            return "";
        }
        return (String) invokeLL.objValue;
    }

    public static String b(Context context) {
        PackageManager packageManager;
        ApplicationInfo applicationInfo;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            try {
                if (Build.VERSION.SDK_INT >= 21 && (packageManager = context.getPackageManager()) != null && (applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 0)) != null) {
                    Field declaredField = ApplicationInfo.class.getDeclaredField("primaryCpuAbi");
                    declaredField.setAccessible(true);
                    return (String) declaredField.get(applicationInfo);
                }
                return "";
            } catch (Throwable unused) {
                int i = com.baidu.sofire.a.b.a;
                return "";
            }
        }
        return (String) invokeL.objValue;
    }
}
