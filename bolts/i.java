package bolts;

import bolts.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class i {
    private g<?> zQ;

    public i(g<?> gVar) {
        this.zQ = gVar;
    }

    protected void finalize() throws Throwable {
        g.a gI;
        try {
            g<?> gVar = this.zQ;
            if (gVar != null && (gI = g.gI()) != null) {
                gI.a(gVar, new UnobservedTaskException(gVar.gL()));
            }
        } finally {
            super.finalize();
        }
    }

    public void gQ() {
        this.zQ = null;
    }
}
