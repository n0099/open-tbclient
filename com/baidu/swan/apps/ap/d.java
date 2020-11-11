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
    private WeakReference<SwanAppActivity> dDu;
    private com.baidu.swan.apps.aj.b dDv;
    private BroadcastReceiver dDw = new BroadcastReceiver() { // from class: com.baidu.swan.apps.ap.d.1
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
        this.dDu = new WeakReference<>(swanAppActivity);
    }

    public void aMg() {
        if (this.dDu.get() != null) {
            this.mSlideHelper.setCanSlide(canSlide());
        }
    }

    public void aMh() {
        SwanAppActivity swanAppActivity = this.dDu.get();
        if (swanAppActivity != null) {
            this.dDv = swanAppActivity.afY();
            if (this.dDv != null) {
                if (com.baidu.swan.apps.u.a.a.ft(false).booleanValue()) {
                    this.dDv.setVisibility(0);
                }
                aMj();
            }
        }
    }

    public void onCreate() {
        SwanAppActivity swanAppActivity = this.dDu.get();
        if (swanAppActivity != null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
            swanAppActivity.registerReceiver(this.dDw, intentFilter);
        }
    }

    public void aMi() {
        SwanAppActivity swanAppActivity = this.dDu.get();
        if (swanAppActivity != null) {
            b.a afO = swanAppActivity.afO();
            if ((afO != null && "1230000000000000".equals(afO.ayD())) || swanAppActivity.afE() == 1) {
                this.mSlideHelper.setCanSlide(false);
            } else {
                this.mSlideHelper.setCanSlide(canSlide());
            }
        }
    }

    public void onResume() {
        if (com.baidu.swan.apps.u.a.a.ft(true).booleanValue()) {
            this.dDv.setVisibility(0);
        }
    }

    public void onDestroy() {
        SwanAppActivity swanAppActivity;
        if (this.dDu != null && (swanAppActivity = this.dDu.get()) != null) {
            swanAppActivity.unregisterReceiver(this.dDw);
        }
    }

    public void aMj() {
        final SwanAppActivity swanAppActivity = this.dDu.get();
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
                        if (swanAppActivity.afG()) {
                            swanAppActivity.afF().ajH();
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
                    d.this.aMl();
                    swanAppActivity.overridePendingTransition(0, 0);
                }

                @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
                public void onPanelClosed(View view) {
                }
            });
            com.baidu.swan.apps.adaptation.b.c aoQ = aoQ();
            if (aoQ != null) {
                this.mSlideHelper.setRegionFactor(aoQ.ais());
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [com.baidu.swan.apps.adaptation.b.d] */
    @Override // com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        com.baidu.swan.apps.core.d.f afM;
        com.baidu.swan.apps.adaptation.b.c aoQ;
        boolean z = true;
        SwanAppActivity swanAppActivity = this.dDu.get();
        if (swanAppActivity == null || !swanAppActivity.afG() || (afM = swanAppActivity.afM()) == null || (aoQ = aoQ()) == null) {
            return false;
        }
        com.baidu.swan.apps.adaptation.b.f aiA = aoQ.aiA();
        boolean z2 = (aiA == null || aiA.aiH() == 0 || !aiA.aiH().canGoBack()) ? false : true;
        if (afM.ape() > 1 || !aoQ.isSlidable(motionEvent) || z2 || !aMk()) {
            z = false;
        }
        return z;
    }

    private com.baidu.swan.apps.adaptation.b.c aoQ() {
        com.baidu.swan.apps.core.d.f afM;
        com.baidu.swan.apps.core.d.c apb;
        SwanAppActivity swanAppActivity = this.dDu.get();
        if (swanAppActivity == null || (afM = swanAppActivity.afM()) == null || (apb = afM.apb()) == null) {
            return null;
        }
        return apb instanceof com.baidu.swan.apps.core.d.e ? ((com.baidu.swan.apps.core.d.e) apb).aoQ() : null;
    }

    private boolean canSlide() {
        SwanAppActivity swanAppActivity = this.dDu.get();
        if (swanAppActivity == null) {
            return false;
        }
        return (swanAppActivity.getResources().getConfiguration().orientation == 2 || Build.VERSION.SDK_INT == 26) ? false : true;
    }

    private boolean aMk() {
        SwanAppActivity swanAppActivity = this.dDu.get();
        if (swanAppActivity == null || swanAppActivity.isDestroyed() || !swanAppActivity.afG()) {
            return false;
        }
        com.baidu.swan.apps.core.d.e apc = swanAppActivity.afM().apc();
        if (apc != null) {
            if (apc.aoq() == null || !apc.aoq().duv) {
                return true;
            }
            com.baidu.swan.apps.setting.oauth.e eVar = com.baidu.swan.apps.network.c.b.a.fR(true).get("scope_disable_swipe_back");
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
    public void aMl() {
        if (com.baidu.swan.apps.t.a.awW().getNightModeSwitcherState()) {
            this.dDv.setVisibility(8);
        }
    }
}
