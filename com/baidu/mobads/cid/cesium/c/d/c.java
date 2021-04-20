package com.baidu.mobads.cid.cesium.c.d;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f8162a = new byte[0];

    /* renamed from: b  reason: collision with root package name */
    public int f8163b;

    /* renamed from: c  reason: collision with root package name */
    public String f8164c = "PKCS1Padding";

    /* renamed from: d  reason: collision with root package name */
    public f f8165d;

    /* renamed from: e  reason: collision with root package name */
    public byte[] f8166e;

    /* renamed from: f  reason: collision with root package name */
    public int f8167f;

    /* renamed from: g  reason: collision with root package name */
    public int f8168g;

    /* renamed from: h  reason: collision with root package name */
    public d f8169h;

    /* JADX WARN: Removed duplicated region for block: B:14:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(int i, d dVar, SecureRandom secureRandom, AlgorithmParameterSpec algorithmParameterSpec) {
        boolean z;
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        throw new InvalidKeyException("Unknown mode: " + i);
                    }
                }
            }
            z = false;
            if (dVar instanceof d) {
                throw new InvalidKeyException("only support helios key");
            }
            this.f8163b = z ? 1 : 4;
            this.f8169h = dVar;
            int a2 = b.a(dVar.a());
            this.f8168g = a2;
            this.f8167f = 0;
            String str = this.f8164c;
            if (str == "NoPadding") {
                if (algorithmParameterSpec != null) {
                    throw new InvalidAlgorithmParameterException("Parameters not supported");
                }
                this.f8165d = f.a(3, a2, secureRandom);
                this.f8166e = new byte[a2];
                return;
            } else if (str != "PKCS1Padding") {
                throw new InvalidKeyException("OAEP not supported");
            } else {
                if (algorithmParameterSpec != null) {
                    throw new InvalidAlgorithmParameterException("Parameters not supported");
                }
                f a3 = f.a(this.f8163b > 2 ? 1 : 2, a2, secureRandom);
                this.f8165d = a3;
                if (z) {
                    this.f8166e = new byte[a3.a()];
                    return;
                } else {
                    this.f8166e = new byte[a2];
                    return;
                }
            }
        }
        z = true;
        if (dVar instanceof d) {
        }
    }

    private byte[] a() {
        int i = this.f8167f;
        byte[] bArr = this.f8166e;
        if (i > bArr.length) {
            throw new IllegalBlockSizeException("Data must not be longer than " + this.f8166e.length + " bytes");
        }
        try {
            int i2 = this.f8163b;
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 == 4) {
                            return this.f8165d.b(b.a(b.a(bArr, 0, i), this.f8169h));
                        }
                        throw new AssertionError("Internal error");
                    }
                    throw new UnsupportedOperationException("only verify supported");
                }
                throw new UnsupportedOperationException("only verify supported");
            }
            return b.a(this.f8165d.a(bArr, 0, i), this.f8169h);
        } finally {
            this.f8167f = 0;
        }
    }

    private void b(byte[] bArr, int i, int i2) {
        int i3;
        if (i2 == 0 || bArr == null) {
            return;
        }
        int i4 = this.f8167f;
        int i5 = i4 + i2;
        byte[] bArr2 = this.f8166e;
        if (i5 > bArr2.length) {
            i3 = bArr2.length + 1;
        } else {
            System.arraycopy(bArr, i, bArr2, i4, i2);
            i3 = this.f8167f + i2;
        }
        this.f8167f = i3;
    }

    public void a(int i, d dVar, SecureRandom secureRandom) {
        try {
            a(i, dVar, secureRandom, null);
        } catch (InvalidAlgorithmParameterException e2) {
            InvalidKeyException invalidKeyException = new InvalidKeyException("Wrong parameters");
            invalidKeyException.initCause(e2);
            throw invalidKeyException;
        }
    }

    public void a(String str) {
        String str2 = "NoPadding";
        if (!str.equalsIgnoreCase("NoPadding")) {
            str2 = "PKCS1Padding";
            if (!str.equalsIgnoreCase("PKCS1Padding")) {
                throw new NoSuchPaddingException("Padding " + str + " not supported");
            }
        }
        this.f8164c = str2;
    }

    public byte[] a(byte[] bArr, int i, int i2) {
        b(bArr, i, i2);
        return a();
    }
}
