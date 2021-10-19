package c.p.a.e.b.g;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
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
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.impls.DownloadHandleService;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static volatile f f35145d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public volatile SparseArray<Boolean> f35146a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f35147b;

    /* renamed from: c  reason: collision with root package name */
    public volatile List<c.p.a.e.b.f.h> f35148c;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f35149e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.p.a.e.b.n.a f35150f;

        public a(f fVar, n nVar, c.p.a.e.b.n.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, nVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35149e = nVar;
            this.f35150f = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f35149e.b(this.f35150f);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1473478631, "Lc/p/a/e/b/g/f;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1473478631, "Lc/p/a/e/b/g/f;");
        }
    }

    public f() {
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
        this.f35146a = new SparseArray<>();
        this.f35147b = new Handler(Looper.getMainLooper());
        this.f35148c = new ArrayList();
    }

    public static f c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f35145d == null) {
                synchronized (f.class) {
                    f35145d = new f();
                }
            }
            return f35145d;
        }
        return (f) invokeV.objValue;
    }

    public List<DownloadInfo> A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
            n a2 = c.p.a.e.b.m.l.a(false);
            List<DownloadInfo> e2 = a2 != null ? a2.e(str) : null;
            n a3 = c.p.a.e.b.m.l.a(true);
            return e(e2, a3 != null ? a3.e(str) : null, sparseArray);
        }
        return (List) invokeL.objValue;
    }

    public boolean B(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            n t = t(i2);
            if (t == null) {
                return false;
            }
            return t.b(i2);
        }
        return invokeI.booleanValue;
    }

    public void C(int i2) {
        n t;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || (t = t(i2)) == null) {
            return;
        }
        t.c(i2);
    }

    public void D(int i2) {
        n t;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || (t = t(i2)) == null) {
            return;
        }
        t.d(i2);
    }

    public int E(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            n t = t(i2);
            if (t == null) {
                return 0;
            }
            return t.f(i2);
        }
        return invokeI.intValue;
    }

    public boolean F(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            n t = t(i2);
            if (t == null) {
                return false;
            }
            return t.g(i2);
        }
        return invokeI.booleanValue;
    }

    public DownloadInfo G(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            n t = t(i2);
            if (t == null) {
                return null;
            }
            return t.h(i2);
        }
        return (DownloadInfo) invokeI.objValue;
    }

    public c.p.a.e.b.f.e H(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            n t = t(i2);
            if (t == null) {
                return null;
            }
            return t.q(i2);
        }
        return (c.p.a.e.b.f.e) invokeI.objValue;
    }

    public c.p.a.e.b.f.j I(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            n t = t(i2);
            if (t == null) {
                return null;
            }
            return t.r(i2);
        }
        return (c.p.a.e.b.f.j) invokeI.objValue;
    }

    public boolean J(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            n t = t(i2);
            if (t == null) {
                return false;
            }
            return t.l(i2);
        }
        return invokeI.booleanValue;
    }

    public void K(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048586, this, i2) == null) || i2 == 0) {
            return;
        }
        r(i2, true);
        n a2 = c.p.a.e.b.m.l.a(true);
        if (a2 == null) {
            return;
        }
        a2.e();
    }

    public w L(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) {
            n t = t(i2);
            if (t == null) {
                return null;
            }
            return t.s(i2);
        }
        return (w) invokeI.objValue;
    }

    public int a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) {
            if (e.s()) {
                if (!c.p.a.e.b.l.f.p0() && c.p.a.e.b.m.l.a(true).h()) {
                    return c.p.a.e.b.m.l.a(true).m(i2);
                }
                return m(i2);
            }
            return -1;
        }
        return invokeI.intValue;
    }

    public int b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, str, str2)) == null) ? e.w(str, str2) : invokeLL.intValue;
    }

    public List<DownloadInfo> d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            List<DownloadInfo> a2 = c.p.a.e.b.m.l.a(false).a(str);
            List<DownloadInfo> a3 = c.p.a.e.b.m.l.a(true).a(str);
            if (a2 == null && a3 == null) {
                return null;
            }
            if (a2 == null || a3 == null) {
                return a2 != null ? a2 : a3;
            }
            ArrayList arrayList = new ArrayList(a2);
            arrayList.addAll(a3);
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public final List<DownloadInfo> e(List<DownloadInfo> list, List<DownloadInfo> list2, SparseArray<DownloadInfo> sparseArray) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048591, this, list, list2, sparseArray)) == null) {
            ArrayList arrayList = new ArrayList();
            if (list != null) {
                for (DownloadInfo downloadInfo : list) {
                    if (downloadInfo != null && sparseArray.get(downloadInfo.getId()) == null) {
                        sparseArray.put(downloadInfo.getId(), downloadInfo);
                    }
                }
            }
            if (list2 != null) {
                for (DownloadInfo downloadInfo2 : list2) {
                    if (downloadInfo2 != null && sparseArray.get(downloadInfo2.getId()) == null) {
                        sparseArray.put(downloadInfo2.getId(), downloadInfo2);
                    }
                }
            }
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                arrayList.add(sparseArray.get(sparseArray.keyAt(i2)));
            }
            return arrayList;
        }
        return (List) invokeLLL.objValue;
    }

    public void f(int i2, c.p.a.e.b.f.c cVar, com.ss.android.socialbase.downloader.constants.f fVar, boolean z) {
        n t;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Integer.valueOf(i2), cVar, fVar, Boolean.valueOf(z)}) == null) || (t = t(i2)) == null) {
            return;
        }
        t.e(i2, cVar == null ? 0 : cVar.hashCode(), cVar, fVar, z);
    }

    public void g(int i2, c.p.a.e.b.f.c cVar, com.ss.android.socialbase.downloader.constants.f fVar, boolean z, boolean z2) {
        n t;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Integer.valueOf(i2), cVar, fVar, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || (t = t(i2)) == null) {
            return;
        }
        t.f(i2, cVar.hashCode(), cVar, fVar, z, z2);
    }

    public void h(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            r(i2, z);
            if (e.s() && !c.p.a.e.b.l.f.p0() && c.p.a.e.b.m.l.a(true).h()) {
                c.p.a.e.b.m.l.a(true).c(i2, z);
            }
            if (e.m0() || c.p.a.e.b.l.f.p0() || c.p.a.e.b.l.f.F()) {
                return;
            }
            try {
                Intent intent = new Intent(e.n(), DownloadHandleService.class);
                intent.setAction("com.ss.android.downloader.action.PROCESS_NOTIFY");
                intent.putExtra("extra_download_id", i2);
                e.n().startService(intent);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void i(c.p.a.e.b.f.q qVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, qVar) == null) {
            e.J(qVar);
        }
    }

    public void j(c.p.a.e.b.n.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, aVar) == null) {
            n n = n(aVar);
            if (n == null) {
                if (aVar != null) {
                    c.p.a.e.b.e.a.e(aVar.R(), aVar.J(), new BaseException(1003, "tryDownload but getDownloadHandler failed"), aVar.J() != null ? aVar.J().getStatus() : 0);
                }
            } else if (aVar.a0()) {
                this.f35147b.postDelayed(new a(this, n, aVar), 500L);
            } else {
                n.b(aVar);
            }
        }
    }

    public void k(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, list) == null) {
            n a2 = c.p.a.e.b.m.l.a(false);
            if (a2 != null) {
                a2.a(list);
            }
            n a3 = c.p.a.e.b.m.l.a(true);
            if (a3 != null) {
                a3.a(list);
            }
        }
    }

    public boolean l(DownloadInfo downloadInfo) {
        InterceptResult invokeL;
        n t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, downloadInfo)) == null) {
            if (downloadInfo == null || (t = t(downloadInfo.getId())) == null) {
                return false;
            }
            return t.a(downloadInfo);
        }
        return invokeL.booleanValue;
    }

    public synchronized int m(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048599, this, i2)) == null) {
            synchronized (this) {
                if (this.f35146a.get(i2) == null) {
                    return -1;
                }
                return this.f35146a.get(i2).booleanValue() ? 1 : 0;
            }
        }
        return invokeI.intValue;
    }

    public final n n(c.p.a.e.b.n.a aVar) {
        InterceptResult invokeL;
        DownloadInfo J;
        List<com.ss.android.socialbase.downloader.model.b> i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, aVar)) == null) {
            if (aVar == null || (J = aVar.J()) == null) {
                return null;
            }
            J.isNeedIndependentProcess();
            boolean z = (c.p.a.e.b.l.f.p0() || !c.p.a.e.b.l.f.F()) ? true : true;
            int a2 = a(J.getId());
            if (a2 >= 0 && a2 != z) {
                try {
                    if (a2 == 1) {
                        if (c.p.a.e.b.l.f.F()) {
                            c.p.a.e.b.m.l.a(true).a(J.getId());
                            DownloadInfo h2 = c.p.a.e.b.m.l.a(true).h(J.getId());
                            if (h2 != null) {
                                c.p.a.e.b.m.l.a(false).b(h2);
                            }
                            if (h2.getChunkCount() > 1 && (i2 = c.p.a.e.b.m.l.a(true).i(J.getId())) != null) {
                                c.p.a.e.b.m.l.a(false).a(J.getId(), c.p.a.e.b.l.f.r(i2));
                            }
                        }
                    } else if (c.p.a.e.b.l.f.F()) {
                        c.p.a.e.b.m.l.a(false).a(J.getId());
                        List<com.ss.android.socialbase.downloader.model.b> i3 = c.p.a.e.b.m.l.a(false).i(J.getId());
                        if (i3 != null) {
                            c.p.a.e.b.m.l.a(true).a(J.getId(), c.p.a.e.b.l.f.r(i3));
                        }
                    } else {
                        aVar.I0(true);
                        c.p.a.e.b.m.l.a(true).a(1, J.getId());
                    }
                } catch (Throwable unused) {
                }
            }
            h(J.getId(), z);
            return c.p.a.e.b.m.l.a(z);
        }
        return (n) invokeL.objValue;
    }

    public DownloadInfo o(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048601, this, str, str2)) == null) {
            int b2 = b(str, str2);
            n t = t(b2);
            if (t == null) {
                return null;
            }
            return t.h(b2);
        }
        return (DownloadInfo) invokeLL.objValue;
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            synchronized (this.f35148c) {
                for (c.p.a.e.b.f.h hVar : this.f35148c) {
                    if (hVar != null) {
                        hVar.a();
                    }
                }
            }
        }
    }

    public void q(int i2, c.p.a.e.b.f.c cVar, com.ss.android.socialbase.downloader.constants.f fVar, boolean z) {
        n t;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048603, this, new Object[]{Integer.valueOf(i2), cVar, fVar, Boolean.valueOf(z)}) == null) || (t = t(i2)) == null) {
            return;
        }
        t.d(i2, cVar.hashCode(), cVar, fVar, z);
    }

    public synchronized void r(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048604, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            synchronized (this) {
                this.f35146a.put(i2, z ? Boolean.TRUE : Boolean.FALSE);
            }
        }
    }

    public void s(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, list) == null) {
            n a2 = c.p.a.e.b.m.l.a(false);
            if (a2 != null) {
                a2.b(list);
            }
            n a3 = c.p.a.e.b.m.l.a(true);
            if (a3 != null) {
                a3.b(list);
            }
        }
    }

    public n t(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048606, this, i2)) == null) {
            boolean z = true;
            return c.p.a.e.b.m.l.a((a(i2) != 1 || c.p.a.e.b.l.f.p0()) ? false : false);
        }
        return (n) invokeI.objValue;
    }

    public List<DownloadInfo> u(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, str)) == null) {
            SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
            n a2 = c.p.a.e.b.m.l.a(false);
            List<DownloadInfo> c2 = a2 != null ? a2.c(str) : null;
            n a3 = c.p.a.e.b.m.l.a(true);
            return e(c2, a3 != null ? a3.c(str) : null, sparseArray);
        }
        return (List) invokeL.objValue;
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            n a2 = c.p.a.e.b.m.l.a(false);
            if (a2 != null) {
                a2.a();
            }
            n a3 = c.p.a.e.b.m.l.a(true);
            if (a3 != null) {
                a3.a();
            }
        }
    }

    public void w(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048609, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (c.p.a.e.b.l.f.F()) {
                if (c.p.a.e.b.l.a.a(8388608)) {
                    n a2 = c.p.a.e.b.m.l.a(true);
                    if (a2 != null) {
                        a2.a(i2, z);
                    }
                    n a3 = c.p.a.e.b.m.l.a(false);
                    if (a3 != null) {
                        a3.a(i2, z);
                        return;
                    }
                    return;
                }
                n a4 = c.p.a.e.b.m.l.a(false);
                if (a4 != null) {
                    a4.a(i2, z);
                }
                n a5 = c.p.a.e.b.m.l.a(true);
                if (a5 != null) {
                    a5.a(i2, z);
                    return;
                }
                return;
            }
            n t = t(i2);
            if (t != null) {
                t.a(i2, z);
            }
            c.p.a.e.b.m.l.a(true).a(2, i2);
        }
    }

    public List<DownloadInfo> x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, str)) == null) {
            SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
            n a2 = c.p.a.e.b.m.l.a(false);
            List<DownloadInfo> d2 = a2 != null ? a2.d(str) : null;
            n a3 = c.p.a.e.b.m.l.a(true);
            return e(d2, a3 != null ? a3.d(str) : null, sparseArray);
        }
        return (List) invokeL.objValue;
    }

    public void y(int i2) {
        n t;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048611, this, i2) == null) || (t = t(i2)) == null) {
            return;
        }
        t.a(i2);
    }

    public void z(int i2, boolean z) {
        n t;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048612, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || (t = t(i2)) == null) {
            return;
        }
        t.b(i2, z);
    }
}
