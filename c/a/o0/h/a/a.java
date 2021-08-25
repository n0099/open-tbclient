package c.a.o0.h.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import c.a.o0.a.h;
import c.a.o0.a.h0.g.g;
import c.a.o0.a.p.b.a.n;
import c.a.o0.a.z1.b.f.e;
import c.a.o0.f.i.l.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a implements f {
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

    @Override // c.a.o0.f.i.l.f
    public void a(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, jSONObject) == null) {
            g W = c.a.o0.a.g1.f.V().W();
            Context appContext = AppRuntime.getAppContext();
            if (W == null) {
                if (appContext != null) {
                    e.f(appContext, h.aiapps_open_fragment_failed_toast).F();
                    return;
                }
                return;
            }
            c.a.o0.a.l1.b g2 = c.a.o0.a.l1.b.g(str, str);
            g2.k(jSONObject.toString());
            g.b i2 = W.i("adLanding");
            i2.n(g.f5900g, g.f5902i);
            i2.k("adLanding", g2).b();
        }
    }

    @Override // c.a.o0.f.i.l.f
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? d.b() : invokeV.booleanValue;
    }

    @Override // c.a.o0.f.i.l.f
    public boolean c(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view)) == null) ? d.c(view) : invokeL.booleanValue;
    }

    @Override // c.a.o0.f.i.l.f
    public boolean d(View view, c.a.o0.f.i.i.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, view, aVar)) == null) ? d.a(view, new c.a.o0.a.l1.e.a.a(aVar.f(), aVar.g(), aVar.h(), aVar.e())) : invokeLL.booleanValue;
    }

    @Override // c.a.o0.f.i.l.f
    @SuppressLint({"SourceLockedOrientationActivity"})
    public void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && b()) {
            SwanAppActivity activity = c.a.o0.a.g1.f.V().getActivity();
            if (activity != null) {
                activity.setRequestedOrientation(1);
            }
            c.a.o0.a.g1.f.V().X().g(true);
        }
    }

    @Override // c.a.o0.f.i.l.f
    public boolean f(View view, c.a.o0.f.i.i.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, view, aVar)) == null) {
            n X = c.a.o0.a.g1.f.V().X();
            return X != null && X.a(view, new c.a.o0.a.l1.e.a.a(aVar.f(), aVar.g(), aVar.h(), aVar.e()));
        }
        return invokeLL.booleanValue;
    }

    @Override // c.a.o0.f.i.l.f
    public boolean removeView(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, view)) == null) ? d.d(view) : invokeL.booleanValue;
    }
}
