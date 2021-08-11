package com.baidu.searchbox.logsystem.logsys.eventscene.snapshot;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes5.dex */
public final class ProcessSnapshotType {
    public static final /* synthetic */ ProcessSnapshotType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final ProcessSnapshotType PROCESS_FILE_DESCRIPTOR;
    public static final ProcessSnapshotType PROCESS_MAPS;
    public static final ProcessSnapshotType PROCESS_MEMORY_STATUS;
    public static final ProcessSnapshotType PROCESS_RUNNING_STATUS;
    public static final ProcessSnapshotType PROCESS_SMAPS;
    public static final ProcessSnapshotType PROCESS_STATUS;
    public static final ProcessSnapshotType PROCESS_THREAD_LIST;
    public static final ProcessSnapshotType PROCESS_UI_TRACE;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1154545652, "Lcom/baidu/searchbox/logsystem/logsys/eventscene/snapshot/ProcessSnapshotType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1154545652, "Lcom/baidu/searchbox/logsystem/logsys/eventscene/snapshot/ProcessSnapshotType;");
                return;
            }
        }
        PROCESS_SMAPS = new ProcessSnapshotType("PROCESS_SMAPS", 0);
        PROCESS_STATUS = new ProcessSnapshotType("PROCESS_STATUS", 1);
        PROCESS_MAPS = new ProcessSnapshotType("PROCESS_MAPS", 2);
        PROCESS_THREAD_LIST = new ProcessSnapshotType("PROCESS_THREAD_LIST", 3);
        PROCESS_FILE_DESCRIPTOR = new ProcessSnapshotType("PROCESS_FILE_DESCRIPTOR", 4);
        PROCESS_UI_TRACE = new ProcessSnapshotType("PROCESS_UI_TRACE", 5);
        PROCESS_MEMORY_STATUS = new ProcessSnapshotType("PROCESS_MEMORY_STATUS", 6);
        ProcessSnapshotType processSnapshotType = new ProcessSnapshotType("PROCESS_RUNNING_STATUS", 7);
        PROCESS_RUNNING_STATUS = processSnapshotType;
        $VALUES = new ProcessSnapshotType[]{PROCESS_SMAPS, PROCESS_STATUS, PROCESS_MAPS, PROCESS_THREAD_LIST, PROCESS_FILE_DESCRIPTOR, PROCESS_UI_TRACE, PROCESS_MEMORY_STATUS, processSnapshotType};
    }

    public ProcessSnapshotType(String str, int i2) {
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

    public static void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
        }
    }

    public static ProcessSnapshotType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (ProcessSnapshotType) Enum.valueOf(ProcessSnapshotType.class, str) : (ProcessSnapshotType) invokeL.objValue;
    }

    public static ProcessSnapshotType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (ProcessSnapshotType[]) $VALUES.clone() : (ProcessSnapshotType[]) invokeV.objValue;
    }
}
