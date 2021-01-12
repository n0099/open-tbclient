package com.baidu.android.bdutil.cuid.sdk;
/* loaded from: classes6.dex */
public class AppCuidManager {
    private static AppCuidManager sAppCuidManager;

    private AppCuidManager() {
    }

    public static AppCuidManager getInstance() {
        if (sAppCuidManager == null) {
            synchronized (AppCuidManager.class) {
                if (sAppCuidManager == null) {
                    sAppCuidManager = new AppCuidManager();
                }
            }
        }
        return sAppCuidManager;
    }

    public String getCuid() {
        return AppCuidRuntime.getAppCuidManager().getCuid();
    }

    public String getEnCuid() {
        return AppCuidRuntime.getAppCuidManager().getEnCuid();
    }
}
