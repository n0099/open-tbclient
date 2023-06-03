package com.baidu.searchbox.task.sync.appcreate;

import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CertVerifyHelper;
import com.baidu.tieba.gx5;
import com.baidu.tieba.kw5;
import com.baidu.tieba.kx5;
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
            kx5.b(new gx5<Boolean>() { // from class: com.baidu.searchbox.task.sync.appcreate.InitCertVerifyTask.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tieba.gx5
                public Boolean doInBackground() {
                    return Boolean.valueOf(CertVerifyHelper.isOfficial(TbadkCoreApplication.getInst()));
                }
            }, new kw5<Boolean>() { // from class: com.baidu.searchbox.task.sync.appcreate.InitCertVerifyTask.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tieba.kw5
                public void onReturnDataInUI(Boolean bool) {
                    if (bool != null) {
                        TbadkCoreApplication.getInst().mIsOfficial = bool.booleanValue();
                    }
                }
            });
        }
    }
}
