package com.baidu.searchbox.aideviceperformance.model;

import com.baidu.searchbox.aideviceperformance.inference.DevicePerformanceModelInfo;
import com.baidu.searchbox.aideviceperformance.model.ModelInfoDataProvider;
import com.baidu.searchbox.aideviceperformance.utils.Config;
import com.baidu.searchbox.aideviceperformance.utils.DeviceInfoSharedPreferenceWrapper;
import com.baidu.searchbox.aideviceperformance.utils.FileUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class ModelManager {
    public static long defaultModelsVersion = 1;
    public static HashMap<ModelInfoDataProvider.DevicePerformanceModelInfoType, IDevicePerformanceModelInfoProvider> mModelInfoProviderHashMap = new HashMap<>();

    public static DevicePerformanceModelInfo defaultModelInfo(ModelInfoDataProvider.DevicePerformanceModelInfoType devicePerformanceModelInfoType) {
        DevicePerformanceModelInfo devicePerformanceModelInfo;
        if (devicePerformanceModelInfoType == null || (devicePerformanceModelInfo = new ModelInfoDataProvider().getDefaultModelInfoMap().get(devicePerformanceModelInfoType)) == null) {
            return null;
        }
        return devicePerformanceModelInfo;
    }

    public static DevicePerformanceModelInfo getDevicePerformanceModelInfo(ModelInfoDataProvider.DevicePerformanceModelInfoType devicePerformanceModelInfoType) {
        DevicePerformanceModelInfo defaultModelInfo = defaultModelInfo(devicePerformanceModelInfoType);
        IDevicePerformanceModelInfoProvider iDevicePerformanceModelInfoProvider = mModelInfoProviderHashMap.get(devicePerformanceModelInfoType);
        if (iDevicePerformanceModelInfoProvider != null) {
            return iDevicePerformanceModelInfoProvider.getDevicePerformanceModelInfo(devicePerformanceModelInfoType, defaultModelInfo);
        }
        return defaultModelInfo;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean needUpdateDefaultModel() {
        if (Long.valueOf(DeviceInfoSharedPreferenceWrapper.getInstance().getLong(ModelInfoDataProvider.defaultModelAssertDir, -1L)).longValue() < defaultModelsVersion || !new File(ModelInfoDataProvider.defaultModelFilePath).exists()) {
            return true;
        }
        for (Map.Entry<ModelInfoDataProvider.DevicePerformanceModelInfoType, DevicePerformanceModelInfo> entry : new ModelInfoDataProvider().getDefaultModelInfoMap().entrySet()) {
            DevicePerformanceModelInfo value = entry.getValue();
            if (value == null || !new File(value.modelPath).exists()) {
                return true;
            }
            while (r0.hasNext()) {
            }
        }
        return false;
    }

    public boolean checkAndUpdatePresetModel() {
        boolean needUpdateDefaultModel;
        boolean needUpdateDefaultModel2 = needUpdateDefaultModel();
        if (!needUpdateDefaultModel2) {
            return needUpdateDefaultModel2;
        }
        synchronized (ModelManager.class) {
            needUpdateDefaultModel = needUpdateDefaultModel();
            if (needUpdateDefaultModel) {
                try {
                    FileUtil fileUtil = new FileUtil();
                    fileUtil.deleteFile(new File(ModelInfoDataProvider.defaultModelFilePath));
                    fileUtil.copyDirFromAssets(AppRuntime.getAppContext(), ModelInfoDataProvider.defaultModelAssertDir, ModelInfoDataProvider.defaultModelFilePath);
                    DeviceInfoSharedPreferenceWrapper.getInstance().putLong(ModelInfoDataProvider.defaultModelAssertDir, defaultModelsVersion);
                } catch (Exception e) {
                    if (Config.isDebug()) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return needUpdateDefaultModel;
    }

    public void setModelInfoProvider(IDevicePerformanceModelInfoProvider iDevicePerformanceModelInfoProvider, ModelInfoDataProvider.DevicePerformanceModelInfoType devicePerformanceModelInfoType) {
        if (iDevicePerformanceModelInfoProvider != null && devicePerformanceModelInfoType != null) {
            mModelInfoProviderHashMap.put(devicePerformanceModelInfoType, iDevicePerformanceModelInfoProvider);
        }
    }
}
