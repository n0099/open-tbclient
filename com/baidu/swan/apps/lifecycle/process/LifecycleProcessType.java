package com.baidu.swan.apps.lifecycle.process;

import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes10.dex */
public final class LifecycleProcessType {
    public static final /* synthetic */ LifecycleProcessType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final LifecycleProcessType MAIN;
    public static final LifecycleProcessType OTHER;
    public static final LifecycleProcessType SWAN;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1316604982, "Lcom/baidu/swan/apps/lifecycle/process/LifecycleProcessType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1316604982, "Lcom/baidu/swan/apps/lifecycle/process/LifecycleProcessType;");
                return;
            }
        }
        MAIN = new LifecycleProcessType("MAIN", 0);
        SWAN = new LifecycleProcessType("SWAN", 1);
        LifecycleProcessType lifecycleProcessType = new LifecycleProcessType("OTHER", 2);
        OTHER = lifecycleProcessType;
        $VALUES = new LifecycleProcessType[]{MAIN, SWAN, lifecycleProcessType};
    }

    public LifecycleProcessType(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static LifecycleProcessType getCurrent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            String curProcessName = ProcessUtils.getCurProcessName();
            if (ProcessUtils.checkIsMainProcess(curProcessName)) {
                return MAIN;
            }
            if (SwanAppProcessInfo.isSwanAppProcess(curProcessName)) {
                return SWAN;
            }
            return OTHER;
        }
        return (LifecycleProcessType) invokeV.objValue;
    }

    public static LifecycleProcessType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (LifecycleProcessType) Enum.valueOf(LifecycleProcessType.class, str) : (LifecycleProcessType) invokeL.objValue;
    }

    public static LifecycleProcessType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (LifecycleProcessType[]) $VALUES.clone() : (LifecycleProcessType[]) invokeV.objValue;
    }
}
