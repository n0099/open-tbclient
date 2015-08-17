package com.baidu.searchbox.plugin.api;
/* loaded from: classes.dex */
public final class PluginCacheManager {
    public static final boolean DEBUG = true;
    public static final String IMPL_CLASS_NAME = ".PluginCacheManager";
    public static final String TAG = "PluginCacheManager";

    /* loaded from: classes.dex */
    public interface PluginCacheResult {
        void onResult(byte[] bArr);
    }

    private PluginCacheManager() {
    }

    public static byte[] getCache(String str, String str2) {
        return null;
    }

    public static void getCacheResult(String str, String str2, PluginCacheResult pluginCacheResult) {
    }

    public static boolean saveCache(String str, String str2, byte[] bArr) {
        return saveCache(str, str2, false, bArr);
    }

    public static boolean saveCache(String str, String str2, boolean z, byte[] bArr) {
        return false;
    }

    private static void saveFile(String str, String str2, boolean z, byte[] bArr) {
    }

    public static boolean removeCache(String str, String str2) {
        return false;
    }

    private static int getPluginMaxCacheValue(String str) {
        return 0;
    }

    public static boolean clearAll(String str) {
        return false;
    }
}
