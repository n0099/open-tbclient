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
/* loaded from: classes10.dex */
public abstract class b extends Fragment implements SlideInterceptor {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    protected com.baidu.swan.apps.model.c bjj;
    protected View bjk;
    protected SwanAppActionBar bjl;
    protected com.baidu.swan.menu.h bjm;
    protected String bjn;
    protected View bjo;
    protected TextView bjp;
    @Nullable
    protected com.baidu.swan.apps.view.a.b bjq;
    private AudioManager.OnAudioFocusChangeListener bjr;
    private a bjs;
    protected Activity mActivity;
    private AudioManager mAudioManager;
    protected SlideHelper mSlideHelper;
    private boolean mImmersionEnabled = com.baidu.swan.apps.view.a.b.SUPPORT_IMMERSION;
    private int mStatusBarColor = 1;

    protected abstract boolean GO();

    protected abstract void GR();

    public abstract boolean Gt();

    protected abstract void Le();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean Lf();

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onAttach(Context context) {
        if (DEBUG) {
            Log.d("SwanAppBaseFragment", "onAttach");
        }
        super.onAttach(context);
        this.mActivity = ask();
        ci(true);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDetach() {
        if (DEBUG) {
            Log.d("SwanAppBaseFragment", "onDetach");
        }
        this.mActivity = null;
        ci(false);
        super.onDetach();
        try {
            Field declaredField = Fragment.class.getDeclaredField("cyL");
            declaredField.setAccessible(true);
            declaredField.set(this, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ae(View view) {
        com.baidu.swan.apps.runtime.config.c iD;
        ag(view);
        SwanAppConfigData Ui = com.baidu.swan.apps.y.f.UC().Ui();
        if (Ui == null) {
            if (DEBUG) {
                Log.d("SwanAppBaseFragment", "config data is null. " + Log.getStackTraceString(new Exception()));
                return;
            }
            return;
        }
        if (this.bjj == null) {
            iD = Ui.bLz;
        } else {
            iD = com.baidu.swan.apps.y.f.UC().iD(this.bjj.getPage());
        }
        ed(iD.bMc);
        this.bjl.setTitle(iD.bMd);
        this.bjs = new a(new Runnable() { // from class: com.baidu.swan.apps.core.d.b.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.ac.f.Wn();
            }
        });
        this.bjl.findViewById(a.f.titlebar_center_zone);
        if (!(this instanceof SwanAppAdLandingFragment)) {
            gF(iD.bMe);
        }
        this.bjn = iD.bMe;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ag(View view) {
        if (view != null) {
            this.bjl = (SwanAppActionBar) view.findViewById(a.f.ai_apps_title_bar);
            this.bjk = view.findViewById(a.f.ai_apps_title_bar_root);
            this.bjo = view.findViewById(a.f.title_shadow);
            this.bjl.setLeftBackViewMinWidth(af.dip2px(this.mActivity, 38.0f));
            this.bjl.setLeftBackViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    b.this.onActionBarBackPressed();
                }
            });
            this.bjl.setRightMenuOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    b.this.Le();
                    com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                    fVar.mValue = "menu";
                    if (com.baidu.swan.apps.runtime.e.aaq() != null && com.baidu.swan.apps.runtime.e.aaq().aaF().b("key_unread_counts_message", (Integer) 0).intValue() > 0) {
                        fVar.mPage = String.valueOf(1);
                    }
                    b.this.a(fVar);
                    if (b.this.bjs != null) {
                        b.this.bjs.onClick();
                    }
                }
            });
            this.bjl.setRightExitOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.b.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.mActivity != null && (b.this.mActivity instanceof SwanAppActivity)) {
                        if (com.baidu.swan.apps.runtime.e.aap() == null || com.baidu.swan.apps.runtime.e.aar() == null) {
                            b.this.Ll();
                        } else if (com.baidu.swan.apps.q.a.QN().QO()) {
                            b.this.Lk();
                        } else if (com.baidu.swan.apps.q.c.QU().QV()) {
                            b.this.Ll();
                        } else {
                            com.baidu.swan.apps.q.b QP = new com.baidu.swan.apps.q.b().QP();
                            if (!QP.isShow()) {
                                b.this.Ll();
                                return;
                            }
                            com.baidu.swan.apps.q.c.QU().a(b.this.mActivity, QP.getImageUrl(), QP.QT(), b.this.Lj());
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c.a Lj() {
        return new c.a() { // from class: com.baidu.swan.apps.core.d.b.6
            @Override // com.baidu.swan.apps.q.c.a
            public void LD() {
                b.this.Ll();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lk() {
        com.baidu.swan.apps.q.a.QN().a(this.mActivity, new com.baidu.swan.apps.core.f.b<Boolean>() { // from class: com.baidu.swan.apps.core.d.b.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.core.f.b
            /* renamed from: d */
            public void D(Boolean bool) {
                b.this.Ll();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ll() {
        if (this.mActivity != null) {
            this.mActivity.moveTaskToBack(true);
            Lm();
            ((SwanAppActivity) this.mActivity).dB(1);
        }
    }

    private void Lm() {
        HashMap hashMap = new HashMap();
        hashMap.put("lcType", "onClose");
        hashMap.put("appId", com.baidu.swan.apps.runtime.e.aar());
        com.baidu.swan.apps.y.f.UC().a(new com.baidu.swan.apps.n.a.c(hashMap));
        com.baidu.swan.apps.console.c.d("SwanAppBaseFragment", "onClose");
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "close";
        a(fVar);
    }

    public boolean ed(int i) {
        if (this.bjl == null || this.bjo == null) {
            return false;
        }
        this.mStatusBarColor = i;
        this.bjl.setBackgroundColor(i);
        com.baidu.swan.apps.runtime.config.c Lt = Lt();
        if (Lt != null) {
            Lt.bMc = i;
        }
        if (immersionEnabled()) {
            applyImmersion();
        }
        if (Lo()) {
            this.bjo.setVisibility(0);
        } else {
            this.bjo.setVisibility(8);
        }
        return true;
    }

    public boolean a(FrameLayout frameLayout, int i) {
        if (frameLayout == null) {
            return false;
        }
        frameLayout.setBackgroundColor(i);
        com.baidu.swan.apps.runtime.config.c Lt = Lt();
        if (Lt != null) {
            Lt.backgroundColor = i;
        }
        return true;
    }

    public SwanAppActionBar Ln() {
        return this.bjl;
    }

    public boolean Lo() {
        return this.mStatusBarColor == -1;
    }

    public void setRightExitViewVisibility(boolean z) {
        this.bjl.setRightExitViewVisibility(z);
    }

    public void setRightZoneVisibility(boolean z) {
        this.bjl.setRightZoneVisibility(z);
    }

    public void ch(boolean z) {
        FloatButton abz = com.baidu.swan.apps.scheme.actions.d.a.abx().abz();
        if (!z) {
            if (abz != null && abz.getVisibility() == 0) {
                abz.setVisibility(8);
            }
        } else if (abz != null && abz.getVisibility() != 0) {
            abz.setVisibility(0);
        }
    }

    public void ci(boolean z) {
        b eg;
        e El = com.baidu.swan.apps.y.f.UC().El();
        if (El != null) {
            if (z) {
                eg = El.LX();
            } else {
                eg = El.eg(El.Ma() - 1);
            }
            if (eg != null) {
                ch(eg.GO());
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
        Lp();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (immersionEnabled() && this.bjq != null && configuration.orientation == 1) {
            ask().getWindow().clearFlags(1024);
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

    public void Lp() {
        if (this.mActivity != null && this.bjl != null) {
            ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.d.b.9
                @Override // java.lang.Runnable
                public void run() {
                    if (com.baidu.swan.apps.ah.a.a.Yq()) {
                        if (b.this.bjp == null) {
                            b.this.bjp = new TextView(b.this.mActivity);
                        }
                        if (!(b.this.bjp.getParent() instanceof SwanAppActionBar)) {
                            b.this.bjp.setText(a.h.aiapps_debug_open_cts);
                            b.this.bjp.setTextColor(b.this.getResources().getColor(17170455));
                            b.this.bjl.addView(b.this.bjp);
                        }
                    } else if (b.this.bjp != null) {
                        b.this.bjl.removeView(b.this.bjp);
                        b.this.bjp = null;
                    }
                }
            });
        }
    }

    public void v(int i, String str) {
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
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.bjl, "alpha", 0.0f, 1.0f);
        ofFloat.setDuration(i);
        ofFloat.setInterpolator(accelerateDecelerateInterpolator);
        ofFloat.start();
        if (this.bjq != null && this.bjq.aff() != null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.bjq.aff(), "alpha", 0.0f, 1.0f);
            ofFloat2.setDuration(i);
            ofFloat2.setInterpolator(accelerateDecelerateInterpolator);
            ofFloat2.start();
        }
    }

    @Nullable
    public boolean gE(String str) {
        if (this.bjl == null) {
            return false;
        }
        this.bjl.setTitle(str);
        com.baidu.swan.apps.runtime.config.c Lt = Lt();
        if (Lt != null) {
            Lt.bMd = str;
        }
        return true;
    }

    protected void Lq() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onActionBarBackPressed() {
        if (this.mActivity != null) {
            this.mActivity.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cj(boolean z) {
        this.bjl.setLeftBackViewVisibility(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Lr() {
        this.bjl.setLeftHomeViewVisibility(0);
        this.bjl.setLeftHomeViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.b.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.Lq();
            }
        });
    }

    @Override // com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        return true;
    }

    public final e El() {
        if (this.mActivity == null) {
            return null;
        }
        return ((SwanAppActivity) this.mActivity).El();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean Ls() {
        e El = El();
        if (El == null) {
            return false;
        }
        return El.Ma() > 1;
    }

    public void finishAfterSlide() {
        e El = El();
        if (El == null || El.Ma() == 1) {
            if (this.mActivity != null) {
                this.mActivity.moveTaskToBack(true);
                return;
            }
            return;
        }
        El.gM("navigateBack").Y(0, 0).Mf().commit();
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
        e El = El();
        if (El != null && El.Ma() >= 2) {
            b eg = El.eg(El.Ma() - 2);
            a(f, eg);
            if (z) {
                El.Mb().g(eg);
            } else {
                El.Mb().h(eg);
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

    public boolean gF(String str) {
        return ee(SwanAppConfigData.cy(str));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean ee(@ColorInt int i) {
        if (this.bjl == null) {
            return false;
        }
        boolean z = this instanceof com.baidu.swan.apps.core.d.a;
        setRightExitViewVisibility(z ? false : true);
        return this.bjl.u(i, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean immersionEnabled() {
        return this.mImmersionEnabled;
    }

    protected com.baidu.swan.apps.runtime.config.c Lt() {
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
        this.bjq = new com.baidu.swan.apps.view.a.b(this.mActivity, frameLayout);
        applyImmersion();
        return frameLayout;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void applyImmersion() {
        if (this.bjq != null) {
            applyImmersion(this.mStatusBarColor);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void applyImmersion(@ColorInt int i) {
        if (this.bjq != null) {
            p(i, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(@ColorInt int i, boolean z) {
        if (this.bjq != null) {
            this.mStatusBarColor = i;
            this.bjq.setImmersion(i, z);
        }
    }

    public void resetWithCurImmersion() {
        if (immersionEnabled() && this.bjq != null) {
            this.bjq.resetWithCurImmersion();
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
        boolean z = getResources().getConfiguration().orientation != 2 && (Lt() == null || !Lt().bMl) && Build.VERSION.SDK_INT != 26;
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

    public final Resources Lu() {
        return isAdded() ? getResources() : AppRuntime.getAppContext().getResources();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean Lv() {
        if ((this.mActivity instanceof SwanAppActivity) && ((SwanAppActivity) this.mActivity).Ed() == 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int Ed() {
        if (this.mActivity instanceof SwanAppActivity) {
            return ((SwanAppActivity) this.mActivity).Ed();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Fm() {
        if (this.mAudioManager != null && this.bjr != null) {
            this.mAudioManager.abandonAudioFocus(this.bjr);
        }
    }

    public boolean Lw() {
        if (this.bjl == null) {
            return false;
        }
        this.bjl.eb(true);
        return true;
    }

    public boolean Lx() {
        if (this.bjl == null) {
            return false;
        }
        this.bjl.eb(false);
        return true;
    }

    public void ck(boolean z) {
        if (this.bjl != null) {
            this.bjl.setActionBarCustom(z);
        }
        if (this.bjo != null) {
            int i = 8;
            if (!z && Lo()) {
                i = 0;
            }
            this.bjo.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int Ly() {
        if (TextUtils.isEmpty(com.baidu.swan.apps.runtime.e.aar())) {
            return 0;
        }
        if (com.baidu.swan.apps.database.favorite.a.hn(com.baidu.swan.apps.runtime.e.aar())) {
            return 2;
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Lz() {
        return "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u".equals(com.baidu.swan.apps.runtime.e.aar());
    }

    public void LA() {
        com.baidu.swan.apps.scheme.actions.k.a.E("backtohome", "menu", com.baidu.swan.apps.y.f.UC().Um());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "gohome";
        fVar.mSource = "menu";
        a(fVar);
    }

    public void LB() {
    }

    public com.baidu.swan.apps.model.c LC() {
        return this.bjj;
    }

    /* loaded from: classes10.dex */
    private class a {
        private int bju = 0;
        private long bjv = 0;
        private Runnable bjw;

        a(Runnable runnable) {
            this.bjw = runnable;
        }

        void onClick() {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.bjv > 1333) {
                this.bjv = currentTimeMillis;
                this.bju = 1;
                return;
            }
            this.bju++;
            if (this.bju == 3) {
                if (this.bjw != null) {
                    this.bjw.run();
                }
                this.bju = 0;
                this.bjv = 0L;
                return;
            }
            this.bjv = currentTimeMillis;
        }
    }
}
