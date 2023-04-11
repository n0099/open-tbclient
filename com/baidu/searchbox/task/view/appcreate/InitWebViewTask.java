package com.baidu.searchbox.task.view.appcreate;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.bc6;
import com.baidu.tieba.w1b;
/* loaded from: classes2.dex */
public class InitWebViewTask extends LaunchTask {
    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public String getName() {
        return "InitWebViewTask";
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public int getProcess() {
        return 1;
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public void execute() {
        try {
            bc6 bc6Var = new bc6();
            bc6Var.i(TbadkCoreApplication.getInst().isDebugMode());
            bc6.e(new w1b<String>() { // from class: com.baidu.searchbox.task.view.appcreate.InitWebViewTask.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tieba.w1b
                public String call() {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(" tieba/");
                    stringBuffer.append(TbConfig.getVersion());
                    stringBuffer.append(" skin/");
                    stringBuffer.append(SkinManager.getCurrentSkinTypeString());
                    return stringBuffer.toString();
                }
            });
            bc6.c(TbadkCoreApplication.getInst(), bc6Var);
        } catch (Exception e) {
            BdLog.e(e);
        }
    }
}
