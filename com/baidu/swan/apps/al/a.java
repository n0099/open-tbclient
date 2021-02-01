package com.baidu.swan.apps.al;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
import java.util.Locale;
/* loaded from: classes9.dex */
public final class a {
    private a dNR = null;
    private long dNS = 0;
    private long dNT = 0;
    private long dNU = 2;
    private String mDesc = "";
    private String dNV = "";
    private final StringBuilder mDetails = new StringBuilder();
    private boolean dNW = false;

    public String toString(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(Locale.getDefault(), "%s :: code(%08d) desc(%s) \n", super.toString(), Long.valueOf(aNf()), Long.valueOf(aMZ()), Long.valueOf(aNa()), Long.valueOf(aNb()), aNc()));
        if (i >= -200) {
            sb.append(String.format(Locale.getDefault(), "  p(%01d) f(%03d) e(%04d) \n", Long.valueOf(aMZ()), Long.valueOf(aNa()), Long.valueOf(aNb())));
        }
        if (i >= -100) {
            sb.append(String.format(Locale.getDefault(), "  details(%s) \n", aNe()));
        }
        return sb.toString();
    }

    public String toString() {
        return toString(-100);
    }

    public a da(long j) {
        this.dNU = b(j, 9L, "platform");
        return this;
    }

    public long aMZ() {
        return this.dNU;
    }

    public a db(long j) {
        this.dNS = b(j, 999L, "feature");
        return this;
    }

    public long aNa() {
        return this.dNS;
    }

    public a dc(long j) {
        this.dNT = b(j, 9999L, BdStatsConstant.StatsType.ERROR);
        return this;
    }

    public long aNb() {
        return this.dNT;
    }

    public a tF(String str) {
        if (str == null) {
            str = "";
        }
        this.mDesc = str;
        return this;
    }

    public String aNc() {
        return this.mDesc;
    }

    public a tG(String str) {
        if (str == null) {
            str = "";
        }
        this.dNV = str;
        return this;
    }

    public String aNd() {
        return this.dNV;
    }

    public a tH(String str) {
        this.mDetails.append(str).append("\n");
        return this;
    }

    public StringBuilder aNe() {
        return this.mDetails;
    }

    public long aNf() {
        return (aMZ() * 10000000) + (aNa() * 10000) + (aNb() * 1);
    }

    public a dd(long j) {
        da(j / 10000000);
        long j2 = j % 10000000;
        db(j2 / 10000);
        dc((j2 % 10000) / 1);
        return this;
    }

    public boolean aNg() {
        return this.dNW;
    }

    public void aNh() {
        this.dNW = true;
    }

    private long b(long j, long j2, String str) {
        boolean z = j < 0 || j > j2;
        if (z) {
            tH("illegalFallback " + str + "::" + j);
        }
        return z ? j2 : j;
    }
}
