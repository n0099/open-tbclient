package c.a.n0.a.x.m;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.p2.x0;
import c.a.n0.a.x.m.c;
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
import g.d;
import java.util.ArrayList;
import java.util.Set;
/* loaded from: classes.dex */
public abstract class o extends k {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public g.j<? super c.a.n0.q.h.e> f7281c;

    /* renamed from: d  reason: collision with root package name */
    public g.j<? super c.a.n0.q.h.c> f7282d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.n0.q.o.g f7283e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.n0.a.p2.g1.c<Exception> f7284f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.n0.q.e.e<c.a.n0.q.h.e> f7285g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.n0.q.e.e<c.a.n0.q.h.c> f7286h;
    public g.j<c.a.n0.q.h.f> i;

    /* loaded from: classes.dex */
    public class a extends c.a.n0.q.e.b<c.a.n0.q.h.e> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o a;

        public a(o oVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.q.e.e
        /* renamed from: l */
        public String d(c.a.n0.q.h.e eVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, eVar)) == null) ? this.a.Y() : (String) invokeL.objValue;
        }

        @Override // c.a.n0.q.e.g
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bundle, set)) == null) ? this.a.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.q.e.b, c.a.n0.q.e.e
        /* renamed from: o */
        public void e(c.a.n0.q.h.e eVar, c.a.n0.q.h.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, eVar, bVar) == null) {
                super.e(eVar, bVar);
                c.a.n0.a.u.d.k("UpdateCoreCallback", "onDownloadError:" + bVar);
                this.a.f7283e.l(eVar);
                c.a.n0.a.k2.a aVar = new c.a.n0.a.k2.a();
                aVar.k(13L);
                aVar.i(bVar.a);
                aVar.d("Framework包下载失败");
                aVar.f(bVar.toString());
                if (this.a.f7281c != null) {
                    this.a.f7281c.onError(new PkgDownloadError(eVar, aVar));
                }
                c.a.n0.a.x.m.c.c().a(eVar, this.a.W(), aVar);
                c.a.n0.w.d.k(eVar.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.q.e.b, c.a.n0.q.e.e
        /* renamed from: p */
        public void i(c.a.n0.q.h.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar) == null) {
                super.i(eVar);
                c.a.n0.a.u.d.k("UpdateCoreCallback", "onFileDownloaded: " + eVar.i);
                c.a.n0.a.k2.a d0 = this.a.d0(eVar);
                if (d0 == null) {
                    this.a.f7283e.m(eVar);
                    if (this.a.f7281c != null) {
                        this.a.f7281c.onNext(eVar);
                        this.a.f7281c.onCompleted();
                    }
                    c.a.n0.q.f.a.i().m(eVar);
                    c.a.n0.a.x.m.c.c().b(eVar, this.a.W());
                    x0.a();
                    return;
                }
                this.a.f7283e.l(eVar);
                if (this.a.f7281c != null) {
                    this.a.f7281c.onError(new PkgDownloadError(eVar, d0));
                }
                c.a.n0.a.x.m.c.c().a(eVar, this.a.W(), d0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.q.e.b, c.a.n0.q.e.e
        /* renamed from: q */
        public void c(c.a.n0.q.h.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, eVar) == null) {
                super.c(eVar);
                c.a.n0.a.u.d.k("UpdateCoreCallback", "onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.q.e.b, c.a.n0.q.e.e
        /* renamed from: r */
        public void f(c.a.n0.q.h.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, eVar) == null) {
                super.f(eVar);
                if (o.j) {
                    Log.i("UpdateCoreCallback", "framework onDownloading");
                }
                this.a.h0(eVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b extends c.a.n0.q.e.b<c.a.n0.q.h.c> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o a;

        public b(o oVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.q.e.e
        /* renamed from: l */
        public String d(c.a.n0.q.h.c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, cVar)) == null) ? this.a.X() : (String) invokeL.objValue;
        }

        @Override // c.a.n0.q.e.g
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bundle, set)) == null) ? this.a.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.q.e.b, c.a.n0.q.e.e
        /* renamed from: o */
        public void e(c.a.n0.q.h.c cVar, c.a.n0.q.h.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, cVar, bVar) == null) {
                super.e(cVar, bVar);
                c.a.n0.a.u.d.k("UpdateCoreCallback", "onDownloadError:" + bVar);
                this.a.f7283e.l(cVar);
                c.a.n0.a.k2.a aVar = new c.a.n0.a.k2.a();
                aVar.k(14L);
                aVar.i(bVar.a);
                aVar.d("Extension下载失败");
                aVar.f(bVar.toString());
                if (this.a.f7282d != null) {
                    this.a.f7282d.onError(new PkgDownloadError(cVar, aVar));
                }
                c.a.n0.a.x.m.c.c().a(cVar, this.a.W(), aVar);
                c.a.n0.w.d.k(cVar.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.q.e.b, c.a.n0.q.e.e
        /* renamed from: p */
        public void i(c.a.n0.q.h.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar) == null) {
                super.i(cVar);
                c.a.n0.a.u.d.k("UpdateCoreCallback", "onFileDownloaded: " + cVar.i);
                c.a.n0.a.k2.a c0 = this.a.c0(cVar);
                if (c0 == null) {
                    this.a.f7283e.m(cVar);
                    if (this.a.f7282d != null) {
                        this.a.f7282d.onNext(cVar);
                        this.a.f7282d.onCompleted();
                    }
                    c.a.n0.q.f.a.i().m(cVar);
                    c.a.n0.a.x.m.c.c().b(cVar, this.a.W());
                    return;
                }
                this.a.f7283e.l(cVar);
                if (this.a.f7282d != null) {
                    this.a.f7282d.onError(new PkgDownloadError(cVar, c0));
                }
                c.a.n0.a.x.m.c.c().a(cVar, this.a.W(), c0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.q.e.b, c.a.n0.q.e.e
        /* renamed from: q */
        public void c(c.a.n0.q.h.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, cVar) == null) {
                super.c(cVar);
                c.a.n0.a.u.d.k("UpdateCoreCallback", "onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.q.e.b, c.a.n0.q.e.e
        /* renamed from: r */
        public void f(c.a.n0.q.h.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, cVar) == null) {
                super.f(cVar);
                if (o.j) {
                    Log.i("UpdateCoreCallback", "extension onDownloading");
                }
                this.a.g0(cVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements c.InterfaceC0549c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.n0.q.h.e a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ o f7287b;

        public c(o oVar, c.a.n0.q.h.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oVar, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7287b = oVar;
            this.a = eVar;
        }

        @Override // c.a.n0.a.x.m.c.InterfaceC0549c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                this.f7287b.f7283e.m(this.a);
                if (this.f7287b.f7281c != null) {
                    this.f7287b.f7281c.onNext(this.a);
                    this.f7287b.f7281c.onCompleted();
                }
            }
        }

        @Override // c.a.n0.a.x.m.c.InterfaceC0549c
        public void b(PMSDownloadType pMSDownloadType, c.a.n0.a.k2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, aVar) == null) {
                this.f7287b.f7283e.l(this.a);
                if (this.f7287b.f7281c != null) {
                    this.f7287b.f7281c.onError(new PkgDownloadError(this.a, aVar));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements c.InterfaceC0549c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.n0.q.h.c a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ o f7288b;

        public d(o oVar, c.a.n0.q.h.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7288b = oVar;
            this.a = cVar;
        }

        @Override // c.a.n0.a.x.m.c.InterfaceC0549c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                this.f7288b.f7283e.m(this.a);
                if (this.f7288b.f7282d != null) {
                    this.f7288b.f7282d.onNext(this.a);
                    this.f7288b.f7282d.onCompleted();
                }
            }
        }

        @Override // c.a.n0.a.x.m.c.InterfaceC0549c
        public void b(PMSDownloadType pMSDownloadType, c.a.n0.a.k2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, aVar) == null) {
                this.f7288b.f7283e.l(this.a);
                if (this.f7288b.f7282d != null) {
                    this.f7288b.f7282d.onError(new PkgDownloadError(this.a, aVar));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements d.a<c.a.n0.q.h.e> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o a;

        public e(o oVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // g.d.a, g.n.b
        public void call(g.j<? super c.a.n0.q.h.e> jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
                this.a.f7281c = jVar;
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements d.a<c.a.n0.q.h.c> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o a;

        public f(o oVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // g.d.a, g.n.b
        public void call(g.j<? super c.a.n0.q.h.c> jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
                this.a.f7282d = jVar;
            }
        }
    }

    /* loaded from: classes.dex */
    public class g extends g.j<c.a.n0.q.h.f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ o f7289e;

        public g(o oVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7289e = oVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // g.e
        /* renamed from: g */
        public void onNext(c.a.n0.q.h.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                c.a.n0.a.u.d.k("UpdateCoreCallback", "单个包下载、业务层处理完成：" + fVar.i);
            }
        }

        @Override // g.e
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                c.a.n0.a.u.d.k("UpdateCoreCallback", "包下载完成");
                this.f7289e.f0();
            }
        }

        @Override // g.e
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                c.a.n0.a.u.d.l("UpdateCoreCallback", "OnError", th);
                this.f7289e.e0(new Exception("UpdateCoreCallback failed by Download error = ", th));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-622708230, "Lc/a/n0/a/x/m/o;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-622708230, "Lc/a/n0/a/x/m/o;");
                return;
            }
        }
        j = c.a.n0.a.a.a;
    }

    public o(c.a.n0.a.p2.g1.c<Exception> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f7284f = cVar;
    }

    @Override // c.a.n0.q.e.i
    public void D(c.a.n0.q.h.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            super.D(bVar);
            c.a.n0.a.u.d.k("UpdateCoreCallback", "onFetchError: " + bVar.toString());
            if (bVar.a == 1010) {
                f0();
                return;
            }
            e0(new PMSException("UpdateCoreCallback failed by fetch error = " + bVar, bVar));
        }
    }

    @Override // c.a.n0.q.e.i
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.F();
            if (j) {
                Log.e("UpdateCoreCallback", "onFetchSuccess:");
            }
        }
    }

    @Override // c.a.n0.q.e.i
    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.G();
            c.a.n0.a.u.d.k("UpdateCoreCallback", "onNoPackage:");
            f0();
        }
    }

    @Override // c.a.n0.q.e.i
    public void H(c.a.n0.q.o.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, gVar) == null) {
            super.H(gVar);
            if (gVar == null) {
                return;
            }
            this.f7283e = gVar;
            if (gVar.k()) {
                return;
            }
            a0();
        }
    }

    public abstract int V();

    public abstract PMSDownloadType W();

    public abstract String X();

    public abstract String Y();

    public final g.j<c.a.n0.q.h.f> Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.i == null) {
                this.i = new g(this);
            }
            return this.i;
        }
        return (g.j) invokeV.objValue;
    }

    public final void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            ArrayList arrayList = new ArrayList();
            if (this.f7283e.e()) {
                arrayList.add(g.d.a(new e(this)));
            }
            if (this.f7283e.d()) {
                arrayList.add(g.d.a(new f(this)));
            }
            if (arrayList.isEmpty()) {
                return;
            }
            g.d.i(arrayList).u(Z());
        }
    }

    public void b0(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, exc) == null) {
            c.a.n0.a.u.d.l("UpdateCoreCallback", "notifyFinalCallback", exc);
            c.a.n0.a.p2.g1.c<Exception> cVar = this.f7284f;
            if (cVar != null) {
                cVar.onCallback(exc);
            }
            this.f7284f = null;
        }
    }

    public abstract c.a.n0.a.k2.a c0(c.a.n0.q.h.c cVar);

    public abstract c.a.n0.a.k2.a d0(c.a.n0.q.h.e eVar);

    public void e0(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, exc) == null) {
            c.a.n0.a.u.d.k("UpdateCoreCallback", "onUpdateFailed setLatestUpdateTime = 0");
            c.a.n0.q.n.a.d(V(), 0L);
            c.a.n0.d.d.b.a(0L);
            b0(new Exception("UpdateCoreCallback onUpdateFailed: cause by = ", exc));
        }
    }

    public void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            c.a.n0.a.u.d.k("UpdateCoreCallback", "onUpdateSuccess setLatestUpdateTime = " + currentTimeMillis);
            c.a.n0.q.n.a.d(V(), currentTimeMillis);
            b0(null);
        }
    }

    public final void g0(c.a.n0.q.h.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, cVar) == null) {
            c.a.n0.a.x.m.c.c().d(cVar, new d(this, cVar));
        }
    }

    public final void h0(c.a.n0.q.h.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, eVar) == null) {
            c.a.n0.a.x.m.c.c().d(eVar, new c(this, eVar));
        }
    }

    @Override // c.a.n0.q.e.i
    public c.a.n0.q.e.e<c.a.n0.q.h.c> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.f7286h == null) {
                this.f7286h = new b(this);
            }
            return this.f7286h;
        }
        return (c.a.n0.q.e.e) invokeV.objValue;
    }

    @Override // c.a.n0.q.e.i
    public c.a.n0.q.e.e<c.a.n0.q.h.e> t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.f7285g == null) {
                this.f7285g = new a(this);
            }
            return this.f7285g;
        }
        return (c.a.n0.q.e.e) invokeV.objValue;
    }
}
