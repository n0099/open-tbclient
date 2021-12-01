package c.a.p0.a.s.a;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.h0.g.l;
import c.a.p0.n.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.alliance.login.SwanAppAllianceLoginHelper;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class e extends l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a extends c.a.p0.a.h0.j.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ e f7882c;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7882c = eVar;
        }

        @Override // c.a.p0.a.h0.j.a, c.a.p0.a.h0.j.d
        public boolean c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? super.c(str) : invokeL.booleanValue;
        }
    }

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

    /* JADX WARN: Type inference failed for: r6v3, types: [c.a.p0.a.p.e.c] */
    @Override // c.a.p0.a.h0.g.l, com.baidu.swan.support.v4.app.Fragment
    public View D0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(c.a.p0.a.g.aiapps_webview_fragment, viewGroup, false);
            V1(inflate);
            c.a.p0.a.p.e.e l = l();
            this.J0 = l;
            l.a0(a3());
            this.K0 = this.J0.t();
            this.J0.loadUrl(this.L0);
            FrameLayout frameLayout = (FrameLayout) inflate.findViewById(c.a.p0.a.f.aiapps_webView_container);
            this.J0.k(frameLayout, this.K0.covertToView());
            X2(frameLayout);
            return U1() ? X1(inflate) : inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // c.a.p0.a.h0.g.l, c.a.p0.a.h0.g.d
    public boolean K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            c.a.p0.a.p.e.c cVar = this.K0;
            if (cVar != null && cVar.canGoBack()) {
                this.K0.goBack();
                return true;
            }
            h3();
            SwanAppAllianceLoginHelper.f39311d.a(f.d(), f.a());
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.p0.a.h0.g.l, c.a.p0.a.h0.g.d
    public void V1(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
            super.V1(view);
            this.k0.setRightZoneVisibility(true);
        }
    }

    @Override // c.a.p0.a.h0.g.l
    public c.a.p0.a.h0.j.d a3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new a(this) : (c.a.p0.a.h0.j.d) invokeV.objValue;
    }

    @Override // c.a.p0.a.h0.g.l
    public void b3() {
        FragmentActivity activity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (activity = getActivity()) != null && this.q0 == null) {
            this.q0 = new n(activity, this.k0, i3(), c.a.p0.a.c1.a.K(), new c.a.p0.a.a3.h.b());
            new c.a.p0.a.k1.a(this.q0, this).z();
        }
    }

    @Override // c.a.p0.a.h0.g.l, c.a.p0.a.h0.g.d
    public boolean d2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void h3() {
        c.a.p0.a.m.a d2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || SwanAppAllianceLoginHelper.f39311d.c() || (d2 = SwanAppAllianceLoginHelper.f39311d.d()) == null) {
            return;
        }
        d2.onResult(-2);
    }

    public final int i3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? e2() ? 18 : 12 : invokeV.intValue;
    }

    @Override // c.a.p0.a.h0.g.l
    public c.a.p0.a.p.e.e l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? c.a.p0.a.h0.u.g.U().f0().f(getContext()) : (c.a.p0.a.p.e.e) invokeV.objValue;
    }

    @Override // c.a.p0.a.h0.g.l, com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            h3();
            super.onDestroy();
        }
    }
}
