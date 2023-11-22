package com.baidu.searchbox.task.sync.appcreate;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tieba.br6;
import com.baidu.tieba.ks5;
import com.baidu.tieba.r58;
/* loaded from: classes4.dex */
public class InitBearTask extends LaunchTask {
    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public String getName() {
        return "AppCreate_InitBear";
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public int getProcess() {
        return 1;
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public void execute() {
        initBearSdk();
    }

    public void initBearSdk() {
        if (!TbadkCoreApplication.getInst().isMainProcess(false) || !PermissionUtil.isAgreePrivacyPolicy()) {
            return;
        }
        boolean p = ks5.p();
        SpeedStatsManager.getInstance().setIsNeedBear(p);
        SpeedStatsManager.getInstance().setIsNeedPlg(ks5.v());
        if (p) {
            r58.m().u(new r58.k() { // from class: com.baidu.searchbox.task.sync.appcreate.InitBearTask.1
                @Override // com.baidu.tieba.r58.k
                public void initComplete() {
                    if (PermissionUtil.isAgreePrivacyPolicy()) {
                        if (BdUtilHelper.isMainThread()) {
                            br6.a(new Runnable() { // from class: com.baidu.searchbox.task.sync.appcreate.InitBearTask.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.AD_PRELOAD_BEAR_START_STAMP_KEY);
                                    MessageManager.getInstance().runTask(new CustomMessage<>(2016571), (Class) null);
                                }
                            }, "initBear", 0);
                            return;
                        }
                        SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.AD_PRELOAD_BEAR_START_STAMP_KEY);
                        MessageManager.getInstance().runTask(new CustomMessage<>(2016571), (Class) null);
                    }
                }
            });
        }
    }
}
