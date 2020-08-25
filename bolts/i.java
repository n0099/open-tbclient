package bolts;

import bolts.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes12.dex */
public class i {
    private g<?> AB;

    public i(g<?> gVar) {
        this.AB = gVar;
    }

    protected void finalize() throws Throwable {
        g.a ii;
        try {
            g<?> gVar = this.AB;
            if (gVar != null && (ii = g.ii()) != null) {
                ii.a(gVar, new UnobservedTaskException(gVar.il()));
            }
        } finally {
            super.finalize();
        }
    }

    public void ir() {
        this.AB = null;
    }
}
