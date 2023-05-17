package com.baidu.searchbox.config.utils;

import com.baidu.android.util.UniKV;
import kotlin.Metadata;
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/baidu/searchbox/config/utils/FontSizeSharedPrefs;", "Lcom/baidu/android/util/UniKV;", "()V", "lib-fontsize_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FontSizeSharedPrefs extends UniKV {
    public static final FontSizeSharedPrefs INSTANCE = new FontSizeSharedPrefs();

    public FontSizeSharedPrefs() {
        super("app_quick_config");
    }
}
