package android.arch.lifecycle;

import android.arch.lifecycle.Lifecycle;
import android.os.Handler;
import android.support.annotation.NonNull;
/* loaded from: classes4.dex */
public class u {
    private final k cD;
    private a cL;
    private final Handler mHandler = new Handler();

    public u(@NonNull j jVar) {
        this.cD = new k(jVar);
    }

    private void d(Lifecycle.Event event) {
        if (this.cL != null) {
            this.cL.run();
        }
        this.cL = new a(this.cD, event);
        this.mHandler.postAtFrontOfQueue(this.cL);
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
        return this.cD;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class a implements Runnable {
        private final k cD;
        final Lifecycle.Event cM;
        private boolean cN = false;

        a(@NonNull k kVar, Lifecycle.Event event) {
            this.cD = kVar;
            this.cM = event;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.cN) {
                this.cD.b(this.cM);
                this.cN = true;
            }
        }
    }
}
