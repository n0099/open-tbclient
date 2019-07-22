package bolts;

import bolts.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class i {
    private g<?> ko;

    public i(g<?> gVar) {
        this.ko = gVar;
    }

    protected void finalize() throws Throwable {
        g.a bg;
        try {
            g<?> gVar = this.ko;
            if (gVar != null && (bg = g.bg()) != null) {
                bg.a(gVar, new UnobservedTaskException(gVar.bj()));
            }
        } finally {
            super.finalize();
        }
    }

    public void bo() {
        this.ko = null;
    }
}
