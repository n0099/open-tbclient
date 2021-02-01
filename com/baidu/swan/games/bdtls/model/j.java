package com.baidu.swan.games.bdtls.model;

import android.util.Log;
import java.util.Arrays;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.p;
@kotlin.e
/* loaded from: classes9.dex */
public final class j {
    private long aWn;
    private int edM;
    private volatile int edN;
    private Integer edO;
    private Integer edP;
    private Integer edQ;
    private Integer edR;
    private byte[] edS;
    private byte[] edT;
    private byte[] edU;

    public j() {
        this(null, null, null, null, null, null, 0L, null, 255, null);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof j)) {
                return false;
            }
            j jVar = (j) obj;
            if (!p.l(this.edO, jVar.edO) || !p.l(this.edP, jVar.edP) || !p.l(this.edQ, jVar.edQ) || !p.l(this.edR, jVar.edR) || !p.l(this.edS, jVar.edS) || !p.l(this.edT, jVar.edT)) {
                return false;
            }
            if (!(this.aWn == jVar.aWn) || !p.l(this.edU, jVar.edU)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        Integer num = this.edO;
        int hashCode = (num != null ? num.hashCode() : 0) * 31;
        Integer num2 = this.edP;
        int hashCode2 = ((num2 != null ? num2.hashCode() : 0) + hashCode) * 31;
        Integer num3 = this.edQ;
        int hashCode3 = ((num3 != null ? num3.hashCode() : 0) + hashCode2) * 31;
        Integer num4 = this.edR;
        int hashCode4 = ((num4 != null ? num4.hashCode() : 0) + hashCode3) * 31;
        byte[] bArr = this.edS;
        int hashCode5 = ((bArr != null ? Arrays.hashCode(bArr) : 0) + hashCode4) * 31;
        byte[] bArr2 = this.edT;
        int hashCode6 = bArr2 != null ? Arrays.hashCode(bArr2) : 0;
        long j = this.aWn;
        int i = (((hashCode6 + hashCode5) * 31) + ((int) (j ^ (j >>> 32)))) * 31;
        byte[] bArr3 = this.edU;
        return i + (bArr3 != null ? Arrays.hashCode(bArr3) : 0);
    }

    public String toString() {
        return "SessionParams(dhGroupId=" + this.edO + ", dhSecretKey=" + this.edP + ", dhPublicKey=" + this.edQ + ", dhServerPublicKey=" + this.edR + ", aesSecretKey=" + Arrays.toString(this.edS) + ", sessionTicket=" + Arrays.toString(this.edT) + ", expireTime=" + this.aWn + ", entryType=" + Arrays.toString(this.edU) + ")";
    }

    public j(Integer num, Integer num2, Integer num3, Integer num4, byte[] bArr, byte[] bArr2, long j, byte[] bArr3) {
        this.edO = num;
        this.edP = num2;
        this.edQ = num3;
        this.edR = num4;
        this.edS = bArr;
        this.edT = bArr2;
        this.aWn = j;
        this.edU = bArr3;
    }

    public /* synthetic */ j(Integer num, Integer num2, Integer num3, Integer num4, byte[] bArr, byte[] bArr2, long j, byte[] bArr3, int i, o oVar) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : num3, (i & 8) != 0 ? null : num4, (i & 16) != 0 ? null : bArr, (i & 32) != 0 ? null : bArr2, (i & 64) != 0 ? 0L : j, (i & 128) != 0 ? null : bArr3);
    }

    public final Integer aVp() {
        return this.edO;
    }

    public final void i(Integer num) {
        this.edO = num;
    }

    public final Integer aVq() {
        return this.edP;
    }

    public final void j(Integer num) {
        this.edP = num;
    }

    public final Integer aVr() {
        return this.edQ;
    }

    public final void k(Integer num) {
        this.edQ = num;
    }

    public final Integer aVs() {
        return this.edR;
    }

    public final void l(Integer num) {
        this.edR = num;
    }

    public final void R(byte[] bArr) {
        this.edS = bArr;
    }

    public final byte[] aVt() {
        return this.edS;
    }

    public final void S(byte[] bArr) {
        this.edT = bArr;
    }

    public final byte[] aVu() {
        return this.edT;
    }

    public final void C(long j) {
        this.aWn = j;
    }

    public final void T(byte[] bArr) {
        this.edU = bArr;
    }

    public final int aVk() {
        return this.edM;
    }

    public final void la(int i) {
        this.edM = i;
    }

    public final void aVl() {
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.d("BDTLS", "Recovery: add recoveryCount: " + this.edN);
        }
        this.edN++;
    }

    public final synchronized boolean aVm() {
        boolean z = true;
        synchronized (this) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (this.edS == null || this.edT == null || this.aWn <= currentTimeMillis || this.edM != 1) {
                z = false;
            }
            if (com.baidu.swan.games.bdtls.a.DEBUG) {
                Log.d("BDTLS", "isSessionEnable " + this.edS + ' ' + this.edT + ' ' + this.aWn + ' ' + this.edM);
            }
        }
        return z;
    }

    public final boolean aVn() {
        return this.edN < 3;
    }

    public final void aVo() {
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.d("BDTLS", "Downgrade: reset downgrade count " + this.edN);
        }
        this.edN = 0;
    }
}
