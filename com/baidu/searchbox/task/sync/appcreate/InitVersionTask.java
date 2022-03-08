package com.baidu.searchbox.task.sync.appcreate;

import android.content.pm.ApplicationInfo;
import c.a.d.f.m.b;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class InitVersionTask extends LaunchTask {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public InitVersionTask() {
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

    private void initVersion() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            ApplicationInfo applicationInfo = null;
            try {
                applicationInfo = TbadkCoreApplication.getInst().getContext().getPackageManager().getApplicationInfo(TbadkCoreApplication.getInst().getContext().getPackageName(), 128);
                TbConfig.setVersionType(b.e(String.valueOf(applicationInfo.metaData.get("versionType")), 3));
            } catch (Exception e2) {
                TbConfig.setVersionType(3);
                BdLog.e(e2.getMessage());
            }
            try {
                if (TbConfig.getVersionType() == 2) {
                    if (applicationInfo != null) {
                        TbConfig.setVersion(String.valueOf(applicationInfo.metaData.get("grayVersion")));
                        return;
                    }
                    return;
                }
                TbConfig.setVersion(TbadkCoreApplication.getInst().getContext().getPackageManager().getPackageInfo(TbadkCoreApplication.getInst().getContext().getPackageName(), 0).versionName);
                if (TbConfig.getVersionType() != 1 || applicationInfo == null) {
                    return;
                }
                TbConfig.setSubVersion(String.valueOf(applicationInfo.metaData.get("subVersion")));
            } catch (Exception e3) {
                BdLog.e(e3.getMessage());
            }
        }
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public void execute() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            initVersion();
        }
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "AppCreate_InitVersion" : (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public int getProcess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return -1;
        }
        return invokeV.intValue;
    }
}
