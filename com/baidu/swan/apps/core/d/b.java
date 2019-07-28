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
    protected com.baidu.swan.apps.model.c aqI;
    protected View aqJ;
    protected SwanAppActionBar aqK;
    protected com.baidu.swan.menu.g aqL;
    protected String aqM;
    protected View aqN;
    @Nullable
    protected com.baidu.swan.apps.view.a.b aqO;
    protected SlideHelper aqQ;
    private AudioManager.OnAudioFocusChangeListener aqS;
    private C0136b aqT;
    protected Activity mActivity;
    private AudioManager mAudioManager;
    private boolean aqP = com.baidu.swan.apps.view.a.b.aNC;
    private int aqR = 1;

    protected abstract boolean xD();

    public abstract boolean xp();

    protected abstract void zu();

    protected abstract void zv();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean zw();

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onAttach(Context context) {
        if (DEBUG) {
            Log.d("SwanAppBaseFragment", "onAttach");
        }
        super.onAttach(context);
        this.mActivity = Xc();
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
            Field declaredField = Fragment.class.getDeclaredField("buu");
            declaredField.setAccessible(true);
            declaredField.set(this, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void O(View view) {
        com.baidu.swan.apps.ae.a.d fd;
        R(view);
        com.baidu.swan.apps.ae.a.c Gn = com.baidu.swan.apps.w.e.GF().Gn();
        if (Gn == null) {
            if (DEBUG) {
                Log.d("SwanAppBaseFragment", "config data is null. " + Log.getStackTraceString(new Exception()));
                return;
            }
            return;
        }
        if (this.aqI == null) {
            fd = Gn.aRa;
        } else {
            fd = com.baidu.swan.apps.w.e.GF().fd(this.aqI.getPage());
        }
        cb(fd.aRu);
        this.aqK.setTitle(fd.aRv);
        this.aqT = new C0136b(new Runnable() { // from class: com.baidu.swan.apps.core.d.b.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.y.f.HH();
            }
        });
        this.aqK.findViewById(a.f.titlebar_center_zone);
        if (!(this instanceof com.baidu.swan.apps.d.c)) {
            dL(fd.aRw);
        }
        this.aqM = fd.aRw;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void R(View view) {
        if (view != null) {
            this.aqK = (SwanAppActionBar) view.findViewById(a.f.ai_apps_title_bar);
            this.aqJ = view.findViewById(a.f.ai_apps_title_bar_root);
            this.aqN = view.findViewById(a.f.title_shadow);
            this.aqK.setLeftBackViewMinWidth(z.dip2px(this.mActivity, 38.0f));
            this.aqK.setLeftBackViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    b.this.zE();
                }
            });
            this.aqK.setRightMenuOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    b.this.zv();
                    com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                    fVar.mValue = "menu";
                    b.this.a(fVar);
                    if (b.this.aqT != null) {
                        b.this.aqT.onClick();
                    }
                }
            });
            this.aqK.setRightExitOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.mActivity != null && (b.this.mActivity instanceof SwanAppActivity)) {
                        ((SwanAppActivity) b.this.mActivity).bK(1);
                        if (((SwanAppActivity) b.this.mActivity).vO()) {
                            com.baidu.swan.apps.p.a DI = com.baidu.swan.apps.p.a.DI();
                            DI.a(b.this.mActivity, DI.DK(), new a.InterfaceC0155a() { // from class: com.baidu.swan.apps.core.d.b.4.1
                                @Override // com.baidu.swan.apps.p.a.InterfaceC0155a
                                public void zW() {
                                    if (b.this.mActivity != null) {
                                        b.this.mActivity.moveTaskToBack(true);
                                        b.this.zA();
                                    }
                                }
                            });
                            return;
                        }
                        b.this.mActivity.moveTaskToBack(true);
                        b.this.zA();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zA() {
        HashMap hashMap = new HashMap();
        hashMap.put("lcType", "onClose");
        hashMap.put("appId", com.baidu.swan.apps.ae.b.Mo());
        com.baidu.swan.apps.w.e.GF().a(new com.baidu.swan.apps.m.a.c(hashMap));
        com.baidu.swan.apps.console.c.d("SwanAppBaseFragment", "onClose");
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "close";
        a(fVar);
    }

    public boolean cb(int i) {
        if (this.aqK == null || this.aqN == null) {
            return false;
        }
        this.aqR = i;
        this.aqK.setBackgroundColor(i);
        com.baidu.swan.apps.ae.a.d zK = zK();
        if (zK != null) {
            zK.aRu = i;
        }
        if (zJ()) {
            zL();
        }
        if (zC()) {
            this.aqN.setVisibility(0);
        } else {
            this.aqN.setVisibility(8);
        }
        return true;
    }

    public boolean a(FrameLayout frameLayout, int i) {
        if (frameLayout == null) {
            return false;
        }
        frameLayout.setBackgroundColor(i);
        com.baidu.swan.apps.ae.a.d zK = zK();
        if (zK != null) {
            zK.mBackgroundColor = i;
        }
        return true;
    }

    public SwanAppActionBar zB() {
        return this.aqK;
    }

    public boolean zC() {
        return this.aqR == -1;
    }

    public void setRightExitViewVisibility(boolean z) {
        this.aqK.setRightExitViewVisibility(z);
    }

    public void setRightZoneVisibility(boolean z) {
        this.aqK.setRightZoneVisibility(z);
    }

    public void bb(boolean z) {
        FloatButton MV = com.baidu.swan.apps.scheme.actions.c.a.MT().MV();
        if (!z) {
            if (MV != null && MV.getVisibility() == 0) {
                MV.setVisibility(8);
            }
        } else if (MV != null && MV.getVisibility() != 0) {
            MV.setVisibility(0);
        }
    }

    public void bc(boolean z) {
        b cf;
        e vJ = com.baidu.swan.apps.w.e.GF().vJ();
        if (vJ != null) {
            if (z) {
                cf = vJ.Ar();
            } else {
                cf = vJ.cf(vJ.Au() - 1);
            }
            if (cf != null) {
                bb(cf.xD());
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
            zM();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (zJ() && this.aqO != null && configuration.orientation == 1) {
            Xc().getWindow().clearFlags(1024);
            ac.b(new Runnable() { // from class: com.baidu.swan.apps.core.d.b.5
                @Override // java.lang.Runnable
                public void run() {
                    b.this.zM();
                }
            }, 200L);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z) {
            zM();
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
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.aqK, "alpha", 0.0f, 1.0f);
        ofFloat.setDuration(i);
        ofFloat.setInterpolator(accelerateDecelerateInterpolator);
        ofFloat.start();
        if (this.aqO != null && this.aqO.PY() != null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.aqO.PY(), "alpha", 0.0f, 1.0f);
            ofFloat2.setDuration(i);
            ofFloat2.setInterpolator(accelerateDecelerateInterpolator);
            ofFloat2.start();
        }
    }

    @Nullable
    public boolean dK(String str) {
        if (this.aqK == null) {
            return false;
        }
        this.aqK.setTitle(str);
        com.baidu.swan.apps.ae.a.d zK = zK();
        if (zK != null) {
            zK.aRv = str;
        }
        return true;
    }

    protected void zD() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zE() {
        if (this.mActivity != null) {
            this.mActivity.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bd(boolean z) {
        this.aqK.setLeftBackViewVisibility(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zF() {
        this.aqK.setLeftHomeViewVisibility(0);
        this.aqK.setLeftHomeViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.zD();
            }
        });
    }

    @Override // com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable() {
        return true;
    }

    public final e vJ() {
        if (this.mActivity == null) {
            return null;
        }
        return ((SwanAppActivity) this.mActivity).vJ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean zG() {
        e vJ = vJ();
        if (vJ == null) {
            return false;
        }
        return vJ.Au() > 1;
    }

    public void zH() {
        e vJ = vJ();
        if (vJ == null || vJ.Au() == 1) {
            if (this.mActivity != null) {
                this.mActivity.moveTaskToBack(true);
                return;
            }
            return;
        }
        vJ.dS("navigateBack").B(0, 0).Az().commit();
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "back";
        a(fVar);
    }

    public void Y(float f) {
        be(true);
    }

    public void zI() {
        be(false);
    }

    private void be(boolean z) {
        e vJ = vJ();
        if (vJ != null && vJ.Au() >= 2) {
            b cf = vJ.cf(vJ.Au() - 2);
            if (z) {
                vJ.Av().e(cf);
            } else {
                vJ.Av().f(cf);
            }
        }
    }

    public final void a(com.baidu.swan.apps.statistic.a.f fVar) {
        if (this.mActivity instanceof SwanAppActivity) {
            ((SwanAppActivity) this.mActivity).a(fVar);
        }
    }

    public boolean dL(String str) {
        return cc(com.baidu.swan.apps.ae.a.c.cE(str));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean cc(@ColorInt int i) {
        if (this.aqK == null) {
            return false;
        }
        boolean z = this instanceof com.baidu.swan.apps.core.d.a;
        setRightExitViewVisibility(z ? false : true);
        return this.aqK.q(i, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean zJ() {
        return this.aqP;
    }

    protected com.baidu.swan.apps.ae.a.d zK() {
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
        this.aqO = new com.baidu.swan.apps.view.a.b(this.mActivity, frameLayout);
        zL();
        return frameLayout;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zL() {
        if (this.aqO != null) {
            cd(this.aqR);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cd(@ColorInt int i) {
        if (this.aqO != null) {
            l(i, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l(@ColorInt int i, boolean z) {
        if (this.aqO != null) {
            this.aqR = i;
            this.aqO.c(i, com.baidu.swan.apps.an.d.eB(i), z);
        }
    }

    public void zM() {
        if (zJ() && this.aqO != null) {
            this.aqO.zM();
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
        this.aqQ = new SlideHelper();
        View wrapSlideView = this.aqQ.wrapSlideView(view.getContext(), view, slideInterceptor);
        this.aqQ.setFadeColor(0);
        this.aqQ.setCanSlide(z);
        this.aqQ.setSlideListener(new SlidingPaneLayout.PanelSlideListener() { // from class: com.baidu.swan.apps.core.d.b.7
            @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
            public void onPanelSlide(View view2, float f) {
                View maskView = b.this.aqQ.getMaskView();
                if (maskView != null) {
                    maskView.setAlpha(1.0f - f);
                }
                b.this.Y(f);
            }

            @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
            public void onPanelOpened(View view2) {
                b.this.zH();
            }

            @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
            public void onPanelClosed(View view2) {
                b.this.zI();
            }
        });
        return wrapSlideView;
    }

    public final Resources zN() {
        return isAdded() ? getResources() : AppRuntime.getAppContext().getResources();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean zO() {
        if ((this.mActivity instanceof SwanAppActivity) && ((SwanAppActivity) this.mActivity).vD() == 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int vD() {
        if (this.mActivity instanceof SwanAppActivity) {
            return ((SwanAppActivity) this.mActivity).vD();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aT(Context context) {
        if (context != null) {
            if (this.aqS == null) {
                this.aqS = new a();
            }
            if (this.mAudioManager == null) {
                this.mAudioManager = (AudioManager) context.getSystemService("audio");
            }
            this.mAudioManager.requestAudioFocus(this.aqS, 3, 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zP() {
        if (this.mAudioManager != null && this.aqS != null) {
            this.mAudioManager.abandonAudioFocus(this.aqS);
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

    public boolean zQ() {
        if (this.aqK == null) {
            return false;
        }
        this.aqK.cK(true);
        return true;
    }

    public boolean zR() {
        if (this.aqK == null) {
            return false;
        }
        this.aqK.cK(false);
        return true;
    }

    public void bf(boolean z) {
        if (this.aqK != null) {
            this.aqK.setActionBarCustom(z);
        }
        if (this.aqN != null) {
            int i = 8;
            if (!z && zC()) {
                i = 0;
            }
            this.aqN.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int zS() {
        if (TextUtils.isEmpty(com.baidu.swan.apps.ae.b.Mo()) || com.baidu.swan.apps.database.favorite.a.el(com.baidu.swan.apps.ae.b.Mo())) {
            return 0;
        }
        if (com.baidu.swan.apps.database.favorite.a.ek(com.baidu.swan.apps.ae.b.Mo())) {
            return 2;
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean zT() {
        return "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u".equals(com.baidu.swan.apps.ae.b.Mo());
    }

    public void zU() {
        com.baidu.swan.apps.scheme.actions.i.a.t("backtohome", "menu", com.baidu.swan.apps.w.e.GF().Gq());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "gohome";
        fVar.mSource = "menu";
        a(fVar);
    }

    public void zV() {
    }

    /* renamed from: com.baidu.swan.apps.core.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private class C0136b {
        private Runnable aqX;
        private int aqW = 0;
        private long mLastTimestamp = 0;

        C0136b(Runnable runnable) {
            this.aqX = runnable;
        }

        void onClick() {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.mLastTimestamp > 1333) {
                this.mLastTimestamp = currentTimeMillis;
                this.aqW = 1;
                return;
            }
            this.aqW++;
            if (this.aqW == 3) {
                if (this.aqX != null) {
                    this.aqX.run();
                }
                this.aqW = 0;
                this.mLastTimestamp = 0L;
                return;
            }
            this.mLastTimestamp = currentTimeMillis;
        }
    }
}
