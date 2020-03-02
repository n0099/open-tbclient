package com.baidu.swan.apps.ap;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
import java.util.Locale;
/* loaded from: classes11.dex */
public final class a {
    private a bXE = null;
    private long bXF = 0;
    private long bXG = 0;
    private long bXH = 2;
    private String mDesc = "";
    private final StringBuilder mDetails = new StringBuilder();
    private boolean bXI = false;

    public String toString(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(Locale.getDefault(), "%s :: code(%08d) desc(%s) \n", super.toString(), Long.valueOf(agk()), Long.valueOf(agf()), Long.valueOf(agg()), Long.valueOf(agh()), agi()));
        if (i >= -200) {
            sb.append(String.format(Locale.getDefault(), "  p(%01d) f(%03d) e(%04d) \n", Long.valueOf(agf()), Long.valueOf(agg()), Long.valueOf(agh())));
        }
        if (i >= -100) {
            sb.append(String.format(Locale.getDefault(), "  details(%s) \n", agj()));
        }
        return sb.toString();
    }

    public String toString() {
        return toString(-100);
    }

    public a aH(long j) {
        this.bXH = a(j, 9L, "platform");
        return this;
    }

    public long agf() {
        return this.bXH;
    }

    public a aI(long j) {
        this.bXF = a(j, 999L, "feature");
        return this;
    }

    public long agg() {
        return this.bXF;
    }

    public a aJ(long j) {
        this.bXG = a(j, 9999L, BdStatsConstant.StatsType.ERROR);
        return this;
    }

    public long agh() {
        return this.bXG;
    }

    public a my(String str) {
        if (str == null) {
            str = "";
        }
        this.mDesc = str;
        return this;
    }

    public String agi() {
        return this.mDesc;
    }

    public a mz(String str) {
        this.mDetails.append(str).append("\n");
        return this;
    }

    public StringBuilder agj() {
        return this.mDetails;
    }

    public long agk() {
        return (agf() * 10000000) + (agg() * 10000) + (agh() * 1);
    }

    public a aK(long j) {
        aH(j / 10000000);
        long j2 = j % 10000000;
        aI(j2 / 10000);
        aJ((j2 % 10000) / 1);
        return this;
    }

    public boolean agl() {
        return this.bXI;
    }

    public void agm() {
        this.bXI = true;
    }

    private long a(long j, long j2, String str) {
        boolean z = j < 0 || j > j2;
        if (z) {
            mz("illegalFallback " + str + "::" + String.valueOf(j));
        }
        return z ? j2 : j;
    }
}
