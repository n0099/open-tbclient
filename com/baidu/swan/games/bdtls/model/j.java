package com.baidu.swan.games.bdtls.model;

import android.util.Log;
import java.util.Arrays;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.p;
@kotlin.e
/* loaded from: classes25.dex */
public final class j {
    private long aWp;
    private byte[] dXA;
    private byte[] dXB;
    private byte[] dXC;
    private int dXu;
    private volatile int dXv;
    private Integer dXw;
    private Integer dXx;
    private Integer dXy;
    private Integer dXz;

    public j() {
        this(null, null, null, null, null, null, 0L, null, 255, null);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof j)) {
                return false;
            }
            j jVar = (j) obj;
            if (!p.l(this.dXw, jVar.dXw) || !p.l(this.dXx, jVar.dXx) || !p.l(this.dXy, jVar.dXy) || !p.l(this.dXz, jVar.dXz) || !p.l(this.dXA, jVar.dXA) || !p.l(this.dXB, jVar.dXB)) {
                return false;
            }
            if (!(this.aWp == jVar.aWp) || !p.l(this.dXC, jVar.dXC)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        Integer num = this.dXw;
        int hashCode = (num != null ? num.hashCode() : 0) * 31;
        Integer num2 = this.dXx;
        int hashCode2 = ((num2 != null ? num2.hashCode() : 0) + hashCode) * 31;
        Integer num3 = this.dXy;
        int hashCode3 = ((num3 != null ? num3.hashCode() : 0) + hashCode2) * 31;
        Integer num4 = this.dXz;
        int hashCode4 = ((num4 != null ? num4.hashCode() : 0) + hashCode3) * 31;
        byte[] bArr = this.dXA;
        int hashCode5 = ((bArr != null ? Arrays.hashCode(bArr) : 0) + hashCode4) * 31;
        byte[] bArr2 = this.dXB;
        int hashCode6 = bArr2 != null ? Arrays.hashCode(bArr2) : 0;
        long j = this.aWp;
        int i = (((hashCode6 + hashCode5) * 31) + ((int) (j ^ (j >>> 32)))) * 31;
        byte[] bArr3 = this.dXC;
        return i + (bArr3 != null ? Arrays.hashCode(bArr3) : 0);
    }

    public String toString() {
        return "SessionParams(dhGroupId=" + this.dXw + ", dhSecretKey=" + this.dXx + ", dhPublicKey=" + this.dXy + ", dhServerPublicKey=" + this.dXz + ", aesSecretKey=" + Arrays.toString(this.dXA) + ", sessionTicket=" + Arrays.toString(this.dXB) + ", expireTime=" + this.aWp + ", entryType=" + Arrays.toString(this.dXC) + ")";
    }

    public j(Integer num, Integer num2, Integer num3, Integer num4, byte[] bArr, byte[] bArr2, long j, byte[] bArr3) {
        this.dXw = num;
        this.dXx = num2;
        this.dXy = num3;
        this.dXz = num4;
        this.dXA = bArr;
        this.dXB = bArr2;
        this.aWp = j;
        this.dXC = bArr3;
    }

    public /* synthetic */ j(Integer num, Integer num2, Integer num3, Integer num4, byte[] bArr, byte[] bArr2, long j, byte[] bArr3, int i, o oVar) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : num3, (i & 8) != 0 ? null : num4, (i & 16) != 0 ? null : bArr, (i & 32) != 0 ? null : bArr2, (i & 64) != 0 ? 0L : j, (i & 128) != 0 ? null : bArr3);
    }

    public final Integer aWC() {
        return this.dXw;
    }

    public final void g(Integer num) {
        this.dXw = num;
    }

    public final Integer aWD() {
        return this.dXx;
    }

    public final void h(Integer num) {
        this.dXx = num;
    }

    public final Integer aWE() {
        return this.dXy;
    }

    public final void i(Integer num) {
        this.dXy = num;
    }

    public final Integer aWF() {
        return this.dXz;
    }

    public final void j(Integer num) {
        this.dXz = num;
    }

    public final void W(byte[] bArr) {
        this.dXA = bArr;
    }

    public final byte[] aWG() {
        return this.dXA;
    }

    public final void X(byte[] bArr) {
        this.dXB = bArr;
    }

    public final byte[] aWH() {
        return this.dXB;
    }

    public final void C(long j) {
        this.aWp = j;
    }

    public final void Y(byte[] bArr) {
        this.dXC = bArr;
    }

    public final int aWx() {
        return this.dXu;
    }

    public final void mv(int i) {
        this.dXu = i;
    }

    public final void aWy() {
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.d("BDTLS", "Recovery: add recoveryCount: " + this.dXv);
        }
        this.dXv++;
    }

    public final synchronized boolean aWz() {
        boolean z = true;
        synchronized (this) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (this.dXA == null || this.dXB == null || this.aWp <= currentTimeMillis || this.dXu != 1) {
                z = false;
            }
            if (com.baidu.swan.games.bdtls.a.DEBUG) {
                Log.d("BDTLS", "isSessionEnable " + this.dXA + ' ' + this.dXB + ' ' + this.aWp + ' ' + this.dXu);
            }
        }
        return z;
    }

    public final boolean aWA() {
        return this.dXv < 3;
    }

    public final void aWB() {
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.d("BDTLS", "Downgrade: reset downgrade count " + this.dXv);
        }
        this.dXv = 0;
    }
}
