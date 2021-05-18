package com.baidu.searchbox.v8engine;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import com.baidu.searchbox.v8engine.V8EngineConfiguration;
import com.baidu.smallgame.sdk.Log;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class DiskCodeCacheManager {
    public static final String DISK_CODE_CACHE_DIR_NAME_PREFIX = "v8_codecache_";
    public static final String DISK_CODE_CACHE_INDEX_SUFFIX = "idx";
    public static final String DISK_CODE_CACHE_NAME_PREFIX = "v8_cache_";
    public static final String DISK_CODE_CACHE_PACKAGE_DEFAULT_NAME = "app_mario";
    public static final String OLD_DISK_CODE_CACHE_PACKAGE_MARIO_NAME = "app_mario";
    public static final String OLD_DISK_CODE_CACHE_PACKAGE_WEBVIEW_NAME = "app_webview_baidu";
    public static final String TAG = "DiskCodeCacheManager";

    public static boolean addDiskCodeCacheBusId(Map<String, String> map, File file) {
        boolean z;
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles(new FilenameFilter() { // from class: com.baidu.searchbox.v8engine.DiskCodeCacheManager.2
                @Override // java.io.FilenameFilter
                public boolean accept(File file2, String str) {
                    return str.startsWith(DiskCodeCacheManager.DISK_CODE_CACHE_NAME_PREFIX) || str.startsWith(DiskCodeCacheManager.DISK_CODE_CACHE_DIR_NAME_PREFIX);
                }
            });
            if (listFiles == null || listFiles.length <= 0) {
                z = true;
            } else {
                z = true;
                for (File file2 : listFiles) {
                    if (file2.isDirectory()) {
                        z = addDiskCodeCacheBusId(map, file2) && z;
                    }
                    String busIdByCodeCacheIndexFile = getBusIdByCodeCacheIndexFile(file2);
                    String parent = file.getParent();
                    if (!TextUtils.isEmpty(busIdByCodeCacheIndexFile) && !TextUtils.isEmpty(parent)) {
                        map.put(parent, busIdByCodeCacheIndexFile);
                    }
                }
            }
            return z && file.delete();
        }
        return false;
    }

    public static boolean clearAllOldDiskCodeCacheResources(Context context, final String str) {
        File[] listFiles;
        if (context != null && context.getApplicationInfo() != null) {
            File file = new File(context.getApplicationInfo().dataDir);
            if (file.exists() && (listFiles = file.listFiles(new FilenameFilter() { // from class: com.baidu.searchbox.v8engine.DiskCodeCacheManager.1
                @Override // java.io.FilenameFilter
                public boolean accept(File file2, String str2) {
                    return str2.startsWith(str);
                }
            })) != null && listFiles.length != 0) {
                HashMap hashMap = new HashMap();
                boolean z = true;
                for (File file2 : listFiles) {
                    z = addDiskCodeCacheBusId(hashMap, file2) && z;
                }
                for (Map.Entry entry : hashMap.entrySet()) {
                    z = nativeClearDiskCodeCache((String) entry.getKey(), (String) entry.getValue()) && z;
                }
                return z;
            }
        }
        return false;
    }

    public static boolean clearDiskCodeCache(String str, String str2) {
        return nativeClearDiskCodeCache(str, str2);
    }

    public static File createDiskCodeCacheDirectory(Context context, String str) {
        File file;
        if (context == null) {
            Log.w(TAG, "[CodeCache] Invoke createDiskCodeCacheDirectory failed. Context or ApplicationInfo is null.");
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            file = new File(context.getCacheDir(), "app_mario");
        } else {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (applicationInfo != null && !TextUtils.isEmpty(applicationInfo.dataDir)) {
                File file2 = new File(applicationInfo.dataDir, str);
                file = !(!file2.exists() ? file2.mkdirs() : true) ? new File(context.getCacheDir(), "app_mario") : file2;
            } else {
                Log.w(TAG, "[CodeCache] ApplicationInfo is null or ApplicationInfo.dataDir is empty");
                return null;
            }
        }
        if (!(file.exists() ? true : file.mkdirs())) {
            Log.w(TAG, "[CodeCache] Crate disk code cache failed.");
            return null;
        } else if (file.canWrite()) {
            return file;
        } else {
            Log.w(TAG, "[CodeCache] File diskCodeCachePathFile " + file.getName() + "can not be written.");
            return null;
        }
    }

    public static String getBusIdByCodeCacheIndexFile(File file) {
        int lastIndexOf;
        String name = file.getName();
        if (!TextUtils.isEmpty(name) && name.length() >= 1 && name.startsWith(DISK_CODE_CACHE_NAME_PREFIX) && (lastIndexOf = name.lastIndexOf(".")) >= 0 && name.substring(lastIndexOf + 1).equals(DISK_CODE_CACHE_INDEX_SUFFIX)) {
            return name.substring(9, lastIndexOf);
        }
        return null;
    }

    public static boolean isCodeCacheSettingValid(Context context, V8EngineConfiguration.CodeCacheSetting codeCacheSetting) {
        if (codeCacheSetting == null) {
            Log.w(TAG, "[CodeCache] Code cache setting is null");
            return false;
        } else if (context == null) {
            Log.w(TAG, "[CodeCache] SetCodeCacheSetting failed. Context is null");
            return false;
        } else if (codeCacheSetting.id == null || codeCacheSetting.pathList == null) {
            StringBuilder sb = new StringBuilder("[CodeCache] Invoke setCodeCacheSetting failed. ");
            if (codeCacheSetting.id == null) {
                sb.append("Id is null.");
            }
            ArrayList<String> arrayList = codeCacheSetting.pathList;
            if (arrayList == null || arrayList.size() == 0) {
                sb.append("PathList is null or empty");
            }
            Log.w(TAG, sb.toString());
            return false;
        } else {
            return true;
        }
    }

    public static native boolean nativeClearDiskCodeCache(String str, String str2);
}
