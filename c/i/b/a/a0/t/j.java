package c.i.b.a.a0.t;

import android.util.SparseArray;
import c.i.b.a.a0.t.w;
import c.i.b.a.i0.j;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import java.util.ArrayList;
import java.util.Arrays;
/* loaded from: classes4.dex */
public final class j implements h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final t f32809a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f32810b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f32811c;

    /* renamed from: d  reason: collision with root package name */
    public final o f32812d;

    /* renamed from: e  reason: collision with root package name */
    public final o f32813e;

    /* renamed from: f  reason: collision with root package name */
    public final o f32814f;

    /* renamed from: g  reason: collision with root package name */
    public long f32815g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean[] f32816h;

    /* renamed from: i  reason: collision with root package name */
    public String f32817i;

    /* renamed from: j  reason: collision with root package name */
    public c.i.b.a.a0.m f32818j;
    public b k;
    public boolean l;
    public long m;
    public final c.i.b.a.i0.l n;

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final c.i.b.a.a0.m f32819a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f32820b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f32821c;

        /* renamed from: d  reason: collision with root package name */
        public final SparseArray<j.b> f32822d;

        /* renamed from: e  reason: collision with root package name */
        public final SparseArray<j.a> f32823e;

        /* renamed from: f  reason: collision with root package name */
        public final c.i.b.a.i0.m f32824f;

        /* renamed from: g  reason: collision with root package name */
        public byte[] f32825g;

        /* renamed from: h  reason: collision with root package name */
        public int f32826h;

        /* renamed from: i  reason: collision with root package name */
        public int f32827i;

        /* renamed from: j  reason: collision with root package name */
        public long f32828j;
        public boolean k;
        public long l;
        public a m;
        public a n;
        public boolean o;
        public long p;
        public long q;
        public boolean r;

        /* loaded from: classes4.dex */
        public static final class a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public boolean f32829a;

            /* renamed from: b  reason: collision with root package name */
            public boolean f32830b;

            /* renamed from: c  reason: collision with root package name */
            public j.b f32831c;

            /* renamed from: d  reason: collision with root package name */
            public int f32832d;

            /* renamed from: e  reason: collision with root package name */
            public int f32833e;

            /* renamed from: f  reason: collision with root package name */
            public int f32834f;

            /* renamed from: g  reason: collision with root package name */
            public int f32835g;

            /* renamed from: h  reason: collision with root package name */
            public boolean f32836h;

            /* renamed from: i  reason: collision with root package name */
            public boolean f32837i;

            /* renamed from: j  reason: collision with root package name */
            public boolean f32838j;
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
                    this.f32830b = false;
                    this.f32829a = false;
                }
            }

            public final boolean c(a aVar) {
                InterceptResult invokeL;
                boolean z;
                boolean z2;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) {
                    if (this.f32829a) {
                        if (!aVar.f32829a || this.f32834f != aVar.f32834f || this.f32835g != aVar.f32835g || this.f32836h != aVar.f32836h) {
                            return true;
                        }
                        if (this.f32837i && aVar.f32837i && this.f32838j != aVar.f32838j) {
                            return true;
                        }
                        int i2 = this.f32832d;
                        int i3 = aVar.f32832d;
                        if (i2 != i3 && (i2 == 0 || i3 == 0)) {
                            return true;
                        }
                        if (this.f32831c.f33805h == 0 && aVar.f32831c.f33805h == 0 && (this.m != aVar.m || this.n != aVar.n)) {
                            return true;
                        }
                        if ((this.f32831c.f33805h == 1 && aVar.f32831c.f33805h == 1 && (this.o != aVar.o || this.p != aVar.p)) || (z = this.k) != (z2 = aVar.k)) {
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
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f32830b && ((i2 = this.f32833e) == 7 || i2 == 2) : invokeV.booleanValue;
            }

            public void e(j.b bVar, int i2, int i3, int i4, int i5, boolean z, boolean z2, boolean z3, boolean z4, int i6, int i7, int i8, int i9, int i10) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{bVar, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10)}) == null) {
                    this.f32831c = bVar;
                    this.f32832d = i2;
                    this.f32833e = i3;
                    this.f32834f = i4;
                    this.f32835g = i5;
                    this.f32836h = z;
                    this.f32837i = z2;
                    this.f32838j = z3;
                    this.k = z4;
                    this.l = i6;
                    this.m = i7;
                    this.n = i8;
                    this.o = i9;
                    this.p = i10;
                    this.f32829a = true;
                    this.f32830b = true;
                }
            }

            public void f(int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
                    this.f32833e = i2;
                    this.f32830b = true;
                }
            }

            public /* synthetic */ a(a aVar) {
                this();
            }
        }

        public b(c.i.b.a.a0.m mVar, boolean z, boolean z2) {
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
            this.f32819a = mVar;
            this.f32820b = z;
            this.f32821c = z2;
            this.f32822d = new SparseArray<>();
            this.f32823e = new SparseArray<>();
            this.m = new a(null);
            this.n = new a(null);
            byte[] bArr = new byte[128];
            this.f32825g = bArr;
            this.f32824f = new c.i.b.a.i0.m(bArr, 0, 0);
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
                byte[] bArr2 = this.f32825g;
                int length = bArr2.length;
                int i10 = this.f32826h;
                if (length < i10 + i9) {
                    this.f32825g = Arrays.copyOf(bArr2, (i10 + i9) * 2);
                }
                System.arraycopy(bArr, i2, this.f32825g, this.f32826h, i9);
                int i11 = this.f32826h + i9;
                this.f32826h = i11;
                this.f32824f.i(this.f32825g, 0, i11);
                if (this.f32824f.b(8)) {
                    this.f32824f.k();
                    int e2 = this.f32824f.e(2);
                    this.f32824f.l(5);
                    if (this.f32824f.c()) {
                        this.f32824f.h();
                        if (this.f32824f.c()) {
                            int h2 = this.f32824f.h();
                            if (!this.f32821c) {
                                this.k = false;
                                this.n.f(h2);
                            } else if (this.f32824f.c()) {
                                int h3 = this.f32824f.h();
                                if (this.f32823e.indexOfKey(h3) < 0) {
                                    this.k = false;
                                    return;
                                }
                                j.a aVar = this.f32823e.get(h3);
                                j.b bVar = this.f32822d.get(aVar.f33796b);
                                if (bVar.f33802e) {
                                    if (!this.f32824f.b(2)) {
                                        return;
                                    }
                                    this.f32824f.l(2);
                                }
                                if (this.f32824f.b(bVar.f33804g)) {
                                    int e3 = this.f32824f.e(bVar.f33804g);
                                    if (bVar.f33803f) {
                                        z = false;
                                    } else if (!this.f32824f.b(1)) {
                                        return;
                                    } else {
                                        boolean d2 = this.f32824f.d();
                                        if (d2) {
                                            if (this.f32824f.b(1)) {
                                                z = d2;
                                                z3 = this.f32824f.d();
                                                z2 = true;
                                                z4 = this.f32827i != 5;
                                                if (z4) {
                                                    i4 = 0;
                                                } else if (!this.f32824f.c()) {
                                                    return;
                                                } else {
                                                    i4 = this.f32824f.h();
                                                }
                                                i5 = bVar.f33805h;
                                                if (i5 != 0) {
                                                    if (!this.f32824f.b(bVar.f33806i)) {
                                                        return;
                                                    }
                                                    int e4 = this.f32824f.e(bVar.f33806i);
                                                    if (aVar.f33797c && !z) {
                                                        if (this.f32824f.c()) {
                                                            i8 = this.f32824f.g();
                                                            i6 = e4;
                                                            i7 = 0;
                                                            g2 = 0;
                                                            this.n.e(bVar, e2, h2, e3, h3, z, z2, z3, z4, i4, i6, i8, i7, g2);
                                                            this.k = false;
                                                        }
                                                        return;
                                                    }
                                                    i6 = e4;
                                                } else if (i5 == 1 && !bVar.f33807j) {
                                                    if (this.f32824f.c()) {
                                                        int g3 = this.f32824f.g();
                                                        if (aVar.f33797c && !z) {
                                                            if (this.f32824f.c()) {
                                                                g2 = this.f32824f.g();
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
                                    if (this.f32827i != 5) {
                                    }
                                    if (z4) {
                                    }
                                    i5 = bVar.f33805h;
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

        public void b(long j2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
                boolean z = false;
                if (this.f32827i == 9 || (this.f32821c && this.n.c(this.m))) {
                    if (this.o) {
                        d(i2 + ((int) (j2 - this.f32828j)));
                    }
                    this.p = this.f32828j;
                    this.q = this.l;
                    this.r = false;
                    this.o = true;
                }
                boolean z2 = this.r;
                int i3 = this.f32827i;
                if (i3 == 5 || (this.f32820b && i3 == 1 && this.n.d())) {
                    z = true;
                }
                this.r = z2 | z;
            }
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f32821c : invokeV.booleanValue;
        }

        public final void d(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
                boolean z = this.r;
                this.f32819a.c(this.q, z ? 1 : 0, (int) (this.f32828j - this.p), i2, null);
            }
        }

        public void e(j.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
                this.f32823e.append(aVar.f33795a, aVar);
            }
        }

        public void f(j.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
                this.f32822d.append(bVar.f33798a, bVar);
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

        public void h(long j2, int i2, long j3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2), Long.valueOf(j3)}) == null) {
                this.f32827i = i2;
                this.l = j3;
                this.f32828j = j2;
                if (!this.f32820b || i2 != 1) {
                    if (!this.f32821c) {
                        return;
                    }
                    int i3 = this.f32827i;
                    if (i3 != 5 && i3 != 1 && i3 != 2) {
                        return;
                    }
                }
                a aVar = this.m;
                this.m = this.n;
                this.n = aVar;
                aVar.b();
                this.f32826h = 0;
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
        this.f32809a = tVar;
        this.f32810b = z;
        this.f32811c = z2;
        this.f32816h = new boolean[3];
        this.f32812d = new o(7, 128);
        this.f32813e = new o(8, 128);
        this.f32814f = new o(6, 128);
        this.n = new c.i.b.a.i0.l();
    }

    public final void a(long j2, int i2, int i3, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j3)}) == null) {
            if (!this.l || this.k.c()) {
                this.f32812d.b(i3);
                this.f32813e.b(i3);
                if (!this.l) {
                    if (this.f32812d.c() && this.f32813e.c()) {
                        ArrayList arrayList = new ArrayList();
                        o oVar = this.f32812d;
                        arrayList.add(Arrays.copyOf(oVar.f32888d, oVar.f32889e));
                        o oVar2 = this.f32813e;
                        arrayList.add(Arrays.copyOf(oVar2.f32888d, oVar2.f32889e));
                        o oVar3 = this.f32812d;
                        j.b i4 = c.i.b.a.i0.j.i(oVar3.f32888d, 3, oVar3.f32889e);
                        o oVar4 = this.f32813e;
                        j.a h2 = c.i.b.a.i0.j.h(oVar4.f32888d, 3, oVar4.f32889e);
                        this.f32818j.b(Format.createVideoSampleFormat(this.f32817i, "video/avc", null, -1, -1, i4.f33799b, i4.f33800c, -1.0f, arrayList, -1, i4.f33801d, null));
                        this.l = true;
                        this.k.f(i4);
                        this.k.e(h2);
                        this.f32812d.d();
                        this.f32813e.d();
                    }
                } else if (this.f32812d.c()) {
                    o oVar5 = this.f32812d;
                    this.k.f(c.i.b.a.i0.j.i(oVar5.f32888d, 3, oVar5.f32889e));
                    this.f32812d.d();
                } else if (this.f32813e.c()) {
                    o oVar6 = this.f32813e;
                    this.k.e(c.i.b.a.i0.j.h(oVar6.f32888d, 3, oVar6.f32889e));
                    this.f32813e.d();
                }
            }
            if (this.f32814f.b(i3)) {
                o oVar7 = this.f32814f;
                this.n.H(this.f32814f.f32888d, c.i.b.a.i0.j.k(oVar7.f32888d, oVar7.f32889e));
                this.n.J(4);
                this.f32809a.a(j3, this.n);
            }
            this.k.b(j2, i2);
        }
    }

    @Override // c.i.b.a.a0.t.h
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.i.b.a.i0.j.a(this.f32816h);
            this.f32812d.d();
            this.f32813e.d();
            this.f32814f.d();
            this.k.g();
            this.f32815g = 0L;
        }
    }

    @Override // c.i.b.a.a0.t.h
    public void c(c.i.b.a.i0.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lVar) != null) {
            return;
        }
        int c2 = lVar.c();
        int d2 = lVar.d();
        byte[] bArr = lVar.f33812a;
        this.f32815g += lVar.a();
        this.f32818j.a(lVar, lVar.a());
        while (true) {
            int c3 = c.i.b.a.i0.j.c(bArr, c2, d2, this.f32816h);
            if (c3 == d2) {
                g(bArr, c2, d2);
                return;
            }
            int f2 = c.i.b.a.i0.j.f(bArr, c3);
            int i2 = c3 - c2;
            if (i2 > 0) {
                g(bArr, c2, c3);
            }
            int i3 = d2 - c3;
            long j2 = this.f32815g - i3;
            a(j2, i3, i2 < 0 ? -i2 : 0, this.m);
            h(j2, f2, this.m);
            c2 = c3 + 3;
        }
    }

    @Override // c.i.b.a.a0.t.h
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    @Override // c.i.b.a.a0.t.h
    public void e(long j2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j2), Boolean.valueOf(z)}) == null) {
            this.m = j2;
        }
    }

    @Override // c.i.b.a.a0.t.h
    public void f(c.i.b.a.a0.g gVar, w.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, gVar, dVar) == null) {
            dVar.a();
            this.f32817i = dVar.b();
            c.i.b.a.a0.m a2 = gVar.a(dVar.c(), 2);
            this.f32818j = a2;
            this.k = new b(a2, this.f32810b, this.f32811c);
            this.f32809a.b(gVar, dVar);
        }
    }

    public final void g(byte[] bArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048582, this, bArr, i2, i3) == null) {
            if (!this.l || this.k.c()) {
                this.f32812d.a(bArr, i2, i3);
                this.f32813e.a(bArr, i2, i3);
            }
            this.f32814f.a(bArr, i2, i3);
            this.k.a(bArr, i2, i3);
        }
    }

    public final void h(long j2, int i2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2), Long.valueOf(j3)}) == null) {
            if (!this.l || this.k.c()) {
                this.f32812d.e(i2);
                this.f32813e.e(i2);
            }
            this.f32814f.e(i2);
            this.k.h(j2, i2, j3);
        }
    }
}
