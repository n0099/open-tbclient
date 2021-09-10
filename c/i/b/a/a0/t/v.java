package c.i.b.a.a0.t;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import c.i.b.a.a0.l;
import c.i.b.a.a0.t.w;
import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/* loaded from: classes4.dex */
public final class v implements c.i.b.a.a0.e {
    public static /* synthetic */ Interceptable $ic;
    public static final long l;
    public static final long m;
    public static final long n;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final int f32926a;

    /* renamed from: b  reason: collision with root package name */
    public final List<c.i.b.a.i0.s> f32927b;

    /* renamed from: c  reason: collision with root package name */
    public final c.i.b.a.i0.l f32928c;

    /* renamed from: d  reason: collision with root package name */
    public final SparseIntArray f32929d;

    /* renamed from: e  reason: collision with root package name */
    public final w.c f32930e;

    /* renamed from: f  reason: collision with root package name */
    public final SparseArray<w> f32931f;

    /* renamed from: g  reason: collision with root package name */
    public final SparseBooleanArray f32932g;

    /* renamed from: h  reason: collision with root package name */
    public c.i.b.a.a0.g f32933h;

    /* renamed from: i  reason: collision with root package name */
    public int f32934i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f32935j;
    public w k;

    /* loaded from: classes4.dex */
    public class a implements r {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final c.i.b.a.i0.k f32936a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ v f32937b;

        public a(v vVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f32937b = vVar;
            this.f32936a = new c.i.b.a.i0.k(new byte[4]);
        }

        @Override // c.i.b.a.a0.t.r
        public void a(c.i.b.a.i0.s sVar, c.i.b.a.a0.g gVar, w.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, sVar, gVar, dVar) == null) {
            }
        }

        @Override // c.i.b.a.a0.t.r
        public void c(c.i.b.a.i0.l lVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lVar) == null) && lVar.x() == 0) {
                lVar.K(7);
                int a2 = lVar.a() / 4;
                for (int i2 = 0; i2 < a2; i2++) {
                    lVar.f(this.f32936a, 4);
                    int g2 = this.f32936a.g(16);
                    this.f32936a.n(3);
                    if (g2 == 0) {
                        this.f32936a.n(13);
                    } else {
                        int g3 = this.f32936a.g(13);
                        this.f32937b.f32931f.put(g3, new s(new b(this.f32937b, g3)));
                        v.i(this.f32937b);
                    }
                }
                if (this.f32937b.f32926a != 2) {
                    this.f32937b.f32931f.remove(0);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements r {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final c.i.b.a.i0.k f32938a;

        /* renamed from: b  reason: collision with root package name */
        public final SparseArray<w> f32939b;

        /* renamed from: c  reason: collision with root package name */
        public final SparseIntArray f32940c;

        /* renamed from: d  reason: collision with root package name */
        public final int f32941d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ v f32942e;

        public b(v vVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f32942e = vVar;
            this.f32938a = new c.i.b.a.i0.k(new byte[5]);
            this.f32939b = new SparseArray<>();
            this.f32940c = new SparseIntArray();
            this.f32941d = i2;
        }

        @Override // c.i.b.a.a0.t.r
        public void a(c.i.b.a.i0.s sVar, c.i.b.a.a0.g gVar, w.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, sVar, gVar, dVar) == null) {
            }
        }

        public final w.b b(c.i.b.a.i0.l lVar, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lVar, i2)) == null) {
                int c2 = lVar.c();
                int i3 = i2 + c2;
                String str = null;
                ArrayList arrayList = null;
                int i4 = -1;
                while (lVar.c() < i3) {
                    int x = lVar.x();
                    int c3 = lVar.c() + lVar.x();
                    if (x == 5) {
                        long z = lVar.z();
                        if (z != v.l) {
                            if (z != v.m) {
                                if (z == v.n) {
                                    i4 = 36;
                                }
                            }
                            i4 = 135;
                        }
                        i4 = 129;
                    } else {
                        if (x != 106) {
                            if (x != 122) {
                                if (x == 123) {
                                    i4 = 138;
                                } else if (x == 10) {
                                    str = lVar.u(3).trim();
                                } else if (x == 89) {
                                    arrayList = new ArrayList();
                                    while (lVar.c() < c3) {
                                        String trim = lVar.u(3).trim();
                                        int x2 = lVar.x();
                                        byte[] bArr = new byte[4];
                                        lVar.g(bArr, 0, 4);
                                        arrayList.add(new w.a(trim, x2, bArr));
                                    }
                                    i4 = 89;
                                }
                            }
                            i4 = 135;
                        }
                        i4 = 129;
                    }
                    lVar.K(c3 - lVar.c());
                }
                lVar.J(i3);
                return new w.b(i4, str, arrayList, Arrays.copyOfRange(lVar.f33812a, c2, i3));
            }
            return (w.b) invokeLI.objValue;
        }

        @Override // c.i.b.a.a0.t.r
        public void c(c.i.b.a.i0.l lVar) {
            c.i.b.a.i0.s sVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lVar) == null) && lVar.x() == 2) {
                if (this.f32942e.f32926a == 1 || this.f32942e.f32926a == 2 || this.f32942e.f32934i == 1) {
                    sVar = (c.i.b.a.i0.s) this.f32942e.f32927b.get(0);
                } else {
                    sVar = new c.i.b.a.i0.s(((c.i.b.a.i0.s) this.f32942e.f32927b.get(0)).c());
                    this.f32942e.f32927b.add(sVar);
                }
                lVar.K(2);
                int D = lVar.D();
                int i2 = 5;
                lVar.K(5);
                lVar.f(this.f32938a, 2);
                int i3 = 4;
                this.f32938a.n(4);
                lVar.K(this.f32938a.g(12));
                if (this.f32942e.f32926a == 2 && this.f32942e.k == null) {
                    w.b bVar = new w.b(21, null, null, new byte[0]);
                    v vVar = this.f32942e;
                    vVar.k = vVar.f32930e.a(21, bVar);
                    this.f32942e.k.a(sVar, this.f32942e.f32933h, new w.d(D, 21, 8192));
                }
                this.f32939b.clear();
                this.f32940c.clear();
                int a2 = lVar.a();
                while (a2 > 0) {
                    lVar.f(this.f32938a, i2);
                    int g2 = this.f32938a.g(8);
                    this.f32938a.n(3);
                    int g3 = this.f32938a.g(13);
                    this.f32938a.n(i3);
                    int g4 = this.f32938a.g(12);
                    w.b b2 = b(lVar, g4);
                    if (g2 == 6) {
                        g2 = b2.f32945a;
                    }
                    a2 -= g4 + 5;
                    int i4 = this.f32942e.f32926a == 2 ? g2 : g3;
                    if (!this.f32942e.f32932g.get(i4)) {
                        w a3 = (this.f32942e.f32926a == 2 && g2 == 21) ? this.f32942e.k : this.f32942e.f32930e.a(g2, b2);
                        if (this.f32942e.f32926a != 2 || g3 < this.f32940c.get(i4, 8192)) {
                            this.f32940c.put(i4, g3);
                            this.f32939b.put(i4, a3);
                        }
                    }
                    i2 = 5;
                    i3 = 4;
                }
                int size = this.f32940c.size();
                for (int i5 = 0; i5 < size; i5++) {
                    int keyAt = this.f32940c.keyAt(i5);
                    this.f32942e.f32932g.put(keyAt, true);
                    w valueAt = this.f32939b.valueAt(i5);
                    if (valueAt != null) {
                        if (valueAt != this.f32942e.k) {
                            valueAt.a(sVar, this.f32942e.f32933h, new w.d(D, keyAt, 8192));
                        }
                        this.f32942e.f32931f.put(this.f32940c.valueAt(i5), valueAt);
                    }
                }
                if (this.f32942e.f32926a == 2) {
                    if (this.f32942e.f32935j) {
                        return;
                    }
                    this.f32942e.f32933h.j();
                    this.f32942e.f32934i = 0;
                    this.f32942e.f32935j = true;
                    return;
                }
                this.f32942e.f32931f.remove(this.f32941d);
                v vVar2 = this.f32942e;
                vVar2.f32934i = vVar2.f32926a != 1 ? this.f32942e.f32934i - 1 : 0;
                if (this.f32942e.f32934i == 0) {
                    this.f32942e.f32933h.j();
                    this.f32942e.f32935j = true;
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-445031449, "Lc/i/b/a/a0/t/v;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-445031449, "Lc/i/b/a/a0/t/v;");
                return;
            }
        }
        l = c.i.b.a.i0.v.q("AC-3");
        m = c.i.b.a.i0.v.q("EAC3");
        n = c.i.b.a.i0.v.q("HEVC");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public v(int i2, int i3) {
        this(i2, new c.i.b.a.i0.s(0L), new e(i3));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), (c.i.b.a.i0.s) objArr2[1], (w.c) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static /* synthetic */ int i(v vVar) {
        int i2 = vVar.f32934i;
        vVar.f32934i = i2 + 1;
        return i2;
    }

    @Override // c.i.b.a.a0.e
    public void a(long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            int size = this.f32927b.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f32927b.get(i2).g();
            }
            this.f32928c.F();
            this.f32929d.clear();
            u();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0025, code lost:
        r2 = r2 + 1;
     */
    @Override // c.i.b.a.a0.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean d(c.i.b.a.a0.f fVar) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar)) == null) {
            byte[] bArr = this.f32928c.f33812a;
            fVar.c(bArr, 0, CyberPlayerManager.MEDIA_INFO_VIDEO_FRAMERATE);
            int i2 = 0;
            while (i2 < 188) {
                for (int i3 = 0; i3 != 5; i3++) {
                    if (bArr[(i3 * Opcodes.NEWARRAY) + i2] != 71) {
                        break;
                    }
                }
                fVar.h(i2);
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // c.i.b.a.a0.e
    public int e(c.i.b.a.a0.f fVar, c.i.b.a.a0.k kVar) throws IOException, InterruptedException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, fVar, kVar)) == null) {
            c.i.b.a.i0.l lVar = this.f32928c;
            byte[] bArr = lVar.f33812a;
            if (9400 - lVar.c() < 188) {
                int a2 = this.f32928c.a();
                if (a2 > 0) {
                    System.arraycopy(bArr, this.f32928c.c(), bArr, 0, a2);
                }
                this.f32928c.H(bArr, a2);
            }
            while (this.f32928c.a() < 188) {
                int d2 = this.f32928c.d();
                int read = fVar.read(bArr, d2, 9400 - d2);
                if (read == -1) {
                    return -1;
                }
                this.f32928c.I(d2 + read);
            }
            int d3 = this.f32928c.d();
            int c2 = this.f32928c.c();
            while (c2 < d3 && bArr[c2] != 71) {
                c2++;
            }
            this.f32928c.J(c2);
            int i2 = c2 + Opcodes.NEWARRAY;
            if (i2 > d3) {
                return 0;
            }
            int i3 = this.f32928c.i();
            if ((8388608 & i3) != 0) {
                this.f32928c.J(i2);
                return 0;
            }
            boolean z = (4194304 & i3) != 0;
            int i4 = (2096896 & i3) >> 8;
            boolean z2 = (i3 & 32) != 0;
            w wVar = (i3 & 16) != 0 ? this.f32931f.get(i4) : null;
            if (wVar == null) {
                this.f32928c.J(i2);
                return 0;
            }
            if (this.f32926a != 2) {
                int i5 = i3 & 15;
                int i6 = this.f32929d.get(i4, i5 - 1);
                this.f32929d.put(i4, i5);
                if (i6 == i5) {
                    this.f32928c.J(i2);
                    return 0;
                } else if (i5 != ((i6 + 1) & 15)) {
                    wVar.b();
                }
            }
            if (z2) {
                this.f32928c.K(this.f32928c.x());
            }
            this.f32928c.I(i2);
            wVar.c(this.f32928c, z);
            this.f32928c.I(d3);
            this.f32928c.J(i2);
            return 0;
        }
        return invokeLL.intValue;
    }

    @Override // c.i.b.a.a0.e
    public void f(c.i.b.a.a0.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, gVar) == null) {
            this.f32933h = gVar;
            gVar.p(new l.a(-9223372036854775807L));
        }
    }

    @Override // c.i.b.a.a0.e
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f32932g.clear();
            this.f32931f.clear();
            SparseArray<w> b2 = this.f32930e.b();
            int size = b2.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f32931f.put(b2.keyAt(i2), b2.valueAt(i2));
            }
            this.f32931f.put(0, new s(new a(this)));
            this.k = null;
        }
    }

    public v(int i2, c.i.b.a.i0.s sVar, w.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), sVar, cVar};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        c.i.b.a.i0.a.e(cVar);
        this.f32930e = cVar;
        this.f32926a = i2;
        if (i2 != 1 && i2 != 2) {
            ArrayList arrayList = new ArrayList();
            this.f32927b = arrayList;
            arrayList.add(sVar);
        } else {
            this.f32927b = Collections.singletonList(sVar);
        }
        this.f32928c = new c.i.b.a.i0.l(9400);
        this.f32932g = new SparseBooleanArray();
        this.f32931f = new SparseArray<>();
        this.f32929d = new SparseIntArray();
        u();
    }
}
