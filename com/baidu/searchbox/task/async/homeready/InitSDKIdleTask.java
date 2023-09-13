package com.baidu.searchbox.task.async.homeready;

import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tieba.k30;
/* loaded from: classes4.dex */
public class InitSDKIdleTask extends LaunchTask {
    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public String getName() {
        return "Ignore_InitIdleSDK";
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public int getProcess() {
        return -1;
    }

    private void initAxeSdk() {
        if (!PermissionUtil.isAgreePrivacyPolicy()) {
            return;
        }
        k30.b.c(TbadkCoreApplication.getInst()).b().t();
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public void execute() {
        initAxeSdk();
    }
}
