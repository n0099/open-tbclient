package c.a.p0.a.i.a.j.a;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import c.a.p0.a.f.e.e;
import c.a.p0.a.x.g.l;
import c.a.p0.a.x.u.g;
import c.a.p0.n.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class c extends l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a extends c.a.p0.a.x.j.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f5714c;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5714c = cVar;
        }

        @Override // c.a.p0.a.x.j.a, c.a.p0.a.x.j.d
        public boolean c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? super.c(str) : invokeL.booleanValue;
        }
    }

    public c() {
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

    @Override // c.a.p0.a.x.g.l, c.a.p0.a.x.g.d
    public boolean K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            c.a.p0.a.f.e.c cVar = this.K0;
            if (cVar != null && cVar.canGoBack()) {
                this.K0.goBack();
                return true;
            }
            d.a().b(1);
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.p0.a.x.g.l, c.a.p0.a.x.g.d
    public void O1(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            super.O1(view);
            this.k0.setRightZoneVisibility(true);
        }
    }

    @Override // c.a.p0.a.x.g.l
    public c.a.p0.a.x.j.d T2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new a(this) : (c.a.p0.a.x.j.d) invokeV.objValue;
    }

    @Override // c.a.p0.a.x.g.l
    public void U2() {
        FragmentActivity activity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (activity = getActivity()) != null && this.q0 == null) {
            this.q0 = new f(activity, this.k0, a3(), c.a.p0.a.s0.a.K(), new c.a.p0.a.q2.h.b());
            new c.a.p0.a.a1.a(this.q0, this).z();
        }
    }

    @Override // c.a.p0.a.x.g.l, c.a.p0.a.x.g.d
    public boolean W1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public final int a3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? X1() ? 18 : 12 : invokeV.intValue;
    }

    @Override // c.a.p0.a.x.g.l
    public e l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? g.U().f0().g(getContext()) : (e) invokeV.objValue;
    }

    /* JADX WARN: Type inference failed for: r6v3, types: [c.a.p0.a.f.e.c] */
    @Override // c.a.p0.a.x.g.l, com.baidu.swan.support.v4.app.Fragment
    public View w0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048583, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.aiapps_webview_fragment, viewGroup, false);
            O1(inflate);
            e l = l();
            this.J0 = l;
            l.a0(T2());
            this.K0 = this.J0.t();
            this.J0.loadUrl(this.L0);
            FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R.id.aiapps_webView_container);
            this.J0.k(frameLayout, this.K0.covertToView());
            Q2(frameLayout);
            return N1() ? Q1(inflate) : inflate;
        }
        return (View) invokeLLL.objValue;
    }
}
