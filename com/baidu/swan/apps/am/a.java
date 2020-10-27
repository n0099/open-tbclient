package com.baidu.swan.apps.am;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
import java.util.Locale;
/* loaded from: classes10.dex */
public final class a {
    private a dwL = null;
    private long dwM = 0;
    private long dwN = 0;
    private long dwO = 2;
    private String mDesc = "";
    private String dwP = "";
    private final StringBuilder mDetails = new StringBuilder();
    private boolean dwQ = false;

    public String toString(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(Locale.getDefault(), "%s :: code(%08d) desc(%s) \n", super.toString(), Long.valueOf(aJp()), Long.valueOf(aJj()), Long.valueOf(aJk()), Long.valueOf(aJl()), aJm()));
        if (i >= -200) {
            sb.append(String.format(Locale.getDefault(), "  p(%01d) f(%03d) e(%04d) \n", Long.valueOf(aJj()), Long.valueOf(aJk()), Long.valueOf(aJl())));
        }
        if (i >= -100) {
            sb.append(String.format(Locale.getDefault(), "  details(%s) \n", aJo()));
        }
        return sb.toString();
    }

    public String toString() {
        return toString(-100);
    }

    public a bY(long j) {
        this.dwO = a(j, 9L, "platform");
        return this;
    }

    public long aJj() {
        return this.dwO;
    }

    public a bZ(long j) {
        this.dwM = a(j, 999L, "feature");
        return this;
    }

    public long aJk() {
        return this.dwM;
    }

    public a ca(long j) {
        this.dwN = a(j, 9999L, BdStatsConstant.StatsType.ERROR);
        return this;
    }

    public long aJl() {
        return this.dwN;
    }

    public a tK(String str) {
        if (str == null) {
            str = "";
        }
        this.mDesc = str;
        return this;
    }

    public String aJm() {
        return this.mDesc;
    }

    public a tL(String str) {
        if (str == null) {
            str = "";
        }
        this.dwP = str;
        return this;
    }

    public String aJn() {
        return this.dwP;
    }

    public a tM(String str) {
        this.mDetails.append(str).append("\n");
        return this;
    }

    public StringBuilder aJo() {
        return this.mDetails;
    }

    public long aJp() {
        return (aJj() * 10000000) + (aJk() * 10000) + (aJl() * 1);
    }

    public a cb(long j) {
        bY(j / 10000000);
        long j2 = j % 10000000;
        bZ(j2 / 10000);
        ca((j2 % 10000) / 1);
        return this;
    }

    public boolean aJq() {
        return this.dwQ;
    }

    public void aJr() {
        this.dwQ = true;
    }

    private long a(long j, long j2, String str) {
        boolean z = j < 0 || j > j2;
        if (z) {
            tM("illegalFallback " + str + "::" + j);
        }
        return z ? j2 : j;
    }
}
