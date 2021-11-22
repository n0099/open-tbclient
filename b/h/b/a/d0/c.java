package b.h.b.a.d0;

import b.h.b.a.d0.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import java.io.IOException;
/* loaded from: classes6.dex */
public final class c implements k, k.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final k f32758e;

    /* renamed from: f  reason: collision with root package name */
    public k.a f32759f;

    /* renamed from: g  reason: collision with root package name */
    public long f32760g;

    /* renamed from: h  reason: collision with root package name */
    public long f32761h;

    /* renamed from: i  reason: collision with root package name */
    public a[] f32762i;
    public boolean j;

    /* loaded from: classes6.dex */
    public static final class a implements o {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final k f32763e;

        /* renamed from: f  reason: collision with root package name */
        public final o f32764f;

        /* renamed from: g  reason: collision with root package name */
        public final long f32765g;

        /* renamed from: h  reason: collision with root package name */
        public final long f32766h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f32767i;
        public boolean j;

        public a(k kVar, o oVar, long j, long j2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, oVar, Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f32763e = kVar;
            this.f32764f = oVar;
            this.f32765g = j;
            this.f32766h = j2;
            this.f32767i = z;
        }

        @Override // b.h.b.a.d0.o
        public void a() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f32764f.a();
            }
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f32767i = false;
            }
        }

        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.j = false;
            }
        }

        @Override // b.h.b.a.d0.o
        public int f(b.h.b.a.l lVar, b.h.b.a.y.e eVar, boolean z) {
            InterceptResult invokeLLZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048579, this, lVar, eVar, z)) == null) {
                if (this.f32767i) {
                    return -3;
                }
                if (this.j) {
                    eVar.l(4);
                    return -4;
                }
                int f2 = this.f32764f.f(lVar, eVar, z);
                if (f2 == -5) {
                    Format format = lVar.f33599a;
                    lVar.f33599a = format.copyWithGaplessInfo(this.f32765g != 0 ? 0 : format.encoderDelay, this.f32766h == Long.MIN_VALUE ? format.encoderPadding : 0);
                    return -5;
                }
                long j = this.f32766h;
                if (j != Long.MIN_VALUE && ((f2 == -4 && eVar.f33760h >= j) || (f2 == -3 && this.f32763e.c() == Long.MIN_VALUE))) {
                    eVar.f();
                    eVar.l(4);
                    this.j = true;
                    return -4;
                }
                if (f2 == -4 && !eVar.j()) {
                    eVar.f33760h -= this.f32765g;
                }
                return f2;
            }
            return invokeLLZ.intValue;
        }

        @Override // b.h.b.a.d0.o
        public boolean isReady() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f32764f.isReady() : invokeV.booleanValue;
        }

        @Override // b.h.b.a.d0.o
        public int j(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j)) == null) ? this.f32764f.j(this.f32765g + j) : invokeJ.intValue;
        }
    }

    public c(k kVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {kVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f32758e = kVar;
        this.f32760g = -9223372036854775807L;
        this.f32761h = -9223372036854775807L;
        this.f32762i = new a[0];
        this.j = z;
    }

    public static boolean m(b.h.b.a.f0.f[] fVarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, fVarArr)) == null) {
            for (b.h.b.a.f0.f fVar : fVarArr) {
                if (fVar != null && !b.h.b.a.i0.i.g(fVar.f().sampleMimeType)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.h.b.a.d0.p.a
    /* renamed from: a */
    public void j(k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, kVar) == null) {
            this.f32759f.j(this);
        }
    }

    @Override // b.h.b.a.d0.k, b.h.b.a.d0.p
    public boolean b(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) ? this.f32758e.b(j + this.f32760g) : invokeJ.booleanValue;
    }

    @Override // b.h.b.a.d0.k, b.h.b.a.d0.p
    public long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            long c2 = this.f32758e.c();
            if (c2 != Long.MIN_VALUE) {
                long j = this.f32761h;
                if (j == Long.MIN_VALUE || c2 < j) {
                    return Math.max(0L, c2 - this.f32760g);
                }
            }
            return Long.MIN_VALUE;
        }
        return invokeV.longValue;
    }

    @Override // b.h.b.a.d0.k, b.h.b.a.d0.p
    public long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            long d2 = this.f32758e.d();
            if (d2 != Long.MIN_VALUE) {
                long j = this.f32761h;
                if (j == Long.MIN_VALUE || d2 < j) {
                    return d2 - this.f32760g;
                }
            }
            return Long.MIN_VALUE;
        }
        return invokeV.longValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x006c, code lost:
        if (r12 > r3) goto L30;
     */
    @Override // b.h.b.a.d0.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long e(b.h.b.a.f0.f[] fVarArr, boolean[] zArr, o[] oVarArr, boolean[] zArr2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{fVarArr, zArr, oVarArr, zArr2, Long.valueOf(j)})) == null) {
            this.f32762i = new a[oVarArr.length];
            o[] oVarArr2 = new o[oVarArr.length];
            int i2 = 0;
            while (true) {
                o oVar = null;
                if (i2 >= oVarArr.length) {
                    break;
                }
                a[] aVarArr = this.f32762i;
                aVarArr[i2] = (a) oVarArr[i2];
                if (aVarArr[i2] != null) {
                    oVar = aVarArr[i2].f32764f;
                }
                oVarArr2[i2] = oVar;
                i2++;
            }
            long e2 = this.f32758e.e(fVarArr, zArr, oVarArr2, zArr2, j + this.f32760g);
            boolean z = true;
            if (this.j) {
                this.j = this.f32760g != 0 && m(fVarArr);
            }
            long j2 = this.f32760g;
            if (e2 != j + j2) {
                if (e2 >= j2) {
                    long j3 = this.f32761h;
                    if (j3 != Long.MIN_VALUE) {
                    }
                }
                z = false;
            }
            b.h.b.a.i0.a.f(z);
            for (int i3 = 0; i3 < oVarArr.length; i3++) {
                if (oVarArr2[i3] == null) {
                    this.f32762i[i3] = null;
                } else if (oVarArr[i3] == null || this.f32762i[i3].f32764f != oVarArr2[i3]) {
                    this.f32762i[i3] = new a(this, oVarArr2[i3], this.f32760g, this.f32761h, this.j);
                }
                oVarArr[i3] = this.f32762i[i3];
            }
            return e2 - this.f32760g;
        }
        return invokeCommon.longValue;
    }

    public void f(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            this.f32760g = j;
            this.f32761h = j2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0033, code lost:
        if (r0 > r7) goto L20;
     */
    @Override // b.h.b.a.d0.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long g(long j) {
        InterceptResult invokeJ;
        a[] aVarArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048582, this, j)) == null) {
            boolean z = false;
            for (a aVar : this.f32762i) {
                if (aVar != null) {
                    aVar.d();
                }
            }
            long g2 = this.f32758e.g(this.f32760g + j);
            long j2 = this.f32760g;
            if (g2 != j + j2) {
                if (g2 >= j2) {
                    long j3 = this.f32761h;
                    if (j3 != Long.MIN_VALUE) {
                    }
                }
                b.h.b.a.i0.a.f(z);
                return g2 - this.f32760g;
            }
            z = true;
            b.h.b.a.i0.a.f(z);
            return g2 - this.f32760g;
        }
        return invokeJ.longValue;
    }

    @Override // b.h.b.a.d0.k
    public long h() {
        InterceptResult invokeV;
        a[] aVarArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            boolean z = false;
            if (this.j) {
                for (a aVar : this.f32762i) {
                    if (aVar != null) {
                        aVar.c();
                    }
                }
                this.j = false;
                long h2 = h();
                if (h2 != -9223372036854775807L) {
                    return h2;
                }
                return 0L;
            }
            long h3 = this.f32758e.h();
            if (h3 == -9223372036854775807L) {
                return -9223372036854775807L;
            }
            b.h.b.a.i0.a.f(h3 >= this.f32760g);
            long j = this.f32761h;
            b.h.b.a.i0.a.f((j == Long.MIN_VALUE || h3 <= j) ? true : true);
            return h3 - this.f32760g;
        }
        return invokeV.longValue;
    }

    @Override // b.h.b.a.d0.k
    public t k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f32758e.k() : (t) invokeV.objValue;
    }

    @Override // b.h.b.a.d0.k.a
    public void l(k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, kVar) == null) {
            b.h.b.a.i0.a.f((this.f32760g == -9223372036854775807L || this.f32761h == -9223372036854775807L) ? false : true);
            this.f32759f.l(this);
        }
    }

    @Override // b.h.b.a.d0.k
    public void o(k.a aVar, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048587, this, aVar, j) == null) {
            this.f32759f = aVar;
            this.f32758e.o(this, this.f32760g + j);
        }
    }

    @Override // b.h.b.a.d0.k
    public void q() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f32758e.q();
        }
    }

    @Override // b.h.b.a.d0.k
    public void r(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048589, this, j) == null) {
            this.f32758e.r(j + this.f32760g);
        }
    }
}
