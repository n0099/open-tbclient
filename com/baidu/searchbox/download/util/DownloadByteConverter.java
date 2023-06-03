package com.baidu.searchbox.download.util;

import android.text.TextUtils;
import com.baidu.searchbox.config.AppConfig;
import java.text.DecimalFormat;
/* loaded from: classes3.dex */
public final class DownloadByteConverter {
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final String FILE_SUFFIX_DOT = ".";
    public static final int GB = 1073741824;
    public static final int KB = 1024;
    public static final int MB = 1048576;
    public static final String SIZE_ZERO = "0";

    public static String calculatePattern(int i) {
        StringBuilder sb = new StringBuilder("0");
        if (i < 0) {
            return "";
        }
        if (i == 0) {
            return sb.toString();
        }
        sb.append(".");
        for (int i2 = 0; i2 < i; i2++) {
            sb.append("0");
        }
        return sb.toString();
    }

    public static String convertByte(double d, int i, boolean z) {
        float f;
        String str;
        int lastIndexOf;
        if (d < 1024.0d) {
            f = (float) d;
            str = "B";
        } else if (d < 1048576.0d) {
            f = ((float) d) / 1024.0f;
            str = "KB";
        } else if (d < 1.073741824E9d) {
            f = ((float) d) / 1048576.0f;
            str = "MB";
        } else {
            f = ((float) d) / 1.0737418E9f;
            str = "GB";
        }
        try {
            String calculatePattern = calculatePattern(i);
            if (TextUtils.isEmpty(calculatePattern)) {
                return "";
            }
            String format = new DecimalFormat(calculatePattern).format(f);
            if (!z && i != 0) {
                if (format.endsWith(calculatePattern.substring(1)) && (lastIndexOf = format.lastIndexOf(".")) > 0) {
                    return format.substring(0, lastIndexOf) + str;
                }
                return format + str;
            }
            return format + str;
        } catch (Exception e) {
            if (!DEBUG) {
                return "";
            }
            e.printStackTrace();
            throw e;
        }
    }
}
