package c.a.r0.a.h0.m;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.d2.i;
import c.a.r0.a.h0.m.c;
import c.a.r0.a.q2.f.a;
import c.a.r0.a.z2.z0;
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
import i.d;
import java.io.File;
import java.io.IOException;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public abstract class g extends c.a.r0.a.h0.m.k {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean G;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.r0.q.f.e<c.a.r0.q.i.h> A;
    public final c.a.r0.q.f.e<c.a.r0.q.i.i> B;
    public c.a.r0.q.f.e<c.a.r0.q.i.e> C;
    public c.a.r0.q.f.e<c.a.r0.q.i.c> D;
    public c.a.r0.q.f.h E;
    public i.j<c.a.r0.q.i.f> F;

    /* renamed from: g  reason: collision with root package name */
    public String f6797g;

    /* renamed from: h  reason: collision with root package name */
    public i.j<? super c.a.r0.q.i.g> f6798h;

    /* renamed from: i  reason: collision with root package name */
    public i.j<? super c.a.r0.q.i.h> f6799i;

    /* renamed from: j  reason: collision with root package name */
    public i.j<? super c.a.r0.q.i.e> f6800j;
    public i.j<? super c.a.r0.q.i.c> k;
    public i.j<? super c.a.r0.q.i.i> l;
    public c.a.r0.q.p.g m;
    public c.a.r0.q.i.g n;
    public List<c.a.r0.q.i.h> o;
    public c.a.r0.q.i.e p;
    public c.a.r0.q.i.c q;
    public PMSAppInfo r;
    public String s;
    public List<UbcFlowEvent> t;
    public c.a.r0.q.i.h u;
    public long v;
    public final Set<c.a.r0.a.h0.m.p.a> w;
    public final Set<c.a.r0.a.z2.g1.c<PMSAppInfo>> x;
    public final z0 y;
    public c.a.r0.q.f.e<c.a.r0.q.i.g> z;

    /* loaded from: classes.dex */
    public class a extends c.a.r0.q.f.b<c.a.r0.q.i.g> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f6801e;

        /* renamed from: c.a.r0.a.h0.m.g$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0394a implements c.a.r0.a.z2.g1.c<i.a> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f6802e;

            public C0394a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f6802e = aVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.r0.a.z2.g1.c
            /* renamed from: a */
            public void onCallback(i.a aVar) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) && "installer_on_pump_finish".equals(aVar.f5685f)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("performance_ubc_event_id", "670");
                    bundle.putString("performance_ubc_extra_key_for_event", "na_stream_bump_end");
                    c.a.r0.q.f.j.a(this.f6802e.f6801e, bundle, "event_performance_ubc");
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6801e = gVar;
        }

        @Override // c.a.r0.q.f.b
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f6801e.k0() : invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.q.f.e
        /* renamed from: l */
        public String d(c.a.r0.q.i.g gVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, gVar)) == null) {
                int i2 = gVar.f11637h;
                if (i2 == 0) {
                    return c.a.r0.a.h0.m.u.a.g();
                }
                if (i2 == 1) {
                    return c.a.r0.a.h0.m.u.a.i();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        @Override // c.a.r0.q.f.g
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle, set)) == null) ? this.f6801e.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.q.f.b, c.a.r0.q.f.e
        /* renamed from: o */
        public void e(c.a.r0.q.i.g gVar, c.a.r0.q.i.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048585, this, gVar, bVar) == null) {
                super.e(gVar, bVar);
                c.a.r0.a.e0.d.k("SwanAppPkgDownloadCallback", "onDownloadError：" + bVar.toString());
                this.f6801e.m.l(gVar);
                c.a.r0.a.u2.a aVar = new c.a.r0.a.u2.a();
                aVar.k(11L);
                aVar.i(bVar.a);
                aVar.d("主包下载失败");
                aVar.f(bVar.toString());
                if (this.f6801e.f6798h != null) {
                    this.f6801e.f6798h.onError(new PkgDownloadError(gVar, aVar));
                }
                c.a.r0.a.h0.m.c.c().a(gVar, this.f6801e.l0(), aVar);
                c.a.r0.w.d.k(gVar.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.q.f.b, c.a.r0.q.f.e
        /* renamed from: p */
        public void i(c.a.r0.q.i.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, gVar) == null) {
                String m0 = this.f6801e.m0();
                if (g.G) {
                    c.a.r0.a.f1.g.a.d(m0).e().d(1);
                }
                super.i(gVar);
                this.f6801e.t.add(new UbcFlowEvent("na_pms_end_download"));
                c.a.r0.a.u2.a A0 = this.f6801e.A0(gVar);
                c.a.r0.a.e0.d.k("SwanAppPkgDownloadCallback", "main onFileDownloaded: pmsPkgMain=" + gVar.f11638i);
                if (A0 == null) {
                    g gVar2 = this.f6801e;
                    gVar2.n = gVar;
                    gVar2.m.m(gVar);
                    if (this.f6801e.f6798h != null) {
                        this.f6801e.f6798h.onNext(gVar);
                        if (g.G) {
                            String str = this.f6801e.j0() + ": main onFileDownloaded: onCompleted";
                        }
                        this.f6801e.f6798h.onCompleted();
                    }
                    c.a.r0.a.h0.m.c.c().b(gVar, this.f6801e.l0());
                    return;
                }
                this.f6801e.m.l(gVar);
                if (this.f6801e.f6798h != null) {
                    this.f6801e.f6798h.onError(new PkgDownloadError(gVar, A0));
                }
                c.a.r0.a.h0.m.c.c().a(gVar, this.f6801e.l0(), A0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.q.f.b, c.a.r0.q.f.e
        /* renamed from: q */
        public void c(c.a.r0.q.i.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, gVar) == null) {
                String m0 = this.f6801e.m0();
                if (g.G) {
                    c.a.r0.a.f1.g.a.d(m0).e().d(1);
                }
                super.c(gVar);
                c.a.r0.a.e0.d.k("SwanAppPkgDownloadCallback", "main onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.q.f.b, c.a.r0.q.f.e
        /* renamed from: r */
        public void f(c.a.r0.q.i.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, gVar) == null) {
                String m0 = this.f6801e.m0();
                if (g.G) {
                    c.a.r0.a.f1.g.a.d(m0).e().d(1);
                }
                super.f(gVar);
                if (g.G) {
                    String str = this.f6801e.j0() + ": main onDownloading";
                }
                this.f6801e.E0(gVar);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.q.f.b, c.a.r0.q.f.e
        /* renamed from: s */
        public c.a.r0.q.i.b h(c.a.r0.q.i.g gVar, File file, long j2, ReadableByteChannel readableByteChannel) throws IOException {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{gVar, file, Long.valueOf(j2), readableByteChannel})) == null) {
                String m0 = this.f6801e.m0();
                if (g.G) {
                    c.a.r0.a.f1.g.a.d(m0).f(gVar.toString()).d(1);
                }
                C0394a c0394a = new C0394a(this);
                Bundle bundle = new Bundle();
                bundle.putLong("length", j2);
                bundle.putFloat("progress_granularity", 0.1f);
                c.a.r0.a.a1.f fVar = new c.a.r0.a.a1.f();
                fVar.v(c0394a);
                fVar.J(bundle);
                fVar.I(new c.a.r0.a.a1.e(gVar, this.f6801e));
                fVar.I(new c.a.r0.a.a1.c(gVar.m, this.f6801e));
                fVar.L(readableByteChannel);
                boolean M = fVar.M();
                fVar.p(c0394a);
                if (g.G) {
                    String str = this.f6801e.j0() + ": onProcessStream: installOk=" + M;
                }
                if (M) {
                    c.a.r0.a.e0.d.k("SwanAppPkgDownloadCallback", "#onProcessStream del: " + file.getAbsolutePath());
                    c.a.r0.w.d.L(file);
                }
                return M ? new c.a.r0.q.i.b(2300, "业务层处理下载流成功") : new c.a.r0.q.i.b(2301, "业务层处理下载流失败");
            }
            return (c.a.r0.q.i.b) invokeCommon.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Collection f6803e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.z2.g1.c f6804f;

        public b(g gVar, Collection collection, c.a.r0.a.z2.g1.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, collection, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6803e = collection;
            this.f6804f = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                for (Object obj : this.f6803e) {
                    this.f6804f.onCallback(obj);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements c.a.r0.a.z2.g1.c<c.a.r0.a.h0.m.p.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.z2.g1.c f6805e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ g f6806f;

        public c(g gVar, c.a.r0.a.z2.g1.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6806f = gVar;
            this.f6805e = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.r0.a.h0.m.p.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f6805e.onCallback(aVar);
                g gVar = this.f6806f;
                gVar.i0(gVar.w, aVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements c.a.r0.a.z2.g1.c<c.a.r0.a.h0.m.p.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.u2.a f6807e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f6808f;

        public d(g gVar, c.a.r0.a.u2.a aVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, aVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6807e = aVar;
            this.f6808f = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.r0.a.h0.m.p.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.a(this.f6807e, this.f6808f);
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements c.a.r0.a.z2.g1.c<c.a.r0.a.h0.m.p.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PMSAppInfo f6809e;

        public e(g gVar, PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, pMSAppInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6809e = pMSAppInfo;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.r0.a.h0.m.p.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.b(this.f6809e);
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements c.InterfaceC0392c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.r0.q.i.g a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g f6810b;

        public f(g gVar, c.a.r0.q.i.g gVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, gVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6810b = gVar;
            this.a = gVar2;
        }

        @Override // c.a.r0.a.h0.m.c.InterfaceC0392c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                g gVar = this.f6810b;
                c.a.r0.q.i.g gVar2 = this.a;
                gVar.n = gVar2;
                gVar.m.m(gVar2);
                if (this.f6810b.f6798h != null) {
                    this.f6810b.f6798h.onNext(this.a);
                    this.f6810b.f6798h.onCompleted();
                }
            }
        }

        @Override // c.a.r0.a.h0.m.c.InterfaceC0392c
        public void b(PMSDownloadType pMSDownloadType, c.a.r0.a.u2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, aVar) == null) {
                this.f6810b.m.l(this.a);
                if (this.f6810b.f6798h != null) {
                    this.f6810b.f6798h.onError(new PkgDownloadError(this.a, aVar));
                }
            }
        }
    }

    /* renamed from: c.a.r0.a.h0.m.g$g  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0395g implements c.InterfaceC0392c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.r0.q.i.h a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g f6811b;

        public C0395g(g gVar, c.a.r0.q.i.h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6811b = gVar;
            this.a = hVar;
        }

        @Override // c.a.r0.a.h0.m.c.InterfaceC0392c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                g gVar = this.f6811b;
                if (gVar.o == null) {
                    gVar.o = new ArrayList();
                }
                c.a.r0.q.i.h hVar = this.a;
                g gVar2 = this.f6811b;
                hVar.o = gVar2.s;
                gVar2.o.add(hVar);
                this.f6811b.m.m(this.a);
                if (this.f6811b.f6799i != null) {
                    this.f6811b.f6799i.onNext(this.a);
                    if (this.f6811b.m.i()) {
                        return;
                    }
                    this.f6811b.f6799i.onCompleted();
                }
            }
        }

        @Override // c.a.r0.a.h0.m.c.InterfaceC0392c
        public void b(PMSDownloadType pMSDownloadType, c.a.r0.a.u2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, aVar) == null) {
                this.f6811b.m.l(this.a);
                if (this.f6811b.f6799i != null) {
                    this.f6811b.f6799i.onError(new PkgDownloadError(this.a, aVar));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class h implements c.InterfaceC0392c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.r0.q.i.e a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g f6812b;

        public h(g gVar, c.a.r0.q.i.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6812b = gVar;
            this.a = eVar;
        }

        @Override // c.a.r0.a.h0.m.c.InterfaceC0392c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                g gVar = this.f6812b;
                c.a.r0.q.i.e eVar = this.a;
                gVar.p = eVar;
                gVar.m.m(eVar);
                if (this.f6812b.f6800j != null) {
                    this.f6812b.f6800j.onNext(this.a);
                    this.f6812b.f6800j.onCompleted();
                }
            }
        }

        @Override // c.a.r0.a.h0.m.c.InterfaceC0392c
        public void b(PMSDownloadType pMSDownloadType, c.a.r0.a.u2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, aVar) == null) {
                this.f6812b.m.l(this.a);
                if (this.f6812b.f6800j != null) {
                    this.f6812b.f6800j.onError(new PkgDownloadError(this.a, aVar));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class i implements c.InterfaceC0392c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.r0.q.i.c a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g f6813b;

        public i(g gVar, c.a.r0.q.i.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6813b = gVar;
            this.a = cVar;
        }

        @Override // c.a.r0.a.h0.m.c.InterfaceC0392c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                c.a.r0.a.e0.d.k("SwanAppPkgDownloadCallback", "Extension Repeat: onSuccess ：" + pMSDownloadType);
                g gVar = this.f6813b;
                c.a.r0.q.i.c cVar = this.a;
                gVar.q = cVar;
                gVar.m.m(cVar);
                this.f6813b.r0(this.a);
            }
        }

        @Override // c.a.r0.a.h0.m.c.InterfaceC0392c
        public void b(PMSDownloadType pMSDownloadType, c.a.r0.a.u2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, aVar) == null) {
                c.a.r0.a.e0.d.k("SwanAppPkgDownloadCallback", "Extension Repeat: onError ：" + pMSDownloadType + ":" + aVar.toString());
                this.f6813b.m.l(this.a);
                this.f6813b.r0(this.a);
            }
        }
    }

    /* loaded from: classes.dex */
    public class j extends i.j<c.a.r0.q.i.f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ g f6814i;

        public j(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6814i = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // i.e
        /* renamed from: g */
        public void onNext(c.a.r0.q.i.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                c.a.r0.a.e0.d.k("SwanAppPkgDownloadCallback", this.f6814i.l0() + " : 单个包下载、业务层处理完成：" + fVar.f11638i);
            }
        }

        @Override // i.e
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                c.a.r0.a.e0.d.k("SwanAppPkgDownloadCallback", this.f6814i.l0() + " : 包下载onCompleted");
                this.f6814i.w0();
            }
        }

        @Override // i.e
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                c.a.r0.a.e0.d.l("SwanAppPkgDownloadCallback", this.f6814i.l0() + " : 包下载OnError", th);
                this.f6814i.x0(th);
            }
        }
    }

    /* loaded from: classes.dex */
    public class k implements d.a<c.a.r0.q.i.g> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f6815e;

        public k(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6815e = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // i.d.a, i.n.b
        public void call(i.j<? super c.a.r0.q.i.g> jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
                this.f6815e.f6798h = jVar;
            }
        }
    }

    /* loaded from: classes.dex */
    public class l implements d.a<c.a.r0.q.i.h> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f6816e;

        public l(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6816e = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // i.d.a, i.n.b
        public void call(i.j<? super c.a.r0.q.i.h> jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
                this.f6816e.f6799i = jVar;
            }
        }
    }

    /* loaded from: classes.dex */
    public class m implements d.a<c.a.r0.q.i.e> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f6817e;

        public m(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6817e = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // i.d.a, i.n.b
        public void call(i.j<? super c.a.r0.q.i.e> jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
                this.f6817e.f6800j = jVar;
            }
        }
    }

    /* loaded from: classes.dex */
    public class n implements d.a<c.a.r0.q.i.c> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f6818e;

        public n(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6818e = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // i.d.a, i.n.b
        public void call(i.j<? super c.a.r0.q.i.c> jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
                this.f6818e.k = jVar;
            }
        }
    }

    /* loaded from: classes.dex */
    public class o implements d.a<c.a.r0.q.i.i> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f6819e;

        public o(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6819e = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // i.d.a, i.n.b
        public void call(i.j<? super c.a.r0.q.i.i> jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
                this.f6819e.l = jVar;
            }
        }
    }

    /* loaded from: classes.dex */
    public class p extends c.a.r0.a.h0.m.n<g> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ g f6820g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(g gVar, g gVar2) {
            super(gVar2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, gVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((c.a.r0.a.h0.m.k) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6820g = gVar;
        }

        @Override // c.a.r0.a.h0.m.n, c.a.r0.q.f.b
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f6820g.k0() : invokeV.intValue;
        }

        @Override // c.a.r0.a.h0.m.n
        public String l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f6820g.s : (String) invokeV.objValue;
        }

        @Override // c.a.r0.a.h0.m.n
        public void p(@NonNull c.a.r0.q.i.h hVar, @Nullable c.a.r0.a.u2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, hVar, aVar) == null) {
                super.p(hVar, aVar);
                c.a.r0.a.e0.d.k("SwanAppPkgDownloadCallback", "sub onFileDownloaded: " + hVar.f11638i);
                g gVar = this.f6820g;
                if (gVar.o == null) {
                    gVar.o = new ArrayList();
                }
                g gVar2 = this.f6820g;
                hVar.o = gVar2.s;
                if (aVar == null) {
                    gVar2.o.add(hVar);
                    this.f6820g.m.m(hVar);
                    c.a.r0.a.h0.m.c.c().b(hVar, this.f6820g.l0());
                } else {
                    gVar2.m.l(hVar);
                    c.a.r0.a.h0.m.c.c().a(hVar, this.f6820g.l0(), aVar);
                }
                if (this.f6820g.f6799i != null) {
                    this.f6820g.f6799i.onNext(hVar);
                    if (this.f6820g.m.i()) {
                        return;
                    }
                    this.f6820g.f6799i.onCompleted();
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.q.f.b, c.a.r0.q.f.e
        /* renamed from: q */
        public void e(c.a.r0.q.i.h hVar, c.a.r0.q.i.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, hVar, bVar) == null) {
                super.q(hVar, bVar);
                c.a.r0.a.e0.d.k("SwanAppPkgDownloadCallback", "sub onDownloadError：" + bVar.toString());
                this.f6820g.m.l(hVar);
                c.a.r0.a.u2.a aVar = new c.a.r0.a.u2.a();
                aVar.k(12L);
                aVar.i(bVar.a);
                aVar.d("分包下载失败");
                aVar.f(bVar.toString());
                if (this.f6820g.f6799i != null) {
                    this.f6820g.f6799i.onError(new PkgDownloadError(hVar, aVar));
                }
                c.a.r0.a.h0.m.c.c().a(hVar, this.f6820g.l0(), aVar);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.a.h0.m.n, c.a.r0.q.f.b, c.a.r0.q.f.e
        /* renamed from: s */
        public void c(c.a.r0.q.i.h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, hVar) == null) {
                super.c(hVar);
                c.a.r0.a.e0.d.k("SwanAppPkgDownloadCallback", "sub onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.q.f.b, c.a.r0.q.f.e
        /* renamed from: u */
        public void f(c.a.r0.q.i.h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, hVar) == null) {
                super.f(hVar);
                this.f6820g.F0(hVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class q extends c.a.r0.a.h0.m.l<g> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ g f6821f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(g gVar, g gVar2) {
            super(gVar2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, gVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((c.a.r0.a.h0.m.k) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6821f = gVar;
        }

        @Override // c.a.r0.q.f.b
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f6821f.k0() : invokeV.intValue;
        }

        @Override // c.a.r0.a.h0.m.l
        public PMSDownloadType o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f6821f.l0() : (PMSDownloadType) invokeV.objValue;
        }

        @Override // c.a.r0.a.h0.m.l
        public void r(@NonNull c.a.r0.q.i.i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, iVar) == null) {
                this.f6821f.m.m(iVar);
                if (this.f6821f.l != null) {
                    this.f6821f.l.onNext(iVar);
                    if (this.f6821f.m.c()) {
                        return;
                    }
                    this.f6821f.l.onCompleted();
                }
            }
        }

        @Override // c.a.r0.a.h0.m.l
        public void u(c.a.r0.q.i.i iVar, c.a.r0.a.u2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, iVar, aVar) == null) {
                c.a.r0.a.e0.d.k("SwanAppPkgDownloadCallback", "dependent onDownloadOrUnzipFail：" + aVar);
                this.f6821f.m.l(iVar);
                if (this.f6821f.l != null) {
                    this.f6821f.l.onError(new PkgDownloadError(iVar, aVar));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.a.h0.m.l, c.a.r0.q.f.b, c.a.r0.q.f.e
        /* renamed from: v */
        public void c(c.a.r0.q.i.i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, iVar) == null) {
                super.c(iVar);
                c.a.r0.a.e0.d.k("SwanAppPkgDownloadCallback", "dependent onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.a.h0.m.l, c.a.r0.q.f.b, c.a.r0.q.f.e
        /* renamed from: w */
        public void f(c.a.r0.q.i.i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, iVar) == null) {
                super.f(iVar);
                if (g.G) {
                    String str = this.f6821f.j0() + ": dependent onDownloading";
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class r extends c.a.r0.q.f.b<c.a.r0.q.i.e> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f6822e;

        public r(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6822e = gVar;
        }

        @Override // c.a.r0.q.f.b
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f6822e.k0() : invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.q.f.e
        /* renamed from: l */
        public String d(c.a.r0.q.i.e eVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, eVar)) == null) {
                int i2 = eVar.f11637h;
                if (i2 == 0) {
                    return c.a.r0.a.h0.m.u.a.h();
                }
                if (i2 == 1) {
                    return c.a.r0.a.h0.m.u.a.e();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        @Override // c.a.r0.q.f.g
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) ? this.f6822e.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.q.f.b, c.a.r0.q.f.e
        /* renamed from: o */
        public void e(c.a.r0.q.i.e eVar, c.a.r0.q.i.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar, bVar) == null) {
                super.e(eVar, bVar);
                c.a.r0.a.e0.d.k("SwanAppPkgDownloadCallback", "framework onDownloadError：" + bVar.toString());
                this.f6822e.m.l(eVar);
                c.a.r0.a.u2.a aVar = new c.a.r0.a.u2.a();
                aVar.k(13L);
                aVar.i(bVar.a);
                aVar.d("Framework包下载失败");
                aVar.f(bVar.toString());
                if (this.f6822e.f6800j != null) {
                    this.f6822e.f6800j.onError(new PkgDownloadError(eVar, aVar));
                }
                c.a.r0.a.h0.m.c.c().a(eVar, this.f6822e.l0(), aVar);
                c.a.r0.w.d.k(eVar.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.q.f.b, c.a.r0.q.f.e
        /* renamed from: p */
        public void i(c.a.r0.q.i.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, eVar) == null) {
                super.i(eVar);
                c.a.r0.a.e0.d.k("SwanAppPkgDownloadCallback", "framework onFileDownloaded: " + eVar.f11638i);
                c.a.r0.a.u2.a z0 = this.f6822e.z0(eVar);
                if (z0 == null) {
                    g gVar = this.f6822e;
                    gVar.p = eVar;
                    gVar.m.m(eVar);
                    if (this.f6822e.f6800j != null) {
                        this.f6822e.f6800j.onNext(eVar);
                        this.f6822e.f6800j.onCompleted();
                    }
                    c.a.r0.a.h0.m.c.c().b(eVar, this.f6822e.l0());
                    return;
                }
                this.f6822e.m.l(eVar);
                if (this.f6822e.f6800j != null) {
                    this.f6822e.f6800j.onError(new PkgDownloadError(eVar, z0));
                }
                c.a.r0.a.h0.m.c.c().a(eVar, this.f6822e.l0(), z0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.q.f.b, c.a.r0.q.f.e
        /* renamed from: q */
        public void c(c.a.r0.q.i.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, eVar) == null) {
                super.c(eVar);
                c.a.r0.a.e0.d.k("SwanAppPkgDownloadCallback", "framework onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.q.f.b, c.a.r0.q.f.e
        /* renamed from: r */
        public void f(c.a.r0.q.i.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, eVar) == null) {
                super.f(eVar);
                if (g.G) {
                    String str = this.f6822e.j0() + ": framework onDownloading";
                }
                this.f6822e.D0(eVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class s extends c.a.r0.q.f.b<c.a.r0.q.i.c> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f6823e;

        public s(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6823e = gVar;
        }

        @Override // c.a.r0.q.f.b
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f6823e.k0() : invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.q.f.e
        /* renamed from: l */
        public String d(c.a.r0.q.i.c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, cVar)) == null) {
                int i2 = cVar.f11637h;
                if (i2 == 0) {
                    return c.a.r0.a.h0.m.u.a.d();
                }
                if (i2 == 1) {
                    return c.a.r0.a.h0.m.u.a.f();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        @Override // c.a.r0.q.f.g
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) ? this.f6823e.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.q.f.b, c.a.r0.q.f.e
        /* renamed from: o */
        public void e(c.a.r0.q.i.c cVar, c.a.r0.q.i.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar, bVar) == null) {
                super.e(cVar, bVar);
                c.a.r0.a.e0.d.k("SwanAppPkgDownloadCallback", "extension onDownloadError：" + bVar.toString());
                this.f6823e.m.l(cVar);
                c.a.r0.a.u2.a aVar = new c.a.r0.a.u2.a();
                aVar.k(14L);
                aVar.i(bVar.a);
                aVar.d("Extension下载失败");
                aVar.f(bVar.toString());
                if (g.G) {
                    aVar.toString();
                }
                this.f6823e.r0(cVar);
                c.a.r0.a.h0.m.c.c().a(cVar, this.f6823e.l0(), aVar);
                c.a.r0.w.d.k(cVar.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.q.f.b, c.a.r0.q.f.e
        /* renamed from: p */
        public void i(c.a.r0.q.i.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, cVar) == null) {
                super.i(cVar);
                c.a.r0.a.e0.d.k("SwanAppPkgDownloadCallback", "extension onFileDownloaded: " + cVar.f11638i);
                c.a.r0.a.u2.a y0 = this.f6823e.y0(cVar);
                if (y0 != null) {
                    if (g.G) {
                        String str = "Extension 业务处理失败：" + cVar.toString();
                    }
                    this.f6823e.m.l(cVar);
                    this.f6823e.r0(cVar);
                    c.a.r0.a.h0.m.c.c().a(cVar, this.f6823e.l0(), y0);
                    return;
                }
                g gVar = this.f6823e;
                gVar.q = cVar;
                gVar.m.m(cVar);
                this.f6823e.r0(cVar);
                c.a.r0.a.h0.m.c.c().b(cVar, this.f6823e.l0());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.q.f.b, c.a.r0.q.f.e
        /* renamed from: q */
        public void c(c.a.r0.q.i.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, cVar) == null) {
                super.c(cVar);
                c.a.r0.a.e0.d.k("SwanAppPkgDownloadCallback", "extension onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.q.f.b, c.a.r0.q.f.e
        /* renamed from: r */
        public void f(c.a.r0.q.i.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, cVar) == null) {
                super.f(cVar);
                if (g.G) {
                    String str = this.f6823e.j0() + ": extension onDownloading";
                }
                this.f6823e.C0(cVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class t implements c.a.r0.q.f.h {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gVar;
        }

        @Override // c.a.r0.q.f.h
        public void a(PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSAppInfo) == null) {
                if (g.G) {
                    String str = this.a.j0() + ": onSwanAppReceive: " + pMSAppInfo.toString();
                }
                g gVar = this.a;
                gVar.r = pMSAppInfo;
                if (pMSAppInfo != null) {
                    gVar.p0(pMSAppInfo);
                    c.a.r0.a.w1.h.b.k(this.a.r.pluginInfo, true);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class u implements c.a.r0.a.z2.g1.c<c.a.r0.a.z2.g1.c<PMSAppInfo>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PMSAppInfo f6824e;

        public u(g gVar, PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, pMSAppInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6824e = pMSAppInfo;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.r0.a.z2.g1.c<PMSAppInfo> cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
                cVar.onCallback(this.f6824e);
            }
        }
    }

    /* loaded from: classes.dex */
    public class v implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Collection f6825e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Object f6826f;

        public v(g gVar, Collection collection, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, collection, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6825e = collection;
            this.f6826f = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f6825e.add(this.f6826f);
            }
        }
    }

    /* loaded from: classes.dex */
    public class w implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Collection f6827e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Object f6828f;

        public w(g gVar, Collection collection, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, collection, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6827e = collection;
            this.f6828f = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f6827e.remove(this.f6828f);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1345213028, "Lc/a/r0/a/h0/m/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1345213028, "Lc/a/r0/a/h0/m/g;");
                return;
            }
        }
        G = c.a.r0.a.k.a;
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
        this.f6797g = "";
        this.v = -1L;
        this.w = new HashSet();
        this.x = new HashSet();
        this.y = new z0();
        this.z = new a(this);
        this.A = new p(this, this);
        this.B = new q(this, this);
        this.C = new r(this);
        this.D = new s(this);
        this.E = new t(this);
        this.F = new j(this);
        this.s = str;
        this.t = new ArrayList();
    }

    public c.a.r0.a.u2.a A0(c.a.r0.q.i.g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, gVar)) == null) {
            if (gVar == null) {
                c.a.r0.a.u2.a aVar = new c.a.r0.a.u2.a();
                aVar.k(11L);
                aVar.i(2310L);
                aVar.f("pkg info is empty");
                c.a.r0.a.u2.e.a().f(aVar);
                return aVar;
            }
            return null;
        }
        return (c.a.r0.a.u2.a) invokeL.objValue;
    }

    @Override // c.a.r0.q.f.i
    public c.a.r0.q.f.e<c.a.r0.q.i.h> B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.A : (c.a.r0.q.f.e) invokeV.objValue;
    }

    public void B0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            c.a.r0.a.u1.q.a.a(this.s, str, this.t, str2);
            this.t.clear();
        }
    }

    public final void C0(c.a.r0.q.i.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
            c.a.r0.a.h0.m.c.c().d(cVar, new i(this, cVar));
        }
    }

    @Override // c.a.r0.q.f.i
    public void D(c.a.r0.q.i.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            c.a.r0.a.e0.d.k("SwanAppPkgDownloadCallback", "onFetchError: error=" + bVar);
            if (bVar != null && bVar.a == 1010) {
                H0();
            }
            this.t.add(new UbcFlowEvent("na_pms_end_req"));
        }
    }

    public final void D0(c.a.r0.q.i.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, eVar) == null) {
            c.a.r0.a.h0.m.c.c().d(eVar, new h(this, eVar));
        }
    }

    @Override // c.a.r0.q.f.i
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.t.add(new UbcFlowEvent("na_pms_start_req"));
        }
    }

    public final void E0(c.a.r0.q.i.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, gVar) == null) {
            c.a.r0.a.h0.m.c.c().d(gVar, new f(this, gVar));
        }
    }

    @Override // c.a.r0.q.f.i
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.t.add(new UbcFlowEvent("na_pms_end_req"));
        }
    }

    public final void F0(c.a.r0.q.i.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, hVar) == null) {
            c.a.r0.a.h0.m.c.c().d(hVar, new C0395g(this, hVar));
        }
    }

    public c.a.r0.a.u2.a G0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            PMSAppInfo pMSAppInfo = this.r;
            if (pMSAppInfo == null) {
                if (this.n == null) {
                    c.a.r0.a.u2.a aVar = new c.a.r0.a.u2.a();
                    aVar.k(10L);
                    aVar.i(2903L);
                    aVar.d("Server未返回主包&AppInfo");
                    return aVar;
                }
                PMSAppInfo u2 = c.a.r0.q.g.a.i().u(this.s);
                if (u2 == null) {
                    c.a.r0.a.u2.a aVar2 = new c.a.r0.a.u2.a();
                    aVar2.k(10L);
                    aVar2.i(2904L);
                    aVar2.d("Server未返回AppInfo数据，本地也没有数据");
                    return aVar2;
                }
                this.r = u2;
                c.a.r0.a.h0.m.u.a.k(u2, this.n);
                this.r.initMaxAgeInfo();
                this.r.updateInstallSrc(K());
                if (c.a.r0.q.g.a.i().b(this.n, this.o, this.p, this.q, this.r)) {
                    return null;
                }
                c.a.r0.a.u2.a aVar3 = new c.a.r0.a.u2.a();
                aVar3.k(10L);
                aVar3.i(2906L);
                aVar3.d("更新DB失败");
                return aVar3;
            }
            c.a.r0.q.i.g gVar = this.n;
            if (gVar != null) {
                c.a.r0.a.h0.m.u.a.k(pMSAppInfo, gVar);
            } else if (c.a.r0.a.h0.m.u.b.f(this.o)) {
                c.a.r0.q.i.h hVar = this.o.get(0);
                this.u = hVar;
                hVar.o = this.s;
                c.a.r0.a.h0.m.u.a.l(this.r, hVar);
            } else {
                PMSAppInfo u3 = c.a.r0.q.g.a.i().u(this.s);
                if (u3 == null) {
                    c.a.r0.a.u2.a aVar4 = new c.a.r0.a.u2.a();
                    aVar4.k(10L);
                    aVar4.i(2905L);
                    aVar4.d("Server未返回包数据，本地也没有数据");
                    return aVar4;
                }
                PMSAppInfo pMSAppInfo2 = this.r;
                pMSAppInfo2.appId = this.s;
                pMSAppInfo2.copyLocalAppInfoData(u3);
            }
            this.r.initMaxAgeInfo();
            this.r.updateInstallSrc(K());
            if (c.a.r0.q.g.a.i().b(this.n, this.o, this.p, this.q, this.r)) {
                c.a.r0.a.h0.m.u.a.o(this.r);
                return null;
            }
            c.a.r0.a.u2.a aVar5 = new c.a.r0.a.u2.a();
            aVar5.k(10L);
            aVar5.i(2906L);
            aVar5.d("更新DB失败");
            return aVar5;
        }
        return (c.a.r0.a.u2.a) invokeV.objValue;
    }

    @Override // c.a.r0.q.f.i
    public void H(c.a.r0.q.p.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, gVar) == null) {
            super.H(gVar);
            this.v = System.currentTimeMillis();
            if (G) {
                String str = "mStartDownload=" + this.v;
            }
            if (gVar == null) {
                return;
            }
            if (G) {
                String str2 = j0() + ": onPrepareDownload: countSet=" + gVar.n();
            }
            this.t.add(new UbcFlowEvent("na_pms_start_download"));
            this.m = gVar;
            if (gVar.k()) {
                return;
            }
            o0();
        }
    }

    public final void H0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            PMSAppInfo u2 = c.a.r0.q.g.a.i().u(this.s);
            c.a.r0.a.e0.d.k("SwanAppPkgDownloadCallback", "updateMainMaxAgeTime: createTime=" + u2.createTime + " lastLaunchTime=" + u2.getLastLaunchTime() + " maxAge=" + u2.maxAge);
            if (u2 != null) {
                u2.initMaxAgeInfo();
                u2.updateInstallSrc(K());
                c.a.r0.q.i.g gVar = this.n;
                if (gVar != null) {
                    gVar.f11632c = u2.createTime;
                }
                PMSAppInfo pMSAppInfo = this.r;
                if (pMSAppInfo != null) {
                    pMSAppInfo.createTime = u2.createTime;
                    pMSAppInfo.updateInstallSrc(K());
                }
                c.a.r0.q.g.a.i().l(u2);
            }
        }
    }

    public g f0(c.a.r0.a.z2.g1.c<PMSAppInfo> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, cVar)) == null) {
            g0(this.x, cVar);
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
                    this.y.a(new v(this, collection, callbackt));
                }
            }
            return this;
        }
        return (g) invokeLL.objValue;
    }

    public synchronized g h0(c.a.r0.a.h0.m.p.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, aVar)) == null) {
            synchronized (this) {
                g0(this.w, aVar);
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
                    this.y.a(new w(this, collection, callbackt));
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
            if (TextUtils.isEmpty(this.f6797g)) {
                this.f6797g = getClass().toString();
            }
            return this.f6797g;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? c.a.r0.q.f.j.b(this, "get_launch_id").getString("launch_id", "") : (String) invokeV.objValue;
    }

    public void n0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            if (i2 == 1013) {
                c.a.r0.q.g.a.i().z(this.s, i2);
            } else {
                c.a.r0.q.g.a.i().z(this.s, 0);
            }
        }
    }

    public final void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            ArrayList arrayList = new ArrayList();
            if (this.m.f()) {
                arrayList.add(i.d.a(new k(this)));
            }
            if (this.m.h()) {
                arrayList.add(i.d.a(new l(this)));
            }
            if (this.m.e()) {
                arrayList.add(i.d.a(new m(this)));
            }
            if (this.m.d()) {
                arrayList.add(i.d.a(new n(this)));
            }
            if (this.m.b()) {
                arrayList.add(i.d.a(new o(this)));
            }
            if (arrayList.isEmpty()) {
                return;
            }
            i.d.i(arrayList).u(this.F);
        }
    }

    public g p0(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, pMSAppInfo)) == null) {
            q0(this.x, new u(this, pMSAppInfo));
            return this;
        }
        return (g) invokeL.objValue;
    }

    @Override // c.a.r0.q.f.i
    public c.a.r0.q.f.h q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.E : (c.a.r0.q.f.h) invokeV.objValue;
    }

    public final synchronized <CallbackT> g q0(@NonNull Collection<CallbackT> collection, @NonNull c.a.r0.a.z2.g1.c<CallbackT> cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048601, this, collection, cVar)) == null) {
            synchronized (this) {
                this.y.a(new b(this, collection, cVar));
            }
            return this;
        }
        return (g) invokeLL.objValue;
    }

    @Override // c.a.r0.q.f.i
    public c.a.r0.q.f.e<c.a.r0.q.i.i> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.B : (c.a.r0.q.f.e) invokeV.objValue;
    }

    public final void r0(c.a.r0.q.i.c cVar) {
        i.j<? super c.a.r0.q.i.c> jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048603, this, cVar) == null) || (jVar = this.k) == null) {
            return;
        }
        jVar.onNext(cVar);
        this.k.onCompleted();
    }

    @Override // c.a.r0.q.f.i
    public c.a.r0.q.f.e<c.a.r0.q.i.c> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.D : (c.a.r0.q.f.e) invokeV.objValue;
    }

    public g s0(@NonNull c.a.r0.a.z2.g1.c<c.a.r0.a.h0.m.p.a> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, cVar)) == null) {
            q0(this.w, new c(this, cVar));
            return this;
        }
        return (g) invokeL.objValue;
    }

    @Override // c.a.r0.q.f.i
    public c.a.r0.q.f.e<c.a.r0.q.i.e> t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.C : (c.a.r0.q.f.e) invokeV.objValue;
    }

    public void t0(PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, pMSAppInfo) == null) {
            s0(new e(this, pMSAppInfo));
        }
    }

    public void u0(boolean z, c.a.r0.a.u2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048608, this, z, aVar) == null) {
            s0(new d(this, aVar, z));
        }
    }

    @Override // c.a.r0.q.f.i
    public c.a.r0.q.f.e<c.a.r0.q.i.g> v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.z : (c.a.r0.q.f.e) invokeV.objValue;
    }

    public void v0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048610, this) == null) || this.r == null) {
            return;
        }
        PMSAppInfo u2 = c.a.r0.q.g.a.i().u(this.s);
        if (u2 == null) {
            c.a.r0.a.e0.d.k("SwanAppPkgDownloadCallback", "Server未返回包数据，本地也没查到");
            return;
        }
        this.r.appId = this.s;
        u2.updateInstallSrc(K());
        this.r.copyLocalAppInfoData(u2);
        this.r.initMaxAgeInfo();
        if (c.a.r0.q.g.a.i().l(this.r)) {
            c.a.r0.a.h0.m.u.a.o(this.r);
        }
    }

    public void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            long currentTimeMillis = System.currentTimeMillis() - this.v;
            c.a.r0.a.e0.d.i("SwanAppPkgDownloadCallback", "pms download time : " + currentTimeMillis);
        }
    }

    public abstract void x0(Throwable th);

    public c.a.r0.a.u2.a y0(c.a.r0.q.i.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, cVar)) == null) {
            c.a.r0.a.p0.g.a aVar = new c.a.r0.a.p0.g.a();
            aVar.f8387b = cVar.f11638i;
            aVar.a = cVar.f11639j;
            aVar.f8388c = cVar.a;
            aVar.f8389d = cVar.m;
            if (c.a.r0.a.p0.b.b(cVar.f11637h, aVar) == null) {
                return null;
            }
            c.a.r0.a.u2.a aVar2 = new c.a.r0.a.u2.a();
            aVar2.k(14L);
            aVar2.b(2908L);
            aVar2.d("Extension包更新失败");
            return aVar2;
        }
        return (c.a.r0.a.u2.a) invokeL.objValue;
    }

    public c.a.r0.a.u2.a z0(c.a.r0.q.i.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, eVar)) == null) {
            if (G) {
                String str = "onFrameworkPkgDownload framework = " + eVar;
            }
            a.b c2 = c.a.r0.a.q2.f.a.c(eVar, eVar.f11637h);
            if (!TextUtils.isEmpty(eVar.a)) {
                c.a.r0.a.e0.d.k("SwanAppPkgDownloadCallback", "#onFrameworkPkgDownload del: " + eVar.a);
                c.a.r0.w.d.k(eVar.a);
            }
            if (c2.c()) {
                return null;
            }
            c.a.r0.a.u2.a aVar = new c.a.r0.a.u2.a();
            aVar.k(13L);
            aVar.b(2907L);
            aVar.d("Core包更新失败");
            return aVar;
        }
        return (c.a.r0.a.u2.a) invokeL.objValue;
    }
}
