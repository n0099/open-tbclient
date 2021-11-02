package b.a.p0.a.h0.m;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.a1.e;
import b.a.p0.a.v2.j0;
import b.a.p0.a.v2.q;
import b.a.p0.n.i.l.a;
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
    public b.a.p0.n.o.f f5519g;

    /* renamed from: h  reason: collision with root package name */
    public b.a.p0.a.h0.m.a f5520h;

    /* renamed from: i  reason: collision with root package name */
    public final List<b.a.p0.n.h.g> f5521i;
    public AtomicInteger j;
    public boolean k;
    public final CopyOnWriteArraySet<String> l;
    public b.a.p0.n.f.a<a.C0618a> m;
    public b.a.p0.n.f.c<b.a.p0.n.h.g> n;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f5522e;

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
            this.f5522e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean b2 = b.a.p0.n.g.a.h().b(null, this.f5522e.f5521i, null, null, null);
                if (b2) {
                    for (b.a.p0.n.h.g gVar : this.f5522e.f5521i) {
                        if (this.f5522e.f5520h != null) {
                            this.f5522e.f5520h.f(gVar);
                        }
                        this.f5522e.W();
                    }
                }
                if (d.o) {
                    String str = "update subPkgList =" + b2 + ", size=" + this.f5522e.f5521i;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b extends b.a.p0.n.f.a<a.C0618a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f5523e;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a.C0618a f5524e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f5525f;

            public a(b bVar, a.C0618a c0618a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, c0618a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f5525f = bVar;
                this.f5524e = c0618a;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.f5525f.f5523e.V(this.f5524e)) {
                        this.f5525f.f5523e.W();
                        if (this.f5525f.f5523e.f5520h != null) {
                            this.f5525f.f5523e.f5520h.c(this.f5524e);
                        }
                        b.a.p0.a.h0.m.p.a.c(this.f5524e.f11150f.appId);
                    }
                    b.a.p0.a.n0.h.b.f(this.f5524e.f11146b);
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
            this.f5523e = dVar;
        }

        @Override // b.a.p0.n.f.a
        public void l(@NonNull PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048582, this, pMSAppInfo) == null) && pMSAppInfo.isForbiddenApp()) {
                b.a.p0.a.c2.f.g0.a.h(pMSAppInfo.appId, pMSAppInfo.appStatus);
            }
        }

        @Override // b.a.p0.n.f.e
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) ? this.f5523e.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        @Override // b.a.p0.n.f.a
        public void o(a.C0618a c0618a, PMSAppInfo pMSAppInfo, b.a.p0.n.h.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, c0618a, pMSAppInfo, aVar) == null) {
                b.a.p0.a.e0.d.h("SwanAppBatchDownloadCallback", "onSingleFetchError: " + aVar.f11066a + ",msg: " + aVar.f11067b);
                if (this.f5523e.f5520h != null) {
                    this.f5523e.f5520h.e(aVar);
                }
                if (aVar.f11066a != 1010) {
                    this.f5523e.k = true;
                    return;
                }
                PMSAppInfo pMSAppInfo2 = c0618a == null ? null : c0618a.f11150f;
                if (pMSAppInfo2 == null) {
                    pMSAppInfo2 = pMSAppInfo;
                }
                this.f5523e.X(pMSAppInfo2, pMSAppInfo);
                if (!b.a.p0.a.h0.m.p.a.m(aVar) || pMSAppInfo2 == null) {
                    return;
                }
                b.a.p0.a.h0.m.p.a.c(pMSAppInfo2.appId);
            }
        }

        @Override // b.a.p0.n.f.a
        public void p(@Nullable PMSAppInfo pMSAppInfo, @Nullable PMSAppInfo pMSAppInfo2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048585, this, pMSAppInfo, pMSAppInfo2) == null) {
                if (pMSAppInfo != null && pMSAppInfo.isForbiddenApp()) {
                    b.a.p0.a.c2.f.g0.a.h(pMSAppInfo.appKey, pMSAppInfo.appStatus);
                }
                this.f5523e.X(pMSAppInfo, pMSAppInfo2);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.n.f.c
        /* renamed from: q */
        public String d(a.C0618a c0618a) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, c0618a)) == null) {
                if (c0618a == null) {
                    return null;
                }
                int i2 = c0618a.f11147c;
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.n.f.b, b.a.p0.n.f.c
        /* renamed from: r */
        public void e(a.C0618a c0618a, b.a.p0.n.h.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048587, this, c0618a, aVar) == null) {
                super.e(c0618a, aVar);
                b.a.p0.a.e0.d.h("SwanAppBatchDownloadCallback", "onDownloadError：" + aVar.toString());
                b.a.p0.a.n0.h.b.f(c0618a.f11146b);
                b.a.p0.a.q2.a aVar2 = new b.a.p0.a.q2.a();
                aVar2.j(11L);
                aVar2.h(aVar.f11066a);
                aVar2.c("批量下载，主包下载失败：" + c0618a.f11146b);
                aVar2.e(aVar.toString());
                if (c0618a.f11145a != 0) {
                    if (d.o) {
                        String str = "onDownloadError: " + aVar2.toString();
                    }
                } else if (c0618a.f11148d == null) {
                } else {
                    this.f5523e.f5519g.j(c0618a.f11148d);
                    b.a.p0.a.h0.m.c.c().a(c0618a.f11148d, PMSDownloadType.BATCH, aVar2);
                    b.a.p0.a.e0.d.h("SwanAppBatchDownloadCallback", "#onDownloadError del: " + c0618a.f11148d.f11070a);
                    b.a.p0.t.d.j(c0618a.f11148d.f11070a);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.n.f.b, b.a.p0.n.f.c
        /* renamed from: s */
        public void i(a.C0618a c0618a) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, c0618a) == null) {
                super.i(c0618a);
                b.a.p0.a.e0.d.h("SwanAppBatchDownloadCallback", "onFileDownloaded: " + c0618a.f11148d.f11078i);
                this.f5523e.l.add(c0618a.f11146b);
                a aVar = new a(this, c0618a);
                String str = c0618a.f11148d.f11076g + " 下载完成，执行签名校验-重命名-解压-DB";
                if (d.p) {
                    ExecutorUtilsExt.postOnSerial(aVar, str);
                } else {
                    q.j(aVar, str);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.n.f.b, b.a.p0.n.f.c
        /* renamed from: t */
        public void a(a.C0618a c0618a) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048589, this, c0618a) == null) {
                super.a(c0618a);
                if (d.o) {
                    String str = "onDownloadProgress: " + c0618a.f11148d.f11071b + "/" + c0618a.f11148d.k;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.n.f.b, b.a.p0.n.f.c
        /* renamed from: u */
        public void c(a.C0618a c0618a) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048590, this, c0618a) == null) {
                super.c(c0618a);
                b.a.p0.a.e0.d.h("SwanAppBatchDownloadCallback", "onDownloadStart: " + c0618a.f11146b);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.n.f.b, b.a.p0.n.f.c
        /* renamed from: v */
        public void f(a.C0618a c0618a) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048591, this, c0618a) == null) {
                if (d.o) {
                    String str = "onDownloading:" + c0618a.f11146b;
                }
                b.a.p0.a.n0.h.b.f(c0618a.f11146b);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PMSAppInfo f5526e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PMSAppInfo f5527f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f5528g;

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
            this.f5528g = dVar;
            this.f5526e = pMSAppInfo;
            this.f5527f = pMSAppInfo2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                PMSAppInfo pMSAppInfo = this.f5526e;
                if (pMSAppInfo != null) {
                    pMSAppInfo.updateInstallSrc(this.f5528g.I());
                    this.f5527f.copyLocalAppInfoData(this.f5526e);
                } else {
                    this.f5527f.updateInstallSrc(this.f5528g.I());
                }
                this.f5527f.initMaxAgeInfo();
                if (b.a.p0.n.g.a.h().k(this.f5527f)) {
                    b.a.p0.a.h0.m.r.a.n(this.f5527f);
                }
            }
        }
    }

    /* renamed from: b.a.p0.a.h0.m.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0224d extends k<d> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f5529g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0224d(d dVar, d dVar2) {
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
            this.f5529g = dVar;
        }

        @Override // b.a.p0.a.h0.m.k
        public void p(@NonNull b.a.p0.n.h.g gVar, @Nullable b.a.p0.a.q2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, gVar, aVar) == null) {
                super.p(gVar, aVar);
                if (aVar == null) {
                    this.f5529g.f5521i.add(gVar);
                } else if (d.o) {
                    String str = "onDownloadAndUnzipFinish " + gVar + StringUtil.ARRAY_ELEMENT_SEPARATOR + aVar;
                }
                b.a.p0.a.n0.h.b.f(gVar.o);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.n.f.b, b.a.p0.n.f.c
        /* renamed from: q */
        public void e(b.a.p0.n.h.g gVar, b.a.p0.n.h.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, gVar, aVar) == null) {
                super.q(gVar, aVar);
                b.a.p0.a.n0.h.b.f(gVar.o);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.n.f.b, b.a.p0.n.f.c
        /* renamed from: u */
        public void f(b.a.p0.n.h.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, gVar) == null) {
                super.f(gVar);
                b.a.p0.a.n0.h.b.f(gVar.o);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1597581674, "Lb/a/p0/a/h0/m/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1597581674, "Lb/a/p0/a/h0/m/d;");
                return;
            }
        }
        o = b.a.p0.a.k.f6397a;
        b.a.p0.a.c1.a.Z().getSwitch("swan_pkg_download_finish_unzip_task_serial", false);
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
                this((b.a.p0.a.h0.m.a) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // b.a.p0.n.f.g
    public void B(b.a.p0.n.h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            super.B(aVar);
            b.a.p0.a.e0.d.h("SwanAppBatchDownloadCallback", "onFetchError: " + aVar.toString());
            b.a.p0.a.h0.m.a aVar2 = this.f5520h;
            if (aVar2 != null) {
                aVar2.b(aVar.f11066a);
            }
        }
    }

    @Override // b.a.p0.n.f.g
    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.C();
            b.a.p0.a.e0.d.h("SwanAppBatchDownloadCallback", "onFetchStart");
        }
    }

    @Override // b.a.p0.n.f.g
    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.D();
            b.a.p0.a.e0.d.h("SwanAppBatchDownloadCallback", "onFetchSuccess");
        }
    }

    @Override // b.a.p0.n.f.g
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.E();
            b.a.p0.a.e0.d.h("SwanAppBatchDownloadCallback", "onNoPackage");
            b.a.p0.a.h0.m.a aVar = this.f5520h;
            if (aVar != null) {
                aVar.d();
            }
        }
    }

    @Override // b.a.p0.n.f.g
    public void F(b.a.p0.n.o.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, fVar) == null) {
            super.F(fVar);
            this.f5519g = fVar;
            b.a.p0.a.n0.h.b.e(fVar);
            b.a.p0.a.e0.d.h("SwanAppBatchDownloadCallback", "onPrepareDownload: " + fVar.l());
        }
    }

    @Override // b.a.p0.a.h0.m.j
    public int J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return 7;
        }
        return invokeV.intValue;
    }

    public final boolean V(a.C0618a c0618a) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, c0618a)) == null) {
            if (c0618a == null || c0618a.f11148d == null || c0618a.f11150f == null) {
                return false;
            }
            if (!j0.a(new File(c0618a.f11148d.f11070a), c0618a.f11148d.m)) {
                b.a.p0.a.e0.d.h("SwanAppBatchDownloadCallback", "onMainPkgDownload: 签名校验失败");
                return false;
            }
            b.a.p0.a.q2.a l = b.a.p0.a.h0.m.r.a.l(c0618a.f11148d, this);
            if (l != null) {
                b.a.p0.a.e0.d.h("SwanAppBatchDownloadCallback", "onMainPkgDownload: 解压失败，" + l);
                return false;
            }
            c0618a.f11150f.initMaxAgeInfo();
            b.a.p0.a.h0.m.r.a.j(c0618a.f11150f, c0618a.f11148d);
            c0618a.f11150f.updateInstallSrc(I());
            if (!b.a.p0.n.g.a.h().a(c0618a.f11148d, c0618a.f11150f)) {
                b.a.p0.a.e0.d.h("SwanAppBatchDownloadCallback", "onMainPkgDownload: 存储DB失败");
                return false;
            }
            this.f5519g.k(c0618a.f11148d);
            if (!c0618a.f11151g) {
                b.a.p0.a.h0.m.r.a.n(c0618a.f11150f);
            }
            b.a.p0.a.h0.m.r.a.b(c0618a.f11148d);
            b.a.p0.n.h.f fVar = c0618a.f11148d;
            if (fVar != null) {
                b.a.p0.a.a2.n.d.c(e.C0109e.i(fVar.f11076g, String.valueOf(fVar.f11078i)).getAbsolutePath(), true);
            }
            b.a.p0.n.h.f fVar2 = c0618a.f11148d;
            if (fVar2 != null && fVar2.f11077h == 0) {
                b.a.p0.a.h0.l.g.n.a i2 = b.a.p0.a.h0.l.g.n.a.i();
                b.a.p0.n.h.f fVar3 = c0618a.f11148d;
                i2.f(fVar3.f11076g, fVar3.f11078i);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void W() {
        b.a.p0.a.h0.m.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            int incrementAndGet = this.j.incrementAndGet();
            int l = this.f5519g.l();
            if (o) {
                String str = "batch download,total pkg num - " + l + ",success num - " + incrementAndGet;
            }
            if (incrementAndGet != l || this.k || (aVar = this.f5520h) == null) {
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

    @Override // b.a.p0.n.f.g, b.a.p0.n.f.d
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.b();
            b.a.p0.a.e0.d.h("SwanAppBatchDownloadCallback", "onTotalPkgDownloadFinish");
            boolean z = o;
            if (!this.f5521i.isEmpty()) {
                q.j(new a(this), "SwanAppBatchDownloadCallback");
            }
            b.a.p0.a.h0.m.a aVar = this.f5520h;
            if (aVar != null) {
                aVar.g();
            }
            if (b.a.p0.a.n0.h.c.a()) {
                return;
            }
            b.a.p0.a.e0.d.h("SwanAppBatchDownloadCallback", "#onTotalPkgDownloadFinish excludeIds=" + this.l);
            b.a.p0.a.n0.d d2 = b.a.p0.a.n0.f.c().d();
            CopyOnWriteArraySet<String> copyOnWriteArraySet = this.l;
            b.a.p0.a.n0.l.c l = b.a.p0.a.n0.l.c.l();
            l.i(7);
            d2.t(copyOnWriteArraySet, false, l.k());
        }
    }

    @Override // b.a.p0.n.f.g
    public b.a.p0.n.f.a<a.C0618a> u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.m : (b.a.p0.n.f.a) invokeV.objValue;
    }

    @Override // b.a.p0.n.f.g
    public b.a.p0.n.f.c<b.a.p0.n.h.g> z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.n : (b.a.p0.n.f.c) invokeV.objValue;
    }

    public d(b.a.p0.a.h0.m.a aVar) {
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
        this.n = new C0224d(this, this);
        this.f5520h = aVar;
        this.f5521i = new Vector();
        this.j = new AtomicInteger(0);
        this.l = new CopyOnWriteArraySet<>();
    }
}
