package b.i.b.a.a0.t;

import android.util.SparseArray;
import b.i.b.a.a0.t.w;
import b.i.b.a.i0.j;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import java.util.ArrayList;
import java.util.Arrays;
/* loaded from: classes6.dex */
public final class j implements h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final t f31698a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f31699b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f31700c;

    /* renamed from: d  reason: collision with root package name */
    public final o f31701d;

    /* renamed from: e  reason: collision with root package name */
    public final o f31702e;

    /* renamed from: f  reason: collision with root package name */
    public final o f31703f;

    /* renamed from: g  reason: collision with root package name */
    public long f31704g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean[] f31705h;

    /* renamed from: i  reason: collision with root package name */
    public String f31706i;
    public b.i.b.a.a0.m j;
    public b k;
    public boolean l;
    public long m;
    public final b.i.b.a.i0.l n;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final b.i.b.a.a0.m f31707a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f31708b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f31709c;

        /* renamed from: d  reason: collision with root package name */
        public final SparseArray<j.b> f31710d;

        /* renamed from: e  reason: collision with root package name */
        public final SparseArray<j.a> f31711e;

        /* renamed from: f  reason: collision with root package name */
        public final b.i.b.a.i0.m f31712f;

        /* renamed from: g  reason: collision with root package name */
        public byte[] f31713g;

        /* renamed from: h  reason: collision with root package name */
        public int f31714h;

        /* renamed from: i  reason: collision with root package name */
        public int f31715i;
        public long j;
        public boolean k;
        public long l;
        public a m;
        public a n;
        public boolean o;
        public long p;
        public long q;
        public boolean r;

        /* loaded from: classes6.dex */
        public static final class a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public boolean f31716a;

            /* renamed from: b  reason: collision with root package name */
            public boolean f31717b;

            /* renamed from: c  reason: collision with root package name */
            public j.b f31718c;

            /* renamed from: d  reason: collision with root package name */
            public int f31719d;

            /* renamed from: e  reason: collision with root package name */
            public int f31720e;

            /* renamed from: f  reason: collision with root package name */
            public int f31721f;

            /* renamed from: g  reason: collision with root package name */
            public int f31722g;

            /* renamed from: h  reason: collision with root package name */
            public boolean f31723h;

            /* renamed from: i  reason: collision with root package name */
            public boolean f31724i;
            public boolean j;
            public boolean k;
            public int l;
            public int m;
            public int n;
            public int o;
            public int p;

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
                    }
                }
            }

            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f31717b = false;
                    this.f31716a = false;
                }
            }

            public final boolean c(a aVar) {
                InterceptResult invokeL;
                boolean z;
                boolean z2;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) {
                    if (this.f31716a) {
                        if (!aVar.f31716a || this.f31721f != aVar.f31721f || this.f31722g != aVar.f31722g || this.f31723h != aVar.f31723h) {
                            return true;
                        }
                        if (this.f31724i && aVar.f31724i && this.j != aVar.j) {
                            return true;
                        }
                        int i2 = this.f31719d;
                        int i3 = aVar.f31719d;
                        if (i2 != i3 && (i2 == 0 || i3 == 0)) {
                            return true;
                        }
                        if (this.f31718c.f32629h == 0 && aVar.f31718c.f32629h == 0 && (this.m != aVar.m || this.n != aVar.n)) {
                            return true;
                        }
                        if ((this.f31718c.f32629h == 1 && aVar.f31718c.f32629h == 1 && (this.o != aVar.o || this.p != aVar.p)) || (z = this.k) != (z2 = aVar.k)) {
                            return true;
                        }
                        if (z && z2 && this.l != aVar.l) {
                            return true;
                        }
                    }
                    return false;
                }
                return invokeL.booleanValue;
            }

            public boolean d() {
                InterceptResult invokeV;
                int i2;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f31717b && ((i2 = this.f31720e) == 7 || i2 == 2) : invokeV.booleanValue;
            }

            public void e(j.b bVar, int i2, int i3, int i4, int i5, boolean z, boolean z2, boolean z3, boolean z4, int i6, int i7, int i8, int i9, int i10) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{bVar, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10)}) == null) {
                    this.f31718c = bVar;
                    this.f31719d = i2;
                    this.f31720e = i3;
                    this.f31721f = i4;
                    this.f31722g = i5;
                    this.f31723h = z;
                    this.f31724i = z2;
                    this.j = z3;
                    this.k = z4;
                    this.l = i6;
                    this.m = i7;
                    this.n = i8;
                    this.o = i9;
                    this.p = i10;
                    this.f31716a = true;
                    this.f31717b = true;
                }
            }

            public void f(int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
                    this.f31720e = i2;
                    this.f31717b = true;
                }
            }

            public /* synthetic */ a(a aVar) {
                this();
            }
        }

        public b(b.i.b.a.a0.m mVar, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mVar, Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31707a = mVar;
            this.f31708b = z;
            this.f31709c = z2;
            this.f31710d = new SparseArray<>();
            this.f31711e = new SparseArray<>();
            this.m = new a(null);
            this.n = new a(null);
            byte[] bArr = new byte[128];
            this.f31713g = bArr;
            this.f31712f = new b.i.b.a.i0.m(bArr, 0, 0);
            g();
        }

        /* JADX WARN: Removed duplicated region for block: B:55:0x0103  */
        /* JADX WARN: Removed duplicated region for block: B:56:0x0106  */
        /* JADX WARN: Removed duplicated region for block: B:58:0x010a  */
        /* JADX WARN: Removed duplicated region for block: B:62:0x011c  */
        /* JADX WARN: Removed duplicated region for block: B:65:0x0122  */
        /* JADX WARN: Removed duplicated region for block: B:76:0x0152  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(byte[] bArr, int i2, int i3) {
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            int i4;
            int i5;
            int i6;
            int i7;
            int i8;
            int g2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLII(1048576, this, bArr, i2, i3) == null) && this.k) {
                int i9 = i3 - i2;
                byte[] bArr2 = this.f31713g;
                int length = bArr2.length;
                int i10 = this.f31714h;
                if (length < i10 + i9) {
                    this.f31713g = Arrays.copyOf(bArr2, (i10 + i9) * 2);
                }
                System.arraycopy(bArr, i2, this.f31713g, this.f31714h, i9);
                int i11 = this.f31714h + i9;
                this.f31714h = i11;
                this.f31712f.i(this.f31713g, 0, i11);
                if (this.f31712f.b(8)) {
                    this.f31712f.k();
                    int e2 = this.f31712f.e(2);
                    this.f31712f.l(5);
                    if (this.f31712f.c()) {
                        this.f31712f.h();
                        if (this.f31712f.c()) {
                            int h2 = this.f31712f.h();
                            if (!this.f31709c) {
                                this.k = false;
                                this.n.f(h2);
                            } else if (this.f31712f.c()) {
                                int h3 = this.f31712f.h();
                                if (this.f31711e.indexOfKey(h3) < 0) {
                                    this.k = false;
                                    return;
                                }
                                j.a aVar = this.f31711e.get(h3);
                                j.b bVar = this.f31710d.get(aVar.f32620b);
                                if (bVar.f32626e) {
                                    if (!this.f31712f.b(2)) {
                                        return;
                                    }
                                    this.f31712f.l(2);
                                }
                                if (this.f31712f.b(bVar.f32628g)) {
                                    int e3 = this.f31712f.e(bVar.f32628g);
                                    if (bVar.f32627f) {
                                        z = false;
                                    } else if (!this.f31712f.b(1)) {
                                        return;
                                    } else {
                                        boolean d2 = this.f31712f.d();
                                        if (d2) {
                                            if (this.f31712f.b(1)) {
                                                z = d2;
                                                z3 = this.f31712f.d();
                                                z2 = true;
                                                z4 = this.f31715i != 5;
                                                if (z4) {
                                                    i4 = 0;
                                                } else if (!this.f31712f.c()) {
                                                    return;
                                                } else {
                                                    i4 = this.f31712f.h();
                                                }
                                                i5 = bVar.f32629h;
                                                if (i5 != 0) {
                                                    if (!this.f31712f.b(bVar.f32630i)) {
                                                        return;
                                                    }
                                                    int e4 = this.f31712f.e(bVar.f32630i);
                                                    if (aVar.f32621c && !z) {
                                                        if (this.f31712f.c()) {
                                                            i8 = this.f31712f.g();
                                                            i6 = e4;
                                                            i7 = 0;
                                                            g2 = 0;
                                                            this.n.e(bVar, e2, h2, e3, h3, z, z2, z3, z4, i4, i6, i8, i7, g2);
                                                            this.k = false;
                                                        }
                                                        return;
                                                    }
                                                    i6 = e4;
                                                } else if (i5 == 1 && !bVar.j) {
                                                    if (this.f31712f.c()) {
                                                        int g3 = this.f31712f.g();
                                                        if (aVar.f32621c && !z) {
                                                            if (this.f31712f.c()) {
                                                                g2 = this.f31712f.g();
                                                                i7 = g3;
                                                                i6 = 0;
                                                                i8 = 0;
                                                                this.n.e(bVar, e2, h2, e3, h3, z, z2, z3, z4, i4, i6, i8, i7, g2);
                                                                this.k = false;
                                                            }
                                                            return;
                                                        }
                                                        i7 = g3;
                                                        i6 = 0;
                                                        i8 = 0;
                                                        g2 = 0;
                                                        this.n.e(bVar, e2, h2, e3, h3, z, z2, z3, z4, i4, i6, i8, i7, g2);
                                                        this.k = false;
                                                    }
                                                    return;
                                                } else {
                                                    i6 = 0;
                                                }
                                                i8 = 0;
                                                i7 = 0;
                                                g2 = 0;
                                                this.n.e(bVar, e2, h2, e3, h3, z, z2, z3, z4, i4, i6, i8, i7, g2);
                                                this.k = false;
                                            }
                                            return;
                                        }
                                        z = d2;
                                    }
                                    z2 = false;
                                    z3 = false;
                                    if (this.f31715i != 5) {
                                    }
                                    if (z4) {
                                    }
                                    i5 = bVar.f32629h;
                                    if (i5 != 0) {
                                    }
                                    i8 = 0;
                                    i7 = 0;
                                    g2 = 0;
                                    this.n.e(bVar, e2, h2, e3, h3, z, z2, z3, z4, i4, i6, i8, i7, g2);
                                    this.k = false;
                                }
                            }
                        }
                    }
                }
            }
        }

        public void b(long j, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), Integer.valueOf(i2)}) == null) {
                boolean z = false;
                if (this.f31715i == 9 || (this.f31709c && this.n.c(this.m))) {
                    if (this.o) {
                        d(i2 + ((int) (j - this.j)));
                    }
                    this.p = this.j;
                    this.q = this.l;
                    this.r = false;
                    this.o = true;
                }
                boolean z2 = this.r;
                int i3 = this.f31715i;
                if (i3 == 5 || (this.f31708b && i3 == 1 && this.n.d())) {
                    z = true;
                }
                this.r = z2 | z;
            }
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f31709c : invokeV.booleanValue;
        }

        public final void d(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
                boolean z = this.r;
                this.f31707a.c(this.q, z ? 1 : 0, (int) (this.j - this.p), i2, null);
            }
        }

        public void e(j.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
                this.f31711e.append(aVar.f32619a, aVar);
            }
        }

        public void f(j.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
                this.f31710d.append(bVar.f32622a, bVar);
            }
        }

        public void g() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                this.k = false;
                this.o = false;
                this.n.b();
            }
        }

        public void h(long j, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Long.valueOf(j), Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                this.f31715i = i2;
                this.l = j2;
                this.j = j;
                if (!this.f31708b || i2 != 1) {
                    if (!this.f31709c) {
                        return;
                    }
                    int i3 = this.f31715i;
                    if (i3 != 5 && i3 != 1 && i3 != 2) {
                        return;
                    }
                }
                a aVar = this.m;
                this.m = this.n;
                this.n = aVar;
                aVar.b();
                this.f31714h = 0;
                this.k = true;
            }
        }
    }

    public j(t tVar, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tVar, Boolean.valueOf(z), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f31698a = tVar;
        this.f31699b = z;
        this.f31700c = z2;
        this.f31705h = new boolean[3];
        this.f31701d = new o(7, 128);
        this.f31702e = new o(8, 128);
        this.f31703f = new o(6, 128);
        this.n = new b.i.b.a.i0.l();
    }

    public final void a(long j, int i2, int i3, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2)}) == null) {
            if (!this.l || this.k.c()) {
                this.f31701d.b(i3);
                this.f31702e.b(i3);
                if (!this.l) {
                    if (this.f31701d.c() && this.f31702e.c()) {
                        ArrayList arrayList = new ArrayList();
                        o oVar = this.f31701d;
                        arrayList.add(Arrays.copyOf(oVar.f31770d, oVar.f31771e));
                        o oVar2 = this.f31702e;
                        arrayList.add(Arrays.copyOf(oVar2.f31770d, oVar2.f31771e));
                        o oVar3 = this.f31701d;
                        j.b i4 = b.i.b.a.i0.j.i(oVar3.f31770d, 3, oVar3.f31771e);
                        o oVar4 = this.f31702e;
                        j.a h2 = b.i.b.a.i0.j.h(oVar4.f31770d, 3, oVar4.f31771e);
                        this.j.b(Format.createVideoSampleFormat(this.f31706i, "video/avc", null, -1, -1, i4.f32623b, i4.f32624c, -1.0f, arrayList, -1, i4.f32625d, null));
                        this.l = true;
                        this.k.f(i4);
                        this.k.e(h2);
                        this.f31701d.d();
                        this.f31702e.d();
                    }
                } else if (this.f31701d.c()) {
                    o oVar5 = this.f31701d;
                    this.k.f(b.i.b.a.i0.j.i(oVar5.f31770d, 3, oVar5.f31771e));
                    this.f31701d.d();
                } else if (this.f31702e.c()) {
                    o oVar6 = this.f31702e;
                    this.k.e(b.i.b.a.i0.j.h(oVar6.f31770d, 3, oVar6.f31771e));
                    this.f31702e.d();
                }
            }
            if (this.f31703f.b(i3)) {
                o oVar7 = this.f31703f;
                this.n.H(this.f31703f.f31770d, b.i.b.a.i0.j.k(oVar7.f31770d, oVar7.f31771e));
                this.n.J(4);
                this.f31698a.a(j2, this.n);
            }
            this.k.b(j, i2);
        }
    }

    @Override // b.i.b.a.a0.t.h
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            b.i.b.a.i0.j.a(this.f31705h);
            this.f31701d.d();
            this.f31702e.d();
            this.f31703f.d();
            this.k.g();
            this.f31704g = 0L;
        }
    }

    @Override // b.i.b.a.a0.t.h
    public void c(b.i.b.a.i0.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lVar) != null) {
            return;
        }
        int c2 = lVar.c();
        int d2 = lVar.d();
        byte[] bArr = lVar.f32635a;
        this.f31704g += lVar.a();
        this.j.a(lVar, lVar.a());
        while (true) {
            int c3 = b.i.b.a.i0.j.c(bArr, c2, d2, this.f31705h);
            if (c3 == d2) {
                g(bArr, c2, d2);
                return;
            }
            int f2 = b.i.b.a.i0.j.f(bArr, c3);
            int i2 = c3 - c2;
            if (i2 > 0) {
                g(bArr, c2, c3);
            }
            int i3 = d2 - c3;
            long j = this.f31704g - i3;
            a(j, i3, i2 < 0 ? -i2 : 0, this.m);
            h(j, f2, this.m);
            c2 = c3 + 3;
        }
    }

    @Override // b.i.b.a.a0.t.h
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    @Override // b.i.b.a.a0.t.h
    public void e(long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            this.m = j;
        }
    }

    @Override // b.i.b.a.a0.t.h
    public void f(b.i.b.a.a0.g gVar, w.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, gVar, dVar) == null) {
            dVar.a();
            this.f31706i = dVar.b();
            b.i.b.a.a0.m a2 = gVar.a(dVar.c(), 2);
            this.j = a2;
            this.k = new b(a2, this.f31699b, this.f31700c);
            this.f31698a.b(gVar, dVar);
        }
    }

    public final void g(byte[] bArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048582, this, bArr, i2, i3) == null) {
            if (!this.l || this.k.c()) {
                this.f31701d.a(bArr, i2, i3);
                this.f31702e.a(bArr, i2, i3);
            }
            this.f31703f.a(bArr, i2, i3);
            this.k.a(bArr, i2, i3);
        }
    }

    public final void h(long j, int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Long.valueOf(j), Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            if (!this.l || this.k.c()) {
                this.f31701d.e(i2);
                this.f31702e.e(i2);
            }
            this.f31703f.e(i2);
            this.k.h(j, i2, j2);
        }
    }
}
