package com.baidu.searchbox.performance.speed;

import android.app.Activity;
import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
@Autowired
/* loaded from: classes5.dex */
public class SpeedRuntime {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String MAIN_ACTIVITY_NAME = "com.baidu.tieba.tblauncher.MainTabActivity";
    public static final String SCHEMA_ACTIVITY_NAME = "com.baidu.tieba.tblauncher.SchemaRouteActivity";
    public static final String SPLASH_ACTIVITY_NAME = "com.baidu.tieba.LogoActivity";
    public transient /* synthetic */ FieldHolder $fh;

    public SpeedRuntime() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static Context getAppContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? AppRuntime.getAppContext() : (Context) invokeV.objValue;
    }

    @Inject(force = false)
    public static ISpeedContext getSpeedContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new ISpeedContext() { // from class: com.baidu.searchbox.performance.speed.SpeedRuntime.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.searchbox.performance.speed.ISpeedContext
            public void checkSendStatisticData() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                }
            }

            @Override // com.baidu.searchbox.performance.speed.ISpeedContext
            public boolean getNightModeSwitcherState() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV2 = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? TbadkCoreApplication.getInst().getSkinType() == 1 : invokeV2.booleanValue;
            }

            @Override // com.baidu.searchbox.performance.speed.ISpeedContext
            public String getVersionName() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV2 = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "1.0" : (String) invokeV2.objValue;
            }

            @Override // com.baidu.searchbox.performance.speed.ISpeedContext
            public boolean hasSkin() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048579, this)) == null) {
                    return false;
                }
                return invokeV2.booleanValue;
            }

            @Override // com.baidu.searchbox.performance.speed.ISpeedContext
            public boolean isMainActivity(Activity activity) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048580, this, activity)) == null) ? SpeedRuntime.MAIN_ACTIVITY_NAME.equals(activity.getClass().getName()) : invokeL.booleanValue;
            }

            @Override // com.baidu.searchbox.performance.speed.ISpeedContext
            public boolean isMainLine() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048581, this)) == null) {
                    return true;
                }
                return invokeV2.booleanValue;
            }

            @Override // com.baidu.searchbox.performance.speed.ISpeedContext
            public boolean isPushDispatchActivity(Activity activity) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048582, this, activity)) == null) ? SpeedRuntime.SCHEMA_ACTIVITY_NAME.equals(activity.getClass().getName()) : invokeL.booleanValue;
            }

            @Override // com.baidu.searchbox.performance.speed.ISpeedContext
            public boolean isSchemeDispatchActivity(Activity activity) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048583, this, activity)) == null) ? SpeedRuntime.SCHEMA_ACTIVITY_NAME.equals(activity.getClass().getName()) : invokeL.booleanValue;
            }

            @Override // com.baidu.searchbox.performance.speed.ISpeedContext
            public boolean isSplashActivity(Activity activity) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, activity)) == null) ? SpeedRuntime.SPLASH_ACTIVITY_NAME.equals(activity.getClass().getName()) : invokeL.booleanValue;
            }

            @Override // com.baidu.searchbox.performance.speed.ISpeedContext
            public void launchData(HashMap<String, String> hashMap) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048585, this, hashMap) == null) {
                }
            }

            @Override // com.baidu.searchbox.performance.speed.ISpeedContext
            public void launchTime(boolean z, long j2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048586, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j2)}) == null) {
                }
            }
        } : (ISpeedContext) invokeV.objValue;
    }

    public static boolean isDebug() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? AppConfig.isDebug() : invokeV.booleanValue;
    }
}
