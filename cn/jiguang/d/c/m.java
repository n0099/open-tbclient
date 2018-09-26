package cn.jiguang.d.c;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Arrays;
/* loaded from: classes3.dex */
public abstract class m implements Serializable, Cloneable, Comparable {
    private static final DecimalFormat ln;
    protected j a;
    protected int b;
    protected int c;
    protected long d;

    static {
        DecimalFormat decimalFormat = new DecimalFormat();
        ln = decimalFormat;
        decimalFormat.setMinimumIntegerDigits(3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static m a(d dVar, int i) {
        j jVar = new j(dVar);
        int g = dVar.g();
        int g2 = dVar.g();
        if (i == 0) {
            return a(jVar, g, g2);
        }
        long h = dVar.h();
        int g3 = dVar.g();
        m a = a(jVar, g, g2, h);
        if (dVar != null) {
            if (dVar.b() < g3) {
                throw new t("truncated record");
            }
            dVar.a(g3);
            a.a(dVar);
            if (dVar.b() > 0) {
                throw new t("invalid record length");
            }
            dVar.c();
            return a;
        }
        return a;
    }

    public static m a(j jVar, int i, int i2) {
        if (jVar.a()) {
            return a(jVar, i, i2, 0L);
        }
        throw new n(jVar);
    }

    private static final m a(j jVar, int i, int i2, long j) {
        p pVar = new p();
        pVar.a = jVar;
        pVar.b = i;
        pVar.c = i2;
        pVar.d = j;
        return pVar;
    }

    private byte[] bB() {
        e eVar = new e();
        a(eVar, true);
        return eVar.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract String a();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(long j) {
        this.d = j;
    }

    abstract void a(d dVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(e eVar, b bVar) {
        this.a.a(eVar, bVar);
        eVar.c(this.b);
        eVar.c(this.c);
    }

    abstract void a(e eVar, boolean z);

    public final boolean a(m mVar) {
        return this.b == mVar.b && this.c == mVar.c && this.a.equals(mVar.a);
    }

    public final j b() {
        return this.a;
    }

    public final int c() {
        return this.b;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        m mVar = (m) obj;
        if (this == mVar) {
            return 0;
        }
        int compareTo = this.a.compareTo(mVar.a);
        if (compareTo != 0) {
            return compareTo;
        }
        int i = this.c - mVar.c;
        if (i != 0) {
            return i;
        }
        int i2 = this.b - mVar.b;
        if (i2 != 0) {
            return i2;
        }
        byte[] bB = bB();
        byte[] bB2 = mVar.bB();
        for (int i3 = 0; i3 < bB.length && i3 < bB2.length; i3++) {
            int i4 = (bB[i3] & 255) - (bB2[i3] & 255);
            if (i4 != 0) {
                return i4;
            }
        }
        return bB.length - bB2.length;
    }

    public final int d() {
        return this.b;
    }

    public final int e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        if (this.b == mVar.b && this.c == mVar.c && this.a.equals(mVar.a)) {
            return Arrays.equals(bB(), mVar.bB());
        }
        return false;
    }

    public final long f() {
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final m g() {
        try {
            return (m) clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException();
        }
    }

    public int hashCode() {
        e eVar = new e();
        this.a.a(eVar);
        eVar.c(this.b);
        eVar.c(this.c);
        eVar.a(0L);
        int a = eVar.a();
        eVar.c(0);
        a(eVar, true);
        eVar.a((eVar.a() - a) - 2, a);
        byte[] b = eVar.b();
        int i = 0;
        for (byte b2 : b) {
            i += (i << 3) + (b2 & 255);
        }
        return i;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.a);
        if (stringBuffer.length() < 8) {
            stringBuffer.append("\t");
        }
        if (stringBuffer.length() < 16) {
            stringBuffer.append("\t");
        }
        stringBuffer.append("\t");
        String a = a();
        if (!a.equals("")) {
            stringBuffer.append("\t");
            stringBuffer.append(a);
        }
        return stringBuffer.toString();
    }
}
