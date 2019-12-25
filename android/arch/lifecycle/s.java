package android.arch.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.ReportFragment;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
/* loaded from: classes4.dex */
public class s implements j {
    private static final s cG = new s();
    private Handler mHandler;
    private int cz = 0;
    private int cA = 0;
    private boolean cB = true;
    private boolean cC = true;
    private final k cD = new k(this);
    private Runnable cE = new Runnable() { // from class: android.arch.lifecycle.s.1
        @Override // java.lang.Runnable
        public void run() {
            s.this.aF();
            s.this.aG();
        }
    };
    private ReportFragment.a cF = new ReportFragment.a() { // from class: android.arch.lifecycle.s.2
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
        cG.P(context);
    }

    void aB() {
        this.cz++;
        if (this.cz == 1 && this.cC) {
            this.cD.b(Lifecycle.Event.ON_START);
            this.cC = false;
        }
    }

    void aC() {
        this.cA++;
        if (this.cA == 1) {
            if (this.cB) {
                this.cD.b(Lifecycle.Event.ON_RESUME);
                this.cB = false;
                return;
            }
            this.mHandler.removeCallbacks(this.cE);
        }
    }

    void aD() {
        this.cA--;
        if (this.cA == 0) {
            this.mHandler.postDelayed(this.cE, 700L);
        }
    }

    void aE() {
        this.cz--;
        aG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aF() {
        if (this.cA == 0) {
            this.cB = true;
            this.cD.b(Lifecycle.Event.ON_PAUSE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aG() {
        if (this.cz == 0 && this.cB) {
            this.cD.b(Lifecycle.Event.ON_STOP);
            this.cC = true;
        }
    }

    private s() {
    }

    void P(Context context) {
        this.mHandler = new Handler();
        this.cD.b(Lifecycle.Event.ON_CREATE);
        ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new d() { // from class: android.arch.lifecycle.s.3
            @Override // android.arch.lifecycle.d, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
                ReportFragment.k(activity).d(s.this.cF);
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
        return this.cD;
    }
}
