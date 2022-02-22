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
/* loaded from: classes9.dex */
public final class c implements k, k.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final k f29275e;

    /* renamed from: f  reason: collision with root package name */
    public k.a f29276f;

    /* renamed from: g  reason: collision with root package name */
    public long f29277g;

    /* renamed from: h  reason: collision with root package name */
    public long f29278h;

    /* renamed from: i  reason: collision with root package name */
    public a[] f29279i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f29280j;

    /* loaded from: classes9.dex */
    public static final class a implements o {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final k f29281e;

        /* renamed from: f  reason: collision with root package name */
        public final o f29282f;

        /* renamed from: g  reason: collision with root package name */
        public final long f29283g;

        /* renamed from: h  reason: collision with root package name */
        public final long f29284h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f29285i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f29286j;

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
            this.f29281e = kVar;
            this.f29282f = oVar;
            this.f29283g = j2;
            this.f29284h = j3;
            this.f29285i = z;
        }

        @Override // c.i.b.a.d0.o
        public void a() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f29282f.a();
            }
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f29285i = false;
            }
        }

        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f29286j = false;
            }
        }

        @Override // c.i.b.a.d0.o
        public int f(c.i.b.a.l lVar, c.i.b.a.y.e eVar, boolean z) {
            InterceptResult invokeLLZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048579, this, lVar, eVar, z)) == null) {
                if (this.f29285i) {
                    return -3;
                }
                if (this.f29286j) {
                    eVar.l(4);
                    return -4;
                }
                int f2 = this.f29282f.f(lVar, eVar, z);
                if (f2 == -5) {
                    Format format = lVar.a;
                    lVar.a = format.copyWithGaplessInfo(this.f29283g != 0 ? 0 : format.encoderDelay, this.f29284h == Long.MIN_VALUE ? format.encoderPadding : 0);
                    return -5;
                }
                long j2 = this.f29284h;
                if (j2 != Long.MIN_VALUE && ((f2 == -4 && eVar.f30191h >= j2) || (f2 == -3 && this.f29281e.c() == Long.MIN_VALUE))) {
                    eVar.f();
                    eVar.l(4);
                    this.f29286j = true;
                    return -4;
                }
                if (f2 == -4 && !eVar.j()) {
                    eVar.f30191h -= this.f29283g;
                }
                return f2;
            }
            return invokeLLZ.intValue;
        }

        @Override // c.i.b.a.d0.o
        public boolean isReady() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f29282f.isReady() : invokeV.booleanValue;
        }

        @Override // c.i.b.a.d0.o
        public int j(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j2)) == null) ? this.f29282f.j(this.f29283g + j2) : invokeJ.intValue;
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
        this.f29275e = kVar;
        this.f29277g = -9223372036854775807L;
        this.f29278h = -9223372036854775807L;
        this.f29279i = new a[0];
        this.f29280j = z;
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
            this.f29276f.j(this);
        }
    }

    @Override // c.i.b.a.d0.k, c.i.b.a.d0.p
    public boolean b(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) ? this.f29275e.b(j2 + this.f29277g) : invokeJ.booleanValue;
    }

    @Override // c.i.b.a.d0.k, c.i.b.a.d0.p
    public long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            long c2 = this.f29275e.c();
            if (c2 != Long.MIN_VALUE) {
                long j2 = this.f29278h;
                if (j2 == Long.MIN_VALUE || c2 < j2) {
                    return Math.max(0L, c2 - this.f29277g);
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
            long d2 = this.f29275e.d();
            if (d2 != Long.MIN_VALUE) {
                long j2 = this.f29278h;
                if (j2 == Long.MIN_VALUE || d2 < j2) {
                    return d2 - this.f29277g;
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
            this.f29279i = new a[oVarArr.length];
            o[] oVarArr2 = new o[oVarArr.length];
            int i2 = 0;
            while (true) {
                o oVar = null;
                if (i2 >= oVarArr.length) {
                    break;
                }
                a[] aVarArr = this.f29279i;
                aVarArr[i2] = (a) oVarArr[i2];
                if (aVarArr[i2] != null) {
                    oVar = aVarArr[i2].f29282f;
                }
                oVarArr2[i2] = oVar;
                i2++;
            }
            long e2 = this.f29275e.e(fVarArr, zArr, oVarArr2, zArr2, j2 + this.f29277g);
            boolean z = true;
            if (this.f29280j) {
                this.f29280j = this.f29277g != 0 && m(fVarArr);
            }
            long j3 = this.f29277g;
            if (e2 != j2 + j3) {
                if (e2 >= j3) {
                    long j4 = this.f29278h;
                    if (j4 != Long.MIN_VALUE) {
                    }
                }
                z = false;
            }
            c.i.b.a.i0.a.f(z);
            for (int i3 = 0; i3 < oVarArr.length; i3++) {
                if (oVarArr2[i3] == null) {
                    this.f29279i[i3] = null;
                } else if (oVarArr[i3] == null || this.f29279i[i3].f29282f != oVarArr2[i3]) {
                    this.f29279i[i3] = new a(this, oVarArr2[i3], this.f29277g, this.f29278h, this.f29280j);
                }
                oVarArr[i3] = this.f29279i[i3];
            }
            return e2 - this.f29277g;
        }
        return invokeCommon.longValue;
    }

    public void f(long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            this.f29277g = j2;
            this.f29278h = j3;
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
            for (a aVar : this.f29279i) {
                if (aVar != null) {
                    aVar.d();
                }
            }
            long g2 = this.f29275e.g(this.f29277g + j2);
            long j3 = this.f29277g;
            if (g2 != j2 + j3) {
                if (g2 >= j3) {
                    long j4 = this.f29278h;
                    if (j4 != Long.MIN_VALUE) {
                    }
                }
                c.i.b.a.i0.a.f(z);
                return g2 - this.f29277g;
            }
            z = true;
            c.i.b.a.i0.a.f(z);
            return g2 - this.f29277g;
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
            if (this.f29280j) {
                for (a aVar : this.f29279i) {
                    if (aVar != null) {
                        aVar.c();
                    }
                }
                this.f29280j = false;
                long h2 = h();
                if (h2 != -9223372036854775807L) {
                    return h2;
                }
                return 0L;
            }
            long h3 = this.f29275e.h();
            if (h3 == -9223372036854775807L) {
                return -9223372036854775807L;
            }
            c.i.b.a.i0.a.f(h3 >= this.f29277g);
            long j2 = this.f29278h;
            c.i.b.a.i0.a.f((j2 == Long.MIN_VALUE || h3 <= j2) ? true : true);
            return h3 - this.f29277g;
        }
        return invokeV.longValue;
    }

    @Override // c.i.b.a.d0.k
    public t k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f29275e.k() : (t) invokeV.objValue;
    }

    @Override // c.i.b.a.d0.k.a
    public void l(k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, kVar) == null) {
            c.i.b.a.i0.a.f((this.f29277g == -9223372036854775807L || this.f29278h == -9223372036854775807L) ? false : true);
            this.f29276f.l(this);
        }
    }

    @Override // c.i.b.a.d0.k
    public void o(k.a aVar, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048587, this, aVar, j2) == null) {
            this.f29276f = aVar;
            this.f29275e.o(this, this.f29277g + j2);
        }
    }

    @Override // c.i.b.a.d0.k
    public void q() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f29275e.q();
        }
    }

    @Override // c.i.b.a.d0.k
    public void r(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048589, this, j2) == null) {
            this.f29275e.r(j2 + this.f29277g);
        }
    }
}
