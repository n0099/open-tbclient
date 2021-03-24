package com.baidu.android.util.io;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.io.File;
/* loaded from: classes2.dex */
public final class PathUtils {
    public static final boolean DEBUG = false;
    public static final String DIRCTORY_APP = "xxx";
    public static final String DIRCTORY_BAIDU = "baidu";
    public static final String DIRCTORY_BAIDU2 = "BaiduBox";
    public static final String DIRCTORY_DOWNLOAD = "downloads";
    public static final String DIRCTORY_IMAGE_CACHE_FOR_IMAGELOADER = "img_cache";
    public static final String DIRCTORY_IMAGE_CACHE_FOR_NUOMI_SDK = "img_cache_nuomi";
    public static final String DIRCTORY_IMAGE_CACHE_FOR_OTHER = "img_other";
    public static final String DIRECTORY_DATA_CACHE = "baidu/xxx";
    public static final String PATH_DEFAULT_DOWNLOAD = "baidu/xxx/downloads";
    public static final String PATH_DEFAULT_DOWNLOAD2 = "BaiduBox/downloads";
    public static final String TAG = "PathUtils";
    public static String sCacheDir;
    public static String sImageCacheDirBaseForFresco = getCacheDirectory(AppRuntime.getAppContext());
    public static String sImageCacheDirForImageloader = getImageCacheDirForImageLoader(AppRuntime.getAppContext());
    public static String sImageCacheDirForOther = getImageCacheDirForOthers(AppRuntime.getAppContext());

    @Deprecated
    public static boolean deleteDirectory(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            File file = new File(str);
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (File file2 : listFiles) {
                        file2.delete();
                    }
                }
                file.delete();
                return true;
            }
            return true;
        } catch (Exception unused) {
            return true;
        }
    }

    @Deprecated
    public static boolean deleteFile(File file) {
        try {
            String absolutePath = file.getAbsolutePath();
            File file2 = new File(absolutePath);
            long currentTimeMillis = System.currentTimeMillis();
            File file3 = new File(absolutePath + currentTimeMillis + ".tmp");
            file2.renameTo(file3);
            return file3.delete();
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Deprecated
    public static void deleteOldFiles(Context context) {
        if (TextUtils.equals("mounted", Environment.getExternalStorageState())) {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
            if (defaultSharedPreferences.getBoolean("key_path_utils_delete_old_file", false)) {
                return;
            }
            File file = new File(Environment.getExternalStorageDirectory(), ".696E5309-E4A7-27C0-A787-0B2CEBF1F1AB");
            if (file.exists()) {
                if (file.delete()) {
                    SharedPreferences.Editor edit = defaultSharedPreferences.edit();
                    edit.putBoolean("key_path_utils_delete_old_file", true);
                    edit.apply();
                    return;
                }
                return;
            }
            SharedPreferences.Editor edit2 = defaultSharedPreferences.edit();
            edit2.putBoolean("key_path_utils_delete_old_file", true);
            edit2.apply();
        }
    }

    @SuppressLint({"NewApi"})
    public static String getCacheDirectory(Context context) {
        if (!TextUtils.isEmpty(sCacheDir)) {
            return sCacheDir;
        }
        File file = null;
        try {
            file = context.getExternalCacheDir();
        } catch (Exception unused) {
        }
        if (file == null) {
            file = context.getCacheDir();
        }
        if (file == null) {
            file = context.getFilesDir();
        }
        if (file != null) {
            if (!file.exists()) {
                file.mkdirs();
            }
            sCacheDir = file.getAbsolutePath();
        }
        return sCacheDir;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static File getDownloadDirectory(Context context) {
        File externalFilesDir = context.getExternalFilesDir("downloads");
        if (externalFilesDir != null) {
            boolean z = false;
            if (externalFilesDir.exists()) {
                if (!externalFilesDir.isDirectory()) {
                    deleteFile(externalFilesDir);
                }
                if (z) {
                    externalFilesDir.mkdirs();
                }
            }
            z = true;
            if (z) {
            }
        }
        return externalFilesDir;
    }

    @Deprecated
    public static String getExternalStorageDir(Context context) {
        File externalStorageDirectory = isExternalStorageWritable() ? Environment.getExternalStorageDirectory() : null;
        if (externalStorageDirectory == null) {
            return "";
        }
        if (!externalStorageDirectory.exists()) {
            externalStorageDirectory.mkdirs();
        }
        return externalStorageDirectory.getAbsolutePath();
    }

    public static String getFileExtFromUrl(String str) {
        int lastIndexOf;
        return (!TextUtils.isEmpty(str) && (lastIndexOf = str.lastIndexOf(46)) > 0) ? str.substring(lastIndexOf + 1) : "";
    }

    @SuppressLint({"NewApi"})
    public static String getImageCacheDirForImageLoader(Context context) {
        String cacheDirectory = getCacheDirectory(context);
        return !TextUtils.isEmpty(cacheDirectory) ? new File(cacheDirectory, DIRCTORY_IMAGE_CACHE_FOR_IMAGELOADER).getAbsolutePath() : "";
    }

    @SuppressLint({"NewApi"})
    public static String getImageCacheDirForOthers(Context context) {
        String cacheDirectory = getCacheDirectory(context);
        if (TextUtils.isEmpty(cacheDirectory)) {
            return "";
        }
        File file = new File(cacheDirectory, DIRCTORY_IMAGE_CACHE_FOR_OTHER);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    @Deprecated
    public static String getImageCacheDirctoryForImageLoader(Context context) {
        if (TextUtils.isEmpty(sImageCacheDirForImageloader)) {
            sImageCacheDirForImageloader = getImageCacheDirForImageLoader(context);
        }
        return sImageCacheDirForImageloader;
    }

    @Deprecated
    public static String getImageCacheDirectoryBaseForFresco(Context context) {
        if (TextUtils.isEmpty(sImageCacheDirBaseForFresco)) {
            sImageCacheDirBaseForFresco = getCacheDirectory(context);
        }
        return sImageCacheDirBaseForFresco;
    }

    @Deprecated
    public static String getImageCacheDirectoryForOthers(Context context) {
        if (TextUtils.isEmpty(sImageCacheDirForOther)) {
            sImageCacheDirForOther = getImageCacheDirForOthers(context);
        }
        return sImageCacheDirForOther;
    }

    public static boolean isExternalStorageWritable() {
        if (TextUtils.equals("mounted", Environment.getExternalStorageState()) && !TextUtils.isEmpty(sCacheDir)) {
            try {
                File file = new File(sCacheDir, ".696E5309-E4A7-27C0-A787-0B2CEBF1F1AB");
                if (file.exists()) {
                    return true;
                }
                return file.createNewFile();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }
}
