package com.baidu.ar.util;

import java.io.UnsupportedEncodingException;
/* loaded from: classes3.dex */
public final class h {
    public static String a(byte[] bArr, int i, int i2, String str) {
        if (bArr == null) {
            throw new IllegalArgumentException("Parameter may not be null");
        }
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("charset may not be null or empty");
        }
        try {
            return new String(bArr, i, i2, str);
        } catch (UnsupportedEncodingException e) {
            return new String(bArr, i, i2);
        }
    }

    public static String a(byte[] bArr, String str) {
        if (bArr == null) {
            throw new IllegalArgumentException("Parameter may not be null");
        }
        return a(bArr, 0, bArr.length, str);
    }
}
