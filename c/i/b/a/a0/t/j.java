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
    public final t f32836a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f32837b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f32838c;

    /* renamed from: d  reason: collision with root package name */
    public final o f32839d;

    /* renamed from: e  reason: collision with root package name */
    public final o f32840e;

    /* renamed from: f  reason: collision with root package name */
    public final o f32841f;

    /* renamed from: g  reason: collision with root package name */
    public long f32842g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean[] f32843h;

    /* renamed from: i  reason: collision with root package name */
    public String f32844i;

    /* renamed from: j  reason: collision with root package name */
    public c.i.b.a.a0.m f32845j;
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
        public final c.i.b.a.a0.m f32846a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f32847b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f32848c;

        /* renamed from: d  reason: collision with root package name */
        public final SparseArray<j.b> f32849d;

        /* renamed from: e  reason: collision with root package name */
        public final SparseArray<j.a> f32850e;

        /* renamed from: f  reason: collision with root package name */
        public final c.i.b.a.i0.m f32851f;

        /* renamed from: g  reason: collision with root package name */
        public byte[] f32852g;

        /* renamed from: h  reason: collision with root package name */
        public int f32853h;

        /* renamed from: i  reason: collision with root package name */
        public int f32854i;

        /* renamed from: j  reason: collision with root package name */
        public long f32855j;
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
            public boolean f32856a;

            /* renamed from: b  reason: collision with root package name */
            public boolean f32857b;

            /* renamed from: c  reason: collision with root package name */
            public j.b f32858c;

            /* renamed from: d  reason: collision with root package name */
            public int f32859d;

            /* renamed from: e  reason: collision with root package name */
            public int f32860e;

            /* renamed from: f  reason: collision with root package name */
            public int f32861f;

            /* renamed from: g  reason: collision with root package name */
            public int f32862g;

            /* renamed from: h  reason: collision with root package name */
            public boolean f32863h;

            /* renamed from: i  reason: collision with root package name */
            public boolean f32864i;

            /* renamed from: j  reason: collision with root package name */
            public boolean f32865j;
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
                    this.f32857b = false;
                    this.f32856a = false;
                }
            }

            public final boolean c(a aVar) {
                InterceptResult invokeL;
                boolean z;
                boolean z2;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) {
                    if (this.f32856a) {
                        if (!aVar.f32856a || this.f32861f != aVar.f32861f || this.f32862g != aVar.f32862g || this.f32863h != aVar.f32863h) {
                            return true;
                        }
                        if (this.f32864i && aVar.f32864i && this.f32865j != aVar.f32865j) {
                            return true;
                        }
                        int i2 = this.f32859d;
                        int i3 = aVar.f32859d;
                        if (i2 != i3 && (i2 == 0 || i3 == 0)) {
                            return true;
                        }
                        if (this.f32858c.f33832h == 0 && aVar.f32858c.f33832h == 0 && (this.m != aVar.m || this.n != aVar.n)) {
                            return true;
                        }
                        if ((this.f32858c.f33832h == 1 && aVar.f32858c.f33832h == 1 && (this.o != aVar.o || this.p != aVar.p)) || (z = this.k) != (z2 = aVar.k)) {
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
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f32857b && ((i2 = this.f32860e) == 7 || i2 == 2) : invokeV.booleanValue;
            }

            public void e(j.b bVar, int i2, int i3, int i4, int i5, boolean z, boolean z2, boolean z3, boolean z4, int i6, int i7, int i8, int i9, int i10) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{bVar, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10)}) == null) {
                    this.f32858c = bVar;
                    this.f32859d = i2;
                    this.f32860e = i3;
                    this.f32861f = i4;
                    this.f32862g = i5;
                    this.f32863h = z;
                    this.f32864i = z2;
                    this.f32865j = z3;
                    this.k = z4;
                    this.l = i6;
                    this.m = i7;
                    this.n = i8;
                    this.o = i9;
                    this.p = i10;
                    this.f32856a = true;
                    this.f32857b = true;
                }
            }

            public void f(int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
                    this.f32860e = i2;
                    this.f32857b = true;
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
            this.f32846a = mVar;
            this.f32847b = z;
            this.f32848c = z2;
            this.f32849d = new SparseArray<>();
            this.f32850e = new SparseArray<>();
            this.m = new a(null);
            this.n = new a(null);
            byte[] bArr = new byte[128];
            this.f32852g = bArr;
            this.f32851f = new c.i.b.a.i0.m(bArr, 0, 0);
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
                byte[] bArr2 = this.f32852g;
                int length = bArr2.length;
                int i10 = this.f32853h;
                if (length < i10 + i9) {
                    this.f32852g = Arrays.copyOf(bArr2, (i10 + i9) * 2);
                }
                System.arraycopy(bArr, i2, this.f32852g, this.f32853h, i9);
                int i11 = this.f32853h + i9;
                this.f32853h = i11;
                this.f32851f.i(this.f32852g, 0, i11);
                if (this.f32851f.b(8)) {
                    this.f32851f.k();
                    int e2 = this.f32851f.e(2);
                    this.f32851f.l(5);
                    if (this.f32851f.c()) {
                        this.f32851f.h();
                        if (this.f32851f.c()) {
                            int h2 = this.f32851f.h();
                            if (!this.f32848c) {
                                this.k = false;
                                this.n.f(h2);
                            } else if (this.f32851f.c()) {
                                int h3 = this.f32851f.h();
                                if (this.f32850e.indexOfKey(h3) < 0) {
                                    this.k = false;
                                    return;
                                }
                                j.a aVar = this.f32850e.get(h3);
                                j.b bVar = this.f32849d.get(aVar.f33823b);
                                if (bVar.f33829e) {
                                    if (!this.f32851f.b(2)) {
                                        return;
                                    }
                                    this.f32851f.l(2);
                                }
                                if (this.f32851f.b(bVar.f33831g)) {
                                    int e3 = this.f32851f.e(bVar.f33831g);
                                    if (bVar.f33830f) {
                                        z = false;
                                    } else if (!this.f32851f.b(1)) {
                                        return;
                                    } else {
                                        boolean d2 = this.f32851f.d();
                                        if (d2) {
                                            if (this.f32851f.b(1)) {
                                                z = d2;
                                                z3 = this.f32851f.d();
                                                z2 = true;
                                                z4 = this.f32854i != 5;
                                                if (z4) {
                                                    i4 = 0;
                                                } else if (!this.f32851f.c()) {
                                                    return;
                                                } else {
                                                    i4 = this.f32851f.h();
                                                }
                                                i5 = bVar.f33832h;
                                                if (i5 != 0) {
                                                    if (!this.f32851f.b(bVar.f33833i)) {
                                                        return;
                                                    }
                                                    int e4 = this.f32851f.e(bVar.f33833i);
                                                    if (aVar.f33824c && !z) {
                                                        if (this.f32851f.c()) {
                                                            i8 = this.f32851f.g();
                                                            i6 = e4;
                                                            i7 = 0;
                                                            g2 = 0;
                                                            this.n.e(bVar, e2, h2, e3, h3, z, z2, z3, z4, i4, i6, i8, i7, g2);
                                                            this.k = false;
                                                        }
                                                        return;
                                                    }
                                                    i6 = e4;
                                                } else if (i5 == 1 && !bVar.f33834j) {
                                                    if (this.f32851f.c()) {
                                                        int g3 = this.f32851f.g();
                                                        if (aVar.f33824c && !z) {
                                                            if (this.f32851f.c()) {
                                                                g2 = this.f32851f.g();
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
                                    if (this.f32854i != 5) {
                                    }
                                    if (z4) {
                                    }
                                    i5 = bVar.f33832h;
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
                if (this.f32854i == 9 || (this.f32848c && this.n.c(this.m))) {
                    if (this.o) {
                        d(i2 + ((int) (j2 - this.f32855j)));
                    }
                    this.p = this.f32855j;
                    this.q = this.l;
                    this.r = false;
                    this.o = true;
                }
                boolean z2 = this.r;
                int i3 = this.f32854i;
                if (i3 == 5 || (this.f32847b && i3 == 1 && this.n.d())) {
                    z = true;
                }
                this.r = z2 | z;
            }
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f32848c : invokeV.booleanValue;
        }

        public final void d(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
                boolean z = this.r;
                this.f32846a.c(this.q, z ? 1 : 0, (int) (this.f32855j - this.p), i2, null);
            }
        }

        public void e(j.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
                this.f32850e.append(aVar.f33822a, aVar);
            }
        }

        public void f(j.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
                this.f32849d.append(bVar.f33825a, bVar);
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
                this.f32854i = i2;
                this.l = j3;
                this.f32855j = j2;
                if (!this.f32847b || i2 != 1) {
                    if (!this.f32848c) {
                        return;
                    }
                    int i3 = this.f32854i;
                    if (i3 != 5 && i3 != 1 && i3 != 2) {
                        return;
                    }
                }
                a aVar = this.m;
                this.m = this.n;
                this.n = aVar;
                aVar.b();
                this.f32853h = 0;
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
        this.f32836a = tVar;
        this.f32837b = z;
        this.f32838c = z2;
        this.f32843h = new boolean[3];
        this.f32839d = new o(7, 128);
        this.f32840e = new o(8, 128);
        this.f32841f = new o(6, 128);
        this.n = new c.i.b.a.i0.l();
    }

    public final void a(long j2, int i2, int i3, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j3)}) == null) {
            if (!this.l || this.k.c()) {
                this.f32839d.b(i3);
                this.f32840e.b(i3);
                if (!this.l) {
                    if (this.f32839d.c() && this.f32840e.c()) {
                        ArrayList arrayList = new ArrayList();
                        o oVar = this.f32839d;
                        arrayList.add(Arrays.copyOf(oVar.f32915d, oVar.f32916e));
                        o oVar2 = this.f32840e;
                        arrayList.add(Arrays.copyOf(oVar2.f32915d, oVar2.f32916e));
                        o oVar3 = this.f32839d;
                        j.b i4 = c.i.b.a.i0.j.i(oVar3.f32915d, 3, oVar3.f32916e);
                        o oVar4 = this.f32840e;
                        j.a h2 = c.i.b.a.i0.j.h(oVar4.f32915d, 3, oVar4.f32916e);
                        this.f32845j.b(Format.createVideoSampleFormat(this.f32844i, "video/avc", null, -1, -1, i4.f33826b, i4.f33827c, -1.0f, arrayList, -1, i4.f33828d, null));
                        this.l = true;
                        this.k.f(i4);
                        this.k.e(h2);
                        this.f32839d.d();
                        this.f32840e.d();
                    }
                } else if (this.f32839d.c()) {
                    o oVar5 = this.f32839d;
                    this.k.f(c.i.b.a.i0.j.i(oVar5.f32915d, 3, oVar5.f32916e));
                    this.f32839d.d();
                } else if (this.f32840e.c()) {
                    o oVar6 = this.f32840e;
                    this.k.e(c.i.b.a.i0.j.h(oVar6.f32915d, 3, oVar6.f32916e));
                    this.f32840e.d();
                }
            }
            if (this.f32841f.b(i3)) {
                o oVar7 = this.f32841f;
                this.n.H(this.f32841f.f32915d, c.i.b.a.i0.j.k(oVar7.f32915d, oVar7.f32916e));
                this.n.J(4);
                this.f32836a.a(j3, this.n);
            }
            this.k.b(j2, i2);
        }
    }

    @Override // c.i.b.a.a0.t.h
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.i.b.a.i0.j.a(this.f32843h);
            this.f32839d.d();
            this.f32840e.d();
            this.f32841f.d();
            this.k.g();
            this.f32842g = 0L;
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
        byte[] bArr = lVar.f33839a;
        this.f32842g += lVar.a();
        this.f32845j.a(lVar, lVar.a());
        while (true) {
            int c3 = c.i.b.a.i0.j.c(bArr, c2, d2, this.f32843h);
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
            long j2 = this.f32842g - i3;
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
            this.f32844i = dVar.b();
            c.i.b.a.a0.m a2 = gVar.a(dVar.c(), 2);
            this.f32845j = a2;
            this.k = new b(a2, this.f32837b, this.f32838c);
            this.f32836a.b(gVar, dVar);
        }
    }

    public final void g(byte[] bArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048582, this, bArr, i2, i3) == null) {
            if (!this.l || this.k.c()) {
                this.f32839d.a(bArr, i2, i3);
                this.f32840e.a(bArr, i2, i3);
            }
            this.f32841f.a(bArr, i2, i3);
            this.k.a(bArr, i2, i3);
        }
    }

    public final void h(long j2, int i2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2), Long.valueOf(j3)}) == null) {
            if (!this.l || this.k.c()) {
                this.f32839d.e(i2);
                this.f32840e.e(i2);
            }
            this.f32841f.e(i2);
            this.k.h(j2, i2, j3);
        }
    }
}
