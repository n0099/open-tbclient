package com.baidu.searchbox.task.view.appcreate;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mainTab.MaintabBottomIndicator;
import com.baidu.tieba.R;
import com.baidu.tieba.bo5;
import com.baidu.tieba.p08;
/* loaded from: classes4.dex */
public class InitBottomIndicatorView2Task extends LaunchTask {
    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public String getName() {
        return "InitBottomIndicatorView2";
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public int getProcess() {
        return 1;
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public void execute() {
        try {
            bo5.e().a(1004, (MaintabBottomIndicator) LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(R.layout.maintab_bottom_indicator, (ViewGroup) null));
            bo5.e().a(1005, (MaintabBottomIndicator) LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(R.layout.maintab_bottom_indicator, (ViewGroup) null));
            bo5.e().a(1012, new p08(TbadkCoreApplication.getInst()));
        } catch (Exception e) {
            BdLog.e(e);
        }
    }
}
