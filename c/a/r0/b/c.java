package c.a.r0.b;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.b.f.a0;
import c.a.r0.b.f.b0;
import c.a.r0.b.f.c0;
import c.a.r0.b.f.d0;
import c.a.r0.b.f.e0;
import c.a.r0.b.f.f;
import c.a.r0.b.f.g;
import c.a.r0.b.f.h;
import c.a.r0.b.f.i;
import c.a.r0.b.f.j;
import c.a.r0.b.f.k;
import c.a.r0.b.f.l;
import c.a.r0.b.f.m;
import c.a.r0.b.f.n;
import c.a.r0.b.f.p;
import c.a.r0.b.f.q;
import c.a.r0.b.f.r;
import c.a.r0.b.f.s;
import c.a.r0.b.f.t;
import c.a.r0.b.f.u;
import c.a.r0.b.f.v;
import c.a.r0.b.f.w;
import c.a.r0.b.f.x;
import c.a.r0.b.f.y;
import c.a.r0.b.f.z;
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
/* loaded from: classes6.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static c f12033d;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<String, e> a;

    /* renamed from: b  reason: collision with root package name */
    public final HashMap<BdUniqueId, c.a.r0.b.f.a> f12034b;

    /* renamed from: c  reason: collision with root package name */
    public final HashMap<BdUniqueId, e> f12035c;

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
        this.f12034b = new HashMap<>();
        this.f12035c = new HashMap<>();
        n();
        k(c());
    }

    public static c d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f12033d == null) {
                synchronized (c.class) {
                    if (f12033d == null) {
                        f12033d = new c();
                    }
                }
            }
            return f12033d;
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
            c.a.r0.s.g0.b.j().v("static_opt_open", d.g0() ? 1 : 0);
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
                JSONArray jSONArray = new JSONArray(c.a.r0.s.g0.b.j().p(e(), "[]"));
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

    public HashMap<String, Integer> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            HashMap<String, Integer> hashMap = new HashMap<>();
            int i2 = 0;
            for (String str : this.a.keySet()) {
                hashMap.put(str, Integer.valueOf(i2));
                i2++;
            }
            return hashMap;
        }
        return (HashMap) invokeV.objValue;
    }

    public e g(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bdUniqueId)) == null) {
            c.a.r0.b.f.a aVar = this.f12034b.get(bdUniqueId);
            if (aVar == null) {
                return null;
            }
            return aVar.b();
        }
        return (e) invokeL.objValue;
    }

    public Map<BdUniqueId, e> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f12035c : (Map) invokeV.objValue;
    }

    public void i(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, jSONArray) == null) {
            try {
                String e2 = e();
                if (jSONArray == null) {
                    this.a.clear();
                    c.a.r0.s.g0.b.j().C(e2);
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
                k(hashMap);
                c.a.r0.s.g0.b.j().x(e2, jSONArray.toString());
                a();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    i(null);
                } else {
                    i(new JSONArray(str));
                }
            } catch (Exception unused) {
            }
        }
    }

    public final void k(HashMap<String, e> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, hashMap) == null) {
            synchronized (this.a) {
                this.a.clear();
                if (hashMap != null) {
                    this.a.putAll(hashMap);
                }
                l();
            }
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            for (Map.Entry<BdUniqueId, c.a.r0.b.f.a> entry : this.f12034b.entrySet()) {
                c.a.r0.b.f.a value = entry.getValue();
                if (value != null) {
                    p(value);
                }
            }
            m();
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f12035c.clear();
            for (BdUniqueId bdUniqueId : this.f12034b.keySet()) {
                this.f12035c.put(bdUniqueId, g(bdUniqueId));
            }
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            o(new b0());
            o(new m());
            o(new h());
            o(new v());
            o(new c.a.r0.b.f.c());
            o(new c.a.r0.b.f.d());
            o(new z());
            o(new f());
            o(new j());
            o(new i());
            o(new q());
            o(new y());
            o(new u());
            o(new n());
            o(new g());
            o(new c.a.r0.b.f.e());
            o(new k());
            o(new e0());
            o(new r());
            o(new p());
            o(new c0());
            o(new d0());
            o(new s());
            o(new x());
            o(new c.a.r0.b.f.b());
            o(new t());
            o(new w());
            o(new l());
            o(new a0());
        }
    }

    public void o(c.a.r0.b.f.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, aVar) == null) || aVar == null || aVar.c() == null) {
            return;
        }
        this.f12034b.put(aVar.c(), aVar);
    }

    public final void p(c.a.r0.b.f.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, aVar) == null) || aVar == null) {
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
