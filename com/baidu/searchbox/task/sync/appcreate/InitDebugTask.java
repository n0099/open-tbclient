package com.baidu.searchbox.task.sync.appcreate;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.BuildPackageInfo;
import com.baidu.tieba.s9;
import com.baidu.tieba.tu4;
import com.baidu.tieba.y70;
import com.baidu.tieba.ys4;
import com.baidu.tieba.zs4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class InitDebugTask extends LaunchTask {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public InitDebugTask() {
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

    private void initCmdConvertManager() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65537, this) == null) && TbadkCoreApplication.getInst().isDebugMode()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(zs4.class.getName());
            arrayList.add(ys4.class.getName());
            arrayList.add(CmdConfigHttp.class.getName());
            s9.a().c(arrayList);
        }
    }

    private void initLeakCanary() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, this) == null) && TbadkCoreApplication.getInst().isDebugMode()) {
            String cuid = TbadkCoreApplication.getInst().getCuid();
            TbadkCoreApplication inst = TbadkCoreApplication.getInst();
            String branchNameFromFile = BuildPackageInfo.getBranchNameFromFile(TbadkCoreApplication.getInst());
            String commitIdFromFile = BuildPackageInfo.getCommitIdFromFile(TbadkCoreApplication.getInst());
            if (TextUtils.isEmpty(cuid)) {
                cuid = "";
            }
            y70.a(inst, branchNameFromFile, commitIdFromFile, cuid);
        }
    }

    private void initUETool() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65539, this) == null) && TbadkCoreApplication.getInst().isDebugMode() && TbadkCoreApplication.getInst().isMainProcess(false) && tu4.k().h("key_ue_tool_switch", false)) {
            MessageManager.getInstance().runTask(2921513, null, null);
        }
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public void execute() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            initCmdConvertManager();
            initUETool();
            initLeakCanary();
        }
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "AppCreate_InitDebug" : (String) invokeV.objValue;
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
