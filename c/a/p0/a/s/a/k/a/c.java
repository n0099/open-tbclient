package c.a.p0.a.s.a.k.a;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import c.a.p0.a.f;
import c.a.p0.a.h0.g.k;
import c.a.p0.a.h0.u.g;
import c.a.p0.a.p.e.e;
import c.a.p0.k.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class c extends k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a extends c.a.p0.a.h0.j.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f8515c;

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
            this.f8515c = cVar;
        }

        @Override // c.a.p0.a.h0.j.a, c.a.p0.a.h0.j.d
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

    @Override // c.a.p0.a.h0.g.k, c.a.p0.a.h0.g.d
    public boolean J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            c.a.p0.a.p.e.c cVar = this.D0;
            if (cVar != null && cVar.canGoBack()) {
                this.D0.goBack();
                return true;
            }
            d.a().b(1);
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.p0.a.h0.g.k
    public c.a.p0.a.h0.j.d K2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new a(this) : (c.a.p0.a.h0.j.d) invokeV.objValue;
    }

    @Override // c.a.p0.a.h0.g.k
    public void L2() {
        FragmentActivity h2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (h2 = h()) != null && this.o0 == null) {
            this.o0 = new n(h2, this.n0, R2(), c.a.p0.a.c1.a.G(), new c.a.p0.a.w2.h.b());
            new c.a.p0.a.j1.a(this.o0, this).z();
        }
    }

    @Override // c.a.p0.a.h0.g.k, c.a.p0.a.h0.g.d
    public void O1(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            super.O1(view);
            this.n0.setRightZoneVisibility(true);
        }
    }

    public final int R2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? W1() ? 18 : 12 : invokeV.intValue;
    }

    @Override // c.a.p0.a.h0.g.k, c.a.p0.a.h0.g.d
    public boolean V1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.p0.a.h0.g.k
    public e l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? g.N().X().d(q()) : (e) invokeV.objValue;
    }

    /* JADX WARN: Type inference failed for: r6v3, types: [c.a.p0.a.p.e.c] */
    @Override // c.a.p0.a.h0.g.k, com.baidu.swan.support.v4.app.Fragment
    public View z0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048583, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(c.a.p0.a.g.aiapps_webview_fragment, viewGroup, false);
            O1(inflate);
            e l = l();
            this.C0 = l;
            l.Y(K2());
            this.D0 = this.C0.t();
            this.C0.loadUrl(this.E0);
            FrameLayout frameLayout = (FrameLayout) inflate.findViewById(f.aiapps_webView_container);
            this.C0.k(frameLayout, this.D0.covertToView());
            H2(frameLayout);
            return N1() ? Q1(inflate) : inflate;
        }
        return (View) invokeLLL.objValue;
    }
}
