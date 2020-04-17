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
    private WeakReference<SwanAppActivity> cxl;
    private com.baidu.swan.apps.am.b cxm;
    private BroadcastReceiver cxn = new BroadcastReceiver() { // from class: com.baidu.swan.apps.as.b.1
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
        this.cxl = new WeakReference<>(swanAppActivity);
    }

    public void aoC() {
        if (this.cxl.get() != null) {
            this.mSlideHelper.setCanSlide(canSlide());
        }
    }

    public void aoD() {
        SwanAppActivity swanAppActivity = this.cxl.get();
        if (swanAppActivity != null) {
            this.cxm = swanAppActivity.OI();
            if (this.cxm != null) {
                if (isNightMode()) {
                    this.cxm.setVisibility(0);
                }
                aoF();
            }
        }
    }

    public void onCreate() {
        SwanAppActivity swanAppActivity = this.cxl.get();
        if (swanAppActivity != null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
            swanAppActivity.registerReceiver(this.cxn, intentFilter);
        }
    }

    public void aoE() {
        SwanAppActivity swanAppActivity = this.cxl.get();
        if (swanAppActivity != null) {
            b.a Ow = swanAppActivity.Ow();
            if ((Ow != null && "1230000000000000".equals(Ow.adB())) || swanAppActivity.Om() == 1) {
                this.mSlideHelper.setCanSlide(false);
            } else {
                this.mSlideHelper.setCanSlide(canSlide());
            }
        }
    }

    public void onResume() {
        if (isNightMode()) {
            this.cxm.setVisibility(0);
        }
    }

    public void onDestroy() {
        SwanAppActivity swanAppActivity;
        if (this.cxl != null && (swanAppActivity = this.cxl.get()) != null) {
            swanAppActivity.unregisterReceiver(this.cxn);
        }
    }

    public void aoF() {
        final SwanAppActivity swanAppActivity = this.cxl.get();
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
                        if (swanAppActivity.Oo()) {
                            swanAppActivity.On().RB();
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
                    b.this.aoH();
                    swanAppActivity.overridePendingTransition(0, 0);
                }

                @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
                public void onPanelClosed(View view) {
                }
            });
            com.baidu.swan.apps.adaptation.b.c VU = VU();
            if (VU != null) {
                this.mSlideHelper.setRegionFactor(VU.Qr());
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [com.baidu.swan.apps.adaptation.b.d] */
    @Override // com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        com.baidu.swan.apps.core.d.e Ou;
        com.baidu.swan.apps.adaptation.b.c VU;
        boolean z = true;
        SwanAppActivity swanAppActivity = this.cxl.get();
        if (swanAppActivity == null || !swanAppActivity.Oo() || (Ou = swanAppActivity.Ou()) == null || (VU = VU()) == null) {
            return false;
        }
        com.baidu.swan.apps.adaptation.b.f Qy = VU.Qy();
        boolean z2 = (Qy == null || Qy.QE() == 0 || !Qy.QE().canGoBack()) ? false : true;
        if (Ou.Wh() > 1 || !VU.isSlidable(motionEvent) || z2 || !aoG()) {
            z = false;
        }
        return z;
    }

    private com.baidu.swan.apps.adaptation.b.c VU() {
        com.baidu.swan.apps.core.d.e Ou;
        com.baidu.swan.apps.core.d.b We;
        SwanAppActivity swanAppActivity = this.cxl.get();
        if (swanAppActivity == null || (Ou = swanAppActivity.Ou()) == null || (We = Ou.We()) == null) {
            return null;
        }
        return We instanceof com.baidu.swan.apps.core.d.d ? ((com.baidu.swan.apps.core.d.d) We).VU() : null;
    }

    private boolean canSlide() {
        SwanAppActivity swanAppActivity = this.cxl.get();
        if (swanAppActivity == null) {
            return false;
        }
        return (swanAppActivity.getResources().getConfiguration().orientation == 2 || Build.VERSION.SDK_INT == 26) ? false : true;
    }

    private boolean aoG() {
        SwanAppActivity swanAppActivity = this.cxl.get();
        if (swanAppActivity == null || swanAppActivity.isDestroyed() || !swanAppActivity.Oo()) {
            return false;
        }
        com.baidu.swan.apps.core.d.d Wf = swanAppActivity.Ou().Wf();
        if (Wf != null) {
            return Wf.VA() == null || !Wf.VA().cpp;
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
    public void aoH() {
        if (isNightMode()) {
            this.cxm.setVisibility(8);
        }
    }

    private boolean isNightMode() {
        return com.baidu.swan.apps.w.a.ack().getNightModeSwitcherState();
    }
}
