package bolts;

import bolts.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes19.dex */
public class i {
    private g<?> zS;

    public i(g<?> gVar) {
        this.zS = gVar;
    }

    protected void finalize() throws Throwable {
        g.a gI;
        try {
            g<?> gVar = this.zS;
            if (gVar != null && (gI = g.gI()) != null) {
                gI.a(gVar, new UnobservedTaskException(gVar.gL()));
            }
        } finally {
            super.finalize();
        }
    }

    public void gQ() {
        this.zS = null;
    }
}
