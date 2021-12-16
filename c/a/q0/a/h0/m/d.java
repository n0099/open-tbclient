package c.a.q0.a.h0.m;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.a.a1.d;
import c.a.q0.a.h0.d.a;
import c.a.q0.a.z2.j0;
import c.a.q0.a.z2.q;
import c.a.q0.q.j.l.b;
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
    public c.a.q0.q.p.g f6046g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.q0.a.h0.m.a f6047h;

    /* renamed from: i  reason: collision with root package name */
    public final List<c.a.q0.q.i.h> f6048i;

    /* renamed from: j  reason: collision with root package name */
    public AtomicInteger f6049j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f6050k;
    public final CopyOnWriteArraySet<String> l;
    public c.a.q0.q.f.a<b.a> m;
    public c.a.q0.q.f.e<c.a.q0.q.i.h> n;
    public final c.a.q0.q.f.e<c.a.q0.q.i.i> o;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f6051e;

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
            this.f6051e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean b2 = c.a.q0.q.g.a.i().b(null, this.f6051e.f6048i, null, null, null);
                if (b2) {
                    for (c.a.q0.q.i.h hVar : this.f6051e.f6048i) {
                        if (this.f6051e.f6047h != null) {
                            this.f6051e.f6047h.g(hVar);
                        }
                        this.f6051e.X();
                    }
                }
                if (d.p) {
                    String str = "update subPkgList =" + b2 + ", size=" + this.f6051e.f6048i;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b extends c.a.q0.q.f.a<b.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f6052e;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b.a f6053e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f6054f;

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
                this.f6054f = bVar;
                this.f6053e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.f6054f.f6052e.W(this.f6053e)) {
                        this.f6054f.f6052e.X();
                        if (this.f6054f.f6052e.f6047h != null) {
                            this.f6054f.f6052e.f6047h.c(this.f6053e);
                        }
                        c.a.q0.a.h0.m.s.a.c(this.f6053e.f11090g.appId);
                    }
                    c.a.q0.a.n0.h.b.f(this.f6053e.f11085b);
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
            this.f6052e = dVar;
        }

        @Override // c.a.q0.q.f.a
        public void l(@NonNull PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048582, this, pMSAppInfo) == null) && pMSAppInfo.isForbiddenApp()) {
                c.a.q0.a.f2.f.f0.a.K(pMSAppInfo.appId, pMSAppInfo.appStatus);
            }
        }

        @Override // c.a.q0.q.f.g
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) ? this.f6052e.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        @Override // c.a.q0.q.f.a
        public void o(b.a aVar, PMSAppInfo pMSAppInfo, c.a.q0.q.i.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar, pMSAppInfo, bVar) == null) {
                c.a.q0.a.e0.d.k("SwanAppBatchDownloadCallback", "#onSingleFetchError errorNo=" + bVar.a + " errorMsg=" + bVar.f11016b + " errorDetails=" + bVar.f11018d);
                if (this.f6052e.f6047h != null) {
                    this.f6052e.f6047h.f(bVar);
                }
                if (bVar.a != 1010) {
                    this.f6052e.f6050k = true;
                    return;
                }
                PMSAppInfo pMSAppInfo2 = aVar == null ? null : aVar.f11090g;
                if (pMSAppInfo2 == null) {
                    pMSAppInfo2 = pMSAppInfo;
                }
                this.f6052e.Y(pMSAppInfo2, pMSAppInfo);
                if (!c.a.q0.a.h0.m.s.a.m(bVar) || pMSAppInfo2 == null) {
                    return;
                }
                c.a.q0.a.h0.m.s.a.c(pMSAppInfo2.appId);
            }
        }

        @Override // c.a.q0.q.f.a
        public void p(@Nullable PMSAppInfo pMSAppInfo, @Nullable PMSAppInfo pMSAppInfo2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048585, this, pMSAppInfo, pMSAppInfo2) == null) {
                if (pMSAppInfo != null && pMSAppInfo.isForbiddenApp()) {
                    c.a.q0.a.f2.f.f0.a.K(pMSAppInfo.appKey, pMSAppInfo.appStatus);
                }
                this.f6052e.Y(pMSAppInfo, pMSAppInfo2);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.q.f.e
        /* renamed from: q */
        public String d(b.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, aVar)) == null) {
                if (aVar == null) {
                    return null;
                }
                int i2 = aVar.f11086c;
                if (i2 == 0) {
                    return c.a.q0.a.h0.m.u.a.g();
                }
                if (i2 == 1) {
                    return c.a.q0.a.h0.m.u.a.i();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.q.f.b, c.a.q0.q.f.e
        /* renamed from: r */
        public void e(b.a aVar, c.a.q0.q.i.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048587, this, aVar, bVar) == null) {
                super.e(aVar, bVar);
                c.a.q0.a.e0.d.k("SwanAppBatchDownloadCallback", "onDownloadError：" + bVar.toString());
                c.a.q0.a.n0.h.b.f(aVar.f11085b);
                c.a.q0.a.u2.a aVar2 = new c.a.q0.a.u2.a();
                aVar2.k(11L);
                aVar2.i(bVar.a);
                aVar2.d("批量下载，主包下载失败：" + aVar.f11085b);
                aVar2.f(bVar.toString());
                if (aVar.a != 0) {
                    if (d.p) {
                        String str = "onDownloadError: " + aVar2.toString();
                    }
                } else if (aVar.f11087d == null) {
                } else {
                    this.f6052e.f6046g.l(aVar.f11087d);
                    c.a.q0.a.h0.m.c.c().a(aVar.f11087d, PMSDownloadType.BATCH, aVar2);
                    c.a.q0.a.e0.d.k("SwanAppBatchDownloadCallback", "#onDownloadError del: " + aVar.f11087d.a);
                    c.a.q0.w.d.k(aVar.f11087d.a);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.q.f.b, c.a.q0.q.f.e
        /* renamed from: s */
        public void i(b.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, aVar) == null) {
                super.i(aVar);
                c.a.q0.a.e0.d.k("SwanAppBatchDownloadCallback", "onFileDownloaded: " + aVar.f11087d.f11028i);
                this.f6052e.l.add(aVar.f11085b);
                a aVar2 = new a(this, aVar);
                ExecutorUtilsExt.postOnSerial(aVar2, aVar.f11087d.f11026g + " 下载完成，执行签名校验-重命名-解压-DB");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.q.f.b, c.a.q0.q.f.e
        /* renamed from: t */
        public void a(b.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048589, this, aVar) == null) {
                super.a(aVar);
                if (d.p) {
                    String str = "onDownloadProgress: " + aVar.f11087d.f11021b + "/" + aVar.f11087d.f11030k;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.q.f.b, c.a.q0.q.f.e
        /* renamed from: u */
        public void c(b.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048590, this, aVar) == null) {
                super.c(aVar);
                c.a.q0.a.e0.d.k("SwanAppBatchDownloadCallback", "onDownloadStart: " + aVar.f11085b);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.q.f.b, c.a.q0.q.f.e
        /* renamed from: v */
        public void f(b.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048591, this, aVar) == null) {
                if (d.p) {
                    String str = "onDownloading:" + aVar.f11085b;
                }
                c.a.q0.a.n0.h.b.f(aVar.f11085b);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PMSAppInfo f6055e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PMSAppInfo f6056f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f6057g;

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
            this.f6057g = dVar;
            this.f6055e = pMSAppInfo;
            this.f6056f = pMSAppInfo2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                PMSAppInfo pMSAppInfo = this.f6055e;
                if (pMSAppInfo != null) {
                    pMSAppInfo.updateInstallSrc(this.f6057g.K());
                    this.f6056f.copyLocalAppInfoData(this.f6055e);
                } else {
                    this.f6056f.updateInstallSrc(this.f6057g.K());
                }
                this.f6056f.initMaxAgeInfo();
                if (c.a.q0.q.g.a.i().l(this.f6056f)) {
                    c.a.q0.a.h0.m.u.a.o(this.f6056f);
                }
            }
        }
    }

    /* renamed from: c.a.q0.a.h0.m.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0325d extends n<d> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f6058g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0325d(d dVar, d dVar2) {
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
            this.f6058g = dVar;
        }

        @Override // c.a.q0.a.h0.m.n
        public void p(@NonNull c.a.q0.q.i.h hVar, @Nullable c.a.q0.a.u2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, hVar, aVar) == null) {
                super.p(hVar, aVar);
                if (aVar == null) {
                    this.f6058g.f6048i.add(hVar);
                } else if (d.p) {
                    String str = "onDownloadAndUnzipFinish " + hVar + StringUtil.ARRAY_ELEMENT_SEPARATOR + aVar;
                }
                c.a.q0.a.n0.h.b.f(hVar.o);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.q.f.b, c.a.q0.q.f.e
        /* renamed from: q */
        public void e(c.a.q0.q.i.h hVar, c.a.q0.q.i.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, hVar, bVar) == null) {
                super.q(hVar, bVar);
                c.a.q0.a.n0.h.b.f(hVar.o);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.q.f.b, c.a.q0.q.f.e
        /* renamed from: u */
        public void f(c.a.q0.q.i.h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, hVar) == null) {
                super.f(hVar);
                c.a.q0.a.n0.h.b.f(hVar.o);
            }
        }
    }

    /* loaded from: classes.dex */
    public class e extends l<d> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f6059f;

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
            this.f6059f = dVar;
        }

        @Override // c.a.q0.a.h0.m.l
        public void r(@NonNull c.a.q0.q.i.i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (d.p) {
                    String str = "onDownloadAndUnzipSuccess:" + iVar;
                }
                if (this.f6059f.f6047h != null) {
                    this.f6059f.f6047h.e(iVar);
                }
                this.f6059f.X();
            }
        }

        @Override // c.a.q0.a.h0.m.l
        public void u(c.a.q0.q.i.i iVar, c.a.q0.a.u2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iVar, aVar) == null) {
                c.a.q0.a.e0.d.k("SwanAppBatchDownloadCallback", "onDownloadOrUnzipFail:" + iVar + StringUtil.ARRAY_ELEMENT_SEPARATOR + aVar);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1216130216, "Lc/a/q0/a/h0/m/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1216130216, "Lc/a/q0/a/h0/m/d;");
                return;
            }
        }
        p = c.a.q0.a.k.a;
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
                this((c.a.q0.a.h0.m.a) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.q0.q.f.i
    public c.a.q0.q.f.e<c.a.q0.q.i.h> B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.n : (c.a.q0.q.f.e) invokeV.objValue;
    }

    @Override // c.a.q0.q.f.i
    public void D(c.a.q0.q.i.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            super.D(bVar);
            c.a.q0.a.e0.d.k("SwanAppBatchDownloadCallback", "onFetchError: " + bVar.toString());
            c.a.q0.a.h0.m.a aVar = this.f6047h;
            if (aVar != null) {
                aVar.b(bVar.a);
            }
        }
    }

    @Override // c.a.q0.q.f.i
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.E();
            c.a.q0.a.e0.d.k("SwanAppBatchDownloadCallback", "onFetchStart");
        }
    }

    @Override // c.a.q0.q.f.i
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.F();
            c.a.q0.a.e0.d.k("SwanAppBatchDownloadCallback", "onFetchSuccess");
        }
    }

    @Override // c.a.q0.q.f.i
    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.G();
            c.a.q0.a.e0.d.k("SwanAppBatchDownloadCallback", "onNoPackage");
            c.a.q0.a.h0.m.a aVar = this.f6047h;
            if (aVar != null) {
                aVar.d();
            }
        }
    }

    @Override // c.a.q0.q.f.i
    public void H(c.a.q0.q.p.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, gVar) == null) {
            super.H(gVar);
            this.f6046g = gVar;
            c.a.q0.a.n0.h.b.e(gVar);
            c.a.q0.a.e0.d.k("SwanAppBatchDownloadCallback", "onPrepareDownload: " + gVar.n());
        }
    }

    @Override // c.a.q0.a.h0.m.k
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
            if (aVar == null || aVar.f11087d == null || aVar.f11090g == null) {
                return false;
            }
            if (!j0.a(new File(aVar.f11087d.a), aVar.f11087d.m)) {
                c.a.q0.a.e0.d.k("SwanAppBatchDownloadCallback", "onMainPkgDownload: 签名校验失败");
                return false;
            }
            c.a.q0.a.u2.a m = c.a.q0.a.h0.m.u.a.m(aVar.f11087d, this);
            if (m != null) {
                c.a.q0.a.e0.d.k("SwanAppBatchDownloadCallback", "onMainPkgDownload: 解压失败，" + m);
                return false;
            }
            aVar.f11090g.initMaxAgeInfo();
            c.a.q0.a.h0.m.u.a.k(aVar.f11090g, aVar.f11087d);
            aVar.f11090g.updateInstallSrc(K());
            if (!c.a.q0.q.g.a.i().a(aVar.f11087d, aVar.f11090g)) {
                c.a.q0.a.e0.d.k("SwanAppBatchDownloadCallback", "onMainPkgDownload: 存储DB失败");
                return false;
            }
            this.f6046g.m(aVar.f11087d);
            if (!aVar.f11091h) {
                c.a.q0.a.h0.m.u.a.o(aVar.f11090g);
            }
            c.a.q0.a.h0.m.u.a.b(aVar.f11087d);
            c.a.q0.q.i.g gVar = aVar.f11087d;
            if (gVar != null) {
                c.a.q0.a.d2.n.d.c(d.e.i(gVar.f11026g, String.valueOf(gVar.f11028i)).getAbsolutePath(), true);
            }
            c.a.q0.q.i.g gVar2 = aVar.f11087d;
            if (gVar2 == null || gVar2.f11027h != 0 || ((c2 = a.b.c()) > 0 && (pMSAppInfo = aVar.f11090g) != null && ((i2 = pMSAppInfo.rank) == 0 || i2 > c2))) {
                return true;
            }
            c.a.q0.a.h0.l.g.n.a i3 = c.a.q0.a.h0.l.g.n.a.i();
            c.a.q0.q.i.g gVar3 = aVar.f11087d;
            i3.f(gVar3.f11026g, gVar3.f11028i);
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void X() {
        c.a.q0.a.h0.m.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            int incrementAndGet = this.f6049j.incrementAndGet();
            int n = this.f6046g.n();
            if (p) {
                String str = "batch download,total pkg num - " + n + ",success num - " + incrementAndGet;
            }
            if (incrementAndGet != n || this.f6050k || (aVar = this.f6047h) == null) {
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

    @Override // c.a.q0.q.f.i, c.a.q0.q.f.f
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.b();
            c.a.q0.a.e0.d.k("SwanAppBatchDownloadCallback", "onTotalPkgDownloadFinish");
            boolean z = p;
            if (!this.f6048i.isEmpty()) {
                q.k(new a(this), "SwanAppBatchDownloadCallback");
            }
            c.a.q0.a.h0.m.a aVar = this.f6047h;
            if (aVar != null) {
                aVar.h();
            }
            if (c.a.q0.a.n0.h.c.a()) {
                return;
            }
            c.a.q0.a.e0.d.k("SwanAppBatchDownloadCallback", "#onTotalPkgDownloadFinish excludeIds=" + this.l);
            c.a.q0.a.n0.d d2 = c.a.q0.a.n0.f.c().d();
            CopyOnWriteArraySet<String> copyOnWriteArraySet = this.l;
            c.a.q0.a.n0.l.c l = c.a.q0.a.n0.l.c.l();
            l.i(7);
            d2.t(copyOnWriteArraySet, false, l.k());
        }
    }

    @Override // c.a.q0.q.f.i
    public c.a.q0.q.f.e<c.a.q0.q.i.i> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.o : (c.a.q0.q.f.e) invokeV.objValue;
    }

    @Override // c.a.q0.q.f.i
    public c.a.q0.q.f.a<b.a> w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.m : (c.a.q0.q.f.a) invokeV.objValue;
    }

    public d(c.a.q0.a.h0.m.a aVar) {
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
        this.n = new C0325d(this, this);
        this.o = new e(this, this);
        this.f6047h = aVar;
        this.f6048i = new Vector();
        this.f6049j = new AtomicInteger(0);
        this.l = new CopyOnWriteArraySet<>();
    }
}
