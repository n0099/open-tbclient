package b.a.p0.a.h0.m;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.a2.i;
import b.a.p0.a.h0.m.c;
import b.a.p0.a.m2.f.a;
import b.a.p0.a.v2.y0;
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
public abstract class f extends b.a.p0.a.h0.m.j {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean E;
    public transient /* synthetic */ FieldHolder $fh;
    public b.a.p0.n.f.c<b.a.p0.n.h.d> A;
    public b.a.p0.n.f.c<b.a.p0.n.h.b> B;
    public b.a.p0.n.f.f C;
    public h.j<b.a.p0.n.h.e> D;

    /* renamed from: g  reason: collision with root package name */
    public String f5530g;

    /* renamed from: h  reason: collision with root package name */
    public h.j<? super b.a.p0.n.h.f> f5531h;

    /* renamed from: i  reason: collision with root package name */
    public h.j<? super b.a.p0.n.h.g> f5532i;
    public h.j<? super b.a.p0.n.h.d> j;
    public h.j<? super b.a.p0.n.h.b> k;
    public b.a.p0.n.o.f l;
    public b.a.p0.n.h.f m;
    public List<b.a.p0.n.h.g> n;
    public b.a.p0.n.h.d o;
    public b.a.p0.n.h.b p;
    public PMSAppInfo q;
    public String r;
    public List<UbcFlowEvent> s;
    public b.a.p0.n.h.g t;
    public long u;
    public final Set<b.a.p0.a.h0.m.m.a> v;
    public final Set<b.a.p0.a.v2.e1.b<PMSAppInfo>> w;
    public final y0 x;
    public b.a.p0.n.f.c<b.a.p0.n.h.f> y;
    public b.a.p0.n.f.c<b.a.p0.n.h.g> z;

    /* loaded from: classes.dex */
    public class a extends b.a.p0.n.f.b<b.a.p0.n.h.f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f5533e;

        /* renamed from: b.a.p0.a.h0.m.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0225a implements b.a.p0.a.v2.e1.b<i.a> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f5534e;

            public C0225a(a aVar) {
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
                this.f5534e = aVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // b.a.p0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(i.a aVar) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) && "installer_on_pump_finish".equals(aVar.f3967f)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("performance_ubc_event_id", "670");
                    bundle.putString("performance_ubc_extra_key_for_event", "na_stream_bump_end");
                    b.a.p0.n.f.h.a(this.f5534e.f5533e, bundle, "event_performance_ubc");
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
            this.f5533e = fVar;
        }

        @Override // b.a.p0.n.f.b
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f5533e.g0() : invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.n.f.c
        /* renamed from: l */
        public String d(b.a.p0.n.h.f fVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, fVar)) == null) {
                int i2 = fVar.f11077h;
                if (i2 == 0) {
                    return b.a.p0.a.h0.m.r.a.g();
                }
                if (i2 == 1) {
                    return b.a.p0.a.h0.m.r.a.i();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        @Override // b.a.p0.n.f.e
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle, set)) == null) ? this.f5533e.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.n.f.b, b.a.p0.n.f.c
        /* renamed from: o */
        public void e(b.a.p0.n.h.f fVar, b.a.p0.n.h.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048585, this, fVar, aVar) == null) {
                super.e(fVar, aVar);
                b.a.p0.a.e0.d.h("SwanAppPkgDownloadCallback", "onDownloadError：" + aVar.toString());
                this.f5533e.l.j(fVar);
                b.a.p0.a.q2.a aVar2 = new b.a.p0.a.q2.a();
                aVar2.j(11L);
                aVar2.h(aVar.f11066a);
                aVar2.c("主包下载失败");
                aVar2.e(aVar.toString());
                if (this.f5533e.f5531h != null) {
                    this.f5533e.f5531h.onError(new PkgDownloadError(fVar, aVar2));
                }
                b.a.p0.a.h0.m.c.c().a(fVar, this.f5533e.h0(), aVar2);
                b.a.p0.t.d.j(fVar.f11070a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.n.f.b, b.a.p0.n.f.c
        /* renamed from: p */
        public void i(b.a.p0.n.h.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, fVar) == null) {
                String i0 = this.f5533e.i0();
                if (f.E) {
                    b.a.p0.a.f1.g.a.d(i0).e().d(1);
                }
                super.i(fVar);
                this.f5533e.s.add(new UbcFlowEvent("na_pms_end_download"));
                b.a.p0.a.q2.a w0 = this.f5533e.w0(fVar);
                b.a.p0.a.e0.d.h("SwanAppPkgDownloadCallback", "main onFileDownloaded: pmsPkgMain=" + fVar.f11078i);
                if (w0 == null) {
                    f fVar2 = this.f5533e;
                    fVar2.m = fVar;
                    fVar2.l.k(fVar);
                    if (this.f5533e.f5531h != null) {
                        this.f5533e.f5531h.onNext(fVar);
                        if (f.E) {
                            String str = this.f5533e.f0() + ": main onFileDownloaded: onCompleted";
                        }
                        this.f5533e.f5531h.onCompleted();
                    }
                    b.a.p0.a.h0.m.c.c().b(fVar, this.f5533e.h0());
                    return;
                }
                this.f5533e.l.j(fVar);
                if (this.f5533e.f5531h != null) {
                    this.f5533e.f5531h.onError(new PkgDownloadError(fVar, w0));
                }
                b.a.p0.a.h0.m.c.c().a(fVar, this.f5533e.h0(), w0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.n.f.b, b.a.p0.n.f.c
        /* renamed from: q */
        public void c(b.a.p0.n.h.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, fVar) == null) {
                String i0 = this.f5533e.i0();
                if (f.E) {
                    b.a.p0.a.f1.g.a.d(i0).e().d(1);
                }
                super.c(fVar);
                b.a.p0.a.e0.d.h("SwanAppPkgDownloadCallback", "main onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.n.f.b, b.a.p0.n.f.c
        /* renamed from: r */
        public void f(b.a.p0.n.h.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, fVar) == null) {
                String i0 = this.f5533e.i0();
                if (f.E) {
                    b.a.p0.a.f1.g.a.d(i0).e().d(1);
                }
                super.f(fVar);
                if (f.E) {
                    String str = this.f5533e.f0() + ": main onDownloading";
                }
                this.f5533e.A0(fVar);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.n.f.b, b.a.p0.n.f.c
        /* renamed from: s */
        public b.a.p0.n.h.a h(b.a.p0.n.h.f fVar, File file, long j, ReadableByteChannel readableByteChannel) throws IOException {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{fVar, file, Long.valueOf(j), readableByteChannel})) == null) {
                String i0 = this.f5533e.i0();
                if (f.E) {
                    b.a.p0.a.f1.g.a.d(i0).f(fVar.toString()).d(1);
                }
                C0225a c0225a = new C0225a(this);
                Bundle bundle = new Bundle();
                bundle.putLong(CloudStabilityUBCUtils.KEY_LENGTH, j);
                bundle.putFloat("progress_granularity", 0.1f);
                b.a.p0.a.a1.g gVar = new b.a.p0.a.a1.g();
                gVar.v(c0225a);
                gVar.g(bundle);
                gVar.f(new b.a.p0.a.a1.f(fVar, this.f5533e));
                gVar.f(new b.a.p0.a.a1.d(fVar.m, this.f5533e));
                gVar.i(readableByteChannel);
                boolean j2 = gVar.j();
                gVar.p(c0225a);
                if (f.E) {
                    String str = this.f5533e.f0() + ": onProcessStream: installOk=" + j2;
                }
                if (j2) {
                    b.a.p0.a.e0.d.h("SwanAppPkgDownloadCallback", "#onProcessStream del: " + file.getAbsolutePath());
                    b.a.p0.t.d.K(file);
                }
                return j2 ? new b.a.p0.n.h.a(2300, "业务层处理下载流成功") : new b.a.p0.n.h.a(2301, "业务层处理下载流失败");
            }
            return (b.a.p0.n.h.a) invokeCommon.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class b implements b.a.p0.a.v2.e1.b<b.a.p0.a.h0.m.m.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.v2.e1.b f5535e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f5536f;

        public b(f fVar, b.a.p0.a.v2.e1.b bVar) {
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
            this.f5536f = fVar;
            this.f5535e = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(b.a.p0.a.h0.m.m.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f5535e.onCallback(aVar);
                f fVar = this.f5536f;
                fVar.e0(fVar.v, aVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements b.a.p0.a.v2.e1.b<b.a.p0.a.h0.m.m.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.q2.a f5537e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f5538f;

        public c(f fVar, b.a.p0.a.q2.a aVar, boolean z) {
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
            this.f5537e = aVar;
            this.f5538f = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(b.a.p0.a.h0.m.m.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.a(this.f5537e, this.f5538f);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements b.a.p0.a.v2.e1.b<b.a.p0.a.h0.m.m.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PMSAppInfo f5539e;

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
            this.f5539e = pMSAppInfo;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(b.a.p0.a.h0.m.m.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.b(this.f5539e);
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements c.InterfaceC0223c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.n.h.f f5540a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f5541b;

        public e(f fVar, b.a.p0.n.h.f fVar2) {
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
            this.f5541b = fVar;
            this.f5540a = fVar2;
        }

        @Override // b.a.p0.a.h0.m.c.InterfaceC0223c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                f fVar = this.f5541b;
                b.a.p0.n.h.f fVar2 = this.f5540a;
                fVar.m = fVar2;
                fVar.l.k(fVar2);
                if (this.f5541b.f5531h != null) {
                    this.f5541b.f5531h.onNext(this.f5540a);
                    this.f5541b.f5531h.onCompleted();
                }
            }
        }

        @Override // b.a.p0.a.h0.m.c.InterfaceC0223c
        public void b(PMSDownloadType pMSDownloadType, b.a.p0.a.q2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, aVar) == null) {
                this.f5541b.l.j(this.f5540a);
                if (this.f5541b.f5531h != null) {
                    this.f5541b.f5531h.onError(new PkgDownloadError(this.f5540a, aVar));
                }
            }
        }
    }

    /* renamed from: b.a.p0.a.h0.m.f$f  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0226f implements c.InterfaceC0223c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.n.h.g f5542a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f5543b;

        public C0226f(f fVar, b.a.p0.n.h.g gVar) {
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
            this.f5543b = fVar;
            this.f5542a = gVar;
        }

        @Override // b.a.p0.a.h0.m.c.InterfaceC0223c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                f fVar = this.f5543b;
                if (fVar.n == null) {
                    fVar.n = new ArrayList();
                }
                b.a.p0.n.h.g gVar = this.f5542a;
                f fVar2 = this.f5543b;
                gVar.o = fVar2.r;
                fVar2.n.add(gVar);
                this.f5543b.l.k(this.f5542a);
                if (this.f5543b.f5532i != null) {
                    this.f5543b.f5532i.onNext(this.f5542a);
                    if (this.f5543b.l.g()) {
                        return;
                    }
                    this.f5543b.f5532i.onCompleted();
                }
            }
        }

        @Override // b.a.p0.a.h0.m.c.InterfaceC0223c
        public void b(PMSDownloadType pMSDownloadType, b.a.p0.a.q2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, aVar) == null) {
                this.f5543b.l.j(this.f5542a);
                if (this.f5543b.f5532i != null) {
                    this.f5543b.f5532i.onError(new PkgDownloadError(this.f5542a, aVar));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements c.InterfaceC0223c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.n.h.d f5544a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f5545b;

        public g(f fVar, b.a.p0.n.h.d dVar) {
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
            this.f5545b = fVar;
            this.f5544a = dVar;
        }

        @Override // b.a.p0.a.h0.m.c.InterfaceC0223c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                f fVar = this.f5545b;
                b.a.p0.n.h.d dVar = this.f5544a;
                fVar.o = dVar;
                fVar.l.k(dVar);
                if (this.f5545b.j != null) {
                    this.f5545b.j.onNext(this.f5544a);
                    this.f5545b.j.onCompleted();
                }
            }
        }

        @Override // b.a.p0.a.h0.m.c.InterfaceC0223c
        public void b(PMSDownloadType pMSDownloadType, b.a.p0.a.q2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, aVar) == null) {
                this.f5545b.l.j(this.f5544a);
                if (this.f5545b.j != null) {
                    this.f5545b.j.onError(new PkgDownloadError(this.f5544a, aVar));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class h implements c.InterfaceC0223c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.n.h.b f5546a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f5547b;

        public h(f fVar, b.a.p0.n.h.b bVar) {
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
            this.f5547b = fVar;
            this.f5546a = bVar;
        }

        @Override // b.a.p0.a.h0.m.c.InterfaceC0223c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                b.a.p0.a.e0.d.h("SwanAppPkgDownloadCallback", "Extension Repeat: onSuccess ：" + pMSDownloadType);
                f fVar = this.f5547b;
                b.a.p0.n.h.b bVar = this.f5546a;
                fVar.p = bVar;
                fVar.l.k(bVar);
                this.f5547b.n0(this.f5546a);
            }
        }

        @Override // b.a.p0.a.h0.m.c.InterfaceC0223c
        public void b(PMSDownloadType pMSDownloadType, b.a.p0.a.q2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, aVar) == null) {
                b.a.p0.a.e0.d.h("SwanAppPkgDownloadCallback", "Extension Repeat: onError ：" + pMSDownloadType + ":" + aVar.toString());
                this.f5547b.l.j(this.f5546a);
                this.f5547b.n0(this.f5546a);
            }
        }
    }

    /* loaded from: classes.dex */
    public class i extends h.j<b.a.p0.n.h.e> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ f f5548i;

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
            this.f5548i = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.e
        /* renamed from: g */
        public void onNext(b.a.p0.n.h.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) {
                b.a.p0.a.e0.d.h("SwanAppPkgDownloadCallback", this.f5548i.h0() + " : 单个包下载、业务层处理完成：" + eVar.f11078i);
            }
        }

        @Override // h.e
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                b.a.p0.a.e0.d.h("SwanAppPkgDownloadCallback", this.f5548i.h0() + " : 包下载onCompleted");
                this.f5548i.s0();
            }
        }

        @Override // h.e
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                b.a.p0.a.e0.d.i("SwanAppPkgDownloadCallback", this.f5548i.h0() + " : 包下载OnError", th);
                this.f5548i.t0(th);
            }
        }
    }

    /* loaded from: classes.dex */
    public class j implements d.a<b.a.p0.n.h.f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f5549e;

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
            this.f5549e = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.d.a, h.n.b
        public void call(h.j<? super b.a.p0.n.h.f> jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
                this.f5549e.f5531h = jVar;
            }
        }
    }

    /* loaded from: classes.dex */
    public class k implements d.a<b.a.p0.n.h.g> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f5550e;

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
            this.f5550e = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.d.a, h.n.b
        public void call(h.j<? super b.a.p0.n.h.g> jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
                this.f5550e.f5532i = jVar;
            }
        }
    }

    /* loaded from: classes.dex */
    public class l implements d.a<b.a.p0.n.h.d> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f5551e;

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
            this.f5551e = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.d.a, h.n.b
        public void call(h.j<? super b.a.p0.n.h.d> jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
                this.f5551e.j = jVar;
            }
        }
    }

    /* loaded from: classes.dex */
    public class m implements d.a<b.a.p0.n.h.b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f5552e;

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
            this.f5552e = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.d.a, h.n.b
        public void call(h.j<? super b.a.p0.n.h.b> jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
                this.f5552e.k = jVar;
            }
        }
    }

    /* loaded from: classes.dex */
    public class n extends b.a.p0.a.h0.m.k<f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ f f5553g;

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
                    super((b.a.p0.a.h0.m.j) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5553g = fVar;
        }

        @Override // b.a.p0.a.h0.m.k, b.a.p0.n.f.b
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f5553g.g0() : invokeV.intValue;
        }

        @Override // b.a.p0.a.h0.m.k
        public String l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f5553g.r : (String) invokeV.objValue;
        }

        @Override // b.a.p0.a.h0.m.k
        public void p(@NonNull b.a.p0.n.h.g gVar, @Nullable b.a.p0.a.q2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, gVar, aVar) == null) {
                super.p(gVar, aVar);
                b.a.p0.a.e0.d.h("SwanAppPkgDownloadCallback", "sub onFileDownloaded: " + gVar.f11078i);
                f fVar = this.f5553g;
                if (fVar.n == null) {
                    fVar.n = new ArrayList();
                }
                f fVar2 = this.f5553g;
                gVar.o = fVar2.r;
                if (aVar == null) {
                    fVar2.n.add(gVar);
                    this.f5553g.l.k(gVar);
                    b.a.p0.a.h0.m.c.c().b(gVar, this.f5553g.h0());
                } else {
                    fVar2.l.j(gVar);
                    b.a.p0.a.h0.m.c.c().a(gVar, this.f5553g.h0(), aVar);
                }
                if (this.f5553g.f5532i != null) {
                    this.f5553g.f5532i.onNext(gVar);
                    if (this.f5553g.l.g()) {
                        return;
                    }
                    this.f5553g.f5532i.onCompleted();
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.n.f.b, b.a.p0.n.f.c
        /* renamed from: q */
        public void e(b.a.p0.n.h.g gVar, b.a.p0.n.h.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, gVar, aVar) == null) {
                super.q(gVar, aVar);
                b.a.p0.a.e0.d.h("SwanAppPkgDownloadCallback", "sub onDownloadError：" + aVar.toString());
                this.f5553g.l.j(gVar);
                b.a.p0.a.q2.a aVar2 = new b.a.p0.a.q2.a();
                aVar2.j(12L);
                aVar2.h(aVar.f11066a);
                aVar2.c("分包下载失败");
                aVar2.e(aVar.toString());
                if (this.f5553g.f5532i != null) {
                    this.f5553g.f5532i.onError(new PkgDownloadError(gVar, aVar2));
                }
                b.a.p0.a.h0.m.c.c().a(gVar, this.f5553g.h0(), aVar2);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.h0.m.k, b.a.p0.n.f.b, b.a.p0.n.f.c
        /* renamed from: s */
        public void c(b.a.p0.n.h.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, gVar) == null) {
                super.c(gVar);
                b.a.p0.a.e0.d.h("SwanAppPkgDownloadCallback", "sub onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.n.f.b, b.a.p0.n.f.c
        /* renamed from: u */
        public void f(b.a.p0.n.h.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, gVar) == null) {
                super.f(gVar);
                this.f5553g.B0(gVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class o extends b.a.p0.n.f.b<b.a.p0.n.h.d> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f5554e;

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
            this.f5554e = fVar;
        }

        @Override // b.a.p0.n.f.b
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f5554e.g0() : invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.n.f.c
        /* renamed from: l */
        public String d(b.a.p0.n.h.d dVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, dVar)) == null) {
                int i2 = dVar.f11077h;
                if (i2 == 0) {
                    return b.a.p0.a.h0.m.r.a.h();
                }
                if (i2 == 1) {
                    return b.a.p0.a.h0.m.r.a.e();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        @Override // b.a.p0.n.f.e
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) ? this.f5554e.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.n.f.b, b.a.p0.n.f.c
        /* renamed from: o */
        public void e(b.a.p0.n.h.d dVar, b.a.p0.n.h.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dVar, aVar) == null) {
                super.e(dVar, aVar);
                b.a.p0.a.e0.d.h("SwanAppPkgDownloadCallback", "framework onDownloadError：" + aVar.toString());
                this.f5554e.l.j(dVar);
                b.a.p0.a.q2.a aVar2 = new b.a.p0.a.q2.a();
                aVar2.j(13L);
                aVar2.h(aVar.f11066a);
                aVar2.c("Framework包下载失败");
                aVar2.e(aVar.toString());
                if (this.f5554e.j != null) {
                    this.f5554e.j.onError(new PkgDownloadError(dVar, aVar2));
                }
                b.a.p0.a.h0.m.c.c().a(dVar, this.f5554e.h0(), aVar2);
                b.a.p0.t.d.j(dVar.f11070a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.n.f.b, b.a.p0.n.f.c
        /* renamed from: p */
        public void i(b.a.p0.n.h.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, dVar) == null) {
                super.i(dVar);
                b.a.p0.a.e0.d.h("SwanAppPkgDownloadCallback", "framework onFileDownloaded: " + dVar.f11078i);
                b.a.p0.a.q2.a v0 = this.f5554e.v0(dVar);
                if (v0 == null) {
                    f fVar = this.f5554e;
                    fVar.o = dVar;
                    fVar.l.k(dVar);
                    if (this.f5554e.j != null) {
                        this.f5554e.j.onNext(dVar);
                        this.f5554e.j.onCompleted();
                    }
                    b.a.p0.a.h0.m.c.c().b(dVar, this.f5554e.h0());
                    return;
                }
                this.f5554e.l.j(dVar);
                if (this.f5554e.j != null) {
                    this.f5554e.j.onError(new PkgDownloadError(dVar, v0));
                }
                b.a.p0.a.h0.m.c.c().a(dVar, this.f5554e.h0(), v0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.n.f.b, b.a.p0.n.f.c
        /* renamed from: q */
        public void c(b.a.p0.n.h.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, dVar) == null) {
                super.c(dVar);
                b.a.p0.a.e0.d.h("SwanAppPkgDownloadCallback", "framework onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.n.f.b, b.a.p0.n.f.c
        /* renamed from: r */
        public void f(b.a.p0.n.h.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, dVar) == null) {
                super.f(dVar);
                if (f.E) {
                    String str = this.f5554e.f0() + ": framework onDownloading";
                }
                this.f5554e.z0(dVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class p extends b.a.p0.n.f.b<b.a.p0.n.h.b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f5555e;

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
            this.f5555e = fVar;
        }

        @Override // b.a.p0.n.f.b
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f5555e.g0() : invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.n.f.c
        /* renamed from: l */
        public String d(b.a.p0.n.h.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, bVar)) == null) {
                int i2 = bVar.f11077h;
                if (i2 == 0) {
                    return b.a.p0.a.h0.m.r.a.d();
                }
                if (i2 == 1) {
                    return b.a.p0.a.h0.m.r.a.f();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        @Override // b.a.p0.n.f.e
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) ? this.f5555e.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.n.f.b, b.a.p0.n.f.c
        /* renamed from: o */
        public void e(b.a.p0.n.h.b bVar, b.a.p0.n.h.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar, aVar) == null) {
                super.e(bVar, aVar);
                b.a.p0.a.e0.d.h("SwanAppPkgDownloadCallback", "extension onDownloadError：" + aVar.toString());
                this.f5555e.l.j(bVar);
                b.a.p0.a.q2.a aVar2 = new b.a.p0.a.q2.a();
                aVar2.j(14L);
                aVar2.h(aVar.f11066a);
                aVar2.c("Extension下载失败");
                aVar2.e(aVar.toString());
                if (f.E) {
                    aVar2.toString();
                }
                this.f5555e.n0(bVar);
                b.a.p0.a.h0.m.c.c().a(bVar, this.f5555e.h0(), aVar2);
                b.a.p0.t.d.j(bVar.f11070a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.n.f.b, b.a.p0.n.f.c
        /* renamed from: p */
        public void i(b.a.p0.n.h.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, bVar) == null) {
                super.i(bVar);
                b.a.p0.a.e0.d.h("SwanAppPkgDownloadCallback", "extension onFileDownloaded: " + bVar.f11078i);
                b.a.p0.a.q2.a u0 = this.f5555e.u0(bVar);
                if (u0 != null) {
                    if (f.E) {
                        String str = "Extension 业务处理失败：" + bVar.toString();
                    }
                    this.f5555e.l.j(bVar);
                    this.f5555e.n0(bVar);
                    b.a.p0.a.h0.m.c.c().a(bVar, this.f5555e.h0(), u0);
                    return;
                }
                f fVar = this.f5555e;
                fVar.p = bVar;
                fVar.l.k(bVar);
                this.f5555e.n0(bVar);
                b.a.p0.a.h0.m.c.c().b(bVar, this.f5555e.h0());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.n.f.b, b.a.p0.n.f.c
        /* renamed from: q */
        public void c(b.a.p0.n.h.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, bVar) == null) {
                super.c(bVar);
                b.a.p0.a.e0.d.h("SwanAppPkgDownloadCallback", "extension onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.n.f.b, b.a.p0.n.f.c
        /* renamed from: r */
        public void f(b.a.p0.n.h.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, bVar) == null) {
                super.f(bVar);
                if (f.E) {
                    String str = this.f5555e.f0() + ": extension onDownloading";
                }
                this.f5555e.y0(bVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class q implements b.a.p0.n.f.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f5556a;

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
            this.f5556a = fVar;
        }

        @Override // b.a.p0.n.f.f
        public void a(PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSAppInfo) == null) {
                if (f.E) {
                    String str = this.f5556a.f0() + ": onSwanAppReceive: " + pMSAppInfo.toString();
                }
                f fVar = this.f5556a;
                fVar.q = pMSAppInfo;
                if (pMSAppInfo != null) {
                    fVar.l0(pMSAppInfo);
                    b.a.p0.a.t1.g.b.k(this.f5556a.q.pluginInfo, true);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class r implements b.a.p0.a.v2.e1.b<b.a.p0.a.v2.e1.b<PMSAppInfo>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PMSAppInfo f5557e;

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
            this.f5557e = pMSAppInfo;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(b.a.p0.a.v2.e1.b<PMSAppInfo> bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                bVar.onCallback(this.f5557e);
            }
        }
    }

    /* loaded from: classes.dex */
    public class s implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Collection f5558e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Object f5559f;

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
            this.f5558e = collection;
            this.f5559f = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f5558e.add(this.f5559f);
            }
        }
    }

    /* loaded from: classes.dex */
    public class t implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Collection f5560e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Object f5561f;

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
            this.f5560e = collection;
            this.f5561f = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f5560e.remove(this.f5561f);
            }
        }
    }

    /* loaded from: classes.dex */
    public class u implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Collection f5562e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.v2.e1.b f5563f;

        public u(f fVar, Collection collection, b.a.p0.a.v2.e1.b bVar) {
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
            this.f5562e = collection;
            this.f5563f = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                for (Object obj : this.f5562e) {
                    this.f5563f.onCallback(obj);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1597581736, "Lb/a/p0/a/h0/m/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1597581736, "Lb/a/p0/a/h0/m/f;");
                return;
            }
        }
        E = b.a.p0.a.k.f6397a;
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
        this.f5530g = "";
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

    public final void A0(b.a.p0.n.h.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
            b.a.p0.a.h0.m.c.c().d(fVar, new e(this, fVar));
        }
    }

    @Override // b.a.p0.n.f.g
    public void B(b.a.p0.n.h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            b.a.p0.a.e0.d.h("SwanAppPkgDownloadCallback", "onFetchError: error=" + aVar);
            if (aVar != null && aVar.f11066a == 1010) {
                D0();
            }
            this.s.add(new UbcFlowEvent("na_pms_end_req"));
        }
    }

    public final void B0(b.a.p0.n.h.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gVar) == null) {
            b.a.p0.a.h0.m.c.c().d(gVar, new C0226f(this, gVar));
        }
    }

    @Override // b.a.p0.n.f.g
    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.s.add(new UbcFlowEvent("na_pms_start_req"));
        }
    }

    public b.a.p0.a.q2.a C0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            PMSAppInfo pMSAppInfo = this.q;
            if (pMSAppInfo == null) {
                if (this.m == null) {
                    b.a.p0.a.q2.a aVar = new b.a.p0.a.q2.a();
                    aVar.j(10L);
                    aVar.h(2903L);
                    aVar.c("Server未返回主包&AppInfo");
                    return aVar;
                }
                PMSAppInfo s2 = b.a.p0.n.g.a.h().s(this.r);
                if (s2 == null) {
                    b.a.p0.a.q2.a aVar2 = new b.a.p0.a.q2.a();
                    aVar2.j(10L);
                    aVar2.h(2904L);
                    aVar2.c("Server未返回AppInfo数据，本地也没有数据");
                    return aVar2;
                }
                this.q = s2;
                b.a.p0.a.h0.m.r.a.j(s2, this.m);
                this.q.initMaxAgeInfo();
                this.q.updateInstallSrc(I());
                if (b.a.p0.n.g.a.h().b(this.m, this.n, this.o, this.p, this.q)) {
                    return null;
                }
                b.a.p0.a.q2.a aVar3 = new b.a.p0.a.q2.a();
                aVar3.j(10L);
                aVar3.h(2906L);
                aVar3.c("更新DB失败");
                return aVar3;
            }
            b.a.p0.n.h.f fVar = this.m;
            if (fVar != null) {
                b.a.p0.a.h0.m.r.a.j(pMSAppInfo, fVar);
            } else if (b.a.p0.a.h0.m.r.b.f(this.n)) {
                b.a.p0.n.h.g gVar = this.n.get(0);
                this.t = gVar;
                gVar.o = this.r;
                b.a.p0.a.h0.m.r.a.k(this.q, gVar);
            } else {
                PMSAppInfo s3 = b.a.p0.n.g.a.h().s(this.r);
                if (s3 == null) {
                    b.a.p0.a.q2.a aVar4 = new b.a.p0.a.q2.a();
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
            if (b.a.p0.n.g.a.h().b(this.m, this.n, this.o, this.p, this.q)) {
                b.a.p0.a.h0.m.r.a.n(this.q);
                return null;
            }
            b.a.p0.a.q2.a aVar5 = new b.a.p0.a.q2.a();
            aVar5.j(10L);
            aVar5.h(2906L);
            aVar5.c("更新DB失败");
            return aVar5;
        }
        return (b.a.p0.a.q2.a) invokeV.objValue;
    }

    @Override // b.a.p0.n.f.g
    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.s.add(new UbcFlowEvent("na_pms_end_req"));
        }
    }

    public final void D0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            PMSAppInfo s2 = b.a.p0.n.g.a.h().s(this.r);
            b.a.p0.a.e0.d.h("SwanAppPkgDownloadCallback", "updateMainMaxAgeTime: createTime=" + s2.createTime + " lastLaunchTime=" + s2.getLastLaunchTime() + " maxAge=" + s2.maxAge);
            if (s2 != null) {
                s2.initMaxAgeInfo();
                s2.updateInstallSrc(I());
                b.a.p0.n.h.f fVar = this.m;
                if (fVar != null) {
                    fVar.f11072c = s2.createTime;
                }
                PMSAppInfo pMSAppInfo = this.q;
                if (pMSAppInfo != null) {
                    pMSAppInfo.createTime = s2.createTime;
                    pMSAppInfo.updateInstallSrc(I());
                }
                b.a.p0.n.g.a.h().k(s2);
            }
        }
    }

    @Override // b.a.p0.n.f.g
    public void F(b.a.p0.n.o.f fVar) {
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

    public f b0(b.a.p0.a.v2.e1.b<PMSAppInfo> bVar) {
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

    public synchronized f d0(b.a.p0.a.h0.m.m.a aVar) {
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
            if (TextUtils.isEmpty(this.f5530g)) {
                this.f5530g = getClass().toString();
            }
            return this.f5530g;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? b.a.p0.n.f.h.b(this, "get_launch_id").getString("launch_id", "") : (String) invokeV.objValue;
    }

    public void j0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            if (i2 == 1013) {
                b.a.p0.n.g.a.h().x(this.r, i2);
            } else {
                b.a.p0.n.g.a.h().x(this.r, 0);
            }
        }
    }

    public final void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            ArrayList arrayList = new ArrayList();
            if (this.l.d()) {
                arrayList.add(h.d.a(new j(this)));
            }
            if (this.l.f()) {
                arrayList.add(h.d.a(new k(this)));
            }
            if (this.l.c()) {
                arrayList.add(h.d.a(new l(this)));
            }
            if (this.l.b()) {
                arrayList.add(h.d.a(new m(this)));
            }
            if (arrayList.isEmpty()) {
                return;
            }
            h.d.i(arrayList).u(this.D);
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

    public final synchronized <CallbackT> f m0(@NonNull Collection<CallbackT> collection, @NonNull b.a.p0.a.v2.e1.b<CallbackT> bVar) {
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

    public final void n0(b.a.p0.n.h.b bVar) {
        h.j<? super b.a.p0.n.h.b> jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, bVar) == null) || (jVar = this.k) == null) {
            return;
        }
        jVar.onNext(bVar);
        this.k.onCompleted();
    }

    public f o0(@NonNull b.a.p0.a.v2.e1.b<b.a.p0.a.h0.m.m.a> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, bVar)) == null) {
            m0(this.v, new b(this, bVar));
            return this;
        }
        return (f) invokeL.objValue;
    }

    @Override // b.a.p0.n.f.g
    public b.a.p0.n.f.f p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.C : (b.a.p0.n.f.f) invokeV.objValue;
    }

    public void p0(PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, pMSAppInfo) == null) {
            o0(new d(this, pMSAppInfo));
        }
    }

    @Override // b.a.p0.n.f.g
    public b.a.p0.n.f.c<b.a.p0.n.h.b> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.B : (b.a.p0.n.f.c) invokeV.objValue;
    }

    public void q0(b.a.p0.a.q2.a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048601, this, aVar, z) == null) {
            o0(new c(this, aVar, z));
        }
    }

    @Override // b.a.p0.n.f.g
    public b.a.p0.n.f.c<b.a.p0.n.h.d> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.A : (b.a.p0.n.f.c) invokeV.objValue;
    }

    public void r0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || this.q == null) {
            return;
        }
        PMSAppInfo s2 = b.a.p0.n.g.a.h().s(this.r);
        if (s2 == null) {
            b.a.p0.a.e0.d.h("SwanAppPkgDownloadCallback", "Server未返回包数据，本地也没查到");
            return;
        }
        this.q.appId = this.r;
        s2.updateInstallSrc(I());
        this.q.copyLocalAppInfoData(s2);
        this.q.initMaxAgeInfo();
        if (b.a.p0.n.g.a.h().k(this.q)) {
            b.a.p0.a.h0.m.r.a.n(this.q);
        }
    }

    public void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            long currentTimeMillis = System.currentTimeMillis() - this.u;
            b.a.p0.a.e0.d.g("SwanAppPkgDownloadCallback", "pms download time : " + currentTimeMillis);
        }
    }

    @Override // b.a.p0.n.f.g
    public b.a.p0.n.f.c<b.a.p0.n.h.f> t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.y : (b.a.p0.n.f.c) invokeV.objValue;
    }

    public abstract void t0(Throwable th);

    public b.a.p0.a.q2.a u0(b.a.p0.n.h.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, bVar)) == null) {
            b.a.p0.a.p0.g.a aVar = new b.a.p0.a.p0.g.a();
            aVar.f7281b = bVar.f11078i;
            aVar.f7280a = bVar.j;
            aVar.f7282c = bVar.f11070a;
            aVar.f7283d = bVar.m;
            if (b.a.p0.a.p0.b.b(bVar.f11077h, aVar) == null) {
                return null;
            }
            b.a.p0.a.q2.a aVar2 = new b.a.p0.a.q2.a();
            aVar2.j(14L);
            aVar2.b(2908L);
            aVar2.c("Extension包更新失败");
            return aVar2;
        }
        return (b.a.p0.a.q2.a) invokeL.objValue;
    }

    public b.a.p0.a.q2.a v0(b.a.p0.n.h.d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, dVar)) == null) {
            if (E) {
                String str = "onFrameworkPkgDownload framework = " + dVar;
            }
            a.b c2 = b.a.p0.a.m2.f.a.c(dVar, dVar.f11077h);
            if (!TextUtils.isEmpty(dVar.f11070a)) {
                b.a.p0.a.e0.d.h("SwanAppPkgDownloadCallback", "#onFrameworkPkgDownload del: " + dVar.f11070a);
                b.a.p0.t.d.j(dVar.f11070a);
            }
            if (c2.c()) {
                return null;
            }
            b.a.p0.a.q2.a aVar = new b.a.p0.a.q2.a();
            aVar.j(13L);
            aVar.b(2907L);
            aVar.c("Core包更新失败");
            return aVar;
        }
        return (b.a.p0.a.q2.a) invokeL.objValue;
    }

    public b.a.p0.a.q2.a w0(b.a.p0.n.h.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, fVar)) == null) {
            if (fVar == null) {
                b.a.p0.a.q2.a aVar = new b.a.p0.a.q2.a();
                aVar.j(11L);
                aVar.h(2310L);
                aVar.e("pkg info is empty");
                b.a.p0.a.q2.e.a().f(aVar);
                return aVar;
            }
            return null;
        }
        return (b.a.p0.a.q2.a) invokeL.objValue;
    }

    public void x0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048610, this, str, str2) == null) {
            b.a.p0.a.r1.q.a.a(this.r, str, this.s, str2);
            this.s.clear();
        }
    }

    public final void y0(b.a.p0.n.h.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, bVar) == null) {
            b.a.p0.a.h0.m.c.c().d(bVar, new h(this, bVar));
        }
    }

    @Override // b.a.p0.n.f.g
    public b.a.p0.n.f.c<b.a.p0.n.h.g> z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.z : (b.a.p0.n.f.c) invokeV.objValue;
    }

    public final void z0(b.a.p0.n.h.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, dVar) == null) {
            b.a.p0.a.h0.m.c.c().d(dVar, new g(this, dVar));
        }
    }
}
