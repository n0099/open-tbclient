package com.baidu.swan.apps.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.mobstat.Config;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ap.ah;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.ap.ap;
import com.baidu.swan.apps.ap.s;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.res.ui.BdBaseImageView;
import com.baidu.swan.apps.runtime.i;
import com.baidu.swan.apps.statistic.a.f;
import com.baidu.swan.apps.statistic.e;
import com.baidu.swan.apps.u.c.b;
import com.baidu.swan.games.loading.SwanLoadingTipsView;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.swan.pms.model.PMSAppInfo;
import kotlin.l;
/* loaded from: classes10.dex */
public class c {
    private static View dFZ;
    private static View dGa;
    public SwanAppRoundedImageView cJq;
    public BdBaseImageView cJr;
    public TextView cJs;
    public View dGb;
    public TextView dGc;
    public ImageView dGd;
    public ImageView dGe;
    private ImageView dGf;
    public RelativeLayout dGg;
    private com.baidu.swan.apps.e.a dGh;
    private SwanAppActivity dGi;
    private View dGj;
    private SwanLoadingTipsView dGk;
    private com.baidu.swan.games.loading.a dGl;
    private TextView dGm;
    private ValueAnimator dGn;
    private boolean dGo = false;
    private float dGp = 0.0f;
    private float dGq = 0.0f;
    private float dGr = 0.0f;
    private long dGs = 0;
    private a dGt = null;
    private String dGv = "";
    private boolean dGw;
    private View mRightMenu;
    private ImageView mRightMenuImageView;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static Boolean dGu = null;

    public c(SwanAppActivity swanAppActivity) {
        this.dGw = com.baidu.swan.apps.runtime.d.aHq().afE() != 1;
        this.dGi = swanAppActivity;
    }

    public static void cV(final Context context) {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.view.c.1
            @Override // java.lang.Runnable
            public void run() {
                c.cW(context);
            }
        }, 5000L);
    }

    public static void cW(Context context) {
        if (dFZ == null) {
            dFZ = p(context, false);
        }
        if (dGa == null) {
            dGa = p(context, true);
        }
        if (DEBUG) {
            Log.i("SwanAppLoadingView", "obtainPreloadContainer:  App=" + dFZ + " Game=" + dGa);
        }
    }

    public static void aNF() {
        dFZ = null;
        dGa = null;
    }

    private View o(Context context, boolean z) {
        View view = z ? dGa : dFZ;
        if (z) {
            dGa = null;
        } else {
            dFZ = null;
        }
        boolean z2 = (view == null || view.isAttachedToWindow()) ? false : true;
        if (z2) {
            cV(context);
        }
        if (!z2) {
            view = p(context, z);
        }
        if (DEBUG) {
            Log.i("SwanAppLoadingView", "obtainPreloadContainer:  isLegalContainer= " + z2 + " game=" + z + " container=" + view);
        }
        return view;
    }

    private static View p(Context context, boolean z) {
        try {
            return LayoutInflater.from(context).inflate(z ? a.g.ai_games_loading_fragment : a.g.aiapps_loading_fragment, (ViewGroup) null);
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            return null;
        }
    }

    public void a(boolean z, boolean z2, @Nullable i.a aVar) {
        boolean z3 = true;
        this.dGw = com.baidu.swan.apps.runtime.d.aHq().afE() != 1;
        this.dGs = 0L;
        String ayW = com.baidu.swan.apps.runtime.d.aHq().aHm().aHy().ayW();
        boolean z4 = this.dGt == null || (this.dGt.dGy ^ z) || TextUtils.isEmpty(ayW) || !TextUtils.equals(ayW, this.dGt.dGz);
        if (DEBUG) {
            Log.i("SwanAppLoadingView", "showSwanAppStartView: newLaunchId = " + ayW + " newIsGameLoading = " + z + " reCreateStarter = " + z4 + " mViewStarter = " + this.dGt);
        }
        Handler mainHandler = com.baidu.swan.apps.runtime.d.getMainHandler();
        if (this.dGt != null) {
            if (DEBUG) {
                Log.i("SwanAppLoadingView", "showSwanAppStartView: oldLaunchId = " + this.dGt.dGz + " oldIsGameLoading = " + this.dGt.dGy);
            }
            mainHandler.removeCallbacks(this.dGt);
        }
        if (z4) {
            this.dGt = new a(ayW, z);
        }
        if (this.dGt != null) {
            if (aVar == null || !aVar.getBoolean(" event_params_pkg_update", false)) {
                z3 = false;
            }
            if (this.dGt.dGB) {
                if (DEBUG) {
                    Log.i("SwanAppLoadingView", "showSwanAppStartView: return by executing pkgUpdating = " + z3 + " trace = " + Log.getStackTraceString(new Exception()));
                }
                if (z3) {
                    s(z, z3);
                    return;
                }
                return;
            }
            if (z3) {
                this.dGt.aNS();
            }
            if (z2) {
                this.dGt.ha(false);
                return;
            }
            if (DEBUG) {
                Log.i("SwanAppLoadingView", "showSwanAppStartView: post starter trace = " + Log.getStackTraceString(new Throwable()));
            }
            mainHandler.post(this.dGt);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(boolean z, boolean z2) {
        synchronized (c.class) {
            if (this.dGh == null) {
                this.dGh = new com.baidu.swan.apps.e.a();
            }
            this.dGb = o(this.dGi, z);
            if (!z) {
                this.dGb.setPadding(0, com.baidu.swan.apps.res.widget.a.SUPPORT_IMMERSION ? ah.getStatusBarHeight() : 0, 0, 0);
            } else {
                aNG();
            }
            this.dGm = (TextView) this.dGb.findViewById(a.f.aiapps_loading_progress);
            b.a aHy = com.baidu.swan.apps.runtime.d.aHq().aHm().aHy();
            PMSAppInfo ayT = aHy.ayT();
            t(z, z2);
            this.dGi.afH().aC(this.dGb);
            this.dGo = true;
            this.dGc = (TextView) this.dGb.findViewById(a.f.aiapps_title);
            this.cJq = (SwanAppRoundedImageView) this.dGb.findViewById(a.f.aiapps_icon);
            this.cJr = (BdBaseImageView) this.dGb.findViewById(a.f.aiapps_label_bg);
            this.cJs = (TextView) this.dGb.findViewById(a.f.aiapps_label_tv);
            this.dGg = (RelativeLayout) this.dGb.findViewById(a.f.aiapps_icon_rl);
            ku(aHy.asF());
            uH(aHy.getIconUrl());
            lw(aHy.getType());
            this.dGd = (ImageView) this.dGb.findViewById(a.f.light_print);
            this.dGe = (ImageView) this.dGb.findViewById(a.f.dark_print);
            this.mRightMenuImageView = (ImageView) this.dGb.findViewById(a.f.titlebar_right_menu_img);
            this.dGf = (ImageView) this.dGb.findViewById(a.f.titlebar_right_menu_exit);
            this.mRightMenu = this.dGb.findViewById(a.f.titlebar_right_menu);
            if (z) {
                this.mRightMenuImageView.setClickable(true);
                this.mRightMenuImageView.setImageResource(a.e.aiapps_action_bar_single_menu_white_selector);
                this.dGf.setImageResource(a.e.aiapps_action_bar_exit_white_selector);
                this.mRightMenu.setBackgroundResource(a.e.aiapps_action_bar_right_menu_bg_solid);
                this.dGj = this.dGb.findViewById(a.f.titlebar_right_menu_line);
                this.dGj.setBackgroundResource(a.c.aiapps_action_bar_menu_line_white);
            } else {
                this.mRightMenuImageView.setImageResource(a.e.aiapps_action_bar_menu_black_selector);
                this.dGf.setImageResource(a.e.aiapps_action_bar_exit_black_selector);
                this.mRightMenu.setBackgroundResource(a.e.aiapps_action_bar_right_menu_bg);
            }
            int i = ayT == null ? PMSConstants.PayProtected.NO_PAY_PROTECTED.type : ayT.payProtected;
            if (!z && ak.aNa() && i == PMSConstants.PayProtected.PAY_PROTECTED.type) {
                ((RelativeLayout) this.dGb.findViewById(a.f.guarantee_plan_rl)).setVisibility(0);
            }
            this.dGe.setAlpha(0.0f);
            this.dGh.g(this.dGi);
            aNI();
        }
    }

    private void aNG() {
        this.dGk = (SwanLoadingTipsView) this.dGb.findViewById(a.f.aigames_loading_game_tips);
        this.dGk.setTipsAnimationFinishCallback(new kotlin.jvm.a.a<l>() { // from class: com.baidu.swan.apps.view.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.a.a
            /* renamed from: aNM */
            public l invoke() {
                c.this.aNH();
                return null;
            }
        });
        this.dGl = new com.baidu.swan.games.loading.a();
        this.dGb.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.swan.apps.view.c.3
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                c.this.aNH();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNH() {
        if (this.dGk != null && this.dGl != null) {
            this.dGk.xo(this.dGl.aWm());
        }
    }

    private void aNI() {
        this.dGf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.view.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.dGi != null && !c.this.dGi.isFinishing()) {
                    HybridUbcFlow aDH = com.baidu.swan.apps.performance.i.aDH();
                    if (aDH != null) {
                        aDH.ci("exitType", String.valueOf(3));
                        aDH.r("value", "cancel");
                        aDH.aDm();
                    }
                    c.this.dGi.moveTaskToBack(true);
                    ap.aNk().lr(2);
                    c.this.aNJ();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNJ() {
        Bundle ayI;
        b.a afO = this.dGi.afO();
        if (afO != null && (ayI = afO.ayI()) != null) {
            long j = ayI.getLong("page_display_flag_for_statistic");
            ayI.remove("page_display_flag_for_statistic");
            if (j > 0) {
                String valueOf = String.valueOf(System.currentTimeMillis() - afO.getLong("launch_time", 0L));
                f fVar = new f();
                fVar.mType = Config.LAUNCH;
                fVar.mValue = "realcancel";
                fVar.dAp = valueOf;
                fVar.u(TiebaInitialize.LogFields.REASON, "close");
                if (afO.getAppFrameType() == 1) {
                    fVar.u("errorList", com.baidu.swan.games.v.b.aXb().aXc());
                }
                this.dGi.a(fVar);
                e.b(afO);
            }
        }
    }

    private void lw(int i) {
        ah.a(this.cJr, this.cJs, String.valueOf(i));
    }

    public void lx(final int i) {
        Handler mainHandler = com.baidu.swan.apps.runtime.d.getMainHandler();
        if (this.dGt != null) {
            mainHandler.removeCallbacks(this.dGt);
            this.dGt.onDestroy();
            this.dGt = null;
        }
        mainHandler.post(new Runnable() { // from class: com.baidu.swan.apps.view.c.5
            @Override // java.lang.Runnable
            public void run() {
                synchronized (c.class) {
                    com.baidu.swan.apps.performance.i.aDG().f(new UbcFlowEvent("first_anim_end"));
                    com.baidu.swan.apps.ak.a.aJS().sS("first_anim_end");
                    if (c.this.dGh != null) {
                        c.this.dGh.a(c.this.dGi, i);
                    }
                    c.this.dGo = false;
                }
            }
        });
    }

    public void ajv() {
        if (DEBUG) {
            Log.i("SwanAppLoadingView", "stopAnimations: " + Log.getStackTraceString(new Exception()));
        }
        Handler mainHandler = com.baidu.swan.apps.runtime.d.getMainHandler();
        if (this.dGt != null) {
            mainHandler.removeCallbacks(this.dGt);
            this.dGt.onDestroy();
            this.dGt = null;
        }
        synchronized (c.class) {
            if (this.dGh != null) {
                this.dGh.ajv();
            }
            if (this.dGk != null) {
                this.dGk.doDestroy();
                this.dGk = null;
            }
            if (this.dGm != null) {
                this.dGm.setVisibility(8);
                this.dGm = null;
                this.dGv = "";
                this.dGq = 0.0f;
                this.dGp = 0.0f;
                this.dGr = 0.0f;
            }
            if (this.dGn != null) {
                this.dGn.removeAllUpdateListeners();
                this.dGn.cancel();
                this.dGn = null;
            }
            this.dGo = false;
            if (this.dGt != null) {
                this.dGt.onDestroy();
                this.dGt = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(Bitmap bitmap) {
        if (bitmap != null && this.cJq != null) {
            this.cJq.setImageBitmap(bitmap);
        }
    }

    public void R(float f) {
        if (DEBUG) {
            Log.i("SwanAppLoadingView", "onDownloadProgressUpdate: " + f + " view: " + this.dGm);
        }
        if (this.dGm != null) {
            float f2 = f >= 0.0f ? f : 0.0f;
            this.dGp = f2 <= 1.0f ? f2 : 1.0f;
            aNK();
            if (this.dGw) {
                if (this.dGs == 0) {
                    this.dGs = System.currentTimeMillis();
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.dGs > 2000) {
                    com.baidu.swan.apps.core.f.bp("pms_downloadPkg", "包下载进度更新间隔大于2秒");
                    this.dGw = false;
                }
                this.dGs = currentTimeMillis;
            }
        }
    }

    private void s(boolean z, boolean z2) {
        if (z) {
            this.dGv = "";
        } else {
            this.dGv = this.dGm.getContext().getString(z2 ? a.h.swan_loading_view_tag_updating : a.h.swan_loading_view_tag_loading);
        }
    }

    public void t(boolean z, boolean z2) {
        if (this.dGm != null) {
            if (this.dGn != null) {
                this.dGn.cancel();
                this.dGn.removeAllUpdateListeners();
            }
            s(z, z2);
            this.dGq = 0.0f;
            this.dGp = 0.0f;
            this.dGr = 0.0f;
            if (z) {
                aNK();
                this.dGn = ValueAnimator.ofFloat(0.0f, 1.0f);
                this.dGn.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.view.c.6
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        if (floatValue > 0.9f || floatValue - c.this.dGq > 0.05d) {
                            c.this.dGq = floatValue;
                            c.this.aNK();
                        }
                    }
                });
                this.dGn.setDuration(4000L);
                this.dGn.start();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNK() {
        if (this.dGm != null) {
            float v = v(this.dGq, this.dGp);
            S(v <= 1.0f ? v : 1.0f);
        }
    }

    private void S(float f) {
        if (this.dGm != null && this.dGr <= f) {
            this.dGr = f;
            if (DEBUG) {
                Log.i("SwanAppLoadingView", "setProgressText: " + this.dGr);
            }
            int i = (int) (1000.0f * f);
            int i2 = i / 10;
            String str = ((i % 10 >= 5 ? 1 : 0) + i2) + "%";
            String trim = this.dGv.trim();
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(trim)) {
                sb.append(trim).append(" ");
            }
            sb.append(str);
            if (this.dGt != null && !this.dGt.dGy) {
                if (this.dGt.aNP()) {
                    if (DEBUG) {
                        Log.i("SwanAppLoadingView", "setProgressText: checking update");
                    }
                    this.dGm.setText(this.dGm.getContext().getString(a.h.swanapp_swan_loading_runtime_check_updating));
                    this.dGm.setVisibility(0);
                } else if (this.dGt.aNQ() && this.dGr <= 0.0f) {
                    if (DEBUG) {
                        Log.i("SwanAppLoadingView", "setProgressText: checking update");
                    }
                    this.dGm.setText(this.dGm.getContext().getString(a.h.swanapp_swan_loading_runtime_check_updating));
                    this.dGm.setVisibility(0);
                } else if (this.dGt.aNP()) {
                    if (DEBUG) {
                        Log.i("SwanAppLoadingView", "setProgressText: Framework loading");
                    }
                    this.dGm.setText(this.dGm.getContext().getString(a.h.swanapp_swan_loading_runtime_loading));
                    this.dGm.setVisibility(0);
                } else if (this.dGt.dGD && !this.dGt.aNR()) {
                    if (DEBUG) {
                        Log.i("SwanAppLoadingView", "setProgressText: Framework loading");
                    }
                    this.dGm.setText(this.dGm.getContext().getString(a.h.swanapp_swan_loading_runtime_loading));
                    this.dGm.setVisibility(0);
                } else if (this.dGr >= 1.0f && !this.dGt.aNR()) {
                    if (DEBUG) {
                        Log.i("SwanAppLoadingView", "setProgressText: Framework loading");
                    }
                    this.dGm.setText(this.dGm.getContext().getString(a.h.swanapp_swan_loading_runtime_loading));
                    this.dGm.setVisibility(0);
                } else {
                    this.dGm.setText(sb);
                }
            } else {
                this.dGm.setText(sb);
            }
            if (f > 0.0f) {
                this.dGm.setVisibility(0);
            }
        }
    }

    private float v(float f, float f2) {
        return ((1.0f - f) * f2) + f;
    }

    public void aNL() {
        if (this.dGm != null) {
            if (this.dGn != null) {
                this.dGn.removeAllUpdateListeners();
                this.dGn.cancel();
                this.dGn = null;
            }
            S(1.0f);
        }
    }

    public void uH(String str) {
        if (DEBUG) {
            Log.i("SwanAppLoadingView", "updateIcon: icon=" + str);
        }
        final String appId = com.baidu.swan.apps.runtime.d.aHq().getAppId();
        if (this.dGo) {
            this.cJq.setImageBitmap(ak.a(str, "SwanAppLoadingView", true, new s.a() { // from class: com.baidu.swan.apps.view.c.7
                @Override // com.baidu.swan.apps.ap.s.a
                public void g(String str2, Bitmap bitmap) {
                    SwanAppActivity aHo;
                    c afI;
                    if (bitmap != null && (aHo = com.baidu.swan.apps.runtime.d.aHq().aHo()) != null && !aHo.isDestroyed() && (afI = aHo.afI()) != null && TextUtils.equals(appId, com.baidu.swan.apps.runtime.d.aHq().getAppId())) {
                        afI.r(bitmap);
                    }
                }
            }));
        }
    }

    public void ku(String str) {
        if (this.dGo && !TextUtils.isEmpty(str)) {
            this.dGc.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a implements Runnable {
        final com.baidu.swan.apps.runtime.b cux;
        private boolean dGD;
        final boolean dGy;
        final String dGz;
        boolean dGA = false;
        boolean dGB = false;
        private int dtk = -1;
        private int dGC = -1;

        a(String str, boolean z) {
            this.dGz = str;
            this.dGy = z;
            this.cux = new com.baidu.swan.apps.runtime.b().a(new com.baidu.swan.apps.ap.e.b<i.a>() { // from class: com.baidu.swan.apps.view.c.a.7
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ap.e.b
                /* renamed from: b */
                public void M(i.a aVar) {
                    if (c.DEBUG) {
                        Log.i("SwanAppLoadingView", "onCallback: EVENT_PMS_CHECK_START");
                    }
                    a.this.dtk = aVar.getInt("KEY_PKG_STATE", -1);
                    a.this.aNN();
                }
            }, "event_pms_check_start").a(new com.baidu.swan.apps.ap.e.b<i.a>() { // from class: com.baidu.swan.apps.view.c.a.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ap.e.b
                /* renamed from: b */
                public void M(i.a aVar) {
                    if (c.DEBUG) {
                        Log.i("SwanAppLoadingView", "onCallback: EVENT_PMS_CHECK_FINISH");
                    }
                    a.this.dtk = aVar.getInt("KEY_PKG_STATE", -1);
                    a.this.aNN();
                }
            }, "event_pms_check_finish").a(new com.baidu.swan.apps.ap.e.b<i.a>() { // from class: com.baidu.swan.apps.view.c.a.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ap.e.b
                /* renamed from: b */
                public void M(i.a aVar) {
                    if (c.DEBUG) {
                        Log.i("SwanAppLoadingView", "onCallback: EVENT_PKG_DOWNLOAD_START");
                    }
                }
            }, "event_pkg_download_start").a(new com.baidu.swan.apps.ap.e.b<i.a>() { // from class: com.baidu.swan.apps.view.c.a.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ap.e.b
                /* renamed from: b */
                public void M(i.a aVar) {
                    if (c.DEBUG) {
                        Log.i("SwanAppLoadingView", "onCallback: EVENT_PKG_DOWNLOAD_FINISH");
                    }
                    a.this.dGD = true;
                    a.this.aNN();
                }
            }, "event_pkg_download_finish").a(new com.baidu.swan.apps.ap.e.b<i.a>() { // from class: com.baidu.swan.apps.view.c.a.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ap.e.b
                /* renamed from: b */
                public void M(i.a aVar) {
                    if (c.DEBUG) {
                        Log.i("SwanAppLoadingView", "onCallback: EVENT_PRELOAD_START");
                    }
                }
            }, "event_preload_start").a(new com.baidu.swan.apps.ap.e.b<i.a>() { // from class: com.baidu.swan.apps.view.c.a.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ap.e.b
                /* renamed from: b */
                public void M(i.a aVar) {
                    if (c.DEBUG) {
                        Log.i("SwanAppLoadingView", "onCallback: EVENT_PRELOAD_ERROR");
                    }
                }
            }, "event_preload_error").a(new com.baidu.swan.apps.ap.e.b<i.a>() { // from class: com.baidu.swan.apps.view.c.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ap.e.b
                /* renamed from: b */
                public void M(i.a aVar) {
                    if (c.DEBUG) {
                        Log.i("SwanAppLoadingView", "onCallback: EVENT_PRELOAD_FINISH");
                    }
                    a.this.dGC = aVar.getInt("KEY_PRELOAD_STATE");
                    a.this.aNN();
                }
            }, "event_preload_finish");
            com.baidu.swan.apps.runtime.d.aHq().v(this.cux);
        }

        void aNN() {
            boolean aNP = aNP();
            boolean aNO = aNO();
            boolean aNR = aNR();
            if (c.DEBUG) {
                Log.i("SwanAppLoadingView", "checkAndUpdateProgress: runtimeLoading " + aNP);
                Log.i("SwanAppLoadingView", "checkAndUpdateProgress: checkingUpdate " + aNO);
                Log.i("SwanAppLoadingView", "checkAndUpdateProgress: preloadFinish " + aNR);
            }
            if (aNP || aNO || !aNR) {
                c.this.aNK();
            }
        }

        boolean aNO() {
            boolean aNQ = aNQ();
            boolean aNR = aNR();
            boolean z = aNQ && aNR;
            if (c.DEBUG) {
                Log.i("SwanAppLoadingView", "isCheckingUpdate: overMaxAge " + aNQ);
                Log.i("SwanAppLoadingView", "isCheckingUpdate: preloadFinish " + aNR);
                Log.i("SwanAppLoadingView", "isCheckingUpdate: " + z);
            }
            return z;
        }

        boolean aNP() {
            boolean z = this.dtk == 4;
            boolean aNR = aNR();
            if (c.DEBUG) {
                Log.i("SwanAppLoadingView", "isRuntimeLoading: isLocalPackage " + z);
                Log.i("SwanAppLoadingView", "isRuntimeLoading: preloadFinish " + aNR);
            }
            return z && !aNR;
        }

        boolean aNQ() {
            boolean z = true;
            if (this.dtk != 3 && this.dtk != 1) {
                z = false;
            }
            if (c.DEBUG) {
                Log.i("SwanAppLoadingView", "isOverMaxAge: isOverMaxAge " + z);
            }
            return z;
        }

        boolean aNR() {
            boolean arQ = com.baidu.swan.apps.core.turbo.d.arI().arQ();
            if (c.DEBUG) {
                Log.i("SwanAppLoadingView", "isPreloadFinish: runtimeReady " + arQ);
            }
            return arQ;
        }

        void onDestroy() {
            if (c.DEBUG) {
                Log.i("SwanAppLoadingView", "onDestroy: ");
            }
            com.baidu.swan.apps.runtime.d.aHq().w(this.cux);
        }

        a aNS() {
            this.dGA = true;
            return this;
        }

        @Override // java.lang.Runnable
        public void run() {
            ha(true);
        }

        public void ha(boolean z) {
            if (c.DEBUG) {
                Log.i("SwanAppLoadingView", "ViewStarter exec : post = " + z + " trace = " + (z ? "post" : Log.getStackTraceString(new Exception())));
            }
            this.dGB = true;
            c.this.r(this.dGy, this.dGA);
        }
    }
}
