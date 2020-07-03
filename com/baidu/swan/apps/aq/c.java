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
    private WeakReference<SwanAppActivity> cOr;
    private com.baidu.swan.apps.ak.b cOs;
    private BroadcastReceiver cOt = new BroadcastReceiver() { // from class: com.baidu.swan.apps.aq.c.1
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
        this.cOr = new WeakReference<>(swanAppActivity);
    }

    public void auh() {
        if (this.cOr.get() != null) {
            this.mSlideHelper.setCanSlide(canSlide());
        }
    }

    public void aui() {
        SwanAppActivity swanAppActivity = this.cOr.get();
        if (swanAppActivity != null) {
            this.cOs = swanAppActivity.RZ();
            if (this.cOs != null) {
                if (isNightMode()) {
                    this.cOs.setVisibility(0);
                }
                auk();
            }
        }
    }

    public void onCreate() {
        SwanAppActivity swanAppActivity = this.cOr.get();
        if (swanAppActivity != null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
            swanAppActivity.registerReceiver(this.cOt, intentFilter);
        }
    }

    public void auj() {
        SwanAppActivity swanAppActivity = this.cOr.get();
        if (swanAppActivity != null) {
            b.a RP = swanAppActivity.RP();
            if ((RP != null && "1230000000000000".equals(RP.ahQ())) || swanAppActivity.RF() == 1) {
                this.mSlideHelper.setCanSlide(false);
            } else {
                this.mSlideHelper.setCanSlide(canSlide());
            }
        }
    }

    public void onResume() {
        if (isNightMode()) {
            this.cOs.setVisibility(0);
        }
    }

    public void onDestroy() {
        SwanAppActivity swanAppActivity;
        if (this.cOr != null && (swanAppActivity = this.cOr.get()) != null) {
            swanAppActivity.unregisterReceiver(this.cOt);
        }
    }

    public void auk() {
        final SwanAppActivity swanAppActivity = this.cOr.get();
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
                        if (swanAppActivity.RH()) {
                            swanAppActivity.RG().Vh();
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
                    c.this.aum();
                    swanAppActivity.overridePendingTransition(0, 0);
                }

                @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
                public void onPanelClosed(View view) {
                }
            });
            com.baidu.swan.apps.adaptation.b.c ZM = ZM();
            if (ZM != null) {
                this.mSlideHelper.setRegionFactor(ZM.Ua());
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [com.baidu.swan.apps.adaptation.b.d] */
    @Override // com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        com.baidu.swan.apps.core.d.e RN;
        com.baidu.swan.apps.adaptation.b.c ZM;
        boolean z = true;
        SwanAppActivity swanAppActivity = this.cOr.get();
        if (swanAppActivity == null || !swanAppActivity.RH() || (RN = swanAppActivity.RN()) == null || (ZM = ZM()) == null) {
            return false;
        }
        com.baidu.swan.apps.adaptation.b.f Uh = ZM.Uh();
        boolean z2 = (Uh == null || Uh.Un() == 0 || !Uh.Un().canGoBack()) ? false : true;
        if (RN.ZY() > 1 || !ZM.isSlidable(motionEvent) || z2 || !aul()) {
            z = false;
        }
        return z;
    }

    private com.baidu.swan.apps.adaptation.b.c ZM() {
        com.baidu.swan.apps.core.d.e RN;
        com.baidu.swan.apps.core.d.b ZV;
        SwanAppActivity swanAppActivity = this.cOr.get();
        if (swanAppActivity == null || (RN = swanAppActivity.RN()) == null || (ZV = RN.ZV()) == null) {
            return null;
        }
        return ZV instanceof com.baidu.swan.apps.core.d.d ? ((com.baidu.swan.apps.core.d.d) ZV).ZM() : null;
    }

    private boolean canSlide() {
        SwanAppActivity swanAppActivity = this.cOr.get();
        if (swanAppActivity == null) {
            return false;
        }
        return (swanAppActivity.getResources().getConfiguration().orientation == 2 || Build.VERSION.SDK_INT == 26) ? false : true;
    }

    private boolean aul() {
        SwanAppActivity swanAppActivity = this.cOr.get();
        if (swanAppActivity == null || swanAppActivity.isDestroyed() || !swanAppActivity.RH()) {
            return false;
        }
        com.baidu.swan.apps.core.d.d ZW = swanAppActivity.RN().ZW();
        if (ZW != null) {
            if (ZW.Zn() == null || !ZW.Zn().cFV) {
                return true;
            }
            com.baidu.swan.apps.setting.oauth.e eVar = com.baidu.swan.apps.network.c.b.a.alU().get("scope_disable_swipe_back");
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
    public void aum() {
        if (isNightMode()) {
            this.cOs.setVisibility(8);
        }
    }

    private boolean isNightMode() {
        return com.baidu.swan.apps.u.a.ags().getNightModeSwitcherState();
    }
}
