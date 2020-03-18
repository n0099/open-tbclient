package com.baidu.swan.apps.core.d;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.AudioManager;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.widget.SlideHelper;
import com.baidu.searchbox.widget.SlideInterceptor;
import com.baidu.searchbox.widget.SlidingPaneLayout;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment;
import com.baidu.swan.apps.as.af;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.q.c;
import com.baidu.swan.apps.res.ui.FloatButton;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.view.SwanAppActionBar;
import com.baidu.swan.support.v4.app.Fragment;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import java.lang.reflect.Field;
import java.util.HashMap;
/* loaded from: classes11.dex */
public abstract class b extends Fragment implements SlideInterceptor {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private AudioManager.OnAudioFocusChangeListener axF;
    protected com.baidu.swan.apps.model.c bnI;
    protected View bnJ;
    protected SwanAppActionBar bnK;
    protected com.baidu.swan.menu.h bnL;
    protected String bnM;
    protected View bnN;
    protected TextView bnO;
    @Nullable
    protected com.baidu.swan.apps.view.a.b bnP;
    private a bnQ;
    protected Activity mActivity;
    private AudioManager mAudioManager;
    protected SlideHelper mSlideHelper;
    private boolean mImmersionEnabled = com.baidu.swan.apps.view.a.b.SUPPORT_IMMERSION;
    private int mStatusBarColor = 1;

    public abstract boolean IN();

    protected abstract boolean Ji();

    protected abstract void Jl();

    protected abstract void Ny();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean Nz();

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onAttach(Context context) {
        if (DEBUG) {
            Log.d("SwanAppBaseFragment", "onAttach");
        }
        super.onAttach(context);
        this.mActivity = auD();
        cq(true);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDetach() {
        if (DEBUG) {
            Log.d("SwanAppBaseFragment", "onDetach");
        }
        this.mActivity = null;
        cq(false);
        super.onDetach();
        try {
            Field declaredField = Fragment.class.getDeclaredField("cCW");
            declaredField.setAccessible(true);
            declaredField.set(this, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ae(View view) {
        com.baidu.swan.apps.runtime.config.c iR;
        ag(view);
        SwanAppConfigData WB = com.baidu.swan.apps.y.f.WV().WB();
        if (WB == null) {
            if (DEBUG) {
                Log.d("SwanAppBaseFragment", "config data is null. " + Log.getStackTraceString(new Exception()));
                return;
            }
            return;
        }
        if (this.bnI == null) {
            iR = WB.bPR;
        } else {
            iR = com.baidu.swan.apps.y.f.WV().iR(this.bnI.getPage());
        }
        et(iR.bQu);
        this.bnK.setTitle(iR.bQv);
        this.bnQ = new a(new Runnable() { // from class: com.baidu.swan.apps.core.d.b.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.ac.f.YG();
            }
        });
        this.bnK.findViewById(a.f.titlebar_center_zone);
        if (!(this instanceof SwanAppAdLandingFragment)) {
            gT(iR.bQw);
        }
        this.bnM = iR.bQw;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ag(View view) {
        if (view != null) {
            this.bnK = (SwanAppActionBar) view.findViewById(a.f.ai_apps_title_bar);
            this.bnJ = view.findViewById(a.f.ai_apps_title_bar_root);
            this.bnN = view.findViewById(a.f.title_shadow);
            this.bnK.setLeftBackViewMinWidth(af.dip2px(this.mActivity, 38.0f));
            this.bnK.setLeftBackViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    b.this.onActionBarBackPressed();
                }
            });
            this.bnK.setRightMenuOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    b.this.Ny();
                    com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                    fVar.mValue = "menu";
                    if (com.baidu.swan.apps.runtime.e.acJ() != null && com.baidu.swan.apps.runtime.e.acJ().acY().b("key_unread_counts_message", (Integer) 0).intValue() > 0) {
                        fVar.mPage = String.valueOf(1);
                    }
                    b.this.a(fVar);
                    if (b.this.bnQ != null) {
                        b.this.bnQ.onClick();
                    }
                }
            });
            this.bnK.setRightExitOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.b.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.mActivity != null && (b.this.mActivity instanceof SwanAppActivity)) {
                        if (com.baidu.swan.apps.runtime.e.acI() == null || com.baidu.swan.apps.runtime.e.acK() == null) {
                            b.this.NE();
                        } else if (com.baidu.swan.apps.q.a.Tg().Th()) {
                            b.this.ND();
                        } else if (com.baidu.swan.apps.q.c.Tn().To()) {
                            b.this.NE();
                        } else {
                            com.baidu.swan.apps.q.b Ti = new com.baidu.swan.apps.q.b().Ti();
                            if (!Ti.isShow()) {
                                b.this.NE();
                                return;
                            }
                            com.baidu.swan.apps.q.c.Tn().a(b.this.mActivity, Ti.getImageUrl(), Ti.Tm(), b.this.NC());
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c.a NC() {
        return new c.a() { // from class: com.baidu.swan.apps.core.d.b.6
            @Override // com.baidu.swan.apps.q.c.a
            public void NW() {
                b.this.NE();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ND() {
        com.baidu.swan.apps.q.a.Tg().a(this.mActivity, new com.baidu.swan.apps.core.f.b<Boolean>() { // from class: com.baidu.swan.apps.core.d.b.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.core.f.b
            /* renamed from: d */
            public void F(Boolean bool) {
                b.this.NE();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NE() {
        if (this.mActivity != null) {
            this.mActivity.moveTaskToBack(true);
            NF();
            ((SwanAppActivity) this.mActivity).dR(1);
        }
    }

    private void NF() {
        HashMap hashMap = new HashMap();
        hashMap.put("lcType", "onClose");
        hashMap.put("appId", com.baidu.swan.apps.runtime.e.acK());
        com.baidu.swan.apps.y.f.WV().a(new com.baidu.swan.apps.n.a.c(hashMap));
        com.baidu.swan.apps.console.c.d("SwanAppBaseFragment", "onClose");
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "close";
        a(fVar);
    }

    public boolean et(int i) {
        if (this.bnK == null || this.bnN == null) {
            return false;
        }
        this.mStatusBarColor = i;
        this.bnK.setBackgroundColor(i);
        com.baidu.swan.apps.runtime.config.c NM = NM();
        if (NM != null) {
            NM.bQu = i;
        }
        if (immersionEnabled()) {
            applyImmersion();
        }
        if (NH()) {
            this.bnN.setVisibility(0);
        } else {
            this.bnN.setVisibility(8);
        }
        return true;
    }

    public boolean a(FrameLayout frameLayout, int i) {
        if (frameLayout == null) {
            return false;
        }
        frameLayout.setBackgroundColor(i);
        com.baidu.swan.apps.runtime.config.c NM = NM();
        if (NM != null) {
            NM.backgroundColor = i;
        }
        return true;
    }

    public SwanAppActionBar NG() {
        return this.bnK;
    }

    public boolean NH() {
        return this.mStatusBarColor == -1;
    }

    public void setRightExitViewVisibility(boolean z) {
        this.bnK.setRightExitViewVisibility(z);
    }

    public void setRightZoneVisibility(boolean z) {
        this.bnK.setRightZoneVisibility(z);
    }

    public void cp(boolean z) {
        FloatButton adS = com.baidu.swan.apps.scheme.actions.d.a.adQ().adS();
        if (!z) {
            if (adS != null && adS.getVisibility() == 0) {
                adS.setVisibility(8);
            }
        } else if (adS != null && adS.getVisibility() != 0) {
            adS.setVisibility(0);
        }
    }

    public void cq(boolean z) {
        b ew;
        e GH = com.baidu.swan.apps.y.f.WV().GH();
        if (GH != null) {
            if (z) {
                ew = GH.Oq();
            } else {
                ew = GH.ew(GH.Ot() - 1);
            }
            if (ew != null) {
                cp(ew.Ji());
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (DEBUG) {
            Log.d("SwanAppBaseFragment", MissionEvent.MESSAGE_RESUME);
        }
        if (getUserVisibleHint()) {
            resetWithCurImmersion();
        }
        NI();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (immersionEnabled() && this.bnP != null && configuration.orientation == 1) {
            auD().getWindow().clearFlags(1024);
            ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.d.b.8
                @Override // java.lang.Runnable
                public void run() {
                    b.this.resetWithCurImmersion();
                }
            }, 200L);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z) {
            resetWithCurImmersion();
        }
    }

    public void NI() {
        if (this.mActivity != null && this.bnK != null) {
            ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.d.b.9
                @Override // java.lang.Runnable
                public void run() {
                    if (com.baidu.swan.apps.ah.a.a.aaJ()) {
                        if (b.this.bnO == null) {
                            b.this.bnO = new TextView(b.this.mActivity);
                        }
                        if (!(b.this.bnO.getParent() instanceof SwanAppActionBar)) {
                            b.this.bnO.setText(a.h.aiapps_debug_open_cts);
                            b.this.bnO.setTextColor(b.this.getResources().getColor(17170455));
                            b.this.bnK.addView(b.this.bnO);
                        }
                    } else if (b.this.bnO != null) {
                        b.this.bnK.removeView(b.this.bnO);
                        b.this.bnO = null;
                    }
                }
            });
        }
    }

    public void x(int i, String str) {
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
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.bnK, "alpha", 0.0f, 1.0f);
        ofFloat.setDuration(i);
        ofFloat.setInterpolator(accelerateDecelerateInterpolator);
        ofFloat.start();
        if (this.bnP != null && this.bnP.ahy() != null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.bnP.ahy(), "alpha", 0.0f, 1.0f);
            ofFloat2.setDuration(i);
            ofFloat2.setInterpolator(accelerateDecelerateInterpolator);
            ofFloat2.start();
        }
    }

    @Nullable
    public boolean gS(String str) {
        if (this.bnK == null) {
            return false;
        }
        this.bnK.setTitle(str);
        com.baidu.swan.apps.runtime.config.c NM = NM();
        if (NM != null) {
            NM.bQv = str;
        }
        return true;
    }

    protected void NJ() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onActionBarBackPressed() {
        if (this.mActivity != null) {
            this.mActivity.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cr(boolean z) {
        this.bnK.setLeftBackViewVisibility(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void NK() {
        this.bnK.setLeftHomeViewVisibility(0);
        this.bnK.setLeftHomeViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.b.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.NJ();
            }
        });
    }

    @Override // com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        return true;
    }

    public final e GH() {
        if (this.mActivity == null) {
            return null;
        }
        return ((SwanAppActivity) this.mActivity).GH();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean NL() {
        e GH = GH();
        if (GH == null) {
            return false;
        }
        return GH.Ot() > 1;
    }

    public void finishAfterSlide() {
        e GH = GH();
        if (GH == null || GH.Ot() == 1) {
            if (this.mActivity != null) {
                this.mActivity.moveTaskToBack(true);
                return;
            }
            return;
        }
        GH.ha("navigateBack").Y(0, 0).Oy().commit();
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "back";
        a(fVar);
    }

    public void onPanelSlide(float f) {
        b(true, f);
    }

    public void onPanelClosed() {
        b(false, 1.0f);
    }

    private void b(boolean z, float f) {
        e GH = GH();
        if (GH != null && GH.Ot() >= 2) {
            b ew = GH.ew(GH.Ot() - 2);
            a(f, ew);
            if (z) {
                GH.Ou().g(ew);
            } else {
                GH.Ou().h(ew);
            }
        }
    }

    private void a(float f, Fragment fragment) {
        View view;
        float displayWidth = af.getDisplayWidth(this.mActivity) >> 2;
        float f2 = (f * displayWidth) - displayWidth;
        if (fragment != null && (view = fragment.getView()) != null) {
            view.setX(f2);
        }
    }

    public final void a(com.baidu.swan.apps.statistic.a.f fVar) {
        if (this.mActivity instanceof SwanAppActivity) {
            ((SwanAppActivity) this.mActivity).a(fVar);
        }
    }

    public boolean gT(String str) {
        return eu(SwanAppConfigData.cF(str));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean eu(@ColorInt int i) {
        if (this.bnK == null) {
            return false;
        }
        boolean z = this instanceof com.baidu.swan.apps.core.d.a;
        setRightExitViewVisibility(z ? false : true);
        return this.bnK.u(i, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean immersionEnabled() {
        return this.mImmersionEnabled;
    }

    protected com.baidu.swan.apps.runtime.config.c NM() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View initImmersion(View view) {
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
            return initImmersion(frameLayout, view);
        }
        return view;
    }

    protected View initImmersion(FrameLayout frameLayout, View view) {
        frameLayout.setTag("IMMERSION_LAYOUT_TAG");
        frameLayout.addView(view);
        this.bnP = new com.baidu.swan.apps.view.a.b(this.mActivity, frameLayout);
        applyImmersion();
        return frameLayout;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void applyImmersion() {
        if (this.bnP != null) {
            applyImmersion(this.mStatusBarColor);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void applyImmersion(@ColorInt int i) {
        if (this.bnP != null) {
            p(i, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(@ColorInt int i, boolean z) {
        if (this.bnP != null) {
            this.mStatusBarColor = i;
            this.bnP.setImmersion(i, z);
        }
    }

    public void resetWithCurImmersion() {
        if (immersionEnabled() && this.bnP != null) {
            this.bnP.resetWithCurImmersion();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setRequestedOrientation(int i) {
        if (this.mActivity != null) {
            this.mActivity.setRequestedOrientation(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View enableSliding(View view, SlideInterceptor slideInterceptor) {
        boolean z = getResources().getConfiguration().orientation != 2 && (NM() == null || !NM().bQD) && Build.VERSION.SDK_INT != 26;
        this.mSlideHelper = new SlideHelper();
        View wrapSlideView = this.mSlideHelper.wrapSlideView(view.getContext(), view, slideInterceptor);
        this.mSlideHelper.setFadeColor(0);
        this.mSlideHelper.setCanSlide(z);
        this.mSlideHelper.setSlideListener(new SlidingPaneLayout.PanelSlideListener() { // from class: com.baidu.swan.apps.core.d.b.2
            @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
            public void onPanelSlide(View view2, float f) {
                View maskView = b.this.mSlideHelper.getMaskView();
                if (maskView != null) {
                    maskView.setAlpha(1.0f - f);
                }
                b.this.onPanelSlide(f);
            }

            @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
            public void onPanelOpened(View view2) {
                b.this.finishAfterSlide();
            }

            @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
            public void onPanelClosed(View view2) {
                b.this.onPanelClosed();
            }
        });
        return wrapSlideView;
    }

    public final Resources NN() {
        return isAdded() ? getResources() : AppRuntime.getAppContext().getResources();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean NO() {
        if ((this.mActivity instanceof SwanAppActivity) && ((SwanAppActivity) this.mActivity).Gz() == 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int Gz() {
        if (this.mActivity instanceof SwanAppActivity) {
            return ((SwanAppActivity) this.mActivity).Gz();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zh() {
        if (this.mAudioManager != null && this.axF != null) {
            this.mAudioManager.abandonAudioFocus(this.axF);
        }
    }

    public boolean NP() {
        if (this.bnK == null) {
            return false;
        }
        this.bnK.ej(true);
        return true;
    }

    public boolean NQ() {
        if (this.bnK == null) {
            return false;
        }
        this.bnK.ej(false);
        return true;
    }

    public void cs(boolean z) {
        if (this.bnK != null) {
            this.bnK.setActionBarCustom(z);
        }
        if (this.bnN != null) {
            int i = 8;
            if (!z && NH()) {
                i = 0;
            }
            this.bnN.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int NR() {
        if (TextUtils.isEmpty(com.baidu.swan.apps.runtime.e.acK())) {
            return 0;
        }
        if (com.baidu.swan.apps.database.favorite.a.hB(com.baidu.swan.apps.runtime.e.acK())) {
            return 2;
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean NS() {
        return "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u".equals(com.baidu.swan.apps.runtime.e.acK());
    }

    public void NT() {
        com.baidu.swan.apps.scheme.actions.k.a.F("backtohome", "menu", com.baidu.swan.apps.y.f.WV().WF());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "gohome";
        fVar.mSource = "menu";
        a(fVar);
    }

    public void NU() {
    }

    public com.baidu.swan.apps.model.c NV() {
        return this.bnI;
    }

    /* loaded from: classes11.dex */
    private class a {
        private int bnS = 0;
        private long bnT = 0;
        private Runnable bnU;

        a(Runnable runnable) {
            this.bnU = runnable;
        }

        void onClick() {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.bnT > 1333) {
                this.bnT = currentTimeMillis;
                this.bnS = 1;
                return;
            }
            this.bnS++;
            if (this.bnS == 3) {
                if (this.bnU != null) {
                    this.bnU.run();
                }
                this.bnS = 0;
                this.bnT = 0L;
                return;
            }
            this.bnT = currentTimeMillis;
        }
    }
}
