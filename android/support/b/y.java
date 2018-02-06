package android.support.b;

import android.transition.TransitionManager;
import android.view.ViewGroup;
/* loaded from: classes2.dex */
class y extends x {
    @Override // android.support.b.x
    public void a(ViewGroup viewGroup, q qVar) {
        TransitionManager.beginDelayedTransition(viewGroup, qVar == null ? null : ((t) qVar).uY);
    }
}
