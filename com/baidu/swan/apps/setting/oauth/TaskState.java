package com.baidu.swan.apps.setting.oauth;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes11.dex */
public final class TaskState {
    public static final /* synthetic */ TaskState[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final TaskState CALLING;
    public static final TaskState FINISHED;
    public static final TaskState INIT;
    public transient /* synthetic */ FieldHolder $fh;
    public final int mCode;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1505696947, "Lcom/baidu/swan/apps/setting/oauth/TaskState;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1505696947, "Lcom/baidu/swan/apps/setting/oauth/TaskState;");
                return;
            }
        }
        INIT = new TaskState("INIT", 0, 0);
        CALLING = new TaskState("CALLING", 1, 1);
        TaskState taskState = new TaskState("FINISHED", 2, 2);
        FINISHED = taskState;
        $VALUES = new TaskState[]{INIT, CALLING, taskState};
    }

    public TaskState(String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mCode = i3;
    }

    public static TaskState valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (TaskState) Enum.valueOf(TaskState.class, str) : (TaskState) invokeL.objValue;
    }

    public static TaskState[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (TaskState[]) $VALUES.clone() : (TaskState[]) invokeV.objValue;
    }

    public boolean isCallbackAvailable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mCode < FINISHED.mCode : invokeV.booleanValue;
    }
}
