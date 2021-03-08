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
    private static Boolean dTA = null;
    private static View dTd;
    private static View dTe;
    public SwanAppRoundedImageView cSw;
    public BdBaseImageView cSx;
    public TextView cSy;
    private boolean dTC;
    public View dTf;
    public TextView dTg;
    public ImageView dTh;
    public ImageView dTi;
    private ImageView dTj;
    private ImageView dTk;
    public RelativeLayout dTl;
    private View dTm;
    private com.baidu.swan.apps.e.a dTn;
    private SwanAppActivity dTo;
    private View dTp;
    private SwanLoadingTipsView dTq;
    private com.baidu.swan.games.loading.a dTr;
    private TextView dTs;
    private ValueAnimator dTt;
    private boolean dTu = false;
    private float dTv = 0.0f;
    private float dTw = 0.0f;
    private float dTx = 0.0f;
    private long dTy = 0;
    private a dTz = null;
    private String dTB = "";

    public c(SwanAppActivity swanAppActivity) {
        this.dTC = com.baidu.swan.apps.runtime.d.aIJ().getFrameType() != 1;
        this.dTo = swanAppActivity;
    }

    public static void dR(final Context context) {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.view.c.1
            @Override // java.lang.Runnable
            public void run() {
                c.dS(context);
            }
        }, 5000L);
    }

    public static void dS(Context context) {
        if (dTd == null) {
            dTd = s(context, false);
        }
        if (dTe == null) {
            dTe = s(context, true);
        }
        if (DEBUG) {
            Log.i("SwanAppLoadingView", "obtainPreloadContainer:  App=" + dTd + " Game=" + dTe);
        }
    }

    public static void aPb() {
        dTd = null;
        dTe = null;
    }

    private View r(Context context, boolean z) {
        View view = z ? dTe : dTd;
        if (z) {
            dTe = null;
        } else {
            dTd = null;
        }
        boolean z2 = (view == null || view.isAttachedToWindow()) ? false : true;
        if (z2) {
            dR(context);
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
        this.dTC = com.baidu.swan.apps.runtime.d.aIJ().getFrameType() != 1;
        this.dTy = 0L;
        String azw = com.baidu.swan.apps.runtime.d.aIJ().aIF().aIR().azw();
        boolean z4 = this.dTz == null || (this.dTz.dTE ^ z) || TextUtils.isEmpty(azw) || !TextUtils.equals(azw, this.dTz.dTF);
        if (DEBUG) {
            Log.i("SwanAppLoadingView", "showSwanAppStartView: newLaunchId = " + azw + " newIsGameLoading = " + z + " reCreateStarter = " + z4 + " mViewStarter = " + this.dTz);
        }
        Handler mainHandler = com.baidu.swan.apps.runtime.d.getMainHandler();
        if (this.dTz != null) {
            if (DEBUG) {
                Log.i("SwanAppLoadingView", "showSwanAppStartView: oldLaunchId = " + this.dTz.dTF + " oldIsGameLoading = " + this.dTz.dTE);
            }
            mainHandler.removeCallbacks(this.dTz);
        }
        if (z4) {
            this.dTz = new a(azw, z);
        }
        if (this.dTz != null) {
            if (aVar == null || !aVar.getBoolean(" event_params_pkg_update", false)) {
                z3 = false;
            }
            if (this.dTz.dTH) {
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
                this.dTz.aPo();
            }
            if (z2) {
                this.dTz.hI(false);
                return;
            }
            if (DEBUG) {
                Log.i("SwanAppLoadingView", "showSwanAppStartView: post starter trace = " + Log.getStackTraceString(new Throwable()));
            }
            mainHandler.post(this.dTz);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(boolean z, boolean z2) {
        synchronized (c.class) {
            if (this.dTn == null) {
                this.dTn = new com.baidu.swan.apps.e.a();
            }
            this.dTf = r(this.dTo, z);
            if (!z) {
                this.dTf.setPadding(0, com.baidu.swan.apps.res.widget.a.dCv ? ah.getStatusBarHeight() : 0, 0, 0);
            } else {
                aPc();
            }
            this.dTs = (TextView) this.dTf.findViewById(a.f.aiapps_loading_progress);
            b.a aIR = com.baidu.swan.apps.runtime.d.aIJ().aIF().aIR();
            PMSAppInfo azt = aIR.azt();
            u(z, z2);
            this.dTo.afV().aI(this.dTf);
            this.dTu = true;
            this.dTg = (TextView) this.dTf.findViewById(a.f.aiapps_title);
            this.cSw = (SwanAppRoundedImageView) this.dTf.findViewById(a.f.aiapps_icon);
            this.cSx = (BdBaseImageView) this.dTf.findViewById(a.f.aiapps_label_bg);
            this.cSy = (TextView) this.dTf.findViewById(a.f.aiapps_label_tv);
            this.dTl = (RelativeLayout) this.dTf.findViewById(a.f.aiapps_icon_rl);
            kc(aIR.atf());
            ux(aIR.getIconUrl());
            kv(aIR.getType());
            this.dTh = (ImageView) this.dTf.findViewById(a.f.light_print);
            this.dTi = (ImageView) this.dTf.findViewById(a.f.dark_print);
            this.dTj = (ImageView) this.dTf.findViewById(a.f.titlebar_right_menu_img);
            this.dTk = (ImageView) this.dTf.findViewById(a.f.titlebar_right_menu_exit);
            this.dTm = this.dTf.findViewById(a.f.titlebar_right_menu);
            if (z) {
                this.dTj.setClickable(true);
                this.dTj.setImageResource(a.e.aiapps_action_bar_single_menu_white_selector);
                this.dTk.setImageResource(a.e.aiapps_action_bar_exit_white_selector);
                this.dTm.setBackgroundResource(a.e.aiapps_action_bar_right_menu_bg_solid);
                this.dTp = this.dTf.findViewById(a.f.titlebar_right_menu_line);
                this.dTp.setBackgroundResource(a.c.aiapps_action_bar_menu_line_white);
            } else {
                this.dTj.setImageResource(a.e.aiapps_action_bar_menu_black_selector);
                this.dTk.setImageResource(a.e.aiapps_action_bar_exit_black_selector);
                this.dTm.setBackgroundResource(a.e.aiapps_action_bar_right_menu_bg);
            }
            int i = azt == null ? PMSConstants.PayProtected.NO_PAY_PROTECTED.type : azt.payProtected;
            if (!z && ak.aOs() && i == PMSConstants.PayProtected.PAY_PROTECTED.type) {
                ((RelativeLayout) this.dTf.findViewById(a.f.guarantee_plan_rl)).setVisibility(0);
            }
            this.dTi.setAlpha(0.0f);
            this.dTn.g(this.dTo);
            aPe();
        }
    }

    private void aPc() {
        this.dTq = (SwanLoadingTipsView) this.dTf.findViewById(a.f.aigames_loading_game_tips);
        this.dTq.setTipsAnimationFinishCallback(new kotlin.jvm.a.a<h>() { // from class: com.baidu.swan.apps.view.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.a.a
            /* renamed from: aPi */
            public h invoke() {
                c.this.aPd();
                return null;
            }
        });
        this.dTr = new com.baidu.swan.games.loading.a();
        this.dTf.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.swan.apps.view.c.3
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                c.this.aPd();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aPd() {
        if (this.dTq != null && this.dTr != null) {
            this.dTq.xe(this.dTr.aXz());
        }
    }

    private void aPe() {
        this.dTk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.view.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.dTo != null && !c.this.dTo.isFinishing()) {
                    HybridUbcFlow aEf = com.baidu.swan.apps.performance.i.aEf();
                    if (aEf != null) {
                        aEf.cg("exitType", String.valueOf(3));
                        aEf.p("value", "cancel");
                        aEf.aDM();
                    }
                    c.this.dTo.moveTaskToBack(true);
                    ap.aOD().ko(2);
                    c.this.aPf();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aPf() {
        Bundle azi;
        b.a agc = this.dTo.agc();
        if (agc != null && (azi = agc.azi()) != null) {
            long j = azi.getLong("page_display_flag_for_statistic");
            azi.remove("page_display_flag_for_statistic");
            if (j > 0) {
                String valueOf = String.valueOf(System.currentTimeMillis() - agc.getLong("launch_time", 0L));
                f fVar = new f();
                fVar.mType = Config.LAUNCH;
                fVar.mValue = "realcancel";
                fVar.dNe = valueOf;
                fVar.s(TiebaInitialize.LogFields.REASON, "close");
                if (agc.getAppFrameType() == 1) {
                    fVar.s("errorList", com.baidu.swan.games.v.b.aYo().aYp());
                }
                this.dTo.a(fVar);
                e.b(agc);
            }
        }
    }

    private void kv(int i) {
        ah.a(this.cSx, this.cSy, String.valueOf(i));
    }

    public void kw(final int i) {
        Handler mainHandler = com.baidu.swan.apps.runtime.d.getMainHandler();
        if (this.dTz != null) {
            mainHandler.removeCallbacks(this.dTz);
            this.dTz.onDestroy();
            this.dTz = null;
        }
        mainHandler.post(new Runnable() { // from class: com.baidu.swan.apps.view.c.5
            @Override // java.lang.Runnable
            public void run() {
                synchronized (c.class) {
                    com.baidu.swan.apps.performance.i.aEe().f(new UbcFlowEvent("first_anim_end"));
                    com.baidu.swan.apps.aj.a.aLl().sG("first_anim_end");
                    if (c.this.dTn != null) {
                        c.this.dTn.a(c.this.dTo, i);
                    }
                    c.this.dTu = false;
                }
            }
        });
    }

    public void ajN() {
        if (DEBUG) {
            Log.i("SwanAppLoadingView", "stopAnimations: " + Log.getStackTraceString(new Exception()));
        }
        Handler mainHandler = com.baidu.swan.apps.runtime.d.getMainHandler();
        if (this.dTz != null) {
            mainHandler.removeCallbacks(this.dTz);
            this.dTz.onDestroy();
            this.dTz = null;
        }
        synchronized (c.class) {
            if (this.dTn != null) {
                this.dTn.ajN();
            }
            if (this.dTq != null) {
                this.dTq.doDestroy();
                this.dTq = null;
            }
            if (this.dTs != null) {
                this.dTs.setVisibility(8);
                this.dTs = null;
                this.dTB = "";
                this.dTw = 0.0f;
                this.dTv = 0.0f;
                this.dTx = 0.0f;
            }
            if (this.dTt != null) {
                this.dTt.removeAllUpdateListeners();
                this.dTt.cancel();
                this.dTt = null;
            }
            this.dTu = false;
            if (this.dTz != null) {
                this.dTz.onDestroy();
                this.dTz = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(Bitmap bitmap) {
        if (bitmap != null && this.cSw != null) {
            this.cSw.setImageBitmap(bitmap);
        }
    }

    public void X(float f) {
        if (DEBUG) {
            Log.i("SwanAppLoadingView", "onDownloadProgressUpdate: " + f + " view: " + this.dTs);
        }
        if (this.dTs != null) {
            float f2 = f >= 0.0f ? f : 0.0f;
            this.dTv = f2 <= 1.0f ? f2 : 1.0f;
            aPg();
            if (this.dTC) {
                if (this.dTy == 0) {
                    this.dTy = System.currentTimeMillis();
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.dTy > 2000) {
                    com.baidu.swan.apps.core.f.bn("pms_downloadPkg", "包下载进度更新间隔大于2秒");
                    this.dTC = false;
                }
                this.dTy = currentTimeMillis;
            }
        }
    }

    private void t(boolean z, boolean z2) {
        if (z) {
            this.dTB = "";
        } else {
            this.dTB = this.dTs.getContext().getString(z2 ? a.h.swan_loading_view_tag_updating : a.h.swan_loading_view_tag_loading);
        }
    }

    public void u(boolean z, boolean z2) {
        if (this.dTs != null) {
            if (this.dTt != null) {
                this.dTt.cancel();
                this.dTt.removeAllUpdateListeners();
            }
            t(z, z2);
            this.dTw = 0.0f;
            this.dTv = 0.0f;
            this.dTx = 0.0f;
            if (z) {
                aPg();
                this.dTt = ValueAnimator.ofFloat(0.0f, 1.0f);
                this.dTt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.view.c.6
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        if (floatValue > 0.9f || floatValue - c.this.dTw > 0.05d) {
                            c.this.dTw = floatValue;
                            c.this.aPg();
                        }
                    }
                });
                this.dTt.setDuration(4000L);
                this.dTt.start();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aPg() {
        if (this.dTs != null) {
            float w = w(this.dTw, this.dTv);
            Y(w <= 1.0f ? w : 1.0f);
        }
    }

    private void Y(float f) {
        if (this.dTs != null && this.dTx <= f) {
            this.dTx = f;
            if (DEBUG) {
                Log.i("SwanAppLoadingView", "setProgressText: " + this.dTx);
            }
            int i = (int) (1000.0f * f);
            int i2 = i / 10;
            String str = ((i % 10 >= 5 ? 1 : 0) + i2) + "%";
            String trim = this.dTB.trim();
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(trim)) {
                sb.append(trim).append(" ");
            }
            sb.append(str);
            if (this.dTz != null && !this.dTz.dTE) {
                if (this.dTz.aPl()) {
                    if (DEBUG) {
                        Log.i("SwanAppLoadingView", "setProgressText: checking update");
                    }
                    this.dTs.setText(this.dTs.getContext().getString(a.h.swanapp_swan_loading_runtime_check_updating));
                    this.dTs.setVisibility(0);
                } else if (this.dTz.aPm() && this.dTx <= 0.0f) {
                    if (DEBUG) {
                        Log.i("SwanAppLoadingView", "setProgressText: checking update");
                    }
                    this.dTs.setText(this.dTs.getContext().getString(a.h.swanapp_swan_loading_runtime_check_updating));
                    this.dTs.setVisibility(0);
                } else if (this.dTz.aPl()) {
                    if (DEBUG) {
                        Log.i("SwanAppLoadingView", "setProgressText: Framework loading");
                    }
                    this.dTs.setText(this.dTs.getContext().getString(a.h.swanapp_swan_loading_runtime_loading));
                    this.dTs.setVisibility(0);
                } else if (this.dTz.dTJ && !this.dTz.aPn()) {
                    if (DEBUG) {
                        Log.i("SwanAppLoadingView", "setProgressText: Framework loading");
                    }
                    this.dTs.setText(this.dTs.getContext().getString(a.h.swanapp_swan_loading_runtime_loading));
                    this.dTs.setVisibility(0);
                } else if (this.dTx >= 1.0f && !this.dTz.aPn()) {
                    if (DEBUG) {
                        Log.i("SwanAppLoadingView", "setProgressText: Framework loading");
                    }
                    this.dTs.setText(this.dTs.getContext().getString(a.h.swanapp_swan_loading_runtime_loading));
                    this.dTs.setVisibility(0);
                } else {
                    this.dTs.setText(sb);
                }
            } else {
                this.dTs.setText(sb);
            }
            if (f > 0.0f) {
                this.dTs.setVisibility(0);
            }
        }
    }

    private float w(float f, float f2) {
        return ((1.0f - f) * f2) + f;
    }

    public void aPh() {
        if (this.dTs != null) {
            if (this.dTt != null) {
                this.dTt.removeAllUpdateListeners();
                this.dTt.cancel();
                this.dTt = null;
            }
            Y(1.0f);
        }
    }

    public void ux(String str) {
        if (DEBUG) {
            Log.i("SwanAppLoadingView", "updateIcon: icon=" + str);
        }
        final String appId = com.baidu.swan.apps.runtime.d.aIJ().getAppId();
        if (this.dTu) {
            this.cSw.setImageBitmap(ak.a(str, "SwanAppLoadingView", true, new s.a() { // from class: com.baidu.swan.apps.view.c.7
                @Override // com.baidu.swan.apps.ao.s.a
                public void f(String str2, Bitmap bitmap) {
                    SwanAppActivity aIH;
                    c afW;
                    if (bitmap != null && (aIH = com.baidu.swan.apps.runtime.d.aIJ().aIH()) != null && !aIH.isDestroyed() && (afW = aIH.afW()) != null && TextUtils.equals(appId, com.baidu.swan.apps.runtime.d.aIJ().getAppId())) {
                        afW.r(bitmap);
                    }
                }
            }));
        }
    }

    public void kc(String str) {
        if (this.dTu && !TextUtils.isEmpty(str)) {
            this.dTg.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a implements Runnable {
        final com.baidu.swan.apps.runtime.b cDD;
        final boolean dTE;
        final String dTF;
        private boolean dTJ;
        boolean dTG = false;
        boolean dTH = false;
        private int dGb = -1;
        private int dTI = -1;

        a(String str, boolean z) {
            this.dTF = str;
            this.dTE = z;
            this.cDD = new com.baidu.swan.apps.runtime.b().a(new com.baidu.swan.apps.ao.e.b<i.a>() { // from class: com.baidu.swan.apps.view.c.a.7
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ao.e.b
                /* renamed from: b */
                public void N(i.a aVar) {
                    if (c.DEBUG) {
                        Log.i("SwanAppLoadingView", "onCallback: EVENT_PMS_CHECK_START");
                    }
                    a.this.dGb = aVar.getInt("KEY_PKG_STATE", -1);
                    a.this.aPj();
                }
            }, "event_pms_check_start").a(new com.baidu.swan.apps.ao.e.b<i.a>() { // from class: com.baidu.swan.apps.view.c.a.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ao.e.b
                /* renamed from: b */
                public void N(i.a aVar) {
                    if (c.DEBUG) {
                        Log.i("SwanAppLoadingView", "onCallback: EVENT_PMS_CHECK_FINISH");
                    }
                    a.this.dGb = aVar.getInt("KEY_PKG_STATE", -1);
                    a.this.aPj();
                }
            }, "event_pms_check_finish").a(new com.baidu.swan.apps.ao.e.b<i.a>() { // from class: com.baidu.swan.apps.view.c.a.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ao.e.b
                /* renamed from: b */
                public void N(i.a aVar) {
                    if (c.DEBUG) {
                        Log.i("SwanAppLoadingView", "onCallback: EVENT_PKG_DOWNLOAD_START");
                    }
                }
            }, "event_pkg_download_start").a(new com.baidu.swan.apps.ao.e.b<i.a>() { // from class: com.baidu.swan.apps.view.c.a.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ao.e.b
                /* renamed from: b */
                public void N(i.a aVar) {
                    if (c.DEBUG) {
                        Log.i("SwanAppLoadingView", "onCallback: EVENT_PKG_DOWNLOAD_FINISH");
                    }
                    a.this.dTJ = true;
                    a.this.aPj();
                }
            }, "event_pkg_download_finish").a(new com.baidu.swan.apps.ao.e.b<i.a>() { // from class: com.baidu.swan.apps.view.c.a.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ao.e.b
                /* renamed from: b */
                public void N(i.a aVar) {
                    if (c.DEBUG) {
                        Log.i("SwanAppLoadingView", "onCallback: EVENT_PRELOAD_START");
                    }
                }
            }, "event_preload_start").a(new com.baidu.swan.apps.ao.e.b<i.a>() { // from class: com.baidu.swan.apps.view.c.a.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ao.e.b
                /* renamed from: b */
                public void N(i.a aVar) {
                    if (c.DEBUG) {
                        Log.i("SwanAppLoadingView", "onCallback: EVENT_PRELOAD_ERROR");
                    }
                }
            }, "event_preload_error").a(new com.baidu.swan.apps.ao.e.b<i.a>() { // from class: com.baidu.swan.apps.view.c.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ao.e.b
                /* renamed from: b */
                public void N(i.a aVar) {
                    if (c.DEBUG) {
                        Log.i("SwanAppLoadingView", "onCallback: EVENT_PRELOAD_FINISH");
                    }
                    a.this.dTI = aVar.getInt("KEY_PRELOAD_STATE");
                    a.this.aPj();
                }
            }, "event_preload_finish");
            com.baidu.swan.apps.runtime.d.aIJ().v(this.cDD);
        }

        void aPj() {
            boolean aPl = aPl();
            boolean aPk = aPk();
            boolean aPn = aPn();
            if (c.DEBUG) {
                Log.i("SwanAppLoadingView", "checkAndUpdateProgress: runtimeLoading " + aPl);
                Log.i("SwanAppLoadingView", "checkAndUpdateProgress: checkingUpdate " + aPk);
                Log.i("SwanAppLoadingView", "checkAndUpdateProgress: preloadFinish " + aPn);
            }
            if (aPl || aPk || !aPn) {
                c.this.aPg();
            }
        }

        boolean aPk() {
            boolean aPm = aPm();
            boolean aPn = aPn();
            boolean z = aPm && aPn;
            if (c.DEBUG) {
                Log.i("SwanAppLoadingView", "isCheckingUpdate: overMaxAge " + aPm);
                Log.i("SwanAppLoadingView", "isCheckingUpdate: preloadFinish " + aPn);
                Log.i("SwanAppLoadingView", "isCheckingUpdate: " + z);
            }
            return z;
        }

        boolean aPl() {
            boolean z = this.dGb == 4;
            boolean aPn = aPn();
            if (c.DEBUG) {
                Log.i("SwanAppLoadingView", "isRuntimeLoading: isLocalPackage " + z);
                Log.i("SwanAppLoadingView", "isRuntimeLoading: preloadFinish " + aPn);
            }
            return z && !aPn;
        }

        boolean aPm() {
            boolean z = true;
            if (this.dGb != 3 && this.dGb != 1) {
                z = false;
            }
            if (c.DEBUG) {
                Log.i("SwanAppLoadingView", "isOverMaxAge: isOverMaxAge " + z);
            }
            return z;
        }

        boolean aPn() {
            boolean asq = com.baidu.swan.apps.core.turbo.d.ash().asq();
            if (c.DEBUG) {
                Log.i("SwanAppLoadingView", "isPreloadFinish: runtimeReady " + asq);
            }
            return asq;
        }

        void onDestroy() {
            if (c.DEBUG) {
                Log.i("SwanAppLoadingView", "onDestroy: ");
            }
            com.baidu.swan.apps.runtime.d.aIJ().w(this.cDD);
        }

        a aPo() {
            this.dTG = true;
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
            this.dTH = true;
            c.this.s(this.dTE, this.dTG);
        }
    }
}
