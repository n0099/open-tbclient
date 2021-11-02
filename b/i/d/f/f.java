package b.i.d.f;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.math.Stats;
import com.google.common.primitives.Doubles;
import java.util.Iterator;
/* loaded from: classes6.dex */
public final class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f33082a;

    /* renamed from: b  reason: collision with root package name */
    public double f33083b;

    /* renamed from: c  reason: collision with root package name */
    public double f33084c;

    /* renamed from: d  reason: collision with root package name */
    public double f33085d;

    /* renamed from: e  reason: collision with root package name */
    public double f33086e;

    public f() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f33082a = 0L;
        this.f33083b = 0.0d;
        this.f33084c = 0.0d;
        this.f33085d = Double.NaN;
        this.f33086e = Double.NaN;
    }

    public static double g(double d2, double d3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Double.valueOf(d2), Double.valueOf(d3)})) == null) {
            if (Doubles.f(d2)) {
                return d3;
            }
            if (Doubles.f(d3) || d2 == d3) {
                return d2;
            }
            return Double.NaN;
        }
        return invokeCommon.doubleValue;
    }

    public void a(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Double.valueOf(d2)}) == null) {
            long j = this.f33082a;
            if (j == 0) {
                this.f33082a = 1L;
                this.f33083b = d2;
                this.f33085d = d2;
                this.f33086e = d2;
                if (Doubles.f(d2)) {
                    return;
                }
                this.f33084c = Double.NaN;
                return;
            }
            this.f33082a = j + 1;
            if (Doubles.f(d2) && Doubles.f(this.f33083b)) {
                double d3 = this.f33083b;
                double d4 = d2 - d3;
                double d5 = d3 + (d4 / this.f33082a);
                this.f33083b = d5;
                this.f33084c += d4 * (d2 - d5);
            } else {
                this.f33083b = g(this.f33083b, d2);
                this.f33084c = Double.NaN;
            }
            this.f33085d = Math.min(this.f33085d, d2);
            this.f33086e = Math.max(this.f33086e, d2);
        }
    }

    public void b(Iterable<? extends Number> iterable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iterable) == null) {
            for (Number number : iterable) {
                a(number.doubleValue());
            }
        }
    }

    public void c(Iterator<? extends Number> it) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, it) == null) {
            while (it.hasNext()) {
                a(it.next().doubleValue());
            }
        }
    }

    public void d(double... dArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, dArr) == null) {
            for (double d2 : dArr) {
                a(d2);
            }
        }
    }

    public void e(int... iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, iArr) == null) {
            for (int i2 : iArr) {
                a(i2);
            }
        }
    }

    public void f(long... jArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jArr) == null) {
            for (long j : jArr) {
                a(j);
            }
        }
    }

    public Stats h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new Stats(this.f33082a, this.f33083b, this.f33084c, this.f33085d, this.f33086e) : (Stats) invokeV.objValue;
    }
}
