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
    private WeakReference<SwanAppActivity> dOI;
    private com.baidu.swan.apps.ai.b dOJ;
    private BroadcastReceiver dOK = new BroadcastReceiver() { // from class: com.baidu.swan.apps.ao.d.1
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
        this.dOI = new WeakReference<>(swanAppActivity);
    }

    public void aNw() {
        if (this.dOI.get() != null) {
            this.mSlideHelper.setCanSlide(canSlide());
        }
    }

    public void aNx() {
        SwanAppActivity swanAppActivity = this.dOI.get();
        if (swanAppActivity != null) {
            this.dOJ = swanAppActivity.agj();
            if (this.dOJ != null) {
                if (com.baidu.swan.apps.u.a.a.fS(false).booleanValue()) {
                    this.dOJ.setVisibility(0);
                }
                aNz();
            }
        }
    }

    public void onCreate() {
        SwanAppActivity swanAppActivity = this.dOI.get();
        if (swanAppActivity != null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
            swanAppActivity.registerReceiver(this.dOK, intentFilter);
        }
    }

    public void aNy() {
        SwanAppActivity swanAppActivity = this.dOI.get();
        if (swanAppActivity != null) {
            b.a afZ = swanAppActivity.afZ();
            if ((afZ != null && "1230000000000000".equals(afZ.aza())) || swanAppActivity.getFrameType() == 1) {
                this.mSlideHelper.setCanSlide(false);
            } else {
                this.mSlideHelper.setCanSlide(canSlide());
            }
        }
    }

    public void onResume() {
        if (com.baidu.swan.apps.u.a.a.fS(true).booleanValue()) {
            this.dOJ.setVisibility(0);
        }
    }

    public void onDestroy() {
        SwanAppActivity swanAppActivity;
        if (this.dOI != null && (swanAppActivity = this.dOI.get()) != null) {
            swanAppActivity.unregisterReceiver(this.dOK);
        }
    }

    public void aNz() {
        final SwanAppActivity swanAppActivity = this.dOI.get();
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
                        if (swanAppActivity.afR()) {
                            swanAppActivity.afQ().ajW();
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
                    d.this.aNB();
                    swanAppActivity.overridePendingTransition(0, 0);
                }

                @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
                public void onPanelClosed(View view) {
                }
            });
            com.baidu.swan.apps.adaptation.b.c apm = apm();
            if (apm != null) {
                this.mSlideHelper.setRegionFactor(apm.aiH());
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [com.baidu.swan.apps.adaptation.b.d] */
    @Override // com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        com.baidu.swan.apps.core.d.f afX;
        com.baidu.swan.apps.adaptation.b.c apm;
        boolean z = true;
        SwanAppActivity swanAppActivity = this.dOI.get();
        if (swanAppActivity == null || !swanAppActivity.afR() || (afX = swanAppActivity.afX()) == null || (apm = apm()) == null) {
            return false;
        }
        com.baidu.swan.apps.adaptation.b.f aiP = apm.aiP();
        boolean z2 = (aiP == null || aiP.aiW() == 0 || !aiP.aiW().canGoBack()) ? false : true;
        if (afX.apA() > 1 || !apm.isSlidable(motionEvent) || z2 || !aNA()) {
            z = false;
        }
        return z;
    }

    private com.baidu.swan.apps.adaptation.b.c apm() {
        com.baidu.swan.apps.core.d.f afX;
        com.baidu.swan.apps.core.d.c apx;
        SwanAppActivity swanAppActivity = this.dOI.get();
        if (swanAppActivity == null || (afX = swanAppActivity.afX()) == null || (apx = afX.apx()) == null) {
            return null;
        }
        return apx instanceof com.baidu.swan.apps.core.d.e ? ((com.baidu.swan.apps.core.d.e) apx).apm() : null;
    }

    private boolean canSlide() {
        SwanAppActivity swanAppActivity = this.dOI.get();
        if (swanAppActivity == null) {
            return false;
        }
        return (swanAppActivity.getResources().getConfiguration().orientation == 2 || Build.VERSION.SDK_INT == 26) ? false : true;
    }

    private boolean aNA() {
        SwanAppActivity swanAppActivity = this.dOI.get();
        if (swanAppActivity == null || swanAppActivity.isDestroyed() || !swanAppActivity.afR()) {
            return false;
        }
        com.baidu.swan.apps.core.d.e apy = swanAppActivity.afX().apy();
        if (apy != null) {
            if (apy.aoJ() == null || !apy.aoJ().dFK) {
                return true;
            }
            com.baidu.swan.apps.setting.oauth.e eVar = com.baidu.swan.apps.network.c.b.a.gq(true).get("scope_disable_swipe_back");
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
    public void aNB() {
        if (com.baidu.swan.apps.t.a.axs().aii()) {
            this.dOJ.setVisibility(8);
        }
    }
}
