package com.baidu.android.util.io;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.io.File;
/* loaded from: classes9.dex */
public final class PathUtils {
    private static final boolean DEBUG = false;
    private static final String DIRCTORY_APP = "xxx";
    private static final String DIRCTORY_BAIDU = "baidu";
    private static final String DIRCTORY_BAIDU2 = "BaiduBox";
    private static final String DIRCTORY_DOWNLOAD = "downloads";
    private static final String DIRCTORY_IMAGE_CACHE_FOR_IMAGELOADER = "img_cache";
    private static final String DIRCTORY_IMAGE_CACHE_FOR_NUOMI_SDK = "img_cache_nuomi";
    private static final String DIRCTORY_IMAGE_CACHE_FOR_OTHER = "img_other";
    private static final String DIRECTORY_DATA_CACHE = "baidu/xxx";
    public static final String PATH_DEFAULT_DOWNLOAD = "baidu/xxx/downloads";
    public static final String PATH_DEFAULT_DOWNLOAD2 = "BaiduBox/downloads";
    private static final String TAG = "PathUtils";
    private static String sCacheDir = null;
    private static String sImageCacheDirBaseForFresco;
    private static String sImageCacheDirForImageloader;
    private static String sImageCacheDirForNuomiSDK;
    private static String sImageCacheDirForOther;

    private PathUtils() {
    }

    static {
        sImageCacheDirForImageloader = null;
        sImageCacheDirForNuomiSDK = null;
        sImageCacheDirBaseForFresco = null;
        sImageCacheDirForOther = null;
        sImageCacheDirBaseForFresco = getCacheDirectory(AppRuntime.getAppContext());
        sImageCacheDirForImageloader = getImageCacheDirForImageLoader(AppRuntime.getAppContext());
        sImageCacheDirForNuomiSDK = getImageCacheDirForNuomiSDK(AppRuntime.getAppContext());
        sImageCacheDirForOther = getImageCacheDirForOthers(AppRuntime.getAppContext());
    }

    public static String getExternalStorageDir(Context context) {
        File cacheDir;
        if (isExternalStorageWritable()) {
            cacheDir = Environment.getExternalStorageDirectory();
        } else {
            cacheDir = context.getCacheDir();
        }
        if (cacheDir == null) {
            return "";
        }
        if (!cacheDir.exists()) {
            cacheDir.mkdirs();
        }
        return cacheDir.getAbsolutePath();
    }

    public static String getImageCacheDirectoryForOthers(Context context) {
        if (TextUtils.isEmpty(sImageCacheDirForOther)) {
            sImageCacheDirForOther = getImageCacheDirForOthers(context);
        }
        return sImageCacheDirForOther;
    }

    public static String getImageCacheDirectoryForNuomiSDK(Context context) {
        if (TextUtils.isEmpty(sImageCacheDirForNuomiSDK)) {
            sImageCacheDirForNuomiSDK = getImageCacheDirForNuomiSDK(context);
        }
        return sImageCacheDirForNuomiSDK;
    }

    public static String getImageCacheDirectoryBaseForFresco(Context context) {
        if (TextUtils.isEmpty(sImageCacheDirBaseForFresco)) {
            sImageCacheDirBaseForFresco = getCacheDirectory(context);
        }
        return sImageCacheDirBaseForFresco;
    }

    public static String getImageCacheDirctoryForImageLoader(Context context) {
        if (TextUtils.isEmpty(sImageCacheDirForImageloader)) {
            sImageCacheDirForImageloader = getImageCacheDirForImageLoader(context);
        }
        return sImageCacheDirForImageloader;
    }

    @SuppressLint({"NewApi"})
    public static String getCacheDirectory(Context context) {
        if (!TextUtils.isEmpty(sCacheDir)) {
            return sCacheDir;
        }
        File file = null;
        if (Build.VERSION.SDK_INT >= 8) {
            try {
                file = context.getExternalCacheDir();
            } catch (Exception e) {
            }
        }
        if (file == null && isExternalStorageWritable()) {
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            file = externalStorageDirectory != null ? new File(externalStorageDirectory, DIRECTORY_DATA_CACHE) : externalStorageDirectory;
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
            }
        } catch (Exception e) {
        }
        return true;
    }

    public static File getDownloadDirectory(Context context) {
        File file;
        boolean z = true;
        if (isExternalStorageWritable()) {
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            if (isBaiduDirectoryWritable()) {
                file = new File(externalStorageDirectory, PATH_DEFAULT_DOWNLOAD);
            } else {
                file = new File(externalStorageDirectory, PATH_DEFAULT_DOWNLOAD2);
            }
            if (file != null) {
                if (file.exists()) {
                    if (file.isDirectory()) {
                        z = false;
                    } else {
                        deleteFile(file);
                    }
                }
                if (z) {
                    file.mkdirs();
                    return file;
                }
                return file;
            }
            return file;
        }
        return null;
    }

    public static boolean isExternalStorageWritable() {
        if (!TextUtils.equals("mounted", Environment.getExternalStorageState()) || TextUtils.isEmpty(sCacheDir)) {
            return false;
        }
        try {
            File file = new File(sCacheDir, ".696E5309-E4A7-27C0-A787-0B2CEBF1F1AB");
            if (file.exists()) {
                return true;
            }
            return file.createNewFile();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static boolean isBaiduDirectoryWritable() {
        return isDirectoryWritable(new File(Environment.getExternalStorageDirectory(), DIRECTORY_DATA_CACHE));
    }

    private static boolean isDirectoryWritable(File file) {
        System.currentTimeMillis();
        boolean z = false;
        if (TextUtils.equals("mounted", Environment.getExternalStorageState())) {
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            if (externalStorageDirectory.exists() && externalStorageDirectory.canWrite() && file != null && file.exists()) {
                try {
                    if (file.isDirectory()) {
                        File file2 = new File(file, ".696E5309-E4A7-27C0-A787-0B2CEBF1F1AB");
                        if (file2.exists()) {
                            File file3 = new File(file, ".696E5309-E4A7-27C0-A787-0B2CEBF1F1AB__temp");
                            z = file2.renameTo(file3);
                            if (z) {
                                file3.renameTo(file2);
                            }
                        } else {
                            z = file2.createNewFile();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        System.currentTimeMillis();
        return z;
    }

    @SuppressLint({"NewApi"})
    private static String getImageCacheDirForImageLoader(Context context) {
        String cacheDirectory = getCacheDirectory(context);
        return !TextUtils.isEmpty(cacheDirectory) ? new File(cacheDirectory, DIRCTORY_IMAGE_CACHE_FOR_IMAGELOADER).getAbsolutePath() : "";
    }

    @SuppressLint({"NewApi"})
    private static String getImageCacheDirForNuomiSDK(Context context) {
        String cacheDirectory = getCacheDirectory(context);
        if (TextUtils.isEmpty(cacheDirectory)) {
            return "";
        }
        File file = new File(cacheDirectory, DIRCTORY_IMAGE_CACHE_FOR_NUOMI_SDK);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    @SuppressLint({"NewApi"})
    private static String getImageCacheDirForOthers(Context context) {
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
    private static boolean deleteFile(File file) {
        try {
            String absolutePath = file.getAbsolutePath();
            File file2 = new File(absolutePath);
            File file3 = new File(absolutePath + System.currentTimeMillis() + ".tmp");
            file2.renameTo(file3);
            return file3.delete();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void deleteOldFiles(Context context) {
        if (TextUtils.equals("mounted", Environment.getExternalStorageState())) {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
            if (!defaultSharedPreferences.getBoolean("key_path_utils_delete_old_file", false)) {
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
    }

    public static String getFileExtFromUrl(String str) {
        int lastIndexOf;
        if (TextUtils.isEmpty(str) || (lastIndexOf = str.lastIndexOf(46)) <= 0) {
            return "";
        }
        return str.substring(lastIndexOf + 1);
    }
}
