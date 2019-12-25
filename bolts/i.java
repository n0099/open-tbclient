package bolts;

import bolts.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class i {
    private g<?> dF;

    public i(g<?> gVar) {
        this.dF = gVar;
    }

    protected void finalize() throws Throwable {
        g.a aV;
        try {
            g<?> gVar = this.dF;
            if (gVar != null && (aV = g.aV()) != null) {
                aV.a(gVar, new UnobservedTaskException(gVar.aY()));
            }
        } finally {
            super.finalize();
        }
    }

    public void bd() {
        this.dF = null;
    }
}
