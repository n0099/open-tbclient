package com.baidu.swan.apps.am;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
import java.util.Locale;
/* loaded from: classes10.dex */
public final class a {
    private a dol = null;
    private long dom = 0;
    private long don = 0;
    private long doo = 2;
    private String mDesc = "";
    private String dop = "";
    private final StringBuilder mDetails = new StringBuilder();
    private boolean doq = false;

    public String toString(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(Locale.getDefault(), "%s :: code(%08d) desc(%s) \n", super.toString(), Long.valueOf(aHv()), Long.valueOf(aHp()), Long.valueOf(aHq()), Long.valueOf(aHr()), aHs()));
        if (i >= -200) {
            sb.append(String.format(Locale.getDefault(), "  p(%01d) f(%03d) e(%04d) \n", Long.valueOf(aHp()), Long.valueOf(aHq()), Long.valueOf(aHr())));
        }
        if (i >= -100) {
            sb.append(String.format(Locale.getDefault(), "  details(%s) \n", aHu()));
        }
        return sb.toString();
    }

    public String toString() {
        return toString(-100);
    }

    public a bW(long j) {
        this.doo = a(j, 9L, "platform");
        return this;
    }

    public long aHp() {
        return this.doo;
    }

    public a bX(long j) {
        this.dom = a(j, 999L, "feature");
        return this;
    }

    public long aHq() {
        return this.dom;
    }

    public a bY(long j) {
        this.don = a(j, 9999L, BdStatsConstant.StatsType.ERROR);
        return this;
    }

    public long aHr() {
        return this.don;
    }

    public a tr(String str) {
        if (str == null) {
            str = "";
        }
        this.mDesc = str;
        return this;
    }

    public String aHs() {
        return this.mDesc;
    }

    public a ts(String str) {
        if (str == null) {
            str = "";
        }
        this.dop = str;
        return this;
    }

    public String aHt() {
        return this.dop;
    }

    public a tt(String str) {
        this.mDetails.append(str).append("\n");
        return this;
    }

    public StringBuilder aHu() {
        return this.mDetails;
    }

    public long aHv() {
        return (aHp() * 10000000) + (aHq() * 10000) + (aHr() * 1);
    }

    public a bZ(long j) {
        bW(j / 10000000);
        long j2 = j % 10000000;
        bX(j2 / 10000);
        bY((j2 % 10000) / 1);
        return this;
    }

    public boolean aHw() {
        return this.doq;
    }

    public void aHx() {
        this.doq = true;
    }

    private long a(long j, long j2, String str) {
        boolean z = j < 0 || j > j2;
        if (z) {
            tt("illegalFallback " + str + "::" + j);
        }
        return z ? j2 : j;
    }
}
