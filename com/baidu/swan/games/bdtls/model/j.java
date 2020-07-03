package com.baidu.swan.games.bdtls.model;

import android.util.Log;
import java.util.Arrays;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes11.dex */
public final class j {
    private long aGP;
    private int cZM;
    private volatile int cZN;
    private Integer cZO;
    private Integer cZP;
    private Integer cZQ;
    private Integer cZR;
    private byte[] cZS;
    private byte[] cZT;
    private byte[] cZU;

    public j() {
        this(null, null, null, null, null, null, 0L, null, 255, null);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof j)) {
                return false;
            }
            j jVar = (j) obj;
            if (!q.l(this.cZO, jVar.cZO) || !q.l(this.cZP, jVar.cZP) || !q.l(this.cZQ, jVar.cZQ) || !q.l(this.cZR, jVar.cZR) || !q.l(this.cZS, jVar.cZS) || !q.l(this.cZT, jVar.cZT)) {
                return false;
            }
            if (!(this.aGP == jVar.aGP) || !q.l(this.cZU, jVar.cZU)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        Integer num = this.cZO;
        int hashCode = (num != null ? num.hashCode() : 0) * 31;
        Integer num2 = this.cZP;
        int hashCode2 = ((num2 != null ? num2.hashCode() : 0) + hashCode) * 31;
        Integer num3 = this.cZQ;
        int hashCode3 = ((num3 != null ? num3.hashCode() : 0) + hashCode2) * 31;
        Integer num4 = this.cZR;
        int hashCode4 = ((num4 != null ? num4.hashCode() : 0) + hashCode3) * 31;
        byte[] bArr = this.cZS;
        int hashCode5 = ((bArr != null ? Arrays.hashCode(bArr) : 0) + hashCode4) * 31;
        byte[] bArr2 = this.cZT;
        int hashCode6 = bArr2 != null ? Arrays.hashCode(bArr2) : 0;
        long j = this.aGP;
        int i = (((hashCode6 + hashCode5) * 31) + ((int) (j ^ (j >>> 32)))) * 31;
        byte[] bArr3 = this.cZU;
        return i + (bArr3 != null ? Arrays.hashCode(bArr3) : 0);
    }

    public String toString() {
        return "SessionParams(dhGroupId=" + this.cZO + ", dhSecretKey=" + this.cZP + ", dhPublicKey=" + this.cZQ + ", dhServerPublicKey=" + this.cZR + ", aesSecretKey=" + Arrays.toString(this.cZS) + ", sessionTicket=" + Arrays.toString(this.cZT) + ", expireTime=" + this.aGP + ", entryType=" + Arrays.toString(this.cZU) + ")";
    }

    public j(Integer num, Integer num2, Integer num3, Integer num4, byte[] bArr, byte[] bArr2, long j, byte[] bArr3) {
        this.cZO = num;
        this.cZP = num2;
        this.cZQ = num3;
        this.cZR = num4;
        this.cZS = bArr;
        this.cZT = bArr2;
        this.aGP = j;
        this.cZU = bArr3;
    }

    public /* synthetic */ j(Integer num, Integer num2, Integer num3, Integer num4, byte[] bArr, byte[] bArr2, long j, byte[] bArr3, int i, o oVar) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : num3, (i & 8) != 0 ? null : num4, (i & 16) != 0 ? null : bArr, (i & 32) != 0 ? null : bArr2, (i & 64) != 0 ? 0L : j, (i & 128) != 0 ? null : bArr3);
    }

    public final Integer azX() {
        return this.cZO;
    }

    public final void d(Integer num) {
        this.cZO = num;
    }

    public final Integer azY() {
        return this.cZP;
    }

    public final void e(Integer num) {
        this.cZP = num;
    }

    public final Integer azZ() {
        return this.cZQ;
    }

    public final void f(Integer num) {
        this.cZQ = num;
    }

    public final Integer aAa() {
        return this.cZR;
    }

    public final void g(Integer num) {
        this.cZR = num;
    }

    public final void T(byte[] bArr) {
        this.cZS = bArr;
    }

    public final byte[] aAb() {
        return this.cZS;
    }

    public final void U(byte[] bArr) {
        this.cZT = bArr;
    }

    public final byte[] aAc() {
        return this.cZT;
    }

    public final void E(long j) {
        this.aGP = j;
    }

    public final void V(byte[] bArr) {
        this.cZU = bArr;
    }

    public final int azS() {
        return this.cZM;
    }

    public final void iy(int i) {
        this.cZM = i;
    }

    public final void azT() {
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.d("BDTLS", "Recovery: add recoveryCount: " + this.cZN);
        }
        this.cZN++;
    }

    public final synchronized boolean azU() {
        boolean z = true;
        synchronized (this) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (this.cZS == null || this.cZT == null || this.aGP <= currentTimeMillis || this.cZM != 1) {
                z = false;
            }
            if (com.baidu.swan.games.bdtls.a.DEBUG) {
                Log.d("BDTLS", "isSessionEnable " + this.cZS + ' ' + this.cZT + ' ' + this.aGP + ' ' + this.cZM);
            }
        }
        return z;
    }

    public final boolean azV() {
        return this.cZN < 3;
    }

    public final void azW() {
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.d("BDTLS", "Downgrade: reset downgrade count " + this.cZN);
        }
        this.cZN = 0;
    }
}
