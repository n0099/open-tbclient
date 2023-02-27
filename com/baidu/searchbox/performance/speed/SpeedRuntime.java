package com.baidu.searchbox.performance.speed;

import android.content.Context;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
/* loaded from: classes2.dex */
public class SpeedRuntime {
    public static ISpeedContext instance;

    public static Context getAppContext() {
        return AppRuntime.getAppContext();
    }

    public static ISpeedContext getSpeedContext() {
        if (instance == null) {
            instance = (ISpeedContext) ServiceManager.getService(new ServiceReference("speed", "runtime"));
        }
        return instance;
    }

    public static boolean isDebug() {
        return AppConfig.isDebug();
    }
}
