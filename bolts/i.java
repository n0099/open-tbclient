package bolts;

import bolts.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes19.dex */
public class i {
    private g<?> AW;

    public i(g<?> gVar) {
        this.AW = gVar;
    }

    protected void finalize() throws Throwable {
        g.a ij;
        try {
            g<?> gVar = this.AW;
            if (gVar != null && (ij = g.ij()) != null) {
                ij.a(gVar, new UnobservedTaskException(gVar.im()));
            }
        } finally {
            super.finalize();
        }
    }

    public void is() {
        this.AW = null;
    }
}
