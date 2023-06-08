package com.baidu.searchbox.task.sync.appcreate;

import com.baidu.common.config.AppIdentityManager;
import com.baidu.searchbox.cloudcontrol.CloudControlManager;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.switchs.EnableYaLogSwitch;
import com.baidu.tieba.goa;
import com.baidu.tieba.hl1;
import com.baidu.tieba.ola;
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
        if (hl1.g()) {
            goa.a();
            CloudControlManager.getInstance().requestCloudControl("0");
        }
        if (EnableYaLogSwitch.isOn()) {
            ola.a();
        }
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public void execute() {
        initUBC();
    }
}
