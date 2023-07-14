package com.baidu.searchbox.task.sync.appcreate;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tieba.fx5;
import com.baidu.tieba.ux7;
import com.baidu.tieba.yi;
import com.baidu.tieba.zu6;
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
        boolean q = fx5.q();
        SpeedStatsManager.getInstance().setIsNeedBear(q);
        SpeedStatsManager.getInstance().setIsNeedPlg(fx5.w());
        if (q) {
            ux7.m().u(new ux7.k() { // from class: com.baidu.searchbox.task.sync.appcreate.InitBearTask.1
                @Override // com.baidu.tieba.ux7.k
                public void initComplete() {
                    if (PermissionUtil.isAgreePrivacyPolicy()) {
                        if (yi.F()) {
                            zu6.a(new Runnable() { // from class: com.baidu.searchbox.task.sync.appcreate.InitBearTask.1.1
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
