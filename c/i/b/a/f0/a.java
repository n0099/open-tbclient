package c.i.b.a.f0;

import android.os.SystemClock;
import c.i.b.a.d0.s;
import c.i.b.a.f0.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.net.BdNetTask;
import com.google.android.exoplayer2.Format;
/* loaded from: classes9.dex */
public class a extends b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public final c.i.b.a.h0.c f30438g;

    /* renamed from: h  reason: collision with root package name */
    public final int f30439h;

    /* renamed from: i  reason: collision with root package name */
    public final long f30440i;

    /* renamed from: j  reason: collision with root package name */
    public final long f30441j;

    /* renamed from: k  reason: collision with root package name */
    public final float f30442k;
    public final float l;
    public int m;
    public int n;

    /* renamed from: c.i.b.a.f0.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static final class C1646a implements f.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final c.i.b.a.h0.c a;

        /* renamed from: b  reason: collision with root package name */
        public final int f30443b;

        /* renamed from: c  reason: collision with root package name */
        public final int f30444c;

        /* renamed from: d  reason: collision with root package name */
        public final int f30445d;

        /* renamed from: e  reason: collision with root package name */
        public final int f30446e;

        /* renamed from: f  reason: collision with root package name */
        public final float f30447f;

        /* renamed from: g  reason: collision with root package name */
        public final float f30448g;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public C1646a(c.i.b.a.h0.c cVar) {
            this(cVar, 800000, 10000, BdNetTask.TIMEOUT_READ, BdNetTask.TIMEOUT_READ, 0.75f, 0.75f);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((c.i.b.a.h0.c) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), ((Integer) objArr2[4]).intValue(), ((Float) objArr2[5]).floatValue(), ((Float) objArr2[6]).floatValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.i.b.a.f0.f.a
        /* renamed from: b */
        public a a(s sVar, int... iArr) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sVar, iArr)) == null) ? new a(sVar, iArr, this.a, this.f30443b, this.f30444c, this.f30445d, this.f30446e, this.f30447f, this.f30448g) : (a) invokeLL.objValue;
        }

        public C1646a(c.i.b.a.h0.c cVar, int i2, int i3, int i4, int i5, float f2, float f3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Float.valueOf(f2), Float.valueOf(f3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i6 = newInitContext.flag;
                if ((i6 & 1) != 0) {
                    int i7 = i6 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = cVar;
            this.f30443b = i2;
            this.f30444c = i3;
            this.f30445d = i4;
            this.f30446e = i5;
            this.f30447f = f2;
            this.f30448g = f3;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(s sVar, int[] iArr, c.i.b.a.h0.c cVar, int i2, long j2, long j3, long j4, float f2, float f3) {
        super(sVar, iArr);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {sVar, iArr, cVar, Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Float.valueOf(f2), Float.valueOf(f3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((s) objArr2[0], (int[]) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f30438g = cVar;
        this.f30439h = i2;
        this.f30440i = j2 * 1000;
        this.f30441j = j3 * 1000;
        this.f30442k = f2;
        this.l = f3;
        this.m = n(Long.MIN_VALUE);
        this.n = 1;
    }

    @Override // c.i.b.a.f0.f
    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.m : invokeV.intValue;
    }

    @Override // c.i.b.a.f0.f
    public void i(long j2, long j3, long j4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)}) == null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            int i2 = this.m;
            int n = n(elapsedRealtime);
            this.m = n;
            if (n == i2) {
                return;
            }
            if (!m(i2, elapsedRealtime)) {
                Format h2 = h(i2);
                Format h3 = h(this.m);
                if (h3.bitrate > h2.bitrate && j3 < o(j4)) {
                    this.m = i2;
                } else if (h3.bitrate < h2.bitrate && j3 >= this.f30441j) {
                    this.m = i2;
                }
            }
            if (this.m != i2) {
                this.n = 3;
            }
        }
    }

    @Override // c.i.b.a.f0.f
    public Object j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return invokeV.objValue;
    }

    @Override // c.i.b.a.f0.f
    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.n : invokeV.intValue;
    }

    public final int n(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048580, this, j2)) == null) {
            long c2 = this.f30438g.c();
            long j3 = c2 == -1 ? this.f30439h : ((float) c2) * this.f30442k;
            int i2 = 0;
            for (int i3 = 0; i3 < this.f30449b; i3++) {
                if (j2 == Long.MIN_VALUE || !m(i3, j2)) {
                    if (h(i3).bitrate <= j3) {
                        return i3;
                    }
                    i2 = i3;
                }
            }
            return i2;
        }
        return invokeJ.intValue;
    }

    public final long o(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j2)) == null) {
            return (j2 > (-9223372036854775807L) ? 1 : (j2 == (-9223372036854775807L) ? 0 : -1)) != 0 && (j2 > this.f30440i ? 1 : (j2 == this.f30440i ? 0 : -1)) <= 0 ? ((float) j2) * this.l : this.f30440i;
        }
        return invokeJ.longValue;
    }
}
