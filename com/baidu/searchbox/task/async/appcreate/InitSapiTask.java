package com.baidu.searchbox.task.async.appcreate;

import com.baidu.adp.framework.MessageManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.tbadk.core.util.PermissionUtil;
/* loaded from: classes2.dex */
public class InitSapiTask extends LaunchTask {
    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public String getName() {
        return "initSapi";
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public int getProcess() {
        return -1;
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public void execute() {
        initSapi();
    }

    public void initSapi() {
        if (!PermissionUtil.isAgreePrivacyPolicy()) {
            return;
        }
        MessageManager.getInstance().runTask(2921328, null, AppRuntime.getAppContext());
    }
}
