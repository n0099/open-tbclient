package c.a.p0.a.x.m;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.p2.x0;
import c.a.p0.a.x.m.c;
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
import i.d;
import java.util.ArrayList;
import java.util.Set;
/* loaded from: classes.dex */
public abstract class o extends k {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean n;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public i.j<? super c.a.p0.q.h.e> f8668g;

    /* renamed from: h  reason: collision with root package name */
    public i.j<? super c.a.p0.q.h.c> f8669h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.p0.q.o.g f8670i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.p0.a.p2.g1.c<Exception> f8671j;
    public c.a.p0.q.e.e<c.a.p0.q.h.e> k;
    public c.a.p0.q.e.e<c.a.p0.q.h.c> l;
    public i.j<c.a.p0.q.h.f> m;

    /* loaded from: classes.dex */
    public class a extends c.a.p0.q.e.b<c.a.p0.q.h.e> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ o f8672e;

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
            this.f8672e = oVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.q.e.e
        /* renamed from: l */
        public String d(c.a.p0.q.h.e eVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, eVar)) == null) ? this.f8672e.Y() : (String) invokeL.objValue;
        }

        @Override // c.a.p0.q.e.g
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bundle, set)) == null) ? this.f8672e.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.q.e.b, c.a.p0.q.e.e
        /* renamed from: o */
        public void e(c.a.p0.q.h.e eVar, c.a.p0.q.h.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, eVar, bVar) == null) {
                super.e(eVar, bVar);
                c.a.p0.a.u.d.k("UpdateCoreCallback", "onDownloadError:" + bVar);
                this.f8672e.f8670i.l(eVar);
                c.a.p0.a.k2.a aVar = new c.a.p0.a.k2.a();
                aVar.k(13L);
                aVar.i(bVar.a);
                aVar.d("Framework包下载失败");
                aVar.f(bVar.toString());
                if (this.f8672e.f8668g != null) {
                    this.f8672e.f8668g.onError(new PkgDownloadError(eVar, aVar));
                }
                c.a.p0.a.x.m.c.c().a(eVar, this.f8672e.W(), aVar);
                c.a.p0.w.d.k(eVar.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.q.e.b, c.a.p0.q.e.e
        /* renamed from: p */
        public void i(c.a.p0.q.h.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar) == null) {
                super.i(eVar);
                c.a.p0.a.u.d.k("UpdateCoreCallback", "onFileDownloaded: " + eVar.f10963i);
                c.a.p0.a.k2.a d0 = this.f8672e.d0(eVar);
                if (d0 == null) {
                    this.f8672e.f8670i.m(eVar);
                    if (this.f8672e.f8668g != null) {
                        this.f8672e.f8668g.onNext(eVar);
                        this.f8672e.f8668g.onCompleted();
                    }
                    c.a.p0.q.f.a.i().m(eVar);
                    c.a.p0.a.x.m.c.c().b(eVar, this.f8672e.W());
                    x0.a();
                    return;
                }
                this.f8672e.f8670i.l(eVar);
                if (this.f8672e.f8668g != null) {
                    this.f8672e.f8668g.onError(new PkgDownloadError(eVar, d0));
                }
                c.a.p0.a.x.m.c.c().a(eVar, this.f8672e.W(), d0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.q.e.b, c.a.p0.q.e.e
        /* renamed from: q */
        public void c(c.a.p0.q.h.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, eVar) == null) {
                super.c(eVar);
                c.a.p0.a.u.d.k("UpdateCoreCallback", "onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.q.e.b, c.a.p0.q.e.e
        /* renamed from: r */
        public void f(c.a.p0.q.h.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, eVar) == null) {
                super.f(eVar);
                boolean unused = o.n;
                this.f8672e.h0(eVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b extends c.a.p0.q.e.b<c.a.p0.q.h.c> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ o f8673e;

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
            this.f8673e = oVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.q.e.e
        /* renamed from: l */
        public String d(c.a.p0.q.h.c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, cVar)) == null) ? this.f8673e.X() : (String) invokeL.objValue;
        }

        @Override // c.a.p0.q.e.g
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bundle, set)) == null) ? this.f8673e.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.q.e.b, c.a.p0.q.e.e
        /* renamed from: o */
        public void e(c.a.p0.q.h.c cVar, c.a.p0.q.h.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, cVar, bVar) == null) {
                super.e(cVar, bVar);
                c.a.p0.a.u.d.k("UpdateCoreCallback", "onDownloadError:" + bVar);
                this.f8673e.f8670i.l(cVar);
                c.a.p0.a.k2.a aVar = new c.a.p0.a.k2.a();
                aVar.k(14L);
                aVar.i(bVar.a);
                aVar.d("Extension下载失败");
                aVar.f(bVar.toString());
                if (this.f8673e.f8669h != null) {
                    this.f8673e.f8669h.onError(new PkgDownloadError(cVar, aVar));
                }
                c.a.p0.a.x.m.c.c().a(cVar, this.f8673e.W(), aVar);
                c.a.p0.w.d.k(cVar.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.q.e.b, c.a.p0.q.e.e
        /* renamed from: p */
        public void i(c.a.p0.q.h.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar) == null) {
                super.i(cVar);
                c.a.p0.a.u.d.k("UpdateCoreCallback", "onFileDownloaded: " + cVar.f10963i);
                c.a.p0.a.k2.a c0 = this.f8673e.c0(cVar);
                if (c0 == null) {
                    this.f8673e.f8670i.m(cVar);
                    if (this.f8673e.f8669h != null) {
                        this.f8673e.f8669h.onNext(cVar);
                        this.f8673e.f8669h.onCompleted();
                    }
                    c.a.p0.q.f.a.i().m(cVar);
                    c.a.p0.a.x.m.c.c().b(cVar, this.f8673e.W());
                    return;
                }
                this.f8673e.f8670i.l(cVar);
                if (this.f8673e.f8669h != null) {
                    this.f8673e.f8669h.onError(new PkgDownloadError(cVar, c0));
                }
                c.a.p0.a.x.m.c.c().a(cVar, this.f8673e.W(), c0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.q.e.b, c.a.p0.q.e.e
        /* renamed from: q */
        public void c(c.a.p0.q.h.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, cVar) == null) {
                super.c(cVar);
                c.a.p0.a.u.d.k("UpdateCoreCallback", "onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.q.e.b, c.a.p0.q.e.e
        /* renamed from: r */
        public void f(c.a.p0.q.h.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, cVar) == null) {
                super.f(cVar);
                boolean unused = o.n;
                this.f8673e.g0(cVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements c.InterfaceC0557c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.p0.q.h.e a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ o f8674b;

        public c(o oVar, c.a.p0.q.h.e eVar) {
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
            this.f8674b = oVar;
            this.a = eVar;
        }

        @Override // c.a.p0.a.x.m.c.InterfaceC0557c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                this.f8674b.f8670i.m(this.a);
                if (this.f8674b.f8668g != null) {
                    this.f8674b.f8668g.onNext(this.a);
                    this.f8674b.f8668g.onCompleted();
                }
            }
        }

        @Override // c.a.p0.a.x.m.c.InterfaceC0557c
        public void b(PMSDownloadType pMSDownloadType, c.a.p0.a.k2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, aVar) == null) {
                this.f8674b.f8670i.l(this.a);
                if (this.f8674b.f8668g != null) {
                    this.f8674b.f8668g.onError(new PkgDownloadError(this.a, aVar));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements c.InterfaceC0557c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.p0.q.h.c a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ o f8675b;

        public d(o oVar, c.a.p0.q.h.c cVar) {
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
            this.f8675b = oVar;
            this.a = cVar;
        }

        @Override // c.a.p0.a.x.m.c.InterfaceC0557c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                this.f8675b.f8670i.m(this.a);
                if (this.f8675b.f8669h != null) {
                    this.f8675b.f8669h.onNext(this.a);
                    this.f8675b.f8669h.onCompleted();
                }
            }
        }

        @Override // c.a.p0.a.x.m.c.InterfaceC0557c
        public void b(PMSDownloadType pMSDownloadType, c.a.p0.a.k2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, aVar) == null) {
                this.f8675b.f8670i.l(this.a);
                if (this.f8675b.f8669h != null) {
                    this.f8675b.f8669h.onError(new PkgDownloadError(this.a, aVar));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements d.a<c.a.p0.q.h.e> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ o f8676e;

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
            this.f8676e = oVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // i.d.a, i.n.b
        public void call(i.j<? super c.a.p0.q.h.e> jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
                this.f8676e.f8668g = jVar;
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements d.a<c.a.p0.q.h.c> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ o f8677e;

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
            this.f8677e = oVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // i.d.a, i.n.b
        public void call(i.j<? super c.a.p0.q.h.c> jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
                this.f8677e.f8669h = jVar;
            }
        }
    }

    /* loaded from: classes.dex */
    public class g extends i.j<c.a.p0.q.h.f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ o f8678i;

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
            this.f8678i = oVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // i.e
        /* renamed from: g */
        public void onNext(c.a.p0.q.h.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                c.a.p0.a.u.d.k("UpdateCoreCallback", "单个包下载、业务层处理完成：" + fVar.f10963i);
            }
        }

        @Override // i.e
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                c.a.p0.a.u.d.k("UpdateCoreCallback", "包下载完成");
                this.f8678i.f0();
            }
        }

        @Override // i.e
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                c.a.p0.a.u.d.l("UpdateCoreCallback", "OnError", th);
                this.f8678i.e0(new Exception("UpdateCoreCallback failed by Download error = ", th));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(78356348, "Lc/a/p0/a/x/m/o;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(78356348, "Lc/a/p0/a/x/m/o;");
                return;
            }
        }
        n = c.a.p0.a.a.a;
    }

    public o(c.a.p0.a.p2.g1.c<Exception> cVar) {
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
        this.f8671j = cVar;
    }

    @Override // c.a.p0.q.e.i
    public void D(c.a.p0.q.h.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            super.D(bVar);
            c.a.p0.a.u.d.k("UpdateCoreCallback", "onFetchError: " + bVar.toString());
            if (bVar.a == 1010) {
                f0();
                return;
            }
            e0(new PMSException("UpdateCoreCallback failed by fetch error = " + bVar, bVar));
        }
    }

    @Override // c.a.p0.q.e.i
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.F();
            boolean z = n;
        }
    }

    @Override // c.a.p0.q.e.i
    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.G();
            c.a.p0.a.u.d.k("UpdateCoreCallback", "onNoPackage:");
            f0();
        }
    }

    @Override // c.a.p0.q.e.i
    public void H(c.a.p0.q.o.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, gVar) == null) {
            super.H(gVar);
            if (gVar == null) {
                return;
            }
            this.f8670i = gVar;
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

    public final i.j<c.a.p0.q.h.f> Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.m == null) {
                this.m = new g(this);
            }
            return this.m;
        }
        return (i.j) invokeV.objValue;
    }

    public final void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            ArrayList arrayList = new ArrayList();
            if (this.f8670i.e()) {
                arrayList.add(i.d.a(new e(this)));
            }
            if (this.f8670i.d()) {
                arrayList.add(i.d.a(new f(this)));
            }
            if (arrayList.isEmpty()) {
                return;
            }
            i.d.i(arrayList).u(Z());
        }
    }

    public void b0(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, exc) == null) {
            c.a.p0.a.u.d.l("UpdateCoreCallback", "notifyFinalCallback", exc);
            c.a.p0.a.p2.g1.c<Exception> cVar = this.f8671j;
            if (cVar != null) {
                cVar.onCallback(exc);
            }
            this.f8671j = null;
        }
    }

    public abstract c.a.p0.a.k2.a c0(c.a.p0.q.h.c cVar);

    public abstract c.a.p0.a.k2.a d0(c.a.p0.q.h.e eVar);

    public void e0(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, exc) == null) {
            c.a.p0.a.u.d.k("UpdateCoreCallback", "onUpdateFailed setLatestUpdateTime = 0");
            c.a.p0.q.n.a.d(V(), 0L);
            c.a.p0.d.d.b.a(0L);
            b0(new Exception("UpdateCoreCallback onUpdateFailed: cause by = ", exc));
        }
    }

    public void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            c.a.p0.a.u.d.k("UpdateCoreCallback", "onUpdateSuccess setLatestUpdateTime = " + currentTimeMillis);
            c.a.p0.q.n.a.d(V(), currentTimeMillis);
            b0(null);
        }
    }

    public final void g0(c.a.p0.q.h.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, cVar) == null) {
            c.a.p0.a.x.m.c.c().d(cVar, new d(this, cVar));
        }
    }

    public final void h0(c.a.p0.q.h.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, eVar) == null) {
            c.a.p0.a.x.m.c.c().d(eVar, new c(this, eVar));
        }
    }

    @Override // c.a.p0.q.e.i
    public c.a.p0.q.e.e<c.a.p0.q.h.c> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.l == null) {
                this.l = new b(this);
            }
            return this.l;
        }
        return (c.a.p0.q.e.e) invokeV.objValue;
    }

    @Override // c.a.p0.q.e.i
    public c.a.p0.q.e.e<c.a.p0.q.h.e> t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.k == null) {
                this.k = new a(this);
            }
            return this.k;
        }
        return (c.a.p0.q.e.e) invokeV.objValue;
    }
}
