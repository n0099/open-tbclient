package com.baidu.platform.comapi.walknavi.d.a.g;

import android.os.Environment;
import java.security.MessageDigest;
/* loaded from: classes2.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    public static final String f10014a = "com.baidu.platform.comapi.walknavi.d.a.g.k";

    /* renamed from: b  reason: collision with root package name */
    public static String f10015b = Environment.getExternalStorageDirectory() + "/AR/Screenshots/";

    public static String a(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[charArray.length];
            for (int i = 0; i < charArray.length; i++) {
                bArr[i] = (byte) charArray[i];
            }
            byte[] digest = messageDigest.digest(bArr);
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b2 : digest) {
                int i2 = b2 & 255;
                if (i2 < 16) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(Integer.toHexString(i2));
            }
            return stringBuffer.toString();
        } catch (Exception unused) {
            return "";
        }
    }
}
