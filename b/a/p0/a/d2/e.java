package b.a.p0.a.d2;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.d2.i;
import b.a.p0.a.f1.e.b;
import b.a.p0.a.h0.g.k;
import b.a.p0.a.z2.q0;
import b.a.p0.q.j.m.a;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.pms.model.PMSAppInfo;
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
import java.util.Set;
/* loaded from: classes.dex */
public class e extends m {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean z;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public final String f4474f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f4475g;

    /* renamed from: h  reason: collision with root package name */
    public SwanAppConfigData f4476h;

    /* renamed from: i  reason: collision with root package name */
    public b.a.p0.a.d2.n.a f4477i;
    public b.a.p0.a.o2.c j;
    public b.a.p0.a.o2.f.d k;
    public b.a.p0.a.h2.a l;
    public b.a.p0.a.m.b m;
    public b.a.p0.a.p1.j n;
    public HttpManager o;
    public b.a.p0.a.e2.a.a p;
    public b.a.p0.a.j1.c.c q;
    public b.a.p0.a.p1.k r;
    public g s;
    public Map<String, String> t;
    public final k u;
    public final b.a v;
    public boolean w;
    public String x;
    public boolean y;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1320931233, "Lb/a/p0/a/d2/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1320931233, "Lb/a/p0/a/d2/e;");
                return;
            }
        }
        z = b.a.p0.a.k.f6863a;
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
        boolean z2 = false;
        this.w = false;
        this.y = false;
        str = str == null ? "" : str;
        this.f4474f = str;
        z2 = (!TextUtils.isEmpty(str) || TextUtils.equals(this.f4474f, "swan_id_unknown")) ? true : true;
        this.f4475g = z2;
        if (z2) {
            b.a.p0.a.e2.a.a aVar = new b.a.p0.a.e2.a.a();
            this.p = aVar;
            aVar.f(this.f4474f);
        }
        b.a.p0.a.e0.d.k("SwanApp", "new SwanApp id = " + this.f4474f + StringUtil.ARRAY_ELEMENT_SEPARATOR + Log.getStackTraceString(new RuntimeException("SwanApp log")));
    }

    @Deprecated
    public static e L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a0() : (e) invokeV.objValue;
    }

    public static e a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            d J = d.J();
            if (J.D()) {
                return J.r();
            }
            return null;
        }
        return (e) invokeV.objValue;
    }

    @Deprecated
    public static String f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? d.J().getAppId() : (String) invokeV.objValue;
    }

    @Override // b.a.p0.a.d2.m, b.a.p0.a.d2.h
    public void A(i.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            super.A((i.a) aVar.update(R()));
        }
    }

    public void A0(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) {
            d0().w(activity);
        }
    }

    public String B0(String... strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, strArr)) == null) {
            if (z) {
                String str = "——> release client Id " + this.f4474f;
            }
            SwanAppActivity x = x();
            if (x != null && !x.isDestroyed() && !x.isFinishing() && x.hasActivedFrame()) {
                x.reset(strArr);
            }
            b.a.p0.a.g1.f.b0();
            g gVar = this.s;
            if (gVar != null) {
                gVar.g();
            }
            b.a.p0.w.d.k(b.a.p0.a.o2.b.x(this.f4474f));
            b.a.p0.a.j1.c.c cVar = this.q;
            if (cVar != null) {
                cVar.E();
            }
            b.a.p0.a.e2.a.a aVar = this.p;
            if (aVar != null) {
                aVar.g();
            }
            b.a.p0.a.p1.k kVar = this.r;
            if (kVar != null) {
                kVar.d();
            }
            this.j = null;
            this.l = null;
            this.o = null;
            this.w = false;
            return this.f4474f;
        }
        return (String) invokeL.objValue;
    }

    public boolean C0(Bundle bundle, String str, boolean z2) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048579, this, bundle, str, z2)) == null) {
            boolean contains = h.g0.contains(str);
            b.a V = V();
            HybridUbcFlow p = b.a.p0.a.u1.h.p("startup");
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("swan_app_update_info_start");
            ubcFlowEvent.a(true);
            p.F(ubcFlowEvent);
            if (TextUtils.equals("update_tag_by_activity_on_new_intent", str) && this.u.l0() && o0()) {
                if (V.c("swanCoreVersion")) {
                    bundle.remove("swanCoreVersion");
                    bundle.remove("extensionCore");
                }
                if (V.c("pms_db_info_onload")) {
                    bundle.remove("pms_db_info_onload");
                }
            }
            bundle.putBoolean("launch_by_reload", TextUtils.equals("update_tag_by_activity_on_relaunch", str));
            V.update(bundle);
            UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("swan_app_update_info_end");
            ubcFlowEvent2.a(true);
            p.F(ubcFlowEvent2);
            if (z2) {
                q("event_on_app_occupied");
            }
            if (this.f4475g && !this.u.l0() && !this.u.k0()) {
                UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("swan_app_maintain_start");
                ubcFlowEvent3.a(true);
                p.F(ubcFlowEvent3);
                this.u.p0();
                UbcFlowEvent ubcFlowEvent4 = new UbcFlowEvent("swan_app_maintain_return");
                ubcFlowEvent4.a(true);
                p.F(ubcFlowEvent4);
                return true;
            }
            if (this.u.l0() && contains) {
                k.n0(V, V.f0(), false, false);
            }
            return this.u.k0();
        }
        return invokeLLZ.booleanValue;
    }

    @Override // b.a.p0.a.d2.m, b.a.p0.a.d2.h
    public boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f4475g : invokeV.booleanValue;
    }

    public int D0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.u.v0() : invokeV.intValue;
    }

    public boolean E0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.u.A0() : invokeV.booleanValue;
    }

    public void F0(SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, swanAppConfigData) == null) {
            this.f4476h = swanAppConfigData;
        }
    }

    public void G0(b.a.p0.a.d2.n.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            this.f4477i = aVar;
        }
    }

    public boolean H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f4475g && this.u.l0() && l() > -1 : invokeV.booleanValue;
    }

    public void H0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.x = str;
            b.a.p0.a.e0.d.k("SwanApp", "SwanAppActivity setUpdateTag:" + this.x);
        }
    }

    public e I(boolean z2) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048587, this, z2)) == null) {
            this.w = z2;
            q("event_first_action_launched");
            return this;
        }
        return (e) invokeZ.objValue;
    }

    public void I0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z2) == null) {
            this.y = z2;
        }
    }

    public boolean J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.w : invokeV.booleanValue;
    }

    public b.a.p0.a.f1.e.b J0(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, bundle)) == null) {
            b.a V = V();
            V.update(bundle);
            return V;
        }
        return (b.a.p0.a.f1.e.b) invokeL.objValue;
    }

    public final String K(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) {
            if (i2 == 0) {
                b.a aVar = this.v;
                String w1 = aVar != null ? aVar.w1() : "";
                if (TextUtils.isEmpty(w1)) {
                    w1 = j0();
                }
                String f2 = q0.f(w1);
                Object[] objArr = new Object[1];
                objArr[0] = TextUtils.isEmpty(f2) ? " version is empty " : f2;
                b.a.p0.a.e0.d.b("SwanApp", objArr);
                return f2;
            }
            return "0";
        }
        return (String) invokeI.objValue;
    }

    public void K0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048592, this, str, str2) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        if (this.t == null) {
            this.t = new HashMap();
        }
        if (z) {
            String str3 = "update initData, page: " + str2 + " initDta : " + str;
        }
        this.t.put(str2, str);
    }

    public void L0(Set<a.C0647a> set) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, set) == null) {
            this.u.I0(set);
        }
    }

    public b.a.p0.a.m.b M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.m == null) {
                this.m = new b.a.p0.a.m.b(this);
            }
            return this.m;
        }
        return (b.a.p0.a.m.b) invokeV.objValue;
    }

    public void M0(PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, pMSAppInfo) == null) || pMSAppInfo == null) {
            return;
        }
        this.u.L0(pMSAppInfo);
    }

    public String N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? V().I() : (String) invokeV.objValue;
    }

    public void N0(String str, boolean z2) {
        SwanAppConfigData swanAppConfigData;
        SwanAppConfigData.l lVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048597, this, str, z2) == null) || TextUtils.isEmpty(str) || (swanAppConfigData = this.f4476h) == null || (lVar = swanAppConfigData.f45028c) == null || lVar.f45069b == null) {
            return;
        }
        if (z) {
            String str2 = "更新内存缓存信息: " + str + ": " + z2;
        }
        this.f4476h.f45028c.f45069b.put(str, Boolean.valueOf(z2));
    }

    public b.a.p0.a.j1.c.c O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (this.q == null) {
                this.q = new b.a.p0.a.j1.c.c(this);
            }
            return this.q;
        }
        return (b.a.p0.a.j1.c.c) invokeV.objValue;
    }

    public SwanAppConfigData P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f4476h : (SwanAppConfigData) invokeV.objValue;
    }

    public String Q(String str) {
        InterceptResult invokeL;
        SwanAppConfigData.m mVar;
        Map<String, String> map;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, str)) == null) {
            SwanAppConfigData swanAppConfigData = this.f4476h;
            if (swanAppConfigData == null || (mVar = swanAppConfigData.f45029d) == null || (map = mVar.f45074a) == null) {
                return null;
            }
            return map.get(str);
        }
        return (String) invokeL.objValue;
    }

    public final Bundle R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("mAppId", this.f4474f);
            return bundle;
        }
        return (Bundle) invokeV.objValue;
    }

    public b.a.p0.a.d2.n.a S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.f4477i : (b.a.p0.a.d2.n.a) invokeV.objValue;
    }

    @NonNull
    public g T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            if (this.s == null) {
                this.s = new g(this);
            }
            return this.s;
        }
        return (g) invokeV.objValue;
    }

    public String U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            b.a V = V();
            return V != null ? K(V.getType()) : "0";
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public b.a V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.v : (b.a) invokeV.objValue;
    }

    @Nullable
    public String W(String str) {
        InterceptResult invokeL;
        Map<String, String> map;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, str)) == null) {
            if (TextUtils.isEmpty(str) || (map = this.t) == null) {
                return null;
            }
            return map.get(str);
        }
        return (String) invokeL.objValue;
    }

    @NonNull
    @Deprecated
    public b.a X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? V() : (b.a) invokeV.objValue;
    }

    public String Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? V().K() : (String) invokeV.objValue;
    }

    public synchronized b.a.p0.a.p1.j Z() {
        InterceptResult invokeV;
        b.a.p0.a.p1.j jVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            synchronized (this) {
                if (this.n == null) {
                    this.n = new b.a.p0.a.p1.j(this);
                }
                jVar = this.n;
            }
            return jVar;
        }
        return (b.a.p0.a.p1.j) invokeV.objValue;
    }

    public String b0(String str) {
        InterceptResult invokeL;
        SwanAppConfigData.l lVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, str)) == null) {
            SwanAppConfigData swanAppConfigData = this.f4476h;
            if (swanAppConfigData == null || (lVar = swanAppConfigData.f45028c) == null || lVar.f45070c == null) {
                return null;
            }
            return this.f4476h.f45028c.f45070c.get(b.a.p0.a.f2.f.o0.j.b(str));
        }
        return (String) invokeL.objValue;
    }

    public String c0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, str)) == null) {
            SwanAppConfigData swanAppConfigData = this.f4476h;
            return swanAppConfigData != null ? swanAppConfigData.h(str) : "";
        }
        return (String) invokeL.objValue;
    }

    @NonNull
    public b.a.p0.a.h2.a d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            if (this.l == null) {
                this.l = new b.a.p0.a.h2.a(this);
            }
            return this.l;
        }
        return (b.a.p0.a.h2.a) invokeV.objValue;
    }

    public b.a.p0.a.o2.c e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            if (this.j == null) {
                this.j = new b.a.p0.a.o2.c(this);
            }
            return this.j;
        }
        return (b.a.p0.a.o2.c) invokeV.objValue;
    }

    public b.a.p0.a.o2.f.d g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            if (this.k == null) {
                if (v0()) {
                    this.k = new b.a.p0.a.r0.l();
                } else {
                    this.k = new b.a.p0.a.o2.f.f();
                }
            }
            return this.k;
        }
        return (b.a.p0.a.o2.f.d) invokeV.objValue;
    }

    @Deprecated
    public Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? x() : (Activity) invokeV.objValue;
    }

    @Override // b.a.p0.a.d2.m, b.a.p0.a.d2.h
    public String getAppId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.f4474f : (String) invokeV.objValue;
    }

    public synchronized HttpManager h0() {
        InterceptResult invokeV;
        HttpManager httpManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
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

    public String i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.x : (String) invokeV.objValue;
    }

    public String j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? V().v1() : (String) invokeV.objValue;
    }

    public b.a.p0.a.e2.a.a k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            if (this.p == null) {
                this.p = new b.a.p0.a.e2.a.a();
            }
            return this.p;
        }
        return (b.a.p0.a.e2.a.a) invokeV.objValue;
    }

    @Override // b.a.p0.a.d2.m, b.a.p0.a.d2.h
    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            if (this.f4475g) {
                return V().G();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public b.a.p0.a.p1.k l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            if (this.r == null) {
                this.r = new b.a.p0.a.p1.k();
            }
            return this.r;
        }
        return (b.a.p0.a.p1.k) invokeV.objValue;
    }

    public boolean m0() {
        InterceptResult invokeV;
        b.a.p0.a.t0.c frame;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            if (b.a.p0.a.h0.o.e.a.h()) {
                SwanAppActivity x = x();
                if (x == null || x.isFinishing() || x.isDestroyed() || (frame = x.getFrame()) == null) {
                    return true;
                }
                return !frame.a0().hasStarted();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.p0.a.d2.m, b.a.p0.a.d2.h
    public SwanAppCores n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            SwanAppCores swanAppCores = new SwanAppCores();
            swanAppCores.setSwanCoreVersion(V().j0());
            swanAppCores.setExtensionCore(V().O());
            return swanAppCores;
        }
        return (SwanAppCores) invokeV.objValue;
    }

    public boolean n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? p0(b.a.p0.a.g1.f.U().T()) : invokeV.booleanValue;
    }

    public boolean o0() {
        InterceptResult invokeV;
        b.a.p0.a.t0.c frame;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            SwanAppActivity x = x();
            if (x == null || (frame = x.getFrame()) == null) {
                return false;
            }
            return frame.a0().hasCreated();
        }
        return invokeV.booleanValue;
    }

    public boolean p0(String str) {
        InterceptResult invokeL;
        SwanAppConfigData swanAppConfigData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048627, this, str)) == null) {
            if (TextUtils.isEmpty(str) || (swanAppConfigData = this.f4476h) == null) {
                return false;
            }
            return swanAppConfigData.o(str);
        }
        return invokeL.booleanValue;
    }

    @Override // b.a.p0.a.d2.m, b.a.p0.a.d2.h
    public void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, str) == null) {
            w(str, R());
        }
    }

    public boolean q0(String str) {
        InterceptResult invokeL;
        SwanAppConfigData swanAppConfigData;
        SwanAppConfigData.e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048629, this, str)) == null) {
            if (TextUtils.isEmpty(str) || (swanAppConfigData = this.f4476h) == null || (eVar = swanAppConfigData.f45027b) == null) {
                return false;
            }
            return eVar.c(str);
        }
        return invokeL.booleanValue;
    }

    @Override // b.a.p0.a.d2.m, b.a.p0.a.d2.h
    public e r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? this : (e) invokeV.objValue;
    }

    public boolean r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) ? this.u.k0() : invokeV.booleanValue;
    }

    public boolean s0(String str) {
        InterceptResult invokeL;
        SwanAppConfigData swanAppConfigData;
        SwanAppConfigData.l lVar;
        Map<String, Boolean> map;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048632, this, str)) == null) {
            if (TextUtils.isEmpty(str) || (swanAppConfigData = this.f4476h) == null || (lVar = swanAppConfigData.f45028c) == null || (map = lVar.f45069b) == null || !map.containsKey(str)) {
                return false;
            }
            boolean z2 = z;
            return this.f4476h.f45028c.f45069b.get(str).booleanValue();
        }
        return invokeL.booleanValue;
    }

    @Override // b.a.p0.a.d2.m, b.a.p0.a.d2.h
    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048633, this) == null) {
            d0().l();
            e0().d(true);
        }
    }

    public boolean t0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048634, this, str)) == null) ? new File(b.a.p0.a.g1.f.U().z(), str).exists() : invokeL.booleanValue;
    }

    public boolean u0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048635, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return b.a.p0.q.g.a.i().n(this.f4474f, j0(), str);
        }
        return invokeL.booleanValue;
    }

    public boolean v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) ? V().G() == 1 : invokeV.booleanValue;
    }

    @Override // b.a.p0.a.d2.m, b.a.p0.a.d2.h
    public void w(String str, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048637, this, str, bundle) == null) {
            if (bundle == null) {
                bundle = R();
            } else {
                bundle.putAll(R());
            }
            super.w(str, bundle);
        }
    }

    public boolean w0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) ? TextUtils.equals("update_tag_by_app_launch", this.x) : invokeV.booleanValue;
    }

    public boolean x0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) ? this.y : invokeV.booleanValue;
    }

    public boolean y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            if (k.b.a()) {
                return true;
            }
            b.a V = V();
            if (V == null) {
                b.a.p0.a.e0.d.i("SwanApp", "isWebPermit: swan app info is null.");
                return false;
            }
            PMSAppInfo f0 = V.f0();
            if (f0 == null) {
                b.a.p0.a.e0.d.i("SwanApp", "isWebPermit: pms info is null.");
                return false;
            } else if (TextUtils.isEmpty(f0.webUrl)) {
                b.a.p0.a.e0.d.i("SwanApp", "isWebPermit: web url is null.");
                return false;
            } else {
                b.a.p0.a.e0.d.i("SwanApp", "isWebPermit: web permit :" + f0.webPermit);
                return f0.webPermit == 1;
            }
        }
        return invokeV.booleanValue;
    }

    public void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048641, this) == null) {
            this.u.t0();
        }
    }
}
