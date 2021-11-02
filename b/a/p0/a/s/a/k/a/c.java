package b.a.p0.a.s.a.k.a;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import b.a.p0.a.f;
import b.a.p0.a.h0.g.k;
import b.a.p0.a.h0.u.g;
import b.a.p0.a.p.e.e;
import b.a.p0.k.n;
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
    public class a extends b.a.p0.a.h0.j.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }

        @Override // b.a.p0.a.h0.j.a, b.a.p0.a.h0.j.d
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

    @Override // b.a.p0.a.h0.g.k
    public b.a.p0.a.h0.j.d G2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new a(this) : (b.a.p0.a.h0.j.d) invokeV.objValue;
    }

    @Override // b.a.p0.a.h0.g.k
    public void H2() {
        FragmentActivity activity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (activity = getActivity()) != null && this.o0 == null) {
            this.o0 = new n(activity, this.n0, N2(), b.a.p0.a.c1.a.G(), new b.a.p0.a.w2.h.b());
            new b.a.p0.a.j1.a(this.o0, this).z();
        }
    }

    @Override // b.a.p0.a.h0.g.k, b.a.p0.a.h0.g.d
    public boolean I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            b.a.p0.a.p.e.c cVar = this.D0;
            if (cVar != null && cVar.canGoBack()) {
                this.D0.goBack();
                return true;
            }
            d.a().b(1);
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.p0.a.h0.g.k, b.a.p0.a.h0.g.d
    public void K1(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            super.K1(view);
            this.n0.setRightZoneVisibility(true);
        }
    }

    public final int N2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? S1() ? 18 : 12 : invokeV.intValue;
    }

    @Override // b.a.p0.a.h0.g.k, b.a.p0.a.h0.g.d
    public boolean R1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.p0.a.h0.g.k
    public e k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? g.M().W().d(getContext()) : (e) invokeV.objValue;
    }

    /* JADX WARN: Type inference failed for: r6v3, types: [b.a.p0.a.p.e.c] */
    @Override // b.a.p0.a.h0.g.k, com.baidu.swan.support.v4.app.Fragment
    public View w0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048583, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(b.a.p0.a.g.aiapps_webview_fragment, viewGroup, false);
            K1(inflate);
            e k = k();
            this.C0 = k;
            k.X(G2());
            this.D0 = this.C0.s();
            this.C0.loadUrl(this.E0);
            FrameLayout frameLayout = (FrameLayout) inflate.findViewById(f.aiapps_webView_container);
            this.C0.j(frameLayout, this.D0.covertToView());
            D2(frameLayout);
            return J1() ? M1(inflate) : inflate;
        }
        return (View) invokeLLL.objValue;
    }
}
