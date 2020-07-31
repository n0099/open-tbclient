package com.baidu.swan.apps.an;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
import java.util.Locale;
/* loaded from: classes7.dex */
public final class a {
    private a cQV = null;
    private long cQW = 0;
    private long cQX = 0;
    private long cQY = 2;
    private String mDesc = "";
    private String cQZ = "";
    private final StringBuilder mDetails = new StringBuilder();
    private boolean cRa = false;

    public String toString(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(Locale.getDefault(), "%s :: code(%08d) desc(%s) \n", super.toString(), Long.valueOf(avT()), Long.valueOf(avN()), Long.valueOf(avO()), Long.valueOf(avP()), avQ()));
        if (i >= -200) {
            sb.append(String.format(Locale.getDefault(), "  p(%01d) f(%03d) e(%04d) \n", Long.valueOf(avN()), Long.valueOf(avO()), Long.valueOf(avP())));
        }
        if (i >= -100) {
            sb.append(String.format(Locale.getDefault(), "  details(%s) \n", avS()));
        }
        return sb.toString();
    }

    public String toString() {
        return toString(-100);
    }

    public a bI(long j) {
        this.cQY = a(j, 9L, "platform");
        return this;
    }

    public long avN() {
        return this.cQY;
    }

    public a bJ(long j) {
        this.cQW = a(j, 999L, "feature");
        return this;
    }

    public long avO() {
        return this.cQW;
    }

    public a bK(long j) {
        this.cQX = a(j, 9999L, BdStatsConstant.StatsType.ERROR);
        return this;
    }

    public long avP() {
        return this.cQX;
    }

    public a qk(String str) {
        if (str == null) {
            str = "";
        }
        this.mDesc = str;
        return this;
    }

    public String avQ() {
        return this.mDesc;
    }

    public a ql(String str) {
        if (str == null) {
            str = "";
        }
        this.cQZ = str;
        return this;
    }

    public String avR() {
        return this.cQZ;
    }

    public a qm(String str) {
        this.mDetails.append(str).append("\n");
        return this;
    }

    public StringBuilder avS() {
        return this.mDetails;
    }

    public long avT() {
        return (avN() * 10000000) + (avO() * 10000) + (avP() * 1);
    }

    public a bL(long j) {
        bI(j / 10000000);
        long j2 = j % 10000000;
        bJ(j2 / 10000);
        bK((j2 % 10000) / 1);
        return this;
    }

    public boolean avU() {
        return this.cRa;
    }

    public void avV() {
        this.cRa = true;
    }

    private long a(long j, long j2, String str) {
        boolean z = j < 0 || j > j2;
        if (z) {
            qm("illegalFallback " + str + "::" + j);
        }
        return z ? j2 : j;
    }
}
