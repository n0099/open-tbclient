package com.baidu.searchbox.preload;

import com.baidu.searchbox.launch.ScheduleStrategy;
import com.baidu.searchbox.util.ChannelInitHelper;
import com.baidu.searchbox.util.VersionInitHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.vk6;
/* loaded from: classes2.dex */
public class AppRuntimePreloader {
    public static void preload(boolean z) {
        if (!z) {
            return;
        }
        vk6.a(new Runnable() { // from class: com.baidu.searchbox.preload.AppRuntimePreloader.1
            @Override // java.lang.Runnable
            public void run() {
                VersionInitHelper.init();
                TbadkCoreApplication.setClientId(TbadkCoreApplication.getInst().readClientId(TbadkCoreApplication.getInst().getContext()));
                ChannelInitHelper.init();
                ScheduleStrategy.getDeviceScore();
            }
        }, "AppRuntimePreloader", 0);
    }
}
