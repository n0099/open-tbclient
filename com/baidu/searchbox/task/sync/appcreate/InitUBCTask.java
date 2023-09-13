package com.baidu.searchbox.task.sync.appcreate;

import com.baidu.common.config.AppIdentityManager;
import com.baidu.searchbox.cloudcontrol.CloudControlManager;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tieba.qbb;
import com.baidu.tieba.qk1;
import com.baidu.tieba.y8b;
/* loaded from: classes4.dex */
public class InitUBCTask extends LaunchTask {
    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public String getName() {
        return "Ignore_InitUBCTask";
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public int getProcess() {
        return -1;
    }

    private void initUBC() {
        if (!PermissionUtil.isAgreePrivacyPolicy()) {
            return;
        }
        AppIdentityManager.getInstance().setAppName("tieba");
        if (qk1.g()) {
            qbb.a();
            CloudControlManager.getInstance().requestCloudControl("0");
        }
        y8b.a();
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public void execute() {
        initUBC();
    }
}
