package b.a.p0.a.h0.g;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.z2.n0;
import b.a.p0.n.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.URI;
import java.util.HashMap;
/* loaded from: classes.dex */
public class k extends l {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean R0;
    public transient /* synthetic */ FieldHolder $fh;
    public int P0;
    public FrameLayout Q0;

    /* loaded from: classes.dex */
    public class a extends b.a.p0.a.h0.j.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
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

    /* loaded from: classes.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? b.a.p0.a.o2.g.h.a().getBoolean("SP_SwanAppWebModeFragment_DEBUG", false) : invokeV.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1597403145, "Lb/a/p0/a/h0/g/k;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1597403145, "Lb/a/p0/a/h0/g/k;");
                return;
            }
        }
        R0 = b.a.p0.a.k.f6863a;
    }

    public k() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.P0 = 20;
    }

    @Override // b.a.p0.a.h0.g.d
    public void J2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.I0 == null) {
                if (R0) {
                    Log.getStackTraceString(new Exception("mCurWebViewManager is null."));
                    return;
                }
                return;
            }
            HashMap hashMap = new HashMap();
            String c2 = this.I0.c();
            hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, c2);
            b.a.p0.a.p.e.c cVar = this.J0;
            if (cVar != null) {
                hashMap.put("webViewUrl", cVar.getUrl());
            }
            b.a.p0.a.o0.d.c cVar2 = new b.a.p0.a.o0.d.c("sharebtn", hashMap);
            b.a.p0.a.g1.f.U().l(c2, cVar2);
            b.a.p0.a.e0.d.i("SwanAppWebModeFragment", "share msg: " + cVar2.s().toString());
        }
    }

    @Override // b.a.p0.a.h0.g.l, b.a.p0.a.h0.g.d
    public void R1(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            super.R1(view);
            this.o0.setRightMenuStyle();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.o0.getLayoutParams();
            layoutParams.topMargin = n0.t();
            this.o0.setLayoutParams(layoutParams);
        }
    }

    @Override // b.a.p0.a.h0.g.l
    public b.a.p0.a.h0.j.d W2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new a(this) : (b.a.p0.a.h0.j.d) invokeV.objValue;
    }

    @Override // b.a.p0.a.h0.g.l
    public void X2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            FragmentActivity activity = getActivity();
            if (this.q0 == null) {
                this.q0 = new SwanAppMenuHeaderView(getContext());
            }
            if (activity == null || this.p0 != null) {
                return;
            }
            this.p0 = new n(activity, this.o0, f3(), b.a.p0.a.c1.a.K(), new b.a.p0.a.a3.h.b());
            new b.a.p0.a.k1.a(this.p0, this, this.q0).z();
        }
    }

    public URI d3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            try {
                return new URI(b.a.p0.a.b3.b.c().a().f());
            } catch (Exception e2) {
                if (R0) {
                    e2.printStackTrace();
                }
                return null;
            }
        }
        return (URI) invokeV.objValue;
    }

    @Override // b.a.p0.a.h0.g.d
    public void e2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.e2();
            b.a.p0.a.b3.d.b.a().j();
        }
    }

    public URI e3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            try {
                return new URI(b.a.p0.a.b3.b.c().e());
            } catch (Exception e2) {
                if (R0) {
                    e2.printStackTrace();
                }
                return null;
            }
        }
        return (URI) invokeV.objValue;
    }

    public final int f3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (a2()) {
                return 19;
            }
            return this.P0;
        }
        return invokeV.intValue;
    }

    @Override // b.a.p0.a.h0.g.l, b.a.p0.a.h0.g.d
    public void g2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            X2();
            SwanAppMenuHeaderView swanAppMenuHeaderView = this.q0;
            if (swanAppMenuHeaderView != null) {
                swanAppMenuHeaderView.setAttentionBtnStates(b.a.p0.a.j0.b.a.n(b.a.p0.a.d2.d.J().getAppId()));
            }
            this.p0.t(b.a.p0.a.c1.a.M().a(), E1(), this.q0, false);
        }
    }

    public void g3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.P0 = i2;
        }
    }

    @Override // b.a.p0.a.h0.g.l
    public b.a.p0.a.p.e.e l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? b.a.p0.a.h0.u.g.U().f0().a(getContext()) : (b.a.p0.a.p.e.e) invokeV.objValue;
    }

    @Override // b.a.p0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onResume();
            URI e3 = e3();
            URI d3 = d3();
            if (e3 == null || d3 == null) {
                return;
            }
            if (!TextUtils.equals(e3.getPath(), d3.getPath()) && !TextUtils.equals(e3.getQuery(), d3.getQuery())) {
                this.I0.loadUrl(d3.toString());
                if (R0) {
                    String str = "onResume: refresh url " + d3.toString();
                }
                b.a.p0.a.b3.b.c().m("3");
                b.a.p0.a.b3.d.b.b("3");
                b.a.p0.a.b3.d.b.a().m();
                boolean z = R0;
                return;
            }
            b.a.p0.a.n2.e.s(b.a.p0.a.d2.d.J().r().V());
            boolean z2 = R0;
        }
    }

    /* JADX WARN: Type inference failed for: r6v3, types: [b.a.p0.a.p.e.c] */
    @Override // b.a.p0.a.h0.g.l, com.baidu.swan.support.v4.app.Fragment
    public View z0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048588, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(b.a.p0.a.g.aiapps_webmode_webview_fragment, viewGroup, false);
            R1(inflate);
            b.a.p0.a.p.e.e l = l();
            this.I0 = l;
            l.a0(W2());
            this.J0 = this.I0.t();
            b.a.p0.a.b3.d.b.a().i(this.K0);
            b.a.p0.a.b3.b.c().m("0");
            this.I0.loadUrl(this.K0);
            FrameLayout frameLayout = (FrameLayout) inflate.findViewById(b.a.p0.a.f.aiapps_webView_container);
            this.Q0 = frameLayout;
            this.I0.k(frameLayout, this.J0.covertToView());
            T2(this.Q0);
            if (Q1()) {
                inflate = T1(inflate);
                u1(0, true);
            }
            n0.R(getActivity());
            b.a.p0.a.b3.b.c().p(this.I0.c());
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }
}
