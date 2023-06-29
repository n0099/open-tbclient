package com.baidu.searchbox.task.async.appcreate;

import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tieba.rf;
/* loaded from: classes4.dex */
public class InitLocationTask extends LaunchTask {
    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public String getName() {
        return "Ignore_InitLocation";
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public int getProcess() {
        return -1;
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public void execute() {
        try {
            rf.n().q();
            if (PermissionUtil.checkLocationForGoogle(TbadkCoreApplication.getInst())) {
                rf.n().j(false);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
