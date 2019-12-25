package com.baidu.minivideo.plugin.capture.download.utils;

import android.app.Activity;
import android.support.v4.app.ActivityCompat;
import java.text.DecimalFormat;
/* loaded from: classes11.dex */
public class CommonUtils {
    private static final DecimalFormat DF = new DecimalFormat("0.00");
    private static String[] PERMISSIONS_STORAGE = {"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"};
    private static final int REQUEST_EXTERNAL_STORAGE = 1;

    public static String getDownloadPerSize(long j, long j2) {
        return DF.format(((float) j) / 1048576.0f) + "M/" + DF.format(((float) j2) / 1048576.0f) + "M";
    }

    public static void verifyStoragePermissions(Activity activity) {
        if (ActivityCompat.checkSelfPermission(activity, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            ActivityCompat.requestPermissions(activity, PERMISSIONS_STORAGE, 1);
        }
    }
}
