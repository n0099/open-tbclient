package b.a.p0.a.h0.m;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.d2.i;
import b.a.p0.a.h0.m.c;
import b.a.p0.a.q2.f.a;
import b.a.p0.a.z2.z0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.cloudcontrol.utils.CloudStabilityUBCUtils;
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
import h.d;
import java.io.File;
import java.io.IOException;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public abstract class g extends b.a.p0.a.h0.m.k {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean G;
    public transient /* synthetic */ FieldHolder $fh;
    public b.a.p0.q.f.e<b.a.p0.q.i.h> A;
    public final b.a.p0.q.f.e<b.a.p0.q.i.i> B;
    public b.a.p0.q.f.e<b.a.p0.q.i.e> C;
    public b.a.p0.q.f.e<b.a.p0.q.i.c> D;
    public b.a.p0.q.f.h E;
    public h.j<b.a.p0.q.i.f> F;

    /* renamed from: g  reason: collision with root package name */
    public String f5815g;

    /* renamed from: h  reason: collision with root package name */
    public h.j<? super b.a.p0.q.i.g> f5816h;

    /* renamed from: i  reason: collision with root package name */
    public h.j<? super b.a.p0.q.i.h> f5817i;
    public h.j<? super b.a.p0.q.i.e> j;
    public h.j<? super b.a.p0.q.i.c> k;
    public h.j<? super b.a.p0.q.i.i> l;
    public b.a.p0.q.p.g m;
    public b.a.p0.q.i.g n;
    public List<b.a.p0.q.i.h> o;
    public b.a.p0.q.i.e p;
    public b.a.p0.q.i.c q;
    public PMSAppInfo r;
    public String s;
    public List<UbcFlowEvent> t;
    public b.a.p0.q.i.h u;
    public long v;
    public final Set<b.a.p0.a.h0.m.p.a> w;
    public final Set<b.a.p0.a.z2.g1.c<PMSAppInfo>> x;
    public final z0 y;
    public b.a.p0.q.f.e<b.a.p0.q.i.g> z;

    /* loaded from: classes.dex */
    public class a extends b.a.p0.q.f.b<b.a.p0.q.i.g> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f5818e;

        /* renamed from: b.a.p0.a.h0.m.g$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0236a implements b.a.p0.a.z2.g1.c<i.a> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f5819e;

            public C0236a(a aVar) {
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
                this.f5819e = aVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // b.a.p0.a.z2.g1.c
            /* renamed from: a */
            public void onCallback(i.a aVar) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) && "installer_on_pump_finish".equals(aVar.f4480f)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("performance_ubc_event_id", "670");
                    bundle.putString("performance_ubc_extra_key_for_event", "na_stream_bump_end");
                    b.a.p0.q.f.j.a(this.f5819e.f5818e, bundle, "event_performance_ubc");
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
            this.f5818e = gVar;
        }

        @Override // b.a.p0.q.f.b
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f5818e.j0() : invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.q.f.e
        /* renamed from: l */
        public String d(b.a.p0.q.i.g gVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, gVar)) == null) {
                int i2 = gVar.f11775h;
                if (i2 == 0) {
                    return b.a.p0.a.h0.m.u.a.g();
                }
                if (i2 == 1) {
                    return b.a.p0.a.h0.m.u.a.i();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        @Override // b.a.p0.q.f.g
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle, set)) == null) ? this.f5818e.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.q.f.b, b.a.p0.q.f.e
        /* renamed from: o */
        public void e(b.a.p0.q.i.g gVar, b.a.p0.q.i.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048585, this, gVar, bVar) == null) {
                super.e(gVar, bVar);
                b.a.p0.a.e0.d.k("SwanAppPkgDownloadCallback", "onDownloadError：" + bVar.toString());
                this.f5818e.m.l(gVar);
                b.a.p0.a.u2.a aVar = new b.a.p0.a.u2.a();
                aVar.k(11L);
                aVar.i(bVar.f11762a);
                aVar.d("主包下载失败");
                aVar.f(bVar.toString());
                if (this.f5818e.f5816h != null) {
                    this.f5818e.f5816h.onError(new PkgDownloadError(gVar, aVar));
                }
                b.a.p0.a.h0.m.c.c().a(gVar, this.f5818e.k0(), aVar);
                b.a.p0.w.d.k(gVar.f11768a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.q.f.b, b.a.p0.q.f.e
        /* renamed from: p */
        public void i(b.a.p0.q.i.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, gVar) == null) {
                String l0 = this.f5818e.l0();
                if (g.G) {
                    b.a.p0.a.f1.g.a.d(l0).e().d(1);
                }
                super.i(gVar);
                this.f5818e.t.add(new UbcFlowEvent("na_pms_end_download"));
                b.a.p0.a.u2.a z0 = this.f5818e.z0(gVar);
                b.a.p0.a.e0.d.k("SwanAppPkgDownloadCallback", "main onFileDownloaded: pmsPkgMain=" + gVar.f11776i);
                if (z0 == null) {
                    g gVar2 = this.f5818e;
                    gVar2.n = gVar;
                    gVar2.m.m(gVar);
                    if (this.f5818e.f5816h != null) {
                        this.f5818e.f5816h.onNext(gVar);
                        if (g.G) {
                            String str = this.f5818e.i0() + ": main onFileDownloaded: onCompleted";
                        }
                        this.f5818e.f5816h.onCompleted();
                    }
                    b.a.p0.a.h0.m.c.c().b(gVar, this.f5818e.k0());
                    return;
                }
                this.f5818e.m.l(gVar);
                if (this.f5818e.f5816h != null) {
                    this.f5818e.f5816h.onError(new PkgDownloadError(gVar, z0));
                }
                b.a.p0.a.h0.m.c.c().a(gVar, this.f5818e.k0(), z0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.q.f.b, b.a.p0.q.f.e
        /* renamed from: q */
        public void c(b.a.p0.q.i.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, gVar) == null) {
                String l0 = this.f5818e.l0();
                if (g.G) {
                    b.a.p0.a.f1.g.a.d(l0).e().d(1);
                }
                super.c(gVar);
                b.a.p0.a.e0.d.k("SwanAppPkgDownloadCallback", "main onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.q.f.b, b.a.p0.q.f.e
        /* renamed from: r */
        public void f(b.a.p0.q.i.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, gVar) == null) {
                String l0 = this.f5818e.l0();
                if (g.G) {
                    b.a.p0.a.f1.g.a.d(l0).e().d(1);
                }
                super.f(gVar);
                if (g.G) {
                    String str = this.f5818e.i0() + ": main onDownloading";
                }
                this.f5818e.D0(gVar);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.q.f.b, b.a.p0.q.f.e
        /* renamed from: s */
        public b.a.p0.q.i.b h(b.a.p0.q.i.g gVar, File file, long j, ReadableByteChannel readableByteChannel) throws IOException {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{gVar, file, Long.valueOf(j), readableByteChannel})) == null) {
                String l0 = this.f5818e.l0();
                if (g.G) {
                    b.a.p0.a.f1.g.a.d(l0).f(gVar.toString()).d(1);
                }
                C0236a c0236a = new C0236a(this);
                Bundle bundle = new Bundle();
                bundle.putLong(CloudStabilityUBCUtils.KEY_LENGTH, j);
                bundle.putFloat("progress_granularity", 0.1f);
                b.a.p0.a.a1.f fVar = new b.a.p0.a.a1.f();
                fVar.v(c0236a);
                fVar.J(bundle);
                fVar.I(new b.a.p0.a.a1.e(gVar, this.f5818e));
                fVar.I(new b.a.p0.a.a1.c(gVar.m, this.f5818e));
                fVar.L(readableByteChannel);
                boolean M = fVar.M();
                fVar.p(c0236a);
                if (g.G) {
                    String str = this.f5818e.i0() + ": onProcessStream: installOk=" + M;
                }
                if (M) {
                    b.a.p0.a.e0.d.k("SwanAppPkgDownloadCallback", "#onProcessStream del: " + file.getAbsolutePath());
                    b.a.p0.w.d.L(file);
                }
                return M ? new b.a.p0.q.i.b(2300, "业务层处理下载流成功") : new b.a.p0.q.i.b(2301, "业务层处理下载流失败");
            }
            return (b.a.p0.q.i.b) invokeCommon.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Collection f5820e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.z2.g1.c f5821f;

        public b(g gVar, Collection collection, b.a.p0.a.z2.g1.c cVar) {
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
            this.f5820e = collection;
            this.f5821f = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                for (Object obj : this.f5820e) {
                    this.f5821f.onCallback(obj);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements b.a.p0.a.z2.g1.c<b.a.p0.a.h0.m.p.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.z2.g1.c f5822e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ g f5823f;

        public c(g gVar, b.a.p0.a.z2.g1.c cVar) {
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
            this.f5823f = gVar;
            this.f5822e = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(b.a.p0.a.h0.m.p.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f5822e.onCallback(aVar);
                g gVar = this.f5823f;
                gVar.h0(gVar.w, aVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements b.a.p0.a.z2.g1.c<b.a.p0.a.h0.m.p.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.u2.a f5824e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f5825f;

        public d(g gVar, b.a.p0.a.u2.a aVar, boolean z) {
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
            this.f5824e = aVar;
            this.f5825f = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(b.a.p0.a.h0.m.p.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.a(this.f5824e, this.f5825f);
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements b.a.p0.a.z2.g1.c<b.a.p0.a.h0.m.p.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PMSAppInfo f5826e;

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
            this.f5826e = pMSAppInfo;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(b.a.p0.a.h0.m.p.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.b(this.f5826e);
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements c.InterfaceC0234c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.q.i.g f5827a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g f5828b;

        public f(g gVar, b.a.p0.q.i.g gVar2) {
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
            this.f5828b = gVar;
            this.f5827a = gVar2;
        }

        @Override // b.a.p0.a.h0.m.c.InterfaceC0234c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                g gVar = this.f5828b;
                b.a.p0.q.i.g gVar2 = this.f5827a;
                gVar.n = gVar2;
                gVar.m.m(gVar2);
                if (this.f5828b.f5816h != null) {
                    this.f5828b.f5816h.onNext(this.f5827a);
                    this.f5828b.f5816h.onCompleted();
                }
            }
        }

        @Override // b.a.p0.a.h0.m.c.InterfaceC0234c
        public void b(PMSDownloadType pMSDownloadType, b.a.p0.a.u2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, aVar) == null) {
                this.f5828b.m.l(this.f5827a);
                if (this.f5828b.f5816h != null) {
                    this.f5828b.f5816h.onError(new PkgDownloadError(this.f5827a, aVar));
                }
            }
        }
    }

    /* renamed from: b.a.p0.a.h0.m.g$g  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0237g implements c.InterfaceC0234c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.q.i.h f5829a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g f5830b;

        public C0237g(g gVar, b.a.p0.q.i.h hVar) {
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
            this.f5830b = gVar;
            this.f5829a = hVar;
        }

        @Override // b.a.p0.a.h0.m.c.InterfaceC0234c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                g gVar = this.f5830b;
                if (gVar.o == null) {
                    gVar.o = new ArrayList();
                }
                b.a.p0.q.i.h hVar = this.f5829a;
                g gVar2 = this.f5830b;
                hVar.o = gVar2.s;
                gVar2.o.add(hVar);
                this.f5830b.m.m(this.f5829a);
                if (this.f5830b.f5817i != null) {
                    this.f5830b.f5817i.onNext(this.f5829a);
                    if (this.f5830b.m.i()) {
                        return;
                    }
                    this.f5830b.f5817i.onCompleted();
                }
            }
        }

        @Override // b.a.p0.a.h0.m.c.InterfaceC0234c
        public void b(PMSDownloadType pMSDownloadType, b.a.p0.a.u2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, aVar) == null) {
                this.f5830b.m.l(this.f5829a);
                if (this.f5830b.f5817i != null) {
                    this.f5830b.f5817i.onError(new PkgDownloadError(this.f5829a, aVar));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class h implements c.InterfaceC0234c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.q.i.e f5831a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g f5832b;

        public h(g gVar, b.a.p0.q.i.e eVar) {
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
            this.f5832b = gVar;
            this.f5831a = eVar;
        }

        @Override // b.a.p0.a.h0.m.c.InterfaceC0234c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                g gVar = this.f5832b;
                b.a.p0.q.i.e eVar = this.f5831a;
                gVar.p = eVar;
                gVar.m.m(eVar);
                if (this.f5832b.j != null) {
                    this.f5832b.j.onNext(this.f5831a);
                    this.f5832b.j.onCompleted();
                }
            }
        }

        @Override // b.a.p0.a.h0.m.c.InterfaceC0234c
        public void b(PMSDownloadType pMSDownloadType, b.a.p0.a.u2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, aVar) == null) {
                this.f5832b.m.l(this.f5831a);
                if (this.f5832b.j != null) {
                    this.f5832b.j.onError(new PkgDownloadError(this.f5831a, aVar));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class i implements c.InterfaceC0234c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.q.i.c f5833a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g f5834b;

        public i(g gVar, b.a.p0.q.i.c cVar) {
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
            this.f5834b = gVar;
            this.f5833a = cVar;
        }

        @Override // b.a.p0.a.h0.m.c.InterfaceC0234c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                b.a.p0.a.e0.d.k("SwanAppPkgDownloadCallback", "Extension Repeat: onSuccess ：" + pMSDownloadType);
                g gVar = this.f5834b;
                b.a.p0.q.i.c cVar = this.f5833a;
                gVar.q = cVar;
                gVar.m.m(cVar);
                this.f5834b.q0(this.f5833a);
            }
        }

        @Override // b.a.p0.a.h0.m.c.InterfaceC0234c
        public void b(PMSDownloadType pMSDownloadType, b.a.p0.a.u2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, aVar) == null) {
                b.a.p0.a.e0.d.k("SwanAppPkgDownloadCallback", "Extension Repeat: onError ：" + pMSDownloadType + ":" + aVar.toString());
                this.f5834b.m.l(this.f5833a);
                this.f5834b.q0(this.f5833a);
            }
        }
    }

    /* loaded from: classes.dex */
    public class j extends h.j<b.a.p0.q.i.f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ g f5835i;

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
            this.f5835i = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.e
        /* renamed from: g */
        public void onNext(b.a.p0.q.i.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                b.a.p0.a.e0.d.k("SwanAppPkgDownloadCallback", this.f5835i.k0() + " : 单个包下载、业务层处理完成：" + fVar.f11776i);
            }
        }

        @Override // h.e
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                b.a.p0.a.e0.d.k("SwanAppPkgDownloadCallback", this.f5835i.k0() + " : 包下载onCompleted");
                this.f5835i.v0();
            }
        }

        @Override // h.e
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                b.a.p0.a.e0.d.l("SwanAppPkgDownloadCallback", this.f5835i.k0() + " : 包下载OnError", th);
                this.f5835i.w0(th);
            }
        }
    }

    /* loaded from: classes.dex */
    public class k implements d.a<b.a.p0.q.i.g> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f5836e;

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
            this.f5836e = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.d.a, h.n.b
        public void call(h.j<? super b.a.p0.q.i.g> jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
                this.f5836e.f5816h = jVar;
            }
        }
    }

    /* loaded from: classes.dex */
    public class l implements d.a<b.a.p0.q.i.h> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f5837e;

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
            this.f5837e = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.d.a, h.n.b
        public void call(h.j<? super b.a.p0.q.i.h> jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
                this.f5837e.f5817i = jVar;
            }
        }
    }

    /* loaded from: classes.dex */
    public class m implements d.a<b.a.p0.q.i.e> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f5838e;

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
            this.f5838e = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.d.a, h.n.b
        public void call(h.j<? super b.a.p0.q.i.e> jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
                this.f5838e.j = jVar;
            }
        }
    }

    /* loaded from: classes.dex */
    public class n implements d.a<b.a.p0.q.i.c> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f5839e;

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
            this.f5839e = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.d.a, h.n.b
        public void call(h.j<? super b.a.p0.q.i.c> jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
                this.f5839e.k = jVar;
            }
        }
    }

    /* loaded from: classes.dex */
    public class o implements d.a<b.a.p0.q.i.i> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f5840e;

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
            this.f5840e = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.d.a, h.n.b
        public void call(h.j<? super b.a.p0.q.i.i> jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
                this.f5840e.l = jVar;
            }
        }
    }

    /* loaded from: classes.dex */
    public class p extends b.a.p0.a.h0.m.n<g> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ g f5841g;

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
                    super((b.a.p0.a.h0.m.k) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5841g = gVar;
        }

        @Override // b.a.p0.a.h0.m.n, b.a.p0.q.f.b
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f5841g.j0() : invokeV.intValue;
        }

        @Override // b.a.p0.a.h0.m.n
        public String l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f5841g.s : (String) invokeV.objValue;
        }

        @Override // b.a.p0.a.h0.m.n
        public void p(@NonNull b.a.p0.q.i.h hVar, @Nullable b.a.p0.a.u2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, hVar, aVar) == null) {
                super.p(hVar, aVar);
                b.a.p0.a.e0.d.k("SwanAppPkgDownloadCallback", "sub onFileDownloaded: " + hVar.f11776i);
                g gVar = this.f5841g;
                if (gVar.o == null) {
                    gVar.o = new ArrayList();
                }
                g gVar2 = this.f5841g;
                hVar.o = gVar2.s;
                if (aVar == null) {
                    gVar2.o.add(hVar);
                    this.f5841g.m.m(hVar);
                    b.a.p0.a.h0.m.c.c().b(hVar, this.f5841g.k0());
                } else {
                    gVar2.m.l(hVar);
                    b.a.p0.a.h0.m.c.c().a(hVar, this.f5841g.k0(), aVar);
                }
                if (this.f5841g.f5817i != null) {
                    this.f5841g.f5817i.onNext(hVar);
                    if (this.f5841g.m.i()) {
                        return;
                    }
                    this.f5841g.f5817i.onCompleted();
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.q.f.b, b.a.p0.q.f.e
        /* renamed from: q */
        public void e(b.a.p0.q.i.h hVar, b.a.p0.q.i.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, hVar, bVar) == null) {
                super.q(hVar, bVar);
                b.a.p0.a.e0.d.k("SwanAppPkgDownloadCallback", "sub onDownloadError：" + bVar.toString());
                this.f5841g.m.l(hVar);
                b.a.p0.a.u2.a aVar = new b.a.p0.a.u2.a();
                aVar.k(12L);
                aVar.i(bVar.f11762a);
                aVar.d("分包下载失败");
                aVar.f(bVar.toString());
                if (this.f5841g.f5817i != null) {
                    this.f5841g.f5817i.onError(new PkgDownloadError(hVar, aVar));
                }
                b.a.p0.a.h0.m.c.c().a(hVar, this.f5841g.k0(), aVar);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.h0.m.n, b.a.p0.q.f.b, b.a.p0.q.f.e
        /* renamed from: s */
        public void c(b.a.p0.q.i.h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, hVar) == null) {
                super.c(hVar);
                b.a.p0.a.e0.d.k("SwanAppPkgDownloadCallback", "sub onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.q.f.b, b.a.p0.q.f.e
        /* renamed from: u */
        public void f(b.a.p0.q.i.h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, hVar) == null) {
                super.f(hVar);
                this.f5841g.E0(hVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class q extends b.a.p0.a.h0.m.l<g> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ g f5842f;

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
                    super((b.a.p0.a.h0.m.k) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5842f = gVar;
        }

        @Override // b.a.p0.q.f.b
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f5842f.j0() : invokeV.intValue;
        }

        @Override // b.a.p0.a.h0.m.l
        public PMSDownloadType o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f5842f.k0() : (PMSDownloadType) invokeV.objValue;
        }

        @Override // b.a.p0.a.h0.m.l
        public void r(@NonNull b.a.p0.q.i.i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, iVar) == null) {
                this.f5842f.m.m(iVar);
                if (this.f5842f.l != null) {
                    this.f5842f.l.onNext(iVar);
                    if (this.f5842f.m.c()) {
                        return;
                    }
                    this.f5842f.l.onCompleted();
                }
            }
        }

        @Override // b.a.p0.a.h0.m.l
        public void u(b.a.p0.q.i.i iVar, b.a.p0.a.u2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, iVar, aVar) == null) {
                b.a.p0.a.e0.d.k("SwanAppPkgDownloadCallback", "dependent onDownloadOrUnzipFail：" + aVar);
                this.f5842f.m.l(iVar);
                if (this.f5842f.l != null) {
                    this.f5842f.l.onError(new PkgDownloadError(iVar, aVar));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.h0.m.l, b.a.p0.q.f.b, b.a.p0.q.f.e
        /* renamed from: v */
        public void c(b.a.p0.q.i.i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, iVar) == null) {
                super.c(iVar);
                b.a.p0.a.e0.d.k("SwanAppPkgDownloadCallback", "dependent onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.h0.m.l, b.a.p0.q.f.b, b.a.p0.q.f.e
        /* renamed from: w */
        public void f(b.a.p0.q.i.i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, iVar) == null) {
                super.f(iVar);
                if (g.G) {
                    String str = this.f5842f.i0() + ": dependent onDownloading";
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class r extends b.a.p0.q.f.b<b.a.p0.q.i.e> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f5843e;

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
            this.f5843e = gVar;
        }

        @Override // b.a.p0.q.f.b
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f5843e.j0() : invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.q.f.e
        /* renamed from: l */
        public String d(b.a.p0.q.i.e eVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, eVar)) == null) {
                int i2 = eVar.f11775h;
                if (i2 == 0) {
                    return b.a.p0.a.h0.m.u.a.h();
                }
                if (i2 == 1) {
                    return b.a.p0.a.h0.m.u.a.e();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        @Override // b.a.p0.q.f.g
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) ? this.f5843e.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.q.f.b, b.a.p0.q.f.e
        /* renamed from: o */
        public void e(b.a.p0.q.i.e eVar, b.a.p0.q.i.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar, bVar) == null) {
                super.e(eVar, bVar);
                b.a.p0.a.e0.d.k("SwanAppPkgDownloadCallback", "framework onDownloadError：" + bVar.toString());
                this.f5843e.m.l(eVar);
                b.a.p0.a.u2.a aVar = new b.a.p0.a.u2.a();
                aVar.k(13L);
                aVar.i(bVar.f11762a);
                aVar.d("Framework包下载失败");
                aVar.f(bVar.toString());
                if (this.f5843e.j != null) {
                    this.f5843e.j.onError(new PkgDownloadError(eVar, aVar));
                }
                b.a.p0.a.h0.m.c.c().a(eVar, this.f5843e.k0(), aVar);
                b.a.p0.w.d.k(eVar.f11768a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.q.f.b, b.a.p0.q.f.e
        /* renamed from: p */
        public void i(b.a.p0.q.i.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, eVar) == null) {
                super.i(eVar);
                b.a.p0.a.e0.d.k("SwanAppPkgDownloadCallback", "framework onFileDownloaded: " + eVar.f11776i);
                b.a.p0.a.u2.a y0 = this.f5843e.y0(eVar);
                if (y0 == null) {
                    g gVar = this.f5843e;
                    gVar.p = eVar;
                    gVar.m.m(eVar);
                    if (this.f5843e.j != null) {
                        this.f5843e.j.onNext(eVar);
                        this.f5843e.j.onCompleted();
                    }
                    b.a.p0.a.h0.m.c.c().b(eVar, this.f5843e.k0());
                    return;
                }
                this.f5843e.m.l(eVar);
                if (this.f5843e.j != null) {
                    this.f5843e.j.onError(new PkgDownloadError(eVar, y0));
                }
                b.a.p0.a.h0.m.c.c().a(eVar, this.f5843e.k0(), y0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.q.f.b, b.a.p0.q.f.e
        /* renamed from: q */
        public void c(b.a.p0.q.i.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, eVar) == null) {
                super.c(eVar);
                b.a.p0.a.e0.d.k("SwanAppPkgDownloadCallback", "framework onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.q.f.b, b.a.p0.q.f.e
        /* renamed from: r */
        public void f(b.a.p0.q.i.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, eVar) == null) {
                super.f(eVar);
                if (g.G) {
                    String str = this.f5843e.i0() + ": framework onDownloading";
                }
                this.f5843e.C0(eVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class s extends b.a.p0.q.f.b<b.a.p0.q.i.c> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f5844e;

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
            this.f5844e = gVar;
        }

        @Override // b.a.p0.q.f.b
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f5844e.j0() : invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.q.f.e
        /* renamed from: l */
        public String d(b.a.p0.q.i.c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, cVar)) == null) {
                int i2 = cVar.f11775h;
                if (i2 == 0) {
                    return b.a.p0.a.h0.m.u.a.d();
                }
                if (i2 == 1) {
                    return b.a.p0.a.h0.m.u.a.f();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        @Override // b.a.p0.q.f.g
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) ? this.f5844e.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.q.f.b, b.a.p0.q.f.e
        /* renamed from: o */
        public void e(b.a.p0.q.i.c cVar, b.a.p0.q.i.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar, bVar) == null) {
                super.e(cVar, bVar);
                b.a.p0.a.e0.d.k("SwanAppPkgDownloadCallback", "extension onDownloadError：" + bVar.toString());
                this.f5844e.m.l(cVar);
                b.a.p0.a.u2.a aVar = new b.a.p0.a.u2.a();
                aVar.k(14L);
                aVar.i(bVar.f11762a);
                aVar.d("Extension下载失败");
                aVar.f(bVar.toString());
                if (g.G) {
                    aVar.toString();
                }
                this.f5844e.q0(cVar);
                b.a.p0.a.h0.m.c.c().a(cVar, this.f5844e.k0(), aVar);
                b.a.p0.w.d.k(cVar.f11768a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.q.f.b, b.a.p0.q.f.e
        /* renamed from: p */
        public void i(b.a.p0.q.i.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, cVar) == null) {
                super.i(cVar);
                b.a.p0.a.e0.d.k("SwanAppPkgDownloadCallback", "extension onFileDownloaded: " + cVar.f11776i);
                b.a.p0.a.u2.a x0 = this.f5844e.x0(cVar);
                if (x0 != null) {
                    if (g.G) {
                        String str = "Extension 业务处理失败：" + cVar.toString();
                    }
                    this.f5844e.m.l(cVar);
                    this.f5844e.q0(cVar);
                    b.a.p0.a.h0.m.c.c().a(cVar, this.f5844e.k0(), x0);
                    return;
                }
                g gVar = this.f5844e;
                gVar.q = cVar;
                gVar.m.m(cVar);
                this.f5844e.q0(cVar);
                b.a.p0.a.h0.m.c.c().b(cVar, this.f5844e.k0());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.q.f.b, b.a.p0.q.f.e
        /* renamed from: q */
        public void c(b.a.p0.q.i.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, cVar) == null) {
                super.c(cVar);
                b.a.p0.a.e0.d.k("SwanAppPkgDownloadCallback", "extension onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.q.f.b, b.a.p0.q.f.e
        /* renamed from: r */
        public void f(b.a.p0.q.i.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, cVar) == null) {
                super.f(cVar);
                if (g.G) {
                    String str = this.f5844e.i0() + ": extension onDownloading";
                }
                this.f5844e.B0(cVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class t implements b.a.p0.q.f.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f5845a;

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
            this.f5845a = gVar;
        }

        @Override // b.a.p0.q.f.h
        public void a(PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSAppInfo) == null) {
                if (g.G) {
                    String str = this.f5845a.i0() + ": onSwanAppReceive: " + pMSAppInfo.toString();
                }
                g gVar = this.f5845a;
                gVar.r = pMSAppInfo;
                if (pMSAppInfo != null) {
                    gVar.o0(pMSAppInfo);
                    b.a.p0.a.w1.h.b.k(this.f5845a.r.pluginInfo, true);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class u implements b.a.p0.a.z2.g1.c<b.a.p0.a.z2.g1.c<PMSAppInfo>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PMSAppInfo f5846e;

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
            this.f5846e = pMSAppInfo;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(b.a.p0.a.z2.g1.c<PMSAppInfo> cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
                cVar.onCallback(this.f5846e);
            }
        }
    }

    /* loaded from: classes.dex */
    public class v implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Collection f5847e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Object f5848f;

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
            this.f5847e = collection;
            this.f5848f = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f5847e.add(this.f5848f);
            }
        }
    }

    /* loaded from: classes.dex */
    public class w implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Collection f5849e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Object f5850f;

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
            this.f5849e = collection;
            this.f5850f = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f5849e.remove(this.f5850f);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1597581767, "Lb/a/p0/a/h0/m/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1597581767, "Lb/a/p0/a/h0/m/g;");
                return;
            }
        }
        G = b.a.p0.a.k.f6863a;
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
        this.f5815g = "";
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

    @Override // b.a.p0.q.f.i
    public b.a.p0.q.f.e<b.a.p0.q.i.h> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.A : (b.a.p0.q.f.e) invokeV.objValue;
    }

    public void A0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            b.a.p0.a.u1.q.a.a(this.s, str, this.t, str2);
            this.t.clear();
        }
    }

    public final void B0(b.a.p0.q.i.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            b.a.p0.a.h0.m.c.c().d(cVar, new i(this, cVar));
        }
    }

    @Override // b.a.p0.q.f.i
    public void C(b.a.p0.q.i.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            b.a.p0.a.e0.d.k("SwanAppPkgDownloadCallback", "onFetchError: error=" + bVar);
            if (bVar != null && bVar.f11762a == 1010) {
                G0();
            }
            this.t.add(new UbcFlowEvent("na_pms_end_req"));
        }
    }

    public final void C0(b.a.p0.q.i.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, eVar) == null) {
            b.a.p0.a.h0.m.c.c().d(eVar, new h(this, eVar));
        }
    }

    @Override // b.a.p0.q.f.i
    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.t.add(new UbcFlowEvent("na_pms_start_req"));
        }
    }

    public final void D0(b.a.p0.q.i.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, gVar) == null) {
            b.a.p0.a.h0.m.c.c().d(gVar, new f(this, gVar));
        }
    }

    @Override // b.a.p0.q.f.i
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.t.add(new UbcFlowEvent("na_pms_end_req"));
        }
    }

    public final void E0(b.a.p0.q.i.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, hVar) == null) {
            b.a.p0.a.h0.m.c.c().d(hVar, new C0237g(this, hVar));
        }
    }

    public b.a.p0.a.u2.a F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            PMSAppInfo pMSAppInfo = this.r;
            if (pMSAppInfo == null) {
                if (this.n == null) {
                    b.a.p0.a.u2.a aVar = new b.a.p0.a.u2.a();
                    aVar.k(10L);
                    aVar.i(2903L);
                    aVar.d("Server未返回主包&AppInfo");
                    return aVar;
                }
                PMSAppInfo u2 = b.a.p0.q.g.a.i().u(this.s);
                if (u2 == null) {
                    b.a.p0.a.u2.a aVar2 = new b.a.p0.a.u2.a();
                    aVar2.k(10L);
                    aVar2.i(2904L);
                    aVar2.d("Server未返回AppInfo数据，本地也没有数据");
                    return aVar2;
                }
                this.r = u2;
                b.a.p0.a.h0.m.u.a.k(u2, this.n);
                this.r.initMaxAgeInfo();
                this.r.updateInstallSrc(J());
                if (b.a.p0.q.g.a.i().b(this.n, this.o, this.p, this.q, this.r)) {
                    return null;
                }
                b.a.p0.a.u2.a aVar3 = new b.a.p0.a.u2.a();
                aVar3.k(10L);
                aVar3.i(2906L);
                aVar3.d("更新DB失败");
                return aVar3;
            }
            b.a.p0.q.i.g gVar = this.n;
            if (gVar != null) {
                b.a.p0.a.h0.m.u.a.k(pMSAppInfo, gVar);
            } else if (b.a.p0.a.h0.m.u.b.f(this.o)) {
                b.a.p0.q.i.h hVar = this.o.get(0);
                this.u = hVar;
                hVar.o = this.s;
                b.a.p0.a.h0.m.u.a.l(this.r, hVar);
            } else {
                PMSAppInfo u3 = b.a.p0.q.g.a.i().u(this.s);
                if (u3 == null) {
                    b.a.p0.a.u2.a aVar4 = new b.a.p0.a.u2.a();
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
            this.r.updateInstallSrc(J());
            if (b.a.p0.q.g.a.i().b(this.n, this.o, this.p, this.q, this.r)) {
                b.a.p0.a.h0.m.u.a.o(this.r);
                return null;
            }
            b.a.p0.a.u2.a aVar5 = new b.a.p0.a.u2.a();
            aVar5.k(10L);
            aVar5.i(2906L);
            aVar5.d("更新DB失败");
            return aVar5;
        }
        return (b.a.p0.a.u2.a) invokeV.objValue;
    }

    @Override // b.a.p0.q.f.i
    public void G(b.a.p0.q.p.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, gVar) == null) {
            super.G(gVar);
            this.v = System.currentTimeMillis();
            if (G) {
                String str = "mStartDownload=" + this.v;
            }
            if (gVar == null) {
                return;
            }
            if (G) {
                String str2 = i0() + ": onPrepareDownload: countSet=" + gVar.n();
            }
            this.t.add(new UbcFlowEvent("na_pms_start_download"));
            this.m = gVar;
            if (gVar.k()) {
                return;
            }
            n0();
        }
    }

    public final void G0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            PMSAppInfo u2 = b.a.p0.q.g.a.i().u(this.s);
            b.a.p0.a.e0.d.k("SwanAppPkgDownloadCallback", "updateMainMaxAgeTime: createTime=" + u2.createTime + " lastLaunchTime=" + u2.getLastLaunchTime() + " maxAge=" + u2.maxAge);
            if (u2 != null) {
                u2.initMaxAgeInfo();
                u2.updateInstallSrc(J());
                b.a.p0.q.i.g gVar = this.n;
                if (gVar != null) {
                    gVar.f11770c = u2.createTime;
                }
                PMSAppInfo pMSAppInfo = this.r;
                if (pMSAppInfo != null) {
                    pMSAppInfo.createTime = u2.createTime;
                    pMSAppInfo.updateInstallSrc(J());
                }
                b.a.p0.q.g.a.i().l(u2);
            }
        }
    }

    public g e0(b.a.p0.a.z2.g1.c<PMSAppInfo> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, cVar)) == null) {
            f0(this.x, cVar);
            return this;
        }
        return (g) invokeL.objValue;
    }

    public final synchronized <CallbackT> g f0(Collection<CallbackT> collection, CallbackT callbackt) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, collection, callbackt)) == null) {
            synchronized (this) {
                if (collection != null && callbackt != null) {
                    this.y.a(new v(this, collection, callbackt));
                }
            }
            return this;
        }
        return (g) invokeLL.objValue;
    }

    public synchronized g g0(b.a.p0.a.h0.m.p.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, aVar)) == null) {
            synchronized (this) {
                f0(this.w, aVar);
            }
            return this;
        }
        return (g) invokeL.objValue;
    }

    public final synchronized <CallbackT> g h0(Collection<CallbackT> collection, CallbackT callbackt) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, collection, callbackt)) == null) {
            synchronized (this) {
                if (collection != null && callbackt != null) {
                    this.y.a(new w(this, collection, callbackt));
                }
            }
            return this;
        }
        return (g) invokeLL.objValue;
    }

    public String i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (TextUtils.isEmpty(this.f5815g)) {
                this.f5815g = getClass().toString();
            }
            return this.f5815g;
        }
        return (String) invokeV.objValue;
    }

    public int j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return 100;
        }
        return invokeV.intValue;
    }

    public abstract PMSDownloadType k0();

    public final String l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? b.a.p0.q.f.j.b(this, "get_launch_id").getString("launch_id", "") : (String) invokeV.objValue;
    }

    public void m0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            if (i2 == 1013) {
                b.a.p0.q.g.a.i().z(this.s, i2);
            } else {
                b.a.p0.q.g.a.i().z(this.s, 0);
            }
        }
    }

    public final void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            ArrayList arrayList = new ArrayList();
            if (this.m.f()) {
                arrayList.add(h.d.a(new k(this)));
            }
            if (this.m.h()) {
                arrayList.add(h.d.a(new l(this)));
            }
            if (this.m.e()) {
                arrayList.add(h.d.a(new m(this)));
            }
            if (this.m.d()) {
                arrayList.add(h.d.a(new n(this)));
            }
            if (this.m.b()) {
                arrayList.add(h.d.a(new o(this)));
            }
            if (arrayList.isEmpty()) {
                return;
            }
            h.d.i(arrayList).u(this.F);
        }
    }

    public g o0(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, pMSAppInfo)) == null) {
            p0(this.x, new u(this, pMSAppInfo));
            return this;
        }
        return (g) invokeL.objValue;
    }

    @Override // b.a.p0.q.f.i
    public b.a.p0.q.f.h p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.E : (b.a.p0.q.f.h) invokeV.objValue;
    }

    public final synchronized <CallbackT> g p0(@NonNull Collection<CallbackT> collection, @NonNull b.a.p0.a.z2.g1.c<CallbackT> cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048600, this, collection, cVar)) == null) {
            synchronized (this) {
                this.y.a(new b(this, collection, cVar));
            }
            return this;
        }
        return (g) invokeLL.objValue;
    }

    @Override // b.a.p0.q.f.i
    public b.a.p0.q.f.e<b.a.p0.q.i.i> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.B : (b.a.p0.q.f.e) invokeV.objValue;
    }

    public final void q0(b.a.p0.q.i.c cVar) {
        h.j<? super b.a.p0.q.i.c> jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048602, this, cVar) == null) || (jVar = this.k) == null) {
            return;
        }
        jVar.onNext(cVar);
        this.k.onCompleted();
    }

    @Override // b.a.p0.q.f.i
    public b.a.p0.q.f.e<b.a.p0.q.i.c> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.D : (b.a.p0.q.f.e) invokeV.objValue;
    }

    public g r0(@NonNull b.a.p0.a.z2.g1.c<b.a.p0.a.h0.m.p.a> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, cVar)) == null) {
            p0(this.w, new c(this, cVar));
            return this;
        }
        return (g) invokeL.objValue;
    }

    @Override // b.a.p0.q.f.i
    public b.a.p0.q.f.e<b.a.p0.q.i.e> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.C : (b.a.p0.q.f.e) invokeV.objValue;
    }

    public void s0(PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, pMSAppInfo) == null) {
            r0(new e(this, pMSAppInfo));
        }
    }

    public void t0(boolean z, b.a.p0.a.u2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048607, this, z, aVar) == null) {
            r0(new d(this, aVar, z));
        }
    }

    @Override // b.a.p0.q.f.i
    public b.a.p0.q.f.e<b.a.p0.q.i.g> u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.z : (b.a.p0.q.f.e) invokeV.objValue;
    }

    public void u0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048609, this) == null) || this.r == null) {
            return;
        }
        PMSAppInfo u2 = b.a.p0.q.g.a.i().u(this.s);
        if (u2 == null) {
            b.a.p0.a.e0.d.k("SwanAppPkgDownloadCallback", "Server未返回包数据，本地也没查到");
            return;
        }
        this.r.appId = this.s;
        u2.updateInstallSrc(J());
        this.r.copyLocalAppInfoData(u2);
        this.r.initMaxAgeInfo();
        if (b.a.p0.q.g.a.i().l(this.r)) {
            b.a.p0.a.h0.m.u.a.o(this.r);
        }
    }

    public void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            long currentTimeMillis = System.currentTimeMillis() - this.v;
            b.a.p0.a.e0.d.i("SwanAppPkgDownloadCallback", "pms download time : " + currentTimeMillis);
        }
    }

    public abstract void w0(Throwable th);

    public b.a.p0.a.u2.a x0(b.a.p0.q.i.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, cVar)) == null) {
            b.a.p0.a.p0.g.a aVar = new b.a.p0.a.p0.g.a();
            aVar.f7706b = cVar.f11776i;
            aVar.f7705a = cVar.j;
            aVar.f7707c = cVar.f11768a;
            aVar.f7708d = cVar.m;
            if (b.a.p0.a.p0.b.b(cVar.f11775h, aVar) == null) {
                return null;
            }
            b.a.p0.a.u2.a aVar2 = new b.a.p0.a.u2.a();
            aVar2.k(14L);
            aVar2.b(2908L);
            aVar2.d("Extension包更新失败");
            return aVar2;
        }
        return (b.a.p0.a.u2.a) invokeL.objValue;
    }

    public b.a.p0.a.u2.a y0(b.a.p0.q.i.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, eVar)) == null) {
            if (G) {
                String str = "onFrameworkPkgDownload framework = " + eVar;
            }
            a.b c2 = b.a.p0.a.q2.f.a.c(eVar, eVar.f11775h);
            if (!TextUtils.isEmpty(eVar.f11768a)) {
                b.a.p0.a.e0.d.k("SwanAppPkgDownloadCallback", "#onFrameworkPkgDownload del: " + eVar.f11768a);
                b.a.p0.w.d.k(eVar.f11768a);
            }
            if (c2.c()) {
                return null;
            }
            b.a.p0.a.u2.a aVar = new b.a.p0.a.u2.a();
            aVar.k(13L);
            aVar.b(2907L);
            aVar.d("Core包更新失败");
            return aVar;
        }
        return (b.a.p0.a.u2.a) invokeL.objValue;
    }

    public b.a.p0.a.u2.a z0(b.a.p0.q.i.g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, gVar)) == null) {
            if (gVar == null) {
                b.a.p0.a.u2.a aVar = new b.a.p0.a.u2.a();
                aVar.k(11L);
                aVar.i(2310L);
                aVar.f("pkg info is empty");
                b.a.p0.a.u2.e.a().f(aVar);
                return aVar;
            }
            return null;
        }
        return (b.a.p0.a.u2.a) invokeL.objValue;
    }
}
