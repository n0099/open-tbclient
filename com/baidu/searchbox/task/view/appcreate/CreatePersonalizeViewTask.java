package com.baidu.searchbox.task.view.appcreate;

import android.app.Activity;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.homepage.personalize.PersonalizePageView;
import com.baidu.tieba.mn5;
/* loaded from: classes4.dex */
public class CreatePersonalizeViewTask extends LaunchTask {
    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public String getName() {
        return "CreatePersonalizeView";
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public int getProcess() {
        return 1;
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public void execute() {
        try {
            PersonalizePageView personalizePageView = new PersonalizePageView(TbadkCoreApplication.getInst());
            mn5.e().a(1011, personalizePageView);
            Activity mainActivity = TbadkCoreApplication.getInst().getMainActivity();
            if (mainActivity == null) {
                return;
            }
            personalizePageView.i0(mainActivity);
        } catch (Exception e) {
            BdLog.e(e);
        }
    }
}
