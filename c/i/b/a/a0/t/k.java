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
    public final t f32839a;

    /* renamed from: b  reason: collision with root package name */
    public String f32840b;

    /* renamed from: c  reason: collision with root package name */
    public c.i.b.a.a0.m f32841c;

    /* renamed from: d  reason: collision with root package name */
    public a f32842d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f32843e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean[] f32844f;

    /* renamed from: g  reason: collision with root package name */
    public final o f32845g;

    /* renamed from: h  reason: collision with root package name */
    public final o f32846h;

    /* renamed from: i  reason: collision with root package name */
    public final o f32847i;

    /* renamed from: j  reason: collision with root package name */
    public final o f32848j;
    public final o k;
    public long l;
    public long m;
    public final c.i.b.a.i0.l n;

    /* loaded from: classes4.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final c.i.b.a.a0.m f32849a;

        /* renamed from: b  reason: collision with root package name */
        public long f32850b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f32851c;

        /* renamed from: d  reason: collision with root package name */
        public int f32852d;

        /* renamed from: e  reason: collision with root package name */
        public long f32853e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f32854f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f32855g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f32856h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f32857i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f32858j;
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
            this.f32849a = mVar;
        }

        public void a(long j2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
                if (this.f32858j && this.f32855g) {
                    this.m = this.f32851c;
                    this.f32858j = false;
                } else if (this.f32856h || this.f32855g) {
                    if (this.f32857i) {
                        b(i2 + ((int) (j2 - this.f32850b)));
                    }
                    this.k = this.f32850b;
                    this.l = this.f32853e;
                    this.f32857i = true;
                    this.m = this.f32851c;
                }
            }
        }

        public final void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                boolean z = this.m;
                this.f32849a.c(this.l, z ? 1 : 0, (int) (this.f32850b - this.k), i2, null);
            }
        }

        public void c(byte[] bArr, int i2, int i3) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, bArr, i2, i3) == null) && this.f32854f) {
                int i4 = this.f32852d;
                int i5 = (i2 + 2) - i4;
                if (i5 < i3) {
                    this.f32855g = (bArr[i5] & ByteCompanionObject.MIN_VALUE) != 0;
                    this.f32854f = false;
                    return;
                }
                this.f32852d = i4 + (i3 - i2);
            }
        }

        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.f32854f = false;
                this.f32855g = false;
                this.f32856h = false;
                this.f32857i = false;
                this.f32858j = false;
            }
        }

        public void e(long j2, int i2, int i3, long j3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j3)}) == null) {
                boolean z = false;
                this.f32855g = false;
                this.f32856h = false;
                this.f32853e = j3;
                this.f32852d = 0;
                this.f32850b = j2;
                if (i3 >= 32) {
                    if (!this.f32858j && this.f32857i) {
                        b(i2);
                        this.f32857i = false;
                    }
                    if (i3 <= 34) {
                        this.f32856h = !this.f32858j;
                        this.f32858j = true;
                    }
                }
                boolean z2 = i3 >= 16 && i3 <= 21;
                this.f32851c = z2;
                this.f32854f = (z2 || i3 <= 9) ? true : true;
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
        this.f32839a = tVar;
        this.f32844f = new boolean[3];
        this.f32845g = new o(32, 128);
        this.f32846h = new o(33, 128);
        this.f32847i = new o(34, 128);
        this.f32848j = new o(39, 128);
        this.k = new o(40, 128);
        this.n = new c.i.b.a.i0.l();
    }

    public static Format h(String str, o oVar, o oVar2, o oVar3) {
        InterceptResult invokeLLLL;
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65537, null, str, oVar, oVar2, oVar3)) == null) {
            int i2 = oVar.f32889e;
            byte[] bArr = new byte[oVar2.f32889e + i2 + oVar3.f32889e];
            System.arraycopy(oVar.f32888d, 0, bArr, 0, i2);
            System.arraycopy(oVar2.f32888d, 0, bArr, oVar.f32889e, oVar2.f32889e);
            System.arraycopy(oVar3.f32888d, 0, bArr, oVar.f32889e + oVar2.f32889e, oVar3.f32889e);
            c.i.b.a.i0.m mVar = new c.i.b.a.i0.m(oVar2.f32888d, 0, oVar2.f32889e);
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
                    float[] fArr = c.i.b.a.i0.j.f33792b;
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
            if (this.f32843e) {
                this.f32842d.a(j2, i2);
            } else {
                this.f32845g.b(i3);
                this.f32846h.b(i3);
                this.f32847i.b(i3);
                if (this.f32845g.c() && this.f32846h.c() && this.f32847i.c()) {
                    this.f32841c.b(h(this.f32840b, this.f32845g, this.f32846h, this.f32847i));
                    this.f32843e = true;
                }
            }
            if (this.f32848j.b(i3)) {
                o oVar = this.f32848j;
                this.n.H(this.f32848j.f32888d, c.i.b.a.i0.j.k(oVar.f32888d, oVar.f32889e));
                this.n.K(5);
                this.f32839a.a(j3, this.n);
            }
            if (this.k.b(i3)) {
                o oVar2 = this.k;
                this.n.H(this.k.f32888d, c.i.b.a.i0.j.k(oVar2.f32888d, oVar2.f32889e));
                this.n.K(5);
                this.f32839a.a(j3, this.n);
            }
        }
    }

    @Override // c.i.b.a.a0.t.h
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.i.b.a.i0.j.a(this.f32844f);
            this.f32845g.d();
            this.f32846h.d();
            this.f32847i.d();
            this.f32848j.d();
            this.k.d();
            this.f32842d.d();
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
                byte[] bArr = lVar.f33812a;
                this.l += lVar.a();
                this.f32841c.a(lVar, lVar.a());
                while (c2 < d2) {
                    int c3 = c.i.b.a.i0.j.c(bArr, c2, d2, this.f32844f);
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
            this.f32840b = dVar.b();
            c.i.b.a.a0.m a2 = gVar.a(dVar.c(), 2);
            this.f32841c = a2;
            this.f32842d = new a(a2);
            this.f32839a.b(gVar, dVar);
        }
    }

    public final void g(byte[] bArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048582, this, bArr, i2, i3) == null) {
            if (this.f32843e) {
                this.f32842d.c(bArr, i2, i3);
            } else {
                this.f32845g.a(bArr, i2, i3);
                this.f32846h.a(bArr, i2, i3);
                this.f32847i.a(bArr, i2, i3);
            }
            this.f32848j.a(bArr, i2, i3);
            this.k.a(bArr, i2, i3);
        }
    }

    public final void k(long j2, int i2, int i3, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j3)}) == null) {
            if (this.f32843e) {
                this.f32842d.e(j2, i2, i3, j3);
            } else {
                this.f32845g.e(i3);
                this.f32846h.e(i3);
                this.f32847i.e(i3);
            }
            this.f32848j.e(i3);
            this.k.e(i3);
        }
    }
}
