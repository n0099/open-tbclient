package com.baidu.searchbox.task.async.appcreate;

import android.content.Context;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.tbadk.core.util.PermissionUtil;
/* loaded from: classes4.dex */
public class PermissionUtilTask extends LaunchTask {
    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public String getName() {
        return "Ignore_permissionUtil";
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public int getProcess() {
        return -1;
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public void execute() {
        init(AppRuntime.getAppContext());
    }

    private void init(Context context) {
        PermissionUtil.registerMutiProcessPrivacyPolicy();
    }
}
