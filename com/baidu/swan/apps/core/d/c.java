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
    private AudioManager.OnAudioFocusChangeListener bub;
    private a cPD;
    private b cPE;
    protected com.baidu.swan.apps.model.c cPr;
    protected View cPs;
    protected SwanAppActionBar cPt;
    protected com.baidu.swan.menu.g cPu;
    protected SwanAppMenuHeaderView cPv;
    protected String cPw;
    protected View cPx;
    protected TextView cPy;
    @Nullable
    protected com.baidu.swan.apps.view.a.b cPz;
    protected Activity mActivity;
    private AudioManager mAudioManager;
    protected SlideHelper mSlideHelper;
    private boolean cPA = com.baidu.swan.apps.view.a.b.dyP;
    private int cPB = 1;
    private int cPC = 1;
    private boolean cPF = false;

    /* loaded from: classes8.dex */
    public interface b {
        void ajy();
    }

    protected abstract boolean aiT();

    protected abstract void aiZ();

    public abstract boolean ais();

    protected abstract void anH();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean anI();

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onAttach(Context context) {
        if (DEBUG) {
            Log.d("SwanAppBaseFragment", "onAttach");
        }
        super.onAttach(context);
        this.mActivity = bdH();
        fh(true);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDetach() {
        if (DEBUG) {
            Log.d("SwanAppBaseFragment", "onDetach");
        }
        this.mActivity = null;
        fh(false);
        super.onDetach();
        try {
            Field declaredField = Fragment.class.getDeclaredField("euo");
            declaredField.setAccessible(true);
            declaredField.set(this, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void av(View view) {
        com.baidu.swan.apps.runtime.config.c oU;
        ay(view);
        SwanAppConfigData azs = com.baidu.swan.apps.v.f.azN().azs();
        if (azs == null) {
            if (DEBUG) {
                Log.d("SwanAppBaseFragment", "config data is null. " + Log.getStackTraceString(new Exception()));
                return;
            }
            return;
        }
        if (this.cPr == null) {
            oU = azs.dCO;
        } else {
            oU = com.baidu.swan.apps.v.f.azN().oU(com.baidu.swan.apps.scheme.actions.k.j.c(this.cPr.getPage(), azs));
        }
        gE(oU.dDx);
        this.cPt.setTitle(oU.dDy);
        this.cPD = new a(new Runnable() { // from class: com.baidu.swan.apps.core.d.c.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.y.f.aCn();
            }
        });
        if (!(this instanceof SwanAppAdLandingFragment)) {
            gF(SwanAppConfigData.rt(oU.dDz));
        }
        this.cPw = oU.dDz;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ay(View view) {
        if (view != null) {
            this.cPt = (SwanAppActionBar) view.findViewById(a.f.ai_apps_title_bar);
            this.cPs = view.findViewById(a.f.ai_apps_title_bar_root);
            this.cPx = view.findViewById(a.f.title_shadow);
            this.cPt.setLeftBackViewMinWidth(ah.dip2px(this.mActivity, 38.0f));
            this.cPt.setLeftBackViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (com.baidu.swan.apps.p.a.avj().avk()) {
                        com.baidu.swan.apps.p.a.avj().a(c.this.mActivity, new com.baidu.swan.apps.core.f.b<Boolean>() { // from class: com.baidu.swan.apps.core.d.c.4.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.swan.apps.core.f.b
                            /* renamed from: f */
                            public void N(Boolean bool) {
                                if (bool.booleanValue()) {
                                    c.this.aof();
                                }
                            }
                        });
                    } else {
                        c.this.aof();
                    }
                }
            });
            this.cPt.setRightMenuOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    c.this.anH();
                    com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                    fVar.mValue = "menu";
                    if (com.baidu.swan.apps.runtime.e.aIs() != null && com.baidu.swan.apps.runtime.e.aIs().aIJ().c("key_unread_counts_message", 0).intValue() > 0) {
                        fVar.mPage = String.valueOf(1);
                    }
                    c.this.a(fVar);
                    if (c.this.cPD != null) {
                        c.this.cPD.onClick();
                    }
                }
            });
            this.cPt.setRightExitOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.c.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (c.this.mActivity != null && (c.this.mActivity instanceof SwanAppActivity)) {
                        if (com.baidu.swan.apps.runtime.e.aIr() == null || com.baidu.swan.apps.runtime.e.aIt() == null) {
                            c.this.anZ();
                        } else if (com.baidu.swan.apps.p.a.avj().avk()) {
                            com.baidu.swan.apps.p.a.avj().a(c.this.mActivity, new com.baidu.swan.apps.core.f.b<Boolean>() { // from class: com.baidu.swan.apps.core.d.c.6.1
                                /* JADX DEBUG: Method merged with bridge method */
                                @Override // com.baidu.swan.apps.core.f.b
                                /* renamed from: f */
                                public void N(Boolean bool) {
                                    if (bool.booleanValue()) {
                                        c.this.anZ();
                                    }
                                }
                            });
                        } else if (com.baidu.swan.apps.p.c.avq().avr()) {
                            c.this.anZ();
                        } else {
                            com.baidu.swan.apps.p.b avl = new com.baidu.swan.apps.p.b().avl();
                            if (!avl.isShow()) {
                                c.this.anZ();
                                return;
                            }
                            com.baidu.swan.apps.p.c.avq().a(c.this.mActivity, avl.getImageUrl(), avl.avp(), c.this.anY());
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c.a anY() {
        return new c.a() { // from class: com.baidu.swan.apps.core.d.c.7
            @Override // com.baidu.swan.apps.p.c.a
            public void aoA() {
                c.this.anZ();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anZ() {
        if (this.mActivity != null) {
            com.baidu.swan.apps.v.g.azW().setForeground(false);
            this.mActivity.moveTaskToBack(true);
            aoa();
            ((SwanAppActivity) this.mActivity).fW(1);
            ap.aOh().kk(2);
        }
    }

    private void aoa() {
        HashMap hashMap = new HashMap();
        hashMap.put("lcType", "onClose");
        hashMap.put("appId", com.baidu.swan.apps.runtime.e.aIt());
        com.baidu.swan.apps.v.f.azN().b(new com.baidu.swan.apps.event.a.c(hashMap));
        com.baidu.swan.apps.console.c.i("SwanAppBaseFragment", "onClose");
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "close";
        a(fVar);
    }

    public boolean gE(int i) {
        return x(i, false);
    }

    public boolean x(int i, boolean z) {
        if (this.cPt == null || this.cPx == null) {
            return false;
        }
        this.cPC = i;
        this.cPt.setBackgroundColor(i);
        com.baidu.swan.apps.runtime.config.c aol = aol();
        if (aol != null) {
            aol.dDx = i;
            aol.hj(z);
        }
        if (aok()) {
            aom();
        }
        if (aoc()) {
            this.cPx.setVisibility(0);
        } else {
            this.cPx.setVisibility(8);
        }
        return true;
    }

    public boolean a(FrameLayout frameLayout, int i) {
        if (frameLayout == null) {
            return false;
        }
        frameLayout.setBackgroundColor(i);
        com.baidu.swan.apps.runtime.config.c aol = aol();
        if (aol != null) {
            aol.backgroundColor = i;
        }
        return true;
    }

    public SwanAppActionBar aob() {
        return this.cPt;
    }

    public boolean aoc() {
        return this.cPC == -1;
    }

    public void setRightExitViewVisibility(boolean z) {
        this.cPt.setRightExitViewVisibility(z);
    }

    public void setRightZoneVisibility(boolean z) {
        this.cPt.setRightZoneVisibility(z);
    }

    public void ff(boolean z) {
        this.cPF = z;
    }

    public void fg(boolean z) {
        FloatButton aJI = com.baidu.swan.apps.scheme.actions.d.a.aJG().aJI();
        if (!z) {
            if (aJI != null && aJI.getVisibility() == 0) {
                aJI.setVisibility(8);
            }
        } else if (aJI != null && aJI.getVisibility() != 0) {
            aJI.setVisibility(0);
        }
    }

    public void fh(boolean z) {
        c gI;
        f afz = com.baidu.swan.apps.v.f.azN().afz();
        if (afz != null) {
            if (z) {
                gI = afz.aoY();
            } else {
                gI = afz.gI(afz.apb() - 1);
            }
            if (gI != null) {
                fg(gI.aiT());
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
            aon();
        }
        aod();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (aok() && this.cPz != null && configuration.orientation == 1) {
            bdH().getWindow().clearFlags(1024);
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.d.c.8
                @Override // java.lang.Runnable
                public void run() {
                    c.this.aon();
                }
            }, 200L);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z) {
            aon();
        }
    }

    public void aod() {
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.core.d.c.9
            @Override // java.lang.Runnable
            public void run() {
                c.this.fi(com.baidu.swan.apps.ad.a.a.aEU());
            }
        }, "updateCtsView", 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fi(final boolean z) {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.d.c.10
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.mActivity != null && c.this.cPt != null) {
                    if (z) {
                        if (c.this.cPy == null) {
                            c.this.cPy = new TextView(c.this.mActivity);
                        }
                        if (!(c.this.cPy.getParent() instanceof SwanAppActionBar)) {
                            c.this.cPy.setText(a.h.aiapps_debug_open_cts);
                            c.this.cPy.setTextColor(c.this.aor().getColor(17170455));
                            c.this.cPt.addView(c.this.cPy);
                        }
                    } else if (c.this.cPy != null) {
                        c.this.cPt.removeView(c.this.cPy);
                        c.this.cPy = null;
                    }
                }
            }
        });
    }

    public void al(int i, String str) {
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
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.cPt, "alpha", 0.0f, 1.0f);
        ofFloat.setDuration(i);
        ofFloat.setInterpolator(accelerateDecelerateInterpolator);
        ofFloat.start();
        if (this.cPz != null && this.cPz.aOz() != null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.cPz.aOz(), "alpha", 0.0f, 1.0f);
            ofFloat2.setDuration(i);
            ofFloat2.setInterpolator(accelerateDecelerateInterpolator);
            ofFloat2.start();
        }
    }

    @Nullable
    public boolean md(String str) {
        return Q(str, false);
    }

    public boolean Q(String str, boolean z) {
        if (this.cPt == null) {
            return false;
        }
        this.cPt.setTitle(str);
        com.baidu.swan.apps.runtime.config.c aol = aol();
        if (aol != null) {
            aol.dDy = str;
            aol.hj(z);
        }
        com.baidu.swan.apps.console.c.i("SwanAppBaseFragment", "page title: " + str);
        return true;
    }

    protected void aoe() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aof() {
        if (this.mActivity != null) {
            this.mActivity.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void fj(boolean z) {
        this.cPt.setLeftBackViewVisibility(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aog() {
        this.cPt.setLeftHomeViewVisibility(0);
        this.cPt.setLeftHomeViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.c.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.aoe();
            }
        });
    }

    public boolean isSlidable(MotionEvent motionEvent) {
        return true;
    }

    public final f afz() {
        if (this.mActivity == null) {
            return null;
        }
        return ((SwanAppActivity) this.mActivity).afz();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean aoh() {
        f afz = afz();
        if (afz == null) {
            return false;
        }
        return afz.apb() > 1;
    }

    public void aoi() {
        f afz = afz();
        if (afz == null || afz.apb() == 1) {
            if (this.mActivity != null) {
                this.mActivity.moveTaskToBack(true);
                ap.aOh().kk(1);
                return;
            }
            return;
        }
        afz.mk("navigateBack").ai(0, 0).apf().commit();
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "back";
        a(fVar);
    }

    public void G(float f) {
        b(true, f);
    }

    public void aoj() {
        b(false, 1.0f);
    }

    private void b(boolean z, float f) {
        f afz = afz();
        if (afz != null && afz.apb() >= 2) {
            c gI = afz.gI(afz.apb() - 2);
            a(f, gI);
            if (z) {
                afz.apc().h(gI);
            } else {
                afz.apc().i(gI);
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

    public boolean gF(int i) {
        return f(i, "", false);
    }

    public boolean R(String str, boolean z) {
        return f(SwanAppConfigData.rt(str), str, z);
    }

    protected boolean f(@ColorInt int i, String str, boolean z) {
        if (this.cPt == null) {
            return false;
        }
        setRightExitViewVisibility(this.cPF ? false : true);
        com.baidu.swan.apps.runtime.config.c aol = aol();
        if (aol != null) {
            if (!TextUtils.isEmpty(str)) {
                aol.dDz = str;
            }
            aol.hj(z);
        }
        int i2 = i == -16777216 ? -16777216 : -1;
        if (aok() && i2 != this.cPB) {
            this.cPB = i2;
            aom();
        }
        return this.cPt.E(i, this.cPF);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aok() {
        return this.cPA;
    }

    protected com.baidu.swan.apps.runtime.config.c aol() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View az(View view) {
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
        this.cPz = new com.baidu.swan.apps.view.a.b(this.mActivity, frameLayout);
        aom();
        return frameLayout;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aom() {
        if (this.cPz != null) {
            gG(this.cPC);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void gG(@ColorInt int i) {
        if (this.cPz != null) {
            y(i, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void y(@ColorInt int i, boolean z) {
        boolean z2 = true;
        if (this.cPz != null) {
            this.cPC = i;
            if (this.cPB == 1) {
                z2 = com.baidu.swan.apps.ao.h.kg(i);
            } else if (this.cPB != -16777216) {
                z2 = false;
            }
            this.cPz.d(i, z, z2);
        }
    }

    public void aon() {
        if (aok() && this.cPz != null) {
            this.cPz.aon();
        }
    }

    @Nullable
    public com.baidu.swan.apps.view.a.b aoo() {
        return this.cPz;
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
        aop();
        aoq();
        return wrapSlideView;
    }

    private void aop() {
        if (aol() != null && aol().dDG) {
            com.baidu.swan.apps.runtime.e aIs = com.baidu.swan.apps.runtime.e.aIs();
            if (aIs != null) {
                aIs.aID().b(aIs.aIl(), "scope_disable_swipe_back", new com.baidu.swan.apps.ao.e.b<com.baidu.swan.apps.setting.oauth.h<b.d>>() { // from class: com.baidu.swan.apps.core.d.c.2
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
        return (aor().getConfiguration().orientation == 2 || Build.VERSION.SDK_INT == 26) ? false : true;
    }

    private void aoq() {
        this.mSlideHelper.setSlideListener(new SlidingPaneLayout.PanelSlideListener() { // from class: com.baidu.swan.apps.core.d.c.3
            @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
            public void onPanelSlide(View view, float f) {
                View maskView = c.this.mSlideHelper.getMaskView();
                if (maskView != null) {
                    maskView.setAlpha(1.0f - f);
                }
                c.this.G(f);
                if (c.this.cPE != null) {
                    c.this.cPE.ajy();
                }
            }

            @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
            public void onPanelOpened(View view) {
                c.this.aoi();
            }

            @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
            public void onPanelClosed(View view) {
                c.this.aoj();
            }
        });
    }

    public final Resources aor() {
        return isAdded() ? getResources() : AppRuntime.getAppContext().getResources();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean aos() {
        if ((this.mActivity instanceof SwanAppActivity) && ((SwanAppActivity) this.mActivity).afr() == 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int afr() {
        if (this.mActivity instanceof SwanAppActivity) {
            return ((SwanAppActivity) this.mActivity).afr();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void abandonAudioFocus() {
        if (this.mAudioManager != null && this.bub != null) {
            this.mAudioManager.abandonAudioFocus(this.bub);
        }
    }

    public boolean aot() {
        if (this.cPt == null) {
            return false;
        }
        this.cPt.hF(true);
        return true;
    }

    public boolean aou() {
        if (this.cPt == null) {
            return false;
        }
        this.cPt.hF(false);
        return true;
    }

    public void fk(boolean z) {
        if (this.cPt != null) {
            this.cPt.setActionBarCustom(z);
        }
        if (this.cPx != null) {
            int i = 8;
            if (!z && aoc()) {
                i = 0;
            }
            this.cPx.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int aov() {
        if (TextUtils.isEmpty(com.baidu.swan.apps.runtime.e.aIt())) {
            return 0;
        }
        if (com.baidu.swan.apps.database.favorite.a.mX(com.baidu.swan.apps.runtime.e.aIt())) {
            return 2;
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aow() {
        return "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u".equals(com.baidu.swan.apps.runtime.e.aIt());
    }

    public void aox() {
        com.baidu.swan.apps.scheme.actions.k.a.Z("backtohome", "menu", com.baidu.swan.apps.v.f.azN().azw());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "gohome";
        fVar.mSource = "menu";
        a(fVar);
    }

    public void anL() {
    }

    public com.baidu.swan.apps.model.c aoy() {
        return this.cPr;
    }

    /* loaded from: classes8.dex */
    private class a {
        private int cPK = 0;
        private long cPL = 0;
        private Runnable cPM;

        a(Runnable runnable) {
            this.cPM = runnable;
        }

        void onClick() {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.cPL > 1333) {
                this.cPL = currentTimeMillis;
                this.cPK = 1;
                return;
            }
            this.cPK++;
            if (this.cPK == 3) {
                if (this.cPM != null) {
                    this.cPM.run();
                }
                this.cPK = 0;
                this.cPL = 0L;
                return;
            }
            this.cPL = currentTimeMillis;
        }
    }

    public void a(b bVar) {
        this.cPE = bVar;
    }

    public View aoz() {
        return this.cPs;
    }
}
