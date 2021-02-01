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
/* loaded from: classes9.dex */
public abstract class c extends Fragment implements SlideInterceptor {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private AudioManager.OnAudioFocusChangeListener bxG;
    protected com.baidu.swan.apps.model.c cRF;
    protected View cRG;
    protected SwanAppActionBar cRH;
    protected com.baidu.swan.menu.g cRI;
    protected SwanAppMenuHeaderView cRJ;
    protected String cRK;
    protected View cRL;
    protected TextView cRM;
    @Nullable
    protected com.baidu.swan.apps.view.a.b cRN;
    private a cRR;
    private b cRS;
    protected Activity mActivity;
    private AudioManager mAudioManager;
    protected SlideHelper mSlideHelper;
    private boolean cRO = com.baidu.swan.apps.view.a.b.dAU;
    private int cRP = 1;
    private int cRQ = 1;
    private boolean cRT = false;

    /* loaded from: classes9.dex */
    public interface b {
        void ajW();
    }

    public abstract boolean aiQ();

    protected abstract boolean ajr();

    protected abstract void ajx();

    protected abstract void aof();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean aog();

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onAttach(Context context) {
        if (DEBUG) {
            Log.d("SwanAppBaseFragment", "onAttach");
        }
        super.onAttach(context);
        this.mActivity = bdU();
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
            Field declaredField = Fragment.class.getDeclaredField("ewu");
            declaredField.setAccessible(true);
            declaredField.set(this, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aq(View view) {
        com.baidu.swan.apps.runtime.config.c pm;
        au(view);
        SwanAppConfigData azQ = com.baidu.swan.apps.v.f.aAl().azQ();
        if (azQ == null) {
            if (DEBUG) {
                Log.d("SwanAppBaseFragment", "config data is null. " + Log.getStackTraceString(new Exception()));
                return;
            }
            return;
        }
        if (this.cRF == null) {
            pm = azQ.dES;
        } else {
            pm = com.baidu.swan.apps.v.f.aAl().pm(com.baidu.swan.apps.scheme.actions.k.j.c(this.cRF.getPage(), azQ));
        }
        gH(pm.dFB);
        this.cRH.setTitle(pm.dFC);
        this.cRR = new a(new Runnable() { // from class: com.baidu.swan.apps.core.d.c.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.y.f.aCJ();
            }
        });
        if (!(this instanceof SwanAppAdLandingFragment)) {
            gI(SwanAppConfigData.rM(pm.dFD));
        }
        this.cRK = pm.dFD;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void au(View view) {
        if (view != null) {
            this.cRH = (SwanAppActionBar) view.findViewById(a.f.ai_apps_title_bar);
            this.cRG = view.findViewById(a.f.ai_apps_title_bar_root);
            this.cRL = view.findViewById(a.f.title_shadow);
            this.cRH.setLeftBackViewMinWidth(ah.dip2px(this.mActivity, 38.0f));
            this.cRH.setLeftBackViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (com.baidu.swan.apps.p.a.avH().avI()) {
                        com.baidu.swan.apps.p.a.avH().a(c.this.mActivity, new com.baidu.swan.apps.core.f.b<Boolean>() { // from class: com.baidu.swan.apps.core.d.c.4.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.swan.apps.core.f.b
                            /* renamed from: f */
                            public void N(Boolean bool) {
                                if (bool.booleanValue()) {
                                    c.this.aoD();
                                }
                            }
                        });
                    } else {
                        c.this.aoD();
                    }
                }
            });
            this.cRH.setRightMenuOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    c.this.aof();
                    com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                    fVar.mValue = "menu";
                    if (com.baidu.swan.apps.runtime.e.aIL() != null && com.baidu.swan.apps.runtime.e.aIL().aJc().c("key_unread_counts_message", 0).intValue() > 0) {
                        fVar.mPage = String.valueOf(1);
                    }
                    c.this.a(fVar);
                    if (c.this.cRR != null) {
                        c.this.cRR.onClick();
                    }
                }
            });
            this.cRH.setRightExitOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.c.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (c.this.mActivity != null && (c.this.mActivity instanceof SwanAppActivity)) {
                        if (com.baidu.swan.apps.runtime.e.aIK() == null || com.baidu.swan.apps.runtime.e.aIM() == null) {
                            c.this.aox();
                        } else if (com.baidu.swan.apps.p.a.avH().avI()) {
                            com.baidu.swan.apps.p.a.avH().a(c.this.mActivity, new com.baidu.swan.apps.core.f.b<Boolean>() { // from class: com.baidu.swan.apps.core.d.c.6.1
                                /* JADX DEBUG: Method merged with bridge method */
                                @Override // com.baidu.swan.apps.core.f.b
                                /* renamed from: f */
                                public void N(Boolean bool) {
                                    if (bool.booleanValue()) {
                                        c.this.aox();
                                    }
                                }
                            });
                        } else if (com.baidu.swan.apps.p.c.avO().avP()) {
                            c.this.aox();
                        } else {
                            com.baidu.swan.apps.p.b avJ = new com.baidu.swan.apps.p.b().avJ();
                            if (!avJ.isShow()) {
                                c.this.aox();
                                return;
                            }
                            com.baidu.swan.apps.p.c.avO().a(c.this.mActivity, avJ.getImageUrl(), avJ.avN(), c.this.aow());
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c.a aow() {
        return new c.a() { // from class: com.baidu.swan.apps.core.d.c.7
            @Override // com.baidu.swan.apps.p.c.a
            public void aoY() {
                c.this.aox();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aox() {
        if (this.mActivity != null) {
            com.baidu.swan.apps.v.g.aAu().setForeground(false);
            this.mActivity.moveTaskToBack(true);
            aoy();
            ((SwanAppActivity) this.mActivity).fZ(1);
            ap.aOA().kn(2);
        }
    }

    private void aoy() {
        HashMap hashMap = new HashMap();
        hashMap.put("lcType", "onClose");
        hashMap.put("appId", com.baidu.swan.apps.runtime.e.aIM());
        com.baidu.swan.apps.v.f.aAl().b(new com.baidu.swan.apps.event.a.c(hashMap));
        com.baidu.swan.apps.console.c.i("SwanAppBaseFragment", "onClose");
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "close";
        a(fVar);
    }

    public boolean gH(int i) {
        return x(i, false);
    }

    public boolean x(int i, boolean z) {
        if (this.cRH == null || this.cRL == null) {
            return false;
        }
        this.cRQ = i;
        this.cRH.setBackgroundColor(i);
        com.baidu.swan.apps.runtime.config.c aoJ = aoJ();
        if (aoJ != null) {
            aoJ.dFB = i;
            aoJ.hl(z);
        }
        if (aoI()) {
            aoK();
        }
        if (aoA()) {
            this.cRL.setVisibility(0);
        } else {
            this.cRL.setVisibility(8);
        }
        return true;
    }

    public boolean a(FrameLayout frameLayout, int i) {
        if (frameLayout == null) {
            return false;
        }
        frameLayout.setBackgroundColor(i);
        com.baidu.swan.apps.runtime.config.c aoJ = aoJ();
        if (aoJ != null) {
            aoJ.backgroundColor = i;
        }
        return true;
    }

    public SwanAppActionBar aoz() {
        return this.cRH;
    }

    public boolean aoA() {
        return this.cRQ == -1;
    }

    public void setRightExitViewVisibility(boolean z) {
        this.cRH.setRightExitViewVisibility(z);
    }

    public void setRightZoneVisibility(boolean z) {
        this.cRH.setRightZoneVisibility(z);
    }

    public void fh(boolean z) {
        this.cRT = z;
    }

    public void fi(boolean z) {
        FloatButton aKb = com.baidu.swan.apps.scheme.actions.d.a.aJZ().aKb();
        if (!z) {
            if (aKb != null && aKb.getVisibility() == 0) {
                aKb.setVisibility(8);
            }
        } else if (aKb != null && aKb.getVisibility() != 0) {
            aKb.setVisibility(0);
        }
    }

    public void fj(boolean z) {
        c gL;
        f afX = com.baidu.swan.apps.v.f.aAl().afX();
        if (afX != null) {
            if (z) {
                gL = afX.apx();
            } else {
                gL = afX.gL(afX.apA() - 1);
            }
            if (gL != null) {
                fi(gL.ajr());
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
            aoL();
        }
        aoB();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (aoI() && this.cRN != null && configuration.orientation == 1) {
            bdU().getWindow().clearFlags(1024);
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.d.c.8
                @Override // java.lang.Runnable
                public void run() {
                    c.this.aoL();
                }
            }, 200L);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z) {
            aoL();
        }
    }

    public void aoB() {
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.core.d.c.9
            @Override // java.lang.Runnable
            public void run() {
                c.this.fk(com.baidu.swan.apps.ad.a.a.aFp());
            }
        }, "updateCtsView", 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fk(final boolean z) {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.d.c.10
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.mActivity != null && c.this.cRH != null) {
                    if (z) {
                        if (c.this.cRM == null) {
                            c.this.cRM = new TextView(c.this.mActivity);
                        }
                        if (!(c.this.cRM.getParent() instanceof SwanAppActionBar)) {
                            c.this.cRM.setText(a.h.aiapps_debug_open_cts);
                            c.this.cRM.setTextColor(c.this.aoP().getColor(17170455));
                            c.this.cRH.addView(c.this.cRM);
                        }
                    } else if (c.this.cRM != null) {
                        c.this.cRH.removeView(c.this.cRM);
                        c.this.cRM = null;
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
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.cRH, "alpha", 0.0f, 1.0f);
        ofFloat.setDuration(i);
        ofFloat.setInterpolator(accelerateDecelerateInterpolator);
        ofFloat.start();
        if (this.cRN != null && this.cRN.aOS() != null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.cRN.aOS(), "alpha", 0.0f, 1.0f);
            ofFloat2.setDuration(i);
            ofFloat2.setInterpolator(accelerateDecelerateInterpolator);
            ofFloat2.start();
        }
    }

    @Nullable
    public boolean mv(String str) {
        return P(str, false);
    }

    public boolean P(String str, boolean z) {
        if (this.cRH == null) {
            return false;
        }
        this.cRH.setTitle(str);
        com.baidu.swan.apps.runtime.config.c aoJ = aoJ();
        if (aoJ != null) {
            aoJ.dFC = str;
            aoJ.hl(z);
        }
        com.baidu.swan.apps.console.c.i("SwanAppBaseFragment", "page title: " + str);
        return true;
    }

    protected void aoC() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aoD() {
        if (this.mActivity != null) {
            this.mActivity.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void fl(boolean z) {
        this.cRH.setLeftBackViewVisibility(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aoE() {
        this.cRH.setLeftHomeViewVisibility(0);
        this.cRH.setLeftHomeViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.c.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.aoC();
            }
        });
    }

    public boolean isSlidable(MotionEvent motionEvent) {
        return true;
    }

    public final f afX() {
        if (this.mActivity == null) {
            return null;
        }
        return ((SwanAppActivity) this.mActivity).afX();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean aoF() {
        f afX = afX();
        if (afX == null) {
            return false;
        }
        return afX.apA() > 1;
    }

    public void aoG() {
        f afX = afX();
        if (afX == null || afX.apA() == 1) {
            if (this.mActivity != null) {
                this.mActivity.moveTaskToBack(true);
                ap.aOA().kn(1);
                return;
            }
            return;
        }
        afX.mC("navigateBack").af(0, 0).apE().commit();
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "back";
        a(fVar);
    }

    public void H(float f) {
        b(true, f);
    }

    public void aoH() {
        b(false, 1.0f);
    }

    private void b(boolean z, float f) {
        f afX = afX();
        if (afX != null && afX.apA() >= 2) {
            c gL = afX.gL(afX.apA() - 2);
            a(f, gL);
            if (z) {
                afX.apB().h(gL);
            } else {
                afX.apB().i(gL);
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

    public boolean gI(int i) {
        return e(i, "", false);
    }

    public boolean Q(String str, boolean z) {
        return e(SwanAppConfigData.rM(str), str, z);
    }

    protected boolean e(@ColorInt int i, String str, boolean z) {
        if (this.cRH == null) {
            return false;
        }
        setRightExitViewVisibility(this.cRT ? false : true);
        com.baidu.swan.apps.runtime.config.c aoJ = aoJ();
        if (aoJ != null) {
            if (!TextUtils.isEmpty(str)) {
                aoJ.dFD = str;
            }
            aoJ.hl(z);
        }
        int i2 = i == -16777216 ? -16777216 : -1;
        if (aoI() && i2 != this.cRP) {
            this.cRP = i2;
            aoK();
        }
        return this.cRH.E(i, this.cRT);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aoI() {
        return this.cRO;
    }

    protected com.baidu.swan.apps.runtime.config.c aoJ() {
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
        this.cRN = new com.baidu.swan.apps.view.a.b(this.mActivity, frameLayout);
        aoK();
        return frameLayout;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aoK() {
        if (this.cRN != null) {
            gJ(this.cRQ);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void gJ(@ColorInt int i) {
        if (this.cRN != null) {
            y(i, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void y(@ColorInt int i, boolean z) {
        boolean z2 = true;
        if (this.cRN != null) {
            this.cRQ = i;
            if (this.cRP == 1) {
                z2 = com.baidu.swan.apps.ao.h.kj(i);
            } else if (this.cRP != -16777216) {
                z2 = false;
            }
            this.cRN.d(i, z, z2);
        }
    }

    public void aoL() {
        if (aoI() && this.cRN != null) {
            this.cRN.aoL();
        }
    }

    @Nullable
    public com.baidu.swan.apps.view.a.b aoM() {
        return this.cRN;
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
        aoN();
        aoO();
        return wrapSlideView;
    }

    private void aoN() {
        if (aoJ() != null && aoJ().dFK) {
            com.baidu.swan.apps.runtime.e aIL = com.baidu.swan.apps.runtime.e.aIL();
            if (aIL != null) {
                aIL.aIW().b(aIL.aIE(), "scope_disable_swipe_back", new com.baidu.swan.apps.ao.e.b<com.baidu.swan.apps.setting.oauth.h<b.d>>() { // from class: com.baidu.swan.apps.core.d.c.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.ao.e.b
                    /* renamed from: a */
                    public void L(com.baidu.swan.apps.setting.oauth.h<b.d> hVar) {
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
        return (aoP().getConfiguration().orientation == 2 || Build.VERSION.SDK_INT == 26) ? false : true;
    }

    private void aoO() {
        this.mSlideHelper.setSlideListener(new SlidingPaneLayout.PanelSlideListener() { // from class: com.baidu.swan.apps.core.d.c.3
            @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
            public void onPanelSlide(View view, float f) {
                View maskView = c.this.mSlideHelper.getMaskView();
                if (maskView != null) {
                    maskView.setAlpha(1.0f - f);
                }
                c.this.H(f);
                if (c.this.cRS != null) {
                    c.this.cRS.ajW();
                }
            }

            @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
            public void onPanelOpened(View view) {
                c.this.aoG();
            }

            @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
            public void onPanelClosed(View view) {
                c.this.aoH();
            }
        });
    }

    public final Resources aoP() {
        return isAdded() ? getResources() : AppRuntime.getAppContext().getResources();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean aoQ() {
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
        if (this.mAudioManager != null && this.bxG != null) {
            this.mAudioManager.abandonAudioFocus(this.bxG);
        }
    }

    public boolean aoR() {
        if (this.cRH == null) {
            return false;
        }
        this.cRH.hH(true);
        return true;
    }

    public boolean aoS() {
        if (this.cRH == null) {
            return false;
        }
        this.cRH.hH(false);
        return true;
    }

    public void fm(boolean z) {
        if (this.cRH != null) {
            this.cRH.setActionBarCustom(z);
        }
        if (this.cRL != null) {
            int i = 8;
            if (!z && aoA()) {
                i = 0;
            }
            this.cRL.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int aoT() {
        if (TextUtils.isEmpty(com.baidu.swan.apps.runtime.e.aIM())) {
            return 0;
        }
        if (com.baidu.swan.apps.database.favorite.a.np(com.baidu.swan.apps.runtime.e.aIM())) {
            return 2;
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aoU() {
        return "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u".equals(com.baidu.swan.apps.runtime.e.aIM());
    }

    public void aoV() {
        com.baidu.swan.apps.scheme.actions.k.a.aa("backtohome", "menu", com.baidu.swan.apps.v.f.aAl().azU());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "gohome";
        fVar.mSource = "menu";
        a(fVar);
    }

    public void aoj() {
    }

    public com.baidu.swan.apps.model.c aoW() {
        return this.cRF;
    }

    /* loaded from: classes9.dex */
    private class a {
        private Runnable cRZ;
        private int mCounter = 0;
        private long cRY = 0;

        a(Runnable runnable) {
            this.cRZ = runnable;
        }

        void onClick() {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.cRY > 1333) {
                this.cRY = currentTimeMillis;
                this.mCounter = 1;
                return;
            }
            this.mCounter++;
            if (this.mCounter == 3) {
                if (this.cRZ != null) {
                    this.cRZ.run();
                }
                this.mCounter = 0;
                this.cRY = 0L;
                return;
            }
            this.cRY = currentTimeMillis;
        }
    }

    public void a(b bVar) {
        this.cRS = bVar;
    }

    public View aoX() {
        return this.cRG;
    }
}
