package b.a.p0.a.n0.k;

import b.a.p0.a.n0.k.a;
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
    public static final Set<String> f6835a;

    /* renamed from: b  reason: collision with root package name */
    public static final Set<String> f6836b;

    /* renamed from: c  reason: collision with root package name */
    public static final Set<String> f6837c;

    /* renamed from: d  reason: collision with root package name */
    public static final Map<String, a> f6838d;

    /* renamed from: e  reason: collision with root package name */
    public static boolean f6839e;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1667390476, "Lb/a/p0/a/n0/k/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1667390476, "Lb/a/p0/a/n0/k/b;");
                return;
            }
        }
        f6835a = Sets.newHashSet(ZeusWebViewPreloadClass.ZEUS_FILE_DIR);
        f6836b = new HashSet(f6835a);
        f6837c = new HashSet(f6836b);
        f6838d = new HashMap();
        f6839e = false;
    }

    public static a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            c();
            return f6838d.get(str);
        }
        return (a) invokeL.objValue;
    }

    public static a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            a.b bVar = new a.b();
            bVar.d(ZeusWebViewPreloadClass.ZEUS_FILE_DIR);
            bVar.e(b.a.p0.a.c1.a.n0().a());
            bVar.b(b.a.p0.a.c1.a.n0().d());
            return bVar.a();
        }
        return (a) invokeV.objValue;
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            if (!f6839e) {
                for (String str : f6837c) {
                    if (ZeusWebViewPreloadClass.ZEUS_FILE_DIR.equals(str)) {
                        f6838d.put(str, b());
                    }
                }
            }
            f6839e = true;
        }
    }
}
