package b.i.b.a.d0;

import b.i.b.a.d0.k;
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
    public final k f31900e;

    /* renamed from: f  reason: collision with root package name */
    public k.a f31901f;

    /* renamed from: g  reason: collision with root package name */
    public long f31902g;

    /* renamed from: h  reason: collision with root package name */
    public long f31903h;

    /* renamed from: i  reason: collision with root package name */
    public a[] f31904i;
    public boolean j;

    /* loaded from: classes6.dex */
    public static final class a implements o {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final k f31905e;

        /* renamed from: f  reason: collision with root package name */
        public final o f31906f;

        /* renamed from: g  reason: collision with root package name */
        public final long f31907g;

        /* renamed from: h  reason: collision with root package name */
        public final long f31908h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f31909i;
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
            this.f31905e = kVar;
            this.f31906f = oVar;
            this.f31907g = j;
            this.f31908h = j2;
            this.f31909i = z;
        }

        @Override // b.i.b.a.d0.o
        public void a() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f31906f.a();
            }
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f31909i = false;
            }
        }

        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.j = false;
            }
        }

        @Override // b.i.b.a.d0.o
        public int f(b.i.b.a.l lVar, b.i.b.a.y.e eVar, boolean z) {
            InterceptResult invokeLLZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048579, this, lVar, eVar, z)) == null) {
                if (this.f31909i) {
                    return -3;
                }
                if (this.j) {
                    eVar.l(4);
                    return -4;
                }
                int f2 = this.f31906f.f(lVar, eVar, z);
                if (f2 == -5) {
                    Format format = lVar.f32741a;
                    lVar.f32741a = format.copyWithGaplessInfo(this.f31907g != 0 ? 0 : format.encoderDelay, this.f31908h == Long.MIN_VALUE ? format.encoderPadding : 0);
                    return -5;
                }
                long j = this.f31908h;
                if (j != Long.MIN_VALUE && ((f2 == -4 && eVar.f32902h >= j) || (f2 == -3 && this.f31905e.c() == Long.MIN_VALUE))) {
                    eVar.f();
                    eVar.l(4);
                    this.j = true;
                    return -4;
                }
                if (f2 == -4 && !eVar.j()) {
                    eVar.f32902h -= this.f31907g;
                }
                return f2;
            }
            return invokeLLZ.intValue;
        }

        @Override // b.i.b.a.d0.o
        public boolean isReady() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f31906f.isReady() : invokeV.booleanValue;
        }

        @Override // b.i.b.a.d0.o
        public int j(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j)) == null) ? this.f31906f.j(this.f31907g + j) : invokeJ.intValue;
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
        this.f31900e = kVar;
        this.f31902g = -9223372036854775807L;
        this.f31903h = -9223372036854775807L;
        this.f31904i = new a[0];
        this.j = z;
    }

    public static boolean m(b.i.b.a.f0.f[] fVarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, fVarArr)) == null) {
            for (b.i.b.a.f0.f fVar : fVarArr) {
                if (fVar != null && !b.i.b.a.i0.i.g(fVar.f().sampleMimeType)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.i.b.a.d0.p.a
    /* renamed from: a */
    public void j(k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, kVar) == null) {
            this.f31901f.j(this);
        }
    }

    @Override // b.i.b.a.d0.k, b.i.b.a.d0.p
    public boolean b(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) ? this.f31900e.b(j + this.f31902g) : invokeJ.booleanValue;
    }

    @Override // b.i.b.a.d0.k, b.i.b.a.d0.p
    public long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            long c2 = this.f31900e.c();
            if (c2 != Long.MIN_VALUE) {
                long j = this.f31903h;
                if (j == Long.MIN_VALUE || c2 < j) {
                    return Math.max(0L, c2 - this.f31902g);
                }
            }
            return Long.MIN_VALUE;
        }
        return invokeV.longValue;
    }

    @Override // b.i.b.a.d0.k, b.i.b.a.d0.p
    public long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            long d2 = this.f31900e.d();
            if (d2 != Long.MIN_VALUE) {
                long j = this.f31903h;
                if (j == Long.MIN_VALUE || d2 < j) {
                    return d2 - this.f31902g;
                }
            }
            return Long.MIN_VALUE;
        }
        return invokeV.longValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x006c, code lost:
        if (r12 > r3) goto L30;
     */
    @Override // b.i.b.a.d0.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long e(b.i.b.a.f0.f[] fVarArr, boolean[] zArr, o[] oVarArr, boolean[] zArr2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{fVarArr, zArr, oVarArr, zArr2, Long.valueOf(j)})) == null) {
            this.f31904i = new a[oVarArr.length];
            o[] oVarArr2 = new o[oVarArr.length];
            int i2 = 0;
            while (true) {
                o oVar = null;
                if (i2 >= oVarArr.length) {
                    break;
                }
                a[] aVarArr = this.f31904i;
                aVarArr[i2] = (a) oVarArr[i2];
                if (aVarArr[i2] != null) {
                    oVar = aVarArr[i2].f31906f;
                }
                oVarArr2[i2] = oVar;
                i2++;
            }
            long e2 = this.f31900e.e(fVarArr, zArr, oVarArr2, zArr2, j + this.f31902g);
            boolean z = true;
            if (this.j) {
                this.j = this.f31902g != 0 && m(fVarArr);
            }
            long j2 = this.f31902g;
            if (e2 != j + j2) {
                if (e2 >= j2) {
                    long j3 = this.f31903h;
                    if (j3 != Long.MIN_VALUE) {
                    }
                }
                z = false;
            }
            b.i.b.a.i0.a.f(z);
            for (int i3 = 0; i3 < oVarArr.length; i3++) {
                if (oVarArr2[i3] == null) {
                    this.f31904i[i3] = null;
                } else if (oVarArr[i3] == null || this.f31904i[i3].f31906f != oVarArr2[i3]) {
                    this.f31904i[i3] = new a(this, oVarArr2[i3], this.f31902g, this.f31903h, this.j);
                }
                oVarArr[i3] = this.f31904i[i3];
            }
            return e2 - this.f31902g;
        }
        return invokeCommon.longValue;
    }

    public void f(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            this.f31902g = j;
            this.f31903h = j2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0033, code lost:
        if (r0 > r7) goto L20;
     */
    @Override // b.i.b.a.d0.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long g(long j) {
        InterceptResult invokeJ;
        a[] aVarArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048582, this, j)) == null) {
            boolean z = false;
            for (a aVar : this.f31904i) {
                if (aVar != null) {
                    aVar.d();
                }
            }
            long g2 = this.f31900e.g(this.f31902g + j);
            long j2 = this.f31902g;
            if (g2 != j + j2) {
                if (g2 >= j2) {
                    long j3 = this.f31903h;
                    if (j3 != Long.MIN_VALUE) {
                    }
                }
                b.i.b.a.i0.a.f(z);
                return g2 - this.f31902g;
            }
            z = true;
            b.i.b.a.i0.a.f(z);
            return g2 - this.f31902g;
        }
        return invokeJ.longValue;
    }

    @Override // b.i.b.a.d0.k
    public long h() {
        InterceptResult invokeV;
        a[] aVarArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            boolean z = false;
            if (this.j) {
                for (a aVar : this.f31904i) {
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
            long h3 = this.f31900e.h();
            if (h3 == -9223372036854775807L) {
                return -9223372036854775807L;
            }
            b.i.b.a.i0.a.f(h3 >= this.f31902g);
            long j = this.f31903h;
            b.i.b.a.i0.a.f((j == Long.MIN_VALUE || h3 <= j) ? true : true);
            return h3 - this.f31902g;
        }
        return invokeV.longValue;
    }

    @Override // b.i.b.a.d0.k
    public t k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f31900e.k() : (t) invokeV.objValue;
    }

    @Override // b.i.b.a.d0.k.a
    public void l(k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, kVar) == null) {
            b.i.b.a.i0.a.f((this.f31902g == -9223372036854775807L || this.f31903h == -9223372036854775807L) ? false : true);
            this.f31901f.l(this);
        }
    }

    @Override // b.i.b.a.d0.k
    public void o(k.a aVar, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048587, this, aVar, j) == null) {
            this.f31901f = aVar;
            this.f31900e.o(this, this.f31902g + j);
        }
    }

    @Override // b.i.b.a.d0.k
    public void q() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f31900e.q();
        }
    }

    @Override // b.i.b.a.d0.k
    public void r(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048589, this, j) == null) {
            this.f31900e.r(j + this.f31902g);
        }
    }
}
