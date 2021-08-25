package c.a.o0.h.i0;

import android.text.TextUtils;
import c.a.o0.a.a2.e;
import c.a.o0.a.k;
import c.a.o0.h.c0.a.a;
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
    public static final boolean f11235b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile a f11236c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c.a.o0.h.c0.a.a f11237a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1360964813, "Lc/a/o0/h/i0/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1360964813, "Lc/a/o0/h/i0/a;");
                return;
            }
        }
        f11235b = k.f7049a;
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
            if (f11236c == null) {
                synchronized (a.class) {
                    if (f11236c == null) {
                        f11236c = new a();
                    }
                }
            }
            return f11236c;
        }
        return (a) invokeV.objValue;
    }

    public String a(String str) {
        InterceptResult invokeL;
        c.a.o0.h.c0.a.a aVar;
        a.c cVar;
        HashMap<String, String> hashMap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            String c2 = c(str, 1);
            if (TextUtils.isEmpty(c2) || (aVar = this.f11237a) == null || (cVar = aVar.f11092d) == null || (hashMap = cVar.f11102a) == null) {
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
        c.a.o0.h.c0.a.a aVar;
        a.b bVar;
        List<a.C0562a> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i2)) == null) {
            if (!TextUtils.isEmpty(str) && (aVar = this.f11237a) != null && (bVar = aVar.f11091c) != null && (list = bVar.f11100a) != null) {
                for (a.C0562a c0562a : list) {
                    if (TextUtils.equals(c0562a.f11096a, str) || TextUtils.equals(c0562a.f11097b, str)) {
                        if (i2 != 0) {
                            if (i2 != 1) {
                                if (i2 != 2) {
                                    if (i2 != 3) {
                                        return c0562a.f11097b;
                                    }
                                    return c0562a.f11099d;
                                }
                                return c0562a.f11098c;
                            }
                            return c0562a.f11097b;
                        }
                        return c0562a.f11096a;
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
            c.a.o0.h.c0.a.a aVar = this.f11237a;
            if (aVar != null && (bVar = aVar.f11091c) != null && (hashMap = bVar.f11101b) != null && hashMap.containsKey(c2)) {
                boolean z = f11235b;
                return this.f11237a.f11091c.f11101b.get(c2).booleanValue();
            }
            boolean z2 = f11235b;
            String V = e.V();
            if (e.i() == null) {
                return false;
            }
            String Z = e.i().Z();
            if (TextUtils.isEmpty(V) || TextUtils.isEmpty(Z)) {
                return false;
            }
            boolean m = c.a.o0.n.g.a.h().m(V, Z, c2);
            if (m) {
                f(c2, true);
            }
            return m;
        }
        return invokeL.booleanValue;
    }

    public void e(c.a.o0.h.c0.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            this.f11237a = aVar;
        }
    }

    public void f(String str, boolean z) {
        c.a.o0.h.c0.a.a aVar;
        a.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048580, this, str, z) == null) || TextUtils.isEmpty(str) || (aVar = this.f11237a) == null || (bVar = aVar.f11091c) == null || bVar.f11101b == null) {
            return;
        }
        if (f11235b) {
            String str2 = "更新内存缓存信息: " + str + ": " + z;
        }
        this.f11237a.f11091c.f11101b.put(str, Boolean.valueOf(z));
    }
}
