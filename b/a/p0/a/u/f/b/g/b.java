package b.a.p0.a.u.f.b.g;

import b.a.p0.a.k;
import b.a.p0.a.u.f.b.e;
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
    public static final boolean f8945b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, b.a.p0.a.u.f.b.a> f8946a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-432011545, "Lb/a/p0/a/u/f/b/g/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-432011545, "Lb/a/p0/a/u/f/b/g/b;");
                return;
            }
        }
        f8945b = k.f6863a;
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
        this.f8946a = new LinkedHashMap();
    }

    public synchronized void a(BasePendingOperation basePendingOperation) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, basePendingOperation) == null) {
            synchronized (this) {
                if (basePendingOperation == null) {
                    return;
                }
                if (f8945b) {
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
                for (Map.Entry<String, b.a.p0.a.u.f.b.a> entry : this.f8946a.entrySet()) {
                    entry.getValue().c();
                }
                this.f8946a.clear();
            }
        }
    }

    public final b.a.p0.a.u.f.b.a c(BasePendingOperation.OperationType operationType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, operationType)) == null) {
            if (!this.f8946a.containsKey(operationType.name())) {
                b.a.p0.a.u.f.b.a a2 = e.a(operationType);
                this.f8946a.put(operationType.name(), a2);
                return a2;
            }
            return this.f8946a.get(operationType.name());
        }
        return (b.a.p0.a.u.f.b.a) invokeL.objValue;
    }

    public synchronized void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this) {
                for (Map.Entry<String, b.a.p0.a.u.f.b.a> entry : this.f8946a.entrySet()) {
                    entry.getValue().a();
                }
            }
        }
    }
}
