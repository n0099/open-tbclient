package c.p.a.e.b.m;

import android.app.Notification;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.core.view.InputDeviceCompat;
import c.p.a.e.b.f.w;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.downloader.downloader.IndependentProcessDownloadService;
import com.ss.android.socialbase.downloader.downloader.i;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.List;
/* loaded from: classes4.dex */
public class n implements c.p.a.e.b.g.n, c.p.a.e.b.g.o {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: d  reason: collision with root package name */
    public static final String f35333d = "n";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public volatile com.ss.android.socialbase.downloader.downloader.i f35334a;

    /* renamed from: b  reason: collision with root package name */
    public c.p.a.e.b.g.p<IndependentProcessDownloadService> f35335b;

    /* renamed from: c  reason: collision with root package name */
    public c.p.a.e.b.g.n f35336c;

    /* loaded from: classes4.dex */
    public class a implements c.p.a.e.b.f.m {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.p.a.e.b.f.m
        public void a(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        c.p.a.e.b.g.a.H(c.p.a.e.b.g.e.n()).b(i2);
                        return;
                    }
                    return;
                }
                c.p.a.e.b.g.a.H(c.p.a.e.b.g.e.n()).u(i2);
                List<com.ss.android.socialbase.downloader.model.b> i4 = l.a(false).i(i2);
                if (i4 != null) {
                    l.a(true).a(i2, c.p.a.e.b.l.f.r(i4));
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1473299637, "Lc/p/a/e/b/m/n;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1473299637, "Lc/p/a/e/b/m/n;");
        }
    }

    public n() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f35336c = new o();
        c.p.a.e.b.g.p<IndependentProcessDownloadService> O0 = c.p.a.e.b.g.e.O0();
        this.f35335b = O0;
        O0.d(this);
    }

    @Override // c.p.a.e.b.g.n
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || this.f35334a == null) {
            return;
        }
        try {
            this.f35334a.a(i2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // c.p.a.e.b.g.n
    public void b(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, downloadInfo) == null) {
        }
    }

    @Override // c.p.a.e.b.g.n
    public boolean b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048601, this, i2)) == null) {
            if (this.f35334a == null) {
                return false;
            }
            try {
                return this.f35334a.b(i2);
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeI.booleanValue;
    }

    @Override // c.p.a.e.b.g.n
    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048603, this, i2) == null) || this.f35334a == null) {
            return;
        }
        try {
            this.f35334a.c(i2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // c.p.a.e.b.g.n
    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048610, this, i2) == null) || this.f35334a == null) {
            return;
        }
        try {
            this.f35334a.d(i2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // c.p.a.e.b.g.n
    public long e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048612, this, i2)) == null) {
            if (this.f35334a == null) {
                return 0L;
            }
            try {
                return this.f35334a.e(i2);
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return 0L;
            }
        }
        return invokeI.longValue;
    }

    @Override // c.p.a.e.b.g.n
    public int f(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048616, this, i2)) == null) {
            if (this.f35334a == null) {
                return 0;
            }
            try {
                return this.f35334a.f(i2);
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return 0;
            }
        }
        return invokeI.intValue;
    }

    @Override // c.p.a.e.b.g.n
    public boolean g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048621, this, i2)) == null) {
            if (this.f35334a == null) {
                return false;
            }
            try {
                return this.f35334a.g(i2);
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeI.booleanValue;
    }

    @Override // c.p.a.e.b.g.n
    public DownloadInfo h(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048622, this, i2)) == null) {
            if (this.f35334a == null) {
                return this.f35336c.h(i2);
            }
            try {
                return this.f35334a.h(i2);
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (DownloadInfo) invokeI.objValue;
    }

    @Override // c.p.a.e.b.g.n
    public List<com.ss.android.socialbase.downloader.model.b> i(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048625, this, i2)) == null) {
            if (this.f35334a == null) {
                return this.f35336c.i(i2);
            }
            try {
                return this.f35334a.i(i2);
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (List) invokeI.objValue;
    }

    @Override // c.p.a.e.b.g.n
    public void j(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048627, this, i2) == null) {
            if (this.f35334a == null) {
                this.f35336c.j(i2);
                return;
            }
            try {
                this.f35334a.j(i2);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // c.p.a.e.b.g.n
    public void k(int i2) {
        c.p.a.e.b.g.p<IndependentProcessDownloadService> pVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048628, this, i2) == null) || (pVar = this.f35335b) == null) {
            return;
        }
        pVar.a(i2);
    }

    @Override // c.p.a.e.b.g.n
    public boolean l(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048629, this, i2)) == null) {
            if (this.f35334a == null) {
                return false;
            }
            try {
                return this.f35334a.k(i2);
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeI.booleanValue;
    }

    @Override // c.p.a.e.b.g.n
    public int m(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048630, this, i2)) == null) {
            if (this.f35334a == null) {
                return c.p.a.e.b.g.f.c().m(i2);
            }
            try {
                return this.f35334a.m(i2);
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return -1;
            }
        }
        return invokeI.intValue;
    }

    @Override // c.p.a.e.b.g.n
    public boolean n(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048631, this, i2)) == null) {
            if (this.f35334a == null) {
                return this.f35336c.n(i2);
            }
            try {
                return this.f35334a.n(i2);
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeI.booleanValue;
    }

    @Override // c.p.a.e.b.g.n
    public void o(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048632, this, i2) == null) {
            if (this.f35334a == null) {
                this.f35336c.o(i2);
                return;
            }
            try {
                this.f35334a.o(i2);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // c.p.a.e.b.g.n
    public boolean p(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048633, this, i2)) == null) {
            if (this.f35334a == null) {
                return this.f35336c.p(i2);
            }
            try {
                return this.f35334a.p(i2);
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeI.booleanValue;
    }

    @Override // c.p.a.e.b.g.n
    public c.p.a.e.b.f.e q(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048634, this, i2)) == null) {
            if (this.f35334a != null) {
                try {
                    return com.ss.android.socialbase.downloader.i.g.d(this.f35334a.q(i2));
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
            return null;
        }
        return (c.p.a.e.b.f.e) invokeI.objValue;
    }

    @Override // c.p.a.e.b.g.n
    public c.p.a.e.b.f.j r(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048635, this, i2)) == null) {
            if (this.f35334a != null) {
                try {
                    return com.ss.android.socialbase.downloader.i.g.f(this.f35334a.r(i2));
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
            return null;
        }
        return (c.p.a.e.b.f.j) invokeI.objValue;
    }

    @Override // c.p.a.e.b.g.n
    public w s(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048636, this, i2)) == null) {
            if (this.f35334a != null) {
                try {
                    return com.ss.android.socialbase.downloader.i.g.w(this.f35334a.s(i2));
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
            return null;
        }
        return (w) invokeI.objValue;
    }

    @Override // c.p.a.e.b.g.n
    public void a(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || this.f35334a == null) {
            return;
        }
        try {
            this.f35334a.a(i2, z);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // c.p.a.e.b.g.n
    public DownloadInfo b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, str, str2)) == null) ? h(a(str, str2)) : (DownloadInfo) invokeLL.objValue;
    }

    @Override // c.p.a.e.b.g.n
    public List<DownloadInfo> c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, str)) == null) {
            if (this.f35334a == null) {
                return this.f35336c.c(str);
            }
            try {
                return this.f35334a.c(str);
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (List) invokeL.objValue;
    }

    @Override // c.p.a.e.b.g.n
    public List<DownloadInfo> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            if (this.f35334a == null) {
                return this.f35336c.d();
            }
            try {
                return this.f35334a.b();
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (List) invokeV.objValue;
    }

    @Override // c.p.a.e.b.g.n
    public void e(int i2, int i3, c.p.a.e.b.f.c cVar, com.ss.android.socialbase.downloader.constants.f fVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048615, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), cVar, fVar, Boolean.valueOf(z)}) == null) || this.f35334a == null) {
            return;
        }
        try {
            this.f35334a.a(i2, i3, com.ss.android.socialbase.downloader.i.g.n(cVar, fVar != com.ss.android.socialbase.downloader.constants.f.f75841b), fVar.ordinal(), z);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // c.p.a.e.b.g.n
    public void f(int i2, int i3, c.p.a.e.b.f.c cVar, com.ss.android.socialbase.downloader.constants.f fVar, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048617, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), cVar, fVar, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || this.f35334a == null) {
            return;
        }
        try {
            this.f35334a.a(i2, i3, com.ss.android.socialbase.downloader.i.g.n(cVar, fVar != com.ss.android.socialbase.downloader.constants.f.f75841b), fVar.ordinal(), z, z2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // c.p.a.e.b.g.n
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            if (this.f35334a == null) {
                this.f35336c.g();
                return;
            }
            try {
                this.f35334a.e();
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // c.p.a.e.b.g.n
    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.f35334a != null : invokeV.booleanValue;
    }

    @Override // c.p.a.e.b.g.o
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            this.f35334a = null;
        }
    }

    @Override // c.p.a.e.b.g.n
    public List<DownloadInfo> b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) {
            if (this.f35334a == null) {
                return this.f35336c.b(str);
            }
            try {
                return this.f35334a.b(str);
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (List) invokeL.objValue;
    }

    @Override // c.p.a.e.b.g.n
    public void h(c.p.a.e.b.f.m mVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048623, this, mVar) == null) || this.f35334a == null) {
            return;
        }
        try {
            this.f35334a.a(com.ss.android.socialbase.downloader.i.g.h(mVar));
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // c.p.a.e.b.g.n
    public void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f35334a == null) {
            return;
        }
        try {
            this.f35334a.a();
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // c.p.a.e.b.g.n
    public List<DownloadInfo> e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, str)) == null) {
            if (this.f35334a != null) {
                try {
                    return this.f35334a.d(str);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    @Override // c.p.a.e.b.g.n
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            if (this.f35334a == null) {
                return this.f35336c.f();
            }
            try {
                return this.f35334a.d();
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // c.p.a.e.b.g.n
    public void c(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048605, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (this.f35334a == null) {
                c.p.a.e.b.c.a.j(f35333d, "stopForeground, aidlService is null");
                return;
            }
            c.p.a.e.b.c.a.i(f35333d, "aidlService.stopForeground");
            try {
                this.f35334a.a(z2);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // c.p.a.e.b.g.n
    public void d(int i2, int i3, c.p.a.e.b.f.c cVar, com.ss.android.socialbase.downloader.constants.f fVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048611, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), cVar, fVar, Boolean.valueOf(z)}) == null) || this.f35334a == null) {
            return;
        }
        try {
            this.f35334a.b(i2, i3, com.ss.android.socialbase.downloader.i.g.n(cVar, fVar != com.ss.android.socialbase.downloader.constants.f.f75841b), fVar.ordinal(), z);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // c.p.a.e.b.g.n
    public void g(int i2, c.p.a.e.b.f.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048620, this, i2, eVar) == null) || this.f35334a == null) {
            return;
        }
        try {
            this.f35334a.a(i2, com.ss.android.socialbase.downloader.i.g.C(eVar));
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // c.p.a.e.b.g.n
    public List<DownloadInfo> a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (this.f35334a == null) {
                return this.f35336c.a(str);
            }
            try {
                return this.f35334a.a(str);
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (List) invokeL.objValue;
    }

    @Override // c.p.a.e.b.g.n
    public void b(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, list) == null) {
            if (this.f35334a == null) {
                this.f35336c.b(list);
                return;
            }
            try {
                this.f35334a.b(list);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // c.p.a.e.b.g.n
    public void e() {
        c.p.a.e.b.g.p<IndependentProcessDownloadService> pVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048614, this) == null) || (pVar = this.f35335b) == null) {
            return;
        }
        pVar.f();
    }

    @Override // c.p.a.e.b.g.n
    public List<DownloadInfo> d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, str)) == null) {
            if (this.f35334a == null) {
                return this.f35336c.d(str);
            }
            try {
                return this.f35334a.e(str);
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (List) invokeL.objValue;
    }

    @Override // c.p.a.e.b.g.n
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? c.p.a.e.b.g.e.o() : invokeV.booleanValue;
    }

    @Override // c.p.a.e.b.g.n
    public int a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) ? c.p.a.e.b.g.e.w(str, str2) : invokeLL.intValue;
    }

    @Override // c.p.a.e.b.g.n
    public void b(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (this.f35334a == null) {
                this.f35336c.b(i2, z);
                return;
            }
            try {
                this.f35334a.b(i2, z);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // c.p.a.e.b.g.n
    public void c(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048604, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || this.f35334a == null) {
            return;
        }
        try {
            this.f35334a.d(i2, z);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // c.p.a.e.b.g.n
    public void a(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, list) == null) {
            if (this.f35334a == null) {
                this.f35336c.a(list);
                return;
            }
            try {
                this.f35334a.a(list);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // c.p.a.e.b.g.n
    public boolean c(DownloadInfo downloadInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, downloadInfo)) == null) {
            if (this.f35334a == null) {
                return this.f35336c.c(downloadInfo);
            }
            try {
                return this.f35334a.b(downloadInfo);
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // c.p.a.e.b.g.n
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            if (this.f35334a == null) {
                c.p.a.e.b.c.a.j(f35333d, "isServiceForeground, aidlService is null");
                return false;
            }
            c.p.a.e.b.c.a.i(f35333d, "aidlService.isServiceForeground");
            try {
                return this.f35334a.f();
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // c.p.a.e.b.g.n
    public boolean a(DownloadInfo downloadInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, downloadInfo)) == null) {
            if (this.f35334a == null) {
                return this.f35336c.a(downloadInfo);
            }
            try {
                this.f35334a.a(downloadInfo);
                return false;
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // c.p.a.e.b.g.n
    public void a(int i2, Notification notification) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048585, this, i2, notification) == null) {
            if (this.f35334a == null) {
                c.p.a.e.b.c.a.j(f35333d, "startForeground, aidlService is null");
                return;
            }
            String str = f35333d;
            c.p.a.e.b.c.a.i(str, "aidlService.startForeground, id = " + i2);
            try {
                this.f35334a.a(i2, notification);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // c.p.a.e.b.g.n
    public void b(c.p.a.e.b.n.a aVar) {
        c.p.a.e.b.g.p<IndependentProcessDownloadService> pVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, aVar) == null) || aVar == null || (pVar = this.f35335b) == null) {
            return;
        }
        pVar.a(aVar);
    }

    @Override // c.p.a.e.b.g.n
    public void b(int i2, List<com.ss.android.socialbase.downloader.model.b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048595, this, i2, list) == null) {
            if (this.f35334a == null) {
                this.f35336c.b(i2, list);
                return;
            }
            try {
                this.f35334a.a(i2, list);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // c.p.a.e.b.g.n
    public void a(c.p.a.e.b.n.a aVar) {
        c.p.a.e.b.g.p<IndependentProcessDownloadService> pVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, aVar) == null) || aVar == null || (pVar = this.f35335b) == null) {
            return;
        }
        pVar.b(aVar);
    }

    @Override // c.p.a.e.b.g.n
    public void a(int i2, List<com.ss.android.socialbase.downloader.model.b> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048586, this, i2, list) == null) || this.f35334a == null) {
            return;
        }
        try {
            this.f35334a.b(i2, list);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // c.p.a.e.b.g.n
    public void a(com.ss.android.socialbase.downloader.model.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bVar) == null) {
            if (this.f35334a == null) {
                this.f35336c.a(bVar);
                return;
            }
            try {
                this.f35334a.a(bVar);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // c.p.a.e.b.g.n
    public void a(int i2, int i3, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2)}) == null) {
            if (this.f35334a == null) {
                this.f35336c.a(i2, i3, j2);
                return;
            }
            try {
                this.f35334a.a(i2, i3, j2);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // c.p.a.e.b.g.n
    public void a(int i2, int i3, int i4, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(j2)}) == null) {
            if (this.f35334a == null) {
                this.f35336c.a(i2, i3, i4, j2);
                return;
            }
            try {
                this.f35334a.a(i2, i3, i4, j2);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // c.p.a.e.b.g.n
    public void a(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048581, this, i2, i3, i4, i5) == null) {
            if (this.f35334a == null) {
                this.f35336c.a(i2, i3, i4, i5);
                return;
            }
            try {
                this.f35334a.a(i2, i3, i4, i5);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // c.p.a.e.b.g.n
    public void a(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048580, this, i2, i3) == null) || this.f35334a == null) {
            return;
        }
        try {
            this.f35334a.a(i2, i3);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // c.p.a.e.b.g.o
    public void a(IBinder iBinder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, iBinder) == null) {
            this.f35334a = i.a.a(iBinder);
            if (c.p.a.e.b.l.f.F()) {
                h(new a(this));
            }
        }
    }

    @Override // c.p.a.e.b.g.n
    public void a(int i2, long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) || this.f35334a == null) {
            return;
        }
        try {
            this.f35334a.a(i2, j2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }
}
