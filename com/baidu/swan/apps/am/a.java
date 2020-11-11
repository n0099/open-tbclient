package com.baidu.swan.apps.am;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
import java.util.Locale;
/* loaded from: classes10.dex */
public final class a {
    private a dCD = null;
    private long dCE = 0;
    private long dCF = 0;
    private long dCG = 2;
    private String mDesc = "";
    private String dCH = "";
    private final StringBuilder mDetails = new StringBuilder();
    private boolean dCI = false;

    public String toString(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(Locale.getDefault(), "%s :: code(%08d) desc(%s) \n", super.toString(), Long.valueOf(aLP()), Long.valueOf(aLJ()), Long.valueOf(aLK()), Long.valueOf(aLL()), aLM()));
        if (i >= -200) {
            sb.append(String.format(Locale.getDefault(), "  p(%01d) f(%03d) e(%04d) \n", Long.valueOf(aLJ()), Long.valueOf(aLK()), Long.valueOf(aLL())));
        }
        if (i >= -100) {
            sb.append(String.format(Locale.getDefault(), "  details(%s) \n", aLO()));
        }
        return sb.toString();
    }

    public String toString() {
        return toString(-100);
    }

    public a cu(long j) {
        this.dCG = a(j, 9L, "platform");
        return this;
    }

    public long aLJ() {
        return this.dCG;
    }

    public a cv(long j) {
        this.dCE = a(j, 999L, "feature");
        return this;
    }

    public long aLK() {
        return this.dCE;
    }

    public a cw(long j) {
        this.dCF = a(j, 9999L, BdStatsConstant.StatsType.ERROR);
        return this;
    }

    public long aLL() {
        return this.dCF;
    }

    public a tY(String str) {
        if (str == null) {
            str = "";
        }
        this.mDesc = str;
        return this;
    }

    public String aLM() {
        return this.mDesc;
    }

    public a tZ(String str) {
        if (str == null) {
            str = "";
        }
        this.dCH = str;
        return this;
    }

    public String aLN() {
        return this.dCH;
    }

    public a ua(String str) {
        this.mDetails.append(str).append("\n");
        return this;
    }

    public StringBuilder aLO() {
        return this.mDetails;
    }

    public long aLP() {
        return (aLJ() * 10000000) + (aLK() * 10000) + (aLL() * 1);
    }

    public a cx(long j) {
        cu(j / 10000000);
        long j2 = j % 10000000;
        cv(j2 / 10000);
        cw((j2 % 10000) / 1);
        return this;
    }

    public boolean aLQ() {
        return this.dCI;
    }

    public void aLR() {
        this.dCI = true;
    }

    private long a(long j, long j2, String str) {
        boolean z = j < 0 || j > j2;
        if (z) {
            ua("illegalFallback " + str + "::" + j);
        }
        return z ? j2 : j;
    }
}
