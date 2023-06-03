package com.baidu.searchbox.download.lightdownload;

import com.baidu.android.util.sp.SharedPrefsWrapper;
/* loaded from: classes3.dex */
public final class LightFileCache extends SharedPrefsWrapper {
    public static final String SP_NAME = "light_download";

    /* loaded from: classes3.dex */
    public static final class Holder {
        public static final LightFileCache INSTANCE = new LightFileCache();
    }

    public LightFileCache() {
        super(SP_NAME);
    }

    public static LightFileCache getInstance() {
        return Holder.INSTANCE;
    }

    public LightFileCache(String str) {
        super(str);
    }

    public String getChecksumByUrl(String str) {
        return super.getString(str, "");
    }

    public void storeChecksumByUrl(String str, String str2) {
        super.putString(str, str2);
    }
}
