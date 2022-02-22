package c.a.s0.a.n0.k;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.a.h0.m.c;
import c.a.s0.a.h0.m.k;
import c.a.s0.a.n0.k.d;
import c.a.s0.a.z2.j0;
import c.a.s0.a.z2.q0;
import c.a.s0.q.f.i;
import c.a.s0.q.j.m.h;
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
import i.d;
import i.j;
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
public final class f extends k implements c.a.s0.q.l.a.a, c.a.s0.q.k.k.c {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean q;
    public static int r;
    public static final PMSDownloadType s;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public String f8055g;

    /* renamed from: h  reason: collision with root package name */
    public j<? super c.a.s0.q.i.j> f8056h;

    /* renamed from: i  reason: collision with root package name */
    public j<c.a.s0.q.i.j> f8057i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.s0.q.p.g f8058j;
    public final h k;
    public c.a.s0.q.f.e<c.a.s0.q.i.j> l;
    public final Map<String, c.a.s0.a.n0.k.e> m;
    public final Map<String, c.a.s0.q.m.a> n;
    public final c.a.s0.a.n0.k.d o;
    public final c.a.s0.q.k.c<JSONArray> p;

    /* loaded from: classes.dex */
    public class a implements c.a.s0.q.k.c<JSONArray> {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.s0.q.k.c
        /* renamed from: b */
        public void a(@NonNull JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) || jSONArray == null || this.a.m.isEmpty()) {
                return;
            }
            for (c.a.s0.a.n0.k.e eVar : this.a.m.values()) {
                if (eVar != null && eVar.r(this.a)) {
                    eVar.a(jSONArray);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.a.s0.a.z2.g1.c<c.a.s0.a.n0.k.e> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f8059e;

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
            this.f8059e = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.s0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.s0.a.n0.k.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) {
                if (f.q) {
                    String unused = this.f8059e.f8055g;
                    String str = "onCallback: SoUpdating=" + eVar;
                }
                if (eVar != null) {
                    this.f8059e.o.c(eVar.k(), eVar.o());
                }
                this.f8059e.a0(null);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements c.a.s0.a.z2.g1.c<c.a.s0.a.n0.k.e> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f8060e;

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
            this.f8060e = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.s0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.s0.a.n0.k.e eVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) || eVar == null) {
                return;
            }
            this.f8060e.o.d(eVar.k(), eVar.m());
        }
    }

    /* loaded from: classes.dex */
    public class d implements c.InterfaceC0403c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.s0.q.i.j a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f8061b;

        public d(f fVar, c.a.s0.q.i.j jVar) {
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
            this.f8061b = fVar;
            this.a = jVar;
        }

        @Override // c.a.s0.a.h0.m.c.InterfaceC0403c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                this.f8061b.f8058j.m(this.a);
                if (this.f8061b.f8056h != null) {
                    this.f8061b.f8056h.onNext(this.a);
                    this.f8061b.f8056h.onCompleted();
                }
            }
        }

        @Override // c.a.s0.a.h0.m.c.InterfaceC0403c
        public void b(PMSDownloadType pMSDownloadType, c.a.s0.a.u2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, aVar) == null) {
                this.f8061b.f8058j.l(this.a);
                if (this.f8061b.f8056h != null) {
                    this.f8061b.f8056h.onError(new PkgDownloadError(this.a, aVar));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements d.a<c.a.s0.q.i.j> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f8062e;

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
            this.f8062e = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // i.d.a, i.n.b
        public void call(j<? super c.a.s0.q.i.j> jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
                this.f8062e.f8056h = jVar;
            }
        }
    }

    /* renamed from: c.a.s0.a.n0.k.f$f  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0490f extends j<c.a.s0.q.i.j> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ f f8063i;

        public C0490f(f fVar) {
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
            this.f8063i = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // i.e
        /* renamed from: g */
        public void onNext(c.a.s0.q.i.j jVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) && f.q) {
                String unused = this.f8063i.f8055g;
                String str = "PkgDlSubscriber 单个包下载、业务层处理完成：" + jVar.toString();
            }
        }

        @Override // i.e
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (f.q) {
                    String unused = this.f8063i.f8055g;
                }
                this.f8063i.f0(null);
            }
        }

        @Override // i.e
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                if (f.q) {
                    String unused = this.f8063i.f8055g;
                    String str = "PkgDlSubscriber 包下载、业务层处理 OnError：" + th.toString();
                }
                this.f8063i.f0(new Exception("failed by Download error = ", th));
            }
        }

        public /* synthetic */ C0490f(f fVar, a aVar) {
            this(fVar);
        }
    }

    /* loaded from: classes.dex */
    public class g extends c.a.s0.q.f.b<c.a.s0.q.i.j> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f8064e;

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
            this.f8064e = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.s0.q.f.e
        /* renamed from: l */
        public String d(c.a.s0.q.i.j jVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, jVar)) == null) {
                String g2 = c.a.s0.a.n0.k.c.f8037d.g(jVar);
                if (f.q) {
                    String unused = this.f8064e.f8055g;
                    String str = "SoDlCallback getDownloadPath: so=" + jVar.f11736g + " path=" + g2;
                }
                return g2;
            }
            return (String) invokeL.objValue;
        }

        @Override // c.a.s0.q.f.g
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) ? this.f8064e.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.s0.q.f.b, c.a.s0.q.f.e
        /* renamed from: o */
        public void e(c.a.s0.q.i.j jVar, c.a.s0.q.i.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jVar, bVar) == null) {
                super.e(jVar, bVar);
                if (f.q) {
                    String unused = this.f8064e.f8055g;
                    String str = "SoDlCallback onDownloadError: so=" + jVar.f11736g + " err=" + bVar;
                }
                this.f8064e.f8058j.l(jVar);
                c.a.s0.a.u2.a aVar = new c.a.s0.a.u2.a();
                aVar.k(13L);
                aVar.i(bVar.a);
                aVar.d("so包下载失败");
                aVar.f(bVar.toString());
                if (this.f8064e.f8056h != null) {
                    this.f8064e.f8056h.onError(new PkgDownloadError(jVar, aVar));
                }
                c.a.s0.a.h0.m.c.c().a(jVar, f.s, aVar);
                c.a.s0.w.d.k(jVar.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.s0.q.f.b, c.a.s0.q.f.e
        /* renamed from: p */
        public void i(c.a.s0.q.i.j jVar) {
            c.a.s0.q.m.a aVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, jVar) == null) {
                super.i(jVar);
                if (f.q) {
                    String unused = this.f8064e.f8055g;
                    String str = "SoDlCallback onDownloadFinish: so=" + jVar;
                }
                String str2 = jVar.p;
                if (TextUtils.isEmpty(str2) && (aVar = (c.a.s0.q.m.a) this.f8064e.n.get(jVar.f11736g)) != null) {
                    str2 = aVar.a;
                }
                c.a.s0.a.n0.k.e b0 = this.f8064e.b0(str2);
                if (b0 != null) {
                    boolean a = j0.a(new File(jVar.a), jVar.m);
                    if (f.q) {
                        String unused2 = this.f8064e.f8055g;
                        String str3 = "SoDlCallback onDownloadFinish: bundle=" + jVar.f11736g + " checkSign=" + a;
                    }
                    boolean z = true;
                    z = (f.q && !q0.G() && c.a.s0.a.x1.a.a.j() == 1) ? false : false;
                    if (a || z) {
                        c.a.s0.q.g.a.i().m(jVar);
                        if (f.q) {
                            String unused3 = this.f8064e.f8055g;
                            String str4 = "SoDlCallback onDownloadFinish: updating=" + b0 + " libName=" + str2;
                        }
                    }
                    b0.q();
                }
                this.f8064e.f8058j.m(jVar);
                if (this.f8064e.f8056h != null) {
                    this.f8064e.f8056h.onNext(jVar);
                    this.f8064e.f8056h.onCompleted();
                }
                c.a.s0.a.h0.m.c.c().b(jVar, f.s);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.s0.q.f.b, c.a.s0.q.f.e
        /* renamed from: q */
        public void a(c.a.s0.q.i.j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, jVar) == null) {
                super.a(jVar);
                c.a.s0.q.m.a aVar = (c.a.s0.q.m.a) this.f8064e.n.get(jVar.f11736g);
                c.a.s0.a.n0.k.e b0 = this.f8064e.b0(aVar == null ? null : aVar.a);
                if (b0 != null) {
                    b0.x(new d.b(jVar.f11731b, jVar.k));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.s0.q.f.b, c.a.s0.q.f.e
        /* renamed from: r */
        public void c(c.a.s0.q.i.j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, jVar) == null) {
                super.c(jVar);
                if (f.q) {
                    String unused = this.f8064e.f8055g;
                    String str = "SoDlCallback onDownloadStart: so=" + jVar.f11736g;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.s0.q.f.b, c.a.s0.q.f.e
        /* renamed from: s */
        public void f(c.a.s0.q.i.j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, jVar) == null) {
                super.f(jVar);
                if (f.q) {
                    String unused = this.f8064e.f8055g;
                    String str = "SoDlCallback onDownloading: so=" + jVar.f11736g;
                }
                this.f8064e.g0(jVar);
            }
        }

        public /* synthetic */ g(f fVar, a aVar) {
            this(fVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1790676372, "Lc/a/s0/a/n0/k/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1790676372, "Lc/a/s0/a/n0/k/f;");
                return;
            }
        }
        q = c.a.s0.a.k.a;
        r = 0;
        s = PMSDownloadType.SO_LIB;
    }

    public f(h hVar, c.a.s0.a.n0.k.d dVar) {
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
        this.f8055g = "SwanSoUpdater";
        this.m = new HashMap();
        this.n = new HashMap();
        this.p = new a(this);
        StringBuilder sb = new StringBuilder();
        sb.append(this.f8055g);
        int i4 = r;
        r = i4 + 1;
        sb.append(i4);
        this.f8055g = sb.toString();
        if (q) {
            String str = "SwanSoUpdater: config=" + dVar + " trace=" + Log.getStackTraceString(new Exception());
        }
        this.k = hVar;
        this.o = dVar;
        if (dVar != null) {
            Iterator<String> it = dVar.a().iterator();
            while (it.hasNext()) {
                String next = it.next();
                c.a.s0.a.n0.k.a a2 = c.a.s0.a.n0.k.b.a(next);
                if (a2 == null) {
                    dVar.c(next, false);
                } else if (a2.f()) {
                    dVar.c(next, true);
                } else {
                    String e2 = a2.e();
                    c.a.s0.a.n0.k.e t = c.a.s0.a.n0.k.c.f8037d.t(this, e2);
                    b bVar = new b(this);
                    c cVar = new c(this);
                    t.u(bVar);
                    t.v(cVar);
                    this.m.put(e2, t);
                    this.n.putAll(c.a.s0.q.m.a.b(e2));
                }
            }
        }
        if (q) {
            String str2 = "SoNodeHandler() start mUpdatings=" + this.m.size();
        }
        if (this.m.isEmpty()) {
            f0(null);
        }
    }

    @Override // c.a.s0.q.f.i
    public c.a.s0.q.f.e<c.a.s0.q.i.j> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.l == null) {
                this.l = new g(this, null);
            }
            return this.l;
        }
        return (c.a.s0.q.f.e) invokeV.objValue;
    }

    @Override // c.a.s0.q.f.i
    public void D(c.a.s0.q.i.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            super.D(bVar);
            if (q) {
                String str = "onFetchError: " + bVar.toString();
            }
            f0(new Exception("failed by fetch error = " + bVar));
        }
    }

    @Override // c.a.s0.q.f.i
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.F();
            boolean z = q;
        }
    }

    @Override // c.a.s0.q.f.i
    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.G();
            boolean z = q;
            f0(null);
        }
    }

    @Override // c.a.s0.q.f.i
    public void H(c.a.s0.q.p.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, gVar) == null) {
            if (q) {
                StringBuilder sb = new StringBuilder();
                sb.append("onPrepareDownload: countSet.size=");
                sb.append(gVar == null ? 0 : gVar.n());
                sb.toString();
            }
            super.H(gVar);
            if (gVar == null) {
                return;
            }
            this.f8058j = gVar;
            if (gVar.k()) {
                return;
            }
            d0();
        }
    }

    public final void a0(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, exc) == null) {
            if (q) {
                String str = "finishWithUpdatingCheck: updatings=" + this.m.size() + " e=" + exc;
            }
            for (c.a.s0.a.n0.k.e eVar : this.m.values()) {
                if (!eVar.n()) {
                    if (q) {
                        String str2 = "finishWithUpdatingCheck: return by wait for=" + eVar;
                        return;
                    }
                    return;
                }
            }
            e0(exc);
        }
    }

    public final c.a.s0.a.n0.k.e b0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            c.a.s0.a.n0.k.e eVar = this.m.get(str);
            if (eVar == null || !eVar.r(this)) {
                return null;
            }
            return eVar;
        }
        return (c.a.s0.a.n0.k.e) invokeL.objValue;
    }

    public final j<c.a.s0.q.i.j> c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.f8057i == null) {
                this.f8057i = new C0490f(this, null);
            }
            return this.f8057i;
        }
        return (j) invokeV.objValue;
    }

    public final void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            ArrayList arrayList = new ArrayList();
            if (this.f8058j.g()) {
                arrayList.add(i.d.a(new e(this)));
            }
            if (arrayList.isEmpty()) {
                return;
            }
            i.d.i(arrayList).u(c0());
        }
    }

    public final void e0(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, exc) == null) {
            if (q) {
                String str = "notifyFinalCallback: e=" + Log.getStackTraceString(exc);
            }
            c.a.s0.a.n0.k.d dVar = this.o;
            if (dVar != null) {
                dVar.b(exc);
            }
        }
    }

    public final void f0(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, exc) == null) {
            if (q) {
                String str = "notifyPmsFinish: updatings=" + this.m.size() + " e=" + exc;
            }
            for (c.a.s0.a.n0.k.e eVar : this.m.values()) {
                if (eVar != null && eVar.r(this) && !eVar.n() && !eVar.s()) {
                    if (q) {
                        String str2 = "notifyPmsFinish: try install updating=" + eVar;
                    }
                    eVar.q();
                }
            }
            a0(exc);
        }
    }

    @Override // c.a.s0.q.l.a.a
    public c.a.s0.q.k.c<JSONArray> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.p : (c.a.s0.q.k.c) invokeV.objValue;
    }

    public final void g0(c.a.s0.q.i.j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, jVar) == null) {
            c.a.s0.a.h0.m.c.c().d(jVar, new d(this, jVar));
        }
    }

    @Override // c.a.s0.q.l.a.a
    @Nullable
    public h getRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.k : (h) invokeV.objValue;
    }

    public final void h0(c.a.s0.q.i.j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, jVar) == null) {
            if (q) {
                String str = "SoNodeHandler updateBestSo start so=" + jVar;
            }
            if (jVar == null) {
                boolean z = q;
                return;
            }
            c.a.s0.q.m.a aVar = this.n.get(jVar.f11736g);
            if (aVar == null) {
                if (q) {
                    String str2 = "SoNodeHandler updateBestSo end by illegal bundleId=" + jVar.f11736g;
                    return;
                }
                return;
            }
            if (TextUtils.isEmpty(jVar.p)) {
                jVar.p = aVar.a;
            }
            c.a.s0.a.n0.k.e b0 = b0(jVar.p);
            if (b0 == null) {
                if (q) {
                    String str3 = "SoNodeHandler updateBestSo end by no updating lib=" + jVar.p;
                    return;
                }
                return;
            }
            if (jVar.q == null) {
                jVar.q = aVar.f11879c;
            }
            if (!AbiType.currentAbi().compat(jVar.q)) {
                boolean z2 = q;
                return;
            }
            c.a.s0.q.i.j l = b0.l();
            c.a.s0.q.i.j j2 = b0.j();
            long max = Math.max(j2 != null ? j2.f11738i : 0L, l == null ? 0L : l.f11738i);
            long j3 = jVar.f11738i;
            if (j3 < max) {
                if (q) {
                    String.format("SoNodeHandler updateBestSo end by not bestVer(%d) libVer(%d)", Long.valueOf(max), Long.valueOf(jVar.f11738i));
                }
            } else if (j3 > max) {
                if (q) {
                    String str4 = "SoNodeHandler updateBestSo end by update bestVer=" + jVar.f11738i;
                }
                b0.w(this, jVar);
            } else {
                if (j2 == null || !j2.q.compat(jVar.q)) {
                    if (q) {
                        String str5 = "SoNodeHandler updateBestSo end by update abi update=" + jVar.q;
                    }
                    b0.w(this, jVar);
                }
                boolean z3 = q;
            }
        }
    }

    @Override // c.a.s0.q.k.k.c
    public void l(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, jSONObject) == null) {
            if (q) {
                String str = "SoNodeHandler parseData start data=" + jSONObject;
            }
            if (jSONObject != null) {
                h0((c.a.s0.q.i.j) c.a.s0.q.p.f.j(jSONObject, new c.a.s0.q.i.j()));
            }
        }
    }

    @Override // c.a.s0.q.l.a.a
    public i o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this : (i) invokeV.objValue;
    }

    @Override // c.a.s0.q.k.k.c
    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            c.a.s0.q.k.k.a aVar = new c.a.s0.q.k.k.a();
            c.a.s0.q.p.g gVar = new c.a.s0.q.p.g();
            boolean z = q;
            boolean z2 = true;
            if ((q && !q0.G() && c.a.s0.a.x1.a.a.j() == 1) ? false : false) {
                String i2 = c.a.s0.a.x1.a.a.i();
                if (!TextUtils.isEmpty(i2)) {
                    try {
                        c.a.s0.q.i.j jVar = (c.a.s0.q.i.j) c.a.s0.q.p.f.j(new JSONObject(i2), new c.a.s0.q.i.j());
                        jVar.f11736g = "so_zeus_armeabi";
                        h0(jVar);
                        c.a.s0.a.c2.b.f.e.g(AppRuntime.getAppContext(), AppRuntime.getAppContext().getString(c.a.s0.a.h.swan_app_debug_so_info_success)).G();
                    } catch (JSONException e2) {
                        c.a.s0.a.c2.b.f.e.g(AppRuntime.getAppContext(), AppRuntime.getAppContext().getString(c.a.s0.a.h.swan_app_debug_so_info_error)).G();
                        e2.printStackTrace();
                    }
                }
            }
            for (c.a.s0.a.n0.k.e eVar : this.m.values()) {
                if (eVar.r(this)) {
                    h0(eVar.l());
                    c.a.s0.q.i.j j2 = eVar.j();
                    if (eVar.p() && j2 != null) {
                        if (q) {
                            String str = "SoNodeHandler handle for bestSo=" + j2;
                        }
                        c.a.s0.q.k.k.b.b(j2, gVar);
                        if (aVar.f11874d == null) {
                            aVar.f11874d = new ArrayList();
                        }
                        aVar.f11874d.add(j2);
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
                G();
                return;
            }
            boolean z5 = q;
            H(gVar);
            c.a.s0.q.j.i.a.e(aVar, this);
        }
    }

    @Override // c.a.s0.q.f.i
    public c.a.s0.q.k.k.c x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) ? TextUtils.equals("so", str) ? this : super.x(str) : (c.a.s0.q.k.k.c) invokeL.objValue;
    }
}
