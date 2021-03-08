package bolts;

import bolts.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes14.dex */
public class i {
    private g<?> CW;

    public i(g<?> gVar) {
        this.CW = gVar;
    }

    protected void finalize() throws Throwable {
        g.a hI;
        try {
            g<?> gVar = this.CW;
            if (gVar != null && (hI = g.hI()) != null) {
                hI.a(gVar, new UnobservedTaskException(gVar.hK()));
            }
        } finally {
            super.finalize();
        }
    }

    public void hP() {
        this.CW = null;
    }
}
