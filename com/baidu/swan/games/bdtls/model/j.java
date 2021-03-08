package com.baidu.swan.games.bdtls.model;

import android.util.Log;
import java.util.Arrays;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.p;
@kotlin.e
/* loaded from: classes8.dex */
public final class j {
    private long aXN;
    private int efn;
    private volatile int efo;
    private Integer efp;
    private Integer efq;
    private Integer efr;
    private Integer efs;
    private byte[] eft;
    private byte[] efu;
    private byte[] efv;

    public j() {
        this(null, null, null, null, null, null, 0L, null, 255, null);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof j)) {
                return false;
            }
            j jVar = (j) obj;
            if (!p.l(this.efp, jVar.efp) || !p.l(this.efq, jVar.efq) || !p.l(this.efr, jVar.efr) || !p.l(this.efs, jVar.efs) || !p.l(this.eft, jVar.eft) || !p.l(this.efu, jVar.efu)) {
                return false;
            }
            if (!(this.aXN == jVar.aXN) || !p.l(this.efv, jVar.efv)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        Integer num = this.efp;
        int hashCode = (num != null ? num.hashCode() : 0) * 31;
        Integer num2 = this.efq;
        int hashCode2 = ((num2 != null ? num2.hashCode() : 0) + hashCode) * 31;
        Integer num3 = this.efr;
        int hashCode3 = ((num3 != null ? num3.hashCode() : 0) + hashCode2) * 31;
        Integer num4 = this.efs;
        int hashCode4 = ((num4 != null ? num4.hashCode() : 0) + hashCode3) * 31;
        byte[] bArr = this.eft;
        int hashCode5 = ((bArr != null ? Arrays.hashCode(bArr) : 0) + hashCode4) * 31;
        byte[] bArr2 = this.efu;
        int hashCode6 = bArr2 != null ? Arrays.hashCode(bArr2) : 0;
        long j = this.aXN;
        int i = (((hashCode6 + hashCode5) * 31) + ((int) (j ^ (j >>> 32)))) * 31;
        byte[] bArr3 = this.efv;
        return i + (bArr3 != null ? Arrays.hashCode(bArr3) : 0);
    }

    public String toString() {
        return "SessionParams(dhGroupId=" + this.efp + ", dhSecretKey=" + this.efq + ", dhPublicKey=" + this.efr + ", dhServerPublicKey=" + this.efs + ", aesSecretKey=" + Arrays.toString(this.eft) + ", sessionTicket=" + Arrays.toString(this.efu) + ", expireTime=" + this.aXN + ", entryType=" + Arrays.toString(this.efv) + ")";
    }

    public j(Integer num, Integer num2, Integer num3, Integer num4, byte[] bArr, byte[] bArr2, long j, byte[] bArr3) {
        this.efp = num;
        this.efq = num2;
        this.efr = num3;
        this.efs = num4;
        this.eft = bArr;
        this.efu = bArr2;
        this.aXN = j;
        this.efv = bArr3;
    }

    public /* synthetic */ j(Integer num, Integer num2, Integer num3, Integer num4, byte[] bArr, byte[] bArr2, long j, byte[] bArr3, int i, o oVar) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : num3, (i & 8) != 0 ? null : num4, (i & 16) != 0 ? null : bArr, (i & 32) != 0 ? null : bArr2, (i & 64) != 0 ? 0L : j, (i & 128) != 0 ? null : bArr3);
    }

    public final Integer aVs() {
        return this.efp;
    }

    public final void i(Integer num) {
        this.efp = num;
    }

    public final Integer aVt() {
        return this.efq;
    }

    public final void j(Integer num) {
        this.efq = num;
    }

    public final Integer aVu() {
        return this.efr;
    }

    public final void k(Integer num) {
        this.efr = num;
    }

    public final Integer aVv() {
        return this.efs;
    }

    public final void l(Integer num) {
        this.efs = num;
    }

    public final void T(byte[] bArr) {
        this.eft = bArr;
    }

    public final byte[] aVw() {
        return this.eft;
    }

    public final void U(byte[] bArr) {
        this.efu = bArr;
    }

    public final byte[] aVx() {
        return this.efu;
    }

    public final void C(long j) {
        this.aXN = j;
    }

    public final void V(byte[] bArr) {
        this.efv = bArr;
    }

    public final int aVn() {
        return this.efn;
    }

    public final void lb(int i) {
        this.efn = i;
    }

    public final void aVo() {
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.d("BDTLS", "Recovery: add recoveryCount: " + this.efo);
        }
        this.efo++;
    }

    public final synchronized boolean aVp() {
        boolean z = true;
        synchronized (this) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (this.eft == null || this.efu == null || this.aXN <= currentTimeMillis || this.efn != 1) {
                z = false;
            }
            if (com.baidu.swan.games.bdtls.a.DEBUG) {
                Log.d("BDTLS", "isSessionEnable " + this.eft + ' ' + this.efu + ' ' + this.aXN + ' ' + this.efn);
            }
        }
        return z;
    }

    public final boolean aVq() {
        return this.efo < 3;
    }

    public final void aVr() {
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.d("BDTLS", "Downgrade: reset downgrade count " + this.efo);
        }
        this.efo = 0;
    }
}
