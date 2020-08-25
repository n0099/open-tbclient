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
/* loaded from: classes8.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static Boolean ddR = null;
    private static View ddw;
    private static View ddx;
    public SwanAppRoundedImageView cgC;
    public BdBaseImageView cgD;
    public TextView cgE;
    public ImageView ddA;
    public ImageView ddB;
    private ImageView ddC;
    public RelativeLayout ddD;
    private com.baidu.swan.apps.e.a ddE;
    private SwanAppActivity ddF;
    private View ddG;
    private SwanLoadingTipsView ddH;
    private com.baidu.swan.games.loading.a ddI;
    private TextView ddJ;
    private ValueAnimator ddK;
    private boolean ddL = false;
    private float ddM = 0.0f;
    private float ddN = 0.0f;
    private float ddO = 0.0f;
    private long ddP = 0;
    private a ddQ = null;
    private String ddS = "";
    private boolean ddT;
    public View ddy;
    public TextView ddz;
    private View mRightMenu;
    private ImageView mRightMenuImageView;

    public c(SwanAppActivity swanAppActivity) {
        this.ddT = com.baidu.swan.apps.runtime.d.azE().XP() != 1;
        this.ddF = swanAppActivity;
    }

    public static void cQ(final Context context) {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.view.c.1
            @Override // java.lang.Runnable
            public void run() {
                c.cR(context);
            }
        }, 5000L);
    }

    public static void cR(Context context) {
        if (ddw == null) {
            ddw = n(context, false);
        }
        if (ddx == null) {
            ddx = n(context, true);
        }
        if (DEBUG) {
            Log.i("SwanAppLoadingView", "obtainPreloadContainer:  App=" + ddw + " Game=" + ddx);
        }
    }

    public static void aFS() {
        ddw = null;
        ddx = null;
    }

    private View m(Context context, boolean z) {
        View view = z ? ddx : ddw;
        if (z) {
            ddx = null;
        } else {
            ddw = null;
        }
        boolean z2 = (view == null || view.isAttachedToWindow()) ? false : true;
        if (z2) {
            cQ(context);
        }
        if (!z2) {
            view = n(context, z);
        }
        if (DEBUG) {
            Log.i("SwanAppLoadingView", "obtainPreloadContainer:  isLegalContainer= " + z2 + " game=" + z + " container=" + view);
        }
        return view;
    }

    private static View n(Context context, boolean z) {
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
        this.ddT = com.baidu.swan.apps.runtime.d.azE().XP() != 1;
        this.ddP = 0L;
        String arg = com.baidu.swan.apps.runtime.d.azE().azA().azM().arg();
        boolean z4 = this.ddQ == null || (this.ddQ.ddV ^ z) || TextUtils.isEmpty(arg) || !TextUtils.equals(arg, this.ddQ.ddW);
        if (DEBUG) {
            Log.i("SwanAppLoadingView", "showSwanAppStartView: newLaunchId = " + arg + " newIsGameLoading = " + z + " reCreateStarter = " + z4 + " mViewStarter = " + this.ddQ);
        }
        Handler mainHandler = com.baidu.swan.apps.runtime.d.getMainHandler();
        if (this.ddQ != null) {
            if (DEBUG) {
                Log.i("SwanAppLoadingView", "showSwanAppStartView: oldLaunchId = " + this.ddQ.ddW + " oldIsGameLoading = " + this.ddQ.ddV);
            }
            mainHandler.removeCallbacks(this.ddQ);
        }
        if (z4) {
            this.ddQ = new a(arg, z);
        }
        if (this.ddQ != null) {
            if (aVar == null || !aVar.getBoolean(" event_params_pkg_update", false)) {
                z3 = false;
            }
            if (this.ddQ.ddY) {
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
                this.ddQ.aGf();
            }
            if (z2) {
                this.ddQ.gj(false);
                return;
            }
            if (DEBUG) {
                Log.i("SwanAppLoadingView", "showSwanAppStartView: post starter trace = " + Log.getStackTraceString(new Throwable()));
            }
            mainHandler.post(this.ddQ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(boolean z, boolean z2) {
        synchronized (c.class) {
            if (this.ddE == null) {
                this.ddE = new com.baidu.swan.apps.e.a();
            }
            this.ddy = m(this.ddF, z);
            if (!z) {
                this.ddy.setPadding(0, com.baidu.swan.apps.res.widget.a.SUPPORT_IMMERSION ? ah.getStatusBarHeight() : 0, 0, 0);
            } else {
                aFT();
            }
            this.ddJ = (TextView) this.ddy.findViewById(a.f.aiapps_loading_progress);
            b.a azM = com.baidu.swan.apps.runtime.d.azE().azA().azM();
            PMSAppInfo ard = azM.ard();
            t(z, z2);
            this.ddF.XS().au(this.ddy);
            this.ddL = true;
            this.ddz = (TextView) this.ddy.findViewById(a.f.aiapps_title);
            this.cgC = (SwanAppRoundedImageView) this.ddy.findViewById(a.f.aiapps_icon);
            this.cgD = (BdBaseImageView) this.ddy.findViewById(a.f.aiapps_label_bg);
            this.cgE = (TextView) this.ddy.findViewById(a.f.aiapps_label_tv);
            this.ddD = (RelativeLayout) this.ddy.findViewById(a.f.aiapps_icon_rl);
            iG(azM.akO());
            sU(azM.getIconUrl());
            kt(azM.getType());
            this.ddA = (ImageView) this.ddy.findViewById(a.f.light_print);
            this.ddB = (ImageView) this.ddy.findViewById(a.f.dark_print);
            this.mRightMenuImageView = (ImageView) this.ddy.findViewById(a.f.titlebar_right_menu_img);
            this.ddC = (ImageView) this.ddy.findViewById(a.f.titlebar_right_menu_exit);
            this.mRightMenu = this.ddy.findViewById(a.f.titlebar_right_menu);
            if (z) {
                this.mRightMenuImageView.setClickable(true);
                this.mRightMenuImageView.setImageResource(a.e.aiapps_action_bar_single_menu_white_selector);
                this.ddC.setImageResource(a.e.aiapps_action_bar_exit_white_selector);
                this.mRightMenu.setBackgroundResource(a.e.aiapps_action_bar_right_menu_bg_solid);
                this.ddG = this.ddy.findViewById(a.f.titlebar_right_menu_line);
                this.ddG.setBackgroundResource(a.c.aiapps_action_bar_menu_line_white);
            } else {
                this.mRightMenuImageView.setImageResource(a.e.aiapps_action_bar_menu_black_selector);
                this.ddC.setImageResource(a.e.aiapps_action_bar_exit_black_selector);
                this.mRightMenu.setBackgroundResource(a.e.aiapps_action_bar_right_menu_bg);
            }
            int i = ard == null ? PMSConstants.PayProtected.NO_PAY_PROTECTED.type : ard.payProtected;
            if (!z && ak.aFn() && i == PMSConstants.PayProtected.PAY_PROTECTED.type) {
                ((RelativeLayout) this.ddy.findViewById(a.f.guarantee_plan_rl)).setVisibility(0);
            }
            this.ddB.setAlpha(0.0f);
            this.ddE.g(this.ddF);
            aFV();
        }
    }

    private void aFT() {
        this.ddH = (SwanLoadingTipsView) this.ddy.findViewById(a.f.aigames_loading_game_tips);
        this.ddH.setTipsAnimationFinishCallback(new kotlin.jvm.a.a<l>() { // from class: com.baidu.swan.apps.view.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.a.a
            /* renamed from: aFZ */
            public l invoke() {
                c.this.aFU();
                return null;
            }
        });
        this.ddI = new com.baidu.swan.games.loading.a();
        this.ddy.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.swan.apps.view.c.3
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                c.this.aFU();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFU() {
        if (this.ddH != null && this.ddI != null) {
            this.ddH.vB(this.ddI.aOy());
        }
    }

    private void aFV() {
        this.ddC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.view.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.ddF != null && !c.this.ddF.isFinishing()) {
                    HybridUbcFlow avT = com.baidu.swan.apps.performance.i.avT();
                    if (avT != null) {
                        avT.bW("exitType", String.valueOf(3));
                        avT.r("value", "cancel");
                        avT.avy();
                    }
                    c.this.ddF.moveTaskToBack(true);
                    ap.aFx().ko(2);
                    c.this.aFW();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFW() {
        Bundle aqS;
        b.a XZ = this.ddF.XZ();
        if (XZ != null && (aqS = XZ.aqS()) != null) {
            long j = aqS.getLong("page_display_flag_for_statistic");
            aqS.remove("page_display_flag_for_statistic");
            if (j > 0) {
                String valueOf = String.valueOf(System.currentTimeMillis() - XZ.getLong("launch_time", 0L));
                f fVar = new f();
                fVar.mType = Config.LAUNCH;
                fVar.mValue = "realcancel";
                fVar.cXH = valueOf;
                fVar.u(TiebaInitialize.LogFields.REASON, "close");
                if (XZ.getAppFrameType() == 1) {
                    fVar.u("errorList", com.baidu.swan.games.v.b.aPn().aPo());
                }
                this.ddF.a(fVar);
                e.b(XZ);
            }
        }
    }

    private void kt(int i) {
        ah.a(this.cgD, this.cgE, String.valueOf(i));
    }

    public void ku(final int i) {
        Handler mainHandler = com.baidu.swan.apps.runtime.d.getMainHandler();
        if (this.ddQ != null) {
            mainHandler.removeCallbacks(this.ddQ);
            this.ddQ.onDestroy();
            this.ddQ = null;
        }
        mainHandler.post(new Runnable() { // from class: com.baidu.swan.apps.view.c.5
            @Override // java.lang.Runnable
            public void run() {
                synchronized (c.class) {
                    com.baidu.swan.apps.performance.i.avS().f(new UbcFlowEvent("first_anim_end"));
                    com.baidu.swan.apps.ak.a.aCf().re("first_anim_end");
                    if (c.this.ddE != null) {
                        c.this.ddE.a(c.this.ddF, i);
                    }
                    c.this.ddL = false;
                }
            }
        });
    }

    public void abG() {
        if (DEBUG) {
            Log.i("SwanAppLoadingView", "stopAnimations: " + Log.getStackTraceString(new Exception()));
        }
        Handler mainHandler = com.baidu.swan.apps.runtime.d.getMainHandler();
        if (this.ddQ != null) {
            mainHandler.removeCallbacks(this.ddQ);
            this.ddQ.onDestroy();
            this.ddQ = null;
        }
        synchronized (c.class) {
            if (this.ddE != null) {
                this.ddE.abG();
            }
            if (this.ddH != null) {
                this.ddH.doDestroy();
                this.ddH = null;
            }
            if (this.ddJ != null) {
                this.ddJ.setVisibility(8);
                this.ddJ = null;
                this.ddS = "";
                this.ddN = 0.0f;
                this.ddM = 0.0f;
                this.ddO = 0.0f;
            }
            if (this.ddK != null) {
                this.ddK.removeAllUpdateListeners();
                this.ddK.cancel();
                this.ddK = null;
            }
            this.ddL = false;
            if (this.ddQ != null) {
                this.ddQ.onDestroy();
                this.ddQ = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(Bitmap bitmap) {
        if (bitmap != null && this.cgC != null) {
            this.cgC.setImageBitmap(bitmap);
        }
    }

    public void L(float f) {
        if (DEBUG) {
            Log.i("SwanAppLoadingView", "onDownloadProgressUpdate: " + f + " view: " + this.ddJ);
        }
        if (this.ddJ != null) {
            float f2 = f >= 0.0f ? f : 0.0f;
            this.ddM = f2 <= 1.0f ? f2 : 1.0f;
            aFX();
            if (this.ddT) {
                if (this.ddP == 0) {
                    this.ddP = System.currentTimeMillis();
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.ddP > 2000) {
                    com.baidu.swan.apps.core.f.bd("pms_downloadPkg", "包下载进度更新间隔大于2秒");
                    this.ddT = false;
                }
                this.ddP = currentTimeMillis;
            }
        }
    }

    private void s(boolean z, boolean z2) {
        if (z) {
            this.ddS = "";
        } else {
            this.ddS = this.ddJ.getContext().getString(z2 ? a.h.swan_loading_view_tag_updating : a.h.swan_loading_view_tag_loading);
        }
    }

    public void t(boolean z, boolean z2) {
        if (this.ddJ != null) {
            if (this.ddK != null) {
                this.ddK.cancel();
                this.ddK.removeAllUpdateListeners();
            }
            s(z, z2);
            this.ddN = 0.0f;
            this.ddM = 0.0f;
            this.ddO = 0.0f;
            if (z) {
                aFX();
                this.ddK = ValueAnimator.ofFloat(0.0f, 1.0f);
                this.ddK.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.view.c.6
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        if (floatValue > 0.9f || floatValue - c.this.ddN > 0.05d) {
                            c.this.ddN = floatValue;
                            c.this.aFX();
                        }
                    }
                });
                this.ddK.setDuration(4000L);
                this.ddK.start();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFX() {
        if (this.ddJ != null) {
            float u = u(this.ddN, this.ddM);
            M(u <= 1.0f ? u : 1.0f);
        }
    }

    private void M(float f) {
        if (this.ddJ != null && this.ddO <= f) {
            this.ddO = f;
            if (DEBUG) {
                Log.i("SwanAppLoadingView", "setProgressText: " + this.ddO);
            }
            int i = (int) (1000.0f * f);
            int i2 = i / 10;
            String str = ((i % 10 >= 5 ? 1 : 0) + i2) + "%";
            String trim = this.ddS.trim();
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(trim)) {
                sb.append(trim).append(" ");
            }
            sb.append(str);
            if (this.ddQ != null && !this.ddQ.ddV) {
                if (this.ddQ.aGc()) {
                    if (DEBUG) {
                        Log.i("SwanAppLoadingView", "setProgressText: checking update");
                    }
                    this.ddJ.setText(this.ddJ.getContext().getString(a.h.swanapp_swan_loading_runtime_check_updating));
                    this.ddJ.setVisibility(0);
                } else if (this.ddQ.aGd() && this.ddO <= 0.0f) {
                    if (DEBUG) {
                        Log.i("SwanAppLoadingView", "setProgressText: checking update");
                    }
                    this.ddJ.setText(this.ddJ.getContext().getString(a.h.swanapp_swan_loading_runtime_check_updating));
                    this.ddJ.setVisibility(0);
                } else if (this.ddQ.aGc()) {
                    if (DEBUG) {
                        Log.i("SwanAppLoadingView", "setProgressText: Framework loading");
                    }
                    this.ddJ.setText(this.ddJ.getContext().getString(a.h.swanapp_swan_loading_runtime_loading));
                    this.ddJ.setVisibility(0);
                } else if (this.ddQ.dea && !this.ddQ.aGe()) {
                    if (DEBUG) {
                        Log.i("SwanAppLoadingView", "setProgressText: Framework loading");
                    }
                    this.ddJ.setText(this.ddJ.getContext().getString(a.h.swanapp_swan_loading_runtime_loading));
                    this.ddJ.setVisibility(0);
                } else if (this.ddO >= 1.0f && !this.ddQ.aGe()) {
                    if (DEBUG) {
                        Log.i("SwanAppLoadingView", "setProgressText: Framework loading");
                    }
                    this.ddJ.setText(this.ddJ.getContext().getString(a.h.swanapp_swan_loading_runtime_loading));
                    this.ddJ.setVisibility(0);
                } else {
                    this.ddJ.setText(sb);
                }
            } else {
                this.ddJ.setText(sb);
            }
            if (f > 0.0f) {
                this.ddJ.setVisibility(0);
            }
        }
    }

    private float u(float f, float f2) {
        return ((1.0f - f) * f2) + f;
    }

    public void aFY() {
        if (this.ddJ != null) {
            if (this.ddK != null) {
                this.ddK.removeAllUpdateListeners();
                this.ddK.cancel();
                this.ddK = null;
            }
            M(1.0f);
        }
    }

    public void sU(String str) {
        if (DEBUG) {
            Log.i("SwanAppLoadingView", "updateIcon: icon=" + str);
        }
        final String appId = com.baidu.swan.apps.runtime.d.azE().getAppId();
        if (this.ddL) {
            this.cgC.setImageBitmap(ak.a(str, "SwanAppLoadingView", true, new s.a() { // from class: com.baidu.swan.apps.view.c.7
                @Override // com.baidu.swan.apps.ap.s.a
                public void h(String str2, Bitmap bitmap) {
                    SwanAppActivity azC;
                    c XT;
                    if (bitmap != null && (azC = com.baidu.swan.apps.runtime.d.azE().azC()) != null && !azC.isDestroyed() && (XT = azC.XT()) != null && TextUtils.equals(appId, com.baidu.swan.apps.runtime.d.azE().getAppId())) {
                        XT.r(bitmap);
                    }
                }
            }));
        }
    }

    public void iG(String str) {
        if (this.ddL && !TextUtils.isEmpty(str)) {
            this.ddz.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a implements Runnable {
        final com.baidu.swan.apps.runtime.b bRG;
        final boolean ddV;
        final String ddW;
        private boolean dea;
        boolean ddX = false;
        boolean ddY = false;
        private int cQC = -1;
        private int ddZ = -1;

        a(String str, boolean z) {
            this.ddW = str;
            this.ddV = z;
            this.bRG = new com.baidu.swan.apps.runtime.b().a(new com.baidu.swan.apps.ap.e.b<i.a>() { // from class: com.baidu.swan.apps.view.c.a.7
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ap.e.b
                /* renamed from: b */
                public void I(i.a aVar) {
                    if (c.DEBUG) {
                        Log.i("SwanAppLoadingView", "onCallback: EVENT_PMS_CHECK_START");
                    }
                    a.this.cQC = aVar.getInt("KEY_PKG_STATE", -1);
                    a.this.aGa();
                }
            }, "event_pms_check_start").a(new com.baidu.swan.apps.ap.e.b<i.a>() { // from class: com.baidu.swan.apps.view.c.a.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ap.e.b
                /* renamed from: b */
                public void I(i.a aVar) {
                    if (c.DEBUG) {
                        Log.i("SwanAppLoadingView", "onCallback: EVENT_PMS_CHECK_FINISH");
                    }
                    a.this.cQC = aVar.getInt("KEY_PKG_STATE", -1);
                    a.this.aGa();
                }
            }, "event_pms_check_finish").a(new com.baidu.swan.apps.ap.e.b<i.a>() { // from class: com.baidu.swan.apps.view.c.a.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ap.e.b
                /* renamed from: b */
                public void I(i.a aVar) {
                    if (c.DEBUG) {
                        Log.i("SwanAppLoadingView", "onCallback: EVENT_PKG_DOWNLOAD_START");
                    }
                }
            }, "event_pkg_download_start").a(new com.baidu.swan.apps.ap.e.b<i.a>() { // from class: com.baidu.swan.apps.view.c.a.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ap.e.b
                /* renamed from: b */
                public void I(i.a aVar) {
                    if (c.DEBUG) {
                        Log.i("SwanAppLoadingView", "onCallback: EVENT_PKG_DOWNLOAD_FINISH");
                    }
                    a.this.dea = true;
                    a.this.aGa();
                }
            }, "event_pkg_download_finish").a(new com.baidu.swan.apps.ap.e.b<i.a>() { // from class: com.baidu.swan.apps.view.c.a.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ap.e.b
                /* renamed from: b */
                public void I(i.a aVar) {
                    if (c.DEBUG) {
                        Log.i("SwanAppLoadingView", "onCallback: EVENT_PRELOAD_START");
                    }
                }
            }, "event_preload_start").a(new com.baidu.swan.apps.ap.e.b<i.a>() { // from class: com.baidu.swan.apps.view.c.a.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ap.e.b
                /* renamed from: b */
                public void I(i.a aVar) {
                    if (c.DEBUG) {
                        Log.i("SwanAppLoadingView", "onCallback: EVENT_PRELOAD_ERROR");
                    }
                }
            }, "event_preload_error").a(new com.baidu.swan.apps.ap.e.b<i.a>() { // from class: com.baidu.swan.apps.view.c.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ap.e.b
                /* renamed from: b */
                public void I(i.a aVar) {
                    if (c.DEBUG) {
                        Log.i("SwanAppLoadingView", "onCallback: EVENT_PRELOAD_FINISH");
                    }
                    a.this.ddZ = aVar.getInt("KEY_PRELOAD_STATE");
                    a.this.aGa();
                }
            }, "event_preload_finish");
            com.baidu.swan.apps.runtime.d.azE().v(this.bRG);
        }

        void aGa() {
            boolean aGc = aGc();
            boolean aGb = aGb();
            boolean aGe = aGe();
            if (c.DEBUG) {
                Log.i("SwanAppLoadingView", "checkAndUpdateProgress: runtimeLoading " + aGc);
                Log.i("SwanAppLoadingView", "checkAndUpdateProgress: checkingUpdate " + aGb);
                Log.i("SwanAppLoadingView", "checkAndUpdateProgress: preloadFinish " + aGe);
            }
            if (aGc || aGb || !aGe) {
                c.this.aFX();
            }
        }

        boolean aGb() {
            boolean aGd = aGd();
            boolean aGe = aGe();
            boolean z = aGd && aGe;
            if (c.DEBUG) {
                Log.i("SwanAppLoadingView", "isCheckingUpdate: overMaxAge " + aGd);
                Log.i("SwanAppLoadingView", "isCheckingUpdate: preloadFinish " + aGe);
                Log.i("SwanAppLoadingView", "isCheckingUpdate: " + z);
            }
            return z;
        }

        boolean aGc() {
            boolean z = this.cQC == 4;
            boolean aGe = aGe();
            if (c.DEBUG) {
                Log.i("SwanAppLoadingView", "isRuntimeLoading: isLocalPackage " + z);
                Log.i("SwanAppLoadingView", "isRuntimeLoading: preloadFinish " + aGe);
            }
            return z && !aGe;
        }

        boolean aGd() {
            boolean z = true;
            if (this.cQC != 3 && this.cQC != 1) {
                z = false;
            }
            if (c.DEBUG) {
                Log.i("SwanAppLoadingView", "isOverMaxAge: isOverMaxAge " + z);
            }
            return z;
        }

        boolean aGe() {
            boolean aka = com.baidu.swan.apps.core.turbo.d.ajS().aka();
            if (c.DEBUG) {
                Log.i("SwanAppLoadingView", "isPreloadFinish: runtimeReady " + aka);
            }
            return aka;
        }

        void onDestroy() {
            if (c.DEBUG) {
                Log.i("SwanAppLoadingView", "onDestroy: ");
            }
            com.baidu.swan.apps.runtime.d.azE().w(this.bRG);
        }

        a aGf() {
            this.ddX = true;
            return this;
        }

        @Override // java.lang.Runnable
        public void run() {
            gj(true);
        }

        public void gj(boolean z) {
            if (c.DEBUG) {
                Log.i("SwanAppLoadingView", "ViewStarter exec : post = " + z + " trace = " + (z ? "post" : Log.getStackTraceString(new Exception())));
            }
            this.ddY = true;
            c.this.r(this.ddV, this.ddX);
        }
    }
}
