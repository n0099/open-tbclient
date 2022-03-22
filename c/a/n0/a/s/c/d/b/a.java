package c.a.n0.a.s.c.d.b;

import androidx.annotation.Nullable;
import c.a.n0.a.u.d;
import com.baidu.swan.apps.canvas.view.CanvasView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Nullable
    public static CanvasView a(c.a.n0.a.q.b.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, aVar)) == null) {
            c.a.n0.a.s.c.d.a aVar2 = (c.a.n0.a.s.c.d.a) c.a.n0.a.s.d.a.a(aVar);
            if (aVar2 == null) {
                d.c("Component-Canvas-Utils", "get canvas view fail: find a null component");
                return null;
            }
            return aVar2.i;
        }
        return (CanvasView) invokeL.objValue;
    }
}
