package com.baidu.swan.games.bdtls.model;

import java.util.Arrays;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes7.dex */
public final class h {
    public static final a dfu = new a(null);
    private byte[] content;
    private byte[] dfn;
    private byte[] dfo;
    private byte dfp;
    private byte dfq;
    private short dfr;
    private int dfs;
    private byte[] dft;

    public h() {
        this(null, null, (byte) 0, (byte) 0, (short) 0, 0, null, null, 255, null);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof h)) {
                return false;
            }
            h hVar = (h) obj;
            if (!q.l(this.dfn, hVar.dfn) || !q.l(this.dfo, hVar.dfo)) {
                return false;
            }
            if (!(this.dfp == hVar.dfp)) {
                return false;
            }
            if (!(this.dfq == hVar.dfq)) {
                return false;
            }
            if (!(this.dfr == hVar.dfr)) {
                return false;
            }
            if (!(this.dfs == hVar.dfs) || !q.l(this.dft, hVar.dft) || !q.l(this.content, hVar.content)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        byte[] bArr = this.dfn;
        int hashCode = (bArr != null ? Arrays.hashCode(bArr) : 0) * 31;
        byte[] bArr2 = this.dfo;
        int hashCode2 = ((((((((((bArr2 != null ? Arrays.hashCode(bArr2) : 0) + hashCode) * 31) + this.dfp) * 31) + this.dfq) * 31) + this.dfr) * 31) + this.dfs) * 31;
        byte[] bArr3 = this.dft;
        int hashCode3 = ((bArr3 != null ? Arrays.hashCode(bArr3) : 0) + hashCode2) * 31;
        byte[] bArr4 = this.content;
        return hashCode3 + (bArr4 != null ? Arrays.hashCode(bArr4) : 0);
    }

    public h(byte[] bArr, byte[] bArr2, byte b, byte b2, short s, int i, byte[] bArr3, byte[] bArr4) {
        this.dfn = bArr;
        this.dfo = bArr2;
        this.dfp = b;
        this.dfq = b2;
        this.dfr = s;
        this.dfs = i;
        this.dft = bArr3;
        this.content = bArr4;
    }

    public /* synthetic */ h(byte[] bArr, byte[] bArr2, byte b, byte b2, short s, int i, byte[] bArr3, byte[] bArr4, int i2, o oVar) {
        this((i2 & 1) != 0 ? new byte[2] : bArr, (i2 & 2) != 0 ? new byte[2] : bArr2, (i2 & 4) != 0 ? (byte) 0 : b, (i2 & 8) != 0 ? (byte) 0 : b2, (i2 & 16) != 0 ? (short) 0 : s, (i2 & 32) != 0 ? 0 : i, (i2 & 64) != 0 ? null : bArr3, (i2 & 128) != 0 ? null : bArr4);
    }

    public final void Q(byte[] bArr) {
        this.dfn = bArr;
    }

    public final byte[] aDo() {
        return this.dfn;
    }

    public final void R(byte[] bArr) {
        this.dfo = bArr;
    }

    public final byte[] aDp() {
        return this.dfo;
    }

    public final byte aDq() {
        return this.dfp;
    }

    public final void c(byte b) {
        this.dfp = b;
    }

    public final byte aDr() {
        return this.dfq;
    }

    public final void d(byte b) {
        this.dfq = b;
    }

    public final short aDs() {
        return this.dfr;
    }

    public final void c(short s) {
        this.dfr = s;
    }

    public final int aDt() {
        return this.dfs;
    }

    public final void iO(int i) {
        this.dfs = i;
    }

    public final void S(byte[] bArr) {
        this.dft = bArr;
    }

    public final byte[] aDu() {
        return this.dft;
    }

    public final byte[] getContent() {
        return this.content;
    }

    public final void setContent(byte[] bArr) {
        this.content = bArr;
    }

    @kotlin.h
    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(o oVar) {
            this();
        }

        public final h aDv() {
            h hVar = new h(null, null, (byte) 0, (byte) 0, (short) 0, 0, null, null, 255, null);
            hVar.Q(new byte[2]);
            byte[] aDo = hVar.aDo();
            if (aDo != null) {
                aDo[0] = 0;
            }
            byte[] aDo2 = hVar.aDo();
            if (aDo2 != null) {
                aDo2[1] = 2;
            }
            hVar.R(new byte[2]);
            byte[] aDp = hVar.aDp();
            if (aDp != null) {
                aDp[0] = -27;
            }
            byte[] aDp2 = hVar.aDp();
            if (aDp2 != null) {
                aDp2[1] = -89;
            }
            return hVar;
        }
    }

    public String toString() {
        return "RecordParams(protocolVersion=" + Arrays.toString(this.dfn) + ", schemeType=" + ((int) this.dfp) + ", schemeExtType=" + ((int) this.dfq) + ", schemeLen=" + ((int) this.dfr) + ", contentLen=" + this.dfs + ", scheme=" + Arrays.toString(this.dft) + ')';
    }
}
