package b.a.p0.a.n0.k;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.h0.m.c;
import b.a.p0.a.h0.m.k;
import b.a.p0.a.n0.k.d;
import b.a.p0.a.z2.j0;
import b.a.p0.a.z2.q0;
import b.a.p0.q.f.i;
import b.a.p0.q.j.m.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.PkgDownloadError;
import com.baidu.swan.pms.utils.AbiType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import h.d;
import h.j;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class f extends k implements b.a.p0.q.l.a.a, b.a.p0.q.k.k.c {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean q;
    public static int r;
    public static final PMSDownloadType s;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public String f7194g;

    /* renamed from: h  reason: collision with root package name */
    public j<? super b.a.p0.q.i.j> f7195h;

    /* renamed from: i  reason: collision with root package name */
    public j<b.a.p0.q.i.j> f7196i;
    public b.a.p0.q.p.g j;
    public final h k;
    public b.a.p0.q.f.e<b.a.p0.q.i.j> l;
    public final Map<String, b.a.p0.a.n0.k.e> m;
    public final Map<String, b.a.p0.q.m.a> n;
    public final b.a.p0.a.n0.k.d o;
    public final b.a.p0.q.k.c<JSONArray> p;

    /* loaded from: classes.dex */
    public class a implements b.a.p0.q.k.c<JSONArray> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f7197a;

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
            this.f7197a = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.q.k.c
        /* renamed from: b */
        public void a(@NonNull JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) || jSONArray == null || this.f7197a.m.isEmpty()) {
                return;
            }
            for (b.a.p0.a.n0.k.e eVar : this.f7197a.m.values()) {
                if (eVar != null && eVar.r(this.f7197a)) {
                    eVar.a(jSONArray);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements b.a.p0.a.z2.g1.c<b.a.p0.a.n0.k.e> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f7198e;

        public b(f fVar) {
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
            this.f7198e = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(b.a.p0.a.n0.k.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) {
                if (f.q) {
                    String unused = this.f7198e.f7194g;
                    String str = "onCallback: SoUpdating=" + eVar;
                }
                if (eVar != null) {
                    this.f7198e.o.c(eVar.k(), eVar.o());
                }
                this.f7198e.Z(null);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements b.a.p0.a.z2.g1.c<b.a.p0.a.n0.k.e> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f7199e;

        public c(f fVar) {
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
            this.f7199e = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(b.a.p0.a.n0.k.e eVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) || eVar == null) {
                return;
            }
            this.f7199e.o.d(eVar.k(), eVar.m());
        }
    }

    /* loaded from: classes.dex */
    public class d implements c.InterfaceC0234c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.q.i.j f7200a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f7201b;

        public d(f fVar, b.a.p0.q.i.j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7201b = fVar;
            this.f7200a = jVar;
        }

        @Override // b.a.p0.a.h0.m.c.InterfaceC0234c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                this.f7201b.j.m(this.f7200a);
                if (this.f7201b.f7195h != null) {
                    this.f7201b.f7195h.onNext(this.f7200a);
                    this.f7201b.f7195h.onCompleted();
                }
            }
        }

        @Override // b.a.p0.a.h0.m.c.InterfaceC0234c
        public void b(PMSDownloadType pMSDownloadType, b.a.p0.a.u2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, aVar) == null) {
                this.f7201b.j.l(this.f7200a);
                if (this.f7201b.f7195h != null) {
                    this.f7201b.f7195h.onError(new PkgDownloadError(this.f7200a, aVar));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements d.a<b.a.p0.q.i.j> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f7202e;

        public e(f fVar) {
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
            this.f7202e = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.d.a, h.n.b
        public void call(j<? super b.a.p0.q.i.j> jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
                this.f7202e.f7195h = jVar;
            }
        }
    }

    /* renamed from: b.a.p0.a.n0.k.f$f  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0321f extends j<b.a.p0.q.i.j> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ f f7203i;

        public C0321f(f fVar) {
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
            this.f7203i = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.e
        /* renamed from: g */
        public void onNext(b.a.p0.q.i.j jVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) && f.q) {
                String unused = this.f7203i.f7194g;
                String str = "PkgDlSubscriber 单个包下载、业务层处理完成：" + jVar.toString();
            }
        }

        @Override // h.e
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (f.q) {
                    String unused = this.f7203i.f7194g;
                }
                this.f7203i.e0(null);
            }
        }

        @Override // h.e
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                if (f.q) {
                    String unused = this.f7203i.f7194g;
                    String str = "PkgDlSubscriber 包下载、业务层处理 OnError：" + th.toString();
                }
                this.f7203i.e0(new Exception("failed by Download error = ", th));
            }
        }

        public /* synthetic */ C0321f(f fVar, a aVar) {
            this(fVar);
        }
    }

    /* loaded from: classes.dex */
    public class g extends b.a.p0.q.f.b<b.a.p0.q.i.j> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f7204e;

        public g(f fVar) {
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
            this.f7204e = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.q.f.e
        /* renamed from: l */
        public String d(b.a.p0.q.i.j jVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, jVar)) == null) {
                String g2 = b.a.p0.a.n0.k.c.f7172d.g(jVar);
                if (f.q) {
                    String unused = this.f7204e.f7194g;
                    String str = "SoDlCallback getDownloadPath: so=" + jVar.f11774g + " path=" + g2;
                }
                return g2;
            }
            return (String) invokeL.objValue;
        }

        @Override // b.a.p0.q.f.g
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) ? this.f7204e.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.q.f.b, b.a.p0.q.f.e
        /* renamed from: o */
        public void e(b.a.p0.q.i.j jVar, b.a.p0.q.i.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jVar, bVar) == null) {
                super.e(jVar, bVar);
                if (f.q) {
                    String unused = this.f7204e.f7194g;
                    String str = "SoDlCallback onDownloadError: so=" + jVar.f11774g + " err=" + bVar;
                }
                this.f7204e.j.l(jVar);
                b.a.p0.a.u2.a aVar = new b.a.p0.a.u2.a();
                aVar.k(13L);
                aVar.i(bVar.f11762a);
                aVar.d("so包下载失败");
                aVar.f(bVar.toString());
                if (this.f7204e.f7195h != null) {
                    this.f7204e.f7195h.onError(new PkgDownloadError(jVar, aVar));
                }
                b.a.p0.a.h0.m.c.c().a(jVar, f.s, aVar);
                b.a.p0.w.d.k(jVar.f11768a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.q.f.b, b.a.p0.q.f.e
        /* renamed from: p */
        public void i(b.a.p0.q.i.j jVar) {
            b.a.p0.q.m.a aVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, jVar) == null) {
                super.i(jVar);
                if (f.q) {
                    String unused = this.f7204e.f7194g;
                    String str = "SoDlCallback onDownloadFinish: so=" + jVar;
                }
                String str2 = jVar.p;
                if (TextUtils.isEmpty(str2) && (aVar = (b.a.p0.q.m.a) this.f7204e.n.get(jVar.f11774g)) != null) {
                    str2 = aVar.f11964a;
                }
                b.a.p0.a.n0.k.e a0 = this.f7204e.a0(str2);
                if (a0 != null) {
                    boolean a2 = j0.a(new File(jVar.f11768a), jVar.m);
                    if (f.q) {
                        String unused2 = this.f7204e.f7194g;
                        String str3 = "SoDlCallback onDownloadFinish: bundle=" + jVar.f11774g + " checkSign=" + a2;
                    }
                    boolean z = true;
                    z = (f.q && !q0.G() && b.a.p0.a.x1.a.a.j() == 1) ? false : false;
                    if (a2 || z) {
                        b.a.p0.q.g.a.i().m(jVar);
                        if (f.q) {
                            String unused3 = this.f7204e.f7194g;
                            String str4 = "SoDlCallback onDownloadFinish: updating=" + a0 + " libName=" + str2;
                        }
                    }
                    a0.q();
                }
                this.f7204e.j.m(jVar);
                if (this.f7204e.f7195h != null) {
                    this.f7204e.f7195h.onNext(jVar);
                    this.f7204e.f7195h.onCompleted();
                }
                b.a.p0.a.h0.m.c.c().b(jVar, f.s);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.q.f.b, b.a.p0.q.f.e
        /* renamed from: q */
        public void a(b.a.p0.q.i.j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, jVar) == null) {
                super.a(jVar);
                b.a.p0.q.m.a aVar = (b.a.p0.q.m.a) this.f7204e.n.get(jVar.f11774g);
                b.a.p0.a.n0.k.e a0 = this.f7204e.a0(aVar == null ? null : aVar.f11964a);
                if (a0 != null) {
                    a0.x(new d.b(jVar.f11769b, jVar.k));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.q.f.b, b.a.p0.q.f.e
        /* renamed from: r */
        public void c(b.a.p0.q.i.j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, jVar) == null) {
                super.c(jVar);
                if (f.q) {
                    String unused = this.f7204e.f7194g;
                    String str = "SoDlCallback onDownloadStart: so=" + jVar.f11774g;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.q.f.b, b.a.p0.q.f.e
        /* renamed from: s */
        public void f(b.a.p0.q.i.j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, jVar) == null) {
                super.f(jVar);
                if (f.q) {
                    String unused = this.f7204e.f7194g;
                    String str = "SoDlCallback onDownloading: so=" + jVar.f11774g;
                }
                this.f7204e.f0(jVar);
            }
        }

        public /* synthetic */ g(f fVar, a aVar) {
            this(fVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1667390352, "Lb/a/p0/a/n0/k/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1667390352, "Lb/a/p0/a/n0/k/f;");
                return;
            }
        }
        q = b.a.p0.a.k.f6863a;
        r = 0;
        s = PMSDownloadType.SO_LIB;
    }

    public f(h hVar, b.a.p0.a.n0.k.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hVar, dVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f7194g = "SwanSoUpdater";
        this.m = new HashMap();
        this.n = new HashMap();
        this.p = new a(this);
        StringBuilder sb = new StringBuilder();
        sb.append(this.f7194g);
        int i4 = r;
        r = i4 + 1;
        sb.append(i4);
        this.f7194g = sb.toString();
        if (q) {
            String str = "SwanSoUpdater: config=" + dVar + " trace=" + Log.getStackTraceString(new Exception());
        }
        this.k = hVar;
        this.o = dVar;
        if (dVar != null) {
            Iterator<String> it = dVar.a().iterator();
            while (it.hasNext()) {
                String next = it.next();
                b.a.p0.a.n0.k.a a2 = b.a.p0.a.n0.k.b.a(next);
                if (a2 == null) {
                    dVar.c(next, false);
                } else if (a2.f()) {
                    dVar.c(next, true);
                } else {
                    String e2 = a2.e();
                    b.a.p0.a.n0.k.e t = b.a.p0.a.n0.k.c.f7172d.t(this, e2);
                    b bVar = new b(this);
                    c cVar = new c(this);
                    t.u(bVar);
                    t.v(cVar);
                    this.m.put(e2, t);
                    this.n.putAll(b.a.p0.q.m.a.b(e2));
                }
            }
        }
        if (q) {
            String str2 = "SoNodeHandler() start mUpdatings=" + this.m.size();
        }
        if (this.m.isEmpty()) {
            e0(null);
        }
    }

    @Override // b.a.p0.q.f.i
    public void C(b.a.p0.q.i.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            super.C(bVar);
            if (q) {
                String str = "onFetchError: " + bVar.toString();
            }
            e0(new Exception("failed by fetch error = " + bVar));
        }
    }

    @Override // b.a.p0.q.f.i
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.E();
            boolean z = q;
        }
    }

    @Override // b.a.p0.q.f.i
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.F();
            boolean z = q;
            e0(null);
        }
    }

    @Override // b.a.p0.q.f.i
    public void G(b.a.p0.q.p.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, gVar) == null) {
            if (q) {
                StringBuilder sb = new StringBuilder();
                sb.append("onPrepareDownload: countSet.size=");
                sb.append(gVar == null ? 0 : gVar.n());
                sb.toString();
            }
            super.G(gVar);
            if (gVar == null) {
                return;
            }
            this.j = gVar;
            if (gVar.k()) {
                return;
            }
            c0();
        }
    }

    public final void Z(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, exc) == null) {
            if (q) {
                String str = "finishWithUpdatingCheck: updatings=" + this.m.size() + " e=" + exc;
            }
            for (b.a.p0.a.n0.k.e eVar : this.m.values()) {
                if (!eVar.n()) {
                    if (q) {
                        String str2 = "finishWithUpdatingCheck: return by wait for=" + eVar;
                        return;
                    }
                    return;
                }
            }
            d0(exc);
        }
    }

    public final b.a.p0.a.n0.k.e a0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            b.a.p0.a.n0.k.e eVar = this.m.get(str);
            if (eVar == null || !eVar.r(this)) {
                return null;
            }
            return eVar;
        }
        return (b.a.p0.a.n0.k.e) invokeL.objValue;
    }

    public final j<b.a.p0.q.i.j> b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.f7196i == null) {
                this.f7196i = new C0321f(this, null);
            }
            return this.f7196i;
        }
        return (j) invokeV.objValue;
    }

    public final void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            ArrayList arrayList = new ArrayList();
            if (this.j.g()) {
                arrayList.add(h.d.a(new e(this)));
            }
            if (arrayList.isEmpty()) {
                return;
            }
            h.d.i(arrayList).u(b0());
        }
    }

    public final void d0(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, exc) == null) {
            if (q) {
                String str = "notifyFinalCallback: e=" + Log.getStackTraceString(exc);
            }
            b.a.p0.a.n0.k.d dVar = this.o;
            if (dVar != null) {
                dVar.b(exc);
            }
        }
    }

    public final void e0(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, exc) == null) {
            if (q) {
                String str = "notifyPmsFinish: updatings=" + this.m.size() + " e=" + exc;
            }
            for (b.a.p0.a.n0.k.e eVar : this.m.values()) {
                if (eVar != null && eVar.r(this) && !eVar.n() && !eVar.s()) {
                    if (q) {
                        String str2 = "notifyPmsFinish: try install updating=" + eVar;
                    }
                    eVar.q();
                }
            }
            Z(exc);
        }
    }

    public final void f0(b.a.p0.q.i.j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, jVar) == null) {
            b.a.p0.a.h0.m.c.c().d(jVar, new d(this, jVar));
        }
    }

    @Override // b.a.p0.q.l.a.a
    public b.a.p0.q.k.c<JSONArray> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.p : (b.a.p0.q.k.c) invokeV.objValue;
    }

    public final void g0(b.a.p0.q.i.j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, jVar) == null) {
            if (q) {
                String str = "SoNodeHandler updateBestSo start so=" + jVar;
            }
            if (jVar == null) {
                boolean z = q;
                return;
            }
            b.a.p0.q.m.a aVar = this.n.get(jVar.f11774g);
            if (aVar == null) {
                if (q) {
                    String str2 = "SoNodeHandler updateBestSo end by illegal bundleId=" + jVar.f11774g;
                    return;
                }
                return;
            }
            if (TextUtils.isEmpty(jVar.p)) {
                jVar.p = aVar.f11964a;
            }
            b.a.p0.a.n0.k.e a0 = a0(jVar.p);
            if (a0 == null) {
                if (q) {
                    String str3 = "SoNodeHandler updateBestSo end by no updating lib=" + jVar.p;
                    return;
                }
                return;
            }
            if (jVar.q == null) {
                jVar.q = aVar.f11966c;
            }
            if (!AbiType.currentAbi().compat(jVar.q)) {
                boolean z2 = q;
                return;
            }
            b.a.p0.q.i.j l = a0.l();
            b.a.p0.q.i.j j = a0.j();
            long max = Math.max(j != null ? j.f11776i : 0L, l == null ? 0L : l.f11776i);
            long j2 = jVar.f11776i;
            if (j2 < max) {
                if (q) {
                    String.format("SoNodeHandler updateBestSo end by not bestVer(%d) libVer(%d)", Long.valueOf(max), Long.valueOf(jVar.f11776i));
                }
            } else if (j2 > max) {
                if (q) {
                    String str4 = "SoNodeHandler updateBestSo end by update bestVer=" + jVar.f11776i;
                }
                a0.w(this, jVar);
            } else {
                if (j == null || !j.q.compat(jVar.q)) {
                    if (q) {
                        String str5 = "SoNodeHandler updateBestSo end by update abi update=" + jVar.q;
                    }
                    a0.w(this, jVar);
                }
                boolean z3 = q;
            }
        }
    }

    @Override // b.a.p0.q.l.a.a
    @Nullable
    public h getRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.k : (h) invokeV.objValue;
    }

    @Override // b.a.p0.q.k.k.c
    public void handle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            b.a.p0.q.k.k.a aVar = new b.a.p0.q.k.k.a();
            b.a.p0.q.p.g gVar = new b.a.p0.q.p.g();
            boolean z = q;
            boolean z2 = true;
            if ((q && !q0.G() && b.a.p0.a.x1.a.a.j() == 1) ? false : false) {
                String i2 = b.a.p0.a.x1.a.a.i();
                if (!TextUtils.isEmpty(i2)) {
                    try {
                        b.a.p0.q.i.j jVar = (b.a.p0.q.i.j) b.a.p0.q.p.f.j(new JSONObject(i2), new b.a.p0.q.i.j());
                        jVar.f11774g = "so_zeus_armeabi";
                        g0(jVar);
                        b.a.p0.a.c2.b.f.e.g(AppRuntime.getAppContext(), AppRuntime.getAppContext().getString(b.a.p0.a.h.swan_app_debug_so_info_success)).G();
                    } catch (JSONException e2) {
                        b.a.p0.a.c2.b.f.e.g(AppRuntime.getAppContext(), AppRuntime.getAppContext().getString(b.a.p0.a.h.swan_app_debug_so_info_error)).G();
                        e2.printStackTrace();
                    }
                }
            }
            for (b.a.p0.a.n0.k.e eVar : this.m.values()) {
                if (eVar.r(this)) {
                    g0(eVar.l());
                    b.a.p0.q.i.j j = eVar.j();
                    if (eVar.p() && j != null) {
                        if (q) {
                            String str = "SoNodeHandler handle for bestSo=" + j;
                        }
                        b.a.p0.q.k.k.b.b(j, gVar);
                        if (aVar.f11959d == null) {
                            aVar.f11959d = new ArrayList();
                        }
                        aVar.f11959d.add(j);
                    } else {
                        boolean z3 = q;
                        eVar.q();
                    }
                }
            }
            if (q) {
                String str2 = "SoNodeHandler handle soSet.pkgSize()=" + gVar.n();
            }
            if (gVar.n() == 0) {
                boolean z4 = q;
                F();
                return;
            }
            boolean z5 = q;
            G(gVar);
            b.a.p0.q.j.i.a.e(aVar, this);
        }
    }

    @Override // b.a.p0.q.k.k.c
    public void l(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, jSONObject) == null) {
            if (q) {
                String str = "SoNodeHandler parseData start data=" + jSONObject;
            }
            if (jSONObject != null) {
                g0((b.a.p0.q.i.j) b.a.p0.q.p.f.j(jSONObject, new b.a.p0.q.i.j()));
            }
        }
    }

    @Override // b.a.p0.q.l.a.a
    public i o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this : (i) invokeV.objValue;
    }

    @Override // b.a.p0.q.f.i
    public b.a.p0.q.k.k.c w(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) ? TextUtils.equals("so", str) ? this : super.w(str) : (b.a.p0.q.k.k.c) invokeL.objValue;
    }

    @Override // b.a.p0.q.f.i
    public b.a.p0.q.f.e<b.a.p0.q.i.j> z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.l == null) {
                this.l = new g(this, null);
            }
            return this.l;
        }
        return (b.a.p0.q.f.e) invokeV.objValue;
    }
}
