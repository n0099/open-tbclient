package com.baidu.swan.games.bdtls.model;

import java.util.Arrays;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes3.dex */
public final class h {
    public static final a drJ = new a(null);
    private byte[] content;
    private byte[] drC;
    private byte[] drD;
    private byte drE;
    private byte drF;
    private short drG;
    private int drH;
    private byte[] drI;

    public h() {
        this(null, null, (byte) 0, (byte) 0, (short) 0, 0, null, null, 255, null);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof h)) {
                return false;
            }
            h hVar = (h) obj;
            if (!q.l(this.drC, hVar.drC) || !q.l(this.drD, hVar.drD)) {
                return false;
            }
            if (!(this.drE == hVar.drE)) {
                return false;
            }
            if (!(this.drF == hVar.drF)) {
                return false;
            }
            if (!(this.drG == hVar.drG)) {
                return false;
            }
            if (!(this.drH == hVar.drH) || !q.l(this.drI, hVar.drI) || !q.l(this.content, hVar.content)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        byte[] bArr = this.drC;
        int hashCode = (bArr != null ? Arrays.hashCode(bArr) : 0) * 31;
        byte[] bArr2 = this.drD;
        int hashCode2 = ((((((((((bArr2 != null ? Arrays.hashCode(bArr2) : 0) + hashCode) * 31) + this.drE) * 31) + this.drF) * 31) + this.drG) * 31) + this.drH) * 31;
        byte[] bArr3 = this.drI;
        int hashCode3 = ((bArr3 != null ? Arrays.hashCode(bArr3) : 0) + hashCode2) * 31;
        byte[] bArr4 = this.content;
        return hashCode3 + (bArr4 != null ? Arrays.hashCode(bArr4) : 0);
    }

    public h(byte[] bArr, byte[] bArr2, byte b, byte b2, short s, int i, byte[] bArr3, byte[] bArr4) {
        this.drC = bArr;
        this.drD = bArr2;
        this.drE = b;
        this.drF = b2;
        this.drG = s;
        this.drH = i;
        this.drI = bArr3;
        this.content = bArr4;
    }

    public /* synthetic */ h(byte[] bArr, byte[] bArr2, byte b, byte b2, short s, int i, byte[] bArr3, byte[] bArr4, int i2, o oVar) {
        this((i2 & 1) != 0 ? new byte[2] : bArr, (i2 & 2) != 0 ? new byte[2] : bArr2, (i2 & 4) != 0 ? (byte) 0 : b, (i2 & 8) != 0 ? (byte) 0 : b2, (i2 & 16) != 0 ? (short) 0 : s, (i2 & 32) != 0 ? 0 : i, (i2 & 64) != 0 ? null : bArr3, (i2 & 128) != 0 ? null : bArr4);
    }

    public final void R(byte[] bArr) {
        this.drC = bArr;
    }

    public final byte[] aMO() {
        return this.drC;
    }

    public final void S(byte[] bArr) {
        this.drD = bArr;
    }

    public final byte[] aMP() {
        return this.drD;
    }

    public final byte aMQ() {
        return this.drE;
    }

    public final void c(byte b) {
        this.drE = b;
    }

    public final byte aMR() {
        return this.drF;
    }

    public final void d(byte b) {
        this.drF = b;
    }

    public final short aMS() {
        return this.drG;
    }

    public final void c(short s) {
        this.drG = s;
    }

    public final int aMT() {
        return this.drH;
    }

    public final void li(int i) {
        this.drH = i;
    }

    public final void T(byte[] bArr) {
        this.drI = bArr;
    }

    public final byte[] aMU() {
        return this.drI;
    }

    public final byte[] getContent() {
        return this.content;
    }

    public final void setContent(byte[] bArr) {
        this.content = bArr;
    }

    @kotlin.h
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(o oVar) {
            this();
        }

        public final h aMV() {
            h hVar = new h(null, null, (byte) 0, (byte) 0, (short) 0, 0, null, null, 255, null);
            hVar.R(new byte[2]);
            byte[] aMO = hVar.aMO();
            if (aMO != null) {
                aMO[0] = 0;
            }
            byte[] aMO2 = hVar.aMO();
            if (aMO2 != null) {
                aMO2[1] = 2;
            }
            hVar.S(new byte[2]);
            byte[] aMP = hVar.aMP();
            if (aMP != null) {
                aMP[0] = -27;
            }
            byte[] aMP2 = hVar.aMP();
            if (aMP2 != null) {
                aMP2[1] = -89;
            }
            return hVar;
        }
    }

    public String toString() {
        return "RecordParams(protocolVersion=" + Arrays.toString(this.drC) + ", schemeType=" + ((int) this.drE) + ", schemeExtType=" + ((int) this.drF) + ", schemeLen=" + ((int) this.drG) + ", contentLen=" + this.drH + ", scheme=" + Arrays.toString(this.drI) + ')';
    }
}
