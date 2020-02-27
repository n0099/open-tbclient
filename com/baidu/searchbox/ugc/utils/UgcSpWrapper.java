package com.baidu.searchbox.ugc.utils;

import com.baidu.android.util.sp.SharedPrefsWrapper;
/* loaded from: classes13.dex */
public final class UgcSpWrapper extends SharedPrefsWrapper {
    private static final String SP_FILE_DEFAULT = "ugc";

    private UgcSpWrapper() {
        super("ugc");
    }

    /* loaded from: classes13.dex */
    private static class Holder {
        private static final UgcSpWrapper INSTANCE = new UgcSpWrapper();

        private Holder() {
        }
    }

    public static UgcSpWrapper getInstance() {
        return Holder.INSTANCE;
    }
}
