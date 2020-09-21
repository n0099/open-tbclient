package com.baidu.swan.apps.am;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
import java.util.Locale;
/* loaded from: classes3.dex */
public final class a {
    private a dcb = null;
    private long dcc = 0;
    private long dcd = 0;
    private long dce = 2;
    private String mDesc = "";
    private String dcf = "";
    private final StringBuilder mDetails = new StringBuilder();
    private boolean dcg = false;

    public String toString(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(Locale.getDefault(), "%s :: code(%08d) desc(%s) \n", super.toString(), Long.valueOf(aEM()), Long.valueOf(aEG()), Long.valueOf(aEH()), Long.valueOf(aEI()), aEJ()));
        if (i >= -200) {
            sb.append(String.format(Locale.getDefault(), "  p(%01d) f(%03d) e(%04d) \n", Long.valueOf(aEG()), Long.valueOf(aEH()), Long.valueOf(aEI())));
        }
        if (i >= -100) {
            sb.append(String.format(Locale.getDefault(), "  details(%s) \n", aEL()));
        }
        return sb.toString();
    }

    public String toString() {
        return toString(-100);
    }

    public a bO(long j) {
        this.dce = a(j, 9L, "platform");
        return this;
    }

    public long aEG() {
        return this.dce;
    }

    public a bP(long j) {
        this.dcc = a(j, 999L, "feature");
        return this;
    }

    public long aEH() {
        return this.dcc;
    }

    public a bQ(long j) {
        this.dcd = a(j, 9999L, BdStatsConstant.StatsType.ERROR);
        return this;
    }

    public long aEI() {
        return this.dcd;
    }

    public a sF(String str) {
        if (str == null) {
            str = "";
        }
        this.mDesc = str;
        return this;
    }

    public String aEJ() {
        return this.mDesc;
    }

    public a sG(String str) {
        if (str == null) {
            str = "";
        }
        this.dcf = str;
        return this;
    }

    public String aEK() {
        return this.dcf;
    }

    public a sH(String str) {
        this.mDetails.append(str).append("\n");
        return this;
    }

    public StringBuilder aEL() {
        return this.mDetails;
    }

    public long aEM() {
        return (aEG() * 10000000) + (aEH() * 10000) + (aEI() * 1);
    }

    public a bR(long j) {
        bO(j / 10000000);
        long j2 = j % 10000000;
        bP(j2 / 10000);
        bQ((j2 % 10000) / 1);
        return this;
    }

    public boolean aEN() {
        return this.dcg;
    }

    public void aEO() {
        this.dcg = true;
    }

    private long a(long j, long j2, String str) {
        boolean z = j < 0 || j > j2;
        if (z) {
            sH("illegalFallback " + str + "::" + j);
        }
        return z ? j2 : j;
    }
}
