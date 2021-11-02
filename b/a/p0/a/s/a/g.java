package b.a.p0.a.s.a;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public final class g {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static Boolean f7772a = null;

    /* renamed from: b  reason: collision with root package name */
    public static String f7773b = "8893";

    /* renamed from: c  reason: collision with root package name */
    public static String f7774c = "80";

    /* renamed from: d  reason: collision with root package name */
    public static String f7775d = "81";

    /* renamed from: e  reason: collision with root package name */
    public static String f7776e = "82";

    /* renamed from: f  reason: collision with root package name */
    public static String f7777f = "show";

    /* renamed from: g  reason: collision with root package name */
    public static String f7778g = "fail";

    /* renamed from: h  reason: collision with root package name */
    public static String f7779h = "success";

    /* renamed from: i  reason: collision with root package name */
    public static String f7780i = "login";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1572698956, "Lb/a/p0/a/s/a/g;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1572698956, "Lb/a/p0/a/s/a/g;");
        }
    }

    public static final String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? f7776e : (String) invokeV.objValue;
    }

    public static final String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f7774c : (String) invokeV.objValue;
    }

    public static final String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? f7775d : (String) invokeV.objValue;
    }

    public static final String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? f7778g : (String) invokeV.objValue;
    }

    public static final String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? f7777f : (String) invokeV.objValue;
    }

    public static final String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? f7779h : (String) invokeV.objValue;
    }

    public static final String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? f7773b : (String) invokeV.objValue;
    }

    public static final String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? f7780i : (String) invokeV.objValue;
    }

    public static final Boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? f7772a : (Boolean) invokeV.objValue;
    }

    public static final void j(Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, bool) == null) {
            f7772a = bool;
        }
    }
}
