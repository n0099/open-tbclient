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
    private static final s cF = new s();
    private Handler mHandler;
    private int cv = 0;
    private int cz = 0;
    private boolean cA = true;
    private boolean cB = true;
    private final k cC = new k(this);
    private Runnable cD = new Runnable() { // from class: android.arch.lifecycle.s.1
        @Override // java.lang.Runnable
        public void run() {
            s.this.aF();
            s.this.aG();
        }
    };
    private ReportFragment.a cE = new ReportFragment.a() { // from class: android.arch.lifecycle.s.2
        @Override // android.arch.lifecycle.ReportFragment.a
        public void onCreate() {
        }

        @Override // android.arch.lifecycle.ReportFragment.a
        public void onStart() {
            s.this.aB();
        }

        @Override // android.arch.lifecycle.ReportFragment.a
        public void onResume() {
            s.this.aC();
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void init(Context context) {
        cF.P(context);
    }

    void aB() {
        this.cv++;
        if (this.cv == 1 && this.cB) {
            this.cC.b(Lifecycle.Event.ON_START);
            this.cB = false;
        }
    }

    void aC() {
        this.cz++;
        if (this.cz == 1) {
            if (this.cA) {
                this.cC.b(Lifecycle.Event.ON_RESUME);
                this.cA = false;
                return;
            }
            this.mHandler.removeCallbacks(this.cD);
        }
    }

    void aD() {
        this.cz--;
        if (this.cz == 0) {
            this.mHandler.postDelayed(this.cD, 700L);
        }
    }

    void aE() {
        this.cv--;
        aG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aF() {
        if (this.cz == 0) {
            this.cA = true;
            this.cC.b(Lifecycle.Event.ON_PAUSE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aG() {
        if (this.cv == 0 && this.cA) {
            this.cC.b(Lifecycle.Event.ON_STOP);
            this.cB = true;
        }
    }

    private s() {
    }

    void P(Context context) {
        this.mHandler = new Handler();
        this.cC.b(Lifecycle.Event.ON_CREATE);
        ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new d() { // from class: android.arch.lifecycle.s.3
            @Override // android.arch.lifecycle.d, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
                ReportFragment.k(activity).d(s.this.cE);
            }

            @Override // android.arch.lifecycle.d, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                s.this.aD();
            }

            @Override // android.arch.lifecycle.d, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                s.this.aE();
            }
        });
    }

    @Override // android.arch.lifecycle.j
    @NonNull
    public Lifecycle getLifecycle() {
        return this.cC;
    }
}
