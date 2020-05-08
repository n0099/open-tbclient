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
    private AudioManager.OnAudioFocusChangeListener aRp;
    protected com.baidu.swan.apps.model.c bLU;
    protected View bLV;
    protected SwanAppActionBar bLW;
    protected com.baidu.swan.menu.h bLX;
    protected String bLY;
    protected View bLZ;
    protected TextView bMa;
    @Nullable
    protected com.baidu.swan.apps.view.a.b bMb;
    private a bMc;
    protected Activity mActivity;
    private AudioManager mAudioManager;
    protected SlideHelper mSlideHelper;
    private boolean mImmersionEnabled = com.baidu.swan.apps.view.a.b.SUPPORT_IMMERSION;
    private int mStatusBarColor = 1;

    protected abstract boolean QT();

    protected abstract void QW();

    public abstract boolean Qy();

    protected abstract void Vk();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean Vl();

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
            Field declaredField = Fragment.class.getDeclaredField("dcb");
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
        SwanAppConfigData aep = com.baidu.swan.apps.y.f.aeJ().aep();
        if (aep == null) {
            if (DEBUG) {
                Log.d("SwanAppBaseFragment", "config data is null. " + Log.getStackTraceString(new Exception()));
                return;
            }
            return;
        }
        if (this.bLU == null) {
            ke = aep.coJ;
        } else {
            ke = com.baidu.swan.apps.y.f.aeJ().ke(this.bLU.getPage());
        }
        ey(ke.cpm);
        this.bLW.setTitle(ke.cpn);
        this.bMc = new a(new Runnable() { // from class: com.baidu.swan.apps.core.d.b.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.ac.f.agL();
            }
        });
        this.bLW.findViewById(a.f.titlebar_center_zone);
        if (!(this instanceof SwanAppAdLandingFragment)) {
            ih(ke.cpo);
        }
        this.bLY = ke.cpo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ah(View view) {
        if (view != null) {
            this.bLW = (SwanAppActionBar) view.findViewById(a.f.ai_apps_title_bar);
            this.bLV = view.findViewById(a.f.ai_apps_title_bar_root);
            this.bLZ = view.findViewById(a.f.title_shadow);
            this.bLW.setLeftBackViewMinWidth(af.dip2px(this.mActivity, 38.0f));
            this.bLW.setLeftBackViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    b.this.Vw();
                }
            });
            this.bLW.setRightMenuOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    b.this.Vk();
                    com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                    fVar.mValue = "menu";
                    if (com.baidu.swan.apps.runtime.e.akN() != null && com.baidu.swan.apps.runtime.e.akN().alc().b("key_unread_counts_message", (Integer) 0).intValue() > 0) {
                        fVar.mPage = String.valueOf(1);
                    }
                    b.this.a(fVar);
                    if (b.this.bMc != null) {
                        b.this.bMc.onClick();
                    }
                }
            });
            this.bLW.setRightExitOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.b.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.mActivity != null && (b.this.mActivity instanceof SwanAppActivity)) {
                        if (com.baidu.swan.apps.runtime.e.akM() == null || com.baidu.swan.apps.runtime.e.akO() == null) {
                            b.this.Vq();
                        } else if (com.baidu.swan.apps.q.a.aaU().aaV()) {
                            b.this.Vp();
                        } else if (com.baidu.swan.apps.q.c.abb().abc()) {
                            b.this.Vq();
                        } else {
                            com.baidu.swan.apps.q.b aaW = new com.baidu.swan.apps.q.b().aaW();
                            if (!aaW.isShow()) {
                                b.this.Vq();
                                return;
                            }
                            com.baidu.swan.apps.q.c.abb().a(b.this.mActivity, aaW.getImageUrl(), aaW.aba(), b.this.Vo());
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c.a Vo() {
        return new c.a() { // from class: com.baidu.swan.apps.core.d.b.6
            @Override // com.baidu.swan.apps.q.c.a
            public void VJ() {
                b.this.Vq();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vp() {
        com.baidu.swan.apps.q.a.aaU().a(this.mActivity, new com.baidu.swan.apps.core.f.b<Boolean>() { // from class: com.baidu.swan.apps.core.d.b.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.core.f.b
            /* renamed from: d */
            public void H(Boolean bool) {
                b.this.Vq();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vq() {
        if (this.mActivity != null) {
            this.mActivity.moveTaskToBack(true);
            Vr();
            ((SwanAppActivity) this.mActivity).dW(1);
        }
    }

    private void Vr() {
        HashMap hashMap = new HashMap();
        hashMap.put("lcType", "onClose");
        hashMap.put("appId", com.baidu.swan.apps.runtime.e.akO());
        com.baidu.swan.apps.y.f.aeJ().a(new com.baidu.swan.apps.n.a.c(hashMap));
        com.baidu.swan.apps.console.c.d("SwanAppBaseFragment", "onClose");
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "close";
        a(fVar);
    }

    public boolean ey(int i) {
        if (this.bLW == null || this.bLZ == null) {
            return false;
        }
        this.mStatusBarColor = i;
        this.bLW.setBackgroundColor(i);
        com.baidu.swan.apps.runtime.config.c Vz = Vz();
        if (Vz != null) {
            Vz.cpm = i;
        }
        if (immersionEnabled()) {
            applyImmersion();
        }
        if (Vt()) {
            this.bLZ.setVisibility(0);
        } else {
            this.bLZ.setVisibility(8);
        }
        return true;
    }

    public boolean a(FrameLayout frameLayout, int i) {
        if (frameLayout == null) {
            return false;
        }
        frameLayout.setBackgroundColor(i);
        com.baidu.swan.apps.runtime.config.c Vz = Vz();
        if (Vz != null) {
            Vz.backgroundColor = i;
        }
        return true;
    }

    public SwanAppActionBar Vs() {
        return this.bLW;
    }

    public boolean Vt() {
        return this.mStatusBarColor == -1;
    }

    public void setRightExitViewVisibility(boolean z) {
        this.bLW.setRightExitViewVisibility(z);
    }

    public void setRightZoneVisibility(boolean z) {
        this.bLW.setRightZoneVisibility(z);
    }

    public void dl(boolean z) {
        FloatButton alW = com.baidu.swan.apps.scheme.actions.d.a.alU().alW();
        if (!z) {
            if (alW != null && alW.getVisibility() == 0) {
                alW.setVisibility(8);
            }
        } else if (alW != null && alW.getVisibility() != 0) {
            alW.setVisibility(0);
        }
    }

    public void dm(boolean z) {
        b eB;
        e Ot = com.baidu.swan.apps.y.f.aeJ().Ot();
        if (Ot != null) {
            if (z) {
                eB = Ot.Wd();
            } else {
                eB = Ot.eB(Ot.Wg() - 1);
            }
            if (eB != null) {
                dl(eB.QT());
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
        Vu();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (immersionEnabled() && this.bMb != null && configuration.orientation == 1) {
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

    public void Vu() {
        if (this.mActivity != null && this.bLW != null) {
            ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.d.b.9
                @Override // java.lang.Runnable
                public void run() {
                    if (com.baidu.swan.apps.ah.a.a.aiN()) {
                        if (b.this.bMa == null) {
                            b.this.bMa = new TextView(b.this.mActivity);
                        }
                        if (!(b.this.bMa.getParent() instanceof SwanAppActionBar)) {
                            b.this.bMa.setText(a.h.aiapps_debug_open_cts);
                            b.this.bMa.setTextColor(b.this.getResources().getColor(17170455));
                            b.this.bLW.addView(b.this.bMa);
                        }
                    } else if (b.this.bMa != null) {
                        b.this.bLW.removeView(b.this.bMa);
                        b.this.bMa = null;
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
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.bLW, "alpha", 0.0f, 1.0f);
        ofFloat.setDuration(i);
        ofFloat.setInterpolator(accelerateDecelerateInterpolator);
        ofFloat.start();
        if (this.bMb != null && this.bMb.apF() != null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.bMb.apF(), "alpha", 0.0f, 1.0f);
            ofFloat2.setDuration(i);
            ofFloat2.setInterpolator(accelerateDecelerateInterpolator);
            ofFloat2.start();
        }
    }

    @Nullable
    public boolean ig(String str) {
        if (this.bLW == null) {
            return false;
        }
        this.bLW.setTitle(str);
        com.baidu.swan.apps.runtime.config.c Vz = Vz();
        if (Vz != null) {
            Vz.cpn = str;
        }
        return true;
    }

    protected void Vv() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Vw() {
        if (this.mActivity != null) {
            this.mActivity.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dn(boolean z) {
        this.bLW.setLeftBackViewVisibility(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Vx() {
        this.bLW.setLeftHomeViewVisibility(0);
        this.bLW.setLeftHomeViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.b.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.Vv();
            }
        });
    }

    @Override // com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        return true;
    }

    public final e Ot() {
        if (this.mActivity == null) {
            return null;
        }
        return ((SwanAppActivity) this.mActivity).Ot();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean Vy() {
        e Ot = Ot();
        if (Ot == null) {
            return false;
        }
        return Ot.Wg() > 1;
    }

    public void finishAfterSlide() {
        e Ot = Ot();
        if (Ot == null || Ot.Wg() == 1) {
            if (this.mActivity != null) {
                this.mActivity.moveTaskToBack(true);
                return;
            }
            return;
        }
        Ot.io("navigateBack").ab(0, 0).Wl().commit();
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
        e Ot = Ot();
        if (Ot != null && Ot.Wg() >= 2) {
            b eB = Ot.eB(Ot.Wg() - 2);
            a(f, eB);
            if (z) {
                Ot.Wh().g(eB);
            } else {
                Ot.Wh().h(eB);
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
        if (this.bLW == null) {
            return false;
        }
        boolean z = this instanceof com.baidu.swan.apps.core.d.a;
        setRightExitViewVisibility(z ? false : true);
        return this.bLW.x(i, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean immersionEnabled() {
        return this.mImmersionEnabled;
    }

    protected com.baidu.swan.apps.runtime.config.c Vz() {
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
        this.bMb = new com.baidu.swan.apps.view.a.b(this.mActivity, frameLayout);
        applyImmersion();
        return frameLayout;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void applyImmersion() {
        if (this.bMb != null) {
            applyImmersion(this.mStatusBarColor);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void applyImmersion(@ColorInt int i) {
        if (this.bMb != null) {
            t(i, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void t(@ColorInt int i, boolean z) {
        if (this.bMb != null) {
            this.mStatusBarColor = i;
            this.bMb.setImmersion(i, z);
        }
    }

    public void resetWithCurImmersion() {
        if (immersionEnabled() && this.bMb != null) {
            this.bMb.resetWithCurImmersion();
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
        boolean z = getResources().getConfiguration().orientation != 2 && (Vz() == null || !Vz().cpw) && Build.VERSION.SDK_INT != 26;
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

    public final Resources VA() {
        return isAdded() ? getResources() : AppRuntime.getAppContext().getResources();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean VB() {
        if ((this.mActivity instanceof SwanAppActivity) && ((SwanAppActivity) this.mActivity).Ol() == 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int Ol() {
        if (this.mActivity instanceof SwanAppActivity) {
            return ((SwanAppActivity) this.mActivity).Ol();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Eb() {
        if (this.mAudioManager != null && this.aRp != null) {
            this.mAudioManager.abandonAudioFocus(this.aRp);
        }
    }

    public boolean VC() {
        if (this.bLW == null) {
            return false;
        }
        this.bLW.fg(true);
        return true;
    }

    public boolean VD() {
        if (this.bLW == null) {
            return false;
        }
        this.bLW.fg(false);
        return true;
    }

    /* renamed from: do  reason: not valid java name */
    public void m27do(boolean z) {
        if (this.bLW != null) {
            this.bLW.setActionBarCustom(z);
        }
        if (this.bLZ != null) {
            int i = 8;
            if (!z && Vt()) {
                i = 0;
            }
            this.bLZ.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int VE() {
        if (TextUtils.isEmpty(com.baidu.swan.apps.runtime.e.akO())) {
            return 0;
        }
        if (com.baidu.swan.apps.database.favorite.a.iP(com.baidu.swan.apps.runtime.e.akO())) {
            return 2;
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean VF() {
        return "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u".equals(com.baidu.swan.apps.runtime.e.akO());
    }

    public void VG() {
        com.baidu.swan.apps.scheme.actions.k.a.F("backtohome", "menu", com.baidu.swan.apps.y.f.aeJ().aet());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "gohome";
        fVar.mSource = "menu";
        a(fVar);
    }

    public void VH() {
    }

    public com.baidu.swan.apps.model.c VI() {
        return this.bLU;
    }

    /* loaded from: classes11.dex */
    private class a {
        private int bMe = 0;
        private long bMf = 0;
        private Runnable bMg;

        a(Runnable runnable) {
            this.bMg = runnable;
        }

        void onClick() {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.bMf > 1333) {
                this.bMf = currentTimeMillis;
                this.bMe = 1;
                return;
            }
            this.bMe++;
            if (this.bMe == 3) {
                if (this.bMg != null) {
                    this.bMg.run();
                }
                this.bMe = 0;
                this.bMf = 0L;
                return;
            }
            this.bMf = currentTimeMillis;
        }
    }
}
