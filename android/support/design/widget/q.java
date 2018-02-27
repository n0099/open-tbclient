package android.support.design.widget;

import android.support.design.widget.s;
import android.util.StateSet;
import java.util.ArrayList;
/* loaded from: classes2.dex */
final class q {
    private final ArrayList<a> qf = new ArrayList<>();
    private a qg = null;
    s qh = null;
    private final s.a qi = new s.b() { // from class: android.support.design.widget.q.1
        @Override // android.support.design.widget.s.b, android.support.design.widget.s.a
        public void b(s sVar) {
            if (q.this.qh == sVar) {
                q.this.qh = null;
            }
        }
    };

    public void a(int[] iArr, s sVar) {
        a aVar = new a(iArr, sVar);
        sVar.a(this.qi);
        this.qf.add(aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(int[] iArr) {
        a aVar;
        int size = this.qf.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                aVar = null;
                break;
            }
            aVar = this.qf.get(i);
            if (StateSet.stateSetMatches(aVar.ql, iArr)) {
                break;
            }
            i++;
        }
        if (aVar != this.qg) {
            if (this.qg != null) {
                cancel();
            }
            this.qg = aVar;
            if (aVar != null) {
                a(aVar);
            }
        }
    }

    private void a(a aVar) {
        this.qh = aVar.qm;
        this.qh.start();
    }

    private void cancel() {
        if (this.qh != null) {
            this.qh.cancel();
            this.qh = null;
        }
    }

    public void jumpToCurrentState() {
        if (this.qh != null) {
            this.qh.end();
            this.qh = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a {
        final int[] ql;
        final s qm;

        a(int[] iArr, s sVar) {
            this.ql = iArr;
            this.qm = sVar;
        }
    }
}
