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
    protected com.baidu.swan.apps.model.c aqf;
    protected View aqg;
    protected SwanAppActionBar aqh;
    protected com.baidu.swan.menu.g aqi;
    protected String aqj;
    protected View aqk;
    @Nullable
    protected com.baidu.swan.apps.view.a.b aql;
    protected SlideHelper aqn;
    private AudioManager.OnAudioFocusChangeListener aqp;
    private C0134b aqq;
    protected Activity mActivity;
    private AudioManager mAudioManager;
    private boolean aqm = com.baidu.swan.apps.view.a.b.aMT;
    private int aqo = 1;

    public abstract boolean wO();

    protected abstract boolean xc();

    protected abstract void yN();

    protected abstract void yO();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean yP();

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onAttach(Context context) {
        if (DEBUG) {
            Log.d("SwanAppBaseFragment", "onAttach");
        }
        super.onAttach(context);
        this.mActivity = Wi();
        aZ(true);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDetach() {
        if (DEBUG) {
            Log.d("SwanAppBaseFragment", "onDetach");
        }
        this.mActivity = null;
        aZ(false);
        super.onDetach();
        try {
            Field declaredField = Fragment.class.getDeclaredField("btD");
            declaredField.setAccessible(true);
            declaredField.set(this, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void M(View view) {
        com.baidu.swan.apps.ae.a.d eZ;
        P(view);
        com.baidu.swan.apps.ae.a.c FD = com.baidu.swan.apps.w.e.FV().FD();
        if (FD == null) {
            if (DEBUG) {
                Log.d("SwanAppBaseFragment", "config data is null. " + Log.getStackTraceString(new Exception()));
                return;
            }
            return;
        }
        if (this.aqf == null) {
            eZ = FD.aQq;
        } else {
            eZ = com.baidu.swan.apps.w.e.FV().eZ(this.aqf.getPage());
        }
        cb(eZ.aQK);
        this.aqh.setTitle(eZ.aQL);
        this.aqq = new C0134b(new Runnable() { // from class: com.baidu.swan.apps.core.d.b.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.y.f.GW();
            }
        });
        this.aqh.findViewById(a.f.titlebar_center_zone);
        if (!(this instanceof com.baidu.swan.apps.d.b)) {
            dH(eZ.aQM);
        }
        this.aqj = eZ.aQM;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void P(View view) {
        if (view != null) {
            this.aqh = (SwanAppActionBar) view.findViewById(a.f.ai_apps_title_bar);
            this.aqg = view.findViewById(a.f.ai_apps_title_bar_root);
            this.aqk = view.findViewById(a.f.title_shadow);
            this.aqh.setLeftBackViewMinWidth(z.dip2px(this.mActivity, 38.0f));
            this.aqh.setLeftBackViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    b.this.yX();
                }
            });
            this.aqh.setRightMenuOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    b.this.yO();
                    com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                    fVar.mValue = "menu";
                    b.this.a(fVar);
                    if (b.this.aqq != null) {
                        b.this.aqq.onClick();
                    }
                }
            });
            this.aqh.setRightExitOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.mActivity != null && (b.this.mActivity instanceof SwanAppActivity)) {
                        ((SwanAppActivity) b.this.mActivity).bK(1);
                        if (((SwanAppActivity) b.this.mActivity).vn()) {
                            com.baidu.swan.apps.p.a CZ = com.baidu.swan.apps.p.a.CZ();
                            CZ.a(b.this.mActivity, CZ.Db(), new a.InterfaceC0153a() { // from class: com.baidu.swan.apps.core.d.b.4.1
                                @Override // com.baidu.swan.apps.p.a.InterfaceC0153a
                                public void zp() {
                                    if (b.this.mActivity != null) {
                                        b.this.mActivity.moveTaskToBack(true);
                                        b.this.yT();
                                    }
                                }
                            });
                            return;
                        }
                        b.this.mActivity.moveTaskToBack(true);
                        b.this.yT();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yT() {
        HashMap hashMap = new HashMap();
        hashMap.put("lcType", "onClose");
        hashMap.put("appId", com.baidu.swan.apps.ae.b.LB());
        com.baidu.swan.apps.w.e.FV().a(new com.baidu.swan.apps.m.a.c(hashMap));
        com.baidu.swan.apps.console.c.d("SwanAppBaseFragment", "onClose");
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "close";
        a(fVar);
    }

    public boolean cb(int i) {
        if (this.aqh == null || this.aqk == null) {
            return false;
        }
        this.aqo = i;
        this.aqh.setBackgroundColor(i);
        com.baidu.swan.apps.ae.a.d zd = zd();
        if (zd != null) {
            zd.aQK = i;
        }
        if (zc()) {
            ze();
        }
        if (yV()) {
            this.aqk.setVisibility(0);
        } else {
            this.aqk.setVisibility(8);
        }
        return true;
    }

    public boolean a(FrameLayout frameLayout, int i) {
        if (frameLayout == null) {
            return false;
        }
        frameLayout.setBackgroundColor(i);
        com.baidu.swan.apps.ae.a.d zd = zd();
        if (zd != null) {
            zd.mBackgroundColor = i;
        }
        return true;
    }

    public SwanAppActionBar yU() {
        return this.aqh;
    }

    public boolean yV() {
        return this.aqo == -1;
    }

    public void setRightExitViewVisibility(boolean z) {
        this.aqh.setRightExitViewVisibility(z);
    }

    public void setRightZoneVisibility(boolean z) {
        this.aqh.setRightZoneVisibility(z);
    }

    public void aY(boolean z) {
        FloatButton Mh = com.baidu.swan.apps.scheme.actions.c.a.Mf().Mh();
        if (!z) {
            if (Mh != null && Mh.getVisibility() == 0) {
                Mh.setVisibility(8);
            }
        } else if (Mh != null && Mh.getVisibility() != 0) {
            Mh.setVisibility(0);
        }
    }

    public void aZ(boolean z) {
        b cf;
        e vi = com.baidu.swan.apps.w.e.FV().vi();
        if (vi != null) {
            if (z) {
                cf = vi.zK();
            } else {
                cf = vi.cf(vi.zN() - 1);
            }
            if (cf != null) {
                aY(cf.xc());
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
            zf();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (zc() && this.aql != null && configuration.orientation == 1) {
            Wi().getWindow().clearFlags(1024);
            ac.b(new Runnable() { // from class: com.baidu.swan.apps.core.d.b.5
                @Override // java.lang.Runnable
                public void run() {
                    b.this.zf();
                }
            }, 200L);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z) {
            zf();
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
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.aqh, "alpha", 0.0f, 1.0f);
        ofFloat.setDuration(i);
        ofFloat.setInterpolator(accelerateDecelerateInterpolator);
        ofFloat.start();
        if (this.aql != null && this.aql.Ph() != null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.aql.Ph(), "alpha", 0.0f, 1.0f);
            ofFloat2.setDuration(i);
            ofFloat2.setInterpolator(accelerateDecelerateInterpolator);
            ofFloat2.start();
        }
    }

    @Nullable
    public boolean dG(String str) {
        if (this.aqh == null) {
            return false;
        }
        this.aqh.setTitle(str);
        com.baidu.swan.apps.ae.a.d zd = zd();
        if (zd != null) {
            zd.aQL = str;
        }
        return true;
    }

    protected void yW() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void yX() {
        if (this.mActivity != null) {
            this.mActivity.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ba(boolean z) {
        this.aqh.setLeftBackViewVisibility(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void yY() {
        this.aqh.setLeftHomeViewVisibility(0);
        this.aqh.setLeftHomeViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.yW();
            }
        });
    }

    @Override // com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable() {
        return true;
    }

    public final e vi() {
        if (this.mActivity == null) {
            return null;
        }
        return ((SwanAppActivity) this.mActivity).vi();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean yZ() {
        e vi = vi();
        if (vi == null) {
            return false;
        }
        return vi.zN() > 1;
    }

    public void za() {
        e vi = vi();
        if (vi == null || vi.zN() == 1) {
            if (this.mActivity != null) {
                this.mActivity.moveTaskToBack(true);
                return;
            }
            return;
        }
        vi.dO("navigateBack").y(0, 0).zS().commit();
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "back";
        a(fVar);
    }

    public void Y(float f) {
        bb(true);
    }

    public void zb() {
        bb(false);
    }

    private void bb(boolean z) {
        e vi = vi();
        if (vi != null && vi.zN() >= 2) {
            b cf = vi.cf(vi.zN() - 2);
            if (z) {
                vi.zO().e(cf);
            } else {
                vi.zO().f(cf);
            }
        }
    }

    public final void a(com.baidu.swan.apps.statistic.a.f fVar) {
        if (this.mActivity instanceof SwanAppActivity) {
            ((SwanAppActivity) this.mActivity).a(fVar);
        }
    }

    public boolean dH(String str) {
        return cc(com.baidu.swan.apps.ae.a.c.parseColor(str));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean cc(@ColorInt int i) {
        if (this.aqh == null) {
            return false;
        }
        boolean z = this instanceof com.baidu.swan.apps.core.d.a;
        setRightExitViewVisibility(z ? false : true);
        return this.aqh.q(i, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean zc() {
        return this.aqm;
    }

    protected com.baidu.swan.apps.ae.a.d zd() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View Q(View view) {
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
        this.aql = new com.baidu.swan.apps.view.a.b(this.mActivity, frameLayout);
        ze();
        return frameLayout;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ze() {
        if (this.aql != null) {
            cd(this.aqo);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cd(@ColorInt int i) {
        if (this.aql != null) {
            l(i, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l(@ColorInt int i, boolean z) {
        if (this.aql != null) {
            this.aqo = i;
            this.aql.c(i, com.baidu.swan.apps.an.d.ey(i), z);
        }
    }

    public void zf() {
        if (zc() && this.aql != null) {
            this.aql.zf();
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
        this.aqn = new SlideHelper();
        View wrapSlideView = this.aqn.wrapSlideView(view.getContext(), view, slideInterceptor);
        this.aqn.setFadeColor(0);
        this.aqn.setCanSlide(z);
        this.aqn.setSlideListener(new SlidingPaneLayout.PanelSlideListener() { // from class: com.baidu.swan.apps.core.d.b.7
            @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
            public void onPanelSlide(View view2, float f) {
                View maskView = b.this.aqn.getMaskView();
                if (maskView != null) {
                    maskView.setAlpha(1.0f - f);
                }
                b.this.Y(f);
            }

            @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
            public void onPanelOpened(View view2) {
                b.this.za();
            }

            @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
            public void onPanelClosed(View view2) {
                b.this.zb();
            }
        });
        return wrapSlideView;
    }

    public final Resources zg() {
        return isAdded() ? getResources() : AppRuntime.getAppContext().getResources();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean zh() {
        if ((this.mActivity instanceof SwanAppActivity) && ((SwanAppActivity) this.mActivity).vc() == 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int vc() {
        if (this.mActivity instanceof SwanAppActivity) {
            return ((SwanAppActivity) this.mActivity).vc();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aT(Context context) {
        if (context != null) {
            if (this.aqp == null) {
                this.aqp = new a();
            }
            if (this.mAudioManager == null) {
                this.mAudioManager = (AudioManager) context.getSystemService("audio");
            }
            this.mAudioManager.requestAudioFocus(this.aqp, 3, 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zi() {
        if (this.mAudioManager != null && this.aqp != null) {
            this.mAudioManager.abandonAudioFocus(this.aqp);
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

    public boolean zj() {
        if (this.aqh == null) {
            return false;
        }
        this.aqh.cH(true);
        return true;
    }

    public boolean zk() {
        if (this.aqh == null) {
            return false;
        }
        this.aqh.cH(false);
        return true;
    }

    public void bc(boolean z) {
        if (this.aqh != null) {
            this.aqh.setActionBarCustom(z);
        }
        if (this.aqk != null) {
            int i = 8;
            if (!z && yV()) {
                i = 0;
            }
            this.aqk.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int zl() {
        if (TextUtils.isEmpty(com.baidu.swan.apps.ae.b.LB()) || com.baidu.swan.apps.database.favorite.a.eh(com.baidu.swan.apps.ae.b.LB())) {
            return 0;
        }
        if (com.baidu.swan.apps.database.favorite.a.eg(com.baidu.swan.apps.ae.b.LB())) {
            return 2;
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean zm() {
        return "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u".equals(com.baidu.swan.apps.ae.b.LB());
    }

    public void zn() {
        com.baidu.swan.apps.scheme.actions.i.a.t("backtohome", "menu", com.baidu.swan.apps.w.e.FV().FG());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "gohome";
        fVar.mSource = "menu";
        a(fVar);
    }

    public void zo() {
    }

    /* renamed from: com.baidu.swan.apps.core.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private class C0134b {
        private Runnable aqu;
        private int aqt = 0;
        private long mLastTimestamp = 0;

        C0134b(Runnable runnable) {
            this.aqu = runnable;
        }

        void onClick() {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.mLastTimestamp > 1333) {
                this.mLastTimestamp = currentTimeMillis;
                this.aqt = 1;
                return;
            }
            this.aqt++;
            if (this.aqt == 3) {
                if (this.aqu != null) {
                    this.aqu.run();
                }
                this.aqt = 0;
                this.mLastTimestamp = 0L;
                return;
            }
            this.mLastTimestamp = currentTimeMillis;
        }
    }
}
