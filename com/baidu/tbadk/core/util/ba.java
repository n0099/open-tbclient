package com.baidu.tbadk.core.util;

import android.content.pm.PackageInfo;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
/* loaded from: classes.dex */
public class ba {
    public static String a(PackageInfo packageInfo) {
        long j = 0;
        String b = b(packageInfo);
        if (b == null || b.length() < 32) {
            return "-1";
        }
        String substring = b.substring(8, 24);
        long j2 = 0;
        for (int i = 0; i < 8; i++) {
            j2 = (j2 * 16) + Integer.parseInt(substring.substring(i, i + 1), 16);
        }
        for (int i2 = 8; i2 < substring.length(); i2++) {
            j = (j * 16) + Integer.parseInt(substring.substring(i2, i2 + 1), 16);
        }
        return String.valueOf((j + j2) & 4294967295L);
    }

    private static String b(PackageInfo packageInfo) {
        if (packageInfo == null) {
            return null;
        }
        try {
            return com.baidu.adp.lib.util.u.n(packageInfo.signatures[0].toCharsString().getBytes());
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }

    public static String c(PackageInfo packageInfo) {
        if (packageInfo == null) {
            return null;
        }
        File file = new File(packageInfo.applicationInfo.publicSourceDir);
        if (file.exists()) {
            try {
                return com.baidu.adp.lib.util.u.b(new FileInputStream(file));
            } catch (FileNotFoundException e) {
                BdLog.detailException(e);
                return null;
            }
        }
        return null;
    }

    public static String bQ(String str) {
        return com.baidu.adp.lib.util.u.aE(str);
    }
}
