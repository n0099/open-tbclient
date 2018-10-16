package bolts;

import bolts.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class i {
    private g<?> kl;

    public i(g<?> gVar) {
        this.kl = gVar;
    }

    protected void finalize() throws Throwable {
        g.a be;
        try {
            g<?> gVar = this.kl;
            if (gVar != null && (be = g.be()) != null) {
                be.a(gVar, new UnobservedTaskException(gVar.bg()));
            }
        } finally {
            super.finalize();
        }
    }

    public void bl() {
        this.kl = null;
    }
}
