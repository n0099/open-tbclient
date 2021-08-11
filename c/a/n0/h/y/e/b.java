package c.a.n0.h.y.e;

import android.text.TextUtils;
import c.a.n0.a.k;
import c.a.n0.a.l0.c;
import c.a.n0.h.s.a;
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
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f11342b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile b f11343c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, c.a.n0.h.y.a> f11344a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1279547353, "Lc/a/n0/h/y/e/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1279547353, "Lc/a/n0/h/y/e/b;");
                return;
            }
        }
        f11342b = k.f6803a;
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
        this.f11344a = new HashMap<>();
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
            if (f11343c == null) {
                synchronized (b.class) {
                    if (f11343c == null) {
                        f11343c = new b();
                    }
                }
            }
            return f11343c;
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

    public synchronized c.a.n0.h.y.a d(c cVar, c.a.n0.a.y.b.a aVar, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, aVar, i2)) == null) {
            synchronized (this) {
                if (aVar == null) {
                    return null;
                }
                String C = aVar.C("url");
                String c2 = c(C, i2);
                if (TextUtils.isEmpty(c2)) {
                    return null;
                }
                c.a.n0.h.y.a remove = this.f11344a.remove(c2);
                if (remove != null) {
                    a(cVar, "preload used, url = " + C);
                }
                if (f11342b) {
                    String str = "obtainRequestTask requestType:" + i2 + ";url:" + C + ";task:" + remove;
                }
                return remove;
            }
        }
        return (c.a.n0.h.y.a) invokeLLI.objValue;
    }

    public synchronized void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                this.f11344a.clear();
            }
        }
    }

    public void f(c cVar, a.c cVar2) {
        c.a.n0.h.c0.a.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, cVar, cVar2) == null) || cVar == null || cVar2 == null || (aVar = cVar2.f11268c) == null || aVar.f10849g == null) {
            return;
        }
        e();
        c.a.n0.a.c1.a.Z().getSwitch("swan_game_resource_preload", 0);
    }
}
