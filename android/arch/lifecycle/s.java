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
    private static final s yA = new s();
    private Handler mHandler;
    private int yt = 0;
    private int yu = 0;
    private boolean yv = true;
    private boolean yw = true;
    private final k yx = new k(this);
    private Runnable yy = new Runnable() { // from class: android.arch.lifecycle.s.1
        @Override // java.lang.Runnable
        public void run() {
            s.this.gb();
            s.this.gd();
        }
    };
    private ReportFragment.a yz = new ReportFragment.a() { // from class: android.arch.lifecycle.s.2
        @Override // android.arch.lifecycle.ReportFragment.a
        public void onCreate() {
        }

        @Override // android.arch.lifecycle.ReportFragment.a
        public void onStart() {
            s.this.fX();
        }

        @Override // android.arch.lifecycle.ReportFragment.a
        public void onResume() {
            s.this.fY();
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void init(Context context) {
        yA.P(context);
    }

    void fX() {
        this.yt++;
        if (this.yt == 1 && this.yw) {
            this.yx.b(Lifecycle.Event.ON_START);
            this.yw = false;
        }
    }

    void fY() {
        this.yu++;
        if (this.yu == 1) {
            if (this.yv) {
                this.yx.b(Lifecycle.Event.ON_RESUME);
                this.yv = false;
                return;
            }
            this.mHandler.removeCallbacks(this.yy);
        }
    }

    void fZ() {
        this.yu--;
        if (this.yu == 0) {
            this.mHandler.postDelayed(this.yy, 700L);
        }
    }

    void ga() {
        this.yt--;
        gd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gb() {
        if (this.yu == 0) {
            this.yv = true;
            this.yx.b(Lifecycle.Event.ON_PAUSE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gd() {
        if (this.yt == 0 && this.yv) {
            this.yx.b(Lifecycle.Event.ON_STOP);
            this.yw = true;
        }
    }

    private s() {
    }

    void P(Context context) {
        this.mHandler = new Handler();
        this.yx.b(Lifecycle.Event.ON_CREATE);
        ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new d() { // from class: android.arch.lifecycle.s.3
            @Override // android.arch.lifecycle.d, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
                ReportFragment.k(activity).d(s.this.yz);
            }

            @Override // android.arch.lifecycle.d, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                s.this.fZ();
            }

            @Override // android.arch.lifecycle.d, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                s.this.ga();
            }
        });
    }

    @Override // android.arch.lifecycle.j
    @NonNull
    public Lifecycle getLifecycle() {
        return this.yx;
    }
}
