package b.a.p0.j.j0.e;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.h0.m.c;
import b.a.p0.a.h0.m.k;
import b.a.p0.a.z2.j0;
import b.a.p0.j.j0.b;
import b.a.p0.j.t.a;
import b.a.p0.q.f.e;
import b.a.p0.q.i.h;
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
/* loaded from: classes4.dex */
public class a extends k {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean l;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public b.a f11197g;

    /* renamed from: h  reason: collision with root package name */
    public String f11198h;

    /* renamed from: i  reason: collision with root package name */
    public String f11199i;
    public String j;
    public e<h> k;

    /* renamed from: b.a.p0.j.j0.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0601a extends b.a.p0.q.f.b<h> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f11200e;

        public C0601a(a aVar) {
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
            this.f11200e = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.q.f.e
        /* renamed from: l */
        public String d(h hVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, hVar)) == null) ? b.a.p0.a.h0.m.u.b.c(this.f11200e.j) : (String) invokeL.objValue;
        }

        @Override // b.a.p0.q.f.g
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bundle, set)) == null) ? this.f11200e.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.q.f.b, b.a.p0.q.f.e
        /* renamed from: o */
        public void e(h hVar, b.a.p0.q.i.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, hVar, bVar) == null) {
                super.e(hVar, bVar);
                if (a.l) {
                    String str = "onDownloadError: " + bVar.toString();
                }
                this.f11200e.T(2103);
                b.a.p0.a.u2.a aVar = new b.a.p0.a.u2.a();
                aVar.k(12L);
                aVar.i(bVar.f11762a);
                aVar.d("分包下载失败");
                aVar.f(bVar.toString());
                c.c().a(hVar, PMSDownloadType.ALONE_SUB, aVar);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.q.f.b, b.a.p0.q.f.e
        /* renamed from: p */
        public void i(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, hVar) == null) {
                super.i(hVar);
                if (a.l) {
                    String str = "onDownloadFinish: " + hVar.toString();
                }
                this.f11200e.W(hVar);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.q.f.b, b.a.p0.q.f.e
        /* renamed from: q */
        public void a(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, hVar) == null) {
                super.a(hVar);
                if (a.l) {
                    String str = "onDownloadProgress: " + hVar.k + ":" + hVar.f11769b;
                }
                this.f11200e.U(hVar.f11769b, hVar.k);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.q.f.b, b.a.p0.q.f.e
        /* renamed from: r */
        public void f(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, hVar) == null) {
                super.f(hVar);
                boolean unused = a.l;
                this.f11200e.X(hVar);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements c.InterfaceC0234c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f11201a;

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
            this.f11201a = aVar;
        }

        @Override // b.a.p0.a.h0.m.c.InterfaceC0234c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                this.f11201a.V();
            }
        }

        @Override // b.a.p0.a.h0.m.c.InterfaceC0234c
        public void b(PMSDownloadType pMSDownloadType, b.a.p0.a.u2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, aVar) == null) {
                this.f11201a.T(2103);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-9837664, "Lb/a/p0/j/j0/e/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-9837664, "Lb/a/p0/j/j0/e/a;");
                return;
            }
        }
        l = b.a.p0.a.k.f6863a;
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
        this.k = new C0601a(this);
        this.f11198h = str;
        this.f11199i = str3;
        this.f11197g = aVar;
        this.j = a.d.h(str, str2).getPath();
    }

    @Override // b.a.p0.q.f.i
    public e<h> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.k : (e) invokeV.objValue;
    }

    @Override // b.a.p0.q.f.i
    public void C(b.a.p0.q.i.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            super.C(bVar);
            if (l) {
                String str = "onFetchError: " + bVar.toString();
            }
            T(2103);
        }
    }

    @Override // b.a.p0.q.f.i
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.F();
            boolean z = l;
            T(2102);
        }
    }

    public final void T(int i2) {
        b.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || (aVar = this.f11197g) == null) {
            return;
        }
        aVar.a(i2);
    }

    public final void U(long j, long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) || this.f11197g == null) {
            return;
        }
        if (j2 > 0 && j <= j2) {
            int floor = (int) Math.floor((j * 100.0d) / j2);
            if (floor != 100) {
                if (l) {
                    String str = "callbackProgress: " + floor;
                }
                this.f11197g.b(floor, j, j2);
                return;
            }
            return;
        }
        T(2114);
    }

    public final void V() {
        b.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (aVar = this.f11197g) == null) {
            return;
        }
        aVar.success();
    }

    public final void W(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, hVar) == null) {
            if (!j0.a(new File(hVar.f11768a), hVar.m)) {
                boolean z = l;
                T(2104);
                b.a.p0.a.u2.a aVar = new b.a.p0.a.u2.a();
                aVar.k(12L);
                aVar.i(2300L);
                aVar.d("分包签名校验");
                c.c().a(hVar, PMSDownloadType.ALONE_SUB, aVar);
            } else if (b.a.p0.a.h0.m.u.b.h(new File(hVar.f11768a), new File(this.j, this.f11199i))) {
                boolean z2 = l;
                V();
                hVar.o = this.f11198h;
                b.a.p0.q.g.a.i().m(hVar);
                c.c().b(hVar, PMSDownloadType.ALONE_SUB);
            } else {
                boolean z3 = l;
                T(2105);
                b.a.p0.a.u2.a aVar2 = new b.a.p0.a.u2.a();
                aVar2.k(12L);
                aVar2.i(2320L);
                aVar2.d("分包解压失败");
                c.c().a(hVar, PMSDownloadType.ALONE_SUB, aVar2);
            }
        }
    }

    public final void X(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, hVar) == null) {
            c.c().d(hVar, new b(this));
        }
    }
}
