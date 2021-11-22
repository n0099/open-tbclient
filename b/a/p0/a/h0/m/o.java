package b.a.p0.a.h0.m;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.h0.m.c;
import b.a.p0.a.z2.x0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.PkgDownloadError;
import com.baidu.swan.pms.model.PMSException;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import h.d;
import java.util.ArrayList;
import java.util.Set;
/* loaded from: classes.dex */
public abstract class o extends k {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean n;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public h.j<? super b.a.p0.q.i.e> f5859g;

    /* renamed from: h  reason: collision with root package name */
    public h.j<? super b.a.p0.q.i.c> f5860h;

    /* renamed from: i  reason: collision with root package name */
    public b.a.p0.q.p.g f5861i;
    public b.a.p0.a.z2.g1.c<Exception> j;
    public b.a.p0.q.f.e<b.a.p0.q.i.e> k;
    public b.a.p0.q.f.e<b.a.p0.q.i.c> l;
    public h.j<b.a.p0.q.i.f> m;

    /* loaded from: classes.dex */
    public class a extends b.a.p0.q.f.b<b.a.p0.q.i.e> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ o f5862e;

        public a(o oVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5862e = oVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.q.f.e
        /* renamed from: l */
        public String d(b.a.p0.q.i.e eVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, eVar)) == null) ? this.f5862e.X() : (String) invokeL.objValue;
        }

        @Override // b.a.p0.q.f.g
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bundle, set)) == null) ? this.f5862e.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.q.f.b, b.a.p0.q.f.e
        /* renamed from: o */
        public void e(b.a.p0.q.i.e eVar, b.a.p0.q.i.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, eVar, bVar) == null) {
                super.e(eVar, bVar);
                b.a.p0.a.e0.d.k("UpdateCoreCallback", "onDownloadError:" + bVar);
                this.f5862e.f5861i.l(eVar);
                b.a.p0.a.u2.a aVar = new b.a.p0.a.u2.a();
                aVar.k(13L);
                aVar.i(bVar.f11762a);
                aVar.d("Framework包下载失败");
                aVar.f(bVar.toString());
                if (this.f5862e.f5859g != null) {
                    this.f5862e.f5859g.onError(new PkgDownloadError(eVar, aVar));
                }
                b.a.p0.a.h0.m.c.c().a(eVar, this.f5862e.V(), aVar);
                b.a.p0.w.d.k(eVar.f11768a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.q.f.b, b.a.p0.q.f.e
        /* renamed from: p */
        public void i(b.a.p0.q.i.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar) == null) {
                super.i(eVar);
                b.a.p0.a.e0.d.k("UpdateCoreCallback", "onFileDownloaded: " + eVar.f11776i);
                b.a.p0.a.u2.a c0 = this.f5862e.c0(eVar);
                if (c0 == null) {
                    this.f5862e.f5861i.m(eVar);
                    if (this.f5862e.f5859g != null) {
                        this.f5862e.f5859g.onNext(eVar);
                        this.f5862e.f5859g.onCompleted();
                    }
                    b.a.p0.q.g.a.i().m(eVar);
                    b.a.p0.a.h0.m.c.c().b(eVar, this.f5862e.V());
                    x0.a();
                    return;
                }
                this.f5862e.f5861i.l(eVar);
                if (this.f5862e.f5859g != null) {
                    this.f5862e.f5859g.onError(new PkgDownloadError(eVar, c0));
                }
                b.a.p0.a.h0.m.c.c().a(eVar, this.f5862e.V(), c0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.q.f.b, b.a.p0.q.f.e
        /* renamed from: q */
        public void c(b.a.p0.q.i.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, eVar) == null) {
                super.c(eVar);
                b.a.p0.a.e0.d.k("UpdateCoreCallback", "onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.q.f.b, b.a.p0.q.f.e
        /* renamed from: r */
        public void f(b.a.p0.q.i.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, eVar) == null) {
                super.f(eVar);
                boolean unused = o.n;
                this.f5862e.g0(eVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b extends b.a.p0.q.f.b<b.a.p0.q.i.c> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ o f5863e;

        public b(o oVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5863e = oVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.q.f.e
        /* renamed from: l */
        public String d(b.a.p0.q.i.c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, cVar)) == null) ? this.f5863e.W() : (String) invokeL.objValue;
        }

        @Override // b.a.p0.q.f.g
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bundle, set)) == null) ? this.f5863e.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.q.f.b, b.a.p0.q.f.e
        /* renamed from: o */
        public void e(b.a.p0.q.i.c cVar, b.a.p0.q.i.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, cVar, bVar) == null) {
                super.e(cVar, bVar);
                b.a.p0.a.e0.d.k("UpdateCoreCallback", "onDownloadError:" + bVar);
                this.f5863e.f5861i.l(cVar);
                b.a.p0.a.u2.a aVar = new b.a.p0.a.u2.a();
                aVar.k(14L);
                aVar.i(bVar.f11762a);
                aVar.d("Extension下载失败");
                aVar.f(bVar.toString());
                if (this.f5863e.f5860h != null) {
                    this.f5863e.f5860h.onError(new PkgDownloadError(cVar, aVar));
                }
                b.a.p0.a.h0.m.c.c().a(cVar, this.f5863e.V(), aVar);
                b.a.p0.w.d.k(cVar.f11768a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.q.f.b, b.a.p0.q.f.e
        /* renamed from: p */
        public void i(b.a.p0.q.i.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar) == null) {
                super.i(cVar);
                b.a.p0.a.e0.d.k("UpdateCoreCallback", "onFileDownloaded: " + cVar.f11776i);
                b.a.p0.a.u2.a b0 = this.f5863e.b0(cVar);
                if (b0 == null) {
                    this.f5863e.f5861i.m(cVar);
                    if (this.f5863e.f5860h != null) {
                        this.f5863e.f5860h.onNext(cVar);
                        this.f5863e.f5860h.onCompleted();
                    }
                    b.a.p0.q.g.a.i().m(cVar);
                    b.a.p0.a.h0.m.c.c().b(cVar, this.f5863e.V());
                    return;
                }
                this.f5863e.f5861i.l(cVar);
                if (this.f5863e.f5860h != null) {
                    this.f5863e.f5860h.onError(new PkgDownloadError(cVar, b0));
                }
                b.a.p0.a.h0.m.c.c().a(cVar, this.f5863e.V(), b0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.q.f.b, b.a.p0.q.f.e
        /* renamed from: q */
        public void c(b.a.p0.q.i.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, cVar) == null) {
                super.c(cVar);
                b.a.p0.a.e0.d.k("UpdateCoreCallback", "onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.q.f.b, b.a.p0.q.f.e
        /* renamed from: r */
        public void f(b.a.p0.q.i.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, cVar) == null) {
                super.f(cVar);
                boolean unused = o.n;
                this.f5863e.f0(cVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements c.InterfaceC0234c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.q.i.e f5864a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ o f5865b;

        public c(o oVar, b.a.p0.q.i.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oVar, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5865b = oVar;
            this.f5864a = eVar;
        }

        @Override // b.a.p0.a.h0.m.c.InterfaceC0234c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                this.f5865b.f5861i.m(this.f5864a);
                if (this.f5865b.f5859g != null) {
                    this.f5865b.f5859g.onNext(this.f5864a);
                    this.f5865b.f5859g.onCompleted();
                }
            }
        }

        @Override // b.a.p0.a.h0.m.c.InterfaceC0234c
        public void b(PMSDownloadType pMSDownloadType, b.a.p0.a.u2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, aVar) == null) {
                this.f5865b.f5861i.l(this.f5864a);
                if (this.f5865b.f5859g != null) {
                    this.f5865b.f5859g.onError(new PkgDownloadError(this.f5864a, aVar));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements c.InterfaceC0234c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.q.i.c f5866a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ o f5867b;

        public d(o oVar, b.a.p0.q.i.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5867b = oVar;
            this.f5866a = cVar;
        }

        @Override // b.a.p0.a.h0.m.c.InterfaceC0234c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                this.f5867b.f5861i.m(this.f5866a);
                if (this.f5867b.f5860h != null) {
                    this.f5867b.f5860h.onNext(this.f5866a);
                    this.f5867b.f5860h.onCompleted();
                }
            }
        }

        @Override // b.a.p0.a.h0.m.c.InterfaceC0234c
        public void b(PMSDownloadType pMSDownloadType, b.a.p0.a.u2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, aVar) == null) {
                this.f5867b.f5861i.l(this.f5866a);
                if (this.f5867b.f5860h != null) {
                    this.f5867b.f5860h.onError(new PkgDownloadError(this.f5866a, aVar));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements d.a<b.a.p0.q.i.e> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ o f5868e;

        public e(o oVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5868e = oVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.d.a, h.n.b
        public void call(h.j<? super b.a.p0.q.i.e> jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
                this.f5868e.f5859g = jVar;
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements d.a<b.a.p0.q.i.c> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ o f5869e;

        public f(o oVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5869e = oVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.d.a, h.n.b
        public void call(h.j<? super b.a.p0.q.i.c> jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
                this.f5869e.f5860h = jVar;
            }
        }
    }

    /* loaded from: classes.dex */
    public class g extends h.j<b.a.p0.q.i.f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ o f5870i;

        public g(o oVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5870i = oVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.e
        /* renamed from: g */
        public void onNext(b.a.p0.q.i.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                b.a.p0.a.e0.d.k("UpdateCoreCallback", "单个包下载、业务层处理完成：" + fVar.f11776i);
            }
        }

        @Override // h.e
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                b.a.p0.a.e0.d.k("UpdateCoreCallback", "包下载完成");
                this.f5870i.e0();
            }
        }

        @Override // h.e
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                b.a.p0.a.e0.d.l("UpdateCoreCallback", "OnError", th);
                this.f5870i.d0(new Exception("UpdateCoreCallback failed by Download error = ", th));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1597582015, "Lb/a/p0/a/h0/m/o;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1597582015, "Lb/a/p0/a/h0/m/o;");
                return;
            }
        }
        n = b.a.p0.a.k.f6863a;
    }

    public o(b.a.p0.a.z2.g1.c<Exception> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.j = cVar;
    }

    @Override // b.a.p0.q.f.i
    public void C(b.a.p0.q.i.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            super.C(bVar);
            b.a.p0.a.e0.d.k("UpdateCoreCallback", "onFetchError: " + bVar.toString());
            if (bVar.f11762a == 1010) {
                e0();
                return;
            }
            d0(new PMSException("UpdateCoreCallback failed by fetch error = " + bVar, bVar));
        }
    }

    @Override // b.a.p0.q.f.i
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.E();
            boolean z = n;
        }
    }

    @Override // b.a.p0.q.f.i
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.F();
            b.a.p0.a.e0.d.k("UpdateCoreCallback", "onNoPackage:");
            e0();
        }
    }

    @Override // b.a.p0.q.f.i
    public void G(b.a.p0.q.p.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, gVar) == null) {
            super.G(gVar);
            if (gVar == null) {
                return;
            }
            this.f5861i = gVar;
            if (gVar.k()) {
                return;
            }
            Z();
        }
    }

    public abstract int U();

    public abstract PMSDownloadType V();

    public abstract String W();

    public abstract String X();

    public final h.j<b.a.p0.q.i.f> Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.m == null) {
                this.m = new g(this);
            }
            return this.m;
        }
        return (h.j) invokeV.objValue;
    }

    public final void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            ArrayList arrayList = new ArrayList();
            if (this.f5861i.e()) {
                arrayList.add(h.d.a(new e(this)));
            }
            if (this.f5861i.d()) {
                arrayList.add(h.d.a(new f(this)));
            }
            if (arrayList.isEmpty()) {
                return;
            }
            h.d.i(arrayList).u(Y());
        }
    }

    public void a0(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, exc) == null) {
            b.a.p0.a.e0.d.l("UpdateCoreCallback", "notifyFinalCallback", exc);
            b.a.p0.a.z2.g1.c<Exception> cVar = this.j;
            if (cVar != null) {
                cVar.onCallback(exc);
            }
            this.j = null;
        }
    }

    public abstract b.a.p0.a.u2.a b0(b.a.p0.q.i.c cVar);

    public abstract b.a.p0.a.u2.a c0(b.a.p0.q.i.e eVar);

    public void d0(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, exc) == null) {
            b.a.p0.a.e0.d.k("UpdateCoreCallback", "onUpdateFailed setLatestUpdateTime = 0");
            b.a.p0.q.o.a.d(U(), 0L);
            b.a.p0.d.d.b.a(0L);
            a0(new Exception("UpdateCoreCallback onUpdateFailed: cause by = ", exc));
        }
    }

    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            b.a.p0.a.e0.d.k("UpdateCoreCallback", "onUpdateSuccess setLatestUpdateTime = " + currentTimeMillis);
            b.a.p0.q.o.a.d(U(), currentTimeMillis);
            a0(null);
        }
    }

    public final void f0(b.a.p0.q.i.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, cVar) == null) {
            b.a.p0.a.h0.m.c.c().d(cVar, new d(this, cVar));
        }
    }

    public final void g0(b.a.p0.q.i.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, eVar) == null) {
            b.a.p0.a.h0.m.c.c().d(eVar, new c(this, eVar));
        }
    }

    @Override // b.a.p0.q.f.i
    public b.a.p0.q.f.e<b.a.p0.q.i.c> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.l == null) {
                this.l = new b(this);
            }
            return this.l;
        }
        return (b.a.p0.q.f.e) invokeV.objValue;
    }

    @Override // b.a.p0.q.f.i
    public b.a.p0.q.f.e<b.a.p0.q.i.e> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.k == null) {
                this.k = new a(this);
            }
            return this.k;
        }
        return (b.a.p0.q.f.e) invokeV.objValue;
    }
}
