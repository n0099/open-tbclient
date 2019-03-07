package bolts;

import bolts.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class i {
    private g<?> kp;

    public i(g<?> gVar) {
        this.kp = gVar;
    }

    protected void finalize() throws Throwable {
        g.a be;
        try {
            g<?> gVar = this.kp;
            if (gVar != null && (be = g.be()) != null) {
                be.a(gVar, new UnobservedTaskException(gVar.bg()));
            }
        } finally {
            super.finalize();
        }
    }

    public void bl() {
        this.kp = null;
    }
}
