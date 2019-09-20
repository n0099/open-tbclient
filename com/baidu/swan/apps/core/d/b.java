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
    protected com.baidu.swan.apps.model.c arg;
    protected View arh;
    protected SwanAppActionBar ari;
    protected com.baidu.swan.menu.g arj;
    protected String ark;
    protected View arl;
    @Nullable
    protected com.baidu.swan.apps.view.a.b arm;
    protected SlideHelper aro;
    private AudioManager.OnAudioFocusChangeListener arq;
    private C0145b arr;
    protected Activity mActivity;
    private AudioManager mAudioManager;
    private boolean arn = com.baidu.swan.apps.view.a.b.aOa;
    private int arp = 1;

    protected abstract boolean xH();

    public abstract boolean xt();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean zA();

    protected abstract void zy();

    protected abstract void zz();

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onAttach(Context context) {
        if (DEBUG) {
            Log.d("SwanAppBaseFragment", "onAttach");
        }
        super.onAttach(context);
        this.mActivity = Xg();
        bc(true);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDetach() {
        if (DEBUG) {
            Log.d("SwanAppBaseFragment", "onDetach");
        }
        this.mActivity = null;
        bc(false);
        super.onDetach();
        try {
            Field declaredField = Fragment.class.getDeclaredField("buS");
            declaredField.setAccessible(true);
            declaredField.set(this, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void O(View view) {
        com.baidu.swan.apps.ae.a.d ff;
        R(view);
        com.baidu.swan.apps.ae.a.c Gr = com.baidu.swan.apps.w.e.GJ().Gr();
        if (Gr == null) {
            if (DEBUG) {
                Log.d("SwanAppBaseFragment", "config data is null. " + Log.getStackTraceString(new Exception()));
                return;
            }
            return;
        }
        if (this.arg == null) {
            ff = Gr.aRy;
        } else {
            ff = com.baidu.swan.apps.w.e.GJ().ff(this.arg.getPage());
        }
        cc(ff.aRS);
        this.ari.setTitle(ff.aRT);
        this.arr = new C0145b(new Runnable() { // from class: com.baidu.swan.apps.core.d.b.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.y.f.HL();
            }
        });
        this.ari.findViewById(a.f.titlebar_center_zone);
        if (!(this instanceof com.baidu.swan.apps.d.c)) {
            dN(ff.aRU);
        }
        this.ark = ff.aRU;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void R(View view) {
        if (view != null) {
            this.ari = (SwanAppActionBar) view.findViewById(a.f.ai_apps_title_bar);
            this.arh = view.findViewById(a.f.ai_apps_title_bar_root);
            this.arl = view.findViewById(a.f.title_shadow);
            this.ari.setLeftBackViewMinWidth(z.dip2px(this.mActivity, 38.0f));
            this.ari.setLeftBackViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    b.this.zI();
                }
            });
            this.ari.setRightMenuOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    b.this.zz();
                    com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                    fVar.mValue = "menu";
                    b.this.a(fVar);
                    if (b.this.arr != null) {
                        b.this.arr.onClick();
                    }
                }
            });
            this.ari.setRightExitOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.mActivity != null && (b.this.mActivity instanceof SwanAppActivity)) {
                        ((SwanAppActivity) b.this.mActivity).bL(1);
                        if (((SwanAppActivity) b.this.mActivity).vS()) {
                            com.baidu.swan.apps.p.a DM = com.baidu.swan.apps.p.a.DM();
                            DM.a(b.this.mActivity, DM.DO(), new a.InterfaceC0164a() { // from class: com.baidu.swan.apps.core.d.b.4.1
                                @Override // com.baidu.swan.apps.p.a.InterfaceC0164a
                                public void Aa() {
                                    if (b.this.mActivity != null) {
                                        b.this.mActivity.moveTaskToBack(true);
                                        b.this.zE();
                                    }
                                }
                            });
                            return;
                        }
                        b.this.mActivity.moveTaskToBack(true);
                        b.this.zE();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zE() {
        HashMap hashMap = new HashMap();
        hashMap.put("lcType", "onClose");
        hashMap.put("appId", com.baidu.swan.apps.ae.b.Ms());
        com.baidu.swan.apps.w.e.GJ().a(new com.baidu.swan.apps.m.a.c(hashMap));
        com.baidu.swan.apps.console.c.d("SwanAppBaseFragment", "onClose");
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "close";
        a(fVar);
    }

    public boolean cc(int i) {
        if (this.ari == null || this.arl == null) {
            return false;
        }
        this.arp = i;
        this.ari.setBackgroundColor(i);
        com.baidu.swan.apps.ae.a.d zO = zO();
        if (zO != null) {
            zO.aRS = i;
        }
        if (zN()) {
            zP();
        }
        if (zG()) {
            this.arl.setVisibility(0);
        } else {
            this.arl.setVisibility(8);
        }
        return true;
    }

    public boolean a(FrameLayout frameLayout, int i) {
        if (frameLayout == null) {
            return false;
        }
        frameLayout.setBackgroundColor(i);
        com.baidu.swan.apps.ae.a.d zO = zO();
        if (zO != null) {
            zO.mBackgroundColor = i;
        }
        return true;
    }

    public SwanAppActionBar zF() {
        return this.ari;
    }

    public boolean zG() {
        return this.arp == -1;
    }

    public void setRightExitViewVisibility(boolean z) {
        this.ari.setRightExitViewVisibility(z);
    }

    public void setRightZoneVisibility(boolean z) {
        this.ari.setRightZoneVisibility(z);
    }

    public void bb(boolean z) {
        FloatButton MZ = com.baidu.swan.apps.scheme.actions.c.a.MX().MZ();
        if (!z) {
            if (MZ != null && MZ.getVisibility() == 0) {
                MZ.setVisibility(8);
            }
        } else if (MZ != null && MZ.getVisibility() != 0) {
            MZ.setVisibility(0);
        }
    }

    public void bc(boolean z) {
        b cg;
        e vN = com.baidu.swan.apps.w.e.GJ().vN();
        if (vN != null) {
            if (z) {
                cg = vN.Av();
            } else {
                cg = vN.cg(vN.Ay() - 1);
            }
            if (cg != null) {
                bb(cg.xH());
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
            zQ();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (zN() && this.arm != null && configuration.orientation == 1) {
            Xg().getWindow().clearFlags(1024);
            ac.b(new Runnable() { // from class: com.baidu.swan.apps.core.d.b.5
                @Override // java.lang.Runnable
                public void run() {
                    b.this.zQ();
                }
            }, 200L);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z) {
            zQ();
        }
    }

    public void l(int i, String str) {
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
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.ari, "alpha", 0.0f, 1.0f);
        ofFloat.setDuration(i);
        ofFloat.setInterpolator(accelerateDecelerateInterpolator);
        ofFloat.start();
        if (this.arm != null && this.arm.Qc() != null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.arm.Qc(), "alpha", 0.0f, 1.0f);
            ofFloat2.setDuration(i);
            ofFloat2.setInterpolator(accelerateDecelerateInterpolator);
            ofFloat2.start();
        }
    }

    @Nullable
    public boolean dM(String str) {
        if (this.ari == null) {
            return false;
        }
        this.ari.setTitle(str);
        com.baidu.swan.apps.ae.a.d zO = zO();
        if (zO != null) {
            zO.aRT = str;
        }
        return true;
    }

    protected void zH() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zI() {
        if (this.mActivity != null) {
            this.mActivity.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bd(boolean z) {
        this.ari.setLeftBackViewVisibility(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zJ() {
        this.ari.setLeftHomeViewVisibility(0);
        this.ari.setLeftHomeViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.zH();
            }
        });
    }

    @Override // com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable() {
        return true;
    }

    public final e vN() {
        if (this.mActivity == null) {
            return null;
        }
        return ((SwanAppActivity) this.mActivity).vN();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean zK() {
        e vN = vN();
        if (vN == null) {
            return false;
        }
        return vN.Ay() > 1;
    }

    public void zL() {
        e vN = vN();
        if (vN == null || vN.Ay() == 1) {
            if (this.mActivity != null) {
                this.mActivity.moveTaskToBack(true);
                return;
            }
            return;
        }
        vN.dU("navigateBack").B(0, 0).AD().commit();
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "back";
        a(fVar);
    }

    public void Y(float f) {
        be(true);
    }

    public void zM() {
        be(false);
    }

    private void be(boolean z) {
        e vN = vN();
        if (vN != null && vN.Ay() >= 2) {
            b cg = vN.cg(vN.Ay() - 2);
            if (z) {
                vN.Az().e(cg);
            } else {
                vN.Az().f(cg);
            }
        }
    }

    public final void a(com.baidu.swan.apps.statistic.a.f fVar) {
        if (this.mActivity instanceof SwanAppActivity) {
            ((SwanAppActivity) this.mActivity).a(fVar);
        }
    }

    public boolean dN(String str) {
        return cd(com.baidu.swan.apps.ae.a.c.cE(str));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean cd(@ColorInt int i) {
        if (this.ari == null) {
            return false;
        }
        boolean z = this instanceof com.baidu.swan.apps.core.d.a;
        setRightExitViewVisibility(z ? false : true);
        return this.ari.q(i, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean zN() {
        return this.arn;
    }

    protected com.baidu.swan.apps.ae.a.d zO() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View S(View view) {
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
        this.arm = new com.baidu.swan.apps.view.a.b(this.mActivity, frameLayout);
        zP();
        return frameLayout;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zP() {
        if (this.arm != null) {
            ce(this.arp);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ce(@ColorInt int i) {
        if (this.arm != null) {
            l(i, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l(@ColorInt int i, boolean z) {
        if (this.arm != null) {
            this.arp = i;
            this.arm.c(i, com.baidu.swan.apps.an.d.eC(i), z);
        }
    }

    public void zQ() {
        if (zN() && this.arm != null) {
            this.arm.zQ();
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
        this.aro = new SlideHelper();
        View wrapSlideView = this.aro.wrapSlideView(view.getContext(), view, slideInterceptor);
        this.aro.setFadeColor(0);
        this.aro.setCanSlide(z);
        this.aro.setSlideListener(new SlidingPaneLayout.PanelSlideListener() { // from class: com.baidu.swan.apps.core.d.b.7
            @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
            public void onPanelSlide(View view2, float f) {
                View maskView = b.this.aro.getMaskView();
                if (maskView != null) {
                    maskView.setAlpha(1.0f - f);
                }
                b.this.Y(f);
            }

            @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
            public void onPanelOpened(View view2) {
                b.this.zL();
            }

            @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
            public void onPanelClosed(View view2) {
                b.this.zM();
            }
        });
        return wrapSlideView;
    }

    public final Resources zR() {
        return isAdded() ? getResources() : AppRuntime.getAppContext().getResources();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean zS() {
        if ((this.mActivity instanceof SwanAppActivity) && ((SwanAppActivity) this.mActivity).vH() == 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int vH() {
        if (this.mActivity instanceof SwanAppActivity) {
            return ((SwanAppActivity) this.mActivity).vH();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aT(Context context) {
        if (context != null) {
            if (this.arq == null) {
                this.arq = new a();
            }
            if (this.mAudioManager == null) {
                this.mAudioManager = (AudioManager) context.getSystemService("audio");
            }
            this.mAudioManager.requestAudioFocus(this.arq, 3, 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zT() {
        if (this.mAudioManager != null && this.arq != null) {
            this.mAudioManager.abandonAudioFocus(this.arq);
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

    public boolean zU() {
        if (this.ari == null) {
            return false;
        }
        this.ari.cK(true);
        return true;
    }

    public boolean zV() {
        if (this.ari == null) {
            return false;
        }
        this.ari.cK(false);
        return true;
    }

    public void bf(boolean z) {
        if (this.ari != null) {
            this.ari.setActionBarCustom(z);
        }
        if (this.arl != null) {
            int i = 8;
            if (!z && zG()) {
                i = 0;
            }
            this.arl.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int zW() {
        if (TextUtils.isEmpty(com.baidu.swan.apps.ae.b.Ms()) || com.baidu.swan.apps.database.favorite.a.en(com.baidu.swan.apps.ae.b.Ms())) {
            return 0;
        }
        if (com.baidu.swan.apps.database.favorite.a.em(com.baidu.swan.apps.ae.b.Ms())) {
            return 2;
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean zX() {
        return "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u".equals(com.baidu.swan.apps.ae.b.Ms());
    }

    public void zY() {
        com.baidu.swan.apps.scheme.actions.i.a.t("backtohome", "menu", com.baidu.swan.apps.w.e.GJ().Gu());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "gohome";
        fVar.mSource = "menu";
        a(fVar);
    }

    public void zZ() {
    }

    /* renamed from: com.baidu.swan.apps.core.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private class C0145b {
        private Runnable arv;
        private int aru = 0;
        private long mLastTimestamp = 0;

        C0145b(Runnable runnable) {
            this.arv = runnable;
        }

        void onClick() {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.mLastTimestamp > 1333) {
                this.mLastTimestamp = currentTimeMillis;
                this.aru = 1;
                return;
            }
            this.aru++;
            if (this.aru == 3) {
                if (this.arv != null) {
                    this.arv.run();
                }
                this.aru = 0;
                this.mLastTimestamp = 0L;
                return;
            }
            this.mLastTimestamp = currentTimeMillis;
        }
    }
}
