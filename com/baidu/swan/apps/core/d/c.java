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
/* loaded from: classes3.dex */
public abstract class c extends Fragment implements SlideInterceptor {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private AudioManager.OnAudioFocusChangeListener bjL;
    @Nullable
    protected com.baidu.swan.apps.view.a.b cjA;
    private a cjC;
    private b cjD;
    protected com.baidu.swan.apps.model.c cjs;
    protected View cjt;
    protected SwanAppActionBar cju;
    protected com.baidu.swan.menu.h cjv;
    protected SwanAppMenuHeaderView cjw;
    protected String cjx;
    protected View cjy;
    protected TextView cjz;
    protected Activity mActivity;
    private AudioManager mAudioManager;
    protected SlideHelper mSlideHelper;
    private boolean mImmersionEnabled = com.baidu.swan.apps.view.a.b.SUPPORT_IMMERSION;
    private int cjB = 1;
    private int mStatusBarColor = 1;
    private boolean cjE = false;

    /* loaded from: classes3.dex */
    public interface b {
        void acB();
    }

    protected abstract boolean abW();

    public abstract boolean abv();

    protected abstract void acc();

    protected abstract void agK();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean agL();

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onAttach(Context context) {
        if (DEBUG) {
            Log.d("SwanAppBaseFragment", "onAttach");
        }
        super.onAttach(context);
        this.mActivity = aVF();
        dS(true);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDetach() {
        if (DEBUG) {
            Log.d("SwanAppBaseFragment", "onDetach");
        }
        this.mActivity = null;
        dS(false);
        super.onDetach();
        try {
            Field declaredField = Fragment.class.getDeclaredField("dJJ");
            declaredField.setAccessible(true);
            declaredField.set(this, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ak(View view) {
        com.baidu.swan.apps.runtime.config.c os;
        an(view);
        SwanAppConfigData aso = com.baidu.swan.apps.v.f.asJ().aso();
        if (aso == null) {
            if (DEBUG) {
                Log.d("SwanAppBaseFragment", "config data is null. " + Log.getStackTraceString(new Exception()));
                return;
            }
            return;
        }
        if (this.cjs == null) {
            os = aso.cSY;
        } else {
            os = com.baidu.swan.apps.v.f.asJ().os(com.baidu.swan.apps.scheme.actions.k.j.c(this.cjs.getPage(), aso));
        }
        he(os.cTH);
        this.cju.setTitle(os.cTI);
        this.cjC = new a(new Runnable() { // from class: com.baidu.swan.apps.core.d.c.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.y.f.avg();
            }
        });
        if (!(this instanceof SwanAppAdLandingFragment)) {
            hf(SwanAppConfigData.fq(os.cTJ));
        }
        this.cjx = os.cTJ;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void an(View view) {
        if (view != null) {
            this.cju = (SwanAppActionBar) view.findViewById(a.f.ai_apps_title_bar);
            this.cjt = view.findViewById(a.f.ai_apps_title_bar_root);
            this.cjy = view.findViewById(a.f.title_shadow);
            this.cju.setLeftBackViewMinWidth(ah.dip2px(this.mActivity, 38.0f));
            this.cju.setLeftBackViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (com.baidu.swan.apps.p.a.aoe().aof()) {
                        com.baidu.swan.apps.p.a.aoe().a(c.this.mActivity, new com.baidu.swan.apps.core.f.b<Boolean>() { // from class: com.baidu.swan.apps.core.d.c.4.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.swan.apps.core.f.b
                            /* renamed from: d */
                            public void L(Boolean bool) {
                                if (bool.booleanValue()) {
                                    c.this.ahi();
                                }
                            }
                        });
                    } else {
                        c.this.ahi();
                    }
                }
            });
            this.cju.setRightMenuOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    c.this.agK();
                    com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                    fVar.mValue = UgcConstant.MENU;
                    if (com.baidu.swan.apps.runtime.e.aAs() != null && com.baidu.swan.apps.runtime.e.aAs().aAJ().b("key_unread_counts_message", (Integer) 0).intValue() > 0) {
                        fVar.mPage = String.valueOf(1);
                    }
                    c.this.a(fVar);
                    if (c.this.cjC != null) {
                        c.this.cjC.onClick();
                    }
                }
            });
            this.cju.setRightExitOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.c.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (c.this.mActivity != null && (c.this.mActivity instanceof SwanAppActivity)) {
                        if (com.baidu.swan.apps.runtime.e.aAr() == null || com.baidu.swan.apps.runtime.e.aAt() == null) {
                            c.this.ahc();
                        } else if (com.baidu.swan.apps.p.a.aoe().aof()) {
                            com.baidu.swan.apps.p.a.aoe().a(c.this.mActivity, new com.baidu.swan.apps.core.f.b<Boolean>() { // from class: com.baidu.swan.apps.core.d.c.6.1
                                /* JADX DEBUG: Method merged with bridge method */
                                @Override // com.baidu.swan.apps.core.f.b
                                /* renamed from: d */
                                public void L(Boolean bool) {
                                    if (bool.booleanValue()) {
                                        c.this.ahc();
                                    }
                                }
                            });
                        } else if (com.baidu.swan.apps.p.c.aol().aom()) {
                            c.this.ahc();
                        } else {
                            com.baidu.swan.apps.p.b aog = new com.baidu.swan.apps.p.b().aog();
                            if (!aog.isShow()) {
                                c.this.ahc();
                                return;
                            }
                            com.baidu.swan.apps.p.c.aol().a(c.this.mActivity, aog.getImageUrl(), aog.aok(), c.this.ahb());
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c.a ahb() {
        return new c.a() { // from class: com.baidu.swan.apps.core.d.c.7
            @Override // com.baidu.swan.apps.p.c.a
            public void ahy() {
                c.this.ahc();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahc() {
        if (this.mActivity != null) {
            com.baidu.swan.apps.v.g.asS().setForeground(false);
            this.mActivity.moveTaskToBack(true);
            ahd();
            ((SwanAppActivity) this.mActivity).gx(1);
            ap.aGh().kz(2);
        }
    }

    private void ahd() {
        HashMap hashMap = new HashMap();
        hashMap.put("lcType", "onClose");
        hashMap.put("appId", com.baidu.swan.apps.runtime.e.aAt());
        com.baidu.swan.apps.v.f.asJ().b(new com.baidu.swan.apps.event.a.c(hashMap));
        com.baidu.swan.apps.console.c.i("SwanAppBaseFragment", "onClose");
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "close";
        a(fVar);
    }

    public boolean he(int i) {
        return v(i, false);
    }

    public boolean v(int i, boolean z) {
        if (this.cju == null || this.cjy == null) {
            return false;
        }
        this.mStatusBarColor = i;
        this.cju.setBackgroundColor(i);
        com.baidu.swan.apps.runtime.config.c ahl = ahl();
        if (ahl != null) {
            ahl.cTH = i;
            ahl.fL(z);
        }
        if (immersionEnabled()) {
            applyImmersion();
        }
        if (ahf()) {
            this.cjy.setVisibility(0);
        } else {
            this.cjy.setVisibility(8);
        }
        return true;
    }

    public boolean a(FrameLayout frameLayout, int i) {
        if (frameLayout == null) {
            return false;
        }
        frameLayout.setBackgroundColor(i);
        com.baidu.swan.apps.runtime.config.c ahl = ahl();
        if (ahl != null) {
            ahl.backgroundColor = i;
        }
        return true;
    }

    public SwanAppActionBar ahe() {
        return this.cju;
    }

    public boolean ahf() {
        return this.mStatusBarColor == -1;
    }

    public void setRightExitViewVisibility(boolean z) {
        this.cju.setRightExitViewVisibility(z);
    }

    public void setRightZoneVisibility(boolean z) {
        this.cju.setRightZoneVisibility(z);
    }

    public void dQ(boolean z) {
        this.cjE = z;
    }

    public void dR(boolean z) {
        FloatButton aBI = com.baidu.swan.apps.scheme.actions.d.a.aBG().aBI();
        if (!z) {
            if (aBI != null && aBI.getVisibility() == 0) {
                aBI.setVisibility(8);
            }
        } else if (aBI != null && aBI.getVisibility() != 0) {
            aBI.setVisibility(0);
        }
    }

    public void dS(boolean z) {
        c hh;
        f YG = com.baidu.swan.apps.v.f.asJ().YG();
        if (YG != null) {
            if (z) {
                hh = YG.ahW();
            } else {
                hh = YG.hh(YG.ahZ() - 1);
            }
            if (hh != null) {
                dR(hh.abW());
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
        ahg();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (immersionEnabled() && this.cjA != null && configuration.orientation == 1) {
            aVF().getWindow().clearFlags(1024);
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

    public void ahg() {
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.core.d.c.9
            @Override // java.lang.Runnable
            public void run() {
                c.this.dT(com.baidu.swan.apps.ad.a.a.axP());
            }
        }, "updateCtsView", 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dT(final boolean z) {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.d.c.10
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.mActivity != null && c.this.cju != null) {
                    if (z) {
                        if (c.this.cjz == null) {
                            c.this.cjz = new TextView(c.this.mActivity);
                        }
                        if (!(c.this.cjz.getParent() instanceof SwanAppActionBar)) {
                            c.this.cjz.setText(a.h.aiapps_debug_open_cts);
                            c.this.cjz.setTextColor(c.this.ahp().getColor(17170455));
                            c.this.cju.addView(c.this.cjz);
                        }
                    } else if (c.this.cjz != null) {
                        c.this.cju.removeView(c.this.cjz);
                        c.this.cjz = null;
                    }
                }
            }
        });
    }

    public void R(int i, String str) {
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
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.cju, "alpha", 0.0f, 1.0f);
        ofFloat.setDuration(i);
        ofFloat.setInterpolator(accelerateDecelerateInterpolator);
        ofFloat.start();
        if (this.cjA != null && this.cjA.aGy() != null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.cjA.aGy(), "alpha", 0.0f, 1.0f);
            ofFloat2.setDuration(i);
            ofFloat2.setInterpolator(accelerateDecelerateInterpolator);
            ofFloat2.start();
        }
    }

    @Nullable
    public boolean lA(String str) {
        return J(str, false);
    }

    public boolean J(String str, boolean z) {
        if (this.cju == null) {
            return false;
        }
        this.cju.setTitle(str);
        com.baidu.swan.apps.runtime.config.c ahl = ahl();
        if (ahl != null) {
            ahl.cTI = str;
            ahl.fL(z);
        }
        com.baidu.swan.apps.console.c.i("SwanAppBaseFragment", "page title: " + str);
        return true;
    }

    protected void ahh() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ahi() {
        if (this.mActivity != null) {
            this.mActivity.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dU(boolean z) {
        this.cju.setLeftBackViewVisibility(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ahj() {
        this.cju.setLeftHomeViewVisibility(0);
        this.cju.setLeftHomeViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.c.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.ahh();
            }
        });
    }

    public boolean isSlidable(MotionEvent motionEvent) {
        return true;
    }

    public final f YG() {
        if (this.mActivity == null) {
            return null;
        }
        return ((SwanAppActivity) this.mActivity).YG();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean ahk() {
        f YG = YG();
        if (YG == null) {
            return false;
        }
        return YG.ahZ() > 1;
    }

    public void finishAfterSlide() {
        f YG = YG();
        if (YG == null || YG.ahZ() == 1) {
            if (this.mActivity != null) {
                this.mActivity.moveTaskToBack(true);
                ap.aGh().kz(1);
                return;
            }
            return;
        }
        YG.lH("navigateBack").al(0, 0).aid().commit();
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
        f YG = YG();
        if (YG != null && YG.ahZ() >= 2) {
            c hh = YG.hh(YG.ahZ() - 2);
            a(f, hh);
            if (z) {
                YG.aia().h(hh);
            } else {
                YG.aia().i(hh);
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

    public boolean hf(int i) {
        return d(i, "", false);
    }

    public boolean K(String str, boolean z) {
        return d(SwanAppConfigData.fq(str), str, z);
    }

    protected boolean d(@ColorInt int i, String str, boolean z) {
        if (this.cju == null) {
            return false;
        }
        setRightExitViewVisibility(this.cjE ? false : true);
        com.baidu.swan.apps.runtime.config.c ahl = ahl();
        if (ahl != null) {
            if (!TextUtils.isEmpty(str)) {
                ahl.cTJ = str;
            }
            ahl.fL(z);
        }
        int i2 = i == -16777216 ? -16777216 : -1;
        if (immersionEnabled() && i2 != this.cjB) {
            this.cjB = i2;
            applyImmersion();
        }
        return this.cju.C(i, this.cjE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean immersionEnabled() {
        return this.mImmersionEnabled;
    }

    protected com.baidu.swan.apps.runtime.config.c ahl() {
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
        this.cjA = new com.baidu.swan.apps.view.a.b(this.mActivity, frameLayout);
        applyImmersion();
        return frameLayout;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void applyImmersion() {
        if (this.cjA != null) {
            applyImmersion(this.mStatusBarColor);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void applyImmersion(@ColorInt int i) {
        if (this.cjA != null) {
            w(i, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void w(@ColorInt int i, boolean z) {
        boolean z2 = true;
        if (this.cjA != null) {
            this.mStatusBarColor = i;
            if (this.cjB == 1) {
                z2 = com.baidu.swan.apps.ap.h.kv(i);
            } else if (this.cjB != -16777216) {
                z2 = false;
            }
            this.cjA.d(i, z, z2);
        }
    }

    public void resetWithCurImmersion() {
        if (immersionEnabled() && this.cjA != null) {
            this.cjA.resetWithCurImmersion();
        }
    }

    @Nullable
    public com.baidu.swan.apps.view.a.b ahm() {
        return this.cjA;
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
        ahn();
        aho();
        return wrapSlideView;
    }

    private void ahn() {
        if (ahl() != null && ahl().cTQ) {
            com.baidu.swan.apps.runtime.e aAs = com.baidu.swan.apps.runtime.e.aAs();
            if (aAs != null) {
                aAs.aAD().b(aAs.aAl(), "scope_disable_swipe_back", new com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.setting.oauth.h<b.d>>() { // from class: com.baidu.swan.apps.core.d.c.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.ap.e.b
                    /* renamed from: a */
                    public void J(com.baidu.swan.apps.setting.oauth.h<b.d> hVar) {
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
        return (ahp().getConfiguration().orientation == 2 || Build.VERSION.SDK_INT == 26) ? false : true;
    }

    private void aho() {
        this.mSlideHelper.setSlideListener(new SlidingPaneLayout.PanelSlideListener() { // from class: com.baidu.swan.apps.core.d.c.3
            @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
            public void onPanelSlide(View view, float f) {
                View maskView = c.this.mSlideHelper.getMaskView();
                if (maskView != null) {
                    maskView.setAlpha(1.0f - f);
                }
                c.this.onPanelSlide(f);
                if (c.this.cjD != null) {
                    c.this.cjD.acB();
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

    public final Resources ahp() {
        return isAdded() ? getResources() : AppRuntime.getAppContext().getResources();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean ahq() {
        if ((this.mActivity instanceof SwanAppActivity) && ((SwanAppActivity) this.mActivity).Yy() == 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int Yy() {
        if (this.mActivity instanceof SwanAppActivity) {
            return ((SwanAppActivity) this.mActivity).Yy();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void abandonAudioFocus() {
        if (this.mAudioManager != null && this.bjL != null) {
            this.mAudioManager.abandonAudioFocus(this.bjL);
        }
    }

    public boolean ahr() {
        if (this.cju == null) {
            return false;
        }
        this.cju.gh(true);
        return true;
    }

    public boolean ahs() {
        if (this.cju == null) {
            return false;
        }
        this.cju.gh(false);
        return true;
    }

    public void dV(boolean z) {
        if (this.cju != null) {
            this.cju.setActionBarCustom(z);
        }
        if (this.cjy != null) {
            int i = 8;
            if (!z && ahf()) {
                i = 0;
            }
            this.cjy.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int aht() {
        if (TextUtils.isEmpty(com.baidu.swan.apps.runtime.e.aAt())) {
            return 0;
        }
        if (com.baidu.swan.apps.database.favorite.a.mv(com.baidu.swan.apps.runtime.e.aAt())) {
            return 2;
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean ahu() {
        return "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u".equals(com.baidu.swan.apps.runtime.e.aAt());
    }

    public void ahv() {
        com.baidu.swan.apps.scheme.actions.k.a.M("backtohome", UgcConstant.MENU, com.baidu.swan.apps.v.f.asJ().ass());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "gohome";
        fVar.mSource = UgcConstant.MENU;
        a(fVar);
    }

    public void agO() {
    }

    public com.baidu.swan.apps.model.c ahw() {
        return this.cjs;
    }

    /* loaded from: classes3.dex */
    private class a {
        private int cjJ = 0;
        private long cjK = 0;
        private Runnable cjL;

        a(Runnable runnable) {
            this.cjL = runnable;
        }

        void onClick() {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.cjK > 1333) {
                this.cjK = currentTimeMillis;
                this.cjJ = 1;
                return;
            }
            this.cjJ++;
            if (this.cjJ == 3) {
                if (this.cjL != null) {
                    this.cjL.run();
                }
                this.cjJ = 0;
                this.cjK = 0L;
                return;
            }
            this.cjK = currentTimeMillis;
        }
    }

    public void a(b bVar) {
        this.cjD = bVar;
    }

    public View ahx() {
        return this.cjt;
    }
}
