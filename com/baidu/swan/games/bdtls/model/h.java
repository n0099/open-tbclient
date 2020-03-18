package com.baidu.swan.games.bdtls.model;

import java.util.Arrays;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes11.dex */
public final class h {
    public static final a clp = new a(null);
    private byte[] cli;
    private byte[] clj;
    private byte clk;
    private byte cll;
    private short clm;
    private int cln;
    private byte[] clo;
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
            if (!q.h(this.cli, hVar.cli) || !q.h(this.clj, hVar.clj)) {
                return false;
            }
            if (!(this.clk == hVar.clk)) {
                return false;
            }
            if (!(this.cll == hVar.cll)) {
                return false;
            }
            if (!(this.clm == hVar.clm)) {
                return false;
            }
            if (!(this.cln == hVar.cln) || !q.h(this.clo, hVar.clo) || !q.h(this.content, hVar.content)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        byte[] bArr = this.cli;
        int hashCode = (bArr != null ? Arrays.hashCode(bArr) : 0) * 31;
        byte[] bArr2 = this.clj;
        int hashCode2 = ((((((((((bArr2 != null ? Arrays.hashCode(bArr2) : 0) + hashCode) * 31) + this.clk) * 31) + this.cll) * 31) + this.clm) * 31) + this.cln) * 31;
        byte[] bArr3 = this.clo;
        int hashCode3 = ((bArr3 != null ? Arrays.hashCode(bArr3) : 0) + hashCode2) * 31;
        byte[] bArr4 = this.content;
        return hashCode3 + (bArr4 != null ? Arrays.hashCode(bArr4) : 0);
    }

    public h(byte[] bArr, byte[] bArr2, byte b, byte b2, short s, int i, byte[] bArr3, byte[] bArr4) {
        this.cli = bArr;
        this.clj = bArr2;
        this.clk = b;
        this.cll = b2;
        this.clm = s;
        this.cln = i;
        this.clo = bArr3;
        this.content = bArr4;
    }

    public /* synthetic */ h(byte[] bArr, byte[] bArr2, byte b, byte b2, short s, int i, byte[] bArr3, byte[] bArr4, int i2, o oVar) {
        this((i2 & 1) != 0 ? new byte[2] : bArr, (i2 & 2) != 0 ? new byte[2] : bArr2, (i2 & 4) != 0 ? (byte) 0 : b, (i2 & 8) != 0 ? (byte) 0 : b2, (i2 & 16) != 0 ? (short) 0 : s, (i2 & 32) != 0 ? 0 : i, (i2 & 64) != 0 ? null : bArr3, (i2 & 128) != 0 ? null : bArr4);
    }

    public final void F(byte[] bArr) {
        this.cli = bArr;
    }

    public final byte[] amC() {
        return this.cli;
    }

    public final void G(byte[] bArr) {
        this.clj = bArr;
    }

    public final byte[] amD() {
        return this.clj;
    }

    public final byte amE() {
        return this.clk;
    }

    public final void b(byte b) {
        this.clk = b;
    }

    public final byte amF() {
        return this.cll;
    }

    public final void c(byte b) {
        this.cll = b;
    }

    public final short amG() {
        return this.clm;
    }

    public final void c(short s) {
        this.clm = s;
    }

    public final int amH() {
        return this.cln;
    }

    public final void hM(int i) {
        this.cln = i;
    }

    public final void H(byte[] bArr) {
        this.clo = bArr;
    }

    public final byte[] amI() {
        return this.clo;
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

        public final h amJ() {
            h hVar = new h(null, null, (byte) 0, (byte) 0, (short) 0, 0, null, null, 255, null);
            hVar.F(new byte[2]);
            byte[] amC = hVar.amC();
            if (amC != null) {
                amC[0] = 0;
            }
            byte[] amC2 = hVar.amC();
            if (amC2 != null) {
                amC2[1] = 1;
            }
            hVar.G(new byte[2]);
            byte[] amD = hVar.amD();
            if (amD != null) {
                amD[0] = -27;
            }
            byte[] amD2 = hVar.amD();
            if (amD2 != null) {
                amD2[1] = -89;
            }
            return hVar;
        }
    }

    public String toString() {
        return "RecordParams(protocolVersion=" + Arrays.toString(this.cli) + ", schemeType=" + ((int) this.clk) + ", schemeExtType=" + ((int) this.cll) + ", schemeLen=" + ((int) this.clm) + ", contentLen=" + this.cln + ", scheme=" + Arrays.toString(this.clo) + ')';
    }
}
