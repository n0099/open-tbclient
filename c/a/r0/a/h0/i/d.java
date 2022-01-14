package c.a.r0.a.h0.i;

import android.os.Looper;
import androidx.annotation.StringRes;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.z2.q0;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public static long a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile int f6463b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f6464e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f6465f;

        public a(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6464e = i2;
            this.f6465f = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.c(this.f6464e, this.f6465f);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1345093771, "Lc/a/r0/a/h0/i/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1345093771, "Lc/a/r0/a/h0/i/d;");
        }
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f6463b < 2 : invokeV.booleanValue;
    }

    public static void c(@StringRes int i2, int i3) {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(65539, null, i2, i3) == null) || (activity = c.a.r0.a.g1.f.U().getActivity()) == null || activity.isFinishing()) {
            return;
        }
        if (i3 != 1) {
            c.a.r0.a.c2.b.f.e.f(activity, i2).G();
        } else {
            c.a.r0.a.c2.b.f.e.f(activity, i2).I();
        }
    }

    public static void d(@StringRes int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TRACKBALL, null, i2, i3) == null) {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                c(i2, i3);
            } else {
                q0.a0(new a(i2, i3));
            }
        }
    }

    public static void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            f6463b = 0;
            a = 0L;
        }
    }

    public static void f(@StringRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65542, null, i2) == null) {
            g(i2, 0);
        }
    }

    public static synchronized void g(@StringRes int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65543, null, i2, i3) == null) {
            synchronized (d.class) {
                int i4 = f6463b;
                if (i4 != 0) {
                    if (i4 == 1 && (a + 5000) - System.currentTimeMillis() < 0) {
                        f6463b = 2;
                        d(i2, i3);
                        f.g("toast提示个数已达2个");
                    }
                } else {
                    f6463b = 1;
                    a = System.currentTimeMillis();
                    d(i2, i3);
                }
            }
        }
    }
}
