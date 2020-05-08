package com.baidu.swan.apps.ap;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
import java.util.Locale;
/* loaded from: classes11.dex */
public final class a {
    private a cwO = null;
    private long cwP = 0;
    private long cwQ = 0;
    private long cwR = 2;
    private String mDesc = "";
    private final StringBuilder mDetails = new StringBuilder();
    private boolean cwS = false;

    public String toString(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(Locale.getDefault(), "%s :: code(%08d) desc(%s) \n", super.toString(), Long.valueOf(aor()), Long.valueOf(aom()), Long.valueOf(aon()), Long.valueOf(aoo()), aop()));
        if (i >= -200) {
            sb.append(String.format(Locale.getDefault(), "  p(%01d) f(%03d) e(%04d) \n", Long.valueOf(aom()), Long.valueOf(aon()), Long.valueOf(aoo())));
        }
        if (i >= -100) {
            sb.append(String.format(Locale.getDefault(), "  details(%s) \n", aoq()));
        }
        return sb.toString();
    }

    public String toString() {
        return toString(-100);
    }

    public a bm(long j) {
        this.cwR = a(j, 9L, "platform");
        return this;
    }

    public long aom() {
        return this.cwR;
    }

    public a bn(long j) {
        this.cwP = a(j, 999L, "feature");
        return this;
    }

    public long aon() {
        return this.cwP;
    }

    public a bo(long j) {
        this.cwQ = a(j, 9999L, BdStatsConstant.StatsType.ERROR);
        return this;
    }

    public long aoo() {
        return this.cwQ;
    }

    public a nK(String str) {
        if (str == null) {
            str = "";
        }
        this.mDesc = str;
        return this;
    }

    public String aop() {
        return this.mDesc;
    }

    public a nL(String str) {
        this.mDetails.append(str).append("\n");
        return this;
    }

    public StringBuilder aoq() {
        return this.mDetails;
    }

    public long aor() {
        return (aom() * 10000000) + (aon() * 10000) + (aoo() * 1);
    }

    public a bp(long j) {
        bm(j / 10000000);
        long j2 = j % 10000000;
        bn(j2 / 10000);
        bo((j2 % 10000) / 1);
        return this;
    }

    public boolean aos() {
        return this.cwS;
    }

    public void aot() {
        this.cwS = true;
    }

    private long a(long j, long j2, String str) {
        boolean z = j < 0 || j > j2;
        if (z) {
            nL("illegalFallback " + str + "::" + String.valueOf(j));
        }
        return z ? j2 : j;
    }
}
