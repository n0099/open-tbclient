package cn.jiguang.d.c;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public final class l implements Serializable {
    private List a;
    private short b;
    private short c;

    public l() {
        this.a = new ArrayList(1);
        this.b = (short) 0;
        this.c = (short) 0;
    }

    public l(m mVar) {
        this();
        c(mVar);
    }

    private static String a(Iterator it) {
        StringBuffer stringBuffer = new StringBuffer();
        while (it.hasNext()) {
            stringBuffer.append("[");
            stringBuffer.append(((m) it.next()).a());
            stringBuffer.append("]");
            if (it.hasNext()) {
                stringBuffer.append(" ");
            }
        }
        return stringBuffer.toString();
    }

    private synchronized long c() {
        return b().f();
    }

    private synchronized Iterator c(boolean z, boolean z2) {
        Iterator it;
        int i = 0;
        synchronized (this) {
            int size = this.a.size();
            int i2 = z ? size - this.b : this.b;
            if (i2 == 0) {
                it = Collections.EMPTY_LIST.iterator();
            } else {
                if (!z) {
                    i = size - this.b;
                } else if (z2) {
                    if (this.c >= i2) {
                        this.c = (short) 0;
                    }
                    i = this.c;
                    this.c = (short) (i + 1);
                }
                ArrayList arrayList = new ArrayList(i2);
                if (z) {
                    arrayList.addAll(this.a.subList(i, i2));
                    if (i != 0) {
                        arrayList.addAll(this.a.subList(0, i));
                    }
                } else {
                    arrayList.addAll(this.a.subList(i, size));
                }
                it = arrayList.iterator();
            }
        }
        return it;
    }

    private void c(m mVar) {
        if (this.b == 0) {
            this.a.add(mVar);
        } else {
            this.a.add(this.a.size() - this.b, mVar);
        }
    }

    public final synchronized Iterator a() {
        return c(true, true);
    }

    public final synchronized void a(m mVar) {
        if (this.a.size() == 0) {
            c(mVar);
        } else {
            m b = b();
            if (!mVar.a(b)) {
                throw new IllegalArgumentException("record does not match rrset");
            }
            if (mVar.f() != b.f()) {
                if (mVar.f() <= b.f()) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= this.a.size()) {
                            break;
                        }
                        m g = ((m) this.a.get(i2)).g();
                        g.a(mVar.f());
                        this.a.set(i2, g);
                        i = i2 + 1;
                    }
                } else {
                    mVar = mVar.g();
                    mVar.a(b.f());
                }
            }
            if (!this.a.contains(mVar)) {
                c(mVar);
            }
        }
    }

    public final synchronized m b() {
        if (this.a.size() == 0) {
            throw new IllegalStateException("rrset is empty");
        }
        return (m) this.a.get(0);
    }

    public final String toString() {
        if (this.a.size() == 0) {
            return "{empty}";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("{ ");
        stringBuffer.append(b().b() + " ");
        stringBuffer.append(c() + " ");
        stringBuffer.append(a(c(true, false)));
        if (this.b > 0) {
            stringBuffer.append(" sigs: ");
            stringBuffer.append(a(c(false, false)));
        }
        stringBuffer.append(" }");
        return stringBuffer.toString();
    }
}
