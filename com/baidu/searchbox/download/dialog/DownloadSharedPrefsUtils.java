package com.baidu.searchbox.download.dialog;

import com.baidu.android.util.UniKV;
/* loaded from: classes3.dex */
public class DownloadSharedPrefsUtils extends UniKV {
    public static final String PREF_NAME = "com.baidu.searchbox.lib.download";

    /* loaded from: classes3.dex */
    public static class Holder {
        public static final DownloadSharedPrefsUtils INSTANCE = new DownloadSharedPrefsUtils();
    }

    public DownloadSharedPrefsUtils() {
        super(PREF_NAME);
    }

    public static final DownloadSharedPrefsUtils getInstance() {
        return Holder.INSTANCE;
    }
}
