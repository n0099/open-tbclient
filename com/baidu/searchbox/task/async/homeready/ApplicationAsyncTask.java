package com.baidu.searchbox.task.async.homeready;

import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.switchs.ImageChangeCacheKeySwitch;
import com.baidu.tieba.jt5;
import com.baidu.tieba.rg;
/* loaded from: classes4.dex */
public class ApplicationAsyncTask extends LaunchTask {
    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public String getName() {
        return "Ignore_initAppAsync";
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public int getProcess() {
        return 1;
    }

    private void initAppAsync() {
        trackPushSwitchOpen();
    }

    private void trackPushSwitchOpen() {
        if (jt5.a(TbadkCoreApplication.getInst())) {
            TiebaStatic.log(new StatisticItem("c13616").param("obj_type", 1));
        } else {
            TiebaStatic.log(new StatisticItem("c13616").param("obj_type", 2));
        }
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public void execute() {
        initAppAsync();
        rg.h().q(ImageChangeCacheKeySwitch.isOn());
    }
}
