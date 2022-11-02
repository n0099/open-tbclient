package com.baidu.searchbox.aideviceperformance.model;

import com.baidu.searchbox.aideviceperformance.amendeddevicescore.AmendedDeviceScoreManager;
import com.baidu.searchbox.aideviceperformance.inference.DevicePerformanceModelInfo;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class ModelInfoDataProvider {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEFAULTMODELNAME_AMENDEDSTATICSCORE = "amended_static_score.mlmodel";
    public static final long DEFAULTMODELVERSION_AMENDEDSTATICSCORE = 1;
    public static HashMap<DevicePerformanceModelInfoType, DevicePerformanceModelInfo> DefaultModelInfoMap = null;
    public static String DefaultModelInfoMapKeyModelName = null;
    public static String DefaultModelInfoMapKeyModelVersion = null;
    public static String defaultModelAssertDir = "ai_device_performance_models";
    public static String defaultModelFilePath;
    public static String defaultModelName_GbdtDeviceScore;
    public static String defaultModelName_LaunchSpeedScore;
    public static String defaultModelName_LrDeviceScore;
    public static String defaultModelName_StaticScoreMapper;
    public static long defaultModelVersion_GbdtDeviceScore;
    public static long defaultModelVersion_LaunchSpeedScore;
    public static long defaultModelVersion_LrDeviceScore;
    public static long defaultModelVersion_StaticScoreMapper;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class DevicePerformanceModelInfoType {
        public static final /* synthetic */ DevicePerformanceModelInfoType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final DevicePerformanceModelInfoType AmendedDeviceScore;
        public static final DevicePerformanceModelInfoType DeviceInfoGBDT;
        public static final DevicePerformanceModelInfoType DeviceInfoLR;
        public static final DevicePerformanceModelInfoType DeviceInfoMapper;
        public static final DevicePerformanceModelInfoType DynamicLR;
        public transient /* synthetic */ FieldHolder $fh;
        public final String type;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1591571797, "Lcom/baidu/searchbox/aideviceperformance/model/ModelInfoDataProvider$DevicePerformanceModelInfoType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1591571797, "Lcom/baidu/searchbox/aideviceperformance/model/ModelInfoDataProvider$DevicePerformanceModelInfoType;");
                    return;
                }
            }
            DeviceInfoGBDT = new DevicePerformanceModelInfoType("DeviceInfoGBDT", 0, ModelInfoDataProvider.defaultModelName_GbdtDeviceScore);
            DeviceInfoLR = new DevicePerformanceModelInfoType("DeviceInfoLR", 1, ModelInfoDataProvider.defaultModelName_LrDeviceScore);
            DeviceInfoMapper = new DevicePerformanceModelInfoType("DeviceInfoMapper", 2, ModelInfoDataProvider.defaultModelName_StaticScoreMapper);
            DynamicLR = new DevicePerformanceModelInfoType("DynamicLR", 3, ModelInfoDataProvider.defaultModelName_LaunchSpeedScore);
            DevicePerformanceModelInfoType devicePerformanceModelInfoType = new DevicePerformanceModelInfoType(AmendedDeviceScoreManager.TAG, 4, ModelInfoDataProvider.defaultModelName_LaunchSpeedScore);
            AmendedDeviceScore = devicePerformanceModelInfoType;
            $VALUES = new DevicePerformanceModelInfoType[]{DeviceInfoGBDT, DeviceInfoLR, DeviceInfoMapper, DynamicLR, devicePerformanceModelInfoType};
        }

        public DevicePerformanceModelInfoType(String str, int i, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i), str2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str3 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.type = str2;
        }

        public static DevicePerformanceModelInfoType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (DevicePerformanceModelInfoType) Enum.valueOf(DevicePerformanceModelInfoType.class, str);
            }
            return (DevicePerformanceModelInfoType) invokeL.objValue;
        }

        public static DevicePerformanceModelInfoType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (DevicePerformanceModelInfoType[]) $VALUES.clone();
            }
            return (DevicePerformanceModelInfoType[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(893653606, "Lcom/baidu/searchbox/aideviceperformance/model/ModelInfoDataProvider;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(893653606, "Lcom/baidu/searchbox/aideviceperformance/model/ModelInfoDataProvider;");
                return;
            }
        }
        defaultModelFilePath = AppRuntime.getAppContext().getFilesDir().getAbsolutePath() + File.separator + defaultModelAssertDir + File.separator;
        defaultModelVersion_GbdtDeviceScore = 2L;
        defaultModelName_GbdtDeviceScore = "gbdt_device_score.mlmodel";
        defaultModelVersion_LrDeviceScore = 1L;
        defaultModelName_LrDeviceScore = "lr_device_score.mlmodel";
        defaultModelVersion_StaticScoreMapper = 1L;
        defaultModelName_StaticScoreMapper = "static-score-mapper.mlmodel";
        defaultModelVersion_LaunchSpeedScore = 1L;
        defaultModelName_LaunchSpeedScore = "launch-speed-score.mlmodel";
        DefaultModelInfoMapKeyModelName = "modelName";
        DefaultModelInfoMapKeyModelVersion = "modelVersioon";
        DefaultModelInfoMap = null;
    }

    public ModelInfoDataProvider() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    private void setModelInfoToMap(String str, Long l, DevicePerformanceModelInfoType devicePerformanceModelInfoType, HashMap<DevicePerformanceModelInfoType, DevicePerformanceModelInfo> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65542, this, str, l, devicePerformanceModelInfoType, hashMap) == null) {
            hashMap.put(devicePerformanceModelInfoType, new DevicePerformanceModelInfo(defaultModelFilePath + str, l.longValue()));
        }
    }

    public HashMap<DevicePerformanceModelInfoType, DevicePerformanceModelInfo> getDefaultModelInfoMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            HashMap<DevicePerformanceModelInfoType, DevicePerformanceModelInfo> hashMap = DefaultModelInfoMap;
            if (hashMap != null) {
                return hashMap;
            }
            HashMap<DevicePerformanceModelInfoType, DevicePerformanceModelInfo> hashMap2 = new HashMap<>();
            setModelInfoToMap(defaultModelName_GbdtDeviceScore, Long.valueOf(defaultModelVersion_GbdtDeviceScore), DevicePerformanceModelInfoType.DeviceInfoGBDT, hashMap2);
            setModelInfoToMap(defaultModelName_LrDeviceScore, Long.valueOf(defaultModelVersion_LrDeviceScore), DevicePerformanceModelInfoType.DeviceInfoLR, hashMap2);
            setModelInfoToMap(defaultModelName_StaticScoreMapper, Long.valueOf(defaultModelVersion_StaticScoreMapper), DevicePerformanceModelInfoType.DeviceInfoMapper, hashMap2);
            setModelInfoToMap(defaultModelName_LaunchSpeedScore, Long.valueOf(defaultModelVersion_LaunchSpeedScore), DevicePerformanceModelInfoType.DynamicLR, hashMap2);
            setModelInfoToMap(DEFAULTMODELNAME_AMENDEDSTATICSCORE, 1L, DevicePerformanceModelInfoType.AmendedDeviceScore, hashMap2);
            DefaultModelInfoMap = hashMap2;
            return hashMap2;
        }
        return (HashMap) invokeV.objValue;
    }
}
