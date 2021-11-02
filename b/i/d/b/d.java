package b.i.d.b;

import androidx.core.view.InputDeviceCompat;
import b.i.d.a.j;
import b.i.d.a.k;
import b.i.d.a.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final long f32991a;

    /* renamed from: b  reason: collision with root package name */
    public final long f32992b;

    /* renamed from: c  reason: collision with root package name */
    public final long f32993c;

    /* renamed from: d  reason: collision with root package name */
    public final long f32994d;

    /* renamed from: e  reason: collision with root package name */
    public final long f32995e;

    /* renamed from: f  reason: collision with root package name */
    public final long f32996f;

    public d(long j, long j2, long j3, long j4, long j5, long j6) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(j6)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        n.d(j >= 0);
        n.d(j2 >= 0);
        n.d(j3 >= 0);
        n.d(j4 >= 0);
        n.d(j5 >= 0);
        n.d(j6 >= 0);
        this.f32991a = j;
        this.f32992b = j2;
        this.f32993c = j3;
        this.f32994d = j4;
        this.f32995e = j5;
        this.f32996f = j6;
    }

    public long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f32996f : invokeV.longValue;
    }

    public long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f32991a : invokeV.longValue;
    }

    public long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f32994d : invokeV.longValue;
    }

    public long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f32993c : invokeV.longValue;
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f32992b : invokeV.longValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (obj instanceof d) {
                d dVar = (d) obj;
                return this.f32991a == dVar.f32991a && this.f32992b == dVar.f32992b && this.f32993c == dVar.f32993c && this.f32994d == dVar.f32994d && this.f32995e == dVar.f32995e && this.f32996f == dVar.f32996f;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public long f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f32995e : invokeV.longValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? k.b(Long.valueOf(this.f32991a), Long.valueOf(this.f32992b), Long.valueOf(this.f32993c), Long.valueOf(this.f32994d), Long.valueOf(this.f32995e), Long.valueOf(this.f32996f)) : invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            j.b c2 = b.i.d.a.j.c(this);
            c2.c("hitCount", this.f32991a);
            c2.c("missCount", this.f32992b);
            c2.c("loadSuccessCount", this.f32993c);
            c2.c("loadExceptionCount", this.f32994d);
            c2.c("totalLoadTime", this.f32995e);
            c2.c("evictionCount", this.f32996f);
            return c2.toString();
        }
        return (String) invokeV.objValue;
    }
}
