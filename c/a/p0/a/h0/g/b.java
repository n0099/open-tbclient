package c.a.p0.a.h0.g;

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

    /* renamed from: a  reason: collision with root package name */
    public static int f5872a = -1;

    /* renamed from: b  reason: collision with root package name */
    public static c.a.p0.a.k2.g.g f5873b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1086868689, "Lc/a/p0/a/h0/g/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1086868689, "Lc/a/p0/a/h0/g/b;");
        }
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
            }
        }
    }

    public static c.a.p0.a.k2.g.g a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f5873b == null) {
                synchronized (b.class) {
                    if (f5873b == null) {
                        f5873b = new c.a.p0.a.k2.g.g("swan_about_page_sp", true);
                    }
                }
            }
            return f5873b;
        }
        return (c.a.p0.a.k2.g.g) invokeV.objValue;
    }

    public static String b() {
        InterceptResult invokeV;
        String D;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            c.a.p0.a.a2.e Q = c.a.p0.a.a2.e.Q();
            if (Q == null) {
                D = c.a.p0.a.v.a.a(c.a.p0.a.a2.d.g().getAppId());
            } else {
                D = Q.D();
            }
            return "pref_tool_" + D;
        }
        return (String) invokeV.objValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (f5872a == -1) {
                f5872a = a().getInt(b(), 0);
            }
            return f5872a == 1;
        }
        return invokeV.booleanValue;
    }
}
