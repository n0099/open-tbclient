package c.i.b.a.a0.t;

import c.i.b.a.a0.t.w;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import java.util.Collections;
import kotlin.jvm.internal.ByteCompanionObject;
/* loaded from: classes4.dex */
public final class k implements h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final t f32866a;

    /* renamed from: b  reason: collision with root package name */
    public String f32867b;

    /* renamed from: c  reason: collision with root package name */
    public c.i.b.a.a0.m f32868c;

    /* renamed from: d  reason: collision with root package name */
    public a f32869d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f32870e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean[] f32871f;

    /* renamed from: g  reason: collision with root package name */
    public final o f32872g;

    /* renamed from: h  reason: collision with root package name */
    public final o f32873h;

    /* renamed from: i  reason: collision with root package name */
    public final o f32874i;

    /* renamed from: j  reason: collision with root package name */
    public final o f32875j;
    public final o k;
    public long l;
    public long m;
    public final c.i.b.a.i0.l n;

    /* loaded from: classes4.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final c.i.b.a.a0.m f32876a;

        /* renamed from: b  reason: collision with root package name */
        public long f32877b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f32878c;

        /* renamed from: d  reason: collision with root package name */
        public int f32879d;

        /* renamed from: e  reason: collision with root package name */
        public long f32880e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f32881f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f32882g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f32883h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f32884i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f32885j;
        public long k;
        public long l;
        public boolean m;

        public a(c.i.b.a.a0.m mVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f32876a = mVar;
        }

        public void a(long j2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
                if (this.f32885j && this.f32882g) {
                    this.m = this.f32878c;
                    this.f32885j = false;
                } else if (this.f32883h || this.f32882g) {
                    if (this.f32884i) {
                        b(i2 + ((int) (j2 - this.f32877b)));
                    }
                    this.k = this.f32877b;
                    this.l = this.f32880e;
                    this.f32884i = true;
                    this.m = this.f32878c;
                }
            }
        }

        public final void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                boolean z = this.m;
                this.f32876a.c(this.l, z ? 1 : 0, (int) (this.f32877b - this.k), i2, null);
            }
        }

        public void c(byte[] bArr, int i2, int i3) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, bArr, i2, i3) == null) && this.f32881f) {
                int i4 = this.f32879d;
                int i5 = (i2 + 2) - i4;
                if (i5 < i3) {
                    this.f32882g = (bArr[i5] & ByteCompanionObject.MIN_VALUE) != 0;
                    this.f32881f = false;
                    return;
                }
                this.f32879d = i4 + (i3 - i2);
            }
        }

        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.f32881f = false;
                this.f32882g = false;
                this.f32883h = false;
                this.f32884i = false;
                this.f32885j = false;
            }
        }

        public void e(long j2, int i2, int i3, long j3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j3)}) == null) {
                boolean z = false;
                this.f32882g = false;
                this.f32883h = false;
                this.f32880e = j3;
                this.f32879d = 0;
                this.f32877b = j2;
                if (i3 >= 32) {
                    if (!this.f32885j && this.f32884i) {
                        b(i2);
                        this.f32884i = false;
                    }
                    if (i3 <= 34) {
                        this.f32883h = !this.f32885j;
                        this.f32885j = true;
                    }
                }
                boolean z2 = i3 >= 16 && i3 <= 21;
                this.f32878c = z2;
                this.f32881f = (z2 || i3 <= 9) ? true : true;
            }
        }
    }

    public k(t tVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f32866a = tVar;
        this.f32871f = new boolean[3];
        this.f32872g = new o(32, 128);
        this.f32873h = new o(33, 128);
        this.f32874i = new o(34, 128);
        this.f32875j = new o(39, 128);
        this.k = new o(40, 128);
        this.n = new c.i.b.a.i0.l();
    }

    public static Format h(String str, o oVar, o oVar2, o oVar3) {
        InterceptResult invokeLLLL;
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65537, null, str, oVar, oVar2, oVar3)) == null) {
            int i2 = oVar.f32916e;
            byte[] bArr = new byte[oVar2.f32916e + i2 + oVar3.f32916e];
            System.arraycopy(oVar.f32915d, 0, bArr, 0, i2);
            System.arraycopy(oVar2.f32915d, 0, bArr, oVar.f32916e, oVar2.f32916e);
            System.arraycopy(oVar3.f32915d, 0, bArr, oVar.f32916e + oVar2.f32916e, oVar3.f32916e);
            c.i.b.a.i0.m mVar = new c.i.b.a.i0.m(oVar2.f32915d, 0, oVar2.f32916e);
            mVar.l(44);
            int e2 = mVar.e(3);
            mVar.k();
            mVar.l(88);
            mVar.l(8);
            int i3 = 0;
            for (int i4 = 0; i4 < e2; i4++) {
                if (mVar.d()) {
                    i3 += 89;
                }
                if (mVar.d()) {
                    i3 += 8;
                }
            }
            mVar.l(i3);
            if (e2 > 0) {
                mVar.l((8 - e2) * 2);
            }
            mVar.h();
            int h2 = mVar.h();
            if (h2 == 3) {
                mVar.k();
            }
            int h3 = mVar.h();
            int h4 = mVar.h();
            if (mVar.d()) {
                int h5 = mVar.h();
                int h6 = mVar.h();
                int h7 = mVar.h();
                int h8 = mVar.h();
                h3 -= ((h2 == 1 || h2 == 2) ? 2 : 1) * (h5 + h6);
                h4 -= (h2 == 1 ? 2 : 1) * (h7 + h8);
            }
            int i5 = h3;
            int i6 = h4;
            mVar.h();
            mVar.h();
            int h9 = mVar.h();
            for (int i7 = mVar.d() ? 0 : e2; i7 <= e2; i7++) {
                mVar.h();
                mVar.h();
                mVar.h();
            }
            mVar.h();
            mVar.h();
            mVar.h();
            mVar.h();
            mVar.h();
            mVar.h();
            if (mVar.d() && mVar.d()) {
                i(mVar);
            }
            mVar.l(2);
            if (mVar.d()) {
                mVar.l(8);
                mVar.h();
                mVar.h();
                mVar.k();
            }
            j(mVar);
            if (mVar.d()) {
                for (int i8 = 0; i8 < mVar.h(); i8++) {
                    mVar.l(h9 + 4 + 1);
                }
            }
            mVar.l(2);
            float f3 = 1.0f;
            if (mVar.d() && mVar.d()) {
                int e3 = mVar.e(8);
                if (e3 == 255) {
                    int e4 = mVar.e(16);
                    int e5 = mVar.e(16);
                    if (e4 != 0 && e5 != 0) {
                        f3 = e4 / e5;
                    }
                    f2 = f3;
                } else {
                    float[] fArr = c.i.b.a.i0.j.f33819b;
                    if (e3 < fArr.length) {
                        f2 = fArr[e3];
                    } else {
                        String str2 = "Unexpected aspect_ratio_idc value: " + e3;
                    }
                }
                return Format.createVideoSampleFormat(str, "video/hevc", null, -1, -1, i5, i6, -1.0f, Collections.singletonList(bArr), -1, f2, null);
            }
            f2 = 1.0f;
            return Format.createVideoSampleFormat(str, "video/hevc", null, -1, -1, i5, i6, -1.0f, Collections.singletonList(bArr), -1, f2, null);
        }
        return (Format) invokeLLLL.objValue;
    }

    public static void i(c.i.b.a.i0.m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, mVar) == null) {
            for (int i2 = 0; i2 < 4; i2++) {
                int i3 = 0;
                while (i3 < 6) {
                    int i4 = 1;
                    if (!mVar.d()) {
                        mVar.h();
                    } else {
                        int min = Math.min(64, 1 << ((i2 << 1) + 4));
                        if (i2 > 1) {
                            mVar.g();
                        }
                        for (int i5 = 0; i5 < min; i5++) {
                            mVar.g();
                        }
                    }
                    if (i2 == 3) {
                        i4 = 3;
                    }
                    i3 += i4;
                }
            }
        }
    }

    public static void j(c.i.b.a.i0.m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, mVar) == null) {
            int h2 = mVar.h();
            boolean z = false;
            int i2 = 0;
            for (int i3 = 0; i3 < h2; i3++) {
                if (i3 != 0) {
                    z = mVar.d();
                }
                if (z) {
                    mVar.k();
                    mVar.h();
                    for (int i4 = 0; i4 <= i2; i4++) {
                        if (mVar.d()) {
                            mVar.k();
                        }
                    }
                } else {
                    int h3 = mVar.h();
                    int h4 = mVar.h();
                    int i5 = h3 + h4;
                    for (int i6 = 0; i6 < h3; i6++) {
                        mVar.h();
                        mVar.k();
                    }
                    for (int i7 = 0; i7 < h4; i7++) {
                        mVar.h();
                        mVar.k();
                    }
                    i2 = i5;
                }
            }
        }
    }

    public final void a(long j2, int i2, int i3, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j3)}) == null) {
            if (this.f32870e) {
                this.f32869d.a(j2, i2);
            } else {
                this.f32872g.b(i3);
                this.f32873h.b(i3);
                this.f32874i.b(i3);
                if (this.f32872g.c() && this.f32873h.c() && this.f32874i.c()) {
                    this.f32868c.b(h(this.f32867b, this.f32872g, this.f32873h, this.f32874i));
                    this.f32870e = true;
                }
            }
            if (this.f32875j.b(i3)) {
                o oVar = this.f32875j;
                this.n.H(this.f32875j.f32915d, c.i.b.a.i0.j.k(oVar.f32915d, oVar.f32916e));
                this.n.K(5);
                this.f32866a.a(j3, this.n);
            }
            if (this.k.b(i3)) {
                o oVar2 = this.k;
                this.n.H(this.k.f32915d, c.i.b.a.i0.j.k(oVar2.f32915d, oVar2.f32916e));
                this.n.K(5);
                this.f32866a.a(j3, this.n);
            }
        }
    }

    @Override // c.i.b.a.a0.t.h
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.i.b.a.i0.j.a(this.f32871f);
            this.f32872g.d();
            this.f32873h.d();
            this.f32874i.d();
            this.f32875j.d();
            this.k.d();
            this.f32869d.d();
            this.l = 0L;
        }
    }

    @Override // c.i.b.a.a0.t.h
    public void c(c.i.b.a.i0.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lVar) == null) {
            while (lVar.a() > 0) {
                int c2 = lVar.c();
                int d2 = lVar.d();
                byte[] bArr = lVar.f33839a;
                this.l += lVar.a();
                this.f32868c.a(lVar, lVar.a());
                while (c2 < d2) {
                    int c3 = c.i.b.a.i0.j.c(bArr, c2, d2, this.f32871f);
                    if (c3 == d2) {
                        g(bArr, c2, d2);
                        return;
                    }
                    int e2 = c.i.b.a.i0.j.e(bArr, c3);
                    int i2 = c3 - c2;
                    if (i2 > 0) {
                        g(bArr, c2, c3);
                    }
                    int i3 = d2 - c3;
                    long j2 = this.l - i3;
                    a(j2, i3, i2 < 0 ? -i2 : 0, this.m);
                    k(j2, i3, e2, this.m);
                    c2 = c3 + 3;
                }
            }
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
            this.f32867b = dVar.b();
            c.i.b.a.a0.m a2 = gVar.a(dVar.c(), 2);
            this.f32868c = a2;
            this.f32869d = new a(a2);
            this.f32866a.b(gVar, dVar);
        }
    }

    public final void g(byte[] bArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048582, this, bArr, i2, i3) == null) {
            if (this.f32870e) {
                this.f32869d.c(bArr, i2, i3);
            } else {
                this.f32872g.a(bArr, i2, i3);
                this.f32873h.a(bArr, i2, i3);
                this.f32874i.a(bArr, i2, i3);
            }
            this.f32875j.a(bArr, i2, i3);
            this.k.a(bArr, i2, i3);
        }
    }

    public final void k(long j2, int i2, int i3, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j3)}) == null) {
            if (this.f32870e) {
                this.f32869d.e(j2, i2, i3, j3);
            } else {
                this.f32872g.e(i3);
                this.f32873h.e(i3);
                this.f32874i.e(i3);
            }
            this.f32875j.e(i3);
            this.k.e(i3);
        }
    }
}
