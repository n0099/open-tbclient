package b.a.p0.a.a2;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.a2.i;
import b.a.p0.a.f1.e.b;
import b.a.p0.a.v2.q0;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class e extends m {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean y;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public final String f3961f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f3962g;

    /* renamed from: h  reason: collision with root package name */
    public SwanAppConfigData f3963h;

    /* renamed from: i  reason: collision with root package name */
    public b.a.p0.a.a2.n.a f3964i;
    public b.a.p0.a.k2.c j;
    public b.a.p0.a.k2.f.d k;
    public b.a.p0.a.e2.a l;
    public b.a.p0.a.m.b m;
    public b.a.p0.a.n1.j n;
    public HttpManager o;
    public b.a.p0.a.b2.a.a p;
    public b.a.p0.a.i1.c.c q;
    public b.a.p0.a.n1.k r;
    public g s;
    public Map<String, String> t;
    public final k u;
    public final b.a v;
    public boolean w;
    public String x;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1318160670, "Lb/a/p0/a/a2/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1318160670, "Lb/a/p0/a/a2/e;");
                return;
            }
        }
        y = b.a.p0.a.k.f6397a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(h hVar, String str) {
        super(hVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hVar, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((h) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.u = new k(this);
        this.v = new b.a();
        boolean z = false;
        this.w = false;
        str = str == null ? "" : str;
        this.f3961f = str;
        z = (!TextUtils.isEmpty(str) || TextUtils.equals(this.f3961f, "swan_id_unknown")) ? true : true;
        this.f3962g = z;
        if (z) {
            b.a.p0.a.b2.a.a aVar = new b.a.p0.a.b2.a.a();
            this.p = aVar;
            aVar.f(this.f3961f);
        }
        b.a.p0.a.e0.d.h("SwanApp", "new SwanApp id = " + this.f3961f + StringUtil.ARRAY_ELEMENT_SEPARATOR + Log.getStackTraceString(new RuntimeException("SwanApp log")));
    }

    public static e P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            d g2 = d.g();
            if (g2.C()) {
                return g2.r();
            }
            return null;
        }
        return (e) invokeV.objValue;
    }

    @Deprecated
    public static String U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? d.g().getAppId() : (String) invokeV.objValue;
    }

    @Deprecated
    public static e i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? P() : (e) invokeV.objValue;
    }

    @Override // b.a.p0.a.a2.m, b.a.p0.a.a2.h
    public void A(i.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            super.A((i.a) aVar.update(G()));
        }
    }

    @Override // b.a.p0.a.a2.m, b.a.p0.a.a2.h
    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f3962g : invokeV.booleanValue;
    }

    public b.a.p0.a.i1.c.c D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.q == null) {
                this.q = new b.a.p0.a.i1.c.c(this);
            }
            return this.q;
        }
        return (b.a.p0.a.i1.c.c) invokeV.objValue;
    }

    public SwanAppConfigData E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f3963h : (SwanAppConfigData) invokeV.objValue;
    }

    public String F(String str) {
        InterceptResult invokeL;
        SwanAppConfigData.k kVar;
        Map<String, String> map;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            SwanAppConfigData swanAppConfigData = this.f3963h;
            if (swanAppConfigData == null || (kVar = swanAppConfigData.f44231d) == null || (map = kVar.f44269a) == null) {
                return null;
            }
            return map.get(str);
        }
        return (String) invokeL.objValue;
    }

    public final Bundle G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("mAppId", this.f3961f);
            return bundle;
        }
        return (Bundle) invokeV.objValue;
    }

    public b.a.p0.a.a2.n.a H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f3964i : (b.a.p0.a.a2.n.a) invokeV.objValue;
    }

    @NonNull
    public g I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.s == null) {
                this.s = new g(this);
            }
            return this.s;
        }
        return (g) invokeV.objValue;
    }

    public String J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            b.a K = K();
            return K != null ? h(K.getType()) : "0";
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public b.a K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.v : (b.a) invokeV.objValue;
    }

    @Nullable
    public String L(String str) {
        InterceptResult invokeL;
        Map<String, String> map;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            if (TextUtils.isEmpty(str) || (map = this.t) == null) {
                return null;
            }
            return map.get(str);
        }
        return (String) invokeL.objValue;
    }

    @NonNull
    @Deprecated
    public b.a M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? K() : (b.a) invokeV.objValue;
    }

    public String N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? K().J() : (String) invokeV.objValue;
    }

    public synchronized b.a.p0.a.n1.j O() {
        InterceptResult invokeV;
        b.a.p0.a.n1.j jVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            synchronized (this) {
                if (this.n == null) {
                    this.n = new b.a.p0.a.n1.j(this);
                }
                jVar = this.n;
            }
            return jVar;
        }
        return (b.a.p0.a.n1.j) invokeV.objValue;
    }

    public String Q(String str) {
        InterceptResult invokeL;
        SwanAppConfigData.j jVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            SwanAppConfigData swanAppConfigData = this.f3963h;
            if (swanAppConfigData == null || (jVar = swanAppConfigData.f44230c) == null || jVar.f44265c == null) {
                return null;
            }
            return this.f3963h.f44230c.f44265c.get(b.a.p0.a.c2.f.p0.j.b(str));
        }
        return (String) invokeL.objValue;
    }

    public String R(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            SwanAppConfigData swanAppConfigData = this.f3963h;
            return swanAppConfigData != null ? swanAppConfigData.g(str) : "";
        }
        return (String) invokeL.objValue;
    }

    @NonNull
    public b.a.p0.a.e2.a S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (this.l == null) {
                this.l = new b.a.p0.a.e2.a(this);
            }
            return this.l;
        }
        return (b.a.p0.a.e2.a) invokeV.objValue;
    }

    public b.a.p0.a.k2.c T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.j == null) {
                this.j = new b.a.p0.a.k2.c(this);
            }
            return this.j;
        }
        return (b.a.p0.a.k2.c) invokeV.objValue;
    }

    public b.a.p0.a.k2.f.d V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.k == null) {
                if (l0()) {
                    this.k = new b.a.p0.a.r0.l();
                } else {
                    this.k = new b.a.p0.a.k2.f.f();
                }
            }
            return this.k;
        }
        return (b.a.p0.a.k2.f.d) invokeV.objValue;
    }

    public synchronized HttpManager W() {
        InterceptResult invokeV;
        HttpManager httpManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            synchronized (this) {
                if (this.o == null) {
                    this.o = b.a.p0.a.c1.b.l().a();
                }
                httpManager = this.o;
            }
            return httpManager;
        }
        return (HttpManager) invokeV.objValue;
    }

    public String X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.x : (String) invokeV.objValue;
    }

    public String Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? K().s1() : (String) invokeV.objValue;
    }

    public b.a.p0.a.b2.a.a Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (this.p == null) {
                this.p = new b.a.p0.a.b2.a.a();
            }
            return this.p;
        }
        return (b.a.p0.a.b2.a.a) invokeV.objValue;
    }

    public b.a.p0.a.n1.k a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            if (this.r == null) {
                this.r = new b.a.p0.a.n1.k();
            }
            return this.r;
        }
        return (b.a.p0.a.n1.k) invokeV.objValue;
    }

    public boolean b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            b.a.p0.a.e0.d.h("SwanApp", "SwanAppActivity isAppHasLaunch:" + this.x);
            return h.g0.contains(this.x);
        }
        return invokeV.booleanValue;
    }

    public boolean c0() {
        InterceptResult invokeV;
        b.a.p0.a.t0.c frame;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            if (b.a.p0.a.h0.o.e.a.f()) {
                SwanAppActivity x = x();
                if (x == null || x.isFinishing() || x.isDestroyed() || (frame = x.getFrame()) == null) {
                    return true;
                }
                return !frame.P().hasStarted();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? f0(b.a.p0.a.g1.f.T().S()) : invokeV.booleanValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.f3962g && this.u.a0() && l() > -1 : invokeV.booleanValue;
    }

    public boolean e0() {
        InterceptResult invokeV;
        b.a.p0.a.t0.c frame;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            SwanAppActivity x = x();
            if (x == null || (frame = x.getFrame()) == null) {
                return false;
            }
            return frame.P().hasCreated();
        }
        return invokeV.booleanValue;
    }

    public e f(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048605, this, z)) == null) {
            this.w = z;
            q("event_first_action_launched");
            return this;
        }
        return (e) invokeZ.objValue;
    }

    public boolean f0(String str) {
        InterceptResult invokeL;
        SwanAppConfigData swanAppConfigData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, str)) == null) {
            if (TextUtils.isEmpty(str) || (swanAppConfigData = this.f3963h) == null) {
                return false;
            }
            return swanAppConfigData.n(str);
        }
        return invokeL.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.w : invokeV.booleanValue;
    }

    public boolean g0(String str) {
        InterceptResult invokeL;
        SwanAppConfigData swanAppConfigData;
        SwanAppConfigData.d dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, str)) == null) {
            if (TextUtils.isEmpty(str) || (swanAppConfigData = this.f3963h) == null || (dVar = swanAppConfigData.f44229b) == null) {
                return false;
            }
            return dVar.c(str);
        }
        return invokeL.booleanValue;
    }

    @Deprecated
    public Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? x() : (Activity) invokeV.objValue;
    }

    @Override // b.a.p0.a.a2.m, b.a.p0.a.a2.h
    public String getAppId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.f3961f : (String) invokeV.objValue;
    }

    public final String h(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048611, this, i2)) == null) {
            if (i2 == 0) {
                b.a aVar = this.v;
                String t1 = aVar != null ? aVar.t1() : "";
                if (TextUtils.isEmpty(t1)) {
                    t1 = Y();
                }
                String f2 = q0.f(t1);
                Object[] objArr = new Object[1];
                objArr[0] = TextUtils.isEmpty(f2) ? " version is empty " : f2;
                b.a.p0.a.e0.d.a("SwanApp", objArr);
                return f2;
            }
            return "0";
        }
        return (String) invokeI.objValue;
    }

    public boolean h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.u.Z() : invokeV.booleanValue;
    }

    public boolean i0(String str) {
        InterceptResult invokeL;
        SwanAppConfigData swanAppConfigData;
        SwanAppConfigData.j jVar;
        Map<String, Boolean> map;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, str)) == null) {
            if (TextUtils.isEmpty(str) || (swanAppConfigData = this.f3963h) == null || (jVar = swanAppConfigData.f44230c) == null || (map = jVar.f44264b) == null || !map.containsKey(str)) {
                return false;
            }
            boolean z = y;
            return this.f3963h.f44230c.f44264b.get(str).booleanValue();
        }
        return invokeL.booleanValue;
    }

    public b.a.p0.a.m.b j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            if (this.m == null) {
                this.m = new b.a.p0.a.m.b(this);
            }
            return this.m;
        }
        return (b.a.p0.a.m.b) invokeV.objValue;
    }

    public boolean j0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048615, this, str)) == null) ? new File(b.a.p0.a.g1.f.T().z(), str).exists() : invokeL.booleanValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? K().H() : (String) invokeV.objValue;
    }

    public boolean k0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048617, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return b.a.p0.n.g.a.h().m(this.f3961f, Y(), str);
        }
        return invokeL.booleanValue;
    }

    @Override // b.a.p0.a.a2.m, b.a.p0.a.a2.h
    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            if (this.f3962g) {
                return K().F();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public boolean l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? K().F() == 1 : invokeV.booleanValue;
    }

    public boolean m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? TextUtils.equals("update_tag_by_app_launch", this.x) : invokeV.booleanValue;
    }

    @Override // b.a.p0.a.a2.m, b.a.p0.a.a2.h
    public SwanAppCores n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            SwanAppCores swanAppCores = new SwanAppCores();
            swanAppCores.setSwanCoreVersion(K().h0());
            swanAppCores.setExtensionCore(K().N());
            return swanAppCores;
        }
        return (SwanAppCores) invokeV.objValue;
    }

    public void n0(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, activity) == null) {
            S().w(activity);
        }
    }

    public String o0(String... strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048623, this, strArr)) == null) {
            if (y) {
                String str = "——> release client Id " + this.f3961f;
            }
            SwanAppActivity x = x();
            if (x != null && !x.isDestroyed() && !x.isFinishing() && x.hasActivedFrame()) {
                x.reset(strArr);
            }
            b.a.p0.a.g1.f.a0();
            g gVar = this.s;
            if (gVar != null) {
                gVar.g();
            }
            b.a.p0.t.d.j(b.a.p0.a.k2.b.x(this.f3961f));
            b.a.p0.a.i1.c.c cVar = this.q;
            if (cVar != null) {
                cVar.E();
            }
            b.a.p0.a.b2.a.a aVar = this.p;
            if (aVar != null) {
                aVar.g();
            }
            b.a.p0.a.n1.k kVar = this.r;
            if (kVar != null) {
                kVar.d();
            }
            this.j = null;
            this.l = null;
            this.o = null;
            this.w = false;
            return this.f3961f;
        }
        return (String) invokeL.objValue;
    }

    public boolean p0(Bundle bundle, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048624, this, bundle, str, z)) == null) {
            boolean contains = h.g0.contains(str);
            b.a K = K();
            HybridUbcFlow p = b.a.p0.a.r1.h.p("startup");
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("swan_app_update_info_start");
            ubcFlowEvent.a(true);
            p.C(ubcFlowEvent);
            if (TextUtils.equals("update_tag_by_activity_on_new_intent", str) && this.u.a0() && e0()) {
                if (K.c("swanCoreVersion")) {
                    bundle.remove("swanCoreVersion");
                    bundle.remove("extensionCore");
                }
                if (K.c("pms_db_info_onload")) {
                    bundle.remove("pms_db_info_onload");
                }
            }
            bundle.putBoolean("launch_by_reload", TextUtils.equals("update_tag_by_activity_on_relaunch", str));
            K.update(bundle);
            UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("swan_app_update_info_end");
            ubcFlowEvent2.a(true);
            p.C(ubcFlowEvent2);
            if (z) {
                q("event_on_app_occupied");
            }
            if (this.f3962g && !this.u.a0() && !this.u.Z()) {
                UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("swan_app_maintain_start");
                ubcFlowEvent3.a(true);
                p.C(ubcFlowEvent3);
                this.u.e0();
                UbcFlowEvent ubcFlowEvent4 = new UbcFlowEvent("swan_app_maintain_return");
                ubcFlowEvent4.a(true);
                p.C(ubcFlowEvent4);
                return true;
            }
            if (this.u.a0() && contains) {
                k.c0(K, K.e0(), false, false);
            }
            return this.u.Z();
        }
        return invokeLLZ.booleanValue;
    }

    @Override // b.a.p0.a.a2.m, b.a.p0.a.a2.h
    public void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, str) == null) {
            w(str, G());
        }
    }

    public int q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? this.u.h0() : invokeV.intValue;
    }

    @Override // b.a.p0.a.a2.m, b.a.p0.a.a2.h
    public e r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? this : (e) invokeV.objValue;
    }

    public boolean r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? this.u.m0() : invokeV.booleanValue;
    }

    public void s0(SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, swanAppConfigData) == null) {
            this.f3963h = swanAppConfigData;
        }
    }

    @Override // b.a.p0.a.a2.m, b.a.p0.a.a2.h
    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            S().l();
            T().d(true);
        }
    }

    public void t0(b.a.p0.a.a2.n.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, aVar) == null) {
            this.f3964i = aVar;
        }
    }

    public void u0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, str) == null) {
            this.x = str;
            b.a.p0.a.e0.d.h("SwanApp", "SwanAppActivity setUpdateTag:" + this.x);
        }
    }

    public b.a.p0.a.f1.e.b v0(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048633, this, bundle)) == null) {
            b.a K = K();
            K.update(bundle);
            return K;
        }
        return (b.a.p0.a.f1.e.b) invokeL.objValue;
    }

    @Override // b.a.p0.a.a2.m, b.a.p0.a.a2.h
    public void w(String str, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048634, this, str, bundle) == null) {
            if (bundle == null) {
                bundle = G();
            } else {
                bundle.putAll(G());
            }
            super.w(str, bundle);
        }
    }

    public void w0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048635, this, str, str2) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        if (this.t == null) {
            this.t = new HashMap();
        }
        if (y) {
            String str3 = "update initData, page: " + str2 + " initDta : " + str;
        }
        this.t.put(str2, str);
    }

    public void x0(String str, boolean z) {
        SwanAppConfigData swanAppConfigData;
        SwanAppConfigData.j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048636, this, str, z) == null) || TextUtils.isEmpty(str) || (swanAppConfigData = this.f3963h) == null || (jVar = swanAppConfigData.f44230c) == null || jVar.f44264b == null) {
            return;
        }
        if (y) {
            String str2 = "更新内存缓存信息: " + str + ": " + z;
        }
        this.f3963h.f44230c.f44264b.put(str, Boolean.valueOf(z));
    }
}
