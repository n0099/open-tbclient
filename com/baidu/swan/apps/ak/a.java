package com.baidu.swan.apps.ak;

import java.util.Locale;
/* loaded from: classes2.dex */
public final class a {
    private a aZp = null;
    private long aZq = 0;
    private long aZr = 0;
    private long aZs = 2;
    private String aZt = "";
    private final StringBuilder aZu = new StringBuilder();
    private boolean aZv = false;

    public String toString(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(Locale.getDefault(), "%s :: code(%08d) desc(%s) \n", super.toString(), Long.valueOf(OV()), Long.valueOf(OQ()), Long.valueOf(OR()), Long.valueOf(OS()), OT()));
        if (i >= -200) {
            sb.append(String.format(Locale.getDefault(), "  p(%01d) f(%03d) e(%04d) \n", Long.valueOf(OQ()), Long.valueOf(OR()), Long.valueOf(OS())));
        }
        if (i >= -100) {
            sb.append(String.format(Locale.getDefault(), "  details(%s) \n", OU()));
        }
        return sb.toString();
    }

    public String toString() {
        return toString(-100);
    }

    public a Y(long j) {
        this.aZs = a(j, 9L, "platform");
        return this;
    }

    public long OQ() {
        return this.aZs;
    }

    public a Z(long j) {
        this.aZq = a(j, 999L, "feature");
        return this;
    }

    public long OR() {
        return this.aZq;
    }

    public a aa(long j) {
        this.aZr = a(j, 9999L, "error");
        return this;
    }

    public long OS() {
        return this.aZr;
    }

    /* renamed from: if  reason: not valid java name */
    public a m14if(String str) {
        if (str == null) {
            str = "";
        }
        this.aZt = str;
        return this;
    }

    public String OT() {
        return this.aZt;
    }

    public a ig(String str) {
        this.aZu.append(str).append("\n");
        return this;
    }

    public StringBuilder OU() {
        return this.aZu;
    }

    public long OV() {
        return (OQ() * 10000000) + (OR() * 10000) + (OS() * 1);
    }

    public a ab(long j) {
        Y(j / 10000000);
        long j2 = j % 10000000;
        Z(j2 / 10000);
        aa((j2 % 10000) / 1);
        return this;
    }

    public boolean OW() {
        return this.aZv;
    }

    public void OX() {
        this.aZv = true;
    }

    private long a(long j, long j2, String str) {
        boolean z = j < 0 || j > j2;
        if (z) {
            ig("illegalFallback " + str + "::" + String.valueOf(j));
        }
        return z ? j2 : j;
    }
}
