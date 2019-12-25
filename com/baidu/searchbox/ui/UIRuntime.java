package com.baidu.searchbox.ui;

import android.content.Context;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes11.dex */
public class UIRuntime {
    public static final boolean GLOBAL_DEBUG = false;
    public static Context sAppContext = AppRuntime.getAppContext();

    public static Context getAppContext() {
        return sAppContext;
    }
}
