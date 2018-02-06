package android.support.design.widget;

import android.support.design.widget.s;
import android.util.StateSet;
import java.util.ArrayList;
/* loaded from: classes2.dex */
final class q {
    private final ArrayList<a> qg = new ArrayList<>();
    private a qh = null;
    s qi = null;
    private final s.a qj = new s.b() { // from class: android.support.design.widget.q.1
        @Override // android.support.design.widget.s.b, android.support.design.widget.s.a
        public void b(s sVar) {
            if (q.this.qi == sVar) {
                q.this.qi = null;
            }
        }
    };

    public void a(int[] iArr, s sVar) {
        a aVar = new a(iArr, sVar);
        sVar.a(this.qj);
        this.qg.add(aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(int[] iArr) {
        a aVar;
        int size = this.qg.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                aVar = null;
                break;
            }
            aVar = this.qg.get(i);
            if (StateSet.stateSetMatches(aVar.qm, iArr)) {
                break;
            }
            i++;
        }
        if (aVar != this.qh) {
            if (this.qh != null) {
                cancel();
            }
            this.qh = aVar;
            if (aVar != null) {
                a(aVar);
            }
        }
    }

    private void a(a aVar) {
        this.qi = aVar.qn;
        this.qi.start();
    }

    private void cancel() {
        if (this.qi != null) {
            this.qi.cancel();
            this.qi = null;
        }
    }

    public void jumpToCurrentState() {
        if (this.qi != null) {
            this.qi.end();
            this.qi = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a {
        final int[] qm;
        final s qn;

        a(int[] iArr, s sVar) {
            this.qm = iArr;
            this.qn = sVar;
        }
    }
}
