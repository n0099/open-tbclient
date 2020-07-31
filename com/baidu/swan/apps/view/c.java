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
import com.baidu.swan.apps.aq.ai;
import com.baidu.swan.apps.aq.al;
import com.baidu.swan.apps.aq.aq;
import com.baidu.swan.apps.aq.s;
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
import java.text.DecimalFormat;
import java.text.NumberFormat;
import kotlin.l;
/* loaded from: classes7.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static Boolean cUP = null;
    private static View cUu;
    private static View cUv;
    private ImageView cUA;
    public RelativeLayout cUB;
    private com.baidu.swan.apps.d.a cUC;
    private SwanAppActivity cUD;
    private View cUE;
    private SwanLoadingTipsView cUF;
    private com.baidu.swan.games.loading.a cUG;
    private TextView cUH;
    private ValueAnimator cUI;
    private boolean cUJ = false;
    private float cUK = 0.0f;
    private float cUL = 0.0f;
    private float cUM = 0.0f;
    private long cUN = 0;
    private a cUO = null;
    private String cUQ = "";
    public View cUw;
    public TextView cUx;
    public ImageView cUy;
    public ImageView cUz;
    public SwanAppRoundedImageView caJ;
    public BdBaseImageView caK;
    public TextView caL;
    private View mRightMenu;
    private ImageView mRightMenuImageView;

    public c(SwanAppActivity swanAppActivity) {
        if (!com.baidu.swan.apps.performance.b.b.aoo()) {
            DecimalFormat.getPercentInstance();
        }
        this.cUD = swanAppActivity;
    }

    public static void cK(final Context context) {
        al.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.view.c.1
            @Override // java.lang.Runnable
            public void run() {
                c.cL(context);
            }
        }, 5000L);
    }

    public static void cL(Context context) {
        if (cUu == null) {
            cUu = m(context, false);
        }
        if (cUv == null) {
            cUv = m(context, true);
        }
        if (DEBUG) {
            Log.i("SwanAppLoadingView", "obtainPreloadContainer:  App=" + cUu + " Game=" + cUv);
        }
    }

    public static void axK() {
        cUu = null;
        cUv = null;
    }

    private View l(Context context, boolean z) {
        View view = z ? cUv : cUu;
        if (z) {
            cUv = null;
        } else {
            cUu = null;
        }
        boolean z2 = (view == null || view.isAttachedToWindow()) ? false : true;
        if (z2) {
            cK(context);
        }
        if (!z2) {
            view = m(context, z);
        }
        if (DEBUG) {
            Log.i("SwanAppLoadingView", "obtainPreloadContainer:  isLegalContainer= " + z2 + " game=" + z + " container=" + view);
        }
        return view;
    }

    private static View m(Context context, boolean z) {
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
        String ajz = com.baidu.swan.apps.runtime.d.arr().arn().arz().ajz();
        boolean z4 = this.cUO == null || (this.cUO.cUS ^ z) || TextUtils.isEmpty(ajz) || !TextUtils.equals(ajz, this.cUO.cUT);
        if (DEBUG) {
            Log.i("SwanAppLoadingView", "showSwanAppStartView: newLaunchId = " + ajz + " newIsGameLoading = " + z + " reCreateStarter = " + z4 + " mViewStarter = " + this.cUO);
        }
        Handler mainHandler = com.baidu.swan.apps.runtime.d.getMainHandler();
        if (this.cUO != null) {
            if (DEBUG) {
                Log.i("SwanAppLoadingView", "showSwanAppStartView: oldLaunchId = " + this.cUO.cUT + " oldIsGameLoading = " + this.cUO.cUS);
            }
            mainHandler.removeCallbacks(this.cUO);
        }
        if (z4) {
            this.cUO = new a(ajz, z);
        }
        if (this.cUO != null) {
            if (aVar == null || !aVar.getBoolean(" event_params_pkg_update", false)) {
                z3 = false;
            }
            if (this.cUO.cUV) {
                if (DEBUG) {
                    Log.i("SwanAppLoadingView", "showSwanAppStartView: return by executing pkgUpdating = " + z3 + " trace = " + Log.getStackTraceString(new Exception()));
                }
                if (z3) {
                    p(z, z3);
                    return;
                }
                return;
            }
            if (z3) {
                this.cUO.axX();
            }
            if (z2) {
                this.cUO.fQ(false);
                return;
            }
            if (DEBUG) {
                Log.i("SwanAppLoadingView", "showSwanAppStartView: post starter trace = " + Log.getStackTraceString(new Throwable()));
            }
            mainHandler.post(this.cUO);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(boolean z, boolean z2) {
        synchronized (c.class) {
            if (this.cUC == null) {
                this.cUC = new com.baidu.swan.apps.d.a();
            }
            this.cUw = l(this.cUD, z);
            if (!z) {
                this.cUw.setPadding(0, com.baidu.swan.apps.res.widget.a.SUPPORT_IMMERSION ? ai.getStatusBarHeight() : 0, 0, 0);
            } else {
                axL();
            }
            this.cUH = (TextView) this.cUw.findViewById(a.f.aiapps_loading_progress);
            b.a arz = com.baidu.swan.apps.runtime.d.arr().arn().arz();
            PMSAppInfo ajw = arz.ajw();
            q(z, z2);
            this.cUD.RX().at(this.cUw);
            this.cUJ = true;
            this.cUx = (TextView) this.cUw.findViewById(a.f.aiapps_title);
            this.caJ = (SwanAppRoundedImageView) this.cUw.findViewById(a.f.aiapps_icon);
            this.caK = (BdBaseImageView) this.cUw.findViewById(a.f.aiapps_label_bg);
            this.caL = (TextView) this.cUw.findViewById(a.f.aiapps_label_tv);
            this.cUB = (RelativeLayout) this.cUw.findViewById(a.f.aiapps_icon_rl);
            hl(arz.aee());
            qS(arz.getIconUrl());
            il(arz.getType());
            this.cUy = (ImageView) this.cUw.findViewById(a.f.light_print);
            this.cUz = (ImageView) this.cUw.findViewById(a.f.dark_print);
            this.mRightMenuImageView = (ImageView) this.cUw.findViewById(a.f.titlebar_right_menu_img);
            this.cUA = (ImageView) this.cUw.findViewById(a.f.titlebar_right_menu_exit);
            this.mRightMenu = this.cUw.findViewById(a.f.titlebar_right_menu);
            if (z) {
                this.mRightMenuImageView.setClickable(true);
                this.mRightMenuImageView.setImageResource(a.e.aiapps_action_bar_single_menu_white_selector);
                this.cUA.setImageResource(a.e.aiapps_action_bar_exit_white_selector);
                this.mRightMenu.setBackgroundResource(a.e.aiapps_action_bar_right_menu_bg_solid);
                this.cUE = this.cUw.findViewById(a.f.titlebar_right_menu_line);
                this.cUE.setBackgroundResource(a.c.aiapps_action_bar_menu_line_white);
            } else {
                this.mRightMenuImageView.setImageResource(a.e.aiapps_action_bar_menu_black_selector);
                this.cUA.setImageResource(a.e.aiapps_action_bar_exit_black_selector);
                this.mRightMenu.setBackgroundResource(a.e.aiapps_action_bar_right_menu_bg);
            }
            int i = ajw == null ? PMSConstants.PayProtected.NO_PAY_PROTECTED.type : ajw.payProtected;
            if (!z && al.axe() && i == PMSConstants.PayProtected.PAY_PROTECTED.type) {
                ((RelativeLayout) this.cUw.findViewById(a.f.guarantee_plan_rl)).setVisibility(0);
            }
            this.cUz.setAlpha(0.0f);
            this.cUC.g(this.cUD);
            axN();
        }
    }

    private void axL() {
        this.cUF = (SwanLoadingTipsView) this.cUw.findViewById(a.f.aigames_loading_game_tips);
        this.cUF.setTipsAnimationFinishCallback(new kotlin.jvm.a.a<l>() { // from class: com.baidu.swan.apps.view.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.a.a
            /* renamed from: axR */
            public l invoke() {
                c.this.axM();
                return null;
            }
        });
        this.cUG = new com.baidu.swan.games.loading.a();
        this.cUw.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.swan.apps.view.c.3
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                c.this.axM();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axM() {
        if (this.cUF != null && this.cUG != null) {
            this.cUF.tl(this.cUG.aFH());
        }
    }

    private void axN() {
        this.cUA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.view.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.cUD != null && !c.this.cUD.isFinishing()) {
                    HybridUbcFlow anY = com.baidu.swan.apps.performance.i.anY();
                    if (anY != null) {
                        anY.bH("exitType", String.valueOf(3));
                        anY.r("value", "cancel");
                        anY.anD();
                    }
                    c.this.cUD.moveTaskToBack(true);
                    aq.axo().ig(2);
                    c.this.axO();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axO() {
        Bundle ajl;
        b.a Se = this.cUD.Se();
        if (Se != null && (ajl = Se.ajl()) != null) {
            long j = ajl.getLong("page_display_flag_for_statistic");
            ajl.remove("page_display_flag_for_statistic");
            if (j > 0) {
                String valueOf = String.valueOf(System.currentTimeMillis() - Se.getLong("launch_time", 0L));
                f fVar = new f();
                fVar.mType = Config.LAUNCH;
                fVar.mValue = "realcancel";
                fVar.cOH = valueOf;
                fVar.v(TiebaInitialize.LogFields.REASON, "close");
                if (Se.getAppFrameType() == 1) {
                    fVar.v("errorList", com.baidu.swan.games.v.b.aGw().aGx());
                }
                this.cUD.a(fVar);
                e.a(Se);
            }
        }
    }

    private void il(int i) {
        ai.a(this.caK, this.caL, String.valueOf(i));
    }

    public void im(final int i) {
        Handler mainHandler = com.baidu.swan.apps.runtime.d.getMainHandler();
        if (this.cUO != null) {
            mainHandler.removeCallbacks(this.cUO);
            this.cUO.onDestroy();
            this.cUO = null;
        }
        mainHandler.post(new Runnable() { // from class: com.baidu.swan.apps.view.c.5
            @Override // java.lang.Runnable
            public void run() {
                synchronized (c.class) {
                    com.baidu.swan.apps.performance.i.anX().f(new UbcFlowEvent("first_anim_end"));
                    com.baidu.swan.apps.al.a.atW().pf("first_anim_end");
                    if (c.this.cUC != null) {
                        c.this.cUC.a(c.this.cUD, i);
                    }
                    c.this.cUJ = false;
                }
            }
        });
    }

    public void VA() {
        if (DEBUG) {
            Log.i("SwanAppLoadingView", "stopAnimations: " + Log.getStackTraceString(new Exception()));
        }
        Handler mainHandler = com.baidu.swan.apps.runtime.d.getMainHandler();
        if (this.cUO != null) {
            mainHandler.removeCallbacks(this.cUO);
            this.cUO.onDestroy();
            this.cUO = null;
        }
        synchronized (c.class) {
            if (this.cUC != null) {
                this.cUC.VA();
            }
            if (this.cUF != null) {
                this.cUF.doDestroy();
                this.cUF = null;
            }
            if (this.cUH != null) {
                this.cUH.setVisibility(8);
                this.cUH = null;
                this.cUQ = "";
                this.cUL = 0.0f;
                this.cUK = 0.0f;
                this.cUM = 0.0f;
            }
            if (this.cUI != null) {
                this.cUI.removeAllUpdateListeners();
                this.cUI.cancel();
                this.cUI = null;
            }
            this.cUJ = false;
            if (this.cUO != null) {
                this.cUO.onDestroy();
                this.cUO = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(Bitmap bitmap) {
        if (bitmap != null && this.caJ != null) {
            this.caJ.setImageBitmap(bitmap);
        }
    }

    public void H(float f) {
        if (DEBUG) {
            Log.i("SwanAppLoadingView", "onDownloadProgressUpdate: " + f + " view: " + this.cUH);
        }
        if (this.cUH != null) {
            float f2 = f >= 0.0f ? f : 0.0f;
            this.cUK = f2 <= 1.0f ? f2 : 1.0f;
            axP();
            if (this.cUN == 0) {
                this.cUN = System.currentTimeMillis();
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.cUN > 2000) {
                com.baidu.swan.apps.core.d.log("loading进度更新间隔大于2秒，检查弱网");
                com.baidu.swan.apps.core.d.YX();
            }
            this.cUN = currentTimeMillis;
        }
    }

    private void p(boolean z, boolean z2) {
        if (z) {
            this.cUQ = "";
        } else {
            this.cUQ = this.cUH.getContext().getString(z2 ? a.h.swan_loading_view_tag_updating : a.h.swan_loading_view_tag_loading);
        }
    }

    public void q(boolean z, boolean z2) {
        if (this.cUH != null) {
            if (this.cUI != null) {
                this.cUI.cancel();
                this.cUI.removeAllUpdateListeners();
            }
            p(z, z2);
            this.cUL = 0.0f;
            this.cUK = 0.0f;
            this.cUM = 0.0f;
            if (z) {
                axP();
                this.cUI = ValueAnimator.ofFloat(0.0f, 1.0f);
                this.cUI.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.view.c.6
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        if (floatValue > 0.9f || floatValue - c.this.cUL > 0.05d) {
                            c.this.cUL = floatValue;
                            c.this.axP();
                        }
                    }
                });
                this.cUI.setDuration(4000L);
                this.cUI.start();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axP() {
        if (this.cUH != null) {
            float q = q(this.cUL, this.cUK);
            I(q <= 1.0f ? q : 1.0f);
        }
    }

    private void I(float f) {
        String format;
        if (this.cUH != null && this.cUM <= f) {
            this.cUM = f;
            if (DEBUG) {
                Log.i("SwanAppLoadingView", "setProgressText: " + this.cUM);
            }
            if (com.baidu.swan.apps.performance.b.b.aoo()) {
                int i = (int) (1000.0f * f);
                int i2 = i / 10;
                format = ((i % 10 >= 5 ? 1 : 0) + i2) + "%";
            } else {
                format = NumberFormat.getPercentInstance().format(f);
            }
            String trim = this.cUQ.trim();
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(trim)) {
                sb.append(trim).append(" ");
            }
            sb.append(format);
            if (this.cUO != null && !this.cUO.cUS) {
                if (this.cUO.axU()) {
                    if (DEBUG) {
                        Log.i("SwanAppLoadingView", "setProgressText: checking update");
                    }
                    this.cUH.setText(this.cUH.getContext().getString(a.h.swanapp_swan_loading_runtime_check_updating));
                    this.cUH.setVisibility(0);
                } else if (this.cUO.axV() && this.cUM <= 0.0f) {
                    if (DEBUG) {
                        Log.i("SwanAppLoadingView", "setProgressText: checking update");
                    }
                    this.cUH.setText(this.cUH.getContext().getString(a.h.swanapp_swan_loading_runtime_check_updating));
                    this.cUH.setVisibility(0);
                } else if (this.cUO.axU()) {
                    if (DEBUG) {
                        Log.i("SwanAppLoadingView", "setProgressText: Framework loading");
                    }
                    this.cUH.setText(this.cUH.getContext().getString(a.h.swanapp_swan_loading_runtime_loading));
                    this.cUH.setVisibility(0);
                } else if (this.cUO.cUX && !this.cUO.axW()) {
                    if (DEBUG) {
                        Log.i("SwanAppLoadingView", "setProgressText: Framework loading");
                    }
                    this.cUH.setText(this.cUH.getContext().getString(a.h.swanapp_swan_loading_runtime_loading));
                    this.cUH.setVisibility(0);
                } else if (this.cUM >= 1.0f && !this.cUO.axW()) {
                    if (DEBUG) {
                        Log.i("SwanAppLoadingView", "setProgressText: Framework loading");
                    }
                    this.cUH.setText(this.cUH.getContext().getString(a.h.swanapp_swan_loading_runtime_loading));
                    this.cUH.setVisibility(0);
                } else {
                    this.cUH.setText(sb);
                }
            } else {
                this.cUH.setText(sb);
            }
            if (f > 0.0f) {
                this.cUH.setVisibility(0);
            }
        }
    }

    private float q(float f, float f2) {
        return ((1.0f - f) * f2) + f;
    }

    public void axQ() {
        if (this.cUH != null) {
            if (this.cUI != null) {
                this.cUI.removeAllUpdateListeners();
                this.cUI.cancel();
                this.cUI = null;
            }
            I(1.0f);
        }
    }

    public void qS(String str) {
        if (DEBUG) {
            Log.i("SwanAppLoadingView", "updateIcon: icon=" + str);
        }
        final String appId = com.baidu.swan.apps.runtime.d.arr().getAppId();
        if (this.cUJ) {
            this.caJ.setImageBitmap(al.a(str, "SwanAppLoadingView", true, new s.a() { // from class: com.baidu.swan.apps.view.c.7
                @Override // com.baidu.swan.apps.aq.s.a
                public void h(String str2, Bitmap bitmap) {
                    SwanAppActivity arp;
                    c RY;
                    if (bitmap != null && (arp = com.baidu.swan.apps.runtime.d.arr().arp()) != null && !arp.isDestroyed() && (RY = arp.RY()) != null && TextUtils.equals(appId, com.baidu.swan.apps.runtime.d.arr().getAppId())) {
                        RY.r(bitmap);
                    }
                }
            }));
        }
    }

    public void hl(String str) {
        if (this.cUJ && !TextUtils.isEmpty(str)) {
            this.cUx.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class a implements Runnable {
        final com.baidu.swan.apps.runtime.b bMk;
        final boolean cUS;
        final String cUT;
        private boolean cUX;
        boolean cUU = false;
        boolean cUV = false;
        private int cHD = -1;
        private int cUW = -1;

        a(String str, boolean z) {
            this.cUT = str;
            this.cUS = z;
            this.bMk = new com.baidu.swan.apps.runtime.b().a(new com.baidu.swan.apps.aq.e.b<i.a>() { // from class: com.baidu.swan.apps.view.c.a.7
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.aq.e.b
                /* renamed from: b */
                public void H(i.a aVar) {
                    if (c.DEBUG) {
                        Log.i("SwanAppLoadingView", "onCallback: EVENT_PMS_CHECK_START");
                    }
                    a.this.cHD = aVar.getInt("KEY_PKG_STATE", -1);
                    a.this.axS();
                }
            }, "event_pms_check_start").a(new com.baidu.swan.apps.aq.e.b<i.a>() { // from class: com.baidu.swan.apps.view.c.a.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.aq.e.b
                /* renamed from: b */
                public void H(i.a aVar) {
                    if (c.DEBUG) {
                        Log.i("SwanAppLoadingView", "onCallback: EVENT_PMS_CHECK_FINISH");
                    }
                    a.this.cHD = aVar.getInt("KEY_PKG_STATE", -1);
                    a.this.axS();
                }
            }, "event_pms_check_finish").a(new com.baidu.swan.apps.aq.e.b<i.a>() { // from class: com.baidu.swan.apps.view.c.a.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.aq.e.b
                /* renamed from: b */
                public void H(i.a aVar) {
                    if (c.DEBUG) {
                        Log.i("SwanAppLoadingView", "onCallback: EVENT_PKG_DOWNLOAD_START");
                    }
                }
            }, "event_pkg_download_start").a(new com.baidu.swan.apps.aq.e.b<i.a>() { // from class: com.baidu.swan.apps.view.c.a.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.aq.e.b
                /* renamed from: b */
                public void H(i.a aVar) {
                    if (c.DEBUG) {
                        Log.i("SwanAppLoadingView", "onCallback: EVENT_PKG_DOWNLOAD_FINISH");
                    }
                    a.this.cUX = true;
                    a.this.axS();
                }
            }, "event_pkg_download_finish").a(new com.baidu.swan.apps.aq.e.b<i.a>() { // from class: com.baidu.swan.apps.view.c.a.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.aq.e.b
                /* renamed from: b */
                public void H(i.a aVar) {
                    if (c.DEBUG) {
                        Log.i("SwanAppLoadingView", "onCallback: EVENT_PRELOAD_START");
                    }
                }
            }, "event_preload_start").a(new com.baidu.swan.apps.aq.e.b<i.a>() { // from class: com.baidu.swan.apps.view.c.a.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.aq.e.b
                /* renamed from: b */
                public void H(i.a aVar) {
                    if (c.DEBUG) {
                        Log.i("SwanAppLoadingView", "onCallback: EVENT_PRELOAD_ERROR");
                    }
                }
            }, "event_preload_error").a(new com.baidu.swan.apps.aq.e.b<i.a>() { // from class: com.baidu.swan.apps.view.c.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.aq.e.b
                /* renamed from: b */
                public void H(i.a aVar) {
                    if (c.DEBUG) {
                        Log.i("SwanAppLoadingView", "onCallback: EVENT_PRELOAD_FINISH");
                    }
                    a.this.cUW = aVar.getInt("KEY_PRELOAD_STATE");
                    a.this.axS();
                }
            }, "event_preload_finish");
            com.baidu.swan.apps.runtime.d.arr().o(this.bMk);
        }

        void axS() {
            boolean axU = axU();
            boolean axT = axT();
            boolean axW = axW();
            if (c.DEBUG) {
                Log.i("SwanAppLoadingView", "checkAndUpdateProgress: runtimeLoading " + axU);
                Log.i("SwanAppLoadingView", "checkAndUpdateProgress: checkingUpdate " + axT);
                Log.i("SwanAppLoadingView", "checkAndUpdateProgress: preloadFinish " + axW);
            }
            if (axU || axT || !axW) {
                c.this.axP();
            }
        }

        boolean axT() {
            boolean axV = axV();
            boolean axW = axW();
            boolean z = axV && axW;
            if (c.DEBUG) {
                Log.i("SwanAppLoadingView", "isCheckingUpdate: overMaxAge " + axV);
                Log.i("SwanAppLoadingView", "isCheckingUpdate: preloadFinish " + axW);
                Log.i("SwanAppLoadingView", "isCheckingUpdate: " + z);
            }
            return z;
        }

        boolean axU() {
            boolean z = this.cHD == 4;
            boolean axW = axW();
            if (c.DEBUG) {
                Log.i("SwanAppLoadingView", "isRuntimeLoading: isLocalPackage " + z);
                Log.i("SwanAppLoadingView", "isRuntimeLoading: preloadFinish " + axW);
            }
            return z && !axW;
        }

        boolean axV() {
            boolean z = true;
            if (this.cHD != 3 && this.cHD != 1) {
                z = false;
            }
            if (c.DEBUG) {
                Log.i("SwanAppLoadingView", "isOverMaxAge: isOverMaxAge " + z);
            }
            return z;
        }

        boolean axW() {
            boolean adC = com.baidu.swan.apps.core.turbo.d.adw().adC();
            if (c.DEBUG) {
                Log.i("SwanAppLoadingView", "isPreloadFinish: runtimeReady " + adC);
            }
            return adC;
        }

        void onDestroy() {
            if (c.DEBUG) {
                Log.i("SwanAppLoadingView", "onDestroy: ");
            }
            com.baidu.swan.apps.runtime.d.arr().p(this.bMk);
        }

        a axX() {
            this.cUU = true;
            return this;
        }

        @Override // java.lang.Runnable
        public void run() {
            fQ(true);
        }

        public void fQ(boolean z) {
            if (c.DEBUG) {
                Log.i("SwanAppLoadingView", "ViewStarter exec : post = " + z + " trace = " + (z ? "post" : Log.getStackTraceString(new Exception())));
            }
            this.cUV = true;
            c.this.o(this.cUS, this.cUU);
        }
    }
}
