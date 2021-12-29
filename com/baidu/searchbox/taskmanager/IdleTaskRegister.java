package com.baidu.searchbox.taskmanager;

import c.a.d.e.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.IdleLaunchTask;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public class IdleTaskRegister implements a.InterfaceC0098a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, IdleLaunchTask> mTaskMap;

    public IdleTaskRegister() {
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
        this.mTaskMap = new HashMap();
    }

    @Override // c.a.d.e.a.InterfaceC0098a
    public void registerIdleTask(String str, Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, runnable) == null) {
            this.mTaskMap.put(str, new IdleLaunchTask(this, str, runnable) { // from class: com.baidu.searchbox.taskmanager.IdleTaskRegister.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ IdleTaskRegister this$0;
                public final /* synthetic */ Runnable val$runnable;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(str);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, runnable};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            super((String) newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$runnable = runnable;
                }

                @Override // com.baidu.searchbox.launch.SmartLaunchTask
                public void execute() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.val$runnable.run();
                    }
                }
            });
        }
    }

    @Override // c.a.d.e.a.InterfaceC0098a
    public void scheduleIdleTask(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            for (Map.Entry<String, IdleLaunchTask> entry : this.mTaskMap.entrySet()) {
                entry.getKey();
                IdleLaunchTask value = entry.getValue();
                if (z) {
                    IdleLaunchTaskManager.registerIdleTask(value);
                } else if (!value.isExecuted()) {
                    value.run();
                }
            }
            if (z) {
                return;
            }
            this.mTaskMap.clear();
        }
    }
}
