package c.a.p0.a.h0.m;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.h0.m.c;
import c.a.p0.a.v2.w0;
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
public abstract class l extends j {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean n;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public i.j<? super c.a.p0.n.h.d> f6225g;

    /* renamed from: h  reason: collision with root package name */
    public i.j<? super c.a.p0.n.h.b> f6226h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.p0.n.o.f f6227i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.p0.a.v2.e1.b<Exception> f6228j;
    public c.a.p0.n.f.c<c.a.p0.n.h.d> k;
    public c.a.p0.n.f.c<c.a.p0.n.h.b> l;
    public i.j<c.a.p0.n.h.e> m;

    /* loaded from: classes.dex */
    public class a extends c.a.p0.n.f.b<c.a.p0.n.h.d> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f6229e;

        public a(l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6229e = lVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.n.f.c
        /* renamed from: l */
        public String d(c.a.p0.n.h.d dVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, dVar)) == null) ? this.f6229e.W() : (String) invokeL.objValue;
        }

        @Override // c.a.p0.n.f.e
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bundle, set)) == null) ? this.f6229e.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.n.f.b, c.a.p0.n.f.c
        /* renamed from: o */
        public void e(c.a.p0.n.h.d dVar, c.a.p0.n.h.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, dVar, aVar) == null) {
                super.e(dVar, aVar);
                c.a.p0.a.e0.d.h("UpdateCoreCallback", "onDownloadError:" + aVar);
                this.f6229e.f6227i.j(dVar);
                c.a.p0.a.q2.a aVar2 = new c.a.p0.a.q2.a();
                aVar2.j(13L);
                aVar2.h(aVar.f11875a);
                aVar2.c("Framework包下载失败");
                aVar2.e(aVar.toString());
                if (this.f6229e.f6225g != null) {
                    this.f6229e.f6225g.onError(new PkgDownloadError(dVar, aVar2));
                }
                c.a.p0.a.h0.m.c.c().a(dVar, this.f6229e.U(), aVar2);
                c.a.p0.t.d.j(dVar.f11879a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.n.f.b, c.a.p0.n.f.c
        /* renamed from: p */
        public void i(c.a.p0.n.h.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dVar) == null) {
                super.i(dVar);
                c.a.p0.a.e0.d.h("UpdateCoreCallback", "onFileDownloaded: " + dVar.f11887i);
                c.a.p0.a.q2.a b0 = this.f6229e.b0(dVar);
                if (b0 == null) {
                    this.f6229e.f6227i.k(dVar);
                    if (this.f6229e.f6225g != null) {
                        this.f6229e.f6225g.onNext(dVar);
                        this.f6229e.f6225g.onCompleted();
                    }
                    c.a.p0.n.g.a.h().l(dVar);
                    c.a.p0.a.h0.m.c.c().b(dVar, this.f6229e.U());
                    w0.a();
                    return;
                }
                this.f6229e.f6227i.j(dVar);
                if (this.f6229e.f6225g != null) {
                    this.f6229e.f6225g.onError(new PkgDownloadError(dVar, b0));
                }
                c.a.p0.a.h0.m.c.c().a(dVar, this.f6229e.U(), b0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.n.f.b, c.a.p0.n.f.c
        /* renamed from: q */
        public void c(c.a.p0.n.h.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, dVar) == null) {
                super.c(dVar);
                c.a.p0.a.e0.d.h("UpdateCoreCallback", "onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.n.f.b, c.a.p0.n.f.c
        /* renamed from: r */
        public void f(c.a.p0.n.h.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, dVar) == null) {
                super.f(dVar);
                boolean unused = l.n;
                this.f6229e.f0(dVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b extends c.a.p0.n.f.b<c.a.p0.n.h.b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f6230e;

        public b(l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6230e = lVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.n.f.c
        /* renamed from: l */
        public String d(c.a.p0.n.h.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bVar)) == null) ? this.f6230e.V() : (String) invokeL.objValue;
        }

        @Override // c.a.p0.n.f.e
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bundle, set)) == null) ? this.f6230e.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.n.f.b, c.a.p0.n.f.c
        /* renamed from: o */
        public void e(c.a.p0.n.h.b bVar, c.a.p0.n.h.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, bVar, aVar) == null) {
                super.e(bVar, aVar);
                c.a.p0.a.e0.d.h("UpdateCoreCallback", "onDownloadError:" + aVar);
                this.f6230e.f6227i.j(bVar);
                c.a.p0.a.q2.a aVar2 = new c.a.p0.a.q2.a();
                aVar2.j(14L);
                aVar2.h(aVar.f11875a);
                aVar2.c("Extension下载失败");
                aVar2.e(aVar.toString());
                if (this.f6230e.f6226h != null) {
                    this.f6230e.f6226h.onError(new PkgDownloadError(bVar, aVar2));
                }
                c.a.p0.a.h0.m.c.c().a(bVar, this.f6230e.U(), aVar2);
                c.a.p0.t.d.j(bVar.f11879a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.n.f.b, c.a.p0.n.f.c
        /* renamed from: p */
        public void i(c.a.p0.n.h.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
                super.i(bVar);
                c.a.p0.a.e0.d.h("UpdateCoreCallback", "onFileDownloaded: " + bVar.f11887i);
                c.a.p0.a.q2.a a0 = this.f6230e.a0(bVar);
                if (a0 == null) {
                    this.f6230e.f6227i.k(bVar);
                    if (this.f6230e.f6226h != null) {
                        this.f6230e.f6226h.onNext(bVar);
                        this.f6230e.f6226h.onCompleted();
                    }
                    c.a.p0.n.g.a.h().l(bVar);
                    c.a.p0.a.h0.m.c.c().b(bVar, this.f6230e.U());
                    return;
                }
                this.f6230e.f6227i.j(bVar);
                if (this.f6230e.f6226h != null) {
                    this.f6230e.f6226h.onError(new PkgDownloadError(bVar, a0));
                }
                c.a.p0.a.h0.m.c.c().a(bVar, this.f6230e.U(), a0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.n.f.b, c.a.p0.n.f.c
        /* renamed from: q */
        public void c(c.a.p0.n.h.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, bVar) == null) {
                super.c(bVar);
                c.a.p0.a.e0.d.h("UpdateCoreCallback", "onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.n.f.b, c.a.p0.n.f.c
        /* renamed from: r */
        public void f(c.a.p0.n.h.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, bVar) == null) {
                super.f(bVar);
                boolean unused = l.n;
                this.f6230e.e0(bVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements c.InterfaceC0228c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.n.h.d f6231a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ l f6232b;

        public c(l lVar, c.a.p0.n.h.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6232b = lVar;
            this.f6231a = dVar;
        }

        @Override // c.a.p0.a.h0.m.c.InterfaceC0228c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                this.f6232b.f6227i.k(this.f6231a);
                if (this.f6232b.f6225g != null) {
                    this.f6232b.f6225g.onNext(this.f6231a);
                    this.f6232b.f6225g.onCompleted();
                }
            }
        }

        @Override // c.a.p0.a.h0.m.c.InterfaceC0228c
        public void b(PMSDownloadType pMSDownloadType, c.a.p0.a.q2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, aVar) == null) {
                this.f6232b.f6227i.j(this.f6231a);
                if (this.f6232b.f6225g != null) {
                    this.f6232b.f6225g.onError(new PkgDownloadError(this.f6231a, aVar));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements c.InterfaceC0228c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.n.h.b f6233a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ l f6234b;

        public d(l lVar, c.a.p0.n.h.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6234b = lVar;
            this.f6233a = bVar;
        }

        @Override // c.a.p0.a.h0.m.c.InterfaceC0228c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                this.f6234b.f6227i.k(this.f6233a);
                if (this.f6234b.f6226h != null) {
                    this.f6234b.f6226h.onNext(this.f6233a);
                    this.f6234b.f6226h.onCompleted();
                }
            }
        }

        @Override // c.a.p0.a.h0.m.c.InterfaceC0228c
        public void b(PMSDownloadType pMSDownloadType, c.a.p0.a.q2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, aVar) == null) {
                this.f6234b.f6227i.j(this.f6233a);
                if (this.f6234b.f6226h != null) {
                    this.f6234b.f6226h.onError(new PkgDownloadError(this.f6233a, aVar));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements d.a<c.a.p0.n.h.d> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f6235e;

        public e(l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6235e = lVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // i.n.b
        /* renamed from: a */
        public void call(i.j<? super c.a.p0.n.h.d> jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
                this.f6235e.f6225g = jVar;
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements d.a<c.a.p0.n.h.b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f6236e;

        public f(l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6236e = lVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // i.n.b
        /* renamed from: a */
        public void call(i.j<? super c.a.p0.n.h.b> jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
                this.f6236e.f6226h = jVar;
            }
        }
    }

    /* loaded from: classes.dex */
    public class g extends i.j<c.a.p0.n.h.e> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f6237e;

        public g(l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6237e = lVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // i.e
        /* renamed from: b */
        public void onNext(c.a.p0.n.h.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) {
                c.a.p0.a.e0.d.h("UpdateCoreCallback", "单个包下载、业务层处理完成：" + eVar.f11887i);
            }
        }

        @Override // i.e
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                c.a.p0.a.e0.d.h("UpdateCoreCallback", "包下载完成");
                this.f6237e.d0();
            }
        }

        @Override // i.e
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                c.a.p0.a.e0.d.i("UpdateCoreCallback", "OnError", th);
                this.f6237e.c0(new Exception("UpdateCoreCallback failed by Download error = ", th));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1087047745, "Lc/a/p0/a/h0/m/l;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1087047745, "Lc/a/p0/a/h0/m/l;");
                return;
            }
        }
        n = c.a.p0.a.k.f7077a;
    }

    public l(c.a.p0.a.v2.e1.b<Exception> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f6228j = bVar;
    }

    @Override // c.a.p0.n.f.g
    public void B(c.a.p0.n.h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            super.B(aVar);
            c.a.p0.a.e0.d.h("UpdateCoreCallback", "onFetchError: " + aVar.toString());
            if (aVar.f11875a == 1010) {
                d0();
                return;
            }
            c0(new PMSException("UpdateCoreCallback failed by fetch error = " + aVar, aVar));
        }
    }

    @Override // c.a.p0.n.f.g
    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.D();
            boolean z = n;
        }
    }

    @Override // c.a.p0.n.f.g
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.E();
            c.a.p0.a.e0.d.h("UpdateCoreCallback", "onNoPackage:");
            d0();
        }
    }

    @Override // c.a.p0.n.f.g
    public void F(c.a.p0.n.o.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
            super.F(fVar);
            if (fVar == null) {
                return;
            }
            this.f6227i = fVar;
            if (fVar.i()) {
                return;
            }
            Y();
        }
    }

    public abstract int T();

    public abstract PMSDownloadType U();

    public abstract String V();

    public abstract String W();

    public final i.j<c.a.p0.n.h.e> X() {
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

    public final void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            ArrayList arrayList = new ArrayList();
            if (this.f6227i.c()) {
                arrayList.add(i.d.b(new e(this)));
            }
            if (this.f6227i.b()) {
                arrayList.add(i.d.b(new f(this)));
            }
            if (arrayList.isEmpty()) {
                return;
            }
            i.d.l(arrayList).z(X());
        }
    }

    public void Z(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, exc) == null) {
            c.a.p0.a.e0.d.i("UpdateCoreCallback", "notifyFinalCallback", exc);
            c.a.p0.a.v2.e1.b<Exception> bVar = this.f6228j;
            if (bVar != null) {
                bVar.onCallback(exc);
            }
            this.f6228j = null;
        }
    }

    public abstract c.a.p0.a.q2.a a0(c.a.p0.n.h.b bVar);

    public abstract c.a.p0.a.q2.a b0(c.a.p0.n.h.d dVar);

    public void c0(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, exc) == null) {
            c.a.p0.a.e0.d.h("UpdateCoreCallback", "onUpdateFailed setLatestUpdateTime = 0");
            c.a.p0.n.n.a.d(T(), 0L);
            c.a.p0.d.d.b.a(0L);
            Z(new Exception("UpdateCoreCallback onUpdateFailed: cause by = ", exc));
        }
    }

    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            c.a.p0.a.e0.d.h("UpdateCoreCallback", "onUpdateSuccess setLatestUpdateTime = " + currentTimeMillis);
            c.a.p0.n.n.a.d(T(), currentTimeMillis);
            Z(null);
        }
    }

    public final void e0(c.a.p0.n.h.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bVar) == null) {
            c.a.p0.a.h0.m.c.c().d(bVar, new d(this, bVar));
        }
    }

    public final void f0(c.a.p0.n.h.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, dVar) == null) {
            c.a.p0.a.h0.m.c.c().d(dVar, new c(this, dVar));
        }
    }

    @Override // c.a.p0.n.f.g
    public c.a.p0.n.f.c<c.a.p0.n.h.b> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.l == null) {
                this.l = new b(this);
            }
            return this.l;
        }
        return (c.a.p0.n.f.c) invokeV.objValue;
    }

    @Override // c.a.p0.n.f.g
    public c.a.p0.n.f.c<c.a.p0.n.h.d> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.k == null) {
                this.k = new a(this);
            }
            return this.k;
        }
        return (c.a.p0.n.f.c) invokeV.objValue;
    }
}
