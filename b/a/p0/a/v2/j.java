package b.a.p0.a.v2;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
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

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f8599a;

    /* renamed from: b  reason: collision with root package name */
    public static List<String> f8600b;

    /* renamed from: c  reason: collision with root package name */
    public static List<String> f8601c;

    /* renamed from: d  reason: collision with root package name */
    public static final Object f8602d;

    /* renamed from: e  reason: collision with root package name */
    public static int f8603e;

    /* renamed from: f  reason: collision with root package name */
    public static int f8604f;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static abstract class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final boolean f8605a;

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
            this.f8605a = z;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1337554766, "Lb/a/p0/a/v2/j;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1337554766, "Lb/a/p0/a/v2/j;");
                return;
            }
        }
        f8599a = b.a.p0.a.k.f6397a;
        f8600b = new ArrayList();
        f8601c = new ArrayList();
        f8602d = new Object();
        f8603e = 0;
        f8604f = 0;
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f8603e == 2) {
                boolean z = f8599a;
                return true;
            } else if (!l0.f("3.230.0")) {
                return b.a.p0.a.c1.a.Z().m() && !b.a.p0.a.k2.g.h.a().getBoolean("swan_app_js_native_ab_update_key", false);
            } else {
                boolean z2 = f8599a;
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            b.a.p0.a.e0.d.b("JsNative", f8604f + "-true");
            return f8604f + "-true-" + str + "-" + c();
        }
        return (String) invokeL.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            StringBuilder sb = new StringBuilder();
            synchronized (f8602d) {
                if (f8600b != null) {
                    sb.append("v8list:{");
                    for (String str : f8600b) {
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
                if (f8601c != null) {
                    sb.append("weblist:{");
                    for (String str2 : f8601c) {
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

    public static String d(int i2, boolean z) {
        InterceptResult invokeCommon;
        List<String> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            f8604f = 0;
            String str = z ? SchemeCollecter.CLASSIFY_SWAN_V8 : SchemeCollecter.CLASSIFY_SWAN_WEBVIEW;
            if (f8603e == 1) {
                boolean z2 = f8599a;
                f8604f = 1;
                return SchemeCollecter.getSchemesDes(str, i2);
            }
            if (b.a.p0.a.u.e.j.d.b()) {
                synchronized (f8602d) {
                    if (z) {
                        list = f8600b;
                    } else {
                        list = f8601c;
                    }
                    if (list != null && list.size() > 0) {
                        boolean z3 = f8599a;
                        f8603e = 2;
                        f8604f = 2;
                        return list.get(i2);
                    } else if (list != null) {
                        f8604f = 3;
                    } else {
                        f8604f = 4;
                    }
                }
            }
            boolean z4 = f8599a;
            f8603e = 1;
            return SchemeCollecter.getSchemesDes(str, i2);
        }
        return (String) invokeCommon.objValue;
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? !l0.f("3.120.2") : invokeV.booleanValue;
    }

    public static void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null) == null) {
            boolean z = f8599a;
            if (b.a.p0.n.c.b() != null && b.a.p0.n.j.i.m.b()) {
                b.a.p0.n.c.b().j().putString("key_online_description_fix_version", "0");
            }
            b.a.p0.a.k2.g.h.a().putBoolean("swan_app_js_native_ab_update_key", true);
            b.a.p0.a.u.e.j.d.f(false);
        }
    }

    public static void g() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65543, null) == null) && f8599a) {
            String str = f8604f + "-true";
        }
    }

    public static void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            boolean z = f8599a;
            synchronized (f8602d) {
                f8603e = 0;
                f8600b = new ArrayList();
                f8601c = new ArrayList();
            }
        }
    }

    public static void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            boolean z = f8599a;
            synchronized (f8602d) {
                j(true);
                j(false);
            }
            boolean z2 = f8599a;
        }
    }

    public static void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65546, null, z) == null) {
            if (f8599a) {
                StringBuilder sb = new StringBuilder();
                sb.append("start prepare ab description :");
                sb.append(z ? V8Engine.TYPE_V8 : AlbumActivityConfig.FROM_WEB_VIEW);
                sb.toString();
            }
            b.a.p0.a.v2.b1.b.a aVar = new b.a.p0.a.v2.b1.b.a(z);
            if (b.a.p0.a.k2.g.h.a().getBoolean("swan_app_js_native_ab_update_key", false)) {
                if (!aVar.a(3)) {
                    return;
                }
                b.a.p0.a.k2.g.h.a().putBoolean("swan_app_js_native_ab_update_key", false);
            }
            List<String> d2 = aVar.d();
            if (d2 != null) {
                k(d2, z);
            }
        }
    }

    public static void k(List<String> list, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(65547, null, list, z) == null) && list != null && f8603e == 0) {
            if (z) {
                f8600b = list;
            } else {
                f8601c = list;
            }
            if (f8599a) {
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
