package c.a.r0.j.j0.e;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.h0.m.c;
import c.a.r0.a.h0.m.k;
import c.a.r0.a.z2.j0;
import c.a.r0.j.j0.b;
import c.a.r0.j.t.a;
import c.a.r0.q.f.e;
import c.a.r0.q.i.h;
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
/* loaded from: classes6.dex */
public class a extends k {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean l;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public b.a f11187g;

    /* renamed from: h  reason: collision with root package name */
    public String f11188h;

    /* renamed from: i  reason: collision with root package name */
    public String f11189i;

    /* renamed from: j  reason: collision with root package name */
    public String f11190j;
    public e<h> k;

    /* renamed from: c.a.r0.j.j0.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0759a extends c.a.r0.q.f.b<h> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f11191e;

        public C0759a(a aVar) {
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
            this.f11191e = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.q.f.e
        /* renamed from: l */
        public String d(h hVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, hVar)) == null) ? c.a.r0.a.h0.m.u.b.c(this.f11191e.f11190j) : (String) invokeL.objValue;
        }

        @Override // c.a.r0.q.f.g
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bundle, set)) == null) ? this.f11191e.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.q.f.b, c.a.r0.q.f.e
        /* renamed from: o */
        public void e(h hVar, c.a.r0.q.i.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, hVar, bVar) == null) {
                super.e(hVar, bVar);
                if (a.l) {
                    String str = "onDownloadError: " + bVar.toString();
                }
                this.f11191e.U(2103);
                c.a.r0.a.u2.a aVar = new c.a.r0.a.u2.a();
                aVar.k(12L);
                aVar.i(bVar.a);
                aVar.d("分包下载失败");
                aVar.f(bVar.toString());
                c.c().a(hVar, PMSDownloadType.ALONE_SUB, aVar);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.q.f.b, c.a.r0.q.f.e
        /* renamed from: p */
        public void i(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, hVar) == null) {
                super.i(hVar);
                if (a.l) {
                    String str = "onDownloadFinish: " + hVar.toString();
                }
                this.f11191e.X(hVar);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.q.f.b, c.a.r0.q.f.e
        /* renamed from: q */
        public void a(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, hVar) == null) {
                super.a(hVar);
                if (a.l) {
                    String str = "onDownloadProgress: " + hVar.k + ":" + hVar.f11631b;
                }
                this.f11191e.V(hVar.f11631b, hVar.k);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.q.f.b, c.a.r0.q.f.e
        /* renamed from: r */
        public void f(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, hVar) == null) {
                super.f(hVar);
                boolean unused = a.l;
                this.f11191e.Y(hVar);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements c.InterfaceC0392c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

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
            this.a = aVar;
        }

        @Override // c.a.r0.a.h0.m.c.InterfaceC0392c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                this.a.W();
            }
        }

        @Override // c.a.r0.a.h0.m.c.InterfaceC0392c
        public void b(PMSDownloadType pMSDownloadType, c.a.r0.a.u2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, aVar) == null) {
                this.a.U(2103);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-262206403, "Lc/a/r0/j/j0/e/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-262206403, "Lc/a/r0/j/j0/e/a;");
                return;
            }
        }
        l = c.a.r0.a.k.a;
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
        this.k = new C0759a(this);
        this.f11188h = str;
        this.f11189i = str3;
        this.f11187g = aVar;
        this.f11190j = a.d.h(str, str2).getPath();
    }

    @Override // c.a.r0.q.f.i
    public e<h> B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.k : (e) invokeV.objValue;
    }

    @Override // c.a.r0.q.f.i
    public void D(c.a.r0.q.i.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            super.D(bVar);
            if (l) {
                String str = "onFetchError: " + bVar.toString();
            }
            U(2103);
        }
    }

    @Override // c.a.r0.q.f.i
    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.G();
            boolean z = l;
            U(2102);
        }
    }

    public final void U(int i2) {
        b.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || (aVar = this.f11187g) == null) {
            return;
        }
        aVar.b(i2);
    }

    public final void V(long j2, long j3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) || this.f11187g == null) {
            return;
        }
        if (j3 > 0 && j2 <= j3) {
            int floor = (int) Math.floor((j2 * 100.0d) / j3);
            if (floor != 100) {
                if (l) {
                    String str = "callbackProgress: " + floor;
                }
                this.f11187g.a(floor, j2, j3);
                return;
            }
            return;
        }
        U(2114);
    }

    public final void W() {
        b.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (aVar = this.f11187g) == null) {
            return;
        }
        aVar.success();
    }

    public final void X(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, hVar) == null) {
            if (!j0.a(new File(hVar.a), hVar.m)) {
                boolean z = l;
                U(2104);
                c.a.r0.a.u2.a aVar = new c.a.r0.a.u2.a();
                aVar.k(12L);
                aVar.i(2300L);
                aVar.d("分包签名校验");
                c.c().a(hVar, PMSDownloadType.ALONE_SUB, aVar);
            } else if (c.a.r0.a.h0.m.u.b.h(new File(hVar.a), new File(this.f11190j, this.f11189i))) {
                boolean z2 = l;
                W();
                hVar.o = this.f11188h;
                c.a.r0.q.g.a.i().m(hVar);
                c.c().b(hVar, PMSDownloadType.ALONE_SUB);
            } else {
                boolean z3 = l;
                U(2105);
                c.a.r0.a.u2.a aVar2 = new c.a.r0.a.u2.a();
                aVar2.k(12L);
                aVar2.i(2320L);
                aVar2.d("分包解压失败");
                c.c().a(hVar, PMSDownloadType.ALONE_SUB, aVar2);
            }
        }
    }

    public final void Y(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, hVar) == null) {
            c.c().d(hVar, new b(this));
        }
    }
}
