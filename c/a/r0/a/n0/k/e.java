package c.a.r0.a.n0.k;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.k;
import c.a.r0.a.n0.k.d;
import c.a.r0.q.i.j;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.pms.utils.AbiType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class e implements c.a.r0.q.k.c<JSONArray> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: k  reason: collision with root package name */
    public static final boolean f7978k;
    public transient /* synthetic */ FieldHolder $fh;
    public final f a;

    /* renamed from: b  reason: collision with root package name */
    public final String f7979b;

    /* renamed from: c  reason: collision with root package name */
    public j f7980c;

    /* renamed from: d  reason: collision with root package name */
    public j f7981d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.r0.a.u2.a f7982e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f7983f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f7984g;

    /* renamed from: h  reason: collision with root package name */
    public final Collection<c.a.r0.a.z2.g1.c<e>> f7985h;

    /* renamed from: i  reason: collision with root package name */
    public final Collection<c.a.r0.a.z2.g1.c<e>> f7986i;

    /* renamed from: j  reason: collision with root package name */
    public d.b f7987j;

    /* loaded from: classes.dex */
    public class a implements Function1<c.a.r0.a.u2.a, Unit> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f7988e;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7988e = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a */
        public Unit invoke(c.a.r0.a.u2.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                if (e.f7978k) {
                    String str = "install: " + this.f7988e.k() + " onCallback";
                }
                this.f7988e.i(aVar);
                this.f7988e.f7983f = false;
                return null;
            }
            return (Unit) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1919759122, "Lc/a/r0/a/n0/k/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1919759122, "Lc/a/r0/a/n0/k/e;");
                return;
            }
        }
        f7978k = k.a;
    }

    public e(@NonNull f fVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f7980c = null;
        this.f7981d = null;
        this.f7982e = null;
        this.f7983f = false;
        this.f7984g = false;
        this.f7985h = new HashSet();
        this.f7986i = new HashSet();
        this.f7987j = null;
        this.a = fVar;
        this.f7979b = str;
    }

    public final synchronized void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                this.f7985h.clear();
                this.f7986i.clear();
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.q.k.c
    /* renamed from: f */
    public void a(@NonNull JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONArray) == null) {
            j l = l();
            if (f7978k) {
                String str = "decorateParams libName=" + this.f7979b + " localSo=" + l;
            }
            try {
                Iterator<AbiType> it = AbiType.currentAbi().getCompatible().iterator();
                while (it.hasNext()) {
                    AbiType next = it.next();
                    if (f7978k) {
                        String str2 = "decorateParams loop abi=" + next;
                    }
                    if (next != null) {
                        c.a.r0.q.m.a d2 = c.a.r0.q.m.a.d(this.f7979b, next);
                        if (f7978k) {
                            String str3 = "decorateParams loop bundleId=" + d2;
                        }
                        if (d2 != null) {
                            JSONObject jSONObject = new JSONObject();
                            boolean z = l != null && next == l.q;
                            long j2 = (l == null || !z) ? 0L : l.f11763i;
                            String str4 = "0";
                            String str5 = (l == null || !z) ? "0" : l.f11764j;
                            if (!TextUtils.isEmpty(str5)) {
                                str4 = str5;
                            }
                            jSONObject.put("type", "so");
                            jSONObject.put("bundle_id", d2.f11907b);
                            jSONObject.put("version_code", j2);
                            jSONObject.put("version_name", str4);
                            if (f7978k) {
                                String str6 = "decorate abi=" + next + " jo=" + jSONObject;
                            }
                            jSONArray.put(jSONObject);
                        }
                    }
                }
            } catch (JSONException e2) {
                if (f7978k) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public synchronized e g(c.a.r0.a.z2.g1.c<e> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, cVar)) == null) {
            synchronized (this) {
                this.f7985h.remove(cVar);
            }
            return this;
        }
        return (e) invokeL.objValue;
    }

    public synchronized e h(c.a.r0.a.z2.g1.c<e> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, cVar)) == null) {
            synchronized (this) {
                this.f7986i.remove(cVar);
            }
            return this;
        }
        return (e) invokeL.objValue;
    }

    public final synchronized e i(c.a.r0.a.u2.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, aVar)) == null) {
            synchronized (this) {
                if (f7978k) {
                    String str = "finish: " + k() + " finished=" + this.f7984g + " error=" + aVar;
                }
                if (this.f7984g) {
                    return this;
                }
                this.f7984g = true;
                this.f7982e = aVar;
                if (aVar == null) {
                    c.f7970d.v(k(), System.currentTimeMillis());
                }
                c.f7970d.f(k());
                t();
                e();
                return this;
            }
        }
        return (e) invokeL.objValue;
    }

    public j j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f7981d : (j) invokeV.objValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f7979b : (String) invokeV.objValue;
    }

    public j l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.f7980c == null && !TextUtils.isEmpty(this.f7979b)) {
                this.f7980c = c.a.r0.q.g.a.i().t(this.f7979b);
            }
            return this.f7980c;
        }
        return (j) invokeV.objValue;
    }

    public d.b m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f7987j : (d.b) invokeV.objValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f7984g : invokeV.booleanValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? n() && (this.f7982e == null || c.f7970d.k(k())) : invokeV.booleanValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            j jVar = this.f7981d;
            return (jVar == null || jVar == this.f7980c) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public synchronized void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            synchronized (this) {
                if (f7978k) {
                    String str = "install: " + k() + " finished=" + this.f7984g + " installing=" + this.f7983f;
                }
                if (!this.f7984g && !this.f7983f) {
                    this.f7983f = true;
                    if (f7978k) {
                        String str2 = "install: " + k();
                    }
                    c.f7970d.x(k(), new a(this));
                }
            }
        }
    }

    public boolean r(f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, fVar)) == null) ? fVar != null && fVar == this.a : invokeL.booleanValue;
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? !n() && this.f7983f : invokeV.booleanValue;
    }

    public final synchronized void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            synchronized (this) {
                if (f7978k) {
                    String str = "notifyFinish: " + k() + " mCallbacks=" + this.f7985h.size();
                }
                this.f7984g = true;
                for (c.a.r0.a.z2.g1.c<e> cVar : this.f7985h) {
                    if (cVar != null) {
                        cVar.onCallback(this);
                    }
                }
            }
        }
    }

    public synchronized e u(c.a.r0.a.z2.g1.c<e> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, cVar)) == null) {
            synchronized (this) {
                this.f7985h.add(cVar);
            }
            return this;
        }
        return (e) invokeL.objValue;
    }

    public synchronized e v(c.a.r0.a.z2.g1.c<e> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, cVar)) == null) {
            synchronized (this) {
                this.f7986i.add(cVar);
            }
            return this;
        }
        return (e) invokeL.objValue;
    }

    public e w(f fVar, j jVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048595, this, fVar, jVar)) == null) {
            if (r(fVar)) {
                this.f7981d = jVar;
            }
            return this;
        }
        return (e) invokeLL.objValue;
    }

    public synchronized void x(d.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, bVar) == null) {
            synchronized (this) {
                if (!this.f7984g && bVar != null && 0 != bVar.f7977b) {
                    this.f7987j = bVar;
                    for (c.a.r0.a.z2.g1.c<e> cVar : this.f7986i) {
                        if (cVar != null) {
                            cVar.onCallback(this);
                        }
                    }
                }
            }
        }
    }
}
