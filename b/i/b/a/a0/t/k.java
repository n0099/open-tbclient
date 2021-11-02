package b.i.b.a.a0.t;

import b.i.b.a.a0.t.w;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import java.util.Collections;
import kotlin.jvm.internal.ByteCompanionObject;
/* loaded from: classes6.dex */
public final class k implements h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final t f31725a;

    /* renamed from: b  reason: collision with root package name */
    public String f31726b;

    /* renamed from: c  reason: collision with root package name */
    public b.i.b.a.a0.m f31727c;

    /* renamed from: d  reason: collision with root package name */
    public a f31728d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f31729e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean[] f31730f;

    /* renamed from: g  reason: collision with root package name */
    public final o f31731g;

    /* renamed from: h  reason: collision with root package name */
    public final o f31732h;

    /* renamed from: i  reason: collision with root package name */
    public final o f31733i;
    public final o j;
    public final o k;
    public long l;
    public long m;
    public final b.i.b.a.i0.l n;

    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final b.i.b.a.a0.m f31734a;

        /* renamed from: b  reason: collision with root package name */
        public long f31735b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f31736c;

        /* renamed from: d  reason: collision with root package name */
        public int f31737d;

        /* renamed from: e  reason: collision with root package name */
        public long f31738e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f31739f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f31740g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f31741h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f31742i;
        public boolean j;
        public long k;
        public long l;
        public boolean m;

        public a(b.i.b.a.a0.m mVar) {
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
            this.f31734a = mVar;
        }

        public void a(long j, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Integer.valueOf(i2)}) == null) {
                if (this.j && this.f31740g) {
                    this.m = this.f31736c;
                    this.j = false;
                } else if (this.f31741h || this.f31740g) {
                    if (this.f31742i) {
                        b(i2 + ((int) (j - this.f31735b)));
                    }
                    this.k = this.f31735b;
                    this.l = this.f31738e;
                    this.f31742i = true;
                    this.m = this.f31736c;
                }
            }
        }

        public final void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                boolean z = this.m;
                this.f31734a.c(this.l, z ? 1 : 0, (int) (this.f31735b - this.k), i2, null);
            }
        }

        public void c(byte[] bArr, int i2, int i3) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, bArr, i2, i3) == null) && this.f31739f) {
                int i4 = this.f31737d;
                int i5 = (i2 + 2) - i4;
                if (i5 < i3) {
                    this.f31740g = (bArr[i5] & ByteCompanionObject.MIN_VALUE) != 0;
                    this.f31739f = false;
                    return;
                }
                this.f31737d = i4 + (i3 - i2);
            }
        }

        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.f31739f = false;
                this.f31740g = false;
                this.f31741h = false;
                this.f31742i = false;
                this.j = false;
            }
        }

        public void e(long j, int i2, int i3, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2)}) == null) {
                boolean z = false;
                this.f31740g = false;
                this.f31741h = false;
                this.f31738e = j2;
                this.f31737d = 0;
                this.f31735b = j;
                if (i3 >= 32) {
                    if (!this.j && this.f31742i) {
                        b(i2);
                        this.f31742i = false;
                    }
                    if (i3 <= 34) {
                        this.f31741h = !this.j;
                        this.j = true;
                    }
                }
                boolean z2 = i3 >= 16 && i3 <= 21;
                this.f31736c = z2;
                this.f31739f = (z2 || i3 <= 9) ? true : true;
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
        this.f31725a = tVar;
        this.f31730f = new boolean[3];
        this.f31731g = new o(32, 128);
        this.f31732h = new o(33, 128);
        this.f31733i = new o(34, 128);
        this.j = new o(39, 128);
        this.k = new o(40, 128);
        this.n = new b.i.b.a.i0.l();
    }

    public static Format h(String str, o oVar, o oVar2, o oVar3) {
        InterceptResult invokeLLLL;
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65537, null, str, oVar, oVar2, oVar3)) == null) {
            int i2 = oVar.f31771e;
            byte[] bArr = new byte[oVar2.f31771e + i2 + oVar3.f31771e];
            System.arraycopy(oVar.f31770d, 0, bArr, 0, i2);
            System.arraycopy(oVar2.f31770d, 0, bArr, oVar.f31771e, oVar2.f31771e);
            System.arraycopy(oVar3.f31770d, 0, bArr, oVar.f31771e + oVar2.f31771e, oVar3.f31771e);
            b.i.b.a.i0.m mVar = new b.i.b.a.i0.m(oVar2.f31770d, 0, oVar2.f31771e);
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
                    float[] fArr = b.i.b.a.i0.j.f32616b;
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

    public static void i(b.i.b.a.i0.m mVar) {
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

    public static void j(b.i.b.a.i0.m mVar) {
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

    public final void a(long j, int i2, int i3, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2)}) == null) {
            if (this.f31729e) {
                this.f31728d.a(j, i2);
            } else {
                this.f31731g.b(i3);
                this.f31732h.b(i3);
                this.f31733i.b(i3);
                if (this.f31731g.c() && this.f31732h.c() && this.f31733i.c()) {
                    this.f31727c.b(h(this.f31726b, this.f31731g, this.f31732h, this.f31733i));
                    this.f31729e = true;
                }
            }
            if (this.j.b(i3)) {
                o oVar = this.j;
                this.n.H(this.j.f31770d, b.i.b.a.i0.j.k(oVar.f31770d, oVar.f31771e));
                this.n.K(5);
                this.f31725a.a(j2, this.n);
            }
            if (this.k.b(i3)) {
                o oVar2 = this.k;
                this.n.H(this.k.f31770d, b.i.b.a.i0.j.k(oVar2.f31770d, oVar2.f31771e));
                this.n.K(5);
                this.f31725a.a(j2, this.n);
            }
        }
    }

    @Override // b.i.b.a.a0.t.h
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            b.i.b.a.i0.j.a(this.f31730f);
            this.f31731g.d();
            this.f31732h.d();
            this.f31733i.d();
            this.j.d();
            this.k.d();
            this.f31728d.d();
            this.l = 0L;
        }
    }

    @Override // b.i.b.a.a0.t.h
    public void c(b.i.b.a.i0.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lVar) == null) {
            while (lVar.a() > 0) {
                int c2 = lVar.c();
                int d2 = lVar.d();
                byte[] bArr = lVar.f32635a;
                this.l += lVar.a();
                this.f31727c.a(lVar, lVar.a());
                while (c2 < d2) {
                    int c3 = b.i.b.a.i0.j.c(bArr, c2, d2, this.f31730f);
                    if (c3 == d2) {
                        g(bArr, c2, d2);
                        return;
                    }
                    int e2 = b.i.b.a.i0.j.e(bArr, c3);
                    int i2 = c3 - c2;
                    if (i2 > 0) {
                        g(bArr, c2, c3);
                    }
                    int i3 = d2 - c3;
                    long j = this.l - i3;
                    a(j, i3, i2 < 0 ? -i2 : 0, this.m);
                    k(j, i3, e2, this.m);
                    c2 = c3 + 3;
                }
            }
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
            this.f31726b = dVar.b();
            b.i.b.a.a0.m a2 = gVar.a(dVar.c(), 2);
            this.f31727c = a2;
            this.f31728d = new a(a2);
            this.f31725a.b(gVar, dVar);
        }
    }

    public final void g(byte[] bArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048582, this, bArr, i2, i3) == null) {
            if (this.f31729e) {
                this.f31728d.c(bArr, i2, i3);
            } else {
                this.f31731g.a(bArr, i2, i3);
                this.f31732h.a(bArr, i2, i3);
                this.f31733i.a(bArr, i2, i3);
            }
            this.j.a(bArr, i2, i3);
            this.k.a(bArr, i2, i3);
        }
    }

    public final void k(long j, int i2, int i3, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Long.valueOf(j), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2)}) == null) {
            if (this.f31729e) {
                this.f31728d.e(j, i2, i3, j2);
            } else {
                this.f31731g.e(i3);
                this.f31732h.e(i3);
                this.f31733i.e(i3);
            }
            this.j.e(i3);
            this.k.e(i3);
        }
    }
}
