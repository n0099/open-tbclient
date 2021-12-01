package c.a.p0.a.j0.c;

import android.net.Uri;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static final String a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f6395b;

    /* renamed from: c  reason: collision with root package name */
    public static final String f6396c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1433210440, "Lc/a/p0/a/j0/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1433210440, "Lc/a/p0/a/j0/c/a;");
                return;
            }
        }
        a = "content://" + c.a.p0.a.j0.b.b.f6393b + "/history_with_app";
        f6395b = "content://" + c.a.p0.a.j0.b.b.f6393b + "/history";
        f6396c = "content://" + c.a.p0.a.j0.b.b.f6393b + "/history_with_aps_pms";
    }

    public static Uri a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? Uri.parse(f6395b) : (Uri) invokeV.objValue;
    }

    public static Uri b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? Uri.parse(a) : (Uri) invokeV.objValue;
    }

    public static Uri c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? Uri.parse(f6396c) : (Uri) invokeV.objValue;
    }
}
