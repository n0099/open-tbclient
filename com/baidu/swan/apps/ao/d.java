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
    private WeakReference<SwanAppActivity> dQj;
    private com.baidu.swan.apps.ai.b dQk;
    private BroadcastReceiver dQl = new BroadcastReceiver() { // from class: com.baidu.swan.apps.ao.d.1
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
        this.dQj = new WeakReference<>(swanAppActivity);
    }

    public void aNz() {
        if (this.dQj.get() != null) {
            this.mSlideHelper.setCanSlide(canSlide());
        }
    }

    public void aNA() {
        SwanAppActivity swanAppActivity = this.dQj.get();
        if (swanAppActivity != null) {
            this.dQk = swanAppActivity.agm();
            if (this.dQk != null) {
                if (com.baidu.swan.apps.u.a.a.fS(false).booleanValue()) {
                    this.dQk.setVisibility(0);
                }
                aNC();
            }
        }
    }

    public void onCreate() {
        SwanAppActivity swanAppActivity = this.dQj.get();
        if (swanAppActivity != null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
            swanAppActivity.registerReceiver(this.dQl, intentFilter);
        }
    }

    public void aNB() {
        SwanAppActivity swanAppActivity = this.dQj.get();
        if (swanAppActivity != null) {
            b.a agc = swanAppActivity.agc();
            if ((agc != null && "1230000000000000".equals(agc.azd())) || swanAppActivity.getFrameType() == 1) {
                this.mSlideHelper.setCanSlide(false);
            } else {
                this.mSlideHelper.setCanSlide(canSlide());
            }
        }
    }

    public void onResume() {
        if (com.baidu.swan.apps.u.a.a.fS(true).booleanValue()) {
            this.dQk.setVisibility(0);
        }
    }

    public void onDestroy() {
        SwanAppActivity swanAppActivity;
        if (this.dQj != null && (swanAppActivity = this.dQj.get()) != null) {
            swanAppActivity.unregisterReceiver(this.dQl);
        }
    }

    public void aNC() {
        final SwanAppActivity swanAppActivity = this.dQj.get();
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
                        if (swanAppActivity.afU()) {
                            swanAppActivity.afT().ajZ();
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
                    d.this.aNE();
                    swanAppActivity.overridePendingTransition(0, 0);
                }

                @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
                public void onPanelClosed(View view) {
                }
            });
            com.baidu.swan.apps.adaptation.b.c app = app();
            if (app != null) {
                this.mSlideHelper.setRegionFactor(app.aiK());
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [com.baidu.swan.apps.adaptation.b.d] */
    @Override // com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        com.baidu.swan.apps.core.d.f aga;
        com.baidu.swan.apps.adaptation.b.c app;
        boolean z = true;
        SwanAppActivity swanAppActivity = this.dQj.get();
        if (swanAppActivity == null || !swanAppActivity.afU() || (aga = swanAppActivity.aga()) == null || (app = app()) == null) {
            return false;
        }
        com.baidu.swan.apps.adaptation.b.f aiS = app.aiS();
        boolean z2 = (aiS == null || aiS.aiZ() == 0 || !aiS.aiZ().canGoBack()) ? false : true;
        if (aga.apD() > 1 || !app.isSlidable(motionEvent) || z2 || !aND()) {
            z = false;
        }
        return z;
    }

    private com.baidu.swan.apps.adaptation.b.c app() {
        com.baidu.swan.apps.core.d.f aga;
        com.baidu.swan.apps.core.d.c apA;
        SwanAppActivity swanAppActivity = this.dQj.get();
        if (swanAppActivity == null || (aga = swanAppActivity.aga()) == null || (apA = aga.apA()) == null) {
            return null;
        }
        return apA instanceof com.baidu.swan.apps.core.d.e ? ((com.baidu.swan.apps.core.d.e) apA).app() : null;
    }

    private boolean canSlide() {
        SwanAppActivity swanAppActivity = this.dQj.get();
        if (swanAppActivity == null) {
            return false;
        }
        return (swanAppActivity.getResources().getConfiguration().orientation == 2 || Build.VERSION.SDK_INT == 26) ? false : true;
    }

    private boolean aND() {
        SwanAppActivity swanAppActivity = this.dQj.get();
        if (swanAppActivity == null || swanAppActivity.isDestroyed() || !swanAppActivity.afU()) {
            return false;
        }
        com.baidu.swan.apps.core.d.e apB = swanAppActivity.aga().apB();
        if (apB != null) {
            if (apB.aoM() == null || !apB.aoM().dHl) {
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
    public void aNE() {
        if (com.baidu.swan.apps.t.a.axv().ail()) {
            this.dQk.setVisibility(8);
        }
    }
}
