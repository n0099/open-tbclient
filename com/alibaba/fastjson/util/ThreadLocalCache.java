package com.alibaba.fastjson.util;

import java.lang.ref.SoftReference;
import java.nio.charset.CharsetDecoder;
/* loaded from: classes.dex */
public class ThreadLocalCache {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int BYTES_CACH_INIT_SIZE = 1024;
    public static final int BYTES_CACH_INIT_SIZE_EXP = 10;
    public static final int BYTES_CACH_MAX_SIZE = 131072;
    public static final int BYTES_CACH_MAX_SIZE_EXP = 17;
    public static final int CHARS_CACH_INIT_SIZE = 1024;
    public static final int CHARS_CACH_INIT_SIZE_EXP = 10;
    public static final int CHARS_CACH_MAX_SIZE = 131072;
    public static final int CHARS_CACH_MAX_SIZE_EXP = 17;
    public static final ThreadLocal<SoftReference<char[]>> charsBufLocal = new ThreadLocal<>();
    public static final ThreadLocal<CharsetDecoder> decoderLocal = new ThreadLocal<>();
    public static final ThreadLocal<SoftReference<byte[]>> bytesBufLocal = new ThreadLocal<>();

    public static char[] allocate(int i2) {
        if (i2 > 131072) {
            return new char[i2];
        }
        char[] cArr = new char[getAllocateLengthExp(10, 17, i2)];
        charsBufLocal.set(new SoftReference<>(cArr));
        return cArr;
    }

    public static byte[] allocateBytes(int i2) {
        if (i2 > 131072) {
            return new byte[i2];
        }
        byte[] bArr = new byte[getAllocateLengthExp(10, 17, i2)];
        bytesBufLocal.set(new SoftReference<>(bArr));
        return bArr;
    }

    public static void clearBytes() {
        bytesBufLocal.set(null);
    }

    public static void clearChars() {
        charsBufLocal.set(null);
    }

    public static int getAllocateLengthExp(int i2, int i3, int i4) {
        return (i4 >>> i2) <= 0 ? 1 << i2 : 1 << (32 - Integer.numberOfLeadingZeros(i4 - 1));
    }

    public static byte[] getBytes(int i2) {
        SoftReference<byte[]> softReference = bytesBufLocal.get();
        if (softReference == null) {
            return allocateBytes(i2);
        }
        byte[] bArr = softReference.get();
        if (bArr == null) {
            return allocateBytes(i2);
        }
        return bArr.length < i2 ? allocateBytes(i2) : bArr;
    }

    public static char[] getChars(int i2) {
        SoftReference<char[]> softReference = charsBufLocal.get();
        if (softReference == null) {
            return allocate(i2);
        }
        char[] cArr = softReference.get();
        if (cArr == null) {
            return allocate(i2);
        }
        return cArr.length < i2 ? allocate(i2) : cArr;
    }

    public static CharsetDecoder getUTF8Decoder() {
        CharsetDecoder charsetDecoder = decoderLocal.get();
        if (charsetDecoder == null) {
            UTF8Decoder uTF8Decoder = new UTF8Decoder();
            decoderLocal.set(uTF8Decoder);
            return uTF8Decoder;
        }
        return charsetDecoder;
    }
}
