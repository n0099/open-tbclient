package c.a.p0.a.n0.k;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.k;
import c.a.p0.a.n0.k.d;
import c.a.p0.q.i.j;
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
public final class e implements c.a.p0.q.k.c<JSONArray> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: k  reason: collision with root package name */
    public static final boolean f6934k;
    public transient /* synthetic */ FieldHolder $fh;
    public final f a;

    /* renamed from: b  reason: collision with root package name */
    public final String f6935b;

    /* renamed from: c  reason: collision with root package name */
    public j f6936c;

    /* renamed from: d  reason: collision with root package name */
    public j f6937d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.p0.a.u2.a f6938e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f6939f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f6940g;

    /* renamed from: h  reason: collision with root package name */
    public final Collection<c.a.p0.a.z2.g1.c<e>> f6941h;

    /* renamed from: i  reason: collision with root package name */
    public final Collection<c.a.p0.a.z2.g1.c<e>> f6942i;

    /* renamed from: j  reason: collision with root package name */
    public d.b f6943j;

    /* loaded from: classes.dex */
    public class a implements Function1<c.a.p0.a.u2.a, Unit> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f6944e;

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
            this.f6944e = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a */
        public Unit invoke(c.a.p0.a.u2.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                if (e.f6934k) {
                    String str = "install: " + this.f6944e.k() + " onCallback";
                }
                this.f6944e.i(aVar);
                this.f6944e.f6939f = false;
                return null;
            }
            return (Unit) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2117042736, "Lc/a/p0/a/n0/k/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2117042736, "Lc/a/p0/a/n0/k/e;");
                return;
            }
        }
        f6934k = k.a;
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
        this.f6936c = null;
        this.f6937d = null;
        this.f6938e = null;
        this.f6939f = false;
        this.f6940g = false;
        this.f6941h = new HashSet();
        this.f6942i = new HashSet();
        this.f6943j = null;
        this.a = fVar;
        this.f6935b = str;
    }

    public final synchronized void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                this.f6941h.clear();
                this.f6942i.clear();
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.q.k.c
    /* renamed from: f */
    public void a(@NonNull JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONArray) == null) {
            j l = l();
            if (f6934k) {
                String str = "decorateParams libName=" + this.f6935b + " localSo=" + l;
            }
            try {
                Iterator<AbiType> it = AbiType.currentAbi().getCompatible().iterator();
                while (it.hasNext()) {
                    AbiType next = it.next();
                    if (f6934k) {
                        String str2 = "decorateParams loop abi=" + next;
                    }
                    if (next != null) {
                        c.a.p0.q.m.a d2 = c.a.p0.q.m.a.d(this.f6935b, next);
                        if (f6934k) {
                            String str3 = "decorateParams loop bundleId=" + d2;
                        }
                        if (d2 != null) {
                            JSONObject jSONObject = new JSONObject();
                            boolean z = l != null && next == l.q;
                            long j2 = (l == null || !z) ? 0L : l.f10719i;
                            String str4 = "0";
                            String str5 = (l == null || !z) ? "0" : l.f10720j;
                            if (!TextUtils.isEmpty(str5)) {
                                str4 = str5;
                            }
                            jSONObject.put("type", "so");
                            jSONObject.put("bundle_id", d2.f10863b);
                            jSONObject.put("version_code", j2);
                            jSONObject.put("version_name", str4);
                            if (f6934k) {
                                String str6 = "decorate abi=" + next + " jo=" + jSONObject;
                            }
                            jSONArray.put(jSONObject);
                        }
                    }
                }
            } catch (JSONException e2) {
                if (f6934k) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public synchronized e g(c.a.p0.a.z2.g1.c<e> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, cVar)) == null) {
            synchronized (this) {
                this.f6941h.remove(cVar);
            }
            return this;
        }
        return (e) invokeL.objValue;
    }

    public synchronized e h(c.a.p0.a.z2.g1.c<e> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, cVar)) == null) {
            synchronized (this) {
                this.f6942i.remove(cVar);
            }
            return this;
        }
        return (e) invokeL.objValue;
    }

    public final synchronized e i(c.a.p0.a.u2.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, aVar)) == null) {
            synchronized (this) {
                if (f6934k) {
                    String str = "finish: " + k() + " finished=" + this.f6940g + " error=" + aVar;
                }
                if (this.f6940g) {
                    return this;
                }
                this.f6940g = true;
                this.f6938e = aVar;
                if (aVar == null) {
                    c.f6926d.v(k(), System.currentTimeMillis());
                }
                c.f6926d.f(k());
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f6937d : (j) invokeV.objValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f6935b : (String) invokeV.objValue;
    }

    public j l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.f6936c == null && !TextUtils.isEmpty(this.f6935b)) {
                this.f6936c = c.a.p0.q.g.a.i().t(this.f6935b);
            }
            return this.f6936c;
        }
        return (j) invokeV.objValue;
    }

    public d.b m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f6943j : (d.b) invokeV.objValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f6940g : invokeV.booleanValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? n() && (this.f6938e == null || c.f6926d.k(k())) : invokeV.booleanValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            j jVar = this.f6937d;
            return (jVar == null || jVar == this.f6936c) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public synchronized void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            synchronized (this) {
                if (f6934k) {
                    String str = "install: " + k() + " finished=" + this.f6940g + " installing=" + this.f6939f;
                }
                if (!this.f6940g && !this.f6939f) {
                    this.f6939f = true;
                    if (f6934k) {
                        String str2 = "install: " + k();
                    }
                    c.f6926d.x(k(), new a(this));
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? !n() && this.f6939f : invokeV.booleanValue;
    }

    public final synchronized void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            synchronized (this) {
                if (f6934k) {
                    String str = "notifyFinish: " + k() + " mCallbacks=" + this.f6941h.size();
                }
                this.f6940g = true;
                for (c.a.p0.a.z2.g1.c<e> cVar : this.f6941h) {
                    if (cVar != null) {
                        cVar.onCallback(this);
                    }
                }
            }
        }
    }

    public synchronized e u(c.a.p0.a.z2.g1.c<e> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, cVar)) == null) {
            synchronized (this) {
                this.f6941h.add(cVar);
            }
            return this;
        }
        return (e) invokeL.objValue;
    }

    public synchronized e v(c.a.p0.a.z2.g1.c<e> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, cVar)) == null) {
            synchronized (this) {
                this.f6942i.add(cVar);
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
                this.f6937d = jVar;
            }
            return this;
        }
        return (e) invokeLL.objValue;
    }

    public synchronized void x(d.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, bVar) == null) {
            synchronized (this) {
                if (!this.f6940g && bVar != null && 0 != bVar.f6933b) {
                    this.f6943j = bVar;
                    for (c.a.p0.a.z2.g1.c<e> cVar : this.f6942i) {
                        if (cVar != null) {
                            cVar.onCallback(this);
                        }
                    }
                }
            }
        }
    }
}
