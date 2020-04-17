package com.baidu.swan.apps.view;

import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.os.Bundle;
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
import com.baidu.swan.apps.as.af;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.as.p;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.res.ui.BdBaseImageView;
import com.baidu.swan.apps.runtime.d;
import com.baidu.swan.apps.statistic.a.f;
import com.baidu.swan.apps.x.b.b;
import com.baidu.swan.games.loading.SwanLoadingTipsView;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.swan.pms.model.PMSAppInfo;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import kotlin.l;
/* loaded from: classes11.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public SwanAppRoundedImageView bLB;
    public BdBaseImageView bLC;
    public TextView bLD;
    public View czk;
    public TextView czl;
    public ImageView czm;
    public ImageView czn;
    private ImageView czo;
    public RelativeLayout czp;
    private com.baidu.swan.apps.d.a czq;
    private SwanAppActivity czr;
    private View czs;
    private SwanLoadingTipsView czt;
    private com.baidu.swan.games.loading.a czu;
    private TextView czv;
    private ValueAnimator czw;
    private View mRightMenu;
    private ImageView mRightMenuImageView;
    private boolean czx = false;
    private float czy = 0.0f;
    private float czz = 0.0f;
    private float czA = 0.0f;

    public c(SwanAppActivity swanAppActivity) {
        DecimalFormat.getPercentInstance();
        this.czr = swanAppActivity;
    }

    public void fh(boolean z) {
        if (this.czq == null) {
            this.czq = new com.baidu.swan.apps.d.a();
        }
        this.czk = LayoutInflater.from(this.czr).inflate(z ? a.g.ai_games_loading_fragment : a.g.aiapps_loading_fragment, (ViewGroup) null);
        if (!z) {
            this.czk.setPadding(0, com.baidu.swan.apps.res.widget.a.SUPPORT_IMMERSION ? af.getStatusBarHeight() : 0, 0, 0);
        } else {
            apK();
        }
        this.czr.Op().aq(this.czk);
        this.czx = true;
        this.czl = (TextView) this.czk.findViewById(a.f.aiapps_title);
        this.bLB = (SwanAppRoundedImageView) this.czk.findViewById(a.f.aiapps_icon);
        this.bLC = (BdBaseImageView) this.czk.findViewById(a.f.aiapps_label_bg);
        this.bLD = (TextView) this.czk.findViewById(a.f.aiapps_label_tv);
        this.czp = (RelativeLayout) this.czk.findViewById(a.f.aiapps_icon_rl);
        b.a akQ = d.akK().akH().akQ();
        op(akQ.YT());
        oo(akQ.getIconUrl());
        hq(akQ.getType());
        this.czm = (ImageView) this.czk.findViewById(a.f.light_print);
        this.czn = (ImageView) this.czk.findViewById(a.f.dark_print);
        this.mRightMenuImageView = (ImageView) this.czk.findViewById(a.f.titlebar_right_menu_img);
        this.czo = (ImageView) this.czk.findViewById(a.f.titlebar_right_menu_exit);
        this.mRightMenu = this.czk.findViewById(a.f.titlebar_right_menu);
        if (z) {
            this.mRightMenuImageView.setClickable(true);
            this.mRightMenuImageView.setImageResource(a.e.aiapps_action_bar_single_menu_white_selector);
            this.czo.setImageResource(a.e.aiapps_action_bar_exit_white_selector);
            this.mRightMenu.setBackgroundResource(a.e.aiapps_action_bar_right_menu_bg_solid);
            this.czs = this.czk.findViewById(a.f.titlebar_right_menu_line);
            this.czs.setBackgroundResource(a.c.aiapps_action_bar_menu_line_white);
        } else {
            this.mRightMenuImageView.setImageResource(a.e.aiapps_action_bar_menu_black_selector);
            this.czo.setImageResource(a.e.aiapps_action_bar_exit_black_selector);
            this.mRightMenu.setBackgroundResource(a.e.aiapps_action_bar_right_menu_bg);
        }
        PMSAppInfo adR = akQ.adR();
        int i = adR == null ? PMSConstants.PayProtected.NO_PAY_PROTECTED.type : adR.payProtected;
        if (!z && ai.apt() && i == PMSConstants.PayProtected.PAY_PROTECTED.type) {
            ((RelativeLayout) this.czk.findViewById(a.f.guarantee_plan_rl)).setVisibility(0);
        }
        this.czn.setAlpha(0.0f);
        this.czq.g(this.czr);
        apM();
    }

    private void apK() {
        this.czv = (TextView) this.czk.findViewById(a.f.aiapps_loading_progress);
        this.czt = (SwanLoadingTipsView) this.czk.findViewById(a.f.aigames_loading_game_tips);
        this.czt.setTipsAnimationFinishCallback(new kotlin.jvm.a.a<l>() { // from class: com.baidu.swan.apps.view.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.a.a
            /* renamed from: apR */
            public l invoke() {
                c.this.apL();
                return null;
            }
        });
        this.czu = new com.baidu.swan.games.loading.a();
        this.czk.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.swan.apps.view.c.2
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                c.this.apL();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
            }
        });
        apO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apL() {
        if (this.czt != null && this.czu != null) {
            this.czt.qB(this.czu.axd());
        }
    }

    private void apM() {
        this.czo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.view.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.czr != null && !c.this.czr.isFinishing()) {
                    c.this.czr.moveTaskToBack(true);
                    c.this.apN();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apN() {
        Bundle adG;
        b.a Ow = this.czr.Ow();
        if (Ow != null && (adG = Ow.adG()) != null) {
            long j = adG.getLong("page_display_flag_for_statistic");
            adG.remove("page_display_flag_for_statistic");
            if (j > 0) {
                String valueOf = String.valueOf(System.currentTimeMillis() - Ow.getLong("launch_time", 0L));
                f fVar = new f();
                fVar.mType = Config.LAUNCH;
                fVar.mValue = "realcancel";
                fVar.cuw = valueOf;
                fVar.s(TiebaInitialize.LogFields.REASON, "close");
                if (Ow.getAppFrameType() == 1) {
                    fVar.s("errorList", com.baidu.swan.games.u.b.axS().axT());
                }
                this.czr.a(fVar);
                com.baidu.swan.apps.statistic.c.a(Ow);
            }
        }
    }

    private void hq(int i) {
        af.a(this.bLC, this.bLD, String.valueOf(i));
    }

    public void hr(int i) {
        com.baidu.swan.apps.performance.f.aid().f(new UbcFlowEvent("first_anim_end"));
        com.baidu.swan.apps.an.a.amP().mO("first_anim_end");
        this.czq.a(this.czr, i);
        this.czx = false;
    }

    public void Rq() {
        this.czq.Rq();
        if (this.czt != null) {
            this.czt.doDestroy();
            this.czt = null;
        }
        if (this.czv != null) {
            this.czv.setVisibility(8);
            this.czv = null;
        }
        if (this.czw != null) {
            this.czw.removeAllUpdateListeners();
            this.czw.cancel();
            this.czw = null;
        }
        this.czx = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(Bitmap bitmap) {
        if (bitmap != null && this.bLB != null) {
            this.bLB.setImageBitmap(bitmap);
        }
    }

    public void G(float f) {
        if (DEBUG) {
            Log.i("SwanAppLoadingView", "onDownloadProgressUpdate: " + f);
        }
        if (this.czv != null) {
            float f2 = f >= 0.0f ? f : 0.0f;
            this.czy = f2 <= 1.0f ? f2 : 1.0f;
            apP();
        }
    }

    public void apO() {
        if (this.czv != null) {
            if (this.czw != null) {
                this.czw.cancel();
                this.czw.removeAllUpdateListeners();
            }
            this.czz = 0.0f;
            this.czy = 0.0f;
            this.czA = 0.0f;
            apP();
            this.czw = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.czw.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.view.c.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (floatValue > 0.9f || floatValue - c.this.czz > 0.05d) {
                        c.this.czz = floatValue;
                        c.this.apP();
                    }
                }
            });
            this.czw.setDuration(4000L);
            this.czw.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apP() {
        if (this.czv != null) {
            float q = q(this.czz, this.czy);
            if (q >= 1.0f) {
                q = 0.99f;
            }
            H(q);
        }
    }

    private void H(float f) {
        if (this.czv != null && this.czA <= f) {
            this.czA = f;
            this.czv.setText(NumberFormat.getPercentInstance().format(f));
            this.czv.setVisibility(0);
        }
    }

    private float q(float f, float f2) {
        float f3 = f * f;
        return f3 + ((1.0f - f3) * f2 * 0.5f);
    }

    public void apQ() {
        if (this.czv != null) {
            if (this.czw != null) {
                this.czw.removeAllUpdateListeners();
                this.czw.cancel();
                this.czw = null;
            }
            H(1.0f);
        }
    }

    public void oo(String str) {
        if (DEBUG) {
            Log.i("SwanAppLoadingView", "updateIcon: icon=" + str);
        }
        final String appId = d.akK().getAppId();
        if (this.czx) {
            this.bLB.setImageBitmap(ai.a(str, "SwanAppLoadingView", true, new p.a() { // from class: com.baidu.swan.apps.view.c.5
                @Override // com.baidu.swan.apps.as.p.a
                public void h(String str2, Bitmap bitmap) {
                    SwanAppActivity akJ;
                    c Oq;
                    if (bitmap != null && (akJ = d.akK().akJ()) != null && !akJ.isDestroyed() && (Oq = akJ.Oq()) != null && TextUtils.equals(appId, d.akK().getAppId())) {
                        Oq.n(bitmap);
                    }
                }
            }));
        }
    }

    public void op(String str) {
        if (this.czx && !TextUtils.isEmpty(str)) {
            this.czl.setText(str);
        }
    }
}
