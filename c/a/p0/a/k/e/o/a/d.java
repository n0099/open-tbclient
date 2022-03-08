package c.a.p0.a.k.e.o.a;

import android.app.Application;
import androidx.annotation.NonNull;
import c.a.p0.a.p2.n0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
/* loaded from: classes.dex */
public final class d extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public d() {
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

    @Override // c.a.p0.a.k.e.o.a.a
    public c.a.p0.a.k.h.b c(@NonNull c.a.p0.a.x.g.d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dVar)) == null) ? e() : (c.a.p0.a.k.h.b) invokeL.objValue;
    }

    @Override // c.a.p0.a.k.e.o.a.a
    public c.a.p0.a.k.h.b d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? e() : (c.a.p0.a.k.h.b) invokeI.objValue;
    }

    public c.a.p0.a.k.h.b e() {
        InterceptResult invokeV;
        c.a.p0.a.k.h.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Application c2 = c.a.p0.a.s0.a.c();
            int i2 = (int) 28.4d;
            int Q = (int) n0.Q(n0.o(c2) - c2.getResources().getDimensionPixelSize(R.dimen.aiapps_action_bar_right_operation_margin));
            int i3 = Q - ((int) 75.53d);
            int Q2 = ((int) (n0.Q(n0.t()) + 0.5f)) + ((38 - i2) / 2);
            try {
                bVar = new c.a.p0.a.k.h.b(0, b(i3, Q2, Q, i2 + Q2));
            } catch (JSONException e2) {
                if (a.a) {
                    e2.printStackTrace();
                }
                bVar = new c.a.p0.a.k.h.b(1001, "result JSONException");
            }
            c.a.p0.a.u.d.k("AbsMenuButtonHandle", "getMenuButtonBoundingClientRect call success, param valid, get param abnormally, result = " + bVar);
            return bVar;
        }
        return (c.a.p0.a.k.h.b) invokeV.objValue;
    }
}
