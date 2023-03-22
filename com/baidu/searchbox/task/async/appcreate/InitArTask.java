package com.baidu.searchbox.task.async.appcreate;

import android.content.Context;
import com.baidu.browser.sailor.feature.upload.BdUploadHandler;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.tieba.fb5;
import com.baidu.tieba.zd0;
/* loaded from: classes2.dex */
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
        zd0.r(BdUploadHandler.MEDIA_SOURCE_KEY);
        zd0.j(context);
        zd0.u(false);
        fb5.a();
    }
}
