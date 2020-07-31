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
import com.baidu.swan.apps.u.c.b;
import java.lang.ref.WeakReference;
/* loaded from: classes7.dex */
public class d implements SlideInterceptor {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private WeakReference<SwanAppActivity> cRO;
    private com.baidu.swan.apps.ak.b cRP;
    private BroadcastReceiver cRQ = new BroadcastReceiver() { // from class: com.baidu.swan.apps.aq.d.1
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
        this.cRO = new WeakReference<>(swanAppActivity);
    }

    public void awj() {
        if (this.cRO.get() != null) {
            this.mSlideHelper.setCanSlide(canSlide());
        }
    }

    public void awk() {
        SwanAppActivity swanAppActivity = this.cRO.get();
        if (swanAppActivity != null) {
            this.cRP = swanAppActivity.So();
            if (this.cRP != null) {
                if (com.baidu.swan.apps.u.a.a.ek(false).booleanValue()) {
                    this.cRP.setVisibility(0);
                }
                awm();
            }
        }
    }

    public void onCreate() {
        SwanAppActivity swanAppActivity = this.cRO.get();
        if (swanAppActivity != null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
            swanAppActivity.registerReceiver(this.cRQ, intentFilter);
        }
    }

    public void awl() {
        SwanAppActivity swanAppActivity = this.cRO.get();
        if (swanAppActivity != null) {
            b.a Se = swanAppActivity.Se();
            if ((Se != null && "1230000000000000".equals(Se.ajg())) || swanAppActivity.RU() == 1) {
                this.mSlideHelper.setCanSlide(false);
            } else {
                this.mSlideHelper.setCanSlide(canSlide());
            }
        }
    }

    public void onResume() {
        if (com.baidu.swan.apps.u.a.a.ek(true).booleanValue()) {
            this.cRP.setVisibility(0);
        }
    }

    public void onDestroy() {
        SwanAppActivity swanAppActivity;
        if (this.cRO != null && (swanAppActivity = this.cRO.get()) != null) {
            swanAppActivity.unregisterReceiver(this.cRQ);
        }
    }

    public void awm() {
        final SwanAppActivity swanAppActivity = this.cRO.get();
        if (swanAppActivity != null && !swanAppActivity.isDestroyed()) {
            this.mSlideHelper.attachSlideView(swanAppActivity, swanAppActivity.findViewById(16908290), new SlidingPaneLayout.LayoutParams(-1, -1));
            this.mSlideHelper.attachActivity(swanAppActivity);
            this.mSlideHelper.setEnableReleaseWhenNoTranslucent(false);
            this.mSlideHelper.setFadeColor(0);
            this.mSlideHelper.setSlideInterceptor(this);
            this.mSlideHelper.setSlideListener(new SlidingPaneLayout.PanelSlideListener() { // from class: com.baidu.swan.apps.aq.d.2
                @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
                public void onPanelSlide(View view, float f) {
                    View maskView = d.this.mSlideHelper.getMaskView();
                    if (maskView != null) {
                        maskView.setAlpha(1.0f - f);
                        if (swanAppActivity.RW()) {
                            swanAppActivity.RV().VM();
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
                    d.this.awo();
                    swanAppActivity.overridePendingTransition(0, 0);
                }

                @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
                public void onPanelClosed(View view) {
                }
            });
            com.baidu.swan.apps.adaptation.b.c aaQ = aaQ();
            if (aaQ != null) {
                this.mSlideHelper.setRegionFactor(aaQ.UB());
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [com.baidu.swan.apps.adaptation.b.d] */
    @Override // com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        com.baidu.swan.apps.core.d.f Sc;
        com.baidu.swan.apps.adaptation.b.c aaQ;
        boolean z = true;
        SwanAppActivity swanAppActivity = this.cRO.get();
        if (swanAppActivity == null || !swanAppActivity.RW() || (Sc = swanAppActivity.Sc()) == null || (aaQ = aaQ()) == null) {
            return false;
        }
        com.baidu.swan.apps.adaptation.b.f UI = aaQ.UI();
        boolean z2 = (UI == null || UI.UP() == 0 || !UI.UP().canGoBack()) ? false : true;
        if (Sc.abc() > 1 || !aaQ.isSlidable(motionEvent) || z2 || !awn()) {
            z = false;
        }
        return z;
    }

    private com.baidu.swan.apps.adaptation.b.c aaQ() {
        com.baidu.swan.apps.core.d.f Sc;
        com.baidu.swan.apps.core.d.c aaZ;
        SwanAppActivity swanAppActivity = this.cRO.get();
        if (swanAppActivity == null || (Sc = swanAppActivity.Sc()) == null || (aaZ = Sc.aaZ()) == null) {
            return null;
        }
        return aaZ instanceof com.baidu.swan.apps.core.d.e ? ((com.baidu.swan.apps.core.d.e) aaZ).aaQ() : null;
    }

    private boolean canSlide() {
        SwanAppActivity swanAppActivity = this.cRO.get();
        if (swanAppActivity == null) {
            return false;
        }
        return (swanAppActivity.getResources().getConfiguration().orientation == 2 || Build.VERSION.SDK_INT == 26) ? false : true;
    }

    private boolean awn() {
        SwanAppActivity swanAppActivity = this.cRO.get();
        if (swanAppActivity == null || swanAppActivity.isDestroyed() || !swanAppActivity.RW()) {
            return false;
        }
        com.baidu.swan.apps.core.d.e aba = swanAppActivity.Sc().aba();
        if (aba != null) {
            if (aba.aar() == null || !aba.aar().cIN) {
                return true;
            }
            com.baidu.swan.apps.setting.oauth.e eVar = com.baidu.swan.apps.network.c.b.a.ank().get("scope_disable_swipe_back");
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
    public void awo() {
        if (com.baidu.swan.apps.t.a.ahF().getNightModeSwitcherState()) {
            this.cRP.setVisibility(8);
        }
    }
}
