package c.i.b.a.d0;

import c.i.b.a.w;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public final class r extends w {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: j  reason: collision with root package name */
    public static final Object f33147j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final long f33148b;

    /* renamed from: c  reason: collision with root package name */
    public final long f33149c;

    /* renamed from: d  reason: collision with root package name */
    public final long f33150d;

    /* renamed from: e  reason: collision with root package name */
    public final long f33151e;

    /* renamed from: f  reason: collision with root package name */
    public final long f33152f;

    /* renamed from: g  reason: collision with root package name */
    public final long f33153g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f33154h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f33155i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-721714125, "Lc/i/b/a/d0/r;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-721714125, "Lc/i/b/a/d0/r;");
                return;
            }
        }
        f33147j = new Object();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public r(long j2, boolean z) {
        this(j2, j2, 0L, 0L, z, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {Long.valueOf(j2), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Long) objArr2[0]).longValue(), ((Long) objArr2[1]).longValue(), ((Long) objArr2[2]).longValue(), ((Long) objArr2[3]).longValue(), ((Boolean) objArr2[4]).booleanValue(), ((Boolean) objArr2[5]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    @Override // c.i.b.a.w
    public int b(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) ? f33147j.equals(obj) ? 0 : -1 : invokeL.intValue;
    }

    @Override // c.i.b.a.w
    public w.b g(int i2, w.b bVar, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), bVar, Boolean.valueOf(z)})) == null) {
            c.i.b.a.i0.a.c(i2, 0, 1);
            Object obj = z ? f33147j : null;
            bVar.n(obj, obj, 0, this.f33150d, -this.f33152f);
            return bVar;
        }
        return (w.b) invokeCommon.objValue;
    }

    @Override // c.i.b.a.w
    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // c.i.b.a.w
    public w.c n(int i2, w.c cVar, boolean z, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), cVar, Boolean.valueOf(z), Long.valueOf(j2)})) == null) {
            c.i.b.a.i0.a.c(i2, 0, 1);
            Object obj = z ? f33147j : null;
            long j3 = this.f33153g;
            if (this.f33155i) {
                j3 += j2;
                if (j3 > this.f33151e) {
                    j3 = -9223372036854775807L;
                }
            }
            cVar.d(obj, this.f33148b, this.f33149c, this.f33154h, this.f33155i, j3, this.f33151e, 0, 0, this.f33152f);
            return cVar;
        }
        return (w.c) invokeCommon.objValue;
    }

    @Override // c.i.b.a.w
    public int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public r(long j2, long j3, long j4, long j5, boolean z, boolean z2) {
        this(-9223372036854775807L, -9223372036854775807L, j2, j3, j4, j5, z, z2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), Boolean.valueOf(z), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Long) objArr2[0]).longValue(), ((Long) objArr2[1]).longValue(), ((Long) objArr2[2]).longValue(), ((Long) objArr2[3]).longValue(), ((Long) objArr2[4]).longValue(), ((Long) objArr2[5]).longValue(), ((Boolean) objArr2[6]).booleanValue(), ((Boolean) objArr2[7]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public r(long j2, long j3, long j4, long j5, long j6, long j7, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r4;
            Object[] objArr = {Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(j6), Long.valueOf(j7), Boolean.valueOf(z), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f33148b = j2;
        this.f33149c = j3;
        this.f33150d = j4;
        this.f33151e = j5;
        this.f33152f = j6;
        this.f33153g = j7;
        this.f33154h = z;
        this.f33155i = z2;
    }
}
