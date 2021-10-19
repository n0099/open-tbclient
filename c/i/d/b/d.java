package c.i.d.b;

import androidx.core.view.InputDeviceCompat;
import c.i.d.a.j;
import c.i.d.a.k;
import c.i.d.a.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final long f34207a;

    /* renamed from: b  reason: collision with root package name */
    public final long f34208b;

    /* renamed from: c  reason: collision with root package name */
    public final long f34209c;

    /* renamed from: d  reason: collision with root package name */
    public final long f34210d;

    /* renamed from: e  reason: collision with root package name */
    public final long f34211e;

    /* renamed from: f  reason: collision with root package name */
    public final long f34212f;

    public d(long j2, long j3, long j4, long j5, long j6, long j7) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(j6), Long.valueOf(j7)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        n.d(j2 >= 0);
        n.d(j3 >= 0);
        n.d(j4 >= 0);
        n.d(j5 >= 0);
        n.d(j6 >= 0);
        n.d(j7 >= 0);
        this.f34207a = j2;
        this.f34208b = j3;
        this.f34209c = j4;
        this.f34210d = j5;
        this.f34211e = j6;
        this.f34212f = j7;
    }

    public long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f34212f : invokeV.longValue;
    }

    public long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f34207a : invokeV.longValue;
    }

    public long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f34210d : invokeV.longValue;
    }

    public long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f34209c : invokeV.longValue;
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f34208b : invokeV.longValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (obj instanceof d) {
                d dVar = (d) obj;
                return this.f34207a == dVar.f34207a && this.f34208b == dVar.f34208b && this.f34209c == dVar.f34209c && this.f34210d == dVar.f34210d && this.f34211e == dVar.f34211e && this.f34212f == dVar.f34212f;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public long f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f34211e : invokeV.longValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? k.b(Long.valueOf(this.f34207a), Long.valueOf(this.f34208b), Long.valueOf(this.f34209c), Long.valueOf(this.f34210d), Long.valueOf(this.f34211e), Long.valueOf(this.f34212f)) : invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            j.b c2 = c.i.d.a.j.c(this);
            c2.c("hitCount", this.f34207a);
            c2.c("missCount", this.f34208b);
            c2.c("loadSuccessCount", this.f34209c);
            c2.c("loadExceptionCount", this.f34210d);
            c2.c("totalLoadTime", this.f34211e);
            c2.c("evictionCount", this.f34212f);
            return c2.toString();
        }
        return (String) invokeV.objValue;
    }
}
