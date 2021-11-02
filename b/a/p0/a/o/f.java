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
    public String f7062a;

    /* renamed from: b  reason: collision with root package name */
    public String f7063b;

    /* renamed from: c  reason: collision with root package name */
    public b.a.p0.f.i.p.b f7064c;

    /* renamed from: d  reason: collision with root package name */
    public c f7065d;

    /* renamed from: e  reason: collision with root package name */
    public b.a.p0.f.i.l.f f7066e;

    /* renamed from: f  reason: collision with root package name */
    public List<b.a.p0.a.o.a> f7067f;

    /* renamed from: g  reason: collision with root package name */
    public b.a.p0.a.o.a f7068g;

    /* renamed from: h  reason: collision with root package name */
    public b.a.p0.a.o.a f7069h;

    /* renamed from: i  reason: collision with root package name */
    public Map<String, String> f7070i;
    public b.a.p0.f.i.p.a j;

    /* loaded from: classes.dex */
    public class a implements b.a.p0.f.i.p.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f7071a;

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
            this.f7071a = fVar;
        }

        @Override // b.a.p0.f.i.p.a
        public void a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                if (z) {
                    this.f7071a.f7065d.b();
                    this.f7071a.f7068g.a(0);
                    for (b.a.p0.a.o.a aVar : this.f7071a.f7067f) {
                        aVar.a(0);
                        if (this.f7071a.f7067f.contains(aVar)) {
                            this.f7071a.f7067f.remove(aVar);
                        }
                    }
                    return;
                }
                this.f7071a.f7068g.a(1001);
                for (b.a.p0.a.o.a aVar2 : this.f7071a.f7067f) {
                    aVar2.a(1001);
                    if (this.f7071a.f7067f.contains(aVar2)) {
                        this.f7071a.f7067f.remove(aVar2);
                    }
                }
            }
        }

        @Override // b.a.p0.f.i.p.a
        public void b(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, str) == null) {
                if (z) {
                    this.f7071a.f7069h.a(0);
                } else {
                    this.f7071a.f7069h.a(1001);
                }
            }
        }

        @Override // b.a.p0.f.i.p.a
        public void c(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
                this.f7071a.f7065d.a(e.a(z));
            }
        }

        @Override // b.a.p0.f.i.p.a
        public void onClick(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            }
        }

        @Override // b.a.p0.f.i.p.a
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.f7071a.f7065d.c(e.b(str));
                b.a.p0.f.i.q.b.k(this.f7071a.f7070i, str);
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
        this.f7062a = "";
        this.f7070i = new TreeMap();
        this.j = new a(this);
        if (jSONObject != null && !TextUtils.isEmpty(jSONObject.optString("adUnitId")) && !TextUtils.isEmpty(jSONObject.optString("appSid"))) {
            this.f7062a = jSONObject.optString("adUnitId");
            String optString = jSONObject.optString("appSid");
            this.f7063b = optString;
            this.f7070i = b.a.p0.f.i.q.b.a("video", "app", optString, this.f7062a, false);
            this.f7066e = new g();
            b.a.p0.f.i.p.b bVar = new b.a.p0.f.i.p.b(b.a.p0.a.g1.f.T().getActivity(), this.f7063b, this.f7062a, false, this.j, this.f7066e);
            this.f7064c = bVar;
            bVar.k0(this.f7070i);
            this.f7067f = new CopyOnWriteArrayList();
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
                if (this.f7064c != null) {
                    this.f7069h = aVar;
                    this.f7064c.l0();
                }
            }
        }
    }

    @Override // b.a.p0.a.o.b
    public synchronized void b(JSONObject jSONObject, b.a.p0.a.o.a aVar, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject, aVar, cVar) == null) {
            synchronized (this) {
                this.f7065d = cVar;
                if (this.f7064c != null) {
                    this.f7068g = aVar;
                    if (aVar != null && !this.f7067f.contains(aVar)) {
                        this.f7067f.add(aVar);
                    }
                    this.f7064c.e0();
                }
            }
        }
    }
}
