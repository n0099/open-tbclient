package com.baidu.tbadk.core;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.tieba.vla;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class GlobalBuildConfig {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static String getFunAdAppId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? "b122ce58b8954c27b6882f7987c08860" : (String) invokeV.objValue;
    }

    public static boolean isDebug() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public GlobalBuildConfig() {
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

    @NonNull
    public static String getBuildParamsConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return vla.c(AppRuntime.getAppContext(), "BUILD_PARAMS_CONFIG");
        }
        return (String) invokeV.objValue;
    }

    public static int getHomepageTestBtnType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return vla.b(AppRuntime.getAppContext(), "HOMEPAGE_TEST_BTN_TYPE");
        }
        return invokeV.intValue;
    }

    @NonNull
    public static String getTiebaNpsPluginMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return vla.c(AppRuntime.getAppContext(), "TIEBA_NPS_PLUGIN_MODE");
        }
        return (String) invokeV.objValue;
    }

    public static int getVersionCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return TbadkCoreApplication.getInst().getVersionCode();
        }
        return invokeV.intValue;
    }

    @NonNull
    public static String getVersionName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return TbadkCoreApplication.getInst().getVersionName();
        }
        return (String) invokeV.objValue;
    }

    public static boolean isFlutterPerfTool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            return vla.a(AppRuntime.getAppContext(), "FLUTTER_PERF_TOOL");
        }
        return invokeV.booleanValue;
    }

    public static boolean isFunAdTestTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            return vla.a(AppRuntime.getAppContext(), "FUN_AD_TEST_TEST");
        }
        return invokeV.booleanValue;
    }

    public static boolean isTiebaDebugTool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            return vla.a(AppRuntime.getAppContext(), "TIEBA_MODIFY_ENABLE");
        }
        return invokeV.booleanValue;
    }
}
