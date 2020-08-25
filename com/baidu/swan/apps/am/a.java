package com.baidu.swan.apps.am;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
import java.util.Locale;
/* loaded from: classes8.dex */
public final class a {
    private a cZV = null;
    private long cZW = 0;
    private long cZX = 0;
    private long cZY = 2;
    private String mDesc = "";
    private String cZZ = "";
    private final StringBuilder mDetails = new StringBuilder();
    private boolean daa = false;

    public String toString(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(Locale.getDefault(), "%s :: code(%08d) desc(%s) \n", super.toString(), Long.valueOf(aEc()), Long.valueOf(aDW()), Long.valueOf(aDX()), Long.valueOf(aDY()), aDZ()));
        if (i >= -200) {
            sb.append(String.format(Locale.getDefault(), "  p(%01d) f(%03d) e(%04d) \n", Long.valueOf(aDW()), Long.valueOf(aDX()), Long.valueOf(aDY())));
        }
        if (i >= -100) {
            sb.append(String.format(Locale.getDefault(), "  details(%s) \n", aEb()));
        }
        return sb.toString();
    }

    public String toString() {
        return toString(-100);
    }

    public a bN(long j) {
        this.cZY = a(j, 9L, "platform");
        return this;
    }

    public long aDW() {
        return this.cZY;
    }

    public a bO(long j) {
        this.cZW = a(j, 999L, "feature");
        return this;
    }

    public long aDX() {
        return this.cZW;
    }

    public a bP(long j) {
        this.cZX = a(j, 9999L, BdStatsConstant.StatsType.ERROR);
        return this;
    }

    public long aDY() {
        return this.cZX;
    }

    public a sk(String str) {
        if (str == null) {
            str = "";
        }
        this.mDesc = str;
        return this;
    }

    public String aDZ() {
        return this.mDesc;
    }

    public a sl(String str) {
        if (str == null) {
            str = "";
        }
        this.cZZ = str;
        return this;
    }

    public String aEa() {
        return this.cZZ;
    }

    public a sm(String str) {
        this.mDetails.append(str).append("\n");
        return this;
    }

    public StringBuilder aEb() {
        return this.mDetails;
    }

    public long aEc() {
        return (aDW() * 10000000) + (aDX() * 10000) + (aDY() * 1);
    }

    public a bQ(long j) {
        bN(j / 10000000);
        long j2 = j % 10000000;
        bO(j2 / 10000);
        bP((j2 % 10000) / 1);
        return this;
    }

    public boolean aEd() {
        return this.daa;
    }

    public void aEe() {
        this.daa = true;
    }

    private long a(long j, long j2, String str) {
        boolean z = j < 0 || j > j2;
        if (z) {
            sm("illegalFallback " + str + "::" + j);
        }
        return z ? j2 : j;
    }
}
