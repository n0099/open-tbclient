package c.a.n0.a.d0.h;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.q.h.h;
import c.a.n0.q.o.g;
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
    public static final Map<String, Integer> f4028b;

    /* renamed from: c  reason: collision with root package name */
    public static final Object f4029c;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f4030d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1573685614, "Lc/a/n0/a/d0/h/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1573685614, "Lc/a/n0/a/d0/h/b;");
                return;
            }
        }
        a = c.a.n0.a.a.a;
        f4028b = new HashMap();
        f4029c = new Object();
        f4030d = c.a();
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65537, null) == null) && f4030d) {
            if (a) {
                Log.d("ExcludeRecorder", "remove all exclude appIds");
            }
            synchronized (f4029c) {
                f4028b.clear();
            }
        }
    }

    @NonNull
    public static Set<String> b() {
        InterceptResult invokeV;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (!f4030d) {
                return Collections.emptySet();
            }
            synchronized (f4029c) {
                strArr = (String[]) f4028b.keySet().toArray(new String[0]);
            }
            return c.a.n0.a.p2.a1.a.a(strArr);
        }
        return (Set) invokeV.objValue;
    }

    public static boolean c(String str) {
        InterceptResult invokeL;
        boolean containsKey;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (f4030d && !TextUtils.isEmpty(str)) {
                synchronized (f4029c) {
                    containsKey = f4028b.containsKey(str);
                }
                if (a) {
                    Log.d("ExcludeRecorder", "appId - " + str + " needExclude - " + containsKey);
                }
                return containsKey;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str) == null) && f4030d) {
            if (a) {
                Log.d("ExcludeRecorder", "record one appId for exclude - " + str);
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            synchronized (f4029c) {
                Integer num = f4028b.get(str);
                if (num == null) {
                    f4028b.put(str, 1);
                } else {
                    f4028b.put(str, Integer.valueOf(num.intValue() + 1));
                }
            }
        }
    }

    public static void e(g gVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, null, gVar) == null) && f4030d && gVar != null) {
            for (c.a.n0.q.h.f fVar : gVar.j()) {
                if (fVar instanceof c.a.n0.q.h.g) {
                    d(fVar.f9145g);
                } else if (fVar instanceof h) {
                    d(((h) fVar).o);
                }
            }
        }
    }

    public static void f(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65542, null, str) == null) && f4030d) {
            if (a) {
                Log.d("ExcludeRecorder", "remove one appId for exclude - " + str);
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            synchronized (f4029c) {
                Integer num = f4028b.get(str);
                if (num != null) {
                    int intValue = num.intValue() - 1;
                    if (intValue <= 0) {
                        f4028b.remove(str);
                    } else {
                        f4028b.put(str, Integer.valueOf(intValue));
                    }
                }
            }
        }
    }
}
