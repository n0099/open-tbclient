package com.baidu.searchbox.dns.transmit.task;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class TaskDispatcherFactory {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int PRIORITY_DISPATCHER = 1;
    public static final int SIMPLE_DISPATCHER = 0;
    public transient /* synthetic */ FieldHolder $fh;

    public TaskDispatcherFactory() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static Dispatcher createDispatcher(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) {
            if (i != 0) {
                if (i != 1) {
                    return new SimpleDispatcher();
                }
                return new PriorityDispatcher();
            }
            return new SimpleDispatcher();
        }
        return (Dispatcher) invokeI.objValue;
    }
}
