package c.a.q0.a.n0.h;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.a.k;
import c.a.q0.q.i.h;
import c.a.q0.q.p.g;
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
    public static final Map<String, Integer> f7206b;

    /* renamed from: c  reason: collision with root package name */
    public static final Object f7207c;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f7208d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2048931307, "Lc/a/q0/a/n0/h/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2048931307, "Lc/a/q0/a/n0/h/b;");
                return;
            }
        }
        a = k.a;
        f7206b = new HashMap();
        f7207c = new Object();
        f7208d = c.a();
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65537, null) == null) && f7208d) {
            boolean z = a;
            synchronized (f7207c) {
                f7206b.clear();
            }
        }
    }

    @NonNull
    public static Set<String> b() {
        InterceptResult invokeV;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (!f7208d) {
                return Collections.emptySet();
            }
            synchronized (f7207c) {
                strArr = (String[]) f7206b.keySet().toArray(new String[0]);
            }
            return c.a.q0.a.z2.a1.a.a(strArr);
        }
        return (Set) invokeV.objValue;
    }

    public static boolean c(String str) {
        InterceptResult invokeL;
        boolean containsKey;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (f7208d && !TextUtils.isEmpty(str)) {
                synchronized (f7207c) {
                    containsKey = f7206b.containsKey(str);
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
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str) == null) && f7208d) {
            if (a) {
                String str2 = "record one appId for exclude - " + str;
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            synchronized (f7207c) {
                Integer num = f7206b.get(str);
                if (num == null) {
                    f7206b.put(str, 1);
                } else {
                    f7206b.put(str, Integer.valueOf(num.intValue() + 1));
                }
            }
        }
    }

    public static void e(g gVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, null, gVar) == null) && f7208d && gVar != null) {
            for (c.a.q0.q.i.f fVar : gVar.j()) {
                if (fVar instanceof c.a.q0.q.i.g) {
                    d(fVar.f11026g);
                } else if (fVar instanceof h) {
                    d(((h) fVar).o);
                }
            }
        }
    }

    public static void f(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65542, null, str) == null) && f7208d) {
            if (a) {
                String str2 = "remove one appId for exclude - " + str;
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            synchronized (f7207c) {
                Integer num = f7206b.get(str);
                if (num != null) {
                    int intValue = num.intValue() - 1;
                    if (intValue <= 0) {
                        f7206b.remove(str);
                    } else {
                        f7206b.put(str, Integer.valueOf(intValue));
                    }
                }
            }
        }
    }
}
