package c.a.o0.a.h0.m;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.a.a1.e;
import c.a.o0.a.v2.j0;
import c.a.o0.a.v2.q;
import c.a.o0.n.i.l.a;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class d extends j {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean o;
    public static final boolean p;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public c.a.o0.n.o.f f6145g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.o0.a.h0.m.a f6146h;

    /* renamed from: i  reason: collision with root package name */
    public final List<c.a.o0.n.h.g> f6147i;

    /* renamed from: j  reason: collision with root package name */
    public AtomicInteger f6148j;
    public boolean k;
    public final CopyOnWriteArraySet<String> l;
    public c.a.o0.n.f.a<a.C0621a> m;
    public c.a.o0.n.f.c<c.a.o0.n.h.g> n;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f6149e;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6149e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean b2 = c.a.o0.n.g.a.h().b(null, this.f6149e.f6147i, null, null, null);
                if (b2) {
                    for (c.a.o0.n.h.g gVar : this.f6149e.f6147i) {
                        if (this.f6149e.f6146h != null) {
                            this.f6149e.f6146h.f(gVar);
                        }
                        this.f6149e.W();
                    }
                }
                if (d.o) {
                    String str = "update subPkgList =" + b2 + ", size=" + this.f6149e.f6147i;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b extends c.a.o0.n.f.a<a.C0621a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f6150e;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a.C0621a f6151e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f6152f;

            public a(b bVar, a.C0621a c0621a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, c0621a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f6152f = bVar;
                this.f6151e = c0621a;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.f6152f.f6150e.V(this.f6151e)) {
                        this.f6152f.f6150e.W();
                        if (this.f6152f.f6150e.f6146h != null) {
                            this.f6152f.f6150e.f6146h.c(this.f6151e);
                        }
                        c.a.o0.a.h0.m.p.a.c(this.f6151e.f11933f.appId);
                    }
                    c.a.o0.a.n0.h.b.f(this.f6151e.f11929b);
                }
            }
        }

        public b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6150e = dVar;
        }

        @Override // c.a.o0.n.f.a
        public void l(@NonNull PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048582, this, pMSAppInfo) == null) && pMSAppInfo.isForbiddenApp()) {
                c.a.o0.a.c2.f.g0.a.h(pMSAppInfo.appId, pMSAppInfo.appStatus);
            }
        }

        @Override // c.a.o0.n.f.e
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) ? this.f6150e.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        @Override // c.a.o0.n.f.a
        public void o(a.C0621a c0621a, PMSAppInfo pMSAppInfo, c.a.o0.n.h.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, c0621a, pMSAppInfo, aVar) == null) {
                c.a.o0.a.e0.d.h("SwanAppBatchDownloadCallback", "onSingleFetchError: " + aVar.f11847a + ",msg: " + aVar.f11848b);
                if (this.f6150e.f6146h != null) {
                    this.f6150e.f6146h.e(aVar);
                }
                if (aVar.f11847a != 1010) {
                    this.f6150e.k = true;
                    return;
                }
                PMSAppInfo pMSAppInfo2 = c0621a == null ? null : c0621a.f11933f;
                if (pMSAppInfo2 == null) {
                    pMSAppInfo2 = pMSAppInfo;
                }
                this.f6150e.X(pMSAppInfo2, pMSAppInfo);
                if (!c.a.o0.a.h0.m.p.a.m(aVar) || pMSAppInfo2 == null) {
                    return;
                }
                c.a.o0.a.h0.m.p.a.c(pMSAppInfo2.appId);
            }
        }

        @Override // c.a.o0.n.f.a
        public void p(@Nullable PMSAppInfo pMSAppInfo, @Nullable PMSAppInfo pMSAppInfo2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048585, this, pMSAppInfo, pMSAppInfo2) == null) {
                if (pMSAppInfo != null && pMSAppInfo.isForbiddenApp()) {
                    c.a.o0.a.c2.f.g0.a.h(pMSAppInfo.appKey, pMSAppInfo.appStatus);
                }
                this.f6150e.X(pMSAppInfo, pMSAppInfo2);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.n.f.c
        /* renamed from: q */
        public String d(a.C0621a c0621a) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, c0621a)) == null) {
                if (c0621a == null) {
                    return null;
                }
                int i2 = c0621a.f11930c;
                if (i2 == 0) {
                    return c.a.o0.a.h0.m.r.a.g();
                }
                if (i2 == 1) {
                    return c.a.o0.a.h0.m.r.a.i();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.n.f.b, c.a.o0.n.f.c
        /* renamed from: r */
        public void e(a.C0621a c0621a, c.a.o0.n.h.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048587, this, c0621a, aVar) == null) {
                super.e(c0621a, aVar);
                c.a.o0.a.e0.d.h("SwanAppBatchDownloadCallback", "onDownloadError：" + aVar.toString());
                c.a.o0.a.n0.h.b.f(c0621a.f11929b);
                c.a.o0.a.q2.a aVar2 = new c.a.o0.a.q2.a();
                aVar2.j(11L);
                aVar2.h(aVar.f11847a);
                aVar2.c("批量下载，主包下载失败：" + c0621a.f11929b);
                aVar2.e(aVar.toString());
                if (c0621a.f11928a != 0) {
                    if (d.o) {
                        String str = "onDownloadError: " + aVar2.toString();
                    }
                } else if (c0621a.f11931d == null) {
                } else {
                    this.f6150e.f6145g.j(c0621a.f11931d);
                    c.a.o0.a.h0.m.c.c().a(c0621a.f11931d, PMSDownloadType.BATCH, aVar2);
                    c.a.o0.a.e0.d.h("SwanAppBatchDownloadCallback", "#onDownloadError del: " + c0621a.f11931d.f11851a);
                    c.a.o0.t.d.j(c0621a.f11931d.f11851a);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.n.f.b, c.a.o0.n.f.c
        /* renamed from: s */
        public void i(a.C0621a c0621a) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, c0621a) == null) {
                super.i(c0621a);
                c.a.o0.a.e0.d.h("SwanAppBatchDownloadCallback", "onFileDownloaded: " + c0621a.f11931d.f11859i);
                this.f6150e.l.add(c0621a.f11929b);
                a aVar = new a(this, c0621a);
                String str = c0621a.f11931d.f11857g + " 下载完成，执行签名校验-重命名-解压-DB";
                if (d.p) {
                    ExecutorUtilsExt.postOnSerial(aVar, str);
                } else {
                    q.j(aVar, str);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.n.f.b, c.a.o0.n.f.c
        /* renamed from: t */
        public void a(a.C0621a c0621a) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048589, this, c0621a) == null) {
                super.a(c0621a);
                if (d.o) {
                    String str = "onDownloadProgress: " + c0621a.f11931d.f11852b + "/" + c0621a.f11931d.k;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.n.f.b, c.a.o0.n.f.c
        /* renamed from: u */
        public void c(a.C0621a c0621a) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048590, this, c0621a) == null) {
                super.c(c0621a);
                c.a.o0.a.e0.d.h("SwanAppBatchDownloadCallback", "onDownloadStart: " + c0621a.f11929b);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.n.f.b, c.a.o0.n.f.c
        /* renamed from: v */
        public void f(a.C0621a c0621a) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048591, this, c0621a) == null) {
                if (d.o) {
                    String str = "onDownloading:" + c0621a.f11929b;
                }
                c.a.o0.a.n0.h.b.f(c0621a.f11929b);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PMSAppInfo f6153e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PMSAppInfo f6154f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f6155g;

        public c(d dVar, PMSAppInfo pMSAppInfo, PMSAppInfo pMSAppInfo2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, pMSAppInfo, pMSAppInfo2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6155g = dVar;
            this.f6153e = pMSAppInfo;
            this.f6154f = pMSAppInfo2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                PMSAppInfo pMSAppInfo = this.f6153e;
                if (pMSAppInfo != null) {
                    pMSAppInfo.updateInstallSrc(this.f6155g.I());
                    this.f6154f.copyLocalAppInfoData(this.f6153e);
                } else {
                    this.f6154f.updateInstallSrc(this.f6155g.I());
                }
                this.f6154f.initMaxAgeInfo();
                if (c.a.o0.n.g.a.h().k(this.f6154f)) {
                    c.a.o0.a.h0.m.r.a.n(this.f6154f);
                }
            }
        }
    }

    /* renamed from: c.a.o0.a.h0.m.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0227d extends k<d> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f6156g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0227d(d dVar, d dVar2) {
            super(dVar2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, dVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((j) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6156g = dVar;
        }

        @Override // c.a.o0.a.h0.m.k
        public void p(@NonNull c.a.o0.n.h.g gVar, @Nullable c.a.o0.a.q2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, gVar, aVar) == null) {
                super.p(gVar, aVar);
                if (aVar == null) {
                    this.f6156g.f6147i.add(gVar);
                } else if (d.o) {
                    String str = "onDownloadAndUnzipFinish " + gVar + StringUtil.ARRAY_ELEMENT_SEPARATOR + aVar;
                }
                c.a.o0.a.n0.h.b.f(gVar.o);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.n.f.b, c.a.o0.n.f.c
        /* renamed from: q */
        public void e(c.a.o0.n.h.g gVar, c.a.o0.n.h.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, gVar, aVar) == null) {
                super.q(gVar, aVar);
                c.a.o0.a.n0.h.b.f(gVar.o);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.n.f.b, c.a.o0.n.f.c
        /* renamed from: u */
        public void f(c.a.o0.n.h.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, gVar) == null) {
                super.f(gVar);
                c.a.o0.a.n0.h.b.f(gVar.o);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(957964778, "Lc/a/o0/a/h0/m/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(957964778, "Lc/a/o0/a/h0/m/d;");
                return;
            }
        }
        o = c.a.o0.a.k.f7049a;
        c.a.o0.a.c1.a.Z().getSwitch("swan_pkg_download_finish_unzip_task_serial", false);
        p = false;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public d() {
        this(null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((c.a.o0.a.h0.m.a) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.o0.n.f.g
    public void B(c.a.o0.n.h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            super.B(aVar);
            c.a.o0.a.e0.d.h("SwanAppBatchDownloadCallback", "onFetchError: " + aVar.toString());
            c.a.o0.a.h0.m.a aVar2 = this.f6146h;
            if (aVar2 != null) {
                aVar2.b(aVar.f11847a);
            }
        }
    }

    @Override // c.a.o0.n.f.g
    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.C();
            c.a.o0.a.e0.d.h("SwanAppBatchDownloadCallback", "onFetchStart");
        }
    }

    @Override // c.a.o0.n.f.g
    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.D();
            c.a.o0.a.e0.d.h("SwanAppBatchDownloadCallback", "onFetchSuccess");
        }
    }

    @Override // c.a.o0.n.f.g
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.E();
            c.a.o0.a.e0.d.h("SwanAppBatchDownloadCallback", "onNoPackage");
            c.a.o0.a.h0.m.a aVar = this.f6146h;
            if (aVar != null) {
                aVar.d();
            }
        }
    }

    @Override // c.a.o0.n.f.g
    public void F(c.a.o0.n.o.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, fVar) == null) {
            super.F(fVar);
            this.f6145g = fVar;
            c.a.o0.a.n0.h.b.e(fVar);
            c.a.o0.a.e0.d.h("SwanAppBatchDownloadCallback", "onPrepareDownload: " + fVar.l());
        }
    }

    @Override // c.a.o0.a.h0.m.j
    public int J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return 7;
        }
        return invokeV.intValue;
    }

    public final boolean V(a.C0621a c0621a) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, c0621a)) == null) {
            if (c0621a == null || c0621a.f11931d == null || c0621a.f11933f == null) {
                return false;
            }
            if (!j0.a(new File(c0621a.f11931d.f11851a), c0621a.f11931d.m)) {
                c.a.o0.a.e0.d.h("SwanAppBatchDownloadCallback", "onMainPkgDownload: 签名校验失败");
                return false;
            }
            c.a.o0.a.q2.a l = c.a.o0.a.h0.m.r.a.l(c0621a.f11931d, this);
            if (l != null) {
                c.a.o0.a.e0.d.h("SwanAppBatchDownloadCallback", "onMainPkgDownload: 解压失败，" + l);
                return false;
            }
            c0621a.f11933f.initMaxAgeInfo();
            c.a.o0.a.h0.m.r.a.j(c0621a.f11933f, c0621a.f11931d);
            c0621a.f11933f.updateInstallSrc(I());
            if (!c.a.o0.n.g.a.h().a(c0621a.f11931d, c0621a.f11933f)) {
                c.a.o0.a.e0.d.h("SwanAppBatchDownloadCallback", "onMainPkgDownload: 存储DB失败");
                return false;
            }
            this.f6145g.k(c0621a.f11931d);
            if (!c0621a.f11934g) {
                c.a.o0.a.h0.m.r.a.n(c0621a.f11933f);
            }
            c.a.o0.a.h0.m.r.a.b(c0621a.f11931d);
            c.a.o0.n.h.f fVar = c0621a.f11931d;
            if (fVar != null) {
                c.a.o0.a.a2.n.d.c(e.C0112e.i(fVar.f11857g, String.valueOf(fVar.f11859i)).getAbsolutePath(), true);
            }
            c.a.o0.n.h.f fVar2 = c0621a.f11931d;
            if (fVar2 != null && fVar2.f11858h == 0) {
                c.a.o0.a.h0.l.g.n.a i2 = c.a.o0.a.h0.l.g.n.a.i();
                c.a.o0.n.h.f fVar3 = c0621a.f11931d;
                i2.f(fVar3.f11857g, fVar3.f11859i);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void W() {
        c.a.o0.a.h0.m.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            int incrementAndGet = this.f6148j.incrementAndGet();
            int l = this.f6145g.l();
            if (o) {
                String str = "batch download,total pkg num - " + l + ",success num - " + incrementAndGet;
            }
            if (incrementAndGet != l || this.k || (aVar = this.f6146h) == null) {
                return;
            }
            aVar.a();
        }
    }

    public final void X(@Nullable PMSAppInfo pMSAppInfo, @Nullable PMSAppInfo pMSAppInfo2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, pMSAppInfo, pMSAppInfo2) == null) || pMSAppInfo == null) {
            return;
        }
        q.j(new c(this, pMSAppInfo2, pMSAppInfo), "批量下载-只更新AppInfo-存储DB");
    }

    @Override // c.a.o0.n.f.g, c.a.o0.n.f.d
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.b();
            c.a.o0.a.e0.d.h("SwanAppBatchDownloadCallback", "onTotalPkgDownloadFinish");
            boolean z = o;
            if (!this.f6147i.isEmpty()) {
                q.j(new a(this), "SwanAppBatchDownloadCallback");
            }
            c.a.o0.a.h0.m.a aVar = this.f6146h;
            if (aVar != null) {
                aVar.g();
            }
            if (c.a.o0.a.n0.h.c.a()) {
                return;
            }
            c.a.o0.a.e0.d.h("SwanAppBatchDownloadCallback", "#onTotalPkgDownloadFinish excludeIds=" + this.l);
            c.a.o0.a.n0.d d2 = c.a.o0.a.n0.f.c().d();
            CopyOnWriteArraySet<String> copyOnWriteArraySet = this.l;
            c.a.o0.a.n0.l.c l = c.a.o0.a.n0.l.c.l();
            l.i(7);
            d2.t(copyOnWriteArraySet, false, l.k());
        }
    }

    @Override // c.a.o0.n.f.g
    public c.a.o0.n.f.a<a.C0621a> u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.m : (c.a.o0.n.f.a) invokeV.objValue;
    }

    @Override // c.a.o0.n.f.g
    public c.a.o0.n.f.c<c.a.o0.n.h.g> z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.n : (c.a.o0.n.f.c) invokeV.objValue;
    }

    public d(c.a.o0.a.h0.m.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.m = new b(this);
        this.n = new C0227d(this, this);
        this.f6146h = aVar;
        this.f6147i = new Vector();
        this.f6148j = new AtomicInteger(0);
        this.l = new CopyOnWriteArraySet<>();
    }
}
