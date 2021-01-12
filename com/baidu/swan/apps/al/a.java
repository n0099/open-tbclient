package com.baidu.swan.apps.al;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
import java.util.Locale;
/* loaded from: classes8.dex */
public final class a {
    private a dLN = null;
    private long dLO = 0;
    private long dLP = 0;
    private long dLQ = 2;
    private String mDesc = "";
    private String dLR = "";
    private final StringBuilder mDetails = new StringBuilder();
    private boolean dLS = false;

    public String toString(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(Locale.getDefault(), "%s :: code(%08d) desc(%s) \n", super.toString(), Long.valueOf(aMM()), Long.valueOf(aMG()), Long.valueOf(aMH()), Long.valueOf(aMI()), aMJ()));
        if (i >= -200) {
            sb.append(String.format(Locale.getDefault(), "  p(%01d) f(%03d) e(%04d) \n", Long.valueOf(aMG()), Long.valueOf(aMH()), Long.valueOf(aMI())));
        }
        if (i >= -100) {
            sb.append(String.format(Locale.getDefault(), "  details(%s) \n", aML()));
        }
        return sb.toString();
    }

    public String toString() {
        return toString(-100);
    }

    public a cU(long j) {
        this.dLQ = a(j, 9L, "platform");
        return this;
    }

    public long aMG() {
        return this.dLQ;
    }

    public a cV(long j) {
        this.dLO = a(j, 999L, "feature");
        return this;
    }

    public long aMH() {
        return this.dLO;
    }

    public a cW(long j) {
        this.dLP = a(j, 9999L, BdStatsConstant.StatsType.ERROR);
        return this;
    }

    public long aMI() {
        return this.dLP;
    }

    public a tm(String str) {
        if (str == null) {
            str = "";
        }
        this.mDesc = str;
        return this;
    }

    public String aMJ() {
        return this.mDesc;
    }

    public a tn(String str) {
        if (str == null) {
            str = "";
        }
        this.dLR = str;
        return this;
    }

    public String aMK() {
        return this.dLR;
    }

    public a to(String str) {
        this.mDetails.append(str).append("\n");
        return this;
    }

    public StringBuilder aML() {
        return this.mDetails;
    }

    public long aMM() {
        return (aMG() * 10000000) + (aMH() * 10000) + (aMI() * 1);
    }

    public a cX(long j) {
        cU(j / 10000000);
        long j2 = j % 10000000;
        cV(j2 / 10000);
        cW((j2 % 10000) / 1);
        return this;
    }

    public boolean aMN() {
        return this.dLS;
    }

    public void aMO() {
        this.dLS = true;
    }

    private long a(long j, long j2, String str) {
        boolean z = j < 0 || j > j2;
        if (z) {
            to("illegalFallback " + str + "::" + j);
        }
        return z ? j2 : j;
    }
}
