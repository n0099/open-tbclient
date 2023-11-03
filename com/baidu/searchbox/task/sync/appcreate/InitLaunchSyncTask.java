package com.baidu.searchbox.task.sync.appcreate;

import androidx.lifecycle.ProcessLifecycleOwner;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.growthFunnel.GrowthAppLifecycleObserver;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.InputMethodManagerLeaksFixer;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.util.ForeBackLifecycleMonitorUtil;
import com.baidu.tieba.au5;
import com.baidu.tieba.eu5;
import com.baidu.tieba.kv4;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class InitLaunchSyncTask extends LaunchTask {
    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public String getName() {
        return "Ignore_InitLaunchSync";
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public int getProcess() {
        return -1;
    }

    private void cleanDirectoryNewStatIfNeed() {
        if (TbadkCoreApplication.getInst().isMainProcess(true) && TbadkCoreApplication.getInst().getIsFirstUse()) {
            eu5.b(new au5<Object>() { // from class: com.baidu.searchbox.task.sync.appcreate.InitLaunchSyncTask.2
                @Override // com.baidu.tieba.au5
                public Object doInBackground() {
                    if ("12.1.0.1".equals(FileHelper.DataDir.getLatestVersion())) {
                        FileHelper.DataDir.cleanDirectory("/newStat");
                        return null;
                    }
                    return null;
                }
            }, null);
        }
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public void execute() {
        if (TbadkCoreApplication.getInst().isMainProcess(false)) {
            ProcessLifecycleOwner.get().getLifecycle().addObserver(new GrowthAppLifecycleObserver());
            ProcessLifecycleOwner.get().getLifecycle().addObserver(new ForeBackLifecycleMonitorUtil());
            if (TbadkCoreApplication.getInst().getIsFirstUse()) {
                SwitchManager.getInstance().clear();
                if (!TbadkCoreApplication.getInst().getCapabilityOfWebp()) {
                    TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), "LocalWebpUnSupport", "");
                }
            }
        } else {
            TbadkCoreApplication.getInst().mRemoteActivity = new ArrayList<>();
        }
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            TbadkCoreApplication.getInst().sendMessageForEnterBackground();
        }
        NetMessage.setGlobalSwitchToHttpStrategy(new NetMessage.a() { // from class: com.baidu.searchbox.task.sync.appcreate.InitLaunchSyncTask.1
            @Override // com.baidu.adp.framework.message.NetMessage.a
            public boolean checkToSwitchHttp(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage != null) {
                    if (socketResponsedMessage.getError() == 110004 || socketResponsedMessage.getError() == 110005) {
                        return true;
                    }
                    return false;
                }
                return false;
            }
        });
        TbadkCoreApplication.getInst().registerActivityLifecycleCallbacks(new kv4());
        InputMethodManagerLeaksFixer.fixFocusedViewLeak(TbadkCoreApplication.getInst());
        cleanDirectoryNewStatIfNeed();
    }
}
