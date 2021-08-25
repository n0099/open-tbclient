package c.i.b.a.a0.u;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final int f32850a;

    /* renamed from: b  reason: collision with root package name */
    public final int f32851b;

    /* renamed from: c  reason: collision with root package name */
    public final int f32852c;

    /* renamed from: d  reason: collision with root package name */
    public final int f32853d;

    /* renamed from: e  reason: collision with root package name */
    public final int f32854e;

    /* renamed from: f  reason: collision with root package name */
    public final int f32855f;

    /* renamed from: g  reason: collision with root package name */
    public long f32856g;

    /* renamed from: h  reason: collision with root package name */
    public long f32857h;

    public b(int i2, int i3, int i4, int i5, int i6, int i7) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i8 = newInitContext.flag;
            if ((i8 & 1) != 0) {
                int i9 = i8 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f32850a = i2;
        this.f32851b = i3;
        this.f32852c = i4;
        this.f32853d = i5;
        this.f32854e = i6;
        this.f32855f = i7;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f32851b * this.f32854e * this.f32850a : invokeV.intValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f32853d : invokeV.intValue;
    }

    public long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? ((this.f32857h / this.f32853d) * 1000000) / this.f32851b : invokeV.longValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f32855f : invokeV.intValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f32850a : invokeV.intValue;
    }

    public long f(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j2)) == null) {
            int i2 = this.f32853d;
            return Math.min((((j2 * this.f32852c) / 1000000) / i2) * i2, this.f32857h - i2) + this.f32856g;
        }
        return invokeJ.longValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f32851b : invokeV.intValue;
    }

    public long h(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048583, this, j2)) == null) ? (j2 * 1000000) / this.f32852c : invokeJ.longValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? (this.f32856g == 0 || this.f32857h == 0) ? false : true : invokeV.booleanValue;
    }

    public void j(long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            this.f32856g = j2;
            this.f32857h = j3;
        }
    }
}
