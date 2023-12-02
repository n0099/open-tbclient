package com.baidu.searchbox.task.view.appcreate;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mainTab.MaintabBottomIndicator;
import com.baidu.tieba.R;
import com.baidu.tieba.kk5;
/* loaded from: classes4.dex */
public class InitBottomIndicatorViewTask extends LaunchTask {
    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public String getName() {
        return "InitBottomIndicatorView";
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public int getProcess() {
        return 1;
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public void execute() {
        try {
            kk5.e().a(1001, (MaintabBottomIndicator) LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(R.layout.maintab_bottom_indicator, (ViewGroup) null));
            kk5.e().a(1002, (MaintabBottomIndicator) LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(R.layout.maintab_bottom_indicator, (ViewGroup) null));
        } catch (Exception e) {
            BdLog.e(e);
        }
    }
}
