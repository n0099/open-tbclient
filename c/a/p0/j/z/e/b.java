package c.a.p0.j.z.e;

import android.text.TextUtils;
import c.a.p0.a.k;
import c.a.p0.a.l0.c;
import c.a.p0.j.t.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import okhttp3.HttpUrl;
/* loaded from: classes5.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f10526b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile b f10527c;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, c.a.p0.j.z.a> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1359200250, "Lc/a/p0/j/z/e/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1359200250, "Lc/a/p0/j/z/e/b;");
                return;
            }
        }
        f10526b = k.a;
    }

    public b() {
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
        this.a = new HashMap<>();
    }

    public static void a(c cVar, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, null, cVar, str) == null) || cVar == null || cVar.z() == null || TextUtils.isEmpty(str)) {
            return;
        }
        cVar.z().b(str);
    }

    public static b b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (f10527c == null) {
                synchronized (b.class) {
                    if (f10527c == null) {
                        f10527c = new b();
                    }
                }
            }
            return f10527c;
        }
        return (b) invokeV.objValue;
    }

    public final String c(String str, int i2) {
        InterceptResult invokeLI;
        HttpUrl parse;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, str, i2)) == null) {
            if (TextUtils.isEmpty(str) || (parse = HttpUrl.parse(str)) == null) {
                return null;
            }
            return parse.url().toString() + i2;
        }
        return (String) invokeLI.objValue;
    }

    public synchronized c.a.p0.j.z.a d(c cVar, c.a.p0.a.y.b.a aVar, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, aVar, i2)) == null) {
            synchronized (this) {
                if (aVar == null) {
                    return null;
                }
                String B = aVar.B("url");
                String c2 = c(B, i2);
                if (TextUtils.isEmpty(c2)) {
                    return null;
                }
                c.a.p0.j.z.a remove = this.a.remove(c2);
                if (remove != null) {
                    a(cVar, "preload used, url = " + B);
                }
                if (f10526b) {
                    String str = "obtainRequestTask requestType:" + i2 + ";url:" + B + ";task:" + remove;
                }
                return remove;
            }
        }
        return (c.a.p0.j.z.a) invokeLLI.objValue;
    }

    public synchronized void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                this.a.clear();
            }
        }
    }

    public void f(c cVar, a.c cVar2) {
        c.a.p0.j.d0.a.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, cVar, cVar2) == null) || cVar == null || cVar2 == null || (aVar = cVar2.f10468c) == null || aVar.f10146g == null) {
            return;
        }
        e();
        c.a.p0.a.c1.a.g0().getSwitch("swan_game_resource_preload", 0);
    }
}
