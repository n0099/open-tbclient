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
/* loaded from: classes3.dex */
public class c {
    private static View dfB;
    private static View dfC;
    public SwanAppRoundedImageView ciI;
    public BdBaseImageView ciJ;
    public TextView ciK;
    public View dfD;
    public TextView dfE;
    public ImageView dfF;
    public ImageView dfG;
    private ImageView dfH;
    public RelativeLayout dfI;
    private com.baidu.swan.apps.e.a dfJ;
    private SwanAppActivity dfK;
    private View dfL;
    private SwanLoadingTipsView dfM;
    private com.baidu.swan.games.loading.a dfN;
    private TextView dfO;
    private ValueAnimator dfP;
    private boolean dfQ = false;
    private float dfR = 0.0f;
    private float dfS = 0.0f;
    private float dfT = 0.0f;
    private long dfU = 0;
    private a dfV = null;
    private String dfX = "";
    private boolean dfY;
    private View mRightMenu;
    private ImageView mRightMenuImageView;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static Boolean dfW = null;

    public c(SwanAppActivity swanAppActivity) {
        this.dfY = com.baidu.swan.apps.runtime.d.aAn().Yy() != 1;
        this.dfK = swanAppActivity;
    }

    public static void cP(final Context context) {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.view.c.1
            @Override // java.lang.Runnable
            public void run() {
                c.cQ(context);
            }
        }, 5000L);
    }

    public static void cQ(Context context) {
        if (dfB == null) {
            dfB = o(context, false);
        }
        if (dfC == null) {
            dfC = o(context, true);
        }
        if (DEBUG) {
            Log.i("SwanAppLoadingView", "obtainPreloadContainer:  App=" + dfB + " Game=" + dfC);
        }
    }

    public static void aGC() {
        dfB = null;
        dfC = null;
    }

    private View n(Context context, boolean z) {
        View view = z ? dfC : dfB;
        if (z) {
            dfC = null;
        } else {
            dfB = null;
        }
        boolean z2 = (view == null || view.isAttachedToWindow()) ? false : true;
        if (z2) {
            cP(context);
        }
        if (!z2) {
            view = o(context, z);
        }
        if (DEBUG) {
            Log.i("SwanAppLoadingView", "obtainPreloadContainer:  isLegalContainer= " + z2 + " game=" + z + " container=" + view);
        }
        return view;
    }

    private static View o(Context context, boolean z) {
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
        this.dfY = com.baidu.swan.apps.runtime.d.aAn().Yy() != 1;
        this.dfU = 0L;
        String arQ = com.baidu.swan.apps.runtime.d.aAn().aAj().aAv().arQ();
        boolean z4 = this.dfV == null || (this.dfV.dga ^ z) || TextUtils.isEmpty(arQ) || !TextUtils.equals(arQ, this.dfV.dgb);
        if (DEBUG) {
            Log.i("SwanAppLoadingView", "showSwanAppStartView: newLaunchId = " + arQ + " newIsGameLoading = " + z + " reCreateStarter = " + z4 + " mViewStarter = " + this.dfV);
        }
        Handler mainHandler = com.baidu.swan.apps.runtime.d.getMainHandler();
        if (this.dfV != null) {
            if (DEBUG) {
                Log.i("SwanAppLoadingView", "showSwanAppStartView: oldLaunchId = " + this.dfV.dgb + " oldIsGameLoading = " + this.dfV.dga);
            }
            mainHandler.removeCallbacks(this.dfV);
        }
        if (z4) {
            this.dfV = new a(arQ, z);
        }
        if (this.dfV != null) {
            if (aVar == null || !aVar.getBoolean(" event_params_pkg_update", false)) {
                z3 = false;
            }
            if (this.dfV.dgd) {
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
                this.dfV.aGP();
            }
            if (z2) {
                this.dfV.gi(false);
                return;
            }
            if (DEBUG) {
                Log.i("SwanAppLoadingView", "showSwanAppStartView: post starter trace = " + Log.getStackTraceString(new Throwable()));
            }
            mainHandler.post(this.dfV);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(boolean z, boolean z2) {
        synchronized (c.class) {
            if (this.dfJ == null) {
                this.dfJ = new com.baidu.swan.apps.e.a();
            }
            this.dfD = n(this.dfK, z);
            if (!z) {
                this.dfD.setPadding(0, com.baidu.swan.apps.res.widget.a.SUPPORT_IMMERSION ? ah.getStatusBarHeight() : 0, 0, 0);
            } else {
                aGD();
            }
            this.dfO = (TextView) this.dfD.findViewById(a.f.aiapps_loading_progress);
            b.a aAv = com.baidu.swan.apps.runtime.d.aAn().aAj().aAv();
            PMSAppInfo arN = aAv.arN();
            t(z, z2);
            this.dfK.YB().aw(this.dfD);
            this.dfQ = true;
            this.dfE = (TextView) this.dfD.findViewById(a.f.aiapps_title);
            this.ciI = (SwanAppRoundedImageView) this.dfD.findViewById(a.f.aiapps_icon);
            this.ciJ = (BdBaseImageView) this.dfD.findViewById(a.f.aiapps_label_bg);
            this.ciK = (TextView) this.dfD.findViewById(a.f.aiapps_label_tv);
            this.dfI = (RelativeLayout) this.dfD.findViewById(a.f.aiapps_icon_rl);
            ja(aAv.aly());
            to(aAv.getIconUrl());
            kE(aAv.getType());
            this.dfF = (ImageView) this.dfD.findViewById(a.f.light_print);
            this.dfG = (ImageView) this.dfD.findViewById(a.f.dark_print);
            this.mRightMenuImageView = (ImageView) this.dfD.findViewById(a.f.titlebar_right_menu_img);
            this.dfH = (ImageView) this.dfD.findViewById(a.f.titlebar_right_menu_exit);
            this.mRightMenu = this.dfD.findViewById(a.f.titlebar_right_menu);
            if (z) {
                this.mRightMenuImageView.setClickable(true);
                this.mRightMenuImageView.setImageResource(a.e.aiapps_action_bar_single_menu_white_selector);
                this.dfH.setImageResource(a.e.aiapps_action_bar_exit_white_selector);
                this.mRightMenu.setBackgroundResource(a.e.aiapps_action_bar_right_menu_bg_solid);
                this.dfL = this.dfD.findViewById(a.f.titlebar_right_menu_line);
                this.dfL.setBackgroundResource(a.c.aiapps_action_bar_menu_line_white);
            } else {
                this.mRightMenuImageView.setImageResource(a.e.aiapps_action_bar_menu_black_selector);
                this.dfH.setImageResource(a.e.aiapps_action_bar_exit_black_selector);
                this.mRightMenu.setBackgroundResource(a.e.aiapps_action_bar_right_menu_bg);
            }
            int i = arN == null ? PMSConstants.PayProtected.NO_PAY_PROTECTED.type : arN.payProtected;
            if (!z && ak.aFX() && i == PMSConstants.PayProtected.PAY_PROTECTED.type) {
                ((RelativeLayout) this.dfD.findViewById(a.f.guarantee_plan_rl)).setVisibility(0);
            }
            this.dfG.setAlpha(0.0f);
            this.dfJ.g(this.dfK);
            aGF();
        }
    }

    private void aGD() {
        this.dfM = (SwanLoadingTipsView) this.dfD.findViewById(a.f.aigames_loading_game_tips);
        this.dfM.setTipsAnimationFinishCallback(new kotlin.jvm.a.a<l>() { // from class: com.baidu.swan.apps.view.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.a.a
            /* renamed from: aGJ */
            public l invoke() {
                c.this.aGE();
                return null;
            }
        });
        this.dfN = new com.baidu.swan.games.loading.a();
        this.dfD.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.swan.apps.view.c.3
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                c.this.aGE();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGE() {
        if (this.dfM != null && this.dfN != null) {
            this.dfM.vV(this.dfN.aPj());
        }
    }

    private void aGF() {
        this.dfH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.view.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.dfK != null && !c.this.dfK.isFinishing()) {
                    HybridUbcFlow awC = com.baidu.swan.apps.performance.i.awC();
                    if (awC != null) {
                        awC.bW("exitType", String.valueOf(3));
                        awC.r("value", "cancel");
                        awC.awh();
                    }
                    c.this.dfK.moveTaskToBack(true);
                    ap.aGh().kz(2);
                    c.this.aGG();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGG() {
        Bundle arC;
        b.a YI = this.dfK.YI();
        if (YI != null && (arC = YI.arC()) != null) {
            long j = arC.getLong("page_display_flag_for_statistic");
            arC.remove("page_display_flag_for_statistic");
            if (j > 0) {
                String valueOf = String.valueOf(System.currentTimeMillis() - YI.getLong("launch_time", 0L));
                f fVar = new f();
                fVar.mType = Config.LAUNCH;
                fVar.mValue = "realcancel";
                fVar.cZL = valueOf;
                fVar.u(TiebaInitialize.LogFields.REASON, "close");
                if (YI.getAppFrameType() == 1) {
                    fVar.u("errorList", com.baidu.swan.games.v.b.aPY().aPZ());
                }
                this.dfK.a(fVar);
                e.b(YI);
            }
        }
    }

    private void kE(int i) {
        ah.a(this.ciJ, this.ciK, String.valueOf(i));
    }

    public void kF(final int i) {
        Handler mainHandler = com.baidu.swan.apps.runtime.d.getMainHandler();
        if (this.dfV != null) {
            mainHandler.removeCallbacks(this.dfV);
            this.dfV.onDestroy();
            this.dfV = null;
        }
        mainHandler.post(new Runnable() { // from class: com.baidu.swan.apps.view.c.5
            @Override // java.lang.Runnable
            public void run() {
                synchronized (c.class) {
                    com.baidu.swan.apps.performance.i.awB().f(new UbcFlowEvent("first_anim_end"));
                    com.baidu.swan.apps.ak.a.aCP().ry("first_anim_end");
                    if (c.this.dfJ != null) {
                        c.this.dfJ.a(c.this.dfK, i);
                    }
                    c.this.dfQ = false;
                }
            }
        });
    }

    public void acp() {
        if (DEBUG) {
            Log.i("SwanAppLoadingView", "stopAnimations: " + Log.getStackTraceString(new Exception()));
        }
        Handler mainHandler = com.baidu.swan.apps.runtime.d.getMainHandler();
        if (this.dfV != null) {
            mainHandler.removeCallbacks(this.dfV);
            this.dfV.onDestroy();
            this.dfV = null;
        }
        synchronized (c.class) {
            if (this.dfJ != null) {
                this.dfJ.acp();
            }
            if (this.dfM != null) {
                this.dfM.doDestroy();
                this.dfM = null;
            }
            if (this.dfO != null) {
                this.dfO.setVisibility(8);
                this.dfO = null;
                this.dfX = "";
                this.dfS = 0.0f;
                this.dfR = 0.0f;
                this.dfT = 0.0f;
            }
            if (this.dfP != null) {
                this.dfP.removeAllUpdateListeners();
                this.dfP.cancel();
                this.dfP = null;
            }
            this.dfQ = false;
            if (this.dfV != null) {
                this.dfV.onDestroy();
                this.dfV = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(Bitmap bitmap) {
        if (bitmap != null && this.ciI != null) {
            this.ciI.setImageBitmap(bitmap);
        }
    }

    public void L(float f) {
        if (DEBUG) {
            Log.i("SwanAppLoadingView", "onDownloadProgressUpdate: " + f + " view: " + this.dfO);
        }
        if (this.dfO != null) {
            float f2 = f >= 0.0f ? f : 0.0f;
            this.dfR = f2 <= 1.0f ? f2 : 1.0f;
            aGH();
            if (this.dfY) {
                if (this.dfU == 0) {
                    this.dfU = System.currentTimeMillis();
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.dfU > 2000) {
                    com.baidu.swan.apps.core.f.bd("pms_downloadPkg", "包下载进度更新间隔大于2秒");
                    this.dfY = false;
                }
                this.dfU = currentTimeMillis;
            }
        }
    }

    private void s(boolean z, boolean z2) {
        if (z) {
            this.dfX = "";
        } else {
            this.dfX = this.dfO.getContext().getString(z2 ? a.h.swan_loading_view_tag_updating : a.h.swan_loading_view_tag_loading);
        }
    }

    public void t(boolean z, boolean z2) {
        if (this.dfO != null) {
            if (this.dfP != null) {
                this.dfP.cancel();
                this.dfP.removeAllUpdateListeners();
            }
            s(z, z2);
            this.dfS = 0.0f;
            this.dfR = 0.0f;
            this.dfT = 0.0f;
            if (z) {
                aGH();
                this.dfP = ValueAnimator.ofFloat(0.0f, 1.0f);
                this.dfP.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.view.c.6
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        if (floatValue > 0.9f || floatValue - c.this.dfS > 0.05d) {
                            c.this.dfS = floatValue;
                            c.this.aGH();
                        }
                    }
                });
                this.dfP.setDuration(4000L);
                this.dfP.start();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGH() {
        if (this.dfO != null) {
            float v = v(this.dfS, this.dfR);
            M(v <= 1.0f ? v : 1.0f);
        }
    }

    private void M(float f) {
        if (this.dfO != null && this.dfT <= f) {
            this.dfT = f;
            if (DEBUG) {
                Log.i("SwanAppLoadingView", "setProgressText: " + this.dfT);
            }
            int i = (int) (1000.0f * f);
            int i2 = i / 10;
            String str = ((i % 10 >= 5 ? 1 : 0) + i2) + "%";
            String trim = this.dfX.trim();
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(trim)) {
                sb.append(trim).append(" ");
            }
            sb.append(str);
            if (this.dfV != null && !this.dfV.dga) {
                if (this.dfV.aGM()) {
                    if (DEBUG) {
                        Log.i("SwanAppLoadingView", "setProgressText: checking update");
                    }
                    this.dfO.setText(this.dfO.getContext().getString(a.h.swanapp_swan_loading_runtime_check_updating));
                    this.dfO.setVisibility(0);
                } else if (this.dfV.aGN() && this.dfT <= 0.0f) {
                    if (DEBUG) {
                        Log.i("SwanAppLoadingView", "setProgressText: checking update");
                    }
                    this.dfO.setText(this.dfO.getContext().getString(a.h.swanapp_swan_loading_runtime_check_updating));
                    this.dfO.setVisibility(0);
                } else if (this.dfV.aGM()) {
                    if (DEBUG) {
                        Log.i("SwanAppLoadingView", "setProgressText: Framework loading");
                    }
                    this.dfO.setText(this.dfO.getContext().getString(a.h.swanapp_swan_loading_runtime_loading));
                    this.dfO.setVisibility(0);
                } else if (this.dfV.dgf && !this.dfV.aGO()) {
                    if (DEBUG) {
                        Log.i("SwanAppLoadingView", "setProgressText: Framework loading");
                    }
                    this.dfO.setText(this.dfO.getContext().getString(a.h.swanapp_swan_loading_runtime_loading));
                    this.dfO.setVisibility(0);
                } else if (this.dfT >= 1.0f && !this.dfV.aGO()) {
                    if (DEBUG) {
                        Log.i("SwanAppLoadingView", "setProgressText: Framework loading");
                    }
                    this.dfO.setText(this.dfO.getContext().getString(a.h.swanapp_swan_loading_runtime_loading));
                    this.dfO.setVisibility(0);
                } else {
                    this.dfO.setText(sb);
                }
            } else {
                this.dfO.setText(sb);
            }
            if (f > 0.0f) {
                this.dfO.setVisibility(0);
            }
        }
    }

    private float v(float f, float f2) {
        return ((1.0f - f) * f2) + f;
    }

    public void aGI() {
        if (this.dfO != null) {
            if (this.dfP != null) {
                this.dfP.removeAllUpdateListeners();
                this.dfP.cancel();
                this.dfP = null;
            }
            M(1.0f);
        }
    }

    public void to(String str) {
        if (DEBUG) {
            Log.i("SwanAppLoadingView", "updateIcon: icon=" + str);
        }
        final String appId = com.baidu.swan.apps.runtime.d.aAn().getAppId();
        if (this.dfQ) {
            this.ciI.setImageBitmap(ak.a(str, "SwanAppLoadingView", true, new s.a() { // from class: com.baidu.swan.apps.view.c.7
                @Override // com.baidu.swan.apps.ap.s.a
                public void g(String str2, Bitmap bitmap) {
                    SwanAppActivity aAl;
                    c YC;
                    if (bitmap != null && (aAl = com.baidu.swan.apps.runtime.d.aAn().aAl()) != null && !aAl.isDestroyed() && (YC = aAl.YC()) != null && TextUtils.equals(appId, com.baidu.swan.apps.runtime.d.aAn().getAppId())) {
                        YC.r(bitmap);
                    }
                }
            }));
        }
    }

    public void ja(String str) {
        if (this.dfQ && !TextUtils.isEmpty(str)) {
            this.dfE.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a implements Runnable {
        final com.baidu.swan.apps.runtime.b bTK;
        final boolean dga;
        final String dgb;
        private boolean dgf;
        boolean dgc = false;
        boolean dgd = false;
        private int cSG = -1;
        private int dge = -1;

        a(String str, boolean z) {
            this.dgb = str;
            this.dga = z;
            this.bTK = new com.baidu.swan.apps.runtime.b().a(new com.baidu.swan.apps.ap.e.b<i.a>() { // from class: com.baidu.swan.apps.view.c.a.7
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ap.e.b
                /* renamed from: b */
                public void J(i.a aVar) {
                    if (c.DEBUG) {
                        Log.i("SwanAppLoadingView", "onCallback: EVENT_PMS_CHECK_START");
                    }
                    a.this.cSG = aVar.getInt("KEY_PKG_STATE", -1);
                    a.this.aGK();
                }
            }, "event_pms_check_start").a(new com.baidu.swan.apps.ap.e.b<i.a>() { // from class: com.baidu.swan.apps.view.c.a.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ap.e.b
                /* renamed from: b */
                public void J(i.a aVar) {
                    if (c.DEBUG) {
                        Log.i("SwanAppLoadingView", "onCallback: EVENT_PMS_CHECK_FINISH");
                    }
                    a.this.cSG = aVar.getInt("KEY_PKG_STATE", -1);
                    a.this.aGK();
                }
            }, "event_pms_check_finish").a(new com.baidu.swan.apps.ap.e.b<i.a>() { // from class: com.baidu.swan.apps.view.c.a.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ap.e.b
                /* renamed from: b */
                public void J(i.a aVar) {
                    if (c.DEBUG) {
                        Log.i("SwanAppLoadingView", "onCallback: EVENT_PKG_DOWNLOAD_START");
                    }
                }
            }, "event_pkg_download_start").a(new com.baidu.swan.apps.ap.e.b<i.a>() { // from class: com.baidu.swan.apps.view.c.a.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ap.e.b
                /* renamed from: b */
                public void J(i.a aVar) {
                    if (c.DEBUG) {
                        Log.i("SwanAppLoadingView", "onCallback: EVENT_PKG_DOWNLOAD_FINISH");
                    }
                    a.this.dgf = true;
                    a.this.aGK();
                }
            }, "event_pkg_download_finish").a(new com.baidu.swan.apps.ap.e.b<i.a>() { // from class: com.baidu.swan.apps.view.c.a.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ap.e.b
                /* renamed from: b */
                public void J(i.a aVar) {
                    if (c.DEBUG) {
                        Log.i("SwanAppLoadingView", "onCallback: EVENT_PRELOAD_START");
                    }
                }
            }, "event_preload_start").a(new com.baidu.swan.apps.ap.e.b<i.a>() { // from class: com.baidu.swan.apps.view.c.a.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ap.e.b
                /* renamed from: b */
                public void J(i.a aVar) {
                    if (c.DEBUG) {
                        Log.i("SwanAppLoadingView", "onCallback: EVENT_PRELOAD_ERROR");
                    }
                }
            }, "event_preload_error").a(new com.baidu.swan.apps.ap.e.b<i.a>() { // from class: com.baidu.swan.apps.view.c.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ap.e.b
                /* renamed from: b */
                public void J(i.a aVar) {
                    if (c.DEBUG) {
                        Log.i("SwanAppLoadingView", "onCallback: EVENT_PRELOAD_FINISH");
                    }
                    a.this.dge = aVar.getInt("KEY_PRELOAD_STATE");
                    a.this.aGK();
                }
            }, "event_preload_finish");
            com.baidu.swan.apps.runtime.d.aAn().v(this.bTK);
        }

        void aGK() {
            boolean aGM = aGM();
            boolean aGL = aGL();
            boolean aGO = aGO();
            if (c.DEBUG) {
                Log.i("SwanAppLoadingView", "checkAndUpdateProgress: runtimeLoading " + aGM);
                Log.i("SwanAppLoadingView", "checkAndUpdateProgress: checkingUpdate " + aGL);
                Log.i("SwanAppLoadingView", "checkAndUpdateProgress: preloadFinish " + aGO);
            }
            if (aGM || aGL || !aGO) {
                c.this.aGH();
            }
        }

        boolean aGL() {
            boolean aGN = aGN();
            boolean aGO = aGO();
            boolean z = aGN && aGO;
            if (c.DEBUG) {
                Log.i("SwanAppLoadingView", "isCheckingUpdate: overMaxAge " + aGN);
                Log.i("SwanAppLoadingView", "isCheckingUpdate: preloadFinish " + aGO);
                Log.i("SwanAppLoadingView", "isCheckingUpdate: " + z);
            }
            return z;
        }

        boolean aGM() {
            boolean z = this.cSG == 4;
            boolean aGO = aGO();
            if (c.DEBUG) {
                Log.i("SwanAppLoadingView", "isRuntimeLoading: isLocalPackage " + z);
                Log.i("SwanAppLoadingView", "isRuntimeLoading: preloadFinish " + aGO);
            }
            return z && !aGO;
        }

        boolean aGN() {
            boolean z = true;
            if (this.cSG != 3 && this.cSG != 1) {
                z = false;
            }
            if (c.DEBUG) {
                Log.i("SwanAppLoadingView", "isOverMaxAge: isOverMaxAge " + z);
            }
            return z;
        }

        boolean aGO() {
            boolean akK = com.baidu.swan.apps.core.turbo.d.akC().akK();
            if (c.DEBUG) {
                Log.i("SwanAppLoadingView", "isPreloadFinish: runtimeReady " + akK);
            }
            return akK;
        }

        void onDestroy() {
            if (c.DEBUG) {
                Log.i("SwanAppLoadingView", "onDestroy: ");
            }
            com.baidu.swan.apps.runtime.d.aAn().w(this.bTK);
        }

        a aGP() {
            this.dgc = true;
            return this;
        }

        @Override // java.lang.Runnable
        public void run() {
            gi(true);
        }

        public void gi(boolean z) {
            if (c.DEBUG) {
                Log.i("SwanAppLoadingView", "ViewStarter exec : post = " + z + " trace = " + (z ? "post" : Log.getStackTraceString(new Exception())));
            }
            this.dgd = true;
            c.this.r(this.dga, this.dgc);
        }
    }
}
