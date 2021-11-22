package b.h.b.a.a0.p;

import b.h.b.a.a0.j;
import b.h.b.a.a0.p.b;
import b.h.b.a.i0.l;
import b.h.b.a.i0.v;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class d implements b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final long f32305a;

    /* renamed from: b  reason: collision with root package name */
    public final long f32306b;

    /* renamed from: c  reason: collision with root package name */
    public final long f32307c;

    /* renamed from: d  reason: collision with root package name */
    public final long[] f32308d;

    /* renamed from: e  reason: collision with root package name */
    public final long f32309e;

    /* renamed from: f  reason: collision with root package name */
    public final int f32310f;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public d(long j, long j2, long j3) {
        this(j, j2, j3, null, 0L, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)};
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

    public static d a(j jVar, l lVar, long j, long j2) {
        InterceptResult invokeCommon;
        int B;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{jVar, lVar, Long.valueOf(j), Long.valueOf(j2)})) == null) {
            int i2 = jVar.f32230g;
            int i3 = jVar.f32227d;
            long j3 = j + jVar.f32226c;
            int i4 = lVar.i();
            if ((i4 & 1) != 1 || (B = lVar.B()) == 0) {
                return null;
            }
            long F = v.F(B, i2 * 1000000, i3);
            if ((i4 & 6) != 6) {
                return new d(j3, F, j2);
            }
            long B2 = lVar.B();
            lVar.K(1);
            long[] jArr = new long[99];
            for (int i5 = 0; i5 < 99; i5++) {
                jArr[i5] = lVar.x();
            }
            return new d(j3, F, j2, jArr, B2, jVar.f32226c);
        }
        return (d) invokeCommon.objValue;
    }

    @Override // b.h.b.a.a0.l
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f32308d != null : invokeV.booleanValue;
    }

    @Override // b.h.b.a.a0.l
    public long c(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
            if (!b()) {
                return this.f32305a;
            }
            float f2 = (((float) j) * 100.0f) / ((float) this.f32306b);
            if (f2 <= 0.0f) {
                r0 = 0.0f;
            } else if (f2 < 100.0f) {
                int i2 = (int) f2;
                float f3 = i2 != 0 ? (float) this.f32308d[i2 - 1] : 0.0f;
                r0 = (((i2 < 99 ? (float) this.f32308d[i2] : 256.0f) - f3) * (f2 - i2)) + f3;
            }
            long round = Math.round(r0 * 0.00390625d * this.f32309e);
            long j2 = this.f32305a;
            long j3 = round + j2;
            long j4 = this.f32307c;
            return Math.min(j3, j4 != -1 ? j4 - 1 : ((j2 - this.f32310f) + this.f32309e) - 1);
        }
        return invokeJ.longValue;
    }

    public final long d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? (this.f32306b * i2) / 100 : invokeI.longValue;
    }

    @Override // b.h.b.a.a0.p.b.a
    public long g(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j)) == null) {
            if (b()) {
                long j2 = this.f32305a;
                if (j >= j2) {
                    double d2 = ((j - j2) * 256.0d) / this.f32309e;
                    int e2 = v.e(this.f32308d, (long) d2, true, false) + 1;
                    long d3 = d(e2);
                    long j3 = e2 == 0 ? 0L : this.f32308d[e2 - 1];
                    long j4 = e2 == 99 ? 256L : this.f32308d[e2];
                    return d3 + (j4 != j3 ? (long) (((d(e2 + 1) - d3) * (d2 - j3)) / (j4 - j3)) : 0L);
                }
            }
            return 0L;
        }
        return invokeJ.longValue;
    }

    @Override // b.h.b.a.a0.l
    public long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f32306b : invokeV.longValue;
    }

    public d(long j, long j2, long j3, long[] jArr, long j4, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), jArr, Long.valueOf(j4), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f32305a = j;
        this.f32306b = j2;
        this.f32307c = j3;
        this.f32308d = jArr;
        this.f32309e = j4;
        this.f32310f = i2;
    }
}
