package com.baidu.minivideo.plugin.capture.download.utils;

import android.app.Activity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import java.text.DecimalFormat;
/* loaded from: classes2.dex */
public class CommonUtils {
    public static final DecimalFormat DF = new DecimalFormat("0.00");
    public static String[] PERMISSIONS_STORAGE = {"android.permission.READ_EXTERNAL_STORAGE", StorageUtils.EXTERNAL_STORAGE_PERMISSION};
    public static final int REQUEST_EXTERNAL_STORAGE = 1;

    public static String getDownloadPerSize(long j, long j2) {
        return DF.format(((float) j) / 1048576.0f) + "M/" + DF.format(((float) j2) / 1048576.0f) + "M";
    }

    public static void verifyStoragePermissions(Activity activity) {
        if (ContextCompat.checkSelfPermission(activity, StorageUtils.EXTERNAL_STORAGE_PERMISSION) != 0) {
            ActivityCompat.requestPermissions(activity, PERMISSIONS_STORAGE, 1);
        }
    }
}
