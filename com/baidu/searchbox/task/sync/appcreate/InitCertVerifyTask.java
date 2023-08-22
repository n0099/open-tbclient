package com.baidu.searchbox.task.sync.appcreate;

import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CertVerifyHelper;
import com.baidu.tieba.bx5;
import com.baidu.tieba.fx5;
import com.baidu.tieba.gw5;
/* loaded from: classes4.dex */
public class InitCertVerifyTask extends LaunchTask {
    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public String getName() {
        return "Ignore_InitCertVerify";
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public int getProcess() {
        return -1;
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public void execute() {
        if (!TbadkCoreApplication.getInst().isDebugMode() && TbConfig.IS_CHECK_OFFICAL_APPLICATION) {
            fx5.b(new bx5<Boolean>() { // from class: com.baidu.searchbox.task.sync.appcreate.InitCertVerifyTask.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tieba.bx5
                public Boolean doInBackground() {
                    return Boolean.valueOf(CertVerifyHelper.isOfficial(TbadkCoreApplication.getInst()));
                }
            }, new gw5<Boolean>() { // from class: com.baidu.searchbox.task.sync.appcreate.InitCertVerifyTask.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tieba.gw5
                public void onReturnDataInUI(Boolean bool) {
                    if (bool != null) {
                        TbadkCoreApplication.getInst().mIsOfficial = bool.booleanValue();
                    }
                }
            });
        }
    }
}
