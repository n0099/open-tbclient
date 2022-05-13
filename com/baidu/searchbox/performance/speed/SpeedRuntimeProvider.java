package com.baidu.searchbox.performance.speed;

import android.app.Activity;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceNotFoundException;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.qc1;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class SpeedRuntimeProvider extends qc1<ISpeedContext> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String MAIN_ACTIVITY_NAME = "com.baidu.tieba.tblauncher.MainTabActivity";
    public static final String SCHEMA_ACTIVITY_NAME = "com.baidu.tieba.tblauncher.SchemaRouteActivity";
    public static final String SPLASH_ACTIVITY_NAME = "com.baidu.tieba.LogoActivity";
    public transient /* synthetic */ FieldHolder $fh;

    public SpeedRuntimeProvider() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.repackage.qc1
    public ISpeedContext createService() throws ServiceNotFoundException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new ISpeedContext(this) { // from class: com.baidu.searchbox.performance.speed.SpeedRuntimeProvider.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ SpeedRuntimeProvider this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.baidu.searchbox.performance.speed.ISpeedContext
            public void checkSendStatisticData() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                }
            }

            @Override // com.baidu.searchbox.performance.speed.ISpeedContext
            public String getVersionName() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV2 = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "1.0" : (String) invokeV2.objValue;
            }

            @Override // com.baidu.searchbox.performance.speed.ISpeedContext
            public boolean hasSkin() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                    return false;
                }
                return invokeV2.booleanValue;
            }

            @Override // com.baidu.searchbox.performance.speed.ISpeedContext
            public boolean isAdShowing() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048579, this)) == null) ? MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW : invokeV2.booleanValue;
            }

            @Override // com.baidu.searchbox.performance.speed.ISpeedContext
            public boolean isAgreePrivacyPolicy() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048580, this)) == null) ? PermissionUtil.isAgreePrivacyPolicy() : invokeV2.booleanValue;
            }

            @Override // com.baidu.searchbox.performance.speed.ISpeedContext
            public boolean isMainActivity(Activity activity) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048581, this, activity)) == null) ? SpeedRuntimeProvider.MAIN_ACTIVITY_NAME.equals(activity.getClass().getName()) : invokeL.booleanValue;
            }

            @Override // com.baidu.searchbox.performance.speed.ISpeedContext
            public boolean isMainLine() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048582, this)) == null) {
                    return true;
                }
                return invokeV2.booleanValue;
            }

            @Override // com.baidu.searchbox.performance.speed.ISpeedContext
            public boolean isMainProcess() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048583, this)) == null) ? TbadkCoreApplication.getInst().isMainProcess(false) : invokeV2.booleanValue;
            }

            @Override // com.baidu.searchbox.performance.speed.ISpeedContext
            public boolean isPushDispatchActivity(Activity activity) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, activity)) == null) ? "com.baidu.tieba.tblauncher.SchemaRouteActivity".equals(activity.getClass().getName()) : invokeL.booleanValue;
            }

            @Override // com.baidu.searchbox.performance.speed.ISpeedContext
            public boolean isSchemeDispatchActivity(Activity activity) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048585, this, activity)) == null) ? "com.baidu.tieba.tblauncher.SchemaRouteActivity".equals(activity.getClass().getName()) : invokeL.booleanValue;
            }

            @Override // com.baidu.searchbox.performance.speed.ISpeedContext
            public boolean isSplashActivity(Activity activity) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048586, this, activity)) == null) ? SpeedRuntimeProvider.SPLASH_ACTIVITY_NAME.equals(activity.getClass().getName()) : invokeL.booleanValue;
            }

            @Override // com.baidu.searchbox.performance.speed.ISpeedContext
            public void launchData(HashMap<String, String> hashMap) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048587, this, hashMap) == null) {
                }
            }

            @Override // com.baidu.searchbox.performance.speed.ISpeedContext
            public void launchTime(boolean z, long j) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048588, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j)}) == null) {
                }
            }
        } : (ISpeedContext) invokeV.objValue;
    }
}
