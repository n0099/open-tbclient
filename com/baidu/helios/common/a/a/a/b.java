package com.baidu.helios.common.a.a.a;

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
/* loaded from: classes3.dex */
public final class b {
    private static final byte[] a = new byte[0];
    private d arO;
    private com.baidu.helios.common.a.b.a arP;
    private int i;
    private byte[] m;
    private int n;
    private int o;
    private OAEPParameterSpec akG = null;
    private String q = "SHA-1";
    private String j = "PKCS1Padding";

    private void a(int i, com.baidu.helios.common.a.b.a aVar, SecureRandom secureRandom, AlgorithmParameterSpec algorithmParameterSpec) {
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
        if (!(aVar instanceof com.baidu.helios.common.a.b.a)) {
            throw new InvalidKeyException("only support helios key");
        }
        this.i = z ? 1 : 4;
        this.arP = aVar;
        int a2 = a.a(this.arP.getModulus());
        this.o = a2;
        this.n = 0;
        if (this.j == "NoPadding") {
            if (algorithmParameterSpec != null) {
                throw new InvalidAlgorithmParameterException("Parameters not supported");
            }
            this.arO = d.b(3, a2, secureRandom);
            this.m = new byte[a2];
        } else if (this.j == "PKCS1Padding") {
            if (algorithmParameterSpec != null) {
                throw new InvalidAlgorithmParameterException("Parameters not supported");
            }
            this.arO = d.b(this.i <= 2 ? 2 : 1, a2, secureRandom);
            if (z) {
                this.m = new byte[this.arO.a()];
            } else {
                this.m = new byte[a2];
            }
        } else if (this.i == 3 || this.i == 4) {
            throw new InvalidKeyException("OAEP cannot be used to sign or verify signatures");
        } else {
            if (algorithmParameterSpec == null) {
                oAEPParameterSpec = new OAEPParameterSpec(this.q, "MGF1", MGF1ParameterSpec.SHA1, PSource.PSpecified.DEFAULT);
            } else if (!(algorithmParameterSpec instanceof OAEPParameterSpec)) {
                throw new InvalidAlgorithmParameterException("Wrong Parameters for OAEP Padding");
            } else {
                oAEPParameterSpec = (OAEPParameterSpec) algorithmParameterSpec;
            }
            this.arO = d.b(4, a2, secureRandom, oAEPParameterSpec);
            if (z) {
                this.m = new byte[this.arO.a()];
            } else {
                this.m = new byte[a2];
            }
        }
    }

    private byte[] a() {
        byte[] a2;
        if (this.n > this.m.length) {
            throw new IllegalBlockSizeException("Data must not be longer than " + this.m.length + " bytes");
        }
        try {
            switch (this.i) {
                case 1:
                    a2 = a.a(this.arO.l(this.m, 0, this.n), this.arP);
                    break;
                case 2:
                    throw new UnsupportedOperationException("only verify supported");
                case 3:
                    throw new UnsupportedOperationException("only verify supported");
                case 4:
                    a2 = this.arO.b(a.a(a.l(this.m, 0, this.n), this.arP));
                    break;
                default:
                    throw new AssertionError("Internal error");
            }
            return a2;
        } finally {
            this.n = 0;
        }
    }

    private void b(byte[] bArr, int i, int i2) {
        if (i2 == 0 || bArr == null) {
            return;
        }
        if (this.n + i2 > this.m.length) {
            this.n = this.m.length + 1;
            return;
        }
        System.arraycopy(bArr, i, this.m, this.n, i2);
        this.n += i2;
    }

    public void a(int i, com.baidu.helios.common.a.b.a aVar, SecureRandom secureRandom) {
        try {
            a(i, aVar, secureRandom, null);
        } catch (InvalidAlgorithmParameterException e) {
            InvalidKeyException invalidKeyException = new InvalidKeyException("Wrong parameters");
            invalidKeyException.initCause(e);
            throw invalidKeyException;
        }
    }

    public void b(String str) {
        if (str.equalsIgnoreCase("NoPadding")) {
            this.j = "NoPadding";
        } else if (str.equalsIgnoreCase("PKCS1Padding")) {
            this.j = "PKCS1Padding";
        } else {
            String lowerCase = str.toLowerCase(Locale.ENGLISH);
            if (lowerCase.equals("oaeppadding")) {
                this.j = "OAEP";
            } else if (!lowerCase.startsWith("oaepwith") || !lowerCase.endsWith("andmgf1padding")) {
                throw new NoSuchPaddingException("Padding " + str + " not supported");
            } else {
                this.j = "OAEP";
                this.q = str.substring(8, str.length() - 14);
                throw new NoSuchPaddingException("MessageDigest not available for " + str);
            }
        }
    }

    public byte[] l(byte[] bArr, int i, int i2) {
        b(bArr, i, i2);
        return a();
    }
}
