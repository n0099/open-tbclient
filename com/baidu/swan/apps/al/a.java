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
        sb.append(String.format(Locale.getDefault(), "%s :: code(%08d) desc(%s) \n", super.toString(), Long.valueOf(aQF()), Long.valueOf(aQz()), Long.valueOf(aQA()), Long.valueOf(aQB()), aQC()));
        if (i >= -200) {
            sb.append(String.format(Locale.getDefault(), "  p(%01d) f(%03d) e(%04d) \n", Long.valueOf(aQz()), Long.valueOf(aQA()), Long.valueOf(aQB())));
        }
        if (i >= -100) {
            sb.append(String.format(Locale.getDefault(), "  details(%s) \n", aQE()));
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

    public long aQz() {
        return this.dQC;
    }

    public a cV(long j) {
        this.dQA = a(j, 999L, "feature");
        return this;
    }

    public long aQA() {
        return this.dQA;
    }

    public a cW(long j) {
        this.dQB = a(j, 9999L, BdStatsConstant.StatsType.ERROR);
        return this;
    }

    public long aQB() {
        return this.dQB;
    }

    public a ux(String str) {
        if (str == null) {
            str = "";
        }
        this.mDesc = str;
        return this;
    }

    public String aQC() {
        return this.mDesc;
    }

    public a uy(String str) {
        if (str == null) {
            str = "";
        }
        this.dQD = str;
        return this;
    }

    public String aQD() {
        return this.dQD;
    }

    public a uz(String str) {
        this.mDetails.append(str).append("\n");
        return this;
    }

    public StringBuilder aQE() {
        return this.mDetails;
    }

    public long aQF() {
        return (aQz() * 10000000) + (aQA() * 10000) + (aQB() * 1);
    }

    public a cX(long j) {
        cU(j / 10000000);
        long j2 = j % 10000000;
        cV(j2 / 10000);
        cW((j2 % 10000) / 1);
        return this;
    }

    public boolean aQG() {
        return this.dQE;
    }

    public void aQH() {
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
