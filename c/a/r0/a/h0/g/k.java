package c.a.r0.a.h0.g;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.z2.n0;
import c.a.r0.n.n;
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
    public static final boolean S0;
    public transient /* synthetic */ FieldHolder $fh;
    public int Q0;
    public FrameLayout R0;

    /* loaded from: classes.dex */
    public class a extends c.a.r0.a.h0.j.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ k f6419c;

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
                    return;
                }
            }
            this.f6419c = kVar;
        }

        @Override // c.a.r0.a.h0.j.a, c.a.r0.a.h0.j.d
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
            return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? c.a.r0.a.o2.g.h.a().getBoolean("SP_SwanAppWebModeFragment_DEBUG", false) : invokeV.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1345034406, "Lc/a/r0/a/h0/g/k;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1345034406, "Lc/a/r0/a/h0/g/k;");
                return;
            }
        }
        S0 = c.a.r0.a.k.a;
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
        this.Q0 = 20;
    }

    @Override // c.a.r0.a.h0.g.d
    public void G2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.J0 == null) {
                if (S0) {
                    Log.getStackTraceString(new Exception("mCurWebViewManager is null."));
                    return;
                }
                return;
            }
            HashMap hashMap = new HashMap();
            String c2 = this.J0.c();
            hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, c2);
            c.a.r0.a.p.e.c cVar = this.K0;
            if (cVar != null) {
                hashMap.put("webViewUrl", cVar.getUrl());
            }
            c.a.r0.a.o0.d.c cVar2 = new c.a.r0.a.o0.d.c("sharebtn", hashMap);
            c.a.r0.a.g1.f.U().m(c2, cVar2);
            c.a.r0.a.e0.d.i("SwanAppWebModeFragment", "share msg: " + cVar2.s().toString());
        }
    }

    @Override // c.a.r0.a.h0.g.l, c.a.r0.a.h0.g.d
    public void O1(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            super.O1(view);
            this.k0.setRightMenuStyle();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.k0.getLayoutParams();
            layoutParams.topMargin = n0.t();
            this.k0.setLayoutParams(layoutParams);
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            FragmentActivity activity = getActivity();
            if (this.r0 == null) {
                this.r0 = new SwanAppMenuHeaderView(getContext());
            }
            if (activity == null || this.q0 != null) {
                return;
            }
            this.q0 = new n(activity, this.k0, c3(), c.a.r0.a.c1.a.K(), new c.a.r0.a.a3.h.b());
            new c.a.r0.a.k1.a(this.q0, this, this.r0).z();
        }
    }

    public URI a3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            try {
                return new URI(c.a.r0.a.b3.b.c().a().f());
            } catch (Exception e2) {
                if (S0) {
                    e2.printStackTrace();
                }
                return null;
            }
        }
        return (URI) invokeV.objValue;
    }

    @Override // c.a.r0.a.h0.g.d
    public void b2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.b2();
            c.a.r0.a.b3.d.b.a().j();
        }
    }

    public URI b3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            try {
                return new URI(c.a.r0.a.b3.b.c().e());
            } catch (Exception e2) {
                if (S0) {
                    e2.printStackTrace();
                }
                return null;
            }
        }
        return (URI) invokeV.objValue;
    }

    public final int c3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (X1()) {
                return 19;
            }
            return this.Q0;
        }
        return invokeV.intValue;
    }

    @Override // c.a.r0.a.h0.g.l, c.a.r0.a.h0.g.d
    public void d2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            U2();
            SwanAppMenuHeaderView swanAppMenuHeaderView = this.r0;
            if (swanAppMenuHeaderView != null) {
                swanAppMenuHeaderView.setAttentionBtnStates(c.a.r0.a.j0.b.a.n(c.a.r0.a.d2.d.J().getAppId()));
            }
            this.q0.x(c.a.r0.a.c1.a.M().a(), B1(), this.r0, false);
        }
    }

    public void d3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.Q0 = i2;
        }
    }

    @Override // c.a.r0.a.h0.g.l
    public c.a.r0.a.p.e.e l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? c.a.r0.a.h0.u.g.U().f0().a(getContext()) : (c.a.r0.a.p.e.e) invokeV.objValue;
    }

    @Override // c.a.r0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onResume();
            URI b3 = b3();
            URI a3 = a3();
            if (b3 == null || a3 == null) {
                return;
            }
            if (!TextUtils.equals(b3.getPath(), a3.getPath()) && !TextUtils.equals(b3.getQuery(), a3.getQuery())) {
                this.J0.loadUrl(a3.toString());
                if (S0) {
                    String str = "onResume: refresh url " + a3.toString();
                }
                c.a.r0.a.b3.b.c().m("3");
                c.a.r0.a.b3.d.b.b("3");
                c.a.r0.a.b3.d.b.a().m();
                boolean z = S0;
                return;
            }
            c.a.r0.a.n2.e.s(c.a.r0.a.d2.d.J().r().V());
            boolean z2 = S0;
        }
    }

    /* JADX WARN: Type inference failed for: r6v3, types: [c.a.r0.a.p.e.c] */
    @Override // c.a.r0.a.h0.g.l, com.baidu.swan.support.v4.app.Fragment
    public View w0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048588, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(c.a.r0.a.g.aiapps_webmode_webview_fragment, viewGroup, false);
            O1(inflate);
            c.a.r0.a.p.e.e l = l();
            this.J0 = l;
            l.a0(T2());
            this.K0 = this.J0.t();
            c.a.r0.a.b3.d.b.a().i(this.L0);
            c.a.r0.a.b3.b.c().m("0");
            this.J0.loadUrl(this.L0);
            FrameLayout frameLayout = (FrameLayout) inflate.findViewById(c.a.r0.a.f.aiapps_webView_container);
            this.R0 = frameLayout;
            this.J0.k(frameLayout, this.K0.covertToView());
            Q2(this.R0);
            if (N1()) {
                inflate = Q1(inflate);
                r1(0, true);
            }
            n0.R(getActivity());
            c.a.r0.a.b3.b.c().p(this.J0.c());
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }
}
