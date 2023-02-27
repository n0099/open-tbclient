package com.baidu.searchbox.download.center.clearcache.controller;

import android.text.TextUtils;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.config.DefaultSharedPrefsWrapper;
import com.baidu.searchbox.download.center.clearcache.ClearCacheDataChangeEvent;
import com.baidu.searchbox.download.center.clearcache.ClearCacheRuntime;
import com.baidu.searchbox.download.center.clearcache.util.ClearCacheUtils;
/* loaded from: classes2.dex */
public class ClearCacheTips {
    public static final String CLEAR_CACHE_TIPS_KEY = "clear_cache_tips_key";

    public static String buildTips(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str;
    }

    public static void notifyTips(long j) {
        ClearCacheUtils.markDoneClearJob();
        DefaultSharedPrefsWrapper.getInstance().putString(CLEAR_CACHE_TIPS_KEY, buildTips(ClearCacheUtils.formatSize(j)));
        ClearCacheRuntime.getClearCacheContext().notifyPersonalClearCacheTipsChange();
        BdEventBus.Companion.getDefault().post(new ClearCacheDataChangeEvent());
    }
}
