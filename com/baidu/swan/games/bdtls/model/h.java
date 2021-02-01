package com.baidu.swan.games.bdtls.model;

import java.util.Arrays;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.p;
@kotlin.e
/* loaded from: classes9.dex */
public final class h {
    public static final a edJ = new a(null);
    private byte[] content;
    private byte[] edC;
    private byte[] edD;
    private byte edE;
    private byte edF;
    private short edG;
    private int edH;
    private byte[] edI;

    public h() {
        this(null, null, (byte) 0, (byte) 0, (short) 0, 0, null, null, 255, null);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof h)) {
                return false;
            }
            h hVar = (h) obj;
            if (!p.l(this.edC, hVar.edC) || !p.l(this.edD, hVar.edD)) {
                return false;
            }
            if (!(this.edE == hVar.edE)) {
                return false;
            }
            if (!(this.edF == hVar.edF)) {
                return false;
            }
            if (!(this.edG == hVar.edG)) {
                return false;
            }
            if (!(this.edH == hVar.edH) || !p.l(this.edI, hVar.edI) || !p.l(this.content, hVar.content)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        byte[] bArr = this.edC;
        int hashCode = (bArr != null ? Arrays.hashCode(bArr) : 0) * 31;
        byte[] bArr2 = this.edD;
        int hashCode2 = ((((((((((bArr2 != null ? Arrays.hashCode(bArr2) : 0) + hashCode) * 31) + this.edE) * 31) + this.edF) * 31) + this.edG) * 31) + this.edH) * 31;
        byte[] bArr3 = this.edI;
        int hashCode3 = ((bArr3 != null ? Arrays.hashCode(bArr3) : 0) + hashCode2) * 31;
        byte[] bArr4 = this.content;
        return hashCode3 + (bArr4 != null ? Arrays.hashCode(bArr4) : 0);
    }

    public h(byte[] bArr, byte[] bArr2, byte b2, byte b3, short s, int i, byte[] bArr3, byte[] bArr4) {
        this.edC = bArr;
        this.edD = bArr2;
        this.edE = b2;
        this.edF = b3;
        this.edG = s;
        this.edH = i;
        this.edI = bArr3;
        this.content = bArr4;
    }

    public /* synthetic */ h(byte[] bArr, byte[] bArr2, byte b2, byte b3, short s, int i, byte[] bArr3, byte[] bArr4, int i2, o oVar) {
        this((i2 & 1) != 0 ? new byte[2] : bArr, (i2 & 2) != 0 ? new byte[2] : bArr2, (i2 & 4) != 0 ? (byte) 0 : b2, (i2 & 8) != 0 ? (byte) 0 : b3, (i2 & 16) != 0 ? (short) 0 : s, (i2 & 32) != 0 ? 0 : i, (i2 & 64) != 0 ? null : bArr3, (i2 & 128) != 0 ? null : bArr4);
    }

    public final void O(byte[] bArr) {
        this.edC = bArr;
    }

    public final byte[] aVb() {
        return this.edC;
    }

    public final void P(byte[] bArr) {
        this.edD = bArr;
    }

    public final byte[] aVc() {
        return this.edD;
    }

    public final byte aVd() {
        return this.edE;
    }

    public final void c(byte b2) {
        this.edE = b2;
    }

    public final byte aVe() {
        return this.edF;
    }

    public final void d(byte b2) {
        this.edF = b2;
    }

    public final short aVf() {
        return this.edG;
    }

    public final void d(short s) {
        this.edG = s;
    }

    public final int aVg() {
        return this.edH;
    }

    public final void kZ(int i) {
        this.edH = i;
    }

    public final void Q(byte[] bArr) {
        this.edI = bArr;
    }

    public final byte[] aVh() {
        return this.edI;
    }

    public final byte[] getContent() {
        return this.content;
    }

    public final void setContent(byte[] bArr) {
        this.content = bArr;
    }

    @kotlin.e
    /* loaded from: classes9.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(o oVar) {
            this();
        }

        public final h aVi() {
            h hVar = new h(null, null, (byte) 0, (byte) 0, (short) 0, 0, null, null, 255, null);
            hVar.O(new byte[2]);
            byte[] aVb = hVar.aVb();
            if (aVb != null) {
                aVb[0] = 0;
            }
            byte[] aVb2 = hVar.aVb();
            if (aVb2 != null) {
                aVb2[1] = 2;
            }
            hVar.P(new byte[2]);
            byte[] aVc = hVar.aVc();
            if (aVc != null) {
                aVc[0] = -27;
            }
            byte[] aVc2 = hVar.aVc();
            if (aVc2 != null) {
                aVc2[1] = -89;
            }
            return hVar;
        }
    }

    public String toString() {
        return "RecordParams(protocolVersion=" + Arrays.toString(this.edC) + ", schemeType=" + ((int) this.edE) + ", schemeExtType=" + ((int) this.edF) + ", schemeLen=" + ((int) this.edG) + ", contentLen=" + this.edH + ", scheme=" + Arrays.toString(this.edI) + ')';
    }
}
