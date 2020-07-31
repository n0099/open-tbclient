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
import com.baidu.swan.apps.aq.ai;
import com.baidu.swan.apps.aq.al;
import com.baidu.swan.apps.aq.aq;
import com.baidu.swan.apps.o.c;
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
    private AudioManager.OnAudioFocusChangeListener bbt;
    private a cbB;
    private b cbC;
    protected com.baidu.swan.apps.model.c cbr;
    protected View cbs;
    protected SwanAppActionBar cbt;
    protected com.baidu.swan.menu.h cbu;
    protected SwanAppMenuHeaderView cbv;
    protected String cbw;
    protected View cbx;
    protected TextView cby;
    @Nullable
    protected com.baidu.swan.apps.view.a.b cbz;
    protected Activity mActivity;
    private AudioManager mAudioManager;
    protected SlideHelper mSlideHelper;
    private boolean mImmersionEnabled = com.baidu.swan.apps.view.a.b.SUPPORT_IMMERSION;
    private int cbA = 1;
    private int mStatusBarColor = 1;
    private boolean cbD = false;

    /* loaded from: classes7.dex */
    public interface b {
        void VM();
    }

    public abstract boolean UJ();

    protected abstract boolean Vi();

    protected abstract void Vn();

    protected abstract void ZQ();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean ZR();

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onAttach(Context context) {
        if (DEBUG) {
            Log.d("SwanAppBaseFragment", "onAttach");
        }
        super.onAttach(context);
        this.mActivity = aMt();
        dJ(true);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDetach() {
        if (DEBUG) {
            Log.d("SwanAppBaseFragment", "onDetach");
        }
        this.mActivity = null;
        dJ(false);
        super.onDetach();
        try {
            Field declaredField = Fragment.class.getDeclaredField("dys");
            declaredField.setAccessible(true);
            declaredField.set(this, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ah(View view) {
        com.baidu.swan.apps.runtime.config.c lZ;
        ak(view);
        SwanAppConfigData ajW = com.baidu.swan.apps.v.f.akr().ajW();
        if (ajW == null) {
            if (DEBUG) {
                Log.d("SwanAppBaseFragment", "config data is null. " + Log.getStackTraceString(new Exception()));
                return;
            }
            return;
        }
        if (this.cbr == null) {
            lZ = ajW.cHV;
        } else {
            lZ = com.baidu.swan.apps.v.f.akr().lZ(com.baidu.swan.apps.scheme.actions.k.j.c(this.cbr.getPage(), ajW));
        }
        eZ(lZ.cIE);
        this.cbt.setTitle(lZ.cIF);
        this.cbB = new a(new Runnable() { // from class: com.baidu.swan.apps.core.d.c.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.z.f.amB();
            }
        });
        if (!(this instanceof SwanAppAdLandingFragment)) {
            fa(SwanAppConfigData.dU(lZ.cIG));
        }
        this.cbw = lZ.cIG;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ak(View view) {
        if (view != null) {
            this.cbt = (SwanAppActionBar) view.findViewById(a.f.ai_apps_title_bar);
            this.cbs = view.findViewById(a.f.ai_apps_title_bar_root);
            this.cbx = view.findViewById(a.f.title_shadow);
            this.cbt.setLeftBackViewMinWidth(ai.dip2px(this.mActivity, 38.0f));
            this.cbt.setLeftBackViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (com.baidu.swan.apps.o.a.agm().agn()) {
                        com.baidu.swan.apps.o.a.agm().a(c.this.mActivity, new com.baidu.swan.apps.core.f.b<Boolean>() { // from class: com.baidu.swan.apps.core.d.c.4.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.swan.apps.core.f.b
                            /* renamed from: d */
                            public void J(Boolean bool) {
                                if (bool.booleanValue()) {
                                    c.this.aao();
                                }
                            }
                        });
                    } else {
                        c.this.aao();
                    }
                }
            });
            this.cbt.setRightMenuOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    c.this.ZQ();
                    com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                    fVar.mValue = "menu";
                    if (com.baidu.swan.apps.runtime.e.arw() != null && com.baidu.swan.apps.runtime.e.arw().arN().b("key_unread_counts_message", (Integer) 0).intValue() > 0) {
                        fVar.mPage = String.valueOf(1);
                    }
                    c.this.a(fVar);
                    if (c.this.cbB != null) {
                        c.this.cbB.onClick();
                    }
                }
            });
            this.cbt.setRightExitOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.c.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (c.this.mActivity != null && (c.this.mActivity instanceof SwanAppActivity)) {
                        if (com.baidu.swan.apps.runtime.e.arv() == null || com.baidu.swan.apps.runtime.e.arx() == null) {
                            c.this.aai();
                        } else if (com.baidu.swan.apps.o.a.agm().agn()) {
                            com.baidu.swan.apps.o.a.agm().a(c.this.mActivity, new com.baidu.swan.apps.core.f.b<Boolean>() { // from class: com.baidu.swan.apps.core.d.c.6.1
                                /* JADX DEBUG: Method merged with bridge method */
                                @Override // com.baidu.swan.apps.core.f.b
                                /* renamed from: d */
                                public void J(Boolean bool) {
                                    if (bool.booleanValue()) {
                                        c.this.aai();
                                    }
                                }
                            });
                        } else if (com.baidu.swan.apps.o.c.agt().agu()) {
                            c.this.aai();
                        } else {
                            com.baidu.swan.apps.o.b ago = new com.baidu.swan.apps.o.b().ago();
                            if (!ago.isShow()) {
                                c.this.aai();
                                return;
                            }
                            com.baidu.swan.apps.o.c.agt().a(c.this.mActivity, ago.getImageUrl(), ago.ags(), c.this.aah());
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c.a aah() {
        return new c.a() { // from class: com.baidu.swan.apps.core.d.c.7
            @Override // com.baidu.swan.apps.o.c.a
            public void aaE() {
                c.this.aai();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aai() {
        if (this.mActivity != null) {
            com.baidu.swan.apps.v.g.akA().eq(false);
            this.mActivity.moveTaskToBack(true);
            aaj();
            ((SwanAppActivity) this.mActivity).eq(1);
            aq.axo().ig(2);
        }
    }

    private void aaj() {
        HashMap hashMap = new HashMap();
        hashMap.put("lcType", "onClose");
        hashMap.put("appId", com.baidu.swan.apps.runtime.e.arx());
        com.baidu.swan.apps.v.f.akr().a(new com.baidu.swan.apps.event.a.c(hashMap));
        com.baidu.swan.apps.console.c.i("SwanAppBaseFragment", "onClose");
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "close";
        a(fVar);
    }

    public boolean eZ(int i) {
        return t(i, false);
    }

    public boolean t(int i, boolean z) {
        if (this.cbt == null || this.cbx == null) {
            return false;
        }
        this.mStatusBarColor = i;
        this.cbt.setBackgroundColor(i);
        com.baidu.swan.apps.runtime.config.c aar = aar();
        if (aar != null) {
            aar.cIE = i;
            aar.ft(z);
        }
        if (immersionEnabled()) {
            applyImmersion();
        }
        if (aal()) {
            this.cbx.setVisibility(0);
        } else {
            this.cbx.setVisibility(8);
        }
        return true;
    }

    public boolean a(FrameLayout frameLayout, int i) {
        if (frameLayout == null) {
            return false;
        }
        frameLayout.setBackgroundColor(i);
        com.baidu.swan.apps.runtime.config.c aar = aar();
        if (aar != null) {
            aar.backgroundColor = i;
        }
        return true;
    }

    public SwanAppActionBar aak() {
        return this.cbt;
    }

    public boolean aal() {
        return this.mStatusBarColor == -1;
    }

    public void setRightExitViewVisibility(boolean z) {
        this.cbt.setRightExitViewVisibility(z);
    }

    public void setRightZoneVisibility(boolean z) {
        this.cbt.setRightZoneVisibility(z);
    }

    public void dH(boolean z) {
        this.cbD = z;
    }

    public void dI(boolean z) {
        FloatButton asQ = com.baidu.swan.apps.scheme.actions.d.a.asO().asQ();
        if (!z) {
            if (asQ != null && asQ.getVisibility() == 0) {
                asQ.setVisibility(8);
            }
        } else if (asQ != null && asQ.getVisibility() != 0) {
            asQ.setVisibility(0);
        }
    }

    public void dJ(boolean z) {
        c fc;
        f Sc = com.baidu.swan.apps.v.f.akr().Sc();
        if (Sc != null) {
            if (z) {
                fc = Sc.aaZ();
            } else {
                fc = Sc.fc(Sc.abc() - 1);
            }
            if (fc != null) {
                dI(fc.Vi());
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
        aam();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (immersionEnabled() && this.cbz != null && configuration.orientation == 1) {
            aMt().getWindow().clearFlags(1024);
            al.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.d.c.8
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

    public void aam() {
        if (!com.baidu.swan.apps.performance.b.b.aon()) {
            dK(com.baidu.swan.apps.ae.a.a.apk());
        } else {
            ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.core.d.c.9
                @Override // java.lang.Runnable
                public void run() {
                    c.this.dK(com.baidu.swan.apps.ae.a.a.apk());
                }
            }, "updateCtsView", 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dK(final boolean z) {
        al.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.d.c.10
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.mActivity != null && c.this.cbt != null) {
                    if (z) {
                        if (c.this.cby == null) {
                            c.this.cby = new TextView(c.this.mActivity);
                        }
                        if (!(c.this.cby.getParent() instanceof SwanAppActionBar)) {
                            c.this.cby.setText(a.h.aiapps_debug_open_cts);
                            c.this.cby.setTextColor(c.this.aav().getColor(17170455));
                            c.this.cbt.addView(c.this.cby);
                        }
                    } else if (c.this.cby != null) {
                        c.this.cbt.removeView(c.this.cby);
                        c.this.cby = null;
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
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.cbt, "alpha", 0.0f, 1.0f);
        ofFloat.setDuration(i);
        ofFloat.setInterpolator(accelerateDecelerateInterpolator);
        ofFloat.start();
        if (this.cbz != null && this.cbz.axG() != null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.cbz.axG(), "alpha", 0.0f, 1.0f);
            ofFloat2.setDuration(i);
            ofFloat2.setInterpolator(accelerateDecelerateInterpolator);
            ofFloat2.start();
        }
    }

    @Nullable
    public boolean jH(String str) {
        return F(str, false);
    }

    public boolean F(String str, boolean z) {
        if (this.cbt == null) {
            return false;
        }
        this.cbt.setTitle(str);
        com.baidu.swan.apps.runtime.config.c aar = aar();
        if (aar != null) {
            aar.cIF = str;
            aar.ft(z);
        }
        com.baidu.swan.apps.console.c.i("SwanAppBaseFragment", "page title: " + str);
        return true;
    }

    protected void aan() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aao() {
        if (this.mActivity != null) {
            this.mActivity.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dL(boolean z) {
        this.cbt.setLeftBackViewVisibility(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aap() {
        this.cbt.setLeftHomeViewVisibility(0);
        this.cbt.setLeftHomeViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.c.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.aan();
            }
        });
    }

    public boolean isSlidable(MotionEvent motionEvent) {
        return true;
    }

    public final f Sc() {
        if (this.mActivity == null) {
            return null;
        }
        return ((SwanAppActivity) this.mActivity).Sc();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean aaq() {
        f Sc = Sc();
        if (Sc == null) {
            return false;
        }
        return Sc.abc() > 1;
    }

    public void finishAfterSlide() {
        f Sc = Sc();
        if (Sc == null || Sc.abc() == 1) {
            if (this.mActivity != null) {
                this.mActivity.moveTaskToBack(true);
                aq.axo().ig(1);
                return;
            }
            return;
        }
        Sc.jO("navigateBack").ag(0, 0).abh().commit();
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
        f Sc = Sc();
        if (Sc != null && Sc.abc() >= 2) {
            c fc = Sc.fc(Sc.abc() - 2);
            a(f, fc);
            if (z) {
                Sc.abd().h(fc);
            } else {
                Sc.abd().i(fc);
            }
        }
    }

    private void a(float f, Fragment fragment) {
        View view;
        float displayWidth = ai.getDisplayWidth(this.mActivity) >> 2;
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

    public boolean fa(int i) {
        return d(i, "", false);
    }

    public boolean G(String str, boolean z) {
        return d(SwanAppConfigData.dU(str), str, z);
    }

    protected boolean d(@ColorInt int i, String str, boolean z) {
        if (this.cbt == null) {
            return false;
        }
        setRightExitViewVisibility(this.cbD ? false : true);
        com.baidu.swan.apps.runtime.config.c aar = aar();
        if (aar != null) {
            if (!TextUtils.isEmpty(str)) {
                aar.cIG = str;
            }
            aar.ft(z);
        }
        int i2 = i == -16777216 ? -16777216 : -1;
        if (immersionEnabled() && i2 != this.cbA) {
            this.cbA = i2;
            applyImmersion();
        }
        return this.cbt.B(i, this.cbD);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean immersionEnabled() {
        return this.mImmersionEnabled;
    }

    protected com.baidu.swan.apps.runtime.config.c aar() {
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
        this.cbz = new com.baidu.swan.apps.view.a.b(this.mActivity, frameLayout);
        applyImmersion();
        return frameLayout;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void applyImmersion() {
        if (this.cbz != null) {
            applyImmersion(this.mStatusBarColor);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void applyImmersion(@ColorInt int i) {
        if (this.cbz != null) {
            u(i, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void u(@ColorInt int i, boolean z) {
        boolean z2 = true;
        if (this.cbz != null) {
            this.mStatusBarColor = i;
            if (this.cbA == 1) {
                z2 = com.baidu.swan.apps.aq.h.ic(i);
            } else if (this.cbA != -16777216) {
                z2 = false;
            }
            this.cbz.c(i, z, z2);
        }
    }

    public void resetWithCurImmersion() {
        if (immersionEnabled() && this.cbz != null) {
            this.cbz.resetWithCurImmersion();
        }
    }

    @Nullable
    public com.baidu.swan.apps.view.a.b aas() {
        return this.cbz;
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
        aat();
        aau();
        return wrapSlideView;
    }

    private void aat() {
        if (aar() != null && aar().cIN) {
            com.baidu.swan.apps.runtime.e arw = com.baidu.swan.apps.runtime.e.arw();
            if (arw != null) {
                arw.arH().b(arw.arp(), "scope_disable_swipe_back", new com.baidu.swan.apps.aq.e.b<com.baidu.swan.apps.setting.oauth.h<b.d>>() { // from class: com.baidu.swan.apps.core.d.c.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.aq.e.b
                    /* renamed from: a */
                    public void H(com.baidu.swan.apps.setting.oauth.h<b.d> hVar) {
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
        return (aav().getConfiguration().orientation == 2 || Build.VERSION.SDK_INT == 26) ? false : true;
    }

    private void aau() {
        this.mSlideHelper.setSlideListener(new SlidingPaneLayout.PanelSlideListener() { // from class: com.baidu.swan.apps.core.d.c.3
            @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
            public void onPanelSlide(View view, float f) {
                View maskView = c.this.mSlideHelper.getMaskView();
                if (maskView != null) {
                    maskView.setAlpha(1.0f - f);
                }
                c.this.onPanelSlide(f);
                if (c.this.cbC != null) {
                    c.this.cbC.VM();
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

    public final Resources aav() {
        return isAdded() ? getResources() : AppRuntime.getAppContext().getResources();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean aaw() {
        if ((this.mActivity instanceof SwanAppActivity) && ((SwanAppActivity) this.mActivity).RU() == 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int RU() {
        if (this.mActivity instanceof SwanAppActivity) {
            return ((SwanAppActivity) this.mActivity).RU();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Gv() {
        if (this.mAudioManager != null && this.bbt != null) {
            this.mAudioManager.abandonAudioFocus(this.bbt);
        }
    }

    public boolean aax() {
        if (this.cbt == null) {
            return false;
        }
        this.cbt.fP(true);
        return true;
    }

    public boolean aay() {
        if (this.cbt == null) {
            return false;
        }
        this.cbt.fP(false);
        return true;
    }

    public void dM(boolean z) {
        if (this.cbt != null) {
            this.cbt.setActionBarCustom(z);
        }
        if (this.cbx != null) {
            int i = 8;
            if (!z && aal()) {
                i = 0;
            }
            this.cbx.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int aaz() {
        if (TextUtils.isEmpty(com.baidu.swan.apps.runtime.e.arx())) {
            return 0;
        }
        if (com.baidu.swan.apps.database.favorite.a.ky(com.baidu.swan.apps.runtime.e.arx())) {
            return 2;
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aaA() {
        return "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u".equals(com.baidu.swan.apps.runtime.e.arx());
    }

    public void aaB() {
        com.baidu.swan.apps.scheme.actions.k.a.J("backtohome", "menu", com.baidu.swan.apps.v.f.akr().aka());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "gohome";
        fVar.mSource = "menu";
        a(fVar);
    }

    public void ZU() {
    }

    public com.baidu.swan.apps.model.c aaC() {
        return this.cbr;
    }

    /* loaded from: classes7.dex */
    private class a {
        private int cbI = 0;
        private long cbJ = 0;
        private Runnable cbK;

        a(Runnable runnable) {
            this.cbK = runnable;
        }

        void onClick() {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.cbJ > 1333) {
                this.cbJ = currentTimeMillis;
                this.cbI = 1;
                return;
            }
            this.cbI++;
            if (this.cbI == 3) {
                if (this.cbK != null) {
                    this.cbK.run();
                }
                this.cbI = 0;
                this.cbJ = 0L;
                return;
            }
            this.cbJ = currentTimeMillis;
        }
    }

    public void a(b bVar) {
        this.cbC = bVar;
    }

    public View aaD() {
        return this.cbs;
    }
}
