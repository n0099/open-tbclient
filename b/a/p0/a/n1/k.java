package b.a.p0.a.n1;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.websocket.WebSocketManager;
import com.baidu.searchbox.websocket.WebSocketTask;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public volatile Set<String> f6921a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1330136838, "Lb/a/p0/a/n1/k;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1330136838, "Lb/a/p0/a/n1/k;");
        }
    }

    public k() {
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

    public final synchronized boolean a() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                Set<String> set = this.f6921a;
                z = (set != null ? set.size() : 0) < 5;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public final synchronized void b(WebSocketTask task) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, task) == null) {
            synchronized (this) {
                Intrinsics.checkNotNullParameter(task, "task");
                if (this.f6921a == null) {
                    this.f6921a = new LinkedHashSet();
                }
                Set<String> set = this.f6921a;
                if (set != null) {
                    set.add(task.getTaskId());
                }
            }
        }
    }

    public final synchronized void c(String taskId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, taskId) == null) {
            synchronized (this) {
                Intrinsics.checkNotNullParameter(taskId, "taskId");
                Set<String> set = this.f6921a;
                if (set != null) {
                    set.remove(taskId);
                }
            }
        }
    }

    public final synchronized void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this) {
                Set<String> set = this.f6921a;
                if (set != null) {
                    for (String str : set) {
                        try {
                            WebSocketManager.INSTANCE.close(str, 1001, "aiapp terminate");
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                }
                Set<String> set2 = this.f6921a;
                if (set2 != null) {
                    set2.clear();
                }
            }
        }
    }
}
