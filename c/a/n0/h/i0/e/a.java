package c.a.n0.h.i0.e;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.h0.m.c;
import c.a.n0.a.h0.m.j;
import c.a.n0.a.k;
import c.a.n0.a.v2.j0;
import c.a.n0.h.i0.b;
import c.a.n0.h.s.a;
import c.a.n0.n.f.c;
import c.a.n0.n.h.g;
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
/* loaded from: classes3.dex */
public class a extends j {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean l;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public b.a f10999g;

    /* renamed from: h  reason: collision with root package name */
    public String f11000h;

    /* renamed from: i  reason: collision with root package name */
    public String f11001i;

    /* renamed from: j  reason: collision with root package name */
    public String f11002j;
    public c<g> k;

    /* renamed from: c.a.n0.h.i0.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0563a extends c.a.n0.n.f.b<g> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f11003e;

        public C0563a(a aVar) {
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
            this.f11003e = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.n.f.c
        /* renamed from: l */
        public String d(g gVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, gVar)) == null) ? c.a.n0.a.h0.m.r.b.c(this.f11003e.f11002j) : (String) invokeL.objValue;
        }

        @Override // c.a.n0.n.f.e
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bundle, set)) == null) ? this.f11003e.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.n.f.b, c.a.n0.n.f.c
        /* renamed from: o */
        public void e(g gVar, c.a.n0.n.h.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, gVar, aVar) == null) {
                super.e(gVar, aVar);
                if (a.l) {
                    String str = "onDownloadError: " + aVar.toString();
                }
                this.f11003e.S(2103);
                c.a.n0.a.q2.a aVar2 = new c.a.n0.a.q2.a();
                aVar2.j(12L);
                aVar2.h(aVar.f11601a);
                aVar2.c("分包下载失败");
                aVar2.e(aVar.toString());
                c.a.n0.a.h0.m.c.c().a(gVar, PMSDownloadType.ALONE_SUB, aVar2);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.n.f.b, c.a.n0.n.f.c
        /* renamed from: p */
        public void i(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, gVar) == null) {
                super.i(gVar);
                if (a.l) {
                    String str = "onDownloadFinish: " + gVar.toString();
                }
                this.f11003e.V(gVar);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.n.f.b, c.a.n0.n.f.c
        /* renamed from: q */
        public void a(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, gVar) == null) {
                super.a(gVar);
                if (a.l) {
                    String str = "onDownloadProgress: " + gVar.k + ":" + gVar.f11606b;
                }
                this.f11003e.T(gVar.f11606b, gVar.k);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.n.f.b, c.a.n0.n.f.c
        /* renamed from: r */
        public void f(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, gVar) == null) {
                super.f(gVar);
                boolean unused = a.l;
                this.f11003e.W(gVar);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements c.InterfaceC0218c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f11004a;

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
            this.f11004a = aVar;
        }

        @Override // c.a.n0.a.h0.m.c.InterfaceC0218c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                this.f11004a.U();
            }
        }

        @Override // c.a.n0.a.h0.m.c.InterfaceC0218c
        public void b(PMSDownloadType pMSDownloadType, c.a.n0.a.q2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, aVar) == null) {
                this.f11004a.S(2103);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948867966, "Lc/a/n0/h/i0/e/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948867966, "Lc/a/n0/h/i0/e/a;");
                return;
            }
        }
        l = k.f6803a;
    }

    public a(String str, String str2, String str3, b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3, aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.k = new C0563a(this);
        this.f11000h = str;
        this.f11001i = str3;
        this.f10999g = aVar;
        this.f11002j = a.d.h(str, str2).getPath();
    }

    @Override // c.a.n0.n.f.g
    public void B(c.a.n0.n.h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            super.B(aVar);
            if (l) {
                String str = "onFetchError: " + aVar.toString();
            }
            S(2103);
        }
    }

    @Override // c.a.n0.n.f.g
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.E();
            boolean z = l;
            S(2102);
        }
    }

    public final void S(int i2) {
        b.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || (aVar = this.f10999g) == null) {
            return;
        }
        aVar.b(i2);
    }

    public final void T(long j2, long j3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) || this.f10999g == null) {
            return;
        }
        if (j3 > 0 && j2 <= j3) {
            int floor = (int) Math.floor((j2 * 100.0d) / j3);
            if (floor != 100) {
                if (l) {
                    String str = "callbackProgress: " + floor;
                }
                this.f10999g.a(floor, j2, j3);
                return;
            }
            return;
        }
        S(2114);
    }

    public final void U() {
        b.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (aVar = this.f10999g) == null) {
            return;
        }
        aVar.success();
    }

    public final void V(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, gVar) == null) {
            if (!j0.a(new File(gVar.f11605a), gVar.m)) {
                boolean z = l;
                S(2104);
                c.a.n0.a.q2.a aVar = new c.a.n0.a.q2.a();
                aVar.j(12L);
                aVar.h(2300L);
                aVar.c("分包签名校验");
                c.a.n0.a.h0.m.c.c().a(gVar, PMSDownloadType.ALONE_SUB, aVar);
            } else if (c.a.n0.a.h0.m.r.b.h(new File(gVar.f11605a), new File(this.f11002j, this.f11001i))) {
                boolean z2 = l;
                U();
                gVar.o = this.f11000h;
                c.a.n0.n.g.a.h().l(gVar);
                c.a.n0.a.h0.m.c.c().b(gVar, PMSDownloadType.ALONE_SUB);
            } else {
                boolean z3 = l;
                S(2105);
                c.a.n0.a.q2.a aVar2 = new c.a.n0.a.q2.a();
                aVar2.j(12L);
                aVar2.h(2320L);
                aVar2.c("分包解压失败");
                c.a.n0.a.h0.m.c.c().a(gVar, PMSDownloadType.ALONE_SUB, aVar2);
            }
        }
    }

    public final void W(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, gVar) == null) {
            c.a.n0.a.h0.m.c.c().d(gVar, new b(this));
        }
    }

    @Override // c.a.n0.n.f.g
    public c.a.n0.n.f.c<g> z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.k : (c.a.n0.n.f.c) invokeV.objValue;
    }
}
