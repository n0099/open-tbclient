package com.baidu.searchbox.task.sync.appcreate;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tieba.xp5;
/* loaded from: classes4.dex */
public class InitSdkNpsPluginTask extends LaunchTask {
    public static final String TAG = "InitSdkNpsPluginTask";

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public String getName() {
        return TAG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initSdkCodePlugin() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921823, new xp5() { // from class: com.baidu.searchbox.task.sync.appcreate.InitSdkNpsPluginTask.2
            @Override // com.baidu.tieba.xp5
            public void onFail() {
            }

            @Override // com.baidu.tieba.xp5
            public void onSuccess() {
            }
        }));
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public void execute() {
        if (PermissionUtil.isBrowseMode()) {
            initSdkCodePlugin();
        } else if (BdUtilHelper.getNumActivities() > 1) {
            SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.searchbox.task.sync.appcreate.InitSdkNpsPluginTask.1
                @Override // java.lang.Runnable
                public void run() {
                    InitSdkNpsPluginTask.this.initSdkCodePlugin();
                }
            }, 20000L);
        } else {
            initSdkCodePlugin();
        }
    }
}
