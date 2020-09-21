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
/* loaded from: classes3.dex */
public class d implements SlideInterceptor {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private WeakReference<SwanAppActivity> dcT;
    private com.baidu.swan.apps.aj.b dcU;
    private BroadcastReceiver dcV = new BroadcastReceiver() { // from class: com.baidu.swan.apps.ap.d.1
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
        this.dcT = new WeakReference<>(swanAppActivity);
    }

    public void aFd() {
        if (this.dcT.get() != null) {
            this.mSlideHelper.setCanSlide(canSlide());
        }
    }

    public void aFe() {
        SwanAppActivity swanAppActivity = this.dcT.get();
        if (swanAppActivity != null) {
            this.dcU = swanAppActivity.YS();
            if (this.dcU != null) {
                if (com.baidu.swan.apps.u.a.a.eB(false).booleanValue()) {
                    this.dcU.setVisibility(0);
                }
                aFg();
            }
        }
    }

    public void onCreate() {
        SwanAppActivity swanAppActivity = this.dcT.get();
        if (swanAppActivity != null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
            swanAppActivity.registerReceiver(this.dcV, intentFilter);
        }
    }

    public void aFf() {
        SwanAppActivity swanAppActivity = this.dcT.get();
        if (swanAppActivity != null) {
            b.a YI = swanAppActivity.YI();
            if ((YI != null && "1230000000000000".equals(YI.arx())) || swanAppActivity.Yy() == 1) {
                this.mSlideHelper.setCanSlide(false);
            } else {
                this.mSlideHelper.setCanSlide(canSlide());
            }
        }
    }

    public void onResume() {
        if (com.baidu.swan.apps.u.a.a.eB(true).booleanValue()) {
            this.dcU.setVisibility(0);
        }
    }

    public void onDestroy() {
        SwanAppActivity swanAppActivity;
        if (this.dcT != null && (swanAppActivity = this.dcT.get()) != null) {
            swanAppActivity.unregisterReceiver(this.dcV);
        }
    }

    public void aFg() {
        final SwanAppActivity swanAppActivity = this.dcT.get();
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
                        if (swanAppActivity.YA()) {
                            swanAppActivity.Yz().acB();
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
                    d.this.aFi();
                    swanAppActivity.overridePendingTransition(0, 0);
                }

                @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
                public void onPanelClosed(View view) {
                }
            });
            com.baidu.swan.apps.adaptation.b.c ahL = ahL();
            if (ahL != null) {
                this.mSlideHelper.setRegionFactor(ahL.abm());
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [com.baidu.swan.apps.adaptation.b.d] */
    @Override // com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        com.baidu.swan.apps.core.d.f YG;
        com.baidu.swan.apps.adaptation.b.c ahL;
        boolean z = true;
        SwanAppActivity swanAppActivity = this.dcT.get();
        if (swanAppActivity == null || !swanAppActivity.YA() || (YG = swanAppActivity.YG()) == null || (ahL = ahL()) == null) {
            return false;
        }
        com.baidu.swan.apps.adaptation.b.f abu = ahL.abu();
        boolean z2 = (abu == null || abu.abB() == 0 || !abu.abB().canGoBack()) ? false : true;
        if (YG.ahZ() > 1 || !ahL.isSlidable(motionEvent) || z2 || !aFh()) {
            z = false;
        }
        return z;
    }

    private com.baidu.swan.apps.adaptation.b.c ahL() {
        com.baidu.swan.apps.core.d.f YG;
        com.baidu.swan.apps.core.d.c ahW;
        SwanAppActivity swanAppActivity = this.dcT.get();
        if (swanAppActivity == null || (YG = swanAppActivity.YG()) == null || (ahW = YG.ahW()) == null) {
            return null;
        }
        return ahW instanceof com.baidu.swan.apps.core.d.e ? ((com.baidu.swan.apps.core.d.e) ahW).ahL() : null;
    }

    private boolean canSlide() {
        SwanAppActivity swanAppActivity = this.dcT.get();
        if (swanAppActivity == null) {
            return false;
        }
        return (swanAppActivity.getResources().getConfiguration().orientation == 2 || Build.VERSION.SDK_INT == 26) ? false : true;
    }

    private boolean aFh() {
        SwanAppActivity swanAppActivity = this.dcT.get();
        if (swanAppActivity == null || swanAppActivity.isDestroyed() || !swanAppActivity.YA()) {
            return false;
        }
        com.baidu.swan.apps.core.d.e ahX = swanAppActivity.YG().ahX();
        if (ahX != null) {
            if (ahX.ahl() == null || !ahX.ahl().cTQ) {
                return true;
            }
            com.baidu.swan.apps.setting.oauth.e eVar = com.baidu.swan.apps.network.c.b.a.eZ(true).get("scope_disable_swipe_back");
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
    public void aFi() {
        if (com.baidu.swan.apps.t.a.apQ().getNightModeSwitcherState()) {
            this.dcU.setVisibility(8);
        }
    }
}
