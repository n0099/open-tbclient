package c.a.x.g.f;

import c.a.x.g.g.b;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, runnable) == null) {
            ExecutorUtilsExt.postOnElastic(runnable, "live-feedpage-" + b.a().b(), 3);
        }
    }

    public static void b(Runnable runnable, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65537, null, runnable, str, i2) == null) {
            ExecutorUtilsExt.postOnElastic(runnable, str, i2);
        }
    }
}
