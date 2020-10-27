package com.baidu.swan.games.bdtls.model;

import java.util.Arrays;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes10.dex */
public final class h {
    public static final a dMj = new a(null);
    private byte[] content;
    private byte[] dMc;
    private byte[] dMd;
    private byte dMe;
    private byte dMf;
    private short dMg;
    private int dMh;
    private byte[] dMi;

    public h() {
        this(null, null, (byte) 0, (byte) 0, (short) 0, 0, null, null, 255, null);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof h)) {
                return false;
            }
            h hVar = (h) obj;
            if (!q.l(this.dMc, hVar.dMc) || !q.l(this.dMd, hVar.dMd)) {
                return false;
            }
            if (!(this.dMe == hVar.dMe)) {
                return false;
            }
            if (!(this.dMf == hVar.dMf)) {
                return false;
            }
            if (!(this.dMg == hVar.dMg)) {
                return false;
            }
            if (!(this.dMh == hVar.dMh) || !q.l(this.dMi, hVar.dMi) || !q.l(this.content, hVar.content)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        byte[] bArr = this.dMc;
        int hashCode = (bArr != null ? Arrays.hashCode(bArr) : 0) * 31;
        byte[] bArr2 = this.dMd;
        int hashCode2 = ((((((((((bArr2 != null ? Arrays.hashCode(bArr2) : 0) + hashCode) * 31) + this.dMe) * 31) + this.dMf) * 31) + this.dMg) * 31) + this.dMh) * 31;
        byte[] bArr3 = this.dMi;
        int hashCode3 = ((bArr3 != null ? Arrays.hashCode(bArr3) : 0) + hashCode2) * 31;
        byte[] bArr4 = this.content;
        return hashCode3 + (bArr4 != null ? Arrays.hashCode(bArr4) : 0);
    }

    public h(byte[] bArr, byte[] bArr2, byte b, byte b2, short s, int i, byte[] bArr3, byte[] bArr4) {
        this.dMc = bArr;
        this.dMd = bArr2;
        this.dMe = b;
        this.dMf = b2;
        this.dMg = s;
        this.dMh = i;
        this.dMi = bArr3;
        this.content = bArr4;
    }

    public /* synthetic */ h(byte[] bArr, byte[] bArr2, byte b, byte b2, short s, int i, byte[] bArr3, byte[] bArr4, int i2, o oVar) {
        this((i2 & 1) != 0 ? new byte[2] : bArr, (i2 & 2) != 0 ? new byte[2] : bArr2, (i2 & 4) != 0 ? (byte) 0 : b, (i2 & 8) != 0 ? (byte) 0 : b2, (i2 & 16) != 0 ? (short) 0 : s, (i2 & 32) != 0 ? 0 : i, (i2 & 64) != 0 ? null : bArr3, (i2 & 128) != 0 ? null : bArr4);
    }

    public final void R(byte[] bArr) {
        this.dMc = bArr;
    }

    public final byte[] aRr() {
        return this.dMc;
    }

    public final void S(byte[] bArr) {
        this.dMd = bArr;
    }

    public final byte[] aRs() {
        return this.dMd;
    }

    public final byte aRt() {
        return this.dMe;
    }

    public final void c(byte b) {
        this.dMe = b;
    }

    public final byte aRu() {
        return this.dMf;
    }

    public final void d(byte b) {
        this.dMf = b;
    }

    public final short aRv() {
        return this.dMg;
    }

    public final void d(short s) {
        this.dMg = s;
    }

    public final int aRw() {
        return this.dMh;
    }

    public final void lQ(int i) {
        this.dMh = i;
    }

    public final void T(byte[] bArr) {
        this.dMi = bArr;
    }

    public final byte[] aRx() {
        return this.dMi;
    }

    public final byte[] getContent() {
        return this.content;
    }

    public final void setContent(byte[] bArr) {
        this.content = bArr;
    }

    @kotlin.h
    /* loaded from: classes10.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(o oVar) {
            this();
        }

        public final h aRy() {
            h hVar = new h(null, null, (byte) 0, (byte) 0, (short) 0, 0, null, null, 255, null);
            hVar.R(new byte[2]);
            byte[] aRr = hVar.aRr();
            if (aRr != null) {
                aRr[0] = 0;
            }
            byte[] aRr2 = hVar.aRr();
            if (aRr2 != null) {
                aRr2[1] = 2;
            }
            hVar.S(new byte[2]);
            byte[] aRs = hVar.aRs();
            if (aRs != null) {
                aRs[0] = -27;
            }
            byte[] aRs2 = hVar.aRs();
            if (aRs2 != null) {
                aRs2[1] = -89;
            }
            return hVar;
        }
    }

    public String toString() {
        return "RecordParams(protocolVersion=" + Arrays.toString(this.dMc) + ", schemeType=" + ((int) this.dMe) + ", schemeExtType=" + ((int) this.dMf) + ", schemeLen=" + ((int) this.dMg) + ", contentLen=" + this.dMh + ", scheme=" + Arrays.toString(this.dMi) + ')';
    }
}
