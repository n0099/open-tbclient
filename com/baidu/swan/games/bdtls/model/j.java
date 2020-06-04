package com.baidu.swan.games.bdtls.model;

import android.util.Log;
import java.util.Arrays;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes11.dex */
public final class j {
    private long aEt;
    private int cVc;
    private volatile int cVd;
    private Integer cVe;
    private Integer cVf;
    private Integer cVg;
    private Integer cVh;
    private byte[] cVi;
    private byte[] cVj;
    private byte[] cVk;

    public j() {
        this(null, null, null, null, null, null, 0L, null, 255, null);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof j)) {
                return false;
            }
            j jVar = (j) obj;
            if (!q.l(this.cVe, jVar.cVe) || !q.l(this.cVf, jVar.cVf) || !q.l(this.cVg, jVar.cVg) || !q.l(this.cVh, jVar.cVh) || !q.l(this.cVi, jVar.cVi) || !q.l(this.cVj, jVar.cVj)) {
                return false;
            }
            if (!(this.aEt == jVar.aEt) || !q.l(this.cVk, jVar.cVk)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        Integer num = this.cVe;
        int hashCode = (num != null ? num.hashCode() : 0) * 31;
        Integer num2 = this.cVf;
        int hashCode2 = ((num2 != null ? num2.hashCode() : 0) + hashCode) * 31;
        Integer num3 = this.cVg;
        int hashCode3 = ((num3 != null ? num3.hashCode() : 0) + hashCode2) * 31;
        Integer num4 = this.cVh;
        int hashCode4 = ((num4 != null ? num4.hashCode() : 0) + hashCode3) * 31;
        byte[] bArr = this.cVi;
        int hashCode5 = ((bArr != null ? Arrays.hashCode(bArr) : 0) + hashCode4) * 31;
        byte[] bArr2 = this.cVj;
        int hashCode6 = bArr2 != null ? Arrays.hashCode(bArr2) : 0;
        long j = this.aEt;
        int i = (((hashCode6 + hashCode5) * 31) + ((int) (j ^ (j >>> 32)))) * 31;
        byte[] bArr3 = this.cVk;
        return i + (bArr3 != null ? Arrays.hashCode(bArr3) : 0);
    }

    public String toString() {
        return "SessionParams(dhGroupId=" + this.cVe + ", dhSecretKey=" + this.cVf + ", dhPublicKey=" + this.cVg + ", dhServerPublicKey=" + this.cVh + ", aesSecretKey=" + Arrays.toString(this.cVi) + ", sessionTicket=" + Arrays.toString(this.cVj) + ", expireTime=" + this.aEt + ", entryType=" + Arrays.toString(this.cVk) + ")";
    }

    public j(Integer num, Integer num2, Integer num3, Integer num4, byte[] bArr, byte[] bArr2, long j, byte[] bArr3) {
        this.cVe = num;
        this.cVf = num2;
        this.cVg = num3;
        this.cVh = num4;
        this.cVi = bArr;
        this.cVj = bArr2;
        this.aEt = j;
        this.cVk = bArr3;
    }

    public /* synthetic */ j(Integer num, Integer num2, Integer num3, Integer num4, byte[] bArr, byte[] bArr2, long j, byte[] bArr3, int i, o oVar) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : num3, (i & 8) != 0 ? null : num4, (i & 16) != 0 ? null : bArr, (i & 32) != 0 ? null : bArr2, (i & 64) != 0 ? 0L : j, (i & 128) != 0 ? null : bArr3);
    }

    public final Integer ayR() {
        return this.cVe;
    }

    public final void d(Integer num) {
        this.cVe = num;
    }

    public final Integer ayS() {
        return this.cVf;
    }

    public final void e(Integer num) {
        this.cVf = num;
    }

    public final Integer ayT() {
        return this.cVg;
    }

    public final void f(Integer num) {
        this.cVg = num;
    }

    public final Integer ayU() {
        return this.cVh;
    }

    public final void g(Integer num) {
        this.cVh = num;
    }

    public final void R(byte[] bArr) {
        this.cVi = bArr;
    }

    public final byte[] ayV() {
        return this.cVi;
    }

    public final void S(byte[] bArr) {
        this.cVj = bArr;
    }

    public final byte[] ayW() {
        return this.cVj;
    }

    public final void E(long j) {
        this.aEt = j;
    }

    public final void T(byte[] bArr) {
        this.cVk = bArr;
    }

    public final int ayM() {
        return this.cVc;
    }

    public final void in(int i) {
        this.cVc = i;
    }

    public final void ayN() {
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.d("BDTLS", "Recovery: add recoveryCount: " + this.cVd);
        }
        this.cVd++;
    }

    public final synchronized boolean ayO() {
        boolean z = true;
        synchronized (this) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (this.cVi == null || this.cVj == null || this.aEt <= currentTimeMillis || this.cVc != 1) {
                z = false;
            }
            if (com.baidu.swan.games.bdtls.a.DEBUG) {
                Log.d("BDTLS", "isSessionEnable " + this.cVi + ' ' + this.cVj + ' ' + this.aEt + ' ' + this.cVc);
            }
        }
        return z;
    }

    public final boolean ayP() {
        return this.cVd < 3;
    }

    public final void ayQ() {
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.d("BDTLS", "Downgrade: reset downgrade count " + this.cVd);
        }
        this.cVd = 0;
    }
}
