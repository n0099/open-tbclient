package c.a.r0.a.u2;

import android.text.TextUtils;
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
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public long f9587b;

    /* renamed from: c  reason: collision with root package name */
    public long f9588c;

    /* renamed from: d  reason: collision with root package name */
    public String f9589d;

    /* renamed from: e  reason: collision with root package name */
    public String f9590e;

    /* renamed from: f  reason: collision with root package name */
    public final StringBuilder f9591f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f9592g;

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
        this.a = 0L;
        this.f9587b = 0L;
        this.f9588c = 2L;
        this.f9589d = "";
        this.f9590e = "";
        this.f9591f = new StringBuilder();
        this.f9592g = false;
    }

    public long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (o() * 10000000) + (j() * 10000) + (h() * 1) : invokeV.longValue;
    }

    public a b(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
            p(j2 / 10000000);
            long j3 = j2 % 10000000;
            k(j3 / 10000);
            i((j3 % 10000) / 1);
            return this;
        }
        return (a) invokeJ.objValue;
    }

    public a c(c.a.r0.q.i.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar)) == null) {
            if (bVar != null) {
                i(bVar.a);
                d(bVar.f11626b);
                q(bVar.f11629e);
                if (!TextUtils.isEmpty(bVar.f11628d)) {
                    f(bVar.f11628d);
                }
            }
            return this;
        }
        return (a) invokeL.objValue;
    }

    public a d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (str == null) {
                str = "";
            }
            this.f9589d = str;
            return this;
        }
        return (a) invokeL.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f9589d : (String) invokeV.objValue;
    }

    public a f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            StringBuilder sb = this.f9591f;
            sb.append(str);
            sb.append(StringUtils.LF);
            return this;
        }
        return (a) invokeL.objValue;
    }

    public StringBuilder g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f9591f : (StringBuilder) invokeV.objValue;
    }

    public long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f9587b : invokeV.longValue;
    }

    public a i(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j2)) == null) {
            this.f9587b = m(j2, 9999L, "error");
            return this;
        }
        return (a) invokeJ.objValue;
    }

    public long j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.a : invokeV.longValue;
    }

    public a k(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048586, this, j2)) == null) {
            this.a = m(j2, 999L, "feature");
            return this;
        }
        return (a) invokeJ.objValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f9592g : invokeV.booleanValue;
    }

    public final long m(long j2, long j3, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), str})) == null) {
            boolean z = j2 < 0 || j2 > j3;
            if (z) {
                f("illegalFallback " + str + "::" + j2);
            }
            return z ? j3 : j2;
        }
        return invokeCommon.longValue;
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f9592g = true;
        }
    }

    public long o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f9588c : invokeV.longValue;
    }

    public a p(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048591, this, j2)) == null) {
            this.f9588c = m(j2, 9L, com.tencent.connect.common.Constants.PARAM_PLATFORM);
            return this;
        }
        return (a) invokeJ.objValue;
    }

    public a q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            if (str == null) {
                str = "";
            }
            this.f9590e = str;
            return this;
        }
        return (a) invokeL.objValue;
    }

    public String r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f9590e : (String) invokeV.objValue;
    }

    public String s(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i2)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(String.format(Locale.getDefault(), "%s :: code(%08d) desc(%s) \n", super.toString(), Long.valueOf(a()), Long.valueOf(o()), Long.valueOf(j()), Long.valueOf(h()), e()));
            if (i2 >= -200) {
                sb.append(String.format(Locale.getDefault(), "  p(%01d) f(%03d) e(%04d) \n", Long.valueOf(o()), Long.valueOf(j()), Long.valueOf(h())));
            }
            if (i2 >= -100) {
                sb.append(String.format(Locale.getDefault(), "  details(%s) \n", g()));
            }
            return sb.toString();
        }
        return (String) invokeI.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? s(-100) : (String) invokeV.objValue;
    }
}
