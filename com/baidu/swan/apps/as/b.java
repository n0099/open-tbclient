package com.baidu.swan.apps.as;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.searchbox.widget.SlideHelper;
import com.baidu.searchbox.widget.SlideInterceptor;
import com.baidu.searchbox.widget.SlidingPaneLayout;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.x.b.b;
import java.lang.ref.WeakReference;
/* loaded from: classes9.dex */
public class b implements SlideInterceptor {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private WeakReference<SwanAppActivity> bTQ;
    private com.baidu.swan.apps.am.b bTR;
    private BroadcastReceiver bTS = new BroadcastReceiver() { // from class: com.baidu.swan.apps.as.b.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(intent.getAction())) {
                String stringExtra = intent.getStringExtra(TiebaInitialize.LogFields.REASON);
                if (!TextUtils.isEmpty(stringExtra)) {
                    if (("homekey".equals(stringExtra) || stringExtra.equals("recentapps")) && b.this.mSlideHelper != null) {
                        b.this.mSlideHelper.closePane();
                        b.this.mSlideHelper.setCanSlide(false);
                    }
                }
            }
        }
    };
    private SlideHelper mSlideHelper = new SlideHelper();

    public b(SwanAppActivity swanAppActivity) {
        this.bTQ = new WeakReference<>(swanAppActivity);
    }

    public void adL() {
        if (this.bTQ.get() != null) {
            this.mSlideHelper.setCanSlide(canSlide());
        }
    }

    public void adM() {
        SwanAppActivity swanAppActivity = this.bTQ.get();
        if (swanAppActivity != null) {
            this.bTR = swanAppActivity.Ed();
            if (this.bTR != null) {
                if (isNightMode()) {
                    this.bTR.setVisibility(0);
                }
                adO();
            }
        }
    }

    public void onCreate() {
        SwanAppActivity swanAppActivity = this.bTQ.get();
        if (swanAppActivity != null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
            swanAppActivity.registerReceiver(this.bTS, intentFilter);
        }
    }

    public void adN() {
        SwanAppActivity swanAppActivity = this.bTQ.get();
        if (swanAppActivity != null) {
            b.a DR = swanAppActivity.DR();
            if ((DR != null && "1230000000000000".equals(DR.SW())) || swanAppActivity.DH() == 1) {
                this.mSlideHelper.setCanSlide(false);
            } else {
                this.mSlideHelper.setCanSlide(canSlide());
            }
        }
    }

    public void onResume() {
        if (isNightMode()) {
            this.bTR.setVisibility(0);
        }
    }

    public void onDestroy() {
        SwanAppActivity swanAppActivity;
        if (this.bTQ != null && (swanAppActivity = this.bTQ.get()) != null) {
            swanAppActivity.unregisterReceiver(this.bTS);
        }
    }

    public void adO() {
        final SwanAppActivity swanAppActivity = this.bTQ.get();
        if (swanAppActivity != null && !swanAppActivity.isDestroyed()) {
            this.mSlideHelper.attachSlideView(swanAppActivity, swanAppActivity.findViewById(16908290));
            this.mSlideHelper.attachActivity(swanAppActivity);
            this.mSlideHelper.setEnableReleaseWhenNoTranslucent(false);
            this.mSlideHelper.setFadeColor(0);
            this.mSlideHelper.setSlideInterceptor(this);
            this.mSlideHelper.setSlideListener(new SlidingPaneLayout.PanelSlideListener() { // from class: com.baidu.swan.apps.as.b.2
                @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
                public void onPanelSlide(View view, float f) {
                    View maskView = b.this.mSlideHelper.getMaskView();
                    if (maskView != null) {
                        maskView.setAlpha(1.0f - f);
                        if (swanAppActivity.DJ()) {
                            swanAppActivity.DI().GY();
                        }
                        if (f == 0.0f) {
                            maskView.setBackgroundColor(Color.parseColor("#40000000"));
                        }
                        if (f == 1.0f) {
                            maskView.setBackgroundColor(0);
                        }
                    }
                }

                @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
                public void onPanelOpened(View view) {
                    swanAppActivity.onBackPressed();
                    b.this.adQ();
                    swanAppActivity.overridePendingTransition(0, 0);
                }

                @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
                public void onPanelClosed(View view) {
                }
            });
            com.baidu.swan.apps.adaptation.b.c Lr = Lr();
            if (Lr != null) {
                this.mSlideHelper.setRegionFactor(Lr.FP());
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [com.baidu.swan.apps.adaptation.b.d] */
    @Override // com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        com.baidu.swan.apps.core.d.e DP;
        com.baidu.swan.apps.adaptation.b.c Lr;
        boolean z = true;
        SwanAppActivity swanAppActivity = this.bTQ.get();
        if (swanAppActivity == null || !swanAppActivity.DJ() || (DP = swanAppActivity.DP()) == null || (Lr = Lr()) == null) {
            return false;
        }
        com.baidu.swan.apps.adaptation.b.f FW = Lr.FW();
        boolean z2 = (FW == null || FW.Gc() == 0 || !FW.Gc().canGoBack()) ? false : true;
        if (DP.LE() > 1 || !Lr.isSlidable(motionEvent) || z2 || !adP()) {
            z = false;
        }
        return z;
    }

    private com.baidu.swan.apps.adaptation.b.c Lr() {
        com.baidu.swan.apps.core.d.e DP;
        com.baidu.swan.apps.core.d.b LB;
        SwanAppActivity swanAppActivity = this.bTQ.get();
        if (swanAppActivity == null || (DP = swanAppActivity.DP()) == null || (LB = DP.LB()) == null) {
            return null;
        }
        return LB instanceof com.baidu.swan.apps.core.d.d ? ((com.baidu.swan.apps.core.d.d) LB).Lr() : null;
    }

    private boolean canSlide() {
        SwanAppActivity swanAppActivity = this.bTQ.get();
        if (swanAppActivity == null) {
            return false;
        }
        return (swanAppActivity.getResources().getConfiguration().orientation == 2 || Build.VERSION.SDK_INT == 26) ? false : true;
    }

    private boolean adP() {
        SwanAppActivity swanAppActivity = this.bTQ.get();
        if (swanAppActivity == null || swanAppActivity.isDestroyed() || !swanAppActivity.DJ()) {
            return false;
        }
        com.baidu.swan.apps.core.d.d LC = swanAppActivity.DP().LC();
        if (LC != null) {
            return LC.KX() == null || !LC.KX().bLB;
        } else if (DEBUG) {
            Log.d("SwanAppActivitySlideHelper", "topFragment = null; return false");
            return false;
        } else {
            return false;
        }
    }

    public void closePane() {
        this.mSlideHelper.closePane();
    }

    public void setCanSlide(boolean z) {
        this.mSlideHelper.setCanSlide(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adQ() {
        if (isNightMode()) {
            this.bTR.setVisibility(8);
        }
    }

    private boolean isNightMode() {
        return com.baidu.swan.apps.w.a.RG().getNightModeSwitcherState();
    }
}
