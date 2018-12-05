package com.baidu.tbadk.core.util;

import android.content.pm.PackageInfo;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.searchbox.ng.ai.apps.media.audio.AiAppsAudioPlayer;
import com.baidu.searchbox.ng.ai.apps.util.AiAppEncryptUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.security.MessageDigest;
/* loaded from: classes.dex */
public class ar {
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String d(PackageInfo packageInfo) throws NumberFormatException {
        long j = 0;
        String e = e(packageInfo);
        if (e == null || e.length() < 32) {
            return AiAppsAudioPlayer.ERROR_UNKNOWN;
        }
        String substring = e.substring(8, 24);
        long j2 = 0;
        for (int i = 0; i < 8; i++) {
            j2 = (j2 * 16) + Integer.parseInt(substring.substring(i, i + 1), 16);
        }
        for (int i2 = 8; i2 < substring.length(); i2++) {
            j = (j * 16) + Integer.parseInt(substring.substring(i2, i2 + 1), 16);
        }
        return String.valueOf((j + j2) & 4294967295L);
    }

    private static String e(PackageInfo packageInfo) {
        if (packageInfo == null || packageInfo.signatures == null || packageInfo.signatures.length == 0 || packageInfo.signatures[0] == null) {
            return null;
        }
        try {
            return com.baidu.adp.lib.util.s.toMd5(packageInfo.signatures[0].toCharsString().getBytes());
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }

    public static String D(byte[] bArr) {
        int i = 0;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(AiAppEncryptUtils.ENCRYPT_MD5);
            messageDigest.update(bArr);
            byte[] digest = messageDigest.digest();
            char[] cArr = new char[32];
            for (int i2 = 0; i2 < 16; i2++) {
                byte b = digest[i2];
                int i3 = i + 1;
                cArr[i] = HEX_DIGITS[(b >>> 4) & 15];
                i = i3 + 1;
                cArr[i3] = HEX_DIGITS[b & 15];
            }
            return new String(cArr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String f(PackageInfo packageInfo) {
        if (packageInfo == null) {
            return null;
        }
        File file = new File(packageInfo.applicationInfo.publicSourceDir);
        if (file.exists()) {
            try {
                return com.baidu.adp.lib.util.s.i(new FileInputStream(file));
            } catch (FileNotFoundException e) {
                BdLog.detailException(e);
                return null;
            }
        }
        return null;
    }

    public static String fK(String str) {
        return com.baidu.adp.lib.util.s.bC(str);
    }
}
