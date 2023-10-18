package com.baidu.searchbox.task.sync.appcreate;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.BuildPackageInfo;
import com.baidu.tieba.j25;
import com.baidu.tieba.k25;
import com.baidu.tieba.u4;
import com.baidu.tieba.y40;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class InitDebugTask extends LaunchTask {
    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public String getName() {
        return "AppCreate_InitDebug";
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public int getProcess() {
        return -1;
    }

    private void initCmdConvertManager() {
        if (TbadkCoreApplication.getInst().isDebugMode()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(k25.class.getName());
            arrayList.add(j25.class.getName());
            arrayList.add(CmdConfigHttp.class.getName());
            u4.a().c(arrayList);
        }
    }

    private void initLeakCanary() {
        if (TbadkCoreApplication.getInst().isDebugMode()) {
            String cuid = TbadkCoreApplication.getInst().getCuid();
            TbadkCoreApplication inst = TbadkCoreApplication.getInst();
            String branchNameFromFile = BuildPackageInfo.getBranchNameFromFile(TbadkCoreApplication.getInst());
            String commitIdFromFile = BuildPackageInfo.getCommitIdFromFile(TbadkCoreApplication.getInst());
            if (TextUtils.isEmpty(cuid)) {
                cuid = "";
            }
            y40.a(inst, branchNameFromFile, commitIdFromFile, cuid);
        }
    }

    private void initUETool() {
        if (TbadkCoreApplication.getInst().isDebugMode() && TbadkCoreApplication.getInst().isMainProcess(false) && SharedPrefHelper.getInstance().getBoolean("key_ue_tool_switch", false)) {
            MessageManager.getInstance().runTask(2921513, null, null);
        }
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public void execute() {
        initCmdConvertManager();
        initUETool();
        initLeakCanary();
    }
}
