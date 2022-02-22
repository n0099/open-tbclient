package c.a.s0.j.j0;

import android.text.TextUtils;
import c.a.s0.a.d2.e;
import c.a.s0.a.k;
import c.a.s0.j.d0.a.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f11279b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile a f11280c;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.s0.j.d0.a.a a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-371087950, "Lc/a/s0/j/j0/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-371087950, "Lc/a/s0/j/j0/a;");
                return;
            }
        }
        f11279b = k.a;
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f11280c == null) {
                synchronized (a.class) {
                    if (f11280c == null) {
                        f11280c = new a();
                    }
                }
            }
            return f11280c;
        }
        return (a) invokeV.objValue;
    }

    public String a(String str) {
        InterceptResult invokeL;
        c.a.s0.j.d0.a.a aVar;
        a.c cVar;
        HashMap<String, String> hashMap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            String c2 = c(str, 1);
            if (TextUtils.isEmpty(c2) || (aVar = this.a) == null || (cVar = aVar.f11181d) == null || (hashMap = cVar.a) == null) {
                return null;
            }
            return hashMap.get(c2);
        }
        return (String) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String c(String str, int i2) {
        InterceptResult invokeLI;
        c.a.s0.j.d0.a.a aVar;
        a.b bVar;
        List<a.C0761a> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i2)) == null) {
            if (!TextUtils.isEmpty(str) && (aVar = this.a) != null && (bVar = aVar.f11180c) != null && (list = bVar.a) != null) {
                for (a.C0761a c0761a : list) {
                    if (TextUtils.equals(c0761a.a, str) || TextUtils.equals(c0761a.f11185b, str)) {
                        if (i2 != 0) {
                            if (i2 != 1) {
                                if (i2 != 2) {
                                    if (i2 != 3) {
                                        return c0761a.f11185b;
                                    }
                                    return c0761a.f11187d;
                                }
                                return c0761a.f11186c;
                            }
                            return c0761a.f11185b;
                        }
                        return c0761a.a;
                    }
                    while (r0.hasNext()) {
                    }
                }
            }
            return null;
        }
        return (String) invokeLI.objValue;
    }

    public boolean d(String str) {
        InterceptResult invokeL;
        a.b bVar;
        HashMap<String, Boolean> hashMap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            String c2 = c(str, 1);
            if (TextUtils.isEmpty(c2)) {
                return false;
            }
            c.a.s0.j.d0.a.a aVar = this.a;
            if (aVar != null && (bVar = aVar.f11180c) != null && (hashMap = bVar.f11188b) != null && hashMap.containsKey(c2)) {
                boolean z = f11279b;
                return this.a.f11180c.f11188b.get(c2).booleanValue();
            }
            boolean z2 = f11279b;
            String f0 = e.f0();
            if (e.L() == null) {
                return false;
            }
            String j0 = e.L().j0();
            if (TextUtils.isEmpty(f0) || TextUtils.isEmpty(j0)) {
                return false;
            }
            boolean n = c.a.s0.q.g.a.i().n(f0, j0, c2);
            if (n) {
                f(c2, true);
            }
            return n;
        }
        return invokeL.booleanValue;
    }

    public void e(c.a.s0.j.d0.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            this.a = aVar;
        }
    }

    public void f(String str, boolean z) {
        c.a.s0.j.d0.a.a aVar;
        a.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048580, this, str, z) == null) || TextUtils.isEmpty(str) || (aVar = this.a) == null || (bVar = aVar.f11180c) == null || bVar.f11188b == null) {
            return;
        }
        if (f11279b) {
            String str2 = "更新内存缓存信息: " + str + ": " + z;
        }
        this.a.f11180c.f11188b.put(str, Boolean.valueOf(z));
    }
}
