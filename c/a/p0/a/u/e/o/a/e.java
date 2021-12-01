package c.a.p0.a.u.e.o.a;

import android.view.View;
import androidx.annotation.NonNull;
import c.a.p0.a.z2.n0;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // c.a.p0.a.u.e.o.a.a
    public c.a.p0.a.u.h.b c(@NonNull c.a.p0.a.h0.g.d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dVar)) == null) {
            View r = c.a.p0.a.c1.b.i().r(dVar);
            if (r == null) {
                return new c.a.p0.a.u.h.b(1001);
            }
            return e(r);
        }
        return (c.a.p0.a.u.h.b) invokeL.objValue;
    }

    @Override // c.a.p0.a.u.e.o.a.a
    public c.a.p0.a.u.h.b d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? new c.a.p0.a.u.h.b(1001) : (c.a.p0.a.u.h.b) invokeI.objValue;
    }

    public final c.a.p0.a.u.h.b e(@NonNull View view) {
        InterceptResult invokeL;
        c.a.p0.a.u.h.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view)) == null) {
            try {
                bVar = new c.a.p0.a.u.h.b(0, b((int) (n0.Q(view.getLeft()) + 0.5f), (int) (n0.Q(view.getTop()) + 0.5f), (int) (n0.Q(view.getRight()) + 0.5f), (int) (n0.Q(view.getBottom()) + 0.5f)));
            } catch (JSONException e2) {
                if (a.a) {
                    e2.printStackTrace();
                }
                bVar = new c.a.p0.a.u.h.b(1001, "result JSONException");
            }
            c.a.p0.a.e0.d.k("AbsMenuButtonHandle", "getMenuButtonBoundingClientRect call success, param valid, get param normally, result = " + bVar);
            return bVar;
        }
        return (c.a.p0.a.u.h.b) invokeL.objValue;
    }
}
