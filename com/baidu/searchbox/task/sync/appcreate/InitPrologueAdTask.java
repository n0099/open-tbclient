package com.baidu.searchbox.task.sync.appcreate;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tieba.ar6;
/* loaded from: classes4.dex */
public class InitPrologueAdTask extends LaunchTask {
    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public String getName() {
        return "AppCreate_InitPrologueAd";
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public int getProcess() {
        return -1;
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public void execute() {
        try {
            Class.forName("com.baidu.tieba.funad.FunAdStatic");
            Class.forName("com.baidu.tieba.advert.sdk.AdvertSDKStatic");
        } catch (Exception e) {
            BdLog.i(e.getMessage());
        }
        if (PermissionUtil.isAgreePrivacyPolicy() && TbadkCoreApplication.getInst().isMainProcess(false)) {
            ar6.a(new Runnable() { // from class: com.baidu.searchbox.task.sync.appcreate.InitPrologueAdTask.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        MessageManager.getInstance().runTask(new CustomMessage<>(2016570), (Class) null);
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                }
            }, "initPrologue", 0);
        }
    }
}
