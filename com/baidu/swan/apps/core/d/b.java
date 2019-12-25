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
import com.baidu.swan.apps.as.af;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.q.c;
import com.baidu.swan.apps.res.ui.FloatButton;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.view.SwanAppActionBar;
import com.baidu.swan.support.v4.app.Fragment;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import java.lang.reflect.Field;
import java.util.HashMap;
/* loaded from: classes9.dex */
public abstract class b extends Fragment implements SlideInterceptor {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    protected TextView biA;
    @Nullable
    protected com.baidu.swan.apps.view.a.b biB;
    private AudioManager.OnAudioFocusChangeListener biC;
    private a biD;
    protected com.baidu.swan.apps.model.c biu;
    protected View biv;
    protected SwanAppActionBar biw;
    protected com.baidu.swan.menu.h bix;
    protected String biy;
    protected View biz;
    protected Activity mActivity;
    private AudioManager mAudioManager;
    protected SlideHelper mSlideHelper;
    private boolean mImmersionEnabled = com.baidu.swan.apps.view.a.b.SUPPORT_IMMERSION;
    private int mStatusBarColor = 1;

    public abstract boolean FX();

    protected abstract boolean Gs();

    protected abstract void Gv();

    protected abstract void KI();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean KJ();

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onAttach(Context context) {
        if (DEBUG) {
            Log.d("SwanAppBaseFragment", "onAttach");
        }
        super.onAttach(context);
        this.mActivity = arR();
        cd(true);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDetach() {
        if (DEBUG) {
            Log.d("SwanAppBaseFragment", "onDetach");
        }
        this.mActivity = null;
        cd(false);
        super.onDetach();
        try {
            Field declaredField = Fragment.class.getDeclaredField("cyA");
            declaredField.setAccessible(true);
            declaredField.set(this, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aa(View view) {
        com.baidu.swan.apps.runtime.config.c iA;
        ac(view);
        SwanAppConfigData TL = com.baidu.swan.apps.y.f.Uf().TL();
        if (TL == null) {
            if (DEBUG) {
                Log.d("SwanAppBaseFragment", "config data is null. " + Log.getStackTraceString(new Exception()));
                return;
            }
            return;
        }
        if (this.biu == null) {
            iA = TL.bKP;
        } else {
            iA = com.baidu.swan.apps.y.f.Uf().iA(this.biu.getPage());
        }
        ec(iA.bLs);
        this.biw.setTitle(iA.bLt);
        this.biD = new a(new Runnable() { // from class: com.baidu.swan.apps.core.d.b.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.ac.f.VQ();
            }
        });
        this.biw.findViewById(a.f.titlebar_center_zone);
        if (!(this instanceof SwanAppAdLandingFragment)) {
            gC(iA.bLu);
        }
        this.biy = iA.bLu;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ac(View view) {
        if (view != null) {
            this.biw = (SwanAppActionBar) view.findViewById(a.f.ai_apps_title_bar);
            this.biv = view.findViewById(a.f.ai_apps_title_bar_root);
            this.biz = view.findViewById(a.f.title_shadow);
            this.biw.setLeftBackViewMinWidth(af.dip2px(this.mActivity, 38.0f));
            this.biw.setLeftBackViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    b.this.onActionBarBackPressed();
                }
            });
            this.biw.setRightMenuOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    b.this.KI();
                    com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                    fVar.mValue = "menu";
                    if (com.baidu.swan.apps.runtime.e.ZT() != null && com.baidu.swan.apps.runtime.e.ZT().aai().b("key_unread_counts_message", (Integer) 0).intValue() > 0) {
                        fVar.mPage = String.valueOf(1);
                    }
                    b.this.a(fVar);
                    if (b.this.biD != null) {
                        b.this.biD.onClick();
                    }
                }
            });
            this.biw.setRightExitOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.b.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.mActivity != null && (b.this.mActivity instanceof SwanAppActivity)) {
                        if (com.baidu.swan.apps.runtime.e.ZS() == null || com.baidu.swan.apps.runtime.e.ZU() == null) {
                            b.this.KP();
                        } else if (com.baidu.swan.apps.q.a.Qr().Qs()) {
                            b.this.KO();
                        } else if (com.baidu.swan.apps.q.c.Qy().Qz()) {
                            b.this.KP();
                        } else {
                            com.baidu.swan.apps.q.b Qt = new com.baidu.swan.apps.q.b().Qt();
                            if (!Qt.isShow()) {
                                b.this.KP();
                                return;
                            }
                            com.baidu.swan.apps.q.c.Qy().a(b.this.mActivity, Qt.getImageUrl(), Qt.Qx(), b.this.KN());
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c.a KN() {
        return new c.a() { // from class: com.baidu.swan.apps.core.d.b.6
            @Override // com.baidu.swan.apps.q.c.a
            public void Lh() {
                b.this.KP();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KO() {
        com.baidu.swan.apps.q.a.Qr().a(this.mActivity, new com.baidu.swan.apps.core.f.b<Boolean>() { // from class: com.baidu.swan.apps.core.d.b.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.core.f.b
            /* renamed from: d */
            public void D(Boolean bool) {
                b.this.KP();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KP() {
        if (this.mActivity != null) {
            this.mActivity.moveTaskToBack(true);
            KQ();
            ((SwanAppActivity) this.mActivity).dA(1);
        }
    }

    private void KQ() {
        HashMap hashMap = new HashMap();
        hashMap.put("lcType", "onClose");
        hashMap.put("appId", com.baidu.swan.apps.runtime.e.ZU());
        com.baidu.swan.apps.y.f.Uf().a(new com.baidu.swan.apps.n.a.c(hashMap));
        com.baidu.swan.apps.console.c.d("SwanAppBaseFragment", "onClose");
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "close";
        a(fVar);
    }

    public boolean ec(int i) {
        if (this.biw == null || this.biz == null) {
            return false;
        }
        this.mStatusBarColor = i;
        this.biw.setBackgroundColor(i);
        com.baidu.swan.apps.runtime.config.c KX = KX();
        if (KX != null) {
            KX.bLs = i;
        }
        if (immersionEnabled()) {
            applyImmersion();
        }
        if (KS()) {
            this.biz.setVisibility(0);
        } else {
            this.biz.setVisibility(8);
        }
        return true;
    }

    public boolean a(FrameLayout frameLayout, int i) {
        if (frameLayout == null) {
            return false;
        }
        frameLayout.setBackgroundColor(i);
        com.baidu.swan.apps.runtime.config.c KX = KX();
        if (KX != null) {
            KX.backgroundColor = i;
        }
        return true;
    }

    public SwanAppActionBar KR() {
        return this.biw;
    }

    public boolean KS() {
        return this.mStatusBarColor == -1;
    }

    public void setRightExitViewVisibility(boolean z) {
        this.biw.setRightExitViewVisibility(z);
    }

    public void setRightZoneVisibility(boolean z) {
        this.biw.setRightZoneVisibility(z);
    }

    public void cc(boolean z) {
        FloatButton abc = com.baidu.swan.apps.scheme.actions.d.a.aba().abc();
        if (!z) {
            if (abc != null && abc.getVisibility() == 0) {
                abc.setVisibility(8);
            }
        } else if (abc != null && abc.getVisibility() != 0) {
            abc.setVisibility(0);
        }
    }

    public void cd(boolean z) {
        b ef;
        e DP = com.baidu.swan.apps.y.f.Uf().DP();
        if (DP != null) {
            if (z) {
                ef = DP.LB();
            } else {
                ef = DP.ef(DP.LE() - 1);
            }
            if (ef != null) {
                cc(ef.Gs());
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
        KT();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (immersionEnabled() && this.biB != null && configuration.orientation == 1) {
            arR().getWindow().clearFlags(1024);
            ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.d.b.8
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

    public void KT() {
        if (this.mActivity != null && this.biw != null) {
            ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.d.b.9
                @Override // java.lang.Runnable
                public void run() {
                    if (com.baidu.swan.apps.ah.a.a.XT()) {
                        if (b.this.biA == null) {
                            b.this.biA = new TextView(b.this.mActivity);
                        }
                        if (!(b.this.biA.getParent() instanceof SwanAppActionBar)) {
                            b.this.biA.setText(a.h.aiapps_debug_open_cts);
                            b.this.biA.setTextColor(b.this.getResources().getColor(17170455));
                            b.this.biw.addView(b.this.biA);
                        }
                    } else if (b.this.biA != null) {
                        b.this.biw.removeView(b.this.biA);
                        b.this.biA = null;
                    }
                }
            });
        }
    }

    public void s(int i, String str) {
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
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.biw, "alpha", 0.0f, 1.0f);
        ofFloat.setDuration(i);
        ofFloat.setInterpolator(accelerateDecelerateInterpolator);
        ofFloat.start();
        if (this.biB != null && this.biB.aeM() != null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.biB.aeM(), "alpha", 0.0f, 1.0f);
            ofFloat2.setDuration(i);
            ofFloat2.setInterpolator(accelerateDecelerateInterpolator);
            ofFloat2.start();
        }
    }

    @Nullable
    public boolean gB(String str) {
        if (this.biw == null) {
            return false;
        }
        this.biw.setTitle(str);
        com.baidu.swan.apps.runtime.config.c KX = KX();
        if (KX != null) {
            KX.bLt = str;
        }
        return true;
    }

    protected void KU() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onActionBarBackPressed() {
        if (this.mActivity != null) {
            this.mActivity.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ce(boolean z) {
        this.biw.setLeftBackViewVisibility(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void KV() {
        this.biw.setLeftHomeViewVisibility(0);
        this.biw.setLeftHomeViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.b.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.KU();
            }
        });
    }

    @Override // com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        return true;
    }

    public final e DP() {
        if (this.mActivity == null) {
            return null;
        }
        return ((SwanAppActivity) this.mActivity).DP();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean KW() {
        e DP = DP();
        if (DP == null) {
            return false;
        }
        return DP.LE() > 1;
    }

    public void finishAfterSlide() {
        e DP = DP();
        if (DP == null || DP.LE() == 1) {
            if (this.mActivity != null) {
                this.mActivity.moveTaskToBack(true);
                return;
            }
            return;
        }
        DP.gJ("navigateBack").U(0, 0).LJ().commit();
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
        e DP = DP();
        if (DP != null && DP.LE() >= 2) {
            b ef = DP.ef(DP.LE() - 2);
            a(f, ef);
            if (z) {
                DP.LF().g(ef);
            } else {
                DP.LF().h(ef);
            }
        }
    }

    private void a(float f, Fragment fragment) {
        View view;
        float displayWidth = af.getDisplayWidth(this.mActivity) >> 2;
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

    public boolean gC(String str) {
        return ed(SwanAppConfigData.cy(str));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean ed(@ColorInt int i) {
        if (this.biw == null) {
            return false;
        }
        boolean z = this instanceof com.baidu.swan.apps.core.d.a;
        setRightExitViewVisibility(z ? false : true);
        return this.biw.u(i, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean immersionEnabled() {
        return this.mImmersionEnabled;
    }

    protected com.baidu.swan.apps.runtime.config.c KX() {
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
        this.biB = new com.baidu.swan.apps.view.a.b(this.mActivity, frameLayout);
        applyImmersion();
        return frameLayout;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void applyImmersion() {
        if (this.biB != null) {
            applyImmersion(this.mStatusBarColor);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void applyImmersion(@ColorInt int i) {
        if (this.biB != null) {
            p(i, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(@ColorInt int i, boolean z) {
        if (this.biB != null) {
            this.mStatusBarColor = i;
            this.biB.setImmersion(i, z);
        }
    }

    public void resetWithCurImmersion() {
        if (immersionEnabled() && this.biB != null) {
            this.biB.resetWithCurImmersion();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setRequestedOrientation(int i) {
        if (this.mActivity != null) {
            this.mActivity.setRequestedOrientation(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View enableSliding(View view, SlideInterceptor slideInterceptor) {
        boolean z = getResources().getConfiguration().orientation != 2 && (KX() == null || !KX().bLB) && Build.VERSION.SDK_INT != 26;
        this.mSlideHelper = new SlideHelper();
        View wrapSlideView = this.mSlideHelper.wrapSlideView(view.getContext(), view, slideInterceptor);
        this.mSlideHelper.setFadeColor(0);
        this.mSlideHelper.setCanSlide(z);
        this.mSlideHelper.setSlideListener(new SlidingPaneLayout.PanelSlideListener() { // from class: com.baidu.swan.apps.core.d.b.2
            @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
            public void onPanelSlide(View view2, float f) {
                View maskView = b.this.mSlideHelper.getMaskView();
                if (maskView != null) {
                    maskView.setAlpha(1.0f - f);
                }
                b.this.onPanelSlide(f);
            }

            @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
            public void onPanelOpened(View view2) {
                b.this.finishAfterSlide();
            }

            @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
            public void onPanelClosed(View view2) {
                b.this.onPanelClosed();
            }
        });
        return wrapSlideView;
    }

    public final Resources KY() {
        return isAdded() ? getResources() : AppRuntime.getAppContext().getResources();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean KZ() {
        if ((this.mActivity instanceof SwanAppActivity) && ((SwanAppActivity) this.mActivity).DH() == 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int DH() {
        if (this.mActivity instanceof SwanAppActivity) {
            return ((SwanAppActivity) this.mActivity).DH();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void EQ() {
        if (this.mAudioManager != null && this.biC != null) {
            this.mAudioManager.abandonAudioFocus(this.biC);
        }
    }

    public boolean La() {
        if (this.biw == null) {
            return false;
        }
        this.biw.dW(true);
        return true;
    }

    public boolean Lb() {
        if (this.biw == null) {
            return false;
        }
        this.biw.dW(false);
        return true;
    }

    public void cf(boolean z) {
        if (this.biw != null) {
            this.biw.setActionBarCustom(z);
        }
        if (this.biz != null) {
            int i = 8;
            if (!z && KS()) {
                i = 0;
            }
            this.biz.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int Lc() {
        if (TextUtils.isEmpty(com.baidu.swan.apps.runtime.e.ZU())) {
            return 0;
        }
        if (com.baidu.swan.apps.database.favorite.a.hk(com.baidu.swan.apps.runtime.e.ZU())) {
            return 2;
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Ld() {
        return "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u".equals(com.baidu.swan.apps.runtime.e.ZU());
    }

    public void Le() {
        com.baidu.swan.apps.scheme.actions.k.a.E("backtohome", "menu", com.baidu.swan.apps.y.f.Uf().TP());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "gohome";
        fVar.mSource = "menu";
        a(fVar);
    }

    public void Lf() {
    }

    public com.baidu.swan.apps.model.c Lg() {
        return this.biu;
    }

    /* loaded from: classes9.dex */
    private class a {
        private int biF = 0;
        private long biG = 0;
        private Runnable biH;

        a(Runnable runnable) {
            this.biH = runnable;
        }

        void onClick() {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.biG > 1333) {
                this.biG = currentTimeMillis;
                this.biF = 1;
                return;
            }
            this.biF++;
            if (this.biF == 3) {
                if (this.biH != null) {
                    this.biH.run();
                }
                this.biF = 0;
                this.biG = 0L;
                return;
            }
            this.biG = currentTimeMillis;
        }
    }
}
