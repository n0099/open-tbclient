package com.baidu.swan.games.bdtls.model;

import android.util.Log;
import java.util.Arrays;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes3.dex */
public final class j {
    private long aPw;
    private int drM;
    private volatile int drN;
    private Integer drO;
    private Integer drP;
    private Integer drQ;
    private Integer drR;
    private byte[] drS;
    private byte[] drT;
    private byte[] drU;

    public j() {
        this(null, null, null, null, null, null, 0L, null, 255, null);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof j)) {
                return false;
            }
            j jVar = (j) obj;
            if (!q.l(this.drO, jVar.drO) || !q.l(this.drP, jVar.drP) || !q.l(this.drQ, jVar.drQ) || !q.l(this.drR, jVar.drR) || !q.l(this.drS, jVar.drS) || !q.l(this.drT, jVar.drT)) {
                return false;
            }
            if (!(this.aPw == jVar.aPw) || !q.l(this.drU, jVar.drU)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        Integer num = this.drO;
        int hashCode = (num != null ? num.hashCode() : 0) * 31;
        Integer num2 = this.drP;
        int hashCode2 = ((num2 != null ? num2.hashCode() : 0) + hashCode) * 31;
        Integer num3 = this.drQ;
        int hashCode3 = ((num3 != null ? num3.hashCode() : 0) + hashCode2) * 31;
        Integer num4 = this.drR;
        int hashCode4 = ((num4 != null ? num4.hashCode() : 0) + hashCode3) * 31;
        byte[] bArr = this.drS;
        int hashCode5 = ((bArr != null ? Arrays.hashCode(bArr) : 0) + hashCode4) * 31;
        byte[] bArr2 = this.drT;
        int hashCode6 = bArr2 != null ? Arrays.hashCode(bArr2) : 0;
        long j = this.aPw;
        int i = (((hashCode6 + hashCode5) * 31) + ((int) (j ^ (j >>> 32)))) * 31;
        byte[] bArr3 = this.drU;
        return i + (bArr3 != null ? Arrays.hashCode(bArr3) : 0);
    }

    public String toString() {
        return "SessionParams(dhGroupId=" + this.drO + ", dhSecretKey=" + this.drP + ", dhPublicKey=" + this.drQ + ", dhServerPublicKey=" + this.drR + ", aesSecretKey=" + Arrays.toString(this.drS) + ", sessionTicket=" + Arrays.toString(this.drT) + ", expireTime=" + this.aPw + ", entryType=" + Arrays.toString(this.drU) + ")";
    }

    public j(Integer num, Integer num2, Integer num3, Integer num4, byte[] bArr, byte[] bArr2, long j, byte[] bArr3) {
        this.drO = num;
        this.drP = num2;
        this.drQ = num3;
        this.drR = num4;
        this.drS = bArr;
        this.drT = bArr2;
        this.aPw = j;
        this.drU = bArr3;
    }

    public /* synthetic */ j(Integer num, Integer num2, Integer num3, Integer num4, byte[] bArr, byte[] bArr2, long j, byte[] bArr3, int i, o oVar) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : num3, (i & 8) != 0 ? null : num4, (i & 16) != 0 ? null : bArr, (i & 32) != 0 ? null : bArr2, (i & 64) != 0 ? 0L : j, (i & 128) != 0 ? null : bArr3);
    }

    public final Integer aNc() {
        return this.drO;
    }

    public final void e(Integer num) {
        this.drO = num;
    }

    public final Integer aNd() {
        return this.drP;
    }

    public final void f(Integer num) {
        this.drP = num;
    }

    public final Integer aNe() {
        return this.drQ;
    }

    public final void g(Integer num) {
        this.drQ = num;
    }

    public final Integer aNf() {
        return this.drR;
    }

    public final void h(Integer num) {
        this.drR = num;
    }

    public final void U(byte[] bArr) {
        this.drS = bArr;
    }

    public final byte[] aNg() {
        return this.drS;
    }

    public final void V(byte[] bArr) {
        this.drT = bArr;
    }

    public final byte[] aNh() {
        return this.drT;
    }

    public final void E(long j) {
        this.aPw = j;
    }

    public final void W(byte[] bArr) {
        this.drU = bArr;
    }

    public final int aMX() {
        return this.drM;
    }

    public final void lj(int i) {
        this.drM = i;
    }

    public final void aMY() {
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.d("BDTLS", "Recovery: add recoveryCount: " + this.drN);
        }
        this.drN++;
    }

    public final synchronized boolean aMZ() {
        boolean z = true;
        synchronized (this) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (this.drS == null || this.drT == null || this.aPw <= currentTimeMillis || this.drM != 1) {
                z = false;
            }
            if (com.baidu.swan.games.bdtls.a.DEBUG) {
                Log.d("BDTLS", "isSessionEnable " + this.drS + ' ' + this.drT + ' ' + this.aPw + ' ' + this.drM);
            }
        }
        return z;
    }

    public final boolean aNa() {
        return this.drN < 3;
    }

    public final void aNb() {
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.d("BDTLS", "Downgrade: reset downgrade count " + this.drN);
        }
        this.drN = 0;
    }
}
