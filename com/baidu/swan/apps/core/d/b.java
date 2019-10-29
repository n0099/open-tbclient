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
    protected String aKA;
    protected View aKB;
    @Nullable
    protected com.baidu.swan.apps.view.a.b aKC;
    protected SlideHelper aKE;
    private AudioManager.OnAudioFocusChangeListener aKG;
    private C0177b aKH;
    protected com.baidu.swan.apps.model.c aKw;
    protected View aKx;
    protected SwanAppActionBar aKy;
    protected com.baidu.swan.menu.g aKz;
    protected Activity mActivity;
    private AudioManager mAudioManager;
    private boolean aKD = com.baidu.swan.apps.view.a.b.bhi;
    private int aKF = 1;

    protected abstract boolean CB();

    public abstract boolean Cn();

    protected abstract void Et();

    protected abstract void Eu();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean Ev();

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onAttach(Context context) {
        if (DEBUG) {
            Log.d("SwanAppBaseFragment", "onAttach");
        }
        super.onAttach(context);
        this.mActivity = abV();
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
            Field declaredField = Fragment.class.getDeclaredField("bNB");
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
        com.baidu.swan.apps.ae.a.c Ll = com.baidu.swan.apps.w.e.LD().Ll();
        if (Ll == null) {
            if (DEBUG) {
                Log.d("SwanAppBaseFragment", "config data is null. " + Log.getStackTraceString(new Exception()));
                return;
            }
            return;
        }
        if (this.aKw == null) {
            fM = Ll.bkC;
        } else {
            fM = com.baidu.swan.apps.w.e.LD().fM(this.aKw.getPage());
        }
        cY(fM.bkW);
        this.aKy.setTitle(fM.bkX);
        this.aKH = new C0177b(new Runnable() { // from class: com.baidu.swan.apps.core.d.b.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.y.f.MF();
            }
        });
        this.aKy.findViewById(a.f.titlebar_center_zone);
        if (!(this instanceof com.baidu.swan.apps.d.c)) {
            ev(fM.bkY);
        }
        this.aKA = fM.bkY;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void X(View view) {
        if (view != null) {
            this.aKy = (SwanAppActionBar) view.findViewById(a.f.ai_apps_title_bar);
            this.aKx = view.findViewById(a.f.ai_apps_title_bar_root);
            this.aKB = view.findViewById(a.f.title_shadow);
            this.aKy.setLeftBackViewMinWidth(z.dip2px(this.mActivity, 38.0f));
            this.aKy.setLeftBackViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    b.this.ED();
                }
            });
            this.aKy.setRightMenuOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    b.this.Eu();
                    com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                    fVar.mValue = "menu";
                    b.this.a(fVar);
                    if (b.this.aKH != null) {
                        b.this.aKH.onClick();
                    }
                }
            });
            this.aKy.setRightExitOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.mActivity != null && (b.this.mActivity instanceof SwanAppActivity)) {
                        ((SwanAppActivity) b.this.mActivity).cH(1);
                        if (((SwanAppActivity) b.this.mActivity).AM()) {
                            com.baidu.swan.apps.p.a IG = com.baidu.swan.apps.p.a.IG();
                            IG.a(b.this.mActivity, IG.II(), new a.InterfaceC0196a() { // from class: com.baidu.swan.apps.core.d.b.4.1
                                @Override // com.baidu.swan.apps.p.a.InterfaceC0196a
                                public void EV() {
                                    if (b.this.mActivity != null) {
                                        b.this.mActivity.moveTaskToBack(true);
                                        b.this.Ez();
                                    }
                                }
                            });
                            return;
                        }
                        b.this.mActivity.moveTaskToBack(true);
                        b.this.Ez();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ez() {
        HashMap hashMap = new HashMap();
        hashMap.put("lcType", "onClose");
        hashMap.put("appId", com.baidu.swan.apps.ae.b.Rk());
        com.baidu.swan.apps.w.e.LD().a(new com.baidu.swan.apps.m.a.c(hashMap));
        com.baidu.swan.apps.console.c.d("SwanAppBaseFragment", "onClose");
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "close";
        a(fVar);
    }

    public boolean cY(int i) {
        if (this.aKy == null || this.aKB == null) {
            return false;
        }
        this.aKF = i;
        this.aKy.setBackgroundColor(i);
        com.baidu.swan.apps.ae.a.d EJ = EJ();
        if (EJ != null) {
            EJ.bkW = i;
        }
        if (EI()) {
            EK();
        }
        if (EB()) {
            this.aKB.setVisibility(0);
        } else {
            this.aKB.setVisibility(8);
        }
        return true;
    }

    public boolean a(FrameLayout frameLayout, int i) {
        if (frameLayout == null) {
            return false;
        }
        frameLayout.setBackgroundColor(i);
        com.baidu.swan.apps.ae.a.d EJ = EJ();
        if (EJ != null) {
            EJ.mBackgroundColor = i;
        }
        return true;
    }

    public SwanAppActionBar EA() {
        return this.aKy;
    }

    public boolean EB() {
        return this.aKF == -1;
    }

    public void setRightExitViewVisibility(boolean z) {
        this.aKy.setRightExitViewVisibility(z);
    }

    public void setRightZoneVisibility(boolean z) {
        this.aKy.setRightZoneVisibility(z);
    }

    public void bt(boolean z) {
        FloatButton RP = com.baidu.swan.apps.scheme.actions.c.a.RN().RP();
        if (!z) {
            if (RP != null && RP.getVisibility() == 0) {
                RP.setVisibility(8);
            }
        } else if (RP != null && RP.getVisibility() != 0) {
            RP.setVisibility(0);
        }
    }

    public void bu(boolean z) {
        b dc;
        e AH = com.baidu.swan.apps.w.e.LD().AH();
        if (AH != null) {
            if (z) {
                dc = AH.Fq();
            } else {
                dc = AH.dc(AH.Ft() - 1);
            }
            if (dc != null) {
                bt(dc.CB());
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
            EL();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (EI() && this.aKC != null && configuration.orientation == 1) {
            abV().getWindow().clearFlags(1024);
            ac.b(new Runnable() { // from class: com.baidu.swan.apps.core.d.b.5
                @Override // java.lang.Runnable
                public void run() {
                    b.this.EL();
                }
            }, 200L);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z) {
            EL();
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
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.aKy, "alpha", 0.0f, 1.0f);
        ofFloat.setDuration(i);
        ofFloat.setInterpolator(accelerateDecelerateInterpolator);
        ofFloat.start();
        if (this.aKC != null && this.aKC.US() != null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.aKC.US(), "alpha", 0.0f, 1.0f);
            ofFloat2.setDuration(i);
            ofFloat2.setInterpolator(accelerateDecelerateInterpolator);
            ofFloat2.start();
        }
    }

    @Nullable
    public boolean eu(String str) {
        if (this.aKy == null) {
            return false;
        }
        this.aKy.setTitle(str);
        com.baidu.swan.apps.ae.a.d EJ = EJ();
        if (EJ != null) {
            EJ.bkX = str;
        }
        return true;
    }

    protected void EC() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ED() {
        if (this.mActivity != null) {
            this.mActivity.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bv(boolean z) {
        this.aKy.setLeftBackViewVisibility(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void EE() {
        this.aKy.setLeftHomeViewVisibility(0);
        this.aKy.setLeftHomeViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.EC();
            }
        });
    }

    @Override // com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable() {
        return true;
    }

    public final e AH() {
        if (this.mActivity == null) {
            return null;
        }
        return ((SwanAppActivity) this.mActivity).AH();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean EF() {
        e AH = AH();
        if (AH == null) {
            return false;
        }
        return AH.Ft() > 1;
    }

    public void EG() {
        e AH = AH();
        if (AH == null || AH.Ft() == 1) {
            if (this.mActivity != null) {
                this.mActivity.moveTaskToBack(true);
                return;
            }
            return;
        }
        AH.eC("navigateBack").H(0, 0).Fy().commit();
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "back";
        a(fVar);
    }

    public void N(float f) {
        bw(true);
    }

    public void EH() {
        bw(false);
    }

    private void bw(boolean z) {
        e AH = AH();
        if (AH != null && AH.Ft() >= 2) {
            b dc = AH.dc(AH.Ft() - 2);
            if (z) {
                AH.Fu().e(dc);
            } else {
                AH.Fu().f(dc);
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
        if (this.aKy == null) {
            return false;
        }
        boolean z = this instanceof com.baidu.swan.apps.core.d.a;
        setRightExitViewVisibility(z ? false : true);
        return this.aKy.t(i, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean EI() {
        return this.aKD;
    }

    protected com.baidu.swan.apps.ae.a.d EJ() {
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
        this.aKC = new com.baidu.swan.apps.view.a.b(this.mActivity, frameLayout);
        EK();
        return frameLayout;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void EK() {
        if (this.aKC != null) {
            da(this.aKF);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void da(@ColorInt int i) {
        if (this.aKC != null) {
            n(i, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n(@ColorInt int i, boolean z) {
        if (this.aKC != null) {
            this.aKF = i;
            this.aKC.c(i, com.baidu.swan.apps.an.d.fx(i), z);
        }
    }

    public void EL() {
        if (EI() && this.aKC != null) {
            this.aKC.EL();
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
        this.aKE = new SlideHelper();
        View wrapSlideView = this.aKE.wrapSlideView(view.getContext(), view, slideInterceptor);
        this.aKE.setFadeColor(0);
        this.aKE.setCanSlide(z);
        this.aKE.setSlideListener(new SlidingPaneLayout.PanelSlideListener() { // from class: com.baidu.swan.apps.core.d.b.7
            @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
            public void onPanelSlide(View view2, float f) {
                View maskView = b.this.aKE.getMaskView();
                if (maskView != null) {
                    maskView.setAlpha(1.0f - f);
                }
                b.this.N(f);
            }

            @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
            public void onPanelOpened(View view2) {
                b.this.EG();
            }

            @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
            public void onPanelClosed(View view2) {
                b.this.EH();
            }
        });
        return wrapSlideView;
    }

    public final Resources EM() {
        return isAdded() ? getResources() : AppRuntime.getAppContext().getResources();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean EN() {
        if ((this.mActivity instanceof SwanAppActivity) && ((SwanAppActivity) this.mActivity).AB() == 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int AB() {
        if (this.mActivity instanceof SwanAppActivity) {
            return ((SwanAppActivity) this.mActivity).AB();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aV(Context context) {
        if (context != null) {
            if (this.aKG == null) {
                this.aKG = new a();
            }
            if (this.mAudioManager == null) {
                this.mAudioManager = (AudioManager) context.getSystemService("audio");
            }
            this.mAudioManager.requestAudioFocus(this.aKG, 3, 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void EO() {
        if (this.mAudioManager != null && this.aKG != null) {
            this.mAudioManager.abandonAudioFocus(this.aKG);
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

    public boolean EP() {
        if (this.aKy == null) {
            return false;
        }
        this.aKy.db(true);
        return true;
    }

    public boolean EQ() {
        if (this.aKy == null) {
            return false;
        }
        this.aKy.db(false);
        return true;
    }

    public void bx(boolean z) {
        if (this.aKy != null) {
            this.aKy.setActionBarCustom(z);
        }
        if (this.aKB != null) {
            int i = 8;
            if (!z && EB()) {
                i = 0;
            }
            this.aKB.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int ER() {
        if (TextUtils.isEmpty(com.baidu.swan.apps.ae.b.Rk()) || com.baidu.swan.apps.database.favorite.a.eU(com.baidu.swan.apps.ae.b.Rk())) {
            return 0;
        }
        if (com.baidu.swan.apps.database.favorite.a.eT(com.baidu.swan.apps.ae.b.Rk())) {
            return 2;
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean ES() {
        return "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u".equals(com.baidu.swan.apps.ae.b.Rk());
    }

    public void ET() {
        com.baidu.swan.apps.scheme.actions.i.a.z("backtohome", "menu", com.baidu.swan.apps.w.e.LD().Lo());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "gohome";
        fVar.mSource = "menu";
        a(fVar);
    }

    public void EU() {
    }

    /* renamed from: com.baidu.swan.apps.core.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private class C0177b {
        private int aKK = 0;
        private long aKL = 0;
        private Runnable aKM;

        C0177b(Runnable runnable) {
            this.aKM = runnable;
        }

        void onClick() {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.aKL > 1333) {
                this.aKL = currentTimeMillis;
                this.aKK = 1;
                return;
            }
            this.aKK++;
            if (this.aKK == 3) {
                if (this.aKM != null) {
                    this.aKM.run();
                }
                this.aKK = 0;
                this.aKL = 0L;
                return;
            }
            this.aKL = currentTimeMillis;
        }
    }
}
