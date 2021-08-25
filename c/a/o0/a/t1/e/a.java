package c.a.o0.a.t1.e;

import android.text.TextUtils;
import android.util.Log;
import c.a.o0.a.a1.e;
import c.a.o0.a.k;
import c.a.o0.a.v2.l0;
import c.a.o0.n.h.h;
import c.a.o0.t.d;
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

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f8676a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1248502208, "Lc/a/o0/a/t1/e/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1248502208, "Lc/a/o0/a/t1/e/a;");
                return;
            }
        }
        f8676a = k.f7049a;
    }

    public static void a() {
        String[] list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65537, null) == null) || (list = e.q().list()) == null || list.length <= 0) {
            return;
        }
        for (String str : list) {
            if (!TextUtils.isEmpty(str)) {
                h hVar = new h();
                hVar.f11857g = str;
                hVar.f11859i = -1L;
                c.a.o0.n.g.a.h().f(hVar);
            }
        }
        e.C0112e.d();
    }

    public static void b(String str) {
        File s;
        String[] list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, str) == null) || TextUtils.isEmpty(str) || (s = e.s(str)) == null || (list = s.list()) == null || list.length <= 1) {
            return;
        }
        List<h> j2 = c.a.o0.a.t1.b.a.j(str);
        for (String str2 : list) {
            long j3 = -1;
            try {
                j3 = Long.parseLong(str2);
            } catch (NumberFormatException e2) {
                if (f8676a) {
                    c.a.o0.a.t1.d.a.a(Log.getStackTraceString(e2));
                }
            }
            if (!c(j3, j2)) {
                d.K(e.t(str, str2));
                c.a.o0.a.t1.d.a.a("delete plugin name = " + str + " ; version = " + str2);
            }
        }
        h hVar = null;
        if (j2 != null) {
            if (j2.size() == 1) {
                hVar = j2.get(0);
            } else if (j2.size() >= 2) {
                hVar = j2.get(1);
            }
        }
        if (hVar != null) {
            c.a.o0.n.g.a.h().f(hVar);
        }
    }

    public static boolean c(long j2, List<h> list) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65539, null, j2, list)) == null) {
            if (j2 >= 0 && list != null && list.size() != 0) {
                int min = Math.min(list.size(), 2);
                for (int i2 = 0; i2 < min; i2++) {
                    h hVar = list.get(i2);
                    if (hVar != null && (j2 == hVar.f11859i || j2 == l0.c(hVar.f11860j))) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeJL.booleanValue;
    }
}
