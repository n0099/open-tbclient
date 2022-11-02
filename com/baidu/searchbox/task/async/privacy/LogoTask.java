package com.baidu.searchbox.task.async.privacy;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.appsearchlib.NASLib;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.da;
import com.baidu.tieba.ky4;
import com.baidu.tieba.ue5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class LogoTask extends LaunchTask {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mIsFirstUse;

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "LogoTask" : (String) invokeV.objValue;
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

    public LogoTask() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mIsFirstUse = TbadkCoreApplication.getInst().getIsFirstUse();
    }

    private void startSwitchDebugService() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2000996, new da(TbadkCoreApplication.getInst())));
        }
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public void execute() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            TbadkCoreApplication.getInst().initTrackConfig();
            TbadkCoreApplication.getInst().onLowMemory();
            if (!TbadkCoreApplication.isLogin()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005015, null));
            }
            HashMap hashMap = new HashMap();
            hashMap.put("type", "start");
            hashMap.put("uname", TbadkCoreApplication.getCurrentAccountName());
            hashMap.put("uid", TbadkCoreApplication.getCurrentAccount());
            MessageManager.getInstance().sendMessageFromBackground(new CustomMessage(2006002, hashMap));
            if (MessageManager.getInstance().findTask(2010002) != null) {
                startSwitchDebugService();
            }
            if (!FileHelper.checkSD()) {
                TiebaStatic.file("no SD", "LogoActivity.onCreate");
            }
            if (MessageManager.getInstance().findTask(2001345) != null) {
                MessageManager.getInstance().sendMessageFromBackground(new CustomMessage(2001345, new IntentConfig(TbadkCoreApplication.getInst())));
            }
            if (this.mIsFirstUse) {
                TbadkSettings.getInst().saveBoolean("first_sync_image_quality", true);
                TbadkCoreApplication.getInst().setIsAbstractOn(0);
                ky4.k().u("frs_first_in", true);
            }
            if (TbSingleton.getInstance().isAuditPackageSwitchOn()) {
                NASLib.onAppStart(TbadkCoreApplication.getInst());
            }
            ue5.b().z(this.mIsFirstUse);
        }
    }
}
