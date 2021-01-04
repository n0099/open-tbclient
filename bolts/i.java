package bolts;

import bolts.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class i {
    private g<?> Af;

    public i(g<?> gVar) {
        this.Af = gVar;
    }

    protected void finalize() throws Throwable {
        g.a hB;
        try {
            g<?> gVar = this.Af;
            if (gVar != null && (hB = g.hB()) != null) {
                hB.a(gVar, new UnobservedTaskException(gVar.hD()));
            }
        } finally {
            super.finalize();
        }
    }

    public void hI() {
        this.Af = null;
    }
}
