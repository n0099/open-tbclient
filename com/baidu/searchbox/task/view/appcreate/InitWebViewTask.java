package com.baidu.searchbox.task.view.appcreate;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.fsa;
import com.baidu.tieba.va6;
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
            va6 va6Var = new va6();
            va6Var.i(TbadkCoreApplication.getInst().isDebugMode());
            va6.e(new fsa<String>() { // from class: com.baidu.searchbox.task.view.appcreate.InitWebViewTask.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tieba.fsa
                public String call() {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(" tieba/");
                    stringBuffer.append(TbConfig.getVersion());
                    stringBuffer.append(" skin/");
                    stringBuffer.append(SkinManager.getCurrentSkinTypeString());
                    return stringBuffer.toString();
                }
            });
            va6.c(TbadkCoreApplication.getInst(), va6Var);
        } catch (Exception e) {
            BdLog.e(e);
        }
    }
}
