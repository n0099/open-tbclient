package c.a.r0.a4;

import android.view.View;
import com.baidu.tieba.tblauncher.MainTabScheduleStrategy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes2.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(MainTabScheduleStrategy mainTabScheduleStrategy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, mainTabScheduleStrategy) == null) {
            d.b(mainTabScheduleStrategy);
        }
    }

    public static void b(Runnable runnable, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65537, null, runnable, i2) == null) {
            d.f(new i(runnable, i2));
        }
    }

    public static void c(View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, null, view, i2) == null) {
            d.f(new k(view, i2));
        }
    }
}
