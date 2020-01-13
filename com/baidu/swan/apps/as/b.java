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
/* loaded from: classes10.dex */
public class b implements SlideInterceptor {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private WeakReference<SwanAppActivity> bUc;
    private com.baidu.swan.apps.am.b bUd;
    private BroadcastReceiver bUe = new BroadcastReceiver() { // from class: com.baidu.swan.apps.as.b.1
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
        this.bUc = new WeakReference<>(swanAppActivity);
    }

    public void aee() {
        if (this.bUc.get() != null) {
            this.mSlideHelper.setCanSlide(canSlide());
        }
    }

    public void aef() {
        SwanAppActivity swanAppActivity = this.bUc.get();
        if (swanAppActivity != null) {
            this.bUd = swanAppActivity.Ez();
            if (this.bUd != null) {
                if (isNightMode()) {
                    this.bUd.setVisibility(0);
                }
                aeh();
            }
        }
    }

    public void onCreate() {
        SwanAppActivity swanAppActivity = this.bUc.get();
        if (swanAppActivity != null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
            swanAppActivity.registerReceiver(this.bUe, intentFilter);
        }
    }

    public void aeg() {
        SwanAppActivity swanAppActivity = this.bUc.get();
        if (swanAppActivity != null) {
            b.a En = swanAppActivity.En();
            if ((En != null && "1230000000000000".equals(En.Tt())) || swanAppActivity.Ed() == 1) {
                this.mSlideHelper.setCanSlide(false);
            } else {
                this.mSlideHelper.setCanSlide(canSlide());
            }
        }
    }

    public void onResume() {
        if (isNightMode()) {
            this.bUd.setVisibility(0);
        }
    }

    public void onDestroy() {
        SwanAppActivity swanAppActivity;
        if (this.bUc != null && (swanAppActivity = this.bUc.get()) != null) {
            swanAppActivity.unregisterReceiver(this.bUe);
        }
    }

    public void aeh() {
        final SwanAppActivity swanAppActivity = this.bUc.get();
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
                        if (swanAppActivity.Ef()) {
                            swanAppActivity.Ee().Hu();
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
                    b.this.aej();
                    swanAppActivity.overridePendingTransition(0, 0);
                }

                @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
                public void onPanelClosed(View view) {
                }
            });
            com.baidu.swan.apps.adaptation.b.c LN = LN();
            if (LN != null) {
                this.mSlideHelper.setRegionFactor(LN.Gl());
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [com.baidu.swan.apps.adaptation.b.d] */
    @Override // com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        com.baidu.swan.apps.core.d.e El;
        com.baidu.swan.apps.adaptation.b.c LN;
        boolean z = true;
        SwanAppActivity swanAppActivity = this.bUc.get();
        if (swanAppActivity == null || !swanAppActivity.Ef() || (El = swanAppActivity.El()) == null || (LN = LN()) == null) {
            return false;
        }
        com.baidu.swan.apps.adaptation.b.f Gs = LN.Gs();
        boolean z2 = (Gs == null || Gs.Gy() == 0 || !Gs.Gy().canGoBack()) ? false : true;
        if (El.Ma() > 1 || !LN.isSlidable(motionEvent) || z2 || !aei()) {
            z = false;
        }
        return z;
    }

    private com.baidu.swan.apps.adaptation.b.c LN() {
        com.baidu.swan.apps.core.d.e El;
        com.baidu.swan.apps.core.d.b LX;
        SwanAppActivity swanAppActivity = this.bUc.get();
        if (swanAppActivity == null || (El = swanAppActivity.El()) == null || (LX = El.LX()) == null) {
            return null;
        }
        return LX instanceof com.baidu.swan.apps.core.d.d ? ((com.baidu.swan.apps.core.d.d) LX).LN() : null;
    }

    private boolean canSlide() {
        SwanAppActivity swanAppActivity = this.bUc.get();
        if (swanAppActivity == null) {
            return false;
        }
        return (swanAppActivity.getResources().getConfiguration().orientation == 2 || Build.VERSION.SDK_INT == 26) ? false : true;
    }

    private boolean aei() {
        SwanAppActivity swanAppActivity = this.bUc.get();
        if (swanAppActivity == null || swanAppActivity.isDestroyed() || !swanAppActivity.Ef()) {
            return false;
        }
        com.baidu.swan.apps.core.d.d LY = swanAppActivity.El().LY();
        if (LY != null) {
            return LY.Lt() == null || !LY.Lt().bMl;
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
    public void aej() {
        if (isNightMode()) {
            this.bUd.setVisibility(8);
        }
    }

    private boolean isNightMode() {
        return com.baidu.swan.apps.w.a.Sc().getNightModeSwitcherState();
    }
}
