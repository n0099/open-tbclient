package com.baidu.swan.apps.ak;

import java.util.Locale;
/* loaded from: classes2.dex */
public final class a {
    private a aZN = null;
    private long aZO = 0;
    private long aZP = 0;
    private long aZQ = 2;
    private String aZR = "";
    private final StringBuilder aZS = new StringBuilder();
    private boolean aZT = false;

    public String toString(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(Locale.getDefault(), "%s :: code(%08d) desc(%s) \n", super.toString(), Long.valueOf(OZ()), Long.valueOf(OU()), Long.valueOf(OV()), Long.valueOf(OW()), OX()));
        if (i >= -200) {
            sb.append(String.format(Locale.getDefault(), "  p(%01d) f(%03d) e(%04d) \n", Long.valueOf(OU()), Long.valueOf(OV()), Long.valueOf(OW())));
        }
        if (i >= -100) {
            sb.append(String.format(Locale.getDefault(), "  details(%s) \n", OY()));
        }
        return sb.toString();
    }

    public String toString() {
        return toString(-100);
    }

    public a Y(long j) {
        this.aZQ = a(j, 9L, "platform");
        return this;
    }

    public long OU() {
        return this.aZQ;
    }

    public a Z(long j) {
        this.aZO = a(j, 999L, "feature");
        return this;
    }

    public long OV() {
        return this.aZO;
    }

    public a aa(long j) {
        this.aZP = a(j, 9999L, "error");
        return this;
    }

    public long OW() {
        return this.aZP;
    }

    public a ih(String str) {
        if (str == null) {
            str = "";
        }
        this.aZR = str;
        return this;
    }

    public String OX() {
        return this.aZR;
    }

    public a ii(String str) {
        this.aZS.append(str).append("\n");
        return this;
    }

    public StringBuilder OY() {
        return this.aZS;
    }

    public long OZ() {
        return (OU() * 10000000) + (OV() * 10000) + (OW() * 1);
    }

    public a ab(long j) {
        Y(j / 10000000);
        long j2 = j % 10000000;
        Z(j2 / 10000);
        aa((j2 % 10000) / 1);
        return this;
    }

    public boolean Pa() {
        return this.aZT;
    }

    public void Pb() {
        this.aZT = true;
    }

    private long a(long j, long j2, String str) {
        boolean z = j < 0 || j > j2;
        if (z) {
            ii("illegalFallback " + str + "::" + String.valueOf(j));
        }
        return z ? j2 : j;
    }
}
