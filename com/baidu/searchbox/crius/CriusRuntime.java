package com.baidu.searchbox.crius;

import android.content.Context;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
/* loaded from: classes2.dex */
public class CriusRuntime {
    public static final boolean DEBUG = AppConfig.isDebug();

    public static Context context() {
        return AppRuntime.getAppContext();
    }
}
