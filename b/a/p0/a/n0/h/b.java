package b.a.p0.a.n0.h;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.k;
import b.a.p0.n.h.g;
import com.baidu.mobads.container.util.AdIconUtil;
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

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f6795a;

    /* renamed from: b  reason: collision with root package name */
    public static final Map<String, Integer> f6796b;

    /* renamed from: c  reason: collision with root package name */
    public static final Object f6797c;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f6798d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1667479849, "Lb/a/p0/a/n0/h/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1667479849, "Lb/a/p0/a/n0/h/b;");
                return;
            }
        }
        f6795a = k.f6397a;
        f6796b = new HashMap();
        f6797c = new Object();
        f6798d = c.a();
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65537, null) == null) && f6798d) {
            boolean z = f6795a;
            synchronized (f6797c) {
                f6796b.clear();
            }
        }
    }

    @NonNull
    public static Set<String> b() {
        InterceptResult invokeV;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (!f6798d) {
                return Collections.emptySet();
            }
            synchronized (f6797c) {
                strArr = (String[]) f6796b.keySet().toArray(new String[0]);
            }
            return b.a.p0.a.v2.z0.a.a(strArr);
        }
        return (Set) invokeV.objValue;
    }

    public static boolean c(String str) {
        InterceptResult invokeL;
        boolean containsKey;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (f6798d && !TextUtils.isEmpty(str)) {
                synchronized (f6797c) {
                    containsKey = f6796b.containsKey(str);
                }
                if (f6795a) {
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
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str) == null) && f6798d) {
            if (f6795a) {
                String str2 = "record one appId for exclude - " + str;
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            synchronized (f6797c) {
                Integer num = f6796b.get(str);
                if (num == null) {
                    f6796b.put(str, 1);
                } else {
                    f6796b.put(str, Integer.valueOf(num.intValue() + 1));
                }
            }
        }
    }

    public static void e(b.a.p0.n.o.f fVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, fVar) == null) && f6798d && fVar != null) {
            for (b.a.p0.n.h.e eVar : fVar.h()) {
                if (eVar instanceof b.a.p0.n.h.f) {
                    d(eVar.f11076g);
                } else if (eVar instanceof g) {
                    d(((g) eVar).o);
                }
            }
        }
    }

    public static void f(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str) == null) && f6798d) {
            if (f6795a) {
                String str2 = "remove one appId for exclude - " + str;
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            synchronized (f6797c) {
                Integer num = f6796b.get(str);
                if (num != null) {
                    int intValue = num.intValue() - 1;
                    if (intValue <= 0) {
                        f6796b.remove(str);
                    } else {
                        f6796b.put(str, Integer.valueOf(intValue));
                    }
                }
            }
        }
    }
}
