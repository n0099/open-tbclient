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
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static Boolean dAC = null;
    private static View dAh;
    private static View dAi;
    public SwanAppRoundedImageView cDx;
    public BdBaseImageView cDy;
    public TextView cDz;
    private boolean dAE;
    public View dAj;
    public TextView dAk;
    public ImageView dAl;
    public ImageView dAm;
    private ImageView dAn;
    public RelativeLayout dAo;
    private com.baidu.swan.apps.e.a dAp;
    private SwanAppActivity dAq;
    private View dAr;
    private SwanLoadingTipsView dAs;
    private com.baidu.swan.games.loading.a dAt;
    private TextView dAu;
    private ValueAnimator dAv;
    private View mRightMenu;
    private ImageView mRightMenuImageView;
    private boolean dAw = false;
    private float dAx = 0.0f;
    private float dAy = 0.0f;
    private float dAz = 0.0f;
    private long dAA = 0;
    private a dAB = null;
    private String dAD = "";

    public c(SwanAppActivity swanAppActivity) {
        this.dAE = com.baidu.swan.apps.runtime.d.aEQ().ade() != 1;
        this.dAq = swanAppActivity;
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
        if (dAh == null) {
            dAh = o(context, false);
        }
        if (dAi == null) {
            dAi = o(context, true);
        }
        if (DEBUG) {
            Log.i("SwanAppLoadingView", "obtainPreloadContainer:  App=" + dAh + " Game=" + dAi);
        }
    }

    public static void aLf() {
        dAh = null;
        dAi = null;
    }

    private View n(Context context, boolean z) {
        View view = z ? dAi : dAh;
        if (z) {
            dAi = null;
        } else {
            dAh = null;
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
        this.dAE = com.baidu.swan.apps.runtime.d.aEQ().ade() != 1;
        this.dAA = 0L;
        String aww = com.baidu.swan.apps.runtime.d.aEQ().aEM().aEY().aww();
        boolean z4 = this.dAB == null || (this.dAB.dAG ^ z) || TextUtils.isEmpty(aww) || !TextUtils.equals(aww, this.dAB.dAH);
        if (DEBUG) {
            Log.i("SwanAppLoadingView", "showSwanAppStartView: newLaunchId = " + aww + " newIsGameLoading = " + z + " reCreateStarter = " + z4 + " mViewStarter = " + this.dAB);
        }
        Handler mainHandler = com.baidu.swan.apps.runtime.d.getMainHandler();
        if (this.dAB != null) {
            if (DEBUG) {
                Log.i("SwanAppLoadingView", "showSwanAppStartView: oldLaunchId = " + this.dAB.dAH + " oldIsGameLoading = " + this.dAB.dAG);
            }
            mainHandler.removeCallbacks(this.dAB);
        }
        if (z4) {
            this.dAB = new a(aww, z);
        }
        if (this.dAB != null) {
            if (aVar == null || !aVar.getBoolean(" event_params_pkg_update", false)) {
                z3 = false;
            }
            if (this.dAB.dAJ) {
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
                this.dAB.aLs();
            }
            if (z2) {
                this.dAB.gR(false);
                return;
            }
            if (DEBUG) {
                Log.i("SwanAppLoadingView", "showSwanAppStartView: post starter trace = " + Log.getStackTraceString(new Throwable()));
            }
            mainHandler.post(this.dAB);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(boolean z, boolean z2) {
        synchronized (c.class) {
            if (this.dAp == null) {
                this.dAp = new com.baidu.swan.apps.e.a();
            }
            this.dAj = n(this.dAq, z);
            if (!z) {
                this.dAj.setPadding(0, com.baidu.swan.apps.res.widget.a.SUPPORT_IMMERSION ? ah.getStatusBarHeight() : 0, 0, 0);
            } else {
                aLg();
            }
            this.dAu = (TextView) this.dAj.findViewById(a.f.aiapps_loading_progress);
            b.a aEY = com.baidu.swan.apps.runtime.d.aEQ().aEM().aEY();
            PMSAppInfo awt = aEY.awt();
            t(z, z2);
            this.dAq.adh().ay(this.dAj);
            this.dAw = true;
            this.dAk = (TextView) this.dAj.findViewById(a.f.aiapps_title);
            this.cDx = (SwanAppRoundedImageView) this.dAj.findViewById(a.f.aiapps_icon);
            this.cDy = (BdBaseImageView) this.dAj.findViewById(a.f.aiapps_label_bg);
            this.cDz = (TextView) this.dAj.findViewById(a.f.aiapps_label_tv);
            this.dAo = (RelativeLayout) this.dAj.findViewById(a.f.aiapps_icon_rl);
            kf(aEY.aqe());
            ut(aEY.getIconUrl());
            lm(aEY.getType());
            this.dAl = (ImageView) this.dAj.findViewById(a.f.light_print);
            this.dAm = (ImageView) this.dAj.findViewById(a.f.dark_print);
            this.mRightMenuImageView = (ImageView) this.dAj.findViewById(a.f.titlebar_right_menu_img);
            this.dAn = (ImageView) this.dAj.findViewById(a.f.titlebar_right_menu_exit);
            this.mRightMenu = this.dAj.findViewById(a.f.titlebar_right_menu);
            if (z) {
                this.mRightMenuImageView.setClickable(true);
                this.mRightMenuImageView.setImageResource(a.e.aiapps_action_bar_single_menu_white_selector);
                this.dAn.setImageResource(a.e.aiapps_action_bar_exit_white_selector);
                this.mRightMenu.setBackgroundResource(a.e.aiapps_action_bar_right_menu_bg_solid);
                this.dAr = this.dAj.findViewById(a.f.titlebar_right_menu_line);
                this.dAr.setBackgroundResource(a.c.aiapps_action_bar_menu_line_white);
            } else {
                this.mRightMenuImageView.setImageResource(a.e.aiapps_action_bar_menu_black_selector);
                this.dAn.setImageResource(a.e.aiapps_action_bar_exit_black_selector);
                this.mRightMenu.setBackgroundResource(a.e.aiapps_action_bar_right_menu_bg);
            }
            int i = awt == null ? PMSConstants.PayProtected.NO_PAY_PROTECTED.type : awt.payProtected;
            if (!z && ak.aKA() && i == PMSConstants.PayProtected.PAY_PROTECTED.type) {
                ((RelativeLayout) this.dAj.findViewById(a.f.guarantee_plan_rl)).setVisibility(0);
            }
            this.dAm.setAlpha(0.0f);
            this.dAp.g(this.dAq);
            aLi();
        }
    }

    private void aLg() {
        this.dAs = (SwanLoadingTipsView) this.dAj.findViewById(a.f.aigames_loading_game_tips);
        this.dAs.setTipsAnimationFinishCallback(new kotlin.jvm.a.a<l>() { // from class: com.baidu.swan.apps.view.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.a.a
            /* renamed from: aLm */
            public l invoke() {
                c.this.aLh();
                return null;
            }
        });
        this.dAt = new com.baidu.swan.games.loading.a();
        this.dAj.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.swan.apps.view.c.3
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                c.this.aLh();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLh() {
        if (this.dAs != null && this.dAt != null) {
            this.dAs.xa(this.dAt.aTM());
        }
    }

    private void aLi() {
        this.dAn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.view.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.dAq != null && !c.this.dAq.isFinishing()) {
                    HybridUbcFlow aBh = com.baidu.swan.apps.performance.i.aBh();
                    if (aBh != null) {
                        aBh.ci("exitType", String.valueOf(3));
                        aBh.r("value", "cancel");
                        aBh.aAM();
                    }
                    c.this.dAq.moveTaskToBack(true);
                    ap.aKK().lh(2);
                    c.this.aLj();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLj() {
        Bundle awi;
        b.a ado = this.dAq.ado();
        if (ado != null && (awi = ado.awi()) != null) {
            long j = awi.getLong("page_display_flag_for_statistic");
            awi.remove("page_display_flag_for_statistic");
            if (j > 0) {
                String valueOf = String.valueOf(System.currentTimeMillis() - ado.getLong("launch_time", 0L));
                f fVar = new f();
                fVar.mType = Config.LAUNCH;
                fVar.mValue = "realcancel";
                fVar.dux = valueOf;
                fVar.u(TiebaInitialize.LogFields.REASON, "close");
                if (ado.getAppFrameType() == 1) {
                    fVar.u("errorList", com.baidu.swan.games.v.b.aUB().aUC());
                }
                this.dAq.a(fVar);
                e.b(ado);
            }
        }
    }

    private void lm(int i) {
        ah.a(this.cDy, this.cDz, String.valueOf(i));
    }

    public void ln(final int i) {
        Handler mainHandler = com.baidu.swan.apps.runtime.d.getMainHandler();
        if (this.dAB != null) {
            mainHandler.removeCallbacks(this.dAB);
            this.dAB.onDestroy();
            this.dAB = null;
        }
        mainHandler.post(new Runnable() { // from class: com.baidu.swan.apps.view.c.5
            @Override // java.lang.Runnable
            public void run() {
                synchronized (c.class) {
                    com.baidu.swan.apps.performance.i.aBg().f(new UbcFlowEvent("first_anim_end"));
                    com.baidu.swan.apps.ak.a.aHs().sE("first_anim_end");
                    if (c.this.dAp != null) {
                        c.this.dAp.a(c.this.dAq, i);
                    }
                    c.this.dAw = false;
                }
            }
        });
    }

    public void agV() {
        if (DEBUG) {
            Log.i("SwanAppLoadingView", "stopAnimations: " + Log.getStackTraceString(new Exception()));
        }
        Handler mainHandler = com.baidu.swan.apps.runtime.d.getMainHandler();
        if (this.dAB != null) {
            mainHandler.removeCallbacks(this.dAB);
            this.dAB.onDestroy();
            this.dAB = null;
        }
        synchronized (c.class) {
            if (this.dAp != null) {
                this.dAp.agV();
            }
            if (this.dAs != null) {
                this.dAs.doDestroy();
                this.dAs = null;
            }
            if (this.dAu != null) {
                this.dAu.setVisibility(8);
                this.dAu = null;
                this.dAD = "";
                this.dAy = 0.0f;
                this.dAx = 0.0f;
                this.dAz = 0.0f;
            }
            if (this.dAv != null) {
                this.dAv.removeAllUpdateListeners();
                this.dAv.cancel();
                this.dAv = null;
            }
            this.dAw = false;
            if (this.dAB != null) {
                this.dAB.onDestroy();
                this.dAB = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(Bitmap bitmap) {
        if (bitmap != null && this.cDx != null) {
            this.cDx.setImageBitmap(bitmap);
        }
    }

    public void P(float f) {
        if (DEBUG) {
            Log.i("SwanAppLoadingView", "onDownloadProgressUpdate: " + f + " view: " + this.dAu);
        }
        if (this.dAu != null) {
            float f2 = f >= 0.0f ? f : 0.0f;
            this.dAx = f2 <= 1.0f ? f2 : 1.0f;
            aLk();
            if (this.dAE) {
                if (this.dAA == 0) {
                    this.dAA = System.currentTimeMillis();
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.dAA > 2000) {
                    com.baidu.swan.apps.core.f.bp("pms_downloadPkg", "包下载进度更新间隔大于2秒");
                    this.dAE = false;
                }
                this.dAA = currentTimeMillis;
            }
        }
    }

    private void s(boolean z, boolean z2) {
        if (z) {
            this.dAD = "";
        } else {
            this.dAD = this.dAu.getContext().getString(z2 ? a.h.swan_loading_view_tag_updating : a.h.swan_loading_view_tag_loading);
        }
    }

    public void t(boolean z, boolean z2) {
        if (this.dAu != null) {
            if (this.dAv != null) {
                this.dAv.cancel();
                this.dAv.removeAllUpdateListeners();
            }
            s(z, z2);
            this.dAy = 0.0f;
            this.dAx = 0.0f;
            this.dAz = 0.0f;
            if (z) {
                aLk();
                this.dAv = ValueAnimator.ofFloat(0.0f, 1.0f);
                this.dAv.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.view.c.6
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        if (floatValue > 0.9f || floatValue - c.this.dAy > 0.05d) {
                            c.this.dAy = floatValue;
                            c.this.aLk();
                        }
                    }
                });
                this.dAv.setDuration(4000L);
                this.dAv.start();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLk() {
        if (this.dAu != null) {
            float v = v(this.dAy, this.dAx);
            Q(v <= 1.0f ? v : 1.0f);
        }
    }

    private void Q(float f) {
        if (this.dAu != null && this.dAz <= f) {
            this.dAz = f;
            if (DEBUG) {
                Log.i("SwanAppLoadingView", "setProgressText: " + this.dAz);
            }
            int i = (int) (1000.0f * f);
            int i2 = i / 10;
            String str = ((i % 10 >= 5 ? 1 : 0) + i2) + "%";
            String trim = this.dAD.trim();
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(trim)) {
                sb.append(trim).append(" ");
            }
            sb.append(str);
            if (this.dAB != null && !this.dAB.dAG) {
                if (this.dAB.aLp()) {
                    if (DEBUG) {
                        Log.i("SwanAppLoadingView", "setProgressText: checking update");
                    }
                    this.dAu.setText(this.dAu.getContext().getString(a.h.swanapp_swan_loading_runtime_check_updating));
                    this.dAu.setVisibility(0);
                } else if (this.dAB.aLq() && this.dAz <= 0.0f) {
                    if (DEBUG) {
                        Log.i("SwanAppLoadingView", "setProgressText: checking update");
                    }
                    this.dAu.setText(this.dAu.getContext().getString(a.h.swanapp_swan_loading_runtime_check_updating));
                    this.dAu.setVisibility(0);
                } else if (this.dAB.aLp()) {
                    if (DEBUG) {
                        Log.i("SwanAppLoadingView", "setProgressText: Framework loading");
                    }
                    this.dAu.setText(this.dAu.getContext().getString(a.h.swanapp_swan_loading_runtime_loading));
                    this.dAu.setVisibility(0);
                } else if (this.dAB.dAL && !this.dAB.aLr()) {
                    if (DEBUG) {
                        Log.i("SwanAppLoadingView", "setProgressText: Framework loading");
                    }
                    this.dAu.setText(this.dAu.getContext().getString(a.h.swanapp_swan_loading_runtime_loading));
                    this.dAu.setVisibility(0);
                } else if (this.dAz >= 1.0f && !this.dAB.aLr()) {
                    if (DEBUG) {
                        Log.i("SwanAppLoadingView", "setProgressText: Framework loading");
                    }
                    this.dAu.setText(this.dAu.getContext().getString(a.h.swanapp_swan_loading_runtime_loading));
                    this.dAu.setVisibility(0);
                } else {
                    this.dAu.setText(sb);
                }
            } else {
                this.dAu.setText(sb);
            }
            if (f > 0.0f) {
                this.dAu.setVisibility(0);
            }
        }
    }

    private float v(float f, float f2) {
        return ((1.0f - f) * f2) + f;
    }

    public void aLl() {
        if (this.dAu != null) {
            if (this.dAv != null) {
                this.dAv.removeAllUpdateListeners();
                this.dAv.cancel();
                this.dAv = null;
            }
            Q(1.0f);
        }
    }

    public void ut(String str) {
        if (DEBUG) {
            Log.i("SwanAppLoadingView", "updateIcon: icon=" + str);
        }
        final String appId = com.baidu.swan.apps.runtime.d.aEQ().getAppId();
        if (this.dAw) {
            this.cDx.setImageBitmap(ak.a(str, "SwanAppLoadingView", true, new s.a() { // from class: com.baidu.swan.apps.view.c.7
                @Override // com.baidu.swan.apps.ap.s.a
                public void g(String str2, Bitmap bitmap) {
                    SwanAppActivity aEO;
                    c adi;
                    if (bitmap != null && (aEO = com.baidu.swan.apps.runtime.d.aEQ().aEO()) != null && !aEO.isDestroyed() && (adi = aEO.adi()) != null && TextUtils.equals(appId, com.baidu.swan.apps.runtime.d.aEQ().getAppId())) {
                        adi.r(bitmap);
                    }
                }
            }));
        }
    }

    public void kf(String str) {
        if (this.dAw && !TextUtils.isEmpty(str)) {
            this.dAk.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a implements Runnable {
        final com.baidu.swan.apps.runtime.b coy;
        final boolean dAG;
        final String dAH;
        private boolean dAL;
        boolean dAI = false;
        boolean dAJ = false;
        private int dnn = -1;
        private int dAK = -1;

        a(String str, boolean z) {
            this.dAH = str;
            this.dAG = z;
            this.coy = new com.baidu.swan.apps.runtime.b().a(new com.baidu.swan.apps.ap.e.b<i.a>() { // from class: com.baidu.swan.apps.view.c.a.7
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ap.e.b
                /* renamed from: b */
                public void M(i.a aVar) {
                    if (c.DEBUG) {
                        Log.i("SwanAppLoadingView", "onCallback: EVENT_PMS_CHECK_START");
                    }
                    a.this.dnn = aVar.getInt("KEY_PKG_STATE", -1);
                    a.this.aLn();
                }
            }, "event_pms_check_start").a(new com.baidu.swan.apps.ap.e.b<i.a>() { // from class: com.baidu.swan.apps.view.c.a.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ap.e.b
                /* renamed from: b */
                public void M(i.a aVar) {
                    if (c.DEBUG) {
                        Log.i("SwanAppLoadingView", "onCallback: EVENT_PMS_CHECK_FINISH");
                    }
                    a.this.dnn = aVar.getInt("KEY_PKG_STATE", -1);
                    a.this.aLn();
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
                    a.this.dAL = true;
                    a.this.aLn();
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
                    a.this.dAK = aVar.getInt("KEY_PRELOAD_STATE");
                    a.this.aLn();
                }
            }, "event_preload_finish");
            com.baidu.swan.apps.runtime.d.aEQ().v(this.coy);
        }

        void aLn() {
            boolean aLp = aLp();
            boolean aLo = aLo();
            boolean aLr = aLr();
            if (c.DEBUG) {
                Log.i("SwanAppLoadingView", "checkAndUpdateProgress: runtimeLoading " + aLp);
                Log.i("SwanAppLoadingView", "checkAndUpdateProgress: checkingUpdate " + aLo);
                Log.i("SwanAppLoadingView", "checkAndUpdateProgress: preloadFinish " + aLr);
            }
            if (aLp || aLo || !aLr) {
                c.this.aLk();
            }
        }

        boolean aLo() {
            boolean aLq = aLq();
            boolean aLr = aLr();
            boolean z = aLq && aLr;
            if (c.DEBUG) {
                Log.i("SwanAppLoadingView", "isCheckingUpdate: overMaxAge " + aLq);
                Log.i("SwanAppLoadingView", "isCheckingUpdate: preloadFinish " + aLr);
                Log.i("SwanAppLoadingView", "isCheckingUpdate: " + z);
            }
            return z;
        }

        boolean aLp() {
            boolean z = this.dnn == 4;
            boolean aLr = aLr();
            if (c.DEBUG) {
                Log.i("SwanAppLoadingView", "isRuntimeLoading: isLocalPackage " + z);
                Log.i("SwanAppLoadingView", "isRuntimeLoading: preloadFinish " + aLr);
            }
            return z && !aLr;
        }

        boolean aLq() {
            boolean z = true;
            if (this.dnn != 3 && this.dnn != 1) {
                z = false;
            }
            if (c.DEBUG) {
                Log.i("SwanAppLoadingView", "isOverMaxAge: isOverMaxAge " + z);
            }
            return z;
        }

        boolean aLr() {
            boolean apq = com.baidu.swan.apps.core.turbo.d.aph().apq();
            if (c.DEBUG) {
                Log.i("SwanAppLoadingView", "isPreloadFinish: runtimeReady " + apq);
            }
            return apq;
        }

        void onDestroy() {
            if (c.DEBUG) {
                Log.i("SwanAppLoadingView", "onDestroy: ");
            }
            com.baidu.swan.apps.runtime.d.aEQ().w(this.coy);
        }

        a aLs() {
            this.dAI = true;
            return this;
        }

        @Override // java.lang.Runnable
        public void run() {
            gR(true);
        }

        public void gR(boolean z) {
            if (c.DEBUG) {
                Log.i("SwanAppLoadingView", "ViewStarter exec : post = " + z + " trace = " + (z ? "post" : Log.getStackTraceString(new Exception())));
            }
            this.dAJ = true;
            c.this.r(this.dAG, this.dAI);
        }
    }
}
