package com.baidu.swan.games.bdtls.model;

import java.util.Arrays;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes10.dex */
public final class h {
    public static final a dDM = new a(null);
    private byte[] content;
    private byte[] dDF;
    private byte[] dDG;
    private byte dDH;
    private byte dDI;
    private short dDJ;
    private int dDK;
    private byte[] dDL;

    public h() {
        this(null, null, (byte) 0, (byte) 0, (short) 0, 0, null, null, 255, null);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof h)) {
                return false;
            }
            h hVar = (h) obj;
            if (!q.l(this.dDF, hVar.dDF) || !q.l(this.dDG, hVar.dDG)) {
                return false;
            }
            if (!(this.dDH == hVar.dDH)) {
                return false;
            }
            if (!(this.dDI == hVar.dDI)) {
                return false;
            }
            if (!(this.dDJ == hVar.dDJ)) {
                return false;
            }
            if (!(this.dDK == hVar.dDK) || !q.l(this.dDL, hVar.dDL) || !q.l(this.content, hVar.content)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        byte[] bArr = this.dDF;
        int hashCode = (bArr != null ? Arrays.hashCode(bArr) : 0) * 31;
        byte[] bArr2 = this.dDG;
        int hashCode2 = ((((((((((bArr2 != null ? Arrays.hashCode(bArr2) : 0) + hashCode) * 31) + this.dDH) * 31) + this.dDI) * 31) + this.dDJ) * 31) + this.dDK) * 31;
        byte[] bArr3 = this.dDL;
        int hashCode3 = ((bArr3 != null ? Arrays.hashCode(bArr3) : 0) + hashCode2) * 31;
        byte[] bArr4 = this.content;
        return hashCode3 + (bArr4 != null ? Arrays.hashCode(bArr4) : 0);
    }

    public h(byte[] bArr, byte[] bArr2, byte b, byte b2, short s, int i, byte[] bArr3, byte[] bArr4) {
        this.dDF = bArr;
        this.dDG = bArr2;
        this.dDH = b;
        this.dDI = b2;
        this.dDJ = s;
        this.dDK = i;
        this.dDL = bArr3;
        this.content = bArr4;
    }

    public /* synthetic */ h(byte[] bArr, byte[] bArr2, byte b, byte b2, short s, int i, byte[] bArr3, byte[] bArr4, int i2, o oVar) {
        this((i2 & 1) != 0 ? new byte[2] : bArr, (i2 & 2) != 0 ? new byte[2] : bArr2, (i2 & 4) != 0 ? (byte) 0 : b, (i2 & 8) != 0 ? (byte) 0 : b2, (i2 & 16) != 0 ? (short) 0 : s, (i2 & 32) != 0 ? 0 : i, (i2 & 64) != 0 ? null : bArr3, (i2 & 128) != 0 ? null : bArr4);
    }

    public final void R(byte[] bArr) {
        this.dDF = bArr;
    }

    public final byte[] aPx() {
        return this.dDF;
    }

    public final void S(byte[] bArr) {
        this.dDG = bArr;
    }

    public final byte[] aPy() {
        return this.dDG;
    }

    public final byte aPz() {
        return this.dDH;
    }

    public final void c(byte b) {
        this.dDH = b;
    }

    public final byte aPA() {
        return this.dDI;
    }

    public final void d(byte b) {
        this.dDI = b;
    }

    public final short aPB() {
        return this.dDJ;
    }

    public final void c(short s) {
        this.dDJ = s;
    }

    public final int aPC() {
        return this.dDK;
    }

    public final void lF(int i) {
        this.dDK = i;
    }

    public final void T(byte[] bArr) {
        this.dDL = bArr;
    }

    public final byte[] aPD() {
        return this.dDL;
    }

    public final byte[] getContent() {
        return this.content;
    }

    public final void setContent(byte[] bArr) {
        this.content = bArr;
    }

    @kotlin.h
    /* loaded from: classes10.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(o oVar) {
            this();
        }

        public final h aPE() {
            h hVar = new h(null, null, (byte) 0, (byte) 0, (short) 0, 0, null, null, 255, null);
            hVar.R(new byte[2]);
            byte[] aPx = hVar.aPx();
            if (aPx != null) {
                aPx[0] = 0;
            }
            byte[] aPx2 = hVar.aPx();
            if (aPx2 != null) {
                aPx2[1] = 2;
            }
            hVar.S(new byte[2]);
            byte[] aPy = hVar.aPy();
            if (aPy != null) {
                aPy[0] = -27;
            }
            byte[] aPy2 = hVar.aPy();
            if (aPy2 != null) {
                aPy2[1] = -89;
            }
            return hVar;
        }
    }

    public String toString() {
        return "RecordParams(protocolVersion=" + Arrays.toString(this.dDF) + ", schemeType=" + ((int) this.dDH) + ", schemeExtType=" + ((int) this.dDI) + ", schemeLen=" + ((int) this.dDJ) + ", contentLen=" + this.dDK + ", scheme=" + Arrays.toString(this.dDL) + ')';
    }
}
