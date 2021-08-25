package c.a.o0.a.o;

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
    public String f7728a;

    /* renamed from: b  reason: collision with root package name */
    public String f7729b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.o0.f.i.p.b f7730c;

    /* renamed from: d  reason: collision with root package name */
    public c f7731d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.o0.f.i.l.f f7732e;

    /* renamed from: f  reason: collision with root package name */
    public List<c.a.o0.a.o.a> f7733f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.o0.a.o.a f7734g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.o0.a.o.a f7735h;

    /* renamed from: i  reason: collision with root package name */
    public Map<String, String> f7736i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.o0.f.i.p.a f7737j;

    /* loaded from: classes.dex */
    public class a implements c.a.o0.f.i.p.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f7738a;

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
            this.f7738a = fVar;
        }

        @Override // c.a.o0.f.i.p.a
        public void a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                if (z) {
                    this.f7738a.f7731d.b();
                    this.f7738a.f7734g.a(0);
                    for (c.a.o0.a.o.a aVar : this.f7738a.f7733f) {
                        aVar.a(0);
                        if (this.f7738a.f7733f.contains(aVar)) {
                            this.f7738a.f7733f.remove(aVar);
                        }
                    }
                    return;
                }
                this.f7738a.f7734g.a(1001);
                for (c.a.o0.a.o.a aVar2 : this.f7738a.f7733f) {
                    aVar2.a(1001);
                    if (this.f7738a.f7733f.contains(aVar2)) {
                        this.f7738a.f7733f.remove(aVar2);
                    }
                }
            }
        }

        @Override // c.a.o0.f.i.p.a
        public void b(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, str) == null) {
                if (z) {
                    this.f7738a.f7735h.a(0);
                } else {
                    this.f7738a.f7735h.a(1001);
                }
            }
        }

        @Override // c.a.o0.f.i.p.a
        public void c(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
                this.f7738a.f7731d.a(e.a(z));
            }
        }

        @Override // c.a.o0.f.i.p.a
        public void onClick(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            }
        }

        @Override // c.a.o0.f.i.p.a
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.f7738a.f7731d.c(e.b(str));
                c.a.o0.f.i.q.b.k(this.f7738a.f7736i, str);
            }
        }
    }

    public f(@NonNull JSONObject jSONObject, c cVar, c.a.o0.a.o.a aVar) {
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
        this.f7728a = "";
        this.f7736i = new TreeMap();
        this.f7737j = new a(this);
        if (jSONObject != null && !TextUtils.isEmpty(jSONObject.optString("adUnitId")) && !TextUtils.isEmpty(jSONObject.optString("appSid"))) {
            this.f7728a = jSONObject.optString("adUnitId");
            String optString = jSONObject.optString("appSid");
            this.f7729b = optString;
            this.f7736i = c.a.o0.f.i.q.b.a("video", "app", optString, this.f7728a, false);
            this.f7732e = new g();
            c.a.o0.f.i.p.b bVar = new c.a.o0.f.i.p.b(c.a.o0.a.g1.f.V().getActivity(), this.f7729b, this.f7728a, false, this.f7737j, this.f7732e);
            this.f7730c = bVar;
            bVar.k0(this.f7736i);
            this.f7733f = new CopyOnWriteArrayList();
            b(jSONObject, aVar, cVar);
            return;
        }
        aVar.a(202);
    }

    @Override // c.a.o0.a.o.b
    public synchronized void a(JSONObject jSONObject, c.a.o0.a.o.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, aVar) == null) {
            synchronized (this) {
                if (this.f7730c != null) {
                    this.f7735h = aVar;
                    this.f7730c.l0();
                }
            }
        }
    }

    @Override // c.a.o0.a.o.b
    public synchronized void b(JSONObject jSONObject, c.a.o0.a.o.a aVar, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject, aVar, cVar) == null) {
            synchronized (this) {
                this.f7731d = cVar;
                if (this.f7730c != null) {
                    this.f7734g = aVar;
                    if (aVar != null && !this.f7733f.contains(aVar)) {
                        this.f7733f.add(aVar);
                    }
                    this.f7730c.e0();
                }
            }
        }
    }
}
