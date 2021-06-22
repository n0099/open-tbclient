package com.baidu.protect.crypto;

import d.a.e0.a.a;
/* loaded from: classes2.dex */
public class WBAESCipherImplement extends a {

    /* renamed from: a  reason: collision with root package name */
    public long f9458a;

    static {
        System.loadLibrary("baiduprotect_sec_jni");
    }

    public static a c() {
        return new WBAESCipherImplement();
    }

    private native int decrypt(long j, byte[] bArr, byte[] bArr2, int i2);

    private native int decryptFile(long j, String str, String str2, int i2);

    private native int destroyContext(long j);

    private native int encrypt(long j, byte[] bArr, byte[] bArr2, int i2);

    private native int encryptFile(long j, String str, String str2, int i2);

    private native long initKeyDataFile(String str, String str2);

    private native long initKeyDataMemory(byte[] bArr, byte[] bArr2);

    @Override // d.a.e0.a.a
    public final boolean a(byte[] bArr) {
        long initKeyDataMemory = initKeyDataMemory(bArr, null);
        this.f9458a = initKeyDataMemory;
        return initKeyDataMemory > 0;
    }

    @Override // d.a.e0.a.a
    public final boolean b(byte[] bArr, byte[] bArr2, int i2) throws b {
        long j = this.f9458a;
        if (j <= 0) {
            return false;
        }
        int encrypt = encrypt(j, bArr, bArr2, i2);
        if (encrypt == -2 || encrypt == -1) {
            throw new b("invalid param");
        }
        if (encrypt == 0) {
            return true;
        }
        throw new b("decrypt fail reason:" + encrypt);
    }
}
