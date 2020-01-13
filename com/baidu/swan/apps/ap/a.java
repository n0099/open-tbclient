package com.baidu.swan.apps.ap;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
import java.util.Locale;
/* loaded from: classes10.dex */
public final class a {
    private a bTz = null;
    private long bTA = 0;
    private long bTB = 0;
    private long bTC = 2;
    private String mDesc = "";
    private final StringBuilder mDetails = new StringBuilder();
    private boolean bTD = false;

    public String toString(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(Locale.getDefault(), "%s :: code(%08d) desc(%s) \n", super.toString(), Long.valueOf(adU()), Long.valueOf(adP()), Long.valueOf(adQ()), Long.valueOf(adR()), adS()));
        if (i >= -200) {
            sb.append(String.format(Locale.getDefault(), "  p(%01d) f(%03d) e(%04d) \n", Long.valueOf(adP()), Long.valueOf(adQ()), Long.valueOf(adR())));
        }
        if (i >= -100) {
            sb.append(String.format(Locale.getDefault(), "  details(%s) \n", adT()));
        }
        return sb.toString();
    }

    public String toString() {
        return toString(-100);
    }

    public a aD(long j) {
        this.bTC = a(j, 9L, "platform");
        return this;
    }

    public long adP() {
        return this.bTC;
    }

    public a aE(long j) {
        this.bTA = a(j, 999L, "feature");
        return this;
    }

    public long adQ() {
        return this.bTA;
    }

    public a aF(long j) {
        this.bTB = a(j, 9999L, BdStatsConstant.StatsType.ERROR);
        return this;
    }

    public long adR() {
        return this.bTB;
    }

    public a mj(String str) {
        if (str == null) {
            str = "";
        }
        this.mDesc = str;
        return this;
    }

    public String adS() {
        return this.mDesc;
    }

    public a mk(String str) {
        this.mDetails.append(str).append("\n");
        return this;
    }

    public StringBuilder adT() {
        return this.mDetails;
    }

    public long adU() {
        return (adP() * 10000000) + (adQ() * 10000) + (adR() * 1);
    }

    public a aG(long j) {
        aD(j / 10000000);
        long j2 = j % 10000000;
        aE(j2 / 10000);
        aF((j2 % 10000) / 1);
        return this;
    }

    public boolean adV() {
        return this.bTD;
    }

    public void adW() {
        this.bTD = true;
    }

    private long a(long j, long j2, String str) {
        boolean z = j < 0 || j > j2;
        if (z) {
            mk("illegalFallback " + str + "::" + String.valueOf(j));
        }
        return z ? j2 : j;
    }
}
