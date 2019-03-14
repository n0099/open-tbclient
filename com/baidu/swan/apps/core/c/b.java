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
    protected com.baidu.swan.apps.model.c apU;
    protected View apV;
    protected SwanAppBdActionBar apW;
    protected com.baidu.swan.menu.h apX;
    protected String apY;
    protected View apZ;
    @Nullable
    protected com.baidu.swan.apps.view.a.b aqa;
    protected SlideHelper aqc;
    private AudioManager.OnAudioFocusChangeListener aqe;
    private C0130b aqf;
    protected Activity mActivity;
    private AudioManager mAudioManager;
    private boolean aqb = com.baidu.swan.apps.view.a.b.aKW;
    private int aqd = 1;

    public abstract boolean vY();

    protected abstract void xW();

    protected abstract void xX();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean xY();

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onAttach(Context context) {
        if (DEBUG) {
            Log.d("SwanAppBaseFragment", "onAttach");
        }
        super.onAttach(context);
        this.mActivity = Sy();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDetach() {
        if (DEBUG) {
            Log.d("SwanAppBaseFragment", "onDetach");
        }
        this.mActivity = null;
        super.onDetach();
        try {
            Field declaredField = Fragment.class.getDeclaredField("bnz");
            declaredField.setAccessible(true);
            declaredField.set(this, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void M(View view) {
        com.baidu.swan.apps.ae.a.d eN;
        P(view);
        com.baidu.swan.apps.ae.a.c DK = com.baidu.swan.apps.w.e.Ec().DK();
        if (DK == null) {
            if (DEBUG) {
                Log.d("SwanAppBaseFragment", "config data is null. " + Log.getStackTraceString(new Exception()));
                return;
            }
            return;
        }
        if (this.apU == null) {
            eN = DK.aOj;
        } else {
            eN = com.baidu.swan.apps.w.e.Ec().eN(this.apU.getPage());
        }
        cc(eN.aOD);
        this.apW.setTitle(eN.aOE);
        this.aqf = new C0130b(new Runnable() { // from class: com.baidu.swan.apps.core.c.b.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.y.f.EX();
            }
        });
        this.apW.findViewById(a.f.titlebar_center_zones);
        if (!(this instanceof com.baidu.swan.apps.d.b)) {
            dS(eN.aOF);
        }
        this.apY = eN.aOF;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void P(View view) {
        if (view != null) {
            this.apW = (SwanAppBdActionBar) view.findViewById(a.f.ai_apps_title_bar);
            this.apV = view.findViewById(a.f.ai_apps_title_bar_root);
            this.apZ = view.findViewById(a.f.title_shadow);
            this.apW.setLeftZoneImageSrcMinWidth(x.dip2px(this.mActivity, 38.0f));
            this.apW.setLeftZoneOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.c.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    b.this.ye();
                }
            });
            this.apW.setRightMenuOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.c.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    b.this.xX();
                    com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                    fVar.mValue = "menu";
                    b.this.a(fVar);
                    if (b.this.aqf != null) {
                        b.this.aqf.onClick();
                    }
                }
            });
            this.apW.setRightExitOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.c.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.mActivity != null) {
                        if (b.this.mActivity instanceof SwanAppActivity) {
                            ((SwanAppActivity) b.this.mActivity).bL(1);
                            if (((SwanAppActivity) b.this.mActivity).uE()) {
                                return;
                            }
                        }
                        b.this.mActivity.moveTaskToBack(true);
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("lcType", "onClose");
                    hashMap.put("appId", com.baidu.swan.apps.ae.b.Ji());
                    com.baidu.swan.apps.w.e.Ec().a(new com.baidu.swan.apps.m.a.c(hashMap));
                    com.baidu.swan.apps.console.c.d("SwanAppBaseFragment", "onClose");
                    com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                    fVar.mValue = "close";
                    b.this.a(fVar);
                }
            });
        }
    }

    public boolean cc(int i) {
        if (this.apW == null || this.apZ == null) {
            return false;
        }
        this.aqd = i;
        this.apW.setBackgroundColor(i);
        com.baidu.swan.apps.ae.a.d yk = yk();
        if (yk != null) {
            yk.aOD = i;
        }
        if (yj()) {
            yl();
        }
        if (yc()) {
            this.apZ.setVisibility(0);
        } else {
            this.apZ.setVisibility(8);
        }
        return true;
    }

    public boolean a(FrameLayout frameLayout, int i) {
        if (frameLayout == null) {
            return false;
        }
        frameLayout.setBackgroundColor(i);
        com.baidu.swan.apps.ae.a.d yk = yk();
        if (yk != null) {
            yk.mBackgroundColor = i;
        }
        return true;
    }

    public boolean yc() {
        return this.aqd == -1;
    }

    public void setRightExitViewVisibility(boolean z) {
        this.apW.setRightExitViewVisibility(z);
    }

    public void setRightMenuVisibility(boolean z) {
        this.apW.setRightMenuVisibility(z);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (DEBUG) {
            Log.d("SwanAppBaseFragment", "onResume");
        }
        if (getUserVisibleHint()) {
            ym();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (yj() && this.aqa != null && configuration.orientation == 1) {
            Sy().getWindow().clearFlags(1024);
            aa.a(new Runnable() { // from class: com.baidu.swan.apps.core.c.b.5
                @Override // java.lang.Runnable
                public void run() {
                    b.this.ym();
                }
            }, 200L);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z) {
            ym();
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
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.apW, "alpha", 0.0f, 1.0f);
        ofFloat.setDuration(i);
        ofFloat.setInterpolator(accelerateDecelerateInterpolator);
        ofFloat.start();
        if (this.aqa != null && this.aqa.MA() != null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.aqa.MA(), "alpha", 0.0f, 1.0f);
            ofFloat2.setDuration(i);
            ofFloat2.setInterpolator(accelerateDecelerateInterpolator);
            ofFloat2.start();
        }
    }

    @Nullable
    public boolean dR(String str) {
        if (this.apW == null) {
            return false;
        }
        this.apW.setTitle(str);
        com.baidu.swan.apps.ae.a.d yk = yk();
        if (yk != null) {
            yk.aOE = str;
        }
        return true;
    }

    protected void yd() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ye() {
        if (this.mActivity != null) {
            this.mActivity.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aW(boolean z) {
        this.apW.setLeftFirstViewVisibility(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void yf() {
        this.apW.setLeftSecondViewVisibility(0);
        this.apW.setLeftSecondViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.c.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.yd();
            }
        });
    }

    @Override // com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable() {
        return true;
    }

    public final e uz() {
        if (this.mActivity == null) {
            return null;
        }
        return ((SwanAppActivity) this.mActivity).uz();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean yg() {
        e uz = uz();
        if (uz == null) {
            return false;
        }
        return uz.yR() > 1;
    }

    public void yh() {
        e uz = uz();
        if (uz == null || uz.yR() == 1) {
            if (this.mActivity != null) {
                this.mActivity.moveTaskToBack(true);
                return;
            }
            return;
        }
        uz.dY("navigateBack").A(0, 0).yW().commit();
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "back";
        a(fVar);
    }

    public void Y(float f) {
        aX(true);
    }

    public void yi() {
        aX(false);
    }

    private void aX(boolean z) {
        e uz = uz();
        if (uz != null && uz.yR() >= 2) {
            b cg = uz.cg(uz.yR() - 2);
            if (z) {
                uz.yS().d(cg);
            } else {
                uz.yS().e(cg);
            }
        }
    }

    public final void a(com.baidu.swan.apps.statistic.a.f fVar) {
        if (this.mActivity instanceof SwanAppActivity) {
            ((SwanAppActivity) this.mActivity).a(fVar);
        }
    }

    public boolean dS(String str) {
        return cd(com.baidu.swan.apps.ae.a.c.parseColor(str));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean cd(@ColorInt int i) {
        if (this.apW == null) {
            return false;
        }
        boolean z = this instanceof com.baidu.swan.apps.core.c.a;
        setRightExitViewVisibility(z ? false : true);
        return this.apW.m(i, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean yj() {
        return this.aqb;
    }

    protected com.baidu.swan.apps.ae.a.d yk() {
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
        this.aqa = new com.baidu.swan.apps.view.a.b(this.mActivity, frameLayout);
        yl();
        return frameLayout;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void yl() {
        if (this.aqa != null) {
            ce(this.aqd);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ce(@ColorInt int i) {
        if (this.aqa != null) {
            h(i, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(@ColorInt int i, boolean z) {
        if (this.aqa != null) {
            this.aqd = i;
            this.aqa.c(i, com.baidu.swan.apps.an.d.eo(i), z);
        }
    }

    public void ym() {
        if (yj() && this.aqa != null) {
            this.aqa.ym();
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
        this.aqc = new SlideHelper();
        View wrapSlideView = this.aqc.wrapSlideView(view.getContext(), view, slideInterceptor);
        this.aqc.setFadeColor(0);
        this.aqc.setCanSlide(z);
        this.aqc.setSlideListener(new SlidingPaneLayout.PanelSlideListener() { // from class: com.baidu.swan.apps.core.c.b.7
            @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
            public void onPanelSlide(View view2, float f) {
                View maskView = b.this.aqc.getMaskView();
                if (maskView != null) {
                    maskView.setAlpha(1.0f - f);
                }
                b.this.Y(f);
            }

            @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
            public void onPanelOpened(View view2) {
                b.this.yh();
            }

            @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
            public void onPanelClosed(View view2) {
                b.this.yi();
            }
        });
        return wrapSlideView;
    }

    public final Resources yn() {
        return isAdded() ? getResources() : AppRuntime.getAppContext().getResources();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean yo() {
        if ((this.mActivity instanceof SwanAppActivity) && ((SwanAppActivity) this.mActivity).ut() == 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int ut() {
        if (this.mActivity instanceof SwanAppActivity) {
            return ((SwanAppActivity) this.mActivity).ut();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bA(Context context) {
        if (context != null) {
            if (this.aqe == null) {
                this.aqe = new a();
            }
            if (this.mAudioManager == null) {
                this.mAudioManager = (AudioManager) context.getSystemService("audio");
            }
            this.mAudioManager.requestAudioFocus(this.aqe, 3, 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void yp() {
        if (this.mAudioManager != null && this.aqe != null) {
            this.mAudioManager.abandonAudioFocus(this.aqe);
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

    public boolean yq() {
        if (this.apW == null) {
            return false;
        }
        this.apW.cs(true);
        return true;
    }

    public boolean yr() {
        if (this.apW == null) {
            return false;
        }
        this.apW.cs(false);
        return true;
    }

    public void aY(boolean z) {
        if (this.apW != null) {
            this.apW.setActionBarCustom(z);
        }
        if (this.apZ != null) {
            int i = 8;
            if (!z && yc()) {
                i = 0;
            }
            this.apZ.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int ys() {
        if (TextUtils.isEmpty(com.baidu.swan.apps.ae.b.Ji()) || com.baidu.swan.apps.database.favorite.a.er(com.baidu.swan.apps.ae.b.Ji())) {
            return 0;
        }
        if (com.baidu.swan.apps.database.favorite.a.eq(com.baidu.swan.apps.ae.b.Ji())) {
            return 2;
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean yt() {
        return "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u".equals(com.baidu.swan.apps.ae.b.Ji());
    }

    public void yu() {
        com.baidu.swan.apps.scheme.actions.h.a.t("backtohome", "menu", com.baidu.swan.apps.w.e.Ec().DN());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "gohome";
        fVar.mSource = "menu";
        a(fVar);
    }

    public void yv() {
    }

    /* renamed from: com.baidu.swan.apps.core.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private class C0130b {
        private Runnable aqi;
        private int aqh = 0;
        private long mLastTimestamp = 0;

        C0130b(Runnable runnable) {
            this.aqi = runnable;
        }

        void onClick() {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.mLastTimestamp > 1333) {
                this.mLastTimestamp = currentTimeMillis;
                this.aqh = 1;
                return;
            }
            this.aqh++;
            if (this.aqh == 3) {
                if (this.aqi != null) {
                    this.aqi.run();
                }
                this.aqh = 0;
                this.mLastTimestamp = 0L;
                return;
            }
            this.mLastTimestamp = currentTimeMillis;
        }
    }
}
