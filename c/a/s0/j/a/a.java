package c.a.s0.j.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import c.a.s0.a.c2.b.f.e;
import c.a.s0.a.g1.f;
import c.a.s0.a.h;
import c.a.s0.a.h0.g.g;
import c.a.s0.a.p.b.a.n;
import c.a.s0.h.i.m.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a implements g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public a() {
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

    @Override // c.a.s0.h.i.m.g
    public void a(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, jSONObject) == null) {
            c.a.s0.a.h0.g.g V = f.U().V();
            Context appContext = AppRuntime.getAppContext();
            if (V == null) {
                if (appContext != null) {
                    e.f(appContext, h.aiapps_open_fragment_failed_toast).G();
                    return;
                }
                return;
            }
            c.a.s0.a.m1.b e2 = c.a.s0.a.m1.b.e(str, str);
            e2.i(jSONObject.toString());
            g.b i2 = V.i("adLanding");
            i2.n(c.a.s0.a.h0.g.g.f6641g, c.a.s0.a.h0.g.g.f6643i);
            i2.k("adLanding", e2).b();
        }
    }

    @Override // c.a.s0.h.i.m.g
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? d.b() : invokeV.booleanValue;
    }

    @Override // c.a.s0.h.i.m.g
    public boolean c(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view)) == null) ? d.c(view) : invokeL.booleanValue;
    }

    @Override // c.a.s0.h.i.m.g
    public boolean d(View view, c.a.s0.h.i.i.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, view, aVar)) == null) ? d.a(view, new c.a.s0.a.m1.e.a.a(aVar.c(), aVar.e(), aVar.f(), aVar.b())) : invokeLL.booleanValue;
    }

    @Override // c.a.s0.h.i.m.g
    @SuppressLint({"SourceLockedOrientationActivity"})
    public void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && b()) {
            SwanAppActivity activity = f.U().getActivity();
            if (activity != null) {
                activity.setRequestedOrientation(1);
            }
            f.U().W().g(true);
        }
    }

    @Override // c.a.s0.h.i.m.g
    public boolean f(View view, c.a.s0.h.i.i.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, view, aVar)) == null) {
            n W = f.U().W();
            return W != null && W.a(view, new c.a.s0.a.m1.e.a.a(aVar.c(), aVar.e(), aVar.f(), aVar.b()));
        }
        return invokeLL.booleanValue;
    }

    @Override // c.a.s0.h.i.m.g
    public boolean removeView(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, view)) == null) ? d.d(view) : invokeL.booleanValue;
    }
}
