package c.a.n0.a.x.i;

import android.os.Looper;
import androidx.annotation.StringRes;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.p2.q0;
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
    public static volatile int f7089b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f7090b;

        public a(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i;
            this.f7090b = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.c(this.a, this.f7090b);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-622827735, "Lc/a/n0/a/x/i/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-622827735, "Lc/a/n0/a/x/i/d;");
        }
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f7089b < 2 : invokeV.booleanValue;
    }

    public static void c(@StringRes int i, int i2) {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(65539, null, i, i2) == null) || (activity = c.a.n0.a.w0.f.U().getActivity()) == null || activity.isFinishing()) {
            return;
        }
        if (i2 != 1) {
            c.a.n0.a.s1.b.f.e.f(activity, i).G();
        } else {
            c.a.n0.a.s1.b.f.e.f(activity, i).I();
        }
    }

    public static void d(@StringRes int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TRACKBALL, null, i, i2) == null) {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                c(i, i2);
            } else {
                q0.a0(new a(i, i2));
            }
        }
    }

    public static void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            f7089b = 0;
            a = 0L;
        }
    }

    public static void f(@StringRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65542, null, i) == null) {
            g(i, 0);
        }
    }

    public static synchronized void g(@StringRes int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65543, null, i, i2) == null) {
            synchronized (d.class) {
                int i3 = f7089b;
                if (i3 != 0) {
                    if (i3 == 1 && (a + 5000) - System.currentTimeMillis() < 0) {
                        f7089b = 2;
                        d(i, i2);
                        f.g("toast提示个数已达2个");
                    }
                } else {
                    f7089b = 1;
                    a = System.currentTimeMillis();
                    d(i, i2);
                }
            }
        }
    }
}
