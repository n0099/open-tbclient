package com.baidu.swan.apps.al;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
import java.util.Locale;
/* loaded from: classes8.dex */
public final class a {
    private a dPs = null;
    private long dPt = 0;
    private long dPu = 0;
    private long dPv = 2;
    private String mDesc = "";
    private String dPw = "";
    private final StringBuilder mDetails = new StringBuilder();
    private boolean dPx = false;

    public String toString(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(Locale.getDefault(), "%s :: code(%08d) desc(%s) \n", super.toString(), Long.valueOf(aNi()), Long.valueOf(aNc()), Long.valueOf(aNd()), Long.valueOf(aNe()), aNf()));
        if (i >= -200) {
            sb.append(String.format(Locale.getDefault(), "  p(%01d) f(%03d) e(%04d) \n", Long.valueOf(aNc()), Long.valueOf(aNd()), Long.valueOf(aNe())));
        }
        if (i >= -100) {
            sb.append(String.format(Locale.getDefault(), "  details(%s) \n", aNh()));
        }
        return sb.toString();
    }

    public String toString() {
        return toString(-100);
    }

    public a da(long j) {
        this.dPv = b(j, 9L, "platform");
        return this;
    }

    public long aNc() {
        return this.dPv;
    }

    public a db(long j) {
        this.dPt = b(j, 999L, "feature");
        return this;
    }

    public long aNd() {
        return this.dPt;
    }

    public a dc(long j) {
        this.dPu = b(j, 9999L, BdStatsConstant.StatsType.ERROR);
        return this;
    }

    public long aNe() {
        return this.dPu;
    }

    public a tM(String str) {
        if (str == null) {
            str = "";
        }
        this.mDesc = str;
        return this;
    }

    public String aNf() {
        return this.mDesc;
    }

    public a tN(String str) {
        if (str == null) {
            str = "";
        }
        this.dPw = str;
        return this;
    }

    public String aNg() {
        return this.dPw;
    }

    public a tO(String str) {
        this.mDetails.append(str).append("\n");
        return this;
    }

    public StringBuilder aNh() {
        return this.mDetails;
    }

    public long aNi() {
        return (aNc() * 10000000) + (aNd() * 10000) + (aNe() * 1);
    }

    public a dd(long j) {
        da(j / 10000000);
        long j2 = j % 10000000;
        db(j2 / 10000);
        dc((j2 % 10000) / 1);
        return this;
    }

    public boolean aNj() {
        return this.dPx;
    }

    public void aNk() {
        this.dPx = true;
    }

    private long b(long j, long j2, String str) {
        boolean z = j < 0 || j > j2;
        if (z) {
            tO("illegalFallback " + str + "::" + j);
        }
        return z ? j2 : j;
    }
}
