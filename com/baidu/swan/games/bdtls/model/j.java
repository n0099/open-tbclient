package com.baidu.swan.games.bdtls.model;

import android.util.Log;
import java.util.Arrays;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes7.dex */
public final class j {
    private long aTl;
    private Integer dQA;
    private Integer dQB;
    private byte[] dQC;
    private byte[] dQD;
    private byte[] dQE;
    private int dQw;
    private volatile int dQx;
    private Integer dQy;
    private Integer dQz;

    public j() {
        this(null, null, null, null, null, null, 0L, null, 255, null);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof j)) {
                return false;
            }
            j jVar = (j) obj;
            if (!q.l(this.dQy, jVar.dQy) || !q.l(this.dQz, jVar.dQz) || !q.l(this.dQA, jVar.dQA) || !q.l(this.dQB, jVar.dQB) || !q.l(this.dQC, jVar.dQC) || !q.l(this.dQD, jVar.dQD)) {
                return false;
            }
            if (!(this.aTl == jVar.aTl) || !q.l(this.dQE, jVar.dQE)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        Integer num = this.dQy;
        int hashCode = (num != null ? num.hashCode() : 0) * 31;
        Integer num2 = this.dQz;
        int hashCode2 = ((num2 != null ? num2.hashCode() : 0) + hashCode) * 31;
        Integer num3 = this.dQA;
        int hashCode3 = ((num3 != null ? num3.hashCode() : 0) + hashCode2) * 31;
        Integer num4 = this.dQB;
        int hashCode4 = ((num4 != null ? num4.hashCode() : 0) + hashCode3) * 31;
        byte[] bArr = this.dQC;
        int hashCode5 = ((bArr != null ? Arrays.hashCode(bArr) : 0) + hashCode4) * 31;
        byte[] bArr2 = this.dQD;
        int hashCode6 = bArr2 != null ? Arrays.hashCode(bArr2) : 0;
        long j = this.aTl;
        int i = (((hashCode6 + hashCode5) * 31) + ((int) (j ^ (j >>> 32)))) * 31;
        byte[] bArr3 = this.dQE;
        return i + (bArr3 != null ? Arrays.hashCode(bArr3) : 0);
    }

    public String toString() {
        return "SessionParams(dhGroupId=" + this.dQy + ", dhSecretKey=" + this.dQz + ", dhPublicKey=" + this.dQA + ", dhServerPublicKey=" + this.dQB + ", aesSecretKey=" + Arrays.toString(this.dQC) + ", sessionTicket=" + Arrays.toString(this.dQD) + ", expireTime=" + this.aTl + ", entryType=" + Arrays.toString(this.dQE) + ")";
    }

    public j(Integer num, Integer num2, Integer num3, Integer num4, byte[] bArr, byte[] bArr2, long j, byte[] bArr3) {
        this.dQy = num;
        this.dQz = num2;
        this.dQA = num3;
        this.dQB = num4;
        this.dQC = bArr;
        this.dQD = bArr2;
        this.aTl = j;
        this.dQE = bArr3;
    }

    public /* synthetic */ j(Integer num, Integer num2, Integer num3, Integer num4, byte[] bArr, byte[] bArr2, long j, byte[] bArr3, int i, o oVar) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : num3, (i & 8) != 0 ? null : num4, (i & 16) != 0 ? null : bArr, (i & 32) != 0 ? null : bArr2, (i & 64) != 0 ? 0L : j, (i & 128) != 0 ? null : bArr3);
    }

    public final Integer aTx() {
        return this.dQy;
    }

    public final void g(Integer num) {
        this.dQy = num;
    }

    public final Integer aTy() {
        return this.dQz;
    }

    public final void h(Integer num) {
        this.dQz = num;
    }

    public final Integer aTz() {
        return this.dQA;
    }

    public final void i(Integer num) {
        this.dQA = num;
    }

    public final Integer aTA() {
        return this.dQB;
    }

    public final void j(Integer num) {
        this.dQB = num;
    }

    public final void U(byte[] bArr) {
        this.dQC = bArr;
    }

    public final byte[] aTB() {
        return this.dQC;
    }

    public final void V(byte[] bArr) {
        this.dQD = bArr;
    }

    public final byte[] aTC() {
        return this.dQD;
    }

    public final void E(long j) {
        this.aTl = j;
    }

    public final void W(byte[] bArr) {
        this.dQE = bArr;
    }

    public final int aTs() {
        return this.dQw;
    }

    public final void lX(int i) {
        this.dQw = i;
    }

    public final void aTt() {
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.d("BDTLS", "Recovery: add recoveryCount: " + this.dQx);
        }
        this.dQx++;
    }

    public final synchronized boolean aTu() {
        boolean z = true;
        synchronized (this) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (this.dQC == null || this.dQD == null || this.aTl <= currentTimeMillis || this.dQw != 1) {
                z = false;
            }
            if (com.baidu.swan.games.bdtls.a.DEBUG) {
                Log.d("BDTLS", "isSessionEnable " + this.dQC + ' ' + this.dQD + ' ' + this.aTl + ' ' + this.dQw);
            }
        }
        return z;
    }

    public final boolean aTv() {
        return this.dQx < 3;
    }

    public final void aTw() {
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.d("BDTLS", "Downgrade: reset downgrade count " + this.dQx);
        }
        this.dQx = 0;
    }
}
