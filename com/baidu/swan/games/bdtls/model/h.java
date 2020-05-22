package com.baidu.swan.games.bdtls.model;

import java.util.Arrays;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes11.dex */
public final class h {
    public static final a cUZ = new a(null);
    private byte[] cUS;
    private byte[] cUT;
    private byte cUU;
    private byte cUV;
    private short cUW;
    private int cUX;
    private byte[] cUY;
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
            if (!q.l(this.cUS, hVar.cUS) || !q.l(this.cUT, hVar.cUT)) {
                return false;
            }
            if (!(this.cUU == hVar.cUU)) {
                return false;
            }
            if (!(this.cUV == hVar.cUV)) {
                return false;
            }
            if (!(this.cUW == hVar.cUW)) {
                return false;
            }
            if (!(this.cUX == hVar.cUX) || !q.l(this.cUY, hVar.cUY) || !q.l(this.content, hVar.content)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        byte[] bArr = this.cUS;
        int hashCode = (bArr != null ? Arrays.hashCode(bArr) : 0) * 31;
        byte[] bArr2 = this.cUT;
        int hashCode2 = ((((((((((bArr2 != null ? Arrays.hashCode(bArr2) : 0) + hashCode) * 31) + this.cUU) * 31) + this.cUV) * 31) + this.cUW) * 31) + this.cUX) * 31;
        byte[] bArr3 = this.cUY;
        int hashCode3 = ((bArr3 != null ? Arrays.hashCode(bArr3) : 0) + hashCode2) * 31;
        byte[] bArr4 = this.content;
        return hashCode3 + (bArr4 != null ? Arrays.hashCode(bArr4) : 0);
    }

    public h(byte[] bArr, byte[] bArr2, byte b, byte b2, short s, int i, byte[] bArr3, byte[] bArr4) {
        this.cUS = bArr;
        this.cUT = bArr2;
        this.cUU = b;
        this.cUV = b2;
        this.cUW = s;
        this.cUX = i;
        this.cUY = bArr3;
        this.content = bArr4;
    }

    public /* synthetic */ h(byte[] bArr, byte[] bArr2, byte b, byte b2, short s, int i, byte[] bArr3, byte[] bArr4, int i2, o oVar) {
        this((i2 & 1) != 0 ? new byte[2] : bArr, (i2 & 2) != 0 ? new byte[2] : bArr2, (i2 & 4) != 0 ? (byte) 0 : b, (i2 & 8) != 0 ? (byte) 0 : b2, (i2 & 16) != 0 ? (short) 0 : s, (i2 & 32) != 0 ? 0 : i, (i2 & 64) != 0 ? null : bArr3, (i2 & 128) != 0 ? null : bArr4);
    }

    public final void O(byte[] bArr) {
        this.cUS = bArr;
    }

    public final byte[] ayD() {
        return this.cUS;
    }

    public final void P(byte[] bArr) {
        this.cUT = bArr;
    }

    public final byte[] ayE() {
        return this.cUT;
    }

    public final byte ayF() {
        return this.cUU;
    }

    public final void c(byte b) {
        this.cUU = b;
    }

    public final byte ayG() {
        return this.cUV;
    }

    public final void d(byte b) {
        this.cUV = b;
    }

    public final short ayH() {
        return this.cUW;
    }

    public final void c(short s) {
        this.cUW = s;
    }

    public final int ayI() {
        return this.cUX;
    }

    public final void ik(int i) {
        this.cUX = i;
    }

    public final void Q(byte[] bArr) {
        this.cUY = bArr;
    }

    public final byte[] ayJ() {
        return this.cUY;
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

        public final h ayK() {
            h hVar = new h(null, null, (byte) 0, (byte) 0, (short) 0, 0, null, null, 255, null);
            hVar.O(new byte[2]);
            byte[] ayD = hVar.ayD();
            if (ayD != null) {
                ayD[0] = 0;
            }
            byte[] ayD2 = hVar.ayD();
            if (ayD2 != null) {
                ayD2[1] = 2;
            }
            hVar.P(new byte[2]);
            byte[] ayE = hVar.ayE();
            if (ayE != null) {
                ayE[0] = -27;
            }
            byte[] ayE2 = hVar.ayE();
            if (ayE2 != null) {
                ayE2[1] = -89;
            }
            return hVar;
        }
    }

    public String toString() {
        return "RecordParams(protocolVersion=" + Arrays.toString(this.cUS) + ", schemeType=" + ((int) this.cUU) + ", schemeExtType=" + ((int) this.cUV) + ", schemeLen=" + ((int) this.cUW) + ", contentLen=" + this.cUX + ", scheme=" + Arrays.toString(this.cUY) + ')';
    }
}
