package c.i.b.a.e0.r;

import android.text.Layout;
import androidx.core.view.InputDeviceCompat;
import c.i.b.a.i0.v;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/* loaded from: classes4.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f33367a;

    /* renamed from: b  reason: collision with root package name */
    public String f33368b;

    /* renamed from: c  reason: collision with root package name */
    public List<String> f33369c;

    /* renamed from: d  reason: collision with root package name */
    public String f33370d;

    /* renamed from: e  reason: collision with root package name */
    public String f33371e;

    /* renamed from: f  reason: collision with root package name */
    public int f33372f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f33373g;

    /* renamed from: h  reason: collision with root package name */
    public int f33374h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f33375i;

    /* renamed from: j  reason: collision with root package name */
    public int f33376j;
    public int k;
    public int l;
    public int m;
    public int n;
    public float o;
    public Layout.Alignment p;

    public d() {
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
        m();
    }

    public static int x(int i2, String str, String str2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i2), str, str2, Integer.valueOf(i3)})) == null) {
            if (str.isEmpty() || i2 == -1) {
                return i2;
            }
            if (str.equals(str2)) {
                return i2 + i3;
            }
            return -1;
        }
        return invokeCommon.intValue;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f33375i) {
                return this.f33374h;
            }
            throw new IllegalStateException("Background color not defined.");
        }
        return invokeV.intValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f33373g) {
                return this.f33372f;
            }
            throw new IllegalStateException("Font color not defined");
        }
        return invokeV.intValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f33371e : (String) invokeV.objValue;
    }

    public float d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.o : invokeV.floatValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.n : invokeV.intValue;
    }

    public int f(String str, String str2, String[] strArr, String str3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048581, this, str, str2, strArr, str3)) == null) {
            if (this.f33367a.isEmpty() && this.f33368b.isEmpty() && this.f33369c.isEmpty() && this.f33370d.isEmpty()) {
                return str2.isEmpty() ? 1 : 0;
            }
            int x = x(x(x(0, this.f33367a, str, 1073741824), this.f33368b, str2, 2), this.f33370d, str3, 4);
            if (x == -1 || !Arrays.asList(strArr).containsAll(this.f33369c)) {
                return 0;
            }
            return x + (this.f33369c.size() * 4);
        }
        return invokeLLLL.intValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.l == -1 && this.m == -1) {
                return -1;
            }
            return (this.l == 1 ? 1 : 0) | (this.m == 1 ? 2 : 0);
        }
        return invokeV.intValue;
    }

    public Layout.Alignment h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.p : (Layout.Alignment) invokeV.objValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f33375i : invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f33373g : invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f33376j == 1 : invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.k == 1 : invokeV.booleanValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f33367a = "";
            this.f33368b = "";
            this.f33369c = Collections.emptyList();
            this.f33370d = "";
            this.f33371e = null;
            this.f33373g = false;
            this.f33375i = false;
            this.f33376j = -1;
            this.k = -1;
            this.l = -1;
            this.m = -1;
            this.n = -1;
            this.p = null;
        }
    }

    public d n(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) {
            this.f33374h = i2;
            this.f33375i = true;
            return this;
        }
        return (d) invokeI.objValue;
    }

    public d o(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048590, this, z)) == null) {
            this.l = z ? 1 : 0;
            return this;
        }
        return (d) invokeZ.objValue;
    }

    public d p(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) {
            this.f33372f = i2;
            this.f33373g = true;
            return this;
        }
        return (d) invokeI.objValue;
    }

    public d q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            this.f33371e = v.J(str);
            return this;
        }
        return (d) invokeL.objValue;
    }

    public d r(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048593, this, z)) == null) {
            this.m = z ? 1 : 0;
            return this;
        }
        return (d) invokeZ.objValue;
    }

    public void s(String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, strArr) == null) {
            this.f33369c = Arrays.asList(strArr);
        }
    }

    public void t(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.f33367a = str;
        }
    }

    public void u(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.f33368b = str;
        }
    }

    public void v(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            this.f33370d = str;
        }
    }

    public d w(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048598, this, z)) == null) {
            this.k = z ? 1 : 0;
            return this;
        }
        return (d) invokeZ.objValue;
    }
}
