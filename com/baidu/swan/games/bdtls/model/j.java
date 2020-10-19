package com.baidu.swan.games.bdtls.model;

import android.util.Log;
import java.util.Arrays;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes10.dex */
public final class j {
    private long aSH;
    private int dDP;
    private volatile int dDQ;
    private Integer dDR;
    private Integer dDS;
    private Integer dDT;
    private Integer dDU;
    private byte[] dDV;
    private byte[] dDW;
    private byte[] dDX;

    public j() {
        this(null, null, null, null, null, null, 0L, null, 255, null);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof j)) {
                return false;
            }
            j jVar = (j) obj;
            if (!q.l(this.dDR, jVar.dDR) || !q.l(this.dDS, jVar.dDS) || !q.l(this.dDT, jVar.dDT) || !q.l(this.dDU, jVar.dDU) || !q.l(this.dDV, jVar.dDV) || !q.l(this.dDW, jVar.dDW)) {
                return false;
            }
            if (!(this.aSH == jVar.aSH) || !q.l(this.dDX, jVar.dDX)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        Integer num = this.dDR;
        int hashCode = (num != null ? num.hashCode() : 0) * 31;
        Integer num2 = this.dDS;
        int hashCode2 = ((num2 != null ? num2.hashCode() : 0) + hashCode) * 31;
        Integer num3 = this.dDT;
        int hashCode3 = ((num3 != null ? num3.hashCode() : 0) + hashCode2) * 31;
        Integer num4 = this.dDU;
        int hashCode4 = ((num4 != null ? num4.hashCode() : 0) + hashCode3) * 31;
        byte[] bArr = this.dDV;
        int hashCode5 = ((bArr != null ? Arrays.hashCode(bArr) : 0) + hashCode4) * 31;
        byte[] bArr2 = this.dDW;
        int hashCode6 = bArr2 != null ? Arrays.hashCode(bArr2) : 0;
        long j = this.aSH;
        int i = (((hashCode6 + hashCode5) * 31) + ((int) (j ^ (j >>> 32)))) * 31;
        byte[] bArr3 = this.dDX;
        return i + (bArr3 != null ? Arrays.hashCode(bArr3) : 0);
    }

    public String toString() {
        return "SessionParams(dhGroupId=" + this.dDR + ", dhSecretKey=" + this.dDS + ", dhPublicKey=" + this.dDT + ", dhServerPublicKey=" + this.dDU + ", aesSecretKey=" + Arrays.toString(this.dDV) + ", sessionTicket=" + Arrays.toString(this.dDW) + ", expireTime=" + this.aSH + ", entryType=" + Arrays.toString(this.dDX) + ")";
    }

    public j(Integer num, Integer num2, Integer num3, Integer num4, byte[] bArr, byte[] bArr2, long j, byte[] bArr3) {
        this.dDR = num;
        this.dDS = num2;
        this.dDT = num3;
        this.dDU = num4;
        this.dDV = bArr;
        this.dDW = bArr2;
        this.aSH = j;
        this.dDX = bArr3;
    }

    public /* synthetic */ j(Integer num, Integer num2, Integer num3, Integer num4, byte[] bArr, byte[] bArr2, long j, byte[] bArr3, int i, o oVar) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : num3, (i & 8) != 0 ? null : num4, (i & 16) != 0 ? null : bArr, (i & 32) != 0 ? null : bArr2, (i & 64) != 0 ? 0L : j, (i & 128) != 0 ? null : bArr3);
    }

    public final Integer aPL() {
        return this.dDR;
    }

    public final void g(Integer num) {
        this.dDR = num;
    }

    public final Integer aPM() {
        return this.dDS;
    }

    public final void h(Integer num) {
        this.dDS = num;
    }

    public final Integer aPN() {
        return this.dDT;
    }

    public final void i(Integer num) {
        this.dDT = num;
    }

    public final Integer aPO() {
        return this.dDU;
    }

    public final void j(Integer num) {
        this.dDU = num;
    }

    public final void U(byte[] bArr) {
        this.dDV = bArr;
    }

    public final byte[] aPP() {
        return this.dDV;
    }

    public final void V(byte[] bArr) {
        this.dDW = bArr;
    }

    public final byte[] aPQ() {
        return this.dDW;
    }

    public final void E(long j) {
        this.aSH = j;
    }

    public final void W(byte[] bArr) {
        this.dDX = bArr;
    }

    public final int aPG() {
        return this.dDP;
    }

    public final void lG(int i) {
        this.dDP = i;
    }

    public final void aPH() {
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.d("BDTLS", "Recovery: add recoveryCount: " + this.dDQ);
        }
        this.dDQ++;
    }

    public final synchronized boolean aPI() {
        boolean z = true;
        synchronized (this) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (this.dDV == null || this.dDW == null || this.aSH <= currentTimeMillis || this.dDP != 1) {
                z = false;
            }
            if (com.baidu.swan.games.bdtls.a.DEBUG) {
                Log.d("BDTLS", "isSessionEnable " + this.dDV + ' ' + this.dDW + ' ' + this.aSH + ' ' + this.dDP);
            }
        }
        return z;
    }

    public final boolean aPJ() {
        return this.dDQ < 3;
    }

    public final void aPK() {
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.d("BDTLS", "Downgrade: reset downgrade count " + this.dDQ);
        }
        this.dDQ = 0;
    }
}
