package com.baidu.swan.apps.ap;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
import java.util.Locale;
/* loaded from: classes11.dex */
public final class a {
    private a bXD = null;
    private long bXE = 0;
    private long bXF = 0;
    private long bXG = 2;
    private String mDesc = "";
    private final StringBuilder mDetails = new StringBuilder();
    private boolean bXH = false;

    public String toString(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(Locale.getDefault(), "%s :: code(%08d) desc(%s) \n", super.toString(), Long.valueOf(agi()), Long.valueOf(agd()), Long.valueOf(age()), Long.valueOf(agf()), agg()));
        if (i >= -200) {
            sb.append(String.format(Locale.getDefault(), "  p(%01d) f(%03d) e(%04d) \n", Long.valueOf(agd()), Long.valueOf(age()), Long.valueOf(agf())));
        }
        if (i >= -100) {
            sb.append(String.format(Locale.getDefault(), "  details(%s) \n", agh()));
        }
        return sb.toString();
    }

    public String toString() {
        return toString(-100);
    }

    public a aH(long j) {
        this.bXG = a(j, 9L, "platform");
        return this;
    }

    public long agd() {
        return this.bXG;
    }

    public a aI(long j) {
        this.bXE = a(j, 999L, "feature");
        return this;
    }

    public long age() {
        return this.bXE;
    }

    public a aJ(long j) {
        this.bXF = a(j, 9999L, BdStatsConstant.StatsType.ERROR);
        return this;
    }

    public long agf() {
        return this.bXF;
    }

    public a my(String str) {
        if (str == null) {
            str = "";
        }
        this.mDesc = str;
        return this;
    }

    public String agg() {
        return this.mDesc;
    }

    public a mz(String str) {
        this.mDetails.append(str).append("\n");
        return this;
    }

    public StringBuilder agh() {
        return this.mDetails;
    }

    public long agi() {
        return (agd() * 10000000) + (age() * 10000) + (agf() * 1);
    }

    public a aK(long j) {
        aH(j / 10000000);
        long j2 = j % 10000000;
        aI(j2 / 10000);
        aJ((j2 % 10000) / 1);
        return this;
    }

    public boolean agj() {
        return this.bXH;
    }

    public void agk() {
        this.bXH = true;
    }

    private long a(long j, long j2, String str) {
        boolean z = j < 0 || j > j2;
        if (z) {
            mz("illegalFallback " + str + "::" + String.valueOf(j));
        }
        return z ? j2 : j;
    }
}
