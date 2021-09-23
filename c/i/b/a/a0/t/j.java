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
    public final t f32832a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f32833b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f32834c;

    /* renamed from: d  reason: collision with root package name */
    public final o f32835d;

    /* renamed from: e  reason: collision with root package name */
    public final o f32836e;

    /* renamed from: f  reason: collision with root package name */
    public final o f32837f;

    /* renamed from: g  reason: collision with root package name */
    public long f32838g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean[] f32839h;

    /* renamed from: i  reason: collision with root package name */
    public String f32840i;

    /* renamed from: j  reason: collision with root package name */
    public c.i.b.a.a0.m f32841j;
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
        public final c.i.b.a.a0.m f32842a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f32843b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f32844c;

        /* renamed from: d  reason: collision with root package name */
        public final SparseArray<j.b> f32845d;

        /* renamed from: e  reason: collision with root package name */
        public final SparseArray<j.a> f32846e;

        /* renamed from: f  reason: collision with root package name */
        public final c.i.b.a.i0.m f32847f;

        /* renamed from: g  reason: collision with root package name */
        public byte[] f32848g;

        /* renamed from: h  reason: collision with root package name */
        public int f32849h;

        /* renamed from: i  reason: collision with root package name */
        public int f32850i;

        /* renamed from: j  reason: collision with root package name */
        public long f32851j;
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
            public boolean f32852a;

            /* renamed from: b  reason: collision with root package name */
            public boolean f32853b;

            /* renamed from: c  reason: collision with root package name */
            public j.b f32854c;

            /* renamed from: d  reason: collision with root package name */
            public int f32855d;

            /* renamed from: e  reason: collision with root package name */
            public int f32856e;

            /* renamed from: f  reason: collision with root package name */
            public int f32857f;

            /* renamed from: g  reason: collision with root package name */
            public int f32858g;

            /* renamed from: h  reason: collision with root package name */
            public boolean f32859h;

            /* renamed from: i  reason: collision with root package name */
            public boolean f32860i;

            /* renamed from: j  reason: collision with root package name */
            public boolean f32861j;
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
                    this.f32853b = false;
                    this.f32852a = false;
                }
            }

            public final boolean c(a aVar) {
                InterceptResult invokeL;
                boolean z;
                boolean z2;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) {
                    if (this.f32852a) {
                        if (!aVar.f32852a || this.f32857f != aVar.f32857f || this.f32858g != aVar.f32858g || this.f32859h != aVar.f32859h) {
                            return true;
                        }
                        if (this.f32860i && aVar.f32860i && this.f32861j != aVar.f32861j) {
                            return true;
                        }
                        int i2 = this.f32855d;
                        int i3 = aVar.f32855d;
                        if (i2 != i3 && (i2 == 0 || i3 == 0)) {
                            return true;
                        }
                        if (this.f32854c.f33828h == 0 && aVar.f32854c.f33828h == 0 && (this.m != aVar.m || this.n != aVar.n)) {
                            return true;
                        }
                        if ((this.f32854c.f33828h == 1 && aVar.f32854c.f33828h == 1 && (this.o != aVar.o || this.p != aVar.p)) || (z = this.k) != (z2 = aVar.k)) {
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
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f32853b && ((i2 = this.f32856e) == 7 || i2 == 2) : invokeV.booleanValue;
            }

            public void e(j.b bVar, int i2, int i3, int i4, int i5, boolean z, boolean z2, boolean z3, boolean z4, int i6, int i7, int i8, int i9, int i10) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{bVar, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10)}) == null) {
                    this.f32854c = bVar;
                    this.f32855d = i2;
                    this.f32856e = i3;
                    this.f32857f = i4;
                    this.f32858g = i5;
                    this.f32859h = z;
                    this.f32860i = z2;
                    this.f32861j = z3;
                    this.k = z4;
                    this.l = i6;
                    this.m = i7;
                    this.n = i8;
                    this.o = i9;
                    this.p = i10;
                    this.f32852a = true;
                    this.f32853b = true;
                }
            }

            public void f(int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
                    this.f32856e = i2;
                    this.f32853b = true;
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
            this.f32842a = mVar;
            this.f32843b = z;
            this.f32844c = z2;
            this.f32845d = new SparseArray<>();
            this.f32846e = new SparseArray<>();
            this.m = new a(null);
            this.n = new a(null);
            byte[] bArr = new byte[128];
            this.f32848g = bArr;
            this.f32847f = new c.i.b.a.i0.m(bArr, 0, 0);
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
                byte[] bArr2 = this.f32848g;
                int length = bArr2.length;
                int i10 = this.f32849h;
                if (length < i10 + i9) {
                    this.f32848g = Arrays.copyOf(bArr2, (i10 + i9) * 2);
                }
                System.arraycopy(bArr, i2, this.f32848g, this.f32849h, i9);
                int i11 = this.f32849h + i9;
                this.f32849h = i11;
                this.f32847f.i(this.f32848g, 0, i11);
                if (this.f32847f.b(8)) {
                    this.f32847f.k();
                    int e2 = this.f32847f.e(2);
                    this.f32847f.l(5);
                    if (this.f32847f.c()) {
                        this.f32847f.h();
                        if (this.f32847f.c()) {
                            int h2 = this.f32847f.h();
                            if (!this.f32844c) {
                                this.k = false;
                                this.n.f(h2);
                            } else if (this.f32847f.c()) {
                                int h3 = this.f32847f.h();
                                if (this.f32846e.indexOfKey(h3) < 0) {
                                    this.k = false;
                                    return;
                                }
                                j.a aVar = this.f32846e.get(h3);
                                j.b bVar = this.f32845d.get(aVar.f33819b);
                                if (bVar.f33825e) {
                                    if (!this.f32847f.b(2)) {
                                        return;
                                    }
                                    this.f32847f.l(2);
                                }
                                if (this.f32847f.b(bVar.f33827g)) {
                                    int e3 = this.f32847f.e(bVar.f33827g);
                                    if (bVar.f33826f) {
                                        z = false;
                                    } else if (!this.f32847f.b(1)) {
                                        return;
                                    } else {
                                        boolean d2 = this.f32847f.d();
                                        if (d2) {
                                            if (this.f32847f.b(1)) {
                                                z = d2;
                                                z3 = this.f32847f.d();
                                                z2 = true;
                                                z4 = this.f32850i != 5;
                                                if (z4) {
                                                    i4 = 0;
                                                } else if (!this.f32847f.c()) {
                                                    return;
                                                } else {
                                                    i4 = this.f32847f.h();
                                                }
                                                i5 = bVar.f33828h;
                                                if (i5 != 0) {
                                                    if (!this.f32847f.b(bVar.f33829i)) {
                                                        return;
                                                    }
                                                    int e4 = this.f32847f.e(bVar.f33829i);
                                                    if (aVar.f33820c && !z) {
                                                        if (this.f32847f.c()) {
                                                            i8 = this.f32847f.g();
                                                            i6 = e4;
                                                            i7 = 0;
                                                            g2 = 0;
                                                            this.n.e(bVar, e2, h2, e3, h3, z, z2, z3, z4, i4, i6, i8, i7, g2);
                                                            this.k = false;
                                                        }
                                                        return;
                                                    }
                                                    i6 = e4;
                                                } else if (i5 == 1 && !bVar.f33830j) {
                                                    if (this.f32847f.c()) {
                                                        int g3 = this.f32847f.g();
                                                        if (aVar.f33820c && !z) {
                                                            if (this.f32847f.c()) {
                                                                g2 = this.f32847f.g();
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
                                    if (this.f32850i != 5) {
                                    }
                                    if (z4) {
                                    }
                                    i5 = bVar.f33828h;
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
                if (this.f32850i == 9 || (this.f32844c && this.n.c(this.m))) {
                    if (this.o) {
                        d(i2 + ((int) (j2 - this.f32851j)));
                    }
                    this.p = this.f32851j;
                    this.q = this.l;
                    this.r = false;
                    this.o = true;
                }
                boolean z2 = this.r;
                int i3 = this.f32850i;
                if (i3 == 5 || (this.f32843b && i3 == 1 && this.n.d())) {
                    z = true;
                }
                this.r = z2 | z;
            }
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f32844c : invokeV.booleanValue;
        }

        public final void d(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
                boolean z = this.r;
                this.f32842a.c(this.q, z ? 1 : 0, (int) (this.f32851j - this.p), i2, null);
            }
        }

        public void e(j.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
                this.f32846e.append(aVar.f33818a, aVar);
            }
        }

        public void f(j.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
                this.f32845d.append(bVar.f33821a, bVar);
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
                this.f32850i = i2;
                this.l = j3;
                this.f32851j = j2;
                if (!this.f32843b || i2 != 1) {
                    if (!this.f32844c) {
                        return;
                    }
                    int i3 = this.f32850i;
                    if (i3 != 5 && i3 != 1 && i3 != 2) {
                        return;
                    }
                }
                a aVar = this.m;
                this.m = this.n;
                this.n = aVar;
                aVar.b();
                this.f32849h = 0;
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
        this.f32832a = tVar;
        this.f32833b = z;
        this.f32834c = z2;
        this.f32839h = new boolean[3];
        this.f32835d = new o(7, 128);
        this.f32836e = new o(8, 128);
        this.f32837f = new o(6, 128);
        this.n = new c.i.b.a.i0.l();
    }

    public final void a(long j2, int i2, int i3, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j3)}) == null) {
            if (!this.l || this.k.c()) {
                this.f32835d.b(i3);
                this.f32836e.b(i3);
                if (!this.l) {
                    if (this.f32835d.c() && this.f32836e.c()) {
                        ArrayList arrayList = new ArrayList();
                        o oVar = this.f32835d;
                        arrayList.add(Arrays.copyOf(oVar.f32911d, oVar.f32912e));
                        o oVar2 = this.f32836e;
                        arrayList.add(Arrays.copyOf(oVar2.f32911d, oVar2.f32912e));
                        o oVar3 = this.f32835d;
                        j.b i4 = c.i.b.a.i0.j.i(oVar3.f32911d, 3, oVar3.f32912e);
                        o oVar4 = this.f32836e;
                        j.a h2 = c.i.b.a.i0.j.h(oVar4.f32911d, 3, oVar4.f32912e);
                        this.f32841j.b(Format.createVideoSampleFormat(this.f32840i, "video/avc", null, -1, -1, i4.f33822b, i4.f33823c, -1.0f, arrayList, -1, i4.f33824d, null));
                        this.l = true;
                        this.k.f(i4);
                        this.k.e(h2);
                        this.f32835d.d();
                        this.f32836e.d();
                    }
                } else if (this.f32835d.c()) {
                    o oVar5 = this.f32835d;
                    this.k.f(c.i.b.a.i0.j.i(oVar5.f32911d, 3, oVar5.f32912e));
                    this.f32835d.d();
                } else if (this.f32836e.c()) {
                    o oVar6 = this.f32836e;
                    this.k.e(c.i.b.a.i0.j.h(oVar6.f32911d, 3, oVar6.f32912e));
                    this.f32836e.d();
                }
            }
            if (this.f32837f.b(i3)) {
                o oVar7 = this.f32837f;
                this.n.H(this.f32837f.f32911d, c.i.b.a.i0.j.k(oVar7.f32911d, oVar7.f32912e));
                this.n.J(4);
                this.f32832a.a(j3, this.n);
            }
            this.k.b(j2, i2);
        }
    }

    @Override // c.i.b.a.a0.t.h
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.i.b.a.i0.j.a(this.f32839h);
            this.f32835d.d();
            this.f32836e.d();
            this.f32837f.d();
            this.k.g();
            this.f32838g = 0L;
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
        byte[] bArr = lVar.f33835a;
        this.f32838g += lVar.a();
        this.f32841j.a(lVar, lVar.a());
        while (true) {
            int c3 = c.i.b.a.i0.j.c(bArr, c2, d2, this.f32839h);
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
            long j2 = this.f32838g - i3;
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
            this.f32840i = dVar.b();
            c.i.b.a.a0.m a2 = gVar.a(dVar.c(), 2);
            this.f32841j = a2;
            this.k = new b(a2, this.f32833b, this.f32834c);
            this.f32832a.b(gVar, dVar);
        }
    }

    public final void g(byte[] bArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048582, this, bArr, i2, i3) == null) {
            if (!this.l || this.k.c()) {
                this.f32835d.a(bArr, i2, i3);
                this.f32836e.a(bArr, i2, i3);
            }
            this.f32837f.a(bArr, i2, i3);
            this.k.a(bArr, i2, i3);
        }
    }

    public final void h(long j2, int i2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2), Long.valueOf(j3)}) == null) {
            if (!this.l || this.k.c()) {
                this.f32835d.e(i2);
                this.f32836e.e(i2);
            }
            this.f32837f.e(i2);
            this.k.h(j2, i2, j3);
        }
    }
}
