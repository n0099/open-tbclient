package com.baidu.mobads.container.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import java.io.File;
/* loaded from: classes2.dex */
public class SdcardUtils {
    public static final String DEFAULT_CACHE_PATH = "/bddownload/";
    public static final String DEFAULT_SD_CARD_PATH = "/mnt/sdcard";
    public static final String KEY_SYS_MEM = "sysMem";
    public static final String KEY_SYS_SDC = "sysSdc";

    public static boolean canSupportSdcardStroage(Context context) {
        try {
            if (Build.VERSION.SDK_INT <= 28 && !PermissionUtils.checkPermission(context, StorageUtils.EXTERNAL_STORAGE_PERMISSION)) {
                if (isUseOldStoragePath()) {
                    return false;
                }
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static long getAllExternalMemorySize() {
        try {
            if (Environment.getExternalStorageState().equals("mounted")) {
                return getAllMemorySize(Environment.getExternalStorageDirectory());
            }
            return -1L;
        } catch (Exception unused) {
            return -1L;
        }
    }

    public static long getAllInternalMemorySize() {
        try {
            return getAllMemorySize(Environment.getDataDirectory());
        } catch (Exception unused) {
            return -1L;
        }
    }

    @TargetApi(18)
    public static long getAllMemorySize(File file) {
        try {
            StatFs statFs = new StatFs(file.getPath());
            return ((statFs.getBlockCount() * statFs.getBlockSize()) / 1024) / 1024;
        } catch (Exception unused) {
            return -1L;
        }
    }

    public static String getApkDlPath(String str) {
        return str + DEFAULT_CACHE_PATH;
    }

    public static String getAppSDC(Context context) {
        String str = "";
        SPUtils sPUtils = new SPUtils(context);
        try {
            String string = sPUtils.getString(KEY_SYS_SDC, "");
            if (!TextUtils.isEmpty(string)) {
                return string;
            }
        } catch (Exception e2) {
            RemoteXAdLogger.getInstance().e(e2);
        }
        if (Environment.getExternalStorageState().equals("mounted")) {
            try {
                str = getAvailableExternalMemorySize() + "," + getAllExternalMemorySize();
                sPUtils.putString(KEY_SYS_SDC, str);
                return str;
            } catch (Exception unused) {
                return str;
            }
        }
        return "0,0";
    }

    public static long getAvailableExternalMemorySize() {
        try {
            if (Environment.getExternalStorageState().equals("mounted")) {
                return getAvailableMemorySize(Environment.getExternalStorageDirectory());
            }
            return -1L;
        } catch (Exception unused) {
            return -1L;
        }
    }

    public static long getAvailableInternalMemorySize() {
        try {
            return getAvailableMemorySize(Environment.getDataDirectory());
        } catch (Exception unused) {
            return -1L;
        }
    }

    @TargetApi(18)
    public static long getAvailableMemorySize(File file) {
        try {
            StatFs statFs = new StatFs(file.getPath());
            return ((statFs.getAvailableBlocks() * statFs.getBlockSize()) / 1024) / 1024;
        } catch (Exception unused) {
            return -1L;
        }
    }

    public static File getExternalFilesDirByStatic(Context context) {
        try {
            if (Build.VERSION.SDK_INT > 28) {
                return context.getExternalFilesDir(null);
            }
            if ("mounted".equals(Environment.getExternalStorageState())) {
                if (PermissionUtils.checkPermission(context, StorageUtils.EXTERNAL_STORAGE_PERMISSION) && PermissionUtils.hasPermission("permission_storage")) {
                    return getExternalStorageDirectory();
                }
                if (Build.VERSION.SDK_INT >= 19) {
                    return context.getExternalFilesDir(null);
                }
                return context.getFilesDir();
            }
            return context.getFilesDir();
        } catch (Exception e2) {
            RemoteXAdLogger.getInstance().e("TAG", e2.getMessage());
            return null;
        }
    }

    public static File getExternalStorageDirectory() {
        return Environment.getExternalStorageDirectory();
    }

    public static String getMem(Context context) {
        String str = "";
        SPUtils sPUtils = new SPUtils(context);
        try {
            String string = sPUtils.getString(KEY_SYS_MEM, "");
            if (!TextUtils.isEmpty(string)) {
                return string;
            }
        } catch (Exception e2) {
            RemoteXAdLogger.getInstance().e(e2);
        }
        try {
            str = getAvailableInternalMemorySize() + "," + getAllInternalMemorySize();
            sPUtils.putString(KEY_SYS_MEM, str);
            return str;
        } catch (Exception unused) {
            return str;
        }
    }

    public static String getStoragePath(Context context) {
        return getStoragePath(context, DEFAULT_SD_CARD_PATH);
    }

    public static String getStoragePathForDlApk(Context context) {
        try {
            if (!AppUtils.needProviderForDl(context)) {
                return getStoragePath(context, DEFAULT_SD_CARD_PATH);
            }
            if (AppUtils.supportInstallApkFromPublicSdPath(context)) {
                return getStoragePath(context, DEFAULT_SD_CARD_PATH);
            }
            return getApkDlPath(context.getExternalFilesDir(null).getPath());
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean isUseOldStoragePath() {
        return Build.VERSION.SDK_INT < 23;
    }

    public static String getStoragePath(Context context, String str) {
        try {
            return getApkDlPath(getExternalFilesDirByStatic(context).getPath());
        } catch (Throwable unused) {
            return getApkDlPath(str);
        }
    }
}
