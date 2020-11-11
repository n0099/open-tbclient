package com.baidu.swan.games.bdtls.model;

import android.util.Log;
import java.util.Arrays;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes10.dex */
public final class j {
    private long aUW;
    private int dSe;
    private volatile int dSf;
    private Integer dSg;
    private Integer dSh;
    private Integer dSi;
    private Integer dSj;
    private byte[] dSk;
    private byte[] dSl;
    private byte[] dSm;

    public j() {
        this(null, null, null, null, null, null, 0L, null, 255, null);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof j)) {
                return false;
            }
            j jVar = (j) obj;
            if (!q.l(this.dSg, jVar.dSg) || !q.l(this.dSh, jVar.dSh) || !q.l(this.dSi, jVar.dSi) || !q.l(this.dSj, jVar.dSj) || !q.l(this.dSk, jVar.dSk) || !q.l(this.dSl, jVar.dSl)) {
                return false;
            }
            if (!(this.aUW == jVar.aUW) || !q.l(this.dSm, jVar.dSm)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        Integer num = this.dSg;
        int hashCode = (num != null ? num.hashCode() : 0) * 31;
        Integer num2 = this.dSh;
        int hashCode2 = ((num2 != null ? num2.hashCode() : 0) + hashCode) * 31;
        Integer num3 = this.dSi;
        int hashCode3 = ((num3 != null ? num3.hashCode() : 0) + hashCode2) * 31;
        Integer num4 = this.dSj;
        int hashCode4 = ((num4 != null ? num4.hashCode() : 0) + hashCode3) * 31;
        byte[] bArr = this.dSk;
        int hashCode5 = ((bArr != null ? Arrays.hashCode(bArr) : 0) + hashCode4) * 31;
        byte[] bArr2 = this.dSl;
        int hashCode6 = bArr2 != null ? Arrays.hashCode(bArr2) : 0;
        long j = this.aUW;
        int i = (((hashCode6 + hashCode5) * 31) + ((int) (j ^ (j >>> 32)))) * 31;
        byte[] bArr3 = this.dSm;
        return i + (bArr3 != null ? Arrays.hashCode(bArr3) : 0);
    }

    public String toString() {
        return "SessionParams(dhGroupId=" + this.dSg + ", dhSecretKey=" + this.dSh + ", dhPublicKey=" + this.dSi + ", dhServerPublicKey=" + this.dSj + ", aesSecretKey=" + Arrays.toString(this.dSk) + ", sessionTicket=" + Arrays.toString(this.dSl) + ", expireTime=" + this.aUW + ", entryType=" + Arrays.toString(this.dSm) + ")";
    }

    public j(Integer num, Integer num2, Integer num3, Integer num4, byte[] bArr, byte[] bArr2, long j, byte[] bArr3) {
        this.dSg = num;
        this.dSh = num2;
        this.dSi = num3;
        this.dSj = num4;
        this.dSk = bArr;
        this.dSl = bArr2;
        this.aUW = j;
        this.dSm = bArr3;
    }

    public /* synthetic */ j(Integer num, Integer num2, Integer num3, Integer num4, byte[] bArr, byte[] bArr2, long j, byte[] bArr3, int i, o oVar) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : num3, (i & 8) != 0 ? null : num4, (i & 16) != 0 ? null : bArr, (i & 32) != 0 ? null : bArr2, (i & 64) != 0 ? 0L : j, (i & 128) != 0 ? null : bArr3);
    }

    public final Integer aUf() {
        return this.dSg;
    }

    public final void g(Integer num) {
        this.dSg = num;
    }

    public final Integer aUg() {
        return this.dSh;
    }

    public final void h(Integer num) {
        this.dSh = num;
    }

    public final Integer aUh() {
        return this.dSi;
    }

    public final void i(Integer num) {
        this.dSi = num;
    }

    public final Integer aUi() {
        return this.dSj;
    }

    public final void j(Integer num) {
        this.dSj = num;
    }

    public final void U(byte[] bArr) {
        this.dSk = bArr;
    }

    public final byte[] aUj() {
        return this.dSk;
    }

    public final void V(byte[] bArr) {
        this.dSl = bArr;
    }

    public final byte[] aUk() {
        return this.dSl;
    }

    public final void E(long j) {
        this.aUW = j;
    }

    public final void W(byte[] bArr) {
        this.dSm = bArr;
    }

    public final int aUa() {
        return this.dSe;
    }

    public final void mb(int i) {
        this.dSe = i;
    }

    public final void aUb() {
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.d("BDTLS", "Recovery: add recoveryCount: " + this.dSf);
        }
        this.dSf++;
    }

    public final synchronized boolean aUc() {
        boolean z = true;
        synchronized (this) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (this.dSk == null || this.dSl == null || this.aUW <= currentTimeMillis || this.dSe != 1) {
                z = false;
            }
            if (com.baidu.swan.games.bdtls.a.DEBUG) {
                Log.d("BDTLS", "isSessionEnable " + this.dSk + ' ' + this.dSl + ' ' + this.aUW + ' ' + this.dSe);
            }
        }
        return z;
    }

    public final boolean aUd() {
        return this.dSf < 3;
    }

    public final void aUe() {
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.d("BDTLS", "Downgrade: reset downgrade count " + this.dSf);
        }
        this.dSf = 0;
    }
}
