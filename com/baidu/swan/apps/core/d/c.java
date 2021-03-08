package com.baidu.swan.apps.core.d;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.AudioManager;
import android.os.Build;
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
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.widget.SlideHelper;
import com.baidu.searchbox.widget.SlideInterceptor;
import com.baidu.searchbox.widget.SlidingPaneLayout;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment;
import com.baidu.swan.apps.ao.ah;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.ao.ap;
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
    private AudioManager.OnAudioFocusChangeListener bzg;
    protected com.baidu.swan.apps.model.c cTf;
    protected View cTg;
    protected SwanAppActionBar cTh;
    protected com.baidu.swan.menu.g cTi;
    protected SwanAppMenuHeaderView cTj;
    protected String cTk;
    protected View cTl;
    protected TextView cTm;
    @Nullable
    protected com.baidu.swan.apps.view.a.b cTn;
    private a cTr;
    private b cTs;
    protected Activity mActivity;
    private AudioManager mAudioManager;
    protected SlideHelper mSlideHelper;
    private boolean cTo = com.baidu.swan.apps.view.a.b.dCv;
    private int cTp = 1;
    private int cTq = 1;
    private boolean cTt = false;

    /* loaded from: classes8.dex */
    public interface b {
        void ajZ();
    }

    public abstract boolean aiT();

    protected abstract void ajA();

    protected abstract boolean aju();

    protected abstract void aoi();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean aoj();

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onAttach(Context context) {
        if (DEBUG) {
            Log.d("SwanAppBaseFragment", "onAttach");
        }
        super.onAttach(context);
        this.mActivity = bdW();
        fj(true);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDetach() {
        if (DEBUG) {
            Log.d("SwanAppBaseFragment", "onDetach");
        }
        this.mActivity = null;
        fj(false);
        super.onDetach();
        try {
            Field declaredField = Fragment.class.getDeclaredField("exW");
            declaredField.setAccessible(true);
            declaredField.set(this, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aq(View view) {
        com.baidu.swan.apps.runtime.config.c pt;
        au(view);
        SwanAppConfigData azT = com.baidu.swan.apps.v.f.aAo().azT();
        if (azT == null) {
            if (DEBUG) {
                Log.d("SwanAppBaseFragment", "config data is null. " + Log.getStackTraceString(new Exception()));
                return;
            }
            return;
        }
        if (this.cTf == null) {
            pt = azT.dGt;
        } else {
            pt = com.baidu.swan.apps.v.f.aAo().pt(com.baidu.swan.apps.scheme.actions.k.j.c(this.cTf.getPage(), azT));
        }
        gI(pt.dHc);
        this.cTh.setTitle(pt.dHd);
        this.cTr = new a(new Runnable() { // from class: com.baidu.swan.apps.core.d.c.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.y.f.aCM();
            }
        });
        if (!(this instanceof SwanAppAdLandingFragment)) {
            gJ(SwanAppConfigData.rT(pt.dHe));
        }
        this.cTk = pt.dHe;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void au(View view) {
        if (view != null) {
            this.cTh = (SwanAppActionBar) view.findViewById(a.f.ai_apps_title_bar);
            this.cTg = view.findViewById(a.f.ai_apps_title_bar_root);
            this.cTl = view.findViewById(a.f.title_shadow);
            this.cTh.setLeftBackViewMinWidth(ah.dip2px(this.mActivity, 38.0f));
            this.cTh.setLeftBackViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (com.baidu.swan.apps.p.a.avK().avL()) {
                        com.baidu.swan.apps.p.a.avK().a(c.this.mActivity, new com.baidu.swan.apps.core.f.b<Boolean>() { // from class: com.baidu.swan.apps.core.d.c.4.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.swan.apps.core.f.b
                            /* renamed from: f */
                            public void P(Boolean bool) {
                                if (bool.booleanValue()) {
                                    c.this.aoG();
                                }
                            }
                        });
                    } else {
                        c.this.aoG();
                    }
                }
            });
            this.cTh.setRightMenuOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    c.this.aoi();
                    com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                    fVar.mValue = "menu";
                    if (com.baidu.swan.apps.runtime.e.aIO() != null && com.baidu.swan.apps.runtime.e.aIO().aJf().c("key_unread_counts_message", (Integer) 0).intValue() > 0) {
                        fVar.mPage = String.valueOf(1);
                    }
                    c.this.a(fVar);
                    if (c.this.cTr != null) {
                        c.this.cTr.onClick();
                    }
                }
            });
            this.cTh.setRightExitOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.c.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (c.this.mActivity != null && (c.this.mActivity instanceof SwanAppActivity)) {
                        if (com.baidu.swan.apps.runtime.e.aIN() == null || com.baidu.swan.apps.runtime.e.aIP() == null) {
                            c.this.aoA();
                        } else if (com.baidu.swan.apps.p.a.avK().avL()) {
                            com.baidu.swan.apps.p.a.avK().a(c.this.mActivity, new com.baidu.swan.apps.core.f.b<Boolean>() { // from class: com.baidu.swan.apps.core.d.c.6.1
                                /* JADX DEBUG: Method merged with bridge method */
                                @Override // com.baidu.swan.apps.core.f.b
                                /* renamed from: f */
                                public void P(Boolean bool) {
                                    if (bool.booleanValue()) {
                                        c.this.aoA();
                                    }
                                }
                            });
                        } else if (com.baidu.swan.apps.p.c.avR().avS()) {
                            c.this.aoA();
                        } else {
                            com.baidu.swan.apps.p.b avM = new com.baidu.swan.apps.p.b().avM();
                            if (!avM.isShow()) {
                                c.this.aoA();
                                return;
                            }
                            com.baidu.swan.apps.p.c.avR().a(c.this.mActivity, avM.getImageUrl(), avM.avQ(), c.this.aoz());
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c.a aoz() {
        return new c.a() { // from class: com.baidu.swan.apps.core.d.c.7
            @Override // com.baidu.swan.apps.p.c.a
            public void apb() {
                c.this.aoA();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoA() {
        if (this.mActivity != null) {
            com.baidu.swan.apps.v.g.aAx().setForeground(false);
            this.mActivity.moveTaskToBack(true);
            aoB();
            ((SwanAppActivity) this.mActivity).ga(1);
            ap.aOD().ko(2);
        }
    }

    private void aoB() {
        HashMap hashMap = new HashMap();
        hashMap.put("lcType", "onClose");
        hashMap.put("appId", com.baidu.swan.apps.runtime.e.aIP());
        com.baidu.swan.apps.v.f.aAo().b(new com.baidu.swan.apps.event.a.c(hashMap));
        com.baidu.swan.apps.console.c.i("SwanAppBaseFragment", "onClose");
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "close";
        a(fVar);
    }

    public boolean gI(int i) {
        return x(i, false);
    }

    public boolean x(int i, boolean z) {
        if (this.cTh == null || this.cTl == null) {
            return false;
        }
        this.cTq = i;
        this.cTh.setBackgroundColor(i);
        com.baidu.swan.apps.runtime.config.c aoM = aoM();
        if (aoM != null) {
            aoM.dHc = i;
            aoM.hl(z);
        }
        if (aoL()) {
            aoN();
        }
        if (aoD()) {
            this.cTl.setVisibility(0);
        } else {
            this.cTl.setVisibility(8);
        }
        return true;
    }

    public boolean a(FrameLayout frameLayout, int i) {
        if (frameLayout == null) {
            return false;
        }
        frameLayout.setBackgroundColor(i);
        com.baidu.swan.apps.runtime.config.c aoM = aoM();
        if (aoM != null) {
            aoM.backgroundColor = i;
        }
        return true;
    }

    public SwanAppActionBar aoC() {
        return this.cTh;
    }

    public boolean aoD() {
        return this.cTq == -1;
    }

    public void setRightExitViewVisibility(boolean z) {
        this.cTh.setRightExitViewVisibility(z);
    }

    public void setRightZoneVisibility(boolean z) {
        this.cTh.setRightZoneVisibility(z);
    }

    public void fh(boolean z) {
        this.cTt = z;
    }

    public void fi(boolean z) {
        FloatButton aKe = com.baidu.swan.apps.scheme.actions.d.a.aKc().aKe();
        if (!z) {
            if (aKe != null && aKe.getVisibility() == 0) {
                aKe.setVisibility(8);
            }
        } else if (aKe != null && aKe.getVisibility() != 0) {
            aKe.setVisibility(0);
        }
    }

    public void fj(boolean z) {
        c gM;
        f aga = com.baidu.swan.apps.v.f.aAo().aga();
        if (aga != null) {
            if (z) {
                gM = aga.apA();
            } else {
                gM = aga.gM(aga.apD() - 1);
            }
            if (gM != null) {
                fi(gM.aju());
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
            aoO();
        }
        aoE();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (aoL() && this.cTn != null && configuration.orientation == 1) {
            bdW().getWindow().clearFlags(1024);
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.d.c.8
                @Override // java.lang.Runnable
                public void run() {
                    c.this.aoO();
                }
            }, 200L);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z) {
            aoO();
        }
    }

    public void aoE() {
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.core.d.c.9
            @Override // java.lang.Runnable
            public void run() {
                c.this.fk(com.baidu.swan.apps.ad.a.a.aFs());
            }
        }, "updateCtsView", 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fk(final boolean z) {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.d.c.10
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.mActivity != null && c.this.cTh != null) {
                    if (z) {
                        if (c.this.cTm == null) {
                            c.this.cTm = new TextView(c.this.mActivity);
                        }
                        if (!(c.this.cTm.getParent() instanceof SwanAppActionBar)) {
                            c.this.cTm.setText(a.h.aiapps_debug_open_cts);
                            c.this.cTm.setTextColor(c.this.aoS().getColor(17170455));
                            c.this.cTh.addView(c.this.cTm);
                        }
                    } else if (c.this.cTm != null) {
                        c.this.cTh.removeView(c.this.cTm);
                        c.this.cTm = null;
                    }
                }
            }
        });
    }

    public void ap(int i, String str) {
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
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.cTh, "alpha", 0.0f, 1.0f);
        ofFloat.setDuration(i);
        ofFloat.setInterpolator(accelerateDecelerateInterpolator);
        ofFloat.start();
        if (this.cTn != null && this.cTn.aOV() != null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.cTn.aOV(), "alpha", 0.0f, 1.0f);
            ofFloat2.setDuration(i);
            ofFloat2.setInterpolator(accelerateDecelerateInterpolator);
            ofFloat2.start();
        }
    }

    @Nullable
    public boolean mC(String str) {
        return P(str, false);
    }

    public boolean P(String str, boolean z) {
        if (this.cTh == null) {
            return false;
        }
        this.cTh.setTitle(str);
        com.baidu.swan.apps.runtime.config.c aoM = aoM();
        if (aoM != null) {
            aoM.dHd = str;
            aoM.hl(z);
        }
        com.baidu.swan.apps.console.c.i("SwanAppBaseFragment", "page title: " + str);
        return true;
    }

    protected void aoF() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aoG() {
        if (this.mActivity != null) {
            this.mActivity.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void fl(boolean z) {
        this.cTh.setLeftBackViewVisibility(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aoH() {
        this.cTh.setLeftHomeViewVisibility(0);
        this.cTh.setLeftHomeViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.c.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.aoF();
            }
        });
    }

    public boolean isSlidable(MotionEvent motionEvent) {
        return true;
    }

    public final f aga() {
        if (this.mActivity == null) {
            return null;
        }
        return ((SwanAppActivity) this.mActivity).aga();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean aoI() {
        f aga = aga();
        if (aga == null) {
            return false;
        }
        return aga.apD() > 1;
    }

    public void aoJ() {
        f aga = aga();
        if (aga == null || aga.apD() == 1) {
            if (this.mActivity != null) {
                this.mActivity.moveTaskToBack(true);
                ap.aOD().ko(1);
                return;
            }
            return;
        }
        aga.mJ("navigateBack").af(0, 0).apH().commit();
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "back";
        a(fVar);
    }

    public void L(float f) {
        b(true, f);
    }

    public void aoK() {
        b(false, 1.0f);
    }

    private void b(boolean z, float f) {
        f aga = aga();
        if (aga != null && aga.apD() >= 2) {
            c gM = aga.gM(aga.apD() - 2);
            a(f, gM);
            if (z) {
                aga.apE().h(gM);
            } else {
                aga.apE().i(gM);
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

    public boolean gJ(int i) {
        return e(i, "", false);
    }

    public boolean Q(String str, boolean z) {
        return e(SwanAppConfigData.rT(str), str, z);
    }

    protected boolean e(@ColorInt int i, String str, boolean z) {
        if (this.cTh == null) {
            return false;
        }
        setRightExitViewVisibility(this.cTt ? false : true);
        com.baidu.swan.apps.runtime.config.c aoM = aoM();
        if (aoM != null) {
            if (!TextUtils.isEmpty(str)) {
                aoM.dHe = str;
            }
            aoM.hl(z);
        }
        int i2 = i == -16777216 ? -16777216 : -1;
        if (aoL() && i2 != this.cTp) {
            this.cTp = i2;
            aoN();
        }
        return this.cTh.E(i, this.cTt);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aoL() {
        return this.cTo;
    }

    protected com.baidu.swan.apps.runtime.config.c aoM() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View av(View view) {
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
            return a(frameLayout, view);
        }
        return view;
    }

    protected View a(FrameLayout frameLayout, View view) {
        frameLayout.setTag("IMMERSION_LAYOUT_TAG");
        frameLayout.addView(view);
        this.cTn = new com.baidu.swan.apps.view.a.b(this.mActivity, frameLayout);
        aoN();
        return frameLayout;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aoN() {
        if (this.cTn != null) {
            gK(this.cTq);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void gK(@ColorInt int i) {
        if (this.cTn != null) {
            y(i, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void y(@ColorInt int i, boolean z) {
        boolean z2 = true;
        if (this.cTn != null) {
            this.cTq = i;
            if (this.cTp == 1) {
                z2 = com.baidu.swan.apps.ao.h.kk(i);
            } else if (this.cTp != -16777216) {
                z2 = false;
            }
            this.cTn.d(i, z, z2);
        }
    }

    public void aoO() {
        if (aoL() && this.cTn != null) {
            this.cTn.aoO();
        }
    }

    @Nullable
    public com.baidu.swan.apps.view.a.b aoP() {
        return this.cTn;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setRequestedOrientation(int i) {
        if (this.mActivity != null) {
            this.mActivity.setRequestedOrientation(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View a(View view, SlideInterceptor slideInterceptor) {
        this.mSlideHelper = new SlideHelper();
        View wrapSlideView = this.mSlideHelper.wrapSlideView(view.getContext(), view, slideInterceptor);
        this.mSlideHelper.setFadeColor(0);
        aoQ();
        aoR();
        return wrapSlideView;
    }

    private void aoQ() {
        if (aoM() != null && aoM().dHl) {
            com.baidu.swan.apps.runtime.e aIO = com.baidu.swan.apps.runtime.e.aIO();
            if (aIO != null) {
                aIO.aIZ().b(aIO.aIH(), "scope_disable_swipe_back", new com.baidu.swan.apps.ao.e.b<com.baidu.swan.apps.setting.oauth.h<b.d>>() { // from class: com.baidu.swan.apps.core.d.c.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.ao.e.b
                    /* renamed from: a */
                    public void N(com.baidu.swan.apps.setting.oauth.h<b.d> hVar) {
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
        return (aoS().getConfiguration().orientation == 2 || Build.VERSION.SDK_INT == 26) ? false : true;
    }

    private void aoR() {
        this.mSlideHelper.setSlideListener(new SlidingPaneLayout.PanelSlideListener() { // from class: com.baidu.swan.apps.core.d.c.3
            @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
            public void onPanelSlide(View view, float f) {
                View maskView = c.this.mSlideHelper.getMaskView();
                if (maskView != null) {
                    maskView.setAlpha(1.0f - f);
                }
                c.this.L(f);
                if (c.this.cTs != null) {
                    c.this.cTs.ajZ();
                }
            }

            @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
            public void onPanelOpened(View view) {
                c.this.aoJ();
            }

            @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
            public void onPanelClosed(View view) {
                c.this.aoK();
            }
        });
    }

    public final Resources aoS() {
        return isAdded() ? getResources() : AppRuntime.getAppContext().getResources();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean aoT() {
        if ((this.mActivity instanceof SwanAppActivity) && ((SwanAppActivity) this.mActivity).getFrameType() == 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getFrameType() {
        if (this.mActivity instanceof SwanAppActivity) {
            return ((SwanAppActivity) this.mActivity).getFrameType();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void abandonAudioFocus() {
        if (this.mAudioManager != null && this.bzg != null) {
            this.mAudioManager.abandonAudioFocus(this.bzg);
        }
    }

    public boolean aoU() {
        if (this.cTh == null) {
            return false;
        }
        this.cTh.hH(true);
        return true;
    }

    public boolean aoV() {
        if (this.cTh == null) {
            return false;
        }
        this.cTh.hH(false);
        return true;
    }

    public void fm(boolean z) {
        if (this.cTh != null) {
            this.cTh.setActionBarCustom(z);
        }
        if (this.cTl != null) {
            int i = 8;
            if (!z && aoD()) {
                i = 0;
            }
            this.cTl.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int aoW() {
        if (TextUtils.isEmpty(com.baidu.swan.apps.runtime.e.aIP())) {
            return 0;
        }
        if (com.baidu.swan.apps.database.favorite.a.nw(com.baidu.swan.apps.runtime.e.aIP())) {
            return 2;
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aoX() {
        return "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u".equals(com.baidu.swan.apps.runtime.e.aIP());
    }

    public void aoY() {
        com.baidu.swan.apps.scheme.actions.k.a.aa("backtohome", "menu", com.baidu.swan.apps.v.f.aAo().azX());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "gohome";
        fVar.mSource = "menu";
        a(fVar);
    }

    public void aom() {
    }

    public com.baidu.swan.apps.model.c aoZ() {
        return this.cTf;
    }

    /* loaded from: classes8.dex */
    private class a {
        private Runnable cTz;
        private int mCounter = 0;
        private long cTy = 0;

        a(Runnable runnable) {
            this.cTz = runnable;
        }

        void onClick() {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.cTy > 1333) {
                this.cTy = currentTimeMillis;
                this.mCounter = 1;
                return;
            }
            this.mCounter++;
            if (this.mCounter == 3) {
                if (this.cTz != null) {
                    this.cTz.run();
                }
                this.mCounter = 0;
                this.cTy = 0L;
                return;
            }
            this.cTy = currentTimeMillis;
        }
    }

    public void a(b bVar) {
        this.cTs = bVar;
    }

    public View apa() {
        return this.cTg;
    }
}
