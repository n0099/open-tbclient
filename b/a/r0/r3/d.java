package b.a.r0.r3;

import b.a.q0.c1.p0;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            try {
                Thread.setDefaultUncaughtExceptionHandler(new p0());
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }
}
