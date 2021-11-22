package b.a.p0.a.e0;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.g1.f;
import b.a.p0.a.h;
import b.a.p0.a.k;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bumptech.glide.load.engine.GlideException;
import java.util.Date;
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f4532a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1321795141, "Lb/a/p0/a/e0/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1321795141, "Lb/a/p0/a/e0/d;");
        }
    }

    public static String a(@Nullable String str, @Nullable String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str2;
            }
            return PreferencesUtil.LEFT_MOUNT + str + "] " + str2;
        }
        return (String) invokeLL.objValue;
    }

    public static void b(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65538, null, str, objArr) == null) && k.f6863a && objArr != null) {
            StringBuilder sb = new StringBuilder();
            for (Object obj : objArr) {
                if (obj != null) {
                    sb.append(obj.toString());
                }
            }
            sb.toString();
        }
    }

    public static void c(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, str, str2) == null) {
            m("error", str, str2);
            b.a.p0.a.c1.a.p0().e(str, str2);
            boolean z = k.f6863a;
        }
    }

    public static void d(String str, String str2, Throwable th) {
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2, th) == null) {
            if (th != null) {
                str3 = "Exception:" + th.getMessage() + StringUtils.LF + str2;
            } else {
                str3 = str2;
            }
            m("error", str, str3);
            b.a.p0.a.c1.a.p0().e(str, str2, th);
            boolean z = k.f6863a;
        }
    }

    public static void e(String str, String str2, String str3, @Nullable Throwable th, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{str, str2, str3, th, Boolean.valueOf(z)}) == null) {
            String a2 = a(str2, str3);
            b.a.p0.a.c1.a.p0().e(str, a2, th);
            if (z) {
                m("error", str, a2);
            }
        }
    }

    public static boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? f4532a : invokeV.booleanValue;
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            if (stackTrace != null && stackTrace.length > 5) {
                return stackTrace[5].getFileName();
            }
            return AppRuntime.getAppContext().getString(h.aiapps_err_message_get_name_fail);
        }
        return (String) invokeV.objValue;
    }

    public static int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            if (stackTrace == null || stackTrace.length <= 5) {
                return -1;
            }
            return stackTrace[5].getLineNumber();
        }
        return invokeV.intValue;
    }

    public static void i(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, str, str2) == null) {
            m("info", str, str2);
            b.a.p0.a.c1.a.p0().i(str, str2);
            boolean z = k.f6863a;
        }
    }

    public static void j(String str, String str2, String str3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{str, str2, str3, Boolean.valueOf(z)}) == null) {
            String a2 = a(str2, str3);
            b.a.p0.a.c1.a.p0().i(str, a2);
            if (z) {
                m("info", str, a2);
            }
        }
    }

    public static void k(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, str, str2) == null) {
            b.a.p0.a.c1.a.p0().i(str, str2);
            boolean z = k.f6863a;
        }
    }

    public static void l(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65548, null, str, str2, th) == null) {
            b.a.p0.a.c1.a.p0().e(str, str2, th);
            boolean z = k.f6863a;
        }
    }

    public static void m(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65549, null, str, str2, str3) == null) && f4532a && !TextUtils.isEmpty(str3)) {
            StringBuilder sb = new StringBuilder();
            String b2 = b.a.p0.a.z2.k.b(new Date(), "yyyy-MM-dd HH:mm:ss");
            String g2 = g();
            int h2 = h();
            sb.append(b2);
            sb.append(GlideException.IndentedAppendable.INDENT);
            sb.append(g2);
            sb.append(GlideException.IndentedAppendable.INDENT);
            sb.append("line:");
            sb.append(h2);
            sb.append(StringUtils.LF);
            sb.append("module:");
            sb.append(str2);
            sb.append(StringUtils.LF);
            sb.append(str3);
            f.U().p().i0(str, sb.toString());
        }
    }

    public static void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65550, null, z) == null) {
            f4532a = z;
        }
    }

    public static void o(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65551, null, str, str2) == null) {
            m("warn", str, str2);
            b.a.p0.a.c1.a.p0().w(str, str2);
            boolean z = k.f6863a;
        }
    }

    public static void p(String str, String str2, String str3, @Nullable Throwable th, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65552, null, new Object[]{str, str2, str3, th, Boolean.valueOf(z)}) == null) {
            String a2 = a(str2, str3);
            b.a.p0.a.c1.a.p0().w(str, a2, th);
            if (z) {
                m("warn", str, a2);
            }
        }
    }
}
