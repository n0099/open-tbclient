package com.baidu.searchbox.preload;

import com.baidu.searchbox.launch.ScheduleStrategy;
import com.baidu.searchbox.util.ChannelInitHelper;
import com.baidu.searchbox.util.VersionInitHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes2.dex */
public class AppRuntimePreloader {
    public static void preload(boolean z) {
        if (!z) {
            return;
        }
        Thread thread = new Thread(new Runnable() { // from class: com.baidu.searchbox.preload.AppRuntimePreloader.1
            @Override // java.lang.Runnable
            public void run() {
                VersionInitHelper.init();
                TbadkCoreApplication.setClientId(TbadkCoreApplication.getInst().readClientId(TbadkCoreApplication.getInst().getContext()));
                ChannelInitHelper.init();
                ScheduleStrategy.getDeviceScore();
            }
        });
        thread.setPriority(10);
        thread.start();
    }
}
