package cn.jiguang.d.c;

import android.support.v7.widget.ActivityChooserView;
/* loaded from: classes3.dex */
public final class b {
    private c[] lM = new c[17];

    public final int a(j jVar) {
        int i = -1;
        for (c cVar = this.lM[(jVar.hashCode() & ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) % 17]; cVar != null; cVar = cVar.lN) {
            if (cVar.a.equals(jVar)) {
                i = cVar.b;
            }
        }
        return i;
    }

    public final void a(int i, j jVar) {
        if (i > 16383) {
            return;
        }
        int hashCode = (jVar.hashCode() & ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) % 17;
        c cVar = new c((byte) 0);
        cVar.a = jVar;
        cVar.b = i;
        cVar.lN = this.lM[hashCode];
        this.lM[hashCode] = cVar;
    }
}
