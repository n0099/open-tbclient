package c.p.a.e.b.n;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.p.a.e.b.f.e;
import c.p.a.e.b.f.r;
import c.p.a.e.b.f.s;
import c.p.a.e.b.f.u;
import c.p.a.e.b.f.w;
import c.p.a.e.b.f.y;
import c.p.a.e.b.f.z;
import c.p.a.e.b.g.i;
import c.p.a.e.b.g.j;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.downloader.constants.EnqueueType;
import com.ss.android.socialbase.downloader.constants.f;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public DownloadInfo f35392a;

    /* renamed from: b  reason: collision with root package name */
    public i f35393b;

    /* renamed from: c  reason: collision with root package name */
    public j f35394c;

    /* renamed from: d  reason: collision with root package name */
    public final Map<f, c.p.a.e.b.f.c> f35395d;

    /* renamed from: e  reason: collision with root package name */
    public final SparseArray<f> f35396e;

    /* renamed from: f  reason: collision with root package name */
    public final SparseArray<c.p.a.e.b.f.c> f35397f;

    /* renamed from: g  reason: collision with root package name */
    public final SparseArray<c.p.a.e.b.f.c> f35398g;

    /* renamed from: h  reason: collision with root package name */
    public final SparseArray<c.p.a.e.b.f.c> f35399h;

    /* renamed from: i  reason: collision with root package name */
    public e f35400i;

    /* renamed from: j  reason: collision with root package name */
    public c.p.a.e.b.f.b f35401j;
    public s k;
    public z l;
    public DownloadInfo.b m;
    public y n;
    public u o;
    public c.p.a.e.b.g.s p;
    public c.p.a.e.b.f.j q;
    public boolean r;
    public w s;
    public final List<r> t;
    public int u;
    public boolean v;

    /* renamed from: c.p.a.e.b.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1554a implements j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C1554a(a aVar) {
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
                }
            }
        }

        @Override // c.p.a.e.b.g.j
        public int a(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j2)) == null) {
                return 1;
            }
            return invokeJ.intValue;
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f35395d = new ConcurrentHashMap();
        this.f35396e = new SparseArray<>();
        this.r = false;
        this.t = new ArrayList();
        this.v = true;
        this.m = new DownloadInfo.b();
        this.f35397f = new SparseArray<>();
        this.f35398g = new SparseArray<>();
        this.f35399h = new SparseArray<>();
    }

    public a A(y yVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, yVar)) == null) {
            this.n = yVar;
            return this;
        }
        return (a) invokeL.objValue;
    }

    public a A0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            this.m.G(i2);
            return this;
        }
        return (a) invokeI.objValue;
    }

    public a B(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
            this.m.K(z);
            return this;
        }
        return (a) invokeZ.objValue;
    }

    public a B0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            this.m.l0(str);
            return this;
        }
        return (a) invokeL.objValue;
    }

    public i C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f35393b : (i) invokeV.objValue;
    }

    public a C0(c.p.a.e.b.g.s sVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, sVar)) == null) {
            this.p = sVar;
            return this;
        }
        return (a) invokeL.objValue;
    }

    public j D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f35394c : (j) invokeV.objValue;
    }

    public a D0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            this.m.R(str);
            return this;
        }
        return (a) invokeL.objValue;
    }

    public s E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.k : (s) invokeV.objValue;
    }

    public a E0(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048585, this, z)) == null) {
            this.m.G0(z);
            return this;
        }
        return (a) invokeZ.objValue;
    }

    public u F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.o : (u) invokeV.objValue;
    }

    public final void F0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.f35392a.getThrottleNetSpeed() <= 0) {
            return;
        }
        l(new C1554a(this));
    }

    public r G(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) {
            synchronized (this.t) {
                if (i2 < this.t.size()) {
                    return this.t.get(i2);
                }
                return null;
            }
        }
        return (r) invokeI.objValue;
    }

    public a G0(List<r> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, list)) == null) {
            if (list != null && !list.isEmpty()) {
                for (r rVar : list) {
                    b(rVar);
                }
            }
            return this;
        }
        return (a) invokeL.objValue;
    }

    @NonNull
    public List<r> H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.t : (List) invokeV.objValue;
    }

    public void H0(SparseArray<c.p.a.e.b.f.c> sparseArray, f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048591, this, sparseArray, fVar) == null) || sparseArray == null) {
            return;
        }
        try {
            if (fVar == f.f76194a) {
                synchronized (this.f35397f) {
                    n(this.f35397f, sparseArray);
                }
            } else if (fVar == f.f76195b) {
                synchronized (this.f35398g) {
                    n(this.f35398g, sparseArray);
                }
            } else if (fVar == f.f76196c) {
                synchronized (this.f35399h) {
                    n(this.f35399h, sparseArray);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public int I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            DownloadInfo downloadInfo = this.f35392a;
            if (downloadInfo == null) {
                return 0;
            }
            return downloadInfo.getId();
        }
        return invokeV.intValue;
    }

    public void I0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.r = z;
        }
    }

    public DownloadInfo J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f35392a : (DownloadInfo) invokeV.objValue;
    }

    public void J0(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, eVar) == null) {
            this.f35400i = eVar;
        }
    }

    public c.p.a.e.b.f.c K(f fVar, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048596, this, fVar, i2)) == null) {
            SparseArray<c.p.a.e.b.f.c> M = M(fVar);
            if (M == null || i2 < 0) {
                return null;
            }
            synchronized (M) {
                if (i2 < M.size()) {
                    return M.get(M.keyAt(i2));
                }
                return null;
            }
        }
        return (c.p.a.e.b.f.c) invokeLI.objValue;
    }

    public a K0(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048597, this, z)) == null) {
            this.m.V(z);
            return this;
        }
        return (a) invokeZ.objValue;
    }

    public int L(f fVar) {
        InterceptResult invokeL;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, fVar)) == null) {
            SparseArray<c.p.a.e.b.f.c> M = M(fVar);
            if (M == null) {
                return 0;
            }
            synchronized (M) {
                size = M.size();
            }
            return size;
        }
        return invokeL.intValue;
    }

    public a L0(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048599, this, z)) == null) {
            this.m.c0(z);
            return this;
        }
        return (a) invokeZ.objValue;
    }

    public SparseArray<c.p.a.e.b.f.c> M(f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, fVar)) == null) {
            if (fVar == f.f76194a) {
                return this.f35397f;
            }
            if (fVar == f.f76195b) {
                return this.f35398g;
            }
            if (fVar == f.f76196c) {
                return this.f35399h;
            }
            return null;
        }
        return (SparseArray) invokeL.objValue;
    }

    public a M0(int i2, c.p.a.e.b.f.c cVar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048601, this, i2, cVar)) == null) {
            if (cVar != null) {
                synchronized (this.f35398g) {
                    this.f35398g.put(i2, cVar);
                }
                this.f35395d.put(f.f76195b, cVar);
                synchronized (this.f35396e) {
                    this.f35396e.put(i2, f.f76195b);
                }
            }
            return this;
        }
        return (a) invokeIL.objValue;
    }

    public w N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.s : (w) invokeV.objValue;
    }

    public a N0(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048603, this, j2)) == null) {
            this.m.H(j2);
            return this;
        }
        return (a) invokeJ.objValue;
    }

    public y O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.n : (y) invokeV.objValue;
    }

    public a O0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, str)) == null) {
            this.m.I(str);
            return this;
        }
        return (a) invokeL.objValue;
    }

    public int P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.u : invokeV.intValue;
    }

    public a P0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, str)) == null) {
            this.m.O(str);
            return this;
        }
        return (a) invokeL.objValue;
    }

    public c.p.a.e.b.f.b Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.f35401j : (c.p.a.e.b.f.b) invokeV.objValue;
    }

    public z R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.l : (z) invokeV.objValue;
    }

    public c.p.a.e.b.f.j S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.q : (c.p.a.e.b.f.j) invokeV.objValue;
    }

    public e T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.f35400i : (e) invokeV.objValue;
    }

    public c.p.a.e.b.g.s U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.p : (c.p.a.e.b.g.s) invokeV.objValue;
    }

    public c.p.a.e.b.f.c V(f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, fVar)) == null) ? this.f35395d.get(fVar) : (c.p.a.e.b.f.c) invokeL.objValue;
    }

    public a W(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048614, this, z)) == null) {
            this.m.t0(z);
            return this;
        }
        return (a) invokeZ.objValue;
    }

    public a X(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048615, this, str)) == null) {
            this.m.r0(str);
            return this;
        }
        return (a) invokeL.objValue;
    }

    public a Y(c.p.a.e.b.f.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048616, this, bVar)) == null) {
            this.f35401j = bVar;
            return this;
        }
        return (a) invokeL.objValue;
    }

    public boolean Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? this.v : invokeV.booleanValue;
    }

    public final void a(SparseArray sparseArray, SparseArray sparseArray2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048618, this, sparseArray, sparseArray2) == null) || sparseArray == null || sparseArray2 == null) {
            return;
        }
        int size = sparseArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            int keyAt = sparseArray.keyAt(i2);
            sparseArray2.put(keyAt, sparseArray.get(keyAt));
        }
    }

    public boolean a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.r : invokeV.booleanValue;
    }

    public a b(r rVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048620, this, rVar)) == null) {
            synchronized (this.t) {
                if (rVar != null) {
                    if (!this.t.contains(rVar)) {
                        this.t.add(rVar);
                        return this;
                    }
                }
                return this;
            }
        }
        return (a) invokeL.objValue;
    }

    public a b0(c.p.a.e.b.f.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048621, this, cVar)) == null) {
            if (cVar == null) {
                return this;
            }
            c0(cVar.hashCode(), cVar);
            return this;
        }
        return (a) invokeL.objValue;
    }

    public void c(int i2, c.p.a.e.b.f.c cVar, f fVar, boolean z) {
        Map<f, c.p.a.e.b.f.c> map;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048622, this, new Object[]{Integer.valueOf(i2), cVar, fVar, Boolean.valueOf(z)}) == null) || cVar == null) {
            return;
        }
        if (z && (map = this.f35395d) != null) {
            map.put(fVar, cVar);
            synchronized (this.f35396e) {
                this.f35396e.put(i2, fVar);
            }
        }
        SparseArray<c.p.a.e.b.f.c> M = M(fVar);
        if (M == null) {
            return;
        }
        synchronized (M) {
            M.put(i2, cVar);
        }
    }

    public a c0(int i2, c.p.a.e.b.f.c cVar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048623, this, i2, cVar)) == null) {
            if (cVar != null) {
                synchronized (this.f35397f) {
                    this.f35397f.put(i2, cVar);
                }
                this.f35395d.put(f.f76194a, cVar);
                synchronized (this.f35396e) {
                    this.f35396e.put(i2, f.f76194a);
                }
            }
            return this;
        }
        return (a) invokeIL.objValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            c.p.a.e.b.c.a.g("DownloadTask", "same task just tryDownloading, so add listener in last task instead of tryDownload");
            DownloadInfo downloadInfo = this.f35392a;
            if (downloadInfo != null && !downloadInfo.isAddListenerToSameTask()) {
                this.f35392a.setAddListenerToSameTask(true);
            }
            e(f.f76194a);
            e(f.f76195b);
            c.p.a.e.b.e.a.e(this.l, this.f35392a, new BaseException(1003, "has another same task, add Listener to old task"), 0);
        }
    }

    public a d0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048625, this, i2)) == null) {
            this.m.Q(i2);
            return this;
        }
        return (a) invokeI.objValue;
    }

    public final void e(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, fVar) == null) {
            SparseArray<c.p.a.e.b.f.c> M = M(fVar);
            synchronized (M) {
                for (int i2 = 0; i2 < M.size(); i2++) {
                    c.p.a.e.b.f.c cVar = M.get(M.keyAt(i2));
                    if (cVar != null) {
                        c.p.a.e.b.g.f.c().q(I(), cVar, fVar, false);
                    }
                }
            }
        }
    }

    public a e0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048627, this, str)) == null) {
            this.m.h0(str);
            return this;
        }
        return (a) invokeL.objValue;
    }

    public synchronized int f() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            synchronized (this) {
                c.p.a.e.b.f.c V = V(f.f76194a);
                if (V == null) {
                    V = V(f.f76195b);
                }
                if (V != null) {
                    this.u = V.hashCode();
                }
                i2 = this.u;
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public a f0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048629, this, str)) == null) {
            this.m.b0(str);
            return this;
        }
        return (a) invokeL.objValue;
    }

    public a g(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048630, this, z)) == null) {
            this.m.Z(z);
            return this;
        }
        return (a) invokeZ.objValue;
    }

    public a g0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048631, this, i2)) == null) {
            this.m.U(i2);
            return this;
        }
        return (a) invokeI.objValue;
    }

    public a h(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048632, this, i2)) == null) {
            this.m.N(i2);
            return this;
        }
        return (a) invokeI.objValue;
    }

    public a h0(z zVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048633, this, zVar)) == null) {
            this.l = zVar;
            return this;
        }
        return (a) invokeL.objValue;
    }

    public a i(List<String> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048634, this, list)) == null) {
            this.m.J(list);
            return this;
        }
        return (a) invokeL.objValue;
    }

    public a i0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048635, this, str)) == null) {
            this.m.o0(str);
            return this;
        }
        return (a) invokeL.objValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            DownloadInfo downloadInfo = this.f35392a;
            if (downloadInfo != null) {
                return downloadInfo.canShowNotification();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public a j0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048637, this, str)) == null) {
            this.m.A(str);
            return this;
        }
        return (a) invokeL.objValue;
    }

    public a k(i iVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048638, this, iVar)) == null) {
            this.f35393b = iVar;
            return this;
        }
        return (a) invokeL.objValue;
    }

    public a k0(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048639, this, z)) == null) {
            this.m.w0(z);
            return this;
        }
        return (a) invokeZ.objValue;
    }

    public a l(j jVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048640, this, jVar)) == null) {
            this.f35394c = jVar;
            return this;
        }
        return (a) invokeL.objValue;
    }

    public a l0(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048641, this, z)) == null) {
            this.m.f0(z);
            return this;
        }
        return (a) invokeZ.objValue;
    }

    public void m(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, aVar) == null) {
            for (Map.Entry<f, c.p.a.e.b.f.c> entry : aVar.f35395d.entrySet()) {
                if (entry != null && !this.f35395d.containsKey(entry.getKey())) {
                    this.f35395d.put(entry.getKey(), entry.getValue());
                }
            }
            try {
                if (aVar.f35397f.size() != 0) {
                    synchronized (this.f35397f) {
                        y0(this.f35397f, aVar.f35397f);
                        a(aVar.f35397f, this.f35397f);
                    }
                }
                if (aVar.f35398g.size() != 0) {
                    synchronized (this.f35398g) {
                        y0(this.f35398g, aVar.f35398g);
                        a(aVar.f35398g, this.f35398g);
                    }
                }
                if (aVar.f35399h.size() != 0) {
                    synchronized (this.f35399h) {
                        y0(this.f35399h, aVar.f35399h);
                        a(aVar.f35399h, this.f35399h);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public a m0(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048643, this, z)) == null) {
            this.m.S(z);
            return this;
        }
        return (a) invokeZ.objValue;
    }

    public final void n(SparseArray<c.p.a.e.b.f.c> sparseArray, SparseArray<c.p.a.e.b.f.c> sparseArray2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048644, this, sparseArray, sparseArray2) == null) {
            sparseArray.clear();
            for (int i2 = 0; i2 < sparseArray2.size(); i2++) {
                int keyAt = sparseArray2.keyAt(i2);
                c.p.a.e.b.f.c cVar = sparseArray2.get(keyAt);
                if (cVar != null) {
                    sparseArray.put(keyAt, cVar);
                }
            }
        }
    }

    public a n0(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048645, this, z)) == null) {
            this.m.s0(z);
            return this;
        }
        return (a) invokeZ.objValue;
    }

    public a o(s sVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048646, this, sVar)) == null) {
            this.k = sVar;
            return this;
        }
        return (a) invokeL.objValue;
    }

    public a o0(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048647, this, z)) == null) {
            this.m.m0(z);
            return this;
        }
        return (a) invokeZ.objValue;
    }

    public a p(u uVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048648, this, uVar)) == null) {
            this.o = uVar;
            return this;
        }
        return (a) invokeL.objValue;
    }

    public a p0(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048649, this, z)) == null) {
            this.m.i0(z);
            return this;
        }
        return (a) invokeZ.objValue;
    }

    public a q(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048650, this, z)) == null) {
            this.m.E0(z);
            return this;
        }
        return (a) invokeZ.objValue;
    }

    public a q0(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048651, this, z)) == null) {
            this.m.p0(z);
            return this;
        }
        return (a) invokeZ.objValue;
    }

    public int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) {
            this.f35392a = this.m.E();
            DownloadInfo b2 = c.p.a.e.b.g.e.M0().b(this.f35392a.getId());
            if (b2 == null) {
                this.f35392a.generateTaskId();
                c.p.a.e.b.e.a.i(this, null, 0);
            } else {
                this.f35392a.copyTaskIdFromCacheData(b2);
            }
            F0();
            c.p.a.e.b.g.f.c().j(this);
            DownloadInfo downloadInfo = this.f35392a;
            if (downloadInfo == null) {
                return 0;
            }
            return downloadInfo.getId();
        }
        return invokeV.intValue;
    }

    public a r0(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048653, this, z)) == null) {
            this.m.A0(z);
            return this;
        }
        return (a) invokeZ.objValue;
    }

    public a s(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048654, this, jSONObject)) == null) {
            this.m.C(jSONObject);
            return this;
        }
        return (a) invokeL.objValue;
    }

    public a s0(c.p.a.e.b.f.j jVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048655, this, jVar)) == null) {
            this.q = jVar;
            return this;
        }
        return (a) invokeL.objValue;
    }

    public a t(EnqueueType enqueueType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048656, this, enqueueType)) == null) {
            this.m.z(enqueueType);
            return this;
        }
        return (a) invokeL.objValue;
    }

    public a t0(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048657, this, eVar)) == null) {
            this.f35400i = eVar;
            return this;
        }
        return (a) invokeL.objValue;
    }

    public a u(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048658, this, i2)) == null) {
            this.m.X(i2);
            return this;
        }
        return (a) invokeI.objValue;
    }

    public a u0(c.p.a.e.b.f.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048659, this, cVar)) == null) {
            if (cVar == null) {
                return this;
            }
            v0(cVar.hashCode(), cVar);
            return this;
        }
        return (a) invokeL.objValue;
    }

    public a v(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048660, this, j2)) == null) {
            this.m.y(j2);
            return this;
        }
        return (a) invokeJ.objValue;
    }

    public a v0(int i2, c.p.a.e.b.f.c cVar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048661, this, i2, cVar)) == null) {
            if (cVar != null) {
                synchronized (this.f35399h) {
                    this.f35399h.put(i2, cVar);
                }
                this.f35395d.put(f.f76196c, cVar);
                synchronized (this.f35396e) {
                    this.f35396e.put(i2, f.f76196c);
                }
            }
            return this;
        }
        return (a) invokeIL.objValue;
    }

    public a w(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048662, this, str)) == null) {
            this.m.Y(str);
            return this;
        }
        return (a) invokeL.objValue;
    }

    public a w0(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048663, this, z)) == null) {
            this.m.D(z);
            return this;
        }
        return (a) invokeZ.objValue;
    }

    public a x(List<com.ss.android.socialbase.downloader.model.c> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048664, this, list)) == null) {
            this.m.B(list);
            return this;
        }
        return (a) invokeL.objValue;
    }

    public a x0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048665, this, str)) == null) {
            this.m.e0(str);
            return this;
        }
        return (a) invokeL.objValue;
    }

    public a y(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048666, this, iArr)) == null) {
            this.m.L(iArr);
            return this;
        }
        return (a) invokeL.objValue;
    }

    public final void y0(SparseArray sparseArray, SparseArray sparseArray2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048667, this, sparseArray, sparseArray2) == null) || sparseArray == null || sparseArray2 == null) {
            return;
        }
        int size = sparseArray2.size();
        for (int i2 = 0; i2 < size; i2++) {
            sparseArray.remove(sparseArray2.keyAt(i2));
        }
    }

    public a z(w wVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048668, this, wVar)) == null) {
            this.s = wVar;
            return this;
        }
        return (a) invokeL.objValue;
    }

    public void z0(int i2, c.p.a.e.b.f.c cVar, f fVar, boolean z) {
        int indexOfValue;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048669, this, new Object[]{Integer.valueOf(i2), cVar, fVar, Boolean.valueOf(z)}) == null) {
            SparseArray<c.p.a.e.b.f.c> M = M(fVar);
            if (M == null) {
                if (z && this.f35395d.containsKey(fVar)) {
                    this.f35395d.remove(fVar);
                    return;
                }
                return;
            }
            synchronized (M) {
                if (z) {
                    if (this.f35395d.containsKey(fVar)) {
                        cVar = this.f35395d.get(fVar);
                        this.f35395d.remove(fVar);
                    }
                    if (cVar != null && (indexOfValue = M.indexOfValue(cVar)) >= 0 && indexOfValue < M.size()) {
                        M.removeAt(indexOfValue);
                    }
                } else {
                    M.remove(i2);
                    synchronized (this.f35396e) {
                        f fVar2 = this.f35396e.get(i2);
                        if (fVar2 != null && this.f35395d.containsKey(fVar2)) {
                            this.f35395d.remove(fVar2);
                            this.f35396e.remove(i2);
                        }
                    }
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(DownloadInfo downloadInfo) {
        this();
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {downloadInfo};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f35392a = downloadInfo;
    }
}
