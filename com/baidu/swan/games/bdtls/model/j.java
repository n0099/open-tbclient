package com.baidu.swan.games.bdtls.model;

import android.util.Log;
import java.util.Arrays;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes11.dex */
public final class j {
    private long azb;
    private Integer cKA;
    private byte[] cKB;
    private byte[] cKC;
    private byte[] cKD;
    private int cKv;
    private volatile int cKw;
    private Integer cKx;
    private Integer cKy;
    private Integer cKz;

    public j() {
        this(null, null, null, null, null, null, 0L, null, 255, null);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof j)) {
                return false;
            }
            j jVar = (j) obj;
            if (!q.k(this.cKx, jVar.cKx) || !q.k(this.cKy, jVar.cKy) || !q.k(this.cKz, jVar.cKz) || !q.k(this.cKA, jVar.cKA) || !q.k(this.cKB, jVar.cKB) || !q.k(this.cKC, jVar.cKC)) {
                return false;
            }
            if (!(this.azb == jVar.azb) || !q.k(this.cKD, jVar.cKD)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        Integer num = this.cKx;
        int hashCode = (num != null ? num.hashCode() : 0) * 31;
        Integer num2 = this.cKy;
        int hashCode2 = ((num2 != null ? num2.hashCode() : 0) + hashCode) * 31;
        Integer num3 = this.cKz;
        int hashCode3 = ((num3 != null ? num3.hashCode() : 0) + hashCode2) * 31;
        Integer num4 = this.cKA;
        int hashCode4 = ((num4 != null ? num4.hashCode() : 0) + hashCode3) * 31;
        byte[] bArr = this.cKB;
        int hashCode5 = ((bArr != null ? Arrays.hashCode(bArr) : 0) + hashCode4) * 31;
        byte[] bArr2 = this.cKC;
        int hashCode6 = bArr2 != null ? Arrays.hashCode(bArr2) : 0;
        long j = this.azb;
        int i = (((hashCode6 + hashCode5) * 31) + ((int) (j ^ (j >>> 32)))) * 31;
        byte[] bArr3 = this.cKD;
        return i + (bArr3 != null ? Arrays.hashCode(bArr3) : 0);
    }

    public String toString() {
        return "SessionParams(dhGroupId=" + this.cKx + ", dhSecretKey=" + this.cKy + ", dhPublicKey=" + this.cKz + ", dhServerPublicKey=" + this.cKA + ", aesSecretKey=" + Arrays.toString(this.cKB) + ", sessionTicket=" + Arrays.toString(this.cKC) + ", expireTime=" + this.azb + ", entryType=" + Arrays.toString(this.cKD) + ")";
    }

    public j(Integer num, Integer num2, Integer num3, Integer num4, byte[] bArr, byte[] bArr2, long j, byte[] bArr3) {
        this.cKx = num;
        this.cKy = num2;
        this.cKz = num3;
        this.cKA = num4;
        this.cKB = bArr;
        this.cKC = bArr2;
        this.azb = j;
        this.cKD = bArr3;
    }

    public /* synthetic */ j(Integer num, Integer num2, Integer num3, Integer num4, byte[] bArr, byte[] bArr2, long j, byte[] bArr3, int i, o oVar) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : num3, (i & 8) != 0 ? null : num4, (i & 16) != 0 ? null : bArr, (i & 32) != 0 ? null : bArr2, (i & 64) != 0 ? 0L : j, (i & 128) != 0 ? null : bArr3);
    }

    public final Integer avd() {
        return this.cKx;
    }

    public final void c(Integer num) {
        this.cKx = num;
    }

    public final Integer ave() {
        return this.cKy;
    }

    public final void d(Integer num) {
        this.cKy = num;
    }

    public final Integer avf() {
        return this.cKz;
    }

    public final void e(Integer num) {
        this.cKz = num;
    }

    public final Integer avg() {
        return this.cKA;
    }

    public final void f(Integer num) {
        this.cKA = num;
    }

    public final void K(byte[] bArr) {
        this.cKB = bArr;
    }

    public final byte[] avh() {
        return this.cKB;
    }

    public final void L(byte[] bArr) {
        this.cKC = bArr;
    }

    public final byte[] avi() {
        return this.cKC;
    }

    public final void E(long j) {
        this.azb = j;
    }

    public final void M(byte[] bArr) {
        this.cKD = bArr;
    }

    public final int auZ() {
        return this.cKv;
    }

    public final void hU(int i) {
        this.cKv = i;
    }

    public final void ava() {
        this.cKw++;
    }

    public final synchronized boolean avb() {
        boolean z = true;
        synchronized (this) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (this.cKB == null || this.cKC == null || this.azb <= currentTimeMillis || this.cKv != 1) {
                z = false;
            }
            if (com.baidu.swan.games.bdtls.a.DEBUG) {
                Log.d("BDTLS", "isSessionEnable " + this.cKB + ' ' + this.cKC + ' ' + this.azb + ' ' + this.cKv);
            }
        }
        return z;
    }

    public final boolean avc() {
        return this.cKw < 3;
    }
}
