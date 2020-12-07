package android.arch.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.ReportFragment;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
/* loaded from: classes15.dex */
public class s implements j {
    private static final s AI = new s();
    private int AA = 0;
    private int AB = 0;
    private boolean AC = true;
    private boolean AE = true;
    private final k AF = new k(this);
    private Runnable AG = new Runnable() { // from class: android.arch.lifecycle.s.1
        @Override // java.lang.Runnable
        public void run() {
            s.this.hH();
            s.this.hI();
        }
    };
    private ReportFragment.a AH = new ReportFragment.a() { // from class: android.arch.lifecycle.s.2
        @Override // android.arch.lifecycle.ReportFragment.a
        public void onCreate() {
        }

        @Override // android.arch.lifecycle.ReportFragment.a
        public void onStart() {
            s.this.hD();
        }

        @Override // android.arch.lifecycle.ReportFragment.a
        public void onResume() {
            s.this.hE();
        }
    };
    private Handler mHandler;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void init(Context context) {
        AI.F(context);
    }

    void hD() {
        this.AA++;
        if (this.AA == 1 && this.AE) {
            this.AF.b(Lifecycle.Event.ON_START);
            this.AE = false;
        }
    }

    void hE() {
        this.AB++;
        if (this.AB == 1) {
            if (this.AC) {
                this.AF.b(Lifecycle.Event.ON_RESUME);
                this.AC = false;
                return;
            }
            this.mHandler.removeCallbacks(this.AG);
        }
    }

    void hF() {
        this.AB--;
        if (this.AB == 0) {
            this.mHandler.postDelayed(this.AG, 700L);
        }
    }

    void hG() {
        this.AA--;
        hI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hH() {
        if (this.AB == 0) {
            this.AC = true;
            this.AF.b(Lifecycle.Event.ON_PAUSE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hI() {
        if (this.AA == 0 && this.AC) {
            this.AF.b(Lifecycle.Event.ON_STOP);
            this.AE = true;
        }
    }

    private s() {
    }

    void F(Context context) {
        this.mHandler = new Handler();
        this.AF.b(Lifecycle.Event.ON_CREATE);
        ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new d() { // from class: android.arch.lifecycle.s.3
            @Override // android.arch.lifecycle.d, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
                ReportFragment.k(activity).d(s.this.AH);
            }

            @Override // android.arch.lifecycle.d, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                s.this.hF();
            }

            @Override // android.arch.lifecycle.d, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                s.this.hG();
            }
        });
    }

    @Override // android.arch.lifecycle.j
    @NonNull
    public Lifecycle getLifecycle() {
        return this.AF;
    }
}
