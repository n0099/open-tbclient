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
    private AudioManager.OnAudioFocusChangeListener bqE;
    protected com.baidu.swan.apps.model.c cJZ;
    protected View cKa;
    protected SwanAppActionBar cKb;
    protected com.baidu.swan.menu.h cKc;
    protected SwanAppMenuHeaderView cKd;
    protected String cKe;
    protected View cKf;
    protected TextView cKg;
    @Nullable
    protected com.baidu.swan.apps.view.a.b cKh;
    private a cKj;
    private b cKk;
    protected Activity mActivity;
    private AudioManager mAudioManager;
    protected SlideHelper mSlideHelper;
    private boolean mImmersionEnabled = com.baidu.swan.apps.view.a.b.SUPPORT_IMMERSION;
    private int cKi = 1;
    private int mStatusBarColor = 1;
    private boolean cKl = false;

    /* loaded from: classes10.dex */
    public interface b {
        void ajH();
    }

    public abstract boolean aiB();

    protected abstract boolean ajc();

    protected abstract void aji();

    protected abstract void anP();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean anQ();

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onAttach(Context context) {
        if (DEBUG) {
            Log.d("SwanAppBaseFragment", "onAttach");
        }
        super.onAttach(context);
        this.mActivity = bcH();
        eK(true);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDetach() {
        if (DEBUG) {
            Log.d("SwanAppBaseFragment", "onDetach");
        }
        this.mActivity = null;
        eK(false);
        super.onDetach();
        try {
            Field declaredField = Fragment.class.getDeclaredField("ejY");
            declaredField.setAccessible(true);
            declaredField.set(this, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ar(View view) {
        com.baidu.swan.apps.runtime.config.c pL;
        at(view);
        SwanAppConfigData azt = com.baidu.swan.apps.v.f.azO().azt();
        if (azt == null) {
            if (DEBUG) {
                Log.d("SwanAppBaseFragment", "config data is null. " + Log.getStackTraceString(new Exception()));
                return;
            }
            return;
        }
        if (this.cJZ == null) {
            pL = azt.dtD;
        } else {
            pL = com.baidu.swan.apps.v.f.azO().pL(com.baidu.swan.apps.scheme.actions.k.j.c(this.cJZ.getPage(), azt));
        }
        hW(pL.dum);
        this.cKb.setTitle(pL.dun);
        this.cKj = new a(new Runnable() { // from class: com.baidu.swan.apps.core.d.c.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.y.f.aCl();
            }
        });
        if (!(this instanceof SwanAppAdLandingFragment)) {
            hX(SwanAppConfigData.fv(pL.duo));
        }
        this.cKe = pL.duo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void at(View view) {
        if (view != null) {
            this.cKb = (SwanAppActionBar) view.findViewById(a.f.ai_apps_title_bar);
            this.cKa = view.findViewById(a.f.ai_apps_title_bar_root);
            this.cKf = view.findViewById(a.f.title_shadow);
            this.cKb.setLeftBackViewMinWidth(ah.dip2px(this.mActivity, 38.0f));
            this.cKb.setLeftBackViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (com.baidu.swan.apps.p.a.avl().avm()) {
                        com.baidu.swan.apps.p.a.avl().a(c.this.mActivity, new com.baidu.swan.apps.core.f.b<Boolean>() { // from class: com.baidu.swan.apps.core.d.c.4.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.swan.apps.core.f.b
                            /* renamed from: e */
                            public void O(Boolean bool) {
                                if (bool.booleanValue()) {
                                    c.this.aon();
                                }
                            }
                        });
                    } else {
                        c.this.aon();
                    }
                }
            });
            this.cKb.setRightMenuOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    c.this.anP();
                    com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                    fVar.mValue = UgcConstant.MENU;
                    if (com.baidu.swan.apps.runtime.e.aHv() != null && com.baidu.swan.apps.runtime.e.aHv().aHM().b("key_unread_counts_message", (Integer) 0).intValue() > 0) {
                        fVar.mPage = String.valueOf(1);
                    }
                    c.this.a(fVar);
                    if (c.this.cKj != null) {
                        c.this.cKj.onClick();
                    }
                }
            });
            this.cKb.setRightExitOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.c.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (c.this.mActivity != null && (c.this.mActivity instanceof SwanAppActivity)) {
                        if (com.baidu.swan.apps.runtime.e.aHu() == null || com.baidu.swan.apps.runtime.e.aHw() == null) {
                            c.this.aoh();
                        } else if (com.baidu.swan.apps.p.a.avl().avm()) {
                            com.baidu.swan.apps.p.a.avl().a(c.this.mActivity, new com.baidu.swan.apps.core.f.b<Boolean>() { // from class: com.baidu.swan.apps.core.d.c.6.1
                                /* JADX DEBUG: Method merged with bridge method */
                                @Override // com.baidu.swan.apps.core.f.b
                                /* renamed from: e */
                                public void O(Boolean bool) {
                                    if (bool.booleanValue()) {
                                        c.this.aoh();
                                    }
                                }
                            });
                        } else if (com.baidu.swan.apps.p.c.avs().avt()) {
                            c.this.aoh();
                        } else {
                            com.baidu.swan.apps.p.b avn = new com.baidu.swan.apps.p.b().avn();
                            if (!avn.isShow()) {
                                c.this.aoh();
                                return;
                            }
                            com.baidu.swan.apps.p.c.avs().a(c.this.mActivity, avn.getImageUrl(), avn.avr(), c.this.aog());
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c.a aog() {
        return new c.a() { // from class: com.baidu.swan.apps.core.d.c.7
            @Override // com.baidu.swan.apps.p.c.a
            public void aoD() {
                c.this.aoh();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoh() {
        if (this.mActivity != null) {
            com.baidu.swan.apps.v.g.azX().setForeground(false);
            this.mActivity.moveTaskToBack(true);
            aoi();
            ((SwanAppActivity) this.mActivity).hp(1);
            ap.aNk().lr(2);
        }
    }

    private void aoi() {
        HashMap hashMap = new HashMap();
        hashMap.put("lcType", "onClose");
        hashMap.put("appId", com.baidu.swan.apps.runtime.e.aHw());
        com.baidu.swan.apps.v.f.azO().b(new com.baidu.swan.apps.event.a.c(hashMap));
        com.baidu.swan.apps.console.c.i("SwanAppBaseFragment", "onClose");
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "close";
        a(fVar);
    }

    public boolean hW(int i) {
        return x(i, false);
    }

    public boolean x(int i, boolean z) {
        if (this.cKb == null || this.cKf == null) {
            return false;
        }
        this.mStatusBarColor = i;
        this.cKb.setBackgroundColor(i);
        com.baidu.swan.apps.runtime.config.c aoq = aoq();
        if (aoq != null) {
            aoq.dum = i;
            aoq.gD(z);
        }
        if (immersionEnabled()) {
            applyImmersion();
        }
        if (aok()) {
            this.cKf.setVisibility(0);
        } else {
            this.cKf.setVisibility(8);
        }
        return true;
    }

    public boolean a(FrameLayout frameLayout, int i) {
        if (frameLayout == null) {
            return false;
        }
        frameLayout.setBackgroundColor(i);
        com.baidu.swan.apps.runtime.config.c aoq = aoq();
        if (aoq != null) {
            aoq.backgroundColor = i;
        }
        return true;
    }

    public SwanAppActionBar aoj() {
        return this.cKb;
    }

    public boolean aok() {
        return this.mStatusBarColor == -1;
    }

    public void setRightExitViewVisibility(boolean z) {
        this.cKb.setRightExitViewVisibility(z);
    }

    public void setRightZoneVisibility(boolean z) {
        this.cKb.setRightZoneVisibility(z);
    }

    public void eI(boolean z) {
        this.cKl = z;
    }

    public void eJ(boolean z) {
        FloatButton aIL = com.baidu.swan.apps.scheme.actions.d.a.aIJ().aIL();
        if (!z) {
            if (aIL != null && aIL.getVisibility() == 0) {
                aIL.setVisibility(8);
            }
        } else if (aIL != null && aIL.getVisibility() != 0) {
            aIL.setVisibility(0);
        }
    }

    public void eK(boolean z) {
        c hZ;
        f afM = com.baidu.swan.apps.v.f.azO().afM();
        if (afM != null) {
            if (z) {
                hZ = afM.apb();
            } else {
                hZ = afM.hZ(afM.ape() - 1);
            }
            if (hZ != null) {
                eJ(hZ.ajc());
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
        aol();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (immersionEnabled() && this.cKh != null && configuration.orientation == 1) {
            bcH().getWindow().clearFlags(1024);
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

    public void aol() {
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.core.d.c.9
            @Override // java.lang.Runnable
            public void run() {
                c.this.eL(com.baidu.swan.apps.ad.a.a.aEU());
            }
        }, "updateCtsView", 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eL(final boolean z) {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.d.c.10
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.mActivity != null && c.this.cKb != null) {
                    if (z) {
                        if (c.this.cKg == null) {
                            c.this.cKg = new TextView(c.this.mActivity);
                        }
                        if (!(c.this.cKg.getParent() instanceof SwanAppActionBar)) {
                            c.this.cKg.setText(a.h.aiapps_debug_open_cts);
                            c.this.cKg.setTextColor(c.this.aou().getColor(17170455));
                            c.this.cKb.addView(c.this.cKg);
                        }
                    } else if (c.this.cKg != null) {
                        c.this.cKb.removeView(c.this.cKg);
                        c.this.cKg = null;
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
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.cKb, "alpha", 0.0f, 1.0f);
        ofFloat.setDuration(i);
        ofFloat.setInterpolator(accelerateDecelerateInterpolator);
        ofFloat.start();
        if (this.cKh != null && this.cKh.aNB() != null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.cKh.aNB(), "alpha", 0.0f, 1.0f);
            ofFloat2.setDuration(i);
            ofFloat2.setInterpolator(accelerateDecelerateInterpolator);
            ofFloat2.start();
        }
    }

    @Nullable
    public boolean mU(String str) {
        return P(str, false);
    }

    public boolean P(String str, boolean z) {
        if (this.cKb == null) {
            return false;
        }
        this.cKb.setTitle(str);
        com.baidu.swan.apps.runtime.config.c aoq = aoq();
        if (aoq != null) {
            aoq.dun = str;
            aoq.gD(z);
        }
        com.baidu.swan.apps.console.c.i("SwanAppBaseFragment", "page title: " + str);
        return true;
    }

    protected void aom() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aon() {
        if (this.mActivity != null) {
            this.mActivity.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eM(boolean z) {
        this.cKb.setLeftBackViewVisibility(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aoo() {
        this.cKb.setLeftHomeViewVisibility(0);
        this.cKb.setLeftHomeViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.c.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.aom();
            }
        });
    }

    public boolean isSlidable(MotionEvent motionEvent) {
        return true;
    }

    public final f afM() {
        if (this.mActivity == null) {
            return null;
        }
        return ((SwanAppActivity) this.mActivity).afM();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean aop() {
        f afM = afM();
        if (afM == null) {
            return false;
        }
        return afM.ape() > 1;
    }

    public void finishAfterSlide() {
        f afM = afM();
        if (afM == null || afM.ape() == 1) {
            if (this.mActivity != null) {
                this.mActivity.moveTaskToBack(true);
                ap.aNk().lr(1);
                return;
            }
            return;
        }
        afM.nb("navigateBack").al(0, 0).apj().commit();
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
        f afM = afM();
        if (afM != null && afM.ape() >= 2) {
            c hZ = afM.hZ(afM.ape() - 2);
            a(f, hZ);
            if (z) {
                afM.apf().h(hZ);
            } else {
                afM.apf().i(hZ);
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

    public boolean hX(int i) {
        return f(i, "", false);
    }

    public boolean Q(String str, boolean z) {
        return f(SwanAppConfigData.fv(str), str, z);
    }

    protected boolean f(@ColorInt int i, String str, boolean z) {
        if (this.cKb == null) {
            return false;
        }
        setRightExitViewVisibility(this.cKl ? false : true);
        com.baidu.swan.apps.runtime.config.c aoq = aoq();
        if (aoq != null) {
            if (!TextUtils.isEmpty(str)) {
                aoq.duo = str;
            }
            aoq.gD(z);
        }
        int i2 = i == -16777216 ? -16777216 : -1;
        if (immersionEnabled() && i2 != this.cKi) {
            this.cKi = i2;
            applyImmersion();
        }
        return this.cKb.E(i, this.cKl);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean immersionEnabled() {
        return this.mImmersionEnabled;
    }

    protected com.baidu.swan.apps.runtime.config.c aoq() {
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
        this.cKh = new com.baidu.swan.apps.view.a.b(this.mActivity, frameLayout);
        applyImmersion();
        return frameLayout;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void applyImmersion() {
        if (this.cKh != null) {
            applyImmersion(this.mStatusBarColor);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void applyImmersion(@ColorInt int i) {
        if (this.cKh != null) {
            y(i, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void y(@ColorInt int i, boolean z) {
        boolean z2 = true;
        if (this.cKh != null) {
            this.mStatusBarColor = i;
            if (this.cKi == 1) {
                z2 = com.baidu.swan.apps.ap.h.ln(i);
            } else if (this.cKi != -16777216) {
                z2 = false;
            }
            this.cKh.d(i, z, z2);
        }
    }

    public void resetWithCurImmersion() {
        if (immersionEnabled() && this.cKh != null) {
            this.cKh.resetWithCurImmersion();
        }
    }

    @Nullable
    public com.baidu.swan.apps.view.a.b aor() {
        return this.cKh;
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
        aos();
        aot();
        return wrapSlideView;
    }

    private void aos() {
        if (aoq() != null && aoq().duv) {
            com.baidu.swan.apps.runtime.e aHv = com.baidu.swan.apps.runtime.e.aHv();
            if (aHv != null) {
                aHv.aHG().b(aHv.aHo(), "scope_disable_swipe_back", new com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.setting.oauth.h<b.d>>() { // from class: com.baidu.swan.apps.core.d.c.2
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
        return (aou().getConfiguration().orientation == 2 || Build.VERSION.SDK_INT == 26) ? false : true;
    }

    private void aot() {
        this.mSlideHelper.setSlideListener(new SlidingPaneLayout.PanelSlideListener() { // from class: com.baidu.swan.apps.core.d.c.3
            @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
            public void onPanelSlide(View view, float f) {
                View maskView = c.this.mSlideHelper.getMaskView();
                if (maskView != null) {
                    maskView.setAlpha(1.0f - f);
                }
                c.this.onPanelSlide(f);
                if (c.this.cKk != null) {
                    c.this.cKk.ajH();
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

    public final Resources aou() {
        return isAdded() ? getResources() : AppRuntime.getAppContext().getResources();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean aov() {
        if ((this.mActivity instanceof SwanAppActivity) && ((SwanAppActivity) this.mActivity).afE() == 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int afE() {
        if (this.mActivity instanceof SwanAppActivity) {
            return ((SwanAppActivity) this.mActivity).afE();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void abandonAudioFocus() {
        if (this.mAudioManager != null && this.bqE != null) {
            this.mAudioManager.abandonAudioFocus(this.bqE);
        }
    }

    public boolean aow() {
        if (this.cKb == null) {
            return false;
        }
        this.cKb.gZ(true);
        return true;
    }

    public boolean aox() {
        if (this.cKb == null) {
            return false;
        }
        this.cKb.gZ(false);
        return true;
    }

    public void eN(boolean z) {
        if (this.cKb != null) {
            this.cKb.setActionBarCustom(z);
        }
        if (this.cKf != null) {
            int i = 8;
            if (!z && aok()) {
                i = 0;
            }
            this.cKf.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int aoy() {
        if (TextUtils.isEmpty(com.baidu.swan.apps.runtime.e.aHw())) {
            return 0;
        }
        if (com.baidu.swan.apps.database.favorite.a.nO(com.baidu.swan.apps.runtime.e.aHw())) {
            return 2;
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aoz() {
        return "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u".equals(com.baidu.swan.apps.runtime.e.aHw());
    }

    public void aoA() {
        com.baidu.swan.apps.scheme.actions.k.a.U("backtohome", UgcConstant.MENU, com.baidu.swan.apps.v.f.azO().azx());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "gohome";
        fVar.mSource = UgcConstant.MENU;
        a(fVar);
    }

    public void anT() {
    }

    public com.baidu.swan.apps.model.c aoB() {
        return this.cJZ;
    }

    /* loaded from: classes10.dex */
    private class a {
        private int cKq = 0;
        private long cKr = 0;
        private Runnable cKs;

        a(Runnable runnable) {
            this.cKs = runnable;
        }

        void onClick() {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.cKr > 1333) {
                this.cKr = currentTimeMillis;
                this.cKq = 1;
                return;
            }
            this.cKq++;
            if (this.cKq == 3) {
                if (this.cKs != null) {
                    this.cKs.run();
                }
                this.cKq = 0;
                this.cKr = 0L;
                return;
            }
            this.cKr = currentTimeMillis;
        }
    }

    public void a(b bVar) {
        this.cKk = bVar;
    }

    public View aoC() {
        return this.cKa;
    }
}
