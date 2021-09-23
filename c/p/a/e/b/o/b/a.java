package c.p.a.e.b.o.b;

import c.p.a.e.b.l.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, c> f35406a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, d> f35407b;

    /* renamed from: c.p.a.e.b.o.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class C1553a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final a f35408a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-150576827, "Lc/p/a/e/b/o/b/a$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-150576827, "Lc/p/a/e/b/o/b/a$b;");
                    return;
                }
            }
            f35408a = new a(null);
        }
    }

    public /* synthetic */ a(C1553a c1553a) {
        this();
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? b.f35408a : (a) invokeV.objValue;
    }

    public c b(String str, List<com.ss.android.socialbase.downloader.model.c> list) {
        InterceptResult invokeLL;
        c remove;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, list)) == null) {
            synchronized (this.f35406a) {
                remove = this.f35406a.remove(str);
            }
            if (remove != null) {
                if (f.S(remove.k(), list)) {
                    try {
                        remove.d();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                    if (remove.i() && remove.h()) {
                        return remove;
                    }
                }
                try {
                    remove.c();
                    return null;
                } catch (Throwable unused) {
                    return null;
                }
            }
            return null;
        }
        return (c) invokeLL.objValue;
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
        }
    }

    public void d(String str, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, cVar) == null) {
            synchronized (this.f35406a) {
                this.f35406a.put(str, cVar);
            }
        }
    }

    public boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            c cVar = this.f35406a.get(str);
            if (cVar != null) {
                if (cVar.j()) {
                    return true;
                }
                return cVar.i() && cVar.h();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public d f(String str, List<com.ss.android.socialbase.downloader.model.c> list) {
        InterceptResult invokeLL;
        d remove;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, list)) == null) {
            synchronized (this.f35407b) {
                remove = this.f35407b.remove(str);
            }
            if (remove != null) {
                if (f.S(remove.f(), list)) {
                    try {
                        remove.e();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                    if (remove.h() && remove.g()) {
                        return remove;
                    }
                }
                try {
                    remove.d();
                    return null;
                } catch (Throwable unused) {
                    return null;
                }
            }
            return null;
        }
        return (d) invokeLL.objValue;
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f35406a = new HashMap();
        this.f35407b = new LinkedHashMap(3);
    }
}
