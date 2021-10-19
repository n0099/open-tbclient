package c.a.w.e.c;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.WeakHashMap;
/* loaded from: classes4.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static d f30575b;

    /* renamed from: c  reason: collision with root package name */
    public static WeakHashMap<Object, List<c.a.w.e.c.b>> f30576c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public e f30577a;

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final d f30578a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(885447149, "Lc/a/w/e/c/d$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(885447149, "Lc/a/w/e/c/d$b;");
                    return;
                }
            }
            f30578a = new d(null);
        }
    }

    public /* synthetic */ d(a aVar) {
        this();
    }

    public static d a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f30575b == null) {
                f30575b = b.f30578a;
            }
            return f30575b;
        }
        return (d) invokeV.objValue;
    }

    public void b(Object obj) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, obj) == null) || obj == null || f30576c.isEmpty()) {
            return;
        }
        this.f30577a.c(f30576c, obj);
    }

    public void c(Object obj, Class<?> cls, int i2, c.a.w.e.c.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, cls, i2, aVar) == null) || obj == null || cls == null || aVar == null || !f.a(i2)) {
            return;
        }
        this.f30577a.d(f30576c, obj, cls, i2, aVar);
    }

    public synchronized void d(Object obj, Class<?> cls, c.a.w.e.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, obj, cls, aVar) == null) {
            synchronized (this) {
                c(obj, cls, 1, aVar);
            }
        }
    }

    public void e(Object obj) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, obj) == null) || obj == null || f30576c.isEmpty() || !f30576c.containsKey(obj)) {
            return;
        }
        this.f30577a.e(f30576c, obj);
    }

    public d() {
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
        f30576c = new WeakHashMap<>();
        this.f30577a = new e();
    }
}
