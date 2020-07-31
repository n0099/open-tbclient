package com.baidu.swan.facade.provider.a;

import android.content.pm.PackageManager;
import android.content.pm.Signature;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes4.dex */
public class c {
    private static final char[] cYx = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String rn(String str) {
        Signature ro = ro(str);
        if (ro == null) {
            return null;
        }
        try {
            return toHexString(MessageDigest.getInstance("MD5").digest(ro.toByteArray()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static Signature ro(String str) {
        try {
            return AppRuntime.getAppContext().getPackageManager().getPackageInfo(str, 64).signatures[0];
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String toHexString(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            byte b = bArr[i];
            cArr[i * 2] = cYx[(b >>> 4) & 15];
            cArr[(i * 2) + 1] = cYx[b & 15];
        }
        return new String(cArr);
    }
}
