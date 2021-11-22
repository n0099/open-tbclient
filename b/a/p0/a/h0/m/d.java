package b.a.p0.a.h0.m;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.a1.d;
import b.a.p0.a.h0.d.a;
import b.a.p0.a.z2.j0;
import b.a.p0.a.z2.q;
import b.a.p0.q.j.l.b;
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
    public b.a.p0.q.p.g f5799g;

    /* renamed from: h  reason: collision with root package name */
    public b.a.p0.a.h0.m.a f5800h;

    /* renamed from: i  reason: collision with root package name */
    public final List<b.a.p0.q.i.h> f5801i;
    public AtomicInteger j;
    public boolean k;
    public final CopyOnWriteArraySet<String> l;
    public b.a.p0.q.f.a<b.a> m;
    public b.a.p0.q.f.e<b.a.p0.q.i.h> n;
    public final b.a.p0.q.f.e<b.a.p0.q.i.i> o;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f5802e;

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
            this.f5802e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean b2 = b.a.p0.q.g.a.i().b(null, this.f5802e.f5801i, null, null, null);
                if (b2) {
                    for (b.a.p0.q.i.h hVar : this.f5802e.f5801i) {
                        if (this.f5802e.f5800h != null) {
                            this.f5802e.f5800h.g(hVar);
                        }
                        this.f5802e.W();
                    }
                }
                if (d.p) {
                    String str = "update subPkgList =" + b2 + ", size=" + this.f5802e.f5801i;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b extends b.a.p0.q.f.a<b.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f5803e;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b.a f5804e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f5805f;

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
                this.f5805f = bVar;
                this.f5804e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.f5805f.f5803e.V(this.f5804e)) {
                        this.f5805f.f5803e.W();
                        if (this.f5805f.f5803e.f5800h != null) {
                            this.f5805f.f5803e.f5800h.c(this.f5804e);
                        }
                        b.a.p0.a.h0.m.s.a.c(this.f5804e.f11853g.appId);
                    }
                    b.a.p0.a.n0.h.b.f(this.f5804e.f11848b);
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
            this.f5803e = dVar;
        }

        @Override // b.a.p0.q.f.a
        public void l(@NonNull PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048582, this, pMSAppInfo) == null) && pMSAppInfo.isForbiddenApp()) {
                b.a.p0.a.f2.f.f0.a.K(pMSAppInfo.appId, pMSAppInfo.appStatus);
            }
        }

        @Override // b.a.p0.q.f.g
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) ? this.f5803e.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        @Override // b.a.p0.q.f.a
        public void o(b.a aVar, PMSAppInfo pMSAppInfo, b.a.p0.q.i.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar, pMSAppInfo, bVar) == null) {
                b.a.p0.a.e0.d.k("SwanAppBatchDownloadCallback", "#onSingleFetchError errorNo=" + bVar.f11762a + " errorMsg=" + bVar.f11763b + " errorDetails=" + bVar.f11765d);
                if (this.f5803e.f5800h != null) {
                    this.f5803e.f5800h.f(bVar);
                }
                if (bVar.f11762a != 1010) {
                    this.f5803e.k = true;
                    return;
                }
                PMSAppInfo pMSAppInfo2 = aVar == null ? null : aVar.f11853g;
                if (pMSAppInfo2 == null) {
                    pMSAppInfo2 = pMSAppInfo;
                }
                this.f5803e.X(pMSAppInfo2, pMSAppInfo);
                if (!b.a.p0.a.h0.m.s.a.m(bVar) || pMSAppInfo2 == null) {
                    return;
                }
                b.a.p0.a.h0.m.s.a.c(pMSAppInfo2.appId);
            }
        }

        @Override // b.a.p0.q.f.a
        public void p(@Nullable PMSAppInfo pMSAppInfo, @Nullable PMSAppInfo pMSAppInfo2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048585, this, pMSAppInfo, pMSAppInfo2) == null) {
                if (pMSAppInfo != null && pMSAppInfo.isForbiddenApp()) {
                    b.a.p0.a.f2.f.f0.a.K(pMSAppInfo.appKey, pMSAppInfo.appStatus);
                }
                this.f5803e.X(pMSAppInfo, pMSAppInfo2);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.q.f.e
        /* renamed from: q */
        public String d(b.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, aVar)) == null) {
                if (aVar == null) {
                    return null;
                }
                int i2 = aVar.f11849c;
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.q.f.b, b.a.p0.q.f.e
        /* renamed from: r */
        public void e(b.a aVar, b.a.p0.q.i.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048587, this, aVar, bVar) == null) {
                super.e(aVar, bVar);
                b.a.p0.a.e0.d.k("SwanAppBatchDownloadCallback", "onDownloadError：" + bVar.toString());
                b.a.p0.a.n0.h.b.f(aVar.f11848b);
                b.a.p0.a.u2.a aVar2 = new b.a.p0.a.u2.a();
                aVar2.k(11L);
                aVar2.i(bVar.f11762a);
                aVar2.d("批量下载，主包下载失败：" + aVar.f11848b);
                aVar2.f(bVar.toString());
                if (aVar.f11847a != 0) {
                    if (d.p) {
                        String str = "onDownloadError: " + aVar2.toString();
                    }
                } else if (aVar.f11850d == null) {
                } else {
                    this.f5803e.f5799g.l(aVar.f11850d);
                    b.a.p0.a.h0.m.c.c().a(aVar.f11850d, PMSDownloadType.BATCH, aVar2);
                    b.a.p0.a.e0.d.k("SwanAppBatchDownloadCallback", "#onDownloadError del: " + aVar.f11850d.f11768a);
                    b.a.p0.w.d.k(aVar.f11850d.f11768a);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.q.f.b, b.a.p0.q.f.e
        /* renamed from: s */
        public void i(b.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, aVar) == null) {
                super.i(aVar);
                b.a.p0.a.e0.d.k("SwanAppBatchDownloadCallback", "onFileDownloaded: " + aVar.f11850d.f11776i);
                this.f5803e.l.add(aVar.f11848b);
                a aVar2 = new a(this, aVar);
                ExecutorUtilsExt.postOnSerial(aVar2, aVar.f11850d.f11774g + " 下载完成，执行签名校验-重命名-解压-DB");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.q.f.b, b.a.p0.q.f.e
        /* renamed from: t */
        public void a(b.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048589, this, aVar) == null) {
                super.a(aVar);
                if (d.p) {
                    String str = "onDownloadProgress: " + aVar.f11850d.f11769b + "/" + aVar.f11850d.k;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.q.f.b, b.a.p0.q.f.e
        /* renamed from: u */
        public void c(b.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048590, this, aVar) == null) {
                super.c(aVar);
                b.a.p0.a.e0.d.k("SwanAppBatchDownloadCallback", "onDownloadStart: " + aVar.f11848b);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.q.f.b, b.a.p0.q.f.e
        /* renamed from: v */
        public void f(b.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048591, this, aVar) == null) {
                if (d.p) {
                    String str = "onDownloading:" + aVar.f11848b;
                }
                b.a.p0.a.n0.h.b.f(aVar.f11848b);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PMSAppInfo f5806e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PMSAppInfo f5807f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f5808g;

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
            this.f5808g = dVar;
            this.f5806e = pMSAppInfo;
            this.f5807f = pMSAppInfo2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                PMSAppInfo pMSAppInfo = this.f5806e;
                if (pMSAppInfo != null) {
                    pMSAppInfo.updateInstallSrc(this.f5808g.J());
                    this.f5807f.copyLocalAppInfoData(this.f5806e);
                } else {
                    this.f5807f.updateInstallSrc(this.f5808g.J());
                }
                this.f5807f.initMaxAgeInfo();
                if (b.a.p0.q.g.a.i().l(this.f5807f)) {
                    b.a.p0.a.h0.m.u.a.o(this.f5807f);
                }
            }
        }
    }

    /* renamed from: b.a.p0.a.h0.m.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0235d extends n<d> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f5809g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0235d(d dVar, d dVar2) {
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
            this.f5809g = dVar;
        }

        @Override // b.a.p0.a.h0.m.n
        public void p(@NonNull b.a.p0.q.i.h hVar, @Nullable b.a.p0.a.u2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, hVar, aVar) == null) {
                super.p(hVar, aVar);
                if (aVar == null) {
                    this.f5809g.f5801i.add(hVar);
                } else if (d.p) {
                    String str = "onDownloadAndUnzipFinish " + hVar + StringUtil.ARRAY_ELEMENT_SEPARATOR + aVar;
                }
                b.a.p0.a.n0.h.b.f(hVar.o);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.q.f.b, b.a.p0.q.f.e
        /* renamed from: q */
        public void e(b.a.p0.q.i.h hVar, b.a.p0.q.i.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, hVar, bVar) == null) {
                super.q(hVar, bVar);
                b.a.p0.a.n0.h.b.f(hVar.o);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.q.f.b, b.a.p0.q.f.e
        /* renamed from: u */
        public void f(b.a.p0.q.i.h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, hVar) == null) {
                super.f(hVar);
                b.a.p0.a.n0.h.b.f(hVar.o);
            }
        }
    }

    /* loaded from: classes.dex */
    public class e extends l<d> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f5810f;

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
            this.f5810f = dVar;
        }

        @Override // b.a.p0.a.h0.m.l
        public void r(@NonNull b.a.p0.q.i.i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (d.p) {
                    String str = "onDownloadAndUnzipSuccess:" + iVar;
                }
                if (this.f5810f.f5800h != null) {
                    this.f5810f.f5800h.e(iVar);
                }
                this.f5810f.W();
            }
        }

        @Override // b.a.p0.a.h0.m.l
        public void u(b.a.p0.q.i.i iVar, b.a.p0.a.u2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iVar, aVar) == null) {
                b.a.p0.a.e0.d.k("SwanAppBatchDownloadCallback", "onDownloadOrUnzipFail:" + iVar + StringUtil.ARRAY_ELEMENT_SEPARATOR + aVar);
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
        p = b.a.p0.a.k.f6863a;
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

    @Override // b.a.p0.q.f.i
    public b.a.p0.q.f.e<b.a.p0.q.i.h> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.n : (b.a.p0.q.f.e) invokeV.objValue;
    }

    @Override // b.a.p0.q.f.i
    public void C(b.a.p0.q.i.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            super.C(bVar);
            b.a.p0.a.e0.d.k("SwanAppBatchDownloadCallback", "onFetchError: " + bVar.toString());
            b.a.p0.a.h0.m.a aVar = this.f5800h;
            if (aVar != null) {
                aVar.b(bVar.f11762a);
            }
        }
    }

    @Override // b.a.p0.q.f.i
    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.D();
            b.a.p0.a.e0.d.k("SwanAppBatchDownloadCallback", "onFetchStart");
        }
    }

    @Override // b.a.p0.q.f.i
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.E();
            b.a.p0.a.e0.d.k("SwanAppBatchDownloadCallback", "onFetchSuccess");
        }
    }

    @Override // b.a.p0.q.f.i
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.F();
            b.a.p0.a.e0.d.k("SwanAppBatchDownloadCallback", "onNoPackage");
            b.a.p0.a.h0.m.a aVar = this.f5800h;
            if (aVar != null) {
                aVar.d();
            }
        }
    }

    @Override // b.a.p0.q.f.i
    public void G(b.a.p0.q.p.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, gVar) == null) {
            super.G(gVar);
            this.f5799g = gVar;
            b.a.p0.a.n0.h.b.e(gVar);
            b.a.p0.a.e0.d.k("SwanAppBatchDownloadCallback", "onPrepareDownload: " + gVar.n());
        }
    }

    @Override // b.a.p0.a.h0.m.k
    public int K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return 7;
        }
        return invokeV.intValue;
    }

    public final boolean V(b.a aVar) {
        InterceptResult invokeL;
        int c2;
        PMSAppInfo pMSAppInfo;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, aVar)) == null) {
            if (aVar == null || aVar.f11850d == null || aVar.f11853g == null) {
                return false;
            }
            if (!j0.a(new File(aVar.f11850d.f11768a), aVar.f11850d.m)) {
                b.a.p0.a.e0.d.k("SwanAppBatchDownloadCallback", "onMainPkgDownload: 签名校验失败");
                return false;
            }
            b.a.p0.a.u2.a m = b.a.p0.a.h0.m.u.a.m(aVar.f11850d, this);
            if (m != null) {
                b.a.p0.a.e0.d.k("SwanAppBatchDownloadCallback", "onMainPkgDownload: 解压失败，" + m);
                return false;
            }
            aVar.f11853g.initMaxAgeInfo();
            b.a.p0.a.h0.m.u.a.k(aVar.f11853g, aVar.f11850d);
            aVar.f11853g.updateInstallSrc(J());
            if (!b.a.p0.q.g.a.i().a(aVar.f11850d, aVar.f11853g)) {
                b.a.p0.a.e0.d.k("SwanAppBatchDownloadCallback", "onMainPkgDownload: 存储DB失败");
                return false;
            }
            this.f5799g.m(aVar.f11850d);
            if (!aVar.f11854h) {
                b.a.p0.a.h0.m.u.a.o(aVar.f11853g);
            }
            b.a.p0.a.h0.m.u.a.b(aVar.f11850d);
            b.a.p0.q.i.g gVar = aVar.f11850d;
            if (gVar != null) {
                b.a.p0.a.d2.n.d.c(d.e.i(gVar.f11774g, String.valueOf(gVar.f11776i)).getAbsolutePath(), true);
            }
            b.a.p0.q.i.g gVar2 = aVar.f11850d;
            if (gVar2 == null || gVar2.f11775h != 0 || ((c2 = a.b.c()) > 0 && (pMSAppInfo = aVar.f11853g) != null && ((i2 = pMSAppInfo.rank) == 0 || i2 > c2))) {
                return true;
            }
            b.a.p0.a.h0.l.g.n.a i3 = b.a.p0.a.h0.l.g.n.a.i();
            b.a.p0.q.i.g gVar3 = aVar.f11850d;
            i3.f(gVar3.f11774g, gVar3.f11776i);
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void W() {
        b.a.p0.a.h0.m.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            int incrementAndGet = this.j.incrementAndGet();
            int n = this.f5799g.n();
            if (p) {
                String str = "batch download,total pkg num - " + n + ",success num - " + incrementAndGet;
            }
            if (incrementAndGet != n || this.k || (aVar = this.f5800h) == null) {
                return;
            }
            aVar.a();
        }
    }

    public final void X(@Nullable PMSAppInfo pMSAppInfo, @Nullable PMSAppInfo pMSAppInfo2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, pMSAppInfo, pMSAppInfo2) == null) || pMSAppInfo == null) {
            return;
        }
        q.k(new c(this, pMSAppInfo2, pMSAppInfo), "批量下载-只更新AppInfo-存储DB");
    }

    @Override // b.a.p0.q.f.i, b.a.p0.q.f.f
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.b();
            b.a.p0.a.e0.d.k("SwanAppBatchDownloadCallback", "onTotalPkgDownloadFinish");
            boolean z = p;
            if (!this.f5801i.isEmpty()) {
                q.k(new a(this), "SwanAppBatchDownloadCallback");
            }
            b.a.p0.a.h0.m.a aVar = this.f5800h;
            if (aVar != null) {
                aVar.h();
            }
            if (b.a.p0.a.n0.h.c.a()) {
                return;
            }
            b.a.p0.a.e0.d.k("SwanAppBatchDownloadCallback", "#onTotalPkgDownloadFinish excludeIds=" + this.l);
            b.a.p0.a.n0.d d2 = b.a.p0.a.n0.f.c().d();
            CopyOnWriteArraySet<String> copyOnWriteArraySet = this.l;
            b.a.p0.a.n0.l.c l = b.a.p0.a.n0.l.c.l();
            l.i(7);
            d2.t(copyOnWriteArraySet, false, l.k());
        }
    }

    @Override // b.a.p0.q.f.i
    public b.a.p0.q.f.e<b.a.p0.q.i.i> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.o : (b.a.p0.q.f.e) invokeV.objValue;
    }

    @Override // b.a.p0.q.f.i
    public b.a.p0.q.f.a<b.a> v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.m : (b.a.p0.q.f.a) invokeV.objValue;
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
        this.n = new C0235d(this, this);
        this.o = new e(this, this);
        this.f5800h = aVar;
        this.f5801i = new Vector();
        this.j = new AtomicInteger(0);
        this.l = new CopyOnWriteArraySet<>();
    }
}
