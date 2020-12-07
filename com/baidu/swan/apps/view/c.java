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
import kotlin.h;
/* loaded from: classes25.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static Boolean dLL = null;
    private static View dLq;
    private static View dLr;
    public BdBaseImageView cOA;
    public TextView cOB;
    public SwanAppRoundedImageView cOz;
    private View dLA;
    private SwanLoadingTipsView dLB;
    private com.baidu.swan.games.loading.a dLC;
    private TextView dLD;
    private ValueAnimator dLE;
    private boolean dLF = false;
    private float dLG = 0.0f;
    private float dLH = 0.0f;
    private float dLI = 0.0f;
    private long dLJ = 0;
    private a dLK = null;
    private String dLM = "";
    private boolean dLN;
    public View dLs;
    public TextView dLt;
    public ImageView dLu;
    public ImageView dLv;
    private ImageView dLw;
    public RelativeLayout dLx;
    private com.baidu.swan.apps.e.a dLy;
    private SwanAppActivity dLz;
    private View mRightMenu;
    private ImageView mRightMenuImageView;

    public c(SwanAppActivity swanAppActivity) {
        this.dLN = com.baidu.swan.apps.runtime.d.aJQ().aie() != 1;
        this.dLz = swanAppActivity;
    }

    public static void dB(final Context context) {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.view.c.1
            @Override // java.lang.Runnable
            public void run() {
                c.dC(context);
            }
        }, 5000L);
    }

    public static void dC(Context context) {
        if (dLq == null) {
            dLq = t(context, false);
        }
        if (dLr == null) {
            dLr = t(context, true);
        }
        if (DEBUG) {
            Log.i("SwanAppLoadingView", "obtainPreloadContainer:  App=" + dLq + " Game=" + dLr);
        }
    }

    public static void aQd() {
        dLq = null;
        dLr = null;
    }

    private View s(Context context, boolean z) {
        View view = z ? dLr : dLq;
        if (z) {
            dLr = null;
        } else {
            dLq = null;
        }
        boolean z2 = (view == null || view.isAttachedToWindow()) ? false : true;
        if (z2) {
            dB(context);
        }
        if (!z2) {
            view = t(context, z);
        }
        if (DEBUG) {
            Log.i("SwanAppLoadingView", "obtainPreloadContainer:  isLegalContainer= " + z2 + " game=" + z + " container=" + view);
        }
        return view;
    }

    private static View t(Context context, boolean z) {
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
        this.dLN = com.baidu.swan.apps.runtime.d.aJQ().aie() != 1;
        this.dLJ = 0L;
        String aBx = com.baidu.swan.apps.runtime.d.aJQ().aJM().aJY().aBx();
        boolean z4 = this.dLK == null || (this.dLK.dLP ^ z) || TextUtils.isEmpty(aBx) || !TextUtils.equals(aBx, this.dLK.dLQ);
        if (DEBUG) {
            Log.i("SwanAppLoadingView", "showSwanAppStartView: newLaunchId = " + aBx + " newIsGameLoading = " + z + " reCreateStarter = " + z4 + " mViewStarter = " + this.dLK);
        }
        Handler mainHandler = com.baidu.swan.apps.runtime.d.getMainHandler();
        if (this.dLK != null) {
            if (DEBUG) {
                Log.i("SwanAppLoadingView", "showSwanAppStartView: oldLaunchId = " + this.dLK.dLQ + " oldIsGameLoading = " + this.dLK.dLP);
            }
            mainHandler.removeCallbacks(this.dLK);
        }
        if (z4) {
            this.dLK = new a(aBx, z);
        }
        if (this.dLK != null) {
            if (aVar == null || !aVar.getBoolean(" event_params_pkg_update", false)) {
                z3 = false;
            }
            if (this.dLK.dLS) {
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
                this.dLK.aQq();
            }
            if (z2) {
                this.dLK.hs(false);
                return;
            }
            if (DEBUG) {
                Log.i("SwanAppLoadingView", "showSwanAppStartView: post starter trace = " + Log.getStackTraceString(new Throwable()));
            }
            mainHandler.post(this.dLK);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(boolean z, boolean z2) {
        synchronized (c.class) {
            if (this.dLy == null) {
                this.dLy = new com.baidu.swan.apps.e.a();
            }
            this.dLs = s(this.dLz, z);
            if (!z) {
                this.dLs.setPadding(0, com.baidu.swan.apps.res.widget.a.SUPPORT_IMMERSION ? ah.getStatusBarHeight() : 0, 0, 0);
            } else {
                aQe();
            }
            this.dLD = (TextView) this.dLs.findViewById(a.f.aiapps_loading_progress);
            b.a aJY = com.baidu.swan.apps.runtime.d.aJQ().aJM().aJY();
            PMSAppInfo aBu = aJY.aBu();
            t(z, z2);
            this.dLz.aih().aE(this.dLs);
            this.dLF = true;
            this.dLt = (TextView) this.dLs.findViewById(a.f.aiapps_title);
            this.cOz = (SwanAppRoundedImageView) this.dLs.findViewById(a.f.aiapps_icon);
            this.cOA = (BdBaseImageView) this.dLs.findViewById(a.f.aiapps_label_bg);
            this.cOB = (TextView) this.dLs.findViewById(a.f.aiapps_label_tv);
            this.dLx = (RelativeLayout) this.dLs.findViewById(a.f.aiapps_icon_rl);
            kV(aJY.avf());
            vj(aJY.getIconUrl());
            lQ(aJY.getType());
            this.dLu = (ImageView) this.dLs.findViewById(a.f.light_print);
            this.dLv = (ImageView) this.dLs.findViewById(a.f.dark_print);
            this.mRightMenuImageView = (ImageView) this.dLs.findViewById(a.f.titlebar_right_menu_img);
            this.dLw = (ImageView) this.dLs.findViewById(a.f.titlebar_right_menu_exit);
            this.mRightMenu = this.dLs.findViewById(a.f.titlebar_right_menu);
            if (z) {
                this.mRightMenuImageView.setClickable(true);
                this.mRightMenuImageView.setImageResource(a.e.aiapps_action_bar_single_menu_white_selector);
                this.dLw.setImageResource(a.e.aiapps_action_bar_exit_white_selector);
                this.mRightMenu.setBackgroundResource(a.e.aiapps_action_bar_right_menu_bg_solid);
                this.dLA = this.dLs.findViewById(a.f.titlebar_right_menu_line);
                this.dLA.setBackgroundResource(a.c.aiapps_action_bar_menu_line_white);
            } else {
                this.mRightMenuImageView.setImageResource(a.e.aiapps_action_bar_menu_black_selector);
                this.dLw.setImageResource(a.e.aiapps_action_bar_exit_black_selector);
                this.mRightMenu.setBackgroundResource(a.e.aiapps_action_bar_right_menu_bg);
            }
            int i = aBu == null ? PMSConstants.PayProtected.NO_PAY_PROTECTED.type : aBu.payProtected;
            if (!z && ak.aPy() && i == PMSConstants.PayProtected.PAY_PROTECTED.type) {
                ((RelativeLayout) this.dLs.findViewById(a.f.guarantee_plan_rl)).setVisibility(0);
            }
            this.dLv.setAlpha(0.0f);
            this.dLy.g(this.dLz);
            aQg();
        }
    }

    private void aQe() {
        this.dLB = (SwanLoadingTipsView) this.dLs.findViewById(a.f.aigames_loading_game_tips);
        this.dLB.setTipsAnimationFinishCallback(new kotlin.jvm.a.a<h>() { // from class: com.baidu.swan.apps.view.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.a.a
            /* renamed from: aQk */
            public h invoke() {
                c.this.aQf();
                return null;
            }
        });
        this.dLC = new com.baidu.swan.games.loading.a();
        this.dLs.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.swan.apps.view.c.3
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                c.this.aQf();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQf() {
        if (this.dLB != null && this.dLC != null) {
            this.dLB.xQ(this.dLC.aYJ());
        }
    }

    private void aQg() {
        this.dLw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.view.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.dLz != null && !c.this.dLz.isFinishing()) {
                    HybridUbcFlow aGh = com.baidu.swan.apps.performance.i.aGh();
                    if (aGh != null) {
                        aGh.co("exitType", String.valueOf(3));
                        aGh.q("value", "cancel");
                        aGh.aFM();
                    }
                    c.this.dLz.moveTaskToBack(true);
                    ap.aPI().lL(2);
                    c.this.aQh();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQh() {
        Bundle aBj;
        b.a aio = this.dLz.aio();
        if (aio != null && (aBj = aio.aBj()) != null) {
            long j = aBj.getLong("page_display_flag_for_statistic");
            aBj.remove("page_display_flag_for_statistic");
            if (j > 0) {
                String valueOf = String.valueOf(System.currentTimeMillis() - aio.getLong("launch_time", 0L));
                f fVar = new f();
                fVar.mType = Config.LAUNCH;
                fVar.mValue = "realcancel";
                fVar.dFH = valueOf;
                fVar.t(TiebaInitialize.LogFields.REASON, "close");
                if (aio.getAppFrameType() == 1) {
                    fVar.t("errorList", com.baidu.swan.games.v.b.aZy().aZz());
                }
                this.dLz.a(fVar);
                e.b(aio);
            }
        }
    }

    private void lQ(int i) {
        ah.a(this.cOA, this.cOB, String.valueOf(i));
    }

    public void lR(final int i) {
        Handler mainHandler = com.baidu.swan.apps.runtime.d.getMainHandler();
        if (this.dLK != null) {
            mainHandler.removeCallbacks(this.dLK);
            this.dLK.onDestroy();
            this.dLK = null;
        }
        mainHandler.post(new Runnable() { // from class: com.baidu.swan.apps.view.c.5
            @Override // java.lang.Runnable
            public void run() {
                synchronized (c.class) {
                    com.baidu.swan.apps.performance.i.aGg().f(new UbcFlowEvent("first_anim_end"));
                    com.baidu.swan.apps.ak.a.aMs().tu("first_anim_end");
                    if (c.this.dLy != null) {
                        c.this.dLy.a(c.this.dLz, i);
                    }
                    c.this.dLF = false;
                }
            }
        });
    }

    public void alV() {
        if (DEBUG) {
            Log.i("SwanAppLoadingView", "stopAnimations: " + Log.getStackTraceString(new Exception()));
        }
        Handler mainHandler = com.baidu.swan.apps.runtime.d.getMainHandler();
        if (this.dLK != null) {
            mainHandler.removeCallbacks(this.dLK);
            this.dLK.onDestroy();
            this.dLK = null;
        }
        synchronized (c.class) {
            if (this.dLy != null) {
                this.dLy.alV();
            }
            if (this.dLB != null) {
                this.dLB.doDestroy();
                this.dLB = null;
            }
            if (this.dLD != null) {
                this.dLD.setVisibility(8);
                this.dLD = null;
                this.dLM = "";
                this.dLH = 0.0f;
                this.dLG = 0.0f;
                this.dLI = 0.0f;
            }
            if (this.dLE != null) {
                this.dLE.removeAllUpdateListeners();
                this.dLE.cancel();
                this.dLE = null;
            }
            this.dLF = false;
            if (this.dLK != null) {
                this.dLK.onDestroy();
                this.dLK = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(Bitmap bitmap) {
        if (bitmap != null && this.cOz != null) {
            this.cOz.setImageBitmap(bitmap);
        }
    }

    public void Q(float f) {
        if (DEBUG) {
            Log.i("SwanAppLoadingView", "onDownloadProgressUpdate: " + f + " view: " + this.dLD);
        }
        if (this.dLD != null) {
            float f2 = f >= 0.0f ? f : 0.0f;
            this.dLG = f2 <= 1.0f ? f2 : 1.0f;
            aQi();
            if (this.dLN) {
                if (this.dLJ == 0) {
                    this.dLJ = System.currentTimeMillis();
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.dLJ > 2000) {
                    com.baidu.swan.apps.core.f.bv("pms_downloadPkg", "包下载进度更新间隔大于2秒");
                    this.dLN = false;
                }
                this.dLJ = currentTimeMillis;
            }
        }
    }

    private void s(boolean z, boolean z2) {
        if (z) {
            this.dLM = "";
        } else {
            this.dLM = this.dLD.getContext().getString(z2 ? a.h.swan_loading_view_tag_updating : a.h.swan_loading_view_tag_loading);
        }
    }

    public void t(boolean z, boolean z2) {
        if (this.dLD != null) {
            if (this.dLE != null) {
                this.dLE.cancel();
                this.dLE.removeAllUpdateListeners();
            }
            s(z, z2);
            this.dLH = 0.0f;
            this.dLG = 0.0f;
            this.dLI = 0.0f;
            if (z) {
                aQi();
                this.dLE = ValueAnimator.ofFloat(0.0f, 1.0f);
                this.dLE.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.view.c.6
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        if (floatValue > 0.9f || floatValue - c.this.dLH > 0.05d) {
                            c.this.dLH = floatValue;
                            c.this.aQi();
                        }
                    }
                });
                this.dLE.setDuration(4000L);
                this.dLE.start();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQi() {
        if (this.dLD != null) {
            float v = v(this.dLH, this.dLG);
            R(v <= 1.0f ? v : 1.0f);
        }
    }

    private void R(float f) {
        if (this.dLD != null && this.dLI <= f) {
            this.dLI = f;
            if (DEBUG) {
                Log.i("SwanAppLoadingView", "setProgressText: " + this.dLI);
            }
            int i = (int) (1000.0f * f);
            int i2 = i / 10;
            String str = ((i % 10 >= 5 ? 1 : 0) + i2) + "%";
            String trim = this.dLM.trim();
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(trim)) {
                sb.append(trim).append(" ");
            }
            sb.append(str);
            if (this.dLK != null && !this.dLK.dLP) {
                if (this.dLK.aQn()) {
                    if (DEBUG) {
                        Log.i("SwanAppLoadingView", "setProgressText: checking update");
                    }
                    this.dLD.setText(this.dLD.getContext().getString(a.h.swanapp_swan_loading_runtime_check_updating));
                    this.dLD.setVisibility(0);
                } else if (this.dLK.aQo() && this.dLI <= 0.0f) {
                    if (DEBUG) {
                        Log.i("SwanAppLoadingView", "setProgressText: checking update");
                    }
                    this.dLD.setText(this.dLD.getContext().getString(a.h.swanapp_swan_loading_runtime_check_updating));
                    this.dLD.setVisibility(0);
                } else if (this.dLK.aQn()) {
                    if (DEBUG) {
                        Log.i("SwanAppLoadingView", "setProgressText: Framework loading");
                    }
                    this.dLD.setText(this.dLD.getContext().getString(a.h.swanapp_swan_loading_runtime_loading));
                    this.dLD.setVisibility(0);
                } else if (this.dLK.dLU && !this.dLK.aQp()) {
                    if (DEBUG) {
                        Log.i("SwanAppLoadingView", "setProgressText: Framework loading");
                    }
                    this.dLD.setText(this.dLD.getContext().getString(a.h.swanapp_swan_loading_runtime_loading));
                    this.dLD.setVisibility(0);
                } else if (this.dLI >= 1.0f && !this.dLK.aQp()) {
                    if (DEBUG) {
                        Log.i("SwanAppLoadingView", "setProgressText: Framework loading");
                    }
                    this.dLD.setText(this.dLD.getContext().getString(a.h.swanapp_swan_loading_runtime_loading));
                    this.dLD.setVisibility(0);
                } else {
                    this.dLD.setText(sb);
                }
            } else {
                this.dLD.setText(sb);
            }
            if (f > 0.0f) {
                this.dLD.setVisibility(0);
            }
        }
    }

    private float v(float f, float f2) {
        return ((1.0f - f) * f2) + f;
    }

    public void aQj() {
        if (this.dLD != null) {
            if (this.dLE != null) {
                this.dLE.removeAllUpdateListeners();
                this.dLE.cancel();
                this.dLE = null;
            }
            R(1.0f);
        }
    }

    public void vj(String str) {
        if (DEBUG) {
            Log.i("SwanAppLoadingView", "updateIcon: icon=" + str);
        }
        final String appId = com.baidu.swan.apps.runtime.d.aJQ().getAppId();
        if (this.dLF) {
            this.cOz.setImageBitmap(ak.a(str, "SwanAppLoadingView", true, new s.a() { // from class: com.baidu.swan.apps.view.c.7
                @Override // com.baidu.swan.apps.ap.s.a
                public void g(String str2, Bitmap bitmap) {
                    SwanAppActivity aJO;
                    c aii;
                    if (bitmap != null && (aJO = com.baidu.swan.apps.runtime.d.aJQ().aJO()) != null && !aJO.isDestroyed() && (aii = aJO.aii()) != null && TextUtils.equals(appId, com.baidu.swan.apps.runtime.d.aJQ().getAppId())) {
                        aii.r(bitmap);
                    }
                }
            }));
        }
    }

    public void kV(String str) {
        if (this.dLF && !TextUtils.isEmpty(str)) {
            this.dLt.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes25.dex */
    public class a implements Runnable {
        final com.baidu.swan.apps.runtime.b czF;
        final boolean dLP;
        final String dLQ;
        private boolean dLU;
        boolean dLR = false;
        boolean dLS = false;
        private int dyD = -1;
        private int dLT = -1;

        a(String str, boolean z) {
            this.dLQ = str;
            this.dLP = z;
            this.czF = new com.baidu.swan.apps.runtime.b().a(new com.baidu.swan.apps.ap.e.b<i.a>() { // from class: com.baidu.swan.apps.view.c.a.7
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ap.e.b
                /* renamed from: b */
                public void M(i.a aVar) {
                    if (c.DEBUG) {
                        Log.i("SwanAppLoadingView", "onCallback: EVENT_PMS_CHECK_START");
                    }
                    a.this.dyD = aVar.getInt("KEY_PKG_STATE", -1);
                    a.this.aQl();
                }
            }, "event_pms_check_start").a(new com.baidu.swan.apps.ap.e.b<i.a>() { // from class: com.baidu.swan.apps.view.c.a.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ap.e.b
                /* renamed from: b */
                public void M(i.a aVar) {
                    if (c.DEBUG) {
                        Log.i("SwanAppLoadingView", "onCallback: EVENT_PMS_CHECK_FINISH");
                    }
                    a.this.dyD = aVar.getInt("KEY_PKG_STATE", -1);
                    a.this.aQl();
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
                    a.this.dLU = true;
                    a.this.aQl();
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
                    a.this.dLT = aVar.getInt("KEY_PRELOAD_STATE");
                    a.this.aQl();
                }
            }, "event_preload_finish");
            com.baidu.swan.apps.runtime.d.aJQ().v(this.czF);
        }

        void aQl() {
            boolean aQn = aQn();
            boolean aQm = aQm();
            boolean aQp = aQp();
            if (c.DEBUG) {
                Log.i("SwanAppLoadingView", "checkAndUpdateProgress: runtimeLoading " + aQn);
                Log.i("SwanAppLoadingView", "checkAndUpdateProgress: checkingUpdate " + aQm);
                Log.i("SwanAppLoadingView", "checkAndUpdateProgress: preloadFinish " + aQp);
            }
            if (aQn || aQm || !aQp) {
                c.this.aQi();
            }
        }

        boolean aQm() {
            boolean aQo = aQo();
            boolean aQp = aQp();
            boolean z = aQo && aQp;
            if (c.DEBUG) {
                Log.i("SwanAppLoadingView", "isCheckingUpdate: overMaxAge " + aQo);
                Log.i("SwanAppLoadingView", "isCheckingUpdate: preloadFinish " + aQp);
                Log.i("SwanAppLoadingView", "isCheckingUpdate: " + z);
            }
            return z;
        }

        boolean aQn() {
            boolean z = this.dyD == 4;
            boolean aQp = aQp();
            if (c.DEBUG) {
                Log.i("SwanAppLoadingView", "isRuntimeLoading: isLocalPackage " + z);
                Log.i("SwanAppLoadingView", "isRuntimeLoading: preloadFinish " + aQp);
            }
            return z && !aQp;
        }

        boolean aQo() {
            boolean z = true;
            if (this.dyD != 3 && this.dyD != 1) {
                z = false;
            }
            if (c.DEBUG) {
                Log.i("SwanAppLoadingView", "isOverMaxAge: isOverMaxAge " + z);
            }
            return z;
        }

        boolean aQp() {
            boolean auq = com.baidu.swan.apps.core.turbo.d.aui().auq();
            if (c.DEBUG) {
                Log.i("SwanAppLoadingView", "isPreloadFinish: runtimeReady " + auq);
            }
            return auq;
        }

        void onDestroy() {
            if (c.DEBUG) {
                Log.i("SwanAppLoadingView", "onDestroy: ");
            }
            com.baidu.swan.apps.runtime.d.aJQ().w(this.czF);
        }

        a aQq() {
            this.dLR = true;
            return this;
        }

        @Override // java.lang.Runnable
        public void run() {
            hs(true);
        }

        public void hs(boolean z) {
            if (c.DEBUG) {
                Log.i("SwanAppLoadingView", "ViewStarter exec : post = " + z + " trace = " + (z ? "post" : Log.getStackTraceString(new Exception())));
            }
            this.dLS = true;
            c.this.r(this.dLP, this.dLR);
        }
    }
}
