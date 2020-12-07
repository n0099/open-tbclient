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
/* loaded from: classes25.dex */
public abstract class c extends Fragment implements SlideInterceptor {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private AudioManager.OnAudioFocusChangeListener buc;
    protected com.baidu.swan.apps.model.c cPi;
    protected View cPj;
    protected SwanAppActionBar cPk;
    protected com.baidu.swan.menu.h cPl;
    protected SwanAppMenuHeaderView cPm;
    protected String cPn;
    protected View cPo;
    protected TextView cPp;
    @Nullable
    protected com.baidu.swan.apps.view.a.b cPq;
    private a cPs;
    private b cPt;
    protected Activity mActivity;
    private AudioManager mAudioManager;
    protected SlideHelper mSlideHelper;
    private boolean mImmersionEnabled = com.baidu.swan.apps.view.a.b.SUPPORT_IMMERSION;
    private int cPr = 1;
    private int mStatusBarColor = 1;
    private boolean cPu = false;

    /* loaded from: classes25.dex */
    public interface b {
        void amh();
    }

    protected abstract boolean alC();

    protected abstract void alI();

    public abstract boolean alb();

    protected abstract void aqp();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean aqq();

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onAttach(Context context) {
        if (DEBUG) {
            Log.d("SwanAppBaseFragment", "onAttach");
        }
        super.onAttach(context);
        this.mActivity = bff();
        fc(true);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDetach() {
        if (DEBUG) {
            Log.d("SwanAppBaseFragment", "onDetach");
        }
        this.mActivity = null;
        fc(false);
        super.onDetach();
        try {
            Field declaredField = Fragment.class.getDeclaredField("ept");
            declaredField.setAccessible(true);
            declaredField.set(this, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void at(View view) {
        com.baidu.swan.apps.runtime.config.c qm;
        av(view);
        SwanAppConfigData aBU = com.baidu.swan.apps.v.f.aCp().aBU();
        if (aBU == null) {
            if (DEBUG) {
                Log.d("SwanAppBaseFragment", "config data is null. " + Log.getStackTraceString(new Exception()));
                return;
            }
            return;
        }
        if (this.cPi == null) {
            qm = aBU.dyV;
        } else {
            qm = com.baidu.swan.apps.v.f.aCp().qm(com.baidu.swan.apps.scheme.actions.k.j.c(this.cPi.getPage(), aBU));
        }
        iq(qm.dzE);
        this.cPk.setTitle(qm.dzF);
        this.cPs = new a(new Runnable() { // from class: com.baidu.swan.apps.core.d.c.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.y.f.aEM();
            }
        });
        if (!(this instanceof SwanAppAdLandingFragment)) {
            ir(SwanAppConfigData.sI(qm.dzG));
        }
        this.cPn = qm.dzG;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void av(View view) {
        if (view != null) {
            this.cPk = (SwanAppActionBar) view.findViewById(a.f.ai_apps_title_bar);
            this.cPj = view.findViewById(a.f.ai_apps_title_bar_root);
            this.cPo = view.findViewById(a.f.title_shadow);
            this.cPk.setLeftBackViewMinWidth(ah.dip2px(this.mActivity, 38.0f));
            this.cPk.setLeftBackViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (com.baidu.swan.apps.p.a.axL().axM()) {
                        com.baidu.swan.apps.p.a.axL().a(c.this.mActivity, new com.baidu.swan.apps.core.f.b<Boolean>() { // from class: com.baidu.swan.apps.core.d.c.4.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.swan.apps.core.f.b
                            /* renamed from: e */
                            public void O(Boolean bool) {
                                if (bool.booleanValue()) {
                                    c.this.aqN();
                                }
                            }
                        });
                    } else {
                        c.this.aqN();
                    }
                }
            });
            this.cPk.setRightMenuOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    c.this.aqp();
                    com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                    fVar.mValue = UgcConstant.MENU;
                    if (com.baidu.swan.apps.runtime.e.aJV() != null && com.baidu.swan.apps.runtime.e.aJV().aKm().b("key_unread_counts_message", (Integer) 0).intValue() > 0) {
                        fVar.mPage = String.valueOf(1);
                    }
                    c.this.a(fVar);
                    if (c.this.cPs != null) {
                        c.this.cPs.onClick();
                    }
                }
            });
            this.cPk.setRightExitOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.c.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (c.this.mActivity != null && (c.this.mActivity instanceof SwanAppActivity)) {
                        if (com.baidu.swan.apps.runtime.e.aJU() == null || com.baidu.swan.apps.runtime.e.aJW() == null) {
                            c.this.aqH();
                        } else if (com.baidu.swan.apps.p.a.axL().axM()) {
                            com.baidu.swan.apps.p.a.axL().a(c.this.mActivity, new com.baidu.swan.apps.core.f.b<Boolean>() { // from class: com.baidu.swan.apps.core.d.c.6.1
                                /* JADX DEBUG: Method merged with bridge method */
                                @Override // com.baidu.swan.apps.core.f.b
                                /* renamed from: e */
                                public void O(Boolean bool) {
                                    if (bool.booleanValue()) {
                                        c.this.aqH();
                                    }
                                }
                            });
                        } else if (com.baidu.swan.apps.p.c.axS().axT()) {
                            c.this.aqH();
                        } else {
                            com.baidu.swan.apps.p.b axN = new com.baidu.swan.apps.p.b().axN();
                            if (!axN.isShow()) {
                                c.this.aqH();
                                return;
                            }
                            com.baidu.swan.apps.p.c.axS().a(c.this.mActivity, axN.getImageUrl(), axN.axR(), c.this.aqG());
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c.a aqG() {
        return new c.a() { // from class: com.baidu.swan.apps.core.d.c.7
            @Override // com.baidu.swan.apps.p.c.a
            public void ard() {
                c.this.aqH();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqH() {
        if (this.mActivity != null) {
            com.baidu.swan.apps.v.g.aCy().setForeground(false);
            this.mActivity.moveTaskToBack(true);
            aqI();
            ((SwanAppActivity) this.mActivity).hJ(1);
            ap.aPI().lL(2);
        }
    }

    private void aqI() {
        HashMap hashMap = new HashMap();
        hashMap.put("lcType", "onClose");
        hashMap.put("appId", com.baidu.swan.apps.runtime.e.aJW());
        com.baidu.swan.apps.v.f.aCp().b(new com.baidu.swan.apps.event.a.c(hashMap));
        com.baidu.swan.apps.console.c.i("SwanAppBaseFragment", "onClose");
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "close";
        a(fVar);
    }

    public boolean iq(int i) {
        return x(i, false);
    }

    public boolean x(int i, boolean z) {
        if (this.cPk == null || this.cPo == null) {
            return false;
        }
        this.mStatusBarColor = i;
        this.cPk.setBackgroundColor(i);
        com.baidu.swan.apps.runtime.config.c aqQ = aqQ();
        if (aqQ != null) {
            aqQ.dzE = i;
            aqQ.gV(z);
        }
        if (immersionEnabled()) {
            applyImmersion();
        }
        if (aqK()) {
            this.cPo.setVisibility(0);
        } else {
            this.cPo.setVisibility(8);
        }
        return true;
    }

    public boolean a(FrameLayout frameLayout, int i) {
        if (frameLayout == null) {
            return false;
        }
        frameLayout.setBackgroundColor(i);
        com.baidu.swan.apps.runtime.config.c aqQ = aqQ();
        if (aqQ != null) {
            aqQ.backgroundColor = i;
        }
        return true;
    }

    public SwanAppActionBar aqJ() {
        return this.cPk;
    }

    public boolean aqK() {
        return this.mStatusBarColor == -1;
    }

    public void setRightExitViewVisibility(boolean z) {
        this.cPk.setRightExitViewVisibility(z);
    }

    public void setRightZoneVisibility(boolean z) {
        this.cPk.setRightZoneVisibility(z);
    }

    public void fa(boolean z) {
        this.cPu = z;
    }

    public void fb(boolean z) {
        FloatButton aLl = com.baidu.swan.apps.scheme.actions.d.a.aLj().aLl();
        if (!z) {
            if (aLl != null && aLl.getVisibility() == 0) {
                aLl.setVisibility(8);
            }
        } else if (aLl != null && aLl.getVisibility() != 0) {
            aLl.setVisibility(0);
        }
    }

    public void fc(boolean z) {
        c it;
        f aim = com.baidu.swan.apps.v.f.aCp().aim();
        if (aim != null) {
            if (z) {
                it = aim.arB();
            } else {
                it = aim.it(aim.arE() - 1);
            }
            if (it != null) {
                fb(it.alC());
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
        aqL();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (immersionEnabled() && this.cPq != null && configuration.orientation == 1) {
            bff().getWindow().clearFlags(1024);
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

    public void aqL() {
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.core.d.c.9
            @Override // java.lang.Runnable
            public void run() {
                c.this.fd(com.baidu.swan.apps.ad.a.a.aHu());
            }
        }, "updateCtsView", 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fd(final boolean z) {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.d.c.10
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.mActivity != null && c.this.cPk != null) {
                    if (z) {
                        if (c.this.cPp == null) {
                            c.this.cPp = new TextView(c.this.mActivity);
                        }
                        if (!(c.this.cPp.getParent() instanceof SwanAppActionBar)) {
                            c.this.cPp.setText(a.h.aiapps_debug_open_cts);
                            c.this.cPp.setTextColor(c.this.aqU().getColor(17170455));
                            c.this.cPk.addView(c.this.cPp);
                        }
                    } else if (c.this.cPp != null) {
                        c.this.cPk.removeView(c.this.cPp);
                        c.this.cPp = null;
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
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.cPk, "alpha", 0.0f, 1.0f);
        ofFloat.setDuration(i);
        ofFloat.setInterpolator(accelerateDecelerateInterpolator);
        ofFloat.start();
        if (this.cPq != null && this.cPq.aPZ() != null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.cPq.aPZ(), "alpha", 0.0f, 1.0f);
            ofFloat2.setDuration(i);
            ofFloat2.setInterpolator(accelerateDecelerateInterpolator);
            ofFloat2.start();
        }
    }

    @Nullable
    public boolean nv(String str) {
        return Q(str, false);
    }

    public boolean Q(String str, boolean z) {
        if (this.cPk == null) {
            return false;
        }
        this.cPk.setTitle(str);
        com.baidu.swan.apps.runtime.config.c aqQ = aqQ();
        if (aqQ != null) {
            aqQ.dzF = str;
            aqQ.gV(z);
        }
        com.baidu.swan.apps.console.c.i("SwanAppBaseFragment", "page title: " + str);
        return true;
    }

    protected void aqM() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aqN() {
        if (this.mActivity != null) {
            this.mActivity.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void fe(boolean z) {
        this.cPk.setLeftBackViewVisibility(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aqO() {
        this.cPk.setLeftHomeViewVisibility(0);
        this.cPk.setLeftHomeViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.c.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.aqM();
            }
        });
    }

    public boolean isSlidable(MotionEvent motionEvent) {
        return true;
    }

    public final f aim() {
        if (this.mActivity == null) {
            return null;
        }
        return ((SwanAppActivity) this.mActivity).aim();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean aqP() {
        f aim = aim();
        if (aim == null) {
            return false;
        }
        return aim.arE() > 1;
    }

    public void finishAfterSlide() {
        f aim = aim();
        if (aim == null || aim.arE() == 1) {
            if (this.mActivity != null) {
                this.mActivity.moveTaskToBack(true);
                ap.aPI().lL(1);
                return;
            }
            return;
        }
        aim.nC("navigateBack").an(0, 0).arI().commit();
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
        f aim = aim();
        if (aim != null && aim.arE() >= 2) {
            c it = aim.it(aim.arE() - 2);
            a(f, it);
            if (z) {
                aim.arF().h(it);
            } else {
                aim.arF().i(it);
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

    public boolean ir(int i) {
        return f(i, "", false);
    }

    public boolean R(String str, boolean z) {
        return f(SwanAppConfigData.sI(str), str, z);
    }

    protected boolean f(@ColorInt int i, String str, boolean z) {
        if (this.cPk == null) {
            return false;
        }
        setRightExitViewVisibility(this.cPu ? false : true);
        com.baidu.swan.apps.runtime.config.c aqQ = aqQ();
        if (aqQ != null) {
            if (!TextUtils.isEmpty(str)) {
                aqQ.dzG = str;
            }
            aqQ.gV(z);
        }
        int i2 = i == -16777216 ? -16777216 : -1;
        if (immersionEnabled() && i2 != this.cPr) {
            this.cPr = i2;
            applyImmersion();
        }
        return this.cPk.E(i, this.cPu);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean immersionEnabled() {
        return this.mImmersionEnabled;
    }

    protected com.baidu.swan.apps.runtime.config.c aqQ() {
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
        this.cPq = new com.baidu.swan.apps.view.a.b(this.mActivity, frameLayout);
        applyImmersion();
        return frameLayout;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void applyImmersion() {
        if (this.cPq != null) {
            applyImmersion(this.mStatusBarColor);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void applyImmersion(@ColorInt int i) {
        if (this.cPq != null) {
            y(i, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void y(@ColorInt int i, boolean z) {
        boolean z2 = true;
        if (this.cPq != null) {
            this.mStatusBarColor = i;
            if (this.cPr == 1) {
                z2 = com.baidu.swan.apps.ap.h.lH(i);
            } else if (this.cPr != -16777216) {
                z2 = false;
            }
            this.cPq.d(i, z, z2);
        }
    }

    public void resetWithCurImmersion() {
        if (immersionEnabled() && this.cPq != null) {
            this.cPq.resetWithCurImmersion();
        }
    }

    @Nullable
    public com.baidu.swan.apps.view.a.b aqR() {
        return this.cPq;
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
        aqS();
        aqT();
        return wrapSlideView;
    }

    private void aqS() {
        if (aqQ() != null && aqQ().dzN) {
            com.baidu.swan.apps.runtime.e aJV = com.baidu.swan.apps.runtime.e.aJV();
            if (aJV != null) {
                aJV.aKg().b(aJV.aJO(), "scope_disable_swipe_back", new com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.setting.oauth.h<b.d>>() { // from class: com.baidu.swan.apps.core.d.c.2
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
        return (aqU().getConfiguration().orientation == 2 || Build.VERSION.SDK_INT == 26) ? false : true;
    }

    private void aqT() {
        this.mSlideHelper.setSlideListener(new SlidingPaneLayout.PanelSlideListener() { // from class: com.baidu.swan.apps.core.d.c.3
            @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
            public void onPanelSlide(View view, float f) {
                View maskView = c.this.mSlideHelper.getMaskView();
                if (maskView != null) {
                    maskView.setAlpha(1.0f - f);
                }
                c.this.onPanelSlide(f);
                if (c.this.cPt != null) {
                    c.this.cPt.amh();
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

    public final Resources aqU() {
        return isAdded() ? getResources() : AppRuntime.getAppContext().getResources();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean aqV() {
        if ((this.mActivity instanceof SwanAppActivity) && ((SwanAppActivity) this.mActivity).aie() == 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int aie() {
        if (this.mActivity instanceof SwanAppActivity) {
            return ((SwanAppActivity) this.mActivity).aie();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void abandonAudioFocus() {
        if (this.mAudioManager != null && this.buc != null) {
            this.mAudioManager.abandonAudioFocus(this.buc);
        }
    }

    public boolean aqW() {
        if (this.cPk == null) {
            return false;
        }
        this.cPk.hr(true);
        return true;
    }

    public boolean aqX() {
        if (this.cPk == null) {
            return false;
        }
        this.cPk.hr(false);
        return true;
    }

    public void ff(boolean z) {
        if (this.cPk != null) {
            this.cPk.setActionBarCustom(z);
        }
        if (this.cPo != null) {
            int i = 8;
            if (!z && aqK()) {
                i = 0;
            }
            this.cPo.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int aqY() {
        if (TextUtils.isEmpty(com.baidu.swan.apps.runtime.e.aJW())) {
            return 0;
        }
        if (com.baidu.swan.apps.database.favorite.a.or(com.baidu.swan.apps.runtime.e.aJW())) {
            return 2;
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aqZ() {
        return "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u".equals(com.baidu.swan.apps.runtime.e.aJW());
    }

    public void ara() {
        com.baidu.swan.apps.scheme.actions.k.a.X("backtohome", UgcConstant.MENU, com.baidu.swan.apps.v.f.aCp().aBY());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "gohome";
        fVar.mSource = UgcConstant.MENU;
        a(fVar);
    }

    public void aqt() {
    }

    public com.baidu.swan.apps.model.c arb() {
        return this.cPi;
    }

    /* loaded from: classes25.dex */
    private class a {
        private Runnable cPB;
        private int cPz = 0;
        private long cPA = 0;

        a(Runnable runnable) {
            this.cPB = runnable;
        }

        void onClick() {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.cPA > 1333) {
                this.cPA = currentTimeMillis;
                this.cPz = 1;
                return;
            }
            this.cPz++;
            if (this.cPz == 3) {
                if (this.cPB != null) {
                    this.cPB.run();
                }
                this.cPz = 0;
                this.cPA = 0L;
                return;
            }
            this.cPA = currentTimeMillis;
        }
    }

    public void a(b bVar) {
        this.cPt = bVar;
    }

    public View arc() {
        return this.cPj;
    }
}
