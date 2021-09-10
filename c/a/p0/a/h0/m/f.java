package c.a.p0.a.h0.m;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.a2.i;
import c.a.p0.a.h0.m.c;
import c.a.p0.a.m2.f.a;
import c.a.p0.a.v2.y0;
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
public abstract class f extends c.a.p0.a.h0.m.j {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean E;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.p0.n.f.c<c.a.p0.n.h.d> A;
    public c.a.p0.n.f.c<c.a.p0.n.h.b> B;
    public c.a.p0.n.f.f C;
    public i.j<c.a.p0.n.h.e> D;

    /* renamed from: g  reason: collision with root package name */
    public String f6185g;

    /* renamed from: h  reason: collision with root package name */
    public i.j<? super c.a.p0.n.h.f> f6186h;

    /* renamed from: i  reason: collision with root package name */
    public i.j<? super c.a.p0.n.h.g> f6187i;

    /* renamed from: j  reason: collision with root package name */
    public i.j<? super c.a.p0.n.h.d> f6188j;
    public i.j<? super c.a.p0.n.h.b> k;
    public c.a.p0.n.o.f l;
    public c.a.p0.n.h.f m;
    public List<c.a.p0.n.h.g> n;
    public c.a.p0.n.h.d o;
    public c.a.p0.n.h.b p;
    public PMSAppInfo q;
    public String r;
    public List<UbcFlowEvent> s;
    public c.a.p0.n.h.g t;
    public long u;
    public final Set<c.a.p0.a.h0.m.m.a> v;
    public final Set<c.a.p0.a.v2.e1.b<PMSAppInfo>> w;
    public final y0 x;
    public c.a.p0.n.f.c<c.a.p0.n.h.f> y;
    public c.a.p0.n.f.c<c.a.p0.n.h.g> z;

    /* loaded from: classes.dex */
    public class a extends c.a.p0.n.f.b<c.a.p0.n.h.f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f6189e;

        /* renamed from: c.a.p0.a.h0.m.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0230a implements c.a.p0.a.v2.e1.b<i.a> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f6190e;

            public C0230a(a aVar) {
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
                this.f6190e = aVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.p0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(i.a aVar) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) && "installer_on_pump_finish".equals(aVar.f4565f)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("performance_ubc_event_id", "670");
                    bundle.putString("performance_ubc_extra_key_for_event", "na_stream_bump_end");
                    c.a.p0.n.f.h.a(this.f6190e.f6189e, bundle, "event_performance_ubc");
                }
            }
        }

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
            this.f6189e = fVar;
        }

        @Override // c.a.p0.n.f.b
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f6189e.g0() : invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.n.f.c
        /* renamed from: l */
        public String d(c.a.p0.n.h.f fVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, fVar)) == null) {
                int i2 = fVar.f11886h;
                if (i2 == 0) {
                    return c.a.p0.a.h0.m.r.a.g();
                }
                if (i2 == 1) {
                    return c.a.p0.a.h0.m.r.a.i();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        @Override // c.a.p0.n.f.e
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle, set)) == null) ? this.f6189e.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.n.f.b, c.a.p0.n.f.c
        /* renamed from: o */
        public void e(c.a.p0.n.h.f fVar, c.a.p0.n.h.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048585, this, fVar, aVar) == null) {
                super.e(fVar, aVar);
                c.a.p0.a.e0.d.h("SwanAppPkgDownloadCallback", "onDownloadError：" + aVar.toString());
                this.f6189e.l.j(fVar);
                c.a.p0.a.q2.a aVar2 = new c.a.p0.a.q2.a();
                aVar2.j(11L);
                aVar2.h(aVar.f11875a);
                aVar2.c("主包下载失败");
                aVar2.e(aVar.toString());
                if (this.f6189e.f6186h != null) {
                    this.f6189e.f6186h.onError(new PkgDownloadError(fVar, aVar2));
                }
                c.a.p0.a.h0.m.c.c().a(fVar, this.f6189e.h0(), aVar2);
                c.a.p0.t.d.j(fVar.f11879a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.n.f.b, c.a.p0.n.f.c
        /* renamed from: p */
        public void i(c.a.p0.n.h.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, fVar) == null) {
                String i0 = this.f6189e.i0();
                if (f.E) {
                    c.a.p0.a.f1.g.a.d(i0).e().d(1);
                }
                super.i(fVar);
                this.f6189e.s.add(new UbcFlowEvent("na_pms_end_download"));
                c.a.p0.a.q2.a w0 = this.f6189e.w0(fVar);
                c.a.p0.a.e0.d.h("SwanAppPkgDownloadCallback", "main onFileDownloaded: pmsPkgMain=" + fVar.f11887i);
                if (w0 == null) {
                    f fVar2 = this.f6189e;
                    fVar2.m = fVar;
                    fVar2.l.k(fVar);
                    if (this.f6189e.f6186h != null) {
                        this.f6189e.f6186h.onNext(fVar);
                        if (f.E) {
                            String str = this.f6189e.f0() + ": main onFileDownloaded: onCompleted";
                        }
                        this.f6189e.f6186h.onCompleted();
                    }
                    c.a.p0.a.h0.m.c.c().b(fVar, this.f6189e.h0());
                    return;
                }
                this.f6189e.l.j(fVar);
                if (this.f6189e.f6186h != null) {
                    this.f6189e.f6186h.onError(new PkgDownloadError(fVar, w0));
                }
                c.a.p0.a.h0.m.c.c().a(fVar, this.f6189e.h0(), w0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.n.f.b, c.a.p0.n.f.c
        /* renamed from: q */
        public void c(c.a.p0.n.h.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, fVar) == null) {
                String i0 = this.f6189e.i0();
                if (f.E) {
                    c.a.p0.a.f1.g.a.d(i0).e().d(1);
                }
                super.c(fVar);
                c.a.p0.a.e0.d.h("SwanAppPkgDownloadCallback", "main onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.n.f.b, c.a.p0.n.f.c
        /* renamed from: r */
        public void f(c.a.p0.n.h.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, fVar) == null) {
                String i0 = this.f6189e.i0();
                if (f.E) {
                    c.a.p0.a.f1.g.a.d(i0).e().d(1);
                }
                super.f(fVar);
                if (f.E) {
                    String str = this.f6189e.f0() + ": main onDownloading";
                }
                this.f6189e.A0(fVar);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.n.f.b, c.a.p0.n.f.c
        /* renamed from: s */
        public c.a.p0.n.h.a h(c.a.p0.n.h.f fVar, File file, long j2, ReadableByteChannel readableByteChannel) throws IOException {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{fVar, file, Long.valueOf(j2), readableByteChannel})) == null) {
                String i0 = this.f6189e.i0();
                if (f.E) {
                    c.a.p0.a.f1.g.a.d(i0).f(fVar.toString()).d(1);
                }
                C0230a c0230a = new C0230a(this);
                Bundle bundle = new Bundle();
                bundle.putLong(CloudStabilityUBCUtils.KEY_LENGTH, j2);
                bundle.putFloat("progress_granularity", 0.1f);
                c.a.p0.a.a1.g gVar = new c.a.p0.a.a1.g();
                gVar.v(c0230a);
                gVar.g(bundle);
                gVar.f(new c.a.p0.a.a1.f(fVar, this.f6189e));
                gVar.f(new c.a.p0.a.a1.d(fVar.m, this.f6189e));
                gVar.i(readableByteChannel);
                boolean j3 = gVar.j();
                gVar.p(c0230a);
                if (f.E) {
                    String str = this.f6189e.f0() + ": onProcessStream: installOk=" + j3;
                }
                if (j3) {
                    c.a.p0.a.e0.d.h("SwanAppPkgDownloadCallback", "#onProcessStream del: " + file.getAbsolutePath());
                    c.a.p0.t.d.K(file);
                }
                return j3 ? new c.a.p0.n.h.a(2300, "业务层处理下载流成功") : new c.a.p0.n.h.a(2301, "业务层处理下载流失败");
            }
            return (c.a.p0.n.h.a) invokeCommon.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.a.p0.a.v2.e1.b<c.a.p0.a.h0.m.m.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.v2.e1.b f6191e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f6192f;

        public b(f fVar, c.a.p0.a.v2.e1.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6192f = fVar;
            this.f6191e = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(c.a.p0.a.h0.m.m.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f6191e.onCallback(aVar);
                f fVar = this.f6192f;
                fVar.e0(fVar.v, aVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements c.a.p0.a.v2.e1.b<c.a.p0.a.h0.m.m.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.q2.a f6193e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f6194f;

        public c(f fVar, c.a.p0.a.q2.a aVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, aVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6193e = aVar;
            this.f6194f = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(c.a.p0.a.h0.m.m.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.a(this.f6193e, this.f6194f);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements c.a.p0.a.v2.e1.b<c.a.p0.a.h0.m.m.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PMSAppInfo f6195e;

        public d(f fVar, PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, pMSAppInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6195e = pMSAppInfo;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(c.a.p0.a.h0.m.m.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.b(this.f6195e);
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements c.InterfaceC0228c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.n.h.f f6196a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f6197b;

        public e(f fVar, c.a.p0.n.h.f fVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, fVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6197b = fVar;
            this.f6196a = fVar2;
        }

        @Override // c.a.p0.a.h0.m.c.InterfaceC0228c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                f fVar = this.f6197b;
                c.a.p0.n.h.f fVar2 = this.f6196a;
                fVar.m = fVar2;
                fVar.l.k(fVar2);
                if (this.f6197b.f6186h != null) {
                    this.f6197b.f6186h.onNext(this.f6196a);
                    this.f6197b.f6186h.onCompleted();
                }
            }
        }

        @Override // c.a.p0.a.h0.m.c.InterfaceC0228c
        public void b(PMSDownloadType pMSDownloadType, c.a.p0.a.q2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, aVar) == null) {
                this.f6197b.l.j(this.f6196a);
                if (this.f6197b.f6186h != null) {
                    this.f6197b.f6186h.onError(new PkgDownloadError(this.f6196a, aVar));
                }
            }
        }
    }

    /* renamed from: c.a.p0.a.h0.m.f$f  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0231f implements c.InterfaceC0228c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.n.h.g f6198a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f6199b;

        public C0231f(f fVar, c.a.p0.n.h.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6199b = fVar;
            this.f6198a = gVar;
        }

        @Override // c.a.p0.a.h0.m.c.InterfaceC0228c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                f fVar = this.f6199b;
                if (fVar.n == null) {
                    fVar.n = new ArrayList();
                }
                c.a.p0.n.h.g gVar = this.f6198a;
                f fVar2 = this.f6199b;
                gVar.o = fVar2.r;
                fVar2.n.add(gVar);
                this.f6199b.l.k(this.f6198a);
                if (this.f6199b.f6187i != null) {
                    this.f6199b.f6187i.onNext(this.f6198a);
                    if (this.f6199b.l.g()) {
                        return;
                    }
                    this.f6199b.f6187i.onCompleted();
                }
            }
        }

        @Override // c.a.p0.a.h0.m.c.InterfaceC0228c
        public void b(PMSDownloadType pMSDownloadType, c.a.p0.a.q2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, aVar) == null) {
                this.f6199b.l.j(this.f6198a);
                if (this.f6199b.f6187i != null) {
                    this.f6199b.f6187i.onError(new PkgDownloadError(this.f6198a, aVar));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements c.InterfaceC0228c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.n.h.d f6200a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f6201b;

        public g(f fVar, c.a.p0.n.h.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6201b = fVar;
            this.f6200a = dVar;
        }

        @Override // c.a.p0.a.h0.m.c.InterfaceC0228c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                f fVar = this.f6201b;
                c.a.p0.n.h.d dVar = this.f6200a;
                fVar.o = dVar;
                fVar.l.k(dVar);
                if (this.f6201b.f6188j != null) {
                    this.f6201b.f6188j.onNext(this.f6200a);
                    this.f6201b.f6188j.onCompleted();
                }
            }
        }

        @Override // c.a.p0.a.h0.m.c.InterfaceC0228c
        public void b(PMSDownloadType pMSDownloadType, c.a.p0.a.q2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, aVar) == null) {
                this.f6201b.l.j(this.f6200a);
                if (this.f6201b.f6188j != null) {
                    this.f6201b.f6188j.onError(new PkgDownloadError(this.f6200a, aVar));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class h implements c.InterfaceC0228c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.n.h.b f6202a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f6203b;

        public h(f fVar, c.a.p0.n.h.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6203b = fVar;
            this.f6202a = bVar;
        }

        @Override // c.a.p0.a.h0.m.c.InterfaceC0228c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                c.a.p0.a.e0.d.h("SwanAppPkgDownloadCallback", "Extension Repeat: onSuccess ：" + pMSDownloadType);
                f fVar = this.f6203b;
                c.a.p0.n.h.b bVar = this.f6202a;
                fVar.p = bVar;
                fVar.l.k(bVar);
                this.f6203b.n0(this.f6202a);
            }
        }

        @Override // c.a.p0.a.h0.m.c.InterfaceC0228c
        public void b(PMSDownloadType pMSDownloadType, c.a.p0.a.q2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, aVar) == null) {
                c.a.p0.a.e0.d.h("SwanAppPkgDownloadCallback", "Extension Repeat: onError ：" + pMSDownloadType + ":" + aVar.toString());
                this.f6203b.l.j(this.f6202a);
                this.f6203b.n0(this.f6202a);
            }
        }
    }

    /* loaded from: classes.dex */
    public class i extends i.j<c.a.p0.n.h.e> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f6204e;

        public i(f fVar) {
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
            this.f6204e = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // i.e
        /* renamed from: b */
        public void onNext(c.a.p0.n.h.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) {
                c.a.p0.a.e0.d.h("SwanAppPkgDownloadCallback", this.f6204e.h0() + " : 单个包下载、业务层处理完成：" + eVar.f11887i);
            }
        }

        @Override // i.e
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                c.a.p0.a.e0.d.h("SwanAppPkgDownloadCallback", this.f6204e.h0() + " : 包下载onCompleted");
                this.f6204e.s0();
            }
        }

        @Override // i.e
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                c.a.p0.a.e0.d.i("SwanAppPkgDownloadCallback", this.f6204e.h0() + " : 包下载OnError", th);
                this.f6204e.t0(th);
            }
        }
    }

    /* loaded from: classes.dex */
    public class j implements d.a<c.a.p0.n.h.f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f6205e;

        public j(f fVar) {
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
            this.f6205e = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // i.n.b
        /* renamed from: a */
        public void call(i.j<? super c.a.p0.n.h.f> jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
                this.f6205e.f6186h = jVar;
            }
        }
    }

    /* loaded from: classes.dex */
    public class k implements d.a<c.a.p0.n.h.g> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f6206e;

        public k(f fVar) {
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
            this.f6206e = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // i.n.b
        /* renamed from: a */
        public void call(i.j<? super c.a.p0.n.h.g> jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
                this.f6206e.f6187i = jVar;
            }
        }
    }

    /* loaded from: classes.dex */
    public class l implements d.a<c.a.p0.n.h.d> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f6207e;

        public l(f fVar) {
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
            this.f6207e = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // i.n.b
        /* renamed from: a */
        public void call(i.j<? super c.a.p0.n.h.d> jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
                this.f6207e.f6188j = jVar;
            }
        }
    }

    /* loaded from: classes.dex */
    public class m implements d.a<c.a.p0.n.h.b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f6208e;

        public m(f fVar) {
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
            this.f6208e = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // i.n.b
        /* renamed from: a */
        public void call(i.j<? super c.a.p0.n.h.b> jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
                this.f6208e.k = jVar;
            }
        }
    }

    /* loaded from: classes.dex */
    public class n extends c.a.p0.a.h0.m.k<f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ f f6209g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(f fVar, f fVar2) {
            super(fVar2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, fVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((c.a.p0.a.h0.m.j) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6209g = fVar;
        }

        @Override // c.a.p0.a.h0.m.k, c.a.p0.n.f.b
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f6209g.g0() : invokeV.intValue;
        }

        @Override // c.a.p0.a.h0.m.k
        public String l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f6209g.r : (String) invokeV.objValue;
        }

        @Override // c.a.p0.a.h0.m.k
        public void p(@NonNull c.a.p0.n.h.g gVar, @Nullable c.a.p0.a.q2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, gVar, aVar) == null) {
                super.p(gVar, aVar);
                c.a.p0.a.e0.d.h("SwanAppPkgDownloadCallback", "sub onFileDownloaded: " + gVar.f11887i);
                f fVar = this.f6209g;
                if (fVar.n == null) {
                    fVar.n = new ArrayList();
                }
                f fVar2 = this.f6209g;
                gVar.o = fVar2.r;
                if (aVar == null) {
                    fVar2.n.add(gVar);
                    this.f6209g.l.k(gVar);
                    c.a.p0.a.h0.m.c.c().b(gVar, this.f6209g.h0());
                } else {
                    fVar2.l.j(gVar);
                    c.a.p0.a.h0.m.c.c().a(gVar, this.f6209g.h0(), aVar);
                }
                if (this.f6209g.f6187i != null) {
                    this.f6209g.f6187i.onNext(gVar);
                    if (this.f6209g.l.g()) {
                        return;
                    }
                    this.f6209g.f6187i.onCompleted();
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.n.f.b, c.a.p0.n.f.c
        /* renamed from: q */
        public void e(c.a.p0.n.h.g gVar, c.a.p0.n.h.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, gVar, aVar) == null) {
                super.q(gVar, aVar);
                c.a.p0.a.e0.d.h("SwanAppPkgDownloadCallback", "sub onDownloadError：" + aVar.toString());
                this.f6209g.l.j(gVar);
                c.a.p0.a.q2.a aVar2 = new c.a.p0.a.q2.a();
                aVar2.j(12L);
                aVar2.h(aVar.f11875a);
                aVar2.c("分包下载失败");
                aVar2.e(aVar.toString());
                if (this.f6209g.f6187i != null) {
                    this.f6209g.f6187i.onError(new PkgDownloadError(gVar, aVar2));
                }
                c.a.p0.a.h0.m.c.c().a(gVar, this.f6209g.h0(), aVar2);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.h0.m.k, c.a.p0.n.f.b, c.a.p0.n.f.c
        /* renamed from: s */
        public void c(c.a.p0.n.h.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, gVar) == null) {
                super.c(gVar);
                c.a.p0.a.e0.d.h("SwanAppPkgDownloadCallback", "sub onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.n.f.b, c.a.p0.n.f.c
        /* renamed from: u */
        public void f(c.a.p0.n.h.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, gVar) == null) {
                super.f(gVar);
                this.f6209g.B0(gVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class o extends c.a.p0.n.f.b<c.a.p0.n.h.d> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f6210e;

        public o(f fVar) {
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
            this.f6210e = fVar;
        }

        @Override // c.a.p0.n.f.b
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f6210e.g0() : invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.n.f.c
        /* renamed from: l */
        public String d(c.a.p0.n.h.d dVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, dVar)) == null) {
                int i2 = dVar.f11886h;
                if (i2 == 0) {
                    return c.a.p0.a.h0.m.r.a.h();
                }
                if (i2 == 1) {
                    return c.a.p0.a.h0.m.r.a.e();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        @Override // c.a.p0.n.f.e
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) ? this.f6210e.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.n.f.b, c.a.p0.n.f.c
        /* renamed from: o */
        public void e(c.a.p0.n.h.d dVar, c.a.p0.n.h.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dVar, aVar) == null) {
                super.e(dVar, aVar);
                c.a.p0.a.e0.d.h("SwanAppPkgDownloadCallback", "framework onDownloadError：" + aVar.toString());
                this.f6210e.l.j(dVar);
                c.a.p0.a.q2.a aVar2 = new c.a.p0.a.q2.a();
                aVar2.j(13L);
                aVar2.h(aVar.f11875a);
                aVar2.c("Framework包下载失败");
                aVar2.e(aVar.toString());
                if (this.f6210e.f6188j != null) {
                    this.f6210e.f6188j.onError(new PkgDownloadError(dVar, aVar2));
                }
                c.a.p0.a.h0.m.c.c().a(dVar, this.f6210e.h0(), aVar2);
                c.a.p0.t.d.j(dVar.f11879a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.n.f.b, c.a.p0.n.f.c
        /* renamed from: p */
        public void i(c.a.p0.n.h.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, dVar) == null) {
                super.i(dVar);
                c.a.p0.a.e0.d.h("SwanAppPkgDownloadCallback", "framework onFileDownloaded: " + dVar.f11887i);
                c.a.p0.a.q2.a v0 = this.f6210e.v0(dVar);
                if (v0 == null) {
                    f fVar = this.f6210e;
                    fVar.o = dVar;
                    fVar.l.k(dVar);
                    if (this.f6210e.f6188j != null) {
                        this.f6210e.f6188j.onNext(dVar);
                        this.f6210e.f6188j.onCompleted();
                    }
                    c.a.p0.a.h0.m.c.c().b(dVar, this.f6210e.h0());
                    return;
                }
                this.f6210e.l.j(dVar);
                if (this.f6210e.f6188j != null) {
                    this.f6210e.f6188j.onError(new PkgDownloadError(dVar, v0));
                }
                c.a.p0.a.h0.m.c.c().a(dVar, this.f6210e.h0(), v0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.n.f.b, c.a.p0.n.f.c
        /* renamed from: q */
        public void c(c.a.p0.n.h.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, dVar) == null) {
                super.c(dVar);
                c.a.p0.a.e0.d.h("SwanAppPkgDownloadCallback", "framework onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.n.f.b, c.a.p0.n.f.c
        /* renamed from: r */
        public void f(c.a.p0.n.h.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, dVar) == null) {
                super.f(dVar);
                if (f.E) {
                    String str = this.f6210e.f0() + ": framework onDownloading";
                }
                this.f6210e.z0(dVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class p extends c.a.p0.n.f.b<c.a.p0.n.h.b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f6211e;

        public p(f fVar) {
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
            this.f6211e = fVar;
        }

        @Override // c.a.p0.n.f.b
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f6211e.g0() : invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.n.f.c
        /* renamed from: l */
        public String d(c.a.p0.n.h.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, bVar)) == null) {
                int i2 = bVar.f11886h;
                if (i2 == 0) {
                    return c.a.p0.a.h0.m.r.a.d();
                }
                if (i2 == 1) {
                    return c.a.p0.a.h0.m.r.a.f();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        @Override // c.a.p0.n.f.e
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) ? this.f6211e.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.n.f.b, c.a.p0.n.f.c
        /* renamed from: o */
        public void e(c.a.p0.n.h.b bVar, c.a.p0.n.h.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar, aVar) == null) {
                super.e(bVar, aVar);
                c.a.p0.a.e0.d.h("SwanAppPkgDownloadCallback", "extension onDownloadError：" + aVar.toString());
                this.f6211e.l.j(bVar);
                c.a.p0.a.q2.a aVar2 = new c.a.p0.a.q2.a();
                aVar2.j(14L);
                aVar2.h(aVar.f11875a);
                aVar2.c("Extension下载失败");
                aVar2.e(aVar.toString());
                if (f.E) {
                    aVar2.toString();
                }
                this.f6211e.n0(bVar);
                c.a.p0.a.h0.m.c.c().a(bVar, this.f6211e.h0(), aVar2);
                c.a.p0.t.d.j(bVar.f11879a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.n.f.b, c.a.p0.n.f.c
        /* renamed from: p */
        public void i(c.a.p0.n.h.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, bVar) == null) {
                super.i(bVar);
                c.a.p0.a.e0.d.h("SwanAppPkgDownloadCallback", "extension onFileDownloaded: " + bVar.f11887i);
                c.a.p0.a.q2.a u0 = this.f6211e.u0(bVar);
                if (u0 != null) {
                    if (f.E) {
                        String str = "Extension 业务处理失败：" + bVar.toString();
                    }
                    this.f6211e.l.j(bVar);
                    this.f6211e.n0(bVar);
                    c.a.p0.a.h0.m.c.c().a(bVar, this.f6211e.h0(), u0);
                    return;
                }
                f fVar = this.f6211e;
                fVar.p = bVar;
                fVar.l.k(bVar);
                this.f6211e.n0(bVar);
                c.a.p0.a.h0.m.c.c().b(bVar, this.f6211e.h0());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.n.f.b, c.a.p0.n.f.c
        /* renamed from: q */
        public void c(c.a.p0.n.h.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, bVar) == null) {
                super.c(bVar);
                c.a.p0.a.e0.d.h("SwanAppPkgDownloadCallback", "extension onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.n.f.b, c.a.p0.n.f.c
        /* renamed from: r */
        public void f(c.a.p0.n.h.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, bVar) == null) {
                super.f(bVar);
                if (f.E) {
                    String str = this.f6211e.f0() + ": extension onDownloading";
                }
                this.f6211e.y0(bVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class q implements c.a.p0.n.f.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f6212a;

        public q(f fVar) {
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
            this.f6212a = fVar;
        }

        @Override // c.a.p0.n.f.f
        public void a(PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSAppInfo) == null) {
                if (f.E) {
                    String str = this.f6212a.f0() + ": onSwanAppReceive: " + pMSAppInfo.toString();
                }
                f fVar = this.f6212a;
                fVar.q = pMSAppInfo;
                if (pMSAppInfo != null) {
                    fVar.l0(pMSAppInfo);
                    c.a.p0.a.t1.g.b.k(this.f6212a.q.pluginInfo, true);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class r implements c.a.p0.a.v2.e1.b<c.a.p0.a.v2.e1.b<PMSAppInfo>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PMSAppInfo f6213e;

        public r(f fVar, PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, pMSAppInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6213e = pMSAppInfo;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(c.a.p0.a.v2.e1.b<PMSAppInfo> bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                bVar.onCallback(this.f6213e);
            }
        }
    }

    /* loaded from: classes.dex */
    public class s implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Collection f6214e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Object f6215f;

        public s(f fVar, Collection collection, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, collection, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6214e = collection;
            this.f6215f = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f6214e.add(this.f6215f);
            }
        }
    }

    /* loaded from: classes.dex */
    public class t implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Collection f6216e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Object f6217f;

        public t(f fVar, Collection collection, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, collection, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6216e = collection;
            this.f6217f = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f6216e.remove(this.f6217f);
            }
        }
    }

    /* loaded from: classes.dex */
    public class u implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Collection f6218e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.v2.e1.b f6219f;

        public u(f fVar, Collection collection, c.a.p0.a.v2.e1.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, collection, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6218e = collection;
            this.f6219f = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                for (Object obj : this.f6218e) {
                    this.f6219f.onCallback(obj);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1087047559, "Lc/a/p0/a/h0/m/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1087047559, "Lc/a/p0/a/h0/m/f;");
                return;
            }
        }
        E = c.a.p0.a.k.f7077a;
    }

    public f(String str) {
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
        this.f6185g = "";
        this.u = -1L;
        this.v = new HashSet();
        this.w = new HashSet();
        this.x = new y0();
        this.y = new a(this);
        this.z = new n(this, this);
        this.A = new o(this);
        this.B = new p(this);
        this.C = new q(this);
        this.D = new i(this);
        this.r = str;
        this.s = new ArrayList();
    }

    public final void A0(c.a.p0.n.h.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
            c.a.p0.a.h0.m.c.c().d(fVar, new e(this, fVar));
        }
    }

    @Override // c.a.p0.n.f.g
    public void B(c.a.p0.n.h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            c.a.p0.a.e0.d.h("SwanAppPkgDownloadCallback", "onFetchError: error=" + aVar);
            if (aVar != null && aVar.f11875a == 1010) {
                D0();
            }
            this.s.add(new UbcFlowEvent("na_pms_end_req"));
        }
    }

    public final void B0(c.a.p0.n.h.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gVar) == null) {
            c.a.p0.a.h0.m.c.c().d(gVar, new C0231f(this, gVar));
        }
    }

    @Override // c.a.p0.n.f.g
    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.s.add(new UbcFlowEvent("na_pms_start_req"));
        }
    }

    public c.a.p0.a.q2.a C0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            PMSAppInfo pMSAppInfo = this.q;
            if (pMSAppInfo == null) {
                if (this.m == null) {
                    c.a.p0.a.q2.a aVar = new c.a.p0.a.q2.a();
                    aVar.j(10L);
                    aVar.h(2903L);
                    aVar.c("Server未返回主包&AppInfo");
                    return aVar;
                }
                PMSAppInfo s2 = c.a.p0.n.g.a.h().s(this.r);
                if (s2 == null) {
                    c.a.p0.a.q2.a aVar2 = new c.a.p0.a.q2.a();
                    aVar2.j(10L);
                    aVar2.h(2904L);
                    aVar2.c("Server未返回AppInfo数据，本地也没有数据");
                    return aVar2;
                }
                this.q = s2;
                c.a.p0.a.h0.m.r.a.j(s2, this.m);
                this.q.initMaxAgeInfo();
                this.q.updateInstallSrc(I());
                if (c.a.p0.n.g.a.h().b(this.m, this.n, this.o, this.p, this.q)) {
                    return null;
                }
                c.a.p0.a.q2.a aVar3 = new c.a.p0.a.q2.a();
                aVar3.j(10L);
                aVar3.h(2906L);
                aVar3.c("更新DB失败");
                return aVar3;
            }
            c.a.p0.n.h.f fVar = this.m;
            if (fVar != null) {
                c.a.p0.a.h0.m.r.a.j(pMSAppInfo, fVar);
            } else if (c.a.p0.a.h0.m.r.b.f(this.n)) {
                c.a.p0.n.h.g gVar = this.n.get(0);
                this.t = gVar;
                gVar.o = this.r;
                c.a.p0.a.h0.m.r.a.k(this.q, gVar);
            } else {
                PMSAppInfo s3 = c.a.p0.n.g.a.h().s(this.r);
                if (s3 == null) {
                    c.a.p0.a.q2.a aVar4 = new c.a.p0.a.q2.a();
                    aVar4.j(10L);
                    aVar4.h(2905L);
                    aVar4.c("Server未返回包数据，本地也没有数据");
                    return aVar4;
                }
                PMSAppInfo pMSAppInfo2 = this.q;
                pMSAppInfo2.appId = this.r;
                pMSAppInfo2.copyLocalAppInfoData(s3);
            }
            this.q.initMaxAgeInfo();
            this.q.updateInstallSrc(I());
            if (c.a.p0.n.g.a.h().b(this.m, this.n, this.o, this.p, this.q)) {
                c.a.p0.a.h0.m.r.a.n(this.q);
                return null;
            }
            c.a.p0.a.q2.a aVar5 = new c.a.p0.a.q2.a();
            aVar5.j(10L);
            aVar5.h(2906L);
            aVar5.c("更新DB失败");
            return aVar5;
        }
        return (c.a.p0.a.q2.a) invokeV.objValue;
    }

    @Override // c.a.p0.n.f.g
    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.s.add(new UbcFlowEvent("na_pms_end_req"));
        }
    }

    public final void D0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            PMSAppInfo s2 = c.a.p0.n.g.a.h().s(this.r);
            c.a.p0.a.e0.d.h("SwanAppPkgDownloadCallback", "updateMainMaxAgeTime: createTime=" + s2.createTime + " lastLaunchTime=" + s2.getLastLaunchTime() + " maxAge=" + s2.maxAge);
            if (s2 != null) {
                s2.initMaxAgeInfo();
                s2.updateInstallSrc(I());
                c.a.p0.n.h.f fVar = this.m;
                if (fVar != null) {
                    fVar.f11881c = s2.createTime;
                }
                PMSAppInfo pMSAppInfo = this.q;
                if (pMSAppInfo != null) {
                    pMSAppInfo.createTime = s2.createTime;
                    pMSAppInfo.updateInstallSrc(I());
                }
                c.a.p0.n.g.a.h().k(s2);
            }
        }
    }

    @Override // c.a.p0.n.f.g
    public void F(c.a.p0.n.o.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, fVar) == null) {
            super.F(fVar);
            this.u = System.currentTimeMillis();
            if (E) {
                String str = "mStartDownload=" + this.u;
            }
            if (fVar == null) {
                return;
            }
            if (E) {
                String str2 = f0() + ": onPrepareDownload: countSet=" + fVar.l();
            }
            this.s.add(new UbcFlowEvent("na_pms_start_download"));
            this.l = fVar;
            if (fVar.i()) {
                return;
            }
            k0();
        }
    }

    public f b0(c.a.p0.a.v2.e1.b<PMSAppInfo> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar)) == null) {
            c0(this.w, bVar);
            return this;
        }
        return (f) invokeL.objValue;
    }

    public final synchronized <CallbackT> f c0(Collection<CallbackT> collection, CallbackT callbackt) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, collection, callbackt)) == null) {
            synchronized (this) {
                if (collection != null && callbackt != null) {
                    this.x.a(new s(this, collection, callbackt));
                }
            }
            return this;
        }
        return (f) invokeLL.objValue;
    }

    public synchronized f d0(c.a.p0.a.h0.m.m.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, aVar)) == null) {
            synchronized (this) {
                c0(this.v, aVar);
            }
            return this;
        }
        return (f) invokeL.objValue;
    }

    public final synchronized <CallbackT> f e0(Collection<CallbackT> collection, CallbackT callbackt) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, collection, callbackt)) == null) {
            synchronized (this) {
                if (collection != null && callbackt != null) {
                    this.x.a(new t(this, collection, callbackt));
                }
            }
            return this;
        }
        return (f) invokeLL.objValue;
    }

    public String f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (TextUtils.isEmpty(this.f6185g)) {
                this.f6185g = getClass().toString();
            }
            return this.f6185g;
        }
        return (String) invokeV.objValue;
    }

    public int g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return 100;
        }
        return invokeV.intValue;
    }

    public abstract PMSDownloadType h0();

    public final String i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? c.a.p0.n.f.h.b(this, "get_launch_id").getString("launch_id", "") : (String) invokeV.objValue;
    }

    public void j0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            if (i2 == 1013) {
                c.a.p0.n.g.a.h().x(this.r, i2);
            } else {
                c.a.p0.n.g.a.h().x(this.r, 0);
            }
        }
    }

    public final void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            ArrayList arrayList = new ArrayList();
            if (this.l.d()) {
                arrayList.add(i.d.b(new j(this)));
            }
            if (this.l.f()) {
                arrayList.add(i.d.b(new k(this)));
            }
            if (this.l.c()) {
                arrayList.add(i.d.b(new l(this)));
            }
            if (this.l.b()) {
                arrayList.add(i.d.b(new m(this)));
            }
            if (arrayList.isEmpty()) {
                return;
            }
            i.d.l(arrayList).z(this.D);
        }
    }

    public f l0(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, pMSAppInfo)) == null) {
            m0(this.w, new r(this, pMSAppInfo));
            return this;
        }
        return (f) invokeL.objValue;
    }

    public final synchronized <CallbackT> f m0(@NonNull Collection<CallbackT> collection, @NonNull c.a.p0.a.v2.e1.b<CallbackT> bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048595, this, collection, bVar)) == null) {
            synchronized (this) {
                this.x.a(new u(this, collection, bVar));
            }
            return this;
        }
        return (f) invokeLL.objValue;
    }

    public final void n0(c.a.p0.n.h.b bVar) {
        i.j<? super c.a.p0.n.h.b> jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, bVar) == null) || (jVar = this.k) == null) {
            return;
        }
        jVar.onNext(bVar);
        this.k.onCompleted();
    }

    public f o0(@NonNull c.a.p0.a.v2.e1.b<c.a.p0.a.h0.m.m.a> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, bVar)) == null) {
            m0(this.v, new b(this, bVar));
            return this;
        }
        return (f) invokeL.objValue;
    }

    @Override // c.a.p0.n.f.g
    public c.a.p0.n.f.f p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.C : (c.a.p0.n.f.f) invokeV.objValue;
    }

    public void p0(PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, pMSAppInfo) == null) {
            o0(new d(this, pMSAppInfo));
        }
    }

    @Override // c.a.p0.n.f.g
    public c.a.p0.n.f.c<c.a.p0.n.h.b> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.B : (c.a.p0.n.f.c) invokeV.objValue;
    }

    public void q0(c.a.p0.a.q2.a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048601, this, aVar, z) == null) {
            o0(new c(this, aVar, z));
        }
    }

    @Override // c.a.p0.n.f.g
    public c.a.p0.n.f.c<c.a.p0.n.h.d> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.A : (c.a.p0.n.f.c) invokeV.objValue;
    }

    public void r0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || this.q == null) {
            return;
        }
        PMSAppInfo s2 = c.a.p0.n.g.a.h().s(this.r);
        if (s2 == null) {
            c.a.p0.a.e0.d.h("SwanAppPkgDownloadCallback", "Server未返回包数据，本地也没查到");
            return;
        }
        this.q.appId = this.r;
        s2.updateInstallSrc(I());
        this.q.copyLocalAppInfoData(s2);
        this.q.initMaxAgeInfo();
        if (c.a.p0.n.g.a.h().k(this.q)) {
            c.a.p0.a.h0.m.r.a.n(this.q);
        }
    }

    public void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            long currentTimeMillis = System.currentTimeMillis() - this.u;
            c.a.p0.a.e0.d.g("SwanAppPkgDownloadCallback", "pms download time : " + currentTimeMillis);
        }
    }

    @Override // c.a.p0.n.f.g
    public c.a.p0.n.f.c<c.a.p0.n.h.f> t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.y : (c.a.p0.n.f.c) invokeV.objValue;
    }

    public abstract void t0(Throwable th);

    public c.a.p0.a.q2.a u0(c.a.p0.n.h.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, bVar)) == null) {
            c.a.p0.a.p0.g.a aVar = new c.a.p0.a.p0.g.a();
            aVar.f7981b = bVar.f11887i;
            aVar.f7980a = bVar.f11888j;
            aVar.f7982c = bVar.f11879a;
            aVar.f7983d = bVar.m;
            if (c.a.p0.a.p0.b.b(bVar.f11886h, aVar) == null) {
                return null;
            }
            c.a.p0.a.q2.a aVar2 = new c.a.p0.a.q2.a();
            aVar2.j(14L);
            aVar2.b(2908L);
            aVar2.c("Extension包更新失败");
            return aVar2;
        }
        return (c.a.p0.a.q2.a) invokeL.objValue;
    }

    public c.a.p0.a.q2.a v0(c.a.p0.n.h.d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, dVar)) == null) {
            if (E) {
                String str = "onFrameworkPkgDownload framework = " + dVar;
            }
            a.b c2 = c.a.p0.a.m2.f.a.c(dVar, dVar.f11886h);
            if (!TextUtils.isEmpty(dVar.f11879a)) {
                c.a.p0.a.e0.d.h("SwanAppPkgDownloadCallback", "#onFrameworkPkgDownload del: " + dVar.f11879a);
                c.a.p0.t.d.j(dVar.f11879a);
            }
            if (c2.c()) {
                return null;
            }
            c.a.p0.a.q2.a aVar = new c.a.p0.a.q2.a();
            aVar.j(13L);
            aVar.b(2907L);
            aVar.c("Core包更新失败");
            return aVar;
        }
        return (c.a.p0.a.q2.a) invokeL.objValue;
    }

    public c.a.p0.a.q2.a w0(c.a.p0.n.h.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, fVar)) == null) {
            if (fVar == null) {
                c.a.p0.a.q2.a aVar = new c.a.p0.a.q2.a();
                aVar.j(11L);
                aVar.h(2310L);
                aVar.e("pkg info is empty");
                c.a.p0.a.q2.e.a().f(aVar);
                return aVar;
            }
            return null;
        }
        return (c.a.p0.a.q2.a) invokeL.objValue;
    }

    public void x0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048610, this, str, str2) == null) {
            c.a.p0.a.r1.q.a.a(this.r, str, this.s, str2);
            this.s.clear();
        }
    }

    public final void y0(c.a.p0.n.h.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, bVar) == null) {
            c.a.p0.a.h0.m.c.c().d(bVar, new h(this, bVar));
        }
    }

    @Override // c.a.p0.n.f.g
    public c.a.p0.n.f.c<c.a.p0.n.h.g> z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.z : (c.a.p0.n.f.c) invokeV.objValue;
    }

    public final void z0(c.a.p0.n.h.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, dVar) == null) {
            c.a.p0.a.h0.m.c.c().d(dVar, new g(this, dVar));
        }
    }
}
