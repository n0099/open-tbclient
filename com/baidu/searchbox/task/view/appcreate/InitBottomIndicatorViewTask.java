package com.baidu.searchbox.task.view.appcreate;

import android.widget.LinearLayout;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mainTab.MaintabBottomIndicator;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.g55;
/* loaded from: classes2.dex */
public class InitBottomIndicatorViewTask extends LaunchTask {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public InitBottomIndicatorViewTask() {
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
                MaintabBottomIndicator maintabBottomIndicator = new MaintabBottomIndicator(TbadkCoreApplication.getInst());
                maintabBottomIndicator.setLayoutParams(new LinearLayout.LayoutParams(0, -1, 1.0f));
                g55.e().a(1001, maintabBottomIndicator);
                MaintabBottomIndicator maintabBottomIndicator2 = new MaintabBottomIndicator(TbadkCoreApplication.getInst());
                maintabBottomIndicator2.setLayoutParams(new LinearLayout.LayoutParams(0, -1, 1.0f));
                g55.e().a(1002, maintabBottomIndicator2);
                MaintabBottomIndicator maintabBottomIndicator3 = new MaintabBottomIndicator(TbadkCoreApplication.getInst());
                maintabBottomIndicator3.setLayoutParams(new LinearLayout.LayoutParams(0, -1, 1.0f));
                g55.e().a(1003, maintabBottomIndicator3);
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "InitBottomIndicatorView" : (String) invokeV.objValue;
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
