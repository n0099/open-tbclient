package com.baidu.searchbox.task.async.homeready;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
/* loaded from: classes4.dex */
public class InitMaintabFragmentTask extends LaunchTask {
    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public String getName() {
        return "InitMaintabFragment";
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public int getProcess() {
        return 1;
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public void execute() {
        MessageManager.getInstance().registerStickyMode(2921616);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921616));
    }
}
