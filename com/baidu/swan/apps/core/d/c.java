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
    private AudioManager.OnAudioFocusChangeListener bny;
    protected com.baidu.swan.apps.model.c cvK;
    protected View cvL;
    protected SwanAppActionBar cvM;
    protected com.baidu.swan.menu.h cvN;
    protected SwanAppMenuHeaderView cvO;
    protected String cvP;
    protected View cvQ;
    protected TextView cvR;
    @Nullable
    protected com.baidu.swan.apps.view.a.b cvS;
    private a cvU;
    private b cvV;
    protected Activity mActivity;
    private AudioManager mAudioManager;
    protected SlideHelper mSlideHelper;
    private boolean mImmersionEnabled = com.baidu.swan.apps.view.a.b.SUPPORT_IMMERSION;
    private int cvT = 1;
    private int mStatusBarColor = 1;
    private boolean cvW = false;

    /* loaded from: classes10.dex */
    public interface b {
        void afn();
    }

    protected abstract boolean aeI();

    protected abstract void aeO();

    public abstract boolean aeh();

    protected abstract void ajv();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean ajw();

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onAttach(Context context) {
        if (DEBUG) {
            Log.d("SwanAppBaseFragment", "onAttach");
        }
        super.onAttach(context);
        this.mActivity = aYo();
        eo(true);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDetach() {
        if (DEBUG) {
            Log.d("SwanAppBaseFragment", "onDetach");
        }
        this.mActivity = null;
        eo(false);
        super.onDetach();
        try {
            Field declaredField = Fragment.class.getDeclaredField("dVK");
            declaredField.setAccessible(true);
            declaredField.set(this, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void al(View view) {
        com.baidu.swan.apps.runtime.config.c pe;
        ao(view);
        SwanAppConfigData auZ = com.baidu.swan.apps.v.f.avu().auZ();
        if (auZ == null) {
            if (DEBUG) {
                Log.d("SwanAppBaseFragment", "config data is null. " + Log.getStackTraceString(new Exception()));
                return;
            }
            return;
        }
        if (this.cvK == null) {
            pe = auZ.dfg;
        } else {
            pe = com.baidu.swan.apps.v.f.avu().pe(com.baidu.swan.apps.scheme.actions.k.j.c(this.cvK.getPage(), auZ));
        }
        hB(pe.dfP);
        this.cvM.setTitle(pe.dfQ);
        this.cvU = new a(new Runnable() { // from class: com.baidu.swan.apps.core.d.c.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.y.f.axR();
            }
        });
        if (!(this instanceof SwanAppAdLandingFragment)) {
            hC(SwanAppConfigData.fv(pe.dfR));
        }
        this.cvP = pe.dfR;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ao(View view) {
        if (view != null) {
            this.cvM = (SwanAppActionBar) view.findViewById(a.f.ai_apps_title_bar);
            this.cvL = view.findViewById(a.f.ai_apps_title_bar_root);
            this.cvQ = view.findViewById(a.f.title_shadow);
            this.cvM.setLeftBackViewMinWidth(ah.dip2px(this.mActivity, 38.0f));
            this.cvM.setLeftBackViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (com.baidu.swan.apps.p.a.aqQ().aqR()) {
                        com.baidu.swan.apps.p.a.aqQ().a(c.this.mActivity, new com.baidu.swan.apps.core.f.b<Boolean>() { // from class: com.baidu.swan.apps.core.d.c.4.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.swan.apps.core.f.b
                            /* renamed from: e */
                            public void O(Boolean bool) {
                                if (bool.booleanValue()) {
                                    c.this.ajT();
                                }
                            }
                        });
                    } else {
                        c.this.ajT();
                    }
                }
            });
            this.cvM.setRightMenuOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    c.this.ajv();
                    com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                    fVar.mValue = UgcConstant.MENU;
                    if (com.baidu.swan.apps.runtime.e.aDb() != null && com.baidu.swan.apps.runtime.e.aDb().aDs().b("key_unread_counts_message", (Integer) 0).intValue() > 0) {
                        fVar.mPage = String.valueOf(1);
                    }
                    c.this.a(fVar);
                    if (c.this.cvU != null) {
                        c.this.cvU.onClick();
                    }
                }
            });
            this.cvM.setRightExitOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.c.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (c.this.mActivity != null && (c.this.mActivity instanceof SwanAppActivity)) {
                        if (com.baidu.swan.apps.runtime.e.aDa() == null || com.baidu.swan.apps.runtime.e.aDc() == null) {
                            c.this.ajN();
                        } else if (com.baidu.swan.apps.p.a.aqQ().aqR()) {
                            com.baidu.swan.apps.p.a.aqQ().a(c.this.mActivity, new com.baidu.swan.apps.core.f.b<Boolean>() { // from class: com.baidu.swan.apps.core.d.c.6.1
                                /* JADX DEBUG: Method merged with bridge method */
                                @Override // com.baidu.swan.apps.core.f.b
                                /* renamed from: e */
                                public void O(Boolean bool) {
                                    if (bool.booleanValue()) {
                                        c.this.ajN();
                                    }
                                }
                            });
                        } else if (com.baidu.swan.apps.p.c.aqX().aqY()) {
                            c.this.ajN();
                        } else {
                            com.baidu.swan.apps.p.b aqS = new com.baidu.swan.apps.p.b().aqS();
                            if (!aqS.isShow()) {
                                c.this.ajN();
                                return;
                            }
                            com.baidu.swan.apps.p.c.aqX().a(c.this.mActivity, aqS.getImageUrl(), aqS.aqW(), c.this.ajM());
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c.a ajM() {
        return new c.a() { // from class: com.baidu.swan.apps.core.d.c.7
            @Override // com.baidu.swan.apps.p.c.a
            public void akj() {
                c.this.ajN();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajN() {
        if (this.mActivity != null) {
            com.baidu.swan.apps.v.g.avD().setForeground(false);
            this.mActivity.moveTaskToBack(true);
            ajO();
            ((SwanAppActivity) this.mActivity).gU(1);
            ap.aIQ().kW(2);
        }
    }

    private void ajO() {
        HashMap hashMap = new HashMap();
        hashMap.put("lcType", "onClose");
        hashMap.put("appId", com.baidu.swan.apps.runtime.e.aDc());
        com.baidu.swan.apps.v.f.avu().b(new com.baidu.swan.apps.event.a.c(hashMap));
        com.baidu.swan.apps.console.c.i("SwanAppBaseFragment", "onClose");
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "close";
        a(fVar);
    }

    public boolean hB(int i) {
        return x(i, false);
    }

    public boolean x(int i, boolean z) {
        if (this.cvM == null || this.cvQ == null) {
            return false;
        }
        this.mStatusBarColor = i;
        this.cvM.setBackgroundColor(i);
        com.baidu.swan.apps.runtime.config.c ajW = ajW();
        if (ajW != null) {
            ajW.dfP = i;
            ajW.gh(z);
        }
        if (immersionEnabled()) {
            applyImmersion();
        }
        if (ajQ()) {
            this.cvQ.setVisibility(0);
        } else {
            this.cvQ.setVisibility(8);
        }
        return true;
    }

    public boolean a(FrameLayout frameLayout, int i) {
        if (frameLayout == null) {
            return false;
        }
        frameLayout.setBackgroundColor(i);
        com.baidu.swan.apps.runtime.config.c ajW = ajW();
        if (ajW != null) {
            ajW.backgroundColor = i;
        }
        return true;
    }

    public SwanAppActionBar ajP() {
        return this.cvM;
    }

    public boolean ajQ() {
        return this.mStatusBarColor == -1;
    }

    public void setRightExitViewVisibility(boolean z) {
        this.cvM.setRightExitViewVisibility(z);
    }

    public void setRightZoneVisibility(boolean z) {
        this.cvM.setRightZoneVisibility(z);
    }

    public void em(boolean z) {
        this.cvW = z;
    }

    public void en(boolean z) {
        FloatButton aEr = com.baidu.swan.apps.scheme.actions.d.a.aEp().aEr();
        if (!z) {
            if (aEr != null && aEr.getVisibility() == 0) {
                aEr.setVisibility(8);
            }
        } else if (aEr != null && aEr.getVisibility() != 0) {
            aEr.setVisibility(0);
        }
    }

    public void eo(boolean z) {
        c hE;
        f abs = com.baidu.swan.apps.v.f.avu().abs();
        if (abs != null) {
            if (z) {
                hE = abs.akH();
            } else {
                hE = abs.hE(abs.akK() - 1);
            }
            if (hE != null) {
                en(hE.aeI());
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
        ajR();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (immersionEnabled() && this.cvS != null && configuration.orientation == 1) {
            aYo().getWindow().clearFlags(1024);
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

    public void ajR() {
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.core.d.c.9
            @Override // java.lang.Runnable
            public void run() {
                c.this.ep(com.baidu.swan.apps.ad.a.a.aAA());
            }
        }, "updateCtsView", 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ep(final boolean z) {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.d.c.10
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.mActivity != null && c.this.cvM != null) {
                    if (z) {
                        if (c.this.cvR == null) {
                            c.this.cvR = new TextView(c.this.mActivity);
                        }
                        if (!(c.this.cvR.getParent() instanceof SwanAppActionBar)) {
                            c.this.cvR.setText(a.h.aiapps_debug_open_cts);
                            c.this.cvR.setTextColor(c.this.aka().getColor(17170455));
                            c.this.cvM.addView(c.this.cvR);
                        }
                    } else if (c.this.cvR != null) {
                        c.this.cvM.removeView(c.this.cvR);
                        c.this.cvR = null;
                    }
                }
            }
        });
    }

    public void ac(int i, String str) {
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
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.cvM, "alpha", 0.0f, 1.0f);
        ofFloat.setDuration(i);
        ofFloat.setInterpolator(accelerateDecelerateInterpolator);
        ofFloat.start();
        if (this.cvS != null && this.cvS.aJh() != null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.cvS.aJh(), "alpha", 0.0f, 1.0f);
            ofFloat2.setDuration(i);
            ofFloat2.setInterpolator(accelerateDecelerateInterpolator);
            ofFloat2.start();
        }
    }

    @Nullable
    public boolean mm(String str) {
        return N(str, false);
    }

    public boolean N(String str, boolean z) {
        if (this.cvM == null) {
            return false;
        }
        this.cvM.setTitle(str);
        com.baidu.swan.apps.runtime.config.c ajW = ajW();
        if (ajW != null) {
            ajW.dfQ = str;
            ajW.gh(z);
        }
        com.baidu.swan.apps.console.c.i("SwanAppBaseFragment", "page title: " + str);
        return true;
    }

    protected void ajS() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ajT() {
        if (this.mActivity != null) {
            this.mActivity.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eq(boolean z) {
        this.cvM.setLeftBackViewVisibility(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ajU() {
        this.cvM.setLeftHomeViewVisibility(0);
        this.cvM.setLeftHomeViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.c.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.ajS();
            }
        });
    }

    public boolean isSlidable(MotionEvent motionEvent) {
        return true;
    }

    public final f abs() {
        if (this.mActivity == null) {
            return null;
        }
        return ((SwanAppActivity) this.mActivity).abs();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean ajV() {
        f abs = abs();
        if (abs == null) {
            return false;
        }
        return abs.akK() > 1;
    }

    public void finishAfterSlide() {
        f abs = abs();
        if (abs == null || abs.akK() == 1) {
            if (this.mActivity != null) {
                this.mActivity.moveTaskToBack(true);
                ap.aIQ().kW(1);
                return;
            }
            return;
        }
        abs.mt("navigateBack").ak(0, 0).akO().commit();
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
        f abs = abs();
        if (abs != null && abs.akK() >= 2) {
            c hE = abs.hE(abs.akK() - 2);
            a(f, hE);
            if (z) {
                abs.akL().h(hE);
            } else {
                abs.akL().i(hE);
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

    public boolean hC(int i) {
        return f(i, "", false);
    }

    public boolean O(String str, boolean z) {
        return f(SwanAppConfigData.fv(str), str, z);
    }

    protected boolean f(@ColorInt int i, String str, boolean z) {
        if (this.cvM == null) {
            return false;
        }
        setRightExitViewVisibility(this.cvW ? false : true);
        com.baidu.swan.apps.runtime.config.c ajW = ajW();
        if (ajW != null) {
            if (!TextUtils.isEmpty(str)) {
                ajW.dfR = str;
            }
            ajW.gh(z);
        }
        int i2 = i == -16777216 ? -16777216 : -1;
        if (immersionEnabled() && i2 != this.cvT) {
            this.cvT = i2;
            applyImmersion();
        }
        return this.cvM.E(i, this.cvW);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean immersionEnabled() {
        return this.mImmersionEnabled;
    }

    protected com.baidu.swan.apps.runtime.config.c ajW() {
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
        this.cvS = new com.baidu.swan.apps.view.a.b(this.mActivity, frameLayout);
        applyImmersion();
        return frameLayout;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void applyImmersion() {
        if (this.cvS != null) {
            applyImmersion(this.mStatusBarColor);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void applyImmersion(@ColorInt int i) {
        if (this.cvS != null) {
            y(i, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void y(@ColorInt int i, boolean z) {
        boolean z2 = true;
        if (this.cvS != null) {
            this.mStatusBarColor = i;
            if (this.cvT == 1) {
                z2 = com.baidu.swan.apps.ap.h.kS(i);
            } else if (this.cvT != -16777216) {
                z2 = false;
            }
            this.cvS.d(i, z, z2);
        }
    }

    public void resetWithCurImmersion() {
        if (immersionEnabled() && this.cvS != null) {
            this.cvS.resetWithCurImmersion();
        }
    }

    @Nullable
    public com.baidu.swan.apps.view.a.b ajX() {
        return this.cvS;
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
        ajY();
        ajZ();
        return wrapSlideView;
    }

    private void ajY() {
        if (ajW() != null && ajW().dfY) {
            com.baidu.swan.apps.runtime.e aDb = com.baidu.swan.apps.runtime.e.aDb();
            if (aDb != null) {
                aDb.aDm().b(aDb.aCU(), "scope_disable_swipe_back", new com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.setting.oauth.h<b.d>>() { // from class: com.baidu.swan.apps.core.d.c.2
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
        return (aka().getConfiguration().orientation == 2 || Build.VERSION.SDK_INT == 26) ? false : true;
    }

    private void ajZ() {
        this.mSlideHelper.setSlideListener(new SlidingPaneLayout.PanelSlideListener() { // from class: com.baidu.swan.apps.core.d.c.3
            @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
            public void onPanelSlide(View view, float f) {
                View maskView = c.this.mSlideHelper.getMaskView();
                if (maskView != null) {
                    maskView.setAlpha(1.0f - f);
                }
                c.this.onPanelSlide(f);
                if (c.this.cvV != null) {
                    c.this.cvV.afn();
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

    public final Resources aka() {
        return isAdded() ? getResources() : AppRuntime.getAppContext().getResources();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean akb() {
        if ((this.mActivity instanceof SwanAppActivity) && ((SwanAppActivity) this.mActivity).abk() == 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int abk() {
        if (this.mActivity instanceof SwanAppActivity) {
            return ((SwanAppActivity) this.mActivity).abk();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void abandonAudioFocus() {
        if (this.mAudioManager != null && this.bny != null) {
            this.mAudioManager.abandonAudioFocus(this.bny);
        }
    }

    public boolean akc() {
        if (this.cvM == null) {
            return false;
        }
        this.cvM.gD(true);
        return true;
    }

    public boolean akd() {
        if (this.cvM == null) {
            return false;
        }
        this.cvM.gD(false);
        return true;
    }

    public void er(boolean z) {
        if (this.cvM != null) {
            this.cvM.setActionBarCustom(z);
        }
        if (this.cvQ != null) {
            int i = 8;
            if (!z && ajQ()) {
                i = 0;
            }
            this.cvQ.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int ake() {
        if (TextUtils.isEmpty(com.baidu.swan.apps.runtime.e.aDc())) {
            return 0;
        }
        if (com.baidu.swan.apps.database.favorite.a.nh(com.baidu.swan.apps.runtime.e.aDc())) {
            return 2;
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean akf() {
        return "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u".equals(com.baidu.swan.apps.runtime.e.aDc());
    }

    public void akg() {
        com.baidu.swan.apps.scheme.actions.k.a.N("backtohome", UgcConstant.MENU, com.baidu.swan.apps.v.f.avu().avd());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "gohome";
        fVar.mSource = UgcConstant.MENU;
        a(fVar);
    }

    public void ajz() {
    }

    public com.baidu.swan.apps.model.c akh() {
        return this.cvK;
    }

    /* loaded from: classes10.dex */
    private class a {
        private int cwb = 0;
        private long cwc = 0;
        private Runnable cwd;

        a(Runnable runnable) {
            this.cwd = runnable;
        }

        void onClick() {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.cwc > 1333) {
                this.cwc = currentTimeMillis;
                this.cwb = 1;
                return;
            }
            this.cwb++;
            if (this.cwb == 3) {
                if (this.cwd != null) {
                    this.cwd.run();
                }
                this.cwb = 0;
                this.cwc = 0L;
                return;
            }
            this.cwc = currentTimeMillis;
        }
    }

    public void a(b bVar) {
        this.cvV = bVar;
    }

    public View aki() {
        return this.cvL;
    }
}
