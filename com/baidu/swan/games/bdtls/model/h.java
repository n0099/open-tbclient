package com.baidu.swan.games.bdtls.model;

import java.util.Arrays;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes8.dex */
public final class h {
    public static final a dpH = new a(null);
    private byte[] content;
    private byte[] dpA;
    private byte[] dpB;
    private byte dpC;
    private byte dpD;
    private short dpE;
    private int dpF;
    private byte[] dpG;

    public h() {
        this(null, null, (byte) 0, (byte) 0, (short) 0, 0, null, null, 255, null);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof h)) {
                return false;
            }
            h hVar = (h) obj;
            if (!q.l(this.dpA, hVar.dpA) || !q.l(this.dpB, hVar.dpB)) {
                return false;
            }
            if (!(this.dpC == hVar.dpC)) {
                return false;
            }
            if (!(this.dpD == hVar.dpD)) {
                return false;
            }
            if (!(this.dpE == hVar.dpE)) {
                return false;
            }
            if (!(this.dpF == hVar.dpF) || !q.l(this.dpG, hVar.dpG) || !q.l(this.content, hVar.content)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        byte[] bArr = this.dpA;
        int hashCode = (bArr != null ? Arrays.hashCode(bArr) : 0) * 31;
        byte[] bArr2 = this.dpB;
        int hashCode2 = ((((((((((bArr2 != null ? Arrays.hashCode(bArr2) : 0) + hashCode) * 31) + this.dpC) * 31) + this.dpD) * 31) + this.dpE) * 31) + this.dpF) * 31;
        byte[] bArr3 = this.dpG;
        int hashCode3 = ((bArr3 != null ? Arrays.hashCode(bArr3) : 0) + hashCode2) * 31;
        byte[] bArr4 = this.content;
        return hashCode3 + (bArr4 != null ? Arrays.hashCode(bArr4) : 0);
    }

    public h(byte[] bArr, byte[] bArr2, byte b, byte b2, short s, int i, byte[] bArr3, byte[] bArr4) {
        this.dpA = bArr;
        this.dpB = bArr2;
        this.dpC = b;
        this.dpD = b2;
        this.dpE = s;
        this.dpF = i;
        this.dpG = bArr3;
        this.content = bArr4;
    }

    public /* synthetic */ h(byte[] bArr, byte[] bArr2, byte b, byte b2, short s, int i, byte[] bArr3, byte[] bArr4, int i2, o oVar) {
        this((i2 & 1) != 0 ? new byte[2] : bArr, (i2 & 2) != 0 ? new byte[2] : bArr2, (i2 & 4) != 0 ? (byte) 0 : b, (i2 & 8) != 0 ? (byte) 0 : b2, (i2 & 16) != 0 ? (short) 0 : s, (i2 & 32) != 0 ? 0 : i, (i2 & 64) != 0 ? null : bArr3, (i2 & 128) != 0 ? null : bArr4);
    }

    public final void R(byte[] bArr) {
        this.dpA = bArr;
    }

    public final byte[] aMd() {
        return this.dpA;
    }

    public final void S(byte[] bArr) {
        this.dpB = bArr;
    }

    public final byte[] aMe() {
        return this.dpB;
    }

    public final byte aMf() {
        return this.dpC;
    }

    public final void c(byte b) {
        this.dpC = b;
    }

    public final byte aMg() {
        return this.dpD;
    }

    public final void d(byte b) {
        this.dpD = b;
    }

    public final short aMh() {
        return this.dpE;
    }

    public final void c(short s) {
        this.dpE = s;
    }

    public final int aMi() {
        return this.dpF;
    }

    public final void kX(int i) {
        this.dpF = i;
    }

    public final void T(byte[] bArr) {
        this.dpG = bArr;
    }

    public final byte[] aMj() {
        return this.dpG;
    }

    public final byte[] getContent() {
        return this.content;
    }

    public final void setContent(byte[] bArr) {
        this.content = bArr;
    }

    @kotlin.h
    /* loaded from: classes8.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(o oVar) {
            this();
        }

        public final h aMk() {
            h hVar = new h(null, null, (byte) 0, (byte) 0, (short) 0, 0, null, null, 255, null);
            hVar.R(new byte[2]);
            byte[] aMd = hVar.aMd();
            if (aMd != null) {
                aMd[0] = 0;
            }
            byte[] aMd2 = hVar.aMd();
            if (aMd2 != null) {
                aMd2[1] = 2;
            }
            hVar.S(new byte[2]);
            byte[] aMe = hVar.aMe();
            if (aMe != null) {
                aMe[0] = -27;
            }
            byte[] aMe2 = hVar.aMe();
            if (aMe2 != null) {
                aMe2[1] = -89;
            }
            return hVar;
        }
    }

    public String toString() {
        return "RecordParams(protocolVersion=" + Arrays.toString(this.dpA) + ", schemeType=" + ((int) this.dpC) + ", schemeExtType=" + ((int) this.dpD) + ", schemeLen=" + ((int) this.dpE) + ", contentLen=" + this.dpF + ", scheme=" + Arrays.toString(this.dpG) + ')';
    }
}
