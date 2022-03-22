package c.a.n0.a.x.m;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.p2.j0;
import c.a.n0.a.p2.q;
import c.a.n0.a.q0.d;
import c.a.n0.a.x.d.a;
import c.a.n0.q.i.l.b;
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
    public static final boolean l;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public c.a.n0.q.o.g f7243c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.n0.a.x.m.a f7244d;

    /* renamed from: e  reason: collision with root package name */
    public final List<c.a.n0.q.h.h> f7245e;

    /* renamed from: f  reason: collision with root package name */
    public AtomicInteger f7246f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f7247g;

    /* renamed from: h  reason: collision with root package name */
    public final CopyOnWriteArraySet<String> f7248h;
    public c.a.n0.q.e.a<b.a> i;
    public c.a.n0.q.e.e<c.a.n0.q.h.h> j;
    public final c.a.n0.q.e.e<c.a.n0.q.h.i> k;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean b2 = c.a.n0.q.f.a.i().b(null, this.a.f7245e, null, null, null);
                if (b2) {
                    for (c.a.n0.q.h.h hVar : this.a.f7245e) {
                        if (this.a.f7244d != null) {
                            this.a.f7244d.g(hVar);
                        }
                        this.a.X();
                    }
                }
                if (d.l) {
                    Log.e("SwanAppBatchDownloadCallback", "update subPkgList =" + b2 + ", size=" + this.a.f7245e);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b extends c.a.n0.q.e.a<b.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b.a a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ b f7249b;

            public a(b bVar, b.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f7249b = bVar;
                this.a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.f7249b.a.W(this.a)) {
                        this.f7249b.a.X();
                        if (this.f7249b.a.f7244d != null) {
                            this.f7249b.a.f7244d.c(this.a);
                        }
                        c.a.n0.a.x.m.s.a.c(this.a.f9200g.appId);
                    }
                    c.a.n0.a.d0.h.b.f(this.a.f9195b);
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // c.a.n0.q.e.a
        public void l(@NonNull PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048582, this, pMSAppInfo) == null) && pMSAppInfo.isForbiddenApp()) {
                c.a.n0.a.v1.f.f0.a.K(pMSAppInfo.appId, pMSAppInfo.appStatus);
            }
        }

        @Override // c.a.n0.q.e.g
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) ? this.a.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        @Override // c.a.n0.q.e.a
        public void o(b.a aVar, PMSAppInfo pMSAppInfo, c.a.n0.q.h.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar, pMSAppInfo, bVar) == null) {
                c.a.n0.a.u.d.k("SwanAppBatchDownloadCallback", "#onSingleFetchError errorNo=" + bVar.a + " errorMsg=" + bVar.f9135b + " errorDetails=" + bVar.f9137d);
                if (this.a.f7244d != null) {
                    this.a.f7244d.f(bVar);
                }
                if (bVar.a != 1010) {
                    this.a.f7247g = true;
                    return;
                }
                PMSAppInfo pMSAppInfo2 = aVar == null ? null : aVar.f9200g;
                if (pMSAppInfo2 == null) {
                    pMSAppInfo2 = pMSAppInfo;
                }
                this.a.Y(pMSAppInfo2, pMSAppInfo);
                if (!c.a.n0.a.x.m.s.a.m(bVar) || pMSAppInfo2 == null) {
                    return;
                }
                c.a.n0.a.x.m.s.a.c(pMSAppInfo2.appId);
            }
        }

        @Override // c.a.n0.q.e.a
        public void p(@Nullable PMSAppInfo pMSAppInfo, @Nullable PMSAppInfo pMSAppInfo2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048585, this, pMSAppInfo, pMSAppInfo2) == null) {
                if (pMSAppInfo != null && pMSAppInfo.isForbiddenApp()) {
                    c.a.n0.a.v1.f.f0.a.K(pMSAppInfo.appKey, pMSAppInfo.appStatus);
                }
                this.a.Y(pMSAppInfo, pMSAppInfo2);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.q.e.e
        /* renamed from: q */
        public String d(b.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, aVar)) == null) {
                if (aVar == null) {
                    return null;
                }
                int i = aVar.f9196c;
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.q.e.b, c.a.n0.q.e.e
        /* renamed from: r */
        public void e(b.a aVar, c.a.n0.q.h.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048587, this, aVar, bVar) == null) {
                super.e(aVar, bVar);
                c.a.n0.a.u.d.k("SwanAppBatchDownloadCallback", "onDownloadError：" + bVar.toString());
                c.a.n0.a.d0.h.b.f(aVar.f9195b);
                c.a.n0.a.k2.a aVar2 = new c.a.n0.a.k2.a();
                aVar2.k(11L);
                aVar2.i(bVar.a);
                aVar2.d("批量下载，主包下载失败：" + aVar.f9195b);
                aVar2.f(bVar.toString());
                if (aVar.a != 0) {
                    if (d.l) {
                        Log.e("SwanAppBatchDownloadCallback", "onDownloadError: " + aVar2.toString());
                    }
                } else if (aVar.f9197d == null) {
                } else {
                    this.a.f7243c.l(aVar.f9197d);
                    c.a.n0.a.x.m.c.c().a(aVar.f9197d, PMSDownloadType.BATCH, aVar2);
                    c.a.n0.a.u.d.k("SwanAppBatchDownloadCallback", "#onDownloadError del: " + aVar.f9197d.a);
                    c.a.n0.w.d.k(aVar.f9197d.a);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.q.e.b, c.a.n0.q.e.e
        /* renamed from: s */
        public void i(b.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, aVar) == null) {
                super.i(aVar);
                c.a.n0.a.u.d.k("SwanAppBatchDownloadCallback", "onFileDownloaded: " + aVar.f9197d.i);
                this.a.f7248h.add(aVar.f9195b);
                a aVar2 = new a(this, aVar);
                ExecutorUtilsExt.postOnSerial(aVar2, aVar.f9197d.f9145g + " 下载完成，执行签名校验-重命名-解压-DB");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.q.e.b, c.a.n0.q.e.e
        /* renamed from: t */
        public void a(b.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048589, this, aVar) == null) {
                super.a(aVar);
                if (d.l) {
                    Log.i("SwanAppBatchDownloadCallback", "onDownloadProgress: " + aVar.f9197d.f9140b + "/" + aVar.f9197d.k);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.q.e.b, c.a.n0.q.e.e
        /* renamed from: u */
        public void c(b.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048590, this, aVar) == null) {
                super.c(aVar);
                c.a.n0.a.u.d.k("SwanAppBatchDownloadCallback", "onDownloadStart: " + aVar.f9195b);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.q.e.b, c.a.n0.q.e.e
        /* renamed from: v */
        public void f(b.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048591, this, aVar) == null) {
                if (d.l) {
                    Log.i("SwanAppBatchDownloadCallback", "onDownloading:" + aVar.f9195b);
                }
                c.a.n0.a.d0.h.b.f(aVar.f9195b);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PMSAppInfo a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PMSAppInfo f7250b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d f7251c;

        public c(d dVar, PMSAppInfo pMSAppInfo, PMSAppInfo pMSAppInfo2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, pMSAppInfo, pMSAppInfo2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7251c = dVar;
            this.a = pMSAppInfo;
            this.f7250b = pMSAppInfo2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                PMSAppInfo pMSAppInfo = this.a;
                if (pMSAppInfo != null) {
                    pMSAppInfo.updateInstallSrc(this.f7251c.K());
                    this.f7250b.copyLocalAppInfoData(this.a);
                } else {
                    this.f7250b.updateInstallSrc(this.f7251c.K());
                }
                this.f7250b.initMaxAgeInfo();
                if (c.a.n0.q.f.a.i().l(this.f7250b)) {
                    c.a.n0.a.x.m.u.a.o(this.f7250b);
                }
            }
        }
    }

    /* renamed from: c.a.n0.a.x.m.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0550d extends n<d> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d f7252c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0550d(d dVar, d dVar2) {
            super(dVar2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, dVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((k) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7252c = dVar;
        }

        @Override // c.a.n0.a.x.m.n
        public void p(@NonNull c.a.n0.q.h.h hVar, @Nullable c.a.n0.a.k2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, hVar, aVar) == null) {
                super.p(hVar, aVar);
                if (aVar == null) {
                    this.f7252c.f7245e.add(hVar);
                } else if (d.l) {
                    Log.w("SwanAppBatchDownloadCallback", "onDownloadAndUnzipFinish " + hVar + StringUtil.ARRAY_ELEMENT_SEPARATOR + aVar);
                }
                c.a.n0.a.d0.h.b.f(hVar.o);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.q.e.b, c.a.n0.q.e.e
        /* renamed from: q */
        public void e(c.a.n0.q.h.h hVar, c.a.n0.q.h.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, hVar, bVar) == null) {
                super.q(hVar, bVar);
                c.a.n0.a.d0.h.b.f(hVar.o);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.q.e.b, c.a.n0.q.e.e
        /* renamed from: u */
        public void f(c.a.n0.q.h.h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, hVar) == null) {
                super.f(hVar);
                c.a.n0.a.d0.h.b.f(hVar.o);
            }
        }
    }

    /* loaded from: classes.dex */
    public class e extends l<d> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f7253b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(d dVar, d dVar2) {
            super(dVar2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, dVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((k) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7253b = dVar;
        }

        @Override // c.a.n0.a.x.m.l
        public void r(@NonNull c.a.n0.q.h.i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (d.l) {
                    Log.v("SwanAppBatchDownloadCallback", "onDownloadAndUnzipSuccess:" + iVar);
                }
                if (this.f7253b.f7244d != null) {
                    this.f7253b.f7244d.e(iVar);
                }
                this.f7253b.X();
            }
        }

        @Override // c.a.n0.a.x.m.l
        public void u(c.a.n0.q.h.i iVar, c.a.n0.a.k2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iVar, aVar) == null) {
                c.a.n0.a.u.d.k("SwanAppBatchDownloadCallback", "onDownloadOrUnzipFail:" + iVar + StringUtil.ARRAY_ELEMENT_SEPARATOR + aVar);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-622708571, "Lc/a/n0/a/x/m/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-622708571, "Lc/a/n0/a/x/m/d;");
                return;
            }
        }
        l = c.a.n0.a.a.a;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public d() {
        this(null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this((c.a.n0.a.x.m.a) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.n0.q.e.i
    public c.a.n0.q.e.e<c.a.n0.q.h.h> B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.j : (c.a.n0.q.e.e) invokeV.objValue;
    }

    @Override // c.a.n0.q.e.i
    public void D(c.a.n0.q.h.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            super.D(bVar);
            c.a.n0.a.u.d.k("SwanAppBatchDownloadCallback", "onFetchError: " + bVar.toString());
            c.a.n0.a.x.m.a aVar = this.f7244d;
            if (aVar != null) {
                aVar.b(bVar.a);
            }
        }
    }

    @Override // c.a.n0.q.e.i
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.E();
            c.a.n0.a.u.d.k("SwanAppBatchDownloadCallback", "onFetchStart");
        }
    }

    @Override // c.a.n0.q.e.i
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.F();
            c.a.n0.a.u.d.k("SwanAppBatchDownloadCallback", "onFetchSuccess");
        }
    }

    @Override // c.a.n0.q.e.i
    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.G();
            c.a.n0.a.u.d.k("SwanAppBatchDownloadCallback", "onNoPackage");
            c.a.n0.a.x.m.a aVar = this.f7244d;
            if (aVar != null) {
                aVar.d();
            }
        }
    }

    @Override // c.a.n0.q.e.i
    public void H(c.a.n0.q.o.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, gVar) == null) {
            super.H(gVar);
            this.f7243c = gVar;
            c.a.n0.a.d0.h.b.e(gVar);
            c.a.n0.a.u.d.k("SwanAppBatchDownloadCallback", "onPrepareDownload: " + gVar.n());
        }
    }

    @Override // c.a.n0.a.x.m.k
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
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, aVar)) == null) {
            if (aVar == null || aVar.f9197d == null || aVar.f9200g == null) {
                return false;
            }
            if (!j0.a(new File(aVar.f9197d.a), aVar.f9197d.m)) {
                c.a.n0.a.u.d.k("SwanAppBatchDownloadCallback", "onMainPkgDownload: 签名校验失败");
                return false;
            }
            c.a.n0.a.k2.a m = c.a.n0.a.x.m.u.a.m(aVar.f9197d, this);
            if (m != null) {
                c.a.n0.a.u.d.k("SwanAppBatchDownloadCallback", "onMainPkgDownload: 解压失败，" + m);
                return false;
            }
            aVar.f9200g.initMaxAgeInfo();
            c.a.n0.a.x.m.u.a.k(aVar.f9200g, aVar.f9197d);
            aVar.f9200g.updateInstallSrc(K());
            if (!c.a.n0.q.f.a.i().a(aVar.f9197d, aVar.f9200g)) {
                c.a.n0.a.u.d.k("SwanAppBatchDownloadCallback", "onMainPkgDownload: 存储DB失败");
                return false;
            }
            this.f7243c.m(aVar.f9197d);
            if (!aVar.f9201h) {
                c.a.n0.a.x.m.u.a.o(aVar.f9200g);
            }
            c.a.n0.a.x.m.u.a.b(aVar.f9197d);
            c.a.n0.q.h.g gVar = aVar.f9197d;
            if (gVar != null) {
                c.a.n0.a.t1.n.d.c(d.e.i(gVar.f9145g, String.valueOf(gVar.i)).getAbsolutePath(), true);
            }
            c.a.n0.q.h.g gVar2 = aVar.f9197d;
            if (gVar2 == null || gVar2.f9146h != 0 || ((c2 = a.b.c()) > 0 && (pMSAppInfo = aVar.f9200g) != null && ((i = pMSAppInfo.rank) == 0 || i > c2))) {
                return true;
            }
            c.a.n0.a.x.l.g.n.a i2 = c.a.n0.a.x.l.g.n.a.i();
            c.a.n0.q.h.g gVar3 = aVar.f9197d;
            i2.f(gVar3.f9145g, gVar3.i);
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void X() {
        c.a.n0.a.x.m.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            int incrementAndGet = this.f7246f.incrementAndGet();
            int n = this.f7243c.n();
            if (l) {
                Log.d("SwanAppBatchDownloadCallback", "batch download,total pkg num - " + n + ",success num - " + incrementAndGet);
            }
            if (incrementAndGet != n || this.f7247g || (aVar = this.f7244d) == null) {
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

    @Override // c.a.n0.q.e.i, c.a.n0.q.e.f
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.b();
            c.a.n0.a.u.d.k("SwanAppBatchDownloadCallback", "onTotalPkgDownloadFinish");
            if (l) {
                Log.e("SwanAppBatchDownloadCallback", "onTotalPkgDownloadFinish");
            }
            if (!this.f7245e.isEmpty()) {
                q.k(new a(this), "SwanAppBatchDownloadCallback");
            }
            c.a.n0.a.x.m.a aVar = this.f7244d;
            if (aVar != null) {
                aVar.h();
            }
            if (c.a.n0.a.d0.h.c.a()) {
                return;
            }
            c.a.n0.a.u.d.k("SwanAppBatchDownloadCallback", "#onTotalPkgDownloadFinish excludeIds=" + this.f7248h);
            c.a.n0.a.d0.d d2 = c.a.n0.a.d0.f.c().d();
            CopyOnWriteArraySet<String> copyOnWriteArraySet = this.f7248h;
            c.a.n0.a.d0.l.c l2 = c.a.n0.a.d0.l.c.l();
            l2.i(7);
            d2.t(copyOnWriteArraySet, false, l2.k());
        }
    }

    @Override // c.a.n0.q.e.i
    public c.a.n0.q.e.e<c.a.n0.q.h.i> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.k : (c.a.n0.q.e.e) invokeV.objValue;
    }

    @Override // c.a.n0.q.e.i
    public c.a.n0.q.e.a<b.a> w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.i : (c.a.n0.q.e.a) invokeV.objValue;
    }

    public d(c.a.n0.a.x.m.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.i = new b(this);
        this.j = new C0550d(this, this);
        this.k = new e(this, this);
        this.f7244d = aVar;
        this.f7245e = new Vector();
        this.f7246f = new AtomicInteger(0);
        this.f7248h = new CopyOnWriteArraySet<>();
    }
}
