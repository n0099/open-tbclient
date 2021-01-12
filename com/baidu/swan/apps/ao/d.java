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
/* loaded from: classes8.dex */
public class d implements SlideInterceptor {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private WeakReference<SwanAppActivity> dME;
    private com.baidu.swan.apps.ai.b dMF;
    private BroadcastReceiver dMG = new BroadcastReceiver() { // from class: com.baidu.swan.apps.ao.d.1
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
        this.dME = new WeakReference<>(swanAppActivity);
    }

    public void aNd() {
        if (this.dME.get() != null) {
            this.mSlideHelper.setCanSlide(canSlide());
        }
    }

    public void aNe() {
        SwanAppActivity swanAppActivity = this.dME.get();
        if (swanAppActivity != null) {
            this.dMF = swanAppActivity.afL();
            if (this.dMF != null) {
                if (com.baidu.swan.apps.u.a.a.fQ(false).booleanValue()) {
                    this.dMF.setVisibility(0);
                }
                aNg();
            }
        }
    }

    public void onCreate() {
        SwanAppActivity swanAppActivity = this.dME.get();
        if (swanAppActivity != null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
            swanAppActivity.registerReceiver(this.dMG, intentFilter);
        }
    }

    public void aNf() {
        SwanAppActivity swanAppActivity = this.dME.get();
        if (swanAppActivity != null) {
            b.a afB = swanAppActivity.afB();
            if ((afB != null && "1230000000000000".equals(afB.ayC())) || swanAppActivity.afr() == 1) {
                this.mSlideHelper.setCanSlide(false);
            } else {
                this.mSlideHelper.setCanSlide(canSlide());
            }
        }
    }

    public void onResume() {
        if (com.baidu.swan.apps.u.a.a.fQ(true).booleanValue()) {
            this.dMF.setVisibility(0);
        }
    }

    public void onDestroy() {
        SwanAppActivity swanAppActivity;
        if (this.dME != null && (swanAppActivity = this.dME.get()) != null) {
            swanAppActivity.unregisterReceiver(this.dMG);
        }
    }

    public void aNg() {
        final SwanAppActivity swanAppActivity = this.dME.get();
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
                        if (swanAppActivity.aft()) {
                            swanAppActivity.afs().ajy();
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
                    d.this.aNi();
                    swanAppActivity.overridePendingTransition(0, 0);
                }

                @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
                public void onPanelClosed(View view) {
                }
            });
            com.baidu.swan.apps.adaptation.b.c aoN = aoN();
            if (aoN != null) {
                this.mSlideHelper.setRegionFactor(aoN.aij());
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [com.baidu.swan.apps.adaptation.b.d] */
    @Override // com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        com.baidu.swan.apps.core.d.f afz;
        com.baidu.swan.apps.adaptation.b.c aoN;
        boolean z = true;
        SwanAppActivity swanAppActivity = this.dME.get();
        if (swanAppActivity == null || !swanAppActivity.aft() || (afz = swanAppActivity.afz()) == null || (aoN = aoN()) == null) {
            return false;
        }
        com.baidu.swan.apps.adaptation.b.f air = aoN.air();
        boolean z2 = (air == null || air.aiy() == 0 || !air.aiy().canGoBack()) ? false : true;
        if (afz.apb() > 1 || !aoN.isSlidable(motionEvent) || z2 || !aNh()) {
            z = false;
        }
        return z;
    }

    private com.baidu.swan.apps.adaptation.b.c aoN() {
        com.baidu.swan.apps.core.d.f afz;
        com.baidu.swan.apps.core.d.c aoY;
        SwanAppActivity swanAppActivity = this.dME.get();
        if (swanAppActivity == null || (afz = swanAppActivity.afz()) == null || (aoY = afz.aoY()) == null) {
            return null;
        }
        return aoY instanceof com.baidu.swan.apps.core.d.e ? ((com.baidu.swan.apps.core.d.e) aoY).aoN() : null;
    }

    private boolean canSlide() {
        SwanAppActivity swanAppActivity = this.dME.get();
        if (swanAppActivity == null) {
            return false;
        }
        return (swanAppActivity.getResources().getConfiguration().orientation == 2 || Build.VERSION.SDK_INT == 26) ? false : true;
    }

    private boolean aNh() {
        SwanAppActivity swanAppActivity = this.dME.get();
        if (swanAppActivity == null || swanAppActivity.isDestroyed() || !swanAppActivity.aft()) {
            return false;
        }
        com.baidu.swan.apps.core.d.e aoZ = swanAppActivity.afz().aoZ();
        if (aoZ != null) {
            if (aoZ.aol() == null || !aoZ.aol().dDG) {
                return true;
            }
            com.baidu.swan.apps.setting.oauth.e eVar = com.baidu.swan.apps.network.c.b.a.go(true).get("scope_disable_swipe_back");
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
    public void aNi() {
        if (com.baidu.swan.apps.t.a.awU().ahK()) {
            this.dMF.setVisibility(8);
        }
    }
}
