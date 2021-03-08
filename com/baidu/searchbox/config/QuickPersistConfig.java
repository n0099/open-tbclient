package com.baidu.searchbox.config;

import com.baidu.android.util.sp.SharedPrefsWrapper;
/* loaded from: classes5.dex */
public class QuickPersistConfig extends SharedPrefsWrapper {
    public static final String SP_FILE_STARTUP = "app_quick_config";

    private QuickPersistConfig() {
        super(SP_FILE_STARTUP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class Holder {
        private static final QuickPersistConfig INSTANCE = new QuickPersistConfig();

        private Holder() {
        }
    }

    public static QuickPersistConfig getInstance() {
        return Holder.INSTANCE;
    }
}
