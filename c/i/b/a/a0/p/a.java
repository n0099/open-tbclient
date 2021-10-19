package c.i.b.a.a0.p;

import c.i.b.a.a0.p.b;
import c.i.b.a.i0.v;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public final class a implements b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final long f32557a;

    /* renamed from: b  reason: collision with root package name */
    public final int f32558b;

    /* renamed from: c  reason: collision with root package name */
    public final long f32559c;

    public a(long j2, int i2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j2), Integer.valueOf(i2), Long.valueOf(j3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f32557a = j2;
        this.f32558b = i2;
        this.f32559c = j3 == -1 ? -9223372036854775807L : g(j3);
    }

    @Override // c.i.b.a.a0.l
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f32559c != -9223372036854775807L : invokeV.booleanValue;
    }

    @Override // c.i.b.a.a0.l
    public long c(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
            long j3 = this.f32559c;
            if (j3 == -9223372036854775807L) {
                return 0L;
            }
            return this.f32557a + ((v.l(j2, 0L, j3) * this.f32558b) / 8000000);
        }
        return invokeJ.longValue;
    }

    @Override // c.i.b.a.a0.p.b.a
    public long g(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2)) == null) ? ((Math.max(0L, j2 - this.f32557a) * 1000000) * 8) / this.f32558b : invokeJ.longValue;
    }

    @Override // c.i.b.a.a0.l
    public long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f32559c : invokeV.longValue;
    }
}
