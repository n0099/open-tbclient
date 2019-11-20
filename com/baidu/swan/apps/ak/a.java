package com.baidu.swan.apps.ak;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
import java.util.Locale;
/* loaded from: classes2.dex */
public final class a {
    private a brW = null;
    private long brX = 0;
    private long brY = 0;
    private long brZ = 2;
    private String mDesc = "";
    private final StringBuilder bsa = new StringBuilder();
    private boolean bsb = false;

    public String toString(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(Locale.getDefault(), "%s :: code(%08d) desc(%s) \n", super.toString(), Long.valueOf(TN()), Long.valueOf(TI()), Long.valueOf(TJ()), Long.valueOf(TK()), TL()));
        if (i >= -200) {
            sb.append(String.format(Locale.getDefault(), "  p(%01d) f(%03d) e(%04d) \n", Long.valueOf(TI()), Long.valueOf(TJ()), Long.valueOf(TK())));
        }
        if (i >= -100) {
            sb.append(String.format(Locale.getDefault(), "  details(%s) \n", TM()));
        }
        return sb.toString();
    }

    public String toString() {
        return toString(-100);
    }

    public a aq(long j) {
        this.brZ = a(j, 9L, "platform");
        return this;
    }

    public long TI() {
        return this.brZ;
    }

    public a ar(long j) {
        this.brX = a(j, 999L, "feature");
        return this;
    }

    public long TJ() {
        return this.brX;
    }

    public a as(long j) {
        this.brY = a(j, 9999L, BdStatsConstant.StatsType.ERROR);
        return this;
    }

    public long TK() {
        return this.brY;
    }

    public a iK(String str) {
        if (str == null) {
            str = "";
        }
        this.mDesc = str;
        return this;
    }

    public String TL() {
        return this.mDesc;
    }

    public a iL(String str) {
        this.bsa.append(str).append("\n");
        return this;
    }

    public StringBuilder TM() {
        return this.bsa;
    }

    public long TN() {
        return (TI() * 10000000) + (TJ() * 10000) + (TK() * 1);
    }

    public a at(long j) {
        aq(j / 10000000);
        long j2 = j % 10000000;
        ar(j2 / 10000);
        as((j2 % 10000) / 1);
        return this;
    }

    public boolean TO() {
        return this.bsb;
    }

    public void TP() {
        this.bsb = true;
    }

    private long a(long j, long j2, String str) {
        boolean z = j < 0 || j > j2;
        if (z) {
            iL("illegalFallback " + str + "::" + String.valueOf(j));
        }
        return z ? j2 : j;
    }
}
