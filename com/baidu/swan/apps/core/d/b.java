package com.baidu.swan.apps.core.d;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.AudioManager;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.widget.SlideHelper;
import com.baidu.searchbox.widget.SlideInterceptor;
import com.baidu.searchbox.widget.SlidingPaneLayout;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.an.ac;
import com.baidu.swan.apps.an.z;
import com.baidu.swan.apps.p.a;
import com.baidu.swan.apps.res.ui.FloatButton;
import com.baidu.swan.apps.view.SwanAppActionBar;
import com.baidu.swan.support.v4.app.Fragment;
import java.lang.reflect.Field;
import java.util.HashMap;
/* loaded from: classes2.dex */
public abstract class b extends Fragment implements SlideInterceptor {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    protected com.baidu.swan.apps.model.c aKe;
    protected View aKf;
    protected SwanAppActionBar aKg;
    protected com.baidu.swan.menu.g aKh;
    protected String aKi;
    protected View aKj;
    @Nullable
    protected com.baidu.swan.apps.view.a.b aKk;
    protected SlideHelper aKm;
    private AudioManager.OnAudioFocusChangeListener aKo;
    private C0177b aKp;
    protected Activity mActivity;
    private AudioManager mAudioManager;
    private boolean aKl = com.baidu.swan.apps.view.a.b.bgQ;
    private int aKn = 1;

    protected abstract boolean CC();

    public abstract boolean Co();

    protected abstract void Eu();

    protected abstract void Ev();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean Ew();

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onAttach(Context context) {
        if (DEBUG) {
            Log.d("SwanAppBaseFragment", "onAttach");
        }
        super.onAttach(context);
        this.mActivity = abT();
        bu(true);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDetach() {
        if (DEBUG) {
            Log.d("SwanAppBaseFragment", "onDetach");
        }
        this.mActivity = null;
        bu(false);
        super.onDetach();
        try {
            Field declaredField = Fragment.class.getDeclaredField("bMK");
            declaredField.setAccessible(true);
            declaredField.set(this, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void U(View view) {
        com.baidu.swan.apps.ae.a.d fM;
        X(view);
        com.baidu.swan.apps.ae.a.c Lm = com.baidu.swan.apps.w.e.LE().Lm();
        if (Lm == null) {
            if (DEBUG) {
                Log.d("SwanAppBaseFragment", "config data is null. " + Log.getStackTraceString(new Exception()));
                return;
            }
            return;
        }
        if (this.aKe == null) {
            fM = Lm.bkk;
        } else {
            fM = com.baidu.swan.apps.w.e.LE().fM(this.aKe.getPage());
        }
        cY(fM.bkE);
        this.aKg.setTitle(fM.bkF);
        this.aKp = new C0177b(new Runnable() { // from class: com.baidu.swan.apps.core.d.b.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.y.f.MG();
            }
        });
        this.aKg.findViewById(a.f.titlebar_center_zone);
        if (!(this instanceof com.baidu.swan.apps.d.c)) {
            ev(fM.bkG);
        }
        this.aKi = fM.bkG;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void X(View view) {
        if (view != null) {
            this.aKg = (SwanAppActionBar) view.findViewById(a.f.ai_apps_title_bar);
            this.aKf = view.findViewById(a.f.ai_apps_title_bar_root);
            this.aKj = view.findViewById(a.f.title_shadow);
            this.aKg.setLeftBackViewMinWidth(z.dip2px(this.mActivity, 38.0f));
            this.aKg.setLeftBackViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    b.this.EE();
                }
            });
            this.aKg.setRightMenuOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    b.this.Ev();
                    com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                    fVar.mValue = "menu";
                    b.this.a(fVar);
                    if (b.this.aKp != null) {
                        b.this.aKp.onClick();
                    }
                }
            });
            this.aKg.setRightExitOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.mActivity != null && (b.this.mActivity instanceof SwanAppActivity)) {
                        ((SwanAppActivity) b.this.mActivity).cH(1);
                        if (((SwanAppActivity) b.this.mActivity).AN()) {
                            com.baidu.swan.apps.p.a IH = com.baidu.swan.apps.p.a.IH();
                            IH.a(b.this.mActivity, IH.IJ(), new a.InterfaceC0196a() { // from class: com.baidu.swan.apps.core.d.b.4.1
                                @Override // com.baidu.swan.apps.p.a.InterfaceC0196a
                                public void EW() {
                                    if (b.this.mActivity != null) {
                                        b.this.mActivity.moveTaskToBack(true);
                                        b.this.EA();
                                    }
                                }
                            });
                            return;
                        }
                        b.this.mActivity.moveTaskToBack(true);
                        b.this.EA();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EA() {
        HashMap hashMap = new HashMap();
        hashMap.put("lcType", "onClose");
        hashMap.put("appId", com.baidu.swan.apps.ae.b.Rm());
        com.baidu.swan.apps.w.e.LE().a(new com.baidu.swan.apps.m.a.c(hashMap));
        com.baidu.swan.apps.console.c.d("SwanAppBaseFragment", "onClose");
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "close";
        a(fVar);
    }

    public boolean cY(int i) {
        if (this.aKg == null || this.aKj == null) {
            return false;
        }
        this.aKn = i;
        this.aKg.setBackgroundColor(i);
        com.baidu.swan.apps.ae.a.d EK = EK();
        if (EK != null) {
            EK.bkE = i;
        }
        if (EJ()) {
            EL();
        }
        if (EC()) {
            this.aKj.setVisibility(0);
        } else {
            this.aKj.setVisibility(8);
        }
        return true;
    }

    public boolean a(FrameLayout frameLayout, int i) {
        if (frameLayout == null) {
            return false;
        }
        frameLayout.setBackgroundColor(i);
        com.baidu.swan.apps.ae.a.d EK = EK();
        if (EK != null) {
            EK.mBackgroundColor = i;
        }
        return true;
    }

    public SwanAppActionBar EB() {
        return this.aKg;
    }

    public boolean EC() {
        return this.aKn == -1;
    }

    public void setRightExitViewVisibility(boolean z) {
        this.aKg.setRightExitViewVisibility(z);
    }

    public void setRightZoneVisibility(boolean z) {
        this.aKg.setRightZoneVisibility(z);
    }

    public void bt(boolean z) {
        FloatButton RR = com.baidu.swan.apps.scheme.actions.c.a.RP().RR();
        if (!z) {
            if (RR != null && RR.getVisibility() == 0) {
                RR.setVisibility(8);
            }
        } else if (RR != null && RR.getVisibility() != 0) {
            RR.setVisibility(0);
        }
    }

    public void bu(boolean z) {
        b dc;
        e AI = com.baidu.swan.apps.w.e.LE().AI();
        if (AI != null) {
            if (z) {
                dc = AI.Fr();
            } else {
                dc = AI.dc(AI.Fu() - 1);
            }
            if (dc != null) {
                bt(dc.CC());
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (DEBUG) {
            Log.d("SwanAppBaseFragment", "onResume");
        }
        if (getUserVisibleHint()) {
            EM();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (EJ() && this.aKk != null && configuration.orientation == 1) {
            abT().getWindow().clearFlags(1024);
            ac.b(new Runnable() { // from class: com.baidu.swan.apps.core.d.b.5
                @Override // java.lang.Runnable
                public void run() {
                    b.this.EM();
                }
            }, 200L);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z) {
            EM();
        }
    }

    public void p(int i, String str) {
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
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.aKg, "alpha", 0.0f, 1.0f);
        ofFloat.setDuration(i);
        ofFloat.setInterpolator(accelerateDecelerateInterpolator);
        ofFloat.start();
        if (this.aKk != null && this.aKk.UQ() != null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.aKk.UQ(), "alpha", 0.0f, 1.0f);
            ofFloat2.setDuration(i);
            ofFloat2.setInterpolator(accelerateDecelerateInterpolator);
            ofFloat2.start();
        }
    }

    @Nullable
    public boolean eu(String str) {
        if (this.aKg == null) {
            return false;
        }
        this.aKg.setTitle(str);
        com.baidu.swan.apps.ae.a.d EK = EK();
        if (EK != null) {
            EK.bkF = str;
        }
        return true;
    }

    protected void ED() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void EE() {
        if (this.mActivity != null) {
            this.mActivity.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bv(boolean z) {
        this.aKg.setLeftBackViewVisibility(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void EF() {
        this.aKg.setLeftHomeViewVisibility(0);
        this.aKg.setLeftHomeViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.ED();
            }
        });
    }

    @Override // com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable() {
        return true;
    }

    public final e AI() {
        if (this.mActivity == null) {
            return null;
        }
        return ((SwanAppActivity) this.mActivity).AI();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean EG() {
        e AI = AI();
        if (AI == null) {
            return false;
        }
        return AI.Fu() > 1;
    }

    public void EH() {
        e AI = AI();
        if (AI == null || AI.Fu() == 1) {
            if (this.mActivity != null) {
                this.mActivity.moveTaskToBack(true);
                return;
            }
            return;
        }
        AI.eC("navigateBack").F(0, 0).Fz().commit();
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "back";
        a(fVar);
    }

    public void N(float f) {
        bw(true);
    }

    public void EI() {
        bw(false);
    }

    private void bw(boolean z) {
        e AI = AI();
        if (AI != null && AI.Fu() >= 2) {
            b dc = AI.dc(AI.Fu() - 2);
            if (z) {
                AI.Fv().e(dc);
            } else {
                AI.Fv().f(dc);
            }
        }
    }

    public final void a(com.baidu.swan.apps.statistic.a.f fVar) {
        if (this.mActivity instanceof SwanAppActivity) {
            ((SwanAppActivity) this.mActivity).a(fVar);
        }
    }

    public boolean ev(String str) {
        return cZ(com.baidu.swan.apps.ae.a.c.bR(str));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean cZ(@ColorInt int i) {
        if (this.aKg == null) {
            return false;
        }
        boolean z = this instanceof com.baidu.swan.apps.core.d.a;
        setRightExitViewVisibility(z ? false : true);
        return this.aKg.t(i, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean EJ() {
        return this.aKl;
    }

    protected com.baidu.swan.apps.ae.a.d EK() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View Y(View view) {
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
        this.aKk = new com.baidu.swan.apps.view.a.b(this.mActivity, frameLayout);
        EL();
        return frameLayout;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void EL() {
        if (this.aKk != null) {
            da(this.aKn);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void da(@ColorInt int i) {
        if (this.aKk != null) {
            n(i, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n(@ColorInt int i, boolean z) {
        if (this.aKk != null) {
            this.aKn = i;
            this.aKk.c(i, com.baidu.swan.apps.an.d.fw(i), z);
        }
    }

    public void EM() {
        if (EJ() && this.aKk != null) {
            this.aKk.EM();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setRequestedOrientation(int i) {
        if (this.mActivity != null) {
            this.mActivity.setRequestedOrientation(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View a(View view, SlideInterceptor slideInterceptor) {
        boolean z = getResources().getConfiguration().orientation != 2;
        this.aKm = new SlideHelper();
        View wrapSlideView = this.aKm.wrapSlideView(view.getContext(), view, slideInterceptor);
        this.aKm.setFadeColor(0);
        this.aKm.setCanSlide(z);
        this.aKm.setSlideListener(new SlidingPaneLayout.PanelSlideListener() { // from class: com.baidu.swan.apps.core.d.b.7
            @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
            public void onPanelSlide(View view2, float f) {
                View maskView = b.this.aKm.getMaskView();
                if (maskView != null) {
                    maskView.setAlpha(1.0f - f);
                }
                b.this.N(f);
            }

            @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
            public void onPanelOpened(View view2) {
                b.this.EH();
            }

            @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
            public void onPanelClosed(View view2) {
                b.this.EI();
            }
        });
        return wrapSlideView;
    }

    public final Resources EN() {
        return isAdded() ? getResources() : AppRuntime.getAppContext().getResources();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean EO() {
        if ((this.mActivity instanceof SwanAppActivity) && ((SwanAppActivity) this.mActivity).AC() == 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int AC() {
        if (this.mActivity instanceof SwanAppActivity) {
            return ((SwanAppActivity) this.mActivity).AC();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aV(Context context) {
        if (context != null) {
            if (this.aKo == null) {
                this.aKo = new a();
            }
            if (this.mAudioManager == null) {
                this.mAudioManager = (AudioManager) context.getSystemService("audio");
            }
            this.mAudioManager.requestAudioFocus(this.aKo, 3, 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void EP() {
        if (this.mAudioManager != null && this.aKo != null) {
            this.mAudioManager.abandonAudioFocus(this.aKo);
        }
    }

    /* loaded from: classes2.dex */
    private static class a implements AudioManager.OnAudioFocusChangeListener {
        private a() {
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
        }
    }

    public boolean EQ() {
        if (this.aKg == null) {
            return false;
        }
        this.aKg.db(true);
        return true;
    }

    public boolean ER() {
        if (this.aKg == null) {
            return false;
        }
        this.aKg.db(false);
        return true;
    }

    public void bx(boolean z) {
        if (this.aKg != null) {
            this.aKg.setActionBarCustom(z);
        }
        if (this.aKj != null) {
            int i = 8;
            if (!z && EC()) {
                i = 0;
            }
            this.aKj.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int ES() {
        if (TextUtils.isEmpty(com.baidu.swan.apps.ae.b.Rm()) || com.baidu.swan.apps.database.favorite.a.eU(com.baidu.swan.apps.ae.b.Rm())) {
            return 0;
        }
        if (com.baidu.swan.apps.database.favorite.a.eT(com.baidu.swan.apps.ae.b.Rm())) {
            return 2;
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean ET() {
        return "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u".equals(com.baidu.swan.apps.ae.b.Rm());
    }

    public void EU() {
        com.baidu.swan.apps.scheme.actions.i.a.z("backtohome", "menu", com.baidu.swan.apps.w.e.LE().Lp());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "gohome";
        fVar.mSource = "menu";
        a(fVar);
    }

    public void EV() {
    }

    /* renamed from: com.baidu.swan.apps.core.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private class C0177b {
        private int aKs = 0;
        private long aKt = 0;
        private Runnable aKu;

        C0177b(Runnable runnable) {
            this.aKu = runnable;
        }

        void onClick() {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.aKt > 1333) {
                this.aKt = currentTimeMillis;
                this.aKs = 1;
                return;
            }
            this.aKs++;
            if (this.aKs == 3) {
                if (this.aKu != null) {
                    this.aKu.run();
                }
                this.aKs = 0;
                this.aKt = 0L;
                return;
            }
            this.aKt = currentTimeMillis;
        }
    }
}
