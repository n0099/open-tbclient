package android.arch.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.ReportFragment;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
/* loaded from: classes14.dex */
public class s implements j {
    private static final s zz = new s();
    private Handler mHandler;
    private int zs = 0;
    private int zt = 0;
    private boolean zu = true;
    private boolean zv = true;
    private final k zw = new k(this);
    private Runnable zx = new Runnable() { // from class: android.arch.lifecycle.s.1
        @Override // java.lang.Runnable
        public void run() {
            s.this.hG();
            s.this.hH();
        }
    };
    private ReportFragment.a zy = new ReportFragment.a() { // from class: android.arch.lifecycle.s.2
        @Override // android.arch.lifecycle.ReportFragment.a
        public void onCreate() {
        }

        @Override // android.arch.lifecycle.ReportFragment.a
        public void onStart() {
            s.this.hC();
        }

        @Override // android.arch.lifecycle.ReportFragment.a
        public void onResume() {
            s.this.hD();
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void init(Context context) {
        zz.E(context);
    }

    void hC() {
        this.zs++;
        if (this.zs == 1 && this.zv) {
            this.zw.b(Lifecycle.Event.ON_START);
            this.zv = false;
        }
    }

    void hD() {
        this.zt++;
        if (this.zt == 1) {
            if (this.zu) {
                this.zw.b(Lifecycle.Event.ON_RESUME);
                this.zu = false;
                return;
            }
            this.mHandler.removeCallbacks(this.zx);
        }
    }

    void hE() {
        this.zt--;
        if (this.zt == 0) {
            this.mHandler.postDelayed(this.zx, 700L);
        }
    }

    void hF() {
        this.zs--;
        hH();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hG() {
        if (this.zt == 0) {
            this.zu = true;
            this.zw.b(Lifecycle.Event.ON_PAUSE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hH() {
        if (this.zs == 0 && this.zu) {
            this.zw.b(Lifecycle.Event.ON_STOP);
            this.zv = true;
        }
    }

    private s() {
    }

    void E(Context context) {
        this.mHandler = new Handler();
        this.zw.b(Lifecycle.Event.ON_CREATE);
        ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new d() { // from class: android.arch.lifecycle.s.3
            @Override // android.arch.lifecycle.d, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
                ReportFragment.k(activity).d(s.this.zy);
            }

            @Override // android.arch.lifecycle.d, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                s.this.hE();
            }

            @Override // android.arch.lifecycle.d, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                s.this.hF();
            }
        });
    }

    @Override // android.arch.lifecycle.j
    @NonNull
    public Lifecycle getLifecycle() {
        return this.zw;
    }
}
