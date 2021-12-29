package c.a.r0.a.u.f.b.g;

import c.a.r0.a.k;
import c.a.r0.a.u.f.b.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.api.pending.queue.operation.BasePendingOperation;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f9519b;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, c.a.r0.a.u.f.b.a> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1738620202, "Lc/a/r0/a/u/f/b/g/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1738620202, "Lc/a/r0/a/u/f/b/g/b;");
                return;
            }
        }
        f9519b = k.a;
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
        this.a = new LinkedHashMap();
    }

    public synchronized void a(BasePendingOperation basePendingOperation) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, basePendingOperation) == null) {
            synchronized (this) {
                if (basePendingOperation == null) {
                    return;
                }
                if (f9519b) {
                    String str = "*************** 【Add pending module】:" + basePendingOperation.b() + " params: " + basePendingOperation.c();
                }
                c(basePendingOperation.getType()).b(basePendingOperation);
            }
        }
    }

    public synchronized void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                for (Map.Entry<String, c.a.r0.a.u.f.b.a> entry : this.a.entrySet()) {
                    entry.getValue().c();
                }
                this.a.clear();
            }
        }
    }

    public final c.a.r0.a.u.f.b.a c(BasePendingOperation.OperationType operationType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, operationType)) == null) {
            if (!this.a.containsKey(operationType.name())) {
                c.a.r0.a.u.f.b.a a = e.a(operationType);
                this.a.put(operationType.name(), a);
                return a;
            }
            return this.a.get(operationType.name());
        }
        return (c.a.r0.a.u.f.b.a) invokeL.objValue;
    }

    public synchronized void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this) {
                for (Map.Entry<String, c.a.r0.a.u.f.b.a> entry : this.a.entrySet()) {
                    entry.getValue().a();
                }
            }
        }
    }
}
