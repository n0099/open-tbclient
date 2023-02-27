package com.baidu.searchbox.aideviceperformance.model;

import com.baidu.searchbox.aideviceperformance.inference.DevicePerformanceModelInfo;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class ModelInfoDataProvider {
    public static final String DEFAULTMODELNAME_AMENDEDSTATICSCORE = "amended_static_score.mlmodel";
    public static final long DEFAULTMODELVERSION_AMENDEDSTATICSCORE = 1;
    public static String defaultModelAssertDir = "ai_device_performance_models";
    public static String defaultModelFilePath = AppRuntime.getAppContext().getFilesDir().getAbsolutePath() + File.separator + defaultModelAssertDir + File.separator;
    public static long defaultModelVersion_GbdtDeviceScore = 2;
    public static String defaultModelName_GbdtDeviceScore = "gbdt_device_score.mlmodel";
    public static long defaultModelVersion_LrDeviceScore = 1;
    public static String defaultModelName_LrDeviceScore = "lr_device_score.mlmodel";
    public static long defaultModelVersion_StaticScoreMapper = 1;
    public static String defaultModelName_StaticScoreMapper = "static-score-mapper.mlmodel";
    public static long defaultModelVersion_LaunchSpeedScore = 1;
    public static String defaultModelName_LaunchSpeedScore = "launch-speed-score.mlmodel";
    public static String DefaultModelInfoMapKeyModelName = "modelName";
    public static String DefaultModelInfoMapKeyModelVersion = "modelVersioon";
    public static HashMap<DevicePerformanceModelInfoType, DevicePerformanceModelInfo> DefaultModelInfoMap = null;

    public HashMap<DevicePerformanceModelInfoType, DevicePerformanceModelInfo> getDefaultModelInfoMap() {
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

    /* loaded from: classes2.dex */
    public enum DevicePerformanceModelInfoType {
        DeviceInfoGBDT(ModelInfoDataProvider.defaultModelName_GbdtDeviceScore),
        DeviceInfoLR(ModelInfoDataProvider.defaultModelName_LrDeviceScore),
        DeviceInfoMapper(ModelInfoDataProvider.defaultModelName_StaticScoreMapper),
        DynamicLR(ModelInfoDataProvider.defaultModelName_LaunchSpeedScore),
        AmendedDeviceScore(ModelInfoDataProvider.defaultModelName_LaunchSpeedScore);
        
        public final String type;

        DevicePerformanceModelInfoType(String str) {
            this.type = str;
        }
    }

    private void setModelInfoToMap(String str, Long l, DevicePerformanceModelInfoType devicePerformanceModelInfoType, HashMap<DevicePerformanceModelInfoType, DevicePerformanceModelInfo> hashMap) {
        hashMap.put(devicePerformanceModelInfoType, new DevicePerformanceModelInfo(defaultModelFilePath + str, l.longValue()));
    }
}
