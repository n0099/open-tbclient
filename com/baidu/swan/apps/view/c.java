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
/* loaded from: classes8.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static Boolean dPT = null;
    private static View dPw;
    private static View dPx;
    public SwanAppRoundedImageView cOI;
    public BdBaseImageView cOJ;
    public TextView cOK;
    public ImageView dPA;
    public ImageView dPB;
    private ImageView dPC;
    private ImageView dPD;
    public RelativeLayout dPE;
    private View dPF;
    private com.baidu.swan.apps.e.a dPG;
    private SwanAppActivity dPH;
    private View dPI;
    private SwanLoadingTipsView dPJ;
    private com.baidu.swan.games.loading.a dPK;
    private TextView dPL;
    private ValueAnimator dPM;
    private boolean dPN = false;
    private float dPO = 0.0f;
    private float dPP = 0.0f;
    private float dPQ = 0.0f;
    private long dPR = 0;
    private a dPS = null;
    private String dPU = "";
    private boolean dPV;
    public View dPy;
    public TextView dPz;

    public c(SwanAppActivity swanAppActivity) {
        this.dPV = com.baidu.swan.apps.runtime.d.aIn().afr() != 1;
        this.dPH = swanAppActivity;
    }

    public static void dT(final Context context) {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.view.c.1
            @Override // java.lang.Runnable
            public void run() {
                c.dU(context);
            }
        }, 5000L);
    }

    public static void dU(Context context) {
        if (dPw == null) {
            dPw = r(context, false);
        }
        if (dPx == null) {
            dPx = r(context, true);
        }
        if (DEBUG) {
            Log.i("SwanAppLoadingView", "obtainPreloadContainer:  App=" + dPw + " Game=" + dPx);
        }
    }

    public static void aOF() {
        dPw = null;
        dPx = null;
    }

    private View q(Context context, boolean z) {
        View view = z ? dPx : dPw;
        if (z) {
            dPx = null;
        } else {
            dPw = null;
        }
        boolean z2 = (view == null || view.isAttachedToWindow()) ? false : true;
        if (z2) {
            dT(context);
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
        this.dPV = com.baidu.swan.apps.runtime.d.aIn().afr() != 1;
        this.dPR = 0L;
        String ayV = com.baidu.swan.apps.runtime.d.aIn().aIj().aIv().ayV();
        boolean z4 = this.dPS == null || (this.dPS.dPX ^ z) || TextUtils.isEmpty(ayV) || !TextUtils.equals(ayV, this.dPS.dPY);
        if (DEBUG) {
            Log.i("SwanAppLoadingView", "showSwanAppStartView: newLaunchId = " + ayV + " newIsGameLoading = " + z + " reCreateStarter = " + z4 + " mViewStarter = " + this.dPS);
        }
        Handler mainHandler = com.baidu.swan.apps.runtime.d.getMainHandler();
        if (this.dPS != null) {
            if (DEBUG) {
                Log.i("SwanAppLoadingView", "showSwanAppStartView: oldLaunchId = " + this.dPS.dPY + " oldIsGameLoading = " + this.dPS.dPX);
            }
            mainHandler.removeCallbacks(this.dPS);
        }
        if (z4) {
            this.dPS = new a(ayV, z);
        }
        if (this.dPS != null) {
            if (aVar == null || !aVar.getBoolean(" event_params_pkg_update", false)) {
                z3 = false;
            }
            if (this.dPS.dQa) {
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
                this.dPS.aOS();
            }
            if (z2) {
                this.dPS.hG(false);
                return;
            }
            if (DEBUG) {
                Log.i("SwanAppLoadingView", "showSwanAppStartView: post starter trace = " + Log.getStackTraceString(new Throwable()));
            }
            mainHandler.post(this.dPS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(boolean z, boolean z2) {
        synchronized (c.class) {
            if (this.dPG == null) {
                this.dPG = new com.baidu.swan.apps.e.a();
            }
            this.dPy = q(this.dPH, z);
            if (!z) {
                this.dPy.setPadding(0, com.baidu.swan.apps.res.widget.a.dyP ? ah.getStatusBarHeight() : 0, 0, 0);
            } else {
                aOG();
            }
            this.dPL = (TextView) this.dPy.findViewById(a.f.aiapps_loading_progress);
            b.a aIv = com.baidu.swan.apps.runtime.d.aIn().aIj().aIv();
            PMSAppInfo ayS = aIv.ayS();
            t(z, z2);
            this.dPH.afu().aM(this.dPy);
            this.dPN = true;
            this.dPz = (TextView) this.dPy.findViewById(a.f.aiapps_title);
            this.cOI = (SwanAppRoundedImageView) this.dPy.findViewById(a.f.aiapps_icon);
            this.cOJ = (BdBaseImageView) this.dPy.findViewById(a.f.aiapps_label_bg);
            this.cOK = (TextView) this.dPy.findViewById(a.f.aiapps_label_tv);
            this.dPE = (RelativeLayout) this.dPy.findViewById(a.f.aiapps_icon_rl);
            jD(aIv.asE());
            tX(aIv.getIconUrl());
            kr(aIv.getType());
            this.dPA = (ImageView) this.dPy.findViewById(a.f.light_print);
            this.dPB = (ImageView) this.dPy.findViewById(a.f.dark_print);
            this.dPC = (ImageView) this.dPy.findViewById(a.f.titlebar_right_menu_img);
            this.dPD = (ImageView) this.dPy.findViewById(a.f.titlebar_right_menu_exit);
            this.dPF = this.dPy.findViewById(a.f.titlebar_right_menu);
            if (z) {
                this.dPC.setClickable(true);
                this.dPC.setImageResource(a.e.aiapps_action_bar_single_menu_white_selector);
                this.dPD.setImageResource(a.e.aiapps_action_bar_exit_white_selector);
                this.dPF.setBackgroundResource(a.e.aiapps_action_bar_right_menu_bg_solid);
                this.dPI = this.dPy.findViewById(a.f.titlebar_right_menu_line);
                this.dPI.setBackgroundResource(a.c.aiapps_action_bar_menu_line_white);
            } else {
                this.dPC.setImageResource(a.e.aiapps_action_bar_menu_black_selector);
                this.dPD.setImageResource(a.e.aiapps_action_bar_exit_black_selector);
                this.dPF.setBackgroundResource(a.e.aiapps_action_bar_right_menu_bg);
            }
            int i = ayS == null ? PMSConstants.PayProtected.NO_PAY_PROTECTED.type : ayS.payProtected;
            if (!z && ak.aNW() && i == PMSConstants.PayProtected.PAY_PROTECTED.type) {
                ((RelativeLayout) this.dPy.findViewById(a.f.guarantee_plan_rl)).setVisibility(0);
            }
            this.dPB.setAlpha(0.0f);
            this.dPG.g(this.dPH);
            aOI();
        }
    }

    private void aOG() {
        this.dPJ = (SwanLoadingTipsView) this.dPy.findViewById(a.f.aigames_loading_game_tips);
        this.dPJ.setTipsAnimationFinishCallback(new kotlin.jvm.a.a<h>() { // from class: com.baidu.swan.apps.view.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.a.a
            /* renamed from: aOM */
            public h invoke() {
                c.this.aOH();
                return null;
            }
        });
        this.dPK = new com.baidu.swan.games.loading.a();
        this.dPy.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.swan.apps.view.c.3
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                c.this.aOH();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOH() {
        if (this.dPJ != null && this.dPK != null) {
            this.dPJ.wE(this.dPK.aXk());
        }
    }

    private void aOI() {
        this.dPD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.view.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.dPH != null && !c.this.dPH.isFinishing()) {
                    HybridUbcFlow aDH = com.baidu.swan.apps.performance.i.aDH();
                    if (aDH != null) {
                        aDH.cm("exitType", String.valueOf(3));
                        aDH.q("value", "cancel");
                        aDH.aDn();
                    }
                    c.this.dPH.moveTaskToBack(true);
                    ap.aOh().kk(2);
                    c.this.aOJ();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOJ() {
        Bundle ayH;
        b.a afB = this.dPH.afB();
        if (afB != null && (ayH = afB.ayH()) != null) {
            long j = ayH.getLong("page_display_flag_for_statistic");
            ayH.remove("page_display_flag_for_statistic");
            if (j > 0) {
                String valueOf = String.valueOf(System.currentTimeMillis() - afB.getLong("launch_time", 0L));
                f fVar = new f();
                fVar.mType = Config.LAUNCH;
                fVar.mValue = "realcancel";
                fVar.dJz = valueOf;
                fVar.t(TiebaInitialize.LogFields.REASON, "close");
                if (afB.getAppFrameType() == 1) {
                    fVar.t("errorList", com.baidu.swan.games.v.b.aXZ().aYa());
                }
                this.dPH.a(fVar);
                e.b(afB);
            }
        }
    }

    private void kr(int i) {
        ah.a(this.cOJ, this.cOK, String.valueOf(i));
    }

    public void ks(final int i) {
        Handler mainHandler = com.baidu.swan.apps.runtime.d.getMainHandler();
        if (this.dPS != null) {
            mainHandler.removeCallbacks(this.dPS);
            this.dPS.onDestroy();
            this.dPS = null;
        }
        mainHandler.post(new Runnable() { // from class: com.baidu.swan.apps.view.c.5
            @Override // java.lang.Runnable
            public void run() {
                synchronized (c.class) {
                    com.baidu.swan.apps.performance.i.aDG().f(new UbcFlowEvent("first_anim_end"));
                    com.baidu.swan.apps.aj.a.aKP().sf("first_anim_end");
                    if (c.this.dPG != null) {
                        c.this.dPG.a(c.this.dPH, i);
                    }
                    c.this.dPN = false;
                }
            }
        });
    }

    public void ajm() {
        if (DEBUG) {
            Log.i("SwanAppLoadingView", "stopAnimations: " + Log.getStackTraceString(new Exception()));
        }
        Handler mainHandler = com.baidu.swan.apps.runtime.d.getMainHandler();
        if (this.dPS != null) {
            mainHandler.removeCallbacks(this.dPS);
            this.dPS.onDestroy();
            this.dPS = null;
        }
        synchronized (c.class) {
            if (this.dPG != null) {
                this.dPG.ajm();
            }
            if (this.dPJ != null) {
                this.dPJ.doDestroy();
                this.dPJ = null;
            }
            if (this.dPL != null) {
                this.dPL.setVisibility(8);
                this.dPL = null;
                this.dPU = "";
                this.dPP = 0.0f;
                this.dPO = 0.0f;
                this.dPQ = 0.0f;
            }
            if (this.dPM != null) {
                this.dPM.removeAllUpdateListeners();
                this.dPM.cancel();
                this.dPM = null;
            }
            this.dPN = false;
            if (this.dPS != null) {
                this.dPS.onDestroy();
                this.dPS = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(Bitmap bitmap) {
        if (bitmap != null && this.cOI != null) {
            this.cOI.setImageBitmap(bitmap);
        }
    }

    public void S(float f) {
        if (DEBUG) {
            Log.i("SwanAppLoadingView", "onDownloadProgressUpdate: " + f + " view: " + this.dPL);
        }
        if (this.dPL != null) {
            float f2 = f >= 0.0f ? f : 0.0f;
            this.dPO = f2 <= 1.0f ? f2 : 1.0f;
            aOK();
            if (this.dPV) {
                if (this.dPR == 0) {
                    this.dPR = System.currentTimeMillis();
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.dPR > 2000) {
                    com.baidu.swan.apps.core.f.bt("pms_downloadPkg", "包下载进度更新间隔大于2秒");
                    this.dPV = false;
                }
                this.dPR = currentTimeMillis;
            }
        }
    }

    private void s(boolean z, boolean z2) {
        if (z) {
            this.dPU = "";
        } else {
            this.dPU = this.dPL.getContext().getString(z2 ? a.h.swan_loading_view_tag_updating : a.h.swan_loading_view_tag_loading);
        }
    }

    public void t(boolean z, boolean z2) {
        if (this.dPL != null) {
            if (this.dPM != null) {
                this.dPM.cancel();
                this.dPM.removeAllUpdateListeners();
            }
            s(z, z2);
            this.dPP = 0.0f;
            this.dPO = 0.0f;
            this.dPQ = 0.0f;
            if (z) {
                aOK();
                this.dPM = ValueAnimator.ofFloat(0.0f, 1.0f);
                this.dPM.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.view.c.6
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        if (floatValue > 0.9f || floatValue - c.this.dPP > 0.05d) {
                            c.this.dPP = floatValue;
                            c.this.aOK();
                        }
                    }
                });
                this.dPM.setDuration(4000L);
                this.dPM.start();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOK() {
        if (this.dPL != null) {
            float w = w(this.dPP, this.dPO);
            T(w <= 1.0f ? w : 1.0f);
        }
    }

    private void T(float f) {
        if (this.dPL != null && this.dPQ <= f) {
            this.dPQ = f;
            if (DEBUG) {
                Log.i("SwanAppLoadingView", "setProgressText: " + this.dPQ);
            }
            int i = (int) (1000.0f * f);
            int i2 = i / 10;
            String str = ((i % 10 >= 5 ? 1 : 0) + i2) + "%";
            String trim = this.dPU.trim();
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(trim)) {
                sb.append(trim).append(" ");
            }
            sb.append(str);
            if (this.dPS != null && !this.dPS.dPX) {
                if (this.dPS.aOP()) {
                    if (DEBUG) {
                        Log.i("SwanAppLoadingView", "setProgressText: checking update");
                    }
                    this.dPL.setText(this.dPL.getContext().getString(a.h.swanapp_swan_loading_runtime_check_updating));
                    this.dPL.setVisibility(0);
                } else if (this.dPS.aOQ() && this.dPQ <= 0.0f) {
                    if (DEBUG) {
                        Log.i("SwanAppLoadingView", "setProgressText: checking update");
                    }
                    this.dPL.setText(this.dPL.getContext().getString(a.h.swanapp_swan_loading_runtime_check_updating));
                    this.dPL.setVisibility(0);
                } else if (this.dPS.aOP()) {
                    if (DEBUG) {
                        Log.i("SwanAppLoadingView", "setProgressText: Framework loading");
                    }
                    this.dPL.setText(this.dPL.getContext().getString(a.h.swanapp_swan_loading_runtime_loading));
                    this.dPL.setVisibility(0);
                } else if (this.dPS.dQc && !this.dPS.aOR()) {
                    if (DEBUG) {
                        Log.i("SwanAppLoadingView", "setProgressText: Framework loading");
                    }
                    this.dPL.setText(this.dPL.getContext().getString(a.h.swanapp_swan_loading_runtime_loading));
                    this.dPL.setVisibility(0);
                } else if (this.dPQ >= 1.0f && !this.dPS.aOR()) {
                    if (DEBUG) {
                        Log.i("SwanAppLoadingView", "setProgressText: Framework loading");
                    }
                    this.dPL.setText(this.dPL.getContext().getString(a.h.swanapp_swan_loading_runtime_loading));
                    this.dPL.setVisibility(0);
                } else {
                    this.dPL.setText(sb);
                }
            } else {
                this.dPL.setText(sb);
            }
            if (f > 0.0f) {
                this.dPL.setVisibility(0);
            }
        }
    }

    private float w(float f, float f2) {
        return ((1.0f - f) * f2) + f;
    }

    public void aOL() {
        if (this.dPL != null) {
            if (this.dPM != null) {
                this.dPM.removeAllUpdateListeners();
                this.dPM.cancel();
                this.dPM = null;
            }
            T(1.0f);
        }
    }

    public void tX(String str) {
        if (DEBUG) {
            Log.i("SwanAppLoadingView", "updateIcon: icon=" + str);
        }
        final String appId = com.baidu.swan.apps.runtime.d.aIn().getAppId();
        if (this.dPN) {
            this.cOI.setImageBitmap(ak.a(str, "SwanAppLoadingView", true, new s.a() { // from class: com.baidu.swan.apps.view.c.7
                @Override // com.baidu.swan.apps.ao.s.a
                public void g(String str2, Bitmap bitmap) {
                    SwanAppActivity aIl;
                    c afv;
                    if (bitmap != null && (aIl = com.baidu.swan.apps.runtime.d.aIn().aIl()) != null && !aIl.isDestroyed() && (afv = aIl.afv()) != null && TextUtils.equals(appId, com.baidu.swan.apps.runtime.d.aIn().getAppId())) {
                        afv.s(bitmap);
                    }
                }
            }));
        }
    }

    public void jD(String str) {
        if (this.dPN && !TextUtils.isEmpty(str)) {
            this.dPz.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a implements Runnable {
        final com.baidu.swan.apps.runtime.b czH;
        final boolean dPX;
        final String dPY;
        private boolean dQc;
        boolean dPZ = false;
        boolean dQa = false;
        private int dCw = -1;
        private int dQb = -1;

        a(String str, boolean z) {
            this.dPY = str;
            this.dPX = z;
            this.czH = new com.baidu.swan.apps.runtime.b().a(new com.baidu.swan.apps.ao.e.b<i.a>() { // from class: com.baidu.swan.apps.view.c.a.7
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ao.e.b
                /* renamed from: b */
                public void L(i.a aVar) {
                    if (c.DEBUG) {
                        Log.i("SwanAppLoadingView", "onCallback: EVENT_PMS_CHECK_START");
                    }
                    a.this.dCw = aVar.getInt("KEY_PKG_STATE", -1);
                    a.this.aON();
                }
            }, "event_pms_check_start").a(new com.baidu.swan.apps.ao.e.b<i.a>() { // from class: com.baidu.swan.apps.view.c.a.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ao.e.b
                /* renamed from: b */
                public void L(i.a aVar) {
                    if (c.DEBUG) {
                        Log.i("SwanAppLoadingView", "onCallback: EVENT_PMS_CHECK_FINISH");
                    }
                    a.this.dCw = aVar.getInt("KEY_PKG_STATE", -1);
                    a.this.aON();
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
                    a.this.dQc = true;
                    a.this.aON();
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
                    a.this.dQb = aVar.getInt("KEY_PRELOAD_STATE");
                    a.this.aON();
                }
            }, "event_preload_finish");
            com.baidu.swan.apps.runtime.d.aIn().v(this.czH);
        }

        void aON() {
            boolean aOP = aOP();
            boolean aOO = aOO();
            boolean aOR = aOR();
            if (c.DEBUG) {
                Log.i("SwanAppLoadingView", "checkAndUpdateProgress: runtimeLoading " + aOP);
                Log.i("SwanAppLoadingView", "checkAndUpdateProgress: checkingUpdate " + aOO);
                Log.i("SwanAppLoadingView", "checkAndUpdateProgress: preloadFinish " + aOR);
            }
            if (aOP || aOO || !aOR) {
                c.this.aOK();
            }
        }

        boolean aOO() {
            boolean aOQ = aOQ();
            boolean aOR = aOR();
            boolean z = aOQ && aOR;
            if (c.DEBUG) {
                Log.i("SwanAppLoadingView", "isCheckingUpdate: overMaxAge " + aOQ);
                Log.i("SwanAppLoadingView", "isCheckingUpdate: preloadFinish " + aOR);
                Log.i("SwanAppLoadingView", "isCheckingUpdate: " + z);
            }
            return z;
        }

        boolean aOP() {
            boolean z = this.dCw == 4;
            boolean aOR = aOR();
            if (c.DEBUG) {
                Log.i("SwanAppLoadingView", "isRuntimeLoading: isLocalPackage " + z);
                Log.i("SwanAppLoadingView", "isRuntimeLoading: preloadFinish " + aOR);
            }
            return z && !aOR;
        }

        boolean aOQ() {
            boolean z = true;
            if (this.dCw != 3 && this.dCw != 1) {
                z = false;
            }
            if (c.DEBUG) {
                Log.i("SwanAppLoadingView", "isOverMaxAge: isOverMaxAge " + z);
            }
            return z;
        }

        boolean aOR() {
            boolean arO = com.baidu.swan.apps.core.turbo.d.arG().arO();
            if (c.DEBUG) {
                Log.i("SwanAppLoadingView", "isPreloadFinish: runtimeReady " + arO);
            }
            return arO;
        }

        void onDestroy() {
            if (c.DEBUG) {
                Log.i("SwanAppLoadingView", "onDestroy: ");
            }
            com.baidu.swan.apps.runtime.d.aIn().w(this.czH);
        }

        a aOS() {
            this.dPZ = true;
            return this;
        }

        @Override // java.lang.Runnable
        public void run() {
            hG(true);
        }

        public void hG(boolean z) {
            if (c.DEBUG) {
                Log.i("SwanAppLoadingView", "ViewStarter exec : post = " + z + " trace = " + (z ? "post" : Log.getStackTraceString(new Exception())));
            }
            this.dQa = true;
            c.this.r(this.dPX, this.dPZ);
        }
    }
}
