package com.baidu.swan.games.bdtls.model;

import java.util.Arrays;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes11.dex */
public final class h {
    public static final a cle = new a(null);
    private byte[] ckX;
    private byte[] ckY;
    private byte ckZ;
    private byte cla;
    private short clb;
    private int clc;
    private byte[] cld;
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
            if (!q.h(this.ckX, hVar.ckX) || !q.h(this.ckY, hVar.ckY)) {
                return false;
            }
            if (!(this.ckZ == hVar.ckZ)) {
                return false;
            }
            if (!(this.cla == hVar.cla)) {
                return false;
            }
            if (!(this.clb == hVar.clb)) {
                return false;
            }
            if (!(this.clc == hVar.clc) || !q.h(this.cld, hVar.cld) || !q.h(this.content, hVar.content)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        byte[] bArr = this.ckX;
        int hashCode = (bArr != null ? Arrays.hashCode(bArr) : 0) * 31;
        byte[] bArr2 = this.ckY;
        int hashCode2 = ((((((((((bArr2 != null ? Arrays.hashCode(bArr2) : 0) + hashCode) * 31) + this.ckZ) * 31) + this.cla) * 31) + this.clb) * 31) + this.clc) * 31;
        byte[] bArr3 = this.cld;
        int hashCode3 = ((bArr3 != null ? Arrays.hashCode(bArr3) : 0) + hashCode2) * 31;
        byte[] bArr4 = this.content;
        return hashCode3 + (bArr4 != null ? Arrays.hashCode(bArr4) : 0);
    }

    public h(byte[] bArr, byte[] bArr2, byte b, byte b2, short s, int i, byte[] bArr3, byte[] bArr4) {
        this.ckX = bArr;
        this.ckY = bArr2;
        this.ckZ = b;
        this.cla = b2;
        this.clb = s;
        this.clc = i;
        this.cld = bArr3;
        this.content = bArr4;
    }

    public /* synthetic */ h(byte[] bArr, byte[] bArr2, byte b, byte b2, short s, int i, byte[] bArr3, byte[] bArr4, int i2, o oVar) {
        this((i2 & 1) != 0 ? new byte[2] : bArr, (i2 & 2) != 0 ? new byte[2] : bArr2, (i2 & 4) != 0 ? (byte) 0 : b, (i2 & 8) != 0 ? (byte) 0 : b2, (i2 & 16) != 0 ? (short) 0 : s, (i2 & 32) != 0 ? 0 : i, (i2 & 64) != 0 ? null : bArr3, (i2 & 128) != 0 ? null : bArr4);
    }

    public final void F(byte[] bArr) {
        this.ckX = bArr;
    }

    public final byte[] amz() {
        return this.ckX;
    }

    public final void G(byte[] bArr) {
        this.ckY = bArr;
    }

    public final byte[] amA() {
        return this.ckY;
    }

    public final byte amB() {
        return this.ckZ;
    }

    public final void b(byte b) {
        this.ckZ = b;
    }

    public final byte amC() {
        return this.cla;
    }

    public final void c(byte b) {
        this.cla = b;
    }

    public final short amD() {
        return this.clb;
    }

    public final void c(short s) {
        this.clb = s;
    }

    public final int amE() {
        return this.clc;
    }

    public final void hM(int i) {
        this.clc = i;
    }

    public final void H(byte[] bArr) {
        this.cld = bArr;
    }

    public final byte[] amF() {
        return this.cld;
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

        public final h amG() {
            h hVar = new h(null, null, (byte) 0, (byte) 0, (short) 0, 0, null, null, 255, null);
            hVar.F(new byte[2]);
            byte[] amz = hVar.amz();
            if (amz != null) {
                amz[0] = 0;
            }
            byte[] amz2 = hVar.amz();
            if (amz2 != null) {
                amz2[1] = 1;
            }
            hVar.G(new byte[2]);
            byte[] amA = hVar.amA();
            if (amA != null) {
                amA[0] = -27;
            }
            byte[] amA2 = hVar.amA();
            if (amA2 != null) {
                amA2[1] = -89;
            }
            return hVar;
        }
    }

    public String toString() {
        return "RecordParams(protocolVersion=" + Arrays.toString(this.ckX) + ", schemeType=" + ((int) this.ckZ) + ", schemeExtType=" + ((int) this.cla) + ", schemeLen=" + ((int) this.clb) + ", contentLen=" + this.clc + ", scheme=" + Arrays.toString(this.cld) + ')';
    }
}
