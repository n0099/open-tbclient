package bolts;

import bolts.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class i {
    private g<?> cz;

    public i(g<?> gVar) {
        this.cz = gVar;
    }

    protected void finalize() throws Throwable {
        g.a aJ;
        try {
            g<?> gVar = this.cz;
            if (gVar != null && (aJ = g.aJ()) != null) {
                aJ.a(gVar, new UnobservedTaskException(gVar.aM()));
            }
        } finally {
            super.finalize();
        }
    }

    public void aR() {
        this.cz = null;
    }
}
