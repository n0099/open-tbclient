package c.a.n0.a.d0.k;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.d0.k.d;
import c.a.n0.a.p2.j0;
import c.a.n0.a.p2.q0;
import c.a.n0.a.x.m.c;
import c.a.n0.a.x.m.k;
import c.a.n0.q.e.i;
import c.a.n0.q.i.m.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.PkgDownloadError;
import com.baidu.swan.pms.utils.AbiType;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import g.d;
import g.j;
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
public final class f extends k implements c.a.n0.q.k.a.a, c.a.n0.q.j.k.c {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean m;
    public static int n;
    public static final PMSDownloadType o;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public String f4068c;

    /* renamed from: d  reason: collision with root package name */
    public j<? super c.a.n0.q.h.j> f4069d;

    /* renamed from: e  reason: collision with root package name */
    public j<c.a.n0.q.h.j> f4070e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.n0.q.o.g f4071f;

    /* renamed from: g  reason: collision with root package name */
    public final h f4072g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.n0.q.e.e<c.a.n0.q.h.j> f4073h;
    public final Map<String, c.a.n0.a.d0.k.e> i;
    public final Map<String, c.a.n0.q.l.a> j;
    public final c.a.n0.a.d0.k.d k;
    public final c.a.n0.q.j.c<JSONArray> l;

    /* loaded from: classes.dex */
    public class a implements c.a.n0.q.j.c<JSONArray> {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.q.j.c
        /* renamed from: b */
        public void a(@NonNull JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) || jSONArray == null || this.a.i.isEmpty()) {
                return;
            }
            for (c.a.n0.a.d0.k.e eVar : this.a.i.values()) {
                if (eVar != null && eVar.r(this.a)) {
                    eVar.a(jSONArray);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.a.n0.a.p2.g1.c<c.a.n0.a.d0.k.e> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;

        public b(f fVar) {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.n0.a.d0.k.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) {
                if (f.m) {
                    String str = this.a.f4068c;
                    Log.i(str, "onCallback: SoUpdating=" + eVar);
                }
                if (eVar != null) {
                    this.a.k.c(eVar.k(), eVar.o());
                }
                this.a.a0(null);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements c.a.n0.a.p2.g1.c<c.a.n0.a.d0.k.e> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;

        public c(f fVar) {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.n0.a.d0.k.e eVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) || eVar == null) {
                return;
            }
            this.a.k.d(eVar.k(), eVar.m());
        }
    }

    /* loaded from: classes.dex */
    public class d implements c.InterfaceC0549c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.n0.q.h.j a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f4074b;

        public d(f fVar, c.a.n0.q.h.j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4074b = fVar;
            this.a = jVar;
        }

        @Override // c.a.n0.a.x.m.c.InterfaceC0549c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                this.f4074b.f4071f.m(this.a);
                if (this.f4074b.f4069d != null) {
                    this.f4074b.f4069d.onNext(this.a);
                    this.f4074b.f4069d.onCompleted();
                }
            }
        }

        @Override // c.a.n0.a.x.m.c.InterfaceC0549c
        public void b(PMSDownloadType pMSDownloadType, c.a.n0.a.k2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, aVar) == null) {
                this.f4074b.f4071f.l(this.a);
                if (this.f4074b.f4069d != null) {
                    this.f4074b.f4069d.onError(new PkgDownloadError(this.a, aVar));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements d.a<c.a.n0.q.h.j> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;

        public e(f fVar) {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // g.d.a, g.n.b
        public void call(j<? super c.a.n0.q.h.j> jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
                this.a.f4069d = jVar;
            }
        }
    }

    /* renamed from: c.a.n0.a.d0.k.f$f  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0235f extends j<c.a.n0.q.h.j> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f4075e;

        public C0235f(f fVar) {
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
            this.f4075e = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // g.e
        /* renamed from: g */
        public void onNext(c.a.n0.q.h.j jVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) && f.m) {
                String str = this.f4075e.f4068c;
                Log.e(str, "PkgDlSubscriber 单个包下载、业务层处理完成：" + jVar.toString());
            }
        }

        @Override // g.e
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (f.m) {
                    Log.e(this.f4075e.f4068c, "PkgDlSubscriber 包下载完成");
                }
                this.f4075e.f0(null);
            }
        }

        @Override // g.e
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                if (f.m) {
                    String str = this.f4075e.f4068c;
                    Log.e(str, "PkgDlSubscriber 包下载、业务层处理 OnError：" + th.toString());
                }
                this.f4075e.f0(new Exception("failed by Download error = ", th));
            }
        }

        public /* synthetic */ C0235f(f fVar, a aVar) {
            this(fVar);
        }
    }

    /* loaded from: classes.dex */
    public class g extends c.a.n0.q.e.b<c.a.n0.q.h.j> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;

        public g(f fVar) {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.q.e.e
        /* renamed from: l */
        public String d(c.a.n0.q.h.j jVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, jVar)) == null) {
                String g2 = c.a.n0.a.d0.k.c.f4054d.g(jVar);
                if (f.m) {
                    String str = this.a.f4068c;
                    Log.i(str, "SoDlCallback getDownloadPath: so=" + jVar.f9145g + " path=" + g2);
                }
                return g2;
            }
            return (String) invokeL.objValue;
        }

        @Override // c.a.n0.q.e.g
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) ? this.a.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.q.e.b, c.a.n0.q.e.e
        /* renamed from: o */
        public void e(c.a.n0.q.h.j jVar, c.a.n0.q.h.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jVar, bVar) == null) {
                super.e(jVar, bVar);
                if (f.m) {
                    String str = this.a.f4068c;
                    Log.i(str, "SoDlCallback onDownloadError: so=" + jVar.f9145g + " err=" + bVar);
                }
                this.a.f4071f.l(jVar);
                c.a.n0.a.k2.a aVar = new c.a.n0.a.k2.a();
                aVar.k(13L);
                aVar.i(bVar.a);
                aVar.d("so包下载失败");
                aVar.f(bVar.toString());
                if (this.a.f4069d != null) {
                    this.a.f4069d.onError(new PkgDownloadError(jVar, aVar));
                }
                c.a.n0.a.x.m.c.c().a(jVar, f.o, aVar);
                c.a.n0.w.d.k(jVar.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.q.e.b, c.a.n0.q.e.e
        /* renamed from: p */
        public void i(c.a.n0.q.h.j jVar) {
            c.a.n0.q.l.a aVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, jVar) == null) {
                super.i(jVar);
                if (f.m) {
                    String str = this.a.f4068c;
                    Log.i(str, "SoDlCallback onDownloadFinish: so=" + jVar);
                }
                String str2 = jVar.p;
                if (TextUtils.isEmpty(str2) && (aVar = (c.a.n0.q.l.a) this.a.j.get(jVar.f9145g)) != null) {
                    str2 = aVar.a;
                }
                c.a.n0.a.d0.k.e b0 = this.a.b0(str2);
                if (b0 != null) {
                    boolean a = j0.a(new File(jVar.a), jVar.m);
                    if (f.m) {
                        String str3 = this.a.f4068c;
                        Log.i(str3, "SoDlCallback onDownloadFinish: bundle=" + jVar.f9145g + " checkSign=" + a);
                    }
                    boolean z = true;
                    z = (f.m && !q0.G() && c.a.n0.a.n1.a.a.j() == 1) ? false : false;
                    if (a || z) {
                        c.a.n0.q.f.a.i().m(jVar);
                        if (f.m) {
                            String str4 = this.a.f4068c;
                            Log.i(str4, "SoDlCallback onDownloadFinish: updating=" + b0 + " libName=" + str2);
                        }
                    }
                    b0.q();
                }
                this.a.f4071f.m(jVar);
                if (this.a.f4069d != null) {
                    this.a.f4069d.onNext(jVar);
                    this.a.f4069d.onCompleted();
                }
                c.a.n0.a.x.m.c.c().b(jVar, f.o);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.q.e.b, c.a.n0.q.e.e
        /* renamed from: q */
        public void a(c.a.n0.q.h.j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, jVar) == null) {
                super.a(jVar);
                c.a.n0.q.l.a aVar = (c.a.n0.q.l.a) this.a.j.get(jVar.f9145g);
                c.a.n0.a.d0.k.e b0 = this.a.b0(aVar == null ? null : aVar.a);
                if (b0 != null) {
                    b0.x(new d.b(jVar.f9140b, jVar.k));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.q.e.b, c.a.n0.q.e.e
        /* renamed from: r */
        public void c(c.a.n0.q.h.j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, jVar) == null) {
                super.c(jVar);
                if (f.m) {
                    String str = this.a.f4068c;
                    Log.i(str, "SoDlCallback onDownloadStart: so=" + jVar.f9145g);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.q.e.b, c.a.n0.q.e.e
        /* renamed from: s */
        public void f(c.a.n0.q.h.j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, jVar) == null) {
                super.f(jVar);
                if (f.m) {
                    String str = this.a.f4068c;
                    Log.i(str, "SoDlCallback onDownloading: so=" + jVar.f9145g);
                }
                this.a.g0(jVar);
            }
        }

        public /* synthetic */ g(f fVar, a aVar) {
            this(fVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1573775111, "Lc/a/n0/a/d0/k/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1573775111, "Lc/a/n0/a/d0/k/f;");
                return;
            }
        }
        m = c.a.n0.a.a.a;
        n = 0;
        o = PMSDownloadType.SO_LIB;
    }

    public f(h hVar, c.a.n0.a.d0.k.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hVar, dVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f4068c = "SwanSoUpdater";
        this.i = new HashMap();
        this.j = new HashMap();
        this.l = new a(this);
        StringBuilder sb = new StringBuilder();
        sb.append(this.f4068c);
        int i3 = n;
        n = i3 + 1;
        sb.append(i3);
        String sb2 = sb.toString();
        this.f4068c = sb2;
        if (m) {
            Log.i(sb2, "SwanSoUpdater: config=" + dVar + " trace=" + Log.getStackTraceString(new Exception()));
        }
        this.f4072g = hVar;
        this.k = dVar;
        if (dVar != null) {
            Iterator<String> it = dVar.a().iterator();
            while (it.hasNext()) {
                String next = it.next();
                c.a.n0.a.d0.k.a a2 = c.a.n0.a.d0.k.b.a(next);
                if (a2 == null) {
                    dVar.c(next, false);
                } else if (a2.f()) {
                    dVar.c(next, true);
                } else {
                    String e2 = a2.e();
                    c.a.n0.a.d0.k.e t = c.a.n0.a.d0.k.c.f4054d.t(this, e2);
                    b bVar = new b(this);
                    c cVar = new c(this);
                    t.u(bVar);
                    t.v(cVar);
                    this.i.put(e2, t);
                    this.j.putAll(c.a.n0.q.l.a.b(e2));
                }
            }
        }
        if (m) {
            String str = this.f4068c;
            Log.i(str, "SoNodeHandler() start mUpdatings=" + this.i.size());
        }
        if (this.i.isEmpty()) {
            f0(null);
        }
    }

    @Override // c.a.n0.q.e.i
    public c.a.n0.q.e.e<c.a.n0.q.h.j> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f4073h == null) {
                this.f4073h = new g(this, null);
            }
            return this.f4073h;
        }
        return (c.a.n0.q.e.e) invokeV.objValue;
    }

    @Override // c.a.n0.q.e.i
    public void D(c.a.n0.q.h.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            super.D(bVar);
            if (m) {
                String str = this.f4068c;
                Log.e(str, "onFetchError: " + bVar.toString());
            }
            f0(new Exception("failed by fetch error = " + bVar));
        }
    }

    @Override // c.a.n0.q.e.i
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.F();
            if (m) {
                Log.e(this.f4068c, "onFetchSuccess:");
            }
        }
    }

    @Override // c.a.n0.q.e.i
    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.G();
            if (m) {
                Log.e(this.f4068c, "onNoPackage:");
            }
            f0(null);
        }
    }

    @Override // c.a.n0.q.e.i
    public void H(c.a.n0.q.o.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, gVar) == null) {
            if (m) {
                String str = this.f4068c;
                StringBuilder sb = new StringBuilder();
                sb.append("onPrepareDownload: countSet.size=");
                sb.append(gVar == null ? 0 : gVar.n());
                Log.i(str, sb.toString());
            }
            super.H(gVar);
            if (gVar == null) {
                return;
            }
            this.f4071f = gVar;
            if (gVar.k()) {
                return;
            }
            d0();
        }
    }

    public final void a0(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, exc) == null) {
            if (m) {
                String str = this.f4068c;
                Log.i(str, "finishWithUpdatingCheck: updatings=" + this.i.size() + " e=" + exc);
            }
            for (c.a.n0.a.d0.k.e eVar : this.i.values()) {
                if (!eVar.n()) {
                    if (m) {
                        String str2 = this.f4068c;
                        Log.i(str2, "finishWithUpdatingCheck: return by wait for=" + eVar);
                        return;
                    }
                    return;
                }
            }
            e0(exc);
        }
    }

    public final c.a.n0.a.d0.k.e b0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            c.a.n0.a.d0.k.e eVar = this.i.get(str);
            if (eVar == null || !eVar.r(this)) {
                return null;
            }
            return eVar;
        }
        return (c.a.n0.a.d0.k.e) invokeL.objValue;
    }

    public final j<c.a.n0.q.h.j> c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.f4070e == null) {
                this.f4070e = new C0235f(this, null);
            }
            return this.f4070e;
        }
        return (j) invokeV.objValue;
    }

    public final void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            ArrayList arrayList = new ArrayList();
            if (this.f4071f.g()) {
                arrayList.add(g.d.a(new e(this)));
            }
            if (arrayList.isEmpty()) {
                return;
            }
            g.d.i(arrayList).u(c0());
        }
    }

    public final void e0(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, exc) == null) {
            if (m) {
                String str = this.f4068c;
                Log.i(str, "notifyFinalCallback: e=" + Log.getStackTraceString(exc));
            }
            c.a.n0.a.d0.k.d dVar = this.k;
            if (dVar != null) {
                dVar.b(exc);
            }
        }
    }

    public final void f0(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, exc) == null) {
            if (m) {
                String str = this.f4068c;
                Log.i(str, "notifyPmsFinish: updatings=" + this.i.size() + " e=" + exc);
            }
            for (c.a.n0.a.d0.k.e eVar : this.i.values()) {
                if (eVar != null && eVar.r(this) && !eVar.n() && !eVar.s()) {
                    if (m) {
                        String str2 = this.f4068c;
                        Log.i(str2, "notifyPmsFinish: try install updating=" + eVar);
                    }
                    eVar.q();
                }
            }
            a0(exc);
        }
    }

    @Override // c.a.n0.q.k.a.a
    public c.a.n0.q.j.c<JSONArray> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.l : (c.a.n0.q.j.c) invokeV.objValue;
    }

    public final void g0(c.a.n0.q.h.j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, jVar) == null) {
            c.a.n0.a.x.m.c.c().d(jVar, new d(this, jVar));
        }
    }

    @Override // c.a.n0.q.k.a.a
    @Nullable
    public h getRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f4072g : (h) invokeV.objValue;
    }

    public final void h0(c.a.n0.q.h.j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, jVar) == null) {
            if (m) {
                String str = this.f4068c;
                Log.i(str, "SoNodeHandler updateBestSo start so=" + jVar);
            }
            if (jVar == null) {
                if (m) {
                    Log.i(this.f4068c, "SoNodeHandler updateBestSo end by null so");
                    return;
                }
                return;
            }
            c.a.n0.q.l.a aVar = this.j.get(jVar.f9145g);
            if (aVar == null) {
                if (m) {
                    String str2 = this.f4068c;
                    Log.i(str2, "SoNodeHandler updateBestSo end by illegal bundleId=" + jVar.f9145g);
                    return;
                }
                return;
            }
            if (TextUtils.isEmpty(jVar.p)) {
                jVar.p = aVar.a;
            }
            c.a.n0.a.d0.k.e b0 = b0(jVar.p);
            if (b0 == null) {
                if (m) {
                    String str3 = this.f4068c;
                    Log.i(str3, "SoNodeHandler updateBestSo end by no updating lib=" + jVar.p);
                    return;
                }
                return;
            }
            if (jVar.q == null) {
                jVar.q = aVar.f9277c;
            }
            if (!AbiType.currentAbi().compat(jVar.q)) {
                if (m) {
                    Log.i(this.f4068c, "SoNodeHandler updateBestSo end by currentAbi");
                    return;
                }
                return;
            }
            c.a.n0.q.h.j l = b0.l();
            c.a.n0.q.h.j j = b0.j();
            long max = Math.max(j != null ? j.i : 0L, l == null ? 0L : l.i);
            long j2 = jVar.i;
            if (j2 < max) {
                if (m) {
                    Log.i(this.f4068c, String.format("SoNodeHandler updateBestSo end by not bestVer(%d) libVer(%d)", Long.valueOf(max), Long.valueOf(jVar.i)));
                }
            } else if (j2 > max) {
                if (m) {
                    String str4 = this.f4068c;
                    Log.i(str4, "SoNodeHandler updateBestSo end by update bestVer=" + jVar.i);
                }
                b0.w(this, jVar);
            } else {
                if (j == null || !j.q.compat(jVar.q)) {
                    if (m) {
                        String str5 = this.f4068c;
                        Log.i(str5, "SoNodeHandler updateBestSo end by update abi update=" + jVar.q);
                    }
                    b0.w(this, jVar);
                }
                if (m) {
                    Log.i(this.f4068c, "SoNodeHandler updateBestSo end by should not exec here");
                }
            }
        }
    }

    @Override // c.a.n0.q.j.k.c
    public void l(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, jSONObject) == null) {
            if (m) {
                String str = this.f4068c;
                Log.i(str, "SoNodeHandler parseData start data=" + jSONObject);
            }
            if (jSONObject != null) {
                h0((c.a.n0.q.h.j) c.a.n0.q.o.f.j(jSONObject, new c.a.n0.q.h.j()));
            }
        }
    }

    @Override // c.a.n0.q.k.a.a
    public i o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this : (i) invokeV.objValue;
    }

    @Override // c.a.n0.q.j.k.c
    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            c.a.n0.q.j.k.a aVar = new c.a.n0.q.j.k.a();
            c.a.n0.q.o.g gVar = new c.a.n0.q.o.g();
            if (m) {
                Log.i(this.f4068c, "SoNodeHandler handle for loop start");
            }
            boolean z = true;
            if ((m && !q0.G() && c.a.n0.a.n1.a.a.j() == 1) ? false : false) {
                String i = c.a.n0.a.n1.a.a.i();
                if (!TextUtils.isEmpty(i)) {
                    try {
                        c.a.n0.q.h.j jVar = (c.a.n0.q.h.j) c.a.n0.q.o.f.j(new JSONObject(i), new c.a.n0.q.h.j());
                        jVar.f9145g = "so_zeus_armeabi";
                        h0(jVar);
                        c.a.n0.a.s1.b.f.e.g(AppRuntime.getAppContext(), AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f1205)).G();
                    } catch (JSONException e2) {
                        c.a.n0.a.s1.b.f.e.g(AppRuntime.getAppContext(), AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f1204)).G();
                        e2.printStackTrace();
                    }
                }
            }
            for (c.a.n0.a.d0.k.e eVar : this.i.values()) {
                if (eVar.r(this)) {
                    h0(eVar.l());
                    c.a.n0.q.h.j j = eVar.j();
                    if (eVar.p() && j != null) {
                        if (m) {
                            String str = this.f4068c;
                            Log.i(str, "SoNodeHandler handle for bestSo=" + j);
                        }
                        c.a.n0.q.j.k.b.b(j, gVar);
                        if (aVar.f9272d == null) {
                            aVar.f9272d = new ArrayList();
                        }
                        aVar.f9272d.add(j);
                    } else {
                        if (m) {
                            Log.i(this.f4068c, "SoNodeHandler localSo not update, just check for install");
                        }
                        eVar.q();
                    }
                }
            }
            if (m) {
                Log.i(this.f4068c, "SoNodeHandler handle for loop end");
                String str2 = this.f4068c;
                Log.i(str2, "SoNodeHandler handle soSet.pkgSize()=" + gVar.n());
            }
            if (gVar.n() == 0) {
                if (m) {
                    Log.i(this.f4068c, "SoNodeHandler handle end by no pkg");
                }
                G();
                return;
            }
            if (m) {
                Log.i(this.f4068c, "SoNodeHandler handle end by start dl");
            }
            H(gVar);
            c.a.n0.q.i.i.a.e(aVar, this);
        }
    }

    @Override // c.a.n0.q.e.i
    public c.a.n0.q.j.k.c x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) ? TextUtils.equals("so", str) ? this : super.x(str) : (c.a.n0.q.j.k.c) invokeL.objValue;
    }
}
