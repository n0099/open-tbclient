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
/* loaded from: classes11.dex */
public abstract class b extends Fragment implements SlideInterceptor {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private AudioManager.OnAudioFocusChangeListener aRk;
    protected com.baidu.swan.apps.model.c bLP;
    protected View bLQ;
    protected SwanAppActionBar bLR;
    protected com.baidu.swan.menu.h bLS;
    protected String bLT;
    protected View bLU;
    protected TextView bLV;
    @Nullable
    protected com.baidu.swan.apps.view.a.b bLW;
    private a bLX;
    protected Activity mActivity;
    private AudioManager mAudioManager;
    protected SlideHelper mSlideHelper;
    private boolean mImmersionEnabled = com.baidu.swan.apps.view.a.b.SUPPORT_IMMERSION;
    private int mStatusBarColor = 1;

    protected abstract boolean QU();

    protected abstract void QX();

    public abstract boolean Qz();

    protected abstract void Vl();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean Vm();

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onAttach(Context context) {
        if (DEBUG) {
            Log.d("SwanAppBaseFragment", "onAttach");
        }
        super.onAttach(context);
        this.mActivity = aCO();
        dm(true);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDetach() {
        if (DEBUG) {
            Log.d("SwanAppBaseFragment", "onDetach");
        }
        this.mActivity = null;
        dm(false);
        super.onDetach();
        try {
            Field declaredField = Fragment.class.getDeclaredField("dbW");
            declaredField.setAccessible(true);
            declaredField.set(this, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ae(View view) {
        com.baidu.swan.apps.runtime.config.c ke;
        ah(view);
        SwanAppConfigData aeq = com.baidu.swan.apps.y.f.aeK().aeq();
        if (aeq == null) {
            if (DEBUG) {
                Log.d("SwanAppBaseFragment", "config data is null. " + Log.getStackTraceString(new Exception()));
                return;
            }
            return;
        }
        if (this.bLP == null) {
            ke = aeq.coD;
        } else {
            ke = com.baidu.swan.apps.y.f.aeK().ke(this.bLP.getPage());
        }
        ey(ke.cpg);
        this.bLR.setTitle(ke.cph);
        this.bLX = new a(new Runnable() { // from class: com.baidu.swan.apps.core.d.b.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.ac.f.agM();
            }
        });
        this.bLR.findViewById(a.f.titlebar_center_zone);
        if (!(this instanceof SwanAppAdLandingFragment)) {
            ih(ke.cpi);
        }
        this.bLT = ke.cpi;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ah(View view) {
        if (view != null) {
            this.bLR = (SwanAppActionBar) view.findViewById(a.f.ai_apps_title_bar);
            this.bLQ = view.findViewById(a.f.ai_apps_title_bar_root);
            this.bLU = view.findViewById(a.f.title_shadow);
            this.bLR.setLeftBackViewMinWidth(af.dip2px(this.mActivity, 38.0f));
            this.bLR.setLeftBackViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    b.this.Vx();
                }
            });
            this.bLR.setRightMenuOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    b.this.Vl();
                    com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                    fVar.mValue = "menu";
                    if (com.baidu.swan.apps.runtime.e.akO() != null && com.baidu.swan.apps.runtime.e.akO().ald().b("key_unread_counts_message", (Integer) 0).intValue() > 0) {
                        fVar.mPage = String.valueOf(1);
                    }
                    b.this.a(fVar);
                    if (b.this.bLX != null) {
                        b.this.bLX.onClick();
                    }
                }
            });
            this.bLR.setRightExitOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.b.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.mActivity != null && (b.this.mActivity instanceof SwanAppActivity)) {
                        if (com.baidu.swan.apps.runtime.e.akN() == null || com.baidu.swan.apps.runtime.e.akP() == null) {
                            b.this.Vr();
                        } else if (com.baidu.swan.apps.q.a.aaV().aaW()) {
                            b.this.Vq();
                        } else if (com.baidu.swan.apps.q.c.abc().abd()) {
                            b.this.Vr();
                        } else {
                            com.baidu.swan.apps.q.b aaX = new com.baidu.swan.apps.q.b().aaX();
                            if (!aaX.isShow()) {
                                b.this.Vr();
                                return;
                            }
                            com.baidu.swan.apps.q.c.abc().a(b.this.mActivity, aaX.getImageUrl(), aaX.abb(), b.this.Vp());
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c.a Vp() {
        return new c.a() { // from class: com.baidu.swan.apps.core.d.b.6
            @Override // com.baidu.swan.apps.q.c.a
            public void VK() {
                b.this.Vr();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vq() {
        com.baidu.swan.apps.q.a.aaV().a(this.mActivity, new com.baidu.swan.apps.core.f.b<Boolean>() { // from class: com.baidu.swan.apps.core.d.b.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.core.f.b
            /* renamed from: d */
            public void G(Boolean bool) {
                b.this.Vr();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vr() {
        if (this.mActivity != null) {
            this.mActivity.moveTaskToBack(true);
            Vs();
            ((SwanAppActivity) this.mActivity).dW(1);
        }
    }

    private void Vs() {
        HashMap hashMap = new HashMap();
        hashMap.put("lcType", "onClose");
        hashMap.put("appId", com.baidu.swan.apps.runtime.e.akP());
        com.baidu.swan.apps.y.f.aeK().a(new com.baidu.swan.apps.n.a.c(hashMap));
        com.baidu.swan.apps.console.c.d("SwanAppBaseFragment", "onClose");
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "close";
        a(fVar);
    }

    public boolean ey(int i) {
        if (this.bLR == null || this.bLU == null) {
            return false;
        }
        this.mStatusBarColor = i;
        this.bLR.setBackgroundColor(i);
        com.baidu.swan.apps.runtime.config.c VA = VA();
        if (VA != null) {
            VA.cpg = i;
        }
        if (immersionEnabled()) {
            applyImmersion();
        }
        if (Vu()) {
            this.bLU.setVisibility(0);
        } else {
            this.bLU.setVisibility(8);
        }
        return true;
    }

    public boolean a(FrameLayout frameLayout, int i) {
        if (frameLayout == null) {
            return false;
        }
        frameLayout.setBackgroundColor(i);
        com.baidu.swan.apps.runtime.config.c VA = VA();
        if (VA != null) {
            VA.backgroundColor = i;
        }
        return true;
    }

    public SwanAppActionBar Vt() {
        return this.bLR;
    }

    public boolean Vu() {
        return this.mStatusBarColor == -1;
    }

    public void setRightExitViewVisibility(boolean z) {
        this.bLR.setRightExitViewVisibility(z);
    }

    public void setRightZoneVisibility(boolean z) {
        this.bLR.setRightZoneVisibility(z);
    }

    public void dl(boolean z) {
        FloatButton alX = com.baidu.swan.apps.scheme.actions.d.a.alV().alX();
        if (!z) {
            if (alX != null && alX.getVisibility() == 0) {
                alX.setVisibility(8);
            }
        } else if (alX != null && alX.getVisibility() != 0) {
            alX.setVisibility(0);
        }
    }

    public void dm(boolean z) {
        b eB;
        e Ou = com.baidu.swan.apps.y.f.aeK().Ou();
        if (Ou != null) {
            if (z) {
                eB = Ou.We();
            } else {
                eB = Ou.eB(Ou.Wh() - 1);
            }
            if (eB != null) {
                dl(eB.QU());
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
        Vv();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (immersionEnabled() && this.bLW != null && configuration.orientation == 1) {
            aCO().getWindow().clearFlags(1024);
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

    public void Vv() {
        if (this.mActivity != null && this.bLR != null) {
            ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.d.b.9
                @Override // java.lang.Runnable
                public void run() {
                    if (com.baidu.swan.apps.ah.a.a.aiO()) {
                        if (b.this.bLV == null) {
                            b.this.bLV = new TextView(b.this.mActivity);
                        }
                        if (!(b.this.bLV.getParent() instanceof SwanAppActionBar)) {
                            b.this.bLV.setText(a.h.aiapps_debug_open_cts);
                            b.this.bLV.setTextColor(b.this.getResources().getColor(17170455));
                            b.this.bLR.addView(b.this.bLV);
                        }
                    } else if (b.this.bLV != null) {
                        b.this.bLR.removeView(b.this.bLV);
                        b.this.bLV = null;
                    }
                }
            });
        }
    }

    public void O(int i, String str) {
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
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.bLR, "alpha", 0.0f, 1.0f);
        ofFloat.setDuration(i);
        ofFloat.setInterpolator(accelerateDecelerateInterpolator);
        ofFloat.start();
        if (this.bLW != null && this.bLW.apG() != null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.bLW.apG(), "alpha", 0.0f, 1.0f);
            ofFloat2.setDuration(i);
            ofFloat2.setInterpolator(accelerateDecelerateInterpolator);
            ofFloat2.start();
        }
    }

    @Nullable
    public boolean ig(String str) {
        if (this.bLR == null) {
            return false;
        }
        this.bLR.setTitle(str);
        com.baidu.swan.apps.runtime.config.c VA = VA();
        if (VA != null) {
            VA.cph = str;
        }
        return true;
    }

    protected void Vw() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Vx() {
        if (this.mActivity != null) {
            this.mActivity.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dn(boolean z) {
        this.bLR.setLeftBackViewVisibility(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Vy() {
        this.bLR.setLeftHomeViewVisibility(0);
        this.bLR.setLeftHomeViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.b.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.Vw();
            }
        });
    }

    @Override // com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        return true;
    }

    public final e Ou() {
        if (this.mActivity == null) {
            return null;
        }
        return ((SwanAppActivity) this.mActivity).Ou();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean Vz() {
        e Ou = Ou();
        if (Ou == null) {
            return false;
        }
        return Ou.Wh() > 1;
    }

    public void finishAfterSlide() {
        e Ou = Ou();
        if (Ou == null || Ou.Wh() == 1) {
            if (this.mActivity != null) {
                this.mActivity.moveTaskToBack(true);
                return;
            }
            return;
        }
        Ou.io("navigateBack").ab(0, 0).Wm().commit();
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
        e Ou = Ou();
        if (Ou != null && Ou.Wh() >= 2) {
            b eB = Ou.eB(Ou.Wh() - 2);
            a(f, eB);
            if (z) {
                Ou.Wi().g(eB);
            } else {
                Ou.Wi().h(eB);
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

    public boolean ih(String str) {
        return ez(SwanAppConfigData.dA(str));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean ez(@ColorInt int i) {
        if (this.bLR == null) {
            return false;
        }
        boolean z = this instanceof com.baidu.swan.apps.core.d.a;
        setRightExitViewVisibility(z ? false : true);
        return this.bLR.x(i, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean immersionEnabled() {
        return this.mImmersionEnabled;
    }

    protected com.baidu.swan.apps.runtime.config.c VA() {
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
        this.bLW = new com.baidu.swan.apps.view.a.b(this.mActivity, frameLayout);
        applyImmersion();
        return frameLayout;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void applyImmersion() {
        if (this.bLW != null) {
            applyImmersion(this.mStatusBarColor);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void applyImmersion(@ColorInt int i) {
        if (this.bLW != null) {
            t(i, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void t(@ColorInt int i, boolean z) {
        if (this.bLW != null) {
            this.mStatusBarColor = i;
            this.bLW.setImmersion(i, z);
        }
    }

    public void resetWithCurImmersion() {
        if (immersionEnabled() && this.bLW != null) {
            this.bLW.resetWithCurImmersion();
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
        boolean z = getResources().getConfiguration().orientation != 2 && (VA() == null || !VA().cpp) && Build.VERSION.SDK_INT != 26;
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

    public final Resources VB() {
        return isAdded() ? getResources() : AppRuntime.getAppContext().getResources();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean VC() {
        if ((this.mActivity instanceof SwanAppActivity) && ((SwanAppActivity) this.mActivity).Om() == 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int Om() {
        if (this.mActivity instanceof SwanAppActivity) {
            return ((SwanAppActivity) this.mActivity).Om();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ec() {
        if (this.mAudioManager != null && this.aRk != null) {
            this.mAudioManager.abandonAudioFocus(this.aRk);
        }
    }

    public boolean VD() {
        if (this.bLR == null) {
            return false;
        }
        this.bLR.fg(true);
        return true;
    }

    public boolean VE() {
        if (this.bLR == null) {
            return false;
        }
        this.bLR.fg(false);
        return true;
    }

    /* renamed from: do  reason: not valid java name */
    public void m27do(boolean z) {
        if (this.bLR != null) {
            this.bLR.setActionBarCustom(z);
        }
        if (this.bLU != null) {
            int i = 8;
            if (!z && Vu()) {
                i = 0;
            }
            this.bLU.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int VF() {
        if (TextUtils.isEmpty(com.baidu.swan.apps.runtime.e.akP())) {
            return 0;
        }
        if (com.baidu.swan.apps.database.favorite.a.iP(com.baidu.swan.apps.runtime.e.akP())) {
            return 2;
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean VG() {
        return "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u".equals(com.baidu.swan.apps.runtime.e.akP());
    }

    public void VH() {
        com.baidu.swan.apps.scheme.actions.k.a.F("backtohome", "menu", com.baidu.swan.apps.y.f.aeK().aeu());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "gohome";
        fVar.mSource = "menu";
        a(fVar);
    }

    public void VI() {
    }

    public com.baidu.swan.apps.model.c VJ() {
        return this.bLP;
    }

    /* loaded from: classes11.dex */
    private class a {
        private int bLZ = 0;
        private long bMa = 0;
        private Runnable bMb;

        a(Runnable runnable) {
            this.bMb = runnable;
        }

        void onClick() {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.bMa > 1333) {
                this.bMa = currentTimeMillis;
                this.bLZ = 1;
                return;
            }
            this.bLZ++;
            if (this.bLZ == 3) {
                if (this.bMb != null) {
                    this.bMb.run();
                }
                this.bLZ = 0;
                this.bMa = 0L;
                return;
            }
            this.bMa = currentTimeMillis;
        }
    }
}
