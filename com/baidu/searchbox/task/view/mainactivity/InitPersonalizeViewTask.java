package com.baidu.searchbox.task.view.mainactivity;

import android.app.Activity;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.en5;
import com.baidu.tieba.homepage.personalize.PersonalizePageView;
/* loaded from: classes4.dex */
public class InitPersonalizeViewTask extends LaunchTask {
    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public String getName() {
        return "InitPersonalizeView";
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public int getProcess() {
        return 1;
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public void execute() {
        PersonalizePageView personalizePageView;
        try {
            Activity mainActivity = TbadkCoreApplication.getInst().getMainActivity();
            if (mainActivity != null && (personalizePageView = (PersonalizePageView) en5.e().c(1011)) != null) {
                personalizePageView.i0(mainActivity);
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
    }
}
