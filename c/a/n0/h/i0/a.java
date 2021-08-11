package c.a.n0.h.i0;

import android.text.TextUtils;
import c.a.n0.a.a2.e;
import c.a.n0.a.k;
import c.a.n0.h.c0.a.a;
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
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f10989b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile a f10990c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c.a.n0.h.c0.a.a f10991a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1164451308, "Lc/a/n0/h/i0/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1164451308, "Lc/a/n0/h/i0/a;");
                return;
            }
        }
        f10989b = k.f6803a;
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
            if (f10990c == null) {
                synchronized (a.class) {
                    if (f10990c == null) {
                        f10990c = new a();
                    }
                }
            }
            return f10990c;
        }
        return (a) invokeV.objValue;
    }

    public String a(String str) {
        InterceptResult invokeL;
        c.a.n0.h.c0.a.a aVar;
        a.c cVar;
        HashMap<String, String> hashMap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            String c2 = c(str, 1);
            if (TextUtils.isEmpty(c2) || (aVar = this.f10991a) == null || (cVar = aVar.f10846d) == null || (hashMap = cVar.f10856a) == null) {
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
        c.a.n0.h.c0.a.a aVar;
        a.b bVar;
        List<a.C0554a> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i2)) == null) {
            if (!TextUtils.isEmpty(str) && (aVar = this.f10991a) != null && (bVar = aVar.f10845c) != null && (list = bVar.f10854a) != null) {
                for (a.C0554a c0554a : list) {
                    if (TextUtils.equals(c0554a.f10850a, str) || TextUtils.equals(c0554a.f10851b, str)) {
                        if (i2 != 0) {
                            if (i2 != 1) {
                                if (i2 != 2) {
                                    if (i2 != 3) {
                                        return c0554a.f10851b;
                                    }
                                    return c0554a.f10853d;
                                }
                                return c0554a.f10852c;
                            }
                            return c0554a.f10851b;
                        }
                        return c0554a.f10850a;
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
            c.a.n0.h.c0.a.a aVar = this.f10991a;
            if (aVar != null && (bVar = aVar.f10845c) != null && (hashMap = bVar.f10855b) != null && hashMap.containsKey(c2)) {
                boolean z = f10989b;
                return this.f10991a.f10845c.f10855b.get(c2).booleanValue();
            }
            boolean z2 = f10989b;
            String V = e.V();
            if (e.i() == null) {
                return false;
            }
            String Z = e.i().Z();
            if (TextUtils.isEmpty(V) || TextUtils.isEmpty(Z)) {
                return false;
            }
            boolean m = c.a.n0.n.g.a.h().m(V, Z, c2);
            if (m) {
                f(c2, true);
            }
            return m;
        }
        return invokeL.booleanValue;
    }

    public void e(c.a.n0.h.c0.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            this.f10991a = aVar;
        }
    }

    public void f(String str, boolean z) {
        c.a.n0.h.c0.a.a aVar;
        a.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048580, this, str, z) == null) || TextUtils.isEmpty(str) || (aVar = this.f10991a) == null || (bVar = aVar.f10845c) == null || bVar.f10855b == null) {
            return;
        }
        if (f10989b) {
            String str2 = "更新内存缓存信息: " + str + ": " + z;
        }
        this.f10991a.f10845c.f10855b.put(str, Boolean.valueOf(z));
    }
}
