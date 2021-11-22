package b.a.p0.a.n0.h;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.k;
import b.a.p0.q.i.h;
import b.a.p0.q.p.g;
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
    public static final boolean f7124a;

    /* renamed from: b  reason: collision with root package name */
    public static final Map<String, Integer> f7125b;

    /* renamed from: c  reason: collision with root package name */
    public static final Object f7126c;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f7127d;
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
        f7124a = k.f6863a;
        f7125b = new HashMap();
        f7126c = new Object();
        f7127d = c.a();
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65537, null) == null) && f7127d) {
            boolean z = f7124a;
            synchronized (f7126c) {
                f7125b.clear();
            }
        }
    }

    @NonNull
    public static Set<String> b() {
        InterceptResult invokeV;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (!f7127d) {
                return Collections.emptySet();
            }
            synchronized (f7126c) {
                strArr = (String[]) f7125b.keySet().toArray(new String[0]);
            }
            return b.a.p0.a.z2.a1.a.a(strArr);
        }
        return (Set) invokeV.objValue;
    }

    public static boolean c(String str) {
        InterceptResult invokeL;
        boolean containsKey;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (f7127d && !TextUtils.isEmpty(str)) {
                synchronized (f7126c) {
                    containsKey = f7125b.containsKey(str);
                }
                if (f7124a) {
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
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str) == null) && f7127d) {
            if (f7124a) {
                String str2 = "record one appId for exclude - " + str;
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            synchronized (f7126c) {
                Integer num = f7125b.get(str);
                if (num == null) {
                    f7125b.put(str, 1);
                } else {
                    f7125b.put(str, Integer.valueOf(num.intValue() + 1));
                }
            }
        }
    }

    public static void e(g gVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, gVar) == null) && f7127d && gVar != null) {
            for (b.a.p0.q.i.f fVar : gVar.j()) {
                if (fVar instanceof b.a.p0.q.i.g) {
                    d(fVar.f11774g);
                } else if (fVar instanceof h) {
                    d(((h) fVar).o);
                }
            }
        }
    }

    public static void f(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str) == null) && f7127d) {
            if (f7124a) {
                String str2 = "remove one appId for exclude - " + str;
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            synchronized (f7126c) {
                Integer num = f7125b.get(str);
                if (num != null) {
                    int intValue = num.intValue() - 1;
                    if (intValue <= 0) {
                        f7125b.remove(str);
                    } else {
                        f7125b.put(str, Integer.valueOf(intValue));
                    }
                }
            }
        }
    }
}
