package android.arch.lifecycle;

import android.arch.lifecycle.Lifecycle;
import android.os.Handler;
import android.support.annotation.NonNull;
/* loaded from: classes14.dex */
public class u {
    private final Handler mHandler = new Handler();
    private a zE;
    private final k zw;

    public u(@NonNull j jVar) {
        this.zw = new k(jVar);
    }

    private void d(Lifecycle.Event event) {
        if (this.zE != null) {
            this.zE.run();
        }
        this.zE = new a(this.zw, event);
        this.mHandler.postAtFrontOfQueue(this.zE);
    }

    public void hI() {
        d(Lifecycle.Event.ON_CREATE);
    }

    public void hJ() {
        d(Lifecycle.Event.ON_START);
    }

    public void hK() {
        d(Lifecycle.Event.ON_START);
    }

    public void hL() {
        d(Lifecycle.Event.ON_STOP);
        d(Lifecycle.Event.ON_DESTROY);
    }

    public Lifecycle getLifecycle() {
        return this.zw;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public static class a implements Runnable {
        final Lifecycle.Event zF;
        private boolean zG = false;
        private final k zw;

        a(@NonNull k kVar, Lifecycle.Event event) {
            this.zw = kVar;
            this.zF = event;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.zG) {
                this.zw.b(this.zF);
                this.zG = true;
            }
        }
    }
}
