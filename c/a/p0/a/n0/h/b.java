package c.a.p0.a.n0.h;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.k;
import c.a.p0.q.i.h;
import c.a.p0.q.p.g;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static final Map<String, Integer> f6897b;

    /* renamed from: c  reason: collision with root package name */
    public static final Object f6898c;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f6899d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2116953270, "Lc/a/p0/a/n0/h/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2116953270, "Lc/a/p0/a/n0/h/b;");
                return;
            }
        }
        a = k.a;
        f6897b = new HashMap();
        f6898c = new Object();
        f6899d = c.a();
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65537, null) == null) && f6899d) {
            boolean z = a;
            synchronized (f6898c) {
                f6897b.clear();
            }
        }
    }

    @NonNull
    public static Set<String> b() {
        InterceptResult invokeV;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (!f6899d) {
                return Collections.emptySet();
            }
            synchronized (f6898c) {
                strArr = (String[]) f6897b.keySet().toArray(new String[0]);
            }
            return c.a.p0.a.z2.a1.a.a(strArr);
        }
        return (Set) invokeV.objValue;
    }

    public static boolean c(String str) {
        InterceptResult invokeL;
        boolean containsKey;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (f6899d && !TextUtils.isEmpty(str)) {
                synchronized (f6898c) {
                    containsKey = f6897b.containsKey(str);
                }
                if (a) {
                    String str2 = "appId - " + str + " needExclude - " + containsKey;
                }
                return containsKey;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str) == null) && f6899d) {
            if (a) {
                String str2 = "record one appId for exclude - " + str;
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            synchronized (f6898c) {
                Integer num = f6897b.get(str);
                if (num == null) {
                    f6897b.put(str, 1);
                } else {
                    f6897b.put(str, Integer.valueOf(num.intValue() + 1));
                }
            }
        }
    }

    public static void e(g gVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, null, gVar) == null) && f6899d && gVar != null) {
            for (c.a.p0.q.i.f fVar : gVar.j()) {
                if (fVar instanceof c.a.p0.q.i.g) {
                    d(fVar.f10717g);
                } else if (fVar instanceof h) {
                    d(((h) fVar).o);
                }
            }
        }
    }

    public static void f(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65542, null, str) == null) && f6899d) {
            if (a) {
                String str2 = "remove one appId for exclude - " + str;
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            synchronized (f6898c) {
                Integer num = f6897b.get(str);
                if (num != null) {
                    int intValue = num.intValue() - 1;
                    if (intValue <= 0) {
                        f6897b.remove(str);
                    } else {
                        f6897b.put(str, Integer.valueOf(intValue));
                    }
                }
            }
        }
    }
}
