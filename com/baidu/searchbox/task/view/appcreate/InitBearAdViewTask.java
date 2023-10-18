package com.baidu.searchbox.task.view.appcreate;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.li5;
/* loaded from: classes4.dex */
public class InitBearAdViewTask extends LaunchTask {
    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public String getName() {
        return "InitBearAdView";
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public int getProcess() {
        return 1;
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public void execute() {
        try {
            li5.e().a(1007, (ViewGroup) LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(R.layout.obfuscated_res_0x7f0d08e8, (ViewGroup) null, false));
        } catch (Exception e) {
            BdLog.e(e);
        }
    }
}
