package c.a.n0.a.x.m.t;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.p2.j0;
import c.a.n0.a.q0.d;
import c.a.n0.a.x.m.c;
import c.a.n0.a.x.m.k;
import c.a.n0.q.e.e;
import c.a.n0.q.h.h;
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

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f7307g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public c.a.n0.a.x.m.b f7308c;

    /* renamed from: d  reason: collision with root package name */
    public String f7309d;

    /* renamed from: e  reason: collision with root package name */
    public String f7310e;

    /* renamed from: f  reason: collision with root package name */
    public e<h> f7311f;

    /* renamed from: c.a.n0.a.x.m.t.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0557a extends c.a.n0.q.e.b<h> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C0557a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.q.e.e
        /* renamed from: l */
        public String d(h hVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, hVar)) == null) ? c.a.n0.a.x.m.u.b.a(this.a.f7310e) : (String) invokeL.objValue;
        }

        @Override // c.a.n0.q.e.g
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, bundle, set)) == null) ? this.a.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.q.e.b, c.a.n0.q.e.e
        /* renamed from: o */
        public void e(h hVar, c.a.n0.q.h.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, hVar, bVar) == null) {
                super.e(hVar, bVar);
                if (a.f7307g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadError:" + bVar.toString());
                }
                c.a.n0.a.k2.a aVar = new c.a.n0.a.k2.a();
                aVar.k(12L);
                aVar.i(bVar.a);
                aVar.d("分包下载失败");
                aVar.f(bVar.toString());
                this.a.T(3, aVar);
                c.c().a(hVar, PMSDownloadType.ALONE_SUB, aVar);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.q.e.b, c.a.n0.q.e.e
        /* renamed from: p */
        public void i(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, hVar) == null) {
                super.i(hVar);
                if (a.f7307g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloadFinish:" + hVar.toString());
                }
                this.a.V(hVar);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.q.e.b, c.a.n0.q.e.e
        /* renamed from: q */
        public void f(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, hVar) == null) {
                super.f(hVar);
                if (a.f7307g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloading");
                }
                this.a.W(hVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.InterfaceC0549c {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.n0.a.x.m.c.InterfaceC0549c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                this.a.U();
            }
        }

        @Override // c.a.n0.a.x.m.c.InterfaceC0549c
        public void b(PMSDownloadType pMSDownloadType, c.a.n0.a.k2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, aVar) == null) {
                this.a.T(0, aVar);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1422014397, "Lc/a/n0/a/x/m/t/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1422014397, "Lc/a/n0/a/x/m/t/a;");
                return;
            }
        }
        f7307g = c.a.n0.a.a.a;
    }

    public a(String str, String str2, c.a.n0.a.x.m.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, bVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f7311f = new C0557a(this);
        this.f7309d = str;
        this.f7308c = bVar;
        this.f7310e = d.e.i(str, str2).getPath();
    }

    @Override // c.a.n0.q.e.i
    public e<h> B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f7311f : (e) invokeV.objValue;
    }

    @Override // c.a.n0.q.e.i
    public void D(c.a.n0.q.h.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            super.D(bVar);
            c.a.n0.a.k2.a aVar = new c.a.n0.a.k2.a();
            aVar.k(12L);
            aVar.c(bVar);
            T(1, aVar);
        }
    }

    @Override // c.a.n0.q.e.i
    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.G();
            c.a.n0.a.k2.a aVar = new c.a.n0.a.k2.a();
            aVar.k(12L);
            aVar.i(2901L);
            aVar.d("Server无包");
            T(2, aVar);
        }
    }

    public final void T(int i, c.a.n0.a.k2.a aVar) {
        c.a.n0.a.x.m.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048579, this, i, aVar) == null) || (bVar = this.f7308c) == null) {
            return;
        }
        bVar.b(i, aVar);
    }

    public final void U() {
        c.a.n0.a.x.m.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (bVar = this.f7308c) == null) {
            return;
        }
        bVar.a();
    }

    public final void V(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, hVar) == null) {
            if (!j0.a(new File(hVar.a), hVar.m)) {
                if (f7307g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadFinish: 签名校验失败");
                }
                c.a.n0.a.k2.a aVar = new c.a.n0.a.k2.a();
                aVar.k(12L);
                aVar.i(2300L);
                aVar.d("分包签名校验");
                T(4, aVar);
                c.c().a(hVar, PMSDownloadType.ALONE_SUB, aVar);
            } else if (c.a.n0.a.x.m.u.b.h(new File(hVar.a), new File(this.f7310e, hVar.p))) {
                if (f7307g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloadFinish: 解压成功");
                }
                hVar.o = this.f7309d;
                c.a.n0.q.f.a.i().m(hVar);
                U();
                c.c().b(hVar, PMSDownloadType.ALONE_SUB);
            } else {
                if (f7307g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadFinish: 解压失败");
                }
                c.a.n0.a.k2.a aVar2 = new c.a.n0.a.k2.a();
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
