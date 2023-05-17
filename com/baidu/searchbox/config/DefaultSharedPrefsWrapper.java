package com.baidu.searchbox.config;

import com.baidu.android.util.sp.SharedPrefsWrapper;
/* loaded from: classes3.dex */
public final class DefaultSharedPrefsWrapper extends SharedPrefsWrapper {
    public static final String SP_FILE_DEFAULT = "default";

    /* loaded from: classes3.dex */
    public static class Holder {
        public static final DefaultSharedPrefsWrapper INSTANCE = new DefaultSharedPrefsWrapper();
    }

    public DefaultSharedPrefsWrapper() {
        super("default");
    }

    public static DefaultSharedPrefsWrapper getInstance() {
        return Holder.INSTANCE;
    }
}
