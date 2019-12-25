package com.baidu.swan.games.bdtls.model;

import android.util.Log;
import java.util.Arrays;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.p;
/* loaded from: classes9.dex */
public final class j {
    private long adZ;
    private int cgO;
    private volatile int cgP;
    private Integer cgQ;
    private Integer cgR;
    private Integer cgS;
    private Integer cgT;
    private byte[] cgU;
    private byte[] cgV;
    private byte[] cgW;

    public j() {
        this(null, null, null, null, null, null, 0L, null, 255, null);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof j)) {
                return false;
            }
            j jVar = (j) obj;
            if (!p.h(this.cgQ, jVar.cgQ) || !p.h(this.cgR, jVar.cgR) || !p.h(this.cgS, jVar.cgS) || !p.h(this.cgT, jVar.cgT) || !p.h(this.cgU, jVar.cgU) || !p.h(this.cgV, jVar.cgV)) {
                return false;
            }
            if (!(this.adZ == jVar.adZ) || !p.h(this.cgW, jVar.cgW)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        Integer num = this.cgQ;
        int hashCode = (num != null ? num.hashCode() : 0) * 31;
        Integer num2 = this.cgR;
        int hashCode2 = ((num2 != null ? num2.hashCode() : 0) + hashCode) * 31;
        Integer num3 = this.cgS;
        int hashCode3 = ((num3 != null ? num3.hashCode() : 0) + hashCode2) * 31;
        Integer num4 = this.cgT;
        int hashCode4 = ((num4 != null ? num4.hashCode() : 0) + hashCode3) * 31;
        byte[] bArr = this.cgU;
        int hashCode5 = ((bArr != null ? Arrays.hashCode(bArr) : 0) + hashCode4) * 31;
        byte[] bArr2 = this.cgV;
        int hashCode6 = bArr2 != null ? Arrays.hashCode(bArr2) : 0;
        long j = this.adZ;
        int i = (((hashCode6 + hashCode5) * 31) + ((int) (j ^ (j >>> 32)))) * 31;
        byte[] bArr3 = this.cgW;
        return i + (bArr3 != null ? Arrays.hashCode(bArr3) : 0);
    }

    public String toString() {
        return "SessionParams(dhGroupId=" + this.cgQ + ", dhSecretKey=" + this.cgR + ", dhPublicKey=" + this.cgS + ", dhServerPublicKey=" + this.cgT + ", aesSecretKey=" + Arrays.toString(this.cgU) + ", sessionTicket=" + Arrays.toString(this.cgV) + ", expireTime=" + this.adZ + ", entryType=" + Arrays.toString(this.cgW) + ")";
    }

    public j(Integer num, Integer num2, Integer num3, Integer num4, byte[] bArr, byte[] bArr2, long j, byte[] bArr3) {
        this.cgQ = num;
        this.cgR = num2;
        this.cgS = num3;
        this.cgT = num4;
        this.cgU = bArr;
        this.cgV = bArr2;
        this.adZ = j;
        this.cgW = bArr3;
    }

    public /* synthetic */ j(Integer num, Integer num2, Integer num3, Integer num4, byte[] bArr, byte[] bArr2, long j, byte[] bArr3, int i, o oVar) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : num3, (i & 8) != 0 ? null : num4, (i & 16) != 0 ? null : bArr, (i & 32) != 0 ? null : bArr2, (i & 64) != 0 ? 0L : j, (i & 128) != 0 ? null : bArr3);
    }

    public final Integer ake() {
        return this.cgQ;
    }

    public final void c(Integer num) {
        this.cgQ = num;
    }

    public final Integer akf() {
        return this.cgR;
    }

    public final void d(Integer num) {
        this.cgR = num;
    }

    public final Integer akg() {
        return this.cgS;
    }

    public final void e(Integer num) {
        this.cgS = num;
    }

    public final Integer akh() {
        return this.cgT;
    }

    public final void f(Integer num) {
        this.cgT = num;
    }

    public final void E(byte[] bArr) {
        this.cgU = bArr;
    }

    public final byte[] aki() {
        return this.cgU;
    }

    public final void F(byte[] bArr) {
        this.cgV = bArr;
    }

    public final byte[] akj() {
        return this.cgV;
    }

    public final void g(long j) {
        this.adZ = j;
    }

    public final void G(byte[] bArr) {
        this.cgW = bArr;
    }

    public final int aka() {
        return this.cgO;
    }

    public final void hw(int i) {
        this.cgO = i;
    }

    public final void akb() {
        this.cgP++;
    }

    public final synchronized boolean akc() {
        boolean z = true;
        synchronized (this) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (this.cgU == null || this.cgV == null || this.adZ <= currentTimeMillis || this.cgO != 1) {
                z = false;
            }
            if (com.baidu.swan.games.bdtls.a.DEBUG) {
                Log.d("BDTLS", "isSessionEnable " + this.cgU + ' ' + this.cgV + ' ' + this.adZ + ' ' + this.cgO);
            }
        }
        return z;
    }

    public final boolean akd() {
        return this.cgP < 3;
    }
}
