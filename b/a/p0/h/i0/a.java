package b.a.p0.h.i0;

import android.text.TextUtils;
import b.a.p0.a.a2.e;
import b.a.p0.a.k;
import b.a.p0.h.c0.a.a;
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
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f10468b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile a f10469c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b.a.p0.h.c0.a.a f10470a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1051919693, "Lb/a/p0/h/i0/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1051919693, "Lb/a/p0/h/i0/a;");
                return;
            }
        }
        f10468b = k.f6397a;
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
            if (f10469c == null) {
                synchronized (a.class) {
                    if (f10469c == null) {
                        f10469c = new a();
                    }
                }
            }
            return f10469c;
        }
        return (a) invokeV.objValue;
    }

    public String a(String str) {
        InterceptResult invokeL;
        b.a.p0.h.c0.a.a aVar;
        a.c cVar;
        HashMap<String, String> hashMap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            String c2 = c(str, 1);
            if (TextUtils.isEmpty(c2) || (aVar = this.f10470a) == null || (cVar = aVar.f10329d) == null || (hashMap = cVar.f10339a) == null) {
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
        b.a.p0.h.c0.a.a aVar;
        a.b bVar;
        List<a.C0559a> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i2)) == null) {
            if (!TextUtils.isEmpty(str) && (aVar = this.f10470a) != null && (bVar = aVar.f10328c) != null && (list = bVar.f10337a) != null) {
                for (a.C0559a c0559a : list) {
                    if (TextUtils.equals(c0559a.f10333a, str) || TextUtils.equals(c0559a.f10334b, str)) {
                        if (i2 != 0) {
                            if (i2 != 1) {
                                if (i2 != 2) {
                                    if (i2 != 3) {
                                        return c0559a.f10334b;
                                    }
                                    return c0559a.f10336d;
                                }
                                return c0559a.f10335c;
                            }
                            return c0559a.f10334b;
                        }
                        return c0559a.f10333a;
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
            b.a.p0.h.c0.a.a aVar = this.f10470a;
            if (aVar != null && (bVar = aVar.f10328c) != null && (hashMap = bVar.f10338b) != null && hashMap.containsKey(c2)) {
                boolean z = f10468b;
                return this.f10470a.f10328c.f10338b.get(c2).booleanValue();
            }
            boolean z2 = f10468b;
            String U = e.U();
            if (e.i() == null) {
                return false;
            }
            String Y = e.i().Y();
            if (TextUtils.isEmpty(U) || TextUtils.isEmpty(Y)) {
                return false;
            }
            boolean m = b.a.p0.n.g.a.h().m(U, Y, c2);
            if (m) {
                f(c2, true);
            }
            return m;
        }
        return invokeL.booleanValue;
    }

    public void e(b.a.p0.h.c0.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            this.f10470a = aVar;
        }
    }

    public void f(String str, boolean z) {
        b.a.p0.h.c0.a.a aVar;
        a.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048580, this, str, z) == null) || TextUtils.isEmpty(str) || (aVar = this.f10470a) == null || (bVar = aVar.f10328c) == null || bVar.f10338b == null) {
            return;
        }
        if (f10468b) {
            String str2 = "更新内存缓存信息: " + str + ": " + z;
        }
        this.f10470a.f10328c.f10338b.put(str, Boolean.valueOf(z));
    }
}
