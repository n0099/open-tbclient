package com.baidu.swan.games.bdtls.model;

import java.util.Arrays;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.p;
@kotlin.e
/* loaded from: classes8.dex */
public final class h {
    public static final a efk = new a(null);
    private byte[] content;
    private byte[] efd;
    private byte[] efe;
    private byte eff;
    private byte efg;
    private short efh;
    private int efi;
    private byte[] efj;

    public h() {
        this(null, null, (byte) 0, (byte) 0, (short) 0, 0, null, null, 255, null);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof h)) {
                return false;
            }
            h hVar = (h) obj;
            if (!p.l(this.efd, hVar.efd) || !p.l(this.efe, hVar.efe)) {
                return false;
            }
            if (!(this.eff == hVar.eff)) {
                return false;
            }
            if (!(this.efg == hVar.efg)) {
                return false;
            }
            if (!(this.efh == hVar.efh)) {
                return false;
            }
            if (!(this.efi == hVar.efi) || !p.l(this.efj, hVar.efj) || !p.l(this.content, hVar.content)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        byte[] bArr = this.efd;
        int hashCode = (bArr != null ? Arrays.hashCode(bArr) : 0) * 31;
        byte[] bArr2 = this.efe;
        int hashCode2 = ((((((((((bArr2 != null ? Arrays.hashCode(bArr2) : 0) + hashCode) * 31) + this.eff) * 31) + this.efg) * 31) + this.efh) * 31) + this.efi) * 31;
        byte[] bArr3 = this.efj;
        int hashCode3 = ((bArr3 != null ? Arrays.hashCode(bArr3) : 0) + hashCode2) * 31;
        byte[] bArr4 = this.content;
        return hashCode3 + (bArr4 != null ? Arrays.hashCode(bArr4) : 0);
    }

    public h(byte[] bArr, byte[] bArr2, byte b, byte b2, short s, int i, byte[] bArr3, byte[] bArr4) {
        this.efd = bArr;
        this.efe = bArr2;
        this.eff = b;
        this.efg = b2;
        this.efh = s;
        this.efi = i;
        this.efj = bArr3;
        this.content = bArr4;
    }

    public /* synthetic */ h(byte[] bArr, byte[] bArr2, byte b, byte b2, short s, int i, byte[] bArr3, byte[] bArr4, int i2, o oVar) {
        this((i2 & 1) != 0 ? new byte[2] : bArr, (i2 & 2) != 0 ? new byte[2] : bArr2, (i2 & 4) != 0 ? (byte) 0 : b, (i2 & 8) != 0 ? (byte) 0 : b2, (i2 & 16) != 0 ? (short) 0 : s, (i2 & 32) != 0 ? 0 : i, (i2 & 64) != 0 ? null : bArr3, (i2 & 128) != 0 ? null : bArr4);
    }

    public final void Q(byte[] bArr) {
        this.efd = bArr;
    }

    public final byte[] aVe() {
        return this.efd;
    }

    public final void R(byte[] bArr) {
        this.efe = bArr;
    }

    public final byte[] aVf() {
        return this.efe;
    }

    public final byte aVg() {
        return this.eff;
    }

    public final void c(byte b) {
        this.eff = b;
    }

    public final byte aVh() {
        return this.efg;
    }

    public final void d(byte b) {
        this.efg = b;
    }

    public final short aVi() {
        return this.efh;
    }

    public final void d(short s) {
        this.efh = s;
    }

    public final int aVj() {
        return this.efi;
    }

    public final void la(int i) {
        this.efi = i;
    }

    public final void S(byte[] bArr) {
        this.efj = bArr;
    }

    public final byte[] aVk() {
        return this.efj;
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

        public final h aVl() {
            h hVar = new h(null, null, (byte) 0, (byte) 0, (short) 0, 0, null, null, 255, null);
            hVar.Q(new byte[2]);
            byte[] aVe = hVar.aVe();
            if (aVe != null) {
                aVe[0] = 0;
            }
            byte[] aVe2 = hVar.aVe();
            if (aVe2 != null) {
                aVe2[1] = 2;
            }
            hVar.R(new byte[2]);
            byte[] aVf = hVar.aVf();
            if (aVf != null) {
                aVf[0] = -27;
            }
            byte[] aVf2 = hVar.aVf();
            if (aVf2 != null) {
                aVf2[1] = -89;
            }
            return hVar;
        }
    }

    public String toString() {
        return "RecordParams(protocolVersion=" + Arrays.toString(this.efd) + ", schemeType=" + ((int) this.eff) + ", schemeExtType=" + ((int) this.efg) + ", schemeLen=" + ((int) this.efh) + ", contentLen=" + this.efi + ", scheme=" + Arrays.toString(this.efj) + ')';
    }
}
