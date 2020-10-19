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
    private static View drI;
    private static View drJ;
    public SwanAppRoundedImageView cvb;
    public BdBaseImageView cvc;
    public TextView cvd;
    public View drK;
    public TextView drL;
    public ImageView drM;
    public ImageView drN;
    private ImageView drO;
    public RelativeLayout drP;
    private com.baidu.swan.apps.e.a drQ;
    private SwanAppActivity drR;
    private View drS;
    private SwanLoadingTipsView drT;
    private com.baidu.swan.games.loading.a drU;
    private TextView drV;
    private ValueAnimator drW;
    private boolean drX = false;
    private float drY = 0.0f;
    private float drZ = 0.0f;
    private float dsa = 0.0f;
    private long dsb = 0;
    private a dsc = null;
    private String dse = "";
    private boolean dsf;
    private View mRightMenu;
    private ImageView mRightMenuImageView;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static Boolean dsd = null;

    public c(SwanAppActivity swanAppActivity) {
        this.dsf = com.baidu.swan.apps.runtime.d.aCW().abk() != 1;
        this.drR = swanAppActivity;
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
        if (drI == null) {
            drI = o(context, false);
        }
        if (drJ == null) {
            drJ = o(context, true);
        }
        if (DEBUG) {
            Log.i("SwanAppLoadingView", "obtainPreloadContainer:  App=" + drI + " Game=" + drJ);
        }
    }

    public static void aJl() {
        drI = null;
        drJ = null;
    }

    private View n(Context context, boolean z) {
        View view = z ? drJ : drI;
        if (z) {
            drJ = null;
        } else {
            drI = null;
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
        this.dsf = com.baidu.swan.apps.runtime.d.aCW().abk() != 1;
        this.dsb = 0L;
        String auC = com.baidu.swan.apps.runtime.d.aCW().aCS().aDe().auC();
        boolean z4 = this.dsc == null || (this.dsc.dsh ^ z) || TextUtils.isEmpty(auC) || !TextUtils.equals(auC, this.dsc.dsi);
        if (DEBUG) {
            Log.i("SwanAppLoadingView", "showSwanAppStartView: newLaunchId = " + auC + " newIsGameLoading = " + z + " reCreateStarter = " + z4 + " mViewStarter = " + this.dsc);
        }
        Handler mainHandler = com.baidu.swan.apps.runtime.d.getMainHandler();
        if (this.dsc != null) {
            if (DEBUG) {
                Log.i("SwanAppLoadingView", "showSwanAppStartView: oldLaunchId = " + this.dsc.dsi + " oldIsGameLoading = " + this.dsc.dsh);
            }
            mainHandler.removeCallbacks(this.dsc);
        }
        if (z4) {
            this.dsc = new a(auC, z);
        }
        if (this.dsc != null) {
            if (aVar == null || !aVar.getBoolean(" event_params_pkg_update", false)) {
                z3 = false;
            }
            if (this.dsc.dsk) {
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
                this.dsc.aJy();
            }
            if (z2) {
                this.dsc.gE(false);
                return;
            }
            if (DEBUG) {
                Log.i("SwanAppLoadingView", "showSwanAppStartView: post starter trace = " + Log.getStackTraceString(new Throwable()));
            }
            mainHandler.post(this.dsc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(boolean z, boolean z2) {
        synchronized (c.class) {
            if (this.drQ == null) {
                this.drQ = new com.baidu.swan.apps.e.a();
            }
            this.drK = n(this.drR, z);
            if (!z) {
                this.drK.setPadding(0, com.baidu.swan.apps.res.widget.a.SUPPORT_IMMERSION ? ah.getStatusBarHeight() : 0, 0, 0);
            } else {
                aJm();
            }
            this.drV = (TextView) this.drK.findViewById(a.f.aiapps_loading_progress);
            b.a aDe = com.baidu.swan.apps.runtime.d.aCW().aCS().aDe();
            PMSAppInfo auz = aDe.auz();
            t(z, z2);
            this.drR.abn().ax(this.drK);
            this.drX = true;
            this.drL = (TextView) this.drK.findViewById(a.f.aiapps_title);
            this.cvb = (SwanAppRoundedImageView) this.drK.findViewById(a.f.aiapps_icon);
            this.cvc = (BdBaseImageView) this.drK.findViewById(a.f.aiapps_label_bg);
            this.cvd = (TextView) this.drK.findViewById(a.f.aiapps_label_tv);
            this.drP = (RelativeLayout) this.drK.findViewById(a.f.aiapps_icon_rl);
            jM(aDe.aoj());
            ua(aDe.getIconUrl());
            lb(aDe.getType());
            this.drM = (ImageView) this.drK.findViewById(a.f.light_print);
            this.drN = (ImageView) this.drK.findViewById(a.f.dark_print);
            this.mRightMenuImageView = (ImageView) this.drK.findViewById(a.f.titlebar_right_menu_img);
            this.drO = (ImageView) this.drK.findViewById(a.f.titlebar_right_menu_exit);
            this.mRightMenu = this.drK.findViewById(a.f.titlebar_right_menu);
            if (z) {
                this.mRightMenuImageView.setClickable(true);
                this.mRightMenuImageView.setImageResource(a.e.aiapps_action_bar_single_menu_white_selector);
                this.drO.setImageResource(a.e.aiapps_action_bar_exit_white_selector);
                this.mRightMenu.setBackgroundResource(a.e.aiapps_action_bar_right_menu_bg_solid);
                this.drS = this.drK.findViewById(a.f.titlebar_right_menu_line);
                this.drS.setBackgroundResource(a.c.aiapps_action_bar_menu_line_white);
            } else {
                this.mRightMenuImageView.setImageResource(a.e.aiapps_action_bar_menu_black_selector);
                this.drO.setImageResource(a.e.aiapps_action_bar_exit_black_selector);
                this.mRightMenu.setBackgroundResource(a.e.aiapps_action_bar_right_menu_bg);
            }
            int i = auz == null ? PMSConstants.PayProtected.NO_PAY_PROTECTED.type : auz.payProtected;
            if (!z && ak.aIG() && i == PMSConstants.PayProtected.PAY_PROTECTED.type) {
                ((RelativeLayout) this.drK.findViewById(a.f.guarantee_plan_rl)).setVisibility(0);
            }
            this.drN.setAlpha(0.0f);
            this.drQ.g(this.drR);
            aJo();
        }
    }

    private void aJm() {
        this.drT = (SwanLoadingTipsView) this.drK.findViewById(a.f.aigames_loading_game_tips);
        this.drT.setTipsAnimationFinishCallback(new kotlin.jvm.a.a<l>() { // from class: com.baidu.swan.apps.view.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.a.a
            /* renamed from: aJs */
            public l invoke() {
                c.this.aJn();
                return null;
            }
        });
        this.drU = new com.baidu.swan.games.loading.a();
        this.drK.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.swan.apps.view.c.3
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                c.this.aJn();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJn() {
        if (this.drT != null && this.drU != null) {
            this.drT.wH(this.drU.aRS());
        }
    }

    private void aJo() {
        this.drO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.view.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.drR != null && !c.this.drR.isFinishing()) {
                    HybridUbcFlow azn = com.baidu.swan.apps.performance.i.azn();
                    if (azn != null) {
                        azn.cb("exitType", String.valueOf(3));
                        azn.r("value", "cancel");
                        azn.ayS();
                    }
                    c.this.drR.moveTaskToBack(true);
                    ap.aIQ().kW(2);
                    c.this.aJp();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJp() {
        Bundle auo;
        b.a abu = this.drR.abu();
        if (abu != null && (auo = abu.auo()) != null) {
            long j = auo.getLong("page_display_flag_for_statistic");
            auo.remove("page_display_flag_for_statistic");
            if (j > 0) {
                String valueOf = String.valueOf(System.currentTimeMillis() - abu.getLong("launch_time", 0L));
                f fVar = new f();
                fVar.mType = Config.LAUNCH;
                fVar.mValue = "realcancel";
                fVar.dlV = valueOf;
                fVar.u(TiebaInitialize.LogFields.REASON, "close");
                if (abu.getAppFrameType() == 1) {
                    fVar.u("errorList", com.baidu.swan.games.v.b.aSH().aSI());
                }
                this.drR.a(fVar);
                e.b(abu);
            }
        }
    }

    private void lb(int i) {
        ah.a(this.cvc, this.cvd, String.valueOf(i));
    }

    public void lc(final int i) {
        Handler mainHandler = com.baidu.swan.apps.runtime.d.getMainHandler();
        if (this.dsc != null) {
            mainHandler.removeCallbacks(this.dsc);
            this.dsc.onDestroy();
            this.dsc = null;
        }
        mainHandler.post(new Runnable() { // from class: com.baidu.swan.apps.view.c.5
            @Override // java.lang.Runnable
            public void run() {
                synchronized (c.class) {
                    com.baidu.swan.apps.performance.i.azm().f(new UbcFlowEvent("first_anim_end"));
                    com.baidu.swan.apps.ak.a.aFy().sk("first_anim_end");
                    if (c.this.drQ != null) {
                        c.this.drQ.a(c.this.drR, i);
                    }
                    c.this.drX = false;
                }
            }
        });
    }

    public void afb() {
        if (DEBUG) {
            Log.i("SwanAppLoadingView", "stopAnimations: " + Log.getStackTraceString(new Exception()));
        }
        Handler mainHandler = com.baidu.swan.apps.runtime.d.getMainHandler();
        if (this.dsc != null) {
            mainHandler.removeCallbacks(this.dsc);
            this.dsc.onDestroy();
            this.dsc = null;
        }
        synchronized (c.class) {
            if (this.drQ != null) {
                this.drQ.afb();
            }
            if (this.drT != null) {
                this.drT.doDestroy();
                this.drT = null;
            }
            if (this.drV != null) {
                this.drV.setVisibility(8);
                this.drV = null;
                this.dse = "";
                this.drZ = 0.0f;
                this.drY = 0.0f;
                this.dsa = 0.0f;
            }
            if (this.drW != null) {
                this.drW.removeAllUpdateListeners();
                this.drW.cancel();
                this.drW = null;
            }
            this.drX = false;
            if (this.dsc != null) {
                this.dsc.onDestroy();
                this.dsc = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(Bitmap bitmap) {
        if (bitmap != null && this.cvb != null) {
            this.cvb.setImageBitmap(bitmap);
        }
    }

    public void N(float f) {
        if (DEBUG) {
            Log.i("SwanAppLoadingView", "onDownloadProgressUpdate: " + f + " view: " + this.drV);
        }
        if (this.drV != null) {
            float f2 = f >= 0.0f ? f : 0.0f;
            this.drY = f2 <= 1.0f ? f2 : 1.0f;
            aJq();
            if (this.dsf) {
                if (this.dsb == 0) {
                    this.dsb = System.currentTimeMillis();
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.dsb > 2000) {
                    com.baidu.swan.apps.core.f.bi("pms_downloadPkg", "包下载进度更新间隔大于2秒");
                    this.dsf = false;
                }
                this.dsb = currentTimeMillis;
            }
        }
    }

    private void s(boolean z, boolean z2) {
        if (z) {
            this.dse = "";
        } else {
            this.dse = this.drV.getContext().getString(z2 ? a.h.swan_loading_view_tag_updating : a.h.swan_loading_view_tag_loading);
        }
    }

    public void t(boolean z, boolean z2) {
        if (this.drV != null) {
            if (this.drW != null) {
                this.drW.cancel();
                this.drW.removeAllUpdateListeners();
            }
            s(z, z2);
            this.drZ = 0.0f;
            this.drY = 0.0f;
            this.dsa = 0.0f;
            if (z) {
                aJq();
                this.drW = ValueAnimator.ofFloat(0.0f, 1.0f);
                this.drW.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.view.c.6
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        if (floatValue > 0.9f || floatValue - c.this.drZ > 0.05d) {
                            c.this.drZ = floatValue;
                            c.this.aJq();
                        }
                    }
                });
                this.drW.setDuration(4000L);
                this.drW.start();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJq() {
        if (this.drV != null) {
            float v = v(this.drZ, this.drY);
            O(v <= 1.0f ? v : 1.0f);
        }
    }

    private void O(float f) {
        if (this.drV != null && this.dsa <= f) {
            this.dsa = f;
            if (DEBUG) {
                Log.i("SwanAppLoadingView", "setProgressText: " + this.dsa);
            }
            int i = (int) (1000.0f * f);
            int i2 = i / 10;
            String str = ((i % 10 >= 5 ? 1 : 0) + i2) + "%";
            String trim = this.dse.trim();
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(trim)) {
                sb.append(trim).append(" ");
            }
            sb.append(str);
            if (this.dsc != null && !this.dsc.dsh) {
                if (this.dsc.aJv()) {
                    if (DEBUG) {
                        Log.i("SwanAppLoadingView", "setProgressText: checking update");
                    }
                    this.drV.setText(this.drV.getContext().getString(a.h.swanapp_swan_loading_runtime_check_updating));
                    this.drV.setVisibility(0);
                } else if (this.dsc.aJw() && this.dsa <= 0.0f) {
                    if (DEBUG) {
                        Log.i("SwanAppLoadingView", "setProgressText: checking update");
                    }
                    this.drV.setText(this.drV.getContext().getString(a.h.swanapp_swan_loading_runtime_check_updating));
                    this.drV.setVisibility(0);
                } else if (this.dsc.aJv()) {
                    if (DEBUG) {
                        Log.i("SwanAppLoadingView", "setProgressText: Framework loading");
                    }
                    this.drV.setText(this.drV.getContext().getString(a.h.swanapp_swan_loading_runtime_loading));
                    this.drV.setVisibility(0);
                } else if (this.dsc.dsm && !this.dsc.aJx()) {
                    if (DEBUG) {
                        Log.i("SwanAppLoadingView", "setProgressText: Framework loading");
                    }
                    this.drV.setText(this.drV.getContext().getString(a.h.swanapp_swan_loading_runtime_loading));
                    this.drV.setVisibility(0);
                } else if (this.dsa >= 1.0f && !this.dsc.aJx()) {
                    if (DEBUG) {
                        Log.i("SwanAppLoadingView", "setProgressText: Framework loading");
                    }
                    this.drV.setText(this.drV.getContext().getString(a.h.swanapp_swan_loading_runtime_loading));
                    this.drV.setVisibility(0);
                } else {
                    this.drV.setText(sb);
                }
            } else {
                this.drV.setText(sb);
            }
            if (f > 0.0f) {
                this.drV.setVisibility(0);
            }
        }
    }

    private float v(float f, float f2) {
        return ((1.0f - f) * f2) + f;
    }

    public void aJr() {
        if (this.drV != null) {
            if (this.drW != null) {
                this.drW.removeAllUpdateListeners();
                this.drW.cancel();
                this.drW = null;
            }
            O(1.0f);
        }
    }

    public void ua(String str) {
        if (DEBUG) {
            Log.i("SwanAppLoadingView", "updateIcon: icon=" + str);
        }
        final String appId = com.baidu.swan.apps.runtime.d.aCW().getAppId();
        if (this.drX) {
            this.cvb.setImageBitmap(ak.a(str, "SwanAppLoadingView", true, new s.a() { // from class: com.baidu.swan.apps.view.c.7
                @Override // com.baidu.swan.apps.ap.s.a
                public void g(String str2, Bitmap bitmap) {
                    SwanAppActivity aCU;
                    c abo;
                    if (bitmap != null && (aCU = com.baidu.swan.apps.runtime.d.aCW().aCU()) != null && !aCU.isDestroyed() && (abo = aCU.abo()) != null && TextUtils.equals(appId, com.baidu.swan.apps.runtime.d.aCW().getAppId())) {
                        abo.r(bitmap);
                    }
                }
            }));
        }
    }

    public void jM(String str) {
        if (this.drX && !TextUtils.isEmpty(str)) {
            this.drL.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a implements Runnable {
        final com.baidu.swan.apps.runtime.b cfY;
        final boolean dsh;
        final String dsi;
        private boolean dsm;
        boolean dsj = false;
        boolean dsk = false;
        private int deO = -1;
        private int dsl = -1;

        a(String str, boolean z) {
            this.dsi = str;
            this.dsh = z;
            this.cfY = new com.baidu.swan.apps.runtime.b().a(new com.baidu.swan.apps.ap.e.b<i.a>() { // from class: com.baidu.swan.apps.view.c.a.7
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ap.e.b
                /* renamed from: b */
                public void M(i.a aVar) {
                    if (c.DEBUG) {
                        Log.i("SwanAppLoadingView", "onCallback: EVENT_PMS_CHECK_START");
                    }
                    a.this.deO = aVar.getInt("KEY_PKG_STATE", -1);
                    a.this.aJt();
                }
            }, "event_pms_check_start").a(new com.baidu.swan.apps.ap.e.b<i.a>() { // from class: com.baidu.swan.apps.view.c.a.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ap.e.b
                /* renamed from: b */
                public void M(i.a aVar) {
                    if (c.DEBUG) {
                        Log.i("SwanAppLoadingView", "onCallback: EVENT_PMS_CHECK_FINISH");
                    }
                    a.this.deO = aVar.getInt("KEY_PKG_STATE", -1);
                    a.this.aJt();
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
                    a.this.dsm = true;
                    a.this.aJt();
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
                    a.this.dsl = aVar.getInt("KEY_PRELOAD_STATE");
                    a.this.aJt();
                }
            }, "event_preload_finish");
            com.baidu.swan.apps.runtime.d.aCW().v(this.cfY);
        }

        void aJt() {
            boolean aJv = aJv();
            boolean aJu = aJu();
            boolean aJx = aJx();
            if (c.DEBUG) {
                Log.i("SwanAppLoadingView", "checkAndUpdateProgress: runtimeLoading " + aJv);
                Log.i("SwanAppLoadingView", "checkAndUpdateProgress: checkingUpdate " + aJu);
                Log.i("SwanAppLoadingView", "checkAndUpdateProgress: preloadFinish " + aJx);
            }
            if (aJv || aJu || !aJx) {
                c.this.aJq();
            }
        }

        boolean aJu() {
            boolean aJw = aJw();
            boolean aJx = aJx();
            boolean z = aJw && aJx;
            if (c.DEBUG) {
                Log.i("SwanAppLoadingView", "isCheckingUpdate: overMaxAge " + aJw);
                Log.i("SwanAppLoadingView", "isCheckingUpdate: preloadFinish " + aJx);
                Log.i("SwanAppLoadingView", "isCheckingUpdate: " + z);
            }
            return z;
        }

        boolean aJv() {
            boolean z = this.deO == 4;
            boolean aJx = aJx();
            if (c.DEBUG) {
                Log.i("SwanAppLoadingView", "isRuntimeLoading: isLocalPackage " + z);
                Log.i("SwanAppLoadingView", "isRuntimeLoading: preloadFinish " + aJx);
            }
            return z && !aJx;
        }

        boolean aJw() {
            boolean z = true;
            if (this.deO != 3 && this.deO != 1) {
                z = false;
            }
            if (c.DEBUG) {
                Log.i("SwanAppLoadingView", "isOverMaxAge: isOverMaxAge " + z);
            }
            return z;
        }

        boolean aJx() {
            boolean anv = com.baidu.swan.apps.core.turbo.d.ann().anv();
            if (c.DEBUG) {
                Log.i("SwanAppLoadingView", "isPreloadFinish: runtimeReady " + anv);
            }
            return anv;
        }

        void onDestroy() {
            if (c.DEBUG) {
                Log.i("SwanAppLoadingView", "onDestroy: ");
            }
            com.baidu.swan.apps.runtime.d.aCW().w(this.cfY);
        }

        a aJy() {
            this.dsj = true;
            return this;
        }

        @Override // java.lang.Runnable
        public void run() {
            gE(true);
        }

        public void gE(boolean z) {
            if (c.DEBUG) {
                Log.i("SwanAppLoadingView", "ViewStarter exec : post = " + z + " trace = " + (z ? "post" : Log.getStackTraceString(new Exception())));
            }
            this.dsk = true;
            c.this.r(this.dsh, this.dsj);
        }
    }
}
