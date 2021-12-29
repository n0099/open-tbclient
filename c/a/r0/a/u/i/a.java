package c.a.r0.a.u.i;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import c.a.r0.a.k;
import c.a.r0.a.p.e.d;
import c.a.r0.a.u.h.b;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f9539b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(693413875, "Lc/a/r0/a/u/i/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(693413875, "Lc/a/r0/a/u/i/a;");
                return;
            }
        }
        a = k.a;
        f9539b = new String[]{"swan", "swanAPI", "utils"};
    }

    @NonNull
    public static Pair<Boolean, c.a.r0.a.u.h.a> a(c.a.r0.a.u.c.a aVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, aVar, str)) == null) {
            b bVar = new b();
            boolean b2 = b(str, aVar.a().h());
            if (b2) {
                bVar.f9529b = 402;
            }
            return new Pair<>(Boolean.valueOf(b2), bVar);
        }
        return (Pair) invokeLL.objValue;
    }

    @SuppressLint({"BDThrowableCheck"})
    public static boolean b(String str, CallbackHandler callbackHandler) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, callbackHandler)) == null) {
            if (!(callbackHandler instanceof d)) {
                boolean z2 = a;
                return false;
            } else if (TextUtils.isEmpty(str)) {
                if (a) {
                    throw new RuntimeException("whitelistName is empty");
                }
                return false;
            } else {
                String d0 = ((d) callbackHandler).d0();
                if ("ai_apps_widget".equals(d0)) {
                    z = c(str);
                } else if ("ai_apps_ad_landing".equals(d0)) {
                    z = !c.a.r0.a.e2.a.b.a(str);
                } else if ("swan_app_alliance_login_widget".equals(d0) || "swan_app_alliance_choose_address_widget".equals(d0)) {
                    return false;
                } else {
                    boolean z3 = a;
                    return false;
                }
                if (a) {
                    String str2 = "intercept: result=" + z + ", path=" + str;
                }
                return z;
            }
        }
        return invokeLL.booleanValue;
    }

    public static boolean c(@NonNull String str) {
        InterceptResult invokeL;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            int indexOf = str.indexOf("/");
            if (indexOf < 0) {
                return true;
            }
            if (str.startsWith("swan")) {
                String substring = str.substring(indexOf + 1);
                for (String str2 : f9539b) {
                    if (c.a.r0.a.e2.a.b.g(str2 + "/" + substring)) {
                        return false;
                    }
                }
                return true;
            }
            return !c.a.r0.a.e2.a.b.g(str);
        }
        return invokeL.booleanValue;
    }
}
