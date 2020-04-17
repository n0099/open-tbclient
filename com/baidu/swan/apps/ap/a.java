package com.baidu.swan.apps.ap;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
import java.util.Locale;
/* loaded from: classes11.dex */
public final class a {
    private a cwI = null;
    private long cwJ = 0;
    private long cwK = 0;
    private long cwL = 2;
    private String mDesc = "";
    private final StringBuilder mDetails = new StringBuilder();
    private boolean cwM = false;

    public String toString(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(Locale.getDefault(), "%s :: code(%08d) desc(%s) \n", super.toString(), Long.valueOf(aos()), Long.valueOf(aon()), Long.valueOf(aoo()), Long.valueOf(aop()), aoq()));
        if (i >= -200) {
            sb.append(String.format(Locale.getDefault(), "  p(%01d) f(%03d) e(%04d) \n", Long.valueOf(aon()), Long.valueOf(aoo()), Long.valueOf(aop())));
        }
        if (i >= -100) {
            sb.append(String.format(Locale.getDefault(), "  details(%s) \n", aor()));
        }
        return sb.toString();
    }

    public String toString() {
        return toString(-100);
    }

    public a bm(long j) {
        this.cwL = a(j, 9L, "platform");
        return this;
    }

    public long aon() {
        return this.cwL;
    }

    public a bn(long j) {
        this.cwJ = a(j, 999L, "feature");
        return this;
    }

    public long aoo() {
        return this.cwJ;
    }

    public a bo(long j) {
        this.cwK = a(j, 9999L, BdStatsConstant.StatsType.ERROR);
        return this;
    }

    public long aop() {
        return this.cwK;
    }

    public a nK(String str) {
        if (str == null) {
            str = "";
        }
        this.mDesc = str;
        return this;
    }

    public String aoq() {
        return this.mDesc;
    }

    public a nL(String str) {
        this.mDetails.append(str).append("\n");
        return this;
    }

    public StringBuilder aor() {
        return this.mDetails;
    }

    public long aos() {
        return (aon() * 10000000) + (aoo() * 10000) + (aop() * 1);
    }

    public a bp(long j) {
        bm(j / 10000000);
        long j2 = j % 10000000;
        bn(j2 / 10000);
        bo((j2 % 10000) / 1);
        return this;
    }

    public boolean aot() {
        return this.cwM;
    }

    public void aou() {
        this.cwM = true;
    }

    private long a(long j, long j2, String str) {
        boolean z = j < 0 || j > j2;
        if (z) {
            nL("illegalFallback " + str + "::" + String.valueOf(j));
        }
        return z ? j2 : j;
    }
}
