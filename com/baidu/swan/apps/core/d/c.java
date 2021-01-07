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
        void ans();
    }

    protected abstract boolean amN();

    protected abstract void amT();

    public abstract boolean amm();

    protected abstract void arC();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean arD();

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onAttach(Context context) {
        if (DEBUG) {
            Log.d("SwanAppBaseFragment", "onAttach");
        }
        super.onAttach(context);
        this.mActivity = bhB();
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
        SwanAppConfigData aDm = com.baidu.swan.apps.v.f.aDH().aDm();
        if (aDm == null) {
            if (DEBUG) {
                Log.d("SwanAppBaseFragment", "config data is null. " + Log.getStackTraceString(new Exception()));
                return;
            }
            return;
        }
        if (this.cUd == null) {
            qf = aDm.dHA;
        } else {
            qf = com.baidu.swan.apps.v.f.aDH().qf(com.baidu.swan.apps.scheme.actions.k.j.c(this.cUd.getPage(), aDm));
        }
        ik(qf.dIj);
        this.cUf.setTitle(qf.dIk);
        this.cUp = new a(new Runnable() { // from class: com.baidu.swan.apps.core.d.c.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.y.f.aGh();
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
                    if (com.baidu.swan.apps.p.a.azd().aze()) {
                        com.baidu.swan.apps.p.a.azd().a(c.this.mActivity, new com.baidu.swan.apps.core.f.b<Boolean>() { // from class: com.baidu.swan.apps.core.d.c.4.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.swan.apps.core.f.b
                            /* renamed from: f */
                            public void N(Boolean bool) {
                                if (bool.booleanValue()) {
                                    c.this.asa();
                                }
                            }
                        });
                    } else {
                        c.this.asa();
                    }
                }
            });
            this.cUf.setRightMenuOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    c.this.arC();
                    com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                    fVar.mValue = "menu";
                    if (com.baidu.swan.apps.runtime.e.aMm() != null && com.baidu.swan.apps.runtime.e.aMm().aMD().c("key_unread_counts_message", 0).intValue() > 0) {
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
                        if (com.baidu.swan.apps.runtime.e.aMl() == null || com.baidu.swan.apps.runtime.e.aMn() == null) {
                            c.this.arU();
                        } else if (com.baidu.swan.apps.p.a.azd().aze()) {
                            com.baidu.swan.apps.p.a.azd().a(c.this.mActivity, new com.baidu.swan.apps.core.f.b<Boolean>() { // from class: com.baidu.swan.apps.core.d.c.6.1
                                /* JADX DEBUG: Method merged with bridge method */
                                @Override // com.baidu.swan.apps.core.f.b
                                /* renamed from: f */
                                public void N(Boolean bool) {
                                    if (bool.booleanValue()) {
                                        c.this.arU();
                                    }
                                }
                            });
                        } else if (com.baidu.swan.apps.p.c.azk().azl()) {
                            c.this.arU();
                        } else {
                            com.baidu.swan.apps.p.b azf = new com.baidu.swan.apps.p.b().azf();
                            if (!azf.isShow()) {
                                c.this.arU();
                                return;
                            }
                            com.baidu.swan.apps.p.c.azk().a(c.this.mActivity, azf.getImageUrl(), azf.azj(), c.this.arT());
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c.a arT() {
        return new c.a() { // from class: com.baidu.swan.apps.core.d.c.7
            @Override // com.baidu.swan.apps.p.c.a
            public void asw() {
                c.this.arU();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void arU() {
        if (this.mActivity != null) {
            com.baidu.swan.apps.v.g.aDQ().setForeground(false);
            this.mActivity.moveTaskToBack(true);
            arV();
            ((SwanAppActivity) this.mActivity).hD(1);
            ap.aSb().lQ(2);
        }
    }

    private void arV() {
        HashMap hashMap = new HashMap();
        hashMap.put("lcType", "onClose");
        hashMap.put("appId", com.baidu.swan.apps.runtime.e.aMn());
        com.baidu.swan.apps.v.f.aDH().b(new com.baidu.swan.apps.event.a.c(hashMap));
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
        com.baidu.swan.apps.runtime.config.c asg = asg();
        if (asg != null) {
            asg.dIj = i;
            asg.hn(z);
        }
        if (asf()) {
            ash();
        }
        if (arX()) {
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
        com.baidu.swan.apps.runtime.config.c asg = asg();
        if (asg != null) {
            asg.backgroundColor = i;
        }
        return true;
    }

    public SwanAppActionBar arW() {
        return this.cUf;
    }

    public boolean arX() {
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
        FloatButton aNC = com.baidu.swan.apps.scheme.actions.d.a.aNA().aNC();
        if (!z) {
            if (aNC != null && aNC.getVisibility() == 0) {
                aNC.setVisibility(8);
            }
        } else if (aNC != null && aNC.getVisibility() != 0) {
            aNC.setVisibility(0);
        }
    }

    public void fl(boolean z) {
        c io2;
        f ajt = com.baidu.swan.apps.v.f.aDH().ajt();
        if (ajt != null) {
            if (z) {
                io2 = ajt.asU();
            } else {
                io2 = ajt.io(ajt.asX() - 1);
            }
            if (io2 != null) {
                fk(io2.amN());
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
            asi();
        }
        arY();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (asf() && this.cUl != null && configuration.orientation == 1) {
            bhB().getWindow().clearFlags(1024);
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.d.c.8
                @Override // java.lang.Runnable
                public void run() {
                    c.this.asi();
                }
            }, 200L);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z) {
            asi();
        }
    }

    public void arY() {
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.core.d.c.9
            @Override // java.lang.Runnable
            public void run() {
                c.this.fm(com.baidu.swan.apps.ad.a.a.aIO());
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
                            c.this.cUk.setTextColor(c.this.asn().getColor(17170455));
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
        if (this.cUl != null && this.cUl.aSt() != null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.cUl.aSt(), "alpha", 0.0f, 1.0f);
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
        com.baidu.swan.apps.runtime.config.c asg = asg();
        if (asg != null) {
            asg.dIk = str;
            asg.hn(z);
        }
        com.baidu.swan.apps.console.c.i("SwanAppBaseFragment", "page title: " + str);
        return true;
    }

    protected void arZ() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void asa() {
        if (this.mActivity != null) {
            this.mActivity.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void fn(boolean z) {
        this.cUf.setLeftBackViewVisibility(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void asb() {
        this.cUf.setLeftHomeViewVisibility(0);
        this.cUf.setLeftHomeViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.c.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.arZ();
            }
        });
    }

    public boolean isSlidable(MotionEvent motionEvent) {
        return true;
    }

    public final f ajt() {
        if (this.mActivity == null) {
            return null;
        }
        return ((SwanAppActivity) this.mActivity).ajt();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean asc() {
        f ajt = ajt();
        if (ajt == null) {
            return false;
        }
        return ajt.asX() > 1;
    }

    public void asd() {
        f ajt = ajt();
        if (ajt == null || ajt.asX() == 1) {
            if (this.mActivity != null) {
                this.mActivity.moveTaskToBack(true);
                ap.aSb().lQ(1);
                return;
            }
            return;
        }
        ajt.nv("navigateBack").ai(0, 0).atb().commit();
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "back";
        a(fVar);
    }

    public void G(float f) {
        b(true, f);
    }

    public void ase() {
        b(false, 1.0f);
    }

    private void b(boolean z, float f) {
        f ajt = ajt();
        if (ajt != null && ajt.asX() >= 2) {
            c io2 = ajt.io(ajt.asX() - 2);
            a(f, io2);
            if (z) {
                ajt.asY().h(io2);
            } else {
                ajt.asY().i(io2);
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
        com.baidu.swan.apps.runtime.config.c asg = asg();
        if (asg != null) {
            if (!TextUtils.isEmpty(str)) {
                asg.dIl = str;
            }
            asg.hn(z);
        }
        int i2 = i == -16777216 ? -16777216 : -1;
        if (asf() && i2 != this.cUn) {
            this.cUn = i2;
            ash();
        }
        return this.cUf.E(i, this.cUr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean asf() {
        return this.cUm;
    }

    protected com.baidu.swan.apps.runtime.config.c asg() {
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
        ash();
        return frameLayout;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ash() {
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

    public void asi() {
        if (asf() && this.cUl != null) {
            this.cUl.asi();
        }
    }

    @Nullable
    public com.baidu.swan.apps.view.a.b asj() {
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
        ask();
        asl();
        return wrapSlideView;
    }

    private void ask() {
        if (asg() != null && asg().dIs) {
            com.baidu.swan.apps.runtime.e aMm = com.baidu.swan.apps.runtime.e.aMm();
            if (aMm != null) {
                aMm.aMx().b(aMm.aMf(), "scope_disable_swipe_back", new com.baidu.swan.apps.ao.e.b<com.baidu.swan.apps.setting.oauth.h<b.d>>() { // from class: com.baidu.swan.apps.core.d.c.2
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
        return (asn().getConfiguration().orientation == 2 || Build.VERSION.SDK_INT == 26) ? false : true;
    }

    private void asl() {
        this.mSlideHelper.setSlideListener(new SlidingPaneLayout.PanelSlideListener() { // from class: com.baidu.swan.apps.core.d.c.3
            @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
            public void onPanelSlide(View view, float f) {
                View maskView = c.this.mSlideHelper.getMaskView();
                if (maskView != null) {
                    maskView.setAlpha(1.0f - f);
                }
                c.this.G(f);
                if (c.this.cUq != null) {
                    c.this.cUq.ans();
                }
            }

            @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
            public void onPanelOpened(View view) {
                c.this.asd();
            }

            @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
            public void onPanelClosed(View view) {
                c.this.ase();
            }
        });
    }

    public final Resources asn() {
        return isAdded() ? getResources() : AppRuntime.getAppContext().getResources();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean aso() {
        if ((this.mActivity instanceof SwanAppActivity) && ((SwanAppActivity) this.mActivity).ajl() == 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int ajl() {
        if (this.mActivity instanceof SwanAppActivity) {
            return ((SwanAppActivity) this.mActivity).ajl();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void abandonAudioFocus() {
        if (this.mAudioManager != null && this.byO != null) {
            this.mAudioManager.abandonAudioFocus(this.byO);
        }
    }

    public boolean asp() {
        if (this.cUf == null) {
            return false;
        }
        this.cUf.hJ(true);
        return true;
    }

    public boolean asq() {
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
            if (!z && arX()) {
                i = 0;
            }
            this.cUj.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int asr() {
        if (TextUtils.isEmpty(com.baidu.swan.apps.runtime.e.aMn())) {
            return 0;
        }
        if (com.baidu.swan.apps.database.favorite.a.oj(com.baidu.swan.apps.runtime.e.aMn())) {
            return 2;
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean ass() {
        return "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u".equals(com.baidu.swan.apps.runtime.e.aMn());
    }

    public void ast() {
        com.baidu.swan.apps.scheme.actions.k.a.aa("backtohome", "menu", com.baidu.swan.apps.v.f.aDH().aDq());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "gohome";
        fVar.mSource = "menu";
        a(fVar);
    }

    public void arG() {
    }

    public com.baidu.swan.apps.model.c asu() {
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

    public View asv() {
        return this.cUe;
    }
}
