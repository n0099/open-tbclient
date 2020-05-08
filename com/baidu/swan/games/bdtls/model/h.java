package com.baidu.swan.games.bdtls.model;

import java.util.Arrays;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes11.dex */
public final class h {
    public static final a cKs = new a(null);
    private byte[] cKl;
    private byte[] cKm;
    private byte cKn;
    private byte cKo;
    private short cKp;
    private int cKq;
    private byte[] cKr;
    private byte[] content;

    public h() {
        this(null, null, (byte) 0, (byte) 0, (short) 0, 0, null, null, 255, null);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof h)) {
                return false;
            }
            h hVar = (h) obj;
            if (!q.k(this.cKl, hVar.cKl) || !q.k(this.cKm, hVar.cKm)) {
                return false;
            }
            if (!(this.cKn == hVar.cKn)) {
                return false;
            }
            if (!(this.cKo == hVar.cKo)) {
                return false;
            }
            if (!(this.cKp == hVar.cKp)) {
                return false;
            }
            if (!(this.cKq == hVar.cKq) || !q.k(this.cKr, hVar.cKr) || !q.k(this.content, hVar.content)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        byte[] bArr = this.cKl;
        int hashCode = (bArr != null ? Arrays.hashCode(bArr) : 0) * 31;
        byte[] bArr2 = this.cKm;
        int hashCode2 = ((((((((((bArr2 != null ? Arrays.hashCode(bArr2) : 0) + hashCode) * 31) + this.cKn) * 31) + this.cKo) * 31) + this.cKp) * 31) + this.cKq) * 31;
        byte[] bArr3 = this.cKr;
        int hashCode3 = ((bArr3 != null ? Arrays.hashCode(bArr3) : 0) + hashCode2) * 31;
        byte[] bArr4 = this.content;
        return hashCode3 + (bArr4 != null ? Arrays.hashCode(bArr4) : 0);
    }

    public h(byte[] bArr, byte[] bArr2, byte b, byte b2, short s, int i, byte[] bArr3, byte[] bArr4) {
        this.cKl = bArr;
        this.cKm = bArr2;
        this.cKn = b;
        this.cKo = b2;
        this.cKp = s;
        this.cKq = i;
        this.cKr = bArr3;
        this.content = bArr4;
    }

    public /* synthetic */ h(byte[] bArr, byte[] bArr2, byte b, byte b2, short s, int i, byte[] bArr3, byte[] bArr4, int i2, o oVar) {
        this((i2 & 1) != 0 ? new byte[2] : bArr, (i2 & 2) != 0 ? new byte[2] : bArr2, (i2 & 4) != 0 ? (byte) 0 : b, (i2 & 8) != 0 ? (byte) 0 : b2, (i2 & 16) != 0 ? (short) 0 : s, (i2 & 32) != 0 ? 0 : i, (i2 & 64) != 0 ? null : bArr3, (i2 & 128) != 0 ? null : bArr4);
    }

    public final void H(byte[] bArr) {
        this.cKl = bArr;
    }

    public final byte[] auQ() {
        return this.cKl;
    }

    public final void I(byte[] bArr) {
        this.cKm = bArr;
    }

    public final byte[] auR() {
        return this.cKm;
    }

    public final byte auS() {
        return this.cKn;
    }

    public final void b(byte b) {
        this.cKn = b;
    }

    public final byte auT() {
        return this.cKo;
    }

    public final void c(byte b) {
        this.cKo = b;
    }

    public final short auU() {
        return this.cKp;
    }

    public final void c(short s) {
        this.cKp = s;
    }

    public final int auV() {
        return this.cKq;
    }

    public final void hT(int i) {
        this.cKq = i;
    }

    public final void J(byte[] bArr) {
        this.cKr = bArr;
    }

    public final byte[] auW() {
        return this.cKr;
    }

    public final byte[] getContent() {
        return this.content;
    }

    public final void setContent(byte[] bArr) {
        this.content = bArr;
    }

    @kotlin.h
    /* loaded from: classes11.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(o oVar) {
            this();
        }

        public final h auX() {
            h hVar = new h(null, null, (byte) 0, (byte) 0, (short) 0, 0, null, null, 255, null);
            hVar.H(new byte[2]);
            byte[] auQ = hVar.auQ();
            if (auQ != null) {
                auQ[0] = 0;
            }
            byte[] auQ2 = hVar.auQ();
            if (auQ2 != null) {
                auQ2[1] = 1;
            }
            hVar.I(new byte[2]);
            byte[] auR = hVar.auR();
            if (auR != null) {
                auR[0] = -27;
            }
            byte[] auR2 = hVar.auR();
            if (auR2 != null) {
                auR2[1] = -89;
            }
            return hVar;
        }
    }

    public String toString() {
        return "RecordParams(protocolVersion=" + Arrays.toString(this.cKl) + ", schemeType=" + ((int) this.cKn) + ", schemeExtType=" + ((int) this.cKo) + ", schemeLen=" + ((int) this.cKp) + ", contentLen=" + this.cKq + ", scheme=" + Arrays.toString(this.cKr) + ')';
    }
}
