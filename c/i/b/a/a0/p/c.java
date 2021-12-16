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
import com.googlecode.mp4parser.authoring.tracks.MP3TrackImpl;
/* loaded from: classes9.dex */
public final class c implements b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final long[] a;

    /* renamed from: b  reason: collision with root package name */
    public final long[] f29458b;

    /* renamed from: c  reason: collision with root package name */
    public final long f29459c;

    public c(long[] jArr, long[] jArr2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jArr, jArr2, Long.valueOf(j2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = jArr;
        this.f29458b = jArr2;
        this.f29459c = j2;
    }

    public static c a(j jVar, l lVar, long j2, long j3) {
        InterceptResult invokeCommon;
        int x;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{jVar, lVar, Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            lVar.K(10);
            int i2 = lVar.i();
            if (i2 <= 0) {
                return null;
            }
            int i3 = jVar.f29388d;
            long F = v.F(i2, 1000000 * (i3 >= 32000 ? MP3TrackImpl.SAMPLES_PER_FRAME : 576), i3);
            int D = lVar.D();
            int D2 = lVar.D();
            int D3 = lVar.D();
            int i4 = 2;
            lVar.K(2);
            long j4 = j2 + jVar.f29387c;
            int i5 = D + 1;
            long[] jArr = new long[i5];
            long[] jArr2 = new long[i5];
            jArr[0] = 0;
            jArr2[0] = j4;
            int i6 = 1;
            while (i6 < i5) {
                if (D3 == 1) {
                    x = lVar.x();
                } else if (D3 == i4) {
                    x = lVar.D();
                } else if (D3 == 3) {
                    x = lVar.A();
                } else if (D3 != 4) {
                    return null;
                } else {
                    x = lVar.B();
                }
                int i7 = i5;
                j4 += x * D2;
                int i8 = D2;
                int i9 = D3;
                jArr[i6] = (i6 * F) / D;
                jArr2[i6] = j3 == -1 ? j4 : Math.min(j3, j4);
                i6++;
                i5 = i7;
                D2 = i8;
                D3 = i9;
                i4 = 2;
            }
            return new c(jArr, jArr2, F);
        }
        return (c) invokeCommon.objValue;
    }

    @Override // c.i.b.a.a0.l
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // c.i.b.a.a0.l
    public long c(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) ? this.f29458b[v.e(this.a, j2, true, true)] : invokeJ.longValue;
    }

    @Override // c.i.b.a.a0.p.b.a
    public long g(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2)) == null) ? this.a[v.e(this.f29458b, j2, true, true)] : invokeJ.longValue;
    }

    @Override // c.i.b.a.a0.l
    public long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f29459c : invokeV.longValue;
    }
}
