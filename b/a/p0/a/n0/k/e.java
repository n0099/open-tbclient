package b.a.p0.a.n0.k;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.k;
import b.a.p0.a.n0.k.d;
import b.a.p0.n.h.i;
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
public final class e implements b.a.p0.n.j.c<JSONArray> {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final f f6855a;

    /* renamed from: b  reason: collision with root package name */
    public final String f6856b;

    /* renamed from: c  reason: collision with root package name */
    public i f6857c;

    /* renamed from: d  reason: collision with root package name */
    public i f6858d;

    /* renamed from: e  reason: collision with root package name */
    public b.a.p0.a.q2.a f6859e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f6860f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f6861g;

    /* renamed from: h  reason: collision with root package name */
    public final Collection<b.a.p0.a.v2.e1.b<e>> f6862h;

    /* renamed from: i  reason: collision with root package name */
    public final Collection<b.a.p0.a.v2.e1.b<e>> f6863i;
    public d.b j;

    /* loaded from: classes.dex */
    public class a implements Function1<b.a.p0.a.q2.a, Unit> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f6864e;

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
            this.f6864e = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a */
        public Unit invoke(b.a.p0.a.q2.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                if (e.k) {
                    String str = "install: " + this.f6864e.k() + " onCallback";
                }
                this.f6864e.i(aVar);
                this.f6864e.f6860f = false;
                return null;
            }
            return (Unit) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1667390383, "Lb/a/p0/a/n0/k/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1667390383, "Lb/a/p0/a/n0/k/e;");
                return;
            }
        }
        k = k.f6397a;
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
        this.f6857c = null;
        this.f6858d = null;
        this.f6859e = null;
        this.f6860f = false;
        this.f6861g = false;
        this.f6862h = new HashSet();
        this.f6863i = new HashSet();
        this.j = null;
        this.f6855a = fVar;
        this.f6856b = str;
    }

    public final synchronized void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                this.f6862h.clear();
                this.f6863i.clear();
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.p0.n.j.c
    /* renamed from: f */
    public void a(@NonNull JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONArray) == null) {
            i l = l();
            if (k) {
                String str = "decorateParams libName=" + this.f6856b + " localSo=" + l;
            }
            try {
                Iterator<AbiType> it = AbiType.currentAbi().getCompatible().iterator();
                while (it.hasNext()) {
                    AbiType next = it.next();
                    if (k) {
                        String str2 = "decorateParams loop abi=" + next;
                    }
                    if (next != null) {
                        b.a.p0.n.l.a d2 = b.a.p0.n.l.a.d(this.f6856b, next);
                        if (k) {
                            String str3 = "decorateParams loop bundleId=" + d2;
                        }
                        if (d2 != null) {
                            JSONObject jSONObject = new JSONObject();
                            boolean z = l != null && next == l.q;
                            long j = (l == null || !z) ? 0L : l.f11078i;
                            String str4 = "0";
                            String str5 = (l == null || !z) ? "0" : l.j;
                            if (!TextUtils.isEmpty(str5)) {
                                str4 = str5;
                            }
                            jSONObject.put("type", "so");
                            jSONObject.put("bundle_id", d2.f11247b);
                            jSONObject.put("version_code", j);
                            jSONObject.put("version_name", str4);
                            if (k) {
                                String str6 = "decorate abi=" + next + " jo=" + jSONObject;
                            }
                            jSONArray.put(jSONObject);
                        }
                    }
                }
            } catch (JSONException e2) {
                if (k) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public synchronized e g(b.a.p0.a.v2.e1.b<e> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, bVar)) == null) {
            synchronized (this) {
                this.f6862h.remove(bVar);
            }
            return this;
        }
        return (e) invokeL.objValue;
    }

    public synchronized e h(b.a.p0.a.v2.e1.b<e> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bVar)) == null) {
            synchronized (this) {
                this.f6863i.remove(bVar);
            }
            return this;
        }
        return (e) invokeL.objValue;
    }

    public final synchronized e i(b.a.p0.a.q2.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, aVar)) == null) {
            synchronized (this) {
                if (k) {
                    String str = "finish: " + k() + " finished=" + this.f6861g + " error=" + aVar;
                }
                if (this.f6861g) {
                    return this;
                }
                this.f6861g = true;
                this.f6859e = aVar;
                if (aVar == null) {
                    c.f6843d.v(k(), System.currentTimeMillis());
                }
                c.f6843d.f(k());
                t();
                e();
                return this;
            }
        }
        return (e) invokeL.objValue;
    }

    public i j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f6858d : (i) invokeV.objValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f6856b : (String) invokeV.objValue;
    }

    public i l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.f6857c == null && !TextUtils.isEmpty(this.f6856b)) {
                this.f6857c = b.a.p0.n.g.a.h().r(this.f6856b);
            }
            return this.f6857c;
        }
        return (i) invokeV.objValue;
    }

    public d.b m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.j : (d.b) invokeV.objValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f6861g : invokeV.booleanValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? n() && (this.f6859e == null || c.f6843d.k(k())) : invokeV.booleanValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            i iVar = this.f6858d;
            return (iVar == null || iVar == this.f6857c) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public synchronized void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            synchronized (this) {
                if (k) {
                    String str = "install: " + k() + " finished=" + this.f6861g + " installing=" + this.f6860f;
                }
                if (!this.f6861g && !this.f6860f) {
                    this.f6860f = true;
                    if (k) {
                        String str2 = "install: " + k();
                    }
                    c.f6843d.x(k(), new a(this));
                }
            }
        }
    }

    public boolean r(f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, fVar)) == null) ? fVar != null && fVar == this.f6855a : invokeL.booleanValue;
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? !n() && this.f6860f : invokeV.booleanValue;
    }

    public final synchronized void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            synchronized (this) {
                if (k) {
                    String str = "notifyFinish: " + k() + " mCallbacks=" + this.f6862h.size();
                }
                this.f6861g = true;
                for (b.a.p0.a.v2.e1.b<e> bVar : this.f6862h) {
                    if (bVar != null) {
                        bVar.onCallback(this);
                    }
                }
            }
        }
    }

    public synchronized e u(b.a.p0.a.v2.e1.b<e> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, bVar)) == null) {
            synchronized (this) {
                this.f6862h.add(bVar);
            }
            return this;
        }
        return (e) invokeL.objValue;
    }

    public synchronized e v(b.a.p0.a.v2.e1.b<e> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, bVar)) == null) {
            synchronized (this) {
                this.f6863i.add(bVar);
            }
            return this;
        }
        return (e) invokeL.objValue;
    }

    public e w(f fVar, i iVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048595, this, fVar, iVar)) == null) {
            if (r(fVar)) {
                this.f6858d = iVar;
            }
            return this;
        }
        return (e) invokeLL.objValue;
    }

    public synchronized void x(d.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, bVar) == null) {
            synchronized (this) {
                if (!this.f6861g && bVar != null && 0 != bVar.f6854b) {
                    this.j = bVar;
                    for (b.a.p0.a.v2.e1.b<e> bVar2 : this.f6863i) {
                        if (bVar2 != null) {
                            bVar2.onCallback(this);
                        }
                    }
                }
            }
        }
    }
}
