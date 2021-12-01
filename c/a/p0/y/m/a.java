package c.a.p0.y.m;

import android.view.Window;
import c.a.p0.a.d2.e;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a() {
        InterceptResult invokeV;
        SwanAppActivity x;
        Window window;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            e a0 = e.a0();
            return (a0 == null || (x = a0.x()) == null || x.isFinishing() || (window = x.getWindow()) == null || (window.getAttributes().flags & 1024) != 1024) ? false : true;
        }
        return invokeV.booleanValue;
    }
}
