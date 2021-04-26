package com.baidu.searchbox.config;

import com.baidu.android.util.KVStorageFactory;
import com.baidu.android.util.sp.SharedPrefsWrapper;
/* loaded from: classes2.dex */
public class QuickPersistConfig extends SharedPrefsWrapper {
    public static final String SP_FILE_STARTUP = "app_quick_config";

    /* loaded from: classes2.dex */
    public static final class Holder {
        public static final QuickPersistConfig INSTANCE = new QuickPersistConfig();
    }

    public static QuickPersistConfig getInstance() {
        return Holder.INSTANCE;
    }

    public QuickPersistConfig() {
        super(KVStorageFactory.getSharedPreferences(SP_FILE_STARTUP));
    }
}
