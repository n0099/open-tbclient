package com.baidu.swan.games.bdtls.model;

import android.util.Log;
import java.util.Arrays;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes11.dex */
public final class j {
    private long agF;
    private byte[] clA;
    private int cls;
    private volatile int clt;
    private Integer clu;
    private Integer clv;
    private Integer clw;
    private Integer clx;
    private byte[] cly;
    private byte[] clz;

    public j() {
        this(null, null, null, null, null, null, 0L, null, 255, null);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof j)) {
                return false;
            }
            j jVar = (j) obj;
            if (!q.h(this.clu, jVar.clu) || !q.h(this.clv, jVar.clv) || !q.h(this.clw, jVar.clw) || !q.h(this.clx, jVar.clx) || !q.h(this.cly, jVar.cly) || !q.h(this.clz, jVar.clz)) {
                return false;
            }
            if (!(this.agF == jVar.agF) || !q.h(this.clA, jVar.clA)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        Integer num = this.clu;
        int hashCode = (num != null ? num.hashCode() : 0) * 31;
        Integer num2 = this.clv;
        int hashCode2 = ((num2 != null ? num2.hashCode() : 0) + hashCode) * 31;
        Integer num3 = this.clw;
        int hashCode3 = ((num3 != null ? num3.hashCode() : 0) + hashCode2) * 31;
        Integer num4 = this.clx;
        int hashCode4 = ((num4 != null ? num4.hashCode() : 0) + hashCode3) * 31;
        byte[] bArr = this.cly;
        int hashCode5 = ((bArr != null ? Arrays.hashCode(bArr) : 0) + hashCode4) * 31;
        byte[] bArr2 = this.clz;
        int hashCode6 = bArr2 != null ? Arrays.hashCode(bArr2) : 0;
        long j = this.agF;
        int i = (((hashCode6 + hashCode5) * 31) + ((int) (j ^ (j >>> 32)))) * 31;
        byte[] bArr3 = this.clA;
        return i + (bArr3 != null ? Arrays.hashCode(bArr3) : 0);
    }

    public String toString() {
        return "SessionParams(dhGroupId=" + this.clu + ", dhSecretKey=" + this.clv + ", dhPublicKey=" + this.clw + ", dhServerPublicKey=" + this.clx + ", aesSecretKey=" + Arrays.toString(this.cly) + ", sessionTicket=" + Arrays.toString(this.clz) + ", expireTime=" + this.agF + ", entryType=" + Arrays.toString(this.clA) + ")";
    }

    public j(Integer num, Integer num2, Integer num3, Integer num4, byte[] bArr, byte[] bArr2, long j, byte[] bArr3) {
        this.clu = num;
        this.clv = num2;
        this.clw = num3;
        this.clx = num4;
        this.cly = bArr;
        this.clz = bArr2;
        this.agF = j;
        this.clA = bArr3;
    }

    public /* synthetic */ j(Integer num, Integer num2, Integer num3, Integer num4, byte[] bArr, byte[] bArr2, long j, byte[] bArr3, int i, o oVar) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : num3, (i & 8) != 0 ? null : num4, (i & 16) != 0 ? null : bArr, (i & 32) != 0 ? null : bArr2, (i & 64) != 0 ? 0L : j, (i & 128) != 0 ? null : bArr3);
    }

    public final Integer amQ() {
        return this.clu;
    }

    public final void c(Integer num) {
        this.clu = num;
    }

    public final Integer amR() {
        return this.clv;
    }

    public final void d(Integer num) {
        this.clv = num;
    }

    public final Integer amS() {
        return this.clw;
    }

    public final void e(Integer num) {
        this.clw = num;
    }

    public final Integer amT() {
        return this.clx;
    }

    public final void f(Integer num) {
        this.clx = num;
    }

    public final void I(byte[] bArr) {
        this.cly = bArr;
    }

    public final byte[] amU() {
        return this.cly;
    }

    public final void J(byte[] bArr) {
        this.clz = bArr;
    }

    public final byte[] amV() {
        return this.clz;
    }

    public final void g(long j) {
        this.agF = j;
    }

    public final void K(byte[] bArr) {
        this.clA = bArr;
    }

    public final int amM() {
        return this.cls;
    }

    public final void hN(int i) {
        this.cls = i;
    }

    public final void amN() {
        this.clt++;
    }

    public final synchronized boolean amO() {
        boolean z = true;
        synchronized (this) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (this.cly == null || this.clz == null || this.agF <= currentTimeMillis || this.cls != 1) {
                z = false;
            }
            if (com.baidu.swan.games.bdtls.a.DEBUG) {
                Log.d("BDTLS", "isSessionEnable " + this.cly + ' ' + this.clz + ' ' + this.agF + ' ' + this.cls);
            }
        }
        return z;
    }

    public final boolean amP() {
        return this.clt < 3;
    }
}
