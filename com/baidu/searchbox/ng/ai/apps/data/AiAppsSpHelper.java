package com.baidu.searchbox.ng.ai.apps.data;

import com.baidu.searchbox.ng.ai.apps.storage.AiAppSharedPrefsWrapper;
/* loaded from: classes2.dex */
public final class AiAppsSpHelper extends AiAppSharedPrefsWrapper {
    private static final String WEBAPPS_SP_NAME = "searchbox_webapps_sp";
    private static AiAppsSpHelper sInstance;

    public AiAppsSpHelper() {
        super(WEBAPPS_SP_NAME);
    }

    public static AiAppsSpHelper getsInstance() {
        if (sInstance == null) {
            synchronized (AiAppsSpHelper.class) {
                if (sInstance == null) {
                    sInstance = new AiAppsSpHelper();
                }
            }
        }
        return sInstance;
    }
}
