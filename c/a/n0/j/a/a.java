package c.a.n0.j.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import c.a.n0.a.f.b.a.n;
import c.a.n0.a.s1.b.f.e;
import c.a.n0.a.w0.f;
import c.a.n0.a.x.g.g;
import c.a.n0.h.a.e.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a implements g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public a() {
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

    @Override // c.a.n0.h.a.e.g
    public void a(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, jSONObject) == null) {
            c.a.n0.a.x.g.g V = f.U().V();
            Context appContext = AppRuntime.getAppContext();
            if (V == null) {
                if (appContext != null) {
                    e.f(appContext, R.string.obfuscated_res_0x7f0f019b).G();
                    return;
                }
                return;
            }
            c.a.n0.a.c1.b d2 = c.a.n0.a.c1.b.d(str, str);
            d2.h(jSONObject.toString());
            g.b i = V.i("adLanding");
            i.n(c.a.n0.a.x.g.g.f7048g, c.a.n0.a.x.g.g.i);
            i.k("adLanding", d2).b();
        }
    }

    @Override // c.a.n0.h.a.e.g
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? d.b() : invokeV.booleanValue;
    }

    @Override // c.a.n0.h.a.e.g
    public boolean c(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view)) == null) ? d.c(view) : invokeL.booleanValue;
    }

    @Override // c.a.n0.h.a.e.g
    public boolean d(View view, c.a.n0.h.a.a.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, view, aVar)) == null) ? d.a(view, new c.a.n0.a.c1.e.a.a(aVar.c(), aVar.d(), aVar.e(), aVar.b())) : invokeLL.booleanValue;
    }

    @Override // c.a.n0.h.a.e.g
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

    @Override // c.a.n0.h.a.e.g
    public boolean f(View view, c.a.n0.h.a.a.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, view, aVar)) == null) {
            n W = f.U().W();
            return W != null && W.a(view, new c.a.n0.a.c1.e.a.a(aVar.c(), aVar.d(), aVar.e(), aVar.b()));
        }
        return invokeLL.booleanValue;
    }

    @Override // c.a.n0.h.a.e.g
    public boolean removeView(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, view)) == null) ? d.d(view) : invokeL.booleanValue;
    }
}
