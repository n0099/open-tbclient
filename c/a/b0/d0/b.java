package c.a.b0.d0;

import androidx.annotation.NonNull;
import c.a.b0.d0.d.c;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Runnable runnable, @NonNull String str, int i2, long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{runnable, str, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || runnable == null) {
            return;
        }
        c.b().a().a(runnable, str, (i2 == 0 || i2 == 1 || i2 == 2 || i2 == 3) ? i2 : 3, j2);
    }

    public static void b(Runnable runnable, @NonNull String str, long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{runnable, str, Long.valueOf(j2)}) == null) || runnable == null) {
            return;
        }
        c.b().a().b(runnable, str, j2);
    }

    public static void c(@NonNull Runnable runnable, @NonNull String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65538, null, runnable, str, i2) == null) {
            a(runnable, str, i2, 0L);
        }
    }

    public static void d(@NonNull Runnable runnable, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, runnable, str) == null) {
            b(runnable, str, 0L);
        }
    }
}
