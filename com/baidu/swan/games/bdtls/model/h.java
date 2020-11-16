package com.baidu.swan.games.bdtls.model;

import java.util.Arrays;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes7.dex */
public final class h {
    public static final a dQt = new a(null);
    private byte[] content;
    private byte[] dQm;
    private byte[] dQn;
    private byte dQo;
    private byte dQp;
    private short dQq;
    private int dQr;
    private byte[] dQs;

    public h() {
        this(null, null, (byte) 0, (byte) 0, (short) 0, 0, null, null, 255, null);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof h)) {
                return false;
            }
            h hVar = (h) obj;
            if (!q.l(this.dQm, hVar.dQm) || !q.l(this.dQn, hVar.dQn)) {
                return false;
            }
            if (!(this.dQo == hVar.dQo)) {
                return false;
            }
            if (!(this.dQp == hVar.dQp)) {
                return false;
            }
            if (!(this.dQq == hVar.dQq)) {
                return false;
            }
            if (!(this.dQr == hVar.dQr) || !q.l(this.dQs, hVar.dQs) || !q.l(this.content, hVar.content)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        byte[] bArr = this.dQm;
        int hashCode = (bArr != null ? Arrays.hashCode(bArr) : 0) * 31;
        byte[] bArr2 = this.dQn;
        int hashCode2 = ((((((((((bArr2 != null ? Arrays.hashCode(bArr2) : 0) + hashCode) * 31) + this.dQo) * 31) + this.dQp) * 31) + this.dQq) * 31) + this.dQr) * 31;
        byte[] bArr3 = this.dQs;
        int hashCode3 = ((bArr3 != null ? Arrays.hashCode(bArr3) : 0) + hashCode2) * 31;
        byte[] bArr4 = this.content;
        return hashCode3 + (bArr4 != null ? Arrays.hashCode(bArr4) : 0);
    }

    public h(byte[] bArr, byte[] bArr2, byte b, byte b2, short s, int i, byte[] bArr3, byte[] bArr4) {
        this.dQm = bArr;
        this.dQn = bArr2;
        this.dQo = b;
        this.dQp = b2;
        this.dQq = s;
        this.dQr = i;
        this.dQs = bArr3;
        this.content = bArr4;
    }

    public /* synthetic */ h(byte[] bArr, byte[] bArr2, byte b, byte b2, short s, int i, byte[] bArr3, byte[] bArr4, int i2, o oVar) {
        this((i2 & 1) != 0 ? new byte[2] : bArr, (i2 & 2) != 0 ? new byte[2] : bArr2, (i2 & 4) != 0 ? (byte) 0 : b, (i2 & 8) != 0 ? (byte) 0 : b2, (i2 & 16) != 0 ? (short) 0 : s, (i2 & 32) != 0 ? 0 : i, (i2 & 64) != 0 ? null : bArr3, (i2 & 128) != 0 ? null : bArr4);
    }

    public final void R(byte[] bArr) {
        this.dQm = bArr;
    }

    public final byte[] aTj() {
        return this.dQm;
    }

    public final void S(byte[] bArr) {
        this.dQn = bArr;
    }

    public final byte[] aTk() {
        return this.dQn;
    }

    public final byte aTl() {
        return this.dQo;
    }

    public final void c(byte b) {
        this.dQo = b;
    }

    public final byte aTm() {
        return this.dQp;
    }

    public final void d(byte b) {
        this.dQp = b;
    }

    public final short aTn() {
        return this.dQq;
    }

    public final void d(short s) {
        this.dQq = s;
    }

    public final int aTo() {
        return this.dQr;
    }

    public final void lW(int i) {
        this.dQr = i;
    }

    public final void T(byte[] bArr) {
        this.dQs = bArr;
    }

    public final byte[] aTp() {
        return this.dQs;
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

        public final h aTq() {
            h hVar = new h(null, null, (byte) 0, (byte) 0, (short) 0, 0, null, null, 255, null);
            hVar.R(new byte[2]);
            byte[] aTj = hVar.aTj();
            if (aTj != null) {
                aTj[0] = 0;
            }
            byte[] aTj2 = hVar.aTj();
            if (aTj2 != null) {
                aTj2[1] = 2;
            }
            hVar.S(new byte[2]);
            byte[] aTk = hVar.aTk();
            if (aTk != null) {
                aTk[0] = -27;
            }
            byte[] aTk2 = hVar.aTk();
            if (aTk2 != null) {
                aTk2[1] = -89;
            }
            return hVar;
        }
    }

    public String toString() {
        return "RecordParams(protocolVersion=" + Arrays.toString(this.dQm) + ", schemeType=" + ((int) this.dQo) + ", schemeExtType=" + ((int) this.dQp) + ", schemeLen=" + ((int) this.dQq) + ", contentLen=" + this.dQr + ", scheme=" + Arrays.toString(this.dQs) + ')';
    }
}
