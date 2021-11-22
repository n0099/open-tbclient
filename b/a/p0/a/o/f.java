package b.a.p0.a.o;

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
    public String f7400a;

    /* renamed from: b  reason: collision with root package name */
    public String f7401b;

    /* renamed from: c  reason: collision with root package name */
    public b.a.p0.h.i.q.b f7402c;

    /* renamed from: d  reason: collision with root package name */
    public c f7403d;

    /* renamed from: e  reason: collision with root package name */
    public b.a.p0.h.i.m.g f7404e;

    /* renamed from: f  reason: collision with root package name */
    public List<b.a.p0.a.o.a> f7405f;

    /* renamed from: g  reason: collision with root package name */
    public b.a.p0.a.o.a f7406g;

    /* renamed from: h  reason: collision with root package name */
    public b.a.p0.a.o.a f7407h;

    /* renamed from: i  reason: collision with root package name */
    public Map<String, String> f7408i;
    public b.a.p0.h.i.q.a j;

    /* loaded from: classes.dex */
    public class a implements b.a.p0.h.i.q.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f7409a;

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
            this.f7409a = fVar;
        }

        @Override // b.a.p0.h.i.q.a
        public void a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                if (z) {
                    this.f7409a.f7403d.b();
                    this.f7409a.f7406g.a(0);
                    for (b.a.p0.a.o.a aVar : this.f7409a.f7405f) {
                        aVar.a(0);
                        if (this.f7409a.f7405f.contains(aVar)) {
                            this.f7409a.f7405f.remove(aVar);
                        }
                    }
                    return;
                }
                this.f7409a.f7406g.a(1001);
                for (b.a.p0.a.o.a aVar2 : this.f7409a.f7405f) {
                    aVar2.a(1001);
                    if (this.f7409a.f7405f.contains(aVar2)) {
                        this.f7409a.f7405f.remove(aVar2);
                    }
                }
            }
        }

        @Override // b.a.p0.h.i.q.a
        public void b(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, str) == null) {
                if (z) {
                    this.f7409a.f7407h.a(0);
                } else {
                    this.f7409a.f7407h.a(1001);
                }
            }
        }

        @Override // b.a.p0.h.i.q.a
        public void c(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
                this.f7409a.f7403d.a(e.a(z));
            }
        }

        @Override // b.a.p0.h.i.q.a
        public void onClick(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            }
        }

        @Override // b.a.p0.h.i.q.a
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.f7409a.f7403d.c(e.b(str));
                b.a.p0.h.i.r.b.k(this.f7409a.f7408i, str);
            }
        }
    }

    public f(@NonNull JSONObject jSONObject, c cVar, b.a.p0.a.o.a aVar) {
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
        this.f7400a = "";
        this.f7408i = new TreeMap();
        this.j = new a(this);
        if (jSONObject != null && !TextUtils.isEmpty(jSONObject.optString("adUnitId")) && !TextUtils.isEmpty(jSONObject.optString("appSid"))) {
            this.f7400a = jSONObject.optString("adUnitId");
            String optString = jSONObject.optString("appSid");
            this.f7401b = optString;
            this.f7408i = b.a.p0.h.i.r.b.a("video", "app", optString, this.f7400a, false);
            this.f7404e = new g();
            b.a.p0.h.i.q.b bVar = new b.a.p0.h.i.q.b(b.a.p0.a.g1.f.U().getActivity(), this.f7401b, this.f7400a, false, this.j, this.f7404e);
            this.f7402c = bVar;
            bVar.k0(this.f7408i);
            this.f7405f = new CopyOnWriteArrayList();
            b(jSONObject, aVar, cVar);
            return;
        }
        aVar.a(202);
    }

    @Override // b.a.p0.a.o.b
    public synchronized void a(JSONObject jSONObject, b.a.p0.a.o.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, aVar) == null) {
            synchronized (this) {
                if (this.f7402c != null) {
                    this.f7407h = aVar;
                    this.f7402c.l0();
                }
            }
        }
    }

    @Override // b.a.p0.a.o.b
    public synchronized void b(JSONObject jSONObject, b.a.p0.a.o.a aVar, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject, aVar, cVar) == null) {
            synchronized (this) {
                this.f7403d = cVar;
                if (this.f7402c != null) {
                    this.f7406g = aVar;
                    if (aVar != null && !this.f7405f.contains(aVar)) {
                        this.f7405f.add(aVar);
                    }
                    this.f7402c.c0();
                }
            }
        }
    }
}
