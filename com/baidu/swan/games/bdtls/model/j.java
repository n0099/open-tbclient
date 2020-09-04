package com.baidu.swan.games.bdtls.model;

import android.util.Log;
import java.util.Arrays;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes8.dex */
public final class j {
    private long aNx;
    private int dpK;
    private volatile int dpL;
    private Integer dpM;
    private Integer dpN;
    private Integer dpO;
    private Integer dpP;
    private byte[] dpQ;
    private byte[] dpR;
    private byte[] dpS;

    public j() {
        this(null, null, null, null, null, null, 0L, null, 255, null);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof j)) {
                return false;
            }
            j jVar = (j) obj;
            if (!q.l(this.dpM, jVar.dpM) || !q.l(this.dpN, jVar.dpN) || !q.l(this.dpO, jVar.dpO) || !q.l(this.dpP, jVar.dpP) || !q.l(this.dpQ, jVar.dpQ) || !q.l(this.dpR, jVar.dpR)) {
                return false;
            }
            if (!(this.aNx == jVar.aNx) || !q.l(this.dpS, jVar.dpS)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        Integer num = this.dpM;
        int hashCode = (num != null ? num.hashCode() : 0) * 31;
        Integer num2 = this.dpN;
        int hashCode2 = ((num2 != null ? num2.hashCode() : 0) + hashCode) * 31;
        Integer num3 = this.dpO;
        int hashCode3 = ((num3 != null ? num3.hashCode() : 0) + hashCode2) * 31;
        Integer num4 = this.dpP;
        int hashCode4 = ((num4 != null ? num4.hashCode() : 0) + hashCode3) * 31;
        byte[] bArr = this.dpQ;
        int hashCode5 = ((bArr != null ? Arrays.hashCode(bArr) : 0) + hashCode4) * 31;
        byte[] bArr2 = this.dpR;
        int hashCode6 = bArr2 != null ? Arrays.hashCode(bArr2) : 0;
        long j = this.aNx;
        int i = (((hashCode6 + hashCode5) * 31) + ((int) (j ^ (j >>> 32)))) * 31;
        byte[] bArr3 = this.dpS;
        return i + (bArr3 != null ? Arrays.hashCode(bArr3) : 0);
    }

    public String toString() {
        return "SessionParams(dhGroupId=" + this.dpM + ", dhSecretKey=" + this.dpN + ", dhPublicKey=" + this.dpO + ", dhServerPublicKey=" + this.dpP + ", aesSecretKey=" + Arrays.toString(this.dpQ) + ", sessionTicket=" + Arrays.toString(this.dpR) + ", expireTime=" + this.aNx + ", entryType=" + Arrays.toString(this.dpS) + ")";
    }

    public j(Integer num, Integer num2, Integer num3, Integer num4, byte[] bArr, byte[] bArr2, long j, byte[] bArr3) {
        this.dpM = num;
        this.dpN = num2;
        this.dpO = num3;
        this.dpP = num4;
        this.dpQ = bArr;
        this.dpR = bArr2;
        this.aNx = j;
        this.dpS = bArr3;
    }

    public /* synthetic */ j(Integer num, Integer num2, Integer num3, Integer num4, byte[] bArr, byte[] bArr2, long j, byte[] bArr3, int i, o oVar) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : num3, (i & 8) != 0 ? null : num4, (i & 16) != 0 ? null : bArr, (i & 32) != 0 ? null : bArr2, (i & 64) != 0 ? 0L : j, (i & 128) != 0 ? null : bArr3);
    }

    public final Integer aMr() {
        return this.dpM;
    }

    public final void e(Integer num) {
        this.dpM = num;
    }

    public final Integer aMs() {
        return this.dpN;
    }

    public final void f(Integer num) {
        this.dpN = num;
    }

    public final Integer aMt() {
        return this.dpO;
    }

    public final void g(Integer num) {
        this.dpO = num;
    }

    public final Integer aMu() {
        return this.dpP;
    }

    public final void h(Integer num) {
        this.dpP = num;
    }

    public final void U(byte[] bArr) {
        this.dpQ = bArr;
    }

    public final byte[] aMv() {
        return this.dpQ;
    }

    public final void V(byte[] bArr) {
        this.dpR = bArr;
    }

    public final byte[] aMw() {
        return this.dpR;
    }

    public final void E(long j) {
        this.aNx = j;
    }

    public final void W(byte[] bArr) {
        this.dpS = bArr;
    }

    public final int aMm() {
        return this.dpK;
    }

    public final void kY(int i) {
        this.dpK = i;
    }

    public final void aMn() {
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.d("BDTLS", "Recovery: add recoveryCount: " + this.dpL);
        }
        this.dpL++;
    }

    public final synchronized boolean aMo() {
        boolean z = true;
        synchronized (this) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (this.dpQ == null || this.dpR == null || this.aNx <= currentTimeMillis || this.dpK != 1) {
                z = false;
            }
            if (com.baidu.swan.games.bdtls.a.DEBUG) {
                Log.d("BDTLS", "isSessionEnable " + this.dpQ + ' ' + this.dpR + ' ' + this.aNx + ' ' + this.dpK);
            }
        }
        return z;
    }

    public final boolean aMp() {
        return this.dpL < 3;
    }

    public final void aMq() {
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.d("BDTLS", "Downgrade: reset downgrade count " + this.dpL);
        }
        this.dpL = 0;
    }
}
