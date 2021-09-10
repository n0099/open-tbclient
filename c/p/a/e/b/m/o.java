package c.p.a.e.b.m;

import android.app.Notification;
import androidx.core.view.InputDeviceCompat;
import c.p.a.e.b.f.w;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.List;
/* loaded from: classes4.dex */
public class o implements c.p.a.e.b.g.n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final a f35337a;

    /* renamed from: b  reason: collision with root package name */
    public final c.p.a.e.b.g.k f35338b;

    /* renamed from: c  reason: collision with root package name */
    public final c.p.a.e.b.g.p f35339c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f35340d;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public o() {
        this(false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this(((Boolean) newInitContext.callArgs[0]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.p.a.e.b.g.n
    public void a(int i2) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || (aVar = this.f35337a) == null) {
            return;
        }
        aVar.J(i2);
    }

    @Override // c.p.a.e.b.g.n
    public boolean b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048600, this, i2)) == null) {
            a aVar = this.f35337a;
            if (aVar != null) {
                return aVar.S(i2);
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    @Override // c.p.a.e.b.g.n
    public void c(int i2) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048602, this, i2) == null) || (aVar = this.f35337a) == null) {
            return;
        }
        aVar.K(i2);
    }

    @Override // c.p.a.e.b.g.n
    public void d(int i2) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048609, this, i2) == null) || (aVar = this.f35337a) == null) {
            return;
        }
        aVar.L(i2);
    }

    @Override // c.p.a.e.b.g.n
    public long e(int i2) {
        InterceptResult invokeI;
        DownloadInfo b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048611, this, i2)) == null) {
            c.p.a.e.b.g.k kVar = this.f35338b;
            if (kVar == null || (b2 = kVar.b(i2)) == null) {
                return 0L;
            }
            int chunkCount = b2.getChunkCount();
            if (chunkCount <= 1) {
                return b2.getCurBytes();
            }
            List<com.ss.android.socialbase.downloader.model.b> c2 = this.f35338b.c(i2);
            if (c2 == null || c2.size() != chunkCount) {
                return 0L;
            }
            return c.p.a.e.b.l.f.W(c2);
        }
        return invokeI.longValue;
    }

    @Override // c.p.a.e.b.g.n
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
        }
    }

    @Override // c.p.a.e.b.g.n
    public int f(int i2) {
        InterceptResult invokeI;
        DownloadInfo G;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048615, this, i2)) == null) {
            a aVar = this.f35337a;
            if (aVar == null || (G = aVar.G(i2)) == null) {
                return 0;
            }
            return G.getStatus();
        }
        return invokeI.intValue;
    }

    @Override // c.p.a.e.b.g.n
    public boolean g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048620, this, i2)) == null) {
            a aVar = this.f35337a;
            if (aVar != null) {
                return aVar.r(i2);
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    @Override // c.p.a.e.b.g.n
    public DownloadInfo h(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048621, this, i2)) == null) {
            a aVar = this.f35337a;
            if (aVar != null) {
                return aVar.G(i2);
            }
            return null;
        }
        return (DownloadInfo) invokeI.objValue;
    }

    @Override // c.p.a.e.b.g.n
    public List<com.ss.android.socialbase.downloader.model.b> i(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048624, this, i2)) == null) ? this.f35338b.c(i2) : (List) invokeI.objValue;
    }

    @Override // c.p.a.e.b.g.n
    public void j(int i2) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048626, this, i2) == null) || (aVar = this.f35337a) == null) {
            return;
        }
        aVar.R(i2);
    }

    @Override // c.p.a.e.b.g.n
    public void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048627, this, i2) == null) {
            c.p.a.e.b.c.a.a(i2);
        }
    }

    @Override // c.p.a.e.b.g.n
    public boolean l(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048628, this, i2)) == null) {
            a aVar = this.f35337a;
            if (aVar != null) {
                return aVar.P(i2);
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    @Override // c.p.a.e.b.g.n
    public int m(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048629, this, i2)) == null) ? c.p.a.e.b.g.f.c().a(i2) : invokeI.intValue;
    }

    @Override // c.p.a.e.b.g.n
    public boolean n(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048630, this, i2)) == null) ? this.f35338b.e(i2) : invokeI.booleanValue;
    }

    @Override // c.p.a.e.b.g.n
    public void o(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048631, this, i2) == null) {
            this.f35338b.d(i2);
        }
    }

    @Override // c.p.a.e.b.g.n
    public boolean p(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048632, this, i2)) == null) ? this.f35338b.f(i2) : invokeI.booleanValue;
    }

    @Override // c.p.a.e.b.g.n
    public c.p.a.e.b.f.e q(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048633, this, i2)) == null) {
            a aVar = this.f35337a;
            if (aVar != null) {
                return aVar.N(i2);
            }
            return null;
        }
        return (c.p.a.e.b.f.e) invokeI.objValue;
    }

    @Override // c.p.a.e.b.g.n
    public c.p.a.e.b.f.j r(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048634, this, i2)) == null) {
            a aVar = this.f35337a;
            c.p.a.e.b.f.j M = aVar != null ? aVar.M(i2) : null;
            return M == null ? c.p.a.e.b.g.e.j() : M;
        }
        return (c.p.a.e.b.f.j) invokeI.objValue;
    }

    @Override // c.p.a.e.b.g.n
    public w s(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048635, this, i2)) == null) {
            a aVar = this.f35337a;
            if (aVar != null) {
                return aVar.O(i2);
            }
            return null;
        }
        return (w) invokeI.objValue;
    }

    public o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f35337a = c.p.a.e.b.g.e.c();
        this.f35338b = c.p.a.e.b.g.e.M0();
        if (!z) {
            this.f35339c = c.p.a.e.b.g.e.N0();
        } else {
            this.f35339c = c.p.a.e.b.g.e.O0();
        }
        this.f35340d = c.p.a.e.b.j.a.r().q("service_alive", false);
    }

    public void i(int i2, boolean z) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048625, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || (aVar = this.f35337a) == null) {
            return;
        }
        aVar.E(i2, z);
    }

    @Override // c.p.a.e.b.g.n
    public void a(int i2, boolean z) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || (aVar = this.f35337a) == null) {
            return;
        }
        aVar.s(i2, z);
    }

    @Override // c.p.a.e.b.g.n
    public List<DownloadInfo> b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
            c.p.a.e.b.g.k kVar = this.f35338b;
            if (kVar != null) {
                return kVar.b(str);
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    @Override // c.p.a.e.b.g.n
    public List<DownloadInfo> c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, str)) == null) {
            c.p.a.e.b.g.k kVar = this.f35338b;
            if (kVar != null) {
                return kVar.c(str);
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    @Override // c.p.a.e.b.g.n
    public List<DownloadInfo> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            c.p.a.e.b.g.k kVar = this.f35338b;
            if (kVar != null) {
                return kVar.b();
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    @Override // c.p.a.e.b.g.n
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            this.f35338b.c();
        }
    }

    @Override // c.p.a.e.b.g.n
    public boolean h() {
        InterceptResult invokeV;
        c.p.a.e.b.g.p pVar;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? this.f35340d && (pVar = this.f35339c) != null && pVar.a() : invokeV.booleanValue;
    }

    @Override // c.p.a.e.b.g.n
    public void f(int i2, int i3, c.p.a.e.b.f.c cVar, com.ss.android.socialbase.downloader.constants.f fVar, boolean z, boolean z2) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048616, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), cVar, fVar, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || (aVar = this.f35337a) == null) {
            return;
        }
        aVar.g(i2, i3, cVar, fVar, z, z2);
    }

    @Override // c.p.a.e.b.g.n
    public void g(int i2, c.p.a.e.b.f.e eVar) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048619, this, i2, eVar) == null) || (aVar = this.f35337a) == null) {
            return;
        }
        aVar.i(i2, eVar);
    }

    @Override // c.p.a.e.b.g.n
    public void a() {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (aVar = this.f35337a) == null) {
            return;
        }
        aVar.u();
    }

    @Override // c.p.a.e.b.g.n
    public void b(List<String> list) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, list) == null) || (aVar = this.f35337a) == null) {
            return;
        }
        aVar.B(list);
    }

    @Override // c.p.a.e.b.g.n
    public void c(boolean z, boolean z2) {
        c.p.a.e.b.g.p pVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048604, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || (pVar = this.f35339c) == null) {
            return;
        }
        pVar.a(z2);
    }

    @Override // c.p.a.e.b.g.n
    public void d(int i2, int i3, c.p.a.e.b.f.c cVar, com.ss.android.socialbase.downloader.constants.f fVar, boolean z) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048610, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), cVar, fVar, Boolean.valueOf(z)}) == null) || (aVar = this.f35337a) == null) {
            return;
        }
        aVar.w(i2, i3, cVar, fVar, z);
    }

    @Override // c.p.a.e.b.g.n
    public void h(c.p.a.e.b.f.m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, mVar) == null) {
            c.p.a.e.b.g.e.I(mVar);
        }
    }

    @Override // c.p.a.e.b.g.n
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? this.f35338b.d() : invokeV.booleanValue;
    }

    @Override // c.p.a.e.b.g.n
    public void a(List<String> list) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, list) == null) || (aVar = this.f35337a) == null) {
            return;
        }
        aVar.q(list);
    }

    @Override // c.p.a.e.b.g.n
    public DownloadInfo b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048592, this, str, str2)) == null) ? h(c.p.a.e.b.g.e.w(str, str2)) : (DownloadInfo) invokeLL.objValue;
    }

    @Override // c.p.a.e.b.g.n
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? c.p.a.e.b.g.e.o() : invokeV.booleanValue;
    }

    @Override // c.p.a.e.b.g.n
    public List<DownloadInfo> d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, str)) == null) {
            c.p.a.e.b.g.k kVar = this.f35338b;
            if (kVar != null) {
                return kVar.d(str);
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    @Override // c.p.a.e.b.g.n
    public void c(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048603, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            c.p.a.e.b.g.f.c().h(i2, z);
        }
    }

    @Override // c.p.a.e.b.g.n
    public void e(int i2, int i3, c.p.a.e.b.f.c cVar, com.ss.android.socialbase.downloader.constants.f fVar, boolean z) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048614, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), cVar, fVar, Boolean.valueOf(z)}) == null) || (aVar = this.f35337a) == null) {
            return;
        }
        aVar.f(i2, i3, cVar, fVar, z);
    }

    @Override // c.p.a.e.b.g.n
    public List<DownloadInfo> a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            a aVar = this.f35337a;
            if (aVar != null) {
                return aVar.c(str);
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    @Override // c.p.a.e.b.g.n
    public void b(int i2, boolean z) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || (aVar = this.f35337a) == null) {
            return;
        }
        aVar.y(i2, z);
    }

    @Override // c.p.a.e.b.g.n
    public boolean c(DownloadInfo downloadInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, downloadInfo)) == null) ? this.f35338b.a(downloadInfo) : invokeL.booleanValue;
    }

    @Override // c.p.a.e.b.g.n
    public List<DownloadInfo> e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, str)) == null) {
            a aVar = this.f35337a;
            if (aVar != null) {
                return aVar.t(str);
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    @Override // c.p.a.e.b.g.n
    public int a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) ? c.p.a.e.b.g.e.w(str, str2) : invokeLL.intValue;
    }

    @Override // c.p.a.e.b.g.n
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            c.p.a.e.b.g.p pVar = this.f35339c;
            if (pVar != null) {
                return pVar.b();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.p.a.e.b.g.n
    public boolean a(DownloadInfo downloadInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, downloadInfo)) == null) {
            if (downloadInfo == null) {
                return false;
            }
            boolean I = c.p.a.e.b.l.f.I(downloadInfo.getStatus(), downloadInfo.getSavePath(), downloadInfo.getName());
            if (I) {
                if (c.p.a.e.b.l.a.a(33554432)) {
                    b(downloadInfo.getId(), true);
                } else {
                    i(downloadInfo.getId(), true);
                }
            }
            return I;
        }
        return invokeL.booleanValue;
    }

    @Override // c.p.a.e.b.g.n
    public void b(c.p.a.e.b.n.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, aVar) == null) {
            c.p.a.e.b.g.p pVar = this.f35339c;
            if (pVar != null) {
                pVar.a(aVar);
            } else if (aVar != null) {
                c.p.a.e.b.e.a.e(aVar.R(), aVar.J(), new BaseException(1003, "downloadServiceHandler is null"), aVar.J() != null ? aVar.J().getStatus() : 0);
            }
        }
    }

    @Override // c.p.a.e.b.g.n
    public void a(int i2, Notification notification) {
        c.p.a.e.b.g.p pVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048585, this, i2, notification) == null) || (pVar = this.f35339c) == null) {
            return;
        }
        pVar.a(i2, notification);
    }

    @Override // c.p.a.e.b.g.n
    public void b(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, downloadInfo) == null) {
            this.f35338b.b(downloadInfo);
        }
    }

    @Override // c.p.a.e.b.g.n
    public void b(int i2, List<com.ss.android.socialbase.downloader.model.b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048594, this, i2, list) == null) {
            this.f35338b.b(i2, list);
        }
    }

    @Override // c.p.a.e.b.g.n
    public void a(c.p.a.e.b.n.a aVar) {
        c.p.a.e.b.g.p pVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, aVar) == null) || (pVar = this.f35339c) == null) {
            return;
        }
        pVar.b(aVar);
    }

    @Override // c.p.a.e.b.g.n
    public void a(int i2, List<com.ss.android.socialbase.downloader.model.b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048586, this, i2, list) == null) {
            this.f35338b.a(i2, list);
        }
    }

    @Override // c.p.a.e.b.g.n
    public void a(com.ss.android.socialbase.downloader.model.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bVar) == null) {
            this.f35338b.a(bVar);
        }
    }

    @Override // c.p.a.e.b.g.n
    public void a(int i2, int i3, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2)}) == null) {
            this.f35338b.a(i2, i3, j2);
        }
    }

    @Override // c.p.a.e.b.g.n
    public void a(int i2, int i3, int i4, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(j2)}) == null) {
            this.f35338b.a(i2, i3, i4, j2);
        }
    }

    @Override // c.p.a.e.b.g.n
    public void a(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048581, this, i2, i3, i4, i5) == null) {
            this.f35338b.a(i2, i3, i4, i5);
        }
    }

    @Override // c.p.a.e.b.g.n
    public void a(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048580, this, i2, i3) == null) || c.p.a.e.b.g.e.p0() == null) {
            return;
        }
        for (c.p.a.e.b.f.m mVar : c.p.a.e.b.g.e.p0()) {
            if (mVar != null) {
                mVar.a(i3, i2);
            }
        }
    }

    @Override // c.p.a.e.b.g.n
    public void a(int i2, long j2) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) || (aVar = this.f35337a) == null) {
            return;
        }
        aVar.x(i2, j2);
    }
}
