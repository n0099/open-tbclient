package com.baidu.android.bdutil.cuid.sdk;
/* loaded from: classes2.dex */
public class AppCuidManager {
    public static AppCuidManager sAppCuidManager;

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
