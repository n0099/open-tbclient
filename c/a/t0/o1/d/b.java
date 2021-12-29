package c.a.t0.o1.d;

import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static b f20797f;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public SparseArray<Long> f20798b;

    /* renamed from: c  reason: collision with root package name */
    public SparseArray<Long> f20799c;

    /* renamed from: d  reason: collision with root package name */
    public SparseArray<Long> f20800d;

    /* renamed from: e  reason: collision with root package name */
    public SparseArray<Long> f20801e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-420730620, "Lc/a/t0/o1/d/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-420730620, "Lc/a/t0/o1/d/b;");
                return;
            }
        }
        f20797f = new b();
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
        this.a = 0L;
        this.f20798b = new SparseArray<>();
        this.f20799c = new SparseArray<>();
        this.f20800d = new SparseArray<>();
        this.f20801e = new SparseArray<>();
    }

    public static b d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f20797f : (b) invokeV.objValue;
    }

    public long a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            Long l = this.f20799c.get(i2);
            if (l == null) {
                return -1L;
            }
            return l.longValue();
        }
        return invokeI.longValue;
    }

    public long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : invokeV.longValue;
    }

    public long c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            Long l = this.f20798b.get(i2);
            if (l == null) {
                return -1L;
            }
            return l.longValue();
        }
        return invokeI.longValue;
    }

    public long e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            Long l = this.f20801e.get(i2);
            if (l == null) {
                return -1L;
            }
            return l.longValue();
        }
        return invokeI.longValue;
    }

    public long f(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            Long l = this.f20800d.get(i2);
            if (l == null) {
                return -1L;
            }
            return l.longValue();
        }
        return invokeI.longValue;
    }

    public void g(long j2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
            this.f20799c.put(i2, Long.valueOf(j2));
        }
    }

    public void h(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j2) == null) {
            this.a = j2;
        }
    }

    public void i(long j2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
            this.f20798b.put(i2, Long.valueOf(j2));
        }
    }

    public void j(long j2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
            this.f20801e.put(i2, Long.valueOf(j2));
        }
    }

    public void k(long j2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
            this.f20800d.put(i2, Long.valueOf(j2));
        }
    }
}
