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
    private static View ddA;
    private static View ddB;
    public SwanAppRoundedImageView cgG;
    public BdBaseImageView cgH;
    public TextView cgI;
    public View ddC;
    public TextView ddD;
    public ImageView ddE;
    public ImageView ddF;
    private ImageView ddG;
    public RelativeLayout ddH;
    private com.baidu.swan.apps.e.a ddI;
    private SwanAppActivity ddJ;
    private View ddK;
    private SwanLoadingTipsView ddL;
    private com.baidu.swan.games.loading.a ddM;
    private TextView ddN;
    private ValueAnimator ddO;
    private boolean ddP = false;
    private float ddQ = 0.0f;
    private float ddR = 0.0f;
    private float ddS = 0.0f;
    private long ddT = 0;
    private a ddU = null;
    private String ddW = "";
    private boolean ddX;
    private View mRightMenu;
    private ImageView mRightMenuImageView;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static Boolean ddV = null;

    public c(SwanAppActivity swanAppActivity) {
        this.ddX = com.baidu.swan.apps.runtime.d.azE().XP() != 1;
        this.ddJ = swanAppActivity;
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
        if (ddA == null) {
            ddA = n(context, false);
        }
        if (ddB == null) {
            ddB = n(context, true);
        }
        if (DEBUG) {
            Log.i("SwanAppLoadingView", "obtainPreloadContainer:  App=" + ddA + " Game=" + ddB);
        }
    }

    public static void aFS() {
        ddA = null;
        ddB = null;
    }

    private View m(Context context, boolean z) {
        View view = z ? ddB : ddA;
        if (z) {
            ddB = null;
        } else {
            ddA = null;
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
        this.ddX = com.baidu.swan.apps.runtime.d.azE().XP() != 1;
        this.ddT = 0L;
        String arg = com.baidu.swan.apps.runtime.d.azE().azA().azM().arg();
        boolean z4 = this.ddU == null || (this.ddU.ddZ ^ z) || TextUtils.isEmpty(arg) || !TextUtils.equals(arg, this.ddU.dea);
        if (DEBUG) {
            Log.i("SwanAppLoadingView", "showSwanAppStartView: newLaunchId = " + arg + " newIsGameLoading = " + z + " reCreateStarter = " + z4 + " mViewStarter = " + this.ddU);
        }
        Handler mainHandler = com.baidu.swan.apps.runtime.d.getMainHandler();
        if (this.ddU != null) {
            if (DEBUG) {
                Log.i("SwanAppLoadingView", "showSwanAppStartView: oldLaunchId = " + this.ddU.dea + " oldIsGameLoading = " + this.ddU.ddZ);
            }
            mainHandler.removeCallbacks(this.ddU);
        }
        if (z4) {
            this.ddU = new a(arg, z);
        }
        if (this.ddU != null) {
            if (aVar == null || !aVar.getBoolean(" event_params_pkg_update", false)) {
                z3 = false;
            }
            if (this.ddU.dec) {
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
                this.ddU.aGf();
            }
            if (z2) {
                this.ddU.gk(false);
                return;
            }
            if (DEBUG) {
                Log.i("SwanAppLoadingView", "showSwanAppStartView: post starter trace = " + Log.getStackTraceString(new Throwable()));
            }
            mainHandler.post(this.ddU);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(boolean z, boolean z2) {
        synchronized (c.class) {
            if (this.ddI == null) {
                this.ddI = new com.baidu.swan.apps.e.a();
            }
            this.ddC = m(this.ddJ, z);
            if (!z) {
                this.ddC.setPadding(0, com.baidu.swan.apps.res.widget.a.SUPPORT_IMMERSION ? ah.getStatusBarHeight() : 0, 0, 0);
            } else {
                aFT();
            }
            this.ddN = (TextView) this.ddC.findViewById(a.f.aiapps_loading_progress);
            b.a azM = com.baidu.swan.apps.runtime.d.azE().azA().azM();
            PMSAppInfo ard = azM.ard();
            t(z, z2);
            this.ddJ.XS().au(this.ddC);
            this.ddP = true;
            this.ddD = (TextView) this.ddC.findViewById(a.f.aiapps_title);
            this.cgG = (SwanAppRoundedImageView) this.ddC.findViewById(a.f.aiapps_icon);
            this.cgH = (BdBaseImageView) this.ddC.findViewById(a.f.aiapps_label_bg);
            this.cgI = (TextView) this.ddC.findViewById(a.f.aiapps_label_tv);
            this.ddH = (RelativeLayout) this.ddC.findViewById(a.f.aiapps_icon_rl);
            iH(azM.akO());
            sV(azM.getIconUrl());
            kt(azM.getType());
            this.ddE = (ImageView) this.ddC.findViewById(a.f.light_print);
            this.ddF = (ImageView) this.ddC.findViewById(a.f.dark_print);
            this.mRightMenuImageView = (ImageView) this.ddC.findViewById(a.f.titlebar_right_menu_img);
            this.ddG = (ImageView) this.ddC.findViewById(a.f.titlebar_right_menu_exit);
            this.mRightMenu = this.ddC.findViewById(a.f.titlebar_right_menu);
            if (z) {
                this.mRightMenuImageView.setClickable(true);
                this.mRightMenuImageView.setImageResource(a.e.aiapps_action_bar_single_menu_white_selector);
                this.ddG.setImageResource(a.e.aiapps_action_bar_exit_white_selector);
                this.mRightMenu.setBackgroundResource(a.e.aiapps_action_bar_right_menu_bg_solid);
                this.ddK = this.ddC.findViewById(a.f.titlebar_right_menu_line);
                this.ddK.setBackgroundResource(a.c.aiapps_action_bar_menu_line_white);
            } else {
                this.mRightMenuImageView.setImageResource(a.e.aiapps_action_bar_menu_black_selector);
                this.ddG.setImageResource(a.e.aiapps_action_bar_exit_black_selector);
                this.mRightMenu.setBackgroundResource(a.e.aiapps_action_bar_right_menu_bg);
            }
            int i = ard == null ? PMSConstants.PayProtected.NO_PAY_PROTECTED.type : ard.payProtected;
            if (!z && ak.aFn() && i == PMSConstants.PayProtected.PAY_PROTECTED.type) {
                ((RelativeLayout) this.ddC.findViewById(a.f.guarantee_plan_rl)).setVisibility(0);
            }
            this.ddF.setAlpha(0.0f);
            this.ddI.g(this.ddJ);
            aFV();
        }
    }

    private void aFT() {
        this.ddL = (SwanLoadingTipsView) this.ddC.findViewById(a.f.aigames_loading_game_tips);
        this.ddL.setTipsAnimationFinishCallback(new kotlin.jvm.a.a<l>() { // from class: com.baidu.swan.apps.view.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.a.a
            /* renamed from: aFZ */
            public l invoke() {
                c.this.aFU();
                return null;
            }
        });
        this.ddM = new com.baidu.swan.games.loading.a();
        this.ddC.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.swan.apps.view.c.3
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
        if (this.ddL != null && this.ddM != null) {
            this.ddL.vC(this.ddM.aOy());
        }
    }

    private void aFV() {
        this.ddG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.view.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.ddJ != null && !c.this.ddJ.isFinishing()) {
                    HybridUbcFlow avT = com.baidu.swan.apps.performance.i.avT();
                    if (avT != null) {
                        avT.bW("exitType", String.valueOf(3));
                        avT.r("value", "cancel");
                        avT.avy();
                    }
                    c.this.ddJ.moveTaskToBack(true);
                    ap.aFx().ko(2);
                    c.this.aFW();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFW() {
        Bundle aqS;
        b.a XZ = this.ddJ.XZ();
        if (XZ != null && (aqS = XZ.aqS()) != null) {
            long j = aqS.getLong("page_display_flag_for_statistic");
            aqS.remove("page_display_flag_for_statistic");
            if (j > 0) {
                String valueOf = String.valueOf(System.currentTimeMillis() - XZ.getLong("launch_time", 0L));
                f fVar = new f();
                fVar.mType = Config.LAUNCH;
                fVar.mValue = "realcancel";
                fVar.cXL = valueOf;
                fVar.u(TiebaInitialize.LogFields.REASON, "close");
                if (XZ.getAppFrameType() == 1) {
                    fVar.u("errorList", com.baidu.swan.games.v.b.aPn().aPo());
                }
                this.ddJ.a(fVar);
                e.b(XZ);
            }
        }
    }

    private void kt(int i) {
        ah.a(this.cgH, this.cgI, String.valueOf(i));
    }

    public void ku(final int i) {
        Handler mainHandler = com.baidu.swan.apps.runtime.d.getMainHandler();
        if (this.ddU != null) {
            mainHandler.removeCallbacks(this.ddU);
            this.ddU.onDestroy();
            this.ddU = null;
        }
        mainHandler.post(new Runnable() { // from class: com.baidu.swan.apps.view.c.5
            @Override // java.lang.Runnable
            public void run() {
                synchronized (c.class) {
                    com.baidu.swan.apps.performance.i.avS().f(new UbcFlowEvent("first_anim_end"));
                    com.baidu.swan.apps.ak.a.aCf().rf("first_anim_end");
                    if (c.this.ddI != null) {
                        c.this.ddI.a(c.this.ddJ, i);
                    }
                    c.this.ddP = false;
                }
            }
        });
    }

    public void abG() {
        if (DEBUG) {
            Log.i("SwanAppLoadingView", "stopAnimations: " + Log.getStackTraceString(new Exception()));
        }
        Handler mainHandler = com.baidu.swan.apps.runtime.d.getMainHandler();
        if (this.ddU != null) {
            mainHandler.removeCallbacks(this.ddU);
            this.ddU.onDestroy();
            this.ddU = null;
        }
        synchronized (c.class) {
            if (this.ddI != null) {
                this.ddI.abG();
            }
            if (this.ddL != null) {
                this.ddL.doDestroy();
                this.ddL = null;
            }
            if (this.ddN != null) {
                this.ddN.setVisibility(8);
                this.ddN = null;
                this.ddW = "";
                this.ddR = 0.0f;
                this.ddQ = 0.0f;
                this.ddS = 0.0f;
            }
            if (this.ddO != null) {
                this.ddO.removeAllUpdateListeners();
                this.ddO.cancel();
                this.ddO = null;
            }
            this.ddP = false;
            if (this.ddU != null) {
                this.ddU.onDestroy();
                this.ddU = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(Bitmap bitmap) {
        if (bitmap != null && this.cgG != null) {
            this.cgG.setImageBitmap(bitmap);
        }
    }

    public void L(float f) {
        if (DEBUG) {
            Log.i("SwanAppLoadingView", "onDownloadProgressUpdate: " + f + " view: " + this.ddN);
        }
        if (this.ddN != null) {
            float f2 = f >= 0.0f ? f : 0.0f;
            this.ddQ = f2 <= 1.0f ? f2 : 1.0f;
            aFX();
            if (this.ddX) {
                if (this.ddT == 0) {
                    this.ddT = System.currentTimeMillis();
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.ddT > 2000) {
                    com.baidu.swan.apps.core.f.bd("pms_downloadPkg", "包下载进度更新间隔大于2秒");
                    this.ddX = false;
                }
                this.ddT = currentTimeMillis;
            }
        }
    }

    private void s(boolean z, boolean z2) {
        if (z) {
            this.ddW = "";
        } else {
            this.ddW = this.ddN.getContext().getString(z2 ? a.h.swan_loading_view_tag_updating : a.h.swan_loading_view_tag_loading);
        }
    }

    public void t(boolean z, boolean z2) {
        if (this.ddN != null) {
            if (this.ddO != null) {
                this.ddO.cancel();
                this.ddO.removeAllUpdateListeners();
            }
            s(z, z2);
            this.ddR = 0.0f;
            this.ddQ = 0.0f;
            this.ddS = 0.0f;
            if (z) {
                aFX();
                this.ddO = ValueAnimator.ofFloat(0.0f, 1.0f);
                this.ddO.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.view.c.6
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        if (floatValue > 0.9f || floatValue - c.this.ddR > 0.05d) {
                            c.this.ddR = floatValue;
                            c.this.aFX();
                        }
                    }
                });
                this.ddO.setDuration(4000L);
                this.ddO.start();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFX() {
        if (this.ddN != null) {
            float u = u(this.ddR, this.ddQ);
            M(u <= 1.0f ? u : 1.0f);
        }
    }

    private void M(float f) {
        if (this.ddN != null && this.ddS <= f) {
            this.ddS = f;
            if (DEBUG) {
                Log.i("SwanAppLoadingView", "setProgressText: " + this.ddS);
            }
            int i = (int) (1000.0f * f);
            int i2 = i / 10;
            String str = ((i % 10 >= 5 ? 1 : 0) + i2) + "%";
            String trim = this.ddW.trim();
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(trim)) {
                sb.append(trim).append(" ");
            }
            sb.append(str);
            if (this.ddU != null && !this.ddU.ddZ) {
                if (this.ddU.aGc()) {
                    if (DEBUG) {
                        Log.i("SwanAppLoadingView", "setProgressText: checking update");
                    }
                    this.ddN.setText(this.ddN.getContext().getString(a.h.swanapp_swan_loading_runtime_check_updating));
                    this.ddN.setVisibility(0);
                } else if (this.ddU.aGd() && this.ddS <= 0.0f) {
                    if (DEBUG) {
                        Log.i("SwanAppLoadingView", "setProgressText: checking update");
                    }
                    this.ddN.setText(this.ddN.getContext().getString(a.h.swanapp_swan_loading_runtime_check_updating));
                    this.ddN.setVisibility(0);
                } else if (this.ddU.aGc()) {
                    if (DEBUG) {
                        Log.i("SwanAppLoadingView", "setProgressText: Framework loading");
                    }
                    this.ddN.setText(this.ddN.getContext().getString(a.h.swanapp_swan_loading_runtime_loading));
                    this.ddN.setVisibility(0);
                } else if (this.ddU.dee && !this.ddU.aGe()) {
                    if (DEBUG) {
                        Log.i("SwanAppLoadingView", "setProgressText: Framework loading");
                    }
                    this.ddN.setText(this.ddN.getContext().getString(a.h.swanapp_swan_loading_runtime_loading));
                    this.ddN.setVisibility(0);
                } else if (this.ddS >= 1.0f && !this.ddU.aGe()) {
                    if (DEBUG) {
                        Log.i("SwanAppLoadingView", "setProgressText: Framework loading");
                    }
                    this.ddN.setText(this.ddN.getContext().getString(a.h.swanapp_swan_loading_runtime_loading));
                    this.ddN.setVisibility(0);
                } else {
                    this.ddN.setText(sb);
                }
            } else {
                this.ddN.setText(sb);
            }
            if (f > 0.0f) {
                this.ddN.setVisibility(0);
            }
        }
    }

    private float u(float f, float f2) {
        return ((1.0f - f) * f2) + f;
    }

    public void aFY() {
        if (this.ddN != null) {
            if (this.ddO != null) {
                this.ddO.removeAllUpdateListeners();
                this.ddO.cancel();
                this.ddO = null;
            }
            M(1.0f);
        }
    }

    public void sV(String str) {
        if (DEBUG) {
            Log.i("SwanAppLoadingView", "updateIcon: icon=" + str);
        }
        final String appId = com.baidu.swan.apps.runtime.d.azE().getAppId();
        if (this.ddP) {
            this.cgG.setImageBitmap(ak.a(str, "SwanAppLoadingView", true, new s.a() { // from class: com.baidu.swan.apps.view.c.7
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

    public void iH(String str) {
        if (this.ddP && !TextUtils.isEmpty(str)) {
            this.ddD.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a implements Runnable {
        final com.baidu.swan.apps.runtime.b bRK;
        final boolean ddZ;
        final String dea;
        private boolean dee;
        boolean deb = false;
        boolean dec = false;
        private int cQG = -1;
        private int ded = -1;

        a(String str, boolean z) {
            this.dea = str;
            this.ddZ = z;
            this.bRK = new com.baidu.swan.apps.runtime.b().a(new com.baidu.swan.apps.ap.e.b<i.a>() { // from class: com.baidu.swan.apps.view.c.a.7
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ap.e.b
                /* renamed from: b */
                public void I(i.a aVar) {
                    if (c.DEBUG) {
                        Log.i("SwanAppLoadingView", "onCallback: EVENT_PMS_CHECK_START");
                    }
                    a.this.cQG = aVar.getInt("KEY_PKG_STATE", -1);
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
                    a.this.cQG = aVar.getInt("KEY_PKG_STATE", -1);
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
                    a.this.dee = true;
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
                    a.this.ded = aVar.getInt("KEY_PRELOAD_STATE");
                    a.this.aGa();
                }
            }, "event_preload_finish");
            com.baidu.swan.apps.runtime.d.azE().v(this.bRK);
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
            boolean z = this.cQG == 4;
            boolean aGe = aGe();
            if (c.DEBUG) {
                Log.i("SwanAppLoadingView", "isRuntimeLoading: isLocalPackage " + z);
                Log.i("SwanAppLoadingView", "isRuntimeLoading: preloadFinish " + aGe);
            }
            return z && !aGe;
        }

        boolean aGd() {
            boolean z = true;
            if (this.cQG != 3 && this.cQG != 1) {
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
            com.baidu.swan.apps.runtime.d.azE().w(this.bRK);
        }

        a aGf() {
            this.deb = true;
            return this;
        }

        @Override // java.lang.Runnable
        public void run() {
            gk(true);
        }

        public void gk(boolean z) {
            if (c.DEBUG) {
                Log.i("SwanAppLoadingView", "ViewStarter exec : post = " + z + " trace = " + (z ? "post" : Log.getStackTraceString(new Exception())));
            }
            this.dec = true;
            c.this.r(this.ddZ, this.deb);
        }
    }
}
