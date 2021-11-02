package b.i.b.a.d0.v;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class e implements d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final b.i.b.a.a0.a f32068a;

    public e(b.i.b.a.a0.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f32068a = aVar;
    }

    @Override // b.i.b.a.d0.v.d
    public long a(int i2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j)})) == null) ? this.f32068a.f31343d[i2] : invokeCommon.longValue;
    }

    @Override // b.i.b.a.d0.v.d
    public int b(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) ? this.f32068a.a(j) : invokeCommon.intValue;
    }

    @Override // b.i.b.a.d0.v.d
    public int c(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j)) == null) ? this.f32068a.f31340a : invokeJ.intValue;
    }

    @Override // b.i.b.a.d0.v.d
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // b.i.b.a.d0.v.d
    public b.i.b.a.d0.v.g.f e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            b.i.b.a.a0.a aVar = this.f32068a;
            return new b.i.b.a.d0.v.g.f(null, aVar.f31342c[i2], aVar.f31341b[i2]);
        }
        return (b.i.b.a.d0.v.g.f) invokeI.objValue;
    }

    @Override // b.i.b.a.d0.v.d
    public long f(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) ? this.f32068a.f31344e[i2] : invokeI.longValue;
    }

    @Override // b.i.b.a.d0.v.d
    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }
}
