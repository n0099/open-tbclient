package b.a.w.e.c;

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
/* loaded from: classes6.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static d f29295b;

    /* renamed from: c  reason: collision with root package name */
    public static WeakHashMap<Object, List<b.a.w.e.c.b>> f29296c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public e f29297a;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final d f29298a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1391005774, "Lb/a/w/e/c/d$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1391005774, "Lb/a/w/e/c/d$b;");
                    return;
                }
            }
            f29298a = new d(null);
        }
    }

    public /* synthetic */ d(a aVar) {
        this();
    }

    public static d a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f29295b == null) {
                f29295b = b.f29298a;
            }
            return f29295b;
        }
        return (d) invokeV.objValue;
    }

    public void b(Object obj) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, obj) == null) || obj == null || f29296c.isEmpty()) {
            return;
        }
        this.f29297a.c(f29296c, obj);
    }

    public void c(Object obj, Class<?> cls, int i2, b.a.w.e.c.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, cls, i2, aVar) == null) || obj == null || cls == null || aVar == null || !f.a(i2)) {
            return;
        }
        this.f29297a.d(f29296c, obj, cls, i2, aVar);
    }

    public synchronized void d(Object obj, Class<?> cls, b.a.w.e.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, obj, cls, aVar) == null) {
            synchronized (this) {
                c(obj, cls, 1, aVar);
            }
        }
    }

    public void e(Object obj) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, obj) == null) || obj == null || f29296c.isEmpty() || !f29296c.containsKey(obj)) {
            return;
        }
        this.f29297a.e(f29296c, obj);
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
        f29296c = new WeakHashMap<>();
        this.f29297a = new e();
    }
}
