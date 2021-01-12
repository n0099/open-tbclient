package com.baidu.swan.games.bdtls.model;

import java.util.Arrays;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.p;
@kotlin.e
/* loaded from: classes8.dex */
public final class h {
    public static final a ebC = new a(null);
    private byte[] content;
    private int ebA;
    private byte[] ebB;
    private byte[] ebv;
    private byte[] ebw;
    private byte ebx;
    private byte eby;
    private short ebz;

    public h() {
        this(null, null, (byte) 0, (byte) 0, (short) 0, 0, null, null, 255, null);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof h)) {
                return false;
            }
            h hVar = (h) obj;
            if (!p.l(this.ebv, hVar.ebv) || !p.l(this.ebw, hVar.ebw)) {
                return false;
            }
            if (!(this.ebx == hVar.ebx)) {
                return false;
            }
            if (!(this.eby == hVar.eby)) {
                return false;
            }
            if (!(this.ebz == hVar.ebz)) {
                return false;
            }
            if (!(this.ebA == hVar.ebA) || !p.l(this.ebB, hVar.ebB) || !p.l(this.content, hVar.content)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        byte[] bArr = this.ebv;
        int hashCode = (bArr != null ? Arrays.hashCode(bArr) : 0) * 31;
        byte[] bArr2 = this.ebw;
        int hashCode2 = ((((((((((bArr2 != null ? Arrays.hashCode(bArr2) : 0) + hashCode) * 31) + this.ebx) * 31) + this.eby) * 31) + this.ebz) * 31) + this.ebA) * 31;
        byte[] bArr3 = this.ebB;
        int hashCode3 = ((bArr3 != null ? Arrays.hashCode(bArr3) : 0) + hashCode2) * 31;
        byte[] bArr4 = this.content;
        return hashCode3 + (bArr4 != null ? Arrays.hashCode(bArr4) : 0);
    }

    public h(byte[] bArr, byte[] bArr2, byte b2, byte b3, short s, int i, byte[] bArr3, byte[] bArr4) {
        this.ebv = bArr;
        this.ebw = bArr2;
        this.ebx = b2;
        this.eby = b3;
        this.ebz = s;
        this.ebA = i;
        this.ebB = bArr3;
        this.content = bArr4;
    }

    public /* synthetic */ h(byte[] bArr, byte[] bArr2, byte b2, byte b3, short s, int i, byte[] bArr3, byte[] bArr4, int i2, o oVar) {
        this((i2 & 1) != 0 ? new byte[2] : bArr, (i2 & 2) != 0 ? new byte[2] : bArr2, (i2 & 4) != 0 ? (byte) 0 : b2, (i2 & 8) != 0 ? (byte) 0 : b3, (i2 & 16) != 0 ? (short) 0 : s, (i2 & 32) != 0 ? 0 : i, (i2 & 64) != 0 ? null : bArr3, (i2 & 128) != 0 ? null : bArr4);
    }

    public final void P(byte[] bArr) {
        this.ebv = bArr;
    }

    public final byte[] aUP() {
        return this.ebv;
    }

    public final void Q(byte[] bArr) {
        this.ebw = bArr;
    }

    public final byte[] aUQ() {
        return this.ebw;
    }

    public final byte aUR() {
        return this.ebx;
    }

    public final void c(byte b2) {
        this.ebx = b2;
    }

    public final byte aUS() {
        return this.eby;
    }

    public final void d(byte b2) {
        this.eby = b2;
    }

    public final short aUT() {
        return this.ebz;
    }

    public final void d(short s) {
        this.ebz = s;
    }

    public final int aUU() {
        return this.ebA;
    }

    public final void kW(int i) {
        this.ebA = i;
    }

    public final void R(byte[] bArr) {
        this.ebB = bArr;
    }

    public final byte[] aUV() {
        return this.ebB;
    }

    public final byte[] getContent() {
        return this.content;
    }

    public final void setContent(byte[] bArr) {
        this.content = bArr;
    }

    @kotlin.e
    /* loaded from: classes8.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(o oVar) {
            this();
        }

        public final h aUW() {
            h hVar = new h(null, null, (byte) 0, (byte) 0, (short) 0, 0, null, null, 255, null);
            hVar.P(new byte[2]);
            byte[] aUP = hVar.aUP();
            if (aUP != null) {
                aUP[0] = 0;
            }
            byte[] aUP2 = hVar.aUP();
            if (aUP2 != null) {
                aUP2[1] = 2;
            }
            hVar.Q(new byte[2]);
            byte[] aUQ = hVar.aUQ();
            if (aUQ != null) {
                aUQ[0] = -27;
            }
            byte[] aUQ2 = hVar.aUQ();
            if (aUQ2 != null) {
                aUQ2[1] = -89;
            }
            return hVar;
        }
    }

    public String toString() {
        return "RecordParams(protocolVersion=" + Arrays.toString(this.ebv) + ", schemeType=" + ((int) this.ebx) + ", schemeExtType=" + ((int) this.eby) + ", schemeLen=" + ((int) this.ebz) + ", contentLen=" + this.ebA + ", scheme=" + Arrays.toString(this.ebB) + ')';
    }
}
