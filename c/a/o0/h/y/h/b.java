package c.a.o0.h.y.h;

import c.a.o0.a.n1.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.websocket.WebSocketTask;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes3.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public final boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            k d2 = d();
            if (d2 != null) {
                return d2.a();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void b(WebSocketTask task) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, task) == null) {
            Intrinsics.checkNotNullParameter(task, "task");
            k d2 = d();
            if (d2 != null) {
                d2.b(task);
            }
        }
    }

    public final void c(String taskId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, taskId) == null) {
            Intrinsics.checkNotNullParameter(taskId, "taskId");
            k d2 = d();
            if (d2 != null) {
                d2.c(taskId);
            }
        }
    }

    public final k d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            c.a.o0.a.a2.e i2 = c.a.o0.a.a2.e.i();
            if (i2 != null) {
                return i2.b0();
            }
            return null;
        }
        return (k) invokeV.objValue;
    }
}
