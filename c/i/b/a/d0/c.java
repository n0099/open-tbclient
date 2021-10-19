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
    public final k f33053e;

    /* renamed from: f  reason: collision with root package name */
    public k.a f33054f;

    /* renamed from: g  reason: collision with root package name */
    public long f33055g;

    /* renamed from: h  reason: collision with root package name */
    public long f33056h;

    /* renamed from: i  reason: collision with root package name */
    public a[] f33057i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f33058j;

    /* loaded from: classes4.dex */
    public static final class a implements o {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final k f33059e;

        /* renamed from: f  reason: collision with root package name */
        public final o f33060f;

        /* renamed from: g  reason: collision with root package name */
        public final long f33061g;

        /* renamed from: h  reason: collision with root package name */
        public final long f33062h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f33063i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f33064j;

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
            this.f33059e = kVar;
            this.f33060f = oVar;
            this.f33061g = j2;
            this.f33062h = j3;
            this.f33063i = z;
        }

        @Override // c.i.b.a.d0.o
        public void a() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f33060f.a();
            }
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f33063i = false;
            }
        }

        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f33064j = false;
            }
        }

        @Override // c.i.b.a.d0.o
        public int f(c.i.b.a.l lVar, c.i.b.a.y.e eVar, boolean z) {
            InterceptResult invokeLLZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048579, this, lVar, eVar, z)) == null) {
                if (this.f33063i) {
                    return -3;
                }
                if (this.f33064j) {
                    eVar.l(4);
                    return -4;
                }
                int f2 = this.f33060f.f(lVar, eVar, z);
                if (f2 == -5) {
                    Format format = lVar.f33949a;
                    lVar.f33949a = format.copyWithGaplessInfo(this.f33061g != 0 ? 0 : format.encoderDelay, this.f33062h == Long.MIN_VALUE ? format.encoderPadding : 0);
                    return -5;
                }
                long j2 = this.f33062h;
                if (j2 != Long.MIN_VALUE && ((f2 == -4 && eVar.f34117h >= j2) || (f2 == -3 && this.f33059e.c() == Long.MIN_VALUE))) {
                    eVar.f();
                    eVar.l(4);
                    this.f33064j = true;
                    return -4;
                }
                if (f2 == -4 && !eVar.j()) {
                    eVar.f34117h -= this.f33061g;
                }
                return f2;
            }
            return invokeLLZ.intValue;
        }

        @Override // c.i.b.a.d0.o
        public boolean isReady() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f33060f.isReady() : invokeV.booleanValue;
        }

        @Override // c.i.b.a.d0.o
        public int j(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j2)) == null) ? this.f33060f.j(this.f33061g + j2) : invokeJ.intValue;
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
        this.f33053e = kVar;
        this.f33055g = -9223372036854775807L;
        this.f33056h = -9223372036854775807L;
        this.f33057i = new a[0];
        this.f33058j = z;
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
            this.f33054f.j(this);
        }
    }

    @Override // c.i.b.a.d0.k, c.i.b.a.d0.p
    public boolean b(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) ? this.f33053e.b(j2 + this.f33055g) : invokeJ.booleanValue;
    }

    @Override // c.i.b.a.d0.k, c.i.b.a.d0.p
    public long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            long c2 = this.f33053e.c();
            if (c2 != Long.MIN_VALUE) {
                long j2 = this.f33056h;
                if (j2 == Long.MIN_VALUE || c2 < j2) {
                    return Math.max(0L, c2 - this.f33055g);
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
            long d2 = this.f33053e.d();
            if (d2 != Long.MIN_VALUE) {
                long j2 = this.f33056h;
                if (j2 == Long.MIN_VALUE || d2 < j2) {
                    return d2 - this.f33055g;
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
            this.f33057i = new a[oVarArr.length];
            o[] oVarArr2 = new o[oVarArr.length];
            int i2 = 0;
            while (true) {
                o oVar = null;
                if (i2 >= oVarArr.length) {
                    break;
                }
                a[] aVarArr = this.f33057i;
                aVarArr[i2] = (a) oVarArr[i2];
                if (aVarArr[i2] != null) {
                    oVar = aVarArr[i2].f33060f;
                }
                oVarArr2[i2] = oVar;
                i2++;
            }
            long e2 = this.f33053e.e(fVarArr, zArr, oVarArr2, zArr2, j2 + this.f33055g);
            boolean z = true;
            if (this.f33058j) {
                this.f33058j = this.f33055g != 0 && m(fVarArr);
            }
            long j3 = this.f33055g;
            if (e2 != j2 + j3) {
                if (e2 >= j3) {
                    long j4 = this.f33056h;
                    if (j4 != Long.MIN_VALUE) {
                    }
                }
                z = false;
            }
            c.i.b.a.i0.a.f(z);
            for (int i3 = 0; i3 < oVarArr.length; i3++) {
                if (oVarArr2[i3] == null) {
                    this.f33057i[i3] = null;
                } else if (oVarArr[i3] == null || this.f33057i[i3].f33060f != oVarArr2[i3]) {
                    this.f33057i[i3] = new a(this, oVarArr2[i3], this.f33055g, this.f33056h, this.f33058j);
                }
                oVarArr[i3] = this.f33057i[i3];
            }
            return e2 - this.f33055g;
        }
        return invokeCommon.longValue;
    }

    public void f(long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            this.f33055g = j2;
            this.f33056h = j3;
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
            for (a aVar : this.f33057i) {
                if (aVar != null) {
                    aVar.d();
                }
            }
            long g2 = this.f33053e.g(this.f33055g + j2);
            long j3 = this.f33055g;
            if (g2 != j2 + j3) {
                if (g2 >= j3) {
                    long j4 = this.f33056h;
                    if (j4 != Long.MIN_VALUE) {
                    }
                }
                c.i.b.a.i0.a.f(z);
                return g2 - this.f33055g;
            }
            z = true;
            c.i.b.a.i0.a.f(z);
            return g2 - this.f33055g;
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
            if (this.f33058j) {
                for (a aVar : this.f33057i) {
                    if (aVar != null) {
                        aVar.c();
                    }
                }
                this.f33058j = false;
                long h2 = h();
                if (h2 != -9223372036854775807L) {
                    return h2;
                }
                return 0L;
            }
            long h3 = this.f33053e.h();
            if (h3 == -9223372036854775807L) {
                return -9223372036854775807L;
            }
            c.i.b.a.i0.a.f(h3 >= this.f33055g);
            long j2 = this.f33056h;
            c.i.b.a.i0.a.f((j2 == Long.MIN_VALUE || h3 <= j2) ? true : true);
            return h3 - this.f33055g;
        }
        return invokeV.longValue;
    }

    @Override // c.i.b.a.d0.k
    public t k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f33053e.k() : (t) invokeV.objValue;
    }

    @Override // c.i.b.a.d0.k.a
    public void l(k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, kVar) == null) {
            c.i.b.a.i0.a.f((this.f33055g == -9223372036854775807L || this.f33056h == -9223372036854775807L) ? false : true);
            this.f33054f.l(this);
        }
    }

    @Override // c.i.b.a.d0.k
    public void o(k.a aVar, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048587, this, aVar, j2) == null) {
            this.f33054f = aVar;
            this.f33053e.o(this, this.f33055g + j2);
        }
    }

    @Override // c.i.b.a.d0.k
    public void q() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f33053e.q();
        }
    }

    @Override // c.i.b.a.d0.k
    public void r(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048589, this, j2) == null) {
            this.f33053e.r(j2 + this.f33055g);
        }
    }
}
