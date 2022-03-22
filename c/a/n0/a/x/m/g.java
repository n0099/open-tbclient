package c.a.n0.a.x.m;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.g2.f.a;
import c.a.n0.a.p2.z0;
import c.a.n0.a.t1.i;
import c.a.n0.a.x.m.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.PkgDownloadError;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import g.d;
import java.io.File;
import java.io.IOException;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public abstract class g extends c.a.n0.a.x.m.k {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean C;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.n0.q.e.h A;
    public g.j<c.a.n0.q.h.f> B;

    /* renamed from: c  reason: collision with root package name */
    public String f7260c;

    /* renamed from: d  reason: collision with root package name */
    public g.j<? super c.a.n0.q.h.g> f7261d;

    /* renamed from: e  reason: collision with root package name */
    public g.j<? super c.a.n0.q.h.h> f7262e;

    /* renamed from: f  reason: collision with root package name */
    public g.j<? super c.a.n0.q.h.e> f7263f;

    /* renamed from: g  reason: collision with root package name */
    public g.j<? super c.a.n0.q.h.c> f7264g;

    /* renamed from: h  reason: collision with root package name */
    public g.j<? super c.a.n0.q.h.i> f7265h;
    public c.a.n0.q.o.g i;
    public c.a.n0.q.h.g j;
    public List<c.a.n0.q.h.h> k;
    public c.a.n0.q.h.e l;
    public c.a.n0.q.h.c m;
    public PMSAppInfo n;
    public String o;
    public List<UbcFlowEvent> p;
    public c.a.n0.q.h.h q;
    public long r;
    public final Set<c.a.n0.a.x.m.p.a> s;
    public final Set<c.a.n0.a.p2.g1.c<PMSAppInfo>> t;
    public final z0 u;
    public c.a.n0.q.e.e<c.a.n0.q.h.g> v;
    public c.a.n0.q.e.e<c.a.n0.q.h.h> w;
    public final c.a.n0.q.e.e<c.a.n0.q.h.i> x;
    public c.a.n0.q.e.e<c.a.n0.q.h.e> y;
    public c.a.n0.q.e.e<c.a.n0.q.h.c> z;

    /* loaded from: classes.dex */
    public class a extends c.a.n0.q.e.b<c.a.n0.q.h.g> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g a;

        /* renamed from: c.a.n0.a.x.m.g$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0551a implements c.a.n0.a.p2.g1.c<i.a> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0551a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.n0.a.p2.g1.c
            /* renamed from: a */
            public void onCallback(i.a aVar) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) && "installer_on_pump_finish".equals(aVar.f6352b)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("performance_ubc_event_id", "670");
                    bundle.putString("performance_ubc_extra_key_for_event", "na_stream_bump_end");
                    c.a.n0.q.e.j.a(this.a.a, bundle, "event_performance_ubc");
                }
            }
        }

        public a(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gVar;
        }

        @Override // c.a.n0.q.e.b
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a.k0() : invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.q.e.e
        /* renamed from: l */
        public String d(c.a.n0.q.h.g gVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, gVar)) == null) {
                int i = gVar.f9146h;
                if (i == 0) {
                    return c.a.n0.a.x.m.u.a.g();
                }
                if (i == 1) {
                    return c.a.n0.a.x.m.u.a.i();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        @Override // c.a.n0.q.e.g
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle, set)) == null) ? this.a.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.q.e.b, c.a.n0.q.e.e
        /* renamed from: o */
        public void e(c.a.n0.q.h.g gVar, c.a.n0.q.h.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048585, this, gVar, bVar) == null) {
                super.e(gVar, bVar);
                c.a.n0.a.u.d.k("SwanAppPkgDownloadCallback", "onDownloadError：" + bVar.toString());
                this.a.i.l(gVar);
                c.a.n0.a.k2.a aVar = new c.a.n0.a.k2.a();
                aVar.k(11L);
                aVar.i(bVar.a);
                aVar.d("主包下载失败");
                aVar.f(bVar.toString());
                if (this.a.f7261d != null) {
                    this.a.f7261d.onError(new PkgDownloadError(gVar, aVar));
                }
                c.a.n0.a.x.m.c.c().a(gVar, this.a.l0(), aVar);
                c.a.n0.w.d.k(gVar.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.q.e.b, c.a.n0.q.e.e
        /* renamed from: p */
        public void i(c.a.n0.q.h.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, gVar) == null) {
                String m0 = this.a.m0();
                if (g.C) {
                    c.a.n0.a.v0.g.a.d(m0).e().d(1);
                }
                super.i(gVar);
                this.a.p.add(new UbcFlowEvent("na_pms_end_download"));
                c.a.n0.a.k2.a A0 = this.a.A0(gVar);
                c.a.n0.a.u.d.k("SwanAppPkgDownloadCallback", "main onFileDownloaded: pmsPkgMain=" + gVar.i);
                if (A0 == null) {
                    g gVar2 = this.a;
                    gVar2.j = gVar;
                    gVar2.i.m(gVar);
                    if (this.a.f7261d != null) {
                        this.a.f7261d.onNext(gVar);
                        if (g.C) {
                            Log.d("SwanAppPkgDownloadCallback", this.a.j0() + ": main onFileDownloaded: onCompleted");
                        }
                        this.a.f7261d.onCompleted();
                    }
                    c.a.n0.a.x.m.c.c().b(gVar, this.a.l0());
                    return;
                }
                this.a.i.l(gVar);
                if (this.a.f7261d != null) {
                    this.a.f7261d.onError(new PkgDownloadError(gVar, A0));
                }
                c.a.n0.a.x.m.c.c().a(gVar, this.a.l0(), A0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.q.e.b, c.a.n0.q.e.e
        /* renamed from: q */
        public void c(c.a.n0.q.h.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, gVar) == null) {
                String m0 = this.a.m0();
                if (g.C) {
                    c.a.n0.a.v0.g.a.d(m0).e().d(1);
                }
                super.c(gVar);
                c.a.n0.a.u.d.k("SwanAppPkgDownloadCallback", "main onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.q.e.b, c.a.n0.q.e.e
        /* renamed from: r */
        public void f(c.a.n0.q.h.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, gVar) == null) {
                String m0 = this.a.m0();
                if (g.C) {
                    c.a.n0.a.v0.g.a.d(m0).e().d(1);
                }
                super.f(gVar);
                if (g.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.j0() + ": main onDownloading");
                }
                this.a.E0(gVar);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.q.e.b, c.a.n0.q.e.e
        /* renamed from: s */
        public c.a.n0.q.h.b h(c.a.n0.q.h.g gVar, File file, long j, ReadableByteChannel readableByteChannel) throws IOException {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{gVar, file, Long.valueOf(j), readableByteChannel})) == null) {
                String m0 = this.a.m0();
                if (g.C) {
                    c.a.n0.a.v0.g.a.d(m0).f(gVar.toString()).d(1);
                }
                C0551a c0551a = new C0551a(this);
                Bundle bundle = new Bundle();
                bundle.putLong("length", j);
                bundle.putFloat("progress_granularity", 0.1f);
                c.a.n0.a.q0.f fVar = new c.a.n0.a.q0.f();
                fVar.v(c0551a);
                fVar.J(bundle);
                fVar.I(new c.a.n0.a.q0.e(gVar, this.a));
                fVar.I(new c.a.n0.a.q0.c(gVar.m, this.a));
                fVar.L(readableByteChannel);
                boolean M = fVar.M();
                fVar.p(c0551a);
                if (g.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.j0() + ": onProcessStream: installOk=" + M);
                }
                if (M) {
                    c.a.n0.a.u.d.k("SwanAppPkgDownloadCallback", "#onProcessStream del: " + file.getAbsolutePath());
                    c.a.n0.w.d.L(file);
                }
                return M ? new c.a.n0.q.h.b(2300, "业务层处理下载流成功") : new c.a.n0.q.h.b(2301, "业务层处理下载流失败");
            }
            return (c.a.n0.q.h.b) invokeCommon.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Collection a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.p2.g1.c f7266b;

        public b(g gVar, Collection collection, c.a.n0.a.p2.g1.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, collection, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = collection;
            this.f7266b = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                for (Object obj : this.a) {
                    this.f7266b.onCallback(obj);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements c.a.n0.a.p2.g1.c<c.a.n0.a.x.m.p.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.n0.a.p2.g1.c a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g f7267b;

        public c(g gVar, c.a.n0.a.p2.g1.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7267b = gVar;
            this.a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.n0.a.x.m.p.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.a.onCallback(aVar);
                g gVar = this.f7267b;
                gVar.i0(gVar.s, aVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements c.a.n0.a.p2.g1.c<c.a.n0.a.x.m.p.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.n0.a.k2.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f7268b;

        public d(g gVar, c.a.n0.a.k2.a aVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, aVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
            this.f7268b = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.n0.a.x.m.p.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.a(this.a, this.f7268b);
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements c.a.n0.a.p2.g1.c<c.a.n0.a.x.m.p.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PMSAppInfo a;

        public e(g gVar, PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, pMSAppInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pMSAppInfo;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.n0.a.x.m.p.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.b(this.a);
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements c.InterfaceC0549c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.n0.q.h.g a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g f7269b;

        public f(g gVar, c.a.n0.q.h.g gVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, gVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7269b = gVar;
            this.a = gVar2;
        }

        @Override // c.a.n0.a.x.m.c.InterfaceC0549c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                g gVar = this.f7269b;
                c.a.n0.q.h.g gVar2 = this.a;
                gVar.j = gVar2;
                gVar.i.m(gVar2);
                if (this.f7269b.f7261d != null) {
                    this.f7269b.f7261d.onNext(this.a);
                    this.f7269b.f7261d.onCompleted();
                }
            }
        }

        @Override // c.a.n0.a.x.m.c.InterfaceC0549c
        public void b(PMSDownloadType pMSDownloadType, c.a.n0.a.k2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, aVar) == null) {
                this.f7269b.i.l(this.a);
                if (this.f7269b.f7261d != null) {
                    this.f7269b.f7261d.onError(new PkgDownloadError(this.a, aVar));
                }
            }
        }
    }

    /* renamed from: c.a.n0.a.x.m.g$g  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0552g implements c.InterfaceC0549c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.n0.q.h.h a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g f7270b;

        public C0552g(g gVar, c.a.n0.q.h.h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7270b = gVar;
            this.a = hVar;
        }

        @Override // c.a.n0.a.x.m.c.InterfaceC0549c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                g gVar = this.f7270b;
                if (gVar.k == null) {
                    gVar.k = new ArrayList();
                }
                c.a.n0.q.h.h hVar = this.a;
                g gVar2 = this.f7270b;
                hVar.o = gVar2.o;
                gVar2.k.add(hVar);
                this.f7270b.i.m(this.a);
                if (this.f7270b.f7262e != null) {
                    this.f7270b.f7262e.onNext(this.a);
                    if (this.f7270b.i.i()) {
                        return;
                    }
                    this.f7270b.f7262e.onCompleted();
                }
            }
        }

        @Override // c.a.n0.a.x.m.c.InterfaceC0549c
        public void b(PMSDownloadType pMSDownloadType, c.a.n0.a.k2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, aVar) == null) {
                this.f7270b.i.l(this.a);
                if (this.f7270b.f7262e != null) {
                    this.f7270b.f7262e.onError(new PkgDownloadError(this.a, aVar));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class h implements c.InterfaceC0549c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.n0.q.h.e a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g f7271b;

        public h(g gVar, c.a.n0.q.h.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7271b = gVar;
            this.a = eVar;
        }

        @Override // c.a.n0.a.x.m.c.InterfaceC0549c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                g gVar = this.f7271b;
                c.a.n0.q.h.e eVar = this.a;
                gVar.l = eVar;
                gVar.i.m(eVar);
                if (this.f7271b.f7263f != null) {
                    this.f7271b.f7263f.onNext(this.a);
                    this.f7271b.f7263f.onCompleted();
                }
            }
        }

        @Override // c.a.n0.a.x.m.c.InterfaceC0549c
        public void b(PMSDownloadType pMSDownloadType, c.a.n0.a.k2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, aVar) == null) {
                this.f7271b.i.l(this.a);
                if (this.f7271b.f7263f != null) {
                    this.f7271b.f7263f.onError(new PkgDownloadError(this.a, aVar));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class i implements c.InterfaceC0549c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.n0.q.h.c a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g f7272b;

        public i(g gVar, c.a.n0.q.h.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7272b = gVar;
            this.a = cVar;
        }

        @Override // c.a.n0.a.x.m.c.InterfaceC0549c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                c.a.n0.a.u.d.k("SwanAppPkgDownloadCallback", "Extension Repeat: onSuccess ：" + pMSDownloadType);
                g gVar = this.f7272b;
                c.a.n0.q.h.c cVar = this.a;
                gVar.m = cVar;
                gVar.i.m(cVar);
                this.f7272b.r0(this.a);
            }
        }

        @Override // c.a.n0.a.x.m.c.InterfaceC0549c
        public void b(PMSDownloadType pMSDownloadType, c.a.n0.a.k2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, aVar) == null) {
                c.a.n0.a.u.d.k("SwanAppPkgDownloadCallback", "Extension Repeat: onError ：" + pMSDownloadType + ":" + aVar.toString());
                this.f7272b.i.l(this.a);
                this.f7272b.r0(this.a);
            }
        }
    }

    /* loaded from: classes.dex */
    public class j extends g.j<c.a.n0.q.h.f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f7273e;

        public j(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7273e = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // g.e
        /* renamed from: g */
        public void onNext(c.a.n0.q.h.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                c.a.n0.a.u.d.k("SwanAppPkgDownloadCallback", this.f7273e.l0() + " : 单个包下载、业务层处理完成：" + fVar.i);
            }
        }

        @Override // g.e
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                c.a.n0.a.u.d.k("SwanAppPkgDownloadCallback", this.f7273e.l0() + " : 包下载onCompleted");
                this.f7273e.w0();
            }
        }

        @Override // g.e
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                c.a.n0.a.u.d.l("SwanAppPkgDownloadCallback", this.f7273e.l0() + " : 包下载OnError", th);
                this.f7273e.x0(th);
            }
        }
    }

    /* loaded from: classes.dex */
    public class k implements d.a<c.a.n0.q.h.g> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g a;

        public k(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // g.d.a, g.n.b
        public void call(g.j<? super c.a.n0.q.h.g> jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
                this.a.f7261d = jVar;
            }
        }
    }

    /* loaded from: classes.dex */
    public class l implements d.a<c.a.n0.q.h.h> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g a;

        public l(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // g.d.a, g.n.b
        public void call(g.j<? super c.a.n0.q.h.h> jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
                this.a.f7262e = jVar;
            }
        }
    }

    /* loaded from: classes.dex */
    public class m implements d.a<c.a.n0.q.h.e> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g a;

        public m(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // g.d.a, g.n.b
        public void call(g.j<? super c.a.n0.q.h.e> jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
                this.a.f7263f = jVar;
            }
        }
    }

    /* loaded from: classes.dex */
    public class n implements d.a<c.a.n0.q.h.c> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g a;

        public n(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // g.d.a, g.n.b
        public void call(g.j<? super c.a.n0.q.h.c> jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
                this.a.f7264g = jVar;
            }
        }
    }

    /* loaded from: classes.dex */
    public class o implements d.a<c.a.n0.q.h.i> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g a;

        public o(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // g.d.a, g.n.b
        public void call(g.j<? super c.a.n0.q.h.i> jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
                this.a.f7265h = jVar;
            }
        }
    }

    /* loaded from: classes.dex */
    public class p extends c.a.n0.a.x.m.n<g> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ g f7274c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(g gVar, g gVar2) {
            super(gVar2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, gVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((c.a.n0.a.x.m.k) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7274c = gVar;
        }

        @Override // c.a.n0.a.x.m.n, c.a.n0.q.e.b
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f7274c.k0() : invokeV.intValue;
        }

        @Override // c.a.n0.a.x.m.n
        public String l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f7274c.o : (String) invokeV.objValue;
        }

        @Override // c.a.n0.a.x.m.n
        public void p(@NonNull c.a.n0.q.h.h hVar, @Nullable c.a.n0.a.k2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, hVar, aVar) == null) {
                super.p(hVar, aVar);
                c.a.n0.a.u.d.k("SwanAppPkgDownloadCallback", "sub onFileDownloaded: " + hVar.i);
                g gVar = this.f7274c;
                if (gVar.k == null) {
                    gVar.k = new ArrayList();
                }
                g gVar2 = this.f7274c;
                hVar.o = gVar2.o;
                if (aVar == null) {
                    gVar2.k.add(hVar);
                    this.f7274c.i.m(hVar);
                    c.a.n0.a.x.m.c.c().b(hVar, this.f7274c.l0());
                } else {
                    gVar2.i.l(hVar);
                    c.a.n0.a.x.m.c.c().a(hVar, this.f7274c.l0(), aVar);
                }
                if (this.f7274c.f7262e != null) {
                    this.f7274c.f7262e.onNext(hVar);
                    if (this.f7274c.i.i()) {
                        return;
                    }
                    this.f7274c.f7262e.onCompleted();
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.q.e.b, c.a.n0.q.e.e
        /* renamed from: q */
        public void e(c.a.n0.q.h.h hVar, c.a.n0.q.h.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, hVar, bVar) == null) {
                super.q(hVar, bVar);
                c.a.n0.a.u.d.k("SwanAppPkgDownloadCallback", "sub onDownloadError：" + bVar.toString());
                this.f7274c.i.l(hVar);
                c.a.n0.a.k2.a aVar = new c.a.n0.a.k2.a();
                aVar.k(12L);
                aVar.i(bVar.a);
                aVar.d("分包下载失败");
                aVar.f(bVar.toString());
                if (this.f7274c.f7262e != null) {
                    this.f7274c.f7262e.onError(new PkgDownloadError(hVar, aVar));
                }
                c.a.n0.a.x.m.c.c().a(hVar, this.f7274c.l0(), aVar);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.x.m.n, c.a.n0.q.e.b, c.a.n0.q.e.e
        /* renamed from: s */
        public void c(c.a.n0.q.h.h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, hVar) == null) {
                super.c(hVar);
                c.a.n0.a.u.d.k("SwanAppPkgDownloadCallback", "sub onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.q.e.b, c.a.n0.q.e.e
        /* renamed from: u */
        public void f(c.a.n0.q.h.h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, hVar) == null) {
                super.f(hVar);
                this.f7274c.F0(hVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class q extends c.a.n0.a.x.m.l<g> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g f7275b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(g gVar, g gVar2) {
            super(gVar2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, gVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((c.a.n0.a.x.m.k) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7275b = gVar;
        }

        @Override // c.a.n0.q.e.b
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f7275b.k0() : invokeV.intValue;
        }

        @Override // c.a.n0.a.x.m.l
        public PMSDownloadType o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f7275b.l0() : (PMSDownloadType) invokeV.objValue;
        }

        @Override // c.a.n0.a.x.m.l
        public void r(@NonNull c.a.n0.q.h.i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, iVar) == null) {
                this.f7275b.i.m(iVar);
                if (this.f7275b.f7265h != null) {
                    this.f7275b.f7265h.onNext(iVar);
                    if (this.f7275b.i.c()) {
                        return;
                    }
                    this.f7275b.f7265h.onCompleted();
                }
            }
        }

        @Override // c.a.n0.a.x.m.l
        public void u(c.a.n0.q.h.i iVar, c.a.n0.a.k2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, iVar, aVar) == null) {
                c.a.n0.a.u.d.k("SwanAppPkgDownloadCallback", "dependent onDownloadOrUnzipFail：" + aVar);
                this.f7275b.i.l(iVar);
                if (this.f7275b.f7265h != null) {
                    this.f7275b.f7265h.onError(new PkgDownloadError(iVar, aVar));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.x.m.l, c.a.n0.q.e.b, c.a.n0.q.e.e
        /* renamed from: v */
        public void c(c.a.n0.q.h.i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, iVar) == null) {
                super.c(iVar);
                c.a.n0.a.u.d.k("SwanAppPkgDownloadCallback", "dependent onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.x.m.l, c.a.n0.q.e.b, c.a.n0.q.e.e
        /* renamed from: w */
        public void f(c.a.n0.q.h.i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, iVar) == null) {
                super.f(iVar);
                if (g.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.f7275b.j0() + ": dependent onDownloading");
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class r extends c.a.n0.q.e.b<c.a.n0.q.h.e> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g a;

        public r(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gVar;
        }

        @Override // c.a.n0.q.e.b
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a.k0() : invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.q.e.e
        /* renamed from: l */
        public String d(c.a.n0.q.h.e eVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, eVar)) == null) {
                int i = eVar.f9146h;
                if (i == 0) {
                    return c.a.n0.a.x.m.u.a.h();
                }
                if (i == 1) {
                    return c.a.n0.a.x.m.u.a.e();
                }
                return null;
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
        public void e(c.a.n0.q.h.e eVar, c.a.n0.q.h.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar, bVar) == null) {
                super.e(eVar, bVar);
                c.a.n0.a.u.d.k("SwanAppPkgDownloadCallback", "framework onDownloadError：" + bVar.toString());
                this.a.i.l(eVar);
                c.a.n0.a.k2.a aVar = new c.a.n0.a.k2.a();
                aVar.k(13L);
                aVar.i(bVar.a);
                aVar.d("Framework包下载失败");
                aVar.f(bVar.toString());
                if (this.a.f7263f != null) {
                    this.a.f7263f.onError(new PkgDownloadError(eVar, aVar));
                }
                c.a.n0.a.x.m.c.c().a(eVar, this.a.l0(), aVar);
                c.a.n0.w.d.k(eVar.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.q.e.b, c.a.n0.q.e.e
        /* renamed from: p */
        public void i(c.a.n0.q.h.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, eVar) == null) {
                super.i(eVar);
                c.a.n0.a.u.d.k("SwanAppPkgDownloadCallback", "framework onFileDownloaded: " + eVar.i);
                c.a.n0.a.k2.a z0 = this.a.z0(eVar);
                if (z0 == null) {
                    g gVar = this.a;
                    gVar.l = eVar;
                    gVar.i.m(eVar);
                    if (this.a.f7263f != null) {
                        this.a.f7263f.onNext(eVar);
                        this.a.f7263f.onCompleted();
                    }
                    c.a.n0.a.x.m.c.c().b(eVar, this.a.l0());
                    return;
                }
                this.a.i.l(eVar);
                if (this.a.f7263f != null) {
                    this.a.f7263f.onError(new PkgDownloadError(eVar, z0));
                }
                c.a.n0.a.x.m.c.c().a(eVar, this.a.l0(), z0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.q.e.b, c.a.n0.q.e.e
        /* renamed from: q */
        public void c(c.a.n0.q.h.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, eVar) == null) {
                super.c(eVar);
                c.a.n0.a.u.d.k("SwanAppPkgDownloadCallback", "framework onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.q.e.b, c.a.n0.q.e.e
        /* renamed from: r */
        public void f(c.a.n0.q.h.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, eVar) == null) {
                super.f(eVar);
                if (g.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.j0() + ": framework onDownloading");
                }
                this.a.D0(eVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class s extends c.a.n0.q.e.b<c.a.n0.q.h.c> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g a;

        public s(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gVar;
        }

        @Override // c.a.n0.q.e.b
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a.k0() : invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.q.e.e
        /* renamed from: l */
        public String d(c.a.n0.q.h.c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, cVar)) == null) {
                int i = cVar.f9146h;
                if (i == 0) {
                    return c.a.n0.a.x.m.u.a.d();
                }
                if (i == 1) {
                    return c.a.n0.a.x.m.u.a.f();
                }
                return null;
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
        public void e(c.a.n0.q.h.c cVar, c.a.n0.q.h.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar, bVar) == null) {
                super.e(cVar, bVar);
                c.a.n0.a.u.d.k("SwanAppPkgDownloadCallback", "extension onDownloadError：" + bVar.toString());
                this.a.i.l(cVar);
                c.a.n0.a.k2.a aVar = new c.a.n0.a.k2.a();
                aVar.k(14L);
                aVar.i(bVar.a);
                aVar.d("Extension下载失败");
                aVar.f(bVar.toString());
                if (g.C) {
                    Log.e("SwanAppPkgDownloadCallback", aVar.toString());
                }
                this.a.r0(cVar);
                c.a.n0.a.x.m.c.c().a(cVar, this.a.l0(), aVar);
                c.a.n0.w.d.k(cVar.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.q.e.b, c.a.n0.q.e.e
        /* renamed from: p */
        public void i(c.a.n0.q.h.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, cVar) == null) {
                super.i(cVar);
                c.a.n0.a.u.d.k("SwanAppPkgDownloadCallback", "extension onFileDownloaded: " + cVar.i);
                c.a.n0.a.k2.a y0 = this.a.y0(cVar);
                if (y0 != null) {
                    if (g.C) {
                        Log.e("SwanAppPkgDownloadCallback", "Extension 业务处理失败：" + cVar.toString());
                    }
                    this.a.i.l(cVar);
                    this.a.r0(cVar);
                    c.a.n0.a.x.m.c.c().a(cVar, this.a.l0(), y0);
                    return;
                }
                g gVar = this.a;
                gVar.m = cVar;
                gVar.i.m(cVar);
                this.a.r0(cVar);
                c.a.n0.a.x.m.c.c().b(cVar, this.a.l0());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.q.e.b, c.a.n0.q.e.e
        /* renamed from: q */
        public void c(c.a.n0.q.h.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, cVar) == null) {
                super.c(cVar);
                c.a.n0.a.u.d.k("SwanAppPkgDownloadCallback", "extension onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.q.e.b, c.a.n0.q.e.e
        /* renamed from: r */
        public void f(c.a.n0.q.h.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, cVar) == null) {
                super.f(cVar);
                if (g.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.j0() + ": extension onDownloading");
                }
                this.a.C0(cVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class t implements c.a.n0.q.e.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g a;

        public t(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gVar;
        }

        @Override // c.a.n0.q.e.h
        public void a(PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSAppInfo) == null) {
                if (g.C) {
                    Log.e("SwanAppPkgDownloadCallback", this.a.j0() + ": onSwanAppReceive: " + pMSAppInfo.toString());
                }
                g gVar = this.a;
                gVar.n = pMSAppInfo;
                if (pMSAppInfo != null) {
                    gVar.p0(pMSAppInfo);
                    c.a.n0.a.m1.h.b.k(this.a.n.pluginInfo, true);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class u implements c.a.n0.a.p2.g1.c<c.a.n0.a.p2.g1.c<PMSAppInfo>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PMSAppInfo a;

        public u(g gVar, PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, pMSAppInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pMSAppInfo;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.n0.a.p2.g1.c<PMSAppInfo> cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
                cVar.onCallback(this.a);
            }
        }
    }

    /* loaded from: classes.dex */
    public class v implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Collection a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Object f7276b;

        public v(g gVar, Collection collection, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, collection, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = collection;
            this.f7276b = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.add(this.f7276b);
            }
        }
    }

    /* loaded from: classes.dex */
    public class w implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Collection a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Object f7277b;

        public w(g gVar, Collection collection, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, collection, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = collection;
            this.f7277b = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.remove(this.f7277b);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-622708478, "Lc/a/n0/a/x/m/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-622708478, "Lc/a/n0/a/x/m/g;");
                return;
            }
        }
        C = c.a.n0.a.a.a;
    }

    public g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f7260c = "";
        this.r = -1L;
        this.s = new HashSet();
        this.t = new HashSet();
        this.u = new z0();
        this.v = new a(this);
        this.w = new p(this, this);
        this.x = new q(this, this);
        this.y = new r(this);
        this.z = new s(this);
        this.A = new t(this);
        this.B = new j(this);
        this.o = str;
        this.p = new ArrayList();
    }

    public c.a.n0.a.k2.a A0(c.a.n0.q.h.g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, gVar)) == null) {
            if (gVar == null) {
                c.a.n0.a.k2.a aVar = new c.a.n0.a.k2.a();
                aVar.k(11L);
                aVar.i(2310L);
                aVar.f("pkg info is empty");
                c.a.n0.a.k2.e.a().f(aVar);
                return aVar;
            }
            return null;
        }
        return (c.a.n0.a.k2.a) invokeL.objValue;
    }

    @Override // c.a.n0.q.e.i
    public c.a.n0.q.e.e<c.a.n0.q.h.h> B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.w : (c.a.n0.q.e.e) invokeV.objValue;
    }

    public void B0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            c.a.n0.a.k1.q.a.a(this.o, str, this.p, str2);
            this.p.clear();
        }
    }

    public final void C0(c.a.n0.q.h.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
            c.a.n0.a.x.m.c.c().d(cVar, new i(this, cVar));
        }
    }

    @Override // c.a.n0.q.e.i
    public void D(c.a.n0.q.h.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            c.a.n0.a.u.d.k("SwanAppPkgDownloadCallback", "onFetchError: error=" + bVar);
            if (bVar != null && bVar.a == 1010) {
                H0();
            }
            this.p.add(new UbcFlowEvent("na_pms_end_req"));
        }
    }

    public final void D0(c.a.n0.q.h.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, eVar) == null) {
            c.a.n0.a.x.m.c.c().d(eVar, new h(this, eVar));
        }
    }

    @Override // c.a.n0.q.e.i
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.p.add(new UbcFlowEvent("na_pms_start_req"));
        }
    }

    public final void E0(c.a.n0.q.h.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, gVar) == null) {
            c.a.n0.a.x.m.c.c().d(gVar, new f(this, gVar));
        }
    }

    @Override // c.a.n0.q.e.i
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.p.add(new UbcFlowEvent("na_pms_end_req"));
        }
    }

    public final void F0(c.a.n0.q.h.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, hVar) == null) {
            c.a.n0.a.x.m.c.c().d(hVar, new C0552g(this, hVar));
        }
    }

    public c.a.n0.a.k2.a G0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            PMSAppInfo pMSAppInfo = this.n;
            if (pMSAppInfo == null) {
                if (this.j == null) {
                    c.a.n0.a.k2.a aVar = new c.a.n0.a.k2.a();
                    aVar.k(10L);
                    aVar.i(2903L);
                    aVar.d("Server未返回主包&AppInfo");
                    return aVar;
                }
                PMSAppInfo u2 = c.a.n0.q.f.a.i().u(this.o);
                if (u2 == null) {
                    c.a.n0.a.k2.a aVar2 = new c.a.n0.a.k2.a();
                    aVar2.k(10L);
                    aVar2.i(2904L);
                    aVar2.d("Server未返回AppInfo数据，本地也没有数据");
                    return aVar2;
                }
                this.n = u2;
                c.a.n0.a.x.m.u.a.k(u2, this.j);
                this.n.initMaxAgeInfo();
                this.n.updateInstallSrc(K());
                if (c.a.n0.q.f.a.i().b(this.j, this.k, this.l, this.m, this.n)) {
                    return null;
                }
                c.a.n0.a.k2.a aVar3 = new c.a.n0.a.k2.a();
                aVar3.k(10L);
                aVar3.i(2906L);
                aVar3.d("更新DB失败");
                return aVar3;
            }
            c.a.n0.q.h.g gVar = this.j;
            if (gVar != null) {
                c.a.n0.a.x.m.u.a.k(pMSAppInfo, gVar);
            } else if (c.a.n0.a.x.m.u.b.f(this.k)) {
                c.a.n0.q.h.h hVar = this.k.get(0);
                this.q = hVar;
                hVar.o = this.o;
                c.a.n0.a.x.m.u.a.l(this.n, hVar);
            } else {
                PMSAppInfo u3 = c.a.n0.q.f.a.i().u(this.o);
                if (u3 == null) {
                    c.a.n0.a.k2.a aVar4 = new c.a.n0.a.k2.a();
                    aVar4.k(10L);
                    aVar4.i(2905L);
                    aVar4.d("Server未返回包数据，本地也没有数据");
                    return aVar4;
                }
                PMSAppInfo pMSAppInfo2 = this.n;
                pMSAppInfo2.appId = this.o;
                pMSAppInfo2.copyLocalAppInfoData(u3);
            }
            this.n.initMaxAgeInfo();
            this.n.updateInstallSrc(K());
            if (c.a.n0.q.f.a.i().b(this.j, this.k, this.l, this.m, this.n)) {
                c.a.n0.a.x.m.u.a.o(this.n);
                return null;
            }
            c.a.n0.a.k2.a aVar5 = new c.a.n0.a.k2.a();
            aVar5.k(10L);
            aVar5.i(2906L);
            aVar5.d("更新DB失败");
            return aVar5;
        }
        return (c.a.n0.a.k2.a) invokeV.objValue;
    }

    @Override // c.a.n0.q.e.i
    public void H(c.a.n0.q.o.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, gVar) == null) {
            super.H(gVar);
            this.r = System.currentTimeMillis();
            if (C) {
                Log.e("SwanAppPkgDownloadCallback", "mStartDownload=" + this.r);
            }
            if (gVar == null) {
                return;
            }
            if (C) {
                Log.i("SwanAppPkgDownloadCallback", j0() + ": onPrepareDownload: countSet=" + gVar.n());
            }
            this.p.add(new UbcFlowEvent("na_pms_start_download"));
            this.i = gVar;
            if (gVar.k()) {
                return;
            }
            o0();
        }
    }

    public final void H0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            PMSAppInfo u2 = c.a.n0.q.f.a.i().u(this.o);
            c.a.n0.a.u.d.k("SwanAppPkgDownloadCallback", "updateMainMaxAgeTime: createTime=" + u2.createTime + " lastLaunchTime=" + u2.getLastLaunchTime() + " maxAge=" + u2.maxAge);
            if (u2 != null) {
                u2.initMaxAgeInfo();
                u2.updateInstallSrc(K());
                c.a.n0.q.h.g gVar = this.j;
                if (gVar != null) {
                    gVar.f9141c = u2.createTime;
                }
                PMSAppInfo pMSAppInfo = this.n;
                if (pMSAppInfo != null) {
                    pMSAppInfo.createTime = u2.createTime;
                    pMSAppInfo.updateInstallSrc(K());
                }
                c.a.n0.q.f.a.i().l(u2);
            }
        }
    }

    public g f0(c.a.n0.a.p2.g1.c<PMSAppInfo> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, cVar)) == null) {
            g0(this.t, cVar);
            return this;
        }
        return (g) invokeL.objValue;
    }

    public final synchronized <CallbackT> g g0(Collection<CallbackT> collection, CallbackT callbackt) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, collection, callbackt)) == null) {
            synchronized (this) {
                if (collection != null && callbackt != null) {
                    this.u.a(new v(this, collection, callbackt));
                }
            }
            return this;
        }
        return (g) invokeLL.objValue;
    }

    public synchronized g h0(c.a.n0.a.x.m.p.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, aVar)) == null) {
            synchronized (this) {
                g0(this.s, aVar);
            }
            return this;
        }
        return (g) invokeL.objValue;
    }

    public final synchronized <CallbackT> g i0(Collection<CallbackT> collection, CallbackT callbackt) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048592, this, collection, callbackt)) == null) {
            synchronized (this) {
                if (collection != null && callbackt != null) {
                    this.u.a(new w(this, collection, callbackt));
                }
            }
            return this;
        }
        return (g) invokeLL.objValue;
    }

    public String j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (TextUtils.isEmpty(this.f7260c)) {
                this.f7260c = getClass().toString();
            }
            return this.f7260c;
        }
        return (String) invokeV.objValue;
    }

    public int k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return 100;
        }
        return invokeV.intValue;
    }

    public abstract PMSDownloadType l0();

    public final String m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? c.a.n0.q.e.j.b(this, "get_launch_id").getString("launch_id", "") : (String) invokeV.objValue;
    }

    public void n0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            if (i2 == 1013) {
                c.a.n0.q.f.a.i().z(this.o, i2);
            } else {
                c.a.n0.q.f.a.i().z(this.o, 0);
            }
        }
    }

    public final void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            ArrayList arrayList = new ArrayList();
            if (this.i.f()) {
                arrayList.add(g.d.a(new k(this)));
            }
            if (this.i.h()) {
                arrayList.add(g.d.a(new l(this)));
            }
            if (this.i.e()) {
                arrayList.add(g.d.a(new m(this)));
            }
            if (this.i.d()) {
                arrayList.add(g.d.a(new n(this)));
            }
            if (this.i.b()) {
                arrayList.add(g.d.a(new o(this)));
            }
            if (arrayList.isEmpty()) {
                return;
            }
            g.d.i(arrayList).u(this.B);
        }
    }

    public g p0(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, pMSAppInfo)) == null) {
            q0(this.t, new u(this, pMSAppInfo));
            return this;
        }
        return (g) invokeL.objValue;
    }

    @Override // c.a.n0.q.e.i
    public c.a.n0.q.e.h q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.A : (c.a.n0.q.e.h) invokeV.objValue;
    }

    public final synchronized <CallbackT> g q0(@NonNull Collection<CallbackT> collection, @NonNull c.a.n0.a.p2.g1.c<CallbackT> cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048601, this, collection, cVar)) == null) {
            synchronized (this) {
                this.u.a(new b(this, collection, cVar));
            }
            return this;
        }
        return (g) invokeLL.objValue;
    }

    @Override // c.a.n0.q.e.i
    public c.a.n0.q.e.e<c.a.n0.q.h.i> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.x : (c.a.n0.q.e.e) invokeV.objValue;
    }

    public final void r0(c.a.n0.q.h.c cVar) {
        g.j<? super c.a.n0.q.h.c> jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048603, this, cVar) == null) || (jVar = this.f7264g) == null) {
            return;
        }
        jVar.onNext(cVar);
        this.f7264g.onCompleted();
    }

    @Override // c.a.n0.q.e.i
    public c.a.n0.q.e.e<c.a.n0.q.h.c> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.z : (c.a.n0.q.e.e) invokeV.objValue;
    }

    public g s0(@NonNull c.a.n0.a.p2.g1.c<c.a.n0.a.x.m.p.a> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, cVar)) == null) {
            q0(this.s, new c(this, cVar));
            return this;
        }
        return (g) invokeL.objValue;
    }

    @Override // c.a.n0.q.e.i
    public c.a.n0.q.e.e<c.a.n0.q.h.e> t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.y : (c.a.n0.q.e.e) invokeV.objValue;
    }

    public void t0(PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, pMSAppInfo) == null) {
            s0(new e(this, pMSAppInfo));
        }
    }

    public void u0(boolean z, c.a.n0.a.k2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048608, this, z, aVar) == null) {
            s0(new d(this, aVar, z));
        }
    }

    @Override // c.a.n0.q.e.i
    public c.a.n0.q.e.e<c.a.n0.q.h.g> v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.v : (c.a.n0.q.e.e) invokeV.objValue;
    }

    public void v0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048610, this) == null) || this.n == null) {
            return;
        }
        PMSAppInfo u2 = c.a.n0.q.f.a.i().u(this.o);
        if (u2 == null) {
            c.a.n0.a.u.d.k("SwanAppPkgDownloadCallback", "Server未返回包数据，本地也没查到");
            return;
        }
        this.n.appId = this.o;
        u2.updateInstallSrc(K());
        this.n.copyLocalAppInfoData(u2);
        this.n.initMaxAgeInfo();
        if (c.a.n0.q.f.a.i().l(this.n)) {
            c.a.n0.a.x.m.u.a.o(this.n);
        }
    }

    public void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            long currentTimeMillis = System.currentTimeMillis() - this.r;
            c.a.n0.a.u.d.i("SwanAppPkgDownloadCallback", "pms download time : " + currentTimeMillis);
        }
    }

    public abstract void x0(Throwable th);

    public c.a.n0.a.k2.a y0(c.a.n0.q.h.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, cVar)) == null) {
            c.a.n0.a.f0.g.a aVar = new c.a.n0.a.f0.g.a();
            aVar.f4405b = cVar.i;
            aVar.a = cVar.j;
            aVar.f4406c = cVar.a;
            aVar.f4407d = cVar.m;
            if (c.a.n0.a.f0.b.b(cVar.f9146h, aVar) == null) {
                return null;
            }
            c.a.n0.a.k2.a aVar2 = new c.a.n0.a.k2.a();
            aVar2.k(14L);
            aVar2.b(2908L);
            aVar2.d("Extension包更新失败");
            return aVar2;
        }
        return (c.a.n0.a.k2.a) invokeL.objValue;
    }

    public c.a.n0.a.k2.a z0(c.a.n0.q.h.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, eVar)) == null) {
            if (C) {
                Log.d("SwanAppPkgDownloadCallback", "onFrameworkPkgDownload framework = " + eVar);
            }
            a.b c2 = c.a.n0.a.g2.f.a.c(eVar, eVar.f9146h);
            if (!TextUtils.isEmpty(eVar.a)) {
                c.a.n0.a.u.d.k("SwanAppPkgDownloadCallback", "#onFrameworkPkgDownload del: " + eVar.a);
                c.a.n0.w.d.k(eVar.a);
            }
            if (c2.c()) {
                return null;
            }
            c.a.n0.a.k2.a aVar = new c.a.n0.a.k2.a();
            aVar.k(13L);
            aVar.b(2907L);
            aVar.d("Core包更新失败");
            return aVar;
        }
        return (c.a.n0.a.k2.a) invokeL.objValue;
    }
}
