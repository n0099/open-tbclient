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
/* loaded from: classes7.dex */
public final class j implements h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final t a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f29321b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f29322c;

    /* renamed from: d  reason: collision with root package name */
    public final o f29323d;

    /* renamed from: e  reason: collision with root package name */
    public final o f29324e;

    /* renamed from: f  reason: collision with root package name */
    public final o f29325f;

    /* renamed from: g  reason: collision with root package name */
    public long f29326g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean[] f29327h;

    /* renamed from: i  reason: collision with root package name */
    public String f29328i;

    /* renamed from: j  reason: collision with root package name */
    public c.i.b.a.a0.m f29329j;

    /* renamed from: k  reason: collision with root package name */
    public b f29330k;
    public boolean l;
    public long m;
    public final c.i.b.a.i0.l n;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final c.i.b.a.a0.m a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f29331b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f29332c;

        /* renamed from: d  reason: collision with root package name */
        public final SparseArray<j.b> f29333d;

        /* renamed from: e  reason: collision with root package name */
        public final SparseArray<j.a> f29334e;

        /* renamed from: f  reason: collision with root package name */
        public final c.i.b.a.i0.m f29335f;

        /* renamed from: g  reason: collision with root package name */
        public byte[] f29336g;

        /* renamed from: h  reason: collision with root package name */
        public int f29337h;

        /* renamed from: i  reason: collision with root package name */
        public int f29338i;

        /* renamed from: j  reason: collision with root package name */
        public long f29339j;

        /* renamed from: k  reason: collision with root package name */
        public boolean f29340k;
        public long l;
        public a m;
        public a n;
        public boolean o;
        public long p;
        public long q;
        public boolean r;

        /* loaded from: classes7.dex */
        public static final class a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public boolean a;

            /* renamed from: b  reason: collision with root package name */
            public boolean f29341b;

            /* renamed from: c  reason: collision with root package name */
            public j.b f29342c;

            /* renamed from: d  reason: collision with root package name */
            public int f29343d;

            /* renamed from: e  reason: collision with root package name */
            public int f29344e;

            /* renamed from: f  reason: collision with root package name */
            public int f29345f;

            /* renamed from: g  reason: collision with root package name */
            public int f29346g;

            /* renamed from: h  reason: collision with root package name */
            public boolean f29347h;

            /* renamed from: i  reason: collision with root package name */
            public boolean f29348i;

            /* renamed from: j  reason: collision with root package name */
            public boolean f29349j;

            /* renamed from: k  reason: collision with root package name */
            public boolean f29350k;
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
                    this.f29341b = false;
                    this.a = false;
                }
            }

            public final boolean c(a aVar) {
                InterceptResult invokeL;
                boolean z;
                boolean z2;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) {
                    if (this.a) {
                        if (!aVar.a || this.f29345f != aVar.f29345f || this.f29346g != aVar.f29346g || this.f29347h != aVar.f29347h) {
                            return true;
                        }
                        if (this.f29348i && aVar.f29348i && this.f29349j != aVar.f29349j) {
                            return true;
                        }
                        int i2 = this.f29343d;
                        int i3 = aVar.f29343d;
                        if (i2 != i3 && (i2 == 0 || i3 == 0)) {
                            return true;
                        }
                        if (this.f29342c.f30226h == 0 && aVar.f29342c.f30226h == 0 && (this.m != aVar.m || this.n != aVar.n)) {
                            return true;
                        }
                        if ((this.f29342c.f30226h == 1 && aVar.f29342c.f30226h == 1 && (this.o != aVar.o || this.p != aVar.p)) || (z = this.f29350k) != (z2 = aVar.f29350k)) {
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
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f29341b && ((i2 = this.f29344e) == 7 || i2 == 2) : invokeV.booleanValue;
            }

            public void e(j.b bVar, int i2, int i3, int i4, int i5, boolean z, boolean z2, boolean z3, boolean z4, int i6, int i7, int i8, int i9, int i10) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{bVar, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10)}) == null) {
                    this.f29342c = bVar;
                    this.f29343d = i2;
                    this.f29344e = i3;
                    this.f29345f = i4;
                    this.f29346g = i5;
                    this.f29347h = z;
                    this.f29348i = z2;
                    this.f29349j = z3;
                    this.f29350k = z4;
                    this.l = i6;
                    this.m = i7;
                    this.n = i8;
                    this.o = i9;
                    this.p = i10;
                    this.a = true;
                    this.f29341b = true;
                }
            }

            public void f(int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
                    this.f29344e = i2;
                    this.f29341b = true;
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
            this.a = mVar;
            this.f29331b = z;
            this.f29332c = z2;
            this.f29333d = new SparseArray<>();
            this.f29334e = new SparseArray<>();
            this.m = new a(null);
            this.n = new a(null);
            byte[] bArr = new byte[128];
            this.f29336g = bArr;
            this.f29335f = new c.i.b.a.i0.m(bArr, 0, 0);
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
            if ((interceptable == null || interceptable.invokeLII(1048576, this, bArr, i2, i3) == null) && this.f29340k) {
                int i9 = i3 - i2;
                byte[] bArr2 = this.f29336g;
                int length = bArr2.length;
                int i10 = this.f29337h;
                if (length < i10 + i9) {
                    this.f29336g = Arrays.copyOf(bArr2, (i10 + i9) * 2);
                }
                System.arraycopy(bArr, i2, this.f29336g, this.f29337h, i9);
                int i11 = this.f29337h + i9;
                this.f29337h = i11;
                this.f29335f.i(this.f29336g, 0, i11);
                if (this.f29335f.b(8)) {
                    this.f29335f.k();
                    int e2 = this.f29335f.e(2);
                    this.f29335f.l(5);
                    if (this.f29335f.c()) {
                        this.f29335f.h();
                        if (this.f29335f.c()) {
                            int h2 = this.f29335f.h();
                            if (!this.f29332c) {
                                this.f29340k = false;
                                this.n.f(h2);
                            } else if (this.f29335f.c()) {
                                int h3 = this.f29335f.h();
                                if (this.f29334e.indexOfKey(h3) < 0) {
                                    this.f29340k = false;
                                    return;
                                }
                                j.a aVar = this.f29334e.get(h3);
                                j.b bVar = this.f29333d.get(aVar.f30218b);
                                if (bVar.f30223e) {
                                    if (!this.f29335f.b(2)) {
                                        return;
                                    }
                                    this.f29335f.l(2);
                                }
                                if (this.f29335f.b(bVar.f30225g)) {
                                    int e3 = this.f29335f.e(bVar.f30225g);
                                    if (bVar.f30224f) {
                                        z = false;
                                    } else if (!this.f29335f.b(1)) {
                                        return;
                                    } else {
                                        boolean d2 = this.f29335f.d();
                                        if (d2) {
                                            if (this.f29335f.b(1)) {
                                                z = d2;
                                                z3 = this.f29335f.d();
                                                z2 = true;
                                                z4 = this.f29338i != 5;
                                                if (z4) {
                                                    i4 = 0;
                                                } else if (!this.f29335f.c()) {
                                                    return;
                                                } else {
                                                    i4 = this.f29335f.h();
                                                }
                                                i5 = bVar.f30226h;
                                                if (i5 != 0) {
                                                    if (!this.f29335f.b(bVar.f30227i)) {
                                                        return;
                                                    }
                                                    int e4 = this.f29335f.e(bVar.f30227i);
                                                    if (aVar.f30219c && !z) {
                                                        if (this.f29335f.c()) {
                                                            i8 = this.f29335f.g();
                                                            i6 = e4;
                                                            i7 = 0;
                                                            g2 = 0;
                                                            this.n.e(bVar, e2, h2, e3, h3, z, z2, z3, z4, i4, i6, i8, i7, g2);
                                                            this.f29340k = false;
                                                        }
                                                        return;
                                                    }
                                                    i6 = e4;
                                                } else if (i5 == 1 && !bVar.f30228j) {
                                                    if (this.f29335f.c()) {
                                                        int g3 = this.f29335f.g();
                                                        if (aVar.f30219c && !z) {
                                                            if (this.f29335f.c()) {
                                                                g2 = this.f29335f.g();
                                                                i7 = g3;
                                                                i6 = 0;
                                                                i8 = 0;
                                                                this.n.e(bVar, e2, h2, e3, h3, z, z2, z3, z4, i4, i6, i8, i7, g2);
                                                                this.f29340k = false;
                                                            }
                                                            return;
                                                        }
                                                        i7 = g3;
                                                        i6 = 0;
                                                        i8 = 0;
                                                        g2 = 0;
                                                        this.n.e(bVar, e2, h2, e3, h3, z, z2, z3, z4, i4, i6, i8, i7, g2);
                                                        this.f29340k = false;
                                                    }
                                                    return;
                                                } else {
                                                    i6 = 0;
                                                }
                                                i8 = 0;
                                                i7 = 0;
                                                g2 = 0;
                                                this.n.e(bVar, e2, h2, e3, h3, z, z2, z3, z4, i4, i6, i8, i7, g2);
                                                this.f29340k = false;
                                            }
                                            return;
                                        }
                                        z = d2;
                                    }
                                    z2 = false;
                                    z3 = false;
                                    if (this.f29338i != 5) {
                                    }
                                    if (z4) {
                                    }
                                    i5 = bVar.f30226h;
                                    if (i5 != 0) {
                                    }
                                    i8 = 0;
                                    i7 = 0;
                                    g2 = 0;
                                    this.n.e(bVar, e2, h2, e3, h3, z, z2, z3, z4, i4, i6, i8, i7, g2);
                                    this.f29340k = false;
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
                if (this.f29338i == 9 || (this.f29332c && this.n.c(this.m))) {
                    if (this.o) {
                        d(i2 + ((int) (j2 - this.f29339j)));
                    }
                    this.p = this.f29339j;
                    this.q = this.l;
                    this.r = false;
                    this.o = true;
                }
                boolean z2 = this.r;
                int i3 = this.f29338i;
                if (i3 == 5 || (this.f29331b && i3 == 1 && this.n.d())) {
                    z = true;
                }
                this.r = z2 | z;
            }
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f29332c : invokeV.booleanValue;
        }

        public final void d(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
                boolean z = this.r;
                this.a.c(this.q, z ? 1 : 0, (int) (this.f29339j - this.p), i2, null);
            }
        }

        public void e(j.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
                this.f29334e.append(aVar.a, aVar);
            }
        }

        public void f(j.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
                this.f29333d.append(bVar.a, bVar);
            }
        }

        public void g() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                this.f29340k = false;
                this.o = false;
                this.n.b();
            }
        }

        public void h(long j2, int i2, long j3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2), Long.valueOf(j3)}) == null) {
                this.f29338i = i2;
                this.l = j3;
                this.f29339j = j2;
                if (!this.f29331b || i2 != 1) {
                    if (!this.f29332c) {
                        return;
                    }
                    int i3 = this.f29338i;
                    if (i3 != 5 && i3 != 1 && i3 != 2) {
                        return;
                    }
                }
                a aVar = this.m;
                this.m = this.n;
                this.n = aVar;
                aVar.b();
                this.f29337h = 0;
                this.f29340k = true;
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
        this.a = tVar;
        this.f29321b = z;
        this.f29322c = z2;
        this.f29327h = new boolean[3];
        this.f29323d = new o(7, 128);
        this.f29324e = new o(8, 128);
        this.f29325f = new o(6, 128);
        this.n = new c.i.b.a.i0.l();
    }

    public final void a(long j2, int i2, int i3, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j3)}) == null) {
            if (!this.l || this.f29330k.c()) {
                this.f29323d.b(i3);
                this.f29324e.b(i3);
                if (!this.l) {
                    if (this.f29323d.c() && this.f29324e.c()) {
                        ArrayList arrayList = new ArrayList();
                        o oVar = this.f29323d;
                        arrayList.add(Arrays.copyOf(oVar.f29398d, oVar.f29399e));
                        o oVar2 = this.f29324e;
                        arrayList.add(Arrays.copyOf(oVar2.f29398d, oVar2.f29399e));
                        o oVar3 = this.f29323d;
                        j.b i4 = c.i.b.a.i0.j.i(oVar3.f29398d, 3, oVar3.f29399e);
                        o oVar4 = this.f29324e;
                        j.a h2 = c.i.b.a.i0.j.h(oVar4.f29398d, 3, oVar4.f29399e);
                        this.f29329j.b(Format.createVideoSampleFormat(this.f29328i, "video/avc", null, -1, -1, i4.f30220b, i4.f30221c, -1.0f, arrayList, -1, i4.f30222d, null));
                        this.l = true;
                        this.f29330k.f(i4);
                        this.f29330k.e(h2);
                        this.f29323d.d();
                        this.f29324e.d();
                    }
                } else if (this.f29323d.c()) {
                    o oVar5 = this.f29323d;
                    this.f29330k.f(c.i.b.a.i0.j.i(oVar5.f29398d, 3, oVar5.f29399e));
                    this.f29323d.d();
                } else if (this.f29324e.c()) {
                    o oVar6 = this.f29324e;
                    this.f29330k.e(c.i.b.a.i0.j.h(oVar6.f29398d, 3, oVar6.f29399e));
                    this.f29324e.d();
                }
            }
            if (this.f29325f.b(i3)) {
                o oVar7 = this.f29325f;
                this.n.H(this.f29325f.f29398d, c.i.b.a.i0.j.k(oVar7.f29398d, oVar7.f29399e));
                this.n.J(4);
                this.a.a(j3, this.n);
            }
            this.f29330k.b(j2, i2);
        }
    }

    @Override // c.i.b.a.a0.t.h
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.i.b.a.i0.j.a(this.f29327h);
            this.f29323d.d();
            this.f29324e.d();
            this.f29325f.d();
            this.f29330k.g();
            this.f29326g = 0L;
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
        byte[] bArr = lVar.a;
        this.f29326g += lVar.a();
        this.f29329j.a(lVar, lVar.a());
        while (true) {
            int c3 = c.i.b.a.i0.j.c(bArr, c2, d2, this.f29327h);
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
            long j2 = this.f29326g - i3;
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
            this.f29328i = dVar.b();
            c.i.b.a.a0.m a2 = gVar.a(dVar.c(), 2);
            this.f29329j = a2;
            this.f29330k = new b(a2, this.f29321b, this.f29322c);
            this.a.b(gVar, dVar);
        }
    }

    public final void g(byte[] bArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048582, this, bArr, i2, i3) == null) {
            if (!this.l || this.f29330k.c()) {
                this.f29323d.a(bArr, i2, i3);
                this.f29324e.a(bArr, i2, i3);
            }
            this.f29325f.a(bArr, i2, i3);
            this.f29330k.a(bArr, i2, i3);
        }
    }

    public final void h(long j2, int i2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2), Long.valueOf(j3)}) == null) {
            if (!this.l || this.f29330k.c()) {
                this.f29323d.e(i2);
                this.f29324e.e(i2);
            }
            this.f29325f.e(i2);
            this.f29330k.h(j2, i2, j3);
        }
    }
}
