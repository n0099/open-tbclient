package com.baidu.swan.games.bdtls.model;

import java.util.Arrays;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.p;
/* loaded from: classes9.dex */
public final class h {
    public static final a cgL = new a(null);
    private byte[] cgE;
    private byte[] cgF;
    private byte cgG;
    private byte cgH;
    private short cgI;
    private int cgJ;
    private byte[] cgK;
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
            if (!p.h(this.cgE, hVar.cgE) || !p.h(this.cgF, hVar.cgF)) {
                return false;
            }
            if (!(this.cgG == hVar.cgG)) {
                return false;
            }
            if (!(this.cgH == hVar.cgH)) {
                return false;
            }
            if (!(this.cgI == hVar.cgI)) {
                return false;
            }
            if (!(this.cgJ == hVar.cgJ) || !p.h(this.cgK, hVar.cgK) || !p.h(this.content, hVar.content)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        byte[] bArr = this.cgE;
        int hashCode = (bArr != null ? Arrays.hashCode(bArr) : 0) * 31;
        byte[] bArr2 = this.cgF;
        int hashCode2 = ((((((((((bArr2 != null ? Arrays.hashCode(bArr2) : 0) + hashCode) * 31) + this.cgG) * 31) + this.cgH) * 31) + this.cgI) * 31) + this.cgJ) * 31;
        byte[] bArr3 = this.cgK;
        int hashCode3 = ((bArr3 != null ? Arrays.hashCode(bArr3) : 0) + hashCode2) * 31;
        byte[] bArr4 = this.content;
        return hashCode3 + (bArr4 != null ? Arrays.hashCode(bArr4) : 0);
    }

    public h(byte[] bArr, byte[] bArr2, byte b, byte b2, short s, int i, byte[] bArr3, byte[] bArr4) {
        this.cgE = bArr;
        this.cgF = bArr2;
        this.cgG = b;
        this.cgH = b2;
        this.cgI = s;
        this.cgJ = i;
        this.cgK = bArr3;
        this.content = bArr4;
    }

    public /* synthetic */ h(byte[] bArr, byte[] bArr2, byte b, byte b2, short s, int i, byte[] bArr3, byte[] bArr4, int i2, o oVar) {
        this((i2 & 1) != 0 ? new byte[2] : bArr, (i2 & 2) != 0 ? new byte[2] : bArr2, (i2 & 4) != 0 ? (byte) 0 : b, (i2 & 8) != 0 ? (byte) 0 : b2, (i2 & 16) != 0 ? (short) 0 : s, (i2 & 32) != 0 ? 0 : i, (i2 & 64) != 0 ? null : bArr3, (i2 & 128) != 0 ? null : bArr4);
    }

    public final void B(byte[] bArr) {
        this.cgE = bArr;
    }

    public final byte[] ajQ() {
        return this.cgE;
    }

    public final void C(byte[] bArr) {
        this.cgF = bArr;
    }

    public final byte[] ajR() {
        return this.cgF;
    }

    public final byte ajS() {
        return this.cgG;
    }

    public final void b(byte b) {
        this.cgG = b;
    }

    public final byte ajT() {
        return this.cgH;
    }

    public final void c(byte b) {
        this.cgH = b;
    }

    public final short ajU() {
        return this.cgI;
    }

    public final void b(short s) {
        this.cgI = s;
    }

    public final int ajV() {
        return this.cgJ;
    }

    public final void hv(int i) {
        this.cgJ = i;
    }

    public final void D(byte[] bArr) {
        this.cgK = bArr;
    }

    public final byte[] ajW() {
        return this.cgK;
    }

    public final byte[] getContent() {
        return this.content;
    }

    public final void setContent(byte[] bArr) {
        this.content = bArr;
    }

    /* loaded from: classes9.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(o oVar) {
            this();
        }

        public final h ajX() {
            h hVar = new h(null, null, (byte) 0, (byte) 0, (short) 0, 0, null, null, 255, null);
            hVar.B(new byte[2]);
            byte[] ajQ = hVar.ajQ();
            if (ajQ != null) {
                ajQ[0] = 0;
            }
            byte[] ajQ2 = hVar.ajQ();
            if (ajQ2 != null) {
                ajQ2[1] = 1;
            }
            hVar.C(new byte[2]);
            byte[] ajR = hVar.ajR();
            if (ajR != null) {
                ajR[0] = -27;
            }
            byte[] ajR2 = hVar.ajR();
            if (ajR2 != null) {
                ajR2[1] = -89;
            }
            return hVar;
        }
    }

    public String toString() {
        return "RecordParams(protocolVersion=" + Arrays.toString(this.cgE) + ", schemeType=" + ((int) this.cgG) + ", schemeExtType=" + ((int) this.cgH) + ", schemeLen=" + ((int) this.cgI) + ", contentLen=" + this.cgJ + ", scheme=" + Arrays.toString(this.cgK) + ')';
    }
}
