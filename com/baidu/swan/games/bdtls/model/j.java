package com.baidu.swan.games.bdtls.model;

import android.util.Log;
import java.util.Arrays;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes10.dex */
public final class j {
    private long aTD;
    private int dMm;
    private volatile int dMn;
    private Integer dMo;
    private Integer dMp;
    private Integer dMq;
    private Integer dMr;
    private byte[] dMs;
    private byte[] dMt;
    private byte[] dMu;

    public j() {
        this(null, null, null, null, null, null, 0L, null, 255, null);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof j)) {
                return false;
            }
            j jVar = (j) obj;
            if (!q.l(this.dMo, jVar.dMo) || !q.l(this.dMp, jVar.dMp) || !q.l(this.dMq, jVar.dMq) || !q.l(this.dMr, jVar.dMr) || !q.l(this.dMs, jVar.dMs) || !q.l(this.dMt, jVar.dMt)) {
                return false;
            }
            if (!(this.aTD == jVar.aTD) || !q.l(this.dMu, jVar.dMu)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        Integer num = this.dMo;
        int hashCode = (num != null ? num.hashCode() : 0) * 31;
        Integer num2 = this.dMp;
        int hashCode2 = ((num2 != null ? num2.hashCode() : 0) + hashCode) * 31;
        Integer num3 = this.dMq;
        int hashCode3 = ((num3 != null ? num3.hashCode() : 0) + hashCode2) * 31;
        Integer num4 = this.dMr;
        int hashCode4 = ((num4 != null ? num4.hashCode() : 0) + hashCode3) * 31;
        byte[] bArr = this.dMs;
        int hashCode5 = ((bArr != null ? Arrays.hashCode(bArr) : 0) + hashCode4) * 31;
        byte[] bArr2 = this.dMt;
        int hashCode6 = bArr2 != null ? Arrays.hashCode(bArr2) : 0;
        long j = this.aTD;
        int i = (((hashCode6 + hashCode5) * 31) + ((int) (j ^ (j >>> 32)))) * 31;
        byte[] bArr3 = this.dMu;
        return i + (bArr3 != null ? Arrays.hashCode(bArr3) : 0);
    }

    public String toString() {
        return "SessionParams(dhGroupId=" + this.dMo + ", dhSecretKey=" + this.dMp + ", dhPublicKey=" + this.dMq + ", dhServerPublicKey=" + this.dMr + ", aesSecretKey=" + Arrays.toString(this.dMs) + ", sessionTicket=" + Arrays.toString(this.dMt) + ", expireTime=" + this.aTD + ", entryType=" + Arrays.toString(this.dMu) + ")";
    }

    public j(Integer num, Integer num2, Integer num3, Integer num4, byte[] bArr, byte[] bArr2, long j, byte[] bArr3) {
        this.dMo = num;
        this.dMp = num2;
        this.dMq = num3;
        this.dMr = num4;
        this.dMs = bArr;
        this.dMt = bArr2;
        this.aTD = j;
        this.dMu = bArr3;
    }

    public /* synthetic */ j(Integer num, Integer num2, Integer num3, Integer num4, byte[] bArr, byte[] bArr2, long j, byte[] bArr3, int i, o oVar) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : num3, (i & 8) != 0 ? null : num4, (i & 16) != 0 ? null : bArr, (i & 32) != 0 ? null : bArr2, (i & 64) != 0 ? 0L : j, (i & 128) != 0 ? null : bArr3);
    }

    public final Integer aRF() {
        return this.dMo;
    }

    public final void g(Integer num) {
        this.dMo = num;
    }

    public final Integer aRG() {
        return this.dMp;
    }

    public final void h(Integer num) {
        this.dMp = num;
    }

    public final Integer aRH() {
        return this.dMq;
    }

    public final void i(Integer num) {
        this.dMq = num;
    }

    public final Integer aRI() {
        return this.dMr;
    }

    public final void j(Integer num) {
        this.dMr = num;
    }

    public final void U(byte[] bArr) {
        this.dMs = bArr;
    }

    public final byte[] aRJ() {
        return this.dMs;
    }

    public final void V(byte[] bArr) {
        this.dMt = bArr;
    }

    public final byte[] aRK() {
        return this.dMt;
    }

    public final void E(long j) {
        this.aTD = j;
    }

    public final void W(byte[] bArr) {
        this.dMu = bArr;
    }

    public final int aRA() {
        return this.dMm;
    }

    public final void lR(int i) {
        this.dMm = i;
    }

    public final void aRB() {
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.d("BDTLS", "Recovery: add recoveryCount: " + this.dMn);
        }
        this.dMn++;
    }

    public final synchronized boolean aRC() {
        boolean z = true;
        synchronized (this) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (this.dMs == null || this.dMt == null || this.aTD <= currentTimeMillis || this.dMm != 1) {
                z = false;
            }
            if (com.baidu.swan.games.bdtls.a.DEBUG) {
                Log.d("BDTLS", "isSessionEnable " + this.dMs + ' ' + this.dMt + ' ' + this.aTD + ' ' + this.dMm);
            }
        }
        return z;
    }

    public final boolean aRD() {
        return this.dMn < 3;
    }

    public final void aRE() {
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.d("BDTLS", "Downgrade: reset downgrade count " + this.dMn);
        }
        this.dMn = 0;
    }
}
