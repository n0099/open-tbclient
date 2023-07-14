package com.baidu.searchbox.taskmanager;

import com.baidu.searchbox.launch.IdleLaunchTask;
import com.baidu.searchbox.launch.SmartLaunchScheduler;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class IdleTaskRegister {
    public final Map<String, IdleLaunchTask> mTaskMap = new HashMap();

    public void registerIdleTask(String str, final Runnable runnable) {
        this.mTaskMap.put(str, new IdleLaunchTask(str) { // from class: com.baidu.searchbox.taskmanager.IdleTaskRegister.1
            @Override // com.baidu.searchbox.launch.SmartLaunchTask
            public void execute() {
                runnable.run();
            }
        });
    }

    public void removeRunnable(String str) {
        if (this.mTaskMap.containsKey(str)) {
            this.mTaskMap.remove(str);
        }
    }

    public void scheduleIdleTask(boolean z) {
        for (Map.Entry<String, IdleLaunchTask> entry : this.mTaskMap.entrySet()) {
            entry.getKey();
            IdleLaunchTask value = entry.getValue();
            if (z) {
                SmartLaunchScheduler.getInstance().register(value);
            } else if (!value.isExecuted()) {
                value.run();
            }
        }
        if (!z) {
            this.mTaskMap.clear();
        }
    }
}
