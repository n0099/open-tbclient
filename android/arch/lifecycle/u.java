package android.arch.lifecycle;

import android.arch.lifecycle.Lifecycle;
import android.os.Handler;
import android.support.annotation.NonNull;
/* loaded from: classes8.dex */
public class u {
    private final Handler mHandler = new Handler();
    private final k zN;
    private a zV;

    public u(@NonNull j jVar) {
        this.zN = new k(jVar);
    }

    private void d(Lifecycle.Event event) {
        if (this.zV != null) {
            this.zV.run();
        }
        this.zV = new a(this.zN, event);
        this.mHandler.postAtFrontOfQueue(this.zV);
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
        return this.zN;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public static class a implements Runnable {
        private final k zN;
        final Lifecycle.Event zW;
        private boolean zX = false;

        a(@NonNull k kVar, Lifecycle.Event event) {
            this.zN = kVar;
            this.zW = event;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.zX) {
                this.zN.b(this.zW);
                this.zX = true;
            }
        }
    }
}
