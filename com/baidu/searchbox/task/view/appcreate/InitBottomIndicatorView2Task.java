package com.baidu.searchbox.task.view.appcreate;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mainTab.MaintabBottomIndicator;
import com.baidu.tieba.R;
import com.baidu.tieba.bc7;
import com.baidu.tieba.tf5;
/* loaded from: classes2.dex */
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
            tf5.e().a(1004, (MaintabBottomIndicator) LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(R.layout.maintab_bottom_indicator, (ViewGroup) null));
            tf5.e().a(1005, (MaintabBottomIndicator) LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(R.layout.maintab_bottom_indicator, (ViewGroup) null));
            tf5.e().a(1012, new bc7(TbadkCoreApplication.getInst()));
        } catch (Exception e) {
            BdLog.e(e);
        }
    }
}
