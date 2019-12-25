package com.baidu.swan.apps.ap;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
import java.util.Locale;
/* loaded from: classes9.dex */
public final class a {
    private a bTn = null;
    private long bTo = 0;
    private long bTp = 0;
    private long bTq = 2;
    private String mDesc = "";
    private final StringBuilder mDetails = new StringBuilder();
    private boolean bTr = false;

    public String toString(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(Locale.getDefault(), "%s :: code(%08d) desc(%s) \n", super.toString(), Long.valueOf(adB()), Long.valueOf(adw()), Long.valueOf(adx()), Long.valueOf(ady()), adz()));
        if (i >= -200) {
            sb.append(String.format(Locale.getDefault(), "  p(%01d) f(%03d) e(%04d) \n", Long.valueOf(adw()), Long.valueOf(adx()), Long.valueOf(ady())));
        }
        if (i >= -100) {
            sb.append(String.format(Locale.getDefault(), "  details(%s) \n", adA()));
        }
        return sb.toString();
    }

    public String toString() {
        return toString(-100);
    }

    public a aA(long j) {
        this.bTq = a(j, 9L, "platform");
        return this;
    }

    public long adw() {
        return this.bTq;
    }

    public a aB(long j) {
        this.bTo = a(j, 999L, "feature");
        return this;
    }

    public long adx() {
        return this.bTo;
    }

    public a aC(long j) {
        this.bTp = a(j, 9999L, BdStatsConstant.StatsType.ERROR);
        return this;
    }

    public long ady() {
        return this.bTp;
    }

    public a mg(String str) {
        if (str == null) {
            str = "";
        }
        this.mDesc = str;
        return this;
    }

    public String adz() {
        return this.mDesc;
    }

    public a mh(String str) {
        this.mDetails.append(str).append("\n");
        return this;
    }

    public StringBuilder adA() {
        return this.mDetails;
    }

    public long adB() {
        return (adw() * 10000000) + (adx() * 10000) + (ady() * 1);
    }

    public a aD(long j) {
        aA(j / 10000000);
        long j2 = j % 10000000;
        aB(j2 / 10000);
        aC((j2 % 10000) / 1);
        return this;
    }

    public boolean adC() {
        return this.bTr;
    }

    public void adD() {
        this.bTr = true;
    }

    private long a(long j, long j2, String str) {
        boolean z = j < 0 || j > j2;
        if (z) {
            mh("illegalFallback " + str + "::" + String.valueOf(j));
        }
        return z ? j2 : j;
    }
}
