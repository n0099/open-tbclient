package com.baidu.swan.games.bdtls.model;

import java.util.Arrays;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
/* loaded from: classes10.dex */
public final class h {
    public static final a cgY = new a(null);
    private byte[] cgR;
    private byte[] cgS;
    private byte cgT;
    private byte cgU;
    private short cgV;
    private int cgW;
    private byte[] cgX;
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
            if (!q.h(this.cgR, hVar.cgR) || !q.h(this.cgS, hVar.cgS)) {
                return false;
            }
            if (!(this.cgT == hVar.cgT)) {
                return false;
            }
            if (!(this.cgU == hVar.cgU)) {
                return false;
            }
            if (!(this.cgV == hVar.cgV)) {
                return false;
            }
            if (!(this.cgW == hVar.cgW) || !q.h(this.cgX, hVar.cgX) || !q.h(this.content, hVar.content)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        byte[] bArr = this.cgR;
        int hashCode = (bArr != null ? Arrays.hashCode(bArr) : 0) * 31;
        byte[] bArr2 = this.cgS;
        int hashCode2 = ((((((((((bArr2 != null ? Arrays.hashCode(bArr2) : 0) + hashCode) * 31) + this.cgT) * 31) + this.cgU) * 31) + this.cgV) * 31) + this.cgW) * 31;
        byte[] bArr3 = this.cgX;
        int hashCode3 = ((bArr3 != null ? Arrays.hashCode(bArr3) : 0) + hashCode2) * 31;
        byte[] bArr4 = this.content;
        return hashCode3 + (bArr4 != null ? Arrays.hashCode(bArr4) : 0);
    }

    public h(byte[] bArr, byte[] bArr2, byte b, byte b2, short s, int i, byte[] bArr3, byte[] bArr4) {
        this.cgR = bArr;
        this.cgS = bArr2;
        this.cgT = b;
        this.cgU = b2;
        this.cgV = s;
        this.cgW = i;
        this.cgX = bArr3;
        this.content = bArr4;
    }

    public /* synthetic */ h(byte[] bArr, byte[] bArr2, byte b, byte b2, short s, int i, byte[] bArr3, byte[] bArr4, int i2, o oVar) {
        this((i2 & 1) != 0 ? new byte[2] : bArr, (i2 & 2) != 0 ? new byte[2] : bArr2, (i2 & 4) != 0 ? (byte) 0 : b, (i2 & 8) != 0 ? (byte) 0 : b2, (i2 & 16) != 0 ? (short) 0 : s, (i2 & 32) != 0 ? 0 : i, (i2 & 64) != 0 ? null : bArr3, (i2 & 128) != 0 ? null : bArr4);
    }

    public final void A(byte[] bArr) {
        this.cgR = bArr;
    }

    public final byte[] akj() {
        return this.cgR;
    }

    public final void B(byte[] bArr) {
        this.cgS = bArr;
    }

    public final byte[] akk() {
        return this.cgS;
    }

    public final byte akl() {
        return this.cgT;
    }

    public final void b(byte b) {
        this.cgT = b;
    }

    public final byte akm() {
        return this.cgU;
    }

    public final void c(byte b) {
        this.cgU = b;
    }

    public final short akn() {
        return this.cgV;
    }

    public final void b(short s) {
        this.cgV = s;
    }

    public final int ako() {
        return this.cgW;
    }

    public final void hv(int i) {
        this.cgW = i;
    }

    public final void C(byte[] bArr) {
        this.cgX = bArr;
    }

    public final byte[] akp() {
        return this.cgX;
    }

    public final byte[] getContent() {
        return this.content;
    }

    public final void setContent(byte[] bArr) {
        this.content = bArr;
    }

    /* loaded from: classes10.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(o oVar) {
            this();
        }

        public final h akq() {
            h hVar = new h(null, null, (byte) 0, (byte) 0, (short) 0, 0, null, null, 255, null);
            hVar.A(new byte[2]);
            byte[] akj = hVar.akj();
            if (akj != null) {
                akj[0] = 0;
            }
            byte[] akj2 = hVar.akj();
            if (akj2 != null) {
                akj2[1] = 1;
            }
            hVar.B(new byte[2]);
            byte[] akk = hVar.akk();
            if (akk != null) {
                akk[0] = -27;
            }
            byte[] akk2 = hVar.akk();
            if (akk2 != null) {
                akk2[1] = -89;
            }
            return hVar;
        }
    }

    public String toString() {
        return "RecordParams(protocolVersion=" + Arrays.toString(this.cgR) + ", schemeType=" + ((int) this.cgT) + ", schemeExtType=" + ((int) this.cgU) + ", schemeLen=" + ((int) this.cgV) + ", contentLen=" + this.cgW + ", scheme=" + Arrays.toString(this.cgX) + ')';
    }
}
