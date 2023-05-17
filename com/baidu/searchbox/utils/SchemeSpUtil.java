package com.baidu.searchbox.utils;

import com.baidu.android.util.KVStorageFactory;
import com.baidu.android.util.sp.SharedPrefsWrapper;
/* loaded from: classes4.dex */
public class SchemeSpUtil extends SharedPrefsWrapper {
    public static final String SP_FILE_NAME = "com.baidu.searchbox_scheme";

    /* loaded from: classes4.dex */
    public static final class Holder {
        public static final SchemeSpUtil INSTANCE = new SchemeSpUtil();
    }

    public SchemeSpUtil() {
        super(KVStorageFactory.getSharedPreferences(SP_FILE_NAME));
    }

    public static SchemeSpUtil getInstance() {
        return Holder.INSTANCE;
    }
}
