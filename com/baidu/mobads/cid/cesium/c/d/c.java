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
    public static final byte[] f8167a = new byte[0];

    /* renamed from: b  reason: collision with root package name */
    public int f8168b;

    /* renamed from: c  reason: collision with root package name */
    public String f8169c = "PKCS1Padding";

    /* renamed from: d  reason: collision with root package name */
    public f f8170d;

    /* renamed from: e  reason: collision with root package name */
    public byte[] f8171e;

    /* renamed from: f  reason: collision with root package name */
    public int f8172f;

    /* renamed from: g  reason: collision with root package name */
    public int f8173g;

    /* renamed from: h  reason: collision with root package name */
    public d f8174h;

    /* JADX WARN: Removed duplicated region for block: B:14:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(int i2, d dVar, SecureRandom secureRandom, AlgorithmParameterSpec algorithmParameterSpec) {
        boolean z;
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        throw new InvalidKeyException("Unknown mode: " + i2);
                    }
                }
            }
            z = false;
            if (dVar instanceof d) {
                throw new InvalidKeyException("only support helios key");
            }
            this.f8168b = z ? 1 : 4;
            this.f8174h = dVar;
            int a2 = b.a(dVar.a());
            this.f8173g = a2;
            this.f8172f = 0;
            String str = this.f8169c;
            if (str == "NoPadding") {
                if (algorithmParameterSpec != null) {
                    throw new InvalidAlgorithmParameterException("Parameters not supported");
                }
                this.f8170d = f.a(3, a2, secureRandom);
                this.f8171e = new byte[a2];
                return;
            } else if (str != "PKCS1Padding") {
                throw new InvalidKeyException("OAEP not supported");
            } else {
                if (algorithmParameterSpec != null) {
                    throw new InvalidAlgorithmParameterException("Parameters not supported");
                }
                f a3 = f.a(this.f8168b > 2 ? 1 : 2, a2, secureRandom);
                this.f8170d = a3;
                if (z) {
                    this.f8171e = new byte[a3.a()];
                    return;
                } else {
                    this.f8171e = new byte[a2];
                    return;
                }
            }
        }
        z = true;
        if (dVar instanceof d) {
        }
    }

    private byte[] a() {
        int i2 = this.f8172f;
        byte[] bArr = this.f8171e;
        if (i2 > bArr.length) {
            throw new IllegalBlockSizeException("Data must not be longer than " + this.f8171e.length + " bytes");
        }
        try {
            int i3 = this.f8168b;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 == 4) {
                            return this.f8170d.b(b.a(b.a(bArr, 0, i2), this.f8174h));
                        }
                        throw new AssertionError("Internal error");
                    }
                    throw new UnsupportedOperationException("only verify supported");
                }
                throw new UnsupportedOperationException("only verify supported");
            }
            return b.a(this.f8170d.a(bArr, 0, i2), this.f8174h);
        } finally {
            this.f8172f = 0;
        }
    }

    private void b(byte[] bArr, int i2, int i3) {
        int i4;
        if (i3 == 0 || bArr == null) {
            return;
        }
        int i5 = this.f8172f;
        int i6 = i5 + i3;
        byte[] bArr2 = this.f8171e;
        if (i6 > bArr2.length) {
            i4 = bArr2.length + 1;
        } else {
            System.arraycopy(bArr, i2, bArr2, i5, i3);
            i4 = this.f8172f + i3;
        }
        this.f8172f = i4;
    }

    public void a(int i2, d dVar, SecureRandom secureRandom) {
        try {
            a(i2, dVar, secureRandom, null);
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
        this.f8169c = str2;
    }

    public byte[] a(byte[] bArr, int i2, int i3) {
        b(bArr, i2, i3);
        return a();
    }
}
