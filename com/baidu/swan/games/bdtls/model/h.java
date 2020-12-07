package com.baidu.swan.games.bdtls.model;

import java.util.Arrays;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.p;
@kotlin.e
/* loaded from: classes25.dex */
public final class h {
    public static final a dXr = new a(null);
    private byte[] content;
    private byte[] dXk;
    private byte[] dXl;
    private byte dXm;
    private byte dXn;
    private short dXo;
    private int dXp;
    private byte[] dXq;

    public h() {
        this(null, null, (byte) 0, (byte) 0, (short) 0, 0, null, null, 255, null);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof h)) {
                return false;
            }
            h hVar = (h) obj;
            if (!p.l(this.dXk, hVar.dXk) || !p.l(this.dXl, hVar.dXl)) {
                return false;
            }
            if (!(this.dXm == hVar.dXm)) {
                return false;
            }
            if (!(this.dXn == hVar.dXn)) {
                return false;
            }
            if (!(this.dXo == hVar.dXo)) {
                return false;
            }
            if (!(this.dXp == hVar.dXp) || !p.l(this.dXq, hVar.dXq) || !p.l(this.content, hVar.content)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        byte[] bArr = this.dXk;
        int hashCode = (bArr != null ? Arrays.hashCode(bArr) : 0) * 31;
        byte[] bArr2 = this.dXl;
        int hashCode2 = ((((((((((bArr2 != null ? Arrays.hashCode(bArr2) : 0) + hashCode) * 31) + this.dXm) * 31) + this.dXn) * 31) + this.dXo) * 31) + this.dXp) * 31;
        byte[] bArr3 = this.dXq;
        int hashCode3 = ((bArr3 != null ? Arrays.hashCode(bArr3) : 0) + hashCode2) * 31;
        byte[] bArr4 = this.content;
        return hashCode3 + (bArr4 != null ? Arrays.hashCode(bArr4) : 0);
    }

    public h(byte[] bArr, byte[] bArr2, byte b, byte b2, short s, int i, byte[] bArr3, byte[] bArr4) {
        this.dXk = bArr;
        this.dXl = bArr2;
        this.dXm = b;
        this.dXn = b2;
        this.dXo = s;
        this.dXp = i;
        this.dXq = bArr3;
        this.content = bArr4;
    }

    public /* synthetic */ h(byte[] bArr, byte[] bArr2, byte b, byte b2, short s, int i, byte[] bArr3, byte[] bArr4, int i2, o oVar) {
        this((i2 & 1) != 0 ? new byte[2] : bArr, (i2 & 2) != 0 ? new byte[2] : bArr2, (i2 & 4) != 0 ? (byte) 0 : b, (i2 & 8) != 0 ? (byte) 0 : b2, (i2 & 16) != 0 ? (short) 0 : s, (i2 & 32) != 0 ? 0 : i, (i2 & 64) != 0 ? null : bArr3, (i2 & 128) != 0 ? null : bArr4);
    }

    public final void T(byte[] bArr) {
        this.dXk = bArr;
    }

    public final byte[] aWo() {
        return this.dXk;
    }

    public final void U(byte[] bArr) {
        this.dXl = bArr;
    }

    public final byte[] aWp() {
        return this.dXl;
    }

    public final byte aWq() {
        return this.dXm;
    }

    public final void c(byte b) {
        this.dXm = b;
    }

    public final byte aWr() {
        return this.dXn;
    }

    public final void d(byte b) {
        this.dXn = b;
    }

    public final short aWs() {
        return this.dXo;
    }

    public final void d(short s) {
        this.dXo = s;
    }

    public final int aWt() {
        return this.dXp;
    }

    public final void mu(int i) {
        this.dXp = i;
    }

    public final void V(byte[] bArr) {
        this.dXq = bArr;
    }

    public final byte[] aWu() {
        return this.dXq;
    }

    public final byte[] getContent() {
        return this.content;
    }

    public final void setContent(byte[] bArr) {
        this.content = bArr;
    }

    @kotlin.e
    /* loaded from: classes25.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(o oVar) {
            this();
        }

        public final h aWv() {
            h hVar = new h(null, null, (byte) 0, (byte) 0, (short) 0, 0, null, null, 255, null);
            hVar.T(new byte[2]);
            byte[] aWo = hVar.aWo();
            if (aWo != null) {
                aWo[0] = 0;
            }
            byte[] aWo2 = hVar.aWo();
            if (aWo2 != null) {
                aWo2[1] = 2;
            }
            hVar.U(new byte[2]);
            byte[] aWp = hVar.aWp();
            if (aWp != null) {
                aWp[0] = -27;
            }
            byte[] aWp2 = hVar.aWp();
            if (aWp2 != null) {
                aWp2[1] = -89;
            }
            return hVar;
        }
    }

    public String toString() {
        return "RecordParams(protocolVersion=" + Arrays.toString(this.dXk) + ", schemeType=" + ((int) this.dXm) + ", schemeExtType=" + ((int) this.dXn) + ", schemeLen=" + ((int) this.dXo) + ", contentLen=" + this.dXp + ", scheme=" + Arrays.toString(this.dXq) + ')';
    }
}
