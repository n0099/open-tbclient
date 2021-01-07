package com.baidu.swan.games.bdtls.model;

import java.util.Arrays;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.p;
@kotlin.e
/* loaded from: classes9.dex */
public final class h {
    public static final a egp = new a(null);
    private byte[] content;
    private byte[] egh;
    private byte[] egi;
    private byte egj;
    private byte egk;
    private short egm;
    private int egn;
    private byte[] ego;

    public h() {
        this(null, null, (byte) 0, (byte) 0, (short) 0, 0, null, null, 255, null);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof h)) {
                return false;
            }
            h hVar = (h) obj;
            if (!p.l(this.egh, hVar.egh) || !p.l(this.egi, hVar.egi)) {
                return false;
            }
            if (!(this.egj == hVar.egj)) {
                return false;
            }
            if (!(this.egk == hVar.egk)) {
                return false;
            }
            if (!(this.egm == hVar.egm)) {
                return false;
            }
            if (!(this.egn == hVar.egn) || !p.l(this.ego, hVar.ego) || !p.l(this.content, hVar.content)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        byte[] bArr = this.egh;
        int hashCode = (bArr != null ? Arrays.hashCode(bArr) : 0) * 31;
        byte[] bArr2 = this.egi;
        int hashCode2 = ((((((((((bArr2 != null ? Arrays.hashCode(bArr2) : 0) + hashCode) * 31) + this.egj) * 31) + this.egk) * 31) + this.egm) * 31) + this.egn) * 31;
        byte[] bArr3 = this.ego;
        int hashCode3 = ((bArr3 != null ? Arrays.hashCode(bArr3) : 0) + hashCode2) * 31;
        byte[] bArr4 = this.content;
        return hashCode3 + (bArr4 != null ? Arrays.hashCode(bArr4) : 0);
    }

    public h(byte[] bArr, byte[] bArr2, byte b2, byte b3, short s, int i, byte[] bArr3, byte[] bArr4) {
        this.egh = bArr;
        this.egi = bArr2;
        this.egj = b2;
        this.egk = b3;
        this.egm = s;
        this.egn = i;
        this.ego = bArr3;
        this.content = bArr4;
    }

    public /* synthetic */ h(byte[] bArr, byte[] bArr2, byte b2, byte b3, short s, int i, byte[] bArr3, byte[] bArr4, int i2, o oVar) {
        this((i2 & 1) != 0 ? new byte[2] : bArr, (i2 & 2) != 0 ? new byte[2] : bArr2, (i2 & 4) != 0 ? (byte) 0 : b2, (i2 & 8) != 0 ? (byte) 0 : b3, (i2 & 16) != 0 ? (short) 0 : s, (i2 & 32) != 0 ? 0 : i, (i2 & 64) != 0 ? null : bArr3, (i2 & 128) != 0 ? null : bArr4);
    }

    public final void Q(byte[] bArr) {
        this.egh = bArr;
    }

    public final byte[] aYJ() {
        return this.egh;
    }

    public final void R(byte[] bArr) {
        this.egi = bArr;
    }

    public final byte[] aYK() {
        return this.egi;
    }

    public final byte aYL() {
        return this.egj;
    }

    public final void c(byte b2) {
        this.egj = b2;
    }

    public final byte aYM() {
        return this.egk;
    }

    public final void d(byte b2) {
        this.egk = b2;
    }

    public final short aYN() {
        return this.egm;
    }

    public final void d(short s) {
        this.egm = s;
    }

    public final int aYO() {
        return this.egn;
    }

    public final void mC(int i) {
        this.egn = i;
    }

    public final void S(byte[] bArr) {
        this.ego = bArr;
    }

    public final byte[] aYP() {
        return this.ego;
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

        public final h aYQ() {
            h hVar = new h(null, null, (byte) 0, (byte) 0, (short) 0, 0, null, null, 255, null);
            hVar.Q(new byte[2]);
            byte[] aYJ = hVar.aYJ();
            if (aYJ != null) {
                aYJ[0] = 0;
            }
            byte[] aYJ2 = hVar.aYJ();
            if (aYJ2 != null) {
                aYJ2[1] = 2;
            }
            hVar.R(new byte[2]);
            byte[] aYK = hVar.aYK();
            if (aYK != null) {
                aYK[0] = -27;
            }
            byte[] aYK2 = hVar.aYK();
            if (aYK2 != null) {
                aYK2[1] = -89;
            }
            return hVar;
        }
    }

    public String toString() {
        return "RecordParams(protocolVersion=" + Arrays.toString(this.egh) + ", schemeType=" + ((int) this.egj) + ", schemeExtType=" + ((int) this.egk) + ", schemeLen=" + ((int) this.egm) + ", contentLen=" + this.egn + ", scheme=" + Arrays.toString(this.ego) + ')';
    }
}
