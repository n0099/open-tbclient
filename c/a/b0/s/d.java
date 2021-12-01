package c.a.b0.s;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public static int a;

    /* renamed from: b  reason: collision with root package name */
    public static int f1921b;

    /* renamed from: c  reason: collision with root package name */
    public static Context f1922c;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f1923d;

    /* renamed from: e  reason: collision with root package name */
    public static c.a.b0.s.k0.d f1924e;

    /* renamed from: f  reason: collision with root package name */
    public static c.a.b0.s.i0.d f1925f;

    /* renamed from: g  reason: collision with root package name */
    public static String f1926g;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1949963602, "Lc/a/b0/s/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1949963602, "Lc/a/b0/s/d;");
        }
    }

    @NonNull
    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? f1926g : (String) invokeV.objValue;
    }

    public static Context b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f1922c : (Context) invokeV.objValue;
    }

    @NonNull
    public static c.a.b0.s.i0.d c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (f1925f == null) {
                f1925f = new c.a.b0.s.i0.c();
            }
            return f1925f;
        }
        return (c.a.b0.s.i0.d) invokeV.objValue;
    }

    @NonNull
    public static c.a.b0.s.k0.d d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (f1924e == null) {
                f1924e = new c.a.b0.s.k0.e();
            }
            return f1924e;
        }
        return (c.a.b0.s.k0.d) invokeV.objValue;
    }

    public static void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65541, null, z) == null) {
            h(z);
            Context context = f1922c;
            if (context != null) {
                DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                f1921b = Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels);
                a = Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels);
            }
        }
    }

    public static boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? f1923d : invokeV.booleanValue;
    }

    public static void g(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, context) == null) {
            f1922c = context;
        }
    }

    public static void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65544, null, z) == null) {
            f1923d = z;
        }
    }

    public static void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, str) == null) {
            f1926g = str;
        }
    }

    public static void j(@NonNull c.a.b0.s.i0.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, dVar) == null) {
            f1925f = dVar;
        }
    }
}
