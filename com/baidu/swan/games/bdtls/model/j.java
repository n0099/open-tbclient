package com.baidu.swan.games.bdtls.model;

import android.util.Log;
import java.util.Arrays;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
/* loaded from: classes10.dex */
public final class j {
    private long aeo;
    private int chb;
    private volatile int chc;
    private Integer chd;
    private Integer che;
    private Integer chf;
    private Integer chg;
    private byte[] chh;
    private byte[] chi;
    private byte[] chj;

    public j() {
        this(null, null, null, null, null, null, 0L, null, 255, null);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof j)) {
                return false;
            }
            j jVar = (j) obj;
            if (!q.h(this.chd, jVar.chd) || !q.h(this.che, jVar.che) || !q.h(this.chf, jVar.chf) || !q.h(this.chg, jVar.chg) || !q.h(this.chh, jVar.chh) || !q.h(this.chi, jVar.chi)) {
                return false;
            }
            if (!(this.aeo == jVar.aeo) || !q.h(this.chj, jVar.chj)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        Integer num = this.chd;
        int hashCode = (num != null ? num.hashCode() : 0) * 31;
        Integer num2 = this.che;
        int hashCode2 = ((num2 != null ? num2.hashCode() : 0) + hashCode) * 31;
        Integer num3 = this.chf;
        int hashCode3 = ((num3 != null ? num3.hashCode() : 0) + hashCode2) * 31;
        Integer num4 = this.chg;
        int hashCode4 = ((num4 != null ? num4.hashCode() : 0) + hashCode3) * 31;
        byte[] bArr = this.chh;
        int hashCode5 = ((bArr != null ? Arrays.hashCode(bArr) : 0) + hashCode4) * 31;
        byte[] bArr2 = this.chi;
        int hashCode6 = bArr2 != null ? Arrays.hashCode(bArr2) : 0;
        long j = this.aeo;
        int i = (((hashCode6 + hashCode5) * 31) + ((int) (j ^ (j >>> 32)))) * 31;
        byte[] bArr3 = this.chj;
        return i + (bArr3 != null ? Arrays.hashCode(bArr3) : 0);
    }

    public String toString() {
        return "SessionParams(dhGroupId=" + this.chd + ", dhSecretKey=" + this.che + ", dhPublicKey=" + this.chf + ", dhServerPublicKey=" + this.chg + ", aesSecretKey=" + Arrays.toString(this.chh) + ", sessionTicket=" + Arrays.toString(this.chi) + ", expireTime=" + this.aeo + ", entryType=" + Arrays.toString(this.chj) + ")";
    }

    public j(Integer num, Integer num2, Integer num3, Integer num4, byte[] bArr, byte[] bArr2, long j, byte[] bArr3) {
        this.chd = num;
        this.che = num2;
        this.chf = num3;
        this.chg = num4;
        this.chh = bArr;
        this.chi = bArr2;
        this.aeo = j;
        this.chj = bArr3;
    }

    public /* synthetic */ j(Integer num, Integer num2, Integer num3, Integer num4, byte[] bArr, byte[] bArr2, long j, byte[] bArr3, int i, o oVar) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : num3, (i & 8) != 0 ? null : num4, (i & 16) != 0 ? null : bArr, (i & 32) != 0 ? null : bArr2, (i & 64) != 0 ? 0L : j, (i & 128) != 0 ? null : bArr3);
    }

    public final Integer akx() {
        return this.chd;
    }

    public final void c(Integer num) {
        this.chd = num;
    }

    public final Integer aky() {
        return this.che;
    }

    public final void d(Integer num) {
        this.che = num;
    }

    public final Integer akz() {
        return this.chf;
    }

    public final void e(Integer num) {
        this.chf = num;
    }

    public final Integer akA() {
        return this.chg;
    }

    public final void f(Integer num) {
        this.chg = num;
    }

    public final void D(byte[] bArr) {
        this.chh = bArr;
    }

    public final byte[] akB() {
        return this.chh;
    }

    public final void E(byte[] bArr) {
        this.chi = bArr;
    }

    public final byte[] akC() {
        return this.chi;
    }

    public final void g(long j) {
        this.aeo = j;
    }

    public final void F(byte[] bArr) {
        this.chj = bArr;
    }

    public final int akt() {
        return this.chb;
    }

    public final void hw(int i) {
        this.chb = i;
    }

    public final void aku() {
        this.chc++;
    }

    public final synchronized boolean akv() {
        boolean z = true;
        synchronized (this) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (this.chh == null || this.chi == null || this.aeo <= currentTimeMillis || this.chb != 1) {
                z = false;
            }
            if (com.baidu.swan.games.bdtls.a.DEBUG) {
                Log.d("BDTLS", "isSessionEnable " + this.chh + ' ' + this.chi + ' ' + this.aeo + ' ' + this.chb);
            }
        }
        return z;
    }

    public final boolean akw() {
        return this.chc < 3;
    }
}
