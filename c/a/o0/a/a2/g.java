package c.a.o0.a.a2;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class g extends f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f4535b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, Object> f4536a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1009115612, "Lc/a/o0/a/a2/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1009115612, "Lc/a/o0/a/a2/g;");
                return;
            }
        }
        f4535b = c.a.o0.a.k.f7049a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(e eVar) {
        super(eVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((e) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f4536a = new HashMap();
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f4536a.clear();
        }
    }

    public boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return this.f4536a.containsKey(str);
        }
        return invokeL.booleanValue;
    }

    public Boolean c(String str, Boolean bool) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, bool)) == null) {
            try {
                return (Boolean) f(str, bool);
            } catch (ClassCastException e2) {
                if (f4535b) {
                    e2.printStackTrace();
                }
                return bool;
            }
        }
        return (Boolean) invokeLL.objValue;
    }

    public Integer d(String str, Integer num) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, num)) == null) {
            try {
                return (Integer) f(str, num);
            } catch (ClassCastException e2) {
                if (f4535b) {
                    e2.printStackTrace();
                }
                return num;
            }
        }
        return (Integer) invokeLL.objValue;
    }

    public String e(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, str2)) == null) {
            try {
                return (String) f(str, str2);
            } catch (ClassCastException e2) {
                if (f4535b) {
                    e2.printStackTrace();
                }
                return str2;
            }
        }
        return (String) invokeLL.objValue;
    }

    public final <V> V f(String str, V v) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, v)) == null) {
            if (b(str)) {
                if (this.f4536a.get(str) == null) {
                    return null;
                }
                try {
                    return (V) this.f4536a.get(str);
                } catch (Exception e2) {
                    if (f4535b) {
                        e2.printStackTrace();
                        return v;
                    }
                    return v;
                }
            }
            return v;
        }
        return (V) invokeLL.objValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            a();
        }
    }

    public void h(String str, Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, bool) == null) {
            k(str, bool);
        }
    }

    public void i(String str, Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, num) == null) {
            k(str, num);
        }
    }

    public void j(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, str, str2) == null) {
            k(str, str2);
        }
    }

    public final <V> void k(String str, V v) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, str, v) == null) {
            this.f4536a.put(str, v);
        }
    }
}
