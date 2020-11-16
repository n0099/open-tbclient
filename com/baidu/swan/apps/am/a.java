package com.baidu.swan.apps.am;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
import java.util.Locale;
/* loaded from: classes7.dex */
public final class a {
    private a dAW = null;
    private long dAX = 0;
    private long dAY = 0;
    private long dAZ = 2;
    private String mDesc = "";
    private String dBa = "";
    private final StringBuilder mDetails = new StringBuilder();
    private boolean dBb = false;

    public String toString(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(Locale.getDefault(), "%s :: code(%08d) desc(%s) \n", super.toString(), Long.valueOf(aLh()), Long.valueOf(aLb()), Long.valueOf(aLc()), Long.valueOf(aLd()), aLe()));
        if (i >= -200) {
            sb.append(String.format(Locale.getDefault(), "  p(%01d) f(%03d) e(%04d) \n", Long.valueOf(aLb()), Long.valueOf(aLc()), Long.valueOf(aLd())));
        }
        if (i >= -100) {
            sb.append(String.format(Locale.getDefault(), "  details(%s) \n", aLg()));
        }
        return sb.toString();
    }

    public String toString() {
        return toString(-100);
    }

    public a cu(long j) {
        this.dAZ = a(j, 9L, "platform");
        return this;
    }

    public long aLb() {
        return this.dAZ;
    }

    public a cv(long j) {
        this.dAX = a(j, 999L, "feature");
        return this;
    }

    public long aLc() {
        return this.dAX;
    }

    public a cw(long j) {
        this.dAY = a(j, 9999L, BdStatsConstant.StatsType.ERROR);
        return this;
    }

    public long aLd() {
        return this.dAY;
    }

    public a tT(String str) {
        if (str == null) {
            str = "";
        }
        this.mDesc = str;
        return this;
    }

    public String aLe() {
        return this.mDesc;
    }

    public a tU(String str) {
        if (str == null) {
            str = "";
        }
        this.dBa = str;
        return this;
    }

    public String aLf() {
        return this.dBa;
    }

    public a tV(String str) {
        this.mDetails.append(str).append("\n");
        return this;
    }

    public StringBuilder aLg() {
        return this.mDetails;
    }

    public long aLh() {
        return (aLb() * 10000000) + (aLc() * 10000) + (aLd() * 1);
    }

    public a cx(long j) {
        cu(j / 10000000);
        long j2 = j % 10000000;
        cv(j2 / 10000);
        cw((j2 % 10000) / 1);
        return this;
    }

    public boolean aLi() {
        return this.dBb;
    }

    public void aLj() {
        this.dBb = true;
    }

    private long a(long j, long j2, String str) {
        boolean z = j < 0 || j > j2;
        if (z) {
            tV("illegalFallback " + str + "::" + j);
        }
        return z ? j2 : j;
    }
}
