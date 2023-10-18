package com.baidu.searchbox.task.async.appcreate;

import android.content.Context;
import com.baidu.browser.sailor.feature.upload.BdUploadHandler;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.tieba.fa0;
import com.baidu.tieba.pc5;
/* loaded from: classes4.dex */
public class InitArTask extends LaunchTask {
    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public String getName() {
        return "initAR";
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public int getProcess() {
        return -1;
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public void execute() {
        initAR(AppRuntime.getAppContext());
    }

    public static void initAR(Context context) {
        fa0.s(BdUploadHandler.MEDIA_SOURCE_KEY);
        fa0.k(context);
        fa0.v(false);
        pc5.a();
    }
}
