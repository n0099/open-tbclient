package com.baidu.minivideo.plugin.capture.download.utils;

import android.content.Context;
import android.os.Environment;
import android.support.annotation.NonNull;
import java.io.File;
/* loaded from: classes11.dex */
public class FileUtils {
    private static final String DOWNLOAD_DIR = "UgcDownload";

    public static final File getDefaultDownloadDir(Context context) {
        return isSDMounted() ? new File(context.getExternalCacheDir(), DOWNLOAD_DIR) : new File(context.getCacheDir(), DOWNLOAD_DIR);
    }

    public static boolean isSDMounted() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public static final String getPrefix(@NonNull String str) {
        return str.substring(0, str.lastIndexOf("."));
    }

    public static final String getSuffix(@NonNull String str) {
        return str.substring(str.lastIndexOf(".") + 1);
    }

    public static final String getFileFullName(String str) {
        return str.substring(str.lastIndexOf("/") + 1, str.length());
    }
}
