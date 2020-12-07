package android.arch.lifecycle;

import android.arch.lifecycle.Lifecycle;
import android.os.Handler;
import android.support.annotation.NonNull;
/* loaded from: classes15.dex */
public class u {
    private final k AF;
    private a AO;
    private final Handler mHandler = new Handler();

    public u(@NonNull j jVar) {
        this.AF = new k(jVar);
    }

    private void d(Lifecycle.Event event) {
        if (this.AO != null) {
            this.AO.run();
        }
        this.AO = new a(this.AF, event);
        this.mHandler.postAtFrontOfQueue(this.AO);
    }

    public void hJ() {
        d(Lifecycle.Event.ON_CREATE);
    }

    public void hK() {
        d(Lifecycle.Event.ON_START);
    }

    public void hL() {
        d(Lifecycle.Event.ON_START);
    }

    public void hM() {
        d(Lifecycle.Event.ON_STOP);
        d(Lifecycle.Event.ON_DESTROY);
    }

    public Lifecycle getLifecycle() {
        return this.AF;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public static class a implements Runnable {
        private final k AF;
        final Lifecycle.Event AP;
        private boolean AQ = false;

        a(@NonNull k kVar, Lifecycle.Event event) {
            this.AF = kVar;
            this.AP = event;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.AQ) {
                this.AF.b(this.AP);
                this.AQ = true;
            }
        }
    }
}
