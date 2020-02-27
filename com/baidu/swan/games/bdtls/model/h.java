package com.baidu.swan.games.bdtls.model;

import java.util.Arrays;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes11.dex */
public final class h {
    public static final a clc = new a(null);
    private byte[] ckV;
    private byte[] ckW;
    private byte ckX;
    private byte ckY;
    private short ckZ;
    private int cla;
    private byte[] clb;
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
            if (!q.h(this.ckV, hVar.ckV) || !q.h(this.ckW, hVar.ckW)) {
                return false;
            }
            if (!(this.ckX == hVar.ckX)) {
                return false;
            }
            if (!(this.ckY == hVar.ckY)) {
                return false;
            }
            if (!(this.ckZ == hVar.ckZ)) {
                return false;
            }
            if (!(this.cla == hVar.cla) || !q.h(this.clb, hVar.clb) || !q.h(this.content, hVar.content)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        byte[] bArr = this.ckV;
        int hashCode = (bArr != null ? Arrays.hashCode(bArr) : 0) * 31;
        byte[] bArr2 = this.ckW;
        int hashCode2 = ((((((((((bArr2 != null ? Arrays.hashCode(bArr2) : 0) + hashCode) * 31) + this.ckX) * 31) + this.ckY) * 31) + this.ckZ) * 31) + this.cla) * 31;
        byte[] bArr3 = this.clb;
        int hashCode3 = ((bArr3 != null ? Arrays.hashCode(bArr3) : 0) + hashCode2) * 31;
        byte[] bArr4 = this.content;
        return hashCode3 + (bArr4 != null ? Arrays.hashCode(bArr4) : 0);
    }

    public h(byte[] bArr, byte[] bArr2, byte b, byte b2, short s, int i, byte[] bArr3, byte[] bArr4) {
        this.ckV = bArr;
        this.ckW = bArr2;
        this.ckX = b;
        this.ckY = b2;
        this.ckZ = s;
        this.cla = i;
        this.clb = bArr3;
        this.content = bArr4;
    }

    public /* synthetic */ h(byte[] bArr, byte[] bArr2, byte b, byte b2, short s, int i, byte[] bArr3, byte[] bArr4, int i2, o oVar) {
        this((i2 & 1) != 0 ? new byte[2] : bArr, (i2 & 2) != 0 ? new byte[2] : bArr2, (i2 & 4) != 0 ? (byte) 0 : b, (i2 & 8) != 0 ? (byte) 0 : b2, (i2 & 16) != 0 ? (short) 0 : s, (i2 & 32) != 0 ? 0 : i, (i2 & 64) != 0 ? null : bArr3, (i2 & 128) != 0 ? null : bArr4);
    }

    public final void F(byte[] bArr) {
        this.ckV = bArr;
    }

    public final byte[] amx() {
        return this.ckV;
    }

    public final void G(byte[] bArr) {
        this.ckW = bArr;
    }

    public final byte[] amy() {
        return this.ckW;
    }

    public final byte amz() {
        return this.ckX;
    }

    public final void b(byte b) {
        this.ckX = b;
    }

    public final byte amA() {
        return this.ckY;
    }

    public final void c(byte b) {
        this.ckY = b;
    }

    public final short amB() {
        return this.ckZ;
    }

    public final void c(short s) {
        this.ckZ = s;
    }

    public final int amC() {
        return this.cla;
    }

    public final void hM(int i) {
        this.cla = i;
    }

    public final void H(byte[] bArr) {
        this.clb = bArr;
    }

    public final byte[] amD() {
        return this.clb;
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

        public final h amE() {
            h hVar = new h(null, null, (byte) 0, (byte) 0, (short) 0, 0, null, null, 255, null);
            hVar.F(new byte[2]);
            byte[] amx = hVar.amx();
            if (amx != null) {
                amx[0] = 0;
            }
            byte[] amx2 = hVar.amx();
            if (amx2 != null) {
                amx2[1] = 1;
            }
            hVar.G(new byte[2]);
            byte[] amy = hVar.amy();
            if (amy != null) {
                amy[0] = -27;
            }
            byte[] amy2 = hVar.amy();
            if (amy2 != null) {
                amy2[1] = -89;
            }
            return hVar;
        }
    }

    public String toString() {
        return "RecordParams(protocolVersion=" + Arrays.toString(this.ckV) + ", schemeType=" + ((int) this.ckX) + ", schemeExtType=" + ((int) this.ckY) + ", schemeLen=" + ((int) this.ckZ) + ", contentLen=" + this.cla + ", scheme=" + Arrays.toString(this.clb) + ')';
    }
}
