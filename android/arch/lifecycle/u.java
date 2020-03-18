package android.arch.lifecycle;

import android.arch.lifecycle.Lifecycle;
import android.os.Handler;
import android.support.annotation.NonNull;
/* loaded from: classes6.dex */
public class u {
    private final k cC;
    private a cK;
    private final Handler mHandler = new Handler();

    public u(@NonNull j jVar) {
        this.cC = new k(jVar);
    }

    private void d(Lifecycle.Event event) {
        if (this.cK != null) {
            this.cK.run();
        }
        this.cK = new a(this.cC, event);
        this.mHandler.postAtFrontOfQueue(this.cK);
    }

    public void aH() {
        d(Lifecycle.Event.ON_CREATE);
    }

    public void aI() {
        d(Lifecycle.Event.ON_START);
    }

    public void aJ() {
        d(Lifecycle.Event.ON_START);
    }

    public void aK() {
        d(Lifecycle.Event.ON_STOP);
        d(Lifecycle.Event.ON_DESTROY);
    }

    public Lifecycle getLifecycle() {
        return this.cC;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class a implements Runnable {
        private final k cC;
        final Lifecycle.Event cL;
        private boolean cM = false;

        a(@NonNull k kVar, Lifecycle.Event event) {
            this.cC = kVar;
            this.cL = event;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.cM) {
                this.cC.b(this.cL);
                this.cM = true;
            }
        }
    }
}
