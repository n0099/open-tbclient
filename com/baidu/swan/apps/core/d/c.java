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
    private AudioManager.OnAudioFocusChangeListener bgQ;
    protected com.baidu.swan.apps.model.c chm;
    protected View chn;
    protected SwanAppActionBar cho;
    protected com.baidu.swan.menu.h chp;
    protected SwanAppMenuHeaderView chq;
    protected String chr;
    protected View chs;
    protected TextView cht;
    @Nullable
    protected com.baidu.swan.apps.view.a.b chu;
    private a chw;
    private b chx;
    protected Activity mActivity;
    private AudioManager mAudioManager;
    protected SlideHelper mSlideHelper;
    private boolean mImmersionEnabled = com.baidu.swan.apps.view.a.b.SUPPORT_IMMERSION;
    private int chv = 1;
    private int mStatusBarColor = 1;
    private boolean chy = false;

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
        dT(true);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDetach() {
        if (DEBUG) {
            Log.d("SwanAppBaseFragment", "onDetach");
        }
        this.mActivity = null;
        dT(false);
        super.onDetach();
        try {
            Field declaredField = Fragment.class.getDeclaredField("dHB");
            declaredField.setAccessible(true);
            declaredField.set(this, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ai(View view) {
        com.baidu.swan.apps.runtime.config.c nW;
        al(view);
        SwanAppConfigData arD = com.baidu.swan.apps.v.f.arY().arD();
        if (arD == null) {
            if (DEBUG) {
                Log.d("SwanAppBaseFragment", "config data is null. " + Log.getStackTraceString(new Exception()));
                return;
            }
            return;
        }
        if (this.chm == null) {
            nW = arD.cQU;
        } else {
            nW = com.baidu.swan.apps.v.f.arY().nW(com.baidu.swan.apps.scheme.actions.k.j.c(this.chm.getPage(), arD));
        }
        gV(nW.cRD);
        this.cho.setTitle(nW.cRE);
        this.chw = new a(new Runnable() { // from class: com.baidu.swan.apps.core.d.c.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.y.f.aux();
            }
        });
        if (!(this instanceof SwanAppAdLandingFragment)) {
            gW(SwanAppConfigData.fn(nW.cRF));
        }
        this.chr = nW.cRF;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void al(View view) {
        if (view != null) {
            this.cho = (SwanAppActionBar) view.findViewById(a.f.ai_apps_title_bar);
            this.chn = view.findViewById(a.f.ai_apps_title_bar_root);
            this.chs = view.findViewById(a.f.title_shadow);
            this.cho.setLeftBackViewMinWidth(ah.dip2px(this.mActivity, 38.0f));
            this.cho.setLeftBackViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.c.4
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
            this.cho.setRightMenuOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    c.this.aga();
                    com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                    fVar.mValue = "menu";
                    if (com.baidu.swan.apps.runtime.e.azJ() != null && com.baidu.swan.apps.runtime.e.azJ().aAa().b("key_unread_counts_message", (Integer) 0).intValue() > 0) {
                        fVar.mPage = String.valueOf(1);
                    }
                    c.this.a(fVar);
                    if (c.this.chw != null) {
                        c.this.chw.onClick();
                    }
                }
            });
            this.cho.setRightExitOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.c.6
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
        if (this.cho == null || this.chs == null) {
            return false;
        }
        this.mStatusBarColor = i;
        this.cho.setBackgroundColor(i);
        com.baidu.swan.apps.runtime.config.c agB = agB();
        if (agB != null) {
            agB.cRD = i;
            agB.fM(z);
        }
        if (immersionEnabled()) {
            applyImmersion();
        }
        if (agv()) {
            this.chs.setVisibility(0);
        } else {
            this.chs.setVisibility(8);
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
        return this.cho;
    }

    public boolean agv() {
        return this.mStatusBarColor == -1;
    }

    public void setRightExitViewVisibility(boolean z) {
        this.cho.setRightExitViewVisibility(z);
    }

    public void setRightZoneVisibility(boolean z) {
        this.cho.setRightZoneVisibility(z);
    }

    public void dR(boolean z) {
        this.chy = z;
    }

    public void dS(boolean z) {
        FloatButton aAZ = com.baidu.swan.apps.scheme.actions.d.a.aAX().aAZ();
        if (!z) {
            if (aAZ != null && aAZ.getVisibility() == 0) {
                aAZ.setVisibility(8);
            }
        } else if (aAZ != null && aAZ.getVisibility() != 0) {
            aAZ.setVisibility(0);
        }
    }

    public void dT(boolean z) {
        c gY;
        f XX = com.baidu.swan.apps.v.f.arY().XX();
        if (XX != null) {
            if (z) {
                gY = XX.ahm();
            } else {
                gY = XX.gY(XX.ahp() - 1);
            }
            if (gY != null) {
                dS(gY.abn());
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
        if (immersionEnabled() && this.chu != null && configuration.orientation == 1) {
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
                c.this.dU(com.baidu.swan.apps.ad.a.a.axg());
            }
        }, "updateCtsView", 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dU(final boolean z) {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.d.c.10
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.mActivity != null && c.this.cho != null) {
                    if (z) {
                        if (c.this.cht == null) {
                            c.this.cht = new TextView(c.this.mActivity);
                        }
                        if (!(c.this.cht.getParent() instanceof SwanAppActionBar)) {
                            c.this.cht.setText(a.h.aiapps_debug_open_cts);
                            c.this.cht.setTextColor(c.this.agF().getColor(17170455));
                            c.this.cho.addView(c.this.cht);
                        }
                    } else if (c.this.cht != null) {
                        c.this.cho.removeView(c.this.cht);
                        c.this.cht = null;
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
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.cho, "alpha", 0.0f, 1.0f);
        ofFloat.setDuration(i);
        ofFloat.setInterpolator(accelerateDecelerateInterpolator);
        ofFloat.start();
        if (this.chu != null && this.chu.aFO() != null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.chu.aFO(), "alpha", 0.0f, 1.0f);
            ofFloat2.setDuration(i);
            ofFloat2.setInterpolator(accelerateDecelerateInterpolator);
            ofFloat2.start();
        }
    }

    @Nullable
    public boolean lg(String str) {
        return J(str, false);
    }

    public boolean J(String str, boolean z) {
        if (this.cho == null) {
            return false;
        }
        this.cho.setTitle(str);
        com.baidu.swan.apps.runtime.config.c agB = agB();
        if (agB != null) {
            agB.cRE = str;
            agB.fM(z);
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
    public void dV(boolean z) {
        this.cho.setLeftBackViewVisibility(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void agz() {
        this.cho.setLeftHomeViewVisibility(0);
        this.cho.setLeftHomeViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.c.11
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
        XX.ln("navigateBack").al(0, 0).aht().commit();
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
        return d(SwanAppConfigData.fn(str), str, z);
    }

    protected boolean d(@ColorInt int i, String str, boolean z) {
        if (this.cho == null) {
            return false;
        }
        setRightExitViewVisibility(this.chy ? false : true);
        com.baidu.swan.apps.runtime.config.c agB = agB();
        if (agB != null) {
            if (!TextUtils.isEmpty(str)) {
                agB.cRF = str;
            }
            agB.fM(z);
        }
        int i2 = i == -16777216 ? -16777216 : -1;
        if (immersionEnabled() && i2 != this.chv) {
            this.chv = i2;
            applyImmersion();
        }
        return this.cho.C(i, this.chy);
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
        this.chu = new com.baidu.swan.apps.view.a.b(this.mActivity, frameLayout);
        applyImmersion();
        return frameLayout;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void applyImmersion() {
        if (this.chu != null) {
            applyImmersion(this.mStatusBarColor);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void applyImmersion(@ColorInt int i) {
        if (this.chu != null) {
            w(i, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void w(@ColorInt int i, boolean z) {
        boolean z2 = true;
        if (this.chu != null) {
            this.mStatusBarColor = i;
            if (this.chv == 1) {
                z2 = com.baidu.swan.apps.ap.h.kk(i);
            } else if (this.chv != -16777216) {
                z2 = false;
            }
            this.chu.d(i, z, z2);
        }
    }

    public void resetWithCurImmersion() {
        if (immersionEnabled() && this.chu != null) {
            this.chu.resetWithCurImmersion();
        }
    }

    @Nullable
    public com.baidu.swan.apps.view.a.b agC() {
        return this.chu;
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
        if (agB() != null && agB().cRM) {
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
                if (c.this.chx != null) {
                    c.this.chx.abS();
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
        if (this.mAudioManager != null && this.bgQ != null) {
            this.mAudioManager.abandonAudioFocus(this.bgQ);
        }
    }

    public boolean agH() {
        if (this.cho == null) {
            return false;
        }
        this.cho.gi(true);
        return true;
    }

    public boolean agI() {
        if (this.cho == null) {
            return false;
        }
        this.cho.gi(false);
        return true;
    }

    public void dW(boolean z) {
        if (this.cho != null) {
            this.cho.setActionBarCustom(z);
        }
        if (this.chs != null) {
            int i = 8;
            if (!z && agv()) {
                i = 0;
            }
            this.chs.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int agJ() {
        if (TextUtils.isEmpty(com.baidu.swan.apps.runtime.e.azK())) {
            return 0;
        }
        if (com.baidu.swan.apps.database.favorite.a.mb(com.baidu.swan.apps.runtime.e.azK())) {
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
        return this.chm;
    }

    /* loaded from: classes8.dex */
    private class a {
        private int chD = 0;
        private long chE = 0;
        private Runnable chF;

        a(Runnable runnable) {
            this.chF = runnable;
        }

        void onClick() {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.chE > 1333) {
                this.chE = currentTimeMillis;
                this.chD = 1;
                return;
            }
            this.chD++;
            if (this.chD == 3) {
                if (this.chF != null) {
                    this.chF.run();
                }
                this.chD = 0;
                this.chE = 0L;
                return;
            }
            this.chE = currentTimeMillis;
        }
    }

    public void a(b bVar) {
        this.chx = bVar;
    }

    public View agN() {
        return this.chn;
    }
}
