package com.baidu.searchbox.logsystem.logsys.eventscene.snapshot;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes4.dex */
public final class DeviceSnapshotType {
    public static final /* synthetic */ DeviceSnapshotType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final DeviceSnapshotType DEVICE_APP_DB_INFO;
    public static final DeviceSnapshotType DEVICE_APP_LOGCAT;
    public static final DeviceSnapshotType DEVICE_BUILD_PROC;
    public static final DeviceSnapshotType DEVICE_GUP_MEM;
    public static final DeviceSnapshotType DEVICE_INFO;
    public static final DeviceSnapshotType DEVICE_ION_MEM;
    public static final DeviceSnapshotType DEVICE_LINUX_KERNEL_VERSION;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1879459575, "Lcom/baidu/searchbox/logsystem/logsys/eventscene/snapshot/DeviceSnapshotType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1879459575, "Lcom/baidu/searchbox/logsystem/logsys/eventscene/snapshot/DeviceSnapshotType;");
                return;
            }
        }
        DEVICE_APP_DB_INFO = new DeviceSnapshotType("DEVICE_APP_DB_INFO", 0);
        DEVICE_APP_LOGCAT = new DeviceSnapshotType("DEVICE_APP_LOGCAT", 1);
        DEVICE_INFO = new DeviceSnapshotType("DEVICE_INFO", 2);
        DEVICE_GUP_MEM = new DeviceSnapshotType("DEVICE_GUP_MEM", 3);
        DEVICE_ION_MEM = new DeviceSnapshotType("DEVICE_ION_MEM", 4);
        DEVICE_LINUX_KERNEL_VERSION = new DeviceSnapshotType("DEVICE_LINUX_KERNEL_VERSION", 5);
        DeviceSnapshotType deviceSnapshotType = new DeviceSnapshotType("DEVICE_BUILD_PROC", 6);
        DEVICE_BUILD_PROC = deviceSnapshotType;
        $VALUES = new DeviceSnapshotType[]{DEVICE_APP_DB_INFO, DEVICE_APP_LOGCAT, DEVICE_INFO, DEVICE_GUP_MEM, DEVICE_ION_MEM, DEVICE_LINUX_KERNEL_VERSION, deviceSnapshotType};
    }

    public DeviceSnapshotType(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static DeviceSnapshotType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (DeviceSnapshotType) Enum.valueOf(DeviceSnapshotType.class, str) : (DeviceSnapshotType) invokeL.objValue;
    }

    public static DeviceSnapshotType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (DeviceSnapshotType[]) $VALUES.clone() : (DeviceSnapshotType[]) invokeV.objValue;
    }
}
