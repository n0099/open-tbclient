package c.a.d1.g;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f3535b;

    /* renamed from: c  reason: collision with root package name */
    public float f3536c;

    /* renamed from: d  reason: collision with root package name */
    public float f3537d;

    /* renamed from: e  reason: collision with root package name */
    public float f3538e;

    /* renamed from: f  reason: collision with root package name */
    public float f3539f;

    /* renamed from: g  reason: collision with root package name */
    public float f3540g;

    /* renamed from: h  reason: collision with root package name */
    public List<c> f3541h;

    /* renamed from: i  reason: collision with root package name */
    public Map<String, b> f3542i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-146684674, "Lc/a/d1/g/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-146684674, "Lc/a/d1/g/a;");
                return;
            }
        }
        AppConfig.isDebug();
    }

    public a() {
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
        this.f3541h = new ArrayList();
        new ArrayList();
        new HashMap();
        this.f3542i = new HashMap();
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!TextUtils.equals("1", this.f3535b)) {
                this.f3535b = "0";
            }
            return this.f3535b;
        }
        return (String) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (!TextUtils.equals("0", this.a)) {
                this.a = "1";
            }
            return this.a;
        }
        return (String) invokeV.objValue;
    }

    public Map<String, b> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f3542i : (Map) invokeV.objValue;
    }

    public float d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            float f2 = this.f3540g;
            if (f2 <= 0.0f || Float.isNaN(f2)) {
                this.f3540g = 20.0f;
            }
            return this.f3540g;
        }
        return invokeV.floatValue;
    }

    public float e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            float f2 = this.f3537d;
            if (f2 <= 0.0f || Float.isNaN(f2)) {
                this.f3537d = 1.0f;
            }
            return this.f3537d;
        }
        return invokeV.floatValue;
    }

    public List<c> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f3541h : (List) invokeV.objValue;
    }

    public float g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            float f2 = this.f3538e;
            if (f2 <= 0.0f || Float.isNaN(f2)) {
                this.f3538e = 20.0f;
            }
            return this.f3538e;
        }
        return invokeV.floatValue;
    }

    public float h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            float f2 = this.f3539f;
            if (f2 <= 0.0f || Float.isNaN(f2)) {
                this.f3539f = 7.0f;
            }
            return this.f3539f;
        }
        return invokeV.floatValue;
    }

    public float i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            float f2 = this.f3536c;
            if (f2 <= 0.0f || Float.isNaN(f2)) {
                this.f3536c = 100.0f;
            }
            return this.f3536c;
        }
        return invokeV.floatValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? TextUtils.equals("1", a()) : invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? TextUtils.equals("1", b()) : invokeV.booleanValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.a = "1";
            this.f3535b = "0";
            this.f3536c = 100.0f;
            this.f3537d = 1.0f;
            this.f3538e = 20.0f;
            this.f3539f = 7.0f;
            this.f3540g = 20.0f;
        }
    }

    public void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.f3535b = str;
        }
    }

    public void n(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, map) == null) {
        }
    }

    public void o(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, list) == null) {
        }
    }

    public void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.a = str;
        }
    }

    public void q(Map<String, b> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, map) == null) {
            this.f3542i = map;
        }
    }

    public void r(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048593, this, f2) == null) {
            this.f3540g = f2;
        }
    }

    public void s(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048594, this, f2) == null) {
            this.f3537d = f2;
        }
    }

    public void t(List<c> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, list) == null) {
            this.f3541h = list;
        }
    }

    public void u(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048596, this, f2) == null) {
            this.f3538e = f2;
        }
    }

    public void v(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048597, this, f2) == null) {
            this.f3539f = f2;
        }
    }

    public void w(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048598, this, f2) == null) {
            this.f3536c = f2;
        }
    }
}
