package com.baidu.swan.apps.al;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
import java.util.Locale;
/* loaded from: classes9.dex */
public final class a {
    private a dQz = null;
    private long dQA = 0;
    private long dQB = 0;
    private long dQC = 2;
    private String mDesc = "";
    private String dQD = "";
    private final StringBuilder mDetails = new StringBuilder();
    private boolean dQE = false;

    public String toString(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(Locale.getDefault(), "%s :: code(%08d) desc(%s) \n", super.toString(), Long.valueOf(aQG()), Long.valueOf(aQA()), Long.valueOf(aQB()), Long.valueOf(aQC()), aQD()));
        if (i >= -200) {
            sb.append(String.format(Locale.getDefault(), "  p(%01d) f(%03d) e(%04d) \n", Long.valueOf(aQA()), Long.valueOf(aQB()), Long.valueOf(aQC())));
        }
        if (i >= -100) {
            sb.append(String.format(Locale.getDefault(), "  details(%s) \n", aQF()));
        }
        return sb.toString();
    }

    public String toString() {
        return toString(-100);
    }

    public a cU(long j) {
        this.dQC = a(j, 9L, "platform");
        return this;
    }

    public long aQA() {
        return this.dQC;
    }

    public a cV(long j) {
        this.dQA = a(j, 999L, "feature");
        return this;
    }

    public long aQB() {
        return this.dQA;
    }

    public a cW(long j) {
        this.dQB = a(j, 9999L, BdStatsConstant.StatsType.ERROR);
        return this;
    }

    public long aQC() {
        return this.dQB;
    }

    public a ux(String str) {
        if (str == null) {
            str = "";
        }
        this.mDesc = str;
        return this;
    }

    public String aQD() {
        return this.mDesc;
    }

    public a uy(String str) {
        if (str == null) {
            str = "";
        }
        this.dQD = str;
        return this;
    }

    public String aQE() {
        return this.dQD;
    }

    public a uz(String str) {
        this.mDetails.append(str).append("\n");
        return this;
    }

    public StringBuilder aQF() {
        return this.mDetails;
    }

    public long aQG() {
        return (aQA() * 10000000) + (aQB() * 10000) + (aQC() * 1);
    }

    public a cX(long j) {
        cU(j / 10000000);
        long j2 = j % 10000000;
        cV(j2 / 10000);
        cW((j2 % 10000) / 1);
        return this;
    }

    public boolean aQH() {
        return this.dQE;
    }

    public void aQI() {
        this.dQE = true;
    }

    private long a(long j, long j2, String str) {
        boolean z = j < 0 || j > j2;
        if (z) {
            uz("illegalFallback " + str + "::" + j);
        }
        return z ? j2 : j;
    }
}
