package com.baidu.swan.apps.ap;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
import java.util.Locale;
/* loaded from: classes11.dex */
public final class a {
    private a bXQ = null;
    private long bXR = 0;
    private long bXS = 0;
    private long bXT = 2;
    private String mDesc = "";
    private final StringBuilder mDetails = new StringBuilder();
    private boolean bXU = false;

    public String toString(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(Locale.getDefault(), "%s :: code(%08d) desc(%s) \n", super.toString(), Long.valueOf(agn()), Long.valueOf(agi()), Long.valueOf(agj()), Long.valueOf(agk()), agl()));
        if (i >= -200) {
            sb.append(String.format(Locale.getDefault(), "  p(%01d) f(%03d) e(%04d) \n", Long.valueOf(agi()), Long.valueOf(agj()), Long.valueOf(agk())));
        }
        if (i >= -100) {
            sb.append(String.format(Locale.getDefault(), "  details(%s) \n", agm()));
        }
        return sb.toString();
    }

    public String toString() {
        return toString(-100);
    }

    public a aH(long j) {
        this.bXT = a(j, 9L, "platform");
        return this;
    }

    public long agi() {
        return this.bXT;
    }

    public a aI(long j) {
        this.bXR = a(j, 999L, "feature");
        return this;
    }

    public long agj() {
        return this.bXR;
    }

    public a aJ(long j) {
        this.bXS = a(j, 9999L, BdStatsConstant.StatsType.ERROR);
        return this;
    }

    public long agk() {
        return this.bXS;
    }

    public a mx(String str) {
        if (str == null) {
            str = "";
        }
        this.mDesc = str;
        return this;
    }

    public String agl() {
        return this.mDesc;
    }

    public a my(String str) {
        this.mDetails.append(str).append("\n");
        return this;
    }

    public StringBuilder agm() {
        return this.mDetails;
    }

    public long agn() {
        return (agi() * 10000000) + (agj() * 10000) + (agk() * 1);
    }

    public a aK(long j) {
        aH(j / 10000000);
        long j2 = j % 10000000;
        aI(j2 / 10000);
        aJ((j2 % 10000) / 1);
        return this;
    }

    public boolean ago() {
        return this.bXU;
    }

    public void agp() {
        this.bXU = true;
    }

    private long a(long j, long j2, String str) {
        boolean z = j < 0 || j > j2;
        if (z) {
            my("illegalFallback " + str + "::" + String.valueOf(j));
        }
        return z ? j2 : j;
    }
}
