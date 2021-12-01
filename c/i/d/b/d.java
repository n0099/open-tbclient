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
/* loaded from: classes7.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final long a;

    /* renamed from: b  reason: collision with root package name */
    public final long f30554b;

    /* renamed from: c  reason: collision with root package name */
    public final long f30555c;

    /* renamed from: d  reason: collision with root package name */
    public final long f30556d;

    /* renamed from: e  reason: collision with root package name */
    public final long f30557e;

    /* renamed from: f  reason: collision with root package name */
    public final long f30558f;

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
        this.a = j2;
        this.f30554b = j3;
        this.f30555c = j4;
        this.f30556d = j5;
        this.f30557e = j6;
        this.f30558f = j7;
    }

    public long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f30558f : invokeV.longValue;
    }

    public long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : invokeV.longValue;
    }

    public long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f30556d : invokeV.longValue;
    }

    public long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f30555c : invokeV.longValue;
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f30554b : invokeV.longValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (obj instanceof d) {
                d dVar = (d) obj;
                return this.a == dVar.a && this.f30554b == dVar.f30554b && this.f30555c == dVar.f30555c && this.f30556d == dVar.f30556d && this.f30557e == dVar.f30557e && this.f30558f == dVar.f30558f;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public long f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f30557e : invokeV.longValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? k.b(Long.valueOf(this.a), Long.valueOf(this.f30554b), Long.valueOf(this.f30555c), Long.valueOf(this.f30556d), Long.valueOf(this.f30557e), Long.valueOf(this.f30558f)) : invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            j.b c2 = c.i.d.a.j.c(this);
            c2.c("hitCount", this.a);
            c2.c("missCount", this.f30554b);
            c2.c("loadSuccessCount", this.f30555c);
            c2.c("loadExceptionCount", this.f30556d);
            c2.c("totalLoadTime", this.f30557e);
            c2.c("evictionCount", this.f30558f);
            return c2.toString();
        }
        return (String) invokeV.objValue;
    }
}
