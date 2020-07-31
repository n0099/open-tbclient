package com.baidu.swan.games.bdtls.model;

import android.util.Log;
import java.util.Arrays;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes7.dex */
public final class j {
    private long aIk;
    private Integer dfA;
    private Integer dfB;
    private Integer dfC;
    private byte[] dfD;
    private byte[] dfE;
    private byte[] dfF;
    private int dfx;
    private volatile int dfy;
    private Integer dfz;

    public j() {
        this(null, null, null, null, null, null, 0L, null, 255, null);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof j)) {
                return false;
            }
            j jVar = (j) obj;
            if (!q.l(this.dfz, jVar.dfz) || !q.l(this.dfA, jVar.dfA) || !q.l(this.dfB, jVar.dfB) || !q.l(this.dfC, jVar.dfC) || !q.l(this.dfD, jVar.dfD) || !q.l(this.dfE, jVar.dfE)) {
                return false;
            }
            if (!(this.aIk == jVar.aIk) || !q.l(this.dfF, jVar.dfF)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        Integer num = this.dfz;
        int hashCode = (num != null ? num.hashCode() : 0) * 31;
        Integer num2 = this.dfA;
        int hashCode2 = ((num2 != null ? num2.hashCode() : 0) + hashCode) * 31;
        Integer num3 = this.dfB;
        int hashCode3 = ((num3 != null ? num3.hashCode() : 0) + hashCode2) * 31;
        Integer num4 = this.dfC;
        int hashCode4 = ((num4 != null ? num4.hashCode() : 0) + hashCode3) * 31;
        byte[] bArr = this.dfD;
        int hashCode5 = ((bArr != null ? Arrays.hashCode(bArr) : 0) + hashCode4) * 31;
        byte[] bArr2 = this.dfE;
        int hashCode6 = bArr2 != null ? Arrays.hashCode(bArr2) : 0;
        long j = this.aIk;
        int i = (((hashCode6 + hashCode5) * 31) + ((int) (j ^ (j >>> 32)))) * 31;
        byte[] bArr3 = this.dfF;
        return i + (bArr3 != null ? Arrays.hashCode(bArr3) : 0);
    }

    public String toString() {
        return "SessionParams(dhGroupId=" + this.dfz + ", dhSecretKey=" + this.dfA + ", dhPublicKey=" + this.dfB + ", dhServerPublicKey=" + this.dfC + ", aesSecretKey=" + Arrays.toString(this.dfD) + ", sessionTicket=" + Arrays.toString(this.dfE) + ", expireTime=" + this.aIk + ", entryType=" + Arrays.toString(this.dfF) + ")";
    }

    public j(Integer num, Integer num2, Integer num3, Integer num4, byte[] bArr, byte[] bArr2, long j, byte[] bArr3) {
        this.dfz = num;
        this.dfA = num2;
        this.dfB = num3;
        this.dfC = num4;
        this.dfD = bArr;
        this.dfE = bArr2;
        this.aIk = j;
        this.dfF = bArr3;
    }

    public /* synthetic */ j(Integer num, Integer num2, Integer num3, Integer num4, byte[] bArr, byte[] bArr2, long j, byte[] bArr3, int i, o oVar) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : num3, (i & 8) != 0 ? null : num4, (i & 16) != 0 ? null : bArr, (i & 32) != 0 ? null : bArr2, (i & 64) != 0 ? 0L : j, (i & 128) != 0 ? null : bArr3);
    }

    public final Integer aDC() {
        return this.dfz;
    }

    public final void d(Integer num) {
        this.dfz = num;
    }

    public final Integer aDD() {
        return this.dfA;
    }

    public final void e(Integer num) {
        this.dfA = num;
    }

    public final Integer aDE() {
        return this.dfB;
    }

    public final void f(Integer num) {
        this.dfB = num;
    }

    public final Integer aDF() {
        return this.dfC;
    }

    public final void g(Integer num) {
        this.dfC = num;
    }

    public final void T(byte[] bArr) {
        this.dfD = bArr;
    }

    public final byte[] aDG() {
        return this.dfD;
    }

    public final void U(byte[] bArr) {
        this.dfE = bArr;
    }

    public final byte[] aDH() {
        return this.dfE;
    }

    public final void E(long j) {
        this.aIk = j;
    }

    public final void V(byte[] bArr) {
        this.dfF = bArr;
    }

    public final int aDx() {
        return this.dfx;
    }

    public final void iP(int i) {
        this.dfx = i;
    }

    public final void aDy() {
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.d("BDTLS", "Recovery: add recoveryCount: " + this.dfy);
        }
        this.dfy++;
    }

    public final synchronized boolean aDz() {
        boolean z = true;
        synchronized (this) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (this.dfD == null || this.dfE == null || this.aIk <= currentTimeMillis || this.dfx != 1) {
                z = false;
            }
            if (com.baidu.swan.games.bdtls.a.DEBUG) {
                Log.d("BDTLS", "isSessionEnable " + this.dfD + ' ' + this.dfE + ' ' + this.aIk + ' ' + this.dfx);
            }
        }
        return z;
    }

    public final boolean aDA() {
        return this.dfy < 3;
    }

    public final void aDB() {
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.d("BDTLS", "Downgrade: reset downgrade count " + this.dfy);
        }
        this.dfy = 0;
    }
}
