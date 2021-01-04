package com.baidu.swan.apps.ao;

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
/* loaded from: classes9.dex */
public class d implements SlideInterceptor {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private WeakReference<SwanAppActivity> dRq;
    private com.baidu.swan.apps.ai.b dRr;
    private BroadcastReceiver dRs = new BroadcastReceiver() { // from class: com.baidu.swan.apps.ao.d.1
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
        this.dRq = new WeakReference<>(swanAppActivity);
    }

    public void aQW() {
        if (this.dRq.get() != null) {
            this.mSlideHelper.setCanSlide(canSlide());
        }
    }

    public void aQX() {
        SwanAppActivity swanAppActivity = this.dRq.get();
        if (swanAppActivity != null) {
            this.dRr = swanAppActivity.ajE();
            if (this.dRr != null) {
                if (com.baidu.swan.apps.u.a.a.fU(false).booleanValue()) {
                    this.dRr.setVisibility(0);
                }
                aQZ();
            }
        }
    }

    public void onCreate() {
        SwanAppActivity swanAppActivity = this.dRq.get();
        if (swanAppActivity != null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
            swanAppActivity.registerReceiver(this.dRs, intentFilter);
        }
    }

    public void aQY() {
        SwanAppActivity swanAppActivity = this.dRq.get();
        if (swanAppActivity != null) {
            b.a aju = swanAppActivity.aju();
            if ((aju != null && "1230000000000000".equals(aju.aCv())) || swanAppActivity.ajk() == 1) {
                this.mSlideHelper.setCanSlide(false);
            } else {
                this.mSlideHelper.setCanSlide(canSlide());
            }
        }
    }

    public void onResume() {
        if (com.baidu.swan.apps.u.a.a.fU(true).booleanValue()) {
            this.dRr.setVisibility(0);
        }
    }

    public void onDestroy() {
        SwanAppActivity swanAppActivity;
        if (this.dRq != null && (swanAppActivity = this.dRq.get()) != null) {
            swanAppActivity.unregisterReceiver(this.dRs);
        }
    }

    public void aQZ() {
        final SwanAppActivity swanAppActivity = this.dRq.get();
        if (swanAppActivity != null && !swanAppActivity.isDestroyed()) {
            this.mSlideHelper.attachSlideView(swanAppActivity, swanAppActivity.findViewById(16908290), new SlidingPaneLayout.LayoutParams(-1, -1));
            this.mSlideHelper.attachActivity(swanAppActivity);
            this.mSlideHelper.setEnableReleaseWhenNoTranslucent(false);
            this.mSlideHelper.setFadeColor(0);
            this.mSlideHelper.setSlideInterceptor(this);
            this.mSlideHelper.setSlideListener(new SlidingPaneLayout.PanelSlideListener() { // from class: com.baidu.swan.apps.ao.d.2
                @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
                public void onPanelSlide(View view, float f) {
                    View maskView = d.this.mSlideHelper.getMaskView();
                    if (maskView != null) {
                        maskView.setAlpha(1.0f - f);
                        if (swanAppActivity.ajm()) {
                            swanAppActivity.ajl().anr();
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
                    d.this.aRb();
                    swanAppActivity.overridePendingTransition(0, 0);
                }

                @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
                public void onPanelClosed(View view) {
                }
            });
            com.baidu.swan.apps.adaptation.b.c asI = asI();
            if (asI != null) {
                this.mSlideHelper.setRegionFactor(asI.amc());
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [com.baidu.swan.apps.adaptation.b.d] */
    @Override // com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        com.baidu.swan.apps.core.d.f ajs;
        com.baidu.swan.apps.adaptation.b.c asI;
        boolean z = true;
        SwanAppActivity swanAppActivity = this.dRq.get();
        if (swanAppActivity == null || !swanAppActivity.ajm() || (ajs = swanAppActivity.ajs()) == null || (asI = asI()) == null) {
            return false;
        }
        com.baidu.swan.apps.adaptation.b.f amk = asI.amk();
        boolean z2 = (amk == null || amk.amr() == 0 || !amk.amr().canGoBack()) ? false : true;
        if (ajs.asW() > 1 || !asI.isSlidable(motionEvent) || z2 || !aRa()) {
            z = false;
        }
        return z;
    }

    private com.baidu.swan.apps.adaptation.b.c asI() {
        com.baidu.swan.apps.core.d.f ajs;
        com.baidu.swan.apps.core.d.c asT;
        SwanAppActivity swanAppActivity = this.dRq.get();
        if (swanAppActivity == null || (ajs = swanAppActivity.ajs()) == null || (asT = ajs.asT()) == null) {
            return null;
        }
        return asT instanceof com.baidu.swan.apps.core.d.e ? ((com.baidu.swan.apps.core.d.e) asT).asI() : null;
    }

    private boolean canSlide() {
        SwanAppActivity swanAppActivity = this.dRq.get();
        if (swanAppActivity == null) {
            return false;
        }
        return (swanAppActivity.getResources().getConfiguration().orientation == 2 || Build.VERSION.SDK_INT == 26) ? false : true;
    }

    private boolean aRa() {
        SwanAppActivity swanAppActivity = this.dRq.get();
        if (swanAppActivity == null || swanAppActivity.isDestroyed() || !swanAppActivity.ajm()) {
            return false;
        }
        com.baidu.swan.apps.core.d.e asU = swanAppActivity.ajs().asU();
        if (asU != null) {
            if (asU.asf() == null || !asU.asf().dIs) {
                return true;
            }
            com.baidu.swan.apps.setting.oauth.e eVar = com.baidu.swan.apps.network.c.b.a.gs(true).get("scope_disable_swipe_back");
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
    public void aRb() {
        if (com.baidu.swan.apps.t.a.aAN().alD()) {
            this.dRr.setVisibility(8);
        }
    }
}
