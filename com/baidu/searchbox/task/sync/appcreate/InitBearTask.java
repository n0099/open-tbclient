package com.baidu.searchbox.task.sync.appcreate;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tieba.ek7;
import com.baidu.tieba.ii;
import com.baidu.tieba.lp5;
import com.baidu.tieba.wk6;
/* loaded from: classes2.dex */
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
        boolean q = lp5.q();
        SpeedStatsManager.getInstance().setIsNeedBear(q);
        SpeedStatsManager.getInstance().setIsNeedPlg(lp5.w());
        if (q) {
            ek7.m().u(new ek7.l() { // from class: com.baidu.searchbox.task.sync.appcreate.InitBearTask.1
                @Override // com.baidu.tieba.ek7.l
                public void initComplete() {
                    if (PermissionUtil.isAgreePrivacyPolicy()) {
                        if (ii.E()) {
                            wk6.a(new Runnable() { // from class: com.baidu.searchbox.task.sync.appcreate.InitBearTask.1.1
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
