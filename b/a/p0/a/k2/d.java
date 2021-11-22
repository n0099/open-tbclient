package b.a.p0.a.k2;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.so.SoLoader;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? b.a.p0.a.c1.a.e0().c() : (String) invokeV.objValue;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? SoLoader.load(AppRuntime.getAppContext(), "audioengine") : invokeV.booleanValue;
    }

    public static f c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (!b.a.p0.a.c1.a.w0().d()) {
                return b.a.p0.a.h0.s.a.c(false);
            }
            return SoLoader.loadV8EngineSo(AppRuntime.getAppContext());
        }
        return (f) invokeV.objValue;
    }
}
