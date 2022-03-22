package c.a.n0.a.k.e.o.a;

import android.view.View;
import androidx.annotation.NonNull;
import c.a.n0.a.p2.n0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
/* loaded from: classes.dex */
public final class e extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // c.a.n0.a.k.e.o.a.a
    public c.a.n0.a.k.h.b c(@NonNull c.a.n0.a.x.g.d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dVar)) == null) {
            View r = c.a.n0.a.s0.b.i().r(dVar);
            if (r == null) {
                return new c.a.n0.a.k.h.b(1001);
            }
            return e(r);
        }
        return (c.a.n0.a.k.h.b) invokeL.objValue;
    }

    @Override // c.a.n0.a.k.e.o.a.a
    public c.a.n0.a.k.h.b d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) ? new c.a.n0.a.k.h.b(1001) : (c.a.n0.a.k.h.b) invokeI.objValue;
    }

    public final c.a.n0.a.k.h.b e(@NonNull View view) {
        InterceptResult invokeL;
        c.a.n0.a.k.h.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view)) == null) {
            try {
                bVar = new c.a.n0.a.k.h.b(0, b((int) (n0.P(view.getLeft()) + 0.5f), (int) (n0.P(view.getTop()) + 0.5f), (int) (n0.P(view.getRight()) + 0.5f), (int) (n0.P(view.getBottom()) + 0.5f)));
            } catch (JSONException e2) {
                if (a.a) {
                    e2.printStackTrace();
                }
                bVar = new c.a.n0.a.k.h.b(1001, "result JSONException");
            }
            c.a.n0.a.u.d.k("AbsMenuButtonHandle", "getMenuButtonBoundingClientRect call success, param valid, get param normally, result = " + bVar);
            return bVar;
        }
        return (c.a.n0.a.k.h.b) invokeL.objValue;
    }
}
