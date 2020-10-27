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
    private WeakReference<SwanAppActivity> dxC;
    private com.baidu.swan.apps.aj.b dxD;
    private BroadcastReceiver dxE = new BroadcastReceiver() { // from class: com.baidu.swan.apps.ap.d.1
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
        this.dxC = new WeakReference<>(swanAppActivity);
    }

    public void aJG() {
        if (this.dxC.get() != null) {
            this.mSlideHelper.setCanSlide(canSlide());
        }
    }

    public void aJH() {
        SwanAppActivity swanAppActivity = this.dxC.get();
        if (swanAppActivity != null) {
            this.dxD = swanAppActivity.ady();
            if (this.dxD != null) {
                if (com.baidu.swan.apps.u.a.a.fk(false).booleanValue()) {
                    this.dxD.setVisibility(0);
                }
                aJJ();
            }
        }
    }

    public void onCreate() {
        SwanAppActivity swanAppActivity = this.dxC.get();
        if (swanAppActivity != null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
            swanAppActivity.registerReceiver(this.dxE, intentFilter);
        }
    }

    public void aJI() {
        SwanAppActivity swanAppActivity = this.dxC.get();
        if (swanAppActivity != null) {
            b.a ado = swanAppActivity.ado();
            if ((ado != null && "1230000000000000".equals(ado.awd())) || swanAppActivity.ade() == 1) {
                this.mSlideHelper.setCanSlide(false);
            } else {
                this.mSlideHelper.setCanSlide(canSlide());
            }
        }
    }

    public void onResume() {
        if (com.baidu.swan.apps.u.a.a.fk(true).booleanValue()) {
            this.dxD.setVisibility(0);
        }
    }

    public void onDestroy() {
        SwanAppActivity swanAppActivity;
        if (this.dxC != null && (swanAppActivity = this.dxC.get()) != null) {
            swanAppActivity.unregisterReceiver(this.dxE);
        }
    }

    public void aJJ() {
        final SwanAppActivity swanAppActivity = this.dxC.get();
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
                        if (swanAppActivity.adg()) {
                            swanAppActivity.adf().ahh();
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
                    d.this.aJL();
                    swanAppActivity.overridePendingTransition(0, 0);
                }

                @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
                public void onPanelClosed(View view) {
                }
            });
            com.baidu.swan.apps.adaptation.b.c amq = amq();
            if (amq != null) {
                this.mSlideHelper.setRegionFactor(amq.afS());
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [com.baidu.swan.apps.adaptation.b.d] */
    @Override // com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        com.baidu.swan.apps.core.d.f adm;
        com.baidu.swan.apps.adaptation.b.c amq;
        boolean z = true;
        SwanAppActivity swanAppActivity = this.dxC.get();
        if (swanAppActivity == null || !swanAppActivity.adg() || (adm = swanAppActivity.adm()) == null || (amq = amq()) == null) {
            return false;
        }
        com.baidu.swan.apps.adaptation.b.f aga = amq.aga();
        boolean z2 = (aga == null || aga.agh() == 0 || !aga.agh().canGoBack()) ? false : true;
        if (adm.amE() > 1 || !amq.isSlidable(motionEvent) || z2 || !aJK()) {
            z = false;
        }
        return z;
    }

    private com.baidu.swan.apps.adaptation.b.c amq() {
        com.baidu.swan.apps.core.d.f adm;
        com.baidu.swan.apps.core.d.c amB;
        SwanAppActivity swanAppActivity = this.dxC.get();
        if (swanAppActivity == null || (adm = swanAppActivity.adm()) == null || (amB = adm.amB()) == null) {
            return null;
        }
        return amB instanceof com.baidu.swan.apps.core.d.e ? ((com.baidu.swan.apps.core.d.e) amB).amq() : null;
    }

    private boolean canSlide() {
        SwanAppActivity swanAppActivity = this.dxC.get();
        if (swanAppActivity == null) {
            return false;
        }
        return (swanAppActivity.getResources().getConfiguration().orientation == 2 || Build.VERSION.SDK_INT == 26) ? false : true;
    }

    private boolean aJK() {
        SwanAppActivity swanAppActivity = this.dxC.get();
        if (swanAppActivity == null || swanAppActivity.isDestroyed() || !swanAppActivity.adg()) {
            return false;
        }
        com.baidu.swan.apps.core.d.e amC = swanAppActivity.adm().amC();
        if (amC != null) {
            if (amC.alQ() == null || !amC.alQ().doA) {
                return true;
            }
            com.baidu.swan.apps.setting.oauth.e eVar = com.baidu.swan.apps.network.c.b.a.fI(true).get("scope_disable_swipe_back");
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
    public void aJL() {
        if (com.baidu.swan.apps.t.a.auw().getNightModeSwitcherState()) {
            this.dxD.setVisibility(8);
        }
    }
}
