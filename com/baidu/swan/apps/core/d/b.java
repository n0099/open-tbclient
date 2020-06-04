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
    private AudioManager.OnAudioFocusChangeListener aYC;
    protected com.baidu.swan.apps.model.c bUY;
    protected View bUZ;
    protected SwanAppActionBar bVa;
    protected com.baidu.swan.menu.h bVb;
    protected String bVc;
    protected View bVd;
    protected TextView bVe;
    @Nullable
    protected com.baidu.swan.apps.view.a.b bVf;
    private a bVh;
    private InterfaceC0336b bVi;
    protected Activity mActivity;
    private AudioManager mAudioManager;
    protected SlideHelper mSlideHelper;
    private boolean mImmersionEnabled = com.baidu.swan.apps.view.a.b.SUPPORT_IMMERSION;
    private int bVg = 1;
    private int mStatusBarColor = 1;
    private boolean bVj = false;

    /* renamed from: com.baidu.swan.apps.core.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0336b {
        void Ub();
    }

    protected abstract void TC();

    public abstract boolean Tc();

    protected abstract boolean Ty();

    protected abstract void XP();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean XQ();

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onAttach(Context context) {
        if (DEBUG) {
            Log.d("SwanAppBaseFragment", "onAttach");
        }
        super.onAttach(context);
        this.mActivity = aHv();
        dB(true);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDetach() {
        if (DEBUG) {
            Log.d("SwanAppBaseFragment", "onDetach");
        }
        this.mActivity = null;
        dB(false);
        super.onDetach();
        try {
            Field declaredField = Fragment.class.getDeclaredField("dnQ");
            declaredField.setAccessible(true);
            declaredField.set(this, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ae(View view) {
        com.baidu.swan.apps.runtime.config.c lq;
        ah(view);
        SwanAppConfigData ahA = com.baidu.swan.apps.w.f.ahV().ahA();
        if (ahA == null) {
            if (DEBUG) {
                Log.d("SwanAppBaseFragment", "config data is null. " + Log.getStackTraceString(new Exception()));
                return;
            }
            return;
        }
        if (this.bUY == null) {
            lq = ahA.cAv;
        } else {
            lq = com.baidu.swan.apps.w.f.ahV().lq(this.bUY.getPage());
        }
        eJ(lq.cBc);
        this.bVa.setTitle(lq.cBd);
        this.bVh = new a(new Runnable() { // from class: com.baidu.swan.apps.core.d.b.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.aa.f.ake();
            }
        });
        this.bVa.findViewById(a.f.titlebar_center_zone);
        if (!(this instanceof SwanAppAdLandingFragment)) {
            eK(SwanAppConfigData.dT(lq.cBe));
        }
        this.bVc = lq.cBe;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ah(View view) {
        if (view != null) {
            this.bVa = (SwanAppActionBar) view.findViewById(a.f.ai_apps_title_bar);
            this.bUZ = view.findViewById(a.f.ai_apps_title_bar_root);
            this.bVd = view.findViewById(a.f.title_shadow);
            this.bVa.setLeftBackViewMinWidth(ag.dip2px(this.mActivity, 38.0f));
            this.bVa.setLeftBackViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (com.baidu.swan.apps.o.a.adV().adW()) {
                        com.baidu.swan.apps.o.a.adV().a(b.this.mActivity, new com.baidu.swan.apps.core.f.b<Boolean>() { // from class: com.baidu.swan.apps.core.d.b.3.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.swan.apps.core.f.b
                            /* renamed from: d */
                            public void K(Boolean bool) {
                                if (bool.booleanValue()) {
                                    b.this.Ye();
                                }
                            }
                        });
                    } else {
                        b.this.Ye();
                    }
                }
            });
            this.bVa.setRightMenuOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    b.this.XP();
                    com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                    fVar.mValue = "menu";
                    if (com.baidu.swan.apps.runtime.e.aoG() != null && com.baidu.swan.apps.runtime.e.aoG().aoX().b("key_unread_counts_message", (Integer) 0).intValue() > 0) {
                        fVar.mPage = String.valueOf(1);
                    }
                    b.this.a(fVar);
                    if (b.this.bVh != null) {
                        b.this.bVh.onClick();
                    }
                }
            });
            this.bVa.setRightExitOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.b.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.mActivity != null && (b.this.mActivity instanceof SwanAppActivity)) {
                        if (com.baidu.swan.apps.runtime.e.aoF() == null || com.baidu.swan.apps.runtime.e.aoH() == null) {
                            b.this.XY();
                        } else if (com.baidu.swan.apps.o.a.adV().adW()) {
                            com.baidu.swan.apps.o.a.adV().a(b.this.mActivity, new com.baidu.swan.apps.core.f.b<Boolean>() { // from class: com.baidu.swan.apps.core.d.b.5.1
                                /* JADX DEBUG: Method merged with bridge method */
                                @Override // com.baidu.swan.apps.core.f.b
                                /* renamed from: d */
                                public void K(Boolean bool) {
                                    if (bool.booleanValue()) {
                                        b.this.XY();
                                    }
                                }
                            });
                        } else if (com.baidu.swan.apps.o.c.aec().aed()) {
                            b.this.XY();
                        } else {
                            com.baidu.swan.apps.o.b adX = new com.baidu.swan.apps.o.b().adX();
                            if (!adX.isShow()) {
                                b.this.XY();
                                return;
                            }
                            com.baidu.swan.apps.o.c.aec().a(b.this.mActivity, adX.getImageUrl(), adX.aeb(), b.this.XX());
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c.a XX() {
        return new c.a() { // from class: com.baidu.swan.apps.core.d.b.6
            @Override // com.baidu.swan.apps.o.c.a
            public void Yv() {
                b.this.XY();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XY() {
        if (this.mActivity != null) {
            com.baidu.swan.apps.w.g.aie().ed(false);
            this.mActivity.moveTaskToBack(true);
            XZ();
            ((SwanAppActivity) this.mActivity).ee(1);
            an.atY().hK(2);
        }
    }

    private void XZ() {
        HashMap hashMap = new HashMap();
        hashMap.put("lcType", "onClose");
        hashMap.put("appId", com.baidu.swan.apps.runtime.e.aoH());
        com.baidu.swan.apps.w.f.ahV().a(new com.baidu.swan.apps.event.a.c(hashMap));
        com.baidu.swan.apps.console.c.d("SwanAppBaseFragment", "onClose");
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "close";
        a(fVar);
    }

    public boolean eJ(int i) {
        return t(i, false);
    }

    public boolean t(int i, boolean z) {
        if (this.bVa == null || this.bVd == null) {
            return false;
        }
        this.mStatusBarColor = i;
        this.bVa.setBackgroundColor(i);
        com.baidu.swan.apps.runtime.config.c Yh = Yh();
        if (Yh != null) {
            Yh.cBc = i;
            Yh.ff(z);
        }
        if (immersionEnabled()) {
            applyImmersion();
        }
        if (Yb()) {
            this.bVd.setVisibility(0);
        } else {
            this.bVd.setVisibility(8);
        }
        return true;
    }

    public boolean a(FrameLayout frameLayout, int i) {
        if (frameLayout == null) {
            return false;
        }
        frameLayout.setBackgroundColor(i);
        com.baidu.swan.apps.runtime.config.c Yh = Yh();
        if (Yh != null) {
            Yh.backgroundColor = i;
        }
        return true;
    }

    public SwanAppActionBar Ya() {
        return this.bVa;
    }

    public boolean Yb() {
        return this.mStatusBarColor == -1;
    }

    public void setRightExitViewVisibility(boolean z) {
        this.bVa.setRightExitViewVisibility(z);
    }

    public void setRightZoneVisibility(boolean z) {
        this.bVa.setRightZoneVisibility(z);
    }

    public void dz(boolean z) {
        this.bVj = z;
    }

    public void dA(boolean z) {
        FloatButton apT = com.baidu.swan.apps.scheme.actions.d.a.apR().apT();
        if (!z) {
            if (apT != null && apT.getVisibility() == 0) {
                apT.setVisibility(8);
            }
        } else if (apT != null && apT.getVisibility() != 0) {
            apT.setVisibility(0);
        }
    }

    public void dB(boolean z) {
        b eM;
        e QH = com.baidu.swan.apps.w.f.ahV().QH();
        if (QH != null) {
            if (z) {
                eM = QH.YP();
            } else {
                eM = QH.eM(QH.YS() - 1);
            }
            if (eM != null) {
                dA(eM.Ty());
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
        Yc();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (immersionEnabled() && this.bVf != null && configuration.orientation == 1) {
            aHv().getWindow().clearFlags(1024);
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

    public void Yc() {
        if (this.mActivity != null && this.bVa != null) {
            aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.d.b.8
                @Override // java.lang.Runnable
                public void run() {
                    if (com.baidu.swan.apps.af.a.a.amu()) {
                        if (b.this.bVe == null) {
                            b.this.bVe = new TextView(b.this.mActivity);
                        }
                        if (!(b.this.bVe.getParent() instanceof SwanAppActionBar)) {
                            b.this.bVe.setText(a.h.aiapps_debug_open_cts);
                            b.this.bVe.setTextColor(b.this.Yl().getColor(17170455));
                            b.this.bVa.addView(b.this.bVe);
                        }
                    } else if (b.this.bVe != null) {
                        b.this.bVa.removeView(b.this.bVe);
                        b.this.bVe = null;
                    }
                }
            });
        }
    }

    public void P(int i, String str) {
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
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.bVa, "alpha", 0.0f, 1.0f);
        ofFloat.setDuration(i);
        ofFloat.setInterpolator(accelerateDecelerateInterpolator);
        ofFloat.start();
        if (this.bVf != null && this.bVf.aum() != null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.bVf.aum(), "alpha", 0.0f, 1.0f);
            ofFloat2.setDuration(i);
            ofFloat2.setInterpolator(accelerateDecelerateInterpolator);
            ofFloat2.start();
        }
    }

    @Nullable
    public boolean ji(String str) {
        return D(str, false);
    }

    public boolean D(String str, boolean z) {
        if (this.bVa == null) {
            return false;
        }
        this.bVa.setTitle(str);
        com.baidu.swan.apps.runtime.config.c Yh = Yh();
        if (Yh != null) {
            Yh.cBd = str;
            Yh.ff(z);
        }
        return true;
    }

    protected void Yd() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ye() {
        if (this.mActivity != null) {
            this.mActivity.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dC(boolean z) {
        this.bVa.setLeftBackViewVisibility(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Yf() {
        this.bVa.setLeftHomeViewVisibility(0);
        this.bVa.setLeftHomeViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.b.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.Yd();
            }
        });
    }

    @Override // com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        return true;
    }

    public final e QH() {
        if (this.mActivity == null) {
            return null;
        }
        return ((SwanAppActivity) this.mActivity).QH();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean Yg() {
        e QH = QH();
        if (QH == null) {
            return false;
        }
        return QH.YS() > 1;
    }

    public void finishAfterSlide() {
        e QH = QH();
        if (QH == null || QH.YS() == 1) {
            if (this.mActivity != null) {
                this.mActivity.moveTaskToBack(true);
                an.atY().hK(1);
                return;
            }
            return;
        }
        QH.jp("navigateBack").ae(0, 0).YX().commit();
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
        e QH = QH();
        if (QH != null && QH.YS() >= 2) {
            b eM = QH.eM(QH.YS() - 2);
            a(f, eM);
            if (z) {
                QH.YT().h(eM);
            } else {
                QH.YT().i(eM);
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

    public boolean eK(int i) {
        return d(i, "", false);
    }

    public boolean E(String str, boolean z) {
        return d(SwanAppConfigData.dT(str), str, z);
    }

    protected boolean d(@ColorInt int i, String str, boolean z) {
        if (this.bVa == null) {
            return false;
        }
        setRightExitViewVisibility(this.bVj ? false : true);
        com.baidu.swan.apps.runtime.config.c Yh = Yh();
        if (Yh != null) {
            if (!TextUtils.isEmpty(str)) {
                Yh.cBe = str;
            }
            Yh.ff(z);
        }
        int i2 = i == -16777216 ? -16777216 : -1;
        if (immersionEnabled() && i2 != this.bVg) {
            this.bVg = i2;
            applyImmersion();
        }
        return this.bVa.A(i, this.bVj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean immersionEnabled() {
        return this.mImmersionEnabled;
    }

    protected com.baidu.swan.apps.runtime.config.c Yh() {
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
        this.bVf = new com.baidu.swan.apps.view.a.b(this.mActivity, frameLayout);
        applyImmersion();
        return frameLayout;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void applyImmersion() {
        if (this.bVf != null) {
            applyImmersion(this.mStatusBarColor);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void applyImmersion(@ColorInt int i) {
        if (this.bVf != null) {
            u(i, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void u(@ColorInt int i, boolean z) {
        boolean z2 = true;
        if (this.bVf != null) {
            this.mStatusBarColor = i;
            if (this.bVg == 1) {
                z2 = com.baidu.swan.apps.aq.g.hI(i);
            } else if (this.bVg != -16777216) {
                z2 = false;
            }
            this.bVf.c(i, z, z2);
        }
    }

    public void resetWithCurImmersion() {
        if (immersionEnabled() && this.bVf != null) {
            this.bVf.resetWithCurImmersion();
        }
    }

    @Nullable
    public com.baidu.swan.apps.view.a.b Yi() {
        return this.bVf;
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
        Yj();
        Yk();
        return wrapSlideView;
    }

    private void Yj() {
        if (Yh() != null && Yh().cBl) {
            com.baidu.swan.apps.runtime.e aoG = com.baidu.swan.apps.runtime.e.aoG();
            if (aoG != null) {
                aoG.aoR().b(aoG.aoz(), "scope_disable_swipe_back", new com.baidu.swan.apps.aq.e.b<com.baidu.swan.apps.setting.oauth.h<b.d>>() { // from class: com.baidu.swan.apps.core.d.b.10
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
        return (Yl().getConfiguration().orientation == 2 || Build.VERSION.SDK_INT == 26) ? false : true;
    }

    private void Yk() {
        this.mSlideHelper.setSlideListener(new SlidingPaneLayout.PanelSlideListener() { // from class: com.baidu.swan.apps.core.d.b.2
            @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
            public void onPanelSlide(View view, float f) {
                View maskView = b.this.mSlideHelper.getMaskView();
                if (maskView != null) {
                    maskView.setAlpha(1.0f - f);
                }
                b.this.onPanelSlide(f);
                if (b.this.bVi != null) {
                    b.this.bVi.Ub();
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

    public final Resources Yl() {
        return isAdded() ? getResources() : AppRuntime.getAppContext().getResources();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean Ym() {
        if ((this.mActivity instanceof SwanAppActivity) && ((SwanAppActivity) this.mActivity).Qz() == 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int Qz() {
        if (this.mActivity instanceof SwanAppActivity) {
            return ((SwanAppActivity) this.mActivity).Qz();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void FR() {
        if (this.mAudioManager != null && this.aYC != null) {
            this.mAudioManager.abandonAudioFocus(this.aYC);
        }
    }

    public boolean Yn() {
        if (this.bVa == null) {
            return false;
        }
        this.bVa.fB(true);
        return true;
    }

    public boolean Yo() {
        if (this.bVa == null) {
            return false;
        }
        this.bVa.fB(false);
        return true;
    }

    public void dD(boolean z) {
        if (this.bVa != null) {
            this.bVa.setActionBarCustom(z);
        }
        if (this.bVd != null) {
            int i = 8;
            if (!z && Yb()) {
                i = 0;
            }
            this.bVd.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int Yp() {
        if (TextUtils.isEmpty(com.baidu.swan.apps.runtime.e.aoH())) {
            return 0;
        }
        if (com.baidu.swan.apps.database.favorite.a.jW(com.baidu.swan.apps.runtime.e.aoH())) {
            return 2;
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Yq() {
        return "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u".equals(com.baidu.swan.apps.runtime.e.aoH());
    }

    public void Yr() {
        com.baidu.swan.apps.scheme.actions.k.a.I("backtohome", "menu", com.baidu.swan.apps.w.f.ahV().ahE());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "gohome";
        fVar.mSource = "menu";
        a(fVar);
    }

    public void Ys() {
    }

    public com.baidu.swan.apps.model.c Yt() {
        return this.bUY;
    }

    /* loaded from: classes11.dex */
    private class a {
        private int bVn = 0;
        private long bVo = 0;
        private Runnable bVp;

        a(Runnable runnable) {
            this.bVp = runnable;
        }

        void onClick() {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.bVo > 1333) {
                this.bVo = currentTimeMillis;
                this.bVn = 1;
                return;
            }
            this.bVn++;
            if (this.bVn == 3) {
                if (this.bVp != null) {
                    this.bVp.run();
                }
                this.bVn = 0;
                this.bVo = 0L;
                return;
            }
            this.bVo = currentTimeMillis;
        }
    }

    public void a(InterfaceC0336b interfaceC0336b) {
        this.bVi = interfaceC0336b;
    }

    public View Yu() {
        return this.bUZ;
    }
}
