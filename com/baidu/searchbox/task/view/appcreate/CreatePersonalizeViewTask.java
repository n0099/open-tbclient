package com.baidu.searchbox.task.view.appcreate;

import android.app.Activity;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.homepage.personalize.PersonalizePageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.b45;
/* loaded from: classes2.dex */
public class CreatePersonalizeViewTask extends LaunchTask {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public CreatePersonalizeViewTask() {
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

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public void execute() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                PersonalizePageView personalizePageView = new PersonalizePageView(TbadkCoreApplication.getInst());
                b45.e().a(1011, personalizePageView);
                Activity mainActivity = TbadkCoreApplication.getInst().getMainActivity();
                if (mainActivity == null) {
                    return;
                }
                personalizePageView.f0(mainActivity);
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "CreatePersonalizeView" : (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public int getProcess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }
}
