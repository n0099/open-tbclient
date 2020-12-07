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
/* loaded from: classes25.dex */
public class d implements SlideInterceptor {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private WeakReference<SwanAppActivity> dIL;
    private com.baidu.swan.apps.aj.b dIM;
    private BroadcastReceiver dIN = new BroadcastReceiver() { // from class: com.baidu.swan.apps.ap.d.1
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
        this.dIL = new WeakReference<>(swanAppActivity);
    }

    public void aOF() {
        if (this.dIL.get() != null) {
            this.mSlideHelper.setCanSlide(canSlide());
        }
    }

    public void aOG() {
        SwanAppActivity swanAppActivity = this.dIL.get();
        if (swanAppActivity != null) {
            this.dIM = swanAppActivity.aiy();
            if (this.dIM != null) {
                if (com.baidu.swan.apps.u.a.a.fL(false).booleanValue()) {
                    this.dIM.setVisibility(0);
                }
                aOI();
            }
        }
    }

    public void onCreate() {
        SwanAppActivity swanAppActivity = this.dIL.get();
        if (swanAppActivity != null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
            swanAppActivity.registerReceiver(this.dIN, intentFilter);
        }
    }

    public void aOH() {
        SwanAppActivity swanAppActivity = this.dIL.get();
        if (swanAppActivity != null) {
            b.a aio = swanAppActivity.aio();
            if ((aio != null && "1230000000000000".equals(aio.aBe())) || swanAppActivity.aie() == 1) {
                this.mSlideHelper.setCanSlide(false);
            } else {
                this.mSlideHelper.setCanSlide(canSlide());
            }
        }
    }

    public void onResume() {
        if (com.baidu.swan.apps.u.a.a.fL(true).booleanValue()) {
            this.dIM.setVisibility(0);
        }
    }

    public void onDestroy() {
        SwanAppActivity swanAppActivity;
        if (this.dIL != null && (swanAppActivity = this.dIL.get()) != null) {
            swanAppActivity.unregisterReceiver(this.dIN);
        }
    }

    public void aOI() {
        final SwanAppActivity swanAppActivity = this.dIL.get();
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
                        if (swanAppActivity.aig()) {
                            swanAppActivity.aif().amh();
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
                    d.this.aOK();
                    swanAppActivity.overridePendingTransition(0, 0);
                }

                @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
                public void onPanelClosed(View view) {
                }
            });
            com.baidu.swan.apps.adaptation.b.c arq = arq();
            if (arq != null) {
                this.mSlideHelper.setRegionFactor(arq.akS());
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [com.baidu.swan.apps.adaptation.b.d] */
    @Override // com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        com.baidu.swan.apps.core.d.f aim;
        com.baidu.swan.apps.adaptation.b.c arq;
        boolean z = true;
        SwanAppActivity swanAppActivity = this.dIL.get();
        if (swanAppActivity == null || !swanAppActivity.aig() || (aim = swanAppActivity.aim()) == null || (arq = arq()) == null) {
            return false;
        }
        com.baidu.swan.apps.adaptation.b.f ala = arq.ala();
        boolean z2 = (ala == null || ala.alh() == 0 || !ala.alh().canGoBack()) ? false : true;
        if (aim.arE() > 1 || !arq.isSlidable(motionEvent) || z2 || !aOJ()) {
            z = false;
        }
        return z;
    }

    private com.baidu.swan.apps.adaptation.b.c arq() {
        com.baidu.swan.apps.core.d.f aim;
        com.baidu.swan.apps.core.d.c arB;
        SwanAppActivity swanAppActivity = this.dIL.get();
        if (swanAppActivity == null || (aim = swanAppActivity.aim()) == null || (arB = aim.arB()) == null) {
            return null;
        }
        return arB instanceof com.baidu.swan.apps.core.d.e ? ((com.baidu.swan.apps.core.d.e) arB).arq() : null;
    }

    private boolean canSlide() {
        SwanAppActivity swanAppActivity = this.dIL.get();
        if (swanAppActivity == null) {
            return false;
        }
        return (swanAppActivity.getResources().getConfiguration().orientation == 2 || Build.VERSION.SDK_INT == 26) ? false : true;
    }

    private boolean aOJ() {
        SwanAppActivity swanAppActivity = this.dIL.get();
        if (swanAppActivity == null || swanAppActivity.isDestroyed() || !swanAppActivity.aig()) {
            return false;
        }
        com.baidu.swan.apps.core.d.e arC = swanAppActivity.aim().arC();
        if (arC != null) {
            if (arC.aqQ() == null || !arC.aqQ().dzN) {
                return true;
            }
            com.baidu.swan.apps.setting.oauth.e eVar = com.baidu.swan.apps.network.c.b.a.gj(true).get("scope_disable_swipe_back");
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
    public void aOK() {
        if (com.baidu.swan.apps.t.a.azw().getNightModeSwitcherState()) {
            this.dIM.setVisibility(8);
        }
    }
}
