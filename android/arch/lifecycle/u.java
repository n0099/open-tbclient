package android.arch.lifecycle;

import android.arch.lifecycle.Lifecycle;
import android.os.Handler;
import android.support.annotation.NonNull;
/* loaded from: classes6.dex */
public class u {
    private final Handler mHandler = new Handler();
    private final k yX;
    private a zf;

    public u(@NonNull j jVar) {
        this.yX = new k(jVar);
    }

    private void d(Lifecycle.Event event) {
        if (this.zf != null) {
            this.zf.run();
        }
        this.zf = new a(this.yX, event);
        this.mHandler.postAtFrontOfQueue(this.zf);
    }

    public void gu() {
        d(Lifecycle.Event.ON_CREATE);
    }

    public void gv() {
        d(Lifecycle.Event.ON_START);
    }

    public void gw() {
        d(Lifecycle.Event.ON_START);
    }

    public void gx() {
        d(Lifecycle.Event.ON_STOP);
        d(Lifecycle.Event.ON_DESTROY);
    }

    public Lifecycle getLifecycle() {
        return this.yX;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class a implements Runnable {
        private final k yX;
        final Lifecycle.Event zg;
        private boolean zh = false;

        a(@NonNull k kVar, Lifecycle.Event event) {
            this.yX = kVar;
            this.zg = event;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.zh) {
                this.yX.b(this.zg);
                this.zh = true;
            }
        }
    }
}
