package com.baidu.swan.games.bdtls.model;

import android.util.Log;
import java.util.Arrays;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes11.dex */
public final class j {
    private long ayV;
    private int cKp;
    private volatile int cKq;
    private Integer cKr;
    private Integer cKs;
    private Integer cKt;
    private Integer cKu;
    private byte[] cKv;
    private byte[] cKw;
    private byte[] cKx;

    public j() {
        this(null, null, null, null, null, null, 0L, null, 255, null);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof j)) {
                return false;
            }
            j jVar = (j) obj;
            if (!q.k(this.cKr, jVar.cKr) || !q.k(this.cKs, jVar.cKs) || !q.k(this.cKt, jVar.cKt) || !q.k(this.cKu, jVar.cKu) || !q.k(this.cKv, jVar.cKv) || !q.k(this.cKw, jVar.cKw)) {
                return false;
            }
            if (!(this.ayV == jVar.ayV) || !q.k(this.cKx, jVar.cKx)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        Integer num = this.cKr;
        int hashCode = (num != null ? num.hashCode() : 0) * 31;
        Integer num2 = this.cKs;
        int hashCode2 = ((num2 != null ? num2.hashCode() : 0) + hashCode) * 31;
        Integer num3 = this.cKt;
        int hashCode3 = ((num3 != null ? num3.hashCode() : 0) + hashCode2) * 31;
        Integer num4 = this.cKu;
        int hashCode4 = ((num4 != null ? num4.hashCode() : 0) + hashCode3) * 31;
        byte[] bArr = this.cKv;
        int hashCode5 = ((bArr != null ? Arrays.hashCode(bArr) : 0) + hashCode4) * 31;
        byte[] bArr2 = this.cKw;
        int hashCode6 = bArr2 != null ? Arrays.hashCode(bArr2) : 0;
        long j = this.ayV;
        int i = (((hashCode6 + hashCode5) * 31) + ((int) (j ^ (j >>> 32)))) * 31;
        byte[] bArr3 = this.cKx;
        return i + (bArr3 != null ? Arrays.hashCode(bArr3) : 0);
    }

    public String toString() {
        return "SessionParams(dhGroupId=" + this.cKr + ", dhSecretKey=" + this.cKs + ", dhPublicKey=" + this.cKt + ", dhServerPublicKey=" + this.cKu + ", aesSecretKey=" + Arrays.toString(this.cKv) + ", sessionTicket=" + Arrays.toString(this.cKw) + ", expireTime=" + this.ayV + ", entryType=" + Arrays.toString(this.cKx) + ")";
    }

    public j(Integer num, Integer num2, Integer num3, Integer num4, byte[] bArr, byte[] bArr2, long j, byte[] bArr3) {
        this.cKr = num;
        this.cKs = num2;
        this.cKt = num3;
        this.cKu = num4;
        this.cKv = bArr;
        this.cKw = bArr2;
        this.ayV = j;
        this.cKx = bArr3;
    }

    public /* synthetic */ j(Integer num, Integer num2, Integer num3, Integer num4, byte[] bArr, byte[] bArr2, long j, byte[] bArr3, int i, o oVar) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : num3, (i & 8) != 0 ? null : num4, (i & 16) != 0 ? null : bArr, (i & 32) != 0 ? null : bArr2, (i & 64) != 0 ? 0L : j, (i & 128) != 0 ? null : bArr3);
    }

    public final Integer avd() {
        return this.cKr;
    }

    public final void c(Integer num) {
        this.cKr = num;
    }

    public final Integer ave() {
        return this.cKs;
    }

    public final void d(Integer num) {
        this.cKs = num;
    }

    public final Integer avf() {
        return this.cKt;
    }

    public final void e(Integer num) {
        this.cKt = num;
    }

    public final Integer avg() {
        return this.cKu;
    }

    public final void f(Integer num) {
        this.cKu = num;
    }

    public final void K(byte[] bArr) {
        this.cKv = bArr;
    }

    public final byte[] avh() {
        return this.cKv;
    }

    public final void L(byte[] bArr) {
        this.cKw = bArr;
    }

    public final byte[] avi() {
        return this.cKw;
    }

    public final void E(long j) {
        this.ayV = j;
    }

    public final void M(byte[] bArr) {
        this.cKx = bArr;
    }

    public final int auZ() {
        return this.cKp;
    }

    public final void hU(int i) {
        this.cKp = i;
    }

    public final void ava() {
        this.cKq++;
    }

    public final synchronized boolean avb() {
        boolean z = true;
        synchronized (this) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (this.cKv == null || this.cKw == null || this.ayV <= currentTimeMillis || this.cKp != 1) {
                z = false;
            }
            if (com.baidu.swan.games.bdtls.a.DEBUG) {
                Log.d("BDTLS", "isSessionEnable " + this.cKv + ' ' + this.cKw + ' ' + this.ayV + ' ' + this.cKp);
            }
        }
        return z;
    }

    public final boolean avc() {
        return this.cKq < 3;
    }
}
