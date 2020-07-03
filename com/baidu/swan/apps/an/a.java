package com.baidu.swan.apps.an;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
import java.util.Locale;
/* loaded from: classes11.dex */
public final class a {
    private a cNA = null;
    private long cNB = 0;
    private long cNC = 0;
    private long cND = 2;
    private String mDesc = "";
    private String cNE = "";
    private final StringBuilder mDetails = new StringBuilder();
    private boolean cNF = false;

    public String toString(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(Locale.getDefault(), "%s :: code(%08d) desc(%s) \n", super.toString(), Long.valueOf(atS()), Long.valueOf(atM()), Long.valueOf(atN()), Long.valueOf(atO()), atP()));
        if (i >= -200) {
            sb.append(String.format(Locale.getDefault(), "  p(%01d) f(%03d) e(%04d) \n", Long.valueOf(atM()), Long.valueOf(atN()), Long.valueOf(atO())));
        }
        if (i >= -100) {
            sb.append(String.format(Locale.getDefault(), "  details(%s) \n", atR()));
        }
        return sb.toString();
    }

    public String toString() {
        return toString(-100);
    }

    public a bv(long j) {
        this.cND = a(j, 9L, "platform");
        return this;
    }

    public long atM() {
        return this.cND;
    }

    public a bw(long j) {
        this.cNB = a(j, 999L, "feature");
        return this;
    }

    public long atN() {
        return this.cNB;
    }

    public a bx(long j) {
        this.cNC = a(j, 9999L, BdStatsConstant.StatsType.ERROR);
        return this;
    }

    public long atO() {
        return this.cNC;
    }

    public a pz(String str) {
        if (str == null) {
            str = "";
        }
        this.mDesc = str;
        return this;
    }

    public String atP() {
        return this.mDesc;
    }

    public a pA(String str) {
        if (str == null) {
            str = "";
        }
        this.cNE = str;
        return this;
    }

    public String atQ() {
        return this.cNE;
    }

    public a pB(String str) {
        this.mDetails.append(str).append("\n");
        return this;
    }

    public StringBuilder atR() {
        return this.mDetails;
    }

    public long atS() {
        return (atM() * 10000000) + (atN() * 10000) + (atO() * 1);
    }

    public a by(long j) {
        bv(j / 10000000);
        long j2 = j % 10000000;
        bw(j2 / 10000);
        bx((j2 % 10000) / 1);
        return this;
    }

    public boolean atT() {
        return this.cNF;
    }

    public void atU() {
        this.cNF = true;
    }

    private long a(long j, long j2, String str) {
        boolean z = j < 0 || j > j2;
        if (z) {
            pB("illegalFallback " + str + "::" + String.valueOf(j));
        }
        return z ? j2 : j;
    }
}
