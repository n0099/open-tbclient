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
import com.baidu.swan.apps.an.aa;
import com.baidu.swan.apps.an.x;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.view.SwanAppBdActionBar;
import com.baidu.swan.support.v4.app.Fragment;
import java.lang.reflect.Field;
import java.util.HashMap;
/* loaded from: classes2.dex */
public abstract class b extends Fragment implements SlideInterceptor {
    private static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;
    protected com.baidu.swan.apps.model.c apT;
    protected View apU;
    protected SwanAppBdActionBar apV;
    protected com.baidu.swan.menu.h apW;
    protected String apX;
    protected View apY;
    @Nullable
    protected com.baidu.swan.apps.view.a.b apZ;
    protected SlideHelper aqb;
    private AudioManager.OnAudioFocusChangeListener aqd;
    private C0101b aqe;
    protected Activity mActivity;
    private AudioManager mAudioManager;
    private boolean aqa = com.baidu.swan.apps.view.a.b.aKV;
    private int aqc = 1;

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
            Field declaredField = Fragment.class.getDeclaredField("bny");
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
        if (this.apT == null) {
            eN = DK.aOi;
        } else {
            eN = com.baidu.swan.apps.w.e.Ec().eN(this.apT.getPage());
        }
        cc(eN.aOC);
        this.apV.setTitle(eN.aOD);
        this.aqe = new C0101b(new Runnable() { // from class: com.baidu.swan.apps.core.c.b.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.y.f.EX();
            }
        });
        this.apV.findViewById(b.f.titlebar_center_zones);
        if (!(this instanceof com.baidu.swan.apps.d.b)) {
            dS(eN.aOE);
        }
        this.apX = eN.aOE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void P(View view) {
        if (view != null) {
            this.apV = (SwanAppBdActionBar) view.findViewById(b.f.ai_apps_title_bar);
            this.apU = view.findViewById(b.f.ai_apps_title_bar_root);
            this.apY = view.findViewById(b.f.title_shadow);
            this.apV.setLeftZoneImageSrcMinWidth(x.dip2px(this.mActivity, 38.0f));
            this.apV.setLeftZoneOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.c.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    b.this.ye();
                }
            });
            this.apV.setRightMenuOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.c.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    b.this.xX();
                    com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                    fVar.mValue = "menu";
                    b.this.a(fVar);
                    if (b.this.aqe != null) {
                        b.this.aqe.onClick();
                    }
                }
            });
            this.apV.setRightExitOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.c.b.4
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
        if (this.apV == null || this.apY == null) {
            return false;
        }
        this.aqc = i;
        this.apV.setBackgroundColor(i);
        com.baidu.swan.apps.ae.a.d yk = yk();
        if (yk != null) {
            yk.aOC = i;
        }
        if (yj()) {
            yl();
        }
        if (yc()) {
            this.apY.setVisibility(0);
        } else {
            this.apY.setVisibility(8);
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
        return this.aqc == -1;
    }

    public void setRightExitViewVisibility(boolean z) {
        this.apV.setRightExitViewVisibility(z);
    }

    public void setRightMenuVisibility(boolean z) {
        this.apV.setRightMenuVisibility(z);
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
        if (yj() && this.apZ != null && configuration.orientation == 1) {
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
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.apV, "alpha", 0.0f, 1.0f);
        ofFloat.setDuration(i);
        ofFloat.setInterpolator(accelerateDecelerateInterpolator);
        ofFloat.start();
        if (this.apZ != null && this.apZ.MA() != null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.apZ.MA(), "alpha", 0.0f, 1.0f);
            ofFloat2.setDuration(i);
            ofFloat2.setInterpolator(accelerateDecelerateInterpolator);
            ofFloat2.start();
        }
    }

    @Nullable
    public boolean dR(String str) {
        if (this.apV == null) {
            return false;
        }
        this.apV.setTitle(str);
        com.baidu.swan.apps.ae.a.d yk = yk();
        if (yk != null) {
            yk.aOD = str;
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
        this.apV.setLeftFirstViewVisibility(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void yf() {
        this.apV.setLeftSecondViewVisibility(0);
        this.apV.setLeftSecondViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.c.b.6
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
        if (this.apV == null) {
            return false;
        }
        boolean z = this instanceof com.baidu.swan.apps.core.c.a;
        setRightExitViewVisibility(z ? false : true);
        return this.apV.m(i, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean yj() {
        return this.aqa;
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
        this.apZ = new com.baidu.swan.apps.view.a.b(this.mActivity, frameLayout);
        yl();
        return frameLayout;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void yl() {
        if (this.apZ != null) {
            ce(this.aqc);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ce(@ColorInt int i) {
        if (this.apZ != null) {
            h(i, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(@ColorInt int i, boolean z) {
        if (this.apZ != null) {
            this.aqc = i;
            this.apZ.c(i, com.baidu.swan.apps.an.d.eo(i), z);
        }
    }

    public void ym() {
        if (yj() && this.apZ != null) {
            this.apZ.ym();
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
        this.aqb = new SlideHelper();
        View wrapSlideView = this.aqb.wrapSlideView(view.getContext(), view, slideInterceptor);
        this.aqb.setFadeColor(0);
        this.aqb.setCanSlide(z);
        this.aqb.setSlideListener(new SlidingPaneLayout.PanelSlideListener() { // from class: com.baidu.swan.apps.core.c.b.7
            @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
            public void onPanelSlide(View view2, float f) {
                View maskView = b.this.aqb.getMaskView();
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
            if (this.aqd == null) {
                this.aqd = new a();
            }
            if (this.mAudioManager == null) {
                this.mAudioManager = (AudioManager) context.getSystemService("audio");
            }
            this.mAudioManager.requestAudioFocus(this.aqd, 3, 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void yp() {
        if (this.mAudioManager != null && this.aqd != null) {
            this.mAudioManager.abandonAudioFocus(this.aqd);
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
        if (this.apV == null) {
            return false;
        }
        this.apV.cs(true);
        return true;
    }

    public boolean yr() {
        if (this.apV == null) {
            return false;
        }
        this.apV.cs(false);
        return true;
    }

    public void aY(boolean z) {
        if (this.apV != null) {
            this.apV.setActionBarCustom(z);
        }
        if (this.apY != null) {
            int i = 8;
            if (!z && yc()) {
                i = 0;
            }
            this.apY.setVisibility(i);
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
    private class C0101b {
        private Runnable aqh;
        private int aqg = 0;
        private long mLastTimestamp = 0;

        C0101b(Runnable runnable) {
            this.aqh = runnable;
        }

        void onClick() {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.mLastTimestamp > 1333) {
                this.mLastTimestamp = currentTimeMillis;
                this.aqg = 1;
                return;
            }
            this.aqg++;
            if (this.aqg == 3) {
                if (this.aqh != null) {
                    this.aqh.run();
                }
                this.aqg = 0;
                this.mLastTimestamp = 0L;
                return;
            }
            this.mLastTimestamp = currentTimeMillis;
        }
    }
}
