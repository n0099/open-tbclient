package com.baidu.searchbox.aideviceperformance.device;

import android.content.Context;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public interface IDevicePortraitManager {
    float getDefaultScoreThreshold(ThresholdType thresholdType);

    float getStaticDeviceScore(Context context);

    float getStaticDeviceScorePercentage(Context context);

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class ThresholdType {
        public static final /* synthetic */ ThresholdType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final ThresholdType LOW_MID;
        public static final ThresholdType MID_HIGH;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(593769957, "Lcom/baidu/searchbox/aideviceperformance/device/IDevicePortraitManager$ThresholdType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(593769957, "Lcom/baidu/searchbox/aideviceperformance/device/IDevicePortraitManager$ThresholdType;");
                    return;
                }
            }
            LOW_MID = new ThresholdType("LOW_MID", 0);
            ThresholdType thresholdType = new ThresholdType("MID_HIGH", 1);
            MID_HIGH = thresholdType;
            $VALUES = new ThresholdType[]{LOW_MID, thresholdType};
        }

        public ThresholdType(String str, int i) {
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

        public static ThresholdType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (ThresholdType) Enum.valueOf(ThresholdType.class, str);
            }
            return (ThresholdType) invokeL.objValue;
        }

        public static ThresholdType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (ThresholdType[]) $VALUES.clone();
            }
            return (ThresholdType[]) invokeV.objValue;
        }
    }
}
