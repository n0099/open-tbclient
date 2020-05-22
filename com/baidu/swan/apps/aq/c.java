package com.baidu.swan.apps.aq;

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
import com.baidu.swan.apps.v.b.b;
import java.lang.ref.WeakReference;
/* loaded from: classes11.dex */
public class c implements SlideInterceptor {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private WeakReference<SwanAppActivity> cJH;
    private com.baidu.swan.apps.ak.b cJI;
    private BroadcastReceiver cJJ = new BroadcastReceiver() { // from class: com.baidu.swan.apps.aq.c.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(intent.getAction())) {
                String stringExtra = intent.getStringExtra(TiebaInitialize.LogFields.REASON);
                if (!TextUtils.isEmpty(stringExtra)) {
                    if (("homekey".equals(stringExtra) || stringExtra.equals("recentapps")) && c.this.mSlideHelper != null) {
                        c.this.mSlideHelper.closePane();
                        c.this.mSlideHelper.setCanSlide(false);
                    }
                }
            }
        }
    };
    private SlideHelper mSlideHelper = new SlideHelper();

    public c(SwanAppActivity swanAppActivity) {
        this.cJH = new WeakReference<>(swanAppActivity);
    }

    public void atb() {
        if (this.cJH.get() != null) {
            this.mSlideHelper.setCanSlide(canSlide());
        }
    }

    public void atc() {
        SwanAppActivity swanAppActivity = this.cJH.get();
        if (swanAppActivity != null) {
            this.cJI = swanAppActivity.QT();
            if (this.cJI != null) {
                if (isNightMode()) {
                    this.cJI.setVisibility(0);
                }
                ate();
            }
        }
    }

    public void onCreate() {
        SwanAppActivity swanAppActivity = this.cJH.get();
        if (swanAppActivity != null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
            swanAppActivity.registerReceiver(this.cJJ, intentFilter);
        }
    }

    public void atd() {
        SwanAppActivity swanAppActivity = this.cJH.get();
        if (swanAppActivity != null) {
            b.a QJ = swanAppActivity.QJ();
            if ((QJ != null && "1230000000000000".equals(QJ.agK())) || swanAppActivity.Qz() == 1) {
                this.mSlideHelper.setCanSlide(false);
            } else {
                this.mSlideHelper.setCanSlide(canSlide());
            }
        }
    }

    public void onResume() {
        if (isNightMode()) {
            this.cJI.setVisibility(0);
        }
    }

    public void onDestroy() {
        SwanAppActivity swanAppActivity;
        if (this.cJH != null && (swanAppActivity = this.cJH.get()) != null) {
            swanAppActivity.unregisterReceiver(this.cJJ);
        }
    }

    public void ate() {
        final SwanAppActivity swanAppActivity = this.cJH.get();
        if (swanAppActivity != null && !swanAppActivity.isDestroyed()) {
            this.mSlideHelper.attachSlideView(swanAppActivity, swanAppActivity.findViewById(16908290), new SlidingPaneLayout.LayoutParams(-1, -1));
            this.mSlideHelper.attachActivity(swanAppActivity);
            this.mSlideHelper.setEnableReleaseWhenNoTranslucent(false);
            this.mSlideHelper.setFadeColor(0);
            this.mSlideHelper.setSlideInterceptor(this);
            this.mSlideHelper.setSlideListener(new SlidingPaneLayout.PanelSlideListener() { // from class: com.baidu.swan.apps.aq.c.2
                @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
                public void onPanelSlide(View view, float f) {
                    View maskView = c.this.mSlideHelper.getMaskView();
                    if (maskView != null) {
                        maskView.setAlpha(1.0f - f);
                        if (swanAppActivity.QB()) {
                            swanAppActivity.QA().Ub();
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
                    c.this.atg();
                    swanAppActivity.overridePendingTransition(0, 0);
                }

                @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
                public void onPanelClosed(View view) {
                }
            });
            com.baidu.swan.apps.adaptation.b.c YG = YG();
            if (YG != null) {
                this.mSlideHelper.setRegionFactor(YG.SU());
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [com.baidu.swan.apps.adaptation.b.d] */
    @Override // com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        com.baidu.swan.apps.core.d.e QH;
        com.baidu.swan.apps.adaptation.b.c YG;
        boolean z = true;
        SwanAppActivity swanAppActivity = this.cJH.get();
        if (swanAppActivity == null || !swanAppActivity.QB() || (QH = swanAppActivity.QH()) == null || (YG = YG()) == null) {
            return false;
        }
        com.baidu.swan.apps.adaptation.b.f Tb = YG.Tb();
        boolean z2 = (Tb == null || Tb.Th() == 0 || !Tb.Th().canGoBack()) ? false : true;
        if (QH.YS() > 1 || !YG.isSlidable(motionEvent) || z2 || !atf()) {
            z = false;
        }
        return z;
    }

    private com.baidu.swan.apps.adaptation.b.c YG() {
        com.baidu.swan.apps.core.d.e QH;
        com.baidu.swan.apps.core.d.b YP;
        SwanAppActivity swanAppActivity = this.cJH.get();
        if (swanAppActivity == null || (QH = swanAppActivity.QH()) == null || (YP = QH.YP()) == null) {
            return null;
        }
        return YP instanceof com.baidu.swan.apps.core.d.d ? ((com.baidu.swan.apps.core.d.d) YP).YG() : null;
    }

    private boolean canSlide() {
        SwanAppActivity swanAppActivity = this.cJH.get();
        if (swanAppActivity == null) {
            return false;
        }
        return (swanAppActivity.getResources().getConfiguration().orientation == 2 || Build.VERSION.SDK_INT == 26) ? false : true;
    }

    private boolean atf() {
        SwanAppActivity swanAppActivity = this.cJH.get();
        if (swanAppActivity == null || swanAppActivity.isDestroyed() || !swanAppActivity.QB()) {
            return false;
        }
        com.baidu.swan.apps.core.d.d YQ = swanAppActivity.QH().YQ();
        if (YQ != null) {
            if (YQ.Yh() == null || !YQ.Yh().cBl) {
                return true;
            }
            com.baidu.swan.apps.setting.oauth.e eVar = com.baidu.swan.apps.network.c.b.a.akO().get("scope_disable_swipe_back");
            return eVar == null || eVar.forbidden;
        }
        if (DEBUG) {
            Log.d("SwanAppActivitySlideHelper", "topFragment = null; return false");
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
    public void atg() {
        if (isNightMode()) {
            this.cJI.setVisibility(8);
        }
    }

    private boolean isNightMode() {
        return com.baidu.swan.apps.u.a.afm().getNightModeSwitcherState();
    }
}
