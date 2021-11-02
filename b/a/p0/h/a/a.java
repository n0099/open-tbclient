package b.a.p0.h.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import b.a.p0.a.h;
import b.a.p0.a.h0.g.g;
import b.a.p0.a.p.b.a.n;
import b.a.p0.a.z1.b.f.e;
import b.a.p0.f.i.l.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes4.dex */
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

    @Override // b.a.p0.f.i.l.f
    public void a(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, jSONObject) == null) {
            g U = b.a.p0.a.g1.f.T().U();
            Context appContext = AppRuntime.getAppContext();
            if (U == null) {
                if (appContext != null) {
                    e.f(appContext, h.aiapps_open_fragment_failed_toast).F();
                    return;
                }
                return;
            }
            b.a.p0.a.l1.b e2 = b.a.p0.a.l1.b.e(str, str);
            e2.i(jSONObject.toString());
            g.b i2 = U.i("adLanding");
            i2.n(g.f5280g, g.f5282i);
            i2.k("adLanding", e2).b();
        }
    }

    @Override // b.a.p0.f.i.l.f
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? d.b() : invokeV.booleanValue;
    }

    @Override // b.a.p0.f.i.l.f
    public boolean c(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view)) == null) ? d.c(view) : invokeL.booleanValue;
    }

    @Override // b.a.p0.f.i.l.f
    public boolean d(View view, b.a.p0.f.i.i.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, view, aVar)) == null) ? d.a(view, new b.a.p0.a.l1.e.a.a(aVar.c(), aVar.e(), aVar.f(), aVar.b())) : invokeLL.booleanValue;
    }

    @Override // b.a.p0.f.i.l.f
    @SuppressLint({"SourceLockedOrientationActivity"})
    public void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && b()) {
            SwanAppActivity activity = b.a.p0.a.g1.f.T().getActivity();
            if (activity != null) {
                activity.setRequestedOrientation(1);
            }
            b.a.p0.a.g1.f.T().V().g(true);
        }
    }

    @Override // b.a.p0.f.i.l.f
    public boolean f(View view, b.a.p0.f.i.i.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, view, aVar)) == null) {
            n V = b.a.p0.a.g1.f.T().V();
            return V != null && V.a(view, new b.a.p0.a.l1.e.a.a(aVar.c(), aVar.e(), aVar.f(), aVar.b()));
        }
        return invokeLL.booleanValue;
    }

    @Override // b.a.p0.f.i.l.f
    public boolean removeView(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, view)) == null) ? d.d(view) : invokeL.booleanValue;
    }
}
