package c.a.n0.a.m1.f;

import android.text.TextUtils;
import android.util.Log;
import c.a.n0.a.p2.l0;
import c.a.n0.a.q0.d;
import c.a.n0.q.h.i;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(999853689, "Lc/a/n0/a/m1/f/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(999853689, "Lc/a/n0/a/m1/f/a;");
                return;
            }
        }
        a = c.a.n0.a.a.a;
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
                iVar.f9145g = str;
                iVar.i = -1L;
                c.a.n0.q.f.a.i().f(iVar);
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
        List<i> q = c.a.n0.a.m1.c.a.q(str);
        for (String str2 : list) {
            long j = -1;
            try {
                j = Long.parseLong(str2);
            } catch (NumberFormatException e2) {
                if (a) {
                    c.a.n0.a.m1.e.a.b(Log.getStackTraceString(e2));
                }
            }
            if (!c(j, q)) {
                c.a.n0.w.d.L(d.t(str, str2));
                c.a.n0.a.m1.e.a.b("delete plugin name = " + str + " ; version = " + str2);
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
            c.a.n0.q.f.a.i().f(iVar);
        }
    }

    public static boolean c(long j, List<i> list) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65539, null, j, list)) == null) {
            if (j >= 0 && list != null && list.size() != 0) {
                int min = Math.min(list.size(), 2);
                for (int i = 0; i < min; i++) {
                    i iVar = list.get(i);
                    if (iVar != null && (j == iVar.i || j == l0.c(iVar.j))) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeJL.booleanValue;
    }
}
