package b.h.b.a.a0.t;

import android.util.SparseArray;
import b.h.b.a.a0.t.w;
import b.h.b.a.i0.j;
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
    public final t f32556a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f32557b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f32558c;

    /* renamed from: d  reason: collision with root package name */
    public final o f32559d;

    /* renamed from: e  reason: collision with root package name */
    public final o f32560e;

    /* renamed from: f  reason: collision with root package name */
    public final o f32561f;

    /* renamed from: g  reason: collision with root package name */
    public long f32562g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean[] f32563h;

    /* renamed from: i  reason: collision with root package name */
    public String f32564i;
    public b.h.b.a.a0.m j;
    public b k;
    public boolean l;
    public long m;
    public final b.h.b.a.i0.l n;

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
        public final b.h.b.a.a0.m f32565a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f32566b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f32567c;

        /* renamed from: d  reason: collision with root package name */
        public final SparseArray<j.b> f32568d;

        /* renamed from: e  reason: collision with root package name */
        public final SparseArray<j.a> f32569e;

        /* renamed from: f  reason: collision with root package name */
        public final b.h.b.a.i0.m f32570f;

        /* renamed from: g  reason: collision with root package name */
        public byte[] f32571g;

        /* renamed from: h  reason: collision with root package name */
        public int f32572h;

        /* renamed from: i  reason: collision with root package name */
        public int f32573i;
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
            public boolean f32574a;

            /* renamed from: b  reason: collision with root package name */
            public boolean f32575b;

            /* renamed from: c  reason: collision with root package name */
            public j.b f32576c;

            /* renamed from: d  reason: collision with root package name */
            public int f32577d;

            /* renamed from: e  reason: collision with root package name */
            public int f32578e;

            /* renamed from: f  reason: collision with root package name */
            public int f32579f;

            /* renamed from: g  reason: collision with root package name */
            public int f32580g;

            /* renamed from: h  reason: collision with root package name */
            public boolean f32581h;

            /* renamed from: i  reason: collision with root package name */
            public boolean f32582i;
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
                    this.f32575b = false;
                    this.f32574a = false;
                }
            }

            public final boolean c(a aVar) {
                InterceptResult invokeL;
                boolean z;
                boolean z2;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) {
                    if (this.f32574a) {
                        if (!aVar.f32574a || this.f32579f != aVar.f32579f || this.f32580g != aVar.f32580g || this.f32581h != aVar.f32581h) {
                            return true;
                        }
                        if (this.f32582i && aVar.f32582i && this.j != aVar.j) {
                            return true;
                        }
                        int i2 = this.f32577d;
                        int i3 = aVar.f32577d;
                        if (i2 != i3 && (i2 == 0 || i3 == 0)) {
                            return true;
                        }
                        if (this.f32576c.f33487h == 0 && aVar.f32576c.f33487h == 0 && (this.m != aVar.m || this.n != aVar.n)) {
                            return true;
                        }
                        if ((this.f32576c.f33487h == 1 && aVar.f32576c.f33487h == 1 && (this.o != aVar.o || this.p != aVar.p)) || (z = this.k) != (z2 = aVar.k)) {
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
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f32575b && ((i2 = this.f32578e) == 7 || i2 == 2) : invokeV.booleanValue;
            }

            public void e(j.b bVar, int i2, int i3, int i4, int i5, boolean z, boolean z2, boolean z3, boolean z4, int i6, int i7, int i8, int i9, int i10) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{bVar, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10)}) == null) {
                    this.f32576c = bVar;
                    this.f32577d = i2;
                    this.f32578e = i3;
                    this.f32579f = i4;
                    this.f32580g = i5;
                    this.f32581h = z;
                    this.f32582i = z2;
                    this.j = z3;
                    this.k = z4;
                    this.l = i6;
                    this.m = i7;
                    this.n = i8;
                    this.o = i9;
                    this.p = i10;
                    this.f32574a = true;
                    this.f32575b = true;
                }
            }

            public void f(int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
                    this.f32578e = i2;
                    this.f32575b = true;
                }
            }

            public /* synthetic */ a(a aVar) {
                this();
            }
        }

        public b(b.h.b.a.a0.m mVar, boolean z, boolean z2) {
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
            this.f32565a = mVar;
            this.f32566b = z;
            this.f32567c = z2;
            this.f32568d = new SparseArray<>();
            this.f32569e = new SparseArray<>();
            this.m = new a(null);
            this.n = new a(null);
            byte[] bArr = new byte[128];
            this.f32571g = bArr;
            this.f32570f = new b.h.b.a.i0.m(bArr, 0, 0);
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
                byte[] bArr2 = this.f32571g;
                int length = bArr2.length;
                int i10 = this.f32572h;
                if (length < i10 + i9) {
                    this.f32571g = Arrays.copyOf(bArr2, (i10 + i9) * 2);
                }
                System.arraycopy(bArr, i2, this.f32571g, this.f32572h, i9);
                int i11 = this.f32572h + i9;
                this.f32572h = i11;
                this.f32570f.i(this.f32571g, 0, i11);
                if (this.f32570f.b(8)) {
                    this.f32570f.k();
                    int e2 = this.f32570f.e(2);
                    this.f32570f.l(5);
                    if (this.f32570f.c()) {
                        this.f32570f.h();
                        if (this.f32570f.c()) {
                            int h2 = this.f32570f.h();
                            if (!this.f32567c) {
                                this.k = false;
                                this.n.f(h2);
                            } else if (this.f32570f.c()) {
                                int h3 = this.f32570f.h();
                                if (this.f32569e.indexOfKey(h3) < 0) {
                                    this.k = false;
                                    return;
                                }
                                j.a aVar = this.f32569e.get(h3);
                                j.b bVar = this.f32568d.get(aVar.f33478b);
                                if (bVar.f33484e) {
                                    if (!this.f32570f.b(2)) {
                                        return;
                                    }
                                    this.f32570f.l(2);
                                }
                                if (this.f32570f.b(bVar.f33486g)) {
                                    int e3 = this.f32570f.e(bVar.f33486g);
                                    if (bVar.f33485f) {
                                        z = false;
                                    } else if (!this.f32570f.b(1)) {
                                        return;
                                    } else {
                                        boolean d2 = this.f32570f.d();
                                        if (d2) {
                                            if (this.f32570f.b(1)) {
                                                z = d2;
                                                z3 = this.f32570f.d();
                                                z2 = true;
                                                z4 = this.f32573i != 5;
                                                if (z4) {
                                                    i4 = 0;
                                                } else if (!this.f32570f.c()) {
                                                    return;
                                                } else {
                                                    i4 = this.f32570f.h();
                                                }
                                                i5 = bVar.f33487h;
                                                if (i5 != 0) {
                                                    if (!this.f32570f.b(bVar.f33488i)) {
                                                        return;
                                                    }
                                                    int e4 = this.f32570f.e(bVar.f33488i);
                                                    if (aVar.f33479c && !z) {
                                                        if (this.f32570f.c()) {
                                                            i8 = this.f32570f.g();
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
                                                    if (this.f32570f.c()) {
                                                        int g3 = this.f32570f.g();
                                                        if (aVar.f33479c && !z) {
                                                            if (this.f32570f.c()) {
                                                                g2 = this.f32570f.g();
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
                                    if (this.f32573i != 5) {
                                    }
                                    if (z4) {
                                    }
                                    i5 = bVar.f33487h;
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
                if (this.f32573i == 9 || (this.f32567c && this.n.c(this.m))) {
                    if (this.o) {
                        d(i2 + ((int) (j - this.j)));
                    }
                    this.p = this.j;
                    this.q = this.l;
                    this.r = false;
                    this.o = true;
                }
                boolean z2 = this.r;
                int i3 = this.f32573i;
                if (i3 == 5 || (this.f32566b && i3 == 1 && this.n.d())) {
                    z = true;
                }
                this.r = z2 | z;
            }
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f32567c : invokeV.booleanValue;
        }

        public final void d(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
                boolean z = this.r;
                this.f32565a.c(this.q, z ? 1 : 0, (int) (this.j - this.p), i2, null);
            }
        }

        public void e(j.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
                this.f32569e.append(aVar.f33477a, aVar);
            }
        }

        public void f(j.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
                this.f32568d.append(bVar.f33480a, bVar);
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
                this.f32573i = i2;
                this.l = j2;
                this.j = j;
                if (!this.f32566b || i2 != 1) {
                    if (!this.f32567c) {
                        return;
                    }
                    int i3 = this.f32573i;
                    if (i3 != 5 && i3 != 1 && i3 != 2) {
                        return;
                    }
                }
                a aVar = this.m;
                this.m = this.n;
                this.n = aVar;
                aVar.b();
                this.f32572h = 0;
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
        this.f32556a = tVar;
        this.f32557b = z;
        this.f32558c = z2;
        this.f32563h = new boolean[3];
        this.f32559d = new o(7, 128);
        this.f32560e = new o(8, 128);
        this.f32561f = new o(6, 128);
        this.n = new b.h.b.a.i0.l();
    }

    public final void a(long j, int i2, int i3, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2)}) == null) {
            if (!this.l || this.k.c()) {
                this.f32559d.b(i3);
                this.f32560e.b(i3);
                if (!this.l) {
                    if (this.f32559d.c() && this.f32560e.c()) {
                        ArrayList arrayList = new ArrayList();
                        o oVar = this.f32559d;
                        arrayList.add(Arrays.copyOf(oVar.f32628d, oVar.f32629e));
                        o oVar2 = this.f32560e;
                        arrayList.add(Arrays.copyOf(oVar2.f32628d, oVar2.f32629e));
                        o oVar3 = this.f32559d;
                        j.b i4 = b.h.b.a.i0.j.i(oVar3.f32628d, 3, oVar3.f32629e);
                        o oVar4 = this.f32560e;
                        j.a h2 = b.h.b.a.i0.j.h(oVar4.f32628d, 3, oVar4.f32629e);
                        this.j.b(Format.createVideoSampleFormat(this.f32564i, "video/avc", null, -1, -1, i4.f33481b, i4.f33482c, -1.0f, arrayList, -1, i4.f33483d, null));
                        this.l = true;
                        this.k.f(i4);
                        this.k.e(h2);
                        this.f32559d.d();
                        this.f32560e.d();
                    }
                } else if (this.f32559d.c()) {
                    o oVar5 = this.f32559d;
                    this.k.f(b.h.b.a.i0.j.i(oVar5.f32628d, 3, oVar5.f32629e));
                    this.f32559d.d();
                } else if (this.f32560e.c()) {
                    o oVar6 = this.f32560e;
                    this.k.e(b.h.b.a.i0.j.h(oVar6.f32628d, 3, oVar6.f32629e));
                    this.f32560e.d();
                }
            }
            if (this.f32561f.b(i3)) {
                o oVar7 = this.f32561f;
                this.n.H(this.f32561f.f32628d, b.h.b.a.i0.j.k(oVar7.f32628d, oVar7.f32629e));
                this.n.J(4);
                this.f32556a.a(j2, this.n);
            }
            this.k.b(j, i2);
        }
    }

    @Override // b.h.b.a.a0.t.h
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            b.h.b.a.i0.j.a(this.f32563h);
            this.f32559d.d();
            this.f32560e.d();
            this.f32561f.d();
            this.k.g();
            this.f32562g = 0L;
        }
    }

    @Override // b.h.b.a.a0.t.h
    public void c(b.h.b.a.i0.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lVar) != null) {
            return;
        }
        int c2 = lVar.c();
        int d2 = lVar.d();
        byte[] bArr = lVar.f33493a;
        this.f32562g += lVar.a();
        this.j.a(lVar, lVar.a());
        while (true) {
            int c3 = b.h.b.a.i0.j.c(bArr, c2, d2, this.f32563h);
            if (c3 == d2) {
                g(bArr, c2, d2);
                return;
            }
            int f2 = b.h.b.a.i0.j.f(bArr, c3);
            int i2 = c3 - c2;
            if (i2 > 0) {
                g(bArr, c2, c3);
            }
            int i3 = d2 - c3;
            long j = this.f32562g - i3;
            a(j, i3, i2 < 0 ? -i2 : 0, this.m);
            h(j, f2, this.m);
            c2 = c3 + 3;
        }
    }

    @Override // b.h.b.a.a0.t.h
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    @Override // b.h.b.a.a0.t.h
    public void e(long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            this.m = j;
        }
    }

    @Override // b.h.b.a.a0.t.h
    public void f(b.h.b.a.a0.g gVar, w.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, gVar, dVar) == null) {
            dVar.a();
            this.f32564i = dVar.b();
            b.h.b.a.a0.m a2 = gVar.a(dVar.c(), 2);
            this.j = a2;
            this.k = new b(a2, this.f32557b, this.f32558c);
            this.f32556a.b(gVar, dVar);
        }
    }

    public final void g(byte[] bArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048582, this, bArr, i2, i3) == null) {
            if (!this.l || this.k.c()) {
                this.f32559d.a(bArr, i2, i3);
                this.f32560e.a(bArr, i2, i3);
            }
            this.f32561f.a(bArr, i2, i3);
            this.k.a(bArr, i2, i3);
        }
    }

    public final void h(long j, int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Long.valueOf(j), Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            if (!this.l || this.k.c()) {
                this.f32559d.e(i2);
                this.f32560e.e(i2);
            }
            this.f32561f.e(i2);
            this.k.h(j, i2, j2);
        }
    }
}
