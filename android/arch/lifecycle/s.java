package android.arch.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.ReportFragment;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
/* loaded from: classes6.dex */
public class s implements j {
    private static final s za = new s();
    private Handler mHandler;
    private int yT = 0;
    private int yU = 0;
    private boolean yV = true;
    private boolean yW = true;
    private final k yX = new k(this);
    private Runnable yY = new Runnable() { // from class: android.arch.lifecycle.s.1
        @Override // java.lang.Runnable
        public void run() {
            s.this.gs();
            s.this.gt();
        }
    };
    private ReportFragment.a yZ = new ReportFragment.a() { // from class: android.arch.lifecycle.s.2
        @Override // android.arch.lifecycle.ReportFragment.a
        public void onCreate() {
        }

        @Override // android.arch.lifecycle.ReportFragment.a
        public void onStart() {
            s.this.go();
        }

        @Override // android.arch.lifecycle.ReportFragment.a
        public void onResume() {
            s.this.gp();
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void init(Context context) {
        za.C(context);
    }

    void go() {
        this.yT++;
        if (this.yT == 1 && this.yW) {
            this.yX.b(Lifecycle.Event.ON_START);
            this.yW = false;
        }
    }

    void gp() {
        this.yU++;
        if (this.yU == 1) {
            if (this.yV) {
                this.yX.b(Lifecycle.Event.ON_RESUME);
                this.yV = false;
                return;
            }
            this.mHandler.removeCallbacks(this.yY);
        }
    }

    void gq() {
        this.yU--;
        if (this.yU == 0) {
            this.mHandler.postDelayed(this.yY, 700L);
        }
    }

    void gr() {
        this.yT--;
        gt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gs() {
        if (this.yU == 0) {
            this.yV = true;
            this.yX.b(Lifecycle.Event.ON_PAUSE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gt() {
        if (this.yT == 0 && this.yV) {
            this.yX.b(Lifecycle.Event.ON_STOP);
            this.yW = true;
        }
    }

    private s() {
    }

    void C(Context context) {
        this.mHandler = new Handler();
        this.yX.b(Lifecycle.Event.ON_CREATE);
        ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new d() { // from class: android.arch.lifecycle.s.3
            @Override // android.arch.lifecycle.d, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
                ReportFragment.k(activity).d(s.this.yZ);
            }

            @Override // android.arch.lifecycle.d, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                s.this.gq();
            }

            @Override // android.arch.lifecycle.d, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                s.this.gr();
            }
        });
    }

    @Override // android.arch.lifecycle.j
    @NonNull
    public Lifecycle getLifecycle() {
        return this.yX;
    }
}
