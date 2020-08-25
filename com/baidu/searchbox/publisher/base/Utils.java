package com.baidu.searchbox.publisher.base;

import android.content.Context;
import android.content.pm.PackageManager;
import java.io.File;
import java.io.FileInputStream;
import java.text.DecimalFormat;
/* loaded from: classes3.dex */
public class Utils {
    private static final long BYTEBIT = 1024;
    private static final int MESCPREMINUTE = 60;
    private static final int MILLISECOND = 1000;

    public static String formentFileSize(long j) {
        DecimalFormat decimalFormat = new DecimalFormat("#");
        if (j < 1024) {
            return decimalFormat.format(j) + "B";
        }
        if (j < 1048576) {
            return decimalFormat.format(j / 1024.0d) + "KB";
        }
        if (j < 1073741824) {
            return decimalFormat.format(j / 1048576.0d) + "M";
        }
        return decimalFormat.format(j / 1.073741824E9d) + "G";
    }

    public static long[] getMinuteAndSecond(int i) {
        int i2 = i / 1000;
        return new long[]{i2 / 60, i2 % 60};
    }

    public static int getStatusHeight(Context context) {
        try {
            Class<?> cls = Class.forName("com.android.internal.R$dimen");
            return context.getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static long getFileSize(File file) throws Exception {
        if (file.exists()) {
            return new FileInputStream(file).available();
        }
        file.createNewFile();
        return 0L;
    }

    public static String getAppName(Context context) {
        try {
            return context.getResources().getString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.labelRes);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
