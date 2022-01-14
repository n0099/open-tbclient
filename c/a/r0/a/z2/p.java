package c.a.r0.a.z2;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.text.format.Formatter;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.e0.g.e;
import c.a.r0.a.f1.e.b;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.sdk.WebView;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes6.dex */
public class p {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(442663401, "Lc/a/r0/a/z2/p;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(442663401, "Lc/a/r0/a/z2/p;");
                return;
            }
        }
        a = c.a.r0.a.k.a;
    }

    public static String a(int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            if (a) {
                return c.a.r0.a.x1.a.a.p() ? j.d(i2, SchemeCollecter.CLASSIFY_SWAN_V8) : "";
            } else if (z) {
                return j.d(i2, SchemeCollecter.CLASSIFY_SWAN_V8);
            } else {
                return j.d(i2, SchemeCollecter.CLASSIFY_SWAN_WEBVIEW);
            }
        }
        return (String) invokeCommon.objValue;
    }

    public static String b() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            StringBuilder sb = new StringBuilder();
            SwanCoreVersion M = c.a.r0.a.g1.f.U().M();
            String str2 = "";
            if (M != null) {
                String str3 = M.swanCoreVersionName;
                str2 = SwanCoreVersion.getTypeString(M.swanCoreType);
                str = str3;
            } else {
                str = "";
            }
            sb.append("swanjs: ");
            sb.append(str2);
            sb.append("/");
            sb.append(str);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public static String c(Context context) {
        InterceptResult invokeL;
        c.a.r0.a.p.e.b i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            c.a.r0.a.d2.e a0 = c.a.r0.a.d2.e.a0();
            if (context == null || a0 == null || a0.l() != 0) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            b.a V = a0.V();
            String formatFileSize = Formatter.formatFileSize(AppRuntime.getAppContext(), V.i1());
            sb.append("size: ");
            if (TextUtils.isEmpty(formatFileSize)) {
                formatFileSize = "";
            }
            sb.append(formatFileSize);
            sb.append(StringUtils.LF);
            sb.append("version: ");
            sb.append(TextUtils.isEmpty(V.w1()) ? "" : V.w1());
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("code: ");
            sb.append(TextUtils.isEmpty(V.v1()) ? "" : V.v1());
            sb.append(StringUtils.LF);
            sb.append("is opt pkg: ");
            sb.append(c.a.r0.a.m1.d.d.g().h(V.f0()));
            sb.append(StringUtils.LF);
            sb.append("swan native: ");
            sb.append(c.a.r0.d.c.getContext() != null ? c.a.r0.d.c.getContext().b() : "");
            sb.append(StringUtils.LF);
            sb.append(b());
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append(e(0));
            sb.append(StringUtils.LF);
            sb.append("is v8 master: ");
            sb.append(c.a.r0.a.h0.u.g.U().r0());
            sb.append(StringUtils.LF);
            String a2 = a(0, c.a.r0.a.h0.u.g.U().r0());
            sb.append("is native desc: ");
            sb.append(!TextUtils.isEmpty(a2));
            sb.append(StringUtils.LF);
            boolean m = c.a.r0.a.p0.f.c.m();
            sb.append("debugDynamicLibEnable: ");
            sb.append(m);
            sb.append('\n');
            if (m) {
                List<String> o = c.a.r0.a.p0.f.c.o();
                sb.append("debugDynamicLibList: {");
                if (!o.isEmpty()) {
                    sb.append('\n');
                    for (String str : o) {
                        sb.append(str);
                        sb.append('\n');
                    }
                }
                sb.append("}\n");
            }
            c.a.r0.a.h0.g.f H = c.a.r0.a.g1.f.U().H();
            if (H != null && (i3 = H.i3()) != null) {
                int S = i3.S();
                sb.append("top fragment na-slave: ");
                sb.append(S == 1 ? "NA" : WebView.LOGTAG);
                sb.append(StringUtils.LF);
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            return "model: " + Build.MODEL + StringUtils.LF + "android: " + Build.VERSION.RELEASE + StringUtil.ARRAY_ELEMENT_SEPARATOR + "api level: " + Build.VERSION.SDK_INT + StringUtils.LF + "cuid: " + c.a.r0.a.c1.a.h0().i(c.a.r0.a.c1.a.c()) + StringUtils.LF;
        }
        return (String) invokeL.objValue;
    }

    public static String e(int i2) {
        InterceptResult invokeI;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65541, null, i2)) == null) {
            String str2 = "";
            if (i2 != 0) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            ExtensionCore T = c.a.r0.a.h0.u.g.U().T();
            if (T != null) {
                String str3 = T.extensionCoreVersionName;
                String typeString = SwanCoreVersion.getTypeString(T.extensionCoreType);
                str = str3;
                str2 = typeString;
            } else {
                str = "";
            }
            sb.append("extensionjs: ");
            sb.append(str2);
            sb.append("/");
            sb.append(str);
            return sb.toString();
        }
        return (String) invokeI.objValue;
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            StringBuilder sb = new StringBuilder();
            SwanCoreVersion M = c.a.r0.a.g1.f.U().M();
            sb.append("game-core version : ");
            sb.append(c.a.r0.a.q2.b.i(M, 1));
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public static String g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            c.a.r0.a.d2.e a0 = c.a.r0.a.d2.e.a0();
            if (context == null || a0 == null || a0.l() != 1) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            b.a V = a0.V();
            sb.append(f());
            sb.append(StringUtils.LF);
            sb.append("host version : ");
            sb.append(q0.u(AppRuntime.getAppContext(), AppRuntime.getAppContext().getPackageName()));
            sb.append(StringUtils.LF);
            sb.append("enable V8: ");
            sb.append(c.a.r0.a.h0.u.g.U().r0());
            sb.append(StringUtils.LF);
            sb.append("aps version: ");
            sb.append(TextUtils.isEmpty(V.v1()) ? "" : V.v1());
            sb.append(StringUtils.LF);
            String formatFileSize = Formatter.formatFileSize(AppRuntime.getAppContext(), V.i1());
            sb.append("app bundle size: ");
            if (TextUtils.isEmpty(formatFileSize)) {
                formatFileSize = "";
            }
            sb.append(formatFileSize);
            sb.append(StringUtils.LF);
            sb.append("app bundle version: ");
            sb.append(TextUtils.isEmpty(V.w1()) ? "" : V.w1());
            sb.append(StringUtils.LF);
            sb.append("app is opt pkg: ");
            sb.append(c.a.r0.a.m1.d.d.g().h(V.f0()));
            sb.append(StringUtils.LF);
            String b2 = c.a.r0.a.c1.b.h().b();
            if (!TextUtils.isEmpty(b2)) {
                sb.append("app sconsole version: ");
                sb.append(b2);
                sb.append(StringUtils.LF);
            }
            sb.append("game engine version: ");
            sb.append("1.3.6.1");
            sb.append(StringUtils.LF);
            sb.append("so version: ");
            sb.append(c.a.r0.a.o2.g.h.a().getLong("swan_so_installed_version_code_zeus", 0L));
            sb.append(StringUtils.LF);
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            c.a.r0.d.a context2 = c.a.r0.d.c.getContext();
            StringBuilder sb = new StringBuilder();
            sb.append("name: ");
            sb.append(c.a.r0.a.c1.a.n().a());
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("version: ");
            sb.append(context2 != null ? context2.h() : "");
            sb.append(StringUtils.LF);
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static void i(Context context, c.a.r0.a.z2.g1.c<String> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, context, cVar) == null) {
            c.a.r0.a.h0.i.f.e(cVar);
        }
    }

    public static String j(@NonNull c.a.r0.a.d2.e eVar) {
        InterceptResult invokeL;
        String str;
        SwanAppConfigData.h hVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, eVar)) == null) {
            PMSAppInfo f0 = eVar.V().f0();
            if (f0 == null) {
                return "no info";
            }
            StringBuilder sb = new StringBuilder();
            boolean i2 = c.a.r0.a.m1.d.d.g().i(f0);
            boolean j0 = c.a.r0.a.h0.u.g.U().j0();
            boolean z = false;
            SwanAppConfigData P = eVar.P();
            if (P == null || (hVar = P.t) == null) {
                str = "";
            } else {
                z = hVar.a;
                str = hVar.f39361b;
            }
            sb.append("is server on: ");
            sb.append(i2);
            sb.append(StringUtils.LF);
            sb.append("app.json info: ");
            sb.append("enabled/");
            sb.append(z);
            sb.append(", trigger/");
            sb.append(str);
            sb.append(StringUtils.LF);
            sb.append("is hit: ");
            sb.append(j0);
            sb.append(StringUtils.LF);
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            long nanoTime = a ? System.nanoTime() : 0L;
            e.d g2 = c.a.r0.a.e0.g.e.c().g();
            if (a) {
                r0 = "获取内存信息耗时: " + ((System.nanoTime() - nanoTime) / 1000000) + " ms";
            }
            return "设备总内存：" + g2.f5725c + " M，设备剩余内存：" + g2.f5726d + " M，小程序启动占用内存：" + g2.a + " M，宿主APP占用内存：" + g2.f5724b + " M\n";
        }
        return (String) invokeV.objValue;
    }

    public static String l(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, context)) == null) {
            long nanoTime = a ? System.nanoTime() : 0L;
            c.a.r0.a.d2.e a0 = c.a.r0.a.d2.e.a0();
            if (a0 == null || context == null) {
                return "";
            }
            String str = "=========================\n= " + a0.V().K() + "\n=========================\n===== 小程序信息 =====\n" + c(context) + "\n===== 设备信息 =====\n" + d(context) + "\n===== 宿主信息 =====\n" + h(context) + "\n===== 内存信息 =====\n" + k() + "\n===== onPrefetch信息 =====\n" + j(a0) + StringUtils.LF;
            if (a) {
                StringBuilder sb = new StringBuilder();
                sb.append("获取启动时信息耗时：");
                sb.append((System.nanoTime() - nanoTime) / 1000000);
                sb.append(" ms 是否主线程：");
                sb.append(Looper.getMainLooper() == Looper.myLooper());
                sb.toString();
            }
            c.a.r0.a.e0.d.k("SwanAppEnvironmentUtils", str);
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static void m(Activity activity) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65549, null, activity) == null) || activity == null) {
            return;
        }
        try {
            str = l(activity);
        } catch (Exception e2) {
            if (!a) {
                c.a.r0.a.e0.d.l("SwanAppEnvironmentUtils", "getExtraInfo error", e2);
                str = "";
            } else {
                throw e2;
            }
        }
        c.a.r0.a.e0.d.k("SwanAppEnvironmentUtils", "recordExtraInfoToLogSystem\n--------------------ExtraInfo list----------------------\n" + str + "--------------------ExtraInfo end-----------------------");
        String k = c.a.r0.a.c1.a.g0().k();
        c.a.r0.a.e0.d.k("SwanAppEnvironmentUtils", "sid = " + k);
        c.a.r0.a.h0.o.e.a.k();
    }
}
