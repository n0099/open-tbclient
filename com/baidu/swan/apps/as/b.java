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
/* loaded from: classes11.dex */
public class b implements SlideInterceptor {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private WeakReference<SwanAppActivity> bYh;
    private com.baidu.swan.apps.am.b bYi;
    private BroadcastReceiver bYj = new BroadcastReceiver() { // from class: com.baidu.swan.apps.as.b.1
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
        this.bYh = new WeakReference<>(swanAppActivity);
    }

    public void agu() {
        if (this.bYh.get() != null) {
            this.mSlideHelper.setCanSlide(canSlide());
        }
    }

    public void agv() {
        SwanAppActivity swanAppActivity = this.bYh.get();
        if (swanAppActivity != null) {
            this.bYi = swanAppActivity.GQ();
            if (this.bYi != null) {
                if (isNightMode()) {
                    this.bYi.setVisibility(0);
                }
                agx();
            }
        }
    }

    public void onCreate() {
        SwanAppActivity swanAppActivity = this.bYh.get();
        if (swanAppActivity != null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
            swanAppActivity.registerReceiver(this.bYj, intentFilter);
        }
    }

    public void agw() {
        SwanAppActivity swanAppActivity = this.bYh.get();
        if (swanAppActivity != null) {
            b.a GE = swanAppActivity.GE();
            if ((GE != null && "1230000000000000".equals(GE.VJ())) || swanAppActivity.Gu() == 1) {
                this.mSlideHelper.setCanSlide(false);
            } else {
                this.mSlideHelper.setCanSlide(canSlide());
            }
        }
    }

    public void onResume() {
        if (isNightMode()) {
            this.bYi.setVisibility(0);
        }
    }

    public void onDestroy() {
        SwanAppActivity swanAppActivity;
        if (this.bYh != null && (swanAppActivity = this.bYh.get()) != null) {
            swanAppActivity.unregisterReceiver(this.bYj);
        }
    }

    public void agx() {
        final SwanAppActivity swanAppActivity = this.bYh.get();
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
                        if (swanAppActivity.Gw()) {
                            swanAppActivity.Gv().JL();
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
                    b.this.agz();
                    swanAppActivity.overridePendingTransition(0, 0);
                }

                @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
                public void onPanelClosed(View view) {
                }
            });
            com.baidu.swan.apps.adaptation.b.c Od = Od();
            if (Od != null) {
                this.mSlideHelper.setRegionFactor(Od.IC());
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [com.baidu.swan.apps.adaptation.b.d] */
    @Override // com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        com.baidu.swan.apps.core.d.e GC;
        com.baidu.swan.apps.adaptation.b.c Od;
        boolean z = true;
        SwanAppActivity swanAppActivity = this.bYh.get();
        if (swanAppActivity == null || !swanAppActivity.Gw() || (GC = swanAppActivity.GC()) == null || (Od = Od()) == null) {
            return false;
        }
        com.baidu.swan.apps.adaptation.b.f IJ = Od.IJ();
        boolean z2 = (IJ == null || IJ.IP() == 0 || !IJ.IP().canGoBack()) ? false : true;
        if (GC.Oq() > 1 || !Od.isSlidable(motionEvent) || z2 || !agy()) {
            z = false;
        }
        return z;
    }

    private com.baidu.swan.apps.adaptation.b.c Od() {
        com.baidu.swan.apps.core.d.e GC;
        com.baidu.swan.apps.core.d.b On;
        SwanAppActivity swanAppActivity = this.bYh.get();
        if (swanAppActivity == null || (GC = swanAppActivity.GC()) == null || (On = GC.On()) == null) {
            return null;
        }
        return On instanceof com.baidu.swan.apps.core.d.d ? ((com.baidu.swan.apps.core.d.d) On).Od() : null;
    }

    private boolean canSlide() {
        SwanAppActivity swanAppActivity = this.bYh.get();
        if (swanAppActivity == null) {
            return false;
        }
        return (swanAppActivity.getResources().getConfiguration().orientation == 2 || Build.VERSION.SDK_INT == 26) ? false : true;
    }

    private boolean agy() {
        SwanAppActivity swanAppActivity = this.bYh.get();
        if (swanAppActivity == null || swanAppActivity.isDestroyed() || !swanAppActivity.Gw()) {
            return false;
        }
        com.baidu.swan.apps.core.d.d Oo = swanAppActivity.GC().Oo();
        if (Oo != null) {
            return Oo.NJ() == null || !Oo.NJ().bQr;
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
    public void agz() {
        if (isNightMode()) {
            this.bYi.setVisibility(8);
        }
    }

    private boolean isNightMode() {
        return com.baidu.swan.apps.w.a.Us().getNightModeSwitcherState();
    }
}
