package com.baidu.searchbox.task.sync.appcreate;

import android.os.Looper;
import android.os.MessageQueue;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.switchs.FixNpsAnrSwitch;
import com.baidu.tieba.mu5;
import com.baidu.tieba.yi;
import com.baidu.tieba.zg;
/* loaded from: classes4.dex */
public class InitFlutterNpsPluginTask extends LaunchTask {
    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public String getName() {
        return "InitFlutterNpsPlugin";
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public void execute() {
        if (PermissionUtil.isBrowseMode()) {
            initFlutterPlugin();
        } else if (FixNpsAnrSwitch.getIsOn() && yi.r() > 1) {
            zg.a().postDelayed(new Runnable() { // from class: com.baidu.searchbox.task.sync.appcreate.InitFlutterNpsPluginTask.1
                @Override // java.lang.Runnable
                public void run() {
                    InitFlutterNpsPluginTask.this.initFlutterPlugin();
                }
            }, 20000L);
        } else {
            initFlutterPlugin();
        }
    }

    public void initFlutterPlugin() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921674, new mu5() { // from class: com.baidu.searchbox.task.sync.appcreate.InitFlutterNpsPluginTask.2
            @Override // com.baidu.tieba.mu5
            public void onFail() {
            }

            @Override // com.baidu.tieba.mu5
            public void onSuccess() {
                zg.a().postDelayed(new Runnable() { // from class: com.baidu.searchbox.task.sync.appcreate.InitFlutterNpsPluginTask.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.baidu.searchbox.task.sync.appcreate.InitFlutterNpsPluginTask.2.1.1
                            @Override // android.os.MessageQueue.IdleHandler
                            public boolean queueIdle() {
                                MessageManager.getInstance().runTask(2921735, null, null);
                                return false;
                            }
                        });
                    }
                }, 10000L);
            }
        }));
    }
}
