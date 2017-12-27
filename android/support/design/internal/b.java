package android.support.design.internal;

import android.support.b.aa;
import android.support.b.u;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.view.ViewGroup;
/* loaded from: classes2.dex */
class b extends a {
    private final aa jm = new android.support.b.a();

    /* JADX INFO: Access modifiers changed from: package-private */
    public b() {
        this.jm.W(0);
        this.jm.setDuration(115L);
        this.jm.setInterpolator(new FastOutSlowInInterpolator());
        this.jm.a(new TextScale());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.support.design.internal.a
    public void beginDelayedTransition(ViewGroup viewGroup) {
        u.a(viewGroup, this.jm);
    }
}
