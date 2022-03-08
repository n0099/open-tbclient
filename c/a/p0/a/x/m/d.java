package c.a.p0.a.x.m;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.p2.j0;
import c.a.p0.a.p2.q;
import c.a.p0.a.q0.d;
import c.a.p0.a.x.d.a;
import c.a.p0.q.i.l.b;
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
public class d extends k {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean p;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public c.a.p0.q.o.g f8612g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.p0.a.x.m.a f8613h;

    /* renamed from: i  reason: collision with root package name */
    public final List<c.a.p0.q.h.h> f8614i;

    /* renamed from: j  reason: collision with root package name */
    public AtomicInteger f8615j;
    public boolean k;
    public final CopyOnWriteArraySet<String> l;
    public c.a.p0.q.e.a<b.a> m;
    public c.a.p0.q.e.e<c.a.p0.q.h.h> n;
    public final c.a.p0.q.e.e<c.a.p0.q.h.i> o;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f8616e;

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
            this.f8616e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean b2 = c.a.p0.q.f.a.i().b(null, this.f8616e.f8614i, null, null, null);
                if (b2) {
                    for (c.a.p0.q.h.h hVar : this.f8616e.f8614i) {
                        if (this.f8616e.f8613h != null) {
                            this.f8616e.f8613h.g(hVar);
                        }
                        this.f8616e.X();
                    }
                }
                if (d.p) {
                    String str = "update subPkgList =" + b2 + ", size=" + this.f8616e.f8614i;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b extends c.a.p0.q.e.a<b.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f8617e;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b.a f8618e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f8619f;

            public a(b bVar, b.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f8619f = bVar;
                this.f8618e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.f8619f.f8617e.W(this.f8618e)) {
                        this.f8619f.f8617e.X();
                        if (this.f8619f.f8617e.f8613h != null) {
                            this.f8619f.f8617e.f8613h.c(this.f8618e);
                        }
                        c.a.p0.a.x.m.s.a.c(this.f8618e.f11023g.appId);
                    }
                    c.a.p0.a.d0.h.b.f(this.f8618e.f11018b);
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
            this.f8617e = dVar;
        }

        @Override // c.a.p0.q.e.a
        public void l(@NonNull PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048582, this, pMSAppInfo) == null) && pMSAppInfo.isForbiddenApp()) {
                c.a.p0.a.v1.f.f0.a.K(pMSAppInfo.appId, pMSAppInfo.appStatus);
            }
        }

        @Override // c.a.p0.q.e.g
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) ? this.f8617e.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        @Override // c.a.p0.q.e.a
        public void o(b.a aVar, PMSAppInfo pMSAppInfo, c.a.p0.q.h.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar, pMSAppInfo, bVar) == null) {
                c.a.p0.a.u.d.k("SwanAppBatchDownloadCallback", "#onSingleFetchError errorNo=" + bVar.a + " errorMsg=" + bVar.f10951b + " errorDetails=" + bVar.f10953d);
                if (this.f8617e.f8613h != null) {
                    this.f8617e.f8613h.f(bVar);
                }
                if (bVar.a != 1010) {
                    this.f8617e.k = true;
                    return;
                }
                PMSAppInfo pMSAppInfo2 = aVar == null ? null : aVar.f11023g;
                if (pMSAppInfo2 == null) {
                    pMSAppInfo2 = pMSAppInfo;
                }
                this.f8617e.Y(pMSAppInfo2, pMSAppInfo);
                if (!c.a.p0.a.x.m.s.a.m(bVar) || pMSAppInfo2 == null) {
                    return;
                }
                c.a.p0.a.x.m.s.a.c(pMSAppInfo2.appId);
            }
        }

        @Override // c.a.p0.q.e.a
        public void p(@Nullable PMSAppInfo pMSAppInfo, @Nullable PMSAppInfo pMSAppInfo2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048585, this, pMSAppInfo, pMSAppInfo2) == null) {
                if (pMSAppInfo != null && pMSAppInfo.isForbiddenApp()) {
                    c.a.p0.a.v1.f.f0.a.K(pMSAppInfo.appKey, pMSAppInfo.appStatus);
                }
                this.f8617e.Y(pMSAppInfo, pMSAppInfo2);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.q.e.e
        /* renamed from: q */
        public String d(b.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, aVar)) == null) {
                if (aVar == null) {
                    return null;
                }
                int i2 = aVar.f11019c;
                if (i2 == 0) {
                    return c.a.p0.a.x.m.u.a.g();
                }
                if (i2 == 1) {
                    return c.a.p0.a.x.m.u.a.i();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.q.e.b, c.a.p0.q.e.e
        /* renamed from: r */
        public void e(b.a aVar, c.a.p0.q.h.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048587, this, aVar, bVar) == null) {
                super.e(aVar, bVar);
                c.a.p0.a.u.d.k("SwanAppBatchDownloadCallback", "onDownloadError：" + bVar.toString());
                c.a.p0.a.d0.h.b.f(aVar.f11018b);
                c.a.p0.a.k2.a aVar2 = new c.a.p0.a.k2.a();
                aVar2.k(11L);
                aVar2.i(bVar.a);
                aVar2.d("批量下载，主包下载失败：" + aVar.f11018b);
                aVar2.f(bVar.toString());
                if (aVar.a != 0) {
                    if (d.p) {
                        String str = "onDownloadError: " + aVar2.toString();
                    }
                } else if (aVar.f11020d == null) {
                } else {
                    this.f8617e.f8612g.l(aVar.f11020d);
                    c.a.p0.a.x.m.c.c().a(aVar.f11020d, PMSDownloadType.BATCH, aVar2);
                    c.a.p0.a.u.d.k("SwanAppBatchDownloadCallback", "#onDownloadError del: " + aVar.f11020d.a);
                    c.a.p0.w.d.k(aVar.f11020d.a);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.q.e.b, c.a.p0.q.e.e
        /* renamed from: s */
        public void i(b.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, aVar) == null) {
                super.i(aVar);
                c.a.p0.a.u.d.k("SwanAppBatchDownloadCallback", "onFileDownloaded: " + aVar.f11020d.f10963i);
                this.f8617e.l.add(aVar.f11018b);
                a aVar2 = new a(this, aVar);
                ExecutorUtilsExt.postOnSerial(aVar2, aVar.f11020d.f10961g + " 下载完成，执行签名校验-重命名-解压-DB");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.q.e.b, c.a.p0.q.e.e
        /* renamed from: t */
        public void a(b.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048589, this, aVar) == null) {
                super.a(aVar);
                if (d.p) {
                    String str = "onDownloadProgress: " + aVar.f11020d.f10956b + "/" + aVar.f11020d.k;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.q.e.b, c.a.p0.q.e.e
        /* renamed from: u */
        public void c(b.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048590, this, aVar) == null) {
                super.c(aVar);
                c.a.p0.a.u.d.k("SwanAppBatchDownloadCallback", "onDownloadStart: " + aVar.f11018b);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.q.e.b, c.a.p0.q.e.e
        /* renamed from: v */
        public void f(b.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048591, this, aVar) == null) {
                if (d.p) {
                    String str = "onDownloading:" + aVar.f11018b;
                }
                c.a.p0.a.d0.h.b.f(aVar.f11018b);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PMSAppInfo f8620e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PMSAppInfo f8621f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f8622g;

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
            this.f8622g = dVar;
            this.f8620e = pMSAppInfo;
            this.f8621f = pMSAppInfo2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                PMSAppInfo pMSAppInfo = this.f8620e;
                if (pMSAppInfo != null) {
                    pMSAppInfo.updateInstallSrc(this.f8622g.K());
                    this.f8621f.copyLocalAppInfoData(this.f8620e);
                } else {
                    this.f8621f.updateInstallSrc(this.f8622g.K());
                }
                this.f8621f.initMaxAgeInfo();
                if (c.a.p0.q.f.a.i().l(this.f8621f)) {
                    c.a.p0.a.x.m.u.a.o(this.f8621f);
                }
            }
        }
    }

    /* renamed from: c.a.p0.a.x.m.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0558d extends n<d> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f8623g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0558d(d dVar, d dVar2) {
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
                    super((k) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8623g = dVar;
        }

        @Override // c.a.p0.a.x.m.n
        public void p(@NonNull c.a.p0.q.h.h hVar, @Nullable c.a.p0.a.k2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, hVar, aVar) == null) {
                super.p(hVar, aVar);
                if (aVar == null) {
                    this.f8623g.f8614i.add(hVar);
                } else if (d.p) {
                    String str = "onDownloadAndUnzipFinish " + hVar + StringUtil.ARRAY_ELEMENT_SEPARATOR + aVar;
                }
                c.a.p0.a.d0.h.b.f(hVar.o);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.q.e.b, c.a.p0.q.e.e
        /* renamed from: q */
        public void e(c.a.p0.q.h.h hVar, c.a.p0.q.h.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, hVar, bVar) == null) {
                super.q(hVar, bVar);
                c.a.p0.a.d0.h.b.f(hVar.o);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.q.e.b, c.a.p0.q.e.e
        /* renamed from: u */
        public void f(c.a.p0.q.h.h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, hVar) == null) {
                super.f(hVar);
                c.a.p0.a.d0.h.b.f(hVar.o);
            }
        }
    }

    /* loaded from: classes.dex */
    public class e extends l<d> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f8624f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(d dVar, d dVar2) {
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
                    super((k) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8624f = dVar;
        }

        @Override // c.a.p0.a.x.m.l
        public void r(@NonNull c.a.p0.q.h.i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (d.p) {
                    String str = "onDownloadAndUnzipSuccess:" + iVar;
                }
                if (this.f8624f.f8613h != null) {
                    this.f8624f.f8613h.e(iVar);
                }
                this.f8624f.X();
            }
        }

        @Override // c.a.p0.a.x.m.l
        public void u(c.a.p0.q.h.i iVar, c.a.p0.a.k2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iVar, aVar) == null) {
                c.a.p0.a.u.d.k("SwanAppBatchDownloadCallback", "onDownloadOrUnzipFail:" + iVar + StringUtil.ARRAY_ELEMENT_SEPARATOR + aVar);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(78356007, "Lc/a/p0/a/x/m/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(78356007, "Lc/a/p0/a/x/m/d;");
                return;
            }
        }
        p = c.a.p0.a.a.a;
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
                this((c.a.p0.a.x.m.a) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.p0.q.e.i
    public c.a.p0.q.e.e<c.a.p0.q.h.h> B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.n : (c.a.p0.q.e.e) invokeV.objValue;
    }

    @Override // c.a.p0.q.e.i
    public void D(c.a.p0.q.h.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            super.D(bVar);
            c.a.p0.a.u.d.k("SwanAppBatchDownloadCallback", "onFetchError: " + bVar.toString());
            c.a.p0.a.x.m.a aVar = this.f8613h;
            if (aVar != null) {
                aVar.b(bVar.a);
            }
        }
    }

    @Override // c.a.p0.q.e.i
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.E();
            c.a.p0.a.u.d.k("SwanAppBatchDownloadCallback", "onFetchStart");
        }
    }

    @Override // c.a.p0.q.e.i
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.F();
            c.a.p0.a.u.d.k("SwanAppBatchDownloadCallback", "onFetchSuccess");
        }
    }

    @Override // c.a.p0.q.e.i
    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.G();
            c.a.p0.a.u.d.k("SwanAppBatchDownloadCallback", "onNoPackage");
            c.a.p0.a.x.m.a aVar = this.f8613h;
            if (aVar != null) {
                aVar.d();
            }
        }
    }

    @Override // c.a.p0.q.e.i
    public void H(c.a.p0.q.o.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, gVar) == null) {
            super.H(gVar);
            this.f8612g = gVar;
            c.a.p0.a.d0.h.b.e(gVar);
            c.a.p0.a.u.d.k("SwanAppBatchDownloadCallback", "onPrepareDownload: " + gVar.n());
        }
    }

    @Override // c.a.p0.a.x.m.k
    public int L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return 7;
        }
        return invokeV.intValue;
    }

    public final boolean W(b.a aVar) {
        InterceptResult invokeL;
        int c2;
        PMSAppInfo pMSAppInfo;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, aVar)) == null) {
            if (aVar == null || aVar.f11020d == null || aVar.f11023g == null) {
                return false;
            }
            if (!j0.a(new File(aVar.f11020d.a), aVar.f11020d.m)) {
                c.a.p0.a.u.d.k("SwanAppBatchDownloadCallback", "onMainPkgDownload: 签名校验失败");
                return false;
            }
            c.a.p0.a.k2.a m = c.a.p0.a.x.m.u.a.m(aVar.f11020d, this);
            if (m != null) {
                c.a.p0.a.u.d.k("SwanAppBatchDownloadCallback", "onMainPkgDownload: 解压失败，" + m);
                return false;
            }
            aVar.f11023g.initMaxAgeInfo();
            c.a.p0.a.x.m.u.a.k(aVar.f11023g, aVar.f11020d);
            aVar.f11023g.updateInstallSrc(K());
            if (!c.a.p0.q.f.a.i().a(aVar.f11020d, aVar.f11023g)) {
                c.a.p0.a.u.d.k("SwanAppBatchDownloadCallback", "onMainPkgDownload: 存储DB失败");
                return false;
            }
            this.f8612g.m(aVar.f11020d);
            if (!aVar.f11024h) {
                c.a.p0.a.x.m.u.a.o(aVar.f11023g);
            }
            c.a.p0.a.x.m.u.a.b(aVar.f11020d);
            c.a.p0.q.h.g gVar = aVar.f11020d;
            if (gVar != null) {
                c.a.p0.a.t1.n.d.c(d.e.i(gVar.f10961g, String.valueOf(gVar.f10963i)).getAbsolutePath(), true);
            }
            c.a.p0.q.h.g gVar2 = aVar.f11020d;
            if (gVar2 == null || gVar2.f10962h != 0 || ((c2 = a.b.c()) > 0 && (pMSAppInfo = aVar.f11023g) != null && ((i2 = pMSAppInfo.rank) == 0 || i2 > c2))) {
                return true;
            }
            c.a.p0.a.x.l.g.n.a i3 = c.a.p0.a.x.l.g.n.a.i();
            c.a.p0.q.h.g gVar3 = aVar.f11020d;
            i3.f(gVar3.f10961g, gVar3.f10963i);
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void X() {
        c.a.p0.a.x.m.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            int incrementAndGet = this.f8615j.incrementAndGet();
            int n = this.f8612g.n();
            if (p) {
                String str = "batch download,total pkg num - " + n + ",success num - " + incrementAndGet;
            }
            if (incrementAndGet != n || this.k || (aVar = this.f8613h) == null) {
                return;
            }
            aVar.a();
        }
    }

    public final void Y(@Nullable PMSAppInfo pMSAppInfo, @Nullable PMSAppInfo pMSAppInfo2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, pMSAppInfo, pMSAppInfo2) == null) || pMSAppInfo == null) {
            return;
        }
        q.k(new c(this, pMSAppInfo2, pMSAppInfo), "批量下载-只更新AppInfo-存储DB");
    }

    @Override // c.a.p0.q.e.i, c.a.p0.q.e.f
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.b();
            c.a.p0.a.u.d.k("SwanAppBatchDownloadCallback", "onTotalPkgDownloadFinish");
            boolean z = p;
            if (!this.f8614i.isEmpty()) {
                q.k(new a(this), "SwanAppBatchDownloadCallback");
            }
            c.a.p0.a.x.m.a aVar = this.f8613h;
            if (aVar != null) {
                aVar.h();
            }
            if (c.a.p0.a.d0.h.c.a()) {
                return;
            }
            c.a.p0.a.u.d.k("SwanAppBatchDownloadCallback", "#onTotalPkgDownloadFinish excludeIds=" + this.l);
            c.a.p0.a.d0.d d2 = c.a.p0.a.d0.f.c().d();
            CopyOnWriteArraySet<String> copyOnWriteArraySet = this.l;
            c.a.p0.a.d0.l.c l = c.a.p0.a.d0.l.c.l();
            l.i(7);
            d2.t(copyOnWriteArraySet, false, l.k());
        }
    }

    @Override // c.a.p0.q.e.i
    public c.a.p0.q.e.e<c.a.p0.q.h.i> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.o : (c.a.p0.q.e.e) invokeV.objValue;
    }

    @Override // c.a.p0.q.e.i
    public c.a.p0.q.e.a<b.a> w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.m : (c.a.p0.q.e.a) invokeV.objValue;
    }

    public d(c.a.p0.a.x.m.a aVar) {
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
        this.n = new C0558d(this, this);
        this.o = new e(this, this);
        this.f8613h = aVar;
        this.f8614i = new Vector();
        this.f8615j = new AtomicInteger(0);
        this.l = new CopyOnWriteArraySet<>();
    }
}
