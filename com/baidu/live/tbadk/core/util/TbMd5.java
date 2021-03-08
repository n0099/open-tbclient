package com.baidu.live.tbadk.core.util;

import android.content.pm.PackageInfo;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.Md5;
import com.baidu.minivideo.plugin.capture.utils.EncryptUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.security.MessageDigest;
/* loaded from: classes10.dex */
public class TbMd5 {
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String creatSignInt(PackageInfo packageInfo) throws NumberFormatException {
        long j = 0;
        String signMd5 = getSignMd5(packageInfo);
        if (signMd5 == null || signMd5.length() < 32) {
            return "-1";
        }
        String substring = signMd5.substring(8, 24);
        long j2 = 0;
        for (int i = 0; i < 8; i++) {
            j2 = (j2 * 16) + Integer.parseInt(substring.substring(i, i + 1), 16);
        }
        for (int i2 = 8; i2 < substring.length(); i2++) {
            j = (j * 16) + Integer.parseInt(substring.substring(i2, i2 + 1), 16);
        }
        return String.valueOf((j + j2) & 4294967295L);
    }

    private static String getSignMd5(PackageInfo packageInfo) {
        if (packageInfo == null || packageInfo.signatures == null || packageInfo.signatures.length == 0 || packageInfo.signatures[0] == null) {
            return null;
        }
        try {
            return Md5.toMd5(packageInfo.signatures[0].toCharsString().getBytes());
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }

    public static String getAPKHexMD5(byte[] bArr) {
        int i = 0;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(EncryptUtils.ENCRYPT_MD5);
            messageDigest.update(bArr);
            byte[] digest = messageDigest.digest();
            char[] cArr = new char[32];
            int i2 = 0;
            while (true) {
                int i3 = i;
                if (i3 >= 16) {
                    return new String(cArr);
                }
                byte b = digest[i3];
                int i4 = i2 + 1;
                cArr[i2] = HEX_DIGITS[(b >>> 4) & 15];
                i2 = i4 + 1;
                cArr[i4] = HEX_DIGITS[b & 15];
                i = i3 + 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
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
                return Md5.toMd5(new FileInputStream(file));
            } catch (FileNotFoundException e) {
                BdLog.detailException(e);
                return null;
            }
        }
        return null;
    }

    public static String getNameMd5FromUrl(String str) {
        return Md5.toMd5(str);
    }
}
