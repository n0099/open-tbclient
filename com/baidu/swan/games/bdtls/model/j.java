package com.baidu.swan.games.bdtls.model;

import android.util.Log;
import java.util.Arrays;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.p;
@kotlin.e
/* loaded from: classes8.dex */
public final class j {
    private long aTi;
    private int ebF;
    private volatile int ebG;
    private Integer ebH;
    private Integer ebI;
    private Integer ebJ;
    private Integer ebK;
    private byte[] ebL;
    private byte[] ebM;
    private byte[] ebN;

    public j() {
        this(null, null, null, null, null, null, 0L, null, 255, null);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof j)) {
                return false;
            }
            j jVar = (j) obj;
            if (!p.l(this.ebH, jVar.ebH) || !p.l(this.ebI, jVar.ebI) || !p.l(this.ebJ, jVar.ebJ) || !p.l(this.ebK, jVar.ebK) || !p.l(this.ebL, jVar.ebL) || !p.l(this.ebM, jVar.ebM)) {
                return false;
            }
            if (!(this.aTi == jVar.aTi) || !p.l(this.ebN, jVar.ebN)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        Integer num = this.ebH;
        int hashCode = (num != null ? num.hashCode() : 0) * 31;
        Integer num2 = this.ebI;
        int hashCode2 = ((num2 != null ? num2.hashCode() : 0) + hashCode) * 31;
        Integer num3 = this.ebJ;
        int hashCode3 = ((num3 != null ? num3.hashCode() : 0) + hashCode2) * 31;
        Integer num4 = this.ebK;
        int hashCode4 = ((num4 != null ? num4.hashCode() : 0) + hashCode3) * 31;
        byte[] bArr = this.ebL;
        int hashCode5 = ((bArr != null ? Arrays.hashCode(bArr) : 0) + hashCode4) * 31;
        byte[] bArr2 = this.ebM;
        int hashCode6 = bArr2 != null ? Arrays.hashCode(bArr2) : 0;
        long j = this.aTi;
        int i = (((hashCode6 + hashCode5) * 31) + ((int) (j ^ (j >>> 32)))) * 31;
        byte[] bArr3 = this.ebN;
        return i + (bArr3 != null ? Arrays.hashCode(bArr3) : 0);
    }

    public String toString() {
        return "SessionParams(dhGroupId=" + this.ebH + ", dhSecretKey=" + this.ebI + ", dhPublicKey=" + this.ebJ + ", dhServerPublicKey=" + this.ebK + ", aesSecretKey=" + Arrays.toString(this.ebL) + ", sessionTicket=" + Arrays.toString(this.ebM) + ", expireTime=" + this.aTi + ", entryType=" + Arrays.toString(this.ebN) + ")";
    }

    public j(Integer num, Integer num2, Integer num3, Integer num4, byte[] bArr, byte[] bArr2, long j, byte[] bArr3) {
        this.ebH = num;
        this.ebI = num2;
        this.ebJ = num3;
        this.ebK = num4;
        this.ebL = bArr;
        this.ebM = bArr2;
        this.aTi = j;
        this.ebN = bArr3;
    }

    public /* synthetic */ j(Integer num, Integer num2, Integer num3, Integer num4, byte[] bArr, byte[] bArr2, long j, byte[] bArr3, int i, o oVar) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : num3, (i & 8) != 0 ? null : num4, (i & 16) != 0 ? null : bArr, (i & 32) != 0 ? null : bArr2, (i & 64) != 0 ? 0L : j, (i & 128) != 0 ? null : bArr3);
    }

    public final Integer aVd() {
        return this.ebH;
    }

    public final void i(Integer num) {
        this.ebH = num;
    }

    public final Integer aVe() {
        return this.ebI;
    }

    public final void j(Integer num) {
        this.ebI = num;
    }

    public final Integer aVf() {
        return this.ebJ;
    }

    public final void k(Integer num) {
        this.ebJ = num;
    }

    public final Integer aVg() {
        return this.ebK;
    }

    public final void l(Integer num) {
        this.ebK = num;
    }

    public final void S(byte[] bArr) {
        this.ebL = bArr;
    }

    public final byte[] aVh() {
        return this.ebL;
    }

    public final void T(byte[] bArr) {
        this.ebM = bArr;
    }

    public final byte[] aVi() {
        return this.ebM;
    }

    public final void C(long j) {
        this.aTi = j;
    }

    public final void U(byte[] bArr) {
        this.ebN = bArr;
    }

    public final int aUY() {
        return this.ebF;
    }

    public final void kX(int i) {
        this.ebF = i;
    }

    public final void aUZ() {
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.d("BDTLS", "Recovery: add recoveryCount: " + this.ebG);
        }
        this.ebG++;
    }

    public final synchronized boolean aVa() {
        boolean z = true;
        synchronized (this) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (this.ebL == null || this.ebM == null || this.aTi <= currentTimeMillis || this.ebF != 1) {
                z = false;
            }
            if (com.baidu.swan.games.bdtls.a.DEBUG) {
                Log.d("BDTLS", "isSessionEnable " + this.ebL + ' ' + this.ebM + ' ' + this.aTi + ' ' + this.ebF);
            }
        }
        return z;
    }

    public final boolean aVb() {
        return this.ebG < 3;
    }

    public final void aVc() {
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.d("BDTLS", "Downgrade: reset downgrade count " + this.ebG);
        }
        this.ebG = 0;
    }
}
