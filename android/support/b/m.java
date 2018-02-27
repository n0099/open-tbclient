package android.support.b;

import android.support.b.k;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes2.dex */
final class m {
    Runnable uP;
    private ViewGroup uQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(View view, m mVar) {
        view.setTag(k.a.transition_current_scene, mVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static m G(View view) {
        return (m) view.getTag(k.a.transition_current_scene);
    }

    public void exit() {
        if (G(this.uQ) == this && this.uP != null) {
            this.uP.run();
        }
    }
}
