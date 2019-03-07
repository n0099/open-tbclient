package com.baidu.swan.apps.ak;

import java.util.Locale;
/* loaded from: classes2.dex */
public final class a {
    private a aVA = null;
    private long aVB = 0;
    private long aVC = 0;
    private long aVD = 2;
    private String aVE = "";
    private final StringBuilder aVF = new StringBuilder();
    private boolean aVG = false;

    public String toString(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(Locale.getDefault(), "%s :: code(%08d) desc(%s) \n", super.toString(), Long.valueOf(LC()), Long.valueOf(Lx()), Long.valueOf(Ly()), Long.valueOf(Lz()), LA()));
        if (i >= -200) {
            sb.append(String.format(Locale.getDefault(), "  p(%01d) f(%03d) e(%04d) \n", Long.valueOf(Lx()), Long.valueOf(Ly()), Long.valueOf(Lz())));
        }
        if (i >= -100) {
            sb.append(String.format(Locale.getDefault(), "  details(%s) \n", LB()));
        }
        return sb.toString();
    }

    public String toString() {
        return toString(-100);
    }

    public a K(long j) {
        this.aVD = a(j, 9L, "platform");
        return this;
    }

    public long Lx() {
        return this.aVD;
    }

    public a L(long j) {
        this.aVB = a(j, 999L, "feature");
        return this;
    }

    public long Ly() {
        return this.aVB;
    }

    public a M(long j) {
        this.aVC = a(j, 9999L, "error");
        return this;
    }

    public long Lz() {
        return this.aVC;
    }

    public a hv(String str) {
        if (str == null) {
            str = "";
        }
        this.aVE = str;
        return this;
    }

    public String LA() {
        return this.aVE;
    }

    public a hw(String str) {
        this.aVF.append(str).append("\n");
        return this;
    }

    public StringBuilder LB() {
        return this.aVF;
    }

    public long LC() {
        return (Lx() * 10000000) + (Ly() * 10000) + (Lz() * 1);
    }

    public a N(long j) {
        K(j / 10000000);
        long j2 = j % 10000000;
        L(j2 / 10000);
        M((j2 % 10000) / 1);
        return this;
    }

    public boolean LD() {
        return this.aVG;
    }

    public void LE() {
        this.aVG = true;
    }

    private long a(long j, long j2, String str) {
        boolean z = j < 0 || j > j2;
        if (z) {
            hw("illegalFallback " + str + "::" + String.valueOf(j));
        }
        return z ? j2 : j;
    }
}
