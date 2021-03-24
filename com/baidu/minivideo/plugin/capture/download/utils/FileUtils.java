package com.baidu.minivideo.plugin.capture.download.utils;

import android.content.Context;
import android.os.Environment;
import androidx.annotation.NonNull;
import java.io.File;
/* loaded from: classes2.dex */
public class FileUtils {
    public static final String DOWNLOAD_DIR = "UgcDownload";

    public static final File getDefaultDownloadDir(Context context) {
        if (isSDMounted()) {
            return new File(context.getExternalCacheDir(), DOWNLOAD_DIR);
        }
        return new File(context.getCacheDir(), DOWNLOAD_DIR);
    }

    public static final String getFileFullName(String str) {
        return str.substring(str.lastIndexOf("/") + 1, str.length());
    }

    public static final String getPrefix(@NonNull String str) {
        return str.substring(0, str.lastIndexOf("."));
    }

    public static final String getSuffix(@NonNull String str) {
        return str.substring(str.lastIndexOf(".") + 1);
    }

    public static boolean isSDMounted() {
        return Environment.getExternalStorageState().equals("mounted");
    }
}
