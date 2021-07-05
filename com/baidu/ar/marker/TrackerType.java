package com.baidu.ar.marker;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes.dex */
public final class TrackerType {
    public static final /* synthetic */ TrackerType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final TrackerType IMU_ANDROID;
    public static final TrackerType IMU_IPHONE;
    public static final TrackerType NO_TRACKER_DATA;
    public static final TrackerType STANDARD_TRACKER_DATA;
    public static final TrackerType VIO_ARCORE_DATA;
    public static final TrackerType VIO_ARKIT_DATA;
    public transient /* synthetic */ FieldHolder $fh;
    public int value;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(158596462, "Lcom/baidu/ar/marker/TrackerType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(158596462, "Lcom/baidu/ar/marker/TrackerType;");
                return;
            }
        }
        NO_TRACKER_DATA = new TrackerType("NO_TRACKER_DATA", 0, 0);
        STANDARD_TRACKER_DATA = new TrackerType("STANDARD_TRACKER_DATA", 1, 1);
        VIO_ARKIT_DATA = new TrackerType("VIO_ARKIT_DATA", 2, 2);
        VIO_ARCORE_DATA = new TrackerType("VIO_ARCORE_DATA", 3, 3);
        IMU_IPHONE = new TrackerType("IMU_IPHONE", 4, 4);
        TrackerType trackerType = new TrackerType("IMU_ANDROID", 5, 5);
        IMU_ANDROID = trackerType;
        $VALUES = new TrackerType[]{NO_TRACKER_DATA, STANDARD_TRACKER_DATA, VIO_ARKIT_DATA, VIO_ARCORE_DATA, IMU_IPHONE, trackerType};
    }

    public TrackerType(String str, int i2, int i3) {
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
        this.value = i3;
    }

    public static TrackerType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (TrackerType) Enum.valueOf(TrackerType.class, str) : (TrackerType) invokeL.objValue;
    }

    public static TrackerType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (TrackerType[]) $VALUES.clone() : (TrackerType[]) invokeV.objValue;
    }

    public int getValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.value : invokeV.intValue;
    }
}
