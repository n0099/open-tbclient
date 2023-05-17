package com.baidu.searchbox.permission;

import android.content.Context;
import com.baidu.pyramid.annotation.Autowired;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
@Autowired
/* loaded from: classes3.dex */
public class DangerousPermissionRuntime {
    public static boolean GLOBAL_DEBUG = AppConfig.isDebug();
    public static Context sAppContext = AppRuntime.getAppContext();

    public static Context getAppContext() {
        return sAppContext;
    }
}
