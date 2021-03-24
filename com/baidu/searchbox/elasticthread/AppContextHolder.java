package com.baidu.searchbox.elasticthread;

import android.content.Context;
/* loaded from: classes.dex */
public class AppContextHolder {
    public static Context sAppContext;

    public static Context getAppContext() {
        return sAppContext;
    }

    public static void setAppContext(Context context) {
        sAppContext = context.getApplicationContext();
    }
}
