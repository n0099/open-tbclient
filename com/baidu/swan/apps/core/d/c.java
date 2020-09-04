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
/* loaded from: classes8.dex */
public abstract class c extends Fragment implements SlideInterceptor {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private AudioManager.OnAudioFocusChangeListener bgT;
    private a chA;
    private b chB;
    protected com.baidu.swan.apps.model.c chq;
    protected View chr;
    protected SwanAppActionBar chs;
    protected com.baidu.swan.menu.h cht;
    protected SwanAppMenuHeaderView chu;
    protected String chv;
    protected View chw;
    protected TextView chx;
    @Nullable
    protected com.baidu.swan.apps.view.a.b chy;
    protected Activity mActivity;
    private AudioManager mAudioManager;
    protected SlideHelper mSlideHelper;
    private boolean mImmersionEnabled = com.baidu.swan.apps.view.a.b.SUPPORT_IMMERSION;
    private int chz = 1;
    private int mStatusBarColor = 1;
    private boolean chC = false;

    /* loaded from: classes8.dex */
    public interface b {
        void abS();
    }

    public abstract boolean aaM();

    protected abstract boolean abn();

    protected abstract void abt();

    protected abstract void aga();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean agb();

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onAttach(Context context) {
        if (DEBUG) {
            Log.d("SwanAppBaseFragment", "onAttach");
        }
        super.onAttach(context);
        this.mActivity = aUT();
        dU(true);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDetach() {
        if (DEBUG) {
            Log.d("SwanAppBaseFragment", "onDetach");
        }
        this.mActivity = null;
        dU(false);
        super.onDetach();
        try {
            Field declaredField = Fragment.class.getDeclaredField("dHF");
            declaredField.setAccessible(true);
            declaredField.set(this, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ai(View view) {
        com.baidu.swan.apps.runtime.config.c nX;
        al(view);
        SwanAppConfigData arD = com.baidu.swan.apps.v.f.arY().arD();
        if (arD == null) {
            if (DEBUG) {
                Log.d("SwanAppBaseFragment", "config data is null. " + Log.getStackTraceString(new Exception()));
                return;
            }
            return;
        }
        if (this.chq == null) {
            nX = arD.cQY;
        } else {
            nX = com.baidu.swan.apps.v.f.arY().nX(com.baidu.swan.apps.scheme.actions.k.j.c(this.chq.getPage(), arD));
        }
        gV(nX.cRH);
        this.chs.setTitle(nX.cRI);
        this.chA = new a(new Runnable() { // from class: com.baidu.swan.apps.core.d.c.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.y.f.aux();
            }
        });
        if (!(this instanceof SwanAppAdLandingFragment)) {
            gW(SwanAppConfigData.fo(nX.cRJ));
        }
        this.chv = nX.cRJ;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void al(View view) {
        if (view != null) {
            this.chs = (SwanAppActionBar) view.findViewById(a.f.ai_apps_title_bar);
            this.chr = view.findViewById(a.f.ai_apps_title_bar_root);
            this.chw = view.findViewById(a.f.title_shadow);
            this.chs.setLeftBackViewMinWidth(ah.dip2px(this.mActivity, 38.0f));
            this.chs.setLeftBackViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (com.baidu.swan.apps.p.a.anu().anv()) {
                        com.baidu.swan.apps.p.a.anu().a(c.this.mActivity, new com.baidu.swan.apps.core.f.b<Boolean>() { // from class: com.baidu.swan.apps.core.d.c.4.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.swan.apps.core.f.b
                            /* renamed from: d */
                            public void K(Boolean bool) {
                                if (bool.booleanValue()) {
                                    c.this.agy();
                                }
                            }
                        });
                    } else {
                        c.this.agy();
                    }
                }
            });
            this.chs.setRightMenuOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    c.this.aga();
                    com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                    fVar.mValue = "menu";
                    if (com.baidu.swan.apps.runtime.e.azJ() != null && com.baidu.swan.apps.runtime.e.azJ().aAa().b("key_unread_counts_message", (Integer) 0).intValue() > 0) {
                        fVar.mPage = String.valueOf(1);
                    }
                    c.this.a(fVar);
                    if (c.this.chA != null) {
                        c.this.chA.onClick();
                    }
                }
            });
            this.chs.setRightExitOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.c.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (c.this.mActivity != null && (c.this.mActivity instanceof SwanAppActivity)) {
                        if (com.baidu.swan.apps.runtime.e.azI() == null || com.baidu.swan.apps.runtime.e.azK() == null) {
                            c.this.ags();
                        } else if (com.baidu.swan.apps.p.a.anu().anv()) {
                            com.baidu.swan.apps.p.a.anu().a(c.this.mActivity, new com.baidu.swan.apps.core.f.b<Boolean>() { // from class: com.baidu.swan.apps.core.d.c.6.1
                                /* JADX DEBUG: Method merged with bridge method */
                                @Override // com.baidu.swan.apps.core.f.b
                                /* renamed from: d */
                                public void K(Boolean bool) {
                                    if (bool.booleanValue()) {
                                        c.this.ags();
                                    }
                                }
                            });
                        } else if (com.baidu.swan.apps.p.c.anB().anC()) {
                            c.this.ags();
                        } else {
                            com.baidu.swan.apps.p.b anw = new com.baidu.swan.apps.p.b().anw();
                            if (!anw.isShow()) {
                                c.this.ags();
                                return;
                            }
                            com.baidu.swan.apps.p.c.anB().a(c.this.mActivity, anw.getImageUrl(), anw.anA(), c.this.agr());
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c.a agr() {
        return new c.a() { // from class: com.baidu.swan.apps.core.d.c.7
            @Override // com.baidu.swan.apps.p.c.a
            public void agO() {
                c.this.ags();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ags() {
        if (this.mActivity != null) {
            com.baidu.swan.apps.v.g.ash().setForeground(false);
            this.mActivity.moveTaskToBack(true);
            agt();
            ((SwanAppActivity) this.mActivity).gn(1);
            ap.aFx().ko(2);
        }
    }

    private void agt() {
        HashMap hashMap = new HashMap();
        hashMap.put("lcType", "onClose");
        hashMap.put("appId", com.baidu.swan.apps.runtime.e.azK());
        com.baidu.swan.apps.v.f.arY().b(new com.baidu.swan.apps.event.a.c(hashMap));
        com.baidu.swan.apps.console.c.i("SwanAppBaseFragment", "onClose");
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "close";
        a(fVar);
    }

    public boolean gV(int i) {
        return v(i, false);
    }

    public boolean v(int i, boolean z) {
        if (this.chs == null || this.chw == null) {
            return false;
        }
        this.mStatusBarColor = i;
        this.chs.setBackgroundColor(i);
        com.baidu.swan.apps.runtime.config.c agB = agB();
        if (agB != null) {
            agB.cRH = i;
            agB.fN(z);
        }
        if (immersionEnabled()) {
            applyImmersion();
        }
        if (agv()) {
            this.chw.setVisibility(0);
        } else {
            this.chw.setVisibility(8);
        }
        return true;
    }

    public boolean a(FrameLayout frameLayout, int i) {
        if (frameLayout == null) {
            return false;
        }
        frameLayout.setBackgroundColor(i);
        com.baidu.swan.apps.runtime.config.c agB = agB();
        if (agB != null) {
            agB.backgroundColor = i;
        }
        return true;
    }

    public SwanAppActionBar agu() {
        return this.chs;
    }

    public boolean agv() {
        return this.mStatusBarColor == -1;
    }

    public void setRightExitViewVisibility(boolean z) {
        this.chs.setRightExitViewVisibility(z);
    }

    public void setRightZoneVisibility(boolean z) {
        this.chs.setRightZoneVisibility(z);
    }

    public void dS(boolean z) {
        this.chC = z;
    }

    public void dT(boolean z) {
        FloatButton aAZ = com.baidu.swan.apps.scheme.actions.d.a.aAX().aAZ();
        if (!z) {
            if (aAZ != null && aAZ.getVisibility() == 0) {
                aAZ.setVisibility(8);
            }
        } else if (aAZ != null && aAZ.getVisibility() != 0) {
            aAZ.setVisibility(0);
        }
    }

    public void dU(boolean z) {
        c gY;
        f XX = com.baidu.swan.apps.v.f.arY().XX();
        if (XX != null) {
            if (z) {
                gY = XX.ahm();
            } else {
                gY = XX.gY(XX.ahp() - 1);
            }
            if (gY != null) {
                dT(gY.abn());
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
        agw();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (immersionEnabled() && this.chy != null && configuration.orientation == 1) {
            aUT().getWindow().clearFlags(1024);
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

    public void agw() {
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.core.d.c.9
            @Override // java.lang.Runnable
            public void run() {
                c.this.dV(com.baidu.swan.apps.ad.a.a.axg());
            }
        }, "updateCtsView", 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dV(final boolean z) {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.d.c.10
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.mActivity != null && c.this.chs != null) {
                    if (z) {
                        if (c.this.chx == null) {
                            c.this.chx = new TextView(c.this.mActivity);
                        }
                        if (!(c.this.chx.getParent() instanceof SwanAppActionBar)) {
                            c.this.chx.setText(a.h.aiapps_debug_open_cts);
                            c.this.chx.setTextColor(c.this.agF().getColor(17170455));
                            c.this.chs.addView(c.this.chx);
                        }
                    } else if (c.this.chx != null) {
                        c.this.chs.removeView(c.this.chx);
                        c.this.chx = null;
                    }
                }
            }
        });
    }

    public void Q(int i, String str) {
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
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.chs, "alpha", 0.0f, 1.0f);
        ofFloat.setDuration(i);
        ofFloat.setInterpolator(accelerateDecelerateInterpolator);
        ofFloat.start();
        if (this.chy != null && this.chy.aFO() != null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.chy.aFO(), "alpha", 0.0f, 1.0f);
            ofFloat2.setDuration(i);
            ofFloat2.setInterpolator(accelerateDecelerateInterpolator);
            ofFloat2.start();
        }
    }

    @Nullable
    public boolean lh(String str) {
        return J(str, false);
    }

    public boolean J(String str, boolean z) {
        if (this.chs == null) {
            return false;
        }
        this.chs.setTitle(str);
        com.baidu.swan.apps.runtime.config.c agB = agB();
        if (agB != null) {
            agB.cRI = str;
            agB.fN(z);
        }
        com.baidu.swan.apps.console.c.i("SwanAppBaseFragment", "page title: " + str);
        return true;
    }

    protected void agx() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void agy() {
        if (this.mActivity != null) {
            this.mActivity.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dW(boolean z) {
        this.chs.setLeftBackViewVisibility(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void agz() {
        this.chs.setLeftHomeViewVisibility(0);
        this.chs.setLeftHomeViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.c.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.agx();
            }
        });
    }

    public boolean isSlidable(MotionEvent motionEvent) {
        return true;
    }

    public final f XX() {
        if (this.mActivity == null) {
            return null;
        }
        return ((SwanAppActivity) this.mActivity).XX();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean agA() {
        f XX = XX();
        if (XX == null) {
            return false;
        }
        return XX.ahp() > 1;
    }

    public void finishAfterSlide() {
        f XX = XX();
        if (XX == null || XX.ahp() == 1) {
            if (this.mActivity != null) {
                this.mActivity.moveTaskToBack(true);
                ap.aFx().ko(1);
                return;
            }
            return;
        }
        XX.lo("navigateBack").al(0, 0).aht().commit();
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
        f XX = XX();
        if (XX != null && XX.ahp() >= 2) {
            c gY = XX.gY(XX.ahp() - 2);
            a(f, gY);
            if (z) {
                XX.ahq().h(gY);
            } else {
                XX.ahq().i(gY);
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

    public boolean gW(int i) {
        return d(i, "", false);
    }

    public boolean K(String str, boolean z) {
        return d(SwanAppConfigData.fo(str), str, z);
    }

    protected boolean d(@ColorInt int i, String str, boolean z) {
        if (this.chs == null) {
            return false;
        }
        setRightExitViewVisibility(this.chC ? false : true);
        com.baidu.swan.apps.runtime.config.c agB = agB();
        if (agB != null) {
            if (!TextUtils.isEmpty(str)) {
                agB.cRJ = str;
            }
            agB.fN(z);
        }
        int i2 = i == -16777216 ? -16777216 : -1;
        if (immersionEnabled() && i2 != this.chz) {
            this.chz = i2;
            applyImmersion();
        }
        return this.chs.C(i, this.chC);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean immersionEnabled() {
        return this.mImmersionEnabled;
    }

    protected com.baidu.swan.apps.runtime.config.c agB() {
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
        this.chy = new com.baidu.swan.apps.view.a.b(this.mActivity, frameLayout);
        applyImmersion();
        return frameLayout;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void applyImmersion() {
        if (this.chy != null) {
            applyImmersion(this.mStatusBarColor);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void applyImmersion(@ColorInt int i) {
        if (this.chy != null) {
            w(i, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void w(@ColorInt int i, boolean z) {
        boolean z2 = true;
        if (this.chy != null) {
            this.mStatusBarColor = i;
            if (this.chz == 1) {
                z2 = com.baidu.swan.apps.ap.h.kk(i);
            } else if (this.chz != -16777216) {
                z2 = false;
            }
            this.chy.d(i, z, z2);
        }
    }

    public void resetWithCurImmersion() {
        if (immersionEnabled() && this.chy != null) {
            this.chy.resetWithCurImmersion();
        }
    }

    @Nullable
    public com.baidu.swan.apps.view.a.b agC() {
        return this.chy;
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
        agD();
        agE();
        return wrapSlideView;
    }

    private void agD() {
        if (agB() != null && agB().cRQ) {
            com.baidu.swan.apps.runtime.e azJ = com.baidu.swan.apps.runtime.e.azJ();
            if (azJ != null) {
                azJ.azU().b(azJ.azC(), "scope_disable_swipe_back", new com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.setting.oauth.h<b.d>>() { // from class: com.baidu.swan.apps.core.d.c.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.ap.e.b
                    /* renamed from: a */
                    public void I(com.baidu.swan.apps.setting.oauth.h<b.d> hVar) {
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
        return (agF().getConfiguration().orientation == 2 || Build.VERSION.SDK_INT == 26) ? false : true;
    }

    private void agE() {
        this.mSlideHelper.setSlideListener(new SlidingPaneLayout.PanelSlideListener() { // from class: com.baidu.swan.apps.core.d.c.3
            @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
            public void onPanelSlide(View view, float f) {
                View maskView = c.this.mSlideHelper.getMaskView();
                if (maskView != null) {
                    maskView.setAlpha(1.0f - f);
                }
                c.this.onPanelSlide(f);
                if (c.this.chB != null) {
                    c.this.chB.abS();
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

    public final Resources agF() {
        return isAdded() ? getResources() : AppRuntime.getAppContext().getResources();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean agG() {
        if ((this.mActivity instanceof SwanAppActivity) && ((SwanAppActivity) this.mActivity).XP() == 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int XP() {
        if (this.mActivity instanceof SwanAppActivity) {
            return ((SwanAppActivity) this.mActivity).XP();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void abandonAudioFocus() {
        if (this.mAudioManager != null && this.bgT != null) {
            this.mAudioManager.abandonAudioFocus(this.bgT);
        }
    }

    public boolean agH() {
        if (this.chs == null) {
            return false;
        }
        this.chs.gj(true);
        return true;
    }

    public boolean agI() {
        if (this.chs == null) {
            return false;
        }
        this.chs.gj(false);
        return true;
    }

    public void dX(boolean z) {
        if (this.chs != null) {
            this.chs.setActionBarCustom(z);
        }
        if (this.chw != null) {
            int i = 8;
            if (!z && agv()) {
                i = 0;
            }
            this.chw.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int agJ() {
        if (TextUtils.isEmpty(com.baidu.swan.apps.runtime.e.azK())) {
            return 0;
        }
        if (com.baidu.swan.apps.database.favorite.a.mc(com.baidu.swan.apps.runtime.e.azK())) {
            return 2;
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean agK() {
        return "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u".equals(com.baidu.swan.apps.runtime.e.azK());
    }

    public void agL() {
        com.baidu.swan.apps.scheme.actions.k.a.M("backtohome", "menu", com.baidu.swan.apps.v.f.arY().arH());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "gohome";
        fVar.mSource = "menu";
        a(fVar);
    }

    public void age() {
    }

    public com.baidu.swan.apps.model.c agM() {
        return this.chq;
    }

    /* loaded from: classes8.dex */
    private class a {
        private int chH = 0;
        private long chI = 0;
        private Runnable chJ;

        a(Runnable runnable) {
            this.chJ = runnable;
        }

        void onClick() {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.chI > 1333) {
                this.chI = currentTimeMillis;
                this.chH = 1;
                return;
            }
            this.chH++;
            if (this.chH == 3) {
                if (this.chJ != null) {
                    this.chJ.run();
                }
                this.chH = 0;
                this.chI = 0L;
                return;
            }
            this.chI = currentTimeMillis;
        }
    }

    public void a(b bVar) {
        this.chB = bVar;
    }

    public View agN() {
        return this.chr;
    }
}
