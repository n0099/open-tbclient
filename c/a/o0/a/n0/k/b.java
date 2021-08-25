package c.a.o0.a.n0.k;

import c.a.o0.a.n0.k.a;
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

    /* renamed from: a  reason: collision with root package name */
    public static final Set<String> f7494a;

    /* renamed from: b  reason: collision with root package name */
    public static final Set<String> f7495b;

    /* renamed from: c  reason: collision with root package name */
    public static final Set<String> f7496c;

    /* renamed from: d  reason: collision with root package name */
    public static final Map<String, a> f7497d;

    /* renamed from: e  reason: collision with root package name */
    public static boolean f7498e;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1987959924, "Lc/a/o0/a/n0/k/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1987959924, "Lc/a/o0/a/n0/k/b;");
                return;
            }
        }
        f7494a = Sets.newHashSet(ZeusWebViewPreloadClass.ZEUS_FILE_DIR);
        f7495b = new HashSet(f7494a);
        f7496c = new HashSet(f7495b);
        f7497d = new HashMap();
        f7498e = false;
    }

    public static a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            c();
            return f7497d.get(str);
        }
        return (a) invokeL.objValue;
    }

    public static a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            a.b bVar = new a.b();
            bVar.d(ZeusWebViewPreloadClass.ZEUS_FILE_DIR);
            bVar.e(c.a.o0.a.c1.a.n0().a());
            bVar.b(c.a.o0.a.c1.a.n0().d());
            return bVar.a();
        }
        return (a) invokeV.objValue;
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            if (!f7498e) {
                for (String str : f7496c) {
                    if (ZeusWebViewPreloadClass.ZEUS_FILE_DIR.equals(str)) {
                        f7497d.put(str, b());
                    }
                }
            }
            f7498e = true;
        }
    }
}
