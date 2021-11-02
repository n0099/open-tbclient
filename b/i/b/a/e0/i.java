package b.i.b.a.e0;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public abstract class i extends b.i.b.a.y.f implements e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public e f32285h;

    /* renamed from: i  reason: collision with root package name */
    public long f32286i;

    public i() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // b.i.b.a.e0.e
    public long a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? this.f32285h.a(i2) + this.f32286i : invokeI.longValue;
    }

    @Override // b.i.b.a.e0.e
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f32285h.b() : invokeV.intValue;
    }

    @Override // b.i.b.a.e0.e
    public int c(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j)) == null) ? this.f32285h.c(j - this.f32286i) : invokeJ.intValue;
    }

    @Override // b.i.b.a.e0.e
    public List<b> d(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j)) == null) ? this.f32285h.d(j - this.f32286i) : (List) invokeJ.objValue;
    }

    @Override // b.i.b.a.y.a
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.f();
            this.f32285h = null;
        }
    }

    public abstract void m();

    public void n(long j, e eVar, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Long.valueOf(j), eVar, Long.valueOf(j2)}) == null) {
            this.f32904f = j;
            this.f32285h = eVar;
            if (j2 != Long.MAX_VALUE) {
                j = j2;
            }
            this.f32286i = j;
        }
    }
}
