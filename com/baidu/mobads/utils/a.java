package com.baidu.mobads.utils;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.interfaces.utils.IBase64;
import com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy;
import com.baidu.webkit.internal.utils.UtilsBlink;
/* loaded from: classes2.dex */
public class a implements IBase64 {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f8525a = {48, 75, 97, 106, 68, 55, 65, 90, 99, 70, 50, 81, 110, 80, 114, 53, 102, 119, 105, 72, 82, 78, 121, 103, 109, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1, 112, 85, 84, 73, 88, 120, 54, 57, 66, 87, 98, UtilsBlink.VER_TYPE_SEPARATOR, 104, 77, 67, 71, 74, 111, 95, 86, 56, 69, 115, 107, 122, 49, 89, 100, 118, 76, 51, 52, 108, Constants.SHORT_PING_CMD_TYPE, 116, 113, 83, 79};

    /* renamed from: b  reason: collision with root package name */
    public static final byte[] f8526b = new byte[128];

    static {
        int i = 0;
        while (true) {
            byte[] bArr = f8525a;
            if (i >= bArr.length) {
                return;
            }
            f8526b[bArr[i]] = (byte) i;
            i++;
        }
    }

    private byte[] a(String str) {
        byte[] bArr;
        if (b(str) || str == null || str.length() < 4) {
            return null;
        }
        if (str.charAt(str.length() - 2) == '$') {
            bArr = new byte[(((str.length() / 4) - 1) * 3) + 1];
        } else if (str.charAt(str.length() - 1) == '$') {
            bArr = new byte[(((str.length() / 4) - 1) * 3) + 2];
        } else {
            bArr = new byte[(str.length() / 4) * 3];
        }
        int i = 0;
        int i2 = 0;
        while (i < str.length() - 4) {
            byte b2 = f8526b[str.charAt(i)];
            byte b3 = f8526b[str.charAt(i + 1)];
            byte b4 = f8526b[str.charAt(i + 2)];
            byte b5 = f8526b[str.charAt(i + 3)];
            bArr[i2] = (byte) ((b2 << 2) | (b3 >> 4));
            bArr[i2 + 1] = (byte) ((b3 << 4) | (b4 >> 2));
            bArr[i2 + 2] = (byte) ((b4 << 6) | b5);
            i += 4;
            i2 += 3;
        }
        if (str.charAt(str.length() - 2) == '$') {
            byte b6 = f8526b[str.charAt(str.length() - 4)];
            bArr[bArr.length - 1] = (byte) ((f8526b[str.charAt(str.length() - 3)] >> 4) | (b6 << 2));
        } else if (str.charAt(str.length() - 1) == '$') {
            byte b7 = f8526b[str.charAt(str.length() - 4)];
            byte b8 = f8526b[str.charAt(str.length() - 3)];
            byte b9 = f8526b[str.charAt(str.length() - 2)];
            bArr[bArr.length - 2] = (byte) ((b7 << 2) | (b8 >> 4));
            bArr[bArr.length - 1] = (byte) ((b9 >> 2) | (b8 << 4));
        } else {
            byte b10 = f8526b[str.charAt(str.length() - 4)];
            byte b11 = f8526b[str.charAt(str.length() - 3)];
            byte b12 = f8526b[str.charAt(str.length() - 2)];
            byte b13 = f8526b[str.charAt(str.length() - 1)];
            bArr[bArr.length - 3] = (byte) ((b10 << 2) | (b11 >> 4));
            bArr[bArr.length - 2] = (byte) ((b11 << 4) | (b12 >> 2));
            bArr[bArr.length - 1] = (byte) (b13 | (b12 << 6));
        }
        return bArr;
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
        } catch (Exception unused) {
            return "";
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IBase64
    public String encode(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        for (int length = str.getBytes().length % 3; length > 0 && length < 3; length++) {
            str = str + "$";
        }
        byte[] bytes = str.getBytes();
        byte[] bArr = new byte[(bytes.length / 3) * 4];
        int i = 0;
        int i2 = 0;
        while (i < bytes.length) {
            byte[] bArr2 = f8525a;
            bArr[i2] = bArr2[(bytes[i] & 252) >> 2];
            int i3 = i + 1;
            bArr[i2 + 1] = bArr2[((bytes[i] & 3) << 4) + ((bytes[i3] & 240) >> 4)];
            int i4 = i + 2;
            bArr[i2 + 2] = bArr2[((bytes[i3] & 15) << 2) + ((bytes[i4] & ExifInterface.MARKER_SOF0) >> 6)];
            bArr[i2 + 3] = bArr2[bytes[i4] & 63];
            i += 3;
            i2 += 4;
        }
        return new String(bArr);
    }

    private boolean a(byte b2) {
        if (b2 == 36) {
            return true;
        }
        return b2 >= 0 && b2 < 128 && f8526b[b2] != -1;
    }
}
