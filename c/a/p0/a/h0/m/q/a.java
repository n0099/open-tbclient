package c.a.p0.a.h0.m.q;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.a1.e;
import c.a.p0.a.h0.m.c;
import c.a.p0.a.h0.m.j;
import c.a.p0.a.k;
import c.a.p0.a.v2.j0;
import c.a.p0.n.f.c;
import c.a.p0.n.h.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Set;
/* loaded from: classes.dex */
public class a extends j {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public c.a.p0.a.h0.m.b f6270g;

    /* renamed from: h  reason: collision with root package name */
    public String f6271h;

    /* renamed from: i  reason: collision with root package name */
    public String f6272i;

    /* renamed from: j  reason: collision with root package name */
    public c<g> f6273j;

    /* renamed from: c.a.p0.a.h0.m.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0236a extends c.a.p0.n.f.b<g> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f6274e;

        public C0236a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6274e = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.n.f.c
        /* renamed from: l */
        public String d(g gVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, gVar)) == null) ? c.a.p0.a.h0.m.r.b.a(this.f6274e.f6272i) : (String) invokeL.objValue;
        }

        @Override // c.a.p0.n.f.e
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, bundle, set)) == null) ? this.f6274e.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.n.f.b, c.a.p0.n.f.c
        /* renamed from: o */
        public void e(g gVar, c.a.p0.n.h.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, gVar, aVar) == null) {
                super.e(gVar, aVar);
                if (a.k) {
                    String str = "onDownloadError:" + aVar.toString();
                }
                c.a.p0.a.q2.a aVar2 = new c.a.p0.a.q2.a();
                aVar2.j(12L);
                aVar2.h(aVar.f11883a);
                aVar2.c("分包下载失败");
                aVar2.e(aVar.toString());
                this.f6274e.R(3, aVar2);
                c.a.p0.a.h0.m.c.c().a(gVar, PMSDownloadType.ALONE_SUB, aVar2);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.n.f.b, c.a.p0.n.f.c
        /* renamed from: p */
        public void i(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, gVar) == null) {
                super.i(gVar);
                if (a.k) {
                    String str = "onDownloadFinish:" + gVar.toString();
                }
                this.f6274e.T(gVar);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.n.f.b, c.a.p0.n.f.c
        /* renamed from: q */
        public void f(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, gVar) == null) {
                super.f(gVar);
                boolean unused = a.k;
                this.f6274e.U(gVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.InterfaceC0228c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f6275a;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6275a = aVar;
        }

        @Override // c.a.p0.a.h0.m.c.InterfaceC0228c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                this.f6275a.S();
            }
        }

        @Override // c.a.p0.a.h0.m.c.InterfaceC0228c
        public void b(PMSDownloadType pMSDownloadType, c.a.p0.a.q2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, aVar) == null) {
                this.f6275a.R(0, aVar);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(975970506, "Lc/a/p0/a/h0/m/q/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(975970506, "Lc/a/p0/a/h0/m/q/a;");
                return;
            }
        }
        k = k.f7085a;
    }

    public a(String str, String str2, c.a.p0.a.h0.m.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, bVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f6273j = new C0236a(this);
        this.f6271h = str;
        this.f6270g = bVar;
        this.f6272i = e.C0114e.i(str, str2).getPath();
    }

    @Override // c.a.p0.n.f.g
    public void B(c.a.p0.n.h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            super.B(aVar);
            c.a.p0.a.q2.a aVar2 = new c.a.p0.a.q2.a();
            aVar2.j(12L);
            aVar2.h(aVar.f11883a);
            aVar2.c(aVar.f11884b);
            aVar2.p(aVar.f11885c);
            R(1, aVar2);
        }
    }

    @Override // c.a.p0.n.f.g
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.E();
            c.a.p0.a.q2.a aVar = new c.a.p0.a.q2.a();
            aVar.j(12L);
            aVar.h(2901L);
            aVar.c("Server无包");
            R(2, aVar);
        }
    }

    public final void R(int i2, c.a.p0.a.q2.a aVar) {
        c.a.p0.a.h0.m.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, aVar) == null) || (bVar = this.f6270g) == null) {
            return;
        }
        bVar.b(i2, aVar);
    }

    public final void S() {
        c.a.p0.a.h0.m.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (bVar = this.f6270g) == null) {
            return;
        }
        bVar.a();
    }

    public final void T(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, gVar) == null) {
            if (!j0.a(new File(gVar.f11887a), gVar.m)) {
                boolean z = k;
                c.a.p0.a.q2.a aVar = new c.a.p0.a.q2.a();
                aVar.j(12L);
                aVar.h(2300L);
                aVar.c("分包签名校验");
                R(4, aVar);
                c.a.p0.a.h0.m.c.c().a(gVar, PMSDownloadType.ALONE_SUB, aVar);
            } else if (c.a.p0.a.h0.m.r.b.h(new File(gVar.f11887a), new File(this.f6272i, gVar.p))) {
                boolean z2 = k;
                gVar.o = this.f6271h;
                c.a.p0.n.g.a.h().l(gVar);
                S();
                c.a.p0.a.h0.m.c.c().b(gVar, PMSDownloadType.ALONE_SUB);
            } else {
                boolean z3 = k;
                c.a.p0.a.q2.a aVar2 = new c.a.p0.a.q2.a();
                aVar2.j(12L);
                aVar2.h(2320L);
                aVar2.c("分包解压失败");
                R(5, aVar2);
                c.a.p0.a.h0.m.c.c().a(gVar, PMSDownloadType.ALONE_SUB, aVar2);
            }
        }
    }

    public final void U(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, gVar) == null) {
            c.a.p0.a.h0.m.c.c().d(gVar, new b(this));
        }
    }

    @Override // c.a.p0.n.f.g
    public c.a.p0.n.f.c<g> z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f6273j : (c.a.p0.n.f.c) invokeV.objValue;
    }
}
