package b.a.p0.h.i.s;

import android.os.Handler;
import android.os.Looper;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Handler f10571a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1751283432, "Lb/a/p0/h/i/s/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1751283432, "Lb/a/p0/h/i/s/d;");
                return;
            }
        }
        f10571a = new Handler(Looper.getMainLooper());
    }

    public static void a(Runnable runnable, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65537, null, runnable, j) == null) {
            f10571a.postDelayed(runnable, j);
        }
    }

    public static void b(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, runnable) == null) {
            f10571a.removeCallbacks(runnable);
        }
    }

    public static void c(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, runnable) == null) {
            d(runnable, 0L);
        }
    }

    public static void d(Runnable runnable, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(InputDeviceCompat.SOURCE_TRACKBALL, null, runnable, j) == null) {
            if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
                f10571a.postDelayed(runnable, j);
            } else {
                runnable.run();
            }
        }
    }
}
