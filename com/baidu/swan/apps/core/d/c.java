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
/* loaded from: classes7.dex */
public abstract class c extends Fragment implements SlideInterceptor {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private AudioManager.OnAudioFocusChangeListener boT;
    private b cIA;
    protected com.baidu.swan.apps.model.c cIp;
    protected View cIq;
    protected SwanAppActionBar cIr;
    protected com.baidu.swan.menu.h cIs;
    protected SwanAppMenuHeaderView cIt;
    protected String cIu;
    protected View cIv;
    protected TextView cIw;
    @Nullable
    protected com.baidu.swan.apps.view.a.b cIx;
    private a cIz;
    protected Activity mActivity;
    private AudioManager mAudioManager;
    protected SlideHelper mSlideHelper;
    private boolean mImmersionEnabled = com.baidu.swan.apps.view.a.b.SUPPORT_IMMERSION;
    private int cIy = 1;
    private int mStatusBarColor = 1;
    private boolean cIB = false;

    /* loaded from: classes7.dex */
    public interface b {
        void aiZ();
    }

    public abstract boolean ahT();

    protected abstract void aiA();

    protected abstract boolean aiu();

    protected abstract void anh();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean ani();

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onAttach(Context context) {
        if (DEBUG) {
            Log.d("SwanAppBaseFragment", "onAttach");
        }
        super.onAttach(context);
        this.mActivity = bca();
        eN(true);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDetach() {
        if (DEBUG) {
            Log.d("SwanAppBaseFragment", "onDetach");
        }
        this.mActivity = null;
        eN(false);
        super.onDetach();
        try {
            Field declaredField = Fragment.class.getDeclaredField("eir");
            declaredField.setAccessible(true);
            declaredField.set(this, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ar(View view) {
        com.baidu.swan.apps.runtime.config.c pF;
        at(view);
        SwanAppConfigData ayL = com.baidu.swan.apps.v.f.azg().ayL();
        if (ayL == null) {
            if (DEBUG) {
                Log.d("SwanAppBaseFragment", "config data is null. " + Log.getStackTraceString(new Exception()));
                return;
            }
            return;
        }
        if (this.cIp == null) {
            pF = ayL.drU;
        } else {
            pF = com.baidu.swan.apps.v.f.azg().pF(com.baidu.swan.apps.scheme.actions.k.j.c(this.cIp.getPage(), ayL));
        }
        hS(pF.dsE);
        this.cIr.setTitle(pF.dsF);
        this.cIz = new a(new Runnable() { // from class: com.baidu.swan.apps.core.d.c.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.y.f.aBD();
            }
        });
        if (!(this instanceof SwanAppAdLandingFragment)) {
            hT(SwanAppConfigData.sa(pF.dsG));
        }
        this.cIu = pF.dsG;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void at(View view) {
        if (view != null) {
            this.cIr = (SwanAppActionBar) view.findViewById(a.f.ai_apps_title_bar);
            this.cIq = view.findViewById(a.f.ai_apps_title_bar_root);
            this.cIv = view.findViewById(a.f.title_shadow);
            this.cIr.setLeftBackViewMinWidth(ah.dip2px(this.mActivity, 38.0f));
            this.cIr.setLeftBackViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (com.baidu.swan.apps.p.a.auD().auE()) {
                        com.baidu.swan.apps.p.a.auD().a(c.this.mActivity, new com.baidu.swan.apps.core.f.b<Boolean>() { // from class: com.baidu.swan.apps.core.d.c.4.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.swan.apps.core.f.b
                            /* renamed from: e */
                            public void O(Boolean bool) {
                                if (bool.booleanValue()) {
                                    c.this.anF();
                                }
                            }
                        });
                    } else {
                        c.this.anF();
                    }
                }
            });
            this.cIr.setRightMenuOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    c.this.anh();
                    com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                    fVar.mValue = UgcConstant.MENU;
                    if (com.baidu.swan.apps.runtime.e.aGN() != null && com.baidu.swan.apps.runtime.e.aGN().aHe().b("key_unread_counts_message", (Integer) 0).intValue() > 0) {
                        fVar.mPage = String.valueOf(1);
                    }
                    c.this.a(fVar);
                    if (c.this.cIz != null) {
                        c.this.cIz.onClick();
                    }
                }
            });
            this.cIr.setRightExitOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.c.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (c.this.mActivity != null && (c.this.mActivity instanceof SwanAppActivity)) {
                        if (com.baidu.swan.apps.runtime.e.aGM() == null || com.baidu.swan.apps.runtime.e.aGO() == null) {
                            c.this.anz();
                        } else if (com.baidu.swan.apps.p.a.auD().auE()) {
                            com.baidu.swan.apps.p.a.auD().a(c.this.mActivity, new com.baidu.swan.apps.core.f.b<Boolean>() { // from class: com.baidu.swan.apps.core.d.c.6.1
                                /* JADX DEBUG: Method merged with bridge method */
                                @Override // com.baidu.swan.apps.core.f.b
                                /* renamed from: e */
                                public void O(Boolean bool) {
                                    if (bool.booleanValue()) {
                                        c.this.anz();
                                    }
                                }
                            });
                        } else if (com.baidu.swan.apps.p.c.auK().auL()) {
                            c.this.anz();
                        } else {
                            com.baidu.swan.apps.p.b auF = new com.baidu.swan.apps.p.b().auF();
                            if (!auF.isShow()) {
                                c.this.anz();
                                return;
                            }
                            com.baidu.swan.apps.p.c.auK().a(c.this.mActivity, auF.getImageUrl(), auF.auJ(), c.this.any());
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c.a any() {
        return new c.a() { // from class: com.baidu.swan.apps.core.d.c.7
            @Override // com.baidu.swan.apps.p.c.a
            public void anV() {
                c.this.anz();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anz() {
        if (this.mActivity != null) {
            com.baidu.swan.apps.v.g.azp().setForeground(false);
            this.mActivity.moveTaskToBack(true);
            anA();
            ((SwanAppActivity) this.mActivity).hl(1);
            ap.aMC().ln(2);
        }
    }

    private void anA() {
        HashMap hashMap = new HashMap();
        hashMap.put("lcType", "onClose");
        hashMap.put("appId", com.baidu.swan.apps.runtime.e.aGO());
        com.baidu.swan.apps.v.f.azg().b(new com.baidu.swan.apps.event.a.c(hashMap));
        com.baidu.swan.apps.console.c.i("SwanAppBaseFragment", "onClose");
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "close";
        a(fVar);
    }

    public boolean hS(int i) {
        return x(i, false);
    }

    public boolean x(int i, boolean z) {
        if (this.cIr == null || this.cIv == null) {
            return false;
        }
        this.mStatusBarColor = i;
        this.cIr.setBackgroundColor(i);
        com.baidu.swan.apps.runtime.config.c anI = anI();
        if (anI != null) {
            anI.dsE = i;
            anI.gG(z);
        }
        if (immersionEnabled()) {
            applyImmersion();
        }
        if (anC()) {
            this.cIv.setVisibility(0);
        } else {
            this.cIv.setVisibility(8);
        }
        return true;
    }

    public boolean a(FrameLayout frameLayout, int i) {
        if (frameLayout == null) {
            return false;
        }
        frameLayout.setBackgroundColor(i);
        com.baidu.swan.apps.runtime.config.c anI = anI();
        if (anI != null) {
            anI.backgroundColor = i;
        }
        return true;
    }

    public SwanAppActionBar anB() {
        return this.cIr;
    }

    public boolean anC() {
        return this.mStatusBarColor == -1;
    }

    public void setRightExitViewVisibility(boolean z) {
        this.cIr.setRightExitViewVisibility(z);
    }

    public void setRightZoneVisibility(boolean z) {
        this.cIr.setRightZoneVisibility(z);
    }

    public void eL(boolean z) {
        this.cIB = z;
    }

    public void eM(boolean z) {
        FloatButton aId = com.baidu.swan.apps.scheme.actions.d.a.aIb().aId();
        if (!z) {
            if (aId != null && aId.getVisibility() == 0) {
                aId.setVisibility(8);
            }
        } else if (aId != null && aId.getVisibility() != 0) {
            aId.setVisibility(0);
        }
    }

    public void eN(boolean z) {
        c hV;
        f afe = com.baidu.swan.apps.v.f.azg().afe();
        if (afe != null) {
            if (z) {
                hV = afe.aot();
            } else {
                hV = afe.hV(afe.aow() - 1);
            }
            if (hV != null) {
                eM(hV.aiu());
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
        anD();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (immersionEnabled() && this.cIx != null && configuration.orientation == 1) {
            bca().getWindow().clearFlags(1024);
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

    public void anD() {
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.core.d.c.9
            @Override // java.lang.Runnable
            public void run() {
                c.this.eO(com.baidu.swan.apps.ad.a.a.aEm());
            }
        }, "updateCtsView", 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eO(final boolean z) {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.d.c.10
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.mActivity != null && c.this.cIr != null) {
                    if (z) {
                        if (c.this.cIw == null) {
                            c.this.cIw = new TextView(c.this.mActivity);
                        }
                        if (!(c.this.cIw.getParent() instanceof SwanAppActionBar)) {
                            c.this.cIw.setText(a.h.aiapps_debug_open_cts);
                            c.this.cIw.setTextColor(c.this.anM().getColor(17170455));
                            c.this.cIr.addView(c.this.cIw);
                        }
                    } else if (c.this.cIw != null) {
                        c.this.cIr.removeView(c.this.cIw);
                        c.this.cIw = null;
                    }
                }
            }
        });
    }

    public void ai(int i, String str) {
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
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.cIr, "alpha", 0.0f, 1.0f);
        ofFloat.setDuration(i);
        ofFloat.setInterpolator(accelerateDecelerateInterpolator);
        ofFloat.start();
        if (this.cIx != null && this.cIx.aMT() != null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.cIx.aMT(), "alpha", 0.0f, 1.0f);
            ofFloat2.setDuration(i);
            ofFloat2.setInterpolator(accelerateDecelerateInterpolator);
            ofFloat2.start();
        }
    }

    @Nullable
    public boolean mO(String str) {
        return P(str, false);
    }

    public boolean P(String str, boolean z) {
        if (this.cIr == null) {
            return false;
        }
        this.cIr.setTitle(str);
        com.baidu.swan.apps.runtime.config.c anI = anI();
        if (anI != null) {
            anI.dsF = str;
            anI.gG(z);
        }
        com.baidu.swan.apps.console.c.i("SwanAppBaseFragment", "page title: " + str);
        return true;
    }

    protected void anE() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void anF() {
        if (this.mActivity != null) {
            this.mActivity.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eP(boolean z) {
        this.cIr.setLeftBackViewVisibility(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void anG() {
        this.cIr.setLeftHomeViewVisibility(0);
        this.cIr.setLeftHomeViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.c.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.anE();
            }
        });
    }

    public boolean isSlidable(MotionEvent motionEvent) {
        return true;
    }

    public final f afe() {
        if (this.mActivity == null) {
            return null;
        }
        return ((SwanAppActivity) this.mActivity).afe();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean anH() {
        f afe = afe();
        if (afe == null) {
            return false;
        }
        return afe.aow() > 1;
    }

    public void finishAfterSlide() {
        f afe = afe();
        if (afe == null || afe.aow() == 1) {
            if (this.mActivity != null) {
                this.mActivity.moveTaskToBack(true);
                ap.aMC().ln(1);
                return;
            }
            return;
        }
        afe.mV("navigateBack").al(0, 0).aoA().commit();
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
        f afe = afe();
        if (afe != null && afe.aow() >= 2) {
            c hV = afe.hV(afe.aow() - 2);
            a(f, hV);
            if (z) {
                afe.aox().h(hV);
            } else {
                afe.aox().i(hV);
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

    public boolean hT(int i) {
        return f(i, "", false);
    }

    public boolean Q(String str, boolean z) {
        return f(SwanAppConfigData.sa(str), str, z);
    }

    protected boolean f(@ColorInt int i, String str, boolean z) {
        if (this.cIr == null) {
            return false;
        }
        setRightExitViewVisibility(this.cIB ? false : true);
        com.baidu.swan.apps.runtime.config.c anI = anI();
        if (anI != null) {
            if (!TextUtils.isEmpty(str)) {
                anI.dsG = str;
            }
            anI.gG(z);
        }
        int i2 = i == -16777216 ? -16777216 : -1;
        if (immersionEnabled() && i2 != this.cIy) {
            this.cIy = i2;
            applyImmersion();
        }
        return this.cIr.E(i, this.cIB);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean immersionEnabled() {
        return this.mImmersionEnabled;
    }

    protected com.baidu.swan.apps.runtime.config.c anI() {
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
        this.cIx = new com.baidu.swan.apps.view.a.b(this.mActivity, frameLayout);
        applyImmersion();
        return frameLayout;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void applyImmersion() {
        if (this.cIx != null) {
            applyImmersion(this.mStatusBarColor);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void applyImmersion(@ColorInt int i) {
        if (this.cIx != null) {
            y(i, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void y(@ColorInt int i, boolean z) {
        boolean z2 = true;
        if (this.cIx != null) {
            this.mStatusBarColor = i;
            if (this.cIy == 1) {
                z2 = com.baidu.swan.apps.ap.h.lj(i);
            } else if (this.cIy != -16777216) {
                z2 = false;
            }
            this.cIx.d(i, z, z2);
        }
    }

    public void resetWithCurImmersion() {
        if (immersionEnabled() && this.cIx != null) {
            this.cIx.resetWithCurImmersion();
        }
    }

    @Nullable
    public com.baidu.swan.apps.view.a.b anJ() {
        return this.cIx;
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
        anK();
        anL();
        return wrapSlideView;
    }

    private void anK() {
        if (anI() != null && anI().dsN) {
            com.baidu.swan.apps.runtime.e aGN = com.baidu.swan.apps.runtime.e.aGN();
            if (aGN != null) {
                aGN.aGY().b(aGN.aGG(), "scope_disable_swipe_back", new com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.setting.oauth.h<b.d>>() { // from class: com.baidu.swan.apps.core.d.c.2
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
        return (anM().getConfiguration().orientation == 2 || Build.VERSION.SDK_INT == 26) ? false : true;
    }

    private void anL() {
        this.mSlideHelper.setSlideListener(new SlidingPaneLayout.PanelSlideListener() { // from class: com.baidu.swan.apps.core.d.c.3
            @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
            public void onPanelSlide(View view, float f) {
                View maskView = c.this.mSlideHelper.getMaskView();
                if (maskView != null) {
                    maskView.setAlpha(1.0f - f);
                }
                c.this.onPanelSlide(f);
                if (c.this.cIA != null) {
                    c.this.cIA.aiZ();
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

    public final Resources anM() {
        return isAdded() ? getResources() : AppRuntime.getAppContext().getResources();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean anN() {
        if ((this.mActivity instanceof SwanAppActivity) && ((SwanAppActivity) this.mActivity).aeW() == 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int aeW() {
        if (this.mActivity instanceof SwanAppActivity) {
            return ((SwanAppActivity) this.mActivity).aeW();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void abandonAudioFocus() {
        if (this.mAudioManager != null && this.boT != null) {
            this.mAudioManager.abandonAudioFocus(this.boT);
        }
    }

    public boolean anO() {
        if (this.cIr == null) {
            return false;
        }
        this.cIr.hc(true);
        return true;
    }

    public boolean anP() {
        if (this.cIr == null) {
            return false;
        }
        this.cIr.hc(false);
        return true;
    }

    public void eQ(boolean z) {
        if (this.cIr != null) {
            this.cIr.setActionBarCustom(z);
        }
        if (this.cIv != null) {
            int i = 8;
            if (!z && anC()) {
                i = 0;
            }
            this.cIv.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int anQ() {
        if (TextUtils.isEmpty(com.baidu.swan.apps.runtime.e.aGO())) {
            return 0;
        }
        if (com.baidu.swan.apps.database.favorite.a.nI(com.baidu.swan.apps.runtime.e.aGO())) {
            return 2;
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean anR() {
        return "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u".equals(com.baidu.swan.apps.runtime.e.aGO());
    }

    public void anS() {
        com.baidu.swan.apps.scheme.actions.k.a.U("backtohome", UgcConstant.MENU, com.baidu.swan.apps.v.f.azg().ayP());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "gohome";
        fVar.mSource = UgcConstant.MENU;
        a(fVar);
    }

    public void anl() {
    }

    public com.baidu.swan.apps.model.c anT() {
        return this.cIp;
    }

    /* loaded from: classes7.dex */
    private class a {
        private int cIG = 0;
        private long cIH = 0;
        private Runnable cII;

        a(Runnable runnable) {
            this.cII = runnable;
        }

        void onClick() {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.cIH > 1333) {
                this.cIH = currentTimeMillis;
                this.cIG = 1;
                return;
            }
            this.cIG++;
            if (this.cIG == 3) {
                if (this.cII != null) {
                    this.cII.run();
                }
                this.cIG = 0;
                this.cIH = 0L;
                return;
            }
            this.cIH = currentTimeMillis;
        }
    }

    public void a(b bVar) {
        this.cIA = bVar;
    }

    public View anU() {
        return this.cIq;
    }
}
