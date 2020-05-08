package com.baidu.swan.apps.as;

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
import com.baidu.swan.apps.x.b.b;
import java.lang.ref.WeakReference;
/* loaded from: classes11.dex */
public class b implements SlideInterceptor {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private WeakReference<SwanAppActivity> cxr;
    private com.baidu.swan.apps.am.b cxs;
    private BroadcastReceiver cxt = new BroadcastReceiver() { // from class: com.baidu.swan.apps.as.b.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(intent.getAction())) {
                String stringExtra = intent.getStringExtra(TiebaInitialize.LogFields.REASON);
                if (!TextUtils.isEmpty(stringExtra)) {
                    if (("homekey".equals(stringExtra) || stringExtra.equals("recentapps")) && b.this.mSlideHelper != null) {
                        b.this.mSlideHelper.closePane();
                        b.this.mSlideHelper.setCanSlide(false);
                    }
                }
            }
        }
    };
    private SlideHelper mSlideHelper = new SlideHelper();

    public b(SwanAppActivity swanAppActivity) {
        this.cxr = new WeakReference<>(swanAppActivity);
    }

    public void aoB() {
        if (this.cxr.get() != null) {
            this.mSlideHelper.setCanSlide(canSlide());
        }
    }

    public void aoC() {
        SwanAppActivity swanAppActivity = this.cxr.get();
        if (swanAppActivity != null) {
            this.cxs = swanAppActivity.OH();
            if (this.cxs != null) {
                if (isNightMode()) {
                    this.cxs.setVisibility(0);
                }
                aoE();
            }
        }
    }

    public void onCreate() {
        SwanAppActivity swanAppActivity = this.cxr.get();
        if (swanAppActivity != null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
            swanAppActivity.registerReceiver(this.cxt, intentFilter);
        }
    }

    public void aoD() {
        SwanAppActivity swanAppActivity = this.cxr.get();
        if (swanAppActivity != null) {
            b.a Ov = swanAppActivity.Ov();
            if ((Ov != null && "1230000000000000".equals(Ov.adA())) || swanAppActivity.Ol() == 1) {
                this.mSlideHelper.setCanSlide(false);
            } else {
                this.mSlideHelper.setCanSlide(canSlide());
            }
        }
    }

    public void onResume() {
        if (isNightMode()) {
            this.cxs.setVisibility(0);
        }
    }

    public void onDestroy() {
        SwanAppActivity swanAppActivity;
        if (this.cxr != null && (swanAppActivity = this.cxr.get()) != null) {
            swanAppActivity.unregisterReceiver(this.cxt);
        }
    }

    public void aoE() {
        final SwanAppActivity swanAppActivity = this.cxr.get();
        if (swanAppActivity != null && !swanAppActivity.isDestroyed()) {
            this.mSlideHelper.attachSlideView(swanAppActivity, swanAppActivity.findViewById(16908290));
            this.mSlideHelper.attachActivity(swanAppActivity);
            this.mSlideHelper.setEnableReleaseWhenNoTranslucent(false);
            this.mSlideHelper.setFadeColor(0);
            this.mSlideHelper.setSlideInterceptor(this);
            this.mSlideHelper.setSlideListener(new SlidingPaneLayout.PanelSlideListener() { // from class: com.baidu.swan.apps.as.b.2
                @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
                public void onPanelSlide(View view, float f) {
                    View maskView = b.this.mSlideHelper.getMaskView();
                    if (maskView != null) {
                        maskView.setAlpha(1.0f - f);
                        if (swanAppActivity.On()) {
                            swanAppActivity.Om().RA();
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
                    b.this.aoG();
                    swanAppActivity.overridePendingTransition(0, 0);
                }

                @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
                public void onPanelClosed(View view) {
                }
            });
            com.baidu.swan.apps.adaptation.b.c VT = VT();
            if (VT != null) {
                this.mSlideHelper.setRegionFactor(VT.Qq());
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [com.baidu.swan.apps.adaptation.b.d] */
    @Override // com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        com.baidu.swan.apps.core.d.e Ot;
        com.baidu.swan.apps.adaptation.b.c VT;
        boolean z = true;
        SwanAppActivity swanAppActivity = this.cxr.get();
        if (swanAppActivity == null || !swanAppActivity.On() || (Ot = swanAppActivity.Ot()) == null || (VT = VT()) == null) {
            return false;
        }
        com.baidu.swan.apps.adaptation.b.f Qx = VT.Qx();
        boolean z2 = (Qx == null || Qx.QD() == 0 || !Qx.QD().canGoBack()) ? false : true;
        if (Ot.Wg() > 1 || !VT.isSlidable(motionEvent) || z2 || !aoF()) {
            z = false;
        }
        return z;
    }

    private com.baidu.swan.apps.adaptation.b.c VT() {
        com.baidu.swan.apps.core.d.e Ot;
        com.baidu.swan.apps.core.d.b Wd;
        SwanAppActivity swanAppActivity = this.cxr.get();
        if (swanAppActivity == null || (Ot = swanAppActivity.Ot()) == null || (Wd = Ot.Wd()) == null) {
            return null;
        }
        return Wd instanceof com.baidu.swan.apps.core.d.d ? ((com.baidu.swan.apps.core.d.d) Wd).VT() : null;
    }

    private boolean canSlide() {
        SwanAppActivity swanAppActivity = this.cxr.get();
        if (swanAppActivity == null) {
            return false;
        }
        return (swanAppActivity.getResources().getConfiguration().orientation == 2 || Build.VERSION.SDK_INT == 26) ? false : true;
    }

    private boolean aoF() {
        SwanAppActivity swanAppActivity = this.cxr.get();
        if (swanAppActivity == null || swanAppActivity.isDestroyed() || !swanAppActivity.On()) {
            return false;
        }
        com.baidu.swan.apps.core.d.d We = swanAppActivity.Ot().We();
        if (We != null) {
            return We.Vz() == null || !We.Vz().cpw;
        } else if (DEBUG) {
            Log.d("SwanAppActivitySlideHelper", "topFragment = null; return false");
            return false;
        } else {
            return false;
        }
    }

    public void closePane() {
        this.mSlideHelper.closePane();
    }

    public void setCanSlide(boolean z) {
        this.mSlideHelper.setCanSlide(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoG() {
        if (isNightMode()) {
            this.cxs.setVisibility(8);
        }
    }

    private boolean isNightMode() {
        return com.baidu.swan.apps.w.a.acj().getNightModeSwitcherState();
    }
}
