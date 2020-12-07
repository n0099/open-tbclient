package com.baidu.cloudbase.download.b;

import java.text.DecimalFormat;
/* loaded from: classes12.dex */
public class a {
    public static final DecimalFormat DF = new DecimalFormat("0.00");
    public static String[] PERMISSIONS_STORAGE = {"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"};

    public static String getDownloadPerSize(long j, long j2) {
        return DF.format(((float) j) / 1048576.0f) + "M/" + DF.format(((float) j2) / 1048576.0f) + "M";
    }
}
