package c.a.n0.a.o;

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

    /* renamed from: a  reason: collision with root package name */
    public String f7482a;

    /* renamed from: b  reason: collision with root package name */
    public String f7483b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.n0.f.i.p.b f7484c;

    /* renamed from: d  reason: collision with root package name */
    public c f7485d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.n0.f.i.l.f f7486e;

    /* renamed from: f  reason: collision with root package name */
    public List<c.a.n0.a.o.a> f7487f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.n0.a.o.a f7488g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.n0.a.o.a f7489h;

    /* renamed from: i  reason: collision with root package name */
    public Map<String, String> f7490i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.n0.f.i.p.a f7491j;

    /* loaded from: classes.dex */
    public class a implements c.a.n0.f.i.p.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f7492a;

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
            this.f7492a = fVar;
        }

        @Override // c.a.n0.f.i.p.a
        public void a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                if (z) {
                    this.f7492a.f7485d.b();
                    this.f7492a.f7488g.a(0);
                    for (c.a.n0.a.o.a aVar : this.f7492a.f7487f) {
                        aVar.a(0);
                        if (this.f7492a.f7487f.contains(aVar)) {
                            this.f7492a.f7487f.remove(aVar);
                        }
                    }
                    return;
                }
                this.f7492a.f7488g.a(1001);
                for (c.a.n0.a.o.a aVar2 : this.f7492a.f7487f) {
                    aVar2.a(1001);
                    if (this.f7492a.f7487f.contains(aVar2)) {
                        this.f7492a.f7487f.remove(aVar2);
                    }
                }
            }
        }

        @Override // c.a.n0.f.i.p.a
        public void b(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, str) == null) {
                if (z) {
                    this.f7492a.f7489h.a(0);
                } else {
                    this.f7492a.f7489h.a(1001);
                }
            }
        }

        @Override // c.a.n0.f.i.p.a
        public void c(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
                this.f7492a.f7485d.a(e.a(z));
            }
        }

        @Override // c.a.n0.f.i.p.a
        public void onClick(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            }
        }

        @Override // c.a.n0.f.i.p.a
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.f7492a.f7485d.c(e.b(str));
                c.a.n0.f.i.q.b.k(this.f7492a.f7490i, str);
            }
        }
    }

    public f(@NonNull JSONObject jSONObject, c cVar, c.a.n0.a.o.a aVar) {
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
        this.f7482a = "";
        this.f7490i = new TreeMap();
        this.f7491j = new a(this);
        if (jSONObject != null && !TextUtils.isEmpty(jSONObject.optString("adUnitId")) && !TextUtils.isEmpty(jSONObject.optString("appSid"))) {
            this.f7482a = jSONObject.optString("adUnitId");
            String optString = jSONObject.optString("appSid");
            this.f7483b = optString;
            this.f7490i = c.a.n0.f.i.q.b.a("video", "app", optString, this.f7482a, false);
            this.f7486e = new g();
            c.a.n0.f.i.p.b bVar = new c.a.n0.f.i.p.b(c.a.n0.a.g1.f.V().getActivity(), this.f7483b, this.f7482a, false, this.f7491j, this.f7486e);
            this.f7484c = bVar;
            bVar.k0(this.f7490i);
            this.f7487f = new CopyOnWriteArrayList();
            b(jSONObject, aVar, cVar);
            return;
        }
        aVar.a(202);
    }

    @Override // c.a.n0.a.o.b
    public synchronized void a(JSONObject jSONObject, c.a.n0.a.o.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, aVar) == null) {
            synchronized (this) {
                if (this.f7484c != null) {
                    this.f7489h = aVar;
                    this.f7484c.l0();
                }
            }
        }
    }

    @Override // c.a.n0.a.o.b
    public synchronized void b(JSONObject jSONObject, c.a.n0.a.o.a aVar, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject, aVar, cVar) == null) {
            synchronized (this) {
                this.f7485d = cVar;
                if (this.f7484c != null) {
                    this.f7488g = aVar;
                    if (aVar != null && !this.f7487f.contains(aVar)) {
                        this.f7487f.add(aVar);
                    }
                    this.f7484c.e0();
                }
            }
        }
    }
}
