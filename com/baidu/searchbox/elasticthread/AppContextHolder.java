package com.baidu.searchbox.elasticthread;

import android.content.Context;
/* loaded from: classes3.dex */
public class AppContextHolder {
    private static Context sAppContext;

    public static void setAppContext(Context context) {
        sAppContext = context.getApplicationContext();
    }

    public static Context getAppContext() {
        return sAppContext;
    }
}
