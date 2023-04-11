package com.baidu.searchbox.task.async.appcreate;

import android.content.Context;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tieba.wh;
import com.baidu.tieba.xh;
/* loaded from: classes2.dex */
public class InitAbi64WebViewCompatTask extends LaunchTask {
    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public String getName() {
        return "Ignore_initAbi64WebViewCompat";
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public int getProcess() {
        return -1;
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public void execute() {
        init(AppRuntime.getAppContext());
    }

    public static void init(Context context) {
        if (TbadkSettings.getInst().isContains("key_last_running_in_64_bit")) {
            if (TbadkSettings.getInst().loadBoolean("key_last_running_in_64_bit", false) != xh.a()) {
                wh.b(context);
            }
        } else {
            wh.b(context);
        }
        TbadkSettings.getInst().saveBoolean("key_last_running_in_64_bit", xh.a());
    }
}
