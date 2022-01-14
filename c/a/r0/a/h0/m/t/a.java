package c.a.r0.a.h0.m.t;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.a1.d;
import c.a.r0.a.h0.m.c;
import c.a.r0.a.h0.m.k;
import c.a.r0.a.z2.j0;
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
/* loaded from: classes.dex */
public class a extends k {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public c.a.r0.a.h0.m.b f6726g;

    /* renamed from: h  reason: collision with root package name */
    public String f6727h;

    /* renamed from: i  reason: collision with root package name */
    public String f6728i;

    /* renamed from: j  reason: collision with root package name */
    public e<h> f6729j;

    /* renamed from: c.a.r0.a.h0.m.t.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0391a extends c.a.r0.q.f.b<h> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f6730e;

        public C0391a(a aVar) {
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
            this.f6730e = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.q.f.e
        /* renamed from: l */
        public String d(h hVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, hVar)) == null) ? c.a.r0.a.h0.m.u.b.a(this.f6730e.f6728i) : (String) invokeL.objValue;
        }

        @Override // c.a.r0.q.f.g
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, bundle, set)) == null) ? this.f6730e.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.q.f.b, c.a.r0.q.f.e
        /* renamed from: o */
        public void e(h hVar, c.a.r0.q.i.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, hVar, bVar) == null) {
                super.e(hVar, bVar);
                if (a.k) {
                    String str = "onDownloadError:" + bVar.toString();
                }
                c.a.r0.a.u2.a aVar = new c.a.r0.a.u2.a();
                aVar.k(12L);
                aVar.i(bVar.a);
                aVar.d("分包下载失败");
                aVar.f(bVar.toString());
                this.f6730e.T(3, aVar);
                c.c().a(hVar, PMSDownloadType.ALONE_SUB, aVar);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.q.f.b, c.a.r0.q.f.e
        /* renamed from: p */
        public void i(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, hVar) == null) {
                super.i(hVar);
                if (a.k) {
                    String str = "onDownloadFinish:" + hVar.toString();
                }
                this.f6730e.V(hVar);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.q.f.b, c.a.r0.q.f.e
        /* renamed from: q */
        public void f(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, hVar) == null) {
                super.f(hVar);
                boolean unused = a.k;
                this.f6730e.W(hVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.InterfaceC0383c {
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

        @Override // c.a.r0.a.h0.m.c.InterfaceC0383c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                this.a.U();
            }
        }

        @Override // c.a.r0.a.h0.m.c.InterfaceC0383c
        public void b(PMSDownloadType pMSDownloadType, c.a.r0.a.u2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, aVar) == null) {
                this.a.T(0, aVar);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-35057371, "Lc/a/r0/a/h0/m/t/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-35057371, "Lc/a/r0/a/h0/m/t/a;");
                return;
            }
        }
        k = c.a.r0.a.k.a;
    }

    public a(String str, String str2, c.a.r0.a.h0.m.b bVar) {
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
        this.f6729j = new C0391a(this);
        this.f6727h = str;
        this.f6726g = bVar;
        this.f6728i = d.e.i(str, str2).getPath();
    }

    @Override // c.a.r0.q.f.i
    public e<h> B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f6729j : (e) invokeV.objValue;
    }

    @Override // c.a.r0.q.f.i
    public void D(c.a.r0.q.i.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            super.D(bVar);
            c.a.r0.a.u2.a aVar = new c.a.r0.a.u2.a();
            aVar.k(12L);
            aVar.c(bVar);
            T(1, aVar);
        }
    }

    @Override // c.a.r0.q.f.i
    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.G();
            c.a.r0.a.u2.a aVar = new c.a.r0.a.u2.a();
            aVar.k(12L);
            aVar.i(2901L);
            aVar.d("Server无包");
            T(2, aVar);
        }
    }

    public final void T(int i2, c.a.r0.a.u2.a aVar) {
        c.a.r0.a.h0.m.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048579, this, i2, aVar) == null) || (bVar = this.f6726g) == null) {
            return;
        }
        bVar.b(i2, aVar);
    }

    public final void U() {
        c.a.r0.a.h0.m.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (bVar = this.f6726g) == null) {
            return;
        }
        bVar.a();
    }

    public final void V(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, hVar) == null) {
            if (!j0.a(new File(hVar.a), hVar.m)) {
                boolean z = k;
                c.a.r0.a.u2.a aVar = new c.a.r0.a.u2.a();
                aVar.k(12L);
                aVar.i(2300L);
                aVar.d("分包签名校验");
                T(4, aVar);
                c.c().a(hVar, PMSDownloadType.ALONE_SUB, aVar);
            } else if (c.a.r0.a.h0.m.u.b.h(new File(hVar.a), new File(this.f6728i, hVar.p))) {
                boolean z2 = k;
                hVar.o = this.f6727h;
                c.a.r0.q.g.a.i().m(hVar);
                U();
                c.c().b(hVar, PMSDownloadType.ALONE_SUB);
            } else {
                boolean z3 = k;
                c.a.r0.a.u2.a aVar2 = new c.a.r0.a.u2.a();
                aVar2.k(12L);
                aVar2.i(2320L);
                aVar2.d("分包解压失败");
                T(5, aVar2);
                c.c().a(hVar, PMSDownloadType.ALONE_SUB, aVar2);
            }
        }
    }

    public final void W(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, hVar) == null) {
            c.c().d(hVar, new b(this));
        }
    }
}
