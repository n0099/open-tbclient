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
    @Nullable
    protected com.baidu.swan.apps.view.a.b bnA;
    private AudioManager.OnAudioFocusChangeListener bnB;
    private a bnC;
    protected com.baidu.swan.apps.model.c bnt;
    protected View bnu;
    protected SwanAppActionBar bnv;
    protected com.baidu.swan.menu.h bnw;
    protected String bnx;
    protected View bny;
    protected TextView bnz;
    protected Activity mActivity;
    private AudioManager mAudioManager;
    protected SlideHelper mSlideHelper;
    private boolean mImmersionEnabled = com.baidu.swan.apps.view.a.b.SUPPORT_IMMERSION;
    private int mStatusBarColor = 1;

    public abstract boolean II();

    protected abstract boolean Jd();

    protected abstract void Jg();

    protected abstract void Nt();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean Nu();

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onAttach(Context context) {
        if (DEBUG) {
            Log.d("SwanAppBaseFragment", "onAttach");
        }
        super.onAttach(context);
        this.mActivity = auy();
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
            Field declaredField = Fragment.class.getDeclaredField("cCJ");
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
        SwanAppConfigData Ww = com.baidu.swan.apps.y.f.WQ().Ww();
        if (Ww == null) {
            if (DEBUG) {
                Log.d("SwanAppBaseFragment", "config data is null. " + Log.getStackTraceString(new Exception()));
                return;
            }
            return;
        }
        if (this.bnt == null) {
            iS = Ww.bPE;
        } else {
            iS = com.baidu.swan.apps.y.f.WQ().iS(this.bnt.getPage());
        }
        et(iS.bQh);
        this.bnv.setTitle(iS.bQi);
        this.bnC = new a(new Runnable() { // from class: com.baidu.swan.apps.core.d.b.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.ac.f.YB();
            }
        });
        this.bnv.findViewById(a.f.titlebar_center_zone);
        if (!(this instanceof SwanAppAdLandingFragment)) {
            gU(iS.bQj);
        }
        this.bnx = iS.bQj;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ag(View view) {
        if (view != null) {
            this.bnv = (SwanAppActionBar) view.findViewById(a.f.ai_apps_title_bar);
            this.bnu = view.findViewById(a.f.ai_apps_title_bar_root);
            this.bny = view.findViewById(a.f.title_shadow);
            this.bnv.setLeftBackViewMinWidth(af.dip2px(this.mActivity, 38.0f));
            this.bnv.setLeftBackViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    b.this.onActionBarBackPressed();
                }
            });
            this.bnv.setRightMenuOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    b.this.Nt();
                    com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                    fVar.mValue = "menu";
                    if (com.baidu.swan.apps.runtime.e.acE() != null && com.baidu.swan.apps.runtime.e.acE().acT().b("key_unread_counts_message", (Integer) 0).intValue() > 0) {
                        fVar.mPage = String.valueOf(1);
                    }
                    b.this.a(fVar);
                    if (b.this.bnC != null) {
                        b.this.bnC.onClick();
                    }
                }
            });
            this.bnv.setRightExitOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.b.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.mActivity != null && (b.this.mActivity instanceof SwanAppActivity)) {
                        if (com.baidu.swan.apps.runtime.e.acD() == null || com.baidu.swan.apps.runtime.e.acF() == null) {
                            b.this.Nz();
                        } else if (com.baidu.swan.apps.q.a.Tb().Tc()) {
                            b.this.Ny();
                        } else if (com.baidu.swan.apps.q.c.Ti().Tj()) {
                            b.this.Nz();
                        } else {
                            com.baidu.swan.apps.q.b Td = new com.baidu.swan.apps.q.b().Td();
                            if (!Td.isShow()) {
                                b.this.Nz();
                                return;
                            }
                            com.baidu.swan.apps.q.c.Ti().a(b.this.mActivity, Td.getImageUrl(), Td.Th(), b.this.Nx());
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c.a Nx() {
        return new c.a() { // from class: com.baidu.swan.apps.core.d.b.6
            @Override // com.baidu.swan.apps.q.c.a
            public void NR() {
                b.this.Nz();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ny() {
        com.baidu.swan.apps.q.a.Tb().a(this.mActivity, new com.baidu.swan.apps.core.f.b<Boolean>() { // from class: com.baidu.swan.apps.core.d.b.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.core.f.b
            /* renamed from: d */
            public void F(Boolean bool) {
                b.this.Nz();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Nz() {
        if (this.mActivity != null) {
            this.mActivity.moveTaskToBack(true);
            NA();
            ((SwanAppActivity) this.mActivity).dR(1);
        }
    }

    private void NA() {
        HashMap hashMap = new HashMap();
        hashMap.put("lcType", "onClose");
        hashMap.put("appId", com.baidu.swan.apps.runtime.e.acF());
        com.baidu.swan.apps.y.f.WQ().a(new com.baidu.swan.apps.n.a.c(hashMap));
        com.baidu.swan.apps.console.c.d("SwanAppBaseFragment", "onClose");
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "close";
        a(fVar);
    }

    public boolean et(int i) {
        if (this.bnv == null || this.bny == null) {
            return false;
        }
        this.mStatusBarColor = i;
        this.bnv.setBackgroundColor(i);
        com.baidu.swan.apps.runtime.config.c NH = NH();
        if (NH != null) {
            NH.bQh = i;
        }
        if (immersionEnabled()) {
            applyImmersion();
        }
        if (NC()) {
            this.bny.setVisibility(0);
        } else {
            this.bny.setVisibility(8);
        }
        return true;
    }

    public boolean a(FrameLayout frameLayout, int i) {
        if (frameLayout == null) {
            return false;
        }
        frameLayout.setBackgroundColor(i);
        com.baidu.swan.apps.runtime.config.c NH = NH();
        if (NH != null) {
            NH.backgroundColor = i;
        }
        return true;
    }

    public SwanAppActionBar NB() {
        return this.bnv;
    }

    public boolean NC() {
        return this.mStatusBarColor == -1;
    }

    public void setRightExitViewVisibility(boolean z) {
        this.bnv.setRightExitViewVisibility(z);
    }

    public void setRightZoneVisibility(boolean z) {
        this.bnv.setRightZoneVisibility(z);
    }

    public void co(boolean z) {
        FloatButton adN = com.baidu.swan.apps.scheme.actions.d.a.adL().adN();
        if (!z) {
            if (adN != null && adN.getVisibility() == 0) {
                adN.setVisibility(8);
            }
        } else if (adN != null && adN.getVisibility() != 0) {
            adN.setVisibility(0);
        }
    }

    public void cp(boolean z) {
        b ew;
        e GA = com.baidu.swan.apps.y.f.WQ().GA();
        if (GA != null) {
            if (z) {
                ew = GA.Ol();
            } else {
                ew = GA.ew(GA.Oo() - 1);
            }
            if (ew != null) {
                co(ew.Jd());
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
        ND();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (immersionEnabled() && this.bnA != null && configuration.orientation == 1) {
            auy().getWindow().clearFlags(1024);
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

    public void ND() {
        if (this.mActivity != null && this.bnv != null) {
            ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.d.b.9
                @Override // java.lang.Runnable
                public void run() {
                    if (com.baidu.swan.apps.ah.a.a.aaE()) {
                        if (b.this.bnz == null) {
                            b.this.bnz = new TextView(b.this.mActivity);
                        }
                        if (!(b.this.bnz.getParent() instanceof SwanAppActionBar)) {
                            b.this.bnz.setText(a.h.aiapps_debug_open_cts);
                            b.this.bnz.setTextColor(b.this.getResources().getColor(17170455));
                            b.this.bnv.addView(b.this.bnz);
                        }
                    } else if (b.this.bnz != null) {
                        b.this.bnv.removeView(b.this.bnz);
                        b.this.bnz = null;
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
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.bnv, "alpha", 0.0f, 1.0f);
        ofFloat.setDuration(i);
        ofFloat.setInterpolator(accelerateDecelerateInterpolator);
        ofFloat.start();
        if (this.bnA != null && this.bnA.aht() != null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.bnA.aht(), "alpha", 0.0f, 1.0f);
            ofFloat2.setDuration(i);
            ofFloat2.setInterpolator(accelerateDecelerateInterpolator);
            ofFloat2.start();
        }
    }

    @Nullable
    public boolean gT(String str) {
        if (this.bnv == null) {
            return false;
        }
        this.bnv.setTitle(str);
        com.baidu.swan.apps.runtime.config.c NH = NH();
        if (NH != null) {
            NH.bQi = str;
        }
        return true;
    }

    protected void NE() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onActionBarBackPressed() {
        if (this.mActivity != null) {
            this.mActivity.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cq(boolean z) {
        this.bnv.setLeftBackViewVisibility(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void NF() {
        this.bnv.setLeftHomeViewVisibility(0);
        this.bnv.setLeftHomeViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.b.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.NE();
            }
        });
    }

    @Override // com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        return true;
    }

    public final e GA() {
        if (this.mActivity == null) {
            return null;
        }
        return ((SwanAppActivity) this.mActivity).GA();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean NG() {
        e GA = GA();
        if (GA == null) {
            return false;
        }
        return GA.Oo() > 1;
    }

    public void finishAfterSlide() {
        e GA = GA();
        if (GA == null || GA.Oo() == 1) {
            if (this.mActivity != null) {
                this.mActivity.moveTaskToBack(true);
                return;
            }
            return;
        }
        GA.hb("navigateBack").Y(0, 0).Ot().commit();
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
        e GA = GA();
        if (GA != null && GA.Oo() >= 2) {
            b ew = GA.ew(GA.Oo() - 2);
            a(f, ew);
            if (z) {
                GA.Op().g(ew);
            } else {
                GA.Op().h(ew);
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
        if (this.bnv == null) {
            return false;
        }
        boolean z = this instanceof com.baidu.swan.apps.core.d.a;
        setRightExitViewVisibility(z ? false : true);
        return this.bnv.u(i, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean immersionEnabled() {
        return this.mImmersionEnabled;
    }

    protected com.baidu.swan.apps.runtime.config.c NH() {
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
        this.bnA = new com.baidu.swan.apps.view.a.b(this.mActivity, frameLayout);
        applyImmersion();
        return frameLayout;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void applyImmersion() {
        if (this.bnA != null) {
            applyImmersion(this.mStatusBarColor);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void applyImmersion(@ColorInt int i) {
        if (this.bnA != null) {
            p(i, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(@ColorInt int i, boolean z) {
        if (this.bnA != null) {
            this.mStatusBarColor = i;
            this.bnA.setImmersion(i, z);
        }
    }

    public void resetWithCurImmersion() {
        if (immersionEnabled() && this.bnA != null) {
            this.bnA.resetWithCurImmersion();
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
        boolean z = getResources().getConfiguration().orientation != 2 && (NH() == null || !NH().bQq) && Build.VERSION.SDK_INT != 26;
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

    public final Resources NI() {
        return isAdded() ? getResources() : AppRuntime.getAppContext().getResources();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean NJ() {
        if ((this.mActivity instanceof SwanAppActivity) && ((SwanAppActivity) this.mActivity).Gs() == 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int Gs() {
        if (this.mActivity instanceof SwanAppActivity) {
            return ((SwanAppActivity) this.mActivity).Gs();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void HB() {
        if (this.mAudioManager != null && this.bnB != null) {
            this.mAudioManager.abandonAudioFocus(this.bnB);
        }
    }

    public boolean NK() {
        if (this.bnv == null) {
            return false;
        }
        this.bnv.ei(true);
        return true;
    }

    public boolean NL() {
        if (this.bnv == null) {
            return false;
        }
        this.bnv.ei(false);
        return true;
    }

    public void cr(boolean z) {
        if (this.bnv != null) {
            this.bnv.setActionBarCustom(z);
        }
        if (this.bny != null) {
            int i = 8;
            if (!z && NC()) {
                i = 0;
            }
            this.bny.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int NM() {
        if (TextUtils.isEmpty(com.baidu.swan.apps.runtime.e.acF())) {
            return 0;
        }
        if (com.baidu.swan.apps.database.favorite.a.hC(com.baidu.swan.apps.runtime.e.acF())) {
            return 2;
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean NN() {
        return "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u".equals(com.baidu.swan.apps.runtime.e.acF());
    }

    public void NO() {
        com.baidu.swan.apps.scheme.actions.k.a.F("backtohome", "menu", com.baidu.swan.apps.y.f.WQ().WA());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "gohome";
        fVar.mSource = "menu";
        a(fVar);
    }

    public void NP() {
    }

    public com.baidu.swan.apps.model.c NQ() {
        return this.bnt;
    }

    /* loaded from: classes11.dex */
    private class a {
        private int bnE = 0;
        private long bnF = 0;
        private Runnable bnG;

        a(Runnable runnable) {
            this.bnG = runnable;
        }

        void onClick() {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.bnF > 1333) {
                this.bnF = currentTimeMillis;
                this.bnE = 1;
                return;
            }
            this.bnE++;
            if (this.bnE == 3) {
                if (this.bnG != null) {
                    this.bnG.run();
                }
                this.bnE = 0;
                this.bnF = 0L;
                return;
            }
            this.bnF = currentTimeMillis;
        }
    }
}
