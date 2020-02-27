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
    private WeakReference<SwanAppActivity> bYg;
    private com.baidu.swan.apps.am.b bYh;
    private BroadcastReceiver bYi = new BroadcastReceiver() { // from class: com.baidu.swan.apps.as.b.1
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
        this.bYg = new WeakReference<>(swanAppActivity);
    }

    public void ags() {
        if (this.bYg.get() != null) {
            this.mSlideHelper.setCanSlide(canSlide());
        }
    }

    public void agt() {
        SwanAppActivity swanAppActivity = this.bYg.get();
        if (swanAppActivity != null) {
            this.bYh = swanAppActivity.GO();
            if (this.bYh != null) {
                if (isNightMode()) {
                    this.bYh.setVisibility(0);
                }
                agv();
            }
        }
    }

    public void onCreate() {
        SwanAppActivity swanAppActivity = this.bYg.get();
        if (swanAppActivity != null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
            swanAppActivity.registerReceiver(this.bYi, intentFilter);
        }
    }

    public void agu() {
        SwanAppActivity swanAppActivity = this.bYg.get();
        if (swanAppActivity != null) {
            b.a GC = swanAppActivity.GC();
            if ((GC != null && "1230000000000000".equals(GC.VH())) || swanAppActivity.Gs() == 1) {
                this.mSlideHelper.setCanSlide(false);
            } else {
                this.mSlideHelper.setCanSlide(canSlide());
            }
        }
    }

    public void onResume() {
        if (isNightMode()) {
            this.bYh.setVisibility(0);
        }
    }

    public void onDestroy() {
        SwanAppActivity swanAppActivity;
        if (this.bYg != null && (swanAppActivity = this.bYg.get()) != null) {
            swanAppActivity.unregisterReceiver(this.bYi);
        }
    }

    public void agv() {
        final SwanAppActivity swanAppActivity = this.bYg.get();
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
                        if (swanAppActivity.Gu()) {
                            swanAppActivity.Gt().JJ();
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
                    b.this.agx();
                    swanAppActivity.overridePendingTransition(0, 0);
                }

                @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
                public void onPanelClosed(View view) {
                }
            });
            com.baidu.swan.apps.adaptation.b.c Ob = Ob();
            if (Ob != null) {
                this.mSlideHelper.setRegionFactor(Ob.IA());
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [com.baidu.swan.apps.adaptation.b.d] */
    @Override // com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        com.baidu.swan.apps.core.d.e GA;
        com.baidu.swan.apps.adaptation.b.c Ob;
        boolean z = true;
        SwanAppActivity swanAppActivity = this.bYg.get();
        if (swanAppActivity == null || !swanAppActivity.Gu() || (GA = swanAppActivity.GA()) == null || (Ob = Ob()) == null) {
            return false;
        }
        com.baidu.swan.apps.adaptation.b.f IH = Ob.IH();
        boolean z2 = (IH == null || IH.IN() == 0 || !IH.IN().canGoBack()) ? false : true;
        if (GA.Oo() > 1 || !Ob.isSlidable(motionEvent) || z2 || !agw()) {
            z = false;
        }
        return z;
    }

    private com.baidu.swan.apps.adaptation.b.c Ob() {
        com.baidu.swan.apps.core.d.e GA;
        com.baidu.swan.apps.core.d.b Ol;
        SwanAppActivity swanAppActivity = this.bYg.get();
        if (swanAppActivity == null || (GA = swanAppActivity.GA()) == null || (Ol = GA.Ol()) == null) {
            return null;
        }
        return Ol instanceof com.baidu.swan.apps.core.d.d ? ((com.baidu.swan.apps.core.d.d) Ol).Ob() : null;
    }

    private boolean canSlide() {
        SwanAppActivity swanAppActivity = this.bYg.get();
        if (swanAppActivity == null) {
            return false;
        }
        return (swanAppActivity.getResources().getConfiguration().orientation == 2 || Build.VERSION.SDK_INT == 26) ? false : true;
    }

    private boolean agw() {
        SwanAppActivity swanAppActivity = this.bYg.get();
        if (swanAppActivity == null || swanAppActivity.isDestroyed() || !swanAppActivity.Gu()) {
            return false;
        }
        com.baidu.swan.apps.core.d.d Om = swanAppActivity.GA().Om();
        if (Om != null) {
            return Om.NH() == null || !Om.NH().bQq;
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
    public void agx() {
        if (isNightMode()) {
            this.bYh.setVisibility(8);
        }
    }

    private boolean isNightMode() {
        return com.baidu.swan.apps.w.a.Uq().getNightModeSwitcherState();
    }
}
