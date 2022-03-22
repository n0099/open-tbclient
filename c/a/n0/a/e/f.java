package c.a.n0.a.e;

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
    public String f4202b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.n0.h.a.i.b f4203c;

    /* renamed from: d  reason: collision with root package name */
    public c f4204d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.n0.h.a.e.g f4205e;

    /* renamed from: f  reason: collision with root package name */
    public List<c.a.n0.a.e.a> f4206f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.n0.a.e.a f4207g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.n0.a.e.a f4208h;
    public Map<String, String> i;
    public c.a.n0.h.a.i.a j;

    /* loaded from: classes.dex */
    public class a implements c.a.n0.h.a.i.a {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fVar;
        }

        @Override // c.a.n0.h.a.i.a
        public void a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                if (z) {
                    this.a.f4204d.b();
                    this.a.f4207g.a(0);
                    for (c.a.n0.a.e.a aVar : this.a.f4206f) {
                        aVar.a(0);
                        if (this.a.f4206f.contains(aVar)) {
                            this.a.f4206f.remove(aVar);
                        }
                    }
                    return;
                }
                this.a.f4207g.a(1001);
                for (c.a.n0.a.e.a aVar2 : this.a.f4206f) {
                    aVar2.a(1001);
                    if (this.a.f4206f.contains(aVar2)) {
                        this.a.f4206f.remove(aVar2);
                    }
                }
            }
        }

        @Override // c.a.n0.h.a.i.a
        public void b(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, str) == null) {
                if (z) {
                    this.a.f4208h.a(0);
                } else {
                    this.a.f4208h.a(1001);
                }
            }
        }

        @Override // c.a.n0.h.a.i.a
        public void c(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
                this.a.f4204d.a(e.a(z));
            }
        }

        @Override // c.a.n0.h.a.i.a
        public void onClick(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            }
        }

        @Override // c.a.n0.h.a.i.a
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.a.f4204d.c(e.b(str));
                c.a.n0.h.a.j.b.k(this.a.i, str);
            }
        }
    }

    public f(@NonNull JSONObject jSONObject, c cVar, c.a.n0.a.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject, cVar, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = "";
        this.i = new TreeMap();
        this.j = new a(this);
        if (jSONObject != null && !TextUtils.isEmpty(jSONObject.optString("adUnitId")) && !TextUtils.isEmpty(jSONObject.optString("appSid"))) {
            this.a = jSONObject.optString("adUnitId");
            String optString = jSONObject.optString("appSid");
            this.f4202b = optString;
            this.i = c.a.n0.h.a.j.b.a("video", "app", optString, this.a, false);
            this.f4205e = new g();
            c.a.n0.h.a.i.b bVar = new c.a.n0.h.a.i.b(c.a.n0.a.w0.f.U().getActivity(), this.f4202b, this.a, false, this.j, this.f4205e);
            this.f4203c = bVar;
            bVar.k0(this.i);
            this.f4206f = new CopyOnWriteArrayList();
            b(jSONObject, aVar, cVar);
            return;
        }
        aVar.a(202);
    }

    @Override // c.a.n0.a.e.b
    public synchronized void a(JSONObject jSONObject, c.a.n0.a.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, aVar) == null) {
            synchronized (this) {
                if (this.f4203c != null) {
                    this.f4208h = aVar;
                    this.f4203c.l0();
                }
            }
        }
    }

    @Override // c.a.n0.a.e.b
    public synchronized void b(JSONObject jSONObject, c.a.n0.a.e.a aVar, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject, aVar, cVar) == null) {
            synchronized (this) {
                this.f4204d = cVar;
                if (this.f4203c != null) {
                    this.f4207g = aVar;
                    if (aVar != null && !this.f4206f.contains(aVar)) {
                        this.f4206f.add(aVar);
                    }
                    this.f4203c.c0();
                }
            }
        }
    }
}
