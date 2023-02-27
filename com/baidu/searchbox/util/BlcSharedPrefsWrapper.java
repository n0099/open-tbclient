package com.baidu.searchbox.util;

import com.baidu.android.util.KVStorageFactory;
import com.baidu.android.util.sp.SharedPrefsWrapper;
/* loaded from: classes3.dex */
public class BlcSharedPrefsWrapper extends SharedPrefsWrapper {
    public static final String SP_FILE_DEFAULT = "c3_aid_sp";

    /* loaded from: classes3.dex */
    public static class Holder {
        public static final BlcSharedPrefsWrapper INSTANCE = new BlcSharedPrefsWrapper();
    }

    public BlcSharedPrefsWrapper() {
        super(KVStorageFactory.getSharedPreferences(SP_FILE_DEFAULT));
    }

    public static BlcSharedPrefsWrapper getInstance() {
        return Holder.INSTANCE;
    }
}
