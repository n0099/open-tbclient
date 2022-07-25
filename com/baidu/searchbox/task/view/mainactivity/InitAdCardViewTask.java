package com.baidu.searchbox.task.view.mainactivity;

import android.app.Activity;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.searchbox.pms.bean.PackageInfo;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.recapp.lego.view.AdCardMultiPicView;
import com.baidu.tieba.recapp.lego.view.AdCardSinglePicView;
import com.baidu.tieba.recapp.lego.view.AdCardVideoView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.t55;
/* loaded from: classes2.dex */
public class InitAdCardViewTask extends LaunchTask {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public InitAdCardViewTask() {
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
            Activity mainActivity = TbadkCoreApplication.getInst().getMainActivity();
            TbPageContext<BaseFragmentActivity> pageContext = mainActivity instanceof BaseFragmentActivity ? ((BaseFragmentActivity) mainActivity).getPageContext() : null;
            if (pageContext == null) {
                return;
            }
            try {
                AdCardSinglePicView adCardSinglePicView = new AdCardSinglePicView(pageContext);
                adCardSinglePicView.X();
                t55.e().a(1101, adCardSinglePicView);
            } catch (Exception e) {
                BdLog.e(e);
            }
            try {
                AdCardMultiPicView adCardMultiPicView = new AdCardMultiPicView(pageContext);
                adCardMultiPicView.X();
                t55.e().a(1102, adCardMultiPicView);
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            try {
                AdCardVideoView adCardVideoView = new AdCardVideoView(pageContext, 2);
                adCardVideoView.X();
                t55.e().a(PackageInfo.CODE_HOST_VERSION, adCardVideoView);
            } catch (Exception e3) {
                BdLog.e(e3);
            }
        }
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "InitAdCardView" : (String) invokeV.objValue;
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
