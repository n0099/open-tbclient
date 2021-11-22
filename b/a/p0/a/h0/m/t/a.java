package b.a.p0.a.h0.m.t;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.a1.d;
import b.a.p0.a.h0.m.c;
import b.a.p0.a.h0.m.k;
import b.a.p0.a.z2.j0;
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
/* loaded from: classes.dex */
public class a extends k {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public b.a.p0.a.h0.m.b f5896g;

    /* renamed from: h  reason: collision with root package name */
    public String f5897h;

    /* renamed from: i  reason: collision with root package name */
    public String f5898i;
    public e<h> j;

    /* renamed from: b.a.p0.a.h0.m.t.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0242a extends b.a.p0.q.f.b<h> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f5899e;

        public C0242a(a aVar) {
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
            this.f5899e = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.q.f.e
        /* renamed from: l */
        public String d(h hVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, hVar)) == null) ? b.a.p0.a.h0.m.u.b.a(this.f5899e.f5898i) : (String) invokeL.objValue;
        }

        @Override // b.a.p0.q.f.g
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, bundle, set)) == null) ? this.f5899e.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.q.f.b, b.a.p0.q.f.e
        /* renamed from: o */
        public void e(h hVar, b.a.p0.q.i.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, hVar, bVar) == null) {
                super.e(hVar, bVar);
                if (a.k) {
                    String str = "onDownloadError:" + bVar.toString();
                }
                b.a.p0.a.u2.a aVar = new b.a.p0.a.u2.a();
                aVar.k(12L);
                aVar.i(bVar.f11762a);
                aVar.d("分包下载失败");
                aVar.f(bVar.toString());
                this.f5899e.S(3, aVar);
                c.c().a(hVar, PMSDownloadType.ALONE_SUB, aVar);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.q.f.b, b.a.p0.q.f.e
        /* renamed from: p */
        public void i(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, hVar) == null) {
                super.i(hVar);
                if (a.k) {
                    String str = "onDownloadFinish:" + hVar.toString();
                }
                this.f5899e.U(hVar);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.q.f.b, b.a.p0.q.f.e
        /* renamed from: q */
        public void f(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, hVar) == null) {
                super.f(hVar);
                boolean unused = a.k;
                this.f5899e.V(hVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.InterfaceC0234c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f5900a;

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
            this.f5900a = aVar;
        }

        @Override // b.a.p0.a.h0.m.c.InterfaceC0234c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                this.f5900a.T();
            }
        }

        @Override // b.a.p0.a.h0.m.c.InterfaceC0234c
        public void b(PMSDownloadType pMSDownloadType, b.a.p0.a.u2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, aVar) == null) {
                this.f5900a.S(0, aVar);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1973132232, "Lb/a/p0/a/h0/m/t/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1973132232, "Lb/a/p0/a/h0/m/t/a;");
                return;
            }
        }
        k = b.a.p0.a.k.f6863a;
    }

    public a(String str, String str2, b.a.p0.a.h0.m.b bVar) {
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
        this.j = new C0242a(this);
        this.f5897h = str;
        this.f5896g = bVar;
        this.f5898i = d.e.i(str, str2).getPath();
    }

    @Override // b.a.p0.q.f.i
    public e<h> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.j : (e) invokeV.objValue;
    }

    @Override // b.a.p0.q.f.i
    public void C(b.a.p0.q.i.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            super.C(bVar);
            b.a.p0.a.u2.a aVar = new b.a.p0.a.u2.a();
            aVar.k(12L);
            aVar.c(bVar);
            S(1, aVar);
        }
    }

    @Override // b.a.p0.q.f.i
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.F();
            b.a.p0.a.u2.a aVar = new b.a.p0.a.u2.a();
            aVar.k(12L);
            aVar.i(2901L);
            aVar.d("Server无包");
            S(2, aVar);
        }
    }

    public final void S(int i2, b.a.p0.a.u2.a aVar) {
        b.a.p0.a.h0.m.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048579, this, i2, aVar) == null) || (bVar = this.f5896g) == null) {
            return;
        }
        bVar.b(i2, aVar);
    }

    public final void T() {
        b.a.p0.a.h0.m.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (bVar = this.f5896g) == null) {
            return;
        }
        bVar.a();
    }

    public final void U(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, hVar) == null) {
            if (!j0.a(new File(hVar.f11768a), hVar.m)) {
                boolean z = k;
                b.a.p0.a.u2.a aVar = new b.a.p0.a.u2.a();
                aVar.k(12L);
                aVar.i(2300L);
                aVar.d("分包签名校验");
                S(4, aVar);
                c.c().a(hVar, PMSDownloadType.ALONE_SUB, aVar);
            } else if (b.a.p0.a.h0.m.u.b.h(new File(hVar.f11768a), new File(this.f5898i, hVar.p))) {
                boolean z2 = k;
                hVar.o = this.f5897h;
                b.a.p0.q.g.a.i().m(hVar);
                T();
                c.c().b(hVar, PMSDownloadType.ALONE_SUB);
            } else {
                boolean z3 = k;
                b.a.p0.a.u2.a aVar2 = new b.a.p0.a.u2.a();
                aVar2.k(12L);
                aVar2.i(2320L);
                aVar2.d("分包解压失败");
                S(5, aVar2);
                c.c().a(hVar, PMSDownloadType.ALONE_SUB, aVar2);
            }
        }
    }

    public final void V(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, hVar) == null) {
            c.c().d(hVar, new b(this));
        }
    }
}
