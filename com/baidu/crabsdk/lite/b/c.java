package com.baidu.crabsdk.lite.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import com.baidu.crabsdk.lite.a.n;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes3.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static SimpleDateFormat f4721a;

    /* renamed from: b  reason: collision with root package name */
    public static PackageManager f4722b;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(long j) {
        InterceptResult invokeJ;
        StringBuilder sb;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65536, null, j)) == null) {
            if (j / 1000000000 > 0) {
                sb = new StringBuilder();
                sb.append(((float) (j / 100000000)) / 10.0f);
                str = "G";
            } else if (j / 1000000 > 0) {
                sb = new StringBuilder();
                sb.append(((float) (j / 100000)) / 10.0f);
                str = "M";
            } else if (j / 1000 > 0) {
                sb = new StringBuilder();
                sb.append(((float) (j / 100)) / 10.0f);
                str = "K";
            } else {
                sb = new StringBuilder();
                sb.append(j);
                str = "B";
            }
            sb.append(str);
            return sb.toString();
        }
        return (String) invokeJ.objValue;
    }

    public static String b(Date date) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, date)) == null) {
            if (f4721a == null) {
                f4721a = new SimpleDateFormat("MM-dd HH:mm:ss");
            }
            return f4721a.format(date);
        }
        return (String) invokeL.objValue;
    }

    public static void c(SharedPreferences.Editor editor, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65538, null, editor, z) == null) {
            if (g() < 9 || z) {
                editor.commit();
            } else {
                editor.apply();
            }
        }
    }

    public static String d(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, th)) == null) {
            if (th == null) {
                return "";
            }
            StackTraceElement[] stackTrace = th.getStackTrace();
            return stackTrace.length > 0 ? stackTrace[0].toString() : "N/A";
        }
        return (String) invokeL.objValue;
    }

    public static boolean e(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65540, null, context, str)) == null) {
            if (f4722b == null) {
                f4722b = context.getPackageManager();
            }
            return f4722b.checkPermission(str, context.getPackageName()) == 0;
        }
        return invokeLL.booleanValue;
    }

    public static String f(Throwable th) {
        InterceptResult invokeL;
        StackTraceElement stackTraceElement;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, th)) == null) {
            if (th == null) {
                return "";
            }
            while (th.getCause() != null) {
                th = th.getCause();
            }
            StackTraceElement[] stackTrace = th.getStackTrace();
            String b2 = n.b();
            int i2 = 0;
            while (true) {
                if (i2 < stackTrace.length) {
                    if (stackTrace[i2].getClassName().contains(b2)) {
                        stackTraceElement = stackTrace[i2];
                        break;
                    }
                    i2++;
                } else if (stackTrace.length <= 0) {
                    return "N/A";
                } else {
                    stackTraceElement = stackTrace[0];
                }
            }
            return stackTraceElement.toString();
        }
        return (String) invokeL.objValue;
    }

    public static int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
            try {
                return Build.VERSION.class.getField("SDK_INT").getInt(null);
            } catch (Exception unused) {
                return Integer.parseInt(Build.VERSION.SDK);
            }
        }
        return invokeV.intValue;
    }

    public static String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? new SimpleDateFormat("yyyyMMdd").format(new Date(System.currentTimeMillis())) : (String) invokeV.objValue;
    }
}
