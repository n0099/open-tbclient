package com.baidu.swan.apps.ak;

import java.util.Locale;
/* loaded from: classes2.dex */
public final class a {
    private a aVF = null;
    private long aVG = 0;
    private long aVH = 0;
    private long aVI = 2;
    private String aVJ = "";
    private final StringBuilder aVK = new StringBuilder();
    private boolean aVL = false;

    public String toString(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(Locale.getDefault(), "%s :: code(%08d) desc(%s) \n", super.toString(), Long.valueOf(LA()), Long.valueOf(Lv()), Long.valueOf(Lw()), Long.valueOf(Lx()), Ly()));
        if (i >= -200) {
            sb.append(String.format(Locale.getDefault(), "  p(%01d) f(%03d) e(%04d) \n", Long.valueOf(Lv()), Long.valueOf(Lw()), Long.valueOf(Lx())));
        }
        if (i >= -100) {
            sb.append(String.format(Locale.getDefault(), "  details(%s) \n", Lz()));
        }
        return sb.toString();
    }

    public String toString() {
        return toString(-100);
    }

    public a K(long j) {
        this.aVI = a(j, 9L, "platform");
        return this;
    }

    public long Lv() {
        return this.aVI;
    }

    public a L(long j) {
        this.aVG = a(j, 999L, "feature");
        return this;
    }

    public long Lw() {
        return this.aVG;
    }

    public a M(long j) {
        this.aVH = a(j, 9999L, "error");
        return this;
    }

    public long Lx() {
        return this.aVH;
    }

    public a hw(String str) {
        if (str == null) {
            str = "";
        }
        this.aVJ = str;
        return this;
    }

    public String Ly() {
        return this.aVJ;
    }

    public a hx(String str) {
        this.aVK.append(str).append("\n");
        return this;
    }

    public StringBuilder Lz() {
        return this.aVK;
    }

    public long LA() {
        return (Lv() * 10000000) + (Lw() * 10000) + (Lx() * 1);
    }

    public a N(long j) {
        K(j / 10000000);
        long j2 = j % 10000000;
        L(j2 / 10000);
        M((j2 % 10000) / 1);
        return this;
    }

    public boolean LB() {
        return this.aVL;
    }

    public void LC() {
        this.aVL = true;
    }

    private long a(long j, long j2, String str) {
        boolean z = j < 0 || j > j2;
        if (z) {
            hx("illegalFallback " + str + "::" + String.valueOf(j));
        }
        return z ? j2 : j;
    }
}
