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
    public final t f32700a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f32701b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f32702c;

    /* renamed from: d  reason: collision with root package name */
    public final o f32703d;

    /* renamed from: e  reason: collision with root package name */
    public final o f32704e;

    /* renamed from: f  reason: collision with root package name */
    public final o f32705f;

    /* renamed from: g  reason: collision with root package name */
    public long f32706g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean[] f32707h;

    /* renamed from: i  reason: collision with root package name */
    public String f32708i;

    /* renamed from: j  reason: collision with root package name */
    public c.i.b.a.a0.m f32709j;
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
        public final c.i.b.a.a0.m f32710a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f32711b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f32712c;

        /* renamed from: d  reason: collision with root package name */
        public final SparseArray<j.b> f32713d;

        /* renamed from: e  reason: collision with root package name */
        public final SparseArray<j.a> f32714e;

        /* renamed from: f  reason: collision with root package name */
        public final c.i.b.a.i0.m f32715f;

        /* renamed from: g  reason: collision with root package name */
        public byte[] f32716g;

        /* renamed from: h  reason: collision with root package name */
        public int f32717h;

        /* renamed from: i  reason: collision with root package name */
        public int f32718i;

        /* renamed from: j  reason: collision with root package name */
        public long f32719j;
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
            public boolean f32720a;

            /* renamed from: b  reason: collision with root package name */
            public boolean f32721b;

            /* renamed from: c  reason: collision with root package name */
            public j.b f32722c;

            /* renamed from: d  reason: collision with root package name */
            public int f32723d;

            /* renamed from: e  reason: collision with root package name */
            public int f32724e;

            /* renamed from: f  reason: collision with root package name */
            public int f32725f;

            /* renamed from: g  reason: collision with root package name */
            public int f32726g;

            /* renamed from: h  reason: collision with root package name */
            public boolean f32727h;

            /* renamed from: i  reason: collision with root package name */
            public boolean f32728i;

            /* renamed from: j  reason: collision with root package name */
            public boolean f32729j;
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
                    this.f32721b = false;
                    this.f32720a = false;
                }
            }

            public final boolean c(a aVar) {
                InterceptResult invokeL;
                boolean z;
                boolean z2;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) {
                    if (this.f32720a) {
                        if (!aVar.f32720a || this.f32725f != aVar.f32725f || this.f32726g != aVar.f32726g || this.f32727h != aVar.f32727h) {
                            return true;
                        }
                        if (this.f32728i && aVar.f32728i && this.f32729j != aVar.f32729j) {
                            return true;
                        }
                        int i2 = this.f32723d;
                        int i3 = aVar.f32723d;
                        if (i2 != i3 && (i2 == 0 || i3 == 0)) {
                            return true;
                        }
                        if (this.f32722c.f33696h == 0 && aVar.f32722c.f33696h == 0 && (this.m != aVar.m || this.n != aVar.n)) {
                            return true;
                        }
                        if ((this.f32722c.f33696h == 1 && aVar.f32722c.f33696h == 1 && (this.o != aVar.o || this.p != aVar.p)) || (z = this.k) != (z2 = aVar.k)) {
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
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f32721b && ((i2 = this.f32724e) == 7 || i2 == 2) : invokeV.booleanValue;
            }

            public void e(j.b bVar, int i2, int i3, int i4, int i5, boolean z, boolean z2, boolean z3, boolean z4, int i6, int i7, int i8, int i9, int i10) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{bVar, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10)}) == null) {
                    this.f32722c = bVar;
                    this.f32723d = i2;
                    this.f32724e = i3;
                    this.f32725f = i4;
                    this.f32726g = i5;
                    this.f32727h = z;
                    this.f32728i = z2;
                    this.f32729j = z3;
                    this.k = z4;
                    this.l = i6;
                    this.m = i7;
                    this.n = i8;
                    this.o = i9;
                    this.p = i10;
                    this.f32720a = true;
                    this.f32721b = true;
                }
            }

            public void f(int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
                    this.f32724e = i2;
                    this.f32721b = true;
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
            this.f32710a = mVar;
            this.f32711b = z;
            this.f32712c = z2;
            this.f32713d = new SparseArray<>();
            this.f32714e = new SparseArray<>();
            this.m = new a(null);
            this.n = new a(null);
            byte[] bArr = new byte[128];
            this.f32716g = bArr;
            this.f32715f = new c.i.b.a.i0.m(bArr, 0, 0);
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
                byte[] bArr2 = this.f32716g;
                int length = bArr2.length;
                int i10 = this.f32717h;
                if (length < i10 + i9) {
                    this.f32716g = Arrays.copyOf(bArr2, (i10 + i9) * 2);
                }
                System.arraycopy(bArr, i2, this.f32716g, this.f32717h, i9);
                int i11 = this.f32717h + i9;
                this.f32717h = i11;
                this.f32715f.i(this.f32716g, 0, i11);
                if (this.f32715f.b(8)) {
                    this.f32715f.k();
                    int e2 = this.f32715f.e(2);
                    this.f32715f.l(5);
                    if (this.f32715f.c()) {
                        this.f32715f.h();
                        if (this.f32715f.c()) {
                            int h2 = this.f32715f.h();
                            if (!this.f32712c) {
                                this.k = false;
                                this.n.f(h2);
                            } else if (this.f32715f.c()) {
                                int h3 = this.f32715f.h();
                                if (this.f32714e.indexOfKey(h3) < 0) {
                                    this.k = false;
                                    return;
                                }
                                j.a aVar = this.f32714e.get(h3);
                                j.b bVar = this.f32713d.get(aVar.f33687b);
                                if (bVar.f33693e) {
                                    if (!this.f32715f.b(2)) {
                                        return;
                                    }
                                    this.f32715f.l(2);
                                }
                                if (this.f32715f.b(bVar.f33695g)) {
                                    int e3 = this.f32715f.e(bVar.f33695g);
                                    if (bVar.f33694f) {
                                        z = false;
                                    } else if (!this.f32715f.b(1)) {
                                        return;
                                    } else {
                                        boolean d2 = this.f32715f.d();
                                        if (d2) {
                                            if (this.f32715f.b(1)) {
                                                z = d2;
                                                z3 = this.f32715f.d();
                                                z2 = true;
                                                z4 = this.f32718i != 5;
                                                if (z4) {
                                                    i4 = 0;
                                                } else if (!this.f32715f.c()) {
                                                    return;
                                                } else {
                                                    i4 = this.f32715f.h();
                                                }
                                                i5 = bVar.f33696h;
                                                if (i5 != 0) {
                                                    if (!this.f32715f.b(bVar.f33697i)) {
                                                        return;
                                                    }
                                                    int e4 = this.f32715f.e(bVar.f33697i);
                                                    if (aVar.f33688c && !z) {
                                                        if (this.f32715f.c()) {
                                                            i8 = this.f32715f.g();
                                                            i6 = e4;
                                                            i7 = 0;
                                                            g2 = 0;
                                                            this.n.e(bVar, e2, h2, e3, h3, z, z2, z3, z4, i4, i6, i8, i7, g2);
                                                            this.k = false;
                                                        }
                                                        return;
                                                    }
                                                    i6 = e4;
                                                } else if (i5 == 1 && !bVar.f33698j) {
                                                    if (this.f32715f.c()) {
                                                        int g3 = this.f32715f.g();
                                                        if (aVar.f33688c && !z) {
                                                            if (this.f32715f.c()) {
                                                                g2 = this.f32715f.g();
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
                                    if (this.f32718i != 5) {
                                    }
                                    if (z4) {
                                    }
                                    i5 = bVar.f33696h;
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
                if (this.f32718i == 9 || (this.f32712c && this.n.c(this.m))) {
                    if (this.o) {
                        d(i2 + ((int) (j2 - this.f32719j)));
                    }
                    this.p = this.f32719j;
                    this.q = this.l;
                    this.r = false;
                    this.o = true;
                }
                boolean z2 = this.r;
                int i3 = this.f32718i;
                if (i3 == 5 || (this.f32711b && i3 == 1 && this.n.d())) {
                    z = true;
                }
                this.r = z2 | z;
            }
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f32712c : invokeV.booleanValue;
        }

        public final void d(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
                boolean z = this.r;
                this.f32710a.c(this.q, z ? 1 : 0, (int) (this.f32719j - this.p), i2, null);
            }
        }

        public void e(j.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
                this.f32714e.append(aVar.f33686a, aVar);
            }
        }

        public void f(j.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
                this.f32713d.append(bVar.f33689a, bVar);
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
                this.f32718i = i2;
                this.l = j3;
                this.f32719j = j2;
                if (!this.f32711b || i2 != 1) {
                    if (!this.f32712c) {
                        return;
                    }
                    int i3 = this.f32718i;
                    if (i3 != 5 && i3 != 1 && i3 != 2) {
                        return;
                    }
                }
                a aVar = this.m;
                this.m = this.n;
                this.n = aVar;
                aVar.b();
                this.f32717h = 0;
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
        this.f32700a = tVar;
        this.f32701b = z;
        this.f32702c = z2;
        this.f32707h = new boolean[3];
        this.f32703d = new o(7, 128);
        this.f32704e = new o(8, 128);
        this.f32705f = new o(6, 128);
        this.n = new c.i.b.a.i0.l();
    }

    public final void a(long j2, int i2, int i3, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j3)}) == null) {
            if (!this.l || this.k.c()) {
                this.f32703d.b(i3);
                this.f32704e.b(i3);
                if (!this.l) {
                    if (this.f32703d.c() && this.f32704e.c()) {
                        ArrayList arrayList = new ArrayList();
                        o oVar = this.f32703d;
                        arrayList.add(Arrays.copyOf(oVar.f32779d, oVar.f32780e));
                        o oVar2 = this.f32704e;
                        arrayList.add(Arrays.copyOf(oVar2.f32779d, oVar2.f32780e));
                        o oVar3 = this.f32703d;
                        j.b i4 = c.i.b.a.i0.j.i(oVar3.f32779d, 3, oVar3.f32780e);
                        o oVar4 = this.f32704e;
                        j.a h2 = c.i.b.a.i0.j.h(oVar4.f32779d, 3, oVar4.f32780e);
                        this.f32709j.b(Format.createVideoSampleFormat(this.f32708i, "video/avc", null, -1, -1, i4.f33690b, i4.f33691c, -1.0f, arrayList, -1, i4.f33692d, null));
                        this.l = true;
                        this.k.f(i4);
                        this.k.e(h2);
                        this.f32703d.d();
                        this.f32704e.d();
                    }
                } else if (this.f32703d.c()) {
                    o oVar5 = this.f32703d;
                    this.k.f(c.i.b.a.i0.j.i(oVar5.f32779d, 3, oVar5.f32780e));
                    this.f32703d.d();
                } else if (this.f32704e.c()) {
                    o oVar6 = this.f32704e;
                    this.k.e(c.i.b.a.i0.j.h(oVar6.f32779d, 3, oVar6.f32780e));
                    this.f32704e.d();
                }
            }
            if (this.f32705f.b(i3)) {
                o oVar7 = this.f32705f;
                this.n.H(this.f32705f.f32779d, c.i.b.a.i0.j.k(oVar7.f32779d, oVar7.f32780e));
                this.n.J(4);
                this.f32700a.a(j3, this.n);
            }
            this.k.b(j2, i2);
        }
    }

    @Override // c.i.b.a.a0.t.h
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.i.b.a.i0.j.a(this.f32707h);
            this.f32703d.d();
            this.f32704e.d();
            this.f32705f.d();
            this.k.g();
            this.f32706g = 0L;
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
        byte[] bArr = lVar.f33703a;
        this.f32706g += lVar.a();
        this.f32709j.a(lVar, lVar.a());
        while (true) {
            int c3 = c.i.b.a.i0.j.c(bArr, c2, d2, this.f32707h);
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
            long j2 = this.f32706g - i3;
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
            this.f32708i = dVar.b();
            c.i.b.a.a0.m a2 = gVar.a(dVar.c(), 2);
            this.f32709j = a2;
            this.k = new b(a2, this.f32701b, this.f32702c);
            this.f32700a.b(gVar, dVar);
        }
    }

    public final void g(byte[] bArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048582, this, bArr, i2, i3) == null) {
            if (!this.l || this.k.c()) {
                this.f32703d.a(bArr, i2, i3);
                this.f32704e.a(bArr, i2, i3);
            }
            this.f32705f.a(bArr, i2, i3);
            this.k.a(bArr, i2, i3);
        }
    }

    public final void h(long j2, int i2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2), Long.valueOf(j3)}) == null) {
            if (!this.l || this.k.c()) {
                this.f32703d.e(i2);
                this.f32704e.e(i2);
            }
            this.f32705f.e(i2);
            this.k.h(j2, i2, j3);
        }
    }
}
