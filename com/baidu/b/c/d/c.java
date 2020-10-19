package com.baidu.b.c.d;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.MGF1ParameterSpec;
import java.util.Locale;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;
/* loaded from: classes7.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f1263a = new byte[0];
    private f adC;
    private d adE;
    private int b;
    private byte[] f;
    private int g;
    private int h;
    private OAEPParameterSpec adD = null;
    private String j = "SHA-1";
    private String c = "PKCS1Padding";

    private void a(int i, d dVar, SecureRandom secureRandom, AlgorithmParameterSpec algorithmParameterSpec) {
        boolean z;
        OAEPParameterSpec oAEPParameterSpec;
        switch (i) {
            case 1:
            case 3:
                z = true;
                break;
            case 2:
            case 4:
                z = false;
                break;
            default:
                throw new InvalidKeyException("Unknown mode: " + i);
        }
        if (!(dVar instanceof d)) {
            throw new InvalidKeyException("only support helios key");
        }
        this.b = z ? 1 : 4;
        this.adE = dVar;
        int a2 = b.a(this.adE.sM());
        this.h = a2;
        this.g = 0;
        if (this.c == "NoPadding") {
            if (algorithmParameterSpec != null) {
                throw new InvalidAlgorithmParameterException("Parameters not supported");
            }
            this.adC = f.a(3, a2, secureRandom);
            this.f = new byte[a2];
        } else if (this.c == "PKCS1Padding") {
            if (algorithmParameterSpec != null) {
                throw new InvalidAlgorithmParameterException("Parameters not supported");
            }
            this.adC = f.a(this.b <= 2 ? 2 : 1, a2, secureRandom);
            if (z) {
                this.f = new byte[this.adC.a()];
            } else {
                this.f = new byte[a2];
            }
        } else if (this.b == 3 || this.b == 4) {
            throw new InvalidKeyException("OAEP cannot be used to sign or verify signatures");
        } else {
            if (algorithmParameterSpec == null) {
                oAEPParameterSpec = new OAEPParameterSpec(this.j, "MGF1", MGF1ParameterSpec.SHA1, PSource.PSpecified.DEFAULT);
            } else if (!(algorithmParameterSpec instanceof OAEPParameterSpec)) {
                throw new InvalidAlgorithmParameterException("Wrong Parameters for OAEP Padding");
            } else {
                oAEPParameterSpec = (OAEPParameterSpec) algorithmParameterSpec;
            }
            this.adC = f.a(4, a2, secureRandom, oAEPParameterSpec);
            if (z) {
                this.f = new byte[this.adC.a()];
            } else {
                this.f = new byte[a2];
            }
        }
    }

    private byte[] a() {
        byte[] a2;
        if (this.g > this.f.length) {
            throw new IllegalBlockSizeException("Data must not be longer than " + this.f.length + " bytes");
        }
        try {
            switch (this.b) {
                case 1:
                    a2 = b.a(this.adC.k(this.f, 0, this.g), this.adE);
                    break;
                case 2:
                    throw new UnsupportedOperationException("only verify supported");
                case 3:
                    throw new UnsupportedOperationException("only verify supported");
                case 4:
                    a2 = this.adC.b(b.a(b.k(this.f, 0, this.g), this.adE));
                    break;
                default:
                    throw new AssertionError("Internal error");
            }
            return a2;
        } finally {
            this.g = 0;
        }
    }

    private void b(byte[] bArr, int i, int i2) {
        if (i2 == 0 || bArr == null) {
            return;
        }
        if (this.g + i2 > this.f.length) {
            this.g = this.f.length + 1;
            return;
        }
        System.arraycopy(bArr, i, this.f, this.g, i2);
        this.g += i2;
    }

    public void a(int i, d dVar, SecureRandom secureRandom) {
        try {
            a(i, dVar, secureRandom, null);
        } catch (InvalidAlgorithmParameterException e) {
            InvalidKeyException invalidKeyException = new InvalidKeyException("Wrong parameters");
            invalidKeyException.initCause(e);
            throw invalidKeyException;
        }
    }

    public void a(String str) {
        if (str.equalsIgnoreCase("NoPadding")) {
            this.c = "NoPadding";
        } else if (str.equalsIgnoreCase("PKCS1Padding")) {
            this.c = "PKCS1Padding";
        } else {
            String lowerCase = str.toLowerCase(Locale.ENGLISH);
            if (lowerCase.equals("oaeppadding")) {
                this.c = "OAEP";
            } else if (!lowerCase.startsWith("oaepwith") || !lowerCase.endsWith("andmgf1padding")) {
                throw new NoSuchPaddingException("Padding " + str + " not supported");
            } else {
                this.c = "OAEP";
                this.j = str.substring(8, str.length() - 14);
                throw new NoSuchPaddingException("MessageDigest not available for " + str);
            }
        }
    }

    public byte[] k(byte[] bArr, int i, int i2) {
        b(bArr, i, i2);
        return a();
    }
}
