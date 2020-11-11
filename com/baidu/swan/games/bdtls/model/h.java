package com.baidu.swan.games.bdtls.model;

import java.util.Arrays;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes10.dex */
public final class h {
    public static final a dSb = new a(null);
    private byte[] content;
    private byte[] dRU;
    private byte[] dRV;
    private byte dRW;
    private byte dRX;
    private short dRY;
    private int dRZ;
    private byte[] dSa;

    public h() {
        this(null, null, (byte) 0, (byte) 0, (short) 0, 0, null, null, 255, null);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof h)) {
                return false;
            }
            h hVar = (h) obj;
            if (!q.l(this.dRU, hVar.dRU) || !q.l(this.dRV, hVar.dRV)) {
                return false;
            }
            if (!(this.dRW == hVar.dRW)) {
                return false;
            }
            if (!(this.dRX == hVar.dRX)) {
                return false;
            }
            if (!(this.dRY == hVar.dRY)) {
                return false;
            }
            if (!(this.dRZ == hVar.dRZ) || !q.l(this.dSa, hVar.dSa) || !q.l(this.content, hVar.content)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        byte[] bArr = this.dRU;
        int hashCode = (bArr != null ? Arrays.hashCode(bArr) : 0) * 31;
        byte[] bArr2 = this.dRV;
        int hashCode2 = ((((((((((bArr2 != null ? Arrays.hashCode(bArr2) : 0) + hashCode) * 31) + this.dRW) * 31) + this.dRX) * 31) + this.dRY) * 31) + this.dRZ) * 31;
        byte[] bArr3 = this.dSa;
        int hashCode3 = ((bArr3 != null ? Arrays.hashCode(bArr3) : 0) + hashCode2) * 31;
        byte[] bArr4 = this.content;
        return hashCode3 + (bArr4 != null ? Arrays.hashCode(bArr4) : 0);
    }

    public h(byte[] bArr, byte[] bArr2, byte b, byte b2, short s, int i, byte[] bArr3, byte[] bArr4) {
        this.dRU = bArr;
        this.dRV = bArr2;
        this.dRW = b;
        this.dRX = b2;
        this.dRY = s;
        this.dRZ = i;
        this.dSa = bArr3;
        this.content = bArr4;
    }

    public /* synthetic */ h(byte[] bArr, byte[] bArr2, byte b, byte b2, short s, int i, byte[] bArr3, byte[] bArr4, int i2, o oVar) {
        this((i2 & 1) != 0 ? new byte[2] : bArr, (i2 & 2) != 0 ? new byte[2] : bArr2, (i2 & 4) != 0 ? (byte) 0 : b, (i2 & 8) != 0 ? (byte) 0 : b2, (i2 & 16) != 0 ? (short) 0 : s, (i2 & 32) != 0 ? 0 : i, (i2 & 64) != 0 ? null : bArr3, (i2 & 128) != 0 ? null : bArr4);
    }

    public final void R(byte[] bArr) {
        this.dRU = bArr;
    }

    public final byte[] aTR() {
        return this.dRU;
    }

    public final void S(byte[] bArr) {
        this.dRV = bArr;
    }

    public final byte[] aTS() {
        return this.dRV;
    }

    public final byte aTT() {
        return this.dRW;
    }

    public final void c(byte b) {
        this.dRW = b;
    }

    public final byte aTU() {
        return this.dRX;
    }

    public final void d(byte b) {
        this.dRX = b;
    }

    public final short aTV() {
        return this.dRY;
    }

    public final void d(short s) {
        this.dRY = s;
    }

    public final int aTW() {
        return this.dRZ;
    }

    public final void ma(int i) {
        this.dRZ = i;
    }

    public final void T(byte[] bArr) {
        this.dSa = bArr;
    }

    public final byte[] aTX() {
        return this.dSa;
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

        public final h aTY() {
            h hVar = new h(null, null, (byte) 0, (byte) 0, (short) 0, 0, null, null, 255, null);
            hVar.R(new byte[2]);
            byte[] aTR = hVar.aTR();
            if (aTR != null) {
                aTR[0] = 0;
            }
            byte[] aTR2 = hVar.aTR();
            if (aTR2 != null) {
                aTR2[1] = 2;
            }
            hVar.S(new byte[2]);
            byte[] aTS = hVar.aTS();
            if (aTS != null) {
                aTS[0] = -27;
            }
            byte[] aTS2 = hVar.aTS();
            if (aTS2 != null) {
                aTS2[1] = -89;
            }
            return hVar;
        }
    }

    public String toString() {
        return "RecordParams(protocolVersion=" + Arrays.toString(this.dRU) + ", schemeType=" + ((int) this.dRW) + ", schemeExtType=" + ((int) this.dRX) + ", schemeLen=" + ((int) this.dRY) + ", contentLen=" + this.dRZ + ", scheme=" + Arrays.toString(this.dSa) + ')';
    }
}
