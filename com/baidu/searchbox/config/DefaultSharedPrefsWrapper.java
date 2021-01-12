package com.baidu.searchbox.config;

import com.baidu.android.util.sp.SharedPrefsWrapper;
/* loaded from: classes3.dex */
public final class DefaultSharedPrefsWrapper extends SharedPrefsWrapper {
    public static final String SP_FILE_DEFAULT = "default";

    private DefaultSharedPrefsWrapper() {
        super(SP_FILE_DEFAULT);
    }

    /* loaded from: classes3.dex */
    private static class Holder {
        private static final DefaultSharedPrefsWrapper INSTANCE = new DefaultSharedPrefsWrapper();

        private Holder() {
        }
    }

    public static DefaultSharedPrefsWrapper getInstance() {
        return Holder.INSTANCE;
    }
}
