package bolts;

import bolts.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class i {
    private g<?> zq;

    public i(g<?> gVar) {
        this.zq = gVar;
    }

    protected void finalize() throws Throwable {
        g.a gs;
        try {
            g<?> gVar = this.zq;
            if (gVar != null && (gs = g.gs()) != null) {
                gs.a(gVar, new UnobservedTaskException(gVar.gv()));
            }
        } finally {
            super.finalize();
        }
    }

    public void gA() {
        this.zq = null;
    }
}
