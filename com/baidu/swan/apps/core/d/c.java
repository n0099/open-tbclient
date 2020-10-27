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
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.searchbox.widget.SlideHelper;
import com.baidu.searchbox.widget.SlideInterceptor;
import com.baidu.searchbox.widget.SlidingPaneLayout;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment;
import com.baidu.swan.apps.ap.ah;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.ap.ap;
import com.baidu.swan.apps.p.c;
import com.baidu.swan.apps.res.ui.FloatButton;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.setting.oauth.a.b;
import com.baidu.swan.apps.view.SwanAppActionBar;
import com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView;
import com.baidu.swan.support.v4.app.Fragment;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import java.lang.reflect.Field;
import java.util.HashMap;
/* loaded from: classes10.dex */
public abstract class c extends Fragment implements SlideInterceptor {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private AudioManager.OnAudioFocusChangeListener bpl;
    protected com.baidu.swan.apps.model.c cEg;
    protected View cEh;
    protected SwanAppActionBar cEi;
    protected com.baidu.swan.menu.h cEj;
    protected SwanAppMenuHeaderView cEk;
    protected String cEl;
    protected View cEm;
    protected TextView cEn;
    @Nullable
    protected com.baidu.swan.apps.view.a.b cEo;
    private a cEq;
    private b cEr;
    protected Activity mActivity;
    private AudioManager mAudioManager;
    protected SlideHelper mSlideHelper;
    private boolean mImmersionEnabled = com.baidu.swan.apps.view.a.b.SUPPORT_IMMERSION;
    private int cEp = 1;
    private int mStatusBarColor = 1;
    private boolean cEs = false;

    /* loaded from: classes10.dex */
    public interface b {
        void ahh();
    }

    protected abstract boolean agC();

    protected abstract void agI();

    public abstract boolean agb();

    protected abstract void alp();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean alq();

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onAttach(Context context) {
        if (DEBUG) {
            Log.d("SwanAppBaseFragment", "onAttach");
        }
        super.onAttach(context);
        this.mActivity = bah();
        eB(true);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDetach() {
        if (DEBUG) {
            Log.d("SwanAppBaseFragment", "onDetach");
        }
        this.mActivity = null;
        eB(false);
        super.onDetach();
        try {
            Field declaredField = Fragment.class.getDeclaredField("eeg");
            declaredField.setAccessible(true);
            declaredField.set(this, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void an(View view) {
        com.baidu.swan.apps.runtime.config.c px;
        ap(view);
        SwanAppConfigData awT = com.baidu.swan.apps.v.f.axo().awT();
        if (awT == null) {
            if (DEBUG) {
                Log.d("SwanAppBaseFragment", "config data is null. " + Log.getStackTraceString(new Exception()));
                return;
            }
            return;
        }
        if (this.cEg == null) {
            px = awT.dnG;
        } else {
            px = com.baidu.swan.apps.v.f.axo().px(com.baidu.swan.apps.scheme.actions.k.j.c(this.cEg.getPage(), awT));
        }
        hM(px.doq);
        this.cEi.setTitle(px.dor);
        this.cEq = new a(new Runnable() { // from class: com.baidu.swan.apps.core.d.c.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.y.f.azL();
            }
        });
        if (!(this instanceof SwanAppAdLandingFragment)) {
            hN(SwanAppConfigData.fv(px.dos));
        }
        this.cEl = px.dos;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ap(View view) {
        if (view != null) {
            this.cEi = (SwanAppActionBar) view.findViewById(a.f.ai_apps_title_bar);
            this.cEh = view.findViewById(a.f.ai_apps_title_bar_root);
            this.cEm = view.findViewById(a.f.title_shadow);
            this.cEi.setLeftBackViewMinWidth(ah.dip2px(this.mActivity, 38.0f));
            this.cEi.setLeftBackViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (com.baidu.swan.apps.p.a.asL().asM()) {
                        com.baidu.swan.apps.p.a.asL().a(c.this.mActivity, new com.baidu.swan.apps.core.f.b<Boolean>() { // from class: com.baidu.swan.apps.core.d.c.4.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.swan.apps.core.f.b
                            /* renamed from: e */
                            public void O(Boolean bool) {
                                if (bool.booleanValue()) {
                                    c.this.alN();
                                }
                            }
                        });
                    } else {
                        c.this.alN();
                    }
                }
            });
            this.cEi.setRightMenuOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    c.this.alp();
                    com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                    fVar.mValue = UgcConstant.MENU;
                    if (com.baidu.swan.apps.runtime.e.aEV() != null && com.baidu.swan.apps.runtime.e.aEV().aFm().b("key_unread_counts_message", (Integer) 0).intValue() > 0) {
                        fVar.mPage = String.valueOf(1);
                    }
                    c.this.a(fVar);
                    if (c.this.cEq != null) {
                        c.this.cEq.onClick();
                    }
                }
            });
            this.cEi.setRightExitOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.c.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (c.this.mActivity != null && (c.this.mActivity instanceof SwanAppActivity)) {
                        if (com.baidu.swan.apps.runtime.e.aEU() == null || com.baidu.swan.apps.runtime.e.aEW() == null) {
                            c.this.alH();
                        } else if (com.baidu.swan.apps.p.a.asL().asM()) {
                            com.baidu.swan.apps.p.a.asL().a(c.this.mActivity, new com.baidu.swan.apps.core.f.b<Boolean>() { // from class: com.baidu.swan.apps.core.d.c.6.1
                                /* JADX DEBUG: Method merged with bridge method */
                                @Override // com.baidu.swan.apps.core.f.b
                                /* renamed from: e */
                                public void O(Boolean bool) {
                                    if (bool.booleanValue()) {
                                        c.this.alH();
                                    }
                                }
                            });
                        } else if (com.baidu.swan.apps.p.c.asS().asT()) {
                            c.this.alH();
                        } else {
                            com.baidu.swan.apps.p.b asN = new com.baidu.swan.apps.p.b().asN();
                            if (!asN.isShow()) {
                                c.this.alH();
                                return;
                            }
                            com.baidu.swan.apps.p.c.asS().a(c.this.mActivity, asN.getImageUrl(), asN.asR(), c.this.alG());
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c.a alG() {
        return new c.a() { // from class: com.baidu.swan.apps.core.d.c.7
            @Override // com.baidu.swan.apps.p.c.a
            public void amd() {
                c.this.alH();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alH() {
        if (this.mActivity != null) {
            com.baidu.swan.apps.v.g.axx().setForeground(false);
            this.mActivity.moveTaskToBack(true);
            alI();
            ((SwanAppActivity) this.mActivity).hf(1);
            ap.aKK().lh(2);
        }
    }

    private void alI() {
        HashMap hashMap = new HashMap();
        hashMap.put("lcType", "onClose");
        hashMap.put("appId", com.baidu.swan.apps.runtime.e.aEW());
        com.baidu.swan.apps.v.f.axo().b(new com.baidu.swan.apps.event.a.c(hashMap));
        com.baidu.swan.apps.console.c.i("SwanAppBaseFragment", "onClose");
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "close";
        a(fVar);
    }

    public boolean hM(int i) {
        return x(i, false);
    }

    public boolean x(int i, boolean z) {
        if (this.cEi == null || this.cEm == null) {
            return false;
        }
        this.mStatusBarColor = i;
        this.cEi.setBackgroundColor(i);
        com.baidu.swan.apps.runtime.config.c alQ = alQ();
        if (alQ != null) {
            alQ.doq = i;
            alQ.gu(z);
        }
        if (immersionEnabled()) {
            applyImmersion();
        }
        if (alK()) {
            this.cEm.setVisibility(0);
        } else {
            this.cEm.setVisibility(8);
        }
        return true;
    }

    public boolean a(FrameLayout frameLayout, int i) {
        if (frameLayout == null) {
            return false;
        }
        frameLayout.setBackgroundColor(i);
        com.baidu.swan.apps.runtime.config.c alQ = alQ();
        if (alQ != null) {
            alQ.backgroundColor = i;
        }
        return true;
    }

    public SwanAppActionBar alJ() {
        return this.cEi;
    }

    public boolean alK() {
        return this.mStatusBarColor == -1;
    }

    public void setRightExitViewVisibility(boolean z) {
        this.cEi.setRightExitViewVisibility(z);
    }

    public void setRightZoneVisibility(boolean z) {
        this.cEi.setRightZoneVisibility(z);
    }

    public void ez(boolean z) {
        this.cEs = z;
    }

    public void eA(boolean z) {
        FloatButton aGl = com.baidu.swan.apps.scheme.actions.d.a.aGj().aGl();
        if (!z) {
            if (aGl != null && aGl.getVisibility() == 0) {
                aGl.setVisibility(8);
            }
        } else if (aGl != null && aGl.getVisibility() != 0) {
            aGl.setVisibility(0);
        }
    }

    public void eB(boolean z) {
        c hP;
        f adm = com.baidu.swan.apps.v.f.axo().adm();
        if (adm != null) {
            if (z) {
                hP = adm.amB();
            } else {
                hP = adm.hP(adm.amE() - 1);
            }
            if (hP != null) {
                eA(hP.agC());
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
        alL();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (immersionEnabled() && this.cEo != null && configuration.orientation == 1) {
            bah().getWindow().clearFlags(1024);
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.d.c.8
                @Override // java.lang.Runnable
                public void run() {
                    c.this.resetWithCurImmersion();
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

    public void alL() {
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.core.d.c.9
            @Override // java.lang.Runnable
            public void run() {
                c.this.eC(com.baidu.swan.apps.ad.a.a.aCu());
            }
        }, "updateCtsView", 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eC(final boolean z) {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.d.c.10
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.mActivity != null && c.this.cEi != null) {
                    if (z) {
                        if (c.this.cEn == null) {
                            c.this.cEn = new TextView(c.this.mActivity);
                        }
                        if (!(c.this.cEn.getParent() instanceof SwanAppActionBar)) {
                            c.this.cEn.setText(a.h.aiapps_debug_open_cts);
                            c.this.cEn.setTextColor(c.this.alU().getColor(17170455));
                            c.this.cEi.addView(c.this.cEn);
                        }
                    } else if (c.this.cEn != null) {
                        c.this.cEi.removeView(c.this.cEn);
                        c.this.cEn = null;
                    }
                }
            }
        });
    }

    public void ae(int i, String str) {
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
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.cEi, "alpha", 0.0f, 1.0f);
        ofFloat.setDuration(i);
        ofFloat.setInterpolator(accelerateDecelerateInterpolator);
        ofFloat.start();
        if (this.cEo != null && this.cEo.aLb() != null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.cEo.aLb(), "alpha", 0.0f, 1.0f);
            ofFloat2.setDuration(i);
            ofFloat2.setInterpolator(accelerateDecelerateInterpolator);
            ofFloat2.start();
        }
    }

    @Nullable
    public boolean mF(String str) {
        return P(str, false);
    }

    public boolean P(String str, boolean z) {
        if (this.cEi == null) {
            return false;
        }
        this.cEi.setTitle(str);
        com.baidu.swan.apps.runtime.config.c alQ = alQ();
        if (alQ != null) {
            alQ.dor = str;
            alQ.gu(z);
        }
        com.baidu.swan.apps.console.c.i("SwanAppBaseFragment", "page title: " + str);
        return true;
    }

    protected void alM() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void alN() {
        if (this.mActivity != null) {
            this.mActivity.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eD(boolean z) {
        this.cEi.setLeftBackViewVisibility(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void alO() {
        this.cEi.setLeftHomeViewVisibility(0);
        this.cEi.setLeftHomeViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.c.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.alM();
            }
        });
    }

    public boolean isSlidable(MotionEvent motionEvent) {
        return true;
    }

    public final f adm() {
        if (this.mActivity == null) {
            return null;
        }
        return ((SwanAppActivity) this.mActivity).adm();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean alP() {
        f adm = adm();
        if (adm == null) {
            return false;
        }
        return adm.amE() > 1;
    }

    public void finishAfterSlide() {
        f adm = adm();
        if (adm == null || adm.amE() == 1) {
            if (this.mActivity != null) {
                this.mActivity.moveTaskToBack(true);
                ap.aKK().lh(1);
                return;
            }
            return;
        }
        adm.mM("navigateBack").al(0, 0).amI().commit();
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
        f adm = adm();
        if (adm != null && adm.amE() >= 2) {
            c hP = adm.hP(adm.amE() - 2);
            a(f, hP);
            if (z) {
                adm.amF().h(hP);
            } else {
                adm.amF().i(hP);
            }
        }
    }

    private void a(float f, Fragment fragment) {
        View view;
        float displayWidth = ah.getDisplayWidth(this.mActivity) >> 2;
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

    public boolean hN(int i) {
        return f(i, "", false);
    }

    public boolean Q(String str, boolean z) {
        return f(SwanAppConfigData.fv(str), str, z);
    }

    protected boolean f(@ColorInt int i, String str, boolean z) {
        if (this.cEi == null) {
            return false;
        }
        setRightExitViewVisibility(this.cEs ? false : true);
        com.baidu.swan.apps.runtime.config.c alQ = alQ();
        if (alQ != null) {
            if (!TextUtils.isEmpty(str)) {
                alQ.dos = str;
            }
            alQ.gu(z);
        }
        int i2 = i == -16777216 ? -16777216 : -1;
        if (immersionEnabled() && i2 != this.cEp) {
            this.cEp = i2;
            applyImmersion();
        }
        return this.cEi.E(i, this.cEs);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean immersionEnabled() {
        return this.mImmersionEnabled;
    }

    protected com.baidu.swan.apps.runtime.config.c alQ() {
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
        this.cEo = new com.baidu.swan.apps.view.a.b(this.mActivity, frameLayout);
        applyImmersion();
        return frameLayout;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void applyImmersion() {
        if (this.cEo != null) {
            applyImmersion(this.mStatusBarColor);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void applyImmersion(@ColorInt int i) {
        if (this.cEo != null) {
            y(i, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void y(@ColorInt int i, boolean z) {
        boolean z2 = true;
        if (this.cEo != null) {
            this.mStatusBarColor = i;
            if (this.cEp == 1) {
                z2 = com.baidu.swan.apps.ap.h.ld(i);
            } else if (this.cEp != -16777216) {
                z2 = false;
            }
            this.cEo.d(i, z, z2);
        }
    }

    public void resetWithCurImmersion() {
        if (immersionEnabled() && this.cEo != null) {
            this.cEo.resetWithCurImmersion();
        }
    }

    @Nullable
    public com.baidu.swan.apps.view.a.b alR() {
        return this.cEo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setRequestedOrientation(int i) {
        if (this.mActivity != null) {
            this.mActivity.setRequestedOrientation(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View enableSliding(View view, SlideInterceptor slideInterceptor) {
        this.mSlideHelper = new SlideHelper();
        View wrapSlideView = this.mSlideHelper.wrapSlideView(view.getContext(), view, slideInterceptor);
        this.mSlideHelper.setFadeColor(0);
        alS();
        alT();
        return wrapSlideView;
    }

    private void alS() {
        if (alQ() != null && alQ().doA) {
            com.baidu.swan.apps.runtime.e aEV = com.baidu.swan.apps.runtime.e.aEV();
            if (aEV != null) {
                aEV.aFg().b(aEV.aEO(), "scope_disable_swipe_back", new com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.setting.oauth.h<b.d>>() { // from class: com.baidu.swan.apps.core.d.c.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.ap.e.b
                    /* renamed from: a */
                    public void M(com.baidu.swan.apps.setting.oauth.h<b.d> hVar) {
                        if (!com.baidu.swan.apps.setting.oauth.c.b(hVar)) {
                            c.this.mSlideHelper.setCanSlide(c.this.canSlide());
                        } else {
                            c.this.mSlideHelper.setCanSlide(false);
                        }
                    }
                });
                return;
            } else {
                this.mSlideHelper.setCanSlide(canSlide());
                return;
            }
        }
        this.mSlideHelper.setCanSlide(canSlide());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canSlide() {
        return (alU().getConfiguration().orientation == 2 || Build.VERSION.SDK_INT == 26) ? false : true;
    }

    private void alT() {
        this.mSlideHelper.setSlideListener(new SlidingPaneLayout.PanelSlideListener() { // from class: com.baidu.swan.apps.core.d.c.3
            @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
            public void onPanelSlide(View view, float f) {
                View maskView = c.this.mSlideHelper.getMaskView();
                if (maskView != null) {
                    maskView.setAlpha(1.0f - f);
                }
                c.this.onPanelSlide(f);
                if (c.this.cEr != null) {
                    c.this.cEr.ahh();
                }
            }

            @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
            public void onPanelOpened(View view) {
                c.this.finishAfterSlide();
            }

            @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
            public void onPanelClosed(View view) {
                c.this.onPanelClosed();
            }
        });
    }

    public final Resources alU() {
        return isAdded() ? getResources() : AppRuntime.getAppContext().getResources();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean alV() {
        if ((this.mActivity instanceof SwanAppActivity) && ((SwanAppActivity) this.mActivity).ade() == 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int ade() {
        if (this.mActivity instanceof SwanAppActivity) {
            return ((SwanAppActivity) this.mActivity).ade();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void abandonAudioFocus() {
        if (this.mAudioManager != null && this.bpl != null) {
            this.mAudioManager.abandonAudioFocus(this.bpl);
        }
    }

    public boolean alW() {
        if (this.cEi == null) {
            return false;
        }
        this.cEi.gQ(true);
        return true;
    }

    public boolean alX() {
        if (this.cEi == null) {
            return false;
        }
        this.cEi.gQ(false);
        return true;
    }

    public void eE(boolean z) {
        if (this.cEi != null) {
            this.cEi.setActionBarCustom(z);
        }
        if (this.cEm != null) {
            int i = 8;
            if (!z && alK()) {
                i = 0;
            }
            this.cEm.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int alY() {
        if (TextUtils.isEmpty(com.baidu.swan.apps.runtime.e.aEW())) {
            return 0;
        }
        if (com.baidu.swan.apps.database.favorite.a.nA(com.baidu.swan.apps.runtime.e.aEW())) {
            return 2;
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean alZ() {
        return "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u".equals(com.baidu.swan.apps.runtime.e.aEW());
    }

    public void ama() {
        com.baidu.swan.apps.scheme.actions.k.a.U("backtohome", UgcConstant.MENU, com.baidu.swan.apps.v.f.axo().awX());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "gohome";
        fVar.mSource = UgcConstant.MENU;
        a(fVar);
    }

    public void alt() {
    }

    public com.baidu.swan.apps.model.c amb() {
        return this.cEg;
    }

    /* loaded from: classes10.dex */
    private class a {
        private int cEx = 0;
        private long cEy = 0;
        private Runnable cEz;

        a(Runnable runnable) {
            this.cEz = runnable;
        }

        void onClick() {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.cEy > 1333) {
                this.cEy = currentTimeMillis;
                this.cEx = 1;
                return;
            }
            this.cEx++;
            if (this.cEx == 3) {
                if (this.cEz != null) {
                    this.cEz.run();
                }
                this.cEx = 0;
                this.cEy = 0L;
                return;
            }
            this.cEy = currentTimeMillis;
        }
    }

    public void a(b bVar) {
        this.cEr = bVar;
    }

    public View amc() {
        return this.cEh;
    }
}
