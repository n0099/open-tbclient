package bolts;

import bolts.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public class i {
    private g<?> BM;

    public i(g<?> gVar) {
        this.BM = gVar;
    }

    protected void finalize() throws Throwable {
        g.a ij;
        try {
            g<?> gVar = this.BM;
            if (gVar != null && (ij = g.ij()) != null) {
                ij.a(gVar, new UnobservedTaskException(gVar.im()));
            }
        } finally {
            super.finalize();
        }
    }

    public void is() {
        this.BM = null;
    }
}
