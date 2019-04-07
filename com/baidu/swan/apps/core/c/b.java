package com.baidu.swan.apps.core.c;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.AudioManager;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.widget.SlideHelper;
import com.baidu.searchbox.widget.SlideInterceptor;
import com.baidu.searchbox.widget.SlidingPaneLayout;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.an.aa;
import com.baidu.swan.apps.an.x;
import com.baidu.swan.apps.view.SwanAppBdActionBar;
import com.baidu.swan.support.v4.app.Fragment;
import java.lang.reflect.Field;
import java.util.HashMap;
/* loaded from: classes2.dex */
public abstract class b extends Fragment implements SlideInterceptor {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    protected com.baidu.swan.apps.model.c apY;
    protected View apZ;
    protected SwanAppBdActionBar aqa;
    protected com.baidu.swan.menu.h aqb;
    protected String aqc;
    protected View aqd;
    @Nullable
    protected com.baidu.swan.apps.view.a.b aqe;
    protected SlideHelper aqg;
    private AudioManager.OnAudioFocusChangeListener aqi;
    private C0130b aqj;
    protected Activity mActivity;
    private AudioManager mAudioManager;
    private boolean aqf = com.baidu.swan.apps.view.a.b.aKZ;
    private int aqh = 1;

    public abstract boolean vX();

    protected abstract void xV();

    protected abstract void xW();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean xX();

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onAttach(Context context) {
        if (DEBUG) {
            Log.d("SwanAppBaseFragment", "onAttach");
        }
        super.onAttach(context);
        this.mActivity = Sw();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDetach() {
        if (DEBUG) {
            Log.d("SwanAppBaseFragment", "onDetach");
        }
        this.mActivity = null;
        super.onDetach();
        try {
            Field declaredField = Fragment.class.getDeclaredField("bnC");
            declaredField.setAccessible(true);
            declaredField.set(this, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void M(View view) {
        com.baidu.swan.apps.ae.a.d eO;
        P(view);
        com.baidu.swan.apps.ae.a.c DI = com.baidu.swan.apps.w.e.Ea().DI();
        if (DI == null) {
            if (DEBUG) {
                Log.d("SwanAppBaseFragment", "config data is null. " + Log.getStackTraceString(new Exception()));
                return;
            }
            return;
        }
        if (this.apY == null) {
            eO = DI.aOm;
        } else {
            eO = com.baidu.swan.apps.w.e.Ea().eO(this.apY.getPage());
        }
        cb(eO.aOG);
        this.aqa.setTitle(eO.aOH);
        this.aqj = new C0130b(new Runnable() { // from class: com.baidu.swan.apps.core.c.b.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.y.f.EV();
            }
        });
        this.aqa.findViewById(a.f.titlebar_center_zones);
        if (!(this instanceof com.baidu.swan.apps.d.b)) {
            dU(eO.aOI);
        }
        this.aqc = eO.aOI;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void P(View view) {
        if (view != null) {
            this.aqa = (SwanAppBdActionBar) view.findViewById(a.f.ai_apps_title_bar);
            this.apZ = view.findViewById(a.f.ai_apps_title_bar_root);
            this.aqd = view.findViewById(a.f.title_shadow);
            this.aqa.setLeftZoneImageSrcMinWidth(x.dip2px(this.mActivity, 38.0f));
            this.aqa.setLeftZoneOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.c.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    b.this.yd();
                }
            });
            this.aqa.setRightMenuOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.c.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    b.this.xW();
                    com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                    fVar.mValue = "menu";
                    b.this.a(fVar);
                    if (b.this.aqj != null) {
                        b.this.aqj.onClick();
                    }
                }
            });
            this.aqa.setRightExitOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.c.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.mActivity != null) {
                        if (b.this.mActivity instanceof SwanAppActivity) {
                            ((SwanAppActivity) b.this.mActivity).bK(1);
                            if (((SwanAppActivity) b.this.mActivity).uD()) {
                                return;
                            }
                        }
                        b.this.mActivity.moveTaskToBack(true);
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("lcType", "onClose");
                    hashMap.put("appId", com.baidu.swan.apps.ae.b.Jg());
                    com.baidu.swan.apps.w.e.Ea().a(new com.baidu.swan.apps.m.a.c(hashMap));
                    com.baidu.swan.apps.console.c.d("SwanAppBaseFragment", "onClose");
                    com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                    fVar.mValue = "close";
                    b.this.a(fVar);
                }
            });
        }
    }

    public boolean cb(int i) {
        if (this.aqa == null || this.aqd == null) {
            return false;
        }
        this.aqh = i;
        this.aqa.setBackgroundColor(i);
        com.baidu.swan.apps.ae.a.d yj = yj();
        if (yj != null) {
            yj.aOG = i;
        }
        if (yi()) {
            yk();
        }
        if (yb()) {
            this.aqd.setVisibility(0);
        } else {
            this.aqd.setVisibility(8);
        }
        return true;
    }

    public boolean a(FrameLayout frameLayout, int i) {
        if (frameLayout == null) {
            return false;
        }
        frameLayout.setBackgroundColor(i);
        com.baidu.swan.apps.ae.a.d yj = yj();
        if (yj != null) {
            yj.mBackgroundColor = i;
        }
        return true;
    }

    public boolean yb() {
        return this.aqh == -1;
    }

    public void setRightExitViewVisibility(boolean z) {
        this.aqa.setRightExitViewVisibility(z);
    }

    public void setRightMenuVisibility(boolean z) {
        this.aqa.setRightMenuVisibility(z);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (DEBUG) {
            Log.d("SwanAppBaseFragment", "onResume");
        }
        if (getUserVisibleHint()) {
            yl();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (yi() && this.aqe != null && configuration.orientation == 1) {
            Sw().getWindow().clearFlags(1024);
            aa.a(new Runnable() { // from class: com.baidu.swan.apps.core.c.b.5
                @Override // java.lang.Runnable
                public void run() {
                    b.this.yl();
                }
            }, 200L);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z) {
            yl();
        }
    }

    public void i(int i, String str) {
        TimeInterpolator accelerateDecelerateInterpolator;
        char c = 65535;
        switch (str.hashCode()) {
            case -1965087616:
                if (str.equals("easeOut")) {
                    c = 2;
                    break;
                }
                break;
            case -1310316109:
                if (str.equals("easeIn")) {
                    c = 1;
                    break;
                }
                break;
            case -1102672091:
                if (str.equals("linear")) {
                    c = 0;
                    break;
                }
                break;
            case 1330629787:
                if (str.equals("easeInOut")) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                accelerateDecelerateInterpolator = new LinearInterpolator();
                break;
            case 1:
                accelerateDecelerateInterpolator = new AccelerateInterpolator();
                break;
            case 2:
                accelerateDecelerateInterpolator = new DecelerateInterpolator();
                break;
            case 3:
                accelerateDecelerateInterpolator = new AccelerateDecelerateInterpolator();
                break;
            default:
                accelerateDecelerateInterpolator = new LinearInterpolator();
                break;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.aqa, "alpha", 0.0f, 1.0f);
        ofFloat.setDuration(i);
        ofFloat.setInterpolator(accelerateDecelerateInterpolator);
        ofFloat.start();
        if (this.aqe != null && this.aqe.My() != null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.aqe.My(), "alpha", 0.0f, 1.0f);
            ofFloat2.setDuration(i);
            ofFloat2.setInterpolator(accelerateDecelerateInterpolator);
            ofFloat2.start();
        }
    }

    @Nullable
    public boolean dT(String str) {
        if (this.aqa == null) {
            return false;
        }
        this.aqa.setTitle(str);
        com.baidu.swan.apps.ae.a.d yj = yj();
        if (yj != null) {
            yj.aOH = str;
        }
        return true;
    }

    protected void yc() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void yd() {
        if (this.mActivity != null) {
            this.mActivity.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aW(boolean z) {
        this.aqa.setLeftFirstViewVisibility(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ye() {
        this.aqa.setLeftSecondViewVisibility(0);
        this.aqa.setLeftSecondViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.c.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.yc();
            }
        });
    }

    @Override // com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable() {
        return true;
    }

    public final e uy() {
        if (this.mActivity == null) {
            return null;
        }
        return ((SwanAppActivity) this.mActivity).uy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean yf() {
        e uy = uy();
        if (uy == null) {
            return false;
        }
        return uy.yQ() > 1;
    }

    public void yg() {
        e uy = uy();
        if (uy == null || uy.yQ() == 1) {
            if (this.mActivity != null) {
                this.mActivity.moveTaskToBack(true);
                return;
            }
            return;
        }
        uy.ea("navigateBack").A(0, 0).yV().commit();
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "back";
        a(fVar);
    }

    public void Y(float f) {
        aX(true);
    }

    public void yh() {
        aX(false);
    }

    private void aX(boolean z) {
        e uy = uy();
        if (uy != null && uy.yQ() >= 2) {
            b cf = uy.cf(uy.yQ() - 2);
            if (z) {
                uy.yR().d(cf);
            } else {
                uy.yR().e(cf);
            }
        }
    }

    public final void a(com.baidu.swan.apps.statistic.a.f fVar) {
        if (this.mActivity instanceof SwanAppActivity) {
            ((SwanAppActivity) this.mActivity).a(fVar);
        }
    }

    public boolean dU(String str) {
        return cc(com.baidu.swan.apps.ae.a.c.parseColor(str));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean cc(@ColorInt int i) {
        if (this.aqa == null) {
            return false;
        }
        boolean z = this instanceof com.baidu.swan.apps.core.c.a;
        setRightExitViewVisibility(z ? false : true);
        return this.aqa.m(i, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean yi() {
        return this.aqf;
    }

    protected com.baidu.swan.apps.ae.a.d yj() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View Q(View view) {
        if (view == null) {
            return null;
        }
        if (!"IMMERSION_LAYOUT_TAG".equals(view.getTag())) {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup != null) {
                if ("IMMERSION_LAYOUT_TAG".equals(viewGroup.getTag())) {
                    return viewGroup;
                }
                viewGroup.removeView(view);
            }
            FrameLayout frameLayout = new FrameLayout(getContext());
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            return a(frameLayout, view);
        }
        return view;
    }

    protected View a(FrameLayout frameLayout, View view) {
        frameLayout.setTag("IMMERSION_LAYOUT_TAG");
        frameLayout.addView(view);
        this.aqe = new com.baidu.swan.apps.view.a.b(this.mActivity, frameLayout);
        yk();
        return frameLayout;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void yk() {
        if (this.aqe != null) {
            cd(this.aqh);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cd(@ColorInt int i) {
        if (this.aqe != null) {
            h(i, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(@ColorInt int i, boolean z) {
        if (this.aqe != null) {
            this.aqh = i;
            this.aqe.c(i, com.baidu.swan.apps.an.d.en(i), z);
        }
    }

    public void yl() {
        if (yi() && this.aqe != null) {
            this.aqe.yl();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setRequestedOrientation(int i) {
        if (this.mActivity != null) {
            this.mActivity.setRequestedOrientation(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View a(View view, SlideInterceptor slideInterceptor) {
        boolean z = getResources().getConfiguration().orientation != 2;
        this.aqg = new SlideHelper();
        View wrapSlideView = this.aqg.wrapSlideView(view.getContext(), view, slideInterceptor);
        this.aqg.setFadeColor(0);
        this.aqg.setCanSlide(z);
        this.aqg.setSlideListener(new SlidingPaneLayout.PanelSlideListener() { // from class: com.baidu.swan.apps.core.c.b.7
            @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
            public void onPanelSlide(View view2, float f) {
                View maskView = b.this.aqg.getMaskView();
                if (maskView != null) {
                    maskView.setAlpha(1.0f - f);
                }
                b.this.Y(f);
            }

            @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
            public void onPanelOpened(View view2) {
                b.this.yg();
            }

            @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
            public void onPanelClosed(View view2) {
                b.this.yh();
            }
        });
        return wrapSlideView;
    }

    public final Resources ym() {
        return isAdded() ? getResources() : AppRuntime.getAppContext().getResources();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean yn() {
        if ((this.mActivity instanceof SwanAppActivity) && ((SwanAppActivity) this.mActivity).us() == 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int us() {
        if (this.mActivity instanceof SwanAppActivity) {
            return ((SwanAppActivity) this.mActivity).us();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bA(Context context) {
        if (context != null) {
            if (this.aqi == null) {
                this.aqi = new a();
            }
            if (this.mAudioManager == null) {
                this.mAudioManager = (AudioManager) context.getSystemService("audio");
            }
            this.mAudioManager.requestAudioFocus(this.aqi, 3, 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void yo() {
        if (this.mAudioManager != null && this.aqi != null) {
            this.mAudioManager.abandonAudioFocus(this.aqi);
        }
    }

    /* loaded from: classes2.dex */
    private static class a implements AudioManager.OnAudioFocusChangeListener {
        private a() {
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
        }
    }

    public boolean yp() {
        if (this.aqa == null) {
            return false;
        }
        this.aqa.cs(true);
        return true;
    }

    public boolean yq() {
        if (this.aqa == null) {
            return false;
        }
        this.aqa.cs(false);
        return true;
    }

    public void aY(boolean z) {
        if (this.aqa != null) {
            this.aqa.setActionBarCustom(z);
        }
        if (this.aqd != null) {
            int i = 8;
            if (!z && yb()) {
                i = 0;
            }
            this.aqd.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int yr() {
        if (TextUtils.isEmpty(com.baidu.swan.apps.ae.b.Jg()) || com.baidu.swan.apps.database.favorite.a.es(com.baidu.swan.apps.ae.b.Jg())) {
            return 0;
        }
        if (com.baidu.swan.apps.database.favorite.a.er(com.baidu.swan.apps.ae.b.Jg())) {
            return 2;
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean ys() {
        return "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u".equals(com.baidu.swan.apps.ae.b.Jg());
    }

    public void yt() {
        com.baidu.swan.apps.scheme.actions.h.a.t("backtohome", "menu", com.baidu.swan.apps.w.e.Ea().DL());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "gohome";
        fVar.mSource = "menu";
        a(fVar);
    }

    public void yu() {
    }

    /* renamed from: com.baidu.swan.apps.core.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private class C0130b {
        private Runnable aqm;
        private int aql = 0;
        private long mLastTimestamp = 0;

        C0130b(Runnable runnable) {
            this.aqm = runnable;
        }

        void onClick() {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.mLastTimestamp > 1333) {
                this.mLastTimestamp = currentTimeMillis;
                this.aql = 1;
                return;
            }
            this.aql++;
            if (this.aql == 3) {
                if (this.aqm != null) {
                    this.aqm.run();
                }
                this.aql = 0;
                this.mLastTimestamp = 0L;
                return;
            }
            this.mLastTimestamp = currentTimeMillis;
        }
    }
}
