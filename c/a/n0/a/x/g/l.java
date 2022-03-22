package c.a.n0.a.x.g;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.x.g.g;
import c.a.n0.r.a.a.m;
import c.a.n0.r.a.a.o;
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
public class l extends c.a.n0.a.x.g.d {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean L0;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.n0.a.f.e.e F0;
    public c.a.n0.a.f.e.c G0;
    public String H0;
    public String I0;
    public String J0;
    public boolean K0;

    /* loaded from: classes.dex */
    public class a extends SwanAppWebViewWidget {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l h0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(l lVar, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h0 = lVar;
        }

        @Override // com.baidu.swan.apps.core.slave.SwanAppWebViewWidget
        public boolean X1() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.h0.K0 : invokeV.booleanValue;
        }

        @Override // com.baidu.swan.apps.core.slave.SwanAppWebViewWidget
        public boolean Y1() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public class b extends c.a.n0.a.x.j.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ l f7060c;

        public b(l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7060c = lVar;
        }

        @Override // c.a.n0.a.x.j.a, c.a.n0.a.x.j.d
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (this.f7060c.V2(str) && this.f7060c.J0 != null) {
                    l lVar = this.f7060c;
                    lVar.l0.setTitle(lVar.J0);
                    return;
                }
                this.f7060c.l0.setTitle(str);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l a;

        public c(l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.a.G0.canGoBack()) {
                    this.a.G0.goBack();
                } else {
                    this.a.f2();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public c.a.n0.a.c1.b a;

        /* renamed from: b  reason: collision with root package name */
        public JSONObject f7061b;

        public d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7061b = new JSONObject();
            this.a = c.a.n0.a.c1.b.d(str, str);
        }

        public d a(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
                try {
                    this.f7061b.put("should_check_domain", z);
                } catch (JSONException e2) {
                    if (l.L0) {
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
                this.a.f3947b = this.f7061b.toString();
                l.b3("default_webview", this.a);
            }
        }

        public void c(m mVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mVar) == null) || mVar == null) {
                return;
            }
            this.a.f3947b = this.f7061b.toString();
            l a3 = l.a3(this.a, "default_webview");
            o a = mVar.a();
            a.a(R.id.obfuscated_res_0x7f090176, a3);
            a.d(null);
            a.e();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-622887069, "Lc/a/n0/a/x/g/l;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-622887069, "Lc/a/n0/a/x/g/l;");
                return;
            }
        }
        L0 = c.a.n0.a.a.a;
    }

    public l() {
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
        this.K0 = true;
    }

    public static boolean W2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            g V = c.a.n0.a.w0.f.U().V();
            if (V == null) {
                c.a.n0.a.u.d.i("SwanAppWebViewFragment", "close page failed");
                return false;
            }
            c.a.n0.a.u.d.i("SwanAppWebViewFragment", "page closed! ");
            g.b h2 = V.h();
            h2.n(g.i, g.f7049h);
            h2.g();
            h2.a();
            return true;
        }
        return invokeV.booleanValue;
    }

    public static d Z2(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) ? new d(str) : (d) invokeL.objValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static l a3(c.a.n0.a.c1.b bVar, String str) {
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
                    jVar = new c.a.n0.a.j1.j();
                    break;
                case 1:
                    jVar = new SwanAppAdLandingFragment();
                    break;
                case 2:
                    jVar = new l();
                    break;
                case 3:
                    jVar = new c.a.n0.a.i.a.e();
                    break;
                case 4:
                    jVar = new c.a.n0.a.i.a.j.a.c();
                    break;
                case 5:
                    jVar = new c.a.n0.a.j1.f();
                    break;
                case 6:
                    jVar = new k();
                    break;
                default:
                    if (L0) {
                        Log.e("SwanAppWebViewFragment", "error type of SwanAppWebViewFragment!");
                    }
                    jVar = null;
                    break;
            }
            if (jVar != null) {
                jVar.d3(bVar);
            }
            return jVar;
        }
        return (l) invokeLL.objValue;
    }

    public static boolean b3(String str, c.a.n0.a.c1.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, str, bVar)) == null) {
            g V = c.a.n0.a.w0.f.U().V();
            if (V == null) {
                c.a.n0.a.u.d.i("SwanAppWebViewFragment", "open page failed");
                return false;
            }
            c.a.n0.a.u.d.i("SwanAppWebViewFragment", "open page url=" + bVar.f3948c);
            g.b h2 = V.h();
            h2.n(g.f7048g, g.i);
            h2.k(str, bVar).b();
            return true;
        }
        return invokeLL.booleanValue;
    }

    @Override // c.a.n0.a.x.g.d
    public boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            c.a.n0.a.f.e.c cVar = this.G0;
            if (cVar == null || !cVar.canGoBack()) {
                return false;
            }
            this.G0.goBack();
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.n0.a.x.g.d
    public void S1(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            super.S1(view);
            r2(-1);
            A2(-16777216);
            SwanAppActionBar swanAppActionBar = this.l0;
            String str = this.J0;
            if (str == null) {
                str = "";
            }
            swanAppActionBar.setTitle(str);
            this.l0.setRightZoneVisibility(false);
            v2(true);
            this.l0.setLeftBackViewClickListener(new c(this));
        }
    }

    public void U2(FrameLayout frameLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, frameLayout) == null) {
        }
    }

    public final boolean V2(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? TextUtils.equals(this.H0, str) || TextUtils.equals(this.H0.replace("http://", "").replace("https://", ""), str) : invokeL.booleanValue;
    }

    public c.a.n0.a.x.j.d X2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? new b(this) : (c.a.n0.a.x.j.d) invokeV.objValue;
    }

    public void Y2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    @Override // c.a.n0.a.x.g.d
    public boolean a2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.n0.a.x.g.d
    public boolean c2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void c3() {
        Bundle p;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (p = p()) == null) {
            return;
        }
        this.H0 = p.getString("url");
        String string = p.getString("params");
        this.I0 = string;
        if (TextUtils.isEmpty(string)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(this.I0);
            this.J0 = jSONObject.optString("fallback_title", null);
            this.K0 = jSONObject.optBoolean("should_check_domain", true);
        } catch (JSONException e2) {
            if (L0) {
                e2.printStackTrace();
            }
        }
    }

    public void d3(c.a.n0.a.c1.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, bVar) == null) || bVar == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("url", bVar.f3948c);
        bundle.putString("params", bVar.f3947b);
        h1(bundle);
    }

    @Override // c.a.n0.a.x.g.d
    public void h2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.F0.W();
            Y2();
            this.m0.t(c.a.n0.a.s0.a.M().a(), F1());
        }
    }

    @Override // c.a.n0.a.x.g.d, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, motionEvent)) == null) {
            c.a.n0.a.f.e.e eVar = this.F0;
            if (eVar != null) {
                return eVar.isSlidable(motionEvent);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public c.a.n0.a.f.e.e m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? new a(this, getContext()) : (c.a.n0.a.f.e.e) invokeV.objValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void u0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bundle) == null) {
            super.u0(bundle);
            c3();
            if (L0) {
                Log.d("SwanAppWebViewFragment", "onCreate() : " + this);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r6v3, types: [c.a.n0.a.f.e.c] */
    @Override // com.baidu.swan.support.v4.app.Fragment
    public View x0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048590, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d00e2, viewGroup, false);
            S1(inflate);
            c.a.n0.a.f.e.e m = m();
            this.F0 = m;
            m.c0(X2());
            this.G0 = this.F0.u();
            this.F0.loadUrl(this.H0);
            FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R.id.obfuscated_res_0x7f0901aa);
            this.F0.l(frameLayout, this.G0.covertToView());
            U2(frameLayout);
            if (R1()) {
                inflate = U1(inflate);
            }
            return B1(inflate, this);
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            c.a.n0.a.f.e.e eVar = this.F0;
            if (eVar != null) {
                eVar.destroy();
                this.F0 = null;
            }
            super.y0();
        }
    }
}
