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
    private static View dRC;
    private static View dRD;
    public SwanAppRoundedImageView cQW;
    public BdBaseImageView cQX;
    public TextView cQY;
    public View dRE;
    public TextView dRF;
    public ImageView dRG;
    public ImageView dRH;
    private ImageView dRI;
    private ImageView dRJ;
    public RelativeLayout dRK;
    private View dRL;
    private com.baidu.swan.apps.e.a dRM;
    private SwanAppActivity dRN;
    private View dRO;
    private SwanLoadingTipsView dRP;
    private com.baidu.swan.games.loading.a dRQ;
    private TextView dRR;
    private ValueAnimator dRS;
    private boolean dRT = false;
    private float dRU = 0.0f;
    private float dRV = 0.0f;
    private float dRW = 0.0f;
    private long dRX = 0;
    private a dRY = null;
    private String dSa = "";
    private boolean dSb;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static Boolean dRZ = null;

    public c(SwanAppActivity swanAppActivity) {
        this.dSb = com.baidu.swan.apps.runtime.d.aIG().getFrameType() != 1;
        this.dRN = swanAppActivity;
    }

    public static void dS(final Context context) {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.view.c.1
            @Override // java.lang.Runnable
            public void run() {
                c.dT(context);
            }
        }, 5000L);
    }

    public static void dT(Context context) {
        if (dRC == null) {
            dRC = s(context, false);
        }
        if (dRD == null) {
            dRD = s(context, true);
        }
        if (DEBUG) {
            Log.i("SwanAppLoadingView", "obtainPreloadContainer:  App=" + dRC + " Game=" + dRD);
        }
    }

    public static void aOY() {
        dRC = null;
        dRD = null;
    }

    private View r(Context context, boolean z) {
        View view = z ? dRD : dRC;
        if (z) {
            dRD = null;
        } else {
            dRC = null;
        }
        boolean z2 = (view == null || view.isAttachedToWindow()) ? false : true;
        if (z2) {
            dS(context);
        }
        if (!z2) {
            view = s(context, z);
        }
        if (DEBUG) {
            Log.i("SwanAppLoadingView", "obtainPreloadContainer:  isLegalContainer= " + z2 + " game=" + z + " container=" + view);
        }
        return view;
    }

    private static View s(Context context, boolean z) {
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
        this.dSb = com.baidu.swan.apps.runtime.d.aIG().getFrameType() != 1;
        this.dRX = 0L;
        String azt = com.baidu.swan.apps.runtime.d.aIG().aIC().aIO().azt();
        boolean z4 = this.dRY == null || (this.dRY.dSd ^ z) || TextUtils.isEmpty(azt) || !TextUtils.equals(azt, this.dRY.dSe);
        if (DEBUG) {
            Log.i("SwanAppLoadingView", "showSwanAppStartView: newLaunchId = " + azt + " newIsGameLoading = " + z + " reCreateStarter = " + z4 + " mViewStarter = " + this.dRY);
        }
        Handler mainHandler = com.baidu.swan.apps.runtime.d.getMainHandler();
        if (this.dRY != null) {
            if (DEBUG) {
                Log.i("SwanAppLoadingView", "showSwanAppStartView: oldLaunchId = " + this.dRY.dSe + " oldIsGameLoading = " + this.dRY.dSd);
            }
            mainHandler.removeCallbacks(this.dRY);
        }
        if (z4) {
            this.dRY = new a(azt, z);
        }
        if (this.dRY != null) {
            if (aVar == null || !aVar.getBoolean(" event_params_pkg_update", false)) {
                z3 = false;
            }
            if (this.dRY.dSg) {
                if (DEBUG) {
                    Log.i("SwanAppLoadingView", "showSwanAppStartView: return by executing pkgUpdating = " + z3 + " trace = " + Log.getStackTraceString(new Exception()));
                }
                if (z3) {
                    t(z, z3);
                    return;
                }
                return;
            }
            if (z3) {
                this.dRY.aPl();
            }
            if (z2) {
                this.dRY.hI(false);
                return;
            }
            if (DEBUG) {
                Log.i("SwanAppLoadingView", "showSwanAppStartView: post starter trace = " + Log.getStackTraceString(new Throwable()));
            }
            mainHandler.post(this.dRY);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(boolean z, boolean z2) {
        synchronized (c.class) {
            if (this.dRM == null) {
                this.dRM = new com.baidu.swan.apps.e.a();
            }
            this.dRE = r(this.dRN, z);
            if (!z) {
                this.dRE.setPadding(0, com.baidu.swan.apps.res.widget.a.dAU ? ah.getStatusBarHeight() : 0, 0, 0);
            } else {
                aOZ();
            }
            this.dRR = (TextView) this.dRE.findViewById(a.f.aiapps_loading_progress);
            b.a aIO = com.baidu.swan.apps.runtime.d.aIG().aIC().aIO();
            PMSAppInfo azq = aIO.azq();
            u(z, z2);
            this.dRN.afS().aI(this.dRE);
            this.dRT = true;
            this.dRF = (TextView) this.dRE.findViewById(a.f.aiapps_title);
            this.cQW = (SwanAppRoundedImageView) this.dRE.findViewById(a.f.aiapps_icon);
            this.cQX = (BdBaseImageView) this.dRE.findViewById(a.f.aiapps_label_bg);
            this.cQY = (TextView) this.dRE.findViewById(a.f.aiapps_label_tv);
            this.dRK = (RelativeLayout) this.dRE.findViewById(a.f.aiapps_icon_rl);
            jV(aIO.atc());
            uq(aIO.getIconUrl());
            ku(aIO.getType());
            this.dRG = (ImageView) this.dRE.findViewById(a.f.light_print);
            this.dRH = (ImageView) this.dRE.findViewById(a.f.dark_print);
            this.dRI = (ImageView) this.dRE.findViewById(a.f.titlebar_right_menu_img);
            this.dRJ = (ImageView) this.dRE.findViewById(a.f.titlebar_right_menu_exit);
            this.dRL = this.dRE.findViewById(a.f.titlebar_right_menu);
            if (z) {
                this.dRI.setClickable(true);
                this.dRI.setImageResource(a.e.aiapps_action_bar_single_menu_white_selector);
                this.dRJ.setImageResource(a.e.aiapps_action_bar_exit_white_selector);
                this.dRL.setBackgroundResource(a.e.aiapps_action_bar_right_menu_bg_solid);
                this.dRO = this.dRE.findViewById(a.f.titlebar_right_menu_line);
                this.dRO.setBackgroundResource(a.c.aiapps_action_bar_menu_line_white);
            } else {
                this.dRI.setImageResource(a.e.aiapps_action_bar_menu_black_selector);
                this.dRJ.setImageResource(a.e.aiapps_action_bar_exit_black_selector);
                this.dRL.setBackgroundResource(a.e.aiapps_action_bar_right_menu_bg);
            }
            int i = azq == null ? PMSConstants.PayProtected.NO_PAY_PROTECTED.type : azq.payProtected;
            if (!z && ak.aOp() && i == PMSConstants.PayProtected.PAY_PROTECTED.type) {
                ((RelativeLayout) this.dRE.findViewById(a.f.guarantee_plan_rl)).setVisibility(0);
            }
            this.dRH.setAlpha(0.0f);
            this.dRM.g(this.dRN);
            aPb();
        }
    }

    private void aOZ() {
        this.dRP = (SwanLoadingTipsView) this.dRE.findViewById(a.f.aigames_loading_game_tips);
        this.dRP.setTipsAnimationFinishCallback(new kotlin.jvm.a.a<h>() { // from class: com.baidu.swan.apps.view.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.a.a
            /* renamed from: aPf */
            public h invoke() {
                c.this.aPa();
                return null;
            }
        });
        this.dRQ = new com.baidu.swan.games.loading.a();
        this.dRE.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.swan.apps.view.c.3
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                c.this.aPa();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aPa() {
        if (this.dRP != null && this.dRQ != null) {
            this.dRP.wX(this.dRQ.aXw());
        }
    }

    private void aPb() {
        this.dRJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.view.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.dRN != null && !c.this.dRN.isFinishing()) {
                    HybridUbcFlow aEc = com.baidu.swan.apps.performance.i.aEc();
                    if (aEc != null) {
                        aEc.cg("exitType", String.valueOf(3));
                        aEc.o("value", "cancel");
                        aEc.aDJ();
                    }
                    c.this.dRN.moveTaskToBack(true);
                    ap.aOA().kn(2);
                    c.this.aPc();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aPc() {
        Bundle azf;
        b.a afZ = this.dRN.afZ();
        if (afZ != null && (azf = afZ.azf()) != null) {
            long j = azf.getLong("page_display_flag_for_statistic");
            azf.remove("page_display_flag_for_statistic");
            if (j > 0) {
                String valueOf = String.valueOf(System.currentTimeMillis() - afZ.getLong("launch_time", 0L));
                f fVar = new f();
                fVar.mType = Config.LAUNCH;
                fVar.mValue = "realcancel";
                fVar.dLD = valueOf;
                fVar.r(TiebaInitialize.LogFields.REASON, "close");
                if (afZ.getAppFrameType() == 1) {
                    fVar.r("errorList", com.baidu.swan.games.v.b.aYl().aYm());
                }
                this.dRN.a(fVar);
                e.b(afZ);
            }
        }
    }

    private void ku(int i) {
        ah.a(this.cQX, this.cQY, String.valueOf(i));
    }

    public void kv(final int i) {
        Handler mainHandler = com.baidu.swan.apps.runtime.d.getMainHandler();
        if (this.dRY != null) {
            mainHandler.removeCallbacks(this.dRY);
            this.dRY.onDestroy();
            this.dRY = null;
        }
        mainHandler.post(new Runnable() { // from class: com.baidu.swan.apps.view.c.5
            @Override // java.lang.Runnable
            public void run() {
                synchronized (c.class) {
                    com.baidu.swan.apps.performance.i.aEb().f(new UbcFlowEvent("first_anim_end"));
                    com.baidu.swan.apps.aj.a.aLi().sz("first_anim_end");
                    if (c.this.dRM != null) {
                        c.this.dRM.a(c.this.dRN, i);
                    }
                    c.this.dRT = false;
                }
            }
        });
    }

    public void ajK() {
        if (DEBUG) {
            Log.i("SwanAppLoadingView", "stopAnimations: " + Log.getStackTraceString(new Exception()));
        }
        Handler mainHandler = com.baidu.swan.apps.runtime.d.getMainHandler();
        if (this.dRY != null) {
            mainHandler.removeCallbacks(this.dRY);
            this.dRY.onDestroy();
            this.dRY = null;
        }
        synchronized (c.class) {
            if (this.dRM != null) {
                this.dRM.ajK();
            }
            if (this.dRP != null) {
                this.dRP.doDestroy();
                this.dRP = null;
            }
            if (this.dRR != null) {
                this.dRR.setVisibility(8);
                this.dRR = null;
                this.dSa = "";
                this.dRV = 0.0f;
                this.dRU = 0.0f;
                this.dRW = 0.0f;
            }
            if (this.dRS != null) {
                this.dRS.removeAllUpdateListeners();
                this.dRS.cancel();
                this.dRS = null;
            }
            this.dRT = false;
            if (this.dRY != null) {
                this.dRY.onDestroy();
                this.dRY = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(Bitmap bitmap) {
        if (bitmap != null && this.cQW != null) {
            this.cQW.setImageBitmap(bitmap);
        }
    }

    public void T(float f) {
        if (DEBUG) {
            Log.i("SwanAppLoadingView", "onDownloadProgressUpdate: " + f + " view: " + this.dRR);
        }
        if (this.dRR != null) {
            float f2 = f >= 0.0f ? f : 0.0f;
            this.dRU = f2 <= 1.0f ? f2 : 1.0f;
            aPd();
            if (this.dSb) {
                if (this.dRX == 0) {
                    this.dRX = System.currentTimeMillis();
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.dRX > 2000) {
                    com.baidu.swan.apps.core.f.bn("pms_downloadPkg", "包下载进度更新间隔大于2秒");
                    this.dSb = false;
                }
                this.dRX = currentTimeMillis;
            }
        }
    }

    private void t(boolean z, boolean z2) {
        if (z) {
            this.dSa = "";
        } else {
            this.dSa = this.dRR.getContext().getString(z2 ? a.h.swan_loading_view_tag_updating : a.h.swan_loading_view_tag_loading);
        }
    }

    public void u(boolean z, boolean z2) {
        if (this.dRR != null) {
            if (this.dRS != null) {
                this.dRS.cancel();
                this.dRS.removeAllUpdateListeners();
            }
            t(z, z2);
            this.dRV = 0.0f;
            this.dRU = 0.0f;
            this.dRW = 0.0f;
            if (z) {
                aPd();
                this.dRS = ValueAnimator.ofFloat(0.0f, 1.0f);
                this.dRS.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.view.c.6
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        if (floatValue > 0.9f || floatValue - c.this.dRV > 0.05d) {
                            c.this.dRV = floatValue;
                            c.this.aPd();
                        }
                    }
                });
                this.dRS.setDuration(4000L);
                this.dRS.start();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aPd() {
        if (this.dRR != null) {
            float w = w(this.dRV, this.dRU);
            U(w <= 1.0f ? w : 1.0f);
        }
    }

    private void U(float f) {
        if (this.dRR != null && this.dRW <= f) {
            this.dRW = f;
            if (DEBUG) {
                Log.i("SwanAppLoadingView", "setProgressText: " + this.dRW);
            }
            int i = (int) (1000.0f * f);
            int i2 = i / 10;
            String str = ((i % 10 >= 5 ? 1 : 0) + i2) + "%";
            String trim = this.dSa.trim();
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(trim)) {
                sb.append(trim).append(" ");
            }
            sb.append(str);
            if (this.dRY != null && !this.dRY.dSd) {
                if (this.dRY.aPi()) {
                    if (DEBUG) {
                        Log.i("SwanAppLoadingView", "setProgressText: checking update");
                    }
                    this.dRR.setText(this.dRR.getContext().getString(a.h.swanapp_swan_loading_runtime_check_updating));
                    this.dRR.setVisibility(0);
                } else if (this.dRY.aPj() && this.dRW <= 0.0f) {
                    if (DEBUG) {
                        Log.i("SwanAppLoadingView", "setProgressText: checking update");
                    }
                    this.dRR.setText(this.dRR.getContext().getString(a.h.swanapp_swan_loading_runtime_check_updating));
                    this.dRR.setVisibility(0);
                } else if (this.dRY.aPi()) {
                    if (DEBUG) {
                        Log.i("SwanAppLoadingView", "setProgressText: Framework loading");
                    }
                    this.dRR.setText(this.dRR.getContext().getString(a.h.swanapp_swan_loading_runtime_loading));
                    this.dRR.setVisibility(0);
                } else if (this.dRY.dSi && !this.dRY.aPk()) {
                    if (DEBUG) {
                        Log.i("SwanAppLoadingView", "setProgressText: Framework loading");
                    }
                    this.dRR.setText(this.dRR.getContext().getString(a.h.swanapp_swan_loading_runtime_loading));
                    this.dRR.setVisibility(0);
                } else if (this.dRW >= 1.0f && !this.dRY.aPk()) {
                    if (DEBUG) {
                        Log.i("SwanAppLoadingView", "setProgressText: Framework loading");
                    }
                    this.dRR.setText(this.dRR.getContext().getString(a.h.swanapp_swan_loading_runtime_loading));
                    this.dRR.setVisibility(0);
                } else {
                    this.dRR.setText(sb);
                }
            } else {
                this.dRR.setText(sb);
            }
            if (f > 0.0f) {
                this.dRR.setVisibility(0);
            }
        }
    }

    private float w(float f, float f2) {
        return ((1.0f - f) * f2) + f;
    }

    public void aPe() {
        if (this.dRR != null) {
            if (this.dRS != null) {
                this.dRS.removeAllUpdateListeners();
                this.dRS.cancel();
                this.dRS = null;
            }
            U(1.0f);
        }
    }

    public void uq(String str) {
        if (DEBUG) {
            Log.i("SwanAppLoadingView", "updateIcon: icon=" + str);
        }
        final String appId = com.baidu.swan.apps.runtime.d.aIG().getAppId();
        if (this.dRT) {
            this.cQW.setImageBitmap(ak.a(str, "SwanAppLoadingView", true, new s.a() { // from class: com.baidu.swan.apps.view.c.7
                @Override // com.baidu.swan.apps.ao.s.a
                public void f(String str2, Bitmap bitmap) {
                    SwanAppActivity aIE;
                    c afT;
                    if (bitmap != null && (aIE = com.baidu.swan.apps.runtime.d.aIG().aIE()) != null && !aIE.isDestroyed() && (afT = aIE.afT()) != null && TextUtils.equals(appId, com.baidu.swan.apps.runtime.d.aIG().getAppId())) {
                        afT.r(bitmap);
                    }
                }
            }));
        }
    }

    public void jV(String str) {
        if (this.dRT && !TextUtils.isEmpty(str)) {
            this.dRF.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a implements Runnable {
        final com.baidu.swan.apps.runtime.b cCd;
        final boolean dSd;
        final String dSe;
        private boolean dSi;
        boolean dSf = false;
        boolean dSg = false;
        private int dEA = -1;
        private int dSh = -1;

        a(String str, boolean z) {
            this.dSe = str;
            this.dSd = z;
            this.cCd = new com.baidu.swan.apps.runtime.b().a(new com.baidu.swan.apps.ao.e.b<i.a>() { // from class: com.baidu.swan.apps.view.c.a.7
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ao.e.b
                /* renamed from: b */
                public void L(i.a aVar) {
                    if (c.DEBUG) {
                        Log.i("SwanAppLoadingView", "onCallback: EVENT_PMS_CHECK_START");
                    }
                    a.this.dEA = aVar.getInt("KEY_PKG_STATE", -1);
                    a.this.aPg();
                }
            }, "event_pms_check_start").a(new com.baidu.swan.apps.ao.e.b<i.a>() { // from class: com.baidu.swan.apps.view.c.a.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ao.e.b
                /* renamed from: b */
                public void L(i.a aVar) {
                    if (c.DEBUG) {
                        Log.i("SwanAppLoadingView", "onCallback: EVENT_PMS_CHECK_FINISH");
                    }
                    a.this.dEA = aVar.getInt("KEY_PKG_STATE", -1);
                    a.this.aPg();
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
                    a.this.dSi = true;
                    a.this.aPg();
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
                    a.this.dSh = aVar.getInt("KEY_PRELOAD_STATE");
                    a.this.aPg();
                }
            }, "event_preload_finish");
            com.baidu.swan.apps.runtime.d.aIG().v(this.cCd);
        }

        void aPg() {
            boolean aPi = aPi();
            boolean aPh = aPh();
            boolean aPk = aPk();
            if (c.DEBUG) {
                Log.i("SwanAppLoadingView", "checkAndUpdateProgress: runtimeLoading " + aPi);
                Log.i("SwanAppLoadingView", "checkAndUpdateProgress: checkingUpdate " + aPh);
                Log.i("SwanAppLoadingView", "checkAndUpdateProgress: preloadFinish " + aPk);
            }
            if (aPi || aPh || !aPk) {
                c.this.aPd();
            }
        }

        boolean aPh() {
            boolean aPj = aPj();
            boolean aPk = aPk();
            boolean z = aPj && aPk;
            if (c.DEBUG) {
                Log.i("SwanAppLoadingView", "isCheckingUpdate: overMaxAge " + aPj);
                Log.i("SwanAppLoadingView", "isCheckingUpdate: preloadFinish " + aPk);
                Log.i("SwanAppLoadingView", "isCheckingUpdate: " + z);
            }
            return z;
        }

        boolean aPi() {
            boolean z = this.dEA == 4;
            boolean aPk = aPk();
            if (c.DEBUG) {
                Log.i("SwanAppLoadingView", "isRuntimeLoading: isLocalPackage " + z);
                Log.i("SwanAppLoadingView", "isRuntimeLoading: preloadFinish " + aPk);
            }
            return z && !aPk;
        }

        boolean aPj() {
            boolean z = true;
            if (this.dEA != 3 && this.dEA != 1) {
                z = false;
            }
            if (c.DEBUG) {
                Log.i("SwanAppLoadingView", "isOverMaxAge: isOverMaxAge " + z);
            }
            return z;
        }

        boolean aPk() {
            boolean asn = com.baidu.swan.apps.core.turbo.d.ase().asn();
            if (c.DEBUG) {
                Log.i("SwanAppLoadingView", "isPreloadFinish: runtimeReady " + asn);
            }
            return asn;
        }

        void onDestroy() {
            if (c.DEBUG) {
                Log.i("SwanAppLoadingView", "onDestroy: ");
            }
            com.baidu.swan.apps.runtime.d.aIG().w(this.cCd);
        }

        a aPl() {
            this.dSf = true;
            return this;
        }

        @Override // java.lang.Runnable
        public void run() {
            hI(true);
        }

        public void hI(boolean z) {
            if (c.DEBUG) {
                Log.i("SwanAppLoadingView", "ViewStarter exec : post = " + z + " trace = " + (z ? "post" : Log.getStackTraceString(new Exception())));
            }
            this.dSg = true;
            c.this.s(this.dSd, this.dSf);
        }
    }
}
