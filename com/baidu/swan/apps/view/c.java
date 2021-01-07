package com.baidu.swan.apps.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.mobstat.Config;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ao.ah;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.ao.ap;
import com.baidu.swan.apps.ao.s;
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
import kotlin.h;
/* loaded from: classes9.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static Boolean dUF = null;
    private static View dUi;
    private static View dUj;
    public SwanAppRoundedImageView cTu;
    public BdBaseImageView cTv;
    public TextView cTw;
    private boolean dUH;
    public View dUk;
    public TextView dUl;
    public ImageView dUm;
    public ImageView dUn;
    private ImageView dUo;
    private ImageView dUp;
    public RelativeLayout dUq;
    private View dUr;
    private com.baidu.swan.apps.e.a dUs;
    private SwanAppActivity dUt;
    private View dUu;
    private SwanLoadingTipsView dUv;
    private com.baidu.swan.games.loading.a dUw;
    private TextView dUx;
    private ValueAnimator dUy;
    private boolean dUz = false;
    private float dUA = 0.0f;
    private float dUB = 0.0f;
    private float dUC = 0.0f;
    private long dUD = 0;
    private a dUE = null;
    private String dUG = "";

    public c(SwanAppActivity swanAppActivity) {
        this.dUH = com.baidu.swan.apps.runtime.d.aMh().ajl() != 1;
        this.dUt = swanAppActivity;
    }

    public static void dU(final Context context) {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.view.c.1
            @Override // java.lang.Runnable
            public void run() {
                c.dV(context);
            }
        }, 5000L);
    }

    public static void dV(Context context) {
        if (dUi == null) {
            dUi = r(context, false);
        }
        if (dUj == null) {
            dUj = r(context, true);
        }
        if (DEBUG) {
            Log.i("SwanAppLoadingView", "obtainPreloadContainer:  App=" + dUi + " Game=" + dUj);
        }
    }

    public static void aSz() {
        dUi = null;
        dUj = null;
    }

    private View q(Context context, boolean z) {
        View view = z ? dUj : dUi;
        if (z) {
            dUj = null;
        } else {
            dUi = null;
        }
        boolean z2 = (view == null || view.isAttachedToWindow()) ? false : true;
        if (z2) {
            dU(context);
        }
        if (!z2) {
            view = r(context, z);
        }
        if (DEBUG) {
            Log.i("SwanAppLoadingView", "obtainPreloadContainer:  isLegalContainer= " + z2 + " game=" + z + " container=" + view);
        }
        return view;
    }

    private static View r(Context context, boolean z) {
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
        this.dUH = com.baidu.swan.apps.runtime.d.aMh().ajl() != 1;
        this.dUD = 0L;
        String aCP = com.baidu.swan.apps.runtime.d.aMh().aMd().aMp().aCP();
        boolean z4 = this.dUE == null || (this.dUE.dUJ ^ z) || TextUtils.isEmpty(aCP) || !TextUtils.equals(aCP, this.dUE.dUK);
        if (DEBUG) {
            Log.i("SwanAppLoadingView", "showSwanAppStartView: newLaunchId = " + aCP + " newIsGameLoading = " + z + " reCreateStarter = " + z4 + " mViewStarter = " + this.dUE);
        }
        Handler mainHandler = com.baidu.swan.apps.runtime.d.getMainHandler();
        if (this.dUE != null) {
            if (DEBUG) {
                Log.i("SwanAppLoadingView", "showSwanAppStartView: oldLaunchId = " + this.dUE.dUK + " oldIsGameLoading = " + this.dUE.dUJ);
            }
            mainHandler.removeCallbacks(this.dUE);
        }
        if (z4) {
            this.dUE = new a(aCP, z);
        }
        if (this.dUE != null) {
            if (aVar == null || !aVar.getBoolean(" event_params_pkg_update", false)) {
                z3 = false;
            }
            if (this.dUE.dUM) {
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
                this.dUE.aSM();
            }
            if (z2) {
                this.dUE.hK(false);
                return;
            }
            if (DEBUG) {
                Log.i("SwanAppLoadingView", "showSwanAppStartView: post starter trace = " + Log.getStackTraceString(new Throwable()));
            }
            mainHandler.post(this.dUE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(boolean z, boolean z2) {
        synchronized (c.class) {
            if (this.dUs == null) {
                this.dUs = new com.baidu.swan.apps.e.a();
            }
            this.dUk = q(this.dUt, z);
            if (!z) {
                this.dUk.setPadding(0, com.baidu.swan.apps.res.widget.a.dDB ? ah.getStatusBarHeight() : 0, 0, 0);
            } else {
                aSA();
            }
            this.dUx = (TextView) this.dUk.findViewById(a.f.aiapps_loading_progress);
            b.a aMp = com.baidu.swan.apps.runtime.d.aMh().aMd().aMp();
            PMSAppInfo aCM = aMp.aCM();
            t(z, z2);
            this.dUt.ajo().aM(this.dUk);
            this.dUz = true;
            this.dUl = (TextView) this.dUk.findViewById(a.f.aiapps_title);
            this.cTu = (SwanAppRoundedImageView) this.dUk.findViewById(a.f.aiapps_icon);
            this.cTv = (BdBaseImageView) this.dUk.findViewById(a.f.aiapps_label_bg);
            this.cTw = (TextView) this.dUk.findViewById(a.f.aiapps_label_tv);
            this.dUq = (RelativeLayout) this.dUk.findViewById(a.f.aiapps_icon_rl);
            kO(aMp.awy());
            vi(aMp.getIconUrl());
            lX(aMp.getType());
            this.dUm = (ImageView) this.dUk.findViewById(a.f.light_print);
            this.dUn = (ImageView) this.dUk.findViewById(a.f.dark_print);
            this.dUo = (ImageView) this.dUk.findViewById(a.f.titlebar_right_menu_img);
            this.dUp = (ImageView) this.dUk.findViewById(a.f.titlebar_right_menu_exit);
            this.dUr = this.dUk.findViewById(a.f.titlebar_right_menu);
            if (z) {
                this.dUo.setClickable(true);
                this.dUo.setImageResource(a.e.aiapps_action_bar_single_menu_white_selector);
                this.dUp.setImageResource(a.e.aiapps_action_bar_exit_white_selector);
                this.dUr.setBackgroundResource(a.e.aiapps_action_bar_right_menu_bg_solid);
                this.dUu = this.dUk.findViewById(a.f.titlebar_right_menu_line);
                this.dUu.setBackgroundResource(a.c.aiapps_action_bar_menu_line_white);
            } else {
                this.dUo.setImageResource(a.e.aiapps_action_bar_menu_black_selector);
                this.dUp.setImageResource(a.e.aiapps_action_bar_exit_black_selector);
                this.dUr.setBackgroundResource(a.e.aiapps_action_bar_right_menu_bg);
            }
            int i = aCM == null ? PMSConstants.PayProtected.NO_PAY_PROTECTED.type : aCM.payProtected;
            if (!z && ak.aRQ() && i == PMSConstants.PayProtected.PAY_PROTECTED.type) {
                ((RelativeLayout) this.dUk.findViewById(a.f.guarantee_plan_rl)).setVisibility(0);
            }
            this.dUn.setAlpha(0.0f);
            this.dUs.g(this.dUt);
            aSC();
        }
    }

    private void aSA() {
        this.dUv = (SwanLoadingTipsView) this.dUk.findViewById(a.f.aigames_loading_game_tips);
        this.dUv.setTipsAnimationFinishCallback(new kotlin.jvm.a.a<h>() { // from class: com.baidu.swan.apps.view.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.a.a
            /* renamed from: aSG */
            public h invoke() {
                c.this.aSB();
                return null;
            }
        });
        this.dUw = new com.baidu.swan.games.loading.a();
        this.dUk.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.swan.apps.view.c.3
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                c.this.aSB();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSB() {
        if (this.dUv != null && this.dUw != null) {
            this.dUv.xP(this.dUw.bbe());
        }
    }

    private void aSC() {
        this.dUp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.view.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.dUt != null && !c.this.dUt.isFinishing()) {
                    HybridUbcFlow aHB = com.baidu.swan.apps.performance.i.aHB();
                    if (aHB != null) {
                        aHB.cn("exitType", String.valueOf(3));
                        aHB.q("value", "cancel");
                        aHB.aHh();
                    }
                    c.this.dUt.moveTaskToBack(true);
                    ap.aSb().lQ(2);
                    c.this.aSD();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSD() {
        Bundle aCB;
        b.a ajv = this.dUt.ajv();
        if (ajv != null && (aCB = ajv.aCB()) != null) {
            long j = aCB.getLong("page_display_flag_for_statistic");
            aCB.remove("page_display_flag_for_statistic");
            if (j > 0) {
                String valueOf = String.valueOf(System.currentTimeMillis() - ajv.getLong("launch_time", 0L));
                f fVar = new f();
                fVar.mType = Config.LAUNCH;
                fVar.mValue = "realcancel";
                fVar.dOl = valueOf;
                fVar.t(TiebaInitialize.LogFields.REASON, "close");
                if (ajv.getAppFrameType() == 1) {
                    fVar.t("errorList", com.baidu.swan.games.v.b.bbT().bbU());
                }
                this.dUt.a(fVar);
                e.b(ajv);
            }
        }
    }

    private void lX(int i) {
        ah.a(this.cTv, this.cTw, String.valueOf(i));
    }

    public void lY(final int i) {
        Handler mainHandler = com.baidu.swan.apps.runtime.d.getMainHandler();
        if (this.dUE != null) {
            mainHandler.removeCallbacks(this.dUE);
            this.dUE.onDestroy();
            this.dUE = null;
        }
        mainHandler.post(new Runnable() { // from class: com.baidu.swan.apps.view.c.5
            @Override // java.lang.Runnable
            public void run() {
                synchronized (c.class) {
                    com.baidu.swan.apps.performance.i.aHA().f(new UbcFlowEvent("first_anim_end"));
                    com.baidu.swan.apps.aj.a.aOJ().tr("first_anim_end");
                    if (c.this.dUs != null) {
                        c.this.dUs.a(c.this.dUt, i);
                    }
                    c.this.dUz = false;
                }
            }
        });
    }

    public void ang() {
        if (DEBUG) {
            Log.i("SwanAppLoadingView", "stopAnimations: " + Log.getStackTraceString(new Exception()));
        }
        Handler mainHandler = com.baidu.swan.apps.runtime.d.getMainHandler();
        if (this.dUE != null) {
            mainHandler.removeCallbacks(this.dUE);
            this.dUE.onDestroy();
            this.dUE = null;
        }
        synchronized (c.class) {
            if (this.dUs != null) {
                this.dUs.ang();
            }
            if (this.dUv != null) {
                this.dUv.doDestroy();
                this.dUv = null;
            }
            if (this.dUx != null) {
                this.dUx.setVisibility(8);
                this.dUx = null;
                this.dUG = "";
                this.dUB = 0.0f;
                this.dUA = 0.0f;
                this.dUC = 0.0f;
            }
            if (this.dUy != null) {
                this.dUy.removeAllUpdateListeners();
                this.dUy.cancel();
                this.dUy = null;
            }
            this.dUz = false;
            if (this.dUE != null) {
                this.dUE.onDestroy();
                this.dUE = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(Bitmap bitmap) {
        if (bitmap != null && this.cTu != null) {
            this.cTu.setImageBitmap(bitmap);
        }
    }

    public void S(float f) {
        if (DEBUG) {
            Log.i("SwanAppLoadingView", "onDownloadProgressUpdate: " + f + " view: " + this.dUx);
        }
        if (this.dUx != null) {
            float f2 = f >= 0.0f ? f : 0.0f;
            this.dUA = f2 <= 1.0f ? f2 : 1.0f;
            aSE();
            if (this.dUH) {
                if (this.dUD == 0) {
                    this.dUD = System.currentTimeMillis();
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.dUD > 2000) {
                    com.baidu.swan.apps.core.f.bu("pms_downloadPkg", "包下载进度更新间隔大于2秒");
                    this.dUH = false;
                }
                this.dUD = currentTimeMillis;
            }
        }
    }

    private void s(boolean z, boolean z2) {
        if (z) {
            this.dUG = "";
        } else {
            this.dUG = this.dUx.getContext().getString(z2 ? a.h.swan_loading_view_tag_updating : a.h.swan_loading_view_tag_loading);
        }
    }

    public void t(boolean z, boolean z2) {
        if (this.dUx != null) {
            if (this.dUy != null) {
                this.dUy.cancel();
                this.dUy.removeAllUpdateListeners();
            }
            s(z, z2);
            this.dUB = 0.0f;
            this.dUA = 0.0f;
            this.dUC = 0.0f;
            if (z) {
                aSE();
                this.dUy = ValueAnimator.ofFloat(0.0f, 1.0f);
                this.dUy.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.view.c.6
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        if (floatValue > 0.9f || floatValue - c.this.dUB > 0.05d) {
                            c.this.dUB = floatValue;
                            c.this.aSE();
                        }
                    }
                });
                this.dUy.setDuration(4000L);
                this.dUy.start();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSE() {
        if (this.dUx != null) {
            float v = v(this.dUB, this.dUA);
            T(v <= 1.0f ? v : 1.0f);
        }
    }

    private void T(float f) {
        if (this.dUx != null && this.dUC <= f) {
            this.dUC = f;
            if (DEBUG) {
                Log.i("SwanAppLoadingView", "setProgressText: " + this.dUC);
            }
            int i = (int) (1000.0f * f);
            int i2 = i / 10;
            String str = ((i % 10 >= 5 ? 1 : 0) + i2) + "%";
            String trim = this.dUG.trim();
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(trim)) {
                sb.append(trim).append(" ");
            }
            sb.append(str);
            if (this.dUE != null && !this.dUE.dUJ) {
                if (this.dUE.aSJ()) {
                    if (DEBUG) {
                        Log.i("SwanAppLoadingView", "setProgressText: checking update");
                    }
                    this.dUx.setText(this.dUx.getContext().getString(a.h.swanapp_swan_loading_runtime_check_updating));
                    this.dUx.setVisibility(0);
                } else if (this.dUE.aSK() && this.dUC <= 0.0f) {
                    if (DEBUG) {
                        Log.i("SwanAppLoadingView", "setProgressText: checking update");
                    }
                    this.dUx.setText(this.dUx.getContext().getString(a.h.swanapp_swan_loading_runtime_check_updating));
                    this.dUx.setVisibility(0);
                } else if (this.dUE.aSJ()) {
                    if (DEBUG) {
                        Log.i("SwanAppLoadingView", "setProgressText: Framework loading");
                    }
                    this.dUx.setText(this.dUx.getContext().getString(a.h.swanapp_swan_loading_runtime_loading));
                    this.dUx.setVisibility(0);
                } else if (this.dUE.dUO && !this.dUE.aSL()) {
                    if (DEBUG) {
                        Log.i("SwanAppLoadingView", "setProgressText: Framework loading");
                    }
                    this.dUx.setText(this.dUx.getContext().getString(a.h.swanapp_swan_loading_runtime_loading));
                    this.dUx.setVisibility(0);
                } else if (this.dUC >= 1.0f && !this.dUE.aSL()) {
                    if (DEBUG) {
                        Log.i("SwanAppLoadingView", "setProgressText: Framework loading");
                    }
                    this.dUx.setText(this.dUx.getContext().getString(a.h.swanapp_swan_loading_runtime_loading));
                    this.dUx.setVisibility(0);
                } else {
                    this.dUx.setText(sb);
                }
            } else {
                this.dUx.setText(sb);
            }
            if (f > 0.0f) {
                this.dUx.setVisibility(0);
            }
        }
    }

    private float v(float f, float f2) {
        return ((1.0f - f) * f2) + f;
    }

    public void aSF() {
        if (this.dUx != null) {
            if (this.dUy != null) {
                this.dUy.removeAllUpdateListeners();
                this.dUy.cancel();
                this.dUy = null;
            }
            T(1.0f);
        }
    }

    public void vi(String str) {
        if (DEBUG) {
            Log.i("SwanAppLoadingView", "updateIcon: icon=" + str);
        }
        final String appId = com.baidu.swan.apps.runtime.d.aMh().getAppId();
        if (this.dUz) {
            this.cTu.setImageBitmap(ak.a(str, "SwanAppLoadingView", true, new s.a() { // from class: com.baidu.swan.apps.view.c.7
                @Override // com.baidu.swan.apps.ao.s.a
                public void g(String str2, Bitmap bitmap) {
                    SwanAppActivity aMf;
                    c ajp;
                    if (bitmap != null && (aMf = com.baidu.swan.apps.runtime.d.aMh().aMf()) != null && !aMf.isDestroyed() && (ajp = aMf.ajp()) != null && TextUtils.equals(appId, com.baidu.swan.apps.runtime.d.aMh().getAppId())) {
                        ajp.s(bitmap);
                    }
                }
            }));
        }
    }

    public void kO(String str) {
        if (this.dUz && !TextUtils.isEmpty(str)) {
            this.dUl.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a implements Runnable {
        final com.baidu.swan.apps.runtime.b cEt;
        final boolean dUJ;
        final String dUK;
        private boolean dUO;
        boolean dUL = false;
        boolean dUM = false;
        private int dHi = -1;
        private int dUN = -1;

        a(String str, boolean z) {
            this.dUK = str;
            this.dUJ = z;
            this.cEt = new com.baidu.swan.apps.runtime.b().a(new com.baidu.swan.apps.ao.e.b<i.a>() { // from class: com.baidu.swan.apps.view.c.a.7
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ao.e.b
                /* renamed from: b */
                public void L(i.a aVar) {
                    if (c.DEBUG) {
                        Log.i("SwanAppLoadingView", "onCallback: EVENT_PMS_CHECK_START");
                    }
                    a.this.dHi = aVar.getInt("KEY_PKG_STATE", -1);
                    a.this.aSH();
                }
            }, "event_pms_check_start").a(new com.baidu.swan.apps.ao.e.b<i.a>() { // from class: com.baidu.swan.apps.view.c.a.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ao.e.b
                /* renamed from: b */
                public void L(i.a aVar) {
                    if (c.DEBUG) {
                        Log.i("SwanAppLoadingView", "onCallback: EVENT_PMS_CHECK_FINISH");
                    }
                    a.this.dHi = aVar.getInt("KEY_PKG_STATE", -1);
                    a.this.aSH();
                }
            }, "event_pms_check_finish").a(new com.baidu.swan.apps.ao.e.b<i.a>() { // from class: com.baidu.swan.apps.view.c.a.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ao.e.b
                /* renamed from: b */
                public void L(i.a aVar) {
                    if (c.DEBUG) {
                        Log.i("SwanAppLoadingView", "onCallback: EVENT_PKG_DOWNLOAD_START");
                    }
                }
            }, "event_pkg_download_start").a(new com.baidu.swan.apps.ao.e.b<i.a>() { // from class: com.baidu.swan.apps.view.c.a.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ao.e.b
                /* renamed from: b */
                public void L(i.a aVar) {
                    if (c.DEBUG) {
                        Log.i("SwanAppLoadingView", "onCallback: EVENT_PKG_DOWNLOAD_FINISH");
                    }
                    a.this.dUO = true;
                    a.this.aSH();
                }
            }, "event_pkg_download_finish").a(new com.baidu.swan.apps.ao.e.b<i.a>() { // from class: com.baidu.swan.apps.view.c.a.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ao.e.b
                /* renamed from: b */
                public void L(i.a aVar) {
                    if (c.DEBUG) {
                        Log.i("SwanAppLoadingView", "onCallback: EVENT_PRELOAD_START");
                    }
                }
            }, "event_preload_start").a(new com.baidu.swan.apps.ao.e.b<i.a>() { // from class: com.baidu.swan.apps.view.c.a.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ao.e.b
                /* renamed from: b */
                public void L(i.a aVar) {
                    if (c.DEBUG) {
                        Log.i("SwanAppLoadingView", "onCallback: EVENT_PRELOAD_ERROR");
                    }
                }
            }, "event_preload_error").a(new com.baidu.swan.apps.ao.e.b<i.a>() { // from class: com.baidu.swan.apps.view.c.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ao.e.b
                /* renamed from: b */
                public void L(i.a aVar) {
                    if (c.DEBUG) {
                        Log.i("SwanAppLoadingView", "onCallback: EVENT_PRELOAD_FINISH");
                    }
                    a.this.dUN = aVar.getInt("KEY_PRELOAD_STATE");
                    a.this.aSH();
                }
            }, "event_preload_finish");
            com.baidu.swan.apps.runtime.d.aMh().v(this.cEt);
        }

        void aSH() {
            boolean aSJ = aSJ();
            boolean aSI = aSI();
            boolean aSL = aSL();
            if (c.DEBUG) {
                Log.i("SwanAppLoadingView", "checkAndUpdateProgress: runtimeLoading " + aSJ);
                Log.i("SwanAppLoadingView", "checkAndUpdateProgress: checkingUpdate " + aSI);
                Log.i("SwanAppLoadingView", "checkAndUpdateProgress: preloadFinish " + aSL);
            }
            if (aSJ || aSI || !aSL) {
                c.this.aSE();
            }
        }

        boolean aSI() {
            boolean aSK = aSK();
            boolean aSL = aSL();
            boolean z = aSK && aSL;
            if (c.DEBUG) {
                Log.i("SwanAppLoadingView", "isCheckingUpdate: overMaxAge " + aSK);
                Log.i("SwanAppLoadingView", "isCheckingUpdate: preloadFinish " + aSL);
                Log.i("SwanAppLoadingView", "isCheckingUpdate: " + z);
            }
            return z;
        }

        boolean aSJ() {
            boolean z = this.dHi == 4;
            boolean aSL = aSL();
            if (c.DEBUG) {
                Log.i("SwanAppLoadingView", "isRuntimeLoading: isLocalPackage " + z);
                Log.i("SwanAppLoadingView", "isRuntimeLoading: preloadFinish " + aSL);
            }
            return z && !aSL;
        }

        boolean aSK() {
            boolean z = true;
            if (this.dHi != 3 && this.dHi != 1) {
                z = false;
            }
            if (c.DEBUG) {
                Log.i("SwanAppLoadingView", "isOverMaxAge: isOverMaxAge " + z);
            }
            return z;
        }

        boolean aSL() {
            boolean avJ = com.baidu.swan.apps.core.turbo.d.avB().avJ();
            if (c.DEBUG) {
                Log.i("SwanAppLoadingView", "isPreloadFinish: runtimeReady " + avJ);
            }
            return avJ;
        }

        void onDestroy() {
            if (c.DEBUG) {
                Log.i("SwanAppLoadingView", "onDestroy: ");
            }
            com.baidu.swan.apps.runtime.d.aMh().w(this.cEt);
        }

        a aSM() {
            this.dUL = true;
            return this;
        }

        @Override // java.lang.Runnable
        public void run() {
            hK(true);
        }

        public void hK(boolean z) {
            if (c.DEBUG) {
                Log.i("SwanAppLoadingView", "ViewStarter exec : post = " + z + " trace = " + (z ? "post" : Log.getStackTraceString(new Exception())));
            }
            this.dUM = true;
            c.this.r(this.dUJ, this.dUL);
        }
    }
}
