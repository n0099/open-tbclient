package c.a.n0.j.j0;

import android.text.TextUtils;
import android.util.Log;
import c.a.n0.a.t1.e;
import c.a.n0.j.d0.a.a;
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
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f8784b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile a f8785c;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.n0.j.d0.a.a a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(611479575, "Lc/a/n0/j/j0/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(611479575, "Lc/a/n0/j/j0/a;");
                return;
            }
        }
        f8784b = c.a.n0.a.a.a;
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f8785c == null) {
                synchronized (a.class) {
                    if (f8785c == null) {
                        f8785c = new a();
                    }
                }
            }
            return f8785c;
        }
        return (a) invokeV.objValue;
    }

    public String a(String str) {
        InterceptResult invokeL;
        c.a.n0.j.d0.a.a aVar;
        a.c cVar;
        HashMap<String, String> hashMap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            String c2 = c(str, 1);
            if (TextUtils.isEmpty(c2) || (aVar = this.a) == null || (cVar = aVar.f8694d) == null || (hashMap = cVar.a) == null) {
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
    public String c(String str, int i) {
        InterceptResult invokeLI;
        c.a.n0.j.d0.a.a aVar;
        a.b bVar;
        List<a.C0700a> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i)) == null) {
            if (!TextUtils.isEmpty(str) && (aVar = this.a) != null && (bVar = aVar.f8693c) != null && (list = bVar.a) != null) {
                for (a.C0700a c0700a : list) {
                    if (TextUtils.equals(c0700a.a, str) || TextUtils.equals(c0700a.f8698b, str)) {
                        if (i != 0) {
                            if (i != 1) {
                                if (i != 2) {
                                    if (i != 3) {
                                        return c0700a.f8698b;
                                    }
                                    return c0700a.f8700d;
                                }
                                return c0700a.f8699c;
                            }
                            return c0700a.f8698b;
                        }
                        return c0700a.a;
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
            c.a.n0.j.d0.a.a aVar = this.a;
            if (aVar != null && (bVar = aVar.f8693c) != null && (hashMap = bVar.f8701b) != null && hashMap.containsKey(c2)) {
                if (f8784b) {
                    Log.i("SubPackageDataHelper", "内存中查询分包是否存在信息");
                }
                return this.a.f8693c.f8701b.get(c2).booleanValue();
            }
            if (f8784b) {
                Log.i("SubPackageDataHelper", "DB中查询分包是否存在信息");
            }
            String f0 = e.f0();
            if (e.L() == null) {
                return false;
            }
            String j0 = e.L().j0();
            if (TextUtils.isEmpty(f0) || TextUtils.isEmpty(j0)) {
                return false;
            }
            boolean n = c.a.n0.q.f.a.i().n(f0, j0, c2);
            if (n) {
                f(c2, true);
            }
            return n;
        }
        return invokeL.booleanValue;
    }

    public void e(c.a.n0.j.d0.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            this.a = aVar;
        }
    }

    public void f(String str, boolean z) {
        c.a.n0.j.d0.a.a aVar;
        a.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048580, this, str, z) == null) || TextUtils.isEmpty(str) || (aVar = this.a) == null || (bVar = aVar.f8693c) == null || bVar.f8701b == null) {
            return;
        }
        if (f8784b) {
            Log.i("SubPackageDataHelper", "更新内存缓存信息: " + str + ": " + z);
        }
        this.a.f8693c.f8701b.put(str, Boolean.valueOf(z));
    }
}
