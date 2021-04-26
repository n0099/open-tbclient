package com.baidu.apollon.utils;

import android.os.Build;
import android.util.Base64;
import java.io.IOException;
/* loaded from: classes.dex */
public class Base64Utils {

    /* renamed from: a  reason: collision with root package name */
    public static final Boolean f4011a;

    static {
        f4011a = Boolean.valueOf(Build.VERSION.SDK_INT >= 8);
    }

    public static byte[] decode(byte[] bArr) {
        if (f4011a.booleanValue()) {
            return Base64.decode(bArr, 2);
        }
        try {
            return com.baidu.apollon.utils.support.Base64.decode(bArr);
        } catch (IOException e2) {
            throw new IllegalArgumentException(e2.getLocalizedMessage());
        }
    }

    public static byte[] encode(byte[] bArr) {
        if (f4011a.booleanValue()) {
            return Base64.encode(bArr, 2);
        }
        return com.baidu.apollon.utils.support.Base64.encodeBytesToBytes(bArr);
    }

    public static String encodeToString(byte[] bArr) {
        if (f4011a.booleanValue()) {
            return Base64.encodeToString(bArr, 2);
        }
        return com.baidu.apollon.utils.support.Base64.encodeBytes(bArr);
    }

    public static byte[] decode(String str) {
        if (f4011a.booleanValue()) {
            return Base64.decode(str, 2);
        }
        try {
            return com.baidu.apollon.utils.support.Base64.decode(str);
        } catch (IOException e2) {
            throw new IllegalArgumentException(e2.getLocalizedMessage());
        }
    }
}
