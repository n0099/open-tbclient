package com.baidu.swan.apps.core.d;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.AudioManager;
import android.os.Build;
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
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.widget.SlideHelper;
import com.baidu.searchbox.widget.SlideInterceptor;
import com.baidu.searchbox.widget.SlidingPaneLayout;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment;
import com.baidu.swan.apps.ao.ah;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.ao.ap;
import com.baidu.swan.apps.p.c;
import com.baidu.swan.apps.res.ui.FloatButton;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.setting.oauth.a.b;
import com.baidu.swan.apps.view.SwanAppActionBar;
import com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView;
import com.baidu.swan.support.v4.app.Fragment;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import java.lang.reflect.Field;
import java.util.HashMap;
/* loaded from: classes9.dex */
public abstract class c extends Fragment implements SlideInterceptor {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private AudioManager.OnAudioFocusChangeListener byO;
    protected com.baidu.swan.apps.model.c cUd;
    protected View cUe;
    protected SwanAppActionBar cUf;
    protected com.baidu.swan.menu.g cUg;
    protected SwanAppMenuHeaderView cUh;
    protected String cUi;
    protected View cUj;
    protected TextView cUk;
    @Nullable
    protected com.baidu.swan.apps.view.a.b cUl;
    private a cUp;
    private b cUq;
    protected Activity mActivity;
    private AudioManager mAudioManager;
    protected SlideHelper mSlideHelper;
    private boolean cUm = com.baidu.swan.apps.view.a.b.dDB;
    private int cUn = 1;
    private int cUo = 1;
    private boolean cUr = false;

    /* loaded from: classes9.dex */
    public interface b {
        void anr();
    }

    protected abstract boolean amM();

    protected abstract void amS();

    public abstract boolean aml();

    protected abstract void arB();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean arC();

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onAttach(Context context) {
        if (DEBUG) {
            Log.d("SwanAppBaseFragment", "onAttach");
        }
        super.onAttach(context);
        this.mActivity = bhA();
        fl(true);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDetach() {
        if (DEBUG) {
            Log.d("SwanAppBaseFragment", "onDetach");
        }
        this.mActivity = null;
        fl(false);
        super.onDetach();
        try {
            Field declaredField = Fragment.class.getDeclaredField("ezd");
            declaredField.setAccessible(true);
            declaredField.set(this, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void av(View view) {
        com.baidu.swan.apps.runtime.config.c qf;
        ay(view);
        SwanAppConfigData aDl = com.baidu.swan.apps.v.f.aDG().aDl();
        if (aDl == null) {
            if (DEBUG) {
                Log.d("SwanAppBaseFragment", "config data is null. " + Log.getStackTraceString(new Exception()));
                return;
            }
            return;
        }
        if (this.cUd == null) {
            qf = aDl.dHA;
        } else {
            qf = com.baidu.swan.apps.v.f.aDG().qf(com.baidu.swan.apps.scheme.actions.k.j.c(this.cUd.getPage(), aDl));
        }
        ik(qf.dIj);
        this.cUf.setTitle(qf.dIk);
        this.cUp = new a(new Runnable() { // from class: com.baidu.swan.apps.core.d.c.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.y.f.aGg();
            }
        });
        if (!(this instanceof SwanAppAdLandingFragment)) {
            il(SwanAppConfigData.sF(qf.dIl));
        }
        this.cUi = qf.dIl;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ay(View view) {
        if (view != null) {
            this.cUf = (SwanAppActionBar) view.findViewById(a.f.ai_apps_title_bar);
            this.cUe = view.findViewById(a.f.ai_apps_title_bar_root);
            this.cUj = view.findViewById(a.f.title_shadow);
            this.cUf.setLeftBackViewMinWidth(ah.dip2px(this.mActivity, 38.0f));
            this.cUf.setLeftBackViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (com.baidu.swan.apps.p.a.azc().azd()) {
                        com.baidu.swan.apps.p.a.azc().a(c.this.mActivity, new com.baidu.swan.apps.core.f.b<Boolean>() { // from class: com.baidu.swan.apps.core.d.c.4.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.swan.apps.core.f.b
                            /* renamed from: f */
                            public void N(Boolean bool) {
                                if (bool.booleanValue()) {
                                    c.this.arZ();
                                }
                            }
                        });
                    } else {
                        c.this.arZ();
                    }
                }
            });
            this.cUf.setRightMenuOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    c.this.arB();
                    com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                    fVar.mValue = "menu";
                    if (com.baidu.swan.apps.runtime.e.aMl() != null && com.baidu.swan.apps.runtime.e.aMl().aMC().c("key_unread_counts_message", 0).intValue() > 0) {
                        fVar.mPage = String.valueOf(1);
                    }
                    c.this.a(fVar);
                    if (c.this.cUp != null) {
                        c.this.cUp.onClick();
                    }
                }
            });
            this.cUf.setRightExitOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.c.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (c.this.mActivity != null && (c.this.mActivity instanceof SwanAppActivity)) {
                        if (com.baidu.swan.apps.runtime.e.aMk() == null || com.baidu.swan.apps.runtime.e.aMm() == null) {
                            c.this.arT();
                        } else if (com.baidu.swan.apps.p.a.azc().azd()) {
                            com.baidu.swan.apps.p.a.azc().a(c.this.mActivity, new com.baidu.swan.apps.core.f.b<Boolean>() { // from class: com.baidu.swan.apps.core.d.c.6.1
                                /* JADX DEBUG: Method merged with bridge method */
                                @Override // com.baidu.swan.apps.core.f.b
                                /* renamed from: f */
                                public void N(Boolean bool) {
                                    if (bool.booleanValue()) {
                                        c.this.arT();
                                    }
                                }
                            });
                        } else if (com.baidu.swan.apps.p.c.azj().azk()) {
                            c.this.arT();
                        } else {
                            com.baidu.swan.apps.p.b aze = new com.baidu.swan.apps.p.b().aze();
                            if (!aze.isShow()) {
                                c.this.arT();
                                return;
                            }
                            com.baidu.swan.apps.p.c.azj().a(c.this.mActivity, aze.getImageUrl(), aze.azi(), c.this.arS());
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c.a arS() {
        return new c.a() { // from class: com.baidu.swan.apps.core.d.c.7
            @Override // com.baidu.swan.apps.p.c.a
            public void asv() {
                c.this.arT();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void arT() {
        if (this.mActivity != null) {
            com.baidu.swan.apps.v.g.aDP().setForeground(false);
            this.mActivity.moveTaskToBack(true);
            arU();
            ((SwanAppActivity) this.mActivity).hD(1);
            ap.aSa().lQ(2);
        }
    }

    private void arU() {
        HashMap hashMap = new HashMap();
        hashMap.put("lcType", "onClose");
        hashMap.put("appId", com.baidu.swan.apps.runtime.e.aMm());
        com.baidu.swan.apps.v.f.aDG().b(new com.baidu.swan.apps.event.a.c(hashMap));
        com.baidu.swan.apps.console.c.i("SwanAppBaseFragment", "onClose");
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "close";
        a(fVar);
    }

    public boolean ik(int i) {
        return x(i, false);
    }

    public boolean x(int i, boolean z) {
        if (this.cUf == null || this.cUj == null) {
            return false;
        }
        this.cUo = i;
        this.cUf.setBackgroundColor(i);
        com.baidu.swan.apps.runtime.config.c asf = asf();
        if (asf != null) {
            asf.dIj = i;
            asf.hn(z);
        }
        if (ase()) {
            asg();
        }
        if (arW()) {
            this.cUj.setVisibility(0);
        } else {
            this.cUj.setVisibility(8);
        }
        return true;
    }

    public boolean a(FrameLayout frameLayout, int i) {
        if (frameLayout == null) {
            return false;
        }
        frameLayout.setBackgroundColor(i);
        com.baidu.swan.apps.runtime.config.c asf = asf();
        if (asf != null) {
            asf.backgroundColor = i;
        }
        return true;
    }

    public SwanAppActionBar arV() {
        return this.cUf;
    }

    public boolean arW() {
        return this.cUo == -1;
    }

    public void setRightExitViewVisibility(boolean z) {
        this.cUf.setRightExitViewVisibility(z);
    }

    public void setRightZoneVisibility(boolean z) {
        this.cUf.setRightZoneVisibility(z);
    }

    public void fj(boolean z) {
        this.cUr = z;
    }

    public void fk(boolean z) {
        FloatButton aNB = com.baidu.swan.apps.scheme.actions.d.a.aNz().aNB();
        if (!z) {
            if (aNB != null && aNB.getVisibility() == 0) {
                aNB.setVisibility(8);
            }
        } else if (aNB != null && aNB.getVisibility() != 0) {
            aNB.setVisibility(0);
        }
    }

    public void fl(boolean z) {
        c io2;
        f ajs = com.baidu.swan.apps.v.f.aDG().ajs();
        if (ajs != null) {
            if (z) {
                io2 = ajs.asT();
            } else {
                io2 = ajs.io(ajs.asW() - 1);
            }
            if (io2 != null) {
                fk(io2.amM());
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
            ash();
        }
        arX();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (ase() && this.cUl != null && configuration.orientation == 1) {
            bhA().getWindow().clearFlags(1024);
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.d.c.8
                @Override // java.lang.Runnable
                public void run() {
                    c.this.ash();
                }
            }, 200L);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z) {
            ash();
        }
    }

    public void arX() {
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.core.d.c.9
            @Override // java.lang.Runnable
            public void run() {
                c.this.fm(com.baidu.swan.apps.ad.a.a.aIN());
            }
        }, "updateCtsView", 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fm(final boolean z) {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.d.c.10
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.mActivity != null && c.this.cUf != null) {
                    if (z) {
                        if (c.this.cUk == null) {
                            c.this.cUk = new TextView(c.this.mActivity);
                        }
                        if (!(c.this.cUk.getParent() instanceof SwanAppActionBar)) {
                            c.this.cUk.setText(a.h.aiapps_debug_open_cts);
                            c.this.cUk.setTextColor(c.this.asl().getColor(17170455));
                            c.this.cUf.addView(c.this.cUk);
                        }
                    } else if (c.this.cUk != null) {
                        c.this.cUf.removeView(c.this.cUk);
                        c.this.cUk = null;
                    }
                }
            }
        });
    }

    public void ak(int i, String str) {
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
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.cUf, "alpha", 0.0f, 1.0f);
        ofFloat.setDuration(i);
        ofFloat.setInterpolator(accelerateDecelerateInterpolator);
        ofFloat.start();
        if (this.cUl != null && this.cUl.aSs() != null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.cUl.aSs(), "alpha", 0.0f, 1.0f);
            ofFloat2.setDuration(i);
            ofFloat2.setInterpolator(accelerateDecelerateInterpolator);
            ofFloat2.start();
        }
    }

    @Nullable
    public boolean no(String str) {
        return Q(str, false);
    }

    public boolean Q(String str, boolean z) {
        if (this.cUf == null) {
            return false;
        }
        this.cUf.setTitle(str);
        com.baidu.swan.apps.runtime.config.c asf = asf();
        if (asf != null) {
            asf.dIk = str;
            asf.hn(z);
        }
        com.baidu.swan.apps.console.c.i("SwanAppBaseFragment", "page title: " + str);
        return true;
    }

    protected void arY() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void arZ() {
        if (this.mActivity != null) {
            this.mActivity.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void fn(boolean z) {
        this.cUf.setLeftBackViewVisibility(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void asa() {
        this.cUf.setLeftHomeViewVisibility(0);
        this.cUf.setLeftHomeViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.c.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.arY();
            }
        });
    }

    public boolean isSlidable(MotionEvent motionEvent) {
        return true;
    }

    public final f ajs() {
        if (this.mActivity == null) {
            return null;
        }
        return ((SwanAppActivity) this.mActivity).ajs();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean asb() {
        f ajs = ajs();
        if (ajs == null) {
            return false;
        }
        return ajs.asW() > 1;
    }

    public void asc() {
        f ajs = ajs();
        if (ajs == null || ajs.asW() == 1) {
            if (this.mActivity != null) {
                this.mActivity.moveTaskToBack(true);
                ap.aSa().lQ(1);
                return;
            }
            return;
        }
        ajs.nv("navigateBack").ai(0, 0).ata().commit();
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "back";
        a(fVar);
    }

    public void G(float f) {
        b(true, f);
    }

    public void asd() {
        b(false, 1.0f);
    }

    private void b(boolean z, float f) {
        f ajs = ajs();
        if (ajs != null && ajs.asW() >= 2) {
            c io2 = ajs.io(ajs.asW() - 2);
            a(f, io2);
            if (z) {
                ajs.asX().h(io2);
            } else {
                ajs.asX().i(io2);
            }
        }
    }

    private void a(float f, Fragment fragment) {
        View view;
        float displayWidth = ah.getDisplayWidth(this.mActivity) >> 2;
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

    public boolean il(int i) {
        return f(i, "", false);
    }

    public boolean R(String str, boolean z) {
        return f(SwanAppConfigData.sF(str), str, z);
    }

    protected boolean f(@ColorInt int i, String str, boolean z) {
        if (this.cUf == null) {
            return false;
        }
        setRightExitViewVisibility(this.cUr ? false : true);
        com.baidu.swan.apps.runtime.config.c asf = asf();
        if (asf != null) {
            if (!TextUtils.isEmpty(str)) {
                asf.dIl = str;
            }
            asf.hn(z);
        }
        int i2 = i == -16777216 ? -16777216 : -1;
        if (ase() && i2 != this.cUn) {
            this.cUn = i2;
            asg();
        }
        return this.cUf.E(i, this.cUr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean ase() {
        return this.cUm;
    }

    protected com.baidu.swan.apps.runtime.config.c asf() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View az(View view) {
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
        this.cUl = new com.baidu.swan.apps.view.a.b(this.mActivity, frameLayout);
        asg();
        return frameLayout;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void asg() {
        if (this.cUl != null) {
            im(this.cUo);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void im(@ColorInt int i) {
        if (this.cUl != null) {
            y(i, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void y(@ColorInt int i, boolean z) {
        boolean z2 = true;
        if (this.cUl != null) {
            this.cUo = i;
            if (this.cUn == 1) {
                z2 = com.baidu.swan.apps.ao.h.lM(i);
            } else if (this.cUn != -16777216) {
                z2 = false;
            }
            this.cUl.d(i, z, z2);
        }
    }

    public void ash() {
        if (ase() && this.cUl != null) {
            this.cUl.ash();
        }
    }

    @Nullable
    public com.baidu.swan.apps.view.a.b asi() {
        return this.cUl;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setRequestedOrientation(int i) {
        if (this.mActivity != null) {
            this.mActivity.setRequestedOrientation(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View a(View view, SlideInterceptor slideInterceptor) {
        this.mSlideHelper = new SlideHelper();
        View wrapSlideView = this.mSlideHelper.wrapSlideView(view.getContext(), view, slideInterceptor);
        this.mSlideHelper.setFadeColor(0);
        asj();
        ask();
        return wrapSlideView;
    }

    private void asj() {
        if (asf() != null && asf().dIs) {
            com.baidu.swan.apps.runtime.e aMl = com.baidu.swan.apps.runtime.e.aMl();
            if (aMl != null) {
                aMl.aMw().b(aMl.aMe(), "scope_disable_swipe_back", new com.baidu.swan.apps.ao.e.b<com.baidu.swan.apps.setting.oauth.h<b.d>>() { // from class: com.baidu.swan.apps.core.d.c.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.ao.e.b
                    /* renamed from: a */
                    public void L(com.baidu.swan.apps.setting.oauth.h<b.d> hVar) {
                        if (!com.baidu.swan.apps.setting.oauth.c.b(hVar)) {
                            c.this.mSlideHelper.setCanSlide(c.this.canSlide());
                        } else {
                            c.this.mSlideHelper.setCanSlide(false);
                        }
                    }
                });
                return;
            } else {
                this.mSlideHelper.setCanSlide(canSlide());
                return;
            }
        }
        this.mSlideHelper.setCanSlide(canSlide());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canSlide() {
        return (asl().getConfiguration().orientation == 2 || Build.VERSION.SDK_INT == 26) ? false : true;
    }

    private void ask() {
        this.mSlideHelper.setSlideListener(new SlidingPaneLayout.PanelSlideListener() { // from class: com.baidu.swan.apps.core.d.c.3
            @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
            public void onPanelSlide(View view, float f) {
                View maskView = c.this.mSlideHelper.getMaskView();
                if (maskView != null) {
                    maskView.setAlpha(1.0f - f);
                }
                c.this.G(f);
                if (c.this.cUq != null) {
                    c.this.cUq.anr();
                }
            }

            @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
            public void onPanelOpened(View view) {
                c.this.asc();
            }

            @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
            public void onPanelClosed(View view) {
                c.this.asd();
            }
        });
    }

    public final Resources asl() {
        return isAdded() ? getResources() : AppRuntime.getAppContext().getResources();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean asn() {
        if ((this.mActivity instanceof SwanAppActivity) && ((SwanAppActivity) this.mActivity).ajk() == 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int ajk() {
        if (this.mActivity instanceof SwanAppActivity) {
            return ((SwanAppActivity) this.mActivity).ajk();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void abandonAudioFocus() {
        if (this.mAudioManager != null && this.byO != null) {
            this.mAudioManager.abandonAudioFocus(this.byO);
        }
    }

    public boolean aso() {
        if (this.cUf == null) {
            return false;
        }
        this.cUf.hJ(true);
        return true;
    }

    public boolean asp() {
        if (this.cUf == null) {
            return false;
        }
        this.cUf.hJ(false);
        return true;
    }

    public void fo(boolean z) {
        if (this.cUf != null) {
            this.cUf.setActionBarCustom(z);
        }
        if (this.cUj != null) {
            int i = 8;
            if (!z && arW()) {
                i = 0;
            }
            this.cUj.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int asq() {
        if (TextUtils.isEmpty(com.baidu.swan.apps.runtime.e.aMm())) {
            return 0;
        }
        if (com.baidu.swan.apps.database.favorite.a.oj(com.baidu.swan.apps.runtime.e.aMm())) {
            return 2;
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean asr() {
        return "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u".equals(com.baidu.swan.apps.runtime.e.aMm());
    }

    public void ass() {
        com.baidu.swan.apps.scheme.actions.k.a.aa("backtohome", "menu", com.baidu.swan.apps.v.f.aDG().aDp());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "gohome";
        fVar.mSource = "menu";
        a(fVar);
    }

    public void arF() {
    }

    public com.baidu.swan.apps.model.c ast() {
        return this.cUd;
    }

    /* loaded from: classes9.dex */
    private class a {
        private int cUw = 0;
        private long cUx = 0;
        private Runnable cUy;

        a(Runnable runnable) {
            this.cUy = runnable;
        }

        void onClick() {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.cUx > 1333) {
                this.cUx = currentTimeMillis;
                this.cUw = 1;
                return;
            }
            this.cUw++;
            if (this.cUw == 3) {
                if (this.cUy != null) {
                    this.cUy.run();
                }
                this.cUw = 0;
                this.cUx = 0L;
                return;
            }
            this.cUx = currentTimeMillis;
        }
    }

    public void a(b bVar) {
        this.cUq = bVar;
    }

    public View asu() {
        return this.cUe;
    }
}
