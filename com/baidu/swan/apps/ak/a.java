package com.baidu.swan.apps.ak;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
import java.util.Locale;
/* loaded from: classes2.dex */
public final class a {
    private a bsN = null;
    private long bsO = 0;
    private long bsP = 0;
    private long bsQ = 2;
    private String mDesc = "";
    private final StringBuilder bsR = new StringBuilder();
    private boolean bsS = false;

    public String toString(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(Locale.getDefault(), "%s :: code(%08d) desc(%s) \n", super.toString(), Long.valueOf(TP()), Long.valueOf(TK()), Long.valueOf(TL()), Long.valueOf(TM()), TN()));
        if (i >= -200) {
            sb.append(String.format(Locale.getDefault(), "  p(%01d) f(%03d) e(%04d) \n", Long.valueOf(TK()), Long.valueOf(TL()), Long.valueOf(TM())));
        }
        if (i >= -100) {
            sb.append(String.format(Locale.getDefault(), "  details(%s) \n", TO()));
        }
        return sb.toString();
    }

    public String toString() {
        return toString(-100);
    }

    public a ar(long j) {
        this.bsQ = a(j, 9L, "platform");
        return this;
    }

    public long TK() {
        return this.bsQ;
    }

    public a as(long j) {
        this.bsO = a(j, 999L, "feature");
        return this;
    }

    public long TL() {
        return this.bsO;
    }

    public a at(long j) {
        this.bsP = a(j, 9999L, BdStatsConstant.StatsType.ERROR);
        return this;
    }

    public long TM() {
        return this.bsP;
    }

    public a iK(String str) {
        if (str == null) {
            str = "";
        }
        this.mDesc = str;
        return this;
    }

    public String TN() {
        return this.mDesc;
    }

    public a iL(String str) {
        this.bsR.append(str).append("\n");
        return this;
    }

    public StringBuilder TO() {
        return this.bsR;
    }

    public long TP() {
        return (TK() * 10000000) + (TL() * 10000) + (TM() * 1);
    }

    public a au(long j) {
        ar(j / 10000000);
        long j2 = j % 10000000;
        as(j2 / 10000);
        at((j2 % 10000) / 1);
        return this;
    }

    public boolean TQ() {
        return this.bsS;
    }

    public void TR() {
        this.bsS = true;
    }

    private long a(long j, long j2, String str) {
        boolean z = j < 0 || j > j2;
        if (z) {
            iL("illegalFallback " + str + "::" + String.valueOf(j));
        }
        return z ? j2 : j;
    }
}
