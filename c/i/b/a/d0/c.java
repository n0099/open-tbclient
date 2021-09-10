package c.i.b.a.d0;

import c.i.b.a.d0.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import java.io.IOException;
/* loaded from: classes4.dex */
public final class c implements k, k.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final k f33026e;

    /* renamed from: f  reason: collision with root package name */
    public k.a f33027f;

    /* renamed from: g  reason: collision with root package name */
    public long f33028g;

    /* renamed from: h  reason: collision with root package name */
    public long f33029h;

    /* renamed from: i  reason: collision with root package name */
    public a[] f33030i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f33031j;

    /* loaded from: classes4.dex */
    public static final class a implements o {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final k f33032e;

        /* renamed from: f  reason: collision with root package name */
        public final o f33033f;

        /* renamed from: g  reason: collision with root package name */
        public final long f33034g;

        /* renamed from: h  reason: collision with root package name */
        public final long f33035h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f33036i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f33037j;

        public a(k kVar, o oVar, long j2, long j3, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, oVar, Long.valueOf(j2), Long.valueOf(j3), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33032e = kVar;
            this.f33033f = oVar;
            this.f33034g = j2;
            this.f33035h = j3;
            this.f33036i = z;
        }

        @Override // c.i.b.a.d0.o
        public void a() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f33033f.a();
            }
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f33036i = false;
            }
        }

        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f33037j = false;
            }
        }

        @Override // c.i.b.a.d0.o
        public int f(c.i.b.a.l lVar, c.i.b.a.y.e eVar, boolean z) {
            InterceptResult invokeLLZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048579, this, lVar, eVar, z)) == null) {
                if (this.f33036i) {
                    return -3;
                }
                if (this.f33037j) {
                    eVar.l(4);
                    return -4;
                }
                int f2 = this.f33033f.f(lVar, eVar, z);
                if (f2 == -5) {
                    Format format = lVar.f33922a;
                    lVar.f33922a = format.copyWithGaplessInfo(this.f33034g != 0 ? 0 : format.encoderDelay, this.f33035h == Long.MIN_VALUE ? format.encoderPadding : 0);
                    return -5;
                }
                long j2 = this.f33035h;
                if (j2 != Long.MIN_VALUE && ((f2 == -4 && eVar.f34090h >= j2) || (f2 == -3 && this.f33032e.c() == Long.MIN_VALUE))) {
                    eVar.f();
                    eVar.l(4);
                    this.f33037j = true;
                    return -4;
                }
                if (f2 == -4 && !eVar.j()) {
                    eVar.f34090h -= this.f33034g;
                }
                return f2;
            }
            return invokeLLZ.intValue;
        }

        @Override // c.i.b.a.d0.o
        public boolean isReady() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f33033f.isReady() : invokeV.booleanValue;
        }

        @Override // c.i.b.a.d0.o
        public int j(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j2)) == null) ? this.f33033f.j(this.f33034g + j2) : invokeJ.intValue;
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
        this.f33026e = kVar;
        this.f33028g = -9223372036854775807L;
        this.f33029h = -9223372036854775807L;
        this.f33030i = new a[0];
        this.f33031j = z;
    }

    public static boolean m(c.i.b.a.f0.f[] fVarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, fVarArr)) == null) {
            for (c.i.b.a.f0.f fVar : fVarArr) {
                if (fVar != null && !c.i.b.a.i0.i.g(fVar.f().sampleMimeType)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.i.b.a.d0.p.a
    /* renamed from: a */
    public void j(k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, kVar) == null) {
            this.f33027f.j(this);
        }
    }

    @Override // c.i.b.a.d0.k, c.i.b.a.d0.p
    public boolean b(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) ? this.f33026e.b(j2 + this.f33028g) : invokeJ.booleanValue;
    }

    @Override // c.i.b.a.d0.k, c.i.b.a.d0.p
    public long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            long c2 = this.f33026e.c();
            if (c2 != Long.MIN_VALUE) {
                long j2 = this.f33029h;
                if (j2 == Long.MIN_VALUE || c2 < j2) {
                    return Math.max(0L, c2 - this.f33028g);
                }
            }
            return Long.MIN_VALUE;
        }
        return invokeV.longValue;
    }

    @Override // c.i.b.a.d0.k, c.i.b.a.d0.p
    public long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            long d2 = this.f33026e.d();
            if (d2 != Long.MIN_VALUE) {
                long j2 = this.f33029h;
                if (j2 == Long.MIN_VALUE || d2 < j2) {
                    return d2 - this.f33028g;
                }
            }
            return Long.MIN_VALUE;
        }
        return invokeV.longValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x006c, code lost:
        if (r12 > r3) goto L30;
     */
    @Override // c.i.b.a.d0.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long e(c.i.b.a.f0.f[] fVarArr, boolean[] zArr, o[] oVarArr, boolean[] zArr2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{fVarArr, zArr, oVarArr, zArr2, Long.valueOf(j2)})) == null) {
            this.f33030i = new a[oVarArr.length];
            o[] oVarArr2 = new o[oVarArr.length];
            int i2 = 0;
            while (true) {
                o oVar = null;
                if (i2 >= oVarArr.length) {
                    break;
                }
                a[] aVarArr = this.f33030i;
                aVarArr[i2] = (a) oVarArr[i2];
                if (aVarArr[i2] != null) {
                    oVar = aVarArr[i2].f33033f;
                }
                oVarArr2[i2] = oVar;
                i2++;
            }
            long e2 = this.f33026e.e(fVarArr, zArr, oVarArr2, zArr2, j2 + this.f33028g);
            boolean z = true;
            if (this.f33031j) {
                this.f33031j = this.f33028g != 0 && m(fVarArr);
            }
            long j3 = this.f33028g;
            if (e2 != j2 + j3) {
                if (e2 >= j3) {
                    long j4 = this.f33029h;
                    if (j4 != Long.MIN_VALUE) {
                    }
                }
                z = false;
            }
            c.i.b.a.i0.a.f(z);
            for (int i3 = 0; i3 < oVarArr.length; i3++) {
                if (oVarArr2[i3] == null) {
                    this.f33030i[i3] = null;
                } else if (oVarArr[i3] == null || this.f33030i[i3].f33033f != oVarArr2[i3]) {
                    this.f33030i[i3] = new a(this, oVarArr2[i3], this.f33028g, this.f33029h, this.f33031j);
                }
                oVarArr[i3] = this.f33030i[i3];
            }
            return e2 - this.f33028g;
        }
        return invokeCommon.longValue;
    }

    public void f(long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            this.f33028g = j2;
            this.f33029h = j3;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0033, code lost:
        if (r0 > r7) goto L20;
     */
    @Override // c.i.b.a.d0.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long g(long j2) {
        InterceptResult invokeJ;
        a[] aVarArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048582, this, j2)) == null) {
            boolean z = false;
            for (a aVar : this.f33030i) {
                if (aVar != null) {
                    aVar.d();
                }
            }
            long g2 = this.f33026e.g(this.f33028g + j2);
            long j3 = this.f33028g;
            if (g2 != j2 + j3) {
                if (g2 >= j3) {
                    long j4 = this.f33029h;
                    if (j4 != Long.MIN_VALUE) {
                    }
                }
                c.i.b.a.i0.a.f(z);
                return g2 - this.f33028g;
            }
            z = true;
            c.i.b.a.i0.a.f(z);
            return g2 - this.f33028g;
        }
        return invokeJ.longValue;
    }

    @Override // c.i.b.a.d0.k
    public long h() {
        InterceptResult invokeV;
        a[] aVarArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            boolean z = false;
            if (this.f33031j) {
                for (a aVar : this.f33030i) {
                    if (aVar != null) {
                        aVar.c();
                    }
                }
                this.f33031j = false;
                long h2 = h();
                if (h2 != -9223372036854775807L) {
                    return h2;
                }
                return 0L;
            }
            long h3 = this.f33026e.h();
            if (h3 == -9223372036854775807L) {
                return -9223372036854775807L;
            }
            c.i.b.a.i0.a.f(h3 >= this.f33028g);
            long j2 = this.f33029h;
            c.i.b.a.i0.a.f((j2 == Long.MIN_VALUE || h3 <= j2) ? true : true);
            return h3 - this.f33028g;
        }
        return invokeV.longValue;
    }

    @Override // c.i.b.a.d0.k
    public t k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f33026e.k() : (t) invokeV.objValue;
    }

    @Override // c.i.b.a.d0.k.a
    public void l(k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, kVar) == null) {
            c.i.b.a.i0.a.f((this.f33028g == -9223372036854775807L || this.f33029h == -9223372036854775807L) ? false : true);
            this.f33027f.l(this);
        }
    }

    @Override // c.i.b.a.d0.k
    public void o(k.a aVar, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048587, this, aVar, j2) == null) {
            this.f33027f = aVar;
            this.f33026e.o(this, this.f33028g + j2);
        }
    }

    @Override // c.i.b.a.d0.k
    public void q() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f33026e.q();
        }
    }

    @Override // c.i.b.a.d0.k
    public void r(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048589, this, j2) == null) {
            this.f33026e.r(j2 + this.f33028g);
        }
    }
}
