package com.baidu.swan.games.bdtls.model;

import android.util.Log;
import java.util.Arrays;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes11.dex */
public final class j {
    private long agv;
    private int clh;
    private volatile int cli;
    private Integer clj;
    private Integer clk;
    private Integer cll;
    private Integer clm;
    private byte[] cln;
    private byte[] clo;
    private byte[] clp;

    public j() {
        this(null, null, null, null, null, null, 0L, null, 255, null);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof j)) {
                return false;
            }
            j jVar = (j) obj;
            if (!q.h(this.clj, jVar.clj) || !q.h(this.clk, jVar.clk) || !q.h(this.cll, jVar.cll) || !q.h(this.clm, jVar.clm) || !q.h(this.cln, jVar.cln) || !q.h(this.clo, jVar.clo)) {
                return false;
            }
            if (!(this.agv == jVar.agv) || !q.h(this.clp, jVar.clp)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        Integer num = this.clj;
        int hashCode = (num != null ? num.hashCode() : 0) * 31;
        Integer num2 = this.clk;
        int hashCode2 = ((num2 != null ? num2.hashCode() : 0) + hashCode) * 31;
        Integer num3 = this.cll;
        int hashCode3 = ((num3 != null ? num3.hashCode() : 0) + hashCode2) * 31;
        Integer num4 = this.clm;
        int hashCode4 = ((num4 != null ? num4.hashCode() : 0) + hashCode3) * 31;
        byte[] bArr = this.cln;
        int hashCode5 = ((bArr != null ? Arrays.hashCode(bArr) : 0) + hashCode4) * 31;
        byte[] bArr2 = this.clo;
        int hashCode6 = bArr2 != null ? Arrays.hashCode(bArr2) : 0;
        long j = this.agv;
        int i = (((hashCode6 + hashCode5) * 31) + ((int) (j ^ (j >>> 32)))) * 31;
        byte[] bArr3 = this.clp;
        return i + (bArr3 != null ? Arrays.hashCode(bArr3) : 0);
    }

    public String toString() {
        return "SessionParams(dhGroupId=" + this.clj + ", dhSecretKey=" + this.clk + ", dhPublicKey=" + this.cll + ", dhServerPublicKey=" + this.clm + ", aesSecretKey=" + Arrays.toString(this.cln) + ", sessionTicket=" + Arrays.toString(this.clo) + ", expireTime=" + this.agv + ", entryType=" + Arrays.toString(this.clp) + ")";
    }

    public j(Integer num, Integer num2, Integer num3, Integer num4, byte[] bArr, byte[] bArr2, long j, byte[] bArr3) {
        this.clj = num;
        this.clk = num2;
        this.cll = num3;
        this.clm = num4;
        this.cln = bArr;
        this.clo = bArr2;
        this.agv = j;
        this.clp = bArr3;
    }

    public /* synthetic */ j(Integer num, Integer num2, Integer num3, Integer num4, byte[] bArr, byte[] bArr2, long j, byte[] bArr3, int i, o oVar) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : num3, (i & 8) != 0 ? null : num4, (i & 16) != 0 ? null : bArr, (i & 32) != 0 ? null : bArr2, (i & 64) != 0 ? 0L : j, (i & 128) != 0 ? null : bArr3);
    }

    public final Integer amN() {
        return this.clj;
    }

    public final void c(Integer num) {
        this.clj = num;
    }

    public final Integer amO() {
        return this.clk;
    }

    public final void d(Integer num) {
        this.clk = num;
    }

    public final Integer amP() {
        return this.cll;
    }

    public final void e(Integer num) {
        this.cll = num;
    }

    public final Integer amQ() {
        return this.clm;
    }

    public final void f(Integer num) {
        this.clm = num;
    }

    public final void I(byte[] bArr) {
        this.cln = bArr;
    }

    public final byte[] amR() {
        return this.cln;
    }

    public final void J(byte[] bArr) {
        this.clo = bArr;
    }

    public final byte[] amS() {
        return this.clo;
    }

    public final void g(long j) {
        this.agv = j;
    }

    public final void K(byte[] bArr) {
        this.clp = bArr;
    }

    public final int amJ() {
        return this.clh;
    }

    public final void hN(int i) {
        this.clh = i;
    }

    public final void amK() {
        this.cli++;
    }

    public final synchronized boolean amL() {
        boolean z = true;
        synchronized (this) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (this.cln == null || this.clo == null || this.agv <= currentTimeMillis || this.clh != 1) {
                z = false;
            }
            if (com.baidu.swan.games.bdtls.a.DEBUG) {
                Log.d("BDTLS", "isSessionEnable " + this.cln + ' ' + this.clo + ' ' + this.agv + ' ' + this.clh);
            }
        }
        return z;
    }

    public final boolean amM() {
        return this.cli < 3;
    }
}
