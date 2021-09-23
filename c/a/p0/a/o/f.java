package c.a.p0.a.o;

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
    public String f7764a;

    /* renamed from: b  reason: collision with root package name */
    public String f7765b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.p0.f.i.p.b f7766c;

    /* renamed from: d  reason: collision with root package name */
    public c f7767d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.p0.f.i.l.f f7768e;

    /* renamed from: f  reason: collision with root package name */
    public List<c.a.p0.a.o.a> f7769f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.p0.a.o.a f7770g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.p0.a.o.a f7771h;

    /* renamed from: i  reason: collision with root package name */
    public Map<String, String> f7772i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.p0.f.i.p.a f7773j;

    /* loaded from: classes.dex */
    public class a implements c.a.p0.f.i.p.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f7774a;

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
            this.f7774a = fVar;
        }

        @Override // c.a.p0.f.i.p.a
        public void a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                if (z) {
                    this.f7774a.f7767d.b();
                    this.f7774a.f7770g.a(0);
                    for (c.a.p0.a.o.a aVar : this.f7774a.f7769f) {
                        aVar.a(0);
                        if (this.f7774a.f7769f.contains(aVar)) {
                            this.f7774a.f7769f.remove(aVar);
                        }
                    }
                    return;
                }
                this.f7774a.f7770g.a(1001);
                for (c.a.p0.a.o.a aVar2 : this.f7774a.f7769f) {
                    aVar2.a(1001);
                    if (this.f7774a.f7769f.contains(aVar2)) {
                        this.f7774a.f7769f.remove(aVar2);
                    }
                }
            }
        }

        @Override // c.a.p0.f.i.p.a
        public void b(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, str) == null) {
                if (z) {
                    this.f7774a.f7771h.a(0);
                } else {
                    this.f7774a.f7771h.a(1001);
                }
            }
        }

        @Override // c.a.p0.f.i.p.a
        public void c(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
                this.f7774a.f7767d.a(e.a(z));
            }
        }

        @Override // c.a.p0.f.i.p.a
        public void onClick(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            }
        }

        @Override // c.a.p0.f.i.p.a
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.f7774a.f7767d.c(e.b(str));
                c.a.p0.f.i.q.b.k(this.f7774a.f7772i, str);
            }
        }
    }

    public f(@NonNull JSONObject jSONObject, c cVar, c.a.p0.a.o.a aVar) {
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
        this.f7764a = "";
        this.f7772i = new TreeMap();
        this.f7773j = new a(this);
        if (jSONObject != null && !TextUtils.isEmpty(jSONObject.optString("adUnitId")) && !TextUtils.isEmpty(jSONObject.optString("appSid"))) {
            this.f7764a = jSONObject.optString("adUnitId");
            String optString = jSONObject.optString("appSid");
            this.f7765b = optString;
            this.f7772i = c.a.p0.f.i.q.b.a("video", "app", optString, this.f7764a, false);
            this.f7768e = new g();
            c.a.p0.f.i.p.b bVar = new c.a.p0.f.i.p.b(c.a.p0.a.g1.f.V().getActivity(), this.f7765b, this.f7764a, false, this.f7773j, this.f7768e);
            this.f7766c = bVar;
            bVar.k0(this.f7772i);
            this.f7769f = new CopyOnWriteArrayList();
            b(jSONObject, aVar, cVar);
            return;
        }
        aVar.a(202);
    }

    @Override // c.a.p0.a.o.b
    public synchronized void a(JSONObject jSONObject, c.a.p0.a.o.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, aVar) == null) {
            synchronized (this) {
                if (this.f7766c != null) {
                    this.f7771h = aVar;
                    this.f7766c.l0();
                }
            }
        }
    }

    @Override // c.a.p0.a.o.b
    public synchronized void b(JSONObject jSONObject, c.a.p0.a.o.a aVar, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject, aVar, cVar) == null) {
            synchronized (this) {
                this.f7767d = cVar;
                if (this.f7766c != null) {
                    this.f7770g = aVar;
                    if (aVar != null && !this.f7769f.contains(aVar)) {
                        this.f7769f.add(aVar);
                    }
                    this.f7766c.e0();
                }
            }
        }
    }
}
