package c.a.r0.p2;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static b f23246h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f23247a;

    /* renamed from: b  reason: collision with root package name */
    public long f23248b;

    /* renamed from: c  reason: collision with root package name */
    public long f23249c;

    /* renamed from: d  reason: collision with root package name */
    public long f23250d;

    /* renamed from: e  reason: collision with root package name */
    public long f23251e;

    /* renamed from: f  reason: collision with root package name */
    public long f23252f;

    /* renamed from: g  reason: collision with root package name */
    public long f23253g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1793101211, "Lc/a/r0/p2/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1793101211, "Lc/a/r0/p2/b;");
                return;
            }
        }
        f23246h = new b();
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f23247a = 0L;
        this.f23248b = 0L;
        this.f23249c = 0L;
        this.f23250d = 0L;
        this.f23251e = 0L;
        this.f23252f = 0L;
        this.f23253g = 0L;
    }

    public static b d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f23246h : (b) invokeV.objValue;
    }

    public long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f23251e : invokeV.longValue;
    }

    public long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f23247a : invokeV.longValue;
    }

    public long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f23250d : invokeV.longValue;
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f23248b : invokeV.longValue;
    }

    public long f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f23249c : invokeV.longValue;
    }

    public long g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f23253g : invokeV.longValue;
    }

    public long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f23252f : invokeV.longValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f23247a = 0L;
            this.f23248b = 0L;
            this.f23249c = 0L;
            this.f23250d = 0L;
            this.f23251e = 0L;
            this.f23252f = 0L;
            this.f23253g = 0L;
        }
    }

    public void j(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j2) == null) {
            this.f23251e = j2;
        }
    }

    public void k(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048585, this, j2) == null) {
            this.f23247a = j2;
        }
    }

    public void l(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048586, this, j2) == null) {
            this.f23250d = j2;
        }
    }

    public void m(long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(1048587, this, j2) == null) && this.f23248b == 0) {
            this.f23248b = j2;
        }
    }

    public void n(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048588, this, j2) == null) {
            this.f23249c = j2;
        }
    }

    public void o(long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(1048589, this, j2) == null) && this.f23253g == 0) {
            this.f23253g = j2;
        }
    }

    public void p(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048590, this, j2) == null) {
            this.f23252f = j2;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(" beginTime:");
            stringBuffer.append(this.f23251e);
            stringBuffer.append(" creatTime:");
            stringBuffer.append(this.f23247a);
            stringBuffer.append(" refreshStartTime:");
            stringBuffer.append(this.f23253g);
            stringBuffer.append(" refrehTime:");
            stringBuffer.append(this.f23252f);
            stringBuffer.append(" drawTime:");
            stringBuffer.append(this.f23250d);
            stringBuffer.append(" profileTime:");
            stringBuffer.append(this.f23249c);
            return stringBuffer.toString();
        }
        return (String) invokeV.objValue;
    }
}
