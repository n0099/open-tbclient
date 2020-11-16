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
/* loaded from: classes7.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static Boolean dEN = null;
    private static View dEs;
    private static View dEt;
    public SwanAppRoundedImageView cHG;
    public BdBaseImageView cHH;
    public TextView cHI;
    private com.baidu.swan.apps.e.a dEA;
    private SwanAppActivity dEB;
    private View dEC;
    private SwanLoadingTipsView dED;
    private com.baidu.swan.games.loading.a dEE;
    private TextView dEF;
    private ValueAnimator dEG;
    private boolean dEH = false;
    private float dEI = 0.0f;
    private float dEJ = 0.0f;
    private float dEK = 0.0f;
    private long dEL = 0;
    private a dEM = null;
    private String dEO = "";
    private boolean dEP;
    public View dEu;
    public TextView dEv;
    public ImageView dEw;
    public ImageView dEx;
    private ImageView dEy;
    public RelativeLayout dEz;
    private View mRightMenu;
    private ImageView mRightMenuImageView;

    public c(SwanAppActivity swanAppActivity) {
        this.dEP = com.baidu.swan.apps.runtime.d.aGI().aeW() != 1;
        this.dEB = swanAppActivity;
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
        if (dEs == null) {
            dEs = o(context, false);
        }
        if (dEt == null) {
            dEt = o(context, true);
        }
        if (DEBUG) {
            Log.i("SwanAppLoadingView", "obtainPreloadContainer:  App=" + dEs + " Game=" + dEt);
        }
    }

    public static void aMX() {
        dEs = null;
        dEt = null;
    }

    private View n(Context context, boolean z) {
        View view = z ? dEt : dEs;
        if (z) {
            dEt = null;
        } else {
            dEs = null;
        }
        boolean z2 = (view == null || view.isAttachedToWindow()) ? false : true;
        if (z2) {
            cV(context);
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
        this.dEP = com.baidu.swan.apps.runtime.d.aGI().aeW() != 1;
        this.dEL = 0L;
        String ayo = com.baidu.swan.apps.runtime.d.aGI().aGE().aGQ().ayo();
        boolean z4 = this.dEM == null || (this.dEM.dER ^ z) || TextUtils.isEmpty(ayo) || !TextUtils.equals(ayo, this.dEM.dES);
        if (DEBUG) {
            Log.i("SwanAppLoadingView", "showSwanAppStartView: newLaunchId = " + ayo + " newIsGameLoading = " + z + " reCreateStarter = " + z4 + " mViewStarter = " + this.dEM);
        }
        Handler mainHandler = com.baidu.swan.apps.runtime.d.getMainHandler();
        if (this.dEM != null) {
            if (DEBUG) {
                Log.i("SwanAppLoadingView", "showSwanAppStartView: oldLaunchId = " + this.dEM.dES + " oldIsGameLoading = " + this.dEM.dER);
            }
            mainHandler.removeCallbacks(this.dEM);
        }
        if (z4) {
            this.dEM = new a(ayo, z);
        }
        if (this.dEM != null) {
            if (aVar == null || !aVar.getBoolean(" event_params_pkg_update", false)) {
                z3 = false;
            }
            if (this.dEM.dEU) {
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
                this.dEM.aNk();
            }
            if (z2) {
                this.dEM.hd(false);
                return;
            }
            if (DEBUG) {
                Log.i("SwanAppLoadingView", "showSwanAppStartView: post starter trace = " + Log.getStackTraceString(new Throwable()));
            }
            mainHandler.post(this.dEM);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(boolean z, boolean z2) {
        synchronized (c.class) {
            if (this.dEA == null) {
                this.dEA = new com.baidu.swan.apps.e.a();
            }
            this.dEu = n(this.dEB, z);
            if (!z) {
                this.dEu.setPadding(0, com.baidu.swan.apps.res.widget.a.SUPPORT_IMMERSION ? ah.getStatusBarHeight() : 0, 0, 0);
            } else {
                aMY();
            }
            this.dEF = (TextView) this.dEu.findViewById(a.f.aiapps_loading_progress);
            b.a aGQ = com.baidu.swan.apps.runtime.d.aGI().aGE().aGQ();
            PMSAppInfo ayl = aGQ.ayl();
            t(z, z2);
            this.dEB.aeZ().aC(this.dEu);
            this.dEH = true;
            this.dEv = (TextView) this.dEu.findViewById(a.f.aiapps_title);
            this.cHG = (SwanAppRoundedImageView) this.dEu.findViewById(a.f.aiapps_icon);
            this.cHH = (BdBaseImageView) this.dEu.findViewById(a.f.aiapps_label_bg);
            this.cHI = (TextView) this.dEu.findViewById(a.f.aiapps_label_tv);
            this.dEz = (RelativeLayout) this.dEu.findViewById(a.f.aiapps_icon_rl);
            ko(aGQ.arW());
            uC(aGQ.getIconUrl());
            ls(aGQ.getType());
            this.dEw = (ImageView) this.dEu.findViewById(a.f.light_print);
            this.dEx = (ImageView) this.dEu.findViewById(a.f.dark_print);
            this.mRightMenuImageView = (ImageView) this.dEu.findViewById(a.f.titlebar_right_menu_img);
            this.dEy = (ImageView) this.dEu.findViewById(a.f.titlebar_right_menu_exit);
            this.mRightMenu = this.dEu.findViewById(a.f.titlebar_right_menu);
            if (z) {
                this.mRightMenuImageView.setClickable(true);
                this.mRightMenuImageView.setImageResource(a.e.aiapps_action_bar_single_menu_white_selector);
                this.dEy.setImageResource(a.e.aiapps_action_bar_exit_white_selector);
                this.mRightMenu.setBackgroundResource(a.e.aiapps_action_bar_right_menu_bg_solid);
                this.dEC = this.dEu.findViewById(a.f.titlebar_right_menu_line);
                this.dEC.setBackgroundResource(a.c.aiapps_action_bar_menu_line_white);
            } else {
                this.mRightMenuImageView.setImageResource(a.e.aiapps_action_bar_menu_black_selector);
                this.dEy.setImageResource(a.e.aiapps_action_bar_exit_black_selector);
                this.mRightMenu.setBackgroundResource(a.e.aiapps_action_bar_right_menu_bg);
            }
            int i = ayl == null ? PMSConstants.PayProtected.NO_PAY_PROTECTED.type : ayl.payProtected;
            if (!z && ak.aMs() && i == PMSConstants.PayProtected.PAY_PROTECTED.type) {
                ((RelativeLayout) this.dEu.findViewById(a.f.guarantee_plan_rl)).setVisibility(0);
            }
            this.dEx.setAlpha(0.0f);
            this.dEA.g(this.dEB);
            aNa();
        }
    }

    private void aMY() {
        this.dED = (SwanLoadingTipsView) this.dEu.findViewById(a.f.aigames_loading_game_tips);
        this.dED.setTipsAnimationFinishCallback(new kotlin.jvm.a.a<l>() { // from class: com.baidu.swan.apps.view.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.a.a
            /* renamed from: aNe */
            public l invoke() {
                c.this.aMZ();
                return null;
            }
        });
        this.dEE = new com.baidu.swan.games.loading.a();
        this.dEu.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.swan.apps.view.c.3
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                c.this.aMZ();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMZ() {
        if (this.dED != null && this.dEE != null) {
            this.dED.xj(this.dEE.aVE());
        }
    }

    private void aNa() {
        this.dEy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.view.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.dEB != null && !c.this.dEB.isFinishing()) {
                    HybridUbcFlow aCZ = com.baidu.swan.apps.performance.i.aCZ();
                    if (aCZ != null) {
                        aCZ.ch("exitType", String.valueOf(3));
                        aCZ.r("value", "cancel");
                        aCZ.aCE();
                    }
                    c.this.dEB.moveTaskToBack(true);
                    ap.aMC().ln(2);
                    c.this.aNb();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNb() {
        Bundle aya;
        b.a afg = this.dEB.afg();
        if (afg != null && (aya = afg.aya()) != null) {
            long j = aya.getLong("page_display_flag_for_statistic");
            aya.remove("page_display_flag_for_statistic");
            if (j > 0) {
                String valueOf = String.valueOf(System.currentTimeMillis() - afg.getLong("launch_time", 0L));
                f fVar = new f();
                fVar.mType = Config.LAUNCH;
                fVar.mValue = "realcancel";
                fVar.dyI = valueOf;
                fVar.u(TiebaInitialize.LogFields.REASON, "close");
                if (afg.getAppFrameType() == 1) {
                    fVar.u("errorList", com.baidu.swan.games.v.b.aWt().aWu());
                }
                this.dEB.a(fVar);
                e.b(afg);
            }
        }
    }

    private void ls(int i) {
        ah.a(this.cHH, this.cHI, String.valueOf(i));
    }

    public void lt(final int i) {
        Handler mainHandler = com.baidu.swan.apps.runtime.d.getMainHandler();
        if (this.dEM != null) {
            mainHandler.removeCallbacks(this.dEM);
            this.dEM.onDestroy();
            this.dEM = null;
        }
        mainHandler.post(new Runnable() { // from class: com.baidu.swan.apps.view.c.5
            @Override // java.lang.Runnable
            public void run() {
                synchronized (c.class) {
                    com.baidu.swan.apps.performance.i.aCY().f(new UbcFlowEvent("first_anim_end"));
                    com.baidu.swan.apps.ak.a.aJk().sN("first_anim_end");
                    if (c.this.dEA != null) {
                        c.this.dEA.a(c.this.dEB, i);
                    }
                    c.this.dEH = false;
                }
            }
        });
    }

    public void aiN() {
        if (DEBUG) {
            Log.i("SwanAppLoadingView", "stopAnimations: " + Log.getStackTraceString(new Exception()));
        }
        Handler mainHandler = com.baidu.swan.apps.runtime.d.getMainHandler();
        if (this.dEM != null) {
            mainHandler.removeCallbacks(this.dEM);
            this.dEM.onDestroy();
            this.dEM = null;
        }
        synchronized (c.class) {
            if (this.dEA != null) {
                this.dEA.aiN();
            }
            if (this.dED != null) {
                this.dED.doDestroy();
                this.dED = null;
            }
            if (this.dEF != null) {
                this.dEF.setVisibility(8);
                this.dEF = null;
                this.dEO = "";
                this.dEJ = 0.0f;
                this.dEI = 0.0f;
                this.dEK = 0.0f;
            }
            if (this.dEG != null) {
                this.dEG.removeAllUpdateListeners();
                this.dEG.cancel();
                this.dEG = null;
            }
            this.dEH = false;
            if (this.dEM != null) {
                this.dEM.onDestroy();
                this.dEM = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(Bitmap bitmap) {
        if (bitmap != null && this.cHG != null) {
            this.cHG.setImageBitmap(bitmap);
        }
    }

    public void Q(float f) {
        if (DEBUG) {
            Log.i("SwanAppLoadingView", "onDownloadProgressUpdate: " + f + " view: " + this.dEF);
        }
        if (this.dEF != null) {
            float f2 = f >= 0.0f ? f : 0.0f;
            this.dEI = f2 <= 1.0f ? f2 : 1.0f;
            aNc();
            if (this.dEP) {
                if (this.dEL == 0) {
                    this.dEL = System.currentTimeMillis();
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.dEL > 2000) {
                    com.baidu.swan.apps.core.f.bo("pms_downloadPkg", "包下载进度更新间隔大于2秒");
                    this.dEP = false;
                }
                this.dEL = currentTimeMillis;
            }
        }
    }

    private void s(boolean z, boolean z2) {
        if (z) {
            this.dEO = "";
        } else {
            this.dEO = this.dEF.getContext().getString(z2 ? a.h.swan_loading_view_tag_updating : a.h.swan_loading_view_tag_loading);
        }
    }

    public void t(boolean z, boolean z2) {
        if (this.dEF != null) {
            if (this.dEG != null) {
                this.dEG.cancel();
                this.dEG.removeAllUpdateListeners();
            }
            s(z, z2);
            this.dEJ = 0.0f;
            this.dEI = 0.0f;
            this.dEK = 0.0f;
            if (z) {
                aNc();
                this.dEG = ValueAnimator.ofFloat(0.0f, 1.0f);
                this.dEG.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.view.c.6
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        if (floatValue > 0.9f || floatValue - c.this.dEJ > 0.05d) {
                            c.this.dEJ = floatValue;
                            c.this.aNc();
                        }
                    }
                });
                this.dEG.setDuration(4000L);
                this.dEG.start();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNc() {
        if (this.dEF != null) {
            float v = v(this.dEJ, this.dEI);
            R(v <= 1.0f ? v : 1.0f);
        }
    }

    private void R(float f) {
        if (this.dEF != null && this.dEK <= f) {
            this.dEK = f;
            if (DEBUG) {
                Log.i("SwanAppLoadingView", "setProgressText: " + this.dEK);
            }
            int i = (int) (1000.0f * f);
            int i2 = i / 10;
            String str = ((i % 10 >= 5 ? 1 : 0) + i2) + "%";
            String trim = this.dEO.trim();
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(trim)) {
                sb.append(trim).append(" ");
            }
            sb.append(str);
            if (this.dEM != null && !this.dEM.dER) {
                if (this.dEM.aNh()) {
                    if (DEBUG) {
                        Log.i("SwanAppLoadingView", "setProgressText: checking update");
                    }
                    this.dEF.setText(this.dEF.getContext().getString(a.h.swanapp_swan_loading_runtime_check_updating));
                    this.dEF.setVisibility(0);
                } else if (this.dEM.aNi() && this.dEK <= 0.0f) {
                    if (DEBUG) {
                        Log.i("SwanAppLoadingView", "setProgressText: checking update");
                    }
                    this.dEF.setText(this.dEF.getContext().getString(a.h.swanapp_swan_loading_runtime_check_updating));
                    this.dEF.setVisibility(0);
                } else if (this.dEM.aNh()) {
                    if (DEBUG) {
                        Log.i("SwanAppLoadingView", "setProgressText: Framework loading");
                    }
                    this.dEF.setText(this.dEF.getContext().getString(a.h.swanapp_swan_loading_runtime_loading));
                    this.dEF.setVisibility(0);
                } else if (this.dEM.dEW && !this.dEM.aNj()) {
                    if (DEBUG) {
                        Log.i("SwanAppLoadingView", "setProgressText: Framework loading");
                    }
                    this.dEF.setText(this.dEF.getContext().getString(a.h.swanapp_swan_loading_runtime_loading));
                    this.dEF.setVisibility(0);
                } else if (this.dEK >= 1.0f && !this.dEM.aNj()) {
                    if (DEBUG) {
                        Log.i("SwanAppLoadingView", "setProgressText: Framework loading");
                    }
                    this.dEF.setText(this.dEF.getContext().getString(a.h.swanapp_swan_loading_runtime_loading));
                    this.dEF.setVisibility(0);
                } else {
                    this.dEF.setText(sb);
                }
            } else {
                this.dEF.setText(sb);
            }
            if (f > 0.0f) {
                this.dEF.setVisibility(0);
            }
        }
    }

    private float v(float f, float f2) {
        return ((1.0f - f) * f2) + f;
    }

    public void aNd() {
        if (this.dEF != null) {
            if (this.dEG != null) {
                this.dEG.removeAllUpdateListeners();
                this.dEG.cancel();
                this.dEG = null;
            }
            R(1.0f);
        }
    }

    public void uC(String str) {
        if (DEBUG) {
            Log.i("SwanAppLoadingView", "updateIcon: icon=" + str);
        }
        final String appId = com.baidu.swan.apps.runtime.d.aGI().getAppId();
        if (this.dEH) {
            this.cHG.setImageBitmap(ak.a(str, "SwanAppLoadingView", true, new s.a() { // from class: com.baidu.swan.apps.view.c.7
                @Override // com.baidu.swan.apps.ap.s.a
                public void g(String str2, Bitmap bitmap) {
                    SwanAppActivity aGG;
                    c afa;
                    if (bitmap != null && (aGG = com.baidu.swan.apps.runtime.d.aGI().aGG()) != null && !aGG.isDestroyed() && (afa = aGG.afa()) != null && TextUtils.equals(appId, com.baidu.swan.apps.runtime.d.aGI().getAppId())) {
                        afa.r(bitmap);
                    }
                }
            }));
        }
    }

    public void ko(String str) {
        if (this.dEH && !TextUtils.isEmpty(str)) {
            this.dEv.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class a implements Runnable {
        final com.baidu.swan.apps.runtime.b csJ;
        final boolean dER;
        final String dES;
        private boolean dEW;
        boolean dET = false;
        boolean dEU = false;
        private int drC = -1;
        private int dEV = -1;

        a(String str, boolean z) {
            this.dES = str;
            this.dER = z;
            this.csJ = new com.baidu.swan.apps.runtime.b().a(new com.baidu.swan.apps.ap.e.b<i.a>() { // from class: com.baidu.swan.apps.view.c.a.7
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ap.e.b
                /* renamed from: b */
                public void M(i.a aVar) {
                    if (c.DEBUG) {
                        Log.i("SwanAppLoadingView", "onCallback: EVENT_PMS_CHECK_START");
                    }
                    a.this.drC = aVar.getInt("KEY_PKG_STATE", -1);
                    a.this.aNf();
                }
            }, "event_pms_check_start").a(new com.baidu.swan.apps.ap.e.b<i.a>() { // from class: com.baidu.swan.apps.view.c.a.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ap.e.b
                /* renamed from: b */
                public void M(i.a aVar) {
                    if (c.DEBUG) {
                        Log.i("SwanAppLoadingView", "onCallback: EVENT_PMS_CHECK_FINISH");
                    }
                    a.this.drC = aVar.getInt("KEY_PKG_STATE", -1);
                    a.this.aNf();
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
                    a.this.dEW = true;
                    a.this.aNf();
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
                    a.this.dEV = aVar.getInt("KEY_PRELOAD_STATE");
                    a.this.aNf();
                }
            }, "event_preload_finish");
            com.baidu.swan.apps.runtime.d.aGI().v(this.csJ);
        }

        void aNf() {
            boolean aNh = aNh();
            boolean aNg = aNg();
            boolean aNj = aNj();
            if (c.DEBUG) {
                Log.i("SwanAppLoadingView", "checkAndUpdateProgress: runtimeLoading " + aNh);
                Log.i("SwanAppLoadingView", "checkAndUpdateProgress: checkingUpdate " + aNg);
                Log.i("SwanAppLoadingView", "checkAndUpdateProgress: preloadFinish " + aNj);
            }
            if (aNh || aNg || !aNj) {
                c.this.aNc();
            }
        }

        boolean aNg() {
            boolean aNi = aNi();
            boolean aNj = aNj();
            boolean z = aNi && aNj;
            if (c.DEBUG) {
                Log.i("SwanAppLoadingView", "isCheckingUpdate: overMaxAge " + aNi);
                Log.i("SwanAppLoadingView", "isCheckingUpdate: preloadFinish " + aNj);
                Log.i("SwanAppLoadingView", "isCheckingUpdate: " + z);
            }
            return z;
        }

        boolean aNh() {
            boolean z = this.drC == 4;
            boolean aNj = aNj();
            if (c.DEBUG) {
                Log.i("SwanAppLoadingView", "isRuntimeLoading: isLocalPackage " + z);
                Log.i("SwanAppLoadingView", "isRuntimeLoading: preloadFinish " + aNj);
            }
            return z && !aNj;
        }

        boolean aNi() {
            boolean z = true;
            if (this.drC != 3 && this.drC != 1) {
                z = false;
            }
            if (c.DEBUG) {
                Log.i("SwanAppLoadingView", "isOverMaxAge: isOverMaxAge " + z);
            }
            return z;
        }

        boolean aNj() {
            boolean ari = com.baidu.swan.apps.core.turbo.d.ara().ari();
            if (c.DEBUG) {
                Log.i("SwanAppLoadingView", "isPreloadFinish: runtimeReady " + ari);
            }
            return ari;
        }

        void onDestroy() {
            if (c.DEBUG) {
                Log.i("SwanAppLoadingView", "onDestroy: ");
            }
            com.baidu.swan.apps.runtime.d.aGI().w(this.csJ);
        }

        a aNk() {
            this.dET = true;
            return this;
        }

        @Override // java.lang.Runnable
        public void run() {
            hd(true);
        }

        public void hd(boolean z) {
            if (c.DEBUG) {
                Log.i("SwanAppLoadingView", "ViewStarter exec : post = " + z + " trace = " + (z ? "post" : Log.getStackTraceString(new Exception())));
            }
            this.dEU = true;
            c.this.r(this.dER, this.dET);
        }
    }
}
