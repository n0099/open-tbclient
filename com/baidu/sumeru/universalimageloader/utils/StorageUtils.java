package com.baidu.sumeru.universalimageloader.utils;

import android.content.Context;
import android.os.Environment;
import java.io.File;
import java.io.IOException;
/* loaded from: classes9.dex */
public final class StorageUtils {
    private static final String EXTERNAL_STORAGE_PERMISSION = "android.permission.WRITE_EXTERNAL_STORAGE";
    private static final String INDIVIDUAL_DIR_NAME = "uil-images";

    private StorageUtils() {
    }

    public static File getCacheDirectory(Context context) {
        return getCacheDirectory(context, true);
    }

    public static File getCacheDirectory(Context context, boolean z) {
        File file = null;
        if (z && "mounted".equals(Environment.getExternalStorageState()) && hasExternalStoragePermission(context)) {
            file = getExternalCacheDir(context);
        }
        if (file == null) {
            file = context.getCacheDir();
        }
        if (file == null) {
            String str = "/data/data/" + context.getPackageName() + "/cache/";
            L.w("Can't define system cache directory! '%s' will be used.", str);
            return new File(str);
        }
        return file;
    }

    public static File getIndividualCacheDirectory(Context context) {
        File cacheDirectory = getCacheDirectory(context);
        File file = new File(cacheDirectory, INDIVIDUAL_DIR_NAME);
        return (file.exists() || file.mkdir()) ? file : cacheDirectory;
    }

    public static File getOwnCacheDirectory(Context context, String str) {
        File file = null;
        if ("mounted".equals(Environment.getExternalStorageState()) && hasExternalStoragePermission(context)) {
            file = new File(Environment.getExternalStorageDirectory(), str);
        }
        if (file == null || (!file.exists() && !file.mkdirs())) {
            return context.getCacheDir();
        }
        return file;
    }

    private static File getExternalCacheDir(Context context) {
        File file = new File(new File(new File(new File(Environment.getExternalStorageDirectory(), "Android"), "data"), context.getPackageName()), "cache");
        if (!file.exists()) {
            if (!file.mkdirs()) {
                L.w("Unable to create external cache directory", new Object[0]);
                return null;
            }
            try {
                new File(file, ".nomedia").createNewFile();
                return file;
            } catch (IOException e) {
                L.i("Can't create \".nomedia\" file in application external cache directory", new Object[0]);
                return file;
            }
        }
        return file;
    }

    private static boolean hasExternalStoragePermission(Context context) {
        return context.checkCallingOrSelfPermission(EXTERNAL_STORAGE_PERMISSION) == 0;
    }
}
