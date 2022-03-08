package c.a.p0.a.p2;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static List<String> f6962b;

    /* renamed from: c  reason: collision with root package name */
    public static List<String> f6963c;

    /* renamed from: d  reason: collision with root package name */
    public static final Object f6964d;

    /* renamed from: e  reason: collision with root package name */
    public static int f6965e;

    /* renamed from: f  reason: collision with root package name */
    public static int f6966f;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static abstract class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final boolean a;

        public a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(826455015, "Lc/a/p0/a/p2/j;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(826455015, "Lc/a/p0/a/p2/j;");
                return;
            }
        }
        a = c.a.p0.a.a.a;
        f6962b = new ArrayList();
        f6963c = new ArrayList();
        f6964d = new Object();
        f6965e = 0;
        f6966f = 0;
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (e()) {
                boolean z = a;
                return true;
            }
            return !c.a.p0.a.e2.g.h.a().getBoolean("swan_app_js_native_ab_update_key", false);
        }
        return invokeV.booleanValue;
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            c.a.p0.a.u.d.c("JsNative", f6966f + "-true");
            return f6966f + "-true-" + str + "-" + c();
        }
        return (String) invokeL.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            StringBuilder sb = new StringBuilder();
            synchronized (f6964d) {
                if (f6962b != null) {
                    sb.append("v8list:{");
                    for (String str : f6962b) {
                        if (!TextUtils.isEmpty(str)) {
                            if (str.length() > 100) {
                                sb.append(str.substring(0, 99));
                                sb.append("...");
                            } else {
                                sb.append(str);
                            }
                            sb.append(";");
                        }
                    }
                    sb.append("},");
                }
                if (f6963c != null) {
                    sb.append("weblist:{");
                    for (String str2 : f6963c) {
                        if (!TextUtils.isEmpty(str2)) {
                            if (str2.length() > 100) {
                                sb.append(str2.substring(0, 99));
                                sb.append("...");
                            } else {
                                sb.append(str2);
                            }
                            sb.append(";");
                        }
                    }
                    sb.append("}");
                }
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public static String d(int i2, String str) {
        InterceptResult invokeIL;
        List<String> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(InputDeviceCompat.SOURCE_TRACKBALL, null, i2, str)) == null) {
            f6966f = 0;
            if (f6965e == 1) {
                c.a.p0.a.u.d.i("SwanAppCompat", "type support default");
                f6966f = 1;
                return SchemeCollecter.getSchemesDes(str, i2);
            } else if (TextUtils.equals(str, "swan/web")) {
                return SchemeCollecter.getSchemesDes(str, i2);
            } else {
                if (a() && !c.a.p0.a.u0.d.b().isEmpty()) {
                    synchronized (f6964d) {
                        if (TextUtils.equals(str, SchemeCollecter.CLASSIFY_SWAN_V8)) {
                            list = f6962b;
                        } else {
                            list = f6963c;
                        }
                        if (list != null && list.size() > 0) {
                            boolean z = a;
                            f6965e = 2;
                            f6966f = 2;
                            return list.get(i2);
                        } else if (list != null) {
                            f6966f = 3;
                        } else {
                            f6966f = 4;
                        }
                    }
                }
                boolean z2 = a;
                f6965e = 1;
                return SchemeCollecter.getSchemesDes(str, i2);
            }
        }
        return (String) invokeIL.objValue;
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? f6965e == 2 : invokeV.booleanValue;
    }

    public static boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? !l0.f("3.320.0") : invokeV.booleanValue;
    }

    public static boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? !l0.f("3.120.2") : invokeV.booleanValue;
    }

    public static void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            boolean z = a;
            if (c.a.p0.q.c.b() != null && c.a.p0.q.j.i.o.b()) {
                c.a.p0.q.c.b().i().putString("key_online_description_fix_version", "0");
            }
            c.a.p0.a.e2.g.h.a().putBoolean("swan_app_js_native_ab_update_key", true);
        }
    }

    public static void i() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65545, null) == null) && a) {
            String str = f6966f + "-true";
        }
    }

    public static void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            boolean z = a;
            synchronized (f6964d) {
                f6965e = 0;
                f6962b = new ArrayList();
                f6963c = new ArrayList();
            }
        }
    }

    public static void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, null) == null) {
            boolean z = a;
            synchronized (f6964d) {
                l(true);
                l(false);
            }
            boolean z2 = a;
        }
    }

    public static void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65548, null, z) == null) {
            if (a) {
                StringBuilder sb = new StringBuilder();
                sb.append("start prepare ab description :");
                sb.append(z ? V8Engine.TYPE_V8 : AlbumActivityConfig.FROM_WEB_VIEW);
                sb.toString();
            }
            c.a.p0.a.p2.d1.b.a aVar = new c.a.p0.a.p2.d1.b.a(z);
            String a2 = c.a.p0.a.u0.d.a();
            String string = c.a.p0.a.e2.g.h.a().getString("swan_app_js_native_ab_sign", null);
            if (!TextUtils.equals(a2, string)) {
                if (a) {
                    String str = "js desc sign change: old=" + string + ", new=" + a2;
                }
                if (!aVar.a(3)) {
                    return;
                }
                c.a.p0.a.e2.g.h.a().putString("swan_app_js_native_ab_sign", a2);
            } else if (c.a.p0.a.e2.g.h.a().getBoolean("swan_app_js_native_ab_update_key", false)) {
                if (!aVar.a(3)) {
                    return;
                }
                c.a.p0.a.e2.g.h.a().putBoolean("swan_app_js_native_ab_update_key", false);
            }
            List<String> d2 = aVar.d();
            if (d2 != null) {
                m(d2, z);
            }
        }
    }

    public static void m(List<String> list, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(65549, null, list, z) == null) && list != null && f6965e == 0) {
            if (z) {
                f6962b = list;
            } else {
                f6963c = list;
            }
            if (a) {
                StringBuilder sb = new StringBuilder();
                sb.append("has update descriptions, list :");
                sb.append(list.toString());
                sb.append(" type :");
                sb.append(z ? V8Engine.TYPE_V8 : AlbumActivityConfig.FROM_WEB_VIEW);
                sb.toString();
            }
        }
    }
}
