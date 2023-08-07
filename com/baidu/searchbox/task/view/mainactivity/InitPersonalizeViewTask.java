package com.baidu.searchbox.task.view.mainactivity;

import android.app.Activity;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.homepage.personalize.PersonalizePageView;
import com.baidu.tieba.tm5;
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
            if (mainActivity != null && (personalizePageView = (PersonalizePageView) tm5.e().c(1011)) != null) {
                personalizePageView.E0(mainActivity);
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
    }
}
