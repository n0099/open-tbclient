package com.baidu.live.adp.framework.settings;
/* loaded from: classes6.dex */
public class CustomTaskSetting extends TaskSetting {
    private static CustomTaskSetting sInstance = null;

    public static CustomTaskSetting getInstance() {
        if (sInstance == null) {
            synchronized (CustomTaskSetting.class) {
                if (sInstance == null) {
                    sInstance = new CustomTaskSetting();
                }
            }
        }
        return sInstance;
    }

    private CustomTaskSetting() {
    }
}
