package c;

import bolts.UnobservedTaskException;
import c.e;
/* loaded from: classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public e<?> f1498a;

    public g(e<?> eVar) {
        this.f1498a = eVar;
    }

    public void a() {
        this.f1498a = null;
    }

    public void finalize() throws Throwable {
        e.f o;
        try {
            e<?> eVar = this.f1498a;
            if (eVar != null && (o = e.o()) != null) {
                o.a(eVar, new UnobservedTaskException(eVar.m()));
            }
        } finally {
            super.finalize();
        }
    }
}
