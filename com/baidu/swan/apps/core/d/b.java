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
import com.baidu.searchbox.widget.SlideHelper;
import com.baidu.searchbox.widget.SlideInterceptor;
import com.baidu.searchbox.widget.SlidingPaneLayout;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment;
import com.baidu.swan.apps.aq.ag;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.aq.an;
import com.baidu.swan.apps.o.c;
import com.baidu.swan.apps.res.ui.FloatButton;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.setting.oauth.a.b;
import com.baidu.swan.apps.view.SwanAppActionBar;
import com.baidu.swan.support.v4.app.Fragment;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import java.lang.reflect.Field;
import java.util.HashMap;
/* loaded from: classes11.dex */
public abstract class b extends Fragment implements SlideInterceptor {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    protected com.baidu.swan.apps.model.c bZM;
    protected View bZN;
    protected SwanAppActionBar bZO;
    protected com.baidu.swan.menu.h bZP;
    protected String bZQ;
    protected View bZR;
    protected TextView bZS;
    @Nullable
    protected com.baidu.swan.apps.view.a.b bZT;
    private a bZV;
    private InterfaceC0342b bZW;
    private AudioManager.OnAudioFocusChangeListener bbv;
    protected Activity mActivity;
    private AudioManager mAudioManager;
    protected SlideHelper mSlideHelper;
    private boolean mImmersionEnabled = com.baidu.swan.apps.view.a.b.SUPPORT_IMMERSION;
    private int bZU = 1;
    private int mStatusBarColor = 1;
    private boolean bZX = false;

    /* renamed from: com.baidu.swan.apps.core.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0342b {
        void Vh();
    }

    protected abstract boolean UE();

    protected abstract void UI();

    public abstract boolean Ui();

    protected abstract void YV();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean YW();

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onAttach(Context context) {
        if (DEBUG) {
            Log.d("SwanAppBaseFragment", "onAttach");
        }
        super.onAttach(context);
        this.mActivity = aIB();
        dG(true);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDetach() {
        if (DEBUG) {
            Log.d("SwanAppBaseFragment", "onDetach");
        }
        this.mActivity = null;
        dG(false);
        super.onDetach();
        try {
            Field declaredField = Fragment.class.getDeclaredField("dsC");
            declaredField.setAccessible(true);
            declaredField.set(this, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ae(View view) {
        com.baidu.swan.apps.runtime.config.c ly;
        ah(view);
        SwanAppConfigData aiG = com.baidu.swan.apps.w.f.ajb().aiG();
        if (aiG == null) {
            if (DEBUG) {
                Log.d("SwanAppBaseFragment", "config data is null. " + Log.getStackTraceString(new Exception()));
                return;
            }
            return;
        }
        if (this.bZM == null) {
            ly = aiG.cFf;
        } else {
            ly = com.baidu.swan.apps.w.f.ajb().ly(this.bZM.getPage());
        }
        eU(ly.cFM);
        this.bZO.setTitle(ly.cFN);
        this.bZV = new a(new Runnable() { // from class: com.baidu.swan.apps.core.d.b.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.aa.f.alk();
            }
        });
        this.bZO.findViewById(a.f.titlebar_center_zone);
        if (!(this instanceof SwanAppAdLandingFragment)) {
            eV(SwanAppConfigData.dV(ly.cFO));
        }
        this.bZQ = ly.cFO;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ah(View view) {
        if (view != null) {
            this.bZO = (SwanAppActionBar) view.findViewById(a.f.ai_apps_title_bar);
            this.bZN = view.findViewById(a.f.ai_apps_title_bar_root);
            this.bZR = view.findViewById(a.f.title_shadow);
            this.bZO.setLeftBackViewMinWidth(ag.dip2px(this.mActivity, 38.0f));
            this.bZO.setLeftBackViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (com.baidu.swan.apps.o.a.afb().afc()) {
                        com.baidu.swan.apps.o.a.afb().a(b.this.mActivity, new com.baidu.swan.apps.core.f.b<Boolean>() { // from class: com.baidu.swan.apps.core.d.b.3.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.swan.apps.core.f.b
                            /* renamed from: d */
                            public void K(Boolean bool) {
                                if (bool.booleanValue()) {
                                    b.this.Zk();
                                }
                            }
                        });
                    } else {
                        b.this.Zk();
                    }
                }
            });
            this.bZO.setRightMenuOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    b.this.YV();
                    com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                    fVar.mValue = "menu";
                    if (com.baidu.swan.apps.runtime.e.apN() != null && com.baidu.swan.apps.runtime.e.apN().aqe().b("key_unread_counts_message", (Integer) 0).intValue() > 0) {
                        fVar.mPage = String.valueOf(1);
                    }
                    b.this.a(fVar);
                    if (b.this.bZV != null) {
                        b.this.bZV.onClick();
                    }
                }
            });
            this.bZO.setRightExitOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.b.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.mActivity != null && (b.this.mActivity instanceof SwanAppActivity)) {
                        if (com.baidu.swan.apps.runtime.e.apM() == null || com.baidu.swan.apps.runtime.e.apO() == null) {
                            b.this.Ze();
                        } else if (com.baidu.swan.apps.o.a.afb().afc()) {
                            com.baidu.swan.apps.o.a.afb().a(b.this.mActivity, new com.baidu.swan.apps.core.f.b<Boolean>() { // from class: com.baidu.swan.apps.core.d.b.5.1
                                /* JADX DEBUG: Method merged with bridge method */
                                @Override // com.baidu.swan.apps.core.f.b
                                /* renamed from: d */
                                public void K(Boolean bool) {
                                    if (bool.booleanValue()) {
                                        b.this.Ze();
                                    }
                                }
                            });
                        } else if (com.baidu.swan.apps.o.c.afi().afj()) {
                            b.this.Ze();
                        } else {
                            com.baidu.swan.apps.o.b afd = new com.baidu.swan.apps.o.b().afd();
                            if (!afd.isShow()) {
                                b.this.Ze();
                                return;
                            }
                            com.baidu.swan.apps.o.c.afi().a(b.this.mActivity, afd.getImageUrl(), afd.afh(), b.this.Zd());
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c.a Zd() {
        return new c.a() { // from class: com.baidu.swan.apps.core.d.b.6
            @Override // com.baidu.swan.apps.o.c.a
            public void ZB() {
                b.this.Ze();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ze() {
        if (this.mActivity != null) {
            com.baidu.swan.apps.w.g.ajk().ei(false);
            this.mActivity.moveTaskToBack(true);
            Zf();
            ((SwanAppActivity) this.mActivity).ep(1);
            an.ave().hV(2);
        }
    }

    private void Zf() {
        HashMap hashMap = new HashMap();
        hashMap.put("lcType", "onClose");
        hashMap.put("appId", com.baidu.swan.apps.runtime.e.apO());
        com.baidu.swan.apps.w.f.ajb().a(new com.baidu.swan.apps.event.a.c(hashMap));
        com.baidu.swan.apps.console.c.d("SwanAppBaseFragment", "onClose");
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "close";
        a(fVar);
    }

    public boolean eU(int i) {
        return u(i, false);
    }

    public boolean u(int i, boolean z) {
        if (this.bZO == null || this.bZR == null) {
            return false;
        }
        this.mStatusBarColor = i;
        this.bZO.setBackgroundColor(i);
        com.baidu.swan.apps.runtime.config.c Zn = Zn();
        if (Zn != null) {
            Zn.cFM = i;
            Zn.fk(z);
        }
        if (immersionEnabled()) {
            applyImmersion();
        }
        if (Zh()) {
            this.bZR.setVisibility(0);
        } else {
            this.bZR.setVisibility(8);
        }
        return true;
    }

    public boolean a(FrameLayout frameLayout, int i) {
        if (frameLayout == null) {
            return false;
        }
        frameLayout.setBackgroundColor(i);
        com.baidu.swan.apps.runtime.config.c Zn = Zn();
        if (Zn != null) {
            Zn.backgroundColor = i;
        }
        return true;
    }

    public SwanAppActionBar Zg() {
        return this.bZO;
    }

    public boolean Zh() {
        return this.mStatusBarColor == -1;
    }

    public void setRightExitViewVisibility(boolean z) {
        this.bZO.setRightExitViewVisibility(z);
    }

    public void setRightZoneVisibility(boolean z) {
        this.bZO.setRightZoneVisibility(z);
    }

    public void dE(boolean z) {
        this.bZX = z;
    }

    public void dF(boolean z) {
        FloatButton aqZ = com.baidu.swan.apps.scheme.actions.d.a.aqX().aqZ();
        if (!z) {
            if (aqZ != null && aqZ.getVisibility() == 0) {
                aqZ.setVisibility(8);
            }
        } else if (aqZ != null && aqZ.getVisibility() != 0) {
            aqZ.setVisibility(0);
        }
    }

    public void dG(boolean z) {
        b eX;
        e RN = com.baidu.swan.apps.w.f.ajb().RN();
        if (RN != null) {
            if (z) {
                eX = RN.ZV();
            } else {
                eX = RN.eX(RN.ZY() - 1);
            }
            if (eX != null) {
                dF(eX.UE());
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
        Zi();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (immersionEnabled() && this.bZT != null && configuration.orientation == 1) {
            aIB().getWindow().clearFlags(1024);
            aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.d.b.7
                @Override // java.lang.Runnable
                public void run() {
                    b.this.resetWithCurImmersion();
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

    public void Zi() {
        if (this.mActivity != null && this.bZO != null) {
            aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.d.b.8
                @Override // java.lang.Runnable
                public void run() {
                    if (com.baidu.swan.apps.af.a.a.anA()) {
                        if (b.this.bZS == null) {
                            b.this.bZS = new TextView(b.this.mActivity);
                        }
                        if (!(b.this.bZS.getParent() instanceof SwanAppActionBar)) {
                            b.this.bZS.setText(a.h.aiapps_debug_open_cts);
                            b.this.bZS.setTextColor(b.this.Zr().getColor(17170455));
                            b.this.bZO.addView(b.this.bZS);
                        }
                    } else if (b.this.bZS != null) {
                        b.this.bZO.removeView(b.this.bZS);
                        b.this.bZS = null;
                    }
                }
            });
        }
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
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.bZO, "alpha", 0.0f, 1.0f);
        ofFloat.setDuration(i);
        ofFloat.setInterpolator(accelerateDecelerateInterpolator);
        ofFloat.start();
        if (this.bZT != null && this.bZT.avs() != null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.bZT.avs(), "alpha", 0.0f, 1.0f);
            ofFloat2.setDuration(i);
            ofFloat2.setInterpolator(accelerateDecelerateInterpolator);
            ofFloat2.start();
        }
    }

    @Nullable
    public boolean jq(String str) {
        return F(str, false);
    }

    public boolean F(String str, boolean z) {
        if (this.bZO == null) {
            return false;
        }
        this.bZO.setTitle(str);
        com.baidu.swan.apps.runtime.config.c Zn = Zn();
        if (Zn != null) {
            Zn.cFN = str;
            Zn.fk(z);
        }
        return true;
    }

    protected void Zj() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Zk() {
        if (this.mActivity != null) {
            this.mActivity.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dH(boolean z) {
        this.bZO.setLeftBackViewVisibility(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Zl() {
        this.bZO.setLeftHomeViewVisibility(0);
        this.bZO.setLeftHomeViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.b.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.Zj();
            }
        });
    }

    @Override // com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        return true;
    }

    public final e RN() {
        if (this.mActivity == null) {
            return null;
        }
        return ((SwanAppActivity) this.mActivity).RN();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean Zm() {
        e RN = RN();
        if (RN == null) {
            return false;
        }
        return RN.ZY() > 1;
    }

    public void finishAfterSlide() {
        e RN = RN();
        if (RN == null || RN.ZY() == 1) {
            if (this.mActivity != null) {
                this.mActivity.moveTaskToBack(true);
                an.ave().hV(1);
                return;
            }
            return;
        }
        RN.jx("navigateBack").ag(0, 0).aad().commit();
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
        e RN = RN();
        if (RN != null && RN.ZY() >= 2) {
            b eX = RN.eX(RN.ZY() - 2);
            a(f, eX);
            if (z) {
                RN.ZZ().h(eX);
            } else {
                RN.ZZ().i(eX);
            }
        }
    }

    private void a(float f, Fragment fragment) {
        View view;
        float displayWidth = ag.getDisplayWidth(this.mActivity) >> 2;
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

    public boolean eV(int i) {
        return d(i, "", false);
    }

    public boolean G(String str, boolean z) {
        return d(SwanAppConfigData.dV(str), str, z);
    }

    protected boolean d(@ColorInt int i, String str, boolean z) {
        if (this.bZO == null) {
            return false;
        }
        setRightExitViewVisibility(this.bZX ? false : true);
        com.baidu.swan.apps.runtime.config.c Zn = Zn();
        if (Zn != null) {
            if (!TextUtils.isEmpty(str)) {
                Zn.cFO = str;
            }
            Zn.fk(z);
        }
        int i2 = i == -16777216 ? -16777216 : -1;
        if (immersionEnabled() && i2 != this.bZU) {
            this.bZU = i2;
            applyImmersion();
        }
        return this.bZO.B(i, this.bZX);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean immersionEnabled() {
        return this.mImmersionEnabled;
    }

    protected com.baidu.swan.apps.runtime.config.c Zn() {
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
        this.bZT = new com.baidu.swan.apps.view.a.b(this.mActivity, frameLayout);
        applyImmersion();
        return frameLayout;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void applyImmersion() {
        if (this.bZT != null) {
            applyImmersion(this.mStatusBarColor);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void applyImmersion(@ColorInt int i) {
        if (this.bZT != null) {
            v(i, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void v(@ColorInt int i, boolean z) {
        boolean z2 = true;
        if (this.bZT != null) {
            this.mStatusBarColor = i;
            if (this.bZU == 1) {
                z2 = com.baidu.swan.apps.aq.g.hT(i);
            } else if (this.bZU != -16777216) {
                z2 = false;
            }
            this.bZT.c(i, z, z2);
        }
    }

    public void resetWithCurImmersion() {
        if (immersionEnabled() && this.bZT != null) {
            this.bZT.resetWithCurImmersion();
        }
    }

    @Nullable
    public com.baidu.swan.apps.view.a.b Zo() {
        return this.bZT;
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
        Zp();
        Zq();
        return wrapSlideView;
    }

    private void Zp() {
        if (Zn() != null && Zn().cFV) {
            com.baidu.swan.apps.runtime.e apN = com.baidu.swan.apps.runtime.e.apN();
            if (apN != null) {
                apN.apY().b(apN.apG(), "scope_disable_swipe_back", new com.baidu.swan.apps.aq.e.b<com.baidu.swan.apps.setting.oauth.h<b.d>>() { // from class: com.baidu.swan.apps.core.d.b.10
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.aq.e.b
                    /* renamed from: a */
                    public void H(com.baidu.swan.apps.setting.oauth.h<b.d> hVar) {
                        if (!com.baidu.swan.apps.setting.oauth.c.b(hVar)) {
                            b.this.mSlideHelper.setCanSlide(b.this.canSlide());
                        } else {
                            b.this.mSlideHelper.setCanSlide(false);
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
        return (Zr().getConfiguration().orientation == 2 || Build.VERSION.SDK_INT == 26) ? false : true;
    }

    private void Zq() {
        this.mSlideHelper.setSlideListener(new SlidingPaneLayout.PanelSlideListener() { // from class: com.baidu.swan.apps.core.d.b.2
            @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
            public void onPanelSlide(View view, float f) {
                View maskView = b.this.mSlideHelper.getMaskView();
                if (maskView != null) {
                    maskView.setAlpha(1.0f - f);
                }
                b.this.onPanelSlide(f);
                if (b.this.bZW != null) {
                    b.this.bZW.Vh();
                }
            }

            @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
            public void onPanelOpened(View view) {
                b.this.finishAfterSlide();
            }

            @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
            public void onPanelClosed(View view) {
                b.this.onPanelClosed();
            }
        });
    }

    public final Resources Zr() {
        return isAdded() ? getResources() : AppRuntime.getAppContext().getResources();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean Zs() {
        if ((this.mActivity instanceof SwanAppActivity) && ((SwanAppActivity) this.mActivity).RF() == 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int RF() {
        if (this.mActivity instanceof SwanAppActivity) {
            return ((SwanAppActivity) this.mActivity).RF();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void GA() {
        if (this.mAudioManager != null && this.bbv != null) {
            this.mAudioManager.abandonAudioFocus(this.bbv);
        }
    }

    public boolean Zt() {
        if (this.bZO == null) {
            return false;
        }
        this.bZO.fG(true);
        return true;
    }

    public boolean Zu() {
        if (this.bZO == null) {
            return false;
        }
        this.bZO.fG(false);
        return true;
    }

    public void dI(boolean z) {
        if (this.bZO != null) {
            this.bZO.setActionBarCustom(z);
        }
        if (this.bZR != null) {
            int i = 8;
            if (!z && Zh()) {
                i = 0;
            }
            this.bZR.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int Zv() {
        if (TextUtils.isEmpty(com.baidu.swan.apps.runtime.e.apO())) {
            return 0;
        }
        if (com.baidu.swan.apps.database.favorite.a.ke(com.baidu.swan.apps.runtime.e.apO())) {
            return 2;
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Zw() {
        return "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u".equals(com.baidu.swan.apps.runtime.e.apO());
    }

    public void Zx() {
        com.baidu.swan.apps.scheme.actions.k.a.J("backtohome", "menu", com.baidu.swan.apps.w.f.ajb().aiK());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "gohome";
        fVar.mSource = "menu";
        a(fVar);
    }

    public void Zy() {
    }

    public com.baidu.swan.apps.model.c Zz() {
        return this.bZM;
    }

    /* loaded from: classes11.dex */
    private class a {
        private int cab = 0;
        private long cac = 0;
        private Runnable cad;

        a(Runnable runnable) {
            this.cad = runnable;
        }

        void onClick() {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.cac > 1333) {
                this.cac = currentTimeMillis;
                this.cab = 1;
                return;
            }
            this.cab++;
            if (this.cab == 3) {
                if (this.cad != null) {
                    this.cad.run();
                }
                this.cab = 0;
                this.cac = 0L;
                return;
            }
            this.cac = currentTimeMillis;
        }
    }

    public void a(InterfaceC0342b interfaceC0342b) {
        this.bZW = interfaceC0342b;
    }

    public View ZA() {
        return this.bZN;
    }
}
