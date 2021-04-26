package com.baidu.platform.comapi.walknavi.d.a.g;

import android.os.Environment;
import java.security.MessageDigest;
/* loaded from: classes2.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    public static final String f9929a = "com.baidu.platform.comapi.walknavi.d.a.g.k";

    /* renamed from: b  reason: collision with root package name */
    public static String f9930b = Environment.getExternalStorageDirectory() + "/AR/Screenshots/";

    public static String a(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[charArray.length];
            for (int i2 = 0; i2 < charArray.length; i2++) {
                bArr[i2] = (byte) charArray[i2];
            }
            byte[] digest = messageDigest.digest(bArr);
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b2 : digest) {
                int i3 = b2 & 255;
                if (i3 < 16) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(Integer.toHexString(i3));
            }
            return stringBuffer.toString();
        } catch (Exception unused) {
            return "";
        }
    }
}
