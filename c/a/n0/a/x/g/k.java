package c.a.n0.a.x.g;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.p2.n0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.tieba.R;
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
    public static final boolean O0;
    public transient /* synthetic */ FieldHolder $fh;
    public int M0;
    public FrameLayout N0;

    /* loaded from: classes.dex */
    public class a extends c.a.n0.a.x.j.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ k f7059c;

        public a(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7059c = kVar;
        }

        @Override // c.a.n0.a.x.j.a, c.a.n0.a.x.j.d
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
            return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? c.a.n0.a.e2.g.h.a().getBoolean("SP_SwanAppWebModeFragment_DEBUG", false) : invokeV.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-622887100, "Lc/a/n0/a/x/g/k;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-622887100, "Lc/a/n0/a/x/g/k;");
                return;
            }
        }
        O0 = c.a.n0.a.a.a;
    }

    public k() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.M0 = 20;
    }

    @Override // c.a.n0.a.x.g.d
    public void K2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.F0 == null) {
                if (O0) {
                    Log.e("SwanAppWebModeFragment", Log.getStackTraceString(new Exception("mCurWebViewManager is null.")));
                    return;
                }
                return;
            }
            HashMap hashMap = new HashMap();
            String c2 = this.F0.c();
            hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, c2);
            c.a.n0.a.f.e.c cVar = this.G0;
            if (cVar != null) {
                hashMap.put("webViewUrl", cVar.getUrl());
            }
            c.a.n0.a.e0.d.c cVar2 = new c.a.n0.a.e0.d.c("sharebtn", hashMap);
            c.a.n0.a.w0.f.U().m(c2, cVar2);
            c.a.n0.a.u.d.i("SwanAppWebModeFragment", "share msg: " + cVar2.s().toString());
        }
    }

    @Override // c.a.n0.a.x.g.l, c.a.n0.a.x.g.d
    public void S1(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            super.S1(view);
            this.l0.setRightMenuStyle();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.l0.getLayoutParams();
            layoutParams.topMargin = n0.t();
            this.l0.setLayoutParams(layoutParams);
        }
    }

    @Override // c.a.n0.a.x.g.l
    public c.a.n0.a.x.j.d X2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new a(this) : (c.a.n0.a.x.j.d) invokeV.objValue;
    }

    @Override // c.a.n0.a.x.g.l
    public void Y2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            FragmentActivity activity = getActivity();
            if (this.n0 == null) {
                this.n0 = new SwanAppMenuHeaderView(getContext());
            }
            if (activity == null || this.m0 != null) {
                return;
            }
            this.m0 = new c.a.n0.n.f(activity, this.l0, g3(), c.a.n0.a.s0.a.K(), new c.a.n0.a.q2.h.b());
            new c.a.n0.a.a1.a(this.m0, this, this.n0).z();
        }
    }

    public URI e3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            try {
                return new URI(c.a.n0.a.r2.b.c().a().e());
            } catch (Exception e2) {
                if (O0) {
                    e2.printStackTrace();
                }
                return null;
            }
        }
        return (URI) invokeV.objValue;
    }

    @Override // c.a.n0.a.x.g.d
    public void f2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.f2();
            c.a.n0.a.r2.d.b.a().j();
        }
    }

    public URI f3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            try {
                return new URI(c.a.n0.a.r2.b.c().e());
            } catch (Exception e2) {
                if (O0) {
                    e2.printStackTrace();
                }
                return null;
            }
        }
        return (URI) invokeV.objValue;
    }

    public final int g3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (b2()) {
                return 19;
            }
            return this.M0;
        }
        return invokeV.intValue;
    }

    @Override // c.a.n0.a.x.g.l, c.a.n0.a.x.g.d
    public void h2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            Y2();
            SwanAppMenuHeaderView swanAppMenuHeaderView = this.n0;
            if (swanAppMenuHeaderView != null) {
                swanAppMenuHeaderView.setAttentionBtnStates(c.a.n0.a.z.b.a.n(c.a.n0.a.t1.d.J().getAppId()));
            }
            this.m0.u(c.a.n0.a.s0.a.M().a(), F1(), this.n0, false);
        }
    }

    public void h3(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.M0 = i;
        }
    }

    @Override // c.a.n0.a.x.g.l
    public c.a.n0.a.f.e.e m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? c.a.n0.a.x.u.g.U().f0().a(getContext()) : (c.a.n0.a.f.e.e) invokeV.objValue;
    }

    @Override // c.a.n0.a.x.g.d, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onResume();
            URI f3 = f3();
            URI e3 = e3();
            if (f3 == null || e3 == null) {
                return;
            }
            if (!TextUtils.equals(f3.getPath(), e3.getPath()) && !TextUtils.equals(f3.getQuery(), e3.getQuery())) {
                this.F0.loadUrl(e3.toString());
                if (O0) {
                    Log.i("SwanAppWebModeFragment", "onResume: refresh url " + e3.toString());
                }
                c.a.n0.a.r2.b.c().m("3");
                c.a.n0.a.r2.d.b.b("3");
                c.a.n0.a.r2.d.b.a().m();
                if (O0) {
                    Log.i("SwanAppWebModeFragment", "onResume: reset statistic for warm refresh.");
                    return;
                }
                return;
            }
            c.a.n0.a.d2.e.s(c.a.n0.a.t1.d.J().r().V());
            if (O0) {
                Log.i("SwanAppWebModeFragment", "onResume: warm without refresh.");
            }
        }
    }

    /* JADX WARN: Type inference failed for: r6v3, types: [c.a.n0.a.f.e.c] */
    @Override // c.a.n0.a.x.g.l, com.baidu.swan.support.v4.app.Fragment
    public View x0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048588, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d00e1, viewGroup, false);
            S1(inflate);
            c.a.n0.a.f.e.e m = m();
            this.F0 = m;
            m.c0(X2());
            this.G0 = this.F0.u();
            c.a.n0.a.r2.d.b.a().i(this.H0);
            c.a.n0.a.r2.b.c().m("0");
            this.F0.loadUrl(this.H0);
            FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R.id.obfuscated_res_0x7f0901aa);
            this.N0 = frameLayout;
            this.F0.l(frameLayout, this.G0.covertToView());
            U2(this.N0);
            if (R1()) {
                inflate = U1(inflate);
                v1(0, true);
            }
            n0.Q(getActivity());
            c.a.n0.a.r2.b.c().p(this.F0.c());
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }
}
