package com.baidu.live.adp.framework.settings;
/* loaded from: classes11.dex */
public class CustomTaskSetting extends TaskSetting {
    private static volatile CustomTaskSetting sInstance = null;

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
