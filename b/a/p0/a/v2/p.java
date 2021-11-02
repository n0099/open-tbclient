package b.a.p0.a.v2;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.text.format.Formatter;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.f1.e.b;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes.dex */
public class p {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f8626a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1337554952, "Lb/a/p0/a/v2/p;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1337554952, "Lb/a/p0/a/v2/p;");
                return;
            }
        }
        f8626a = b.a.p0.a.k.f6397a;
    }

    public static String a(int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            if (f8626a) {
                return b.a.p0.a.u1.a.a.p() ? j.d(i2, true) : "";
            }
            return j.d(i2, z);
        }
        return (String) invokeCommon.objValue;
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            b.a.p0.a.a2.e P = b.a.p0.a.a2.e.P();
            if (context == null || P == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            int l = P.l();
            if (l != -1) {
                b.a K = P.K();
                sb.append(c(l));
                sb.append(StringUtils.LF);
                if (l == 0) {
                    sb.append(e(l));
                    sb.append(StringUtils.LF);
                }
                if (P.l0()) {
                    sb.append("host version : ");
                    sb.append(q0.u(AppRuntime.getAppContext(), AppRuntime.getAppContext().getPackageName()));
                    sb.append(StringUtils.LF);
                } else {
                    sb.append("native version : ");
                    sb.append(b.a.p0.d.c.getContext() != null ? b.a.p0.d.c.getContext().b() : "");
                    sb.append(StringUtils.LF);
                }
                sb.append("enable V8: ");
                sb.append(b.a.p0.a.h0.u.g.M().g0());
                sb.append(StringUtils.LF);
                sb.append("aps version: ");
                sb.append(TextUtils.isEmpty(K.s1()) ? "" : K.s1());
                sb.append(StringUtils.LF);
                String formatFileSize = Formatter.formatFileSize(AppRuntime.getAppContext(), K.f1());
                sb.append("app bundle size: ");
                if (TextUtils.isEmpty(formatFileSize)) {
                    formatFileSize = "";
                }
                sb.append(formatFileSize);
                sb.append(StringUtils.LF);
                sb.append("app bundle version: ");
                sb.append(TextUtils.isEmpty(K.t1()) ? "" : K.t1());
                sb.append(StringUtils.LF);
                sb.append("app is opt pkg: ");
                sb.append(b.a.p0.a.l1.d.d.f().g(K.e0()));
                sb.append(StringUtils.LF);
                String b2 = b.a.p0.a.c1.b.h().b();
                if (!TextUtils.isEmpty(b2)) {
                    sb.append("app sconsole version: ");
                    sb.append(b2);
                    sb.append(StringUtils.LF);
                }
                if (P.l0()) {
                    sb.append("game engine version: ");
                    sb.append("1.3.2.3");
                    sb.append(StringUtils.LF);
                }
                if (!P.l0()) {
                    String a2 = a(0, b.a.p0.a.h0.u.g.M().g0());
                    sb.append("jsNativeEnable: ");
                    sb.append(!TextUtils.isEmpty(a2));
                    sb.append(StringUtils.LF);
                }
                if (!P.l0()) {
                    boolean m = b.a.p0.a.p0.f.b.m();
                    sb.append("debugDynamicLibEnable: ");
                    sb.append(m);
                    sb.append('\n');
                    if (m) {
                        List<String> o = b.a.p0.a.p0.f.b.o();
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
                }
                sb.append("so version: ");
                sb.append(b.a.p0.a.k2.g.h.a().getLong("swan_so_installed_version_code_zeus", 0L));
                sb.append(StringUtils.LF);
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) {
            StringBuilder sb = new StringBuilder();
            SwanCoreVersion L = b.a.p0.a.g1.f.T().L();
            sb.append(i2 == 1 ? "game-core" : "swan-js");
            sb.append(" version : ");
            sb.append(b.a.p0.a.m2.b.i(L, i2));
            return sb.toString();
        }
        return (String) invokeI.objValue;
    }

    public static String d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            return "model: " + Build.MODEL + StringUtils.LF + "android: " + Build.VERSION.RELEASE + StringUtils.LF + "api level: " + Build.VERSION.SDK_INT + StringUtils.LF + "cuid: " + b.a.p0.a.c1.a.a0().i(b.a.p0.a.c1.a.b()) + StringUtils.LF;
        }
        return (String) invokeL.objValue;
    }

    public static String e(int i2) {
        InterceptResult invokeI;
        String str;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(AdIconUtil.AD_TEXT_ID, null, i2)) == null) {
            StringBuilder sb = new StringBuilder();
            if (i2 == 0) {
                ExtensionCore L = b.a.p0.a.h0.u.g.M().L();
                if (L != null) {
                    str = L.extensionCoreVersionName;
                    i3 = L.extensionCoreType;
                } else {
                    str = "";
                    i3 = -1;
                }
                sb.append("extension-js version : ");
                sb.append(str);
                sb.append("   type：");
                sb.append(i3);
            }
            return sb.toString();
        }
        return (String) invokeI.objValue;
    }

    public static String f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, context)) == null) {
            b.a.p0.d.a context2 = b.a.p0.d.c.getContext();
            StringBuilder sb = new StringBuilder();
            sb.append("name: ");
            sb.append(b.a.p0.a.c1.a.m().a());
            sb.append(StringUtils.LF);
            sb.append("version: ");
            sb.append(context2 != null ? context2.i() : "");
            sb.append(StringUtils.LF);
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static void g(Context context, b.a.p0.a.v2.e1.b<String> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, context, bVar) == null) {
            b.a.p0.a.h0.i.i.f(bVar);
        }
    }

    public static String h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            b.a.p0.a.a2.e P = b.a.p0.a.a2.e.P();
            if (P == null || context == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            sb.append("=========================");
            sb.append(StringUtils.LF);
            sb.append("= ");
            sb.append(P.K().J());
            sb.append(StringUtils.LF);
            sb.append("=========================");
            sb.append(StringUtils.LF);
            sb.append("===== 小程序信息 =====");
            sb.append(StringUtils.LF);
            sb.append(b(context));
            sb.append(StringUtils.LF);
            sb.append("===== 设备信息 =====");
            sb.append(StringUtils.LF);
            sb.append(d(context));
            sb.append(StringUtils.LF);
            sb.append("===== 宿主信息 =====");
            sb.append(StringUtils.LF);
            sb.append(f(context));
            sb.append(StringUtils.LF);
            b.a.p0.a.e0.d.h("SwanAppEnvironmentUtils", sb.toString());
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static void i(Activity activity) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65545, null, activity) == null) || activity == null) {
            return;
        }
        try {
            str = h(activity);
        } catch (Exception e2) {
            if (!f8626a) {
                b.a.p0.a.e0.d.i("SwanAppEnvironmentUtils", "getExtraInfo error", e2);
                str = "";
            } else {
                throw e2;
            }
        }
        b.a.p0.a.e0.d.h("SwanAppEnvironmentUtils", "recordExtraInfoToLogSystem\n--------------------ExtraInfo list----------------------\n" + str + "--------------------ExtraInfo end-----------------------");
        String k = b.a.p0.a.c1.a.Z().k();
        b.a.p0.a.e0.d.h("SwanAppEnvironmentUtils", "sid = " + k);
        b.a.p0.a.h0.o.e.a.i();
    }
}
