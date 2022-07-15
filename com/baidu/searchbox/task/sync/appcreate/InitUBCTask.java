package com.baidu.searchbox.task.sync.appcreate;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.common.config.AppIdentityManager;
import com.baidu.searchbox.cloudcontrol.CloudControlManager;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.e29;
import com.repackage.sb1;
/* loaded from: classes2.dex */
public class InitUBCTask extends LaunchTask {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public InitUBCTask() {
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

    private void initUBC() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65537, this) == null) && PermissionUtil.isAgreePrivacyPolicy()) {
            AppIdentityManager.getInstance().setAppName("tieba");
            if (sb1.g()) {
                e29.a();
                CloudControlManager.getInstance().requestCloudControl("0");
            }
        }
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public void execute() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            initUBC();
        }
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "Ignore_InitUBCTask" : (String) invokeV.objValue;
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
