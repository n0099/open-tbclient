package com.baidu.fsg.base.utils;

import android.os.Build;
import android.util.Base64;
import java.io.IOException;
/* loaded from: classes10.dex */
public class Base64Utils {
    private static final Boolean a;

    static {
        a = Boolean.valueOf(Build.VERSION.SDK_INT >= 8);
    }

    public static byte[] encode(byte[] bArr) {
        return a.booleanValue() ? Base64.encode(bArr, 2) : com.baidu.fsg.base.utils.support.Base64.encodeBytesToBytes(bArr);
    }

    public static String encodeToString(byte[] bArr) {
        return a.booleanValue() ? Base64.encodeToString(bArr, 2) : com.baidu.fsg.base.utils.support.Base64.encodeBytes(bArr);
    }

    public static byte[] decode(byte[] bArr) {
        if (a.booleanValue()) {
            return Base64.decode(bArr, 2);
        }
        try {
            return com.baidu.fsg.base.utils.support.Base64.decode(bArr);
        } catch (IOException e) {
            throw new IllegalArgumentException(e.getLocalizedMessage());
        }
    }

    public static byte[] decode(String str) {
        if (a.booleanValue()) {
            return Base64.decode(str, 2);
        }
        try {
            return com.baidu.fsg.base.utils.support.Base64.decode(str);
        } catch (IOException e) {
            throw new IllegalArgumentException(e.getLocalizedMessage());
        }
    }
}
