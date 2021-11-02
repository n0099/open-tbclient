package b.a.p0.a.q2;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Locale;
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f7408a;

    /* renamed from: b  reason: collision with root package name */
    public long f7409b;

    /* renamed from: c  reason: collision with root package name */
    public long f7410c;

    /* renamed from: d  reason: collision with root package name */
    public String f7411d;

    /* renamed from: e  reason: collision with root package name */
    public String f7412e;

    /* renamed from: f  reason: collision with root package name */
    public final StringBuilder f7413f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f7414g;

    public a() {
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
        this.f7408a = 0L;
        this.f7409b = 0L;
        this.f7410c = 2L;
        this.f7411d = "";
        this.f7412e = "";
        this.f7413f = new StringBuilder();
        this.f7414g = false;
    }

    public long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (n() * 10000000) + (i() * 10000) + (g() * 1) : invokeV.longValue;
    }

    public a b(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
            o(j / 10000000);
            long j2 = j % 10000000;
            j(j2 / 10000);
            h((j2 % 10000) / 1);
            return this;
        }
        return (a) invokeJ.objValue;
    }

    public a c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (str == null) {
                str = "";
            }
            this.f7411d = str;
            return this;
        }
        return (a) invokeL.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f7411d : (String) invokeV.objValue;
    }

    public a e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            StringBuilder sb = this.f7413f;
            sb.append(str);
            sb.append(StringUtils.LF);
            return this;
        }
        return (a) invokeL.objValue;
    }

    public StringBuilder f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f7413f : (StringBuilder) invokeV.objValue;
    }

    public long g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f7409b : invokeV.longValue;
    }

    public a h(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048583, this, j)) == null) {
            this.f7409b = l(j, 9999L, "error");
            return this;
        }
        return (a) invokeJ.objValue;
    }

    public long i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f7408a : invokeV.longValue;
    }

    public a j(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048585, this, j)) == null) {
            this.f7408a = l(j, 999L, "feature");
            return this;
        }
        return (a) invokeJ.objValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f7414g : invokeV.booleanValue;
    }

    public final long l(long j, long j2, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), str})) == null) {
            boolean z = j < 0 || j > j2;
            if (z) {
                e("illegalFallback " + str + "::" + j);
            }
            return z ? j2 : j;
        }
        return invokeCommon.longValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f7414g = true;
        }
    }

    public long n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f7410c : invokeV.longValue;
    }

    public a o(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048590, this, j)) == null) {
            this.f7410c = l(j, 9L, com.tencent.connect.common.Constants.PARAM_PLATFORM);
            return this;
        }
        return (a) invokeJ.objValue;
    }

    public a p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            if (str == null) {
                str = "";
            }
            this.f7412e = str;
            return this;
        }
        return (a) invokeL.objValue;
    }

    public String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f7412e : (String) invokeV.objValue;
    }

    public String r(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i2)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(String.format(Locale.getDefault(), "%s :: code(%08d) desc(%s) \n", super.toString(), Long.valueOf(a()), Long.valueOf(n()), Long.valueOf(i()), Long.valueOf(g()), d()));
            if (i2 >= -200) {
                sb.append(String.format(Locale.getDefault(), "  p(%01d) f(%03d) e(%04d) \n", Long.valueOf(n()), Long.valueOf(i()), Long.valueOf(g())));
            }
            if (i2 >= -100) {
                sb.append(String.format(Locale.getDefault(), "  details(%s) \n", f()));
            }
            return sb.toString();
        }
        return (String) invokeI.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? r(-100) : (String) invokeV.objValue;
    }
}
