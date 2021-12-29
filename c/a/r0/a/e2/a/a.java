package c.a.r0.a.e2.a;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.a.r0.a.e0.d;
import c.a.r0.a.e2.a.c;
import c.a.r0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f5905d;
    public transient /* synthetic */ FieldHolder $fh;
    public c.d a;

    /* renamed from: b  reason: collision with root package name */
    public c.d f5906b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, c.d> f5907c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1260397391, "Lc/a/r0/a/e2/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1260397391, "Lc/a/r0/a/e2/a/a;");
                return;
            }
        }
        f5905d = k.a;
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
                return;
            }
        }
        this.f5907c = new ConcurrentHashMap();
    }

    public static boolean a(c.d dVar, String str) {
        InterceptResult invokeLL;
        List<String> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, dVar, str)) == null) {
            if ((dVar == null || (list = dVar.f5916b) == null || list.isEmpty()) ? false : true) {
                File file = new File(str);
                if (file.exists() && file.lastModified() == dVar.f5917c) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public List<String> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? c.d() : (List) invokeV.objValue;
    }

    public c.d c(String str, String str2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, z)) == null) {
            c.d dVar = this.f5907c.get(str2);
            if (a(dVar, c.i(str))) {
                d.k("SwanAppWebSafe", "read from cache: serverDomains.data=" + dVar.f5916b);
                return dVar;
            }
            if (dVar != null) {
                dVar.c();
            } else {
                dVar = new c.d();
            }
            c.h(z, str, str2, dVar);
            this.f5907c.put(str2, dVar);
            return dVar;
        }
        return (c.d) invokeLLZ.objValue;
    }

    public List<String> d(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
            if (a(this.f5906b, c.j())) {
                d.k("SwanAppWebSafe", "read from cache: webActions.data=" + this.f5906b.f5916b);
                return this.f5906b.f5916b;
            }
            c.d dVar = this.f5906b;
            if (dVar != null) {
                dVar.c();
            } else {
                this.f5906b = new c.d();
            }
            c.k(z, this.f5906b);
            return this.f5906b.f5916b;
        }
        return (List) invokeZ.objValue;
    }

    public List<String> e(@NonNull String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048579, this, str, z)) == null) {
            if (a(this.a, c.m(str))) {
                d.k("SwanAppWebSafe", "read from cache: webDomains.data=" + this.a.f5916b);
                return this.a.f5916b;
            }
            c.d dVar = this.a;
            if (dVar != null) {
                dVar.c();
            } else {
                this.a = new c.d();
            }
            c.l(z, str, this.a);
            return this.a.f5916b;
        }
        return (List) invokeLZ.objValue;
    }

    @SuppressLint({"BDThrowableCheck"})
    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                if (f5905d) {
                    throw new RuntimeException("appId can not be empty");
                }
                return;
            }
            d(true);
            e(str, true);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            c.d dVar = this.a;
            if (dVar != null) {
                dVar.c();
                this.a = null;
            }
            c.d dVar2 = this.f5906b;
            if (dVar2 != null) {
                dVar2.c();
                this.f5906b = null;
            }
            d.k("SwanAppWebSafe", "release cache done");
        }
    }
}
