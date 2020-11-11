package com.baidu.swan.facade.provider.a;

import android.content.pm.PackageManager;
import android.content.pm.Signature;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes16.dex */
public class c {
    private static final char[] dKe = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String vi(String str) {
        Signature vj = vj(str);
        if (vj == null) {
            return null;
        }
        try {
            return toHexString(MessageDigest.getInstance("MD5").digest(vj.toByteArray()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static Signature vj(String str) {
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
            cArr[i * 2] = dKe[(b >>> 4) & 15];
            cArr[(i * 2) + 1] = dKe[b & 15];
        }
        return new String(cArr);
    }
}
