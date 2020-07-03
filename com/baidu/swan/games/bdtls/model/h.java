package com.baidu.swan.games.bdtls.model;

import java.util.Arrays;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes11.dex */
public final class h {
    public static final a cZJ = new a(null);
    private byte[] cZC;
    private byte[] cZD;
    private byte cZE;
    private byte cZF;
    private short cZG;
    private int cZH;
    private byte[] cZI;
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
            if (!q.l(this.cZC, hVar.cZC) || !q.l(this.cZD, hVar.cZD)) {
                return false;
            }
            if (!(this.cZE == hVar.cZE)) {
                return false;
            }
            if (!(this.cZF == hVar.cZF)) {
                return false;
            }
            if (!(this.cZG == hVar.cZG)) {
                return false;
            }
            if (!(this.cZH == hVar.cZH) || !q.l(this.cZI, hVar.cZI) || !q.l(this.content, hVar.content)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        byte[] bArr = this.cZC;
        int hashCode = (bArr != null ? Arrays.hashCode(bArr) : 0) * 31;
        byte[] bArr2 = this.cZD;
        int hashCode2 = ((((((((((bArr2 != null ? Arrays.hashCode(bArr2) : 0) + hashCode) * 31) + this.cZE) * 31) + this.cZF) * 31) + this.cZG) * 31) + this.cZH) * 31;
        byte[] bArr3 = this.cZI;
        int hashCode3 = ((bArr3 != null ? Arrays.hashCode(bArr3) : 0) + hashCode2) * 31;
        byte[] bArr4 = this.content;
        return hashCode3 + (bArr4 != null ? Arrays.hashCode(bArr4) : 0);
    }

    public h(byte[] bArr, byte[] bArr2, byte b, byte b2, short s, int i, byte[] bArr3, byte[] bArr4) {
        this.cZC = bArr;
        this.cZD = bArr2;
        this.cZE = b;
        this.cZF = b2;
        this.cZG = s;
        this.cZH = i;
        this.cZI = bArr3;
        this.content = bArr4;
    }

    public /* synthetic */ h(byte[] bArr, byte[] bArr2, byte b, byte b2, short s, int i, byte[] bArr3, byte[] bArr4, int i2, o oVar) {
        this((i2 & 1) != 0 ? new byte[2] : bArr, (i2 & 2) != 0 ? new byte[2] : bArr2, (i2 & 4) != 0 ? (byte) 0 : b, (i2 & 8) != 0 ? (byte) 0 : b2, (i2 & 16) != 0 ? (short) 0 : s, (i2 & 32) != 0 ? 0 : i, (i2 & 64) != 0 ? null : bArr3, (i2 & 128) != 0 ? null : bArr4);
    }

    public final void Q(byte[] bArr) {
        this.cZC = bArr;
    }

    public final byte[] azJ() {
        return this.cZC;
    }

    public final void R(byte[] bArr) {
        this.cZD = bArr;
    }

    public final byte[] azK() {
        return this.cZD;
    }

    public final byte azL() {
        return this.cZE;
    }

    public final void c(byte b) {
        this.cZE = b;
    }

    public final byte azM() {
        return this.cZF;
    }

    public final void d(byte b) {
        this.cZF = b;
    }

    public final short azN() {
        return this.cZG;
    }

    public final void c(short s) {
        this.cZG = s;
    }

    public final int azO() {
        return this.cZH;
    }

    public final void ix(int i) {
        this.cZH = i;
    }

    public final void S(byte[] bArr) {
        this.cZI = bArr;
    }

    public final byte[] azP() {
        return this.cZI;
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

        public final h azQ() {
            h hVar = new h(null, null, (byte) 0, (byte) 0, (short) 0, 0, null, null, 255, null);
            hVar.Q(new byte[2]);
            byte[] azJ = hVar.azJ();
            if (azJ != null) {
                azJ[0] = 0;
            }
            byte[] azJ2 = hVar.azJ();
            if (azJ2 != null) {
                azJ2[1] = 2;
            }
            hVar.R(new byte[2]);
            byte[] azK = hVar.azK();
            if (azK != null) {
                azK[0] = -27;
            }
            byte[] azK2 = hVar.azK();
            if (azK2 != null) {
                azK2[1] = -89;
            }
            return hVar;
        }
    }

    public String toString() {
        return "RecordParams(protocolVersion=" + Arrays.toString(this.cZC) + ", schemeType=" + ((int) this.cZE) + ", schemeExtType=" + ((int) this.cZF) + ", schemeLen=" + ((int) this.cZG) + ", contentLen=" + this.cZH + ", scheme=" + Arrays.toString(this.cZI) + ')';
    }
}
