package c.a.p0.a.n0.k;

import c.a.p0.a.n0.k.a;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.sdk.ZeusWebViewPreloadClass;
import com.facebook.common.internal.Sets;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public static final Set<String> a;

    /* renamed from: b  reason: collision with root package name */
    public static final Set<String> f6920b;

    /* renamed from: c  reason: collision with root package name */
    public static final Set<String> f6921c;

    /* renamed from: d  reason: collision with root package name */
    public static final Map<String, a> f6922d;

    /* renamed from: e  reason: collision with root package name */
    public static boolean f6923e;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2117042643, "Lc/a/p0/a/n0/k/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2117042643, "Lc/a/p0/a/n0/k/b;");
                return;
            }
        }
        a = Sets.newHashSet(ZeusWebViewPreloadClass.ZEUS_FILE_DIR);
        f6920b = new HashSet(a);
        f6921c = new HashSet(f6920b);
        f6922d = new HashMap();
        f6923e = false;
    }

    public static a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            c();
            return f6922d.get(str);
        }
        return (a) invokeL.objValue;
    }

    public static a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            a.b bVar = new a.b();
            bVar.d(ZeusWebViewPreloadClass.ZEUS_FILE_DIR);
            bVar.e(c.a.p0.a.c1.a.w0().a());
            bVar.b(c.a.p0.a.c1.a.w0().d());
            return bVar.a();
        }
        return (a) invokeV.objValue;
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            if (!f6923e) {
                for (String str : f6921c) {
                    if (ZeusWebViewPreloadClass.ZEUS_FILE_DIR.equals(str)) {
                        f6922d.put(str, b());
                    }
                }
            }
            f6923e = true;
        }
    }
}
