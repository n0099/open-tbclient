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
    protected TextView bnA;
    @Nullable
    protected com.baidu.swan.apps.view.a.b bnB;
    private AudioManager.OnAudioFocusChangeListener bnC;
    private a bnD;
    protected com.baidu.swan.apps.model.c bnu;
    protected View bnv;
    protected SwanAppActionBar bnw;
    protected com.baidu.swan.menu.h bnx;
    protected String bny;
    protected View bnz;
    protected Activity mActivity;
    private AudioManager mAudioManager;
    protected SlideHelper mSlideHelper;
    private boolean mImmersionEnabled = com.baidu.swan.apps.view.a.b.SUPPORT_IMMERSION;
    private int mStatusBarColor = 1;

    public abstract boolean IK();

    protected abstract boolean Jf();

    protected abstract void Ji();

    protected abstract void Nv();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean Nw();

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onAttach(Context context) {
        if (DEBUG) {
            Log.d("SwanAppBaseFragment", "onAttach");
        }
        super.onAttach(context);
        this.mActivity = auA();
        cp(true);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDetach() {
        if (DEBUG) {
            Log.d("SwanAppBaseFragment", "onDetach");
        }
        this.mActivity = null;
        cp(false);
        super.onDetach();
        try {
            Field declaredField = Fragment.class.getDeclaredField("cCK");
            declaredField.setAccessible(true);
            declaredField.set(this, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ae(View view) {
        com.baidu.swan.apps.runtime.config.c iS;
        ag(view);
        SwanAppConfigData Wy = com.baidu.swan.apps.y.f.WS().Wy();
        if (Wy == null) {
            if (DEBUG) {
                Log.d("SwanAppBaseFragment", "config data is null. " + Log.getStackTraceString(new Exception()));
                return;
            }
            return;
        }
        if (this.bnu == null) {
            iS = Wy.bPF;
        } else {
            iS = com.baidu.swan.apps.y.f.WS().iS(this.bnu.getPage());
        }
        et(iS.bQi);
        this.bnw.setTitle(iS.bQj);
        this.bnD = new a(new Runnable() { // from class: com.baidu.swan.apps.core.d.b.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.ac.f.YD();
            }
        });
        this.bnw.findViewById(a.f.titlebar_center_zone);
        if (!(this instanceof SwanAppAdLandingFragment)) {
            gU(iS.bQk);
        }
        this.bny = iS.bQk;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ag(View view) {
        if (view != null) {
            this.bnw = (SwanAppActionBar) view.findViewById(a.f.ai_apps_title_bar);
            this.bnv = view.findViewById(a.f.ai_apps_title_bar_root);
            this.bnz = view.findViewById(a.f.title_shadow);
            this.bnw.setLeftBackViewMinWidth(af.dip2px(this.mActivity, 38.0f));
            this.bnw.setLeftBackViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    b.this.onActionBarBackPressed();
                }
            });
            this.bnw.setRightMenuOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    b.this.Nv();
                    com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                    fVar.mValue = "menu";
                    if (com.baidu.swan.apps.runtime.e.acG() != null && com.baidu.swan.apps.runtime.e.acG().acV().b("key_unread_counts_message", (Integer) 0).intValue() > 0) {
                        fVar.mPage = String.valueOf(1);
                    }
                    b.this.a(fVar);
                    if (b.this.bnD != null) {
                        b.this.bnD.onClick();
                    }
                }
            });
            this.bnw.setRightExitOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.b.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.mActivity != null && (b.this.mActivity instanceof SwanAppActivity)) {
                        if (com.baidu.swan.apps.runtime.e.acF() == null || com.baidu.swan.apps.runtime.e.acH() == null) {
                            b.this.NB();
                        } else if (com.baidu.swan.apps.q.a.Td().Te()) {
                            b.this.NA();
                        } else if (com.baidu.swan.apps.q.c.Tk().Tl()) {
                            b.this.NB();
                        } else {
                            com.baidu.swan.apps.q.b Tf = new com.baidu.swan.apps.q.b().Tf();
                            if (!Tf.isShow()) {
                                b.this.NB();
                                return;
                            }
                            com.baidu.swan.apps.q.c.Tk().a(b.this.mActivity, Tf.getImageUrl(), Tf.Tj(), b.this.Nz());
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c.a Nz() {
        return new c.a() { // from class: com.baidu.swan.apps.core.d.b.6
            @Override // com.baidu.swan.apps.q.c.a
            public void NT() {
                b.this.NB();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NA() {
        com.baidu.swan.apps.q.a.Td().a(this.mActivity, new com.baidu.swan.apps.core.f.b<Boolean>() { // from class: com.baidu.swan.apps.core.d.b.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.core.f.b
            /* renamed from: d */
            public void F(Boolean bool) {
                b.this.NB();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NB() {
        if (this.mActivity != null) {
            this.mActivity.moveTaskToBack(true);
            NC();
            ((SwanAppActivity) this.mActivity).dR(1);
        }
    }

    private void NC() {
        HashMap hashMap = new HashMap();
        hashMap.put("lcType", "onClose");
        hashMap.put("appId", com.baidu.swan.apps.runtime.e.acH());
        com.baidu.swan.apps.y.f.WS().a(new com.baidu.swan.apps.n.a.c(hashMap));
        com.baidu.swan.apps.console.c.d("SwanAppBaseFragment", "onClose");
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "close";
        a(fVar);
    }

    public boolean et(int i) {
        if (this.bnw == null || this.bnz == null) {
            return false;
        }
        this.mStatusBarColor = i;
        this.bnw.setBackgroundColor(i);
        com.baidu.swan.apps.runtime.config.c NJ = NJ();
        if (NJ != null) {
            NJ.bQi = i;
        }
        if (immersionEnabled()) {
            applyImmersion();
        }
        if (NE()) {
            this.bnz.setVisibility(0);
        } else {
            this.bnz.setVisibility(8);
        }
        return true;
    }

    public boolean a(FrameLayout frameLayout, int i) {
        if (frameLayout == null) {
            return false;
        }
        frameLayout.setBackgroundColor(i);
        com.baidu.swan.apps.runtime.config.c NJ = NJ();
        if (NJ != null) {
            NJ.backgroundColor = i;
        }
        return true;
    }

    public SwanAppActionBar ND() {
        return this.bnw;
    }

    public boolean NE() {
        return this.mStatusBarColor == -1;
    }

    public void setRightExitViewVisibility(boolean z) {
        this.bnw.setRightExitViewVisibility(z);
    }

    public void setRightZoneVisibility(boolean z) {
        this.bnw.setRightZoneVisibility(z);
    }

    public void co(boolean z) {
        FloatButton adP = com.baidu.swan.apps.scheme.actions.d.a.adN().adP();
        if (!z) {
            if (adP != null && adP.getVisibility() == 0) {
                adP.setVisibility(8);
            }
        } else if (adP != null && adP.getVisibility() != 0) {
            adP.setVisibility(0);
        }
    }

    public void cp(boolean z) {
        b ew;
        e GC = com.baidu.swan.apps.y.f.WS().GC();
        if (GC != null) {
            if (z) {
                ew = GC.On();
            } else {
                ew = GC.ew(GC.Oq() - 1);
            }
            if (ew != null) {
                co(ew.Jf());
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
        NF();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (immersionEnabled() && this.bnB != null && configuration.orientation == 1) {
            auA().getWindow().clearFlags(1024);
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

    public void NF() {
        if (this.mActivity != null && this.bnw != null) {
            ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.d.b.9
                @Override // java.lang.Runnable
                public void run() {
                    if (com.baidu.swan.apps.ah.a.a.aaG()) {
                        if (b.this.bnA == null) {
                            b.this.bnA = new TextView(b.this.mActivity);
                        }
                        if (!(b.this.bnA.getParent() instanceof SwanAppActionBar)) {
                            b.this.bnA.setText(a.h.aiapps_debug_open_cts);
                            b.this.bnA.setTextColor(b.this.getResources().getColor(17170455));
                            b.this.bnw.addView(b.this.bnA);
                        }
                    } else if (b.this.bnA != null) {
                        b.this.bnw.removeView(b.this.bnA);
                        b.this.bnA = null;
                    }
                }
            });
        }
    }

    public void x(int i, String str) {
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
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.bnw, "alpha", 0.0f, 1.0f);
        ofFloat.setDuration(i);
        ofFloat.setInterpolator(accelerateDecelerateInterpolator);
        ofFloat.start();
        if (this.bnB != null && this.bnB.ahv() != null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.bnB.ahv(), "alpha", 0.0f, 1.0f);
            ofFloat2.setDuration(i);
            ofFloat2.setInterpolator(accelerateDecelerateInterpolator);
            ofFloat2.start();
        }
    }

    @Nullable
    public boolean gT(String str) {
        if (this.bnw == null) {
            return false;
        }
        this.bnw.setTitle(str);
        com.baidu.swan.apps.runtime.config.c NJ = NJ();
        if (NJ != null) {
            NJ.bQj = str;
        }
        return true;
    }

    protected void NG() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onActionBarBackPressed() {
        if (this.mActivity != null) {
            this.mActivity.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cq(boolean z) {
        this.bnw.setLeftBackViewVisibility(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void NH() {
        this.bnw.setLeftHomeViewVisibility(0);
        this.bnw.setLeftHomeViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.b.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.NG();
            }
        });
    }

    @Override // com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        return true;
    }

    public final e GC() {
        if (this.mActivity == null) {
            return null;
        }
        return ((SwanAppActivity) this.mActivity).GC();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean NI() {
        e GC = GC();
        if (GC == null) {
            return false;
        }
        return GC.Oq() > 1;
    }

    public void finishAfterSlide() {
        e GC = GC();
        if (GC == null || GC.Oq() == 1) {
            if (this.mActivity != null) {
                this.mActivity.moveTaskToBack(true);
                return;
            }
            return;
        }
        GC.hb("navigateBack").Y(0, 0).Ov().commit();
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
        e GC = GC();
        if (GC != null && GC.Oq() >= 2) {
            b ew = GC.ew(GC.Oq() - 2);
            a(f, ew);
            if (z) {
                GC.Or().g(ew);
            } else {
                GC.Or().h(ew);
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

    public boolean gU(String str) {
        return eu(SwanAppConfigData.cG(str));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean eu(@ColorInt int i) {
        if (this.bnw == null) {
            return false;
        }
        boolean z = this instanceof com.baidu.swan.apps.core.d.a;
        setRightExitViewVisibility(z ? false : true);
        return this.bnw.u(i, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean immersionEnabled() {
        return this.mImmersionEnabled;
    }

    protected com.baidu.swan.apps.runtime.config.c NJ() {
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
        this.bnB = new com.baidu.swan.apps.view.a.b(this.mActivity, frameLayout);
        applyImmersion();
        return frameLayout;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void applyImmersion() {
        if (this.bnB != null) {
            applyImmersion(this.mStatusBarColor);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void applyImmersion(@ColorInt int i) {
        if (this.bnB != null) {
            p(i, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(@ColorInt int i, boolean z) {
        if (this.bnB != null) {
            this.mStatusBarColor = i;
            this.bnB.setImmersion(i, z);
        }
    }

    public void resetWithCurImmersion() {
        if (immersionEnabled() && this.bnB != null) {
            this.bnB.resetWithCurImmersion();
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
        boolean z = getResources().getConfiguration().orientation != 2 && (NJ() == null || !NJ().bQr) && Build.VERSION.SDK_INT != 26;
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

    public final Resources NK() {
        return isAdded() ? getResources() : AppRuntime.getAppContext().getResources();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean NL() {
        if ((this.mActivity instanceof SwanAppActivity) && ((SwanAppActivity) this.mActivity).Gu() == 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int Gu() {
        if (this.mActivity instanceof SwanAppActivity) {
            return ((SwanAppActivity) this.mActivity).Gu();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void HD() {
        if (this.mAudioManager != null && this.bnC != null) {
            this.mAudioManager.abandonAudioFocus(this.bnC);
        }
    }

    public boolean NM() {
        if (this.bnw == null) {
            return false;
        }
        this.bnw.ei(true);
        return true;
    }

    public boolean NN() {
        if (this.bnw == null) {
            return false;
        }
        this.bnw.ei(false);
        return true;
    }

    public void cr(boolean z) {
        if (this.bnw != null) {
            this.bnw.setActionBarCustom(z);
        }
        if (this.bnz != null) {
            int i = 8;
            if (!z && NE()) {
                i = 0;
            }
            this.bnz.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int NO() {
        if (TextUtils.isEmpty(com.baidu.swan.apps.runtime.e.acH())) {
            return 0;
        }
        if (com.baidu.swan.apps.database.favorite.a.hC(com.baidu.swan.apps.runtime.e.acH())) {
            return 2;
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean NP() {
        return "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u".equals(com.baidu.swan.apps.runtime.e.acH());
    }

    public void NQ() {
        com.baidu.swan.apps.scheme.actions.k.a.F("backtohome", "menu", com.baidu.swan.apps.y.f.WS().WC());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "gohome";
        fVar.mSource = "menu";
        a(fVar);
    }

    public void NR() {
    }

    public com.baidu.swan.apps.model.c NS() {
        return this.bnu;
    }

    /* loaded from: classes11.dex */
    private class a {
        private int bnF = 0;
        private long bnG = 0;
        private Runnable bnH;

        a(Runnable runnable) {
            this.bnH = runnable;
        }

        void onClick() {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.bnG > 1333) {
                this.bnG = currentTimeMillis;
                this.bnF = 1;
                return;
            }
            this.bnF++;
            if (this.bnF == 3) {
                if (this.bnH != null) {
                    this.bnH.run();
                }
                this.bnF = 0;
                this.bnG = 0L;
                return;
            }
            this.bnG = currentTimeMillis;
        }
    }
}
