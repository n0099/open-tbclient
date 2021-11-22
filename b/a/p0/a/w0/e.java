package b.a.p0.a.w0;

import android.text.TextUtils;
import b.a.p0.a.k;
import b.a.p0.q.k.i.h;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1338418550, "Lb/a/p0/a/w0/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1338418550, "Lb/a/p0/a/w0/e;");
                return;
            }
        }
        boolean z = k.f6863a;
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            String[] b2 = h.a().b();
            b.a.p0.a.e0.d.b("SwanHistoryQueryHelper", "no history app list: " + Arrays.toString(b2));
            if (b2 != null && b2.length != 0 && (str == null || !str.equals("sync_state=?"))) {
                String format = String.format("%s %s NOT IN ('%s')", (str == null || str.trim().length() <= 0) ? "" : String.format("(%s) AND ", str.trim()), String.format("%s.%s", "ai_apps_history", "app_id"), TextUtils.join("','", b2));
                b.a.p0.a.e0.d.b("SwanHistoryQueryHelper", "origin Selection: " + str + ", created selection: " + format);
                return format;
            }
            b.a.p0.a.e0.d.b("SwanHistoryQueryHelper", "origin Selection: " + str + ", created selection: " + str);
            return str;
        }
        return (String) invokeL.objValue;
    }
}
