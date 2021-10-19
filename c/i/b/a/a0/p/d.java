package c.i.b.a.a0.p;

import c.i.b.a.a0.j;
import c.i.b.a.a0.p.b;
import c.i.b.a.i0.l;
import c.i.b.a.i0.v;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public final class d implements b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final long f32573a;

    /* renamed from: b  reason: collision with root package name */
    public final long f32574b;

    /* renamed from: c  reason: collision with root package name */
    public final long f32575c;

    /* renamed from: d  reason: collision with root package name */
    public final long[] f32576d;

    /* renamed from: e  reason: collision with root package name */
    public final long f32577e;

    /* renamed from: f  reason: collision with root package name */
    public final int f32578f;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public d(long j2, long j3, long j4) {
        this(j2, j3, j4, null, 0L, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Long) objArr2[0]).longValue(), ((Long) objArr2[1]).longValue(), ((Long) objArr2[2]).longValue(), (long[]) objArr2[3], ((Long) objArr2[4]).longValue(), ((Integer) objArr2[5]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static d a(j jVar, l lVar, long j2, long j3) {
        InterceptResult invokeCommon;
        int B;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{jVar, lVar, Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            int i2 = jVar.f32494g;
            int i3 = jVar.f32491d;
            long j4 = j2 + jVar.f32490c;
            int i4 = lVar.i();
            if ((i4 & 1) != 1 || (B = lVar.B()) == 0) {
                return null;
            }
            long F = v.F(B, i2 * 1000000, i3);
            if ((i4 & 6) != 6) {
                return new d(j4, F, j3);
            }
            long B2 = lVar.B();
            lVar.K(1);
            long[] jArr = new long[99];
            for (int i5 = 0; i5 < 99; i5++) {
                jArr[i5] = lVar.x();
            }
            return new d(j4, F, j3, jArr, B2, jVar.f32490c);
        }
        return (d) invokeCommon.objValue;
    }

    @Override // c.i.b.a.a0.l
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f32576d != null : invokeV.booleanValue;
    }

    @Override // c.i.b.a.a0.l
    public long c(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
            if (!b()) {
                return this.f32573a;
            }
            float f2 = (((float) j2) * 100.0f) / ((float) this.f32574b);
            if (f2 <= 0.0f) {
                r0 = 0.0f;
            } else if (f2 < 100.0f) {
                int i2 = (int) f2;
                float f3 = i2 != 0 ? (float) this.f32576d[i2 - 1] : 0.0f;
                r0 = (((i2 < 99 ? (float) this.f32576d[i2] : 256.0f) - f3) * (f2 - i2)) + f3;
            }
            long round = Math.round(r0 * 0.00390625d * this.f32577e);
            long j3 = this.f32573a;
            long j4 = round + j3;
            long j5 = this.f32575c;
            return Math.min(j4, j5 != -1 ? j5 - 1 : ((j3 - this.f32578f) + this.f32577e) - 1);
        }
        return invokeJ.longValue;
    }

    public final long d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? (this.f32574b * i2) / 100 : invokeI.longValue;
    }

    @Override // c.i.b.a.a0.p.b.a
    public long g(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j2)) == null) {
            if (b()) {
                long j3 = this.f32573a;
                if (j2 >= j3) {
                    double d2 = ((j2 - j3) * 256.0d) / this.f32577e;
                    int e2 = v.e(this.f32576d, (long) d2, true, false) + 1;
                    long d3 = d(e2);
                    long j4 = e2 == 0 ? 0L : this.f32576d[e2 - 1];
                    long j5 = e2 == 99 ? 256L : this.f32576d[e2];
                    return d3 + (j5 != j4 ? (long) (((d(e2 + 1) - d3) * (d2 - j4)) / (j5 - j4)) : 0L);
                }
            }
            return 0L;
        }
        return invokeJ.longValue;
    }

    @Override // c.i.b.a.a0.l
    public long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f32574b : invokeV.longValue;
    }

    public d(long j2, long j3, long j4, long[] jArr, long j5, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), jArr, Long.valueOf(j5), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f32573a = j2;
        this.f32574b = j3;
        this.f32575c = j4;
        this.f32576d = jArr;
        this.f32577e = j5;
        this.f32578f = i2;
    }
}
