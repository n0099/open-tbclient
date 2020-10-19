package com.baidu.swan.apps.ap;

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
import com.baidu.swan.apps.u.c.b;
import java.lang.ref.WeakReference;
/* loaded from: classes10.dex */
public class d implements SlideInterceptor {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private WeakReference<SwanAppActivity> dpc;
    private com.baidu.swan.apps.aj.b dpd;
    private BroadcastReceiver dpe = new BroadcastReceiver() { // from class: com.baidu.swan.apps.ap.d.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(intent.getAction())) {
                String stringExtra = intent.getStringExtra(TiebaInitialize.LogFields.REASON);
                if (!TextUtils.isEmpty(stringExtra)) {
                    if (("homekey".equals(stringExtra) || stringExtra.equals("recentapps")) && d.this.mSlideHelper != null) {
                        d.this.mSlideHelper.closePane();
                        d.this.mSlideHelper.setCanSlide(false);
                    }
                }
            }
        }
    };
    private SlideHelper mSlideHelper = new SlideHelper();

    public d(SwanAppActivity swanAppActivity) {
        this.dpc = new WeakReference<>(swanAppActivity);
    }

    public void aHM() {
        if (this.dpc.get() != null) {
            this.mSlideHelper.setCanSlide(canSlide());
        }
    }

    public void aHN() {
        SwanAppActivity swanAppActivity = this.dpc.get();
        if (swanAppActivity != null) {
            this.dpd = swanAppActivity.abE();
            if (this.dpd != null) {
                if (com.baidu.swan.apps.u.a.a.eX(false).booleanValue()) {
                    this.dpd.setVisibility(0);
                }
                aHP();
            }
        }
    }

    public void onCreate() {
        SwanAppActivity swanAppActivity = this.dpc.get();
        if (swanAppActivity != null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
            swanAppActivity.registerReceiver(this.dpe, intentFilter);
        }
    }

    public void aHO() {
        SwanAppActivity swanAppActivity = this.dpc.get();
        if (swanAppActivity != null) {
            b.a abu = swanAppActivity.abu();
            if ((abu != null && "1230000000000000".equals(abu.auj())) || swanAppActivity.abk() == 1) {
                this.mSlideHelper.setCanSlide(false);
            } else {
                this.mSlideHelper.setCanSlide(canSlide());
            }
        }
    }

    public void onResume() {
        if (com.baidu.swan.apps.u.a.a.eX(true).booleanValue()) {
            this.dpd.setVisibility(0);
        }
    }

    public void onDestroy() {
        SwanAppActivity swanAppActivity;
        if (this.dpc != null && (swanAppActivity = this.dpc.get()) != null) {
            swanAppActivity.unregisterReceiver(this.dpe);
        }
    }

    public void aHP() {
        final SwanAppActivity swanAppActivity = this.dpc.get();
        if (swanAppActivity != null && !swanAppActivity.isDestroyed()) {
            this.mSlideHelper.attachSlideView(swanAppActivity, swanAppActivity.findViewById(16908290), new SlidingPaneLayout.LayoutParams(-1, -1));
            this.mSlideHelper.attachActivity(swanAppActivity);
            this.mSlideHelper.setEnableReleaseWhenNoTranslucent(false);
            this.mSlideHelper.setFadeColor(0);
            this.mSlideHelper.setSlideInterceptor(this);
            this.mSlideHelper.setSlideListener(new SlidingPaneLayout.PanelSlideListener() { // from class: com.baidu.swan.apps.ap.d.2
                @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
                public void onPanelSlide(View view, float f) {
                    View maskView = d.this.mSlideHelper.getMaskView();
                    if (maskView != null) {
                        maskView.setAlpha(1.0f - f);
                        if (swanAppActivity.abm()) {
                            swanAppActivity.abl().afn();
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
                    d.this.aHR();
                    swanAppActivity.overridePendingTransition(0, 0);
                }

                @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
                public void onPanelClosed(View view) {
                }
            });
            com.baidu.swan.apps.adaptation.b.c akw = akw();
            if (akw != null) {
                this.mSlideHelper.setRegionFactor(akw.adY());
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [com.baidu.swan.apps.adaptation.b.d] */
    @Override // com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        com.baidu.swan.apps.core.d.f abs;
        com.baidu.swan.apps.adaptation.b.c akw;
        boolean z = true;
        SwanAppActivity swanAppActivity = this.dpc.get();
        if (swanAppActivity == null || !swanAppActivity.abm() || (abs = swanAppActivity.abs()) == null || (akw = akw()) == null) {
            return false;
        }
        com.baidu.swan.apps.adaptation.b.f aeg = akw.aeg();
        boolean z2 = (aeg == null || aeg.aen() == 0 || !aeg.aen().canGoBack()) ? false : true;
        if (abs.akK() > 1 || !akw.isSlidable(motionEvent) || z2 || !aHQ()) {
            z = false;
        }
        return z;
    }

    private com.baidu.swan.apps.adaptation.b.c akw() {
        com.baidu.swan.apps.core.d.f abs;
        com.baidu.swan.apps.core.d.c akH;
        SwanAppActivity swanAppActivity = this.dpc.get();
        if (swanAppActivity == null || (abs = swanAppActivity.abs()) == null || (akH = abs.akH()) == null) {
            return null;
        }
        return akH instanceof com.baidu.swan.apps.core.d.e ? ((com.baidu.swan.apps.core.d.e) akH).akw() : null;
    }

    private boolean canSlide() {
        SwanAppActivity swanAppActivity = this.dpc.get();
        if (swanAppActivity == null) {
            return false;
        }
        return (swanAppActivity.getResources().getConfiguration().orientation == 2 || Build.VERSION.SDK_INT == 26) ? false : true;
    }

    private boolean aHQ() {
        SwanAppActivity swanAppActivity = this.dpc.get();
        if (swanAppActivity == null || swanAppActivity.isDestroyed() || !swanAppActivity.abm()) {
            return false;
        }
        com.baidu.swan.apps.core.d.e akI = swanAppActivity.abs().akI();
        if (akI != null) {
            if (akI.ajW() == null || !akI.ajW().dfY) {
                return true;
            }
            com.baidu.swan.apps.setting.oauth.e eVar = com.baidu.swan.apps.network.c.b.a.fv(true).get("scope_disable_swipe_back");
            return eVar == null || eVar.forbidden;
        }
        if (DEBUG) {
            Log.d("SwanActivitySlideHelper", "topFragment = null; return false");
        }
        return false;
    }

    public void closePane() {
        this.mSlideHelper.closePane();
    }

    public void setCanSlide(boolean z) {
        this.mSlideHelper.setCanSlide(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHR() {
        if (com.baidu.swan.apps.t.a.asC().getNightModeSwitcherState()) {
            this.dpd.setVisibility(8);
        }
    }
}
