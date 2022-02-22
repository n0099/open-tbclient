package c.a.d0.v;

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
    public static int f3258b;

    /* renamed from: c  reason: collision with root package name */
    public static Context f3259c;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f3260d;

    /* renamed from: e  reason: collision with root package name */
    public static c.a.d0.v.k0.d f3261e;

    /* renamed from: f  reason: collision with root package name */
    public static c.a.d0.v.i0.d f3262f;

    /* renamed from: g  reason: collision with root package name */
    public static String f3263g;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-174866867, "Lc/a/d0/v/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-174866867, "Lc/a/d0/v/d;");
        }
    }

    @NonNull
    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? f3263g : (String) invokeV.objValue;
    }

    public static Context b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f3259c : (Context) invokeV.objValue;
    }

    @NonNull
    public static c.a.d0.v.i0.d c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (f3262f == null) {
                f3262f = new c.a.d0.v.i0.c();
            }
            return f3262f;
        }
        return (c.a.d0.v.i0.d) invokeV.objValue;
    }

    @NonNull
    public static c.a.d0.v.k0.d d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (f3261e == null) {
                f3261e = new c.a.d0.v.k0.e();
            }
            return f3261e;
        }
        return (c.a.d0.v.k0.d) invokeV.objValue;
    }

    public static void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65541, null, z) == null) {
            h(z);
            Context context = f3259c;
            if (context != null) {
                DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                f3258b = Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels);
                a = Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels);
            }
        }
    }

    public static boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? f3260d : invokeV.booleanValue;
    }

    public static void g(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, context) == null) {
            f3259c = context;
        }
    }

    public static void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65544, null, z) == null) {
            f3260d = z;
        }
    }

    public static void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, str) == null) {
            f3263g = str;
        }
    }

    public static void j(@NonNull c.a.d0.v.i0.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, dVar) == null) {
            f3262f = dVar;
        }
    }
}
