package com.baidu.searchbox.task.view.appcreate;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.we6;
import com.baidu.tieba.z7b;
/* loaded from: classes4.dex */
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
            we6 we6Var = new we6();
            we6Var.h(TbadkCoreApplication.getInst().isDebugMode());
            we6.e(new z7b<String>() { // from class: com.baidu.searchbox.task.view.appcreate.InitWebViewTask.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tieba.z7b
                public String call() {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(" tieba/");
                    stringBuffer.append(TbConfig.getVersion());
                    stringBuffer.append(" skin/");
                    stringBuffer.append(SkinManager.getCurrentSkinTypeString());
                    return stringBuffer.toString();
                }
            });
            we6.c(TbadkCoreApplication.getInst(), we6Var);
        } catch (Exception e) {
            BdLog.e(e);
        }
    }
}
