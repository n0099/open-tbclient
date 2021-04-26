package com.baidu.tbadk.core.util;

import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import com.baidu.adp.lib.util.BdLog;
import d.a.c.e.p.q;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.security.MessageDigest;
/* loaded from: classes3.dex */
public class TbMd5 {
    public static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String creatSignInt(PackageInfo packageInfo) throws NumberFormatException {
        int i2;
        int i3;
        String signMd5 = getSignMd5(packageInfo);
        if (signMd5 == null || signMd5.length() < 32) {
            return "-1";
        }
        String substring = signMd5.substring(8, 24);
        long j = 0;
        long j2 = 0;
        for (int i4 = 0; i4 < 8; i4++) {
            j2 = (j2 * 16) + Integer.parseInt(substring.substring(i4, i3), 16);
        }
        for (int i5 = 8; i5 < substring.length(); i5++) {
            j = (j * 16) + Integer.parseInt(substring.substring(i5, i2), 16);
        }
        return String.valueOf(4294967295L & (j + j2));
    }

    public static String getAPKHexMD5(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            byte[] digest = messageDigest.digest();
            char[] cArr = new char[32];
            int i2 = 0;
            for (int i3 = 0; i3 < 16; i3++) {
                byte b2 = digest[i3];
                int i4 = i2 + 1;
                cArr[i2] = HEX_DIGITS[(b2 >>> 4) & 15];
                i2 = i4 + 1;
                cArr[i4] = HEX_DIGITS[b2 & 15];
            }
            return new String(cArr);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String getAPKMd5(PackageInfo packageInfo) {
        if (packageInfo == null) {
            return null;
        }
        File file = new File(packageInfo.applicationInfo.publicSourceDir);
        if (file.exists()) {
            try {
                return q.b(new FileInputStream(file));
            } catch (FileNotFoundException e2) {
                BdLog.detailException(e2);
            }
        }
        return null;
    }

    public static String getNameMd5FromUrl(String str) {
        return q.c(str);
    }

    public static String getSignMd5(PackageInfo packageInfo) {
        Signature[] signatureArr;
        if (packageInfo == null || (signatureArr = packageInfo.signatures) == null || signatureArr.length == 0 || signatureArr[0] == null) {
            return null;
        }
        try {
            return q.d(signatureArr[0].toCharsString().getBytes());
        } catch (Exception e2) {
            BdLog.detailException(e2);
            return null;
        }
    }
}
