package com.baidu.searchbox.task.sync.privacy;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.a95;
import com.baidu.tieba.q05;
/* loaded from: classes4.dex */
public class SyncAccountTask extends LaunchTask {
    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public String getName() {
        return "Ignore_SyncAccountTask";
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public int getProcess() {
        return 1;
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public void execute() {
        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            a95.a(DI.ACCOUNT, -1L, 0, "logo_activity_uninit_account", 0, "", new Object[0]);
            if (!TbadkCoreApplication.getInst().getDatabasePath(TbConfig.PHONE_DATEBASE_NAME).exists()) {
                a95.a(DI.ACCOUNT, -1L, 0, "logo_activity_sync_account", 0, "", new Object[0]);
                TbadkCoreApplication.setCurrentAccount(q05.e(), TbadkCoreApplication.getInst());
            }
        }
    }
}
