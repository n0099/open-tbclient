package c.a.p0.a.m0;

import android.text.TextUtils;
import c.a.p0.q.j.i.h;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Arrays;
/* loaded from: classes.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(823624715, "Lc/a/p0/a/m0/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(823624715, "Lc/a/p0/a/m0/e;");
                return;
            }
        }
        boolean z = c.a.p0.a.a.a;
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            String[] b2 = h.a().b();
            c.a.p0.a.u.d.b("SwanHistoryQueryHelper", "no history app list: " + Arrays.toString(b2));
            if (b2 != null && b2.length != 0 && (str == null || !str.equals("sync_state=?"))) {
                String format = String.format("%s %s NOT IN ('%s')", (str == null || str.trim().length() <= 0) ? "" : String.format("(%s) AND ", str.trim()), String.format("%s.%s", "ai_apps_history", "app_id"), TextUtils.join("','", b2));
                c.a.p0.a.u.d.b("SwanHistoryQueryHelper", "origin Selection: " + str + ", created selection: " + format);
                return format;
            }
            c.a.p0.a.u.d.b("SwanHistoryQueryHelper", "origin Selection: " + str + ", created selection: " + str);
            return str;
        }
        return (String) invokeL.objValue;
    }
}
