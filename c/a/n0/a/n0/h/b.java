package c.a.n0.a.n0.h;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.k;
import c.a.n0.n.h.g;
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
    public static final boolean f7207a;

    /* renamed from: b  reason: collision with root package name */
    public static final Map<String, Integer> f7208b;

    /* renamed from: c  reason: collision with root package name */
    public static final Object f7209c;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f7210d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1858787832, "Lc/a/n0/a/n0/h/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1858787832, "Lc/a/n0/a/n0/h/b;");
                return;
            }
        }
        f7207a = k.f6803a;
        f7208b = new HashMap();
        f7209c = new Object();
        f7210d = c.a();
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65537, null) == null) && f7210d) {
            boolean z = f7207a;
            synchronized (f7209c) {
                f7208b.clear();
            }
        }
    }

    @NonNull
    public static Set<String> b() {
        InterceptResult invokeV;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (!f7210d) {
                return Collections.emptySet();
            }
            synchronized (f7209c) {
                strArr = (String[]) f7208b.keySet().toArray(new String[0]);
            }
            return c.a.n0.a.v2.z0.a.a(strArr);
        }
        return (Set) invokeV.objValue;
    }

    public static boolean c(String str) {
        InterceptResult invokeL;
        boolean containsKey;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (f7210d && !TextUtils.isEmpty(str)) {
                synchronized (f7209c) {
                    containsKey = f7208b.containsKey(str);
                }
                if (f7207a) {
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
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str) == null) && f7210d) {
            if (f7207a) {
                String str2 = "record one appId for exclude - " + str;
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            synchronized (f7209c) {
                Integer num = f7208b.get(str);
                if (num == null) {
                    f7208b.put(str, 1);
                } else {
                    f7208b.put(str, Integer.valueOf(num.intValue() + 1));
                }
            }
        }
    }

    public static void e(c.a.n0.n.o.f fVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, fVar) == null) && f7210d && fVar != null) {
            for (c.a.n0.n.h.e eVar : fVar.h()) {
                if (eVar instanceof c.a.n0.n.h.f) {
                    d(eVar.f11611g);
                } else if (eVar instanceof g) {
                    d(((g) eVar).o);
                }
            }
        }
    }

    public static void f(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str) == null) && f7210d) {
            if (f7207a) {
                String str2 = "remove one appId for exclude - " + str;
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            synchronized (f7209c) {
                Integer num = f7208b.get(str);
                if (num != null) {
                    int intValue = num.intValue() - 1;
                    if (intValue <= 0) {
                        f7208b.remove(str);
                    } else {
                        f7208b.put(str, Integer.valueOf(intValue));
                    }
                }
            }
        }
    }
}
