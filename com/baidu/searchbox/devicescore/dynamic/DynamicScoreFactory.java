package com.baidu.searchbox.devicescore.dynamic;

import com.baidu.searchbox.devicescore.IDeviceScore;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class DynamicScoreFactory {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "DynamicScoreFactory";
    public static Map<String, IDynamicScoreManager> sDynamicManagerMap;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(588257089, "Lcom/baidu/searchbox/devicescore/dynamic/DynamicScoreFactory;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(588257089, "Lcom/baidu/searchbox/devicescore/dynamic/DynamicScoreFactory;");
                return;
            }
        }
        sDynamicManagerMap = new HashMap(1);
    }

    public DynamicScoreFactory() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static IDynamicScoreManager getDynamicScoreManager(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (IDeviceScore.TYPE_LAUNCH_SPEED.equals(str)) {
                IDynamicScoreManager iDynamicScoreManager = sDynamicManagerMap.get(IDeviceScore.TYPE_LAUNCH_SPEED);
                if (iDynamicScoreManager == null) {
                    LaunchSpeedManager launchSpeedManager = new LaunchSpeedManager();
                    sDynamicManagerMap.put(IDeviceScore.TYPE_LAUNCH_SPEED, launchSpeedManager);
                    return launchSpeedManager;
                }
                return iDynamicScoreManager;
            }
            String str2 = "DynamicScoreFactory unKnow dynamic type:" + str;
            return null;
        }
        return (IDynamicScoreManager) invokeL.objValue;
    }
}
