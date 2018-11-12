package com.baidu.searchbox.bdmapsdk.data;

import com.baidu.searchbox.ng.ai.apps.storage.AiAppSharedPrefsWrapper;
/* loaded from: classes4.dex */
public final class BdMapLibSpHelper extends AiAppSharedPrefsWrapper {
    public static final String BDMAP_SP_NAME = "searchbox_bdmap_sp";
    private static BdMapLibSpHelper sInstance;

    public BdMapLibSpHelper() {
        super(BDMAP_SP_NAME);
    }

    public static BdMapLibSpHelper getsInstance() {
        if (sInstance == null) {
            synchronized (BdMapLibSpHelper.class) {
                if (sInstance == null) {
                    sInstance = new BdMapLibSpHelper();
                }
            }
        }
        return sInstance;
    }
}
