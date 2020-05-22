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
import com.baidu.swan.apps.aq.ag;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.aq.an;
import com.baidu.swan.apps.aq.q;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.performance.g;
import com.baidu.swan.apps.res.ui.BdBaseImageView;
import com.baidu.swan.apps.runtime.d;
import com.baidu.swan.apps.runtime.i;
import com.baidu.swan.apps.statistic.a.f;
import com.baidu.swan.apps.statistic.e;
import com.baidu.swan.apps.v.b.b;
import com.baidu.swan.games.loading.SwanLoadingTipsView;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.swan.pms.model.PMSAppInfo;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import kotlin.l;
/* loaded from: classes11.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static Boolean cMD = null;
    private static View cMj;
    private static View cMk;
    public SwanAppRoundedImageView bUD;
    public BdBaseImageView bUE;
    public TextView bUF;
    public View cMl;
    public TextView cMm;
    public ImageView cMn;
    public ImageView cMo;
    private ImageView cMp;
    public RelativeLayout cMq;
    private com.baidu.swan.apps.d.a cMr;
    private SwanAppActivity cMs;
    private View cMt;
    private SwanLoadingTipsView cMu;
    private com.baidu.swan.games.loading.a cMv;
    private TextView cMw;
    private ValueAnimator cMx;
    private View mRightMenu;
    private ImageView mRightMenuImageView;
    private boolean cMy = false;
    private float cMz = 0.0f;
    private float cMA = 0.0f;
    private float cMB = 0.0f;
    private a cMC = null;
    private String cME = "";

    public c(SwanAppActivity swanAppActivity) {
        DecimalFormat.getPercentInstance();
        this.cMs = swanAppActivity;
    }

    public static void cE(final Context context) {
        aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.view.c.1
            @Override // java.lang.Runnable
            public void run() {
                c.cF(context);
            }
        }, 5000L);
    }

    public static void cF(Context context) {
        if (cMj == null) {
            cMj = m(context, false);
        }
        if (cMk == null) {
            cMk = m(context, true);
        }
        if (DEBUG) {
            Log.i("SwanAppLoadingView", "obtainPreloadContainer:  App=" + cMj + " Game=" + cMk);
        }
    }

    public static void auq() {
        cMj = null;
        cMk = null;
    }

    private View l(Context context, boolean z) {
        View view = z ? cMk : cMj;
        if (z) {
            cMk = null;
        } else {
            cMj = null;
        }
        boolean z2 = (view == null || view.isAttachedToWindow()) ? false : true;
        if (z2) {
            cE(context);
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
        String ahd = d.aoB().aox().aoJ().ahd();
        boolean z4 = this.cMC == null || (this.cMC.cMH ^ z) || TextUtils.isEmpty(ahd) || !TextUtils.equals(ahd, this.cMC.cMI);
        if (DEBUG) {
            Log.i("SwanAppLoadingView", "showSwanAppStartView: newLaunchId = " + ahd + " newIsGameLoading = " + z + " reCreateStarter = " + z4 + " mViewStarter = " + this.cMC);
        }
        Handler mainHandler = d.getMainHandler();
        if (this.cMC != null) {
            if (DEBUG) {
                Log.i("SwanAppLoadingView", "showSwanAppStartView: oldLaunchId = " + this.cMC.cMI + " oldIsGameLoading = " + this.cMC.cMH);
            }
            mainHandler.removeCallbacks(this.cMC);
        }
        if (z4) {
            this.cMC = new a(ahd, z);
        }
        if (this.cMC != null) {
            if (aVar == null || !aVar.getBoolean(" event_params_pkg_update", false)) {
                z3 = false;
            }
            if (this.cMC.cMK) {
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
                this.cMC.auy();
            }
            if (z2) {
                this.cMC.fC(false);
                return;
            }
            if (DEBUG) {
                Log.i("SwanAppLoadingView", "showSwanAppStartView: post starter trace = " + Log.getStackTraceString(new Throwable()));
            }
            mainHandler.post(this.cMC);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(boolean z, boolean z2) {
        synchronized (c.class) {
            if (this.cMr == null) {
                this.cMr = new com.baidu.swan.apps.d.a();
            }
            this.cMl = l(this.cMs, z);
            if (!z) {
                this.cMl.setPadding(0, com.baidu.swan.apps.res.widget.a.SUPPORT_IMMERSION ? ag.getStatusBarHeight() : 0, 0, 0);
            } else {
                aur();
            }
            this.cMw = (TextView) this.cMl.findViewById(a.f.aiapps_loading_progress);
            q(z, z2);
            this.cMs.QC().aq(this.cMl);
            this.cMy = true;
            this.cMm = (TextView) this.cMl.findViewById(a.f.aiapps_title);
            this.bUD = (SwanAppRoundedImageView) this.cMl.findViewById(a.f.aiapps_icon);
            this.bUE = (BdBaseImageView) this.cMl.findViewById(a.f.aiapps_label_bg);
            this.bUF = (TextView) this.cMl.findViewById(a.f.aiapps_label_tv);
            this.cMq = (RelativeLayout) this.cMl.findViewById(a.f.aiapps_icon_rl);
            b.a aoJ = d.aoB().aox().aoJ();
            pW(aoJ.abT());
            pV(aoJ.getIconUrl());
            hN(aoJ.getType());
            this.cMn = (ImageView) this.cMl.findViewById(a.f.light_print);
            this.cMo = (ImageView) this.cMl.findViewById(a.f.dark_print);
            this.mRightMenuImageView = (ImageView) this.cMl.findViewById(a.f.titlebar_right_menu_img);
            this.cMp = (ImageView) this.cMl.findViewById(a.f.titlebar_right_menu_exit);
            this.mRightMenu = this.cMl.findViewById(a.f.titlebar_right_menu);
            if (z) {
                this.mRightMenuImageView.setClickable(true);
                this.mRightMenuImageView.setImageResource(a.e.aiapps_action_bar_single_menu_white_selector);
                this.cMp.setImageResource(a.e.aiapps_action_bar_exit_white_selector);
                this.mRightMenu.setBackgroundResource(a.e.aiapps_action_bar_right_menu_bg_solid);
                this.cMt = this.cMl.findViewById(a.f.titlebar_right_menu_line);
                this.cMt.setBackgroundResource(a.c.aiapps_action_bar_menu_line_white);
            } else {
                this.mRightMenuImageView.setImageResource(a.e.aiapps_action_bar_menu_black_selector);
                this.cMp.setImageResource(a.e.aiapps_action_bar_exit_black_selector);
                this.mRightMenu.setBackgroundResource(a.e.aiapps_action_bar_right_menu_bg);
            }
            PMSAppInfo aha = aoJ.aha();
            int i = aha == null ? PMSConstants.PayProtected.NO_PAY_PROTECTED.type : aha.payProtected;
            if (!z && aj.atS() && i == PMSConstants.PayProtected.PAY_PROTECTED.type) {
                ((RelativeLayout) this.cMl.findViewById(a.f.guarantee_plan_rl)).setVisibility(0);
            }
            this.cMo.setAlpha(0.0f);
            this.cMr.f(this.cMs);
            aut();
        }
    }

    private void aur() {
        this.cMu = (SwanLoadingTipsView) this.cMl.findViewById(a.f.aigames_loading_game_tips);
        this.cMu.setTipsAnimationFinishCallback(new kotlin.jvm.a.a<l>() { // from class: com.baidu.swan.apps.view.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.a.a
            /* renamed from: aux */
            public l invoke() {
                c.this.aus();
                return null;
            }
        });
        this.cMv = new com.baidu.swan.games.loading.a();
        this.cMl.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.swan.apps.view.c.3
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                c.this.aus();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aus() {
        if (this.cMu != null && this.cMv != null) {
            this.cMu.se(this.cMv.aAU());
        }
    }

    private void aut() {
        this.cMp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.view.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.cMs != null && !c.this.cMs.isFinishing()) {
                    HybridUbcFlow aly = g.aly();
                    if (aly != null) {
                        aly.bD("exitType", String.valueOf(3));
                        aly.ald();
                    }
                    c.this.cMs.moveTaskToBack(true);
                    an.atY().hI(2);
                    c.this.auu();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auu() {
        Bundle agP;
        b.a QJ = this.cMs.QJ();
        if (QJ != null && (agP = QJ.agP()) != null) {
            long j = agP.getLong("page_display_flag_for_statistic");
            agP.remove("page_display_flag_for_statistic");
            if (j > 0) {
                String valueOf = String.valueOf(System.currentTimeMillis() - QJ.getLong("launch_time", 0L));
                f fVar = new f();
                fVar.mType = Config.LAUNCH;
                fVar.mValue = "realcancel";
                fVar.cGC = valueOf;
                fVar.v(TiebaInitialize.LogFields.REASON, "close");
                if (QJ.getAppFrameType() == 1) {
                    fVar.v("errorList", com.baidu.swan.games.v.b.aBJ().aBK());
                }
                this.cMs.a(fVar);
                e.a(QJ);
            }
        }
    }

    private void hN(int i) {
        ag.a(this.bUE, this.bUF, String.valueOf(i));
    }

    public void hO(final int i) {
        Handler mainHandler = d.getMainHandler();
        if (this.cMC != null) {
            mainHandler.removeCallbacks(this.cMC);
            this.cMC = null;
        }
        mainHandler.post(new Runnable() { // from class: com.baidu.swan.apps.view.c.5
            @Override // java.lang.Runnable
            public void run() {
                synchronized (c.class) {
                    g.alx().f(new UbcFlowEvent("first_anim_end"));
                    com.baidu.swan.apps.al.a.aqT().oo("first_anim_end");
                    if (c.this.cMr != null) {
                        c.this.cMr.a(c.this.cMs, i);
                    }
                    c.this.cMy = false;
                }
            }
        });
    }

    public void TP() {
        if (DEBUG) {
            Log.i("SwanAppLoadingView", "stopAnimations: " + Log.getStackTraceString(new Exception()));
        }
        Handler mainHandler = d.getMainHandler();
        if (this.cMC != null) {
            mainHandler.removeCallbacks(this.cMC);
            this.cMC = null;
        }
        synchronized (c.class) {
            if (this.cMr != null) {
                this.cMr.TP();
            }
            if (this.cMu != null) {
                this.cMu.doDestroy();
                this.cMu = null;
            }
            if (this.cMw != null) {
                this.cMw.setVisibility(8);
                this.cMw = null;
                this.cME = "";
                this.cMA = 0.0f;
                this.cMz = 0.0f;
                this.cMB = 0.0f;
            }
            if (this.cMx != null) {
                this.cMx.removeAllUpdateListeners();
                this.cMx.cancel();
                this.cMx = null;
            }
            this.cMy = false;
            this.cMC = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(Bitmap bitmap) {
        if (bitmap != null && this.bUD != null) {
            this.bUD.setImageBitmap(bitmap);
        }
    }

    public void F(float f) {
        if (DEBUG) {
            Log.i("SwanAppLoadingView", "onDownloadProgressUpdate: " + f + " view: " + this.cMw);
        }
        if (this.cMw != null) {
            float f2 = f >= 0.0f ? f : 0.0f;
            this.cMz = f2 <= 1.0f ? f2 : 1.0f;
            auv();
        }
    }

    private void p(boolean z, boolean z2) {
        if (z) {
            this.cME = "";
        } else {
            this.cME = this.cMw.getContext().getString(z2 ? a.h.swan_loading_view_tag_updating : a.h.swan_loading_view_tag_loading);
        }
    }

    public void q(boolean z, boolean z2) {
        if (this.cMw != null) {
            if (this.cMx != null) {
                this.cMx.cancel();
                this.cMx.removeAllUpdateListeners();
            }
            p(z, z2);
            this.cMA = 0.0f;
            this.cMz = 0.0f;
            this.cMB = 0.0f;
            if (z) {
                auv();
                this.cMx = ValueAnimator.ofFloat(0.0f, 1.0f);
                this.cMx.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.view.c.6
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        if (floatValue > 0.9f || floatValue - c.this.cMA > 0.05d) {
                            c.this.cMA = floatValue;
                            c.this.auv();
                        }
                    }
                });
                this.cMx.setDuration(4000L);
                this.cMx.start();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auv() {
        if (this.cMw != null) {
            float q = q(this.cMA, this.cMz);
            G(q <= 1.0f ? q : 1.0f);
        }
    }

    private void G(float f) {
        if (this.cMw != null && this.cMB <= f) {
            this.cMB = f;
            String format = NumberFormat.getPercentInstance().format(f);
            String trim = this.cME.trim();
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(trim)) {
                sb.append(trim).append(" ");
            }
            sb.append(format);
            this.cMw.setText(sb);
            if (f > 0.0f) {
                this.cMw.setVisibility(0);
            }
        }
    }

    private float q(float f, float f2) {
        return ((1.0f - f) * f2) + f;
    }

    public void auw() {
        if (this.cMw != null) {
            if (this.cMx != null) {
                this.cMx.removeAllUpdateListeners();
                this.cMx.cancel();
                this.cMx = null;
            }
            G(1.0f);
        }
    }

    public void pV(String str) {
        if (DEBUG) {
            Log.i("SwanAppLoadingView", "updateIcon: icon=" + str);
        }
        final String appId = d.aoB().getAppId();
        if (this.cMy) {
            this.bUD.setImageBitmap(aj.a(str, "SwanAppLoadingView", true, new q.a() { // from class: com.baidu.swan.apps.view.c.7
                @Override // com.baidu.swan.apps.aq.q.a
                public void h(String str2, Bitmap bitmap) {
                    SwanAppActivity aoz;
                    c QD;
                    if (bitmap != null && (aoz = d.aoB().aoz()) != null && !aoz.isDestroyed() && (QD = aoz.QD()) != null && TextUtils.equals(appId, d.aoB().getAppId())) {
                        QD.o(bitmap);
                    }
                }
            }));
        }
    }

    public void pW(String str) {
        if (this.cMy && !TextUtils.isEmpty(str)) {
            this.cMm.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a implements Runnable {
        final boolean cMH;
        final String cMI;
        boolean cMJ = false;
        boolean cMK = false;

        a(String str, boolean z) {
            this.cMI = str;
            this.cMH = z;
        }

        a auy() {
            this.cMJ = true;
            return this;
        }

        @Override // java.lang.Runnable
        public void run() {
            fC(true);
        }

        public void fC(boolean z) {
            if (c.DEBUG) {
                Log.i("SwanAppLoadingView", "ViewStarter exec : post = " + z + " trace = " + (z ? "post" : Log.getStackTraceString(new Exception())));
            }
            this.cMK = true;
            c.this.o(this.cMH, this.cMJ);
        }
    }
}
