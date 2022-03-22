package c.a.n0.a.k.f.b;

import com.baidu.swan.apps.api.pending.queue.operation.BasePendingOperation;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1968445128, "Lc/a/n0/a/k/f/b/e$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1968445128, "Lc/a/n0/a/k/f/b/e$a;");
                    return;
                }
            }
            int[] iArr = new int[BasePendingOperation.OperationType.values().length];
            a = iArr;
            try {
                iArr[BasePendingOperation.OperationType.OPERATION_TYPE_MAIN_THREAD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[BasePendingOperation.OperationType.OPERATION_TYPE_REQUEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static c.a.n0.a.k.f.b.a a(BasePendingOperation.OperationType operationType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, operationType)) == null) {
            int i = a.a[operationType.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    return new f();
                }
                return new d();
            }
            return new c();
        }
        return (c.a.n0.a.k.f.b.a) invokeL.objValue;
    }
}
