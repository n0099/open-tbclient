package c.a.n0.a.x.g;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic = null;
    public static int a = -1;

    /* renamed from: b  reason: collision with root package name */
    public static c.a.n0.a.e2.g.g f7022b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-622887379, "Lc/a/n0/a/x/g/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-622887379, "Lc/a/n0/a/x/g/b;");
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static c.a.n0.a.e2.g.g a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f7022b == null) {
                synchronized (b.class) {
                    if (f7022b == null) {
                        f7022b = new c.a.n0.a.e2.g.g("swan_about_page_sp", true);
                    }
                }
            }
            return f7022b;
        }
        return (c.a.n0.a.e2.g.g) invokeV.objValue;
    }

    public static String b() {
        InterceptResult invokeV;
        String N;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            c.a.n0.a.t1.e a0 = c.a.n0.a.t1.e.a0();
            if (a0 == null) {
                N = c.a.n0.a.l.a.a(c.a.n0.a.t1.d.J().getAppId());
            } else {
                N = a0.N();
            }
            return "pref_tool_" + N;
        }
        return (String) invokeV.objValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (a == -1) {
                a = a().getInt(b(), 0);
            }
            return a == 1;
        }
        return invokeV.booleanValue;
    }
}
