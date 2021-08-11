package c.a.n0.a.u.i;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import c.a.n0.a.k;
import c.a.n0.a.p.e.d;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f8899a;

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f8900b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-708715281, "Lc/a/n0/a/u/i/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-708715281, "Lc/a/n0/a/u/i/a;");
                return;
            }
        }
        f8899a = k.f6803a;
        f8900b = new String[]{"swan", "swanAPI", "utils"};
    }

    @NonNull
    public static Pair<Boolean, c.a.n0.a.u.h.a> a(c.a.n0.a.u.c.a aVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, aVar, str)) == null) {
            c.a.n0.a.u.h.b bVar = new c.a.n0.a.u.h.b();
            boolean b2 = b(str, aVar.a().h());
            if (b2) {
                bVar.f8895b = 402;
            }
            return new Pair<>(Boolean.valueOf(b2), bVar);
        }
        return (Pair) invokeLL.objValue;
    }

    public static boolean b(String str, CallbackHandler callbackHandler) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, callbackHandler)) == null) {
            if (!(callbackHandler instanceof d)) {
                boolean z2 = f8899a;
                return false;
            } else if (TextUtils.isEmpty(str)) {
                if (f8899a) {
                    throw new RuntimeException("whitelistName is empty");
                }
                return false;
            } else {
                String b0 = ((d) callbackHandler).b0();
                if ("ai_apps_widget".equals(b0)) {
                    z = c(str);
                } else if ("ai_apps_ad_landing".equals(b0)) {
                    z = !c.a.n0.a.b2.a.b.a(str);
                } else if ("swan_app_alliance_login_widget".equals(b0) || "swan_app_alliance_choose_address_widget".equals(b0)) {
                    return false;
                } else {
                    boolean z3 = f8899a;
                    return false;
                }
                if (f8899a) {
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
                for (String str2 : f8900b) {
                    if (c.a.n0.a.b2.a.b.g(str2 + "/" + substring)) {
                        return false;
                    }
                }
                return true;
            }
            return !c.a.n0.a.b2.a.b.g(str);
        }
        return invokeL.booleanValue;
    }
}
