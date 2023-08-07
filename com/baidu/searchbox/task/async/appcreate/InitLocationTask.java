package com.baidu.searchbox.task.async.appcreate;

import com.baidu.adp.lib.lbs.BdLocationMananger;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.PermissionUtil;
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
            BdLocationMananger.getInstance().initial();
            if (PermissionUtil.checkLocationForGoogle(TbadkCoreApplication.getInst())) {
                BdLocationMananger.getInstance().getAddress(false);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
