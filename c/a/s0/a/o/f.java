package c.a.s0.a.o;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f8236b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.s0.h.i.q.b f8237c;

    /* renamed from: d  reason: collision with root package name */
    public c f8238d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.s0.h.i.m.g f8239e;

    /* renamed from: f  reason: collision with root package name */
    public List<c.a.s0.a.o.a> f8240f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.s0.a.o.a f8241g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.s0.a.o.a f8242h;

    /* renamed from: i  reason: collision with root package name */
    public Map<String, String> f8243i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.s0.h.i.q.a f8244j;

    /* loaded from: classes.dex */
    public class a implements c.a.s0.h.i.q.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;

        public a(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fVar;
        }

        @Override // c.a.s0.h.i.q.a
        public void a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                if (z) {
                    this.a.f8238d.b();
                    this.a.f8241g.a(0);
                    for (c.a.s0.a.o.a aVar : this.a.f8240f) {
                        aVar.a(0);
                        if (this.a.f8240f.contains(aVar)) {
                            this.a.f8240f.remove(aVar);
                        }
                    }
                    return;
                }
                this.a.f8241g.a(1001);
                for (c.a.s0.a.o.a aVar2 : this.a.f8240f) {
                    aVar2.a(1001);
                    if (this.a.f8240f.contains(aVar2)) {
                        this.a.f8240f.remove(aVar2);
                    }
                }
            }
        }

        @Override // c.a.s0.h.i.q.a
        public void b(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, str) == null) {
                if (z) {
                    this.a.f8242h.a(0);
                } else {
                    this.a.f8242h.a(1001);
                }
            }
        }

        @Override // c.a.s0.h.i.q.a
        public void c(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
                this.a.f8238d.a(e.a(z));
            }
        }

        @Override // c.a.s0.h.i.q.a
        public void onClick(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            }
        }

        @Override // c.a.s0.h.i.q.a
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.a.f8238d.c(e.b(str));
                c.a.s0.h.i.r.b.k(this.a.f8243i, str);
            }
        }
    }

    public f(@NonNull JSONObject jSONObject, c cVar, c.a.s0.a.o.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject, cVar, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = "";
        this.f8243i = new TreeMap();
        this.f8244j = new a(this);
        if (jSONObject != null && !TextUtils.isEmpty(jSONObject.optString("adUnitId")) && !TextUtils.isEmpty(jSONObject.optString("appSid"))) {
            this.a = jSONObject.optString("adUnitId");
            String optString = jSONObject.optString("appSid");
            this.f8236b = optString;
            this.f8243i = c.a.s0.h.i.r.b.a("video", "app", optString, this.a, false);
            this.f8239e = new g();
            c.a.s0.h.i.q.b bVar = new c.a.s0.h.i.q.b(c.a.s0.a.g1.f.U().getActivity(), this.f8236b, this.a, false, this.f8244j, this.f8239e);
            this.f8237c = bVar;
            bVar.k0(this.f8243i);
            this.f8240f = new CopyOnWriteArrayList();
            b(jSONObject, aVar, cVar);
            return;
        }
        aVar.a(202);
    }

    @Override // c.a.s0.a.o.b
    public synchronized void a(JSONObject jSONObject, c.a.s0.a.o.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, aVar) == null) {
            synchronized (this) {
                if (this.f8237c != null) {
                    this.f8242h = aVar;
                    this.f8237c.l0();
                }
            }
        }
    }

    @Override // c.a.s0.a.o.b
    public synchronized void b(JSONObject jSONObject, c.a.s0.a.o.a aVar, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject, aVar, cVar) == null) {
            synchronized (this) {
                this.f8238d = cVar;
                if (this.f8237c != null) {
                    this.f8241g = aVar;
                    if (aVar != null && !this.f8240f.contains(aVar)) {
                        this.f8240f.add(aVar);
                    }
                    this.f8237c.c0();
                }
            }
        }
    }
}
