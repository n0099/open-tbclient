package b.a.p0.a.h0.m;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.h0.m.c;
import b.a.p0.a.v2.w0;
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
public abstract class l extends j {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean n;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public h.j<? super b.a.p0.n.h.d> f5569g;

    /* renamed from: h  reason: collision with root package name */
    public h.j<? super b.a.p0.n.h.b> f5570h;

    /* renamed from: i  reason: collision with root package name */
    public b.a.p0.n.o.f f5571i;
    public b.a.p0.a.v2.e1.b<Exception> j;
    public b.a.p0.n.f.c<b.a.p0.n.h.d> k;
    public b.a.p0.n.f.c<b.a.p0.n.h.b> l;
    public h.j<b.a.p0.n.h.e> m;

    /* loaded from: classes.dex */
    public class a extends b.a.p0.n.f.b<b.a.p0.n.h.d> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f5572e;

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
            this.f5572e = lVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.n.f.c
        /* renamed from: l */
        public String d(b.a.p0.n.h.d dVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, dVar)) == null) ? this.f5572e.W() : (String) invokeL.objValue;
        }

        @Override // b.a.p0.n.f.e
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bundle, set)) == null) ? this.f5572e.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.n.f.b, b.a.p0.n.f.c
        /* renamed from: o */
        public void e(b.a.p0.n.h.d dVar, b.a.p0.n.h.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, dVar, aVar) == null) {
                super.e(dVar, aVar);
                b.a.p0.a.e0.d.h("UpdateCoreCallback", "onDownloadError:" + aVar);
                this.f5572e.f5571i.j(dVar);
                b.a.p0.a.q2.a aVar2 = new b.a.p0.a.q2.a();
                aVar2.j(13L);
                aVar2.h(aVar.f11066a);
                aVar2.c("Framework包下载失败");
                aVar2.e(aVar.toString());
                if (this.f5572e.f5569g != null) {
                    this.f5572e.f5569g.onError(new PkgDownloadError(dVar, aVar2));
                }
                b.a.p0.a.h0.m.c.c().a(dVar, this.f5572e.U(), aVar2);
                b.a.p0.t.d.j(dVar.f11070a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.n.f.b, b.a.p0.n.f.c
        /* renamed from: p */
        public void i(b.a.p0.n.h.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dVar) == null) {
                super.i(dVar);
                b.a.p0.a.e0.d.h("UpdateCoreCallback", "onFileDownloaded: " + dVar.f11078i);
                b.a.p0.a.q2.a b0 = this.f5572e.b0(dVar);
                if (b0 == null) {
                    this.f5572e.f5571i.k(dVar);
                    if (this.f5572e.f5569g != null) {
                        this.f5572e.f5569g.onNext(dVar);
                        this.f5572e.f5569g.onCompleted();
                    }
                    b.a.p0.n.g.a.h().l(dVar);
                    b.a.p0.a.h0.m.c.c().b(dVar, this.f5572e.U());
                    w0.a();
                    return;
                }
                this.f5572e.f5571i.j(dVar);
                if (this.f5572e.f5569g != null) {
                    this.f5572e.f5569g.onError(new PkgDownloadError(dVar, b0));
                }
                b.a.p0.a.h0.m.c.c().a(dVar, this.f5572e.U(), b0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.n.f.b, b.a.p0.n.f.c
        /* renamed from: q */
        public void c(b.a.p0.n.h.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, dVar) == null) {
                super.c(dVar);
                b.a.p0.a.e0.d.h("UpdateCoreCallback", "onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.n.f.b, b.a.p0.n.f.c
        /* renamed from: r */
        public void f(b.a.p0.n.h.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, dVar) == null) {
                super.f(dVar);
                boolean unused = l.n;
                this.f5572e.f0(dVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b extends b.a.p0.n.f.b<b.a.p0.n.h.b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f5573e;

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
            this.f5573e = lVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.n.f.c
        /* renamed from: l */
        public String d(b.a.p0.n.h.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bVar)) == null) ? this.f5573e.V() : (String) invokeL.objValue;
        }

        @Override // b.a.p0.n.f.e
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bundle, set)) == null) ? this.f5573e.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.n.f.b, b.a.p0.n.f.c
        /* renamed from: o */
        public void e(b.a.p0.n.h.b bVar, b.a.p0.n.h.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, bVar, aVar) == null) {
                super.e(bVar, aVar);
                b.a.p0.a.e0.d.h("UpdateCoreCallback", "onDownloadError:" + aVar);
                this.f5573e.f5571i.j(bVar);
                b.a.p0.a.q2.a aVar2 = new b.a.p0.a.q2.a();
                aVar2.j(14L);
                aVar2.h(aVar.f11066a);
                aVar2.c("Extension下载失败");
                aVar2.e(aVar.toString());
                if (this.f5573e.f5570h != null) {
                    this.f5573e.f5570h.onError(new PkgDownloadError(bVar, aVar2));
                }
                b.a.p0.a.h0.m.c.c().a(bVar, this.f5573e.U(), aVar2);
                b.a.p0.t.d.j(bVar.f11070a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.n.f.b, b.a.p0.n.f.c
        /* renamed from: p */
        public void i(b.a.p0.n.h.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
                super.i(bVar);
                b.a.p0.a.e0.d.h("UpdateCoreCallback", "onFileDownloaded: " + bVar.f11078i);
                b.a.p0.a.q2.a a0 = this.f5573e.a0(bVar);
                if (a0 == null) {
                    this.f5573e.f5571i.k(bVar);
                    if (this.f5573e.f5570h != null) {
                        this.f5573e.f5570h.onNext(bVar);
                        this.f5573e.f5570h.onCompleted();
                    }
                    b.a.p0.n.g.a.h().l(bVar);
                    b.a.p0.a.h0.m.c.c().b(bVar, this.f5573e.U());
                    return;
                }
                this.f5573e.f5571i.j(bVar);
                if (this.f5573e.f5570h != null) {
                    this.f5573e.f5570h.onError(new PkgDownloadError(bVar, a0));
                }
                b.a.p0.a.h0.m.c.c().a(bVar, this.f5573e.U(), a0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.n.f.b, b.a.p0.n.f.c
        /* renamed from: q */
        public void c(b.a.p0.n.h.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, bVar) == null) {
                super.c(bVar);
                b.a.p0.a.e0.d.h("UpdateCoreCallback", "onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.n.f.b, b.a.p0.n.f.c
        /* renamed from: r */
        public void f(b.a.p0.n.h.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, bVar) == null) {
                super.f(bVar);
                boolean unused = l.n;
                this.f5573e.e0(bVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements c.InterfaceC0223c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.n.h.d f5574a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ l f5575b;

        public c(l lVar, b.a.p0.n.h.d dVar) {
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
            this.f5575b = lVar;
            this.f5574a = dVar;
        }

        @Override // b.a.p0.a.h0.m.c.InterfaceC0223c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                this.f5575b.f5571i.k(this.f5574a);
                if (this.f5575b.f5569g != null) {
                    this.f5575b.f5569g.onNext(this.f5574a);
                    this.f5575b.f5569g.onCompleted();
                }
            }
        }

        @Override // b.a.p0.a.h0.m.c.InterfaceC0223c
        public void b(PMSDownloadType pMSDownloadType, b.a.p0.a.q2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, aVar) == null) {
                this.f5575b.f5571i.j(this.f5574a);
                if (this.f5575b.f5569g != null) {
                    this.f5575b.f5569g.onError(new PkgDownloadError(this.f5574a, aVar));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements c.InterfaceC0223c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.n.h.b f5576a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ l f5577b;

        public d(l lVar, b.a.p0.n.h.b bVar) {
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
            this.f5577b = lVar;
            this.f5576a = bVar;
        }

        @Override // b.a.p0.a.h0.m.c.InterfaceC0223c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                this.f5577b.f5571i.k(this.f5576a);
                if (this.f5577b.f5570h != null) {
                    this.f5577b.f5570h.onNext(this.f5576a);
                    this.f5577b.f5570h.onCompleted();
                }
            }
        }

        @Override // b.a.p0.a.h0.m.c.InterfaceC0223c
        public void b(PMSDownloadType pMSDownloadType, b.a.p0.a.q2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, aVar) == null) {
                this.f5577b.f5571i.j(this.f5576a);
                if (this.f5577b.f5570h != null) {
                    this.f5577b.f5570h.onError(new PkgDownloadError(this.f5576a, aVar));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements d.a<b.a.p0.n.h.d> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f5578e;

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
            this.f5578e = lVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.d.a, h.n.b
        public void call(h.j<? super b.a.p0.n.h.d> jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
                this.f5578e.f5569g = jVar;
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements d.a<b.a.p0.n.h.b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f5579e;

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
            this.f5579e = lVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.d.a, h.n.b
        public void call(h.j<? super b.a.p0.n.h.b> jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
                this.f5579e.f5570h = jVar;
            }
        }
    }

    /* loaded from: classes.dex */
    public class g extends h.j<b.a.p0.n.h.e> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ l f5580i;

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
            this.f5580i = lVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.e
        /* renamed from: g */
        public void onNext(b.a.p0.n.h.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) {
                b.a.p0.a.e0.d.h("UpdateCoreCallback", "单个包下载、业务层处理完成：" + eVar.f11078i);
            }
        }

        @Override // h.e
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                b.a.p0.a.e0.d.h("UpdateCoreCallback", "包下载完成");
                this.f5580i.d0();
            }
        }

        @Override // h.e
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                b.a.p0.a.e0.d.i("UpdateCoreCallback", "OnError", th);
                this.f5580i.c0(new Exception("UpdateCoreCallback failed by Download error = ", th));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1597581922, "Lb/a/p0/a/h0/m/l;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1597581922, "Lb/a/p0/a/h0/m/l;");
                return;
            }
        }
        n = b.a.p0.a.k.f6397a;
    }

    public l(b.a.p0.a.v2.e1.b<Exception> bVar) {
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
        this.j = bVar;
    }

    @Override // b.a.p0.n.f.g
    public void B(b.a.p0.n.h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            super.B(aVar);
            b.a.p0.a.e0.d.h("UpdateCoreCallback", "onFetchError: " + aVar.toString());
            if (aVar.f11066a == 1010) {
                d0();
                return;
            }
            c0(new PMSException("UpdateCoreCallback failed by fetch error = " + aVar, aVar));
        }
    }

    @Override // b.a.p0.n.f.g
    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.D();
            boolean z = n;
        }
    }

    @Override // b.a.p0.n.f.g
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.E();
            b.a.p0.a.e0.d.h("UpdateCoreCallback", "onNoPackage:");
            d0();
        }
    }

    @Override // b.a.p0.n.f.g
    public void F(b.a.p0.n.o.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
            super.F(fVar);
            if (fVar == null) {
                return;
            }
            this.f5571i = fVar;
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

    public final h.j<b.a.p0.n.h.e> X() {
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

    public final void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            ArrayList arrayList = new ArrayList();
            if (this.f5571i.c()) {
                arrayList.add(h.d.a(new e(this)));
            }
            if (this.f5571i.b()) {
                arrayList.add(h.d.a(new f(this)));
            }
            if (arrayList.isEmpty()) {
                return;
            }
            h.d.i(arrayList).u(X());
        }
    }

    public void Z(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, exc) == null) {
            b.a.p0.a.e0.d.i("UpdateCoreCallback", "notifyFinalCallback", exc);
            b.a.p0.a.v2.e1.b<Exception> bVar = this.j;
            if (bVar != null) {
                bVar.onCallback(exc);
            }
            this.j = null;
        }
    }

    public abstract b.a.p0.a.q2.a a0(b.a.p0.n.h.b bVar);

    public abstract b.a.p0.a.q2.a b0(b.a.p0.n.h.d dVar);

    public void c0(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, exc) == null) {
            b.a.p0.a.e0.d.h("UpdateCoreCallback", "onUpdateFailed setLatestUpdateTime = 0");
            b.a.p0.n.n.a.d(T(), 0L);
            b.a.p0.d.d.b.a(0L);
            Z(new Exception("UpdateCoreCallback onUpdateFailed: cause by = ", exc));
        }
    }

    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            b.a.p0.a.e0.d.h("UpdateCoreCallback", "onUpdateSuccess setLatestUpdateTime = " + currentTimeMillis);
            b.a.p0.n.n.a.d(T(), currentTimeMillis);
            Z(null);
        }
    }

    public final void e0(b.a.p0.n.h.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bVar) == null) {
            b.a.p0.a.h0.m.c.c().d(bVar, new d(this, bVar));
        }
    }

    public final void f0(b.a.p0.n.h.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, dVar) == null) {
            b.a.p0.a.h0.m.c.c().d(dVar, new c(this, dVar));
        }
    }

    @Override // b.a.p0.n.f.g
    public b.a.p0.n.f.c<b.a.p0.n.h.b> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.l == null) {
                this.l = new b(this);
            }
            return this.l;
        }
        return (b.a.p0.n.f.c) invokeV.objValue;
    }

    @Override // b.a.p0.n.f.g
    public b.a.p0.n.f.c<b.a.p0.n.h.d> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.k == null) {
                this.k = new a(this);
            }
            return this.k;
        }
        return (b.a.p0.n.f.c) invokeV.objValue;
    }
}
