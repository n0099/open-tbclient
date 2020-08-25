package com.baidu.swan.games.bdtls.model;

import android.util.Log;
import java.util.Arrays;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes8.dex */
public final class j {
    private long aNv;
    private int dpG;
    private volatile int dpH;
    private Integer dpI;
    private Integer dpJ;
    private Integer dpK;
    private Integer dpL;
    private byte[] dpM;
    private byte[] dpN;
    private byte[] dpO;

    public j() {
        this(null, null, null, null, null, null, 0L, null, 255, null);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof j)) {
                return false;
            }
            j jVar = (j) obj;
            if (!q.l(this.dpI, jVar.dpI) || !q.l(this.dpJ, jVar.dpJ) || !q.l(this.dpK, jVar.dpK) || !q.l(this.dpL, jVar.dpL) || !q.l(this.dpM, jVar.dpM) || !q.l(this.dpN, jVar.dpN)) {
                return false;
            }
            if (!(this.aNv == jVar.aNv) || !q.l(this.dpO, jVar.dpO)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        Integer num = this.dpI;
        int hashCode = (num != null ? num.hashCode() : 0) * 31;
        Integer num2 = this.dpJ;
        int hashCode2 = ((num2 != null ? num2.hashCode() : 0) + hashCode) * 31;
        Integer num3 = this.dpK;
        int hashCode3 = ((num3 != null ? num3.hashCode() : 0) + hashCode2) * 31;
        Integer num4 = this.dpL;
        int hashCode4 = ((num4 != null ? num4.hashCode() : 0) + hashCode3) * 31;
        byte[] bArr = this.dpM;
        int hashCode5 = ((bArr != null ? Arrays.hashCode(bArr) : 0) + hashCode4) * 31;
        byte[] bArr2 = this.dpN;
        int hashCode6 = bArr2 != null ? Arrays.hashCode(bArr2) : 0;
        long j = this.aNv;
        int i = (((hashCode6 + hashCode5) * 31) + ((int) (j ^ (j >>> 32)))) * 31;
        byte[] bArr3 = this.dpO;
        return i + (bArr3 != null ? Arrays.hashCode(bArr3) : 0);
    }

    public String toString() {
        return "SessionParams(dhGroupId=" + this.dpI + ", dhSecretKey=" + this.dpJ + ", dhPublicKey=" + this.dpK + ", dhServerPublicKey=" + this.dpL + ", aesSecretKey=" + Arrays.toString(this.dpM) + ", sessionTicket=" + Arrays.toString(this.dpN) + ", expireTime=" + this.aNv + ", entryType=" + Arrays.toString(this.dpO) + ")";
    }

    public j(Integer num, Integer num2, Integer num3, Integer num4, byte[] bArr, byte[] bArr2, long j, byte[] bArr3) {
        this.dpI = num;
        this.dpJ = num2;
        this.dpK = num3;
        this.dpL = num4;
        this.dpM = bArr;
        this.dpN = bArr2;
        this.aNv = j;
        this.dpO = bArr3;
    }

    public /* synthetic */ j(Integer num, Integer num2, Integer num3, Integer num4, byte[] bArr, byte[] bArr2, long j, byte[] bArr3, int i, o oVar) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : num3, (i & 8) != 0 ? null : num4, (i & 16) != 0 ? null : bArr, (i & 32) != 0 ? null : bArr2, (i & 64) != 0 ? 0L : j, (i & 128) != 0 ? null : bArr3);
    }

    public final Integer aMr() {
        return this.dpI;
    }

    public final void e(Integer num) {
        this.dpI = num;
    }

    public final Integer aMs() {
        return this.dpJ;
    }

    public final void f(Integer num) {
        this.dpJ = num;
    }

    public final Integer aMt() {
        return this.dpK;
    }

    public final void g(Integer num) {
        this.dpK = num;
    }

    public final Integer aMu() {
        return this.dpL;
    }

    public final void h(Integer num) {
        this.dpL = num;
    }

    public final void U(byte[] bArr) {
        this.dpM = bArr;
    }

    public final byte[] aMv() {
        return this.dpM;
    }

    public final void V(byte[] bArr) {
        this.dpN = bArr;
    }

    public final byte[] aMw() {
        return this.dpN;
    }

    public final void E(long j) {
        this.aNv = j;
    }

    public final void W(byte[] bArr) {
        this.dpO = bArr;
    }

    public final int aMm() {
        return this.dpG;
    }

    public final void kY(int i) {
        this.dpG = i;
    }

    public final void aMn() {
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.d("BDTLS", "Recovery: add recoveryCount: " + this.dpH);
        }
        this.dpH++;
    }

    public final synchronized boolean aMo() {
        boolean z = true;
        synchronized (this) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (this.dpM == null || this.dpN == null || this.aNv <= currentTimeMillis || this.dpG != 1) {
                z = false;
            }
            if (com.baidu.swan.games.bdtls.a.DEBUG) {
                Log.d("BDTLS", "isSessionEnable " + this.dpM + ' ' + this.dpN + ' ' + this.aNv + ' ' + this.dpG);
            }
        }
        return z;
    }

    public final boolean aMp() {
        return this.dpH < 3;
    }

    public final void aMq() {
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.d("BDTLS", "Downgrade: reset downgrade count " + this.dpH);
        }
        this.dpH = 0;
    }
}
