package com.baidu.swan.games.bdtls.model;

import android.util.Log;
import java.util.Arrays;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.p;
@kotlin.e
/* loaded from: classes9.dex */
public final class j {
    private long aXV;
    private byte[] egA;
    private int egs;
    private volatile int egt;
    private Integer egu;
    private Integer egv;
    private Integer egw;
    private Integer egx;
    private byte[] egy;
    private byte[] egz;

    public j() {
        this(null, null, null, null, null, null, 0L, null, 255, null);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof j)) {
                return false;
            }
            j jVar = (j) obj;
            if (!p.l(this.egu, jVar.egu) || !p.l(this.egv, jVar.egv) || !p.l(this.egw, jVar.egw) || !p.l(this.egx, jVar.egx) || !p.l(this.egy, jVar.egy) || !p.l(this.egz, jVar.egz)) {
                return false;
            }
            if (!(this.aXV == jVar.aXV) || !p.l(this.egA, jVar.egA)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        Integer num = this.egu;
        int hashCode = (num != null ? num.hashCode() : 0) * 31;
        Integer num2 = this.egv;
        int hashCode2 = ((num2 != null ? num2.hashCode() : 0) + hashCode) * 31;
        Integer num3 = this.egw;
        int hashCode3 = ((num3 != null ? num3.hashCode() : 0) + hashCode2) * 31;
        Integer num4 = this.egx;
        int hashCode4 = ((num4 != null ? num4.hashCode() : 0) + hashCode3) * 31;
        byte[] bArr = this.egy;
        int hashCode5 = ((bArr != null ? Arrays.hashCode(bArr) : 0) + hashCode4) * 31;
        byte[] bArr2 = this.egz;
        int hashCode6 = bArr2 != null ? Arrays.hashCode(bArr2) : 0;
        long j = this.aXV;
        int i = (((hashCode6 + hashCode5) * 31) + ((int) (j ^ (j >>> 32)))) * 31;
        byte[] bArr3 = this.egA;
        return i + (bArr3 != null ? Arrays.hashCode(bArr3) : 0);
    }

    public String toString() {
        return "SessionParams(dhGroupId=" + this.egu + ", dhSecretKey=" + this.egv + ", dhPublicKey=" + this.egw + ", dhServerPublicKey=" + this.egx + ", aesSecretKey=" + Arrays.toString(this.egy) + ", sessionTicket=" + Arrays.toString(this.egz) + ", expireTime=" + this.aXV + ", entryType=" + Arrays.toString(this.egA) + ")";
    }

    public j(Integer num, Integer num2, Integer num3, Integer num4, byte[] bArr, byte[] bArr2, long j, byte[] bArr3) {
        this.egu = num;
        this.egv = num2;
        this.egw = num3;
        this.egx = num4;
        this.egy = bArr;
        this.egz = bArr2;
        this.aXV = j;
        this.egA = bArr3;
    }

    public /* synthetic */ j(Integer num, Integer num2, Integer num3, Integer num4, byte[] bArr, byte[] bArr2, long j, byte[] bArr3, int i, o oVar) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : num3, (i & 8) != 0 ? null : num4, (i & 16) != 0 ? null : bArr, (i & 32) != 0 ? null : bArr2, (i & 64) != 0 ? 0L : j, (i & 128) != 0 ? null : bArr3);
    }

    public final Integer aYW() {
        return this.egu;
    }

    public final void i(Integer num) {
        this.egu = num;
    }

    public final Integer aYX() {
        return this.egv;
    }

    public final void j(Integer num) {
        this.egv = num;
    }

    public final Integer aYY() {
        return this.egw;
    }

    public final void k(Integer num) {
        this.egw = num;
    }

    public final Integer aYZ() {
        return this.egx;
    }

    public final void l(Integer num) {
        this.egx = num;
    }

    public final void T(byte[] bArr) {
        this.egy = bArr;
    }

    public final byte[] aZa() {
        return this.egy;
    }

    public final void U(byte[] bArr) {
        this.egz = bArr;
    }

    public final byte[] aZb() {
        return this.egz;
    }

    public final void C(long j) {
        this.aXV = j;
    }

    public final void V(byte[] bArr) {
        this.egA = bArr;
    }

    public final int aYR() {
        return this.egs;
    }

    public final void mD(int i) {
        this.egs = i;
    }

    public final void aYS() {
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.d("BDTLS", "Recovery: add recoveryCount: " + this.egt);
        }
        this.egt++;
    }

    public final synchronized boolean aYT() {
        boolean z = true;
        synchronized (this) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (this.egy == null || this.egz == null || this.aXV <= currentTimeMillis || this.egs != 1) {
                z = false;
            }
            if (com.baidu.swan.games.bdtls.a.DEBUG) {
                Log.d("BDTLS", "isSessionEnable " + this.egy + ' ' + this.egz + ' ' + this.aXV + ' ' + this.egs);
            }
        }
        return z;
    }

    public final boolean aYU() {
        return this.egt < 3;
    }

    public final void aYV() {
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.d("BDTLS", "Downgrade: reset downgrade count " + this.egt);
        }
        this.egt = 0;
    }
}
