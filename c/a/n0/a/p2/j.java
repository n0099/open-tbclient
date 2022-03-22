package c.a.n0.a.p2;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.util.StringHelper;
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
    public static List<String> f5835b;

    /* renamed from: c  reason: collision with root package name */
    public static List<String> f5836c;

    /* renamed from: d  reason: collision with root package name */
    public static final Object f5837d;

    /* renamed from: e  reason: collision with root package name */
    public static int f5838e;

    /* renamed from: f  reason: collision with root package name */
    public static int f5839f;
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1219482025, "Lc/a/n0/a/p2/j;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1219482025, "Lc/a/n0/a/p2/j;");
                return;
            }
        }
        a = c.a.n0.a.a.a;
        f5835b = new ArrayList();
        f5836c = new ArrayList();
        f5837d = new Object();
        f5838e = 0;
        f5839f = 0;
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (e()) {
                if (a) {
                    Log.d("SwanAppCompat", "has used ab description");
                }
                return true;
            }
            return !c.a.n0.a.e2.g.h.a().getBoolean("swan_app_js_native_ab_update_key", false);
        }
        return invokeV.booleanValue;
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            c.a.n0.a.u.d.c("JsNative", f5839f + "-true");
            return f5839f + "-true-" + str + "-" + c();
        }
        return (String) invokeL.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            StringBuilder sb = new StringBuilder();
            synchronized (f5837d) {
                if (f5835b != null) {
                    sb.append("v8list:{");
                    for (String str : f5835b) {
                        if (!TextUtils.isEmpty(str)) {
                            if (str.length() > 100) {
                                sb.append(str.substring(0, 99));
                                sb.append(StringHelper.STRING_MORE);
                            } else {
                                sb.append(str);
                            }
                            sb.append(";");
                        }
                    }
                    sb.append("},");
                }
                if (f5836c != null) {
                    sb.append("weblist:{");
                    for (String str2 : f5836c) {
                        if (!TextUtils.isEmpty(str2)) {
                            if (str2.length() > 100) {
                                sb.append(str2.substring(0, 99));
                                sb.append(StringHelper.STRING_MORE);
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

    public static String d(int i, String str) {
        InterceptResult invokeIL;
        List<String> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(InputDeviceCompat.SOURCE_TRACKBALL, null, i, str)) == null) {
            f5839f = 0;
            if (f5838e == 1) {
                c.a.n0.a.u.d.i("SwanAppCompat", "type support default");
                f5839f = 1;
                return SchemeCollecter.getSchemesDes(str, i);
            } else if (TextUtils.equals(str, "swan/web")) {
                return SchemeCollecter.getSchemesDes(str, i);
            } else {
                if (a() && !c.a.n0.a.u0.d.b().isEmpty()) {
                    synchronized (f5837d) {
                        if (TextUtils.equals(str, SchemeCollecter.CLASSIFY_SWAN_V8)) {
                            list = f5835b;
                        } else {
                            list = f5836c;
                        }
                        if (list != null && list.size() > 0) {
                            if (a) {
                                Log.d("SwanAppCompat", "support ab js native descriptions");
                            }
                            f5838e = 2;
                            f5839f = 2;
                            return list.get(i);
                        } else if (list != null) {
                            f5839f = 3;
                        } else {
                            f5839f = 4;
                        }
                    }
                }
                if (a) {
                    Log.d("SwanAppCompat", "use default descriptions");
                }
                f5838e = 1;
                return SchemeCollecter.getSchemesDes(str, i);
            }
        }
        return (String) invokeIL.objValue;
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? f5838e == 2 : invokeV.booleanValue;
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
            if (a) {
                Log.d("SwanAppCompat", "on App upgrade");
            }
            if (c.a.n0.q.c.b() != null && c.a.n0.q.j.i.o.b()) {
                c.a.n0.q.c.b().i().putString("key_online_description_fix_version", "0");
            }
            c.a.n0.a.e2.g.h.a().putBoolean("swan_app_js_native_ab_update_key", true);
        }
    }

    public static void i() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65545, null) == null) && a) {
            Log.e("JsNative", f5839f + "-true");
        }
    }

    public static void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            if (a) {
                Log.d("SwanAppCompat", "start release descriptions");
            }
            synchronized (f5837d) {
                f5838e = 0;
                f5835b = new ArrayList();
                f5836c = new ArrayList();
            }
        }
    }

    public static void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, null) == null) {
            if (a) {
                Log.d("SwanAppCompat", "start prepare ab description");
            }
            synchronized (f5837d) {
                l(true);
                l(false);
            }
            if (a) {
                Log.d("SwanAppCompat", "end prepare ab description");
            }
        }
    }

    public static void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65548, null, z) == null) {
            if (a) {
                StringBuilder sb = new StringBuilder();
                sb.append("start prepare ab description :");
                sb.append(z ? V8Engine.TYPE_V8 : AlbumActivityConfig.FROM_WEB_VIEW);
                Log.d("SwanAppCompat", sb.toString());
            }
            c.a.n0.a.p2.d1.b.a aVar = new c.a.n0.a.p2.d1.b.a(z);
            String a2 = c.a.n0.a.u0.d.a();
            String string = c.a.n0.a.e2.g.h.a().getString("swan_app_js_native_ab_sign", null);
            if (!TextUtils.equals(a2, string)) {
                if (a) {
                    Log.w("SwanAppCompat", "js desc sign change: old=" + string + ", new=" + a2);
                }
                if (!aVar.a(3)) {
                    return;
                }
                c.a.n0.a.e2.g.h.a().putString("swan_app_js_native_ab_sign", a2);
            } else if (c.a.n0.a.e2.g.h.a().getBoolean("swan_app_js_native_ab_update_key", false)) {
                if (!aVar.a(3)) {
                    return;
                }
                c.a.n0.a.e2.g.h.a().putBoolean("swan_app_js_native_ab_update_key", false);
            }
            List<String> d2 = aVar.d();
            if (d2 != null) {
                m(d2, z);
            }
        }
    }

    public static void m(List<String> list, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(65549, null, list, z) == null) && list != null && f5838e == 0) {
            if (z) {
                f5835b = list;
            } else {
                f5836c = list;
            }
            if (a) {
                StringBuilder sb = new StringBuilder();
                sb.append("has update descriptions, list :");
                sb.append(list.toString());
                sb.append(" type :");
                sb.append(z ? V8Engine.TYPE_V8 : AlbumActivityConfig.FROM_WEB_VIEW);
                Log.d("SwanAppCompat", sb.toString());
            }
        }
    }
}
