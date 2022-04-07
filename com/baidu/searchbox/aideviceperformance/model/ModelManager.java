package com.baidu.searchbox.aideviceperformance.model;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.aideviceperformance.inference.DevicePerformanceModelInfo;
import com.baidu.searchbox.aideviceperformance.model.ModelInfoDataProvider;
import com.baidu.searchbox.aideviceperformance.utils.Config;
import com.baidu.searchbox.aideviceperformance.utils.DeviceInfoSharedPreferenceWrapper;
import com.baidu.searchbox.aideviceperformance.utils.FileUtil;
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
import java.util.Map;
/* loaded from: classes2.dex */
public class ModelManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static long defaultModelsVersion = 1;
    public static HashMap<ModelInfoDataProvider.DevicePerformanceModelInfoType, IDevicePerformanceModelInfoProvider> mModelInfoProviderHashMap;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-380839142, "Lcom/baidu/searchbox/aideviceperformance/model/ModelManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-380839142, "Lcom/baidu/searchbox/aideviceperformance/model/ModelManager;");
                return;
            }
        }
        mModelInfoProviderHashMap = new HashMap<>();
    }

    public ModelManager() {
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

    public static DevicePerformanceModelInfo defaultModelInfo(ModelInfoDataProvider.DevicePerformanceModelInfoType devicePerformanceModelInfoType) {
        InterceptResult invokeL;
        DevicePerformanceModelInfo devicePerformanceModelInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, devicePerformanceModelInfoType)) == null) {
            if (devicePerformanceModelInfoType == null || (devicePerformanceModelInfo = new ModelInfoDataProvider().getDefaultModelInfoMap().get(devicePerformanceModelInfoType)) == null) {
                return null;
            }
            return devicePerformanceModelInfo;
        }
        return (DevicePerformanceModelInfo) invokeL.objValue;
    }

    public static DevicePerformanceModelInfo getDevicePerformanceModelInfo(ModelInfoDataProvider.DevicePerformanceModelInfoType devicePerformanceModelInfoType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, devicePerformanceModelInfoType)) == null) {
            DevicePerformanceModelInfo defaultModelInfo = defaultModelInfo(devicePerformanceModelInfoType);
            IDevicePerformanceModelInfoProvider iDevicePerformanceModelInfoProvider = mModelInfoProviderHashMap.get(devicePerformanceModelInfoType);
            return iDevicePerformanceModelInfoProvider != null ? iDevicePerformanceModelInfoProvider.getDevicePerformanceModelInfo(devicePerformanceModelInfoType, defaultModelInfo) : defaultModelInfo;
        }
        return (DevicePerformanceModelInfo) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean needUpdateDefaultModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (Long.valueOf(DeviceInfoSharedPreferenceWrapper.getInstance().getLong(ModelInfoDataProvider.defaultModelAssertDir, -1L)).longValue() >= defaultModelsVersion && new File(ModelInfoDataProvider.defaultModelFilePath).exists()) {
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
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean checkAndUpdatePresetModel() {
        InterceptResult invokeV;
        boolean needUpdateDefaultModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            boolean needUpdateDefaultModel2 = needUpdateDefaultModel();
            if (needUpdateDefaultModel2) {
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
            return needUpdateDefaultModel2;
        }
        return invokeV.booleanValue;
    }

    public void setModelInfoProvider(IDevicePerformanceModelInfoProvider iDevicePerformanceModelInfoProvider, ModelInfoDataProvider.DevicePerformanceModelInfoType devicePerformanceModelInfoType) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iDevicePerformanceModelInfoProvider, devicePerformanceModelInfoType) == null) || iDevicePerformanceModelInfoProvider == null || devicePerformanceModelInfoType == null) {
            return;
        }
        mModelInfoProviderHashMap.put(devicePerformanceModelInfoType, iDevicePerformanceModelInfoProvider);
    }
}
