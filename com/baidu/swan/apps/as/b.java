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
    private WeakReference<SwanAppActivity> bYt;
    private com.baidu.swan.apps.am.b bYu;
    private BroadcastReceiver bYv = new BroadcastReceiver() { // from class: com.baidu.swan.apps.as.b.1
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
        this.bYt = new WeakReference<>(swanAppActivity);
    }

    public void agx() {
        if (this.bYt.get() != null) {
            this.mSlideHelper.setCanSlide(canSlide());
        }
    }

    public void agy() {
        SwanAppActivity swanAppActivity = this.bYt.get();
        if (swanAppActivity != null) {
            this.bYu = swanAppActivity.GV();
            if (this.bYu != null) {
                if (isNightMode()) {
                    this.bYu.setVisibility(0);
                }
                agA();
            }
        }
    }

    public void onCreate() {
        SwanAppActivity swanAppActivity = this.bYt.get();
        if (swanAppActivity != null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
            swanAppActivity.registerReceiver(this.bYv, intentFilter);
        }
    }

    public void agz() {
        SwanAppActivity swanAppActivity = this.bYt.get();
        if (swanAppActivity != null) {
            b.a GJ = swanAppActivity.GJ();
            if ((GJ != null && "1230000000000000".equals(GJ.VM())) || swanAppActivity.Gz() == 1) {
                this.mSlideHelper.setCanSlide(false);
            } else {
                this.mSlideHelper.setCanSlide(canSlide());
            }
        }
    }

    public void onResume() {
        if (isNightMode()) {
            this.bYu.setVisibility(0);
        }
    }

    public void onDestroy() {
        SwanAppActivity swanAppActivity;
        if (this.bYt != null && (swanAppActivity = this.bYt.get()) != null) {
            swanAppActivity.unregisterReceiver(this.bYv);
        }
    }

    public void agA() {
        final SwanAppActivity swanAppActivity = this.bYt.get();
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
                        if (swanAppActivity.GB()) {
                            swanAppActivity.GA().JO();
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
                    b.this.agC();
                    swanAppActivity.overridePendingTransition(0, 0);
                }

                @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
                public void onPanelClosed(View view) {
                }
            });
            com.baidu.swan.apps.adaptation.b.c Og = Og();
            if (Og != null) {
                this.mSlideHelper.setRegionFactor(Og.IF());
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [com.baidu.swan.apps.adaptation.b.d] */
    @Override // com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        com.baidu.swan.apps.core.d.e GH;
        com.baidu.swan.apps.adaptation.b.c Og;
        boolean z = true;
        SwanAppActivity swanAppActivity = this.bYt.get();
        if (swanAppActivity == null || !swanAppActivity.GB() || (GH = swanAppActivity.GH()) == null || (Og = Og()) == null) {
            return false;
        }
        com.baidu.swan.apps.adaptation.b.f IM = Og.IM();
        boolean z2 = (IM == null || IM.IS() == 0 || !IM.IS().canGoBack()) ? false : true;
        if (GH.Ot() > 1 || !Og.isSlidable(motionEvent) || z2 || !agB()) {
            z = false;
        }
        return z;
    }

    private com.baidu.swan.apps.adaptation.b.c Og() {
        com.baidu.swan.apps.core.d.e GH;
        com.baidu.swan.apps.core.d.b Oq;
        SwanAppActivity swanAppActivity = this.bYt.get();
        if (swanAppActivity == null || (GH = swanAppActivity.GH()) == null || (Oq = GH.Oq()) == null) {
            return null;
        }
        return Oq instanceof com.baidu.swan.apps.core.d.d ? ((com.baidu.swan.apps.core.d.d) Oq).Og() : null;
    }

    private boolean canSlide() {
        SwanAppActivity swanAppActivity = this.bYt.get();
        if (swanAppActivity == null) {
            return false;
        }
        return (swanAppActivity.getResources().getConfiguration().orientation == 2 || Build.VERSION.SDK_INT == 26) ? false : true;
    }

    private boolean agB() {
        SwanAppActivity swanAppActivity = this.bYt.get();
        if (swanAppActivity == null || swanAppActivity.isDestroyed() || !swanAppActivity.GB()) {
            return false;
        }
        com.baidu.swan.apps.core.d.d Or = swanAppActivity.GH().Or();
        if (Or != null) {
            return Or.NM() == null || !Or.NM().bQD;
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
    public void agC() {
        if (isNightMode()) {
            this.bYu.setVisibility(8);
        }
    }

    private boolean isNightMode() {
        return com.baidu.swan.apps.w.a.Uv().getNightModeSwitcherState();
    }
}
