package c.a.r0.a.s.a;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.h0.g.l;
import c.a.r0.n.n;
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
    public class a extends c.a.r0.a.h0.j.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ e f8873c;

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
            this.f8873c = eVar;
        }

        @Override // c.a.r0.a.h0.j.a, c.a.r0.a.h0.j.d
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

    @Override // c.a.r0.a.h0.g.l, c.a.r0.a.h0.g.d
    public boolean K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            c.a.r0.a.p.e.c cVar = this.K0;
            if (cVar != null && cVar.canGoBack()) {
                this.K0.goBack();
                return true;
            }
            a3();
            SwanAppAllianceLoginHelper.f38661d.a(f.d(), f.a());
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.r0.a.h0.g.l, c.a.r0.a.h0.g.d
    public void O1(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            super.O1(view);
            this.k0.setRightZoneVisibility(true);
        }
    }

    @Override // c.a.r0.a.h0.g.l
    public c.a.r0.a.h0.j.d T2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new a(this) : (c.a.r0.a.h0.j.d) invokeV.objValue;
    }

    @Override // c.a.r0.a.h0.g.l
    public void U2() {
        FragmentActivity activity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (activity = getActivity()) != null && this.q0 == null) {
            this.q0 = new n(activity, this.k0, b3(), c.a.r0.a.c1.a.K(), new c.a.r0.a.a3.h.b());
            new c.a.r0.a.k1.a(this.q0, this).z();
        }
    }

    @Override // c.a.r0.a.h0.g.l, c.a.r0.a.h0.g.d
    public boolean W1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void a3() {
        c.a.r0.a.m.a d2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || SwanAppAllianceLoginHelper.f38661d.c() || (d2 = SwanAppAllianceLoginHelper.f38661d.d()) == null) {
            return;
        }
        d2.onResult(-2);
    }

    public final int b3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? X1() ? 18 : 12 : invokeV.intValue;
    }

    @Override // c.a.r0.a.h0.g.l
    public c.a.r0.a.p.e.e l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? c.a.r0.a.h0.u.g.U().f0().f(getContext()) : (c.a.r0.a.p.e.e) invokeV.objValue;
    }

    @Override // c.a.r0.a.h0.g.l, com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            a3();
            super.onDestroy();
        }
    }

    /* JADX WARN: Type inference failed for: r6v3, types: [c.a.r0.a.p.e.c] */
    @Override // c.a.r0.a.h0.g.l, com.baidu.swan.support.v4.app.Fragment
    public View w0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048585, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(c.a.r0.a.g.aiapps_webview_fragment, viewGroup, false);
            O1(inflate);
            c.a.r0.a.p.e.e l = l();
            this.J0 = l;
            l.a0(T2());
            this.K0 = this.J0.t();
            this.J0.loadUrl(this.L0);
            FrameLayout frameLayout = (FrameLayout) inflate.findViewById(c.a.r0.a.f.aiapps_webView_container);
            this.J0.k(frameLayout, this.K0.covertToView());
            Q2(frameLayout);
            return N1() ? Q1(inflate) : inflate;
        }
        return (View) invokeLLL.objValue;
    }
}
