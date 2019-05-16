package com.baidu.swan.apps.ak;

import java.util.Locale;
/* loaded from: classes2.dex */
public final class a {
    private a aYF = null;
    private long aYG = 0;
    private long aYH = 0;
    private long aYI = 2;
    private String aYJ = "";
    private final StringBuilder aYK = new StringBuilder();
    private boolean aYL = false;

    public String toString(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(Locale.getDefault(), "%s :: code(%08d) desc(%s) \n", super.toString(), Long.valueOf(Og()), Long.valueOf(Ob()), Long.valueOf(Oc()), Long.valueOf(Od()), Oe()));
        if (i >= -200) {
            sb.append(String.format(Locale.getDefault(), "  p(%01d) f(%03d) e(%04d) \n", Long.valueOf(Ob()), Long.valueOf(Oc()), Long.valueOf(Od())));
        }
        if (i >= -100) {
            sb.append(String.format(Locale.getDefault(), "  details(%s) \n", Of()));
        }
        return sb.toString();
    }

    public String toString() {
        return toString(-100);
    }

    public a X(long j) {
        this.aYI = a(j, 9L, "platform");
        return this;
    }

    public long Ob() {
        return this.aYI;
    }

    public a Y(long j) {
        this.aYG = a(j, 999L, "feature");
        return this;
    }

    public long Oc() {
        return this.aYG;
    }

    public a Z(long j) {
        this.aYH = a(j, 9999L, "error");
        return this;
    }

    public long Od() {
        return this.aYH;
    }

    public a hY(String str) {
        if (str == null) {
            str = "";
        }
        this.aYJ = str;
        return this;
    }

    public String Oe() {
        return this.aYJ;
    }

    public a hZ(String str) {
        this.aYK.append(str).append("\n");
        return this;
    }

    public StringBuilder Of() {
        return this.aYK;
    }

    public long Og() {
        return (Ob() * 10000000) + (Oc() * 10000) + (Od() * 1);
    }

    public a aa(long j) {
        X(j / 10000000);
        long j2 = j % 10000000;
        Y(j2 / 10000);
        Z((j2 % 10000) / 1);
        return this;
    }

    public boolean Oh() {
        return this.aYL;
    }

    public void Oi() {
        this.aYL = true;
    }

    private long a(long j, long j2, String str) {
        boolean z = j < 0 || j > j2;
        if (z) {
            hZ("illegalFallback " + str + "::" + String.valueOf(j));
        }
        return z ? j2 : j;
    }
}
