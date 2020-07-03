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
    private static View cQT;
    private static View cQU;
    public SwanAppRoundedImageView bZr;
    public BdBaseImageView bZs;
    public TextView bZt;
    public View cQV;
    public TextView cQW;
    public ImageView cQX;
    public ImageView cQY;
    private ImageView cQZ;
    public RelativeLayout cRa;
    private com.baidu.swan.apps.d.a cRb;
    private SwanAppActivity cRc;
    private View cRd;
    private SwanLoadingTipsView cRe;
    private com.baidu.swan.games.loading.a cRf;
    private TextView cRg;
    private ValueAnimator cRh;
    private boolean cRi = false;
    private float cRj = 0.0f;
    private float cRk = 0.0f;
    private float cRl = 0.0f;
    private a cRm = null;
    private String cRo = "";
    private View mRightMenu;
    private ImageView mRightMenuImageView;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static Boolean cRn = null;

    public c(SwanAppActivity swanAppActivity) {
        DecimalFormat.getPercentInstance();
        this.cRc = swanAppActivity;
    }

    public static void cF(final Context context) {
        aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.view.c.1
            @Override // java.lang.Runnable
            public void run() {
                c.cG(context);
            }
        }, 5000L);
    }

    public static void cG(Context context) {
        if (cQT == null) {
            cQT = m(context, false);
        }
        if (cQU == null) {
            cQU = m(context, true);
        }
        if (DEBUG) {
            Log.i("SwanAppLoadingView", "obtainPreloadContainer:  App=" + cQT + " Game=" + cQU);
        }
    }

    public static void avw() {
        cQT = null;
        cQU = null;
    }

    private View l(Context context, boolean z) {
        View view = z ? cQU : cQT;
        if (z) {
            cQU = null;
        } else {
            cQT = null;
        }
        boolean z2 = (view == null || view.isAttachedToWindow()) ? false : true;
        if (z2) {
            cF(context);
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
        String aij = d.apI().apE().apQ().aij();
        boolean z4 = this.cRm == null || (this.cRm.cRr ^ z) || TextUtils.isEmpty(aij) || !TextUtils.equals(aij, this.cRm.cRs);
        if (DEBUG) {
            Log.i("SwanAppLoadingView", "showSwanAppStartView: newLaunchId = " + aij + " newIsGameLoading = " + z + " reCreateStarter = " + z4 + " mViewStarter = " + this.cRm);
        }
        Handler mainHandler = d.getMainHandler();
        if (this.cRm != null) {
            if (DEBUG) {
                Log.i("SwanAppLoadingView", "showSwanAppStartView: oldLaunchId = " + this.cRm.cRs + " oldIsGameLoading = " + this.cRm.cRr);
            }
            mainHandler.removeCallbacks(this.cRm);
        }
        if (z4) {
            this.cRm = new a(aij, z);
        }
        if (this.cRm != null) {
            if (aVar == null || !aVar.getBoolean(" event_params_pkg_update", false)) {
                z3 = false;
            }
            if (this.cRm.cRu) {
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
                this.cRm.avE();
            }
            if (z2) {
                this.cRm.fH(false);
                return;
            }
            if (DEBUG) {
                Log.i("SwanAppLoadingView", "showSwanAppStartView: post starter trace = " + Log.getStackTraceString(new Throwable()));
            }
            mainHandler.post(this.cRm);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(boolean z, boolean z2) {
        synchronized (c.class) {
            if (this.cRb == null) {
                this.cRb = new com.baidu.swan.apps.d.a();
            }
            this.cQV = l(this.cRc, z);
            if (!z) {
                this.cQV.setPadding(0, com.baidu.swan.apps.res.widget.a.SUPPORT_IMMERSION ? ag.getStatusBarHeight() : 0, 0, 0);
            } else {
                avx();
            }
            this.cRg = (TextView) this.cQV.findViewById(a.f.aiapps_loading_progress);
            q(z, z2);
            this.cRc.RI().aq(this.cQV);
            this.cRi = true;
            this.cQW = (TextView) this.cQV.findViewById(a.f.aiapps_title);
            this.bZr = (SwanAppRoundedImageView) this.cQV.findViewById(a.f.aiapps_icon);
            this.bZs = (BdBaseImageView) this.cQV.findViewById(a.f.aiapps_label_bg);
            this.bZt = (TextView) this.cQV.findViewById(a.f.aiapps_label_tv);
            this.cRa = (RelativeLayout) this.cQV.findViewById(a.f.aiapps_icon_rl);
            b.a apQ = d.apI().apE().apQ();
            qe(apQ.acZ());
            qd(apQ.getIconUrl());
            ia(apQ.getType());
            this.cQX = (ImageView) this.cQV.findViewById(a.f.light_print);
            this.cQY = (ImageView) this.cQV.findViewById(a.f.dark_print);
            this.mRightMenuImageView = (ImageView) this.cQV.findViewById(a.f.titlebar_right_menu_img);
            this.cQZ = (ImageView) this.cQV.findViewById(a.f.titlebar_right_menu_exit);
            this.mRightMenu = this.cQV.findViewById(a.f.titlebar_right_menu);
            if (z) {
                this.mRightMenuImageView.setClickable(true);
                this.mRightMenuImageView.setImageResource(a.e.aiapps_action_bar_single_menu_white_selector);
                this.cQZ.setImageResource(a.e.aiapps_action_bar_exit_white_selector);
                this.mRightMenu.setBackgroundResource(a.e.aiapps_action_bar_right_menu_bg_solid);
                this.cRd = this.cQV.findViewById(a.f.titlebar_right_menu_line);
                this.cRd.setBackgroundResource(a.c.aiapps_action_bar_menu_line_white);
            } else {
                this.mRightMenuImageView.setImageResource(a.e.aiapps_action_bar_menu_black_selector);
                this.cQZ.setImageResource(a.e.aiapps_action_bar_exit_black_selector);
                this.mRightMenu.setBackgroundResource(a.e.aiapps_action_bar_right_menu_bg);
            }
            PMSAppInfo aig = apQ.aig();
            int i = aig == null ? PMSConstants.PayProtected.NO_PAY_PROTECTED.type : aig.payProtected;
            if (!z && aj.auY() && i == PMSConstants.PayProtected.PAY_PROTECTED.type) {
                ((RelativeLayout) this.cQV.findViewById(a.f.guarantee_plan_rl)).setVisibility(0);
            }
            this.cQY.setAlpha(0.0f);
            this.cRb.f(this.cRc);
            avz();
        }
    }

    private void avx() {
        this.cRe = (SwanLoadingTipsView) this.cQV.findViewById(a.f.aigames_loading_game_tips);
        this.cRe.setTipsAnimationFinishCallback(new kotlin.jvm.a.a<l>() { // from class: com.baidu.swan.apps.view.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.a.a
            /* renamed from: avD */
            public l invoke() {
                c.this.avy();
                return null;
            }
        });
        this.cRf = new com.baidu.swan.games.loading.a();
        this.cQV.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.swan.apps.view.c.3
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                c.this.avy();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avy() {
        if (this.cRe != null && this.cRf != null) {
            this.cRe.sm(this.cRf.aCa());
        }
    }

    private void avz() {
        this.cQZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.view.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.cRc != null && !c.this.cRc.isFinishing()) {
                    HybridUbcFlow amE = g.amE();
                    if (amE != null) {
                        amE.bF("exitType", String.valueOf(3));
                        amE.amj();
                    }
                    c.this.cRc.moveTaskToBack(true);
                    an.ave().hV(2);
                    c.this.avA();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avA() {
        Bundle ahV;
        b.a RP = this.cRc.RP();
        if (RP != null && (ahV = RP.ahV()) != null) {
            long j = ahV.getLong("page_display_flag_for_statistic");
            ahV.remove("page_display_flag_for_statistic");
            if (j > 0) {
                String valueOf = String.valueOf(System.currentTimeMillis() - RP.getLong("launch_time", 0L));
                f fVar = new f();
                fVar.mType = Config.LAUNCH;
                fVar.mValue = "realcancel";
                fVar.cLm = valueOf;
                fVar.v(TiebaInitialize.LogFields.REASON, "close");
                if (RP.getAppFrameType() == 1) {
                    fVar.v("errorList", com.baidu.swan.games.v.b.aCP().aCQ());
                }
                this.cRc.a(fVar);
                e.a(RP);
            }
        }
    }

    private void ia(int i) {
        ag.a(this.bZs, this.bZt, String.valueOf(i));
    }

    public void ib(final int i) {
        Handler mainHandler = d.getMainHandler();
        if (this.cRm != null) {
            mainHandler.removeCallbacks(this.cRm);
            this.cRm = null;
        }
        mainHandler.post(new Runnable() { // from class: com.baidu.swan.apps.view.c.5
            @Override // java.lang.Runnable
            public void run() {
                synchronized (c.class) {
                    g.amD().f(new UbcFlowEvent("first_anim_end"));
                    com.baidu.swan.apps.al.a.arZ().ow("first_anim_end");
                    if (c.this.cRb != null) {
                        c.this.cRb.a(c.this.cRc, i);
                    }
                    c.this.cRi = false;
                }
            }
        });
    }

    public void UV() {
        if (DEBUG) {
            Log.i("SwanAppLoadingView", "stopAnimations: " + Log.getStackTraceString(new Exception()));
        }
        Handler mainHandler = d.getMainHandler();
        if (this.cRm != null) {
            mainHandler.removeCallbacks(this.cRm);
            this.cRm = null;
        }
        synchronized (c.class) {
            if (this.cRb != null) {
                this.cRb.UV();
            }
            if (this.cRe != null) {
                this.cRe.doDestroy();
                this.cRe = null;
            }
            if (this.cRg != null) {
                this.cRg.setVisibility(8);
                this.cRg = null;
                this.cRo = "";
                this.cRk = 0.0f;
                this.cRj = 0.0f;
                this.cRl = 0.0f;
            }
            if (this.cRh != null) {
                this.cRh.removeAllUpdateListeners();
                this.cRh.cancel();
                this.cRh = null;
            }
            this.cRi = false;
            this.cRm = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(Bitmap bitmap) {
        if (bitmap != null && this.bZr != null) {
            this.bZr.setImageBitmap(bitmap);
        }
    }

    public void H(float f) {
        if (DEBUG) {
            Log.i("SwanAppLoadingView", "onDownloadProgressUpdate: " + f + " view: " + this.cRg);
        }
        if (this.cRg != null) {
            float f2 = f >= 0.0f ? f : 0.0f;
            this.cRj = f2 <= 1.0f ? f2 : 1.0f;
            avB();
        }
    }

    private void p(boolean z, boolean z2) {
        if (z) {
            this.cRo = "";
        } else {
            this.cRo = this.cRg.getContext().getString(z2 ? a.h.swan_loading_view_tag_updating : a.h.swan_loading_view_tag_loading);
        }
    }

    public void q(boolean z, boolean z2) {
        if (this.cRg != null) {
            if (this.cRh != null) {
                this.cRh.cancel();
                this.cRh.removeAllUpdateListeners();
            }
            p(z, z2);
            this.cRk = 0.0f;
            this.cRj = 0.0f;
            this.cRl = 0.0f;
            if (z) {
                avB();
                this.cRh = ValueAnimator.ofFloat(0.0f, 1.0f);
                this.cRh.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.view.c.6
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        if (floatValue > 0.9f || floatValue - c.this.cRk > 0.05d) {
                            c.this.cRk = floatValue;
                            c.this.avB();
                        }
                    }
                });
                this.cRh.setDuration(4000L);
                this.cRh.start();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avB() {
        if (this.cRg != null) {
            float q = q(this.cRk, this.cRj);
            I(q <= 1.0f ? q : 1.0f);
        }
    }

    private void I(float f) {
        if (this.cRg != null && this.cRl <= f) {
            this.cRl = f;
            String format = NumberFormat.getPercentInstance().format(f);
            String trim = this.cRo.trim();
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(trim)) {
                sb.append(trim).append(" ");
            }
            sb.append(format);
            this.cRg.setText(sb);
            if (f > 0.0f) {
                this.cRg.setVisibility(0);
            }
        }
    }

    private float q(float f, float f2) {
        return ((1.0f - f) * f2) + f;
    }

    public void avC() {
        if (this.cRg != null) {
            if (this.cRh != null) {
                this.cRh.removeAllUpdateListeners();
                this.cRh.cancel();
                this.cRh = null;
            }
            I(1.0f);
        }
    }

    public void qd(String str) {
        if (DEBUG) {
            Log.i("SwanAppLoadingView", "updateIcon: icon=" + str);
        }
        final String appId = d.apI().getAppId();
        if (this.cRi) {
            this.bZr.setImageBitmap(aj.a(str, "SwanAppLoadingView", true, new q.a() { // from class: com.baidu.swan.apps.view.c.7
                @Override // com.baidu.swan.apps.aq.q.a
                public void h(String str2, Bitmap bitmap) {
                    SwanAppActivity apG;
                    c RJ;
                    if (bitmap != null && (apG = d.apI().apG()) != null && !apG.isDestroyed() && (RJ = apG.RJ()) != null && TextUtils.equals(appId, d.apI().getAppId())) {
                        RJ.o(bitmap);
                    }
                }
            }));
        }
    }

    public void qe(String str) {
        if (this.cRi && !TextUtils.isEmpty(str)) {
            this.cQW.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a implements Runnable {
        final boolean cRr;
        final String cRs;
        boolean cRt = false;
        boolean cRu = false;

        a(String str, boolean z) {
            this.cRs = str;
            this.cRr = z;
        }

        a avE() {
            this.cRt = true;
            return this;
        }

        @Override // java.lang.Runnable
        public void run() {
            fH(true);
        }

        public void fH(boolean z) {
            if (c.DEBUG) {
                Log.i("SwanAppLoadingView", "ViewStarter exec : post = " + z + " trace = " + (z ? "post" : Log.getStackTraceString(new Exception())));
            }
            this.cRu = true;
            c.this.o(this.cRr, this.cRt);
        }
    }
}
