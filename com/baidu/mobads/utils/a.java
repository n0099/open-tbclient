package com.baidu.mobads.utils;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.interfaces.utils.IBase64;
/* loaded from: classes5.dex */
public class a implements IBase64 {
    private static final byte[] a = {48, 75, 97, 106, 68, 55, 65, 90, 99, 70, 50, 81, 110, 80, 114, 53, 102, 119, 105, 72, 82, 78, 121, 103, 109, 117, 112, 85, 84, 73, 88, 120, 54, 57, 66, 87, 98, 45, 104, 77, 67, 71, 74, 111, 95, 86, 56, 69, 115, 107, 122, 49, 89, 100, 118, 76, 51, 52, 108, Constants.SHORT_PING_CMD_TYPE, 116, 113, 83, 79};
    private static final byte[] b = new byte[128];

    static {
        for (int i = 0; i < a.length; i++) {
            b[a[i]] = (byte) i;
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IBase64
    public String encode(String str) {
        int i = 0;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        for (int length = str.getBytes().length % 3; length > 0 && length < 3; length++) {
            str = str + "$";
        }
        byte[] bytes = str.getBytes();
        byte[] bArr = new byte[(bytes.length / 3) * 4];
        int i2 = 0;
        while (i2 < bytes.length) {
            bArr[i] = a[(bytes[i2] & 252) >> 2];
            bArr[i + 1] = a[((bytes[i2] & 3) << 4) + ((bytes[i2 + 1] & 240) >> 4)];
            bArr[i + 2] = a[((bytes[i2 + 1] & 15) << 2) + ((bytes[i2 + 2] & 192) >> 6)];
            bArr[i + 3] = a[bytes[i2 + 2] & 63];
            i2 += 3;
            i += 4;
        }
        return new String(bArr);
    }

    private byte[] a(String str) {
        byte[] bArr = null;
        int i = 0;
        if (!b(str) && str != null && str.length() >= 4) {
            if (str.charAt(str.length() - 2) == '$') {
                bArr = new byte[(((str.length() / 4) - 1) * 3) + 1];
            } else if (str.charAt(str.length() - 1) == '$') {
                bArr = new byte[(((str.length() / 4) - 1) * 3) + 2];
            } else {
                bArr = new byte[(str.length() / 4) * 3];
            }
            int i2 = 0;
            while (i2 < str.length() - 4) {
                byte b2 = b[str.charAt(i2)];
                byte b3 = b[str.charAt(i2 + 1)];
                byte b4 = b[str.charAt(i2 + 2)];
                byte b5 = b[str.charAt(i2 + 3)];
                bArr[i] = (byte) ((b2 << 2) | (b3 >> 4));
                bArr[i + 1] = (byte) ((b3 << 4) | (b4 >> 2));
                bArr[i + 2] = (byte) ((b4 << 6) | b5);
                i2 += 4;
                i += 3;
            }
            if (str.charAt(str.length() - 2) == '$') {
                bArr[bArr.length - 1] = (byte) ((b[str.charAt(str.length() - 4)] << 2) | (b[str.charAt(str.length() - 3)] >> 4));
            } else if (str.charAt(str.length() - 1) == '$') {
                byte b6 = b[str.charAt(str.length() - 4)];
                byte b7 = b[str.charAt(str.length() - 3)];
                byte b8 = b[str.charAt(str.length() - 2)];
                bArr[bArr.length - 2] = (byte) ((b6 << 2) | (b7 >> 4));
                bArr[bArr.length - 1] = (byte) ((b7 << 4) | (b8 >> 2));
            } else {
                byte b9 = b[str.charAt(str.length() - 4)];
                byte b10 = b[str.charAt(str.length() - 3)];
                byte b11 = b[str.charAt(str.length() - 2)];
                byte b12 = b[str.charAt(str.length() - 1)];
                bArr[bArr.length - 3] = (byte) ((b9 << 2) | (b10 >> 4));
                bArr[bArr.length - 2] = (byte) ((b10 << 4) | (b11 >> 2));
                bArr[bArr.length - 1] = (byte) ((b11 << 6) | b12);
            }
        }
        return bArr;
    }

    @Override // com.baidu.mobads.interfaces.utils.IBase64
    public String decodeStr(String str) {
        if (str == null || str.length() < 4) {
            return null;
        }
        try {
            String str2 = new String(a(str));
            while (str2.endsWith("$")) {
                str2 = str2.substring(0, str2.length() - 1);
            }
            return str2;
        } catch (Exception e) {
            return "";
        }
    }

    private boolean b(String str) {
        if (str == null) {
            return true;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!a((byte) str.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private boolean a(byte b2) {
        if (b2 == 36) {
            return true;
        }
        if (b2 < 0 || b2 >= 128) {
            return false;
        }
        return b[b2] != -1;
    }
}
