package com.baidu.crabsdk.lite.a;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.crabsdk.lite.b.b;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/* loaded from: classes2.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Activity f4740a;

    /* renamed from: b  reason: collision with root package name */
    public static b<List> f4741b;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f4742c;

    /* renamed from: d  reason: collision with root package name */
    public static long f4743d;

    /* renamed from: e  reason: collision with root package name */
    public static int f4744e;

    /* renamed from: f  reason: collision with root package name */
    public static int f4745f;

    /* renamed from: g  reason: collision with root package name */
    public static int f4746g;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1349354870, "Lcom/baidu/crabsdk/lite/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1349354870, "Lcom/baidu/crabsdk/lite/a/a;");
                return;
            }
        }
        f4741b = new b<>(com.baidu.crabsdk.lite.a.f4733c);
        f4742c = true;
        f4744e = 0;
        f4745f = 0;
        f4746g = 0;
    }

    public static long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? f4743d : invokeV.longValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0060, code lost:
        if ((((java.util.Date) com.baidu.crabsdk.lite.a.a.f4741b.get(r5 - 1).get(1)).getTime() - ((java.util.Date) r3.get(2)).getTime()) > com.baidu.crabsdk.lite.a.f4736f) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void b(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, activity) == null) {
            f4740a = activity;
            ArrayList arrayList = new ArrayList(3);
            arrayList.add(activity.getClass().getName());
            arrayList.add(new Date());
            f4741b.add(arrayList);
            int size = f4741b.size();
            if (size >= 2) {
                List list = f4741b.get(size - 2);
                if (list.size() == 3) {
                }
                f4745f = (f4745f + 1) % 100;
            }
            f4744e++;
            f4745f = (f4745f + 1) % 100;
        }
    }

    @SuppressLint({"NewApi"})
    public static void c(String str, Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65539, null, str, context) == null) && f4742c) {
            f4742c = false;
            f4743d = System.currentTimeMillis();
            if (com.baidu.crabsdk.lite.b.c.g() >= 14) {
                if (!(context instanceof Application)) {
                    com.baidu.crabsdk.lite.b.a.g(str, "传入的不是一个Application对象!");
                    return;
                }
                com.baidu.crabsdk.lite.b.a.c(str, "传入的是一个Application对象");
                ((Application) context).registerActivityLifecycleCallbacks(new d.a.o.a.a.a());
            }
        }
    }

    public static String d() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            StringBuilder sb = new StringBuilder();
            int size = f4741b.size();
            for (int i2 = 0; i2 < size; i2++) {
                List list = f4741b.get((size - i2) - 1);
                if (list.size() == 3) {
                    sb.append((String) list.get(0));
                    sb.append(" from ");
                    sb.append(com.baidu.crabsdk.lite.b.c.b((Date) list.get(1)));
                    sb.append(" to ");
                    sb.append(com.baidu.crabsdk.lite.b.c.b((Date) list.get(2)));
                    str = "\n";
                } else if (list.size() == 2) {
                    sb.append((String) list.get(0));
                    sb.append(" from ");
                    sb.append(com.baidu.crabsdk.lite.b.c.b((Date) list.get(1)));
                    str = " to ...\n";
                }
                sb.append(str);
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public static /* synthetic */ void e(Activity activity) {
        Activity activity2 = f4740a;
        if (activity2 != null && activity != null && activity2.hashCode() == activity.hashCode()) {
            f4740a = null;
        }
        int i2 = f4745f - f4746g;
        int size = f4741b.size();
        if (i2 < 0) {
            i2 += 100;
        }
        if (i2 > 0 && size >= i2) {
            List list = f4741b.get(size - i2);
            if (list.size() == 2) {
                list.add(new Date());
            }
        }
        f4746g = (f4746g + 1) % 100;
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
            Activity activity = f4740a;
            return activity == null ? "N/A" : activity.getClass().getName();
        }
        return (String) invokeV.objValue;
    }

    public static byte[] g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            if (f4740a == null) {
                return new byte[0];
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                View decorView = f4740a.getWindow().getDecorView();
                decorView.setDrawingCacheEnabled(true);
                Bitmap drawingCache = decorView.getDrawingCache();
                if (drawingCache != null) {
                    drawingCache.compress(Bitmap.CompressFormat.JPEG, 30, byteArrayOutputStream);
                } else {
                    com.baidu.crabsdk.lite.b.a.f(str, "getScreenshot failed, curActivity " + f4740a.getClass().getName());
                }
                decorView.setDrawingCacheEnabled(false);
            } catch (RuntimeException e2) {
                com.baidu.crabsdk.lite.b.a.e(str, "getScreenshot failed, curActivity " + f4740a.getClass().getName(), e2);
            }
            return byteArrayOutputStream.toByteArray();
        }
        return (byte[]) invokeL.objValue;
    }
}
