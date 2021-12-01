package c.a.p0.j.j0;

import android.text.TextUtils;
import c.a.p0.a.d2.e;
import c.a.p0.a.k;
import c.a.p0.j.d0.a.a;
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
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f10244b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile a f10245c;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.p0.j.d0.a.a a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(218452565, "Lc/a/p0/j/j0/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(218452565, "Lc/a/p0/j/j0/a;");
                return;
            }
        }
        f10244b = k.a;
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
            if (f10245c == null) {
                synchronized (a.class) {
                    if (f10245c == null) {
                        f10245c = new a();
                    }
                }
            }
            return f10245c;
        }
        return (a) invokeV.objValue;
    }

    public String a(String str) {
        InterceptResult invokeL;
        c.a.p0.j.d0.a.a aVar;
        a.c cVar;
        HashMap<String, String> hashMap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            String c2 = c(str, 1);
            if (TextUtils.isEmpty(c2) || (aVar = this.a) == null || (cVar = aVar.f10143d) == null || (hashMap = cVar.a) == null) {
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
        c.a.p0.j.d0.a.a aVar;
        a.b bVar;
        List<a.C0648a> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i2)) == null) {
            if (!TextUtils.isEmpty(str) && (aVar = this.a) != null && (bVar = aVar.f10142c) != null && (list = bVar.a) != null) {
                for (a.C0648a c0648a : list) {
                    if (TextUtils.equals(c0648a.a, str) || TextUtils.equals(c0648a.f10147b, str)) {
                        if (i2 != 0) {
                            if (i2 != 1) {
                                if (i2 != 2) {
                                    if (i2 != 3) {
                                        return c0648a.f10147b;
                                    }
                                    return c0648a.f10149d;
                                }
                                return c0648a.f10148c;
                            }
                            return c0648a.f10147b;
                        }
                        return c0648a.a;
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
            c.a.p0.j.d0.a.a aVar = this.a;
            if (aVar != null && (bVar = aVar.f10142c) != null && (hashMap = bVar.f10150b) != null && hashMap.containsKey(c2)) {
                boolean z = f10244b;
                return this.a.f10142c.f10150b.get(c2).booleanValue();
            }
            boolean z2 = f10244b;
            String f0 = e.f0();
            if (e.L() == null) {
                return false;
            }
            String j0 = e.L().j0();
            if (TextUtils.isEmpty(f0) || TextUtils.isEmpty(j0)) {
                return false;
            }
            boolean n = c.a.p0.q.g.a.i().n(f0, j0, c2);
            if (n) {
                f(c2, true);
            }
            return n;
        }
        return invokeL.booleanValue;
    }

    public void e(c.a.p0.j.d0.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            this.a = aVar;
        }
    }

    public void f(String str, boolean z) {
        c.a.p0.j.d0.a.a aVar;
        a.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048580, this, str, z) == null) || TextUtils.isEmpty(str) || (aVar = this.a) == null || (bVar = aVar.f10142c) == null || bVar.f10150b == null) {
            return;
        }
        if (f10244b) {
            String str2 = "更新内存缓存信息: " + str + ": " + z;
        }
        this.a.f10142c.f10150b.put(str, Boolean.valueOf(z));
    }
}
