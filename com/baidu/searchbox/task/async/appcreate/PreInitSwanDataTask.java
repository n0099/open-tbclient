package com.baidu.searchbox.task.async.appcreate;

import android.util.Log;
import com.baidu.adp.framework.MessageManager;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
/* loaded from: classes4.dex */
public class PreInitSwanDataTask extends LaunchTask {
    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public String getName() {
        return "PreInitSwanData";
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public int getProcess() {
        return 1;
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public void execute() {
        try {
            MessageManager.getInstance().runTask(2921669, (Class) null);
        } catch (Throwable th) {
            Log.e(LaunchTask.TAG, "preLoadClass exception " + th.toString());
            th.printStackTrace();
        }
    }
}
