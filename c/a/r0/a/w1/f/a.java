package c.a.r0.a.w1.f;

import android.text.TextUtils;
import android.util.Log;
import c.a.r0.a.a1.d;
import c.a.r0.a.k;
import c.a.r0.a.z2.l0;
import c.a.r0.q.i.i;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1801286783, "Lc/a/r0/a/w1/f/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1801286783, "Lc/a/r0/a/w1/f/a;");
                return;
            }
        }
        a = k.a;
    }

    public static void a() {
        String[] list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65537, null) == null) || (list = d.q().list()) == null || list.length <= 0) {
            return;
        }
        for (String str : list) {
            if (!TextUtils.isEmpty(str)) {
                i iVar = new i();
                iVar.f11494g = str;
                iVar.f11496i = -1L;
                c.a.r0.q.g.a.i().f(iVar);
            }
        }
        d.e.d();
    }

    public static void b(String str) {
        File s;
        String[] list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, str) == null) || TextUtils.isEmpty(str) || (s = d.s(str)) == null || (list = s.list()) == null || list.length <= 1) {
            return;
        }
        List<i> q = c.a.r0.a.w1.c.a.q(str);
        for (String str2 : list) {
            long j2 = -1;
            try {
                j2 = Long.parseLong(str2);
            } catch (NumberFormatException e2) {
                if (a) {
                    c.a.r0.a.w1.e.a.b(Log.getStackTraceString(e2));
                }
            }
            if (!c(j2, q)) {
                c.a.r0.w.d.L(d.t(str, str2));
                c.a.r0.a.w1.e.a.b("delete plugin name = " + str + " ; version = " + str2);
            }
        }
        i iVar = null;
        if (q != null) {
            if (q.size() == 1) {
                iVar = q.get(0);
            } else if (q.size() >= 2) {
                iVar = q.get(1);
            }
        }
        if (iVar != null) {
            c.a.r0.q.g.a.i().f(iVar);
        }
    }

    public static boolean c(long j2, List<i> list) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65539, null, j2, list)) == null) {
            if (j2 >= 0 && list != null && list.size() != 0) {
                int min = Math.min(list.size(), 2);
                for (int i2 = 0; i2 < min; i2++) {
                    i iVar = list.get(i2);
                    if (iVar != null && (j2 == iVar.f11496i || j2 == l0.c(iVar.f11497j))) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeJL.booleanValue;
    }
}
