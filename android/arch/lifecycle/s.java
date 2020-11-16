package android.arch.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.ReportFragment;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
/* loaded from: classes16.dex */
public class s implements j {
    private static final s zQ = new s();
    private Handler mHandler;
    private int zJ = 0;
    private int zK = 0;
    private boolean zL = true;
    private boolean zM = true;
    private final k zN = new k(this);
    private Runnable zO = new Runnable() { // from class: android.arch.lifecycle.s.1
        @Override // java.lang.Runnable
        public void run() {
            s.this.hH();
            s.this.hI();
        }
    };
    private ReportFragment.a zP = new ReportFragment.a() { // from class: android.arch.lifecycle.s.2
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void init(Context context) {
        zQ.E(context);
    }

    void hD() {
        this.zJ++;
        if (this.zJ == 1 && this.zM) {
            this.zN.b(Lifecycle.Event.ON_START);
            this.zM = false;
        }
    }

    void hE() {
        this.zK++;
        if (this.zK == 1) {
            if (this.zL) {
                this.zN.b(Lifecycle.Event.ON_RESUME);
                this.zL = false;
                return;
            }
            this.mHandler.removeCallbacks(this.zO);
        }
    }

    void hF() {
        this.zK--;
        if (this.zK == 0) {
            this.mHandler.postDelayed(this.zO, 700L);
        }
    }

    void hG() {
        this.zJ--;
        hI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hH() {
        if (this.zK == 0) {
            this.zL = true;
            this.zN.b(Lifecycle.Event.ON_PAUSE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hI() {
        if (this.zJ == 0 && this.zL) {
            this.zN.b(Lifecycle.Event.ON_STOP);
            this.zM = true;
        }
    }

    private s() {
    }

    void E(Context context) {
        this.mHandler = new Handler();
        this.zN.b(Lifecycle.Event.ON_CREATE);
        ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new d() { // from class: android.arch.lifecycle.s.3
            @Override // android.arch.lifecycle.d, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
                ReportFragment.k(activity).d(s.this.zP);
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
        return this.zN;
    }
}
