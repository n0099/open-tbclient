package android.arch.lifecycle;

import android.arch.lifecycle.Lifecycle;
import android.os.Handler;
import android.support.annotation.NonNull;
/* loaded from: classes6.dex */
public class u {
    private final Handler mHandler = new Handler();
    private a yF;
    private final k yx;

    public u(@NonNull j jVar) {
        this.yx = new k(jVar);
    }

    private void d(Lifecycle.Event event) {
        if (this.yF != null) {
            this.yF.run();
        }
        this.yF = new a(this.yx, event);
        this.mHandler.postAtFrontOfQueue(this.yF);
    }

    public void ge() {
        d(Lifecycle.Event.ON_CREATE);
    }

    public void gf() {
        d(Lifecycle.Event.ON_START);
    }

    public void gg() {
        d(Lifecycle.Event.ON_START);
    }

    public void gh() {
        d(Lifecycle.Event.ON_STOP);
        d(Lifecycle.Event.ON_DESTROY);
    }

    public Lifecycle getLifecycle() {
        return this.yx;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class a implements Runnable {
        final Lifecycle.Event yG;
        private boolean yH = false;
        private final k yx;

        a(@NonNull k kVar, Lifecycle.Event event) {
            this.yx = kVar;
            this.yG = event;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.yH) {
                this.yx.b(this.yG);
                this.yH = true;
            }
        }
    }
}
