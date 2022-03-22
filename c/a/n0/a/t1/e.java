package c.a.n0.a.t1;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.p2.q0;
import c.a.n0.a.t1.i;
import c.a.n0.a.v0.e.b;
import c.a.n0.a.x.g.k;
import c.a.n0.q.i.m.a;
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
import com.kwad.v8.NodeJS;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class e extends m {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean v;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final String f6344b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f6345c;

    /* renamed from: d  reason: collision with root package name */
    public SwanAppConfigData f6346d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.n0.a.t1.n.a f6347e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.n0.a.e2.c f6348f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.n0.a.e2.f.d f6349g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.n0.a.x1.a f6350h;
    public c.a.n0.a.c.b i;
    public c.a.n0.a.f1.j j;
    public HttpManager k;
    public c.a.n0.a.u1.a.a l;
    public c.a.n0.a.z0.c.c m;
    public c.a.n0.a.f1.k n;
    public g o;
    public Map<String, String> p;
    public final k q;
    public final b.a r;
    public boolean s;
    public String t;
    public boolean u;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1223146163, "Lc/a/n0/a/t1/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1223146163, "Lc/a/n0/a/t1/e;");
                return;
            }
        }
        v = c.a.n0.a.a.a;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((h) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.q = new k(this);
        this.r = new b.a();
        boolean z = false;
        this.s = false;
        this.u = false;
        str = str == null ? "" : str;
        this.f6344b = str;
        z = (!TextUtils.isEmpty(str) || TextUtils.equals(this.f6344b, "swan_id_unknown")) ? true : true;
        this.f6345c = z;
        if (z) {
            c.a.n0.a.u1.a.a aVar = new c.a.n0.a.u1.a.a();
            this.l = aVar;
            aVar.f(this.f6344b);
        }
        c.a.n0.a.u.d.k("SwanApp", "new SwanApp id = " + this.f6344b + StringUtil.ARRAY_ELEMENT_SEPARATOR + Log.getStackTraceString(new RuntimeException("SwanApp log")));
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

    @Override // c.a.n0.a.t1.m, c.a.n0.a.t1.h
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
            if (v) {
                Log.d("SwanApp", "——> release client Id " + this.f6344b);
            }
            SwanAppActivity x = x();
            if (x != null && !x.isDestroyed() && !x.isFinishing() && x.hasActivedFrame()) {
                x.reset(strArr);
            }
            c.a.n0.a.w0.f.b0();
            g gVar = this.o;
            if (gVar != null) {
                gVar.g();
            }
            c.a.n0.w.d.k(c.a.n0.a.e2.b.x(this.f6344b));
            c.a.n0.a.z0.c.c cVar = this.m;
            if (cVar != null) {
                cVar.E();
            }
            c.a.n0.a.u1.a.a aVar = this.l;
            if (aVar != null) {
                aVar.g();
            }
            c.a.n0.a.f1.k kVar = this.n;
            if (kVar != null) {
                kVar.d();
            }
            this.f6348f = null;
            this.f6350h = null;
            this.k = null;
            this.s = false;
            return this.f6344b;
        }
        return (String) invokeL.objValue;
    }

    public boolean C0(Bundle bundle, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048579, this, bundle, str, z)) == null) {
            boolean contains = h.e0.contains(str);
            b.a V = V();
            HybridUbcFlow p = c.a.n0.a.k1.h.p(NodeJS.STARTUP_SCRIPT_NAME);
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("swan_app_update_info_start");
            ubcFlowEvent.a(true);
            p.F(ubcFlowEvent);
            if (TextUtils.equals("update_tag_by_activity_on_new_intent", str) && this.q.l0() && o0()) {
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
            if (z) {
                q("event_on_app_occupied");
            }
            if (this.f6345c && !this.q.l0() && !this.q.k0()) {
                UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("swan_app_maintain_start");
                ubcFlowEvent3.a(true);
                p.F(ubcFlowEvent3);
                this.q.p0();
                UbcFlowEvent ubcFlowEvent4 = new UbcFlowEvent("swan_app_maintain_return");
                ubcFlowEvent4.a(true);
                p.F(ubcFlowEvent4);
                return true;
            }
            if (this.q.l0() && contains) {
                k.n0(V, V.f0(), false, false);
            }
            return this.q.k0();
        }
        return invokeLLZ.booleanValue;
    }

    @Override // c.a.n0.a.t1.m, c.a.n0.a.t1.h
    public boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f6345c : invokeV.booleanValue;
    }

    public int D0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.q.v0() : invokeV.intValue;
    }

    public boolean E0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.q.A0() : invokeV.booleanValue;
    }

    public void F0(SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, swanAppConfigData) == null) {
            this.f6346d = swanAppConfigData;
        }
    }

    public void G0(c.a.n0.a.t1.n.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            this.f6347e = aVar;
        }
    }

    public boolean H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f6345c && this.q.l0() && l() > -1 : invokeV.booleanValue;
    }

    public void H0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.t = str;
            c.a.n0.a.u.d.k("SwanApp", "SwanAppActivity setUpdateTag:" + this.t);
        }
    }

    public e I(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048587, this, z)) == null) {
            this.s = z;
            q("event_first_action_launched");
            return this;
        }
        return (e) invokeZ.objValue;
    }

    public void I0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.u = z;
        }
    }

    public boolean J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.s : invokeV.booleanValue;
    }

    public c.a.n0.a.v0.e.b J0(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, bundle)) == null) {
            b.a V = V();
            V.update(bundle);
            return V;
        }
        return (c.a.n0.a.v0.e.b) invokeL.objValue;
    }

    public final String K(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i)) == null) {
            if (i == 0) {
                b.a aVar = this.r;
                String w1 = aVar != null ? aVar.w1() : "";
                if (TextUtils.isEmpty(w1)) {
                    w1 = j0();
                }
                String f2 = q0.f(w1);
                Object[] objArr = new Object[1];
                objArr[0] = TextUtils.isEmpty(f2) ? " version is empty " : f2;
                c.a.n0.a.u.d.b("SwanApp", objArr);
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
        if (this.p == null) {
            this.p = new HashMap();
        }
        if (v) {
            Log.d("SwanApp", "update initData, page: " + str2 + " initDta : " + str);
        }
        this.p.put(str2, str);
    }

    public void L0(Set<a.C0756a> set) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, set) == null) {
            this.q.I0(set);
        }
    }

    public c.a.n0.a.c.b M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.i == null) {
                this.i = new c.a.n0.a.c.b(this);
            }
            return this.i;
        }
        return (c.a.n0.a.c.b) invokeV.objValue;
    }

    public void M0(PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, pMSAppInfo) == null) || pMSAppInfo == null) {
            return;
        }
        this.q.L0(pMSAppInfo);
    }

    public String N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? V().I() : (String) invokeV.objValue;
    }

    public void N0(String str, boolean z) {
        SwanAppConfigData swanAppConfigData;
        SwanAppConfigData.l lVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048597, this, str, z) == null) || TextUtils.isEmpty(str) || (swanAppConfigData = this.f6346d) == null || (lVar = swanAppConfigData.f29237c) == null || lVar.f29267b == null) {
            return;
        }
        if (v) {
            Log.i("SwanApp", "更新内存缓存信息: " + str + ": " + z);
        }
        this.f6346d.f29237c.f29267b.put(str, Boolean.valueOf(z));
    }

    public c.a.n0.a.z0.c.c O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (this.m == null) {
                this.m = new c.a.n0.a.z0.c.c(this);
            }
            return this.m;
        }
        return (c.a.n0.a.z0.c.c) invokeV.objValue;
    }

    public SwanAppConfigData P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f6346d : (SwanAppConfigData) invokeV.objValue;
    }

    public String Q(String str) {
        InterceptResult invokeL;
        SwanAppConfigData.m mVar;
        Map<String, String> map;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, str)) == null) {
            SwanAppConfigData swanAppConfigData = this.f6346d;
            if (swanAppConfigData == null || (mVar = swanAppConfigData.f29238d) == null || (map = mVar.a) == null) {
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
            bundle.putString("mAppId", this.f6344b);
            return bundle;
        }
        return (Bundle) invokeV.objValue;
    }

    public c.a.n0.a.t1.n.a S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.f6347e : (c.a.n0.a.t1.n.a) invokeV.objValue;
    }

    @NonNull
    public g T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            if (this.o == null) {
                this.o = new g(this);
            }
            return this.o;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.r : (b.a) invokeV.objValue;
    }

    @Nullable
    public String W(String str) {
        InterceptResult invokeL;
        Map<String, String> map;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, str)) == null) {
            if (TextUtils.isEmpty(str) || (map = this.p) == null) {
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

    public synchronized c.a.n0.a.f1.j Z() {
        InterceptResult invokeV;
        c.a.n0.a.f1.j jVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            synchronized (this) {
                if (this.j == null) {
                    this.j = new c.a.n0.a.f1.j(this);
                }
                jVar = this.j;
            }
            return jVar;
        }
        return (c.a.n0.a.f1.j) invokeV.objValue;
    }

    public String b0(String str) {
        InterceptResult invokeL;
        SwanAppConfigData.l lVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, str)) == null) {
            SwanAppConfigData swanAppConfigData = this.f6346d;
            if (swanAppConfigData == null || (lVar = swanAppConfigData.f29237c) == null || lVar.f29268c == null) {
                return null;
            }
            return this.f6346d.f29237c.f29268c.get(c.a.n0.a.v1.f.o0.j.b(str));
        }
        return (String) invokeL.objValue;
    }

    public String c0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, str)) == null) {
            SwanAppConfigData swanAppConfigData = this.f6346d;
            return swanAppConfigData != null ? swanAppConfigData.h(str) : "";
        }
        return (String) invokeL.objValue;
    }

    @NonNull
    public c.a.n0.a.x1.a d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            if (this.f6350h == null) {
                this.f6350h = new c.a.n0.a.x1.a(this);
            }
            return this.f6350h;
        }
        return (c.a.n0.a.x1.a) invokeV.objValue;
    }

    public c.a.n0.a.e2.c e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            if (this.f6348f == null) {
                this.f6348f = new c.a.n0.a.e2.c(this);
            }
            return this.f6348f;
        }
        return (c.a.n0.a.e2.c) invokeV.objValue;
    }

    public c.a.n0.a.e2.f.d g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            if (this.f6349g == null) {
                if (v0()) {
                    this.f6349g = new c.a.n0.a.h0.l();
                } else {
                    this.f6349g = new c.a.n0.a.e2.f.f();
                }
            }
            return this.f6349g;
        }
        return (c.a.n0.a.e2.f.d) invokeV.objValue;
    }

    @Deprecated
    public Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? x() : (Activity) invokeV.objValue;
    }

    @Override // c.a.n0.a.t1.m, c.a.n0.a.t1.h
    public String getAppId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.f6344b : (String) invokeV.objValue;
    }

    public synchronized HttpManager h0() {
        InterceptResult invokeV;
        HttpManager httpManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            synchronized (this) {
                if (this.k == null) {
                    this.k = c.a.n0.a.s0.b.l().a();
                }
                httpManager = this.k;
            }
            return httpManager;
        }
        return (HttpManager) invokeV.objValue;
    }

    public String i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.t : (String) invokeV.objValue;
    }

    public String j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? V().v1() : (String) invokeV.objValue;
    }

    public c.a.n0.a.u1.a.a k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            if (this.l == null) {
                this.l = new c.a.n0.a.u1.a.a();
            }
            return this.l;
        }
        return (c.a.n0.a.u1.a.a) invokeV.objValue;
    }

    @Override // c.a.n0.a.t1.m, c.a.n0.a.t1.h
    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            if (this.f6345c) {
                return V().G();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public c.a.n0.a.f1.k l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            if (this.n == null) {
                this.n = new c.a.n0.a.f1.k();
            }
            return this.n;
        }
        return (c.a.n0.a.f1.k) invokeV.objValue;
    }

    public boolean m0() {
        InterceptResult invokeV;
        c.a.n0.a.j0.c frame;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            if (c.a.n0.a.x.o.e.a.h()) {
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

    @Override // c.a.n0.a.t1.m, c.a.n0.a.t1.h
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? p0(c.a.n0.a.w0.f.U().T()) : invokeV.booleanValue;
    }

    public boolean o0() {
        InterceptResult invokeV;
        c.a.n0.a.j0.c frame;
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
            if (TextUtils.isEmpty(str) || (swanAppConfigData = this.f6346d) == null) {
                return false;
            }
            return swanAppConfigData.o(str);
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.n0.a.t1.m, c.a.n0.a.t1.h
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
            if (TextUtils.isEmpty(str) || (swanAppConfigData = this.f6346d) == null || (eVar = swanAppConfigData.f29236b) == null) {
                return false;
            }
            return eVar.c(str);
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.n0.a.t1.m, c.a.n0.a.t1.h
    public e r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? this : (e) invokeV.objValue;
    }

    public boolean r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) ? this.q.k0() : invokeV.booleanValue;
    }

    public boolean s0(String str) {
        InterceptResult invokeL;
        SwanAppConfigData swanAppConfigData;
        SwanAppConfigData.l lVar;
        Map<String, Boolean> map;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048632, this, str)) == null) {
            if (TextUtils.isEmpty(str) || (swanAppConfigData = this.f6346d) == null || (lVar = swanAppConfigData.f29237c) == null || (map = lVar.f29267b) == null || !map.containsKey(str)) {
                return false;
            }
            if (v) {
                Log.i("SwanApp", "内存中查询分包是否存在信息");
            }
            return this.f6346d.f29237c.f29267b.get(str).booleanValue();
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.n0.a.t1.m, c.a.n0.a.t1.h
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
        return (interceptable == null || (invokeL = interceptable.invokeL(1048634, this, str)) == null) ? new File(c.a.n0.a.w0.f.U().z(), str).exists() : invokeL.booleanValue;
    }

    public boolean u0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048635, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return c.a.n0.q.f.a.i().n(this.f6344b, j0(), str);
        }
        return invokeL.booleanValue;
    }

    public boolean v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) ? V().G() == 1 : invokeV.booleanValue;
    }

    @Override // c.a.n0.a.t1.m, c.a.n0.a.t1.h
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) ? TextUtils.equals("update_tag_by_app_launch", this.t) : invokeV.booleanValue;
    }

    public boolean x0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) ? this.u : invokeV.booleanValue;
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
                c.a.n0.a.u.d.i("SwanApp", "isWebPermit: swan app info is null.");
                return false;
            }
            PMSAppInfo f0 = V.f0();
            if (f0 == null) {
                c.a.n0.a.u.d.i("SwanApp", "isWebPermit: pms info is null.");
                return false;
            } else if (TextUtils.isEmpty(f0.webUrl)) {
                c.a.n0.a.u.d.i("SwanApp", "isWebPermit: web url is null.");
                return false;
            } else {
                c.a.n0.a.u.d.i("SwanApp", "isWebPermit: web permit :" + f0.webPermit);
                return f0.webPermit == 1;
            }
        }
        return invokeV.booleanValue;
    }

    public void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048641, this) == null) {
            this.q.t0();
        }
    }
}
