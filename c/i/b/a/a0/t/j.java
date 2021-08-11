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
    public final t f32594a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f32595b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f32596c;

    /* renamed from: d  reason: collision with root package name */
    public final o f32597d;

    /* renamed from: e  reason: collision with root package name */
    public final o f32598e;

    /* renamed from: f  reason: collision with root package name */
    public final o f32599f;

    /* renamed from: g  reason: collision with root package name */
    public long f32600g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean[] f32601h;

    /* renamed from: i  reason: collision with root package name */
    public String f32602i;

    /* renamed from: j  reason: collision with root package name */
    public c.i.b.a.a0.m f32603j;
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
        public final c.i.b.a.a0.m f32604a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f32605b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f32606c;

        /* renamed from: d  reason: collision with root package name */
        public final SparseArray<j.b> f32607d;

        /* renamed from: e  reason: collision with root package name */
        public final SparseArray<j.a> f32608e;

        /* renamed from: f  reason: collision with root package name */
        public final c.i.b.a.i0.m f32609f;

        /* renamed from: g  reason: collision with root package name */
        public byte[] f32610g;

        /* renamed from: h  reason: collision with root package name */
        public int f32611h;

        /* renamed from: i  reason: collision with root package name */
        public int f32612i;

        /* renamed from: j  reason: collision with root package name */
        public long f32613j;
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
            public boolean f32614a;

            /* renamed from: b  reason: collision with root package name */
            public boolean f32615b;

            /* renamed from: c  reason: collision with root package name */
            public j.b f32616c;

            /* renamed from: d  reason: collision with root package name */
            public int f32617d;

            /* renamed from: e  reason: collision with root package name */
            public int f32618e;

            /* renamed from: f  reason: collision with root package name */
            public int f32619f;

            /* renamed from: g  reason: collision with root package name */
            public int f32620g;

            /* renamed from: h  reason: collision with root package name */
            public boolean f32621h;

            /* renamed from: i  reason: collision with root package name */
            public boolean f32622i;

            /* renamed from: j  reason: collision with root package name */
            public boolean f32623j;
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
                    this.f32615b = false;
                    this.f32614a = false;
                }
            }

            public final boolean c(a aVar) {
                InterceptResult invokeL;
                boolean z;
                boolean z2;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) {
                    if (this.f32614a) {
                        if (!aVar.f32614a || this.f32619f != aVar.f32619f || this.f32620g != aVar.f32620g || this.f32621h != aVar.f32621h) {
                            return true;
                        }
                        if (this.f32622i && aVar.f32622i && this.f32623j != aVar.f32623j) {
                            return true;
                        }
                        int i2 = this.f32617d;
                        int i3 = aVar.f32617d;
                        if (i2 != i3 && (i2 == 0 || i3 == 0)) {
                            return true;
                        }
                        if (this.f32616c.f33590h == 0 && aVar.f32616c.f33590h == 0 && (this.m != aVar.m || this.n != aVar.n)) {
                            return true;
                        }
                        if ((this.f32616c.f33590h == 1 && aVar.f32616c.f33590h == 1 && (this.o != aVar.o || this.p != aVar.p)) || (z = this.k) != (z2 = aVar.k)) {
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
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f32615b && ((i2 = this.f32618e) == 7 || i2 == 2) : invokeV.booleanValue;
            }

            public void e(j.b bVar, int i2, int i3, int i4, int i5, boolean z, boolean z2, boolean z3, boolean z4, int i6, int i7, int i8, int i9, int i10) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{bVar, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10)}) == null) {
                    this.f32616c = bVar;
                    this.f32617d = i2;
                    this.f32618e = i3;
                    this.f32619f = i4;
                    this.f32620g = i5;
                    this.f32621h = z;
                    this.f32622i = z2;
                    this.f32623j = z3;
                    this.k = z4;
                    this.l = i6;
                    this.m = i7;
                    this.n = i8;
                    this.o = i9;
                    this.p = i10;
                    this.f32614a = true;
                    this.f32615b = true;
                }
            }

            public void f(int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
                    this.f32618e = i2;
                    this.f32615b = true;
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
            this.f32604a = mVar;
            this.f32605b = z;
            this.f32606c = z2;
            this.f32607d = new SparseArray<>();
            this.f32608e = new SparseArray<>();
            this.m = new a(null);
            this.n = new a(null);
            byte[] bArr = new byte[128];
            this.f32610g = bArr;
            this.f32609f = new c.i.b.a.i0.m(bArr, 0, 0);
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
                byte[] bArr2 = this.f32610g;
                int length = bArr2.length;
                int i10 = this.f32611h;
                if (length < i10 + i9) {
                    this.f32610g = Arrays.copyOf(bArr2, (i10 + i9) * 2);
                }
                System.arraycopy(bArr, i2, this.f32610g, this.f32611h, i9);
                int i11 = this.f32611h + i9;
                this.f32611h = i11;
                this.f32609f.i(this.f32610g, 0, i11);
                if (this.f32609f.b(8)) {
                    this.f32609f.k();
                    int e2 = this.f32609f.e(2);
                    this.f32609f.l(5);
                    if (this.f32609f.c()) {
                        this.f32609f.h();
                        if (this.f32609f.c()) {
                            int h2 = this.f32609f.h();
                            if (!this.f32606c) {
                                this.k = false;
                                this.n.f(h2);
                            } else if (this.f32609f.c()) {
                                int h3 = this.f32609f.h();
                                if (this.f32608e.indexOfKey(h3) < 0) {
                                    this.k = false;
                                    return;
                                }
                                j.a aVar = this.f32608e.get(h3);
                                j.b bVar = this.f32607d.get(aVar.f33581b);
                                if (bVar.f33587e) {
                                    if (!this.f32609f.b(2)) {
                                        return;
                                    }
                                    this.f32609f.l(2);
                                }
                                if (this.f32609f.b(bVar.f33589g)) {
                                    int e3 = this.f32609f.e(bVar.f33589g);
                                    if (bVar.f33588f) {
                                        z = false;
                                    } else if (!this.f32609f.b(1)) {
                                        return;
                                    } else {
                                        boolean d2 = this.f32609f.d();
                                        if (d2) {
                                            if (this.f32609f.b(1)) {
                                                z = d2;
                                                z3 = this.f32609f.d();
                                                z2 = true;
                                                z4 = this.f32612i != 5;
                                                if (z4) {
                                                    i4 = 0;
                                                } else if (!this.f32609f.c()) {
                                                    return;
                                                } else {
                                                    i4 = this.f32609f.h();
                                                }
                                                i5 = bVar.f33590h;
                                                if (i5 != 0) {
                                                    if (!this.f32609f.b(bVar.f33591i)) {
                                                        return;
                                                    }
                                                    int e4 = this.f32609f.e(bVar.f33591i);
                                                    if (aVar.f33582c && !z) {
                                                        if (this.f32609f.c()) {
                                                            i8 = this.f32609f.g();
                                                            i6 = e4;
                                                            i7 = 0;
                                                            g2 = 0;
                                                            this.n.e(bVar, e2, h2, e3, h3, z, z2, z3, z4, i4, i6, i8, i7, g2);
                                                            this.k = false;
                                                        }
                                                        return;
                                                    }
                                                    i6 = e4;
                                                } else if (i5 == 1 && !bVar.f33592j) {
                                                    if (this.f32609f.c()) {
                                                        int g3 = this.f32609f.g();
                                                        if (aVar.f33582c && !z) {
                                                            if (this.f32609f.c()) {
                                                                g2 = this.f32609f.g();
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
                                    if (this.f32612i != 5) {
                                    }
                                    if (z4) {
                                    }
                                    i5 = bVar.f33590h;
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
                if (this.f32612i == 9 || (this.f32606c && this.n.c(this.m))) {
                    if (this.o) {
                        d(i2 + ((int) (j2 - this.f32613j)));
                    }
                    this.p = this.f32613j;
                    this.q = this.l;
                    this.r = false;
                    this.o = true;
                }
                boolean z2 = this.r;
                int i3 = this.f32612i;
                if (i3 == 5 || (this.f32605b && i3 == 1 && this.n.d())) {
                    z = true;
                }
                this.r = z2 | z;
            }
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f32606c : invokeV.booleanValue;
        }

        public final void d(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
                boolean z = this.r;
                this.f32604a.c(this.q, z ? 1 : 0, (int) (this.f32613j - this.p), i2, null);
            }
        }

        public void e(j.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
                this.f32608e.append(aVar.f33580a, aVar);
            }
        }

        public void f(j.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
                this.f32607d.append(bVar.f33583a, bVar);
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
                this.f32612i = i2;
                this.l = j3;
                this.f32613j = j2;
                if (!this.f32605b || i2 != 1) {
                    if (!this.f32606c) {
                        return;
                    }
                    int i3 = this.f32612i;
                    if (i3 != 5 && i3 != 1 && i3 != 2) {
                        return;
                    }
                }
                a aVar = this.m;
                this.m = this.n;
                this.n = aVar;
                aVar.b();
                this.f32611h = 0;
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
        this.f32594a = tVar;
        this.f32595b = z;
        this.f32596c = z2;
        this.f32601h = new boolean[3];
        this.f32597d = new o(7, 128);
        this.f32598e = new o(8, 128);
        this.f32599f = new o(6, 128);
        this.n = new c.i.b.a.i0.l();
    }

    public final void a(long j2, int i2, int i3, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j3)}) == null) {
            if (!this.l || this.k.c()) {
                this.f32597d.b(i3);
                this.f32598e.b(i3);
                if (!this.l) {
                    if (this.f32597d.c() && this.f32598e.c()) {
                        ArrayList arrayList = new ArrayList();
                        o oVar = this.f32597d;
                        arrayList.add(Arrays.copyOf(oVar.f32673d, oVar.f32674e));
                        o oVar2 = this.f32598e;
                        arrayList.add(Arrays.copyOf(oVar2.f32673d, oVar2.f32674e));
                        o oVar3 = this.f32597d;
                        j.b i4 = c.i.b.a.i0.j.i(oVar3.f32673d, 3, oVar3.f32674e);
                        o oVar4 = this.f32598e;
                        j.a h2 = c.i.b.a.i0.j.h(oVar4.f32673d, 3, oVar4.f32674e);
                        this.f32603j.b(Format.createVideoSampleFormat(this.f32602i, "video/avc", null, -1, -1, i4.f33584b, i4.f33585c, -1.0f, arrayList, -1, i4.f33586d, null));
                        this.l = true;
                        this.k.f(i4);
                        this.k.e(h2);
                        this.f32597d.d();
                        this.f32598e.d();
                    }
                } else if (this.f32597d.c()) {
                    o oVar5 = this.f32597d;
                    this.k.f(c.i.b.a.i0.j.i(oVar5.f32673d, 3, oVar5.f32674e));
                    this.f32597d.d();
                } else if (this.f32598e.c()) {
                    o oVar6 = this.f32598e;
                    this.k.e(c.i.b.a.i0.j.h(oVar6.f32673d, 3, oVar6.f32674e));
                    this.f32598e.d();
                }
            }
            if (this.f32599f.b(i3)) {
                o oVar7 = this.f32599f;
                this.n.H(this.f32599f.f32673d, c.i.b.a.i0.j.k(oVar7.f32673d, oVar7.f32674e));
                this.n.J(4);
                this.f32594a.a(j3, this.n);
            }
            this.k.b(j2, i2);
        }
    }

    @Override // c.i.b.a.a0.t.h
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.i.b.a.i0.j.a(this.f32601h);
            this.f32597d.d();
            this.f32598e.d();
            this.f32599f.d();
            this.k.g();
            this.f32600g = 0L;
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
        byte[] bArr = lVar.f33597a;
        this.f32600g += lVar.a();
        this.f32603j.a(lVar, lVar.a());
        while (true) {
            int c3 = c.i.b.a.i0.j.c(bArr, c2, d2, this.f32601h);
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
            long j2 = this.f32600g - i3;
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
            this.f32602i = dVar.b();
            c.i.b.a.a0.m a2 = gVar.a(dVar.c(), 2);
            this.f32603j = a2;
            this.k = new b(a2, this.f32595b, this.f32596c);
            this.f32594a.b(gVar, dVar);
        }
    }

    public final void g(byte[] bArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048582, this, bArr, i2, i3) == null) {
            if (!this.l || this.k.c()) {
                this.f32597d.a(bArr, i2, i3);
                this.f32598e.a(bArr, i2, i3);
            }
            this.f32599f.a(bArr, i2, i3);
            this.k.a(bArr, i2, i3);
        }
    }

    public final void h(long j2, int i2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2), Long.valueOf(j3)}) == null) {
            if (!this.l || this.k.c()) {
                this.f32597d.e(i2);
                this.f32598e.e(i2);
            }
            this.f32599f.e(i2);
            this.k.h(j2, i2, j3);
        }
    }
}
