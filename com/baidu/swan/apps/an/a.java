package com.baidu.swan.apps.an;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
import java.util.Locale;
/* loaded from: classes11.dex */
public final class a {
    private a cIQ = null;
    private long cIR = 0;
    private long cIS = 0;
    private long cIT = 2;
    private String mDesc = "";
    private String cIU = "";
    private final StringBuilder mDetails = new StringBuilder();
    private boolean cIV = false;

    public String toString(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(Locale.getDefault(), "%s :: code(%08d) desc(%s) \n", super.toString(), Long.valueOf(asM()), Long.valueOf(asG()), Long.valueOf(asH()), Long.valueOf(asI()), asJ()));
        if (i >= -200) {
            sb.append(String.format(Locale.getDefault(), "  p(%01d) f(%03d) e(%04d) \n", Long.valueOf(asG()), Long.valueOf(asH()), Long.valueOf(asI())));
        }
        if (i >= -100) {
            sb.append(String.format(Locale.getDefault(), "  details(%s) \n", asL()));
        }
        return sb.toString();
    }

    public String toString() {
        return toString(-100);
    }

    public a bv(long j) {
        this.cIT = a(j, 9L, "platform");
        return this;
    }

    public long asG() {
        return this.cIT;
    }

    public a bw(long j) {
        this.cIR = a(j, 999L, "feature");
        return this;
    }

    public long asH() {
        return this.cIR;
    }

    public a bx(long j) {
        this.cIS = a(j, 9999L, BdStatsConstant.StatsType.ERROR);
        return this;
    }

    public long asI() {
        return this.cIS;
    }

    public a pr(String str) {
        if (str == null) {
            str = "";
        }
        this.mDesc = str;
        return this;
    }

    public String asJ() {
        return this.mDesc;
    }

    public a ps(String str) {
        if (str == null) {
            str = "";
        }
        this.cIU = str;
        return this;
    }

    public String asK() {
        return this.cIU;
    }

    public a pt(String str) {
        this.mDetails.append(str).append("\n");
        return this;
    }

    public StringBuilder asL() {
        return this.mDetails;
    }

    public long asM() {
        return (asG() * 10000000) + (asH() * 10000) + (asI() * 1);
    }

    public a by(long j) {
        bv(j / 10000000);
        long j2 = j % 10000000;
        bw(j2 / 10000);
        bx((j2 % 10000) / 1);
        return this;
    }

    public boolean asN() {
        return this.cIV;
    }

    public void asO() {
        this.cIV = true;
    }

    private long a(long j, long j2, String str) {
        boolean z = j < 0 || j > j2;
        if (z) {
            pt("illegalFallback " + str + "::" + String.valueOf(j));
        }
        return z ? j2 : j;
    }
}
