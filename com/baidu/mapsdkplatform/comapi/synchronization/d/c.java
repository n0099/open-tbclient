package com.baidu.mapsdkplatform.comapi.synchronization.d;

import android.text.TextUtils;
import com.baidu.minivideo.plugin.capture.utils.EncryptUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes6.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static final String f3104a = c.class.getSimpleName();

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(EncryptUtils.ENCRYPT_MD5);
            messageDigest.update(str.getBytes());
            return a(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            a.a(f3104a, "NoSuchAlgorithmException happened when get MD5 string", e);
            return null;
        }
    }

    private static String a(byte[] bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] cArr2 = new char[bArr.length * 2];
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            byte b2 = bArr[i];
            int i3 = i2 + 1;
            cArr2[i2] = cArr[(b2 >>> 4) & 15];
            cArr2[i3] = cArr[b2 & 15];
            i++;
            i2 = i3 + 1;
        }
        return new String(cArr2).toLowerCase();
    }
}
