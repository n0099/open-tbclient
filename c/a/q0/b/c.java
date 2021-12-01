package c.a.q0.b;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.b.f.a0;
import c.a.q0.b.f.b0;
import c.a.q0.b.f.c0;
import c.a.q0.b.f.d0;
import c.a.q0.b.f.f;
import c.a.q0.b.f.g;
import c.a.q0.b.f.h;
import c.a.q0.b.f.i;
import c.a.q0.b.f.j;
import c.a.q0.b.f.k;
import c.a.q0.b.f.l;
import c.a.q0.b.f.m;
import c.a.q0.b.f.n;
import c.a.q0.b.f.p;
import c.a.q0.b.f.q;
import c.a.q0.b.f.r;
import c.a.q0.b.f.s;
import c.a.q0.b.f.t;
import c.a.q0.b.f.u;
import c.a.q0.b.f.v;
import c.a.q0.b.f.w;
import c.a.q0.b.f.x;
import c.a.q0.b.f.y;
import c.a.q0.b.f.z;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static c f11720d;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<String, e> a;

    /* renamed from: b  reason: collision with root package name */
    public final HashMap<BdUniqueId, c.a.q0.b.f.a> f11721b;

    /* renamed from: c  reason: collision with root package name */
    public final HashMap<BdUniqueId, e> f11722c;

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
                return;
            }
        }
        this.a = new HashMap<>();
        this.f11721b = new HashMap<>();
        this.f11722c = new HashMap<>();
        m();
        j(c());
    }

    public static c d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f11720d == null) {
                synchronized (c.class) {
                    if (f11720d == null) {
                        f11720d = new c();
                    }
                }
            }
            return f11720d;
        }
        return (c) invokeV.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? "ubs_abtest_config" : (String) invokeV.objValue;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c.a.q0.s.e0.b.j().v("static_opt_open", d.f0() ? 1 : 0);
        }
    }

    public synchronized e b(String str) {
        InterceptResult invokeL;
        e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            synchronized (this) {
                eVar = this.a.get(str);
            }
            return eVar;
        }
        return (e) invokeL.objValue;
    }

    public final HashMap<String, e> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            HashMap<String, e> hashMap = new HashMap<>();
            try {
                e();
                JSONArray jSONArray = new JSONArray(c.a.q0.s.e0.b.j().p(e(), "[]"));
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    if (jSONObject != null) {
                        String optString = jSONObject.optString("sid");
                        hashMap.put(optString, new e(optString));
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return hashMap;
        }
        return (HashMap) invokeV.objValue;
    }

    public e f(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, bdUniqueId)) == null) {
            c.a.q0.b.f.a aVar = this.f11721b.get(bdUniqueId);
            if (aVar == null) {
                return null;
            }
            return aVar.b();
        }
        return (e) invokeL.objValue;
    }

    public Map<BdUniqueId, e> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f11722c : (Map) invokeV.objValue;
    }

    public void h(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jSONArray) == null) {
            try {
                String e2 = e();
                if (jSONArray == null) {
                    this.a.clear();
                    c.a.q0.s.e0.b.j().C(e2);
                    return;
                }
                HashMap<String, e> hashMap = new HashMap<>();
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    if (jSONObject != null) {
                        String optString = jSONObject.optString("sid");
                        hashMap.put(optString, new e(optString));
                    }
                }
                j(hashMap);
                c.a.q0.s.e0.b.j().x(e2, jSONArray.toString());
                a();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    h(null);
                } else {
                    h(new JSONArray(str));
                }
            } catch (Exception unused) {
            }
        }
    }

    public final void j(HashMap<String, e> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, hashMap) == null) {
            synchronized (this.a) {
                this.a.clear();
                if (hashMap != null) {
                    this.a.putAll(hashMap);
                }
                k();
            }
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            for (Map.Entry<BdUniqueId, c.a.q0.b.f.a> entry : this.f11721b.entrySet()) {
                c.a.q0.b.f.a value = entry.getValue();
                if (value != null) {
                    o(value);
                }
            }
            l();
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f11722c.clear();
            for (BdUniqueId bdUniqueId : this.f11721b.keySet()) {
                this.f11722c.put(bdUniqueId, f(bdUniqueId));
            }
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            n(new a0());
            n(new m());
            n(new h());
            n(new v());
            n(new c.a.q0.b.f.c());
            n(new c.a.q0.b.f.d());
            n(new z());
            n(new f());
            n(new j());
            n(new i());
            n(new q());
            n(new y());
            n(new u());
            n(new n());
            n(new g());
            n(new c.a.q0.b.f.e());
            n(new k());
            n(new d0());
            n(new r());
            n(new p());
            n(new b0());
            n(new c0());
            n(new s());
            n(new x());
            n(new c.a.q0.b.f.b());
            n(new t());
            n(new w());
            n(new l());
        }
    }

    public void n(c.a.q0.b.f.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, aVar) == null) || aVar == null || aVar.c() == null) {
            return;
        }
        this.f11721b.put(aVar.c(), aVar);
    }

    public final void o(c.a.q0.b.f.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, aVar) == null) || aVar == null) {
            return;
        }
        ArrayList<String> a = aVar.a();
        e eVar = null;
        if (ListUtils.isEmpty(a)) {
            aVar.f(null);
            return;
        }
        Iterator<String> it = a.iterator();
        while (it.hasNext()) {
            eVar = this.a.get(it.next());
            if (eVar != null) {
                break;
            }
        }
        aVar.f(eVar);
    }
}
