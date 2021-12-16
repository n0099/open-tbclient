package com.baidu.android.ddmlib.tools.perflib.vmtrace;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes9.dex */
public final class VmClockType {
    public static final /* synthetic */ VmClockType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final VmClockType DUAL;
    public static final VmClockType THREAD_CPU;
    public static final VmClockType WALL;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1568370565, "Lcom/baidu/android/ddmlib/tools/perflib/vmtrace/VmClockType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1568370565, "Lcom/baidu/android/ddmlib/tools/perflib/vmtrace/VmClockType;");
                return;
            }
        }
        THREAD_CPU = new VmClockType("THREAD_CPU", 0);
        WALL = new VmClockType("WALL", 1);
        VmClockType vmClockType = new VmClockType("DUAL", 2);
        DUAL = vmClockType;
        $VALUES = new VmClockType[]{THREAD_CPU, WALL, vmClockType};
    }

    public VmClockType(String str, int i2) {
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

    public static VmClockType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (VmClockType) Enum.valueOf(VmClockType.class, str) : (VmClockType) invokeL.objValue;
    }

    public static VmClockType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (VmClockType[]) $VALUES.clone() : (VmClockType[]) invokeV.objValue;
    }
}
