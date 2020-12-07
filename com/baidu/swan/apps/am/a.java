package com.baidu.swan.apps.am;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
import java.util.Locale;
/* loaded from: classes25.dex */
public final class a {
    private a dHU = null;
    private long dHV = 0;
    private long dHW = 0;
    private long dHX = 2;
    private String mDesc = "";
    private String dHY = "";
    private final StringBuilder mDetails = new StringBuilder();
    private boolean dHZ = false;

    public String toString(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(Locale.getDefault(), "%s :: code(%08d) desc(%s) \n", super.toString(), Long.valueOf(aOo()), Long.valueOf(aOi()), Long.valueOf(aOj()), Long.valueOf(aOk()), aOl()));
        if (i >= -200) {
            sb.append(String.format(Locale.getDefault(), "  p(%01d) f(%03d) e(%04d) \n", Long.valueOf(aOi()), Long.valueOf(aOj()), Long.valueOf(aOk())));
        }
        if (i >= -100) {
            sb.append(String.format(Locale.getDefault(), "  details(%s) \n", aOn()));
        }
        return sb.toString();
    }

    public String toString() {
        return toString(-100);
    }

    public a cT(long j) {
        this.dHX = a(j, 9L, "platform");
        return this;
    }

    public long aOi() {
        return this.dHX;
    }

    public a cU(long j) {
        this.dHV = a(j, 999L, "feature");
        return this;
    }

    public long aOj() {
        return this.dHV;
    }

    public a cV(long j) {
        this.dHW = a(j, 9999L, BdStatsConstant.StatsType.ERROR);
        return this;
    }

    public long aOk() {
        return this.dHW;
    }

    public a uA(String str) {
        if (str == null) {
            str = "";
        }
        this.mDesc = str;
        return this;
    }

    public String aOl() {
        return this.mDesc;
    }

    public a uB(String str) {
        if (str == null) {
            str = "";
        }
        this.dHY = str;
        return this;
    }

    public String aOm() {
        return this.dHY;
    }

    public a uC(String str) {
        this.mDetails.append(str).append("\n");
        return this;
    }

    public StringBuilder aOn() {
        return this.mDetails;
    }

    public long aOo() {
        return (aOi() * 10000000) + (aOj() * 10000) + (aOk() * 1);
    }

    public a cW(long j) {
        cT(j / 10000000);
        long j2 = j % 10000000;
        cU(j2 / 10000);
        cV((j2 % 10000) / 1);
        return this;
    }

    public boolean aOp() {
        return this.dHZ;
    }

    public void aOq() {
        this.dHZ = true;
    }

    private long a(long j, long j2, String str) {
        boolean z = j < 0 || j > j2;
        if (z) {
            uC("illegalFallback " + str + "::" + j);
        }
        return z ? j2 : j;
    }
}
