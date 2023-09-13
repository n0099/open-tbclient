package com.baidu.searchbox.task.async.appcreate;

import android.content.Context;
import com.baidu.browser.sailor.feature.upload.BdUploadHandler;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.tieba.fi5;
import com.baidu.tieba.jf0;
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
        jf0.r(BdUploadHandler.MEDIA_SOURCE_KEY);
        jf0.j(context);
        jf0.u(false);
        fi5.a();
    }
}
