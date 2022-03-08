package c.a.p0.a.x.g;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.x.g.g;
import c.a.p0.r.a.a.m;
import c.a.p0.r.a.a.o;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment;
import com.baidu.swan.apps.core.slave.SwanAppWebViewWidget;
import com.baidu.swan.apps.view.SwanAppActionBar;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class l extends c.a.p0.a.x.g.d {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean P0;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.p0.a.f.e.e J0;
    public c.a.p0.a.f.e.c K0;
    public String L0;
    public String M0;
    public String N0;
    public boolean O0;

    /* loaded from: classes.dex */
    public class a extends SwanAppWebViewWidget {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l f0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(l lVar, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f0 = lVar;
        }

        @Override // com.baidu.swan.apps.core.slave.SwanAppWebViewWidget
        public boolean W1() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f0.O0 : invokeV.booleanValue;
        }

        @Override // com.baidu.swan.apps.core.slave.SwanAppWebViewWidget
        public boolean X1() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public class b extends c.a.p0.a.x.j.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ l f8395c;

        public b(l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8395c = lVar;
        }

        @Override // c.a.p0.a.x.j.a, c.a.p0.a.x.j.d
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (this.f8395c.R2(str) && this.f8395c.N0 != null) {
                    l lVar = this.f8395c;
                    lVar.k0.setTitle(lVar.N0);
                    return;
                }
                this.f8395c.k0.setTitle(str);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f8396e;

        public c(l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8396e = lVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f8396e.K0.canGoBack()) {
                    this.f8396e.K0.goBack();
                } else {
                    this.f8396e.b2();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public c.a.p0.a.c1.b a;

        /* renamed from: b  reason: collision with root package name */
        public JSONObject f8397b;

        public d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8397b = new JSONObject();
            this.a = c.a.p0.a.c1.b.e(str, str);
        }

        public d a(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
                try {
                    this.f8397b.put("should_check_domain", z);
                } catch (JSONException e2) {
                    if (l.P0) {
                        e2.printStackTrace();
                    }
                }
                return this;
            }
            return (d) invokeZ.objValue;
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.f4643f = this.f8397b.toString();
                l.X2("default_webview", this.a);
            }
        }

        public void c(m mVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mVar) == null) || mVar == null) {
                return;
            }
            this.a.f4643f = this.f8397b.toString();
            l W2 = l.W2(this.a, "default_webview");
            o a = mVar.a();
            a.a(R.id.ai_apps_error_layout, W2);
            a.d(null);
            a.e();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(78177509, "Lc/a/p0/a/x/g/l;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(78177509, "Lc/a/p0/a/x/g/l;");
                return;
            }
        }
        P0 = c.a.p0.a.a.a;
    }

    public l() {
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
        this.O0 = true;
    }

    public static boolean S2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            g V = c.a.p0.a.w0.f.U().V();
            if (V == null) {
                c.a.p0.a.u.d.i("SwanAppWebViewFragment", "close page failed");
                return false;
            }
            c.a.p0.a.u.d.i("SwanAppWebViewFragment", "page closed! ");
            g.b h2 = V.h();
            h2.n(g.f8376i, g.f8375h);
            h2.g();
            h2.a();
            return true;
        }
        return invokeV.booleanValue;
    }

    public static d V2(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) ? new d(str) : (d) invokeL.objValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static l W2(c.a.p0.a.c1.b bVar, String str) {
        InterceptResult invokeLL;
        char c2;
        l jVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, bVar, str)) == null) {
            switch (str.hashCode()) {
                case -1750679182:
                    if (str.equals("allianceLogin")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -718660690:
                    if (str.equals("web_mode")) {
                        c2 = 6;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -130826522:
                    if (str.equals("allianceChooseAddress")) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 113553927:
                    if (str.equals("wxPay")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 570452084:
                    if (str.equals("adLanding")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1221126139:
                    if (str.equals("default_webview")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1339472410:
                    if (str.equals("qrCodePay")) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            switch (c2) {
                case 0:
                    jVar = new c.a.p0.a.j1.j();
                    break;
                case 1:
                    jVar = new SwanAppAdLandingFragment();
                    break;
                case 2:
                    jVar = new l();
                    break;
                case 3:
                    jVar = new c.a.p0.a.i.a.e();
                    break;
                case 4:
                    jVar = new c.a.p0.a.i.a.j.a.c();
                    break;
                case 5:
                    jVar = new c.a.p0.a.j1.f();
                    break;
                case 6:
                    jVar = new k();
                    break;
                default:
                    boolean z = P0;
                    jVar = null;
                    break;
            }
            if (jVar != null) {
                jVar.Z2(bVar);
            }
            return jVar;
        }
        return (l) invokeLL.objValue;
    }

    public static boolean X2(String str, c.a.p0.a.c1.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, str, bVar)) == null) {
            g V = c.a.p0.a.w0.f.U().V();
            if (V == null) {
                c.a.p0.a.u.d.i("SwanAppWebViewFragment", "open page failed");
                return false;
            }
            c.a.p0.a.u.d.i("SwanAppWebViewFragment", "open page url=" + bVar.f4644g);
            g.b h2 = V.h();
            h2.n(g.f8374g, g.f8376i);
            h2.k(str, bVar).b();
            return true;
        }
        return invokeLL.booleanValue;
    }

    @Override // c.a.p0.a.x.g.d
    public boolean K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            c.a.p0.a.f.e.c cVar = this.K0;
            if (cVar == null || !cVar.canGoBack()) {
                return false;
            }
            this.K0.goBack();
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.p0.a.x.g.d
    public void O1(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            super.O1(view);
            n2(-1);
            w2(-16777216);
            SwanAppActionBar swanAppActionBar = this.k0;
            String str = this.N0;
            if (str == null) {
                str = "";
            }
            swanAppActionBar.setTitle(str);
            this.k0.setRightZoneVisibility(false);
            r2(true);
            this.k0.setLeftBackViewClickListener(new c(this));
        }
    }

    public void Q2(FrameLayout frameLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, frameLayout) == null) {
        }
    }

    public final boolean R2(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? TextUtils.equals(this.L0, str) || TextUtils.equals(this.L0.replace("http://", "").replace("https://", ""), str) : invokeL.booleanValue;
    }

    public c.a.p0.a.x.j.d T2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? new b(this) : (c.a.p0.a.x.j.d) invokeV.objValue;
    }

    public void U2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    @Override // c.a.p0.a.x.g.d
    public boolean W1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.p0.a.x.g.d
    public boolean Y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void Y2() {
        Bundle t;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (t = t()) == null) {
            return;
        }
        this.L0 = t.getString("url");
        String string = t.getString("params");
        this.M0 = string;
        if (TextUtils.isEmpty(string)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(this.M0);
            this.N0 = jSONObject.optString("fallback_title", null);
            this.O0 = jSONObject.optBoolean("should_check_domain", true);
        } catch (JSONException e2) {
            if (P0) {
                e2.printStackTrace();
            }
        }
    }

    public void Z2(c.a.p0.a.c1.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, bVar) == null) || bVar == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("url", bVar.f4644g);
        bundle.putString("params", bVar.f4643f);
        d1(bundle);
    }

    @Override // c.a.p0.a.x.g.d
    public void d2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.J0.V();
            U2();
            this.q0.w(c.a.p0.a.s0.a.M().a(), B1());
        }
    }

    @Override // c.a.p0.a.x.g.d, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, motionEvent)) == null) {
            c.a.p0.a.f.e.e eVar = this.J0;
            if (eVar != null) {
                return eVar.isSlidable(motionEvent);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public c.a.p0.a.f.e.e l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? new a(this, getContext()) : (c.a.p0.a.f.e.e) invokeV.objValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bundle) == null) {
            super.onCreate(bundle);
            Y2();
            if (P0) {
                String str = "onCreate() : " + this;
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            c.a.p0.a.f.e.e eVar = this.J0;
            if (eVar != null) {
                eVar.destroy();
                this.J0 = null;
            }
            super.onDestroy();
        }
    }

    /* JADX WARN: Type inference failed for: r6v3, types: [c.a.p0.a.f.e.c] */
    @Override // com.baidu.swan.support.v4.app.Fragment
    public View w0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048591, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.aiapps_webview_fragment, viewGroup, false);
            O1(inflate);
            c.a.p0.a.f.e.e l = l();
            this.J0 = l;
            l.a0(T2());
            this.K0 = this.J0.t();
            this.J0.loadUrl(this.L0);
            FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R.id.aiapps_webView_container);
            this.J0.k(frameLayout, this.K0.covertToView());
            Q2(frameLayout);
            if (N1()) {
                inflate = Q1(inflate);
            }
            return x1(inflate, this);
        }
        return (View) invokeLLL.objValue;
    }
}
