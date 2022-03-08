package c.a.p0.a.m1.f;

import android.text.TextUtils;
import android.util.Log;
import c.a.p0.a.p2.l0;
import c.a.p0.a.q0.d;
import c.a.p0.q.h.i;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1258019127, "Lc/a/p0/a/m1/f/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1258019127, "Lc/a/p0/a/m1/f/a;");
                return;
            }
        }
        a = c.a.p0.a.a.a;
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
                iVar.f10961g = str;
                iVar.f10963i = -1L;
                c.a.p0.q.f.a.i().f(iVar);
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
        List<i> q = c.a.p0.a.m1.c.a.q(str);
        for (String str2 : list) {
            long j2 = -1;
            try {
                j2 = Long.parseLong(str2);
            } catch (NumberFormatException e2) {
                if (a) {
                    c.a.p0.a.m1.e.a.b(Log.getStackTraceString(e2));
                }
            }
            if (!c(j2, q)) {
                c.a.p0.w.d.L(d.t(str, str2));
                c.a.p0.a.m1.e.a.b("delete plugin name = " + str + " ; version = " + str2);
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
            c.a.p0.q.f.a.i().f(iVar);
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
                    if (iVar != null && (j2 == iVar.f10963i || j2 == l0.c(iVar.f10964j))) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeJL.booleanValue;
    }
}
